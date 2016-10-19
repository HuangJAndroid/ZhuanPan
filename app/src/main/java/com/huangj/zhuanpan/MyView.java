package com.huangj.zhuanpan;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/9/26 9:57
 * 功能描述:
 */
public class MyView extends View {

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    private Paint mPaint;
    private String[] data =new String[8];
    public void setData(String[] data){
        this.data = data;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);

        mPaint = new Paint();
        // 必选设定画笔属性
        mPaint.setAntiAlias(false);// 抗锯齿

        // 获取视图 宽和 高 便于 确定中心点
        int w = getWidth();
        int h = getHeight();

        // 画 外边黄圆圈
        mPaint.setColor(Color.YELLOW);
        mPaint.setStyle(Paint.Style.STROKE);// 空心
        mPaint.setStrokeWidth(30.0f);// 画笔粗
        canvas.drawCircle(w / 2, h / 2, 320, mPaint);// 半径 350

        // 第2个圈

        mPaint.setARGB(255, 181, 28, 24);// 第一个参数是透明度 0是透明255 不透明
        mPaint.setStrokeWidth(40.0f);// 画笔粗
        canvas.drawCircle(w / 2, h / 2, 290, mPaint);// 半径 290
        // 里边的实心小圆 分24分 15°一份
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.YELLOW);
        canvas.drawCircle(w / 2, h / 2 - 290, 10, mPaint);
        for (int i = 0; i < 24; i++) {
            canvas.save();
            canvas.rotate(15 * i, w / 2, h / 2);
            if (i % 2 == 0) {
                mPaint.setColor(Color.BLUE);
            } else
                mPaint.setColor(Color.YELLOW);
            canvas.drawCircle(w / 2, h / 2 - 290, 10, mPaint);
            canvas.restore();
        }




        RectF rectF3 = new RectF(w / 2 - 270, h / 2 - 270, w / 2 + 270,
                h / 2 + 270);// 外切红圆圈的半径减去画笔一半
        for (int i = 0; i < 8; i++) {
            if (i%2==0) mPaint.setColor(Color.GREEN);
            else mPaint.setColor(Color.YELLOW);
            canvas.drawArc(rectF3, 45*i, 45, true, mPaint);
            mPaint.setColor(Color.BLACK);
        }
        // 扇形
        // 画弧线 参数 外切矩形 起始角度 终角度 是否封闭
        //扇形上边写字
        //  写一个转八次
        Path path = new Path();
        path.moveTo(w/2, h/2);
        path.lineTo(w/2-100,  w / 2 - 270);
        path.close();
        mPaint.setTextSize(42);

        // 沿路径绘制图片

        for (int j = 1; j < 9; j++) {
            canvas.save();

            canvas.rotate(45 * j, w / 2, h / 2);
            canvas.drawTextOnPath(data[j-1], path, 80, 0, mPaint);
            canvas.restore();
        }



        //画箭头

        canvas.restore();
        mPaint.setStyle(Paint.Style.FILL);// 实心
        mPaint.setStrokeWidth(8);//
        mPaint.setColor(Color.RED);
        Path path1 = new Path();
        path1.moveTo(w/2-40, h/2);
        path1.lineTo(w/2+30,  h/2);
        path1.lineTo(w/2,  h/2-120);
        path1.close();
        canvas.drawPath(path1, mPaint);

        // 最里层 实心园
        mPaint.setColor(Color.CYAN);
        mPaint.setStrokeWidth(2f);//
        canvas.drawCircle(w / 2, h / 2, 60, mPaint);


    }

}
