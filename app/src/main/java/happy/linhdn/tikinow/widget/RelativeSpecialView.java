package happy.linhdn.tikinow.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class RelativeSpecialView extends RelativeLayout {
    public RelativeSpecialView(Context context) {
        super(context);
    }

    public RelativeSpecialView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RelativeSpecialView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int w = getMeasuredWidth();
        setMeasuredDimension(w, w/2);
    }

}
