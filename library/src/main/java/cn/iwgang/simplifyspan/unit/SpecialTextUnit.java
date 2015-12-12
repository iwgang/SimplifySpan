package cn.iwgang.simplifyspan.unit;

import cn.iwgang.simplifyspan.other.OnClickableSpanListener;
import cn.iwgang.simplifyspan.other.SpecialConvertModeEnum;
import cn.iwgang.simplifyspan.other.SpecialGravityEnum;

/**
 * Text Special Unit
 * Created by iWgang on 15/12/3.
 * https://github.com/iwgang/SimplifySpan
 */
public class SpecialTextUnit extends BaseSpecialUnit {
    private int specialTextColor;
    private int specialTextBackgroundColor;
    private float textSize; // sp
    private boolean isShowUnderline;
    private boolean isShowStrikeThrough;
    private boolean isTextBold;
    private boolean isShowClickableSpanUnderline;
    private OnClickableSpanListener mOnClickListener;
    private int mClickableSpanPreTextColor;
    private int mClickableSpanPreBgColor;

    public SpecialTextUnit(String specialText) {
        super(specialText);
    }

    public SpecialTextUnit(String specialText, int specialTextColor) {
        this(specialText);
        this.specialTextColor = specialTextColor;
    }

    public SpecialTextUnit(String specialText, int specialTextColor, float textSize) {
        this(specialText);
        this.specialTextColor = specialTextColor;
        this.textSize = textSize;
    }

    public SpecialTextUnit(String specialText, int specialTextColor, float textSize, SpecialGravityEnum gravity) {
        this(specialText);
        this.specialTextColor = specialTextColor;
        this.textSize = textSize;
        this.gravity = gravity;
    }

    public SpecialTextUnit showStrikeThrough() {
        isShowStrikeThrough = true;
        return this;
    }

    public SpecialTextUnit showUnderline() {
        isShowUnderline = true;
        return this;
    }

    public SpecialTextUnit useTextBold() {
        isTextBold = true;
        return this;
    }

    public SpecialTextUnit setSpecialTextBackgroundColor(int specialTextBackgroundColor) {
        this.specialTextBackgroundColor = specialTextBackgroundColor;
        return this;
    }

    public SpecialTextUnit setSpecialTextColor(int specialTextColor) {
        this.specialTextColor = specialTextColor;
        return this;
    }

    public SpecialTextUnit setTextSize(float textSize) {
        this.textSize = textSize;
        return this;
    }

    public SpecialTextUnit setOnClickListener(boolean isShowClickableSpanUnderline, OnClickableSpanListener onClickListener) {
        return setOnClickListener(isShowClickableSpanUnderline, 0, onClickListener);
    }

    /**
     * Set OnClickListener
     * @param isShowClickableSpanUnderline is show Underline
     * @param clickableSpanPreBgColor      press background color
     * @param onClickListener OnClickableSpanListener
     * @return SpecialTextUnit
     */
    public SpecialTextUnit setOnClickListener(boolean isShowClickableSpanUnderline, int clickableSpanPreBgColor, OnClickableSpanListener onClickListener) {
        return setOnClickListener(isShowClickableSpanUnderline, clickableSpanPreBgColor, 0, onClickListener);
    }

    /**
     * Set OnClickListener
     * @param isShowClickableSpanUnderline is show Underline
     * @param clickableSpanPreBgColor      press background color (unRequired set 0)
     * @param mClickableSpanPreTextColor   press text color (unRequired set 0)
     * @param onClickListener OnClickableSpanListener
     * @return SpecialTextUnit
     */
    public SpecialTextUnit setOnClickListener(boolean isShowClickableSpanUnderline, int clickableSpanPreBgColor, int mClickableSpanPreTextColor, OnClickableSpanListener onClickListener) {
        this.isShowClickableSpanUnderline = isShowClickableSpanUnderline;
        this.mOnClickListener = onClickListener;
        this.mClickableSpanPreBgColor = clickableSpanPreBgColor;
        this.mClickableSpanPreTextColor = mClickableSpanPreTextColor;
        return this;
    }

    public SpecialTextUnit setGravity(SpecialGravityEnum gravity) {
        this.gravity = gravity;
        return this;
    }

    public SpecialTextUnit setConvertMode(SpecialConvertModeEnum convertMode) {
        this.convertMode = convertMode;
        return this;
    }

    public int getSpecialTextColor() {
        return specialTextColor;
    }

    public int getSpecialTextBackgroundColor() {
        return specialTextBackgroundColor;
    }

    public float getTextSize() {
        return textSize;
    }

    public boolean isShowUnderline() {
        return isShowUnderline;
    }

    public boolean isShowStrikeThrough() {
        return isShowStrikeThrough;
    }

    public boolean isTextBold() {
        return isTextBold;
    }

    public int getClickableSpanPreBgColor() {
        return mClickableSpanPreBgColor;
    }

    public int getClickableSpanPreTextColor() {
        return mClickableSpanPreTextColor;
    }

    public OnClickableSpanListener getOnClickListener() {
        return mOnClickListener;
    }

    public boolean isShowClickableSpanUnderline() {
        return isShowClickableSpanUnderline;
    }

}