package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzem implements ThreadFactory {
    public final /* synthetic */ String zza = "ExoPlayer:AudioTrackReleaseThread";

    public /* synthetic */ zzem(String str) {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.zza);
    }
}
