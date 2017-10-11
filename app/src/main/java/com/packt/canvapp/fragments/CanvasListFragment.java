package com.packt.canvapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.packt.canvapp.R;
import com.packt.canvapp.activities.MainActivity;
import com.packt.canvapp.adapter.CanvasListAdapter;
import com.packt.canvapp.adapter.OnCardViewClicked;
import com.packt.canvapp.data.OnRepositoryResult;
import com.packt.canvapp.models.CanvasListModel;

public class CanvasListFragment extends Fragment
        implements OnCardViewClicked, OnRepositoryResult{

    private RecyclerView recyclerView;
    private CanvasListAdapter adapter;
    private CanvasListModel viewModel;

    public static CanvasListFragment newInstance() {
        CanvasListFragment fragment = new CanvasListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(getClass().toString(), "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_canvas_list, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.canvas_recycle_view);
        loadData();
        return view;
    }

    private void loadData(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        ((MainActivity)getActivity()).getRepository().loadCanvasModels(this);
            }

    @Override
    public void onCardClicked(View view, int position) {
        ((MainActivity)getActivity()).onEdit(viewModel.canvases.get(position));
    }

    @Override
    public void onResult(CanvasListModel result) {
        viewModel = result;
        adapter = new CanvasListAdapter(viewModel, R.layout.adapter_canvas_list, getActivity());
        adapter.setOnCardViewClicked(this);
        recyclerView.setAdapter(adapter);
    }
}
