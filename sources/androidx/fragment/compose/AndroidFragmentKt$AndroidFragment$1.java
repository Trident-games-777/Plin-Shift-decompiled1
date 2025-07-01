package androidx.fragment.compose;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
/* compiled from: AndroidFragment.kt */
public final class AndroidFragmentKt$AndroidFragment$1 extends Lambda implements Function1<T, Unit> {
    public static final AndroidFragmentKt$AndroidFragment$1 INSTANCE = new AndroidFragmentKt$AndroidFragment$1();

    static {
        Intrinsics.needClassReification();
    }

    public AndroidFragmentKt$AndroidFragment$1() {
        super(1);
    }

    public final void invoke(T t) {
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Fragment) obj);
        return Unit.INSTANCE;
    }
}
