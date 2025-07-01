package com.plinkofortune.cash.winspin.profile;

import androidx.activity.result.ActivityResultRegistry;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.plinkofortune.cash.winspin.profile.EvUYlHumoDFUKt", f = "EvUYlHumoDFU.kt", i = {0}, l = {40}, m = "zTpyAYOMXPnR", n = {"registry"}, s = {"L$0"})
/* compiled from: EvUYlHumoDFU.kt */
final class EvUYlHumoDFUKt$zTpyAYOMXPnR$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    EvUYlHumoDFUKt$zTpyAYOMXPnR$1(Continuation<? super EvUYlHumoDFUKt$zTpyAYOMXPnR$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return EvUYlHumoDFUKt.zTpyAYOMXPnR((ActivityResultRegistry) null, this);
    }
}
