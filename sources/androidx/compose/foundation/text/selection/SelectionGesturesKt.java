package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.ViewConfiguration;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002\u001a\u0012\u0010\f\u001a\u00020\u0004*\u00020\rH@¢\u0006\u0002\u0010\u000e\u001a*\u0010\u000f\u001a\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H@¢\u0006\u0002\u0010\u0016\u001a*\u0010\u0017\u001a\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H@¢\u0006\u0002\u0010\u0016\u001a\u001c\u0010\u0018\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0000\u001a\"\u0010\u001d\u001a\u00020\u0010*\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH@¢\u0006\u0002\u0010\u001f\u001a\"\u0010 \u001a\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0004H@¢\u0006\u0002\u0010!\u001a\"\u0010\"\u001a\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u0004H@¢\u0006\u0002\u0010!\u001a\"\u0010$\u001a\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u0004H@¢\u0006\u0002\u0010!\u001a \u0010%\u001a\u00020\u0019*\u00020\u00192\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00100'H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006("}, d2 = {"STATIC_KEY", "", "isPrecisePointer", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "(Landroidx/compose/ui/input/pointer/PointerEvent;)Z", "distanceIsTolerable", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "change1", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "change2", "awaitDown", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mouseSelection", "", "observer", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "clicksCounter", "Landroidx/compose/foundation/text/selection/ClicksCounter;", "down", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/selection/ClicksCounter;Landroidx/compose/ui/input/pointer/PointerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mouseSelectionBtf2", "selectionGestureInput", "Landroidx/compose/ui/Modifier;", "mouseSelectionObserver", "textDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "selectionGesturePointerInputBtf2", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/TextDragObserver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "touchSelection", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/TextDragObserver;Landroidx/compose/ui/input/pointer/PointerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "touchSelectionFirstPress", "downEvent", "touchSelectionSubsequentPress", "updateSelectionTouchMode", "updateTouchMode", "Lkotlin/Function1;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionGestures.kt */
public final class SelectionGesturesKt {
    private static final int STATIC_KEY = 8675309;

    public static final Modifier updateSelectionTouchMode(Modifier modifier, Function1<? super Boolean, Unit> function1) {
        return SuspendingPointerInputFilterKt.pointerInput(modifier, (Object) Integer.valueOf(STATIC_KEY), (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new SelectionGesturesKt$updateSelectionTouchMode$1(function1, (Continuation<? super SelectionGesturesKt$updateSelectionTouchMode$1>) null));
    }

    public static final Modifier selectionGestureInput(Modifier modifier, MouseSelectionObserver mouseSelectionObserver, TextDragObserver textDragObserver) {
        return SuspendingPointerInputFilterKt.pointerInput(modifier, mouseSelectionObserver, textDragObserver, new SelectionGesturesKt$selectionGestureInput$1(mouseSelectionObserver, textDragObserver, (Continuation<? super SelectionGesturesKt$selectionGestureInput$1>) null));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: androidx.compose.foundation.text.TextDragObserver} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009e, code lost:
        if (r11 != r1) goto L_0x00a1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object touchSelection(androidx.compose.ui.input.pointer.AwaitPointerEventScope r8, androidx.compose.foundation.text.TextDragObserver r9, androidx.compose.ui.input.pointer.PointerEvent r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            boolean r0 = r11 instanceof androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$1 r0 = (androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$1 r0 = new androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$1
            r0.<init>(r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0051
            if (r2 == r4) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r8 = r0.L$1
            r9 = r8
            androidx.compose.foundation.text.TextDragObserver r9 = (androidx.compose.foundation.text.TextDragObserver) r9
            java.lang.Object r8 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ CancellationException -> 0x00d4 }
            goto L_0x00a1
        L_0x0036:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003e:
            java.lang.Object r8 = r0.L$2
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            java.lang.Object r9 = r0.L$1
            androidx.compose.foundation.text.TextDragObserver r9 = (androidx.compose.foundation.text.TextDragObserver) r9
            java.lang.Object r10 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ CancellationException -> 0x00d4 }
            r7 = r10
            r10 = r8
            r8 = r7
            goto L_0x0071
        L_0x0051:
            kotlin.ResultKt.throwOnFailure(r11)
            java.util.List r10 = r10.getChanges()     // Catch:{ CancellationException -> 0x00d4 }
            java.lang.Object r10 = kotlin.collections.CollectionsKt.first(r10)     // Catch:{ CancellationException -> 0x00d4 }
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10     // Catch:{ CancellationException -> 0x00d4 }
            long r5 = r10.m5585getIdJ3iCeTQ()     // Catch:{ CancellationException -> 0x00d4 }
            r0.L$0 = r8     // Catch:{ CancellationException -> 0x00d4 }
            r0.L$1 = r9     // Catch:{ CancellationException -> 0x00d4 }
            r0.L$2 = r10     // Catch:{ CancellationException -> 0x00d4 }
            r0.label = r4     // Catch:{ CancellationException -> 0x00d4 }
            java.lang.Object r11 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m445awaitLongPressOrCancellationrnUCldI(r8, r5, r0)     // Catch:{ CancellationException -> 0x00d4 }
            if (r11 != r1) goto L_0x0071
            goto L_0x00a0
        L_0x0071:
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11     // Catch:{ CancellationException -> 0x00d4 }
            if (r11 == 0) goto L_0x00d1
            androidx.compose.ui.platform.ViewConfiguration r2 = r8.getViewConfiguration()     // Catch:{ CancellationException -> 0x00d4 }
            boolean r10 = distanceIsTolerable(r2, r10, r11)     // Catch:{ CancellationException -> 0x00d4 }
            if (r10 == 0) goto L_0x00d1
            long r4 = r11.m5587getPositionF1C5BW0()     // Catch:{ CancellationException -> 0x00d4 }
            r9.m1258onStartk4lQ0M(r4)     // Catch:{ CancellationException -> 0x00d4 }
            long r10 = r11.m5585getIdJ3iCeTQ()     // Catch:{ CancellationException -> 0x00d4 }
            androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$2 r2 = new androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$2     // Catch:{ CancellationException -> 0x00d4 }
            r2.<init>(r9)     // Catch:{ CancellationException -> 0x00d4 }
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2     // Catch:{ CancellationException -> 0x00d4 }
            r0.L$0 = r8     // Catch:{ CancellationException -> 0x00d4 }
            r0.L$1 = r9     // Catch:{ CancellationException -> 0x00d4 }
            r4 = 0
            r0.L$2 = r4     // Catch:{ CancellationException -> 0x00d4 }
            r0.label = r3     // Catch:{ CancellationException -> 0x00d4 }
            java.lang.Object r11 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m453dragjO51t88(r8, r10, r2, r0)     // Catch:{ CancellationException -> 0x00d4 }
            if (r11 != r1) goto L_0x00a1
        L_0x00a0:
            return r1
        L_0x00a1:
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch:{ CancellationException -> 0x00d4 }
            boolean r10 = r11.booleanValue()     // Catch:{ CancellationException -> 0x00d4 }
            if (r10 == 0) goto L_0x00ce
            androidx.compose.ui.input.pointer.PointerEvent r8 = r8.getCurrentEvent()     // Catch:{ CancellationException -> 0x00d4 }
            java.util.List r8 = r8.getChanges()     // Catch:{ CancellationException -> 0x00d4 }
            int r10 = r8.size()     // Catch:{ CancellationException -> 0x00d4 }
            r11 = 0
        L_0x00b6:
            if (r11 >= r10) goto L_0x00ca
            java.lang.Object r0 = r8.get(r11)     // Catch:{ CancellationException -> 0x00d4 }
            androidx.compose.ui.input.pointer.PointerInputChange r0 = (androidx.compose.ui.input.pointer.PointerInputChange) r0     // Catch:{ CancellationException -> 0x00d4 }
            boolean r1 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUp(r0)     // Catch:{ CancellationException -> 0x00d4 }
            if (r1 == 0) goto L_0x00c7
            r0.consume()     // Catch:{ CancellationException -> 0x00d4 }
        L_0x00c7:
            int r11 = r11 + 1
            goto L_0x00b6
        L_0x00ca:
            r9.onStop()     // Catch:{ CancellationException -> 0x00d4 }
            goto L_0x00d1
        L_0x00ce:
            r9.onCancel()     // Catch:{ CancellationException -> 0x00d4 }
        L_0x00d1:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x00d4:
            r8 = move-exception
            r9.onCancel()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt.touchSelection(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.foundation.text.TextDragObserver, androidx.compose.ui.input.pointer.PointerEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: androidx.compose.foundation.text.selection.MouseSelectionObserver} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: androidx.compose.foundation.text.selection.MouseSelectionObserver} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0082, code lost:
        if (r11 == r1) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ec, code lost:
        if (r11 == r1) goto L_0x00ee;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object mouseSelection(androidx.compose.ui.input.pointer.AwaitPointerEventScope r7, androidx.compose.foundation.text.selection.MouseSelectionObserver r8, androidx.compose.foundation.text.selection.ClicksCounter r9, androidx.compose.ui.input.pointer.PointerEvent r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            boolean r0 = r11 instanceof androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$1 r0 = (androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$1 r0 = new androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$1
            r0.<init>(r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x004d
            if (r2 == r5) goto L_0x0040
            if (r2 != r4) goto L_0x0038
            java.lang.Object r7 = r0.L$1
            r8 = r7
            androidx.compose.foundation.text.selection.MouseSelectionObserver r8 = (androidx.compose.foundation.text.selection.MouseSelectionObserver) r8
            java.lang.Object r7 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00ef
        L_0x0038:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0040:
            java.lang.Object r7 = r0.L$1
            r8 = r7
            androidx.compose.foundation.text.selection.MouseSelectionObserver r8 = (androidx.compose.foundation.text.selection.MouseSelectionObserver) r8
            java.lang.Object r7 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0085
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r11)
            r9.update(r10)
            java.util.List r11 = r10.getChanges()
            java.lang.Object r11 = r11.get(r3)
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            boolean r10 = androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt.isShiftPressed(r10)
            if (r10 == 0) goto L_0x00b1
            long r9 = r11.m5587getPositionF1C5BW0()
            boolean r9 = r8.m1560onExtendk4lQ0M(r9)
            if (r9 == 0) goto L_0x011a
            long r9 = r11.m5585getIdJ3iCeTQ()
            androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$shouldConsumeUp$1 r11 = new androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$shouldConsumeUp$1
            r11.<init>(r8)
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r5
            java.lang.Object r11 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m453dragjO51t88(r7, r9, r11, r0)
            if (r11 != r1) goto L_0x0085
            goto L_0x00ee
        L_0x0085:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r9 = r11.booleanValue()
            if (r9 == 0) goto L_0x00ad
            androidx.compose.ui.input.pointer.PointerEvent r7 = r7.getCurrentEvent()
            java.util.List r7 = r7.getChanges()
            int r9 = r7.size()
        L_0x0099:
            if (r3 >= r9) goto L_0x00ad
            java.lang.Object r10 = r7.get(r3)
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            boolean r11 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUp(r10)
            if (r11 == 0) goto L_0x00aa
            r10.consume()
        L_0x00aa:
            int r3 = r3 + 1
            goto L_0x0099
        L_0x00ad:
            r8.onDragDone()
            goto L_0x011a
        L_0x00b1:
            int r9 = r9.getClicks()
            if (r9 == r5) goto L_0x00c7
            if (r9 == r4) goto L_0x00c0
            androidx.compose.foundation.text.selection.SelectionAdjustment$Companion r9 = androidx.compose.foundation.text.selection.SelectionAdjustment.Companion
            androidx.compose.foundation.text.selection.SelectionAdjustment r9 = r9.getParagraph()
            goto L_0x00cd
        L_0x00c0:
            androidx.compose.foundation.text.selection.SelectionAdjustment$Companion r9 = androidx.compose.foundation.text.selection.SelectionAdjustment.Companion
            androidx.compose.foundation.text.selection.SelectionAdjustment r9 = r9.getWord()
            goto L_0x00cd
        L_0x00c7:
            androidx.compose.foundation.text.selection.SelectionAdjustment$Companion r9 = androidx.compose.foundation.text.selection.SelectionAdjustment.Companion
            androidx.compose.foundation.text.selection.SelectionAdjustment r9 = r9.getNone()
        L_0x00cd:
            long r5 = r11.m5587getPositionF1C5BW0()
            boolean r10 = r8.m1562onStart3MmeM6k(r5, r9)
            if (r10 == 0) goto L_0x011a
            long r10 = r11.m5585getIdJ3iCeTQ()
            androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$shouldConsumeUp$2 r2 = new androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$shouldConsumeUp$2
            r2.<init>(r8, r9)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r11 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m453dragjO51t88(r7, r10, r2, r0)
            if (r11 != r1) goto L_0x00ef
        L_0x00ee:
            return r1
        L_0x00ef:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r9 = r11.booleanValue()
            if (r9 == 0) goto L_0x0117
            androidx.compose.ui.input.pointer.PointerEvent r7 = r7.getCurrentEvent()
            java.util.List r7 = r7.getChanges()
            int r9 = r7.size()
        L_0x0103:
            if (r3 >= r9) goto L_0x0117
            java.lang.Object r10 = r7.get(r3)
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            boolean r11 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUp(r10)
            if (r11 == 0) goto L_0x0114
            r10.consume()
        L_0x0114:
            int r3 = r3 + 1
            goto L_0x0103
        L_0x0117:
            r8.onDragDone()
        L_0x011a:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt.mouseSelection(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.foundation.text.selection.MouseSelectionObserver, androidx.compose.foundation.text.selection.ClicksCounter, androidx.compose.ui.input.pointer.PointerEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object selectionGesturePointerInputBtf2(PointerInputScope pointerInputScope, MouseSelectionObserver mouseSelectionObserver, TextDragObserver textDragObserver, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new SelectionGesturesKt$selectionGesturePointerInputBtf2$2(new ClicksCounter(pointerInputScope.getViewConfiguration()), mouseSelectionObserver, textDragObserver, (Continuation<? super SelectionGesturesKt$selectionGesturePointerInputBtf2$2>) null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: androidx.compose.foundation.text.TextDragObserver} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009e, code lost:
        if (r11 != r1) goto L_0x00a1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object touchSelectionFirstPress(androidx.compose.ui.input.pointer.AwaitPointerEventScope r8, androidx.compose.foundation.text.TextDragObserver r9, androidx.compose.ui.input.pointer.PointerEvent r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            boolean r0 = r11 instanceof androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionFirstPress$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionFirstPress$1 r0 = (androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionFirstPress$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionFirstPress$1 r0 = new androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionFirstPress$1
            r0.<init>(r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0051
            if (r2 == r4) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r8 = r0.L$1
            r9 = r8
            androidx.compose.foundation.text.TextDragObserver r9 = (androidx.compose.foundation.text.TextDragObserver) r9
            java.lang.Object r8 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ CancellationException -> 0x00d4 }
            goto L_0x00a1
        L_0x0036:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003e:
            java.lang.Object r8 = r0.L$2
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            java.lang.Object r9 = r0.L$1
            androidx.compose.foundation.text.TextDragObserver r9 = (androidx.compose.foundation.text.TextDragObserver) r9
            java.lang.Object r10 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ CancellationException -> 0x00d4 }
            r7 = r10
            r10 = r8
            r8 = r7
            goto L_0x0071
        L_0x0051:
            kotlin.ResultKt.throwOnFailure(r11)
            java.util.List r10 = r10.getChanges()     // Catch:{ CancellationException -> 0x00d4 }
            java.lang.Object r10 = kotlin.collections.CollectionsKt.first(r10)     // Catch:{ CancellationException -> 0x00d4 }
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10     // Catch:{ CancellationException -> 0x00d4 }
            long r5 = r10.m5585getIdJ3iCeTQ()     // Catch:{ CancellationException -> 0x00d4 }
            r0.L$0 = r8     // Catch:{ CancellationException -> 0x00d4 }
            r0.L$1 = r9     // Catch:{ CancellationException -> 0x00d4 }
            r0.L$2 = r10     // Catch:{ CancellationException -> 0x00d4 }
            r0.label = r4     // Catch:{ CancellationException -> 0x00d4 }
            java.lang.Object r11 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m445awaitLongPressOrCancellationrnUCldI(r8, r5, r0)     // Catch:{ CancellationException -> 0x00d4 }
            if (r11 != r1) goto L_0x0071
            goto L_0x00a0
        L_0x0071:
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11     // Catch:{ CancellationException -> 0x00d4 }
            if (r11 == 0) goto L_0x00d1
            androidx.compose.ui.platform.ViewConfiguration r2 = r8.getViewConfiguration()     // Catch:{ CancellationException -> 0x00d4 }
            boolean r10 = distanceIsTolerable(r2, r10, r11)     // Catch:{ CancellationException -> 0x00d4 }
            if (r10 == 0) goto L_0x00d1
            long r4 = r11.m5587getPositionF1C5BW0()     // Catch:{ CancellationException -> 0x00d4 }
            r9.m1258onStartk4lQ0M(r4)     // Catch:{ CancellationException -> 0x00d4 }
            long r10 = r11.m5585getIdJ3iCeTQ()     // Catch:{ CancellationException -> 0x00d4 }
            androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionFirstPress$dragCompletedWithUp$1 r2 = new androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionFirstPress$dragCompletedWithUp$1     // Catch:{ CancellationException -> 0x00d4 }
            r2.<init>(r9)     // Catch:{ CancellationException -> 0x00d4 }
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2     // Catch:{ CancellationException -> 0x00d4 }
            r0.L$0 = r8     // Catch:{ CancellationException -> 0x00d4 }
            r0.L$1 = r9     // Catch:{ CancellationException -> 0x00d4 }
            r4 = 0
            r0.L$2 = r4     // Catch:{ CancellationException -> 0x00d4 }
            r0.label = r3     // Catch:{ CancellationException -> 0x00d4 }
            java.lang.Object r11 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m453dragjO51t88(r8, r10, r2, r0)     // Catch:{ CancellationException -> 0x00d4 }
            if (r11 != r1) goto L_0x00a1
        L_0x00a0:
            return r1
        L_0x00a1:
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch:{ CancellationException -> 0x00d4 }
            boolean r10 = r11.booleanValue()     // Catch:{ CancellationException -> 0x00d4 }
            if (r10 == 0) goto L_0x00ce
            androidx.compose.ui.input.pointer.PointerEvent r8 = r8.getCurrentEvent()     // Catch:{ CancellationException -> 0x00d4 }
            java.util.List r8 = r8.getChanges()     // Catch:{ CancellationException -> 0x00d4 }
            int r10 = r8.size()     // Catch:{ CancellationException -> 0x00d4 }
            r11 = 0
        L_0x00b6:
            if (r11 >= r10) goto L_0x00ca
            java.lang.Object r0 = r8.get(r11)     // Catch:{ CancellationException -> 0x00d4 }
            androidx.compose.ui.input.pointer.PointerInputChange r0 = (androidx.compose.ui.input.pointer.PointerInputChange) r0     // Catch:{ CancellationException -> 0x00d4 }
            boolean r1 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUp(r0)     // Catch:{ CancellationException -> 0x00d4 }
            if (r1 == 0) goto L_0x00c7
            r0.consume()     // Catch:{ CancellationException -> 0x00d4 }
        L_0x00c7:
            int r11 = r11 + 1
            goto L_0x00b6
        L_0x00ca:
            r9.onStop()     // Catch:{ CancellationException -> 0x00d4 }
            goto L_0x00d1
        L_0x00ce:
            r9.onCancel()     // Catch:{ CancellationException -> 0x00d4 }
        L_0x00d1:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x00d4:
            r8 = move-exception
            r9.onCancel()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt.touchSelectionFirstPress(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.foundation.text.TextDragObserver, androidx.compose.ui.input.pointer.PointerEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v8, resolved type: androidx.compose.foundation.text.TextDragObserver} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00de, code lost:
        if (r15 == r1) goto L_0x00e0;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a6 A[Catch:{ CancellationException -> 0x0114 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ac A[Catch:{ CancellationException -> 0x0114 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00af A[Catch:{ CancellationException -> 0x0114 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object touchSelectionSubsequentPress(androidx.compose.ui.input.pointer.AwaitPointerEventScope r12, androidx.compose.foundation.text.TextDragObserver r13, androidx.compose.ui.input.pointer.PointerEvent r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            boolean r0 = r15 instanceof androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionSubsequentPress$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionSubsequentPress$1 r0 = (androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionSubsequentPress$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionSubsequentPress$1 r0 = new androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionSubsequentPress$1
            r0.<init>(r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x0061
            if (r2 == r5) goto L_0x0040
            if (r2 != r3) goto L_0x0038
            java.lang.Object r12 = r0.L$1
            r13 = r12
            androidx.compose.foundation.text.TextDragObserver r13 = (androidx.compose.foundation.text.TextDragObserver) r13
            java.lang.Object r12 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r12 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r12
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ CancellationException -> 0x0114 }
            goto L_0x00e1
        L_0x0038:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0040:
            long r12 = r0.J$0
            java.lang.Object r14 = r0.L$3
            kotlin.jvm.internal.Ref$LongRef r14 = (kotlin.jvm.internal.Ref.LongRef) r14
            java.lang.Object r2 = r0.L$2
            androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2
            java.lang.Object r5 = r0.L$1
            androidx.compose.foundation.text.TextDragObserver r5 = (androidx.compose.foundation.text.TextDragObserver) r5
            java.lang.Object r6 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r6 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r6
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ CancellationException -> 0x005d }
            r10 = r6
            r6 = r14
            r11 = r5
            r5 = r15
            r14 = r12
            r13 = r11
            r12 = r10
            goto L_0x00a2
        L_0x005d:
            r12 = move-exception
            r13 = r5
            goto L_0x0115
        L_0x0061:
            kotlin.ResultKt.throwOnFailure(r15)
            java.util.List r14 = r14.getChanges()     // Catch:{ CancellationException -> 0x0114 }
            java.lang.Object r14 = kotlin.collections.CollectionsKt.first(r14)     // Catch:{ CancellationException -> 0x0114 }
            r2 = r14
            androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2     // Catch:{ CancellationException -> 0x0114 }
            long r14 = r2.m5585getIdJ3iCeTQ()     // Catch:{ CancellationException -> 0x0114 }
            kotlin.jvm.internal.Ref$LongRef r6 = new kotlin.jvm.internal.Ref$LongRef     // Catch:{ CancellationException -> 0x0114 }
            r6.<init>()     // Catch:{ CancellationException -> 0x0114 }
            androidx.compose.ui.geometry.Offset$Companion r7 = androidx.compose.ui.geometry.Offset.Companion     // Catch:{ CancellationException -> 0x0114 }
            long r7 = r7.m4002getUnspecifiedF1C5BW0()     // Catch:{ CancellationException -> 0x0114 }
            r6.element = r7     // Catch:{ CancellationException -> 0x0114 }
            androidx.compose.ui.platform.ViewConfiguration r7 = r12.getViewConfiguration()     // Catch:{ CancellationException -> 0x0114 }
            long r7 = r7.getLongPressTimeoutMillis()     // Catch:{ CancellationException -> 0x0114 }
            androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1 r9 = new androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1     // Catch:{ CancellationException -> 0x0114 }
            r9.<init>(r14, r6, r4)     // Catch:{ CancellationException -> 0x0114 }
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9     // Catch:{ CancellationException -> 0x0114 }
            r0.L$0 = r12     // Catch:{ CancellationException -> 0x0114 }
            r0.L$1 = r13     // Catch:{ CancellationException -> 0x0114 }
            r0.L$2 = r2     // Catch:{ CancellationException -> 0x0114 }
            r0.L$3 = r6     // Catch:{ CancellationException -> 0x0114 }
            r0.J$0 = r14     // Catch:{ CancellationException -> 0x0114 }
            r0.label = r5     // Catch:{ CancellationException -> 0x0114 }
            java.lang.Object r5 = r12.withTimeoutOrNull(r7, r9, r0)     // Catch:{ CancellationException -> 0x0114 }
            if (r5 != r1) goto L_0x00a2
            goto L_0x00e0
        L_0x00a2:
            androidx.compose.foundation.text.selection.DownResolution r5 = (androidx.compose.foundation.text.selection.DownResolution) r5     // Catch:{ CancellationException -> 0x0114 }
            if (r5 != 0) goto L_0x00a8
            androidx.compose.foundation.text.selection.DownResolution r5 = androidx.compose.foundation.text.selection.DownResolution.Timeout     // Catch:{ CancellationException -> 0x0114 }
        L_0x00a8:
            androidx.compose.foundation.text.selection.DownResolution r7 = androidx.compose.foundation.text.selection.DownResolution.Cancel     // Catch:{ CancellationException -> 0x0114 }
            if (r5 != r7) goto L_0x00af
            kotlin.Unit r12 = kotlin.Unit.INSTANCE     // Catch:{ CancellationException -> 0x0114 }
            return r12
        L_0x00af:
            long r7 = r2.m5587getPositionF1C5BW0()     // Catch:{ CancellationException -> 0x0114 }
            r13.m1258onStartk4lQ0M(r7)     // Catch:{ CancellationException -> 0x0114 }
            androidx.compose.foundation.text.selection.DownResolution r2 = androidx.compose.foundation.text.selection.DownResolution.Up     // Catch:{ CancellationException -> 0x0114 }
            if (r5 != r2) goto L_0x00c0
            r13.onStop()     // Catch:{ CancellationException -> 0x0114 }
            kotlin.Unit r12 = kotlin.Unit.INSTANCE     // Catch:{ CancellationException -> 0x0114 }
            return r12
        L_0x00c0:
            androidx.compose.foundation.text.selection.DownResolution r2 = androidx.compose.foundation.text.selection.DownResolution.Drag     // Catch:{ CancellationException -> 0x0114 }
            if (r5 != r2) goto L_0x00c9
            long r5 = r6.element     // Catch:{ CancellationException -> 0x0114 }
            r13.m1257onDragk4lQ0M(r5)     // Catch:{ CancellationException -> 0x0114 }
        L_0x00c9:
            androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionSubsequentPress$dragCompletedWithUp$1 r2 = new androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionSubsequentPress$dragCompletedWithUp$1     // Catch:{ CancellationException -> 0x0114 }
            r2.<init>(r13)     // Catch:{ CancellationException -> 0x0114 }
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2     // Catch:{ CancellationException -> 0x0114 }
            r0.L$0 = r12     // Catch:{ CancellationException -> 0x0114 }
            r0.L$1 = r13     // Catch:{ CancellationException -> 0x0114 }
            r0.L$2 = r4     // Catch:{ CancellationException -> 0x0114 }
            r0.L$3 = r4     // Catch:{ CancellationException -> 0x0114 }
            r0.label = r3     // Catch:{ CancellationException -> 0x0114 }
            java.lang.Object r15 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m453dragjO51t88(r12, r14, r2, r0)     // Catch:{ CancellationException -> 0x0114 }
            if (r15 != r1) goto L_0x00e1
        L_0x00e0:
            return r1
        L_0x00e1:
            java.lang.Boolean r15 = (java.lang.Boolean) r15     // Catch:{ CancellationException -> 0x0114 }
            boolean r14 = r15.booleanValue()     // Catch:{ CancellationException -> 0x0114 }
            if (r14 == 0) goto L_0x010e
            androidx.compose.ui.input.pointer.PointerEvent r12 = r12.getCurrentEvent()     // Catch:{ CancellationException -> 0x0114 }
            java.util.List r12 = r12.getChanges()     // Catch:{ CancellationException -> 0x0114 }
            int r14 = r12.size()     // Catch:{ CancellationException -> 0x0114 }
            r15 = 0
        L_0x00f6:
            if (r15 >= r14) goto L_0x010a
            java.lang.Object r0 = r12.get(r15)     // Catch:{ CancellationException -> 0x0114 }
            androidx.compose.ui.input.pointer.PointerInputChange r0 = (androidx.compose.ui.input.pointer.PointerInputChange) r0     // Catch:{ CancellationException -> 0x0114 }
            boolean r1 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUp(r0)     // Catch:{ CancellationException -> 0x0114 }
            if (r1 == 0) goto L_0x0107
            r0.consume()     // Catch:{ CancellationException -> 0x0114 }
        L_0x0107:
            int r15 = r15 + 1
            goto L_0x00f6
        L_0x010a:
            r13.onStop()     // Catch:{ CancellationException -> 0x0114 }
            goto L_0x0111
        L_0x010e:
            r13.onCancel()     // Catch:{ CancellationException -> 0x0114 }
        L_0x0111:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x0114:
            r12 = move-exception
        L_0x0115:
            r13.onCancel()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt.touchSelectionSubsequentPress(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.foundation.text.TextDragObserver, androidx.compose.ui.input.pointer.PointerEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: androidx.compose.foundation.text.selection.MouseSelectionObserver} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: androidx.compose.foundation.text.selection.MouseSelectionObserver} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00fa, code lost:
        if (r11 == r1) goto L_0x00fc;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0093 A[Catch:{ all -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object mouseSelectionBtf2(androidx.compose.ui.input.pointer.AwaitPointerEventScope r7, androidx.compose.foundation.text.selection.MouseSelectionObserver r8, androidx.compose.foundation.text.selection.ClicksCounter r9, androidx.compose.ui.input.pointer.PointerEvent r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            boolean r0 = r11 instanceof androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelectionBtf2$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelectionBtf2$1 r0 = (androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelectionBtf2$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelectionBtf2$1 r0 = new androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelectionBtf2$1
            r0.<init>(r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0052
            if (r2 == r5) goto L_0x0043
            if (r2 != r4) goto L_0x003b
            java.lang.Object r7 = r0.L$1
            r8 = r7
            androidx.compose.foundation.text.selection.MouseSelectionObserver r8 = (androidx.compose.foundation.text.selection.MouseSelectionObserver) r8
            java.lang.Object r7 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0038 }
            goto L_0x00fd
        L_0x0038:
            r7 = move-exception
            goto L_0x0129
        L_0x003b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0043:
            java.lang.Object r7 = r0.L$1
            r8 = r7
            androidx.compose.foundation.text.selection.MouseSelectionObserver r8 = (androidx.compose.foundation.text.selection.MouseSelectionObserver) r8
            java.lang.Object r7 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0050 }
            goto L_0x008b
        L_0x0050:
            r7 = move-exception
            goto L_0x00b8
        L_0x0052:
            kotlin.ResultKt.throwOnFailure(r11)
            java.util.List r11 = r10.getChanges()
            java.lang.Object r11 = r11.get(r3)
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            boolean r10 = androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt.isShiftPressed(r10)
            if (r10 == 0) goto L_0x00bc
            long r9 = r11.m5587getPositionF1C5BW0()
            boolean r9 = r8.m1560onExtendk4lQ0M(r9)
            if (r9 == 0) goto L_0x012d
            r11.consume()     // Catch:{ all -> 0x0050 }
            long r9 = r11.m5585getIdJ3iCeTQ()     // Catch:{ all -> 0x0050 }
            androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelectionBtf2$shouldConsumeUp$1 r11 = new androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelectionBtf2$shouldConsumeUp$1     // Catch:{ all -> 0x0050 }
            r11.<init>(r8)     // Catch:{ all -> 0x0050 }
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11     // Catch:{ all -> 0x0050 }
            r0.L$0 = r7     // Catch:{ all -> 0x0050 }
            r0.L$1 = r8     // Catch:{ all -> 0x0050 }
            r0.label = r5     // Catch:{ all -> 0x0050 }
            java.lang.Object r11 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m453dragjO51t88(r7, r9, r11, r0)     // Catch:{ all -> 0x0050 }
            if (r11 != r1) goto L_0x008b
            goto L_0x00fc
        L_0x008b:
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch:{ all -> 0x0050 }
            boolean r9 = r11.booleanValue()     // Catch:{ all -> 0x0050 }
            if (r9 == 0) goto L_0x00b3
            androidx.compose.ui.input.pointer.PointerEvent r7 = r7.getCurrentEvent()     // Catch:{ all -> 0x0050 }
            java.util.List r7 = r7.getChanges()     // Catch:{ all -> 0x0050 }
            int r9 = r7.size()     // Catch:{ all -> 0x0050 }
        L_0x009f:
            if (r3 >= r9) goto L_0x00b3
            java.lang.Object r10 = r7.get(r3)     // Catch:{ all -> 0x0050 }
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10     // Catch:{ all -> 0x0050 }
            boolean r11 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUp(r10)     // Catch:{ all -> 0x0050 }
            if (r11 == 0) goto L_0x00b0
            r10.consume()     // Catch:{ all -> 0x0050 }
        L_0x00b0:
            int r3 = r3 + 1
            goto L_0x009f
        L_0x00b3:
            r8.onDragDone()
            goto L_0x012d
        L_0x00b8:
            r8.onDragDone()
            throw r7
        L_0x00bc:
            int r9 = r9.getClicks()
            if (r9 == r5) goto L_0x00d2
            if (r9 == r4) goto L_0x00cb
            androidx.compose.foundation.text.selection.SelectionAdjustment$Companion r9 = androidx.compose.foundation.text.selection.SelectionAdjustment.Companion
            androidx.compose.foundation.text.selection.SelectionAdjustment r9 = r9.getParagraph()
            goto L_0x00d8
        L_0x00cb:
            androidx.compose.foundation.text.selection.SelectionAdjustment$Companion r9 = androidx.compose.foundation.text.selection.SelectionAdjustment.Companion
            androidx.compose.foundation.text.selection.SelectionAdjustment r9 = r9.getWord()
            goto L_0x00d8
        L_0x00d2:
            androidx.compose.foundation.text.selection.SelectionAdjustment$Companion r9 = androidx.compose.foundation.text.selection.SelectionAdjustment.Companion
            androidx.compose.foundation.text.selection.SelectionAdjustment r9 = r9.getNone()
        L_0x00d8:
            long r5 = r11.m5587getPositionF1C5BW0()
            boolean r10 = r8.m1562onStart3MmeM6k(r5, r9)
            if (r10 == 0) goto L_0x012d
            r11.consume()     // Catch:{ all -> 0x0038 }
            long r10 = r11.m5585getIdJ3iCeTQ()     // Catch:{ all -> 0x0038 }
            androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelectionBtf2$shouldConsumeUp$2 r2 = new androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelectionBtf2$shouldConsumeUp$2     // Catch:{ all -> 0x0038 }
            r2.<init>(r8, r9)     // Catch:{ all -> 0x0038 }
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2     // Catch:{ all -> 0x0038 }
            r0.L$0 = r7     // Catch:{ all -> 0x0038 }
            r0.L$1 = r8     // Catch:{ all -> 0x0038 }
            r0.label = r4     // Catch:{ all -> 0x0038 }
            java.lang.Object r11 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m453dragjO51t88(r7, r10, r2, r0)     // Catch:{ all -> 0x0038 }
            if (r11 != r1) goto L_0x00fd
        L_0x00fc:
            return r1
        L_0x00fd:
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch:{ all -> 0x0038 }
            boolean r9 = r11.booleanValue()     // Catch:{ all -> 0x0038 }
            if (r9 == 0) goto L_0x0125
            androidx.compose.ui.input.pointer.PointerEvent r7 = r7.getCurrentEvent()     // Catch:{ all -> 0x0038 }
            java.util.List r7 = r7.getChanges()     // Catch:{ all -> 0x0038 }
            int r9 = r7.size()     // Catch:{ all -> 0x0038 }
        L_0x0111:
            if (r3 >= r9) goto L_0x0125
            java.lang.Object r10 = r7.get(r3)     // Catch:{ all -> 0x0038 }
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10     // Catch:{ all -> 0x0038 }
            boolean r11 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUp(r10)     // Catch:{ all -> 0x0038 }
            if (r11 == 0) goto L_0x0122
            r10.consume()     // Catch:{ all -> 0x0038 }
        L_0x0122:
            int r3 = r3 + 1
            goto L_0x0111
        L_0x0125:
            r8.onDragDone()
            goto L_0x012d
        L_0x0129:
            r8.onDragDone()
            throw r7
        L_0x012d:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt.mouseSelectionBtf2(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.foundation.text.selection.MouseSelectionObserver, androidx.compose.foundation.text.selection.ClicksCounter, androidx.compose.ui.input.pointer.PointerEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0045 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0063 A[SYNTHETIC] */
    public static final java.lang.Object awaitDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope r7, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerEvent> r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1 r0 = (androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1 r0 = new androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1
            r0.<init>(r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r7 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0046
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r8)
        L_0x0039:
            androidx.compose.ui.input.pointer.PointerEventPass r8 = androidx.compose.ui.input.pointer.PointerEventPass.Main
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r8 = r7.awaitPointerEvent(r8, r0)
            if (r8 != r1) goto L_0x0046
            return r1
        L_0x0046:
            androidx.compose.ui.input.pointer.PointerEvent r8 = (androidx.compose.ui.input.pointer.PointerEvent) r8
            java.util.List r2 = r8.getChanges()
            int r4 = r2.size()
            r5 = 0
        L_0x0051:
            if (r5 >= r4) goto L_0x0063
            java.lang.Object r6 = r2.get(r5)
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            boolean r6 = androidx.compose.ui.input.pointer.PointerEventKt.changedToDownIgnoreConsumed(r6)
            if (r6 != 0) goto L_0x0060
            goto L_0x0039
        L_0x0060:
            int r5 = r5 + 1
            goto L_0x0051
        L_0x0063:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt.awaitDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final boolean distanceIsTolerable(ViewConfiguration viewConfiguration, PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2) {
        return Offset.m3985getDistanceimpl(Offset.m3991minusMKHz9U(pointerInputChange.m5587getPositionF1C5BW0(), pointerInputChange2.m5587getPositionF1C5BW0())) < DragGestureDetectorKt.m456pointerSlopE8SPZFQ(viewConfiguration, pointerInputChange.m5590getTypeT8wyACA());
    }

    public static final boolean isPrecisePointer(PointerEvent pointerEvent) {
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            if (!PointerType.m5662equalsimpl0(changes.get(i).m5590getTypeT8wyACA(), PointerType.Companion.m5667getMouseT8wyACA())) {
                return false;
            }
        }
        return true;
    }
}
