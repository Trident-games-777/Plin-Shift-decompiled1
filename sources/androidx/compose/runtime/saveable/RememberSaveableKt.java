package androidx.compose.runtime.saveable;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a>\u0010\u0006\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\b0\u0007\"\u0004\b\u0000\u0010\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u0002H\t\u0012\u0006\b\u0001\u0012\u00020\u00050\u0007H\u0002\u001aa\u0010\u000b\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\u00052\u0016\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\r\"\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u0002H\t\u0012\u0006\b\u0001\u0012\u00020\u00050\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\t0\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001ag\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\u0004\b\u0000\u0010\t2\u0016\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\r\"\u0004\u0018\u00010\u00052\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u0002H\t\u0012\u0006\b\u0001\u0012\u00020\u00050\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\b0\u0011H\u0007¢\u0006\u0002\u0010\u0014\u001a\u0016\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XD¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"MaxSupportedRadix", "", "generateCannotBeSavedErrorMessage", "", "value", "", "mutableStateSaver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/runtime/MutableState;", "T", "inner", "rememberSaveable", "inputs", "", "saver", "key", "init", "Lkotlin/Function0;", "([Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Ljava/lang/Object;", "stateSaver", "([Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/MutableState;", "requireCanBeSaved", "", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "runtime-saveable_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: RememberSaveable.kt */
public final class RememberSaveableKt {
    private static final int MaxSupportedRadix = 36;

    /* JADX WARNING: type inference failed for: r12v0, types: [kotlin.jvm.functions.Function0<? extends T>, kotlin.jvm.functions.Function0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: rememberSaveable  reason: collision with other method in class */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T m3802rememberSaveable(java.lang.Object[] r9, androidx.compose.runtime.saveable.Saver<T, ? extends java.lang.Object> r10, java.lang.String r11, kotlin.jvm.functions.Function0<? extends T> r12, androidx.compose.runtime.Composer r13, int r14, int r15) {
        /*
            java.lang.String r0 = "C(rememberSaveable)P(1,3,2)71@3180L23,81@3526L7,83@3552L313,93@3951L71,93@3940L82:RememberSaveable.kt#r2ddri"
            r1 = 441892779(0x1a56bfab, float:4.440899E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r1, r0)
            r0 = r15 & 2
            if (r0 == 0) goto L_0x0010
            androidx.compose.runtime.saveable.Saver r10 = androidx.compose.runtime.saveable.SaverKt.autoSaver()
        L_0x0010:
            r3 = r10
            r10 = r15 & 4
            r15 = 0
            if (r10 == 0) goto L_0x0017
            r11 = r15
        L_0x0017:
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x0023
            r10 = -1
            java.lang.String r0 = "androidx.compose.runtime.saveable.rememberSaveable (RememberSaveable.kt:70)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r14, r10, r0)
        L_0x0023:
            r10 = 0
            int r0 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r13, r10)
            r1 = r11
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x0033
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0043
        L_0x0033:
            int r11 = MaxSupportedRadix
            int r11 = kotlin.text.CharsKt.checkRadix(r11)
            java.lang.String r11 = java.lang.Integer.toString(r0, r11)
            java.lang.String r0 = "toString(this, checkRadix(radix))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
        L_0x0043:
            r5 = r11
            java.lang.String r11 = "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable, kotlin.Any>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r11)
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.runtime.saveable.SaveableStateRegistryKt.getLocalSaveableStateRegistry()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            r0 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r1 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r0, r1)
            java.lang.Object r11 = r13.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r4 = r11
            androidx.compose.runtime.saveable.SaveableStateRegistry r4 = (androidx.compose.runtime.saveable.SaveableStateRegistry) r4
            r11 = -1519365315(0xffffffffa570533d, float:-2.0844884E-16)
            java.lang.String r0 = "CC(remember):RememberSaveable.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r11, r0)
            java.lang.Object r11 = r13.rememberedValue()
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r11 != r1) goto L_0x0093
            if (r4 == 0) goto L_0x0081
            java.lang.Object r11 = r4.consumeRestored(r5)
            if (r11 == 0) goto L_0x0081
            java.lang.Object r15 = r3.restore(r11)
        L_0x0081:
            if (r15 != 0) goto L_0x0087
            java.lang.Object r15 = r12.invoke()
        L_0x0087:
            r6 = r15
            androidx.compose.runtime.saveable.SaveableHolder r2 = new androidx.compose.runtime.saveable.SaveableHolder
            r7 = r9
            r2.<init>(r3, r4, r5, r6, r7)
            r13.updateRememberedValue(r2)
            r11 = r2
            goto L_0x0094
        L_0x0093:
            r7 = r9
        L_0x0094:
            androidx.compose.runtime.saveable.SaveableHolder r11 = (androidx.compose.runtime.saveable.SaveableHolder) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            java.lang.Object r9 = r11.getValueIfInputsDidntChange(r7)
            if (r9 != 0) goto L_0x00a3
            java.lang.Object r9 = r12.invoke()
        L_0x00a3:
            r12 = -1519352789(0xffffffffa570842b, float:-2.0861462E-16)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r12, r0)
            boolean r12 = r13.changedInstance(r11)
            r15 = r14 & 112(0x70, float:1.57E-43)
            r15 = r15 ^ 48
            r0 = 32
            if (r15 <= r0) goto L_0x00bb
            boolean r15 = r13.changedInstance(r3)
            if (r15 != 0) goto L_0x00bf
        L_0x00bb:
            r14 = r14 & 48
            if (r14 != r0) goto L_0x00c1
        L_0x00bf:
            r14 = 1
            goto L_0x00c2
        L_0x00c1:
            r14 = r10
        L_0x00c2:
            r12 = r12 | r14
            boolean r14 = r13.changedInstance(r4)
            r12 = r12 | r14
            boolean r14 = r13.changed((java.lang.Object) r5)
            r12 = r12 | r14
            boolean r14 = r13.changedInstance(r9)
            r12 = r12 | r14
            boolean r14 = r13.changedInstance(r7)
            r12 = r12 | r14
            java.lang.Object r14 = r13.rememberedValue()
            if (r12 != 0) goto L_0x00e8
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r14 != r12) goto L_0x00e6
            goto L_0x00e8
        L_0x00e6:
            r7 = r9
            goto L_0x00f9
        L_0x00e8:
            androidx.compose.runtime.saveable.RememberSaveableKt$rememberSaveable$1$1 r2 = new androidx.compose.runtime.saveable.RememberSaveableKt$rememberSaveable$1$1
            r6 = r5
            r8 = r7
            r7 = r9
            r5 = r4
            r4 = r3
            r3 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r14 = r2
            kotlin.jvm.functions.Function0 r14 = (kotlin.jvm.functions.Function0) r14
            r13.updateRememberedValue(r14)
        L_0x00f9:
            kotlin.jvm.functions.Function0 r14 = (kotlin.jvm.functions.Function0) r14
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.runtime.EffectsKt.SideEffect(r14, r13, r10)
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x010a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x010a:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.saveable.RememberSaveableKt.m3802rememberSaveable(java.lang.Object[], androidx.compose.runtime.saveable.Saver, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r10v0, types: [androidx.compose.runtime.saveable.Saver, androidx.compose.runtime.saveable.Saver<T, ? extends java.lang.Object>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> androidx.compose.runtime.MutableState<T> rememberSaveable(java.lang.Object[] r9, androidx.compose.runtime.saveable.Saver<T, ? extends java.lang.Object> r10, java.lang.String r11, kotlin.jvm.functions.Function0<? extends androidx.compose.runtime.MutableState<T>> r12, androidx.compose.runtime.Composer r13, int r14, int r15) {
        /*
            java.lang.String r0 = "C(rememberSaveable)P(1,3,2)127@5317L106:RememberSaveable.kt#r2ddri"
            r1 = -202053668(0xfffffffff3f4e7dc, float:-3.8806857E31)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r1, r0)
            r15 = r15 & 4
            if (r15 == 0) goto L_0x000d
            r11 = 0
        L_0x000d:
            r4 = r11
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x001a
            r11 = -1
            java.lang.String r15 = "androidx.compose.runtime.saveable.rememberSaveable (RememberSaveable.kt:127)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r14, r11, r15)
        L_0x001a:
            int r11 = r9.length
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r9, r11)
            androidx.compose.runtime.saveable.Saver r3 = mutableStateSaver(r10)
            r7 = r14 & 8064(0x1f80, float:1.13E-41)
            r8 = 0
            r5 = r12
            r6 = r13
            java.lang.Object r9 = rememberSaveable((java.lang.Object[]) r2, r3, (java.lang.String) r4, r5, (androidx.compose.runtime.Composer) r6, (int) r7, (int) r8)
            androidx.compose.runtime.MutableState r9 = (androidx.compose.runtime.MutableState) r9
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x0037
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0037:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable(java.lang.Object[], androidx.compose.runtime.saveable.Saver, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):androidx.compose.runtime.MutableState");
    }

    private static final <T> Saver<MutableState<T>, MutableState<Object>> mutableStateSaver(Saver<T, ? extends Object> saver) {
        Intrinsics.checkNotNull(saver, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.RememberSaveableKt.mutableStateSaver, kotlin.Any>");
        return SaverKt.Saver(new RememberSaveableKt$mutableStateSaver$1$1(saver), new RememberSaveableKt$mutableStateSaver$1$2(saver));
    }

    /* access modifiers changed from: private */
    public static final void requireCanBeSaved(SaveableStateRegistry saveableStateRegistry, Object obj) {
        String str;
        if (obj != null && !saveableStateRegistry.canBeSaved(obj)) {
            if (obj instanceof SnapshotMutableState) {
                SnapshotMutableState snapshotMutableState = (SnapshotMutableState) obj;
                if (snapshotMutableState.getPolicy() == SnapshotStateKt.neverEqualPolicy() || snapshotMutableState.getPolicy() == SnapshotStateKt.structuralEqualityPolicy() || snapshotMutableState.getPolicy() == SnapshotStateKt.referentialEqualityPolicy()) {
                    str = "MutableState containing " + snapshotMutableState.getValue() + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it as a stateSaver parameter to rememberSaveable().";
                } else {
                    str = "If you use a custom SnapshotMutationPolicy for your MutableState you have to write a custom Saver";
                }
            } else {
                str = generateCannotBeSavedErrorMessage(obj);
            }
            throw new IllegalArgumentException(str);
        }
    }

    public static final String generateCannotBeSavedErrorMessage(Object obj) {
        return obj + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it to rememberSaveable().";
    }
}
