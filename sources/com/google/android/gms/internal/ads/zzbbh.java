package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.zzv;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbbh {
    /* access modifiers changed from: private */
    public zzbaw zza;
    /* access modifiers changed from: private */
    public boolean zzb;
    private final Context zzc;
    /* access modifiers changed from: private */
    public final Object zzd = new Object();

    zzbbh(Context context) {
        this.zzc = context;
    }

    /* access modifiers changed from: package-private */
    public final Future zzc(zzbax zzbax) {
        zzbbb zzbbb = new zzbbb(this);
        zzbbf zzbbf = new zzbbf(this, zzbax, zzbbb);
        zzbbg zzbbg = new zzbbg(this, zzbbb);
        synchronized (this.zzd) {
            zzbaw zzbaw = new zzbaw(this.zzc, zzv.zzu().zzb(), zzbbf, zzbbg);
            this.zza = zzbaw;
            zzbaw.checkAvailabilityAndConnect();
        }
        return zzbbb;
    }

    static /* bridge */ /* synthetic */ void zze(zzbbh zzbbh) {
        synchronized (zzbbh.zzd) {
            zzbaw zzbaw = zzbbh.zza;
            if (zzbaw != null) {
                zzbaw.disconnect();
                zzbbh.zza = null;
                Binder.flushPendingCommands();
            }
        }
    }
}
