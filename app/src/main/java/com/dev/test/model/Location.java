package com.dev.test.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Location implements Parcelable {
    private String name;
    private String image;
    private String description;

    public Location(String name, String image, String description) {
        this.name = name;
        this.image = image;
        this.description = description;
    }

    protected Location(Parcel in) {
        name = in.readString();
        image = in.readString();
        description = in.readString();
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(image);
        parcel.writeString(description);
    }
}
