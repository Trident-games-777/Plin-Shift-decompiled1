package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaxe extends zzaxt {
    private final zzavi zzh;
    private final long zzi;
    private final long zzj;

    public zzaxe(zzawf zzawf, String str, String str2, zzasf zzasf, int i, int i2, zzavi zzavi, long j, long j2) {
        super(zzawf, "TEuVeGvhlSIXkgQOkIrP3/M5xn08Noea2HjGio+2r03gBpanfVd2G9lK+KoDXH2T", "AA74eMHsp6+YeXgwW1ug4iNz8R55KIvaQAvJIVOChCk=", zzasf, i, 11);
        this.zzh = zzavi;
        this.zzi = j;
        this.zzj = j2;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        zzavi zzavi = this.zzh;
        if (zzavi != null) {
            zzavg zzavg = new zzavg((String) this.zze.invoke((Object) null, new Object[]{zzavi.zzb(), Long.valueOf(this.zzi), Long.valueOf(this.zzj)}));
            synchronized (this.zzd) {
                this.zzd.zzz(zzavg.zza.longValue());
                if (zzavg.zzb.longValue() >= 0) {
                    this.zzd.zzQ(zzavg.zzb.longValue());
                }
                if (zzavg.zzc.longValue() >= 0) {
                    this.zzd.zzf(zzavg.zzc.longValue());
                }
            }
        }
    }
}
