package androidx.compose.ui.text.platform;

import android.graphics.Shader;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ShaderBrush;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidTextPaint.android.kt */
final class AndroidTextPaint$setBrush$1 extends Lambda implements Function0<Shader> {
    final /* synthetic */ Brush $brush;
    final /* synthetic */ long $size;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidTextPaint$setBrush$1(Brush brush, long j) {
        super(0);
        this.$brush = brush;
        this.$size = j;
    }

    public final Shader invoke() {
        return ((ShaderBrush) this.$brush).m4590createShaderuvyYCjk(this.$size);
    }
}
