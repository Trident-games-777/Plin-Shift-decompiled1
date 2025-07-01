package androidx.lifecycle.compose;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LifecycleEffect.kt */
final class LifecycleEffectKt$LifecycleStartEffectImpl$1$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ Function1<LifecycleStartStopEffectScope, LifecycleStopOrDisposeEffectResult> $effects;
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ LifecycleStartStopEffectScope $scope;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LifecycleEffect.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                androidx.lifecycle.Lifecycle$Event[] r0 = androidx.lifecycle.Lifecycle.Event.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_START     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_STOP     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleStartEffectImpl$1$1.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LifecycleEffectKt$LifecycleStartEffectImpl$1$1(LifecycleOwner lifecycleOwner, LifecycleStartStopEffectScope lifecycleStartStopEffectScope, Function1<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> function1) {
        super(1);
        this.$lifecycleOwner = lifecycleOwner;
        this.$scope = lifecycleStartStopEffectScope;
        this.$effects = function1;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        LifecycleEffectKt$LifecycleStartEffectImpl$1$1$$ExternalSyntheticLambda0 lifecycleEffectKt$LifecycleStartEffectImpl$1$1$$ExternalSyntheticLambda0 = new LifecycleEffectKt$LifecycleStartEffectImpl$1$1$$ExternalSyntheticLambda0(this.$scope, objectRef, this.$effects);
        this.$lifecycleOwner.getLifecycle().addObserver(lifecycleEffectKt$LifecycleStartEffectImpl$1$1$$ExternalSyntheticLambda0);
        return new LifecycleEffectKt$LifecycleStartEffectImpl$1$1$invoke$$inlined$onDispose$1(this.$lifecycleOwner, lifecycleEffectKt$LifecycleStartEffectImpl$1$1$$ExternalSyntheticLambda0, objectRef);
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$1(LifecycleStartStopEffectScope lifecycleStartStopEffectScope, Ref.ObjectRef objectRef, Function1 function1, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i == 1) {
            objectRef.element = function1.invoke(lifecycleStartStopEffectScope);
        } else if (i == 2) {
            LifecycleStopOrDisposeEffectResult lifecycleStopOrDisposeEffectResult = (LifecycleStopOrDisposeEffectResult) objectRef.element;
            if (lifecycleStopOrDisposeEffectResult != null) {
                lifecycleStopOrDisposeEffectResult.runStopOrDisposeEffect();
            }
            objectRef.element = null;
        }
    }
}
