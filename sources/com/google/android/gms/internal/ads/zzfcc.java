package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfcc implements zzfwh {
    final /* synthetic */ zzfcg zza;

    zzfcc(zzfcg zzfcg) {
        this.zza = zzfcg;
    }

    @NullableDecl
    public final /* bridge */ /* synthetic */ Object apply(@NullableDecl Object obj) {
        zzm.zzh("", (zzdyw) obj);
        zze.zza("Failed to get a cache key, reverting to legacy flow.");
        zzfcg zzfcg = this.zza;
        zzfcg.zzd = new zzfce((zzbvx) null, zzfcg.zze(), (zzfcf) null);
        return this.zza.zzd;
    }
}
