package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.net.Uri;
import android.os.Handler;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzov {
    /* access modifiers changed from: private */
    public final Context zza;
    private final Handler zzb;
    private final zzor zzc;
    private final BroadcastReceiver zzd;
    private final zzos zze;
    private zzop zzf;
    /* access modifiers changed from: private */
    public zzow zzg;
    /* access modifiers changed from: private */
    public zzg zzh;
    private boolean zzi;
    private final zzqf zzj;

    zzov(Context context, zzqf zzqf, zzg zzg2, zzow zzow) {
        Context applicationContext = context.getApplicationContext();
        this.zza = applicationContext;
        zzqf zzqf2 = zzqf;
        this.zzj = zzqf;
        this.zzh = zzg2;
        this.zzg = zzow;
        zzos zzos = null;
        Handler handler = new Handler(zzen.zzz(), (Handler.Callback) null);
        this.zzb = handler;
        this.zzc = zzen.zza >= 23 ? new zzor(this, (zzou) null) : null;
        this.zzd = new zzot(this, (zzou) null);
        Uri zza2 = zzop.zza();
        this.zze = zza2 != null ? new zzos(this, handler, applicationContext.getContentResolver(), zza2) : zzos;
    }

    /* access modifiers changed from: private */
    public final void zzj(zzop zzop) {
        if (this.zzi && !zzop.equals(this.zzf)) {
            this.zzf = zzop;
            this.zzj.zza.zzJ(zzop);
        }
    }

    public final void zzg(zzg zzg2) {
        this.zzh = zzg2;
        zzj(zzop.zzc(this.zza, zzg2, this.zzg));
    }

    public final void zzh(AudioDeviceInfo audioDeviceInfo) {
        AudioDeviceInfo audioDeviceInfo2;
        zzow zzow = this.zzg;
        zzow zzow2 = null;
        if (zzow == null) {
            audioDeviceInfo2 = null;
        } else {
            audioDeviceInfo2 = zzow.zza;
        }
        if (!Objects.equals(audioDeviceInfo, audioDeviceInfo2)) {
            if (audioDeviceInfo != null) {
                zzow2 = new zzow(audioDeviceInfo);
            }
            this.zzg = zzow2;
            zzj(zzop.zzc(this.zza, this.zzh, zzow2));
        }
    }

    public final void zzi() {
        zzor zzor;
        if (this.zzi) {
            this.zzf = null;
            if (zzen.zza >= 23 && (zzor = this.zzc) != null) {
                zzoq.zzb(this.zza, zzor);
            }
            this.zza.unregisterReceiver(this.zzd);
            zzos zzos = this.zze;
            if (zzos != null) {
                zzos.zzb();
            }
            this.zzi = false;
        }
    }

    public final zzop zzc() {
        zzor zzor;
        if (this.zzi) {
            zzop zzop = this.zzf;
            zzop.getClass();
            zzop zzop2 = zzop;
            return zzop;
        }
        this.zzi = true;
        zzos zzos = this.zze;
        if (zzos != null) {
            zzos.zza();
        }
        if (zzen.zza >= 23 && (zzor = this.zzc) != null) {
            zzoq.zza(this.zza, zzor, this.zzb);
        }
        zzop zzd2 = zzop.zzd(this.zza, this.zza.registerReceiver(this.zzd, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"), (String) null, this.zzb), this.zzh, this.zzg);
        this.zzf = zzd2;
        return zzd2;
    }
}
