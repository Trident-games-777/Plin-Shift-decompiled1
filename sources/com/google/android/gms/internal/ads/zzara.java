package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzara extends zzhfi implements Closeable {
    static {
        zzhfp.zzb(zzara.class);
    }

    public zzara(zzhfj zzhfj, zzaqz zzaqz) throws IOException {
        zze(zzhfj, zzhfj.zzc(), zzaqz);
    }

    public final void close() throws IOException {
    }

    public final String toString() {
        String obj = this.zzc.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 7);
        sb.append("model(");
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
