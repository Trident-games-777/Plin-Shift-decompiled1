package com.google.android.gms.ads.internal.util;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzfgq;
import com.google.android.gms.internal.ads.zzfxf;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzba extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzba> CREATOR = new zzbb();
    public final String zza;
    public final int zzb;

    zzba(String str, int i) {
        this.zza = str == null ? "" : str;
        this.zzb = i;
    }

    public static zzba zzb(Throwable th) {
        String str;
        zze zza2 = zzfgq.zza(th);
        if (zzfxf.zzd(th.getMessage())) {
            str = zza2.zzb;
        } else {
            str = th.getMessage();
        }
        return new zzba(str, zza2.zza);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, str, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzaz zza() {
        return new zzaz(this.zza, this.zzb);
    }
}
