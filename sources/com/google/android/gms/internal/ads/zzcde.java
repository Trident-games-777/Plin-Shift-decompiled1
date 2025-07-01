package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcde extends zzaqy {
    static final zzcde zzb = new zzcde();

    zzcde() {
    }

    public final zzarc zza(String str, byte[] bArr, String str2) {
        if ("moov".equals(str)) {
            return new zzare();
        }
        if ("mvhd".equals(str)) {
            return new zzarf();
        }
        return new zzarg(str);
    }
}
