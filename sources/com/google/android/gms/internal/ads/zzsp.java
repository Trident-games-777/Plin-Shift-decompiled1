package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public class zzsp extends zzhk {
    public final String zza;
    public final int zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzsp(Throwable th, zzsq zzsq) {
        super("Decoder failed: ".concat(String.valueOf(zzsq == null ? null : zzsq.zza)), th);
        int i;
        String str = null;
        boolean z = th instanceof MediaCodec.CodecException;
        str = z ? ((MediaCodec.CodecException) th).getDiagnosticInfo() : str;
        this.zza = str;
        if (zzen.zza >= 23) {
            i = z ? ((MediaCodec.CodecException) th).getErrorCode() : 0;
        } else {
            i = zzen.zzm(str);
        }
        this.zzb = i;
    }
}
