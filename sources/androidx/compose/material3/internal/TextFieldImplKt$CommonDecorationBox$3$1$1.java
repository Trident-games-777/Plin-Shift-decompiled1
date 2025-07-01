package androidx.compose.material3.internal;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/geometry/Size;", "invoke-uvyYCjk", "(J)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldImpl.kt */
final class TextFieldImplKt$CommonDecorationBox$3$1$1 extends Lambda implements Function1<Size, Unit> {
    final /* synthetic */ float $labelProgressValue;
    final /* synthetic */ MutableState<Size> $labelSize;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldImplKt$CommonDecorationBox$3$1$1(float f, MutableState<Size> mutableState) {
        super(1);
        this.$labelProgressValue = f;
        this.$labelSize = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m3000invokeuvyYCjk(((Size) obj).m4061unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-uvyYCjk  reason: not valid java name */
    public final void m3000invokeuvyYCjk(long j) {
        float r0 = Size.m4056getWidthimpl(j) * this.$labelProgressValue;
        float r4 = Size.m4053getHeightimpl(j) * this.$labelProgressValue;
        if (Size.m4056getWidthimpl(this.$labelSize.getValue().m4061unboximpl()) != r0 || Size.m4053getHeightimpl(this.$labelSize.getValue().m4061unboximpl()) != r4) {
            this.$labelSize.setValue(Size.m4044boximpl(SizeKt.Size(r0, r4)));
        }
    }
}
