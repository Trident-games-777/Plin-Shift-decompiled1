package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.webkit.CookieManager;
import android.webkit.WebView;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzcaj;
import com.google.android.gms.internal.ads.zzdsh;
import com.google.android.gms.internal.ads.zzdsr;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzj {
    private final Map zza = new HashMap();
    private final Map zzb = new HashMap();
    private final Context zzc;
    private final zzdsr zzd;
    private final ExecutorService zze;

    zzj(Context context, zzdsr zzdsr, ExecutorService executorService) {
        this.zzc = context;
        this.zzd = zzdsr;
        this.zze = executorService;
    }

    private final void zzh(boolean z) {
        Map map = this.zzb;
        Boolean valueOf = Boolean.valueOf(z);
        if (!map.containsKey(valueOf)) {
            this.zzb.put(valueOf, new ArrayList());
            this.zze.submit(new zzh(this, z));
        }
    }

    private final void zzi(zzl zzl, Pair pair, boolean z) {
        zzl.zzd();
        QueryInfo zzb2 = zzl.zzb();
        if (zzb2 != null) {
            ((QueryInfoGenerationCallback) pair.first).onSuccess(zzb2);
        } else {
            ((QueryInfoGenerationCallback) pair.first).onFailure(zzl.zzc());
        }
        zzdsr zzdsr = this.zzd;
        Pair[] pairArr = new Pair[7];
        boolean z2 = false;
        pairArr[0] = new Pair("se", "query_g");
        pairArr[1] = new Pair(FirebaseAnalytics.Param.AD_FORMAT, AdFormat.BANNER.name());
        pairArr[2] = new Pair("rtype", Integer.toString(6));
        pairArr[3] = new Pair("scar", "true");
        pairArr[4] = new Pair("lat_ms", Long.toString(zzv.zzC().currentTimeMillis() - ((Long) pair.second).longValue()));
        pairArr[5] = new Pair("sgpc_h", Boolean.toString(z));
        if (zzl.zzb() != null) {
            z2 = true;
        }
        pairArr[6] = new Pair("sgpc_rs", Boolean.toString(z2));
        zzv.zzd(zzdsr, (zzdsh) null, "sgpcr", pairArr);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzj */
    public final synchronized void zzd(boolean z, boolean z2) {
        Throwable th;
        Boolean valueOf;
        try {
            Bundle bundle = new Bundle();
            bundle.putString("query_info_type", "requester_type_6");
            bundle.putBoolean("accept_3p_cookie", z);
            Map map = this.zza;
            Boolean valueOf2 = Boolean.valueOf(z);
            zzl zzl = (zzl) map.get(valueOf2);
            int i = 0;
            if (z2 && zzl != null) {
                try {
                    i = zzl.zza() + 1;
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            }
            int i2 = i;
            zzl zzl2 = (zzl) this.zza.get(valueOf2);
            if (zzl2 == null) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(zzl2.zzf());
            }
            try {
                zzk zzk = new zzk(this, z, i2, valueOf, this.zzd);
                AdRequest build = ((AdRequest.Builder) new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, bundle)).build();
                if (((Boolean) zzbe.zzc().zza(zzbcn.zzkK)).booleanValue()) {
                    this.zze.submit(new zzi(this, build, zzk));
                } else {
                    QueryInfo.generate(this.zzc, AdFormat.BANNER, build, zzk);
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza(AdRequest adRequest, zzk zzk) throws Exception {
        QueryInfo.generate(this.zzc, AdFormat.BANNER, adRequest, zzk);
        return true;
    }

    public final synchronized void zzb() {
        zzh(true);
        zzh(false);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(boolean z) {
        zzd(z, false);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(Object obj, Pair pair) {
        CookieManager zza2;
        boolean z = false;
        if ((obj instanceof WebView) && (zza2 = zzv.zzr().zza(this.zzc)) != null) {
            z = zza2.acceptThirdPartyCookies((WebView) obj);
        }
        Map map = this.zza;
        Boolean valueOf = Boolean.valueOf(z);
        zzl zzl = (zzl) map.get(valueOf);
        if (zzl == null || zzl.zze()) {
            List list = (List) this.zzb.get(valueOf);
            if (list == null) {
                list = new ArrayList();
                this.zzb.put(valueOf, list);
            }
            list.add(pair);
            return;
        }
        zzi(zzl, pair, true);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzf(boolean z, zzl zzl) {
        Integer num;
        Map map = this.zza;
        Boolean valueOf = Boolean.valueOf(z);
        zzl zzl2 = (zzl) map.get(valueOf);
        if (zzl2 == null || zzl2.zze() || zzl2.zzb() == null || zzl.zzb() != null) {
            this.zza.put(valueOf, zzl);
        }
        if (zzl.zzb() != null) {
            num = (Integer) zzbe.zzc().zza(zzbcn.zzjA);
        } else {
            num = (Integer) zzbe.zzc().zza(zzbcn.zzjB);
        }
        zzcaj.zzd.schedule(new zzg(this, z, zzl.zzb() == null), (long) num.intValue(), TimeUnit.SECONDS);
        List<Pair> list = (List) this.zzb.get(valueOf);
        this.zzb.put(valueOf, new ArrayList());
        if (list != null) {
            for (Pair zzi : list) {
                zzi(zzl, zzi, false);
            }
        }
    }

    public final synchronized void zzg(Object obj, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzcaj.zze.execute(new zzf(this, obj, new Pair(queryInfoGenerationCallback, Long.valueOf(zzv.zzC().currentTimeMillis()))));
    }
}
