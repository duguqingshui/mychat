package com.tao.mychat.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tao.mychat.R;
import com.tao.mychat.adapter.DataAdapter;
import com.tao.mychat.widget.swipelistview.BaseSwipeListViewListener;
import com.tao.mychat.widget.swipelistview.SwipeListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AMOBBS on 2017/2/7.
 */

public class ChatRecordFragment extends Fragment{
    protected static final String TAG = "Activity";
    private SwipeListView mSwipeListView;
    private DataAdapter mAdapter;
    private List<String> mDatas;
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_chatrecord, container, false);
        initDatas();
        System.out.println("集合大小："+mDatas.size());
        mSwipeListView = (SwipeListView)view.findViewById(R.id.id_swipelistview);

        mAdapter = new DataAdapter(getContext(), mDatas , mSwipeListView);
        mSwipeListView.setAdapter(mAdapter);

        mSwipeListView.setSwipeListViewListener(new BaseSwipeListViewListener()
        {
            @Override
            public void onChoiceChanged(int position, boolean selected)
            {
                Log.d(TAG, "onChoiceChanged:" + position + ", " + selected);
            }

            @Override
            public void onChoiceEnded()
            {
                Log.d(TAG, "onChoiceEnded");
            }

            @Override
            public void onChoiceStarted()
            {
                Log.d(TAG, "onChoiceStarted");
            }

            @Override
            public void onClickBackView(int position)
            {
                Log.d(TAG, "onClickBackView:" + position);
            }

            @Override
            public void onClickFrontView(int position)
            {
                Log.d(TAG, "onClickFrontView:" + position);
            }

            @Override
            public void onClosed(int position, boolean fromRight)
            {
                Log.d(TAG, "onClosed:" + position + "," + fromRight);
            }

            @Override
            public void onDismiss(int[] reverseSortedPositions)
            {
                Log.d(TAG, "onDismiss");

            }

            @Override
            public void onFirstListItem()
            {
                Log.d(TAG, "onFirstListItem");
            }

            @Override
            public void onLastListItem()
            {
                Log.d(TAG, "onLastListItem");
            }

            @Override
            public void onListChanged()
            {
                Log.d(TAG, "onListChanged");

                mSwipeListView.closeOpenedItems();

            }

            @Override
            public void onMove(int position, float x)
            {
                Log.d(TAG, "onMove:" + position + "," + x);
            }

            @Override
            public void onOpened(int position, boolean toRight)
            {
                Log.d(TAG, "onOpened:" + position + "," + toRight);
            }

            @Override
            public void onStartClose(int position, boolean right)
            {
                Log.d(TAG, "onStartClose:" + position + "," + right);
            }

            @Override
            public void onStartOpen(int position, int action, boolean right)
            {
                Log.d(TAG, "onStartOpen:" + position + "," + action + ","
                        + right);
            }
        });
        return view;
    }
    private void initDatas()
    {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i <= 'Z'; i++)
            mDatas.add((char) i + "");
    }
}
