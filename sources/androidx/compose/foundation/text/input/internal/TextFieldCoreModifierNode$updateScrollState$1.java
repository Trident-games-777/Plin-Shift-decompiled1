package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$updateScrollState$1", f = "TextFieldCoreModifier.kt", i = {}, l = {448, 451}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TextFieldCoreModifier.kt */
final class TextFieldCoreModifierNode$updateScrollState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ float $offsetDifference;
    final /* synthetic */ Rect $rawCursorRect;
    int label;
    final /* synthetic */ TextFieldCoreModifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldCoreModifierNode$updateScrollState$1(TextFieldCoreModifierNode textFieldCoreModifierNode, float f, Rect rect, Continuation<? super TextFieldCoreModifierNode$updateScrollState$1> continuation) {
        super(2, continuation);
        this.this$0 = textFieldCoreModifierNode;
        this.$offsetDifference = f;
        this.$rawCursorRect = rect;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TextFieldCoreModifierNode$updateScrollState$1(this.this$0, this.$offsetDifference, this.$rawCursorRect, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TextFieldCoreModifierNode$updateScrollState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0050, code lost:
        if (androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode.access$getTextLayoutState$p(r5.this$0).getBringIntoViewRequester().bringIntoView(r5.$rawCursorRect, r5) == r0) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0052, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0038, code lost:
        if (androidx.compose.foundation.gestures.ScrollExtensionsKt.scrollBy(androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode.access$getScrollState$p(r5.this$0), androidx.compose.foundation.text.input.internal.TextFieldCoreModifierKt.roundToNext(r5.$offsetDifference), r5) == r0) goto L_0x0052;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0053
        L_0x0012:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x003b
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode r6 = r5.this$0
            androidx.compose.foundation.ScrollState r6 = r6.scrollState
            androidx.compose.foundation.gestures.ScrollableState r6 = (androidx.compose.foundation.gestures.ScrollableState) r6
            float r1 = r5.$offsetDifference
            float r1 = androidx.compose.foundation.text.input.internal.TextFieldCoreModifierKt.roundToNext(r1)
            r4 = r5
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r5.label = r3
            java.lang.Object r6 = androidx.compose.foundation.gestures.ScrollExtensionsKt.scrollBy(r6, r1, r4)
            if (r6 != r0) goto L_0x003b
            goto L_0x0052
        L_0x003b:
            androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode r6 = r5.this$0
            androidx.compose.foundation.text.input.internal.TextLayoutState r6 = r6.textLayoutState
            androidx.compose.foundation.relocation.BringIntoViewRequester r6 = r6.getBringIntoViewRequester()
            androidx.compose.ui.geometry.Rect r1 = r5.$rawCursorRect
            r3 = r5
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r5.label = r2
            java.lang.Object r6 = r6.bringIntoView(r1, r3)
            if (r6 != r0) goto L_0x0053
        L_0x0052:
            return r0
        L_0x0053:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$updateScrollState$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
