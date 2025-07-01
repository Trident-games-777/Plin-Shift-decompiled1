package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzv;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzbin implements zzfwh {
    public final /* synthetic */ String zza;

    public /* synthetic */ zzbin(String str) {
        this.zza = str;
    }

    public final Object apply(Object obj) {
        Throwable th = (Throwable) obj;
        zzbjr zzbjr = zzbjq.zza;
        if (((Boolean) zzbem.zzi.zze()).booleanValue()) {
            zzv.zzp().zzw(th, "prepareClickUrl.attestation2");
        }
        return this.zza;
    }
}
