package com.plinkofortune.cash.winspin.profile;

import androidx.activity.result.ActivityResultCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* compiled from: EvUYlHumoDFU.kt */
final class EvUYlHumoDFUKt$zTpyAYOMXPnR$g$1$launcher$1<O> implements ActivityResultCallback {
    final /* synthetic */ CancellableContinuation<Boolean> $continuation;

    EvUYlHumoDFUKt$zTpyAYOMXPnR$g$1$launcher$1(CancellableContinuation<? super Boolean> cancellableContinuation) {
        this.$continuation = cancellableContinuation;
    }

    public /* bridge */ /* synthetic */ void onActivityResult(Object obj) {
        onActivityResult(((Boolean) obj).booleanValue());
    }

    public final void onActivityResult(boolean z) {
        if (this.$continuation.isActive()) {
            this.$continuation.resume(Boolean.valueOf(z), (Function1<? super Throwable, Unit>) AnonymousClass1.INSTANCE);
        }
    }
}
