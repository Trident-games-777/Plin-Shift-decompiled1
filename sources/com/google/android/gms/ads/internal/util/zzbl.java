package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.util.client.zzl;
import com.google.android.gms.internal.ads.zzapl;
import com.google.android.gms.internal.ads.zzapp;
import com.google.android.gms.internal.ads.zzapv;
import com.google.android.gms.internal.ads.zzaqm;
import com.google.android.gms.internal.ads.zzcao;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbl extends zzapp {
    private final zzcao zza;
    private final zzl zzb;

    public zzbl(String str, Map map, zzcao zzcao) {
        super(0, str, new zzbk(zzcao));
        this.zza = zzcao;
        zzl zzl = new zzl((String) null);
        this.zzb = zzl;
        zzl.zzd(str, "GET", (Map) null, (byte[]) null);
    }

    /* access modifiers changed from: protected */
    public final zzapv zzh(zzapl zzapl) {
        return zzapv.zzb(zzapl, zzaqm.zzb(zzapl));
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void zzo(Object obj) {
        zzapl zzapl = (zzapl) obj;
        this.zzb.zzf(zzapl.zzc, zzapl.zza);
        byte[] bArr = zzapl.zzb;
        if (zzl.zzk() && bArr != null) {
            this.zzb.zzh(bArr);
        }
        this.zza.zzc(zzapl);
    }
}
