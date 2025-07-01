package com.google.android.gms.internal.ads;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfnn extends ContentObserver {
    private final Context zza;
    private final AudioManager zzb;
    private float zzc;
    private final zzfnz zzd;

    public zzfnn(Handler handler, Context context, zzfnl zzfnl, zzfnz zzfnz) {
        super(handler);
        this.zza = context;
        this.zzb = (AudioManager) context.getSystemService("audio");
        this.zzd = zzfnz;
    }

    private final float zzc() {
        AudioManager audioManager = this.zzb;
        int streamVolume = audioManager.getStreamVolume(3);
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        float f = 0.0f;
        if (streamMaxVolume > 0) {
            if (streamVolume <= 0) {
                return 0.0f;
            }
            f = ((float) streamVolume) / ((float) streamMaxVolume);
            if (f > 1.0f) {
                return 1.0f;
            }
        }
        return f;
    }

    private final void zzd() {
        this.zzd.zze(this.zzc);
    }

    public final void onChange(boolean z) {
        super.onChange(z);
        float zzc2 = zzc();
        if (zzc2 != this.zzc) {
            this.zzc = zzc2;
            zzd();
        }
    }

    public final void zza() {
        this.zzc = zzc();
        zzd();
        this.zza.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public final void zzb() {
        this.zza.getContentResolver().unregisterContentObserver(this);
    }
}
