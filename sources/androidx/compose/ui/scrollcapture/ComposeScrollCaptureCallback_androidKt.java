package androidx.compose.ui.scrollcapture;

import android.os.CancellationSignal;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aB\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\n¢\u0006\u0002\b\u000eH\u0002¢\u0006\u0002\u0010\u000f\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"DEBUG", "", "TAG", "", "launchWithCancellationSignal", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;", "signal", "Landroid/os/CancellationSignal;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Landroid/os/CancellationSignal;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ComposeScrollCaptureCallback.android.kt */
public final class ComposeScrollCaptureCallback_androidKt {
    private static final boolean DEBUG = false;
    private static final String TAG = "ScrollCapture";

    /* access modifiers changed from: private */
    public static final Job launchWithCancellationSignal(CoroutineScope coroutineScope, CancellationSignal cancellationSignal, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Job launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, function2, 3, (Object) null);
        launch$default.invokeOnCompletion(new ComposeScrollCaptureCallback_androidKt$launchWithCancellationSignal$1(cancellationSignal));
        cancellationSignal.setOnCancelListener(new ComposeScrollCaptureCallback_androidKt$$ExternalSyntheticLambda0(launch$default));
        return launch$default;
    }

    /* access modifiers changed from: private */
    public static final void launchWithCancellationSignal$lambda$0(Job job) {
        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
    }
}
