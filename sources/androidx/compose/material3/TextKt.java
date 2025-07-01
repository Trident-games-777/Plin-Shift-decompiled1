package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\u001aæ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020&2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001aÜ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001aÆ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020*2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001aÒ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020*2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020&2\u0016\b\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00106\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00067"}, d2 = {"LocalTextStyle", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/text/TextStyle;", "getLocalTextStyle", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ProvideTextStyle", "", "value", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Text", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "style", "Text-IbK3jfQ", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text--4IGK_g", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text-fLXpl1I", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Text.kt */
public final class TextKt {
    private static final ProvidableCompositionLocal<TextStyle> LocalTextStyle = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.structuralEqualityPolicy(), TextKt$LocalTextStyle$1.INSTANCE);

    /* JADX WARNING: Removed duplicated region for block: B:109:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0237  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x0454  */
    /* JADX WARNING: Removed duplicated region for block: B:259:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0141  */
    /* renamed from: Text--4IGK_g  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2692Text4IGK_g(java.lang.String r67, androidx.compose.ui.Modifier r68, long r69, long r71, androidx.compose.ui.text.font.FontStyle r73, androidx.compose.ui.text.font.FontWeight r74, androidx.compose.ui.text.font.FontFamily r75, long r76, androidx.compose.ui.text.style.TextDecoration r78, androidx.compose.ui.text.style.TextAlign r79, long r80, int r82, boolean r83, int r84, int r85, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r86, androidx.compose.ui.text.TextStyle r87, androidx.compose.runtime.Composer r88, int r89, int r90, int r91) {
        /*
            r0 = r89
            r1 = r90
            r2 = r91
            r3 = -2055108902(0xffffffff858186da, float:-1.2180638E-35)
            r4 = r88
            androidx.compose.runtime.Composer r4 = r4.startRestartGroup(r3)
            java.lang.String r5 = "C(Text)P(14,9,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,5:c#ui.unit.TextUnit,16,15:c#ui.text.style.TextAlign,6:c#ui.unit.TextUnit,11:c#ui.text.style.TextOverflow,12)108@5620L7,113@5732L530:Text.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r5)
            r5 = r2 & 1
            if (r5 == 0) goto L_0x001e
            r5 = r0 | 6
            r8 = r5
            r5 = r67
            goto L_0x0032
        L_0x001e:
            r5 = r0 & 6
            if (r5 != 0) goto L_0x002f
            r5 = r67
            boolean r8 = r4.changed((java.lang.Object) r5)
            if (r8 == 0) goto L_0x002c
            r8 = 4
            goto L_0x002d
        L_0x002c:
            r8 = 2
        L_0x002d:
            r8 = r8 | r0
            goto L_0x0032
        L_0x002f:
            r5 = r67
            r8 = r0
        L_0x0032:
            r9 = r2 & 2
            if (r9 == 0) goto L_0x0039
            r8 = r8 | 48
            goto L_0x004c
        L_0x0039:
            r12 = r0 & 48
            if (r12 != 0) goto L_0x004c
            r12 = r68
            boolean r13 = r4.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x0048
            r13 = 32
            goto L_0x004a
        L_0x0048:
            r13 = 16
        L_0x004a:
            r8 = r8 | r13
            goto L_0x004e
        L_0x004c:
            r12 = r68
        L_0x004e:
            r13 = r2 & 4
            if (r13 == 0) goto L_0x0058
            r8 = r8 | 384(0x180, float:5.38E-43)
            r6 = r8
            r7 = r69
            goto L_0x006f
        L_0x0058:
            r6 = r0 & 384(0x180, float:5.38E-43)
            r16 = r8
            r7 = r69
            if (r6 != 0) goto L_0x006d
            boolean r17 = r4.changed((long) r7)
            if (r17 == 0) goto L_0x0069
            r17 = 256(0x100, float:3.59E-43)
            goto L_0x006b
        L_0x0069:
            r17 = 128(0x80, float:1.794E-43)
        L_0x006b:
            r16 = r16 | r17
        L_0x006d:
            r6 = r16
        L_0x006f:
            r16 = r2 & 8
            r18 = 2048(0x800, float:2.87E-42)
            r19 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x007c
            r6 = r6 | 3072(0xc00, float:4.305E-42)
            r11 = r71
            goto L_0x008f
        L_0x007c:
            r10 = r0 & 3072(0xc00, float:4.305E-42)
            r11 = r71
            if (r10 != 0) goto L_0x008f
            boolean r21 = r4.changed((long) r11)
            if (r21 == 0) goto L_0x008b
            r21 = r18
            goto L_0x008d
        L_0x008b:
            r21 = r19
        L_0x008d:
            r6 = r6 | r21
        L_0x008f:
            r21 = r2 & 16
            r22 = 16384(0x4000, float:2.2959E-41)
            r23 = 8192(0x2000, float:1.14794E-41)
            if (r21 == 0) goto L_0x009a
            r6 = r6 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00ae
        L_0x009a:
            r10 = r0 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x00ae
            r10 = r73
            boolean r25 = r4.changed((java.lang.Object) r10)
            if (r25 == 0) goto L_0x00a9
            r25 = r22
            goto L_0x00ab
        L_0x00a9:
            r25 = r23
        L_0x00ab:
            r6 = r6 | r25
            goto L_0x00b0
        L_0x00ae:
            r10 = r73
        L_0x00b0:
            r25 = r2 & 32
            r26 = 131072(0x20000, float:1.83671E-40)
            r27 = 196608(0x30000, float:2.75506E-40)
            r28 = 65536(0x10000, float:9.18355E-41)
            if (r25 == 0) goto L_0x00bf
            r6 = r6 | r27
            r14 = r74
            goto L_0x00d2
        L_0x00bf:
            r29 = r0 & r27
            r14 = r74
            if (r29 != 0) goto L_0x00d2
            boolean r30 = r4.changed((java.lang.Object) r14)
            if (r30 == 0) goto L_0x00ce
            r30 = r26
            goto L_0x00d0
        L_0x00ce:
            r30 = r28
        L_0x00d0:
            r6 = r6 | r30
        L_0x00d2:
            r30 = r2 & 64
            r31 = 1572864(0x180000, float:2.204052E-39)
            if (r30 == 0) goto L_0x00dd
            r6 = r6 | r31
            r15 = r75
            goto L_0x00f0
        L_0x00dd:
            r32 = r0 & r31
            r15 = r75
            if (r32 != 0) goto L_0x00f0
            boolean r33 = r4.changed((java.lang.Object) r15)
            if (r33 == 0) goto L_0x00ec
            r33 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ee
        L_0x00ec:
            r33 = 524288(0x80000, float:7.34684E-40)
        L_0x00ee:
            r6 = r6 | r33
        L_0x00f0:
            r3 = r2 & 128(0x80, float:1.794E-43)
            r34 = 12582912(0xc00000, float:1.7632415E-38)
            if (r3 == 0) goto L_0x00f9
            r6 = r6 | r34
            goto L_0x010f
        L_0x00f9:
            r34 = r0 & r34
            if (r34 != 0) goto L_0x010f
            r34 = r6
            r5 = r76
            boolean r35 = r4.changed((long) r5)
            if (r35 == 0) goto L_0x010a
            r35 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x010c
        L_0x010a:
            r35 = 4194304(0x400000, float:5.877472E-39)
        L_0x010c:
            r34 = r34 | r35
            goto L_0x0113
        L_0x010f:
            r34 = r6
            r5 = r76
        L_0x0113:
            r0 = r2 & 256(0x100, float:3.59E-43)
            r35 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x011c
            r34 = r34 | r35
            goto L_0x0132
        L_0x011c:
            r35 = r89 & r35
            if (r35 != 0) goto L_0x0132
            r35 = r0
            r0 = r78
            boolean r36 = r4.changed((java.lang.Object) r0)
            if (r36 == 0) goto L_0x012d
            r36 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x012f
        L_0x012d:
            r36 = 33554432(0x2000000, float:9.403955E-38)
        L_0x012f:
            r34 = r34 | r36
            goto L_0x0136
        L_0x0132:
            r35 = r0
            r0 = r78
        L_0x0136:
            r0 = r2 & 512(0x200, float:7.175E-43)
            r36 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x0141
            r34 = r34 | r36
            r36 = r0
            goto L_0x015b
        L_0x0141:
            r36 = r89 & r36
            if (r36 != 0) goto L_0x0157
            r36 = r0
            r0 = r79
            boolean r37 = r4.changed((java.lang.Object) r0)
            if (r37 == 0) goto L_0x0152
            r37 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0154
        L_0x0152:
            r37 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0154:
            r34 = r34 | r37
            goto L_0x015b
        L_0x0157:
            r36 = r0
            r0 = r79
        L_0x015b:
            r0 = r34
            r34 = r3
            r3 = r2 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0168
            r17 = r1 | 6
            r5 = r80
            goto L_0x017e
        L_0x0168:
            r37 = r1 & 6
            r5 = r80
            if (r37 != 0) goto L_0x017c
            boolean r37 = r4.changed((long) r5)
            if (r37 == 0) goto L_0x0177
            r17 = 4
            goto L_0x0179
        L_0x0177:
            r17 = 2
        L_0x0179:
            r17 = r1 | r17
            goto L_0x017e
        L_0x017c:
            r17 = r1
        L_0x017e:
            r37 = r3
            r3 = r2 & 2048(0x800, float:2.87E-42)
            if (r3 == 0) goto L_0x0189
            r17 = r17 | 48
            r38 = r3
            goto L_0x01a3
        L_0x0189:
            r38 = r1 & 48
            if (r38 != 0) goto L_0x019f
            r38 = r3
            r3 = r82
            boolean r39 = r4.changed((int) r3)
            if (r39 == 0) goto L_0x019a
            r24 = 32
            goto L_0x019c
        L_0x019a:
            r24 = 16
        L_0x019c:
            r17 = r17 | r24
            goto L_0x01a3
        L_0x019f:
            r38 = r3
            r3 = r82
        L_0x01a3:
            r3 = r17
            r5 = r2 & 4096(0x1000, float:5.74E-42)
            if (r5 == 0) goto L_0x01ac
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x01c0
        L_0x01ac:
            r6 = r1 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x01c0
            r6 = r83
            boolean r17 = r4.changed((boolean) r6)
            if (r17 == 0) goto L_0x01bb
            r29 = 256(0x100, float:3.59E-43)
            goto L_0x01bd
        L_0x01bb:
            r29 = 128(0x80, float:1.794E-43)
        L_0x01bd:
            r3 = r3 | r29
            goto L_0x01c2
        L_0x01c0:
            r6 = r83
        L_0x01c2:
            r17 = r5
            r5 = r2 & 8192(0x2000, float:1.14794E-41)
            if (r5 == 0) goto L_0x01cb
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x01e5
        L_0x01cb:
            r20 = r3
            r3 = r1 & 3072(0xc00, float:4.305E-42)
            if (r3 != 0) goto L_0x01e1
            r3 = r84
            boolean r24 = r4.changed((int) r3)
            if (r24 == 0) goto L_0x01da
            goto L_0x01dc
        L_0x01da:
            r18 = r19
        L_0x01dc:
            r18 = r20 | r18
            r3 = r18
            goto L_0x01e5
        L_0x01e1:
            r3 = r84
            r3 = r20
        L_0x01e5:
            r18 = r5
            r5 = r2 & 16384(0x4000, float:2.2959E-41)
            if (r5 == 0) goto L_0x01ee
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0200
        L_0x01ee:
            r2 = r1 & 24576(0x6000, float:3.4438E-41)
            if (r2 != 0) goto L_0x0200
            r2 = r85
            boolean r19 = r4.changed((int) r2)
            if (r19 == 0) goto L_0x01fb
            goto L_0x01fd
        L_0x01fb:
            r22 = r23
        L_0x01fd:
            r3 = r3 | r22
            goto L_0x0202
        L_0x0200:
            r2 = r85
        L_0x0202:
            r19 = 32768(0x8000, float:4.5918E-41)
            r19 = r91 & r19
            if (r19 == 0) goto L_0x020e
            r3 = r3 | r27
            r1 = r86
            goto L_0x021f
        L_0x020e:
            r20 = r1 & r27
            r1 = r86
            if (r20 != 0) goto L_0x021f
            boolean r20 = r4.changedInstance(r1)
            if (r20 == 0) goto L_0x021b
            goto L_0x021d
        L_0x021b:
            r26 = r28
        L_0x021d:
            r3 = r3 | r26
        L_0x021f:
            r20 = r90 & r31
            if (r20 != 0) goto L_0x0237
            r20 = r91 & r28
            r1 = r87
            if (r20 != 0) goto L_0x0232
            boolean r20 = r4.changed((java.lang.Object) r1)
            if (r20 == 0) goto L_0x0232
            r20 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0234
        L_0x0232:
            r20 = 524288(0x80000, float:7.34684E-40)
        L_0x0234:
            r3 = r3 | r20
            goto L_0x0239
        L_0x0237:
            r1 = r87
        L_0x0239:
            r20 = 306783379(0x12492493, float:6.34695E-28)
            r1 = r0 & r20
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r2) goto L_0x0274
            r1 = 599187(0x92493, float:8.3964E-40)
            r1 = r1 & r3
            r2 = 599186(0x92492, float:8.39638E-40)
            if (r1 != r2) goto L_0x0274
            boolean r1 = r4.getSkipping()
            if (r1 != 0) goto L_0x0253
            goto L_0x0274
        L_0x0253:
            r4.skipToGroupEnd()
            r2 = r68
            r13 = r79
            r16 = r82
            r18 = r84
            r19 = r85
            r20 = r86
            r21 = r87
            r0 = r4
            r17 = r6
            r3 = r7
            r7 = r10
            r5 = r11
            r8 = r14
            r9 = r15
            r10 = r76
            r12 = r78
            r14 = r80
            goto L_0x044e
        L_0x0274:
            r4.startDefaults()
            r1 = r89 & 1
            if (r1 == 0) goto L_0x02ab
            boolean r1 = r4.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0282
            goto L_0x02ab
        L_0x0282:
            r4.skipToGroupEnd()
            r1 = r91 & r28
            if (r1 == 0) goto L_0x028d
            r1 = -3670017(0xffffffffffc7ffff, float:NaN)
            r3 = r3 & r1
        L_0x028d:
            r1 = r68
            r44 = r76
            r51 = r78
            r13 = r79
            r56 = r80
            r16 = r82
            r17 = r84
            r24 = r85
            r2 = r86
            r34 = r87
            r40 = r10
            r37 = r11
            r39 = r14
            r42 = r15
            goto L_0x035d
        L_0x02ab:
            if (r9 == 0) goto L_0x02b2
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x02b4
        L_0x02b2:
            r1 = r68
        L_0x02b4:
            if (r13 == 0) goto L_0x02bc
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            long r7 = r2.m4275getUnspecified0d7_KjU()
        L_0x02bc:
            if (r16 == 0) goto L_0x02c4
            androidx.compose.ui.unit.TextUnit$Companion r2 = androidx.compose.ui.unit.TextUnit.Companion
            long r11 = r2.m7317getUnspecifiedXSAIIZE()
        L_0x02c4:
            r2 = 0
            if (r21 == 0) goto L_0x02c8
            r10 = r2
        L_0x02c8:
            if (r25 == 0) goto L_0x02cb
            r14 = r2
        L_0x02cb:
            if (r30 == 0) goto L_0x02ce
            r15 = r2
        L_0x02ce:
            if (r34 == 0) goto L_0x02d7
            androidx.compose.ui.unit.TextUnit$Companion r9 = androidx.compose.ui.unit.TextUnit.Companion
            long r20 = r9.m7317getUnspecifiedXSAIIZE()
            goto L_0x02d9
        L_0x02d7:
            r20 = r76
        L_0x02d9:
            if (r35 == 0) goto L_0x02dd
            r9 = r2
            goto L_0x02df
        L_0x02dd:
            r9 = r78
        L_0x02df:
            if (r36 == 0) goto L_0x02e3
            r13 = r2
            goto L_0x02e5
        L_0x02e3:
            r13 = r79
        L_0x02e5:
            if (r37 == 0) goto L_0x02ee
            androidx.compose.ui.unit.TextUnit$Companion r16 = androidx.compose.ui.unit.TextUnit.Companion
            long r22 = r16.m7317getUnspecifiedXSAIIZE()
            goto L_0x02f0
        L_0x02ee:
            r22 = r80
        L_0x02f0:
            if (r38 == 0) goto L_0x02f9
            androidx.compose.ui.text.style.TextOverflow$Companion r16 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r16 = r16.m7037getClipgIe3tQ8()
            goto L_0x02fb
        L_0x02f9:
            r16 = r82
        L_0x02fb:
            r24 = 1
            if (r17 == 0) goto L_0x0301
            r6 = r24
        L_0x0301:
            if (r18 == 0) goto L_0x0307
            r17 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0309
        L_0x0307:
            r17 = r84
        L_0x0309:
            if (r5 == 0) goto L_0x030c
            goto L_0x030e
        L_0x030c:
            r24 = r85
        L_0x030e:
            if (r19 == 0) goto L_0x0311
            goto L_0x0313
        L_0x0311:
            r2 = r86
        L_0x0313:
            r5 = r91 & r28
            if (r5 == 0) goto L_0x0349
            androidx.compose.runtime.ProvidableCompositionLocal<androidx.compose.ui.text.TextStyle> r5 = LocalTextStyle
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r68 = r1
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            r69 = r2
            java.lang.String r2 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r1, r2)
            java.lang.Object r1 = r4.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.text.TextStyle r1 = (androidx.compose.ui.text.TextStyle) r1
            r2 = -3670017(0xffffffffffc7ffff, float:NaN)
            r3 = r3 & r2
            r2 = r69
            r34 = r1
            r51 = r9
            r40 = r10
            r37 = r11
            r39 = r14
            r42 = r15
            r44 = r20
            r56 = r22
            r1 = r68
            goto L_0x035d
        L_0x0349:
            r68 = r1
            r69 = r2
            r34 = r87
            r51 = r9
            r40 = r10
            r37 = r11
            r39 = r14
            r42 = r15
            r44 = r20
            r56 = r22
        L_0x035d:
            r4.endDefaults()
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x036e
            java.lang.String r5 = "androidx.compose.material3.Text (Text.kt:109)"
            r9 = -2055108902(0xffffffff858186da, float:-1.2180638E-35)
            androidx.compose.runtime.ComposerKt.traceEventStart(r9, r0, r3, r5)
        L_0x036e:
            r5 = -1827892941(0xffffffff930c9133, float:-1.7742073E-27)
            r4.startReplaceGroup(r5)
            java.lang.String r5 = ""
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r5)
            r9 = 16
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 == 0) goto L_0x0382
            r35 = r7
            goto L_0x03b8
        L_0x0382:
            r5 = -1827892168(0xffffffff930c9438, float:-1.7743562E-27)
            r4.startReplaceGroup(r5)
            java.lang.String r5 = "*111@5715L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r5)
            long r9 = r34.m6594getColor0d7_KjU()
            r11 = 16
            int r5 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r5 == 0) goto L_0x0398
            goto L_0x03b3
        L_0x0398:
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.material3.ContentColorKt.getLocalContentColor()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r10 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r9, r10)
            java.lang.Object r5 = r4.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.graphics.Color r5 = (androidx.compose.ui.graphics.Color) r5
            long r9 = r5.m4249unboximpl()
        L_0x03b3:
            r4.endReplaceGroup()
            r35 = r9
        L_0x03b8:
            r4.endReplaceGroup()
            if (r13 == 0) goto L_0x03c2
            int r5 = r13.m6985unboximpl()
            goto L_0x03c8
        L_0x03c2:
            androidx.compose.ui.text.style.TextAlign$Companion r5 = androidx.compose.ui.text.style.TextAlign.Companion
            int r5 = r5.m6992getUnspecifiede0LSkKk()
        L_0x03c8:
            r54 = r5
            r64 = 16609104(0xfd6f50, float:2.3274312E-38)
            r65 = 0
            r41 = 0
            r43 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r52 = 0
            r53 = 0
            r55 = 0
            r58 = 0
            r59 = 0
            r60 = 0
            r61 = 0
            r62 = 0
            r63 = 0
            androidx.compose.ui.text.TextStyle r5 = androidx.compose.ui.text.TextStyle.m6584mergedA7vx0o$default(r34, r35, r37, r39, r40, r41, r42, r43, r44, r46, r47, r48, r49, r51, r52, r53, r54, r55, r56, r58, r59, r60, r61, r62, r63, r64, r65)
            r0 = r0 & 126(0x7e, float:1.77E-43)
            int r9 = r3 >> 6
            r9 = r9 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r9
            int r3 = r3 << 9
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r3
            r0 = r0 | r9
            r9 = 458752(0x70000, float:6.42848E-40)
            r9 = r9 & r3
            r0 = r0 | r9
            r9 = 3670016(0x380000, float:5.142788E-39)
            r9 = r9 & r3
            r0 = r0 | r9
            r9 = 29360128(0x1c00000, float:7.052966E-38)
            r3 = r3 & r9
            r0 = r0 | r3
            r3 = 256(0x100, float:3.59E-43)
            r9 = 0
            r68 = r67
            r78 = r0
            r69 = r1
            r71 = r2
            r79 = r3
            r77 = r4
            r70 = r5
            r73 = r6
            r76 = r9
            r72 = r16
            r74 = r17
            r75 = r24
            androidx.compose.foundation.text.BasicTextKt.m1166BasicTextVhcvRP8((java.lang.String) r68, (androidx.compose.ui.Modifier) r69, (androidx.compose.ui.text.TextStyle) r70, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r71, (int) r72, (boolean) r73, (int) r74, (int) r75, (androidx.compose.ui.graphics.ColorProducer) r76, (androidx.compose.runtime.Composer) r77, (int) r78, (int) r79)
            r0 = r77
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0434
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0434:
            r20 = r2
            r3 = r7
            r18 = r17
            r19 = r24
            r21 = r34
            r8 = r39
            r7 = r40
            r9 = r42
            r10 = r44
            r12 = r51
            r14 = r56
            r2 = r1
            r17 = r6
            r5 = r37
        L_0x044e:
            androidx.compose.runtime.ScopeUpdateScope r0 = r0.endRestartGroup()
            if (r0 == 0) goto L_0x046b
            r1 = r0
            androidx.compose.material3.TextKt$Text$1 r0 = new androidx.compose.material3.TextKt$Text$1
            r22 = r89
            r23 = r90
            r24 = r91
            r66 = r1
            r1 = r67
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r66
            r1.updateScope(r0)
        L_0x046b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextKt.m2692Text4IGK_g(java.lang.String, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, int, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0254  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x039a  */
    /* JADX WARNING: Removed duplicated region for block: B:236:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x013f  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* renamed from: Text-fLXpl1I  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void m2694TextfLXpl1I(java.lang.String r41, androidx.compose.ui.Modifier r42, long r43, long r45, androidx.compose.ui.text.font.FontStyle r47, androidx.compose.ui.text.font.FontWeight r48, androidx.compose.ui.text.font.FontFamily r49, long r50, androidx.compose.ui.text.style.TextDecoration r52, androidx.compose.ui.text.style.TextAlign r53, long r54, int r56, boolean r57, int r58, kotlin.jvm.functions.Function1 r59, androidx.compose.ui.text.TextStyle r60, androidx.compose.runtime.Composer r61, int r62, int r63, int r64) {
        /*
            r0 = r62
            r1 = r63
            r2 = r64
            r3 = 1968784669(0x7559451d, float:2.7542241E32)
            r4 = r61
            androidx.compose.runtime.Composer r4 = r4.startRestartGroup(r3)
            java.lang.String r5 = "C(Text)P(13,8,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,5:c#ui.unit.TextUnit,15,14:c#ui.text.style.TextAlign,6:c#ui.unit.TextUnit,10:c#ui.text.style.TextOverflow,11)156@7042L7,158@7058L322:Text.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r5)
            r5 = r2 & 1
            if (r5 == 0) goto L_0x001e
            r5 = r0 | 6
            r8 = r5
            r5 = r41
            goto L_0x0032
        L_0x001e:
            r5 = r0 & 6
            if (r5 != 0) goto L_0x002f
            r5 = r41
            boolean r8 = r4.changed((java.lang.Object) r5)
            if (r8 == 0) goto L_0x002c
            r8 = 4
            goto L_0x002d
        L_0x002c:
            r8 = 2
        L_0x002d:
            r8 = r8 | r0
            goto L_0x0032
        L_0x002f:
            r5 = r41
            r8 = r0
        L_0x0032:
            r9 = r2 & 2
            if (r9 == 0) goto L_0x0039
            r8 = r8 | 48
            goto L_0x004c
        L_0x0039:
            r12 = r0 & 48
            if (r12 != 0) goto L_0x004c
            r12 = r42
            boolean r13 = r4.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x0048
            r13 = 32
            goto L_0x004a
        L_0x0048:
            r13 = 16
        L_0x004a:
            r8 = r8 | r13
            goto L_0x004e
        L_0x004c:
            r12 = r42
        L_0x004e:
            r13 = r2 & 4
            if (r13 == 0) goto L_0x0058
            r8 = r8 | 384(0x180, float:5.38E-43)
            r6 = r8
            r7 = r43
            goto L_0x006f
        L_0x0058:
            r6 = r0 & 384(0x180, float:5.38E-43)
            r16 = r8
            r7 = r43
            if (r6 != 0) goto L_0x006d
            boolean r17 = r4.changed((long) r7)
            if (r17 == 0) goto L_0x0069
            r17 = 256(0x100, float:3.59E-43)
            goto L_0x006b
        L_0x0069:
            r17 = 128(0x80, float:1.794E-43)
        L_0x006b:
            r16 = r16 | r17
        L_0x006d:
            r6 = r16
        L_0x006f:
            r16 = r2 & 8
            r18 = 2048(0x800, float:2.87E-42)
            r19 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x007c
            r6 = r6 | 3072(0xc00, float:4.305E-42)
            r11 = r45
            goto L_0x008f
        L_0x007c:
            r10 = r0 & 3072(0xc00, float:4.305E-42)
            r11 = r45
            if (r10 != 0) goto L_0x008f
            boolean r21 = r4.changed((long) r11)
            if (r21 == 0) goto L_0x008b
            r21 = r18
            goto L_0x008d
        L_0x008b:
            r21 = r19
        L_0x008d:
            r6 = r6 | r21
        L_0x008f:
            r21 = r2 & 16
            r22 = 16384(0x4000, float:2.2959E-41)
            r23 = 8192(0x2000, float:1.14794E-41)
            if (r21 == 0) goto L_0x009a
            r6 = r6 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00ae
        L_0x009a:
            r10 = r0 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x00ae
            r10 = r47
            boolean r25 = r4.changed((java.lang.Object) r10)
            if (r25 == 0) goto L_0x00a9
            r25 = r22
            goto L_0x00ab
        L_0x00a9:
            r25 = r23
        L_0x00ab:
            r6 = r6 | r25
            goto L_0x00b0
        L_0x00ae:
            r10 = r47
        L_0x00b0:
            r25 = r2 & 32
            r26 = 65536(0x10000, float:9.18355E-41)
            r27 = 196608(0x30000, float:2.75506E-40)
            if (r25 == 0) goto L_0x00bd
            r6 = r6 | r27
            r14 = r48
            goto L_0x00d0
        L_0x00bd:
            r28 = r0 & r27
            r14 = r48
            if (r28 != 0) goto L_0x00d0
            boolean r29 = r4.changed((java.lang.Object) r14)
            if (r29 == 0) goto L_0x00cc
            r29 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ce
        L_0x00cc:
            r29 = r26
        L_0x00ce:
            r6 = r6 | r29
        L_0x00d0:
            r29 = r2 & 64
            r30 = 1572864(0x180000, float:2.204052E-39)
            if (r29 == 0) goto L_0x00db
            r6 = r6 | r30
            r15 = r49
            goto L_0x00ee
        L_0x00db:
            r30 = r0 & r30
            r15 = r49
            if (r30 != 0) goto L_0x00ee
            boolean r31 = r4.changed((java.lang.Object) r15)
            if (r31 == 0) goto L_0x00ea
            r31 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ec
        L_0x00ea:
            r31 = 524288(0x80000, float:7.34684E-40)
        L_0x00ec:
            r6 = r6 | r31
        L_0x00ee:
            r3 = r2 & 128(0x80, float:1.794E-43)
            r32 = 12582912(0xc00000, float:1.7632415E-38)
            if (r3 == 0) goto L_0x00f7
            r6 = r6 | r32
            goto L_0x010d
        L_0x00f7:
            r32 = r0 & r32
            if (r32 != 0) goto L_0x010d
            r32 = r6
            r5 = r50
            boolean r33 = r4.changed((long) r5)
            if (r33 == 0) goto L_0x0108
            r33 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x010a
        L_0x0108:
            r33 = 4194304(0x400000, float:5.877472E-39)
        L_0x010a:
            r32 = r32 | r33
            goto L_0x0111
        L_0x010d:
            r32 = r6
            r5 = r50
        L_0x0111:
            r0 = r2 & 256(0x100, float:3.59E-43)
            r33 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x011a
            r32 = r32 | r33
            goto L_0x0130
        L_0x011a:
            r33 = r62 & r33
            if (r33 != 0) goto L_0x0130
            r33 = r0
            r0 = r52
            boolean r34 = r4.changed((java.lang.Object) r0)
            if (r34 == 0) goto L_0x012b
            r34 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x012d
        L_0x012b:
            r34 = 33554432(0x2000000, float:9.403955E-38)
        L_0x012d:
            r32 = r32 | r34
            goto L_0x0134
        L_0x0130:
            r33 = r0
            r0 = r52
        L_0x0134:
            r0 = r2 & 512(0x200, float:7.175E-43)
            r34 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x013f
            r32 = r32 | r34
            r34 = r0
            goto L_0x0159
        L_0x013f:
            r34 = r62 & r34
            if (r34 != 0) goto L_0x0155
            r34 = r0
            r0 = r53
            boolean r35 = r4.changed((java.lang.Object) r0)
            if (r35 == 0) goto L_0x0150
            r35 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0152
        L_0x0150:
            r35 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0152:
            r32 = r32 | r35
            goto L_0x0159
        L_0x0155:
            r34 = r0
            r0 = r53
        L_0x0159:
            r0 = r32
            r32 = r3
            r3 = r2 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0166
            r17 = r1 | 6
            r5 = r54
            goto L_0x017c
        L_0x0166:
            r35 = r1 & 6
            r5 = r54
            if (r35 != 0) goto L_0x017a
            boolean r35 = r4.changed((long) r5)
            if (r35 == 0) goto L_0x0175
            r17 = 4
            goto L_0x0177
        L_0x0175:
            r17 = 2
        L_0x0177:
            r17 = r1 | r17
            goto L_0x017c
        L_0x017a:
            r17 = r1
        L_0x017c:
            r35 = r3
            r3 = r2 & 2048(0x800, float:2.87E-42)
            if (r3 == 0) goto L_0x0187
            r17 = r17 | 48
            r36 = r3
            goto L_0x01a1
        L_0x0187:
            r36 = r1 & 48
            if (r36 != 0) goto L_0x019d
            r36 = r3
            r3 = r56
            boolean r37 = r4.changed((int) r3)
            if (r37 == 0) goto L_0x0198
            r24 = 32
            goto L_0x019a
        L_0x0198:
            r24 = 16
        L_0x019a:
            r17 = r17 | r24
            goto L_0x01a1
        L_0x019d:
            r36 = r3
            r3 = r56
        L_0x01a1:
            r3 = r17
            r5 = r2 & 4096(0x1000, float:5.74E-42)
            if (r5 == 0) goto L_0x01aa
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x01be
        L_0x01aa:
            r6 = r1 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x01be
            r6 = r57
            boolean r17 = r4.changed((boolean) r6)
            if (r17 == 0) goto L_0x01b9
            r28 = 256(0x100, float:3.59E-43)
            goto L_0x01bb
        L_0x01b9:
            r28 = 128(0x80, float:1.794E-43)
        L_0x01bb:
            r3 = r3 | r28
            goto L_0x01c0
        L_0x01be:
            r6 = r57
        L_0x01c0:
            r17 = r5
            r5 = r2 & 8192(0x2000, float:1.14794E-41)
            if (r5 == 0) goto L_0x01c9
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x01e3
        L_0x01c9:
            r20 = r3
            r3 = r1 & 3072(0xc00, float:4.305E-42)
            if (r3 != 0) goto L_0x01df
            r3 = r58
            boolean r24 = r4.changed((int) r3)
            if (r24 == 0) goto L_0x01d8
            goto L_0x01da
        L_0x01d8:
            r18 = r19
        L_0x01da:
            r18 = r20 | r18
            r3 = r18
            goto L_0x01e3
        L_0x01df:
            r3 = r58
            r3 = r20
        L_0x01e3:
            r18 = r5
            r5 = r2 & 16384(0x4000, float:2.2959E-41)
            if (r5 == 0) goto L_0x01ec
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x01fe
        L_0x01ec:
            r2 = r1 & 24576(0x6000, float:3.4438E-41)
            if (r2 != 0) goto L_0x01fe
            r2 = r59
            boolean r19 = r4.changedInstance(r2)
            if (r19 == 0) goto L_0x01f9
            goto L_0x01fb
        L_0x01f9:
            r22 = r23
        L_0x01fb:
            r3 = r3 | r22
            goto L_0x0200
        L_0x01fe:
            r2 = r59
        L_0x0200:
            r19 = r1 & r27
            r20 = 32768(0x8000, float:4.5918E-41)
            if (r19 != 0) goto L_0x0218
            r19 = r64 & r20
            r1 = r60
            if (r19 != 0) goto L_0x0215
            boolean r19 = r4.changed((java.lang.Object) r1)
            if (r19 == 0) goto L_0x0215
            r26 = 131072(0x20000, float:1.83671E-40)
        L_0x0215:
            r3 = r3 | r26
            goto L_0x021a
        L_0x0218:
            r1 = r60
        L_0x021a:
            r19 = 306783379(0x12492493, float:6.34695E-28)
            r1 = r0 & r19
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r2) goto L_0x0254
            r1 = 74899(0x12493, float:1.04956E-40)
            r1 = r1 & r3
            r2 = 74898(0x12492, float:1.04954E-40)
            if (r1 != r2) goto L_0x0254
            boolean r1 = r4.getSkipping()
            if (r1 != 0) goto L_0x0234
            goto L_0x0254
        L_0x0234:
            r4.skipToGroupEnd()
            r2 = r42
            r13 = r53
            r16 = r56
            r18 = r58
            r19 = r59
            r20 = r60
            r25 = r4
            r17 = r6
            r3 = r7
            r7 = r10
            r5 = r11
            r8 = r14
            r9 = r15
            r10 = r50
            r12 = r52
            r14 = r54
            goto L_0x0394
        L_0x0254:
            r4.startDefaults()
            r1 = r62 & 1
            if (r1 == 0) goto L_0x0287
            boolean r1 = r4.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0262
            goto L_0x0287
        L_0x0262:
            r4.skipToGroupEnd()
            r1 = r64 & r20
            if (r1 == 0) goto L_0x026d
            r1 = -458753(0xfffffffffff8ffff, float:NaN)
            r3 = r3 & r1
        L_0x026d:
            r5 = r42
            r16 = r53
            r17 = r54
            r19 = r56
            r21 = r58
            r23 = r59
            r24 = r60
            r20 = r6
            r6 = r7
            r8 = r11
            r11 = r14
            r12 = r15
            r13 = r50
            r15 = r52
            goto L_0x033c
        L_0x0287:
            if (r9 == 0) goto L_0x028e
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x0290
        L_0x028e:
            r1 = r42
        L_0x0290:
            if (r13 == 0) goto L_0x0298
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            long r7 = r2.m4275getUnspecified0d7_KjU()
        L_0x0298:
            if (r16 == 0) goto L_0x02a0
            androidx.compose.ui.unit.TextUnit$Companion r2 = androidx.compose.ui.unit.TextUnit.Companion
            long r11 = r2.m7317getUnspecifiedXSAIIZE()
        L_0x02a0:
            r2 = 0
            if (r21 == 0) goto L_0x02a4
            r10 = r2
        L_0x02a4:
            if (r25 == 0) goto L_0x02a7
            r14 = r2
        L_0x02a7:
            if (r29 == 0) goto L_0x02aa
            r15 = r2
        L_0x02aa:
            if (r32 == 0) goto L_0x02b3
            androidx.compose.ui.unit.TextUnit$Companion r9 = androidx.compose.ui.unit.TextUnit.Companion
            long r21 = r9.m7317getUnspecifiedXSAIIZE()
            goto L_0x02b5
        L_0x02b3:
            r21 = r50
        L_0x02b5:
            if (r33 == 0) goto L_0x02b9
            r9 = r2
            goto L_0x02bb
        L_0x02b9:
            r9 = r52
        L_0x02bb:
            if (r34 == 0) goto L_0x02be
            goto L_0x02c0
        L_0x02be:
            r2 = r53
        L_0x02c0:
            if (r35 == 0) goto L_0x02c9
            androidx.compose.ui.unit.TextUnit$Companion r13 = androidx.compose.ui.unit.TextUnit.Companion
            long r23 = r13.m7317getUnspecifiedXSAIIZE()
            goto L_0x02cb
        L_0x02c9:
            r23 = r54
        L_0x02cb:
            if (r36 == 0) goto L_0x02d4
            androidx.compose.ui.text.style.TextOverflow$Companion r13 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r13 = r13.m7037getClipgIe3tQ8()
            goto L_0x02d6
        L_0x02d4:
            r13 = r56
        L_0x02d6:
            if (r17 == 0) goto L_0x02d9
            r6 = 1
        L_0x02d9:
            if (r18 == 0) goto L_0x02df
            r16 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x02e1
        L_0x02df:
            r16 = r58
        L_0x02e1:
            if (r5 == 0) goto L_0x02e8
            androidx.compose.material3.TextKt$Text$2 r5 = androidx.compose.material3.TextKt$Text$2.INSTANCE
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            goto L_0x02ea
        L_0x02e8:
            r5 = r59
        L_0x02ea:
            r17 = r64 & r20
            if (r17 == 0) goto L_0x031a
            androidx.compose.runtime.ProvidableCompositionLocal<androidx.compose.ui.text.TextStyle> r17 = LocalTextStyle
            r42 = r1
            r1 = r17
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r43 = r2
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            r61 = r3
            java.lang.String r3 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r2, r3)
            java.lang.Object r1 = r4.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.text.TextStyle r1 = (androidx.compose.ui.text.TextStyle) r1
            r2 = -458753(0xfffffffffff8ffff, float:NaN)
            r3 = r61 & r2
            r20 = r6
            r6 = r7
            r19 = r13
            r17 = r23
            r24 = r1
            goto L_0x0329
        L_0x031a:
            r42 = r1
            r43 = r2
            r61 = r3
            r20 = r6
            r6 = r7
            r19 = r13
            r17 = r23
            r24 = r60
        L_0x0329:
            r23 = r5
            r5 = r42
            r39 = r16
            r16 = r43
            r40 = r15
            r15 = r9
            r8 = r11
            r11 = r14
            r12 = r40
            r13 = r21
            r21 = r39
        L_0x033c:
            r4.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x034d
            java.lang.String r1 = "androidx.compose.material3.Text (Text.kt:157)"
            r2 = 1968784669(0x7559451d, float:2.7542241E32)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r0, r3, r1)
        L_0x034d:
            r1 = 2147483646(0x7ffffffe, float:NaN)
            r26 = r0 & r1
            r0 = r3 & 14
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r1 = r3 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r3 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r3 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r3 << 3
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r1
            r0 = r0 | r2
            r2 = 3670016(0x380000, float:5.142788E-39)
            r1 = r1 & r2
            r27 = r0 | r1
            r28 = 0
            r22 = 1
            r25 = r4
            r4 = r41
            m2692Text4IGK_g((java.lang.String) r4, (androidx.compose.ui.Modifier) r5, (long) r6, (long) r8, (androidx.compose.ui.text.font.FontStyle) r10, (androidx.compose.ui.text.font.FontWeight) r11, (androidx.compose.ui.text.font.FontFamily) r12, (long) r13, (androidx.compose.ui.text.style.TextDecoration) r15, (androidx.compose.ui.text.style.TextAlign) r16, (long) r17, (int) r19, (boolean) r20, (int) r21, (int) r22, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r23, (androidx.compose.ui.text.TextStyle) r24, (androidx.compose.runtime.Composer) r25, (int) r26, (int) r27, (int) r28)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x037e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x037e:
            r2 = r5
            r3 = r6
            r5 = r8
            r7 = r10
            r8 = r11
            r9 = r12
            r10 = r13
            r12 = r15
            r13 = r16
            r14 = r17
            r16 = r19
            r17 = r20
            r18 = r21
            r19 = r23
            r20 = r24
        L_0x0394:
            androidx.compose.runtime.ScopeUpdateScope r0 = r25.endRestartGroup()
            if (r0 == 0) goto L_0x03b1
            r1 = r0
            androidx.compose.material3.TextKt$Text$3 r0 = new androidx.compose.material3.TextKt$Text$3
            r21 = r62
            r22 = r63
            r23 = r64
            r38 = r1
            r1 = r41
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r38
            r1.updateScope(r0)
        L_0x03b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextKt.m2694TextfLXpl1I(java.lang.String, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x022f  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0243  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0284  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x048c  */
    /* JADX WARNING: Removed duplicated region for block: B:271:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x012f  */
    /* renamed from: Text-IbK3jfQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2693TextIbK3jfQ(androidx.compose.ui.text.AnnotatedString r60, androidx.compose.ui.Modifier r61, long r62, long r64, androidx.compose.ui.text.font.FontStyle r66, androidx.compose.ui.text.font.FontWeight r67, androidx.compose.ui.text.font.FontFamily r68, long r69, androidx.compose.ui.text.style.TextDecoration r71, androidx.compose.ui.text.style.TextAlign r72, long r73, int r75, boolean r76, int r77, int r78, java.util.Map<java.lang.String, androidx.compose.foundation.text.InlineTextContent> r79, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r80, androidx.compose.ui.text.TextStyle r81, androidx.compose.runtime.Composer r82, int r83, int r84, int r85) {
        /*
            r0 = r83
            r1 = r84
            r2 = r85
            r3 = 2027001676(0x78d1974c, float:3.4008085E34)
            r4 = r82
            androidx.compose.runtime.Composer r3 = r4.startRestartGroup(r3)
            java.lang.String r4 = "C(Text)P(15,10,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,6:c#ui.unit.TextUnit,17,16:c#ui.text.style.TextAlign,7:c#ui.unit.TextUnit,12:c#ui.text.style.TextOverflow,13,8,9)254@11726L7,258@11837L706:Text.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            r4 = r2 & 1
            if (r4 == 0) goto L_0x001e
            r4 = r0 | 6
            r7 = r4
            r4 = r60
            goto L_0x0032
        L_0x001e:
            r4 = r0 & 6
            if (r4 != 0) goto L_0x002f
            r4 = r60
            boolean r7 = r3.changed((java.lang.Object) r4)
            if (r7 == 0) goto L_0x002c
            r7 = 4
            goto L_0x002d
        L_0x002c:
            r7 = 2
        L_0x002d:
            r7 = r7 | r0
            goto L_0x0032
        L_0x002f:
            r4 = r60
            r7 = r0
        L_0x0032:
            r8 = r2 & 2
            if (r8 == 0) goto L_0x0039
            r7 = r7 | 48
            goto L_0x004c
        L_0x0039:
            r11 = r0 & 48
            if (r11 != 0) goto L_0x004c
            r11 = r61
            boolean r12 = r3.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0048
            r12 = 32
            goto L_0x004a
        L_0x0048:
            r12 = 16
        L_0x004a:
            r7 = r7 | r12
            goto L_0x004e
        L_0x004c:
            r11 = r61
        L_0x004e:
            r12 = r2 & 4
            if (r12 == 0) goto L_0x0057
            r7 = r7 | 384(0x180, float:5.38E-43)
            r5 = r62
            goto L_0x006a
        L_0x0057:
            r15 = r0 & 384(0x180, float:5.38E-43)
            r5 = r62
            if (r15 != 0) goto L_0x006a
            boolean r16 = r3.changed((long) r5)
            if (r16 == 0) goto L_0x0066
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0066:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r7 = r7 | r16
        L_0x006a:
            r16 = r2 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0077
            r7 = r7 | 3072(0xc00, float:4.305E-42)
            r10 = r64
            goto L_0x008a
        L_0x0077:
            r9 = r0 & 3072(0xc00, float:4.305E-42)
            r10 = r64
            if (r9 != 0) goto L_0x008a
            boolean r20 = r3.changed((long) r10)
            if (r20 == 0) goto L_0x0086
            r20 = r17
            goto L_0x0088
        L_0x0086:
            r20 = r18
        L_0x0088:
            r7 = r7 | r20
        L_0x008a:
            r20 = r2 & 16
            r21 = 16384(0x4000, float:2.2959E-41)
            r22 = 8192(0x2000, float:1.14794E-41)
            if (r20 == 0) goto L_0x0095
            r7 = r7 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a9
        L_0x0095:
            r9 = r0 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x00a9
            r9 = r66
            boolean r24 = r3.changed((java.lang.Object) r9)
            if (r24 == 0) goto L_0x00a4
            r24 = r21
            goto L_0x00a6
        L_0x00a4:
            r24 = r22
        L_0x00a6:
            r7 = r7 | r24
            goto L_0x00ab
        L_0x00a9:
            r9 = r66
        L_0x00ab:
            r24 = r2 & 32
            r25 = 65536(0x10000, float:9.18355E-41)
            r26 = 196608(0x30000, float:2.75506E-40)
            r27 = 131072(0x20000, float:1.83671E-40)
            if (r24 == 0) goto L_0x00ba
            r7 = r7 | r26
            r13 = r67
            goto L_0x00cd
        L_0x00ba:
            r28 = r0 & r26
            r13 = r67
            if (r28 != 0) goto L_0x00cd
            boolean r29 = r3.changed((java.lang.Object) r13)
            if (r29 == 0) goto L_0x00c9
            r29 = r27
            goto L_0x00cb
        L_0x00c9:
            r29 = r25
        L_0x00cb:
            r7 = r7 | r29
        L_0x00cd:
            r29 = r2 & 64
            r30 = 1572864(0x180000, float:2.204052E-39)
            if (r29 == 0) goto L_0x00d8
            r7 = r7 | r30
            r14 = r68
            goto L_0x00eb
        L_0x00d8:
            r31 = r0 & r30
            r14 = r68
            if (r31 != 0) goto L_0x00eb
            boolean r32 = r3.changed((java.lang.Object) r14)
            if (r32 == 0) goto L_0x00e7
            r32 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e9
        L_0x00e7:
            r32 = 524288(0x80000, float:7.34684E-40)
        L_0x00e9:
            r7 = r7 | r32
        L_0x00eb:
            r15 = r2 & 128(0x80, float:1.794E-43)
            r33 = 12582912(0xc00000, float:1.7632415E-38)
            if (r15 == 0) goto L_0x00f6
            r7 = r7 | r33
            r4 = r69
            goto L_0x0108
        L_0x00f6:
            r34 = r0 & r33
            r4 = r69
            if (r34 != 0) goto L_0x0108
            boolean r6 = r3.changed((long) r4)
            if (r6 == 0) goto L_0x0105
            r6 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0107
        L_0x0105:
            r6 = 4194304(0x400000, float:5.877472E-39)
        L_0x0107:
            r7 = r7 | r6
        L_0x0108:
            r6 = r2 & 256(0x100, float:3.59E-43)
            r34 = 100663296(0x6000000, float:2.4074124E-35)
            if (r6 == 0) goto L_0x0113
            r7 = r7 | r34
            r0 = r71
            goto L_0x0126
        L_0x0113:
            r34 = r0 & r34
            r0 = r71
            if (r34 != 0) goto L_0x0126
            boolean r34 = r3.changed((java.lang.Object) r0)
            if (r34 == 0) goto L_0x0122
            r34 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0124
        L_0x0122:
            r34 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0124:
            r7 = r7 | r34
        L_0x0126:
            r0 = r2 & 512(0x200, float:7.175E-43)
            r34 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x012f
            r7 = r7 | r34
            goto L_0x0145
        L_0x012f:
            r34 = r83 & r34
            if (r34 != 0) goto L_0x0145
            r34 = r0
            r0 = r72
            boolean r35 = r3.changed((java.lang.Object) r0)
            if (r35 == 0) goto L_0x0140
            r35 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0142
        L_0x0140:
            r35 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0142:
            r7 = r7 | r35
            goto L_0x0149
        L_0x0145:
            r34 = r0
            r0 = r72
        L_0x0149:
            r0 = r2 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0152
            r32 = r1 | 6
            r4 = r73
            goto L_0x0168
        L_0x0152:
            r35 = r1 & 6
            r4 = r73
            if (r35 != 0) goto L_0x0166
            boolean r35 = r3.changed((long) r4)
            if (r35 == 0) goto L_0x0161
            r32 = 4
            goto L_0x0163
        L_0x0161:
            r32 = 2
        L_0x0163:
            r32 = r1 | r32
            goto L_0x0168
        L_0x0166:
            r32 = r1
        L_0x0168:
            r35 = r0
            r0 = r2 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0173
            r32 = r32 | 48
            r36 = r0
            goto L_0x018d
        L_0x0173:
            r36 = r1 & 48
            if (r36 != 0) goto L_0x0189
            r36 = r0
            r0 = r75
            boolean r37 = r3.changed((int) r0)
            if (r37 == 0) goto L_0x0184
            r23 = 32
            goto L_0x0186
        L_0x0184:
            r23 = 16
        L_0x0186:
            r32 = r32 | r23
            goto L_0x018d
        L_0x0189:
            r36 = r0
            r0 = r75
        L_0x018d:
            r0 = r32
            r4 = r2 & 4096(0x1000, float:5.74E-42)
            if (r4 == 0) goto L_0x0196
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x01aa
        L_0x0196:
            r5 = r1 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x01aa
            r5 = r76
            boolean r19 = r3.changed((boolean) r5)
            if (r19 == 0) goto L_0x01a5
            r28 = 256(0x100, float:3.59E-43)
            goto L_0x01a7
        L_0x01a5:
            r28 = 128(0x80, float:1.794E-43)
        L_0x01a7:
            r0 = r0 | r28
            goto L_0x01ac
        L_0x01aa:
            r5 = r76
        L_0x01ac:
            r19 = r4
            r4 = r2 & 8192(0x2000, float:1.14794E-41)
            if (r4 == 0) goto L_0x01b5
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x01cf
        L_0x01b5:
            r23 = r0
            r0 = r1 & 3072(0xc00, float:4.305E-42)
            if (r0 != 0) goto L_0x01cb
            r0 = r77
            boolean r28 = r3.changed((int) r0)
            if (r28 == 0) goto L_0x01c4
            goto L_0x01c6
        L_0x01c4:
            r17 = r18
        L_0x01c6:
            r17 = r23 | r17
            r0 = r17
            goto L_0x01cf
        L_0x01cb:
            r0 = r77
            r0 = r23
        L_0x01cf:
            r17 = r4
            r4 = r2 & 16384(0x4000, float:2.2959E-41)
            if (r4 == 0) goto L_0x01da
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r18 = r0
            goto L_0x01ee
        L_0x01da:
            r18 = r0
            r0 = r1 & 24576(0x6000, float:3.4438E-41)
            if (r0 != 0) goto L_0x01ee
            r0 = r78
            boolean r23 = r3.changed((int) r0)
            if (r23 == 0) goto L_0x01e9
            goto L_0x01eb
        L_0x01e9:
            r21 = r22
        L_0x01eb:
            r18 = r18 | r21
            goto L_0x01f0
        L_0x01ee:
            r0 = r78
        L_0x01f0:
            r21 = 32768(0x8000, float:4.5918E-41)
            r21 = r2 & r21
            if (r21 == 0) goto L_0x01fc
            r18 = r18 | r26
            r0 = r79
            goto L_0x020f
        L_0x01fc:
            r22 = r1 & r26
            r0 = r79
            if (r22 != 0) goto L_0x020f
            boolean r22 = r3.changedInstance(r0)
            if (r22 == 0) goto L_0x020b
            r22 = r27
            goto L_0x020d
        L_0x020b:
            r22 = r25
        L_0x020d:
            r18 = r18 | r22
        L_0x020f:
            r22 = r2 & r25
            if (r22 == 0) goto L_0x0218
            r18 = r18 | r30
            r0 = r80
            goto L_0x022b
        L_0x0218:
            r23 = r1 & r30
            r0 = r80
            if (r23 != 0) goto L_0x022b
            boolean r23 = r3.changedInstance(r0)
            if (r23 == 0) goto L_0x0227
            r23 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0229
        L_0x0227:
            r23 = 524288(0x80000, float:7.34684E-40)
        L_0x0229:
            r18 = r18 | r23
        L_0x022b:
            r23 = r1 & r33
            if (r23 != 0) goto L_0x0243
            r23 = r2 & r27
            r0 = r81
            if (r23 != 0) goto L_0x023e
            boolean r23 = r3.changed((java.lang.Object) r0)
            if (r23 == 0) goto L_0x023e
            r23 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0240
        L_0x023e:
            r23 = 4194304(0x400000, float:5.877472E-39)
        L_0x0240:
            r18 = r18 | r23
            goto L_0x0245
        L_0x0243:
            r0 = r81
        L_0x0245:
            r23 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r7 & r23
            r1 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r1) goto L_0x0284
            r0 = 4793491(0x492493, float:6.717112E-39)
            r0 = r18 & r0
            r1 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r1) goto L_0x0284
            boolean r0 = r3.getSkipping()
            if (r0 != 0) goto L_0x0260
            goto L_0x0284
        L_0x0260:
            r3.skipToGroupEnd()
            r2 = r61
            r12 = r71
            r16 = r75
            r18 = r77
            r19 = r78
            r20 = r79
            r21 = r80
            r22 = r81
            r0 = r3
            r17 = r5
            r7 = r9
            r5 = r10
            r8 = r13
            r9 = r14
            r3 = r62
            r10 = r69
            r13 = r72
            r14 = r73
            goto L_0x0486
        L_0x0284:
            r3.startDefaults()
            r0 = r83 & 1
            if (r0 == 0) goto L_0x02c2
            boolean r0 = r3.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0292
            goto L_0x02c2
        L_0x0292:
            r3.skipToGroupEnd()
            r0 = r2 & r27
            if (r0 == 0) goto L_0x029e
            r0 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r18 = r18 & r0
        L_0x029e:
            r0 = r61
            r25 = r62
            r37 = r69
            r44 = r71
            r1 = r72
            r49 = r73
            r8 = r75
            r17 = r77
            r12 = r78
            r4 = r79
            r19 = r80
            r27 = r81
            r33 = r9
            r30 = r10
            r32 = r13
            r35 = r14
            r2 = r18
            goto L_0x0388
        L_0x02c2:
            if (r8 == 0) goto L_0x02c9
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x02cb
        L_0x02c9:
            r0 = r61
        L_0x02cb:
            if (r12 == 0) goto L_0x02d4
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r25 = r1.m4275getUnspecified0d7_KjU()
            goto L_0x02d6
        L_0x02d4:
            r25 = r62
        L_0x02d6:
            if (r16 == 0) goto L_0x02de
            androidx.compose.ui.unit.TextUnit$Companion r1 = androidx.compose.ui.unit.TextUnit.Companion
            long r10 = r1.m7317getUnspecifiedXSAIIZE()
        L_0x02de:
            r1 = 0
            if (r20 == 0) goto L_0x02e2
            r9 = r1
        L_0x02e2:
            if (r24 == 0) goto L_0x02e5
            r13 = r1
        L_0x02e5:
            if (r29 == 0) goto L_0x02e8
            r14 = r1
        L_0x02e8:
            if (r15 == 0) goto L_0x02f1
            androidx.compose.ui.unit.TextUnit$Companion r8 = androidx.compose.ui.unit.TextUnit.Companion
            long r15 = r8.m7317getUnspecifiedXSAIIZE()
            goto L_0x02f3
        L_0x02f1:
            r15 = r69
        L_0x02f3:
            if (r6 == 0) goto L_0x02f7
            r6 = r1
            goto L_0x02f9
        L_0x02f7:
            r6 = r71
        L_0x02f9:
            if (r34 == 0) goto L_0x02fc
            goto L_0x02fe
        L_0x02fc:
            r1 = r72
        L_0x02fe:
            if (r35 == 0) goto L_0x0307
            androidx.compose.ui.unit.TextUnit$Companion r8 = androidx.compose.ui.unit.TextUnit.Companion
            long r23 = r8.m7317getUnspecifiedXSAIIZE()
            goto L_0x0309
        L_0x0307:
            r23 = r73
        L_0x0309:
            if (r36 == 0) goto L_0x0312
            androidx.compose.ui.text.style.TextOverflow$Companion r8 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r8 = r8.m7037getClipgIe3tQ8()
            goto L_0x0314
        L_0x0312:
            r8 = r75
        L_0x0314:
            r12 = 1
            if (r19 == 0) goto L_0x0318
            r5 = r12
        L_0x0318:
            if (r17 == 0) goto L_0x031e
            r17 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0320
        L_0x031e:
            r17 = r77
        L_0x0320:
            if (r4 == 0) goto L_0x0323
            goto L_0x0325
        L_0x0323:
            r12 = r78
        L_0x0325:
            if (r21 == 0) goto L_0x032c
            java.util.Map r4 = kotlin.collections.MapsKt.emptyMap()
            goto L_0x032e
        L_0x032c:
            r4 = r79
        L_0x032e:
            if (r22 == 0) goto L_0x0335
            androidx.compose.material3.TextKt$Text$4 r19 = androidx.compose.material3.TextKt$Text$4.INSTANCE
            kotlin.jvm.functions.Function1 r19 = (kotlin.jvm.functions.Function1) r19
            goto L_0x0337
        L_0x0335:
            r19 = r80
        L_0x0337:
            r20 = r2 & r27
            if (r20 == 0) goto L_0x0372
            androidx.compose.runtime.ProvidableCompositionLocal<androidx.compose.ui.text.TextStyle> r20 = LocalTextStyle
            r61 = r0
            r0 = r20
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r62 = r1
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r2 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r1, r2)
            java.lang.Object r0 = r3.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.ui.text.TextStyle r0 = (androidx.compose.ui.text.TextStyle) r0
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r18 = r18 & r1
            r1 = r62
            r27 = r0
            r44 = r6
            r33 = r9
            r30 = r10
            r32 = r13
            r35 = r14
            r37 = r15
            r2 = r18
            r49 = r23
            r0 = r61
            goto L_0x0388
        L_0x0372:
            r61 = r0
            r62 = r1
            r27 = r81
            r44 = r6
            r33 = r9
            r30 = r10
            r32 = r13
            r35 = r14
            r37 = r15
            r2 = r18
            r49 = r23
        L_0x0388:
            r3.endDefaults()
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x0399
            r6 = 2027001676(0x78d1974c, float:3.4008085E34)
            java.lang.String r9 = "androidx.compose.material3.Text (Text.kt:255)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r6, r7, r2, r9)
        L_0x0399:
            r6 = -1827697581(0xffffffff930f8c53, float:-1.8118323E-27)
            r3.startReplaceGroup(r6)
            java.lang.String r6 = ""
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r6)
            r9 = 16
            int r6 = (r25 > r9 ? 1 : (r25 == r9 ? 0 : -1))
            if (r6 == 0) goto L_0x03ad
            r28 = r25
            goto L_0x03e3
        L_0x03ad:
            r6 = -1827696808(0xffffffff930f8f58, float:-1.8119811E-27)
            r3.startReplaceGroup(r6)
            java.lang.String r6 = "*256@11820L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r6)
            long r9 = r27.m6594getColor0d7_KjU()
            r13 = 16
            int r6 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r6 == 0) goto L_0x03c3
            goto L_0x03de
        L_0x03c3:
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.material3.ContentColorKt.getLocalContentColor()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r10 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r9, r10)
            java.lang.Object r6 = r3.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.ui.graphics.Color r6 = (androidx.compose.ui.graphics.Color) r6
            long r9 = r6.m4249unboximpl()
        L_0x03de:
            r3.endReplaceGroup()
            r28 = r9
        L_0x03e3:
            r3.endReplaceGroup()
            if (r1 == 0) goto L_0x03ed
            int r6 = r1.m6985unboximpl()
            goto L_0x03f3
        L_0x03ed:
            androidx.compose.ui.text.style.TextAlign$Companion r6 = androidx.compose.ui.text.style.TextAlign.Companion
            int r6 = r6.m6992getUnspecifiede0LSkKk()
        L_0x03f3:
            r47 = r6
            r57 = 16609104(0xfd6f50, float:2.3274312E-38)
            r58 = 0
            r34 = 0
            r36 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r45 = 0
            r46 = 0
            r48 = 0
            r51 = 0
            r52 = 0
            r53 = 0
            r54 = 0
            r55 = 0
            r56 = 0
            androidx.compose.ui.text.TextStyle r6 = androidx.compose.ui.text.TextStyle.m6584mergedA7vx0o$default(r27, r28, r30, r32, r33, r34, r35, r36, r37, r39, r40, r41, r42, r44, r45, r46, r47, r48, r49, r51, r52, r53, r54, r55, r56, r57, r58)
            r7 = r7 & 126(0x7e, float:1.77E-43)
            int r9 = r2 >> 9
            r9 = r9 & 7168(0x1c00, float:1.0045E-41)
            r7 = r7 | r9
            int r2 = r2 << 9
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r2
            r7 = r7 | r9
            r9 = 458752(0x70000, float:6.42848E-40)
            r9 = r9 & r2
            r7 = r7 | r9
            r9 = 3670016(0x380000, float:5.142788E-39)
            r9 = r9 & r2
            r7 = r7 | r9
            r9 = 29360128(0x1c00000, float:7.052966E-38)
            r9 = r9 & r2
            r7 = r7 | r9
            r9 = 234881024(0xe000000, float:1.5777218E-30)
            r2 = r2 & r9
            r2 = r2 | r7
            r7 = 512(0x200, float:7.175E-43)
            r9 = 0
            r61 = r60
            r62 = r0
            r72 = r2
            r71 = r3
            r69 = r4
            r66 = r5
            r63 = r6
            r73 = r7
            r65 = r8
            r70 = r9
            r68 = r12
            r67 = r17
            r64 = r19
            androidx.compose.foundation.text.BasicTextKt.m1164BasicTextRWo7tUw(r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73)
            r2 = r62
            r0 = r71
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0467
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0467:
            r13 = r1
            r20 = r4
            r16 = r8
            r18 = r17
            r21 = r19
            r3 = r25
            r22 = r27
            r8 = r32
            r7 = r33
            r9 = r35
            r10 = r37
            r14 = r49
            r17 = r5
            r19 = r12
            r5 = r30
            r12 = r44
        L_0x0486:
            androidx.compose.runtime.ScopeUpdateScope r0 = r0.endRestartGroup()
            if (r0 == 0) goto L_0x04a3
            r1 = r0
            androidx.compose.material3.TextKt$Text$5 r0 = new androidx.compose.material3.TextKt$Text$5
            r23 = r83
            r24 = r84
            r25 = r85
            r59 = r1
            r1 = r60
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r59
            r1.updateScope(r0)
        L_0x04a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextKt.m2693TextIbK3jfQ(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, int, java.util.Map, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0237  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x03c9  */
    /* JADX WARNING: Removed duplicated region for block: B:249:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0141  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* renamed from: Text--4IGK_g  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void m2691Text4IGK_g(androidx.compose.ui.text.AnnotatedString r44, androidx.compose.ui.Modifier r45, long r46, long r48, androidx.compose.ui.text.font.FontStyle r50, androidx.compose.ui.text.font.FontWeight r51, androidx.compose.ui.text.font.FontFamily r52, long r53, androidx.compose.ui.text.style.TextDecoration r55, androidx.compose.ui.text.style.TextAlign r56, long r57, int r59, boolean r60, int r61, java.util.Map r62, kotlin.jvm.functions.Function1 r63, androidx.compose.ui.text.TextStyle r64, androidx.compose.runtime.Composer r65, int r66, int r67, int r68) {
        /*
            r0 = r66
            r1 = r67
            r2 = r68
            r3 = 224529679(0xd620d0f, float:6.9657345E-31)
            r4 = r65
            androidx.compose.runtime.Composer r4 = r4.startRestartGroup(r3)
            java.lang.String r5 = "C(Text)P(14,9,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,6:c#ui.unit.TextUnit,16,15:c#ui.text.style.TextAlign,7:c#ui.unit.TextUnit,11:c#ui.text.style.TextOverflow,12,8)304@13393L7,306@13409L345:Text.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r5)
            r5 = r2 & 1
            if (r5 == 0) goto L_0x001e
            r5 = r0 | 6
            r8 = r5
            r5 = r44
            goto L_0x0032
        L_0x001e:
            r5 = r0 & 6
            if (r5 != 0) goto L_0x002f
            r5 = r44
            boolean r8 = r4.changed((java.lang.Object) r5)
            if (r8 == 0) goto L_0x002c
            r8 = 4
            goto L_0x002d
        L_0x002c:
            r8 = 2
        L_0x002d:
            r8 = r8 | r0
            goto L_0x0032
        L_0x002f:
            r5 = r44
            r8 = r0
        L_0x0032:
            r9 = r2 & 2
            if (r9 == 0) goto L_0x0039
            r8 = r8 | 48
            goto L_0x004c
        L_0x0039:
            r12 = r0 & 48
            if (r12 != 0) goto L_0x004c
            r12 = r45
            boolean r13 = r4.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x0048
            r13 = 32
            goto L_0x004a
        L_0x0048:
            r13 = 16
        L_0x004a:
            r8 = r8 | r13
            goto L_0x004e
        L_0x004c:
            r12 = r45
        L_0x004e:
            r13 = r2 & 4
            if (r13 == 0) goto L_0x0058
            r8 = r8 | 384(0x180, float:5.38E-43)
            r6 = r8
            r7 = r46
            goto L_0x006f
        L_0x0058:
            r6 = r0 & 384(0x180, float:5.38E-43)
            r16 = r8
            r7 = r46
            if (r6 != 0) goto L_0x006d
            boolean r17 = r4.changed((long) r7)
            if (r17 == 0) goto L_0x0069
            r17 = 256(0x100, float:3.59E-43)
            goto L_0x006b
        L_0x0069:
            r17 = 128(0x80, float:1.794E-43)
        L_0x006b:
            r16 = r16 | r17
        L_0x006d:
            r6 = r16
        L_0x006f:
            r16 = r2 & 8
            r18 = 2048(0x800, float:2.87E-42)
            r19 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x007c
            r6 = r6 | 3072(0xc00, float:4.305E-42)
            r11 = r48
            goto L_0x008f
        L_0x007c:
            r10 = r0 & 3072(0xc00, float:4.305E-42)
            r11 = r48
            if (r10 != 0) goto L_0x008f
            boolean r21 = r4.changed((long) r11)
            if (r21 == 0) goto L_0x008b
            r21 = r18
            goto L_0x008d
        L_0x008b:
            r21 = r19
        L_0x008d:
            r6 = r6 | r21
        L_0x008f:
            r21 = r2 & 16
            r22 = 16384(0x4000, float:2.2959E-41)
            r23 = 8192(0x2000, float:1.14794E-41)
            if (r21 == 0) goto L_0x009a
            r6 = r6 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00ae
        L_0x009a:
            r10 = r0 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x00ae
            r10 = r50
            boolean r25 = r4.changed((java.lang.Object) r10)
            if (r25 == 0) goto L_0x00a9
            r25 = r22
            goto L_0x00ab
        L_0x00a9:
            r25 = r23
        L_0x00ab:
            r6 = r6 | r25
            goto L_0x00b0
        L_0x00ae:
            r10 = r50
        L_0x00b0:
            r25 = r2 & 32
            r26 = 131072(0x20000, float:1.83671E-40)
            r27 = 196608(0x30000, float:2.75506E-40)
            r28 = 65536(0x10000, float:9.18355E-41)
            if (r25 == 0) goto L_0x00bf
            r6 = r6 | r27
            r14 = r51
            goto L_0x00d2
        L_0x00bf:
            r29 = r0 & r27
            r14 = r51
            if (r29 != 0) goto L_0x00d2
            boolean r30 = r4.changed((java.lang.Object) r14)
            if (r30 == 0) goto L_0x00ce
            r30 = r26
            goto L_0x00d0
        L_0x00ce:
            r30 = r28
        L_0x00d0:
            r6 = r6 | r30
        L_0x00d2:
            r30 = r2 & 64
            r31 = 1572864(0x180000, float:2.204052E-39)
            if (r30 == 0) goto L_0x00dd
            r6 = r6 | r31
            r15 = r52
            goto L_0x00f0
        L_0x00dd:
            r32 = r0 & r31
            r15 = r52
            if (r32 != 0) goto L_0x00f0
            boolean r33 = r4.changed((java.lang.Object) r15)
            if (r33 == 0) goto L_0x00ec
            r33 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ee
        L_0x00ec:
            r33 = 524288(0x80000, float:7.34684E-40)
        L_0x00ee:
            r6 = r6 | r33
        L_0x00f0:
            r3 = r2 & 128(0x80, float:1.794E-43)
            r34 = 12582912(0xc00000, float:1.7632415E-38)
            if (r3 == 0) goto L_0x00f9
            r6 = r6 | r34
            goto L_0x010f
        L_0x00f9:
            r34 = r0 & r34
            if (r34 != 0) goto L_0x010f
            r34 = r6
            r5 = r53
            boolean r35 = r4.changed((long) r5)
            if (r35 == 0) goto L_0x010a
            r35 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x010c
        L_0x010a:
            r35 = 4194304(0x400000, float:5.877472E-39)
        L_0x010c:
            r34 = r34 | r35
            goto L_0x0113
        L_0x010f:
            r34 = r6
            r5 = r53
        L_0x0113:
            r0 = r2 & 256(0x100, float:3.59E-43)
            r35 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x011c
            r34 = r34 | r35
            goto L_0x0132
        L_0x011c:
            r35 = r66 & r35
            if (r35 != 0) goto L_0x0132
            r35 = r0
            r0 = r55
            boolean r36 = r4.changed((java.lang.Object) r0)
            if (r36 == 0) goto L_0x012d
            r36 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x012f
        L_0x012d:
            r36 = 33554432(0x2000000, float:9.403955E-38)
        L_0x012f:
            r34 = r34 | r36
            goto L_0x0136
        L_0x0132:
            r35 = r0
            r0 = r55
        L_0x0136:
            r0 = r2 & 512(0x200, float:7.175E-43)
            r36 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x0141
            r34 = r34 | r36
            r36 = r0
            goto L_0x015b
        L_0x0141:
            r36 = r66 & r36
            if (r36 != 0) goto L_0x0157
            r36 = r0
            r0 = r56
            boolean r37 = r4.changed((java.lang.Object) r0)
            if (r37 == 0) goto L_0x0152
            r37 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0154
        L_0x0152:
            r37 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0154:
            r34 = r34 | r37
            goto L_0x015b
        L_0x0157:
            r36 = r0
            r0 = r56
        L_0x015b:
            r0 = r34
            r34 = r3
            r3 = r2 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0168
            r17 = r1 | 6
            r5 = r57
            goto L_0x017e
        L_0x0168:
            r37 = r1 & 6
            r5 = r57
            if (r37 != 0) goto L_0x017c
            boolean r37 = r4.changed((long) r5)
            if (r37 == 0) goto L_0x0177
            r17 = 4
            goto L_0x0179
        L_0x0177:
            r17 = 2
        L_0x0179:
            r17 = r1 | r17
            goto L_0x017e
        L_0x017c:
            r17 = r1
        L_0x017e:
            r37 = r3
            r3 = r2 & 2048(0x800, float:2.87E-42)
            if (r3 == 0) goto L_0x0189
            r17 = r17 | 48
            r38 = r3
            goto L_0x01a3
        L_0x0189:
            r38 = r1 & 48
            if (r38 != 0) goto L_0x019f
            r38 = r3
            r3 = r59
            boolean r39 = r4.changed((int) r3)
            if (r39 == 0) goto L_0x019a
            r24 = 32
            goto L_0x019c
        L_0x019a:
            r24 = 16
        L_0x019c:
            r17 = r17 | r24
            goto L_0x01a3
        L_0x019f:
            r38 = r3
            r3 = r59
        L_0x01a3:
            r3 = r17
            r5 = r2 & 4096(0x1000, float:5.74E-42)
            if (r5 == 0) goto L_0x01ac
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x01c0
        L_0x01ac:
            r6 = r1 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x01c0
            r6 = r60
            boolean r17 = r4.changed((boolean) r6)
            if (r17 == 0) goto L_0x01bb
            r29 = 256(0x100, float:3.59E-43)
            goto L_0x01bd
        L_0x01bb:
            r29 = 128(0x80, float:1.794E-43)
        L_0x01bd:
            r3 = r3 | r29
            goto L_0x01c2
        L_0x01c0:
            r6 = r60
        L_0x01c2:
            r17 = r5
            r5 = r2 & 8192(0x2000, float:1.14794E-41)
            if (r5 == 0) goto L_0x01cb
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x01e5
        L_0x01cb:
            r20 = r3
            r3 = r1 & 3072(0xc00, float:4.305E-42)
            if (r3 != 0) goto L_0x01e1
            r3 = r61
            boolean r24 = r4.changed((int) r3)
            if (r24 == 0) goto L_0x01da
            goto L_0x01dc
        L_0x01da:
            r18 = r19
        L_0x01dc:
            r18 = r20 | r18
            r3 = r18
            goto L_0x01e5
        L_0x01e1:
            r3 = r61
            r3 = r20
        L_0x01e5:
            r18 = r5
            r5 = r2 & 16384(0x4000, float:2.2959E-41)
            if (r5 == 0) goto L_0x01ee
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0200
        L_0x01ee:
            r2 = r1 & 24576(0x6000, float:3.4438E-41)
            if (r2 != 0) goto L_0x0200
            r2 = r62
            boolean r19 = r4.changedInstance(r2)
            if (r19 == 0) goto L_0x01fb
            goto L_0x01fd
        L_0x01fb:
            r22 = r23
        L_0x01fd:
            r3 = r3 | r22
            goto L_0x0202
        L_0x0200:
            r2 = r62
        L_0x0202:
            r19 = 32768(0x8000, float:4.5918E-41)
            r19 = r68 & r19
            if (r19 == 0) goto L_0x020e
            r3 = r3 | r27
            r1 = r63
            goto L_0x021f
        L_0x020e:
            r20 = r1 & r27
            r1 = r63
            if (r20 != 0) goto L_0x021f
            boolean r20 = r4.changedInstance(r1)
            if (r20 == 0) goto L_0x021b
            goto L_0x021d
        L_0x021b:
            r26 = r28
        L_0x021d:
            r3 = r3 | r26
        L_0x021f:
            r20 = r67 & r31
            if (r20 != 0) goto L_0x0237
            r20 = r68 & r28
            r1 = r64
            if (r20 != 0) goto L_0x0232
            boolean r20 = r4.changed((java.lang.Object) r1)
            if (r20 == 0) goto L_0x0232
            r20 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0234
        L_0x0232:
            r20 = 524288(0x80000, float:7.34684E-40)
        L_0x0234:
            r3 = r3 | r20
            goto L_0x0239
        L_0x0237:
            r1 = r64
        L_0x0239:
            r20 = 306783379(0x12492493, float:6.34695E-28)
            r1 = r0 & r20
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r2) goto L_0x0275
            r1 = 599187(0x92493, float:8.3964E-40)
            r1 = r1 & r3
            r2 = 599186(0x92492, float:8.39638E-40)
            if (r1 != r2) goto L_0x0275
            boolean r1 = r4.getSkipping()
            if (r1 != 0) goto L_0x0253
            goto L_0x0275
        L_0x0253:
            r4.skipToGroupEnd()
            r2 = r45
            r13 = r56
            r16 = r59
            r18 = r61
            r19 = r62
            r20 = r63
            r21 = r64
            r26 = r4
            r17 = r6
            r3 = r7
            r7 = r10
            r5 = r11
            r8 = r14
            r9 = r15
            r10 = r53
            r12 = r55
            r14 = r57
            goto L_0x03c3
        L_0x0275:
            r4.startDefaults()
            r1 = r66 & 1
            if (r1 == 0) goto L_0x02aa
            boolean r1 = r4.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0283
            goto L_0x02aa
        L_0x0283:
            r4.skipToGroupEnd()
            r1 = r68 & r28
            if (r1 == 0) goto L_0x028e
            r1 = -3670017(0xffffffffffc7ffff, float:NaN)
            r3 = r3 & r1
        L_0x028e:
            r5 = r45
            r16 = r56
            r17 = r57
            r19 = r59
            r21 = r61
            r23 = r62
            r24 = r63
            r25 = r64
            r20 = r6
            r6 = r7
            r8 = r11
            r11 = r14
            r12 = r15
            r13 = r53
            r15 = r55
            goto L_0x0365
        L_0x02aa:
            if (r9 == 0) goto L_0x02b1
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x02b3
        L_0x02b1:
            r1 = r45
        L_0x02b3:
            if (r13 == 0) goto L_0x02bb
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            long r7 = r2.m4275getUnspecified0d7_KjU()
        L_0x02bb:
            if (r16 == 0) goto L_0x02c3
            androidx.compose.ui.unit.TextUnit$Companion r2 = androidx.compose.ui.unit.TextUnit.Companion
            long r11 = r2.m7317getUnspecifiedXSAIIZE()
        L_0x02c3:
            r2 = 0
            if (r21 == 0) goto L_0x02c7
            r10 = r2
        L_0x02c7:
            if (r25 == 0) goto L_0x02ca
            r14 = r2
        L_0x02ca:
            if (r30 == 0) goto L_0x02cd
            r15 = r2
        L_0x02cd:
            if (r34 == 0) goto L_0x02d6
            androidx.compose.ui.unit.TextUnit$Companion r9 = androidx.compose.ui.unit.TextUnit.Companion
            long r20 = r9.m7317getUnspecifiedXSAIIZE()
            goto L_0x02d8
        L_0x02d6:
            r20 = r53
        L_0x02d8:
            if (r35 == 0) goto L_0x02dc
            r9 = r2
            goto L_0x02de
        L_0x02dc:
            r9 = r55
        L_0x02de:
            if (r36 == 0) goto L_0x02e1
            goto L_0x02e3
        L_0x02e1:
            r2 = r56
        L_0x02e3:
            if (r37 == 0) goto L_0x02ec
            androidx.compose.ui.unit.TextUnit$Companion r13 = androidx.compose.ui.unit.TextUnit.Companion
            long r22 = r13.m7317getUnspecifiedXSAIIZE()
            goto L_0x02ee
        L_0x02ec:
            r22 = r57
        L_0x02ee:
            if (r38 == 0) goto L_0x02f7
            androidx.compose.ui.text.style.TextOverflow$Companion r13 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r13 = r13.m7037getClipgIe3tQ8()
            goto L_0x02f9
        L_0x02f7:
            r13 = r59
        L_0x02f9:
            if (r17 == 0) goto L_0x02fc
            r6 = 1
        L_0x02fc:
            if (r18 == 0) goto L_0x0302
            r16 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0304
        L_0x0302:
            r16 = r61
        L_0x0304:
            if (r5 == 0) goto L_0x030b
            java.util.Map r5 = kotlin.collections.MapsKt.emptyMap()
            goto L_0x030d
        L_0x030b:
            r5 = r62
        L_0x030d:
            if (r19 == 0) goto L_0x0314
            androidx.compose.material3.TextKt$Text$6 r17 = androidx.compose.material3.TextKt$Text$6.INSTANCE
            kotlin.jvm.functions.Function1 r17 = (kotlin.jvm.functions.Function1) r17
            goto L_0x0316
        L_0x0314:
            r17 = r63
        L_0x0316:
            r18 = r68 & r28
            if (r18 == 0) goto L_0x033f
            androidx.compose.runtime.ProvidableCompositionLocal<androidx.compose.ui.text.TextStyle> r18 = LocalTextStyle
            r45 = r1
            r1 = r18
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r46 = r2
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            r65 = r3
            java.lang.String r3 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r2, r3)
            java.lang.Object r1 = r4.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.text.TextStyle r1 = (androidx.compose.ui.text.TextStyle) r1
            r2 = -3670017(0xffffffffffc7ffff, float:NaN)
            r3 = r65 & r2
            r25 = r1
            goto L_0x0347
        L_0x033f:
            r45 = r1
            r46 = r2
            r65 = r3
            r25 = r64
        L_0x0347:
            r19 = r13
            r24 = r17
            r17 = r22
            r23 = r5
            r5 = r45
            r41 = r16
            r16 = r46
            r42 = r20
            r20 = r6
            r6 = r7
            r21 = r41
            r41 = r15
            r15 = r9
            r8 = r11
            r11 = r14
            r12 = r41
            r13 = r42
        L_0x0365:
            r4.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0376
            java.lang.String r1 = "androidx.compose.material3.Text (Text.kt:305)"
            r2 = 224529679(0xd620d0f, float:6.9657345E-31)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r0, r3, r1)
        L_0x0376:
            r1 = 2147483646(0x7ffffffe, float:NaN)
            r27 = r0 & r1
            r0 = r3 & 14
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r1 = r3 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r3 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r3 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r3 << 3
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r1
            r0 = r0 | r2
            r2 = 3670016(0x380000, float:5.142788E-39)
            r2 = r2 & r1
            r0 = r0 | r2
            r2 = 29360128(0x1c00000, float:7.052966E-38)
            r1 = r1 & r2
            r28 = r0 | r1
            r29 = 0
            r22 = 1
            r26 = r4
            r4 = r44
            m2693TextIbK3jfQ(r4, r5, r6, r8, r10, r11, r12, r13, r15, r16, r17, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x03ab
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03ab:
            r2 = r5
            r3 = r6
            r5 = r8
            r7 = r10
            r8 = r11
            r9 = r12
            r10 = r13
            r12 = r15
            r13 = r16
            r14 = r17
            r16 = r19
            r17 = r20
            r18 = r21
            r19 = r23
            r20 = r24
            r21 = r25
        L_0x03c3:
            androidx.compose.runtime.ScopeUpdateScope r0 = r26.endRestartGroup()
            if (r0 == 0) goto L_0x03e0
            r1 = r0
            androidx.compose.material3.TextKt$Text$7 r0 = new androidx.compose.material3.TextKt$Text$7
            r22 = r66
            r23 = r67
            r24 = r68
            r40 = r1
            r1 = r44
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r40
            r1.updateScope(r0)
        L_0x03e0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextKt.m2691Text4IGK_g(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, java.util.Map, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final ProvidableCompositionLocal<TextStyle> getLocalTextStyle() {
        return LocalTextStyle;
    }

    public static final void ProvideTextStyle(TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-460300127);
        ComposerKt.sourceInformation(startRestartGroup, "C(ProvideTextStyle)P(1)347@14710L7,348@14735L80:Text.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) textStyle) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-460300127, i2, -1, "androidx.compose.material3.ProvideTextStyle (Text.kt:346)");
            }
            ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(providableCompositionLocal);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) providableCompositionLocal.provides(((TextStyle) consume).merge(textStyle)), function2, startRestartGroup, (i2 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextKt$ProvideTextStyle$1(textStyle, function2, i));
        }
    }
}
