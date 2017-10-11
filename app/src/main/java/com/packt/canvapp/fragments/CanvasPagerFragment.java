package com.packt.canvapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.packt.canvapp.R;
import com.packt.canvapp.activities.MainActivity;
import com.packt.canvapp.adapter.CanvasElementPageAdapter;
import com.packt.canvapp.data.OnRepositoryResult;
import com.packt.canvapp.models.Canvas;
import com.packt.canvapp.models.CanvasListModel;

/**
 * Container fragment for Canvas Element fragments, provided through a swipable interface.
 */
public class CanvasPagerFragment extends Fragment
      implements OnRepositoryResult, View.OnClickListener {

    private static final String ARG_CANVAS = "ARG_CANVAS";

    private Canvas canvas;
    private ViewPager pager;
    private CanvasElementPageAdapter pagerAdapter;

    public static CanvasPagerFragment newInstance(Canvas canvas) {
        CanvasPagerFragment fragment = new CanvasPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_CANVAS, canvas);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        canvas = getArguments().getParcelable(ARG_CANVAS);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_canvas_pager, container, false);
        pager = (ViewPager) view.findViewById(R.id.canvas_edit_pager);
        view.findViewById(R.id.canvas_edit_save).setOnClickListener(this);
        loadData();
        return view;
    }

    private void loadData(){
        MainActivity ma = (MainActivity)getActivity();
        pagerAdapter = new CanvasElementPageAdapter( ma.getSupportFragmentManager(),getActivity(),canvas);
        pager.setOffscreenPageLimit(11);
        pager.setAdapter(pagerAdapter);
    }

    @Override
    public void onClick(View v) {
        onSaveData();
    }

    private void onSaveData(){
        Canvas canvas = pagerAdapter.getCanvas();
        MainActivity activity = (MainActivity)getActivity();
        activity.getRepository().saveCanvasModel(canvas);
        activity.onList();
    }

    @Override
    public void onResult(CanvasListModel result) {

    }
}
