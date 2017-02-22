package cn.iwgang.simplifyspandemo;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import cn.iwgang.simplifyspan.SimplifySpanBuild;
import cn.iwgang.simplifyspan.other.OnClickableSpanListener;
import cn.iwgang.simplifyspan.other.SpecialConvertMode;
import cn.iwgang.simplifyspan.other.SpecialGravity;
import cn.iwgang.simplifyspan.unit.SpecialClickableUnit;
import cn.iwgang.simplifyspan.unit.SpecialImageUnit;
import cn.iwgang.simplifyspan.unit.SpecialLabelUnit;
import cn.iwgang.simplifyspan.unit.SpecialTextUnit;

public class MainActivity extends AppCompatActivity implements OnClickableSpanListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvText1 = (TextView) findViewById(R.id.tv_text1);
        TextView tvText11 = (TextView) findViewById(R.id.tv_text11);
        TextView tvText2 = (TextView) findViewById(R.id.tv_text2);
        TextView tvText21 = (TextView) findViewById(R.id.tv_text21);
        TextView tvText22 = (TextView) findViewById(R.id.tv_text22);
        TextView tvText3 = (TextView) findViewById(R.id.tv_text3);
        TextView tvText4 = (TextView) findViewById(R.id.tv_text4);
        TextView tvText41 = (TextView)findViewById(R.id.tv_text41);

        SimplifySpanBuild simplifySpanBuild1 = new SimplifySpanBuild(" 艾客优品雷霆Dock 2 雷电转USB3.0/火线/esata 扩展HUB");
        simplifySpanBuild1.appendSpecialUnitToFirst(new SpecialLabelUnit("1212", Color.WHITE, sp2px(8), Color.RED, 70, 35).useTextBold().setGravity(SpecialGravity.CENTER))
                .appendSpecialUnitToFirst(new SpecialLabelUnit("天猫", Color.WHITE, sp2px(8), 0xFFFF5000, 60, 35).setGravity(SpecialGravity.CENTER));
        tvText1.setText(simplifySpanBuild1.build());


        SimplifySpanBuild simplifySpanBuild11 = new SimplifySpanBuild();
        simplifySpanBuild11.appendSpecialUnit(new SpecialLabelUnit("火", Color.RED, sp2px(7), BitmapFactory.decodeResource(getResources(), R.drawable.label)).setPadding(15).setGravity(SpecialGravity.CENTER))
                .appendNormalText("正常")
                .appendSpecialUnit(new SpecialLabelUnit("火", Color.RED, sp2px(7), BitmapFactory.decodeResource(getResources(), R.drawable.label)).setPadding(15).setGravity(SpecialGravity.TOP))
                .appendNormalText("正常")
                .appendSpecialUnit(new SpecialLabelUnit("火", Color.RED, sp2px(7), BitmapFactory.decodeResource(getResources(), R.drawable.label)).setPadding(15).setGravity(SpecialGravity.BOTTOM))
                .appendNormalText("正常")
                .appendSpecialUnit(new SpecialLabelUnit("原创", Color.BLACK, sp2px(10), BitmapFactory.decodeResource(getResources(), R.drawable.tag)).setPadding(5).setPaddingLeft(15).setPaddingRight(30).setGravity(SpecialGravity.TOP))
                .appendNormalText("正常")
                .appendSpecialUnit(new SpecialLabelUnit("原创", Color.BLACK, sp2px(10), BitmapFactory.decodeResource(getResources(), R.drawable.tag)).setPadding(5).setPaddingLeft(15).setPaddingRight(30).setGravity(SpecialGravity.CENTER))
                .appendNormalText("正常")
                .appendSpecialUnit(new SpecialLabelUnit("原创", Color.BLACK, sp2px(10), BitmapFactory.decodeResource(getResources(), R.drawable.tag)).setPadding(5).setPaddingLeft(15).setPaddingRight(30).setGravity(SpecialGravity.BOTTOM))
                .appendNormalText("正常")
                .appendSpecialUnit(new SpecialLabelUnit("原创", Color.WHITE, sp2px(10), 0xFFFF5000).setLabelBgRadius(5).setPadding(5).setPaddingLeft(10).setPaddingRight(10).setGravity(SpecialGravity.BOTTOM))
                .appendNormalText("正常")
                .appendSpecialUnit(new SpecialLabelUnit("原创", Color.WHITE, sp2px(10), 0xFFFF5000).setLabelBgRadius(5).setPadding(5).setPaddingLeft(10).setPaddingRight(10).setGravity(SpecialGravity.TOP))
                .appendNormalText("正常")
                .appendSpecialUnit(new SpecialLabelUnit("原创", Color.WHITE, sp2px(10), 0xFFFF5000).setLabelBgRadius(5).setPadding(5).setPaddingLeft(10).setPaddingRight(10).setGravity(SpecialGravity.CENTER))
                .appendNormalText("正常")
                .appendSpecialUnit(new SpecialLabelUnit("原创", Color.WHITE, sp2px(10), Color.GRAY).setLabelBgRadius(5).showBorder(Color.BLACK, 2).setPadding(5).setPaddingLeft(10).setPaddingRight(10).setGravity(SpecialGravity.BOTTOM))
                .appendNormalText("正常")
                .appendSpecialUnit(new SpecialLabelUnit("原创", Color.WHITE, sp2px(10), Color.GRAY).setLabelBgRadius(5).showBorder(Color.BLACK, 2).setPadding(5).setPaddingLeft(10).setPaddingRight(10).setGravity(SpecialGravity.TOP))
                .appendNormalText("正常")
                .appendSpecialUnit(new SpecialLabelUnit("原创", Color.WHITE, sp2px(10), Color.GRAY).setLabelBgRadius(5).showBorder(Color.BLACK, 2).setPadding(5).setPaddingLeft(10).setPaddingRight(10).setGravity(SpecialGravity.CENTER))
                .appendNormalText("正常")
                .appendSpecialUnit(new SpecialLabelUnit("原创", Color.RED, sp2px(10), Color.TRANSPARENT).showBorder(Color.BLACK, 2).setPadding(5).setPaddingLeft(10).setPaddingRight(10).setGravity(SpecialGravity.BOTTOM))
                .appendNormalText("正常")
                .appendSpecialUnit(new SpecialLabelUnit("原创", Color.RED, sp2px(10), Color.TRANSPARENT).showBorder(Color.BLACK, 2).setPadding(5).setPaddingLeft(10).setPaddingRight(10).setGravity(SpecialGravity.TOP))
                .appendNormalText("正常")
                .appendSpecialUnit(new SpecialLabelUnit("原创", Color.RED, sp2px(10), Color.TRANSPARENT).showBorder(Color.BLACK, 2).setPadding(5).setPaddingLeft(10).setPaddingRight(10).setGravity(SpecialGravity.CENTER));
        tvText11.setText(simplifySpanBuild11.build());


        SimplifySpanBuild simplifySpanBuild2 = new SimplifySpanBuild("替换所有张字的颜色及字体大小并加粗，张歆艺、张馨予、张嘉倪、张涵予、张含韵、张韶涵、张嘉译、张佳宁、大张伟", new SpecialTextUnit("张").useTextBold().setTextSize(20).setSpecialTextColor(0xFFFFA500).setConvertMode(SpecialConvertMode.ALL));
        tvText2.setText(simplifySpanBuild2.build());


        SimplifySpanBuild simplifySpanBuild21 = new SimplifySpanBuild();
        simplifySpanBuild21.appendSpecialUnit(new SpecialTextUnit("居中").setTextSize(12).setGravity(tvText21, SpecialGravity.CENTER).setSpecialTextColor(Color.BLUE))
                .appendNormalText("正常")
                .appendSpecialUnit(new SpecialTextUnit("顶部").setTextSize(12).setGravity(tvText21, SpecialGravity.TOP).setSpecialTextColor(0xFFFF5000))
                .appendNormalText("正常")
                .appendSpecialUnit(new SpecialTextUnit("底部").setTextSize(12).setSpecialTextColor(0xFF8B658B));
        tvText21.setText(simplifySpanBuild21.build());


        SimplifySpanBuild simplifySpanBuild22 = new SimplifySpanBuild("正常底部正常居中正常顶部正常",
                new SpecialTextUnit("底部").setTextSize(30).setSpecialTextColor(Color.BLUE),
                new SpecialTextUnit("居中").setTextSize(30).setGravity(tvText22, SpecialGravity.CENTER).setSpecialTextColor(0xFFB03060),
                new SpecialTextUnit("顶部").setTextSize(30).setGravity(tvText22, SpecialGravity.TOP).setSpecialTextColor(0xFFB0C4DE));
        tvText22.setText(simplifySpanBuild22.build());


        SimplifySpanBuild simplifySpanBuild3 = new SimplifySpanBuild();
        simplifySpanBuild3.appendSpecialUnit(new SpecialImageUnit(this, BitmapFactory.decodeResource(getResources(), R.drawable.ic_bulletin), 50, 50).setGravity(SpecialGravity.CENTER))
                .appendNormalText("正常")
                .appendSpecialUnit(new SpecialImageUnit(this, BitmapFactory.decodeResource(getResources(), R.drawable.test_img), 150, 150))
                .appendNormalText("正常")
                .appendSpecialUnit(new SpecialImageUnit(this, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher), 50, 50).setGravity(SpecialGravity.CENTER))
                .appendNormalText("正常")
                .appendSpecialUnit(new SpecialImageUnit(this, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher), 50, 50).setGravity(SpecialGravity.TOP))
                .appendNormalText("正常")
                .appendSpecialUnit(new SpecialImageUnit(this, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher), 50, 50).setGravity(SpecialGravity.BOTTOM));
        tvText3.setText(simplifySpanBuild3.build());


        int linkNorTextColor = 0xFF483D8B;
        int linkPressBgColor = 0xFF87CEFA;
        SimplifySpanBuild simplifySpanBuild4 = new SimplifySpanBuild();
        simplifySpanBuild4.appendSpecialUnit(new SpecialTextUnit("@英雄联盟", linkNorTextColor).setSpecialClickableUnit(new SpecialClickableUnit(tvText4, this).setPressBgColor(linkPressBgColor)))
                .appendNormalText(" : ")
                .appendSpecialUnit(new SpecialTextUnit("#LOG夜话#", linkNorTextColor).setSpecialClickableUnit(new SpecialClickableUnit(tvText4, this).setPressBgColor(linkPressBgColor)))
                .appendSpecialUnit(new SpecialTextUnit("#LOL明星召唤师#", linkNorTextColor).setSpecialClickableUnit(new SpecialClickableUnit(tvText4, this).setPressBgColor(linkPressBgColor)))
                .appendNormalText("星光熠熠的各赛区阵容、精彩的1V1Solo赛、克隆/双人共玩等奇葩套路层出不穷的花样对抗，你最期待看到哪位选手、哪种模式的对决？");
        simplifySpanBuild4.appendMultiClickableSpecialUnit(new SpecialClickableUnit(tvText4, this).setNormalTextColor(linkNorTextColor).setPressBgColor(linkPressBgColor),
                " ",
                new SpecialImageUnit(this, BitmapFactory.decodeResource(getResources(), R.drawable.timeline_card_small_video), 35, 35).setGravity(SpecialGravity.CENTER),
                new SpecialTextUnit("LOL新大战闻声识英雄 "));
        simplifySpanBuild4.appendNormalText("完整文章见 ");
        simplifySpanBuild4.appendMultiClickableSpecialUnit(new SpecialClickableUnit(tvText4, this).setNormalTextColor(linkNorTextColor).setPressBgColor(linkPressBgColor),
                new SpecialImageUnit(this, BitmapFactory.decodeResource(getResources(), R.drawable.timeline_card_small_article), 30, 30).setGravity(SpecialGravity.CENTER),
                new SpecialTextUnit("LOL超强攻略,不见绝对后悔 "));
        simplifySpanBuild4.appendNormalText(" 更多好玩的内容请点击 ");
        simplifySpanBuild4.appendMultiClickableSpecialUnit(new SpecialClickableUnit(tvText4, this).setNormalTextColor(linkNorTextColor).setPressBgColor(linkPressBgColor),
                new SpecialImageUnit(this, BitmapFactory.decodeResource(getResources(), R.drawable.timeline_card_small_web), 42, 42).setGravity(SpecialGravity.CENTER),
                new SpecialTextUnit("网页链接"));
        simplifySpanBuild4.appendNormalText(" 已收录 ");
        simplifySpanBuild4.appendMultiClickableSpecialUnit(new SpecialClickableUnit(tvText4, this).setNormalTextColor(linkNorTextColor).setPressBgColor(linkPressBgColor),
                " ",
                new SpecialLabelUnit("酷玩", 0xFF483D8B, sp2px(8), Color.TRANSPARENT).showBorder(0xFF483D8B, 2).setLabelBgRadius(8).setPadding(5).setPaddingLeft(8).setPaddingRight(10).setGravity(SpecialGravity.CENTER),
                new SpecialTextUnit(" LOL新闻库 "));
        simplifySpanBuild4.appendNormalText(" 后面加的内容是为了凑字数的哈");
        tvText4.setText(simplifySpanBuild4.build());


        SimplifySpanBuild simplifySpanBuild41 = new SimplifySpanBuild();
        simplifySpanBuild41.appendNormalText("无默认背景")
                .appendSpecialUnit(new SpecialTextUnit("点我点我1").setSpecialClickableUnit(new SpecialClickableUnit(tvText41, this).setPressBgColor(0xFFFF5000)).setSpecialTextColor(Color.BLUE))
                .appendNormalText("无默认背景显示下划线")
                .appendSpecialUnit(new SpecialTextUnit("点我点我2").setSpecialClickableUnit(new SpecialClickableUnit(tvText41, this).showUnderline().setPressBgColor(0xFFFF5000).setPressTextColor(Color.WHITE)).setSpecialTextColor(0xFFFF5000))
                .appendNormalText("有默认背景")
                .appendSpecialUnit(new SpecialTextUnit("点我点我3").setSpecialClickableUnit(new SpecialClickableUnit(tvText41, this).setPressBgColor(Color.BLUE).setPressTextColor(Color.WHITE)).setSpecialTextColor(0xFFFF5000).setSpecialTextBackgroundColor(0xFF87CEEB))
                .appendNormalText("我只是个结尾");
        tvText41.setText(simplifySpanBuild41.build());
    }

    @Override
    public void onClick(TextView tv, String clickText) {
        Toast.makeText(MainActivity.this, "Click Text: " + clickText, Toast.LENGTH_SHORT).show();
    }

    private float sp2px(float spValue) {
        final float scale = getResources().getDisplayMetrics().scaledDensity;
        return spValue * scale;
    }
}
