package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.PointerIconCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u0001\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001am\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\f2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060#2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010$\u001a\"\u0010%\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a8\u0010)\u001a\u00020\n*\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0013\u001a\u00020+H\u0003ø\u0001\u0000¢\u0006\u0004\b,\u0010-\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006."}, d2 = {"LocalAbsoluteTonalElevation", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/unit/Dp;", "getLocalAbsoluteTonalElevation", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "Surface", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "color", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "shadowElevation", "border", "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/runtime/Composable;", "Surface-o_FOJdg", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Surface-T9BRK9s", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "selected", "Surface-d85dljk", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "surfaceColorAtElevation", "elevation", "surfaceColorAtElevation-CLU3JFs", "(JFLandroidx/compose/runtime/Composer;I)J", "surface", "backgroundColor", "", "surface-XO-JAsU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/foundation/BorderStroke;F)Landroidx/compose/ui/Modifier;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Surface.kt */
public final class SurfaceKt {
    private static final ProvidableCompositionLocal<Dp> LocalAbsoluteTonalElevation = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, SurfaceKt$LocalAbsoluteTonalElevation$1.INSTANCE, 1, (Object) null);

    /* renamed from: Surface-T9BRK9s  reason: not valid java name */
    public static final void m2536SurfaceT9BRK9s(Modifier modifier, Shape shape, long j, long j2, float f, float f2, BorderStroke borderStroke, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -513881741, "C(Surface)P(4,6,1:c#ui.graphics.Color,3:c#ui.graphics.Color,7:c#ui.unit.Dp,5:c#ui.unit.Dp)96@5014L11,97@5061L22,*103@5278L7,107@5451L741,104@5307L885:Surface.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            modifier = Modifier.Companion;
        }
        if ((i2 & 2) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        if ((i2 & 4) != 0) {
            j = MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1872getSurface0d7_KjU();
        }
        if ((i2 & 8) != 0) {
            j2 = ColorSchemeKt.m1886contentColorForek8zF_U(j, composer, (i >> 6) & 14);
        }
        if ((i2 & 16) != 0) {
            f = Dp.m7111constructorimpl((float) 0);
        }
        if ((i2 & 32) != 0) {
            f2 = Dp.m7111constructorimpl((float) 0);
        }
        if ((i2 & 64) != 0) {
            borderStroke = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-513881741, i, -1, "androidx.compose.material3.Surface (Surface.kt:102)");
        }
        ProvidableCompositionLocal<Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(providableCompositionLocal);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float r9 = Dp.m7111constructorimpl(((Dp) consume).m7125unboximpl() + f);
        ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m4229boximpl(j2)), providableCompositionLocal.provides(Dp.m7109boximpl(r9))};
        long j3 = j;
        BorderStroke borderStroke2 = borderStroke;
        float f3 = f2;
        BorderStroke borderStroke3 = borderStroke2;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-70914509, true, new SurfaceKt$Surface$1(modifier, shape, j3, r9, borderStroke3, f3, function2), composer, 54), composer, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX WARNING: type inference failed for: r18v1 */
    /* JADX WARNING: type inference failed for: r18v2 */
    /* JADX WARNING: type inference failed for: r18v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: Surface-o_FOJdg  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2539Surfaceo_FOJdg(kotlin.jvm.functions.Function0<kotlin.Unit> r17, androidx.compose.ui.Modifier r18, boolean r19, androidx.compose.ui.graphics.Shape r20, long r21, long r23, float r25, float r26, androidx.compose.foundation.BorderStroke r27, androidx.compose.foundation.interaction.MutableInteractionSource r28, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.runtime.Composer r30, int r31, int r32, int r33) {
        /*
            r0 = r30
            r1 = r31
            r2 = r33
            java.lang.String r3 = "C(Surface)P(7,6,4,9,1:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.unit.Dp,8:c#ui.unit.Dp!1,5)196@10536L11,197@10583L22,*204@10857L7,208@11030L853,205@10886L997:Surface.kt#uh7d8r"
            r4 = -789752804(0xffffffffd0ed541c, float:-3.18536991E10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r4, r3)
            r3 = r2 & 2
            if (r3 == 0) goto L_0x0018
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r6 = r3
            goto L_0x001a
        L_0x0018:
            r6 = r18
        L_0x001a:
            r3 = r2 & 4
            if (r3 == 0) goto L_0x0020
            r13 = 1
            goto L_0x0022
        L_0x0020:
            r13 = r19
        L_0x0022:
            r3 = r2 & 8
            if (r3 == 0) goto L_0x002c
            androidx.compose.ui.graphics.Shape r3 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            r7 = r3
            goto L_0x002e
        L_0x002c:
            r7 = r20
        L_0x002e:
            r3 = r2 & 16
            if (r3 == 0) goto L_0x003e
            androidx.compose.material3.MaterialTheme r3 = androidx.compose.material3.MaterialTheme.INSTANCE
            r8 = 6
            androidx.compose.material3.ColorScheme r3 = r3.getColorScheme(r0, r8)
            long r8 = r3.m1872getSurface0d7_KjU()
            goto L_0x0040
        L_0x003e:
            r8 = r21
        L_0x0040:
            r3 = r2 & 32
            if (r3 == 0) goto L_0x004d
            int r3 = r1 >> 12
            r3 = r3 & 14
            long r10 = androidx.compose.material3.ColorSchemeKt.m1886contentColorForek8zF_U(r8, r0, r3)
            goto L_0x004f
        L_0x004d:
            r10 = r23
        L_0x004f:
            r3 = r2 & 64
            r12 = 0
            if (r3 == 0) goto L_0x005a
            float r3 = (float) r12
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r3)
            goto L_0x005c
        L_0x005a:
            r3 = r25
        L_0x005c:
            r14 = r2 & 128(0x80, float:1.794E-43)
            if (r14 == 0) goto L_0x0067
            float r14 = (float) r12
            float r14 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r14)
            r15 = r14
            goto L_0x0069
        L_0x0067:
            r15 = r26
        L_0x0069:
            r14 = r2 & 256(0x100, float:3.59E-43)
            r16 = 0
            if (r14 == 0) goto L_0x0072
            r14 = r16
            goto L_0x0074
        L_0x0072:
            r14 = r27
        L_0x0074:
            r2 = r2 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x0079
            goto L_0x007b
        L_0x0079:
            r16 = r28
        L_0x007b:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x008b
            java.lang.String r2 = "androidx.compose.material3.Surface (Surface.kt:203)"
            r5 = r32
            r18 = 1
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r1, r5, r2)
            goto L_0x008d
        L_0x008b:
            r18 = 1
        L_0x008d:
            androidx.compose.runtime.ProvidableCompositionLocal<androidx.compose.ui.unit.Dp> r1 = LocalAbsoluteTonalElevation
            r2 = r1
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r5 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r4, r5)
            java.lang.Object r2 = r0.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Dp r2 = (androidx.compose.ui.unit.Dp) r2
            float r2 = r2.m7125unboximpl()
            float r2 = r2 + r3
            float r2 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r2)
            r3 = 2
            androidx.compose.runtime.ProvidedValue[] r3 = new androidx.compose.runtime.ProvidedValue[r3]
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.material3.ContentColorKt.getLocalContentColor()
            androidx.compose.ui.graphics.Color r5 = androidx.compose.ui.graphics.Color.m4229boximpl(r10)
            androidx.compose.runtime.ProvidedValue r4 = r4.provides(r5)
            r3[r12] = r4
            androidx.compose.ui.unit.Dp r4 = androidx.compose.ui.unit.Dp.m7109boximpl(r2)
            androidx.compose.runtime.ProvidedValue r1 = r1.provides(r4)
            r3[r18] = r1
            androidx.compose.material3.SurfaceKt$Surface$2 r5 = new androidx.compose.material3.SurfaceKt$Surface$2
            r1 = r18
            r10 = r2
            r11 = r14
            r12 = r16
            r14 = r17
            r16 = r29
            r5.<init>(r6, r7, r8, r10, r11, r12, r13, r14, r15, r16)
            r2 = 54
            r4 = 1279702876(0x4c46b75c, float:5.2092272E7)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r4, r1, r5, r0, r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            int r2 = androidx.compose.runtime.ProvidedValue.$stable
            r2 = r2 | 48
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r3, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r1, (androidx.compose.runtime.Composer) r0, (int) r2)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00f1
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00f1:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SurfaceKt.m2539Surfaceo_FOJdg(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, long, long, float, float, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: type inference failed for: r20v1 */
    /* JADX WARNING: type inference failed for: r20v2 */
    /* JADX WARNING: type inference failed for: r20v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: Surface-d85dljk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2537Surfaced85dljk(boolean r18, kotlin.jvm.functions.Function0<kotlin.Unit> r19, androidx.compose.ui.Modifier r20, boolean r21, androidx.compose.ui.graphics.Shape r22, long r23, long r25, float r27, float r28, androidx.compose.foundation.BorderStroke r29, androidx.compose.foundation.interaction.MutableInteractionSource r30, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, androidx.compose.runtime.Composer r32, int r33, int r34, int r35) {
        /*
            r0 = r32
            r1 = r33
            r2 = r35
            java.lang.String r3 = "C(Surface)P(8,7,6,4,10,1:c#ui.graphics.Color,3:c#ui.graphics.Color,11:c#ui.unit.Dp,9:c#ui.unit.Dp!1,5)299@16163L11,300@16210L22,*307@16484L7,311@16657L899,308@16513L1043:Surface.kt#uh7d8r"
            r4 = 540296512(0x20344540, float:1.5269506E-19)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r4, r3)
            r3 = r2 & 4
            if (r3 == 0) goto L_0x0018
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r6 = r3
            goto L_0x001a
        L_0x0018:
            r6 = r20
        L_0x001a:
            r3 = r2 & 8
            if (r3 == 0) goto L_0x0020
            r14 = 1
            goto L_0x0022
        L_0x0020:
            r14 = r21
        L_0x0022:
            r3 = r2 & 16
            if (r3 == 0) goto L_0x002c
            androidx.compose.ui.graphics.Shape r3 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            r7 = r3
            goto L_0x002e
        L_0x002c:
            r7 = r22
        L_0x002e:
            r3 = r2 & 32
            if (r3 == 0) goto L_0x003e
            androidx.compose.material3.MaterialTheme r3 = androidx.compose.material3.MaterialTheme.INSTANCE
            r8 = 6
            androidx.compose.material3.ColorScheme r3 = r3.getColorScheme(r0, r8)
            long r8 = r3.m1872getSurface0d7_KjU()
            goto L_0x0040
        L_0x003e:
            r8 = r23
        L_0x0040:
            r3 = r2 & 64
            if (r3 == 0) goto L_0x004d
            int r3 = r1 >> 15
            r3 = r3 & 14
            long r10 = androidx.compose.material3.ColorSchemeKt.m1886contentColorForek8zF_U(r8, r0, r3)
            goto L_0x004f
        L_0x004d:
            r10 = r25
        L_0x004f:
            r3 = r2 & 128(0x80, float:1.794E-43)
            r12 = 0
            if (r3 == 0) goto L_0x005a
            float r3 = (float) r12
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r3)
            goto L_0x005c
        L_0x005a:
            r3 = r27
        L_0x005c:
            r13 = r2 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x0068
            float r13 = (float) r12
            float r13 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r13)
            r16 = r13
            goto L_0x006a
        L_0x0068:
            r16 = r28
        L_0x006a:
            r13 = r2 & 512(0x200, float:7.175E-43)
            r15 = 0
            if (r13 == 0) goto L_0x0071
            r13 = r15
            goto L_0x0073
        L_0x0071:
            r13 = r29
        L_0x0073:
            r2 = r2 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x0078
            goto L_0x007a
        L_0x0078:
            r15 = r30
        L_0x007a:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x008a
            java.lang.String r2 = "androidx.compose.material3.Surface (Surface.kt:306)"
            r5 = r34
            r20 = 1
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r1, r5, r2)
            goto L_0x008c
        L_0x008a:
            r20 = 1
        L_0x008c:
            androidx.compose.runtime.ProvidableCompositionLocal<androidx.compose.ui.unit.Dp> r1 = LocalAbsoluteTonalElevation
            r2 = r1
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r5 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r4, r5)
            java.lang.Object r2 = r0.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Dp r2 = (androidx.compose.ui.unit.Dp) r2
            float r2 = r2.m7125unboximpl()
            float r2 = r2 + r3
            float r2 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r2)
            r3 = 2
            androidx.compose.runtime.ProvidedValue[] r3 = new androidx.compose.runtime.ProvidedValue[r3]
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.material3.ContentColorKt.getLocalContentColor()
            androidx.compose.ui.graphics.Color r5 = androidx.compose.ui.graphics.Color.m4229boximpl(r10)
            androidx.compose.runtime.ProvidedValue r4 = r4.provides(r5)
            r3[r12] = r4
            androidx.compose.ui.unit.Dp r4 = androidx.compose.ui.unit.Dp.m7109boximpl(r2)
            androidx.compose.runtime.ProvidedValue r1 = r1.provides(r4)
            r3[r20] = r1
            androidx.compose.material3.SurfaceKt$Surface$3 r5 = new androidx.compose.material3.SurfaceKt$Surface$3
            r12 = r18
            r1 = r20
            r17 = r31
            r10 = r2
            r11 = r13
            r13 = r15
            r15 = r19
            r5.<init>(r6, r7, r8, r10, r11, r12, r13, r14, r15, r16, r17)
            r2 = 54
            r4 = -1164547968(0xffffffffba966880, float:-0.0011475235)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r4, r1, r5, r0, r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            int r2 = androidx.compose.runtime.ProvidedValue.$stable
            r2 = r2 | 48
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r3, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r1, (androidx.compose.runtime.Composer) r0, (int) r2)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00f1
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00f1:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SurfaceKt.m2537Surfaced85dljk(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, long, long, float, float, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: type inference failed for: r20v1 */
    /* JADX WARNING: type inference failed for: r20v2 */
    /* JADX WARNING: type inference failed for: r20v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: Surface-d85dljk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2538Surfaced85dljk(boolean r18, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r19, androidx.compose.ui.Modifier r20, boolean r21, androidx.compose.ui.graphics.Shape r22, long r23, long r25, float r27, float r28, androidx.compose.foundation.BorderStroke r29, androidx.compose.foundation.interaction.MutableInteractionSource r30, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, androidx.compose.runtime.Composer r32, int r33, int r34, int r35) {
        /*
            r0 = r32
            r1 = r33
            r2 = r35
            java.lang.String r3 = "C(Surface)P(1,8,7,5,10,2:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.unit.Dp,9:c#ui.unit.Dp!1,6)403@21903L11,404@21950L22,*411@22224L7,415@22397L909,412@22253L1053:Surface.kt#uh7d8r"
            r4 = -1877401889(0xffffffff90191edf, float:-3.0197712E-29)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r4, r3)
            r3 = r2 & 4
            if (r3 == 0) goto L_0x0018
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r6 = r3
            goto L_0x001a
        L_0x0018:
            r6 = r20
        L_0x001a:
            r3 = r2 & 8
            if (r3 == 0) goto L_0x0020
            r14 = 1
            goto L_0x0022
        L_0x0020:
            r14 = r21
        L_0x0022:
            r3 = r2 & 16
            if (r3 == 0) goto L_0x002c
            androidx.compose.ui.graphics.Shape r3 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            r7 = r3
            goto L_0x002e
        L_0x002c:
            r7 = r22
        L_0x002e:
            r3 = r2 & 32
            if (r3 == 0) goto L_0x003e
            androidx.compose.material3.MaterialTheme r3 = androidx.compose.material3.MaterialTheme.INSTANCE
            r8 = 6
            androidx.compose.material3.ColorScheme r3 = r3.getColorScheme(r0, r8)
            long r8 = r3.m1872getSurface0d7_KjU()
            goto L_0x0040
        L_0x003e:
            r8 = r23
        L_0x0040:
            r3 = r2 & 64
            if (r3 == 0) goto L_0x004d
            int r3 = r1 >> 15
            r3 = r3 & 14
            long r10 = androidx.compose.material3.ColorSchemeKt.m1886contentColorForek8zF_U(r8, r0, r3)
            goto L_0x004f
        L_0x004d:
            r10 = r25
        L_0x004f:
            r3 = r2 & 128(0x80, float:1.794E-43)
            r12 = 0
            if (r3 == 0) goto L_0x005a
            float r3 = (float) r12
            float r3 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r3)
            goto L_0x005c
        L_0x005a:
            r3 = r27
        L_0x005c:
            r13 = r2 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x0068
            float r13 = (float) r12
            float r13 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r13)
            r16 = r13
            goto L_0x006a
        L_0x0068:
            r16 = r28
        L_0x006a:
            r13 = r2 & 512(0x200, float:7.175E-43)
            r15 = 0
            if (r13 == 0) goto L_0x0071
            r13 = r15
            goto L_0x0073
        L_0x0071:
            r13 = r29
        L_0x0073:
            r2 = r2 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x0078
            goto L_0x007a
        L_0x0078:
            r15 = r30
        L_0x007a:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x008a
            java.lang.String r2 = "androidx.compose.material3.Surface (Surface.kt:410)"
            r5 = r34
            r20 = 1
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r1, r5, r2)
            goto L_0x008c
        L_0x008a:
            r20 = 1
        L_0x008c:
            androidx.compose.runtime.ProvidableCompositionLocal<androidx.compose.ui.unit.Dp> r1 = LocalAbsoluteTonalElevation
            r2 = r1
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r5 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r4, r5)
            java.lang.Object r2 = r0.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Dp r2 = (androidx.compose.ui.unit.Dp) r2
            float r2 = r2.m7125unboximpl()
            float r2 = r2 + r3
            float r2 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r2)
            r3 = 2
            androidx.compose.runtime.ProvidedValue[] r3 = new androidx.compose.runtime.ProvidedValue[r3]
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.material3.ContentColorKt.getLocalContentColor()
            androidx.compose.ui.graphics.Color r5 = androidx.compose.ui.graphics.Color.m4229boximpl(r10)
            androidx.compose.runtime.ProvidedValue r4 = r4.provides(r5)
            r3[r12] = r4
            androidx.compose.ui.unit.Dp r4 = androidx.compose.ui.unit.Dp.m7109boximpl(r2)
            androidx.compose.runtime.ProvidedValue r1 = r1.provides(r4)
            r3[r20] = r1
            androidx.compose.material3.SurfaceKt$Surface$4 r5 = new androidx.compose.material3.SurfaceKt$Surface$4
            r12 = r18
            r1 = r20
            r17 = r31
            r10 = r2
            r11 = r13
            r13 = r15
            r15 = r19
            r5.<init>(r6, r7, r8, r10, r11, r12, r13, r14, r15, r16, r17)
            r2 = 54
            r4 = 712720927(0x2a7b421f, float:2.2316219E-13)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r4, r1, r5, r0, r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            int r2 = androidx.compose.runtime.ProvidedValue.$stable
            r2 = r2 | 48
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r3, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r1, (androidx.compose.runtime.Composer) r0, (int) r2)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00f1
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00f1:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SurfaceKt.m2538Surfaced85dljk(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, long, long, float, float, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: surface-XO-JAsU  reason: not valid java name */
    public static final Modifier m2542surfaceXOJAsU(Modifier modifier, Shape shape, long j, BorderStroke borderStroke, float f) {
        Shape shape2;
        Modifier modifier2;
        BorderStroke borderStroke2 = borderStroke;
        if (f > 0.0f) {
            shape2 = shape;
            modifier2 = GraphicsLayerModifierKt.m4401graphicsLayerAp8cVGQ$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f, 0.0f, 0.0f, 0.0f, 0.0f, 0, shape2, false, (RenderEffect) null, 0, 0, 0, 124895, (Object) null);
        } else {
            shape2 = shape;
            modifier2 = Modifier.Companion;
        }
        return ClipKt.clip(BackgroundKt.m247backgroundbw27NRU(modifier.then(modifier2).then(borderStroke2 != null ? BorderKt.border(Modifier.Companion, borderStroke2, shape2) : Modifier.Companion), j, shape2), shape2);
    }

    /* access modifiers changed from: private */
    /* renamed from: surfaceColorAtElevation-CLU3JFs  reason: not valid java name */
    public static final long m2543surfaceColorAtElevationCLU3JFs(long j, float f, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2079918090, "C(surfaceColorAtElevation)P(0:c#ui.graphics.Color,1:c#ui.unit.Dp)465@24025L11,465@24037L37:Surface.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2079918090, i, -1, "androidx.compose.material3.surfaceColorAtElevation (Surface.kt:465)");
        }
        Composer composer2 = composer;
        long r8 = ColorSchemeKt.m1884applyTonalElevationRFCenO8(MaterialTheme.INSTANCE.getColorScheme(composer, 6), j, f, composer2, (i << 3) & PointerIconCompat.TYPE_TEXT);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return r8;
    }

    public static final ProvidableCompositionLocal<Dp> getLocalAbsoluteTonalElevation() {
        return LocalAbsoluteTonalElevation;
    }
}
