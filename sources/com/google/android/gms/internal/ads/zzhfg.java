package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzhfg extends zzhfe implements zzarc {
    private int zzg;

    protected zzhfg(String str) {
        super("mvhd");
    }

    public final int zzg() {
        if (!this.zzb) {
            zzf();
        }
        return this.zzg;
    }

    /* access modifiers changed from: protected */
    public final long zzh(ByteBuffer byteBuffer) {
        this.zzg = zzarb.zzc(byteBuffer.get());
        zzarb.zzd(byteBuffer);
        byteBuffer.get();
        return 4;
    }
}
