package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzekz implements zzefb {
    private final zzbdi zza;
    private final zzges zzb;
    private final zzfjr zzc;
    /* access modifiers changed from: private */
    public final zzeli zzd;

    public zzekz(zzfjr zzfjr, zzges zzges, zzbdi zzbdi, zzeli zzeli) {
        this.zzc = zzfjr;
        this.zzb = zzges;
        this.zza = zzbdi;
        this.zzd = zzeli;
    }

    public final ListenableFuture zza(zzfff zzfff, zzfet zzfet) {
        zzcao zzcao = new zzcao();
        zzele zzele = new zzele();
        zzfet zzfet2 = zzfet;
        zzele.zzd(new zzeky(this, zzcao, zzfff, zzfet2, zzele));
        zzfey zzfey = zzfet2.zzs;
        zzbdd zzbdd = new zzbdd(zzele, zzfey.zzb, zzfey.zza);
        zzfjl zzfjl = zzfjl.CUSTOM_RENDER_SYN;
        return zzfjb.zzd(new zzekx(this, zzbdd), this.zzb, zzfjl, this.zzc).zzb(zzfjl.CUSTOM_RENDER_ACK).zzd(zzcao).zza();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.zzs;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzb(com.google.android.gms.internal.ads.zzfff r1, com.google.android.gms.internal.ads.zzfet r2) {
        /*
            r0 = this;
            com.google.android.gms.internal.ads.zzbdi r1 = r0.zza
            if (r1 == 0) goto L_0x000e
            com.google.android.gms.internal.ads.zzfey r1 = r2.zzs
            if (r1 == 0) goto L_0x000e
            java.lang.String r1 = r1.zza
            if (r1 == 0) goto L_0x000e
            r1 = 1
            return r1
        L_0x000e:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzekz.zzb(com.google.android.gms.internal.ads.zzfff, com.google.android.gms.internal.ads.zzfet):boolean");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzbdd zzbdd) throws Exception {
        this.zza.zze(zzbdd);
    }
}
