package com.phamtantb24.foodlistview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class FoodAdapter extends BaseAdapter {
    List<Food> foods;
    int layout;
    Context context;

    public FoodAdapter() {
    }

    public FoodAdapter(List<Food> foods, int layout, Context context) {
        this.foods = foods;
        this.layout = layout;
        this.context = context;
    }

    @Override
    public int getCount() {
        return foods.size();
    }

    @Override
    public Object getItem(int position) {
        return foods.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView name, info, price;
        ImageView image;
        RelativeLayout la;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            viewHolder = new ViewHolder();
            viewHolder.name = convertView.findViewById(R.id.foodName);
            viewHolder.info = convertView.findViewById(R.id.info);
            viewHolder.price = convertView.findViewById(R.id.price);
            viewHolder.image = convertView.findViewById(R.id.imageFood);
            viewHolder.la = convertView.findViewById(R.id.lineInfoFood);
            convertView.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder) convertView.getTag();
        Food food = (Food) getItem(position);
        viewHolder.name.setText(food.getName());
        viewHolder.info.setText(food.getInfo());
        viewHolder.price.setText(food.getPrice() + "$");
        viewHolder.image.setImageResource(food.getImage());
        viewHolder.la.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Detail.class);
                context.startActivity(intent);
            }
        });
        viewHolder.la.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                builder.setTitle("Do you want to delete this item ?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        foods.remove(position);
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
                return false;
            }
        });
        return convertView;
    }
}
