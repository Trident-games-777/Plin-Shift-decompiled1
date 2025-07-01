package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzacv {
    public static int zza(zzacs zzacs, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int zzb = zzacs.zzb(bArr, i + i3, i2 - i3);
            if (zzb == -1) {
                break;
            }
            i3 += zzb;
        }
        return i3;
    }

    @Pure
    public static void zzb(boolean z, String str) throws zzbh {
        if (!z) {
            throw zzbh.zza(str, (Throwable) null);
        }
    }

    public static boolean zzc(zzacs zzacs, byte[] bArr, int i, int i2, boolean z) throws IOException {
        try {
            return zzacs.zzm(bArr, 0, i2, z);
        } catch (EOFException e) {
            if (z) {
                return false;
            }
            throw e;
        }
    }

    public static boolean zzd(zzacs zzacs, byte[] bArr, int i, int i2) throws IOException {
        try {
            zzacs.zzi(bArr, i, i2);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean zze(zzacs zzacs, int i) throws IOException {
        try {
            zzacs.zzk(i);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
