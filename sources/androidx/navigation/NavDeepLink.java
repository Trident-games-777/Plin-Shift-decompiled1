package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.navigation.serialization.RouteSerializerKt;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.SerializersKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 m2\u00020\u0001:\u0004lmnoB\u000f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B%\b\u0000\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ*\u0010;\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\n\u0010>\u001a\u00060?j\u0002`@H\u0002J\u0017\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010DH\u0000¢\u0006\u0002\bEJ\u0013\u0010F\u001a\u00020\"2\b\u0010G\u001a\u0004\u0018\u00010\u0001H\u0002J(\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010J\u001a\u00020D2\u0014\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010M0LH\u0007J-\u0010N\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010D2\u0014\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010M0LH\u0000¢\u0006\u0002\bOJ.\u0010P\u001a\u00020\"2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020I2\u0014\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010M0LH\u0002J.\u0010T\u001a\u00020\"2\u0006\u0010J\u001a\u00020D2\u0006\u0010S\u001a\u00020I2\u0014\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010M0LH\u0002J0\u0010U\u001a\u00020<2\b\u0010V\u001a\u0004\u0018\u00010\u00032\u0006\u0010S\u001a\u00020I2\u0014\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010M0LH\u0002J\u0010\u0010W\u001a\u00020B2\u0006\u0010\u0007\u001a\u00020\u0003H\u0007J\b\u0010X\u001a\u00020BH\u0016J\u0012\u0010Y\u001a\u00020\"2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010Z\u001a\u00020\"2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010[\u001a\u00020\"2\b\u0010\u0002\u001a\u0004\u0018\u00010DH\u0002J\u0015\u0010\\\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020DH\u0000¢\u0006\u0002\b]J\u0015\u0010\\\u001a\u00020\"2\u0006\u0010^\u001a\u00020_H\u0000¢\u0006\u0002\b]J*\u0010`\u001a\u00020<2\u0006\u0010S\u001a\u00020I2\u0006\u0010a\u001a\u00020\u00032\u0006\u0010b\u001a\u00020\u00032\b\u0010c\u001a\u0004\u0018\u00010MH\u0002J,\u0010d\u001a\u00020\"2\u0006\u0010S\u001a\u00020I2\u0006\u0010a\u001a\u00020\u00032\b\u0010b\u001a\u0004\u0018\u00010\u00032\b\u0010c\u001a\u0004\u0018\u00010MH\u0002J\u001c\u0010e\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015H\u0002J<\u0010f\u001a\u00020\"2\f\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010h\u001a\u0002062\u0006\u0010S\u001a\u00020I2\u0014\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010M0LH\u0002J\b\u0010i\u001a\u00020<H\u0002J\b\u0010j\u001a\u00020<H\u0002J\u0014\u0010k\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020605H\u0002R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f8@X\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00108BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0011\u0010\u000eR/\u0010\u0014\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u00038BX\u0002¢\u0006\f\n\u0004\b \u0010\u0013\u001a\u0004\b\u001f\u0010\nR&\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"8G@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010'\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b(\u0010\u0013\u001a\u0004\b'\u0010$R\u000e\u0010)\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\nR\u001d\u0010+\u001a\u0004\u0018\u00010\u001a8BX\u0002¢\u0006\f\n\u0004\b-\u0010\u0013\u001a\u0004\b,\u0010\u001cR\u0010\u0010.\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010X\u0004¢\u0006\u0002\n\u0000R\u001d\u00100\u001a\u0004\u0018\u00010\u001a8BX\u0002¢\u0006\f\n\u0004\b2\u0010\u0013\u001a\u0004\b1\u0010\u001cR\u0010\u00103\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R'\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u000206058BX\u0002¢\u0006\f\n\u0004\b9\u0010\u0013\u001a\u0004\b7\u00108R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\n¨\u0006p"}, d2 = {"Landroidx/navigation/NavDeepLink;", "", "uri", "", "(Ljava/lang/String;)V", "uriPattern", "action", "mimeType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "argumentsNames", "", "getArgumentsNames$navigation_common_release", "()Ljava/util/List;", "fragArgs", "", "getFragArgs", "fragArgs$delegate", "Lkotlin/Lazy;", "fragArgsAndRegex", "Lkotlin/Pair;", "getFragArgsAndRegex", "()Lkotlin/Pair;", "fragArgsAndRegex$delegate", "fragPattern", "Ljava/util/regex/Pattern;", "getFragPattern", "()Ljava/util/regex/Pattern;", "fragPattern$delegate", "fragRegex", "getFragRegex", "fragRegex$delegate", "<set-?>", "", "isExactDeepLink", "()Z", "setExactDeepLink$navigation_common_release", "(Z)V", "isParameterizedQuery", "isParameterizedQuery$delegate", "isSingleQueryParamValueOnly", "getMimeType", "mimeTypePattern", "getMimeTypePattern", "mimeTypePattern$delegate", "mimeTypeRegex", "pathArgs", "pathPattern", "getPathPattern", "pathPattern$delegate", "pathRegex", "queryArgsMap", "", "Landroidx/navigation/NavDeepLink$ParamQuery;", "getQueryArgsMap", "()Ljava/util/Map;", "queryArgsMap$delegate", "getUriPattern", "buildRegex", "", "args", "uriRegex", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "calculateMatchingPathSegments", "", "requestedLink", "Landroid/net/Uri;", "calculateMatchingPathSegments$navigation_common_release", "equals", "other", "getMatchingArguments", "Landroid/os/Bundle;", "deepLink", "arguments", "", "Landroidx/navigation/NavArgument;", "getMatchingPathAndQueryArgs", "getMatchingPathAndQueryArgs$navigation_common_release", "getMatchingPathArguments", "matcher", "Ljava/util/regex/Matcher;", "bundle", "getMatchingQueryArguments", "getMatchingUriFragment", "fragment", "getMimeTypeMatchRating", "hashCode", "matchAction", "matchMimeType", "matchUri", "matches", "matches$navigation_common_release", "deepLinkRequest", "Landroidx/navigation/NavDeepLinkRequest;", "parseArgument", "name", "value", "argument", "parseArgumentForRepeatedParam", "parseFragment", "parseInputParams", "inputParams", "storedParam", "parseMime", "parsePath", "parseQuery", "Builder", "Companion", "MimeType", "ParamQuery", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavDeepLink.kt */
public final class NavDeepLink {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Pattern FILL_IN_PATTERN = Pattern.compile("\\{(.+?)\\}");
    private static final String PATH_REGEX = "([^/]*?|)";
    private static final Pattern SCHEME_PATTERN = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");
    private static final String SCHEME_REGEX = "http[s]?://";
    private static final String WILDCARD_REGEX = ".*";
    private static final String WILDCARD_REGEX_ESCAPED = ("\\E" + ".*" + "\\Q");
    private final String action;
    private final Lazy fragArgs$delegate;
    private final Lazy fragArgsAndRegex$delegate;
    private final Lazy fragPattern$delegate;
    private final Lazy fragRegex$delegate;
    private boolean isExactDeepLink;
    private final Lazy isParameterizedQuery$delegate;
    private boolean isSingleQueryParamValueOnly;
    private final String mimeType;
    private final Lazy mimeTypePattern$delegate;
    /* access modifiers changed from: private */
    public String mimeTypeRegex;
    private final List<String> pathArgs;
    private final Lazy pathPattern$delegate;
    /* access modifiers changed from: private */
    public String pathRegex;
    private final Lazy queryArgsMap$delegate;
    private final String uriPattern;

