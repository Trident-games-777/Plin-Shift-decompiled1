package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfpy implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected final zzfqw zza;
    private final String zzb;
    private final String zzc;
    private final LinkedBlockingQueue zzd;
    private final HandlerThread zze;
    private final zzfpp zzf;
    private final long zzg = System.currentTimeMillis();
    private final int zzh;

    public zzfpy(Context context, int i, int i2, String str, String str2, String str3, zzfpp zzfpp) {
        this.zzb = str;
        this.zzh = i2;
        this.zzc = str2;
        this.zzf = zzfpp;
        HandlerThread handlerThread = new HandlerThread("GassDGClient");
        this.zze = handlerThread;
        handlerThread.start();
        zzfqw zzfqw = new zzfqw(context, handlerThread.getLooper(), this, this, 19621000);
        this.zza = zzfqw;
        this.zzd = new LinkedBlockingQueue();
        zzfqw.checkAvailabilityAndConnect();
    }

    private final void zzd(int i, long j, Exception exc) {
        this.zzf.zzc(i, System.currentTimeMillis() - j, exc);
    }

    public final void onConnected(Bundle bundle) {
        zzfrb zzc2 = zzc();
        if (zzc2 != null) {
            try {
                zzfri zzf2 = zzc2.zzf(new zzfrg(1, this.zzh, this.zzb, this.zzc));
                zzd(5011, this.zzg, (Exception) null);
                this.zzd.put(zzf2);
            } catch (Throwable th) {
                zzb();
                this.zze.quit();
                throw th;
            }
            zzb();
            this.zze.quit();
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            zzd(4012, this.zzg, (Exception) null);
            this.zzd.put(new zzfri((byte[]) null, 1));
        } catch (InterruptedException unused) {
        }
    }

    public final void onConnectionSuspended(int i) {
        try {
            zzd(4011, this.zzg, (Exception) null);
            this.zzd.put(new zzfri((byte[]) null, 1));
        } catch (InterruptedException unused) {
        }
    }

    public final zzfri zza(int i) {
        zzfri zzfri;
        try {
            zzfri = (zzfri) this.zzd.poll(50000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            zzd(2009, this.zzg, e);
            zzfri = null;
        }
        zzd(3004, this.zzg, (Exception) null);
        if (zzfri != null) {
            if (zzfri.zzc == 7) {
                zzfpp.zzg(3);
            } else {
                zzfpp.zzg(2);
            }
        }
        return zzfri == null ? new zzfri((byte[]) null, 1) : zzfri;
    }

    public final void zzb() {
        zzfqw zzfqw = this.zza;
        if (zzfqw == null) {
            return;
        }
        if (zzfqw.isConnected() || this.zza.isConnecting()) {
            this.zza.disconnect();
        }
    }

    /* access modifiers changed from: protected */
    public final zzfrb zzc() {
        try {
            return this.zza.zzp();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }
}
