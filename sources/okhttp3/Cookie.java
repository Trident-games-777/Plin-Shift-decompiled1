package okhttp3;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.common.net.HttpHeaders;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 &2\u00020\u0001:\u0002%&BO\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u000eJ\r\u0010\u0007\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0012J\u0013\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0002J\r\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0017J\r\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0002\b\u0018J\r\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0002\b\u0019J\u000e\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cJ\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001dJ\r\u0010\b\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001eJ\r\u0010\f\u001a\u00020\nH\u0007¢\u0006\u0002\b\u001fJ\r\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\b J\b\u0010!\u001a\u00020\u0003H\u0016J\u0015\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\nH\u0000¢\u0006\u0002\b#J\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\b$R\u0013\u0010\u0007\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000fR\u0013\u0010\u0005\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0010R\u0013\u0010\r\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0011R\u0013\u0010\u000b\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0011R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000fR\u0013\u0010\b\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000fR\u0013\u0010\f\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0011R\u0013\u0010\t\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011R\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000f¨\u0006'"}, d2 = {"Lokhttp3/Cookie;", "", "name", "", "value", "expiresAt", "", "domain", "path", "secure", "", "httpOnly", "persistent", "hostOnly", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZZZZ)V", "()Ljava/lang/String;", "()J", "()Z", "-deprecated_domain", "equals", "other", "-deprecated_expiresAt", "hashCode", "", "-deprecated_hostOnly", "-deprecated_httpOnly", "matches", "url", "Lokhttp3/HttpUrl;", "-deprecated_name", "-deprecated_path", "-deprecated_persistent", "-deprecated_secure", "toString", "forObsoleteRfc2965", "toString$okhttp", "-deprecated_value", "Builder", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Cookie.kt */
public final class Cookie {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    /* access modifiers changed from: private */
    public static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    /* access modifiers changed from: private */
    public static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    /* access modifiers changed from: private */
    public static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;

