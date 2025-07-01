package com.google.android.gms.internal.ads;

import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzaxv implements PackageManager.OnChecksumsReadyListener {
    public final /* synthetic */ zzgfa zza;

    public /* synthetic */ zzaxv(zzgfa zzgfa) {
        this.zza = zzgfa;
    }

    public final void onChecksumsReady(List list) {
        zzgfa zzgfa = this.zza;
        if (list == null) {
            zzgfa.zzc((Object) null);
            return;
        }
        try {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ApkChecksum apkChecksum = (ApkChecksum) list.get(i);
                if (apkChecksum.getType() == 8) {
                    zzgfa.zzc(zzawi.zzb(apkChecksum.getValue()));
                    return;
                }
            }
            zzgfa.zzc((Object) null);
        } catch (Throwable unused) {
            zzgfa.zzc((Object) null);
        }
    }
}
