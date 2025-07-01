package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\u0010\t\u001a$\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0000\u001a*\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u0015\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010$\u001a\u0001\u0010\"\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010(\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2@\u0010)\u001a<\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b+\u0012\b\b(\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b+\u0012\b\b(\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00030*¢\u0006\u0002\b,¢\u0006\u0002\b-H\u0007ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a \u0001\u0010\"\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010(\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u0002012@\u0010)\u001a<\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b+\u0012\b\b(\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b+\u0012\b\b(\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00030*¢\u0006\u0002\b,¢\u0006\u0002\b-H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001aD\u00104\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u001b2\b\b\u0002\u0010(\u001a\u00020\u00012\b\u00106\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u00100\u001a\u000201H\u0000ø\u0001\u0000¢\u0006\u0004\b7\u00108\u001a\u0014\u00109\u001a\u00020\u0019*\u00020\u00192\u0006\u0010:\u001a\u00020\u0005H\u0000\u001a&\u0010;\u001a\u00020\u0003*\u00020<2\u0017\u0010=\u001a\u0013\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u00030>¢\u0006\u0002\b?H\b\u001a&\u0010@\u001a\u00020\u001b*\u00020\u00152\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\bA\u0010B\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006C"}, d2 = {"RootGroupName", "", "RenderVectorGroup", "", "group", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "configs", "", "Landroidx/compose/ui/graphics/vector/VectorConfig;", "(Landroidx/compose/ui/graphics/vector/VectorGroup;Ljava/util/Map;Landroidx/compose/runtime/Composer;II)V", "createColorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "tintColor", "Landroidx/compose/ui/graphics/Color;", "tintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "createColorFilter-xETnrds", "(JI)Landroidx/compose/ui/graphics/ColorFilter;", "createVectorPainterFromImageVector", "Landroidx/compose/ui/graphics/vector/VectorPainter;", "density", "Landroidx/compose/ui/unit/Density;", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "root", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "obtainViewportSize", "Landroidx/compose/ui/geometry/Size;", "defaultSize", "viewportWidth", "", "viewportHeight", "obtainViewportSize-Pq9zytI", "(JFF)J", "rememberVectorPainter", "image", "(Landroidx/compose/ui/graphics/vector/ImageVector;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/vector/VectorPainter;", "defaultWidth", "Landroidx/compose/ui/unit/Dp;", "defaultHeight", "name", "content", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/graphics/vector/VectorComposable;", "rememberVectorPainter-mlNsNFs", "(FFFFLjava/lang/String;JILkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/vector/VectorPainter;", "autoMirror", "", "rememberVectorPainter-vIP8VLU", "(FFFFLjava/lang/String;JIZLkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/vector/VectorPainter;", "configureVectorPainter", "viewportSize", "intrinsicColorFilter", "configureVectorPainter-T4PVSW8", "(Landroidx/compose/ui/graphics/vector/VectorPainter;JJLjava/lang/String;Landroidx/compose/ui/graphics/ColorFilter;Z)Landroidx/compose/ui/graphics/vector/VectorPainter;", "createGroupComponent", "currentGroup", "mirror", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "obtainSizePx", "obtainSizePx-VpY3zN4", "(Landroidx/compose/ui/unit/Density;FF)J", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: VectorPainter.kt */
public final class VectorPainterKt {
    public static final String RootGroupName = "VectorRootGroup";

    @Deprecated(message = "Replace rememberVectorPainter graphicsLayer that consumes the auto mirror flag", replaceWith = @ReplaceWith(expression = "rememberVectorPainter(defaultWidth, defaultHeight, viewportWidth, viewportHeight, name, tintColor, tintBlendMode, false, content)", imports = {"androidx.compose.ui.graphics.vector"}))
    /* renamed from: rememberVectorPainter-mlNsNFs  reason: not valid java name */
    public static final VectorPainter m5081rememberVectorPaintermlNsNFs(float f, float f2, float f3, float f4, String str, long j, int i, Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function4, Composer composer, int i2, int i3) {
        int i4 = i2;
        Composer composer2 = composer;
        ComposerKt.sourceInformationMarkerStart(composer2, -964365210, "C(rememberVectorPainter)P(2:c#ui.unit.Dp,1:c#ui.unit.Dp,7,6,3,5:c#ui.graphics.Color,4:c#ui.graphics.BlendMode)86@3732L207:VectorPainter.kt#huu6hf");
        float f5 = (i3 & 4) != 0 ? Float.NaN : f3;
        float f6 = (i3 & 8) != 0 ? Float.NaN : f4;
        String str2 = (i3 & 16) != 0 ? RootGroupName : str;
        long r8 = (i3 & 32) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j;
        int r10 = (i3 & 64) != 0 ? BlendMode.Companion.m4168getSrcIn0nO6VwU() : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-964365210, i4, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:86)");
        }
        VectorPainter r0 = m5082rememberVectorPaintervIP8VLU(f, f2, f5, f6, str2, r8, r10, false, function4, composer2, (i4 & 14) | 12582912 | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i4) | ((i4 << 3) & 234881024), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return r0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0167, code lost:
        if (r4 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x0169;
     */
    /* renamed from: rememberVectorPainter-vIP8VLU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.graphics.vector.VectorPainter m5082rememberVectorPaintervIP8VLU(float r17, float r18, float r19, float r20, java.lang.String r21, long r22, int r24, boolean r25, kotlin.jvm.functions.Function4<? super java.lang.Float, ? super java.lang.Float, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, androidx.compose.runtime.Composer r27, int r28, int r29) {
        /*
            r0 = r26
            r1 = r27
            r2 = r28
            r3 = r29
            java.lang.String r4 = "C(rememberVectorPainter)P(3:c#ui.unit.Dp,2:c#ui.unit.Dp,8,7,4,6:c#ui.graphics.Color,5:c#ui.graphics.BlendMode)131@5630L7,134@5823L94:VectorPainter.kt#huu6hf"
            r5 = 1068590786(0x3fb166c2, float:1.3859484)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r5, r4)
            r4 = r3 & 4
            r6 = 2143289344(0x7fc00000, float:NaN)
            if (r4 == 0) goto L_0x0018
            r4 = r6
            goto L_0x001a
        L_0x0018:
            r4 = r19
        L_0x001a:
            r7 = r3 & 8
            if (r7 == 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            r6 = r20
        L_0x0021:
            r7 = r3 & 16
            if (r7 == 0) goto L_0x0028
            java.lang.String r7 = "VectorRootGroup"
            goto L_0x002a
        L_0x0028:
            r7 = r21
        L_0x002a:
            r8 = r3 & 32
            if (r8 == 0) goto L_0x0035
            androidx.compose.ui.graphics.Color$Companion r8 = androidx.compose.ui.graphics.Color.Companion
            long r8 = r8.m4275getUnspecified0d7_KjU()
            goto L_0x0037
        L_0x0035:
            r8 = r22
        L_0x0037:
            r10 = r3 & 64
            if (r10 == 0) goto L_0x0042
            androidx.compose.ui.graphics.BlendMode$Companion r10 = androidx.compose.ui.graphics.BlendMode.Companion
            int r10 = r10.m4168getSrcIn0nO6VwU()
            goto L_0x0044
        L_0x0042:
            r10 = r24
        L_0x0044:
            r3 = r3 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x004a
            r3 = 0
            goto L_0x004c
        L_0x004a:
            r3 = r25
        L_0x004c:
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x0058
            r12 = -1
            java.lang.String r13 = "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:130)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r2, r12, r13)
        L_0x0058:
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r13 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r12, r13)
            java.lang.Object r5 = r1.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.ui.unit.Density r5 = (androidx.compose.ui.unit.Density) r5
            r12 = r17
            r13 = r18
            long r12 = m5079obtainSizePxVpY3zN4(r5, r12, r13)
            long r14 = m5080obtainViewportSizePq9zytI(r12, r4, r6)
            r5 = -1837515400(0xffffffff9279bd78, float:-7.8804084E-28)
            java.lang.String r11 = "CC(remember):VectorPainter.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r5, r11)
            r5 = 458752(0x70000, float:6.42848E-40)
            r5 = r5 & r2
            r16 = 196608(0x30000, float:2.75506E-40)
            r5 = r5 ^ r16
            r24 = r3
            r3 = 131072(0x20000, float:1.83671E-40)
            r19 = r7
            if (r5 <= r3) goto L_0x0098
            boolean r5 = r1.changed((long) r8)
            if (r5 != 0) goto L_0x009c
        L_0x0098:
            r5 = r2 & r16
            if (r5 != r3) goto L_0x009e
        L_0x009c:
            r3 = 1
            goto L_0x009f
        L_0x009e:
            r3 = 0
        L_0x009f:
            r5 = 3670016(0x380000, float:5.142788E-39)
            r5 = r5 & r2
            r16 = 1572864(0x180000, float:2.204052E-39)
            r5 = r5 ^ r16
            r7 = 1048576(0x100000, float:1.469368E-39)
            if (r5 <= r7) goto L_0x00b0
            boolean r5 = r1.changed((int) r10)
            if (r5 != 0) goto L_0x00b4
        L_0x00b0:
            r5 = r2 & r16
            if (r5 != r7) goto L_0x00b6
        L_0x00b4:
            r5 = 1
            goto L_0x00b7
        L_0x00b6:
            r5 = 0
        L_0x00b7:
            r3 = r3 | r5
            java.lang.Object r5 = r1.rememberedValue()
            if (r3 != 0) goto L_0x00c6
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r5 != r3) goto L_0x00cd
        L_0x00c6:
            androidx.compose.ui.graphics.ColorFilter r5 = m5078createColorFilterxETnrds(r8, r10)
            r1.updateRememberedValue(r5)
        L_0x00cd:
            androidx.compose.ui.graphics.ColorFilter r5 = (androidx.compose.ui.graphics.ColorFilter) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r3 = -1837510348(0xffffffff9279d134, float:-7.882841E-28)
            r1.startReplaceGroup(r3)
            java.lang.String r3 = "*137@5929L28,145@6235L28,146@6291L487"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = -1837512074(0xffffffff9279ca76, float:-7.88201E-28)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r3, r11)
            java.lang.Object r3 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r3 != r7) goto L_0x00f9
            androidx.compose.ui.graphics.vector.VectorPainter r3 = new androidx.compose.ui.graphics.vector.VectorPainter
            r7 = 0
            r8 = 1
            r3.<init>(r7, r8, r7)
            r1.updateRememberedValue(r3)
        L_0x00f9:
            androidx.compose.ui.graphics.vector.VectorPainter r3 = (androidx.compose.ui.graphics.vector.VectorPainter) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r22 = r19
            r17 = r3
            r23 = r5
            r18 = r12
            r20 = r14
            m5076configureVectorPainterT4PVSW8(r17, r18, r20, r22, r23, r24)
            r9 = r20
            r8 = 0
            androidx.compose.runtime.CompositionContext r5 = androidx.compose.runtime.ComposablesKt.rememberCompositionContext(r1, r8)
            r7 = 904082560(0x35e33480, float:1.6928097E-6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r7, r11)
            r7 = r2 & 896(0x380, float:1.256E-42)
            r7 = r7 ^ 384(0x180, float:5.38E-43)
            r11 = 256(0x100, float:3.59E-43)
            if (r7 <= r11) goto L_0x0126
            boolean r4 = r1.changed((float) r4)
            if (r4 != 0) goto L_0x012a
        L_0x0126:
            r4 = r2 & 384(0x180, float:5.38E-43)
            if (r4 != r11) goto L_0x012c
        L_0x012a:
            r4 = 1
            goto L_0x012d
        L_0x012c:
            r4 = r8
        L_0x012d:
            r7 = r2 & 7168(0x1c00, float:1.0045E-41)
            r7 = r7 ^ 3072(0xc00, float:4.305E-42)
            r11 = 2048(0x800, float:2.87E-42)
            if (r7 <= r11) goto L_0x013b
            boolean r6 = r1.changed((float) r6)
            if (r6 != 0) goto L_0x013f
        L_0x013b:
            r6 = r2 & 3072(0xc00, float:4.305E-42)
            if (r6 != r11) goto L_0x0141
        L_0x013f:
            r6 = 1
            goto L_0x0142
        L_0x0141:
            r6 = r8
        L_0x0142:
            r4 = r4 | r6
            r6 = 234881024(0xe000000, float:1.5777218E-30)
            r6 = r6 & r2
            r7 = 100663296(0x6000000, float:2.4074124E-35)
            r6 = r6 ^ r7
            r11 = 67108864(0x4000000, float:1.5046328E-36)
            if (r6 <= r11) goto L_0x0153
            boolean r6 = r1.changed((java.lang.Object) r0)
            if (r6 != 0) goto L_0x0156
        L_0x0153:
            r2 = r2 & r7
            if (r2 != r11) goto L_0x0158
        L_0x0156:
            r11 = 1
            goto L_0x0159
        L_0x0158:
            r11 = r8
        L_0x0159:
            r2 = r4 | r11
            java.lang.Object r4 = r1.rememberedValue()
            if (r2 != 0) goto L_0x0169
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r4 != r2) goto L_0x01a0
        L_0x0169:
            androidx.compose.runtime.Composition r2 = r3.getComposition$ui_release()
            if (r2 == 0) goto L_0x0175
            boolean r4 = r2.isDisposed()
            if (r4 == 0) goto L_0x018a
        L_0x0175:
            androidx.compose.ui.graphics.vector.VectorApplier r2 = new androidx.compose.ui.graphics.vector.VectorApplier
            androidx.compose.ui.graphics.vector.VectorComponent r4 = r3.getVector$ui_release()
            androidx.compose.ui.graphics.vector.GroupComponent r4 = r4.getRoot()
            androidx.compose.ui.graphics.vector.VNode r4 = (androidx.compose.ui.graphics.vector.VNode) r4
            r2.<init>(r4)
            androidx.compose.runtime.Applier r2 = (androidx.compose.runtime.Applier) r2
            androidx.compose.runtime.Composition r2 = androidx.compose.runtime.CompositionKt.Composition(r2, r5)
        L_0x018a:
            r4 = r2
            androidx.compose.ui.graphics.vector.VectorPainterKt$rememberVectorPainter$2$1$1 r2 = new androidx.compose.ui.graphics.vector.VectorPainterKt$rememberVectorPainter$2$1$1
            r2.<init>(r0, r9)
            r0 = -824421385(0xffffffffcedc53f7, float:-1.84824512E9)
            r8 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r0, r8, r2)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r4.setContent(r0)
            r1.updateRememberedValue(r4)
        L_0x01a0:
            androidx.compose.runtime.Composition r4 = (androidx.compose.runtime.Composition) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r3.setComposition$ui_release(r4)
            r1.endReplaceGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01b4
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01b4:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.VectorPainterKt.m5082rememberVectorPaintervIP8VLU(float, float, float, float, java.lang.String, long, int, boolean, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):androidx.compose.ui.graphics.vector.VectorPainter");
    }

    public static final VectorPainter rememberVectorPainter(ImageVector imageVector, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1413834416, "C(rememberVectorPainter)172@7145L7,174@7229L215:VectorPainter.kt#huu6hf");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1413834416, i, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:171)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) consume;
        float density2 = density.getDensity();
        long floatToRawIntBits = (long) Float.floatToRawIntBits((float) imageVector.getGenId$ui_release());
        long floatToRawIntBits2 = ((long) Float.floatToRawIntBits(density2)) & 4294967295L;
        ComposerKt.sourceInformationMarkerStart(composer, -1837470287, "CC(remember):VectorPainter.kt#9igjgp");
        boolean changed = composer.changed(floatToRawIntBits2 | (floatToRawIntBits << 32));
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            GroupComponent groupComponent = new GroupComponent();
            createGroupComponent(groupComponent, imageVector.getRoot());
            Unit unit = Unit.INSTANCE;
            rememberedValue = createVectorPainterFromImageVector(density, imageVector, groupComponent);
            composer.updateRememberedValue(rememberedValue);
        }
        VectorPainter vectorPainter = (VectorPainter) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return vectorPainter;
    }

    /* renamed from: obtainSizePx-VpY3zN4  reason: not valid java name */
    private static final long m5079obtainSizePxVpY3zN4(Density density, float f, float f2) {
        return SizeKt.Size(density.m7091toPx0680j_4(f), density.m7091toPx0680j_4(f2));
    }

    /* renamed from: obtainViewportSize-Pq9zytI  reason: not valid java name */
    private static final long m5080obtainViewportSizePq9zytI(long j, float f, float f2) {
        if (Float.isNaN(f)) {
            f = Size.m4056getWidthimpl(j);
        }
        if (Float.isNaN(f2)) {
            f2 = Size.m4053getHeightimpl(j);
        }
        return SizeKt.Size(f, f2);
    }

    /* renamed from: createColorFilter-xETnrds  reason: not valid java name */
    private static final ColorFilter m5078createColorFilterxETnrds(long j, int i) {
        if (j != 16) {
            return ColorFilter.Companion.m4283tintxETnrds(j, i);
        }
        return null;
    }

    /* renamed from: configureVectorPainter-T4PVSW8$default  reason: not valid java name */
    public static /* synthetic */ VectorPainter m5077configureVectorPainterT4PVSW8$default(VectorPainter vectorPainter, long j, long j2, String str, ColorFilter colorFilter, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            str = RootGroupName;
        }
        return m5076configureVectorPainterT4PVSW8(vectorPainter, j, j2, str, colorFilter, (i & 16) != 0 ? false : z);
    }

    /* renamed from: configureVectorPainter-T4PVSW8  reason: not valid java name */
    public static final VectorPainter m5076configureVectorPainterT4PVSW8(VectorPainter vectorPainter, long j, long j2, String str, ColorFilter colorFilter, boolean z) {
        vectorPainter.m5074setSizeuvyYCjk$ui_release(j);
        vectorPainter.setAutoMirror$ui_release(z);
        vectorPainter.setIntrinsicColorFilter$ui_release(colorFilter);
        vectorPainter.m5075setViewportSizeuvyYCjk$ui_release(j2);
        vectorPainter.setName$ui_release(str);
        return vectorPainter;
    }

    public static final VectorPainter createVectorPainterFromImageVector(Density density, ImageVector imageVector, GroupComponent groupComponent) {
        long r3 = m5079obtainSizePxVpY3zN4(density, imageVector.m5049getDefaultWidthD9Ej5fM(), imageVector.m5048getDefaultHeightD9Ej5fM());
        return m5076configureVectorPainterT4PVSW8(new VectorPainter(groupComponent), r3, m5080obtainViewportSizePq9zytI(r3, imageVector.getViewportWidth(), imageVector.getViewportHeight()), imageVector.getName(), m5078createColorFilterxETnrds(imageVector.m5051getTintColor0d7_KjU(), imageVector.m5050getTintBlendMode0nO6VwU()), imageVector.getAutoMirror());
    }

    public static final GroupComponent createGroupComponent(GroupComponent groupComponent, VectorGroup vectorGroup) {
        int size = vectorGroup.getSize();
        for (int i = 0; i < size; i++) {
            VectorNode vectorNode = vectorGroup.get(i);
            if (vectorNode instanceof VectorPath) {
                PathComponent pathComponent = new PathComponent();
                VectorPath vectorPath = (VectorPath) vectorNode;
                pathComponent.setPathData(vectorPath.getPathData());
                pathComponent.m5059setPathFillTypeoQ8Xj4U(vectorPath.m5083getPathFillTypeRgk1Os());
                pathComponent.setName(vectorPath.getName());
                pathComponent.setFill(vectorPath.getFill());
                pathComponent.setFillAlpha(vectorPath.getFillAlpha());
                pathComponent.setStroke(vectorPath.getStroke());
                pathComponent.setStrokeAlpha(vectorPath.getStrokeAlpha());
                pathComponent.setStrokeLineWidth(vectorPath.getStrokeLineWidth());
                pathComponent.m5060setStrokeLineCapBeK7IIE(vectorPath.m5084getStrokeLineCapKaPHkGw());
                pathComponent.m5061setStrokeLineJoinWw9F2mQ(vectorPath.m5085getStrokeLineJoinLxFBmk8());
                pathComponent.setStrokeLineMiter(vectorPath.getStrokeLineMiter());
                pathComponent.setTrimPathStart(vectorPath.getTrimPathStart());
                pathComponent.setTrimPathEnd(vectorPath.getTrimPathEnd());
                pathComponent.setTrimPathOffset(vectorPath.getTrimPathOffset());
                groupComponent.insertAt(i, pathComponent);
            } else if (vectorNode instanceof VectorGroup) {
                GroupComponent groupComponent2 = new GroupComponent();
                VectorGroup vectorGroup2 = (VectorGroup) vectorNode;
                groupComponent2.setName(vectorGroup2.getName());
                groupComponent2.setRotation(vectorGroup2.getRotation());
                groupComponent2.setScaleX(vectorGroup2.getScaleX());
                groupComponent2.setScaleY(vectorGroup2.getScaleY());
                groupComponent2.setTranslationX(vectorGroup2.getTranslationX());
                groupComponent2.setTranslationY(vectorGroup2.getTranslationY());
                groupComponent2.setPivotX(vectorGroup2.getPivotX());
                groupComponent2.setPivotY(vectorGroup2.getPivotY());
                groupComponent2.setClipPathData(vectorGroup2.getClipPathData());
                createGroupComponent(groupComponent2, vectorGroup2);
                groupComponent.insertAt(i, groupComponent2);
            }
        }
        return groupComponent;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x02bf  */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void RenderVectorGroup(androidx.compose.ui.graphics.vector.VectorGroup r22, java.util.Map<java.lang.String, ? extends androidx.compose.ui.graphics.vector.VectorConfig> r23, androidx.compose.runtime.Composer r24, int r25, int r26) {
        /*
            r0 = r22
            r1 = r25
            r2 = r26
            r3 = -446179233(0xffffffffe567d85f, float:-6.8428625E22)
            r4 = r24
            androidx.compose.runtime.Composer r14 = r4.startRestartGroup(r3)
            java.lang.String r4 = "C(RenderVectorGroup)P(1):VectorPainter.kt#huu6hf"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r4)
            r4 = r2 & 1
            if (r4 == 0) goto L_0x001b
            r4 = r1 | 6
            goto L_0x002b
        L_0x001b:
            r4 = r1 & 6
            if (r4 != 0) goto L_0x002a
            boolean r4 = r14.changed((java.lang.Object) r0)
            if (r4 == 0) goto L_0x0027
            r4 = 4
            goto L_0x0028
        L_0x0027:
            r4 = 2
        L_0x0028:
            r4 = r4 | r1
            goto L_0x002b
        L_0x002a:
            r4 = r1
        L_0x002b:
            r5 = r2 & 2
            if (r5 == 0) goto L_0x0032
            r4 = r4 | 48
            goto L_0x0045
        L_0x0032:
            r6 = r1 & 48
            if (r6 != 0) goto L_0x0045
            r6 = r23
            boolean r7 = r14.changedInstance(r6)
            if (r7 == 0) goto L_0x0041
            r7 = 32
            goto L_0x0043
        L_0x0041:
            r7 = 16
        L_0x0043:
            r4 = r4 | r7
            goto L_0x0047
        L_0x0045:
            r6 = r23
        L_0x0047:
            r7 = r4 & 19
            r8 = 18
            if (r7 != r8) goto L_0x0059
            boolean r7 = r14.getSkipping()
            if (r7 != 0) goto L_0x0054
            goto L_0x0059
        L_0x0054:
            r14.skipToGroupEnd()
            goto L_0x02b9
        L_0x0059:
            if (r5 == 0) goto L_0x0060
            java.util.Map r5 = kotlin.collections.MapsKt.emptyMap()
            goto L_0x0061
        L_0x0060:
            r5 = r6
        L_0x0061:
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x006d
            r6 = -1
            java.lang.String r7 = "androidx.compose.ui.graphics.vector.RenderVectorGroup (VectorPainter.kt:430)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r4, r6, r7)
        L_0x006d:
            java.util.Iterator r3 = r0.iterator()
        L_0x0071:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x02ac
            java.lang.Object r4 = r3.next()
            androidx.compose.ui.graphics.vector.VectorNode r4 = (androidx.compose.ui.graphics.vector.VectorNode) r4
            boolean r6 = r4 instanceof androidx.compose.ui.graphics.vector.VectorPath
            if (r6 == 0) goto L_0x0199
            r6 = -23647808(0xfffffffffe9729c0, float:-1.004651E38)
            r14.startReplaceGroup(r6)
            java.lang.String r6 = "434@16086L1719"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r6)
            androidx.compose.ui.graphics.vector.VectorPath r4 = (androidx.compose.ui.graphics.vector.VectorPath) r4
            java.lang.String r6 = r4.getName()
            java.lang.Object r6 = r5.get(r6)
            androidx.compose.ui.graphics.vector.VectorConfig r6 = (androidx.compose.ui.graphics.vector.VectorConfig) r6
            if (r6 != 0) goto L_0x00a1
            androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$config$1 r6 = new androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$config$1
            r6.<init>()
            androidx.compose.ui.graphics.vector.VectorConfig r6 = (androidx.compose.ui.graphics.vector.VectorConfig) r6
        L_0x00a1:
            androidx.compose.ui.graphics.vector.VectorProperty$PathData r7 = androidx.compose.ui.graphics.vector.VectorProperty.PathData.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r7 = (androidx.compose.ui.graphics.vector.VectorProperty) r7
            java.util.List r8 = r4.getPathData()
            java.lang.Object r7 = r6.getOrDefault(r7, r8)
            java.util.List r7 = (java.util.List) r7
            r8 = r5
            int r5 = r4.m5083getPathFillTypeRgk1Os()
            java.lang.String r9 = r4.getName()
            androidx.compose.ui.graphics.vector.VectorProperty$Fill r10 = androidx.compose.ui.graphics.vector.VectorProperty.Fill.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r10 = (androidx.compose.ui.graphics.vector.VectorProperty) r10
            androidx.compose.ui.graphics.Brush r11 = r4.getFill()
            java.lang.Object r10 = r6.getOrDefault(r10, r11)
            androidx.compose.ui.graphics.Brush r10 = (androidx.compose.ui.graphics.Brush) r10
            androidx.compose.ui.graphics.vector.VectorProperty$FillAlpha r11 = androidx.compose.ui.graphics.vector.VectorProperty.FillAlpha.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r11 = (androidx.compose.ui.graphics.vector.VectorProperty) r11
            float r12 = r4.getFillAlpha()
            java.lang.Float r12 = java.lang.Float.valueOf(r12)
            java.lang.Object r11 = r6.getOrDefault(r11, r12)
            java.lang.Number r11 = (java.lang.Number) r11
            float r11 = r11.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$Stroke r12 = androidx.compose.ui.graphics.vector.VectorProperty.Stroke.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r12 = (androidx.compose.ui.graphics.vector.VectorProperty) r12
            androidx.compose.ui.graphics.Brush r13 = r4.getStroke()
            java.lang.Object r12 = r6.getOrDefault(r12, r13)
            androidx.compose.ui.graphics.Brush r12 = (androidx.compose.ui.graphics.Brush) r12
            androidx.compose.ui.graphics.vector.VectorProperty$StrokeAlpha r13 = androidx.compose.ui.graphics.vector.VectorProperty.StrokeAlpha.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r13 = (androidx.compose.ui.graphics.vector.VectorProperty) r13
            float r15 = r4.getStrokeAlpha()
            java.lang.Float r15 = java.lang.Float.valueOf(r15)
            java.lang.Object r13 = r6.getOrDefault(r13, r15)
            java.lang.Number r13 = (java.lang.Number) r13
            float r13 = r13.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$StrokeLineWidth r15 = androidx.compose.ui.graphics.vector.VectorProperty.StrokeLineWidth.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r15 = (androidx.compose.ui.graphics.vector.VectorProperty) r15
            float r16 = r4.getStrokeLineWidth()
            r23 = r3
            java.lang.Float r3 = java.lang.Float.valueOf(r16)
            java.lang.Object r3 = r6.getOrDefault(r15, r3)
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            r15 = r9
            r9 = r12
            int r12 = r4.m5084getStrokeLineCapKaPHkGw()
            r16 = r4
            r4 = r7
            r7 = r10
            r10 = r13
            int r13 = r16.m5085getStrokeLineJoinLxFBmk8()
            r18 = r14
            float r14 = r16.getStrokeLineMiter()
            androidx.compose.ui.graphics.vector.VectorProperty$TrimPathStart r17 = androidx.compose.ui.graphics.vector.VectorProperty.TrimPathStart.INSTANCE
            r24 = r3
            r3 = r17
            androidx.compose.ui.graphics.vector.VectorProperty r3 = (androidx.compose.ui.graphics.vector.VectorProperty) r3
            float r17 = r16.getTrimPathStart()
            r19 = r4
            java.lang.Float r4 = java.lang.Float.valueOf(r17)
            java.lang.Object r3 = r6.getOrDefault(r3, r4)
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$TrimPathEnd r4 = androidx.compose.ui.graphics.vector.VectorProperty.TrimPathEnd.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r4 = (androidx.compose.ui.graphics.vector.VectorProperty) r4
            float r17 = r16.getTrimPathEnd()
            r20 = r3
            java.lang.Float r3 = java.lang.Float.valueOf(r17)
            java.lang.Object r3 = r6.getOrDefault(r4, r3)
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$TrimPathOffset r4 = androidx.compose.ui.graphics.vector.VectorProperty.TrimPathOffset.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r4 = (androidx.compose.ui.graphics.vector.VectorProperty) r4
            float r16 = r16.getTrimPathOffset()
            r17 = r3
            java.lang.Float r3 = java.lang.Float.valueOf(r16)
            java.lang.Object r3 = r6.getOrDefault(r4, r3)
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            r6 = r15
            r15 = r20
            r20 = 0
            r21 = 0
            r4 = r19
            r19 = 0
            r16 = r17
            r17 = r3
            r3 = r8
            r8 = r11
            r11 = r24
            androidx.compose.ui.graphics.vector.VectorComposeKt.m5065Path9cdaXJ4(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r14 = r18
            r14.endReplaceGroup()
            r5 = r3
            r3 = r23
            goto L_0x0071
        L_0x0199:
            r23 = r3
            r3 = r5
            boolean r5 = r4 instanceof androidx.compose.ui.graphics.vector.VectorGroup
            if (r5 == 0) goto L_0x029b
            r5 = -21815553(0xfffffffffeb31eff, float:-1.1904638E38)
            r14.startReplaceGroup(r5)
            java.lang.String r5 = "513@19224L88,479@17944L1368"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r5)
            r5 = r4
            androidx.compose.ui.graphics.vector.VectorGroup r5 = (androidx.compose.ui.graphics.vector.VectorGroup) r5
            java.lang.String r6 = r5.getName()
            java.lang.Object r6 = r3.get(r6)
            androidx.compose.ui.graphics.vector.VectorConfig r6 = (androidx.compose.ui.graphics.vector.VectorConfig) r6
            if (r6 != 0) goto L_0x01c1
            androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$config$2 r6 = new androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$config$2
            r6.<init>()
            androidx.compose.ui.graphics.vector.VectorConfig r6 = (androidx.compose.ui.graphics.vector.VectorConfig) r6
        L_0x01c1:
            java.lang.String r7 = r5.getName()
            androidx.compose.ui.graphics.vector.VectorProperty$Rotation r8 = androidx.compose.ui.graphics.vector.VectorProperty.Rotation.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r8 = (androidx.compose.ui.graphics.vector.VectorProperty) r8
            float r9 = r5.getRotation()
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            java.lang.Object r8 = r6.getOrDefault(r8, r9)
            java.lang.Number r8 = (java.lang.Number) r8
            float r8 = r8.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$ScaleX r9 = androidx.compose.ui.graphics.vector.VectorProperty.ScaleX.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r9 = (androidx.compose.ui.graphics.vector.VectorProperty) r9
            float r10 = r5.getScaleX()
            java.lang.Float r10 = java.lang.Float.valueOf(r10)
            java.lang.Object r9 = r6.getOrDefault(r9, r10)
            java.lang.Number r9 = (java.lang.Number) r9
            float r9 = r9.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$ScaleY r10 = androidx.compose.ui.graphics.vector.VectorProperty.ScaleY.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r10 = (androidx.compose.ui.graphics.vector.VectorProperty) r10
            float r11 = r5.getScaleY()
            java.lang.Float r11 = java.lang.Float.valueOf(r11)
            java.lang.Object r10 = r6.getOrDefault(r10, r11)
            java.lang.Number r10 = (java.lang.Number) r10
            float r10 = r10.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$TranslateX r11 = androidx.compose.ui.graphics.vector.VectorProperty.TranslateX.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r11 = (androidx.compose.ui.graphics.vector.VectorProperty) r11
            float r12 = r5.getTranslationX()
            java.lang.Float r12 = java.lang.Float.valueOf(r12)
            java.lang.Object r11 = r6.getOrDefault(r11, r12)
            java.lang.Number r11 = (java.lang.Number) r11
            float r11 = r11.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$TranslateY r12 = androidx.compose.ui.graphics.vector.VectorProperty.TranslateY.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r12 = (androidx.compose.ui.graphics.vector.VectorProperty) r12
            float r13 = r5.getTranslationY()
            java.lang.Float r13 = java.lang.Float.valueOf(r13)
            java.lang.Object r12 = r6.getOrDefault(r12, r13)
            java.lang.Number r12 = (java.lang.Number) r12
            float r12 = r12.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$PivotX r13 = androidx.compose.ui.graphics.vector.VectorProperty.PivotX.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r13 = (androidx.compose.ui.graphics.vector.VectorProperty) r13
            float r15 = r5.getPivotX()
            java.lang.Float r15 = java.lang.Float.valueOf(r15)
            java.lang.Object r13 = r6.getOrDefault(r13, r15)
            java.lang.Number r13 = (java.lang.Number) r13
            float r13 = r13.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$PivotY r15 = androidx.compose.ui.graphics.vector.VectorProperty.PivotY.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r15 = (androidx.compose.ui.graphics.vector.VectorProperty) r15
            float r16 = r5.getPivotY()
            r24 = r5
            java.lang.Float r5 = java.lang.Float.valueOf(r16)
            java.lang.Object r5 = r6.getOrDefault(r15, r5)
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$PathData r15 = androidx.compose.ui.graphics.vector.VectorProperty.PathData.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r15 = (androidx.compose.ui.graphics.vector.VectorProperty) r15
            r16 = r5
            java.util.List r5 = r24.getClipPathData()
            java.lang.Object r5 = r6.getOrDefault(r15, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$1 r6 = new androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$1
            r6.<init>(r4, r3)
            r4 = 54
            r15 = 1450046638(0x566df4ae, float:6.5408787E13)
            r17 = r3
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r15, r3, r6, r14, r4)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r15 = 805306368(0x30000000, float:4.656613E-10)
            r4 = r7
            r7 = r16
            r16 = 0
            r6 = r12
            r12 = r5
            r5 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r6
            r6 = r13
            r13 = r3
            androidx.compose.ui.graphics.vector.VectorComposeKt.Group(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r14.endReplaceGroup()
            goto L_0x02a6
        L_0x029b:
            r17 = r3
            r3 = -20402883(0xfffffffffec8ad3d, float:-1.3337255E38)
            r14.startReplaceGroup(r3)
            r14.endReplaceGroup()
        L_0x02a6:
            r3 = r23
            r5 = r17
            goto L_0x0071
        L_0x02ac:
            r17 = r5
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x02b7
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02b7:
            r6 = r17
        L_0x02b9:
            androidx.compose.runtime.ScopeUpdateScope r3 = r14.endRestartGroup()
            if (r3 == 0) goto L_0x02c9
            androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$2 r4 = new androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$2
            r4.<init>(r0, r6, r1, r2)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r3.updateScope(r4)
        L_0x02c9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.VectorPainterKt.RenderVectorGroup(androidx.compose.ui.graphics.vector.VectorGroup, java.util.Map, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final void mirror(DrawScope drawScope, Function1<? super DrawScope, Unit> function1) {
        long r0 = drawScope.m4864getCenterF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long r3 = drawContext.m4806getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().m4930scale0AR0LA0(-1.0f, 1.0f, r0);
            function1.invoke(drawScope);
        } finally {
            drawContext.getCanvas().restore();
            drawContext.m4807setSizeuvyYCjk(r3);
        }
    }
}
