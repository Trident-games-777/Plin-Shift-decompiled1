package androidx.lifecycle.compose;

import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/lifecycle/LifecycleOwner;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LocalLifecycleOwner.android.kt */
final class LocalLifecycleOwnerKt$LocalLifecycleOwner$1$1 extends Lambda implements Function0<LifecycleOwner> {
    public static final LocalLifecycleOwnerKt$LocalLifecycleOwner$1$1 INSTANCE = new LocalLifecycleOwnerKt$LocalLifecycleOwner$1$1();

    LocalLifecycleOwnerKt$LocalLifecycleOwner$1$1() {
        super(0);
    }

    public final LifecycleOwner invoke() {
        throw new IllegalStateException("CompositionLocal LocalLifecycleOwner not present".toString());
    }
}
