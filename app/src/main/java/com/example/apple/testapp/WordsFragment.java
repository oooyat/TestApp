package com.example.apple.testapp;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by apple on 15. 9. 23..
 */
public class WordsFragment extends ListFragment{
    OnwordSelectedListenr mcallback;

    public interface  OnwordSelectedListenr {
        public  void onWordSelected(int position);
    }

    @Override
    public void onCreate(Bundle savedInstanceState ){
        super.onCreate(savedInstanceState);

        int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
                android.R.layout.simple_list_item_activated_1
                : android.R.layout.simple_list_item_1;

        setListAdapter(new ArrayAdapter<String>(getActivity(), layout, Data.words));

    }
    @Override
    public  void onStart(){
        super.onStart();
        if(getFragmentManager().findFragmentById(R.id.definition_fragment) != null){
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }

    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);

        try{
            mcallback = (OnwordSelectedListenr) activity;

        } catch (ClassCastException e){
            throw  new ClassCastException(activity.toString() + "must implement OnwordSelectedListener");

        }


    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        mcallback.onWordSelected(position);
        getListView().setItemChecked(position, true);

    }


}
