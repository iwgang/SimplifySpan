package cn.iwgang.simplifyspan.unit;

import android.widget.TextView;

import java.util.List;

import cn.iwgang.simplifyspan.other.OnClickStateChangeListener;
import cn.iwgang.simplifyspan.other.OnClickableSpanListener;

/**
 * Clickable Special Unit
 * Created by iWgang on 15/12/7.
 * https://github.com/iwgang/SimplifySpan
 */
public class SpecialClickableUnit extends BaseSpecialUnit {
    private List<OnClickStateChangeListener> onClickStateChangeListeners;
    private OnClickableSpanListener onClickListener;
    private TextView curTextView;
    private int normalBgColor;
    private int pressBgColor;
    // only text
    private boolean isShowUnderline;
    private int normalTextColor;
    private int pressTextColor;
    private Object tag;

    public SpecialClickableUnit(TextView curTextView, OnClickableSpanListener onClickListener) {
        super(null);
        this.curTextView = curTextView;
        this.onClickListener = onClickListener;
    }

    public SpecialClickableUnit showUnderline() {
        this.isShowUnderline = true;
        return this;
    }

    public SpecialClickableUnit setPressBgColor(int pressBgColor) {
        this.pressBgColor = pressBgColor;
        return this;
    }

    public SpecialClickableUnit setPressTextColor(int pressTextColor) {
        this.pressTextColor = pressTextColor;
        return this;
    }

    public SpecialClickableUnit setNormalBgColor(int normalBgColor) {
        this.normalBgColor = normalBgColor;
        return this;
    }

    public SpecialClickableUnit setNormalTextColor(int normalTextColor) {
        this.normalTextColor = normalTextColor;
        return this;
    }

    /**
     * Do not call !!! (Use only in SimplifySpanBuild)
     *
     * @param onClickStateChangeListeners OnClickStateChangeListener list
     */
    public void setOnClickStateChangeListeners(List<OnClickStateChangeListener> onClickStateChangeListeners) {
        this.onClickStateChangeListeners = onClickStateChangeListeners;
    }

    public OnClickableSpanListener getOnClickListener() {
        return onClickListener;
    }

    public int getPressTextColor() {
        return pressTextColor;
    }

    public int getPressBgColor() {
        return pressBgColor;
    }

    public int getNormalBgColor() {
        return normalBgColor;
    }

    public int getNormalTextColor() {
        return normalTextColor;
    }

    public TextView getCurTextView() {
        return curTextView;
    }

    public List<OnClickStateChangeListener> getOnClickStateChangeListeners() {
        return onClickStateChangeListeners;
    }

    public boolean isShowUnderline() {
        return isShowUnderline;
    }

    /**
     * Do not call !!! (Use only in SimplifySpanBuild)
     *
     * @param text text
     */
    public void setText(String text) {
        this.text = text;
    }

    public Object getTag() {
        return tag;
    }

    public SpecialClickableUnit setTag(Object tag) {
        this.tag = tag;
        return this;
    }
}