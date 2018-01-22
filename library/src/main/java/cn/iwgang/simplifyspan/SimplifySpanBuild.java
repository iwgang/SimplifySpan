package cn.iwgang.simplifyspan;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.media.ThumbnailUtils;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.iwgang.simplifyspan.customspan.CustomAbsoluteSizeSpan;
import cn.iwgang.simplifyspan.customspan.CustomClickableSpan;
import cn.iwgang.simplifyspan.customspan.CustomImageSpan;
import cn.iwgang.simplifyspan.customspan.CustomLabelSpan;
import cn.iwgang.simplifyspan.other.CustomLinkMovementMethod;
import cn.iwgang.simplifyspan.other.OnClickStateChangeListener;
import cn.iwgang.simplifyspan.other.SpecialConvertMode;
import cn.iwgang.simplifyspan.other.SpecialGravity;
import cn.iwgang.simplifyspan.unit.BaseSpecialUnit;
import cn.iwgang.simplifyspan.unit.SpecialClickableUnit;
import cn.iwgang.simplifyspan.unit.SpecialImageUnit;
import cn.iwgang.simplifyspan.unit.SpecialLabelUnit;
import cn.iwgang.simplifyspan.unit.SpecialRawSpanUnit;
import cn.iwgang.simplifyspan.unit.SpecialTextUnit;

/**
 * SimplifySpan Build
 * Created by iWgang on 15/12/2.
 * https://github.com/iwgang/SimplifySpan
 */
public class SimplifySpanBuild {
    private List<BaseSpecialUnit> mFinalSpecialUnit;
    private List<BaseSpecialUnit> mBeforeSpecialUnit;
    private StringBuilder mStringBuilder;
    private StringBuilder mBeforeStringBuilder;
    private Map<SpecialClickableUnit, PositionInfo> mBeforeCacheSpecialClickableUnitMap = new HashMap<>();
    private Map<SpecialClickableUnit, PositionInfo> mCacheSpecialClickableUnitMap = new HashMap<>();

    private StringBuilder mNormalSizeText;

    public SimplifySpanBuild() {
        this(null);
    }

    public SimplifySpanBuild(String initializeNormalText) {
        init(initializeNormalText);
    }

    public SimplifySpanBuild(String initializeNormalText, BaseSpecialUnit... normalSpecialUnits) {
        init(initializeNormalText, normalSpecialUnits);
    }

    private void init(String initializeNormalText, BaseSpecialUnit... normalSpecialUnits) {
        mStringBuilder = new StringBuilder(TextUtils.isEmpty(initializeNormalText) ? "" : initializeNormalText);
        mBeforeStringBuilder = new StringBuilder("");
        mNormalSizeText = new StringBuilder("");
        mFinalSpecialUnit = new ArrayList<>();
        mBeforeSpecialUnit = new ArrayList<>();

        if (!TextUtils.isEmpty(initializeNormalText)) {
            if (null != normalSpecialUnits && normalSpecialUnits.length > 0) {
                buildNormalSpecialUnits(false, 0, initializeNormalText, normalSpecialUnits);
            } else {
                mNormalSizeText.append(initializeNormalText);
            }
        }
    }

