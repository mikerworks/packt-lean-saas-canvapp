package com.packt.canvapp.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Represents an element of the business model canvas
 */
public class CanvasElement implements Parcelable {
    public String ID;
    public String TITLE;
    public String DESCRIPTION;
    public String VALUE;
    public String HINT;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.ID);
        dest.writeString(this.TITLE);
        dest.writeString(this.DESCRIPTION);
        dest.writeString(this.VALUE);
        dest.writeString(this.HINT);
    }

    protected CanvasElement(Parcel in) {
        this.ID = in.readString();
        this.TITLE = in.readString();
        this.DESCRIPTION = in.readString();
        this.VALUE = in.readString();
        this.HINT = in.readString();
    }

    public static final Parcelable.Creator<CanvasElement> CREATOR = new Parcelable.Creator<CanvasElement>() {
        @Override
        public CanvasElement createFromParcel(Parcel source) {
            return new CanvasElement(source);
        }

        @Override
        public CanvasElement[] newArray(int size) {
            return new CanvasElement[size];
        }
    };
}
