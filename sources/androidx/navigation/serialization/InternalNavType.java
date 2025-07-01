package androidx.navigation.serialization;

import android.os.Bundle;
import androidx.navigation.CollectionNavType;
import androidx.navigation.NavType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001:\u0003$%&B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u001f\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0007R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0007R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0019\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0007R\u0019\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0007R!\u0010\u001f\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010 0\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R!\u0010\"\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0007¨\u0006'"}, d2 = {"Landroidx/navigation/serialization/InternalNavType;", "", "()V", "BoolNullableType", "Landroidx/navigation/NavType;", "", "getBoolNullableType", "()Landroidx/navigation/NavType;", "DoubleArrayType", "", "getDoubleArrayType", "DoubleListType", "", "", "getDoubleListType", "DoubleNullableType", "getDoubleNullableType", "DoubleType", "getDoubleType", "FloatNullableType", "", "getFloatNullableType", "IntNullableType", "", "getIntNullableType", "LongNullableType", "", "getLongNullableType", "StringNonNullableType", "", "getStringNonNullableType", "StringNullableArrayType", "", "getStringNullableArrayType", "StringNullableListType", "getStringNullableListType", "EnumListType", "EnumNullableType", "SerializableNullableType", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavTypeConverter.kt */
public final class InternalNavType {
    private static final NavType<Boolean> BoolNullableType = new InternalNavType$BoolNullableType$1();
    private static final NavType<double[]> DoubleArrayType = new InternalNavType$DoubleArrayType$1();
    private static final NavType<List<Double>> DoubleListType = new InternalNavType$DoubleListType$1();
    private static final NavType<Double> DoubleNullableType = new InternalNavType$DoubleNullableType$1();
    private static final NavType<Double> DoubleType = new InternalNavType$DoubleType$1();
    private static final NavType<Float> FloatNullableType = new InternalNavType$FloatNullableType$1();
    public static final InternalNavType INSTANCE = new InternalNavType();
    private static final NavType<Integer> IntNullableType = new InternalNavType$IntNullableType$1();
    private static final NavType<Long> LongNullableType = new InternalNavType$LongNullableType$1();
    private static final NavType<String> StringNonNullableType = new InternalNavType$StringNonNullableType$1();
    private static final NavType<String[]> StringNullableArrayType = new InternalNavType$StringNullableArrayType$1();
    private static final NavType<List<String>> StringNullableListType = new InternalNavType$StringNullableListType$1();

    private InternalNavType() {
    }

    public final NavType<Integer> getIntNullableType() {
        return IntNullableType;
    }

    public final NavType<Boolean> getBoolNullableType() {
        return BoolNullableType;
    }

    public final NavType<Double> getDoubleType() {
        return DoubleType;
    }

    public final NavType<Double> getDoubleNullableType() {
        return DoubleNullableType;
    }

    public final NavType<Float> getFloatNullableType() {
        return FloatNullableType;
    }

    public final NavType<Long> getLongNullableType() {
        return LongNullableType;
    }

    public final NavType<String> getStringNonNullableType() {
        return StringNonNullableType;
    }

    public final NavType<String[]> getStringNullableArrayType() {
        return StringNullableArrayType;
    }

    public final NavType<List<String>> getStringNullableListType() {
        return StringNullableListType;
    }

    public final NavType<double[]> getDoubleArrayType() {
        return DoubleArrayType;
    }

    public final NavType<List<Double>> getDoubleListType() {
        return DoubleListType;
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u00040\u0003B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J!\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u001a\u001a\u00020\u000bH\u0016J(\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00020\u000b2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004H\u0016J(\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000b2\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004H\u0016J\u001e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004H\u0016J(\u0010\u001f\u001a\u00020\u00102\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00042\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004H\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006 "}, d2 = {"Landroidx/navigation/serialization/InternalNavType$EnumListType;", "D", "", "Landroidx/navigation/CollectionNavType;", "", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "enumNavType", "Landroidx/navigation/NavType$EnumType;", "name", "", "getName", "()Ljava/lang/String;", "emptyCollection", "equals", "", "other", "", "get", "bundle", "Landroid/os/Bundle;", "key", "hashCode", "", "parseValue", "value", "previousValue", "put", "", "serializeAsValues", "valueEquals", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NavTypeConverter.kt */
    public static final class EnumListType<D extends Enum<?>> extends CollectionNavType<List<? extends D>> {
        private final NavType.EnumType<D> enumNavType;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EnumListType(Class<D> cls) {
            super(true);
            Intrinsics.checkNotNullParameter(cls, "type");
            this.enumNavType = new NavType.EnumType<>(cls);
        }

        public String getName() {
            return "List<" + this.enumNavType.getName() + "}>";
        }

        public void put(Bundle bundle, String str, List<? extends D> list) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            bundle.putSerializable(str, list != null ? new ArrayList(list) : null);
        }

        public List<D> get(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            Object obj = bundle.get(str);
            if (obj instanceof List) {
                return (List) obj;
            }
            return null;
        }

        public List<D> parseValue(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            return CollectionsKt.listOf(this.enumNavType.parseValue(str));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
            r3 = kotlin.collections.CollectionsKt.plus(r3, parseValue(r2));
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.List<D> parseValue(java.lang.String r2, java.util.List<? extends D> r3) {
            /*
                r1 = this;
                java.lang.String r0 = "value"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                if (r3 == 0) goto L_0x0017
                java.util.Collection r3 = (java.util.Collection) r3
                java.util.List r0 = r1.parseValue((java.lang.String) r2)
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.util.List r3 = kotlin.collections.CollectionsKt.plus(r3, r0)
                if (r3 != 0) goto L_0x0016
                goto L_0x0017
            L_0x0016:
                return r3
            L_0x0017:
                java.util.List r2 = r1.parseValue((java.lang.String) r2)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.serialization.InternalNavType.EnumListType.parseValue(java.lang.String, java.util.List):java.util.List");
        }

        public boolean valueEquals(List<? extends D> list, List<? extends D> list2) {
            ArrayList arrayList = null;
            ArrayList arrayList2 = list != null ? new ArrayList(list) : null;
            if (list2 != null) {
                arrayList = new ArrayList(list2);
            }
            return Intrinsics.areEqual((Object) arrayList2, (Object) arrayList);
        }

        public List<String> serializeAsValues(List<? extends D> list) {
            if (list == null) {
                return CollectionsKt.emptyList();
            }
            Iterable<Enum> iterable = list;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (Enum enumR : iterable) {
                arrayList.add(enumR.toString());
            }
            return (List) arrayList;
        }

        public List<D> emptyCollection() {
            return CollectionsKt.emptyList();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EnumListType)) {
                return false;
            }
            return Intrinsics.areEqual((Object) this.enumNavType, (Object) ((EnumListType) obj).enumNavType);
        }

        public int hashCode() {
            return this.enumNavType.hashCode();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u00022\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0003B\u0015\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005¢\u0006\u0002\u0010\u0006J\u0017\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\rR\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/navigation/serialization/InternalNavType$EnumNullableType;", "D", "", "Landroidx/navigation/serialization/InternalNavType$SerializableNullableType;", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "name", "", "getName", "()Ljava/lang/String;", "parseValue", "value", "(Ljava/lang/String;)Ljava/lang/Enum;", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NavTypeConverter.kt */
    public static final class EnumNullableType<D extends Enum<?>> extends SerializableNullableType<D> {
        private final Class<D> type;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EnumNullableType(Class<D> cls) {
            super(cls);
            Intrinsics.checkNotNullParameter(cls, "type");
            if (cls.isEnum()) {
                this.type = cls;
                return;
            }
            throw new IllegalArgumentException((cls + " is not an Enum type.").toString());
        }

        public String getName() {
            String name = this.type.getName();
            Intrinsics.checkNotNullExpressionValue(name, "type.name");
            return name;
        }

        public D parseValue(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            D d = null;
            if (Intrinsics.areEqual((Object) str, (Object) "null")) {
                return null;
            }
            D[] enumConstants = this.type.getEnumConstants();
            Intrinsics.checkNotNull(enumConstants);
            int length = enumConstants.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                D d2 = enumConstants[i];
                Enum enumR = (Enum) d2;
                Intrinsics.checkNotNull(enumR);
                if (StringsKt.equals(enumR.name(), str, true)) {
                    d = d2;
                    break;
                }
                i++;
            }
            D d3 = (Enum) d;
            if (d3 != null) {
                return d3;
            }
            throw new IllegalArgumentException("Enum value " + str + " not found for type " + this.type.getName() + '.');
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0003B\u0015\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J \u0010\u000f\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0017\u0010\u0016\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\u0018J'\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u001bR\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/navigation/serialization/InternalNavType$SerializableNullableType;", "D", "Ljava/io/Serializable;", "Landroidx/navigation/NavType;", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "get", "bundle", "Landroid/os/Bundle;", "key", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/io/Serializable;", "hashCode", "", "parseValue", "value", "(Ljava/lang/String;)Ljava/io/Serializable;", "put", "", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/io/Serializable;)V", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NavTypeConverter.kt */
    public static class SerializableNullableType<D extends Serializable> extends NavType<D> {
        private final Class<D> type;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SerializableNullableType(Class<D> cls) {
            super(true);
            Intrinsics.checkNotNullParameter(cls, "type");
            this.type = cls;
            if (!Serializable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
            }
        }

        public String getName() {
            String name = this.type.getName();
            Intrinsics.checkNotNullExpressionValue(name, "type.name");
            return name;
        }

        public void put(Bundle bundle, String str, D d) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            bundle.putSerializable(str, (Serializable) this.type.cast(d));
        }

        public D get(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            D d = bundle.get(str);
            if (d instanceof Serializable) {
                return (Serializable) d;
            }
            return null;
        }

        public D parseValue(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SerializableNullableType)) {
                return false;
            }
            return Intrinsics.areEqual((Object) this.type, (Object) ((SerializableNullableType) obj).type);
        }

        public int hashCode() {
            return this.type.hashCode();
        }
    }
}
