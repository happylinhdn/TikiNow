
package happy.linhdn.tikinow.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.viewstate.MvpViewStateFragment;
import com.hannesdorfmann.mosby.mvp.viewstate.RestorableViewState;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;

import happy.linhdn.tikinow.presenter.BasePresenter;
import happy.linhdn.tikinow.view.BaseView;


public abstract class BaseFragment<V extends BaseView, P extends BasePresenter<V>> extends
        MvpViewStateFragment<V, P> implements BackPressedInterceptor {

    public boolean shouldPerformExitTransition = true;
    protected boolean blockBackButtonPressed = false;

    protected abstract int getFragmentLayoutId();

    protected int getBackgroundImage() {
        return 0;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(getFragmentLayoutId(), container, false);

        return view;
    }

    @Override
    public boolean onBackPressed() {
        return blockBackButtonPressed;
    }

    protected boolean shouldPerformExitTransition() {
        return shouldPerformExitTransition;
    }

    @Override
    public final Animation onCreateAnimation(int transit, final boolean enter,
                                             int nextAnim) {
        if (nextAnim != 0) {
            if (!enter && !shouldPerformExitTransition()) {
                return null;
            }

            Animation anim = AnimationUtils.loadAnimation(getActivity(), nextAnim);

            anim.setAnimationListener(new Animation.AnimationListener() {

                public void onAnimationStart(Animation animation) {
                    blockBackButtonPressed = true;
                }

                public void onAnimationEnd(Animation animation) {
                    if (enter) {
                        blockBackButtonPressed = false;
                        onFragmentTransitionEnd();
                    }
                }

                public void onAnimationRepeat(Animation animation) {
                }

            });

            return anim;
        }

        if (enter) {
            blockBackButtonPressed = false;
            onFragmentTransitionEnd();
        }
        return null;
    }

    @NonNull
    @Override
    public ViewState createViewState() {
        return new RestorableViewState() {
            @Override
            public void saveInstanceState(@NonNull Bundle out) {

            }

            @Override
            public RestorableViewState restoreInstanceState(Bundle in) {
                return null;
            }

            @Override
            public void apply(MvpView view, boolean retained) {

            }
        };
    }

    protected boolean checkFragmentAvailable(Fragment fragment) {
        return fragment != null && !fragment.isDetached() && fragment.getView() != null;
    }

    @Override
    public void onNewViewStateInstance() {
        getPresenter().onNewViewStateInstance();
    }

    protected void onFragmentTransitionEnd() {
    }

    public void showMessage(int msgId, boolean success) {
        //AlertUtil.showTopSnackbar(getView(), msgId, success);
    }

    public void showMessage(String message, boolean success) {
       // AlertUtil.showTopSnackbar(getView(), message, success);
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }
}