    private void buildNormalSpecialUnits(boolean isAddToBeforeSpecialUnit, int initStartPos, String finalText, BaseSpecialUnit... normalSpecialUnits) {
        Map<String, Boolean> delTextTagMap = new HashMap<>();
        List<Integer> otherSpecialTextStartPos;
        for (BaseSpecialUnit st : normalSpecialUnits) {
            String specialText = st.getText();

            if (TextUtils.isEmpty(specialText) || !finalText.contains(specialText)) continue;

            int specialTextLength = specialText.length();
            switch (st.getConvertMode()) {
                case SpecialConvertMode.ONLY_FIRST:
                    st.setStartPoss(new int[]{initStartPos + finalText.indexOf(specialText)});
                    break;
                case SpecialConvertMode.ONLY_LAST:
                    st.setStartPoss(new int[]{initStartPos + finalText.lastIndexOf(specialText)});
                    break;
                case SpecialConvertMode.ALL:
                    int firstSpecialTextStartPos = finalText.indexOf(specialText);
                    otherSpecialTextStartPos = new ArrayList<>();
                    otherSpecialTextStartPos.add(firstSpecialTextStartPos);
                    int previousSpecialTextStartPos = firstSpecialTextStartPos + specialTextLength;
                    boolean hasNext = true;
                    while (hasNext) {
                        int nextSpecialTextStartPos = finalText.indexOf(specialText, previousSpecialTextStartPos);
                        if (nextSpecialTextStartPos != -1) {
                            otherSpecialTextStartPos.add(nextSpecialTextStartPos);
                            previousSpecialTextStartPos = nextSpecialTextStartPos + specialTextLength;
                        } else {
                            hasNext = false;
                        }
                    }

                    int[] startPos = new int[otherSpecialTextStartPos.size()];
                    for (int i = 0; i < otherSpecialTextStartPos.size(); i++) {
                        startPos[i] = initStartPos + otherSpecialTextStartPos.get(i);
                    }
                    st.setStartPoss(startPos);
                    break;
            }

            int[] startPossTemp = st.getStartPoss();
            if (null == startPossTemp || startPossTemp.length == 0) continue;

            // excluding content
            if (st instanceof SpecialTextUnit) {
                SpecialTextUnit specialTextUnit = (SpecialTextUnit) st;

                if (specialTextUnit.getTextSize() > 0) {
                    if (startPossTemp.length > 1) {
                        delTextTagMap.put(specialText, true);
                    } else {
                        delTextTagMap.put(specialText, false);
                    }
                }
            } else if (st instanceof SpecialImageUnit || st instanceof SpecialLabelUnit) {
                if (startPossTemp.length > 1) {
                    delTextTagMap.put(specialText, true);
                } else {
                    delTextTagMap.put(specialText, false);
                }
            }
        }

        if (!delTextTagMap.isEmpty()) {
            for (Map.Entry<String, Boolean> pm : delTextTagMap.entrySet()) {
                if (pm.getValue()) {
                    // delete all
                    finalText = finalText.replaceAll(pm.getKey(), "");
                } else {
                    // del first
                    finalText = finalText.replace(pm.getKey(), "");
                }
            }
        }


        if (isAddToBeforeSpecialUnit) {
            mNormalSizeText.insert(0, finalText);
            mBeforeSpecialUnit.addAll(Arrays.asList(normalSpecialUnits));
        } else {
            mNormalSizeText.append(finalText);
            mFinalSpecialUnit.addAll(Arrays.asList(normalSpecialUnits));
        }
    }

    /**
     * append SpecialUnit
     *
     * @param specialUnit SpecialUnit (Not support convertMode)
     * @return SimplifySpanBuild
     */
    public SimplifySpanBuild append(BaseSpecialUnit specialUnit) {
        if (null == specialUnit) return this;

        String specialText = specialUnit.getText();
        if (TextUtils.isEmpty(specialText)) return this;

        // process start pos
        specialUnit.setStartPoss(new int[]{mStringBuilder.length()});
        mStringBuilder.append(specialText);
        mFinalSpecialUnit.add(specialUnit);
        return this;
    }

    /**
     * append normal text
     *
     * @param text normal text
     * @return SimplifySpanBuild
     */
    public SimplifySpanBuild append(String text) {
        if (TextUtils.isEmpty(text)) return this;

        mNormalSizeText.append(text);
        mStringBuilder.append(text);
        return this;
    }

