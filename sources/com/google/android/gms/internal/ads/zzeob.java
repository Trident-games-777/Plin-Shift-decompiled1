package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.nonagon.signalgeneration.zzv;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeob implements zzevz {
    private final zzges zza;
    private final zzffo zzb;

    zzeob(zzges zzges, zzffo zzffo, zzfgd zzfgd) {
        this.zza = zzges;
        this.zzb = zzffo;
    }

    public final int zza() {
        return 5;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzeoa(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzeoc zzc() throws Exception {
        String str = null;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzgT)).booleanValue() && "requester_type_2".equals(zzv.zzc(this.zzb.zzd))) {
            str = zzfgd.zza();
        }
        return new zzeoc(str);
    }
}
