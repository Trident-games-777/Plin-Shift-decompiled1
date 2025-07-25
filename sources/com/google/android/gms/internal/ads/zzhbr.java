package com.google.android.gms.internal.ads;

import libcore.io.Memory;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzhbr extends zzhbt {
    zzhbr(Unsafe unsafe) {
        super(unsafe);
    }

    public final byte zza(long j) {
        return Memory.peekByte((int) j);
    }

    public final double zzb(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    public final float zzc(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    public final void zzd(long j, byte[] bArr, long j2, long j3) {
        Memory.peekByteArray((int) j, bArr, (int) j2, (int) j3);
    }

    public final void zze(Object obj, long j, boolean z) {
        if (zzhbu.zzb) {
            zzhbu.zzG(obj, j, r3 ? (byte) 1 : 0);
        } else {
            zzhbu.zzH(obj, j, r3 ? (byte) 1 : 0);
        }
    }

    public final void zzf(Object obj, long j, byte b) {
        if (zzhbu.zzb) {
            zzhbu.zzG(obj, j, b);
        } else {
            zzhbu.zzH(obj, j, b);
        }
    }

    public final void zzg(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }

    public final void zzh(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    public final boolean zzi(Object obj, long j) {
        if (zzhbu.zzb) {
            return zzhbu.zzw(obj, j);
        }
        return zzhbu.zzx(obj, j);
    }
}
