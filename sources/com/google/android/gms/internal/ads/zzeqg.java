package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeqg implements zzevz {
    private final zzges zza;
    private final Context zzb;

    zzeqg(zzges zzges, Context context) {
        this.zza = zzges;
        this.zzb = context;
    }

    private final Intent zzd() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzkG)).booleanValue() || Build.VERSION.SDK_INT < 33) {
            return this.zzb.registerReceiver((BroadcastReceiver) null, intentFilter);
        }
        return this.zzb.registerReceiver((BroadcastReceiver) null, intentFilter, 4);
    }

    private static final boolean zze(Intent intent) {
        if (intent == null) {
            return false;
        }
        int intExtra = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
        return intExtra == 2 || intExtra == 5;
    }

    public final int zza() {
        return 14;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzeqf(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzeqh zzc() throws Exception {
        boolean z;
        double d = -1.0d;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzlJ)).booleanValue()) {
            BatteryManager batteryManager = (BatteryManager) this.zzb.getSystemService("batterymanager");
            if (batteryManager != null) {
                d = ((double) batteryManager.getIntProperty(4)) / 100.0d;
            }
            if (batteryManager != null) {
                z = batteryManager.isCharging();
            } else {
                z = zze(zzd());
            }
        } else {
            Intent zzd = zzd();
            boolean zze = zze(zzd);
            if (zzd != null) {
                d = ((double) zzd.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1)) / ((double) zzd.getIntExtra("scale", -1));
            }
            z = zze;
        }
        return new zzeqh(d, z);
    }
}
