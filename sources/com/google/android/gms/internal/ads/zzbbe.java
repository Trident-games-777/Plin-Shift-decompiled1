package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbbe extends PushbackInputStream {
    final /* synthetic */ zzbbf zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbbe(zzbbf zzbbf, InputStream inputStream, int i) {
        super(inputStream, 1);
        this.zza = zzbbf;
    }

    public final synchronized void close() throws IOException {
        zzbbh.zze(this.zza.zzc);
        super.close();
    }
}
