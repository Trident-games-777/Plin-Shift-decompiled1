package com.google.android.gms.internal.ads;

import coil3.util.UtilsKt;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzafd implements zzacr {
    private final zzed zza = new zzed(4);
    private final zzads zzb = new zzads(-1, -1, UtilsKt.MIME_TYPE_HEIF);

    private final boolean zza(zzacs zzacs, int i) throws IOException {
        this.zza.zzI(4);
        ((zzacg) zzacs).zzm(this.zza.zzN(), 0, 4, false);
        if (this.zza.zzu() == ((long) i)) {
            return true;
        }
        return false;
    }

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
        ((zzacg) zzacs).zzl(4, false);
        if (!zza(zzacs, 1718909296) || !zza(zzacs, 1751476579)) {
            return false;
        }
        return true;
    }
}
