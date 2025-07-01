package com.google.android.gms.internal.ads;

import coil3.util.UtilsKt;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaom implements zzacr {
    private final zzed zza = new zzed(4);
    private final zzads zzb = new zzads(-1, -1, UtilsKt.MIME_TYPE_WEBP);

    public final int zzb(zzacs zzacs, zzadn zzadn) throws IOException {
        return this.zzb.zzb(zzacs, zzadn);
    }

    public final /* synthetic */ zzacr zzc() {
        return this;
    }

    public final /* synthetic */ List zzd() {
        return zzfzo.zzn();
    }

    public final void zze(zzacu zzacu) {
        this.zzb.zze(zzacu);
    }

    public final void zzf(long j, long j2) {
        this.zzb.zzf(j, j2);
    }

    public final boolean zzi(zzacs zzacs) throws IOException {
        this.zza.zzI(4);
        zzacg zzacg = (zzacg) zzacs;
        zzacg.zzm(this.zza.zzN(), 0, 4, false);
        if (this.zza.zzu() == 1380533830) {
            zzacg.zzl(4, false);
            this.zza.zzI(4);
            zzacg.zzm(this.zza.zzN(), 0, 4, false);
            if (this.zza.zzu() == 1464156752) {
                return true;
            }
        }
        return false;
    }
}
