package com.google.android.gms.internal.ads;

import coil3.disk.DiskLruCache;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzegv implements zzefb {
    /* access modifiers changed from: private */
    public final zzcqh zza;
    private final zzegc zzb;
    private final zzges zzc;
    /* access modifiers changed from: private */
    public final zzcwo zzd;
    private final ScheduledExecutorService zze;
    private final zzdsh zzf;

    public zzegv(zzcqh zzcqh, zzegc zzegc, zzcwo zzcwo, ScheduledExecutorService scheduledExecutorService, zzges zzges, zzdsh zzdsh) {
        this.zza = zzcqh;
        this.zzb = zzegc;
        this.zzd = zzcwo;
        this.zze = scheduledExecutorService;
        this.zzc = zzges;
        this.zzf = zzdsh;
    }

    public final ListenableFuture zza(zzfff zzfff, zzfet zzfet) {
        return this.zzc.zzb(new zzegt(this, zzfff, zzfet));
    }

    public final boolean zzb(zzfff zzfff, zzfet zzfet) {
        zzbhp zza2 = zzfff.zza.zza.zza();
        boolean zzb2 = this.zzb.zzb(zzfff, zzfet);
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzlH)).booleanValue()) {
            zzdsh zzdsh = this.zzf;
            String str = DiskLruCache.VERSION;
            zzdsh.zzb().put("has_dbl", zza2 != null ? str : "0");
            zzdsh zzdsh2 = this.zzf;
            if (true != zzb2) {
                str = "0";
            }
            zzdsh2.zzb().put("crdb", str);
        }
        if (zza2 == null || !zzb2) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcpd zzc(zzfff zzfff, zzfet zzfet) throws Exception {
        return this.zza.zzb(new zzcsg(zzfff, zzfet, (String) null), new zzcqy(zzfff.zza.zza.zza(), new zzegs(this, zzfff, zzfet))).zza();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(zzfff zzfff, zzfet zzfet) {
        zzgei.zzr(zzgei.zzo(this.zzb.zza(zzfff, zzfet), (long) zzfet.zzR, TimeUnit.SECONDS, this.zze), new zzegu(this), this.zzc);
    }
}
