package cn.iwgang.simplifyspan.unit;

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
    private int normalBgColor;
    private int pressBgColor;
    // only text
    private boolean isShowUnderline;
    private int normalTextColor;
    private int pressTextColor;

    public SpecialClickableUnit(OnClickableSpanListener onClickListener) {
        super(null);
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

    public List<OnClickStateChangeListener> getOnClickStateChangeListeners() {
        return onClickStateChangeListeners;
    }

    public boolean isShowUnderline() {
        return isShowUnderline;
    }

    public void setSpecialText(String specialText) {
        this.specialText = specialText;
    }

}