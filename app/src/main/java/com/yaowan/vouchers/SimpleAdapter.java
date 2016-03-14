package com.yaowan.vouchers;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by Rc3 on 2016/3/8.
 */
public class SimpleAdapter extends BaseAdapter {


    public ArrayList<SparseArray<String>> mList;
    public Context mContext;


    public SimpleAdapter(Context context ,ArrayList<SparseArray<String>> list){
        this.mContext=context;
        this.mList=list;


    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHolder  myHolder;
        if(convertView==null){
            myHolder=new MyHolder();
           convertView = LayoutInflater.from(mContext).inflate(R.layout.lv_item,null);
           convertView.setTag(myHolder);
        }else{
            myHolder= (MyHolder) convertView.getTag();
        }
      myHolder.ll= (LinearLayout) convertView.findViewById(R.id.layout);

            Log.i("mList(position).size()",mList.get(position).size()+".");
            for (int j = 0; j < mList.get(position).size(); j++) {
                ImageView imageview=new ImageView(mContext);
               imageview.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                imageview.setBackgroundResource(R.mipmap.ic_launcher);
                myHolder.ll.addView(imageview);

        }


        return convertView;
    }

    public class MyHolder{
       LinearLayout ll;

    }
}
