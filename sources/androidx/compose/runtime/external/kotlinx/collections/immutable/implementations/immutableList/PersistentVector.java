package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import java.util.Arrays;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010*\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B5\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u001b\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0011J#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u001d\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0016J\u0016\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0002\u0010\u0019JG\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\u001dH\u0002¢\u0006\u0002\u0010\u001eJ5\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010 \u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010!J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010\u0012\u001a\u00020\tH\u0016J?\u0010$\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u001dH\u0002¢\u0006\u0002\u0010&J3\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010(\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0002¢\u0006\u0002\u0010)JC\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0002¢\u0006\u0002\u0010-J?\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u0006\u0010\u001b\u001a\u00020\t2\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0002¢\u0006\u0002\u0010/J\"\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020302H\u0016J\u0016\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0012\u001a\u00020\tH\u0016J=\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u001dH\u0002¢\u0006\u0002\u0010&J;\u00106\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010(\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0002\u00107J\b\u0010(\u001a\u00020\tH\u0002J#\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J?\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\b\u0010:\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010;R\u0018\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006<"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVector;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractPersistentList;", "root", "", "", "tail", "size", "", "rootShift", "([Ljava/lang/Object;[Ljava/lang/Object;II)V", "[Ljava/lang/Object;", "getSize", "()I", "add", "element", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "index", "(ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "bufferFor", "(I)[Ljava/lang/Object;", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorBuilder;", "get", "(I)Ljava/lang/Object;", "insertIntoRoot", "shift", "elementCarry", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;", "([Ljava/lang/Object;IILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "insertIntoTail", "tailIndex", "([Ljava/lang/Object;ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVector;", "listIterator", "", "pullLastBuffer", "tailCarry", "([Ljava/lang/Object;IILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "pullLastBufferFromRoot", "rootSize", "([Ljava/lang/Object;II)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "pushFilledTail", "filledTail", "newTail", "([Ljava/lang/Object;[Ljava/lang/Object;[Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVector;", "pushTail", "([Ljava/lang/Object;I[Ljava/lang/Object;)[Ljava/lang/Object;", "removeAll", "predicate", "Lkotlin/Function1;", "", "removeAt", "removeFromRootAt", "removeFromTailAt", "([Ljava/lang/Object;III)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "set", "setInRoot", "e", "([Ljava/lang/Object;IILjava/lang/Object;)[Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PersistentVector.kt */
public final class PersistentVector<E> extends AbstractPersistentList<E> implements PersistentList<E> {
    public static final int $stable = 8;
    private final Object[] root;
    private final int rootShift;
    private final int size;
    private final Object[] tail;

    public int getSize() {
        return this.size;
    }

    public PersistentVector(Object[] objArr, Object[] objArr2, int i, int i2) {
        this.root = objArr;
        this.tail = objArr2;
        this.size = i;
        this.rootShift = i2;
        boolean z = true;
        if (!(size() > 32)) {
            PreconditionsKt.throwIllegalArgumentException("Trie-based persistent vector should have at least 33 elements, got " + size());
        }
        CommonFunctionsKt.m3801assert(size() - UtilsKt.rootSize(size()) > RangesKt.coerceAtMost(objArr2.length, 32) ? false : z);
    }

    private final int rootSize() {
        return UtilsKt.rootSize(size());
    }

    public PersistentList<E> add(E e) {
        int size2 = size() - rootSize();
        if (size2 < 32) {
            Object[] copyOf = Arrays.copyOf(this.tail, 32);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            copyOf[size2] = e;
            return new PersistentVector<>(this.root, copyOf, size() + 1, this.rootShift);
        }
        return pushFilledTail(this.root, this.tail, UtilsKt.presizedBufferWith(e));
    }

