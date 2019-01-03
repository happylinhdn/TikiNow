
package happy.linhdn.tikinow.presenter;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import happy.linhdn.tikinow.view.BaseView;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public abstract class BasePresenter<V extends BaseView> extends MvpBasePresenter<V> {

    protected CompositeSubscription compositeSubscription;

    @Override
    public void attachView(V view) {
        super.attachView(view);
        compositeSubscription = new CompositeSubscription();
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        if (!retainInstance) {
            compositeSubscription.unsubscribe();
        }
    }

    protected void addSubscription(Subscription subscription) {
        compositeSubscription.add(subscription);
    }

    protected void removeSubscription(Subscription subscription) {
        compositeSubscription.remove(subscription);
    }

    protected void unsubscribeAllSubscriptions() {
        compositeSubscription.unsubscribe();
        compositeSubscription = new CompositeSubscription();
    }

    public abstract void onNewViewStateInstance();

}
