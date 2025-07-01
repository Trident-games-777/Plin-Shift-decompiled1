package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzqr implements zzpx {
    final /* synthetic */ zzqw zza;

    /* synthetic */ zzqr(zzqw zzqw, zzqv zzqv) {
        this.zza = zzqw;
    }

    public final void zza(long j) {
        zzdt.zzf("DefaultAudioSink", "Ignoring impossibly large audio latency: " + j);
    }

    public final void zzb(long j) {
        zzqw zzqw = this.zza;
        if (zzqw.zzo != null) {
            ((zzra) zzqw.zzo).zza.zzc.zzv(j);
        }
    }

    public final void zzc(long j, long j2, long j3, long j4) {
        zzqw zzqw = this.zza;
        long zzC = zzqw.zzL();
        long zzD = zzqw.zzM();
        zzdt.zzf("DefaultAudioSink", "Spurious audio timestamp (frame position mismatch): " + j + ", " + j2 + ", " + j3 + ", " + j4 + ", " + zzC + ", " + zzD);
    }

    public final void zzd(long j, long j2, long j3, long j4) {
        zzqw zzqw = this.zza;
        long zzC = zzqw.zzL();
        long zzD = zzqw.zzM();
        zzdt.zzf("DefaultAudioSink", "Spurious audio timestamp (system clock mismatch): " + j + ", " + j2 + ", " + j3 + ", " + j4 + ", " + zzC + ", " + zzD);
    }

    public final void zze(int i, long j) {
        zzqw zzqw = this.zza;
        if (zzqw.zzo != null) {
            ((zzra) this.zza.zzo).zza.zzc.zzx(i, j, SystemClock.elapsedRealtime() - zzqw.zzU);
        }
    }
}
