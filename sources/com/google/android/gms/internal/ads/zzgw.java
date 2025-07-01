package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgw extends zzgu {
    public final int zzc;

    public zzgw(int i, String str, IOException iOException, Map map, zzgi zzgi, byte[] bArr) {
        super("Response code: " + i, iOException, zzgi, 2004, 1);
        this.zzc = i;
    }
}
