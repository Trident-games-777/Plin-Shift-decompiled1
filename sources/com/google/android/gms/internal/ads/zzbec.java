package com.google.android.gms.internal.ads;

import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkRequest;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbec {
    public static final zzbdx zza = zzbdx.zzb("gads:app_permissions_caching_expiry_ms:expiry", 60000);
    public static final zzbdx zzb = zzbdx.zzb("gads:audio_caching_expiry_ms:expiry", CoroutineLiveDataKt.DEFAULT_TIMEOUT);
    public static final zzbdx zzc = zzbdx.zzb("gads:battery_caching_expiry_ms:expiry", WorkRequest.MIN_BACKOFF_MILLIS);
    public static final zzbdx zzd = zzbdx.zzb("gads:device_info_caching_expiry_ms:expiry", PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
    public static final zzbdx zze = zzbdx.zzb("gads:hsdp_caching_expiry_ms:expiry", 600000);
    public static final zzbdx zzf = zzbdx.zzb("gads:memory_caching_expiry_ms:expiry", CoroutineLiveDataKt.DEFAULT_TIMEOUT);
    public static final zzbdx zzg = zzbdx.zzb("gads:sdk_environment_caching_expiry_ms:expiry", 600000);
    public static final zzbdx zzh = zzbdx.zzb("gads:telephony_caching_expiry_ms:expiry", CoroutineLiveDataKt.DEFAULT_TIMEOUT);
}
