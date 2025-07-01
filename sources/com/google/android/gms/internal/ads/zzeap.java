package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Looper;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzeap implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected final zzcao zza = new zzcao();
    protected boolean zzb = false;
    protected boolean zzc = false;
    protected zzbuu zzd;
    protected Context zze;
    protected Looper zzf;
    protected ScheduledExecutorService zzg;

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        String format = String.format(Locale.US, "Remote ad service connection failed, cause: %d.", new Object[]{Integer.valueOf(connectionResult.getErrorCode())});
        zzm.zze(format);
        this.zza.zzd(new zzdyw(1, format));
    }

    public void onConnectionSuspended(int i) {
        String format = String.format(Locale.US, "Remote ad service connection suspended, cause: %d.", new Object[]{Integer.valueOf(i)});
        zzm.zze(format);
        this.zza.zzd(new zzdyw(1, format));
    }

    /* access modifiers changed from: protected */
    public final synchronized void zzb() {
        if (this.zzd == null) {
            this.zzd = new zzbuu(this.zze, this.zzf, this, this);
        }
        this.zzd.checkAvailabilityAndConnect();
    }

    /* access modifiers changed from: protected */
    public final synchronized void zzc() {
        this.zzc = true;
        zzbuu zzbuu = this.zzd;
        if (zzbuu != null) {
            if (zzbuu.isConnected() || this.zzd.isConnecting()) {
                this.zzd.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }
}