    public NavDeepLink(String str, String str2, String str3) {
        this.uriPattern = str;
        this.action = str2;
        this.mimeType = str3;
        this.pathArgs = new ArrayList();
        this.pathPattern$delegate = LazyKt.lazy(new NavDeepLink$pathPattern$2(this));
        this.isParameterizedQuery$delegate = LazyKt.lazy(new NavDeepLink$isParameterizedQuery$2(this));
        this.queryArgsMap$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new NavDeepLink$queryArgsMap$2(this));
        this.fragArgsAndRegex$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new NavDeepLink$fragArgsAndRegex$2(this));
        this.fragArgs$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new NavDeepLink$fragArgs$2(this));
        this.fragRegex$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new NavDeepLink$fragRegex$2(this));
        this.fragPattern$delegate = LazyKt.lazy(new NavDeepLink$fragPattern$2(this));
        this.mimeTypePattern$delegate = LazyKt.lazy(new NavDeepLink$mimeTypePattern$2(this));
        parsePath();
        parseMime();
    }

    public final String getUriPattern() {
        return this.uriPattern;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    private final Pattern getPathPattern() {
        return (Pattern) this.pathPattern$delegate.getValue();
    }

    private final boolean isParameterizedQuery() {
        return ((Boolean) this.isParameterizedQuery$delegate.getValue()).booleanValue();
    }

    private final Map<String, ParamQuery> getQueryArgsMap() {
        return (Map) this.queryArgsMap$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final Pair<List<String>, String> getFragArgsAndRegex() {
        return (Pair) this.fragArgsAndRegex$delegate.getValue();
    }

    private final List<String> getFragArgs() {
        return (List) this.fragArgs$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final String getFragRegex() {
        return (String) this.fragRegex$delegate.getValue();
    }

    private final Pattern getFragPattern() {
        return (Pattern) this.fragPattern$delegate.getValue();
    }

    private final Pattern getMimeTypePattern() {
        return (Pattern) this.mimeTypePattern$delegate.getValue();
    }

    public final List<String> getArgumentsNames$navigation_common_release() {
        Collection collection = this.pathArgs;
        Collection arrayList = new ArrayList();
        for (ParamQuery arguments : getQueryArgsMap().values()) {
            CollectionsKt.addAll(arrayList, arguments.getArguments());
        }
        return CollectionsKt.plus(CollectionsKt.plus(collection, (List) arrayList), getFragArgs());
    }

    public final boolean isExactDeepLink() {
        return this.isExactDeepLink;
    }

    public final void setExactDeepLink$navigation_common_release(boolean z) {
        this.isExactDeepLink = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NavDeepLink(String str) {
        this(str, (String) null, (String) null);
        Intrinsics.checkNotNullParameter(str, "uri");
    }

    private final void buildRegex(String str, List<String> list, StringBuilder sb) {
        Matcher matcher = FILL_IN_PATTERN.matcher(str);
        int i = 0;
        while (matcher.find()) {
            String group = matcher.group(1);
            Intrinsics.checkNotNull(group, "null cannot be cast to non-null type kotlin.String");
            list.add(group);
            if (matcher.start() > i) {
                String substring = str.substring(i, matcher.start());
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                sb.append(Pattern.quote(substring));
            }
            sb.append(PATH_REGEX);
            i = matcher.end();
        }
        if (i < str.length()) {
            String substring2 = str.substring(i);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            sb.append(Pattern.quote(substring2));
        }
    }

    public final boolean matches$navigation_common_release(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return matches$navigation_common_release(new NavDeepLinkRequest(uri, (String) null, (String) null));
    }

    public final boolean matches$navigation_common_release(NavDeepLinkRequest navDeepLinkRequest) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "deepLinkRequest");
        return matchUri(navDeepLinkRequest.getUri()) && matchAction(navDeepLinkRequest.getAction()) && matchMimeType(navDeepLinkRequest.getMimeType());
    }

    private final boolean matchUri(Uri uri) {
        if (getPathPattern() == null) {
            return true;
        }
        if (uri == null) {
            return false;
        }
        Pattern pathPattern = getPathPattern();
        Intrinsics.checkNotNull(pathPattern);
        return pathPattern.matcher(uri.toString()).matches();
    }

    private final boolean matchAction(String str) {
        String str2 = this.action;
        if (str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return Intrinsics.areEqual((Object) str2, (Object) str);
    }

    private final boolean matchMimeType(String str) {
        if (this.mimeType == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        Pattern mimeTypePattern = getMimeTypePattern();
        Intrinsics.checkNotNull(mimeTypePattern);
        return mimeTypePattern.matcher(str).matches();
    }

    public final int getMimeTypeMatchRating(String str) {
        Intrinsics.checkNotNullParameter(str, "mimeType");
        if (this.mimeType == null) {
            return -1;
        }
        Pattern mimeTypePattern = getMimeTypePattern();
        Intrinsics.checkNotNull(mimeTypePattern);
        if (!mimeTypePattern.matcher(str).matches()) {
            return -1;
        }
        return new MimeType(this.mimeType).compareTo(new MimeType(str));
    }

    public final Bundle getMatchingArguments(Uri uri, Map<String, NavArgument> map) {
        Intrinsics.checkNotNullParameter(uri, "deepLink");
        Intrinsics.checkNotNullParameter(map, "arguments");
        Pattern pathPattern = getPathPattern();
        Matcher matcher = pathPattern != null ? pathPattern.matcher(uri.toString()) : null;
        if (matcher == null || !matcher.matches()) {
            return null;
        }
        Bundle bundle = new Bundle();
        if (!getMatchingPathArguments(matcher, bundle, map)) {
            return null;
        }
        if (isParameterizedQuery() && !getMatchingQueryArguments(uri, bundle, map)) {
            return null;
        }
        getMatchingUriFragment(uri.getFragment(), bundle, map);
        if (!NavArgumentKt.missingRequiredArguments(map, new NavDeepLink$getMatchingArguments$missingRequiredArguments$1(bundle)).isEmpty()) {
            return null;
        }
        return bundle;
    }

    public final Bundle getMatchingPathAndQueryArgs$navigation_common_release(Uri uri, Map<String, NavArgument> map) {
        Intrinsics.checkNotNullParameter(map, "arguments");
        Bundle bundle = new Bundle();
        if (uri != null) {
            Pattern pathPattern = getPathPattern();
            Matcher matcher = pathPattern != null ? pathPattern.matcher(uri.toString()) : null;
            if (matcher != null && matcher.matches()) {
                getMatchingPathArguments(matcher, bundle, map);
                if (isParameterizedQuery()) {
                    getMatchingQueryArguments(uri, bundle, map);
                }
            }
        }
        return bundle;
    }

    private final void getMatchingUriFragment(String str, Bundle bundle, Map<String, NavArgument> map) {
        Pattern fragPattern = getFragPattern();
        Matcher matcher = fragPattern != null ? fragPattern.matcher(String.valueOf(str)) : null;
        if (matcher != null && matcher.matches()) {
            Iterable fragArgs = getFragArgs();
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(fragArgs, 10));
            int i = 0;
            for (Object next : fragArgs) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str2 = (String) next;
                String decode = Uri.decode(matcher.group(i2));
                NavArgument navArgument = map.get(str2);
                try {
                    Intrinsics.checkNotNullExpressionValue(decode, "value");
                    parseArgument(bundle, str2, decode, navArgument);
                    arrayList.add(Unit.INSTANCE);
                    i = i2;
                } catch (IllegalArgumentException unused) {
                    return;
                }
            }
            List list = (List) arrayList;
        }
    }

    private final boolean getMatchingPathArguments(Matcher matcher, Bundle bundle, Map<String, NavArgument> map) {
        Iterable iterable = this.pathArgs;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        int i = 0;
        for (Object next : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str = (String) next;
            String decode = Uri.decode(matcher.group(i2));
            NavArgument navArgument = map.get(str);
            try {
                Intrinsics.checkNotNullExpressionValue(decode, "value");
                parseArgument(bundle, str, decode, navArgument);
                arrayList.add(Unit.INSTANCE);
                i = i2;
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }
        List list = (List) arrayList;
        return true;
    }

    private final boolean getMatchingQueryArguments(Uri uri, Bundle bundle, Map<String, NavArgument> map) {
        String query;
        for (Map.Entry next : getQueryArgsMap().entrySet()) {
            ParamQuery paramQuery = (ParamQuery) next.getValue();
            List<String> queryParameters = uri.getQueryParameters((String) next.getKey());
            if (this.isSingleQueryParamValueOnly && (query = uri.getQuery()) != null && !Intrinsics.areEqual((Object) query, (Object) uri.toString())) {
                queryParameters = CollectionsKt.listOf(query);
            }
            Intrinsics.checkNotNullExpressionValue(queryParameters, "inputParams");
            if (!parseInputParams(queryParameters, paramQuery, bundle, map)) {
                return false;
            }
        }
        return true;
    }

    private final boolean parseInputParams(List<String> list, ParamQuery paramQuery, Bundle bundle, Map<String, NavArgument> map) {
        Object obj;
        Bundle bundleOf = BundleKt.bundleOf(new Pair[0]);
        Iterator it = paramQuery.getArguments().iterator();
        while (true) {
            NavType<Object> navType = null;
            if (!it.hasNext()) {
                break;
            }
            String str = (String) it.next();
            NavArgument navArgument = map.get(str);
            if (navArgument != null) {
                navType = navArgument.getType();
            }
            if ((navType instanceof CollectionNavType) && !navArgument.isDefaultValuePresent()) {
                navType.put(bundleOf, str, ((CollectionNavType) navType).emptyCollection());
            }
        }
        for (String str2 : list) {
            String paramRegex = paramQuery.getParamRegex();
            Matcher matcher = paramRegex != null ? Pattern.compile(paramRegex, 32).matcher(str2) : null;
            if (matcher == null || !matcher.matches()) {
                return false;
            }
            Iterable arguments = paramQuery.getArguments();
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arguments, 10));
            int i = 0;
            for (Object next : arguments) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str3 = (String) next;
                String group = matcher.group(i2);
                if (group == null) {
                    group = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(group, "argMatcher.group(index + 1) ?: \"\"");
                }
                NavArgument navArgument2 = map.get(str3);
                try {
                    if (!bundleOf.containsKey(str3)) {
                        parseArgument(bundleOf, str3, group, navArgument2);
                        obj = Unit.INSTANCE;
                    } else {
                        obj = Boolean.valueOf(parseArgumentForRepeatedParam(bundleOf, str3, group, navArgument2));
                    }
                } catch (IllegalArgumentException unused) {
                    obj = Unit.INSTANCE;
                }
                arrayList.add(obj);
                i = i2;
            }
            List list2 = (List) arrayList;
        }
        bundle.putAll(bundleOf);
        return true;
    }

    public final int calculateMatchingPathSegments$navigation_common_release(Uri uri) {
        if (uri == null || this.uriPattern == null) {
            return 0;
        }
        List<String> pathSegments = uri.getPathSegments();
        List<String> pathSegments2 = Uri.parse(this.uriPattern).getPathSegments();
        Intrinsics.checkNotNullExpressionValue(pathSegments, "requestedPathSegments");
        Intrinsics.checkNotNullExpressionValue(pathSegments2, "uriPathSegments");
        return CollectionsKt.intersect(pathSegments, pathSegments2).size();
    }

    private final void parseArgument(Bundle bundle, String str, String str2, NavArgument navArgument) {
        if (navArgument != null) {
            navArgument.getType().parseAndPut(bundle, str, str2);
        } else {
            bundle.putString(str, str2);
        }
    }

    private final boolean parseArgumentForRepeatedParam(Bundle bundle, String str, String str2, NavArgument navArgument) {
        if (!bundle.containsKey(str)) {
            return true;
        }
        if (navArgument == null) {
            return false;
        }
        NavType<Object> type = navArgument.getType();
        type.parseAndPut(bundle, str, str2, type.get(bundle, str));
        return false;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Landroidx/navigation/NavDeepLink$ParamQuery;", "", "()V", "arguments", "", "", "getArguments", "()Ljava/util/List;", "paramRegex", "getParamRegex", "()Ljava/lang/String;", "setParamRegex", "(Ljava/lang/String;)V", "addArgumentName", "", "name", "getArgumentName", "index", "", "size", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NavDeepLink.kt */
    private static final class ParamQuery {
        private final List<String> arguments = new ArrayList();
        private String paramRegex;

        public final String getParamRegex() {
            return this.paramRegex;
        }

        public final void setParamRegex(String str) {
            this.paramRegex = str;
        }

        public final List<String> getArguments() {
            return this.arguments;
        }

        public final void addArgumentName(String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            this.arguments.add(str);
        }

        public final String getArgumentName(int i) {
            return this.arguments.get(i);
        }

        public final int size() {
            return this.arguments.size();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0000H\u0002R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\u0004¨\u0006\u000f"}, d2 = {"Landroidx/navigation/NavDeepLink$MimeType;", "", "mimeType", "", "(Ljava/lang/String;)V", "subType", "getSubType", "()Ljava/lang/String;", "setSubType", "type", "getType", "setType", "compareTo", "", "other", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NavDeepLink.kt */
    private static final class MimeType implements Comparable<MimeType> {
        private String subType;
        private String type;

        public MimeType(String str) {
            List list;
            Intrinsics.checkNotNullParameter(str, "mimeType");
            List<String> split = new Regex(RemoteSettings.FORWARD_SLASH_STRING).split(str, 0);
            if (!split.isEmpty()) {
                ListIterator<String> listIterator = split.listIterator(split.size());
                while (true) {
                    if (listIterator.hasPrevious()) {
                        if (listIterator.previous().length() != 0) {
                            list = CollectionsKt.take(split, listIterator.nextIndex() + 1);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            list = CollectionsKt.emptyList();
            this.type = (String) list.get(0);
            this.subType = (String) list.get(1);
        }

        public final String getType() {
            return this.type;
        }

        public final void setType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.type = str;
        }

        public final String getSubType() {
            return this.subType;
        }

        public final void setSubType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.subType = str;
        }

        public int compareTo(MimeType mimeType) {
            Intrinsics.checkNotNullParameter(mimeType, "other");
            int i = Intrinsics.areEqual((Object) this.type, (Object) mimeType.type) ? 2 : 0;
            return Intrinsics.areEqual((Object) this.subType, (Object) mimeType.subType) ? i + 1 : i;
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof NavDeepLink)) {
            NavDeepLink navDeepLink = (NavDeepLink) obj;
            if (!Intrinsics.areEqual((Object) this.uriPattern, (Object) navDeepLink.uriPattern) || !Intrinsics.areEqual((Object) this.action, (Object) navDeepLink.action) || !Intrinsics.areEqual((Object) this.mimeType, (Object) navDeepLink.mimeType)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.uriPattern;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.action;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.mimeType;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007\b\u0017¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0004J<\u0010\u000b\u001a\u00020\u0000\"\n\b\u0000\u0010\f\u0018\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u00042\u001d\b\u0002\u0010\u000e\u001a\u0017\u0012\u0004\u0012\u00020\u0010\u0012\r\u0012\u000b\u0012\u0002\b\u00030\u0011¢\u0006\u0002\b\u00120\u000fH\bJB\u0010\u000b\u001a\u00020\u0000\"\b\b\u0000\u0010\f*\u00020\u00012\u0006\u0010\r\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\f0\u00142\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u000fH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/navigation/NavDeepLink$Builder;", "", "()V", "action", "", "mimeType", "uriPattern", "build", "Landroidx/navigation/NavDeepLink;", "setAction", "setMimeType", "setUriPattern", "T", "basePath", "typeMap", "", "Lkotlin/reflect/KType;", "Landroidx/navigation/NavType;", "Lkotlin/jvm/JvmSuppressWildcards;", "route", "Lkotlin/reflect/KClass;", "Companion", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NavDeepLink.kt */
    public static final class Builder {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private String action;
        private String mimeType;
        private String uriPattern;

        @JvmStatic
        public static final Builder fromAction(String str) {
            return Companion.fromAction(str);
        }

        @JvmStatic
        public static final Builder fromMimeType(String str) {
            return Companion.fromMimeType(str);
        }

        @JvmStatic
        public static final Builder fromUriPattern(String str) {
            return Companion.fromUriPattern(str);
        }

        public final Builder setUriPattern(String str) {
            Intrinsics.checkNotNullParameter(str, "uriPattern");
            this.uriPattern = str;
            return this;
        }

        public static /* synthetic */ Builder setUriPattern$default(Builder builder, String str, Map map, int i, Object obj) {
            if ((i & 2) != 0) {
                map = MapsKt.emptyMap();
            }
            Intrinsics.checkNotNullParameter(str, "basePath");
            Intrinsics.checkNotNullParameter(map, "typeMap");
            Intrinsics.reifiedOperationMarker(4, "T");
            return builder.setUriPattern(str, Reflection.getOrCreateKotlinClass(Object.class), map);
        }

        public final /* synthetic */ <T> Builder setUriPattern(String str, Map<KType, NavType<?>> map) {
            Intrinsics.checkNotNullParameter(str, "basePath");
            Intrinsics.checkNotNullParameter(map, "typeMap");
            Intrinsics.reifiedOperationMarker(4, "T");
            return setUriPattern(str, Reflection.getOrCreateKotlinClass(Object.class), map);
        }

        public static /* synthetic */ Builder setUriPattern$default(Builder builder, String str, KClass kClass, Map map, int i, Object obj) {
            if ((i & 4) != 0) {
                map = MapsKt.emptyMap();
            }
            return builder.setUriPattern(str, kClass, map);
        }

        public final <T> Builder setUriPattern(String str, KClass<T> kClass, Map<KType, ? extends NavType<?>> map) {
            Intrinsics.checkNotNullParameter(str, "basePath");
            Intrinsics.checkNotNullParameter(kClass, "route");
            Intrinsics.checkNotNullParameter(map, "typeMap");
            this.uriPattern = RouteSerializerKt.generateRoutePattern(SerializersKt.serializer(kClass), map, str);
            return this;
        }

        public final Builder setAction(String str) {
            Intrinsics.checkNotNullParameter(str, "action");
            if (str.length() > 0) {
                this.action = str;
                return this;
            }
            throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.".toString());
        }

        public final Builder setMimeType(String str) {
            Intrinsics.checkNotNullParameter(str, "mimeType");
            this.mimeType = str;
            return this;
        }

        public final NavDeepLink build() {
            return new NavDeepLink(this.uriPattern, this.action, this.mimeType);
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0007J<\u0010\t\u001a\u00020\u0004\"\n\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\u00062\u001d\b\u0002\u0010\r\u001a\u0017\u0012\u0004\u0012\u00020\u000f\u0012\r\u0012\u000b\u0012\u0002\b\u00030\u0010¢\u0006\u0002\b\u00110\u000eH\b¨\u0006\u0012"}, d2 = {"Landroidx/navigation/NavDeepLink$Builder$Companion;", "", "()V", "fromAction", "Landroidx/navigation/NavDeepLink$Builder;", "action", "", "fromMimeType", "mimeType", "fromUriPattern", "uriPattern", "T", "basePath", "typeMap", "", "Lkotlin/reflect/KType;", "Landroidx/navigation/NavType;", "Lkotlin/jvm/JvmSuppressWildcards;", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: NavDeepLink.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Builder fromUriPattern(String str) {
                Intrinsics.checkNotNullParameter(str, "uriPattern");
                Builder builder = new Builder();
                builder.setUriPattern(str);
                return builder;
            }

            public static /* synthetic */ Builder fromUriPattern$default(Companion companion, String str, Map map, int i, Object obj) {
                if ((i & 2) != 0) {
                    map = MapsKt.emptyMap();
                }
                Intrinsics.checkNotNullParameter(str, "basePath");
                Intrinsics.checkNotNullParameter(map, "typeMap");
                Builder builder = new Builder();
                Intrinsics.reifiedOperationMarker(4, "T");
                builder.setUriPattern(str, Reflection.getOrCreateKotlinClass(Object.class), map);
                return builder;
            }

            @JvmStatic
            public final /* synthetic */ <T> Builder fromUriPattern(String str, Map<KType, NavType<?>> map) {
                Intrinsics.checkNotNullParameter(str, "basePath");
                Intrinsics.checkNotNullParameter(map, "typeMap");
                Builder builder = new Builder();
                Intrinsics.reifiedOperationMarker(4, "T");
                builder.setUriPattern(str, Reflection.getOrCreateKotlinClass(Object.class), map);
                return builder;
            }

            @JvmStatic
            public final Builder fromAction(String str) {
                Intrinsics.checkNotNullParameter(str, "action");
                if (str.length() > 0) {
                    Builder builder = new Builder();
                    builder.setAction(str);
                    return builder;
                }
                throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.".toString());
            }

            @JvmStatic
            public final Builder fromMimeType(String str) {
                Intrinsics.checkNotNullParameter(str, "mimeType");
                Builder builder = new Builder();
                builder.setMimeType(str);
                return builder;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/navigation/NavDeepLink$Companion;", "", "()V", "FILL_IN_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "PATH_REGEX", "", "SCHEME_PATTERN", "SCHEME_REGEX", "WILDCARD_REGEX", "WILDCARD_REGEX_ESCAPED", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NavDeepLink.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void parsePath() {
        if (this.uriPattern != null) {
            StringBuilder sb = new StringBuilder("^");
            if (!SCHEME_PATTERN.matcher(this.uriPattern).find()) {
                sb.append(SCHEME_REGEX);
            }
            Matcher matcher = Pattern.compile("(\\?|\\#|$)").matcher(this.uriPattern);
            matcher.find();
            boolean z = false;
            String substring = this.uriPattern.substring(0, matcher.start());
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            buildRegex(substring, this.pathArgs, sb);
            CharSequence charSequence = sb;
            String str = WILDCARD_REGEX;
            if (!StringsKt.contains$default(charSequence, (CharSequence) str, false, 2, (Object) null) && !StringsKt.contains$default(charSequence, (CharSequence) PATH_REGEX, false, 2, (Object) null)) {
                z = true;
            }
            this.isExactDeepLink = z;
            sb.append("($|(\\?(.)*)|(\\#(.)*))");
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "uriRegex.toString()");
            this.pathRegex = StringsKt.replace$default(sb2, str, WILDCARD_REGEX_ESCAPED, false, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final Map<String, ParamQuery> parseQuery() {
        Map<String, ParamQuery> linkedHashMap = new LinkedHashMap<>();
        if (isParameterizedQuery()) {
            Uri parse = Uri.parse(this.uriPattern);
            for (String next : parse.getQueryParameterNames()) {
                StringBuilder sb = new StringBuilder();
                List<String> queryParameters = parse.getQueryParameters(next);
                if (queryParameters.size() <= 1) {
                    Intrinsics.checkNotNullExpressionValue(queryParameters, "queryParams");
                    String str = (String) CollectionsKt.firstOrNull(queryParameters);
                    if (str == null) {
                        this.isSingleQueryParamValueOnly = true;
                        str = next;
                    }
                    Matcher matcher = FILL_IN_PATTERN.matcher(str);
                    ParamQuery paramQuery = new ParamQuery();
                    int i = 0;
                    while (matcher.find()) {
                        String group = matcher.group(1);
                        Intrinsics.checkNotNull(group, "null cannot be cast to non-null type kotlin.String");
                        paramQuery.addArgumentName(group);
                        Intrinsics.checkNotNullExpressionValue(str, "queryParam");
                        String substring = str.substring(i, matcher.start());
                        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                        sb.append(Pattern.quote(substring));
                        sb.append("(.+?)?");
                        i = matcher.end();
                    }
                    if (i < str.length()) {
                        Intrinsics.checkNotNullExpressionValue(str, "queryParam");
                        String substring2 = str.substring(i);
                        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                        sb.append(Pattern.quote(substring2));
                    }
                    String sb2 = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(sb2, "argRegex.toString()");
                    paramQuery.setParamRegex(StringsKt.replace$default(sb2, WILDCARD_REGEX, WILDCARD_REGEX_ESCAPED, false, 4, (Object) null));
                    Intrinsics.checkNotNullExpressionValue(next, "paramName");
                    linkedHashMap.put(next, paramQuery);
                } else {
                    throw new IllegalArgumentException(("Query parameter " + next + " must only be present once in " + this.uriPattern + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.").toString());
                }
            }
        }
        return linkedHashMap;
    }

    /* access modifiers changed from: private */
    public final Pair<List<String>, String> parseFragment() {
        String str = this.uriPattern;
        if (str == null || Uri.parse(str).getFragment() == null) {
            return null;
        }
        List arrayList = new ArrayList();
        String fragment = Uri.parse(this.uriPattern).getFragment();
        StringBuilder sb = new StringBuilder();
        Intrinsics.checkNotNull(fragment);
        buildRegex(fragment, arrayList, sb);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "fragRegex.toString()");
        return TuplesKt.to(arrayList, sb2);
    }

    private final void parseMime() {
        if (this.mimeType != null) {
            if (Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(this.mimeType).matches()) {
                MimeType mimeType2 = new MimeType(this.mimeType);
                this.mimeTypeRegex = StringsKt.replace$default("^(" + mimeType2.getType() + "|[*]+)/(" + mimeType2.getSubType() + "|[*]+)$", "*|[*]", "[\\s\\S]", false, 4, (Object) null);
                return;
            }
            throw new IllegalArgumentException(("The given mimeType " + this.mimeType + " does not match to required \"type/subtype\" format").toString());
        }
    }
}
