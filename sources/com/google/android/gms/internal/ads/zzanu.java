package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzanu implements zzann {
    final /* synthetic */ zzanw zza;
    private final zzec zzb = new zzec(new byte[4], 4);

    public zzanu(zzanw zzanw) {
        this.zza = zzanw;
    }

    public final void zza(zzed zzed) {
        if (zzed.zzm() == 0 && (zzed.zzm() & 128) != 0) {
            zzed.zzM(6);
            int zzb2 = zzed.zzb() / 4;
            for (int i = 0; i < zzb2; i++) {
                zzed.zzG(this.zzb, 4);
                zzec zzec = this.zzb;
                int zzd = zzec.zzd(16);
                zzec.zzn(3);
                if (zzd == 0) {
                    this.zzb.zzn(13);
                } else {
                    int zzd2 = this.zzb.zzd(13);
                    if (this.zza.zzg.get(zzd2) == null) {
                        zzanw zzanw = this.zza;
                        zzanw.zzg.put(zzd2, new zzano(new zzanv(zzanw, zzd2)));
                        zzanw zzanw2 = this.zza;
                        zzanw2.zzm = zzanw2.zzm + 1;
                    }
                }
            }
            this.zza.zzg.remove(0);
        }
    }

    public final void zzb(zzek zzek, zzacu zzacu, zzaoa zzaoa) {
    }
}
