package br.com.byu.guidebook.domain.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Guide implements Parcelable {

    public static final Creator<Guide> CREATOR = new Creator<Guide>() {
        @Override
        public Guide createFromParcel(Parcel source) {
            return new Guide(source);
        }

        @Override
        public Guide[] newArray(int size) {
            return new Guide[size];
        }
    };

    public String endDate;
    public String name;
    public String url;
    public String icon;
    public String startDate;

    protected Guide(Parcel in) {

        this.endDate = in.readString();
        this.name = in.readString();
        this.url = in.readString();
        this.icon = in.readString();
        this.startDate  = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(this.endDate);
        dest.writeString(this.name);
        dest.writeString(this.url);
        dest.writeString(this.icon);
        dest.writeString(this.startDate);
    }
}