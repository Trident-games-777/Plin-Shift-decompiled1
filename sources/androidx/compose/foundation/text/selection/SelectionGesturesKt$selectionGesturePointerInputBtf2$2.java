package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGesturePointerInputBtf2$2", f = "SelectionGestures.kt", i = {0}, l = {209, 217, 220, 221}, m = "invokeSuspend", n = {"$this$awaitEachGesture"}, s = {"L$0"})
/* compiled from: SelectionGestures.kt */
final class SelectionGesturesKt$selectionGesturePointerInputBtf2$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ClicksCounter $clicksCounter;
    final /* synthetic */ MouseSelectionObserver $mouseSelectionObserver;
    final /* synthetic */ TextDragObserver $textDragObserver;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectionGesturesKt$selectionGesturePointerInputBtf2$2(ClicksCounter clicksCounter, MouseSelectionObserver mouseSelectionObserver, TextDragObserver textDragObserver, Continuation<? super SelectionGesturesKt$selectionGesturePointerInputBtf2$2> continuation) {
        super(2, continuation);
        this.$clicksCounter = clicksCounter;
        this.$mouseSelectionObserver = mouseSelectionObserver;
        this.$textDragObserver = textDragObserver;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SelectionGesturesKt$selectionGesturePointerInputBtf2$2 selectionGesturesKt$selectionGesturePointerInputBtf2$2 = new SelectionGesturesKt$selectionGesturePointerInputBtf2$2(this.$clicksCounter, this.$mouseSelectionObserver, this.$textDragObserver, continuation);
        selectionGesturesKt$selectionGesturePointerInputBtf2$2.L$0 = obj;
        return selectionGesturesKt$selectionGesturePointerInputBtf2$2;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((SelectionGesturesKt$selectionGesturePointerInputBtf2$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.compose.ui.input.pointer.AwaitPointerEventScope} */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003d, code lost:
        if (r13 == r0) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0083, code lost:
        if (androidx.compose.foundation.text.selection.SelectionGesturesKt.mouseSelectionBtf2(r1, r12.$mouseSelectionObserver, r12.$clicksCounter, r13, r12) == r0) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009d, code lost:
        if (androidx.compose.foundation.text.selection.SelectionGesturesKt.touchSelectionFirstPress(r1, r12.$textDragObserver, r13, r12) == r0) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ad, code lost:
        if (androidx.compose.foundation.text.selection.SelectionGesturesKt.touchSelectionSubsequentPress(r1, r12.$textDragObserver, r13, r12) == r0) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00af, code lost:
        return r0;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x002a
            if (r1 == r5) goto L_0x0022
            if (r1 == r4) goto L_0x001d
            if (r1 == r3) goto L_0x001d
            if (r1 != r2) goto L_0x0015
            goto L_0x001d
        L_0x0015:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x001d:
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00b0
        L_0x0022:
            java.lang.Object r1 = r12.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0041
        L_0x002a:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            r1 = r13
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            r13 = r12
            kotlin.coroutines.Continuation r13 = (kotlin.coroutines.Continuation) r13
            r12.L$0 = r1
            r12.label = r5
            java.lang.Object r13 = androidx.compose.foundation.text.selection.SelectionGesturesKt.awaitDown(r1, r13)
            if (r13 != r0) goto L_0x0041
            goto L_0x00af
        L_0x0041:
            androidx.compose.ui.input.pointer.PointerEvent r13 = (androidx.compose.ui.input.pointer.PointerEvent) r13
            androidx.compose.foundation.text.selection.ClicksCounter r6 = r12.$clicksCounter
            r6.update(r13)
            boolean r6 = androidx.compose.foundation.text.selection.SelectionGesturesKt.isPrecisePointer(r13)
            r7 = 0
            if (r6 == 0) goto L_0x0086
            int r8 = r13.m5526getButtonsry648PA()
            boolean r8 = androidx.compose.ui.input.pointer.PointerEvent_androidKt.m5559isPrimaryPressedaHzCxE(r8)
            if (r8 == 0) goto L_0x0086
            java.util.List r8 = r13.getChanges()
            int r9 = r8.size()
            r10 = 0
        L_0x0062:
            if (r10 >= r9) goto L_0x0074
            java.lang.Object r11 = r8.get(r10)
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            boolean r11 = r11.isConsumed()
            if (r11 == 0) goto L_0x0071
            goto L_0x0086
        L_0x0071:
            int r10 = r10 + 1
            goto L_0x0062
        L_0x0074:
            androidx.compose.foundation.text.selection.MouseSelectionObserver r2 = r12.$mouseSelectionObserver
            androidx.compose.foundation.text.selection.ClicksCounter r3 = r12.$clicksCounter
            r5 = r12
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r12.L$0 = r7
            r12.label = r4
            java.lang.Object r13 = androidx.compose.foundation.text.selection.SelectionGesturesKt.mouseSelectionBtf2(r1, r2, r3, r13, r5)
            if (r13 != r0) goto L_0x00b0
            goto L_0x00af
        L_0x0086:
            if (r6 != 0) goto L_0x00b0
            androidx.compose.foundation.text.selection.ClicksCounter r4 = r12.$clicksCounter
            int r4 = r4.getClicks()
            if (r4 != r5) goto L_0x00a0
            androidx.compose.foundation.text.TextDragObserver r2 = r12.$textDragObserver
            r4 = r12
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r12.L$0 = r7
            r12.label = r3
            java.lang.Object r13 = androidx.compose.foundation.text.selection.SelectionGesturesKt.touchSelectionFirstPress(r1, r2, r13, r4)
            if (r13 != r0) goto L_0x00b0
            goto L_0x00af
        L_0x00a0:
            androidx.compose.foundation.text.TextDragObserver r3 = r12.$textDragObserver
            r4 = r12
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r12.L$0 = r7
            r12.label = r2
            java.lang.Object r13 = androidx.compose.foundation.text.selection.SelectionGesturesKt.touchSelectionSubsequentPress(r1, r3, r13, r4)
            if (r13 != r0) goto L_0x00b0
        L_0x00af:
            return r0
        L_0x00b0:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGesturePointerInputBtf2$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
