package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\b\u001a\u00028\u0000H ¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\b\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\nJ(\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0002\b\u0010H\u0004J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\b\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\nJ1\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0013H\u0010¢\u0006\u0002\b\u0015J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002¨\u0006\u0017"}, d2 = {"Landroidx/compose/runtime/ProvidableCompositionLocal;", "T", "Landroidx/compose/runtime/CompositionLocal;", "defaultFactory", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "defaultProvidedValue", "Landroidx/compose/runtime/ProvidedValue;", "value", "defaultProvidedValue$runtime_release", "(Ljava/lang/Object;)Landroidx/compose/runtime/ProvidedValue;", "provides", "providesComputed", "compute", "Lkotlin/Function1;", "Landroidx/compose/runtime/CompositionLocalAccessorScope;", "Lkotlin/ExtensionFunctionType;", "providesDefault", "updatedStateOf", "Landroidx/compose/runtime/ValueHolder;", "previous", "updatedStateOf$runtime_release", "valueHolderOf", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CompositionLocal.kt */
public abstract class ProvidableCompositionLocal<T> extends CompositionLocal<T> {
    public static final int $stable = 0;

    public abstract ProvidedValue<T> defaultProvidedValue$runtime_release(T t);

    public ProvidableCompositionLocal(Function0<? extends T> function0) {
        super(function0, (DefaultConstructorMarker) null);
    }

    public final ProvidedValue<T> provides(T t) {
        return defaultProvidedValue$runtime_release(t);
    }

    public final ProvidedValue<T> providesDefault(T t) {
        return defaultProvidedValue$runtime_release(t).ifNotAlreadyProvided$runtime_release();
    }

    public final ProvidedValue<T> providesComputed(Function1<? super CompositionLocalAccessorScope, ? extends T> function1) {
        return new ProvidedValue<>(this, null, false, (SnapshotMutationPolicy) null, (MutableState) null, function1, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: androidx.compose.runtime.ComputedValueHolder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.compose.runtime.ComputedValueHolder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: androidx.compose.runtime.ComputedValueHolder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: androidx.compose.runtime.ComputedValueHolder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: androidx.compose.runtime.ComputedValueHolder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: androidx.compose.runtime.ComputedValueHolder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: androidx.compose.runtime.ComputedValueHolder} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.runtime.ValueHolder<T> updatedStateOf$runtime_release(androidx.compose.runtime.ProvidedValue<T> r4, androidx.compose.runtime.ValueHolder<T> r5) {
        /*
            r3 = this;
            boolean r0 = r5 instanceof androidx.compose.runtime.DynamicValueHolder
            r1 = 0
            if (r0 == 0) goto L_0x001c
            boolean r0 = r4.isDynamic$runtime_release()
            if (r0 == 0) goto L_0x0019
            r1 = r5
            androidx.compose.runtime.DynamicValueHolder r1 = (androidx.compose.runtime.DynamicValueHolder) r1
            androidx.compose.runtime.MutableState r5 = r1.getState()
            java.lang.Object r0 = r4.getEffectiveValue$runtime_release()
            r5.setValue(r0)
        L_0x0019:
            androidx.compose.runtime.ValueHolder r1 = (androidx.compose.runtime.ValueHolder) r1
            goto L_0x004d
        L_0x001c:
            boolean r0 = r5 instanceof androidx.compose.runtime.StaticValueHolder
            if (r0 == 0) goto L_0x003a
            boolean r0 = r4.isStatic$runtime_release()
            if (r0 == 0) goto L_0x0037
            java.lang.Object r0 = r4.getEffectiveValue$runtime_release()
            androidx.compose.runtime.StaticValueHolder r5 = (androidx.compose.runtime.StaticValueHolder) r5
            java.lang.Object r2 = r5.getValue()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x0037
            r1 = r5
        L_0x0037:
            androidx.compose.runtime.ValueHolder r1 = (androidx.compose.runtime.ValueHolder) r1
            goto L_0x004d
        L_0x003a:
            boolean r0 = r5 instanceof androidx.compose.runtime.ComputedValueHolder
            if (r0 == 0) goto L_0x004d
            kotlin.jvm.functions.Function1 r0 = r4.getCompute$runtime_release()
            androidx.compose.runtime.ComputedValueHolder r5 = (androidx.compose.runtime.ComputedValueHolder) r5
            kotlin.jvm.functions.Function1 r2 = r5.getCompute()
            if (r0 != r2) goto L_0x004b
            r1 = r5
        L_0x004b:
            androidx.compose.runtime.ValueHolder r1 = (androidx.compose.runtime.ValueHolder) r1
        L_0x004d:
            if (r1 != 0) goto L_0x0054
            androidx.compose.runtime.ValueHolder r4 = r3.valueHolderOf(r4)
            return r4
        L_0x0054:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ProvidableCompositionLocal.updatedStateOf$runtime_release(androidx.compose.runtime.ProvidedValue, androidx.compose.runtime.ValueHolder):androidx.compose.runtime.ValueHolder");
    }

    private final ValueHolder<T> valueHolderOf(ProvidedValue<T> providedValue) {
        if (providedValue.isDynamic$runtime_release()) {
            MutableState<T> state$runtime_release = providedValue.getState$runtime_release();
            if (state$runtime_release == null) {
                T value = providedValue.getValue();
                SnapshotMutationPolicy<T> mutationPolicy$runtime_release = providedValue.getMutationPolicy$runtime_release();
                if (mutationPolicy$runtime_release == null) {
                    mutationPolicy$runtime_release = SnapshotStateKt.structuralEqualityPolicy();
                }
                state$runtime_release = SnapshotStateKt.mutableStateOf(value, mutationPolicy$runtime_release);
            }
            return new DynamicValueHolder<>(state$runtime_release);
        } else if (providedValue.getCompute$runtime_release() != null) {
            return new ComputedValueHolder<>(providedValue.getCompute$runtime_release());
        } else {
            if (providedValue.getState$runtime_release() != null) {
                return new DynamicValueHolder<>(providedValue.getState$runtime_release());
            }
            return new StaticValueHolder<>(providedValue.getEffectiveValue$runtime_release());
        }
    }
}
