package com.plinkofortune.cash.winspin;

import com.plinkofortune.cash.winspin.profile.ProfileData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: SafeCollector.common.kt */
public final class GlobalRepo$getProfile$$inlined$map$1 implements Flow<ProfileData> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;
    final /* synthetic */ GlobalRepo this$0;

    public GlobalRepo$getProfile$$inlined$map$1(Flow flow, GlobalRepo globalRepo) {
        this.$this_unsafeTransform$inlined = flow;
        this.this$0 = globalRepo;
    }

    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        Flow flow = this.$this_unsafeTransform$inlined;
        final GlobalRepo globalRepo = this.this$0;
        Object collect = flow.collect(new FlowCollector() {
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x006d, code lost:
                if (r7 == null) goto L_0x006f;
             */
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0042  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof com.plinkofortune.cash.winspin.GlobalRepo$getProfile$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0014
                    r0 = r8
                    com.plinkofortune.cash.winspin.GlobalRepo$getProfile$$inlined$map$1$2$1 r0 = (com.plinkofortune.cash.winspin.GlobalRepo$getProfile$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L_0x0014
                    int r8 = r0.label
                    int r8 = r8 - r2
                    r0.label = r8
                    goto L_0x0019
                L_0x0014:
                    com.plinkofortune.cash.winspin.GlobalRepo$getProfile$$inlined$map$1$2$1 r0 = new com.plinkofortune.cash.winspin.GlobalRepo$getProfile$$inlined$map$1$2$1
                    r0.<init>(r6, r8)
                L_0x0019:
                    java.lang.Object r8 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 1
                    r4 = 8
                    if (r2 == 0) goto L_0x0042
                    if (r2 != r3) goto L_0x002c
                    kotlin.ResultKt.throwOnFailure(r8)
                    goto L_0x008c
                L_0x002c:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    r8 = 47
                    byte[] r8 = new byte[r8]
                    r8 = {35, 33, 1, -81, 68, -69, -65, -5, 103, 50, 8, -80, 17, -94, -75, -4, 96, 34, 8, -91, 11, -67, -75, -5, 103, 41, 3, -75, 11, -92, -75, -4, 96, 55, 4, -73, 12, -17, -77, -76, 50, 47, 24, -73, 13, -95, -75} // fill-array
                    byte[] r0 = new byte[r4]
                    r0 = {64, 64, 109, -61, 100, -49, -48, -37} // fill-array
                    java.lang.String r8 = com.plinkofortune.cash.winspin.StringFog.decrypt(r8, r0)
                    r7.<init>(r8)
                    throw r7
                L_0x0042:
                    kotlin.ResultKt.throwOnFailure(r8)
                    kotlinx.coroutines.flow.FlowCollector r8 = r4
                    r2 = r0
                    kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                    androidx.datastore.preferences.core.Preferences r7 = (androidx.datastore.preferences.core.Preferences) r7
                    com.plinkofortune.cash.winspin.GlobalRepo r2 = r2
                    androidx.datastore.preferences.core.Preferences$Key r2 = r2.profileKey
                    java.lang.Object r7 = r7.get(r2)
                    java.lang.String r7 = (java.lang.String) r7
                    if (r7 == 0) goto L_0x006f
                    com.plinkofortune.cash.winspin.GlobalRepo$getProfile$1$1$token$1 r2 = new com.plinkofortune.cash.winspin.GlobalRepo$getProfile$1$1$token$1
                    r2.<init>()
                    com.plinkofortune.cash.winspin.GlobalRepo r5 = r2
                    com.google.gson.Gson r5 = r5.gson
                    com.google.gson.reflect.TypeToken r2 = (com.google.gson.reflect.TypeToken) r2
                    java.lang.Object r7 = r5.fromJson((java.lang.String) r7, r2)
                    com.plinkofortune.cash.winspin.profile.ProfileData r7 = (com.plinkofortune.cash.winspin.profile.ProfileData) r7
                    if (r7 != 0) goto L_0x0083
                L_0x006f:
                    com.plinkofortune.cash.winspin.profile.ProfileData r7 = new com.plinkofortune.cash.winspin.profile.ProfileData
                    byte[] r2 = new byte[r4]
                    r2 = {95, 119, -96, -47, 46, 93, -26, -103} // fill-array
                    byte[] r4 = new byte[r4]
                    r4 = {49, 30, -61, -70, 64, 60, -117, -4} // fill-array
                    java.lang.String r2 = com.plinkofortune.cash.winspin.StringFog.decrypt(r2, r4)
                    r4 = 0
                    r7.<init>(r4, r2)
                L_0x0083:
                    r0.label = r3
                    java.lang.Object r7 = r8.emit(r7, r0)
                    if (r7 != r1) goto L_0x008c
                    return r1
                L_0x008c:
                    kotlin.Unit r7 = kotlin.Unit.INSTANCE
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: com.plinkofortune.cash.winspin.GlobalRepo$getProfile$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
