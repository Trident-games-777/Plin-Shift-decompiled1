package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzoc {
    final /* synthetic */ zzod zza;
    /* access modifiers changed from: private */
    public final String zzb;
    /* access modifiers changed from: private */
    public int zzc;
    /* access modifiers changed from: private */
    public long zzd;
    /* access modifiers changed from: private */
    public zzur zze;
    /* access modifiers changed from: private */
    public boolean zzf;
    /* access modifiers changed from: private */
    public boolean zzg;

    public zzoc(zzod zzod, String str, int i, zzur zzur) {
        this.zza = zzod;
        this.zzb = str;
        this.zzc = i;
        this.zzd = zzur == null ? -1 : zzur.zzd;
        if (zzur != null && zzur.zzb()) {
            this.zze = zzur;
        }
    }

    public final void zzg(int i, zzur zzur) {
        if (this.zzd == -1 && i == this.zzc && zzur != null) {
            zzod zzod = this.zza;
            long j = zzur.zzd;
            if (j >= zzod.zzl()) {
                this.zzd = j;
            }
        }
    }

    public final boolean zzj(int i, zzur zzur) {
        if (zzur == null) {
            return i == this.zzc;
        }
        zzur zzur2 = this.zze;
        return zzur2 == null ? !zzur.zzb() && zzur.zzd == this.zzd : zzur.zzd == zzur2.zzd && zzur.zzb == zzur2.zzb && zzur.zzc == zzur2.zzc;
    }

    public final boolean zzk(zzlx zzlx) {
        zzur zzur = zzlx.zzd;
        if (zzur == null) {
            return this.zzc != zzlx.zzc;
        }
        long j = this.zzd;
        if (j == -1) {
            return false;
        }
        if (zzur.zzd > j) {
            return true;
        }
        if (this.zze == null) {
            return false;
        }
        zzbv zzbv = zzlx.zzb;
        int zza2 = zzbv.zza(zzur.zza);
        int zza3 = zzbv.zza(this.zze.zza);
        zzur zzur2 = zzlx.zzd;
        if (zzur2.zzd < this.zze.zzd || zza2 < zza3) {
            return false;
        }
        if (zza2 > zza3) {
            return true;
        }
        if (zzur2.zzb()) {
            zzur zzur3 = zzlx.zzd;
            int i = zzur3.zzb;
            int i2 = zzur3.zzc;
            zzur zzur4 = this.zze;
            int i3 = zzur4.zzb;
            if (i <= i3) {
                return i == i3 && i2 > zzur4.zzc;
            }
            return true;
        }
        int i4 = zzlx.zzd.zze;
        return i4 == -1 || i4 > this.zze.zzb;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
        if (r0 < r8.zzc()) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzl(com.google.android.gms.internal.ads.zzbv r7, com.google.android.gms.internal.ads.zzbv r8) {
        /*
            r6 = this;
            int r0 = r6.zzc
            int r1 = r7.zzc()
            r2 = 0
            r3 = -1
            if (r0 < r1) goto L_0x0013
            int r7 = r8.zzc()
            if (r0 >= r7) goto L_0x0011
            goto L_0x004a
        L_0x0011:
            r0 = r3
            goto L_0x004a
        L_0x0013:
            com.google.android.gms.internal.ads.zzod r1 = r6.zza
            com.google.android.gms.internal.ads.zzbu r1 = r1.zzc
            r4 = 0
            r7.zze(r0, r1, r4)
            com.google.android.gms.internal.ads.zzod r0 = r6.zza
            com.google.android.gms.internal.ads.zzbu r0 = r0.zzc
            int r0 = r0.zzn
        L_0x0026:
            com.google.android.gms.internal.ads.zzod r1 = r6.zza
            com.google.android.gms.internal.ads.zzbu r1 = r1.zzc
            int r1 = r1.zzo
            if (r0 > r1) goto L_0x0011
            java.lang.Object r1 = r7.zzf(r0)
            int r1 = r8.zza(r1)
            if (r1 == r3) goto L_0x0047
            com.google.android.gms.internal.ads.zzod r7 = r6.zza
            com.google.android.gms.internal.ads.zzbt r7 = r7.zzd
            com.google.android.gms.internal.ads.zzbt r7 = r8.zzd(r1, r7, r2)
            int r0 = r7.zzc
            goto L_0x004a
        L_0x0047:
            int r0 = r0 + 1
            goto L_0x0026
        L_0x004a:
            r6.zzc = r0
            if (r0 != r3) goto L_0x004f
            return r2
        L_0x004f:
            com.google.android.gms.internal.ads.zzur r7 = r6.zze
            r0 = 1
            if (r7 != 0) goto L_0x0055
            return r0
        L_0x0055:
            java.lang.Object r7 = r7.zza
            int r7 = r8.zza(r7)
            if (r7 == r3) goto L_0x005e
            return r0
        L_0x005e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzoc.zzl(com.google.android.gms.internal.ads.zzbv, com.google.android.gms.internal.ads.zzbv):boolean");
    }
}
