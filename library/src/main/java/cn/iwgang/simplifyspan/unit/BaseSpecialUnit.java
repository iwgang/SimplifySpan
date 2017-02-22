package cn.iwgang.simplifyspan.unit;

import cn.iwgang.simplifyspan.other.SpecialConvertMode;
import cn.iwgang.simplifyspan.other.SpecialGravity;

/**
 * Base Special Unit
 * Created by iWgang on 15/12/3.
 * https://github.com/iwgang/SimplifySpan
 */
public class BaseSpecialUnit {
    protected String text;
    private int[] startPoss;
    protected int gravity = SpecialGravity.BOTTOM;
    protected int convertMode = SpecialConvertMode.ONLY_FIRST;

    public BaseSpecialUnit(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public int getGravity() {
        return gravity;
    }

    public int getConvertMode() {
        return convertMode;
    }

    /**
     * Use only in SimplifySpanBuild
     * @param startPoss
     */
    public void setStartPoss(int[] startPoss) {
        this.startPoss = startPoss;
    }

    public int[] getStartPoss() {
        return startPoss;
    }

}