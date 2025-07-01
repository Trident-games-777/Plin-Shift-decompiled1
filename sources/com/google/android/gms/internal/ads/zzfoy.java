package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfoy implements Runnable {
    zzfoy() {
    }

    public final void run() {
        if (zzfpb.zzc != null) {
            zzfpb.zzc.post(zzfpb.zzd);
            zzfpb.zzc.postDelayed(zzfpb.zze, 200);
        }
    }
}
