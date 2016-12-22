package com.xiaoxin.xmlxin.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.xiaoxin.xmlxin.R;
import com.xiaoxin.xmlxin.widget.MarqueeView;
import com.xiaoxin.xmlxin.widget.RippleImageView;
import com.xiaoxin.xmlxin.widget.ShareButtonView;
import com.xiaoxin.xmlxin.widget.WaveView;

public class MainActivity extends AppCompatActivity {

    private MarqueeView mMarqueeView;
    private RippleImageView rippleImageView;
    private Button btn_start,btn_stop;

    private ShareButtonView mShareButtonView;
    int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        btn_start=(Button)findViewById(R.id.btn_start);
//        btn_stop=(Button)findViewById(R.id.btn_stop);
//        rippleImageView=(RippleImageView)findViewById(R.id.rippleImageView);
//        btn_stop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //停止动画
//                rippleImageView.stopWaveAnimation();
//            }
//        });
//        btn_start.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //开始动画
//                rippleImageView.startWaveAnimation();
//            }
//        });
        mShareButtonView = (ShareButtonView) findViewById(R.id.share_button);
        mShareButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count % 2 == 0)
                    mShareButtonView.reset();
                else
                    mShareButtonView.startAnimation();
                count++;
            }
        });
        mMarqueeView=(MarqueeView)findViewById(R.id.mMarqueeView);
        mMarqueeView.setText("依据赫兹接触强度计算理论，着重研究了圆柱滚子轴承内、外圈及滚动体的接触应力");


        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMarqueeView.startScroll();
            }
        });
        findViewById(R.id.stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMarqueeView.stopScroll();
            }
        });

        mMarqueeView.setOnMargueeListener(new MarqueeView.OnMargueeListener() {
            @Override
            public void onRollOver() {
                Toast.makeText(MainActivity.this,"滚动完毕",Toast.LENGTH_LONG).show();
            }
        });

//        WaveView waveView = (WaveView) findViewById(R.id.waveView);
//        waveView.startAnim();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mMarqueeView.startScroll();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mMarqueeView.stopScroll();
    }
}
