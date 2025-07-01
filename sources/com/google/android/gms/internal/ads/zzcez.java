package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcez extends zzcbl {
    private final zzccg zzc;
    private zzcfa zzd;
    private Uri zze;
    private zzcbk zzf;
    private boolean zzg = false;
    private int zzh = 1;

    public zzcez(Context context, zzccg zzccg) {
        super(context);
        this.zzc = zzccg;
        zzccg.zza(this);
    }

    @EnsuresNonNullIf(expression = {"immersiveAdPlayer"}, result = true)
    private final boolean zzm() {
        int i = this.zzh;
        return (i == 1 || i == 2 || this.zzd == null) ? false : true;
    }

    private final void zzv(int i) {
        if (i == 4) {
            this.zzc.zzc();
            this.zzb.zzb();
        } else if (this.zzh == 4) {
            this.zzc.zze();
            this.zzb.zzc();
        }
        this.zzh = i;
    }

    public final String toString() {
        String name = getClass().getName();
        String hexString = Integer.toHexString(hashCode());
        return name + "@" + hexString;
    }

    public final int zza() {
        return 0;
    }

    public final int zzb() {
        return zzm() ? 0 : -1;
    }

    public final int zzc() {
        return zzm() ? 0 : -1;
    }

    public final int zzd() {
        return 0;
    }

    public final int zze() {
        return 0;
    }

    public final long zzf() {
        return 0;
    }

    public final long zzg() {
        return 0;
    }

    public final long zzh() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi() {
        zzcbk zzcbk = this.zzf;
        if (zzcbk != null) {
            zzcbk.zzd();
        }
    }

    public final String zzj() {
        return "ImmersivePlayer";
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk() {
        zzcbk zzcbk = this.zzf;
        if (zzcbk != null) {
            if (!this.zzg) {
                zzcbk.zzg();
                this.zzg = true;
            }
            this.zzf.zze();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzl() {
        zzcbk zzcbk = this.zzf;
        if (zzcbk != null) {
            zzcbk.zzf();
        }
    }

    public final void zzn() {
        if (this.zzd != null) {
            this.zzb.zza();
        }
    }

    public final void zzo() {
        zze.zza("AdImmersivePlayerView pause");
        if (zzm() && this.zzd.zzd()) {
            this.zzd.zza();
            zzv(5);
            zzs.zza.post(new zzcey(this));
        }
    }

    public final void zzp() {
        zze.zza("AdImmersivePlayerView play");
        if (zzm()) {
            this.zzd.zzb();
            zzv(4);
            this.zza.zzb();
            zzs.zza.post(new zzcex(this));
        }
    }

    public final void zzq(int i) {
        zze.zza("AdImmersivePlayerView seek " + i);
    }

    public final void zzr(zzcbk zzcbk) {
        this.zzf = zzcbk;
    }

    public final void zzs(String str) {
        if (str != null) {
            this.zze = Uri.parse(str);
            this.zzd = new zzcfa(this.zze.toString());
            zzv(3);
            zzs.zza.post(new zzcew(this));
        }
    }

    public final void zzt() {
        zze.zza("AdImmersivePlayerView stop");
        zzcfa zzcfa = this.zzd;
        if (zzcfa != null) {
            zzcfa.zzc();
            this.zzd = null;
            zzv(1);
        }
        this.zzc.zzd();
    }

    public final void zzu(float f, float f2) {
    }
}
