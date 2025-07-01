package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzabf {
    private final Handler zza;
    private final zzabg zzb;

    public zzabf(Handler handler, zzabg zzabg) {
        if (zzabg != null) {
            Handler handler2 = handler;
        } else {
            handler = null;
        }
        this.zza = handler;
        this.zzb = zzabg;
    }

    public final void zza(String str, long j, long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzaav(this, str, j, j2));
        }
    }

    public final void zzb(String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzabe(this, str));
        }
    }

    public final void zzc(zzhx zzhx) {
        zzhx.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzabd(this, zzhx));
        }
    }

    public final void zzd(int i, long j) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzaax(this, i, j));
        }
    }

    public final void zze(zzhx zzhx) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzabb(this, zzhx));
        }
    }

    public final void zzf(zzad zzad, zzhy zzhy) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzabc(this, zzad, zzhy));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(String str, long j, long j2) {
        int i = zzen.zza;
        zzabg zzabg = this.zzb;
        zzabg zzabg2 = zzabg;
        zzabg.zzp(str, j, j2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(String str) {
        int i = zzen.zza;
        zzabg zzabg = this.zzb;
        zzabg zzabg2 = zzabg;
        zzabg.zzq(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(zzhx zzhx) {
        zzhx.zza();
        int i = zzen.zza;
        zzabg zzabg = this.zzb;
        zzabg zzabg2 = zzabg;
        zzabg.zzr(zzhx);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(int i, long j) {
        int i2 = zzen.zza;
        zzabg zzabg = this.zzb;
        zzabg zzabg2 = zzabg;
        zzabg.zzl(i, j);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(zzhx zzhx) {
        int i = zzen.zza;
        zzabg zzabg = this.zzb;
        zzabg zzabg2 = zzabg;
        zzabg.zzs(zzhx);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(zzad zzad, zzhy zzhy) {
        int i = zzen.zza;
        zzabg zzabg = this.zzb;
        zzabg zzabg2 = zzabg;
        zzabg.zzu(zzad, zzhy);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm(Object obj, long j) {
        int i = zzen.zza;
        zzabg zzabg = this.zzb;
        zzabg zzabg2 = zzabg;
        zzabg.zzm(obj, j);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(long j, int i) {
        int i2 = zzen.zza;
        zzabg zzabg = this.zzb;
        zzabg zzabg2 = zzabg;
        zzabg.zzt(j, i);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(Exception exc) {
        int i = zzen.zza;
        zzabg zzabg = this.zzb;
        zzabg zzabg2 = zzabg;
        zzabg.zzo(exc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(zzci zzci) {
        int i = zzen.zza;
        zzabg zzabg = this.zzb;
        zzabg zzabg2 = zzabg;
        zzabg.zzv(zzci);
    }

    public final void zzq(Object obj) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzaay(this, obj, SystemClock.elapsedRealtime()));
        }
    }

    public final void zzr(long j, int i) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzaaz(this, j, i));
        }
    }

    public final void zzs(Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzaba(this, exc));
        }
    }

    public final void zzt(zzci zzci) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzaaw(this, zzci));
        }
    }
}
