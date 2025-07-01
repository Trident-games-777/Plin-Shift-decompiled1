package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgfo {
    private final OutputStream zza;

    private zzgfo(OutputStream outputStream) {
        this.zza = outputStream;
    }

    public static zzgfo zzb(OutputStream outputStream) {
        return new zzgfo(outputStream);
    }

    public final void zza(zzgum zzgum) throws IOException {
        try {
            zzgum.zzaU(this.zza);
        } finally {
            this.zza.close();
        }
    }
}
