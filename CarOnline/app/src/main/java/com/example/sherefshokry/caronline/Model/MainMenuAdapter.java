package com.example.sherefshokry.caronline.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sherefshokry.caronline.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sheref Shokry on 8/2/2016.
 */
public class MainMenuAdapter  extends ArrayAdapter {
    private List list = new ArrayList();
    private Context c;
    public MainMenuAdapter(Context context, int resource) {
        super(context, resource);
        c=context;
    }

    static class DataHandler {
        ImageView categoryImage;
        TextView categoryName;
    }

    @Override
    public void add(Object object)
    {
        super.add(object);
        list.add((MainMenuDataProvider ) object);
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View item;
        item = convertView;
        final DataHandler dataHandler;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            item = inflater.inflate(R.layout.mainlayout, parent, false);
            dataHandler = new DataHandler();
            dataHandler.categoryImage = (ImageView) item.findViewById(R.id.categoryImage);
            dataHandler.categoryName = (TextView) item.findViewById(R.id.categoryName);
            item.setTag(dataHandler);
        } else {
            dataHandler = (DataHandler) item.getTag();
        }
        final MainMenuDataProvider  dataProvider;
        dataProvider = (MainMenuDataProvider) this.getItem(position);

      dataHandler.categoryImage.setImageResource(dataProvider.getImg());
        dataHandler.categoryName.setText(dataProvider.getName());

        return item;
    }
}
