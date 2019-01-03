
package happy.linhdn.tikinow.presenter;


import happy.linhdn.tikinow.view.SplashActivityView;

public class SplashActivityPresenter extends BasePresenter<SplashActivityView> {
    @Override
    public void onNewViewStateInstance() {
        if (isViewAttached()){
            getView().showLoading();
        }
    }
}
