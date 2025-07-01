package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzxf implements zzxv {
    public final /* synthetic */ zzyb zza;
    public final /* synthetic */ zzxp zzb;
    public final /* synthetic */ boolean zzc;
    public final /* synthetic */ int[] zzd;

    public /* synthetic */ zzxf(zzyb zzyb, zzxp zzxp, boolean z, int[] iArr) {
        this.zza = zzyb;
        this.zzb = zzxp;
        this.zzc = z;
        this.zzd = iArr;
    }

    public final List zza(int i, zzbw zzbw, int[] iArr) {
        zzxc zzxc = new zzxc(this.zza);
        int i2 = this.zzd[i];
        zzfzl zzfzl = new zzfzl();
        for (int i3 = 0; i3 < zzbw.zza; i3++) {
            zzfzl.zzf(new zzxl(i, zzbw, i3, this.zzb, iArr[i3], this.zzc, zzxc, i2));
        }
        return zzfzl.zzi();
    }
}
