package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzewc {
    private final Context zza;
    private final Set zzb;
    private final Executor zzc;
    private final zzfkl zzd;
    private final zzdsm zze;
    private long zzf = 0;
    private int zzg = 0;

    public zzewc(Context context, Executor executor, Set set, zzfkl zzfkl, zzdsm zzdsm) {
        this.zza = context;
        this.zzc = executor;
        this.zzb = set;
        this.zzd = zzfkl;
        this.zze = zzdsm;
    }

    public final ListenableFuture zza(Object obj, Bundle bundle) {
        zzfka zza2 = zzfjz.zza(this.zza, 8);
        zza2.zzi();
        ArrayList arrayList = new ArrayList(this.zzb.size());
        List arrayList2 = new ArrayList();
        if (!((String) zzbe.zzc().zza(zzbcn.zzlt)).isEmpty()) {
            arrayList2 = Arrays.asList(((String) zzbe.zzc().zza(zzbcn.zzlt)).split(","));
        }
        this.zzf = zzv.zzC().elapsedRealtime();
        Bundle bundle2 = new Bundle();
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzci)).booleanValue() && bundle != null) {
            long currentTimeMillis = zzv.zzC().currentTimeMillis();
            if (obj instanceof Bundle) {
                bundle.putLong(zzdrv.CLIENT_SIGNALS_START.zza(), currentTimeMillis);
            } else {
                bundle.putLong(zzdrv.GMS_SIGNALS_START.zza(), currentTimeMillis);
            }
        }
        for (zzevz zzevz : this.zzb) {
            if (!arrayList2.contains(String.valueOf(zzevz.zza()))) {
                long elapsedRealtime = zzv.zzC().elapsedRealtime();
                ListenableFuture zzb2 = zzevz.zzb();
                zzb2.addListener(new zzewa(this, elapsedRealtime, zzevz, bundle2), zzcaj.zzf);
                arrayList.add(zzb2);
            }
        }
        ListenableFuture zza3 = zzgei.zzb(arrayList).zza(new zzewb(arrayList, obj, bundle, bundle2), this.zzc);
        if (zzfko.zza()) {
            zzfkk.zza(zza3, this.zzd, zza2);
        }
        return zza3;
    }

    public final void zzb(long j, zzevz zzevz, Bundle bundle) {
        long elapsedRealtime = zzv.zzC().elapsedRealtime() - j;
        if (((Boolean) zzbep.zza.zze()).booleanValue()) {
            zze.zza("Signal runtime (ms) : " + zzfxf.zzc(zzevz.getClass().getCanonicalName()) + " = " + elapsedRealtime);
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzci)).booleanValue()) {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzcm)).booleanValue()) {
                synchronized (this) {
                    bundle.putLong("sig" + zzevz.zza(), elapsedRealtime);
                }
            }
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzcg)).booleanValue()) {
            zzdsl zza2 = this.zze.zza();
            zza2.zzb("action", "lat_ms");
            zza2.zzb("lat_grp", "sig_lat_grp");
            zza2.zzb("lat_id", String.valueOf(zzevz.zza()));
            zza2.zzb("clat_ms", String.valueOf(elapsedRealtime));
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzch)).booleanValue()) {
                synchronized (this) {
                    this.zzg++;
                }
                zza2.zzb("seq_num", zzv.zzp().zzh().zzd());
                synchronized (this) {
                    if (this.zzg == this.zzb.size() && this.zzf != 0) {
                        this.zzg = 0;
                        String valueOf = String.valueOf(zzv.zzC().elapsedRealtime() - this.zzf);
                        if (zzevz.zza() <= 39 || zzevz.zza() >= 52) {
                            zza2.zzb("lat_clsg", valueOf);
                        } else {
                            zza2.zzb("lat_gmssg", valueOf);
                        }
                    }
                }
            }
            zza2.zzg();
        }
    }
}
