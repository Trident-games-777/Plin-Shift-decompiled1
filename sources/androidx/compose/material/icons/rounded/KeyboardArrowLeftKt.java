package androidx.compose.material.icons.rounded;

import androidx.compose.material.icons.Icons;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00038FX\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"_keyboardArrowLeft", "Landroidx/compose/ui/graphics/vector/ImageVector;", "KeyboardArrowLeft", "Landroidx/compose/material/icons/Icons$Rounded;", "getKeyboardArrowLeft$annotations", "(Landroidx/compose/material/icons/Icons$Rounded;)V", "getKeyboardArrowLeft", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: KeyboardArrowLeft.kt */
public final class KeyboardArrowLeftKt {
    private static ImageVector _keyboardArrowLeft;

    @Deprecated(message = "Use the AutoMirrored version at Icons.AutoMirrored.Rounded.KeyboardArrowLeft", replaceWith = @ReplaceWith(expression = "Icons.AutoMirrored.Rounded.KeyboardArrowLeft", imports = {"androidx.compose.material.icons.automirrored.rounded.KeyboardArrowLeft"}))
    public static /* synthetic */ void getKeyboardArrowLeft$annotations(Icons.Rounded rounded) {
    }

    public static final ImageVector getKeyboardArrowLeft(Icons.Rounded rounded) {
        ImageVector imageVector = _keyboardArrowLeft;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        int r10 = StrokeCap.Companion.m4634getButtKaPHkGw();
        int r11 = StrokeJoin.Companion.m4644getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(14.71f, 15.88f);
        pathBuilder.lineTo(10.83f, 12.0f);
        pathBuilder.lineToRelative(3.88f, -3.88f);
        pathBuilder.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0.0f, -1.41f);
        pathBuilder.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0.0f);
        pathBuilder.lineTo(8.71f, 11.3f);
        pathBuilder.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0.0f, 1.41f);
        pathBuilder.lineToRelative(4.59f, 4.59f);
        pathBuilder.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0.0f);
        pathBuilder.curveToRelative(0.38f, -0.39f, 0.39f, -1.03f, 0.0f, -1.42f);
        pathBuilder.close();
        ImageVector build = ImageVector.Builder.m5052addPathoIyEayM$default(new ImageVector.Builder("Rounded.KeyboardArrowLeft", Dp.m7111constructorimpl(24.0f), Dp.m7111constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, (DefaultConstructorMarker) null), pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m4265getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, r10, r11, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _keyboardArrowLeft = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
