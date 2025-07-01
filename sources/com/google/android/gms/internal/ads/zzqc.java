package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzqc {
    private final Context zza;
    private Boolean zzb;

    public zzqc() {
        this.zza = null;
    }

    public zzqc(Context context) {
        this.zza = context;
    }

    public final zzoz zza(zzad zzad, zzg zzg) {
        boolean z;
        zzad.getClass();
        zzg.getClass();
        if (zzen.zza < 29 || zzad.zzD == -1) {
            return zzoz.zza;
        }
        Context context = this.zza;
        Boolean bool = this.zzb;
        if (bool != null) {
            z = bool.booleanValue();
        } else {
            boolean z2 = false;
            if (context != null) {
                AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                if (audioManager != null) {
                    String parameters = audioManager.getParameters("offloadVariableRateSupported");
                    if (parameters != null && parameters.equals("offloadVariableRateSupported=1")) {
                        z2 = true;
                    }
                    this.zzb = Boolean.valueOf(z2);
                } else {
                    this.zzb = false;
                }
            } else {
                this.zzb = false;
            }
            z = this.zzb.booleanValue();
        }
        String str = zzad.zzo;
        str.getClass();
        String str2 = str;
        int zza2 = zzbg.zza(str, zzad.zzk);
        if (zza2 == 0 || zzen.zza < zzen.zzh(zza2)) {
            return zzoz.zza;
        }
        int zzi = zzen.zzi(zzad.zzC);
        if (zzi == 0) {
            return zzoz.zza;
        }
        try {
            AudioFormat zzx = zzen.zzx(zzad.zzD, zzi, zza2);
            if (zzen.zza >= 31) {
                return zzqb.zza(zzx, zzg.zza().zza, z);
            }
            return zzqa.zza(zzx, zzg.zza().zza, z);
        } catch (IllegalArgumentException unused) {
            return zzoz.zza;
        }
    }
}
