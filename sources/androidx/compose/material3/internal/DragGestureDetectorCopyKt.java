package androidx.compose.material3.internal;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aa\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f26\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\u000eH@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001aW\u0010\u0016\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u000e2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00050\u0018HHø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001e\u0010\u001c\u001a\u00020\u001d*\u00020\u001e2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u001e\u0010!\u001a\u00020\u0005*\u00020\"2\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\b#\u0010$\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006%"}, d2 = {"defaultTouchSlop", "Landroidx/compose/ui/unit/Dp;", "F", "mouseSlop", "mouseToTouchSlopRatio", "", "awaitHorizontalPointerSlopOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "onPointerSlopReached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "change", "overSlop", "", "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitPointerSlopOrCancellation", "getDragDirectionValue", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "awaitPointerSlopOrCancellation-pn7EDYM", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isPointerUp", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "pointerSlop", "Landroidx/compose/ui/platform/ViewConfiguration;", "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DragGestureDetectorCopy.kt */
public final class DragGestureDetectorCopyKt {
    private static final float defaultTouchSlop;
    private static final float mouseSlop;
    private static final float mouseToTouchSlopRatio;

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0166 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00e9 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* renamed from: awaitHorizontalPointerSlopOrCancellation-gDDlDlE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m2906awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope r20, long r21, int r23, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r24, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r25) {
        /*
            r0 = r21
            r2 = r25
            boolean r3 = r2 instanceof androidx.compose.material3.internal.DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.material3.internal.DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1 r3 = (androidx.compose.material3.internal.DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.material3.internal.DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1 r3 = new androidx.compose.material3.internal.DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 0
            r7 = 2
            r8 = 1
            r9 = 0
            if (r5 == 0) goto L_0x0078
            if (r5 == r8) goto L_0x0058
            if (r5 != r7) goto L_0x0050
            float r0 = r3.F$1
            float r1 = r3.F$0
            java.lang.Object r5 = r3.L$3
            androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
            java.lang.Object r10 = r3.L$2
            kotlin.jvm.internal.Ref$LongRef r10 = (kotlin.jvm.internal.Ref.LongRef) r10
            java.lang.Object r11 = r3.L$1
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
            java.lang.Object r12 = r3.L$0
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r0
            r18 = r9
            r0 = r11
            r11 = r10
            r10 = r3
            r3 = r1
            r1 = r12
            goto L_0x0160
        L_0x0050:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0058:
            float r0 = r3.F$1
            float r1 = r3.F$0
            java.lang.Object r5 = r3.L$2
            kotlin.jvm.internal.Ref$LongRef r5 = (kotlin.jvm.internal.Ref.LongRef) r5
            java.lang.Object r10 = r3.L$1
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            java.lang.Object r11 = r3.L$0
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            kotlin.ResultKt.throwOnFailure(r2)
            r19 = r3
            r3 = r0
            r0 = r10
            r10 = r19
            r19 = r5
            r5 = r1
            r1 = r11
            r11 = r19
            goto L_0x00bd
        L_0x0078:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.ui.input.pointer.PointerEvent r2 = r20.getCurrentEvent()
            boolean r2 = m2908isPointerUpDmW0f2w(r2, r0)
            if (r2 == 0) goto L_0x0086
            return r9
        L_0x0086:
            androidx.compose.ui.platform.ViewConfiguration r2 = r20.getViewConfiguration()
            r5 = r23
            float r2 = m2909pointerSlopE8SPZFQ(r2, r5)
            kotlin.jvm.internal.Ref$LongRef r5 = new kotlin.jvm.internal.Ref$LongRef
            r5.<init>()
            r5.element = r0
            r0 = r20
            r1 = r24
            r10 = r5
            r5 = r3
            r3 = r2
            r2 = r6
        L_0x009f:
            r5.L$0 = r1
            r5.L$1 = r0
            r5.L$2 = r10
            r5.L$3 = r9
            r5.F$0 = r3
            r5.F$1 = r2
            r5.label = r8
            java.lang.Object r11 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r0, r9, r5, r8, r9)
            if (r11 != r4) goto L_0x00b5
            goto L_0x015d
        L_0x00b5:
            r19 = r3
            r3 = r2
            r2 = r11
            r11 = r10
            r10 = r5
            r5 = r19
        L_0x00bd:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r12 = r2.getChanges()
            int r13 = r12.size()
            r15 = 0
        L_0x00c8:
            if (r15 >= r13) goto L_0x00e9
            java.lang.Object r16 = r12.get(r15)
            r17 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r17 = (androidx.compose.ui.input.pointer.PointerInputChange) r17
            r18 = r9
            long r8 = r17.m5585getIdJ3iCeTQ()
            r17 = r15
            long r14 = r11.element
            boolean r8 = androidx.compose.ui.input.pointer.PointerId.m5569equalsimpl0(r8, r14)
            if (r8 == 0) goto L_0x00e3
            goto L_0x00ed
        L_0x00e3:
            int r15 = r17 + 1
            r9 = r18
            r8 = 1
            goto L_0x00c8
        L_0x00e9:
            r18 = r9
            r16 = r18
        L_0x00ed:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r16)
            r8 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            boolean r9 = r8.isConsumed()
            if (r9 == 0) goto L_0x00fb
            return r18
        L_0x00fb:
            boolean r9 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r8)
            if (r9 == 0) goto L_0x012d
            java.util.List r2 = r2.getChanges()
            int r8 = r2.size()
            r14 = 0
        L_0x010a:
            if (r14 >= r8) goto L_0x011d
            java.lang.Object r9 = r2.get(r14)
            r12 = r9
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            boolean r12 = r12.getPressed()
            if (r12 == 0) goto L_0x011a
            goto L_0x011f
        L_0x011a:
            int r14 = r14 + 1
            goto L_0x010a
        L_0x011d:
            r9 = r18
        L_0x011f:
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            if (r9 != 0) goto L_0x0124
            return r18
        L_0x0124:
            long r8 = r9.m5585getIdJ3iCeTQ()
            r11.element = r8
            r2 = r3
            r3 = r5
            goto L_0x0167
        L_0x012d:
            long r12 = r8.m5587getPositionF1C5BW0()
            long r14 = r8.m5588getPreviousPositionF1C5BW0()
            float r2 = androidx.compose.ui.geometry.Offset.m3987getXimpl(r12)
            float r9 = androidx.compose.ui.geometry.Offset.m3987getXimpl(r14)
            float r2 = r2 - r9
            float r2 = r2 + r3
            float r3 = java.lang.Math.abs(r2)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x016e
            androidx.compose.ui.input.pointer.PointerEventPass r3 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r10.L$0 = r1
            r10.L$1 = r0
            r10.L$2 = r11
            r10.L$3 = r8
            r10.F$0 = r5
            r10.F$1 = r2
            r10.label = r7
            java.lang.Object r3 = r0.awaitPointerEvent(r3, r10)
            if (r3 != r4) goto L_0x015e
        L_0x015d:
            return r4
        L_0x015e:
            r3 = r5
            r5 = r8
        L_0x0160:
            boolean r5 = r5.isConsumed()
            if (r5 == 0) goto L_0x0167
            return r18
        L_0x0167:
            r5 = r10
            r10 = r11
            r9 = r18
            r8 = 1
            goto L_0x009f
        L_0x016e:
            float r3 = java.lang.Math.signum(r2)
            float r3 = r3 * r5
            float r2 = r2 - r3
            java.lang.Float r2 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r2)
            r1.invoke(r8, r2)
            boolean r2 = r8.isConsumed()
            if (r2 == 0) goto L_0x0182
            return r8
        L_0x0182:
            r3 = r5
            r2 = r6
            goto L_0x0167
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.DragGestureDetectorCopyKt.m2906awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: awaitPointerSlopOrCancellation-pn7EDYM  reason: not valid java name */
    private static final Object m2907awaitPointerSlopOrCancellationpn7EDYM(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Function2<? super PointerInputChange, ? super Float, Unit> function2, Function1<? super Offset, Float> function1, Continuation<? super PointerInputChange> continuation) {
        float f;
        PointerInputChange pointerInputChange;
        float f2;
        PointerInputChange pointerInputChange2;
        AwaitPointerEventScope awaitPointerEventScope2 = awaitPointerEventScope;
        long j2 = j;
        Function1<? super Offset, Float> function12 = function1;
        Continuation<? super PointerInputChange> continuation2 = continuation;
        if (m2908isPointerUpDmW0f2w(awaitPointerEventScope2.getCurrentEvent(), j2)) {
            return null;
        }
        float r5 = m2909pointerSlopE8SPZFQ(awaitPointerEventScope2.getViewConfiguration(), i);
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = j2;
        float f3 = 0.0f;
        while (true) {
            PointerEvent pointerEvent = (PointerEvent) AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, (PointerEventPass) null, continuation2, 1, (Object) null);
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    f = f3;
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i3);
                f = f3;
                Boolean valueOf = Boolean.valueOf(PointerId.m5569equalsimpl0(pointerInputChange.m5585getIdJ3iCeTQ(), longRef.element));
                Boolean bool = valueOf;
                if (valueOf.booleanValue()) {
                    break;
                }
                i3++;
                f3 = f;
            }
            Intrinsics.checkNotNull(pointerInputChange);
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3.isConsumed()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                while (true) {
                    if (i2 >= size2) {
                        pointerInputChange2 = null;
                        break;
                    }
                    pointerInputChange2 = changes2.get(i2);
                    Boolean valueOf2 = Boolean.valueOf(pointerInputChange2.getPressed());
                    Boolean bool2 = valueOf2;
                    if (valueOf2.booleanValue()) {
                        break;
                    }
                    i2++;
                }
                PointerInputChange pointerInputChange4 = pointerInputChange2;
                if (pointerInputChange4 == null) {
                    return null;
                }
                longRef.element = pointerInputChange4.m5585getIdJ3iCeTQ();
                f2 = f;
            } else {
                float floatValue = f + (function12.invoke(Offset.m3976boximpl(pointerInputChange3.m5587getPositionF1C5BW0())).floatValue() - function12.invoke(Offset.m3976boximpl(pointerInputChange3.m5588getPreviousPositionF1C5BW0())).floatValue());
                if (Math.abs(floatValue) < r5) {
                    awaitPointerEventScope2.awaitPointerEvent(PointerEventPass.Final, continuation2);
                    if (pointerInputChange3.isConsumed()) {
                        return null;
                    }
                    f2 = floatValue;
                } else {
                    function2.invoke(pointerInputChange3, Float.valueOf(floatValue - (Math.signum(floatValue) * r5)));
                    if (pointerInputChange3.isConsumed()) {
                        return pointerInputChange3;
                    }
                    f2 = 0.0f;
                    f3 = f2;
                }
            }
            Function2<? super PointerInputChange, ? super Float, Unit> function22 = function2;
            f3 = f2;
        }
    }

    /* renamed from: isPointerUp-DmW0f2w  reason: not valid java name */
    private static final boolean m2908isPointerUpDmW0f2w(PointerEvent pointerEvent, long j) {
        PointerInputChange pointerInputChange;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                pointerInputChange = null;
                break;
            }
            pointerInputChange = changes.get(i);
            if (PointerId.m5569equalsimpl0(pointerInputChange.m5585getIdJ3iCeTQ(), j)) {
                break;
            }
            i++;
        }
        PointerInputChange pointerInputChange2 = pointerInputChange;
        if (pointerInputChange2 != null && pointerInputChange2.getPressed()) {
            z = true;
        }
        return true ^ z;
    }

    /* renamed from: pointerSlop-E8SPZFQ  reason: not valid java name */
    public static final float m2909pointerSlopE8SPZFQ(ViewConfiguration viewConfiguration, int i) {
        if (PointerType.m5662equalsimpl0(i, PointerType.Companion.m5667getMouseT8wyACA())) {
            return viewConfiguration.getTouchSlop() * mouseToTouchSlopRatio;
        }
        return viewConfiguration.getTouchSlop();
    }

    static {
        float r0 = Dp.m7111constructorimpl((float) 0.125d);
        mouseSlop = r0;
        float r1 = Dp.m7111constructorimpl((float) 18);
        defaultTouchSlop = r1;
        mouseToTouchSlopRatio = r0 / r1;
    }
}
