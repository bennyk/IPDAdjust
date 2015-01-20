package com.bennykhoo.vr.ipdadjust;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by bennykhoo on 1/19/15.
 */

public class IPDView extends View {

    public static final int TICK = 10;
    private Integer _dx = 0, _dy = 0;

    public IPDView(Context context) {
        super(context);
    }

    public IPDView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public IPDView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Integer getOffset() {
        return getWidth() / 2 + _dx;
    }

    public void adjustLeft() {
        _dx += -TICK;
        invalidate();
    }

    public void adjustRight() {
        _dx += TICK;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Integer x = getWidth() / 2 + _dx;
        Integer y = getHeight() / 2 + _dy;
        int radius;

        radius = 100;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        canvas.drawPaint(paint);
        // Use Color.parseColor to define HTML colors
        paint.setColor(Color.parseColor("#CD5C5C"));
        canvas.drawCircle(x, y, radius, paint);
    }
}
