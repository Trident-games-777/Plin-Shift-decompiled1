package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzdr;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.overlay.zzr;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfar implements zzcwp, zzcyl, zzfch, zzr, zzcyx, zzcxc, zzdel {
    private final zzfgy zza;
    private final AtomicReference zzb = new AtomicReference();
    private final AtomicReference zzc = new AtomicReference();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final AtomicReference zzf = new AtomicReference();
    private final AtomicReference zzg = new AtomicReference();
    private zzfar zzh = null;

    public zzfar(zzfgy zzfgy) {
        this.zza = zzfgy;
    }

    public static zzfar zzi(zzfar zzfar) {
        zzfar zzfar2 = new zzfar(zzfar.zza);
        zzfar zzfar3 = zzfar;
        zzfar2.zzh = zzfar;
        return zzfar2;
    }

    public final void zzdG() {
        zzfar zzfar = this.zzh;
        if (zzfar != null) {
            zzfar.zzdG();
        } else {
            zzfby.zza(this.zzd, new zzfai());
        }
    }

    public final void zzdH() {
    }

    public final void zzdf() {
    }

    public final void zzdk() {
    }

    public final void zzdq() {
        zzfar zzfar = this.zzh;
        if (zzfar != null) {
            zzfar.zzdq();
        } else {
            zzfby.zza(this.zzf, new zzfaf());
        }
    }

    public final void zzdr() {
        zzfar zzfar = this.zzh;
        if (zzfar != null) {
            zzfar.zzdr();
            return;
        }
        zzfby.zza(this.zzf, new zzfaq());
        zzfby.zza(this.zzd, new zzfad());
        zzfby.zza(this.zzd, new zzfae());
    }

    public final void zzdt() {
        zzfar zzfar = this.zzh;
        if (zzfar != null) {
            zzfar.zzdt();
        } else {
            zzfby.zza(this.zzf, new zzfap());
        }
    }

    public final void zzdu(int i) {
        zzfar zzfar = this.zzh;
        if (zzfar != null) {
            zzfar.zzdu(i);
        } else {
            zzfby.zza(this.zzf, new zzfal(i));
        }
    }

    public final void zzg() {
        zzfar zzfar = this.zzh;
        if (zzfar != null) {
            zzfar.zzg();
        } else {
            zzfby.zza(this.zze, new zzfao());
        }
    }

    public final void zzh(zzu zzu) {
        zzfar zzfar = this.zzh;
        if (zzfar != null) {
            zzfar.zzh(zzu);
        } else {
            zzfby.zza(this.zzg, new zzfac(zzu));
        }
    }

    public final void zzj() {
        zzfar zzfar = this.zzh;
        if (zzfar != null) {
            zzfar.zzj();
            return;
        }
        this.zza.zza();
        zzfby.zza(this.zzc, new zzfaj());
        zzfby.zza(this.zzd, new zzfak());
    }

    public final void zzl(zzfch zzfch) {
        this.zzh = (zzfar) zzfch;
    }

    public final void zzm(zzr zzr) {
        this.zzf.set(zzr);
    }

    public final void zzn(zzdr zzdr) {
        this.zzg.set(zzdr);
    }

    public final void zzo(zzbai zzbai) {
        this.zzb.set(zzbai);
    }

    public final void zzp(zzbam zzbam) {
        this.zzd.set(zzbam);
    }

    public final void zzq(zze zze2) {
        zzfar zzfar = this.zzh;
        if (zzfar != null) {
            zzfar.zzq(zze2);
        } else {
            zzfby.zza(this.zzd, new zzfag(zze2));
        }
    }

    public final void zzk(zzbaf zzbaf) {
        zzfar zzfar = this.zzh;
        if (zzfar != null) {
            zzfar.zzk(zzbaf);
        } else {
            zzfby.zza(this.zzb, new zzfah(zzbaf));
        }
    }

    public final void zzdB(zze zze2) {
        zzfar zzfar = this.zzh;
        if (zzfar != null) {
            zzfar.zzdB(zze2);
            return;
        }
        zzfby.zza(this.zzb, new zzfam(zze2));
        zzfby.zza(this.zzb, new zzfan(zze2));
    }
}
