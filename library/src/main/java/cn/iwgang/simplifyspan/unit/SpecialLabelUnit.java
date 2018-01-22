package cn.iwgang.simplifyspan.unit;

import android.graphics.Bitmap;
import android.graphics.Typeface;

/**
 * Label Special Unit
 * Created by iWgang on 15/12/7.
 * https://github.com/iwgang/SimplifySpan
 */
public class SpecialLabelUnit extends BaseSpecialUnit {
    private int textStyle = Typeface.NORMAL;
    private int labelTextColor;
    private float labelTextSize; // sp
    private Bitmap mBitmap;
    private int labelBgColor;
    private float labelBgRadius;
    private int labelBgWidth; // px
    private int labelBgHeight; // px
    private int padding; // px
    private int paddingLeft; // px
    private int paddingRight; // px
    private float borderSize; // px
    private int labelBgBorderColor;
    private boolean isShowBorder;
    private boolean isTextBold;
    private boolean isTextItalic;
    private boolean isClickable;
    private int bgColor;

    /**
     * @param labelText      label text
     * @param labelTextColor label text color
     * @param labelTextSize  label text size (unit：xp)
     * @param labelBgColor   label background color
     */
    public SpecialLabelUnit(String labelText, int labelTextColor, float labelTextSize, int labelBgColor) {
        super(labelText);
        this.labelTextSize = labelTextSize;
        this.labelTextColor = labelTextColor;
        this.labelBgColor = labelBgColor;
    }

    /**
     * @param labelText      label text
     * @param labelTextColor label text color
     * @param labelTextSize  label text size (unit：xp)
     * @param labelBgColor   label background color
     * @param labelBgWidth   label background width
     * @param labelBgHeight  label background height
     */
    public SpecialLabelUnit(String labelText, int labelTextColor, float labelTextSize, int labelBgColor, int labelBgWidth, int labelBgHeight) {
        super(labelText);
        this.labelTextSize = labelTextSize;
        this.labelTextColor = labelTextColor;
        this.labelBgColor = labelBgColor;
        this.labelBgWidth = labelBgWidth;
        this.labelBgHeight = labelBgHeight;
    }

    /**
     * @param labelText      label text
     * @param labelTextColor label text color
     * @param labelTextSize  label text size (unit：xp)
     * @param bitmap         label background image bitmap
     */
    public SpecialLabelUnit(String labelText, int labelTextColor, float labelTextSize, Bitmap bitmap) {
        super(labelText);
        this.labelTextSize = labelTextSize;
        this.labelTextColor = labelTextColor;
        this.mBitmap = bitmap;
    }

    /**
     * @param labelText      label text
     * @param labelTextColor label text color
     * @param labelTextSize  label text size (unit：xp)
     * @param bitmap         label background image bitmap
     * @param labelBgWidth   label background width
     * @param labelBgHeight  label background height
     */
    public SpecialLabelUnit(String labelText, int labelTextColor, float labelTextSize, Bitmap bitmap, int labelBgWidth, int labelBgHeight) {
        super(labelText);
        this.labelTextSize = labelTextSize;
        this.labelTextColor = labelTextColor;
        this.mBitmap = bitmap;
        this.labelBgWidth = labelBgWidth;
        this.labelBgHeight = labelBgHeight;
    }

    public SpecialLabelUnit setLabelBgSize(int labelBgWidth, int labelBgHeight) {
        this.labelBgWidth = labelBgWidth;
        this.labelBgHeight = labelBgHeight;
        return this;
    }

    public SpecialLabelUnit setBitmap(Bitmap mBitmap) {
        this.mBitmap = mBitmap;
        return this;
    }

    public SpecialLabelUnit setPadding(int padding) {
        this.padding = padding;
        return this;
    }

    public SpecialLabelUnit setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
        return this;
    }

    public SpecialLabelUnit setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
        return this;
    }

    public SpecialLabelUnit setLabelBgRadius(float labelBgRadius) {
        this.labelBgRadius = labelBgRadius;
        return this;
    }

    public SpecialLabelUnit showBorder(int labelBgBorderColor, float borderSize) {
        isShowBorder = true;
        this.labelBgBorderColor = labelBgBorderColor;
        this.borderSize = borderSize;
        return this;
    }

    public SpecialLabelUnit useTextBold() {
        isTextBold = true;
        return this;
    }

    public SpecialLabelUnit useTextItalic() {
        isTextItalic = true;
        return this;
    }

    /**
     * Use TextView support textStyle
     *
     * @param textStyle please see {@link Typeface}
     * @return SpecialTextUnit
     */
    public SpecialLabelUnit setTextStyle(int textStyle) {
        this.textStyle = textStyle;
        return this;
    }

    public SpecialLabelUnit setBgColor(int bgColor) {
        this.bgColor = bgColor;
        return this;
    }

    /**
     * Set Gravity
     *
     * @param gravity use SpecialGravity.xx
     * @return
     */
    public SpecialLabelUnit setGravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    /**
     * Set Convert Mode
     *
     * @param convertMode use SpecialConvertMode.xx
     * @return
     */
    public SpecialLabelUnit setConvertMode(int convertMode) {
        this.convertMode = convertMode;
        return this;
    }

    public int getLabelBgColor() {
        return labelBgColor;
    }

    public int getLabelBgHeight() {
        return labelBgHeight;
    }

    public int getLabelBgWidth() {
        return labelBgWidth;
    }

    public int getLabelTextColor() {
        return labelTextColor;
    }

    /**
     * label Text Size
     *
     * @return px
     */
    public float getLabelTextSize() {
        return labelTextSize;
    }

    public int getPadding() {
        return padding;
    }

    public int getPaddingLeft() {
        return paddingLeft;
    }

    public int getPaddingRight() {
        return paddingRight;
    }

    public float getLabelBgRadius() {
        return labelBgRadius;
    }

    public boolean isShowBorder() {
        return isShowBorder;
    }

    /**
     * Use only in SimplifySpanBuild
     *
     * @param clickable
     */
    public void setClickable(boolean clickable) {
        isClickable = clickable;
    }

    public float getBorderSize() {
        return borderSize;
    }

    public int getLabelBgBorderColor() {
        return labelBgBorderColor;
    }

    public boolean isTextBold() {
        return isTextBold;
    }

    public Bitmap getBitmap() {
        return mBitmap;
    }

    public boolean isClickable() {
        return isClickable;
    }

    public int getBgColor() {
        return bgColor;
    }

    public boolean isTextItalic() {
        return isTextItalic;
    }

    public int getTextStyle() {
        return textStyle;
    }


}