package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.tokens.OutlinedTextFieldTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b)\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\\\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u00132\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$JR\u0010%\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u00132\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\u0002\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*2\u0011\u0010+\u001a\r\u0012\u0004\u0012\u00020\u00180,¢\u0006\u0002\b-2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u0002002\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00103\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00104\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00105\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010,¢\u0006\u0002\b-2\b\b\u0002\u0010 \u001a\u00020\u00132\b\b\u0002\u00108\u001a\u0002092\u0013\b\u0002\u0010:\u001a\r\u0012\u0004\u0012\u00020\u00180,¢\u0006\u0002\b-H\u0007¢\u0006\u0002\u0010;J\r\u0010 \u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010<JÂ\u0003\u0010 \u001a\u00020\u00132\b\b\u0002\u0010=\u001a\u00020>2\b\b\u0002\u0010?\u001a\u00020>2\b\b\u0002\u0010@\u001a\u00020>2\b\b\u0002\u0010A\u001a\u00020>2\b\b\u0002\u0010B\u001a\u00020>2\b\b\u0002\u0010C\u001a\u00020>2\b\b\u0002\u0010D\u001a\u00020>2\b\b\u0002\u0010E\u001a\u00020>2\b\b\u0002\u0010F\u001a\u00020>2\b\b\u0002\u0010G\u001a\u00020>2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010I2\b\b\u0002\u0010J\u001a\u00020>2\b\b\u0002\u0010K\u001a\u00020>2\b\b\u0002\u0010L\u001a\u00020>2\b\b\u0002\u0010M\u001a\u00020>2\b\b\u0002\u0010N\u001a\u00020>2\b\b\u0002\u0010O\u001a\u00020>2\b\b\u0002\u0010P\u001a\u00020>2\b\b\u0002\u0010Q\u001a\u00020>2\b\b\u0002\u0010R\u001a\u00020>2\b\b\u0002\u0010S\u001a\u00020>2\b\b\u0002\u0010T\u001a\u00020>2\b\b\u0002\u0010U\u001a\u00020>2\b\b\u0002\u0010V\u001a\u00020>2\b\b\u0002\u0010W\u001a\u00020>2\b\b\u0002\u0010X\u001a\u00020>2\b\b\u0002\u0010Y\u001a\u00020>2\b\b\u0002\u0010Z\u001a\u00020>2\b\b\u0002\u0010[\u001a\u00020>2\b\b\u0002\u0010\\\u001a\u00020>2\b\b\u0002\u0010]\u001a\u00020>2\b\b\u0002\u0010^\u001a\u00020>2\b\b\u0002\u0010_\u001a\u00020>2\b\b\u0002\u0010`\u001a\u00020>2\b\b\u0002\u0010a\u001a\u00020>2\b\b\u0002\u0010b\u001a\u00020>2\b\b\u0002\u0010c\u001a\u00020>2\b\b\u0002\u0010d\u001a\u00020>2\b\b\u0002\u0010e\u001a\u00020>2\b\b\u0002\u0010f\u001a\u00020>2\b\b\u0002\u0010g\u001a\u00020>2\b\b\u0002\u0010h\u001a\u00020>2\b\b\u0002\u0010i\u001a\u00020>H\u0007ø\u0001\u0000¢\u0006\u0004\bj\u0010kJ8\u00108\u001a\u0002092\b\b\u0002\u0010l\u001a\u00020\u00042\b\b\u0002\u0010m\u001a\u00020\u00042\b\b\u0002\u0010n\u001a\u00020\u00042\b\b\u0002\u0010o\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\bp\u0010qR\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0011\u0010\u000e\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u00020\u0013*\u00020\u00148AX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006r"}, d2 = {"Landroidx/compose/material3/OutlinedTextFieldDefaults;", "", "()V", "FocusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "getFocusedBorderThickness-D9Ej5fM", "()F", "F", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "defaultOutlinedTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultOutlinedTextFieldColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "Container", "", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "modifier", "Landroidx/compose/ui/Modifier;", "colors", "focusedBorderThickness", "unfocusedBorderThickness", "Container-4EFweAY", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "ContainerBox", "ContainerBox-nbWgWpA", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "DecorationBox", "value", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "container", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "colors-0hiis_0", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIIII)Landroidx/compose/material3/TextFieldColors;", "start", "top", "end", "bottom", "contentPadding-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDefaults.kt */
public final class OutlinedTextFieldDefaults {
    public static final int $stable = 0;
    private static final float FocusedBorderThickness = Dp.m7111constructorimpl((float) 2);
    public static final OutlinedTextFieldDefaults INSTANCE = new OutlinedTextFieldDefaults();
    private static final float MinHeight = Dp.m7111constructorimpl((float) 56);
    private static final float MinWidth = Dp.m7111constructorimpl((float) 280);
    private static final float UnfocusedBorderThickness = Dp.m7111constructorimpl((float) 1);

    private OutlinedTextFieldDefaults() {
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1066756961, "C729@37132L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1066756961, i, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.<get-shape> (TextFieldDefaults.kt:729)");
        }
        Shape value = ShapesKt.getValue(OutlinedTextFieldTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    /* renamed from: getMinHeight-D9Ej5fM  reason: not valid java name */
    public final float m2326getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM  reason: not valid java name */
    public final float m2327getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    /* renamed from: getUnfocusedBorderThickness-D9Ej5fM  reason: not valid java name */
    public final float m2328getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    /* renamed from: getFocusedBorderThickness-D9Ej5fM  reason: not valid java name */
    public final float m2325getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:149:? A[RETURN, SYNTHETIC] */
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
    public final void m2321Container4EFweAY(boolean r21, boolean r22, androidx.compose.foundation.interaction.InteractionSource r23, androidx.compose.ui.Modifier r24, androidx.compose.material3.TextFieldColors r25, androidx.compose.ui.graphics.Shape r26, float r27, float r28, androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            r20 = this;
            r1 = r20
            r2 = r21
            r3 = r22
            r0 = r23
            r10 = r30
            r11 = r31
            r4 = 1035477640(0x3db82288, float:0.08990961)
            r5 = r29
            androidx.compose.runtime.Composer r8 = r5.startRestartGroup(r4)
            java.lang.String r5 = "C(Container)P(1,4,3,5!1,6,2:c#ui.unit.Dp,7:c#ui.unit.Dp)772@39024L8,773@39083L5,777@39264L25,779@39335L222,788@39599L198,792@39806L153:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r5)
            r5 = r11 & 1
            if (r5 == 0) goto L_0x0021
            r5 = r10 | 6
            goto L_0x0031
        L_0x0021:
            r5 = r10 & 6
            if (r5 != 0) goto L_0x0030
            boolean r5 = r8.changed((boolean) r2)
            if (r5 == 0) goto L_0x002d
            r5 = 4
            goto L_0x002e
        L_0x002d:
            r5 = 2
        L_0x002e:
            r5 = r5 | r10
            goto L_0x0031
        L_0x0030:
            r5 = r10
        L_0x0031:
            r6 = r11 & 2
            if (r6 == 0) goto L_0x0038
            r5 = r5 | 48
            goto L_0x0048
        L_0x0038:
            r6 = r10 & 48
            if (r6 != 0) goto L_0x0048
            boolean r6 = r8.changed((boolean) r3)
            if (r6 == 0) goto L_0x0045
            r6 = 32
            goto L_0x0047
        L_0x0045:
            r6 = 16
        L_0x0047:
            r5 = r5 | r6
        L_0x0048:
            r6 = r11 & 4
            if (r6 == 0) goto L_0x004f
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004f:
            r6 = r10 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x005f
            boolean r6 = r8.changed((java.lang.Object) r0)
            if (r6 == 0) goto L_0x005c
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005c:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r5 = r5 | r6
        L_0x005f:
            r6 = r11 & 8
            if (r6 == 0) goto L_0x0066
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            goto L_0x0079
        L_0x0066:
            r7 = r10 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x0079
            r7 = r24
            boolean r9 = r8.changed((java.lang.Object) r7)
            if (r9 == 0) goto L_0x0075
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0077
        L_0x0075:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0077:
            r5 = r5 | r9
            goto L_0x007b
        L_0x0079:
            r7 = r24
        L_0x007b:
            r9 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x0094
            r9 = r11 & 16
            if (r9 != 0) goto L_0x008e
            r9 = r25
            boolean r12 = r8.changed((java.lang.Object) r9)
            if (r12 == 0) goto L_0x0090
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0092
        L_0x008e:
            r9 = r25
        L_0x0090:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0092:
            r5 = r5 | r12
            goto L_0x0096
        L_0x0094:
            r9 = r25
        L_0x0096:
            r12 = 196608(0x30000, float:2.75506E-40)
            r12 = r12 & r10
            if (r12 != 0) goto L_0x00b0
            r12 = r11 & 32
            if (r12 != 0) goto L_0x00aa
            r12 = r26
            boolean r13 = r8.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x00ac
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ae
        L_0x00aa:
            r12 = r26
        L_0x00ac:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00ae:
            r5 = r5 | r13
            goto L_0x00b2
        L_0x00b0:
            r12 = r26
        L_0x00b2:
            r13 = 1572864(0x180000, float:2.204052E-39)
            r13 = r13 & r10
            if (r13 != 0) goto L_0x00cc
            r13 = r11 & 64
            if (r13 != 0) goto L_0x00c6
            r13 = r27
            boolean r14 = r8.changed((float) r13)
            if (r14 == 0) goto L_0x00c8
            r14 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ca
        L_0x00c6:
            r13 = r27
        L_0x00c8:
            r14 = 524288(0x80000, float:7.34684E-40)
        L_0x00ca:
            r5 = r5 | r14
            goto L_0x00ce
        L_0x00cc:
            r13 = r27
        L_0x00ce:
            r14 = 12582912(0xc00000, float:1.7632415E-38)
            r14 = r14 & r10
            if (r14 != 0) goto L_0x00e8
            r14 = r11 & 128(0x80, float:1.794E-43)
            if (r14 != 0) goto L_0x00e2
            r14 = r28
            boolean r15 = r8.changed((float) r14)
            if (r15 == 0) goto L_0x00e4
            r15 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00e6
        L_0x00e2:
            r14 = r28
        L_0x00e4:
            r15 = 4194304(0x400000, float:5.877472E-39)
        L_0x00e6:
            r5 = r5 | r15
            goto L_0x00ea
        L_0x00e8:
            r14 = r28
        L_0x00ea:
            r15 = r11 & 256(0x100, float:3.59E-43)
            r16 = 100663296(0x6000000, float:2.4074124E-35)
            if (r15 == 0) goto L_0x00f3
            r5 = r5 | r16
            goto L_0x0103
        L_0x00f3:
            r15 = r10 & r16
            if (r15 != 0) goto L_0x0103
            boolean r15 = r8.changed((java.lang.Object) r1)
            if (r15 == 0) goto L_0x0100
            r15 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0102
        L_0x0100:
            r15 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0102:
            r5 = r5 | r15
        L_0x0103:
            r15 = 38347923(0x2492493, float:1.4777644E-37)
            r15 = r15 & r5
            r4 = 38347922(0x2492492, float:1.4777643E-37)
            if (r15 != r4) goto L_0x011f
            boolean r4 = r8.getSkipping()
            if (r4 != 0) goto L_0x0113
            goto L_0x011f
        L_0x0113:
            r8.skipToGroupEnd()
            r5 = r13
            r13 = r8
            r8 = r5
            r5 = r7
            r6 = r9
            r7 = r12
            r9 = r14
            goto L_0x022d
        L_0x011f:
            r8.startDefaults()
            r4 = r10 & 1
            r17 = -3670017(0xffffffffffc7ffff, float:NaN)
            r18 = -458753(0xfffffffffff8ffff, float:NaN)
            r19 = -57345(0xffffffffffff1fff, float:NaN)
            r29 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r15 = 6
            if (r4 == 0) goto L_0x015b
            boolean r4 = r8.getDefaultsInvalid()
            if (r4 == 0) goto L_0x013a
            goto L_0x015b
        L_0x013a:
            r8.skipToGroupEnd()
            r4 = r11 & 16
            if (r4 == 0) goto L_0x0143
            r5 = r5 & r19
        L_0x0143:
            r4 = r11 & 32
            if (r4 == 0) goto L_0x0149
            r5 = r5 & r18
        L_0x0149:
            r4 = r11 & 64
            if (r4 == 0) goto L_0x014f
            r5 = r5 & r17
        L_0x014f:
            r4 = r11 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x0155
            r5 = r5 & r29
        L_0x0155:
            r4 = r5
            r5 = r9
            r6 = r13
            r13 = r12
            r12 = r7
            goto L_0x019f
        L_0x015b:
            if (r6 == 0) goto L_0x0162
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x0163
        L_0x0162:
            r4 = r7
        L_0x0163:
            r6 = r11 & 16
            if (r6 == 0) goto L_0x0172
            int r6 = r5 >> 24
            r6 = r6 & 14
            androidx.compose.material3.TextFieldColors r6 = r1.colors(r8, r6)
            r5 = r5 & r19
            goto L_0x0173
        L_0x0172:
            r6 = r9
        L_0x0173:
            r7 = r11 & 32
            if (r7 == 0) goto L_0x0180
            androidx.compose.material3.OutlinedTextFieldDefaults r7 = INSTANCE
            androidx.compose.ui.graphics.Shape r7 = r7.getShape(r8, r15)
            r5 = r5 & r18
            goto L_0x0181
        L_0x0180:
            r7 = r12
        L_0x0181:
            r9 = r11 & 64
            if (r9 == 0) goto L_0x018a
            float r9 = FocusedBorderThickness
            r5 = r5 & r17
            goto L_0x018b
        L_0x018a:
            r9 = r13
        L_0x018b:
            r12 = r11 & 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L_0x019a
            float r12 = UnfocusedBorderThickness
            r5 = r5 & r29
            r13 = r7
            r7 = r12
            r12 = r4
            r4 = r5
            r5 = r6
            r6 = r9
            goto L_0x01a0
        L_0x019a:
            r12 = r4
            r4 = r5
            r5 = r6
            r13 = r7
            r6 = r9
        L_0x019f:
            r7 = r14
        L_0x01a0:
            r8.endDefaults()
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x01b2
            r9 = -1
            java.lang.String r14 = "androidx.compose.material3.OutlinedTextFieldDefaults.Container (TextFieldDefaults.kt:776)"
            r15 = 1035477640(0x3db82288, float:0.08990961)
            androidx.compose.runtime.ComposerKt.traceEventStart(r15, r4, r9, r14)
        L_0x01b2:
            int r9 = r4 >> 6
            r14 = r9 & 14
            androidx.compose.runtime.State r14 = androidx.compose.foundation.interaction.FocusInteractionKt.collectIsFocusedAsState(r0, r8, r14)
            java.lang.Object r14 = r14.getValue()
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            r15 = r4 & 126(0x7e, float:1.77E-43)
            int r4 = r4 >> 3
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | r15
            r15 = 57344(0xe000, float:8.0356E-41)
            r15 = r15 & r9
            r4 = r4 | r15
            r15 = 458752(0x70000, float:6.42848E-40)
            r9 = r9 & r15
            r9 = r9 | r4
            r4 = r14
            androidx.compose.runtime.State r9 = androidx.compose.material3.internal.TextFieldImplKt.m2999animateBorderStrokeAsStateNuRrP5Q(r2, r3, r4, r5, r6, r7, r8, r9)
            long r14 = r5.m2607containerColorXeAY9LY$material3_release(r2, r3, r4)
            r4 = 150(0x96, float:2.1E-43)
            r24 = r14
            r15 = 0
            r14 = 0
            r0 = 6
            androidx.compose.animation.core.TweenSpec r0 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r4, r15, r14, r0, r14)
            r14 = r0
            androidx.compose.animation.core.AnimationSpec r14 = (androidx.compose.animation.core.AnimationSpec) r14
            r18 = 48
            r19 = 12
            r0 = r15
            r15 = 0
            r16 = 0
            r17 = r8
            r4 = r12
            r8 = r0
            r0 = r13
            r12 = r24
            androidx.compose.runtime.State r12 = androidx.compose.animation.SingleValueAnimationKt.m123animateColorAsStateeuL9pac(r12, r14, r15, r16, r17, r18, r19)
            r13 = r17
            java.lang.Object r9 = r9.getValue()
            androidx.compose.foundation.BorderStroke r9 = (androidx.compose.foundation.BorderStroke) r9
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.BorderKt.border(r4, r9, r0)
            androidx.compose.material3.OutlinedTextFieldDefaults$Container$1 r14 = new androidx.compose.material3.OutlinedTextFieldDefaults$Container$1
            r14.<init>(r12)
            androidx.compose.material3.TextFieldDefaults$sam$androidx_compose_ui_graphics_ColorProducer$0 r12 = new androidx.compose.material3.TextFieldDefaults$sam$androidx_compose_ui_graphics_ColorProducer$0
            kotlin.jvm.functions.Function0 r14 = (kotlin.jvm.functions.Function0) r14
            r12.<init>(r14)
            androidx.compose.ui.graphics.ColorProducer r12 = (androidx.compose.ui.graphics.ColorProducer) r12
            androidx.compose.ui.Modifier r9 = androidx.compose.material3.internal.TextFieldImplKt.textFieldBackground(r9, r12, r0)
            androidx.compose.foundation.layout.BoxKt.Box(r9, r13, r8)
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x0228
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0228:
            r8 = r6
            r9 = r7
            r7 = r0
            r6 = r5
            r5 = r4
        L_0x022d:
            androidx.compose.runtime.ScopeUpdateScope r12 = r13.endRestartGroup()
            if (r12 == 0) goto L_0x023f
            androidx.compose.material3.OutlinedTextFieldDefaults$Container$2 r0 = new androidx.compose.material3.OutlinedTextFieldDefaults$Container$2
            r4 = r23
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x023f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldDefaults.m2321Container4EFweAY(boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.ui.Modifier, androidx.compose.material3.TextFieldColors, androidx.compose.ui.graphics.Shape, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0262  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x0404  */
    /* JADX WARNING: Removed duplicated region for block: B:252:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0130  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void DecorationBox(java.lang.String r37, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, boolean r39, boolean r40, androidx.compose.ui.text.input.VisualTransformation r41, androidx.compose.foundation.interaction.InteractionSource r42, boolean r43, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r48, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, androidx.compose.material3.TextFieldColors r51, androidx.compose.foundation.layout.PaddingValues r52, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r53, androidx.compose.runtime.Composer r54, int r55, int r56, int r57) {
        /*
            r36 = this;
            r1 = r36
            r12 = r39
            r14 = r42
            r0 = r55
            r2 = r56
            r3 = r57
            r4 = -350442135(0xffffffffeb1cad69, float:-1.8941133E26)
            r5 = r54
            androidx.compose.runtime.Composer r4 = r5.startRestartGroup(r4)
            java.lang.String r5 = "C(DecorationBox)P(15,4,3,11,16,5,6,7,9,8,14,10,12,13!1,2)870@44562L8,872@44674L408,885@45099L709:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r5)
            r5 = r3 & 1
            if (r5 == 0) goto L_0x0024
            r5 = r0 | 6
            r8 = r5
            r5 = r37
            goto L_0x0038
        L_0x0024:
            r5 = r0 & 6
            if (r5 != 0) goto L_0x0035
            r5 = r37
            boolean r8 = r4.changed((java.lang.Object) r5)
            if (r8 == 0) goto L_0x0032
            r8 = 4
            goto L_0x0033
        L_0x0032:
            r8 = 2
        L_0x0033:
            r8 = r8 | r0
            goto L_0x0038
        L_0x0035:
            r5 = r37
            r8 = r0
        L_0x0038:
            r9 = r3 & 2
            if (r9 == 0) goto L_0x003f
            r8 = r8 | 48
            goto L_0x0052
        L_0x003f:
            r9 = r0 & 48
            if (r9 != 0) goto L_0x0052
            r9 = r38
            boolean r13 = r4.changedInstance(r9)
            if (r13 == 0) goto L_0x004e
            r13 = 32
            goto L_0x0050
        L_0x004e:
            r13 = 16
        L_0x0050:
            r8 = r8 | r13
            goto L_0x0054
        L_0x0052:
            r9 = r38
        L_0x0054:
            r13 = r3 & 4
            r16 = 128(0x80, float:1.794E-43)
            if (r13 == 0) goto L_0x005d
            r8 = r8 | 384(0x180, float:5.38E-43)
            goto L_0x006d
        L_0x005d:
            r13 = r0 & 384(0x180, float:5.38E-43)
            if (r13 != 0) goto L_0x006d
            boolean r13 = r4.changed((boolean) r12)
            if (r13 == 0) goto L_0x006a
            r13 = 256(0x100, float:3.59E-43)
            goto L_0x006c
        L_0x006a:
            r13 = r16
        L_0x006c:
            r8 = r8 | r13
        L_0x006d:
            r13 = r3 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0078
            r8 = r8 | 3072(0xc00, float:4.305E-42)
            goto L_0x008c
        L_0x0078:
            r13 = r0 & 3072(0xc00, float:4.305E-42)
            if (r13 != 0) goto L_0x008c
            r13 = r40
            boolean r19 = r4.changed((boolean) r13)
            if (r19 == 0) goto L_0x0087
            r19 = r17
            goto L_0x0089
        L_0x0087:
            r19 = r18
        L_0x0089:
            r8 = r8 | r19
            goto L_0x008e
        L_0x008c:
            r13 = r40
        L_0x008e:
            r19 = r3 & 16
            r20 = 8192(0x2000, float:1.14794E-41)
            r21 = 16384(0x4000, float:2.2959E-41)
            if (r19 == 0) goto L_0x0099
            r8 = r8 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00ad
        L_0x0099:
            r6 = r0 & 24576(0x6000, float:3.4438E-41)
            if (r6 != 0) goto L_0x00ad
            r6 = r41
            boolean r19 = r4.changed((java.lang.Object) r6)
            if (r19 == 0) goto L_0x00a8
            r19 = r21
            goto L_0x00aa
        L_0x00a8:
            r19 = r20
        L_0x00aa:
            r8 = r8 | r19
            goto L_0x00af
        L_0x00ad:
            r6 = r41
        L_0x00af:
            r19 = r3 & 32
            r22 = 131072(0x20000, float:1.83671E-40)
            r23 = 65536(0x10000, float:9.18355E-41)
            r24 = 196608(0x30000, float:2.75506E-40)
            if (r19 == 0) goto L_0x00bc
            r8 = r8 | r24
            goto L_0x00cd
        L_0x00bc:
            r19 = r0 & r24
            if (r19 != 0) goto L_0x00cd
            boolean r19 = r4.changed((java.lang.Object) r14)
            if (r19 == 0) goto L_0x00c9
            r19 = r22
            goto L_0x00cb
        L_0x00c9:
            r19 = r23
        L_0x00cb:
            r8 = r8 | r19
        L_0x00cd:
            r19 = r3 & 64
            r25 = 1572864(0x180000, float:2.204052E-39)
            if (r19 == 0) goto L_0x00d8
            r8 = r8 | r25
            r7 = r43
            goto L_0x00eb
        L_0x00d8:
            r26 = r0 & r25
            r7 = r43
            if (r26 != 0) goto L_0x00eb
            boolean r27 = r4.changed((boolean) r7)
            if (r27 == 0) goto L_0x00e7
            r27 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e9
        L_0x00e7:
            r27 = 524288(0x80000, float:7.34684E-40)
        L_0x00e9:
            r8 = r8 | r27
        L_0x00eb:
            r10 = r3 & 128(0x80, float:1.794E-43)
            r28 = 12582912(0xc00000, float:1.7632415E-38)
            if (r10 == 0) goto L_0x00f6
            r8 = r8 | r28
            r11 = r44
            goto L_0x0109
        L_0x00f6:
            r29 = r0 & r28
            r11 = r44
            if (r29 != 0) goto L_0x0109
            boolean r30 = r4.changedInstance(r11)
            if (r30 == 0) goto L_0x0105
            r30 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0107
        L_0x0105:
            r30 = 4194304(0x400000, float:5.877472E-39)
        L_0x0107:
            r8 = r8 | r30
        L_0x0109:
            r15 = r3 & 256(0x100, float:3.59E-43)
            r31 = 100663296(0x6000000, float:2.4074124E-35)
            if (r15 == 0) goto L_0x0114
            r8 = r8 | r31
            r0 = r45
            goto L_0x0127
        L_0x0114:
            r31 = r0 & r31
            r0 = r45
            if (r31 != 0) goto L_0x0127
            boolean r31 = r4.changedInstance(r0)
            if (r31 == 0) goto L_0x0123
            r31 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0125
        L_0x0123:
            r31 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0125:
            r8 = r8 | r31
        L_0x0127:
            r0 = r3 & 512(0x200, float:7.175E-43)
            r31 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x0130
            r8 = r8 | r31
            goto L_0x0146
        L_0x0130:
            r31 = r55 & r31
            if (r31 != 0) goto L_0x0146
            r31 = r0
            r0 = r46
            boolean r32 = r4.changedInstance(r0)
            if (r32 == 0) goto L_0x0141
            r32 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0143
        L_0x0141:
            r32 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0143:
            r8 = r8 | r32
            goto L_0x014a
        L_0x0146:
            r31 = r0
            r0 = r46
        L_0x014a:
            r0 = r3 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0155
            r26 = r2 | 6
            r32 = r0
            r0 = r47
            goto L_0x0171
        L_0x0155:
            r32 = r2 & 6
            if (r32 != 0) goto L_0x016b
            r32 = r0
            r0 = r47
            boolean r33 = r4.changedInstance(r0)
            if (r33 == 0) goto L_0x0166
            r26 = 4
            goto L_0x0168
        L_0x0166:
            r26 = 2
        L_0x0168:
            r26 = r2 | r26
            goto L_0x0171
        L_0x016b:
            r32 = r0
            r0 = r47
            r26 = r2
        L_0x0171:
            r0 = r3 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x017a
            r26 = r26 | 48
            r33 = r0
            goto L_0x0194
        L_0x017a:
            r33 = r2 & 48
            if (r33 != 0) goto L_0x0190
            r33 = r0
            r0 = r48
            boolean r34 = r4.changedInstance(r0)
            if (r34 == 0) goto L_0x018b
            r27 = 32
            goto L_0x018d
        L_0x018b:
            r27 = 16
        L_0x018d:
            r26 = r26 | r27
            goto L_0x0194
        L_0x0190:
            r33 = r0
            r0 = r48
        L_0x0194:
            r0 = r26
            r5 = r3 & 4096(0x1000, float:5.74E-42)
            if (r5 == 0) goto L_0x019d
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x01b9
        L_0x019d:
            r26 = r0
            r0 = r2 & 384(0x180, float:5.38E-43)
            if (r0 != 0) goto L_0x01b5
            r0 = r49
            boolean r27 = r4.changedInstance(r0)
            if (r27 == 0) goto L_0x01ae
            r30 = 256(0x100, float:3.59E-43)
            goto L_0x01b0
        L_0x01ae:
            r30 = r16
        L_0x01b0:
            r16 = r26 | r30
            r0 = r16
            goto L_0x01b9
        L_0x01b5:
            r0 = r49
            r0 = r26
        L_0x01b9:
            r16 = r5
            r5 = r3 & 8192(0x2000, float:1.14794E-41)
            if (r5 == 0) goto L_0x01c4
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            r26 = r0
            goto L_0x01da
        L_0x01c4:
            r26 = r0
            r0 = r2 & 3072(0xc00, float:4.305E-42)
            if (r0 != 0) goto L_0x01da
            r0 = r50
            boolean r27 = r4.changedInstance(r0)
            if (r27 == 0) goto L_0x01d3
            goto L_0x01d5
        L_0x01d3:
            r17 = r18
        L_0x01d5:
            r17 = r26 | r17
            r26 = r17
            goto L_0x01dc
        L_0x01da:
            r0 = r50
        L_0x01dc:
            r0 = r2 & 24576(0x6000, float:3.4438E-41)
            if (r0 != 0) goto L_0x01f4
            r0 = r3 & 16384(0x4000, float:2.2959E-41)
            if (r0 != 0) goto L_0x01ef
            r0 = r51
            boolean r17 = r4.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x01f1
            r20 = r21
            goto L_0x01f1
        L_0x01ef:
            r0 = r51
        L_0x01f1:
            r26 = r26 | r20
            goto L_0x01f6
        L_0x01f4:
            r0 = r51
        L_0x01f6:
            r17 = r2 & r24
            if (r17 != 0) goto L_0x0211
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r3 & r17
            r0 = r52
            if (r17 != 0) goto L_0x020c
            boolean r17 = r4.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x020c
            r17 = r22
            goto L_0x020e
        L_0x020c:
            r17 = r23
        L_0x020e:
            r26 = r26 | r17
            goto L_0x0213
        L_0x0211:
            r0 = r52
        L_0x0213:
            r17 = r3 & r23
            if (r17 == 0) goto L_0x021c
            r26 = r26 | r25
            r0 = r53
            goto L_0x022f
        L_0x021c:
            r18 = r2 & r25
            r0 = r53
            if (r18 != 0) goto L_0x022f
            boolean r18 = r4.changedInstance(r0)
            if (r18 == 0) goto L_0x022b
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x022d
        L_0x022b:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x022d:
            r26 = r26 | r18
        L_0x022f:
            r18 = r3 & r22
            if (r18 == 0) goto L_0x0236
            r26 = r26 | r28
            goto L_0x0247
        L_0x0236:
            r18 = r2 & r28
            if (r18 != 0) goto L_0x0247
            boolean r18 = r4.changed((java.lang.Object) r1)
            if (r18 == 0) goto L_0x0243
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0245
        L_0x0243:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x0245:
            r26 = r26 | r18
        L_0x0247:
            r18 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r8 & r18
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r2) goto L_0x027c
            r0 = 4793491(0x492493, float:6.717112E-39)
            r0 = r26 & r0
            r2 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r2) goto L_0x027c
            boolean r0 = r4.getSkipping()
            if (r0 != 0) goto L_0x0262
            goto L_0x027c
        L_0x0262:
            r4.skipToGroupEnd()
            r10 = r45
            r12 = r47
            r13 = r48
            r14 = r49
            r15 = r50
            r16 = r51
            r17 = r52
            r18 = r53
            r2 = r4
            r8 = r7
            r9 = r11
            r11 = r46
            goto L_0x03fe
        L_0x027c:
            r4.startDefaults()
            r0 = r55 & 1
            if (r0 == 0) goto L_0x02bb
            boolean r0 = r4.getDefaultsInvalid()
            if (r0 == 0) goto L_0x028a
            goto L_0x02bb
        L_0x028a:
            r4.skipToGroupEnd()
            r0 = r3 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x0296
            r0 = -57345(0xffffffffffff1fff, float:NaN)
            r26 = r26 & r0
        L_0x0296:
            r0 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r3
            if (r0 == 0) goto L_0x02a1
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r26 = r26 & r0
        L_0x02a1:
            r5 = r45
            r6 = r46
            r18 = r48
            r9 = r49
            r10 = r50
            r16 = r51
            r15 = r52
            r0 = r53
            r2 = r4
            r17 = r7
            r4 = r11
            r1 = r26
            r7 = r47
            goto L_0x035d
        L_0x02bb:
            if (r19 == 0) goto L_0x02bf
            r0 = 0
            goto L_0x02c0
        L_0x02bf:
            r0 = r7
        L_0x02c0:
            r2 = 0
            if (r10 == 0) goto L_0x02c4
            r11 = r2
        L_0x02c4:
            if (r15 == 0) goto L_0x02c8
            r7 = r2
            goto L_0x02ca
        L_0x02c8:
            r7 = r45
        L_0x02ca:
            if (r31 == 0) goto L_0x02ce
            r10 = r2
            goto L_0x02d0
        L_0x02ce:
            r10 = r46
        L_0x02d0:
            if (r32 == 0) goto L_0x02d4
            r15 = r2
            goto L_0x02d6
        L_0x02d4:
            r15 = r47
        L_0x02d6:
            if (r33 == 0) goto L_0x02db
            r18 = r2
            goto L_0x02dd
        L_0x02db:
            r18 = r48
        L_0x02dd:
            if (r16 == 0) goto L_0x02e2
            r16 = r2
            goto L_0x02e4
        L_0x02e2:
            r16 = r49
        L_0x02e4:
            if (r5 == 0) goto L_0x02e7
            goto L_0x02e9
        L_0x02e7:
            r2 = r50
        L_0x02e9:
            r5 = r3 & 16384(0x4000, float:2.2959E-41)
            if (r5 == 0) goto L_0x02fb
            int r5 = r26 >> 21
            r5 = r5 & 14
            androidx.compose.material3.TextFieldColors r5 = r1.colors(r4, r5)
            r19 = -57345(0xffffffffffff1fff, float:NaN)
            r26 = r26 & r19
            goto L_0x02fd
        L_0x02fb:
            r5 = r51
        L_0x02fd:
            r19 = 32768(0x8000, float:4.5918E-41)
            r19 = r3 & r19
            if (r19 == 0) goto L_0x032a
            r19 = 15
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r43 = r1
            r48 = r19
            r49 = r20
            r44 = r21
            r45 = r22
            r46 = r23
            r47 = r24
            androidx.compose.foundation.layout.PaddingValues r1 = m2320contentPaddinga9UjIt4$default(r43, r44, r45, r46, r47, r48, r49)
            r19 = -458753(0xfffffffffff8ffff, float:NaN)
            r19 = r26 & r19
            r26 = r19
            goto L_0x032c
        L_0x032a:
            r1 = r52
        L_0x032c:
            if (r17 == 0) goto L_0x0346
            r43 = r1
            androidx.compose.material3.OutlinedTextFieldDefaults$DecorationBox$1 r1 = new androidx.compose.material3.OutlinedTextFieldDefaults$DecorationBox$1
            r1.<init>(r12, r0, r14, r5)
            r17 = r0
            r0 = 54
            r44 = r2
            r2 = -1448570018(0xffffffffa9a8935e, float:-7.486263E-14)
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r2, r3, r1, r4, r0)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            goto L_0x034e
        L_0x0346:
            r17 = r0
            r43 = r1
            r44 = r2
            r0 = r53
        L_0x034e:
            r2 = r4
            r6 = r10
            r4 = r11
            r9 = r16
            r1 = r26
            r10 = r44
            r16 = r5
            r5 = r7
            r7 = r15
            r15 = r43
        L_0x035d:
            r2.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x036e
            r3 = -350442135(0xffffffffeb1cad69, float:-1.8941133E26)
            java.lang.String r11 = "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:884)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r8, r1, r11)
        L_0x036e:
            r13 = r17
            r17 = r0
            androidx.compose.material3.internal.TextFieldType r0 = androidx.compose.material3.internal.TextFieldType.Outlined
            int r3 = r8 << 3
            r11 = r3 & 112(0x70, float:1.57E-43)
            r11 = r11 | 6
            r3 = r3 & 896(0x380, float:1.256E-42)
            r3 = r3 | r11
            int r11 = r8 >> 3
            r43 = r0
            r0 = r11 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r3
            int r3 = r8 >> 9
            r19 = 57344(0xe000, float:8.0356E-41)
            r19 = r3 & r19
            r0 = r0 | r19
            r19 = 458752(0x70000, float:6.42848E-40)
            r19 = r3 & r19
            r0 = r0 | r19
            r19 = 3670016(0x380000, float:5.142788E-39)
            r19 = r3 & r19
            r0 = r0 | r19
            int r19 = r1 << 21
            r20 = 29360128(0x1c00000, float:7.052966E-38)
            r20 = r19 & r20
            r0 = r0 | r20
            r20 = 234881024(0xe000000, float:1.5777218E-30)
            r20 = r19 & r20
            r0 = r0 | r20
            r20 = 1879048192(0x70000000, float:1.58456325E29)
            r19 = r19 & r20
            r19 = r0 | r19
            int r0 = r1 >> 9
            r0 = r0 & 14
            int r20 = r8 >> 6
            r20 = r20 & 112(0x70, float:1.57E-43)
            r0 = r0 | r20
            r8 = r8 & 896(0x380, float:1.256E-42)
            r0 = r0 | r8
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r3
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r11
            r0 = r0 | r3
            r3 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r1
            r0 = r0 | r3
            int r3 = r1 << 6
            r8 = 3670016(0x380000, float:5.142788E-39)
            r3 = r3 & r8
            r0 = r0 | r3
            int r1 = r1 << 3
            r3 = 29360128(0x1c00000, float:7.052966E-38)
            r1 = r1 & r3
            r20 = r0 | r1
            r21 = 0
            r1 = r37
            r11 = r40
            r3 = r41
            r0 = r43
            r8 = r18
            r18 = r2
            r2 = r38
            androidx.compose.material3.internal.TextFieldImplKt.CommonDecorationBox(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r2 = r18
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x03f1
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03f1:
            r11 = r13
            r13 = r8
            r8 = r11
            r11 = r6
            r12 = r7
            r14 = r9
            r18 = r17
            r9 = r4
            r17 = r15
            r15 = r10
            r10 = r5
        L_0x03fe:
            androidx.compose.runtime.ScopeUpdateScope r0 = r2.endRestartGroup()
            if (r0 == 0) goto L_0x0427
            r1 = r0
            androidx.compose.material3.OutlinedTextFieldDefaults$DecorationBox$2 r0 = new androidx.compose.material3.OutlinedTextFieldDefaults$DecorationBox$2
            r2 = r37
            r3 = r38
            r4 = r39
            r5 = r40
            r6 = r41
            r7 = r42
            r19 = r55
            r20 = r56
            r21 = r57
            r35 = r1
            r1 = r36
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r35
            r1.updateScope(r0)
        L_0x0427:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* renamed from: contentPadding-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m2320contentPaddinga9UjIt4$default(OutlinedTextFieldDefaults outlinedTextFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
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
        return outlinedTextFieldDefaults.m2324contentPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: contentPadding-a9UjIt4  reason: not valid java name */
    public final PaddingValues m2324contentPaddinga9UjIt4(float f, float f2, float f3, float f4) {
        return PaddingKt.m771PaddingValuesa9UjIt4(f, f2, f3, f4);
    }

    public final TextFieldColors colors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -471651810, "C(colors)921@46417L11,921@46429L30:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-471651810, i, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.colors (TextFieldDefaults.kt:921)");
        }
        TextFieldColors defaultOutlinedTextFieldColors = getDefaultOutlinedTextFieldColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i << 3) & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultOutlinedTextFieldColors;
    }

    /* renamed from: colors-0hiis_0  reason: not valid java name */
    public final TextFieldColors m2323colors0hiis_0(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, TextSelectionColors textSelectionColors, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, Composer composer, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        Composer composer2 = composer;
        int i8 = i6;
        int i9 = i7;
        ComposerKt.sourceInformationMarkerStart(composer2, 1767617725, "C(colors)P(30:c#ui.graphics.Color,41:c#ui.graphics.Color,9:c#ui.graphics.Color,20:c#ui.graphics.Color,23:c#ui.graphics.Color,34:c#ui.graphics.Color,2:c#ui.graphics.Color,12:c#ui.graphics.Color,0:c#ui.graphics.Color,13:c#ui.graphics.Color,32,22:c#ui.graphics.Color,33:c#ui.graphics.Color,1:c#ui.graphics.Color,11:c#ui.graphics.Color,25:c#ui.graphics.Color,36:c#ui.graphics.Color,4:c#ui.graphics.Color,15:c#ui.graphics.Color,31:c#ui.graphics.Color,42:c#ui.graphics.Color,10:c#ui.graphics.Color,21:c#ui.graphics.Color,24:c#ui.graphics.Color,35:c#ui.graphics.Color,3:c#ui.graphics.Color,14:c#ui.graphics.Color,26:c#ui.graphics.Color,37:c#ui.graphics.Color,5:c#ui.graphics.Color,16:c#ui.graphics.Color,29:c#ui.graphics.Color,40:c#ui.graphics.Color,8:c#ui.graphics.Color,19:c#ui.graphics.Color,27:c#ui.graphics.Color,38:c#ui.graphics.Color,6:c#ui.graphics.Color,17:c#ui.graphics.Color,28:c#ui.graphics.Color,39:c#ui.graphics.Color,7:c#ui.graphics.Color,18:c#ui.graphics.Color)1023@53240L11,1023@53252L30:TextFieldDefaults.kt#uh7d8r");
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
            ComposerKt.traceEventStart(1767617725, i, i2, "androidx.compose.material3.OutlinedTextFieldDefaults.colors (TextFieldDefaults.kt:1023)");
        }
        TextFieldColors r1 = getDefaultOutlinedTextFieldColors(MaterialTheme.INSTANCE.getColorScheme(composer2, 6), composer2, (i5 >> 6) & 112).m2608copyejIjP34(r8, r10, r12, r14, r16, r18, r20, r22, r24, r26, textSelectionColors2, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r61, r63, r65, r67, r69, r71, r73, r75, r77, r79, r81, r83, r85, r87, r89, r91);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return r1;
    }

    public final TextFieldColors getDefaultOutlinedTextFieldColors(ColorScheme colorScheme, Composer composer, int i) {
        ColorScheme colorScheme2 = colorScheme;
        Composer composer2 = composer;
        ComposerKt.sourceInformationMarkerStart(composer2, -292363577, "C:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-292363577, i, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.<get-defaultOutlinedTextFieldColors> (TextFieldDefaults.kt:1071)");
        }
        TextFieldColors defaultOutlinedTextFieldColorsCached$material3_release = colorScheme2.getDefaultOutlinedTextFieldColorsCached$material3_release();
        composer2.startReplaceGroup(1540400102);
        ComposerKt.sourceInformation(composer2, "*1086@57012L7");
        if (defaultOutlinedTextFieldColorsCached$material3_release == null) {
            long fromToken = ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getFocusInputColor());
            long fromToken2 = ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getInputColor());
            long r9 = Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            long fromToken3 = ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getErrorInputColor());
            long r13 = Color.Companion.m4274getTransparent0d7_KjU();
            long r15 = Color.Companion.m4274getTransparent0d7_KjU();
            long r17 = Color.Companion.m4274getTransparent0d7_KjU();
            long r19 = Color.Companion.m4274getTransparent0d7_KjU();
            long fromToken4 = ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getCaretColor());
            long fromToken5 = ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getErrorFocusCaretColor());
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer2);
            TextFieldColors textFieldColors = new TextFieldColors(fromToken, fromToken2, r9, fromToken3, r13, r15, r17, r19, fromToken4, fromToken5, (TextSelectionColors) consume, ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getFocusOutlineColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getOutlineColor()), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getDisabledOutlineColor()), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getErrorOutlineColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getFocusLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getLeadingIconColor()), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getDisabledLeadingIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getErrorLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getFocusTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getTrailingIconColor()), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getDisabledTrailingIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getErrorTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getFocusLabelColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getLabelColor()), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getDisabledLabelColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getErrorLabelColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor()), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getFocusSupportingColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getSupportingColor()), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getDisabledSupportingColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getErrorSupportingColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), (DefaultConstructorMarker) null);
            colorScheme2.setDefaultOutlinedTextFieldColorsCached$material3_release(textFieldColors);
            defaultOutlinedTextFieldColorsCached$material3_release = textFieldColors;
        }
        composer2.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return defaultOutlinedTextFieldColorsCached$material3_release;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0136, code lost:
        if ((r13 & 64) != 0) goto L_0x0161;
     */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0109  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Renamed to OutlinedTextFieldDefaults.Container", replaceWith = @kotlin.ReplaceWith(expression = "Container(\n    enabled = enabled,\n    isError = isError,\n    interactionSource = interactionSource,\n    colors = colors,\n    shape = shape,\n    focusedBorderThickness = focusedBorderThickness,\n    unfocusedBorderThickness = unfocusedBorderThickness,\n)", imports = {}))
    /* renamed from: ContainerBox-nbWgWpA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m2322ContainerBoxnbWgWpA(boolean r19, boolean r20, androidx.compose.foundation.interaction.InteractionSource r21, androidx.compose.material3.TextFieldColors r22, androidx.compose.ui.graphics.Shape r23, float r24, float r25, androidx.compose.runtime.Composer r26, int r27, int r28) {
        /*
            r18 = this;
            r0 = r18
            r12 = r27
            r13 = r28
            r1 = 1461761386(0x5720b56a, float:1.76701028E14)
            r2 = r26
            androidx.compose.runtime.Composer r9 = r2.startRestartGroup(r1)
            java.lang.String r2 = "C(ContainerBox)P(1,4,3!1,5,2:c#ui.unit.Dp,6:c#ui.unit.Dp)1174@62656L8,1175@62715L5,1179@62864L348:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r2)
            r2 = r13 & 1
            if (r2 == 0) goto L_0x001e
            r2 = r12 | 6
            r3 = r2
            r2 = r19
            goto L_0x0032
        L_0x001e:
            r2 = r12 & 6
            if (r2 != 0) goto L_0x002f
            r2 = r19
            boolean r3 = r9.changed((boolean) r2)
            if (r3 == 0) goto L_0x002c
            r3 = 4
            goto L_0x002d
        L_0x002c:
            r3 = 2
        L_0x002d:
            r3 = r3 | r12
            goto L_0x0032
        L_0x002f:
            r2 = r19
            r3 = r12
        L_0x0032:
            r4 = r13 & 2
            if (r4 == 0) goto L_0x0039
            r3 = r3 | 48
            goto L_0x004c
        L_0x0039:
            r4 = r12 & 48
            if (r4 != 0) goto L_0x004c
            r4 = r20
            boolean r5 = r9.changed((boolean) r4)
            if (r5 == 0) goto L_0x0048
            r5 = 32
            goto L_0x004a
        L_0x0048:
            r5 = 16
        L_0x004a:
            r3 = r3 | r5
            goto L_0x004e
        L_0x004c:
            r4 = r20
        L_0x004e:
            r5 = r13 & 4
            if (r5 == 0) goto L_0x0055
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0055:
            r5 = r12 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x0068
            r5 = r21
            boolean r6 = r9.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0064
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r3 = r3 | r6
            goto L_0x006a
        L_0x0068:
            r5 = r21
        L_0x006a:
            r6 = r12 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x0083
            r6 = r13 & 8
            if (r6 != 0) goto L_0x007d
            r6 = r22
            boolean r7 = r9.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x007f
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0081
        L_0x007d:
            r6 = r22
        L_0x007f:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0081:
            r3 = r3 | r7
            goto L_0x0085
        L_0x0083:
            r6 = r22
        L_0x0085:
            r7 = r12 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x009e
            r7 = r13 & 16
            if (r7 != 0) goto L_0x0098
            r7 = r23
            boolean r8 = r9.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x009a
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009c
        L_0x0098:
            r7 = r23
        L_0x009a:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x009c:
            r3 = r3 | r8
            goto L_0x00a0
        L_0x009e:
            r7 = r23
        L_0x00a0:
            r8 = 196608(0x30000, float:2.75506E-40)
            r8 = r8 & r12
            if (r8 != 0) goto L_0x00ba
            r8 = r13 & 32
            if (r8 != 0) goto L_0x00b4
            r8 = r24
            boolean r10 = r9.changed((float) r8)
            if (r10 == 0) goto L_0x00b6
            r10 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00b4:
            r8 = r24
        L_0x00b6:
            r10 = 65536(0x10000, float:9.18355E-41)
        L_0x00b8:
            r3 = r3 | r10
            goto L_0x00bc
        L_0x00ba:
            r8 = r24
        L_0x00bc:
            r10 = 1572864(0x180000, float:2.204052E-39)
            r10 = r10 & r12
            if (r10 != 0) goto L_0x00d6
            r10 = r13 & 64
            if (r10 != 0) goto L_0x00d0
            r10 = r25
            boolean r11 = r9.changed((float) r10)
            if (r11 == 0) goto L_0x00d2
            r11 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d4
        L_0x00d0:
            r10 = r25
        L_0x00d2:
            r11 = 524288(0x80000, float:7.34684E-40)
        L_0x00d4:
            r3 = r3 | r11
            goto L_0x00d8
        L_0x00d6:
            r10 = r25
        L_0x00d8:
            r11 = r13 & 128(0x80, float:1.794E-43)
            r14 = 12582912(0xc00000, float:1.7632415E-38)
            if (r11 == 0) goto L_0x00e0
            r3 = r3 | r14
            goto L_0x00f0
        L_0x00e0:
            r11 = r12 & r14
            if (r11 != 0) goto L_0x00f0
            boolean r11 = r9.changed((java.lang.Object) r0)
            if (r11 == 0) goto L_0x00ed
            r11 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ef
        L_0x00ed:
            r11 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ef:
            r3 = r3 | r11
        L_0x00f0:
            r11 = 4793491(0x492493, float:6.717112E-39)
            r11 = r11 & r3
            r14 = 4793490(0x492492, float:6.71711E-39)
            if (r11 != r14) goto L_0x0109
            boolean r11 = r9.getSkipping()
            if (r11 != 0) goto L_0x0100
            goto L_0x0109
        L_0x0100:
            r9.skipToGroupEnd()
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r10
            goto L_0x01b2
        L_0x0109:
            r9.startDefaults()
            r11 = r12 & 1
            r14 = -3670017(0xffffffffffc7ffff, float:NaN)
            r15 = -458753(0xfffffffffff8ffff, float:NaN)
            r16 = -57345(0xffffffffffff1fff, float:NaN)
            if (r11 == 0) goto L_0x0139
            boolean r11 = r9.getDefaultsInvalid()
            if (r11 == 0) goto L_0x0120
            goto L_0x0139
        L_0x0120:
            r9.skipToGroupEnd()
            r11 = r13 & 8
            if (r11 == 0) goto L_0x0129
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0129:
            r11 = r13 & 16
            if (r11 == 0) goto L_0x012f
            r3 = r3 & r16
        L_0x012f:
            r11 = r13 & 32
            if (r11 == 0) goto L_0x0134
            r3 = r3 & r15
        L_0x0134:
            r11 = r13 & 64
            if (r11 == 0) goto L_0x0162
            goto L_0x0161
        L_0x0139:
            r11 = r13 & 8
            if (r11 == 0) goto L_0x0147
            int r6 = r3 >> 21
            r6 = r6 & 14
            androidx.compose.material3.TextFieldColors r6 = r0.colors(r9, r6)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0147:
            r11 = r13 & 16
            if (r11 == 0) goto L_0x0154
            androidx.compose.material3.OutlinedTextFieldDefaults r7 = INSTANCE
            r11 = 6
            androidx.compose.ui.graphics.Shape r7 = r7.getShape(r9, r11)
            r3 = r3 & r16
        L_0x0154:
            r11 = r13 & 32
            if (r11 == 0) goto L_0x015b
            float r8 = FocusedBorderThickness
            r3 = r3 & r15
        L_0x015b:
            r11 = r13 & 64
            if (r11 == 0) goto L_0x0162
            float r10 = UnfocusedBorderThickness
        L_0x0161:
            r3 = r3 & r14
        L_0x0162:
            r9.endDefaults()
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x0171
            r11 = -1
            java.lang.String r14 = "androidx.compose.material3.OutlinedTextFieldDefaults.ContainerBox (TextFieldDefaults.kt:1179)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r3, r11, r14)
        L_0x0171:
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r11 = r3 & 14
            r11 = r11 | 3072(0xc00, float:4.305E-42)
            r14 = r3 & 112(0x70, float:1.57E-43)
            r11 = r11 | r14
            r14 = r3 & 896(0x380, float:1.256E-42)
            r11 = r11 | r14
            int r3 = r3 << 3
            r14 = 57344(0xe000, float:8.0356E-41)
            r14 = r14 & r3
            r11 = r11 | r14
            r14 = 458752(0x70000, float:6.42848E-40)
            r14 = r14 & r3
            r11 = r11 | r14
            r14 = 3670016(0x380000, float:5.142788E-39)
            r14 = r14 & r3
            r11 = r11 | r14
            r14 = 29360128(0x1c00000, float:7.052966E-38)
            r14 = r14 & r3
            r11 = r11 | r14
            r14 = 234881024(0xe000000, float:1.5777218E-30)
            r3 = r3 & r14
            r3 = r3 | r11
            r11 = 0
            r17 = r4
            r4 = r1
            r1 = r2
            r2 = r17
            r17 = r10
            r10 = r3
            r3 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r17
            r0.m2321Container4EFweAY(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01b2
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01b2:
            androidx.compose.runtime.ScopeUpdateScope r11 = r9.endRestartGroup()
            if (r11 == 0) goto L_0x01cc
            androidx.compose.material3.OutlinedTextFieldDefaults$ContainerBox$1 r0 = new androidx.compose.material3.OutlinedTextFieldDefaults$ContainerBox$1
            r1 = r18
            r2 = r19
            r3 = r20
            r4 = r21
            r9 = r12
            r10 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r11.updateScope(r0)
        L_0x01cc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldDefaults.m2322ContainerBoxnbWgWpA(boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.material3.TextFieldColors, androidx.compose.ui.graphics.Shape, float, float, androidx.compose.runtime.Composer, int, int):void");
    }
}
