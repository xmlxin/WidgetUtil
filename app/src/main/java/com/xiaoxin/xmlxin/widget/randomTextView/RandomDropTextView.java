package com.xiaoxin.xmlxin.widget.randomTextView;

import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.xiaoxin.xmlxin.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 文字一个一个显示
 * Created by james on 14/10/15.
 */
public class RandomDropTextView extends LinearLayout {
    private final int default_text_color = Color.BLACK;
    private final int default_duration_time = 2000;

    private String text;
    private int duration;
    private int color;
    private int index;
    private List<TextView> textViewList;

    public RandomDropTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        init();
    }

    public RandomDropTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //load styled attributes.
        final TypedArray attributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.RandomShowTextView,
                defStyleAttr, 0);

        text = attributes.getString(R.styleable.RandomShowTextView_text);
        duration = attributes.getInt(R.styleable.RandomShowTextView_duration, default_duration_time);
        color = attributes.getColor(R.styleable.RandomShowTextView_textColor, default_text_color);
        init();
        fireWork();
        playNext();
    }


    private void init() {
        setOrientation(HORIZONTAL);
    }

    private void fireWork() {
        text = "马勒戈壁";
        textViewList = new ArrayList<TextView>();
        for (int i = 0; i < text.length(); i++) {
            TextView textView = new TextView(getContext());
            textView.setTextColor(Color.BLACK);
            textView.setText("吗");
            textView.setTextSize(40);
            textView.setVisibility(INVISIBLE);
            textViewList.add(textView);
            addView(textView);
        }
        Collections.shuffle(textViewList);
    }

    private void playNext() {
        AnimatorSet animatorSet = new AnimatorSet();
        TextView textView = textViewList.get(index);
        textView.setVisibility(VISIBLE);
        YoYo.with(Techniques.ZoomInLeft)
                .duration(700)
                .withListener(new com.nineoldandroids.animation.Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(com.nineoldandroids.animation.Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(com.nineoldandroids.animation.Animator animation) {
                        if (index == textViewList.size()) {
                            index = 0;
                            return;
                        }
                        playNext();
                    }

                    @Override
                    public void onAnimationCancel(com.nineoldandroids.animation.Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(com.nineoldandroids.animation.Animator animation) {

                    }
                })
                .playOn(textView);
        index++;
    }

    private void setText(String text) {
        this.text = text;
        fireWork();
    }

    private void startAnimaion() {
        fireWork();
    }

}
