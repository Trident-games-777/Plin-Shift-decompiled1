package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzepz implements zzevz {
    private final zzges zza;
    private final Context zzb;

    public zzepz(zzges zzges, Context context) {
        this.zza = zzges;
        this.zzb = context;
    }

    public final int zza() {
        return 13;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzepy(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzeqa zzc() throws Exception {
        int i;
        int i2;
        AudioManager audioManager = (AudioManager) this.zzb.getSystemService("audio");
        int mode = audioManager.getMode();
        boolean isMusicActive = audioManager.isMusicActive();
        boolean isSpeakerphoneOn = audioManager.isSpeakerphoneOn();
        int streamVolume = audioManager.getStreamVolume(3);
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzkF)).booleanValue()) {
            i2 = zzv.zzr().zzj(audioManager);
            i = audioManager.getStreamMaxVolume(3);
        } else {
            i2 = -1;
            i = -1;
        }
        return new zzeqa(mode, isMusicActive, isSpeakerphoneOn, streamVolume, i2, i, audioManager.getRingerMode(), audioManager.getStreamVolume(2), zzv.zzs().zza(), zzv.zzs().zze());
    }
}