    public /* synthetic */ Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j, str3, str4, z, z2, z3, z4);
    }

    @JvmStatic
    public static final Cookie parse(HttpUrl httpUrl, String str) {
        return Companion.parse(httpUrl, str);
    }

    @JvmStatic
    public static final List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        return Companion.parseAll(httpUrl, headers);
    }

    private Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j;
        this.domain = str3;
        this.path = str4;
        this.secure = z;
        this.httpOnly = z2;
        this.persistent = z3;
        this.hostOnly = z4;
    }

    public final String name() {
        return this.name;
    }

    public final String value() {
        return this.value;
    }

    public final long expiresAt() {
        return this.expiresAt;
    }

    public final String domain() {
        return this.domain;
    }

    public final String path() {
        return this.path;
    }

    public final boolean secure() {
        return this.secure;
    }

    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean persistent() {
        return this.persistent;
    }

    public final boolean hostOnly() {
        return this.hostOnly;
    }

    public final boolean matches(HttpUrl httpUrl) {
        boolean z;
        Intrinsics.checkNotNullParameter(httpUrl, ImagesContract.URL);
        if (this.hostOnly) {
            z = Intrinsics.areEqual((Object) httpUrl.host(), (Object) this.domain);
        } else {
            z = Companion.domainMatch(httpUrl.host(), this.domain);
        }
        if (!z || !Companion.pathMatch(httpUrl, this.path)) {
            return false;
        }
        if (!this.secure || httpUrl.isHttps()) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        return Intrinsics.areEqual((Object) cookie.name, (Object) this.name) && Intrinsics.areEqual((Object) cookie.value, (Object) this.value) && cookie.expiresAt == this.expiresAt && Intrinsics.areEqual((Object) cookie.domain, (Object) this.domain) && Intrinsics.areEqual((Object) cookie.path, (Object) this.path) && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly;
    }

    public int hashCode() {
        return ((((((((((((((((527 + this.name.hashCode()) * 31) + this.value.hashCode()) * 31) + Long.hashCode(this.expiresAt)) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31) + Boolean.hashCode(this.secure)) * 31) + Boolean.hashCode(this.httpOnly)) * 31) + Boolean.hashCode(this.persistent)) * 31) + Boolean.hashCode(this.hostOnly);
    }

    public String toString() {
        return toString$okhttp(false);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "name", imports = {}))
    /* renamed from: -deprecated_name  reason: not valid java name */
    public final String m9501deprecated_name() {
        return this.name;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "value", imports = {}))
    /* renamed from: -deprecated_value  reason: not valid java name */
    public final String m9505deprecated_value() {
        return this.value;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "persistent", imports = {}))
    /* renamed from: -deprecated_persistent  reason: not valid java name */
    public final boolean m9503deprecated_persistent() {
        return this.persistent;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "expiresAt", imports = {}))
    /* renamed from: -deprecated_expiresAt  reason: not valid java name */
    public final long m9498deprecated_expiresAt() {
        return this.expiresAt;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "hostOnly", imports = {}))
    /* renamed from: -deprecated_hostOnly  reason: not valid java name */
    public final boolean m9499deprecated_hostOnly() {
        return this.hostOnly;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "domain", imports = {}))
    /* renamed from: -deprecated_domain  reason: not valid java name */
    public final String m9497deprecated_domain() {
        return this.domain;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "path", imports = {}))
    /* renamed from: -deprecated_path  reason: not valid java name */
    public final String m9502deprecated_path() {
        return this.path;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "httpOnly", imports = {}))
    /* renamed from: -deprecated_httpOnly  reason: not valid java name */
    public final boolean m9500deprecated_httpOnly() {
        return this.httpOnly;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "secure", imports = {}))
    /* renamed from: -deprecated_secure  reason: not valid java name */
    public final boolean m9504deprecated_secure() {
        return this.secure;
    }

    public final String toString$okhttp(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append('=');
        sb.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=").append(DatesKt.toHttpDateString(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.domain);
        }
        sb.append("; path=").append(this.path);
        if (this.secure) {
            sb.append("; secure");
        }
        if (this.httpOnly) {
            sb.append("; httponly");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString()");
        return sb2;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0018\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0000J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0000J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokhttp3/Cookie$Builder;", "", "()V", "domain", "", "expiresAt", "", "hostOnly", "", "httpOnly", "name", "path", "persistent", "secure", "value", "build", "Lokhttp3/Cookie;", "hostOnlyDomain", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Cookie.kt */
    public static final class Builder {
        private String domain;
        private long expiresAt = DatesKt.MAX_DATE;
        private boolean hostOnly;
        private boolean httpOnly;
        private String name;
        private String path = RemoteSettings.FORWARD_SLASH_STRING;
        private boolean persistent;
        private boolean secure;
        private String value;

        public final Builder name(String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            Builder builder = this;
            if (Intrinsics.areEqual((Object) StringsKt.trim((CharSequence) str).toString(), (Object) str)) {
                this.name = str;
                return this;
            }
            throw new IllegalArgumentException("name is not trimmed".toString());
        }

        public final Builder value(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            Builder builder = this;
            if (Intrinsics.areEqual((Object) StringsKt.trim((CharSequence) str).toString(), (Object) str)) {
                this.value = str;
                return this;
            }
            throw new IllegalArgumentException("value is not trimmed".toString());
        }

        public final Builder expiresAt(long j) {
            Builder builder = this;
            if (j <= 0) {
                j = Long.MIN_VALUE;
            }
            if (j > DatesKt.MAX_DATE) {
                j = 253402300799999L;
            }
            this.expiresAt = j;
            this.persistent = true;
            return this;
        }

        public final Builder domain(String str) {
            Intrinsics.checkNotNullParameter(str, "domain");
            return domain(str, false);
        }

        public final Builder hostOnlyDomain(String str) {
            Intrinsics.checkNotNullParameter(str, "domain");
            return domain(str, true);
        }

        private final Builder domain(String str, boolean z) {
            Builder builder = this;
            String canonicalHost = HostnamesKt.toCanonicalHost(str);
            if (canonicalHost != null) {
                this.domain = canonicalHost;
                this.hostOnly = z;
                return this;
            }
            throw new IllegalArgumentException("unexpected domain: " + str);
        }

        public final Builder path(String str) {
            Intrinsics.checkNotNullParameter(str, "path");
            Builder builder = this;
            if (StringsKt.startsWith$default(str, RemoteSettings.FORWARD_SLASH_STRING, false, 2, (Object) null)) {
                this.path = str;
                return this;
            }
            throw new IllegalArgumentException("path must start with '/'".toString());
        }

        public final Builder secure() {
            Builder builder = this;
            this.secure = true;
            return this;
        }

        public final Builder httpOnly() {
            Builder builder = this;
            this.httpOnly = true;
            return this;
        }

        public final Cookie build() {
            String str = this.name;
            if (str != null) {
                String str2 = this.value;
                if (str2 != null) {
                    long j = this.expiresAt;
                    String str3 = this.domain;
                    if (str3 != null) {
                        return new Cookie(str, str2, j, str3, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, (DefaultConstructorMarker) null);
                    }
                    throw new NullPointerException("builder.domain == null");
                }
                throw new NullPointerException("builder.value == null");
            }
            throw new NullPointerException("builder.name == null");
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0002J'\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fH\u0000¢\u0006\u0002\b\u001bJ\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fH\u0007J\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u001d2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\fH\u0002J \u0010\"\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\fH\u0002J\u0018\u0010$\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\fH\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lokhttp3/Cookie$Companion;", "", "()V", "DAY_OF_MONTH_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "MONTH_PATTERN", "TIME_PATTERN", "YEAR_PATTERN", "dateCharacterOffset", "", "input", "", "pos", "limit", "invert", "", "domainMatch", "urlHost", "domain", "parse", "Lokhttp3/Cookie;", "currentTimeMillis", "", "url", "Lokhttp3/HttpUrl;", "setCookie", "parse$okhttp", "parseAll", "", "headers", "Lokhttp3/Headers;", "parseDomain", "s", "parseExpires", "parseMaxAge", "pathMatch", "path", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Cookie.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final boolean domainMatch(String str, String str2) {
            if (Intrinsics.areEqual((Object) str, (Object) str2)) {
                return true;
            }
            return StringsKt.endsWith$default(str, str2, false, 2, (Object) null) && str.charAt((str.length() - str2.length()) - 1) == '.' && !Util.canParseAsIpAddress(str);
        }

        /* access modifiers changed from: private */
        public final boolean pathMatch(HttpUrl httpUrl, String str) {
            String encodedPath = httpUrl.encodedPath();
            if (Intrinsics.areEqual((Object) encodedPath, (Object) str)) {
                return true;
            }
            return StringsKt.startsWith$default(encodedPath, str, false, 2, (Object) null) && (StringsKt.endsWith$default(str, RemoteSettings.FORWARD_SLASH_STRING, false, 2, (Object) null) || encodedPath.charAt(str.length()) == '/');
        }

        @JvmStatic
        public final Cookie parse(HttpUrl httpUrl, String str) {
            Intrinsics.checkNotNullParameter(httpUrl, ImagesContract.URL);
            Intrinsics.checkNotNullParameter(str, "setCookie");
            return parse$okhttp(System.currentTimeMillis(), httpUrl, str);
        }

        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final okhttp3.Cookie parse$okhttp(long r33, okhttp3.HttpUrl r35, java.lang.String r36) {
            /*
                r32 = this;
                r0 = r32
                r1 = r36
                java.lang.String r2 = "url"
                r7 = r35
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r2)
                java.lang.String r2 = "setCookie"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
                r5 = 6
                r6 = 0
                r2 = 59
                r3 = 0
                r4 = 0
                int r4 = okhttp3.internal.Util.delimiterOffset$default((java.lang.String) r1, (char) r2, (int) r3, (int) r4, (int) r5, (java.lang.Object) r6)
                r5 = 2
                r2 = 61
                int r2 = okhttp3.internal.Util.delimiterOffset$default((java.lang.String) r1, (char) r2, (int) r3, (int) r4, (int) r5, (java.lang.Object) r6)
                r3 = 0
                if (r2 != r4) goto L_0x0025
                return r3
            L_0x0025:
                r5 = 0
                r6 = 1
                java.lang.String r8 = okhttp3.internal.Util.trimSubstring$default(r1, r5, r2, r6, r3)
                r9 = r8
                java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                int r9 = r9.length()
                if (r9 != 0) goto L_0x0035
                goto L_0x003c
            L_0x0035:
                int r9 = okhttp3.internal.Util.indexOfControlOrNonAscii(r8)
                r10 = -1
                if (r9 == r10) goto L_0x003d
            L_0x003c:
                return r3
            L_0x003d:
                int r2 = r2 + r6
                java.lang.String r9 = okhttp3.internal.Util.trimSubstring(r1, r2, r4)
                int r2 = okhttp3.internal.Util.indexOfControlOrNonAscii(r9)
                if (r2 == r10) goto L_0x0049
                return r3
            L_0x0049:
                int r4 = r4 + r6
                int r2 = r1.length()
                r10 = r3
                r11 = r10
                r18 = r5
                r20 = r18
                r23 = r20
                r19 = r6
                r14 = -1
                r16 = -1
                r21 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            L_0x0061:
                if (r4 >= r2) goto L_0x00d8
                r24 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
                r12 = 59
                int r12 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r1, (char) r12, (int) r4, (int) r2)
                r13 = 61
                int r13 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r1, (char) r13, (int) r4, (int) r12)
                java.lang.String r4 = okhttp3.internal.Util.trimSubstring(r1, r4, r13)
                if (r13 >= r12) goto L_0x0081
                int r13 = r13 + 1
                java.lang.String r13 = okhttp3.internal.Util.trimSubstring(r1, r13, r12)
                goto L_0x0083
            L_0x0081:
                java.lang.String r13 = ""
            L_0x0083:
                r26 = r3
                java.lang.String r3 = "expires"
                boolean r3 = kotlin.text.StringsKt.equals(r4, r3, r6)
                if (r3 == 0) goto L_0x0096
                int r3 = r13.length()     // Catch:{ IllegalArgumentException -> 0x00d3 }
                long r21 = r0.parseExpires(r13, r5, r3)     // Catch:{ IllegalArgumentException -> 0x00d3 }
                goto L_0x00a2
            L_0x0096:
                java.lang.String r3 = "max-age"
                boolean r3 = kotlin.text.StringsKt.equals(r4, r3, r6)
                if (r3 == 0) goto L_0x00a5
                long r14 = r0.parseMaxAge(r13)     // Catch:{  }
            L_0x00a2:
                r20 = r6
                goto L_0x00d3
            L_0x00a5:
                java.lang.String r3 = "domain"
                boolean r3 = kotlin.text.StringsKt.equals(r4, r3, r6)
                if (r3 == 0) goto L_0x00b4
                java.lang.String r10 = r0.parseDomain(r13)     // Catch:{ IllegalArgumentException -> 0x00d3 }
                r19 = r5
                goto L_0x00d3
            L_0x00b4:
                java.lang.String r3 = "path"
                boolean r3 = kotlin.text.StringsKt.equals(r4, r3, r6)
                if (r3 == 0) goto L_0x00be
                r11 = r13
                goto L_0x00d3
            L_0x00be:
                java.lang.String r3 = "secure"
                boolean r3 = kotlin.text.StringsKt.equals(r4, r3, r6)
                if (r3 == 0) goto L_0x00c9
                r23 = r6
                goto L_0x00d3
            L_0x00c9:
                java.lang.String r3 = "httponly"
                boolean r3 = kotlin.text.StringsKt.equals(r4, r3, r6)
                if (r3 == 0) goto L_0x00d3
                r18 = r6
            L_0x00d3:
                int r4 = r12 + 1
                r3 = r26
                goto L_0x0061
            L_0x00d8:
                r26 = r3
                r24 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
                r1 = -9223372036854775808
                int r3 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
                if (r3 != 0) goto L_0x00e7
                r12 = r1
                goto L_0x0110
            L_0x00e7:
                int r1 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
                if (r1 == 0) goto L_0x010e
                r1 = 9223372036854775(0x20c49ba5e353f7, double:4.663754807431093E-308)
                int r1 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
                if (r1 > 0) goto L_0x00f9
                r1 = 1000(0x3e8, float:1.401E-42)
                long r1 = (long) r1
                long r14 = r14 * r1
                goto L_0x00fe
            L_0x00f9:
                r14 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            L_0x00fe:
                long r14 = r33 + r14
                int r1 = (r14 > r33 ? 1 : (r14 == r33 ? 0 : -1))
                if (r1 < 0) goto L_0x010b
                int r1 = (r14 > r24 ? 1 : (r14 == r24 ? 0 : -1))
                if (r1 <= 0) goto L_0x0109
                goto L_0x010b
            L_0x0109:
                r12 = r14
                goto L_0x0110
            L_0x010b:
                r12 = r24
                goto L_0x0110
            L_0x010e:
                r12 = r21
            L_0x0110:
                java.lang.String r1 = r7.host()
                if (r10 != 0) goto L_0x0118
                r10 = r1
                goto L_0x011f
            L_0x0118:
                boolean r2 = r0.domainMatch(r1, r10)
                if (r2 != 0) goto L_0x011f
                return r26
            L_0x011f:
                int r1 = r1.length()
                int r2 = r10.length()
                if (r1 == r2) goto L_0x0136
                okhttp3.internal.publicsuffix.PublicSuffixDatabase$Companion r1 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.Companion
                okhttp3.internal.publicsuffix.PublicSuffixDatabase r1 = r1.get()
                java.lang.String r1 = r1.getEffectiveTldPlusOne(r10)
                if (r1 != 0) goto L_0x0136
                return r26
            L_0x0136:
                java.lang.String r1 = "/"
                if (r11 == 0) goto L_0x0143
                r2 = 2
                r3 = r26
                boolean r2 = kotlin.text.StringsKt.startsWith$default(r11, r1, r5, r2, r3)
                if (r2 != 0) goto L_0x0165
            L_0x0143:
                java.lang.String r2 = r7.encodedPath()
                r24 = r2
                java.lang.CharSequence r24 = (java.lang.CharSequence) r24
                r28 = 6
                r29 = 0
                r25 = 47
                r26 = 0
                r27 = 0
                int r3 = kotlin.text.StringsKt.lastIndexOf$default((java.lang.CharSequence) r24, (char) r25, (int) r26, (boolean) r27, (int) r28, (java.lang.Object) r29)
                if (r3 == 0) goto L_0x0164
                java.lang.String r1 = r2.substring(r5, r3)
                java.lang.String r2 = "this as java.lang.String…ing(startIndex, endIndex)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            L_0x0164:
                r11 = r1
            L_0x0165:
                okhttp3.Cookie r7 = new okhttp3.Cookie
                r15 = r18
                r18 = 0
                r17 = r19
                r16 = r20
                r14 = r23
                r30 = r12
                r12 = r10
                r13 = r11
                r10 = r30
                r7.<init>(r8, r9, r10, r12, r13, r14, r15, r16, r17, r18)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cookie.Companion.parse$okhttp(long, okhttp3.HttpUrl, java.lang.String):okhttp3.Cookie");
        }

        private final long parseExpires(String str, int i, int i2) {
            String str2 = str;
            int i3 = i2;
            int dateCharacterOffset = dateCharacterOffset(str2, i, i3, false);
            Matcher matcher = Cookie.TIME_PATTERN.matcher(str2);
            int i4 = -1;
            int i5 = -1;
            int i6 = -1;
            int i7 = -1;
            int i8 = -1;
            int i9 = -1;
            while (dateCharacterOffset < i3) {
                int dateCharacterOffset2 = dateCharacterOffset(str2, dateCharacterOffset + 1, i3, true);
                matcher.region(dateCharacterOffset, dateCharacterOffset2);
                if (i5 == -1 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                    String group = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(group, "matcher.group(1)");
                    i5 = Integer.parseInt(group);
                    String group2 = matcher.group(2);
                    Intrinsics.checkNotNullExpressionValue(group2, "matcher.group(2)");
                    i8 = Integer.parseInt(group2);
                    String group3 = matcher.group(3);
                    Intrinsics.checkNotNullExpressionValue(group3, "matcher.group(3)");
                    i9 = Integer.parseInt(group3);
                } else if (i6 == -1 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                    String group4 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(group4, "matcher.group(1)");
                    i6 = Integer.parseInt(group4);
                } else if (i7 == -1 && matcher.usePattern(Cookie.MONTH_PATTERN).matches()) {
                    String group5 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(group5, "matcher.group(1)");
                    Locale locale = Locale.US;
                    Intrinsics.checkNotNullExpressionValue(locale, "US");
                    String lowerCase = group5.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    String pattern = Cookie.MONTH_PATTERN.pattern();
                    Intrinsics.checkNotNullExpressionValue(pattern, "MONTH_PATTERN.pattern()");
                    i7 = StringsKt.indexOf$default((CharSequence) pattern, lowerCase, 0, false, 6, (Object) null) / 4;
                } else if (i4 == -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                    String group6 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(group6, "matcher.group(1)");
                    i4 = Integer.parseInt(group6);
                }
                dateCharacterOffset = dateCharacterOffset(str2, dateCharacterOffset2 + 1, i3, false);
            }
            if (70 <= i4 && i4 < 100) {
                i4 += 1900;
            }
            if (i4 >= 0 && i4 < 70) {
                i4 += 2000;
            }
            if (i4 < 1601) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            } else if (i7 == -1) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            } else if (1 > i6 || i6 >= 32) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            } else if (i5 < 0 || i5 >= 24) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            } else if (i8 < 0 || i8 >= 60) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            } else if (i9 < 0 || i9 >= 60) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            } else {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
                gregorianCalendar.setLenient(false);
                gregorianCalendar.set(1, i4);
                gregorianCalendar.set(2, i7 - 1);
                gregorianCalendar.set(5, i6);
                gregorianCalendar.set(11, i5);
                gregorianCalendar.set(12, i8);
                gregorianCalendar.set(13, i9);
                gregorianCalendar.set(14, 0);
                return gregorianCalendar.getTimeInMillis();
            }
        }

        private final int dateCharacterOffset(String str, int i, int i2, boolean z) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (((charAt < ' ' && charAt != 9) || charAt >= 127 || ('0' <= charAt && charAt < ':') || (('a' <= charAt && charAt < '{') || (('A' <= charAt && charAt < '[') || charAt == ':'))) == (!z)) {
                    return i;
                }
                i++;
            }
            return i2;
        }

        private final long parseMaxAge(String str) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong <= 0) {
                    return Long.MIN_VALUE;
                }
                return parseLong;
            } catch (NumberFormatException e) {
                if (!new Regex("-?\\d+").matches(str)) {
                    throw e;
                } else if (StringsKt.startsWith$default(str, "-", false, 2, (Object) null)) {
                    return Long.MIN_VALUE;
                } else {
                    return Long.MAX_VALUE;
                }
            }
        }

        private final String parseDomain(String str) {
            if (!StringsKt.endsWith$default(str, ".", false, 2, (Object) null)) {
                String canonicalHost = HostnamesKt.toCanonicalHost(StringsKt.removePrefix(str, (CharSequence) "."));
                if (canonicalHost != null) {
                    return canonicalHost;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        @JvmStatic
        public final List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
            Intrinsics.checkNotNullParameter(httpUrl, ImagesContract.URL);
            Intrinsics.checkNotNullParameter(headers, "headers");
            List<String> values = headers.values(HttpHeaders.SET_COOKIE);
            int size = values.size();
            List list = null;
            for (int i = 0; i < size; i++) {
                Cookie parse = parse(httpUrl, values.get(i));
                if (parse != null) {
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(parse);
                }
            }
            if (list == null) {
                return CollectionsKt.emptyList();
            }
            List<Cookie> unmodifiableList = Collections.unmodifiableList(list);
            Intrinsics.checkNotNullExpressionValue(unmodifiableList, "{\n        Collections.un…ableList(cookies)\n      }");
            return unmodifiableList;
        }
    }
}
