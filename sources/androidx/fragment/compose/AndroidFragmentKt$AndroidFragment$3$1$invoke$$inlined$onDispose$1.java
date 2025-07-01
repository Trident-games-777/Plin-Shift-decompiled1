package androidx.fragment.compose;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Effects.kt */
public final class AndroidFragmentKt$AndroidFragment$3$1$invoke$$inlined$onDispose$1 implements DisposableEffectResult {
    final /* synthetic */ Fragment $fragment$inlined;
    final /* synthetic */ FragmentManager $fragmentManager$inlined;
    final /* synthetic */ FragmentState $fragmentState$inlined;
    final /* synthetic */ Ref.BooleanRef $removeEvenIfStateIsSaved$inlined;

    public AndroidFragmentKt$AndroidFragment$3$1$invoke$$inlined$onDispose$1(FragmentManager fragmentManager, Fragment fragment, FragmentState fragmentState, Ref.BooleanRef booleanRef) {
        this.$fragmentManager$inlined = fragmentManager;
        this.$fragment$inlined = fragment;
        this.$fragmentState$inlined = fragmentState;
        this.$removeEvenIfStateIsSaved$inlined = booleanRef;
    }

    public void dispose() {
        this.$fragmentState$inlined.getState$fragment_compose_release().setValue(this.$fragmentManager$inlined.saveFragmentInstanceState(this.$fragment$inlined));
        if (this.$removeEvenIfStateIsSaved$inlined.element) {
            FragmentTransaction beginTransaction = this.$fragmentManager$inlined.beginTransaction();
            beginTransaction.remove(this.$fragment$inlined);
            beginTransaction.commitNowAllowingStateLoss();
        } else if (!this.$fragmentManager$inlined.isStateSaved()) {
            FragmentTransaction beginTransaction2 = this.$fragmentManager$inlined.beginTransaction();
            beginTransaction2.remove(this.$fragment$inlined);
            beginTransaction2.commitNow();
        }
    }
}
