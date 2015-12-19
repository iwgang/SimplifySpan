package cn.iwgang.simplifyspan.unit;

/**
 * Text Special Unit
 * Created by iWgang on 15/12/3.
 * https://github.com/iwgang/SimplifySpan
 */
public class SpecialTextUnit extends BaseSpecialUnit {
    private int specialTextColor;
    private int specialTextBackgroundColor;
    private float textSize; // sp
    private boolean isShowUnderline;
    private boolean isShowStrikeThrough;
    private boolean isTextBold;
    private SpecialClickableUnit specialClickableUnit;

    /**
     * @param specialText       Special Text
     */
    public SpecialTextUnit(String specialText) {
        super(specialText);
    }

    /**
     * @param specialText       Special Text
     * @param specialTextColor  special Text Color
     */
    public SpecialTextUnit(String specialText, int specialTextColor) {
        this(specialText);
        this.specialTextColor = specialTextColor;
    }

    /**
     * @param specialText       Special Text
     * @param specialTextColor  special Text Color
     * @param textSize          Special Text Size (sp)
     */
    public SpecialTextUnit(String specialText, int specialTextColor, float textSize) {
        this(specialText);
        this.specialTextColor = specialTextColor;
        this.textSize = textSize;
    }

    /**
     * @param specialText       Special Text
     * @param specialTextColor  special Text Color
     * @param textSize          Special Text Size (sp)
     * @param gravity           Use SpecialGravity.xx
     */
    public SpecialTextUnit(String specialText, int specialTextColor, float textSize, int gravity) {
        this(specialText);
        this.specialTextColor = specialTextColor;
        this.textSize = textSize;
        this.gravity = gravity;
    }

    /**
     * Show StrikeThrough
     * @return SpecialTextUnit
     */
    public SpecialTextUnit showStrikeThrough() {
        isShowStrikeThrough = true;
        return this;
    }

    /**
     * Show Underline
     * @return SpecialTextUnit
     */
    public SpecialTextUnit showUnderline() {
        isShowUnderline = true;
        return this;
    }

    /**
     * Use Text Bold
     * @return SpecialTextUnit
     */
    public SpecialTextUnit useTextBold() {
        isTextBold = true;
        return this;
    }

    /**
     * Set Background Color
     * @param specialTextBackgroundColor color
     * @return SpecialTextUnit
     */
    public SpecialTextUnit setSpecialTextBackgroundColor(int specialTextBackgroundColor) {
        this.specialTextBackgroundColor = specialTextBackgroundColor;
        return this;
    }

    /**
     * Set Special Text Color
     * @param specialTextColor color
     * @return SpecialTextUnit
     */
    public SpecialTextUnit setSpecialTextColor(int specialTextColor) {
        this.specialTextColor = specialTextColor;
        return this;
    }

    /**
     * Set Special Text Size
     * @param textSize size (sp)
     * @return SpecialTextUnit
     */
    public SpecialTextUnit setTextSize(float textSize) {
        this.textSize = textSize;
        return this;
    }

    /**
     * Set SpecialClickableUnit
     * @param specialClickableUnit SpecialClickableUnit
     * @return SpecialTextUnit
     */
    public SpecialTextUnit setSpecialClickableUnit(SpecialClickableUnit specialClickableUnit) {
        this.specialClickableUnit = specialClickableUnit;
        return this;
    }

    /**
     * Set Gravity
     * @param gravity use SpecialGravity.xx
     * @return SpecialTextUnit
     */
    public SpecialTextUnit setGravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    /**
     * Set Convert Mode
     * @param convertMode use SpecialConvertMode.xx
     * @return SpecialTextUnit
     */
    public SpecialTextUnit setConvertMode(int convertMode) {
        this.convertMode = convertMode;
        return this;
    }

    public int getSpecialTextColor() {
        return specialTextColor;
    }

    public int getSpecialTextBackgroundColor() {
        return specialTextBackgroundColor;
    }

    public float getTextSize() {
        return textSize;
    }

    public boolean isShowUnderline() {
        return isShowUnderline;
    }

    public boolean isShowStrikeThrough() {
        return isShowStrikeThrough;
    }

    public boolean isTextBold() {
        return isTextBold;
    }

    public SpecialClickableUnit getSpecialClickableUnit() {
        return specialClickableUnit;
    }

}