package switcher.view.test.myapplication;


import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.AdapterViewFlipper;

public class ArticleSlider extends AdapterViewFlipper {

    private static final int GESTURE_SENSITIVITY = 50;

    private GestureDetectorCompat gestureDetectorCompat;

    public ArticleSlider(Context context) {
        super(context);
        init();
    }

    public ArticleSlider(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        gestureDetectorCompat = new GestureDetectorCompat(getContext(), simpleOnGestureListener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        gestureDetectorCompat.onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }

    GestureDetector.SimpleOnGestureListener simpleOnGestureListener = new GestureDetector.SimpleOnGestureListener() {

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float deltaMoveY = e1.getY() - e2.getY();
            if (deltaMoveY > GESTURE_SENSITIVITY) {
                onSwipeDown();
            } else if (deltaMoveY < GESTURE_SENSITIVITY) {
                onSwipeUp();
            }
            return true;
        }

    };

    private ArticleView.ScrollState getScrollState() {
        if (getAdapter() instanceof ArticleSliderAdapter) {
            return ((ArticleSliderAdapter) getAdapter()).getScrollState();
        }
        return ArticleView.ScrollState.SCROLLING;
    }

    private void onSwipeUp() {
        Log.i("TTT", "swipe up");
        if (getScrollState() == ArticleView.ScrollState.TOP_EDGE) {
            setOutAnimation(getContext(), R.animator.current_top);
            setInAnimation(getContext(), R.animator.previous_current);
            showPrevious();
        }
    }

    private void onSwipeDown() {
        Log.i("TTT", "swipe down");
        if (getScrollState() == ArticleView.ScrollState.BOTTOM_EDGE) {
            setOutAnimation(getContext(), R.animator.current_bottom);
            setInAnimation(getContext(), R.animator.next_current);
            showNext();
        }
    }

}
