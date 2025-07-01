package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzelk {
    private final ConcurrentHashMap zza = new ConcurrentHashMap();
    private final zzdqd zzb;

    public zzelk(zzdqd zzdqd) {
        this.zzb = zzdqd;
    }

    @CheckForNull
    public final zzbrf zza(String str) {
        if (this.zza.containsKey(str)) {
            return (zzbrf) this.zza.get(str);
        }
        return null;
    }

    public final void zzb(String str) {
        try {
            this.zza.put(str, this.zzb.zzb(str));
        } catch (RemoteException e) {
            zze.zzb("Couldn't create RTB adapter : ", e);
        }
    }
}
