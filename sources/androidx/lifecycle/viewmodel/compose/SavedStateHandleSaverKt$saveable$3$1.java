package androidx.lifecycle.viewmodel.compose;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00028\u00000\u0001J$\u0010\u0003\u001a\u00028\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002¢\u0006\u0002\u0010\u0007J,\u0010\b\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\n\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"androidx/lifecycle/viewmodel/compose/SavedStateHandleSaverKt$saveable$3$1", "Lkotlin/properties/ReadWriteProperty;", "", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "lifecycle-viewmodel-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SavedStateHandleSaver.android.kt */
public final class SavedStateHandleSaverKt$saveable$3$1 implements ReadWriteProperty<Object, T> {
    final /* synthetic */ MutableState<T> $mutableState;

    SavedStateHandleSaverKt$saveable$3$1(MutableState<T> mutableState) {
        this.$mutableState = mutableState;
    }

    public T getValue(Object obj, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        return this.$mutableState.getValue();
    }

    public void setValue(Object obj, KProperty<?> kProperty, T t) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        this.$mutableState.setValue(t);
    }
}
