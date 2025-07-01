package com.plinkofortune.cash.winspin.profile;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"zTpyAYOMXPnR", "", "registry", "Landroidx/activity/result/ActivityResultRegistry;", "(Landroidx/activity/result/ActivityResultRegistry;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: EvUYlHumoDFU.kt */
public final class EvUYlHumoDFUKt {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object zTpyAYOMXPnR(androidx.activity.result.ActivityResultRegistry r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            boolean r0 = r8 instanceof com.plinkofortune.cash.winspin.profile.EvUYlHumoDFUKt$zTpyAYOMXPnR$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.plinkofortune.cash.winspin.profile.EvUYlHumoDFUKt$zTpyAYOMXPnR$1 r0 = (com.plinkofortune.cash.winspin.profile.EvUYlHumoDFUKt$zTpyAYOMXPnR$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.plinkofortune.cash.winspin.profile.EvUYlHumoDFUKt$zTpyAYOMXPnR$1 r0 = new com.plinkofortune.cash.winspin.profile.EvUYlHumoDFUKt$zTpyAYOMXPnR$1
            r0.<init>(r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 8
            r4 = 1
            if (r2 == 0) goto L_0x0047
            if (r2 != r4) goto L_0x0031
            java.lang.Object r7 = r0.L$0
            androidx.activity.result.ActivityResultRegistry r7 = (androidx.activity.result.ActivityResultRegistry) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x00c7
        L_0x0031:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            r8 = 47
            byte[] r8 = new byte[r8]
            r8 = {13, -32, -14, 120, 66, -44, 120, -25, 73, -13, -5, 103, 23, -51, 114, -32, 78, -29, -5, 114, 13, -46, 114, -25, 73, -24, -16, 98, 13, -53, 114, -32, 78, -10, -9, 96, 10, -128, 116, -88, 28, -18, -21, 96, 11, -50, 114} // fill-array
            byte[] r0 = new byte[r3]
            r0 = {110, -127, -98, 20, 98, -96, 23, -57} // fill-array
            java.lang.String r8 = com.plinkofortune.cash.winspin.StringFog.decrypt(r8, r0)
            r7.<init>(r8)
            throw r7
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r7
            r0.label = r4
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
            kotlinx.coroutines.CancellableContinuationImpl r8 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)
            r8.<init>(r2, r4)
            r8.initCancellability()
            r2 = r8
            kotlinx.coroutines.CancellableContinuation r2 = (kotlinx.coroutines.CancellableContinuation) r2
            r4 = 20
            byte[] r4 = new byte[r4]
            r4 = {-37, 34, 109, 68, 86, 29, -20, -113, -52, 53, 113, 88, 64, 29, -15, -80, -57, 12, 121, 72} // fill-array
            byte[] r5 = new byte[r3]
            r5 = {-87, 71, 28, 49, 51, 110, -104, -33} // fill-array
            java.lang.String r4 = com.plinkofortune.cash.winspin.StringFog.decrypt(r4, r5)
            androidx.activity.result.contract.ActivityResultContracts$RequestPermission r5 = new androidx.activity.result.contract.ActivityResultContracts$RequestPermission
            r5.<init>()
            androidx.activity.result.contract.ActivityResultContract r5 = (androidx.activity.result.contract.ActivityResultContract) r5
            com.plinkofortune.cash.winspin.profile.EvUYlHumoDFUKt$zTpyAYOMXPnR$g$1$launcher$1 r6 = new com.plinkofortune.cash.winspin.profile.EvUYlHumoDFUKt$zTpyAYOMXPnR$g$1$launcher$1
            r6.<init>(r2)
            androidx.activity.result.ActivityResultCallback r6 = (androidx.activity.result.ActivityResultCallback) r6
            androidx.activity.result.ActivityResultLauncher r7 = r7.register(r4, r5, r6)
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 33
            if (r4 < r5) goto L_0x009b
            r4 = 37
            byte[] r4 = new byte[r4]
            r4 = {-26, 73, -73, -115, 121, -18, 57, 105, -9, 66, -95, -110, 127, -12, 46, 46, -24, 73, -3, -81, 89, -44, 9, 24, -55, 104, -121, -74, 80, -50, 30, 6, -45, 110, -100, -79, 69} // fill-array
            byte[] r3 = new byte[r3]
            r3 = {-121, 39, -45, -1, 22, -121, 93, 71} // fill-array
            java.lang.String r3 = com.plinkofortune.cash.winspin.StringFog.decrypt(r4, r3)
            r7.launch(r3)
            goto L_0x00ad
        L_0x009b:
            boolean r3 = r2.isActive()
            if (r3 == 0) goto L_0x00ad
            r3 = 0
            java.lang.Boolean r3 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            com.plinkofortune.cash.winspin.profile.EvUYlHumoDFUKt$zTpyAYOMXPnR$g$1$1 r4 = com.plinkofortune.cash.winspin.profile.EvUYlHumoDFUKt$zTpyAYOMXPnR$g$1$1.INSTANCE
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r2.resume(r3, (kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit>) r4)
        L_0x00ad:
            com.plinkofortune.cash.winspin.profile.EvUYlHumoDFUKt$zTpyAYOMXPnR$g$1$2 r3 = new com.plinkofortune.cash.winspin.profile.EvUYlHumoDFUKt$zTpyAYOMXPnR$g$1$2
            r3.<init>(r7)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r2.invokeOnCancellation(r3)
            java.lang.Object r8 = r8.getResult()
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r8 != r7) goto L_0x00c4
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        L_0x00c4:
            if (r8 != r1) goto L_0x00c7
            return r1
        L_0x00c7:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r7 = r8.booleanValue()
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.plinkofortune.cash.winspin.profile.EvUYlHumoDFUKt.zTpyAYOMXPnR(androidx.activity.result.ActivityResultRegistry, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
