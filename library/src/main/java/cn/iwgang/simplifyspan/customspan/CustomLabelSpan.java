package cn.iwgang.simplifyspan.customspan;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.media.ThumbnailUtils;
import android.text.style.ReplacementSpan;

import cn.iwgang.simplifyspan.other.OnClickStateChangeListener;
import cn.iwgang.simplifyspan.other.SpecialGravity;
import cn.iwgang.simplifyspan.unit.SpecialLabelUnit;

/**
 * Custom Label Span
 * Created by iWgang on 15/12/3.
 * https://github.com/iwgang/SimplifySpan
 */
public class CustomLabelSpan extends ReplacementSpan implements OnClickStateChangeListener {
    private SpecialLabelUnit mSpecialLabelUnit;
    private String mSpecialText;
    private float mFinalWidth, mFinalHeight;
    private int mSpecialTextHeight = 0;
    private float mSpecialTextWidth = 0;
    private int mLineTextHeight = 0;
    private int mLineTextBaselineOffset = 0;
    private int mSpecialTextBaselineOffset = 0;
    private float mLabelBgRadius;
    private Bitmap mBitmap;
    private String mNormalSizeText;

    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int mPaddingLeft = 0;
    private int mPaddingRight = 0;
    private boolean isLabelBgCenter = true;
    private boolean isDrawBitmap = false;
    private RectF bgRect;
    private boolean isInit = true;

    private int mBgColor;
    private boolean isSelected;
    private boolean isClickable;
    private int pressBgColor;

    public CustomLabelSpan(String normalSizeText, SpecialLabelUnit specialLabelUnit) {
        mSpecialLabelUnit = specialLabelUnit;
        mSpecialText = mSpecialLabelUnit.getText();
        mNormalSizeText = normalSizeText;
        isClickable = mSpecialLabelUnit.isClickable();
        mBgColor = mSpecialLabelUnit.getBgColor();

        mBitmap = mSpecialLabelUnit.getBitmap();
        if (null == mBitmap) {
            mLabelBgRadius = mSpecialLabelUnit.getLabelBgRadius();
            if (mLabelBgRadius > 0) {
                bgRect = new RectF();
            }
        } else {
            isDrawBitmap = true;
        }
        initPadding();
    }

    private void initPadding() {
        if (mSpecialLabelUnit.getLabelBgHeight() > 0 || mSpecialLabelUnit.getLabelBgWidth() > 0)
            return;

        int allPadding = mSpecialLabelUnit.getPadding();

        mPaddingTop = allPadding;
        mPaddingBottom = allPadding;

        int paddingLeft = mSpecialLabelUnit.getPaddingLeft();
        if (paddingLeft > 0) {
            mPaddingLeft = paddingLeft;
        } else {
            mPaddingLeft = allPadding;
        }

        int paddingRight = mSpecialLabelUnit.getPaddingRight();
        if (paddingRight > 0) {
            mPaddingRight = paddingRight;
        } else {
            mPaddingRight = allPadding;
        }

        if (mPaddingTop > 0 || mPaddingBottom > 0 || mPaddingLeft > 0 || mPaddingRight > 0)
            isLabelBgCenter = false;
    }

    @Override
    public void onStateChange(boolean isSelected, int pressBgColor) {
        this.isSelected = isSelected;
        this.pressBgColor = pressBgColor;
    }

    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        if (isInit) {
            isInit = false;
            initFinalHeight(paint);
            initFinalWidth(paint);

            // Re Create Bitmap
            if (isDrawBitmap) {
                Bitmap newBitmap = ThumbnailUtils.extractThumbnail(mBitmap, Math.round(mFinalWidth), Math.round(mFinalHeight));
                if (null != newBitmap) {
                    mBitmap.recycle();
                    mBitmap = newBitmap;
                }
            }
        }

        return Math.round(mFinalWidth);
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        float finalUnitHeight = bottom - top;
        float bgTop = bottom - finalUnitHeight;
        if (isClickable && isSelected && pressBgColor != 0) {
            // click background
            paint.setColor(pressBgColor);
            canvas.drawRect(x, bgTop, x + mFinalWidth, bgTop + finalUnitHeight, paint);
        } else {
            // normal background
            if (mBgColor != 0) {
                paint.setColor(mBgColor);
                canvas.drawRect(x, bgTop, x + mFinalWidth, bgTop + finalUnitHeight, paint);
            }
        }

        float labelTextSize = mSpecialLabelUnit.getLabelTextSize();
        if (labelTextSize > 0 && labelTextSize != paint.getTextSize()) {
            paint.setTextSize(labelTextSize);
        }

        float newStartY = y;
        int newTextY = y;

