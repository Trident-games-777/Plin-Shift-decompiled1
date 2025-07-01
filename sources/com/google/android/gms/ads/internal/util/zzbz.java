package com.google.android.gms.ads.internal.util;

import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzv;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbz implements SharedPreferences.OnSharedPreferenceChangeListener {
    final /* synthetic */ zzca zza;
    private final String zzb;

    public zzbz(zzca zzca, String str) {
        this.zza = zzca;
        this.zzb = str;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zza) {
            for (zzby zzby : this.zza.zzb) {
                String str2 = this.zzb;
                Map map = zzby.zza;
                if (map.containsKey(str2) && ((Set) map.get(str2)).contains(str)) {
                    zzv.zzp().zzi().zzE(false);
                }
            }
        }
    }
}
