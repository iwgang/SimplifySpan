package cn.iwgang.simplifyspan.unit;

import android.graphics.Bitmap;

import cn.iwgang.simplifyspan.other.SpecialGravityEnum;
import cn.iwgang.simplifyspan.other.SpecialConvertModeEnum;

/**
 * Image Special Unit
 * Created by iWgang on 15/12/3.
 * https://github.com/iwgang/SimplifySpan
 */
public class SpecialImageUnit extends BaseSpecialUnit {
    private static final String DEF_IMG_PLACEHOLDER = "img";

    private Bitmap bitmap;
    private int width; // px
    private int height; // px

    public SpecialImageUnit(Bitmap bitmap) {
        this(DEF_IMG_PLACEHOLDER, bitmap);
    }

    public SpecialImageUnit(String specialText, Bitmap bitmap) {
        super(specialText);
        this.bitmap = bitmap;
    }

    public SpecialImageUnit(Bitmap bitmap, int width, int height) {
        this(DEF_IMG_PLACEHOLDER, bitmap, width, height);
    }

    public SpecialImageUnit(String specialText, Bitmap bitmap, int width, int height) {
        super(specialText);
        this.bitmap = bitmap;
        this.width = width;
        this.height = height;
    }

    public SpecialImageUnit(Bitmap bitmap, int width, int height, SpecialGravityEnum gravity) {
        this(DEF_IMG_PLACEHOLDER, bitmap, width, height, gravity);
    }

    public SpecialImageUnit(String specialText, Bitmap bitmap, int width, int height, SpecialGravityEnum gravity) {
        super(specialText);
        this.bitmap = bitmap;
        this.width = width;
        this.height = height;
        this.gravity = gravity;
    }

    public SpecialImageUnit setGravity(SpecialGravityEnum gravity) {
        this.gravity = gravity;
        return this;
    }

    public SpecialImageUnit setConvertMode(SpecialConvertModeEnum convertMode) {
        this.convertMode = convertMode;
        return this;
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

}