package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzaha implements Parcelable.Creator {
    zzaha() {
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, zzahc.class.getClassLoader());
        return new zzahd(arrayList);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzahd[i];
    }
}
