package com.google.android.gms.internal.ads;

import java.util.Iterator;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeix {
    private final zzfgg zza;
    private final zzdqa zzb;
    private final zzdsm zzc;

    public zzeix(zzfgg zzfgg, zzdqa zzdqa, zzdsm zzdsm) {
        this.zza = zzfgg;
        this.zzb = zzdqa;
        this.zzc = zzdsm;
    }

    public final void zza(zzfew zzfew, zzfet zzfet, int i, @Nullable zzeff zzeff, long j) {
        zzdpz zzdpz;
        zzdsl zza2 = this.zzc.zza();
        zza2.zzd(zzfew);
        zza2.zzc(zzfet);
        zza2.zzb("action", "adapter_status");
        zza2.zzb("adapter_l", String.valueOf(j));
        zza2.zzb("sc", Integer.toString(i));
        if (zzeff != null) {
            zza2.zzb("arec", Integer.toString(zzeff.zzb().zza));
            String zza3 = this.zza.zza(zzeff.getMessage());
            if (zza3 != null) {
                zza2.zzb("areec", zza3);
            }
        }
        zzdqa zzdqa = this.zzb;
        Iterator it = zzfet.zzt.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzdpz = null;
                break;
            }
            zzdpz = zzdqa.zza((String) it.next());
            if (zzdpz != null) {
                break;
            }
        }
        if (zzdpz != null) {
            zza2.zzb("ancn", zzdpz.zza);
            zzbru zzbru = zzdpz.zzb;
            if (zzbru != null) {
                zza2.zzb("adapter_v", zzbru.toString());
            }
            zzbru zzbru2 = zzdpz.zzc;
            if (zzbru2 != null) {
                zza2.zzb("adapter_sv", zzbru2.toString());
            }
        }
        zza2.zzf();
    }
}
