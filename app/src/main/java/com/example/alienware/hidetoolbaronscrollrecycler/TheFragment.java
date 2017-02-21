package com.example.alienware.hidetoolbaronscrollrecycler;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alienware on 21-02-2017.
 */

public class TheFragment extends Fragment {
    final int LENGTH_OF_LIST = 30;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<JSONObject> jsonObjectList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.thefrag,container,false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler);
        Toolbar toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        getjsonFakeAsync();
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new TheAdapter(jsonObjectList);
        recyclerView.setAdapter(adapter);


        return view;
    }



    //if you get your json from Async just do-> adapter.notifyDataSetChanged();
    public void getjsonFakeAsync(){
        //here you may want to get things from an json array that you may receive but i'll just do jsonObj
        for(int i =0;i<LENGTH_OF_LIST;i++){
            try {
                jsonObjectList.add(new JSONObject(String.format("{\"name\":\"USER %d\",\"user_name\":\" %d \"}",i,i)));
            }catch (JSONException je){je.printStackTrace();}
        }

    }

}
