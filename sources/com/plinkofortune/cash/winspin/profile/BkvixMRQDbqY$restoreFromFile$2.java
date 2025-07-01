package com.plinkofortune.cash.winspin.profile;

import android.content.SharedPreferences;
import com.google.common.base.Ascii;
import com.plinkofortune.cash.winspin.StringFog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import okio.Utf8;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.plinkofortune.cash.winspin.profile.BkvixMRQDbqY$restoreFromFile$2", f = "BkvixMRQDbqY.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BkvixMRQDbqY.kt */
final class BkvixMRQDbqY$restoreFromFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $dialog;
    final /* synthetic */ KFunction<Unit> $function;
    final /* synthetic */ Function0<Unit> $ifDoNotRestoreState;
    final /* synthetic */ int $nOw;
    final /* synthetic */ File $scroll;
    final /* synthetic */ File $state;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BkvixMRQDbqY this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BkvixMRQDbqY$restoreFromFile$2(int i, BkvixMRQDbqY bkvixMRQDbqY, Function0<Unit> function0, File file, File file2, KFunction<Unit> kFunction, File file3, Continuation<? super BkvixMRQDbqY$restoreFromFile$2> continuation) {
        super(2, continuation);
        this.$nOw = i;
        this.this$0 = bkvixMRQDbqY;
        this.$ifDoNotRestoreState = function0;
        this.$state = file;
        this.$dialog = file2;
        this.$function = kFunction;
        this.$scroll = file3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BkvixMRQDbqY$restoreFromFile$2 bkvixMRQDbqY$restoreFromFile$2 = new BkvixMRQDbqY$restoreFromFile$2(this.$nOw, this.this$0, this.$ifDoNotRestoreState, this.$state, this.$dialog, this.$function, this.$scroll, continuation);
        bkvixMRQDbqY$restoreFromFile$2.L$0 = obj;
        return bkvixMRQDbqY$restoreFromFile$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BkvixMRQDbqY$restoreFromFile$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Iterator it;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            List mutableListOf = CollectionsKt.mutableListOf(BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new BkvixMRQDbqY$restoreFromFile$2$mutableList$1(this.$ifDoNotRestoreState, (Continuation<? super BkvixMRQDbqY$restoreFromFile$2$mutableList$1>) null), 3, (Object) null));
            int i2 = this.$nOw + 1;
            BkvixMRQDbqY bkvixMRQDbqY = this.this$0;
            File file = this.$state;
            File file2 = this.$dialog;
            KFunction<Unit> kFunction = this.$function;
            File file3 = this.$scroll;
            int i3 = 0;
            while (i3 < i2) {
                File file4 = file2;
                KFunction<Unit> kFunction2 = kFunction;
                File file5 = file3;
                int i4 = i3;
                mutableListOf.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new BkvixMRQDbqY$restoreFromFile$2$1$1(bkvixMRQDbqY, file, i4, file4, kFunction2, file5, (Continuation<? super BkvixMRQDbqY$restoreFromFile$2$1$1>) null), 3, (Object) null));
                i3 = i4 + 1;
                file2 = file4;
                kFunction = kFunction2;
                file3 = file5;
            }
            it = mutableListOf.iterator();
        } else if (i == 1) {
            it = (Iterator) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException(StringFog.decrypt(new byte[]{-39, 94, -76, 17, Ascii.CR, 115, Ascii.CAN, 101, -99, 77, -67, Ascii.SO, 88, 106, Ascii.DC2, 98, -102, 93, -67, Ascii.ESC, 66, 117, Ascii.DC2, 101, -99, 86, -74, Ascii.VT, 66, 108, Ascii.DC2, 98, -102, 72, -79, 9, 69, 39, Ascii.DC4, 42, -56, 80, -83, 9, 68, 105, Ascii.DC2}, new byte[]{-70, Utf8.REPLACEMENT_BYTE, -40, 125, 45, 7, 119, 69}));
        }
        while (it.hasNext()) {
            this.L$0 = it;
            this.label = 1;
            if (((Deferred) it.next()).await(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        SharedPreferences sharedPreferences = this.this$0.activity.getSharedPreferences(StringFog.decrypt(new byte[]{-10, -70, -70, -1, 79, 56}, new byte[]{-127, -23, -50, -98, 59, 93, 67, 7}), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, StringFog.decrypt(new byte[]{-115, 38, 95, -86, 89, 45, -90, 111, -114, 19, 89, -100, 87, 41, -90, 111, -124, 32, 78, -118, Ascii.EM, 98, -6, 36, -61}, new byte[]{-22, 67, 43, -7, 49, 76, -44, 10}));
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt(StringFog.decrypt(new byte[]{Ascii.VT, -56, 19}, new byte[]{101, -121, 100, -69, 83, -110, 81, -8}), -1);
        edit.commit();
        return Unit.INSTANCE;
    }
}
