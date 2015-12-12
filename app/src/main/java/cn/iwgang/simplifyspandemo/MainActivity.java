package cn.iwgang.simplifyspandemo;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import cn.iwgang.simplifyspan.SimplifySpanBuild;
import cn.iwgang.simplifyspan.other.OnClickableSpanListener;
import cn.iwgang.simplifyspan.other.SpecialConvertModeEnum;
import cn.iwgang.simplifyspan.other.SpecialGravityEnum;
import cn.iwgang.simplifyspan.unit.SpecialImageUnit;
import cn.iwgang.simplifyspan.unit.SpecialLabelUnit;
import cn.iwgang.simplifyspan.unit.SpecialTextUnit;

public class MainActivity extends AppCompatActivity implements OnClickableSpanListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvText1 = (TextView)findViewById(R.id.tv_text1);
        TextView tvText11 = (TextView)findViewById(R.id.tv_text11);
        TextView tvText2 = (TextView)findViewById(R.id.tv_text2);
        TextView tvText21 = (TextView)findViewById(R.id.tv_text21);
        TextView tvText22 = (TextView)findViewById(R.id.tv_text22);
        TextView tvText3 = (TextView)findViewById(R.id.tv_text3);
        TextView tvText4 = (TextView)findViewById(R.id.tv_text4);


        SimplifySpanBuild simplifySpanBuild1 = new SimplifySpanBuild(this, tvText1, " 艾客优品雷霆Dock 2 雷电转USB3.0/火线/esata 扩展HUB");
        simplifySpanBuild1.appendSpecialUnitToFirst(new SpecialLabelUnit("1212", Color.WHITE, 8, Color.RED, 70, 35).useTextBold().setGravity(SpecialGravityEnum.CENTER))
                .appendSpecialUnitToFirst(new SpecialLabelUnit("天猫", Color.WHITE, 8, 0xFFFF5000, 60, 35).setGravity(SpecialGravityEnum.CENTER));
        tvText1.setText(simplifySpanBuild1.build());


        SimplifySpanBuild simplifySpanBuild11 = new SimplifySpanBuild(this, tvText11);
        simplifySpanBuild11.appendSpecialUnit(new SpecialLabelUnit("火", Color.RED, 7, BitmapFactory.decodeResource(getResources(), R.drawable.label)).setPadding(15).setGravity(SpecialGravityEnum.CENTER))
                          .appendNormalText("正常")
                          .appendSpecialUnit(new SpecialLabelUnit("火", Color.RED, 7, BitmapFactory.decodeResource(getResources(), R.drawable.label)).setPadding(15).setGravity(SpecialGravityEnum.TOP))
                          .appendNormalText("正常")
                          .appendSpecialUnit(new SpecialLabelUnit("火", Color.RED, 7, BitmapFactory.decodeResource(getResources(), R.drawable.label)).setPadding(15).setGravity(SpecialGravityEnum.BOTTOM))
                          .appendNormalText("正常")
                          .appendSpecialUnit(new SpecialLabelUnit("原创", Color.BLACK, 10, BitmapFactory.decodeResource(getResources(), R.drawable.tag)).setPadding(5).setPaddingLeft(15).setPaddingRight(30).setGravity(SpecialGravityEnum.TOP))
                          .appendNormalText("正常")
                          .appendSpecialUnit(new SpecialLabelUnit("原创", Color.BLACK, 10, BitmapFactory.decodeResource(getResources(), R.drawable.tag)).setPadding(5).setPaddingLeft(15).setPaddingRight(30).setGravity(SpecialGravityEnum.CENTER))
                          .appendNormalText("正常")
                          .appendSpecialUnit(new SpecialLabelUnit("原创", Color.BLACK, 10, BitmapFactory.decodeResource(getResources(), R.drawable.tag)).setPadding(5).setPaddingLeft(15).setPaddingRight(30).setGravity(SpecialGravityEnum.BOTTOM))
                          .appendNormalText("正常")
                          .appendSpecialUnit(new SpecialLabelUnit("原创", Color.WHITE, 10, 0xFFFF5000).setLabelBgRadius(5).setPadding(5).setPaddingLeft(10).setPaddingRight(10).setGravity(SpecialGravityEnum.BOTTOM))
                          .appendNormalText("正常")
                          .appendSpecialUnit(new SpecialLabelUnit("原创", Color.WHITE, 10, 0xFFFF5000).setLabelBgRadius(5).setPadding(5).setPaddingLeft(10).setPaddingRight(10).setGravity(SpecialGravityEnum.TOP))
                          .appendNormalText("正常")
                          .appendSpecialUnit(new SpecialLabelUnit("原创", Color.WHITE, 10, 0xFFFF5000).setLabelBgRadius(5).setPadding(5).setPaddingLeft(10).setPaddingRight(10).setGravity(SpecialGravityEnum.CENTER))
                          .appendNormalText("正常")
                          .appendSpecialUnit(new SpecialLabelUnit("原创", Color.WHITE, 10, Color.GRAY).setLabelBgRadius(5).showShowBorder(Color.BLACK, 2).setPadding(5).setPaddingLeft(10).setPaddingRight(10).setGravity(SpecialGravityEnum.BOTTOM))
                          .appendNormalText("正常")
                          .appendSpecialUnit(new SpecialLabelUnit("原创", Color.WHITE, 10, Color.GRAY).setLabelBgRadius(5).showShowBorder(Color.BLACK, 2).setPadding(5).setPaddingLeft(10).setPaddingRight(10).setGravity(SpecialGravityEnum.TOP))
                          .appendNormalText("正常")
                          .appendSpecialUnit(new SpecialLabelUnit("原创", Color.WHITE, 10, Color.GRAY).setLabelBgRadius(5).showShowBorder(Color.BLACK, 2).setPadding(5).setPaddingLeft(10).setPaddingRight(10).setGravity(SpecialGravityEnum.CENTER))
                          .appendNormalText("正常")
                          .appendSpecialUnit(new SpecialLabelUnit("原创", Color.RED, 10, Color.TRANSPARENT).showShowBorder(Color.BLACK, 2).setPadding(5).setPaddingLeft(10).setPaddingRight(10).setGravity(SpecialGravityEnum.BOTTOM))
                          .appendNormalText("正常")
                          .appendSpecialUnit(new SpecialLabelUnit("原创", Color.RED, 10, Color.TRANSPARENT).showShowBorder(Color.BLACK, 2).setPadding(5).setPaddingLeft(10).setPaddingRight(10).setGravity(SpecialGravityEnum.TOP))
                          .appendNormalText("正常")
                          .appendSpecialUnit(new SpecialLabelUnit("原创", Color.RED, 10, Color.TRANSPARENT).showShowBorder(Color.BLACK, 2).setPadding(5).setPaddingLeft(10).setPaddingRight(10).setGravity(SpecialGravityEnum.CENTER));
        tvText11.setText(simplifySpanBuild11.build());


        SimplifySpanBuild simplifySpanBuild2 = new SimplifySpanBuild(this, tvText2, "替换所有张字的颜色及字体大小并加粗，张歆艺、张馨予、张嘉倪、张涵予、张含韵、张韶涵、张嘉译、张佳宁、大张伟", new SpecialTextUnit("张").useTextBold().setTextSize(20).setSpecialTextColor(0xFFFFA500).setConvertMode(SpecialConvertModeEnum.ALL));
        tvText2.setText(simplifySpanBuild2.build());


        SimplifySpanBuild simplifySpanBuild21 = new SimplifySpanBuild(this, tvText21);
        simplifySpanBuild21.appendSpecialUnit(new SpecialTextUnit("居中").setTextSize(12).setGravity(SpecialGravityEnum.CENTER).setSpecialTextColor(Color.BLUE))
                          .appendNormalText("正常")
                          .appendSpecialUnit(new SpecialTextUnit("顶部").setTextSize(12).setGravity(SpecialGravityEnum.TOP).setSpecialTextColor(0xFFFF5000))
                          .appendNormalText("正常")
                          .appendSpecialUnit(new SpecialTextUnit("底部").setTextSize(12).setSpecialTextColor(0xFF8B658B));
        tvText21.setText(simplifySpanBuild21.build());


        SimplifySpanBuild simplifySpanBuild22 = new SimplifySpanBuild(this, tvText22, "正常底部正常居中正常顶部正常",
                                                                                     new SpecialTextUnit("底部").setTextSize(30).setSpecialTextColor(Color.BLUE),
                                                                                     new SpecialTextUnit("居中").setTextSize(30).setGravity(SpecialGravityEnum.CENTER).setSpecialTextColor(0xFFB03060),
                                                                                     new SpecialTextUnit("顶部").setTextSize(30).setGravity(SpecialGravityEnum.TOP).setSpecialTextColor(0xFFB0C4DE));
        tvText22.setText(simplifySpanBuild22.build());


        SimplifySpanBuild simplifySpanBuild3 = new SimplifySpanBuild(this, tvText3);
        simplifySpanBuild3.appendSpecialUnit(new SpecialImageUnit(BitmapFactory.decodeResource(getResources(), R.drawable.ic_bulletin), 50, 50).setGravity(SpecialGravityEnum.CENTER))
                          .appendNormalText("正常")
                          .appendSpecialUnit(new SpecialImageUnit(BitmapFactory.decodeResource(getResources(), R.drawable.test_img), 150, 150))
                          .appendNormalText("正常")
                          .appendSpecialUnit(new SpecialImageUnit(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher), 50, 50).setGravity(SpecialGravityEnum.CENTER))
                          .appendNormalText("正常")
                          .appendSpecialUnit(new SpecialImageUnit(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher), 50, 50).setGravity(SpecialGravityEnum.TOP))
                          .appendNormalText("正常")
                          .appendSpecialUnit(new SpecialImageUnit(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher), 50, 50).setGravity(SpecialGravityEnum.BOTTOM));
        tvText3.setText(simplifySpanBuild3.build());


        SimplifySpanBuild simplifySpanBuild4 = new SimplifySpanBuild(this, tvText4);
        simplifySpanBuild4.appendNormalText("无默认背景")
                          .appendSpecialUnit(new SpecialTextUnit("点我点我1").setOnClickListener(false, 0xFFFF5000, this).setSpecialTextColor(Color.BLUE))
                          .appendNormalText("无默认背景显示下划线")
                          .appendSpecialUnit(new SpecialTextUnit("点我点我2").setOnClickListener(true, 0xFFFF5000, Color.WHITE, this).setSpecialTextColor(0xFFFF5000))
                          .appendNormalText("有默认背景显示下划线")
                          .appendSpecialUnit(new SpecialTextUnit("点我点我3").setOnClickListener(false, Color.BLUE, Color.WHITE, this).setSpecialTextColor(0xFFFF5000).setSpecialTextBackgroundColor(0xFF87CEEB))
                           .appendNormalText("我只是个结尾");
        tvText4.setText(simplifySpanBuild4.build());
    }

    @Override
    public void onClick(TextView tv, String clickText) {
        Toast.makeText(MainActivity.this, "Click Text: " + clickText, Toast.LENGTH_SHORT).show();
    }
}
