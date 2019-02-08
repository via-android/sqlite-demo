package com.morepranit.sqlitedemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.morepranit.sqlitedemo.R;
import com.morepranit.sqlitedemo.database.entities.User;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<User> users;

    public UserAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_user, viewGroup, false);
            holder = new ViewHolder();
            holder.tvMobile = view.findViewById(R.id.tv_mobile);
            holder.tvName = view.findViewById(R.id.tv_name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        User user = users.get(i);
        holder.tvName.setText(user.firstName + " " + user.lastName);
        holder.tvMobile.setText(user.mobile + "");

        return view;
    }

    class ViewHolder {
        TextView tvName, tvMobile;
    }
}
