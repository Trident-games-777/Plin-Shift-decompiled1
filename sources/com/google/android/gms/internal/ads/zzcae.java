package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcae extends ScheduledThreadPoolExecutor {
    zzcae(int i, ThreadFactory threadFactory) {
        super(3, threadFactory);
    }
}
