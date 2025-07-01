package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzadi implements zzadq {
    private final zzdu zza;
    private final zzdu zzb;
    private long zzc;

    public zzadi(long[] jArr, long[] jArr2, long j) {
        int length = jArr.length;
        int length2 = jArr2.length;
        zzdb.zzd(length == length2);
        if (length2 <= 0 || jArr2[0] <= 0) {
            this.zza = new zzdu(length2);
            this.zzb = new zzdu(length2);
        } else {
            int i = length2 + 1;
            zzdu zzdu = new zzdu(i);
            this.zza = zzdu;
            zzdu zzdu2 = new zzdu(i);
            this.zzb = zzdu2;
            zzdu.zzc(0);
            zzdu2.zzc(0);
        }
        this.zza.zzd(jArr);
        this.zzb.zzd(jArr2);
        this.zzc = j;
    }

    public final long zza() {
        return this.zzc;
    }

    public final zzado zzg(long j) {
        zzdu zzdu = this.zzb;
        if (zzdu.zza() == 0) {
            zzadr zzadr = zzadr.zza;
            return new zzado(zzadr, zzadr);
        }
        int zzb2 = zzen.zzb(zzdu, j, true, true);
        zzadr zzadr2 = new zzadr(this.zzb.zzb(zzb2), this.zza.zzb(zzb2));
        if (zzadr2.zzb != j) {
            zzdu zzdu2 = this.zzb;
            if (zzb2 != zzdu2.zza() - 1) {
                int i = zzb2 + 1;
                return new zzado(zzadr2, new zzadr(zzdu2.zzb(i), this.zza.zzb(i)));
            }
        }
        return new zzado(zzadr2, zzadr2);
    }

    public final boolean zzh() {
        return this.zzb.zza() > 0;
    }
}
