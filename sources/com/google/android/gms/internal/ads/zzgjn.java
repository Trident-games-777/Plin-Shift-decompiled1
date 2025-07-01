package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgjn {
    public static final zzgjn zza = new zzgjn("ASSUME_AES_GCM");
    public static final zzgjn zzb = new zzgjn("ASSUME_XCHACHA20POLY1305");
    public static final zzgjn zzc = new zzgjn("ASSUME_CHACHA20POLY1305");
    public static final zzgjn zzd = new zzgjn("ASSUME_AES_CTR_HMAC");
    public static final zzgjn zze = new zzgjn("ASSUME_AES_EAX");
    public static final zzgjn zzf = new zzgjn("ASSUME_AES_GCM_SIV");
    private final String zzg;

    private zzgjn(String str) {
        this.zzg = str;
    }

    public final String toString() {
        return this.zzg;
    }
}
