package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzpz extends zzcn {
    private int[] zzd;
    private int[] zze;

    zzpz() {
    }

    public final void zze(ByteBuffer byteBuffer) {
        int[] iArr = this.zze;
        iArr.getClass();
        int[] iArr2 = iArr;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        ByteBuffer zzj = zzj(((limit - position) / this.zzb.zze) * this.zzc.zze);
        while (position < limit) {
            for (int i : iArr2) {
                zzj.putShort(byteBuffer.getShort(i + i + position));
            }
            position += this.zzb.zze;
        }
        byteBuffer.position(limit);
        zzj.flip();
    }

    public final zzck zzi(zzck zzck) throws zzcl {
        int[] iArr = this.zzd;
        if (iArr == null) {
            return zzck.zza;
        }
        if (zzck.zzd == 2) {
            boolean z = zzck.zzc != iArr.length;
            int i = 0;
            while (true) {
                int length = iArr.length;
                if (i >= length) {
                    return z ? new zzck(zzck.zzb, length, 2) : zzck.zza;
                }
                int i2 = iArr[i];
                if (i2 < zzck.zzc) {
                    z |= i2 != i;
                    i++;
                } else {
                    throw new zzcl("Unhandled input format:", zzck);
                }
            }
        } else {
            throw new zzcl("Unhandled input format:", zzck);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzk() {
        this.zze = this.zzd;
    }

    /* access modifiers changed from: protected */
    public final void zzm() {
        this.zze = null;
        this.zzd = null;
    }

    public final void zzo(int[] iArr) {
        this.zzd = iArr;
    }
}
