package androidx.compose.material.icons.outlined;

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
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_accountBox", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AccountBox", "Landroidx/compose/material/icons/Icons$Outlined;", "getAccountBox", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AccountBox.kt */
public final class AccountBoxKt {
    private static ImageVector _accountBox;

    public static final ImageVector getAccountBox(Icons.Outlined outlined) {
        ImageVector imageVector = _accountBox;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        int r10 = StrokeCap.Companion.m4634getButtKaPHkGw();
        int r11 = StrokeJoin.Companion.m4644getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(19.0f, 3.0f);
        pathBuilder.horizontalLineTo(5.0f);
        pathBuilder.curveTo(3.9f, 3.0f, 3.0f, 3.9f, 3.0f, 5.0f);
        pathBuilder.verticalLineToRelative(14.0f);
        pathBuilder.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        pathBuilder.horizontalLineToRelative(14.0f);
        pathBuilder.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        pathBuilder.verticalLineTo(5.0f);
        pathBuilder.curveTo(21.0f, 3.9f, 20.1f, 3.0f, 19.0f, 3.0f);
        pathBuilder.close();
        pathBuilder.moveTo(17.0f, 19.0f);
        pathBuilder.horizontalLineTo(7.0f);
        pathBuilder.verticalLineToRelative(-0.24f);
        pathBuilder.curveTo(8.42f, 17.62f, 10.16f, 17.0f, 12.0f, 17.0f);
        pathBuilder.reflectiveCurveToRelative(3.58f, 0.62f, 5.0f, 1.76f);
        pathBuilder.verticalLineTo(19.0f);
        pathBuilder.close();
        pathBuilder.moveTo(19.0f, 17.86f);
        pathBuilder.curveTo(17.2f, 16.09f, 14.73f, 15.0f, 12.0f, 15.0f);
        pathBuilder.reflectiveCurveToRelative(-5.2f, 1.09f, -7.0f, 2.86f);
        pathBuilder.verticalLineTo(5.0f);
        pathBuilder.horizontalLineToRelative(14.0f);
        pathBuilder.verticalLineTo(17.86f);
        pathBuilder.close();
        pathBuilder.moveTo(12.0f, 13.0f);
        pathBuilder.curveToRelative(1.93f, 0.0f, 3.5f, -1.57f, 3.5f, -3.5f);
        pathBuilder.reflectiveCurveTo(13.93f, 6.0f, 12.0f, 6.0f);
        pathBuilder.curveToRelative(-1.93f, 0.0f, -3.5f, 1.57f, -3.5f, 3.5f);
        pathBuilder.reflectiveCurveTo(10.07f, 13.0f, 12.0f, 13.0f);
        pathBuilder.close();
        pathBuilder.moveTo(12.0f, 8.0f);
        pathBuilder.curveToRelative(0.83f, 0.0f, 1.5f, 0.67f, 1.5f, 1.5f);
        pathBuilder.reflectiveCurveTo(12.83f, 11.0f, 12.0f, 11.0f);
        pathBuilder.reflectiveCurveToRelative(-1.5f, -0.67f, -1.5f, -1.5f);
        pathBuilder.reflectiveCurveTo(11.17f, 8.0f, 12.0f, 8.0f);
        pathBuilder.close();
        ImageVector build = ImageVector.Builder.m5052addPathoIyEayM$default(new ImageVector.Builder("Outlined.AccountBox", Dp.m7111constructorimpl(24.0f), Dp.m7111constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, (DefaultConstructorMarker) null), pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m4265getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, r10, r11, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _accountBox = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
