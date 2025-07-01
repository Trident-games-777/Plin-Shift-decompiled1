package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import androidx.compose.ui.window.SecureFlagPolicy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0001¢\u0006\u0002\u0010\t\u001aD\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a+\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\u0006\u0010\u0019\u001a\u00020\rH\u0001¢\u0006\u0002\u0010\u001a\u001a\u0014\u0010\u001b\u001a\u00020\u001c*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001a\"\u0010 \u001a\u00020\u0014*\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\u0006\u0010\u0019\u001a\u00020\rH\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"HandlePopup", "", "positionProvider", "Landroidx/compose/foundation/text/selection/OffsetProvider;", "handleReferencePoint", "Landroidx/compose/ui/Alignment;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/text/selection/OffsetProvider;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionHandle", "offsetProvider", "isStartHandle", "", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "handlesCrossed", "minTouchTargetSize", "Landroidx/compose/ui/unit/DpSize;", "modifier", "Landroidx/compose/ui/Modifier;", "SelectionHandle-pzduO1o", "(Landroidx/compose/foundation/text/selection/OffsetProvider;ZLandroidx/compose/ui/text/style/ResolvedTextDirection;ZJLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SelectionHandleIcon", "iconVisible", "isLeft", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "createHandleImage", "Landroidx/compose/ui/graphics/ImageBitmap;", "Landroidx/compose/ui/draw/CacheDrawScope;", "radius", "", "drawSelectionHandle", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidSelectionHandles.android.kt */
public final class AndroidSelectionHandles_androidKt {
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00e1, code lost:
        if ((r27 & 16) != 0) goto L_0x00ee;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0131  */
    /* renamed from: SelectionHandle-pzduO1o  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1553SelectionHandlepzduO1o(androidx.compose.foundation.text.selection.OffsetProvider r18, boolean r19, androidx.compose.ui.text.style.ResolvedTextDirection r20, boolean r21, long r22, androidx.compose.ui.Modifier r24, androidx.compose.runtime.Composer r25, int r26, int r27) {
        /*
            r6 = r18
            r7 = r19
            r8 = r24
            r9 = r26
            r0 = -843755800(0xffffffffcdb54ee8, float:-3.80230912E8)
            r1 = r25
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(SelectionHandle)P(5,2!2,3:c#ui.unit.DpSize)69@3042L326,80@3475L7,81@3579L1272,81@3487L1364:AndroidSelectionHandles.android.kt#eksfi3"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r27 & 1
            r2 = 4
            if (r1 == 0) goto L_0x001e
            r1 = r9 | 6
            goto L_0x0037
        L_0x001e:
            r1 = r9 & 6
            if (r1 != 0) goto L_0x0036
            r1 = r9 & 8
            if (r1 != 0) goto L_0x002b
            boolean r1 = r10.changed((java.lang.Object) r6)
            goto L_0x002f
        L_0x002b:
            boolean r1 = r10.changedInstance(r6)
        L_0x002f:
            if (r1 == 0) goto L_0x0033
            r1 = r2
            goto L_0x0034
        L_0x0033:
            r1 = 2
        L_0x0034:
            r1 = r1 | r9
            goto L_0x0037
        L_0x0036:
            r1 = r9
        L_0x0037:
            r3 = r27 & 2
            r4 = 32
            if (r3 == 0) goto L_0x0040
            r1 = r1 | 48
            goto L_0x004f
        L_0x0040:
            r3 = r9 & 48
            if (r3 != 0) goto L_0x004f
            boolean r3 = r10.changed((boolean) r7)
            if (r3 == 0) goto L_0x004c
            r3 = r4
            goto L_0x004e
        L_0x004c:
            r3 = 16
        L_0x004e:
            r1 = r1 | r3
        L_0x004f:
            r3 = r27 & 4
            if (r3 == 0) goto L_0x0058
            r1 = r1 | 384(0x180, float:5.38E-43)
            r11 = r20
            goto L_0x006a
        L_0x0058:
            r3 = r9 & 384(0x180, float:5.38E-43)
            r11 = r20
            if (r3 != 0) goto L_0x006a
            boolean r3 = r10.changed((java.lang.Object) r11)
            if (r3 == 0) goto L_0x0067
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0069
        L_0x0067:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0069:
            r1 = r1 | r3
        L_0x006a:
            r3 = r27 & 8
            if (r3 == 0) goto L_0x0073
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r12 = r21
            goto L_0x0085
        L_0x0073:
            r3 = r9 & 3072(0xc00, float:4.305E-42)
            r12 = r21
            if (r3 != 0) goto L_0x0085
            boolean r3 = r10.changed((boolean) r12)
            if (r3 == 0) goto L_0x0082
            r3 = 2048(0x800, float:2.87E-42)
            goto L_0x0084
        L_0x0082:
            r3 = 1024(0x400, float:1.435E-42)
        L_0x0084:
            r1 = r1 | r3
        L_0x0085:
            r3 = r9 & 24576(0x6000, float:3.4438E-41)
            if (r3 != 0) goto L_0x009c
            r3 = r27 & 16
            r13 = r22
            if (r3 != 0) goto L_0x0098
            boolean r3 = r10.changed((long) r13)
            if (r3 == 0) goto L_0x0098
            r3 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009a
        L_0x0098:
            r3 = 8192(0x2000, float:1.14794E-41)
        L_0x009a:
            r1 = r1 | r3
            goto L_0x009e
        L_0x009c:
            r13 = r22
        L_0x009e:
            r3 = r27 & 32
            r5 = 196608(0x30000, float:2.75506E-40)
            if (r3 == 0) goto L_0x00a6
            r1 = r1 | r5
            goto L_0x00b6
        L_0x00a6:
            r3 = r9 & r5
            if (r3 != 0) goto L_0x00b6
            boolean r3 = r10.changed((java.lang.Object) r8)
            if (r3 == 0) goto L_0x00b3
            r3 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b3:
            r3 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r1 = r1 | r3
        L_0x00b6:
            r3 = 74899(0x12493, float:1.04956E-40)
            r3 = r3 & r1
            r5 = 74898(0x12492, float:1.04954E-40)
            if (r3 != r5) goto L_0x00cb
            boolean r3 = r10.getSkipping()
            if (r3 != 0) goto L_0x00c6
            goto L_0x00cb
        L_0x00c6:
            r10.skipToGroupEnd()
            goto L_0x019b
        L_0x00cb:
            r10.startDefaults()
            r3 = r9 & 1
            r5 = -57345(0xffffffffffff1fff, float:NaN)
            if (r3 == 0) goto L_0x00e4
            boolean r3 = r10.getDefaultsInvalid()
            if (r3 == 0) goto L_0x00dc
            goto L_0x00e4
        L_0x00dc:
            r10.skipToGroupEnd()
            r3 = r27 & 16
            if (r3 == 0) goto L_0x00ef
            goto L_0x00ee
        L_0x00e4:
            r3 = r27 & 16
            if (r3 == 0) goto L_0x00ef
            androidx.compose.ui.unit.DpSize$Companion r3 = androidx.compose.ui.unit.DpSize.Companion
            long r13 = r3.m7218getUnspecifiedMYxV2XQ()
        L_0x00ee:
            r1 = r1 & r5
        L_0x00ef:
            r10.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x00fe
            r3 = -1
            java.lang.String r5 = "androidx.compose.foundation.text.selection.SelectionHandle (AndroidSelectionHandles.android.kt:64)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r3, r5)
        L_0x00fe:
            boolean r0 = androidx.compose.foundation.text.selection.SelectionHandlesKt.isLeftSelectionHandle(r19, r20, r21)
            androidx.compose.ui.AbsoluteAlignment r3 = androidx.compose.ui.AbsoluteAlignment.INSTANCE
            if (r0 == 0) goto L_0x010b
            androidx.compose.ui.Alignment r3 = r3.getTopRight()
            goto L_0x010f
        L_0x010b:
            androidx.compose.ui.Alignment r3 = r3.getTopLeft()
        L_0x010f:
            r15 = r3
            r3 = -785126383(0xffffffffd133ec11, float:-4.829748E10)
            java.lang.String r5 = "CC(remember):AndroidSelectionHandles.android.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r3, r5)
            r3 = r1 & 14
            r5 = 1
            if (r3 == r2) goto L_0x012a
            r2 = r1 & 8
            if (r2 == 0) goto L_0x0128
            boolean r2 = r10.changedInstance(r6)
            if (r2 == 0) goto L_0x0128
            goto L_0x012a
        L_0x0128:
            r2 = 0
            goto L_0x012b
        L_0x012a:
            r2 = r5
        L_0x012b:
            r1 = r1 & 112(0x70, float:1.57E-43)
            if (r1 != r4) goto L_0x0131
            r1 = r5
            goto L_0x0132
        L_0x0131:
            r1 = 0
        L_0x0132:
            r1 = r1 | r2
            boolean r2 = r10.changed((boolean) r0)
            r1 = r1 | r2
            java.lang.Object r2 = r10.rememberedValue()
            if (r1 != 0) goto L_0x0146
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r2 != r1) goto L_0x0151
        L_0x0146:
            androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$semanticsModifier$1$1 r1 = new androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$semanticsModifier$1$1
            r1.<init>(r6, r7, r0)
            r2 = r1
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r10.updateRememberedValue(r2)
        L_0x0151:
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r1 = 0
            r4 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r8, r4, r2, r5, r1)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r5 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r4, r5)
            java.lang.Object r2 = r10.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.platform.ViewConfiguration r2 = (androidx.compose.ui.platform.ViewConfiguration) r2
            r4 = r0
            androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$1 r0 = new androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$1
            r5 = r1
            r1 = r2
            r16 = r13
            r13 = r3
            r2 = r16
            r14 = 1
            r0.<init>(r1, r2, r4, r5, r6)
            r1 = 54
            r4 = 280174801(0x10b320d1, float:7.065361E-29)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r4, r14, r0, r10, r1)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r13 | 384(0x180, float:5.38E-43)
            HandlePopup(r6, r15, r0, r10, r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x019a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x019a:
            r13 = r2
        L_0x019b:
            androidx.compose.runtime.ScopeUpdateScope r10 = r10.endRestartGroup()
            if (r10 == 0) goto L_0x01b4
            androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$2 r0 = new androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$2
            r1 = r6
            r2 = r7
            r7 = r8
            r8 = r9
            r3 = r11
            r4 = r12
            r5 = r13
            r9 = r27
            r0.<init>(r1, r2, r3, r4, r5, r7, r8, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x01b4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt.m1553SelectionHandlepzduO1o(androidx.compose.foundation.text.selection.OffsetProvider, boolean, androidx.compose.ui.text.style.ResolvedTextDirection, boolean, long, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void SelectionHandleIcon(Modifier modifier, Function0<Boolean> function0, boolean z, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(2111672474);
        ComposerKt.sourceInformation(startRestartGroup, "C(SelectionHandleIcon)P(2)123@5009L129:AndroidSelectionHandles.android.kt#eksfi3");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2111672474, i2, -1, "androidx.compose.foundation.text.selection.SelectionHandleIcon (AndroidSelectionHandles.android.kt:122)");
            }
            SpacerKt.Spacer(drawSelectionHandle(SizeKt.m847sizeVpY3zN4(modifier, SelectionHandlesKt.getHandleWidth(), SelectionHandlesKt.getHandleHeight()), function0, z), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AndroidSelectionHandles_androidKt$SelectionHandleIcon$1(modifier, function0, z, i));
        }
    }

    public static final Modifier drawSelectionHandle(Modifier modifier, Function0<Boolean> function0, boolean z) {
        return ComposedModifierKt.composed$default(modifier, (Function1) null, new AndroidSelectionHandles_androidKt$drawSelectionHandle$1(function0, z), 1, (Object) null);
    }

    public static final ImageBitmap createHandleImage(CacheDrawScope cacheDrawScope, float f) {
        float f2 = f;
        int ceil = ((int) ((float) Math.ceil((double) f2))) * 2;
        ImageBitmap imageBitmap = HandleImageCache.INSTANCE.getImageBitmap();
        Canvas canvas = HandleImageCache.INSTANCE.getCanvas();
        CanvasDrawScope canvasDrawScope = HandleImageCache.INSTANCE.getCanvasDrawScope();
        if (imageBitmap == null || canvas == null || ceil > imageBitmap.getWidth() || ceil > imageBitmap.getHeight()) {
            imageBitmap = ImageBitmapKt.m4467ImageBitmapx__hDU$default(ceil, ceil, ImageBitmapConfig.Companion.m4461getAlpha8_sVssgQ(), false, (ColorSpace) null, 24, (Object) null);
            HandleImageCache.INSTANCE.setImageBitmap(imageBitmap);
            canvas = CanvasKt.Canvas(imageBitmap);
            HandleImageCache.INSTANCE.setCanvas(canvas);
        }
        ImageBitmap imageBitmap2 = imageBitmap;
        Canvas canvas2 = canvas;
        if (canvasDrawScope == null) {
            canvasDrawScope = new CanvasDrawScope();
            HandleImageCache.INSTANCE.setCanvasDrawScope(canvasDrawScope);
        }
        CanvasDrawScope canvasDrawScope2 = canvasDrawScope;
        LayoutDirection layoutDirection = cacheDrawScope.getLayoutDirection();
        long Size = androidx.compose.ui.geometry.SizeKt.Size((float) imageBitmap2.getWidth(), (float) imageBitmap2.getHeight());
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope2.getDrawParams();
        Density component1 = drawParams.component1();
        LayoutDirection component2 = drawParams.component2();
        Canvas component3 = drawParams.component3();
        long r7 = drawParams.m4761component4NHjbRc();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope2.getDrawParams();
        drawParams2.setDensity(cacheDrawScope);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(canvas2);
        drawParams2.m4764setSizeuvyYCjk(Size);
        canvas2.save();
        DrawScope drawScope = canvasDrawScope2;
        DrawScope.m4840drawRectnJ9OG0$default(drawScope, Color.Companion.m4265getBlack0d7_KjU(), 0, drawScope.m4865getSizeNHjbRc(), 0.0f, (DrawStyle) null, (ColorFilter) null, BlendMode.Companion.m4143getClear0nO6VwU(), 58, (Object) null);
        DrawScope.m4840drawRectnJ9OG0$default(drawScope, ColorKt.Color(4278190080L), Offset.Companion.m4003getZeroF1C5BW0(), androidx.compose.ui.geometry.SizeKt.Size(f2, f2), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, MenuKt.InTransitionDuration, (Object) null);
        ImageBitmap imageBitmap3 = imageBitmap2;
        DrawScope drawScope2 = drawScope;
        DrawScope.m4827drawCircleVaOC9Bg$default(drawScope2, ColorKt.Color(4278190080L), f2, OffsetKt.Offset(f2, f2), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, MenuKt.InTransitionDuration, (Object) null);
        canvas2.restore();
        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope2.getDrawParams();
        drawParams3.setDensity(component1);
        drawParams3.setLayoutDirection(component2);
        drawParams3.setCanvas(component3);
        drawParams3.m4764setSizeuvyYCjk(r7);
        return imageBitmap3;
    }

    public static final void HandlePopup(OffsetProvider offsetProvider, Alignment alignment, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        OffsetProvider offsetProvider2 = offsetProvider;
        Alignment alignment2 = alignment;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(476043083);
        ComposerKt.sourceInformation(startRestartGroup, "C(HandlePopup)P(2,1)248@8967L127,251@9099L190:AndroidSelectionHandles.android.kt#eksfi3");
        if ((i3 & 6) == 0) {
            i2 = ((i3 & 8) == 0 ? startRestartGroup.changed((Object) offsetProvider2) : startRestartGroup.changedInstance(offsetProvider2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changed((Object) alignment2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(476043083, i2, -1, "androidx.compose.foundation.text.selection.HandlePopup (AndroidSelectionHandles.android.kt:247)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1288574970, "CC(remember):AndroidSelectionHandles.android.kt#9igjgp");
            boolean z = true;
            boolean z2 = (i2 & 112) == 32;
            if ((i2 & 14) != 4 && ((i2 & 8) == 0 || !startRestartGroup.changed((Object) offsetProvider2))) {
                z = false;
            }
            boolean z3 = z2 | z;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new HandlePositionProvider(alignment2, offsetProvider2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            AndroidPopup_androidKt.Popup((HandlePositionProvider) rememberedValue, (Function0<Unit>) null, new PopupProperties(false, false, false, (SecureFlagPolicy) null, true, false, 15, (DefaultConstructorMarker) null), function22, startRestartGroup, ((i2 << 3) & 7168) | 384, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AndroidSelectionHandles_androidKt$HandlePopup$1(offsetProvider2, alignment2, function22, i3));
        }
    }
}
