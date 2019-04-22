package com.bku.appbooking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListProductAdapter extends BaseAdapter {
    private final Context mContext;
    private final ArrayList<Product> products;

    // 1
    public ListProductAdapter(Context context, ArrayList<Product> products) {
        this.mContext = context;
        this.products = products;
    }

    // 2
    @Override
    public int getCount() {
        return products.size();
    }

    // 3
    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 4
    @Override
    public Object getItem(int position) {
        return null;
    }

    // 5
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Product product = products.get(position);
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.layout_product, null);

            final ImageView imageViewCoverArt = (ImageView)convertView.findViewById(R.id.imageview_cover_art);
            final TextView titleTv = (TextView)convertView.findViewById(R.id.tv_title);
            final TextView priceTv = (TextView)convertView.findViewById(R.id.tv_price);

            final ViewHolder viewHolder = new ViewHolder(titleTv, priceTv, imageViewCoverArt);
            convertView.setTag(viewHolder);
        }
        final ViewHolder viewHolder = (ViewHolder)convertView.getTag();
//    viewHolder.imageViewCoverArt.setImageResource(book.getImageResource());
        viewHolder.titleTv.setText(product.getTitle());
        viewHolder.priceTv.setText(product.getPrice());

        Picasso.with(mContext).load(product.getImageUrl()).into(viewHolder.imageViewCoverArt);

        return convertView;
    }

    private class ViewHolder {
        private final TextView titleTv;
        private final TextView priceTv;
        private final ImageView imageViewCoverArt;

        public ViewHolder(TextView titleTv, TextView priceTv, ImageView imageViewCoverArt) {
            this.titleTv = titleTv;
            this.priceTv = priceTv;
            this.imageViewCoverArt = imageViewCoverArt;
        }
    }
}
