package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzanq {
    private final List zza;
    private final zzadx[] zzb;
    private final zzft zzc = new zzft(new zzanp(this));

    public zzanq(List list) {
        this.zza = list;
        this.zzb = new zzadx[list.size()];
    }

    public final void zza(long j, zzed zzed) {
        this.zzc.zzb(j, zzed);
    }

    public final void zzb(zzacu zzacu, zzaoa zzaoa) {
        for (int i = 0; i < this.zzb.length; i++) {
            zzaoa.zzc();
            zzadx zzw = zzacu.zzw(zzaoa.zza(), 3);
            zzad zzad = (zzad) this.zza.get(i);
            String str = zzad.zzo;
            boolean z = true;
            if (!"application/cea-608".equals(str) && !"application/cea-708".equals(str)) {
                z = false;
            }
            zzdb.zze(z, "Invalid closed caption MIME type provided: ".concat(String.valueOf(str)));
            String str2 = zzad.zza;
            if (str2 == null) {
                str2 = zzaoa.zzb();
            }
            zzab zzab = new zzab();
            zzab.zzL(str2);
            zzab.zzZ(str);
            zzab.zzab(zzad.zze);
            zzab.zzP(zzad.zzd);
            zzab.zzx(zzad.zzH);
            zzab.zzM(zzad.zzr);
            zzw.zzl(zzab.zzaf());
            this.zzb[i] = zzw;
        }
    }

    public final void zzc() {
        this.zzc.zzc();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(long j, zzed zzed) {
        zzacd.zza(j, zzed, this.zzb);
    }

    public final void zze(int i) {
        this.zzc.zzd(i);
    }
}
