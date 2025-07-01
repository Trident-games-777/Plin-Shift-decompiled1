package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import java.lang.reflect.Method;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzpy {
    private long zzA;
    private long zzB;
    private long zzC;
    private boolean zzD;
    private long zzE;
    private long zzF;
    private boolean zzG;
    private long zzH;
    private zzdc zzI;
    private final zzpx zza;
    private final long[] zzb;
    private AudioTrack zzc;
    private int zzd;
    private zzpw zze;
    private int zzf;
    private boolean zzg;
    private long zzh;
    private float zzi;
    private boolean zzj;
    private long zzk;
    private long zzl;
    private Method zzm;
    private long zzn;
    private boolean zzo;
    private boolean zzp;
    private long zzq;
    private long zzr;
    private long zzs;
    private long zzt;
    private long zzu;
    private int zzv;
    private int zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    public zzpy(zzpx zzpx) {
        zzpx zzpx2 = zzpx;
        this.zza = zzpx;
        try {
            Class[] clsArr = null;
            this.zzm = AudioTrack.class.getMethod("getLatency", (Class[]) null);
        } catch (NoSuchMethodException unused) {
        }
        this.zzb = new long[10];
        this.zzI = zzdc.zza;
    }

    private final long zzl() {
        long zzb2 = this.zzI.zzb();
        int i = 2;
        if (this.zzx != -9223372036854775807L) {
            AudioTrack audioTrack = this.zzc;
            audioTrack.getClass();
            AudioTrack audioTrack2 = audioTrack;
            if (audioTrack.getPlayState() == 2) {
                return this.zzz;
            }
            return Math.min(this.zzA, this.zzz + zzen.zzp(zzen.zzq(zzen.zzs(zzb2) - this.zzx, this.zzi), this.zzf));
        }
        if (zzb2 - this.zzr >= 5) {
            AudioTrack audioTrack3 = this.zzc;
            audioTrack3.getClass();
            AudioTrack audioTrack4 = audioTrack3;
            int playState = audioTrack3.getPlayState();
            if (playState != 1) {
                long playbackHeadPosition = ((long) audioTrack3.getPlaybackHeadPosition()) & 4294967295L;
                long j = 0;
                if (this.zzg) {
                    if (playState != 2) {
                        i = playState;
                    } else if (playbackHeadPosition == 0) {
                        this.zzu = this.zzs;
                    }
                    playbackHeadPosition += this.zzu;
                    playState = i;
                }
                if (zzen.zza <= 29) {
                    if (playbackHeadPosition != 0) {
                        j = playbackHeadPosition;
                    } else if (this.zzs > 0 && playState == 3) {
                        if (this.zzy == -9223372036854775807L) {
                            this.zzy = zzb2;
                        }
                    }
                    this.zzy = -9223372036854775807L;
                    playbackHeadPosition = j;
                }
                if (this.zzs > playbackHeadPosition) {
                    this.zzt++;
                }
                this.zzs = playbackHeadPosition;
            }
            this.zzr = zzb2;
        }
        return this.zzs + this.zzH + (this.zzt << 32);
    }

    private final long zzm() {
        return zzen.zzt(zzl(), this.zzf);
    }

    private final void zzn() {
        this.zzk = 0;
        this.zzw = 0;
        this.zzv = 0;
        this.zzl = 0;
        this.zzC = 0;
        this.zzF = 0;
        this.zzj = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0180  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zza(boolean r22) {
        /*
            r21 = this;
            r0 = r21
            android.media.AudioTrack r1 = r0.zzc
            r1.getClass()
            r2 = r1
            android.media.AudioTrack r2 = (android.media.AudioTrack) r2
            int r1 = r1.getPlayState()
            r2 = 3
            r3 = 1
            r4 = 0
            r6 = 1000(0x3e8, double:4.94E-321)
            if (r1 != r2) goto L_0x0105
            com.google.android.gms.internal.ads.zzdc r1 = r0.zzI
            long r1 = r1.zzc()
            long r13 = r1 / r6
            long r1 = r0.zzl
            long r1 = r13 - r1
            r8 = 30000(0x7530, double:1.4822E-319)
            int r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            r2 = 0
            if (r1 < 0) goto L_0x006a
            long r8 = r0.zzm()
            int r1 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x0033
            goto L_0x0105
        L_0x0033:
            long[] r1 = r0.zzb
            int r10 = r0.zzv
            float r11 = r0.zzi
            long r8 = com.google.android.gms.internal.ads.zzen.zzr(r8, r11)
            long r8 = r8 - r13
            r1[r10] = r8
            int r1 = r0.zzv
            int r1 = r1 + r3
            r8 = 10
            int r1 = r1 % r8
            r0.zzv = r1
            int r1 = r0.zzw
            if (r1 >= r8) goto L_0x004f
            int r1 = r1 + r3
            r0.zzw = r1
        L_0x004f:
            r0.zzl = r13
            r0.zzk = r4
            r1 = r2
        L_0x0054:
            int r8 = r0.zzw
            if (r1 >= r8) goto L_0x006a
            long r9 = r0.zzk
            long[] r11 = r0.zzb
            r17 = r6
            long r6 = (long) r8
            r11 = r11[r1]
            long r11 = r11 / r6
            long r9 = r9 + r11
            r0.zzk = r9
            int r1 = r1 + 1
            r6 = r17
            goto L_0x0054
        L_0x006a:
            r17 = r6
            boolean r1 = r0.zzg
            if (r1 != 0) goto L_0x0107
            com.google.android.gms.internal.ads.zzpw r1 = r0.zze
            r1.getClass()
            r6 = r1
            com.google.android.gms.internal.ads.zzpw r6 = (com.google.android.gms.internal.ads.zzpw) r6
            boolean r6 = r1.zzg(r13)
            r19 = 5000000(0x4c4b40, double:2.470328E-317)
            if (r6 != 0) goto L_0x0082
            goto L_0x00bc
        L_0x0082:
            long r11 = r1.zzb()
            long r9 = r1.zza()
            long r15 = r0.zzm()
            long r6 = r11 - r13
            long r6 = java.lang.Math.abs(r6)
            int r6 = (r6 > r19 ? 1 : (r6 == r19 ? 0 : -1))
            if (r6 <= 0) goto L_0x00a1
            com.google.android.gms.internal.ads.zzpx r8 = r0.zza
            r8.zzd(r9, r11, r13, r15)
            r1.zzd()
            goto L_0x00bc
        L_0x00a1:
            int r6 = r0.zzf
            long r6 = com.google.android.gms.internal.ads.zzen.zzt(r9, r6)
            long r6 = r6 - r15
            long r6 = java.lang.Math.abs(r6)
            int r6 = (r6 > r19 ? 1 : (r6 == r19 ? 0 : -1))
            if (r6 <= 0) goto L_0x00b9
            com.google.android.gms.internal.ads.zzpx r8 = r0.zza
            r8.zzc(r9, r11, r13, r15)
            r1.zzd()
            goto L_0x00bc
        L_0x00b9:
            r1.zzc()
        L_0x00bc:
            boolean r1 = r0.zzp
            if (r1 == 0) goto L_0x0107
            java.lang.reflect.Method r1 = r0.zzm
            if (r1 == 0) goto L_0x0107
            long r6 = r0.zzq
            long r6 = r13 - r6
            r8 = 500000(0x7a120, double:2.47033E-318)
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 < 0) goto L_0x0107
            r6 = 0
            android.media.AudioTrack r7 = r0.zzc     // Catch:{ Exception -> 0x0100 }
            if (r7 == 0) goto L_0x00ff
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0100 }
            java.lang.Object r1 = r1.invoke(r7, r2)     // Catch:{ Exception -> 0x0100 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x0100 }
            int r2 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x0100 }
            r2 = r1
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ Exception -> 0x0100 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x0100 }
            long r1 = (long) r1     // Catch:{ Exception -> 0x0100 }
            long r1 = r1 * r17
            long r7 = r0.zzh     // Catch:{ Exception -> 0x0100 }
            long r1 = r1 - r7
            r0.zzn = r1     // Catch:{ Exception -> 0x0100 }
            long r1 = java.lang.Math.max(r1, r4)     // Catch:{ Exception -> 0x0100 }
            r0.zzn = r1     // Catch:{ Exception -> 0x0100 }
            int r7 = (r1 > r19 ? 1 : (r1 == r19 ? 0 : -1))
            if (r7 <= 0) goto L_0x0102
            com.google.android.gms.internal.ads.zzpx r7 = r0.zza     // Catch:{ Exception -> 0x0100 }
            r7.zza(r1)     // Catch:{ Exception -> 0x0100 }
            r0.zzn = r4     // Catch:{ Exception -> 0x0100 }
            goto L_0x0102
        L_0x00ff:
            throw r6     // Catch:{ Exception -> 0x0100 }
        L_0x0100:
            r0.zzm = r6
        L_0x0102:
            r0.zzq = r13
            goto L_0x0107
        L_0x0105:
            r17 = r6
        L_0x0107:
            com.google.android.gms.internal.ads.zzdc r1 = r0.zzI
            long r1 = r1.zzc()
            long r1 = r1 / r17
            com.google.android.gms.internal.ads.zzpw r6 = r0.zze
            r6.getClass()
            r7 = r6
            com.google.android.gms.internal.ads.zzpw r7 = (com.google.android.gms.internal.ads.zzpw) r7
            boolean r7 = r6.zzf()
            if (r7 == 0) goto L_0x0135
            long r4 = r6.zza()
            int r8 = r0.zzf
            long r4 = com.google.android.gms.internal.ads.zzen.zzt(r4, r8)
            long r8 = r6.zzb()
            long r8 = r1 - r8
            float r6 = r0.zzi
            long r8 = com.google.android.gms.internal.ads.zzen.zzq(r8, r6)
            long r4 = r4 + r8
            goto L_0x0152
        L_0x0135:
            int r6 = r0.zzw
            if (r6 != 0) goto L_0x013e
            long r8 = r0.zzm()
            goto L_0x0147
        L_0x013e:
            long r8 = r0.zzk
            long r8 = r8 + r1
            float r6 = r0.zzi
            long r8 = com.google.android.gms.internal.ads.zzen.zzq(r8, r6)
        L_0x0147:
            if (r22 != 0) goto L_0x0151
            long r10 = r0.zzn
            long r8 = r8 - r10
            long r4 = java.lang.Math.max(r4, r8)
            goto L_0x0152
        L_0x0151:
            r4 = r8
        L_0x0152:
            boolean r6 = r0.zzD
            if (r6 == r7) goto L_0x015e
            long r8 = r0.zzC
            r0.zzF = r8
            long r8 = r0.zzB
            r0.zzE = r8
        L_0x015e:
            long r8 = r0.zzF
            long r8 = r1 - r8
            r10 = 1000000(0xf4240, double:4.940656E-318)
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 >= 0) goto L_0x017c
            long r12 = r0.zzE
            float r6 = r0.zzi
            long r14 = com.google.android.gms.internal.ads.zzen.zzq(r8, r6)
            long r12 = r12 + r14
            long r8 = r8 * r17
            long r8 = r8 / r10
            long r4 = r4 * r8
            long r8 = r17 - r8
            long r8 = r8 * r12
            long r4 = r4 + r8
            long r4 = r4 / r17
        L_0x017c:
            boolean r6 = r0.zzj
            if (r6 != 0) goto L_0x01a6
            long r8 = r0.zzB
            int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x01a6
            r0.zzj = r3
            long r8 = r4 - r8
            int r3 = com.google.android.gms.internal.ads.zzen.zza
            float r3 = r0.zzi
            long r8 = com.google.android.gms.internal.ads.zzen.zzv(r8)
            long r8 = com.google.android.gms.internal.ads.zzen.zzr(r8, r3)
            com.google.android.gms.internal.ads.zzdc r3 = r0.zzI
            long r10 = r3.zza()
            long r8 = com.google.android.gms.internal.ads.zzen.zzv(r8)
            long r10 = r10 - r8
            com.google.android.gms.internal.ads.zzpx r3 = r0.zza
            r3.zzb(r10)
        L_0x01a6:
            r0.zzC = r1
            r0.zzB = r4
            r0.zzD = r7
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpy.zza(boolean):long");
    }

    public final void zzb(long j) {
        this.zzz = zzl();
        this.zzx = zzen.zzs(this.zzI.zzb());
        this.zzA = j;
    }

    public final void zzc() {
        zzn();
        this.zzc = null;
        this.zze = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(android.media.AudioTrack r3, boolean r4, int r5, int r6, int r7) {
        /*
            r2 = this;
            r2.zzc = r3
            r2.zzd = r7
            com.google.android.gms.internal.ads.zzpw r0 = new com.google.android.gms.internal.ads.zzpw
            r0.<init>(r3)
            r2.zze = r0
            int r3 = r3.getSampleRate()
            r2.zzf = r3
            r3 = 0
            if (r4 == 0) goto L_0x0023
            int r4 = com.google.android.gms.internal.ads.zzen.zza
            r0 = 23
            if (r4 >= r0) goto L_0x0023
            r4 = 5
            r0 = 1
            if (r5 == r4) goto L_0x0024
            r4 = 6
            if (r5 != r4) goto L_0x0023
            r5 = r4
            goto L_0x0024
        L_0x0023:
            r0 = r3
        L_0x0024:
            r2.zzg = r0
            boolean r4 = com.google.android.gms.internal.ads.zzen.zzJ(r5)
            r2.zzp = r4
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 == 0) goto L_0x003c
            int r7 = r7 / r6
            long r4 = (long) r7
            int r6 = r2.zzf
            long r4 = com.google.android.gms.internal.ads.zzen.zzt(r4, r6)
            goto L_0x003d
        L_0x003c:
            r4 = r0
        L_0x003d:
            r2.zzh = r4
            r4 = 0
            r2.zzs = r4
            r2.zzt = r4
            r2.zzG = r3
            r2.zzH = r4
            r2.zzu = r4
            r2.zzo = r3
            r2.zzx = r0
            r2.zzy = r0
            r2.zzq = r4
            r2.zzn = r4
            r3 = 1065353216(0x3f800000, float:1.0)
            r2.zzi = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpy.zzd(android.media.AudioTrack, boolean, int, int, int):void");
    }

    public final void zze(zzdc zzdc) {
        this.zzI = zzdc;
    }

    public final void zzf() {
        if (this.zzx != -9223372036854775807L) {
            this.zzx = zzen.zzs(this.zzI.zzb());
        }
        zzpw zzpw = this.zze;
        zzpw.getClass();
        zzpw zzpw2 = zzpw;
        zzpw.zze();
    }

    public final boolean zzg(long j) {
        if (j > zzen.zzp(zza(false), this.zzf)) {
            return true;
        }
        if (this.zzg) {
            AudioTrack audioTrack = this.zzc;
            audioTrack.getClass();
            AudioTrack audioTrack2 = audioTrack;
            if (audioTrack.getPlayState() == 2 && zzl() == 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final boolean zzh() {
        AudioTrack audioTrack = this.zzc;
        audioTrack.getClass();
        AudioTrack audioTrack2 = audioTrack;
        return audioTrack.getPlayState() == 3;
    }

    public final boolean zzi(long j) {
        return this.zzy != -9223372036854775807L && j > 0 && this.zzI.zzb() - this.zzy >= 200;
    }

    public final boolean zzj(long j) {
        AudioTrack audioTrack = this.zzc;
        audioTrack.getClass();
        AudioTrack audioTrack2 = audioTrack;
        int playState = audioTrack.getPlayState();
        if (this.zzg) {
            if (playState == 2) {
                this.zzo = false;
                return false;
            } else if (playState == 1) {
                if (zzl() == 0) {
                    return false;
                }
                playState = 1;
            }
        }
        boolean z = this.zzo;
        boolean zzg2 = zzg(j);
        this.zzo = zzg2;
        if (z && !zzg2 && playState != 1) {
            this.zza.zze(this.zzd, zzen.zzv(this.zzh));
        }
        return true;
    }

    public final boolean zzk() {
        zzn();
        if (this.zzx == -9223372036854775807L) {
            zzpw zzpw = this.zze;
            zzpw.getClass();
            zzpw zzpw2 = zzpw;
            zzpw.zze();
            return true;
        }
        this.zzz = zzl();
        return false;
    }
}
