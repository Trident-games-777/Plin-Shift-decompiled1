package androidx.fragment.compose;

import androidx.compose.runtime.MutableState;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/fragment/compose/FragmentState;", "it", "Landroidx/compose/runtime/MutableState;", "Landroidx/fragment/app/Fragment$SavedState;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: FragmentState.kt */
final class FragmentStateKt$fragmentStateSaver$2 extends Lambda implements Function1<MutableState<Fragment.SavedState>, FragmentState> {
    public static final FragmentStateKt$fragmentStateSaver$2 INSTANCE = new FragmentStateKt$fragmentStateSaver$2();

    FragmentStateKt$fragmentStateSaver$2() {
        super(1);
    }

    public final FragmentState invoke(MutableState<Fragment.SavedState> mutableState) {
        return new FragmentState(mutableState);
    }
}
