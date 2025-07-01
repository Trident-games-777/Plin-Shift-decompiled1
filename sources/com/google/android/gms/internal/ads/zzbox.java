package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final /* synthetic */ class zzbox implements Runnable {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzbox(zzboy zzboy, Context context, String str) {
        this.zza = context;
        this.zzb = str;
    }

    public final void run() {
        Context context = this.zza;
        zzbcn.zza(context);
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzaD)).booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("measurementEnabled", ((Boolean) zzbe.zzc().zza(zzbcn.zzas)).booleanValue());
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzaz)).booleanValue()) {
                bundle.putString("ad_storage", "denied");
                bundle.putString("analytics_storage", "denied");
            }
            try {
                ((zzchj) zzq.zzb(context, "com.google.android.gms.ads.measurement.DynamiteMeasurementManager", new zzbow())).zze(ObjectWrapper.wrap(context), new zzbov(AppMeasurementSdk.getInstance(context, "FA-Ads", "am", this.zzb, bundle)));
            } catch (RemoteException | zzp | NullPointerException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
    }
}
