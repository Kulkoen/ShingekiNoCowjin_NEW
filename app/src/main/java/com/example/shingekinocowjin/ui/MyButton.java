package com.example.shingekinocowjin.ui;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class MyButton {
    private int left, top, right, bottom;
    private String text;
    private Rect bounds;
    int bodyColor = Color.GRAY;

    public MyButton(String text, int left, int top, int right, int bottom) {
        this.text = text;
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        initBounds();
    }

    private void initBounds() {
        this.bounds = new Rect(left, top, right, bottom);
    }

    public void drawButton(Canvas canvas) {
        // Body
        Paint bodyPaint = new Paint();
        bodyPaint.setColor(bodyColor);
        canvas.drawRect(left, top, right, bottom, bodyPaint);
        // Border
        Paint borderPaint = new Paint();
        borderPaint.setStrokeWidth(10);
        borderPaint.setColor(Color.BLACK);
        borderPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(left, top, right, bottom, borderPaint);
        // Text
        Paint textPaint = new Paint();
        int textColor = Color.BLACK;
        textPaint.setColor(textColor);
        textPaint.setTextSize(50);
        Rect textBounds = new Rect();
        textPaint.getTextBounds(text, 0, text.length(), textBounds);
        int height = textBounds.height();
        int width = textBounds.width();
        canvas.drawText(text, ((right + left) - width) / 2, ((bottom + top) + height) / 2, textPaint);
    }

    public Rect getBounds() {
        return bounds;
    }

    public void setBodyPaint(int color) {
        bodyColor = color;
    };

}
