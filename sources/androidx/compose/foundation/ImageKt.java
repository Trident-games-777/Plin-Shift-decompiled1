package androidx.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.BitmapPainterKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.ContentScale;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001ab\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0017\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u001a\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Image", "", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "Image-5h-nEew", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;II)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Image.kt */
public final class ImageKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Consider usage of the Image composable that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "Image(bitmap, contentDescription, modifier, alignment, contentScale, alpha, colorFilter, DefaultFilterQuality)", imports = {"androidx.compose.foundation", "androidx.compose.ui.graphics.DefaultAlpha", "androidx.compose.ui.Alignment", "androidx.compose.ui.graphics.drawscope.DrawScope.Companion.DefaultFilterQuality", "androidx.compose.ui.layout.ContentScale.Fit"}))
    public static final /* synthetic */ void Image(ImageBitmap imageBitmap, String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, Composer composer, int i, int i2) {
        int i3 = i;
        Composer composer2 = composer;
        ComposerKt.sourceInformationMarkerStart(composer2, -2123228673, "C(Image)P(2,4,6!1,5)96@4585L177:Image.kt#71ulvw");
        Modifier modifier2 = (i2 & 4) != 0 ? Modifier.Companion : modifier;
        Alignment center = (i2 & 8) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i2 & 16) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f2 = (i2 & 32) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i2 & 64) != 0 ? null : colorFilter;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2123228673, i3, -1, "androidx.compose.foundation.Image (Image.kt:95)");
        }
        m307Image5hnEew(imageBitmap, str, modifier2, center, fit, f2, colorFilter2, FilterQuality.Companion.m4340getLowfv9h1I(), composer2, i3 & 4194302, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* renamed from: Image-5h-nEew  reason: not valid java name */
    public static final void m307Image5hnEew(ImageBitmap imageBitmap, String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, Composer composer, int i2, int i3) {
        Composer composer2 = composer;
        int i4 = i2;
        int i5 = i3;
        ComposerKt.sourceInformationMarkerStart(composer2, -1396260732, "C(Image)P(2,4,7!1,5!,6:c#ui.graphics.FilterQuality)153@7224L73,154@7302L248:Image.kt#71ulvw");
        Modifier modifier2 = (i5 & 4) != 0 ? Modifier.Companion : modifier;
        Alignment center = (i5 & 8) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i5 & 16) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f2 = (i5 & 32) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i5 & 64) != 0 ? null : colorFilter;
        int r14 = (i5 & 128) != 0 ? DrawScope.Companion.m4868getDefaultFilterQualityfv9h1I() : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1396260732, i4, -1, "androidx.compose.foundation.Image (Image.kt:152)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 449057418, "CC(remember):Image.kt#9igjgp");
        ImageBitmap imageBitmap2 = imageBitmap;
        boolean changed = composer2.changed((Object) imageBitmap2);
        Object rememberedValue = composer2.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = BitmapPainterKt.m5038BitmapPainterQZhYCtY$default(imageBitmap2, 0, 0, r14, 6, (Object) null);
            composer2.updateRememberedValue(rememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        Image((BitmapPainter) rememberedValue, str, modifier2, center, fit, f2, colorFilter2, composer2, i4 & 4194288, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    public static final void Image(ImageVector imageVector, String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i;
        ComposerKt.sourceInformationMarkerStart(composer2, 1595907091, "C(Image)P(5,3,6!1,4)198@9330L34,197@9309L237:Image.kt#71ulvw");
        if ((i2 & 4) != 0) {
            modifier = Modifier.Companion;
        }
        if ((i2 & 8) != 0) {
            alignment = Alignment.Companion.getCenter();
        }
        Alignment alignment2 = alignment;
        if ((i2 & 16) != 0) {
            contentScale = ContentScale.Companion.getFit();
        }
        ContentScale contentScale2 = contentScale;
        if ((i2 & 32) != 0) {
            f = 1.0f;
        }
        float f2 = f;
        ColorFilter colorFilter2 = (i2 & 64) != 0 ? null : colorFilter;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1595907091, i3, -1, "androidx.compose.foundation.Image (Image.kt:197)");
        }
        Image(VectorPainterKt.rememberVectorPainter(imageVector, composer2, i3 & 14), str, modifier, alignment2, contentScale2, f2, colorFilter2, composer2, VectorPainter.$stable | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX WARNING: Removed duplicated region for block: B:127:0x0232  */
    /* JADX WARNING: Removed duplicated region for block: B:129:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Image(androidx.compose.ui.graphics.painter.Painter r18, java.lang.String r19, androidx.compose.ui.Modifier r20, androidx.compose.ui.Alignment r21, androidx.compose.ui.layout.ContentScale r22, float r23, androidx.compose.ui.graphics.ColorFilter r24, androidx.compose.runtime.Composer r25, int r26, int r27) {
        /*
            r2 = r19
            r8 = r26
            r0 = 1142754848(0x441d0e20, float:628.2207)
            r1 = r25
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r3 = "C(Image)P(6,3,5!1,4)255@11931L329:Image.kt#71ulvw"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = r27 & 1
            if (r3 == 0) goto L_0x001b
            r3 = r8 | 6
            r10 = r18
            goto L_0x002d
        L_0x001b:
            r3 = r8 & 6
            r10 = r18
            if (r3 != 0) goto L_0x002c
            boolean r3 = r1.changedInstance(r10)
            if (r3 == 0) goto L_0x0029
            r3 = 4
            goto L_0x002a
        L_0x0029:
            r3 = 2
        L_0x002a:
            r3 = r3 | r8
            goto L_0x002d
        L_0x002c:
            r3 = r8
        L_0x002d:
            r4 = r27 & 2
            if (r4 == 0) goto L_0x0034
            r3 = r3 | 48
            goto L_0x0044
        L_0x0034:
            r4 = r8 & 48
            if (r4 != 0) goto L_0x0044
            boolean r4 = r1.changed((java.lang.Object) r2)
            if (r4 == 0) goto L_0x0041
            r4 = 32
            goto L_0x0043
        L_0x0041:
            r4 = 16
        L_0x0043:
            r3 = r3 | r4
        L_0x0044:
            r4 = r27 & 4
            if (r4 == 0) goto L_0x004b
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x005e
        L_0x004b:
            r6 = r8 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x005e
            r6 = r20
            boolean r7 = r1.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x005a
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005c
        L_0x005a:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005c:
            r3 = r3 | r7
            goto L_0x0060
        L_0x005e:
            r6 = r20
        L_0x0060:
            r7 = r27 & 8
            if (r7 == 0) goto L_0x0067
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007a
        L_0x0067:
            r9 = r8 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x007a
            r9 = r21
            boolean r11 = r1.changed((java.lang.Object) r9)
            if (r11 == 0) goto L_0x0076
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0078
        L_0x0076:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0078:
            r3 = r3 | r11
            goto L_0x007c
        L_0x007a:
            r9 = r21
        L_0x007c:
            r11 = r27 & 16
            if (r11 == 0) goto L_0x0083
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0096
        L_0x0083:
            r12 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x0096
            r12 = r22
            boolean r13 = r1.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x0092
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0094
        L_0x0092:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0094:
            r3 = r3 | r13
            goto L_0x0098
        L_0x0096:
            r12 = r22
        L_0x0098:
            r13 = r27 & 32
            r14 = 196608(0x30000, float:2.75506E-40)
            if (r13 == 0) goto L_0x00a0
            r3 = r3 | r14
            goto L_0x00b2
        L_0x00a0:
            r14 = r14 & r8
            if (r14 != 0) goto L_0x00b2
            r14 = r23
            boolean r15 = r1.changed((float) r14)
            if (r15 == 0) goto L_0x00ae
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b0
        L_0x00ae:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b0:
            r3 = r3 | r15
            goto L_0x00b4
        L_0x00b2:
            r14 = r23
        L_0x00b4:
            r15 = r27 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00bf
            r3 = r3 | r16
            r5 = r24
            goto L_0x00d2
        L_0x00bf:
            r16 = r8 & r16
            r5 = r24
            if (r16 != 0) goto L_0x00d2
            boolean r16 = r1.changed((java.lang.Object) r5)
            if (r16 == 0) goto L_0x00ce
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d0
        L_0x00ce:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d0:
            r3 = r3 | r16
        L_0x00d2:
            r16 = 599187(0x92493, float:8.3964E-40)
            r0 = r3 & r16
            r16 = r4
            r4 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r4) goto L_0x00ef
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x00e5
            goto L_0x00ef
        L_0x00e5:
            r1.skipToGroupEnd()
            r7 = r5
            r4 = r9
            r5 = r12
        L_0x00eb:
            r3 = r6
            r6 = r14
            goto L_0x022c
        L_0x00ef:
            if (r16 == 0) goto L_0x00f6
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r6 = r0
        L_0x00f6:
            if (r7 == 0) goto L_0x00ff
            androidx.compose.ui.Alignment$Companion r0 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r0 = r0.getCenter()
            r9 = r0
        L_0x00ff:
            if (r11 == 0) goto L_0x0108
            androidx.compose.ui.layout.ContentScale$Companion r0 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r0 = r0.getFit()
            r12 = r0
        L_0x0108:
            if (r13 == 0) goto L_0x010d
            r0 = 1065353216(0x3f800000, float:1.0)
            r14 = r0
        L_0x010d:
            r0 = 0
            if (r15 == 0) goto L_0x0112
            r15 = r0
            goto L_0x0113
        L_0x0112:
            r15 = r5
        L_0x0113:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0122
            r4 = -1
            java.lang.String r5 = "androidx.compose.foundation.Image (Image.kt:243)"
            r7 = 1142754848(0x441d0e20, float:628.2207)
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r3, r4, r5)
        L_0x0122:
            r4 = 0
            if (r2 == 0) goto L_0x016c
            r5 = 1040258775(0x3e0116d7, float:0.12606369)
            r1.startReplaceGroup(r5)
            java.lang.String r5 = "245@11667L103"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r5)
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            r7 = 449199624(0x1ac63e08, float:8.19911E-23)
            java.lang.String r11 = "CC(remember):Image.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r7, r11)
            r3 = r3 & 112(0x70, float:1.57E-43)
            r7 = 1
            r11 = 32
            if (r3 != r11) goto L_0x0145
            r3 = r7
            goto L_0x0146
        L_0x0145:
            r3 = r4
        L_0x0146:
            java.lang.Object r11 = r1.rememberedValue()
            if (r3 != 0) goto L_0x0154
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r11 != r3) goto L_0x015f
        L_0x0154:
            androidx.compose.foundation.ImageKt$Image$semantics$1$1 r3 = new androidx.compose.foundation.ImageKt$Image$semantics$1$1
            r3.<init>(r2)
            r11 = r3
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            r1.updateRememberedValue(r11)
        L_0x015f:
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r5, r4, r11, r7, r0)
            r1.endReplaceGroup()
            goto L_0x0179
        L_0x016c:
            r0 = 1040398089(0x3e033709, float:0.12813963)
            r1.startReplaceGroup(r0)
            r1.endReplaceGroup()
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
        L_0x0179:
            androidx.compose.ui.Modifier r0 = r6.then(r0)
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.draw.ClipKt.clipToBounds(r0)
            r16 = 2
            r17 = 0
            r11 = 0
            r13 = r12
            r12 = r9
            r9 = r0
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.draw.PainterModifierKt.paint$default(r9, r10, r11, r12, r13, r14, r15, r16, r17)
            androidx.compose.foundation.ImageKt$Image$1 r3 = androidx.compose.foundation.ImageKt$Image$1.INSTANCE
            androidx.compose.ui.layout.MeasurePolicy r3 = (androidx.compose.ui.layout.MeasurePolicy) r3
            r5 = 544976794(0x207baf9a, float:2.1318629E-19)
            java.lang.String r7 = "CC(Layout)P(1)125@4862L23,128@5013L385:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r5, r7)
            int r4 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r1, r4)
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r1, r0)
            androidx.compose.runtime.CompositionLocalMap r5 = r1.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r7 = r7.getConstructor()
            r9 = 1405779621(0x53ca7ea5, float:1.73941627E12)
            java.lang.String r10 = "CC(ReusableComposeNode):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r9, r10)
            androidx.compose.runtime.Applier r9 = r1.getApplier()
            boolean r9 = r9 instanceof androidx.compose.runtime.Applier
            if (r9 != 0) goto L_0x01be
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01be:
            r1.startReusableNode()
            boolean r9 = r1.getInserting()
            if (r9 == 0) goto L_0x01cb
            r1.createNode(r7)
            goto L_0x01ce
        L_0x01cb:
            r1.useNode()
        L_0x01ce:
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.Updater.m3675constructorimpl(r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r7, r3, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r7, r5, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r7, r0, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetCompositeKeyHash()
            boolean r3 = r7.getInserting()
            if (r3 != 0) goto L_0x0207
            java.lang.Object r3 = r7.rememberedValue()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 != 0) goto L_0x0215
        L_0x0207:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            r7.updateRememberedValue(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            r7.apply(r3, r0)
        L_0x0215:
            r1.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0227
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0227:
            r4 = r12
            r5 = r13
            r7 = r15
            goto L_0x00eb
        L_0x022c:
            androidx.compose.runtime.ScopeUpdateScope r10 = r1.endRestartGroup()
            if (r10 == 0) goto L_0x0240
            androidx.compose.foundation.ImageKt$Image$2 r0 = new androidx.compose.foundation.ImageKt$Image$2
            r1 = r18
            r9 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x0240:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.ImageKt.Image(androidx.compose.ui.graphics.painter.Painter, java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.Alignment, androidx.compose.ui.layout.ContentScale, float, androidx.compose.ui.graphics.ColorFilter, androidx.compose.runtime.Composer, int, int):void");
    }
}
