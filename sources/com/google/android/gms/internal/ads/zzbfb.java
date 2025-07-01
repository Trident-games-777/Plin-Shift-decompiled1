package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbfb {
    public static final zzbdx zza = zzbdx.zzd("gads:trustless_token_for_decagon:enabled", true);
    public static final zzbdx zzb = zzbdx.zzb("gads:timeout_for_trustless_token:millis", 2000);

    static {
        zzbdx.zzd("gads:invalidate_token_at_refresh_start", true);
        zzbdx.zzd("gms:expose_token_for_gma:enabled", true);
        zzbdx.zzd("gads:referesh_rate_limit", false);
        zzbdx.zzd("gads:token_anonymization:enabled", true);
        zzbdx.zzb("gads:cached_token:ttl_millis", 10800000);
    }
}
