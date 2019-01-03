
package happy.linhdn.tikinow.view;

import com.hannesdorfmann.mosby.mvp.MvpView;

public interface BaseView extends MvpView {
    void showMessage(int msgId, boolean success);
    void showMessage(String message, boolean success);

}
