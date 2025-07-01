package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aP\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u001d\u0010\u000b\u001a\u0019\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001aJ\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u001d\u0010\u000b\u001a\u0019\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0012\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"MaxItemsToRetainForReuse", "", "LazyLayout", "", "itemProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "measurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayout.kt */
public final class LazyLayoutKt {
    private static final int MaxItemsToRetainForReuse = 7;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    @kotlin.Deprecated(message = "Use an overload accepting a lambda prodicing an item provider instead", replaceWith = @kotlin.ReplaceWith(expression = "LazyLayout({ itemProvider }, modifier, prefetchState, measurePolicy)", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyLayout(androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider r8, androidx.compose.ui.Modifier r9, androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r10, kotlin.jvm.functions.Function2<? super androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, ? super androidx.compose.ui.unit.Constraints, ? extends androidx.compose.ui.layout.MeasureResult> r11, androidx.compose.runtime.Composer r12, int r13, int r14) {
        /*
            r0 = 852831187(0x32d52bd3, float:2.4816392E-8)
            androidx.compose.runtime.Composer r5 = r12.startRestartGroup(r0)
            java.lang.String r12 = "C(LazyLayout)P(!1,2,3)54@2185L16,54@2174L68:LazyLayout.kt#wow0x6"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r12)
            r12 = r14 & 1
            r1 = 4
            if (r12 == 0) goto L_0x0014
            r12 = r13 | 6
            goto L_0x0024
        L_0x0014:
            r12 = r13 & 6
            if (r12 != 0) goto L_0x0023
            boolean r12 = r5.changed((java.lang.Object) r8)
            if (r12 == 0) goto L_0x0020
            r12 = r1
            goto L_0x0021
        L_0x0020:
            r12 = 2
        L_0x0021:
            r12 = r12 | r13
            goto L_0x0024
        L_0x0023:
            r12 = r13
        L_0x0024:
            r2 = r14 & 2
            if (r2 == 0) goto L_0x002b
            r12 = r12 | 48
            goto L_0x003b
        L_0x002b:
            r3 = r13 & 48
            if (r3 != 0) goto L_0x003b
            boolean r3 = r5.changed((java.lang.Object) r9)
            if (r3 == 0) goto L_0x0038
            r3 = 32
            goto L_0x003a
        L_0x0038:
            r3 = 16
        L_0x003a:
            r12 = r12 | r3
        L_0x003b:
            r3 = r14 & 4
            if (r3 == 0) goto L_0x0042
            r12 = r12 | 384(0x180, float:5.38E-43)
            goto L_0x0052
        L_0x0042:
            r4 = r13 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x0052
            boolean r4 = r5.changed((java.lang.Object) r10)
            if (r4 == 0) goto L_0x004f
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0051
        L_0x004f:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0051:
            r12 = r12 | r4
        L_0x0052:
            r4 = r14 & 8
            if (r4 == 0) goto L_0x0059
            r12 = r12 | 3072(0xc00, float:4.305E-42)
            goto L_0x0069
        L_0x0059:
            r4 = r13 & 3072(0xc00, float:4.305E-42)
            if (r4 != 0) goto L_0x0069
            boolean r4 = r5.changedInstance(r11)
            if (r4 == 0) goto L_0x0066
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x0068
        L_0x0066:
            r4 = 1024(0x400, float:1.435E-42)
        L_0x0068:
            r12 = r12 | r4
        L_0x0069:
            r4 = r12 & 1171(0x493, float:1.641E-42)
            r6 = 1170(0x492, float:1.64E-42)
            if (r4 != r6) goto L_0x007d
            boolean r4 = r5.getSkipping()
            if (r4 != 0) goto L_0x0076
            goto L_0x007d
        L_0x0076:
            r5.skipToGroupEnd()
            r12 = r11
            r11 = r10
            r10 = r9
            goto L_0x00d5
        L_0x007d:
            if (r2 == 0) goto L_0x0083
            androidx.compose.ui.Modifier$Companion r9 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r9 = (androidx.compose.ui.Modifier) r9
        L_0x0083:
            r2 = r9
            if (r3 == 0) goto L_0x0087
            r10 = 0
        L_0x0087:
            r3 = r10
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x0094
            r9 = -1
            java.lang.String r10 = "androidx.compose.foundation.lazy.layout.LazyLayout (LazyLayout.kt:53)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r12, r9, r10)
        L_0x0094:
            r9 = 1956949074(0x74a4ac52, float:1.0437399E32)
            java.lang.String r10 = "CC(remember):LazyLayout.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r9, r10)
            r9 = r12 & 14
            if (r9 != r1) goto L_0x00a2
            r9 = 1
            goto L_0x00a3
        L_0x00a2:
            r9 = 0
        L_0x00a3:
            java.lang.Object r10 = r5.rememberedValue()
            if (r9 != 0) goto L_0x00b1
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r10 != r9) goto L_0x00bc
        L_0x00b1:
            androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$1$1 r9 = new androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$1$1
            r9.<init>(r8)
            r10 = r9
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            r5.updateRememberedValue(r10)
        L_0x00bc:
            r1 = r10
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r6 = r12 & 8176(0x1ff0, float:1.1457E-41)
            r7 = 0
            r4 = r11
            LazyLayout((kotlin.jvm.functions.Function0<? extends androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider>) r1, (androidx.compose.ui.Modifier) r2, (androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState) r3, (kotlin.jvm.functions.Function2<? super androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, ? super androidx.compose.ui.unit.Constraints, ? extends androidx.compose.ui.layout.MeasureResult>) r4, (androidx.compose.runtime.Composer) r5, (int) r6, (int) r7)
            r12 = r4
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x00d3
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00d3:
            r10 = r2
            r11 = r3
        L_0x00d5:
            androidx.compose.runtime.ScopeUpdateScope r0 = r5.endRestartGroup()
            if (r0 == 0) goto L_0x00e6
            r9 = r8
            androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2 r8 = new androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2
            r8.<init>(r9, r10, r11, r12, r13, r14)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r0.updateScope(r8)
        L_0x00e6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutKt.LazyLayout(androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider, androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void LazyLayout(Function0<? extends LazyLayoutItemProvider> function0, Modifier modifier, LazyLayoutPrefetchState lazyLayoutPrefetchState, Function2<? super LazyLayoutMeasureScope, ? super Constraints, ? extends MeasureResult> function2, Composer composer, int i, int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(2002163445);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyLayout)P(!1,2,3)79@3266L34,81@3338L1509,81@3306L1541:LazyLayout.kt#wow0x6");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed((Object) modifier) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed((Object) lazyLayoutPrefetchState) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i3 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (i5 != 0) {
                lazyLayoutPrefetchState = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2002163445, i3, -1, "androidx.compose.foundation.lazy.layout.LazyLayout (LazyLayout.kt:78)");
            }
            LazySaveableStateHolderKt.LazySaveableStateHolderProvider(ComposableLambdaKt.rememberComposableLambda(-1488997347, true, new LazyLayoutKt$LazyLayout$3(lazyLayoutPrefetchState, modifier, function2, SnapshotStateKt.rememberUpdatedState(function0, startRestartGroup, i3 & 14)), startRestartGroup, 54), startRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        Modifier modifier2 = modifier;
        LazyLayoutPrefetchState lazyLayoutPrefetchState2 = lazyLayoutPrefetchState;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LazyLayoutKt$LazyLayout$4(function0, modifier2, lazyLayoutPrefetchState2, function2, i, i2));
        }
    }
}
