package com.phamtantb24.foodlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Food> foods;
    private ListView foodListView;
    private FoodAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        foodListView = findViewById(R.id.foodListView);
        foods = new ArrayList<>();
        foods.add(new Food("Cơm chiên","Cơm chiên ông Tân 24/7",R.drawable.cow,2));
        foods.add(new Food("Bo viên chiên mỳ ý","Bò viên ông Tân",R.drawable.fish,3));
        foods.add(new Food("Cá rầm mắm","Cơm chiên ông Tân 24/7",R.drawable.fish,3));
        foods.add(new Food("Cơm chiên","Cơm chiên ông Tân 24/7",R.drawable.cow,2));
        foods.add(new Food("Cơm chiên","Cơm chiên ông Tân 24/7",R.drawable.fish,2));
        foodAdapter = new FoodAdapter(foods, R.layout.food_item,this);
        foodListView.setAdapter(foodAdapter);

        foodListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Do you want to delete this item ?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                return false;
            }
        });
    }
}