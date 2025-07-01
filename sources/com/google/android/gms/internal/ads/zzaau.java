package com.google.android.gms.internal.ads;

import android.media.MediaFormat;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzaau {
    private final zzaap zza;
    private final zzaan zzb = new zzaan();
    private final zzej zzc = new zzej(10);
    private final zzej zzd = new zzej(10);
    private final zzdv zze = new zzdv(16);
    private zzci zzf;
    private zzci zzg = zzci.zza;
    private long zzh;
    private long zzi = -9223372036854775807L;
    private final zzzq zzj;

    public zzaau(zzzq zzzq, zzaap zzaap) {
        this.zzj = zzzq;
        this.zza = zzaap;
    }

    private static Object zzg(zzej zzej) {
        zzdb.zzd(zzej.zza() > 0);
        while (zzej.zza() > 1) {
            zzej.zzb();
        }
        Object zzb2 = zzej.zzb();
        zzb2.getClass();
        return zzb2;
    }

    public final void zza() {
        this.zze.zzc();
        this.zzi = -9223372036854775807L;
        zzej zzej = this.zzd;
        if (zzej.zza() > 0) {
            this.zzd.zzd(0, Long.valueOf(((Long) zzg(zzej)).longValue()));
        }
        if (this.zzf == null) {
            zzej zzej2 = this.zzc;
            if (zzej2.zza() > 0) {
                this.zzf = (zzci) zzg(zzej2);
                return;
            }
            return;
        }
        this.zzc.zze();
    }

    public final void zzb(long j, long j2) {
        this.zzd.zzd(j, Long.valueOf(j2));
    }

    /* JADX WARNING: type inference failed for: r15v0, types: [java.lang.Throwable, com.google.android.gms.internal.ads.zzbr, java.lang.Object] */
    public final void zzc(long j, long j2) throws zzig {
        zzad zzad;
        zzdv zzdv = this.zze;
        if (!zzdv.zzd()) {
            zzej zzej = this.zzd;
            long zza2 = zzdv.zza();
            Long l = (Long) zzej.zzc(zza2);
            if (!(l == null || l.longValue() == this.zzh)) {
                this.zzh = l.longValue();
                this.zza.zzf();
            }
            int zza3 = this.zza.zza(zza2, j, j2, this.zzh, false, this.zzb);
            ? r15 = 0;
            if (zza3 == 0 || zza3 == 1) {
                this.zzi = zza2;
                Long valueOf = Long.valueOf(this.zze.zzb());
                Long l2 = valueOf;
                long longValue = valueOf.longValue();
                zzci zzci = (zzci) this.zzc.zzc(longValue);
                if (zzci != null && !zzci.equals(zzci.zza) && !zzci.equals(this.zzg)) {
                    this.zzg = zzci;
                    zzzq zzzq = this.zzj;
                    zzab zzab = new zzab();
                    zzab.zzae(zzci.zzb);
                    zzab.zzJ(zzci.zzc);
                    zzab.zzZ("video/raw");
                    zzzq.zza.zzi = zzab.zzaf();
                    Iterator it = zzzq.zza.zzh.iterator();
                    while (it.hasNext()) {
                        ((zzzr) it.next()).zzc(zzzq.zza, zzci);
                    }
                }
                zzzq zzzq2 = this.zzj;
                if (this.zza.zzp()) {
                    zzaaa zzaaa = zzzq2.zza;
                    if (zzaaa.zzl != null) {
                        Iterator it2 = zzaaa.zzh.iterator();
                        while (it2.hasNext()) {
                            ((zzzr) it2.next()).zza(zzzq2.zza);
                        }
                    }
                }
                zzaaa zzaaa2 = zzzq2.zza;
                if (zzaaa2.zzj != null) {
                    if (zzaaa2.zzi == null) {
                        zzad = new zzab().zzaf();
                    } else {
                        zzad = zzaaa2.zzi;
                    }
                    zzaaa zzaaa3 = zzzq2.zza;
                    zzaaa3.zzj.zza(longValue, zzaaa3.zzg.zzc(), zzad, (MediaFormat) null);
                }
                zzdb.zzb(r15);
                zzbr zzbr = r15;
                r15.zza();
                throw r15;
            } else if (zza3 == 2 || zza3 == 3 || zza3 == 4) {
                this.zzi = zza2;
                this.zze.zzb();
                zzzq zzzq3 = this.zzj;
                Iterator it3 = zzzq3.zza.zzh.iterator();
                while (it3.hasNext()) {
                    ((zzzr) it3.next()).zzb(zzzq3.zza);
                }
                zzdb.zzb(r15);
                zzbr zzbr2 = r15;
                r15.zza();
                throw r15;
            }
        }
    }

    public final void zzd(float f) {
        zzdb.zzd(f > 0.0f);
        this.zza.zzn(f);
    }

    public final boolean zze(long j) {
        long j2 = this.zzi;
        return j2 != -9223372036854775807L && j2 >= j;
    }

    public final boolean zzf(boolean z) {
        return this.zza.zzo(false);
    }
}
