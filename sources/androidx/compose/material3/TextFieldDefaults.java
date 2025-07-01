package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.tokens.FilledTextFieldTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b7\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\\\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u001f2\b\b\u0002\u0010\u001c\u001a\u00020\u00152\b\b\u0002\u0010-\u001a\u00020\u00042\b\b\u0002\u0010.\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b/\u00100J7\u00101\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)2\u0006\u0010,\u001a\u00020\u001f2\b\b\u0002\u0010\u001c\u001a\u00020\u0015H\u0007¢\u0006\u0002\u00102J¦\u0002\u00103\u001a\u00020$2\u0006\u00104\u001a\u0002052\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020$07¢\u0006\u0002\b82\u0006\u0010%\u001a\u00020&2\u0006\u00109\u001a\u00020&2\u0006\u0010:\u001a\u00020;2\u0006\u0010(\u001a\u00020)2\b\b\u0002\u0010'\u001a\u00020&2\u0015\b\u0002\u0010<\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000107¢\u0006\u0002\b82\u0015\b\u0002\u0010=\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000107¢\u0006\u0002\b82\u0015\b\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000107¢\u0006\u0002\b82\u0015\b\u0002\u0010?\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000107¢\u0006\u0002\b82\u0015\b\u0002\u0010@\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000107¢\u0006\u0002\b82\u0015\b\u0002\u0010A\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000107¢\u0006\u0002\b82\u0015\b\u0002\u0010B\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000107¢\u0006\u0002\b82\b\b\u0002\u0010\u001c\u001a\u00020\u00152\b\b\u0002\u0010,\u001a\u00020\u001f2\b\b\u0002\u0010C\u001a\u00020D2\u0013\b\u0002\u0010E\u001a\r\u0012\u0004\u0012\u00020$07¢\u0006\u0002\b8H\u0007¢\u0006\u0002\u0010FJ\r\u0010,\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010GJÂ\u0003\u0010,\u001a\u00020\u001f2\b\b\u0002\u0010H\u001a\u00020I2\b\b\u0002\u0010J\u001a\u00020I2\b\b\u0002\u0010K\u001a\u00020I2\b\b\u0002\u0010L\u001a\u00020I2\b\b\u0002\u0010M\u001a\u00020I2\b\b\u0002\u0010N\u001a\u00020I2\b\b\u0002\u0010O\u001a\u00020I2\b\b\u0002\u0010P\u001a\u00020I2\b\b\u0002\u0010Q\u001a\u00020I2\b\b\u0002\u0010R\u001a\u00020I2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010T2\b\b\u0002\u0010U\u001a\u00020I2\b\b\u0002\u0010V\u001a\u00020I2\b\b\u0002\u0010W\u001a\u00020I2\b\b\u0002\u0010X\u001a\u00020I2\b\b\u0002\u0010Y\u001a\u00020I2\b\b\u0002\u0010Z\u001a\u00020I2\b\b\u0002\u0010[\u001a\u00020I2\b\b\u0002\u0010\\\u001a\u00020I2\b\b\u0002\u0010]\u001a\u00020I2\b\b\u0002\u0010^\u001a\u00020I2\b\b\u0002\u0010_\u001a\u00020I2\b\b\u0002\u0010`\u001a\u00020I2\b\b\u0002\u0010a\u001a\u00020I2\b\b\u0002\u0010b\u001a\u00020I2\b\b\u0002\u0010c\u001a\u00020I2\b\b\u0002\u0010d\u001a\u00020I2\b\b\u0002\u0010e\u001a\u00020I2\b\b\u0002\u0010f\u001a\u00020I2\b\b\u0002\u0010g\u001a\u00020I2\b\b\u0002\u0010h\u001a\u00020I2\b\b\u0002\u0010i\u001a\u00020I2\b\b\u0002\u0010j\u001a\u00020I2\b\b\u0002\u0010k\u001a\u00020I2\b\b\u0002\u0010l\u001a\u00020I2\b\b\u0002\u0010m\u001a\u00020I2\b\b\u0002\u0010n\u001a\u00020I2\b\b\u0002\u0010o\u001a\u00020I2\b\b\u0002\u0010p\u001a\u00020I2\b\b\u0002\u0010q\u001a\u00020I2\b\b\u0002\u0010r\u001a\u00020I2\b\b\u0002\u0010s\u001a\u00020I2\b\b\u0002\u0010t\u001a\u00020IH\u0007ø\u0001\u0000¢\u0006\u0004\bu\u0010vJ8\u0010w\u001a\u00020D2\b\b\u0002\u0010x\u001a\u00020\u00042\b\b\u0002\u0010y\u001a\u00020\u00042\b\b\u0002\u0010z\u001a\u00020\u00042\b\b\u0002\u0010{\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b|\u0010}J8\u0010~\u001a\u00020D2\b\b\u0002\u0010x\u001a\u00020\u00042\b\b\u0002\u0010z\u001a\u00020\u00042\b\b\u0002\u0010y\u001a\u00020\u00042\b\b\u0002\u0010{\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0010}J<\u0010\u0001\u001a\u00020D2\b\b\u0002\u0010x\u001a\u00020\u00042\b\b\u0002\u0010z\u001a\u00020\u00042\b\b\u0002\u0010y\u001a\u00020\u00042\b\b\u0002\u0010{\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010}J<\u0010\u0001\u001a\u00020D2\b\b\u0002\u0010x\u001a\u00020\u00042\b\b\u0002\u0010z\u001a\u00020\u00042\b\b\u0002\u0010y\u001a\u00020\u00042\b\b\u0002\u0010{\u001a\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010}J<\u0010\u0001\u001a\u00020D2\b\b\u0002\u0010x\u001a\u00020\u00042\b\b\u0002\u0010y\u001a\u00020\u00042\b\b\u0002\u0010z\u001a\u00020\u00042\b\b\u0002\u0010{\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010}J<\u0010\u0001\u001a\u00020D2\b\b\u0002\u0010x\u001a\u00020\u00042\b\b\u0002\u0010z\u001a\u00020\u00042\b\b\u0002\u0010y\u001a\u00020\u00042\b\b\u0002\u0010{\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010}JM\u0010\u0001\u001a\u00020+*\u00020+2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)2\u0006\u0010,\u001a\u00020\u001f2\b\b\u0002\u0010-\u001a\u00020\u00042\b\b\u0002\u0010.\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\t\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0019\u0010\r\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R$\u0010\u000f\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0007R\u0019\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0013\u0010\u0007R\u001a\u0010\u0014\u001a\u00020\u00158GX\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u00158GX\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0002\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u001c\u001a\u00020\u00158G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0018R\u0018\u0010\u001e\u001a\u00020\u001f*\u00020 8AX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0001"}, d2 = {"Landroidx/compose/material3/TextFieldDefaults;", "", "()V", "FocusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "getFocusedBorderThickness-D9Ej5fM$annotations", "getFocusedBorderThickness-D9Ej5fM", "()F", "F", "FocusedIndicatorThickness", "getFocusedIndicatorThickness-D9Ej5fM", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM$annotations", "getUnfocusedBorderThickness-D9Ej5fM", "UnfocusedIndicatorThickness", "getUnfocusedIndicatorThickness-D9Ej5fM", "filledShape", "Landroidx/compose/ui/graphics/Shape;", "getFilledShape$annotations", "getFilledShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "outlinedShape", "getOutlinedShape$annotations", "getOutlinedShape", "shape", "getShape", "defaultTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultTextFieldColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "Container", "", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "modifier", "Landroidx/compose/ui/Modifier;", "colors", "focusedIndicatorLineThickness", "unfocusedIndicatorLineThickness", "Container-4EFweAY", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "ContainerBox", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)V", "DecorationBox", "value", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "container", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "colors-0hiis_0", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIIII)Landroidx/compose/material3/TextFieldColors;", "contentPaddingWithLabel", "start", "end", "top", "bottom", "contentPaddingWithLabel-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "contentPaddingWithoutLabel", "contentPaddingWithoutLabel-a9UjIt4", "outlinedTextFieldPadding", "outlinedTextFieldPadding-a9UjIt4", "supportingTextPadding", "supportingTextPadding-a9UjIt4$material3_release", "textFieldWithLabelPadding", "textFieldWithLabelPadding-a9UjIt4", "textFieldWithoutLabelPadding", "textFieldWithoutLabelPadding-a9UjIt4", "indicatorLine", "indicatorLine-gv0btCI", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;FF)Landroidx/compose/ui/Modifier;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDefaults.kt */
public final class TextFieldDefaults {
    public static final int $stable = 0;
    private static final float FocusedBorderThickness;
    private static final float FocusedIndicatorThickness;
    public static final TextFieldDefaults INSTANCE = new TextFieldDefaults();
    private static final float MinHeight = Dp.m7111constructorimpl((float) 56);
    private static final float MinWidth = Dp.m7111constructorimpl((float) 280);
    private static final float UnfocusedBorderThickness;
    private static final float UnfocusedIndicatorThickness;

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.shape`", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.shape", imports = {}))
    public static /* synthetic */ void getFilledShape$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Split into `TextFieldDefaults.FocusedIndicatorThickness` and `OutlinedTextFieldDefaults.FocusedBorderThickness`. Please update as appropriate.", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.FocusedIndicatorThickness", imports = {}))
    /* renamed from: getFocusedBorderThickness-D9Ej5fM$annotations  reason: not valid java name */
    public static /* synthetic */ void m2663getFocusedBorderThicknessD9Ej5fM$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `OutlinedTextFieldDefaults.shape`", replaceWith = @ReplaceWith(expression = "OutlinedTextFieldDefaults.shape", imports = {"androidx.compose.material.OutlinedTextFieldDefaults"}))
    public static /* synthetic */ void getOutlinedShape$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Split into `TextFieldDefaults.UnfocusedIndicatorThickness` and `OutlinedTextFieldDefaults.UnfocusedBorderThickness`. Please update as appropriate.", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.UnfocusedIndicatorThickness", imports = {}))
    /* renamed from: getUnfocusedBorderThickness-D9Ej5fM$annotations  reason: not valid java name */
    public static /* synthetic */ void m2664getUnfocusedBorderThicknessD9Ej5fM$annotations() {
    }

    private TextFieldDefaults() {
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1941327459, "C60@2756L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1941327459, i, -1, "androidx.compose.material3.TextFieldDefaults.<get-shape> (TextFieldDefaults.kt:60)");
        }
        Shape value = ShapesKt.getValue(FilledTextFieldTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    /* renamed from: getMinHeight-D9Ej5fM  reason: not valid java name */
    public final float m2676getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM  reason: not valid java name */
    public final float m2677getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    /* renamed from: getUnfocusedIndicatorThickness-D9Ej5fM  reason: not valid java name */
    public final float m2679getUnfocusedIndicatorThicknessD9Ej5fM() {
        return UnfocusedIndicatorThickness;
    }

    /* renamed from: getFocusedIndicatorThickness-D9Ej5fM  reason: not valid java name */
    public final float m2675getFocusedIndicatorThicknessD9Ej5fM() {
        return FocusedIndicatorThickness;
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0215  */
    /* JADX WARNING: Removed duplicated region for block: B:144:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f3  */
    /* renamed from: Container-4EFweAY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m2670Container4EFweAY(boolean r22, boolean r23, androidx.compose.foundation.interaction.InteractionSource r24, androidx.compose.ui.Modifier r25, androidx.compose.material3.TextFieldColors r26, androidx.compose.ui.graphics.Shape r27, float r28, float r29, androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r21 = this;
            r0 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r10 = r31
            r11 = r32
            r1 = -818661242(0xffffffffcf343886, float:-3.0236032E9)
            r5 = r30
            androidx.compose.runtime.Composer r5 = r5.startRestartGroup(r1)
            java.lang.String r6 = "C(Container)P(1,4,3,5!1,6,2:c#ui.unit.Dp,7:c#ui.unit.Dp)105@4681L8,106@4732L5,110@4933L25,112@5006L198,116@5213L496:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r6)
            r6 = r11 & 1
            if (r6 == 0) goto L_0x0021
            r6 = r10 | 6
            goto L_0x0031
        L_0x0021:
            r6 = r10 & 6
            if (r6 != 0) goto L_0x0030
            boolean r6 = r5.changed((boolean) r2)
            if (r6 == 0) goto L_0x002d
            r6 = 4
            goto L_0x002e
        L_0x002d:
            r6 = 2
        L_0x002e:
            r6 = r6 | r10
            goto L_0x0031
        L_0x0030:
            r6 = r10
        L_0x0031:
            r7 = r11 & 2
            if (r7 == 0) goto L_0x0038
            r6 = r6 | 48
            goto L_0x0048
        L_0x0038:
            r7 = r10 & 48
            if (r7 != 0) goto L_0x0048
            boolean r7 = r5.changed((boolean) r3)
            if (r7 == 0) goto L_0x0045
            r7 = 32
            goto L_0x0047
        L_0x0045:
            r7 = 16
        L_0x0047:
            r6 = r6 | r7
        L_0x0048:
            r7 = r11 & 4
            if (r7 == 0) goto L_0x004f
            r6 = r6 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004f:
            r7 = r10 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x005f
            boolean r7 = r5.changed((java.lang.Object) r4)
            if (r7 == 0) goto L_0x005c
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005c:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r6 = r6 | r7
        L_0x005f:
            r7 = r11 & 8
            if (r7 == 0) goto L_0x0066
            r6 = r6 | 3072(0xc00, float:4.305E-42)
            goto L_0x0079
        L_0x0066:
            r8 = r10 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x0079
            r8 = r25
            boolean r9 = r5.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0075
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0077
        L_0x0075:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0077:
            r6 = r6 | r9
            goto L_0x007b
        L_0x0079:
            r8 = r25
        L_0x007b:
            r9 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x0094
            r9 = r11 & 16
            if (r9 != 0) goto L_0x008e
            r9 = r26
            boolean r12 = r5.changed((java.lang.Object) r9)
            if (r12 == 0) goto L_0x0090
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0092
        L_0x008e:
            r9 = r26
        L_0x0090:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0092:
            r6 = r6 | r12
            goto L_0x0096
        L_0x0094:
            r9 = r26
        L_0x0096:
            r12 = 196608(0x30000, float:2.75506E-40)
            r12 = r12 & r10
            if (r12 != 0) goto L_0x00b0
            r12 = r11 & 32
            if (r12 != 0) goto L_0x00aa
            r12 = r27
            boolean r13 = r5.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x00ac
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ae
        L_0x00aa:
            r12 = r27
        L_0x00ac:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00ae:
            r6 = r6 | r13
            goto L_0x00b2
        L_0x00b0:
            r12 = r27
        L_0x00b2:
            r13 = 1572864(0x180000, float:2.204052E-39)
            r13 = r13 & r10
            if (r13 != 0) goto L_0x00cc
            r13 = r11 & 64
            if (r13 != 0) goto L_0x00c6
            r13 = r28
            boolean r14 = r5.changed((float) r13)
            if (r14 == 0) goto L_0x00c8
            r14 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ca
        L_0x00c6:
            r13 = r28
        L_0x00c8:
            r14 = 524288(0x80000, float:7.34684E-40)
        L_0x00ca:
            r6 = r6 | r14
            goto L_0x00ce
        L_0x00cc:
            r13 = r28
        L_0x00ce:
            r14 = 12582912(0xc00000, float:1.7632415E-38)
            r14 = r14 & r10
            if (r14 != 0) goto L_0x00e8
            r14 = r11 & 128(0x80, float:1.794E-43)
            if (r14 != 0) goto L_0x00e2
            r14 = r29
            boolean r15 = r5.changed((float) r14)
            if (r15 == 0) goto L_0x00e4
            r15 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00e6
        L_0x00e2:
            r14 = r29
        L_0x00e4:
            r15 = 4194304(0x400000, float:5.877472E-39)
        L_0x00e6:
            r6 = r6 | r15
            goto L_0x00ea
        L_0x00e8:
            r14 = r29
        L_0x00ea:
            r15 = r11 & 256(0x100, float:3.59E-43)
            r16 = 100663296(0x6000000, float:2.4074124E-35)
            if (r15 == 0) goto L_0x00f3
            r6 = r6 | r16
            goto L_0x0103
        L_0x00f3:
            r15 = r10 & r16
            if (r15 != 0) goto L_0x0103
            boolean r15 = r5.changed((java.lang.Object) r0)
            if (r15 == 0) goto L_0x0100
            r15 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0102
        L_0x0100:
            r15 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0102:
            r6 = r6 | r15
        L_0x0103:
            r15 = 38347923(0x2492493, float:1.4777644E-37)
            r15 = r15 & r6
            r1 = 38347922(0x2492492, float:1.4777643E-37)
            if (r15 != r1) goto L_0x011e
            boolean r1 = r5.getSkipping()
            if (r1 != 0) goto L_0x0113
            goto L_0x011e
        L_0x0113:
            r5.skipToGroupEnd()
            r6 = r9
            r7 = r12
            r9 = r14
            r12 = r5
            r5 = r8
            r8 = r13
            goto L_0x020f
        L_0x011e:
            r5.startDefaults()
            r1 = r10 & 1
            r17 = -3670017(0xffffffffffc7ffff, float:NaN)
            r18 = -458753(0xfffffffffff8ffff, float:NaN)
            r19 = -57345(0xffffffffffff1fff, float:NaN)
            r30 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r15 = 6
            if (r1 == 0) goto L_0x0155
            boolean r1 = r5.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0139
            goto L_0x0155
        L_0x0139:
            r5.skipToGroupEnd()
            r1 = r11 & 16
            if (r1 == 0) goto L_0x0142
            r6 = r6 & r19
        L_0x0142:
            r1 = r11 & 32
            if (r1 == 0) goto L_0x0148
            r6 = r6 & r18
        L_0x0148:
            r1 = r11 & 64
            if (r1 == 0) goto L_0x014e
            r6 = r6 & r17
        L_0x014e:
            r1 = r11 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x018c
            r6 = r6 & r30
            goto L_0x018c
        L_0x0155:
            if (r7 == 0) goto L_0x015c
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r8 = r1
        L_0x015c:
            r1 = r11 & 16
            if (r1 == 0) goto L_0x016b
            int r1 = r6 >> 24
            r1 = r1 & 14
            androidx.compose.material3.TextFieldColors r1 = r0.colors(r5, r1)
            r6 = r6 & r19
            r9 = r1
        L_0x016b:
            r1 = r11 & 32
            if (r1 == 0) goto L_0x0178
            androidx.compose.material3.TextFieldDefaults r1 = INSTANCE
            androidx.compose.ui.graphics.Shape r1 = r1.getShape(r5, r15)
            r6 = r6 & r18
            r12 = r1
        L_0x0178:
            r1 = r11 & 64
            if (r1 == 0) goto L_0x0181
            float r1 = FocusedIndicatorThickness
            r6 = r6 & r17
            r13 = r1
        L_0x0181:
            r1 = r11 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x018c
            float r1 = UnfocusedIndicatorThickness
            r6 = r6 & r30
            r7 = r1
            r1 = r12
            goto L_0x018e
        L_0x018c:
            r1 = r12
            r7 = r14
        L_0x018e:
            r12 = r6
            r6 = r13
            r5.endDefaults()
            boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r13 == 0) goto L_0x01a5
            r13 = -1
            java.lang.String r14 = "androidx.compose.material3.TextFieldDefaults.Container (TextFieldDefaults.kt:109)"
            r30 = r15
            r15 = -818661242(0xffffffffcf343886, float:-3.0236032E9)
            androidx.compose.runtime.ComposerKt.traceEventStart(r15, r12, r13, r14)
            goto L_0x01a7
        L_0x01a5:
            r30 = r15
        L_0x01a7:
            int r12 = r12 >> 6
            r12 = r12 & 14
            androidx.compose.runtime.State r12 = androidx.compose.foundation.interaction.FocusInteractionKt.collectIsFocusedAsState(r4, r5, r12)
            java.lang.Object r12 = r12.getValue()
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            long r12 = r9.m2607containerColorXeAY9LY$material3_release(r2, r3, r12)
            r14 = 150(0x96, float:2.1E-43)
            r15 = 0
            r0 = 0
            r2 = r30
            androidx.compose.animation.core.TweenSpec r0 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r14, r15, r0, r2, r0)
            r14 = r0
            androidx.compose.animation.core.AnimationSpec r14 = (androidx.compose.animation.core.AnimationSpec) r14
            r18 = 48
            r19 = 12
            r0 = r15
            r15 = 0
            r16 = 0
            r17 = r5
            androidx.compose.runtime.State r2 = androidx.compose.animation.SingleValueAnimationKt.m123animateColorAsStateeuL9pac(r12, r14, r15, r16, r17, r18, r19)
            r12 = r17
            androidx.compose.material3.TextFieldDefaults$Container$1 r5 = new androidx.compose.material3.TextFieldDefaults$Container$1
            r5.<init>(r2)
            androidx.compose.material3.TextFieldDefaults$sam$androidx_compose_ui_graphics_ColorProducer$0 r2 = new androidx.compose.material3.TextFieldDefaults$sam$androidx_compose_ui_graphics_ColorProducer$0
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r2.<init>(r5)
            androidx.compose.ui.graphics.ColorProducer r2 = (androidx.compose.ui.graphics.ColorProducer) r2
            androidx.compose.ui.Modifier r2 = androidx.compose.material3.internal.TextFieldImplKt.textFieldBackground(r8, r2, r1)
            r13 = r0
            r5 = r9
            r0 = r21
            r9 = r1
            r1 = r2
            r2 = r22
            androidx.compose.ui.Modifier r1 = r0.m2680indicatorLinegv0btCI(r1, r2, r3, r4, r5, r6, r7)
            androidx.compose.foundation.layout.BoxKt.Box(r1, r12, r13)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0204
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0204:
            r20 = r6
            r6 = r5
            r5 = r8
            r8 = r20
            r20 = r9
            r9 = r7
            r7 = r20
        L_0x020f:
            androidx.compose.runtime.ScopeUpdateScope r12 = r12.endRestartGroup()
            if (r12 == 0) goto L_0x0227
            androidx.compose.material3.TextFieldDefaults$Container$2 r0 = new androidx.compose.material3.TextFieldDefaults$Container$2
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x0227:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.m2670Container4EFweAY(boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.ui.Modifier, androidx.compose.material3.TextFieldColors, androidx.compose.ui.graphics.Shape, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: indicatorLine-gv0btCI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m2665indicatorLinegv0btCI$default(TextFieldDefaults textFieldDefaults, Modifier modifier, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, float f, float f2, int i, Object obj) {
        float f3;
        if ((i & 16) != 0) {
            f = FocusedIndicatorThickness;
        }
        float f4 = f;
        if ((i & 32) != 0) {
            f3 = UnfocusedIndicatorThickness;
        } else {
            f3 = f2;
        }
        return textFieldDefaults.m2680indicatorLinegv0btCI(modifier, z, z2, interactionSource, textFieldColors, f4, f3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x021a  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x022e  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0254  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0257  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x0283  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x02a0  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x047e  */
    /* JADX WARNING: Removed duplicated region for block: B:273:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0131  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void DecorationBox(java.lang.String r36, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, boolean r38, boolean r39, androidx.compose.ui.text.input.VisualTransformation r40, androidx.compose.foundation.interaction.InteractionSource r41, boolean r42, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r48, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, androidx.compose.ui.graphics.Shape r50, androidx.compose.material3.TextFieldColors r51, androidx.compose.foundation.layout.PaddingValues r52, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r53, androidx.compose.runtime.Composer r54, int r55, int r56, int r57) {
        /*
            r35 = this;
            r1 = r35
            r0 = r55
            r2 = r56
            r3 = r57
            r4 = 289640444(0x11438ffc, float:1.5427156E-28)
            r5 = r54
            androidx.compose.runtime.Composer r4 = r5.startRestartGroup(r4)
            java.lang.String r5 = "C(DecorationBox)P(16,4,3,12,17,5,6,7,9,8,15,10,13,14,11!1,2)256@13034L5,257@13075L8,264@13325L428,277@13770L707:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r5)
            r5 = r3 & 1
            if (r5 == 0) goto L_0x0020
            r5 = r0 | 6
            r8 = r5
            r5 = r36
            goto L_0x0034
        L_0x0020:
            r5 = r0 & 6
            if (r5 != 0) goto L_0x0031
            r5 = r36
            boolean r8 = r4.changed((java.lang.Object) r5)
            if (r8 == 0) goto L_0x002e
            r8 = 4
            goto L_0x002f
        L_0x002e:
            r8 = 2
        L_0x002f:
            r8 = r8 | r0
            goto L_0x0034
        L_0x0031:
            r5 = r36
            r8 = r0
        L_0x0034:
            r9 = r3 & 2
            if (r9 == 0) goto L_0x003b
            r8 = r8 | 48
            goto L_0x004e
        L_0x003b:
            r9 = r0 & 48
            if (r9 != 0) goto L_0x004e
            r9 = r37
            boolean r12 = r4.changedInstance(r9)
            if (r12 == 0) goto L_0x004a
            r12 = 32
            goto L_0x004c
        L_0x004a:
            r12 = 16
        L_0x004c:
            r8 = r8 | r12
            goto L_0x0050
        L_0x004e:
            r9 = r37
        L_0x0050:
            r12 = r3 & 4
            if (r12 == 0) goto L_0x0057
            r8 = r8 | 384(0x180, float:5.38E-43)
            goto L_0x006a
        L_0x0057:
            r12 = r0 & 384(0x180, float:5.38E-43)
            if (r12 != 0) goto L_0x006a
            r12 = r38
            boolean r15 = r4.changed((boolean) r12)
            if (r15 == 0) goto L_0x0066
            r15 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0066:
            r15 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r8 = r8 | r15
            goto L_0x006c
        L_0x006a:
            r12 = r38
        L_0x006c:
            r15 = r3 & 8
            r16 = 2048(0x800, float:2.87E-42)
            r17 = 1024(0x400, float:1.435E-42)
            if (r15 == 0) goto L_0x0077
            r8 = r8 | 3072(0xc00, float:4.305E-42)
            goto L_0x008b
        L_0x0077:
            r15 = r0 & 3072(0xc00, float:4.305E-42)
            if (r15 != 0) goto L_0x008b
            r15 = r39
            boolean r18 = r4.changed((boolean) r15)
            if (r18 == 0) goto L_0x0086
            r18 = r16
            goto L_0x0088
        L_0x0086:
            r18 = r17
        L_0x0088:
            r8 = r8 | r18
            goto L_0x008d
        L_0x008b:
            r15 = r39
        L_0x008d:
            r18 = r3 & 16
            r19 = 8192(0x2000, float:1.14794E-41)
            r20 = 16384(0x4000, float:2.2959E-41)
            if (r18 == 0) goto L_0x0098
            r8 = r8 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00ac
        L_0x0098:
            r6 = r0 & 24576(0x6000, float:3.4438E-41)
            if (r6 != 0) goto L_0x00ac
            r6 = r40
            boolean r18 = r4.changed((java.lang.Object) r6)
            if (r18 == 0) goto L_0x00a7
            r18 = r20
            goto L_0x00a9
        L_0x00a7:
            r18 = r19
        L_0x00a9:
            r8 = r8 | r18
            goto L_0x00ae
        L_0x00ac:
            r6 = r40
        L_0x00ae:
            r18 = r3 & 32
            r21 = 196608(0x30000, float:2.75506E-40)
            r22 = 65536(0x10000, float:9.18355E-41)
            if (r18 == 0) goto L_0x00bb
            r8 = r8 | r21
            r7 = r41
            goto L_0x00ce
        L_0x00bb:
            r18 = r0 & r21
            r7 = r41
            if (r18 != 0) goto L_0x00ce
            boolean r23 = r4.changed((java.lang.Object) r7)
            if (r23 == 0) goto L_0x00ca
            r23 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00cc
        L_0x00ca:
            r23 = r22
        L_0x00cc:
            r8 = r8 | r23
        L_0x00ce:
            r23 = r3 & 64
            r24 = 1572864(0x180000, float:2.204052E-39)
            if (r23 == 0) goto L_0x00d9
            r8 = r8 | r24
            r10 = r42
            goto L_0x00ec
        L_0x00d9:
            r24 = r0 & r24
            r10 = r42
            if (r24 != 0) goto L_0x00ec
            boolean r25 = r4.changed((boolean) r10)
            if (r25 == 0) goto L_0x00e8
            r25 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ea
        L_0x00e8:
            r25 = 524288(0x80000, float:7.34684E-40)
        L_0x00ea:
            r8 = r8 | r25
        L_0x00ec:
            r11 = r3 & 128(0x80, float:1.794E-43)
            r26 = 12582912(0xc00000, float:1.7632415E-38)
            if (r11 == 0) goto L_0x00f7
            r8 = r8 | r26
            r13 = r43
            goto L_0x010a
        L_0x00f7:
            r27 = r0 & r26
            r13 = r43
            if (r27 != 0) goto L_0x010a
            boolean r28 = r4.changedInstance(r13)
            if (r28 == 0) goto L_0x0106
            r28 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0108
        L_0x0106:
            r28 = 4194304(0x400000, float:5.877472E-39)
        L_0x0108:
            r8 = r8 | r28
        L_0x010a:
            r14 = r3 & 256(0x100, float:3.59E-43)
            r29 = 100663296(0x6000000, float:2.4074124E-35)
            if (r14 == 0) goto L_0x0115
            r8 = r8 | r29
            r0 = r44
            goto L_0x0128
        L_0x0115:
            r30 = r0 & r29
            r0 = r44
            if (r30 != 0) goto L_0x0128
            boolean r30 = r4.changedInstance(r0)
            if (r30 == 0) goto L_0x0124
            r30 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0126
        L_0x0124:
            r30 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0126:
            r8 = r8 | r30
        L_0x0128:
            r0 = r3 & 512(0x200, float:7.175E-43)
            r30 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x0131
            r8 = r8 | r30
            goto L_0x0147
        L_0x0131:
            r30 = r55 & r30
            if (r30 != 0) goto L_0x0147
            r30 = r0
            r0 = r45
            boolean r31 = r4.changedInstance(r0)
            if (r31 == 0) goto L_0x0142
            r31 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0144
        L_0x0142:
            r31 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0144:
            r8 = r8 | r31
            goto L_0x014b
        L_0x0147:
            r30 = r0
            r0 = r45
        L_0x014b:
            r0 = r3 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0156
            r18 = r2 | 6
            r31 = r0
            r0 = r46
            goto L_0x0172
        L_0x0156:
            r31 = r2 & 6
            if (r31 != 0) goto L_0x016c
            r31 = r0
            r0 = r46
            boolean r32 = r4.changedInstance(r0)
            if (r32 == 0) goto L_0x0167
            r18 = 4
            goto L_0x0169
        L_0x0167:
            r18 = 2
        L_0x0169:
            r18 = r2 | r18
            goto L_0x0172
        L_0x016c:
            r31 = r0
            r0 = r46
            r18 = r2
        L_0x0172:
            r0 = r3 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x017b
            r18 = r18 | 48
            r32 = r0
            goto L_0x0195
        L_0x017b:
            r32 = r2 & 48
            if (r32 != 0) goto L_0x0191
            r32 = r0
            r0 = r47
            boolean r33 = r4.changedInstance(r0)
            if (r33 == 0) goto L_0x018c
            r25 = 32
            goto L_0x018e
        L_0x018c:
            r25 = 16
        L_0x018e:
            r18 = r18 | r25
            goto L_0x0195
        L_0x0191:
            r32 = r0
            r0 = r47
        L_0x0195:
            r0 = r18
            r5 = r3 & 4096(0x1000, float:5.74E-42)
            if (r5 == 0) goto L_0x019e
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x01b8
        L_0x019e:
            r18 = r0
            r0 = r2 & 384(0x180, float:5.38E-43)
            if (r0 != 0) goto L_0x01b4
            r0 = r48
            boolean r24 = r4.changedInstance(r0)
            if (r24 == 0) goto L_0x01af
            r27 = 256(0x100, float:3.59E-43)
            goto L_0x01b1
        L_0x01af:
            r27 = 128(0x80, float:1.794E-43)
        L_0x01b1:
            r18 = r18 | r27
            goto L_0x01b6
        L_0x01b4:
            r0 = r48
        L_0x01b6:
            r0 = r18
        L_0x01b8:
            r18 = r5
            r5 = r3 & 8192(0x2000, float:1.14794E-41)
            if (r5 == 0) goto L_0x01c5
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            r16 = r0
            r0 = r49
            goto L_0x01dd
        L_0x01c5:
            r24 = r0
            r0 = r2 & 3072(0xc00, float:4.305E-42)
            if (r0 != 0) goto L_0x01d9
            r0 = r49
            boolean r25 = r4.changedInstance(r0)
            if (r25 == 0) goto L_0x01d4
            goto L_0x01d6
        L_0x01d4:
            r16 = r17
        L_0x01d6:
            r16 = r24 | r16
            goto L_0x01dd
        L_0x01d9:
            r0 = r49
            r16 = r24
        L_0x01dd:
            r0 = r2 & 24576(0x6000, float:3.4438E-41)
            if (r0 != 0) goto L_0x01f5
            r0 = r3 & 16384(0x4000, float:2.2959E-41)
            if (r0 != 0) goto L_0x01f0
            r0 = r50
            boolean r17 = r4.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x01f2
            r19 = r20
            goto L_0x01f2
        L_0x01f0:
            r0 = r50
        L_0x01f2:
            r16 = r16 | r19
            goto L_0x01f7
        L_0x01f5:
            r0 = r50
        L_0x01f7:
            r17 = r2 & r21
            if (r17 != 0) goto L_0x0212
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r3 & r17
            r0 = r51
            if (r17 != 0) goto L_0x020d
            boolean r17 = r4.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x020d
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x020f
        L_0x020d:
            r17 = r22
        L_0x020f:
            r16 = r16 | r17
            goto L_0x0214
        L_0x0212:
            r0 = r51
        L_0x0214:
            r17 = 1572864(0x180000, float:2.204052E-39)
            r17 = r2 & r17
            if (r17 != 0) goto L_0x022e
            r17 = r3 & r22
            r0 = r52
            if (r17 != 0) goto L_0x0229
            boolean r17 = r4.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x0229
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x022b
        L_0x0229:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x022b:
            r16 = r16 | r17
            goto L_0x0230
        L_0x022e:
            r0 = r52
        L_0x0230:
            r17 = 131072(0x20000, float:1.83671E-40)
            r17 = r3 & r17
            if (r17 == 0) goto L_0x023b
            r16 = r16 | r26
            r0 = r53
            goto L_0x024e
        L_0x023b:
            r19 = r2 & r26
            r0 = r53
            if (r19 != 0) goto L_0x024e
            boolean r19 = r4.changedInstance(r0)
            if (r19 == 0) goto L_0x024a
            r19 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x024c
        L_0x024a:
            r19 = 4194304(0x400000, float:5.877472E-39)
        L_0x024c:
            r16 = r16 | r19
        L_0x024e:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r3 & r19
            if (r19 == 0) goto L_0x0257
            r16 = r16 | r29
            goto L_0x0268
        L_0x0257:
            r19 = r2 & r29
            if (r19 != 0) goto L_0x0268
            boolean r19 = r4.changed((java.lang.Object) r1)
            if (r19 == 0) goto L_0x0264
            r19 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0266
        L_0x0264:
            r19 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0266:
            r16 = r16 | r19
        L_0x0268:
            r19 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r8 & r19
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r2) goto L_0x02a0
            r0 = 38347923(0x2492493, float:1.4777644E-37)
            r0 = r16 & r0
            r2 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r2) goto L_0x02a0
            boolean r0 = r4.getSkipping()
            if (r0 != 0) goto L_0x0283
            goto L_0x02a0
        L_0x0283:
            r4.skipToGroupEnd()
            r11 = r45
            r12 = r46
            r14 = r48
            r15 = r49
            r16 = r50
            r17 = r51
            r18 = r52
            r19 = r53
            r23 = r4
            r8 = r10
            r9 = r13
            r10 = r44
            r13 = r47
            goto L_0x0478
        L_0x02a0:
            r4.startDefaults()
            r0 = r55 & 1
            r2 = 6
            if (r0 == 0) goto L_0x02ec
            boolean r0 = r4.getDefaultsInvalid()
            if (r0 == 0) goto L_0x02af
            goto L_0x02ec
        L_0x02af:
            r4.skipToGroupEnd()
            r0 = r3 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x02bb
            r0 = -57345(0xffffffffffff1fff, float:NaN)
            r16 = r16 & r0
        L_0x02bb:
            r0 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r3
            if (r0 == 0) goto L_0x02c6
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r16 = r16 & r0
        L_0x02c6:
            r0 = r3 & r22
            if (r0 == 0) goto L_0x02cf
            r0 = -3670017(0xffffffffffc7ffff, float:NaN)
            r16 = r16 & r0
        L_0x02cf:
            r11 = r45
            r12 = r46
            r14 = r48
            r15 = r49
            r0 = r50
            r21 = r51
            r20 = r52
            r22 = r53
            r54 = r2
            r18 = r10
            r9 = r13
            r1 = r16
            r10 = r44
            r13 = r47
            goto L_0x03e1
        L_0x02ec:
            if (r23 == 0) goto L_0x02f0
            r0 = 0
            r10 = r0
        L_0x02f0:
            r0 = 0
            if (r11 == 0) goto L_0x02f4
            r13 = r0
        L_0x02f4:
            if (r14 == 0) goto L_0x02f8
            r11 = r0
            goto L_0x02fa
        L_0x02f8:
            r11 = r44
        L_0x02fa:
            if (r30 == 0) goto L_0x02fe
            r14 = r0
            goto L_0x0300
        L_0x02fe:
            r14 = r45
        L_0x0300:
            if (r31 == 0) goto L_0x0305
            r19 = r0
            goto L_0x0307
        L_0x0305:
            r19 = r46
        L_0x0307:
            if (r32 == 0) goto L_0x030c
            r20 = r0
            goto L_0x030e
        L_0x030c:
            r20 = r47
        L_0x030e:
            if (r18 == 0) goto L_0x0313
            r18 = r0
            goto L_0x0315
        L_0x0313:
            r18 = r48
        L_0x0315:
            if (r5 == 0) goto L_0x0318
            goto L_0x031a
        L_0x0318:
            r0 = r49
        L_0x031a:
            r5 = r3 & 16384(0x4000, float:2.2959E-41)
            if (r5 == 0) goto L_0x032a
            androidx.compose.material3.TextFieldDefaults r5 = INSTANCE
            androidx.compose.ui.graphics.Shape r5 = r5.getShape(r4, r2)
            r21 = -57345(0xffffffffffff1fff, float:NaN)
            r16 = r16 & r21
            goto L_0x032c
        L_0x032a:
            r5 = r50
        L_0x032c:
            r21 = 32768(0x8000, float:4.5918E-41)
            r21 = r3 & r21
            if (r21 == 0) goto L_0x0343
            int r21 = r16 >> 24
            r54 = r2
            r2 = r21 & 14
            androidx.compose.material3.TextFieldColors r2 = r1.colors(r4, r2)
            r21 = -458753(0xfffffffffff8ffff, float:NaN)
            r16 = r16 & r21
            goto L_0x0347
        L_0x0343:
            r54 = r2
            r2 = r51
        L_0x0347:
            r21 = r3 & r22
            if (r21 == 0) goto L_0x0390
            if (r13 != 0) goto L_0x036c
            r21 = 15
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r42 = r1
            r47 = r21
            r48 = r22
            r43 = r23
            r44 = r24
            r45 = r25
            r46 = r26
            androidx.compose.foundation.layout.PaddingValues r1 = m2662contentPaddingWithoutLabela9UjIt4$default(r42, r43, r44, r45, r46, r47, r48)
            goto L_0x038a
        L_0x036c:
            r1 = 15
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r42 = r35
            r47 = r1
            r48 = r21
            r43 = r22
            r44 = r23
            r45 = r24
            r46 = r25
            androidx.compose.foundation.layout.PaddingValues r1 = m2661contentPaddingWithLabela9UjIt4$default(r42, r43, r44, r45, r46, r47, r48)
        L_0x038a:
            r21 = -3670017(0xffffffffffc7ffff, float:NaN)
            r16 = r16 & r21
            goto L_0x0392
        L_0x0390:
            r1 = r52
        L_0x0392:
            if (r17 == 0) goto L_0x03c5
            androidx.compose.material3.TextFieldDefaults$DecorationBox$1 r17 = new androidx.compose.material3.TextFieldDefaults$DecorationBox$1
            r46 = r2
            r47 = r5
            r45 = r7
            r44 = r10
            r43 = r12
            r42 = r17
            r42.<init>(r43, r44, r45, r46, r47)
            r2 = r42
            r7 = r46
            r12 = 54
            r42 = r0
            r0 = -435523791(0xffffffffe60a6f31, float:-1.6343442E23)
            r43 = r1
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r0, r1, r2, r4, r12)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r18
            r18 = r10
            r10 = r11
            r11 = r14
            r14 = r1
            r15 = r42
            r22 = r0
            goto L_0x03d5
        L_0x03c5:
            r42 = r0
            r43 = r1
            r7 = r2
            r0 = r18
            r18 = r10
            r10 = r11
            r11 = r14
            r14 = r0
            r15 = r42
            r22 = r53
        L_0x03d5:
            r0 = r5
            r21 = r7
            r9 = r13
            r1 = r16
            r12 = r19
            r13 = r20
            r20 = r43
        L_0x03e1:
            r4.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x03f2
            r2 = 289640444(0x11438ffc, float:1.5427156E-28)
            java.lang.String r5 = "androidx.compose.material3.TextFieldDefaults.DecorationBox (TextFieldDefaults.kt:276)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r8, r1, r5)
        L_0x03f2:
            androidx.compose.material3.internal.TextFieldType r5 = androidx.compose.material3.internal.TextFieldType.Filled
            int r2 = r8 << 3
            r7 = r2 & 112(0x70, float:1.57E-43)
            r7 = r7 | 6
            r2 = r2 & 896(0x380, float:1.256E-42)
            r2 = r2 | r7
            int r7 = r8 >> 3
            r42 = r0
            r0 = r7 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            int r2 = r8 >> 9
            r16 = 57344(0xe000, float:8.0356E-41)
            r16 = r2 & r16
            r0 = r0 | r16
            r16 = 458752(0x70000, float:6.42848E-40)
            r16 = r2 & r16
            r0 = r0 | r16
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r2 & r16
            r0 = r0 | r16
            int r16 = r1 << 21
            r17 = 29360128(0x1c00000, float:7.052966E-38)
            r17 = r16 & r17
            r0 = r0 | r17
            r17 = 234881024(0xe000000, float:1.5777218E-30)
            r17 = r16 & r17
            r0 = r0 | r17
            r17 = 1879048192(0x70000000, float:1.58456325E29)
            r16 = r16 & r17
            r24 = r0 | r16
            int r0 = r1 >> 9
            r0 = r0 & 14
            int r16 = r8 >> 6
            r16 = r16 & 112(0x70, float:1.57E-43)
            r0 = r0 | r16
            r8 = r8 & 896(0x380, float:1.256E-42)
            r0 = r0 | r8
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r7
            r0 = r0 | r2
            int r2 = r1 >> 3
            r7 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r7
            r0 = r0 | r2
            r2 = 3670016(0x380000, float:5.142788E-39)
            int r7 = r1 << 3
            r2 = r2 & r7
            r0 = r0 | r2
            r2 = 29360128(0x1c00000, float:7.052966E-38)
            r1 = r1 & r2
            r25 = r0 | r1
            r26 = 0
            r7 = r37
            r17 = r38
            r16 = r39
            r19 = r41
            r23 = r4
            r8 = r6
            r6 = r36
            androidx.compose.material3.internal.TextFieldImplKt.CommonDecorationBox(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x046e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x046e:
            r16 = r42
            r8 = r18
            r18 = r20
            r17 = r21
            r19 = r22
        L_0x0478:
            androidx.compose.runtime.ScopeUpdateScope r0 = r23.endRestartGroup()
            if (r0 == 0) goto L_0x04a1
            r1 = r0
            androidx.compose.material3.TextFieldDefaults$DecorationBox$2 r0 = new androidx.compose.material3.TextFieldDefaults$DecorationBox$2
            r2 = r36
            r4 = r38
            r5 = r39
            r6 = r40
            r7 = r41
            r20 = r55
            r21 = r56
            r34 = r1
            r22 = r3
            r1 = r35
            r3 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r34
            r1.updateScope(r0)
        L_0x04a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.DecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* renamed from: contentPaddingWithLabel-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m2661contentPaddingWithLabela9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        return textFieldDefaults.m2672contentPaddingWithLabela9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: contentPaddingWithLabel-a9UjIt4  reason: not valid java name */
    public final PaddingValues m2672contentPaddingWithLabela9UjIt4(float f, float f2, float f3, float f4) {
        return PaddingKt.m771PaddingValuesa9UjIt4(f, f3, f2, f4);
    }

    /* renamed from: contentPaddingWithoutLabel-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m2662contentPaddingWithoutLabela9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m2673contentPaddingWithoutLabela9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: contentPaddingWithoutLabel-a9UjIt4  reason: not valid java name */
    public final PaddingValues m2673contentPaddingWithoutLabela9UjIt4(float f, float f2, float f3, float f4) {
        return PaddingKt.m771PaddingValuesa9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: supportingTextPadding-a9UjIt4$material3_release$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m2667supportingTextPaddinga9UjIt4$material3_release$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getSupportingTopPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = Dp.m7111constructorimpl((float) 0);
        }
        return textFieldDefaults.m2682supportingTextPaddinga9UjIt4$material3_release(f, f2, f3, f4);
    }

    /* renamed from: supportingTextPadding-a9UjIt4$material3_release  reason: not valid java name */
    public final PaddingValues m2682supportingTextPaddinga9UjIt4$material3_release(float f, float f2, float f3, float f4) {
        return PaddingKt.m771PaddingValuesa9UjIt4(f, f2, f3, f4);
    }

    public final TextFieldColors colors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 831731228, "C(colors)336@16080L11,336@16092L22:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(831731228, i, -1, "androidx.compose.material3.TextFieldDefaults.colors (TextFieldDefaults.kt:336)");
        }
        TextFieldColors defaultTextFieldColors = getDefaultTextFieldColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i << 3) & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultTextFieldColors;
    }

    /* renamed from: colors-0hiis_0  reason: not valid java name */
    public final TextFieldColors m2671colors0hiis_0(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, TextSelectionColors textSelectionColors, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, Composer composer, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        Composer composer2 = composer;
        int i8 = i6;
        int i9 = i7;
        ComposerKt.sourceInformationMarkerStart(composer2, 1513344955, "C(colors)P(30:c#ui.graphics.Color,41:c#ui.graphics.Color,9:c#ui.graphics.Color,20:c#ui.graphics.Color,22:c#ui.graphics.Color,33:c#ui.graphics.Color,1:c#ui.graphics.Color,11:c#ui.graphics.Color,0:c#ui.graphics.Color,12:c#ui.graphics.Color,32,23:c#ui.graphics.Color,34:c#ui.graphics.Color,2:c#ui.graphics.Color,13:c#ui.graphics.Color,25:c#ui.graphics.Color,36:c#ui.graphics.Color,4:c#ui.graphics.Color,15:c#ui.graphics.Color,31:c#ui.graphics.Color,42:c#ui.graphics.Color,10:c#ui.graphics.Color,21:c#ui.graphics.Color,24:c#ui.graphics.Color,35:c#ui.graphics.Color,3:c#ui.graphics.Color,14:c#ui.graphics.Color,26:c#ui.graphics.Color,37:c#ui.graphics.Color,5:c#ui.graphics.Color,16:c#ui.graphics.Color,29:c#ui.graphics.Color,40:c#ui.graphics.Color,8:c#ui.graphics.Color,19:c#ui.graphics.Color,27:c#ui.graphics.Color,38:c#ui.graphics.Color,6:c#ui.graphics.Color,17:c#ui.graphics.Color,28:c#ui.graphics.Color,39:c#ui.graphics.Color,7:c#ui.graphics.Color,18:c#ui.graphics.Color)438@22922L11,438@22934L22:TextFieldDefaults.kt#uh7d8r");
        long r8 = (i8 & 1) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j;
        long r10 = (i8 & 2) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j2;
        long r12 = (i8 & 4) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j3;
        long r14 = (i8 & 8) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j4;
        long r16 = (i8 & 16) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j5;
        long r18 = (i8 & 32) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j6;
        long r20 = (i8 & 64) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j7;
        long r22 = (i8 & 128) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j8;
        long r24 = (i8 & 256) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j9;
        long r26 = (i8 & 512) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j10;
        TextSelectionColors textSelectionColors2 = (i8 & 1024) != 0 ? null : textSelectionColors;
        long r29 = (i8 & 2048) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j11;
        long r31 = (i8 & 4096) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j12;
        long r33 = (i8 & 8192) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j13;
        long r35 = (i8 & 16384) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j14;
        long r37 = (32768 & i8) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j15;
        long r39 = (65536 & i8) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j16;
        long r41 = (131072 & i8) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j17;
        long r43 = (262144 & i8) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j18;
        long r45 = (524288 & i8) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j19;
        long r47 = (1048576 & i8) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j20;
        long r49 = (2097152 & i8) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j21;
        long r51 = (4194304 & i8) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j22;
        long r53 = (8388608 & i8) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j23;
        long r55 = (16777216 & i8) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j24;
        long r57 = (33554432 & i8) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j25;
        long r59 = (67108864 & i8) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j26;
        long r61 = (134217728 & i8) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j27;
        long r63 = (268435456 & i8) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j28;
        long r65 = (536870912 & i8) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j29;
        long r67 = (i8 & 1073741824) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j30;
        long r69 = (i9 & 1) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j31;
        long r71 = (i9 & 2) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j32;
        long r73 = (i9 & 4) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j33;
        long r75 = (i9 & 8) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j34;
        long r77 = (i9 & 16) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j35;
        long r79 = (i9 & 32) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j36;
        long r81 = (i9 & 64) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j37;
        long r83 = (i9 & 128) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j38;
        long r85 = (i9 & 256) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j39;
        long r87 = (i9 & 512) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j40;
        long r89 = (i9 & 1024) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j41;
        long r91 = (i9 & 2048) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j42;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1513344955, i, i2, "androidx.compose.material3.TextFieldDefaults.colors (TextFieldDefaults.kt:438)");
        }
        TextFieldColors r1 = getDefaultTextFieldColors(MaterialTheme.INSTANCE.getColorScheme(composer2, 6), composer2, (i5 >> 6) & 112).m2608copyejIjP34(r8, r10, r12, r14, r16, r18, r20, r22, r24, r26, textSelectionColors2, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r61, r63, r65, r67, r69, r71, r73, r75, r77, r79, r81, r83, r85, r87, r89, r91);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return r1;
    }

    public final TextFieldColors getDefaultTextFieldColors(ColorScheme colorScheme, Composer composer, int i) {
        ColorScheme colorScheme2 = colorScheme;
        Composer composer2 = composer;
        ComposerKt.sourceInformationMarkerStart(composer2, 1341970309, "C:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1341970309, i, -1, "androidx.compose.material3.TextFieldDefaults.<get-defaultTextFieldColors> (TextFieldDefaults.kt:486)");
        }
        TextFieldColors defaultTextFieldColorsCached$material3_release = colorScheme2.getDefaultTextFieldColorsCached$material3_release();
        composer2.startReplaceGroup(27085453);
        ComposerKt.sourceInformation(composer2, "*501@26788L7");
        if (defaultTextFieldColorsCached$material3_release == null) {
            long fromToken = ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getFocusInputColor());
            long fromToken2 = ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getInputColor());
            long r9 = Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getDisabledInputColor()), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
            long fromToken3 = ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getErrorInputColor());
            long fromToken4 = ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getContainerColor());
            long fromToken5 = ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getContainerColor());
            long fromToken6 = ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getContainerColor());
            long fromToken7 = ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getContainerColor());
            long fromToken8 = ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getCaretColor());
            long fromToken9 = ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getErrorFocusCaretColor());
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer2);
            TextFieldColors textFieldColors = new TextFieldColors(fromToken, fromToken2, r9, fromToken3, fromToken4, fromToken5, fromToken6, fromToken7, fromToken8, fromToken9, (TextSelectionColors) consume, ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getFocusActiveIndicatorColor()), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getActiveIndicatorColor()), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getDisabledActiveIndicatorColor()), FilledTextFieldTokens.INSTANCE.getDisabledActiveIndicatorOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getErrorActiveIndicatorColor()), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getFocusLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getLeadingIconColor()), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor()), FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getErrorLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getFocusTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getTrailingIconColor()), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor()), FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getErrorTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getFocusLabelColor()), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getLabelColor()), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getDisabledLabelColor()), FilledTextFieldTokens.INSTANCE.getDisabledLabelOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getErrorLabelColor()), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor()), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor()), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getDisabledInputColor()), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor()), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getFocusSupportingColor()), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getSupportingColor()), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getDisabledSupportingColor()), FilledTextFieldTokens.INSTANCE.getDisabledSupportingOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getErrorSupportingColor()), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getInputPrefixColor()), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getInputPrefixColor()), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getInputPrefixColor()), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getInputPrefixColor()), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getInputSuffixColor()), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getInputSuffixColor()), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getInputSuffixColor()), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getInputSuffixColor()), (DefaultConstructorMarker) null);
            colorScheme2.setDefaultTextFieldColorsCached$material3_release(textFieldColors);
            defaultTextFieldColorsCached$material3_release = textFieldColors;
        }
        composer2.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return defaultTextFieldColorsCached$material3_release;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00e0, code lost:
        if ((r28 & 16) != 0) goto L_0x00ee;
     */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0131  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Renamed to TextFieldDefaults.Container", replaceWith = @kotlin.ReplaceWith(expression = "Container(\n    enabled = enabled,\n    isError = isError,\n    interactionSource = interactionSource,\n    colors = colors,\n    shape = shape,\n)", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ContainerBox(boolean r21, boolean r22, androidx.compose.foundation.interaction.InteractionSource r23, androidx.compose.material3.TextFieldColors r24, androidx.compose.ui.graphics.Shape r25, androidx.compose.runtime.Composer r26, int r27, int r28) {
        /*
            r20 = this;
            r7 = r27
            r0 = 918564008(0x36c02ca8, float:5.7272446E-6)
            r1 = r26
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(ContainerBox)P(1,3,2)590@32311L5,592@32334L368:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r28 & 1
            if (r2 == 0) goto L_0x0019
            r2 = r7 | 6
            r9 = r21
            goto L_0x002b
        L_0x0019:
            r2 = r7 & 6
            r9 = r21
            if (r2 != 0) goto L_0x002a
            boolean r2 = r1.changed((boolean) r9)
            if (r2 == 0) goto L_0x0027
            r2 = 4
            goto L_0x0028
        L_0x0027:
            r2 = 2
        L_0x0028:
            r2 = r2 | r7
            goto L_0x002b
        L_0x002a:
            r2 = r7
        L_0x002b:
            r3 = r28 & 2
            if (r3 == 0) goto L_0x0034
            r2 = r2 | 48
            r10 = r22
            goto L_0x0046
        L_0x0034:
            r3 = r7 & 48
            r10 = r22
            if (r3 != 0) goto L_0x0046
            boolean r3 = r1.changed((boolean) r10)
            if (r3 == 0) goto L_0x0043
            r3 = 32
            goto L_0x0045
        L_0x0043:
            r3 = 16
        L_0x0045:
            r2 = r2 | r3
        L_0x0046:
            r3 = r28 & 4
            if (r3 == 0) goto L_0x004f
            r2 = r2 | 384(0x180, float:5.38E-43)
            r11 = r23
            goto L_0x0061
        L_0x004f:
            r3 = r7 & 384(0x180, float:5.38E-43)
            r11 = r23
            if (r3 != 0) goto L_0x0061
            boolean r3 = r1.changed((java.lang.Object) r11)
            if (r3 == 0) goto L_0x005e
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r2 = r2 | r3
        L_0x0061:
            r3 = r28 & 8
            if (r3 == 0) goto L_0x006a
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r13 = r24
            goto L_0x007c
        L_0x006a:
            r3 = r7 & 3072(0xc00, float:4.305E-42)
            r13 = r24
            if (r3 != 0) goto L_0x007c
            boolean r3 = r1.changed((java.lang.Object) r13)
            if (r3 == 0) goto L_0x0079
            r3 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r3 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r2 = r2 | r3
        L_0x007c:
            r3 = r7 & 24576(0x6000, float:3.4438E-41)
            if (r3 != 0) goto L_0x0095
            r3 = r28 & 16
            if (r3 != 0) goto L_0x008f
            r3 = r25
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0091
            r4 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0093
        L_0x008f:
            r3 = r25
        L_0x0091:
            r4 = 8192(0x2000, float:1.14794E-41)
        L_0x0093:
            r2 = r2 | r4
            goto L_0x0097
        L_0x0095:
            r3 = r25
        L_0x0097:
            r4 = r28 & 32
            r5 = 196608(0x30000, float:2.75506E-40)
            if (r4 == 0) goto L_0x00a1
            r2 = r2 | r5
            r8 = r20
            goto L_0x00b3
        L_0x00a1:
            r4 = r7 & r5
            r8 = r20
            if (r4 != 0) goto L_0x00b3
            boolean r4 = r1.changed((java.lang.Object) r8)
            if (r4 == 0) goto L_0x00b0
            r4 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b2
        L_0x00b0:
            r4 = 65536(0x10000, float:9.18355E-41)
        L_0x00b2:
            r2 = r2 | r4
        L_0x00b3:
            r4 = 74899(0x12493, float:1.04956E-40)
            r4 = r4 & r2
            r5 = 74898(0x12492, float:1.04954E-40)
            if (r4 != r5) goto L_0x00ca
            boolean r4 = r1.getSkipping()
            if (r4 != 0) goto L_0x00c3
            goto L_0x00ca
        L_0x00c3:
            r1.skipToGroupEnd()
            r17 = r1
            r6 = r3
            goto L_0x0135
        L_0x00ca:
            r1.startDefaults()
            r4 = r7 & 1
            r5 = -57345(0xffffffffffff1fff, float:NaN)
            if (r4 == 0) goto L_0x00e3
            boolean r4 = r1.getDefaultsInvalid()
            if (r4 == 0) goto L_0x00db
            goto L_0x00e3
        L_0x00db:
            r1.skipToGroupEnd()
            r4 = r28 & 16
            if (r4 == 0) goto L_0x00ef
            goto L_0x00ee
        L_0x00e3:
            r4 = r28 & 16
            if (r4 == 0) goto L_0x00ef
            androidx.compose.material3.TextFieldDefaults r3 = INSTANCE
            r4 = 6
            androidx.compose.ui.graphics.Shape r3 = r3.getShape(r1, r4)
        L_0x00ee:
            r2 = r2 & r5
        L_0x00ef:
            r14 = r3
            r1.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x00ff
            r3 = -1
            java.lang.String r4 = "androidx.compose.material3.TextFieldDefaults.ContainerBox (TextFieldDefaults.kt:592)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r3, r4)
        L_0x00ff:
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            r12 = r0
            androidx.compose.ui.Modifier r12 = (androidx.compose.ui.Modifier) r12
            float r15 = FocusedIndicatorThickness
            float r16 = UnfocusedIndicatorThickness
            r0 = r2 & 14
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            r3 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r3
            r3 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r3
            int r3 = r2 << 3
            r4 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r3
            r0 = r0 | r4
            r4 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r4
            r0 = r0 | r3
            int r2 = r2 << 9
            r3 = 234881024(0xe000000, float:1.5777218E-30)
            r2 = r2 & r3
            r18 = r0 | r2
            r19 = 0
            r17 = r1
            r8.m2670Container4EFweAY(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0134
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0134:
            r6 = r14
        L_0x0135:
            androidx.compose.runtime.ScopeUpdateScope r9 = r17.endRestartGroup()
            if (r9 == 0) goto L_0x0151
            androidx.compose.material3.TextFieldDefaults$ContainerBox$1 r0 = new androidx.compose.material3.TextFieldDefaults$ContainerBox$1
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r23
            r5 = r24
            r8 = r28
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x0151:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.ContainerBox(boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.material3.TextFieldColors, androidx.compose.ui.graphics.Shape, androidx.compose.runtime.Composer, int, int):void");
    }

    public final Shape getOutlinedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -584749279, "C613@33100L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-584749279, i, -1, "androidx.compose.material3.TextFieldDefaults.<get-outlinedShape> (TextFieldDefaults.kt:613)");
        }
        Shape shape = OutlinedTextFieldDefaults.INSTANCE.getShape(composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return shape;
    }

    public final Shape getFilledShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 611926497, "C621@33346L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(611926497, i, -1, "androidx.compose.material3.TextFieldDefaults.<get-filledShape> (TextFieldDefaults.kt:621)");
        }
        Shape shape = getShape(composer, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return shape;
    }

    /* renamed from: getUnfocusedBorderThickness-D9Ej5fM  reason: not valid java name */
    public final float m2678getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    /* renamed from: getFocusedBorderThickness-D9Ej5fM  reason: not valid java name */
    public final float m2674getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* renamed from: textFieldWithLabelPadding-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m2668textFieldWithLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        return textFieldDefaults.m2683textFieldWithLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.contentPaddingWithLabel`", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.contentPaddingWithLabel(\n        start = start,\n        top = top,\n        end = end,\n        bottom = bottom,\n    )", imports = {}))
    /* renamed from: textFieldWithLabelPadding-a9UjIt4  reason: not valid java name */
    public final PaddingValues m2683textFieldWithLabelPaddinga9UjIt4(float f, float f2, float f3, float f4) {
        return m2672contentPaddingWithLabela9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: textFieldWithoutLabelPadding-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m2669textFieldWithoutLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m2684textFieldWithoutLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.contentPaddingWithoutLabel`", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.contentPaddingWithoutLabel(\n        start = start,\n        top = top,\n        end = end,\n        bottom = bottom,\n    )", imports = {}))
    /* renamed from: textFieldWithoutLabelPadding-a9UjIt4  reason: not valid java name */
    public final PaddingValues m2684textFieldWithoutLabelPaddinga9UjIt4(float f, float f2, float f3, float f4) {
        return m2673contentPaddingWithoutLabela9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: outlinedTextFieldPadding-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m2666outlinedTextFieldPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m2681outlinedTextFieldPaddinga9UjIt4(f, f2, f3, f4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `OutlinedTextFieldDefaults.contentPadding`", replaceWith = @ReplaceWith(expression = "OutlinedTextFieldDefaults.contentPadding(\n        start = start,\n        top = top,\n        end = end,\n        bottom = bottom,\n    )", imports = {"androidx.compose.material.OutlinedTextFieldDefaults"}))
    /* renamed from: outlinedTextFieldPadding-a9UjIt4  reason: not valid java name */
    public final PaddingValues m2681outlinedTextFieldPaddinga9UjIt4(float f, float f2, float f3, float f4) {
        return OutlinedTextFieldDefaults.INSTANCE.m2324contentPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: indicatorLine-gv0btCI  reason: not valid java name */
    public final Modifier m2680indicatorLinegv0btCI(Modifier modifier, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, float f, float f2) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new TextFieldDefaults$indicatorLinegv0btCI$$inlined$debugInspectorInfo$1(z, z2, interactionSource, textFieldColors, f, f2) : InspectableValueKt.getNoInspectorInfo(), new TextFieldDefaults$indicatorLine$2(interactionSource, z, z2, textFieldColors, f, f2));
    }

    static {
        float r0 = Dp.m7111constructorimpl((float) 1);
        UnfocusedIndicatorThickness = r0;
        float r1 = Dp.m7111constructorimpl((float) 2);
        FocusedIndicatorThickness = r1;
        UnfocusedBorderThickness = r0;
        FocusedBorderThickness = r1;
    }
}
