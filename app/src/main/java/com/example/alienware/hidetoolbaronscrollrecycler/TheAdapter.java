package com.example.alienware.hidetoolbaronscrollrecycler;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alienware on 20-02-2017.
 */

public class TheAdapter extends RecyclerView.Adapter<TheAdapter.TheViewHolder> {

    List<JSONObject> jsonObjectList;
    CoordinatorLayout coordinatorLayout;
    ArrayList<Integer> selectedvalues = new ArrayList();
    int selectedcolor = Color.parseColor("#960000");


    //Class for View Holder, layout stuff for each card
    public class TheViewHolder extends RecyclerView.ViewHolder{
        TextView name,user_name;
        Button add;
        RelativeLayout relativeLayout;
        public TheViewHolder(final View itemView) {
            super(itemView);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.card);
            name = (TextView)itemView.findViewById(R.id.name);
            user_name = (TextView)itemView.findViewById(R.id.user_name);
            add = (Button)itemView.findViewById(R.id.button);


            itemView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()){
                        case MotionEvent.ACTION_UP:
                            //switch (view.getId()){
                              //  case R.id.button:
                                //    Snackbar.make(itemView,"ADD->"+jsonObjectList.get(getAdapterPosition()).toString(),Snackbar.LENGTH_SHORT).show();
                                  //  break;
                                //default:
                            if(selectedvalues.contains(getAdapterPosition())){
                                relativeLayout.setBackgroundColor(Color.TRANSPARENT);
                                selectedvalues.remove((Integer) getAdapterPosition());
                            }else{
                                selectedvalues.add(getAdapterPosition());
                                relativeLayout.setBackgroundColor(selectedcolor);
                            }


                                    Snackbar.make(itemView,jsonObjectList.get(getAdapterPosition()).toString(),Snackbar.LENGTH_SHORT).show();
                                  //   break;
                            //}
                            return true;
                        case MotionEvent.ACTION_DOWN:
                            return true;
                    }
                    return true;
                }
            });
        }
    }

    public TheAdapter(List<JSONObject> jsonObjectList){ this.jsonObjectList = jsonObjectList; }


    @Override
    public TheViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.the_card,parent,false);
        return new TheViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TheViewHolder holder, int position) {

        if(selectedvalues.contains(position)){
         holder.relativeLayout.setBackgroundColor(selectedcolor);
        }else {
            holder.relativeLayout.setBackgroundColor(Color.TRANSPARENT);
        }

        JSONObject jsonObject = jsonObjectList.get(position);
        try {
            holder.user_name.setText(jsonObject.getString("user_name"));
            holder.name.setText(jsonObject.getString("name"));

        }catch (JSONException je){je.printStackTrace();}
    }



    @Override
    public int getItemCount() {
        return jsonObjectList.size();
    }
}
