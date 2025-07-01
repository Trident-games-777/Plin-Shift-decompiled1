package androidx.activity.compose;

import androidx.activity.BackEventCompat;
import androidx.activity.OnBackPressedCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001BN\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00127\u0010\u0006\u001a3\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\t0\b¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0007¢\u0006\u0002\u0010\u0010J\b\u0010\u001c\u001a\u00020\u000eH\u0016J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\tH\u0016J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\tH\u0016J\u000e\u0010!\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003RM\u0010\u0006\u001a3\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\t0\b¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0007X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Landroidx/activity/compose/PredictiveBackHandlerCallback;", "Landroidx/activity/OnBackPressedCallback;", "enabled", "", "onBackScope", "Lkotlinx/coroutines/CoroutineScope;", "currentOnBack", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/activity/BackEventCompat;", "Lkotlin/ParameterName;", "name", "progress", "Lkotlin/coroutines/Continuation;", "", "", "(ZLkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function2;)V", "getCurrentOnBack", "()Lkotlin/jvm/functions/Function2;", "setCurrentOnBack", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "onBackInstance", "Landroidx/activity/compose/OnBackInstance;", "getOnBackScope", "()Lkotlinx/coroutines/CoroutineScope;", "setOnBackScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "handleOnBackCancelled", "handleOnBackPressed", "handleOnBackProgressed", "backEvent", "handleOnBackStarted", "setIsEnabled", "activity-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PredictiveBackHandler.kt */
final class PredictiveBackHandlerCallback extends OnBackPressedCallback {
    private Function2<? super Flow<BackEventCompat>, ? super Continuation<? super Unit>, ? extends Object> currentOnBack;
    private OnBackInstance onBackInstance;
    private CoroutineScope onBackScope;

    public final CoroutineScope getOnBackScope() {
        return this.onBackScope;
    }

    public final void setOnBackScope(CoroutineScope coroutineScope) {
        this.onBackScope = coroutineScope;
    }

    public final Function2<Flow<BackEventCompat>, Continuation<? super Unit>, Object> getCurrentOnBack() {
        return this.currentOnBack;
    }

    public final void setCurrentOnBack(Function2<? super Flow<BackEventCompat>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.currentOnBack = function2;
    }

    public PredictiveBackHandlerCallback(boolean z, CoroutineScope coroutineScope, Function2<? super Flow<BackEventCompat>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        super(z);
        this.onBackScope = coroutineScope;
        this.currentOnBack = function2;
    }

    public final void setIsEnabled(boolean z) {
        OnBackInstance onBackInstance2;
        if (!z && isEnabled() && (onBackInstance2 = this.onBackInstance) != null) {
            onBackInstance2.cancel();
        }
        setEnabled(z);
    }

    public void handleOnBackStarted(BackEventCompat backEventCompat) {
        super.handleOnBackStarted(backEventCompat);
        OnBackInstance onBackInstance2 = this.onBackInstance;
        if (onBackInstance2 != null) {
            onBackInstance2.cancel();
        }
        if (isEnabled()) {
            this.onBackInstance = new OnBackInstance(this.onBackScope, true, this.currentOnBack, this);
        }
    }

    public void handleOnBackProgressed(BackEventCompat backEventCompat) {
        super.handleOnBackProgressed(backEventCompat);
        OnBackInstance onBackInstance2 = this.onBackInstance;
        if (onBackInstance2 != null) {
            ChannelResult.m9357boximpl(onBackInstance2.m7sendJP2dKIU(backEventCompat));
        }
    }

    public void handleOnBackPressed() {
        OnBackInstance onBackInstance2 = this.onBackInstance;
        if (onBackInstance2 != null && !onBackInstance2.isPredictiveBack()) {
            onBackInstance2.cancel();
            this.onBackInstance = null;
        }
        if (this.onBackInstance == null) {
            this.onBackInstance = new OnBackInstance(this.onBackScope, false, this.currentOnBack, this);
        }
        OnBackInstance onBackInstance3 = this.onBackInstance;
        if (onBackInstance3 != null) {
            onBackInstance3.close();
        }
        OnBackInstance onBackInstance4 = this.onBackInstance;
        if (onBackInstance4 != null) {
            onBackInstance4.setPredictiveBack(false);
        }
    }

    public void handleOnBackCancelled() {
        super.handleOnBackCancelled();
        OnBackInstance onBackInstance2 = this.onBackInstance;
        if (onBackInstance2 != null) {
            onBackInstance2.cancel();
        }
        OnBackInstance onBackInstance3 = this.onBackInstance;
        if (onBackInstance3 != null) {
            onBackInstance3.setPredictiveBack(false);
        }
    }
}
