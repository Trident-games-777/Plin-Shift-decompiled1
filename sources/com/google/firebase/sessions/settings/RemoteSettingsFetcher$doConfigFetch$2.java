package com.google.firebase.sessions.settings;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.sessions.settings.RemoteSettingsFetcher$doConfigFetch$2", f = "RemoteSettingsFetcher.kt", i = {}, l = {68, 70, 73}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: RemoteSettingsFetcher.kt */
final class RemoteSettingsFetcher$doConfigFetch$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $headerOptions;
    final /* synthetic */ Function2<String, Continuation<? super Unit>, Object> $onFailure;
    final /* synthetic */ Function2<JSONObject, Continuation<? super Unit>, Object> $onSuccess;
    int label;
    final /* synthetic */ RemoteSettingsFetcher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RemoteSettingsFetcher$doConfigFetch$2(RemoteSettingsFetcher remoteSettingsFetcher, Map<String, String> map, Function2<? super JSONObject, ? super Continuation<? super Unit>, ? extends Object> function2, Function2<? super String, ? super Continuation<? super Unit>, ? extends Object> function22, Continuation<? super RemoteSettingsFetcher$doConfigFetch$2> continuation) {
        super(2, continuation);
        this.this$0 = remoteSettingsFetcher;
        this.$headerOptions = map;
        this.$onSuccess = function2;
        this.$onFailure = function22;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RemoteSettingsFetcher$doConfigFetch$2(this.this$0, this.$headerOptions, this.$onSuccess, this.$onFailure, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RemoteSettingsFetcher$doConfigFetch$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00d3, code lost:
        if (r8.invoke(r1, r7) == r0) goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00e8, code lost:
        if (r1.invoke(r3, r7) != r0) goto L_0x00eb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0026
            if (r1 == r4) goto L_0x001e
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x00eb
        L_0x0016:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ Exception -> 0x0023 }
            goto L_0x00eb
        L_0x0023:
            r8 = move-exception
            goto L_0x00d6
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r8)
            com.google.firebase.sessions.settings.RemoteSettingsFetcher r8 = r7.this$0     // Catch:{ Exception -> 0x0023 }
            java.net.URL r8 = r8.settingsUrl()     // Catch:{ Exception -> 0x0023 }
            java.net.URLConnection r8 = r8.openConnection()     // Catch:{ Exception -> 0x0023 }
            java.lang.String r1 = "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8, r1)     // Catch:{ Exception -> 0x0023 }
            javax.net.ssl.HttpsURLConnection r8 = (javax.net.ssl.HttpsURLConnection) r8     // Catch:{ Exception -> 0x0023 }
            java.lang.String r1 = "GET"
            r8.setRequestMethod(r1)     // Catch:{ Exception -> 0x0023 }
            java.lang.String r1 = "Accept"
            java.lang.String r5 = "application/json"
            r8.setRequestProperty(r1, r5)     // Catch:{ Exception -> 0x0023 }
            java.util.Map<java.lang.String, java.lang.String> r1 = r7.$headerOptions     // Catch:{ Exception -> 0x0023 }
            java.util.Set r1 = r1.entrySet()     // Catch:{ Exception -> 0x0023 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0023 }
        L_0x0050:
            boolean r5 = r1.hasNext()     // Catch:{ Exception -> 0x0023 }
            if (r5 == 0) goto L_0x006c
            java.lang.Object r5 = r1.next()     // Catch:{ Exception -> 0x0023 }
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ Exception -> 0x0023 }
            java.lang.Object r6 = r5.getKey()     // Catch:{ Exception -> 0x0023 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0023 }
            java.lang.Object r5 = r5.getValue()     // Catch:{ Exception -> 0x0023 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0023 }
            r8.setRequestProperty(r6, r5)     // Catch:{ Exception -> 0x0023 }
            goto L_0x0050
        L_0x006c:
            int r1 = r8.getResponseCode()     // Catch:{ Exception -> 0x0023 }
            r5 = 200(0xc8, float:2.8E-43)
            if (r1 != r5) goto L_0x00b8
            java.io.InputStream r8 = r8.getInputStream()     // Catch:{ Exception -> 0x0023 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0023 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0023 }
            r3.<init>(r8)     // Catch:{ Exception -> 0x0023 }
            java.io.Reader r3 = (java.io.Reader) r3     // Catch:{ Exception -> 0x0023 }
            r1.<init>(r3)     // Catch:{ Exception -> 0x0023 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0023 }
            r3.<init>()     // Catch:{ Exception -> 0x0023 }
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ Exception -> 0x0023 }
            r5.<init>()     // Catch:{ Exception -> 0x0023 }
        L_0x008e:
            java.lang.String r6 = r1.readLine()     // Catch:{ Exception -> 0x0023 }
            r5.element = r6     // Catch:{ Exception -> 0x0023 }
            if (r6 == 0) goto L_0x009e
            T r6 = r5.element     // Catch:{ Exception -> 0x0023 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0023 }
            r3.append(r6)     // Catch:{ Exception -> 0x0023 }
            goto L_0x008e
        L_0x009e:
            r1.close()     // Catch:{ Exception -> 0x0023 }
            r8.close()     // Catch:{ Exception -> 0x0023 }
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x0023 }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x0023 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x0023 }
            kotlin.jvm.functions.Function2<org.json.JSONObject, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r1 = r7.$onSuccess     // Catch:{ Exception -> 0x0023 }
            r7.label = r4     // Catch:{ Exception -> 0x0023 }
            java.lang.Object r8 = r1.invoke(r8, r7)     // Catch:{ Exception -> 0x0023 }
            if (r8 != r0) goto L_0x00eb
            goto L_0x00ea
        L_0x00b8:
            kotlin.jvm.functions.Function2<java.lang.String, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r8 = r7.$onFailure     // Catch:{ Exception -> 0x0023 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0023 }
            r4.<init>()     // Catch:{ Exception -> 0x0023 }
            java.lang.String r5 = "Bad response code: "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ Exception -> 0x0023 }
            java.lang.StringBuilder r1 = r4.append(r1)     // Catch:{ Exception -> 0x0023 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0023 }
            r7.label = r3     // Catch:{ Exception -> 0x0023 }
            java.lang.Object r8 = r8.invoke(r1, r7)     // Catch:{ Exception -> 0x0023 }
            if (r8 != r0) goto L_0x00eb
            goto L_0x00ea
        L_0x00d6:
            kotlin.jvm.functions.Function2<java.lang.String, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r1 = r7.$onFailure
            java.lang.String r3 = r8.getMessage()
            if (r3 != 0) goto L_0x00e2
            java.lang.String r3 = r8.toString()
        L_0x00e2:
            r7.label = r2
            java.lang.Object r8 = r1.invoke(r3, r7)
            if (r8 != r0) goto L_0x00eb
        L_0x00ea:
            return r0
        L_0x00eb:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.RemoteSettingsFetcher$doConfigFetch$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
