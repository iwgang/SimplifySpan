package cn.iwgang.simplifyspan.unit;

import cn.iwgang.simplifyspan.other.SpecialConvertModeEnum;
import cn.iwgang.simplifyspan.other.SpecialGravityEnum;

/**
 * Base Special Unit
 * Created by iWgang on 15/12/3.
 * https://github.com/iwgang/SimplifySpan
 */
public class BaseSpecialUnit {
    private String specialText;
    private int[] startPoss;
    protected SpecialGravityEnum gravity = SpecialGravityEnum.BOTTOM;
    protected SpecialConvertModeEnum convertMode = SpecialConvertModeEnum.ONLY_FIRST;

    public BaseSpecialUnit(String specialText) {
        this.specialText = specialText;
    }

    public String getSpecialText() {
        return specialText;
    }

    public SpecialGravityEnum getGravity() {
        return gravity;
    }

    public SpecialConvertModeEnum getConvertMode() {
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