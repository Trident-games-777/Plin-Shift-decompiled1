package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.core.view.PointerIconCompat;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u001aN\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\f\u001aX\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u000f\u001a\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00102\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00140\n2&\u0010\t\u001a\"\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u0015¨\u0006\u0016²\u0006\u0010\u0010\u0017\u001a\u00020\b\"\u0004\b\u0000\u0010\u0002X\u0002"}, d2 = {"Crossfade", "", "T", "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "label", "", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/animation/core/Transition;", "contentKey", "Lkotlin/ParameterName;", "name", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "animation_release", "alpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Crossfade.kt */
public final class CrossfadeKt {
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> void Crossfade(T r16, androidx.compose.ui.Modifier r17, androidx.compose.animation.core.FiniteAnimationSpec<java.lang.Float> r18, java.lang.String r19, kotlin.jvm.functions.Function3<? super T, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r20, androidx.compose.runtime.Composer r21, int r22, int r23) {
        /*
            r1 = r16
            r6 = r22
            r0 = -310686752(0xffffffffed7b4be0, float:-4.860779E27)
            r2 = r21
            androidx.compose.runtime.Composer r12 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(Crossfade)P(4,3!1,2)56@2327L36,57@2379L53:Crossfade.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r2)
            r2 = r23 & 1
            if (r2 == 0) goto L_0x0019
            r2 = r6 | 6
            goto L_0x0032
        L_0x0019:
            r2 = r6 & 6
            if (r2 != 0) goto L_0x0031
            r2 = r6 & 8
            if (r2 != 0) goto L_0x0026
            boolean r2 = r12.changed((java.lang.Object) r1)
            goto L_0x002a
        L_0x0026:
            boolean r2 = r12.changedInstance(r1)
        L_0x002a:
            if (r2 == 0) goto L_0x002e
            r2 = 4
            goto L_0x002f
        L_0x002e:
            r2 = 2
        L_0x002f:
            r2 = r2 | r6
            goto L_0x0032
        L_0x0031:
            r2 = r6
        L_0x0032:
            r3 = r23 & 2
            if (r3 == 0) goto L_0x0039
            r2 = r2 | 48
            goto L_0x004c
        L_0x0039:
            r4 = r6 & 48
            if (r4 != 0) goto L_0x004c
            r4 = r17
            boolean r5 = r12.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0048
            r5 = 32
            goto L_0x004a
        L_0x0048:
            r5 = 16
        L_0x004a:
            r2 = r2 | r5
            goto L_0x004e
        L_0x004c:
            r4 = r17
        L_0x004e:
            r5 = r23 & 4
            if (r5 == 0) goto L_0x0055
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0055:
            r7 = r6 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0068
            r7 = r18
            boolean r8 = r12.changedInstance(r7)
            if (r8 == 0) goto L_0x0064
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r2 = r2 | r8
            goto L_0x006a
        L_0x0068:
            r7 = r18
        L_0x006a:
            r8 = r23 & 8
            if (r8 == 0) goto L_0x0071
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0084
        L_0x0071:
            r9 = r6 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x0084
            r9 = r19
            boolean r10 = r12.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0080
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0082
        L_0x0080:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0082:
            r2 = r2 | r10
            goto L_0x0086
        L_0x0084:
            r9 = r19
        L_0x0086:
            r10 = r23 & 16
            if (r10 == 0) goto L_0x008f
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            r11 = r20
            goto L_0x00a1
        L_0x008f:
            r10 = r6 & 24576(0x6000, float:3.4438E-41)
            r11 = r20
            if (r10 != 0) goto L_0x00a1
            boolean r10 = r12.changedInstance(r11)
            if (r10 == 0) goto L_0x009e
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a0
        L_0x009e:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x00a0:
            r2 = r2 | r10
        L_0x00a1:
            r10 = r2 & 9363(0x2493, float:1.312E-41)
            r13 = 9362(0x2492, float:1.3119E-41)
            if (r10 != r13) goto L_0x00b5
            boolean r10 = r12.getSkipping()
            if (r10 != 0) goto L_0x00ae
            goto L_0x00b5
        L_0x00ae:
            r12.skipToGroupEnd()
            r2 = r4
            r3 = r7
            r4 = r9
            goto L_0x0100
        L_0x00b5:
            if (r3 == 0) goto L_0x00bc
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x00bd
        L_0x00bc:
            r3 = r4
        L_0x00bd:
            r4 = 0
            if (r5 == 0) goto L_0x00c9
            r5 = 7
            r7 = 0
            androidx.compose.animation.core.TweenSpec r5 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r4, r4, r7, r5, r7)
            androidx.compose.animation.core.FiniteAnimationSpec r5 = (androidx.compose.animation.core.FiniteAnimationSpec) r5
            goto L_0x00ca
        L_0x00c9:
            r5 = r7
        L_0x00ca:
            if (r8 == 0) goto L_0x00d0
            java.lang.String r7 = "Crossfade"
            r15 = r7
            goto L_0x00d1
        L_0x00d0:
            r15 = r9
        L_0x00d1:
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x00dd
            r7 = -1
            java.lang.String r8 = "androidx.compose.animation.Crossfade (Crossfade.kt:55)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r7, r8)
        L_0x00dd:
            r0 = r2 & 14
            int r7 = r2 >> 6
            r7 = r7 & 112(0x70, float:1.57E-43)
            r0 = r0 | r7
            androidx.compose.animation.core.Transition r7 = androidx.compose.animation.core.TransitionKt.updateTransition(r1, (java.lang.String) r15, (androidx.compose.runtime.Composer) r12, (int) r0, (int) r4)
            r0 = 58352(0xe3f0, float:8.1769E-41)
            r13 = r2 & r0
            r14 = 4
            r10 = 0
            r8 = r3
            r9 = r5
            Crossfade(r7, (androidx.compose.ui.Modifier) r8, (androidx.compose.animation.core.FiniteAnimationSpec<java.lang.Float>) r9, r10, r11, (androidx.compose.runtime.Composer) r12, (int) r13, (int) r14)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x00fd
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00fd:
            r2 = r8
            r3 = r9
            r4 = r15
        L_0x0100:
            androidx.compose.runtime.ScopeUpdateScope r8 = r12.endRestartGroup()
            if (r8 == 0) goto L_0x0114
            androidx.compose.animation.CrossfadeKt$Crossfade$1 r0 = new androidx.compose.animation.CrossfadeKt$Crossfade$1
            r5 = r20
            r7 = r23
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r8.updateScope(r0)
        L_0x0114:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.CrossfadeKt.Crossfade(java.lang.Object, androidx.compose.ui.Modifier, androidx.compose.animation.core.FiniteAnimationSpec, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Crossfade API now has a new label parameter added.")
    public static final /* synthetic */ void Crossfade(Object obj, Modifier modifier, FiniteAnimationSpec finiteAnimationSpec, Function3 function3, Composer composer, int i, int i2) {
        int i3;
        Function3 function32;
        FiniteAnimationSpec finiteAnimationSpec2;
        Modifier modifier2;
        Composer startRestartGroup = composer.startRestartGroup(523603005);
        ComposerKt.sourceInformation(startRestartGroup, "C(Crossfade)P(3,2)72@2790L29,73@2835L53:Crossfade.kt#xbi5r1");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? startRestartGroup.changed(obj) : startRestartGroup.changedInstance(obj) ? 4 : 2) | i;
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
            i3 |= startRestartGroup.changedInstance(finiteAnimationSpec) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((i3 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            Modifier modifier3 = modifier;
            if (i5 != 0) {
                finiteAnimationSpec = AnimationSpecKt.tween$default(0, 0, (Easing) null, 7, (Object) null);
            }
            FiniteAnimationSpec finiteAnimationSpec3 = finiteAnimationSpec;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(523603005, i3, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:71)");
            }
            Function3 function33 = function3;
            Crossfade(TransitionKt.updateTransition(obj, (String) null, startRestartGroup, i3 & 14, 2), modifier3, (FiniteAnimationSpec<Float>) finiteAnimationSpec3, (Function1) null, function33, startRestartGroup, (i3 & PointerIconCompat.TYPE_TEXT) | ((i3 << 3) & 57344), 4);
            function32 = function33;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            finiteAnimationSpec2 = finiteAnimationSpec3;
        } else {
            startRestartGroup.skipToGroupEnd();
            function32 = function3;
            finiteAnimationSpec2 = finiteAnimationSpec;
            modifier2 = modifier;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CrossfadeKt$Crossfade$2(obj, modifier2, finiteAnimationSpec2, function32, i, i2));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:139:0x0350  */
    /* JADX WARNING: Removed duplicated region for block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> void Crossfade(androidx.compose.animation.core.Transition<T> r16, androidx.compose.ui.Modifier r17, androidx.compose.animation.core.FiniteAnimationSpec<java.lang.Float> r18, kotlin.jvm.functions.Function1<? super T, ? extends java.lang.Object> r19, kotlin.jvm.functions.Function3<? super T, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r20, androidx.compose.runtime.Composer r21, int r22, int r23) {
        /*
            r1 = r16
            r5 = r20
            r6 = r22
            r0 = 679005231(0x2878cc2f, float:1.3811041E-14)
            r2 = r21
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(Crossfade)P(3!1,2)104@4422L64,105@4508L61,137@5785L159:Crossfade.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r23 & r3
            r4 = 4
            if (r3 == 0) goto L_0x001e
            r3 = r6 | 6
            goto L_0x002e
        L_0x001e:
            r3 = r6 & 6
            if (r3 != 0) goto L_0x002d
            boolean r3 = r2.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x002a
            r3 = r4
            goto L_0x002b
        L_0x002a:
            r3 = 2
        L_0x002b:
            r3 = r3 | r6
            goto L_0x002e
        L_0x002d:
            r3 = r6
        L_0x002e:
            r7 = r23 & 1
            if (r7 == 0) goto L_0x0035
            r3 = r3 | 48
            goto L_0x0048
        L_0x0035:
            r8 = r6 & 48
            if (r8 != 0) goto L_0x0048
            r8 = r17
            boolean r9 = r2.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0044
            r9 = 32
            goto L_0x0046
        L_0x0044:
            r9 = 16
        L_0x0046:
            r3 = r3 | r9
            goto L_0x004a
        L_0x0048:
            r8 = r17
        L_0x004a:
            r9 = r23 & 2
            if (r9 == 0) goto L_0x0051
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0051:
            r10 = r6 & 384(0x180, float:5.38E-43)
            if (r10 != 0) goto L_0x0064
            r10 = r18
            boolean r11 = r2.changedInstance(r10)
            if (r11 == 0) goto L_0x0060
            r11 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r11 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r3 = r3 | r11
            goto L_0x0066
        L_0x0064:
            r10 = r18
        L_0x0066:
            r11 = r23 & 4
            if (r11 == 0) goto L_0x006d
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0080
        L_0x006d:
            r12 = r6 & 3072(0xc00, float:4.305E-42)
            if (r12 != 0) goto L_0x0080
            r12 = r19
            boolean r13 = r2.changedInstance(r12)
            if (r13 == 0) goto L_0x007c
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r3 = r3 | r13
            goto L_0x0082
        L_0x0080:
            r12 = r19
        L_0x0082:
            r13 = r23 & 8
            if (r13 == 0) goto L_0x0089
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0099
        L_0x0089:
            r13 = r6 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x0099
            boolean r13 = r2.changedInstance(r5)
            if (r13 == 0) goto L_0x0096
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r3 = r3 | r13
        L_0x0099:
            r13 = r3 & 9363(0x2493, float:1.312E-41)
            r14 = 9362(0x2492, float:1.3119E-41)
            if (r13 != r14) goto L_0x00ad
            boolean r13 = r2.getSkipping()
            if (r13 != 0) goto L_0x00a6
            goto L_0x00ad
        L_0x00a6:
            r2.skipToGroupEnd()
            r3 = r10
            r4 = r12
            goto L_0x034a
        L_0x00ad:
            if (r7 == 0) goto L_0x00b4
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            r8 = r7
        L_0x00b4:
            r7 = 0
            if (r9 == 0) goto L_0x00c0
            r9 = 7
            r10 = 0
            androidx.compose.animation.core.TweenSpec r9 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r7, r7, r10, r9, r10)
            androidx.compose.animation.core.FiniteAnimationSpec r9 = (androidx.compose.animation.core.FiniteAnimationSpec) r9
            goto L_0x00c1
        L_0x00c0:
            r9 = r10
        L_0x00c1:
            if (r11 == 0) goto L_0x00c8
            androidx.compose.animation.CrossfadeKt$Crossfade$3 r10 = androidx.compose.animation.CrossfadeKt$Crossfade$3.INSTANCE
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            goto L_0x00c9
        L_0x00c8:
            r10 = r12
        L_0x00c9:
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r12 = -1
            if (r11 == 0) goto L_0x00d5
            java.lang.String r11 = "androidx.compose.animation.Crossfade (Crossfade.kt:103)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r12, r11)
        L_0x00d5:
            r0 = 1274683025(0x4bfa1e91, float:3.278365E7)
            java.lang.String r11 = "CC(remember):Crossfade.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r11)
            java.lang.Object r0 = r2.rememberedValue()
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r0 != r13) goto L_0x00f7
            androidx.compose.runtime.snapshots.SnapshotStateList r0 = androidx.compose.runtime.SnapshotStateKt.mutableStateListOf()
            java.lang.Object r13 = r1.getCurrentState()
            r0.add(r13)
            r2.updateRememberedValue(r0)
        L_0x00f7:
            androidx.compose.runtime.snapshots.SnapshotStateList r0 = (androidx.compose.runtime.snapshots.SnapshotStateList) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r13 = 1274685774(0x4bfa294e, float:3.2789148E7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r13, r11)
            java.lang.Object r13 = r2.rememberedValue()
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r13 != r14) goto L_0x0115
            androidx.collection.MutableScatterMap r13 = androidx.collection.ScatterMapKt.mutableScatterMapOf()
            r2.updateRememberedValue(r13)
        L_0x0115:
            androidx.collection.MutableScatterMap r13 = (androidx.collection.MutableScatterMap) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            java.lang.Object r14 = r1.getCurrentState()
            java.lang.Object r15 = r1.getTargetState()
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r15)
            java.lang.String r15 = ""
            r12 = 1
            if (r14 == 0) goto L_0x0199
            r14 = 860660313(0x334ca259, float:4.7645106E-8)
            r2.startReplaceGroup(r14)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r15)
            int r14 = r0.size()
            if (r14 != r12) goto L_0x0153
            java.lang.Object r14 = r0.get(r7)
            java.lang.Object r7 = r1.getTargetState()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r7)
            if (r7 != 0) goto L_0x0149
            goto L_0x0153
        L_0x0149:
            r3 = 860984945(0x33519671, float:4.879843E-8)
            r2.startReplaceGroup(r3)
            r2.endReplaceGroup()
            goto L_0x0195
        L_0x0153:
            r7 = 860794667(0x334eaf2b, float:4.8122427E-8)
            r2.startReplaceGroup(r7)
            java.lang.String r7 = "110@4883L21"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r7)
            r7 = r0
            java.util.List r7 = (java.util.List) r7
            r14 = 1274697734(0x4bfa5806, float:3.2813068E7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r14, r11)
            r3 = r3 & 14
            if (r3 != r4) goto L_0x016d
            r3 = r12
            goto L_0x016e
        L_0x016d:
            r3 = 0
        L_0x016e:
            java.lang.Object r4 = r2.rememberedValue()
            if (r3 != 0) goto L_0x017c
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x0187
        L_0x017c:
            androidx.compose.animation.CrossfadeKt$Crossfade$4$1 r3 = new androidx.compose.animation.CrossfadeKt$Crossfade$4$1
            r3.<init>(r1)
            r4 = r3
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r2.updateRememberedValue(r4)
        L_0x0187:
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            kotlin.collections.CollectionsKt.removeAll(r7, r4)
            r13.clear()
            r2.endReplaceGroup()
        L_0x0195:
            r2.endReplaceGroup()
            goto L_0x01a2
        L_0x0199:
            r3 = 860990897(0x3351adb1, float:4.8819576E-8)
            r2.startReplaceGroup(r3)
            r2.endReplaceGroup()
        L_0x01a2:
            java.lang.Object r3 = r1.getTargetState()
            boolean r3 = r13.contains(r3)
            if (r3 != 0) goto L_0x0220
            r3 = 861052122(0x33529cda, float:4.903709E-8)
            r2.startReplaceGroup(r3)
            java.lang.String r3 = "*126@5458L305"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r0
            java.util.List r3 = (java.util.List) r3
            java.util.Iterator r4 = r3.iterator()
            r7 = 0
        L_0x01bf:
            boolean r11 = r4.hasNext()
            if (r11 == 0) goto L_0x01df
            java.lang.Object r11 = r4.next()
            java.lang.Object r11 = r10.invoke(r11)
            java.lang.Object r14 = r1.getTargetState()
            java.lang.Object r14 = r10.invoke(r14)
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r14)
            if (r11 == 0) goto L_0x01dc
            goto L_0x01e0
        L_0x01dc:
            int r7 = r7 + 1
            goto L_0x01bf
        L_0x01df:
            r7 = -1
        L_0x01e0:
            r4 = -1
            if (r7 != r4) goto L_0x01eb
            java.lang.Object r4 = r1.getTargetState()
            r0.add(r4)
            goto L_0x01f2
        L_0x01eb:
            java.lang.Object r4 = r1.getTargetState()
            r0.set(r7, r4)
        L_0x01f2:
            r13.clear()
            int r4 = r3.size()
            r7 = 0
        L_0x01fa:
            if (r7 >= r4) goto L_0x021a
            java.lang.Object r11 = r3.get(r7)
            androidx.compose.animation.CrossfadeKt$Crossfade$5$1 r14 = new androidx.compose.animation.CrossfadeKt$Crossfade$5$1
            r14.<init>(r1, r9, r11, r5)
            r17 = r0
            r0 = 54
            r1 = -1426421288(0xffffffffaafa89d8, float:-4.450457E-13)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r1, r12, r14, r2, r0)
            r13.set(r11, r0)
            int r7 = r7 + 1
            r1 = r16
            r0 = r17
            goto L_0x01fa
        L_0x021a:
            r17 = r0
            r2.endReplaceGroup()
            goto L_0x022b
        L_0x0220:
            r17 = r0
            r0 = 861812273(0x335e3631, float:5.173769E-8)
            r2.startReplaceGroup(r0)
            r2.endReplaceGroup()
        L_0x022b:
            r0 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            java.lang.String r1 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r1)
            androidx.compose.ui.Alignment$Companion r0 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r0 = r0.getTopStart()
            r1 = 0
            androidx.compose.ui.layout.MeasurePolicy r0 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r0, r1)
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r4 = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r3, r4)
            int r3 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r1)
            androidx.compose.runtime.CompositionLocalMap r1 = r2.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r4 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r2, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r7 = r7.getConstructor()
            r11 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            java.lang.String r12 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r11, r12)
            androidx.compose.runtime.Applier r11 = r2.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x026b
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x026b:
            r2.startReusableNode()
            boolean r11 = r2.getInserting()
            if (r11 == 0) goto L_0x0278
            r2.createNode(r7)
            goto L_0x027b
        L_0x0278:
            r2.useNode()
        L_0x027b:
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.Updater.m3675constructorimpl(r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r7, r0, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r7, r1, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetCompositeKeyHash()
            boolean r1 = r7.getInserting()
            if (r1 != 0) goto L_0x02ab
            java.lang.Object r1 = r7.rememberedValue()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r3)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r11)
            if (r1 != 0) goto L_0x02b9
        L_0x02ab:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            r7.updateRememberedValue(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            r7.apply(r1, r0)
        L_0x02b9:
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r7, r4, r0)
            r0 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            java.lang.String r1 = "C73@3429L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r0 = -1517004430(0xffffffffa5945972, float:-2.5734518E-16)
            java.lang.String r1 = "C:Crossfade.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r1)
            r0 = -187482432(0xfffffffff4d33ec0, float:-1.338925E32)
            r2.startReplaceGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r15)
            r0 = r17
            java.util.List r0 = (java.util.List) r0
            int r1 = r0.size()
            r3 = 0
        L_0x02e8:
            if (r3 >= r1) goto L_0x032a
            java.lang.Object r4 = r0.get(r3)
            r7 = -1081873445(0xffffffffbf83ebdb, float:-1.0306352)
            java.lang.Object r11 = r10.invoke(r4)
            r2.startMovableGroup(r7, r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r15)
            java.lang.Object r4 = r13.get(r4)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            if (r4 != 0) goto L_0x030e
            r4 = 821713034(0x30fa588a, float:1.8215058E-9)
            r2.startReplaceGroup(r4)
            r2.endReplaceGroup()
            r7 = 0
            goto L_0x0324
        L_0x030e:
            r7 = -1081871785(0xffffffffbf83f257, float:-1.0308331)
            r2.startReplaceGroup(r7)
            java.lang.String r7 = "140@5906L8"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r7)
            r7 = 0
            java.lang.Integer r11 = java.lang.Integer.valueOf(r7)
            r4.invoke(r2, r11)
            r2.endReplaceGroup()
        L_0x0324:
            r2.endMovableGroup()
            int r3 = r3 + 1
            goto L_0x02e8
        L_0x032a:
            r2.endReplaceGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r2.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0348
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0348:
            r3 = r9
            r4 = r10
        L_0x034a:
            androidx.compose.runtime.ScopeUpdateScope r9 = r2.endRestartGroup()
            if (r9 == 0) goto L_0x035f
            androidx.compose.animation.CrossfadeKt$Crossfade$7 r0 = new androidx.compose.animation.CrossfadeKt$Crossfade$7
            r1 = r16
            r7 = r23
            r2 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x035f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.CrossfadeKt.Crossfade(androidx.compose.animation.core.Transition, androidx.compose.ui.Modifier, androidx.compose.animation.core.FiniteAnimationSpec, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }
}
