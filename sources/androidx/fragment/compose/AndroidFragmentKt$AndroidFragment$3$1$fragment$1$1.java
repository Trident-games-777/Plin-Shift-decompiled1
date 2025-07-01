package androidx.fragment.compose;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"androidx/fragment/compose/AndroidFragmentKt$AndroidFragment$3$1$fragment$1$1", "Landroidx/lifecycle/DefaultLifecycleObserver;", "onStart", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "fragment-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidFragment.kt */
public final class AndroidFragmentKt$AndroidFragment$3$1$fragment$1$1 implements DefaultLifecycleObserver {
    final /* synthetic */ Ref.BooleanRef $removeEvenIfStateIsSaved;
    final /* synthetic */ Fragment $this_apply;

    AndroidFragmentKt$AndroidFragment$3$1$fragment$1$1(Ref.BooleanRef booleanRef, Fragment fragment) {
        this.$removeEvenIfStateIsSaved = booleanRef;
        this.$this_apply = fragment;
    }

    public void onStart(LifecycleOwner lifecycleOwner) {
        this.$removeEvenIfStateIsSaved.element = false;
        this.$this_apply.getLifecycle().removeObserver(this);
    }
}
