package com.plinkofortune.cash.winspin.policy;

import com.google.common.base.Ascii;
import com.plinkofortune.cash.winspin.StringFog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/plinkofortune/cash/winspin/policy/MjGvsjnRgWW;", "", "<init>", "()V", "hJAUnFCEodUQ", "", "id", "", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: MjGvsjnRgWW.kt */
public final class MjGvsjnRgWW {
    public static final int $stable = 0;

    public final void hJAUnFCEodUQ(String str) {
        Intrinsics.checkNotNullParameter(str, StringFog.decrypt(new byte[]{-126, -79}, new byte[]{-21, -43, -90, -41, Ascii.RS, -65, 82, 80}));
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new MjGvsjnRgWW$hJAUnFCEodUQ$1(str, (Continuation<? super MjGvsjnRgWW$hJAUnFCEodUQ$1>) null), 3, (Object) null);
    }
}
