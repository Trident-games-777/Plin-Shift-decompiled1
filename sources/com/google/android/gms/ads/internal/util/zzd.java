package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.ads.internal.util.client.zzl;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.internal.ads.zzbej;
import com.google.android.gms.internal.ads.zzcam;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzd {
    public static void zza(Context context) {
        int i = zzl.zza;
        if (((Boolean) zzbej.zza.zze()).booleanValue()) {
            try {
                if (Settings.Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0 && !zzl.zzl()) {
                    ListenableFuture zzb = new zzc(context).zzb();
                    zzm.zzi("Updating ad debug logging enablement.");
                    zzcam.zza(zzb, "AdDebugLogUpdater.updateEnablement");
                }
            } catch (Exception e) {
                zzm.zzk("Fail to determine debug setting.", e);
            }
        }
    }
}