        switch (mSpecialLabelUnit.getGravity()) {
            case SpecialGravity.TOP:
                newStartY -= (mLineTextHeight - mLineTextBaselineOffset);
                newTextY -= (mLineTextHeight - mSpecialTextHeight - (mLineTextBaselineOffset - mSpecialTextBaselineOffset) - mPaddingTop);
                break;
            case SpecialGravity.CENTER:
                newStartY -= (mLineTextHeight / 2 + mFinalHeight / 2 - mLineTextBaselineOffset);
                newTextY -= (mLineTextHeight / 2 - mSpecialTextHeight / 2 - (mLineTextBaselineOffset - mSpecialTextBaselineOffset));
                break;
            case SpecialGravity.BOTTOM:
                newStartY -= mFinalHeight - mLineTextBaselineOffset;
                newTextY -= mPaddingBottom - (mLineTextBaselineOffset - mSpecialTextBaselineOffset);
                break;
        }

        if (isDrawBitmap) {
            canvas.drawBitmap(mBitmap, x, newStartY, paint);
        } else {
            paint.setColor(mSpecialLabelUnit.getLabelBgColor());
            if (mLabelBgRadius > 0) {
                bgRect.top = newStartY;
                bgRect.bottom = newStartY + mFinalHeight;
                bgRect.left = x;
                bgRect.right = x + mFinalWidth;
                if (mSpecialLabelUnit.isShowBorder()) {
                    float borderSize = mSpecialLabelUnit.getBorderSize();
                    // draw background
                    canvas.drawRect(x, newStartY, x + mFinalWidth, newStartY + mFinalHeight, paint);

                    // draw border
                    paint.setColor(mSpecialLabelUnit.getLabelBgBorderColor());
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(borderSize);
                    canvas.drawRoundRect(bgRect, mLabelBgRadius, mLabelBgRadius, paint);

                    // recover paint
                    paint.setStyle(Paint.Style.FILL);
                } else {
                    // draw background
                    canvas.drawRoundRect(bgRect, mLabelBgRadius, mLabelBgRadius, paint);
                }
            } else {
                // draw background
                canvas.drawRect(x, newStartY, x + mFinalWidth, newStartY + mFinalHeight, paint);

                if (mSpecialLabelUnit.isShowBorder()) {
                    // draw border
                    paint.setColor(mSpecialLabelUnit.getLabelBgBorderColor());
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(mSpecialLabelUnit.getBorderSize());
                    canvas.drawRect(x, newStartY, x + mFinalWidth, newStartY + mFinalHeight, paint);

                    // recover paint
                    paint.setStyle(Paint.Style.FILL);
                }
            }
        }

        paint.setColor(mSpecialLabelUnit.getLabelTextColor());
        float newTextX;
        if (isLabelBgCenter) {
            newTextX = x + Math.round(mFinalWidth / 2f - mSpecialTextWidth / 2f);
        } else {
            newTextX = x + mPaddingLeft;
        }

        if (mSpecialLabelUnit.isTextBold())
            paint.setFakeBoldText(true);

        if (mSpecialLabelUnit.isTextItalic())
            paint.setTypeface(Typeface.create((String) null, Typeface.ITALIC));
        paint.setStrikeThruText(mSpecialLabelUnit.isShowStrikeThrough());
        canvas.drawText(mSpecialText, newTextX, newTextY, paint);
    }

    private float initFinalWidth(Paint paint) {
        if (mFinalWidth <= 0) {
            float labelTextSize = mSpecialLabelUnit.getLabelTextSize();
            if (labelTextSize > 0 && labelTextSize != paint.getTextSize()) {
                paint.setTextSize(labelTextSize);
            }

            int labelBgWidth = mSpecialLabelUnit.getLabelBgWidth();
            mSpecialTextWidth = paint.measureText(mSpecialText, 0, mSpecialText.length());
            if (labelBgWidth > 0 && labelBgWidth > mSpecialTextWidth) {
                mFinalWidth = labelBgWidth;
            } else {
                mFinalWidth = mSpecialTextWidth + mPaddingLeft + mPaddingRight;
            }
        }

        return mFinalWidth;
    }

    private float initFinalHeight(Paint paint) {
        if (mFinalHeight <= 0) {
            int labelBgHeight = mSpecialLabelUnit.getLabelBgHeight();

            Rect specialTextRect = new Rect();
            paint.getTextBounds(mNormalSizeText, 0, mNormalSizeText.length(), specialTextRect);
            mLineTextHeight = specialTextRect.height();
            mLineTextBaselineOffset = specialTextRect.bottom;

            float labelTextSize = mSpecialLabelUnit.getLabelTextSize();
            if (labelTextSize > 0 && labelTextSize != paint.getTextSize()) {
                paint.setTextSize(labelTextSize);
            }

            paint.getTextBounds(mSpecialText, 0, mSpecialText.length(), specialTextRect);
            mSpecialTextHeight = specialTextRect.height();
            mSpecialTextBaselineOffset = specialTextRect.bottom;

            if (labelBgHeight > 0 && labelBgHeight > mSpecialTextHeight && labelBgHeight <= mLineTextHeight) {
                mFinalHeight = labelBgHeight;
            } else {
                mFinalHeight = mSpecialTextHeight + mPaddingTop + mPaddingBottom;
            }

            if (mFinalHeight > mLineTextHeight) {
                mFinalHeight = mLineTextHeight;
            }
        }

        return mFinalHeight;
    }

}