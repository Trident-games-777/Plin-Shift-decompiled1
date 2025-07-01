package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public class zzhff extends zzhfi implements zzarc {
    protected final String zza = "moov";

    public zzhff(String str) {
    }

    public final String zza() {
        return this.zza;
    }

    public final void zzb(zzhfj zzhfj, ByteBuffer byteBuffer, long j, zzaqz zzaqz) throws IOException {
        zzhfj.zzb();
        byteBuffer.remaining();
        byteBuffer.remaining();
        this.zzc = zzhfj;
        this.zze = zzhfj.zzb();
        zzhfj.zze(zzhfj.zzb() + j);
        this.zzf = zzhfj.zzb();
        this.zzb = zzaqz;
    }
}
