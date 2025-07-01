package coil3.disk;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.disk.DiskLruCache$launchCleanup$1", f = "DiskLruCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DiskLruCache.kt */
final class DiskLruCache$launchCleanup$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DiskLruCache this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiskLruCache$launchCleanup$1(DiskLruCache diskLruCache, Continuation<? super DiskLruCache$launchCleanup$1> continuation) {
        super(2, continuation);
        this.this$0 = diskLruCache;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DiskLruCache$launchCleanup$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DiskLruCache$launchCleanup$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:9|10|11|12|13|14|15|(1:17)|20|21|22|23) */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:18|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r0.mostRecentRebuildFailed = true;
        r0.journalWriter = okio.Okio.buffer(okio.Okio.blackhole());
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0025 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0032 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:12:0x0025=Splitter:B:12:0x0025, B:24:0x0046=Splitter:B:24:0x0046, B:14:0x0028=Splitter:B:14:0x0028} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r4) {
        /*
            r3 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r3.label
            if (r0 != 0) goto L_0x004d
            kotlin.ResultKt.throwOnFailure(r4)
            coil3.disk.DiskLruCache r4 = r3.this$0
            java.lang.Object r4 = r4.lock
            coil3.disk.DiskLruCache r0 = r3.this$0
            monitor-enter(r4)
            boolean r1 = r0.initialized     // Catch:{ all -> 0x004a }
            if (r1 == 0) goto L_0x0046
            boolean r1 = r0.closed     // Catch:{ all -> 0x004a }
            if (r1 == 0) goto L_0x0020
            goto L_0x0046
        L_0x0020:
            r1 = 1
            r0.trimToSize()     // Catch:{ IOException -> 0x0025 }
            goto L_0x0028
        L_0x0025:
            r0.mostRecentTrimFailed = r1     // Catch:{ all -> 0x004a }
        L_0x0028:
            boolean r2 = r0.journalRewriteRequired()     // Catch:{ IOException -> 0x0032 }
            if (r2 == 0) goto L_0x0040
            r0.writeJournal()     // Catch:{ IOException -> 0x0032 }
            goto L_0x0040
        L_0x0032:
            r0.mostRecentRebuildFailed = r1     // Catch:{ all -> 0x004a }
            okio.Sink r1 = okio.Okio.blackhole()     // Catch:{ all -> 0x004a }
            okio.BufferedSink r1 = okio.Okio.buffer((okio.Sink) r1)     // Catch:{ all -> 0x004a }
            r0.journalWriter = r1     // Catch:{ all -> 0x004a }
        L_0x0040:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004a }
            monitor-exit(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L_0x0046:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004a }
            monitor-exit(r4)
            return r0
        L_0x004a:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        L_0x004d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.disk.DiskLruCache$launchCleanup$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
