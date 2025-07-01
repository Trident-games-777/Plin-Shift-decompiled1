package com.google.android.gms.internal.ads;

import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzpm {
    private final Handler zza;
    private final zzpn zzb;

    public zzpm(Handler handler, zzpn zzpn) {
        if (zzpn != null) {
            Handler handler2 = handler;
        } else {
            handler = null;
        }
        this.zza = handler;
        this.zzb = zzpn;
    }

    public final void zza(Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzpg(this, exc));
        }
    }

    public final void zzb(Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzph(this, exc));
        }
    }

    public final void zzc(zzpo zzpo) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzpe(this, zzpo));
        }
    }

    public final void zzd(zzpo zzpo) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzpf(this, zzpo));
        }
    }

    public final void zze(String str, long j, long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzpk(this, str, j, j2));
        }
    }

    public final void zzf(String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzpl(this, str));
        }
    }

    public final void zzg(zzhx zzhx) {
        zzhx.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzpb(this, zzhx));
        }
    }

    public final void zzh(zzhx zzhx) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzpa(this, zzhx));
        }
    }

    public final void zzi(zzad zzad, zzhy zzhy) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzpi(this, zzad, zzhy));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(Exception exc) {
        int i = zzen.zza;
        zzpn zzpn = this.zzb;
        zzpn zzpn2 = zzpn;
        zzpn.zza(exc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(Exception exc) {
        int i = zzen.zza;
        zzpn zzpn = this.zzb;
        zzpn zzpn2 = zzpn;
        zzpn.zzh(exc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(zzpo zzpo) {
        int i = zzen.zza;
        zzpn zzpn = this.zzb;
        zzpn zzpn2 = zzpn;
        zzpn.zzi(zzpo);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm(zzpo zzpo) {
        int i = zzen.zza;
        zzpn zzpn = this.zzb;
        zzpn zzpn2 = zzpn;
        zzpn.zzj(zzpo);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(String str, long j, long j2) {
        int i = zzen.zza;
        zzpn zzpn = this.zzb;
        zzpn zzpn2 = zzpn;
        zzpn.zzb(str, j, j2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(String str) {
        int i = zzen.zza;
        zzpn zzpn = this.zzb;
        zzpn zzpn2 = zzpn;
        zzpn.zzc(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(zzhx zzhx) {
        zzhx.zza();
        int i = zzen.zza;
        zzpn zzpn = this.zzb;
        zzpn zzpn2 = zzpn;
        zzpn.zzd(zzhx);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(zzhx zzhx) {
        int i = zzen.zza;
        zzpn zzpn = this.zzb;
        zzpn zzpn2 = zzpn;
        zzpn.zze(zzhx);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzr(zzad zzad, zzhy zzhy) {
        int i = zzen.zza;
        zzpn zzpn = this.zzb;
        zzpn zzpn2 = zzpn;
        zzpn.zzf(zzad, zzhy);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzs(long j) {
        int i = zzen.zza;
        zzpn zzpn = this.zzb;
        zzpn zzpn2 = zzpn;
        zzpn.zzg(j);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzt(boolean z) {
        int i = zzen.zza;
        zzpn zzpn = this.zzb;
        zzpn zzpn2 = zzpn;
        zzpn.zzn(z);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzu(int i, long j, long j2) {
        int i2 = zzen.zza;
        zzpn zzpn = this.zzb;
        zzpn zzpn2 = zzpn;
        zzpn.zzk(i, j, j2);
    }

    public final void zzv(long j) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzpc(this, j));
        }
    }

    public final void zzw(boolean z) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzpj(this, z));
        }
    }

    public final void zzx(int i, long j, long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzpd(this, i, j, j2));
        }
    }
}
