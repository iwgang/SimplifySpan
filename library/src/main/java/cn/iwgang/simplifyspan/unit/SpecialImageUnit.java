package cn.iwgang.simplifyspan.unit;

import android.content.Context;
import android.graphics.Bitmap;

/**
 * Image Special Unit
 * Created by iWgang on 15/12/3.
 * https://github.com/iwgang/SimplifySpan
 */
public class SpecialImageUnit extends BaseSpecialUnit {
    private static final String DEF_IMG_PLACEHOLDER = "img";

    private Context context;
    private Bitmap bitmap;
    private int bgColor;
    private boolean isClickable;
    private int width; // px
    private int height; // px

    /**
     * @param context     Context
     * @param bitmap      Bitmap
     */
    public SpecialImageUnit(Context context, Bitmap bitmap) {
        this(context, DEF_IMG_PLACEHOLDER, bitmap);
    }

    /**
     * @param context     Context
     * @param specialText Special Text
     * @param bitmap      Bitmap
     */
    public SpecialImageUnit(Context context, String specialText, Bitmap bitmap) {
        super(specialText);
        this.context = context;
        this.bitmap = bitmap;
    }

    /**
     * @param context     Context
     * @param bitmap      Bitmap
     * @param width       Width
     * @param height      Height
     */
    public SpecialImageUnit(Context context, Bitmap bitmap, int width, int height) {
        this(context, DEF_IMG_PLACEHOLDER, bitmap, width, height);
    }

    /**
     * @param context     Context
     * @param specialText Special Text
     * @param bitmap      Bitmap
     * @param width       Width
     * @param height      Height
     */
    public SpecialImageUnit(Context context, String specialText, Bitmap bitmap, int width, int height) {
        super(specialText);
        this.context = context;
        this.bitmap = bitmap;
        this.width = width;
        this.height = height;
    }

    /**
     * @param context     Context
     * @param bitmap      Bitmap
     * @param width       Width
     * @param height      Height
     * @param gravity     Use SpecialGravity.xx
     */
    public SpecialImageUnit(Context context, Bitmap bitmap, int width, int height, int gravity) {
        this(context, DEF_IMG_PLACEHOLDER, bitmap, width, height, gravity);
    }

    /**
     * @param context     Context
     * @param specialText Special Text
     * @param bitmap      Bitmap
     * @param width       Width
     * @param height      Height
     * @param gravity     Use SpecialGravity.xx
     */
    public SpecialImageUnit(Context context, String specialText, Bitmap bitmap, int width, int height, int gravity) {
        super(specialText);
        this.context = context;
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

    public Context getContext() {
        return context;
    }
}