package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0001\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0002\u0010\u001a\u001aa\u0010\u001b\u001a\u00020\u00072\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u001d2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010 \u001a[\u0010\u001b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010!\u001ak\u0010\"\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0002\u0010#\u001am\u0010\u001b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010$\u001ae\u0010\u001b\u001a\u00020\u0007*\u00020%2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u001d2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010&\u001a_\u0010\u001b\u001a\u00020\u0007*\u00020%2\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010'\u001ae\u0010\u001b\u001a\u00020\u0007*\u00020(2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u001d2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010)\u001a_\u0010\u001b\u001a\u00020\u0007*\u00020(2\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010*\u001a9\u0010+\u001a\u00020\u0003\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010,\u001a\u0002H\bH\u0003¢\u0006\u0002\u0010-\"\u001e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006.²\u0006\"\u0010/\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0013\"\u0004\b\u0000\u0010\bX\u0002²\u0006\u0010\u00100\u001a\u00020\u0001\"\u0004\b\u0000\u0010\bX\u0002"}, d2 = {"exitFinished", "", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "getExitFinished", "(Landroidx/compose/animation/core/Transition;)Z", "AnimatedEnterExitImpl", "", "T", "transition", "visible", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "shouldDisposeBlock", "Lkotlin/Function2;", "onLookaheadMeasured", "Landroidx/compose/animation/OnLookaheadMeasured;", "content", "Landroidx/compose/animation/AnimatedVisibilityScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function2;Landroidx/compose/animation/OnLookaheadMeasured;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "AnimatedVisibility", "visibleState", "Landroidx/compose/animation/core/MutableTransitionState;", "label", "", "(Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "AnimatedVisibilityImpl", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/ColumnScope;", "(Landroidx/compose/foundation/layout/ColumnScope;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/layout/ColumnScope;ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/RowScope;", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/layout/RowScope;ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "targetEnterExit", "targetState", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/EnterExitState;", "animation_release", "shouldDisposeBlockUpdated", "shouldDisposeAfterExit"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedVisibility.kt */
public final class AnimatedVisibilityKt {
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AnimatedVisibility(boolean r22, androidx.compose.ui.Modifier r23, androidx.compose.animation.EnterTransition r24, androidx.compose.animation.ExitTransition r25, java.lang.String r26, kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, androidx.compose.runtime.Composer r28, int r29, int r30) {
        /*
            r7 = r29
            r0 = 2088733774(0x7c7f8c4e, float:5.3075257E36)
            r1 = r28
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AnimatedVisibility)P(5,4,1,2,3)132@6967L32,133@7004L84:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            r1 = r30 & 1
            if (r1 == 0) goto L_0x001a
            r1 = r7 | 6
            r2 = r1
            r1 = r22
            goto L_0x002e
        L_0x001a:
            r1 = r7 & 6
            if (r1 != 0) goto L_0x002b
            r1 = r22
            boolean r2 = r14.changed((boolean) r1)
            if (r2 == 0) goto L_0x0028
            r2 = 4
            goto L_0x0029
        L_0x0028:
            r2 = 2
        L_0x0029:
            r2 = r2 | r7
            goto L_0x002e
        L_0x002b:
            r1 = r22
            r2 = r7
        L_0x002e:
            r3 = r30 & 2
            if (r3 == 0) goto L_0x0035
            r2 = r2 | 48
            goto L_0x0048
        L_0x0035:
            r4 = r7 & 48
            if (r4 != 0) goto L_0x0048
            r4 = r23
            boolean r5 = r14.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0044
            r5 = 32
            goto L_0x0046
        L_0x0044:
            r5 = 16
        L_0x0046:
            r2 = r2 | r5
            goto L_0x004a
        L_0x0048:
            r4 = r23
        L_0x004a:
            r5 = r30 & 4
            if (r5 == 0) goto L_0x0051
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0051:
            r6 = r7 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0064
            r6 = r24
            boolean r8 = r14.changed((java.lang.Object) r6)
            if (r8 == 0) goto L_0x0060
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r2 = r2 | r8
            goto L_0x0066
        L_0x0064:
            r6 = r24
        L_0x0066:
            r8 = r30 & 8
            if (r8 == 0) goto L_0x006d
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0080
        L_0x006d:
            r9 = r7 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x0080
            r9 = r25
            boolean r10 = r14.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x007c
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r2 = r2 | r10
            goto L_0x0082
        L_0x0080:
            r9 = r25
        L_0x0082:
            r10 = r30 & 16
            if (r10 == 0) goto L_0x0089
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009c
        L_0x0089:
            r11 = r7 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x009c
            r11 = r26
            boolean r12 = r14.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0098
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009a
        L_0x0098:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x009a:
            r2 = r2 | r12
            goto L_0x009e
        L_0x009c:
            r11 = r26
        L_0x009e:
            r12 = r30 & 32
            r13 = 196608(0x30000, float:2.75506E-40)
            if (r12 == 0) goto L_0x00a8
            r2 = r2 | r13
            r13 = r27
            goto L_0x00ba
        L_0x00a8:
            r12 = r7 & r13
            r13 = r27
            if (r12 != 0) goto L_0x00ba
            boolean r12 = r14.changedInstance(r13)
            if (r12 == 0) goto L_0x00b7
            r12 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b9
        L_0x00b7:
            r12 = 65536(0x10000, float:9.18355E-41)
        L_0x00b9:
            r2 = r2 | r12
        L_0x00ba:
            r12 = 74899(0x12493, float:1.04956E-40)
            r12 = r12 & r2
            r15 = 74898(0x12492, float:1.04954E-40)
            if (r12 != r15) goto L_0x00d3
            boolean r12 = r14.getSkipping()
            if (r12 != 0) goto L_0x00ca
            goto L_0x00d3
        L_0x00ca:
            r14.skipToGroupEnd()
            r2 = r4
            r3 = r6
            r4 = r9
            r5 = r11
            goto L_0x0163
        L_0x00d3:
            if (r3 == 0) goto L_0x00da
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x00db
        L_0x00da:
            r3 = r4
        L_0x00db:
            r4 = 0
            r12 = 3
            r15 = 0
            if (r5 == 0) goto L_0x00f9
            androidx.compose.animation.EnterTransition r5 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r15, r4, r12, r15)
            r20 = 15
            r21 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            androidx.compose.animation.EnterTransition r6 = androidx.compose.animation.EnterExitTransitionKt.expandIn$default(r16, r17, r18, r19, r20, r21)
            androidx.compose.animation.EnterTransition r5 = r5.plus(r6)
            goto L_0x00fa
        L_0x00f9:
            r5 = r6
        L_0x00fa:
            if (r8 == 0) goto L_0x0116
            r20 = 15
            r21 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            androidx.compose.animation.ExitTransition r6 = androidx.compose.animation.EnterExitTransitionKt.shrinkOut$default(r16, r17, r18, r19, r20, r21)
            androidx.compose.animation.ExitTransition r4 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r15, r4, r12, r15)
            androidx.compose.animation.ExitTransition r4 = r6.plus(r4)
            r12 = r4
            goto L_0x0117
        L_0x0116:
            r12 = r9
        L_0x0117:
            if (r10 == 0) goto L_0x011c
            java.lang.String r4 = "AnimatedVisibility"
            goto L_0x011d
        L_0x011c:
            r4 = r11
        L_0x011d:
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x0129
            r6 = -1
            java.lang.String r8 = "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r6, r8)
        L_0x0129:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            r6 = r2 & 14
            int r8 = r2 >> 9
            r8 = r8 & 112(0x70, float:1.57E-43)
            r6 = r6 | r8
            r8 = 0
            androidx.compose.animation.core.Transition r8 = androidx.compose.animation.core.TransitionKt.updateTransition(r0, (java.lang.String) r4, (androidx.compose.runtime.Composer) r14, (int) r6, (int) r8)
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1 r0 = androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1.INSTANCE
            r9 = r0
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            int r0 = r2 << 3
            r6 = r0 & 896(0x380, float:1.256E-42)
            r6 = r6 | 48
            r10 = r0 & 7168(0x1c00, float:1.0045E-41)
            r6 = r6 | r10
            r10 = 57344(0xe000, float:8.0356E-41)
            r0 = r0 & r10
            r0 = r0 | r6
            r6 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r6
            r15 = r0 | r2
            r10 = r3
            r11 = r5
            AnimatedVisibilityImpl(r8, r9, r10, r11, r12, r13, r14, r15)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x015f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x015f:
            r5 = r4
            r2 = r10
            r3 = r11
            r4 = r12
        L_0x0163:
            androidx.compose.runtime.ScopeUpdateScope r9 = r14.endRestartGroup()
            if (r9 == 0) goto L_0x0177
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$2 r0 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$2
            r6 = r27
            r8 = r30
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x0177:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(boolean, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AnimatedVisibility(androidx.compose.foundation.layout.RowScope r22, boolean r23, androidx.compose.ui.Modifier r24, androidx.compose.animation.EnterTransition r25, androidx.compose.animation.ExitTransition r26, java.lang.String r27, kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            r8 = r30
            r0 = -1741346906(0xffffffff983527a6, float:-2.341372E-24)
            r1 = r29
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AnimatedVisibility)P(5,4,1,2,3)207@11272L32,208@11309L84:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            r1 = r31 & 1
            if (r1 == 0) goto L_0x0019
            r1 = r8 | 48
            r2 = r23
            goto L_0x002d
        L_0x0019:
            r1 = r8 & 48
            r2 = r23
            if (r1 != 0) goto L_0x002c
            boolean r1 = r15.changed((boolean) r2)
            if (r1 == 0) goto L_0x0028
            r1 = 32
            goto L_0x002a
        L_0x0028:
            r1 = 16
        L_0x002a:
            r1 = r1 | r8
            goto L_0x002d
        L_0x002c:
            r1 = r8
        L_0x002d:
            r3 = r31 & 2
            if (r3 == 0) goto L_0x0034
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0047
        L_0x0034:
            r4 = r8 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x0047
            r4 = r24
            boolean r5 = r15.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0043
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0045
        L_0x0043:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0045:
            r1 = r1 | r5
            goto L_0x0049
        L_0x0047:
            r4 = r24
        L_0x0049:
            r5 = r31 & 4
            if (r5 == 0) goto L_0x0050
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0063
        L_0x0050:
            r6 = r8 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x0063
            r6 = r25
            boolean r7 = r15.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x005f
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0061
        L_0x005f:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0061:
            r1 = r1 | r7
            goto L_0x0065
        L_0x0063:
            r6 = r25
        L_0x0065:
            r7 = r31 & 8
            if (r7 == 0) goto L_0x006c
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x007f
        L_0x006c:
            r9 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x007f
            r9 = r26
            boolean r10 = r15.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x007b
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x007d
        L_0x007b:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x007d:
            r1 = r1 | r10
            goto L_0x0081
        L_0x007f:
            r9 = r26
        L_0x0081:
            r10 = r31 & 16
            r11 = 196608(0x30000, float:2.75506E-40)
            if (r10 == 0) goto L_0x0089
            r1 = r1 | r11
            goto L_0x009b
        L_0x0089:
            r11 = r11 & r8
            if (r11 != 0) goto L_0x009b
            r11 = r27
            boolean r12 = r15.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0097
            r12 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0099
        L_0x0097:
            r12 = 65536(0x10000, float:9.18355E-41)
        L_0x0099:
            r1 = r1 | r12
            goto L_0x009d
        L_0x009b:
            r11 = r27
        L_0x009d:
            r12 = r31 & 32
            r13 = 1572864(0x180000, float:2.204052E-39)
            if (r12 == 0) goto L_0x00a7
            r1 = r1 | r13
            r14 = r28
            goto L_0x00b9
        L_0x00a7:
            r12 = r8 & r13
            r14 = r28
            if (r12 != 0) goto L_0x00b9
            boolean r12 = r15.changedInstance(r14)
            if (r12 == 0) goto L_0x00b6
            r12 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00b8
        L_0x00b6:
            r12 = 524288(0x80000, float:7.34684E-40)
        L_0x00b8:
            r1 = r1 | r12
        L_0x00b9:
            r12 = 599185(0x92491, float:8.39637E-40)
            r12 = r12 & r1
            r13 = 599184(0x92490, float:8.39636E-40)
            if (r12 != r13) goto L_0x00d2
            boolean r12 = r15.getSkipping()
            if (r12 != 0) goto L_0x00c9
            goto L_0x00d2
        L_0x00c9:
            r15.skipToGroupEnd()
            r3 = r4
            r4 = r6
            r5 = r9
            r6 = r11
            goto L_0x0161
        L_0x00d2:
            if (r3 == 0) goto L_0x00d9
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x00da
        L_0x00d9:
            r3 = r4
        L_0x00da:
            r4 = 0
            r12 = 3
            r13 = 0
            if (r5 == 0) goto L_0x00f8
            androidx.compose.animation.EnterTransition r5 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r13, r4, r12, r13)
            r20 = 15
            r21 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            androidx.compose.animation.EnterTransition r6 = androidx.compose.animation.EnterExitTransitionKt.expandHorizontally$default(r16, r17, r18, r19, r20, r21)
            androidx.compose.animation.EnterTransition r5 = r5.plus(r6)
            r6 = r5
        L_0x00f8:
            if (r7 == 0) goto L_0x0114
            androidx.compose.animation.ExitTransition r4 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r13, r4, r12, r13)
            r20 = 15
            r21 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            androidx.compose.animation.ExitTransition r5 = androidx.compose.animation.EnterExitTransitionKt.shrinkHorizontally$default(r16, r17, r18, r19, r20, r21)
            androidx.compose.animation.ExitTransition r4 = r4.plus(r5)
            r13 = r4
            goto L_0x0115
        L_0x0114:
            r13 = r9
        L_0x0115:
            if (r10 == 0) goto L_0x011a
            java.lang.String r4 = "AnimatedVisibility"
            goto L_0x011b
        L_0x011a:
            r4 = r11
        L_0x011b:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0127
            r5 = -1
            java.lang.String r7 = "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:206)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r5, r7)
        L_0x0127:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
            int r5 = r1 >> 3
            r7 = r5 & 14
            int r9 = r1 >> 12
            r9 = r9 & 112(0x70, float:1.57E-43)
            r7 = r7 | r9
            r9 = 0
            androidx.compose.animation.core.Transition r9 = androidx.compose.animation.core.TransitionKt.updateTransition(r0, (java.lang.String) r4, (androidx.compose.runtime.Composer) r15, (int) r7, (int) r9)
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3 r0 = androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3.INSTANCE
            r10 = r0
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r0 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | 48
            r7 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r7
            r7 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r7
            r0 = r0 | r1
            r1 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r5
            r16 = r0 | r1
            r11 = r3
            r12 = r6
            AnimatedVisibilityImpl(r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x015d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x015d:
            r6 = r4
            r3 = r11
            r4 = r12
            r5 = r13
        L_0x0161:
            androidx.compose.runtime.ScopeUpdateScope r10 = r15.endRestartGroup()
            if (r10 == 0) goto L_0x0177
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$4 r0 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$4
            r1 = r22
            r7 = r28
            r9 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x0177:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(androidx.compose.foundation.layout.RowScope, boolean, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AnimatedVisibility(androidx.compose.foundation.layout.ColumnScope r22, boolean r23, androidx.compose.ui.Modifier r24, androidx.compose.animation.EnterTransition r25, androidx.compose.animation.ExitTransition r26, java.lang.String r27, kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            r8 = r30
            r0 = 1766503102(0x694ab2be, float:1.5315444E25)
            r1 = r29
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AnimatedVisibility)P(5,4,1,2,3)280@15555L32,281@15592L84:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            r1 = r31 & 1
            if (r1 == 0) goto L_0x0019
            r1 = r8 | 48
            r2 = r23
            goto L_0x002d
        L_0x0019:
            r1 = r8 & 48
            r2 = r23
            if (r1 != 0) goto L_0x002c
            boolean r1 = r15.changed((boolean) r2)
            if (r1 == 0) goto L_0x0028
            r1 = 32
            goto L_0x002a
        L_0x0028:
            r1 = 16
        L_0x002a:
            r1 = r1 | r8
            goto L_0x002d
        L_0x002c:
            r1 = r8
        L_0x002d:
            r3 = r31 & 2
            if (r3 == 0) goto L_0x0034
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0047
        L_0x0034:
            r4 = r8 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x0047
            r4 = r24
            boolean r5 = r15.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0043
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0045
        L_0x0043:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0045:
            r1 = r1 | r5
            goto L_0x0049
        L_0x0047:
            r4 = r24
        L_0x0049:
            r5 = r31 & 4
            if (r5 == 0) goto L_0x0050
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0063
        L_0x0050:
            r6 = r8 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x0063
            r6 = r25
            boolean r7 = r15.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x005f
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0061
        L_0x005f:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0061:
            r1 = r1 | r7
            goto L_0x0065
        L_0x0063:
            r6 = r25
        L_0x0065:
            r7 = r31 & 8
            if (r7 == 0) goto L_0x006c
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x007f
        L_0x006c:
            r9 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x007f
            r9 = r26
            boolean r10 = r15.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x007b
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x007d
        L_0x007b:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x007d:
            r1 = r1 | r10
            goto L_0x0081
        L_0x007f:
            r9 = r26
        L_0x0081:
            r10 = r31 & 16
            r11 = 196608(0x30000, float:2.75506E-40)
            if (r10 == 0) goto L_0x0089
            r1 = r1 | r11
            goto L_0x009b
        L_0x0089:
            r11 = r11 & r8
            if (r11 != 0) goto L_0x009b
            r11 = r27
            boolean r12 = r15.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0097
            r12 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0099
        L_0x0097:
            r12 = 65536(0x10000, float:9.18355E-41)
        L_0x0099:
            r1 = r1 | r12
            goto L_0x009d
        L_0x009b:
            r11 = r27
        L_0x009d:
            r12 = r31 & 32
            r13 = 1572864(0x180000, float:2.204052E-39)
            if (r12 == 0) goto L_0x00a7
            r1 = r1 | r13
            r14 = r28
            goto L_0x00b9
        L_0x00a7:
            r12 = r8 & r13
            r14 = r28
            if (r12 != 0) goto L_0x00b9
            boolean r12 = r15.changedInstance(r14)
            if (r12 == 0) goto L_0x00b6
            r12 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00b8
        L_0x00b6:
            r12 = 524288(0x80000, float:7.34684E-40)
        L_0x00b8:
            r1 = r1 | r12
        L_0x00b9:
            r12 = 599185(0x92491, float:8.39637E-40)
            r12 = r12 & r1
            r13 = 599184(0x92490, float:8.39636E-40)
            if (r12 != r13) goto L_0x00d2
            boolean r12 = r15.getSkipping()
            if (r12 != 0) goto L_0x00c9
            goto L_0x00d2
        L_0x00c9:
            r15.skipToGroupEnd()
            r3 = r4
            r4 = r6
            r5 = r9
            r6 = r11
            goto L_0x0161
        L_0x00d2:
            if (r3 == 0) goto L_0x00d9
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x00da
        L_0x00d9:
            r3 = r4
        L_0x00da:
            r4 = 0
            r12 = 3
            r13 = 0
            if (r5 == 0) goto L_0x00f8
            androidx.compose.animation.EnterTransition r5 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r13, r4, r12, r13)
            r20 = 15
            r21 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            androidx.compose.animation.EnterTransition r6 = androidx.compose.animation.EnterExitTransitionKt.expandVertically$default(r16, r17, r18, r19, r20, r21)
            androidx.compose.animation.EnterTransition r5 = r5.plus(r6)
            r6 = r5
        L_0x00f8:
            if (r7 == 0) goto L_0x0114
            androidx.compose.animation.ExitTransition r4 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r13, r4, r12, r13)
            r20 = 15
            r21 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            androidx.compose.animation.ExitTransition r5 = androidx.compose.animation.EnterExitTransitionKt.shrinkVertically$default(r16, r17, r18, r19, r20, r21)
            androidx.compose.animation.ExitTransition r4 = r4.plus(r5)
            r13 = r4
            goto L_0x0115
        L_0x0114:
            r13 = r9
        L_0x0115:
            if (r10 == 0) goto L_0x011a
            java.lang.String r4 = "AnimatedVisibility"
            goto L_0x011b
        L_0x011a:
            r4 = r11
        L_0x011b:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0127
            r5 = -1
            java.lang.String r7 = "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r5, r7)
        L_0x0127:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
            int r5 = r1 >> 3
            r7 = r5 & 14
            int r9 = r1 >> 12
            r9 = r9 & 112(0x70, float:1.57E-43)
            r7 = r7 | r9
            r9 = 0
            androidx.compose.animation.core.Transition r9 = androidx.compose.animation.core.TransitionKt.updateTransition(r0, (java.lang.String) r4, (androidx.compose.runtime.Composer) r15, (int) r7, (int) r9)
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5 r0 = androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5.INSTANCE
            r10 = r0
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r0 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | 48
            r7 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r7
            r7 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r7
            r0 = r0 | r1
            r1 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r5
            r16 = r0 | r1
            r11 = r3
            r12 = r6
            AnimatedVisibilityImpl(r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x015d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x015d:
            r6 = r4
            r3 = r11
            r4 = r12
            r5 = r13
        L_0x0161:
            androidx.compose.runtime.ScopeUpdateScope r10 = r15.endRestartGroup()
            if (r10 == 0) goto L_0x0177
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$6 r0 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$6
            r1 = r22
            r7 = r28
            r9 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x0177:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(androidx.compose.foundation.layout.ColumnScope, boolean, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AnimatedVisibility(androidx.compose.animation.core.MutableTransitionState<java.lang.Boolean> r22, androidx.compose.ui.Modifier r23, androidx.compose.animation.EnterTransition r24, androidx.compose.animation.ExitTransition r25, java.lang.String r26, kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, androidx.compose.runtime.Composer r28, int r29, int r30) {
        /*
            r1 = r22
            r7 = r29
            r0 = -222898426(0xfffffffff2b6d706, float:-7.243036E30)
            r2 = r28
            androidx.compose.runtime.Composer r14 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(AnimatedVisibility)P(5,4,1,2,3)385@20955L39,386@20999L84:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r2)
            r2 = r30 & 1
            if (r2 == 0) goto L_0x0019
            r2 = r7 | 6
            goto L_0x0032
        L_0x0019:
            r2 = r7 & 6
            if (r2 != 0) goto L_0x0031
            r2 = r7 & 8
            if (r2 != 0) goto L_0x0026
            boolean r2 = r14.changed((java.lang.Object) r1)
            goto L_0x002a
        L_0x0026:
            boolean r2 = r14.changedInstance(r1)
        L_0x002a:
            if (r2 == 0) goto L_0x002e
            r2 = 4
            goto L_0x002f
        L_0x002e:
            r2 = 2
        L_0x002f:
            r2 = r2 | r7
            goto L_0x0032
        L_0x0031:
            r2 = r7
        L_0x0032:
            r3 = r30 & 2
            if (r3 == 0) goto L_0x0039
            r2 = r2 | 48
            goto L_0x004c
        L_0x0039:
            r4 = r7 & 48
            if (r4 != 0) goto L_0x004c
            r4 = r23
            boolean r5 = r14.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0048
            r5 = 32
            goto L_0x004a
        L_0x0048:
            r5 = 16
        L_0x004a:
            r2 = r2 | r5
            goto L_0x004e
        L_0x004c:
            r4 = r23
        L_0x004e:
            r5 = r30 & 4
            if (r5 == 0) goto L_0x0055
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0055:
            r6 = r7 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0068
            r6 = r24
            boolean r8 = r14.changed((java.lang.Object) r6)
            if (r8 == 0) goto L_0x0064
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r2 = r2 | r8
            goto L_0x006a
        L_0x0068:
            r6 = r24
        L_0x006a:
            r8 = r30 & 8
            if (r8 == 0) goto L_0x0071
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0084
        L_0x0071:
            r9 = r7 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x0084
            r9 = r25
            boolean r10 = r14.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0080
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0082
        L_0x0080:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0082:
            r2 = r2 | r10
            goto L_0x0086
        L_0x0084:
            r9 = r25
        L_0x0086:
            r10 = r30 & 16
            if (r10 == 0) goto L_0x008d
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a0
        L_0x008d:
            r11 = r7 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x00a0
            r11 = r26
            boolean r12 = r14.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x009c
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009e
        L_0x009c:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x009e:
            r2 = r2 | r12
            goto L_0x00a2
        L_0x00a0:
            r11 = r26
        L_0x00a2:
            r12 = r30 & 32
            r13 = 196608(0x30000, float:2.75506E-40)
            if (r12 == 0) goto L_0x00ac
            r2 = r2 | r13
            r13 = r27
            goto L_0x00be
        L_0x00ac:
            r12 = r7 & r13
            r13 = r27
            if (r12 != 0) goto L_0x00be
            boolean r12 = r14.changedInstance(r13)
            if (r12 == 0) goto L_0x00bb
            r12 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bd
        L_0x00bb:
            r12 = 65536(0x10000, float:9.18355E-41)
        L_0x00bd:
            r2 = r2 | r12
        L_0x00be:
            r12 = 74899(0x12493, float:1.04956E-40)
            r12 = r12 & r2
            r15 = 74898(0x12492, float:1.04954E-40)
            if (r12 != r15) goto L_0x00d7
            boolean r12 = r14.getSkipping()
            if (r12 != 0) goto L_0x00ce
            goto L_0x00d7
        L_0x00ce:
            r14.skipToGroupEnd()
            r2 = r4
            r3 = r6
            r4 = r9
            r5 = r11
            goto L_0x0168
        L_0x00d7:
            if (r3 == 0) goto L_0x00de
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x00df
        L_0x00de:
            r3 = r4
        L_0x00df:
            r4 = 0
            r12 = 3
            r15 = 0
            if (r5 == 0) goto L_0x00fd
            androidx.compose.animation.EnterTransition r5 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r15, r4, r12, r15)
            r20 = 15
            r21 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            androidx.compose.animation.EnterTransition r6 = androidx.compose.animation.EnterExitTransitionKt.expandIn$default(r16, r17, r18, r19, r20, r21)
            androidx.compose.animation.EnterTransition r5 = r5.plus(r6)
            goto L_0x00fe
        L_0x00fd:
            r5 = r6
        L_0x00fe:
            if (r8 == 0) goto L_0x0119
            androidx.compose.animation.ExitTransition r4 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r15, r4, r12, r15)
            r19 = 15
            r20 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            androidx.compose.animation.ExitTransition r6 = androidx.compose.animation.EnterExitTransitionKt.shrinkOut$default(r15, r16, r17, r18, r19, r20)
            androidx.compose.animation.ExitTransition r4 = r4.plus(r6)
            r12 = r4
            goto L_0x011a
        L_0x0119:
            r12 = r9
        L_0x011a:
            if (r10 == 0) goto L_0x011f
            java.lang.String r4 = "AnimatedVisibility"
            goto L_0x0120
        L_0x011f:
            r4 = r11
        L_0x0120:
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x012c
            r6 = -1
            java.lang.String r8 = "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:384)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r6, r8)
        L_0x012c:
            r0 = r1
            androidx.compose.animation.core.TransitionState r0 = (androidx.compose.animation.core.TransitionState) r0
            int r6 = androidx.compose.animation.core.MutableTransitionState.$stable
            r8 = r2 & 14
            r6 = r6 | r8
            int r8 = r2 >> 9
            r8 = r8 & 112(0x70, float:1.57E-43)
            r6 = r6 | r8
            r8 = 0
            androidx.compose.animation.core.Transition r8 = androidx.compose.animation.core.TransitionKt.rememberTransition(r0, r4, r14, r6, r8)
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$7 r0 = androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$7.INSTANCE
            r9 = r0
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            int r0 = r2 << 3
            r6 = r0 & 896(0x380, float:1.256E-42)
            r6 = r6 | 48
            r10 = r0 & 7168(0x1c00, float:1.0045E-41)
            r6 = r6 | r10
            r10 = 57344(0xe000, float:8.0356E-41)
            r0 = r0 & r10
            r0 = r0 | r6
            r6 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r6
            r15 = r0 | r2
            r10 = r3
            r11 = r5
            AnimatedVisibilityImpl(r8, r9, r10, r11, r12, r13, r14, r15)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0164
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0164:
            r5 = r4
            r2 = r10
            r3 = r11
            r4 = r12
        L_0x0168:
            androidx.compose.runtime.ScopeUpdateScope r9 = r14.endRestartGroup()
            if (r9 == 0) goto L_0x017c
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$8 r0 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$8
            r6 = r27
            r8 = r30
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x017c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(androidx.compose.animation.core.MutableTransitionState, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AnimatedVisibility(androidx.compose.foundation.layout.RowScope r22, androidx.compose.animation.core.MutableTransitionState<java.lang.Boolean> r23, androidx.compose.ui.Modifier r24, androidx.compose.animation.EnterTransition r25, androidx.compose.animation.ExitTransition r26, java.lang.String r27, kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            r2 = r23
            r8 = r30
            r0 = 836509870(0x31dc20ae, float:6.406558E-9)
            r1 = r29
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AnimatedVisibility)P(5,4,1,2,3)460@25318L39,461@25362L84:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            r1 = r31 & 1
            if (r1 == 0) goto L_0x0019
            r1 = r8 | 48
            goto L_0x0034
        L_0x0019:
            r1 = r8 & 48
            if (r1 != 0) goto L_0x0033
            r1 = r8 & 64
            if (r1 != 0) goto L_0x0026
            boolean r1 = r15.changed((java.lang.Object) r2)
            goto L_0x002a
        L_0x0026:
            boolean r1 = r15.changedInstance(r2)
        L_0x002a:
            if (r1 == 0) goto L_0x002f
            r1 = 32
            goto L_0x0031
        L_0x002f:
            r1 = 16
        L_0x0031:
            r1 = r1 | r8
            goto L_0x0034
        L_0x0033:
            r1 = r8
        L_0x0034:
            r3 = r31 & 2
            if (r3 == 0) goto L_0x003b
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x004e
        L_0x003b:
            r4 = r8 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x004e
            r4 = r24
            boolean r5 = r15.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x004a
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x004c
        L_0x004a:
            r5 = 128(0x80, float:1.794E-43)
        L_0x004c:
            r1 = r1 | r5
            goto L_0x0050
        L_0x004e:
            r4 = r24
        L_0x0050:
            r5 = r31 & 4
            if (r5 == 0) goto L_0x0057
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x006a
        L_0x0057:
            r6 = r8 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x006a
            r6 = r25
            boolean r7 = r15.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0066
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0068
        L_0x0066:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0068:
            r1 = r1 | r7
            goto L_0x006c
        L_0x006a:
            r6 = r25
        L_0x006c:
            r7 = r31 & 8
            if (r7 == 0) goto L_0x0073
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0086
        L_0x0073:
            r9 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x0086
            r9 = r26
            boolean r10 = r15.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0082
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0084
        L_0x0082:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x0084:
            r1 = r1 | r10
            goto L_0x0088
        L_0x0086:
            r9 = r26
        L_0x0088:
            r10 = r31 & 16
            r11 = 196608(0x30000, float:2.75506E-40)
            if (r10 == 0) goto L_0x0090
            r1 = r1 | r11
            goto L_0x00a2
        L_0x0090:
            r11 = r11 & r8
            if (r11 != 0) goto L_0x00a2
            r11 = r27
            boolean r12 = r15.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x009e
            r12 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00a0
        L_0x009e:
            r12 = 65536(0x10000, float:9.18355E-41)
        L_0x00a0:
            r1 = r1 | r12
            goto L_0x00a4
        L_0x00a2:
            r11 = r27
        L_0x00a4:
            r12 = r31 & 32
            r13 = 1572864(0x180000, float:2.204052E-39)
            if (r12 == 0) goto L_0x00ae
            r1 = r1 | r13
            r14 = r28
            goto L_0x00c0
        L_0x00ae:
            r12 = r8 & r13
            r14 = r28
            if (r12 != 0) goto L_0x00c0
            boolean r12 = r15.changedInstance(r14)
            if (r12 == 0) goto L_0x00bd
            r12 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00bf
        L_0x00bd:
            r12 = 524288(0x80000, float:7.34684E-40)
        L_0x00bf:
            r1 = r1 | r12
        L_0x00c0:
            r12 = 599185(0x92491, float:8.39637E-40)
            r12 = r12 & r1
            r13 = 599184(0x92490, float:8.39636E-40)
            if (r12 != r13) goto L_0x00d9
            boolean r12 = r15.getSkipping()
            if (r12 != 0) goto L_0x00d0
            goto L_0x00d9
        L_0x00d0:
            r15.skipToGroupEnd()
            r3 = r4
            r4 = r6
            r5 = r9
            r6 = r11
            goto L_0x016a
        L_0x00d9:
            if (r3 == 0) goto L_0x00e0
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x00e1
        L_0x00e0:
            r3 = r4
        L_0x00e1:
            r4 = 0
            r12 = 3
            r13 = 0
            if (r5 == 0) goto L_0x00ff
            r20 = 15
            r21 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            androidx.compose.animation.EnterTransition r5 = androidx.compose.animation.EnterExitTransitionKt.expandHorizontally$default(r16, r17, r18, r19, r20, r21)
            androidx.compose.animation.EnterTransition r6 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r13, r4, r12, r13)
            androidx.compose.animation.EnterTransition r5 = r5.plus(r6)
            r6 = r5
        L_0x00ff:
            if (r7 == 0) goto L_0x011b
            r20 = 15
            r21 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            androidx.compose.animation.ExitTransition r5 = androidx.compose.animation.EnterExitTransitionKt.shrinkHorizontally$default(r16, r17, r18, r19, r20, r21)
            androidx.compose.animation.ExitTransition r4 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r13, r4, r12, r13)
            androidx.compose.animation.ExitTransition r4 = r5.plus(r4)
            r13 = r4
            goto L_0x011c
        L_0x011b:
            r13 = r9
        L_0x011c:
            if (r10 == 0) goto L_0x0121
            java.lang.String r4 = "AnimatedVisibility"
            goto L_0x0122
        L_0x0121:
            r4 = r11
        L_0x0122:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x012e
            r5 = -1
            java.lang.String r7 = "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:459)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r5, r7)
        L_0x012e:
            r0 = r2
            androidx.compose.animation.core.TransitionState r0 = (androidx.compose.animation.core.TransitionState) r0
            int r5 = androidx.compose.animation.core.MutableTransitionState.$stable
            int r7 = r1 >> 3
            r9 = r7 & 14
            r5 = r5 | r9
            int r9 = r1 >> 12
            r9 = r9 & 112(0x70, float:1.57E-43)
            r5 = r5 | r9
            r9 = 0
            androidx.compose.animation.core.Transition r9 = androidx.compose.animation.core.TransitionKt.rememberTransition(r0, r4, r15, r5, r9)
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$9 r0 = androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$9.INSTANCE
            r10 = r0
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r0 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | 48
            r5 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r5
            r5 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r5
            r0 = r0 | r1
            r1 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r7
            r16 = r0 | r1
            r11 = r3
            r12 = r6
            AnimatedVisibilityImpl(r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0166
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0166:
            r6 = r4
            r3 = r11
            r4 = r12
            r5 = r13
        L_0x016a:
            androidx.compose.runtime.ScopeUpdateScope r10 = r15.endRestartGroup()
            if (r10 == 0) goto L_0x0180
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$10 r0 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$10
            r1 = r22
            r7 = r28
            r9 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x0180:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(androidx.compose.foundation.layout.RowScope, androidx.compose.animation.core.MutableTransitionState, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AnimatedVisibility(androidx.compose.foundation.layout.ColumnScope r22, androidx.compose.animation.core.MutableTransitionState<java.lang.Boolean> r23, androidx.compose.ui.Modifier r24, androidx.compose.animation.EnterTransition r25, androidx.compose.animation.ExitTransition r26, java.lang.String r27, kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            r2 = r23
            r8 = r30
            r0 = -850656618(0xffffffffcd4c0296, float:-2.13920096E8)
            r1 = r29
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AnimatedVisibility)P(5,4,1,2,3)536@29773L39,537@29817L84:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            r1 = r31 & 1
            if (r1 == 0) goto L_0x0019
            r1 = r8 | 48
            goto L_0x0034
        L_0x0019:
            r1 = r8 & 48
            if (r1 != 0) goto L_0x0033
            r1 = r8 & 64
            if (r1 != 0) goto L_0x0026
            boolean r1 = r15.changed((java.lang.Object) r2)
            goto L_0x002a
        L_0x0026:
            boolean r1 = r15.changedInstance(r2)
        L_0x002a:
            if (r1 == 0) goto L_0x002f
            r1 = 32
            goto L_0x0031
        L_0x002f:
            r1 = 16
        L_0x0031:
            r1 = r1 | r8
            goto L_0x0034
        L_0x0033:
            r1 = r8
        L_0x0034:
            r3 = r31 & 2
            if (r3 == 0) goto L_0x003b
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x004e
        L_0x003b:
            r4 = r8 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x004e
            r4 = r24
            boolean r5 = r15.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x004a
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x004c
        L_0x004a:
            r5 = 128(0x80, float:1.794E-43)
        L_0x004c:
            r1 = r1 | r5
            goto L_0x0050
        L_0x004e:
            r4 = r24
        L_0x0050:
            r5 = r31 & 4
            if (r5 == 0) goto L_0x0057
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x006a
        L_0x0057:
            r6 = r8 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x006a
            r6 = r25
            boolean r7 = r15.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0066
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0068
        L_0x0066:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0068:
            r1 = r1 | r7
            goto L_0x006c
        L_0x006a:
            r6 = r25
        L_0x006c:
            r7 = r31 & 8
            if (r7 == 0) goto L_0x0073
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0086
        L_0x0073:
            r9 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x0086
            r9 = r26
            boolean r10 = r15.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0082
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0084
        L_0x0082:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x0084:
            r1 = r1 | r10
            goto L_0x0088
        L_0x0086:
            r9 = r26
        L_0x0088:
            r10 = r31 & 16
            r11 = 196608(0x30000, float:2.75506E-40)
            if (r10 == 0) goto L_0x0090
            r1 = r1 | r11
            goto L_0x00a2
        L_0x0090:
            r11 = r11 & r8
            if (r11 != 0) goto L_0x00a2
            r11 = r27
            boolean r12 = r15.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x009e
            r12 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00a0
        L_0x009e:
            r12 = 65536(0x10000, float:9.18355E-41)
        L_0x00a0:
            r1 = r1 | r12
            goto L_0x00a4
        L_0x00a2:
            r11 = r27
        L_0x00a4:
            r12 = r31 & 32
            r13 = 1572864(0x180000, float:2.204052E-39)
            if (r12 == 0) goto L_0x00ae
            r1 = r1 | r13
            r14 = r28
            goto L_0x00c0
        L_0x00ae:
            r12 = r8 & r13
            r14 = r28
            if (r12 != 0) goto L_0x00c0
            boolean r12 = r15.changedInstance(r14)
            if (r12 == 0) goto L_0x00bd
            r12 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00bf
        L_0x00bd:
            r12 = 524288(0x80000, float:7.34684E-40)
        L_0x00bf:
            r1 = r1 | r12
        L_0x00c0:
            r12 = 599185(0x92491, float:8.39637E-40)
            r12 = r12 & r1
            r13 = 599184(0x92490, float:8.39636E-40)
            if (r12 != r13) goto L_0x00d9
            boolean r12 = r15.getSkipping()
            if (r12 != 0) goto L_0x00d0
            goto L_0x00d9
        L_0x00d0:
            r15.skipToGroupEnd()
            r3 = r4
            r4 = r6
            r5 = r9
            r6 = r11
            goto L_0x016a
        L_0x00d9:
            if (r3 == 0) goto L_0x00e0
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x00e1
        L_0x00e0:
            r3 = r4
        L_0x00e1:
            r4 = 0
            r12 = 3
            r13 = 0
            if (r5 == 0) goto L_0x00ff
            r20 = 15
            r21 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            androidx.compose.animation.EnterTransition r5 = androidx.compose.animation.EnterExitTransitionKt.expandVertically$default(r16, r17, r18, r19, r20, r21)
            androidx.compose.animation.EnterTransition r6 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r13, r4, r12, r13)
            androidx.compose.animation.EnterTransition r5 = r5.plus(r6)
            r6 = r5
        L_0x00ff:
            if (r7 == 0) goto L_0x011b
            r20 = 15
            r21 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            androidx.compose.animation.ExitTransition r5 = androidx.compose.animation.EnterExitTransitionKt.shrinkVertically$default(r16, r17, r18, r19, r20, r21)
            androidx.compose.animation.ExitTransition r4 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r13, r4, r12, r13)
            androidx.compose.animation.ExitTransition r4 = r5.plus(r4)
            r13 = r4
            goto L_0x011c
        L_0x011b:
            r13 = r9
        L_0x011c:
            if (r10 == 0) goto L_0x0121
            java.lang.String r4 = "AnimatedVisibility"
            goto L_0x0122
        L_0x0121:
            r4 = r11
        L_0x0122:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x012e
            r5 = -1
            java.lang.String r7 = "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:535)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r5, r7)
        L_0x012e:
            r0 = r2
            androidx.compose.animation.core.TransitionState r0 = (androidx.compose.animation.core.TransitionState) r0
            int r5 = androidx.compose.animation.core.MutableTransitionState.$stable
            int r7 = r1 >> 3
            r9 = r7 & 14
            r5 = r5 | r9
            int r9 = r1 >> 12
            r9 = r9 & 112(0x70, float:1.57E-43)
            r5 = r5 | r9
            r9 = 0
            androidx.compose.animation.core.Transition r9 = androidx.compose.animation.core.TransitionKt.rememberTransition(r0, r4, r15, r5, r9)
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$11 r0 = androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$11.INSTANCE
            r10 = r0
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r0 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | 48
            r5 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r5
            r5 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r5
            r0 = r0 | r1
            r1 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r7
            r16 = r0 | r1
            r11 = r3
            r12 = r6
            AnimatedVisibilityImpl(r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0166
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0166:
            r6 = r4
            r3 = r11
            r4 = r12
            r5 = r13
        L_0x016a:
            androidx.compose.runtime.ScopeUpdateScope r10 = r15.endRestartGroup()
            if (r10 == 0) goto L_0x0180
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$12 r0 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$12
            r1 = r22
            r7 = r28
            r9 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x0180:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(androidx.compose.foundation.layout.ColumnScope, androidx.compose.animation.core.MutableTransitionState, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> void AnimatedVisibility(androidx.compose.animation.core.Transition<T> r21, kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r22, androidx.compose.ui.Modifier r23, androidx.compose.animation.EnterTransition r24, androidx.compose.animation.ExitTransition r25, kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, androidx.compose.runtime.Composer r27, int r28, int r29) {
        /*
            r7 = r28
            r0 = 1031950689(0x3d825161, float:0.06363178)
            r1 = r27
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AnimatedVisibility)P(4,3,1,2)609@34120L79:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r29 & r1
            if (r1 == 0) goto L_0x001b
            r1 = r7 | 6
            r8 = r21
            goto L_0x002d
        L_0x001b:
            r1 = r7 & 6
            r8 = r21
            if (r1 != 0) goto L_0x002c
            boolean r1 = r14.changed((java.lang.Object) r8)
            if (r1 == 0) goto L_0x0029
            r1 = 4
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r7
            goto L_0x002d
        L_0x002c:
            r1 = r7
        L_0x002d:
            r2 = r29 & 1
            if (r2 == 0) goto L_0x0036
            r1 = r1 | 48
            r9 = r22
            goto L_0x0048
        L_0x0036:
            r2 = r7 & 48
            r9 = r22
            if (r2 != 0) goto L_0x0048
            boolean r2 = r14.changedInstance(r9)
            if (r2 == 0) goto L_0x0045
            r2 = 32
            goto L_0x0047
        L_0x0045:
            r2 = 16
        L_0x0047:
            r1 = r1 | r2
        L_0x0048:
            r2 = r29 & 2
            if (r2 == 0) goto L_0x004f
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r3 = r7 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x0062
            r3 = r23
            boolean r4 = r14.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x005e
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r1 = r1 | r4
            goto L_0x0064
        L_0x0062:
            r3 = r23
        L_0x0064:
            r4 = r29 & 4
            if (r4 == 0) goto L_0x006b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r5 = r7 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x007e
            r5 = r24
            boolean r6 = r14.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x007a
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r1 = r1 | r6
            goto L_0x0080
        L_0x007e:
            r5 = r24
        L_0x0080:
            r6 = r29 & 8
            if (r6 == 0) goto L_0x0087
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0087:
            r10 = r7 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x009a
            r10 = r25
            boolean r11 = r14.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x0096
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r1 = r1 | r11
            goto L_0x009c
        L_0x009a:
            r10 = r25
        L_0x009c:
            r11 = r29 & 16
            r12 = 196608(0x30000, float:2.75506E-40)
            if (r11 == 0) goto L_0x00a6
            r1 = r1 | r12
            r13 = r26
            goto L_0x00b8
        L_0x00a6:
            r11 = r7 & r12
            r13 = r26
            if (r11 != 0) goto L_0x00b8
            boolean r11 = r14.changedInstance(r13)
            if (r11 == 0) goto L_0x00b5
            r11 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b7
        L_0x00b5:
            r11 = 65536(0x10000, float:9.18355E-41)
        L_0x00b7:
            r1 = r1 | r11
        L_0x00b8:
            r11 = 74899(0x12493, float:1.04956E-40)
            r11 = r11 & r1
            r12 = 74898(0x12492, float:1.04954E-40)
            if (r11 != r12) goto L_0x00cf
            boolean r11 = r14.getSkipping()
            if (r11 != 0) goto L_0x00c8
            goto L_0x00cf
        L_0x00c8:
            r14.skipToGroupEnd()
            r4 = r5
            r5 = r10
            goto L_0x0133
        L_0x00cf:
            if (r2 == 0) goto L_0x00d6
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x00d7
        L_0x00d6:
            r2 = r3
        L_0x00d7:
            r3 = 3
            r11 = 0
            r12 = 0
            if (r4 == 0) goto L_0x00f4
            androidx.compose.animation.EnterTransition r4 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r12, r11, r3, r12)
            r19 = 15
            r20 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            androidx.compose.animation.EnterTransition r5 = androidx.compose.animation.EnterExitTransitionKt.expandIn$default(r15, r16, r17, r18, r19, r20)
            androidx.compose.animation.EnterTransition r4 = r4.plus(r5)
            goto L_0x00f5
        L_0x00f4:
            r4 = r5
        L_0x00f5:
            if (r6 == 0) goto L_0x0110
            r19 = 15
            r20 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            androidx.compose.animation.ExitTransition r5 = androidx.compose.animation.EnterExitTransitionKt.shrinkOut$default(r15, r16, r17, r18, r19, r20)
            androidx.compose.animation.ExitTransition r3 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r12, r11, r3, r12)
            androidx.compose.animation.ExitTransition r3 = r5.plus(r3)
            r12 = r3
            goto L_0x0111
        L_0x0110:
            r12 = r10
        L_0x0111:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x011d
            r3 = -1
            java.lang.String r5 = "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:609)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r3, r5)
        L_0x011d:
            r0 = 524286(0x7fffe, float:7.34681E-40)
            r15 = r1 & r0
            r10 = r2
            r11 = r4
            AnimatedVisibilityImpl(r8, r9, r10, r11, r12, r13, r14, r15)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0130
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0130:
            r3 = r10
            r4 = r11
            r5 = r12
        L_0x0133:
            androidx.compose.runtime.ScopeUpdateScope r9 = r14.endRestartGroup()
            if (r9 == 0) goto L_0x014b
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$13 r0 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$13
            r1 = r21
            r2 = r22
            r6 = r26
            r8 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x014b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(androidx.compose.animation.core.Transition, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final <T> void AnimatedVisibilityImpl(Transition<T> transition, Function1<? super T, Boolean> function1, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i) {
        int i2;
        ExitTransition exitTransition2;
        Transition<T> transition2 = transition;
        Function1<? super T, Boolean> function12 = function1;
        Modifier modifier2 = modifier;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(429978603);
        ComposerKt.sourceInformation(startRestartGroup, "C(AnimatedVisibilityImpl)P(4,5,3,1,2)697@38299L415,694@38181L703:AnimatedVisibility.kt#xbi5r1");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) transition2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function12) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changed((Object) modifier2) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changed((Object) enterTransition) ? 2048 : 1024;
        } else {
            EnterTransition enterTransition2 = enterTransition;
        }
        if ((i3 & 24576) == 0) {
            exitTransition2 = exitTransition;
            i2 |= startRestartGroup.changed((Object) exitTransition2) ? 16384 : 8192;
        } else {
            exitTransition2 = exitTransition;
        }
        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i2 |= startRestartGroup.changedInstance(function3) ? 131072 : 65536;
        } else {
            Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function32 = function3;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(429978603, i2, -1, "androidx.compose.animation.AnimatedVisibilityImpl (AnimatedVisibility.kt:693)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 689212639, "CC(remember):AnimatedVisibility.kt#9igjgp");
            int i4 = i2 & 112;
            boolean z = true;
            boolean z2 = i4 == 32;
            int i5 = i2 & 14;
            if (i5 != 4) {
                z = false;
            }
            boolean z3 = z2 | z;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new AnimatedVisibilityKt$AnimatedVisibilityImpl$1$1(function12, transition2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            AnimatedEnterExitImpl(transition2, function12, LayoutModifierKt.layout(modifier2, (Function3) rememberedValue), enterTransition, exitTransition2, AnimatedVisibilityKt$AnimatedVisibilityImpl$2.INSTANCE, (OnLookaheadMeasured) null, function3, startRestartGroup, i4 | 196608 | i5 | (i2 & 7168) | (57344 & i2) | ((i2 << 6) & 29360128), 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AnimatedVisibilityKt$AnimatedVisibilityImpl$3(transition, function1, modifier2, enterTransition, exitTransition, function3, i3));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:190:0x0408  */
    /* JADX WARNING: Removed duplicated region for block: B:192:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0105  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> void AnimatedEnterExitImpl(androidx.compose.animation.core.Transition<T> r23, kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r24, androidx.compose.ui.Modifier r25, androidx.compose.animation.EnterTransition r26, androidx.compose.animation.ExitTransition r27, kotlin.jvm.functions.Function2<? super androidx.compose.animation.EnterExitState, ? super androidx.compose.animation.EnterExitState, java.lang.Boolean> r28, androidx.compose.animation.OnLookaheadMeasured r29, kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r0 = r23
            r6 = r24
            r7 = r25
            r8 = r28
            r1 = r29
            r9 = r30
            r10 = r32
            r11 = r33
            r2 = -891967166(0xffffffffcad5a942, float:-7001249.0)
            r3 = r31
            androidx.compose.runtime.Composer r4 = r3.startRestartGroup(r2)
            java.lang.String r3 = "C(AnimatedEnterExitImpl)P(6,7,3,1,2,5,4):AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r3)
            r3 = r11 & 1
            if (r3 == 0) goto L_0x0025
            r3 = r10 | 6
            goto L_0x0035
        L_0x0025:
            r3 = r10 & 6
            if (r3 != 0) goto L_0x0034
            boolean r3 = r4.changed((java.lang.Object) r0)
            if (r3 == 0) goto L_0x0031
            r3 = 4
            goto L_0x0032
        L_0x0031:
            r3 = 2
        L_0x0032:
            r3 = r3 | r10
            goto L_0x0035
        L_0x0034:
            r3 = r10
        L_0x0035:
            r5 = r11 & 2
            if (r5 == 0) goto L_0x003c
            r3 = r3 | 48
            goto L_0x004c
        L_0x003c:
            r5 = r10 & 48
            if (r5 != 0) goto L_0x004c
            boolean r5 = r4.changedInstance(r6)
            if (r5 == 0) goto L_0x0049
            r5 = 32
            goto L_0x004b
        L_0x0049:
            r5 = 16
        L_0x004b:
            r3 = r3 | r5
        L_0x004c:
            r5 = r11 & 4
            if (r5 == 0) goto L_0x0053
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0053:
            r5 = r10 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x0063
            boolean r5 = r4.changed((java.lang.Object) r7)
            if (r5 == 0) goto L_0x0060
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r3 = r3 | r5
        L_0x0063:
            r5 = r11 & 8
            if (r5 == 0) goto L_0x006c
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            r13 = r26
            goto L_0x007e
        L_0x006c:
            r5 = r10 & 3072(0xc00, float:4.305E-42)
            r13 = r26
            if (r5 != 0) goto L_0x007e
            boolean r5 = r4.changed((java.lang.Object) r13)
            if (r5 == 0) goto L_0x007b
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r3 = r3 | r5
        L_0x007e:
            r5 = r11 & 16
            if (r5 == 0) goto L_0x0087
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            r14 = r27
            goto L_0x0099
        L_0x0087:
            r5 = r10 & 24576(0x6000, float:3.4438E-41)
            r14 = r27
            if (r5 != 0) goto L_0x0099
            boolean r5 = r4.changed((java.lang.Object) r14)
            if (r5 == 0) goto L_0x0096
            r5 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r5 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r3 = r3 | r5
        L_0x0099:
            r5 = r11 & 32
            r15 = 196608(0x30000, float:2.75506E-40)
            if (r5 == 0) goto L_0x00a1
            r3 = r3 | r15
            goto L_0x00b1
        L_0x00a1:
            r5 = r10 & r15
            if (r5 != 0) goto L_0x00b1
            boolean r5 = r4.changedInstance(r8)
            if (r5 == 0) goto L_0x00ae
            r5 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b0
        L_0x00ae:
            r5 = 65536(0x10000, float:9.18355E-41)
        L_0x00b0:
            r3 = r3 | r5
        L_0x00b1:
            r5 = r11 & 64
            r20 = 2097152(0x200000, float:2.938736E-39)
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r5 == 0) goto L_0x00bc
        L_0x00b9:
            r3 = r3 | r16
            goto L_0x00d5
        L_0x00bc:
            r16 = r10 & r16
            if (r16 != 0) goto L_0x00d5
            r16 = r10 & r20
            if (r16 != 0) goto L_0x00c9
            boolean r16 = r4.changed((java.lang.Object) r1)
            goto L_0x00cd
        L_0x00c9:
            boolean r16 = r4.changedInstance(r1)
        L_0x00cd:
            if (r16 == 0) goto L_0x00d2
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00b9
        L_0x00d2:
            r16 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00b9
        L_0x00d5:
            r15 = r11 & 128(0x80, float:1.794E-43)
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            if (r15 == 0) goto L_0x00de
            r3 = r3 | r16
            goto L_0x00ee
        L_0x00de:
            r15 = r10 & r16
            if (r15 != 0) goto L_0x00ee
            boolean r15 = r4.changedInstance(r9)
            if (r15 == 0) goto L_0x00eb
            r15 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ed
        L_0x00eb:
            r15 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ed:
            r3 = r3 | r15
        L_0x00ee:
            r15 = r3
            r3 = 4793491(0x492493, float:6.717112E-39)
            r3 = r3 & r15
            r12 = 4793490(0x492492, float:6.71711E-39)
            if (r3 != r12) goto L_0x0105
            boolean r3 = r4.getSkipping()
            if (r3 != 0) goto L_0x00ff
            goto L_0x0105
        L_0x00ff:
            r4.skipToGroupEnd()
            r11 = r4
            goto L_0x0402
        L_0x0105:
            if (r5 == 0) goto L_0x0108
            r1 = 0
        L_0x0108:
            r12 = r1
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r3 = -1
            if (r1 == 0) goto L_0x0115
            java.lang.String r1 = "androidx.compose.animation.AnimatedEnterExitImpl (AnimatedVisibility.kt:737)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r15, r3, r1)
        L_0x0115:
            java.lang.Object r1 = r0.getTargetState()
            java.lang.Object r1 = r6.invoke(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x014f
            java.lang.Object r1 = r0.getCurrentState()
            java.lang.Object r1 = r6.invoke(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x014f
            boolean r1 = r0.isSeeking()
            if (r1 != 0) goto L_0x014f
            boolean r1 = r0.getHasInitialValueAnimations()
            if (r1 == 0) goto L_0x0142
            goto L_0x014f
        L_0x0142:
            r1 = 1790262234(0x6ab53bda, float:1.0954911E26)
            r4.startReplaceGroup(r1)
            r4.endReplaceGroup()
            r11 = r4
            r1 = r12
            goto L_0x03f9
        L_0x014f:
            r1 = 1787977937(0x6a9260d1, float:8.848019E25)
            r4.startReplaceGroup(r1)
            java.lang.String r1 = "741@39659L116,745@39818L40,752@40073L399,747@39898L574"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r1)
            r1 = r15 & 14
            r2 = r1 | 48
            r5 = 1215497572(0x48730564, float:248853.56)
            java.lang.String r3 = "CC(createChildTransition)1813@74138L36,1814@74198L74,1815@74295L39,1816@74346L63:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r5, r3)
            r3 = 272027253(0x1036ce75, float:3.605222E-29)
            java.lang.String r5 = "CC(remember):Transition.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r3, r5)
            r3 = r2 & 14
            r5 = r3 ^ 6
            r17 = r15
            r21 = 1
            r15 = 4
            if (r5 <= r15) goto L_0x017f
            boolean r5 = r4.changed((java.lang.Object) r0)
            if (r5 != 0) goto L_0x0183
        L_0x017f:
            r2 = r2 & 6
            if (r2 != r15) goto L_0x0186
        L_0x0183:
            r2 = r21
            goto L_0x0187
        L_0x0186:
            r2 = 0
        L_0x0187:
            java.lang.Object r5 = r4.rememberedValue()
            if (r2 != 0) goto L_0x0195
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r5 != r2) goto L_0x019c
        L_0x0195:
            java.lang.Object r5 = r0.getCurrentState()
            r4.updateRememberedValue(r5)
        L_0x019c:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            boolean r2 = r0.isSeeking()
            if (r2 == 0) goto L_0x01a9
            java.lang.Object r5 = r0.getCurrentState()
        L_0x01a9:
            r2 = -466616829(0xffffffffe42ffe03, float:-1.2985935E22)
            r4.startReplaceGroup(r2)
            java.lang.String r15 = "C742@39737L28:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r15)
            boolean r15 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r15 == 0) goto L_0x01c4
            java.lang.String r15 = "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:742)"
            r19 = r1
            r1 = -1
            r10 = 0
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r10, r1, r15)
            goto L_0x01c6
        L_0x01c4:
            r19 = r1
        L_0x01c6:
            r1 = r17 & 126(0x7e, float:1.77E-43)
            androidx.compose.animation.EnterExitState r5 = targetEnterExit(r0, r6, r5, r4, r1)
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x01d5
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01d5:
            r4.endReplaceGroup()
            java.lang.Object r10 = r0.getTargetState()
            r4.startReplaceGroup(r2)
            java.lang.String r15 = "C742@39737L28:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r15)
            boolean r15 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r15 == 0) goto L_0x01f4
            java.lang.String r15 = "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:742)"
            r22 = r5
            r5 = -1
            r11 = 0
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r11, r5, r15)
            goto L_0x01f6
        L_0x01f4:
            r22 = r5
        L_0x01f6:
            androidx.compose.animation.EnterExitState r2 = targetEnterExit(r0, r6, r10, r4, r1)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0203
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0203:
            r4.endReplaceGroup()
            r5 = r3 | 3072(0xc00, float:4.305E-42)
            java.lang.String r3 = "EnterExitTransition"
            r10 = r19
            r1 = r22
            androidx.compose.animation.core.Transition r1 = androidx.compose.animation.core.TransitionKt.createChildTransitionInternal(r0, r1, r2, r3, r4, r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            int r0 = r17 >> 15
            r0 = r0 & 14
            androidx.compose.runtime.State r0 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r8, r4, r0)
            java.lang.Object r2 = r1.getCurrentState()
            java.lang.Object r3 = r1.getTargetState()
            java.lang.Object r2 = r8.invoke(r2, r3)
            r3 = 1581710007(0x5e46fab7, float:3.58449339E18)
            java.lang.String r5 = "CC(remember):AnimatedVisibility.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r3, r5)
            boolean r3 = r4.changed((java.lang.Object) r1)
            boolean r11 = r4.changed((java.lang.Object) r0)
            r3 = r3 | r11
            java.lang.Object r11 = r4.rememberedValue()
            if (r3 != 0) goto L_0x0248
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r11 != r3) goto L_0x0254
        L_0x0248:
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1 r3 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1
            r11 = 0
            r3.<init>(r1, r0, r11)
            r11 = r3
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r4.updateRememberedValue(r11)
        L_0x0254:
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r0 = 0
            androidx.compose.runtime.State r2 = androidx.compose.runtime.SnapshotStateKt.produceState(r2, r11, r4, r0)
            boolean r3 = getExitFinished(r1)
            if (r3 == 0) goto L_0x0278
            boolean r2 = AnimatedEnterExitImpl$lambda$4(r2)
            if (r2 != 0) goto L_0x026b
            goto L_0x0278
        L_0x026b:
            r0 = 1790256282(0x6ab5249a, float:1.0949421E26)
            r4.startReplaceGroup(r0)
            r4.endReplaceGroup()
            r11 = r4
            r1 = r12
            goto L_0x03f6
        L_0x0278:
            r2 = 1788869559(0x6a9ffbb7, float:9.670395E25)
            r4.startReplaceGroup(r2)
            java.lang.String r2 = "768@40570L69,773@40810L47,794@41913L50,769@40652L1325"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r2)
            r2 = 1581725581(0x5e47378d, float:3.58877434E18)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r2, r5)
            r15 = 4
            if (r10 != r15) goto L_0x028f
            r10 = r21
            goto L_0x0290
        L_0x028f:
            r10 = r0
        L_0x0290:
            java.lang.Object r2 = r4.rememberedValue()
            if (r10 != 0) goto L_0x029e
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r2 != r3) goto L_0x02a6
        L_0x029e:
            androidx.compose.animation.AnimatedVisibilityScopeImpl r2 = new androidx.compose.animation.AnimatedVisibilityScopeImpl
            r2.<init>(r1)
            r4.updateRememberedValue(r2)
        L_0x02a6:
            androidx.compose.animation.AnimatedVisibilityScopeImpl r2 = (androidx.compose.animation.AnimatedVisibilityScopeImpl) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            int r3 = r17 >> 6
            r10 = r3 & 112(0x70, float:1.57E-43)
            r10 = r10 | 24576(0x6000, float:3.4438E-41)
            r3 = r3 & 896(0x380, float:1.256E-42)
            r18 = r10 | r3
            r19 = 4
            r15 = 0
            java.lang.String r16 = "Built-in"
            r3 = r12
            r12 = r1
            r1 = r3
            r10 = r0
            r3 = r17
            r0 = 1048576(0x100000, float:1.469368E-39)
            r17 = r4
            androidx.compose.ui.Modifier r4 = androidx.compose.animation.EnterExitTransitionKt.createModifier(r12, r13, r14, r15, r16, r17, r18, r19)
            r11 = r17
            if (r1 == 0) goto L_0x031a
            r12 = 1789227361(0x6aa57161, float:1.0000409E26)
            r11.startReplaceGroup(r12)
            java.lang.String r12 = "775@40967L849"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r12)
            androidx.compose.ui.Modifier$Companion r12 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r12 = (androidx.compose.ui.Modifier) r12
            r13 = 1581739065(0x5e476c39, float:3.5924808E18)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r13, r5)
            r13 = 3670016(0x380000, float:5.142788E-39)
            r13 = r13 & r3
            if (r13 == r0) goto L_0x02f3
            r0 = r3 & r20
            if (r0 == 0) goto L_0x02f1
            boolean r0 = r11.changedInstance(r1)
            if (r0 == 0) goto L_0x02f1
            goto L_0x02f3
        L_0x02f1:
            r15 = r10
            goto L_0x02f5
        L_0x02f3:
            r15 = r21
        L_0x02f5:
            java.lang.Object r0 = r11.rememberedValue()
            if (r15 != 0) goto L_0x0303
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r0 != r13) goto L_0x030d
        L_0x0303:
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1 r0 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1
            r0.<init>(r1)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r11.updateRememberedValue(r0)
        L_0x030d:
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.layout.LayoutModifierKt.layout(r12, r0)
            r11.endReplaceGroup()
            goto L_0x0327
        L_0x031a:
            r0 = 1581766416(0x5e47d710, float:3.59999898E18)
            r11.startReplaceGroup(r0)
            r11.endReplaceGroup()
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
        L_0x0327:
            androidx.compose.ui.Modifier r0 = r4.then(r0)
            androidx.compose.ui.Modifier r0 = r7.then(r0)
            r4 = 1581768538(0x5e47df5a, float:3.60058227E18)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r4, r5)
            java.lang.Object r4 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r4 != r5) goto L_0x0349
            androidx.compose.animation.AnimatedEnterExitMeasurePolicy r4 = new androidx.compose.animation.AnimatedEnterExitMeasurePolicy
            r4.<init>(r2)
            r11.updateRememberedValue(r4)
        L_0x0349:
            androidx.compose.animation.AnimatedEnterExitMeasurePolicy r4 = (androidx.compose.animation.AnimatedEnterExitMeasurePolicy) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.layout.MeasurePolicy r4 = (androidx.compose.ui.layout.MeasurePolicy) r4
            r5 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r12 = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r5, r12)
            int r5 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r11, r10)
            androidx.compose.runtime.CompositionLocalMap r10 = r11.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r11, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r12 = r12.getConstructor()
            r13 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            java.lang.String r14 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r13, r14)
            androidx.compose.runtime.Applier r13 = r11.getApplier()
            boolean r13 = r13 instanceof androidx.compose.runtime.Applier
            if (r13 != 0) goto L_0x037d
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x037d:
            r11.startReusableNode()
            boolean r13 = r11.getInserting()
            if (r13 == 0) goto L_0x038a
            r11.createNode(r12)
            goto L_0x038d
        L_0x038a:
            r11.useNode()
        L_0x038d:
            androidx.compose.runtime.Composer r12 = androidx.compose.runtime.Updater.m3675constructorimpl(r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r12, r4, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r12, r10, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetCompositeKeyHash()
            boolean r10 = r12.getInserting()
            if (r10 != 0) goto L_0x03bd
            java.lang.Object r10 = r12.rememberedValue()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r5)
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r13)
            if (r10 != 0) goto L_0x03cb
        L_0x03bd:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r5)
            r12.updateRememberedValue(r10)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r12.apply(r5, r4)
        L_0x03cb:
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r12, r0, r4)
            r0 = 254461613(0xf2ac6ad, float:8.419911E-30)
            java.lang.String r4 = "C770@40694L9:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r0, r4)
            int r0 = r3 >> 18
            r0 = r0 & 112(0x70, float:1.57E-43)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r9.invoke(r2, r11, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r11.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r11.endReplaceGroup()
        L_0x03f6:
            r11.endReplaceGroup()
        L_0x03f9:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0402
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0402:
            androidx.compose.runtime.ScopeUpdateScope r11 = r11.endRestartGroup()
            if (r11 == 0) goto L_0x0421
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$4 r0 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$4
            r4 = r26
            r5 = r27
            r10 = r33
            r2 = r6
            r3 = r7
            r6 = r8
            r8 = r9
            r9 = r32
            r7 = r1
            r1 = r23
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r11.updateScope(r0)
        L_0x0421:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedEnterExitImpl(androidx.compose.animation.core.Transition, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, kotlin.jvm.functions.Function2, androidx.compose.animation.OnLookaheadMeasured, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final boolean getExitFinished(Transition<EnterExitState> transition) {
        return transition.getCurrentState() == EnterExitState.PostExit && transition.getTargetState() == EnterExitState.PostExit;
    }

    private static final <T> EnterExitState targetEnterExit(Transition<T> transition, Function1<? super T, Boolean> function1, T t, Composer composer, int i) {
        EnterExitState enterExitState;
        ComposerKt.sourceInformationMarkerStart(composer, 361571134, "C(targetEnterExit)P(1):AnimatedVisibility.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(361571134, i, -1, "androidx.compose.animation.targetEnterExit (AnimatedVisibility.kt:855)");
        }
        composer.startMovableGroup(-902048200, transition);
        ComposerKt.sourceInformation(composer, "");
        if (transition.isSeeking()) {
            composer.startReplaceGroup(2101296683);
            composer.endReplaceGroup();
            if (function1.invoke(t).booleanValue()) {
                enterExitState = EnterExitState.Visible;
            } else if (function1.invoke(transition.getCurrentState()).booleanValue()) {
                enterExitState = EnterExitState.PostExit;
            } else {
                enterExitState = EnterExitState.PreEnter;
            }
        } else {
            composer.startReplaceGroup(2101530516);
            ComposerKt.sourceInformation(composer, "868@44365L34");
            ComposerKt.sourceInformationMarkerStart(composer, -902039492, "CC(remember):AnimatedVisibility.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                composer.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (function1.invoke(transition.getCurrentState()).booleanValue()) {
                mutableState.setValue(true);
            }
            if (function1.invoke(t).booleanValue()) {
                enterExitState = EnterExitState.Visible;
            } else if (((Boolean) mutableState.getValue()).booleanValue()) {
                enterExitState = EnterExitState.PostExit;
            } else {
                enterExitState = EnterExitState.PreEnter;
            }
            composer.endReplaceGroup();
        }
        composer.endMovableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return enterExitState;
    }

    /* access modifiers changed from: private */
    public static final Function2<EnterExitState, EnterExitState, Boolean> AnimatedEnterExitImpl$lambda$2(State<? extends Function2<? super EnterExitState, ? super EnterExitState, Boolean>> state) {
        return (Function2) state.getValue();
    }

    private static final boolean AnimatedEnterExitImpl$lambda$4(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
