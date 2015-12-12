package cn.iwgang.simplifyspan.customspan;

import android.graphics.Rect;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.widget.TextView;

import cn.iwgang.simplifyspan.other.SpecialGravityEnum;

/**
 * Custom ImageSpan
 * Created by iWgang on 15/12/5.
 * https://github.com/iwgang/SimplifySpan
 */
public class CustomAbsoluteSizeSpan extends AbsoluteSizeSpan {
    private TextView textView;
    private SpecialGravityEnum gravity;
    private int offsetBaselineShift;
    private String mSpecialText;
    private Rect mTextViewRect = new Rect();
    private Rect mSpecialTextRect = new Rect();
    private String mNormalSizeText;

    public CustomAbsoluteSizeSpan(String normalSizeText, String specialText, int size, TextView textView, SpecialGravityEnum gravity) {
        super(size, true);
        this.mSpecialText = specialText;
        this.textView = textView;
        this.gravity = gravity;
        this.mNormalSizeText = normalSizeText;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);

        if (gravity == SpecialGravityEnum.BOTTOM) return;

        textView.getPaint().getTextBounds(mNormalSizeText, 0, mNormalSizeText.length(), mTextViewRect);
        ds.getTextBounds(mSpecialText, 0, mSpecialText.length(), mSpecialTextRect);
        int mMainTextHeight = mTextViewRect.height();

        int offset = mTextViewRect.bottom - mSpecialTextRect.bottom;
        switch (gravity) {
            case TOP:
                offsetBaselineShift = mMainTextHeight - mSpecialTextRect.height() - offset;
                break;
            case CENTER:
                offsetBaselineShift = mMainTextHeight / 2 - mSpecialTextRect.height() / 2 - offset;
                break;
        }

        ds.baselineShift -= offsetBaselineShift;
    }

    @Override
    public void updateMeasureState(TextPaint ds) {
        super.updateMeasureState(ds);
        ds.baselineShift -= offsetBaselineShift;
    }
}