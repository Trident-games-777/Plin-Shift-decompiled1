package com.google.android.gms.internal.ads;

import android.text.Layout;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzall {
    private String zza;
    private int zzb;
    private boolean zzc;
    private int zzd;
    private boolean zze;
    private int zzf = -1;
    private int zzg = -1;
    private int zzh = -1;
    private int zzi = -1;
    private int zzj = -1;
    private float zzk;
    private String zzl;
    private int zzm = -1;
    private int zzn = -1;
    private Layout.Alignment zzo;
    private Layout.Alignment zzp;
    private int zzq = -1;
    private zzale zzr;
    private float zzs = Float.MAX_VALUE;

    public final zzall zzA(boolean z) {
        this.zzq = z ? 1 : 0;
        return this;
    }

    public final zzall zzB(zzale zzale) {
        this.zzr = zzale;
        return this;
    }

    public final zzall zzC(boolean z) {
        this.zzg = z ? 1 : 0;
        return this;
    }

    public final String zzD() {
        return this.zza;
    }

    public final String zzE() {
        return this.zzl;
    }

    public final boolean zzF() {
        return this.zzq == 1;
    }

    public final boolean zzG() {
        return this.zze;
    }

    public final boolean zzH() {
        return this.zzc;
    }

    public final boolean zzI() {
        return this.zzf == 1;
    }

    public final boolean zzJ() {
        return this.zzg == 1;
    }

    public final float zza() {
        return this.zzk;
    }

    public final float zzb() {
        return this.zzs;
    }

    public final int zzc() {
        if (this.zze) {
            return this.zzd;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public final int zzd() {
        if (this.zzc) {
            return this.zzb;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public final int zze() {
        return this.zzj;
    }

    public final int zzf() {
        return this.zzn;
    }

    public final int zzg() {
        return this.zzm;
    }

    public final int zzh() {
        int i = this.zzh;
        if (i == -1 && this.zzi == -1) {
            return -1;
        }
        int i2 = 0;
        int i3 = i == 1 ? 1 : 0;
        if (this.zzi == 1) {
            i2 = 2;
        }
        return i3 | i2;
    }

    public final Layout.Alignment zzi() {
        return this.zzp;
    }

    public final Layout.Alignment zzj() {
        return this.zzo;
    }

    public final zzale zzk() {
        return this.zzr;
    }

    public final zzall zzl(zzall zzall) {
        int i;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (zzall != null) {
            if (!this.zzc && zzall.zzc) {
                zzo(zzall.zzb);
            }
            if (this.zzh == -1) {
                this.zzh = zzall.zzh;
            }
            if (this.zzi == -1) {
                this.zzi = zzall.zzi;
            }
            if (this.zza == null && (str = zzall.zza) != null) {
                this.zza = str;
            }
            if (this.zzf == -1) {
                this.zzf = zzall.zzf;
            }
            if (this.zzg == -1) {
                this.zzg = zzall.zzg;
            }
            if (this.zzn == -1) {
                this.zzn = zzall.zzn;
            }
            if (this.zzo == null && (alignment2 = zzall.zzo) != null) {
                this.zzo = alignment2;
            }
            if (this.zzp == null && (alignment = zzall.zzp) != null) {
                this.zzp = alignment;
            }
            if (this.zzq == -1) {
                this.zzq = zzall.zzq;
            }
            if (this.zzj == -1) {
                this.zzj = zzall.zzj;
                this.zzk = zzall.zzk;
            }
            if (this.zzr == null) {
                this.zzr = zzall.zzr;
            }
            if (this.zzs == Float.MAX_VALUE) {
                this.zzs = zzall.zzs;
            }
            if (!this.zze && zzall.zze) {
                zzm(zzall.zzd);
            }
            if (this.zzm == -1 && (i = zzall.zzm) != -1) {
                this.zzm = i;
            }
        }
        return this;
    }

    public final zzall zzm(int i) {
        this.zzd = i;
        this.zze = true;
        return this;
    }

    public final zzall zzn(boolean z) {
        this.zzh = z ? 1 : 0;
        return this;
    }

    public final zzall zzo(int i) {
        this.zzb = i;
        this.zzc = true;
        return this;
    }

    public final zzall zzp(String str) {
        this.zza = str;
        return this;
    }

    public final zzall zzq(float f) {
        this.zzk = f;
        return this;
    }

    public final zzall zzr(int i) {
        this.zzj = i;
        return this;
    }

    public final zzall zzs(String str) {
        this.zzl = str;
        return this;
    }

    public final zzall zzt(boolean z) {
        this.zzi = z ? 1 : 0;
        return this;
    }

    public final zzall zzu(boolean z) {
        this.zzf = z ? 1 : 0;
        return this;
    }

    public final zzall zzv(Layout.Alignment alignment) {
        this.zzp = alignment;
        return this;
    }

    public final zzall zzw(int i) {
        this.zzn = i;
        return this;
    }

    public final zzall zzx(int i) {
        this.zzm = i;
        return this;
    }

    public final zzall zzy(float f) {
        this.zzs = f;
        return this;
    }

    public final zzall zzz(Layout.Alignment alignment) {
        this.zzo = alignment;
        return this;
    }
}
