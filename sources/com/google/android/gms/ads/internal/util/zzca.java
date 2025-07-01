package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.ads.zzbcn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzca {
    private final Map zza = new HashMap();
    /* access modifiers changed from: private */
    public final List zzb = new ArrayList();
    private final Context zzc;

    zzca(Context context) {
        this.zzc = context;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzb(String str) {
        SharedPreferences sharedPreferences;
        if (!this.zza.containsKey(str)) {
            if (Objects.equals(str, "__default__")) {
                sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.zzc);
            } else {
                sharedPreferences = this.zzc.getSharedPreferences(str, 0);
            }
            zzbz zzbz = new zzbz(this, str);
            this.zza.put(str, zzbz);
            sharedPreferences.registerOnSharedPreferenceChangeListener(zzbz);
        }
    }

    public final void zzc() {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzkb)).booleanValue()) {
            zzv.zzq();
            Map zzv = zzs.zzv((String) zzbe.zzc().zza(zzbcn.zzkg));
            for (String zzb2 : zzv.keySet()) {
                zzb(zzb2);
            }
            zzd(new zzby(zzv));
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzd(zzby zzby) {
        this.zzb.add(zzby);
    }
}
