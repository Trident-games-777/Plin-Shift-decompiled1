package com.plinkofortune.cash.winspin.profile;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.plinkofortune.cash.winspin.StringFog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.plinkofortune.cash.winspin.profile.BkvixMRQDbqY$restoreFromFile$2$mutableList$1", f = "BkvixMRQDbqY.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BkvixMRQDbqY.kt */
final class BkvixMRQDbqY$restoreFromFile$2$mutableList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $ifDoNotRestoreState;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BkvixMRQDbqY$restoreFromFile$2$mutableList$1(Function0<Unit> function0, Continuation<? super BkvixMRQDbqY$restoreFromFile$2$mutableList$1> continuation) {
        super(2, continuation);
        this.$ifDoNotRestoreState = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BkvixMRQDbqY$restoreFromFile$2$mutableList$1(this.$ifDoNotRestoreState, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BkvixMRQDbqY$restoreFromFile$2$mutableList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$ifDoNotRestoreState.invoke();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException(StringFog.decrypt(new byte[]{-47, 74, -32, Ascii.CR, Ascii.SYN, 5, 74, 47, -107, 89, -23, Ascii.DC2, 67, Ascii.FS, SignedBytes.MAX_POWER_OF_TWO, 40, -110, 73, -23, 7, 89, 3, SignedBytes.MAX_POWER_OF_TWO, 47, -107, 66, -30, Ascii.ETB, 89, Ascii.SUB, SignedBytes.MAX_POWER_OF_TWO, 40, -110, 92, -27, Ascii.NAK, 94, 81, 70, 96, -64, 68, -7, Ascii.NAK, 95, Ascii.US, SignedBytes.MAX_POWER_OF_TWO}, new byte[]{-78, 43, -116, 97, 54, 113, 37, Ascii.SI}));
    }
}
