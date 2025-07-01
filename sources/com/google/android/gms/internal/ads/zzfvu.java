package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfvu {
    private final zzfxg zza;
    private final Context zzb;
    /* access modifiers changed from: private */
    public final zzfvv zzc;
    private final String zzd;
    /* access modifiers changed from: private */
    public final List zze = new ArrayList();
    /* access modifiers changed from: private */
    public boolean zzf;
    private final Intent zzg;
    /* access modifiers changed from: private */
    public final IBinder.DeathRecipient zzh;
    private ServiceConnection zzi;
    /* access modifiers changed from: private */
    public IInterface zzj;

    zzfvu(Context context, zzfvv zzfvv, String str, Intent intent, zzfuz zzfuz) {
        this.zzb = context;
        this.zzc = zzfvv;
        this.zzd = "OverlayDisplayService";
        this.zzg = intent;
        this.zza = zzfxk.zza(new zzfvl("OverlayDisplayService"));
        this.zzh = new zzfvm(this);
    }

    /* access modifiers changed from: private */
    public final void zzo(Runnable runnable) {
        ((Handler) this.zza.zza()).post(new zzfvn(this, runnable));
    }

    public final IInterface zzc() {
        return this.zzj;
    }

    public final void zzi(Runnable runnable) {
        zzo(new zzfvo(this, runnable));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk() {
        this.zzc.zzc("%s : Binder has died.", this.zzd);
        synchronized (this.zze) {
            this.zze.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(Runnable runnable) {
        try {
            runnable.run();
        } catch (RuntimeException e) {
            this.zzc.zza("error caused by ", e);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm() {
        if (this.zzj != null) {
            this.zzc.zzc("Unbind from service.", new Object[0]);
            Context context = this.zzb;
            ServiceConnection serviceConnection = this.zzi;
            serviceConnection.getClass();
            ServiceConnection serviceConnection2 = serviceConnection;
            context.unbindService(serviceConnection);
            this.zzf = false;
            this.zzj = null;
            this.zzi = null;
            synchronized (this.zze) {
                this.zze.clear();
            }
        }
    }

    public final void zzn() {
        zzo(new zzfvp(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(Runnable runnable) {
        if (this.zzj == null && !this.zzf) {
            this.zzc.zzc("Initiate binding to the service.", new Object[0]);
            synchronized (this.zze) {
                this.zze.add(runnable);
            }
            zzfvs zzfvs = new zzfvs(this, (zzfvt) null);
            this.zzi = zzfvs;
            this.zzf = true;
            if (!this.zzb.bindService(this.zzg, zzfvs, 1)) {
                this.zzc.zzc("Failed to bind to the service.", new Object[0]);
                this.zzf = false;
                synchronized (this.zze) {
                    this.zze.clear();
                }
            }
        } else if (this.zzf) {
            this.zzc.zzc("Waiting to bind to the service.", new Object[0]);
            synchronized (this.zze) {
                this.zze.add(runnable);
            }
        } else {
            runnable.run();
        }
    }
}
