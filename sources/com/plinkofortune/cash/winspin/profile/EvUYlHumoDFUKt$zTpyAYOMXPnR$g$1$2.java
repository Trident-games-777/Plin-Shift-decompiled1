package com.plinkofortune.cash.winspin.profile;

import androidx.activity.result.ActivityResultLauncher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* compiled from: EvUYlHumoDFU.kt */
final class EvUYlHumoDFUKt$zTpyAYOMXPnR$g$1$2 implements Function1<Throwable, Unit> {
    final /* synthetic */ ActivityResultLauncher<String> $launcher;

    EvUYlHumoDFUKt$zTpyAYOMXPnR$g$1$2(ActivityResultLauncher<String> activityResultLauncher) {
        this.$launcher = activityResultLauncher;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        this.$launcher.unregister();
    }
}
