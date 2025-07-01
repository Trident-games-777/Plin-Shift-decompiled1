package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Landroidx/datastore/core/WriteScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$writeData$2", f = "DataStoreImpl.kt", i = {0}, l = {352, 353}, m = "invokeSuspend", n = {"$this$writeScope"}, s = {"L$0"})
/* compiled from: DataStoreImpl.kt */
final class DataStoreImpl$writeData$2 extends SuspendLambda implements Function2<WriteScope<T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ T $newData;
    final /* synthetic */ Ref.IntRef $newVersion;
    final /* synthetic */ boolean $updateCache;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreImpl$writeData$2(Ref.IntRef intRef, DataStoreImpl<T> dataStoreImpl, T t, boolean z, Continuation<? super DataStoreImpl$writeData$2> continuation) {
        super(2, continuation);
        this.$newVersion = intRef;
        this.this$0 = dataStoreImpl;
        this.$newData = t;
        this.$updateCache = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DataStoreImpl$writeData$2 dataStoreImpl$writeData$2 = new DataStoreImpl$writeData$2(this.$newVersion, this.this$0, this.$newData, this.$updateCache, continuation);
        dataStoreImpl$writeData$2.L$0 = obj;
        return dataStoreImpl$writeData$2;
    }

    public final Object invoke(WriteScope<T> writeScope, Continuation<? super Unit> continuation) {
        return ((DataStoreImpl$writeData$2) create(writeScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0060, code lost:
        if (r3.writeData(r7.$newData, r7) == r0) goto L_0x0062;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0026
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0063
        L_0x0012:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x001a:
            java.lang.Object r1 = r7.L$1
            kotlin.jvm.internal.Ref$IntRef r1 = (kotlin.jvm.internal.Ref.IntRef) r1
            java.lang.Object r3 = r7.L$0
            androidx.datastore.core.WriteScope r3 = (androidx.datastore.core.WriteScope) r3
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0048
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.L$0
            androidx.datastore.core.WriteScope r8 = (androidx.datastore.core.WriteScope) r8
            kotlin.jvm.internal.Ref$IntRef r1 = r7.$newVersion
            androidx.datastore.core.DataStoreImpl<T> r4 = r7.this$0
            androidx.datastore.core.InterProcessCoordinator r4 = r4.getCoordinator()
            r5 = r7
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r7.L$0 = r8
            r7.L$1 = r1
            r7.label = r3
            java.lang.Object r3 = r4.incrementAndGetVersion(r5)
            if (r3 != r0) goto L_0x0045
            goto L_0x0062
        L_0x0045:
            r6 = r3
            r3 = r8
            r8 = r6
        L_0x0048:
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            r1.element = r8
            T r8 = r7.$newData
            r1 = r7
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r4 = 0
            r7.L$0 = r4
            r7.L$1 = r4
            r7.label = r2
            java.lang.Object r8 = r3.writeData(r8, r1)
            if (r8 != r0) goto L_0x0063
        L_0x0062:
            return r0
        L_0x0063:
            boolean r8 = r7.$updateCache
            if (r8 == 0) goto L_0x0085
            androidx.datastore.core.DataStoreImpl<T> r8 = r7.this$0
            androidx.datastore.core.DataStoreInMemoryCache r8 = r8.inMemoryCache
            androidx.datastore.core.Data r0 = new androidx.datastore.core.Data
            T r1 = r7.$newData
            if (r1 == 0) goto L_0x0078
            int r2 = r1.hashCode()
            goto L_0x0079
        L_0x0078:
            r2 = 0
        L_0x0079:
            kotlin.jvm.internal.Ref$IntRef r3 = r7.$newVersion
            int r3 = r3.element
            r0.<init>(r1, r2, r3)
            androidx.datastore.core.State r0 = (androidx.datastore.core.State) r0
            r8.tryUpdate(r0)
        L_0x0085:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$writeData$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
