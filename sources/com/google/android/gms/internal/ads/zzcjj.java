package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcjj {
    private zzchn zza;
    private zzcke zzb;
    private zzfjv zzc;
    private zzckr zzd;
    private zzfgr zze;

    private zzcjj() {
        throw null;
    }

    /* synthetic */ zzcjj(zzckd zzckd) {
    }

    public final zzchk zza() {
        zzhgf.zzc(this.zza, zzchn.class);
        zzhgf.zzc(this.zzb, zzcke.class);
        if (this.zzc == null) {
            this.zzc = new zzfjv();
        }
        if (this.zzd == null) {
            this.zzd = new zzckr();
        }
        if (this.zze == null) {
            this.zze = new zzfgr();
        }
        return new zzciy(this.zza, this.zzb, this.zzc, this.zzd, this.zze, (zzckd) null);
    }

    public final zzcjj zzb(zzchn zzchn) {
        zzchn zzchn2 = zzchn;
        this.zza = zzchn;
        return this;
    }

    public final zzcjj zzc(zzcke zzcke) {
        zzcke zzcke2 = zzcke;
        this.zzb = zzcke;
        return this;
    }
}
