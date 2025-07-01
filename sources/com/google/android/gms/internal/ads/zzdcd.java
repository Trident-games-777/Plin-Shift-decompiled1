package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.zzr;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdcd {
    /* access modifiers changed from: private */
    public final Set zza = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzb = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzc = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzd = new HashSet();
    /* access modifiers changed from: private */
    public final Set zze = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzf = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzg = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzh = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzi = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzj = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzk = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzl = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzm = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzn = new HashSet();
    /* access modifiers changed from: private */
    public zzfch zzo;

    public final zzdcd zza(zza zza2, Executor executor) {
        this.zzc.add(new zzded(zza2, executor));
        return this;
    }

    public final zzdcd zzb(zzcwp zzcwp, Executor executor) {
        this.zzi.add(new zzded(zzcwp, executor));
        return this;
    }

    public final zzdcd zzc(zzcxc zzcxc, Executor executor) {
        this.zzl.add(new zzded(zzcxc, executor));
        return this;
    }

    public final zzdcd zzd(zzcxg zzcxg, Executor executor) {
        this.zzf.add(new zzded(zzcxg, executor));
        return this;
    }

    public final zzdcd zze(zzcwm zzcwm, Executor executor) {
        this.zze.add(new zzded(zzcwm, executor));
        return this;
    }

    public final zzdcd zzf(zzcya zzcya, Executor executor) {
        this.zzh.add(new zzded(zzcya, executor));
        return this;
    }

    public final zzdcd zzg(zzcyl zzcyl, Executor executor) {
        this.zzg.add(new zzded(zzcyl, executor));
        return this;
    }

    public final zzdcd zzh(zzr zzr, Executor executor) {
        this.zzn.add(new zzded(zzr, executor));
        return this;
    }

    public final zzdcd zzi(zzcyx zzcyx, Executor executor) {
        this.zzm.add(new zzded(zzcyx, executor));
        return this;
    }

    public final zzdcd zzj(zzczj zzczj, Executor executor) {
        this.zzb.add(new zzded(zzczj, executor));
        return this;
    }

    public final zzdcd zzk(AppEventListener appEventListener, Executor executor) {
        this.zzk.add(new zzded(appEventListener, executor));
        return this;
    }

    public final zzdcd zzl(zzdel zzdel, Executor executor) {
        this.zzd.add(new zzded(zzdel, executor));
        return this;
    }

    public final zzdcd zzm(zzfch zzfch) {
        this.zzo = zzfch;
        return this;
    }

    public final zzdcf zzn() {
        return new zzdcf(this, (zzdce) null);
    }
}
