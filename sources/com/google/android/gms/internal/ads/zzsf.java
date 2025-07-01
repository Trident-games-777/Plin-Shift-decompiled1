package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzsf implements zzsl {
    private final Context zza;

    @Deprecated
    public zzsf() {
        this.zza = null;
    }

    public zzsf(Context context) {
        this.zza = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0099  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzsn zzd(com.google.android.gms.internal.ads.zzsk r7) throws java.io.IOException {
        /*
            r6 = this;
            int r0 = com.google.android.gms.internal.ads.zzen.zza
            r1 = 23
            if (r0 < r1) goto L_0x0047
            r1 = 31
            if (r0 < r1) goto L_0x000b
            goto L_0x0022
        L_0x000b:
            android.content.Context r0 = r6.zza
            if (r0 == 0) goto L_0x0047
            int r1 = com.google.android.gms.internal.ads.zzen.zza
            r2 = 28
            if (r1 < r2) goto L_0x0047
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            java.lang.String r1 = "com.amazon.hardware.tv_screen"
            boolean r0 = r0.hasSystemFeature(r1)
            if (r0 != 0) goto L_0x0022
            goto L_0x0047
        L_0x0022:
            com.google.android.gms.internal.ads.zzad r0 = r7.zzc
            java.lang.String r0 = r0.zzo
            int r0 = com.google.android.gms.internal.ads.zzbg.zzb(r0)
            java.lang.String r1 = com.google.android.gms.internal.ads.zzen.zzD(r0)
            java.lang.String r2 = "DMCodecAdapterFactory"
            java.lang.String r3 = "Creating an asynchronous MediaCodec adapter for track type "
            java.lang.String r1 = r3.concat(r1)
            com.google.android.gms.internal.ads.zzdt.zze(r2, r1)
            com.google.android.gms.internal.ads.zzrv r1 = new com.google.android.gms.internal.ads.zzrv
            r1.<init>(r0)
            r0 = 1
            r1.zze(r0)
            com.google.android.gms.internal.ads.zzrx r7 = r1.zzc(r7)
            return r7
        L_0x0047:
            r0 = 0
            com.google.android.gms.internal.ads.zzsq r1 = r7.zza     // Catch:{ IOException -> 0x0096, RuntimeException -> 0x0094 }
            java.lang.String r1 = r1.zza     // Catch:{ IOException -> 0x0096, RuntimeException -> 0x0094 }
            java.lang.String r2 = "createCodec:"
            java.lang.String r2 = r2.concat(r1)     // Catch:{ IOException -> 0x0096, RuntimeException -> 0x0094 }
            android.os.Trace.beginSection(r2)     // Catch:{ IOException -> 0x0096, RuntimeException -> 0x0094 }
            android.media.MediaCodec r1 = android.media.MediaCodec.createByCodecName(r1)     // Catch:{ IOException -> 0x0096, RuntimeException -> 0x0094 }
            android.os.Trace.endSection()     // Catch:{ IOException -> 0x0096, RuntimeException -> 0x0094 }
            java.lang.String r2 = "configureCodec"
            android.os.Trace.beginSection(r2)     // Catch:{ IOException -> 0x0091, RuntimeException -> 0x008f }
            android.view.Surface r2 = r7.zzd     // Catch:{ IOException -> 0x0091, RuntimeException -> 0x008f }
            r3 = 0
            if (r2 != 0) goto L_0x0074
            com.google.android.gms.internal.ads.zzsq r4 = r7.zza     // Catch:{ IOException -> 0x0091, RuntimeException -> 0x008f }
            boolean r4 = r4.zzh     // Catch:{ IOException -> 0x0091, RuntimeException -> 0x008f }
            if (r4 == 0) goto L_0x0074
            int r4 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ IOException -> 0x0091, RuntimeException -> 0x008f }
            r5 = 35
            if (r4 < r5) goto L_0x0074
            r3 = 8
        L_0x0074:
            android.media.MediaFormat r4 = r7.zzb     // Catch:{ IOException -> 0x0091, RuntimeException -> 0x008f }
            r1.configure(r4, r2, r0, r3)     // Catch:{ IOException -> 0x0091, RuntimeException -> 0x008f }
            android.os.Trace.endSection()     // Catch:{ IOException -> 0x0091, RuntimeException -> 0x008f }
            java.lang.String r2 = "startCodec"
            android.os.Trace.beginSection(r2)     // Catch:{ IOException -> 0x0091, RuntimeException -> 0x008f }
            r1.start()     // Catch:{ IOException -> 0x0091, RuntimeException -> 0x008f }
            android.os.Trace.endSection()     // Catch:{ IOException -> 0x0091, RuntimeException -> 0x008f }
            com.google.android.gms.internal.ads.zztn r2 = new com.google.android.gms.internal.ads.zztn     // Catch:{ IOException -> 0x0091, RuntimeException -> 0x008f }
            com.google.android.gms.internal.ads.zzsj r7 = r7.zzf     // Catch:{ IOException -> 0x0091, RuntimeException -> 0x008f }
            r2.<init>(r1, r7, r0)     // Catch:{ IOException -> 0x0091, RuntimeException -> 0x008f }
            return r2
        L_0x008f:
            r7 = move-exception
            goto L_0x0092
        L_0x0091:
            r7 = move-exception
        L_0x0092:
            r0 = r1
            goto L_0x0097
        L_0x0094:
            r7 = move-exception
            goto L_0x0097
        L_0x0096:
            r7 = move-exception
        L_0x0097:
            if (r0 == 0) goto L_0x009c
            r0.release()
        L_0x009c:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsf.zzd(com.google.android.gms.internal.ads.zzsk):com.google.android.gms.internal.ads.zzsn");
    }
}