    private final PersistentVector<E> pushFilledTail(Object[] objArr, Object[] objArr2, Object[] objArr3) {
        int size2 = size() >> 5;
        int i = this.rootShift;
        if (size2 <= (1 << i)) {
            return new PersistentVector<>(pushTail(objArr, i, objArr2), objArr3, size() + 1, this.rootShift);
        }
        Object[] presizedBufferWith = UtilsKt.presizedBufferWith(objArr);
        int i2 = this.rootShift + 5;
        return new PersistentVector<>(pushTail(presizedBufferWith, i2, objArr2), objArr3, size() + 1, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0017, code lost:
        if (r4 == null) goto L_0x0019;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object[] pushTail(java.lang.Object[] r4, int r5, java.lang.Object[] r6) {
        /*
            r3 = this;
            int r0 = r3.size()
            int r0 = r0 + -1
            int r0 = androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.UtilsKt.indexSegment(r0, r5)
            r1 = 32
            if (r4 == 0) goto L_0x0019
            java.lang.Object[] r4 = java.util.Arrays.copyOf(r4, r1)
            java.lang.String r2 = "copyOf(this, newSize)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
            if (r4 != 0) goto L_0x001b
        L_0x0019:
            java.lang.Object[] r4 = new java.lang.Object[r1]
        L_0x001b:
            r1 = 5
            if (r5 != r1) goto L_0x0021
            r4[r0] = r6
            return r4
        L_0x0021:
            r2 = r4[r0]
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            int r5 = r5 - r1
            java.lang.Object[] r5 = r3.pushTail(r2, r5, r6)
            r4[r0] = r5
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.PersistentVector.pushTail(java.lang.Object[], int, java.lang.Object[]):java.lang.Object[]");
    }

    public PersistentList<E> add(int i, E e) {
        ListImplementation.checkPositionIndex$runtime_release(i, size());
        if (i == size()) {
            return add((Object) e);
        }
        int rootSize = rootSize();
        if (i >= rootSize) {
            return insertIntoTail(this.root, i - rootSize, e);
        }
        ObjectRef objectRef = new ObjectRef((Object) null);
        return insertIntoTail(insertIntoRoot(this.root, this.rootShift, i, e, objectRef), 0, objectRef.getValue());
    }

    private final PersistentVector<E> insertIntoTail(Object[] objArr, int i, Object obj) {
        int size2 = size() - rootSize();
        Object[] copyOf = Arrays.copyOf(this.tail, 32);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        if (size2 < 32) {
            ArraysKt.copyInto((T[]) this.tail, (T[]) copyOf, i + 1, i, size2);
            copyOf[i] = obj;
            return new PersistentVector<>(objArr, copyOf, size() + 1, this.rootShift);
        }
        Object[] objArr2 = this.tail;
        Object obj2 = objArr2[31];
        ArraysKt.copyInto((T[]) objArr2, (T[]) copyOf, i + 1, i, size2 - 1);
        copyOf[i] = obj;
        return pushFilledTail(objArr, copyOf, UtilsKt.presizedBufferWith(obj2));
    }

    private final Object[] insertIntoRoot(Object[] objArr, int i, int i2, Object obj, ObjectRef objectRef) {
        Object[] objArr2;
        int indexSegment = UtilsKt.indexSegment(i2, i);
        if (i == 0) {
            if (indexSegment == 0) {
                objArr2 = new Object[32];
            } else {
                objArr2 = Arrays.copyOf(objArr, 32);
                Intrinsics.checkNotNullExpressionValue(objArr2, "copyOf(this, newSize)");
            }
            ArraysKt.copyInto((T[]) objArr, (T[]) objArr2, indexSegment + 1, indexSegment, 31);
            objectRef.setValue(objArr[31]);
            objArr2[indexSegment] = obj;
            return objArr2;
        }
        Object[] copyOf = Arrays.copyOf(objArr, 32);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        int i3 = i - 5;
        Object[] objArr3 = objArr[indexSegment];
        Intrinsics.checkNotNull(objArr3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        ObjectRef objectRef2 = objectRef;
        copyOf[indexSegment] = insertIntoRoot(objArr3, i3, i2, obj, objectRef2);
        while (true) {
            indexSegment++;
            if (indexSegment >= 32 || copyOf[indexSegment] == null) {
                return copyOf;
            }
            Object[] objArr4 = objArr[indexSegment];
            Intrinsics.checkNotNull(objArr4, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            copyOf[indexSegment] = insertIntoRoot(objArr4, i3, 0, objectRef2.getValue(), objectRef2);
        }
        return copyOf;
    }

    public PersistentList<E> removeAt(int i) {
        ListImplementation.checkElementIndex$runtime_release(i, size());
        int rootSize = rootSize();
        if (i >= rootSize) {
            return removeFromTailAt(this.root, rootSize, this.rootShift, i - rootSize);
        }
        return removeFromTailAt(removeFromRootAt(this.root, this.rootShift, i, new ObjectRef(this.tail[0])), rootSize, this.rootShift, 0);
    }

    private final PersistentList<E> removeFromTailAt(Object[] objArr, int i, int i2, int i3) {
        int size2 = size() - i;
        CommonFunctionsKt.m3801assert(i3 < size2);
        if (size2 == 1) {
            return pullLastBufferFromRoot(objArr, i, i2);
        }
        Object[] copyOf = Arrays.copyOf(this.tail, 32);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        int i4 = size2 - 1;
        if (i3 < i4) {
            ArraysKt.copyInto((T[]) this.tail, (T[]) copyOf, i3, i3 + 1, size2);
        }
        copyOf[i4] = null;
        return new PersistentVector<>(objArr, copyOf, (i + size2) - 1, i2);
    }

    private final PersistentList<E> pullLastBufferFromRoot(Object[] objArr, int i, int i2) {
        if (i2 == 0) {
            if (objArr.length == 33) {
                objArr = Arrays.copyOf(objArr, 32);
                Intrinsics.checkNotNullExpressionValue(objArr, "copyOf(this, newSize)");
            }
            return new SmallPersistentVector<>(objArr);
        }
        ObjectRef objectRef = new ObjectRef((Object) null);
        Object[] pullLastBuffer = pullLastBuffer(objArr, i2, i - 1, objectRef);
        Intrinsics.checkNotNull(pullLastBuffer);
        Object value = objectRef.getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr2 = (Object[]) value;
        if (pullLastBuffer[1] != null) {
            return new PersistentVector<>(pullLastBuffer, objArr2, i, i2);
        }
        Object obj = pullLastBuffer[0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        return new PersistentVector<>((Object[]) obj, objArr2, i, i2 - 5);
    }

    private final Object[] pullLastBuffer(Object[] objArr, int i, int i2, ObjectRef objectRef) {
        Object[] objArr2;
        int indexSegment = UtilsKt.indexSegment(i2, i);
        if (i == 5) {
            objectRef.setValue(objArr[indexSegment]);
            objArr2 = null;
        } else {
            Object[] objArr3 = objArr[indexSegment];
            Intrinsics.checkNotNull(objArr3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr2 = pullLastBuffer(objArr3, i - 5, i2, objectRef);
        }
        if (objArr2 == null && indexSegment == 0) {
            return null;
        }
        Object[] copyOf = Arrays.copyOf(objArr, 32);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        copyOf[indexSegment] = objArr2;
        return copyOf;
    }

    private final Object[] removeFromRootAt(Object[] objArr, int i, int i2, ObjectRef objectRef) {
        Object[] objArr2;
        int indexSegment = UtilsKt.indexSegment(i2, i);
        int i3 = 31;
        if (i == 0) {
            if (indexSegment == 0) {
                objArr2 = new Object[32];
            } else {
                objArr2 = Arrays.copyOf(objArr, 32);
                Intrinsics.checkNotNullExpressionValue(objArr2, "copyOf(this, newSize)");
            }
            ArraysKt.copyInto((T[]) objArr, (T[]) objArr2, indexSegment, indexSegment + 1, 32);
            objArr2[31] = objectRef.getValue();
            objectRef.setValue(objArr[indexSegment]);
            return objArr2;
        }
        if (objArr[31] == null) {
            i3 = UtilsKt.indexSegment(rootSize() - 1, i);
        }
        Object[] copyOf = Arrays.copyOf(objArr, 32);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        int i4 = i - 5;
        int i5 = indexSegment + 1;
        if (i5 <= i3) {
            while (true) {
                Object obj = copyOf[i3];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                copyOf[i3] = removeFromRootAt((Object[]) obj, i4, 0, objectRef);
                if (i3 == i5) {
                    break;
                }
                i3--;
            }
        }
        Object obj2 = copyOf[indexSegment];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        copyOf[indexSegment] = removeFromRootAt((Object[]) obj2, i4, i2, objectRef);
        return copyOf;
    }

    public PersistentList<E> removeAll(Function1<? super E, Boolean> function1) {
        PersistentVectorBuilder builder = builder();
        builder.removeAllWithPredicate(function1);
        return builder.build();
    }

    public PersistentVectorBuilder<E> builder() {
        return new PersistentVectorBuilder<>(this, this.root, this.tail, this.rootShift);
    }

    public ListIterator<E> listIterator(int i) {
        ListImplementation.checkPositionIndex$runtime_release(i, size());
        return new PersistentVectorIterator<>(this.root, this.tail, i, size(), (this.rootShift / 5) + 1);
    }

    private final Object[] bufferFor(int i) {
        if (rootSize() <= i) {
            return this.tail;
        }
        Object[] objArr = this.root;
        for (int i2 = this.rootShift; i2 > 0; i2 -= 5) {
            Object[] objArr2 = objArr[UtilsKt.indexSegment(i, i2)];
            Intrinsics.checkNotNull(objArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr = objArr2;
        }
        return objArr;
    }

    public E get(int i) {
        ListImplementation.checkElementIndex$runtime_release(i, size());
        return bufferFor(i)[i & 31];
    }

    public PersistentList<E> set(int i, E e) {
        ListImplementation.checkElementIndex$runtime_release(i, size());
        if (rootSize() > i) {
            return new PersistentVector<>(setInRoot(this.root, this.rootShift, i, e), this.tail, size(), this.rootShift);
        }
        Object[] copyOf = Arrays.copyOf(this.tail, 32);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        copyOf[i & 31] = e;
        return new PersistentVector<>(this.root, copyOf, size(), this.rootShift);
    }

    private final Object[] setInRoot(Object[] objArr, int i, int i2, Object obj) {
        int indexSegment = UtilsKt.indexSegment(i2, i);
        Object[] copyOf = Arrays.copyOf(objArr, 32);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        if (i == 0) {
            copyOf[indexSegment] = obj;
            return copyOf;
        }
        Object obj2 = copyOf[indexSegment];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        copyOf[indexSegment] = setInRoot((Object[]) obj2, i - 5, i2, obj);
        return copyOf;
    }
}
