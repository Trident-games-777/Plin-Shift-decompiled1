package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzaxt implements Callable {
    protected final zzawf zza;
    protected final String zzb;
    protected final String zzc;
    protected final zzasf zzd;
    protected Method zze;
    protected final int zzf;
    protected final int zzg;

    public zzaxt(zzawf zzawf, String str, String str2, zzasf zzasf, int i, int i2) {
        getClass().getSimpleName();
        this.zza = zzawf;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzasf;
        this.zzf = i;
        this.zzg = i2;
    }

    public /* bridge */ /* synthetic */ Object call() throws Exception {
        zzk();
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract void zza() throws IllegalAccessException, InvocationTargetException;

    public Void zzk() throws Exception {
        int i;
        try {
            long nanoTime = System.nanoTime();
            Method zzj = this.zza.zzj(this.zzb, this.zzc);
            this.zze = zzj;
            if (zzj == null) {
                return null;
            }
            zza();
            zzauw zzd2 = this.zza.zzd();
            if (zzd2 == null || (i = this.zzf) == Integer.MIN_VALUE) {
                return null;
            }
            zzd2.zzc(this.zzg, i, (System.nanoTime() - nanoTime) / 1000, (String) null, (Exception) null);
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }
}
