package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AccessibilityManager;
import androidx.work.WorkRequest;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a:\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\b\fH\u0003¢\u0006\u0002\u0010\r\u001a:\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\b\u001a\u00020\t2\u0019\b\u0002\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0012\u001a9\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bH\u0003¢\u0006\u0002\u0010\u001c\u001a)\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0003¢\u0006\u0002\u0010\u001e\u001a\u001e\u0010\u001f\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010$H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000*b\b\u0002\u0010%\"-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00050\u001b¢\u0006\u0002\b\f¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\b\f2-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00050\u001b¢\u0006\u0002\b\f¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\b\f¨\u0006("}, d2 = {"SnackbarFadeInMillis", "", "SnackbarFadeOutMillis", "SnackbarInBetweenDelayMillis", "FadeInFadeOutWithScale", "", "current", "Landroidx/compose/material3/SnackbarData;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material3/SnackbarData;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SnackbarHost", "hostState", "Landroidx/compose/material3/SnackbarHostState;", "snackbar", "(Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "animatedOpacity", "Landroidx/compose/runtime/State;", "", "animation", "Landroidx/compose/animation/core/AnimationSpec;", "visible", "", "onAnimationFinish", "Lkotlin/Function0;", "(Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animatedScale", "(Landroidx/compose/animation/core/AnimationSpec;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "toMillis", "", "Landroidx/compose/material3/SnackbarDuration;", "hasAction", "accessibilityManager", "Landroidx/compose/ui/platform/AccessibilityManager;", "FadeInFadeOutTransition", "Lkotlin/ParameterName;", "name", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnackbarHost.kt */
public final class SnackbarHostKt {
    private static final int SnackbarFadeInMillis = 150;
    private static final int SnackbarFadeOutMillis = 75;
    private static final int SnackbarInBetweenDelayMillis = 0;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SnackbarHost.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                androidx.compose.material3.SnackbarDuration[] r0 = androidx.compose.material3.SnackbarDuration.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.material3.SnackbarDuration r1 = androidx.compose.material3.SnackbarDuration.Indefinite     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.material3.SnackbarDuration r1 = androidx.compose.material3.SnackbarDuration.Long     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.material3.SnackbarDuration r1 = androidx.compose.material3.SnackbarDuration.Short     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnackbarHostKt.WhenMappings.<clinit>():void");
        }
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SnackbarHost(androidx.compose.material3.SnackbarHostState r11, androidx.compose.ui.Modifier r12, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SnackbarData, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r13, androidx.compose.runtime.Composer r14, int r15, int r16) {
        /*
            r0 = 464178177(0x1baacc01, float:2.8255975E-22)
            androidx.compose.runtime.Composer r4 = r14.startRestartGroup(r0)
            java.lang.String r14 = "C(SnackbarHost)223@9468L7,224@9516L348,224@9480L384,235@9869L134:SnackbarHost.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r14)
            r14 = r16 & 1
            if (r14 == 0) goto L_0x0013
            r14 = r15 | 6
            goto L_0x0023
        L_0x0013:
            r14 = r15 & 6
            if (r14 != 0) goto L_0x0022
            boolean r14 = r4.changed((java.lang.Object) r11)
            if (r14 == 0) goto L_0x001f
            r14 = 4
            goto L_0x0020
        L_0x001f:
            r14 = 2
        L_0x0020:
            r14 = r14 | r15
            goto L_0x0023
        L_0x0022:
            r14 = r15
        L_0x0023:
            r1 = r16 & 2
            if (r1 == 0) goto L_0x002a
            r14 = r14 | 48
            goto L_0x003a
        L_0x002a:
            r2 = r15 & 48
            if (r2 != 0) goto L_0x003a
            boolean r2 = r4.changed((java.lang.Object) r12)
            if (r2 == 0) goto L_0x0037
            r2 = 32
            goto L_0x0039
        L_0x0037:
            r2 = 16
        L_0x0039:
            r14 = r14 | r2
        L_0x003a:
            r2 = r16 & 4
            if (r2 == 0) goto L_0x0041
            r14 = r14 | 384(0x180, float:5.38E-43)
            goto L_0x0051
        L_0x0041:
            r3 = r15 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x0051
            boolean r3 = r4.changedInstance(r13)
            if (r3 == 0) goto L_0x004e
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0050
        L_0x004e:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0050:
            r14 = r14 | r3
        L_0x0051:
            r3 = r14 & 147(0x93, float:2.06E-43)
            r5 = 146(0x92, float:2.05E-43)
            if (r3 != r5) goto L_0x0065
            boolean r3 = r4.getSkipping()
            if (r3 != 0) goto L_0x005e
            goto L_0x0065
        L_0x005e:
            r4.skipToGroupEnd()
            r7 = r12
            r8 = r13
            goto L_0x00e5
        L_0x0065:
            if (r1 == 0) goto L_0x006b
            androidx.compose.ui.Modifier$Companion r12 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r12 = (androidx.compose.ui.Modifier) r12
        L_0x006b:
            if (r2 == 0) goto L_0x0073
            androidx.compose.material3.ComposableSingletons$SnackbarHostKt r13 = androidx.compose.material3.ComposableSingletons$SnackbarHostKt.INSTANCE
            kotlin.jvm.functions.Function3 r13 = r13.m1938getLambda1$material3_release()
        L_0x0073:
            r3 = r13
            boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r13 == 0) goto L_0x0080
            r13 = -1
            java.lang.String r1 = "androidx.compose.material3.SnackbarHost (SnackbarHost.kt:221)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r14, r13, r1)
        L_0x0080:
            androidx.compose.material3.SnackbarData r13 = r11.getCurrentSnackbarData()
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalAccessibilityManager()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r2 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r1, r2)
            java.lang.Object r0 = r4.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.platform.AccessibilityManager r0 = (androidx.compose.ui.platform.AccessibilityManager) r0
            r1 = -487334772(0xffffffffe2f3dc8c, float:-2.2492254E21)
            java.lang.String r2 = "CC(remember):SnackbarHost.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r1, r2)
            boolean r1 = r4.changed((java.lang.Object) r13)
            boolean r2 = r4.changedInstance(r0)
            r1 = r1 | r2
            java.lang.Object r2 = r4.rememberedValue()
            if (r1 != 0) goto L_0x00ba
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r2 != r1) goto L_0x00c6
        L_0x00ba:
            androidx.compose.material3.SnackbarHostKt$SnackbarHost$1$1 r1 = new androidx.compose.material3.SnackbarHostKt$SnackbarHost$1$1
            r2 = 0
            r1.<init>(r13, r0, r2)
            r2 = r1
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r4.updateRememberedValue(r2)
        L_0x00c6:
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r0 = 0
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r13, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r2, (androidx.compose.runtime.Composer) r4, (int) r0)
            androidx.compose.material3.SnackbarData r1 = r11.getCurrentSnackbarData()
            r5 = r14 & 1008(0x3f0, float:1.413E-42)
            r6 = 0
            r2 = r12
            FadeInFadeOutWithScale(r1, r2, r3, r4, r5, r6)
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x00e3
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00e3:
            r7 = r2
            r8 = r3
        L_0x00e5:
            androidx.compose.runtime.ScopeUpdateScope r12 = r4.endRestartGroup()
            if (r12 == 0) goto L_0x00f9
            androidx.compose.material3.SnackbarHostKt$SnackbarHost$2 r5 = new androidx.compose.material3.SnackbarHostKt$SnackbarHost$2
            r6 = r11
            r9 = r15
            r10 = r16
            r5.<init>(r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r12.updateScope(r5)
        L_0x00f9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnackbarHostKt.SnackbarHost(androidx.compose.material3.SnackbarHostState, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final long toMillis(SnackbarDuration snackbarDuration, boolean z, AccessibilityManager accessibilityManager) {
        long j;
        int i = WhenMappings.$EnumSwitchMapping$0[snackbarDuration.ordinal()];
        if (i == 1) {
            j = Long.MAX_VALUE;
        } else if (i == 2) {
            j = WorkRequest.MIN_BACKOFF_MILLIS;
        } else if (i == 3) {
            j = 4000;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        long j2 = j;
        if (accessibilityManager == null) {
            return j2;
        }
        return accessibilityManager.calculateRecommendedTimeoutMillis(j2, true, true, z);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void FadeInFadeOutWithScale(androidx.compose.material3.SnackbarData r16, androidx.compose.ui.Modifier r17, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SnackbarData, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r18, androidx.compose.runtime.Composer r19, int r20, int r21) {
        /*
            r1 = r16
            r3 = r18
            r4 = r20
            r0 = -1316639904(0xffffffffb185ab60, float:-3.8902925E-9)
            r2 = r19
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r5 = "C(FadeInFadeOutWithScale)P(1,2)328@12730L48,393@15387L162:SnackbarHost.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r5)
            r5 = r21 & 1
            if (r5 == 0) goto L_0x001b
            r5 = r4 | 6
            goto L_0x002b
        L_0x001b:
            r5 = r4 & 6
            if (r5 != 0) goto L_0x002a
            boolean r5 = r2.changed((java.lang.Object) r1)
            if (r5 == 0) goto L_0x0027
            r5 = 4
            goto L_0x0028
        L_0x0027:
            r5 = 2
        L_0x0028:
            r5 = r5 | r4
            goto L_0x002b
        L_0x002a:
            r5 = r4
        L_0x002b:
            r6 = r21 & 2
            if (r6 == 0) goto L_0x0032
            r5 = r5 | 48
            goto L_0x0045
        L_0x0032:
            r7 = r4 & 48
            if (r7 != 0) goto L_0x0045
            r7 = r17
            boolean r8 = r2.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0041
            r8 = 32
            goto L_0x0043
        L_0x0041:
            r8 = 16
        L_0x0043:
            r5 = r5 | r8
            goto L_0x0047
        L_0x0045:
            r7 = r17
        L_0x0047:
            r8 = r21 & 4
            if (r8 == 0) goto L_0x004e
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x005e
        L_0x004e:
            r8 = r4 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x005e
            boolean r8 = r2.changedInstance(r3)
            if (r8 == 0) goto L_0x005b
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r5 = r5 | r8
        L_0x005e:
            r8 = r5 & 147(0x93, float:2.06E-43)
            r9 = 146(0x92, float:2.05E-43)
            if (r8 != r9) goto L_0x0071
            boolean r8 = r2.getSkipping()
            if (r8 != 0) goto L_0x006b
            goto L_0x0071
        L_0x006b:
            r2.skipToGroupEnd()
            r6 = r7
            goto L_0x0255
        L_0x0071:
            if (r6 == 0) goto L_0x0078
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            goto L_0x0079
        L_0x0078:
            r6 = r7
        L_0x0079:
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x0085
            r7 = -1
            java.lang.String r8 = "androidx.compose.material3.FadeInFadeOutWithScale (SnackbarHost.kt:327)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r5, r7, r8)
        L_0x0085:
            r0 = -1256815738(0xffffffffb5168386, float:-5.6070746E-7)
            java.lang.String r5 = "CC(remember):SnackbarHost.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r5)
            java.lang.Object r0 = r2.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r0 != r5) goto L_0x00a1
            androidx.compose.material3.FadeInFadeOutState r0 = new androidx.compose.material3.FadeInFadeOutState
            r0.<init>()
            r2.updateRememberedValue(r0)
        L_0x00a1:
            androidx.compose.material3.FadeInFadeOutState r0 = (androidx.compose.material3.FadeInFadeOutState) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r5 = -1256811491(0xffffffffb516941d, float:-5.609489E-7)
            r2.startReplaceGroup(r5)
            java.lang.String r5 = "*337@13129L2237"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r5)
            java.lang.Object r5 = r0.getCurrent()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r5)
            r7 = 54
            r9 = 1
            if (r5 != 0) goto L_0x0136
            r0.setCurrent(r1)
            java.util.List r5 = r0.getItems()
            java.util.ArrayList r10 = new java.util.ArrayList
            int r11 = r5.size()
            r10.<init>(r11)
            int r11 = r5.size()
            r12 = 0
        L_0x00d3:
            if (r12 >= r11) goto L_0x00ea
            java.lang.Object r13 = r5.get(r12)
            r14 = r10
            java.util.Collection r14 = (java.util.Collection) r14
            androidx.compose.material3.FadeInFadeOutAnimationItem r13 = (androidx.compose.material3.FadeInFadeOutAnimationItem) r13
            java.lang.Object r13 = r13.getKey()
            androidx.compose.material3.SnackbarData r13 = (androidx.compose.material3.SnackbarData) r13
            r14.add(r13)
            int r12 = r12 + 1
            goto L_0x00d3
        L_0x00ea:
            java.util.List r10 = (java.util.List) r10
            java.util.Collection r10 = (java.util.Collection) r10
            java.util.List r5 = kotlin.collections.CollectionsKt.toMutableList(r10)
            boolean r10 = r5.contains(r1)
            if (r10 != 0) goto L_0x00fb
            r5.add(r1)
        L_0x00fb:
            java.util.List r10 = r0.getItems()
            r10.clear()
            java.util.List r10 = androidx.compose.ui.util.ListUtilsKt.fastFilterNotNull(r5)
            java.util.List r11 = r0.getItems()
            java.util.Collection r11 = (java.util.Collection) r11
            int r12 = r10.size()
            r13 = 0
        L_0x0111:
            if (r13 >= r12) goto L_0x0134
            java.lang.Object r14 = r10.get(r13)
            androidx.compose.material3.SnackbarData r14 = (androidx.compose.material3.SnackbarData) r14
            androidx.compose.material3.FadeInFadeOutAnimationItem r15 = new androidx.compose.material3.FadeInFadeOutAnimationItem
            androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1 r8 = new androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1
            r8.<init>(r14, r1, r5, r0)
            r1 = -1654683077(0xffffffff9d5f8a3b, float:-2.9585268E-21)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r1, r9, r8, r2, r7)
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r15.<init>(r14, r1)
            r11.add(r15)
            int r13 = r13 + 1
            r1 = r16
            goto L_0x0111
        L_0x0134:
            java.util.List r11 = (java.util.List) r11
        L_0x0136:
            r2.endReplaceGroup()
            r1 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            java.lang.String r5 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r1, r5)
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getTopStart()
            r5 = 0
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r1, r5)
            r8 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r10 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r8, r10)
            int r8 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r5)
            androidx.compose.runtime.CompositionLocalMap r5 = r2.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r10 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r2, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r11 = r11.getConstructor()
            r12 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            java.lang.String r13 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r12, r13)
            androidx.compose.runtime.Applier r12 = r2.getApplier()
            boolean r12 = r12 instanceof androidx.compose.runtime.Applier
            if (r12 != 0) goto L_0x0179
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0179:
            r2.startReusableNode()
            boolean r12 = r2.getInserting()
            if (r12 == 0) goto L_0x0186
            r2.createNode(r11)
            goto L_0x0189
        L_0x0186:
            r2.useNode()
        L_0x0189:
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m3675constructorimpl(r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r11, r1, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r11, r5, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetCompositeKeyHash()
            boolean r5 = r11.getInserting()
            if (r5 != 0) goto L_0x01b9
            java.lang.Object r5 = r11.rememberedValue()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r8)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r12)
            if (r5 != 0) goto L_0x01c7
        L_0x01b9:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r8)
            r11.updateRememberedValue(r5)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r8)
            r11.apply(r5, r1)
        L_0x01c7:
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r11, r10, r1)
            r1 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            java.lang.String r5 = "C73@3429L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r1, r5)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            r1 = -1643979990(0xffffffff9e02db2a, float:-6.927465E-21)
            java.lang.String r5 = "C394@15425L21:SnackbarHost.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r1, r5)
            r5 = 0
            androidx.compose.runtime.RecomposeScope r1 = androidx.compose.runtime.ComposablesKt.getCurrentRecomposeScope(r2, r5)
            r0.setScope(r1)
            r1 = 1748085441(0x6831aac1, float:3.356035E24)
            r2.startReplaceGroup(r1)
            java.lang.String r1 = ""
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r1)
            java.util.List r0 = r0.getItems()
            int r1 = r0.size()
            r8 = r5
        L_0x0200:
            if (r8 >= r1) goto L_0x0237
            java.lang.Object r5 = r0.get(r8)
            androidx.compose.material3.FadeInFadeOutAnimationItem r5 = (androidx.compose.material3.FadeInFadeOutAnimationItem) r5
            java.lang.Object r10 = r5.component1()
            androidx.compose.material3.SnackbarData r10 = (androidx.compose.material3.SnackbarData) r10
            kotlin.jvm.functions.Function3 r5 = r5.component2()
            r11 = 1201076541(0x4796f93d, float:77298.48)
            r2.startMovableGroup(r11, r10)
            java.lang.String r11 = "395@15520L19,395@15512L27"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r11)
            androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$2$1$1 r11 = new androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$2$1$1
            r11.<init>(r3, r10)
            r10 = -1135367807(0xffffffffbc53a981, float:-0.012918831)
            androidx.compose.runtime.internal.ComposableLambda r10 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r10, r9, r11, r2, r7)
            r11 = 6
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r5.invoke(r10, r2, r11)
            r2.endMovableGroup()
            int r8 = r8 + 1
            goto L_0x0200
        L_0x0237:
            r2.endReplaceGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r2.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0255
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0255:
            androidx.compose.runtime.ScopeUpdateScope r7 = r2.endRestartGroup()
            if (r7 == 0) goto L_0x026a
            androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$3 r0 = new androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$3
            r1 = r16
            r5 = r21
            r2 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r7.updateScope(r0)
        L_0x026a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnackbarHostKt.FadeInFadeOutWithScale(androidx.compose.material3.SnackbarData, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final State<Float> animatedOpacity(AnimationSpec<Float> animationSpec, boolean z, Function0<Unit> function0, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1431889134, "C(animatedOpacity)P(!1,2)419@16197L49,420@16275L111,420@16251L135:SnackbarHost.kt#uh7d8r");
        if ((i2 & 4) != 0) {
            function0 = SnackbarHostKt$animatedOpacity$1.INSTANCE;
        }
        Function0<Unit> function02 = function0;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1431889134, i, -1, "androidx.compose.material3.animatedOpacity (SnackbarHost.kt:418)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2104079446, "CC(remember):SnackbarHost.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = AnimatableKt.Animatable$default(!z ? 1.0f : 0.0f, 0.0f, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        Animatable animatable = (Animatable) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        Boolean valueOf = Boolean.valueOf(z);
        ComposerKt.sourceInformationMarkerStart(composer, 2104082004, "CC(remember):SnackbarHost.kt#9igjgp");
        boolean z2 = false;
        boolean changedInstance = composer.changedInstance(animatable) | ((((i & 112) ^ 48) > 32 && composer.changed(z)) || (i & 48) == 32) | composer.changedInstance(animationSpec);
        if ((((i & 896) ^ 384) > 256 && composer.changed((Object) function02)) || (i & 384) == 256) {
            z2 = true;
        }
        boolean z3 = changedInstance | z2;
        Object rememberedValue2 = composer.rememberedValue();
        if (z3 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new SnackbarHostKt$animatedOpacity$2$1(animatable, z, animationSpec, function02, (Continuation<? super SnackbarHostKt$animatedOpacity$2$1>) null);
            composer.updateRememberedValue(rememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect((Object) valueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue2, composer, (i >> 3) & 14);
        State<Float> asState = animatable.asState();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return asState;
    }

    /* access modifiers changed from: private */
    public static final State<Float> animatedScale(AnimationSpec<Float> animationSpec, boolean z, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1966809761, "C(animatedScale)429@16538L51,430@16618L85,430@16594L109:SnackbarHost.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1966809761, i, -1, "androidx.compose.material3.animatedScale (SnackbarHost.kt:428)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1433330423, "CC(remember):SnackbarHost.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = AnimatableKt.Animatable$default(!z ? 1.0f : 0.8f, 0.0f, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        Animatable animatable = (Animatable) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        Boolean valueOf = Boolean.valueOf(z);
        ComposerKt.sourceInformationMarkerStart(composer, 1433333017, "CC(remember):SnackbarHost.kt#9igjgp");
        boolean changedInstance = composer.changedInstance(animatable) | ((((i & 112) ^ 48) > 32 && composer.changed(z)) || (i & 48) == 32) | composer.changedInstance(animationSpec);
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new SnackbarHostKt$animatedScale$1$1(animatable, z, animationSpec, (Continuation<? super SnackbarHostKt$animatedScale$1$1>) null);
            composer.updateRememberedValue(rememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect((Object) valueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue2, composer, (i >> 3) & 14);
        State<Float> asState = animatable.asState();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return asState;
    }
}
