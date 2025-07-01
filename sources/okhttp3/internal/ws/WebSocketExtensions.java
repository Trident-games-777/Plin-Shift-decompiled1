package okhttp3.internal.ws;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cBE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003JN\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\u000e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lokhttp3/internal/ws/WebSocketExtensions;", "", "perMessageDeflate", "", "clientMaxWindowBits", "", "clientNoContextTakeover", "serverMaxWindowBits", "serverNoContextTakeover", "unknownValues", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)V", "Ljava/lang/Integer;", "component1", "component2", "()Ljava/lang/Integer;", "component3", "component4", "component5", "component6", "copy", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)Lokhttp3/internal/ws/WebSocketExtensions;", "equals", "other", "hashCode", "noContextTakeover", "clientOriginated", "toString", "", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: WebSocketExtensions.kt */
public final class WebSocketExtensions {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";
    public final Integer clientMaxWindowBits;
    public final boolean clientNoContextTakeover;
    public final boolean perMessageDeflate;
    public final Integer serverMaxWindowBits;
    public final boolean serverNoContextTakeover;
    public final boolean unknownValues;

    public WebSocketExtensions() {
        this(false, (Integer) null, false, (Integer) null, false, false, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ WebSocketExtensions copy$default(WebSocketExtensions webSocketExtensions, boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = webSocketExtensions.perMessageDeflate;
        }
        if ((i & 2) != 0) {
            num = webSocketExtensions.clientMaxWindowBits;
        }
        if ((i & 4) != 0) {
            z2 = webSocketExtensions.clientNoContextTakeover;
        }
        if ((i & 8) != 0) {
            num2 = webSocketExtensions.serverMaxWindowBits;
        }
        if ((i & 16) != 0) {
            z3 = webSocketExtensions.serverNoContextTakeover;
        }
        if ((i & 32) != 0) {
            z4 = webSocketExtensions.unknownValues;
        }
        boolean z5 = z3;
        boolean z6 = z4;
        Integer num3 = num2;
        Integer num4 = num;
        return webSocketExtensions.copy(z, num4, z2, num3, z5, z6);
    }

    public final boolean component1() {
        return this.perMessageDeflate;
    }

    public final Integer component2() {
        return this.clientMaxWindowBits;
    }

    public final boolean component3() {
        return this.clientNoContextTakeover;
    }

    public final Integer component4() {
        return this.serverMaxWindowBits;
    }

    public final boolean component5() {
        return this.serverNoContextTakeover;
    }

    public final boolean component6() {
        return this.unknownValues;
    }

    public final WebSocketExtensions copy(boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4) {
        return new WebSocketExtensions(z, num, z2, num2, z3, z4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSocketExtensions)) {
            return false;
        }
        WebSocketExtensions webSocketExtensions = (WebSocketExtensions) obj;
        return this.perMessageDeflate == webSocketExtensions.perMessageDeflate && Intrinsics.areEqual((Object) this.clientMaxWindowBits, (Object) webSocketExtensions.clientMaxWindowBits) && this.clientNoContextTakeover == webSocketExtensions.clientNoContextTakeover && Intrinsics.areEqual((Object) this.serverMaxWindowBits, (Object) webSocketExtensions.serverMaxWindowBits) && this.serverNoContextTakeover == webSocketExtensions.serverNoContextTakeover && this.unknownValues == webSocketExtensions.unknownValues;
    }

    public int hashCode() {
        boolean z = this.perMessageDeflate;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        Integer num = this.clientMaxWindowBits;
        int i2 = 0;
        int hashCode = (i + (num == null ? 0 : num.hashCode())) * 31;
        boolean z3 = this.clientNoContextTakeover;
        if (z3) {
            z3 = true;
        }
        int i3 = (hashCode + (z3 ? 1 : 0)) * 31;
        Integer num2 = this.serverMaxWindowBits;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i4 = (i3 + i2) * 31;
        boolean z4 = this.serverNoContextTakeover;
        if (z4) {
            z4 = true;
        }
        int i5 = (i4 + (z4 ? 1 : 0)) * 31;
        boolean z5 = this.unknownValues;
        if (!z5) {
            z2 = z5;
        }
        return i5 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.perMessageDeflate + ", clientMaxWindowBits=" + this.clientMaxWindowBits + ", clientNoContextTakeover=" + this.clientNoContextTakeover + ", serverMaxWindowBits=" + this.serverMaxWindowBits + ", serverNoContextTakeover=" + this.serverNoContextTakeover + ", unknownValues=" + this.unknownValues + ')';
    }

