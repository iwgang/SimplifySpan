[![Android Gems](http://www.android-gems.com/badge/iwgang/SimplifySpan.svg?branch=master)](http://www.android-gems.com/lib/iwgang/SimplifySpan)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-SimplifySpan-green.svg?style=true)](http://android-arsenal.com/details/1/2907)
[![@iwgang](https://img.shields.io/badge/weibo-%40iwgang-blue.svg)](http://weibo.com/iwgang)

# SimplifySpan
A easy-to-use and powerful Spannable library

### screenshot
![](https://raw.githubusercontent.com/iwgang/SimplifySpan/master/screenshot/s1.png)   
![](https://raw.githubusercontent.com/iwgang/SimplifySpan/master/screenshot/s3.gif)  

### gradle
    implementation 'com.github.iwgang:simplifyspan:2.2'
    
### Support Units
* SpecialTextUnit
    * **text** (Constructor | String)
    * **gravity** (setGravity(gravity | int)) SpecialGravity.TOP, SpecialGravity.CENTER, SpecialGravity.BOTTOM
    * **convertMode** (setConvertMode(convertMode | int)) SpecialConvertMode.ONLY_FIRST, SpecialConvertMode.ALL, SpecialConvertMode.ONLY_LAST
    * **textColor** (Constructor Or setTextColor(int color))
    * **textSize** (Constructor Or setTextSize(float size)) ps
    * **backgroundColor** (setTextBackgroundColor(int color))
    * **showUnderline** (showUnderline())
    * **showStrikeThrough** (showStrikeThrough())
    * **textBold** (useTextBold())
    * **textItalic** (useTextItalic())
    * **textStyle** (setTextStyle(Typeface style))
    * **clickableUnit** (setClickableUnit(SpecialClickableUnit))
* SpecialLabelUnit
    * **text** (Constructor | String)
    * **gravity** (setGravity(gravity | int)) SpecialGravity.TOP, SpecialGravity.CENTER, SpecialGravity.BOTTOM
    * **convertMode** (setConvertMode(convertMode | int)) SpecialConvertMode.ONLY_FIRST, SpecialConvertMode.ALL, SpecialConvertMode.ONLY_LAST
    * **labelTextColor** (Constructor | int color)
    * **labelTextSize** (Constructor | int color) sp
    * **labelBgColor** (Constructor | int color)
    * **bitmap** (Constructor | Bitmap)
    * **labelBgRadius** (setLabelBgRadius(float radius)) Only support labelBgColor
    * **labelBgWidth** And **labelBgHeight** (Constructor Or setLabelBgSize(int width, int height)) px
    * **padding** (setPadding(int padding)) px
    * **paddingLeft** (setPaddingLeft(int padding)) px
    * **paddingRight** (setPaddingRight(int padding)) px
    * **labelBgBorderColor** And **borderSize** (showBorder(int labelBgBorderColor, float borderSize | px))
    * **textBold** (useTextBold())
    * **textItalic** (useTextItalic())
    * **clickable** See SimplifySpanBuild.appendMultiClickable() Or SimplifySpanBuild.appendMultiClickableToFirst()
* SpecialImageUnit
    * **text** (Constructor | String)
    * **gravity** (setGravity(gravity | int)) SpecialGravity.TOP, SpecialGravity.CENTER, SpecialGravity.BOTTOM
    * **convertMode** (setConvertMode(convertMode | int)) SpecialConvertMode.ONLY_FIRST, SpecialConvertMode.ALL, SpecialConvertMode.ONLY_LAST
    * **bitmap** (Constructor)
    * **width** And **height** (Constructor) px
    * **clickable** See SimplifySpanBuild.appendMultiClickable() Or SimplifySpanBuild.appendMultiClickableToFirst()
* SpecialClickableUnit
    * **curTextView** (Constructor | TextView)
    * **onClickListener** (Constructor | OnClickableSpanListener)
    * **isShowUnderline** (showUnderline())
    * **pressTextColor** (setPressTextColor(int color))
    * **pressBgColor** (setPressBgColor(int color))
    * **normalTextColor** (setNormalTextColor(int color))
    * **normalBgColor** (setNormalBgColor(int color))
* SpecialRawSpanUnit
    * **text** (Constructor | String)
    * **spanObj** (Constructor) Spannable Object
    * **flags** (Constructor | int) Spannable flags
    
### Support Methods
* SimplifySpanBuild
    * **append** (string | Units)
    * **appendToFirst** (string | Units)
    * **appendMultiClickable** ()
    * **appendMultiClickableToFirst** ()
    * **build** ()

### how to use ?
[Sample Code](https://github.com/iwgang/SimplifySpan/blob/master/app/src/main/java/cn/iwgang/simplifyspandemo/MainActivity.java)
```
// sample 1
tvText.setText(new SimplifySpanBuild("距离您：").append(new SpecialTextUnit("385", Color.BLUE)).append(" 米").build());

// sample 2
CharSequence spannableString = new SimplifySpanBuild(" 艾客优品雷霆Dock 2 雷电转USB3.0/火线/esata 扩展HUB")
        .appendToFirst(new SpecialLabelUnit("1212", Color.WHITE, sp2px(8), Color.RED, 70, 35).useTextBold().setGravity(SpecialGravity.CENTER))
        .appendToFirst(new SpecialLabelUnit("天猫", Color.WHITE, sp2px(8), 0xFFFF5000, 60, 35).setGravity(SpecialGravity.CENTER))
        .build();
tvText.setText(spannableString);
```
