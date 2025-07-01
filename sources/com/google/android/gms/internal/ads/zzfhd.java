package com.google.android.gms.internal.ads;

import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.ads.zzbbs;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfhd implements zzfhc {
    private final ConcurrentHashMap zza;
    private final zzfhj zzb;
    private final zzfhf zzc = new zzfhf();

    public zzfhd(zzfhj zzfhj) {
        this.zza = new ConcurrentHashMap(zzfhj.zzd);
        this.zzb = zzfhj;
    }

    private final void zzf() {
        Parcelable.Creator<zzfhj> creator = zzfhj.CREATOR;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzgi)).booleanValue()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.zzb.zzb);
            sb.append(" PoolCollection");
            sb.append(this.zzc.zzb());
            int i = 0;
            for (Map.Entry entry : this.zza.entrySet()) {
                i++;
                sb.append(i);
                sb.append(". ");
                sb.append(entry.getValue());
                sb.append("#");
                sb.append(((zzfhm) entry.getKey()).hashCode());
                sb.append("    ");
                for (int i2 = 0; i2 < ((zzfhb) entry.getValue()).zzb(); i2++) {
                    sb.append("[O]");
                }
                for (int zzb2 = ((zzfhb) entry.getValue()).zzb(); zzb2 < this.zzb.zzd; zzb2++) {
                    sb.append("[ ]");
                }
                sb.append("\n");
                sb.append(((zzfhb) entry.getValue()).zzg());
                sb.append("\n");
            }
            while (i < this.zzb.zzc) {
                i++;
                sb.append(i);
                sb.append(".\n");
            }
            zzm.zze(sb.toString());
        }
    }

    public final zzfhj zza() {
        return this.zzb;
    }

    public final synchronized zzfhl zzb(zzfhm zzfhm) {
        zzfhl zzfhl;
        zzfhb zzfhb = (zzfhb) this.zza.get(zzfhm);
        if (zzfhb != null) {
            zzfhl = zzfhb.zze();
            if (zzfhl == null) {
                this.zzc.zze();
            }
            zzfhz zzf = zzfhb.zzf();
            if (zzfhl != null) {
                zzbbs.zzb.zzc zzd = zzbbs.zzb.zzd();
                zzbbs.zzb.zza.C0003zza zza2 = zzbbs.zzb.zza.zza();
                zza2.zzf(zzbbs.zzb.zzd.IN_MEMORY);
                zzbbs.zzb.zze.zza zzb2 = zzbbs.zzb.zze.zzb();
                zzb2.zzd(zzf.zza);
                zzb2.zze(zzf.zzb);
                zza2.zzg(zzb2);
                zzd.zzd(zza2);
                zzfhl.zza.zzb().zzc().zzi((zzbbs.zzb) zzd.zzbr());
            }
            zzf();
        } else {
            this.zzc.zzf();
            zzf();
            zzfhl = null;
        }
        return zzfhl;
    }

    @Deprecated
    public final zzfhm zzc(com.google.android.gms.ads.internal.client.zzm zzm, String str, zzy zzy) {
        return new zzfhn(zzm, str, new zzbwa(this.zzb.zza).zza().zzj, this.zzb.zzf, zzy);
    }

    public final synchronized boolean zzd(zzfhm zzfhm, zzfhl zzfhl) {
        boolean zzh;
        zzfhb zzfhb = (zzfhb) this.zza.get(zzfhm);
        zzfhl.zzd = zzv.zzC().currentTimeMillis();
        if (zzfhb == null) {
            zzfhj zzfhj = this.zzb;
            zzfhb zzfhb2 = new zzfhb(zzfhj.zzd, zzfhj.zze * 1000);
            if (this.zza.size() == this.zzb.zzc) {
                int i = this.zzb.zzg;
                int i2 = i - 1;
                zzfhm zzfhm2 = null;
                if (i != 0) {
                    long j = Long.MAX_VALUE;
                    if (i2 == 0) {
                        for (Map.Entry entry : this.zza.entrySet()) {
                            if (((zzfhb) entry.getValue()).zzc() < j) {
                                j = ((zzfhb) entry.getValue()).zzc();
                                zzfhm2 = (zzfhm) entry.getKey();
                            }
                        }
                        if (zzfhm2 != null) {
                            this.zza.remove(zzfhm2);
                        }
                    } else if (i2 == 1) {
                        for (Map.Entry entry2 : this.zza.entrySet()) {
                            if (((zzfhb) entry2.getValue()).zzd() < j) {
                                j = ((zzfhb) entry2.getValue()).zzd();
                                zzfhm2 = (zzfhm) entry2.getKey();
                            }
                        }
                        if (zzfhm2 != null) {
                            this.zza.remove(zzfhm2);
                        }
                    } else if (i2 == 2) {
                        int i3 = Integer.MAX_VALUE;
                        for (Map.Entry entry3 : this.zza.entrySet()) {
                            if (((zzfhb) entry3.getValue()).zza() < i3) {
                                i3 = ((zzfhb) entry3.getValue()).zza();
                                zzfhm2 = (zzfhm) entry3.getKey();
                            }
                        }
                        if (zzfhm2 != null) {
                            this.zza.remove(zzfhm2);
                        }
                    }
                    this.zzc.zzg();
                } else {
                    throw null;
                }
            }
            this.zza.put(zzfhm, zzfhb2);
            this.zzc.zzd();
            zzfhb = zzfhb2;
        }
        zzh = zzfhb.zzh(zzfhl);
        this.zzc.zzc();
        zzfhe zza2 = this.zzc.zza();
        zzfhz zzf = zzfhb.zzf();
        if (zzfhl != null) {
            zzbbs.zzb.zzc zzd = zzbbs.zzb.zzd();
            zzbbs.zzb.zza.C0003zza zza3 = zzbbs.zzb.zza.zza();
            zza3.zzf(zzbbs.zzb.zzd.IN_MEMORY);
            zzbbs.zzb.zzg.zza zzb2 = zzbbs.zzb.zzg.zzb();
            zzb2.zze(zza2.zza);
            zzb2.zzf(zza2.zzb);
            zzb2.zzg(zzf.zzb);
            zza3.zzi(zzb2);
            zzd.zzd(zza3);
            zzfhl.zza.zzb().zzc().zzj((zzbbs.zzb) zzd.zzbr());
        }
        zzf();
        return zzh;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        if (r3.zzb() >= r1.zzd) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0018, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zze(com.google.android.gms.internal.ads.zzfhm r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.concurrent.ConcurrentHashMap r0 = r2.zza     // Catch:{ all -> 0x001c }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x001c }
            com.google.android.gms.internal.ads.zzfhb r3 = (com.google.android.gms.internal.ads.zzfhb) r3     // Catch:{ all -> 0x001c }
            r0 = 1
            if (r3 == 0) goto L_0x001a
            com.google.android.gms.internal.ads.zzfhj r1 = r2.zzb     // Catch:{ all -> 0x001c }
            int r3 = r3.zzb()     // Catch:{ all -> 0x001c }
            int r1 = r1.zzd     // Catch:{ all -> 0x001c }
            monitor-exit(r2)
            if (r3 >= r1) goto L_0x0018
            return r0
        L_0x0018:
            r3 = 0
            return r3
        L_0x001a:
            monitor-exit(r2)
            return r0
        L_0x001c:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001c }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfhd.zze(com.google.android.gms.internal.ads.zzfhm):boolean");
    }
}
