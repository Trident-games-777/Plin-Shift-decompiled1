package com.google.android.gms.internal.ads;

import androidx.core.view.PointerIconCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public class zzgu extends zzge {
    public final int zzb;

    public zzgu(zzgi zzgi, int i, int i2) {
        super(zzb(2008, 1));
        this.zzb = 1;
    }

    public static zzgu zza(IOException iOException, zzgi zzgi, int i) {
        int i2;
        String message = iOException.getMessage();
        if (iOException instanceof SocketTimeoutException) {
            i2 = 2002;
        } else if (iOException instanceof InterruptedIOException) {
            i2 = PointerIconCompat.TYPE_WAIT;
        } else {
            i2 = (message == null || !zzfwa.zza(message).matches("cleartext.*not permitted.*")) ? 2001 : 2007;
        }
        if (i2 == 2007) {
            return new zzgt(iOException, zzgi);
        }
        return new zzgu(iOException, zzgi, i2, i);
    }

    private static int zzb(int i, int i2) {
        return i == 2000 ? i2 != 1 ? 2000 : 2001 : i;
    }

    public zzgu(IOException iOException, zzgi zzgi, int i, int i2) {
        super((Throwable) iOException, zzb(i, i2));
        this.zzb = i2;
    }

    public zzgu(String str, zzgi zzgi, int i, int i2) {
        super(str, zzb(i, i2));
        this.zzb = i2;
    }

    public zzgu(String str, IOException iOException, zzgi zzgi, int i, int i2) {
        super(str, iOException, zzb(i, i2));
        this.zzb = i2;
    }
}
