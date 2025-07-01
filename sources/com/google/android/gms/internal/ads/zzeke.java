package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeke implements zzefh {
    private final Context zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    private final zzdow zzc;

    public zzeke(Context context, Executor executor, zzdow zzdow) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdow;
    }

    /* access modifiers changed from: private */
    public static final void zze(zzfff zzfff, zzfet zzfet, zzefe zzefe) {
        try {
            ((zzfgm) zzefe.zzb).zzk(zzfff.zza.zza.zzd, zzfet.zzv.toString());
        } catch (Exception e) {
            zzm.zzk("Fail to load ad from adapter ".concat(String.valueOf(zzefe.zza)), e);
        }
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfff zzfff, zzfet zzfet, zzefe zzefe) throws zzffv, zzeiz {
        zzdos zze = this.zzc.zze(new zzcsg(zzfff, zzfet, zzefe.zza), new zzdot(new zzeka(zzefe)));
        zze.zzd().zzo(new zzcmr((zzfgm) zzefe.zzb), this.zzb);
        zzcxt zze2 = zze.zze();
        zzcwk zzb2 = zze.zzb();
        ((zzegy) zzefe.zzc).zzc(new zzekd(this, zze.zza(), zzb2, zze2, zze.zzg()));
        return zze.zzi();
    }

    public final void zzb(zzfff zzfff, zzfet zzfet, zzefe zzefe) throws zzffv {
        if (!((zzfgm) zzefe.zzb).zzC()) {
            ((zzegy) zzefe.zzc).zzd(new zzekc(this, zzfff, zzfet, zzefe));
            Object obj = zzefe.zzb;
            Context context = this.zza;
            zzffo zzffo = zzfff.zza.zza;
            String jSONObject = zzfet.zzv.toString();
            ((zzfgm) obj).zzh(context, zzffo.zzd, (String) null, (zzbwu) zzefe.zzc, jSONObject);
            return;
        }
        zze(zzfff, zzfet, zzefe);
    }
}
