package androidx.compose.foundation.contextmenu;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/ø\u0001\u0000¢\u0006\u0004\b0\u00101R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0015\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0016\u0010\u0006R\u0019\u0010\u0017\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0018\u0010\u0006R\u0019\u0010\u0019\u001a\u00020\u001aø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0019\u0010\"\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b#\u0010\u000fR\u0019\u0010$\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b%\u0010\u000fR\u0019\u0010&\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b'\u0010\u0006R\u0019\u0010(\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b)\u0010\u0006R\u0019\u0010*\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b+\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00062"}, d2 = {"Landroidx/compose/foundation/contextmenu/ContextMenuSpec;", "", "()V", "ContainerWidthMax", "Landroidx/compose/ui/unit/Dp;", "getContainerWidthMax-D9Ej5fM", "()F", "F", "ContainerWidthMin", "getContainerWidthMin-D9Ej5fM", "CornerRadius", "getCornerRadius-D9Ej5fM", "FontSize", "Landroidx/compose/ui/unit/TextUnit;", "getFontSize-XSAIIZE", "()J", "J", "FontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "HorizontalPadding", "getHorizontalPadding-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "LabelHorizontalTextAlignment", "Landroidx/compose/ui/text/style/TextAlign;", "getLabelHorizontalTextAlignment-e0LSkKk", "()I", "I", "LabelVerticalTextAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "getLabelVerticalTextAlignment", "()Landroidx/compose/ui/Alignment$Vertical;", "LetterSpacing", "getLetterSpacing-XSAIIZE", "LineHeight", "getLineHeight-XSAIIZE", "ListItemHeight", "getListItemHeight-D9Ej5fM", "MenuContainerElevation", "getMenuContainerElevation-D9Ej5fM", "VerticalPadding", "getVerticalPadding-D9Ej5fM", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "color", "Landroidx/compose/ui/graphics/Color;", "textStyle-8_81llA", "(J)Landroidx/compose/ui/text/TextStyle;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContextMenuUi.android.kt */
public final class ContextMenuSpec {
    public static final int $stable = 0;
    private static final float ContainerWidthMax = Dp.m7111constructorimpl((float) 280);
    private static final float ContainerWidthMin = Dp.m7111constructorimpl((float) 112);
    private static final float CornerRadius = Dp.m7111constructorimpl((float) 4);
    private static final long FontSize = TextUnitKt.getSp(14);
    private static final FontWeight FontWeight = FontWeight.Companion.getMedium();
    private static final float HorizontalPadding = Dp.m7111constructorimpl((float) 12);
    public static final ContextMenuSpec INSTANCE = new ContextMenuSpec();
    private static final float IconSize = Dp.m7111constructorimpl((float) 24);
    private static final int LabelHorizontalTextAlignment = TextAlign.Companion.m6991getStarte0LSkKk();
    private static final Alignment.Vertical LabelVerticalTextAlignment = Alignment.Companion.getCenterVertically();
    private static final long LetterSpacing = TextUnitKt.getSp(0.1f);
    private static final long LineHeight = TextUnitKt.getSp(20);
    private static final float ListItemHeight = Dp.m7111constructorimpl((float) 48);
    private static final float MenuContainerElevation = Dp.m7111constructorimpl((float) 3);
    private static final float VerticalPadding = Dp.m7111constructorimpl((float) 8);

    private ContextMenuSpec() {
    }

    /* renamed from: getContainerWidthMin-D9Ej5fM  reason: not valid java name */
    public final float m376getContainerWidthMinD9Ej5fM() {
        return ContainerWidthMin;
    }

    /* renamed from: getContainerWidthMax-D9Ej5fM  reason: not valid java name */
    public final float m375getContainerWidthMaxD9Ej5fM() {
        return ContainerWidthMax;
    }

    /* renamed from: getListItemHeight-D9Ej5fM  reason: not valid java name */
    public final float m384getListItemHeightD9Ej5fM() {
        return ListItemHeight;
    }

    /* renamed from: getMenuContainerElevation-D9Ej5fM  reason: not valid java name */
    public final float m385getMenuContainerElevationD9Ej5fM() {
        return MenuContainerElevation;
    }

    /* renamed from: getCornerRadius-D9Ej5fM  reason: not valid java name */
    public final float m377getCornerRadiusD9Ej5fM() {
        return CornerRadius;
    }

    public final Alignment.Vertical getLabelVerticalTextAlignment() {
        return LabelVerticalTextAlignment;
    }

    /* renamed from: getLabelHorizontalTextAlignment-e0LSkKk  reason: not valid java name */
    public final int m381getLabelHorizontalTextAlignmente0LSkKk() {
        return LabelHorizontalTextAlignment;
    }

    /* renamed from: getHorizontalPadding-D9Ej5fM  reason: not valid java name */
    public final float m379getHorizontalPaddingD9Ej5fM() {
        return HorizontalPadding;
    }

    /* renamed from: getVerticalPadding-D9Ej5fM  reason: not valid java name */
    public final float m386getVerticalPaddingD9Ej5fM() {
        return VerticalPadding;
    }

    /* renamed from: getIconSize-D9Ej5fM  reason: not valid java name */
    public final float m380getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* renamed from: getFontSize-XSAIIZE  reason: not valid java name */
    public final long m378getFontSizeXSAIIZE() {
        return FontSize;
    }

    public final FontWeight getFontWeight() {
        return FontWeight;
    }

    /* renamed from: getLineHeight-XSAIIZE  reason: not valid java name */
    public final long m383getLineHeightXSAIIZE() {
        return LineHeight;
    }

    /* renamed from: getLetterSpacing-XSAIIZE  reason: not valid java name */
    public final long m382getLetterSpacingXSAIIZE() {
        return LetterSpacing;
    }

    /* renamed from: textStyle-8_81llA  reason: not valid java name */
    public final TextStyle m387textStyle8_81llA(long j) {
        int i = LabelHorizontalTextAlignment;
        return new TextStyle(j, FontSize, FontWeight, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, LetterSpacing, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, i, 0, LineHeight, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16613240, (DefaultConstructorMarker) null);
    }
}
