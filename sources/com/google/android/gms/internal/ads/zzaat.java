package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.Surface;
import com.google.firebase.messaging.Constants;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaat {
    private final zzaac zza = new zzaac();
    private final zzaar zzb;
    private final zzaas zzc;
    private boolean zzd;
    private Surface zze;
    private float zzf;
    private float zzg;
    private float zzh;
    private float zzi;
    private int zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;

    static /* bridge */ /* synthetic */ void zzb(zzaat zzaat, Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / ((double) display.getRefreshRate()));
            zzaat.zzk = refreshRate;
            zzaat.zzl = (refreshRate * 80) / 100;
            return;
        }
        zzdt.zzf("VideoFrameReleaseHelper", "Unable to query display refresh rate");
        zzaat.zzk = -9223372036854775807L;
        zzaat.zzl = -9223372036854775807L;
    }

    private final void zzk() {
        Surface surface;
        if (zzen.zza >= 30 && (surface = this.zze) != null && this.zzj != Integer.MIN_VALUE && this.zzh != 0.0f) {
            this.zzh = 0.0f;
            zzaaq.zza(surface, 0.0f);
        }
    }

    private final void zzl() {
        this.zzm = 0;
        this.zzp = -1;
        this.zzn = -1;
    }

    private final void zzm() {
        float f;
        if (zzen.zza >= 30 && this.zze != null) {
            if (this.zza.zzg()) {
                f = this.zza.zza();
            } else {
                f = this.zzf;
            }
            float f2 = this.zzg;
            if (f != f2) {
                int i = (f > -1.0f ? 1 : (f == -1.0f ? 0 : -1));
                if (i != 0 && f2 != -1.0f) {
                    float f3 = 1.0f;
                    if (this.zza.zzg() && this.zza.zzd() >= 5000000000L) {
                        f3 = 0.02f;
                    }
                    if (Math.abs(f - this.zzg) < f3) {
                        return;
                    }
                } else if (i == 0 && this.zza.zzb() < 30) {
                    return;
                }
                this.zzg = f;
                zzn(false);
            }
        }
    }

    private final void zzn(boolean z) {
        Surface surface;
        if (zzen.zza >= 30 && (surface = this.zze) != null && this.zzj != Integer.MIN_VALUE) {
            float f = 0.0f;
            if (this.zzd) {
                float f2 = this.zzg;
                if (f2 != -1.0f) {
                    f = this.zzi * f2;
                }
            }
            if (z || this.zzh != f) {
                this.zzh = f;
                zzaaq.zza(surface, f);
            }
        }
    }

    public final long zza(long j) {
        long j2;
        if (this.zzp != -1 && this.zza.zzg()) {
            long zzc2 = this.zza.zzc();
            long j3 = this.zzq + ((long) (((float) (zzc2 * (this.zzm - this.zzp))) / this.zzi));
            if (Math.abs(j - j3) > 20000000) {
                zzl();
            } else {
                j = j3;
            }
        }
        this.zzn = this.zzm;
        this.zzo = j;
        zzaas zzaas = this.zzc;
        if (!(zzaas == null || this.zzk == -9223372036854775807L)) {
            long j4 = zzaas.zza;
            if (j4 != -9223372036854775807L) {
                long j5 = this.zzk;
                long j6 = j4 + (((j - j4) / j5) * j5);
                if (j <= j6) {
                    j2 = j6 - j5;
                } else {
                    long j7 = j5 + j6;
                    j2 = j6;
                    j6 = j7;
                }
                long j8 = this.zzl;
                if (j6 - j >= j - j2) {
                    j6 = j2;
                }
                return j6 - j8;
            }
        }
        return j;
    }

    public final void zzc(float f) {
        this.zzf = f;
        this.zza.zzf();
        zzm();
    }

    public final void zzd(long j) {
        long j2 = this.zzn;
        if (j2 != -1) {
            this.zzp = j2;
            this.zzq = this.zzo;
        }
        this.zzm++;
        this.zza.zze(j * 1000);
        zzm();
    }

    public final void zze(float f) {
        this.zzi = f;
        zzl();
        zzn(false);
    }

    public final void zzf() {
        zzl();
    }

    public final void zzg() {
        this.zzd = true;
        zzl();
        if (this.zzb != null) {
            zzaas zzaas = this.zzc;
            zzaas.getClass();
            zzaas zzaas2 = zzaas;
            zzaas.zzb();
            this.zzb.zza();
        }
        zzn(false);
    }

    public final void zzh() {
        this.zzd = false;
        zzaar zzaar = this.zzb;
        if (zzaar != null) {
            zzaar.zzb();
            zzaas zzaas = this.zzc;
            zzaas.getClass();
            zzaas zzaas2 = zzaas;
            zzaas.zzc();
        }
        zzk();
    }

    public final void zzi(Surface surface) {
        if (this.zze != surface) {
            zzk();
            this.zze = surface;
            zzn(true);
        }
    }

    public final void zzj(int i) {
        if (this.zzj != i) {
            this.zzj = i;
            zzn(true);
        }
    }

    public zzaat(Context context) {
        zzaar zzaar;
        DisplayManager displayManager;
        zzaas zzaas = null;
        if (context == null || (displayManager = (DisplayManager) context.getSystemService(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION)) == null) {
            zzaar = null;
        } else {
            zzaar = new zzaar(this, displayManager);
        }
        this.zzb = zzaar;
        this.zzc = zzaar != null ? zzaas.zza() : zzaas;
        this.zzk = -9223372036854775807L;
        this.zzl = -9223372036854775807L;
        this.zzf = -1.0f;
        this.zzi = 1.0f;
        this.zzj = 0;
    }
}
