package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2", f = "TapGestureDetector.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TapGestureDetector.kt */
final class TapGestureDetectorKt$detectTapGestures$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Offset, Unit> $onDoubleTap;
    final /* synthetic */ Function1<Offset, Unit> $onLongPress;
    final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
    final /* synthetic */ Function1<Offset, Unit> $onTap;
    final /* synthetic */ PointerInputScope $this_detectTapGestures;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TapGestureDetectorKt$detectTapGestures$2(PointerInputScope pointerInputScope, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function12, Function1<? super Offset, Unit> function13, Continuation<? super TapGestureDetectorKt$detectTapGestures$2> continuation) {
        super(2, continuation);
        this.$this_detectTapGestures = pointerInputScope;
        this.$onPress = function3;
        this.$onLongPress = function1;
        this.$onDoubleTap = function12;
        this.$onTap = function13;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TapGestureDetectorKt$detectTapGestures$2 tapGestureDetectorKt$detectTapGestures$2 = new TapGestureDetectorKt$detectTapGestures$2(this.$this_detectTapGestures, this.$onPress, this.$onLongPress, this.$onDoubleTap, this.$onTap, continuation);
        tapGestureDetectorKt$detectTapGestures$2.L$0 = obj;
        return tapGestureDetectorKt$detectTapGestures$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TapGestureDetectorKt$detectTapGestures$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            final PressGestureScopeImpl pressGestureScopeImpl = new PressGestureScopeImpl(this.$this_detectTapGestures);
            PointerInputScope pointerInputScope = this.$this_detectTapGestures;
            final Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3 = this.$onPress;
            final Function1<Offset, Unit> function1 = this.$onLongPress;
            final Function1<Offset, Unit> function12 = this.$onDoubleTap;
            final Function1<Offset, Unit> function13 = this.$onTap;
            this.label = 1;
            if (ForEachGestureKt.awaitEachGesture(pointerInputScope, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1", f = "TapGestureDetector.kt", i = {0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4}, l = {100, 114, 129, 141, 156, 178}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "down", "upOrCancel", "longPressTimeout", "$this$awaitEachGesture", "upOrCancel", "longPressTimeout", "$this$awaitEachGesture", "upOrCancel", "longPressTimeout", "$this$awaitEachGesture", "upOrCancel", "secondDown"}, s = {"L$0", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "L$2"})
    /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1  reason: invalid class name */
    /* compiled from: TapGestureDetector.kt */
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(coroutineScope, function3, function1, function12, function13, pressGestureScopeImpl, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v37, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: androidx.compose.ui.input.pointer.AwaitPointerEventScope} */
        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            r2.element = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0107, code lost:
            if (r7.element != null) goto L_0x011d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0109, code lost:
            r10 = r4;
            r6 = r9;
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r10, (kotlin.coroutines.CoroutineContext) null, (kotlinx.coroutines.CoroutineStart) null, new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass4((kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass4>) null), 3, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x011d, code lost:
            r7.element.consume();
            r10 = r4;
            r6 = r9;
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r10, (kotlin.coroutines.CoroutineContext) null, (kotlinx.coroutines.CoroutineStart) null, new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass5((kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass5>) null), 3, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0137, code lost:
            r2 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0139, code lost:
            r2 = r7;
            r7 = r8;
            r6 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x015f, code lost:
            if (androidx.compose.foundation.gestures.TapGestureDetectorKt.consumeUntilUp(r6, r0) != r1) goto L_0x0163;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0163, code lost:
            r7 = r4;
            r9 = r9;
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r7, (kotlin.coroutines.CoroutineContext) null, (kotlinx.coroutines.CoroutineStart) null, new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass6((kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass6>) null), 3, (java.lang.Object) null);
            r9 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0179, code lost:
            if (r2.element == null) goto L_0x026d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x017d, code lost:
            if (r7 != null) goto L_0x0194;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x017f, code lost:
            r1 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0181, code lost:
            if (r1 == null) goto L_0x026d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0183, code lost:
            r1.invoke(androidx.compose.ui.geometry.Offset.m3976boximpl(r2.element.m5587getPositionF1C5BW0()));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x0194, code lost:
            r0.L$0 = r9;
            r0.L$1 = r2;
            r0.L$2 = null;
            r0.L$3 = null;
            r0.J$0 = r4;
            r0.label = 4;
            r6 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitSecondDown(r9, r2.element, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x01ac, code lost:
            if (r6 != r1) goto L_0x01b0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x01b0, code lost:
            r11 = r2;
            r2 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x01b2, code lost:
            r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x01b4, code lost:
            if (r6 != null) goto L_0x01cb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x01b6, code lost:
            r1 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x01b8, code lost:
            if (r1 == null) goto L_0x026d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x01ba, code lost:
            r1.invoke(androidx.compose.ui.geometry.Offset.m3976boximpl(r11.element.m5587getPositionF1C5BW0()));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x01cb, code lost:
            r12 = r4;
            r8 = r9;
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r12, (kotlin.coroutines.CoroutineContext) null, (kotlinx.coroutines.CoroutineStart) null, new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass7((kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass7>) null), 3, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x01e6, code lost:
            if (r5 == androidx.compose.foundation.gestures.TapGestureDetectorKt.NoPressGesture) goto L_0x01ff;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x01e8, code lost:
            r12 = r4;
            r8 = r5;
            r9 = r9;
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r12, (kotlin.coroutines.CoroutineContext) null, (kotlinx.coroutines.CoroutineStart) null, new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass8((kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass8>) null), 3, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
            r8 = r4;
            r9 = r7;
            r10 = r8;
            r12 = r9;
            r0.L$0 = r2;
            r0.L$1 = r11;
            r0.L$2 = r6;
            r0.label = 5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x021f, code lost:
            if (r2.withTimeout(r4, new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass9((kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass9>) null), r0) != r1) goto L_0x026d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x0222, code lost:
            r5 = r2;
            r2 = r6;
            r4 = r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x0225, code lost:
            r6 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x0227, code lost:
            if (r6 != null) goto L_0x0229;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x0229, code lost:
            r6.invoke(androidx.compose.ui.geometry.Offset.m3976boximpl(r4.element.m5587getPositionF1C5BW0()));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x0238, code lost:
            r4 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x023a, code lost:
            if (r4 != null) goto L_0x023c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x023c, code lost:
            r4.invoke(androidx.compose.ui.geometry.Offset.m3976boximpl(r2.m5587getPositionF1C5BW0()));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x0247, code lost:
            r0.L$0 = null;
            r0.L$1 = null;
            r0.L$2 = null;
            r0.label = 6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x0257, code lost:
            if (androidx.compose.foundation.gestures.TapGestureDetectorKt.consumeUntilUp(r5, r0) != r1) goto L_0x025a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x0259, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x025a, code lost:
            r4 = r4;
            r2 = r9;
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r4, (kotlin.coroutines.CoroutineContext) null, (kotlinx.coroutines.CoroutineStart) null, new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass10((kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass10>) null), 3, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x026f, code lost:
            return kotlin.Unit.INSTANCE;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0140  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                r18 = this;
                r0 = r18
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 0
                switch(r2) {
                    case 0: goto L_0x0077;
                    case 1: goto L_0x006c;
                    case 2: goto L_0x004c;
                    case 3: goto L_0x003d;
                    case 4: goto L_0x002a;
                    case 5: goto L_0x0019;
                    case 6: goto L_0x0014;
                    default: goto L_0x000c;
                }
            L_0x000c:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0014:
                kotlin.ResultKt.throwOnFailure(r19)
                goto L_0x025a
            L_0x0019:
                java.lang.Object r2 = r0.L$2
                androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2
                java.lang.Object r4 = r0.L$1
                kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
                java.lang.Object r5 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
                kotlin.ResultKt.throwOnFailure(r19)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0225 }
                goto L_0x026d
            L_0x002a:
                long r4 = r0.J$0
                java.lang.Object r2 = r0.L$1
                kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
                java.lang.Object r6 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r6 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r6
                kotlin.ResultKt.throwOnFailure(r19)
                r11 = r2
                r2 = r6
                r6 = r19
                goto L_0x01b2
            L_0x003d:
                long r4 = r0.J$0
                java.lang.Object r2 = r0.L$1
                kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
                java.lang.Object r6 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r6 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r6
                kotlin.ResultKt.throwOnFailure(r19)
                goto L_0x0163
            L_0x004c:
                long r4 = r0.J$0
                java.lang.Object r2 = r0.L$3
                kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
                java.lang.Object r6 = r0.L$2
                kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
                java.lang.Object r7 = r0.L$1
                androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
                java.lang.Object r8 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
                kotlin.ResultKt.throwOnFailure(r19)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0068 }
                r9 = r8
                r8 = r7
                r7 = r6
                r6 = r19
                goto L_0x0103
            L_0x0068:
                r2 = r6
            L_0x0069:
                r6 = r8
                goto L_0x013c
            L_0x006c:
                java.lang.Object r2 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
                kotlin.ResultKt.throwOnFailure(r19)
                r8 = r2
                r2 = r19
                goto L_0x0094
            L_0x0077:
                kotlin.ResultKt.throwOnFailure(r19)
                java.lang.Object r2 = r0.L$0
                r4 = r2
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
                r7 = r0
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r0.L$0 = r4
                r2 = 1
                r0.label = r2
                r5 = 0
                r6 = 0
                r8 = 3
                r9 = 0
                java.lang.Object r2 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r4, r5, r6, r7, r8, r9)
                if (r2 != r1) goto L_0x0093
                goto L_0x0259
            L_0x0093:
                r8 = r4
            L_0x0094:
                r7 = r2
                androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
                r7.consume()
                kotlinx.coroutines.CoroutineScope r9 = r4
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1 r2 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1
                androidx.compose.foundation.gestures.PressGestureScopeImpl r4 = r9
                r2.<init>(r4, r3)
                r12 = r2
                kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
                r13 = 3
                r14 = 0
                r10 = 0
                r11 = 0
                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r9, r10, r11, r12, r13, r14)
                kotlin.jvm.functions.Function3<androidx.compose.foundation.gestures.PressGestureScope, androidx.compose.ui.geometry.Offset, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r2 = r5
                kotlin.jvm.functions.Function3 r4 = androidx.compose.foundation.gestures.TapGestureDetectorKt.NoPressGesture
                if (r2 == r4) goto L_0x00ca
                kotlinx.coroutines.CoroutineScope r9 = r4
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$2 r2 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$2
                kotlin.jvm.functions.Function3<androidx.compose.foundation.gestures.PressGestureScope, androidx.compose.ui.geometry.Offset, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r4 = r5
                androidx.compose.foundation.gestures.PressGestureScopeImpl r5 = r9
                r2.<init>(r4, r5, r7, r3)
                r12 = r2
                kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
                r13 = 3
                r14 = 0
                r10 = 0
                r11 = 0
                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r9, r10, r11, r12, r13, r14)
            L_0x00ca:
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r2 = r6
                if (r2 == 0) goto L_0x00d7
                androidx.compose.ui.platform.ViewConfiguration r2 = r8.getViewConfiguration()
                long r4 = r2.getLongPressTimeoutMillis()
                goto L_0x00dc
            L_0x00d7:
                r4 = 4611686018427387903(0x3fffffffffffffff, double:1.9999999999999998)
            L_0x00dc:
                kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
                r2.<init>()
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$3 r6 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$3     // Catch:{ PointerEventTimeoutCancellationException -> 0x0069 }
                r6.<init>(r3)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0069 }
                kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch:{ PointerEventTimeoutCancellationException -> 0x0069 }
                r9 = r0
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9     // Catch:{ PointerEventTimeoutCancellationException -> 0x0069 }
                r0.L$0 = r8     // Catch:{ PointerEventTimeoutCancellationException -> 0x0069 }
                r0.L$1 = r7     // Catch:{ PointerEventTimeoutCancellationException -> 0x0069 }
                r0.L$2 = r2     // Catch:{ PointerEventTimeoutCancellationException -> 0x0069 }
                r0.L$3 = r2     // Catch:{ PointerEventTimeoutCancellationException -> 0x0069 }
                r0.J$0 = r4     // Catch:{ PointerEventTimeoutCancellationException -> 0x0069 }
                r10 = 2
                r0.label = r10     // Catch:{ PointerEventTimeoutCancellationException -> 0x0069 }
                java.lang.Object r6 = r8.withTimeout(r4, r6, r9)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0069 }
                if (r6 != r1) goto L_0x0100
                goto L_0x0259
            L_0x0100:
                r9 = r8
                r8 = r7
                r7 = r2
            L_0x0103:
                r2.element = r6     // Catch:{ PointerEventTimeoutCancellationException -> 0x0139 }
                T r2 = r7.element     // Catch:{ PointerEventTimeoutCancellationException -> 0x0139 }
                if (r2 != 0) goto L_0x011d
                kotlinx.coroutines.CoroutineScope r10 = r4     // Catch:{ PointerEventTimeoutCancellationException -> 0x0139 }
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$4 r2 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$4     // Catch:{ PointerEventTimeoutCancellationException -> 0x0139 }
                androidx.compose.foundation.gestures.PressGestureScopeImpl r6 = r9     // Catch:{ PointerEventTimeoutCancellationException -> 0x0139 }
                r2.<init>(r6, r3)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0139 }
                r13 = r2
                kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13     // Catch:{ PointerEventTimeoutCancellationException -> 0x0139 }
                r14 = 3
                r15 = 0
                r11 = 0
                r12 = 0
                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r10, r11, r12, r13, r14, r15)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0139 }
                goto L_0x0137
            L_0x011d:
                T r2 = r7.element     // Catch:{ PointerEventTimeoutCancellationException -> 0x0139 }
                androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2     // Catch:{ PointerEventTimeoutCancellationException -> 0x0139 }
                r2.consume()     // Catch:{ PointerEventTimeoutCancellationException -> 0x0139 }
                kotlinx.coroutines.CoroutineScope r10 = r4     // Catch:{ PointerEventTimeoutCancellationException -> 0x0139 }
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$5 r2 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$5     // Catch:{ PointerEventTimeoutCancellationException -> 0x0139 }
                androidx.compose.foundation.gestures.PressGestureScopeImpl r6 = r9     // Catch:{ PointerEventTimeoutCancellationException -> 0x0139 }
                r2.<init>(r6, r3)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0139 }
                r13 = r2
                kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13     // Catch:{ PointerEventTimeoutCancellationException -> 0x0139 }
                r14 = 3
                r15 = 0
                r11 = 0
                r12 = 0
                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r10, r11, r12, r13, r14, r15)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0139 }
            L_0x0137:
                r2 = r7
                goto L_0x0177
            L_0x0139:
                r2 = r7
                r7 = r8
                r6 = r9
            L_0x013c:
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r8 = r6
                if (r8 == 0) goto L_0x014b
                long r9 = r7.m5587getPositionF1C5BW0()
                androidx.compose.ui.geometry.Offset r7 = androidx.compose.ui.geometry.Offset.m3976boximpl(r9)
                r8.invoke(r7)
            L_0x014b:
                r7 = r0
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r0.L$0 = r6
                r0.L$1 = r2
                r0.L$2 = r3
                r0.L$3 = r3
                r0.J$0 = r4
                r8 = 3
                r0.label = r8
                java.lang.Object r7 = androidx.compose.foundation.gestures.TapGestureDetectorKt.consumeUntilUp(r6, r7)
                if (r7 != r1) goto L_0x0163
                goto L_0x0259
            L_0x0163:
                kotlinx.coroutines.CoroutineScope r7 = r4
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$6 r8 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$6
                androidx.compose.foundation.gestures.PressGestureScopeImpl r9 = r9
                r8.<init>(r9, r3)
                r10 = r8
                kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
                r11 = 3
                r12 = 0
                r8 = 0
                r9 = 0
                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r7, r8, r9, r10, r11, r12)
                r9 = r6
            L_0x0177:
                T r6 = r2.element
                if (r6 == 0) goto L_0x026d
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r6 = r7
                if (r6 != 0) goto L_0x0194
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r1 = r8
                if (r1 == 0) goto L_0x026d
                T r2 = r2.element
                androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2
                long r2 = r2.m5587getPositionF1C5BW0()
                androidx.compose.ui.geometry.Offset r2 = androidx.compose.ui.geometry.Offset.m3976boximpl(r2)
                r1.invoke(r2)
                goto L_0x026d
            L_0x0194:
                T r6 = r2.element
                androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
                r7 = r0
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r0.L$0 = r9
                r0.L$1 = r2
                r0.L$2 = r3
                r0.L$3 = r3
                r0.J$0 = r4
                r8 = 4
                r0.label = r8
                java.lang.Object r6 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitSecondDown(r9, r6, r7)
                if (r6 != r1) goto L_0x01b0
                goto L_0x0259
            L_0x01b0:
                r11 = r2
                r2 = r9
            L_0x01b2:
                androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
                if (r6 != 0) goto L_0x01cb
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r1 = r8
                if (r1 == 0) goto L_0x026d
                T r2 = r11.element
                androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2
                long r2 = r2.m5587getPositionF1C5BW0()
                androidx.compose.ui.geometry.Offset r2 = androidx.compose.ui.geometry.Offset.m3976boximpl(r2)
                r1.invoke(r2)
                goto L_0x026d
            L_0x01cb:
                kotlinx.coroutines.CoroutineScope r12 = r4
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$7 r7 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$7
                androidx.compose.foundation.gestures.PressGestureScopeImpl r8 = r9
                r7.<init>(r8, r3)
                r15 = r7
                kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
                r16 = 3
                r17 = 0
                r13 = 0
                r14 = 0
                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r12, r13, r14, r15, r16, r17)
                kotlin.jvm.functions.Function3<androidx.compose.foundation.gestures.PressGestureScope, androidx.compose.ui.geometry.Offset, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r7 = r5
                kotlin.jvm.functions.Function3 r8 = androidx.compose.foundation.gestures.TapGestureDetectorKt.NoPressGesture
                if (r7 == r8) goto L_0x01ff
                kotlinx.coroutines.CoroutineScope r12 = r4
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$8 r7 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$8
                kotlin.jvm.functions.Function3<androidx.compose.foundation.gestures.PressGestureScope, androidx.compose.ui.geometry.Offset, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r8 = r5
                androidx.compose.foundation.gestures.PressGestureScopeImpl r9 = r9
                r7.<init>(r8, r9, r6, r3)
                r15 = r7
                kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
                r16 = 3
                r17 = 0
                r13 = 0
                r14 = 0
                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r12, r13, r14, r15, r16, r17)
            L_0x01ff:
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9 r7 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9     // Catch:{ PointerEventTimeoutCancellationException -> 0x0222 }
                kotlinx.coroutines.CoroutineScope r8 = r4     // Catch:{ PointerEventTimeoutCancellationException -> 0x0222 }
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r9 = r7     // Catch:{ PointerEventTimeoutCancellationException -> 0x0222 }
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r10 = r8     // Catch:{ PointerEventTimeoutCancellationException -> 0x0222 }
                androidx.compose.foundation.gestures.PressGestureScopeImpl r12 = r9     // Catch:{ PointerEventTimeoutCancellationException -> 0x0222 }
                r13 = 0
                r7.<init>(r8, r9, r10, r11, r12, r13)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0222 }
                kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7     // Catch:{ PointerEventTimeoutCancellationException -> 0x0222 }
                r8 = r0
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8     // Catch:{ PointerEventTimeoutCancellationException -> 0x0222 }
                r0.L$0 = r2     // Catch:{ PointerEventTimeoutCancellationException -> 0x0222 }
                r0.L$1 = r11     // Catch:{ PointerEventTimeoutCancellationException -> 0x0222 }
                r0.L$2 = r6     // Catch:{ PointerEventTimeoutCancellationException -> 0x0222 }
                r9 = 5
                r0.label = r9     // Catch:{ PointerEventTimeoutCancellationException -> 0x0222 }
                java.lang.Object r2 = r2.withTimeout(r4, r7, r8)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0222 }
                if (r2 != r1) goto L_0x026d
                goto L_0x0259
            L_0x0222:
                r5 = r2
                r2 = r6
                r4 = r11
            L_0x0225:
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r6 = r8
                if (r6 == 0) goto L_0x0238
                T r4 = r4.element
                androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
                long r7 = r4.m5587getPositionF1C5BW0()
                androidx.compose.ui.geometry.Offset r4 = androidx.compose.ui.geometry.Offset.m3976boximpl(r7)
                r6.invoke(r4)
            L_0x0238:
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r4 = r6
                if (r4 == 0) goto L_0x0247
                long r6 = r2.m5587getPositionF1C5BW0()
                androidx.compose.ui.geometry.Offset r2 = androidx.compose.ui.geometry.Offset.m3976boximpl(r6)
                r4.invoke(r2)
            L_0x0247:
                r2 = r0
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                r0.L$0 = r3
                r0.L$1 = r3
                r0.L$2 = r3
                r4 = 6
                r0.label = r4
                java.lang.Object r2 = androidx.compose.foundation.gestures.TapGestureDetectorKt.consumeUntilUp(r5, r2)
                if (r2 != r1) goto L_0x025a
            L_0x0259:
                return r1
            L_0x025a:
                kotlinx.coroutines.CoroutineScope r4 = r4
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$10 r1 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$10
                androidx.compose.foundation.gestures.PressGestureScopeImpl r2 = r9
                r1.<init>(r2, r3)
                r7 = r1
                kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
                r8 = 3
                r9 = 0
                r5 = 0
                r6 = 0
                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r4, r5, r6, r7, r8, r9)
            L_0x026d:
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
