package com.example.sherefshokry.caronline.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.example.sherefshokry.caronline.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sheref Shokry on 8/2/2016.
 */
public class CarBrandsAdapter extends ArrayAdapter {
    private List list = new ArrayList();
    private Context c;
    public CarBrandsAdapter(Context context, int resource) {
        super(context, resource);
        c=context;
    }

    static class DataHandler {

        ImageView brandImage;
        TextView brandName;
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add((CarBrandsDataProvider ) object);
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
            item = inflater.inflate(R.layout.brandslayout, parent, false);
            dataHandler = new DataHandler();
            dataHandler.brandImage = (ImageView) item.findViewById(R.id.brandImage);
            dataHandler.brandName = (TextView) item.findViewById(R.id.brandName);
            item.setTag(dataHandler);
        } else {
            dataHandler = (DataHandler) item.getTag();
        }
            final  CarBrandsDataProvider  dataProvider;
            dataProvider = (CarBrandsDataProvider) this.getItem(position);

            Picasso.with(this.c).load(dataProvider.getBrandImage()).into(dataHandler.brandImage);
            dataHandler.brandName.setText(dataProvider.getBrandName());

            return item;
}
}
