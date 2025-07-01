package com.plinkofortune.cash.winspin;

import com.plinkofortune.cash.winspin.rounds.RoundModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: SafeCollector.common.kt */
public final class GlobalRepo$getRounds$$inlined$map$1 implements Flow<List<? extends RoundModel>> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;
    final /* synthetic */ GlobalRepo this$0;

    public GlobalRepo$getRounds$$inlined$map$1(Flow flow, GlobalRepo globalRepo) {
        this.$this_unsafeTransform$inlined = flow;
        this.this$0 = globalRepo;
    }

    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        Flow flow = this.$this_unsafeTransform$inlined;
        final GlobalRepo globalRepo = this.this$0;
        Object collect = flow.collect(new FlowCollector() {
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x006e, code lost:
                if (r9 == null) goto L_0x0070;
             */
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0043  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r9, kotlin.coroutines.Continuation r10) {
                /*
                    r8 = this;
                    boolean r0 = r10 instanceof com.plinkofortune.cash.winspin.GlobalRepo$getRounds$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0014
                    r0 = r10
                    com.plinkofortune.cash.winspin.GlobalRepo$getRounds$$inlined$map$1$2$1 r0 = (com.plinkofortune.cash.winspin.GlobalRepo$getRounds$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L_0x0014
                    int r10 = r0.label
                    int r10 = r10 - r2
                    r0.label = r10
                    goto L_0x0019
                L_0x0014:
                    com.plinkofortune.cash.winspin.GlobalRepo$getRounds$$inlined$map$1$2$1 r0 = new com.plinkofortune.cash.winspin.GlobalRepo$getRounds$$inlined$map$1$2$1
                    r0.<init>(r8, r10)
                L_0x0019:
                    java.lang.Object r10 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0043
                    if (r2 != r3) goto L_0x002b
                    kotlin.ResultKt.throwOnFailure(r10)
                    goto L_0x0097
                L_0x002b:
                    java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                    r10 = 47
                    byte[] r10 = new byte[r10]
                    r10 = {66, 99, -18, -95, -88, 64, 36, -89, 6, 112, -25, -66, -3, 89, 46, -96, 1, 96, -25, -85, -25, 70, 46, -89, 6, 107, -20, -69, -25, 95, 46, -96, 1, 117, -21, -71, -32, 20, 40, -24, 83, 109, -9, -71, -31, 90, 46} // fill-array
                    r0 = 8
                    byte[] r0 = new byte[r0]
                    r0 = {33, 2, -126, -51, -120, 52, 75, -121} // fill-array
                    java.lang.String r10 = com.plinkofortune.cash.winspin.StringFog.decrypt(r10, r0)
                    r9.<init>(r10)
                    throw r9
                L_0x0043:
                    kotlin.ResultKt.throwOnFailure(r10)
                    kotlinx.coroutines.flow.FlowCollector r10 = r4
                    r2 = r0
                    kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                    androidx.datastore.preferences.core.Preferences r9 = (androidx.datastore.preferences.core.Preferences) r9
                    com.plinkofortune.cash.winspin.GlobalRepo r2 = r2
                    androidx.datastore.preferences.core.Preferences$Key r2 = r2.roundKey
                    java.lang.Object r9 = r9.get(r2)
                    java.lang.String r9 = (java.lang.String) r9
                    if (r9 == 0) goto L_0x0070
                    com.plinkofortune.cash.winspin.GlobalRepo$getRounds$1$1$token$1 r2 = new com.plinkofortune.cash.winspin.GlobalRepo$getRounds$1$1$token$1
                    r2.<init>()
                    com.plinkofortune.cash.winspin.GlobalRepo r4 = r2
                    com.google.gson.Gson r4 = r4.gson
                    com.google.gson.reflect.TypeToken r2 = (com.google.gson.reflect.TypeToken) r2
                    java.lang.Object r9 = r4.fromJson((java.lang.String) r9, r2)
                    java.util.List r9 = (java.util.List) r9
                    if (r9 != 0) goto L_0x008e
                L_0x0070:
                    java.util.ArrayList r9 = new java.util.ArrayList
                    r2 = 40
                    r9.<init>(r2)
                    r4 = 0
                    r5 = r4
                L_0x0079:
                    if (r5 >= r2) goto L_0x008c
                    com.plinkofortune.cash.winspin.rounds.RoundModel r6 = new com.plinkofortune.cash.winspin.rounds.RoundModel
                    int r7 = r5 + 1
                    if (r5 != 0) goto L_0x0083
                    r5 = r3
                    goto L_0x0084
                L_0x0083:
                    r5 = r4
                L_0x0084:
                    r6.<init>(r7, r4, r5)
                    r9.add(r6)
                    r5 = r7
                    goto L_0x0079
                L_0x008c:
                    java.util.List r9 = (java.util.List) r9
                L_0x008e:
                    r0.label = r3
                    java.lang.Object r9 = r10.emit(r9, r0)
                    if (r9 != r1) goto L_0x0097
                    return r1
                L_0x0097:
                    kotlin.Unit r9 = kotlin.Unit.INSTANCE
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: com.plinkofortune.cash.winspin.GlobalRepo$getRounds$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
