package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbeu {
    public static final zzbdx zza = zzbdx.zzd("gads:separate_url_generation:enabled", true);
    public static final zzbdx zzb = new zzbdx("gads:google_ad_request_domains", "googleads.g.doubleclick.net;pubads.g.doubleclick.net", 4);
    public static final zzbdx zzc = zzbdx.zzb("gads:url_cache:max_size", 200);

    static {
        zzbdx.zzd("gads:use_request_id_as_url_cache_key:enabled", true);
    }
}
