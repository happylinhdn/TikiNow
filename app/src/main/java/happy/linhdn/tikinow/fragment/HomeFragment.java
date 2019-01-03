
package happy.linhdn.tikinow.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;


import java.util.List;

import happy.linhdn.tikinow.R;
import happy.linhdn.tikinow.adapter.HotKeyAdapter;
import happy.linhdn.tikinow.adapter.ServiceHorizontalAdapter;
import happy.linhdn.tikinow.base.BaseFragment;
import happy.linhdn.tikinow.model.HotKey;
import happy.linhdn.tikinow.model.Service;
import happy.linhdn.tikinow.presenter.HomePresenter;
import happy.linhdn.tikinow.view.HomeView;
import happy.linhdn.tikinow.widget.HorizontalListView;


public class HomeFragment extends BaseFragment<HomeView, HomePresenter> implements HomeView {

    private HorizontalListView serviceListView, hotKeyListView;
    private ServiceHorizontalAdapter serviceHorizontalAdapter;
    private HotKeyAdapter hotKeyAdapter;


    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        serviceListView = view.findViewById(R.id.list_service);
        hotKeyListView = view.findViewById(R.id.list_hot_key);
        serviceHorizontalAdapter = new ServiceHorizontalAdapter(getContext());
        serviceListView.setAdapter(serviceHorizontalAdapter);

        hotKeyAdapter = new HotKeyAdapter(getContext());
        hotKeyListView.setAdapter(hotKeyAdapter);
    }

    @NonNull
    @Override
    public HomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    public void showMessage(int msgId, boolean success) {

    }

    @Override
    public void showMessage(String message, boolean success) {

    }

    @Override
    public void setServiceData(List<Service> datas) {
        serviceHorizontalAdapter.setData(datas);
    }

    @Override
    public void setHotKeyData(List<HotKey> datas) {
        hotKeyAdapter.setData(datas);
    }
}