    /**
     * append SpecialUnit to first (Behind the existing BeforeContent)
     *
     * @param specialUnit (Not support convertMode)
     * @return SimplifySpanBuild
     */
    public SimplifySpanBuild appendToFirst(BaseSpecialUnit specialUnit) {
        if (null == specialUnit) return this;

        String specialText = specialUnit.getText();
        if (TextUtils.isEmpty(specialText)) return this;

        // process start pos
        int curBeforeFirstPos = mBeforeStringBuilder.length();
        specialUnit.setStartPoss(new int[]{curBeforeFirstPos});
        mBeforeStringBuilder.insert(curBeforeFirstPos, specialText);
        mBeforeSpecialUnit.add(specialUnit);
        return this;
    }

    /**
     * append normal text to first (Behind the existing BeforeContent)
     *
     * @param text normal text
     * @return SimplifySpanBuild
     */
    public SimplifySpanBuild appendToFirst(String text) {
        if (TextUtils.isEmpty(text)) return this;

        mNormalSizeText.append(text);
        mBeforeStringBuilder.append(text);
        return this;
    }

    /**
     * append multi clickable SpecialUnit or String
     *
     * @param specialClickableUnit SpecialClickableUnit
     * @param specialUnitOrStrings Unit Or String
     * @return
     */
    public SimplifySpanBuild appendMultiClickable(SpecialClickableUnit specialClickableUnit, Object... specialUnitOrStrings) {
        processMultiClickableSpecialUnit(false, specialClickableUnit, specialUnitOrStrings);
        return this;
    }

    /**
     * append multi clickable SpecialUnit or String to first (Behind the existing BeforeContent)
     *
     * @param specialClickableUnit SpecialClickableUnit
     * @param specialUnitOrStrings Unit Or String
     * @return
     */
    public SimplifySpanBuild appendMultiClickableToFirst(SpecialClickableUnit specialClickableUnit, Object... specialUnitOrStrings) {
        processMultiClickableSpecialUnit(true, specialClickableUnit, specialUnitOrStrings);
        return this;
    }

