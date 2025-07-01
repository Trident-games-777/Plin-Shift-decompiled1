package com.google.android.gms.internal.ads;

import android.view.ViewParent;
import coil3.disk.DiskLruCache;
import com.google.android.gms.ads.internal.client.zzbe;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcqe implements zzcxg {
    private final zzcfk zza;
    private final zzdsm zzb;
    private final zzfet zzc;

    zzcqe(zzcfk zzcfk, zzdsm zzdsm, zzfet zzfet) {
        this.zza = zzcfk;
        this.zzb = zzdsm;
        this.zzc = zzfet;
    }

    public final void zzr() {
        zzcfk zzcfk;
        boolean z;
        String str;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzmB)).booleanValue() && (zzcfk = this.zza) != null) {
            ViewParent parent = zzcfk.zzF().getParent();
            while (true) {
                if (parent == null) {
                    z = false;
                    break;
                } else if (parent.getClass().getName().startsWith("androidx.compose.ui")) {
                    z = true;
                    break;
                } else {
                    parent = parent.getParent();
                }
            }
            zzdsl zza2 = this.zzb.zza();
            zza2.zzb("action", "hcp");
            if (true != z) {
                str = "0";
            } else {
                str = DiskLruCache.VERSION;
            }
            zza2.zzb("hcp", str);
            zza2.zzc(this.zzc);
            zza2.zzf();
        }
    }
}
