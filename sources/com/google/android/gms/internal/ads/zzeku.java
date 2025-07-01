package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeku implements zzefb {
    private final Context zza;
    private final zzcqh zzb;
    private final zzbdi zzc;
    private final zzges zzd;
    private final zzfjr zze;

    public zzeku(Context context, zzcqh zzcqh, zzfjr zzfjr, zzges zzges, zzbdi zzbdi) {
        this.zza = context;
        this.zzb = zzcqh;
        this.zze = zzfjr;
        this.zzd = zzges;
        this.zzc = zzbdi;
    }

    public final ListenableFuture zza(zzfff zzfff, zzfet zzfet) {
        zzeks zzeks = new zzeks(this, new View(this.zza), (zzcfk) null, new zzekq(), (zzfeu) zzfet.zzu.get(0));
        zzcpe zza2 = this.zzb.zza(new zzcsg(zzfff, zzfet, (String) null), zzeks);
        zzekt zzl = zza2.zzl();
        zzfey zzfey = zzfet.zzs;
        zzbdd zzbdd = new zzbdd(zzl, zzfey.zzb, zzfey.zza);
        zzfjl zzfjl = zzfjl.CUSTOM_RENDER_SYN;
        return zzfjb.zzd(new zzekr(this, zzbdd), this.zzd, zzfjl, this.zze).zzb(zzfjl.CUSTOM_RENDER_ACK).zzd(zzgei.zzh(zza2.zza())).zza();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.zzs;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzb(com.google.android.gms.internal.ads.zzfff r1, com.google.android.gms.internal.ads.zzfet r2) {
        /*
            r0 = this;
            com.google.android.gms.internal.ads.zzbdi r1 = r0.zzc
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeku.zzb(com.google.android.gms.internal.ads.zzfff, com.google.android.gms.internal.ads.zzfet):boolean");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzbdd zzbdd) throws Exception {
        this.zzc.zze(zzbdd);
    }
}
