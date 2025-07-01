package com.google.android.gms.internal.ads;

import androidx.work.WorkRequest;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbew {
    public static final zzbdx zza = zzbdx.zzb("gads:dynamite_load:fail:sample_rate", WorkRequest.MIN_BACKOFF_MILLIS);
    public static final zzbdx zzb = zzbdx.zzd("gads:report_dynamite_crash_in_background_thread", false);
    public static final zzbdx zzc = new zzbdx("gads:public_beta:traffic_multiplier", "1.0", 4);
    public static final zzbdx zzd = new zzbdx("gads:sdk_crash_report_class_prefix", "com.google.", 4);
    public static final zzbdx zze = zzbdx.zzd("gads:sdk_crash_report_enabled", false);
    public static final zzbdx zzf = zzbdx.zzd("gads:sdk_crash_report_full_stacktrace", false);
    public static final zzbdx zzg = zzbdx.zza("gads:trapped_exception_sample_rate", 0.01d);
}
