package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import coil3.disk.DiskLruCache;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeps implements zzevz {
    private static final Object zzb = new Object();
    final Context zza;
    private final String zzc;
    private final String zzd;
    private final long zze;
    private final zzctk zzf;
    private final zzfgw zzg;
    private final zzffo zzh;
    private final zzg zzi = zzv.zzp().zzi();
    private final zzdsh zzj;
    private final zzctx zzk;

    public zzeps(Context context, String str, String str2, zzctk zzctk, zzfgw zzfgw, zzffo zzffo, zzdsh zzdsh, zzctx zzctx, long j) {
        this.zza = context;
        this.zzc = str;
        this.zzd = str2;
        this.zzf = zzctk;
        this.zzg = zzfgw;
        this.zzh = zzffo;
        this.zzj = zzdsh;
        this.zzk = zzctx;
        this.zze = j;
    }

    public final int zza() {
        return 12;
    }

    public final ListenableFuture zzb() {
        String str;
        Bundle bundle = new Bundle();
        this.zzj.zzb().put("seq_num", this.zzc);
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzci)).booleanValue()) {
            this.zzj.zzc("tsacc", String.valueOf(zzv.zzC().currentTimeMillis() - this.zze));
            zzdsh zzdsh = this.zzj;
            zzv.zzq();
            if (true != zzs.zzG(this.zza)) {
                str = DiskLruCache.VERSION;
            } else {
                str = "0";
            }
            zzdsh.zzc("foreground", str);
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzfA)).booleanValue()) {
            this.zzf.zzk(this.zzh.zzd);
            bundle.putAll(this.zzg.zzb());
        }
        return zzgei.zzh(new zzepr(this, bundle));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Bundle bundle, Bundle bundle2) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzfA)).booleanValue()) {
            bundle2.putBundle("quality_signals", bundle);
        } else {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzfz)).booleanValue()) {
                synchronized (zzb) {
                    this.zzf.zzk(this.zzh.zzd);
                    bundle2.putBundle("quality_signals", this.zzg.zzb());
                }
            } else {
                this.zzf.zzk(this.zzh.zzd);
                bundle2.putBundle("quality_signals", this.zzg.zzb());
            }
        }
        bundle2.putString("seq_num", this.zzc);
        if (!this.zzi.zzN()) {
            bundle2.putString("session_id", this.zzd);
        }
        bundle2.putBoolean("client_purpose_one", !this.zzi.zzN());
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzfB)).booleanValue()) {
            try {
                zzv.zzq();
                bundle2.putString("_app_id", zzs.zzp(this.zza));
            } catch (RemoteException | RuntimeException e) {
                zzv.zzp().zzw(e, "AppStatsSignal_AppId");
            }
        }
        if (this.zzh.zzf != null) {
            Bundle bundle3 = new Bundle();
            bundle3.putLong("dload", this.zzk.zzb(this.zzh.zzf));
            bundle3.putInt("pcc", this.zzk.zza(this.zzh.zzf));
            bundle2.putBundle("ad_unit_quality_signals", bundle3);
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzjp)).booleanValue() && zzv.zzp().zza() > 0) {
            bundle2.putInt("nrwv", zzv.zzp().zza());
        }
    }
}
