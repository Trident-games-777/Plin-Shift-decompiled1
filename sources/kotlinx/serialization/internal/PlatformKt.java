package kotlinx.serialization.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Polymorphic;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationException;

@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aK\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\"\u0010\u0005\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0006\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0002¢\u0006\u0002\u0010\u0007\u001aO\u0010\b\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\"\u0010\u0005\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0006\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0002¢\u0006\u0002\u0010\u000b\u001a\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u0000\u001a\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u0003*\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002\u001a$\u0010\u0013\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u000fH\u0000\u001aM\u0010\u0014\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\n2\"\u0010\u0005\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0006\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0000¢\u0006\u0002\u0010\u000b\u001aM\u0010\u0014\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\"\u0010\u0005\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0006\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0000¢\u0006\u0002\u0010\u0015\u001a\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\nH\u0002\u001aM\u0010\u0017\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\n2\"\u0010\u0005\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0006\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0002¢\u0006\u0002\u0010\u000b\u001a\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0003\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\nH\u0002\u001a$\u0010\u0019\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\nH\u0002\u001a&\u0010\u001a\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001cH\b¢\u0006\u0002\u0010\u001d\u001a\u0015\u0010\u001a\u001a\u00020\r*\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001cH\b\u001a$\u0010\u001f\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\nH\u0002\u001a\u001c\u0010 \u001a\u00020\r\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\nH\u0002\u001a\u001c\u0010!\u001a\u00020\r\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\nH\u0002\u001a\u0010\u0010\"\u001a\u00020#*\u0006\u0012\u0002\b\u00030\u000fH\u0000\u001a\u0010\u0010$\u001a\u00020#*\u0006\u0012\u0002\b\u00030\nH\u0000\u001aK\u0010%\u001a\b\u0012\u0004\u0012\u0002H&0\u0006\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\n\b\u0001\u0010&*\u0004\u0018\u0001H\u0002*\u0012\u0012\u0004\u0012\u0002H&0'j\b\u0012\u0004\u0012\u0002H&`(2\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000fH\u0000¢\u0006\u0002\u0010*¨\u0006+"}, d2 = {"invokeSerializerOnCompanion", "Lkotlinx/serialization/KSerializer;", "T", "", "companion", "args", "", "(Ljava/lang/Object;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "invokeSerializerOnDefaultCompanion", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "isReferenceArray", "", "rootClass", "Lkotlin/reflect/KClass;", "companionOrNull", "companionName", "", "compiledSerializerImpl", "constructSerializerForGivenTypeArgs", "(Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "createEnumSerializer", "findInNamedCompanion", "findNamedCompanionByAnnotation", "findObjectSerializer", "getChecked", "index", "", "([Ljava/lang/Object;I)Ljava/lang/Object;", "", "interfaceSerializer", "isNotAnnotated", "isPolymorphicSerializer", "platformSpecificSerializerNotRegistered", "", "serializerNotRegistered", "toNativeArrayImpl", "E", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "eClass", "(Ljava/util/ArrayList;Lkotlin/reflect/KClass;)[Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: Platform.kt */
public final class PlatformKt {
    public static final <T> T getChecked(T[] tArr, int i) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr[i];
    }

    public static final boolean getChecked(boolean[] zArr, int i) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr[i];
    }

    public static final <T> KSerializer<T> compiledSerializerImpl(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        return constructSerializerForGivenTypeArgs(kClass, (KSerializer<Object>[]) new KSerializer[0]);
    }

    public static final <T, E extends T> E[] toNativeArrayImpl(ArrayList<E> arrayList, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "eClass");
        Object newInstance = Array.newInstance(JvmClassMappingKt.getJavaClass(kClass), arrayList.size());
        Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Array<E of kotlinx.serialization.internal.PlatformKt.toNativeArrayImpl>");
        E[] array = arrayList.toArray((Object[]) newInstance);
        Intrinsics.checkNotNullExpressionValue(array, "toArray(...)");
        return array;
    }

    public static final Void platformSpecificSerializerNotRegistered(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Platform_commonKt.serializerNotRegistered(kClass);
        throw new KotlinNothingValueException();
    }

    public static final Void serializerNotRegistered(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        throw new SerializationException(Platform_commonKt.notRegisteredMessage(JvmClassMappingKt.getKotlinClass(cls)));
    }

    public static final <T> KSerializer<T> constructSerializerForGivenTypeArgs(KClass<T> kClass, KSerializer<Object>... kSerializerArr) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(kSerializerArr, "args");
        return constructSerializerForGivenTypeArgs(JvmClassMappingKt.getJavaClass(kClass), (KSerializer<Object>[]) (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length));
    }

    public static final <T> KSerializer<T> constructSerializerForGivenTypeArgs(Class<T> cls, KSerializer<Object>... kSerializerArr) {
        KSerializer<T> interfaceSerializer;
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Intrinsics.checkNotNullParameter(kSerializerArr, "args");
        if (cls.isEnum() && isNotAnnotated(cls)) {
            return createEnumSerializer(cls);
        }
        if (cls.isInterface() && (interfaceSerializer = interfaceSerializer(cls)) != null) {
            return interfaceSerializer;
        }
        KSerializer<T> invokeSerializerOnDefaultCompanion = invokeSerializerOnDefaultCompanion(cls, (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length));
        if (invokeSerializerOnDefaultCompanion != null) {
            return invokeSerializerOnDefaultCompanion;
        }
        KSerializer<T> findObjectSerializer = findObjectSerializer(cls);
        if (findObjectSerializer != null) {
            return findObjectSerializer;
        }
        KSerializer<T> findInNamedCompanion = findInNamedCompanion(cls, (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length));
        if (findInNamedCompanion != null) {
            return findInNamedCompanion;
        }
        if (isPolymorphicSerializer(cls)) {
            return new PolymorphicSerializer<>(JvmClassMappingKt.getKotlinClass(cls));
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
        if (r2 == false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0046, code lost:
        r7 = r3.getField("INSTANCE");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <T> kotlinx.serialization.KSerializer<T> findInNamedCompanion(java.lang.Class<T> r7, kotlinx.serialization.KSerializer<java.lang.Object>... r8) {
        /*
            java.lang.Object r0 = findNamedCompanionByAnnotation(r7)
            if (r0 == 0) goto L_0x0014
            int r1 = r8.length
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r1)
            kotlinx.serialization.KSerializer[] r8 = (kotlinx.serialization.KSerializer[]) r8
            kotlinx.serialization.KSerializer r8 = invokeSerializerOnCompanion(r0, r8)
            if (r8 == 0) goto L_0x0014
            return r8
        L_0x0014:
            r8 = 0
            java.lang.Class[] r7 = r7.getDeclaredClasses()     // Catch:{ NoSuchFieldException -> 0x005b }
            java.lang.String r0 = "getDeclaredClasses(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)     // Catch:{ NoSuchFieldException -> 0x005b }
            java.lang.Object[] r7 = (java.lang.Object[]) r7     // Catch:{ NoSuchFieldException -> 0x005b }
            int r0 = r7.length     // Catch:{ NoSuchFieldException -> 0x005b }
            r1 = 0
            r3 = r8
            r2 = r1
        L_0x0024:
            if (r1 >= r0) goto L_0x003f
            r4 = r7[r1]     // Catch:{ NoSuchFieldException -> 0x005b }
            r5 = r4
            java.lang.Class r5 = (java.lang.Class) r5     // Catch:{ NoSuchFieldException -> 0x005b }
            java.lang.String r5 = r5.getSimpleName()     // Catch:{ NoSuchFieldException -> 0x005b }
            java.lang.String r6 = "$serializer"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)     // Catch:{ NoSuchFieldException -> 0x005b }
            if (r5 == 0) goto L_0x003c
            if (r2 == 0) goto L_0x003a
            goto L_0x0041
        L_0x003a:
            r2 = 1
            r3 = r4
        L_0x003c:
            int r1 = r1 + 1
            goto L_0x0024
        L_0x003f:
            if (r2 != 0) goto L_0x0042
        L_0x0041:
            r3 = r8
        L_0x0042:
            java.lang.Class r3 = (java.lang.Class) r3     // Catch:{ NoSuchFieldException -> 0x005b }
            if (r3 == 0) goto L_0x0053
            java.lang.String r7 = "INSTANCE"
            java.lang.reflect.Field r7 = r3.getField(r7)     // Catch:{ NoSuchFieldException -> 0x005b }
            if (r7 == 0) goto L_0x0053
            java.lang.Object r7 = r7.get(r8)     // Catch:{ NoSuchFieldException -> 0x005b }
            goto L_0x0054
        L_0x0053:
            r7 = r8
        L_0x0054:
            boolean r0 = r7 instanceof kotlinx.serialization.KSerializer     // Catch:{ NoSuchFieldException -> 0x005b }
            if (r0 == 0) goto L_0x005b
            kotlinx.serialization.KSerializer r7 = (kotlinx.serialization.KSerializer) r7     // Catch:{ NoSuchFieldException -> 0x005b }
            return r7
        L_0x005b:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.PlatformKt.findInNamedCompanion(java.lang.Class, kotlinx.serialization.KSerializer[]):kotlinx.serialization.KSerializer");
    }

    private static final <T> Object findNamedCompanionByAnnotation(Class<T> cls) {
        Class cls2;
        Class[] declaredClasses = cls.getDeclaredClasses();
        Intrinsics.checkNotNullExpressionValue(declaredClasses, "getDeclaredClasses(...)");
        Object[] objArr = (Object[]) declaredClasses;
        int length = objArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                cls2 = null;
                break;
            }
            cls2 = objArr[i];
            if (((Class) cls2).getAnnotation(NamedCompanion.class) != null) {
                break;
            }
            i++;
        }
        Class cls3 = cls2;
        if (cls3 == null) {
            return null;
        }
        String simpleName = cls3.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        return companionOrNull(cls, simpleName);
    }

    private static final <T> boolean isNotAnnotated(Class<T> cls) {
        return cls.getAnnotation(Serializable.class) == null && cls.getAnnotation(Polymorphic.class) == null;
    }

    private static final <T> boolean isPolymorphicSerializer(Class<T> cls) {
        if (cls.getAnnotation(Polymorphic.class) != null) {
            return true;
        }
        Serializable serializable = (Serializable) cls.getAnnotation(Serializable.class);
        if (serializable == null || !Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(serializable.with()), (Object) Reflection.getOrCreateKotlinClass(PolymorphicSerializer.class))) {
            return false;
        }
        return true;
    }

    private static final <T> KSerializer<T> interfaceSerializer(Class<T> cls) {
        Serializable serializable = (Serializable) cls.getAnnotation(Serializable.class);
        if (serializable == null || Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(serializable.with()), (Object) Reflection.getOrCreateKotlinClass(PolymorphicSerializer.class))) {
            return new PolymorphicSerializer<>(JvmClassMappingKt.getKotlinClass(cls));
        }
        return null;
    }

    private static final <T> KSerializer<T> invokeSerializerOnDefaultCompanion(Class<?> cls, KSerializer<Object>... kSerializerArr) {
        Object companionOrNull = companionOrNull(cls, "Companion");
        if (companionOrNull == null) {
            return null;
        }
        return invokeSerializerOnCompanion(companionOrNull, (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length));
    }

    private static final <T> KSerializer<T> invokeSerializerOnCompanion(Object obj, KSerializer<Object>... kSerializerArr) {
        Class[] clsArr;
        try {
            if (kSerializerArr.length == 0) {
                clsArr = new Class[0];
            } else {
                int length = kSerializerArr.length;
                Class[] clsArr2 = new Class[length];
                for (int i = 0; i < length; i++) {
                    clsArr2[i] = KSerializer.class;
                }
                clsArr = clsArr2;
            }
            Object invoke = obj.getClass().getDeclaredMethod("serializer", (Class[]) Arrays.copyOf(clsArr, clsArr.length)).invoke(obj, Arrays.copyOf(kSerializerArr, kSerializerArr.length));
            if (invoke instanceof KSerializer) {
                return (KSerializer) invoke;
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause != null) {
                String message = cause.getMessage();
                if (message == null) {
                    message = e.getMessage();
                }
                throw new InvocationTargetException(cause, message);
            }
            throw e;
        }
    }

    private static final Object companionOrNull(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get((Object) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static final <T> KSerializer<T> createEnumSerializer(Class<T> cls) {
        Object[] enumConstants = cls.getEnumConstants();
        String canonicalName = cls.getCanonicalName();
        Intrinsics.checkNotNullExpressionValue(canonicalName, "getCanonicalName(...)");
        Intrinsics.checkNotNull(enumConstants, "null cannot be cast to non-null type kotlin.Array<out kotlin.Enum<*>>");
        return new EnumSerializer<>(canonicalName, (Enum[]) enumConstants);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005a, code lost:
        if (r5 == false) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00aa, code lost:
        if (r5 == false) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ac, code lost:
        r6 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <T> kotlinx.serialization.KSerializer<T> findObjectSerializer(java.lang.Class<T> r12) {
        /*
            java.lang.String r0 = r12.getCanonicalName()
            r1 = 0
            if (r0 == 0) goto L_0x00bf
            java.lang.String r2 = "java."
            r3 = 0
            r4 = 2
            boolean r2 = kotlin.text.StringsKt.startsWith$default(r0, r2, r3, r4, r1)
            if (r2 != 0) goto L_0x00bf
            java.lang.String r2 = "kotlin."
            boolean r0 = kotlin.text.StringsKt.startsWith$default(r0, r2, r3, r4, r1)
            if (r0 == 0) goto L_0x001b
            goto L_0x00bf
        L_0x001b:
            java.lang.reflect.Field[] r0 = r12.getDeclaredFields()
            java.lang.String r2 = "getDeclaredFields(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            int r2 = r0.length
            r6 = r1
            r4 = r3
            r5 = r4
        L_0x002a:
            r7 = 1
            if (r4 >= r2) goto L_0x005a
            r8 = r0[r4]
            r9 = r8
            java.lang.reflect.Field r9 = (java.lang.reflect.Field) r9
            java.lang.String r10 = r9.getName()
            java.lang.String r11 = "INSTANCE"
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)
            if (r10 == 0) goto L_0x0057
            java.lang.Class r10 = r9.getType()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r10 == 0) goto L_0x0057
            int r9 = r9.getModifiers()
            boolean r9 = java.lang.reflect.Modifier.isStatic(r9)
            if (r9 == 0) goto L_0x0057
            if (r5 == 0) goto L_0x0055
            goto L_0x005c
        L_0x0055:
            r5 = r7
            r6 = r8
        L_0x0057:
            int r4 = r4 + 1
            goto L_0x002a
        L_0x005a:
            if (r5 != 0) goto L_0x005d
        L_0x005c:
            r6 = r1
        L_0x005d:
            java.lang.reflect.Field r6 = (java.lang.reflect.Field) r6
            if (r6 != 0) goto L_0x0062
            return r1
        L_0x0062:
            java.lang.Object r0 = r6.get(r1)
            java.lang.reflect.Method[] r12 = r12.getMethods()
            java.lang.String r2 = "getMethods(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r2)
            java.lang.Object[] r12 = (java.lang.Object[]) r12
            int r2 = r12.length
            r6 = r1
            r4 = r3
            r5 = r4
        L_0x0075:
            if (r4 >= r2) goto L_0x00aa
            r8 = r12[r4]
            r9 = r8
            java.lang.reflect.Method r9 = (java.lang.reflect.Method) r9
            java.lang.String r10 = r9.getName()
            java.lang.String r11 = "serializer"
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)
            if (r10 == 0) goto L_0x00a7
            java.lang.Class[] r10 = r9.getParameterTypes()
            java.lang.String r11 = "getParameterTypes(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            java.lang.Object[] r10 = (java.lang.Object[]) r10
            int r10 = r10.length
            if (r10 != 0) goto L_0x00a7
            java.lang.Class r9 = r9.getReturnType()
            java.lang.Class<kotlinx.serialization.KSerializer> r10 = kotlinx.serialization.KSerializer.class
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
            if (r9 == 0) goto L_0x00a7
            if (r5 == 0) goto L_0x00a5
            goto L_0x00ac
        L_0x00a5:
            r5 = r7
            r6 = r8
        L_0x00a7:
            int r4 = r4 + 1
            goto L_0x0075
        L_0x00aa:
            if (r5 != 0) goto L_0x00ad
        L_0x00ac:
            r6 = r1
        L_0x00ad:
            java.lang.reflect.Method r6 = (java.lang.reflect.Method) r6
            if (r6 != 0) goto L_0x00b2
            return r1
        L_0x00b2:
            java.lang.Object[] r12 = new java.lang.Object[r3]
            java.lang.Object r12 = r6.invoke(r0, r12)
            boolean r0 = r12 instanceof kotlinx.serialization.KSerializer
            if (r0 == 0) goto L_0x00bf
            kotlinx.serialization.KSerializer r12 = (kotlinx.serialization.KSerializer) r12
            return r12
        L_0x00bf:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.PlatformKt.findObjectSerializer(java.lang.Class):kotlinx.serialization.KSerializer");
    }

    public static final boolean isReferenceArray(KClass<Object> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "rootClass");
        return JvmClassMappingKt.getJavaClass(kClass).isArray();
    }
}
