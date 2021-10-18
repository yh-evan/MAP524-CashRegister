package yh.evanz.cashregister_assignment2;

import android.os.Parcel;
import android.os.Parcelable;

public class History implements Parcelable {
    public double total;
    public String name;
    public int quantity;
    public String date;


    public History(double total, String name, int quantity, String date) {
        this.total = total;
        this.name = name;
        this.quantity = quantity;
        this.date = date;
    }

    protected History(Parcel in) {
        total = in.readDouble();
        name = in.readString();
        quantity = in.readInt();
        date = in.readString();
    }

    public static final Creator<History> CREATOR = new Creator<History>() {
        @Override
        public History createFromParcel(Parcel in) {
            return new History(in);
        }

        @Override
        public History[] newArray(int size) {
            return new History[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(total);
        parcel.writeString(name);
        parcel.writeInt(quantity);
        parcel.writeString(date);
    }
}
