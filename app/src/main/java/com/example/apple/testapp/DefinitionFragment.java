package com.example.apple.testapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by apple on 15. 9. 23..
 */
public class DefinitionFragment extends Fragment{
    final static String ARG_POSITION = "position";
    int mCurrentPosition = -1;
    TextView def;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        if(savedInstanceState != null){
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }

        View fragmentView = inflater.inflate(R.layout.definition_view, container, false);
        def = (TextView) fragmentView.findViewById(R.id.definition);

        return fragmentView;
    }

    public  void onStart(){
       super.onStart();

        Bundle args = getArguments();
        if(args != null){
            updateDefinitionView(args.getInt(ARG_POSITION));
        }
        else if(mCurrentPosition != -1)
        {
            updateDefinitionView(mCurrentPosition);
        }

    }

    public void updateDefinitionView(int position){
        def.setText(Data.definitions[position]);
        mCurrentPosition = position;
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_POSITION, mCurrentPosition);
    }


}
