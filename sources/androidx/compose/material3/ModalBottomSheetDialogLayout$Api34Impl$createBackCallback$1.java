package androidx.compose.material3;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"androidx/compose/material3/ModalBottomSheetDialogLayout$Api34Impl$createBackCallback$1", "Landroid/window/OnBackAnimationCallback;", "onBackCancelled", "", "onBackInvoked", "onBackProgressed", "backEvent", "Landroid/window/BackEvent;", "onBackStarted", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.android.kt */
public final class ModalBottomSheetDialogLayout$Api34Impl$createBackCallback$1 implements OnBackAnimationCallback {
    final /* synthetic */ Function0<Unit> $onDismissRequest;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $predictiveBackProgress;
    final /* synthetic */ CoroutineScope $scope;

    ModalBottomSheetDialogLayout$Api34Impl$createBackCallback$1(CoroutineScope coroutineScope, Animatable<Float, AnimationVector1D> animatable, Function0<Unit> function0) {
        this.$scope = coroutineScope;
        this.$predictiveBackProgress = animatable;
        this.$onDismissRequest = function0;
    }

    public void onBackStarted(BackEvent backEvent) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.$scope, (CoroutineContext) null, (CoroutineStart) null, new ModalBottomSheetDialogLayout$Api34Impl$createBackCallback$1$onBackStarted$1(this.$predictiveBackProgress, backEvent, (Continuation<? super ModalBottomSheetDialogLayout$Api34Impl$createBackCallback$1$onBackStarted$1>) null), 3, (Object) null);
    }

    public void onBackProgressed(BackEvent backEvent) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.$scope, (CoroutineContext) null, (CoroutineStart) null, new ModalBottomSheetDialogLayout$Api34Impl$createBackCallback$1$onBackProgressed$1(this.$predictiveBackProgress, backEvent, (Continuation<? super ModalBottomSheetDialogLayout$Api34Impl$createBackCallback$1$onBackProgressed$1>) null), 3, (Object) null);
    }

    public void onBackInvoked() {
        this.$onDismissRequest.invoke();
    }

    public void onBackCancelled() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.$scope, (CoroutineContext) null, (CoroutineStart) null, new ModalBottomSheetDialogLayout$Api34Impl$createBackCallback$1$onBackCancelled$1(this.$predictiveBackProgress, (Continuation<? super ModalBottomSheetDialogLayout$Api34Impl$createBackCallback$1$onBackCancelled$1>) null), 3, (Object) null);
    }
}
