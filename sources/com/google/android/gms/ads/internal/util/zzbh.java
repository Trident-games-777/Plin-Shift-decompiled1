package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.internal.ads.zzapt;
import com.google.android.gms.internal.ads.zzapy;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbh implements zzapt {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbj zzb;

    zzbh(zzbn zzbn, String str, zzbj zzbj) {
        this.zza = str;
        this.zzb = zzbj;
    }

    public final void zza(zzapy zzapy) {
        String zzapy2 = zzapy.toString();
        zzm.zzj("Failed to load URL: " + this.zza + "\n" + zzapy2);
        this.zzb.zza((Object) null);
    }
}
