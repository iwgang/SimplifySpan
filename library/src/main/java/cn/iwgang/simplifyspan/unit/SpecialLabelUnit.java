package cn.iwgang.simplifyspan.unit;

import android.graphics.Bitmap;

import cn.iwgang.simplifyspan.other.SpecialConvertModeEnum;
import cn.iwgang.simplifyspan.other.SpecialGravityEnum;

/**
 * Label Special Unit
 * Created by iWgang on 15/12/7.
 * https://github.com/iwgang/SimplifySpan
 */
public class SpecialLabelUnit extends BaseSpecialUnit {
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

    public SpecialLabelUnit(String specialText, int labelTextColor, float labelTextSize, int labelBgColor) {
        super(specialText);
        this.labelTextSize = labelTextSize;
        this.labelTextColor = labelTextColor;
        this.labelBgColor = labelBgColor;
    }

    public SpecialLabelUnit(String specialText, int labelTextColor, float labelTextSize, int labelBgColor, int labelBgWidth, int labelBgHeight) {
        super(specialText);
        this.labelTextSize = labelTextSize;
        this.labelTextColor = labelTextColor;
        this.labelBgColor = labelBgColor;
        this.labelBgWidth = labelBgWidth;
        this.labelBgHeight = labelBgHeight;
    }

    public SpecialLabelUnit(String specialText, int labelTextColor, float labelTextSize, Bitmap bitmap) {
        super(specialText);
        this.labelTextSize = labelTextSize;
        this.labelTextColor = labelTextColor;
        this.mBitmap = bitmap;
    }

    public SpecialLabelUnit(String specialText, int labelTextColor, float labelTextSize, Bitmap bitmap, int labelBgWidth, int labelBgHeight) {
        super(specialText);
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

    public SpecialLabelUnit showShowBorder(int labelBgBorderColor, float borderSize) {
        isShowBorder = true;
        this.labelBgBorderColor = labelBgBorderColor;
        this.borderSize = borderSize;
        return this;
    }

    public SpecialLabelUnit useTextBold() {
        isTextBold = true;
        return this;
    }

    public SpecialLabelUnit setGravity(SpecialGravityEnum gravity) {
        this.gravity = gravity;
        return this;
    }

    public SpecialLabelUnit setConvertMode(SpecialConvertModeEnum convertMode) {
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
     * @return px (Convert in SimplifySpanBuild)
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

    /**
     * Use only in SimplifySpanBuild
     * @param pxLabelTextSize
     */
    public void convertLabelTextSize(float pxLabelTextSize) {
        this.labelTextSize = pxLabelTextSize;
    }
}