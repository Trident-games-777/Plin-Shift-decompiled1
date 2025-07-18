package com.google.firebase.sessions;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.sessions.SessionFirelogPublisherImpl$logSession$1", f = "SessionFirelogPublisher.kt", i = {2}, l = {63, 64, 70}, m = "invokeSuspend", n = {"installationId"}, s = {"L$0"})
/* compiled from: SessionFirelogPublisher.kt */
final class SessionFirelogPublisherImpl$logSession$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SessionDetails $sessionDetails;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ SessionFirelogPublisherImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SessionFirelogPublisherImpl$logSession$1(SessionFirelogPublisherImpl sessionFirelogPublisherImpl, SessionDetails sessionDetails, Continuation<? super SessionFirelogPublisherImpl$logSession$1> continuation) {
        super(2, continuation);
        this.this$0 = sessionFirelogPublisherImpl;
        this.$sessionDetails = sessionDetails;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SessionFirelogPublisherImpl$logSession$1(this.this$0, this.$sessionDetails, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SessionFirelogPublisherImpl$logSession$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0053, code lost:
        if (r10 == r0) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006f, code lost:
        if (r10 == r0) goto L_0x00a0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0045
            if (r1 == r4) goto L_0x0041
            if (r1 == r3) goto L_0x003d
            if (r1 != r2) goto L_0x0035
            java.lang.Object r0 = r9.L$5
            com.google.firebase.sessions.settings.SessionsSettings r0 = (com.google.firebase.sessions.settings.SessionsSettings) r0
            java.lang.Object r1 = r9.L$4
            com.google.firebase.sessions.SessionDetails r1 = (com.google.firebase.sessions.SessionDetails) r1
            java.lang.Object r2 = r9.L$3
            com.google.firebase.FirebaseApp r2 = (com.google.firebase.FirebaseApp) r2
            java.lang.Object r3 = r9.L$2
            com.google.firebase.sessions.SessionEvents r3 = (com.google.firebase.sessions.SessionEvents) r3
            java.lang.Object r4 = r9.L$1
            com.google.firebase.sessions.SessionFirelogPublisherImpl r4 = (com.google.firebase.sessions.SessionFirelogPublisherImpl) r4
            java.lang.Object r5 = r9.L$0
            com.google.firebase.sessions.InstallationId r5 = (com.google.firebase.sessions.InstallationId) r5
            kotlin.ResultKt.throwOnFailure(r10)
            r7 = r3
            r3 = r0
            r0 = r7
            r7 = r2
            r2 = r1
            r1 = r7
        L_0x0032:
            r7 = r4
            goto L_0x00a8
        L_0x0035:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0072
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0056
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r10)
            com.google.firebase.sessions.SessionFirelogPublisherImpl r10 = r9.this$0
            r1 = r9
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r9.label = r4
            java.lang.Object r10 = r10.shouldLogSession(r1)
            if (r10 != r0) goto L_0x0056
            goto L_0x00a0
        L_0x0056:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x00bb
            com.google.firebase.sessions.InstallationId$Companion r10 = com.google.firebase.sessions.InstallationId.Companion
            com.google.firebase.sessions.SessionFirelogPublisherImpl r1 = r9.this$0
            com.google.firebase.installations.FirebaseInstallationsApi r1 = r1.firebaseInstallations
            r4 = r9
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r9.label = r3
            java.lang.Object r10 = r10.create(r1, r4)
            if (r10 != r0) goto L_0x0072
            goto L_0x00a0
        L_0x0072:
            r5 = r10
            com.google.firebase.sessions.InstallationId r5 = (com.google.firebase.sessions.InstallationId) r5
            com.google.firebase.sessions.SessionFirelogPublisherImpl r4 = r9.this$0
            com.google.firebase.sessions.SessionEvents r3 = com.google.firebase.sessions.SessionEvents.INSTANCE
            com.google.firebase.sessions.SessionFirelogPublisherImpl r10 = r9.this$0
            com.google.firebase.FirebaseApp r10 = r10.firebaseApp
            com.google.firebase.sessions.SessionDetails r1 = r9.$sessionDetails
            com.google.firebase.sessions.SessionFirelogPublisherImpl r6 = r9.this$0
            com.google.firebase.sessions.settings.SessionsSettings r6 = r6.sessionSettings
            com.google.firebase.sessions.api.FirebaseSessionsDependencies r7 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.INSTANCE
            r8 = r9
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r9.L$0 = r5
            r9.L$1 = r4
            r9.L$2 = r3
            r9.L$3 = r10
            r9.L$4 = r1
            r9.L$5 = r6
            r9.label = r2
            java.lang.Object r2 = r7.getRegisteredSubscribers$com_google_firebase_firebase_sessions(r8)
            if (r2 != r0) goto L_0x00a1
        L_0x00a0:
            return r0
        L_0x00a1:
            r0 = r1
            r1 = r10
            r10 = r2
            r2 = r0
            r0 = r3
            r3 = r6
            goto L_0x0032
        L_0x00a8:
            r4 = r10
            java.util.Map r4 = (java.util.Map) r4
            r10 = r5
            java.lang.String r5 = r10.getFid()
            java.lang.String r6 = r10.getAuthToken()
            com.google.firebase.sessions.SessionEvent r10 = r0.buildSession(r1, r2, r3, r4, r5, r6)
            r7.attemptLoggingSessionEvent(r10)
        L_0x00bb:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SessionFirelogPublisherImpl$logSession$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
