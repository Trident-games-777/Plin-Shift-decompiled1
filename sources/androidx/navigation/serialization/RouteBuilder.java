package androidx.navigation.serialization;

import androidx.navigation.CollectionNavType;
import androidx.navigation.NavType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u001aB\u0015\b\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005B\u001d\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J4\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00072\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00142\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015J&\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00072\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0007J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0014H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/navigation/serialization/RouteBuilder;", "T", "", "serializer", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/KSerializer;)V", "path", "", "(Ljava/lang/String;Lkotlinx/serialization/KSerializer;)V", "pathArgs", "queryArgs", "addPath", "", "addQuery", "name", "value", "appendArg", "index", "", "type", "Landroidx/navigation/NavType;", "", "appendPattern", "build", "computeParamType", "Landroidx/navigation/serialization/RouteBuilder$ParamType;", "ParamType", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RouteBuilder.kt */
public final class RouteBuilder<T> {
    private final String path;
    private String pathArgs = "";
    private String queryArgs = "";
    private final KSerializer<T> serializer;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Landroidx/navigation/serialization/RouteBuilder$ParamType;", "", "(Ljava/lang/String;I)V", "PATH", "QUERY", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: RouteBuilder.kt */
    private enum ParamType {
        PATH,
        QUERY
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: RouteBuilder.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                androidx.navigation.serialization.RouteBuilder$ParamType[] r0 = androidx.navigation.serialization.RouteBuilder.ParamType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.navigation.serialization.RouteBuilder$ParamType r1 = androidx.navigation.serialization.RouteBuilder.ParamType.PATH     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.navigation.serialization.RouteBuilder$ParamType r1 = androidx.navigation.serialization.RouteBuilder.ParamType.QUERY     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.serialization.RouteBuilder.WhenMappings.<clinit>():void");
        }
    }

    public RouteBuilder(KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(kSerializer, "serializer");
        this.serializer = kSerializer;
        this.path = kSerializer.getDescriptor().getSerialName();
    }

    public RouteBuilder(String str, KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(str, "path");
        Intrinsics.checkNotNullParameter(kSerializer, "serializer");
        this.serializer = kSerializer;
        this.path = str;
    }

    public final String build() {
        return this.path + this.pathArgs + this.queryArgs;
    }

    private final void addPath(String str) {
        this.pathArgs += '/' + str;
    }

    private final void addQuery(String str, String str2) {
        this.queryArgs += (this.queryArgs.length() == 0 ? "?" : "&") + str + '=' + str2;
    }

    public final void appendPattern(int i, String str, NavType<Object> navType) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(navType, "type");
        int i2 = WhenMappings.$EnumSwitchMapping$0[computeParamType(i, navType).ordinal()];
        if (i2 == 1) {
            addPath("{" + str + '}');
        } else if (i2 == 2) {
            addQuery(str, "{" + str + '}');
        }
    }

    public final void appendArg(int i, String str, NavType<Object> navType, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(navType, "type");
        Intrinsics.checkNotNullParameter(list, "value");
        int i2 = WhenMappings.$EnumSwitchMapping$0[computeParamType(i, navType).ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                for (String addQuery : list) {
                    addQuery(str, addQuery);
                }
            }
        } else if (list.size() == 1) {
            addPath((String) CollectionsKt.first(list));
        } else {
            throw new IllegalArgumentException(("Expected one value for argument " + str + ", found " + list.size() + "values instead.").toString());
        }
    }

    private final ParamType computeParamType(int i, NavType<Object> navType) {
        if ((navType instanceof CollectionNavType) || this.serializer.getDescriptor().isElementOptional(i)) {
            return ParamType.QUERY;
        }
        return ParamType.PATH;
    }
}
