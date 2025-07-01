package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzrd {
    private static final byte[] zza = {79, 103, 103, 83, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Ascii.FS, -43, -59, -9, 1, 19, 79, 112, 117, 115, 72, 101, 97, 100, 1, 2, 56, 1, Byte.MIN_VALUE, -69, 0, 0, 0, 0, 0};
    private static final byte[] zzb = {79, 103, 103, 83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, Ascii.VT, -103, 87, 83, 1, Ascii.DLE, 79, 112, 117, 115, 84, 97, 103, 115, 0, 0, 0, 0, 0, 0, 0, 0};
    private ByteBuffer zzc = zzcm.zza;
    private int zzd = 2;
    private int zze = 0;

    private static final void zzc(ByteBuffer byteBuffer, long j, int i, int i2, boolean z) {
        byteBuffer.put((byte) 79);
        byteBuffer.put((byte) 103);
        byteBuffer.put((byte) 103);
        byteBuffer.put((byte) 83);
        byteBuffer.put((byte) 0);
        byteBuffer.put(true != z ? (byte) 0 : 2);
        byteBuffer.putLong(j);
        byteBuffer.putInt(0);
        byteBuffer.putInt(i);
        byteBuffer.putInt(0);
        byteBuffer.put(zzgcu.zza((long) i2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: byte[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzhm r22, java.util.List r23) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            java.nio.ByteBuffer r2 = r1.zzc
            r2.getClass()
            int r2 = r2.limit()
            java.nio.ByteBuffer r3 = r1.zzc
            int r3 = r3.position()
            int r2 = r2 - r3
            if (r2 != 0) goto L_0x0017
            return
        L_0x0017:
            int r2 = r0.zzd
            r3 = 0
            r4 = 1
            r5 = 2
            r6 = 0
            if (r2 != r5) goto L_0x0035
            int r2 = r23.size()
            if (r2 == r4) goto L_0x002c
            int r2 = r23.size()
            r7 = 3
            if (r2 != r7) goto L_0x0035
        L_0x002c:
            r2 = r23
            java.lang.Object r2 = r2.get(r6)
            r3 = r2
            byte[] r3 = (byte[]) r3
        L_0x0035:
            java.nio.ByteBuffer r2 = r1.zzc
            int r7 = r2.position()
            int r8 = r2.limit()
            int r9 = r8 - r7
            int r10 = r0.zzd
            int r11 = r9 + 255
            r12 = 255(0xff, float:3.57E-43)
            int r11 = r11 / r12
            int r13 = r11 + 27
            int r13 = r13 + r9
            if (r10 != r5) goto L_0x0059
            if (r3 == 0) goto L_0x0053
            int r10 = r3.length
            int r10 = r10 + 28
            goto L_0x0055
        L_0x0053:
            r10 = 47
        L_0x0055:
            int r14 = r10 + 44
            int r13 = r13 + r14
            goto L_0x005a
        L_0x0059:
            r10 = r6
        L_0x005a:
            java.nio.ByteBuffer r14 = r0.zzc
            int r14 = r14.capacity()
            if (r14 >= r13) goto L_0x006f
            java.nio.ByteBuffer r13 = java.nio.ByteBuffer.allocate(r13)
            java.nio.ByteOrder r14 = java.nio.ByteOrder.LITTLE_ENDIAN
            java.nio.ByteBuffer r13 = r13.order(r14)
            r0.zzc = r13
            goto L_0x0074
        L_0x006f:
            java.nio.ByteBuffer r13 = r0.zzc
            r13.clear()
        L_0x0074:
            java.nio.ByteBuffer r13 = r0.zzc
            int r14 = r0.zzd
            r15 = 22
            if (r14 != r5) goto L_0x00c1
            if (r3 == 0) goto L_0x00b2
            r18 = 1
            r19 = 1
            r14 = r15
            r15 = 0
            r17 = 0
            r20 = r14
            r14 = r13
            r13 = r20
            zzc(r14, r15, r17, r18, r19)
            int r15 = r3.length
            r19 = r4
            long r4 = (long) r15
            byte r4 = com.google.android.gms.internal.ads.zzgcu.zza(r4)
            r14.put(r4)
            r14.put(r3)
            byte[] r3 = r14.array()
            int r4 = r14.arrayOffset()
            int r15 = r15 + 28
            int r3 = com.google.android.gms.internal.ads.zzen.zzf(r3, r4, r15, r6)
            r14.putInt(r13, r3)
            r14.position(r15)
            goto L_0x00bb
        L_0x00b2:
            r19 = r4
            r14 = r13
            r13 = r15
            byte[] r3 = zza
            r14.put(r3)
        L_0x00bb:
            byte[] r3 = zzb
            r14.put(r3)
            goto L_0x00c5
        L_0x00c1:
            r19 = r4
            r14 = r13
            r13 = r15
        L_0x00c5:
            int r3 = com.google.android.gms.internal.ads.zzadm.zzc(r2)
            int r4 = r0.zze
            int r4 = r4 + r3
            r0.zze = r4
            int r3 = r0.zzd
            long r4 = (long) r4
            r18 = 0
            r16 = r3
            r17 = r11
            r3 = r13
            r13 = r14
            r14 = r4
            zzc(r13, r14, r16, r17, r18)
            r14 = r13
            r4 = r6
        L_0x00df:
            if (r4 >= r11) goto L_0x00f2
            if (r9 < r12) goto L_0x00ea
            r5 = -1
            r14.put(r5)
            int r9 = r9 + -255
            goto L_0x00ef
        L_0x00ea:
            byte r5 = (byte) r9
            r14.put(r5)
            r9 = r6
        L_0x00ef:
            int r4 = r4 + 1
            goto L_0x00df
        L_0x00f2:
            if (r7 >= r8) goto L_0x00fe
            byte r4 = r2.get(r7)
            r14.put(r4)
            int r7 = r7 + 1
            goto L_0x00f2
        L_0x00fe:
            int r4 = r2.limit()
            r2.position(r4)
            r14.flip()
            int r2 = r0.zzd
            r4 = 2
            if (r2 != r4) goto L_0x012b
            byte[] r2 = r14.array()
            int r3 = r14.arrayOffset()
            int r3 = r3 + r10
            int r3 = r3 + 44
            int r4 = r14.limit()
            int r5 = r14.position()
            int r4 = r4 - r5
            int r2 = com.google.android.gms.internal.ads.zzen.zzf(r2, r3, r4, r6)
            int r10 = r10 + 66
            r14.putInt(r10, r2)
            goto L_0x0143
        L_0x012b:
            byte[] r2 = r14.array()
            int r4 = r14.arrayOffset()
            int r5 = r14.limit()
            int r7 = r14.position()
            int r5 = r5 - r7
            int r2 = com.google.android.gms.internal.ads.zzen.zzf(r2, r4, r5, r6)
            r14.putInt(r3, r2)
        L_0x0143:
            int r2 = r0.zzd
            int r2 = r2 + 1
            r0.zzd = r2
            r0.zzc = r14
            r1.zzb()
            java.nio.ByteBuffer r2 = r0.zzc
            int r2 = r2.remaining()
            r1.zzj(r2)
            java.nio.ByteBuffer r2 = r1.zzc
            java.nio.ByteBuffer r3 = r0.zzc
            r2.put(r3)
            r1.zzk()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrd.zza(com.google.android.gms.internal.ads.zzhm, java.util.List):void");
    }

    public final void zzb() {
        this.zzc = zzcm.zza;
        this.zze = 0;
        this.zzd = 2;
    }
}
