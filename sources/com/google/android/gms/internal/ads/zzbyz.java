package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbyz implements SharedPreferences.OnSharedPreferenceChangeListener {
    final /* synthetic */ zzbza zza;
    private final String zzb;

    public zzbyz(zzbza zzbza, String str) {
        this.zza = zzbza;
        this.zzb = str;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zza) {
            for (zzbyy zzbyy : this.zza.zzb) {
                zzbyy.zza.zzb(zzbyy.zzb, sharedPreferences, this.zzb, str);
            }
        }
    }
}
