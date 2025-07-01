package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"LazySaveableStateHolderProvider", "", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazySaveableStateHolder.kt */
public final class LazySaveableStateHolderKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazySaveableStateHolderProvider(kotlin.jvm.functions.Function3<? super androidx.compose.runtime.saveable.SaveableStateHolder, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r8, androidx.compose.runtime.Composer r9, int r10) {
        /*
            r0 = 674185128(0x282f3fa8, float:9.728255E-15)
            androidx.compose.runtime.Composer r5 = r9.startRestartGroup(r0)
            java.lang.String r9 = "C(LazySaveableStateHolderProvider)42@2089L7,45@2218L68,43@2114L172,48@2360L92,48@2291L161:LazySaveableStateHolder.kt#wow0x6"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r9)
            r9 = r10 & 6
            r1 = 2
            if (r9 != 0) goto L_0x001c
            boolean r9 = r5.changedInstance(r8)
            if (r9 == 0) goto L_0x0019
            r9 = 4
            goto L_0x001a
        L_0x0019:
            r9 = r1
        L_0x001a:
            r9 = r9 | r10
            goto L_0x001d
        L_0x001c:
            r9 = r10
        L_0x001d:
            r2 = r9 & 3
            if (r2 != r1) goto L_0x002d
            boolean r1 = r5.getSkipping()
            if (r1 != 0) goto L_0x0028
            goto L_0x002d
        L_0x0028:
            r5.skipToGroupEnd()
            goto L_0x00b7
        L_0x002d:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0039
            r1 = -1
            java.lang.String r2 = "androidx.compose.foundation.lazy.layout.LazySaveableStateHolderProvider (LazySaveableStateHolder.kt:41)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r9, r1, r2)
        L_0x0039:
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.runtime.saveable.SaveableStateRegistryKt.getLocalSaveableStateRegistry()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r0 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r1 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r0, r1)
            java.lang.Object r9 = r5.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.runtime.saveable.SaveableStateRegistry r9 = (androidx.compose.runtime.saveable.SaveableStateRegistry) r9
            java.lang.Object[] r1 = new java.lang.Object[]{r9}
            androidx.compose.foundation.lazy.layout.LazySaveableStateHolder$Companion r0 = androidx.compose.foundation.lazy.layout.LazySaveableStateHolder.Companion
            androidx.compose.runtime.saveable.Saver r2 = r0.saver(r9)
            r0 = -16183005(0xffffffffff091123, float:-1.8219321E38)
            java.lang.String r3 = "CC(remember):LazySaveableStateHolder.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r0, r3)
            boolean r0 = r5.changedInstance(r9)
            java.lang.Object r3 = r5.rememberedValue()
            if (r0 != 0) goto L_0x0074
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r3 != r0) goto L_0x007f
        L_0x0074:
            androidx.compose.foundation.lazy.layout.LazySaveableStateHolderKt$LazySaveableStateHolderProvider$holder$1$1 r0 = new androidx.compose.foundation.lazy.layout.LazySaveableStateHolderKt$LazySaveableStateHolderProvider$holder$1$1
            r0.<init>(r9)
            r3 = r0
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r5.updateRememberedValue(r3)
        L_0x007f:
            r4 = r3
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r6 = 0
            r7 = 4
            r3 = 0
            java.lang.Object r9 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r1, r2, (java.lang.String) r3, r4, (androidx.compose.runtime.Composer) r5, (int) r6, (int) r7)
            androidx.compose.foundation.lazy.layout.LazySaveableStateHolder r9 = (androidx.compose.foundation.lazy.layout.LazySaveableStateHolder) r9
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.runtime.saveable.SaveableStateRegistryKt.getLocalSaveableStateRegistry()
            androidx.compose.runtime.ProvidedValue r0 = r0.provides(r9)
            androidx.compose.foundation.lazy.layout.LazySaveableStateHolderKt$LazySaveableStateHolderProvider$1 r1 = new androidx.compose.foundation.lazy.layout.LazySaveableStateHolderKt$LazySaveableStateHolderProvider$1
            r1.<init>(r9, r8)
            r9 = 54
            r2 = 1863926504(0x6f1942e8, float:4.743209E28)
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r9 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r2, r3, r1, r5, r9)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            int r1 = androidx.compose.runtime.ProvidedValue.$stable
            r1 = r1 | 48
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>) r0, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r9, (androidx.compose.runtime.Composer) r5, (int) r1)
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x00b7
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00b7:
            androidx.compose.runtime.ScopeUpdateScope r9 = r5.endRestartGroup()
            if (r9 == 0) goto L_0x00c7
            androidx.compose.foundation.lazy.layout.LazySaveableStateHolderKt$LazySaveableStateHolderProvider$2 r0 = new androidx.compose.foundation.lazy.layout.LazySaveableStateHolderKt$LazySaveableStateHolderProvider$2
            r0.<init>(r8, r10)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x00c7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazySaveableStateHolderKt.LazySaveableStateHolderProvider(kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int):void");
    }
}
