package com.google.android.gms.internal.ads;

import android.os.HandlerThread;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzrv implements zzsl {
    private final zzfxg zza;
    private final zzfxg zzb;
    private boolean zzc = true;

    public zzrv(int i) {
        zzrt zzrt = new zzrt(i);
        zzru zzru = new zzru(i);
        this.zza = zzrt;
        this.zzb = zzru;
    }

    static /* synthetic */ HandlerThread zza(int i) {
        return new HandlerThread(zzrx.zzt(i, "ExoPlayer:MediaCodecAsyncAdapter:"));
    }

    static /* synthetic */ HandlerThread zzb(int i) {
        return new HandlerThread(zzrx.zzt(i, "ExoPlayer:MediaCodecQueueingThread:"));
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0093  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzrx zzc(com.google.android.gms.internal.ads.zzsk r10) throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = "createCodec:"
            com.google.android.gms.internal.ads.zzsq r1 = r10.zza
            java.lang.String r1 = r1.zza
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0088 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x0088 }
            r3.append(r1)     // Catch:{ Exception -> 0x0088 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0088 }
            android.os.Trace.beginSection(r0)     // Catch:{ Exception -> 0x0088 }
            android.media.MediaCodec r4 = android.media.MediaCodec.createByCodecName(r1)     // Catch:{ Exception -> 0x0088 }
            boolean r0 = r9.zzc     // Catch:{ Exception -> 0x0085 }
            r1 = 35
            if (r0 == 0) goto L_0x003c
            com.google.android.gms.internal.ads.zzad r0 = r10.zzc     // Catch:{ Exception -> 0x0085 }
            int r3 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x0085 }
            r5 = 34
            if (r3 >= r5) goto L_0x0029
            goto L_0x003c
        L_0x0029:
            int r3 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x0085 }
            if (r3 >= r1) goto L_0x0035
            java.lang.String r0 = r0.zzo     // Catch:{ Exception -> 0x0085 }
            boolean r0 = com.google.android.gms.internal.ads.zzbg.zzi(r0)     // Catch:{ Exception -> 0x0085 }
            if (r0 == 0) goto L_0x003c
        L_0x0035:
            com.google.android.gms.internal.ads.zzto r0 = new com.google.android.gms.internal.ads.zzto     // Catch:{ Exception -> 0x0085 }
            r0.<init>(r4)     // Catch:{ Exception -> 0x0085 }
            r3 = 4
            goto L_0x004f
        L_0x003c:
            com.google.android.gms.internal.ads.zzsb r0 = new com.google.android.gms.internal.ads.zzsb     // Catch:{ Exception -> 0x0085 }
            com.google.android.gms.internal.ads.zzfxg r3 = r9.zzb     // Catch:{ Exception -> 0x0085 }
            com.google.android.gms.internal.ads.zzru r3 = (com.google.android.gms.internal.ads.zzru) r3     // Catch:{ Exception -> 0x0085 }
            int r3 = r3.zza     // Catch:{ Exception -> 0x0085 }
            android.os.HandlerThread r3 = zzb(r3)     // Catch:{ Exception -> 0x0085 }
            r5 = r3
            android.os.HandlerThread r5 = (android.os.HandlerThread) r5     // Catch:{ Exception -> 0x0085 }
            r0.<init>(r4, r3)     // Catch:{ Exception -> 0x0085 }
            r3 = 0
        L_0x004f:
            r6 = r0
            r0 = r3
            com.google.android.gms.internal.ads.zzrx r3 = new com.google.android.gms.internal.ads.zzrx     // Catch:{ Exception -> 0x0085 }
            com.google.android.gms.internal.ads.zzfxg r5 = r9.zza     // Catch:{ Exception -> 0x0085 }
            com.google.android.gms.internal.ads.zzrt r5 = (com.google.android.gms.internal.ads.zzrt) r5     // Catch:{ Exception -> 0x0085 }
            int r5 = r5.zza     // Catch:{ Exception -> 0x0085 }
            android.os.HandlerThread r5 = zza(r5)     // Catch:{ Exception -> 0x0085 }
            r7 = r5
            android.os.HandlerThread r7 = (android.os.HandlerThread) r7     // Catch:{ Exception -> 0x0085 }
            com.google.android.gms.internal.ads.zzsj r7 = r10.zzf     // Catch:{ Exception -> 0x0085 }
            r8 = 0
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0085 }
            android.os.Trace.endSection()     // Catch:{ Exception -> 0x0081 }
            android.view.Surface r5 = r10.zzd     // Catch:{ Exception -> 0x0081 }
            if (r5 != 0) goto L_0x0079
            com.google.android.gms.internal.ads.zzsq r5 = r10.zza     // Catch:{ Exception -> 0x0081 }
            boolean r5 = r5.zzh     // Catch:{ Exception -> 0x0081 }
            if (r5 == 0) goto L_0x0079
            int r5 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x0081 }
            if (r5 < r1) goto L_0x0079
            r0 = r0 | 8
        L_0x0079:
            android.media.MediaFormat r1 = r10.zzb     // Catch:{ Exception -> 0x0081 }
            android.view.Surface r10 = r10.zzd     // Catch:{ Exception -> 0x0081 }
            com.google.android.gms.internal.ads.zzrx.zzh(r3, r1, r10, r2, r0)     // Catch:{ Exception -> 0x0081 }
            return r3
        L_0x0081:
            r0 = move-exception
            r10 = r0
            r2 = r3
            goto L_0x008b
        L_0x0085:
            r0 = move-exception
            r10 = r0
            goto L_0x008b
        L_0x0088:
            r0 = move-exception
            r10 = r0
            r4 = r2
        L_0x008b:
            if (r2 != 0) goto L_0x0093
            if (r4 == 0) goto L_0x0096
            r4.release()
            goto L_0x0096
        L_0x0093:
            r2.zzm()
        L_0x0096:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrv.zzc(com.google.android.gms.internal.ads.zzsk):com.google.android.gms.internal.ads.zzrx");
    }

    public final /* bridge */ /* synthetic */ zzsn zzd(zzsk zzsk) throws IOException {
        throw null;
    }

    public final void zze(boolean z) {
        this.zzc = true;
    }
}
