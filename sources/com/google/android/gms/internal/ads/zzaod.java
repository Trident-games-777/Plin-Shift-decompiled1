package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzaod {
    private final List zza;
    private final zzadx[] zzb;

    public zzaod(List list) {
        this.zza = list;
        this.zzb = new zzadx[list.size()];
    }

    public final void zza(long j, zzed zzed) {
        if (zzed.zzb() >= 9) {
            int zzg = zzed.zzg();
            int zzg2 = zzed.zzg();
            int zzm = zzed.zzm();
            if (zzg == 434 && zzg2 == 1195456820 && zzm == 3) {
                zzacd.zzb(j, zzed, this.zzb);
            }
        }
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
            zzab zzab = new zzab();
            zzab.zzL(zzaoa.zzb());
            zzab.zzZ(str);
            zzab.zzab(zzad.zze);
            zzab.zzP(zzad.zzd);
            zzab.zzx(zzad.zzH);
            zzab.zzM(zzad.zzr);
            zzw.zzl(zzab.zzaf());
            this.zzb[i] = zzw;
        }
    }
}
