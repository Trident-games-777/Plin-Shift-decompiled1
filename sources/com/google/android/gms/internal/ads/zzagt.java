package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzagt implements Parcelable.Creator {
    zzagt() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String readString = parcel.readString();
        readString.getClass();
        String str = readString;
        String readString2 = parcel.readString();
        String[] createStringArray = parcel.createStringArray();
        createStringArray.getClass();
        return new zzagu(readString, readString2, zzfzo.zzm(createStringArray));
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzagu[i];
    }
}
