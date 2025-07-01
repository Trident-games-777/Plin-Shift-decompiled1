package androidx.compose.foundation.text.handwriting;

import androidx.compose.foundation.gestures.ForEachGestureKt;
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
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.handwriting.StylusHandwritingNode$suspendingPointerInputModifierNode$1", f = "StylusHandwriting.kt", i = {}, l = {132}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: StylusHandwriting.kt */
final class StylusHandwritingNode$suspendingPointerInputModifierNode$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StylusHandwritingNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StylusHandwritingNode$suspendingPointerInputModifierNode$1(StylusHandwritingNode stylusHandwritingNode, Continuation<? super StylusHandwritingNode$suspendingPointerInputModifierNode$1> continuation) {
        super(2, continuation);
        this.this$0 = stylusHandwritingNode;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StylusHandwritingNode$suspendingPointerInputModifierNode$1 stylusHandwritingNode$suspendingPointerInputModifierNode$1 = new StylusHandwritingNode$suspendingPointerInputModifierNode$1(this.this$0, continuation);
        stylusHandwritingNode$suspendingPointerInputModifierNode$1.L$0 = obj;
        return stylusHandwritingNode$suspendingPointerInputModifierNode$1;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((StylusHandwritingNode$suspendingPointerInputModifierNode$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.handwriting.StylusHandwritingNode$suspendingPointerInputModifierNode$1$1", f = "StylusHandwriting.kt", i = {0, 1, 1, 1, 2, 2}, l = {134, 158, 186}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "firstDown", "pass", "$this$awaitEachGesture", "firstDown"}, s = {"L$0", "L$0", "L$1", "L$2", "L$0", "L$1"})
    /* renamed from: androidx.compose.foundation.text.handwriting.StylusHandwritingNode$suspendingPointerInputModifierNode$1$1  reason: invalid class name */
    /* compiled from: StylusHandwriting.kt */
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(stylusHandwritingNode, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x005d, code lost:
            if (r8 == r1) goto L_0x0197;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00f0, code lost:
            if (r10 != r1) goto L_0x00f4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0195, code lost:
            if (r5 != r1) goto L_0x0198;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x0197, code lost:
            return r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                r16 = this;
                r0 = r16
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 3
                r4 = 2
                r7 = 1
                if (r2 == 0) goto L_0x0049
                if (r2 == r7) goto L_0x003f
                if (r2 == r4) goto L_0x002b
                if (r2 != r3) goto L_0x0023
                java.lang.Object r2 = r0.L$1
                androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2
                java.lang.Object r4 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
                kotlin.ResultKt.throwOnFailure(r17)
                r5 = r17
                r7 = 0
                goto L_0x0198
            L_0x0023:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x002b:
                java.lang.Object r2 = r0.L$2
                androidx.compose.ui.input.pointer.PointerEventPass r2 = (androidx.compose.ui.input.pointer.PointerEventPass) r2
                java.lang.Object r7 = r0.L$1
                androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
                java.lang.Object r8 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
                kotlin.ResultKt.throwOnFailure(r17)
                r10 = r17
                r9 = 0
                goto L_0x00f4
            L_0x003f:
                java.lang.Object r2 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
                kotlin.ResultKt.throwOnFailure(r17)
                r8 = r17
                goto L_0x0061
            L_0x0049:
                kotlin.ResultKt.throwOnFailure(r17)
                java.lang.Object r2 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
                androidx.compose.ui.input.pointer.PointerEventPass r8 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                r9 = r0
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                r0.L$0 = r2
                r0.label = r7
                java.lang.Object r8 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(r2, r7, r8, r9)
                if (r8 != r1) goto L_0x0061
                goto L_0x0197
            L_0x0061:
                androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
                int r9 = r8.m5590getTypeT8wyACA()
                androidx.compose.ui.input.pointer.PointerType$Companion r10 = androidx.compose.ui.input.pointer.PointerType.Companion
                int r10 = r10.m5668getStylusT8wyACA()
                boolean r9 = androidx.compose.ui.input.pointer.PointerType.m5662equalsimpl0(r9, r10)
                if (r9 != 0) goto L_0x0087
                int r9 = r8.m5590getTypeT8wyACA()
                androidx.compose.ui.input.pointer.PointerType$Companion r10 = androidx.compose.ui.input.pointer.PointerType.Companion
                int r10 = r10.m5666getEraserT8wyACA()
                boolean r9 = androidx.compose.ui.input.pointer.PointerType.m5662equalsimpl0(r9, r10)
                if (r9 == 0) goto L_0x0084
                goto L_0x0087
            L_0x0084:
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
            L_0x0087:
                long r9 = r8.m5587getPositionF1C5BW0()
                float r9 = androidx.compose.ui.geometry.Offset.m3987getXimpl(r9)
                r10 = 0
                int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
                if (r9 < 0) goto L_0x00cb
                long r11 = r8.m5587getPositionF1C5BW0()
                float r9 = androidx.compose.ui.geometry.Offset.m3987getXimpl(r11)
                long r11 = r2.m5497getSizeYbymL2g()
                int r11 = androidx.compose.ui.unit.IntSize.m7283getWidthimpl(r11)
                float r11 = (float) r11
                int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
                if (r9 >= 0) goto L_0x00cb
                long r11 = r8.m5587getPositionF1C5BW0()
                float r9 = androidx.compose.ui.geometry.Offset.m3988getYimpl(r11)
                int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
                if (r9 < 0) goto L_0x00cb
                long r9 = r8.m5587getPositionF1C5BW0()
                float r9 = androidx.compose.ui.geometry.Offset.m3988getYimpl(r9)
                long r10 = r2.m5497getSizeYbymL2g()
                int r10 = androidx.compose.ui.unit.IntSize.m7282getHeightimpl(r10)
                float r10 = (float) r10
                int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
                if (r9 >= 0) goto L_0x00cb
                goto L_0x00cc
            L_0x00cb:
                r7 = 0
            L_0x00cc:
                androidx.compose.foundation.text.handwriting.StylusHandwritingNode r9 = r3
                boolean r9 = r9.focused
                if (r9 != 0) goto L_0x00da
                if (r7 == 0) goto L_0x00d7
                goto L_0x00da
            L_0x00d7:
                androidx.compose.ui.input.pointer.PointerEventPass r7 = androidx.compose.ui.input.pointer.PointerEventPass.Main
                goto L_0x00dc
            L_0x00da:
                androidx.compose.ui.input.pointer.PointerEventPass r7 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
            L_0x00dc:
                r9 = r8
                r8 = r2
                r2 = r7
                r7 = r9
                r9 = 0
            L_0x00e1:
                r10 = r0
                kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
                r0.L$0 = r8
                r0.L$1 = r7
                r0.L$2 = r2
                r0.label = r4
                java.lang.Object r10 = r8.awaitPointerEvent(r2, r10)
                if (r10 != r1) goto L_0x00f4
                goto L_0x0197
            L_0x00f4:
                androidx.compose.ui.input.pointer.PointerEvent r10 = (androidx.compose.ui.input.pointer.PointerEvent) r10
                java.util.List r10 = r10.getChanges()
                int r11 = r10.size()
                r12 = 0
            L_0x00ff:
                if (r12 >= r11) goto L_0x012d
                java.lang.Object r13 = r10.get(r12)
                r14 = r13
                androidx.compose.ui.input.pointer.PointerInputChange r14 = (androidx.compose.ui.input.pointer.PointerInputChange) r14
                boolean r15 = r14.isConsumed()
                if (r15 != 0) goto L_0x0125
                long r4 = r14.m5585getIdJ3iCeTQ()
                r17 = r7
                long r6 = r17.m5585getIdJ3iCeTQ()
                boolean r4 = androidx.compose.ui.input.pointer.PointerId.m5569equalsimpl0(r4, r6)
                if (r4 == 0) goto L_0x0127
                boolean r4 = r14.getPressed()
                if (r4 == 0) goto L_0x0127
                goto L_0x0130
            L_0x0125:
                r17 = r7
            L_0x0127:
                int r12 = r12 + 1
                r7 = r17
                r4 = 2
                goto L_0x00ff
            L_0x012d:
                r17 = r7
                r13 = 0
            L_0x0130:
                androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
                if (r13 != 0) goto L_0x0135
                goto L_0x0168
            L_0x0135:
                long r4 = r13.getUptimeMillis()
                long r6 = r17.getUptimeMillis()
                long r4 = r4 - r6
                androidx.compose.ui.platform.ViewConfiguration r6 = r8.getViewConfiguration()
                long r6 = r6.getLongPressTimeoutMillis()
                int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r4 < 0) goto L_0x014b
                goto L_0x0168
            L_0x014b:
                long r4 = r13.m5587getPositionF1C5BW0()
                long r6 = r17.m5587getPositionF1C5BW0()
                long r4 = androidx.compose.ui.geometry.Offset.m3991minusMKHz9U(r4, r6)
                float r4 = androidx.compose.ui.geometry.Offset.m3985getDistanceimpl(r4)
                androidx.compose.ui.platform.ViewConfiguration r5 = r8.getViewConfiguration()
                float r5 = r5.getHandwritingSlop()
                int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r4 <= 0) goto L_0x01d9
                r9 = r13
            L_0x0168:
                if (r9 == 0) goto L_0x01d6
                androidx.compose.foundation.text.handwriting.StylusHandwritingNode r2 = r3
                kotlin.jvm.functions.Function0 r2 = r2.getOnHandwritingSlopExceeded()
                java.lang.Object r2 = r2.invoke()
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                boolean r2 = r2.booleanValue()
                if (r2 != 0) goto L_0x017d
                goto L_0x01d6
            L_0x017d:
                r9.consume()
                r2 = r17
                r4 = r8
            L_0x0183:
                androidx.compose.ui.input.pointer.PointerEventPass r5 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                r6 = r0
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r0.L$0 = r4
                r0.L$1 = r2
                r7 = 0
                r0.L$2 = r7
                r0.label = r3
                java.lang.Object r5 = r4.awaitPointerEvent(r5, r6)
                if (r5 != r1) goto L_0x0198
            L_0x0197:
                return r1
            L_0x0198:
                androidx.compose.ui.input.pointer.PointerEvent r5 = (androidx.compose.ui.input.pointer.PointerEvent) r5
                java.util.List r5 = r5.getChanges()
                int r6 = r5.size()
                r8 = 0
            L_0x01a3:
                if (r8 >= r6) goto L_0x01ca
                java.lang.Object r9 = r5.get(r8)
                r10 = r9
                androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
                boolean r11 = r10.isConsumed()
                if (r11 != 0) goto L_0x01c7
                long r11 = r10.m5585getIdJ3iCeTQ()
                long r13 = r2.m5585getIdJ3iCeTQ()
                boolean r11 = androidx.compose.ui.input.pointer.PointerId.m5569equalsimpl0(r11, r13)
                if (r11 == 0) goto L_0x01c7
                boolean r10 = r10.getPressed()
                if (r10 == 0) goto L_0x01c7
                goto L_0x01cb
            L_0x01c7:
                int r8 = r8 + 1
                goto L_0x01a3
            L_0x01ca:
                r9 = r7
            L_0x01cb:
                androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
                if (r9 != 0) goto L_0x01d2
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
            L_0x01d2:
                r9.consume()
                goto L_0x0183
            L_0x01d6:
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
            L_0x01d9:
                r7 = r17
                r4 = 2
                goto L_0x00e1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.handwriting.StylusHandwritingNode$suspendingPointerInputModifierNode$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final StylusHandwritingNode stylusHandwritingNode = this.this$0;
            this.label = 1;
            if (ForEachGestureKt.awaitEachGesture((PointerInputScope) this.L$0, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
