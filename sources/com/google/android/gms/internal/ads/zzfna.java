package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfna extends zzfmw {
    private final zzfmy zza;
    private final zzfnv zzb = new zzfnv();
    private zzfpi zzc;
    private zzfoh zzd;
    private boolean zze = false;
    private boolean zzf = false;
    private final String zzg;

    zzfna(zzfmx zzfmx, zzfmy zzfmy, String str) {
        this.zza = zzfmy;
        this.zzg = str;
        zzk((View) null);
        if (zzfmy.zzd() == zzfmz.HTML || zzfmy.zzd() == zzfmz.JAVASCRIPT) {
            this.zzd = new zzfoi(str, zzfmy.zza());
        } else {
            this.zzd = new zzfol(str, zzfmy.zzi(), (String) null);
        }
        this.zzd.zzo();
        zzfnr.zza().zzd(this);
        this.zzd.zzf(zzfmx);
    }

    private final void zzk(View view) {
        this.zzc = new zzfpi(view);
    }

    public final void zzb(View view, zzfnd zzfnd, String str) {
        if (!this.zzf) {
            this.zzb.zzb(view, zzfnd, "Ad overlay");
        }
    }

    public final void zzc() {
        if (!this.zzf) {
            this.zzc.clear();
            if (!this.zzf) {
                this.zzb.zzc();
            }
            this.zzf = true;
            this.zzd.zze();
            zzfnr.zza().zze(this);
            this.zzd.zzc();
            this.zzd = null;
        }
    }

    public final void zzd(View view) {
        if (!this.zzf && zzf() != view) {
            zzk(view);
            this.zzd.zzb();
            Collection<zzfna> zzc2 = zzfnr.zza().zzc();
            if (zzc2 != null && !zzc2.isEmpty()) {
                for (zzfna zzfna : zzc2) {
                    if (zzfna != this && zzfna.zzf() == view) {
                        zzfna.zzc.clear();
                    }
                }
            }
        }
    }

    public final void zze() {
        if (!this.zze) {
            this.zze = true;
            zzfnr.zza().zzf(this);
            this.zzd.zzl(zzfnz.zzb().zza());
            this.zzd.zzg(zzfnp.zza().zzb());
            this.zzd.zzi(this, this.zza);
        }
    }

    public final View zzf() {
        return (View) this.zzc.get();
    }

    public final zzfoh zzg() {
        return this.zzd;
    }

    public final String zzh() {
        return this.zzg;
    }

    public final List zzi() {
        return this.zzb.zza();
    }

    public final boolean zzj() {
        return this.zze && !this.zzf;
    }
}
