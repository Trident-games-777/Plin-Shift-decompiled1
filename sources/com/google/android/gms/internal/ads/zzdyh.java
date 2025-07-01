package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzdyh implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected final zzcao zza = new zzcao();
    protected final Object zzb = new Object();
    protected boolean zzc = false;
    protected boolean zzd = false;
    protected zzbvx zze;
    protected zzbur zzf;

    static void zzc(Context context, ListenableFuture listenableFuture, Executor executor) {
        if (((Boolean) zzbef.zzj.zze()).booleanValue() || ((Boolean) zzbef.zzh.zze()).booleanValue()) {
            zzgei.zzr(listenableFuture, new zzdye(context), executor);
        }
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        zzm.zze("Disconnected from remote ad request service.");
        this.zza.zzd(new zzdyw(1));
    }

    public final void onConnectionSuspended(int i) {
        zzm.zze("Cannot connect to remote service, fallback to local instance.");
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        synchronized (this.zzb) {
            this.zzd = true;
            if (this.zzf.isConnected() || this.zzf.isConnecting()) {
                this.zzf.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }
}
