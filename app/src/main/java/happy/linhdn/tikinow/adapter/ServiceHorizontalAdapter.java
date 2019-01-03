package happy.linhdn.tikinow.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import happy.linhdn.tikinow.R;
import happy.linhdn.tikinow.model.Service;

public class ServiceHorizontalAdapter extends BaseAdapter {
    private ArrayList<Service> dataObjects;
    private Context context;

    public ServiceHorizontalAdapter(Context context) {
        this.dataObjects = new ArrayList<>();
        this.context = context;
    }

    public void setData(List<Service> dataObjects) {
        this.dataObjects.clear();
        this.dataObjects.addAll(dataObjects);
        notifyDataSetChanged();
    }

    public int getCount() {
        return dataObjects.size();
    }

    public Service getItem(int position) {
        return dataObjects.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.item_service, null);
        ImageView iconView = convertView.findViewById(R.id.iv_icon);
        TextView nameView = convertView.findViewById(R.id.tv_name);

        Service service = dataObjects.get(position);

        iconView.setImageResource(service.getImgResource());
        nameView.setText(service.getName());

        return convertView;
    }

}

