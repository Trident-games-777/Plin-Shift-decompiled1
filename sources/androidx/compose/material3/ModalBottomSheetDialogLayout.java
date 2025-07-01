package androidx.compose.material3;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.window.DialogWindowProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.time.DurationKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0002-.BG\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\r\u0010$\u001a\u00020\u000bH\u0017¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u000bH\u0002J\b\u0010'\u001a\u00020\u000bH\u0002J\b\u0010(\u001a\u00020\u000bH\u0014J\b\u0010)\u001a\u00020\u000bH\u0014J&\u0010\u001a\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+2\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\b\u0016¢\u0006\u0002\u0010,R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000RA\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\b\u00162\u0011\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\b\u00168B@BX\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006/"}, d2 = {"Landroidx/compose/material3/ModalBottomSheetDialogLayout;", "Landroidx/compose/ui/platform/AbstractComposeView;", "Landroidx/compose/ui/window/DialogWindowProvider;", "context", "Landroid/content/Context;", "window", "Landroid/view/Window;", "shouldDismissOnBackPress", "", "onDismissRequest", "Lkotlin/Function0;", "", "predictiveBackProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroid/content/Context;Landroid/view/Window;ZLkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/Animatable;Lkotlinx/coroutines/CoroutineScope;)V", "backCallback", "", "<set-?>", "Landroidx/compose/runtime/Composable;", "content", "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "content$delegate", "Landroidx/compose/runtime/MutableState;", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow", "()Z", "getShouldDismissOnBackPress", "getWindow", "()Landroid/view/Window;", "Content", "(Landroidx/compose/runtime/Composer;I)V", "maybeRegisterBackCallback", "maybeUnregisterBackCallback", "onAttachedToWindow", "onDetachedFromWindow", "parent", "Landroidx/compose/runtime/CompositionContext;", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "Api33Impl", "Api34Impl", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.android.kt */
final class ModalBottomSheetDialogLayout extends AbstractComposeView implements DialogWindowProvider {
    private Object backCallback;
    private final MutableState content$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1930getLambda2$material3_release(), (SnapshotMutationPolicy) null, 2, (Object) null);
    private final Function0<Unit> onDismissRequest;
    private final Animatable<Float, AnimationVector1D> predictiveBackProgress;
    private final CoroutineScope scope;
    private boolean shouldCreateCompositionOnAttachedToWindow;
    private final boolean shouldDismissOnBackPress;
    private final Window window;

    public Window getWindow() {
        return this.window;
    }

    public final boolean getShouldDismissOnBackPress() {
        return this.shouldDismissOnBackPress;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModalBottomSheetDialogLayout(Context context, Window window2, boolean z, Function0<Unit> function0, Animatable<Float, AnimationVector1D> animatable, CoroutineScope coroutineScope) {
        super(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        this.window = window2;
        this.shouldDismissOnBackPress = z;
        this.onDismissRequest = function0;
        this.predictiveBackProgress = animatable;
        this.scope = coroutineScope;
    }

    private final Function2<Composer, Integer, Unit> getContent() {
        return (Function2) this.content$delegate.getValue();
    }

    private final void setContent(Function2<? super Composer, ? super Integer, Unit> function2) {
        this.content$delegate.setValue(function2);
    }

    /* access modifiers changed from: protected */
    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    public final void setContent(CompositionContext compositionContext, Function2<? super Composer, ? super Integer, Unit> function2) {
        setParentCompositionContext(compositionContext);
        setContent(function2);
        this.shouldCreateCompositionOnAttachedToWindow = true;
        createComposition();
    }

    public void Content(Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(576708319);
        ComposerKt.sourceInformation(startRestartGroup, "C(Content)353@14383L9:ModalBottomSheet.android.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(576708319, i2, -1, "androidx.compose.material3.ModalBottomSheetDialogLayout.Content (ModalBottomSheet.android.kt:352)");
            }
            getContent().invoke(startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ModalBottomSheetDialogLayout$Content$4(this, i));
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        maybeRegisterBackCallback();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        maybeUnregisterBackCallback();
    }

    private final void maybeRegisterBackCallback() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (this.shouldDismissOnBackPress && Build.VERSION.SDK_INT >= 33) {
            if (this.backCallback == null) {
                if (Build.VERSION.SDK_INT >= 34) {
                    onBackInvokedCallback = (OnBackInvokedCallback) Api34Impl.createBackCallback(this.onDismissRequest, this.predictiveBackProgress, this.scope);
                } else {
                    onBackInvokedCallback = Api33Impl.createBackCallback(this.onDismissRequest);
                }
                this.backCallback = onBackInvokedCallback;
            }
            Api33Impl.maybeRegisterBackCallback(this, this.backCallback);
        }
    }

    private final void maybeUnregisterBackCallback() {
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.maybeUnregisterBackCallback(this, this.backCallback);
        }
        this.backCallback = null;
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\rH\u0007¨\u0006\u000e"}, d2 = {"Landroidx/compose/material3/ModalBottomSheetDialogLayout$Api34Impl;", "", "()V", "createBackCallback", "Landroid/window/OnBackAnimationCallback;", "onDismissRequest", "Lkotlin/Function0;", "", "predictiveBackProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ModalBottomSheet.android.kt */
    private static final class Api34Impl {
        public static final Api34Impl INSTANCE = new Api34Impl();

        private Api34Impl() {
        }

        @JvmStatic
        public static final OnBackAnimationCallback createBackCallback(Function0<Unit> function0, Animatable<Float, AnimationVector1D> animatable, CoroutineScope coroutineScope) {
            return new ModalBottomSheetDialogLayout$Api34Impl$createBackCallback$1(coroutineScope, animatable, function0);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0007J\u001a\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/material3/ModalBottomSheetDialogLayout$Api33Impl;", "", "()V", "createBackCallback", "Landroid/window/OnBackInvokedCallback;", "onDismissRequest", "Lkotlin/Function0;", "", "maybeRegisterBackCallback", "view", "Landroid/view/View;", "backCallback", "maybeUnregisterBackCallback", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ModalBottomSheet.android.kt */
    private static final class Api33Impl {
        public static final Api33Impl INSTANCE = new Api33Impl();

        private Api33Impl() {
        }

        @JvmStatic
        public static final OnBackInvokedCallback createBackCallback(Function0<Unit> function0) {
            return new ModalBottomSheetDialogLayout$Api33Impl$$ExternalSyntheticLambda0(function0);
        }

        /* access modifiers changed from: private */
        public static final void createBackCallback$lambda$0(Function0 function0) {
            function0.invoke();
        }

        @JvmStatic
        public static final void maybeRegisterBackCallback(View view, Object obj) {
            OnBackInvokedDispatcher findOnBackInvokedDispatcher;
            if ((obj instanceof OnBackInvokedCallback) && (findOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) != null) {
                findOnBackInvokedDispatcher.registerOnBackInvokedCallback(DurationKt.NANOS_IN_MILLIS, (OnBackInvokedCallback) obj);
            }
        }

        @JvmStatic
        public static final void maybeUnregisterBackCallback(View view, Object obj) {
            OnBackInvokedDispatcher findOnBackInvokedDispatcher;
            if ((obj instanceof OnBackInvokedCallback) && (findOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) != null) {
                findOnBackInvokedDispatcher.unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj);
            }
        }
    }
}
