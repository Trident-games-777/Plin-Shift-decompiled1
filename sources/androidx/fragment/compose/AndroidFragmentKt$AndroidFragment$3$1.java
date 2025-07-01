package androidx.fragment.compose;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.State;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "T", "Landroidx/fragment/app/Fragment;", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidFragment.kt */
final class AndroidFragmentKt$AndroidFragment$3$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ Bundle $arguments;
    final /* synthetic */ Class<T> $clazz;
    final /* synthetic */ FragmentContainerViewFactory $containerFactory;
    final /* synthetic */ Context $context;
    final /* synthetic */ FragmentManager $fragmentManager;
    final /* synthetic */ FragmentState $fragmentState;
    final /* synthetic */ int $hashKey;
    final /* synthetic */ State<Function1<T, Unit>> $updateCallback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidFragmentKt$AndroidFragment$3$1(FragmentManager fragmentManager, FragmentContainerViewFactory fragmentContainerViewFactory, Context context, Class<T> cls, State<? extends Function1<? super T, Unit>> state, FragmentState fragmentState, Bundle bundle, int i) {
        super(1);
        this.$fragmentManager = fragmentManager;
        this.$containerFactory = fragmentContainerViewFactory;
        this.$context = context;
        this.$clazz = cls;
        this.$updateCallback = state;
        this.$fragmentState = fragmentState;
        this.$arguments = bundle;
        this.$hashKey = i;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Fragment findFragmentById = this.$fragmentManager.findFragmentById(this.$containerFactory.getContainer().getId());
        if (findFragmentById == null) {
            findFragmentById = this.$fragmentManager.getFragmentFactory().instantiate(this.$context.getClassLoader(), this.$clazz.getName());
            FragmentState fragmentState = this.$fragmentState;
            Bundle bundle = this.$arguments;
            FragmentManager fragmentManager = this.$fragmentManager;
            FragmentContainerViewFactory fragmentContainerViewFactory = this.$containerFactory;
            int i = this.$hashKey;
            findFragmentById.setInitialSavedState(fragmentState.getState$fragment_compose_release().getValue());
            findFragmentById.setArguments(bundle);
            FragmentTransaction add = fragmentManager.beginTransaction().setReorderingAllowed(true).add((ViewGroup) fragmentContainerViewFactory.getContainer(), findFragmentById, String.valueOf(i));
            if (fragmentManager.isStateSaved()) {
                booleanRef.element = true;
                findFragmentById.getLifecycle().addObserver(new AndroidFragmentKt$AndroidFragment$3$1$fragment$1$1(booleanRef, findFragmentById));
                add.commitNowAllowingStateLoss();
            } else {
                add.commitNow();
            }
        }
        this.$fragmentManager.onContainerAvailable(this.$containerFactory.getContainer());
        Intrinsics.checkNotNull(findFragmentById, "null cannot be cast to non-null type T of androidx.fragment.compose.AndroidFragmentKt.AndroidFragment$lambda$2");
        this.$updateCallback.getValue().invoke(findFragmentById);
        return new AndroidFragmentKt$AndroidFragment$3$1$invoke$$inlined$onDispose$1(this.$fragmentManager, findFragmentById, this.$fragmentState, booleanRef);
    }
}
