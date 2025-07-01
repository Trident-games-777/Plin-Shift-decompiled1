package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzekn implements zzefb {
    private final zzefd zza;
    private final zzefh zzb;
    private final zzfjr zzc;
    private final zzges zzd;

    public zzekn(zzfjr zzfjr, zzges zzges, zzefd zzefd, zzefh zzefh) {
        this.zzc = zzfjr;
        this.zzd = zzges;
        this.zzb = zzefh;
        this.zza = zzefd;
    }

    static final String zze(String str, int i) {
        return "Error from: " + str + ", code: " + i;
    }

    public final ListenableFuture zza(zzfff zzfff, zzfet zzfet) {
        zzefe zzefe;
        Iterator it = zzfet.zzt.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzefe = null;
                break;
            }
            try {
                zzefe = this.zza.zza((String) it.next(), zzfet.zzv);
                break;
            } catch (zzffv unused) {
            }
        }
        if (zzefe == null) {
            return zzgei.zzg(new zzeid("Unable to instantiate mediation adapter class."));
        }
        zzcao zzcao = new zzcao();
        zzefe.zzc.zza(new zzekm(this, zzefe, zzcao));
        if (zzfet.zzM) {
            Bundle bundle = zzfff.zza.zza.zzd.zzm;
            Bundle bundle2 = bundle.getBundle(AdMobAdapter.class.getName());
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(AdMobAdapter.class.getName(), bundle2);
            }
            bundle2.putBoolean("render_test_ad_label", true);
        }
        zzfjr zzfjr = this.zzc;
        return zzfjb.zzd(new zzekk(this, zzfff, zzfet, zzefe), this.zzd, zzfjl.ADAPTER_LOAD_AD_SYN, zzfjr).zzb(zzfjl.ADAPTER_LOAD_AD_ACK).zzd(zzcao).zzb(zzfjl.ADAPTER_WRAP_ADAPTER).zze(new zzekl(this, zzfff, zzfet, zzefe)).zza();
    }

    public final boolean zzb(zzfff zzfff, zzfet zzfet) {
        return !zzfet.zzt.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzc(zzfff zzfff, zzfet zzfet, zzefe zzefe, Void voidR) throws Exception {
        return this.zzb.zza(zzfff, zzfet, zzefe);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzfff zzfff, zzfet zzfet, zzefe zzefe) throws Exception {
        this.zzb.zzb(zzfff, zzfet, zzefe);
    }
}
