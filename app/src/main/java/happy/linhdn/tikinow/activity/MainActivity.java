package happy.linhdn.tikinow.activity;

import android.support.annotation.NonNull;
import android.os.Bundle;

import happy.linhdn.tikinow.R;
import happy.linhdn.tikinow.base.BaseActivity;
import happy.linhdn.tikinow.util.Constant;
import happy.linhdn.tikinow.fragment.HomeFragment;
import happy.linhdn.tikinow.presenter.MainActivityPresenter;
import happy.linhdn.tikinow.view.MainActivityView;

public class MainActivity extends BaseActivity<MainActivityView, MainActivityPresenter> implements MainActivityView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @NonNull
    @Override
    public MainActivityPresenter createPresenter() {
        return new MainActivityPresenter();
    }

    @Override
    public void onNewViewStateInstance() {
        getPresenter().onNewViewStateInstance();
    }

    @Override
    public void showHomePage() {
        pushFragment(new HomeFragment(), Constant.TransitionType.NONE, true);
    }

    @Override
    public void showMessage(int msgId, boolean success) {

    }

    @Override
    public void showMessage(String message, boolean success) {

    }
}
