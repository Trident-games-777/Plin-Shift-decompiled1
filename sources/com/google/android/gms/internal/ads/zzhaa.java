package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzhaa implements zzhbc {
    private static final zzhag zza = new zzgzy();
    private final zzhag zzb;

    public zzhaa() {
        zzhag zzhag = zza;
        int i = zzhas.zza;
        zzgzz zzgzz = new zzgzz(zzgyq.zza(), zzhag);
        byte[] bArr = zzgzk.zzb;
        this.zzb = zzgzz;
    }

    public final zzhbb zza(Class cls) {
        int i = zzhbd.zza;
        if (!zzgyx.class.isAssignableFrom(cls)) {
            int i2 = zzhas.zza;
        }
        zzhaf zzb2 = this.zzb.zzb(cls);
        if (!zzb2.zzb()) {
            int i3 = zzhas.zza;
            return zzhal.zzm(cls, zzb2, zzhap.zza(), zzgzw.zza(), zzhbd.zzm(), zzb2.zzc() + -1 != 1 ? zzgyk.zza() : null, zzhae.zza());
        }
        int i4 = zzhas.zza;
        return zzham.zzc(zzhbd.zzm(), zzgyk.zza(), zzb2.zza());
    }
}
