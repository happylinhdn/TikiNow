package happy.linhdn.tikinow.model;

import android.text.TextUtils;

import happy.linhdn.tikinow.util.Utility;

public class HotKey {
    private String name;
    private int backgroundColor;

    public HotKey(String name) {
        this.name = name;
        this.backgroundColor = Utility.getRandomColor();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormatName() {
        if (TextUtils.isEmpty(name)) {
            return "";
        }
        String formatName = "";

        String[] splits = name.split("\\s");
        if (splits != null && splits.length > 1) {
            for (int i = 0; i < splits.length/2;i++) {
                formatName += splits[i] + " ";
            }

            formatName += "\n"; //Break down

            for (int i = splits.length/2; i < splits.length;i++) {
                formatName += splits[i] + " ";
            }
        } else {
            formatName = name;
        }
        return formatName.trim();
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }
}
