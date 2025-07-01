package androidx.fragment.compose;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/MutableState;", "Landroidx/fragment/app/Fragment$SavedState;", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "Landroidx/fragment/compose/FragmentState;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: FragmentState.kt */
final class FragmentStateKt$fragmentStateSaver$1 extends Lambda implements Function2<SaverScope, FragmentState, MutableState<Fragment.SavedState>> {
    public static final FragmentStateKt$fragmentStateSaver$1 INSTANCE = new FragmentStateKt$fragmentStateSaver$1();

    FragmentStateKt$fragmentStateSaver$1() {
        super(2);
    }

    public final MutableState<Fragment.SavedState> invoke(SaverScope saverScope, FragmentState fragmentState) {
        return fragmentState.getState$fragment_compose_release();
    }
}
