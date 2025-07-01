package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzv;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzazc {
    int zza;
    private final Object zzb = new Object();
    private final List zzc = new LinkedList();

    public final void zza(zzazb zzazb) {
        synchronized (this.zzb) {
            if (this.zzc.size() >= 10) {
                int size = this.zzc.size();
                zzm.zze("Queue is full, current size = " + size);
                this.zzc.remove(0);
            }
            int i = this.zza;
            this.zza = i + 1;
            zzazb.zzg(i);
            zzazb.zzk();
            this.zzc.add(zzazb);
        }
    }

    public final boolean zzb(zzazb zzazb) {
        synchronized (this.zzb) {
            Iterator it = this.zzc.iterator();
            while (it.hasNext()) {
                zzazb zzazb2 = (zzazb) it.next();
                if (!zzv.zzp().zzi().zzK()) {
                    if (!zzazb.equals(zzazb2) && zzazb2.zzc().equals(zzazb.zzc())) {
                        it.remove();
                        return true;
                    }
                } else if (!zzv.zzp().zzi().zzL() && !zzazb.equals(zzazb2) && zzazb2.zzd().equals(zzazb.zzd())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public final boolean zzc(zzazb zzazb) {
        synchronized (this.zzb) {
            if (this.zzc.contains(zzazb)) {
                return true;
            }
            return false;
        }
    }
}
