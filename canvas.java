package tdc.edu.doanlaptrinhdidong2.Modules_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class canvas extends View {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public canvas(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    Paint pacmanPaint,eyePaint,eatPaint;
    public canvas(Context context) {
        super(context);
    }

    public canvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public canvas(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        pacmanPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pacmanPaint.setColor(Color.BLUE);
        pacmanPaint.setStyle(Paint.Style.FILL);
        int square = 300;
        float top = 100;
        float left = 100;
        float right = left + square;
        float bottom = top + square;
        float cx = left + 180;
        float cy = top + 70;
        float radius = 25;
        canvas.drawArc(new RectF(left,top,right,bottom),30,300,true,pacmanPaint);
        eyePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        eyePaint.setColor(Color.YELLOW);
        eyePaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(cx,cy,radius,eyePaint);
        float cy1 = top + 150;
        int topPlus = 200;
        for(int i = 0 ;i<=4 ;i++){
            float cx1 = cx + topPlus;
            eatPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            eatPaint.setColor(Color.BLACK);
            eatPaint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(cx1,cy1,radius,eatPaint);
            topPlus = topPlus + 100;
        }
        super.onDraw(canvas);
    }
}
