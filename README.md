[![Android Gems](http://www.android-gems.com/badge/iwgang/SimplifySpan.svg?branch=master)](http://www.android-gems.com/lib/iwgang/SimplifySpan)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-SimplifySpan-green.svg?style=true)](http://android-arsenal.com/details/1/2907)
[![@iwgang](https://img.shields.io/badge/weibo-%40iwgang-blue.svg)](http://weibo.com/iwgang)

# SimplifySpan
A easy-to-use and powerful Spannable library

### screenshot
![](https://raw.githubusercontent.com/iwgang/SimplifySpan/master/screenshot/s1.png)   
![](https://raw.githubusercontent.com/iwgang/SimplifySpan/master/screenshot/s3.gif)  

### gradle
    compile 'com.github.iwgang:simplifyspan:1.1'
    
### Support Units
* SpecialTextUnit
    * **specialText** (Constructor | String)
    * **gravity** (setGravity(gravity | int)) SpecialGravity.TOP, SpecialGravity.CENTER, SpecialGravity.BOTTOM
    * **convertMode** (setConvertMode(convertMode | int)) SpecialConvertMode.ONLY_FIRST, SpecialConvertMode.ALL, SpecialConvertMode.ONLY_LAST
    * **specialTextColor** (Constructor Or setSpecialTextColor(int color))
    * **textSize** (Constructor Or setTextSize(float size)) ps
    * **specialTextBackgroundColor** (setSpecialTextBackgroundColor(int color))
    * **isShowUnderline** (showUnderline())
    * **isShowStrikeThrough** (showStrikeThrough())
    * **isTextBold** (useTextBold())
    * **specialClickableUnit** (setSpecialClickableUnit(SpecialClickableUnit))
* SpecialLabelUnit
    * **specialText** (Constructor | String)
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
    * **isTextBold** (useTextBold())
    * **clickable** See SimplifySpanBuild.appendMultiClickableSpecialUnit() Or SimplifySpanBuild.appendMultiClickableSpecialUnitToFirst()
* SpecialImageUnit
    * **specialText** (Constructor | String)
    * **gravity** (setGravity(gravity | int)) SpecialGravity.TOP, SpecialGravity.CENTER, SpecialGravity.BOTTOM
    * **convertMode** (setConvertMode(convertMode | int)) SpecialConvertMode.ONLY_FIRST, SpecialConvertMode.ALL, SpecialConvertMode.ONLY_LAST
    * **bitmap** (Constructor)
    * **width** And **height** (Constructor) px
    * **clickable** See SimplifySpanBuild.appendMultiClickableSpecialUnit() Or SimplifySpanBuild.appendMultiClickableSpecialUnitToFirst()
* SpecialRawSpanUnit
    * **specialText** (Constructor | String)
    * **spanObj** (Constructor) Spannable Object
    * **flags** (Constructor | int) Spannable flags
    
### Support Methods
* SimplifySpanBuild
    * **appendSpecialUnit** () 
    * **appendSpecialUnitToFirst** ()
    * **appendNormalText** ()
    * **appendNormalTextToFirst** ()
    * **appendMultiClickableSpecialUnit** ()
    * **appendMultiClickableSpecialUnitToFirst** ()
    * **build** ()

### how to use ?
[Sample Code](https://github.com/iwgang/SimplifySpan/blob/master/app/src/main/java/cn/iwgang/simplifyspandemo/MainActivity.java)
```
SimplifySpanBuild simplifySpanBuild = new SimplifySpanBuild(this, textView, " 艾客优品雷霆Dock 2 雷电转USB3.0/火线/esata 扩展HUB");
simplifySpanBuild.appendSpecialUnitToFirst(new SpecialLabelUnit("1212", Color.WHITE, 8, Color.RED, 70,35).useTextBold().setGravity(SpecialGravity.CENTER))
                 .appendSpecialUnitToFirst(new SpecialLabelUnit("天猫", Color.WHITE, 8, 0xFFFF5000, 60, 35).setGravity(SpecialGravity.CENTER));
textView.setText(simplifySpanBuild.build());
```
