package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzhv {
    private final zzfxg zza;
    private final zzht zzb;
    private zzhu zzc;
    private int zzd;
    private float zze = 1.0f;

    public zzhv(Context context, Handler handler, zzhu zzhu) {
        this.zza = zzfxk.zza(new zzhr(context));
        this.zzc = zzhu;
        this.zzb = new zzht(this, handler);
        this.zzd = 0;
    }

    private final void zze() {
        int i = this.zzd;
        if (i != 1 && i != 0 && zzen.zza < 26) {
            ((AudioManager) this.zza.zza()).abandonAudioFocus(this.zzb);
        }
    }

    private final void zzf(int i) {
        zzhu zzhu = this.zzc;
        if (zzhu != null) {
            int zzC = zzjv.zzS(i);
            zzjv zzjv = ((zzjr) zzhu).zza;
            zzjv.zzaf(zzjv.zzu(), i, zzC);
        }
    }

    private final void zzg(int i) {
        if (this.zzd != i) {
            this.zzd = i;
            float f = i == 4 ? 0.2f : 1.0f;
            if (this.zze != f) {
                this.zze = f;
                zzhu zzhu = this.zzc;
                if (zzhu != null) {
                    ((zzjr) zzhu).zza.zzac();
                }
            }
        }
    }

    public final float zza() {
        return this.zze;
    }

    public final int zzb(boolean z, int i) {
        zze();
        zzg(0);
        return 1;
    }

    public final void zzd() {
        this.zzc = null;
        zze();
        zzg(0);
    }

    static /* bridge */ /* synthetic */ void zzc(zzhv zzhv, int i) {
        if (i == -3 || i == -2) {
            if (i != -2) {
                zzhv.zzg(4);
                return;
            }
            zzhv.zzf(0);
            zzhv.zzg(3);
        } else if (i == -1) {
            zzhv.zzf(-1);
            zzhv.zze();
            zzhv.zzg(1);
        } else if (i != 1) {
            zzdt.zzf("AudioFocusManager", "Unknown focus change type: " + i);
        } else {
            zzhv.zzg(2);
            zzhv.zzf(1);
        }
    }
}
