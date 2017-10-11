package com.packt.canvapp.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class Canvas implements Parcelable {

    private String id;
    public List<CanvasElement> ELEMENTS;

    public Canvas(){
        ELEMENTS = new ArrayList<>();
    }

    public void setId(String value){
        this.id= value;
    }

    public String getId(){
        return this.id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeTypedList(this.ELEMENTS);
    }

    protected Canvas(Parcel in) {
        this.id = in.readString();
        this.ELEMENTS = in.createTypedArrayList(CanvasElement.CREATOR);
    }

    public static final Parcelable.Creator<Canvas> CREATOR = new Parcelable.Creator<Canvas>() {
        @Override
        public Canvas createFromParcel(Parcel source) {
            return new Canvas(source);
        }

        @Override
        public Canvas[] newArray(int size) {
            return new Canvas[size];
        }
    };
}
