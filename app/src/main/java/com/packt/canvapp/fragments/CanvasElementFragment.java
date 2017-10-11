package com.packt.canvapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.packt.canvapp.R;
import com.packt.canvapp.models.CanvasElement;

/**
 * Represents a fragment for each element of the business model canvas.
 */
public class CanvasElementFragment extends Fragment {

    private static final String ARG_ELEMENT = "ARG_ELEMENT";

    public static CanvasElementFragment newInstance(CanvasElement element) {
        CanvasElementFragment fragment = new CanvasElementFragment();

        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_ELEMENT, element);
        fragment.setArguments(bundle);
        return fragment;
    }

    private CanvasElement element;

    public CanvasElement getElement(){
        if (getView() != null) {
            EditText editValue = (EditText) getView().findViewById(R.id.element_value);
            element.VALUE = editValue.getText().toString();
        }
        return element;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        element = getArguments().getParcelable(ARG_ELEMENT);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_canvas_element, container, false);

        ((TextView)view.findViewById(R.id.element_text_title)).setText(element.TITLE);
        ((TextView)view.findViewById(R.id.element_text_description)).setText(element.DESCRIPTION);
        ((TextView) view.findViewById(R.id.element_value)).setHint(element.HINT);
        if (element.VALUE != null){
            EditText editValue = (EditText) view.findViewById(R.id.element_value);
            editValue.setText(element.VALUE);
        }
        return view;
    }
}
