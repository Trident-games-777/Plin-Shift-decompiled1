package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzxj implements zzxv {
    public final /* synthetic */ zzxp zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzxj(zzxp zzxp, String str) {
        this.zza = zzxp;
        this.zzb = str;
    }

    public final List zza(int i, zzbw zzbw, int[] iArr) {
        int i2 = zzyb.zzb;
        zzfzl zzfzl = new zzfzl();
        for (int i3 = 0; i3 < zzbw.zza; i3++) {
            zzfzl.zzf(new zzxu(i, zzbw, i3, this.zza, iArr[i3], this.zzb));
        }
        return zzfzl.zzi();
    }
}
