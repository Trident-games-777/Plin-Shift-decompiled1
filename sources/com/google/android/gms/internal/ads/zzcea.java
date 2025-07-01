package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.Clock;
import com.google.firebase.messaging.Constants;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcea extends zzcdr implements zzcbv {
    public static final /* synthetic */ int zzd = 0;
    private zzcbw zze;
    private String zzf;
    private boolean zzg;
    private boolean zzh;
    private zzcdj zzi;
    private long zzj;
    private long zzk;

    public zzcea(zzccf zzccf, zzcce zzcce) {
        super(zzccf);
        zzces zzces = new zzces(zzccf.getContext(), zzcce, (zzccf) this.zzc.get(), (Integer) null);
        zzm.zzi("ExoPlayerAdapter initialized.");
        this.zze = zzces;
        zzces.zzL(this);
    }

    protected static final String zzc(String str) {
        return "cache:".concat(String.valueOf(zzf.zzf(str)));
    }

    private static String zzd(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        return str + RemoteSettings.FORWARD_SLASH_STRING + canonicalName + ":" + message;
    }

    private final void zzx(long j) {
        zzs.zza.postDelayed(new zzcdz(this), j);
    }

    public final void release() {
        zzcbw zzcbw = this.zze;
        if (zzcbw != null) {
            zzcbw.zzL((zzcbv) null);
            this.zze.zzH();
        }
    }

    public final void zzD(int i, int i2) {
    }

    public final zzcbw zza() {
        synchronized (this) {
            this.zzh = true;
            notify();
        }
        this.zze.zzL((zzcbv) null);
        zzcbw zzcbw = this.zze;
        this.zze = null;
        return zzcbw;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e0, code lost:
        zzx(((java.lang.Long) com.google.android.gms.ads.internal.client.zzbe.zzc().zza(com.google.android.gms.internal.ads.zzbcn.zzI)).longValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f3, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zzb() {
        /*
            r24 = this;
            r1 = r24
            java.lang.String r0 = "Timeout reached. Limit: "
            java.lang.String r2 = r1.zzf
            java.lang.String r3 = zzc(r2)
            java.lang.String r17 = "error"
            com.google.android.gms.internal.ads.zzbce r2 = com.google.android.gms.internal.ads.zzbcn.zzH     // Catch:{ Exception -> 0x0128 }
            com.google.android.gms.internal.ads.zzbcl r4 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ Exception -> 0x0128 }
            java.lang.Object r2 = r4.zza(r2)     // Catch:{ Exception -> 0x0128 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ Exception -> 0x0128 }
            long r4 = r2.longValue()     // Catch:{ Exception -> 0x0128 }
            r6 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 * r6
            com.google.android.gms.internal.ads.zzbce r2 = com.google.android.gms.internal.ads.zzbcn.zzr     // Catch:{ Exception -> 0x0128 }
            com.google.android.gms.internal.ads.zzbcl r6 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ Exception -> 0x0128 }
            java.lang.Object r2 = r6.zza(r2)     // Catch:{ Exception -> 0x0128 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ Exception -> 0x0128 }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x0128 }
            long r6 = (long) r2     // Catch:{ Exception -> 0x0128 }
            com.google.android.gms.internal.ads.zzbce r2 = com.google.android.gms.internal.ads.zzbcn.zzbW     // Catch:{ Exception -> 0x0128 }
            com.google.android.gms.internal.ads.zzbcl r8 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ Exception -> 0x0128 }
            java.lang.Object r2 = r8.zza(r2)     // Catch:{ Exception -> 0x0128 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Exception -> 0x0128 }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x0128 }
            monitor-enter(r24)     // Catch:{ Exception -> 0x0128 }
            com.google.android.gms.common.util.Clock r8 = com.google.android.gms.ads.internal.zzv.zzC()     // Catch:{ all -> 0x0125 }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x0125 }
            long r10 = r1.zzj     // Catch:{ all -> 0x0125 }
            long r8 = r8 - r10
            int r8 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r8 > 0) goto L_0x0108
            boolean r0 = r1.zzg     // Catch:{ all -> 0x0125 }
            if (r0 != 0) goto L_0x00fe
            boolean r0 = r1.zzh     // Catch:{ all -> 0x0125 }
            if (r0 == 0) goto L_0x005b
            monitor-exit(r24)     // Catch:{ all -> 0x0125 }
            goto L_0x015f
        L_0x005b:
            com.google.android.gms.internal.ads.zzcbw r0 = r1.zze     // Catch:{ all -> 0x0125 }
            boolean r0 = r0.zzV()     // Catch:{ all -> 0x0125 }
            if (r0 == 0) goto L_0x00f4
            com.google.android.gms.internal.ads.zzcbw r0 = r1.zze     // Catch:{ all -> 0x0125 }
            long r4 = r0.zzz()     // Catch:{ all -> 0x0125 }
            r18 = 0
            int r0 = (r4 > r18 ? 1 : (r4 == r18 ? 0 : -1))
            if (r0 <= 0) goto L_0x00df
            com.google.android.gms.internal.ads.zzcbw r0 = r1.zze     // Catch:{ all -> 0x0125 }
            long r8 = r0.zzv()     // Catch:{ all -> 0x0125 }
            long r10 = r1.zzk     // Catch:{ all -> 0x0125 }
            int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r0 == 0) goto L_0x00be
            int r0 = (r8 > r18 ? 1 : (r8 == r18 ? 0 : -1))
            if (r0 <= 0) goto L_0x0081
            r0 = 1
            goto L_0x0082
        L_0x0081:
            r0 = 0
        L_0x0082:
            r10 = r2
            java.lang.String r2 = r1.zzf     // Catch:{ all -> 0x0125 }
            r11 = -1
            if (r10 == 0) goto L_0x0090
            com.google.android.gms.internal.ads.zzcbw r13 = r1.zze     // Catch:{ all -> 0x0125 }
            long r13 = r13.zzA()     // Catch:{ all -> 0x0125 }
            goto L_0x0091
        L_0x0090:
            r13 = r11
        L_0x0091:
            if (r10 == 0) goto L_0x009a
            com.google.android.gms.internal.ads.zzcbw r15 = r1.zze     // Catch:{ all -> 0x0125 }
            long r15 = r15.zzx()     // Catch:{ all -> 0x0125 }
            goto L_0x009b
        L_0x009a:
            r15 = r11
        L_0x009b:
            if (r10 == 0) goto L_0x00a3
            com.google.android.gms.internal.ads.zzcbw r10 = r1.zze     // Catch:{ all -> 0x0125 }
            long r11 = r10.zzB()     // Catch:{ all -> 0x0125 }
        L_0x00a3:
            r20 = r15
            int r15 = com.google.android.gms.internal.ads.zzcbw.zzs()     // Catch:{ all -> 0x0125 }
            int r16 = com.google.android.gms.internal.ads.zzcbw.zzu()     // Catch:{ all -> 0x0125 }
            r22 = r6
            r6 = r4
            r4 = r8
            r9 = r13
            r13 = r11
            r11 = r20
            r20 = r22
            r8 = r0
            r1.zzo(r2, r3, r4, r6, r8, r9, r11, r13, r15, r16)     // Catch:{ all -> 0x0125 }
            r1.zzk = r4     // Catch:{ all -> 0x0125 }
            goto L_0x00c2
        L_0x00be:
            r20 = r6
            r6 = r4
            r4 = r8
        L_0x00c2:
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 < 0) goto L_0x00ce
            java.lang.String r0 = r1.zzf     // Catch:{ all -> 0x0125 }
            r1.zzj(r0, r3, r6)     // Catch:{ all -> 0x0125 }
            monitor-exit(r24)     // Catch:{ all -> 0x0125 }
            goto L_0x015f
        L_0x00ce:
            com.google.android.gms.internal.ads.zzcbw r0 = r1.zze     // Catch:{ all -> 0x0125 }
            long r6 = r0.zzw()     // Catch:{ all -> 0x0125 }
            int r0 = (r6 > r20 ? 1 : (r6 == r20 ? 0 : -1))
            if (r0 < 0) goto L_0x00df
            int r0 = (r4 > r18 ? 1 : (r4 == r18 ? 0 : -1))
            if (r0 <= 0) goto L_0x00df
            monitor-exit(r24)     // Catch:{ all -> 0x0125 }
            goto L_0x015f
        L_0x00df:
            monitor-exit(r24)     // Catch:{ all -> 0x0125 }
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzI
            com.google.android.gms.internal.ads.zzbcl r2 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r0 = r2.zza(r0)
            java.lang.Long r0 = (java.lang.Long) r0
            long r2 = r0.longValue()
            r1.zzx(r2)
            return
        L_0x00f4:
            java.lang.String r2 = "exoPlayerReleased"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0121 }
            java.lang.String r4 = "ExoPlayer was released during preloading."
            r0.<init>(r4)     // Catch:{ all -> 0x0121 }
            throw r0     // Catch:{ all -> 0x0121 }
        L_0x00fe:
            java.lang.String r2 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0121 }
            java.lang.String r4 = "Abort requested before buffering finished. "
            r0.<init>(r4)     // Catch:{ all -> 0x0121 }
            throw r0     // Catch:{ all -> 0x0121 }
        L_0x0108:
            java.lang.String r2 = "downloadTimeout"
            java.io.IOException r6 = new java.io.IOException     // Catch:{ all -> 0x0121 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0121 }
            r7.<init>(r0)     // Catch:{ all -> 0x0121 }
            r7.append(r4)     // Catch:{ all -> 0x0121 }
            java.lang.String r0 = " ms"
            r7.append(r0)     // Catch:{ all -> 0x0121 }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x0121 }
            r6.<init>(r0)     // Catch:{ all -> 0x0121 }
            throw r6     // Catch:{ all -> 0x0121 }
        L_0x0121:
            r0 = move-exception
            r17 = r2
            goto L_0x0126
        L_0x0125:
            r0 = move-exception
        L_0x0126:
            monitor-exit(r24)     // Catch:{ all -> 0x0125 }
            throw r0     // Catch:{ Exception -> 0x0128 }
        L_0x0128:
            r0 = move-exception
            r2 = r17
            java.lang.String r4 = r1.zzf
            java.lang.String r5 = r0.getMessage()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Failed to preload url "
            r6.<init>(r7)
            r6.append(r4)
            java.lang.String r4 = " Exception: "
            r6.append(r4)
            r6.append(r5)
            java.lang.String r4 = r6.toString()
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r4)
            java.lang.String r4 = "VideoStreamExoPlayerCache.preload"
            com.google.android.gms.internal.ads.zzbzz r5 = com.google.android.gms.ads.internal.zzv.zzp()
            r5.zzv(r0, r4)
            r1.release()
            java.lang.String r0 = zzd(r2, r0)
            java.lang.String r4 = r1.zzf
            r1.zzg(r4, r3, r2, r0)
        L_0x015f:
            com.google.android.gms.internal.ads.zzcdk r0 = com.google.android.gms.ads.internal.zzv.zzz()
            com.google.android.gms.internal.ads.zzcdj r2 = r1.zzi
            r0.zzc(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcea.zzb():void");
    }

    public final void zzf() {
        synchronized (this) {
            this.zzg = true;
            notify();
            release();
        }
        String str = this.zzf;
        if (str != null) {
            zzg(this.zzf, zzc(str), "externalAbort", "Programmatic precache abort.");
        }
    }

    public final void zzi(boolean z, long j) {
        zzccf zzccf = (zzccf) this.zzc.get();
        if (zzccf != null) {
            zzcaj.zze.execute(new zzcdy(zzccf, z, j));
        }
    }

    public final void zzk(String str, Exception exc) {
        zzm.zzk("Precache error", exc);
        zzv.zzp().zzv(exc, "VideoStreamExoPlayerCache.onError");
    }

    public final void zzl(String str, Exception exc) {
        zzm.zzk("Precache exception", exc);
        zzv.zzp().zzv(exc, "VideoStreamExoPlayerCache.onException");
    }

    public final void zzm(int i) {
    }

    public final void zzp(int i) {
        this.zze.zzJ(i);
    }

    public final void zzq(int i) {
        this.zze.zzK(i);
    }

    public final void zzr(int i) {
        this.zze.zzM(i);
    }

    public final void zzs(int i) {
        this.zze.zzN(i);
    }

    public final boolean zzt(String str) {
        return zzu(str, new String[]{str});
    }

    public final boolean zzu(String str, String[] strArr) {
        String str2;
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        boolean z;
        String str3 = str;
        String[] strArr2 = strArr;
        this.zzf = str3;
        String str4 = Constants.IPC_BUNDLE_KEY_SEND_ERROR;
        String zzc = zzc(str3);
        try {
            Uri[] uriArr = new Uri[strArr2.length];
            for (int i = 0; i < strArr2.length; i++) {
                uriArr[i] = Uri.parse(strArr2[i]);
            }
            this.zze.zzF(uriArr, this.zzb);
            zzccf zzccf = (zzccf) this.zzc.get();
            if (zzccf != null) {
                zzccf.zzt(zzc, this);
            }
            Clock zzC = zzv.zzC();
            long currentTimeMillis = zzC.currentTimeMillis();
            long longValue = ((Long) zzbe.zzc().zza(zzbcn.zzI)).longValue();
            long longValue2 = ((Long) zzbe.zzc().zza(zzbcn.zzH)).longValue() * 1000;
            long intValue = (long) ((Integer) zzbe.zzc().zza(zzbcn.zzr)).intValue();
            boolean booleanValue = ((Boolean) zzbe.zzc().zza(zzbcn.zzbW)).booleanValue();
            long j7 = -1;
            while (true) {
                synchronized (this) {
                    try {
                        if (zzC.currentTimeMillis() - currentTimeMillis > longValue2) {
                            str2 = "downloadTimeout";
                            throw new IOException("Timeout reached. Limit: " + longValue2 + " ms");
                        } else if (this.zzg) {
                            str2 = "externalAbort";
                            throw new IOException("Abort requested before buffering finished. ");
                        } else if (!this.zzh) {
                            if (this.zze.zzV()) {
                                long zzz = this.zze.zzz();
                                if (zzz > 0) {
                                    long zzv = this.zze.zzv();
                                    if (zzv != j7) {
                                        if (zzv > 0) {
                                            j6 = intValue;
                                            z = true;
                                        } else {
                                            j6 = intValue;
                                            z = false;
                                        }
                                        long j8 = longValue;
                                        j5 = zzv;
                                        j2 = j6;
                                        j = longValue2;
                                        j4 = zzz;
                                        j3 = j8;
                                        zzo(str3, zzc, j5, j4, z, booleanValue ? this.zze.zzA() : -1, booleanValue ? this.zze.zzx() : -1, booleanValue ? this.zze.zzB() : -1, zzcbw.zzs(), zzcbw.zzu());
                                        j7 = j5;
                                    } else {
                                        j3 = longValue;
                                        j = longValue2;
                                        j2 = intValue;
                                        j4 = zzz;
                                        j5 = zzv;
                                    }
                                    if (j5 >= j4) {
                                        zzj(str3, zzc, j4);
                                    } else if (this.zze.zzw() < j2 || j5 <= 0) {
                                        longValue = j3;
                                    }
                                } else {
                                    j = longValue2;
                                    j2 = intValue;
                                }
                                wait(longValue);
                            } else {
                                str2 = "exoPlayerReleased";
                                throw new IOException("ExoPlayer was released during preloading.");
                            }
                        }
                    } catch (InterruptedException unused) {
                        throw new IOException("Wait interrupted.");
                    } catch (Throwable th) {
                        th = th;
                        str4 = str2;
                        throw th;
                    }
                }
                intValue = j2;
                longValue2 = j;
            }
            return true;
        } catch (Exception e) {
            String str5 = str4;
            zzm.zzj("Failed to preload url " + str3 + " Exception: " + e.getMessage());
            zzv.zzp().zzv(e, "VideoStreamExoPlayerCache.preload");
            release();
            zzg(str3, zzc, str5, zzd(str5, e));
            return false;
        }
    }

    public final void zzv() {
        zzm.zzj("Precache onRenderedFirstFrame");
    }

    public final boolean zzw(String str, String[] strArr, zzcdj zzcdj) {
        this.zzf = str;
        this.zzi = zzcdj;
        String zzc = zzc(str);
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                uriArr[i] = Uri.parse(strArr[i]);
            }
            this.zze.zzF(uriArr, this.zzb);
            zzccf zzccf = (zzccf) this.zzc.get();
            if (zzccf != null) {
                zzccf.zzt(zzc, this);
            }
            this.zzj = zzv.zzC().currentTimeMillis();
            this.zzk = -1;
            zzx(0);
            return true;
        } catch (Exception e) {
            zzm.zzj("Failed to preload url " + str + " Exception: " + e.getMessage());
            zzv.zzp().zzv(e, "VideoStreamExoPlayerCache.preload");
            release();
            zzg(str, zzc, Constants.IPC_BUNDLE_KEY_SEND_ERROR, zzd(Constants.IPC_BUNDLE_KEY_SEND_ERROR, e));
            return false;
        }
    }
}
