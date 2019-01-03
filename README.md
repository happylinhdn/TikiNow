# TikiNow example
This is Tiki Now example written by Java base on MVP architecture pattern.

# Feature:
  - Show list of hot key as the below:
![HotKey Horizontal Listview](./demo.gif)
  - If the keyword is more than one word, then display in two lines.
  - Background color is random.

# Technical:
  - MVP architecture pattern.
  - Horizontal List View

# APK file:
[APK download](./tikinow.apk)

# Direction for testcase:
  - Demo data set at happy.linhdn.tikinow.util.Constant.java
  - List of keywords:

 ```java
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
```

  - List of colors for Background:

```java
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
```
