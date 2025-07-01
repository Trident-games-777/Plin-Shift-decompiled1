package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbwq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbwq> CREATOR = new zzbwr();
    public final zzm zza;
    public final String zzb;

    public zzbwq(zzm zzm, String str) {
        this.zza = zzm;
        this.zzb = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        zzm zzm = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, zzm, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
