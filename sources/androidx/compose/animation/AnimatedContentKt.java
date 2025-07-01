package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.unit.IntSize;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a´\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001f\b\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000721\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u0017\u001aP\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2>\b\u0002\u0010\u001c\u001a8\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0 0\u0014\u001a¬\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020!2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001f\b\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000721\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\"\u001a\u0015\u0010#\u001a\u00020\t*\u00020$2\u0006\u0010%\u001a\u00020&H\u0004\u001a\u0015\u0010'\u001a\u00020\t*\u00020$2\u0006\u0010%\u001a\u00020&H\u0004¨\u0006("}, d2 = {"AnimatedContent", "", "S", "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/compose/animation/ContentTransform;", "Lkotlin/ExtensionFunctionType;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "label", "", "contentKey", "Lkotlin/ParameterName;", "name", "", "content", "Lkotlin/Function2;", "Landroidx/compose/animation/AnimatedContentScope;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "SizeTransform", "Landroidx/compose/animation/SizeTransform;", "clip", "", "sizeAnimationSpec", "Landroidx/compose/ui/unit/IntSize;", "initialSize", "targetSize", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/animation/core/Transition;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "togetherWith", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "with", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedContent.kt */
public final class AnimatedContentKt {
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00fa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <S> void AnimatedContent(S r18, androidx.compose.ui.Modifier r19, kotlin.jvm.functions.Function1<? super androidx.compose.animation.AnimatedContentTransitionScope<S>, androidx.compose.animation.ContentTransform> r20, androidx.compose.ui.Alignment r21, java.lang.String r22, kotlin.jvm.functions.Function1<? super S, ? extends java.lang.Object> r23, kotlin.jvm.functions.Function4<? super androidx.compose.animation.AnimatedContentScope, ? super S, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r24, androidx.compose.runtime.Composer r25, int r26, int r27) {
        /*
            r1 = r18
            r8 = r26
            r0 = 2132720749(0x7f1ebc6d, float:2.1099639E38)
            r2 = r25
            androidx.compose.runtime.Composer r15 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(AnimatedContent)P(5,4,6,1,3,2)141@7507L58,142@7581L136:AnimatedContent.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            r2 = r27 & 1
            if (r2 == 0) goto L_0x0019
            r2 = r8 | 6
            goto L_0x0032
        L_0x0019:
            r2 = r8 & 6
            if (r2 != 0) goto L_0x0031
            r2 = r8 & 8
            if (r2 != 0) goto L_0x0026
            boolean r2 = r15.changed((java.lang.Object) r1)
            goto L_0x002a
        L_0x0026:
            boolean r2 = r15.changedInstance(r1)
        L_0x002a:
            if (r2 == 0) goto L_0x002e
            r2 = 4
            goto L_0x002f
        L_0x002e:
            r2 = 2
        L_0x002f:
            r2 = r2 | r8
            goto L_0x0032
        L_0x0031:
            r2 = r8
        L_0x0032:
            r3 = r27 & 2
            if (r3 == 0) goto L_0x0039
            r2 = r2 | 48
            goto L_0x004c
        L_0x0039:
            r4 = r8 & 48
            if (r4 != 0) goto L_0x004c
            r4 = r19
            boolean r5 = r15.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0048
            r5 = 32
            goto L_0x004a
        L_0x0048:
            r5 = 16
        L_0x004a:
            r2 = r2 | r5
            goto L_0x004e
        L_0x004c:
            r4 = r19
        L_0x004e:
            r5 = r27 & 4
            if (r5 == 0) goto L_0x0055
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0055:
            r6 = r8 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0068
            r6 = r20
            boolean r7 = r15.changedInstance(r6)
            if (r7 == 0) goto L_0x0064
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r2 = r2 | r7
            goto L_0x006a
        L_0x0068:
            r6 = r20
        L_0x006a:
            r7 = r27 & 8
            if (r7 == 0) goto L_0x0071
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0084
        L_0x0071:
            r9 = r8 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x0084
            r9 = r21
            boolean r10 = r15.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0080
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0082
        L_0x0080:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0082:
            r2 = r2 | r10
            goto L_0x0086
        L_0x0084:
            r9 = r21
        L_0x0086:
            r10 = r27 & 16
            if (r10 == 0) goto L_0x008d
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a0
        L_0x008d:
            r11 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x00a0
            r11 = r22
            boolean r12 = r15.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x009c
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009e
        L_0x009c:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x009e:
            r2 = r2 | r12
            goto L_0x00a2
        L_0x00a0:
            r11 = r22
        L_0x00a2:
            r12 = r27 & 32
            r13 = 196608(0x30000, float:2.75506E-40)
            if (r12 == 0) goto L_0x00aa
            r2 = r2 | r13
            goto L_0x00bc
        L_0x00aa:
            r13 = r13 & r8
            if (r13 != 0) goto L_0x00bc
            r13 = r23
            boolean r14 = r15.changedInstance(r13)
            if (r14 == 0) goto L_0x00b8
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ba
        L_0x00b8:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00ba:
            r2 = r2 | r14
            goto L_0x00be
        L_0x00bc:
            r13 = r23
        L_0x00be:
            r14 = r27 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r14 == 0) goto L_0x00c7
            r2 = r2 | r16
            goto L_0x00db
        L_0x00c7:
            r14 = r8 & r16
            if (r14 != 0) goto L_0x00db
            r14 = r24
            boolean r16 = r15.changedInstance(r14)
            if (r16 == 0) goto L_0x00d6
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d8
        L_0x00d6:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d8:
            r2 = r2 | r16
            goto L_0x00dd
        L_0x00db:
            r14 = r24
        L_0x00dd:
            r16 = 599187(0x92493, float:8.3964E-40)
            r0 = r2 & r16
            r25 = r3
            r3 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r3) goto L_0x00fa
            boolean r0 = r15.getSkipping()
            if (r0 != 0) goto L_0x00f0
            goto L_0x00fa
        L_0x00f0:
            r15.skipToGroupEnd()
            r2 = r4
            r3 = r6
            r4 = r9
            r5 = r11
        L_0x00f7:
            r6 = r13
            goto L_0x015f
        L_0x00fa:
            if (r25 == 0) goto L_0x0101
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0102
        L_0x0101:
            r0 = r4
        L_0x0102:
            if (r5 == 0) goto L_0x0109
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$1 r3 = androidx.compose.animation.AnimatedContentKt$AnimatedContent$1.INSTANCE
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r6 = r3
        L_0x0109:
            if (r7 == 0) goto L_0x0112
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r3 = r3.getTopStart()
            r9 = r3
        L_0x0112:
            if (r10 == 0) goto L_0x0117
            java.lang.String r3 = "AnimatedContent"
            goto L_0x0118
        L_0x0117:
            r3 = r11
        L_0x0118:
            if (r12 == 0) goto L_0x011f
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$2 r4 = androidx.compose.animation.AnimatedContentKt$AnimatedContent$2.INSTANCE
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r13 = r4
        L_0x011f:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x012e
            r4 = -1
            java.lang.String r5 = "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:140)"
            r7 = 2132720749(0x7f1ebc6d, float:2.1099639E38)
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r2, r4, r5)
        L_0x012e:
            r4 = r2 & 14
            int r5 = r2 >> 9
            r5 = r5 & 112(0x70, float:1.57E-43)
            r4 = r4 | r5
            r5 = 0
            androidx.compose.animation.core.Transition r4 = androidx.compose.animation.core.TransitionKt.updateTransition(r1, (java.lang.String) r3, (androidx.compose.runtime.Composer) r15, (int) r4, (int) r5)
            r5 = r2 & 8176(0x1ff0, float:1.1457E-41)
            int r2 = r2 >> 3
            r7 = 57344(0xe000, float:8.0356E-41)
            r7 = r7 & r2
            r5 = r5 | r7
            r7 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r7
            r16 = r5 | r2
            r17 = 0
            r10 = r0
            r11 = r6
            r12 = r9
            r9 = r4
            AnimatedContent(r9, r10, r11, r12, r13, r14, r15, r16, r17)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x015a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x015a:
            r5 = r3
            r2 = r10
            r3 = r11
            r4 = r12
            goto L_0x00f7
        L_0x015f:
            androidx.compose.runtime.ScopeUpdateScope r10 = r15.endRestartGroup()
            if (r10 == 0) goto L_0x0173
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$3 r0 = new androidx.compose.animation.AnimatedContentKt$AnimatedContent$3
            r7 = r24
            r9 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x0173:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedContentKt.AnimatedContent(java.lang.Object, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.ui.Alignment, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }

    public static /* synthetic */ SizeTransform SizeTransform$default(boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            function2 = AnimatedContentKt$SizeTransform$1.INSTANCE;
        }
        return SizeTransform(z, function2);
    }

    public static final SizeTransform SizeTransform(boolean z, Function2<? super IntSize, ? super IntSize, ? extends FiniteAnimationSpec<IntSize>> function2) {
        return new SizeTransformImpl(z, function2);
    }

    public static final ContentTransform togetherWith(EnterTransition enterTransition, ExitTransition exitTransition) {
        return new ContentTransform(enterTransition, exitTransition, 0.0f, (SizeTransform) null, 12, (DefaultConstructorMarker) null);
    }

    @Deprecated(message = "Infix fun EnterTransition.with(ExitTransition) has been renamed to togetherWith", replaceWith = @ReplaceWith(expression = "togetherWith(exit)", imports = {}))
    public static final ContentTransform with(EnterTransition enterTransition, ExitTransition exitTransition) {
        return new ContentTransform(enterTransition, exitTransition, 0.0f, (SizeTransform) null, 12, (DefaultConstructorMarker) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: androidx.compose.animation.AnimatedContentTransitionScopeImpl} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: androidx.collection.MutableScatterMap} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x040d  */
    /* JADX WARNING: Removed duplicated region for block: B:193:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00d1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <S> void AnimatedContent(androidx.compose.animation.core.Transition<S> r18, androidx.compose.ui.Modifier r19, kotlin.jvm.functions.Function1<? super androidx.compose.animation.AnimatedContentTransitionScope<S>, androidx.compose.animation.ContentTransform> r20, androidx.compose.ui.Alignment r21, kotlin.jvm.functions.Function1<? super S, ? extends java.lang.Object> r22, kotlin.jvm.functions.Function4<? super androidx.compose.animation.AnimatedContentScope, ? super S, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, androidx.compose.runtime.Composer r24, int r25, int r26) {
        /*
            r1 = r18
            r7 = r25
            r0 = -114689412(0xfffffffff929fa7c, float:-5.516116E34)
            r2 = r24
            androidx.compose.runtime.Composer r8 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(AnimatedContent)P(3,4,1,2)714@34537L7,715@34565L106,719@34759L51,720@34832L69,808@39387L58,809@39479L45,819@39798L52,810@39529L327:AnimatedContent.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r2)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r26 & r2
            if (r2 == 0) goto L_0x001b
            r2 = r7 | 6
            goto L_0x002b
        L_0x001b:
            r2 = r7 & 6
            if (r2 != 0) goto L_0x002a
            boolean r2 = r8.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0027
            r2 = 4
            goto L_0x0028
        L_0x0027:
            r2 = 2
        L_0x0028:
            r2 = r2 | r7
            goto L_0x002b
        L_0x002a:
            r2 = r7
        L_0x002b:
            r4 = r26 & 1
            if (r4 == 0) goto L_0x0032
            r2 = r2 | 48
            goto L_0x0045
        L_0x0032:
            r5 = r7 & 48
            if (r5 != 0) goto L_0x0045
            r5 = r19
            boolean r6 = r8.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0041
            r6 = 32
            goto L_0x0043
        L_0x0041:
            r6 = 16
        L_0x0043:
            r2 = r2 | r6
            goto L_0x0047
        L_0x0045:
            r5 = r19
        L_0x0047:
            r6 = r26 & 2
            if (r6 == 0) goto L_0x004e
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r9 = r7 & 384(0x180, float:5.38E-43)
            if (r9 != 0) goto L_0x0061
            r9 = r20
            boolean r10 = r8.changedInstance(r9)
            if (r10 == 0) goto L_0x005d
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r10 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r2 = r2 | r10
            goto L_0x0063
        L_0x0061:
            r9 = r20
        L_0x0063:
            r10 = r26 & 4
            if (r10 == 0) goto L_0x006a
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006a:
            r11 = r7 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x007d
            r11 = r21
            boolean r12 = r8.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0079
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r2 = r2 | r12
            goto L_0x007f
        L_0x007d:
            r11 = r21
        L_0x007f:
            r12 = r26 & 8
            if (r12 == 0) goto L_0x0086
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0099
        L_0x0086:
            r13 = r7 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x0099
            r13 = r22
            boolean r14 = r8.changedInstance(r13)
            if (r14 == 0) goto L_0x0095
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r2 = r2 | r14
            goto L_0x009b
        L_0x0099:
            r13 = r22
        L_0x009b:
            r14 = r26 & 16
            r15 = 196608(0x30000, float:2.75506E-40)
            if (r14 == 0) goto L_0x00a3
            r2 = r2 | r15
            goto L_0x00b6
        L_0x00a3:
            r14 = r7 & r15
            if (r14 != 0) goto L_0x00b6
            r14 = r23
            boolean r15 = r8.changedInstance(r14)
            if (r15 == 0) goto L_0x00b2
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b4
        L_0x00b2:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b4:
            r2 = r2 | r15
            goto L_0x00b8
        L_0x00b6:
            r14 = r23
        L_0x00b8:
            r15 = 74899(0x12493, float:1.04956E-40)
            r15 = r15 & r2
            r3 = 74898(0x12492, float:1.04954E-40)
            if (r15 != r3) goto L_0x00d1
            boolean r3 = r8.getSkipping()
            if (r3 != 0) goto L_0x00c8
            goto L_0x00d1
        L_0x00c8:
            r8.skipToGroupEnd()
            r2 = r5
            r3 = r9
        L_0x00cd:
            r4 = r11
            r5 = r13
            goto L_0x0407
        L_0x00d1:
            if (r4 == 0) goto L_0x00d9
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r15 = r3
            goto L_0x00da
        L_0x00d9:
            r15 = r5
        L_0x00da:
            if (r6 == 0) goto L_0x00e1
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$4 r3 = androidx.compose.animation.AnimatedContentKt$AnimatedContent$4.INSTANCE
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            goto L_0x00e2
        L_0x00e1:
            r3 = r9
        L_0x00e2:
            if (r10 == 0) goto L_0x00eb
            androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r4 = r4.getTopStart()
            r11 = r4
        L_0x00eb:
            if (r12 == 0) goto L_0x00f2
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$5 r4 = androidx.compose.animation.AnimatedContentKt$AnimatedContent$5.INSTANCE
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r13 = r4
        L_0x00f2:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r5 = -1
            if (r4 == 0) goto L_0x00fe
            java.lang.String r4 = "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:713)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r5, r4)
        L_0x00fe:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r6 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r4, r6)
            java.lang.Object r0 = r8.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.ui.unit.LayoutDirection r0 = (androidx.compose.ui.unit.LayoutDirection) r0
            r4 = -801903883(0xffffffffd033eaf5, float:-1.20740792E10)
            java.lang.String r9 = "CC(remember):AnimatedContent.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r4, r9)
            r2 = r2 & 14
            r12 = 1
            r4 = 4
            if (r2 != r4) goto L_0x0125
            r4 = r12
            goto L_0x0126
        L_0x0125:
            r4 = 0
        L_0x0126:
            java.lang.Object r6 = r8.rememberedValue()
            if (r4 != 0) goto L_0x0134
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r6 != r4) goto L_0x013c
        L_0x0134:
            androidx.compose.animation.AnimatedContentTransitionScopeImpl r6 = new androidx.compose.animation.AnimatedContentTransitionScopeImpl
            r6.<init>(r1, r11, r0)
            r8.updateRememberedValue(r6)
        L_0x013c:
            r4 = r6
            androidx.compose.animation.AnimatedContentTransitionScopeImpl r4 = (androidx.compose.animation.AnimatedContentTransitionScopeImpl) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r6 = -801897730(0xffffffffd03402fe, float:-1.20803799E10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r6, r9)
            r6 = 4
            if (r2 != r6) goto L_0x014d
            r6 = r12
            goto L_0x014e
        L_0x014d:
            r6 = 0
        L_0x014e:
            java.lang.Object r5 = r8.rememberedValue()
            if (r6 != 0) goto L_0x015c
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r5 != r6) goto L_0x016b
        L_0x015c:
            java.lang.Object r5 = r1.getCurrentState()
            java.lang.Object[] r5 = new java.lang.Object[]{r5}
            androidx.compose.runtime.snapshots.SnapshotStateList r5 = androidx.compose.runtime.SnapshotStateKt.mutableStateListOf(r5)
            r8.updateRememberedValue(r5)
        L_0x016b:
            androidx.compose.runtime.snapshots.SnapshotStateList r5 = (androidx.compose.runtime.snapshots.SnapshotStateList) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r6 = -801895376(0xffffffffd0340c30, float:-1.20827904E10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r6, r9)
            r6 = 4
            if (r2 != r6) goto L_0x017b
            r2 = r12
            goto L_0x017c
        L_0x017b:
            r2 = 0
        L_0x017c:
            java.lang.Object r6 = r8.rememberedValue()
            if (r2 != 0) goto L_0x018a
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r6 != r2) goto L_0x0191
        L_0x018a:
            androidx.collection.MutableScatterMap r6 = androidx.collection.ScatterMapKt.mutableScatterMapOf()
            r8.updateRememberedValue(r6)
        L_0x0191:
            r2 = r6
            androidx.collection.MutableScatterMap r2 = (androidx.collection.MutableScatterMap) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            java.lang.Object r6 = r1.getCurrentState()
            boolean r6 = r5.contains(r6)
            if (r6 != 0) goto L_0x01ab
            r5.clear()
            java.lang.Object r6 = r1.getCurrentState()
            r5.add(r6)
        L_0x01ab:
            java.lang.Object r6 = r1.getCurrentState()
            java.lang.Object r10 = r1.getTargetState()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r10)
            if (r6 == 0) goto L_0x01f1
            int r6 = r5.size()
            if (r6 != r12) goto L_0x01ce
            r6 = 0
            java.lang.Object r10 = r5.get(r6)
            java.lang.Object r6 = r1.getCurrentState()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r6)
            if (r6 != 0) goto L_0x01d8
        L_0x01ce:
            r5.clear()
            java.lang.Object r6 = r1.getCurrentState()
            r5.add(r6)
        L_0x01d8:
            int r6 = r2.getSize()
            if (r6 != r12) goto L_0x01e8
            java.lang.Object r6 = r1.getCurrentState()
            boolean r6 = r2.containsKey(r6)
            if (r6 == 0) goto L_0x01eb
        L_0x01e8:
            r2.clear()
        L_0x01eb:
            r4.setContentAlignment(r11)
            r4.setLayoutDirection$animation_release(r0)
        L_0x01f1:
            java.lang.Object r0 = r1.getCurrentState()
            java.lang.Object r6 = r1.getTargetState()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r6)
            if (r0 != 0) goto L_0x0245
            java.lang.Object r0 = r1.getTargetState()
            boolean r0 = r5.contains(r0)
            if (r0 != 0) goto L_0x0245
            r0 = r5
            java.util.List r0 = (java.util.List) r0
            java.util.Iterator r0 = r0.iterator()
            r6 = 0
        L_0x0211:
            boolean r10 = r0.hasNext()
            if (r10 == 0) goto L_0x0232
            java.lang.Object r10 = r0.next()
            java.lang.Object r10 = r13.invoke(r10)
            java.lang.Object r12 = r1.getTargetState()
            java.lang.Object r12 = r13.invoke(r12)
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r10 == 0) goto L_0x022e
            goto L_0x0233
        L_0x022e:
            int r6 = r6 + 1
            r12 = 1
            goto L_0x0211
        L_0x0232:
            r6 = -1
        L_0x0233:
            r0 = -1
            if (r6 != r0) goto L_0x023e
            java.lang.Object r0 = r1.getTargetState()
            r5.add(r0)
            goto L_0x0245
        L_0x023e:
            java.lang.Object r0 = r1.getTargetState()
            r5.set(r6, r0)
        L_0x0245:
            java.lang.Object r0 = r1.getTargetState()
            boolean r0 = r2.containsKey(r0)
            if (r0 == 0) goto L_0x0267
            java.lang.Object r0 = r1.getCurrentState()
            boolean r0 = r2.containsKey(r0)
            if (r0 != 0) goto L_0x025a
            goto L_0x0267
        L_0x025a:
            r0 = 915535767(0x3691f797, float:4.35016E-6)
            r8.startReplaceGroup(r0)
            r8.endReplaceGroup()
            r14 = r2
            r19 = r5
            goto L_0x02af
        L_0x0267:
            r0 = 912931457(0x366a3a81, float:3.490277E-6)
            r8.startReplaceGroup(r0)
            java.lang.String r0 = "*756@36778L2565"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0)
            r2.clear()
            r10 = r5
            java.util.List r10 = (java.util.List) r10
            int r12 = r10.size()
            r0 = 0
        L_0x027d:
            if (r0 >= r12) goto L_0x02a9
            r6 = r2
            java.lang.Object r2 = r10.get(r0)
            r16 = r0
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1 r0 = new androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1
            r17 = r14
            r14 = r6
            r6 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r1 = 54
            r6 = 885640742(0x34c9ce26, float:3.758916E-7)
            r19 = r5
            r5 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r6, r5, r0, r8, r1)
            r14.set(r2, r0)
            int r0 = r16 + 1
            r1 = r18
            r5 = r19
            r2 = r14
            r14 = r23
            goto L_0x027d
        L_0x02a9:
            r14 = r2
            r19 = r5
            r8.endReplaceGroup()
        L_0x02af:
            androidx.compose.animation.core.Transition$Segment r0 = r18.getSegment()
            r1 = -801749627(0xffffffffd0364585, float:-1.22320374E10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r1, r9)
            boolean r1 = r8.changed((java.lang.Object) r4)
            boolean r0 = r8.changed((java.lang.Object) r0)
            r0 = r0 | r1
            java.lang.Object r1 = r8.rememberedValue()
            if (r0 != 0) goto L_0x02d0
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x02da
        L_0x02d0:
            java.lang.Object r0 = r3.invoke(r4)
            r1 = r0
            androidx.compose.animation.ContentTransform r1 = (androidx.compose.animation.ContentTransform) r1
            r8.updateRememberedValue(r1)
        L_0x02da:
            androidx.compose.animation.ContentTransform r1 = (androidx.compose.animation.ContentTransform) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r6 = 0
            androidx.compose.ui.Modifier r0 = r4.createSizeAnimationModifier$animation_release(r1, r8, r6)
            androidx.compose.ui.Modifier r0 = r15.then(r0)
            r1 = -801736481(0xffffffffd03678df, float:-1.22454989E10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r1, r9)
            java.lang.Object r1 = r8.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x0302
            androidx.compose.animation.AnimatedContentMeasurePolicy r1 = new androidx.compose.animation.AnimatedContentMeasurePolicy
            r1.<init>(r4)
            r8.updateRememberedValue(r1)
        L_0x0302:
            androidx.compose.animation.AnimatedContentMeasurePolicy r1 = (androidx.compose.animation.AnimatedContentMeasurePolicy) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r2 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r4 = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r2, r4)
            r6 = 0
            int r2 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r8, r6)
            androidx.compose.runtime.CompositionLocalMap r4 = r8.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r8, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r5.getConstructor()
            r6 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            java.lang.String r9 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r6, r9)
            androidx.compose.runtime.Applier r6 = r8.getApplier()
            boolean r6 = r6 instanceof androidx.compose.runtime.Applier
            if (r6 != 0) goto L_0x0335
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0335:
            r8.startReusableNode()
            boolean r6 = r8.getInserting()
            if (r6 == 0) goto L_0x0342
            r8.createNode(r5)
            goto L_0x0345
        L_0x0342:
            r8.useNode()
        L_0x0345:
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m3675constructorimpl(r8)
            androidx.compose.ui.layout.MeasurePolicy r1 = (androidx.compose.ui.layout.MeasurePolicy) r1
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r5, r1, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r5, r4, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetCompositeKeyHash()
            boolean r4 = r5.getInserting()
            if (r4 != 0) goto L_0x0377
            java.lang.Object r4 = r5.rememberedValue()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r6)
            if (r4 != 0) goto L_0x0385
        L_0x0377:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            r5.updateRememberedValue(r4)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r5.apply(r2, r1)
        L_0x0385:
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r5, r0, r1)
            r0 = 1023567688(0x3d026748, float:0.031836778)
            java.lang.String r1 = "C:AnimatedContent.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r0, r1)
            r0 = -1491001814(0xffffffffa7211e2a, float:-2.235959E-15)
            r8.startReplaceGroup(r0)
            java.lang.String r0 = ""
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0)
            r5 = r19
            java.util.List r5 = (java.util.List) r5
            int r1 = r5.size()
            r6 = 0
        L_0x03aa:
            if (r6 >= r1) goto L_0x03ec
            java.lang.Object r2 = r5.get(r6)
            r4 = 1908315325(0x71be94bd, float:1.8874229E30)
            java.lang.Object r9 = r13.invoke(r2)
            r8.startMovableGroup(r4, r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0)
            java.lang.Object r2 = r14.get(r2)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            if (r2 != 0) goto L_0x03d0
            r2 = -971711888(0xffffffffc614da70, float:-9526.609)
            r8.startReplaceGroup(r2)
            r8.endReplaceGroup()
            r4 = 0
            goto L_0x03e6
        L_0x03d0:
            r4 = 1908317105(0x71be9bb1, float:1.8876919E30)
            r8.startReplaceGroup(r4)
            java.lang.String r4 = "815@39722L8"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r4)
            r4 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r4)
            r2.invoke(r8, r9)
            r8.endReplaceGroup()
        L_0x03e6:
            r8.endMovableGroup()
            int r6 = r6 + 1
            goto L_0x03aa
        L_0x03ec:
            r8.endReplaceGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r8.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0404
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0404:
            r2 = r15
            goto L_0x00cd
        L_0x0407:
            androidx.compose.runtime.ScopeUpdateScope r9 = r8.endRestartGroup()
            if (r9 == 0) goto L_0x041d
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$9 r0 = new androidx.compose.animation.AnimatedContentKt$AnimatedContent$9
            r1 = r18
            r6 = r23
            r8 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x041d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedContentKt.AnimatedContent(androidx.compose.animation.core.Transition, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.ui.Alignment, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }
}
