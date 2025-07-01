package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzzg {
    public static final zzyz zza = new zzyz(2, -9223372036854775807L, (zzzf) null);
    public static final zzyz zzb = new zzyz(3, -9223372036854775807L, (zzzf) null);
    /* access modifiers changed from: private */
    public final Executor zzc;
    private final Runnable zzd;
    /* access modifiers changed from: private */
    public zzza zze;
    /* access modifiers changed from: private */
    public IOException zzf;

    public zzzg(String str) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new zzel("ExoPlayer:Loader:ProgressiveMediaPeriod"));
        this.zzc = newSingleThreadExecutor;
        Objects.requireNonNull(newSingleThreadExecutor);
        this.zzd = new zzyx(newSingleThreadExecutor);
    }

    public static zzyz zzb(boolean z, long j) {
        return new zzyz(z ? 1 : 0, j, (zzzf) null);
    }

    public final long zza(zzzb zzzb, zzyy zzyy, int i) {
        Looper myLooper = Looper.myLooper();
        zzdb.zzb(myLooper);
        Looper looper = myLooper;
        this.zzf = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new zzza(this, myLooper, zzzb, zzyy, i, elapsedRealtime).zzc(0);
        return elapsedRealtime;
    }

    public final void zzg() {
        zzza zzza = this.zze;
        zzdb.zzb(zzza);
        zzza zzza2 = zzza;
        zzza.zza(false);
    }

    public final void zzh() {
        this.zzf = null;
    }

    public final void zzi(int i) throws IOException {
        IOException iOException = this.zzf;
        if (iOException == null) {
            zzza zzza = this.zze;
            if (zzza != null) {
                zzza.zzb(i);
                return;
            }
            return;
        }
        throw iOException;
    }

    public final void zzj(zzzc zzzc) {
        zzza zzza = this.zze;
        if (zzza != null) {
            zzza.zza(true);
        }
        this.zzc.execute(new zzzd(zzzc));
        this.zzd.run();
    }

    public final boolean zzk() {
        return this.zzf != null;
    }

    public final boolean zzl() {
        return this.zze != null;
    }
}
