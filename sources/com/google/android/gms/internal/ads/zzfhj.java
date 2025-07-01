package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfhj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfhj> CREATOR = new zzfhk();
    @Nullable
    public final Context zza;
    public final zzfhg zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final String zzf;
    public final int zzg;
    private final zzfhg[] zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int[] zzl;
    private final int[] zzm;

    public zzfhj(int i, int i2, int i3, int i4, String str, int i5, int i6) {
        zzfhg[] values = zzfhg.values();
        this.zzh = values;
        int[] zza2 = zzfhh.zza();
        this.zzl = zza2;
        int[] zza3 = zzfhi.zza();
        this.zzm = zza3;
        this.zza = null;
        this.zzi = i;
        this.zzb = values[i];
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = str;
        this.zzj = i5;
        this.zzg = zza2[i5];
        this.zzk = i6;
        int i7 = zza3[i6];
    }

    @Nullable
    public static zzfhj zza(zzfhg zzfhg, Context context) {
        if (zzfhg == zzfhg.Rewarded) {
            return new zzfhj(context, zzfhg, ((Integer) zzbe.zzc().zza(zzbcn.zzgj)).intValue(), ((Integer) zzbe.zzc().zza(zzbcn.zzgp)).intValue(), ((Integer) zzbe.zzc().zza(zzbcn.zzgr)).intValue(), (String) zzbe.zzc().zza(zzbcn.zzgt), (String) zzbe.zzc().zza(zzbcn.zzgl), (String) zzbe.zzc().zza(zzbcn.zzgn));
        }
        zzfhg zzfhg2 = zzfhg;
        Context context2 = context;
        if (zzfhg2 == zzfhg.Interstitial) {
            return new zzfhj(context2, zzfhg2, ((Integer) zzbe.zzc().zza(zzbcn.zzgk)).intValue(), ((Integer) zzbe.zzc().zza(zzbcn.zzgq)).intValue(), ((Integer) zzbe.zzc().zza(zzbcn.zzgs)).intValue(), (String) zzbe.zzc().zza(zzbcn.zzgu), (String) zzbe.zzc().zza(zzbcn.zzgm), (String) zzbe.zzc().zza(zzbcn.zzgo));
        } else if (zzfhg2 != zzfhg.AppOpen) {
            return null;
        } else {
            return new zzfhj(context2, zzfhg2, ((Integer) zzbe.zzc().zza(zzbcn.zzgx)).intValue(), ((Integer) zzbe.zzc().zza(zzbcn.zzgz)).intValue(), ((Integer) zzbe.zzc().zza(zzbcn.zzgA)).intValue(), (String) zzbe.zzc().zza(zzbcn.zzgv), (String) zzbe.zzc().zza(zzbcn.zzgw), (String) zzbe.zzc().zza(zzbcn.zzgy));
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zzi;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeInt(parcel, 2, this.zzc);
        SafeParcelWriter.writeInt(parcel, 3, this.zzd);
        SafeParcelWriter.writeInt(parcel, 4, this.zze);
        SafeParcelWriter.writeString(parcel, 5, this.zzf, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzj);
        SafeParcelWriter.writeInt(parcel, 7, this.zzk);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private zzfhj(@Nullable Context context, zzfhg zzfhg, int i, int i2, int i3, String str, String str2, String str3) {
        int i4;
        this.zzh = zzfhg.values();
        this.zzl = zzfhh.zza();
        this.zzm = zzfhi.zza();
        this.zza = context;
        this.zzi = zzfhg.ordinal();
        this.zzb = zzfhg;
        this.zzc = i;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = str;
        if ("oldest".equals(str2)) {
            i4 = 1;
        } else if (!"lru".equals(str2) && "lfu".equals(str2)) {
            i4 = 3;
        } else {
            i4 = 2;
        }
        this.zzg = i4;
        this.zzj = i4 - 1;
        "onAdClosed".equals(str3);
        this.zzk = 0;
    }
}
