package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzxd implements zzxv {
    public final /* synthetic */ zzxp zza;

    public /* synthetic */ zzxd(zzxp zzxp) {
        this.zza = zzxp;
    }

    public final List zza(int i, zzbw zzbw, int[] iArr) {
        int i2 = zzyb.zzb;
        zzfzl zzfzl = new zzfzl();
        for (int i3 = 0; i3 < zzbw.zza; i3++) {
            zzfzl.zzf(new zzxm(i, zzbw, i3, this.zza, iArr[i3]));
        }
        return zzfzl.zzi();
    }
}
