package cn.iwgang.simplifyspan.customspan;

import android.graphics.Color;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import cn.iwgang.simplifyspan.other.OnClickStateChangeListener;
import cn.iwgang.simplifyspan.other.OnClickableSpanListener;
import cn.iwgang.simplifyspan.unit.SpecialClickableUnit;

/**
 * Custom ClickableSpan
 * Created by iWgang on 15/12/8.
 * https://github.com/iwgang/SimplifySpan
 */
public class CustomClickableSpan extends ClickableSpan {
    private List<OnClickStateChangeListener> mOnClickStateChangeListeners;
    private OnClickableSpanListener mOnClickableSpanListener;
    private boolean isPressed;
    private boolean isShowUnderline;
    private int mTextColorNor;
    private int mTextColorPre;
    private int mBgColorNor;
    private int mBgColorPre;

    public CustomClickableSpan(SpecialClickableUnit specialClickableUnit) {
        mTextColorNor = specialClickableUnit.getNormalTextColor();
        mTextColorPre = specialClickableUnit.getPressTextColor();
        mBgColorNor = specialClickableUnit.getNormalBgColor();
        mBgColorPre = specialClickableUnit.getPressBgColor();
        isShowUnderline = specialClickableUnit.isShowUnderline();
        mOnClickableSpanListener = specialClickableUnit.getOnClickListener();
        this.mOnClickStateChangeListeners = specialClickableUnit.getOnClickStateChangeListeners();
    }

    @Override
    public void onClick(View widget) {
        if (null != mOnClickableSpanListener) {
            TextView tv = (TextView)widget;
            Spanned spanned = (Spanned)tv.getText();
            int start = spanned.getSpanStart(this);
            int end = spanned.getSpanEnd(this);
            mOnClickableSpanListener.onClick(tv, spanned.subSequence(start, end).toString());
        }
    }

    public void setPressed(boolean isSelected) {
        if (null != mOnClickStateChangeListeners && !mOnClickStateChangeListeners.isEmpty()) {
            for (OnClickStateChangeListener csl : mOnClickStateChangeListeners) {
                csl.onStateChange(isSelected, mBgColorPre);
            }
        }
        isPressed = isSelected;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);

        // set text color And press status color
        if (mTextColorNor != 0) {
            if (mTextColorPre != 0) {
                ds.setColor(isPressed ? mTextColorPre : mTextColorNor);
            } else {
                ds.setColor(mTextColorNor);
            }
        }

        // set background color And press status color
        if (mBgColorPre != 0) {
            ds.bgColor = isPressed ? mBgColorPre : mBgColorNor == 0 ? Color.TRANSPARENT : mBgColorNor;
        } else if (mBgColorNor != 0) {
            ds.bgColor = mBgColorNor;
        }

        if (!isShowUnderline) {
            // clear underline
            ds.setUnderlineText(false);
        }
    }
}
