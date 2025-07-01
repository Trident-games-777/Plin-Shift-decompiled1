package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzzu implements zzbq {
    private final zzcf zza;

    public zzzu(zzcf zzcf) {
        this.zza = zzcf;
    }

    public final zzbr zza(Context context, zzm zzm, zzp zzp, zzch zzch, Executor executor, List list, long j) throws zzce {
        zzce zzce;
        try {
            return ((zzbq) Class.forName("androidx.media3.effect.PreviewingSingleInputVideoGraph$Factory").getConstructor(new Class[]{zzcf.class}).newInstance(new Object[]{this.zza})).zza(context, zzm, zzp, zzch, executor, list, 0);
        } catch (Exception e) {
            Exception exc = e;
            if (exc instanceof zzce) {
                zzce = (zzce) exc;
            } else {
                zzce = new zzce(exc, -9223372036854775807L);
            }
            throw zzce;
        }
    }
}
