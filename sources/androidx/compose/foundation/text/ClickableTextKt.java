package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001av\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001e\u0010\u0017\u001a\u00020\f*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"ClickableText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "onHover", "Lkotlin/Function1;", "", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxLines", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "onClick", "ClickableText-03UYbkw", "(Landroidx/compose/ui/text/AnnotatedString;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;ZIILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ClickableText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;ZIILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "containsWithinBounds", "Landroidx/compose/ui/text/MultiParagraph;", "positionOffset", "Landroidx/compose/ui/geometry/Offset;", "containsWithinBounds-Uv8p0NA", "(Landroidx/compose/ui/text/MultiParagraph;J)Z", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ClickableText.kt */
public final class ClickableTextKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v6, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0118  */
    @kotlin.Deprecated(message = "Use Text or BasicText and pass an AnnotatedString that contains a LinkAnnotation")
    /* renamed from: ClickableText-4YKlhWE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1171ClickableText4YKlhWE(androidx.compose.ui.text.AnnotatedString r24, androidx.compose.ui.Modifier r25, androidx.compose.ui.text.TextStyle r26, boolean r27, int r28, int r29, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r30, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r31, androidx.compose.runtime.Composer r32, int r33, int r34) {
        /*
            r8 = r31
            r9 = r33
            r10 = r34
            r0 = -246609449(0xfffffffff14d09d7, float:-1.0153012E30)
            r1 = r32
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(ClickableText)P(7,1,6,5,4:c#ui.text.style.TextOverflow!1,3)84@3976L52,85@4085L184,100@4490L76,93@4275L297:ClickableText.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r10 & 1
            if (r2 == 0) goto L_0x001d
            r2 = r9 | 6
            r11 = r24
            goto L_0x002f
        L_0x001d:
            r2 = r9 & 6
            r11 = r24
            if (r2 != 0) goto L_0x002e
            boolean r2 = r1.changed((java.lang.Object) r11)
            if (r2 == 0) goto L_0x002b
            r2 = 4
            goto L_0x002c
        L_0x002b:
            r2 = 2
        L_0x002c:
            r2 = r2 | r9
            goto L_0x002f
        L_0x002e:
            r2 = r9
        L_0x002f:
            r4 = r10 & 2
            if (r4 == 0) goto L_0x0036
            r2 = r2 | 48
            goto L_0x0049
        L_0x0036:
            r5 = r9 & 48
            if (r5 != 0) goto L_0x0049
            r5 = r25
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0045
            r6 = 32
            goto L_0x0047
        L_0x0045:
            r6 = 16
        L_0x0047:
            r2 = r2 | r6
            goto L_0x004b
        L_0x0049:
            r5 = r25
        L_0x004b:
            r6 = r10 & 4
            if (r6 == 0) goto L_0x0052
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0065
        L_0x0052:
            r7 = r9 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0065
            r7 = r26
            boolean r12 = r1.changed((java.lang.Object) r7)
            if (r12 == 0) goto L_0x0061
            r12 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r12 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r2 = r2 | r12
            goto L_0x0067
        L_0x0065:
            r7 = r26
        L_0x0067:
            r12 = r10 & 8
            if (r12 == 0) goto L_0x006e
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x006e:
            r13 = r9 & 3072(0xc00, float:4.305E-42)
            if (r13 != 0) goto L_0x0081
            r13 = r27
            boolean r14 = r1.changed((boolean) r13)
            if (r14 == 0) goto L_0x007d
            r14 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007d:
            r14 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r2 = r2 | r14
            goto L_0x0083
        L_0x0081:
            r13 = r27
        L_0x0083:
            r14 = r10 & 16
            if (r14 == 0) goto L_0x008a
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009e
        L_0x008a:
            r15 = r9 & 24576(0x6000, float:3.4438E-41)
            if (r15 != 0) goto L_0x009e
            r15 = r28
            boolean r16 = r1.changed((int) r15)
            if (r16 == 0) goto L_0x0099
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009b
        L_0x0099:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x009b:
            r2 = r2 | r16
            goto L_0x00a0
        L_0x009e:
            r15 = r28
        L_0x00a0:
            r16 = r10 & 32
            r17 = 196608(0x30000, float:2.75506E-40)
            if (r16 == 0) goto L_0x00ab
            r2 = r2 | r17
            r3 = r29
            goto L_0x00be
        L_0x00ab:
            r17 = r9 & r17
            r3 = r29
            if (r17 != 0) goto L_0x00be
            boolean r17 = r1.changed((int) r3)
            if (r17 == 0) goto L_0x00ba
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bc
        L_0x00ba:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00bc:
            r2 = r2 | r17
        L_0x00be:
            r17 = r10 & 64
            r19 = 1572864(0x180000, float:2.204052E-39)
            if (r17 == 0) goto L_0x00c9
            r2 = r2 | r19
            r0 = r30
            goto L_0x00dc
        L_0x00c9:
            r19 = r9 & r19
            r0 = r30
            if (r19 != 0) goto L_0x00dc
            boolean r20 = r1.changedInstance(r0)
            if (r20 == 0) goto L_0x00d8
            r20 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00da
        L_0x00d8:
            r20 = 524288(0x80000, float:7.34684E-40)
        L_0x00da:
            r2 = r2 | r20
        L_0x00dc:
            r0 = r10 & 128(0x80, float:1.794E-43)
            r20 = r0
            r21 = 12582912(0xc00000, float:1.7632415E-38)
            if (r20 == 0) goto L_0x00e7
            r2 = r2 | r21
            goto L_0x00f8
        L_0x00e7:
            r20 = r9 & r21
            if (r20 != 0) goto L_0x00f8
            boolean r20 = r1.changedInstance(r8)
            if (r20 == 0) goto L_0x00f4
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f6
        L_0x00f4:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f6:
            r2 = r2 | r20
        L_0x00f8:
            r20 = 4793491(0x492493, float:6.717112E-39)
            r0 = r2 & r20
            r3 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r3) goto L_0x0118
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x0109
            goto L_0x0118
        L_0x0109:
            r1.skipToGroupEnd()
            r6 = r29
            r21 = r1
            r3 = r7
            r4 = r13
            r7 = r30
        L_0x0114:
            r2 = r5
            r5 = r15
            goto L_0x0219
        L_0x0118:
            if (r4 == 0) goto L_0x011f
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r5 = r0
        L_0x011f:
            if (r6 == 0) goto L_0x0128
            androidx.compose.ui.text.TextStyle$Companion r0 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r0 = r0.getDefault()
            r7 = r0
        L_0x0128:
            if (r12 == 0) goto L_0x012b
            r13 = 1
        L_0x012b:
            if (r14 == 0) goto L_0x0134
            androidx.compose.ui.text.style.TextOverflow$Companion r3 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r3 = r3.m7037getClipgIe3tQ8()
            r15 = r3
        L_0x0134:
            if (r16 == 0) goto L_0x013a
            r3 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x013c
        L_0x013a:
            r3 = r29
        L_0x013c:
            if (r17 == 0) goto L_0x0143
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$1 r4 = androidx.compose.foundation.text.ClickableTextKt$ClickableText$1.INSTANCE
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            goto L_0x0145
        L_0x0143:
            r4 = r30
        L_0x0145:
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x0154
            r6 = -1
            java.lang.String r12 = "androidx.compose.foundation.text.ClickableText (ClickableText.kt:83)"
            r14 = -246609449(0xfffffffff14d09d7, float:-1.0153012E30)
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r2, r6, r12)
        L_0x0154:
            r6 = 1498074812(0x594acebc, float:3.56782826E15)
            java.lang.String r12 = "CC(remember):ClickableText.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r6, r12)
            java.lang.Object r6 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            r0 = 0
            if (r6 != r14) goto L_0x0171
            r14 = 2
            androidx.compose.runtime.MutableState r6 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r0, r14, r0)
            r1.updateRememberedValue(r6)
        L_0x0171:
            androidx.compose.runtime.MutableState r6 = (androidx.compose.runtime.MutableState) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.ui.Modifier$Companion r14 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r14 = (androidx.compose.ui.Modifier) r14
            r0 = 1498078432(0x594adce0, float:3.5688E15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r0, r12)
            r0 = 29360128(0x1c00000, float:7.052966E-38)
            r0 = r0 & r2
            r16 = 0
            r32 = r2
            r2 = 8388608(0x800000, float:1.17549435E-38)
            if (r0 != r2) goto L_0x018d
            r0 = 1
            goto L_0x018f
        L_0x018d:
            r0 = r16
        L_0x018f:
            java.lang.Object r2 = r1.rememberedValue()
            if (r0 != 0) goto L_0x019d
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r2 != r0) goto L_0x01a9
        L_0x019d:
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$pressIndicator$1$1 r0 = new androidx.compose.foundation.text.ClickableTextKt$ClickableText$pressIndicator$1$1
            r2 = 0
            r0.<init>(r6, r8, r2)
            r2 = r0
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r1.updateRememberedValue(r2)
        L_0x01a9:
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt.pointerInput((androidx.compose.ui.Modifier) r14, (java.lang.Object) r8, (kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r2)
            androidx.compose.ui.Modifier r0 = r5.then(r0)
            r2 = 1498091284(0x594b0f14, float:3.57224993E15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r2, r12)
            r2 = 3670016(0x380000, float:5.142788E-39)
            r12 = r32 & r2
            r14 = 1048576(0x100000, float:1.469368E-39)
            if (r12 != r14) goto L_0x01c6
            r16 = 1
        L_0x01c6:
            java.lang.Object r12 = r1.rememberedValue()
            if (r16 != 0) goto L_0x01d4
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r12 != r14) goto L_0x01de
        L_0x01d4:
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$2$1 r12 = new androidx.compose.foundation.text.ClickableTextKt$ClickableText$2$1
            r12.<init>(r6, r4)
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            r1.updateRememberedValue(r12)
        L_0x01de:
            r14 = r12
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r6 = 58254(0xe38e, float:8.1631E-41)
            r6 = r32 & r6
            r12 = 458752(0x70000, float:6.42848E-40)
            int r16 = r32 << 6
            r12 = r16 & r12
            r6 = r6 | r12
            int r12 = r32 << 3
            r2 = r2 & r12
            r22 = r6 | r2
            r23 = 896(0x380, float:1.256E-42)
            r18 = 0
            r19 = 0
            r20 = 0
            r12 = r0
            r21 = r1
            r17 = r3
            r16 = r13
            r13 = r7
            androidx.compose.foundation.text.BasicTextKt.m1164BasicTextRWo7tUw(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0211
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0211:
            r7 = r4
            r3 = r13
            r4 = r16
            r6 = r17
            goto L_0x0114
        L_0x0219:
            androidx.compose.runtime.ScopeUpdateScope r11 = r21.endRestartGroup()
            if (r11 == 0) goto L_0x022b
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$3 r0 = new androidx.compose.foundation.text.ClickableTextKt$ClickableText$3
            r1 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r11.updateScope(r0)
        L_0x022b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.ClickableTextKt.m1171ClickableText4YKlhWE(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, boolean, int, int, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:151:0x02ac  */
    /* JADX WARNING: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0135  */
    @kotlin.Deprecated(message = "Use Text or BasicText and pass an AnnotatedString that contains a LinkAnnotation")
    /* renamed from: ClickableText-03UYbkw  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1170ClickableText03UYbkw(androidx.compose.ui.text.AnnotatedString r25, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r26, androidx.compose.ui.Modifier r27, androidx.compose.ui.text.TextStyle r28, boolean r29, int r30, int r31, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r32, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r2 = r26
            r9 = r33
            r10 = r35
            r11 = r36
            r0 = 1020774372(0x3cd7c7e4, float:0.026340432)
            r1 = r34
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r3 = "C(ClickableText)P(8,3,1,7,6,5:c#ui.text.style.TextOverflow!1,4)163@7538L52,164@7616L24,171@7916L413,193@8556L76,186@8335L303:ClickableText.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = r11 & 1
            if (r3 == 0) goto L_0x001f
            r3 = r10 | 6
            r12 = r25
            goto L_0x0031
        L_0x001f:
            r3 = r10 & 6
            r12 = r25
            if (r3 != 0) goto L_0x0030
            boolean r3 = r1.changed((java.lang.Object) r12)
            if (r3 == 0) goto L_0x002d
            r3 = 4
            goto L_0x002e
        L_0x002d:
            r3 = 2
        L_0x002e:
            r3 = r3 | r10
            goto L_0x0031
        L_0x0030:
            r3 = r10
        L_0x0031:
            r5 = r11 & 2
            if (r5 == 0) goto L_0x0038
            r3 = r3 | 48
            goto L_0x0048
        L_0x0038:
            r5 = r10 & 48
            if (r5 != 0) goto L_0x0048
            boolean r5 = r1.changedInstance(r2)
            if (r5 == 0) goto L_0x0045
            r5 = 32
            goto L_0x0047
        L_0x0045:
            r5 = 16
        L_0x0047:
            r3 = r3 | r5
        L_0x0048:
            r5 = r11 & 4
            if (r5 == 0) goto L_0x004f
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r7 = r10 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0062
            r7 = r27
            boolean r8 = r1.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x005e
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r3 = r3 | r8
            goto L_0x0064
        L_0x0062:
            r7 = r27
        L_0x0064:
            r8 = r11 & 8
            if (r8 == 0) goto L_0x006b
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r13 = r10 & 3072(0xc00, float:4.305E-42)
            if (r13 != 0) goto L_0x007e
            r13 = r28
            boolean r14 = r1.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x007a
            r14 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r14 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r3 = r3 | r14
            goto L_0x0080
        L_0x007e:
            r13 = r28
        L_0x0080:
            r14 = r11 & 16
            if (r14 == 0) goto L_0x0087
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009b
        L_0x0087:
            r15 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r15 != 0) goto L_0x009b
            r15 = r29
            boolean r16 = r1.changed((boolean) r15)
            if (r16 == 0) goto L_0x0096
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r3 = r3 | r16
            goto L_0x009d
        L_0x009b:
            r15 = r29
        L_0x009d:
            r16 = r11 & 32
            r17 = 196608(0x30000, float:2.75506E-40)
            if (r16 == 0) goto L_0x00a8
            r3 = r3 | r17
            r6 = r30
            goto L_0x00bb
        L_0x00a8:
            r17 = r10 & r17
            r6 = r30
            if (r17 != 0) goto L_0x00bb
            boolean r17 = r1.changed((int) r6)
            if (r17 == 0) goto L_0x00b7
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b9
        L_0x00b7:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00b9:
            r3 = r3 | r17
        L_0x00bb:
            r17 = r11 & 64
            r18 = 1572864(0x180000, float:2.204052E-39)
            if (r17 == 0) goto L_0x00c6
            r3 = r3 | r18
            r4 = r31
            goto L_0x00d9
        L_0x00c6:
            r18 = r10 & r18
            r4 = r31
            if (r18 != 0) goto L_0x00d9
            boolean r19 = r1.changed((int) r4)
            if (r19 == 0) goto L_0x00d5
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d7
        L_0x00d5:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x00d7:
            r3 = r3 | r19
        L_0x00d9:
            r0 = r11 & 128(0x80, float:1.794E-43)
            r20 = r0
            r21 = 12582912(0xc00000, float:1.7632415E-38)
            if (r20 == 0) goto L_0x00e6
            r3 = r3 | r21
            r0 = r32
            goto L_0x00f9
        L_0x00e6:
            r21 = r10 & r21
            r0 = r32
            if (r21 != 0) goto L_0x00f9
            boolean r22 = r1.changedInstance(r0)
            if (r22 == 0) goto L_0x00f5
            r22 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f7
        L_0x00f5:
            r22 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f7:
            r3 = r3 | r22
        L_0x00f9:
            r0 = r11 & 256(0x100, float:3.59E-43)
            r22 = r0
            r23 = 100663296(0x6000000, float:2.4074124E-35)
            if (r22 == 0) goto L_0x0104
            r3 = r3 | r23
            goto L_0x0115
        L_0x0104:
            r22 = r10 & r23
            if (r22 != 0) goto L_0x0115
            boolean r22 = r1.changedInstance(r9)
            if (r22 == 0) goto L_0x0111
            r22 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0113
        L_0x0111:
            r22 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0113:
            r3 = r3 | r22
        L_0x0115:
            r22 = 38347923(0x2492493, float:1.4777644E-37)
            r0 = r3 & r22
            r2 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r2) goto L_0x0135
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x0126
            goto L_0x0135
        L_0x0126:
            r1.skipToGroupEnd()
            r0 = r26
            r8 = r32
            r22 = r1
            r3 = r7
            r5 = r15
            r7 = r4
            r4 = r13
            goto L_0x02a6
        L_0x0135:
            if (r5 == 0) goto L_0x013c
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r7 = r0
        L_0x013c:
            if (r8 == 0) goto L_0x0145
            androidx.compose.ui.text.TextStyle$Companion r0 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r0 = r0.getDefault()
            r13 = r0
        L_0x0145:
            if (r14 == 0) goto L_0x0148
            r15 = 1
        L_0x0148:
            if (r16 == 0) goto L_0x0153
            androidx.compose.ui.text.style.TextOverflow$Companion r2 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r2 = r2.m7037getClipgIe3tQ8()
            r16 = r2
            goto L_0x0155
        L_0x0153:
            r16 = r6
        L_0x0155:
            if (r17 == 0) goto L_0x015b
            r2 = 2147483647(0x7fffffff, float:NaN)
            r4 = r2
        L_0x015b:
            if (r20 == 0) goto L_0x0162
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$4 r2 = androidx.compose.foundation.text.ClickableTextKt$ClickableText$4.INSTANCE
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            goto L_0x0164
        L_0x0162:
            r2 = r32
        L_0x0164:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0173
            r5 = -1
            java.lang.String r6 = "androidx.compose.foundation.text.ClickableText (ClickableText.kt:162)"
            r8 = 1020774372(0x3cd7c7e4, float:0.026340432)
            androidx.compose.runtime.ComposerKt.traceEventStart(r8, r3, r5, r6)
        L_0x0173:
            r5 = 1498188796(0x594c8bfc, float:3.59842561E15)
            java.lang.String r6 = "CC(remember):ClickableText.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r5, r6)
            java.lang.Object r5 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r5 != r8) goto L_0x0190
            r5 = 0
            r8 = 2
            androidx.compose.runtime.MutableState r5 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r5, r5, r8, r5)
            r1.updateRememberedValue(r5)
        L_0x0190:
            androidx.compose.runtime.MutableState r5 = (androidx.compose.runtime.MutableState) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r8 = 773894976(0x2e20b340, float:3.6538994E-11)
            java.lang.String r14 = "CC(rememberCoroutineScope)482@20332L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r8, r14)
            r8 = -954367824(0xffffffffc71d80b0, float:-40320.688)
            java.lang.String r14 = "CC(remember):Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r8, r14)
            java.lang.Object r8 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r8 != r14) goto L_0x01c2
            kotlin.coroutines.EmptyCoroutineContext r8 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8
            kotlinx.coroutines.CoroutineScope r8 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r8, r1)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r14 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r14.<init>(r8)
            r1.updateRememberedValue(r14)
            r8 = r14
        L_0x01c2:
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r8 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            kotlinx.coroutines.CoroutineScope r8 = r8.getCoroutineScope()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.ui.Modifier$Companion r14 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r14 = (androidx.compose.ui.Modifier) r14
            r0 = 1498201253(0x594cbca5, float:3.60176951E15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r0, r6)
            boolean r0 = r1.changedInstance(r8)
            r27 = r0
            r0 = r3 & 112(0x70, float:1.57E-43)
            r18 = 0
            r19 = r3
            r3 = 32
            if (r0 != r3) goto L_0x01ea
            r0 = 1
            goto L_0x01ec
        L_0x01ea:
            r0 = r18
        L_0x01ec:
            r0 = r27 | r0
            r3 = 234881024(0xe000000, float:1.5777218E-30)
            r3 = r19 & r3
            r27 = r0
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            if (r3 != r0) goto L_0x01fa
            r0 = 1
            goto L_0x01fc
        L_0x01fa:
            r0 = r18
        L_0x01fc:
            r0 = r27 | r0
            java.lang.Object r3 = r1.rememberedValue()
            if (r0 != 0) goto L_0x0210
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r3 != r0) goto L_0x020d
            goto L_0x0210
        L_0x020d:
            r0 = r26
            goto L_0x022b
        L_0x0210:
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$pointerInputModifier$1$1 r0 = new androidx.compose.foundation.text.ClickableTextKt$ClickableText$pointerInputModifier$1$1
            r3 = 0
            r29 = r26
            r27 = r0
            r32 = r3
            r30 = r5
            r28 = r8
            r31 = r9
            r27.<init>(r28, r29, r30, r31, r32)
            r3 = r27
            r0 = r29
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r1.updateRememberedValue(r3)
        L_0x022b:
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt.pointerInput(r14, r9, r0, r3)
            androidx.compose.ui.Modifier r3 = r7.then(r3)
            r8 = 1498221396(0x594d0b54, float:3.6071766E15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r8, r6)
            r6 = 29360128(0x1c00000, float:7.052966E-38)
            r6 = r19 & r6
            r8 = 8388608(0x800000, float:1.17549435E-38)
            if (r6 != r8) goto L_0x0249
            r17 = 1
            goto L_0x024b
        L_0x0249:
            r17 = r18
        L_0x024b:
            java.lang.Object r6 = r1.rememberedValue()
            if (r17 != 0) goto L_0x0259
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r6 != r8) goto L_0x0263
        L_0x0259:
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$5$1 r6 = new androidx.compose.foundation.text.ClickableTextKt$ClickableText$5$1
            r6.<init>(r5, r2)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r1.updateRememberedValue(r6)
        L_0x0263:
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r5 = r19 & 14
            int r8 = r19 >> 3
            r14 = r8 & 896(0x380, float:1.256E-42)
            r5 = r5 | r14
            r14 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r14
            r5 = r5 | r8
            int r8 = r19 << 3
            r14 = 458752(0x70000, float:6.42848E-40)
            r8 = r8 & r14
            r5 = r5 | r8
            r8 = 3670016(0x380000, float:5.142788E-39)
            r8 = r19 & r8
            r23 = r5 | r8
            r24 = 896(0x380, float:1.256E-42)
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = r1
            r18 = r4
            r14 = r13
            r17 = r15
            r13 = r3
            r15 = r6
            androidx.compose.foundation.text.BasicTextKt.m1164BasicTextRWo7tUw(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x029d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x029d:
            r8 = r2
            r3 = r7
            r4 = r14
            r6 = r16
            r5 = r17
            r7 = r18
        L_0x02a6:
            androidx.compose.runtime.ScopeUpdateScope r12 = r22.endRestartGroup()
            if (r12 == 0) goto L_0x02ba
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$6 r0 = new androidx.compose.foundation.text.ClickableTextKt$ClickableText$6
            r1 = r25
            r2 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x02ba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.ClickableTextKt.m1170ClickableText03UYbkw(androidx.compose.ui.text.AnnotatedString, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, boolean, int, int, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final Integer ClickableText_03UYbkw$getOffset(MutableState<TextLayoutResult> mutableState, long j) {
        MultiParagraph multiParagraph;
        TextLayoutResult value = mutableState.getValue();
        if (!(value == null || (multiParagraph = value.getMultiParagraph()) == null)) {
            if (!m1172containsWithinBoundsUv8p0NA(multiParagraph, j)) {
                multiParagraph = null;
            }
            if (multiParagraph != null) {
                return Integer.valueOf(multiParagraph.m6423getOffsetForPositionk4lQ0M(j));
            }
        }
        return null;
    }

    /* renamed from: containsWithinBounds-Uv8p0NA  reason: not valid java name */
    private static final boolean m1172containsWithinBoundsUv8p0NA(MultiParagraph multiParagraph, long j) {
        float r0 = Offset.m3987getXimpl(j);
        float r3 = Offset.m3988getYimpl(j);
        return r0 > 0.0f && r3 >= 0.0f && r0 <= multiParagraph.getWidth() && r3 <= multiParagraph.getHeight();
    }
}
