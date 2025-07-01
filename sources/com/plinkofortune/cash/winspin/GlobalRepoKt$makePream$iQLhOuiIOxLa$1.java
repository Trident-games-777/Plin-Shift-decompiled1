package com.plinkofortune.cash.winspin;

import androidx.fragment.app.FragmentActivity;
import com.google.common.base.Ascii;
import com.plinkofortune.cash.winspin.rounds.ZabgTpCHxFDS;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.plinkofortune.cash.winspin.GlobalRepoKt$makePream$iQLhOuiIOxLa$1", f = "GlobalRepo.kt", i = {}, l = {204}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GlobalRepo.kt */
final class GlobalRepoKt$makePream$iQLhOuiIOxLa$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ FragmentActivity $root;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalRepoKt$makePream$iQLhOuiIOxLa$1(FragmentActivity fragmentActivity, Continuation<? super GlobalRepoKt$makePream$iQLhOuiIOxLa$1> continuation) {
        super(2, continuation);
        this.$root = fragmentActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GlobalRepoKt$makePream$iQLhOuiIOxLa$1(this.$root, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((GlobalRepoKt$makePream$iQLhOuiIOxLa$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = ZabgTpCHxFDS.iQLhOuiIOxLa$default(new ZabgTpCHxFDS(), this.$root, 0, this, 2, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException(StringFog.decrypt(new byte[]{-123, -15, -71, 123, -65, -3, -85, 80, -63, -30, -80, 100, -22, -28, -95, 87, -58, -14, -80, 113, -16, -5, -95, 80, -63, -7, -69, 97, -16, -30, -95, 87, -58, -25, -68, 99, -9, -87, -89, Ascii.US, -108, -1, -96, 99, -10, -25, -95}, new byte[]{-26, -112, -43, Ascii.ETB, -97, -119, -60, 112}));
        }
        return URLEncoder.encode((String) obj, StringFog.decrypt(new byte[]{42, -67, -108, -22, -99}, new byte[]{Byte.MAX_VALUE, -23, -46, -57, -91, -33, -7, 70}));
    }
}
