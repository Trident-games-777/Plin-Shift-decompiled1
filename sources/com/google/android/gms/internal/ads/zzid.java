package com.google.android.gms.internal.ads;

import androidx.lifecycle.CoroutineLiveDataKt;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzid implements zzkl {
    private final zzys zza;
    private final long zzb = zzen.zzs(50000);
    private final long zzc = zzen.zzs(50000);
    private final long zzd = zzen.zzs(2500);
    private final long zze = zzen.zzs(CoroutineLiveDataKt.DEFAULT_TIMEOUT);
    private final long zzf = zzen.zzs(0);
    private final HashMap zzg = new HashMap();
    private long zzh = -1;

    public zzid() {
        zzys zzys = new zzys(true, 65536);
        zzk(2500, 0, "bufferForPlaybackMs", "0");
        zzk(5000, 0, "bufferForPlaybackAfterRebufferMs", "0");
        zzk(50000, 2500, "minBufferMs", "bufferForPlaybackMs");
        zzk(50000, 5000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        zzk(50000, 50000, "maxBufferMs", "minBufferMs");
        zzk(0, 0, "backBufferDurationMs", "0");
        this.zza = zzys;
    }

    private static void zzk(int i, int i2, String str, String str2) {
        zzdb.zze(i >= i2, str + " cannot be less than " + str2);
    }

    private final void zzl(zzoj zzoj) {
        if (this.zzg.remove(zzoj) != null) {
            zzm();
        }
    }

    private final void zzm() {
        if (this.zzg.isEmpty()) {
            this.zza.zze();
        } else {
            this.zza.zzf(zza());
        }
    }

    /* access modifiers changed from: package-private */
    public final int zza() {
        int i = 0;
        for (zzib zzib : this.zzg.values()) {
            i += zzib.zzb;
        }
        return i;
    }

    public final long zzb(zzoj zzoj) {
        return this.zzf;
    }

    public final void zzc(zzoj zzoj) {
        long id = Thread.currentThread().getId();
        long j = this.zzh;
        boolean z = true;
        if (!(j == -1 || j == id)) {
            z = false;
        }
        zzdb.zzg(z, "Players that share the same LoadControl must share the same playback thread. See ExoPlayer.Builder.setPlaybackLooper(Looper).");
        this.zzh = id;
        if (!this.zzg.containsKey(zzoj)) {
            this.zzg.put(zzoj, new zzib((zzic) null));
        }
        zzib zzib = (zzib) this.zzg.get(zzoj);
        zzib.getClass();
        zzib zzib2 = zzib;
        zzib.zzb = 13107200;
        zzib.zza = false;
    }

    public final void zzd(zzoj zzoj) {
        zzl(zzoj);
        if (this.zzg.isEmpty()) {
            this.zzh = -1;
        }
    }

    public final void zze(zzoj zzoj) {
        zzl(zzoj);
    }

    public final void zzf(zzoj zzoj, zzbv zzbv, zzur zzur, zzln[] zzlnArr, zzwr zzwr, zzyd[] zzydArr) {
        zzib zzib = (zzib) this.zzg.get(zzoj);
        zzib.getClass();
        zzib zzib2 = zzib;
        int i = 0;
        int i2 = 0;
        while (true) {
            int length = zzlnArr.length;
            int i3 = 13107200;
            if (i < 2) {
                if (zzydArr[i] != null) {
                    if (zzlnArr[i].zzb() != 1) {
                        i3 = 131072000;
                    }
                    i2 += i3;
                }
                i++;
            } else {
                zzib.zzb = Math.max(13107200, i2);
                zzm();
                return;
            }
        }
    }

    public final boolean zzg(zzoj zzoj) {
        return false;
    }

    public final boolean zzh(zzkk zzkk) {
        zzib zzib = (zzib) this.zzg.get(zzkk.zza);
        zzib.getClass();
        zzib zzib2 = zzib;
        int zza2 = this.zza.zza();
        int zza3 = zza();
        long j = this.zzb;
        float f = zzkk.zzc;
        if (f > 1.0f) {
            j = Math.min(zzen.zzq(j, f), this.zzc);
        }
        long j2 = zzkk.zzb;
        int i = (j2 > Math.max(j, 500000) ? 1 : (j2 == Math.max(j, 500000) ? 0 : -1));
        boolean z = false;
        if (i < 0) {
            if (zza2 < zza3) {
                z = true;
            }
            zzib.zza = z;
            if (!z && j2 < 500000) {
                zzdt.zzf("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j2 >= this.zzc || zza2 >= zza3) {
            zzib.zza = false;
        }
        return zzib.zza;
    }

    public final boolean zzi(zzkk zzkk) {
        long j;
        boolean z = zzkk.zzd;
        long zzr = zzen.zzr(zzkk.zzb, zzkk.zzc);
        if (z) {
            j = this.zze;
        } else {
            j = this.zzd;
        }
        long j2 = zzkk.zze;
        if (j2 != -9223372036854775807L) {
            j = Math.min(j2 / 2, j);
        }
        return j <= 0 || zzr >= j || this.zza.zza() >= zza();
    }

    public final zzys zzj() {
        return this.zza;
    }
}
