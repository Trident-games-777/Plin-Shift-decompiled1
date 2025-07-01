package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgmx implements zzgfx {
    final String zza;
    final Class zzb;
    final zzgty zzc;

    zzgmx(String str, Class cls, zzgty zzgty, zzhaq zzhaq) {
        this.zza = str;
        this.zzb = cls;
        this.zzc = zzgty;
    }

    public static zzgfx zzd(String str, Class cls, zzgty zzgty, zzhaq zzhaq) {
        return new zzgmx(str, cls, zzgty, zzhaq);
    }

    public final zzgua zza(zzgxp zzgxp) throws GeneralSecurityException {
        zzguc zza2 = zzgue.zza();
        zza2.zzb(this.zza);
        zza2.zzc(zzgxp);
        zza2.zza(zzgve.RAW);
        zzgow zzgow = (zzgow) zzgnz.zzc().zzd(zzgnp.zzb().zza(zzgnz.zzc().zzb(zzgox.zza((zzgue) zza2.zzbr())), (Integer) null), zzgow.class, zzgfv.zza());
        zzgtx zza3 = zzgua.zza();
        zza3.zzb(zzgow.zzg());
        zza3.zzc(zzgow.zze());
        zza3.zza(zzgow.zzb());
        return (zzgua) zza3.zzbr();
    }

    public final Class zzb() {
        return this.zzb;
    }

    public final Object zzc(zzgxp zzgxp) throws GeneralSecurityException {
        return zzgnw.zza().zzc(zzgnz.zzc().zza(zzgow.zza(this.zza, zzgxp, this.zzc, zzgve.RAW, (Integer) null), zzgfv.zza()), this.zzb);
    }
}
