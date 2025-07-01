package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeuj implements zzevz {
    private static String zza;
    private final zzges zzb;
    private final Context zzc;
    private final Set zzd;

    public zzeuj(zzges zzges, Context context, Set set) {
        this.zzb = zzges;
        this.zzc = context;
        this.zzd = set;
    }

    public final int zza() {
        return 27;
    }

    public final ListenableFuture zzb() {
        return this.zzb.zzb(new zzeui(this));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0044, code lost:
        if (r0.contains("banner") == false) goto L_0x0080;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.ads.zzeuk zzc() throws java.lang.Exception {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzfb
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0080
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzfm
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0046
            java.util.Set r0 = r3.zzd
            java.lang.String r1 = "rewarded"
            boolean r1 = r0.contains(r1)
            if (r1 != 0) goto L_0x0046
            java.lang.String r1 = "interstitial"
            boolean r1 = r0.contains(r1)
            if (r1 != 0) goto L_0x0046
            java.lang.String r1 = "native"
            boolean r1 = r0.contains(r1)
            if (r1 != 0) goto L_0x0046
            java.lang.String r1 = "banner"
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0080
        L_0x0046:
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzfn
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0070
            java.lang.String r0 = zza
            if (r0 != 0) goto L_0x0068
            android.content.Context r0 = r3.zzc
            com.google.android.gms.internal.ads.zzeer r1 = com.google.android.gms.ads.internal.zzv.zzB()
            java.lang.String r0 = r1.zzf(r0)
            zza = r0
        L_0x0068:
            com.google.android.gms.internal.ads.zzeuk r0 = new com.google.android.gms.internal.ads.zzeuk
            java.lang.String r1 = zza
            r0.<init>(r1)
            return r0
        L_0x0070:
            android.content.Context r0 = r3.zzc
            com.google.android.gms.internal.ads.zzeuk r1 = new com.google.android.gms.internal.ads.zzeuk
            com.google.android.gms.internal.ads.zzeer r2 = com.google.android.gms.ads.internal.zzv.zzB()
            java.lang.String r0 = r2.zzf(r0)
            r1.<init>(r0)
            return r1
        L_0x0080:
            com.google.android.gms.internal.ads.zzeuk r0 = new com.google.android.gms.internal.ads.zzeuk
            r1 = 0
            r0.<init>(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeuj.zzc():com.google.android.gms.internal.ads.zzeuk");
    }
}
