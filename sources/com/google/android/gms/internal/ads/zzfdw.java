package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzdr;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfdw implements OnAdMetadataChangedListener, zzcya, zzcwp, zzcwm, zzcxc, zzcyx, zzfch, zzdel {
    private final zzfgy zza;
    private final AtomicReference zzb = new AtomicReference();
    private final AtomicReference zzc = new AtomicReference();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final AtomicReference zzf = new AtomicReference();
    private final AtomicReference zzg = new AtomicReference();
    private final AtomicReference zzh = new AtomicReference();
    private zzfdw zzi = null;

    public zzfdw(zzfgy zzfgy) {
        this.zza = zzfgy;
    }

    public final void onAdMetadataChanged() {
        zzfdw zzfdw = this.zzi;
        if (zzfdw != null) {
            zzfdw.onAdMetadataChanged();
        } else {
            zzfby.zza(this.zzb, new zzfdk());
        }
    }

    public final void zza() {
        zzfdw zzfdw = this.zzi;
        if (zzfdw != null) {
            zzfdw.zza();
            return;
        }
        this.zza.zza();
        zzfby.zza(this.zzd, new zzfds());
        zzfby.zza(this.zze, new zzfdt());
    }

    public final void zzdG() {
        zzfdw zzfdw = this.zzi;
        if (zzfdw != null) {
            zzfdw.zzdG();
        } else {
            zzfby.zza(this.zzd, new zzfdl());
        }
    }

    public final void zzdf() {
    }

    public final void zzg(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzb.set(onAdMetadataChangedListener);
    }

    public final void zzh(zzu zzu) {
        zzfdw zzfdw = this.zzi;
        if (zzfdw != null) {
            zzfdw.zzh(zzu);
        } else {
            zzfby.zza(this.zzh, new zzfdh(zzu));
        }
    }

    public final void zzi(zzdr zzdr) {
        this.zzh.set(zzdr);
    }

    public final void zzj(zzbxf zzbxf) {
        this.zzd.set(zzbxf);
    }

    public final void zzk(zzbxj zzbxj) {
        this.zzc.set(zzbxj);
    }

    public final void zzl(zzfch zzfch) {
        this.zzi = (zzfdw) zzfch;
    }

    @Deprecated
    public final void zzm(zzbwp zzbwp) {
        this.zze.set(zzbwp);
    }

    @Deprecated
    public final void zzn(zzbwk zzbwk) {
        this.zzg.set(zzbwk);
    }

    public final void zzo(zzbxk zzbxk) {
        this.zzf.set(zzbxk);
    }

    public final void zzq(zze zze2) {
        zzfdw zzfdw = this.zzi;
        if (zzfdw != null) {
            zzfdw.zzq(zze2);
            return;
        }
        zzfby.zza(this.zzd, new zzfdm(zze2));
        zzfby.zza(this.zzd, new zzfdn(zze2));
    }

    public final void zzb() {
        zzfdw zzfdw = this.zzi;
        if (zzfdw != null) {
            zzfdw.zzb();
        } else {
            zzfby.zza(this.zze, new zzfdu());
        }
    }

    public final void zze() {
        zzfdw zzfdw = this.zzi;
        if (zzfdw != null) {
            zzfdw.zze();
        } else {
            zzfby.zza(this.zze, new zzfdo());
        }
    }

    public final void zzf() {
        zzfdw zzfdw = this.zzi;
        if (zzfdw != null) {
            zzfdw.zzf();
        } else {
            zzfby.zza(this.zze, new zzfda());
        }
    }

    public final void zzs() {
        zzfdw zzfdw = this.zzi;
        if (zzfdw != null) {
            zzfdw.zzs();
            return;
        }
        zzfby.zza(this.zzc, new zzfdi());
        zzfby.zza(this.zze, new zzfdj());
    }

    public final void zzc() {
        zzfdw zzfdw = this.zzi;
        if (zzfdw != null) {
            zzfdw.zzc();
            return;
        }
        zzfby.zza(this.zzd, new zzfde());
        zzfby.zza(this.zze, new zzfdf());
        zzfby.zza(this.zzd, new zzfdg());
    }

    public final void zzdB(zze zze2) {
        zzfdw zzfdw = this.zzi;
        if (zzfdw != null) {
            zzfdw.zzdB(zze2);
            return;
        }
        int i = zze2.zza;
        zzfby.zza(this.zzc, new zzfdp(zze2));
        zzfby.zza(this.zzc, new zzfdq(i));
        zzfby.zza(this.zze, new zzfdr(i));
    }

    public final void zzds(zzbwj zzbwj, String str, String str2) {
        zzfdw zzfdw = this.zzi;
        if (zzfdw != null) {
            zzfdw.zzds(zzbwj, str, str2);
            return;
        }
        zzfby.zza(this.zzd, new zzfdv(zzbwj));
        zzfby.zza(this.zzf, new zzfdb(zzbwj, str, str2));
        zzfby.zza(this.zze, new zzfdc(zzbwj));
        zzfby.zza(this.zzg, new zzfdd(zzbwj, str, str2));
    }
}
