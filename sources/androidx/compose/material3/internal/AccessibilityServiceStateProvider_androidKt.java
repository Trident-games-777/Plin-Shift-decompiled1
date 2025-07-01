package androidx.compose.material3.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0003¢\u0006\u0002\u0010\u000b\u001a'\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000eH\u0001¢\u0006\u0002\u0010\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"SwitchAccessActivityName", "", "ObserveState", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "handleEvent", "Lkotlin/Function1;", "Landroidx/lifecycle/Lifecycle$Event;", "onDispose", "Lkotlin/Function0;", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "rememberAccessibilityServiceState", "Landroidx/compose/runtime/State;", "", "listenToTouchExplorationState", "listenToSwitchAccessState", "(ZZLandroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AccessibilityServiceStateProvider.android.kt */
public final class AccessibilityServiceStateProvider_androidKt {
    private static final String SwitchAccessActivityName = "SwitchAccess";

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.runtime.State<java.lang.Boolean> rememberAccessibilityServiceState(boolean r11, boolean r12, androidx.compose.runtime.Composer r13, int r14, int r15) {
        /*
            java.lang.String r0 = "C(rememberAccessibilityServiceState)P(1)47@1997L7,52@2152L157,57@2374L7,58@2405L144,63@2571L45,56@2315L307:AccessibilityServiceStateProvider.android.kt#mqatfk"
            r1 = -1771705152(0xffffffff9665ecc0, float:-1.8573178E-25)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r1, r0)
            r0 = r15 & 1
            r2 = 1
            if (r0 == 0) goto L_0x000e
            r11 = r2
        L_0x000e:
            r15 = r15 & 2
            if (r15 == 0) goto L_0x0013
            r12 = r2
        L_0x0013:
            boolean r15 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r15 == 0) goto L_0x001f
            r15 = -1
            java.lang.String r0 = "androidx.compose.material3.internal.rememberAccessibilityServiceState (AccessibilityServiceStateProvider.android.kt:46)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r14, r15, r0)
        L_0x001f:
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
            r0 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r1 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r0, r1)
            java.lang.Object r15 = r13.consume(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            android.content.Context r15 = (android.content.Context) r15
            java.lang.String r3 = "accessibility"
            java.lang.Object r15 = r15.getSystemService(r3)
            java.lang.String r3 = "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15, r3)
            android.view.accessibility.AccessibilityManager r15 = (android.view.accessibility.AccessibilityManager) r15
            r3 = 18334252(0x117c22c, float:2.787363E-38)
            java.lang.String r4 = "CC(remember):AccessibilityServiceStateProvider.android.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r3, r4)
            r3 = r14 & 14
            r3 = r3 ^ 6
            r5 = 0
            r6 = 4
            if (r3 <= r6) goto L_0x0059
            boolean r3 = r13.changed((boolean) r11)
            if (r3 != 0) goto L_0x005d
        L_0x0059:
            r3 = r14 & 6
            if (r3 != r6) goto L_0x005f
        L_0x005d:
            r3 = r2
            goto L_0x0060
        L_0x005f:
            r3 = r5
        L_0x0060:
            r6 = r14 & 112(0x70, float:1.57E-43)
            r6 = r6 ^ 48
            r7 = 32
            if (r6 <= r7) goto L_0x006e
            boolean r6 = r13.changed((boolean) r12)
            if (r6 != 0) goto L_0x0074
        L_0x006e:
            r14 = r14 & 48
            if (r14 != r7) goto L_0x0073
            goto L_0x0074
        L_0x0073:
            r2 = r5
        L_0x0074:
            r14 = r3 | r2
            java.lang.Object r2 = r13.rememberedValue()
            if (r14 != 0) goto L_0x0084
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r2 != r14) goto L_0x008c
        L_0x0084:
            androidx.compose.material3.internal.Listener r2 = new androidx.compose.material3.internal.Listener
            r2.<init>(r11, r12)
            r13.updateRememberedValue(r2)
        L_0x008c:
            androidx.compose.material3.internal.Listener r2 = (androidx.compose.material3.internal.Listener) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.lifecycle.compose.LocalLifecycleOwnerKt.getLocalLifecycleOwner()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r0, r1)
            java.lang.Object r11 = r13.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r5 = r11
            androidx.lifecycle.LifecycleOwner r5 = (androidx.lifecycle.LifecycleOwner) r5
            r11 = 18342335(0x117e1bf, float:2.7896285E-38)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r11, r4)
            boolean r11 = r13.changed((java.lang.Object) r2)
            boolean r12 = r13.changedInstance(r15)
            r11 = r11 | r12
            java.lang.Object r12 = r13.rememberedValue()
            if (r11 != 0) goto L_0x00c1
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r12 != r11) goto L_0x00cc
        L_0x00c1:
            androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt$rememberAccessibilityServiceState$1$1 r11 = new androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt$rememberAccessibilityServiceState$1$1
            r11.<init>(r2, r15)
            r12 = r11
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            r13.updateRememberedValue(r12)
        L_0x00cc:
            r6 = r12
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r11 = 18347548(0x117f61c, float:2.7910895E-38)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r11, r4)
            boolean r11 = r13.changed((java.lang.Object) r2)
            boolean r12 = r13.changedInstance(r15)
            r11 = r11 | r12
            java.lang.Object r12 = r13.rememberedValue()
            if (r11 != 0) goto L_0x00ef
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r12 != r11) goto L_0x00fa
        L_0x00ef:
            androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt$rememberAccessibilityServiceState$2$1 r11 = new androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt$rememberAccessibilityServiceState$2$1
            r11.<init>(r2, r15)
            r12 = r11
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12
            r13.updateRememberedValue(r12)
        L_0x00fa:
            r7 = r12
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r9 = 0
            r10 = 0
            r8 = r13
            ObserveState(r5, r6, r7, r8, r9, r10)
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x010f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x010f:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.runtime.State r2 = (androidx.compose.runtime.State) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt.rememberAccessibilityServiceState(boolean, boolean, androidx.compose.runtime.Composer, int, int):androidx.compose.runtime.State");
    }

    /* access modifiers changed from: private */
    public static final void ObserveState(LifecycleOwner lifecycleOwner, Function1<? super Lifecycle.Event, Unit> function1, Function0<Unit> function0, Composer composer, int i, int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1868327245);
        ComposerKt.sourceInformation(startRestartGroup, "C(ObserveState)P(1)75@2842L259,75@2809L292:AccessibilityServiceStateProvider.android.kt#mqatfk");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(lifecycleOwner) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i3 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                function1 = AccessibilityServiceStateProvider_androidKt$ObserveState$1.INSTANCE;
            }
            if (i5 != 0) {
                function0 = AccessibilityServiceStateProvider_androidKt$ObserveState$2.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1868327245, i3, -1, "androidx.compose.material3.internal.ObserveState (AccessibilityServiceStateProvider.android.kt:74)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1591666214, "CC(remember):AccessibilityServiceStateProvider.android.kt#9igjgp");
            boolean z = false;
            boolean changedInstance = ((i3 & 112) == 32) | startRestartGroup.changedInstance(lifecycleOwner);
            if ((i3 & 896) == 256) {
                z = true;
            }
            boolean z2 = changedInstance | z;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new AccessibilityServiceStateProvider_androidKt$ObserveState$3$1(lifecycleOwner, function1, function0);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.DisposableEffect((Object) lifecycleOwner, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) (Function1) rememberedValue, startRestartGroup, i3 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        Function1<? super Lifecycle.Event, Unit> function12 = function1;
        Function0<Unit> function02 = function0;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AccessibilityServiceStateProvider_androidKt$ObserveState$4(lifecycleOwner, function12, function02, i, i2));
        }
    }
}
