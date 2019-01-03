package happy.linhdn.tikinow.presenter;

import happy.linhdn.tikinow.view.MainActivityView;

public class MainActivityPresenter extends BasePresenter<MainActivityView> {
    @Override
    public void onNewViewStateInstance() {
        if (isViewAttached()) {
            getView().showHomePage();
        }
    }
}
