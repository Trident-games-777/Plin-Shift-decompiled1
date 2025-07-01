package com.google.android.gms.internal.ads;

import android.app.AppOpsManager;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzawn implements AppOpsManager.OnOpActiveChangedListener {
    final /* synthetic */ zzawo zza;

    zzawn(zzawo zzawo) {
        this.zza = zzawo;
    }

    public final void onOpActiveChanged(String str, int i, String str2, boolean z) {
        if (z) {
            this.zza.zzb = System.currentTimeMillis();
            this.zza.zze = true;
            return;
        }
        zzawo zzawo = this.zza;
        long currentTimeMillis = System.currentTimeMillis();
        if (zzawo.zzc > 0) {
            zzawo zzawo2 = this.zza;
            if (currentTimeMillis >= zzawo2.zzc) {
                zzawo2.zzd = currentTimeMillis - zzawo2.zzc;
            }
        }
        this.zza.zze = false;
    }
}
