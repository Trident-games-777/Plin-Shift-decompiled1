package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfnq extends zzfnt {
    private static final zzfnq zzb = new zzfnq();

    private zzfnq() {
    }

    public static zzfnq zza() {
        return zzb;
    }

    public final void zzb(boolean z) {
        for (zzfna zzg : zzfnr.zza().zzc()) {
            zzg.zzg().zzk(z);
        }
    }

    public final boolean zzc() {
        for (zzfna zzf : zzfnr.zza().zzb()) {
            View zzf2 = zzf.zzf();
            if (zzf2 != null && zzf2.hasWindowFocus()) {
                return true;
            }
        }
        return false;
    }
}
