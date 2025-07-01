package androidx.navigation.serialization;

import androidx.navigation.NavType;
import androidx.navigation.serialization.InternalNavType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.internal.CollectionDescriptorsKt;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u0002H\u0002\u001a\u0010\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004*\u00020\u0002H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a\f\u0010\t\u001a\u00020\n*\u00020\u0002H\u0002¨\u0006\u000b"}, d2 = {"getClass", "Ljava/lang/Class;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getNavType", "Landroidx/navigation/NavType;", "matchKType", "", "kType", "Lkotlin/reflect/KType;", "toInternalType", "Landroidx/navigation/serialization/InternalType;", "navigation-common_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavTypeConverter.kt */
public final class NavTypeConverterKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NavTypeConverter.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(45:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|45) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0082 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x008c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0096 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00be */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00c8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                androidx.navigation.serialization.InternalType[] r0 = androidx.navigation.serialization.InternalType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.INT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.BOOL     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.LONG     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.STRING     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.STRING_NULLABLE     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.ENUM     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.INT_NULLABLE     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.BOOL_NULLABLE     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.DOUBLE_NULLABLE     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.FLOAT_NULLABLE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.LONG_NULLABLE     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.INT_ARRAY     // Catch:{ NoSuchFieldError -> 0x008c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008c }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008c }
            L_0x008c:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.BOOL_ARRAY     // Catch:{ NoSuchFieldError -> 0x0096 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0096 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0096 }
            L_0x0096:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.DOUBLE_ARRAY     // Catch:{ NoSuchFieldError -> 0x00a0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a0 }
            L_0x00a0:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.FLOAT_ARRAY     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.LONG_ARRAY     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.ARRAY     // Catch:{ NoSuchFieldError -> 0x00be }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00be }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00be }
            L_0x00be:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.LIST     // Catch:{ NoSuchFieldError -> 0x00c8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c8 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c8 }
            L_0x00c8:
                androidx.navigation.serialization.InternalType r1 = androidx.navigation.serialization.InternalType.ENUM_NULLABLE     // Catch:{ NoSuchFieldError -> 0x00d2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d2 }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d2 }
            L_0x00d2:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.serialization.NavTypeConverterKt.WhenMappings.<clinit>():void");
        }
    }

    public static final NavType<?> getNavType(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[toInternalType(serialDescriptor).ordinal()]) {
            case 1:
                return NavType.IntType;
            case 2:
                return NavType.BoolType;
            case 3:
                return NavType.FloatType;
            case 4:
                return NavType.LongType;
            case 5:
                return InternalNavType.INSTANCE.getStringNonNullableType();
            case 6:
                return NavType.StringType;
            case 7:
                NavType<?> parseSerializableOrParcelableType$navigation_common_release = NavType.Companion.parseSerializableOrParcelableType$navigation_common_release(getClass(serialDescriptor), false);
                return parseSerializableOrParcelableType$navigation_common_release == null ? UNKNOWN.INSTANCE : parseSerializableOrParcelableType$navigation_common_release;
            case 8:
                return InternalNavType.INSTANCE.getIntNullableType();
            case 9:
                return InternalNavType.INSTANCE.getBoolNullableType();
            case 10:
                return InternalNavType.INSTANCE.getDoubleType();
            case 11:
                return InternalNavType.INSTANCE.getDoubleNullableType();
            case 12:
                return InternalNavType.INSTANCE.getFloatNullableType();
            case 13:
                return InternalNavType.INSTANCE.getLongNullableType();
            case 14:
                return NavType.IntArrayType;
            case 15:
                return NavType.BoolArrayType;
            case 16:
                return InternalNavType.INSTANCE.getDoubleArrayType();
            case 17:
                return NavType.FloatArrayType;
            case 18:
                return NavType.LongArrayType;
            case 19:
                return toInternalType(serialDescriptor.getElementDescriptor(0)) == InternalType.STRING ? NavType.StringArrayType : UNKNOWN.INSTANCE;
            case 20:
                switch (WhenMappings.$EnumSwitchMapping$0[toInternalType(serialDescriptor.getElementDescriptor(0)).ordinal()]) {
                    case 1:
                        return NavType.IntListType;
                    case 2:
                        return NavType.BoolListType;
                    case 3:
                        return NavType.FloatListType;
                    case 4:
                        return NavType.LongListType;
                    case 5:
                        return NavType.StringListType;
                    case 6:
                        return InternalNavType.INSTANCE.getStringNullableListType();
                    case 7:
                        Class<?> cls = getClass(serialDescriptor.getElementDescriptor(0));
                        Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<kotlin.Enum<*>>");
                        return new InternalNavType.EnumListType<>(cls);
                    default:
                        return UNKNOWN.INSTANCE;
                }
            case 21:
                Class<?> cls2 = getClass(serialDescriptor);
                if (!Enum.class.isAssignableFrom(cls2)) {
                    return UNKNOWN.INSTANCE;
                }
                Intrinsics.checkNotNull(cls2, "null cannot be cast to non-null type java.lang.Class<kotlin.Enum<*>?>");
                return new InternalNavType.EnumNullableType<>(cls2);
            default:
                return UNKNOWN.INSTANCE;
        }
    }

    private static final InternalType toInternalType(SerialDescriptor serialDescriptor) {
        String replace$default = StringsKt.replace$default(serialDescriptor.getSerialName(), "?", "", false, 4, (Object) null);
        if (Intrinsics.areEqual((Object) serialDescriptor.getKind(), (Object) SerialKind.ENUM.INSTANCE)) {
            return serialDescriptor.isNullable() ? InternalType.ENUM_NULLABLE : InternalType.ENUM;
        }
        if (Intrinsics.areEqual((Object) replace$default, (Object) "kotlin.Int")) {
            return serialDescriptor.isNullable() ? InternalType.INT_NULLABLE : InternalType.INT;
        }
        if (Intrinsics.areEqual((Object) replace$default, (Object) "kotlin.Boolean")) {
            return serialDescriptor.isNullable() ? InternalType.BOOL_NULLABLE : InternalType.BOOL;
        }
        if (Intrinsics.areEqual((Object) replace$default, (Object) "kotlin.Double")) {
            return serialDescriptor.isNullable() ? InternalType.DOUBLE_NULLABLE : InternalType.DOUBLE;
        }
        if (Intrinsics.areEqual((Object) replace$default, (Object) "kotlin.Double")) {
            return InternalType.DOUBLE;
        }
        if (Intrinsics.areEqual((Object) replace$default, (Object) "kotlin.Float")) {
            return serialDescriptor.isNullable() ? InternalType.FLOAT_NULLABLE : InternalType.FLOAT;
        }
        if (Intrinsics.areEqual((Object) replace$default, (Object) "kotlin.Long")) {
            return serialDescriptor.isNullable() ? InternalType.LONG_NULLABLE : InternalType.LONG;
        }
        if (Intrinsics.areEqual((Object) replace$default, (Object) "kotlin.String")) {
            return serialDescriptor.isNullable() ? InternalType.STRING_NULLABLE : InternalType.STRING;
        }
        if (Intrinsics.areEqual((Object) replace$default, (Object) "kotlin.IntArray")) {
            return InternalType.INT_ARRAY;
        }
        if (Intrinsics.areEqual((Object) replace$default, (Object) "kotlin.DoubleArray")) {
            return InternalType.DOUBLE_ARRAY;
        }
        if (Intrinsics.areEqual((Object) replace$default, (Object) "kotlin.BooleanArray")) {
            return InternalType.BOOL_ARRAY;
        }
        if (Intrinsics.areEqual((Object) replace$default, (Object) "kotlin.FloatArray")) {
            return InternalType.FLOAT_ARRAY;
        }
        if (Intrinsics.areEqual((Object) replace$default, (Object) "kotlin.LongArray")) {
            return InternalType.LONG_ARRAY;
        }
        if (Intrinsics.areEqual((Object) replace$default, (Object) CollectionDescriptorsKt.ARRAY_NAME)) {
            return InternalType.ARRAY;
        }
        if (StringsKt.startsWith$default(replace$default, CollectionDescriptorsKt.ARRAY_LIST_NAME, false, 2, (Object) null)) {
            return InternalType.LIST;
        }
        return InternalType.UNKNOWN;
    }

    private static final Class<?> getClass(SerialDescriptor serialDescriptor) {
        String replace$default = StringsKt.replace$default(serialDescriptor.getSerialName(), "?", "", false, 4, (Object) null);
        try {
            Class<?> cls = Class.forName(replace$default);
            Intrinsics.checkNotNullExpressionValue(cls, "forName(className)");
            return cls;
        } catch (ClassNotFoundException unused) {
            while (true) {
                CharSequence charSequence = replace$default;
                if (StringsKt.contains$default(charSequence, (CharSequence) ".", false, 2, (Object) null)) {
                    replace$default = new Regex("(\\.+)(?!.*\\.)").replace(charSequence, "\\$");
                    Class<?> cls2 = Class.forName(replace$default);
                    Intrinsics.checkNotNullExpressionValue(cls2, "forName(className)");
                    return cls2;
                }
                throw new IllegalArgumentException("Cannot find class with name \"" + serialDescriptor.getSerialName() + "\". Ensure that the serialName for this argument is the default fully qualified name");
            }
        }
    }

    public static final boolean matchKType(SerialDescriptor serialDescriptor, KType kType) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(kType, "kType");
        if (serialDescriptor.isNullable() != kType.isMarkedNullable()) {
            return false;
        }
        KSerializer<Object> serializerOrNull = SerializersKt.serializerOrNull(kType);
        if (serializerOrNull != null) {
            return Intrinsics.areEqual((Object) serialDescriptor, (Object) serializerOrNull.getDescriptor());
        }
        throw new IllegalStateException("Custom serializers declared directly on a class field via @Serializable(with = ...) is currently not supported by safe args for both custom types and third-party types. Please use @Serializable or @Serializable(with = ...) on the class or object declaration.".toString());
    }
}
