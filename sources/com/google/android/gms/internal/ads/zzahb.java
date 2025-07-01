package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzahb implements Parcelable.Creator {
    zzahb() {
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzahc(parcel.readLong(), parcel.readLong(), parcel.readInt());
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzahc[i];
    }
}
