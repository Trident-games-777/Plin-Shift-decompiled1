package androidx.compose.foundation;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.AbstractClickableNode$handlePressInteraction$2$1", f = "Clickable.kt", i = {0, 1, 2}, l = {1139, 1141, 1148, 1149, 1158}, m = "invokeSuspend", n = {"delayJob", "success", "release"}, s = {"L$0", "Z$0", "L$0"})
/* compiled from: Clickable.kt */
final class AbstractClickableNode$handlePressInteraction$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ long $offset;
    final /* synthetic */ PressGestureScope $this_handlePressInteraction;
    private /* synthetic */ Object L$0;
    boolean Z$0;
    int label;
    final /* synthetic */ AbstractClickableNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractClickableNode$handlePressInteraction$2$1(PressGestureScope pressGestureScope, long j, MutableInteractionSource mutableInteractionSource, AbstractClickableNode abstractClickableNode, Continuation<? super AbstractClickableNode$handlePressInteraction$2$1> continuation) {
        super(2, continuation);
        this.$this_handlePressInteraction = pressGestureScope;
        this.$offset = j;
        this.$interactionSource = mutableInteractionSource;
        this.this$0 = abstractClickableNode;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AbstractClickableNode$handlePressInteraction$2$1 abstractClickableNode$handlePressInteraction$2$1 = new AbstractClickableNode$handlePressInteraction$2$1(this.$this_handlePressInteraction, this.$offset, this.$interactionSource, this.this$0, continuation);
        abstractClickableNode$handlePressInteraction$2$1.L$0 = obj;
        return abstractClickableNode$handlePressInteraction$2$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AbstractClickableNode$handlePressInteraction$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006d, code lost:
        if (r7 == r1) goto L_0x00e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00be, code lost:
        if (r0.$interactionSource.emit(r2, r0) != r1) goto L_0x00e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00e6, code lost:
        if (r4.emit(r5, r0) == r1) goto L_0x00e8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0090  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            r16 = this;
            r0 = r16
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            r8 = 0
            if (r2 == 0) goto L_0x0041
            if (r2 == r7) goto L_0x0037
            if (r2 == r6) goto L_0x0031
            if (r2 == r5) goto L_0x0028
            if (r2 == r4) goto L_0x0023
            if (r2 != r3) goto L_0x001b
            goto L_0x0023
        L_0x001b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r17)
            goto L_0x00e9
        L_0x0028:
            java.lang.Object r2 = r0.L$0
            androidx.compose.foundation.interaction.PressInteraction$Release r2 = (androidx.compose.foundation.interaction.PressInteraction.Release) r2
            kotlin.ResultKt.throwOnFailure(r17)
            goto L_0x00af
        L_0x0031:
            boolean r2 = r0.Z$0
            kotlin.ResultKt.throwOnFailure(r17)
            goto L_0x008e
        L_0x0037:
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2
            kotlin.ResultKt.throwOnFailure(r17)
            r7 = r17
            goto L_0x0071
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r17)
            java.lang.Object r2 = r0.L$0
            r9 = r2
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
            androidx.compose.foundation.AbstractClickableNode$handlePressInteraction$2$1$delayJob$1 r10 = new androidx.compose.foundation.AbstractClickableNode$handlePressInteraction$2$1$delayJob$1
            androidx.compose.foundation.AbstractClickableNode r11 = r0.this$0
            long r12 = r0.$offset
            androidx.compose.foundation.interaction.MutableInteractionSource r14 = r0.$interactionSource
            r15 = 0
            r10.<init>(r11, r12, r14, r15)
            r12 = r10
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r13 = 3
            r14 = 0
            r10 = 0
            r11 = 0
            kotlinx.coroutines.Job r2 = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r9, r10, r11, r12, r13, r14)
            androidx.compose.foundation.gestures.PressGestureScope r9 = r0.$this_handlePressInteraction
            r10 = r0
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
            r0.L$0 = r2
            r0.label = r7
            java.lang.Object r7 = r9.tryAwaitRelease(r10)
            if (r7 != r1) goto L_0x0071
            goto L_0x00e8
        L_0x0071:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            boolean r9 = r2.isActive()
            if (r9 == 0) goto L_0x00c1
            r3 = r0
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r0.L$0 = r8
            r0.Z$0 = r7
            r0.label = r6
            java.lang.Object r2 = kotlinx.coroutines.JobKt.cancelAndJoin(r2, r3)
            if (r2 != r1) goto L_0x008d
            goto L_0x00e8
        L_0x008d:
            r2 = r7
        L_0x008e:
            if (r2 == 0) goto L_0x00e9
            androidx.compose.foundation.interaction.PressInteraction$Press r2 = new androidx.compose.foundation.interaction.PressInteraction$Press
            long r6 = r0.$offset
            r2.<init>(r6, r8)
            androidx.compose.foundation.interaction.PressInteraction$Release r3 = new androidx.compose.foundation.interaction.PressInteraction$Release
            r3.<init>(r2)
            androidx.compose.foundation.interaction.MutableInteractionSource r6 = r0.$interactionSource
            androidx.compose.foundation.interaction.Interaction r2 = (androidx.compose.foundation.interaction.Interaction) r2
            r7 = r0
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r0.L$0 = r3
            r0.label = r5
            java.lang.Object r2 = r6.emit(r2, r7)
            if (r2 != r1) goto L_0x00ae
            goto L_0x00e8
        L_0x00ae:
            r2 = r3
        L_0x00af:
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = r0.$interactionSource
            androidx.compose.foundation.interaction.Interaction r2 = (androidx.compose.foundation.interaction.Interaction) r2
            r5 = r0
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r2 = r3.emit(r2, r5)
            if (r2 != r1) goto L_0x00e9
            goto L_0x00e8
        L_0x00c1:
            androidx.compose.foundation.AbstractClickableNode r2 = r0.this$0
            androidx.compose.foundation.interaction.PressInteraction$Press r2 = r2.pressInteraction
            if (r2 == 0) goto L_0x00e9
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = r0.$interactionSource
            if (r7 == 0) goto L_0x00d5
            androidx.compose.foundation.interaction.PressInteraction$Release r5 = new androidx.compose.foundation.interaction.PressInteraction$Release
            r5.<init>(r2)
            androidx.compose.foundation.interaction.PressInteraction r5 = (androidx.compose.foundation.interaction.PressInteraction) r5
            goto L_0x00dc
        L_0x00d5:
            androidx.compose.foundation.interaction.PressInteraction$Cancel r5 = new androidx.compose.foundation.interaction.PressInteraction$Cancel
            r5.<init>(r2)
            androidx.compose.foundation.interaction.PressInteraction r5 = (androidx.compose.foundation.interaction.PressInteraction) r5
        L_0x00dc:
            androidx.compose.foundation.interaction.Interaction r5 = (androidx.compose.foundation.interaction.Interaction) r5
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r2 = r4.emit(r5, r0)
            if (r2 != r1) goto L_0x00e9
        L_0x00e8:
            return r1
        L_0x00e9:
            androidx.compose.foundation.AbstractClickableNode r1 = r0.this$0
            r1.pressInteraction = r8
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AbstractClickableNode$handlePressInteraction$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
