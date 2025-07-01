package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import com.google.android.gms.ads.internal.client.zzbe;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbdm extends CustomTabsServiceConnection {
    public static final /* synthetic */ int zza = 0;
    private final AtomicBoolean zzb = new AtomicBoolean(false);
    private Context zzc;
    private zzdsm zzd;
    private CustomTabsSession zze;
    private CustomTabsClient zzf;

    private final void zzf(Context context) {
        String packageName;
        if (this.zzf == null && context != null && (packageName = CustomTabsClient.getPackageName(context, (List<String>) null)) != null) {
            CustomTabsClient.bindCustomTabsService(context, packageName, this);
        }
    }

    public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        this.zzf = customTabsClient;
        customTabsClient.warmup(0);
        this.zze = customTabsClient.newSession(new zzbdl(this));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.zzf = null;
        this.zze = null;
    }

    public final CustomTabsSession zza() {
        if (this.zze == null) {
            zzcaj.zza.execute(new zzbdk(this));
        }
        return this.zze;
    }

    public final void zzb(Context context, zzdsm zzdsm) {
        if (!this.zzb.getAndSet(true)) {
            this.zzc = context;
            this.zzd = zzdsm;
            zzf(context);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc() {
        zzf(this.zzc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(int i) {
        zzdsm zzdsm = this.zzd;
        if (zzdsm != null) {
            zzdsl zza2 = zzdsm.zza();
            zza2.zzb("action", "cct_nav");
            zza2.zzb("cct_navs", String.valueOf(i));
            zza2.zzf();
        }
    }

    public final void zze(int i) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzeE)).booleanValue() && this.zzd != null) {
            zzcaj.zza.execute(new zzbdj(this, i));
        }
    }
}
