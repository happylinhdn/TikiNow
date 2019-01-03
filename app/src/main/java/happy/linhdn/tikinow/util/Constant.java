package happy.linhdn.tikinow.util;

import happy.linhdn.tikinow.R;

public class Constant {
    public enum TransitionType {
        NONE(R.anim.stand_still, R.anim.stand_still, R.anim.stand_still, R.anim.stand_still),
        SLIDE_IN_RIGHT_TO_LEFT(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right),
        SLIDE_IN_LEFT_TO_RIGHT(R.anim.slide_in_left, R.anim.slide_out_right, R.anim.slide_in_right, R.anim.slide_out_left),
        SLIDE_IN_BOTTOM(R.anim.slide_in_bottom, R.anim.stand_still, R.anim.stand_still, R.anim.slide_out_bottom),
        CROSS_FADE(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out);

        public int enter;
        public int exit;
        public int popEnter;
        public int popExit;

        TransitionType(int enter, int exit, int popEnter, int popExit) {
            this.enter = enter;
            this.exit = exit;
            this.popEnter = popEnter;
            this.popExit = popExit;
        }
    }

    public static final String[] HOT_KEY_LIST_DEMO =  {
            "xiaomi",
            "bitis hunter",
            "bts",
            "balo",
            "bitis hunter x",
            "tai nghe",
            "harry potter",
            "anker",
            "iphone",
            "balo nữ",
            "nguyễn nhật ánh",
            "đắc nhân tâm",
            "ipad",
            "senka",
            "tai nghe bluetooth",
            "son",
            "maybelline",
            "laneige",
            "kem chống nắng",
            "anh chính là thanh xuân của em",
    };

    public static final int [] HOT_KEY_LIST_COLOR = {
            R.color.color_green,
            R.color.color_green_1,
            R.color.color_yellow,
            R.color.color_purple,
            R.color.color_blue,
            R.color.color_yellow_1,
            R.color.color_red,
            R.color.color_blue_1,
    };
}
