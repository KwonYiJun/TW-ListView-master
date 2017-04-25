package com.myapplicationdev.android.tw_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ModuleAdapter extends ArrayAdapter<Module> {
    private ArrayList<Module> module;
    private Context context;
    private TextView tvModuleName;
    private ImageView ivPic;

    public ModuleAdapter(Context context, int resource, ArrayList<Module> objects){
        super(context, resource, objects);
        module = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        //Get the TextView object
        tvModuleName = (TextView) rowView.findViewById(R.id.tvCode);
        //Get the ImageView object
        ivPic = (ImageView) rowView.findViewById(R.id.ivProg);

        Module currentModule = module.get(position);

        tvModuleName.setText(currentModule.getModule());

        if(currentModule.isProg()){
            ivPic.setImageResource(R.drawable.prog);
        }
        else {
            ivPic.setImageResource(R.drawable.nonprog);
        }
        return rowView;
    }




}
