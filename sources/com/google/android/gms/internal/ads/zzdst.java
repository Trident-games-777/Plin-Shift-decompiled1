package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdst implements SharedPreferences.OnSharedPreferenceChangeListener {
    public final /* synthetic */ zzdsu zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzdst(zzdsu zzdsu, String str) {
        this.zza = zzdsu;
        this.zzb = str;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        this.zza.zzd(this.zzb, sharedPreferences, str);
    }
}
