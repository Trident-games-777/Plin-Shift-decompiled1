package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzfgo implements Runnable {
    public final /* synthetic */ InputStream zza;
    public final /* synthetic */ ParcelFileDescriptor zzb;

    public /* synthetic */ zzfgo(InputStream inputStream, ParcelFileDescriptor parcelFileDescriptor) {
        this.zza = inputStream;
        this.zzb = parcelFileDescriptor;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0026, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:8:0x0011, B:20:0x0022] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r3 = this;
            java.io.InputStream r0 = r3.zza
            android.os.ParcelFileDescriptor r1 = r3.zzb
            android.os.ParcelFileDescriptor$AutoCloseOutputStream r2 = new android.os.ParcelFileDescriptor$AutoCloseOutputStream     // Catch:{ all -> 0x001f }
            r2.<init>(r1)     // Catch:{ all -> 0x001f }
            com.google.android.gms.common.util.IOUtils.copyStream(r0, r2)     // Catch:{ all -> 0x0015 }
            r2.close()     // Catch:{ all -> 0x001f }
            if (r0 == 0) goto L_0x002b
            r0.close()     // Catch:{ IOException -> 0x002b }
            return
        L_0x0015:
            r1 = move-exception
            r2.close()     // Catch:{ all -> 0x001a }
            goto L_0x001e
        L_0x001a:
            r2 = move-exception
            r1.addSuppressed(r2)     // Catch:{ all -> 0x001f }
        L_0x001e:
            throw r1     // Catch:{ all -> 0x001f }
        L_0x001f:
            r1 = move-exception
            if (r0 == 0) goto L_0x002a
            r0.close()     // Catch:{ all -> 0x0026 }
            goto L_0x002a
        L_0x0026:
            r0 = move-exception
            r1.addSuppressed(r0)     // Catch:{ IOException -> 0x002b }
        L_0x002a:
            throw r1     // Catch:{ IOException -> 0x002b }
        L_0x002b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfgo.run():void");
    }
}
