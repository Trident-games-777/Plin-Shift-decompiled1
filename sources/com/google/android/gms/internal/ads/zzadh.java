package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzadh {
    private final zzed zza = new zzed(10);

    public final zzbd zza(zzacs zzacs, zzagi zzagi) throws IOException {
        zzbd zzbd = null;
        int i = 0;
        while (true) {
            try {
                zzacs.zzh(this.zza.zzN(), 0, 10);
                this.zza.zzL(0);
                if (this.zza.zzo() != 4801587) {
                    break;
                }
                this.zza.zzM(3);
                int zzl = this.zza.zzl();
                int i2 = zzl + 10;
                if (zzbd == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.zza.zzN(), 0, bArr, 0, 10);
                    zzacs.zzh(bArr, 10, zzl);
                    zzbd = zzagk.zza(bArr, i2, zzagi, new zzafm());
                } else {
                    zzacs.zzg(zzl);
                }
                i += i2;
            } catch (EOFException unused) {
            }
        }
        zzacs.zzj();
        zzacs.zzg(i);
        return zzbd;
    }
}