    /**
     * Build
     *
     * @return SpannableStringBuilder
     */
    public SpannableStringBuilder build() {
        if (mBeforeStringBuilder.length() > 0) {
            mStringBuilder.insert(0, mBeforeStringBuilder);

            // reset SpecialUnit start pos
            if (!mFinalSpecialUnit.isEmpty()) {
                for (BaseSpecialUnit specialUnit : mFinalSpecialUnit) {
                    int[] tempStartPoss = specialUnit.getStartPoss();

                    if (null == tempStartPoss || tempStartPoss.length == 0) continue;

                    for (int i = 0; i < tempStartPoss.length; i++) {
                        int oldStartPos = tempStartPoss[i];
                        tempStartPoss[i] = oldStartPos + mBeforeStringBuilder.length();
                    }
                }
            }

            // reset Cache SpecialClickableUnit start pos
            if (!mCacheSpecialClickableUnitMap.isEmpty()) {
                for (Map.Entry<SpecialClickableUnit, PositionInfo> cm : mCacheSpecialClickableUnitMap.entrySet()) {
                    cm.getValue().startPos += mBeforeStringBuilder.length();
                }
            }
        }

        if (!mBeforeCacheSpecialClickableUnitMap.isEmpty()) {
            mCacheSpecialClickableUnitMap.putAll(mBeforeCacheSpecialClickableUnitMap);
        }

        if (!mBeforeSpecialUnit.isEmpty()) {
            mFinalSpecialUnit.addAll(mBeforeSpecialUnit);
        }

        if (mStringBuilder.length() == 0) return null;
        if (mFinalSpecialUnit.isEmpty())
            return new SpannableStringBuilder(mStringBuilder.toString());

        if (mNormalSizeText.length() == 0) mNormalSizeText.append(mStringBuilder);

        String normalSizeText = mNormalSizeText.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(mStringBuilder);
        boolean isInitClickListener = false;
        for (BaseSpecialUnit st : mFinalSpecialUnit) {
            String specialText = st.getText();
            int[] startPoss = st.getStartPoss();

            if (TextUtils.isEmpty(specialText) || null == startPoss || startPoss.length == 0)
                continue;

            int specialTextLength = specialText.length();
            if (st instanceof SpecialTextUnit) {
                // text span
                SpecialTextUnit specialTextUnit = (SpecialTextUnit) st;

                final SpecialClickableUnit internalSpecialClickableUnit = specialTextUnit.getSpecialClickableUnit();
                if (null != internalSpecialClickableUnit) {
                    if (internalSpecialClickableUnit.getNormalTextColor() == 0) {
                        internalSpecialClickableUnit.setNormalTextColor(specialTextUnit.getTextColor());
                    }
                    if (internalSpecialClickableUnit.getNormalBgColor() == 0) {
                        internalSpecialClickableUnit.setNormalBgColor(specialTextUnit.getTextBackgroundColor());
                    }
                }
                for (int startPos : startPoss) {
                    // Set Text Color
                    if (specialTextUnit.getTextColor() != 0) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(specialTextUnit.getTextColor()), startPos, startPos + specialTextLength, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }

                    // Set Text Background Color
                    if (specialTextUnit.getTextBackgroundColor() != 0 && null == internalSpecialClickableUnit) {
                        spannableStringBuilder.setSpan(new BackgroundColorSpan(specialTextUnit.getTextBackgroundColor()), startPos, startPos + specialTextLength, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }

                    // Add Underline
                    if (specialTextUnit.isShowUnderline()) {
                        spannableStringBuilder.setSpan(new UnderlineSpan(), startPos, startPos + specialTextLength, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }

                    // Add StrikeThrough
                    if (specialTextUnit.isShowStrikeThrough()) {
                        spannableStringBuilder.setSpan(new StrikethroughSpan(), startPos, startPos + specialTextLength, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }

                    // Set Text Bold
                    if (specialTextUnit.isTextBold()) {
                        spannableStringBuilder.setSpan(new StyleSpan(Typeface.BOLD), startPos, startPos + specialTextLength, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }

                    // Set Text Italic
                    if (specialTextUnit.isTextItalic()) {
                        spannableStringBuilder.setSpan(new StyleSpan(Typeface.ITALIC), startPos, startPos + specialTextLength, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }

                    // Set Text Style
                    if (specialTextUnit.getTextStyle() != Typeface.NORMAL) {
                        spannableStringBuilder.setSpan(new StyleSpan(specialTextUnit.getTextStyle()), startPos, startPos + specialTextLength, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }

                    // Set Text Size
                    if (specialTextUnit.getTextSize() > 0) {
                        TextView curTextView = specialTextUnit.getCurTextView();
                        int gravity = specialTextUnit.getGravity();
                        if (gravity != SpecialGravity.BOTTOM && null != curTextView) {
                            spannableStringBuilder.setSpan(new CustomAbsoluteSizeSpan(normalSizeText, specialTextUnit.getText(), Math.round(specialTextUnit.getTextSize()), curTextView, gravity), startPos, startPos + specialTextLength, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        } else {
                            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(Math.round(specialTextUnit.getTextSize()), true), startPos, startPos + specialTextLength, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        }
                    }

                    // set clickable
                    if (null != internalSpecialClickableUnit) {
                        if (!isInitClickListener) {
                            isInitClickListener = true;
                            TextView curTextView = internalSpecialClickableUnit.getCurTextView();
                            if (null != curTextView) {
                                curTextView.setMovementMethod(CustomLinkMovementMethod.getInstance());
                            }
                        }
                        spannableStringBuilder.setSpan(new CustomClickableSpan(internalSpecialClickableUnit), startPos, startPos + specialTextLength, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }
                }
            } else if (st instanceof SpecialImageUnit) {
                // image Span
                SpecialImageUnit specialImageUnit = (SpecialImageUnit) st;
                Bitmap bitmap = specialImageUnit.getBitmap();
                int imgWidth = specialImageUnit.getWidth();
                int imgHeight = specialImageUnit.getHeight();
                if (imgWidth > 0 && imgHeight > 0) {
                    int bitWidth = bitmap.getWidth();
                    int bitHeight = bitmap.getHeight();

                    if (imgWidth < bitWidth && imgHeight < bitHeight) {
                        Bitmap newBitmap = ThumbnailUtils.extractThumbnail(bitmap, imgWidth, imgHeight);
                        if (null != newBitmap) {
                            bitmap.recycle();
                            specialImageUnit.setBitmap(newBitmap);
                        }
                    }
                }

                for (int startPos : startPoss) {
                    CustomImageSpan curCustomImageSpan = new CustomImageSpan(normalSizeText, specialImageUnit);
                    spannableStringBuilder.setSpan(curCustomImageSpan, startPos, startPos + specialTextLength, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                    if (specialImageUnit.isClickable()) {
                        addClickStateChangeListeners(startPos, startPos + specialTextLength, curCustomImageSpan);
                    }
                }
            } else if (st instanceof SpecialLabelUnit) {
                // label span
                SpecialLabelUnit specialLabelUnit = (SpecialLabelUnit) st;
                for (int startPos : startPoss) {
                    CustomLabelSpan curCustomLabelSpan = new CustomLabelSpan(normalSizeText, specialLabelUnit);
                    spannableStringBuilder.setSpan(curCustomLabelSpan, startPos, startPos + specialTextLength, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                    if (specialLabelUnit.isClickable()) {
                        addClickStateChangeListeners(startPos, startPos + specialTextLength, curCustomLabelSpan);
                    }
                }
            } else if (st instanceof SpecialClickableUnit) {
                // clickable span
                SpecialClickableUnit specialClickableUnit = (SpecialClickableUnit) st;

                if (!isInitClickListener) {
                    isInitClickListener = true;
                    TextView curTextView = specialClickableUnit.getCurTextView();
                    if (null != curTextView) {
                        curTextView.setMovementMethod(CustomLinkMovementMethod.getInstance());
                    }
                }

                int startPos = startPoss[0];
                spannableStringBuilder.setSpan(new CustomClickableSpan(specialClickableUnit), startPos, startPos + specialTextLength, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            } else if (st instanceof SpecialRawSpanUnit) {
                // raw span
                SpecialRawSpanUnit specialRawSpanUnit = (SpecialRawSpanUnit) st;

                int startPos = startPoss[0];
                spannableStringBuilder.setSpan(specialRawSpanUnit.getSpanObj(), startPos, startPos + specialTextLength, specialRawSpanUnit.getFlags());

                // Temporarily unable to support all
            }
        }

        return spannableStringBuilder;
    }

    private void processMultiClickableSpecialUnit(boolean isToFirst, SpecialClickableUnit specialClickableUnit, Object... specialUnitOrStrings) {
        if (null == specialClickableUnit || null == specialUnitOrStrings || specialUnitOrStrings.length == 0)
            return;

        StringBuilder tempStrBuild = new StringBuilder();
        int baseStartPos;
        if (isToFirst) {
            baseStartPos = mBeforeStringBuilder.length();
        } else {
            baseStartPos = mStringBuilder.length();
        }
        for (Object su : specialUnitOrStrings) {
            if (su instanceof SpecialTextUnit) {
                SpecialTextUnit specialTextUnit = (SpecialTextUnit) su;

                String specialText = specialTextUnit.getText();
                if (TextUtils.isEmpty(specialText)) continue;

                specialTextUnit.setClickableUnit(null);

                // process start pos
                specialTextUnit.setStartPoss(new int[]{baseStartPos + tempStrBuild.length()});
                if (isToFirst) {
                    mBeforeSpecialUnit.add(specialTextUnit);
                } else {
                    mFinalSpecialUnit.add(specialTextUnit);
                }
                tempStrBuild.append(specialText);
            } else if (su instanceof SpecialImageUnit) {
                SpecialImageUnit specialImageUnit = (SpecialImageUnit) su;

                String specialText = specialImageUnit.getText();
                if (TextUtils.isEmpty(specialText)) continue;

                specialImageUnit.setClickable(true);
                if (specialImageUnit.getBgColor() == 0 && specialClickableUnit.getNormalBgColor() != 0) {
                    specialImageUnit.setBgColor(specialClickableUnit.getNormalBgColor());
                }

                // process start pos
                specialImageUnit.setStartPoss(new int[]{baseStartPos + tempStrBuild.length()});
                if (isToFirst) {
                    mBeforeSpecialUnit.add(specialImageUnit);
                } else {
                    mFinalSpecialUnit.add(specialImageUnit);
                }
                tempStrBuild.append(specialText);
            } else if (su instanceof SpecialLabelUnit) {
                SpecialLabelUnit specialLabelUnit = (SpecialLabelUnit) su;

                String specialText = specialLabelUnit.getText();
                if (TextUtils.isEmpty(specialText)) continue;

                specialLabelUnit.setClickable(true);
                if (specialLabelUnit.getBgColor() == 0 && specialClickableUnit.getNormalBgColor() != 0) {
                    specialLabelUnit.setBgColor(specialClickableUnit.getNormalBgColor());
                }

                // process start pos
                specialLabelUnit.setStartPoss(new int[]{baseStartPos + tempStrBuild.length()});
                if (isToFirst) {
                    mBeforeSpecialUnit.add(specialLabelUnit);
                } else {
                    mFinalSpecialUnit.add(specialLabelUnit);
                }
                tempStrBuild.append(specialText);
            } else if (su instanceof String) {
                tempStrBuild.append(su.toString());
            }
        }

        String finalStr = tempStrBuild.toString();
        specialClickableUnit.setText(finalStr);
        specialClickableUnit.setStartPoss(new int[]{baseStartPos});
        PositionInfo positionInfo = new PositionInfo(baseStartPos, finalStr.length());
        if (isToFirst) {
            mBeforeStringBuilder.insert(baseStartPos, finalStr);
            mBeforeSpecialUnit.add(specialClickableUnit);
            mBeforeCacheSpecialClickableUnitMap.put(specialClickableUnit, positionInfo);
        } else {
            mStringBuilder.append(finalStr);
            mFinalSpecialUnit.add(specialClickableUnit);
            mCacheSpecialClickableUnitMap.put(specialClickableUnit, positionInfo);
        }
    }

    private void addClickStateChangeListeners(int startPos, int endPos, OnClickStateChangeListener onClickStateChangeListener) {
        if (mCacheSpecialClickableUnitMap.isEmpty()) return;

        for (Map.Entry<SpecialClickableUnit, PositionInfo> cm : mCacheSpecialClickableUnitMap.entrySet()) {
            PositionInfo curPositionInfo = cm.getValue();
            int curStartPos = curPositionInfo.startPos;
            int curEndPos = curStartPos + curPositionInfo.textLength;
            if (startPos >= curStartPos && endPos <= curEndPos) {
                SpecialClickableUnit curCacheSpecialClickableUnit = cm.getKey();
                List<OnClickStateChangeListener> onClickStateChangeListeners = curCacheSpecialClickableUnit.getOnClickStateChangeListeners();
                if (null == onClickStateChangeListeners) {
                    onClickStateChangeListeners = new ArrayList<>();
                    curCacheSpecialClickableUnit.setOnClickStateChangeListeners(onClickStateChangeListeners);
                }
                onClickStateChangeListeners.add(onClickStateChangeListener);
                break;
            }
        }
    }

    static class PositionInfo {
        int startPos;
        int textLength;

        public PositionInfo(int startPos, int textLength) {
            this.startPos = startPos;
            this.textLength = textLength;
        }
    }

}
