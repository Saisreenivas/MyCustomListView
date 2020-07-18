package com.mycustomlistview.saisreenivas.mycustomlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.Inflater;

/**
 * Created by Sai sreenivas on 12/30/2016.
 */

public class CustomListViewAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<HashMap<String, String>> books;
    private static LayoutInflater minflater = null ;


    public CustomListViewAdapter(Context context, ArrayList<HashMap<String, String>> data){

        mContext = context;
        books = data;
        minflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if(convertView == null){

            view = minflater.inflate(R.layout.list_row, null);

            TextView mName = (TextView) view.findViewById(R.id.bookName);
            TextView mAuthor = (TextView) view.findViewById(R.id.bookAuthor);
            TextView mPages = (TextView) view.findViewById(R.id.bookPages);
            ImageView mImageView = (ImageView) view.findViewById(R.id.bookImage);

            HashMap<String, String> mBook = new HashMap<>();

            mBook = books.get(position);

            mName.setText(mBook.get("title"));
            mAuthor.setText(mBook.get("author"));
            mPages.setText(mBook.get("pages"));
            mImageView.setImageDrawable(mContext.getResources().getDrawable(R.drawable.blue_swirl));
        }

        return view;
    }
}
