package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzvp implements zzwg {
    final /* synthetic */ zzvs zza;
    /* access modifiers changed from: private */
    public final int zzb;

    public zzvp(zzvs zzvs, int i) {
        this.zza = zzvs;
        this.zzb = i;
    }

    public final int zza(zzkj zzkj, zzhm zzhm, int i) {
        return this.zza.zzg(this.zzb, zzkj, zzhm, i);
    }

    public final int zzb(long j) {
        return this.zza.zzi(this.zzb, j);
    }

    public final void zzd() throws IOException {
        this.zza.zzI(this.zzb);
    }

    public final boolean zze() {
        return this.zza.zzP(this.zzb);
    }
}
