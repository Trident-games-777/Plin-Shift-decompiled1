package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzfw implements zzgd {
    private final boolean zza;
    private final ArrayList zzb = new ArrayList(1);
    private int zzc;
    private zzgi zzd;

    protected zzfw(boolean z) {
        this.zza = z;
    }

    public /* synthetic */ Map zze() {
        return Collections.emptyMap();
    }

    /* access modifiers changed from: protected */
    public final void zzg(int i) {
        zzgi zzgi = this.zzd;
        int i2 = zzen.zza;
        zzgi zzgi2 = zzgi;
        for (int i3 = 0; i3 < this.zzc; i3++) {
            ((zzhd) this.zzb.get(i3)).zza(this, zzgi, this.zza, i);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzh() {
        zzgi zzgi = this.zzd;
        int i = zzen.zza;
        zzgi zzgi2 = zzgi;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            ((zzhd) this.zzb.get(i2)).zzb(this, zzgi, this.zza);
        }
        this.zzd = null;
    }

    /* access modifiers changed from: protected */
    public final void zzi(zzgi zzgi) {
        for (int i = 0; i < this.zzc; i++) {
            ((zzhd) this.zzb.get(i)).zzc(this, zzgi, this.zza);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzj(zzgi zzgi) {
        this.zzd = zzgi;
        for (int i = 0; i < this.zzc; i++) {
            ((zzhd) this.zzb.get(i)).zzd(this, zzgi, this.zza);
        }
    }

    public final void zzf(zzhd zzhd) {
        zzhd.getClass();
        if (!this.zzb.contains(zzhd)) {
            this.zzb.add(zzhd);
            this.zzc++;
        }
    }
}
