package coil3.compose;

import android.content.Context;
import android.os.Trace;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import coil3.Image;
import coil3.ImageLoader;
import coil3.compose.internal.UtilsKt;
import coil3.request.ErrorResult;
import coil3.request.ImageRequest;
import coil3.request.ImageResult;
import coil3.request.SuccessResult;
import coil3.size.Precision;
import coil3.size.SizeResolver;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 j2\u00020\u00012\u00020\u0002:\u0003hijB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\f\u0010X\u001a\u00020\u000b*\u00020YH\u0014J\u0010\u0010Z\u001a\u00020[2\u0006\u0010\u0015\u001a\u00020\u0014H\u0014J\u0012\u0010\\\u001a\u00020[2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010]\u001a\u00020\u000bH\u0016J\b\u0010^\u001a\u00020\u000bH\u0016J\b\u0010_\u001a\u00020\u000bH\u0016J\u0006\u0010`\u001a\u00020\u000bJ\u0018\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020b2\u0006\u0010d\u001a\u00020[H\u0002J\u0010\u0010e\u001a\u00020\u000b2\u0006\u0010S\u001a\u000200H\u0002J\f\u0010f\u001a\u000200*\u00020gH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0004¢\u0006\u0002\n\u0000R/\u0010\r\u001a\u0004\u0018\u00010\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u00018B@BX\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u00148B@BX\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R/\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\f\u001a\u0004\u0018\u00010\u001c8B@BX\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0013\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010%\u001a\u0004\u0018\u00010$2\b\u0010#\u001a\u0004\u0018\u00010$@BX\u000e¢\u0006\b\n\u0000\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R&\u0010.\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u0002000/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R(\u00105\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u000b\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00102\"\u0004\b7\u00104R\u001a\u00108\u001a\u000209X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010>\u001a\u00020?X\u000e¢\u0006\u0010\n\u0002\u0010D\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010E\u001a\u0004\u0018\u00010FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00040LX\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040O¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0014\u0010R\u001a\b\u0012\u0004\u0012\u0002000LX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010S\u001a\b\u0012\u0004\u0012\u0002000O¢\u0006\b\n\u0000\u001a\u0004\bT\u0010QR\u0014\u0010U\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\bV\u0010W¨\u0006k"}, d2 = {"Lcoil3/compose/AsyncImagePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/runtime/RememberObserver;", "input", "Lcoil3/compose/AsyncImagePainter$Input;", "<init>", "(Lcoil3/compose/AsyncImagePainter$Input;)V", "drawSize", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Landroidx/compose/ui/geometry/Size;", "restartSignal", "", "<set-?>", "painter", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "painter$delegate", "Landroidx/compose/runtime/MutableState;", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "alpha$delegate", "Landroidx/compose/runtime/MutableFloatState;", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "colorFilter$delegate", "value", "Lkotlinx/coroutines/Job;", "rememberJob", "setRememberJob", "(Lkotlinx/coroutines/Job;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope$coil_compose_core_release", "()Lkotlinx/coroutines/CoroutineScope;", "setScope$coil_compose_core_release", "(Lkotlinx/coroutines/CoroutineScope;)V", "transform", "Lkotlin/Function1;", "Lcoil3/compose/AsyncImagePainter$State;", "getTransform$coil_compose_core_release", "()Lkotlin/jvm/functions/Function1;", "setTransform$coil_compose_core_release", "(Lkotlin/jvm/functions/Function1;)V", "onState", "getOnState$coil_compose_core_release", "setOnState$coil_compose_core_release", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "getContentScale$coil_compose_core_release", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale$coil_compose_core_release", "(Landroidx/compose/ui/layout/ContentScale;)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "getFilterQuality-f-v9h1I$coil_compose_core_release", "()I", "setFilterQuality-vDHp3xo$coil_compose_core_release", "(I)V", "I", "previewHandler", "Lcoil3/compose/AsyncImagePreviewHandler;", "getPreviewHandler$coil_compose_core_release", "()Lcoil3/compose/AsyncImagePreviewHandler;", "setPreviewHandler$coil_compose_core_release", "(Lcoil3/compose/AsyncImagePreviewHandler;)V", "_input", "Lkotlinx/coroutines/flow/MutableStateFlow;", "get_input$coil_compose_core_release", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "getInput", "()Lkotlinx/coroutines/flow/StateFlow;", "_state", "state", "getState", "intrinsicSize", "getIntrinsicSize-NH-jbRc", "()J", "onDraw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "applyAlpha", "", "applyColorFilter", "onRemembered", "onForgotten", "onAbandoned", "restart", "updateRequest", "Lcoil3/request/ImageRequest;", "request", "isPreview", "updateState", "toState", "Lcoil3/request/ImageResult;", "Input", "State", "Companion", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: AsyncImagePainter.kt */
public final class AsyncImagePainter extends Painter implements RememberObserver {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Function1<State, State> DefaultTransform = new AsyncImagePainter$$ExternalSyntheticLambda0();
    private final MutableStateFlow<Input> _input;
    private final MutableStateFlow<State> _state;
    private final MutableFloatState alpha$delegate;
    private final MutableState colorFilter$delegate;
    private ContentScale contentScale;
    private final MutableSharedFlow<Size> drawSize = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, (Object) null);
    private int filterQuality;
    private final StateFlow<Input> input;
    private Function1<? super State, Unit> onState;
    private final MutableState painter$delegate;
    private AsyncImagePreviewHandler previewHandler;
    private Job rememberJob;
    /* access modifiers changed from: private */
    public final MutableSharedFlow<Unit> restartSignal;
    public CoroutineScope scope;
    private final StateFlow<State> state;
    private Function1<? super State, ? extends State> transform;

    /* access modifiers changed from: private */
    public static final State DefaultTransform$lambda$5(State state2) {
        return state2;
    }

    public AsyncImagePainter(Input input2) {
        MutableSharedFlow<Unit> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, (Object) null);
        MutableSharedFlow$default.tryEmit(Unit.INSTANCE);
        this.restartSignal = MutableSharedFlow$default;
        this.painter$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.alpha$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);
        this.colorFilter$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.transform = DefaultTransform;
        this.contentScale = ContentScale.Companion.getFit();
        this.filterQuality = DrawScope.Companion.m4868getDefaultFilterQualityfv9h1I();
        MutableStateFlow<Input> MutableStateFlow = StateFlowKt.MutableStateFlow(input2);
        this._input = MutableStateFlow;
        this.input = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<State> MutableStateFlow2 = StateFlowKt.MutableStateFlow(State.Empty.INSTANCE);
        this._state = MutableStateFlow2;
        this.state = FlowKt.asStateFlow(MutableStateFlow2);
    }

    private final Painter getPainter() {
        return (Painter) this.painter$delegate.getValue();
    }

    private final void setPainter(Painter painter) {
        this.painter$delegate.setValue(painter);
    }

    private final float getAlpha() {
        return this.alpha$delegate.getFloatValue();
    }

    private final void setAlpha(float f) {
        this.alpha$delegate.setFloatValue(f);
    }

    private final ColorFilter getColorFilter() {
        return (ColorFilter) this.colorFilter$delegate.getValue();
    }

    private final void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter$delegate.setValue(colorFilter);
    }

    private final void setRememberJob(Job job) {
        Job job2 = this.rememberJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.rememberJob = job;
    }

    public final CoroutineScope getScope$coil_compose_core_release() {
        CoroutineScope coroutineScope = this.scope;
        if (coroutineScope != null) {
            return coroutineScope;
        }
        Intrinsics.throwUninitializedPropertyAccessException("scope");
        return null;
    }

    public final void setScope$coil_compose_core_release(CoroutineScope coroutineScope) {
        this.scope = coroutineScope;
    }

    public final Function1<State, State> getTransform$coil_compose_core_release() {
        return this.transform;
    }

    public final void setTransform$coil_compose_core_release(Function1<? super State, ? extends State> function1) {
        this.transform = function1;
    }

    public final Function1<State, Unit> getOnState$coil_compose_core_release() {
        return this.onState;
    }

    public final void setOnState$coil_compose_core_release(Function1<? super State, Unit> function1) {
        this.onState = function1;
    }

    public final ContentScale getContentScale$coil_compose_core_release() {
        return this.contentScale;
    }

    public final void setContentScale$coil_compose_core_release(ContentScale contentScale2) {
        this.contentScale = contentScale2;
    }

    /* renamed from: getFilterQuality-f-v9h1I$coil_compose_core_release  reason: not valid java name */
    public final int m7460getFilterQualityfv9h1I$coil_compose_core_release() {
        return this.filterQuality;
    }

    /* renamed from: setFilterQuality-vDHp3xo$coil_compose_core_release  reason: not valid java name */
    public final void m7462setFilterQualityvDHp3xo$coil_compose_core_release(int i) {
        this.filterQuality = i;
    }

    public final AsyncImagePreviewHandler getPreviewHandler$coil_compose_core_release() {
        return this.previewHandler;
    }

    public final void setPreviewHandler$coil_compose_core_release(AsyncImagePreviewHandler asyncImagePreviewHandler) {
        this.previewHandler = asyncImagePreviewHandler;
    }

    public final MutableStateFlow<Input> get_input$coil_compose_core_release() {
        return this._input;
    }

    public final StateFlow<Input> getInput() {
        return this.input;
    }

    public final StateFlow<State> getState() {
        return this.state;
    }

    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public long m7461getIntrinsicSizeNHjbRc() {
        Painter painter = getPainter();
        return painter != null ? painter.m5044getIntrinsicSizeNHjbRc() : Size.Companion.m4064getUnspecifiedNHjbRc();
    }

    /* access modifiers changed from: protected */
    public void onDraw(DrawScope drawScope) {
        this.drawSize.tryEmit(Size.m4044boximpl(drawScope.m4865getSizeNHjbRc()));
        Painter painter = getPainter();
        if (painter != null) {
            painter.m5043drawx_KDEd0(drawScope, drawScope.m4865getSizeNHjbRc(), getAlpha(), getColorFilter());
        }
    }

    /* access modifiers changed from: protected */
    public boolean applyAlpha(float f) {
        setAlpha(f);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean applyColorFilter(ColorFilter colorFilter) {
        setColorFilter(colorFilter);
        return true;
    }

    public void onRemembered() {
        Trace.beginSection("AsyncImagePainter.onRemembered");
        try {
            Painter painter = getPainter();
            RememberObserver rememberObserver = painter instanceof RememberObserver ? (RememberObserver) painter : null;
            if (rememberObserver != null) {
                rememberObserver.onRemembered();
            }
            AsyncImagePreviewHandler asyncImagePreviewHandler = this.previewHandler;
            if (asyncImagePreviewHandler != null) {
                setRememberJob(BuildersKt__Builders_commonKt.launch$default(getScope$coil_compose_core_release(), Dispatchers.getUnconfined(), (CoroutineStart) null, new AsyncImagePainter$onRemembered$1$1(this, asyncImagePreviewHandler, (Continuation<? super AsyncImagePainter$onRemembered$1$1>) null), 2, (Object) null));
            } else {
                setRememberJob(BuildersKt__Builders_commonKt.launch$default(getScope$coil_compose_core_release(), UtilsKt.getSafeImmediateMainDispatcher(), (CoroutineStart) null, new AsyncImagePainter$onRemembered$1$2(this, (Continuation<? super AsyncImagePainter$onRemembered$1$2>) null), 2, (Object) null));
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [androidx.compose.ui.graphics.painter.Painter] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onForgotten() {
        /*
            r3 = this;
            r0 = 0
            r3.setRememberJob(r0)
            androidx.compose.ui.graphics.painter.Painter r1 = r3.getPainter()
            boolean r2 = r1 instanceof androidx.compose.runtime.RememberObserver
            if (r2 == 0) goto L_0x000f
            r0 = r1
            androidx.compose.runtime.RememberObserver r0 = (androidx.compose.runtime.RememberObserver) r0
        L_0x000f:
            if (r0 == 0) goto L_0x0014
            r0.onForgotten()
        L_0x0014:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.compose.AsyncImagePainter.onForgotten():void");
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [androidx.compose.ui.graphics.painter.Painter] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAbandoned() {
        /*
            r3 = this;
            r0 = 0
            r3.setRememberJob(r0)
            androidx.compose.ui.graphics.painter.Painter r1 = r3.getPainter()
            boolean r2 = r1 instanceof androidx.compose.runtime.RememberObserver
            if (r2 == 0) goto L_0x000f
            r0 = r1
            androidx.compose.runtime.RememberObserver r0 = (androidx.compose.runtime.RememberObserver) r0
        L_0x000f:
            if (r0 == 0) goto L_0x0014
            r0.onAbandoned()
        L_0x0014:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.compose.AsyncImagePainter.onAbandoned():void");
    }

    public final void restart() {
        this.restartSignal.tryEmit(Unit.INSTANCE);
    }

    /* access modifiers changed from: private */
    public final ImageRequest updateRequest(ImageRequest imageRequest, boolean z) {
        SizeResolver sizeResolver = imageRequest.getSizeResolver();
        if (sizeResolver instanceof DrawScopeSizeResolver) {
            ((DrawScopeSizeResolver) sizeResolver).connect(this.drawSize);
        }
        ImageRequest.Builder target = ImageRequest.newBuilder$default(imageRequest, (Context) null, 1, (Object) null).target(new AsyncImagePainter$updateRequest$$inlined$target$default$1(imageRequest, this));
        if (imageRequest.getDefined().getSizeResolver() == null) {
            target.size(SizeResolver.ORIGINAL);
        }
        if (imageRequest.getDefined().getScale() == null) {
            target.scale(UtilsKt.toScale(this.contentScale));
        }
        if (imageRequest.getDefined().getPrecision() == null) {
            target.precision(Precision.INEXACT);
        }
        if (z) {
            target.coroutineContext(EmptyCoroutineContext.INSTANCE);
        }
        return target.build();
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [androidx.compose.ui.graphics.painter.Painter] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateState(coil3.compose.AsyncImagePainter.State r4) {
        /*
            r3 = this;
            kotlinx.coroutines.flow.MutableStateFlow<coil3.compose.AsyncImagePainter$State> r0 = r3._state
            java.lang.Object r0 = r0.getValue()
            coil3.compose.AsyncImagePainter$State r0 = (coil3.compose.AsyncImagePainter.State) r0
            kotlin.jvm.functions.Function1<? super coil3.compose.AsyncImagePainter$State, ? extends coil3.compose.AsyncImagePainter$State> r1 = r3.transform
            java.lang.Object r4 = r1.invoke(r4)
            coil3.compose.AsyncImagePainter$State r4 = (coil3.compose.AsyncImagePainter.State) r4
            kotlinx.coroutines.flow.MutableStateFlow<coil3.compose.AsyncImagePainter$State> r1 = r3._state
            r1.setValue(r4)
            androidx.compose.ui.layout.ContentScale r1 = r3.contentScale
            coil3.compose.internal.CrossfadePainter r1 = coil3.compose.AsyncImagePainter_androidKt.maybeNewCrossfadePainter(r0, r4, r1)
            if (r1 == 0) goto L_0x0020
            androidx.compose.ui.graphics.painter.Painter r1 = (androidx.compose.ui.graphics.painter.Painter) r1
            goto L_0x0024
        L_0x0020:
            androidx.compose.ui.graphics.painter.Painter r1 = r4.getPainter()
        L_0x0024:
            r3.setPainter(r1)
            androidx.compose.ui.graphics.painter.Painter r1 = r0.getPainter()
            androidx.compose.ui.graphics.painter.Painter r2 = r4.getPainter()
            if (r1 == r2) goto L_0x0053
            androidx.compose.ui.graphics.painter.Painter r0 = r0.getPainter()
            boolean r1 = r0 instanceof androidx.compose.runtime.RememberObserver
            r2 = 0
            if (r1 == 0) goto L_0x003d
            androidx.compose.runtime.RememberObserver r0 = (androidx.compose.runtime.RememberObserver) r0
            goto L_0x003e
        L_0x003d:
            r0 = r2
        L_0x003e:
            if (r0 == 0) goto L_0x0043
            r0.onForgotten()
        L_0x0043:
            androidx.compose.ui.graphics.painter.Painter r0 = r4.getPainter()
            boolean r1 = r0 instanceof androidx.compose.runtime.RememberObserver
            if (r1 == 0) goto L_0x004e
            r2 = r0
            androidx.compose.runtime.RememberObserver r2 = (androidx.compose.runtime.RememberObserver) r2
        L_0x004e:
            if (r2 == 0) goto L_0x0053
            r2.onRemembered()
        L_0x0053:
            kotlin.jvm.functions.Function1<? super coil3.compose.AsyncImagePainter$State, kotlin.Unit> r0 = r3.onState
            if (r0 == 0) goto L_0x005a
            r0.invoke(r4)
        L_0x005a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.compose.AsyncImagePainter.updateState(coil3.compose.AsyncImagePainter$State):void");
    }

    /* access modifiers changed from: private */
    public final State toState(ImageResult imageResult) {
        if (imageResult instanceof SuccessResult) {
            SuccessResult successResult = (SuccessResult) imageResult;
            return new State.Success(ImagePainter_androidKt.m7471asPainter55t9rM(successResult.getImage(), successResult.getRequest().getContext(), this.filterQuality), successResult);
        } else if (imageResult instanceof ErrorResult) {
            ErrorResult errorResult = (ErrorResult) imageResult;
            Image image = errorResult.getImage();
            return new State.Error(image != null ? ImagePainter_androidKt.m7471asPainter55t9rM(image, errorResult.getRequest().getContext(), this.filterQuality) : null, errorResult);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcoil3/compose/AsyncImagePainter$Input;", "", "imageLoader", "Lcoil3/ImageLoader;", "request", "Lcoil3/request/ImageRequest;", "modelEqualityDelegate", "Lcoil3/compose/AsyncImageModelEqualityDelegate;", "<init>", "(Lcoil3/ImageLoader;Lcoil3/request/ImageRequest;Lcoil3/compose/AsyncImageModelEqualityDelegate;)V", "getImageLoader", "()Lcoil3/ImageLoader;", "getRequest", "()Lcoil3/request/ImageRequest;", "getModelEqualityDelegate", "()Lcoil3/compose/AsyncImageModelEqualityDelegate;", "equals", "", "other", "hashCode", "", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: AsyncImagePainter.kt */
    public static final class Input {
        public static final int $stable = 0;
        private final ImageLoader imageLoader;
        private final AsyncImageModelEqualityDelegate modelEqualityDelegate;
        private final ImageRequest request;

        public String toString() {
            return "Input(imageLoader=" + this.imageLoader + ", request=" + this.request + ", modelEqualityDelegate=" + this.modelEqualityDelegate + ')';
        }

        public Input(ImageLoader imageLoader2, ImageRequest imageRequest, AsyncImageModelEqualityDelegate asyncImageModelEqualityDelegate) {
            this.imageLoader = imageLoader2;
            this.request = imageRequest;
            this.modelEqualityDelegate = asyncImageModelEqualityDelegate;
        }

        public final ImageLoader getImageLoader() {
            return this.imageLoader;
        }

        public final ImageRequest getRequest() {
            return this.request;
        }

        public final AsyncImageModelEqualityDelegate getModelEqualityDelegate() {
            return this.modelEqualityDelegate;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Input)) {
                return false;
            }
            Input input = (Input) obj;
            if (!Intrinsics.areEqual((Object) this.imageLoader, (Object) input.imageLoader) || !Intrinsics.areEqual((Object) this.modelEqualityDelegate, (Object) input.modelEqualityDelegate) || !this.modelEqualityDelegate.equals(this.request, input.request)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.imageLoader.hashCode() * 31) + this.modelEqualityDelegate.hashCode()) * 31) + this.modelEqualityDelegate.hashCode(this.request);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0006\u0007\b\tR\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0001\u0004\n\u000b\f\rø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Lcoil3/compose/AsyncImagePainter$State;", "", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "Empty", "Loading", "Success", "Error", "Lcoil3/compose/AsyncImagePainter$State$Empty;", "Lcoil3/compose/AsyncImagePainter$State$Error;", "Lcoil3/compose/AsyncImagePainter$State$Loading;", "Lcoil3/compose/AsyncImagePainter$State$Success;", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: AsyncImagePainter.kt */
    public interface State {
        Painter getPainter();

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcoil3/compose/AsyncImagePainter$State$Empty;", "Lcoil3/compose/AsyncImagePainter$State;", "<init>", "()V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "equals", "", "other", "", "hashCode", "", "toString", "", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* compiled from: AsyncImagePainter.kt */
        public static final class Empty implements State {
            public static final int $stable = 0;
            public static final Empty INSTANCE = new Empty();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Empty)) {
                    return false;
                }
                Empty empty = (Empty) obj;
                return true;
            }

            public Painter getPainter() {
                return null;
            }

            public int hashCode() {
                return -1625786264;
            }

            public String toString() {
                return "Empty";
            }

            private Empty() {
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcoil3/compose/AsyncImagePainter$State$Loading;", "Lcoil3/compose/AsyncImagePainter$State;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* compiled from: AsyncImagePainter.kt */
        public static final class Loading implements State {
            public static final int $stable = 8;
            private final Painter painter;

            public static /* synthetic */ Loading copy$default(Loading loading, Painter painter2, int i, Object obj) {
                if ((i & 1) != 0) {
                    painter2 = loading.painter;
                }
                return loading.copy(painter2);
            }

            public final Painter component1() {
                return this.painter;
            }

            public final Loading copy(Painter painter2) {
                return new Loading(painter2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Loading) && Intrinsics.areEqual((Object) this.painter, (Object) ((Loading) obj).painter);
            }

            public int hashCode() {
                Painter painter2 = this.painter;
                if (painter2 == null) {
                    return 0;
                }
                return painter2.hashCode();
            }

            public String toString() {
                return "Loading(painter=" + this.painter + ')';
            }

            public Loading(Painter painter2) {
                this.painter = painter2;
            }

            public Painter getPainter() {
                return this.painter;
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcoil3/compose/AsyncImagePainter$State$Success;", "Lcoil3/compose/AsyncImagePainter$State;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "result", "Lcoil3/request/SuccessResult;", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;Lcoil3/request/SuccessResult;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "getResult", "()Lcoil3/request/SuccessResult;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* compiled from: AsyncImagePainter.kt */
        public static final class Success implements State {
            public static final int $stable = 8;
            private final Painter painter;
            private final SuccessResult result;

            public static /* synthetic */ Success copy$default(Success success, Painter painter2, SuccessResult successResult, int i, Object obj) {
                if ((i & 1) != 0) {
                    painter2 = success.painter;
                }
                if ((i & 2) != 0) {
                    successResult = success.result;
                }
                return success.copy(painter2, successResult);
            }

            public final Painter component1() {
                return this.painter;
            }

            public final SuccessResult component2() {
                return this.result;
            }

            public final Success copy(Painter painter2, SuccessResult successResult) {
                return new Success(painter2, successResult);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Success)) {
                    return false;
                }
                Success success = (Success) obj;
                return Intrinsics.areEqual((Object) this.painter, (Object) success.painter) && Intrinsics.areEqual((Object) this.result, (Object) success.result);
            }

            public int hashCode() {
                return (this.painter.hashCode() * 31) + this.result.hashCode();
            }

            public String toString() {
                return "Success(painter=" + this.painter + ", result=" + this.result + ')';
            }

            public Success(Painter painter2, SuccessResult successResult) {
                this.painter = painter2;
                this.result = successResult;
            }

            public Painter getPainter() {
                return this.painter;
            }

            public final SuccessResult getResult() {
                return this.result;
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcoil3/compose/AsyncImagePainter$State$Error;", "Lcoil3/compose/AsyncImagePainter$State;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "result", "Lcoil3/request/ErrorResult;", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;Lcoil3/request/ErrorResult;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "getResult", "()Lcoil3/request/ErrorResult;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* compiled from: AsyncImagePainter.kt */
        public static final class Error implements State {
            public static final int $stable = 8;
            private final Painter painter;
            private final ErrorResult result;

            public static /* synthetic */ Error copy$default(Error error, Painter painter2, ErrorResult errorResult, int i, Object obj) {
                if ((i & 1) != 0) {
                    painter2 = error.painter;
                }
                if ((i & 2) != 0) {
                    errorResult = error.result;
                }
                return error.copy(painter2, errorResult);
            }

            public final Painter component1() {
                return this.painter;
            }

            public final ErrorResult component2() {
                return this.result;
            }

            public final Error copy(Painter painter2, ErrorResult errorResult) {
                return new Error(painter2, errorResult);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Error)) {
                    return false;
                }
                Error error = (Error) obj;
                return Intrinsics.areEqual((Object) this.painter, (Object) error.painter) && Intrinsics.areEqual((Object) this.result, (Object) error.result);
            }

            public int hashCode() {
                Painter painter2 = this.painter;
                return ((painter2 == null ? 0 : painter2.hashCode()) * 31) + this.result.hashCode();
            }

            public String toString() {
                return "Error(painter=" + this.painter + ", result=" + this.result + ')';
            }

            public Error(Painter painter2, ErrorResult errorResult) {
                this.painter = painter2;
                this.result = errorResult;
            }

            public Painter getPainter() {
                return this.painter;
            }

            public final ErrorResult getResult() {
                return this.result;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcoil3/compose/AsyncImagePainter$Companion;", "", "<init>", "()V", "DefaultTransform", "Lkotlin/Function1;", "Lcoil3/compose/AsyncImagePainter$State;", "getDefaultTransform", "()Lkotlin/jvm/functions/Function1;", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: AsyncImagePainter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function1<State, State> getDefaultTransform() {
            return AsyncImagePainter.DefaultTransform;
        }
    }
}
