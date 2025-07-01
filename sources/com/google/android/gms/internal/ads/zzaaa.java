package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaaa implements zzch {
    /* access modifiers changed from: private */
    public static final Executor zza = new zzzn();
    private final Context zzb;
    private final zzzy zzc;
    /* access modifiers changed from: private */
    public final zzaap zzd;
    private final zzaau zze;
    private final zzbq zzf;
    /* access modifiers changed from: private */
    public final zzdc zzg;
    /* access modifiers changed from: private */
    public final CopyOnWriteArraySet zzh;
    /* access modifiers changed from: private */
    public zzad zzi;
    /* access modifiers changed from: private */
    public zzaam zzj;
    private zzdm zzk;
    /* access modifiers changed from: private */
    public Pair zzl;
    private int zzm;
    private int zzn = 0;

    /* synthetic */ zzaaa(zzzp zzzp, zzzz zzzz) {
        Context zza2 = zzzp.zza;
        this.zzb = zza2;
        zzzy zzzy = new zzzy(this, zza2);
        this.zzc = zzzy;
        zzdc zzc2 = zzzp.zze;
        this.zzg = zzc2;
        zzaap zzf2 = zzzp.zzb;
        this.zzd = zzf2;
        zzf2.zzk(zzc2);
        this.zze = new zzaau(new zzzq(this, (zzzz) null), zzf2);
        zzbq zzb2 = zzzp.zzd;
        zzdb.zzb(zzb2);
        zzbq zzbq = zzb2;
        this.zzf = zzb2;
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        this.zzh = copyOnWriteArraySet;
        copyOnWriteArraySet.add(zzzy);
    }

    static /* bridge */ /* synthetic */ zzcg zzd(zzaaa zzaaa, zzad zzad) {
        zzdb.zzf(zzaaa.zzn == 0);
        zzm zzw = zzw(zzad.zzB);
        if (zzw.zzd == 7 && zzen.zza < 34) {
            zzk zzc2 = zzw.zzc();
            zzc2.zzd(6);
            zzw = zzc2.zzg();
        }
        zzm zzm2 = zzw;
        zzdc zzdc = zzaaa.zzg;
        Looper myLooper = Looper.myLooper();
        zzdb.zzb(myLooper);
        Looper looper = myLooper;
        zzaaa.zzk = zzdc.zzd(myLooper, (Handler.Callback) null);
        try {
            zzbq zzbq = zzaaa.zzf;
            Context context = zzaaa.zzb;
            zzp zzp = zzp.zza;
            zzdm zzdm = zzaaa.zzk;
            Objects.requireNonNull(zzdm);
            zzaaa zzaaa2 = zzaaa;
            zzbq.zza(context, zzm2, zzp, zzaaa2, new zzzm(zzdm), zzfzo.zzn(), 0);
            Pair pair = zzaaa2.zzl;
            if (pair != null) {
                Surface surface = (Surface) pair.first;
                zzee zzee = (zzee) zzaaa2.zzl.second;
                zzee.zzb();
                zzee.zza();
            }
            throw null;
        } catch (zzce e) {
            throw new zzabk(e, zzad);
        }
    }

    public static /* synthetic */ void zzk(zzaaa zzaaa) {
        int i = zzaaa.zzm - 1;
        zzaaa.zzm = i;
        if (i <= 0) {
            if (i >= 0) {
                zzaaa.zze.zza();
                return;
            }
            throw new IllegalStateException(String.valueOf(i));
        }
    }

    static /* bridge */ /* synthetic */ void zzm(zzaaa zzaaa) {
        if (zzaaa.zzn == 1) {
            zzaaa.zzm++;
            zzaaa.zze.zza();
            zzdm zzdm = zzaaa.zzk;
            zzdb.zzb(zzdm);
            zzdm zzdm2 = zzdm;
            zzdm.zzh(new zzzo(zzaaa));
        }
    }

    static /* bridge */ /* synthetic */ void zzo(zzaaa zzaaa, long j, long j2) {
        if (zzaaa.zzm == 0) {
            zzaaa.zze.zzc(j, j2);
        }
    }

    static /* bridge */ /* synthetic */ boolean zzu(zzaaa zzaaa, long j) {
        return zzaaa.zzm == 0 && zzaaa.zze.zze(j);
    }

    /* access modifiers changed from: private */
    public static zzm zzw(zzm zzm2) {
        return (zzm2 == null || !zzm2.zzf()) ? zzm.zza : zzm2;
    }

    public final zzabl zzh() {
        return this.zzc;
    }

    public final void zzr() {
        zzee.zza.zzb();
        zzee.zza.zza();
        this.zzl = null;
    }

    public final void zzs() {
        if (this.zzn != 2) {
            zzdm zzdm = this.zzk;
            if (zzdm != null) {
                zzdm.zze((Object) null);
            }
            this.zzl = null;
            this.zzn = 2;
        }
    }

    public final void zzt(Surface surface, zzee zzee) {
        Pair pair = this.zzl;
        if (pair == null || !((Surface) pair.first).equals(surface) || !((zzee) this.zzl.second).equals(zzee)) {
            this.zzl = Pair.create(surface, zzee);
            zzee.zzb();
            zzee.zza();
        }
    }
}
