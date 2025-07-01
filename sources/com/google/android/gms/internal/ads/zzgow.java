package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgow implements zzgpb {
    private final String zza;
    private final zzgwu zzb;
    private final zzgxp zzc;
    private final zzgty zzd;
    private final zzgve zze;
    @Nullable
    private final Integer zzf;

    private zzgow(String str, zzgwu zzgwu, zzgxp zzgxp, zzgty zzgty, zzgve zzgve, @Nullable Integer num) {
        this.zza = str;
        this.zzb = zzgwu;
        this.zzc = zzgxp;
        this.zzd = zzgty;
        this.zze = zzgve;
        this.zzf = num;
    }

    public static zzgow zza(String str, zzgxp zzgxp, zzgty zzgty, zzgve zzgve, @Nullable Integer num) throws GeneralSecurityException {
        if (zzgve == zzgve.RAW) {
            if (num != null) {
                throw new GeneralSecurityException("Keys with output prefix type raw should not have an id requirement.");
            }
        } else if (num == null) {
            throw new GeneralSecurityException("Keys with output prefix type different from raw should have an id requirement.");
        }
        return new zzgow(str, zzgpj.zza(str), zzgxp, zzgty, zzgve, num);
    }

    public final zzgty zzb() {
        return this.zzd;
    }

    public final zzgve zzc() {
        return this.zze;
    }

    public final zzgwu zzd() {
        return this.zzb;
    }

    public final zzgxp zze() {
        return this.zzc;
    }

    @Nullable
    public final Integer zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zza;
    }
}
