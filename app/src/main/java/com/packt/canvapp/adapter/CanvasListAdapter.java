package com.packt.canvapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.packt.canvapp.R;
import com.packt.canvapp.models.Canvas;
import com.packt.canvapp.models.CanvasListModel;

public class CanvasListAdapter extends  RecyclerView.Adapter<CanvasListAdapter.ViewHolder>  {

    private CanvasListModel mViewModel;
    private OnCardViewClicked onCardViewClicked;

    public void setOnCardViewClicked(OnCardViewClicked handler) {
        this.onCardViewClicked = handler;
        }

    public CanvasListAdapter(CanvasListModel viewModel, int rowLayout, Context context) {
        this.mViewModel = viewModel;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
            R.layout.adapter_canvas_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Canvas entry = mViewModel.canvases.get(position);
        holder.titleText.setText(getTitle(entry));
        holder.descriptionText.setText(getDesignedFor(entry));


        holder.view.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (onCardViewClicked != null) {
                onCardViewClicked.onCardClicked(v, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
         return mViewModel == null ? 0 : mViewModel.canvases.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView descriptionText;
        public TextView titleText;
        public View view;

        public ViewHolder(View itemView) {

            super(itemView);
            view = itemView.findViewById(R.id.canvas_list_text_title);
            titleText = (TextView) itemView.findViewById(R.id.canvas_list_text_title);
            descriptionText = (TextView) itemView.findViewById(R.id.canvas_list_text_description);
        }
    }

    public String getDesignedFor(Canvas canvas){
        if (canvas.ELEMENTS.size()>=2){
            return canvas.ELEMENTS.get(1).VALUE;
        }
        else{
            return "";
        }
    }

    public String getTitle(Canvas canvas){
        if (canvas.ELEMENTS.size()>=1){
            return canvas.ELEMENTS.get(0).VALUE;
        }
        else{
            return "No title";
        }
    }


}