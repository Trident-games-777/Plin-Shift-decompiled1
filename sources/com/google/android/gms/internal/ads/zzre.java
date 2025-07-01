package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzre extends zzcn {
    private int zzd;
    private boolean zze;
    private int zzf;
    private long zzg;
    private int zzh = 0;
    private byte[] zzi = zzen.zzf;
    private int zzj = 0;
    private int zzk = 0;
    private byte[] zzl = zzen.zzf;

    private final int zzq(int i) {
        boolean z = true;
        int zzr = ((zzr(2000000) - this.zzh) * this.zzd) - (this.zzi.length >> 1);
        if (zzr < 0) {
            z = false;
        }
        zzdb.zzf(z);
        int i2 = this.zzd;
        return (((int) Math.min((((float) i) * 0.2f) + 0.5f, (float) zzr)) / i2) * i2;
    }

    private final int zzr(long j) {
        return (int) ((j * ((long) this.zzb.zzb)) / AnimationKt.MillisToNanos);
    }

    private static int zzs(byte b, byte b2) {
        return (b << 8) | (b2 & 255);
    }

    private final void zzt(boolean z) {
        int i;
        int i2;
        int i3 = this.zzk;
        int length = this.zzi.length;
        boolean z2 = true;
        if (i3 != length) {
            if (z) {
                z = true;
            } else {
                return;
            }
        }
        if (this.zzh == 0) {
            if (z) {
                zzu(i3, 3);
                i = i3;
            } else {
                zzdb.zzf(i3 >= (length >> 1));
                i = this.zzi.length >> 1;
                zzu(i, 0);
            }
            i2 = i;
        } else {
            int i4 = length >> 1;
            int i5 = i3 - i4;
            if (z) {
                int zzq = zzq(i5) + (this.zzi.length >> 1);
                zzu(zzq, 2);
                int i6 = i4 + i5;
                i2 = zzq;
                i = i6;
            } else {
                int zzq2 = zzq(i5);
                zzu(zzq2, 1);
                i2 = zzq2;
                i = i5;
            }
        }
        zzdb.zzg(i % this.zzd == 0, "bytesConsumed is not aligned to frame size: %s" + i);
        if (i3 < i2) {
            z2 = false;
        }
        zzdb.zzf(z2);
        this.zzk -= i;
        int i7 = this.zzj + i;
        this.zzj = i7;
        this.zzj = i7 % this.zzi.length;
        int i8 = this.zzh;
        int i9 = this.zzd;
        this.zzh = i8 + (i2 / i9);
        this.zzg += (long) ((i - i2) / i9);
    }

    private final void zzu(int i, int i2) {
        int i3;
        if (i != 0) {
            boolean z = true;
            zzdb.zzd(this.zzk >= i);
            if (i2 == 2) {
                int i4 = this.zzj;
                int i5 = this.zzk;
                int i6 = i4 + i5;
                byte[] bArr = this.zzi;
                int length = bArr.length;
                if (i6 <= length) {
                    System.arraycopy(bArr, i6 - i, this.zzl, 0, i);
                } else {
                    int i7 = i5 - (length - i4);
                    if (i7 >= i) {
                        System.arraycopy(bArr, i7 - i, this.zzl, 0, i);
                    } else {
                        int i8 = i - i7;
                        System.arraycopy(bArr, length - i8, this.zzl, 0, i8);
                        System.arraycopy(this.zzi, 0, this.zzl, i8, i7);
                    }
                }
            } else {
                int i9 = this.zzj;
                int i10 = i9 + i;
                byte[] bArr2 = this.zzi;
                int length2 = bArr2.length;
                if (i10 <= length2) {
                    System.arraycopy(bArr2, i9, this.zzl, 0, i);
                } else {
                    int i11 = length2 - i9;
                    System.arraycopy(bArr2, i9, this.zzl, 0, i11);
                    System.arraycopy(this.zzi, 0, this.zzl, i11, i - i11);
                }
            }
            zzdb.zze(i % this.zzd == 0, "sizeToOutput is not aligned to frame size: " + i);
            zzdb.zzf(this.zzj < this.zzi.length);
            byte[] bArr3 = this.zzl;
            String str = "byteOutput size is not aligned to frame size " + i;
            if (i % this.zzd != 0) {
                z = false;
            }
            zzdb.zze(z, str);
            if (i2 != 3) {
                for (int i12 = 0; i12 < i; i12 += 2) {
                    int i13 = i12 + 1;
                    int zzs = zzs(bArr3[i13], bArr3[i12]);
                    if (i2 == 0) {
                        i3 = ((((i12 * 1000) / (i - 1)) * -90) / 1000) + 100;
                    } else {
                        i3 = 10;
                        if (i2 == 2) {
                            i3 = 10 + (((90000 * i12) / (i - 1)) / 1000);
                        }
                    }
                    int i14 = (zzs * i3) / 100;
                    if (i14 >= 32767) {
                        bArr3[i12] = -1;
                        bArr3[i13] = Byte.MAX_VALUE;
                    } else if (i14 <= -32768) {
                        bArr3[i12] = 0;
                        bArr3[i13] = Byte.MIN_VALUE;
                    } else {
                        bArr3[i12] = (byte) (i14 & 255);
                        bArr3[i13] = (byte) (i14 >> 8);
                    }
                }
            }
            zzj(i).put(bArr3, 0, i).flip();
        }
    }

    private static final boolean zzv(byte b, byte b2) {
        return Math.abs(zzs(b, b2)) > 1024;
    }

    public final void zze(ByteBuffer byteBuffer) {
        int position;
        int limit;
        int i;
        while (byteBuffer.hasRemaining() && !zzn()) {
            boolean z = true;
            if (this.zzf != 0) {
                zzdb.zzf(this.zzj < this.zzi.length);
                int limit2 = byteBuffer.limit();
                int position2 = byteBuffer.position() + 1;
                while (true) {
                    if (position2 >= byteBuffer.limit()) {
                        limit = byteBuffer.limit();
                        break;
                    } else if (zzv(byteBuffer.get(position2), byteBuffer.get(position2 - 1))) {
                        int i2 = this.zzd;
                        limit = i2 * (position2 / i2);
                        break;
                    } else {
                        position2 += 2;
                    }
                }
                int position3 = limit - byteBuffer.position();
                int i3 = this.zzj;
                int i4 = this.zzk;
                int i5 = i3 + i4;
                int length = this.zzi.length;
                if (i5 < length) {
                    i = length - i5;
                } else {
                    i5 = i4 - (length - i3);
                    i = i3 - i5;
                }
                int min = Math.min(position3, i);
                byteBuffer.limit(byteBuffer.position() + min);
                byteBuffer.get(this.zzi, i5, min);
                int i6 = this.zzk + min;
                this.zzk = i6;
                zzdb.zzf(i6 <= this.zzi.length);
                if (limit >= limit2 || position3 >= i) {
                    z = false;
                }
                zzt(z);
                if (z) {
                    this.zzf = 0;
                    this.zzh = 0;
                }
                byteBuffer.limit(limit2);
            } else {
                int limit3 = byteBuffer.limit();
                byteBuffer.limit(Math.min(limit3, byteBuffer.position() + this.zzi.length));
                int limit4 = byteBuffer.limit() - 1;
                while (true) {
                    if (limit4 < byteBuffer.position()) {
                        position = byteBuffer.position();
                        break;
                    } else if (zzv(byteBuffer.get(limit4), byteBuffer.get(limit4 - 1))) {
                        int i7 = this.zzd;
                        position = ((limit4 / i7) * i7) + i7;
                        break;
                    } else {
                        limit4 -= 2;
                    }
                }
                if (position == byteBuffer.position()) {
                    this.zzf = 1;
                } else {
                    byteBuffer.limit(Math.min(position, byteBuffer.capacity()));
                    zzj(byteBuffer.remaining()).put(byteBuffer).flip();
                }
                byteBuffer.limit(limit3);
            }
        }
    }

    public final boolean zzg() {
        return super.zzg() && this.zze;
    }

    /* access modifiers changed from: protected */
    public final zzck zzi(zzck zzck) throws zzcl {
        if (zzck.zzd == 2) {
            return zzck.zzb == -1 ? zzck.zza : zzck;
        }
        throw new zzcl("Unhandled input format:", zzck);
    }

    public final void zzk() {
        if (zzg()) {
            int i = this.zzb.zzc;
            this.zzd = i + i;
            int i2 = this.zzd;
            int zzr = ((zzr(100000) / 2) / i2) * i2;
            int i3 = zzr + zzr;
            if (this.zzi.length != i3) {
                this.zzi = new byte[i3];
                this.zzl = new byte[i3];
            }
        }
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = 0;
        this.zzj = 0;
        this.zzk = 0;
    }

    public final void zzl() {
        if (this.zzk > 0) {
            zzt(true);
            this.zzh = 0;
        }
    }

    public final void zzm() {
        this.zze = false;
        this.zzi = zzen.zzf;
        this.zzl = zzen.zzf;
    }

    public final long zzo() {
        return this.zzg;
    }

    public final void zzp(boolean z) {
        this.zze = z;
    }
}
