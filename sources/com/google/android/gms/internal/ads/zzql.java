package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzql {
    public final zzad zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final zzcj zzi;
    public final boolean zzj = false;
    public final boolean zzk = false;
    public final boolean zzl = false;

    public zzql(zzad zzad, int i, int i2, int i3, int i4, int i5, int i6, int i7, zzcj zzcj, boolean z, boolean z2, boolean z3) {
        this.zza = zzad;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = i5;
        this.zzg = i6;
        this.zzh = i7;
        this.zzi = zzcj;
    }

    public final AudioTrack zza(zzg zzg2, int i) throws zzpq {
        AudioTrack audioTrack;
        try {
            if (zzen.zza >= 29) {
                audioTrack = new AudioTrack.Builder().setAudioAttributes(zzg2.zza().zza).setAudioFormat(zzen.zzx(this.zze, this.zzf, this.zzg)).setTransferMode(1).setBufferSizeInBytes(this.zzh).setSessionId(i).setOffloadedPlayback(this.zzc == 1).build();
            } else {
                audioTrack = new AudioTrack(zzg2.zza().zza, zzen.zzx(this.zze, this.zzf, this.zzg), this.zzh, 1, i);
            }
            int state = audioTrack.getState();
            if (state == 1) {
                return audioTrack;
            }
            try {
                audioTrack.release();
            } catch (Exception unused) {
            }
            throw new zzpq(state, this.zze, this.zzf, this.zzh, this.zza, zzc(), (Exception) null);
        } catch (IllegalArgumentException | UnsupportedOperationException e) {
            throw new zzpq(0, this.zze, this.zzf, this.zzh, this.zza, zzc(), e);
        }
    }

    public final zzpo zzb() {
        boolean z = true;
        if (this.zzc != 1) {
            z = false;
        }
        boolean z2 = z;
        int i = this.zzf;
        return new zzpo(this.zzg, this.zze, i, false, z2, this.zzh);
    }

    public final boolean zzc() {
        return this.zzc == 1;
    }
}
