package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzzs implements zzfxg {
    public final Object zza() {
        int i = zzzt.zza;
        try {
            Class<?> cls = Class.forName("androidx.media3.effect.DefaultVideoFrameProcessor$Factory$Builder");
            Object invoke = cls.getMethod("build", new Class[0]).invoke(cls.getConstructor(new Class[0]).newInstance(new Object[0]), new Object[0]);
            if (invoke != null) {
                return (zzcf) invoke;
            }
            throw null;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
