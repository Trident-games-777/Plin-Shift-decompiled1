package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzfpl implements Continuation {
    public final Object then(Task task) {
        return Boolean.valueOf(task.isSuccessful());
    }
}
