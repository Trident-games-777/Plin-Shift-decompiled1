package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.Surface;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzzy implements zzabl, zzzr {
    final /* synthetic */ zzaaa zza;
    private final int zzb;
    private final ArrayList zzc;
    private final zzaan zzd;
    private zzad zze;
    private long zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private boolean zzj;
    private long zzk;
    private boolean zzl;
    private boolean zzm;
    private long zzn;
    private zzabi zzo;
    private Executor zzp;

    public zzzy(zzaaa zzaaa, Context context) {
        this.zza = zzaaa;
        this.zzb = true != zzen.zzK(context) ? 5 : 1;
        this.zzc = new ArrayList();
        this.zzd = new zzaan();
        this.zzk = -9223372036854775807L;
        this.zzo = zzabi.zzb;
        this.zzp = zzaaa.zza;
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [java.lang.Throwable, java.lang.Object, com.google.android.gms.internal.ads.zzcg] */
    private final void zzz() {
        if (this.zze != null) {
            new ArrayList(this.zzc);
            zzad zzad = this.zze;
            zzad.getClass();
            zzad zzad2 = zzad;
            ? r1 = 0;
            zzdb.zzb(r1);
            zzm zzm2 = zzad.zzB;
            zzcg zzcg = r1;
            zzae zzae = new zzae(zzaaa.zzw(zzm2), zzad.zzu, zzad.zzv);
            zzae.zza(zzad.zzy);
            zzae.zzb();
            r1.zzd();
            throw r1;
        }
    }

    public final void zza(zzaaa zzaaa) {
        this.zzp.execute(new zzzx(this, this.zzo));
    }

    public final void zzb(zzaaa zzaaa) {
        this.zzp.execute(new zzzw(this, this.zzo));
    }

    public final void zzc(zzaaa zzaaa, zzci zzci) {
        this.zzp.execute(new zzzv(this, this.zzo, zzci));
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [java.lang.Throwable, java.lang.Object, com.google.android.gms.internal.ads.zzcg] */
    public final Surface zzd() {
        zzdb.zzf(false);
        ? r0 = 0;
        zzdb.zzb(r0);
        zzcg zzcg = r0;
        r0.zzb();
        throw r0;
    }

    public final void zze() {
        this.zza.zzr();
    }

    public final void zzf() {
        this.zza.zzd.zzb();
    }

    public final void zzg(boolean z) {
        this.zzl = false;
        this.zzk = -9223372036854775807L;
        zzaaa.zzm(this.zza);
        if (z) {
            this.zza.zzd.zzi();
        }
        this.zzn = -9223372036854775807L;
    }

    public final void zzh(zzad zzad) throws zzabk {
        zzaaa.zzd(this.zza, zzad);
    }

    public final void zzi(boolean z) {
        this.zza.zzd.zzc(z);
    }

    public final void zzj(int i, zzad zzad) {
        boolean z = false;
        zzdb.zzf(false);
        this.zza.zzd.zzl(zzad.zzw);
        this.zze = zzad;
        if (!this.zzl) {
            zzz();
            this.zzl = true;
            this.zzm = false;
            this.zzn = -9223372036854775807L;
            return;
        }
        if (this.zzk != -9223372036854775807L) {
            z = true;
        }
        zzdb.zzf(z);
        this.zzm = true;
        this.zzn = this.zzk;
    }

    public final void zzk() {
        this.zza.zzd.zzd();
    }

    public final void zzl(boolean z) {
        this.zza.zzd.zze(z);
    }

    public final void zzm() {
        this.zza.zzd.zzg();
    }

    public final void zzn() {
        this.zza.zzd.zzh();
    }

    public final void zzo() {
        this.zza.zzs();
    }

    public final void zzp(long j, long j2) throws zzabk {
        try {
            zzaaa.zzo(this.zza, j, j2);
        } catch (zzig e) {
            zzad zzad = this.zze;
            if (zzad == null) {
                zzad = new zzab().zzaf();
            }
            throw new zzabk(e, zzad);
        }
    }

    public final void zzq(int i) {
        this.zza.zzd.zzj(i);
    }

    public final void zzr(zzabi zzabi, Executor executor) {
        this.zzo = zzabi;
        this.zzp = executor;
    }

    public final void zzs(Surface surface, zzee zzee) {
        this.zza.zzt(surface, zzee);
    }

    public final void zzt(float f) {
        this.zza.zze.zzd(f);
    }

    public final void zzu(long j, long j2, long j3, long j4) {
        boolean z = this.zzj;
        boolean z2 = true;
        if (this.zzg == j2 && this.zzh == j3) {
            z2 = false;
        }
        this.zzj = z | z2;
        this.zzf = j;
        this.zzg = j2;
        this.zzh = j3;
        this.zzi = j4;
    }

    public final void zzv(List list) {
        if (!this.zzc.equals(list)) {
            this.zzc.clear();
            this.zzc.addAll(list);
            zzz();
        }
    }

    public final void zzw(zzaam zzaam) {
        this.zza.zzj = zzaam;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.Throwable, java.lang.Object, com.google.android.gms.internal.ads.zzcg] */
    public final boolean zzx(long j, boolean z, long j2, long j3, zzabj zzabj) throws zzabk {
        zzdb.zzf(false);
        long j4 = j - this.zzh;
        try {
            if (this.zza.zzd.zza(j4, j2, j3, this.zzf, z, this.zzd) != 4) {
                if (j4 >= this.zzi || z) {
                    zzp(j2, j3);
                    if (this.zzm) {
                        long j5 = this.zzn;
                        if (j5 == -9223372036854775807L || zzaaa.zzu(this.zza, j5)) {
                            zzz();
                            this.zzm = false;
                            this.zzn = -9223372036854775807L;
                        }
                    }
                    ? r0 = 0;
                    zzdb.zzb(r0);
                    zzcg zzcg = r0;
                    r0.zza();
                    throw r0;
                }
                zzaaf zzaaf = (zzaaf) zzabj;
                zzaaf.zzd.zzaQ(zzaaf.zza, zzaaf.zzb, zzaaf.zzc);
                return true;
            }
            return false;
        } catch (zzig e) {
            zzad zzad = this.zze;
            zzdb.zzb(zzad);
            zzad zzad2 = zzad;
            throw new zzabk(e, zzad);
        }
    }

    public final boolean zzy(boolean z) {
        return this.zza.zze.zzf(false);
    }
}
