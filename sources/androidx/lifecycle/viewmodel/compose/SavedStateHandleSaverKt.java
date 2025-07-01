package androidx.lifecycle.viewmodel.compose;

import android.os.Bundle;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.core.os.BundleKt;
import androidx.lifecycle.SavedStateHandle;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.PropertyDelegateProvider;
import kotlin.properties.ReadOnlyProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a>\u0010\u0000\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u0001\"\u0004\b\u0000\u0010\u00032\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u0002H\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0001H\u0002\u001ai\u0010\u0006\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u0002H\u00030\b0\u0007\"\u0004\b\u0000\u0010\u0003\"\u000e\b\u0001\u0010\t*\b\u0012\u0004\u0012\u0002H\u00030\u0002*\u00020\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u0002H\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\t0\rH\u0007¢\u0006\u0002\b\u000e\u001aX\u0010\u0006\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u0002H\u00030\u000f0\u0007\"\b\b\u0000\u0010\u0003*\u00020\u0004*\u00020\n2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002H\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00030\rH\u0007\u001aI\u0010\u0006\u001a\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u0004*\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002H\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00030\rH\u0007¢\u0006\u0002\u0010\u0013\u001aJ\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0002\"\u0004\b\u0000\u0010\u0003*\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u0002H\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u00012\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\rH\u0007¨\u0006\u0014"}, d2 = {"mutableStateSaver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/runtime/MutableState;", "T", "", "inner", "saveable", "Lkotlin/properties/PropertyDelegateProvider;", "Lkotlin/properties/ReadWriteProperty;", "M", "Landroidx/lifecycle/SavedStateHandle;", "stateSaver", "init", "Lkotlin/Function0;", "saveableMutableState", "Lkotlin/properties/ReadOnlyProperty;", "saver", "key", "", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;Landroidx/compose/runtime/saveable/Saver;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "lifecycle-viewmodel-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SavedStateHandleSaver.android.kt */
public final class SavedStateHandleSaverKt {
    /* access modifiers changed from: private */
    public static final Object saveable$lambda$3$lambda$2(Object obj, Object obj2, KProperty kProperty) {
        Intrinsics.checkNotNullParameter(obj, "$value");
        Intrinsics.checkNotNullParameter(kProperty, "<anonymous parameter 1>");
        return obj;
    }

    public static /* synthetic */ Object saveable$default(SavedStateHandle savedStateHandle, String str, Saver saver, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            saver = SaverKt.autoSaver();
        }
        return saveable(savedStateHandle, str, saver, function0);
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [kotlin.jvm.functions.Function0<? extends T>, java.lang.Object, kotlin.jvm.functions.Function0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: saveable  reason: collision with other method in class */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T m7439saveable(androidx.lifecycle.SavedStateHandle r2, java.lang.String r3, androidx.compose.runtime.saveable.Saver<T, ? extends java.lang.Object> r4, kotlin.jvm.functions.Function0<? extends T> r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "saver"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "init"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.Object r0 = r2.get(r3)
            android.os.Bundle r0 = (android.os.Bundle) r0
            if (r0 == 0) goto L_0x002a
            java.lang.String r1 = "value"
            java.lang.Object r0 = r0.get(r1)
            if (r0 == 0) goto L_0x002a
            java.lang.Object r0 = r4.restore(r0)
            if (r0 != 0) goto L_0x002e
        L_0x002a:
            java.lang.Object r0 = r5.invoke()
        L_0x002e:
            androidx.lifecycle.viewmodel.compose.SavedStateHandleSaverKt$$ExternalSyntheticLambda1 r5 = new androidx.lifecycle.viewmodel.compose.SavedStateHandleSaverKt$$ExternalSyntheticLambda1
            r5.<init>(r4, r0)
            r2.setSavedStateProvider(r3, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.viewmodel.compose.SavedStateHandleSaverKt.m7439saveable(androidx.lifecycle.SavedStateHandle, java.lang.String, androidx.compose.runtime.saveable.Saver, kotlin.jvm.functions.Function0):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final Bundle saveable$lambda$1(Saver saver, Object obj) {
        Intrinsics.checkNotNullParameter(saver, "$saver");
        Intrinsics.checkNotNullParameter(obj, "$value");
        return BundleKt.bundleOf(TuplesKt.to("value", saver.save(new SavedStateHandleSaverKt$saveable$1$1$1(SavedStateHandle.Companion), obj)));
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [androidx.compose.runtime.saveable.Saver, androidx.compose.runtime.saveable.Saver<T, ? extends java.lang.Object>, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r4v0, types: [kotlin.jvm.functions.Function0<? extends androidx.compose.runtime.MutableState<T>>, java.lang.Object, kotlin.jvm.functions.Function0] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> androidx.compose.runtime.MutableState<T> saveable(androidx.lifecycle.SavedStateHandle r1, java.lang.String r2, androidx.compose.runtime.saveable.Saver<T, ? extends java.lang.Object> r3, kotlin.jvm.functions.Function0<? extends androidx.compose.runtime.MutableState<T>> r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "stateSaver"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "init"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            androidx.compose.runtime.saveable.Saver r3 = mutableStateSaver(r3)
            java.lang.Object r1 = saveable((androidx.lifecycle.SavedStateHandle) r1, (java.lang.String) r2, r3, r4)
            androidx.compose.runtime.MutableState r1 = (androidx.compose.runtime.MutableState) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.viewmodel.compose.SavedStateHandleSaverKt.saveable(androidx.lifecycle.SavedStateHandle, java.lang.String, androidx.compose.runtime.saveable.Saver, kotlin.jvm.functions.Function0):androidx.compose.runtime.MutableState");
    }

    public static /* synthetic */ PropertyDelegateProvider saveable$default(SavedStateHandle savedStateHandle, Saver saver, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            saver = SaverKt.autoSaver();
        }
        return saveable(savedStateHandle, saver, function0);
    }

    public static final <T> PropertyDelegateProvider<Object, ReadOnlyProperty<Object, T>> saveable(SavedStateHandle savedStateHandle, Saver<T, ? extends Object> saver, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "<this>");
        Intrinsics.checkNotNullParameter(saver, "saver");
        Intrinsics.checkNotNullParameter(function0, "init");
        return new SavedStateHandleSaverKt$$ExternalSyntheticLambda0(savedStateHandle, saver, function0);
    }

    /* access modifiers changed from: private */
    public static final ReadOnlyProperty saveable$lambda$3(SavedStateHandle savedStateHandle, Saver saver, Function0 function0, Object obj, KProperty kProperty) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "$this_saveable");
        Intrinsics.checkNotNullParameter(saver, "$saver");
        Intrinsics.checkNotNullParameter(function0, "$init");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        return new SavedStateHandleSaverKt$$ExternalSyntheticLambda3(saveable(savedStateHandle, (obj != null ? Reflection.getOrCreateKotlinClass(obj.getClass()).getQualifiedName() + '.' : "") + kProperty.getName(), saver, function0));
    }

    public static /* synthetic */ PropertyDelegateProvider saveableMutableState$default(SavedStateHandle savedStateHandle, Saver saver, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            saver = SaverKt.autoSaver();
        }
        return saveableMutableState(savedStateHandle, saver, function0);
    }

    public static final <T, M extends MutableState<T>> PropertyDelegateProvider<Object, ReadWriteProperty<Object, T>> saveableMutableState(SavedStateHandle savedStateHandle, Saver<T, ? extends Object> saver, Function0<? extends M> function0) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "<this>");
        Intrinsics.checkNotNullParameter(saver, "stateSaver");
        Intrinsics.checkNotNullParameter(function0, "init");
        return new SavedStateHandleSaverKt$$ExternalSyntheticLambda2(savedStateHandle, saver, function0);
    }

    /* access modifiers changed from: private */
    public static final ReadWriteProperty saveable$lambda$4(SavedStateHandle savedStateHandle, Saver saver, Function0 function0, Object obj, KProperty kProperty) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "$this_saveable");
        Intrinsics.checkNotNullParameter(saver, "$stateSaver");
        Intrinsics.checkNotNullParameter(function0, "$init");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        return new SavedStateHandleSaverKt$saveable$3$1(saveable(savedStateHandle, (obj != null ? Reflection.getOrCreateKotlinClass(obj.getClass()).getQualifiedName() + '.' : "") + kProperty.getName(), saver, function0));
    }

    private static final <T> Saver<MutableState<T>, MutableState<Object>> mutableStateSaver(Saver<T, ? extends Object> saver) {
        Intrinsics.checkNotNull(saver, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.lifecycle.viewmodel.compose.SavedStateHandleSaverKt.mutableStateSaver, kotlin.Any>");
        return SaverKt.Saver(new SavedStateHandleSaverKt$mutableStateSaver$1$1(saver), new SavedStateHandleSaverKt$mutableStateSaver$1$2(saver));
    }
}
