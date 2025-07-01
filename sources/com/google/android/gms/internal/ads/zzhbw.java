package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
abstract class zzhbw {
    zzhbw() {
    }

    static final String zzc(ByteBuffer byteBuffer, int i, int i2) throws zzgzm {
        int i3;
        if ((((byteBuffer.limit() - i) - i2) | i | i2) >= 0) {
            int i4 = i + i2;
            char[] cArr = new char[i2];
            int i5 = 0;
            while (r8 < i4) {
                byte b = byteBuffer.get(r8);
                if (!zzhbv.zzd(b)) {
                    break;
                }
                i = r8 + 1;
                cArr[i5] = (char) b;
                i5++;
            }
            int i6 = i5;
            while (r8 < i4) {
                int i7 = r8 + 1;
                byte b2 = byteBuffer.get(r8);
                if (zzhbv.zzd(b2)) {
                    cArr[i6] = (char) b2;
                    i6++;
                    r8 = i7;
                    while (r8 < i4) {
                        byte b3 = byteBuffer.get(r8);
                        if (!zzhbv.zzd(b3)) {
                            break;
                        }
                        r8++;
                        cArr[i6] = (char) b3;
                        i6++;
                    }
                } else {
                    if (zzhbv.zzf(b2)) {
                        if (i7 < i4) {
                            i3 = i6 + 1;
                            r8 = r8 + 2;
                            zzhbv.zzc(b2, byteBuffer.get(i7), cArr, i6);
                        } else {
                            throw new zzgzm("Protocol message had invalid UTF-8.");
                        }
                    } else if (zzhbv.zze(b2)) {
                        if (i7 < i4 - 1) {
                            i3 = i6 + 1;
                            int i8 = r8 + 2;
                            r8 = r8 + 3;
                            zzhbv.zzb(b2, byteBuffer.get(i7), byteBuffer.get(i8), cArr, i6);
                        } else {
                            throw new zzgzm("Protocol message had invalid UTF-8.");
                        }
                    } else if (i7 < i4 - 2) {
                        int i9 = r8 + 3;
                        r8 += 4;
                        zzhbv.zza(b2, byteBuffer.get(i7), byteBuffer.get(r8 + 2), byteBuffer.get(i9), cArr, i6);
                        i6 += 2;
                    } else {
                        throw new zzgzm("Protocol message had invalid UTF-8.");
                    }
                    i6 = i3;
                }
            }
            return new String(cArr, 0, i6);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    /* access modifiers changed from: package-private */
    public abstract int zza(int i, byte[] bArr, int i2, int i3);

    /* access modifiers changed from: package-private */
    public abstract String zzb(byte[] bArr, int i, int i2) throws zzgzm;
}
