package cn.iwgang.simplifyspan.customspan;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

import java.lang.ref.WeakReference;

import cn.iwgang.simplifyspan.other.OnClickStateChangeListener;
import cn.iwgang.simplifyspan.other.SpecialGravity;
import cn.iwgang.simplifyspan.unit.SpecialImageUnit;

/**
 * Custom ImageSpan
 * Created by iWgang on 15/12/3.
 * https://github.com/iwgang/SimplifySpan
 */
public class CustomImageSpan extends ImageSpan implements OnClickStateChangeListener {
    private WeakReference<Drawable> mDrawableRef;
    private int gravity;
    private Rect mRect = new Rect();
    private String mNormalSizeText;
    private int mBgColor;
    private boolean isSelected;
    private boolean isClickable;
    private int pressBgColor;

    private int mLineTextHeight;
    private int mLineTextBaselineOffset;

    public CustomImageSpan(String normalSizeText,  SpecialImageUnit specialImageUnit) {
        super(specialImageUnit.getContext(), specialImageUnit.getBitmap(), ALIGN_BASELINE);
        this.gravity = specialImageUnit.getGravity();
        this.mNormalSizeText = normalSizeText;
        this.mBgColor = specialImageUnit.getBgColor();
        this.isClickable = specialImageUnit.isClickable();
    }

    @Override
    public void onStateChange(boolean isSelected, int pressBgColor) {
        this.isSelected = isSelected;
        this.pressBgColor = pressBgColor;
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Drawable b = getCachedDrawable();
        int drawableHeight = b.getIntrinsicHeight();
        int drawableWidth = b.getIntrinsicWidth();
        paint.getTextBounds(mNormalSizeText, 0, mNormalSizeText.length(), mRect);

        float finalUnitHeight = bottom - top;
        float bgTop = bottom - finalUnitHeight;

        if (isClickable && isSelected && pressBgColor != 0) {
            // click background
            paint.setColor(pressBgColor);
            canvas.drawRect(x, bgTop, x + drawableWidth, bgTop + finalUnitHeight, paint);
        } else {
            // normal background
            if (mBgColor != 0) {
                paint.setColor(mBgColor);
                canvas.drawRect(x, bgTop, x + drawableWidth, bgTop + finalUnitHeight, paint);
            }
        }

        int textHeight = mRect.height();
        if (drawableHeight > textHeight) {
            super.draw(canvas, text, start, end, x, top, y, bottom, paint);
            return;
        }
        canvas.save();

        if (mLineTextHeight <= 0) {
            Rect specialTextRect = new Rect();
            paint.getTextBounds(mNormalSizeText, 0, mNormalSizeText.length(), specialTextRect);
            mLineTextHeight = specialTextRect.height();
            mLineTextBaselineOffset = specialTextRect.bottom;
        }

        float newStartY = y;
        switch (gravity) {
            case SpecialGravity.TOP: {
                newStartY -= mLineTextHeight - mLineTextBaselineOffset;
                canvas.translate(x, newStartY);
                break;
            }
            case SpecialGravity.CENTER: {
                newStartY -= (mLineTextHeight / 2 + drawableHeight / 2 - mLineTextBaselineOffset);
                canvas.translate(x, newStartY);
                break;
            }
            case SpecialGravity.BOTTOM: {
                newStartY -= drawableHeight - mLineTextBaselineOffset;
                canvas.translate(x, newStartY);
                break;
            }
        }
        b.draw(canvas);
        canvas.restore();
    }

    private Drawable getCachedDrawable() {
        Drawable drawable = null;

        if (mDrawableRef != null) {
            drawable = mDrawableRef.get();
        }

        if (drawable == null) {
            drawable = getDrawable();
            mDrawableRef = new WeakReference<>(drawable);
        }

        return drawable;
    }

}  