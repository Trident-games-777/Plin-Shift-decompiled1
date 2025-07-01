package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: OutlinedTextField.kt */
final class OutlinedTextFieldKt$outlineCutout$1 extends Lambda implements Function1<ContentDrawScope, Unit> {
    final /* synthetic */ Function0<Size> $labelSize;
    final /* synthetic */ PaddingValues $paddingValues;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: OutlinedTextField.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutlinedTextFieldKt$outlineCutout$1(Function0<Size> function0, PaddingValues paddingValues) {
        super(1);
        this.$labelSize = function0;
        this.$paddingValues = paddingValues;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentDrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ContentDrawScope contentDrawScope) {
        float f;
        long r0 = this.$labelSize.invoke().m4061unboximpl();
        float r2 = Size.m4056getWidthimpl(r0);
        if (r2 > 0.0f) {
            float r4 = contentDrawScope.m7091toPx0680j_4(OutlinedTextFieldKt.OutlinedTextFieldInnerPadding);
            float r5 = contentDrawScope.m7091toPx0680j_4(this.$paddingValues.m790calculateLeftPaddingu2uoSUM(contentDrawScope.getLayoutDirection())) - r4;
            float f2 = (float) 2;
            float f3 = r2 + r5 + (r4 * f2);
            if (WhenMappings.$EnumSwitchMapping$0[contentDrawScope.getLayoutDirection().ordinal()] == 1) {
                f = Size.m4056getWidthimpl(contentDrawScope.m4865getSizeNHjbRc()) - f3;
            } else {
                f = RangesKt.coerceAtLeast(r5, 0.0f);
            }
            float f4 = f;
            if (WhenMappings.$EnumSwitchMapping$0[contentDrawScope.getLayoutDirection().ordinal()] == 1) {
                f3 = Size.m4056getWidthimpl(contentDrawScope.m4865getSizeNHjbRc()) - RangesKt.coerceAtLeast(r5, 0.0f);
            }
            float f5 = f3;
            float r02 = Size.m4053getHeightimpl(r0);
            float f6 = (-r02) / f2;
            float f7 = r02 / f2;
            int r13 = ClipOp.Companion.m4227getDifferencertfAjoo();
            DrawContext drawContext = contentDrawScope.getDrawContext();
            long r22 = drawContext.m4806getSizeNHjbRc();
            drawContext.getCanvas().save();
            try {
                drawContext.getTransform().m4926clipRectN_I0leg(f4, f6, f5, f7, r13);
                contentDrawScope.drawContent();
                drawContext.getCanvas().restore();
                drawContext.m4807setSizeuvyYCjk(r22);
            } catch (Throwable th) {
                Throwable th2 = th;
                drawContext.getCanvas().restore();
                drawContext.m4807setSizeuvyYCjk(r22);
                throw th2;
            }
        } else {
            contentDrawScope.drawContent();
        }
    }
}
