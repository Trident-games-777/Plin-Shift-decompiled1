package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2", f = "TransformGestureDetector.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {59, 61}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "rotation", "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "$this$awaitEachGesture", "rotation", "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom"}, s = {"L$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "L$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1"})
/* compiled from: TransformGestureDetector.kt */
final class TransformGestureDetectorKt$detectTransformGestures$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function4<Offset, Offset, Float, Float, Unit> $onGesture;
    final /* synthetic */ boolean $panZoomLock;
    float F$0;
    float F$1;
    float F$2;
    int I$0;
    int I$1;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransformGestureDetectorKt$detectTransformGestures$2(boolean z, Function4<? super Offset, ? super Offset, ? super Float, ? super Float, Unit> function4, Continuation<? super TransformGestureDetectorKt$detectTransformGestures$2> continuation) {
        super(2, continuation);
        this.$panZoomLock = z;
        this.$onGesture = function4;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TransformGestureDetectorKt$detectTransformGestures$2 transformGestureDetectorKt$detectTransformGestures$2 = new TransformGestureDetectorKt$detectTransformGestures$2(this.$panZoomLock, this.$onGesture, continuation);
        transformGestureDetectorKt$detectTransformGestures$2.L$0 = obj;
        return transformGestureDetectorKt$detectTransformGestures$2;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((TransformGestureDetectorKt$detectTransformGestures$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: androidx.compose.ui.input.pointer.AwaitPointerEventScope} */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x009e, code lost:
        if (r3 == r1) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0137, code lost:
        if (androidx.compose.ui.geometry.Offset.m3984equalsimpl0(r7, androidx.compose.ui.geometry.Offset.Companion.m4003getZeroF1C5BW0()) == false) goto L_0x013c;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x015c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) {
        /*
            r23 = this;
            r0 = r23
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 2
            r5 = 0
            r6 = 0
            r7 = 1
            if (r2 == 0) goto L_0x0049
            if (r2 == r7) goto L_0x0035
            if (r2 != r4) goto L_0x002d
            int r2 = r0.I$1
            float r8 = r0.F$2
            int r9 = r0.I$0
            long r10 = r0.J$0
            float r12 = r0.F$1
            float r13 = r0.F$0
            java.lang.Object r14 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r14 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r14
            kotlin.ResultKt.throwOnFailure(r24)
            r16 = r3
            r3 = r24
            goto L_0x00a1
        L_0x002d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0035:
            int r2 = r0.I$1
            float r8 = r0.F$2
            int r9 = r0.I$0
            long r10 = r0.J$0
            float r12 = r0.F$1
            float r13 = r0.F$0
            java.lang.Object r14 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r14 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r14
            kotlin.ResultKt.throwOnFailure(r24)
            goto L_0x0084
        L_0x0049:
            kotlin.ResultKt.throwOnFailure(r24)
            java.lang.Object r2 = r0.L$0
            r8 = r2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
            androidx.compose.ui.geometry.Offset$Companion r2 = androidx.compose.ui.geometry.Offset.Companion
            long r14 = r2.m4003getZeroF1C5BW0()
            androidx.compose.ui.platform.ViewConfiguration r2 = r8.getViewConfiguration()
            float r2 = r2.getTouchSlop()
            r11 = r0
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
            r0.L$0 = r8
            r0.F$0 = r5
            r0.F$1 = r3
            r0.J$0 = r14
            r0.I$0 = r6
            r0.F$2 = r2
            r0.I$1 = r6
            r0.label = r7
            r9 = 0
            r10 = 0
            r12 = 2
            r13 = 0
            java.lang.Object r9 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r8, r9, r10, r11, r12, r13)
            if (r9 != r1) goto L_0x007d
            goto L_0x00a0
        L_0x007d:
            r12 = r3
            r13 = r5
            r9 = r6
            r10 = r14
            r14 = r8
            r8 = r2
            r2 = r9
        L_0x0084:
            r15 = r0
            kotlin.coroutines.Continuation r15 = (kotlin.coroutines.Continuation) r15
            r0.L$0 = r14
            r0.F$0 = r13
            r0.F$1 = r12
            r0.J$0 = r10
            r0.I$0 = r9
            r0.F$2 = r8
            r0.I$1 = r2
            r0.label = r4
            r16 = r3
            r3 = 0
            java.lang.Object r3 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r14, r3, r15, r7, r3)
            if (r3 != r1) goto L_0x00a1
        L_0x00a0:
            return r1
        L_0x00a1:
            androidx.compose.ui.input.pointer.PointerEvent r3 = (androidx.compose.ui.input.pointer.PointerEvent) r3
            java.util.List r15 = r3.getChanges()
            int r4 = r15.size()
            r17 = r5
            r5 = r6
        L_0x00ae:
            if (r5 >= r4) goto L_0x00c1
            java.lang.Object r18 = r15.get(r5)
            androidx.compose.ui.input.pointer.PointerInputChange r18 = (androidx.compose.ui.input.pointer.PointerInputChange) r18
            boolean r18 = r18.isConsumed()
            if (r18 == 0) goto L_0x00be
            r4 = r7
            goto L_0x00c2
        L_0x00be:
            int r5 = r5 + 1
            goto L_0x00ae
        L_0x00c1:
            r4 = r6
        L_0x00c2:
            if (r4 != 0) goto L_0x0173
            float r5 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateZoom(r3)
            float r15 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateRotation(r3)
            r24 = r8
            long r7 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculatePan(r3)
            if (r9 != 0) goto L_0x0115
            float r12 = r12 * r5
            float r13 = r13 + r15
            long r10 = androidx.compose.ui.geometry.Offset.m3992plusMKHz9U(r10, r7)
            float r19 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateCentroidSize(r3, r6)
            r18 = r1
            r6 = 1
            float r1 = (float) r6
            float r1 = r1 - r12
            float r1 = java.lang.Math.abs(r1)
            float r1 = r1 * r19
            r21 = 1078530011(0x40490fdb, float:3.1415927)
            float r21 = r21 * r13
            float r21 = r21 * r19
            r19 = 1127481344(0x43340000, float:180.0)
            float r21 = r21 / r19
            float r19 = java.lang.Math.abs(r21)
            float r21 = androidx.compose.ui.geometry.Offset.m3985getDistanceimpl(r10)
            int r1 = (r1 > r24 ? 1 : (r1 == r24 ? 0 : -1))
            if (r1 > 0) goto L_0x0108
            int r1 = (r19 > r24 ? 1 : (r19 == r24 ? 0 : -1))
            if (r1 > 0) goto L_0x0108
            int r1 = (r21 > r24 ? 1 : (r21 == r24 ? 0 : -1))
            if (r1 <= 0) goto L_0x0118
        L_0x0108:
            boolean r1 = r0.$panZoomLock
            if (r1 == 0) goto L_0x0112
            int r1 = (r19 > r24 ? 1 : (r19 == r24 ? 0 : -1))
            if (r1 >= 0) goto L_0x0112
            r2 = r6
            goto L_0x0113
        L_0x0112:
            r2 = 0
        L_0x0113:
            r9 = r6
            goto L_0x0118
        L_0x0115:
            r18 = r1
            r6 = 1
        L_0x0118:
            if (r9 == 0) goto L_0x016e
            r1 = 0
            long r19 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateCentroid(r3, r1)
            if (r2 == 0) goto L_0x0123
            r15 = r17
        L_0x0123:
            int r21 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r21 != 0) goto L_0x013a
            int r21 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1))
            if (r21 != 0) goto L_0x013a
            androidx.compose.ui.geometry.Offset$Companion r21 = androidx.compose.ui.geometry.Offset.Companion
            r22 = r2
            long r1 = r21.m4003getZeroF1C5BW0()
            boolean r1 = androidx.compose.ui.geometry.Offset.m3984equalsimpl0(r7, r1)
            if (r1 != 0) goto L_0x0151
            goto L_0x013c
        L_0x013a:
            r22 = r2
        L_0x013c:
            kotlin.jvm.functions.Function4<androidx.compose.ui.geometry.Offset, androidx.compose.ui.geometry.Offset, java.lang.Float, java.lang.Float, kotlin.Unit> r1 = r0.$onGesture
            androidx.compose.ui.geometry.Offset r2 = androidx.compose.ui.geometry.Offset.m3976boximpl(r19)
            androidx.compose.ui.geometry.Offset r7 = androidx.compose.ui.geometry.Offset.m3976boximpl(r7)
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r5)
            java.lang.Float r8 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r15)
            r1.invoke(r2, r7, r5, r8)
        L_0x0151:
            java.util.List r1 = r3.getChanges()
            int r2 = r1.size()
            r5 = 0
        L_0x015a:
            if (r5 >= r2) goto L_0x0170
            java.lang.Object r7 = r1.get(r5)
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            boolean r8 = androidx.compose.ui.input.pointer.PointerEventKt.positionChanged(r7)
            if (r8 == 0) goto L_0x016b
            r7.consume()
        L_0x016b:
            int r5 = r5 + 1
            goto L_0x015a
        L_0x016e:
            r22 = r2
        L_0x0170:
            r2 = r22
            goto L_0x0178
        L_0x0173:
            r18 = r1
            r6 = r7
            r24 = r8
        L_0x0178:
            if (r4 != 0) goto L_0x01a1
            java.util.List r1 = r3.getChanges()
            int r3 = r1.size()
            r4 = 0
        L_0x0183:
            if (r4 >= r3) goto L_0x01a1
            java.lang.Object r5 = r1.get(r4)
            androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
            boolean r5 = r5.getPressed()
            if (r5 == 0) goto L_0x019e
            r8 = r24
            r7 = r6
            r3 = r16
            r5 = r17
            r1 = r18
            r4 = 2
            r6 = 0
            goto L_0x0084
        L_0x019e:
            int r4 = r4 + 1
            goto L_0x0183
        L_0x01a1:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
