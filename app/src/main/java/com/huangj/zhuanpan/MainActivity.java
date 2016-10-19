package com.huangj.zhuanpan;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView star;
    MyView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        star=(TextView) findViewById(R.id.start);
        mView=(MyView) findViewById(R.id.myview);
        mView.setData(new String[]{"一等奖","二等奖","三等奖","四等奖","五等奖","六等奖","七等奖","八等奖"});

        star.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                int min=1,max=359;
                final int s=(new Random()).nextInt(max)%(max-min-1)+min;
                RotateAnimation rotate = new RotateAnimation(0, 720+s,
                        Animation.ABSOLUTE,  mView.getWidth() / 2,
                        Animation.ABSOLUTE, mView.getHeight() / 2);
                rotate.setDuration(1500);
                rotate.setFillAfter(true);
                //rotate.setInterpolator(new LinearInterpolator());
                mView.startAnimation(rotate);
                rotate.setAnimationListener(new Animation.AnimationListener() {

                    @Override
                    public void onAnimationStart(Animation animation) {
                        // TODO Auto-generated method stub 13591774480
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        // TODO Auto-generated method stub
                        int a=8-s/45;
                        Toast.makeText(getApplicationContext(), "恭喜您"+a+"等奖"+s, Toast.LENGTH_SHORT).show();
                    }
                });



            }
        });
    }
}
