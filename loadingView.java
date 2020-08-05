package tdc.edu.doanlaptrinhdidong2.touchPaintSign;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class loadingView extends View {
    Paint LoadingPaint,LoadingPaint1;
    public loadingView(Context context) {
        super(context);
        init();
    }

    public loadingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public loadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init() {
        LoadingPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        LoadingPaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        LoadingPaint.setStyle(Paint.Style.FILL);
        LoadingPaint.setColor(Color.BLUE);
        LoadingPaint.setStrokeWidth(3);

        LoadingPaint1.setStyle(Paint.Style.FILL);
        LoadingPaint1.setColor(Color.rgb(250,250,250));
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int square = 500;
        int square1 = 470;
        float top = 200;
        float top1 = 220;
        float left = 200;
        float left1 = 220;
        float right = left + square;
        float right1 = left1 + square1;
        float bottom = top + square;
        float bottom1 = top1 + square1;
        canvas.drawArc(left, top, right, bottom, 30, 300, true, LoadingPaint);
        canvas.drawArc(left1, top1, right1, bottom1, 0, 360, true, LoadingPaint1);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public loadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }
}
