package happy.linhdn.tikinow.model;

import android.text.TextUtils;

import happy.linhdn.tikinow.util.Utility;

public class HotKey {
    private String keyword;
    private int backgroundColor;

    public HotKey(String keyword) {
        this.keyword = keyword;
        this.backgroundColor = Utility.getRandomColor();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getFormatKeyword() {
        if (TextUtils.isEmpty(keyword)) {
            return "";
        }
        String formatName = "";

        String[] splits = keyword.split("\\s");
        if (splits != null && splits.length > 1) {
            for (int i = 0; i < splits.length/2;i++) {
                formatName += splits[i] + " ";
            }

            formatName += "\n"; //Break down

            for (int i = splits.length/2; i < splits.length;i++) {
                formatName += splits[i] + " ";
            }
        } else {
            formatName = keyword;
        }
        return formatName.trim();
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }
}
