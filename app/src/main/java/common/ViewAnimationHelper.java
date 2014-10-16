package common;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

/**
 * Helps with specific view animations
 * Created by Eric on 10/15/2014.
 */
public class ViewAnimationHelper {

    /**
     * Expands a view
     * @param view
     * @param duration
     */
    public static void expand(View view, int duration) {
        //set Visible
        view.setVisibility(View.VISIBLE);

        final int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        final int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        view.measure(widthSpec, heightSpec);

        ValueAnimator mAnimator = slideAnimator(view, 0, view.getMeasuredHeight());
        mAnimator.setDuration(duration);
        mAnimator.start();
    }

    /**
     * Collapses a view
     * @param view
     * @param duration
     */
    public static void collapse(final View view, int duration) {
        int finalHeight = view.getHeight();

        ValueAnimator mAnimator = slideAnimator(view, finalHeight, 0);
        mAnimator.setDuration(duration);
        mAnimator.start();
    }

    /**
     * Creates a ValueAnimator
     * @param view
     * @param start
     * @param end
     * @return
     */
    private static ValueAnimator slideAnimator(final View view, int start, int end) {

        ValueAnimator animator = ValueAnimator.ofInt(start, end);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                //Update Height
                int value = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = value;
                view.setLayoutParams(layoutParams);
            }
        });
        return animator;
    }
}
