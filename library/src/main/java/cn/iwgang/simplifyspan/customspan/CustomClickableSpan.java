package cn.iwgang.simplifyspan.customspan;

import android.graphics.Color;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import cn.iwgang.simplifyspan.other.OnClickableSpanListener;
import cn.iwgang.simplifyspan.unit.SpecialTextUnit;

/**
 * Custom ClickableSpan
 * Created by iWgang on 15/12/8.
 * https://github.com/iwgang/SimplifySpan
 */
public class CustomClickableSpan extends ClickableSpan {
    private SpecialTextUnit mSpecialTextUnit;
    private boolean isPressed;
    private int mtSpecialTextColorNor;
    private int mtSpecialTextColorPre;
    private int mClickableSpanBgColorNor;
    private int mClickableSpanBgColorPre;

    public CustomClickableSpan(SpecialTextUnit specialTextUnit) {
        this.mSpecialTextUnit = specialTextUnit;
        mtSpecialTextColorNor = mSpecialTextUnit.getSpecialTextColor();
        mtSpecialTextColorPre = mSpecialTextUnit.getClickableSpanPreTextColor();
        mClickableSpanBgColorNor = mSpecialTextUnit.getSpecialTextBackgroundColor();
        mClickableSpanBgColorPre = mSpecialTextUnit.getClickableSpanPreBgColor();
    }

    @Override
    public void onClick(View widget) {
        OnClickableSpanListener onClickableSpanListener = mSpecialTextUnit.getOnClickListener();

        if (null != onClickableSpanListener) {
            TextView tv = (TextView)widget;
            Spanned spanned = (Spanned)tv.getText();
            int start = spanned.getSpanStart(this);
            int end = spanned.getSpanEnd(this);
            onClickableSpanListener.onClick(tv, spanned.subSequence(start, end).toString());
        }
    }

    public void setPressed(boolean isSelected) {
        isPressed = isSelected;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);

        // set text color And press status color
        if (mtSpecialTextColorNor != 0) {
            if (mtSpecialTextColorPre != 0) {
                ds.setColor(isPressed ? mtSpecialTextColorPre : mtSpecialTextColorNor);
            } else {
                ds.setColor(mtSpecialTextColorNor);
            }
        }

        // set background color And press status color
        if (mClickableSpanBgColorPre != 0) {
            ds.bgColor = isPressed ? mClickableSpanBgColorPre : mClickableSpanBgColorNor == 0 ? Color.TRANSPARENT : mClickableSpanBgColorNor;
        } else if (mClickableSpanBgColorNor != 0) {
            ds.bgColor = mClickableSpanBgColorNor;
        }

        if (!mSpecialTextUnit.isShowClickableSpanUnderline()) {
            // clear underline
            ds.setUnderlineText(false);
        }
    }
}
