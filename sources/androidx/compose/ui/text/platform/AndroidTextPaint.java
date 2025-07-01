package androidx.compose.ui.text.platform;

import android.graphics.Paint;
import android.graphics.Shader;
import android.text.TextPaint;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.text.platform.extensions.TextPaintExtensions_androidKt;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u00107\u001a\u000208H\u0002J,\u00109\u001a\u0002082\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010:\u001a\u00020\u001b2\b\b\u0002\u0010;\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\u0018\u0010>\u001a\u0002082\u0006\u0010?\u001a\u00020@ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ\u0010\u0010C\u001a\u0002082\b\u0010$\u001a\u0004\u0018\u00010%J\u0010\u0010D\u001a\u0002082\b\u0010.\u001a\u0004\u0018\u00010/J\u0010\u0010E\u001a\u0002082\b\u00105\u001a\u0004\u0018\u000106R\u0016\u0010\u0007\u001a\u00020\bX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b8F@FX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R,\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0000@\u0000X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0014\n\u0000\u0012\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R*\u0010&\u001a\u0012\u0012\f\u0012\n\u0018\u00010(j\u0004\u0018\u0001`)\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u00020/8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b0\u0010\u0015\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u000e\u00105\u001a\u000206X\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006F"}, d2 = {"Landroidx/compose/ui/text/platform/AndroidTextPaint;", "Landroid/text/TextPaint;", "flags", "", "density", "", "(IF)V", "backingBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "I", "backingComposePaint", "Landroidx/compose/ui/graphics/Paint;", "value", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "brush", "Landroidx/compose/ui/graphics/Brush;", "getBrush$ui_text_release$annotations", "()V", "getBrush$ui_text_release", "()Landroidx/compose/ui/graphics/Brush;", "setBrush$ui_text_release", "(Landroidx/compose/ui/graphics/Brush;)V", "brushSize", "Landroidx/compose/ui/geometry/Size;", "getBrushSize-VsRJwc0$ui_text_release$annotations", "getBrushSize-VsRJwc0$ui_text_release", "()Landroidx/compose/ui/geometry/Size;", "setBrushSize-iaC8Vc4$ui_text_release", "(Landroidx/compose/ui/geometry/Size;)V", "composePaint", "getComposePaint", "()Landroidx/compose/ui/graphics/Paint;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "shaderState", "Landroidx/compose/runtime/State;", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "getShaderState$ui_text_release", "()Landroidx/compose/runtime/State;", "setShaderState$ui_text_release", "(Landroidx/compose/runtime/State;)V", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "getShadow$ui_text_release$annotations", "getShadow$ui_text_release", "()Landroidx/compose/ui/graphics/Shadow;", "setShadow$ui_text_release", "(Landroidx/compose/ui/graphics/Shadow;)V", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "clearShader", "", "setBrush", "size", "alpha", "setBrush-12SF9DM", "(Landroidx/compose/ui/graphics/Brush;JF)V", "setColor", "color", "Landroidx/compose/ui/graphics/Color;", "setColor-8_81llA", "(J)V", "setDrawStyle", "setShadow", "setTextDecoration", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidTextPaint.android.kt */
public final class AndroidTextPaint extends TextPaint {
    public static final int $stable = 8;
    private int backingBlendMode = DrawScope.Companion.m4867getDefaultBlendMode0nO6VwU();
    private Paint backingComposePaint;
    private Brush brush;
    private Size brushSize;
    private DrawStyle drawStyle;
    private State<? extends Shader> shaderState;
    private Shadow shadow = Shadow.Companion.getNone();
    private TextDecoration textDecoration = TextDecoration.Companion.getNone();

    public static /* synthetic */ void getBrush$ui_text_release$annotations() {
    }

    /* renamed from: getBrushSize-VsRJwc0$ui_text_release$annotations  reason: not valid java name */
    public static /* synthetic */ void m6841getBrushSizeVsRJwc0$ui_text_release$annotations() {
    }

    public static /* synthetic */ void getShadow$ui_text_release$annotations() {
    }

    public AndroidTextPaint(int i, float f) {
        super(i);
        this.density = f;
    }

    private final Paint getComposePaint() {
        Paint paint = this.backingComposePaint;
        if (paint != null) {
            return paint;
        }
        Paint asComposePaint = AndroidPaint_androidKt.asComposePaint(this);
        this.backingComposePaint = asComposePaint;
        return asComposePaint;
    }

    public final Shadow getShadow$ui_text_release() {
        return this.shadow;
    }

    public final void setShadow$ui_text_release(Shadow shadow2) {
        this.shadow = shadow2;
    }

    public final Brush getBrush$ui_text_release() {
        return this.brush;
    }

    public final void setBrush$ui_text_release(Brush brush2) {
        this.brush = brush2;
    }

    public final State<Shader> getShaderState$ui_text_release() {
        return this.shaderState;
    }

    public final void setShaderState$ui_text_release(State<? extends Shader> state) {
        this.shaderState = state;
    }

    /* renamed from: getBrushSize-VsRJwc0$ui_text_release  reason: not valid java name */
    public final Size m6844getBrushSizeVsRJwc0$ui_text_release() {
        return this.brushSize;
    }

    /* renamed from: setBrushSize-iaC8Vc4$ui_text_release  reason: not valid java name */
    public final void m6847setBrushSizeiaC8Vc4$ui_text_release(Size size) {
        this.brushSize = size;
    }

    public final void setTextDecoration(TextDecoration textDecoration2) {
        if (textDecoration2 != null && !Intrinsics.areEqual((Object) this.textDecoration, (Object) textDecoration2)) {
            this.textDecoration = textDecoration2;
            setUnderlineText(textDecoration2.contains(TextDecoration.Companion.getUnderline()));
            setStrikeThruText(this.textDecoration.contains(TextDecoration.Companion.getLineThrough()));
        }
    }

    public final void setShadow(Shadow shadow2) {
        if (shadow2 != null && !Intrinsics.areEqual((Object) this.shadow, (Object) shadow2)) {
            this.shadow = shadow2;
            if (Intrinsics.areEqual((Object) shadow2, (Object) Shadow.Companion.getNone())) {
                clearShadowLayer();
            } else {
                setShadowLayer(TextPaintExtensions_androidKt.correctBlurRadius(this.shadow.getBlurRadius()), Offset.m3987getXimpl(this.shadow.m4604getOffsetF1C5BW0()), Offset.m3988getYimpl(this.shadow.m4604getOffsetF1C5BW0()), ColorKt.m4293toArgb8_81llA(this.shadow.m4603getColor0d7_KjU()));
            }
        }
    }

    /* renamed from: setColor-8_81llA  reason: not valid java name */
    public final void m6848setColor8_81llA(long j) {
        if (j != 16) {
            setColor(ColorKt.m4293toArgb8_81llA(j));
            clearShader();
        }
    }

    /* renamed from: setBrush-12SF9DM$default  reason: not valid java name */
    public static /* synthetic */ void m6842setBrush12SF9DM$default(AndroidTextPaint androidTextPaint, Brush brush2, long j, float f, int i, Object obj) {
        if ((i & 4) != 0) {
            f = Float.NaN;
        }
        androidTextPaint.m6846setBrush12SF9DM(brush2, j, f);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
        if ((r0 == null ? false : androidx.compose.ui.geometry.Size.m4052equalsimpl0(r0.m4061unboximpl(), r4)) == false) goto L_0x0034;
     */
    /* renamed from: setBrush-12SF9DM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m6846setBrush12SF9DM(androidx.compose.ui.graphics.Brush r3, long r4, float r6) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0006
            r2.clearShader()
            return
        L_0x0006:
            boolean r0 = r3 instanceof androidx.compose.ui.graphics.SolidColor
            if (r0 == 0) goto L_0x0018
            androidx.compose.ui.graphics.SolidColor r3 = (androidx.compose.ui.graphics.SolidColor) r3
            long r3 = r3.m4616getValue0d7_KjU()
            long r3 = androidx.compose.ui.text.style.TextDrawStyleKt.m7006modulateDxMtmZc(r3, r6)
            r2.m6848setColor8_81llA(r3)
            return
        L_0x0018:
            boolean r0 = r3 instanceof androidx.compose.ui.graphics.ShaderBrush
            if (r0 == 0) goto L_0x006b
            androidx.compose.ui.graphics.Brush r0 = r2.brush
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            if (r0 == 0) goto L_0x0034
            androidx.compose.ui.geometry.Size r0 = r2.brushSize
            if (r0 != 0) goto L_0x002a
            r0 = 0
            goto L_0x0032
        L_0x002a:
            long r0 = r0.m4061unboximpl()
            boolean r0 = androidx.compose.ui.geometry.Size.m4052equalsimpl0(r0, r4)
        L_0x0032:
            if (r0 != 0) goto L_0x0052
        L_0x0034:
            r0 = 9205357640488583168(0x7fc000007fc00000, double:2.247117487993712E307)
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x0052
            r2.brush = r3
            androidx.compose.ui.geometry.Size r0 = androidx.compose.ui.geometry.Size.m4044boximpl(r4)
            r2.brushSize = r0
            androidx.compose.ui.text.platform.AndroidTextPaint$setBrush$1 r0 = new androidx.compose.ui.text.platform.AndroidTextPaint$setBrush$1
            r0.<init>(r3, r4)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            androidx.compose.runtime.State r3 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r0)
            r2.shaderState = r3
        L_0x0052:
            androidx.compose.ui.graphics.Paint r3 = r2.getComposePaint()
            androidx.compose.runtime.State<? extends android.graphics.Shader> r4 = r2.shaderState
            if (r4 == 0) goto L_0x0061
            java.lang.Object r4 = r4.getValue()
            android.graphics.Shader r4 = (android.graphics.Shader) r4
            goto L_0x0062
        L_0x0061:
            r4 = 0
        L_0x0062:
            r3.setShader(r4)
            r3 = r2
            android.text.TextPaint r3 = (android.text.TextPaint) r3
            androidx.compose.ui.text.platform.AndroidTextPaint_androidKt.setAlpha(r3, r6)
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.AndroidTextPaint.m6846setBrush12SF9DM(androidx.compose.ui.graphics.Brush, long, float):void");
    }

    public final void setDrawStyle(DrawStyle drawStyle2) {
        if (drawStyle2 != null && !Intrinsics.areEqual((Object) this.drawStyle, (Object) drawStyle2)) {
            this.drawStyle = drawStyle2;
            if (Intrinsics.areEqual((Object) drawStyle2, (Object) Fill.INSTANCE)) {
                setStyle(Paint.Style.FILL);
            } else if (drawStyle2 instanceof Stroke) {
                getComposePaint().m4514setStylek9PVt8s(PaintingStyle.Companion.m4523getStrokeTiuSbCo());
                Stroke stroke = (Stroke) drawStyle2;
                getComposePaint().setStrokeWidth(stroke.getWidth());
                getComposePaint().setStrokeMiterLimit(stroke.getMiter());
                getComposePaint().m4513setStrokeJoinWw9F2mQ(stroke.m4952getJoinLxFBmk8());
                getComposePaint().m4512setStrokeCapBeK7IIE(stroke.m4951getCapKaPHkGw());
                getComposePaint().setPathEffect(stroke.getPathEffect());
            }
        }
    }

    /* renamed from: getBlendMode-0nO6VwU  reason: not valid java name */
    public final int m6843getBlendMode0nO6VwU() {
        return this.backingBlendMode;
    }

    /* renamed from: setBlendMode-s9anfk8  reason: not valid java name */
    public final void m6845setBlendModes9anfk8(int i) {
        if (!BlendMode.m4139equalsimpl0(i, this.backingBlendMode)) {
            getComposePaint().m4509setBlendModes9anfk8(i);
            this.backingBlendMode = i;
        }
    }

    private final void clearShader() {
        this.shaderState = null;
        this.brush = null;
        this.brushSize = null;
        setShader((Shader) null);
    }
}
