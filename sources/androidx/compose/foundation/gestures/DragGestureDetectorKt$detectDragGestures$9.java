package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$9", f = "DragGestureDetector.kt", i = {0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4}, l = {247, 253, 972, 1014, 1025}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "initialDown", "awaitTouchSlop", "$this$awaitEachGesture", "down", "$this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv", "pointer$iv", "touchSlopDetector$iv", "touchSlop$iv", "$this$awaitEachGesture", "down", "$this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv", "pointer$iv", "touchSlopDetector$iv", "dragEvent$iv", "touchSlop$iv", "$this$drag_u2dVnAYq1g$iv", "orientation$iv", "$this$awaitDragOrUp_u2djO51t88$iv$iv", "pointer$iv$iv"}, s = {"L$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "L$2", "L$4", "L$5", "F$0", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "F$0", "L$0", "L$2", "L$3", "L$4"})
/* compiled from: DragGestureDetector.kt */
final class DragGestureDetectorKt$detectDragGestures$9 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
    final /* synthetic */ Function0<Unit> $onDragCancel;
    final /* synthetic */ Function1<PointerInputChange, Unit> $onDragEnd;
    final /* synthetic */ Function3<PointerInputChange, PointerInputChange, Offset, Unit> $onDragStart;
    final /* synthetic */ Orientation $orientationLock;
    final /* synthetic */ Ref.LongRef $overSlop;
    final /* synthetic */ Function0<Boolean> $shouldAwaitTouchSlop;
    float F$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    boolean Z$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DragGestureDetectorKt$detectDragGestures$9(Function0<Boolean> function0, Ref.LongRef longRef, Orientation orientation, Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function3, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Function0<Unit> function02, Function1<? super PointerInputChange, Unit> function1, Continuation<? super DragGestureDetectorKt$detectDragGestures$9> continuation) {
        super(2, continuation);
        this.$shouldAwaitTouchSlop = function0;
        this.$overSlop = longRef;
        this.$orientationLock = orientation;
        this.$onDragStart = function3;
        this.$onDrag = function2;
        this.$onDragCancel = function02;
        this.$onDragEnd = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureDetectorKt$detectDragGestures$9 dragGestureDetectorKt$detectDragGestures$9 = new DragGestureDetectorKt$detectDragGestures$9(this.$shouldAwaitTouchSlop, this.$overSlop, this.$orientationLock, this.$onDragStart, this.$onDrag, this.$onDragCancel, this.$onDragEnd, continuation);
        dragGestureDetectorKt$detectDragGestures$9.L$0 = obj;
        return dragGestureDetectorKt$detectDragGestures$9;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$detectDragGestures$9) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v13, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v16, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v17, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v18, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0311, code lost:
        if ((r3 == 0.0f) == false) goto L_0x0313;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00c1, code lost:
        if (r10 == r1) goto L_0x028d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0103, code lost:
        if (r2 == false) goto L_0x0235;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x014d, code lost:
        if (r13 == r1) goto L_0x028d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0261, code lost:
        if (androidx.compose.foundation.gestures.DragGestureDetectorKt.m455isPointerUpDmW0f2w(r11.getCurrentEvent(), r2) != false) goto L_0x0263;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x028b, code lost:
        if (r3 != r1) goto L_0x028e;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0328  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x032e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x011f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            r20 = this;
            r0 = r20
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 0
            r8 = 1
            r9 = 0
            if (r2 == 0) goto L_0x00ad
            if (r2 == r8) goto L_0x00a3
            if (r2 == r6) goto L_0x0091
            if (r2 == r5) goto L_0x006a
            if (r2 == r4) goto L_0x0041
            if (r2 != r3) goto L_0x0039
            java.lang.Object r2 = r0.L$4
            kotlin.jvm.internal.Ref$LongRef r2 = (kotlin.jvm.internal.Ref.LongRef) r2
            java.lang.Object r4 = r0.L$3
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
            java.lang.Object r5 = r0.L$2
            androidx.compose.foundation.gestures.Orientation r5 = (androidx.compose.foundation.gestures.Orientation) r5
            java.lang.Object r6 = r0.L$1
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            java.lang.Object r10 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            kotlin.ResultKt.throwOnFailure(r21)
            r7 = r9
            r9 = r8
            r8 = r3
            r3 = r21
            goto L_0x028e
        L_0x0039:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0041:
            float r2 = r0.F$0
            java.lang.Object r6 = r0.L$6
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            java.lang.Object r10 = r0.L$5
            androidx.compose.foundation.gestures.TouchSlopDetector r10 = (androidx.compose.foundation.gestures.TouchSlopDetector) r10
            java.lang.Object r11 = r0.L$4
            kotlin.jvm.internal.Ref$LongRef r11 = (kotlin.jvm.internal.Ref.LongRef) r11
            java.lang.Object r12 = r0.L$3
            kotlin.jvm.internal.Ref$LongRef r12 = (kotlin.jvm.internal.Ref.LongRef) r12
            java.lang.Object r13 = r0.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
            java.lang.Object r14 = r0.L$1
            androidx.compose.ui.input.pointer.PointerInputChange r14 = (androidx.compose.ui.input.pointer.PointerInputChange) r14
            java.lang.Object r15 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r15 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r15
            kotlin.ResultKt.throwOnFailure(r21)
            r7 = r4
            r3 = r12
            r12 = r10
            r10 = r15
            r15 = r11
            r11 = r13
            goto L_0x0211
        L_0x006a:
            float r2 = r0.F$0
            java.lang.Object r6 = r0.L$5
            androidx.compose.foundation.gestures.TouchSlopDetector r6 = (androidx.compose.foundation.gestures.TouchSlopDetector) r6
            java.lang.Object r10 = r0.L$4
            kotlin.jvm.internal.Ref$LongRef r10 = (kotlin.jvm.internal.Ref.LongRef) r10
            java.lang.Object r11 = r0.L$3
            kotlin.jvm.internal.Ref$LongRef r11 = (kotlin.jvm.internal.Ref.LongRef) r11
            java.lang.Object r12 = r0.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r12 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r12
            java.lang.Object r13 = r0.L$1
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
            java.lang.Object r14 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r14 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r14
            kotlin.ResultKt.throwOnFailure(r21)
            r15 = r10
            r10 = r14
            r14 = r11
            r11 = r12
            r12 = r6
            r6 = r13
            r13 = r21
            goto L_0x0151
        L_0x0091:
            boolean r2 = r0.Z$0
            java.lang.Object r6 = r0.L$1
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            java.lang.Object r10 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            kotlin.ResultKt.throwOnFailure(r21)
            r11 = r10
            r10 = r6
            r6 = r21
            goto L_0x00f7
        L_0x00a3:
            java.lang.Object r2 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
            kotlin.ResultKt.throwOnFailure(r21)
            r10 = r21
            goto L_0x00c5
        L_0x00ad:
            kotlin.ResultKt.throwOnFailure(r21)
            java.lang.Object r2 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
            androidx.compose.ui.input.pointer.PointerEventPass r10 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
            r11 = r0
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
            r0.L$0 = r2
            r0.label = r8
            java.lang.Object r10 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(r2, r7, r10, r11)
            if (r10 != r1) goto L_0x00c5
            goto L_0x028d
        L_0x00c5:
            r11 = r2
            r2 = r10
            androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2
            kotlin.jvm.functions.Function0<java.lang.Boolean> r10 = r0.$shouldAwaitTouchSlop
            java.lang.Object r10 = r10.invoke()
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 != 0) goto L_0x00da
            r2.consume()
        L_0x00da:
            r14 = r0
            kotlin.coroutines.Continuation r14 = (kotlin.coroutines.Continuation) r14
            r0.L$0 = r11
            r0.L$1 = r2
            r0.Z$0 = r10
            r0.label = r6
            r12 = 0
            r13 = 0
            r15 = 2
            r16 = 0
            java.lang.Object r6 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r11, r12, r13, r14, r15, r16)
            if (r6 != r1) goto L_0x00f2
            goto L_0x028d
        L_0x00f2:
            r19 = r10
            r10 = r2
            r2 = r19
        L_0x00f7:
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            kotlin.jvm.internal.Ref$LongRef r12 = r0.$overSlop
            androidx.compose.ui.geometry.Offset$Companion r13 = androidx.compose.ui.geometry.Offset.Companion
            long r13 = r13.m4003getZeroF1C5BW0()
            r12.element = r13
            if (r2 == 0) goto L_0x0235
        L_0x0105:
            long r12 = r6.m5585getIdJ3iCeTQ()
            int r2 = r6.m5590getTypeT8wyACA()
            androidx.compose.foundation.gestures.Orientation r10 = r0.$orientationLock
            kotlin.jvm.internal.Ref$LongRef r14 = r0.$overSlop
            androidx.compose.ui.input.pointer.PointerEvent r15 = r11.getCurrentEvent()
            boolean r15 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m455isPointerUpDmW0f2w(r15, r12)
            if (r15 == 0) goto L_0x011f
            r7 = r4
            r10 = r9
            goto L_0x021a
        L_0x011f:
            androidx.compose.ui.platform.ViewConfiguration r15 = r11.getViewConfiguration()
            float r2 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m456pointerSlopE8SPZFQ(r15, r2)
            kotlin.jvm.internal.Ref$LongRef r15 = new kotlin.jvm.internal.Ref$LongRef
            r15.<init>()
            r15.element = r12
            androidx.compose.foundation.gestures.TouchSlopDetector r12 = new androidx.compose.foundation.gestures.TouchSlopDetector
            r12.<init>(r10)
            r10 = r11
        L_0x0134:
            r13 = r0
            kotlin.coroutines.Continuation r13 = (kotlin.coroutines.Continuation) r13
            r0.L$0 = r10
            r0.L$1 = r6
            r0.L$2 = r11
            r0.L$3 = r14
            r0.L$4 = r15
            r0.L$5 = r12
            r0.L$6 = r9
            r0.F$0 = r2
            r0.label = r5
            java.lang.Object r13 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r11, r9, r13, r8, r9)
            if (r13 != r1) goto L_0x0151
            goto L_0x028d
        L_0x0151:
            androidx.compose.ui.input.pointer.PointerEvent r13 = (androidx.compose.ui.input.pointer.PointerEvent) r13
            java.util.List r5 = r13.getChanges()
            int r7 = r5.size()
            r8 = 0
        L_0x015c:
            if (r8 >= r7) goto L_0x017d
            java.lang.Object r17 = r5.get(r8)
            r18 = r17
            androidx.compose.ui.input.pointer.PointerInputChange r18 = (androidx.compose.ui.input.pointer.PointerInputChange) r18
            long r3 = r18.m5585getIdJ3iCeTQ()
            r21 = r10
            long r9 = r15.element
            boolean r3 = androidx.compose.ui.input.pointer.PointerId.m5569equalsimpl0(r3, r9)
            if (r3 == 0) goto L_0x0175
            goto L_0x0181
        L_0x0175:
            int r8 = r8 + 1
            r10 = r21
            r3 = 5
            r4 = 4
            r9 = 0
            goto L_0x015c
        L_0x017d:
            r21 = r10
            r17 = 0
        L_0x0181:
            r3 = r17
            androidx.compose.ui.input.pointer.PointerInputChange r3 = (androidx.compose.ui.input.pointer.PointerInputChange) r3
            if (r3 != 0) goto L_0x018c
        L_0x0187:
            r11 = r21
            r7 = 4
            goto L_0x0219
        L_0x018c:
            boolean r4 = r3.isConsumed()
            if (r4 == 0) goto L_0x0193
            goto L_0x0187
        L_0x0193:
            boolean r4 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r3)
            if (r4 == 0) goto L_0x01c2
            java.util.List r3 = r13.getChanges()
            int r4 = r3.size()
            r5 = 0
        L_0x01a2:
            if (r5 >= r4) goto L_0x01b5
            java.lang.Object r7 = r3.get(r5)
            r8 = r7
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            boolean r8 = r8.getPressed()
            if (r8 == 0) goto L_0x01b2
            goto L_0x01b6
        L_0x01b2:
            int r5 = r5 + 1
            goto L_0x01a2
        L_0x01b5:
            r7 = 0
        L_0x01b6:
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            if (r7 != 0) goto L_0x01bb
            goto L_0x0187
        L_0x01bb:
            long r3 = r7.m5585getIdJ3iCeTQ()
            r15.element = r3
            goto L_0x01df
        L_0x01c2:
            androidx.compose.ui.geometry.Offset r4 = r12.m563addPointerInputChangeGcwITfU(r3, r2)
            if (r4 == 0) goto L_0x01e9
            long r4 = r4.m3997unboximpl()
            r3.consume()
            r14.element = r4
            boolean r4 = r3.isConsumed()
            if (r4 == 0) goto L_0x01dc
            r11 = r21
            r10 = r3
            r7 = 4
            goto L_0x021a
        L_0x01dc:
            r12.reset()
        L_0x01df:
            r10 = r21
            r3 = 5
            r4 = 4
            r5 = 3
            r7 = 0
            r8 = 1
            r9 = 0
            goto L_0x0134
        L_0x01e9:
            androidx.compose.ui.input.pointer.PointerEventPass r4 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r5 = r0
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r10 = r21
            r0.L$0 = r10
            r0.L$1 = r6
            r0.L$2 = r11
            r0.L$3 = r14
            r0.L$4 = r15
            r0.L$5 = r12
            r0.L$6 = r3
            r0.F$0 = r2
            r7 = 4
            r0.label = r7
            java.lang.Object r4 = r11.awaitPointerEvent(r4, r5)
            if (r4 != r1) goto L_0x020b
            goto L_0x028d
        L_0x020b:
            r19 = r6
            r6 = r3
            r3 = r14
            r14 = r19
        L_0x0211:
            boolean r4 = r6.isConsumed()
            if (r4 == 0) goto L_0x022b
            r11 = r10
            r6 = r14
        L_0x0219:
            r10 = 0
        L_0x021a:
            if (r10 == 0) goto L_0x0235
            boolean r2 = r10.isConsumed()
            if (r2 == 0) goto L_0x0223
            goto L_0x0235
        L_0x0223:
            r4 = r7
            r3 = 5
            r5 = 3
            r7 = 0
            r8 = 1
            r9 = 0
            goto L_0x0105
        L_0x022b:
            r4 = r7
            r6 = r14
            r5 = 3
            r7 = 0
            r8 = 1
            r9 = 0
            r14 = r3
            r3 = 5
            goto L_0x0134
        L_0x0235:
            if (r10 == 0) goto L_0x034f
            kotlin.jvm.functions.Function3<androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.geometry.Offset, kotlin.Unit> r2 = r0.$onDragStart
            kotlin.jvm.internal.Ref$LongRef r3 = r0.$overSlop
            long r3 = r3.element
            androidx.compose.ui.geometry.Offset r3 = androidx.compose.ui.geometry.Offset.m3976boximpl(r3)
            r2.invoke(r6, r10, r3)
            kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.geometry.Offset, kotlin.Unit> r2 = r0.$onDrag
            kotlin.jvm.internal.Ref$LongRef r3 = r0.$overSlop
            long r3 = r3.element
            androidx.compose.ui.geometry.Offset r3 = androidx.compose.ui.geometry.Offset.m3976boximpl(r3)
            r2.invoke(r10, r3)
            long r2 = r10.m5585getIdJ3iCeTQ()
            kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.geometry.Offset, kotlin.Unit> r4 = r0.$onDrag
            androidx.compose.foundation.gestures.Orientation r5 = r0.$orientationLock
            androidx.compose.ui.input.pointer.PointerEvent r6 = r11.getCurrentEvent()
            boolean r6 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m455isPointerUpDmW0f2w(r6, r2)
            if (r6 == 0) goto L_0x0266
        L_0x0263:
            r9 = 0
            goto L_0x0326
        L_0x0266:
            kotlin.jvm.internal.Ref$LongRef r6 = new kotlin.jvm.internal.Ref$LongRef
            r6.<init>()
            r6.element = r2
            r2 = r6
            r10 = r11
            r6 = r4
            r4 = r10
        L_0x0271:
            r3 = r0
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r0.L$0 = r10
            r0.L$1 = r6
            r0.L$2 = r5
            r0.L$3 = r4
            r0.L$4 = r2
            r7 = 0
            r0.L$5 = r7
            r0.L$6 = r7
            r8 = 5
            r0.label = r8
            r9 = 1
            java.lang.Object r3 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r4, r7, r3, r9, r7)
            if (r3 != r1) goto L_0x028e
        L_0x028d:
            return r1
        L_0x028e:
            androidx.compose.ui.input.pointer.PointerEvent r3 = (androidx.compose.ui.input.pointer.PointerEvent) r3
            java.util.List r11 = r3.getChanges()
            int r12 = r11.size()
            r13 = 0
        L_0x0299:
            if (r13 >= r12) goto L_0x02b9
            java.lang.Object r14 = r11.get(r13)
            r15 = r14
            androidx.compose.ui.input.pointer.PointerInputChange r15 = (androidx.compose.ui.input.pointer.PointerInputChange) r15
            long r7 = r15.m5585getIdJ3iCeTQ()
            r21 = r10
            long r9 = r2.element
            boolean r7 = androidx.compose.ui.input.pointer.PointerId.m5569equalsimpl0(r7, r9)
            if (r7 == 0) goto L_0x02b1
            goto L_0x02bc
        L_0x02b1:
            int r13 = r13 + 1
            r10 = r21
            r7 = 0
            r8 = 5
            r9 = 1
            goto L_0x0299
        L_0x02b9:
            r21 = r10
            r14 = 0
        L_0x02bc:
            androidx.compose.ui.input.pointer.PointerInputChange r14 = (androidx.compose.ui.input.pointer.PointerInputChange) r14
            if (r14 != 0) goto L_0x02c2
            r14 = 0
            goto L_0x0313
        L_0x02c2:
            boolean r7 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r14)
            if (r7 == 0) goto L_0x02f1
            java.util.List r3 = r3.getChanges()
            int r7 = r3.size()
            r8 = 0
        L_0x02d1:
            if (r8 >= r7) goto L_0x02e4
            java.lang.Object r9 = r3.get(r8)
            r10 = r9
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            boolean r10 = r10.getPressed()
            if (r10 == 0) goto L_0x02e1
            goto L_0x02e5
        L_0x02e1:
            int r8 = r8 + 1
            goto L_0x02d1
        L_0x02e4:
            r9 = 0
        L_0x02e5:
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            if (r9 != 0) goto L_0x02ea
            goto L_0x0313
        L_0x02ea:
            long r7 = r9.m5585getIdJ3iCeTQ()
            r2.element = r7
            goto L_0x034b
        L_0x02f1:
            long r7 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r14)
            if (r5 != 0) goto L_0x02fc
            float r3 = androidx.compose.ui.geometry.Offset.m3985getDistanceimpl(r7)
            goto L_0x0309
        L_0x02fc:
            androidx.compose.foundation.gestures.Orientation r3 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r5 != r3) goto L_0x0305
            float r3 = androidx.compose.ui.geometry.Offset.m3988getYimpl(r7)
            goto L_0x0309
        L_0x0305:
            float r3 = androidx.compose.ui.geometry.Offset.m3987getXimpl(r7)
        L_0x0309:
            r7 = 0
            int r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x0310
            r3 = 1
            goto L_0x0311
        L_0x0310:
            r3 = 0
        L_0x0311:
            if (r3 != 0) goto L_0x034b
        L_0x0313:
            if (r14 != 0) goto L_0x0317
            goto L_0x0263
        L_0x0317:
            boolean r2 = r14.isConsumed()
            if (r2 == 0) goto L_0x031f
            goto L_0x0263
        L_0x031f:
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r14)
            if (r2 == 0) goto L_0x0334
            r9 = r14
        L_0x0326:
            if (r9 != 0) goto L_0x032e
            kotlin.jvm.functions.Function0<kotlin.Unit> r1 = r0.$onDragCancel
            r1.invoke()
            goto L_0x034f
        L_0x032e:
            kotlin.jvm.functions.Function1<androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r1 = r0.$onDragEnd
            r1.invoke(r9)
            goto L_0x034f
        L_0x0334:
            long r2 = androidx.compose.ui.input.pointer.PointerEventKt.positionChange(r14)
            androidx.compose.ui.geometry.Offset r2 = androidx.compose.ui.geometry.Offset.m3976boximpl(r2)
            r6.invoke(r14, r2)
            r14.consume()
            long r2 = r14.m5585getIdJ3iCeTQ()
            r11 = r21
            r4 = r6
            goto L_0x0266
        L_0x034b:
            r10 = r21
            goto L_0x0271
        L_0x034f:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$9.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
