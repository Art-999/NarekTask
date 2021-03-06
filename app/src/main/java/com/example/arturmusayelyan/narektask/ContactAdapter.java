package com.example.arturmusayelyan.narektask;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by artur.musayelyan on 13/11/2017.
 */

public class ContactAdapter extends ArrayAdapter {
    List<Contacts>list = new ArrayList();

    public ContactAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }


    public void add(Contacts object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row;
        row = convertView;
        ContactHolder contactHolder;
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout, parent, false);
            contactHolder = new ContactHolder();
            contactHolder.tx_id = (TextView) row.findViewById(R.id.tv_id);
            contactHolder.tx_name = (TextView) row.findViewById(R.id.tv_name);
            contactHolder.image = (ImageView) row.findViewById(R.id.iv_image);
            row.setTag(contactHolder);

        } else {
            contactHolder = (ContactHolder) row.getTag();
        }
        Contacts contacts = list.get(position);
        contactHolder.tx_id.setText(contacts.getId());
        contactHolder.tx_name.setText(contacts.getName());
//        contactHolder.image.setImageResource(Integer.parseInt(contacts.getImage())); //harc ka
        return row;
    }

    static class ContactHolder {
        TextView tx_id, tx_name;
        ImageView image;
    }
}
