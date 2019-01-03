package happy.linhdn.tikinow.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ProgressBar;

import happy.linhdn.tikinow.R;
import happy.linhdn.tikinow.base.BaseActivity;
import happy.linhdn.tikinow.presenter.SplashActivityPresenter;
import happy.linhdn.tikinow.view.SplashActivityView;

public class SplashActivity extends BaseActivity<SplashActivityView, SplashActivityPresenter> implements SplashActivityView {
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        progressBar = findViewById(R.id.main_progress);
    }

    @NonNull
    @Override
    public SplashActivityPresenter createPresenter() {
        return new SplashActivityPresenter();
    }

    @Override
    public void onNewViewStateInstance() {
        getPresenter().onNewViewStateInstance();
    }

    @Override
    public void showMessage(int msgId, boolean success) {

    }

    @Override
    public void showMessage(String message, boolean success) {

    }

    public void showMainActivity() {
        if (progressBar != null) {
            progressBar.setVisibility(View.GONE);
        }
        startActivity(new Intent(this, MainActivity.class));
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.stand_still);
        finish();
    }

    @Override
    public void showLoading() {
        System.out.println("LINH showLoading ");
        if (progressBar != null) {
            progressBar.setVisibility(View.VISIBLE);
        }
        new Handler().postDelayed(() -> showMainActivity(), 2000);
    }
}
