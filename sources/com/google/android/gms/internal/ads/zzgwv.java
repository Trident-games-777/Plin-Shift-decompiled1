package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgwv {
    private final zzgwu zza;

    private zzgwv(zzgwu zzgwu) {
        this.zza = zzgwu;
    }

    public static zzgwv zzb(byte[] bArr, zzggn zzggn) {
        return new zzgwv(zzgwu.zzb(bArr));
    }

    public static zzgwv zzc(int i) {
        return new zzgwv(zzgwu.zzb(zzgoz.zzb(i)));
    }

    public final int zza() {
        return this.zza.zza();
    }

    public final byte[] zzd(zzggn zzggn) {
        return this.zza.zzc();
    }
}
