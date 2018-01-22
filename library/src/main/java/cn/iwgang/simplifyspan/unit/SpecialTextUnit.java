package cn.iwgang.simplifyspan.unit;

import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Text Special Unit
 * Created by iWgang on 15/12/3.
 * https://github.com/iwgang/SimplifySpan
 */
public class SpecialTextUnit extends BaseSpecialUnit {
    private int textStyle = Typeface.NORMAL;
    private int textColor;
    private int textBackgroundColor;
    private float textSize; // sp
    private boolean isShowUnderline;
    private boolean isShowStrikeThrough;
    private boolean isTextBold;
    private boolean isTextItalic;
    private SpecialClickableUnit specialClickableUnit;
    private TextView curTextView;

    /**
     * @param text text
     */
    public SpecialTextUnit(String text) {
        super(text);
    }

    /**
     * @param text      text
     * @param textColor Text Color
     */
    public SpecialTextUnit(String text, int textColor) {
        this(text);
        this.textColor = textColor;
    }

    /**
     * @param text      text
     * @param textColor text color
     * @param textSize  text size (unit：sp)
     */
    public SpecialTextUnit(String text, int textColor, float textSize) {
        this(text);
        this.textColor = textColor;
        this.textSize = textSize;
    }

    /**
     * @param text        text
     * @param textColor   text color
     * @param textSize    text size (unit：sp)
     * @param gravity     use SpecialGravity.xx
     * @param curTextView current TextView
     */
    public SpecialTextUnit(String text, int textColor, float textSize, int gravity, TextView curTextView) {
        this(text);
        this.textColor = textColor;
        this.textSize = textSize;
        this.gravity = gravity;
        this.curTextView = curTextView;
    }

    /**
     * Show StrikeThrough
     *
     * @return SpecialTextUnit
     */
    public SpecialTextUnit showStrikeThrough() {
        isShowStrikeThrough = true;
        return this;
    }

    /**
     * Show Underline
     *
     * @return SpecialTextUnit
     */
    public SpecialTextUnit showUnderline() {
        isShowUnderline = true;
        return this;
    }

    /**
     * Use Text Bold
     *
     * @return SpecialTextUnit
     */
    public SpecialTextUnit useTextBold() {
        isTextBold = true;
        return this;
    }

    /**
     * Use Text Italic
     *
     * @return SpecialTextUnit
     */
    public SpecialTextUnit useTextItalic() {
        isTextItalic = true;
        return this;
    }

    /**
     * Use TextView support textStyle
     *
     * @param textStyle please see {@link Typeface}
     * @return SpecialTextUnit
     */
    public SpecialTextUnit setTextStyle(int textStyle) {
        this.textStyle = textStyle;
        return this;
    }

    /**
     * Set Background Color
     *
     * @param textBackgroundColor color
     * @return SpecialTextUnit
     */
    public SpecialTextUnit setTextBackgroundColor(int textBackgroundColor) {
        this.textBackgroundColor = textBackgroundColor;
        return this;
    }

    /**
     * Set Special Text Color
     *
     * @param textColor color
     * @return SpecialTextUnit
     */
    public SpecialTextUnit setTextColor(int textColor) {
        this.textColor = textColor;
        return this;
    }

    /**
     * Set Special Text Size
     *
     * @param textSize size (sp)
     * @return SpecialTextUnit
     */
    public SpecialTextUnit setTextSize(float textSize) {
        this.textSize = textSize;
        return this;
    }

    /**
     * Set SpecialClickableUnit
     *
     * @param specialClickableUnit SpecialClickableUnit
     * @return SpecialTextUnit
     */
    public SpecialTextUnit setClickableUnit(SpecialClickableUnit specialClickableUnit) {
        this.specialClickableUnit = specialClickableUnit;
        return this;
    }

    /**
     * Set Gravity
     *
     * @param curTextView current TextView
     * @param gravity     use SpecialGravity.xx
     * @return SpecialTextUnit
     */
    public SpecialTextUnit setGravity(TextView curTextView, int gravity) {
        this.curTextView = curTextView;
        this.gravity = gravity;
        return this;
    }

    /**
     * Set Convert Mode
     *
     * @param convertMode use SpecialConvertMode.xx
     * @return SpecialTextUnit
     */
    public SpecialTextUnit setConvertMode(int convertMode) {
        this.convertMode = convertMode;
        return this;
    }

    public int getTextColor() {
        return textColor;
    }

    public int getTextBackgroundColor() {
        return textBackgroundColor;
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

    public boolean isTextItalic() {
        return isTextItalic;
    }

    public int getTextStyle() {
        return textStyle;
    }

    public TextView getCurTextView() {
        return curTextView;
    }

    public SpecialClickableUnit getSpecialClickableUnit() {
        return specialClickableUnit;
    }

}