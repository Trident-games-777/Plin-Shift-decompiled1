package androidx.lifecycle.viewmodel.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a<\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\b\u0004\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\u0006\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0007"}, d2 = {"synchronized", "T", "lock", "Landroidx/lifecycle/viewmodel/internal/SynchronizedObject;", "action", "Lkotlin/Function0;", "(Landroidx/lifecycle/viewmodel/internal/SynchronizedObject;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "lifecycle-viewmodel_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SynchronizedObject.kt */
public final class SynchronizedObjectKt {
    /* renamed from: synchronized  reason: not valid java name */
    public static final <T> T m7440synchronized(SynchronizedObject synchronizedObject, Function0<? extends T> function0) {
        T invoke;
        Intrinsics.checkNotNullParameter(synchronizedObject, "lock");
        Intrinsics.checkNotNullParameter(function0, "action");
        synchronized (synchronizedObject) {
            invoke = function0.invoke();
        }
        return invoke;
    }
}
