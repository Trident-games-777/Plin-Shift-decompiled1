package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.RecomposerKt$withRunningRecomposer$2", f = "Recomposer.kt", i = {0}, l = {76, 78}, m = "invokeSuspend", n = {"recomposer"}, s = {"L$0"})
/* compiled from: Recomposer.kt */
final class RecomposerKt$withRunningRecomposer$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
    final /* synthetic */ Function3<CoroutineScope, Recomposer, Continuation<? super R>, Object> $block;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RecomposerKt$withRunningRecomposer$2(Function3<? super CoroutineScope, ? super Recomposer, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super RecomposerKt$withRunningRecomposer$2> continuation) {
        super(2, continuation);
        this.$block = function3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RecomposerKt$withRunningRecomposer$2 recomposerKt$withRunningRecomposer$2 = new RecomposerKt$withRunningRecomposer$2(this.$block, continuation);
        recomposerKt$withRunningRecomposer$2.L$0 = obj;
        return recomposerKt$withRunningRecomposer$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
        return ((RecomposerKt$withRunningRecomposer$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004e, code lost:
        if (r11 == r0) goto L_0x005e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0024
            if (r1 == r3) goto L_0x001c
            if (r1 != r2) goto L_0x0014
            java.lang.Object r0 = r10.L$0
            kotlin.ResultKt.throwOnFailure(r11)
            return r0
        L_0x0014:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x001c:
            java.lang.Object r1 = r10.L$0
            androidx.compose.runtime.Recomposer r1 = (androidx.compose.runtime.Recomposer) r1
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0051
        L_0x0024:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.Object r11 = r10.L$0
            r4 = r11
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            androidx.compose.runtime.Recomposer r1 = new androidx.compose.runtime.Recomposer
            kotlin.coroutines.CoroutineContext r11 = r4.getCoroutineContext()
            r1.<init>(r11)
            androidx.compose.runtime.RecomposerKt$withRunningRecomposer$2$1 r11 = new androidx.compose.runtime.RecomposerKt$withRunningRecomposer$2$1
            r5 = 0
            r11.<init>(r1, r5)
            r7 = r11
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r8 = 3
            r9 = 0
            r6 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function3<kotlinx.coroutines.CoroutineScope, androidx.compose.runtime.Recomposer, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r11 = r10.$block
            r10.L$0 = r1
            r10.label = r3
            java.lang.Object r11 = r11.invoke(r4, r1, r10)
            if (r11 != r0) goto L_0x0051
            goto L_0x005e
        L_0x0051:
            r1.close()
            r10.L$0 = r11
            r10.label = r2
            java.lang.Object r1 = r1.join(r10)
            if (r1 != r0) goto L_0x005f
        L_0x005e:
            return r0
        L_0x005f:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.RecomposerKt$withRunningRecomposer$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
