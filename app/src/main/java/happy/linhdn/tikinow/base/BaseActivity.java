package happy.linhdn.tikinow.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.MotionEvent;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.viewstate.MvpViewStateActivity;
import com.hannesdorfmann.mosby.mvp.viewstate.RestorableViewState;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;

import java.util.Stack;

import happy.linhdn.tikinow.R;
import happy.linhdn.tikinow.util.Constant;
import happy.linhdn.tikinow.util.Utility;


public abstract class BaseActivity<V extends MvpView, P extends MvpPresenter<V>> extends
        MvpViewStateActivity<V, P> {
    protected BaseActivity() {
    }

    protected Stack<String> fragmentNames = new Stack<>();
    protected boolean blockAllTouchEvent = false;


    public void pushFragment(Fragment fragment, boolean addToBackStack) {
        pushFragment(fragment, Constant.TransitionType.SLIDE_IN_RIGHT_TO_LEFT, addToBackStack);

    }

    public void pushFragment(Fragment fragment, Constant.TransitionType transitionType, boolean addToBackStack) {
        blockAllTouchEventOnAnimation();

        String fragmentName = fragment.getClass().getSimpleName() + System.currentTimeMillis();

        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(transitionType.enter, transitionType.exit,
                        transitionType.popEnter, transitionType.popExit)
                .replace(R.id.fragment_container, fragment, fragmentName)
                .addToBackStack(fragmentName)
                .commitAllowingStateLoss();

        if (addToBackStack) {
            fragmentNames.push(fragmentName);
        }
    }

    public void popFragment() {
        blockAllTouchEventOnAnimation();
        if (!fragmentNames.empty()) {
            String tag = fragmentNames.pop();
            getSupportFragmentManager().popBackStack(tag,
                    FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }

    }

    public void popToFragment(int index, boolean shouldPopNamedFragment) {
        String fragmentName = fragmentNames.peek();
        getSupportFragmentManager().popBackStack(fragmentName,
                shouldPopNamedFragment ? FragmentManager.POP_BACK_STACK_INCLUSIVE : 0);

        for (int i = fragmentNames.size() - 1; i > index; i--) {
            fragmentNames.pop();
        }

        if (shouldPopNamedFragment) {
            fragmentNames.pop();
        }
    }

    public void blockAllTouchEventOnAnimation() {
        Utility.delayExecute(300)
                .doOnSubscribe(() -> blockAllTouchEvent = true)
                .doOnNext(aLong -> blockAllTouchEvent = false)
                .subscribe(new SubscriberImpl<>());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
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

    @Override
    public void onBackPressed() {
        int fragmentCount = fragmentNames.size();
        if (fragmentCount > 1) {
            String tag = fragmentNames.peek();
            Fragment fragment = getSupportFragmentManager().findFragmentByTag(
                    tag);
            if (fragment != null) {
                if (fragment instanceof BackPressedInterceptor) {
                    if (((BackPressedInterceptor) fragment).onBackPressed()) {
                        return;
                    }
                }
                popFragment();
                return;
            }
        }

        finish();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return blockAllTouchEvent || super.dispatchTouchEvent(ev);
    }

}
