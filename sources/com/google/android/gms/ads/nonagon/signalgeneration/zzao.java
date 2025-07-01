package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzdsh;
import com.google.android.gms.internal.ads.zzgee;
import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzao implements zzgee {
    final /* synthetic */ zzap zza;

    zzao(zzap zzap) {
        this.zza = zzap;
    }

    public final void zza(Throwable th) {
        zzv.zzp().zzw(th, "SignalGeneratorImpl.initializeWebViewForSignalCollection");
        zzv.zzd(this.zza.zzp, (zzdsh) null, "sgf", new Pair("sgf_reason", th.getMessage()), new Pair("se", "query_g"), new Pair(FirebaseAnalytics.Param.AD_FORMAT, AdFormat.BANNER.name()), new Pair("rtype", Integer.toString(6)), new Pair("scar", "true"), new Pair("sgi_rn", Integer.toString(this.zza.zzH.get())));
        zzm.zzh("Failed to initialize webview for loading SDKCore. ", th);
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzjn)).booleanValue() && !this.zza.zzG.get()) {
            if (this.zza.zzH.getAndIncrement() < ((Integer) zzbe.zzc().zza(zzbcn.zzjo)).intValue()) {
                this.zza.zzT();
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzbd zzbd = (zzbd) obj;
        zzm.zze("Initialized webview successfully for SDKCore.");
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzjn)).booleanValue()) {
            zzv.zzd(this.zza.zzp, (zzdsh) null, "sgs", new Pair("se", "query_g"), new Pair(FirebaseAnalytics.Param.AD_FORMAT, AdFormat.BANNER.name()), new Pair("rtype", Integer.toString(6)), new Pair("scar", "true"), new Pair("sgi_rn", Integer.toString(this.zza.zzH.get())));
            this.zza.zzG.set(true);
        }
    }
}
