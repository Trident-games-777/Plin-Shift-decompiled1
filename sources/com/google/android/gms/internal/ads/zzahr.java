package com.google.android.gms.internal.ads;

import java.io.IOException;
import okhttp3.internal.ws.RealWebSocket;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzahr {
    private final zzed zza = new zzed(8);
    private int zzb;

    private final long zzb(zzacs zzacs) throws IOException {
        int i;
        zzacg zzacg = (zzacg) zzacs;
        int i2 = 0;
        zzacg.zzm(this.zza.zzN(), 0, 1, false);
        byte b = this.zza.zzN()[0] & 255;
        if (b == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while (true) {
            i = i4 + 1;
            if ((b & i3) != 0) {
                break;
            }
            i3 >>= 1;
            i4 = i;
        }
        int i5 = b & (~i3);
        zzacg.zzm(this.zza.zzN(), 1, i4, false);
        while (i2 < i4) {
            i2++;
            i5 = (this.zza.zzN()[i2] & 255) + (i5 << 8);
        }
        this.zzb += i;
        return (long) i5;
    }

    public final boolean zza(zzacs zzacs) throws IOException {
        long zzb2;
        int i;
        long zzd = zzacs.zzd();
        int i2 = (zzd > -1 ? 1 : (zzd == -1 ? 0 : -1));
        long j = RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
        if (i2 != 0 && zzd <= RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) {
            j = zzd;
        }
        zzacg zzacg = (zzacg) zzacs;
        zzacg.zzm(this.zza.zzN(), 0, 4, false);
        long zzu = this.zza.zzu();
        this.zzb = 4;
        while (zzu != 440786851) {
            int i3 = (int) j;
            int i4 = this.zzb + 1;
            this.zzb = i4;
            if (i4 == i3) {
                return false;
            }
            zzacg.zzm(this.zza.zzN(), 0, 1, false);
            zzu = ((zzu << 8) & -256) | ((long) (this.zza.zzN()[0] & 255));
        }
        long zzb3 = zzb(zzacs);
        long j2 = (long) this.zzb;
        if (zzb3 != Long.MIN_VALUE) {
            long j3 = j2 + zzb3;
            if (i2 == 0 || j3 < zzd) {
                while (true) {
                    int i5 = (((long) this.zzb) > j3 ? 1 : (((long) this.zzb) == j3 ? 0 : -1));
                    if (i5 < 0) {
                        if (zzb(zzacs) == Long.MIN_VALUE || zzb2 < 0) {
                            return false;
                        }
                        if (i != 0) {
                            int zzb4 = (int) (zzb2 = zzb(zzacs));
                            zzacg.zzl(zzb4, false);
                            this.zzb += zzb4;
                        }
                    } else if (i5 == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
