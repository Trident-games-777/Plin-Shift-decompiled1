package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzr;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbrw implements zzr {
    final /* synthetic */ zzbry zza;

    zzbrw(zzbry zzbry) {
        this.zza = zzbry;
    }

    public final void zzdH() {
        zzm.zze("AdMobCustomTabsAdapter overlay is resumed.");
    }

    public final void zzdk() {
        zzm.zze("AdMobCustomTabsAdapter overlay is paused.");
    }

    public final void zzdq() {
        zzm.zze("Delay close AdMobCustomTabsAdapter overlay.");
    }

    public final void zzdr() {
        zzm.zze("Opening AdMobCustomTabsAdapter overlay.");
        zzbry zzbry = this.zza;
        zzbry.zzb.onAdOpened(zzbry);
    }

    public final void zzdt() {
    }

    public final void zzdu(int i) {
        zzm.zze("AdMobCustomTabsAdapter overlay is closed.");
        zzbry zzbry = this.zza;
        zzbry.zzb.onAdClosed(zzbry);
    }
}
