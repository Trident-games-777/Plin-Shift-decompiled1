package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzais {
    public final zzadx zza;
    public final zzajg zzb = new zzajg();
    public final zzed zzc = new zzed();
    public zzajh zzd;
    public zzaio zze;
    public int zzf;
    public int zzg;
    public int zzh;
    public int zzi;
    private final zzed zzj = new zzed(1);
    private final zzed zzk = new zzed();
    /* access modifiers changed from: private */
    public boolean zzl;

    public zzais(zzadx zzadx, zzajh zzajh, zzaio zzaio) {
        this.zza = zzadx;
        this.zzd = zzajh;
        this.zze = zzaio;
        zzh(zzajh, zzaio);
    }

    public final int zza() {
        int i;
        if (!this.zzl) {
            i = this.zzd.zzg[this.zzf];
        } else {
            i = this.zzb.zzj[this.zzf] ? 1 : 0;
        }
        return zzf() != null ? i | 1073741824 : i;
    }

    public final int zzb() {
        if (!this.zzl) {
            return this.zzd.zzd[this.zzf];
        }
        return this.zzb.zzh[this.zzf];
    }

    public final int zzc(int i, int i2) {
        zzed zzed;
        zzajf zzf2 = zzf();
        if (zzf2 == null) {
            return 0;
        }
        int i3 = zzf2.zzd;
        if (i3 != 0) {
            zzed = this.zzb.zzn;
        } else {
            byte[] bArr = zzf2.zze;
            int i4 = zzen.zza;
            zzed zzed2 = this.zzk;
            byte[] bArr2 = bArr;
            int length = bArr2.length;
            zzed2.zzJ(bArr2, length);
            zzed = this.zzk;
            i3 = length;
        }
        boolean zzb2 = this.zzb.zzb(this.zzf);
        boolean z = zzb2 || i2 != 0;
        zzed zzed3 = this.zzj;
        zzed3.zzN()[0] = (byte) ((true != z ? 0 : 128) | i3);
        zzed3.zzL(0);
        this.zza.zzr(this.zzj, 1, 1);
        this.zza.zzr(zzed, i3, 1);
        if (!z) {
            return i3 + 1;
        }
        if (!zzb2) {
            this.zzc.zzI(8);
            zzed zzed4 = this.zzc;
            byte[] zzN = zzed4.zzN();
            zzN[0] = 0;
            zzN[1] = 1;
            zzN[2] = 0;
            zzN[3] = (byte) i2;
            zzN[4] = (byte) ((i >> 24) & 255);
            zzN[5] = (byte) ((i >> 16) & 255);
            zzN[6] = (byte) ((i >> 8) & 255);
            zzN[7] = (byte) (i & 255);
            this.zza.zzr(zzed4, 8, 1);
            return i3 + 9;
        }
        int i5 = i3 + 1;
        zzed zzed5 = this.zzb.zzn;
        int zzq = zzed5.zzq();
        zzed5.zzM(-2);
        int i6 = (zzq * 6) + 2;
        if (i2 != 0) {
            this.zzc.zzI(i6);
            byte[] zzN2 = this.zzc.zzN();
            zzed5.zzH(zzN2, 0, i6);
            int i7 = (((zzN2[2] & 255) << 8) | (zzN2[3] & 255)) + i2;
            zzN2[2] = (byte) ((i7 >> 8) & 255);
            zzN2[3] = (byte) (i7 & 255);
            zzed5 = this.zzc;
        }
        this.zza.zzr(zzed5, i6, 1);
        return i5 + i6;
    }

    public final long zzd() {
        if (!this.zzl) {
            return this.zzd.zzc[this.zzf];
        }
        return this.zzb.zzf[this.zzh];
    }

    public final long zze() {
        if (!this.zzl) {
            return this.zzd.zzf[this.zzf];
        }
        zzajg zzajg = this.zzb;
        return zzajg.zzi[this.zzf];
    }

    public final zzajf zzf() {
        if (!this.zzl) {
            return null;
        }
        zzaio zzaio = this.zzb.zza;
        int i = zzen.zza;
        zzaio zzaio2 = zzaio;
        int i2 = zzaio.zza;
        zzajf zzajf = this.zzb.zzm;
        if (zzajf == null) {
            zzajf = this.zzd.zza.zza(i2);
        }
        if (zzajf == null || !zzajf.zza) {
            return null;
        }
        return zzajf;
    }

    public final void zzh(zzajh zzajh, zzaio zzaio) {
        this.zzd = zzajh;
        this.zze = zzaio;
        this.zza.zzl(zzajh.zza.zzf);
        zzi();
    }

    public final void zzi() {
        zzajg zzajg = this.zzb;
        zzajg.zzd = 0;
        zzajg.zzp = 0;
        zzajg.zzq = false;
        zzajg.zzk = false;
        zzajg.zzo = false;
        zzajg.zzm = null;
        this.zzf = 0;
        this.zzh = 0;
        this.zzg = 0;
        this.zzi = 0;
        this.zzl = false;
    }

    public final boolean zzk() {
        this.zzf++;
        if (!this.zzl) {
            return false;
        }
        int i = this.zzg + 1;
        this.zzg = i;
        int[] iArr = this.zzb.zzg;
        int i2 = this.zzh;
        if (i != iArr[i2]) {
            return true;
        }
        this.zzh = i2 + 1;
        this.zzg = 0;
        return false;
    }
}
