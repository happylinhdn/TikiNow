package happy.linhdn.tikinow;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import happy.linhdn.tikinow.activity.MainActivity;
import happy.linhdn.tikinow.model.HotKey;
import happy.linhdn.tikinow.presenter.HomePresenter;

@RunWith(RobolectricTestRunner.class)
public class TikiNowTestCase {
    private MainActivity mActivity;

    @Before
    public void setUp() throws Exception {
        mActivity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void testMainActivity() {
        Assert.assertNotNull(mActivity);
    }

    @Test
    public void testHomeFragmentAttached() throws Exception {
        HomePresenter homePresenter = mActivity.homeFragment.getPresenter();
        Assert.assertEquals(true, homePresenter.isViewAttached());
    }

    @Test
    public void testLoadedData() throws Exception {
        HomePresenter homePresenter = mActivity.homeFragment.getPresenter();
        Assert.assertEquals(4, homePresenter.services.size());
        Assert.assertEquals(20, homePresenter.hotKeys.size());
    }

    @Test
    public void testClearData() throws Exception {
        HomePresenter homePresenter = mActivity.homeFragment.getPresenter();
        homePresenter.clearData();
        Assert.assertEquals(0, homePresenter.services.size());
        Assert.assertEquals(0, homePresenter.hotKeys.size());
    }

    @Test
    public void testLoadDataAgain() throws Exception {
        HomePresenter homePresenter = mActivity.homeFragment.getPresenter();
        homePresenter.loadData();
        Assert.assertEquals(4, homePresenter.services.size());
        Assert.assertEquals(20, homePresenter.hotKeys.size());
    }

    @Test
    public void testHotKeySingleWord() throws Exception {
        String keyword = "xiaomi";
        String printKeyword = "xiaomi";

        HotKey hotKey = new HotKey(keyword);
        Assert.assertEquals(printKeyword, hotKey.getFormatKeyword());
        Assert.assertEquals(keyword, hotKey.getKeyword());
        Assert.assertEquals(hotKey.getKeyword(), hotKey.getFormatKeyword());
    }

    @Test
    public void testHotKeyLongWord() throws Exception {
        String keyword = "bitis hunter x";
        String printKeyword = "bitis \nhunter x";

        HotKey hotKey = new HotKey(keyword);
        Assert.assertEquals(printKeyword, hotKey.getFormatKeyword());
        Assert.assertEquals(keyword, hotKey.getKeyword());
        //Keyword will not same format keyword
        Assert.assertNotEquals(hotKey.getKeyword(), hotKey.getFormatKeyword());
    }
}
