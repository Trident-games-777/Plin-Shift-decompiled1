package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Date;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfnp implements zzfns {
    private static final zzfnp zza = new zzfnp(new zzfnt());
    private Date zzb;
    private boolean zzc;
    private final zzfnt zzd;
    private boolean zze;

    private zzfnp(zzfnt zzfnt) {
        this.zzd = zzfnt;
    }

    public static zzfnp zza() {
        return zza;
    }

    public final Date zzb() {
        Date date = this.zzb;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public final void zzc(boolean z) {
        if (!this.zze && z) {
            Date date = new Date();
            Date date2 = this.zzb;
            if (date2 == null || date.after(date2)) {
                this.zzb = date;
                if (this.zzc) {
                    for (zzfna zzg : zzfnr.zza().zzb()) {
                        zzg.zzg().zzg(zzb());
                    }
                }
            }
        }
        this.zze = z;
    }

    public final void zzd(Context context) {
        if (!this.zzc) {
            this.zzd.zzd(context);
            this.zzd.zze(this);
            this.zzd.zzf();
            this.zze = this.zzd.zza;
            this.zzc = true;
        }
    }
}
