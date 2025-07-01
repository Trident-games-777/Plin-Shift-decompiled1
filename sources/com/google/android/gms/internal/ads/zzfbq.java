package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.internal.ads.zzbbs;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfbq implements zzfck {
    private final zzfck zza;
    private final zzfck zzb;
    private final zzfhy zzc;
    private final String zzd;
    private zzcvt zze;
    private final Executor zzf;

    public zzfbq(zzfck zzfck, zzfck zzfck2, zzfhy zzfhy, String str, Executor executor) {
        this.zza = zzfck;
        this.zzb = zzfck2;
        this.zzc = zzfhy;
        this.zzd = str;
        this.zzf = executor;
    }

    private final ListenableFuture zzg(zzfhl zzfhl, zzfcl zzfcl) {
        zzcvt zzcvt = zzfhl.zza;
        this.zze = zzcvt;
        if (zzfhl.zzc != null) {
            if (zzcvt.zzf() != null) {
                zzfhl.zzc.zzp().zzl(zzfhl.zza.zzf());
            }
            return zzgei.zzh(zzfhl.zzc);
        }
        zzcvt.zzb().zzl(zzfhl.zzb);
        zzfck zzfck = this.zza;
        zzcvt zzcvt2 = zzfhl.zza;
        zzcvt zzcvt3 = zzcvt2;
        return ((zzfca) zzfck).zzb(zzfcl, (zzfcj) null, zzcvt2);
    }

    /* renamed from: zza */
    public final synchronized zzcvt zzd() {
        return this.zze;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzb(zzfcl zzfcl, zzfbp zzfbp, zzfcj zzfcj, zzcvt zzcvt, zzfbv zzfbv) throws Exception {
        if (zzfbv != null) {
            zzfbp zzfbp2 = new zzfbp(zzfbp.zza, zzfbp.zzb, zzfbp.zzc, zzfbp.zzd, zzfbp.zze, zzfbp.zzf, zzfbv.zza);
            if (zzfbv.zzc != null) {
                this.zze = null;
                this.zzc.zze(zzfbp2);
                return zzg(zzfbv.zzc, zzfcl);
            }
            ListenableFuture zza2 = this.zzc.zza(zzfbp2);
            if (zza2 != null) {
                this.zze = null;
                return zzgei.zzn(zza2, new zzfbm(this), this.zzf);
            }
            this.zzc.zze(zzfbp2);
            zzfcl = new zzfcl(zzfcl.zzb, zzfbv.zzb);
        }
        zzcvt zzcvt2 = zzcvt;
        ListenableFuture zzb2 = ((zzfca) this.zza).zzb(zzfcl, zzfcj, zzcvt);
        this.zze = zzcvt;
        return zzb2;
    }

    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzfcl zzfcl, zzfcj zzfcj, Object obj) {
        zzcvt zzcvt = null;
        return zzf(zzfcl, zzfcj, (zzcvt) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zze(zzfhv zzfhv) throws Exception {
        zzfhx zzfhx;
        if (zzfhv == null || zzfhv.zza == null || (zzfhx = zzfhv.zzb) == null) {
            throw new zzdwn(1, "Empty prefetch");
        }
        zzbbs.zzb.zzc zzd2 = zzbbs.zzb.zzd();
        zzbbs.zzb.zza.C0003zza zza2 = zzbbs.zzb.zza.zza();
        zza2.zzf(zzbbs.zzb.zzd.IN_MEMORY);
        zza2.zzh(zzbbs.zzb.zze.zzi());
        zzd2.zzd(zza2);
        zzfhv.zza.zza.zzb().zzc().zzm((zzbbs.zzb) zzd2.zzbr());
        return zzg(zzfhv.zza, ((zzfbp) zzfhx).zzb);
    }

    public final synchronized ListenableFuture zzf(zzfcl zzfcl, zzfcj zzfcj, zzcvt zzcvt) {
        zzcvs zza2 = zzfcj.zza(zzfcl.zzb);
        zza2.zza(new zzfbr(this.zzd));
        zzcvt zzcvt2 = (zzcvt) zza2.zzh();
        zzcvt2.zzg();
        zzcvt2.zzg();
        zzm zzm = zzcvt2.zzg().zzd;
        if (zzm.zzs == null) {
            if (zzm.zzx == null) {
                zzffo zzg = zzcvt2.zzg();
                zzm zzm2 = zzg.zzd;
                String str = zzg.zzf;
                zzy zzy = zzg.zzj;
                zzfcj zzfcj2 = zzfcj;
                zzfbp zzfbp = new zzfbp(zzfcj2, zzfcl, zzm2, str, this.zzf, zzy, (zzfhm) null);
                zzcvt zzcvt3 = zzcvt2;
                return (zzgdz) zzgei.zzn(zzgdz.zzu(((zzfbw) this.zzb).zzb(zzfcl, zzfcj, zzcvt2)), new zzfbn(this, zzfcl, zzfbp, zzfcj, zzcvt2), this.zzf);
            }
        }
        zzcvt zzcvt4 = zzcvt2;
        this.zze = zzcvt4;
        zzcvt zzcvt5 = zzcvt4;
        return ((zzfca) this.zza).zzb(zzfcl, zzfcj, zzcvt4);
    }
}
