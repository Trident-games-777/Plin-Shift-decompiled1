package androidx.compose.foundation.gestures;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a<\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\tH@¢\u0006\u0002\u0010\u000b\u001a<\u0010\f\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0004H\u0007\u001a&\u0010\f\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0004¨\u0006\u0012"}, d2 = {"detectZoom", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "panZoomLock", "", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/TransformEvent;", "canPan", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLkotlinx/coroutines/channels/Channel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transformable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/TransformableState;", "lockRotationOnZoomPan", "enabled", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Transformable.kt */
public final class TransformableKt {
    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, z, z2);
    }

    public static final Modifier transformable(Modifier modifier, TransformableState transformableState, boolean z, boolean z2) {
        return transformable(modifier, transformableState, TransformableKt$transformable$1.INSTANCE, z, z2);
    }

    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, Function1 function1, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, function1, z, z2);
    }

    public static final Modifier transformable(Modifier modifier, TransformableState transformableState, Function1<? super Offset, Boolean> function1, boolean z, boolean z2) {
        return modifier.then(new TransformableElement(transformableState, function1, z, z2));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0205, code lost:
        if (r13.invoke(androidx.compose.ui.geometry.Offset.m3976boximpl(r9)).booleanValue() != false) goto L_0x020f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x02b1, code lost:
        if (r6 != 0) goto L_0x02b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x02b3, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x02b8, code lost:
        r0 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x02b8 A[EDGE_INSN: B:100:0x02b8->B:84:0x02b8 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x02e2 A[EDGE_INSN: B:103:0x02e2->B:93:0x02e2 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0245  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x02a5  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02c8  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x014d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object detectZoom(androidx.compose.ui.input.pointer.AwaitPointerEventScope r30, boolean r31, kotlinx.coroutines.channels.Channel<androidx.compose.foundation.gestures.TransformEvent> r32, kotlin.jvm.functions.Function1<? super androidx.compose.ui.geometry.Offset, java.lang.Boolean> r33, kotlin.coroutines.Continuation<? super kotlin.Unit> r34) {
        /*
            r0 = r34
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.TransformableKt$detectZoom$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.TransformableKt$detectZoom$1 r1 = (androidx.compose.foundation.gestures.TransformableKt$detectZoom$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.TransformableKt$detectZoom$1 r1 = new androidx.compose.foundation.gestures.TransformableKt$detectZoom$1
            r1.<init>(r0)
        L_0x001b:
            r5 = r1
            java.lang.Object r0 = r5.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r5.label
            r9 = 3
            r10 = 2
            r13 = 1
            if (r2 == 0) goto L_0x00b6
            if (r2 == r13) goto L_0x0093
            if (r2 == r10) goto L_0x006b
            if (r2 != r9) goto L_0x0063
            int r2 = r5.I$2
            int r3 = r5.I$1
            float r4 = r5.F$2
            int r6 = r5.I$0
            long r14 = r5.J$0
            float r7 = r5.F$1
            float r9 = r5.F$0
            boolean r10 = r5.Z$0
            java.lang.Object r13 = r5.L$3
            androidx.compose.ui.input.pointer.PointerEvent r13 = (androidx.compose.ui.input.pointer.PointerEvent) r13
            java.lang.Object r12 = r5.L$2
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            java.lang.Object r8 = r5.L$1
            kotlinx.coroutines.channels.Channel r8 = (kotlinx.coroutines.channels.Channel) r8
            java.lang.Object r11 = r5.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
            kotlin.ResultKt.throwOnFailure(r0)
            r16 = r8
            r8 = r7
            r7 = r16
            r16 = r11
            r11 = r12
            r18 = 1065353216(0x3f800000, float:1.0)
            r19 = 0
            r12 = r10
            r10 = r0
            r0 = 3
            goto L_0x0296
        L_0x0063:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x006b:
            int r2 = r5.I$1
            float r3 = r5.F$2
            int r4 = r5.I$0
            long r6 = r5.J$0
            float r8 = r5.F$1
            float r9 = r5.F$0
            boolean r10 = r5.Z$0
            java.lang.Object r11 = r5.L$2
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            java.lang.Object r12 = r5.L$1
            kotlinx.coroutines.channels.Channel r12 = (kotlinx.coroutines.channels.Channel) r12
            java.lang.Object r13 = r5.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
            kotlin.ResultKt.throwOnFailure(r0)
            r14 = r9
            r9 = r8
            r8 = r12
            r12 = r10
            r10 = r14
            r14 = r13
            r13 = r11
            r11 = r14
            r14 = 2
            goto L_0x012d
        L_0x0093:
            int r2 = r5.I$1
            float r3 = r5.F$2
            int r4 = r5.I$0
            long r6 = r5.J$0
            float r8 = r5.F$1
            float r9 = r5.F$0
            boolean r10 = r5.Z$0
            java.lang.Object r11 = r5.L$2
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            java.lang.Object r12 = r5.L$1
            kotlinx.coroutines.channels.Channel r12 = (kotlinx.coroutines.channels.Channel) r12
            java.lang.Object r13 = r5.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
            kotlin.ResultKt.throwOnFailure(r0)
            r28 = r12
            r12 = r10
            r10 = r28
            goto L_0x00ff
        L_0x00b6:
            kotlin.ResultKt.throwOnFailure(r0)
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r8 = r0.m4003getZeroF1C5BW0()
            androidx.compose.ui.platform.ViewConfiguration r0 = r30.getViewConfiguration()
            float r0 = r0.getTouchSlop()
            r2 = r30
            r5.L$0 = r2
            r10 = r32
            r5.L$1 = r10
            r11 = r33
            r5.L$2 = r11
            r12 = r31
            r5.Z$0 = r12
            r3 = 0
            r5.F$0 = r3
            r3 = 1065353216(0x3f800000, float:1.0)
            r5.F$1 = r3
            r5.J$0 = r8
            r3 = 0
            r5.I$0 = r3
            r5.F$2 = r0
            r5.I$1 = r3
            r3 = 1
            r5.label = r3
            r3 = 0
            r4 = 0
            r6 = 2
            r7 = 0
            java.lang.Object r3 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r2, r3, r4, r5, r6, r7)
            if (r3 != r1) goto L_0x00f6
            goto L_0x0286
        L_0x00f6:
            r3 = r0
            r6 = r8
            r2 = 0
            r4 = 0
            r8 = 1065353216(0x3f800000, float:1.0)
            r9 = 0
            r13 = r30
        L_0x00ff:
            r5.L$0 = r13
            r5.L$1 = r10
            r5.L$2 = r11
            r0 = 0
            r5.L$3 = r0
            r5.Z$0 = r12
            r5.F$0 = r9
            r5.F$1 = r8
            r5.J$0 = r6
            r5.I$0 = r4
            r5.F$2 = r3
            r5.I$1 = r2
            r14 = 2
            r5.label = r14
            r15 = 1
            java.lang.Object r0 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r13, r0, r5, r15, r0)
            if (r0 != r1) goto L_0x0122
            goto L_0x0286
        L_0x0122:
            r28 = r9
            r9 = r8
            r8 = r10
            r10 = r28
            r28 = r13
            r13 = r11
            r11 = r28
        L_0x012d:
            androidx.compose.ui.input.pointer.PointerEvent r0 = (androidx.compose.ui.input.pointer.PointerEvent) r0
            java.util.List r15 = r0.getChanges()
            int r14 = r15.size()
            r30 = r2
            r2 = 0
        L_0x013a:
            if (r2 >= r14) goto L_0x014d
            java.lang.Object r20 = r15.get(r2)
            androidx.compose.ui.input.pointer.PointerInputChange r20 = (androidx.compose.ui.input.pointer.PointerInputChange) r20
            boolean r20 = r20.isConsumed()
            if (r20 == 0) goto L_0x014a
            r2 = 1
            goto L_0x014e
        L_0x014a:
            int r2 = r2 + 1
            goto L_0x013a
        L_0x014d:
            r2 = 0
        L_0x014e:
            if (r2 != 0) goto L_0x0245
            float r21 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateZoom(r0)
            float r14 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateRotation(r0)
            r31 = r9
            r32 = r10
            long r9 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculatePan(r0)
            if (r4 != 0) goto L_0x01c7
            float r15 = r31 * r21
            float r20 = r32 + r14
            long r6 = androidx.compose.ui.geometry.Offset.m3992plusMKHz9U(r6, r9)
            r33 = r4
            r4 = 0
            float r17 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateCentroidSize(r0, r4)
            r31 = r6
            r4 = 1
            float r6 = (float) r4
            float r6 = r6 - r15
            float r6 = java.lang.Math.abs(r6)
            float r6 = r6 * r17
            r7 = 1078530011(0x40490fdb, float:3.1415927)
            float r7 = r7 * r20
            float r7 = r7 * r17
            r16 = 1127481344(0x43340000, float:180.0)
            float r7 = r7 / r16
            float r7 = java.lang.Math.abs(r7)
            float r16 = androidx.compose.ui.geometry.Offset.m3985getDistanceimpl(r31)
            int r6 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r6 > 0) goto L_0x01b5
            int r6 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r6 > 0) goto L_0x01b5
            int r6 = (r16 > r3 ? 1 : (r16 == r3 ? 0 : -1))
            if (r6 <= 0) goto L_0x01ac
            androidx.compose.ui.geometry.Offset r6 = androidx.compose.ui.geometry.Offset.m3976boximpl(r9)
            java.lang.Object r6 = r13.invoke(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x01ac
            goto L_0x01b5
        L_0x01ac:
            r6 = r30
            r16 = r31
            r7 = r33
        L_0x01b2:
            r26 = r20
            goto L_0x01d4
        L_0x01b5:
            if (r12 == 0) goto L_0x01bd
            int r6 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x01bd
            r6 = r4
            goto L_0x01be
        L_0x01bd:
            r6 = 0
        L_0x01be:
            androidx.compose.foundation.gestures.TransformEvent$TransformStarted r7 = androidx.compose.foundation.gestures.TransformEvent.TransformStarted.INSTANCE
            r8.m9382trySendJP2dKIU(r7)
            r16 = r31
            r7 = r4
            goto L_0x01b2
        L_0x01c7:
            r33 = r4
            r4 = 1
            r15 = r31
            r26 = r32
            r16 = r6
            r6 = r30
            r7 = r33
        L_0x01d4:
            if (r7 == 0) goto L_0x023a
            if (r6 == 0) goto L_0x01db
            r24 = 0
            goto L_0x01dd
        L_0x01db:
            r24 = r14
        L_0x01dd:
            r19 = 0
            int r14 = (r24 > r19 ? 1 : (r24 == r19 ? 0 : -1))
            if (r14 != 0) goto L_0x020b
            r18 = 1065353216(0x3f800000, float:1.0)
            int r14 = (r21 > r18 ? 1 : (r21 == r18 ? 0 : -1))
            if (r14 != 0) goto L_0x0208
            androidx.compose.ui.geometry.Offset$Companion r14 = androidx.compose.ui.geometry.Offset.Companion
            r27 = r5
            long r4 = r14.m4003getZeroF1C5BW0()
            boolean r4 = androidx.compose.ui.geometry.Offset.m3984equalsimpl0(r9, r4)
            if (r4 != 0) goto L_0x021d
            androidx.compose.ui.geometry.Offset r4 = androidx.compose.ui.geometry.Offset.m3976boximpl(r9)
            java.lang.Object r4 = r13.invoke(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x021d
            goto L_0x020f
        L_0x0208:
            r27 = r5
            goto L_0x020f
        L_0x020b:
            r27 = r5
            r18 = 1065353216(0x3f800000, float:1.0)
        L_0x020f:
            androidx.compose.foundation.gestures.TransformEvent$TransformDelta r20 = new androidx.compose.foundation.gestures.TransformEvent$TransformDelta
            r25 = 0
            r22 = r9
            r20.<init>(r21, r22, r24, r25)
            r4 = r20
            r8.m9382trySendJP2dKIU(r4)
        L_0x021d:
            java.util.List r4 = r0.getChanges()
            int r5 = r4.size()
            r9 = 0
        L_0x0226:
            if (r9 >= r5) goto L_0x0240
            java.lang.Object r10 = r4.get(r9)
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            boolean r14 = androidx.compose.ui.input.pointer.PointerEventKt.positionChanged(r10)
            if (r14 == 0) goto L_0x0237
            r10.consume()
        L_0x0237:
            int r9 = r9 + 1
            goto L_0x0226
        L_0x023a:
            r27 = r5
            r18 = 1065353216(0x3f800000, float:1.0)
            r19 = 0
        L_0x0240:
            r4 = r16
            r9 = r26
            goto L_0x025f
        L_0x0245:
            r33 = r4
            r27 = r5
            r31 = r9
            r32 = r10
            r18 = 1065353216(0x3f800000, float:1.0)
            r19 = 0
            androidx.compose.foundation.gestures.TransformEvent$TransformStopped r4 = androidx.compose.foundation.gestures.TransformEvent.TransformStopped.INSTANCE
            r8.m9382trySendJP2dKIU(r4)
            r15 = r31
            r9 = r32
            r4 = r6
            r6 = r30
            r7 = r33
        L_0x025f:
            androidx.compose.ui.input.pointer.PointerEventPass r10 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r14 = r27
            r14.L$0 = r11
            r14.L$1 = r8
            r14.L$2 = r13
            r14.L$3 = r0
            r14.Z$0 = r12
            r14.F$0 = r9
            r14.F$1 = r15
            r14.J$0 = r4
            r14.I$0 = r7
            r14.F$2 = r3
            r14.I$1 = r6
            r14.I$2 = r2
            r30 = r0
            r0 = 3
            r14.label = r0
            java.lang.Object r10 = r11.awaitPointerEvent(r10, r14)
            if (r10 != r1) goto L_0x0287
        L_0x0286:
            return r1
        L_0x0287:
            r16 = r11
            r11 = r13
            r13 = r30
            r28 = r4
            r4 = r3
            r3 = r6
            r6 = r7
            r7 = r8
            r5 = r14
            r8 = r15
            r14 = r28
        L_0x0296:
            androidx.compose.ui.input.pointer.PointerEvent r10 = (androidx.compose.ui.input.pointer.PointerEvent) r10
            java.util.List r10 = r10.getChanges()
            int r0 = r10.size()
            r17 = r1
            r1 = 0
        L_0x02a3:
            if (r1 >= r0) goto L_0x02b8
            java.lang.Object r20 = r10.get(r1)
            androidx.compose.ui.input.pointer.PointerInputChange r20 = (androidx.compose.ui.input.pointer.PointerInputChange) r20
            boolean r20 = r20.isConsumed()
            if (r20 == 0) goto L_0x02b5
            if (r6 != 0) goto L_0x02b8
            r0 = 1
            goto L_0x02b9
        L_0x02b5:
            int r1 = r1 + 1
            goto L_0x02a3
        L_0x02b8:
            r0 = 0
        L_0x02b9:
            if (r2 != 0) goto L_0x02e2
            if (r0 != 0) goto L_0x02e2
            java.util.List r0 = r13.getChanges()
            int r1 = r0.size()
            r2 = 0
        L_0x02c6:
            if (r2 >= r1) goto L_0x02e2
            java.lang.Object r10 = r0.get(r2)
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            boolean r10 = r10.getPressed()
            if (r10 == 0) goto L_0x02df
            r2 = r3
            r3 = r4
            r4 = r6
            r10 = r7
            r6 = r14
            r13 = r16
            r1 = r17
            goto L_0x00ff
        L_0x02df:
            int r2 = r2 + 1
            goto L_0x02c6
        L_0x02e2:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt.detectZoom(androidx.compose.ui.input.pointer.AwaitPointerEventScope, boolean, kotlinx.coroutines.channels.Channel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
