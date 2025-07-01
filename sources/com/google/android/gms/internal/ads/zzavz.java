package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzavz implements zzfro {
    private final zzfpr zza;
    private final zzfqi zzb;
    private final zzawm zzc;
    private final zzavy zzd;
    private final zzavi zze;
    private final zzawo zzf;
    private final zzawg zzg;
    private final zzavx zzh;

    zzavz(zzfpr zzfpr, zzfqi zzfqi, zzawm zzawm, zzavy zzavy, zzavi zzavi, zzawo zzawo, zzawg zzawg, zzavx zzavx) {
        this.zza = zzfpr;
        this.zzb = zzfqi;
        this.zzc = zzawm;
        this.zzd = zzavy;
        this.zze = zzavi;
        this.zzf = zzawo;
        this.zzg = zzawg;
        this.zzh = zzavx;
    }

    private final Map zze() {
        HashMap hashMap = new HashMap();
        zzfpr zzfpr = this.zza;
        zzata zzb2 = this.zzb.zzb();
        hashMap.put("v", zzfpr.zzd());
        hashMap.put("gms", Boolean.valueOf(this.zza.zzg()));
        hashMap.put("int", zzb2.zzh());
        hashMap.put("attts", Long.valueOf(zzb2.zzf().zza()));
        hashMap.put("att", zzb2.zzf().zzd());
        hashMap.put("attkid", zzb2.zzf().zzf());
        hashMap.put("up", Boolean.valueOf(this.zzd.zza()));
        hashMap.put("t", new Throwable());
        zzawg zzawg = this.zzg;
        if (zzawg != null) {
            hashMap.put("tcq", Long.valueOf(zzawg.zzc()));
            hashMap.put("tpq", Long.valueOf(this.zzg.zzg()));
            hashMap.put("tcv", Long.valueOf(this.zzg.zzd()));
            hashMap.put("tpv", Long.valueOf(this.zzg.zzh()));
            hashMap.put("tchv", Long.valueOf(this.zzg.zzb()));
            hashMap.put("tphv", Long.valueOf(this.zzg.zzf()));
            hashMap.put("tcc", Long.valueOf(this.zzg.zza()));
            hashMap.put("tpc", Long.valueOf(this.zzg.zze()));
        }
        return hashMap;
    }

    public final Map zza() {
        zzawm zzawm = this.zzc;
        Map zze2 = zze();
        zze2.put("lts", Long.valueOf(zzawm.zza()));
        return zze2;
    }

    public final Map zzb() {
        Map zze2 = zze();
        zzata zza2 = this.zzb.zza();
        zze2.put("gai", Boolean.valueOf(this.zza.zzh()));
        zze2.put("did", zza2.zzg());
        zze2.put("dst", Integer.valueOf(zza2.zzal() - 1));
        zze2.put("doo", Boolean.valueOf(zza2.zzai()));
        zzavi zzavi = this.zze;
        if (zzavi != null) {
            zze2.put("nt", Long.valueOf(zzavi.zza()));
        }
        zzawo zzawo = this.zzf;
        if (zzawo != null) {
            zze2.put("vs", Long.valueOf(zzawo.zzc()));
            zze2.put("vf", Long.valueOf(this.zzf.zzb()));
        }
        return zze2;
    }

    public final Map zzc() {
        zzavx zzavx = this.zzh;
        Map zze2 = zze();
        if (zzavx != null) {
            zze2.put("vst", zzavx.zza());
        }
        return zze2;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(View view) {
        this.zzc.zzd(view);
    }
}
