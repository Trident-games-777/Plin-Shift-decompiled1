package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/animation/core/AnimationVector4D;", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ColorVectorConverter.kt */
final class ColorVectorConverterKt$ColorToVector$1 extends Lambda implements Function1<ColorSpace, TwoWayConverter<Color, AnimationVector4D>> {
    public static final ColorVectorConverterKt$ColorToVector$1 INSTANCE = new ColorVectorConverterKt$ColorToVector$1();

    ColorVectorConverterKt$ColorToVector$1() {
        super(1);
    }

    public final TwoWayConverter<Color, AnimationVector4D> invoke(final ColorSpace colorSpace) {
        return VectorConvertersKt.TwoWayConverter(AnonymousClass1.INSTANCE, new Function1<AnimationVector4D, Color>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return Color.m4229boximpl(m77invokevNxB06k((AnimationVector4D) obj));
            }

            /* renamed from: invoke-vNxB06k  reason: not valid java name */
            public final long m77invokevNxB06k(AnimationVector4D animationVector4D) {
                float v2 = animationVector4D.getV2();
                float f = 0.0f;
                if (v2 < 0.0f) {
                    v2 = 0.0f;
                }
                float f2 = 1.0f;
                if (v2 > 1.0f) {
                    v2 = 1.0f;
                }
                float v3 = animationVector4D.getV3();
                float f3 = -0.5f;
                if (v3 < -0.5f) {
                    v3 = -0.5f;
                }
                float f4 = 0.5f;
                if (v3 > 0.5f) {
                    v3 = 0.5f;
                }
                float v4 = animationVector4D.getV4();
                if (v4 >= -0.5f) {
                    f3 = v4;
                }
                if (f3 <= 0.5f) {
                    f4 = f3;
                }
                float v1 = animationVector4D.getV1();
                if (v1 >= 0.0f) {
                    f = v1;
                }
                if (f <= 1.0f) {
                    f2 = f;
                }
                return Color.m4236convertvNxB06k(ColorKt.Color(v2, v3, f4, f2, ColorSpaces.INSTANCE.getOklab()), colorSpace);
            }
        });
    }
}
