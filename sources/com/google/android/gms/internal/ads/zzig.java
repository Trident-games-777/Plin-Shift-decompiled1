package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.core.view.PointerIconCompat;
import java.io.IOException;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzig extends zzbi {
    public final int zzc;
    public final String zzd;
    public final int zze;
    public final zzad zzf;
    public final int zzg;
    public final zzur zzh;
    final boolean zzi;

    static {
        Integer.toString(1001, 36);
        Integer.toString(PointerIconCompat.TYPE_HAND, 36);
        Integer.toString(PointerIconCompat.TYPE_HELP, 36);
        Integer.toString(PointerIconCompat.TYPE_WAIT, 36);
        Integer.toString(WebSocketProtocol.CLOSE_NO_STATUS_CODE, 36);
        Integer.toString(PointerIconCompat.TYPE_CELL, 36);
    }

    private zzig(int i, Throwable th, int i2) {
        this(i, th, (String) null, i2, (String) null, -1, (zzad) null, 4, false);
    }

    public static zzig zzb(Throwable th, String str, int i, zzad zzad, int i2, boolean z, int i3) {
        if (zzad == null) {
            i2 = 4;
        }
        return new zzig(1, th, (String) null, i3, str, i, zzad, i2, z);
    }

    public static zzig zzc(IOException iOException, int i) {
        return new zzig(0, iOException, i);
    }

    public static zzig zzd(RuntimeException runtimeException, int i) {
        return new zzig(2, runtimeException, i);
    }

    /* access modifiers changed from: package-private */
    public final zzig zza(zzur zzur) {
        String message = getMessage();
        int i = zzen.zza;
        String str = message;
        return new zzig(message, getCause(), this.zza, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, zzur, this.zzb, this.zzi);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzig(int r14, java.lang.Throwable r15, java.lang.String r16, int r17, java.lang.String r18, int r19, com.google.android.gms.internal.ads.zzad r20, int r21, boolean r22) {
        /*
            r13 = this;
            r8 = r21
            if (r14 == 0) goto L_0x005e
            r0 = 1
            if (r14 == r0) goto L_0x000e
            java.lang.String r0 = "Unexpected runtime error"
            r5 = r18
            r6 = r19
            goto L_0x0064
        L_0x000e:
            java.lang.String r1 = java.lang.String.valueOf(r20)
            int r2 = com.google.android.gms.internal.ads.zzen.zza
            if (r8 == 0) goto L_0x0033
            if (r8 == r0) goto L_0x0030
            r0 = 2
            if (r8 == r0) goto L_0x002d
            r0 = 3
            if (r8 == r0) goto L_0x002a
            r0 = 4
            if (r8 != r0) goto L_0x0024
            java.lang.String r0 = "YES"
            goto L_0x0035
        L_0x0024:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            r14.<init>()
            throw r14
        L_0x002a:
            java.lang.String r0 = "NO_EXCEEDS_CAPABILITIES"
            goto L_0x0035
        L_0x002d:
            java.lang.String r0 = "NO_UNSUPPORTED_DRM"
            goto L_0x0035
        L_0x0030:
            java.lang.String r0 = "NO_UNSUPPORTED_TYPE"
            goto L_0x0035
        L_0x0033:
            java.lang.String r0 = "NO"
        L_0x0035:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r5 = r18
            r2.append(r5)
            java.lang.String r3 = " error, index="
            r2.append(r3)
            r6 = r19
            r2.append(r6)
            java.lang.String r3 = ", format="
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = ", format_supported="
            r2.append(r1)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            goto L_0x0064
        L_0x005e:
            r5 = r18
            r6 = r19
            java.lang.String r0 = "Source error"
        L_0x0064:
            r1 = 0
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0071
            java.lang.String r1 = ": null"
            java.lang.String r0 = r0.concat(r1)
        L_0x0071:
            r1 = r0
            r9 = 0
            long r10 = android.os.SystemClock.elapsedRealtime()
            r0 = r13
            r4 = r14
            r2 = r15
            r3 = r17
            r7 = r20
            r12 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzig.<init>(int, java.lang.Throwable, java.lang.String, int, java.lang.String, int, com.google.android.gms.internal.ads.zzad, int, boolean):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzig(String str, Throwable th, int i, int i2, String str2, int i3, zzad zzad, int i4, zzur zzur, long j, boolean z) {
        super(str, th, i, Bundle.EMPTY, j);
        boolean z2;
        boolean z3 = z;
        boolean z4 = false;
        if (!z3) {
            z2 = true;
        } else if (i2 == 1) {
            i2 = 1;
            z2 = true;
        } else {
            z2 = false;
        }
        zzdb.zzd(z2);
        zzdb.zzd(th != null ? true : z4);
        this.zzc = i2;
        this.zzd = str2;
        this.zze = i3;
        this.zzf = zzad;
        this.zzg = i4;
        this.zzh = zzur;
        this.zzi = z3;
    }
}
