package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a!\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a5\u0010\r\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100\u000fHHø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a!\u0010\u0013\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\f\u001aa\u0010\u0015\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u001726\u0010\u0018\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u0019H@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001aY\u0010!\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n26\u0010\"\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u0019H@ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a!\u0010%\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0004\b&\u0010\f\u001aM\u0010'\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010(\u001a\u0004\u0018\u00010)2\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001e0\u0019HHø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001aY\u0010-\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n26\u0010\"\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110*¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u0019H@ø\u0001\u0000¢\u0006\u0004\b.\u0010$\u001a!\u0010/\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0004\b0\u0010\f\u001aa\u00101\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u001726\u0010\"\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u0019H@ø\u0001\u0000¢\u0006\u0004\b2\u0010 \u001aY\u00103\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n26\u0010\"\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u0019H@ø\u0001\u0000¢\u0006\u0004\b4\u0010$\u001a\u0001\u00105\u001a\u00020\u001e*\u0002062\u0014\b\u0002\u00107\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001e0\u000f2\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020\u001e092\u000e\b\u0002\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001e0926\u0010;\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110*¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001e0\u0019H@¢\u0006\u0002\u0010=\u001aà\u0001\u00105\u001a\u00020\u001e*\u0002062K\u00107\u001aG\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(?\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(@\u0012\u0013\u0012\u00110*¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020\u001e0>2!\u00108\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001e0\u000f2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001e092\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u0010092\b\u0010C\u001a\u0004\u0018\u00010)26\u0010;\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110*¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001e0\u0019H@¢\u0006\u0002\u0010D\u001a\u0001\u0010E\u001a\u00020\u001e*\u0002062\u0014\b\u0002\u00107\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001e0\u000f2\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020\u001e092\u000e\b\u0002\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001e0926\u0010;\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110*¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001e0\u0019H@¢\u0006\u0002\u0010=\u001a\u0001\u0010F\u001a\u00020\u001e*\u0002062\u0014\b\u0002\u00107\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001e0\u000f2\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020\u001e092\u000e\b\u0002\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001e0926\u0010G\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001e0\u0019H@¢\u0006\u0002\u0010=\u001a\u0001\u0010H\u001a\u00020\u001e*\u0002062\u0014\b\u0002\u00107\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001e0\u000f2\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020\u001e092\u000e\b\u0002\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001e0926\u0010I\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001e0\u0019H@¢\u0006\u0002\u0010=\u001a3\u0010J\u001a\u00020\u0010*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e0\u000fH@ø\u0001\u0000¢\u0006\u0004\bK\u0010\u0012\u001aS\u0010J\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e0\u000f2\b\u0010(\u001a\u0004\u0018\u00010)2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100\u000fHHø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001a3\u0010O\u001a\u00020\u0010*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e0\u000fH@ø\u0001\u0000¢\u0006\u0004\bP\u0010\u0012\u001a\u001e\u0010Q\u001a\u00020\u0010*\u00020R2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001a\u001e\u0010U\u001a\u00020\u0005*\u00020V2\u0006\u0010\u0016\u001a\u00020\u0017H\u0000ø\u0001\u0000¢\u0006\u0004\bW\u0010X\u001a3\u0010Y\u001a\u00020\u0010*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e0\u000fH@ø\u0001\u0000¢\u0006\u0004\bZ\u0010\u0012\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006["}, d2 = {"defaultTouchSlop", "Landroidx/compose/ui/unit/Dp;", "F", "mouseSlop", "mouseToTouchSlopRatio", "", "awaitDragOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "awaitDragOrCancellation-rnUCldI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDragOrUp", "hasDragged", "Lkotlin/Function1;", "", "awaitDragOrUp-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitHorizontalDragOrCancellation", "awaitHorizontalDragOrCancellation-rnUCldI", "awaitHorizontalPointerSlopOrCancellation", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "onPointerSlopReached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "change", "overSlop", "", "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitHorizontalTouchSlopOrCancellation", "onTouchSlopReached", "awaitHorizontalTouchSlopOrCancellation-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitLongPressOrCancellation", "awaitLongPressOrCancellation-rnUCldI", "awaitPointerSlopOrCancellation", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "Landroidx/compose/ui/geometry/Offset;", "awaitPointerSlopOrCancellation-pn7EDYM", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILandroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitTouchSlopOrCancellation", "awaitTouchSlopOrCancellation-jO51t88", "awaitVerticalDragOrCancellation", "awaitVerticalDragOrCancellation-rnUCldI", "awaitVerticalPointerSlopOrCancellation", "awaitVerticalPointerSlopOrCancellation-gDDlDlE", "awaitVerticalTouchSlopOrCancellation", "awaitVerticalTouchSlopOrCancellation-jO51t88", "detectDragGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDragStart", "onDragEnd", "Lkotlin/Function0;", "onDragCancel", "onDrag", "dragAmount", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function3;", "down", "slopTriggerChange", "overSlopOffset", "shouldAwaitTouchSlop", "orientationLock", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectDragGesturesAfterLongPress", "detectHorizontalDragGestures", "onHorizontalDrag", "detectVerticalDragGestures", "onVerticalDrag", "drag", "drag-jO51t88", "motionConsumed", "drag-VnAYq1g", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "horizontalDrag", "horizontalDrag-jO51t88", "isPointerUp", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "pointerSlop", "Landroidx/compose/ui/platform/ViewConfiguration;", "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "verticalDrag", "verticalDrag-jO51t88", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DragGestureDetector.kt */
public final class DragGestureDetectorKt {
    private static final float defaultTouchSlop;
    private static final float mouseSlop;
    private static final float mouseToTouchSlopRatio;

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0100 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00f0 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* renamed from: awaitTouchSlopOrCancellation-jO51t88  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m447awaitTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r19, long r20, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super androidx.compose.ui.geometry.Offset, kotlin.Unit> r22, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r23) {
        /*
            r0 = r20
            r2 = r23
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitTouchSlopOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitTouchSlopOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitTouchSlopOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitTouchSlopOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitTouchSlopOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 2
            r7 = 1
            r8 = 0
            if (r5 == 0) goto L_0x0076
            if (r5 == r7) goto L_0x0057
            if (r5 != r6) goto L_0x004f
            float r0 = r3.F$0
            java.lang.Object r1 = r3.L$4
            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
            java.lang.Object r5 = r3.L$3
            androidx.compose.foundation.gestures.TouchSlopDetector r5 = (androidx.compose.foundation.gestures.TouchSlopDetector) r5
            java.lang.Object r9 = r3.L$2
            kotlin.jvm.internal.Ref$LongRef r9 = (kotlin.jvm.internal.Ref.LongRef) r9
            java.lang.Object r10 = r3.L$1
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            java.lang.Object r11 = r3.L$0
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r5
            r17 = r8
            r5 = r3
            r3 = r0
            r0 = r10
            goto L_0x0166
        L_0x004f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0057:
            float r0 = r3.F$0
            java.lang.Object r1 = r3.L$3
            androidx.compose.foundation.gestures.TouchSlopDetector r1 = (androidx.compose.foundation.gestures.TouchSlopDetector) r1
            java.lang.Object r5 = r3.L$2
            kotlin.jvm.internal.Ref$LongRef r5 = (kotlin.jvm.internal.Ref.LongRef) r5
            java.lang.Object r9 = r3.L$1
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r9 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r9
            java.lang.Object r10 = r3.L$0
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            kotlin.ResultKt.throwOnFailure(r2)
            r18 = r5
            r5 = r0
            r0 = r9
            r9 = r3
            r3 = r1
            r1 = r10
            r10 = r18
            goto L_0x00c4
        L_0x0076:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.ui.input.pointer.PointerType$Companion r2 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r2 = r2.m5669getTouchT8wyACA()
            androidx.compose.ui.input.pointer.PointerEvent r5 = r19.getCurrentEvent()
            boolean r5 = m455isPointerUpDmW0f2w(r5, r0)
            if (r5 == 0) goto L_0x008a
            return r8
        L_0x008a:
            androidx.compose.ui.platform.ViewConfiguration r5 = r19.getViewConfiguration()
            float r2 = m456pointerSlopE8SPZFQ(r5, r2)
            kotlin.jvm.internal.Ref$LongRef r5 = new kotlin.jvm.internal.Ref$LongRef
            r5.<init>()
            r5.element = r0
            androidx.compose.foundation.gestures.TouchSlopDetector r0 = new androidx.compose.foundation.gestures.TouchSlopDetector
            r0.<init>(r8)
            r1 = r22
            r9 = r5
            r5 = r3
            r3 = r2
            r2 = r0
            r0 = r19
        L_0x00a6:
            r5.L$0 = r1
            r5.L$1 = r0
            r5.L$2 = r9
            r5.L$3 = r2
            r5.L$4 = r8
            r5.F$0 = r3
            r5.label = r7
            java.lang.Object r10 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r0, r8, r5, r7, r8)
            if (r10 != r4) goto L_0x00bc
            goto L_0x015f
        L_0x00bc:
            r18 = r3
            r3 = r2
            r2 = r10
            r10 = r9
            r9 = r5
            r5 = r18
        L_0x00c4:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r11 = r2.getChanges()
            int r12 = r11.size()
            r14 = 0
        L_0x00cf:
            if (r14 >= r12) goto L_0x00f0
            java.lang.Object r15 = r11.get(r14)
            r16 = r15
            androidx.compose.ui.input.pointer.PointerInputChange r16 = (androidx.compose.ui.input.pointer.PointerInputChange) r16
            r17 = r8
            long r7 = r16.m5585getIdJ3iCeTQ()
            r16 = r14
            long r13 = r10.element
            boolean r7 = androidx.compose.ui.input.pointer.PointerId.m5569equalsimpl0(r7, r13)
            if (r7 == 0) goto L_0x00ea
            goto L_0x00f4
        L_0x00ea:
            int r14 = r16 + 1
            r8 = r17
            r7 = 1
            goto L_0x00cf
        L_0x00f0:
            r17 = r8
            r15 = r17
        L_0x00f4:
            r7 = r15
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            if (r7 != 0) goto L_0x00fa
            return r17
        L_0x00fa:
            boolean r8 = r7.isConsumed()
            if (r8 == 0) goto L_0x0101
            return r17
        L_0x0101:
            boolean r8 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r7)
            if (r8 == 0) goto L_0x0131
            java.util.List r2 = r2.getChanges()
            int r7 = r2.size()
            r13 = 0
        L_0x0110:
            if (r13 >= r7) goto L_0x0123
            java.lang.Object r8 = r2.get(r13)
            r11 = r8
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            boolean r11 = r11.getPressed()
            if (r11 == 0) goto L_0x0120
            goto L_0x0125
        L_0x0120:
            int r13 = r13 + 1
            goto L_0x0110
        L_0x0123:
            r8 = r17
        L_0x0125:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 != 0) goto L_0x012a
            return r17
        L_0x012a:
            long r7 = r8.m5585getIdJ3iCeTQ()
            r10.element = r7
            goto L_0x0144
        L_0x0131:
            androidx.compose.ui.geometry.Offset r2 = r3.m563addPointerInputChangeGcwITfU(r7, r5)
            if (r2 == 0) goto L_0x0149
            r1.invoke(r7, r2)
            boolean r2 = r7.isConsumed()
            if (r2 == 0) goto L_0x0141
            return r7
        L_0x0141:
            r3.reset()
        L_0x0144:
            r2 = r3
            r3 = r5
            r5 = r9
            r9 = r10
            goto L_0x016e
        L_0x0149:
            androidx.compose.ui.input.pointer.PointerEventPass r2 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r9.L$0 = r1
            r9.L$1 = r0
            r9.L$2 = r10
            r9.L$3 = r3
            r9.L$4 = r7
            r9.F$0 = r5
            r9.label = r6
            java.lang.Object r2 = r0.awaitPointerEvent(r2, r9)
            if (r2 != r4) goto L_0x0160
        L_0x015f:
            return r4
        L_0x0160:
            r11 = r1
            r2 = r3
            r3 = r5
            r1 = r7
            r5 = r9
            r9 = r10
        L_0x0166:
            boolean r1 = r1.isConsumed()
            if (r1 == 0) goto L_0x016d
            return r17
        L_0x016d:
            r1 = r11
        L_0x016e:
            r8 = r17
            r7 = 1
            goto L_0x00a6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m447awaitTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: drag-jO51t88  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m453dragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r4, long r5, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1 r0 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1 r0 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1
            r0.<init>(r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r4 = r0.L$1
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            java.lang.Object r5 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
            kotlin.ResultKt.throwOnFailure(r8)
            r7 = r4
            r4 = r5
            goto L_0x004c
        L_0x0034:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r8)
        L_0x003f:
            r0.L$0 = r4
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r8 = m440awaitDragOrCancellationrnUCldI(r4, r5, r0)
            if (r8 != r1) goto L_0x004c
            return r1
        L_0x004c:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 != 0) goto L_0x0056
            r4 = 0
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r4
        L_0x0056:
            boolean r5 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r8)
            if (r5 == 0) goto L_0x0061
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r4
        L_0x0061:
            r7.invoke(r8)
            long r5 = r8.m5585getIdJ3iCeTQ()
            goto L_0x003f
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m453dragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00cb, code lost:
        if (androidx.compose.ui.input.pointer.PointerEventKt.positionChangedIgnoreConsumed(r11) != false) goto L_0x00cd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0092 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* renamed from: awaitDragOrCancellation-rnUCldI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m440awaitDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r20) {
        /*
            r0 = r18
            r2 = r20
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitDragOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitDragOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitDragOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitDragOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitDragOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 1
            r7 = 0
            if (r5 == 0) goto L_0x0044
            if (r5 != r6) goto L_0x003c
            java.lang.Object r0 = r3.L$1
            kotlin.jvm.internal.Ref$LongRef r0 = (kotlin.jvm.internal.Ref.LongRef) r0
            java.lang.Object r1 = r3.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r2)
            r16 = r1
            r1 = r0
            r0 = r16
            goto L_0x006d
        L_0x003c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.ui.input.pointer.PointerEvent r2 = r17.getCurrentEvent()
            boolean r2 = m455isPointerUpDmW0f2w(r2, r0)
            if (r2 == 0) goto L_0x0052
            return r7
        L_0x0052:
            kotlin.jvm.internal.Ref$LongRef r2 = new kotlin.jvm.internal.Ref$LongRef
            r2.<init>()
            r2.element = r0
            r0 = r17
        L_0x005b:
            r3.L$0 = r0
            r3.L$1 = r2
            r3.label = r6
            java.lang.Object r1 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r0, r7, r3, r6, r7)
            if (r1 != r4) goto L_0x0068
            return r4
        L_0x0068:
            r16 = r2
            r2 = r1
            r1 = r16
        L_0x006d:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r5 = r2.getChanges()
            int r8 = r5.size()
            r9 = 0
            r10 = r9
        L_0x0079:
            if (r10 >= r8) goto L_0x0092
            java.lang.Object r11 = r5.get(r10)
            r12 = r11
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            long r12 = r12.m5585getIdJ3iCeTQ()
            long r14 = r1.element
            boolean r12 = androidx.compose.ui.input.pointer.PointerId.m5569equalsimpl0(r12, r14)
            if (r12 == 0) goto L_0x008f
            goto L_0x0093
        L_0x008f:
            int r10 = r10 + 1
            goto L_0x0079
        L_0x0092:
            r11 = r7
        L_0x0093:
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            if (r11 != 0) goto L_0x0099
            r11 = r7
            goto L_0x00cd
        L_0x0099:
            boolean r5 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r11)
            if (r5 == 0) goto L_0x00c7
            java.util.List r2 = r2.getChanges()
            int r5 = r2.size()
        L_0x00a7:
            if (r9 >= r5) goto L_0x00ba
            java.lang.Object r8 = r2.get(r9)
            r10 = r8
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            boolean r10 = r10.getPressed()
            if (r10 == 0) goto L_0x00b7
            goto L_0x00bb
        L_0x00b7:
            int r9 = r9 + 1
            goto L_0x00a7
        L_0x00ba:
            r8 = r7
        L_0x00bb:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 != 0) goto L_0x00c0
            goto L_0x00cd
        L_0x00c0:
            long r8 = r8.m5585getIdJ3iCeTQ()
            r1.element = r8
            goto L_0x00d7
        L_0x00c7:
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangedIgnoreConsumed(r11)
            if (r2 == 0) goto L_0x00d7
        L_0x00cd:
            if (r11 == 0) goto L_0x00d6
            boolean r0 = r11.isConsumed()
            if (r0 != 0) goto L_0x00d6
            return r11
        L_0x00d6:
            return r7
        L_0x00d7:
            r2 = r1
            goto L_0x005b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m440awaitDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object detectDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = DragGestureDetectorKt$detectDragGestures$2.INSTANCE;
        }
        if ((i & 2) != 0) {
            function0 = DragGestureDetectorKt$detectDragGestures$3.INSTANCE;
        }
        if ((i & 4) != 0) {
            function02 = DragGestureDetectorKt$detectDragGestures$4.INSTANCE;
        }
        Function2 function22 = function2;
        Continuation continuation2 = continuation;
        return detectDragGestures(pointerInputScope, function1, function0, function02, function22, continuation2);
    }

    public static final Object detectDragGestures(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object detectDragGestures = detectDragGestures(pointerInputScope, new DragGestureDetectorKt$detectDragGestures$5(function1), new DragGestureDetectorKt$detectDragGestures$6(function0), function02, DragGestureDetectorKt$detectDragGestures$7.INSTANCE, (Orientation) null, function2, continuation);
        return detectDragGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectDragGestures : Unit.INSTANCE;
    }

    public static final Object detectDragGestures(PointerInputScope pointerInputScope, Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function3, Function1<? super PointerInputChange, Unit> function1, Function0<Unit> function0, Function0<Boolean> function02, Orientation orientation, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new DragGestureDetectorKt$detectDragGestures$9(function02, new Ref.LongRef(), orientation, function3, function2, function0, function1, (Continuation<? super DragGestureDetectorKt$detectDragGestures$9>) null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    public static /* synthetic */ Object detectDragGesturesAfterLongPress$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = DragGestureDetectorKt$detectDragGesturesAfterLongPress$2.INSTANCE;
        }
        if ((i & 2) != 0) {
            function0 = DragGestureDetectorKt$detectDragGesturesAfterLongPress$3.INSTANCE;
        }
        if ((i & 4) != 0) {
            function02 = DragGestureDetectorKt$detectDragGesturesAfterLongPress$4.INSTANCE;
        }
        Function2 function22 = function2;
        Continuation continuation2 = continuation;
        return detectDragGesturesAfterLongPress(pointerInputScope, function1, function0, function02, function22, continuation2);
    }

    public static final Object detectDragGesturesAfterLongPress(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(function1, function0, function02, function2, (Continuation<? super DragGestureDetectorKt$detectDragGesturesAfterLongPress$5>) null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0101 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* renamed from: awaitVerticalTouchSlopOrCancellation-jO51t88  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m450awaitVerticalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r19, long r20, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r22, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r23) {
        /*
            r0 = r20
            r2 = r23
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 2
            r7 = 1
            r8 = 0
            if (r5 == 0) goto L_0x0076
            if (r5 == r7) goto L_0x0057
            if (r5 != r6) goto L_0x004f
            float r0 = r3.F$0
            java.lang.Object r1 = r3.L$4
            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
            java.lang.Object r5 = r3.L$3
            androidx.compose.foundation.gestures.TouchSlopDetector r5 = (androidx.compose.foundation.gestures.TouchSlopDetector) r5
            java.lang.Object r9 = r3.L$2
            kotlin.jvm.internal.Ref$LongRef r9 = (kotlin.jvm.internal.Ref.LongRef) r9
            java.lang.Object r10 = r3.L$1
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            java.lang.Object r11 = r3.L$0
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r5
            r17 = r8
            r5 = r3
            r3 = r0
            r0 = r10
            goto L_0x0173
        L_0x004f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0057:
            float r0 = r3.F$0
            java.lang.Object r1 = r3.L$3
            androidx.compose.foundation.gestures.TouchSlopDetector r1 = (androidx.compose.foundation.gestures.TouchSlopDetector) r1
            java.lang.Object r5 = r3.L$2
            kotlin.jvm.internal.Ref$LongRef r5 = (kotlin.jvm.internal.Ref.LongRef) r5
            java.lang.Object r9 = r3.L$1
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r9 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r9
            java.lang.Object r10 = r3.L$0
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            kotlin.ResultKt.throwOnFailure(r2)
            r18 = r5
            r5 = r0
            r0 = r9
            r9 = r3
            r3 = r1
            r1 = r10
            r10 = r18
            goto L_0x00c5
        L_0x0076:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.ui.input.pointer.PointerType$Companion r2 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r2 = r2.m5669getTouchT8wyACA()
            androidx.compose.foundation.gestures.Orientation r5 = androidx.compose.foundation.gestures.Orientation.Vertical
            androidx.compose.ui.input.pointer.PointerEvent r9 = r19.getCurrentEvent()
            boolean r9 = m455isPointerUpDmW0f2w(r9, r0)
            if (r9 == 0) goto L_0x008c
            return r8
        L_0x008c:
            androidx.compose.ui.platform.ViewConfiguration r9 = r19.getViewConfiguration()
            float r2 = m456pointerSlopE8SPZFQ(r9, r2)
            kotlin.jvm.internal.Ref$LongRef r9 = new kotlin.jvm.internal.Ref$LongRef
            r9.<init>()
            r9.element = r0
            androidx.compose.foundation.gestures.TouchSlopDetector r0 = new androidx.compose.foundation.gestures.TouchSlopDetector
            r0.<init>(r5)
            r1 = r22
            r5 = r3
            r3 = r2
            r2 = r0
            r0 = r19
        L_0x00a7:
            r5.L$0 = r1
            r5.L$1 = r0
            r5.L$2 = r9
            r5.L$3 = r2
            r5.L$4 = r8
            r5.F$0 = r3
            r5.label = r7
            java.lang.Object r10 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r0, r8, r5, r7, r8)
            if (r10 != r4) goto L_0x00bd
            goto L_0x016c
        L_0x00bd:
            r18 = r3
            r3 = r2
            r2 = r10
            r10 = r9
            r9 = r5
            r5 = r18
        L_0x00c5:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r11 = r2.getChanges()
            int r12 = r11.size()
            r14 = 0
        L_0x00d0:
            if (r14 >= r12) goto L_0x00f1
            java.lang.Object r15 = r11.get(r14)
            r16 = r15
            androidx.compose.ui.input.pointer.PointerInputChange r16 = (androidx.compose.ui.input.pointer.PointerInputChange) r16
            r17 = r8
            long r7 = r16.m5585getIdJ3iCeTQ()
            r16 = r14
            long r13 = r10.element
            boolean r7 = androidx.compose.ui.input.pointer.PointerId.m5569equalsimpl0(r7, r13)
            if (r7 == 0) goto L_0x00eb
            goto L_0x00f5
        L_0x00eb:
            int r14 = r16 + 1
            r8 = r17
            r7 = 1
            goto L_0x00d0
        L_0x00f1:
            r17 = r8
            r15 = r17
        L_0x00f5:
            r7 = r15
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            if (r7 != 0) goto L_0x00fb
            return r17
        L_0x00fb:
            boolean r8 = r7.isConsumed()
            if (r8 == 0) goto L_0x0102
            return r17
        L_0x0102:
            boolean r8 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r7)
            if (r8 == 0) goto L_0x0132
            java.util.List r2 = r2.getChanges()
            int r7 = r2.size()
            r13 = 0
        L_0x0111:
            if (r13 >= r7) goto L_0x0124
            java.lang.Object r8 = r2.get(r13)
            r11 = r8
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            boolean r11 = r11.getPressed()
            if (r11 == 0) goto L_0x0121
            goto L_0x0126
        L_0x0121:
            int r13 = r13 + 1
            goto L_0x0111
        L_0x0124:
            r8 = r17
        L_0x0126:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 != 0) goto L_0x012b
            return r17
        L_0x012b:
            long r7 = r8.m5585getIdJ3iCeTQ()
            r10.element = r7
            goto L_0x0151
        L_0x0132:
            androidx.compose.ui.geometry.Offset r2 = r3.m563addPointerInputChangeGcwITfU(r7, r5)
            if (r2 == 0) goto L_0x0156
            long r11 = r2.m3997unboximpl()
            float r2 = androidx.compose.ui.geometry.Offset.m3988getYimpl(r11)
            java.lang.Float r2 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r2)
            r1.invoke(r7, r2)
            boolean r2 = r7.isConsumed()
            if (r2 == 0) goto L_0x014e
            return r7
        L_0x014e:
            r3.reset()
        L_0x0151:
            r2 = r3
            r3 = r5
            r5 = r9
            r9 = r10
            goto L_0x017b
        L_0x0156:
            androidx.compose.ui.input.pointer.PointerEventPass r2 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r9.L$0 = r1
            r9.L$1 = r0
            r9.L$2 = r10
            r9.L$3 = r3
            r9.L$4 = r7
            r9.F$0 = r5
            r9.label = r6
            java.lang.Object r2 = r0.awaitPointerEvent(r2, r9)
            if (r2 != r4) goto L_0x016d
        L_0x016c:
            return r4
        L_0x016d:
            r11 = r1
            r2 = r3
            r3 = r5
            r1 = r7
            r5 = r9
            r9 = r10
        L_0x0173:
            boolean r1 = r1.isConsumed()
            if (r1 == 0) goto L_0x017a
            return r17
        L_0x017a:
            r1 = r11
        L_0x017b:
            r8 = r17
            r7 = 1
            goto L_0x00a7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m450awaitVerticalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00fc A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00ec A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* renamed from: awaitVerticalPointerSlopOrCancellation-gDDlDlE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m449awaitVerticalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope r19, long r20, int r22, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r23, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r24) {
        /*
            r0 = r20
            r2 = r24
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 2
            r7 = 1
            r8 = 0
            if (r5 == 0) goto L_0x0078
            if (r5 == r7) goto L_0x0056
            if (r5 != r6) goto L_0x004e
            float r0 = r3.F$0
            java.lang.Object r1 = r3.L$4
            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
            java.lang.Object r5 = r3.L$3
            androidx.compose.foundation.gestures.TouchSlopDetector r5 = (androidx.compose.foundation.gestures.TouchSlopDetector) r5
            java.lang.Object r9 = r3.L$2
            kotlin.jvm.internal.Ref$LongRef r9 = (kotlin.jvm.internal.Ref.LongRef) r9
            java.lang.Object r10 = r3.L$1
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            java.lang.Object r11 = r3.L$0
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r5
            r17 = r8
            r5 = r0
            r0 = r10
            goto L_0x016e
        L_0x004e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0056:
            float r0 = r3.F$0
            java.lang.Object r1 = r3.L$3
            androidx.compose.foundation.gestures.TouchSlopDetector r1 = (androidx.compose.foundation.gestures.TouchSlopDetector) r1
            java.lang.Object r5 = r3.L$2
            kotlin.jvm.internal.Ref$LongRef r5 = (kotlin.jvm.internal.Ref.LongRef) r5
            java.lang.Object r9 = r3.L$1
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r9 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r9
            java.lang.Object r10 = r3.L$0
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            kotlin.ResultKt.throwOnFailure(r2)
            r18 = r9
            r9 = r0
            r0 = r18
            r18 = r3
            r3 = r1
            r1 = r10
            r10 = r5
        L_0x0075:
            r5 = r18
            goto L_0x00c0
        L_0x0078:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.foundation.gestures.Orientation r2 = androidx.compose.foundation.gestures.Orientation.Vertical
            androidx.compose.ui.input.pointer.PointerEvent r5 = r19.getCurrentEvent()
            boolean r5 = m455isPointerUpDmW0f2w(r5, r0)
            if (r5 == 0) goto L_0x0088
            return r8
        L_0x0088:
            androidx.compose.ui.platform.ViewConfiguration r5 = r19.getViewConfiguration()
            r9 = r22
            float r5 = m456pointerSlopE8SPZFQ(r5, r9)
            kotlin.jvm.internal.Ref$LongRef r9 = new kotlin.jvm.internal.Ref$LongRef
            r9.<init>()
            r9.element = r0
            androidx.compose.foundation.gestures.TouchSlopDetector r0 = new androidx.compose.foundation.gestures.TouchSlopDetector
            r0.<init>(r2)
            r1 = r23
            r2 = r0
            r0 = r19
        L_0x00a3:
            r3.L$0 = r1
            r3.L$1 = r0
            r3.L$2 = r9
            r3.L$3 = r2
            r3.L$4 = r8
            r3.F$0 = r5
            r3.label = r7
            java.lang.Object r10 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r0, r8, r3, r7, r8)
            if (r10 != r4) goto L_0x00b9
            goto L_0x0167
        L_0x00b9:
            r18 = r3
            r3 = r2
            r2 = r10
            r10 = r9
            r9 = r5
            goto L_0x0075
        L_0x00c0:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r11 = r2.getChanges()
            int r12 = r11.size()
            r14 = 0
        L_0x00cb:
            if (r14 >= r12) goto L_0x00ec
            java.lang.Object r15 = r11.get(r14)
            r16 = r15
            androidx.compose.ui.input.pointer.PointerInputChange r16 = (androidx.compose.ui.input.pointer.PointerInputChange) r16
            r17 = r8
            long r7 = r16.m5585getIdJ3iCeTQ()
            r16 = r14
            long r13 = r10.element
            boolean r7 = androidx.compose.ui.input.pointer.PointerId.m5569equalsimpl0(r7, r13)
            if (r7 == 0) goto L_0x00e6
            goto L_0x00f0
        L_0x00e6:
            int r14 = r16 + 1
            r8 = r17
            r7 = 1
            goto L_0x00cb
        L_0x00ec:
            r17 = r8
            r15 = r17
        L_0x00f0:
            r7 = r15
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            if (r7 != 0) goto L_0x00f6
            return r17
        L_0x00f6:
            boolean r8 = r7.isConsumed()
            if (r8 == 0) goto L_0x00fd
            return r17
        L_0x00fd:
            boolean r8 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r7)
            if (r8 == 0) goto L_0x012d
            java.util.List r2 = r2.getChanges()
            int r7 = r2.size()
            r13 = 0
        L_0x010c:
            if (r13 >= r7) goto L_0x011f
            java.lang.Object r8 = r2.get(r13)
            r11 = r8
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            boolean r11 = r11.getPressed()
            if (r11 == 0) goto L_0x011c
            goto L_0x0121
        L_0x011c:
            int r13 = r13 + 1
            goto L_0x010c
        L_0x011f:
            r8 = r17
        L_0x0121:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 != 0) goto L_0x0126
            return r17
        L_0x0126:
            long r7 = r8.m5585getIdJ3iCeTQ()
            r10.element = r7
            goto L_0x014c
        L_0x012d:
            androidx.compose.ui.geometry.Offset r2 = r3.m563addPointerInputChangeGcwITfU(r7, r9)
            if (r2 == 0) goto L_0x0151
            long r11 = r2.m3997unboximpl()
            float r2 = androidx.compose.ui.geometry.Offset.m3988getYimpl(r11)
            java.lang.Float r2 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r2)
            r1.invoke(r7, r2)
            boolean r2 = r7.isConsumed()
            if (r2 == 0) goto L_0x0149
            return r7
        L_0x0149:
            r3.reset()
        L_0x014c:
            r2 = r3
            r3 = r5
            r5 = r9
            r9 = r10
            goto L_0x0176
        L_0x0151:
            androidx.compose.ui.input.pointer.PointerEventPass r2 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r5.L$0 = r1
            r5.L$1 = r0
            r5.L$2 = r10
            r5.L$3 = r3
            r5.L$4 = r7
            r5.F$0 = r9
            r5.label = r6
            java.lang.Object r2 = r0.awaitPointerEvent(r2, r5)
            if (r2 != r4) goto L_0x0168
        L_0x0167:
            return r4
        L_0x0168:
            r11 = r1
            r2 = r3
            r3 = r5
            r1 = r7
            r5 = r9
            r9 = r10
        L_0x016e:
            boolean r1 = r1.isConsumed()
            if (r1 == 0) goto L_0x0175
            return r17
        L_0x0175:
            r1 = r11
        L_0x0176:
            r8 = r17
            r7 = 1
            goto L_0x00a3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m449awaitVerticalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v13, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v14, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x010c, code lost:
        if ((r0 == 0.0f) == false) goto L_0x010e;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0083 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00b4 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* renamed from: verticalDrag-jO51t88  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m457verticalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r20, kotlin.coroutines.Continuation<? super java.lang.Boolean> r21) {
        /*
            r0 = r21
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$verticalDrag$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.DragGestureDetectorKt$verticalDrag$1 r1 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$verticalDrag$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$verticalDrag$1 r1 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$verticalDrag$1
            r1.<init>(r0)
        L_0x001b:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r5 = 1
            r6 = 0
            if (r3 == 0) goto L_0x004e
            if (r3 != r5) goto L_0x0046
            java.lang.Object r3 = r1.L$4
            kotlin.jvm.internal.Ref$LongRef r3 = (kotlin.jvm.internal.Ref.LongRef) r3
            java.lang.Object r7 = r1.L$3
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            java.lang.Object r8 = r1.L$2
            androidx.compose.foundation.gestures.Orientation r8 = (androidx.compose.foundation.gestures.Orientation) r8
            java.lang.Object r9 = r1.L$1
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r9 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r9
            java.lang.Object r10 = r1.L$0
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            kotlin.ResultKt.throwOnFailure(r0)
            r16 = r10
            r10 = r1
            r1 = r16
            goto L_0x008a
        L_0x0046:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004e:
            kotlin.ResultKt.throwOnFailure(r0)
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Vertical
            androidx.compose.ui.input.pointer.PointerEvent r3 = r17.getCurrentEvent()
            r7 = r18
            boolean r3 = m455isPointerUpDmW0f2w(r3, r7)
            if (r3 == 0) goto L_0x0061
            goto L_0x0120
        L_0x0061:
            r3 = r0
            r9 = r1
            r0 = r17
            r1 = r20
        L_0x0067:
            kotlin.jvm.internal.Ref$LongRef r10 = new kotlin.jvm.internal.Ref$LongRef
            r10.<init>()
            r10.element = r7
            r7 = r0
            r8 = r3
            r3 = r10
        L_0x0071:
            r9.L$0 = r1
            r9.L$1 = r0
            r9.L$2 = r8
            r9.L$3 = r7
            r9.L$4 = r3
            r9.label = r5
            java.lang.Object r10 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r7, r6, r9, r5, r6)
            if (r10 != r2) goto L_0x0084
            return r2
        L_0x0084:
            r16 = r9
            r9 = r0
            r0 = r10
            r10 = r16
        L_0x008a:
            androidx.compose.ui.input.pointer.PointerEvent r0 = (androidx.compose.ui.input.pointer.PointerEvent) r0
            java.util.List r11 = r0.getChanges()
            int r12 = r11.size()
            r13 = 0
        L_0x0095:
            if (r13 >= r12) goto L_0x00b4
            java.lang.Object r14 = r11.get(r13)
            r15 = r14
            androidx.compose.ui.input.pointer.PointerInputChange r15 = (androidx.compose.ui.input.pointer.PointerInputChange) r15
            long r4 = r15.m5585getIdJ3iCeTQ()
            r17 = r7
            long r6 = r3.element
            boolean r4 = androidx.compose.ui.input.pointer.PointerId.m5569equalsimpl0(r4, r6)
            if (r4 == 0) goto L_0x00ad
            goto L_0x00b7
        L_0x00ad:
            int r13 = r13 + 1
            r5 = 1
            r6 = 0
            r7 = r17
            goto L_0x0095
        L_0x00b4:
            r17 = r7
            r14 = 0
        L_0x00b7:
            androidx.compose.ui.input.pointer.PointerInputChange r14 = (androidx.compose.ui.input.pointer.PointerInputChange) r14
            if (r14 != 0) goto L_0x00bd
            r14 = 0
            goto L_0x010e
        L_0x00bd:
            boolean r4 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r14)
            if (r4 == 0) goto L_0x00ec
            java.util.List r0 = r0.getChanges()
            int r4 = r0.size()
            r5 = 0
        L_0x00cc:
            if (r5 >= r4) goto L_0x00df
            java.lang.Object r6 = r0.get(r5)
            r7 = r6
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            boolean r7 = r7.getPressed()
            if (r7 == 0) goto L_0x00dc
            goto L_0x00e0
        L_0x00dc:
            int r5 = r5 + 1
            goto L_0x00cc
        L_0x00df:
            r6 = 0
        L_0x00e0:
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            if (r6 != 0) goto L_0x00e5
            goto L_0x010e
        L_0x00e5:
            long r4 = r6.m5585getIdJ3iCeTQ()
            r3.element = r4
            goto L_0x013a
        L_0x00ec:
            long r4 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r14)
            if (r8 != 0) goto L_0x00f7
            float r0 = androidx.compose.ui.geometry.Offset.m3985getDistanceimpl(r4)
            goto L_0x0104
        L_0x00f7:
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r8 != r0) goto L_0x0100
            float r0 = androidx.compose.ui.geometry.Offset.m3988getYimpl(r4)
            goto L_0x0104
        L_0x0100:
            float r0 = androidx.compose.ui.geometry.Offset.m3987getXimpl(r4)
        L_0x0104:
            r4 = 0
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x010b
            r0 = 1
            goto L_0x010c
        L_0x010b:
            r0 = 0
        L_0x010c:
            if (r0 != 0) goto L_0x013a
        L_0x010e:
            if (r14 != 0) goto L_0x0112
        L_0x0110:
            r6 = 0
            goto L_0x0120
        L_0x0112:
            boolean r0 = r14.isConsumed()
            if (r0 == 0) goto L_0x0119
            goto L_0x0110
        L_0x0119:
            boolean r0 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r14)
            if (r0 == 0) goto L_0x012a
            r6 = r14
        L_0x0120:
            if (r6 == 0) goto L_0x0124
            r4 = 1
            goto L_0x0125
        L_0x0124:
            r4 = 0
        L_0x0125:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r0
        L_0x012a:
            r1.invoke(r14)
            long r3 = r14.m5585getIdJ3iCeTQ()
            r5 = r3
            r3 = r8
            r7 = r5
            r0 = r9
            r9 = r10
            r5 = 1
            r6 = 0
            goto L_0x0067
        L_0x013a:
            r7 = r17
            r0 = r9
            r9 = r10
            r5 = 1
            r6 = 0
            goto L_0x0071
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m457verticalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d5, code lost:
        if (r9 == 0) goto L_0x00d7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00df A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00e0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0092 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* renamed from: awaitVerticalDragOrCancellation-rnUCldI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m448awaitVerticalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r20) {
        /*
            r0 = r18
            r2 = r20
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalDragOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalDragOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalDragOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalDragOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalDragOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 1
            r7 = 0
            if (r5 == 0) goto L_0x0044
            if (r5 != r6) goto L_0x003c
            java.lang.Object r0 = r3.L$1
            kotlin.jvm.internal.Ref$LongRef r0 = (kotlin.jvm.internal.Ref.LongRef) r0
            java.lang.Object r1 = r3.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r2)
            r16 = r1
            r1 = r0
            r0 = r16
            goto L_0x006d
        L_0x003c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.ui.input.pointer.PointerEvent r2 = r17.getCurrentEvent()
            boolean r2 = m455isPointerUpDmW0f2w(r2, r0)
            if (r2 == 0) goto L_0x0052
            return r7
        L_0x0052:
            kotlin.jvm.internal.Ref$LongRef r2 = new kotlin.jvm.internal.Ref$LongRef
            r2.<init>()
            r2.element = r0
            r0 = r17
        L_0x005b:
            r3.L$0 = r0
            r3.L$1 = r2
            r3.label = r6
            java.lang.Object r1 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r0, r7, r3, r6, r7)
            if (r1 != r4) goto L_0x0068
            return r4
        L_0x0068:
            r16 = r2
            r2 = r1
            r1 = r16
        L_0x006d:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r5 = r2.getChanges()
            int r8 = r5.size()
            r9 = 0
            r10 = r9
        L_0x0079:
            if (r10 >= r8) goto L_0x0092
            java.lang.Object r11 = r5.get(r10)
            r12 = r11
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            long r12 = r12.m5585getIdJ3iCeTQ()
            long r14 = r1.element
            boolean r12 = androidx.compose.ui.input.pointer.PointerId.m5569equalsimpl0(r12, r14)
            if (r12 == 0) goto L_0x008f
            goto L_0x0093
        L_0x008f:
            int r10 = r10 + 1
            goto L_0x0079
        L_0x0092:
            r11 = r7
        L_0x0093:
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            if (r11 != 0) goto L_0x0099
            r11 = r7
            goto L_0x00d7
        L_0x0099:
            boolean r5 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r11)
            if (r5 == 0) goto L_0x00c7
            java.util.List r2 = r2.getChanges()
            int r5 = r2.size()
        L_0x00a7:
            if (r9 >= r5) goto L_0x00ba
            java.lang.Object r8 = r2.get(r9)
            r10 = r8
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            boolean r10 = r10.getPressed()
            if (r10 == 0) goto L_0x00b7
            goto L_0x00bb
        L_0x00b7:
            int r9 = r9 + 1
            goto L_0x00a7
        L_0x00ba:
            r8 = r7
        L_0x00bb:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 != 0) goto L_0x00c0
            goto L_0x00d7
        L_0x00c0:
            long r8 = r8.m5585getIdJ3iCeTQ()
            r1.element = r8
            goto L_0x00e1
        L_0x00c7:
            long r12 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r11)
            float r2 = androidx.compose.ui.geometry.Offset.m3988getYimpl(r12)
            r5 = 0
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x00d5
            r9 = r6
        L_0x00d5:
            if (r9 != 0) goto L_0x00e1
        L_0x00d7:
            if (r11 == 0) goto L_0x00e0
            boolean r0 = r11.isConsumed()
            if (r0 != 0) goto L_0x00e0
            return r11
        L_0x00e0:
            return r7
        L_0x00e1:
            r2 = r1
            goto L_0x005b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m448awaitVerticalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object detectVerticalDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = DragGestureDetectorKt$detectVerticalDragGestures$2.INSTANCE;
        }
        if ((i & 2) != 0) {
            function0 = DragGestureDetectorKt$detectVerticalDragGestures$3.INSTANCE;
        }
        if ((i & 4) != 0) {
            function02 = DragGestureDetectorKt$detectVerticalDragGestures$4.INSTANCE;
        }
        Function2 function22 = function2;
        Continuation continuation2 = continuation;
        return detectVerticalDragGestures(pointerInputScope, function1, function0, function02, function22, continuation2);
    }

    public static final Object detectVerticalDragGestures(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new DragGestureDetectorKt$detectVerticalDragGestures$5(function1, function2, function0, function02, (Continuation<? super DragGestureDetectorKt$detectVerticalDragGestures$5>) null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0101 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* renamed from: awaitHorizontalTouchSlopOrCancellation-jO51t88  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m444awaitHorizontalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r19, long r20, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r22, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r23) {
        /*
            r0 = r20
            r2 = r23
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 2
            r7 = 1
            r8 = 0
            if (r5 == 0) goto L_0x0076
            if (r5 == r7) goto L_0x0057
            if (r5 != r6) goto L_0x004f
            float r0 = r3.F$0
            java.lang.Object r1 = r3.L$4
            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
            java.lang.Object r5 = r3.L$3
            androidx.compose.foundation.gestures.TouchSlopDetector r5 = (androidx.compose.foundation.gestures.TouchSlopDetector) r5
            java.lang.Object r9 = r3.L$2
            kotlin.jvm.internal.Ref$LongRef r9 = (kotlin.jvm.internal.Ref.LongRef) r9
            java.lang.Object r10 = r3.L$1
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            java.lang.Object r11 = r3.L$0
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r5
            r17 = r8
            r5 = r3
            r3 = r0
            r0 = r10
            goto L_0x0173
        L_0x004f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0057:
            float r0 = r3.F$0
            java.lang.Object r1 = r3.L$3
            androidx.compose.foundation.gestures.TouchSlopDetector r1 = (androidx.compose.foundation.gestures.TouchSlopDetector) r1
            java.lang.Object r5 = r3.L$2
            kotlin.jvm.internal.Ref$LongRef r5 = (kotlin.jvm.internal.Ref.LongRef) r5
            java.lang.Object r9 = r3.L$1
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r9 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r9
            java.lang.Object r10 = r3.L$0
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            kotlin.ResultKt.throwOnFailure(r2)
            r18 = r5
            r5 = r0
            r0 = r9
            r9 = r3
            r3 = r1
            r1 = r10
            r10 = r18
            goto L_0x00c5
        L_0x0076:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.ui.input.pointer.PointerType$Companion r2 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r2 = r2.m5669getTouchT8wyACA()
            androidx.compose.foundation.gestures.Orientation r5 = androidx.compose.foundation.gestures.Orientation.Horizontal
            androidx.compose.ui.input.pointer.PointerEvent r9 = r19.getCurrentEvent()
            boolean r9 = m455isPointerUpDmW0f2w(r9, r0)
            if (r9 == 0) goto L_0x008c
            return r8
        L_0x008c:
            androidx.compose.ui.platform.ViewConfiguration r9 = r19.getViewConfiguration()
            float r2 = m456pointerSlopE8SPZFQ(r9, r2)
            kotlin.jvm.internal.Ref$LongRef r9 = new kotlin.jvm.internal.Ref$LongRef
            r9.<init>()
            r9.element = r0
            androidx.compose.foundation.gestures.TouchSlopDetector r0 = new androidx.compose.foundation.gestures.TouchSlopDetector
            r0.<init>(r5)
            r1 = r22
            r5 = r3
            r3 = r2
            r2 = r0
            r0 = r19
        L_0x00a7:
            r5.L$0 = r1
            r5.L$1 = r0
            r5.L$2 = r9
            r5.L$3 = r2
            r5.L$4 = r8
            r5.F$0 = r3
            r5.label = r7
            java.lang.Object r10 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r0, r8, r5, r7, r8)
            if (r10 != r4) goto L_0x00bd
            goto L_0x016c
        L_0x00bd:
            r18 = r3
            r3 = r2
            r2 = r10
            r10 = r9
            r9 = r5
            r5 = r18
        L_0x00c5:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r11 = r2.getChanges()
            int r12 = r11.size()
            r14 = 0
        L_0x00d0:
            if (r14 >= r12) goto L_0x00f1
            java.lang.Object r15 = r11.get(r14)
            r16 = r15
            androidx.compose.ui.input.pointer.PointerInputChange r16 = (androidx.compose.ui.input.pointer.PointerInputChange) r16
            r17 = r8
            long r7 = r16.m5585getIdJ3iCeTQ()
            r16 = r14
            long r13 = r10.element
            boolean r7 = androidx.compose.ui.input.pointer.PointerId.m5569equalsimpl0(r7, r13)
            if (r7 == 0) goto L_0x00eb
            goto L_0x00f5
        L_0x00eb:
            int r14 = r16 + 1
            r8 = r17
            r7 = 1
            goto L_0x00d0
        L_0x00f1:
            r17 = r8
            r15 = r17
        L_0x00f5:
            r7 = r15
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            if (r7 != 0) goto L_0x00fb
            return r17
        L_0x00fb:
            boolean r8 = r7.isConsumed()
            if (r8 == 0) goto L_0x0102
            return r17
        L_0x0102:
            boolean r8 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r7)
            if (r8 == 0) goto L_0x0132
            java.util.List r2 = r2.getChanges()
            int r7 = r2.size()
            r13 = 0
        L_0x0111:
            if (r13 >= r7) goto L_0x0124
            java.lang.Object r8 = r2.get(r13)
            r11 = r8
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            boolean r11 = r11.getPressed()
            if (r11 == 0) goto L_0x0121
            goto L_0x0126
        L_0x0121:
            int r13 = r13 + 1
            goto L_0x0111
        L_0x0124:
            r8 = r17
        L_0x0126:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 != 0) goto L_0x012b
            return r17
        L_0x012b:
            long r7 = r8.m5585getIdJ3iCeTQ()
            r10.element = r7
            goto L_0x0151
        L_0x0132:
            androidx.compose.ui.geometry.Offset r2 = r3.m563addPointerInputChangeGcwITfU(r7, r5)
            if (r2 == 0) goto L_0x0156
            long r11 = r2.m3997unboximpl()
            float r2 = androidx.compose.ui.geometry.Offset.m3987getXimpl(r11)
            java.lang.Float r2 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r2)
            r1.invoke(r7, r2)
            boolean r2 = r7.isConsumed()
            if (r2 == 0) goto L_0x014e
            return r7
        L_0x014e:
            r3.reset()
        L_0x0151:
            r2 = r3
            r3 = r5
            r5 = r9
            r9 = r10
            goto L_0x017b
        L_0x0156:
            androidx.compose.ui.input.pointer.PointerEventPass r2 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r9.L$0 = r1
            r9.L$1 = r0
            r9.L$2 = r10
            r9.L$3 = r3
            r9.L$4 = r7
            r9.F$0 = r5
            r9.label = r6
            java.lang.Object r2 = r0.awaitPointerEvent(r2, r9)
            if (r2 != r4) goto L_0x016d
        L_0x016c:
            return r4
        L_0x016d:
            r11 = r1
            r2 = r3
            r3 = r5
            r1 = r7
            r5 = r9
            r9 = r10
        L_0x0173:
            boolean r1 = r1.isConsumed()
            if (r1 == 0) goto L_0x017a
            return r17
        L_0x017a:
            r1 = r11
        L_0x017b:
            r8 = r17
            r7 = 1
            goto L_0x00a7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m444awaitHorizontalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00fc A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00ec A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* renamed from: awaitHorizontalPointerSlopOrCancellation-gDDlDlE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m443awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope r19, long r20, int r22, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r23, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r24) {
        /*
            r0 = r20
            r2 = r24
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 2
            r7 = 1
            r8 = 0
            if (r5 == 0) goto L_0x0078
            if (r5 == r7) goto L_0x0056
            if (r5 != r6) goto L_0x004e
            float r0 = r3.F$0
            java.lang.Object r1 = r3.L$4
            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
            java.lang.Object r5 = r3.L$3
            androidx.compose.foundation.gestures.TouchSlopDetector r5 = (androidx.compose.foundation.gestures.TouchSlopDetector) r5
            java.lang.Object r9 = r3.L$2
            kotlin.jvm.internal.Ref$LongRef r9 = (kotlin.jvm.internal.Ref.LongRef) r9
            java.lang.Object r10 = r3.L$1
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            java.lang.Object r11 = r3.L$0
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r5
            r17 = r8
            r5 = r0
            r0 = r10
            goto L_0x016e
        L_0x004e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0056:
            float r0 = r3.F$0
            java.lang.Object r1 = r3.L$3
            androidx.compose.foundation.gestures.TouchSlopDetector r1 = (androidx.compose.foundation.gestures.TouchSlopDetector) r1
            java.lang.Object r5 = r3.L$2
            kotlin.jvm.internal.Ref$LongRef r5 = (kotlin.jvm.internal.Ref.LongRef) r5
            java.lang.Object r9 = r3.L$1
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r9 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r9
            java.lang.Object r10 = r3.L$0
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            kotlin.ResultKt.throwOnFailure(r2)
            r18 = r9
            r9 = r0
            r0 = r18
            r18 = r3
            r3 = r1
            r1 = r10
            r10 = r5
        L_0x0075:
            r5 = r18
            goto L_0x00c0
        L_0x0078:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.foundation.gestures.Orientation r2 = androidx.compose.foundation.gestures.Orientation.Horizontal
            androidx.compose.ui.input.pointer.PointerEvent r5 = r19.getCurrentEvent()
            boolean r5 = m455isPointerUpDmW0f2w(r5, r0)
            if (r5 == 0) goto L_0x0088
            return r8
        L_0x0088:
            androidx.compose.ui.platform.ViewConfiguration r5 = r19.getViewConfiguration()
            r9 = r22
            float r5 = m456pointerSlopE8SPZFQ(r5, r9)
            kotlin.jvm.internal.Ref$LongRef r9 = new kotlin.jvm.internal.Ref$LongRef
            r9.<init>()
            r9.element = r0
            androidx.compose.foundation.gestures.TouchSlopDetector r0 = new androidx.compose.foundation.gestures.TouchSlopDetector
            r0.<init>(r2)
            r1 = r23
            r2 = r0
            r0 = r19
        L_0x00a3:
            r3.L$0 = r1
            r3.L$1 = r0
            r3.L$2 = r9
            r3.L$3 = r2
            r3.L$4 = r8
            r3.F$0 = r5
            r3.label = r7
            java.lang.Object r10 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r0, r8, r3, r7, r8)
            if (r10 != r4) goto L_0x00b9
            goto L_0x0167
        L_0x00b9:
            r18 = r3
            r3 = r2
            r2 = r10
            r10 = r9
            r9 = r5
            goto L_0x0075
        L_0x00c0:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r11 = r2.getChanges()
            int r12 = r11.size()
            r14 = 0
        L_0x00cb:
            if (r14 >= r12) goto L_0x00ec
            java.lang.Object r15 = r11.get(r14)
            r16 = r15
            androidx.compose.ui.input.pointer.PointerInputChange r16 = (androidx.compose.ui.input.pointer.PointerInputChange) r16
            r17 = r8
            long r7 = r16.m5585getIdJ3iCeTQ()
            r16 = r14
            long r13 = r10.element
            boolean r7 = androidx.compose.ui.input.pointer.PointerId.m5569equalsimpl0(r7, r13)
            if (r7 == 0) goto L_0x00e6
            goto L_0x00f0
        L_0x00e6:
            int r14 = r16 + 1
            r8 = r17
            r7 = 1
            goto L_0x00cb
        L_0x00ec:
            r17 = r8
            r15 = r17
        L_0x00f0:
            r7 = r15
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            if (r7 != 0) goto L_0x00f6
            return r17
        L_0x00f6:
            boolean r8 = r7.isConsumed()
            if (r8 == 0) goto L_0x00fd
            return r17
        L_0x00fd:
            boolean r8 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r7)
            if (r8 == 0) goto L_0x012d
            java.util.List r2 = r2.getChanges()
            int r7 = r2.size()
            r13 = 0
        L_0x010c:
            if (r13 >= r7) goto L_0x011f
            java.lang.Object r8 = r2.get(r13)
            r11 = r8
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            boolean r11 = r11.getPressed()
            if (r11 == 0) goto L_0x011c
            goto L_0x0121
        L_0x011c:
            int r13 = r13 + 1
            goto L_0x010c
        L_0x011f:
            r8 = r17
        L_0x0121:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 != 0) goto L_0x0126
            return r17
        L_0x0126:
            long r7 = r8.m5585getIdJ3iCeTQ()
            r10.element = r7
            goto L_0x014c
        L_0x012d:
            androidx.compose.ui.geometry.Offset r2 = r3.m563addPointerInputChangeGcwITfU(r7, r9)
            if (r2 == 0) goto L_0x0151
            long r11 = r2.m3997unboximpl()
            float r2 = androidx.compose.ui.geometry.Offset.m3987getXimpl(r11)
            java.lang.Float r2 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r2)
            r1.invoke(r7, r2)
            boolean r2 = r7.isConsumed()
            if (r2 == 0) goto L_0x0149
            return r7
        L_0x0149:
            r3.reset()
        L_0x014c:
            r2 = r3
            r3 = r5
            r5 = r9
            r9 = r10
            goto L_0x0176
        L_0x0151:
            androidx.compose.ui.input.pointer.PointerEventPass r2 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r5.L$0 = r1
            r5.L$1 = r0
            r5.L$2 = r10
            r5.L$3 = r3
            r5.L$4 = r7
            r5.F$0 = r9
            r5.label = r6
            java.lang.Object r2 = r0.awaitPointerEvent(r2, r5)
            if (r2 != r4) goto L_0x0168
        L_0x0167:
            return r4
        L_0x0168:
            r11 = r1
            r2 = r3
            r3 = r5
            r1 = r7
            r5 = r9
            r9 = r10
        L_0x016e:
            boolean r1 = r1.isConsumed()
            if (r1 == 0) goto L_0x0175
            return r17
        L_0x0175:
            r1 = r11
        L_0x0176:
            r8 = r17
            r7 = 1
            goto L_0x00a3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m443awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v13, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v14, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x010c, code lost:
        if ((r0 == 0.0f) == false) goto L_0x010e;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0083 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00b4 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* renamed from: horizontalDrag-jO51t88  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m454horizontalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r20, kotlin.coroutines.Continuation<? super java.lang.Boolean> r21) {
        /*
            r0 = r21
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$horizontalDrag$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.DragGestureDetectorKt$horizontalDrag$1 r1 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$horizontalDrag$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$horizontalDrag$1 r1 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$horizontalDrag$1
            r1.<init>(r0)
        L_0x001b:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r5 = 1
            r6 = 0
            if (r3 == 0) goto L_0x004e
            if (r3 != r5) goto L_0x0046
            java.lang.Object r3 = r1.L$4
            kotlin.jvm.internal.Ref$LongRef r3 = (kotlin.jvm.internal.Ref.LongRef) r3
            java.lang.Object r7 = r1.L$3
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            java.lang.Object r8 = r1.L$2
            androidx.compose.foundation.gestures.Orientation r8 = (androidx.compose.foundation.gestures.Orientation) r8
            java.lang.Object r9 = r1.L$1
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r9 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r9
            java.lang.Object r10 = r1.L$0
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            kotlin.ResultKt.throwOnFailure(r0)
            r16 = r10
            r10 = r1
            r1 = r16
            goto L_0x008a
        L_0x0046:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004e:
            kotlin.ResultKt.throwOnFailure(r0)
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Horizontal
            androidx.compose.ui.input.pointer.PointerEvent r3 = r17.getCurrentEvent()
            r7 = r18
            boolean r3 = m455isPointerUpDmW0f2w(r3, r7)
            if (r3 == 0) goto L_0x0061
            goto L_0x0120
        L_0x0061:
            r3 = r0
            r9 = r1
            r0 = r17
            r1 = r20
        L_0x0067:
            kotlin.jvm.internal.Ref$LongRef r10 = new kotlin.jvm.internal.Ref$LongRef
            r10.<init>()
            r10.element = r7
            r7 = r0
            r8 = r3
            r3 = r10
        L_0x0071:
            r9.L$0 = r1
            r9.L$1 = r0
            r9.L$2 = r8
            r9.L$3 = r7
            r9.L$4 = r3
            r9.label = r5
            java.lang.Object r10 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r7, r6, r9, r5, r6)
            if (r10 != r2) goto L_0x0084
            return r2
        L_0x0084:
            r16 = r9
            r9 = r0
            r0 = r10
            r10 = r16
        L_0x008a:
            androidx.compose.ui.input.pointer.PointerEvent r0 = (androidx.compose.ui.input.pointer.PointerEvent) r0
            java.util.List r11 = r0.getChanges()
            int r12 = r11.size()
            r13 = 0
        L_0x0095:
            if (r13 >= r12) goto L_0x00b4
            java.lang.Object r14 = r11.get(r13)
            r15 = r14
            androidx.compose.ui.input.pointer.PointerInputChange r15 = (androidx.compose.ui.input.pointer.PointerInputChange) r15
            long r4 = r15.m5585getIdJ3iCeTQ()
            r17 = r7
            long r6 = r3.element
            boolean r4 = androidx.compose.ui.input.pointer.PointerId.m5569equalsimpl0(r4, r6)
            if (r4 == 0) goto L_0x00ad
            goto L_0x00b7
        L_0x00ad:
            int r13 = r13 + 1
            r5 = 1
            r6 = 0
            r7 = r17
            goto L_0x0095
        L_0x00b4:
            r17 = r7
            r14 = 0
        L_0x00b7:
            androidx.compose.ui.input.pointer.PointerInputChange r14 = (androidx.compose.ui.input.pointer.PointerInputChange) r14
            if (r14 != 0) goto L_0x00bd
            r14 = 0
            goto L_0x010e
        L_0x00bd:
            boolean r4 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r14)
            if (r4 == 0) goto L_0x00ec
            java.util.List r0 = r0.getChanges()
            int r4 = r0.size()
            r5 = 0
        L_0x00cc:
            if (r5 >= r4) goto L_0x00df
            java.lang.Object r6 = r0.get(r5)
            r7 = r6
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            boolean r7 = r7.getPressed()
            if (r7 == 0) goto L_0x00dc
            goto L_0x00e0
        L_0x00dc:
            int r5 = r5 + 1
            goto L_0x00cc
        L_0x00df:
            r6 = 0
        L_0x00e0:
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            if (r6 != 0) goto L_0x00e5
            goto L_0x010e
        L_0x00e5:
            long r4 = r6.m5585getIdJ3iCeTQ()
            r3.element = r4
            goto L_0x013a
        L_0x00ec:
            long r4 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r14)
            if (r8 != 0) goto L_0x00f7
            float r0 = androidx.compose.ui.geometry.Offset.m3985getDistanceimpl(r4)
            goto L_0x0104
        L_0x00f7:
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r8 != r0) goto L_0x0100
            float r0 = androidx.compose.ui.geometry.Offset.m3988getYimpl(r4)
            goto L_0x0104
        L_0x0100:
            float r0 = androidx.compose.ui.geometry.Offset.m3987getXimpl(r4)
        L_0x0104:
            r4 = 0
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x010b
            r0 = 1
            goto L_0x010c
        L_0x010b:
            r0 = 0
        L_0x010c:
            if (r0 != 0) goto L_0x013a
        L_0x010e:
            if (r14 != 0) goto L_0x0112
        L_0x0110:
            r6 = 0
            goto L_0x0120
        L_0x0112:
            boolean r0 = r14.isConsumed()
            if (r0 == 0) goto L_0x0119
            goto L_0x0110
        L_0x0119:
            boolean r0 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r14)
            if (r0 == 0) goto L_0x012a
            r6 = r14
        L_0x0120:
            if (r6 == 0) goto L_0x0124
            r4 = 1
            goto L_0x0125
        L_0x0124:
            r4 = 0
        L_0x0125:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r0
        L_0x012a:
            r1.invoke(r14)
            long r3 = r14.m5585getIdJ3iCeTQ()
            r5 = r3
            r3 = r8
            r7 = r5
            r0 = r9
            r9 = r10
            r5 = 1
            r6 = 0
            goto L_0x0067
        L_0x013a:
            r7 = r17
            r0 = r9
            r9 = r10
            r5 = 1
            r6 = 0
            goto L_0x0071
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m454horizontalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d5, code lost:
        if (r9 == 0) goto L_0x00d7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00df A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00e0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0092 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* renamed from: awaitHorizontalDragOrCancellation-rnUCldI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m442awaitHorizontalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r20) {
        /*
            r0 = r18
            r2 = r20
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 1
            r7 = 0
            if (r5 == 0) goto L_0x0044
            if (r5 != r6) goto L_0x003c
            java.lang.Object r0 = r3.L$1
            kotlin.jvm.internal.Ref$LongRef r0 = (kotlin.jvm.internal.Ref.LongRef) r0
            java.lang.Object r1 = r3.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r2)
            r16 = r1
            r1 = r0
            r0 = r16
            goto L_0x006d
        L_0x003c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.ui.input.pointer.PointerEvent r2 = r17.getCurrentEvent()
            boolean r2 = m455isPointerUpDmW0f2w(r2, r0)
            if (r2 == 0) goto L_0x0052
            return r7
        L_0x0052:
            kotlin.jvm.internal.Ref$LongRef r2 = new kotlin.jvm.internal.Ref$LongRef
            r2.<init>()
            r2.element = r0
            r0 = r17
        L_0x005b:
            r3.L$0 = r0
            r3.L$1 = r2
            r3.label = r6
            java.lang.Object r1 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r0, r7, r3, r6, r7)
            if (r1 != r4) goto L_0x0068
            return r4
        L_0x0068:
            r16 = r2
            r2 = r1
            r1 = r16
        L_0x006d:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r5 = r2.getChanges()
            int r8 = r5.size()
            r9 = 0
            r10 = r9
        L_0x0079:
            if (r10 >= r8) goto L_0x0092
            java.lang.Object r11 = r5.get(r10)
            r12 = r11
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            long r12 = r12.m5585getIdJ3iCeTQ()
            long r14 = r1.element
            boolean r12 = androidx.compose.ui.input.pointer.PointerId.m5569equalsimpl0(r12, r14)
            if (r12 == 0) goto L_0x008f
            goto L_0x0093
        L_0x008f:
            int r10 = r10 + 1
            goto L_0x0079
        L_0x0092:
            r11 = r7
        L_0x0093:
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            if (r11 != 0) goto L_0x0099
            r11 = r7
            goto L_0x00d7
        L_0x0099:
            boolean r5 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r11)
            if (r5 == 0) goto L_0x00c7
            java.util.List r2 = r2.getChanges()
            int r5 = r2.size()
        L_0x00a7:
            if (r9 >= r5) goto L_0x00ba
            java.lang.Object r8 = r2.get(r9)
            r10 = r8
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            boolean r10 = r10.getPressed()
            if (r10 == 0) goto L_0x00b7
            goto L_0x00bb
        L_0x00b7:
            int r9 = r9 + 1
            goto L_0x00a7
        L_0x00ba:
            r8 = r7
        L_0x00bb:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 != 0) goto L_0x00c0
            goto L_0x00d7
        L_0x00c0:
            long r8 = r8.m5585getIdJ3iCeTQ()
            r1.element = r8
            goto L_0x00e1
        L_0x00c7:
            long r12 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r11)
            float r2 = androidx.compose.ui.geometry.Offset.m3987getXimpl(r12)
            r5 = 0
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x00d5
            r9 = r6
        L_0x00d5:
            if (r9 != 0) goto L_0x00e1
        L_0x00d7:
            if (r11 == 0) goto L_0x00e0
            boolean r0 = r11.isConsumed()
            if (r0 != 0) goto L_0x00e0
            return r11
        L_0x00e0:
            return r7
        L_0x00e1:
            r2 = r1
            goto L_0x005b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m442awaitHorizontalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object detectHorizontalDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = DragGestureDetectorKt$detectHorizontalDragGestures$2.INSTANCE;
        }
        if ((i & 2) != 0) {
            function0 = DragGestureDetectorKt$detectHorizontalDragGestures$3.INSTANCE;
        }
        if ((i & 4) != 0) {
            function02 = DragGestureDetectorKt$detectHorizontalDragGestures$4.INSTANCE;
        }
        Function2 function22 = function2;
        Continuation continuation2 = continuation;
        return detectHorizontalDragGestures(pointerInputScope, function1, function0, function02, function22, continuation2);
    }

    public static final Object detectHorizontalDragGestures(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new DragGestureDetectorKt$detectHorizontalDragGestures$5(function1, function2, function0, function02, (Continuation<? super DragGestureDetectorKt$detectHorizontalDragGestures$5>) null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v2, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v3, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v4, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x011b, code lost:
        if ((r0 == 0.0f) == false) goto L_0x011d;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x008d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c0 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* renamed from: drag-VnAYq1g  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m451dragVnAYq1g(androidx.compose.ui.input.pointer.AwaitPointerEventScope r19, long r20, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r22, androidx.compose.foundation.gestures.Orientation r23, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Boolean> r24, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r25) {
        /*
            r0 = r25
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$2
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$2 r1 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$2) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$2 r1 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$2
            r1.<init>(r0)
        L_0x001b:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L_0x0058
            if (r3 != r4) goto L_0x0050
            java.lang.Object r3 = r1.L$5
            kotlin.jvm.internal.Ref$LongRef r3 = (kotlin.jvm.internal.Ref.LongRef) r3
            java.lang.Object r6 = r1.L$4
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r6 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r6
            java.lang.Object r7 = r1.L$3
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r8 = r1.L$2
            androidx.compose.foundation.gestures.Orientation r8 = (androidx.compose.foundation.gestures.Orientation) r8
            java.lang.Object r9 = r1.L$1
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            java.lang.Object r10 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            kotlin.ResultKt.throwOnFailure(r0)
            r18 = r9
            r9 = r1
            r1 = r18
            r18 = r7
            r7 = r3
            r3 = r8
            r8 = r18
            goto L_0x0094
        L_0x0050:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0058:
            kotlin.ResultKt.throwOnFailure(r0)
            androidx.compose.ui.input.pointer.PointerEvent r0 = r19.getCurrentEvent()
            r6 = r20
            boolean r0 = m455isPointerUpDmW0f2w(r0, r6)
            if (r0 == 0) goto L_0x0068
            return r5
        L_0x0068:
            r0 = r19
            r3 = r23
            r8 = r24
            r9 = r1
            r1 = r22
        L_0x0071:
            kotlin.jvm.internal.Ref$LongRef r10 = new kotlin.jvm.internal.Ref$LongRef
            r10.<init>()
            r10.element = r6
            r6 = r0
        L_0x0079:
            r9.L$0 = r0
            r9.L$1 = r1
            r9.L$2 = r3
            r9.L$3 = r8
            r9.L$4 = r6
            r9.L$5 = r10
            r9.label = r4
            java.lang.Object r7 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r6, r5, r9, r4, r5)
            if (r7 != r2) goto L_0x008e
            return r2
        L_0x008e:
            r18 = r10
            r10 = r0
            r0 = r7
            r7 = r18
        L_0x0094:
            androidx.compose.ui.input.pointer.PointerEvent r0 = (androidx.compose.ui.input.pointer.PointerEvent) r0
            java.util.List r11 = r0.getChanges()
            int r12 = r11.size()
            r14 = 0
        L_0x009f:
            if (r14 >= r12) goto L_0x00c0
            java.lang.Object r15 = r11.get(r14)
            r16 = r15
            androidx.compose.ui.input.pointer.PointerInputChange r16 = (androidx.compose.ui.input.pointer.PointerInputChange) r16
            r17 = r5
            long r4 = r16.m5585getIdJ3iCeTQ()
            r16 = r14
            long r13 = r7.element
            boolean r4 = androidx.compose.ui.input.pointer.PointerId.m5569equalsimpl0(r4, r13)
            if (r4 == 0) goto L_0x00ba
            goto L_0x00c4
        L_0x00ba:
            int r14 = r16 + 1
            r5 = r17
            r4 = 1
            goto L_0x009f
        L_0x00c0:
            r17 = r5
            r15 = r17
        L_0x00c4:
            androidx.compose.ui.input.pointer.PointerInputChange r15 = (androidx.compose.ui.input.pointer.PointerInputChange) r15
            if (r15 != 0) goto L_0x00cb
            r15 = r17
            goto L_0x011d
        L_0x00cb:
            boolean r4 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r15)
            if (r4 == 0) goto L_0x00fb
            java.util.List r0 = r0.getChanges()
            int r4 = r0.size()
            r13 = 0
        L_0x00da:
            if (r13 >= r4) goto L_0x00ed
            java.lang.Object r5 = r0.get(r13)
            r11 = r5
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            boolean r11 = r11.getPressed()
            if (r11 == 0) goto L_0x00ea
            goto L_0x00ef
        L_0x00ea:
            int r13 = r13 + 1
            goto L_0x00da
        L_0x00ed:
            r5 = r17
        L_0x00ef:
            androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
            if (r5 != 0) goto L_0x00f4
            goto L_0x011d
        L_0x00f4:
            long r4 = r5.m5585getIdJ3iCeTQ()
            r7.element = r4
            goto L_0x0141
        L_0x00fb:
            long r4 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r15)
            if (r3 != 0) goto L_0x0106
            float r0 = androidx.compose.ui.geometry.Offset.m3985getDistanceimpl(r4)
            goto L_0x0113
        L_0x0106:
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r3 != r0) goto L_0x010f
            float r0 = androidx.compose.ui.geometry.Offset.m3988getYimpl(r4)
            goto L_0x0113
        L_0x010f:
            float r0 = androidx.compose.ui.geometry.Offset.m3987getXimpl(r4)
        L_0x0113:
            r4 = 0
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x011a
            r13 = 1
            goto L_0x011b
        L_0x011a:
            r13 = 0
        L_0x011b:
            if (r13 != 0) goto L_0x0141
        L_0x011d:
            if (r15 != 0) goto L_0x0120
            return r17
        L_0x0120:
            java.lang.Object r0 = r8.invoke(r15)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x012d
            return r17
        L_0x012d:
            boolean r0 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r15)
            if (r0 == 0) goto L_0x0134
            return r15
        L_0x0134:
            r1.invoke(r15)
            long r6 = r15.m5585getIdJ3iCeTQ()
            r0 = r10
            r5 = r17
            r4 = 1
            goto L_0x0071
        L_0x0141:
            r0 = r10
            r5 = r17
            r4 = 1
            r10 = r7
            goto L_0x0079
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m451dragVnAYq1g(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, androidx.compose.foundation.gestures.Orientation, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: drag-VnAYq1g$$forInline  reason: not valid java name */
    private static final Object m452dragVnAYq1g$$forInline(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Unit> function1, Orientation orientation, Function1<? super PointerInputChange, Boolean> function12, Continuation<? super PointerInputChange> continuation) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        float f;
        PointerInputChange pointerInputChange3;
        Orientation orientation2 = orientation;
        long j2 = j;
        if (m455isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j2)) {
            return null;
        }
        while (true) {
            Ref.LongRef longRef = new Ref.LongRef();
            longRef.element = j2;
            while (true) {
                PointerEvent pointerEvent = (PointerEvent) AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, (PointerEventPass) null, continuation, 1, (Object) null);
                List<PointerInputChange> changes = pointerEvent.getChanges();
                int size = changes.size();
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        pointerInputChange = null;
                        break;
                    }
                    pointerInputChange = changes.get(i2);
                    Boolean valueOf = Boolean.valueOf(PointerId.m5569equalsimpl0(pointerInputChange.m5585getIdJ3iCeTQ(), longRef.element));
                    Boolean bool = valueOf;
                    if (valueOf.booleanValue()) {
                        break;
                    }
                    i2++;
                }
                pointerInputChange2 = pointerInputChange;
                if (pointerInputChange2 == null) {
                    pointerInputChange2 = null;
                    break;
                } else if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    int size2 = changes2.size();
                    while (true) {
                        if (i >= size2) {
                            pointerInputChange3 = null;
                            break;
                        }
                        pointerInputChange3 = changes2.get(i);
                        Boolean valueOf2 = Boolean.valueOf(pointerInputChange3.getPressed());
                        Boolean bool2 = valueOf2;
                        if (valueOf2.booleanValue()) {
                            break;
                        }
                        i++;
                    }
                    PointerInputChange pointerInputChange4 = pointerInputChange3;
                    if (pointerInputChange4 == null) {
                        break;
                    }
                    longRef.element = pointerInputChange4.m5585getIdJ3iCeTQ();
                } else {
                    PointerInputChange pointerInputChange5 = pointerInputChange2;
                    long positionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange2);
                    if (orientation2 == null) {
                        f = Offset.m3985getDistanceimpl(positionChangeIgnoreConsumed);
                    } else {
                        f = orientation2 == Orientation.Vertical ? Offset.m3988getYimpl(positionChangeIgnoreConsumed) : Offset.m3987getXimpl(positionChangeIgnoreConsumed);
                    }
                    if (f == 0.0f) {
                        i = 1;
                    }
                    Boolean valueOf3 = Boolean.valueOf(true ^ i);
                    Boolean bool3 = valueOf3;
                    if (valueOf3.booleanValue()) {
                        break;
                    }
                }
            }
            PointerInputChange pointerInputChange6 = pointerInputChange2;
            if (pointerInputChange2 == null || function12.invoke(pointerInputChange2).booleanValue()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                return pointerInputChange2;
            }
            function1.invoke(pointerInputChange2);
            j2 = pointerInputChange2.m5585getIdJ3iCeTQ();
        }
    }

    /* renamed from: awaitDragOrUp-jO51t88  reason: not valid java name */
    private static final Object m441awaitDragOrUpjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Boolean> function1, Continuation<? super PointerInputChange> continuation) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = j;
        while (true) {
            PointerInputChange pointerInputChange3 = null;
            PointerEvent pointerEvent = (PointerEvent) AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, (PointerEventPass) null, continuation, 1, (Object) null);
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i2);
                Boolean valueOf = Boolean.valueOf(PointerId.m5569equalsimpl0(pointerInputChange.m5585getIdJ3iCeTQ(), longRef.element));
                Boolean bool = valueOf;
                if (valueOf.booleanValue()) {
                    break;
                }
                i2++;
            }
            pointerInputChange2 = pointerInputChange;
            if (pointerInputChange2 == null) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                while (true) {
                    if (i >= size2) {
                        break;
                    }
                    PointerInputChange pointerInputChange4 = changes2.get(i);
                    Boolean valueOf2 = Boolean.valueOf(pointerInputChange4.getPressed());
                    Boolean bool2 = valueOf2;
                    if (valueOf2.booleanValue()) {
                        pointerInputChange3 = pointerInputChange4;
                        break;
                    }
                    i++;
                }
                PointerInputChange pointerInputChange5 = pointerInputChange3;
                if (pointerInputChange5 == null) {
                    break;
                }
                longRef.element = pointerInputChange5.m5585getIdJ3iCeTQ();
            } else if (function1.invoke(pointerInputChange2).booleanValue()) {
                break;
            }
        }
        return pointerInputChange2;
    }

    /* renamed from: awaitPointerSlopOrCancellation-pn7EDYM  reason: not valid java name */
    private static final Object m446awaitPointerSlopOrCancellationpn7EDYM(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Orientation orientation, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        AwaitPointerEventScope awaitPointerEventScope2 = awaitPointerEventScope;
        long j2 = j;
        Continuation<? super PointerInputChange> continuation2 = continuation;
        if (m455isPointerUpDmW0f2w(awaitPointerEventScope2.getCurrentEvent(), j2)) {
            return null;
        }
        float r4 = m456pointerSlopE8SPZFQ(awaitPointerEventScope2.getViewConfiguration(), i);
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = j2;
        TouchSlopDetector touchSlopDetector = new TouchSlopDetector(orientation);
        while (true) {
            PointerEvent pointerEvent = (PointerEvent) AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, (PointerEventPass) null, continuation2, 1, (Object) null);
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i3);
                Boolean valueOf = Boolean.valueOf(PointerId.m5569equalsimpl0(pointerInputChange.m5585getIdJ3iCeTQ(), longRef.element));
                Boolean bool = valueOf;
                if (valueOf.booleanValue()) {
                    break;
                }
                i3++;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 == null || pointerInputChange3.isConsumed()) {
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
                Function2<? super PointerInputChange, ? super Offset, Unit> function22 = function2;
            } else {
                Offset r2 = touchSlopDetector.m563addPointerInputChangeGcwITfU(pointerInputChange3, r4);
                if (r2 != null) {
                    function2.invoke(pointerInputChange3, r2);
                    if (pointerInputChange3.isConsumed()) {
                        return pointerInputChange3;
                    }
                    touchSlopDetector.reset();
                } else {
                    Function2<? super PointerInputChange, ? super Offset, Unit> function23 = function2;
                    awaitPointerEventScope2.awaitPointerEvent(PointerEventPass.Final, continuation2);
                    if (pointerInputChange3.isConsumed()) {
                        break;
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: awaitLongPressOrCancellation-rnUCldI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m445awaitLongPressOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r9, long r10, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r12) {
        /*
            boolean r0 = r12 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1 r0 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1 r0 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1
            r0.<init>(r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r9 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r0.L$0
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ PointerEventTimeoutCancellationException -> 0x009e }
            goto L_0x009c
        L_0x0033:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r12)
            androidx.compose.ui.input.pointer.PointerEvent r12 = r9.getCurrentEvent()
            boolean r12 = m455isPointerUpDmW0f2w(r12, r10)
            if (r12 == 0) goto L_0x0049
            return r4
        L_0x0049:
            androidx.compose.ui.input.pointer.PointerEvent r12 = r9.getCurrentEvent()
            java.util.List r12 = r12.getChanges()
            int r2 = r12.size()
            r5 = 0
        L_0x0056:
            if (r5 >= r2) goto L_0x006d
            java.lang.Object r6 = r12.get(r5)
            r7 = r6
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            long r7 = r7.m5585getIdJ3iCeTQ()
            boolean r7 = androidx.compose.ui.input.pointer.PointerId.m5569equalsimpl0(r7, r10)
            if (r7 == 0) goto L_0x006a
            goto L_0x006e
        L_0x006a:
            int r5 = r5 + 1
            goto L_0x0056
        L_0x006d:
            r6 = r4
        L_0x006e:
            r10 = r6
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            if (r10 != 0) goto L_0x0074
            return r4
        L_0x0074:
            kotlin.jvm.internal.Ref$ObjectRef r11 = new kotlin.jvm.internal.Ref$ObjectRef
            r11.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r12 = new kotlin.jvm.internal.Ref$ObjectRef
            r12.<init>()
            r12.element = r10
            androidx.compose.ui.platform.ViewConfiguration r2 = r9.getViewConfiguration()
            long r5 = r2.getLongPressTimeoutMillis()
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2 r2 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2     // Catch:{ PointerEventTimeoutCancellationException -> 0x009d }
            r2.<init>(r12, r11, r4)     // Catch:{ PointerEventTimeoutCancellationException -> 0x009d }
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2     // Catch:{ PointerEventTimeoutCancellationException -> 0x009d }
            r0.L$0 = r10     // Catch:{ PointerEventTimeoutCancellationException -> 0x009d }
            r0.L$1 = r11     // Catch:{ PointerEventTimeoutCancellationException -> 0x009d }
            r0.label = r3     // Catch:{ PointerEventTimeoutCancellationException -> 0x009d }
            java.lang.Object r9 = r9.withTimeout(r5, r2, r0)     // Catch:{ PointerEventTimeoutCancellationException -> 0x009d }
            if (r9 != r1) goto L_0x009c
            return r1
        L_0x009c:
            return r4
        L_0x009d:
            r9 = r11
        L_0x009e:
            T r9 = r9.element
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            if (r9 != 0) goto L_0x00a5
            goto L_0x00a6
        L_0x00a5:
            r10 = r9
        L_0x00a6:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m445awaitLongPressOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* renamed from: isPointerUp-DmW0f2w  reason: not valid java name */
    public static final boolean m455isPointerUpDmW0f2w(PointerEvent pointerEvent, long j) {
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
    public static final float m456pointerSlopE8SPZFQ(ViewConfiguration viewConfiguration, int i) {
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
