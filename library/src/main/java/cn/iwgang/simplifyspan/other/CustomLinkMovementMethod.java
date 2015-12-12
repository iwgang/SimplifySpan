package cn.iwgang.simplifyspan.other;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;

import cn.iwgang.simplifyspan.customspan.CustomClickableSpan;

/**
 * Custom LinkMovementMethod
 * Created by iWgang on 15/12/8.
 * https://github.com/iwgang/SimplifySpan
 * Ref: http://stackoverflow.com/a/20905824
 */
public class CustomLinkMovementMethod extends LinkMovementMethod {
    private static CustomLinkMovementMethod sInstance;
    private CustomClickableSpan mCustomClickableSpan;

    public static CustomLinkMovementMethod getInstance() {
        if (sInstance == null)
            sInstance = new CustomLinkMovementMethod();

        return sInstance;
    }

    @Override
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            mCustomClickableSpan = getPressedSpan(textView, spannable, event);
            if (mCustomClickableSpan != null) {
                mCustomClickableSpan.setPressed(true);
                Selection.setSelection(spannable, spannable.getSpanStart(mCustomClickableSpan), spannable.getSpanEnd(mCustomClickableSpan));
            }
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            CustomClickableSpan touchedSpan = getPressedSpan(textView, spannable, event);
            if (mCustomClickableSpan != null && touchedSpan != mCustomClickableSpan) {
                mCustomClickableSpan.setPressed(false);
                mCustomClickableSpan = null;
                Selection.removeSelection(spannable);
            }
        } else {
            if (mCustomClickableSpan != null) {
                mCustomClickableSpan.setPressed(false);
                super.onTouchEvent(textView, spannable, event);
            }
            mCustomClickableSpan = null;
            Selection.removeSelection(spannable);
        }
        return true;
    }

    private CustomClickableSpan getPressedSpan(TextView textView, Spannable spannable, MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        x -= textView.getTotalPaddingLeft();
        y -= textView.getTotalPaddingTop();

        x += textView.getScrollX();
        y += textView.getScrollY();

        Layout layout = textView.getLayout();
        int line = layout.getLineForVertical(y);
        int off = layout.getOffsetForHorizontal(line, x);

        CustomClickableSpan[] link = spannable.getSpans(off, off, CustomClickableSpan.class);
        CustomClickableSpan touchedSpan = null;
        if (link.length > 0) {
            touchedSpan = link[0];
        }
        return touchedSpan;
    }

}