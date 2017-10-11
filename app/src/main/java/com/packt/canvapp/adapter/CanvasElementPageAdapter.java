package com.packt.canvapp.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.packt.canvapp.data.LocalRepository;
import com.packt.canvapp.fragments.CanvasElementFragment;
import com.packt.canvapp.models.Canvas;
import com.packt.canvapp.models.CanvasElementsModel;
import java.util.ArrayList;
import java.util.List;

public class CanvasElementPageAdapter extends FragmentStatePagerAdapter {

    private Canvas canvas;
    public List<CanvasElementFragment> fragments = new ArrayList<>();

    public CanvasElementPageAdapter(FragmentManager fm, Context context, Canvas canvas) {
        super(fm);
        this.canvas = canvas;
        if (canvas.ELEMENTS == null) {
            CanvasElementsModel model = LocalRepository.getElements(context);
            this.canvas.ELEMENTS = model.ELEMENTS;
        }
    }

    @Override
    public Fragment getItem(int position) {
        CanvasElementFragment fragment = CanvasElementFragment.newInstance(canvas.ELEMENTS.get(position));
        fragments.add(fragment);
        return fragment;
    }

    @Override
    public int getCount() {
        return canvas.ELEMENTS.size();
    }

    public Canvas getCanvas(){
        int position = 0;
        for(CanvasElementFragment fragment : fragments){
            canvas.ELEMENTS.get(position).VALUE = fragment.getElement().VALUE;
            position++;
        }
        return canvas;
    }
}
