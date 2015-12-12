package cn.iwgang.simplifyspan.customspan;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

import java.lang.ref.WeakReference;

import cn.iwgang.simplifyspan.other.SpecialGravityEnum;

/**
 * Custom ImageSpan
 * Created by iWgang on 15/12/3.
 * https://github.com/iwgang/SimplifySpan
 */
public class CustomImageSpan extends ImageSpan {
    private WeakReference<Drawable> mDrawableRef;
    private SpecialGravityEnum gravity;
    private Rect mRect = new Rect();
    private String mNormalSizeText;

    public CustomImageSpan(Context context, String normalSizeText, Bitmap b, SpecialGravityEnum gravity) {
        super(context, b, ALIGN_BASELINE);
        this.gravity = gravity;
        this.mNormalSizeText = normalSizeText;
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Drawable b = getCachedDrawable();

        int drawableHeight = b.getIntrinsicHeight();
        int fontDescent = paint.getFontMetricsInt().descent;
        paint.getTextBounds(mNormalSizeText, 0, mNormalSizeText.length(), mRect);
        int textHeight = mRect.height();
        if (drawableHeight > textHeight) {
            super.draw(canvas, text, start, end, x, top, y, bottom, paint);
            return;
        }

        canvas.save();

        int baseTransY = bottom - b.getBounds().bottom - fontDescent + mRect.bottom;
        switch (gravity) {
            case TOP: {
                int transY = baseTransY - (textHeight - drawableHeight);
                canvas.translate(x, transY);
                break;
            }
            case CENTER: {
                int transY = baseTransY - (textHeight / 2 - drawableHeight / 2);
                canvas.translate(x, transY);
                break;
            }
            case BOTTOM: {
                canvas.translate(x, baseTransY);
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