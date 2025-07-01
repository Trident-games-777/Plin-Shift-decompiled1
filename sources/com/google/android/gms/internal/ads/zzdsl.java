package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdsl {
    final /* synthetic */ zzdsm zza;
    private final Map zzb = new ConcurrentHashMap();

    zzdsl(zzdsm zzdsm) {
        this.zza = zzdsm;
    }

    public final zzdsl zzb(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.zzb.put(str, str2);
        }
        return this;
    }

    public final zzdsl zzc(zzfet zzfet) {
        zzb("aai", zzfet.zzw);
        zzb("request_id", zzfet.zzan);
        zzb(FirebaseAnalytics.Param.AD_FORMAT, zzfet.zza(zzfet.zzb));
        return this;
    }

    public final zzdsl zzd(zzfew zzfew) {
        zzb("gqi", zzfew.zzb);
        return this;
    }

    public final String zze() {
        return this.zza.zza.zzb(this.zzb);
    }

    public final void zzf() {
        this.zza.zzb.execute(new zzdsj(this));
    }

    public final void zzg() {
        this.zza.zzb.execute(new zzdsk(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh() {
        this.zza.zza.zzf(this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi() {
        this.zza.zza.zze(this.zzb);
    }
}
