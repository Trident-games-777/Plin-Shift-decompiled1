package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgoa {
    public static final zzgwu zza = zzgwu.zzb(new byte[0]);

    public static final zzgwu zza(int i) {
        return zzgwu.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(i).array());
    }

    public static final zzgwu zzb(int i) {
        return zzgwu.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(i).array());
    }
}
