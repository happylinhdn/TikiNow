
package happy.linhdn.tikinow.presenter;


import java.util.ArrayList;
import java.util.List;

import happy.linhdn.tikinow.R;
import happy.linhdn.tikinow.util.Constant;
import happy.linhdn.tikinow.model.HotKey;
import happy.linhdn.tikinow.model.Service;
import happy.linhdn.tikinow.view.HomeView;

public class HomePresenter extends BasePresenter<HomeView> {
    @Override
    public void onNewViewStateInstance() {
        if (isViewAttached()) {
            loadData();
        }
    }

    private void loadData() {
//        Load service demo
        List<Service> services = new ArrayList<>();
        services.add(new Service("Vé máy bay", R.drawable.ic_flight));
        services.add(new Service("Mua bảo hiểm online", R.drawable.ic_flight));
        services.add(new Service("Mua thẻ điện thoại", R.drawable.ic_flight));
        services.add(new Service("Thẻ cào", R.drawable.ic_flight));

        getView().setServiceData(services);

//        Load Hot key demo
        List<HotKey> hotKeys = new ArrayList<>();
        for (String key : Constant.HOT_KEY_LIST_DEMO) {
            hotKeys.add(new HotKey(key));
        }

        getView().setHotKeyData(hotKeys);
    }
}
