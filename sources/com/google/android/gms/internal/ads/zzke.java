package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzke {
    public zzlg zza;
    public int zzb;
    public boolean zzc;
    public int zzd;
    /* access modifiers changed from: private */
    public boolean zze;

    public zzke(zzlg zzlg) {
        this.zza = zzlg;
    }

    public final void zza(int i) {
        boolean z = true;
        if (true != (this.zze | i)) {
            z = false;
        }
        this.zze = z;
        this.zzb += i;
    }

    public final void zzb(zzlg zzlg) {
        this.zze |= this.zza != zzlg;
        this.zza = zzlg;
    }

    public final void zzc(int i) {
        boolean z = true;
        if (!this.zzc || this.zzd == 5) {
            this.zze = true;
            this.zzc = true;
            this.zzd = i;
            return;
        }
        if (i != 5) {
            z = false;
        }
        zzdb.zzd(z);
    }
}
