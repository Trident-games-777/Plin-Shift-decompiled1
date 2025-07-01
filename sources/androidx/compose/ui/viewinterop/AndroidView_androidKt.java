package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.view.View;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ay\u0010\u0007\u001a\u00020\u0003\"\b\b\u0000\u0010\b*\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\b0\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00030\u00012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0002\u0010\u0010\u001aK\u0010\u0007\u001a\u00020\u0003\"\b\b\u0000\u0010\b*\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\b0\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0002\u0010\u0011\u001a1\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\"\b\b\u0000\u0010\b*\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\b0\u0001H\u0003¢\u0006\u0002\u0010\u0015\u001a\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\b0\u0017\"\b\b\u0000\u0010\b*\u00020\u0002*\u00020\u0014H\u0002\u001a^\u0010\u0018\u001a\u00020\u0003\"\b\b\u0000\u0010\b*\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00140\u00192\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002ø\u0001\u0000¢\u0006\u0004\b&\u0010'\"\"\u0010\u0000\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006("}, d2 = {"NoOpUpdate", "Lkotlin/Function1;", "Landroid/view/View;", "", "Lkotlin/ExtensionFunctionType;", "getNoOpUpdate", "()Lkotlin/jvm/functions/Function1;", "AndroidView", "T", "factory", "Landroid/content/Context;", "modifier", "Landroidx/compose/ui/Modifier;", "onReset", "onRelease", "update", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "createAndroidViewNodeFactory", "Lkotlin/Function0;", "Landroidx/compose/ui/node/LayoutNode;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "requireViewFactoryHolder", "Landroidx/compose/ui/viewinterop/ViewFactoryHolder;", "updateViewHolderParams", "Landroidx/compose/runtime/Updater;", "compositeKeyHash", "", "density", "Landroidx/compose/ui/unit/Density;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "compositionLocalMap", "Landroidx/compose/runtime/CompositionLocalMap;", "updateViewHolderParams-6NefGtU", "(Landroidx/compose/runtime/Composer;Landroidx/compose/ui/Modifier;ILandroidx/compose/ui/unit/Density;Landroidx/lifecycle/LifecycleOwner;Landroidx/savedstate/SavedStateRegistryOwner;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/runtime/CompositionLocalMap;)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidView.android.kt */
public final class AndroidView_androidKt {
    private static final Function1<View, Unit> NoOpUpdate = AndroidView_androidKt$NoOpUpdate$1.INSTANCE;

    public static final <T extends View> void AndroidView(Function1<? super Context, ? extends T> function1, Modifier modifier, Function1<? super T, Unit> function12, Composer composer, int i, int i2) {
        int i3;
        Function1<? super T, Unit> function13;
        Modifier modifier2;
        int i4 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1783766393);
        ComposerKt.sourceInformation(startRestartGroup, "C(AndroidView)108@5537L130:AndroidView.android.kt#z33iqn");
        if ((i2 & 1) != 0) {
            i3 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function1) ? 4 : 2) | i4;
        } else {
            i3 = i4;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i4 & 48) == 0) {
            i3 |= startRestartGroup.changed((Object) modifier) ? 32 : 16;
        }
        int i6 = i2 & 4;
        if (i6 != 0) {
            i3 |= 384;
        } else if ((i4 & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function12) ? 256 : 128;
        }
        if ((i3 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (i5 != 0) {
                modifier = Modifier.Companion;
            }
            Modifier modifier3 = modifier;
            Function1<View, Unit> function14 = function12;
            if (i6 != 0) {
                function14 = NoOpUpdate;
            }
            Function1<? super T, Unit> function15 = function14;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1783766393, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:107)");
            }
            AndroidView(function1, modifier3, (Function1) null, NoOpUpdate, function15, startRestartGroup, (i3 & 14) | 3072 | (i3 & 112) | (57344 & (i3 << 6)), 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            function13 = function15;
        } else {
            startRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            function13 = function12;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AndroidView_androidKt$AndroidView$1(function1, modifier2, function13, i4, i2));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T extends android.view.View> void AndroidView(kotlin.jvm.functions.Function1<? super android.content.Context, ? extends T> r21, androidx.compose.ui.Modifier r22, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r23, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r24, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r25, androidx.compose.runtime.Composer r26, int r27, int r28) {
        /*
            r1 = r21
            r6 = r27
            r0 = -180024211(0xfffffffff5450c6d, float:-2.497887E32)
            r2 = r26
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(AndroidView)P(!2,3)212@11953L23,214@12100L7,215@12155L7,222@12611L7,223@12682L7:AndroidView.android.kt#z33iqn"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r28 & 1
            if (r3 == 0) goto L_0x0019
            r3 = r6 | 6
            goto L_0x0029
        L_0x0019:
            r3 = r6 & 6
            if (r3 != 0) goto L_0x0028
            boolean r3 = r2.changedInstance(r1)
            if (r3 == 0) goto L_0x0025
            r3 = 4
            goto L_0x0026
        L_0x0025:
            r3 = 2
        L_0x0026:
            r3 = r3 | r6
            goto L_0x0029
        L_0x0028:
            r3 = r6
        L_0x0029:
            r4 = r28 & 2
            if (r4 == 0) goto L_0x0030
            r3 = r3 | 48
            goto L_0x0043
        L_0x0030:
            r5 = r6 & 48
            if (r5 != 0) goto L_0x0043
            r5 = r22
            boolean r7 = r2.changed((java.lang.Object) r5)
            if (r7 == 0) goto L_0x003f
            r7 = 32
            goto L_0x0041
        L_0x003f:
            r7 = 16
        L_0x0041:
            r3 = r3 | r7
            goto L_0x0045
        L_0x0043:
            r5 = r22
        L_0x0045:
            r7 = r28 & 4
            if (r7 == 0) goto L_0x004c
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004c:
            r8 = r6 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x005f
            r8 = r23
            boolean r9 = r2.changedInstance(r8)
            if (r9 == 0) goto L_0x005b
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r9 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r3 = r3 | r9
            goto L_0x0061
        L_0x005f:
            r8 = r23
        L_0x0061:
            r9 = r28 & 8
            if (r9 == 0) goto L_0x0068
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007b
        L_0x0068:
            r10 = r6 & 3072(0xc00, float:4.305E-42)
            if (r10 != 0) goto L_0x007b
            r10 = r24
            boolean r11 = r2.changedInstance(r10)
            if (r11 == 0) goto L_0x0077
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0077:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r3 = r3 | r11
            goto L_0x007d
        L_0x007b:
            r10 = r24
        L_0x007d:
            r11 = r28 & 16
            if (r11 == 0) goto L_0x0084
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0097
        L_0x0084:
            r12 = r6 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x0097
            r12 = r25
            boolean r13 = r2.changedInstance(r12)
            if (r13 == 0) goto L_0x0093
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0095
        L_0x0093:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0095:
            r3 = r3 | r13
            goto L_0x0099
        L_0x0097:
            r12 = r25
        L_0x0099:
            r13 = r3 & 9363(0x2493, float:1.312E-41)
            r14 = 9362(0x2492, float:1.3119E-41)
            if (r13 != r14) goto L_0x00ae
            boolean r13 = r2.getSkipping()
            if (r13 != 0) goto L_0x00a6
            goto L_0x00ae
        L_0x00a6:
            r2.skipToGroupEnd()
            r4 = r5
        L_0x00aa:
            r3 = r8
            r5 = r12
            goto L_0x01ef
        L_0x00ae:
            if (r4 == 0) goto L_0x00b5
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x00b6
        L_0x00b5:
            r4 = r5
        L_0x00b6:
            if (r7 == 0) goto L_0x00ba
            r5 = 0
            r8 = r5
        L_0x00ba:
            if (r9 == 0) goto L_0x00bf
            kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit> r5 = NoOpUpdate
            r10 = r5
        L_0x00bf:
            if (r11 == 0) goto L_0x00c4
            kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit> r5 = NoOpUpdate
            r12 = r5
        L_0x00c4:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x00d0
            r5 = -1
            java.lang.String r7 = "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:211)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r5, r7)
        L_0x00d0:
            r0 = 0
            int r15 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r0)
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.viewinterop.FocusGroupNode_androidKt.focusInteropModifier(r4)
            androidx.compose.ui.Modifier r14 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r2, r0)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r5, r7)
            java.lang.Object r0 = r2.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r16 = r0
            androidx.compose.ui.unit.Density r16 = (androidx.compose.ui.unit.Density) r16
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r5, r7)
            java.lang.Object r0 = r2.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r19 = r0
            androidx.compose.ui.unit.LayoutDirection r19 = (androidx.compose.ui.unit.LayoutDirection) r19
            androidx.compose.runtime.CompositionLocalMap r20 = r2.getCurrentCompositionLocalMap()
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.lifecycle.compose.LocalLifecycleOwnerKt.getLocalLifecycleOwner()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r5, r7)
            java.lang.Object r0 = r2.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r17 = r0
            androidx.lifecycle.LifecycleOwner r17 = (androidx.lifecycle.LifecycleOwner) r17
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r5, r7)
            java.lang.Object r0 = r2.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r18 = r0
            androidx.savedstate.SavedStateRegistryOwner r18 = (androidx.savedstate.SavedStateRegistryOwner) r18
            if (r8 == 0) goto L_0x0192
            r0 = 607871394(0x243b61a2, float:4.063186E-17)
            r2.startReplaceGroup(r0)
            java.lang.String r0 = "227@12792L37,226@12726L843"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            r0 = r3 & 14
            kotlin.jvm.functions.Function0 r0 = createAndroidViewNodeFactory(r1, r2, r0)
            r3 = 1405779621(0x53ca7ea5, float:1.73941627E12)
            java.lang.String r5 = "CC(ReusableComposeNode):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r3, r5)
            androidx.compose.runtime.Applier r3 = r2.getApplier()
            boolean r3 = r3 instanceof androidx.compose.ui.node.UiApplier
            if (r3 != 0) goto L_0x015c
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x015c:
            r2.startReusableNode()
            boolean r3 = r2.getInserting()
            if (r3 == 0) goto L_0x0169
            r2.createNode(r0)
            goto L_0x016c
        L_0x0169:
            r2.useNode()
        L_0x016c:
            androidx.compose.runtime.Composer r13 = androidx.compose.runtime.Updater.m3675constructorimpl(r2)
            m7363updateViewHolderParams6NefGtU(r13, r14, r15, r16, r17, r18, r19, r20)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$1 r0 = androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$1.INSTANCE
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r13, r8, r0)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$2 r0 = androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$2.INSTANCE
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r13, r12, r0)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$3 r0 = androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$3.INSTANCE
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r13, r10, r0)
            r2.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r2.endReplaceGroup()
            goto L_0x01e4
        L_0x0192:
            r0 = 608726777(0x24486ef9, float:4.3462084E-17)
            r2.startReplaceGroup(r0)
            java.lang.String r0 = "245@13649L37,244@13591L756"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            r0 = r3 & 14
            kotlin.jvm.functions.Function0 r0 = createAndroidViewNodeFactory(r1, r2, r0)
            r3 = 1886828752(0x7076b8d0, float:3.0542695E29)
            java.lang.String r5 = "CC(ComposeNode):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r3, r5)
            androidx.compose.runtime.Applier r3 = r2.getApplier()
            boolean r3 = r3 instanceof androidx.compose.ui.node.UiApplier
            if (r3 != 0) goto L_0x01b6
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01b6:
            r2.startNode()
            boolean r3 = r2.getInserting()
            if (r3 == 0) goto L_0x01c3
            r2.createNode(r0)
            goto L_0x01c6
        L_0x01c3:
            r2.useNode()
        L_0x01c6:
            androidx.compose.runtime.Composer r13 = androidx.compose.runtime.Updater.m3675constructorimpl(r2)
            m7363updateViewHolderParams6NefGtU(r13, r14, r15, r16, r17, r18, r19, r20)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$1 r0 = androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$1.INSTANCE
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r13, r12, r0)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$2 r0 = androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$2.INSTANCE
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r13, r10, r0)
            r2.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r2.endReplaceGroup()
        L_0x01e4:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x00aa
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x00aa
        L_0x01ef:
            androidx.compose.runtime.ScopeUpdateScope r8 = r2.endRestartGroup()
            if (r8 == 0) goto L_0x0203
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$4 r0 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$4
            r7 = r28
            r2 = r4
            r4 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r8.updateScope(r0)
        L_0x0203:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView(kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final <T extends View> Function0<LayoutNode> createAndroidViewNodeFactory(Function1<? super Context, ? extends T> function1, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 2030558801, "C(createAndroidViewNodeFactory)267@14499L23,268@14554L7,269@14588L28,270@14668L7,271@14706L7,273@14726L297:AndroidView.android.kt#z33iqn");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2030558801, i, -1, "androidx.compose.ui.viewinterop.createAndroidViewNodeFactory (AndroidView.android.kt:266)");
        }
        boolean z = false;
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) consume;
        CompositionContext rememberCompositionContext = ComposablesKt.rememberCompositionContext(composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(SaveableStateRegistryKt.getLocalSaveableStateRegistry());
        ComposerKt.sourceInformationMarkerEnd(composer);
        SaveableStateRegistry saveableStateRegistry = (SaveableStateRegistry) consume2;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume3 = composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        ComposerKt.sourceInformationMarkerEnd(composer);
        View view = (View) consume3;
        ComposerKt.sourceInformationMarkerStart(composer, -1137327224, "CC(remember):AndroidView.android.kt#9igjgp");
        boolean changedInstance = composer.changedInstance(context);
        if ((((i & 14) ^ 6) > 4 && composer.changed((Object) function1)) || (i & 6) == 4) {
            z = true;
        }
        boolean changedInstance2 = changedInstance | z | composer.changedInstance(rememberCompositionContext) | composer.changedInstance(saveableStateRegistry) | composer.changed(currentCompositeKeyHash) | composer.changedInstance(view);
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance2 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new AndroidView_androidKt$createAndroidViewNodeFactory$1$1(context, function1, rememberCompositionContext, saveableStateRegistry, currentCompositeKeyHash, view);
            composer.updateRememberedValue(rememberedValue);
        }
        Function0<LayoutNode> function0 = (Function0) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return function0;
    }

    /* renamed from: updateViewHolderParams-6NefGtU  reason: not valid java name */
    private static final <T extends View> void m7363updateViewHolderParams6NefGtU(Composer composer, Modifier modifier, int i, Density density, LifecycleOwner lifecycleOwner, SavedStateRegistryOwner savedStateRegistryOwner, LayoutDirection layoutDirection, CompositionLocalMap compositionLocalMap) {
        Updater.m3682setimpl(composer, compositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.m3682setimpl(composer, modifier, AndroidView_androidKt$updateViewHolderParams$1.INSTANCE);
        Updater.m3682setimpl(composer, density, AndroidView_androidKt$updateViewHolderParams$2.INSTANCE);
        Updater.m3682setimpl(composer, lifecycleOwner, AndroidView_androidKt$updateViewHolderParams$3.INSTANCE);
        Updater.m3682setimpl(composer, savedStateRegistryOwner, AndroidView_androidKt$updateViewHolderParams$4.INSTANCE);
        Updater.m3682setimpl(composer, layoutDirection, AndroidView_androidKt$updateViewHolderParams$5.INSTANCE);
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), (Object) Integer.valueOf(i))) {
            composer.updateRememberedValue(Integer.valueOf(i));
            composer.apply(Integer.valueOf(i), setCompositeKeyHash);
        }
    }

    /* access modifiers changed from: private */
    public static final <T extends View> ViewFactoryHolder<T> requireViewFactoryHolder(LayoutNode layoutNode) {
        AndroidViewHolder interopViewFactoryHolder$ui_release = layoutNode.getInteropViewFactoryHolder$ui_release();
        if (interopViewFactoryHolder$ui_release != null) {
            return (ViewFactoryHolder) interopViewFactoryHolder$ui_release;
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
        throw new KotlinNothingValueException();
    }

    public static final Function1<View, Unit> getNoOpUpdate() {
        return NoOpUpdate;
    }
}
