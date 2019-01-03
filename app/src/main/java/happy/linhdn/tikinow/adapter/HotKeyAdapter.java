package happy.linhdn.tikinow.adapter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import happy.linhdn.tikinow.R;
import happy.linhdn.tikinow.model.HotKey;

public class HotKeyAdapter extends BaseAdapter {
    private ArrayList<HotKey> dataObjects;
    private Context context;

    public HotKeyAdapter(Context context) {
        this.dataObjects = new ArrayList<>();
        this.context = context;
    }

    public void setData(List<HotKey> dataObjects) {
        this.dataObjects.clear();
        this.dataObjects.addAll(dataObjects);
        notifyDataSetChanged();
    }

    public int getCount() {
        return dataObjects.size();
    }

    public HotKey getItem(int position) {
        return dataObjects.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.item_hotkey, null);
        TextView nameView = convertView.findViewById(R.id.tv_name);
        LinearLayout backgroundView = convertView.findViewById(R.id.ll_background);

        HotKey hotKey = dataObjects.get(position);

        nameView.setText(hotKey.getFormatName());

        Drawable background = backgroundView.getBackground();
        if (background instanceof ShapeDrawable) {
            ((ShapeDrawable)background).getPaint().setColor(ContextCompat.getColor(context, hotKey.getBackgroundColor()));
        } else if (background instanceof GradientDrawable) {
            ((GradientDrawable)background).setColor(ContextCompat.getColor(context, hotKey.getBackgroundColor()));
        } else if (background instanceof ColorDrawable) {
            ((ColorDrawable)background).setColor(ContextCompat.getColor(context, hotKey.getBackgroundColor()));
        }
        return convertView;
    }

}

