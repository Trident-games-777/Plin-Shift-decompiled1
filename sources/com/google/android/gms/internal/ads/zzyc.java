package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzyc {
    public final zzbw zza;
    public final int[] zzb;

    public zzyc(zzbw zzbw, int[] iArr, int i) {
        if (iArr.length == 0) {
            zzdt.zzd("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
        }
        this.zza = zzbw;
        this.zzb = iArr;
    }
}
