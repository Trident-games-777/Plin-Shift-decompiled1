package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.IconButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a3\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0010\u001a8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0011\u001a8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0014\u001a\u0014\u0010\u0015\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\u0014\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\u0016\u0010\u0017\u001a\u00020\u0018*\u00020\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"DefaultIconSizeModifier", "Landroidx/compose/ui/Modifier;", "Icon", "", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "contentDescription", "", "modifier", "tint", "Landroidx/compose/ui/graphics/Color;", "Icon-ww6aTOc", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/ui/graphics/ColorProducer;", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/ColorProducer;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "defaultSizeFor", "defaultSizeForColorProducer", "isInfinite", "", "Landroidx/compose/ui/geometry/Size;", "isInfinite-uvyYCjk", "(J)Z", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Icon.kt */
public final class IconKt {
    private static final Modifier DefaultIconSizeModifier = SizeKt.m845size3ABfNKs(Modifier.Companion, IconButtonTokens.INSTANCE.m3312getIconSizeD9Ej5fM());

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /* renamed from: Icon-ww6aTOc  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2124Iconww6aTOc(androidx.compose.ui.graphics.vector.ImageVector r15, java.lang.String r16, androidx.compose.ui.Modifier r17, long r18, androidx.compose.runtime.Composer r20, int r21, int r22) {
        /*
            r6 = r21
            r0 = -126890956(0xfffffffff86fcc34, float:-1.9454698E34)
            r1 = r20
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Icon)P(1!,3:c#ui.graphics.Color)69@3394L7,72@3434L34,71@3410L163:Icon.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r22 & 1
            if (r1 == 0) goto L_0x0017
            r1 = r6 | 6
            goto L_0x0027
        L_0x0017:
            r1 = r6 & 6
            if (r1 != 0) goto L_0x0026
            boolean r1 = r12.changed((java.lang.Object) r15)
            if (r1 == 0) goto L_0x0023
            r1 = 4
            goto L_0x0024
        L_0x0023:
            r1 = 2
        L_0x0024:
            r1 = r1 | r6
            goto L_0x0027
        L_0x0026:
            r1 = r6
        L_0x0027:
            r2 = r22 & 2
            if (r2 == 0) goto L_0x0030
            r1 = r1 | 48
            r8 = r16
            goto L_0x0042
        L_0x0030:
            r2 = r6 & 48
            r8 = r16
            if (r2 != 0) goto L_0x0042
            boolean r2 = r12.changed((java.lang.Object) r8)
            if (r2 == 0) goto L_0x003f
            r2 = 32
            goto L_0x0041
        L_0x003f:
            r2 = 16
        L_0x0041:
            r1 = r1 | r2
        L_0x0042:
            r2 = r22 & 4
            if (r2 == 0) goto L_0x0049
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x005c
        L_0x0049:
            r3 = r6 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x005c
            r3 = r17
            boolean r4 = r12.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0058
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x005a
        L_0x0058:
            r4 = 128(0x80, float:1.794E-43)
        L_0x005a:
            r1 = r1 | r4
            goto L_0x005e
        L_0x005c:
            r3 = r17
        L_0x005e:
            r4 = r6 & 3072(0xc00, float:4.305E-42)
            if (r4 != 0) goto L_0x0077
            r4 = r22 & 8
            if (r4 != 0) goto L_0x0071
            r4 = r18
            boolean r7 = r12.changed((long) r4)
            if (r7 == 0) goto L_0x0073
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0075
        L_0x0071:
            r4 = r18
        L_0x0073:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0075:
            r1 = r1 | r7
            goto L_0x0079
        L_0x0077:
            r4 = r18
        L_0x0079:
            r7 = r1 & 1171(0x493, float:1.641E-42)
            r9 = 1170(0x492, float:1.64E-42)
            if (r7 != r9) goto L_0x008b
            boolean r7 = r12.getSkipping()
            if (r7 != 0) goto L_0x0086
            goto L_0x008b
        L_0x0086:
            r12.skipToGroupEnd()
            goto L_0x0105
        L_0x008b:
            r12.startDefaults()
            r7 = r6 & 1
            if (r7 == 0) goto L_0x00a4
            boolean r7 = r12.getDefaultsInvalid()
            if (r7 == 0) goto L_0x0099
            goto L_0x00a4
        L_0x0099:
            r12.skipToGroupEnd()
            r2 = r22 & 8
            if (r2 == 0) goto L_0x00a2
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00a2:
            r9 = r3
            goto L_0x00d1
        L_0x00a4:
            if (r2 == 0) goto L_0x00ab
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x00ac
        L_0x00ab:
            r2 = r3
        L_0x00ac:
            r3 = r22 & 8
            if (r3 == 0) goto L_0x00d0
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.material3.ContentColorKt.getLocalContentColor()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r5 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r4, r5)
            java.lang.Object r3 = r12.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.ui.graphics.Color r3 = (androidx.compose.ui.graphics.Color) r3
            long r3 = r3.m4249unboximpl()
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r9 = r2
            r10 = r3
            goto L_0x00d2
        L_0x00d0:
            r9 = r2
        L_0x00d1:
            r10 = r4
        L_0x00d2:
            r12.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x00e1
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.Icon (Icon.kt:70)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r2, r3)
        L_0x00e1:
            r0 = r1 & 14
            androidx.compose.ui.graphics.vector.VectorPainter r0 = androidx.compose.ui.graphics.vector.VectorPainterKt.rememberVectorPainter(r15, r12, r0)
            r7 = r0
            androidx.compose.ui.graphics.painter.Painter r7 = (androidx.compose.ui.graphics.painter.Painter) r7
            int r0 = androidx.compose.ui.graphics.vector.VectorPainter.$stable
            r2 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            r2 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r13 = r0 | r1
            r14 = 0
            m2123Iconww6aTOc((androidx.compose.ui.graphics.painter.Painter) r7, (java.lang.String) r8, (androidx.compose.ui.Modifier) r9, (long) r10, (androidx.compose.runtime.Composer) r12, (int) r13, (int) r14)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0103
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0103:
            r3 = r9
            r4 = r10
        L_0x0105:
            androidx.compose.runtime.ScopeUpdateScope r8 = r12.endRestartGroup()
            if (r8 == 0) goto L_0x011a
            androidx.compose.material3.IconKt$Icon$1 r0 = new androidx.compose.material3.IconKt$Icon$1
            r1 = r15
            r2 = r16
            r7 = r22
            r0.<init>(r1, r2, r3, r4, r6, r7)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r8.updateScope(r0)
        L_0x011a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.IconKt.m2124Iconww6aTOc(androidx.compose.ui.graphics.vector.ImageVector, java.lang.String, androidx.compose.ui.Modifier, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /* renamed from: Icon-ww6aTOc  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2122Iconww6aTOc(androidx.compose.ui.graphics.ImageBitmap r17, java.lang.String r18, androidx.compose.ui.Modifier r19, long r20, androidx.compose.runtime.Composer r22, int r23, int r24) {
        /*
            r1 = r17
            r8 = r23
            r0 = -1092052280(0xffffffffbee89ac8, float:-0.4543059)
            r2 = r22
            androidx.compose.runtime.Composer r14 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(Icon)P(!,3:c#ui.graphics.Color)105@5106L7,107@5136L42,108@5183L136:Icon.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r2)
            r2 = r24 & 1
            if (r2 == 0) goto L_0x0019
            r2 = r8 | 6
            goto L_0x0029
        L_0x0019:
            r2 = r8 & 6
            if (r2 != 0) goto L_0x0028
            boolean r2 = r14.changedInstance(r1)
            if (r2 == 0) goto L_0x0025
            r2 = 4
            goto L_0x0026
        L_0x0025:
            r2 = 2
        L_0x0026:
            r2 = r2 | r8
            goto L_0x0029
        L_0x0028:
            r2 = r8
        L_0x0029:
            r3 = r24 & 2
            if (r3 == 0) goto L_0x0032
            r2 = r2 | 48
            r10 = r18
            goto L_0x0044
        L_0x0032:
            r3 = r8 & 48
            r10 = r18
            if (r3 != 0) goto L_0x0044
            boolean r3 = r14.changed((java.lang.Object) r10)
            if (r3 == 0) goto L_0x0041
            r3 = 32
            goto L_0x0043
        L_0x0041:
            r3 = 16
        L_0x0043:
            r2 = r2 | r3
        L_0x0044:
            r3 = r24 & 4
            if (r3 == 0) goto L_0x004b
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x005e
        L_0x004b:
            r4 = r8 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x005e
            r4 = r19
            boolean r5 = r14.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x005a
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x005c
        L_0x005a:
            r5 = 128(0x80, float:1.794E-43)
        L_0x005c:
            r2 = r2 | r5
            goto L_0x0060
        L_0x005e:
            r4 = r19
        L_0x0060:
            r5 = r8 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x0079
            r5 = r24 & 8
            if (r5 != 0) goto L_0x0073
            r5 = r20
            boolean r7 = r14.changed((long) r5)
            if (r7 == 0) goto L_0x0075
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0077
        L_0x0073:
            r5 = r20
        L_0x0075:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0077:
            r2 = r2 | r7
            goto L_0x007b
        L_0x0079:
            r5 = r20
        L_0x007b:
            r7 = r2 & 1171(0x493, float:1.641E-42)
            r9 = 1170(0x492, float:1.64E-42)
            if (r7 != r9) goto L_0x008f
            boolean r7 = r14.getSkipping()
            if (r7 != 0) goto L_0x0088
            goto L_0x008f
        L_0x0088:
            r14.skipToGroupEnd()
            r3 = r4
            r4 = r5
            goto L_0x012b
        L_0x008f:
            r14.startDefaults()
            r7 = r8 & 1
            if (r7 == 0) goto L_0x00a9
            boolean r7 = r14.getDefaultsInvalid()
            if (r7 == 0) goto L_0x009d
            goto L_0x00a9
        L_0x009d:
            r14.skipToGroupEnd()
            r3 = r24 & 8
            if (r3 == 0) goto L_0x00a6
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00a6:
            r9 = r2
            r11 = r4
            goto L_0x00d8
        L_0x00a9:
            if (r3 == 0) goto L_0x00b0
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x00b1
        L_0x00b0:
            r3 = r4
        L_0x00b1:
            r4 = r24 & 8
            if (r4 == 0) goto L_0x00d6
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.material3.ContentColorKt.getLocalContentColor()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r6 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r5, r6)
            java.lang.Object r4 = r14.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.graphics.Color r4 = (androidx.compose.ui.graphics.Color) r4
            long r4 = r4.m4249unboximpl()
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
            r9 = r2
            r11 = r3
            r12 = r4
            goto L_0x00d9
        L_0x00d6:
            r9 = r2
            r11 = r3
        L_0x00d8:
            r12 = r5
        L_0x00d9:
            r14.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x00e8
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.Icon (Icon.kt:106)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r9, r2, r3)
        L_0x00e8:
            r0 = -2144951290(0xffffffff8026a406, float:-3.54859E-39)
            java.lang.String r2 = "CC(remember):Icon.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r0, r2)
            boolean r0 = r14.changed((java.lang.Object) r1)
            java.lang.Object r2 = r14.rememberedValue()
            if (r0 != 0) goto L_0x0102
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r2 != r0) goto L_0x0111
        L_0x0102:
            androidx.compose.ui.graphics.painter.BitmapPainter r0 = new androidx.compose.ui.graphics.painter.BitmapPainter
            r6 = 6
            r7 = 0
            r2 = 0
            r4 = 0
            r0.<init>(r1, r2, r4, r6, r7)
            r14.updateRememberedValue(r0)
            r2 = r0
        L_0x0111:
            androidx.compose.ui.graphics.painter.BitmapPainter r2 = (androidx.compose.ui.graphics.painter.BitmapPainter) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.graphics.painter.Painter r2 = (androidx.compose.ui.graphics.painter.Painter) r2
            r15 = r9 & 8176(0x1ff0, float:1.1457E-41)
            r16 = 0
            r9 = r2
            m2123Iconww6aTOc((androidx.compose.ui.graphics.painter.Painter) r9, (java.lang.String) r10, (androidx.compose.ui.Modifier) r11, (long) r12, (androidx.compose.runtime.Composer) r14, (int) r15, (int) r16)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0129
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0129:
            r3 = r11
            r4 = r12
        L_0x012b:
            androidx.compose.runtime.ScopeUpdateScope r9 = r14.endRestartGroup()
            if (r9 == 0) goto L_0x0142
            androidx.compose.material3.IconKt$Icon$2 r0 = new androidx.compose.material3.IconKt$Icon$2
            r1 = r17
            r2 = r18
            r7 = r24
            r6 = r8
            r0.<init>(r1, r2, r3, r4, r6, r7)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x0142:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.IconKt.m2122Iconww6aTOc(androidx.compose.ui.graphics.ImageBitmap, java.lang.String, androidx.compose.ui.Modifier, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008d  */
    /* renamed from: Icon-ww6aTOc  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2123Iconww6aTOc(androidx.compose.ui.graphics.painter.Painter r19, java.lang.String r20, androidx.compose.ui.Modifier r21, long r22, androidx.compose.runtime.Composer r24, int r25, int r26) {
        /*
            r1 = r19
            r9 = r20
            r10 = r25
            r0 = -2142239481(0xffffffff80500507, float:-7.348643E-39)
            r2 = r24
            androidx.compose.runtime.Composer r11 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(Icon)P(2!,3:c#ui.graphics.Color)142@6849L7,145@6891L82,155@7235L217:Icon.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r2)
            r2 = r26 & 1
            if (r2 == 0) goto L_0x001b
            r2 = r10 | 6
            goto L_0x002b
        L_0x001b:
            r2 = r10 & 6
            if (r2 != 0) goto L_0x002a
            boolean r2 = r11.changedInstance(r1)
            if (r2 == 0) goto L_0x0027
            r2 = 4
            goto L_0x0028
        L_0x0027:
            r2 = 2
        L_0x0028:
            r2 = r2 | r10
            goto L_0x002b
        L_0x002a:
            r2 = r10
        L_0x002b:
            r3 = r26 & 2
            r4 = 32
            if (r3 == 0) goto L_0x0034
            r2 = r2 | 48
            goto L_0x0043
        L_0x0034:
            r3 = r10 & 48
            if (r3 != 0) goto L_0x0043
            boolean r3 = r11.changed((java.lang.Object) r9)
            if (r3 == 0) goto L_0x0040
            r3 = r4
            goto L_0x0042
        L_0x0040:
            r3 = 16
        L_0x0042:
            r2 = r2 | r3
        L_0x0043:
            r3 = r26 & 4
            if (r3 == 0) goto L_0x004a
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x005d
        L_0x004a:
            r5 = r10 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x005d
            r5 = r21
            boolean r6 = r11.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0059
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005b
        L_0x0059:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005b:
            r2 = r2 | r6
            goto L_0x005f
        L_0x005d:
            r5 = r21
        L_0x005f:
            r6 = r10 & 3072(0xc00, float:4.305E-42)
            r7 = 2048(0x800, float:2.87E-42)
            if (r6 != 0) goto L_0x0077
            r6 = r26 & 8
            r12 = r22
            if (r6 != 0) goto L_0x0073
            boolean r6 = r11.changed((long) r12)
            if (r6 == 0) goto L_0x0073
            r6 = r7
            goto L_0x0075
        L_0x0073:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x0075:
            r2 = r2 | r6
            goto L_0x0079
        L_0x0077:
            r12 = r22
        L_0x0079:
            r6 = r2 & 1171(0x493, float:1.641E-42)
            r8 = 1170(0x492, float:1.64E-42)
            if (r6 != r8) goto L_0x008d
            boolean r6 = r11.getSkipping()
            if (r6 != 0) goto L_0x0086
            goto L_0x008d
        L_0x0086:
            r11.skipToGroupEnd()
            r3 = r5
            r4 = r12
            goto L_0x01ae
        L_0x008d:
            r11.startDefaults()
            r6 = r10 & 1
            if (r6 == 0) goto L_0x00a7
            boolean r6 = r11.getDefaultsInvalid()
            if (r6 == 0) goto L_0x009b
            goto L_0x00a7
        L_0x009b:
            r11.skipToGroupEnd()
            r3 = r26 & 8
            if (r3 == 0) goto L_0x00a4
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00a4:
            r14 = r12
            r12 = r5
            goto L_0x00d5
        L_0x00a7:
            if (r3 == 0) goto L_0x00ae
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x00af
        L_0x00ae:
            r3 = r5
        L_0x00af:
            r5 = r26 & 8
            if (r5 == 0) goto L_0x00d3
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.material3.ContentColorKt.getLocalContentColor()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r8 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r6, r8)
            java.lang.Object r5 = r11.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.graphics.Color r5 = (androidx.compose.ui.graphics.Color) r5
            long r5 = r5.m4249unboximpl()
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
            r12 = r3
            r14 = r5
            goto L_0x00d5
        L_0x00d3:
            r14 = r12
            r12 = r3
        L_0x00d5:
            r11.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x00e4
            r3 = -1
            java.lang.String r5 = "androidx.compose.material3.Icon (Icon.kt:143)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r3, r5)
        L_0x00e4:
            r0 = -2144895090(0xffffffff80277f8e, float:-3.627342E-39)
            java.lang.String r3 = "CC(remember):Icon.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r0, r3)
            r0 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 ^ 3072(0xc00, float:4.305E-42)
            if (r0 <= r7) goto L_0x00f8
            boolean r0 = r11.changed((long) r14)
            if (r0 != 0) goto L_0x00fc
        L_0x00f8:
            r0 = r2 & 3072(0xc00, float:4.305E-42)
            if (r0 != r7) goto L_0x00fe
        L_0x00fc:
            r0 = 1
            goto L_0x00ff
        L_0x00fe:
            r0 = 0
        L_0x00ff:
            java.lang.Object r7 = r11.rememberedValue()
            r8 = 0
            if (r0 != 0) goto L_0x010e
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r7 != r0) goto L_0x012c
        L_0x010e:
            androidx.compose.ui.graphics.Color$Companion r0 = androidx.compose.ui.graphics.Color.Companion
            long r5 = r0.m4275getUnspecified0d7_KjU()
            boolean r0 = androidx.compose.ui.graphics.Color.m4240equalsimpl0(r14, r5)
            if (r0 == 0) goto L_0x011c
            r7 = r8
            goto L_0x0129
        L_0x011c:
            androidx.compose.ui.graphics.ColorFilter$Companion r13 = androidx.compose.ui.graphics.ColorFilter.Companion
            r17 = 2
            r18 = 0
            r16 = 0
            androidx.compose.ui.graphics.ColorFilter r0 = androidx.compose.ui.graphics.ColorFilter.Companion.m4280tintxETnrds$default(r13, r14, r16, r17, r18)
            r7 = r0
        L_0x0129:
            r11.updateRememberedValue(r7)
        L_0x012c:
            r6 = r7
            androidx.compose.ui.graphics.ColorFilter r6 = (androidx.compose.ui.graphics.ColorFilter) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r0 = -2144891392(0xffffffff80278e00, float:-3.632524E-39)
            r11.startReplaceGroup(r0)
            java.lang.String r0 = "148@7067L115"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
            if (r9 == 0) goto L_0x0175
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r5 = -2144889425(0xffffffff802795af, float:-3.635281E-39)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r5, r3)
            r2 = r2 & 112(0x70, float:1.57E-43)
            if (r2 != r4) goto L_0x014f
            r2 = 1
            goto L_0x0150
        L_0x014f:
            r2 = 0
        L_0x0150:
            java.lang.Object r3 = r11.rememberedValue()
            if (r2 != 0) goto L_0x015e
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x0169
        L_0x015e:
            androidx.compose.material3.IconKt$Icon$semantics$1$1 r2 = new androidx.compose.material3.IconKt$Icon$semantics$1$1
            r2.<init>(r9)
            r3 = r2
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r11.updateRememberedValue(r3)
        L_0x0169:
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r2 = 0
            r4 = 1
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r0, r2, r3, r4, r8)
            goto L_0x017a
        L_0x0175:
            r2 = 0
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
        L_0x017a:
            r13 = r0
            r11.endReplaceGroup()
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.graphics.GraphicsLayerModifierKt.toolingGraphicsLayer(r12)
            androidx.compose.ui.Modifier r0 = defaultSizeFor(r0, r1)
            androidx.compose.ui.layout.ContentScale$Companion r3 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r4 = r3.getFit()
            r7 = 22
            r8 = 0
            r3 = r2
            r2 = 0
            r5 = r3
            r3 = 0
            r16 = r5
            r5 = 0
            r9 = r16
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.draw.PainterModifierKt.paint$default(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            androidx.compose.ui.Modifier r0 = r0.then(r13)
            androidx.compose.foundation.layout.BoxKt.Box(r0, r11, r9)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01ac
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01ac:
            r3 = r12
            r4 = r14
        L_0x01ae:
            androidx.compose.runtime.ScopeUpdateScope r8 = r11.endRestartGroup()
            if (r8 == 0) goto L_0x01c5
            androidx.compose.material3.IconKt$Icon$3 r0 = new androidx.compose.material3.IconKt$Icon$3
            r1 = r19
            r2 = r20
            r7 = r26
            r6 = r10
            r0.<init>(r1, r2, r3, r4, r6, r7)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r8.updateScope(r0)
        L_0x01c5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.IconKt.m2123Iconww6aTOc(androidx.compose.ui.graphics.painter.Painter, java.lang.String, androidx.compose.ui.Modifier, long, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void Icon(Painter painter, ColorProducer colorProducer, String str, Modifier modifier, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        Composer startRestartGroup = composer.startRestartGroup(1755070997);
        ComposerKt.sourceInformation(startRestartGroup, "C(Icon)P(2,3)206@9303L163,202@9171L330:Icon.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(painter) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(colorProducer) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed((Object) str) ? 256 : 128;
        }
        int i4 = i2 & 8;
        if (i4 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changed((Object) modifier) ? 2048 : 1024;
        }
        if ((i3 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1755070997, i3, -1, "androidx.compose.material3.Icon (Icon.kt:191)");
            }
            startRestartGroup.startReplaceGroup(-2144829472);
            ComposerKt.sourceInformation(startRestartGroup, "194@9002L115");
            if (str != null) {
                Modifier modifier3 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2144827505, "CC(remember):Icon.kt#9igjgp");
                boolean z = (i3 & 896) == 256;
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new IconKt$Icon$semantics$2$1(str);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                modifier2 = SemanticsModifierKt.semantics$default(modifier3, false, (Function1) rememberedValue, 1, (Object) null);
            } else {
                modifier2 = Modifier.Companion;
            }
            startRestartGroup.endReplaceGroup();
            Modifier defaultSizeForColorProducer = defaultSizeForColorProducer(GraphicsLayerModifierKt.toolingGraphicsLayer(modifier), painter);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2144817825, "CC(remember):Icon.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(painter) | startRestartGroup.changedInstance(colorProducer);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new IconKt$Icon$4$1(painter, colorProducer);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            BoxKt.Box(DrawModifierKt.drawBehind(defaultSizeForColorProducer, (Function1) rememberedValue2).then(modifier2), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        Modifier modifier4 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new IconKt$Icon$5(painter, colorProducer, str, modifier4, i, i2));
        }
    }

    private static final Modifier defaultSizeForColorProducer(Modifier modifier, Painter painter) {
        Modifier modifier2;
        if (Size.m4052equalsimpl0(painter.m5044getIntrinsicSizeNHjbRc(), Size.Companion.m4064getUnspecifiedNHjbRc()) || m2125isInfiniteuvyYCjk(painter.m5044getIntrinsicSizeNHjbRc())) {
            modifier2 = DefaultIconSizeModifier;
        } else {
            long r0 = painter.m5044getIntrinsicSizeNHjbRc();
            modifier2 = LayoutModifierKt.layout(Modifier.Companion, new IconKt$defaultSizeForColorProducer$1(Size.m4056getWidthimpl(r0), Size.m4053getHeightimpl(r0)));
        }
        return modifier.then(modifier2);
    }

    private static final Modifier defaultSizeFor(Modifier modifier, Painter painter) {
        Modifier modifier2;
        if (Size.m4052equalsimpl0(painter.m5044getIntrinsicSizeNHjbRc(), Size.Companion.m4064getUnspecifiedNHjbRc()) || m2125isInfiniteuvyYCjk(painter.m5044getIntrinsicSizeNHjbRc())) {
            modifier2 = DefaultIconSizeModifier;
        } else {
            modifier2 = Modifier.Companion;
        }
        return modifier.then(modifier2);
    }

    /* renamed from: isInfinite-uvyYCjk  reason: not valid java name */
    private static final boolean m2125isInfiniteuvyYCjk(long j) {
        return Float.isInfinite(Size.m4056getWidthimpl(j)) && Float.isInfinite(Size.m4053getHeightimpl(j));
    }
}
