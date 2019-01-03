package happy.linhdn.tikinow.view;

import java.util.List;

import happy.linhdn.tikinow.model.HotKey;
import happy.linhdn.tikinow.model.Service;

public interface HomeView extends BaseView {
    public void setServiceData(List<Service> datas);
    public void setHotKeyData(List<HotKey> datas);
}
