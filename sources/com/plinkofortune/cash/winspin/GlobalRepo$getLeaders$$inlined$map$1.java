package com.plinkofortune.cash.winspin;

import com.plinkofortune.cash.winspin.leader.LeaderModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: SafeCollector.common.kt */
public final class GlobalRepo$getLeaders$$inlined$map$1 implements Flow<List<? extends LeaderModel>> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;
    final /* synthetic */ GlobalRepo this$0;

    public GlobalRepo$getLeaders$$inlined$map$1(Flow flow, GlobalRepo globalRepo) {
        this.$this_unsafeTransform$inlined = flow;
        this.this$0 = globalRepo;
    }

    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        Flow flow = this.$this_unsafeTransform$inlined;
        final GlobalRepo globalRepo = this.this$0;
        Object collect = flow.collect(new FlowCollector() {
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x006d, code lost:
                if (r6 == null) goto L_0x006f;
             */
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0042  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof com.plinkofortune.cash.winspin.GlobalRepo$getLeaders$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0014
                    r0 = r7
                    com.plinkofortune.cash.winspin.GlobalRepo$getLeaders$$inlined$map$1$2$1 r0 = (com.plinkofortune.cash.winspin.GlobalRepo$getLeaders$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L_0x0014
                    int r7 = r0.label
                    int r7 = r7 - r2
                    r0.label = r7
                    goto L_0x0019
                L_0x0014:
                    com.plinkofortune.cash.winspin.GlobalRepo$getLeaders$$inlined$map$1$2$1 r0 = new com.plinkofortune.cash.winspin.GlobalRepo$getLeaders$$inlined$map$1$2$1
                    r0.<init>(r5, r7)
                L_0x0019:
                    java.lang.Object r7 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0042
                    if (r2 != r3) goto L_0x002a
                    kotlin.ResultKt.throwOnFailure(r7)
                    goto L_0x007e
                L_0x002a:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    r7 = 47
                    byte[] r7 = new byte[r7]
                    r7 = {28, 90, -72, -16, 99, 85, -75, 112, 88, 73, -79, -17, 54, 76, -65, 119, 95, 89, -79, -6, 44, 83, -65, 112, 88, 82, -70, -22, 44, 74, -65, 119, 95, 76, -67, -24, 43, 1, -71, 63, 13, 84, -95, -24, 42, 79, -65} // fill-array
                    r0 = 8
                    byte[] r0 = new byte[r0]
                    r0 = {127, 59, -44, -100, 67, 33, -38, 80} // fill-array
                    java.lang.String r7 = com.plinkofortune.cash.winspin.StringFog.decrypt(r7, r0)
                    r6.<init>(r7)
                    throw r6
                L_0x0042:
                    kotlin.ResultKt.throwOnFailure(r7)
                    kotlinx.coroutines.flow.FlowCollector r7 = r4
                    r2 = r0
                    kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                    androidx.datastore.preferences.core.Preferences r6 = (androidx.datastore.preferences.core.Preferences) r6
                    com.plinkofortune.cash.winspin.GlobalRepo r2 = r2
                    androidx.datastore.preferences.core.Preferences$Key r2 = r2.leaderKey
                    java.lang.Object r6 = r6.get(r2)
                    java.lang.String r6 = (java.lang.String) r6
                    if (r6 == 0) goto L_0x006f
                    com.plinkofortune.cash.winspin.GlobalRepo$getLeaders$1$1$token$1 r2 = new com.plinkofortune.cash.winspin.GlobalRepo$getLeaders$1$1$token$1
                    r2.<init>()
                    com.plinkofortune.cash.winspin.GlobalRepo r4 = r2
                    com.google.gson.Gson r4 = r4.gson
                    com.google.gson.reflect.TypeToken r2 = (com.google.gson.reflect.TypeToken) r2
                    java.lang.Object r6 = r4.fromJson((java.lang.String) r6, r2)
                    java.util.List r6 = (java.util.List) r6
                    if (r6 != 0) goto L_0x0075
                L_0x006f:
                    com.plinkofortune.cash.winspin.GlobalRepo r6 = r2
                    java.util.List r6 = r6.generateInitialLeaders()
                L_0x0075:
                    r0.label = r3
                    java.lang.Object r6 = r7.emit(r6, r0)
                    if (r6 != r1) goto L_0x007e
                    return r1
                L_0x007e:
                    kotlin.Unit r6 = kotlin.Unit.INSTANCE
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: com.plinkofortune.cash.winspin.GlobalRepo$getLeaders$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
