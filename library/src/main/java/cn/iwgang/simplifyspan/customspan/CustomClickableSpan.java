package cn.iwgang.simplifyspan.customspan;

import android.graphics.Color;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.Log;
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
    private Object tag;
    private String clickText;
    private int startSpanIndex;
    private int endSpanIndex;

    public CustomClickableSpan(SpecialClickableUnit specialClickableUnit) {
        setTag(specialClickableUnit.getTag());
        mTextColorNor = specialClickableUnit.getNormalTextColor();
        mTextColorPre = specialClickableUnit.getPressTextColor();
        mBgColorNor = specialClickableUnit.getNormalBgColor();
        mBgColorPre = specialClickableUnit.getPressBgColor();
        isShowUnderline = specialClickableUnit.isShowUnderline();
        mOnClickableSpanListener = specialClickableUnit.getOnClickListener();
        mOnClickStateChangeListeners = specialClickableUnit.getOnClickStateChangeListeners();
    }

    @Override
    public void onClick(View widget) {
        if (null != mOnClickableSpanListener) {
            TextView tv = (TextView)widget;
            Spanned spanned = (Spanned)tv.getText();
            startSpanIndex = spanned.getSpanStart(this);
            endSpanIndex = spanned.getSpanEnd(this);
            clickText = spanned.subSequence(startSpanIndex, endSpanIndex).toString();
            mOnClickableSpanListener.onClick(tv, this);
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

    public Object getTag() {
        return tag;
    }

    public void setTag(Object tag) {
        this.tag = tag;
    }

    //get current click text
    public String getClickText(){
        return clickText;
    }

    //get current click text span start index in total
    public int getStartSpanIndex() {
        return startSpanIndex;
    }

    //get current click text span start index in end
    public int getEndSpanIndex() {
        return endSpanIndex;
    }

}
