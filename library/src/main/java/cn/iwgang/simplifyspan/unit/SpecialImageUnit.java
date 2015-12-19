package cn.iwgang.simplifyspan.unit;

import android.graphics.Bitmap;

/**
 * Image Special Unit
 * Created by iWgang on 15/12/3.
 * https://github.com/iwgang/SimplifySpan
 */
public class SpecialImageUnit extends BaseSpecialUnit {
    private static final String DEF_IMG_PLACEHOLDER = "img";

    private Bitmap bitmap;
    private int bgColor;
    private boolean isClickable;
    private int width; // px
    private int height; // px

    /**
     * @param bitmap      Bitmap
     */
    public SpecialImageUnit(Bitmap bitmap) {
        this(DEF_IMG_PLACEHOLDER, bitmap);
    }

    /**
     * @param specialText Special Text
     * @param bitmap      Bitmap
     */
    public SpecialImageUnit(String specialText, Bitmap bitmap) {
        super(specialText);
        this.bitmap = bitmap;
    }

    /**
     * @param bitmap      Bitmap
     * @param width       Width
     * @param height      Height
     */
    public SpecialImageUnit(Bitmap bitmap, int width, int height) {
        this(DEF_IMG_PLACEHOLDER, bitmap, width, height);
    }

    /**
     * @param specialText Special Text
     * @param bitmap      Bitmap
     * @param width       Width
     * @param height      Height
     */
    public SpecialImageUnit(String specialText, Bitmap bitmap, int width, int height) {
        super(specialText);
        this.bitmap = bitmap;
        this.width = width;
        this.height = height;
    }

    /**
     * @param bitmap      Bitmap
     * @param width       Width
     * @param height      Height
     * @param gravity     Use SpecialGravity.xx
     */
    public SpecialImageUnit(Bitmap bitmap, int width, int height, int gravity) {
        this(DEF_IMG_PLACEHOLDER, bitmap, width, height, gravity);
    }

    /**
     * @param specialText Special Text
     * @param bitmap      Bitmap
     * @param width       Width
     * @param height      Height
     * @param gravity     Use SpecialGravity.xx
     */
    public SpecialImageUnit(String specialText, Bitmap bitmap, int width, int height, int gravity) {
        super(specialText);
        this.bitmap = bitmap;
        this.width = width;
        this.height = height;
        this.gravity = gravity;
    }

    /**
     * Set Background Color
     * @param bgColor
     * @return
     */
    public SpecialImageUnit setBgColor(int bgColor) {
        this.bgColor = bgColor;
        return this;
    }

    /**
     * Set Gravity
     * @param gravity use SpecialGravity.xx
     * @return
     */
    public SpecialImageUnit setGravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    /**
     * Set Convert Mode
     * @param convertMode use SpecialConvertMode.xx
     * @return
     */
    public SpecialImageUnit setConvertMode(int convertMode) {
        this.convertMode = convertMode;
        return this;
    }

    public boolean isClickable() {
        return isClickable;
    }

    /**
     * Use only in SimplifySpanBuild
     * @param clickable
     */
    public void setClickable(boolean clickable) {
        isClickable = clickable;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getBgColor() {
        return bgColor;
    }

}