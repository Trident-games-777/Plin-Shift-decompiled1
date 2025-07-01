package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import coil3.disk.DiskLruCache;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzdsh;
import com.google.android.gms.internal.ads.zzdsr;
import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzk extends QueryInfoGenerationCallback {
    private final zzj zza;
    private final zzdsr zzb;
    private final boolean zzc;
    private final int zzd;
    private final long zze = zzv.zzC().currentTimeMillis();
    private final Boolean zzf;

    public zzk(zzj zzj, boolean z, int i, Boolean bool, zzdsr zzdsr) {
        this.zza = zzj;
        this.zzc = z;
        this.zzd = i;
        this.zzf = bool;
        this.zzb = zzdsr;
    }

    private static long zza() {
        return zzv.zzC().currentTimeMillis() + ((Long) zzbe.zzc().zza(zzbcn.zzjz)).longValue();
    }

    private final long zzb() {
        return zzv.zzC().currentTimeMillis() - this.zze;
    }

    public final void onFailure(String str) {
        String str2;
        Pair[] pairArr = new Pair[9];
        pairArr[0] = new Pair("sgf_reason", str);
        pairArr[1] = new Pair("se", "query_g");
        pairArr[2] = new Pair(FirebaseAnalytics.Param.AD_FORMAT, AdFormat.BANNER.name());
        pairArr[3] = new Pair("rtype", Integer.toString(6));
        pairArr[4] = new Pair("scar", "true");
        pairArr[5] = new Pair("lat_ms", Long.toString(zzb()));
        pairArr[6] = new Pair("sgpc_rn", Integer.toString(this.zzd));
        pairArr[7] = new Pair("sgpc_lsu", String.valueOf(this.zzf));
        if (true != this.zzc) {
            str2 = "0";
        } else {
            str2 = DiskLruCache.VERSION;
        }
        pairArr[8] = new Pair("tpc", str2);
        zzv.zzd(this.zzb, (zzdsh) null, "sgpcf", pairArr);
        this.zza.zzf(this.zzc, new zzl((QueryInfo) null, str, zza(), this.zzd));
    }

    public final void onSuccess(QueryInfo queryInfo) {
        String str;
        Pair[] pairArr = new Pair[8];
        pairArr[0] = new Pair("se", "query_g");
        pairArr[1] = new Pair(FirebaseAnalytics.Param.AD_FORMAT, AdFormat.BANNER.name());
        pairArr[2] = new Pair("rtype", Integer.toString(6));
        pairArr[3] = new Pair("scar", "true");
        pairArr[4] = new Pair("lat_ms", Long.toString(zzb()));
        pairArr[5] = new Pair("sgpc_rn", Integer.toString(this.zzd));
        pairArr[6] = new Pair("sgpc_lsu", String.valueOf(this.zzf));
        if (true != this.zzc) {
            str = "0";
        } else {
            str = DiskLruCache.VERSION;
        }
        pairArr[7] = new Pair("tpc", str);
        zzv.zzd(this.zzb, (zzdsh) null, "sgpcs", pairArr);
        this.zza.zzf(this.zzc, new zzl(queryInfo, "", zza(), this.zzd));
    }
}
