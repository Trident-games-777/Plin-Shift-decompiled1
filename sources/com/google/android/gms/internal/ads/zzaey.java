package com.google.android.gms.internal.ads;

import androidx.recyclerview.widget.ItemTouchHelper;
import java.io.IOException;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaey implements zzacr {
    private final zzed zza = new zzed(4);
    private final zzed zzb = new zzed(9);
    private final zzed zzc = new zzed(11);
    private final zzed zzd = new zzed();
    private final zzaez zze = new zzaez();
    private zzacu zzf;
    private int zzg = 1;
    private boolean zzh;
    private long zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private boolean zzn;
    private zzaex zzo;
    private zzafc zzp;

    private final zzed zza(zzacs zzacs) throws IOException {
        if (this.zzl > this.zzd.zzc()) {
            zzed zzed = this.zzd;
            int zzc2 = zzed.zzc();
            zzed.zzJ(new byte[Math.max(zzc2 + zzc2, this.zzl)], 0);
        } else {
            this.zzd.zzL(0);
        }
        this.zzd.zzK(this.zzl);
        zzacs.zzi(this.zzd.zzN(), 0, this.zzl);
        return this.zzd;
    }

    @RequiresNonNull({"extractorOutput"})
    private final void zzg() {
        if (!this.zzn) {
            this.zzf.zzO(new zzadp(-9223372036854775807L, 0));
            this.zzn = true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bf A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0009 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(com.google.android.gms.internal.ads.zzacs r17, com.google.android.gms.internal.ads.zzadn r18) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            com.google.android.gms.internal.ads.zzacu r2 = r0.zzf
            com.google.android.gms.internal.ads.zzdb.zzb(r2)
        L_0x0009:
            int r2 = r0.zzg
            r3 = -1
            r4 = 8
            r5 = 9
            r6 = 2
            r7 = 4
            r8 = 0
            r9 = 1
            if (r2 == r9) goto L_0x0119
            r10 = 3
            if (r2 == r6) goto L_0x010e
            if (r2 == r10) goto L_0x00c6
            if (r2 != r7) goto L_0x00c0
            boolean r2 = r0.zzh
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r2 == 0) goto L_0x002c
            long r2 = r0.zzi
            long r14 = r0.zzm
            long r2 = r2 + r14
            goto L_0x003b
        L_0x002c:
            com.google.android.gms.internal.ads.zzaez r2 = r0.zze
            long r2 = r2.zzc()
            int r2 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x0039
            r2 = 0
            goto L_0x003b
        L_0x0039:
            long r2 = r0.zzm
        L_0x003b:
            int r14 = r0.zzk
            if (r14 != r4) goto L_0x0052
            com.google.android.gms.internal.ads.zzaex r14 = r0.zzo
            if (r14 == 0) goto L_0x0053
            r0.zzg()
            com.google.android.gms.internal.ads.zzaex r4 = r0.zzo
            com.google.android.gms.internal.ads.zzed r5 = r16.zza(r17)
            boolean r2 = r4.zzf(r5, r2)
        L_0x0050:
            r3 = r9
            goto L_0x009f
        L_0x0052:
            r4 = r14
        L_0x0053:
            if (r4 != r5) goto L_0x0067
            com.google.android.gms.internal.ads.zzafc r4 = r0.zzp
            if (r4 == 0) goto L_0x0098
            r0.zzg()
            com.google.android.gms.internal.ads.zzafc r4 = r0.zzp
            com.google.android.gms.internal.ads.zzed r5 = r16.zza(r17)
            boolean r2 = r4.zzf(r5, r2)
            goto L_0x0050
        L_0x0067:
            r5 = 18
            if (r4 != r5) goto L_0x0098
            boolean r4 = r0.zzn
            if (r4 != 0) goto L_0x0098
            com.google.android.gms.internal.ads.zzaez r4 = r0.zze
            com.google.android.gms.internal.ads.zzed r5 = r16.zza(r17)
            boolean r2 = r4.zzf(r5, r2)
            com.google.android.gms.internal.ads.zzaez r3 = r0.zze
            long r4 = r3.zzc()
            int r14 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r14 == 0) goto L_0x0050
            com.google.android.gms.internal.ads.zzacu r14 = r0.zzf
            com.google.android.gms.internal.ads.zzadi r15 = new com.google.android.gms.internal.ads.zzadi
            long[] r10 = r3.zzd()
            long[] r3 = r3.zze()
            r15.<init>(r10, r3, r4)
            r14.zzO(r15)
            r0.zzn = r9
            goto L_0x0050
        L_0x0098:
            int r2 = r0.zzl
            r1.zzk(r2)
            r2 = r8
            r3 = r2
        L_0x009f:
            boolean r4 = r0.zzh
            if (r4 != 0) goto L_0x00b9
            if (r2 == 0) goto L_0x00b9
            r0.zzh = r9
            com.google.android.gms.internal.ads.zzaez r2 = r0.zze
            long r4 = r2.zzc()
            int r2 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x00b5
            long r4 = r0.zzm
            long r10 = -r4
            goto L_0x00b7
        L_0x00b5:
            r10 = 0
        L_0x00b7:
            r0.zzi = r10
        L_0x00b9:
            r0.zzj = r7
            r0.zzg = r6
            if (r3 == 0) goto L_0x0009
            return r8
        L_0x00c0:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x00c6:
            com.google.android.gms.internal.ads.zzed r2 = r0.zzc
            byte[] r2 = r2.zzN()
            r4 = 11
            boolean r2 = r1.zzn(r2, r8, r4, r9)
            if (r2 != 0) goto L_0x00d5
            return r3
        L_0x00d5:
            com.google.android.gms.internal.ads.zzed r2 = r0.zzc
            r2.zzL(r8)
            com.google.android.gms.internal.ads.zzed r2 = r0.zzc
            int r2 = r2.zzm()
            r0.zzk = r2
            com.google.android.gms.internal.ads.zzed r2 = r0.zzc
            int r2 = r2.zzo()
            r0.zzl = r2
            com.google.android.gms.internal.ads.zzed r2 = r0.zzc
            int r2 = r2.zzo()
            long r2 = (long) r2
            r0.zzm = r2
            com.google.android.gms.internal.ads.zzed r2 = r0.zzc
            int r2 = r2.zzm()
            int r2 = r2 << 24
            long r3 = r0.zzm
            long r5 = (long) r2
            long r2 = r5 | r3
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 * r4
            r0.zzm = r2
            com.google.android.gms.internal.ads.zzed r2 = r0.zzc
            r2.zzM(r10)
            r0.zzg = r7
            goto L_0x0009
        L_0x010e:
            int r2 = r0.zzj
            r1.zzk(r2)
            r0.zzj = r8
            r0.zzg = r10
            goto L_0x0009
        L_0x0119:
            com.google.android.gms.internal.ads.zzed r2 = r0.zzb
            byte[] r2 = r2.zzN()
            boolean r2 = r1.zzn(r2, r8, r5, r9)
            if (r2 != 0) goto L_0x0126
            return r3
        L_0x0126:
            com.google.android.gms.internal.ads.zzed r2 = r0.zzb
            r2.zzL(r8)
            com.google.android.gms.internal.ads.zzed r2 = r0.zzb
            r2.zzM(r7)
            com.google.android.gms.internal.ads.zzed r2 = r0.zzb
            int r2 = r2.zzm()
            r3 = r2 & 4
            r2 = r2 & r9
            if (r3 == 0) goto L_0x014c
            com.google.android.gms.internal.ads.zzaex r3 = r0.zzo
            if (r3 != 0) goto L_0x014c
            com.google.android.gms.internal.ads.zzaex r3 = new com.google.android.gms.internal.ads.zzaex
            com.google.android.gms.internal.ads.zzacu r7 = r0.zzf
            com.google.android.gms.internal.ads.zzadx r4 = r7.zzw(r4, r9)
            r3.<init>(r4)
            r0.zzo = r3
        L_0x014c:
            if (r2 == 0) goto L_0x015f
            com.google.android.gms.internal.ads.zzafc r2 = r0.zzp
            if (r2 != 0) goto L_0x015f
            com.google.android.gms.internal.ads.zzafc r2 = new com.google.android.gms.internal.ads.zzafc
            com.google.android.gms.internal.ads.zzacu r3 = r0.zzf
            com.google.android.gms.internal.ads.zzadx r3 = r3.zzw(r5, r6)
            r2.<init>(r3)
            r0.zzp = r2
        L_0x015f:
            com.google.android.gms.internal.ads.zzacu r2 = r0.zzf
            r2.zzD()
            com.google.android.gms.internal.ads.zzed r2 = r0.zzb
            int r2 = r2.zzg()
            int r2 = r2 + -5
            r0.zzj = r2
            r0.zzg = r6
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaey.zzb(com.google.android.gms.internal.ads.zzacs, com.google.android.gms.internal.ads.zzadn):int");
    }

    public final /* synthetic */ zzacr zzc() {
        return this;
    }

    public final /* synthetic */ List zzd() {
        return zzfzo.zzn();
    }

    public final void zze(zzacu zzacu) {
        this.zzf = zzacu;
    }

    public final void zzf(long j, long j2) {
        if (j == 0) {
            this.zzg = 1;
            this.zzh = false;
        } else {
            this.zzg = 3;
        }
        this.zzj = 0;
    }

    public final boolean zzi(zzacs zzacs) throws IOException {
        zzacg zzacg = (zzacg) zzacs;
        zzacg.zzm(this.zza.zzN(), 0, 3, false);
        this.zza.zzL(0);
        if (this.zza.zzo() != 4607062) {
            return false;
        }
        zzacg.zzm(this.zza.zzN(), 0, 2, false);
        this.zza.zzL(0);
        if ((this.zza.zzq() & ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION) != 0) {
            return false;
        }
        zzacg.zzm(this.zza.zzN(), 0, 4, false);
        this.zza.zzL(0);
        int zzg2 = this.zza.zzg();
        zzacs.zzj();
        zzacg.zzl(zzg2, false);
        zzacg.zzm(this.zza.zzN(), 0, 4, false);
        this.zza.zzL(0);
        if (this.zza.zzg() == 0) {
            return true;
        }
        return false;
    }
}
