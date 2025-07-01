package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaal extends Surface {
    private static int zzb;
    private static boolean zzc;
    public final boolean zza;
    private final zzaaj zzd;
    private boolean zze;

    /* synthetic */ zzaal(zzaaj zzaaj, SurfaceTexture surfaceTexture, boolean z, zzaak zzaak) {
        super(surfaceTexture);
        this.zzd = zzaaj;
        this.zza = z;
    }

    public static zzaal zza(Context context, boolean z) {
        int i = 0;
        boolean z2 = true;
        if (z && !zzb(context)) {
            z2 = false;
        }
        zzdb.zzf(z2);
        zzaaj zzaaj = new zzaaj();
        if (z) {
            i = zzb;
        }
        return zzaaj.zza(i);
    }

    public static synchronized boolean zzb(Context context) {
        int i;
        synchronized (zzaal.class) {
            if (!zzc) {
                zzb = zzdk.zzb(context) ? zzdk.zzc() ? 1 : 2 : 0;
                zzc = true;
            }
            i = zzb;
        }
        return i != 0;
    }

    public final void release() {
        super.release();
        synchronized (this.zzd) {
            if (!this.zze) {
                this.zzd.zzb();
                this.zze = true;
            }
        }
    }
}
