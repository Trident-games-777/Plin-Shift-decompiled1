package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzub implements zzwi {
    private final zzfzo zza;
    private long zzb;

    public zzub(List list, List list2) {
        zzfzl zzfzl = new zzfzl();
        zzdb.zzd(list.size() == list2.size());
        for (int i = 0; i < list.size(); i++) {
            zzfzl.zzf(new zzua((zzwi) list.get(i), (List) list2.get(i)));
        }
        this.zza = zzfzl.zzi();
        this.zzb = -9223372036854775807L;
    }

    public final long zzb() {
        long j = Long.MAX_VALUE;
        long j2 = Long.MAX_VALUE;
        for (int i = 0; i < this.zza.size(); i++) {
            zzua zzua = (zzua) this.zza.get(i);
            long zzb2 = zzua.zzb();
            if ((zzua.zza().contains(1) || zzua.zza().contains(2) || zzua.zza().contains(4)) && zzb2 != Long.MIN_VALUE) {
                j = Math.min(j, zzb2);
            }
            if (zzb2 != Long.MIN_VALUE) {
                j2 = Math.min(j2, zzb2);
            }
        }
        if (j != Long.MAX_VALUE) {
            this.zzb = j;
            return j;
        } else if (j2 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        } else {
            long j3 = this.zzb;
            return j3 != -9223372036854775807L ? j3 : j2;
        }
    }

    public final long zzc() {
        long j = Long.MAX_VALUE;
        for (int i = 0; i < this.zza.size(); i++) {
            long zzc = ((zzua) this.zza.get(i)).zzc();
            if (zzc != Long.MIN_VALUE) {
                j = Math.min(j, zzc);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    public final void zzm(long j) {
        for (int i = 0; i < this.zza.size(); i++) {
            ((zzua) this.zza.get(i)).zzm(j);
        }
    }

    public final boolean zzo(zzko zzko) {
        boolean z;
        boolean z2 = false;
        do {
            long zzc = zzc();
            if (zzc == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (int i = 0; i < this.zza.size(); i++) {
                long zzc2 = ((zzua) this.zza.get(i)).zzc();
                boolean z3 = zzc2 != Long.MIN_VALUE && zzc2 <= zzko.zza;
                if (zzc2 == zzc || z3) {
                    z |= ((zzua) this.zza.get(i)).zzo(zzko);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }

    public final boolean zzp() {
        for (int i = 0; i < this.zza.size(); i++) {
            if (((zzua) this.zza.get(i)).zzp()) {
                return true;
            }
        }
        return false;
    }
}
