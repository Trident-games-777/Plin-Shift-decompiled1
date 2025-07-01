package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzr;
import com.google.android.gms.ads.internal.util.zzac;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.nonagon.util.logging.csi.CsiUrlBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public class zzdsu {
    protected final Map zza = new HashMap();
    protected final Context zzb;
    protected final Executor zzc;
    protected final zzr zzd;
    protected final boolean zze;
    private final CsiUrlBuilder zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final AtomicBoolean zzi = new AtomicBoolean();
    private final AtomicReference zzj = new AtomicReference(new Bundle());

    protected zzdsu(Executor executor, zzr zzr, CsiUrlBuilder csiUrlBuilder, Context context) {
        String str = (String) zzbeh.zza.zze();
        this.zzc = executor;
        this.zzd = zzr;
        this.zze = ((Boolean) zzbe.zzc().zza(zzbcn.zzcd)).booleanValue();
        this.zzf = csiUrlBuilder;
        this.zzg = ((Boolean) zzbe.zzc().zza(zzbcn.zzcg)).booleanValue();
        this.zzh = ((Boolean) zzbe.zzc().zza(zzbcn.zzgP)).booleanValue();
        this.zzb = context;
    }

    private final void zza(Map map, boolean z) {
        if (!map.isEmpty()) {
            if (map == null || map.isEmpty()) {
                zzm.zze("Empty or null paramMap.");
            } else {
                if (!this.zzi.getAndSet(true)) {
                    String str = (String) zzbe.zzc().zza(zzbcn.zzkh);
                    this.zzj.set(zzac.zza(this.zzb, str, new zzdst(this, str)));
                }
                Bundle bundle = (Bundle) this.zzj.get();
                for (String str2 : bundle.keySet()) {
                    map.put(str2, String.valueOf(bundle.get(str2)));
                }
            }
            String generateUrl = this.zzf.generateUrl(map);
            zze.zza(generateUrl);
            boolean parseBoolean = Boolean.parseBoolean((String) map.get("scar"));
            if (!this.zze) {
                return;
            }
            if (z && !this.zzg) {
                return;
            }
            if (!parseBoolean || this.zzh) {
                this.zzc.execute(new zzdss(this, generateUrl));
                return;
            }
            return;
        }
        zzm.zze("Empty paramMap.");
    }

    /* access modifiers changed from: protected */
    public final String zzb(Map map) {
        return this.zzf.generateUrl(map);
    }

    public final ConcurrentHashMap zzc() {
        return new ConcurrentHashMap(this.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(String str, SharedPreferences sharedPreferences, String str2) {
        this.zzj.set(zzac.zzb(this.zzb, str));
    }

    public final void zze(Map map) {
        zza(map, true);
    }

    public final void zzf(Map map) {
        zza(map, false);
    }
}