    public WebSocketExtensions(boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4) {
        this.perMessageDeflate = z;
        this.clientMaxWindowBits = num;
        this.clientNoContextTakeover = z2;
        this.serverMaxWindowBits = num2;
        this.serverNoContextTakeover = z3;
        this.unknownValues = z4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ WebSocketExtensions(boolean r3, java.lang.Integer r4, boolean r5, java.lang.Integer r6, boolean r7, boolean r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r2 = this;
            r10 = r9 & 1
            r0 = 0
            if (r10 == 0) goto L_0x0006
            r3 = r0
        L_0x0006:
            r10 = r9 & 2
            r1 = 0
            if (r10 == 0) goto L_0x000c
            r4 = r1
        L_0x000c:
            r10 = r9 & 4
            if (r10 == 0) goto L_0x0011
            r5 = r0
        L_0x0011:
            r10 = r9 & 8
            if (r10 == 0) goto L_0x0016
            r6 = r1
        L_0x0016:
            r10 = r9 & 16
            if (r10 == 0) goto L_0x001b
            r7 = r0
        L_0x001b:
            r9 = r9 & 32
            if (r9 == 0) goto L_0x0021
            r9 = r0
            goto L_0x0022
        L_0x0021:
            r9 = r8
        L_0x0022:
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.WebSocketExtensions.<init>(boolean, java.lang.Integer, boolean, java.lang.Integer, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final boolean noContextTakeover(boolean z) {
        if (z) {
            return this.clientNoContextTakeover;
        }
        return this.serverNoContextTakeover;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lokhttp3/internal/ws/WebSocketExtensions$Companion;", "", "()V", "HEADER_WEB_SOCKET_EXTENSION", "", "parse", "Lokhttp3/internal/ws/WebSocketExtensions;", "responseHeaders", "Lokhttp3/Headers;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: WebSocketExtensions.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0055, code lost:
            if (r2 >= r5) goto L_0x00ce;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0057, code lost:
            r3 = okhttp3.internal.Util.delimiterOffset(r14, ';', r2, r5);
            r6 = okhttp3.internal.Util.delimiterOffset(r14, '=', r2, r3);
            r2 = okhttp3.internal.Util.trimSubstring(r14, r2, r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0065, code lost:
            if (r6 >= r3) goto L_0x0076;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0067, code lost:
            r6 = kotlin.text.StringsKt.removeSurrounding(okhttp3.internal.Util.trimSubstring(r14, r6 + 1, r3), (java.lang.CharSequence) "\"");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0076, code lost:
            r6 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0077, code lost:
            r3 = r3 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x007f, code lost:
            if (kotlin.text.StringsKt.equals(r2, "client_max_window_bits", true) == false) goto L_0x0092;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0081, code lost:
            if (r7 == null) goto L_0x0084;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0083, code lost:
            r11 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0084, code lost:
            if (r6 == null) goto L_0x008c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0086, code lost:
            r7 = kotlin.text.StringsKt.toIntOrNull(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x008c, code lost:
            r7 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x008d, code lost:
            if (r7 != null) goto L_0x0090;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0090, code lost:
            r2 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0098, code lost:
            if (kotlin.text.StringsKt.equals(r2, "client_no_context_takeover", true) == false) goto L_0x00a3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x009a, code lost:
            if (r8 == false) goto L_0x009d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x009c, code lost:
            r11 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x009d, code lost:
            if (r6 == null) goto L_0x00a0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x009f, code lost:
            r11 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a0, code lost:
            r2 = r3;
            r8 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a9, code lost:
            if (kotlin.text.StringsKt.equals(r2, "server_max_window_bits", true) == false) goto L_0x00ba;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ab, code lost:
            if (r9 == null) goto L_0x00ae;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ad, code lost:
            r11 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ae, code lost:
            if (r6 == null) goto L_0x00b6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b0, code lost:
            r9 = kotlin.text.StringsKt.toIntOrNull(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b6, code lost:
            r9 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b7, code lost:
            if (r9 != null) goto L_0x0090;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c0, code lost:
            if (kotlin.text.StringsKt.equals(r2, "server_no_context_takeover", true) == false) goto L_0x00cb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c2, code lost:
            if (r10 == false) goto L_0x00c5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c4, code lost:
            r11 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c5, code lost:
            if (r6 == null) goto L_0x00c8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c7, code lost:
            r11 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c8, code lost:
            r2 = r3;
            r10 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00cb, code lost:
            r2 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x00cc, code lost:
            r11 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ce, code lost:
            r5 = r2;
            r6 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0051, code lost:
            if (r6 != false) goto L_0x00cc;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final okhttp3.internal.ws.WebSocketExtensions parse(okhttp3.Headers r21) throws java.io.IOException {
            /*
                r20 = this;
                r0 = r21
                java.lang.String r1 = "responseHeaders"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
                int r1 = r0.size()
                r4 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
            L_0x0012:
                if (r4 >= r1) goto L_0x00da
                java.lang.String r5 = r0.name(r4)
                java.lang.String r12 = "Sec-WebSocket-Extensions"
                r13 = 1
                boolean r5 = kotlin.text.StringsKt.equals(r5, r12, r13)
                if (r5 != 0) goto L_0x0023
                goto L_0x00d6
            L_0x0023:
                java.lang.String r14 = r0.value(r4)
                r5 = 0
            L_0x0028:
                int r12 = r14.length()
                if (r5 >= r12) goto L_0x00d6
                r18 = 4
                r19 = 0
                r15 = 44
                r17 = 0
                r16 = r5
                int r5 = okhttp3.internal.Util.delimiterOffset$default((java.lang.String) r14, (char) r15, (int) r16, (int) r17, (int) r18, (java.lang.Object) r19)
                r12 = r16
                r15 = 59
                int r2 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r14, (char) r15, (int) r12, (int) r5)
                java.lang.String r12 = okhttp3.internal.Util.trimSubstring(r14, r12, r2)
                int r2 = r2 + r13
                java.lang.String r3 = "permessage-deflate"
                boolean r3 = kotlin.text.StringsKt.equals(r12, r3, r13)
                if (r3 == 0) goto L_0x00d2
                if (r6 == 0) goto L_0x0055
                goto L_0x00cc
            L_0x0055:
                if (r2 >= r5) goto L_0x00ce
                int r3 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r14, (char) r15, (int) r2, (int) r5)
                r6 = 61
                int r6 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r14, (char) r6, (int) r2, (int) r3)
                java.lang.String r2 = okhttp3.internal.Util.trimSubstring(r14, r2, r6)
                if (r6 >= r3) goto L_0x0076
                int r6 = r6 + 1
                java.lang.String r6 = okhttp3.internal.Util.trimSubstring(r14, r6, r3)
                java.lang.String r12 = "\""
                java.lang.CharSequence r12 = (java.lang.CharSequence) r12
                java.lang.String r6 = kotlin.text.StringsKt.removeSurrounding((java.lang.String) r6, (java.lang.CharSequence) r12)
                goto L_0x0077
            L_0x0076:
                r6 = 0
            L_0x0077:
                int r3 = r3 + 1
                java.lang.String r12 = "client_max_window_bits"
                boolean r12 = kotlin.text.StringsKt.equals(r2, r12, r13)
                if (r12 == 0) goto L_0x0092
                if (r7 == 0) goto L_0x0084
                r11 = r13
            L_0x0084:
                if (r6 == 0) goto L_0x008c
                java.lang.Integer r2 = kotlin.text.StringsKt.toIntOrNull(r6)
                r7 = r2
                goto L_0x008d
            L_0x008c:
                r7 = 0
            L_0x008d:
                if (r7 != 0) goto L_0x0090
                goto L_0x00cb
            L_0x0090:
                r2 = r3
                goto L_0x0055
            L_0x0092:
                java.lang.String r12 = "client_no_context_takeover"
                boolean r12 = kotlin.text.StringsKt.equals(r2, r12, r13)
                if (r12 == 0) goto L_0x00a3
                if (r8 == 0) goto L_0x009d
                r11 = r13
            L_0x009d:
                if (r6 == 0) goto L_0x00a0
                r11 = r13
            L_0x00a0:
                r2 = r3
                r8 = r13
                goto L_0x0055
            L_0x00a3:
                java.lang.String r12 = "server_max_window_bits"
                boolean r12 = kotlin.text.StringsKt.equals(r2, r12, r13)
                if (r12 == 0) goto L_0x00ba
                if (r9 == 0) goto L_0x00ae
                r11 = r13
            L_0x00ae:
                if (r6 == 0) goto L_0x00b6
                java.lang.Integer r2 = kotlin.text.StringsKt.toIntOrNull(r6)
                r9 = r2
                goto L_0x00b7
            L_0x00b6:
                r9 = 0
            L_0x00b7:
                if (r9 != 0) goto L_0x0090
                goto L_0x00cb
            L_0x00ba:
                java.lang.String r12 = "server_no_context_takeover"
                boolean r2 = kotlin.text.StringsKt.equals(r2, r12, r13)
                if (r2 == 0) goto L_0x00cb
                if (r10 == 0) goto L_0x00c5
                r11 = r13
            L_0x00c5:
                if (r6 == 0) goto L_0x00c8
                r11 = r13
            L_0x00c8:
                r2 = r3
                r10 = r13
                goto L_0x0055
            L_0x00cb:
                r2 = r3
            L_0x00cc:
                r11 = r13
                goto L_0x0055
            L_0x00ce:
                r5 = r2
                r6 = r13
                goto L_0x0028
            L_0x00d2:
                r5 = r2
                r11 = r13
                goto L_0x0028
            L_0x00d6:
                int r4 = r4 + 1
                goto L_0x0012
            L_0x00da:
                okhttp3.internal.ws.WebSocketExtensions r5 = new okhttp3.internal.ws.WebSocketExtensions
                r5.<init>(r6, r7, r8, r9, r10, r11)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.WebSocketExtensions.Companion.parse(okhttp3.Headers):okhttp3.internal.ws.WebSocketExtensions");
        }
    }
}
