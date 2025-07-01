package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import android.view.TextureView;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzjr implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, zzabg, zzpn, zzwu, zztp, zzhu, zzhp {
    public static final /* synthetic */ int zzb = 0;
    final /* synthetic */ zzjv zza;

    /* synthetic */ zzjr(zzjv zzjv, zzju zzju) {
        this.zza = zzjv;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzjv.zzK(this.zza, surfaceTexture);
        this.zza.zzaa(i, i2);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.zza.zzad((Object) null);
        this.zza.zzaa(0, 0);
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.zza.zzaa(i, i2);
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.zza.zzaa(i2, i3);
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.zza.zzaa(0, 0);
    }

    public final void zza(Exception exc) {
        this.zza.zzq.zzv(exc);
    }

    public final void zzb(String str, long j, long j2) {
        this.zza.zzq.zzw(str, j, j2);
    }

    public final void zzc(String str) {
        this.zza.zzq.zzx(str);
    }

    public final void zzd(zzhx zzhx) {
        this.zza.zzq.zzy(zzhx);
    }

    public final void zze(zzhx zzhx) {
        this.zza.zzq.zzz(zzhx);
    }

    public final void zzf(zzad zzad, zzhy zzhy) {
        this.zza.zzq.zzA(zzad, zzhy);
    }

    public final void zzg(long j) {
        this.zza.zzq.zzB(j);
    }

    public final void zzh(Exception exc) {
        this.zza.zzq.zzC(exc);
    }

    public final void zzi(zzpo zzpo) {
        this.zza.zzq.zzD(zzpo);
    }

    public final void zzj(zzpo zzpo) {
        this.zza.zzq.zzE(zzpo);
    }

    public final void zzk(int i, long j, long j2) {
        this.zza.zzq.zzF(i, j, j2);
    }

    public final void zzl(int i, long j) {
        this.zza.zzq.zzG(i, j);
    }

    public final void zzm(Object obj, long j) {
        this.zza.zzq.zzH(obj, j);
        zzjv zzjv = this.zza;
        if (zzjv.zzF == obj) {
            zzds zzD = zzjv.zzl;
            zzD.zzd(26, new zzjq());
            zzD.zzc();
        }
    }

    public final void zzn(boolean z) {
        zzjv zzjv = this.zza;
        if (zzjv.zzM != z) {
            zzjv.zzM = z;
            zzds zzD = this.zza.zzl;
            zzD.zzd(23, new zzjo(z));
            zzD.zzc();
        }
    }

    public final void zzo(Exception exc) {
        this.zza.zzq.zzJ(exc);
    }

    public final void zzp(String str, long j, long j2) {
        this.zza.zzq.zzK(str, j, j2);
    }

    public final void zzq(String str) {
        this.zza.zzq.zzL(str);
    }

    public final void zzr(zzhx zzhx) {
        this.zza.zzq.zzM(zzhx);
    }

    public final void zzs(zzhx zzhx) {
        this.zza.zzq.zzN(zzhx);
    }

    public final void zzt(long j, int i) {
        this.zza.zzq.zzO(j, i);
    }

    public final void zzu(zzad zzad, zzhy zzhy) {
        this.zza.zzq.zzP(zzad, zzhy);
    }

    public final void zzv(zzci zzci) {
        zzds zzD = this.zza.zzl;
        zzD.zzd(25, new zzjp(zzci));
        zzD.zzc();
    }
}
