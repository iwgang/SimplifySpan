package cn.iwgang.simplifyspan.customspan;

import android.graphics.Rect;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.widget.TextView;

import cn.iwgang.simplifyspan.other.SpecialGravity;

/**
 * Custom AbsoluteSizeSpan
 * Created by iWgang on 15/12/5.
 * https://github.com/iwgang/SimplifySpan
 */
public class CustomAbsoluteSizeSpan extends AbsoluteSizeSpan {
    private TextView mTextView;
    private int mGravity;
    private int mOffsetBaselineShift;
    private String mSpecialText;
    private Rect mTextViewRect = new Rect();
    private Rect mSpecialTextRect = new Rect();
    private String mNormalSizeText;

    public CustomAbsoluteSizeSpan(String normalSizeText, String specialText, int size, TextView textView, int gravity) {
        super(size, true);
        mSpecialText = specialText;
        mTextView = textView;
        mGravity = gravity;
        mNormalSizeText = normalSizeText;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);

        if (mGravity == SpecialGravity.BOTTOM) return;

        mTextView.getPaint().getTextBounds(mNormalSizeText, 0, mNormalSizeText.length(), mTextViewRect);
        ds.getTextBounds(mSpecialText, 0, mSpecialText.length(), mSpecialTextRect);
        int mMainTextHeight = mTextViewRect.height();

        int offset = mTextViewRect.bottom - mSpecialTextRect.bottom;
        switch (mGravity) {
            case SpecialGravity.TOP:
                mOffsetBaselineShift = mMainTextHeight - mSpecialTextRect.height() - offset;
                break;
            case SpecialGravity.CENTER:
                mOffsetBaselineShift = mMainTextHeight / 2 - mSpecialTextRect.height() / 2 - offset;
                break;
        }

        ds.baselineShift -= mOffsetBaselineShift;
    }

    @Override
    public void updateMeasureState(TextPaint ds) {
        super.updateMeasureState(ds);
        ds.baselineShift -= mOffsetBaselineShift;
    }
}