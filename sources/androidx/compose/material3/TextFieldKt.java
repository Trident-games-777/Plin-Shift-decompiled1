package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000¤\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u001aØ\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010,\u001aØ\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020-2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010.\u001aì\u0001\u0010/\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0011\u00100\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\u00142\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0019\u0010\u0015\u001a\u0015\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n¢\u0006\u0002\b\u00142\u0013\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0013\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0006\u0010\"\u001a\u00020\u000e2\u0006\u00103\u001a\u0002042\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\u00142\u0013\u00106\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0006\u00107\u001a\u000208H\u0001¢\u0006\u0002\u00109\u001ar\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020$2\u0006\u0010B\u001a\u00020$2\u0006\u00103\u001a\u0002042\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u0002042\u0006\u00107\u001a\u000208H\u0002ø\u0001\u0000¢\u0006\u0004\bF\u0010G\u001aR\u0010H\u001a\u00020$2\u0006\u0010I\u001a\u00020$2\u0006\u0010J\u001a\u00020$2\u0006\u0010K\u001a\u00020$2\u0006\u0010L\u001a\u00020$2\u0006\u0010M\u001a\u00020$2\u0006\u0010N\u001a\u00020$2\u0006\u0010O\u001a\u00020$2\u0006\u0010C\u001a\u00020DH\u0002ø\u0001\u0000¢\u0006\u0004\bP\u0010Q\u001a\u001a\u0010R\u001a\u00020\f*\u00020\f2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020U0TH\u0000\u001a\u0001\u0010V\u001a\u00020\u0006*\u00020W2\u0006\u0010X\u001a\u00020$2\u0006\u0010Y\u001a\u00020$2\u0006\u0010Z\u001a\u00020[2\b\u0010\\\u001a\u0004\u0018\u00010[2\b\u0010]\u001a\u0004\u0018\u00010[2\b\u0010^\u001a\u0004\u0018\u00010[2\b\u0010_\u001a\u0004\u0018\u00010[2\b\u0010`\u001a\u0004\u0018\u00010[2\b\u0010a\u001a\u0004\u0018\u00010[2\u0006\u0010b\u001a\u00020[2\b\u0010c\u001a\u0004\u0018\u00010[2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010d\u001a\u00020$2\u0006\u0010e\u001a\u00020$2\u0006\u00103\u001a\u0002042\u0006\u0010E\u001a\u000204H\u0002\u001a\u0001\u0010f\u001a\u00020\u0006*\u00020W2\u0006\u0010X\u001a\u00020$2\u0006\u0010Y\u001a\u00020$2\u0006\u0010g\u001a\u00020[2\b\u0010]\u001a\u0004\u0018\u00010[2\b\u0010^\u001a\u0004\u0018\u00010[2\b\u0010_\u001a\u0004\u0018\u00010[2\b\u0010`\u001a\u0004\u0018\u00010[2\b\u0010a\u001a\u0004\u0018\u00010[2\u0006\u0010b\u001a\u00020[2\b\u0010c\u001a\u0004\u0018\u00010[2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010E\u001a\u0002042\u0006\u00107\u001a\u000208H\u0002\u001a\u0014\u0010h\u001a\u00020$*\u00020$2\u0006\u0010i\u001a\u00020$H\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006j"}, d2 = {"TextFieldWithLabelVerticalPadding", "Landroidx/compose/ui/unit/Dp;", "getTextFieldWithLabelVerticalPadding", "()F", "F", "TextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "minLines", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "TextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "container", "supporting", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "textFieldHeight", "labelHeight", "leadingHeight", "trailingHeight", "prefixHeight", "suffixHeight", "placeholderHeight", "supportingHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-mKXJcVc", "(IIIIIIIIFJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingWidth", "trailingWidth", "prefixWidth", "suffixWidth", "textFieldWidth", "labelWidth", "placeholderWidth", "calculateWidth-yeHjK3Y", "(IIIIIIIJ)I", "drawIndicatorLine", "indicatorBorder", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/BorderStroke;", "placeWithLabel", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "width", "totalHeight", "textfieldPlaceable", "Landroidx/compose/ui/layout/Placeable;", "labelPlaceable", "placeholderPlaceable", "leadingPlaceable", "trailingPlaceable", "prefixPlaceable", "suffixPlaceable", "containerPlaceable", "supportingPlaceable", "labelEndPosition", "textPosition", "placeWithoutLabel", "textPlaceable", "substractConstraintSafely", "from", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextField.kt */
public final class TextFieldKt {
    private static final float TextFieldWithLabelVerticalPadding = Dp.m7111constructorimpl((float) 8);

    /* access modifiers changed from: private */
    public static final int substractConstraintSafely(int i, int i2) {
        return i == Integer.MAX_VALUE ? i : i - i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0245  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x029f  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x02b9  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x02cf  */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x02d5  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x02eb  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x0310  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x033a  */
    /* JADX WARNING: Removed duplicated region for block: B:332:0x04af  */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x04c4  */
    /* JADX WARNING: Removed duplicated region for block: B:339:0x04e7  */
    /* JADX WARNING: Removed duplicated region for block: B:342:0x0502  */
    /* JADX WARNING: Removed duplicated region for block: B:345:0x0585  */
    /* JADX WARNING: Removed duplicated region for block: B:349:0x05b1  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:351:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x012f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TextField(java.lang.String r65, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r66, androidx.compose.ui.Modifier r67, boolean r68, boolean r69, androidx.compose.ui.text.TextStyle r70, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r71, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r72, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r73, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r74, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r75, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r76, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r77, boolean r78, androidx.compose.ui.text.input.VisualTransformation r79, androidx.compose.foundation.text.KeyboardOptions r80, androidx.compose.foundation.text.KeyboardActions r81, boolean r82, int r83, int r84, androidx.compose.foundation.interaction.MutableInteractionSource r85, androidx.compose.ui.graphics.Shape r86, androidx.compose.material3.TextFieldColors r87, androidx.compose.runtime.Composer r88, int r89, int r90, int r91, int r92) {
        /*
            r0 = r89
            r1 = r90
            r2 = r91
            r3 = r92
            r4 = -676242365(0xffffffffd7b15c43, float:-3.90019638E14)
            r5 = r88
            androidx.compose.runtime.Composer r4 = r5.startRestartGroup(r4)
            java.lang.String r5 = "C(TextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)201@10573L7,217@11369L5,218@11424L8,230@12004L1956,230@11917L2043:TextField.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r5)
            r5 = r3 & 1
            if (r5 == 0) goto L_0x001f
            r5 = r0 | 6
            r12 = r65
            goto L_0x0031
        L_0x001f:
            r5 = r0 & 6
            r12 = r65
            if (r5 != 0) goto L_0x0030
            boolean r5 = r4.changed((java.lang.Object) r12)
            if (r5 == 0) goto L_0x002d
            r5 = 4
            goto L_0x002e
        L_0x002d:
            r5 = 2
        L_0x002e:
            r5 = r5 | r0
            goto L_0x0031
        L_0x0030:
            r5 = r0
        L_0x0031:
            r8 = r3 & 2
            if (r8 == 0) goto L_0x003a
            r5 = r5 | 48
            r13 = r66
            goto L_0x004c
        L_0x003a:
            r8 = r0 & 48
            r13 = r66
            if (r8 != 0) goto L_0x004c
            boolean r8 = r4.changedInstance(r13)
            if (r8 == 0) goto L_0x0049
            r8 = 32
            goto L_0x004b
        L_0x0049:
            r8 = 16
        L_0x004b:
            r5 = r5 | r8
        L_0x004c:
            r8 = r3 & 4
            if (r8 == 0) goto L_0x0053
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x0067
        L_0x0053:
            r15 = r0 & 384(0x180, float:5.38E-43)
            if (r15 != 0) goto L_0x0067
            r15 = r67
            boolean r16 = r4.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x0062
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r5 = r5 | r16
            goto L_0x0069
        L_0x0067:
            r15 = r67
        L_0x0069:
            r16 = r3 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0074
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            goto L_0x0088
        L_0x0074:
            r6 = r0 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x0088
            r6 = r68
            boolean r19 = r4.changed((boolean) r6)
            if (r19 == 0) goto L_0x0083
            r19 = r17
            goto L_0x0085
        L_0x0083:
            r19 = r18
        L_0x0085:
            r5 = r5 | r19
            goto L_0x008a
        L_0x0088:
            r6 = r68
        L_0x008a:
            r19 = r3 & 16
            r20 = 8192(0x2000, float:1.14794E-41)
            if (r19 == 0) goto L_0x0093
            r5 = r5 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a7
        L_0x0093:
            r7 = r0 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x00a7
            r7 = r69
            boolean r22 = r4.changed((boolean) r7)
            if (r22 == 0) goto L_0x00a2
            r22 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a4
        L_0x00a2:
            r22 = r20
        L_0x00a4:
            r5 = r5 | r22
            goto L_0x00a9
        L_0x00a7:
            r7 = r69
        L_0x00a9:
            r22 = 196608(0x30000, float:2.75506E-40)
            r23 = r0 & r22
            if (r23 != 0) goto L_0x00c3
            r23 = r3 & 32
            r9 = r70
            if (r23 != 0) goto L_0x00be
            boolean r24 = r4.changed((java.lang.Object) r9)
            if (r24 == 0) goto L_0x00be
            r24 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c0
        L_0x00be:
            r24 = 65536(0x10000, float:9.18355E-41)
        L_0x00c0:
            r5 = r5 | r24
            goto L_0x00c5
        L_0x00c3:
            r9 = r70
        L_0x00c5:
            r24 = r3 & 64
            r25 = 1572864(0x180000, float:2.204052E-39)
            if (r24 == 0) goto L_0x00d0
            r5 = r5 | r25
            r10 = r71
            goto L_0x00e3
        L_0x00d0:
            r26 = r0 & r25
            r10 = r71
            if (r26 != 0) goto L_0x00e3
            boolean r27 = r4.changedInstance(r10)
            if (r27 == 0) goto L_0x00df
            r27 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e1
        L_0x00df:
            r27 = 524288(0x80000, float:7.34684E-40)
        L_0x00e1:
            r5 = r5 | r27
        L_0x00e3:
            r11 = r3 & 128(0x80, float:1.794E-43)
            r28 = 4194304(0x400000, float:5.877472E-39)
            r29 = 12582912(0xc00000, float:1.7632415E-38)
            if (r11 == 0) goto L_0x00f0
            r5 = r5 | r29
            r14 = r72
            goto L_0x0103
        L_0x00f0:
            r30 = r0 & r29
            r14 = r72
            if (r30 != 0) goto L_0x0103
            boolean r31 = r4.changedInstance(r14)
            if (r31 == 0) goto L_0x00ff
            r31 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0101
        L_0x00ff:
            r31 = r28
        L_0x0101:
            r5 = r5 | r31
        L_0x0103:
            r0 = r3 & 256(0x100, float:3.59E-43)
            r31 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x010c
            r5 = r5 | r31
            goto L_0x0122
        L_0x010c:
            r31 = r89 & r31
            if (r31 != 0) goto L_0x0122
            r31 = r0
            r0 = r73
            boolean r32 = r4.changedInstance(r0)
            if (r32 == 0) goto L_0x011d
            r32 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011f
        L_0x011d:
            r32 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011f:
            r5 = r5 | r32
            goto L_0x0126
        L_0x0122:
            r31 = r0
            r0 = r73
        L_0x0126:
            r0 = r3 & 512(0x200, float:7.175E-43)
            r32 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x012f
            r5 = r5 | r32
            goto L_0x0145
        L_0x012f:
            r33 = r89 & r32
            if (r33 != 0) goto L_0x0145
            r33 = r0
            r0 = r74
            boolean r34 = r4.changedInstance(r0)
            if (r34 == 0) goto L_0x0140
            r34 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0142
        L_0x0140:
            r34 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0142:
            r5 = r5 | r34
            goto L_0x0149
        L_0x0145:
            r33 = r0
            r0 = r74
        L_0x0149:
            r0 = r3 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0156
            r34 = r1 | 6
            r35 = r34
            r34 = r0
            r0 = r75
            goto L_0x0172
        L_0x0156:
            r34 = r1 & 6
            if (r34 != 0) goto L_0x016c
            r34 = r0
            r0 = r75
            boolean r35 = r4.changedInstance(r0)
            if (r35 == 0) goto L_0x0167
            r35 = 4
            goto L_0x0169
        L_0x0167:
            r35 = 2
        L_0x0169:
            r35 = r1 | r35
            goto L_0x0172
        L_0x016c:
            r34 = r0
            r0 = r75
            r35 = r1
        L_0x0172:
            r0 = r3 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x017b
            r35 = r35 | 48
            r36 = r0
            goto L_0x0195
        L_0x017b:
            r36 = r1 & 48
            if (r36 != 0) goto L_0x0191
            r36 = r0
            r0 = r76
            boolean r37 = r4.changedInstance(r0)
            if (r37 == 0) goto L_0x018c
            r37 = 32
            goto L_0x018e
        L_0x018c:
            r37 = 16
        L_0x018e:
            r35 = r35 | r37
            goto L_0x0195
        L_0x0191:
            r36 = r0
            r0 = r76
        L_0x0195:
            r0 = r35
            r35 = r5
            r5 = r3 & 4096(0x1000, float:5.74E-42)
            if (r5 == 0) goto L_0x01a0
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x01ba
        L_0x01a0:
            r37 = r0
            r0 = r1 & 384(0x180, float:5.38E-43)
            if (r0 != 0) goto L_0x01b6
            r0 = r77
            boolean r38 = r4.changedInstance(r0)
            if (r38 == 0) goto L_0x01b1
            r38 = 256(0x100, float:3.59E-43)
            goto L_0x01b3
        L_0x01b1:
            r38 = 128(0x80, float:1.794E-43)
        L_0x01b3:
            r37 = r37 | r38
            goto L_0x01b8
        L_0x01b6:
            r0 = r77
        L_0x01b8:
            r0 = r37
        L_0x01ba:
            r37 = r5
            r5 = r3 & 8192(0x2000, float:1.14794E-41)
            if (r5 == 0) goto L_0x01c3
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x01dd
        L_0x01c3:
            r38 = r0
            r0 = r1 & 3072(0xc00, float:4.305E-42)
            if (r0 != 0) goto L_0x01d9
            r0 = r78
            boolean r39 = r4.changed((boolean) r0)
            if (r39 == 0) goto L_0x01d2
            goto L_0x01d4
        L_0x01d2:
            r17 = r18
        L_0x01d4:
            r17 = r38 | r17
            r0 = r17
            goto L_0x01dd
        L_0x01d9:
            r0 = r78
            r0 = r38
        L_0x01dd:
            r17 = r5
            r5 = r3 & 16384(0x4000, float:2.2959E-41)
            if (r5 == 0) goto L_0x01e8
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r18 = r0
            goto L_0x01fb
        L_0x01e8:
            r18 = r0
            r0 = r1 & 24576(0x6000, float:3.4438E-41)
            if (r0 != 0) goto L_0x01fb
            r0 = r79
            boolean r38 = r4.changed((java.lang.Object) r0)
            if (r38 == 0) goto L_0x01f8
            r20 = 16384(0x4000, float:2.2959E-41)
        L_0x01f8:
            r18 = r18 | r20
            goto L_0x01fd
        L_0x01fb:
            r0 = r79
        L_0x01fd:
            r20 = 32768(0x8000, float:4.5918E-41)
            r20 = r3 & r20
            if (r20 == 0) goto L_0x0209
            r18 = r18 | r22
            r0 = r80
            goto L_0x021c
        L_0x0209:
            r22 = r1 & r22
            r0 = r80
            if (r22 != 0) goto L_0x021c
            boolean r22 = r4.changed((java.lang.Object) r0)
            if (r22 == 0) goto L_0x0218
            r22 = 131072(0x20000, float:1.83671E-40)
            goto L_0x021a
        L_0x0218:
            r22 = 65536(0x10000, float:9.18355E-41)
        L_0x021a:
            r18 = r18 | r22
        L_0x021c:
            r22 = 65536(0x10000, float:9.18355E-41)
            r22 = r3 & r22
            if (r22 == 0) goto L_0x0227
            r18 = r18 | r25
            r0 = r81
            goto L_0x023a
        L_0x0227:
            r25 = r1 & r25
            r0 = r81
            if (r25 != 0) goto L_0x023a
            boolean r25 = r4.changed((java.lang.Object) r0)
            if (r25 == 0) goto L_0x0236
            r25 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0238
        L_0x0236:
            r25 = 524288(0x80000, float:7.34684E-40)
        L_0x0238:
            r18 = r18 | r25
        L_0x023a:
            r25 = 131072(0x20000, float:1.83671E-40)
            r25 = r3 & r25
            if (r25 == 0) goto L_0x0245
            r18 = r18 | r29
            r0 = r82
            goto L_0x0258
        L_0x0245:
            r29 = r1 & r29
            r0 = r82
            if (r29 != 0) goto L_0x0258
            boolean r29 = r4.changed((boolean) r0)
            if (r29 == 0) goto L_0x0254
            r29 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0256
        L_0x0254:
            r29 = r28
        L_0x0256:
            r18 = r18 | r29
        L_0x0258:
            r29 = 100663296(0x6000000, float:2.4074124E-35)
            r29 = r1 & r29
            if (r29 != 0) goto L_0x0274
            r29 = 262144(0x40000, float:3.67342E-40)
            r29 = r3 & r29
            r0 = r83
            if (r29 != 0) goto L_0x026f
            boolean r29 = r4.changed((int) r0)
            if (r29 == 0) goto L_0x026f
            r29 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0271
        L_0x026f:
            r29 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0271:
            r18 = r18 | r29
            goto L_0x0276
        L_0x0274:
            r0 = r83
        L_0x0276:
            r29 = 524288(0x80000, float:7.34684E-40)
            r29 = r3 & r29
            if (r29 == 0) goto L_0x0281
            r18 = r18 | r32
            r0 = r84
            goto L_0x0294
        L_0x0281:
            r32 = r1 & r32
            r0 = r84
            if (r32 != 0) goto L_0x0294
            boolean r32 = r4.changed((int) r0)
            if (r32 == 0) goto L_0x0290
            r32 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0292
        L_0x0290:
            r32 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0292:
            r18 = r18 | r32
        L_0x0294:
            r32 = 1048576(0x100000, float:1.469368E-39)
            r32 = r3 & r32
            if (r32 == 0) goto L_0x029f
            r21 = r2 | 6
            r0 = r85
            goto L_0x02b5
        L_0x029f:
            r38 = r2 & 6
            r0 = r85
            if (r38 != 0) goto L_0x02b3
            boolean r38 = r4.changed((java.lang.Object) r0)
            if (r38 == 0) goto L_0x02ae
            r21 = 4
            goto L_0x02b0
        L_0x02ae:
            r21 = 2
        L_0x02b0:
            r21 = r2 | r21
            goto L_0x02b5
        L_0x02b3:
            r21 = r2
        L_0x02b5:
            r38 = r2 & 48
            if (r38 != 0) goto L_0x02cf
            r38 = 2097152(0x200000, float:2.938736E-39)
            r38 = r3 & r38
            r0 = r86
            if (r38 != 0) goto L_0x02ca
            boolean r38 = r4.changed((java.lang.Object) r0)
            if (r38 == 0) goto L_0x02ca
            r23 = 32
            goto L_0x02cc
        L_0x02ca:
            r23 = 16
        L_0x02cc:
            r21 = r21 | r23
            goto L_0x02d1
        L_0x02cf:
            r0 = r86
        L_0x02d1:
            r0 = r2 & 384(0x180, float:5.38E-43)
            if (r0 != 0) goto L_0x02eb
            r0 = r3 & r28
            if (r0 != 0) goto L_0x02e4
            r0 = r87
            boolean r23 = r4.changed((java.lang.Object) r0)
            if (r23 == 0) goto L_0x02e6
            r27 = 256(0x100, float:3.59E-43)
            goto L_0x02e8
        L_0x02e4:
            r0 = r87
        L_0x02e6:
            r27 = 128(0x80, float:1.794E-43)
        L_0x02e8:
            r21 = r21 | r27
            goto L_0x02ed
        L_0x02eb:
            r0 = r87
        L_0x02ed:
            r0 = r21
            r21 = 306783379(0x12492493, float:6.34695E-28)
            r1 = r35 & r21
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r2) goto L_0x033a
            r1 = 306783379(0x12492493, float:6.34695E-28)
            r1 = r18 & r1
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r2) goto L_0x033a
            r0 = r0 & 147(0x93, float:2.06E-43)
            r1 = 146(0x92, float:2.05E-43)
            if (r0 != r1) goto L_0x033a
            boolean r0 = r4.getSkipping()
            if (r0 != 0) goto L_0x0310
            goto L_0x033a
        L_0x0310:
            r4.skipToGroupEnd()
            r26 = r73
            r11 = r75
            r12 = r76
            r13 = r77
            r16 = r80
            r17 = r81
            r18 = r82
            r19 = r83
            r20 = r84
            r21 = r85
            r22 = r86
            r23 = r87
            r0 = r4
            r4 = r6
            r5 = r7
            r6 = r9
            r7 = r10
            r8 = r14
            r9 = r15
            r10 = r74
            r14 = r78
            r15 = r79
            goto L_0x05ab
        L_0x033a:
            r4.startDefaults()
            r0 = r89 & 1
            if (r0 == 0) goto L_0x038c
            boolean r0 = r4.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0348
            goto L_0x038c
        L_0x0348:
            r4.skipToGroupEnd()
            r0 = r3 & 32
            if (r0 == 0) goto L_0x0355
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r5 = r35 & r0
            goto L_0x0357
        L_0x0355:
            r5 = r35
        L_0x0357:
            r0 = 262144(0x40000, float:3.67342E-40)
            r0 = r0 & r3
            if (r0 == 0) goto L_0x0361
            r0 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r18 = r18 & r0
        L_0x0361:
            r26 = r73
            r27 = r74
            r28 = r75
            r29 = r76
            r30 = r77
            r22 = r79
            r17 = r80
            r19 = r82
            r20 = r83
            r21 = r84
            r1 = r85
            r31 = r86
            r11 = r87
            r0 = r9
            r24 = r10
            r25 = r14
            r9 = r15
            r2 = r18
            r10 = r78
            r18 = r81
        L_0x0387:
            r14 = r6
            r15 = r7
        L_0x0389:
            r6 = 0
            goto L_0x04a6
        L_0x038c:
            if (r8 == 0) goto L_0x0393
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r15 = r0
        L_0x0393:
            if (r16 == 0) goto L_0x0396
            r6 = 1
        L_0x0396:
            if (r19 == 0) goto L_0x0399
            r7 = 0
        L_0x0399:
            r0 = r3 & 32
            if (r0 == 0) goto L_0x03bb
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material3.TextKt.getLocalTextStyle()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r9 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r8, r9)
            java.lang.Object r0 = r4.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.text.TextStyle r0 = (androidx.compose.ui.text.TextStyle) r0
            r8 = -458753(0xfffffffffff8ffff, float:NaN)
            r8 = r35 & r8
            r9 = r0
            goto L_0x03bd
        L_0x03bb:
            r8 = r35
        L_0x03bd:
            r0 = 0
            if (r24 == 0) goto L_0x03c1
            r10 = r0
        L_0x03c1:
            if (r11 == 0) goto L_0x03c4
            r14 = r0
        L_0x03c4:
            if (r31 == 0) goto L_0x03c8
            r11 = r0
            goto L_0x03ca
        L_0x03c8:
            r11 = r73
        L_0x03ca:
            if (r33 == 0) goto L_0x03cf
            r16 = r0
            goto L_0x03d1
        L_0x03cf:
            r16 = r74
        L_0x03d1:
            if (r34 == 0) goto L_0x03d6
            r19 = r0
            goto L_0x03d8
        L_0x03d6:
            r19 = r75
        L_0x03d8:
            if (r36 == 0) goto L_0x03dd
            r21 = r0
            goto L_0x03df
        L_0x03dd:
            r21 = r76
        L_0x03df:
            if (r37 == 0) goto L_0x03e4
            r23 = r0
            goto L_0x03e6
        L_0x03e4:
            r23 = r77
        L_0x03e6:
            if (r17 == 0) goto L_0x03eb
            r17 = 0
            goto L_0x03ed
        L_0x03eb:
            r17 = r78
        L_0x03ed:
            if (r5 == 0) goto L_0x03f6
            androidx.compose.ui.text.input.VisualTransformation$Companion r5 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r5 = r5.getNone()
            goto L_0x03f8
        L_0x03f6:
            r5 = r79
        L_0x03f8:
            if (r20 == 0) goto L_0x0401
            androidx.compose.foundation.text.KeyboardOptions$Companion r20 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r20 = r20.getDefault()
            goto L_0x0403
        L_0x0401:
            r20 = r80
        L_0x0403:
            if (r22 == 0) goto L_0x040c
            androidx.compose.foundation.text.KeyboardActions$Companion r22 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r22 = r22.getDefault()
            goto L_0x040e
        L_0x040c:
            r22 = r81
        L_0x040e:
            if (r25 == 0) goto L_0x0413
            r24 = 0
            goto L_0x0415
        L_0x0413:
            r24 = r82
        L_0x0415:
            r25 = 262144(0x40000, float:3.67342E-40)
            r25 = r3 & r25
            if (r25 == 0) goto L_0x0429
            if (r24 == 0) goto L_0x0420
            r25 = 1
            goto L_0x0423
        L_0x0420:
            r25 = 2147483647(0x7fffffff, float:NaN)
        L_0x0423:
            r26 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r18 = r18 & r26
            goto L_0x042b
        L_0x0429:
            r25 = r83
        L_0x042b:
            if (r29 == 0) goto L_0x0430
            r26 = 1
            goto L_0x0432
        L_0x0430:
            r26 = r84
        L_0x0432:
            if (r32 == 0) goto L_0x0435
            goto L_0x0437
        L_0x0435:
            r0 = r85
        L_0x0437:
            r27 = 2097152(0x200000, float:2.938736E-39)
            r27 = r3 & r27
            r2 = 6
            if (r27 == 0) goto L_0x0445
            androidx.compose.material3.TextFieldDefaults r1 = androidx.compose.material3.TextFieldDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r1 = r1.getShape(r4, r2)
            goto L_0x0447
        L_0x0445:
            r1 = r86
        L_0x0447:
            r28 = r3 & r28
            r67 = r0
            if (r28 == 0) goto L_0x047b
            androidx.compose.material3.TextFieldDefaults r0 = androidx.compose.material3.TextFieldDefaults.INSTANCE
            androidx.compose.material3.TextFieldColors r0 = r0.colors(r4, r2)
            r31 = r1
            r27 = r16
            r2 = r18
            r28 = r19
            r29 = r21
            r18 = r22
            r30 = r23
            r19 = r24
            r21 = r26
            r1 = r67
            r22 = r5
            r5 = r8
            r24 = r10
            r26 = r11
            r10 = r17
            r17 = r20
            r20 = r25
            r11 = r0
            r0 = r9
            r25 = r14
            r9 = r15
            goto L_0x0387
        L_0x047b:
            r31 = r1
            r0 = r9
            r9 = r15
            r27 = r16
            r2 = r18
            r28 = r19
            r29 = r21
            r18 = r22
            r30 = r23
            r19 = r24
            r21 = r26
            r1 = r67
            r22 = r5
            r15 = r7
            r5 = r8
            r24 = r10
            r26 = r11
            r10 = r17
            r17 = r20
            r20 = r25
            r11 = r87
            r25 = r14
            r14 = r6
            goto L_0x0389
        L_0x04a6:
            r4.endDefaults()
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x04b7
            r7 = -676242365(0xffffffffd7b15c43, float:-3.90019638E14)
            java.lang.String r8 = "androidx.compose.material3.TextField (TextField.kt:219)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r5, r2, r8)
        L_0x04b7:
            r2 = -508515290(0xffffffffe1b0ac26, float:-4.0737894E20)
            r4.startReplaceGroup(r2)
            java.lang.String r2 = "221@11518L39"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r2)
            if (r1 != 0) goto L_0x04e7
            r2 = -508514639(0xffffffffe1b0aeb1, float:-4.0740185E20)
            java.lang.String r5 = "CC(remember):TextField.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r2, r5)
            java.lang.Object r2 = r4.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r2 != r5) goto L_0x04df
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r4.updateRememberedValue(r2)
        L_0x04df:
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = (androidx.compose.foundation.interaction.MutableInteractionSource) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r23 = r2
            goto L_0x04e9
        L_0x04e7:
            r23 = r1
        L_0x04e9:
            r4.endReplaceGroup()
            r2 = -508509180(0xffffffffe1b0c404, float:-4.0759392E20)
            r4.startReplaceGroup(r2)
            java.lang.String r2 = "*225@11742L25"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r2)
            long r7 = r0.m6594getColor0d7_KjU()
            r32 = 16
            int r2 = (r7 > r32 ? 1 : (r7 == r32 ? 0 : -1))
            if (r2 == 0) goto L_0x0502
            goto L_0x0518
        L_0x0502:
            r2 = r23
            androidx.compose.foundation.interaction.InteractionSource r2 = (androidx.compose.foundation.interaction.InteractionSource) r2
            androidx.compose.runtime.State r2 = androidx.compose.foundation.interaction.FocusInteractionKt.collectIsFocusedAsState(r2, r4, r6)
            java.lang.Object r2 = r2.getValue()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            long r7 = r11.m2659textColorXeAY9LY$material3_release(r14, r10, r2)
        L_0x0518:
            r33 = r7
            r4.endReplaceGroup()
            androidx.compose.ui.text.TextStyle r32 = new androidx.compose.ui.text.TextStyle
            r62 = 16777214(0xfffffe, float:2.3509884E-38)
            r63 = 0
            r35 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r49 = 0
            r50 = 0
            r51 = 0
            r52 = 0
            r53 = 0
            r54 = 0
            r56 = 0
            r57 = 0
            r58 = 0
            r59 = 0
            r60 = 0
            r61 = 0
            r32.<init>((long) r33, (long) r35, (androidx.compose.ui.text.font.FontWeight) r37, (androidx.compose.ui.text.font.FontStyle) r38, (androidx.compose.ui.text.font.FontSynthesis) r39, (androidx.compose.ui.text.font.FontFamily) r40, (java.lang.String) r41, (long) r42, (androidx.compose.ui.text.style.BaselineShift) r44, (androidx.compose.ui.text.style.TextGeometricTransform) r45, (androidx.compose.ui.text.intl.LocaleList) r46, (long) r47, (androidx.compose.ui.text.style.TextDecoration) r49, (androidx.compose.ui.graphics.Shadow) r50, (androidx.compose.ui.graphics.drawscope.DrawStyle) r51, (int) r52, (int) r53, (long) r54, (androidx.compose.ui.text.style.TextIndent) r56, (androidx.compose.ui.text.PlatformTextStyle) r57, (androidx.compose.ui.text.style.LineHeightStyle) r58, (int) r59, (int) r60, (androidx.compose.ui.text.style.TextMotion) r61, (int) r62, (kotlin.jvm.internal.DefaultConstructorMarker) r63)
            r2 = r32
            androidx.compose.ui.text.TextStyle r16 = r0.merge((androidx.compose.ui.text.TextStyle) r2)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.foundation.text.selection.TextSelectionColors r5 = r11.getTextSelectionColors()
            androidx.compose.runtime.ProvidedValue r2 = r2.provides(r5)
            androidx.compose.material3.TextFieldKt$TextField$1 r8 = new androidx.compose.material3.TextFieldKt$TextField$1
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            r5 = 54
            r6 = 1859145987(0x6ed05103, float:3.223541E28)
            r7 = 1
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r6, r7, r8, r4, r5)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            int r6 = androidx.compose.runtime.ProvidedValue.$stable
            r6 = r6 | 48
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>) r2, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r5, (androidx.compose.runtime.Composer) r4, (int) r6)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0588
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0588:
            r6 = r0
            r0 = r4
            r23 = r11
            r4 = r14
            r5 = r15
            r16 = r17
            r17 = r18
            r18 = r19
            r19 = r20
            r20 = r21
            r15 = r22
            r7 = r24
            r8 = r25
            r11 = r28
            r12 = r29
            r13 = r30
            r22 = r31
            r21 = r1
            r14 = r10
            r10 = r27
        L_0x05ab:
            androidx.compose.runtime.ScopeUpdateScope r0 = r0.endRestartGroup()
            if (r0 == 0) goto L_0x05cf
            r1 = r0
            androidx.compose.material3.TextFieldKt$TextField$2 r0 = new androidx.compose.material3.TextFieldKt$TextField$2
            r2 = r66
            r24 = r89
            r25 = r90
            r64 = r1
            r27 = r3
            r3 = r9
            r9 = r26
            r1 = r65
            r26 = r91
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r64
            r1.updateScope(r0)
        L_0x05cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldKt.TextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0245  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x029f  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x02b9  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x02cf  */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x02d5  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x02eb  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x0310  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x033a  */
    /* JADX WARNING: Removed duplicated region for block: B:332:0x04af  */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x04c4  */
    /* JADX WARNING: Removed duplicated region for block: B:339:0x04e7  */
    /* JADX WARNING: Removed duplicated region for block: B:342:0x0502  */
    /* JADX WARNING: Removed duplicated region for block: B:345:0x0585  */
    /* JADX WARNING: Removed duplicated region for block: B:349:0x05b1  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:351:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x012f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TextField(androidx.compose.ui.text.input.TextFieldValue r65, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r66, androidx.compose.ui.Modifier r67, boolean r68, boolean r69, androidx.compose.ui.text.TextStyle r70, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r71, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r72, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r73, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r74, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r75, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r76, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r77, boolean r78, androidx.compose.ui.text.input.VisualTransformation r79, androidx.compose.foundation.text.KeyboardOptions r80, androidx.compose.foundation.text.KeyboardActions r81, boolean r82, int r83, int r84, androidx.compose.foundation.interaction.MutableInteractionSource r85, androidx.compose.ui.graphics.Shape r86, androidx.compose.material3.TextFieldColors r87, androidx.compose.runtime.Composer r88, int r89, int r90, int r91, int r92) {
        /*
            r0 = r89
            r1 = r90
            r2 = r91
            r3 = r92
            r4 = -1268528240(0xffffffffb463cb90, float:-2.1215078E-7)
            r5 = r88
            androidx.compose.runtime.Composer r4 = r5.startRestartGroup(r4)
            java.lang.String r5 = "C(TextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)357@19138L7,373@19934L5,374@19989L8,386@20569L1961,386@20482L2048:TextField.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r5)
            r5 = r3 & 1
            if (r5 == 0) goto L_0x001f
            r5 = r0 | 6
            r12 = r65
            goto L_0x0031
        L_0x001f:
            r5 = r0 & 6
            r12 = r65
            if (r5 != 0) goto L_0x0030
            boolean r5 = r4.changed((java.lang.Object) r12)
            if (r5 == 0) goto L_0x002d
            r5 = 4
            goto L_0x002e
        L_0x002d:
            r5 = 2
        L_0x002e:
            r5 = r5 | r0
            goto L_0x0031
        L_0x0030:
            r5 = r0
        L_0x0031:
            r8 = r3 & 2
            if (r8 == 0) goto L_0x003a
            r5 = r5 | 48
            r13 = r66
            goto L_0x004c
        L_0x003a:
            r8 = r0 & 48
            r13 = r66
            if (r8 != 0) goto L_0x004c
            boolean r8 = r4.changedInstance(r13)
            if (r8 == 0) goto L_0x0049
            r8 = 32
            goto L_0x004b
        L_0x0049:
            r8 = 16
        L_0x004b:
            r5 = r5 | r8
        L_0x004c:
            r8 = r3 & 4
            if (r8 == 0) goto L_0x0053
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x0067
        L_0x0053:
            r15 = r0 & 384(0x180, float:5.38E-43)
            if (r15 != 0) goto L_0x0067
            r15 = r67
            boolean r16 = r4.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x0062
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r5 = r5 | r16
            goto L_0x0069
        L_0x0067:
            r15 = r67
        L_0x0069:
            r16 = r3 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0074
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            goto L_0x0088
        L_0x0074:
            r6 = r0 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x0088
            r6 = r68
            boolean r19 = r4.changed((boolean) r6)
            if (r19 == 0) goto L_0x0083
            r19 = r17
            goto L_0x0085
        L_0x0083:
            r19 = r18
        L_0x0085:
            r5 = r5 | r19
            goto L_0x008a
        L_0x0088:
            r6 = r68
        L_0x008a:
            r19 = r3 & 16
            r20 = 8192(0x2000, float:1.14794E-41)
            if (r19 == 0) goto L_0x0093
            r5 = r5 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a7
        L_0x0093:
            r7 = r0 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x00a7
            r7 = r69
            boolean r22 = r4.changed((boolean) r7)
            if (r22 == 0) goto L_0x00a2
            r22 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a4
        L_0x00a2:
            r22 = r20
        L_0x00a4:
            r5 = r5 | r22
            goto L_0x00a9
        L_0x00a7:
            r7 = r69
        L_0x00a9:
            r22 = 196608(0x30000, float:2.75506E-40)
            r23 = r0 & r22
            if (r23 != 0) goto L_0x00c3
            r23 = r3 & 32
            r9 = r70
            if (r23 != 0) goto L_0x00be
            boolean r24 = r4.changed((java.lang.Object) r9)
            if (r24 == 0) goto L_0x00be
            r24 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c0
        L_0x00be:
            r24 = 65536(0x10000, float:9.18355E-41)
        L_0x00c0:
            r5 = r5 | r24
            goto L_0x00c5
        L_0x00c3:
            r9 = r70
        L_0x00c5:
            r24 = r3 & 64
            r25 = 1572864(0x180000, float:2.204052E-39)
            if (r24 == 0) goto L_0x00d0
            r5 = r5 | r25
            r10 = r71
            goto L_0x00e3
        L_0x00d0:
            r26 = r0 & r25
            r10 = r71
            if (r26 != 0) goto L_0x00e3
            boolean r27 = r4.changedInstance(r10)
            if (r27 == 0) goto L_0x00df
            r27 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e1
        L_0x00df:
            r27 = 524288(0x80000, float:7.34684E-40)
        L_0x00e1:
            r5 = r5 | r27
        L_0x00e3:
            r11 = r3 & 128(0x80, float:1.794E-43)
            r28 = 4194304(0x400000, float:5.877472E-39)
            r29 = 12582912(0xc00000, float:1.7632415E-38)
            if (r11 == 0) goto L_0x00f0
            r5 = r5 | r29
            r14 = r72
            goto L_0x0103
        L_0x00f0:
            r30 = r0 & r29
            r14 = r72
            if (r30 != 0) goto L_0x0103
            boolean r31 = r4.changedInstance(r14)
            if (r31 == 0) goto L_0x00ff
            r31 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0101
        L_0x00ff:
            r31 = r28
        L_0x0101:
            r5 = r5 | r31
        L_0x0103:
            r0 = r3 & 256(0x100, float:3.59E-43)
            r31 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x010c
            r5 = r5 | r31
            goto L_0x0122
        L_0x010c:
            r31 = r89 & r31
            if (r31 != 0) goto L_0x0122
            r31 = r0
            r0 = r73
            boolean r32 = r4.changedInstance(r0)
            if (r32 == 0) goto L_0x011d
            r32 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011f
        L_0x011d:
            r32 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011f:
            r5 = r5 | r32
            goto L_0x0126
        L_0x0122:
            r31 = r0
            r0 = r73
        L_0x0126:
            r0 = r3 & 512(0x200, float:7.175E-43)
            r32 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x012f
            r5 = r5 | r32
            goto L_0x0145
        L_0x012f:
            r33 = r89 & r32
            if (r33 != 0) goto L_0x0145
            r33 = r0
            r0 = r74
            boolean r34 = r4.changedInstance(r0)
            if (r34 == 0) goto L_0x0140
            r34 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0142
        L_0x0140:
            r34 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0142:
            r5 = r5 | r34
            goto L_0x0149
        L_0x0145:
            r33 = r0
            r0 = r74
        L_0x0149:
            r0 = r3 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0156
            r34 = r1 | 6
            r35 = r34
            r34 = r0
            r0 = r75
            goto L_0x0172
        L_0x0156:
            r34 = r1 & 6
            if (r34 != 0) goto L_0x016c
            r34 = r0
            r0 = r75
            boolean r35 = r4.changedInstance(r0)
            if (r35 == 0) goto L_0x0167
            r35 = 4
            goto L_0x0169
        L_0x0167:
            r35 = 2
        L_0x0169:
            r35 = r1 | r35
            goto L_0x0172
        L_0x016c:
            r34 = r0
            r0 = r75
            r35 = r1
        L_0x0172:
            r0 = r3 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x017b
            r35 = r35 | 48
            r36 = r0
            goto L_0x0195
        L_0x017b:
            r36 = r1 & 48
            if (r36 != 0) goto L_0x0191
            r36 = r0
            r0 = r76
            boolean r37 = r4.changedInstance(r0)
            if (r37 == 0) goto L_0x018c
            r37 = 32
            goto L_0x018e
        L_0x018c:
            r37 = 16
        L_0x018e:
            r35 = r35 | r37
            goto L_0x0195
        L_0x0191:
            r36 = r0
            r0 = r76
        L_0x0195:
            r0 = r35
            r35 = r5
            r5 = r3 & 4096(0x1000, float:5.74E-42)
            if (r5 == 0) goto L_0x01a0
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x01ba
        L_0x01a0:
            r37 = r0
            r0 = r1 & 384(0x180, float:5.38E-43)
            if (r0 != 0) goto L_0x01b6
            r0 = r77
            boolean r38 = r4.changedInstance(r0)
            if (r38 == 0) goto L_0x01b1
            r38 = 256(0x100, float:3.59E-43)
            goto L_0x01b3
        L_0x01b1:
            r38 = 128(0x80, float:1.794E-43)
        L_0x01b3:
            r37 = r37 | r38
            goto L_0x01b8
        L_0x01b6:
            r0 = r77
        L_0x01b8:
            r0 = r37
        L_0x01ba:
            r37 = r5
            r5 = r3 & 8192(0x2000, float:1.14794E-41)
            if (r5 == 0) goto L_0x01c3
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x01dd
        L_0x01c3:
            r38 = r0
            r0 = r1 & 3072(0xc00, float:4.305E-42)
            if (r0 != 0) goto L_0x01d9
            r0 = r78
            boolean r39 = r4.changed((boolean) r0)
            if (r39 == 0) goto L_0x01d2
            goto L_0x01d4
        L_0x01d2:
            r17 = r18
        L_0x01d4:
            r17 = r38 | r17
            r0 = r17
            goto L_0x01dd
        L_0x01d9:
            r0 = r78
            r0 = r38
        L_0x01dd:
            r17 = r5
            r5 = r3 & 16384(0x4000, float:2.2959E-41)
            if (r5 == 0) goto L_0x01e8
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r18 = r0
            goto L_0x01fb
        L_0x01e8:
            r18 = r0
            r0 = r1 & 24576(0x6000, float:3.4438E-41)
            if (r0 != 0) goto L_0x01fb
            r0 = r79
            boolean r38 = r4.changed((java.lang.Object) r0)
            if (r38 == 0) goto L_0x01f8
            r20 = 16384(0x4000, float:2.2959E-41)
        L_0x01f8:
            r18 = r18 | r20
            goto L_0x01fd
        L_0x01fb:
            r0 = r79
        L_0x01fd:
            r20 = 32768(0x8000, float:4.5918E-41)
            r20 = r3 & r20
            if (r20 == 0) goto L_0x0209
            r18 = r18 | r22
            r0 = r80
            goto L_0x021c
        L_0x0209:
            r22 = r1 & r22
            r0 = r80
            if (r22 != 0) goto L_0x021c
            boolean r22 = r4.changed((java.lang.Object) r0)
            if (r22 == 0) goto L_0x0218
            r22 = 131072(0x20000, float:1.83671E-40)
            goto L_0x021a
        L_0x0218:
            r22 = 65536(0x10000, float:9.18355E-41)
        L_0x021a:
            r18 = r18 | r22
        L_0x021c:
            r22 = 65536(0x10000, float:9.18355E-41)
            r22 = r3 & r22
            if (r22 == 0) goto L_0x0227
            r18 = r18 | r25
            r0 = r81
            goto L_0x023a
        L_0x0227:
            r25 = r1 & r25
            r0 = r81
            if (r25 != 0) goto L_0x023a
            boolean r25 = r4.changed((java.lang.Object) r0)
            if (r25 == 0) goto L_0x0236
            r25 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0238
        L_0x0236:
            r25 = 524288(0x80000, float:7.34684E-40)
        L_0x0238:
            r18 = r18 | r25
        L_0x023a:
            r25 = 131072(0x20000, float:1.83671E-40)
            r25 = r3 & r25
            if (r25 == 0) goto L_0x0245
            r18 = r18 | r29
            r0 = r82
            goto L_0x0258
        L_0x0245:
            r29 = r1 & r29
            r0 = r82
            if (r29 != 0) goto L_0x0258
            boolean r29 = r4.changed((boolean) r0)
            if (r29 == 0) goto L_0x0254
            r29 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0256
        L_0x0254:
            r29 = r28
        L_0x0256:
            r18 = r18 | r29
        L_0x0258:
            r29 = 100663296(0x6000000, float:2.4074124E-35)
            r29 = r1 & r29
            if (r29 != 0) goto L_0x0274
            r29 = 262144(0x40000, float:3.67342E-40)
            r29 = r3 & r29
            r0 = r83
            if (r29 != 0) goto L_0x026f
            boolean r29 = r4.changed((int) r0)
            if (r29 == 0) goto L_0x026f
            r29 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0271
        L_0x026f:
            r29 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0271:
            r18 = r18 | r29
            goto L_0x0276
        L_0x0274:
            r0 = r83
        L_0x0276:
            r29 = 524288(0x80000, float:7.34684E-40)
            r29 = r3 & r29
            if (r29 == 0) goto L_0x0281
            r18 = r18 | r32
            r0 = r84
            goto L_0x0294
        L_0x0281:
            r32 = r1 & r32
            r0 = r84
            if (r32 != 0) goto L_0x0294
            boolean r32 = r4.changed((int) r0)
            if (r32 == 0) goto L_0x0290
            r32 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0292
        L_0x0290:
            r32 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0292:
            r18 = r18 | r32
        L_0x0294:
            r32 = 1048576(0x100000, float:1.469368E-39)
            r32 = r3 & r32
            if (r32 == 0) goto L_0x029f
            r21 = r2 | 6
            r0 = r85
            goto L_0x02b5
        L_0x029f:
            r38 = r2 & 6
            r0 = r85
            if (r38 != 0) goto L_0x02b3
            boolean r38 = r4.changed((java.lang.Object) r0)
            if (r38 == 0) goto L_0x02ae
            r21 = 4
            goto L_0x02b0
        L_0x02ae:
            r21 = 2
        L_0x02b0:
            r21 = r2 | r21
            goto L_0x02b5
        L_0x02b3:
            r21 = r2
        L_0x02b5:
            r38 = r2 & 48
            if (r38 != 0) goto L_0x02cf
            r38 = 2097152(0x200000, float:2.938736E-39)
            r38 = r3 & r38
            r0 = r86
            if (r38 != 0) goto L_0x02ca
            boolean r38 = r4.changed((java.lang.Object) r0)
            if (r38 == 0) goto L_0x02ca
            r23 = 32
            goto L_0x02cc
        L_0x02ca:
            r23 = 16
        L_0x02cc:
            r21 = r21 | r23
            goto L_0x02d1
        L_0x02cf:
            r0 = r86
        L_0x02d1:
            r0 = r2 & 384(0x180, float:5.38E-43)
            if (r0 != 0) goto L_0x02eb
            r0 = r3 & r28
            if (r0 != 0) goto L_0x02e4
            r0 = r87
            boolean r23 = r4.changed((java.lang.Object) r0)
            if (r23 == 0) goto L_0x02e6
            r27 = 256(0x100, float:3.59E-43)
            goto L_0x02e8
        L_0x02e4:
            r0 = r87
        L_0x02e6:
            r27 = 128(0x80, float:1.794E-43)
        L_0x02e8:
            r21 = r21 | r27
            goto L_0x02ed
        L_0x02eb:
            r0 = r87
        L_0x02ed:
            r0 = r21
            r21 = 306783379(0x12492493, float:6.34695E-28)
            r1 = r35 & r21
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r2) goto L_0x033a
            r1 = 306783379(0x12492493, float:6.34695E-28)
            r1 = r18 & r1
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r2) goto L_0x033a
            r0 = r0 & 147(0x93, float:2.06E-43)
            r1 = 146(0x92, float:2.05E-43)
            if (r0 != r1) goto L_0x033a
            boolean r0 = r4.getSkipping()
            if (r0 != 0) goto L_0x0310
            goto L_0x033a
        L_0x0310:
            r4.skipToGroupEnd()
            r26 = r73
            r11 = r75
            r12 = r76
            r13 = r77
            r16 = r80
            r17 = r81
            r18 = r82
            r19 = r83
            r20 = r84
            r21 = r85
            r22 = r86
            r23 = r87
            r0 = r4
            r4 = r6
            r5 = r7
            r6 = r9
            r7 = r10
            r8 = r14
            r9 = r15
            r10 = r74
            r14 = r78
            r15 = r79
            goto L_0x05ab
        L_0x033a:
            r4.startDefaults()
            r0 = r89 & 1
            if (r0 == 0) goto L_0x038c
            boolean r0 = r4.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0348
            goto L_0x038c
        L_0x0348:
            r4.skipToGroupEnd()
            r0 = r3 & 32
            if (r0 == 0) goto L_0x0355
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r5 = r35 & r0
            goto L_0x0357
        L_0x0355:
            r5 = r35
        L_0x0357:
            r0 = 262144(0x40000, float:3.67342E-40)
            r0 = r0 & r3
            if (r0 == 0) goto L_0x0361
            r0 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r18 = r18 & r0
        L_0x0361:
            r26 = r73
            r27 = r74
            r28 = r75
            r29 = r76
            r30 = r77
            r22 = r79
            r17 = r80
            r19 = r82
            r20 = r83
            r21 = r84
            r1 = r85
            r31 = r86
            r11 = r87
            r0 = r9
            r24 = r10
            r25 = r14
            r9 = r15
            r2 = r18
            r10 = r78
            r18 = r81
        L_0x0387:
            r14 = r6
            r15 = r7
        L_0x0389:
            r6 = 0
            goto L_0x04a6
        L_0x038c:
            if (r8 == 0) goto L_0x0393
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r15 = r0
        L_0x0393:
            if (r16 == 0) goto L_0x0396
            r6 = 1
        L_0x0396:
            if (r19 == 0) goto L_0x0399
            r7 = 0
        L_0x0399:
            r0 = r3 & 32
            if (r0 == 0) goto L_0x03bb
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material3.TextKt.getLocalTextStyle()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r9 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r8, r9)
            java.lang.Object r0 = r4.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.text.TextStyle r0 = (androidx.compose.ui.text.TextStyle) r0
            r8 = -458753(0xfffffffffff8ffff, float:NaN)
            r8 = r35 & r8
            r9 = r0
            goto L_0x03bd
        L_0x03bb:
            r8 = r35
        L_0x03bd:
            r0 = 0
            if (r24 == 0) goto L_0x03c1
            r10 = r0
        L_0x03c1:
            if (r11 == 0) goto L_0x03c4
            r14 = r0
        L_0x03c4:
            if (r31 == 0) goto L_0x03c8
            r11 = r0
            goto L_0x03ca
        L_0x03c8:
            r11 = r73
        L_0x03ca:
            if (r33 == 0) goto L_0x03cf
            r16 = r0
            goto L_0x03d1
        L_0x03cf:
            r16 = r74
        L_0x03d1:
            if (r34 == 0) goto L_0x03d6
            r19 = r0
            goto L_0x03d8
        L_0x03d6:
            r19 = r75
        L_0x03d8:
            if (r36 == 0) goto L_0x03dd
            r21 = r0
            goto L_0x03df
        L_0x03dd:
            r21 = r76
        L_0x03df:
            if (r37 == 0) goto L_0x03e4
            r23 = r0
            goto L_0x03e6
        L_0x03e4:
            r23 = r77
        L_0x03e6:
            if (r17 == 0) goto L_0x03eb
            r17 = 0
            goto L_0x03ed
        L_0x03eb:
            r17 = r78
        L_0x03ed:
            if (r5 == 0) goto L_0x03f6
            androidx.compose.ui.text.input.VisualTransformation$Companion r5 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r5 = r5.getNone()
            goto L_0x03f8
        L_0x03f6:
            r5 = r79
        L_0x03f8:
            if (r20 == 0) goto L_0x0401
            androidx.compose.foundation.text.KeyboardOptions$Companion r20 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r20 = r20.getDefault()
            goto L_0x0403
        L_0x0401:
            r20 = r80
        L_0x0403:
            if (r22 == 0) goto L_0x040c
            androidx.compose.foundation.text.KeyboardActions$Companion r22 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r22 = r22.getDefault()
            goto L_0x040e
        L_0x040c:
            r22 = r81
        L_0x040e:
            if (r25 == 0) goto L_0x0413
            r24 = 0
            goto L_0x0415
        L_0x0413:
            r24 = r82
        L_0x0415:
            r25 = 262144(0x40000, float:3.67342E-40)
            r25 = r3 & r25
            if (r25 == 0) goto L_0x0429
            if (r24 == 0) goto L_0x0420
            r25 = 1
            goto L_0x0423
        L_0x0420:
            r25 = 2147483647(0x7fffffff, float:NaN)
        L_0x0423:
            r26 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r18 = r18 & r26
            goto L_0x042b
        L_0x0429:
            r25 = r83
        L_0x042b:
            if (r29 == 0) goto L_0x0430
            r26 = 1
            goto L_0x0432
        L_0x0430:
            r26 = r84
        L_0x0432:
            if (r32 == 0) goto L_0x0435
            goto L_0x0437
        L_0x0435:
            r0 = r85
        L_0x0437:
            r27 = 2097152(0x200000, float:2.938736E-39)
            r27 = r3 & r27
            r2 = 6
            if (r27 == 0) goto L_0x0445
            androidx.compose.material3.TextFieldDefaults r1 = androidx.compose.material3.TextFieldDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r1 = r1.getShape(r4, r2)
            goto L_0x0447
        L_0x0445:
            r1 = r86
        L_0x0447:
            r28 = r3 & r28
            r67 = r0
            if (r28 == 0) goto L_0x047b
            androidx.compose.material3.TextFieldDefaults r0 = androidx.compose.material3.TextFieldDefaults.INSTANCE
            androidx.compose.material3.TextFieldColors r0 = r0.colors(r4, r2)
            r31 = r1
            r27 = r16
            r2 = r18
            r28 = r19
            r29 = r21
            r18 = r22
            r30 = r23
            r19 = r24
            r21 = r26
            r1 = r67
            r22 = r5
            r5 = r8
            r24 = r10
            r26 = r11
            r10 = r17
            r17 = r20
            r20 = r25
            r11 = r0
            r0 = r9
            r25 = r14
            r9 = r15
            goto L_0x0387
        L_0x047b:
            r31 = r1
            r0 = r9
            r9 = r15
            r27 = r16
            r2 = r18
            r28 = r19
            r29 = r21
            r18 = r22
            r30 = r23
            r19 = r24
            r21 = r26
            r1 = r67
            r22 = r5
            r15 = r7
            r5 = r8
            r24 = r10
            r26 = r11
            r10 = r17
            r17 = r20
            r20 = r25
            r11 = r87
            r25 = r14
            r14 = r6
            goto L_0x0389
        L_0x04a6:
            r4.endDefaults()
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x04b7
            r7 = -1268528240(0xffffffffb463cb90, float:-2.1215078E-7)
            java.lang.String r8 = "androidx.compose.material3.TextField (TextField.kt:375)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r5, r2, r8)
        L_0x04b7:
            r2 = -508241210(0xffffffffe1b4dac6, float:-4.1702228E20)
            r4.startReplaceGroup(r2)
            java.lang.String r2 = "377@20083L39"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r2)
            if (r1 != 0) goto L_0x04e7
            r2 = -508240559(0xffffffffe1b4dd51, float:-4.170452E20)
            java.lang.String r5 = "CC(remember):TextField.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r2, r5)
            java.lang.Object r2 = r4.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r2 != r5) goto L_0x04df
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r4.updateRememberedValue(r2)
        L_0x04df:
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = (androidx.compose.foundation.interaction.MutableInteractionSource) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r23 = r2
            goto L_0x04e9
        L_0x04e7:
            r23 = r1
        L_0x04e9:
            r4.endReplaceGroup()
            r2 = -508235100(0xffffffffe1b4f2a4, float:-4.1723725E20)
            r4.startReplaceGroup(r2)
            java.lang.String r2 = "*381@20307L25"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r2)
            long r7 = r0.m6594getColor0d7_KjU()
            r32 = 16
            int r2 = (r7 > r32 ? 1 : (r7 == r32 ? 0 : -1))
            if (r2 == 0) goto L_0x0502
            goto L_0x0518
        L_0x0502:
            r2 = r23
            androidx.compose.foundation.interaction.InteractionSource r2 = (androidx.compose.foundation.interaction.InteractionSource) r2
            androidx.compose.runtime.State r2 = androidx.compose.foundation.interaction.FocusInteractionKt.collectIsFocusedAsState(r2, r4, r6)
            java.lang.Object r2 = r2.getValue()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            long r7 = r11.m2659textColorXeAY9LY$material3_release(r14, r10, r2)
        L_0x0518:
            r33 = r7
            r4.endReplaceGroup()
            androidx.compose.ui.text.TextStyle r32 = new androidx.compose.ui.text.TextStyle
            r62 = 16777214(0xfffffe, float:2.3509884E-38)
            r63 = 0
            r35 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r49 = 0
            r50 = 0
            r51 = 0
            r52 = 0
            r53 = 0
            r54 = 0
            r56 = 0
            r57 = 0
            r58 = 0
            r59 = 0
            r60 = 0
            r61 = 0
            r32.<init>((long) r33, (long) r35, (androidx.compose.ui.text.font.FontWeight) r37, (androidx.compose.ui.text.font.FontStyle) r38, (androidx.compose.ui.text.font.FontSynthesis) r39, (androidx.compose.ui.text.font.FontFamily) r40, (java.lang.String) r41, (long) r42, (androidx.compose.ui.text.style.BaselineShift) r44, (androidx.compose.ui.text.style.TextGeometricTransform) r45, (androidx.compose.ui.text.intl.LocaleList) r46, (long) r47, (androidx.compose.ui.text.style.TextDecoration) r49, (androidx.compose.ui.graphics.Shadow) r50, (androidx.compose.ui.graphics.drawscope.DrawStyle) r51, (int) r52, (int) r53, (long) r54, (androidx.compose.ui.text.style.TextIndent) r56, (androidx.compose.ui.text.PlatformTextStyle) r57, (androidx.compose.ui.text.style.LineHeightStyle) r58, (int) r59, (int) r60, (androidx.compose.ui.text.style.TextMotion) r61, (int) r62, (kotlin.jvm.internal.DefaultConstructorMarker) r63)
            r2 = r32
            androidx.compose.ui.text.TextStyle r16 = r0.merge((androidx.compose.ui.text.TextStyle) r2)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.foundation.text.selection.TextSelectionColors r5 = r11.getTextSelectionColors()
            androidx.compose.runtime.ProvidedValue r2 = r2.provides(r5)
            androidx.compose.material3.TextFieldKt$TextField$3 r8 = new androidx.compose.material3.TextFieldKt$TextField$3
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            r5 = 54
            r6 = -1163788208(0xffffffffbaa20050, float:-0.0012359712)
            r7 = 1
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r6, r7, r8, r4, r5)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            int r6 = androidx.compose.runtime.ProvidedValue.$stable
            r6 = r6 | 48
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>) r2, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r5, (androidx.compose.runtime.Composer) r4, (int) r6)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0588
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0588:
            r6 = r0
            r0 = r4
            r23 = r11
            r4 = r14
            r5 = r15
            r16 = r17
            r17 = r18
            r18 = r19
            r19 = r20
            r20 = r21
            r15 = r22
            r7 = r24
            r8 = r25
            r11 = r28
            r12 = r29
            r13 = r30
            r22 = r31
            r21 = r1
            r14 = r10
            r10 = r27
        L_0x05ab:
            androidx.compose.runtime.ScopeUpdateScope r0 = r0.endRestartGroup()
            if (r0 == 0) goto L_0x05cf
            r1 = r0
            androidx.compose.material3.TextFieldKt$TextField$4 r0 = new androidx.compose.material3.TextFieldKt$TextField$4
            r2 = r66
            r24 = r89
            r25 = r90
            r64 = r1
            r27 = r3
            r3 = r9
            r9 = r26
            r1 = r65
            r26 = r91
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r64
            r1.updateScope(r0)
        L_0x05cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldKt.TextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    public static final void TextFieldLayout(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, boolean z, float f, Function2<? super Composer, ? super Integer, Unit> function27, Function2<? super Composer, ? super Integer, Unit> function28, PaddingValues paddingValues, Composer composer, int i, int i2) {
        int i3;
        int i4;
        PaddingValues paddingValues2;
        Function2<? super Composer, ? super Integer, Unit> function29;
        Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function32;
        Function2<? super Composer, ? super Integer, Unit> function210;
        int i5;
        float f2;
        float f3;
        Modifier modifier2 = modifier;
        Function2<? super Composer, ? super Integer, Unit> function211 = function2;
        Function2<? super Composer, ? super Integer, Unit> function212 = function22;
        Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function33 = function3;
        Function2<? super Composer, ? super Integer, Unit> function213 = function23;
        Function2<? super Composer, ? super Integer, Unit> function214 = function24;
        Function2<? super Composer, ? super Integer, Unit> function215 = function25;
        Function2<? super Composer, ? super Integer, Unit> function216 = function26;
        boolean z2 = z;
        float f4 = f;
        Function2<? super Composer, ? super Integer, Unit> function217 = function27;
        Function2<? super Composer, ? super Integer, Unit> function218 = function28;
        int i6 = i;
        int i7 = i2;
        Composer startRestartGroup = composer.startRestartGroup(-1830307184);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextFieldLayout)P(4,11,2,6,3,12,7,9,8!2,10)455@23228L147,458@23423L7,459@23435L4118:TextField.kt#uh7d8r");
        int i8 = 4;
        if ((i6 & 6) == 0) {
            i3 = i6 | (startRestartGroup.changed((Object) modifier2) ? 4 : 2);
        } else {
            i3 = i6;
        }
        int i9 = 16;
        if ((i6 & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function211) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function212) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function33) ? 2048 : 1024;
        }
        if ((i6 & 24576) == 0) {
            i3 |= startRestartGroup.changedInstance(function213) ? 16384 : 8192;
        }
        if ((196608 & i6) == 0) {
            i3 |= startRestartGroup.changedInstance(function214) ? 131072 : 65536;
        }
        if ((1572864 & i6) == 0) {
            i3 |= startRestartGroup.changedInstance(function215) ? 1048576 : 524288;
        }
        if ((12582912 & i6) == 0) {
            i3 |= startRestartGroup.changedInstance(function216) ? 8388608 : 4194304;
        }
        if ((100663296 & i6) == 0) {
            i3 |= startRestartGroup.changed(z2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((805306368 & i6) == 0) {
            i3 |= startRestartGroup.changed(f4) ? 536870912 : 268435456;
        }
        int i10 = i3;
        if ((i7 & 6) == 0) {
            if (!startRestartGroup.changedInstance(function217)) {
                i8 = 2;
            }
            i4 = i7 | i8;
        } else {
            i4 = i7;
        }
        if ((i7 & 48) == 0) {
            if (startRestartGroup.changedInstance(function218)) {
                i9 = 32;
            }
            i4 |= i9;
        }
        if ((i7 & 384) == 0) {
            paddingValues2 = paddingValues;
            i4 |= startRestartGroup.changed((Object) paddingValues2) ? 256 : 128;
        } else {
            paddingValues2 = paddingValues;
        }
        int i11 = i4;
        if ((i10 & 306783379) == 306783378 && (i11 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            function210 = function2;
            function29 = function28;
            function32 = function33;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1830307184, i10, i11, "androidx.compose.material3.TextFieldLayout (TextField.kt:453)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1052646361, "CC(remember):TextField.kt#9igjgp");
            int i12 = i10;
            boolean z3 = ((i12 & 1879048192) == 536870912) | ((234881024 & i10) == 67108864) | ((i11 & 896) == 256);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new TextFieldMeasurePolicy(z2, f4, paddingValues2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            TextFieldMeasurePolicy textFieldMeasurePolicy = (TextFieldMeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier2);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            int i13 = i11;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r1 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r1, textFieldMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r1, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r1.getInserting() || !Intrinsics.areEqual(r1.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r1.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r1.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r1, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1362557328, "C465@23754L11,550@26868L187:TextField.kt#uh7d8r");
            function217.invoke(startRestartGroup, Integer.valueOf(i13 & 14));
            startRestartGroup.startReplaceGroup(1341517187);
            ComposerKt.sourceInformation(startRestartGroup, "468@23818L219");
            if (function213 != null) {
                Modifier then = LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.LeadingId).then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment center = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, then);
                int i14 = currentCompositeKeyHash2;
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                Composer r10 = Updater.m3675constructorimpl(startRestartGroup);
                Updater.m3682setimpl(r10, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3682setimpl(r10, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r10.getInserting() || !Intrinsics.areEqual(r10.rememberedValue(), (Object) Integer.valueOf(i14))) {
                    r10.updateRememberedValue(Integer.valueOf(i14));
                    r10.apply(Integer.valueOf(i14), setCompositeKeyHash2);
                }
                Updater.m3682setimpl(r10, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -948431736, "C472@24010L9:TextField.kt#uh7d8r");
                function213.invoke(startRestartGroup, Integer.valueOf((i12 >> 12) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1341526310);
            ComposerKt.sourceInformation(startRestartGroup, "476@24104L221");
            if (function214 != null) {
                Modifier then2 = LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.TrailingId).then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment center2 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, then2);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                Composer r5 = Updater.m3675constructorimpl(startRestartGroup);
                Updater.m3682setimpl(r5, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3682setimpl(r5, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r5.getInserting() || !Intrinsics.areEqual(r5.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash3))) {
                    r5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    r5.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m3682setimpl(r5, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -948147001, "C480@24297L10:TextField.kt#uh7d8r");
                function214.invoke(startRestartGroup, Integer.valueOf((i12 >> 15) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            }
            startRestartGroup.endReplaceGroup();
            float calculateStartPadding = PaddingKt.calculateStartPadding(paddingValues2, layoutDirection);
            float calculateEndPadding = PaddingKt.calculateEndPadding(paddingValues2, layoutDirection);
            if (function23 != null) {
                i5 = 0;
                calculateStartPadding = Dp.m7111constructorimpl(RangesKt.coerceAtLeast(Dp.m7111constructorimpl(calculateStartPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m7111constructorimpl((float) 0)));
            } else {
                i5 = 0;
            }
            float f5 = calculateStartPadding;
            if (function214 != null) {
                calculateEndPadding = Dp.m7111constructorimpl(RangesKt.coerceAtLeast(Dp.m7111constructorimpl(calculateEndPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m7111constructorimpl((float) i5)));
            }
            startRestartGroup.startReplaceGroup(1341556924);
            ComposerKt.sourceInformation(startRestartGroup, "501@25056L309");
            if (function215 != null) {
                Modifier r102 = PaddingKt.m779paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m833heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.PrefixId), TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null), f5, 0.0f, TextFieldImplKt.getPrefixSuffixTextPadding(), 0.0f, 10, (Object) null);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, r102);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor4);
                } else {
                    startRestartGroup.useNode();
                }
                Composer r2 = Updater.m3675constructorimpl(startRestartGroup);
                Updater.m3682setimpl(r2, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3682setimpl(r2, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r2.getInserting() || !Intrinsics.areEqual(r2.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash4))) {
                    r2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    r2.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m3682setimpl(r2, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -947113399, "C507@25339L8:TextField.kt#uh7d8r");
                function215.invoke(startRestartGroup, Integer.valueOf((i12 >> 18) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1341568890);
            ComposerKt.sourceInformation(startRestartGroup, "511@25430L307");
            if (function216 != null) {
                float f6 = calculateEndPadding;
                Modifier r0 = PaddingKt.m779paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m833heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.SuffixId), TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null), TextFieldImplKt.getPrefixSuffixTextPadding(), 0.0f, f6, 0.0f, 10, (Object) null);
                f2 = f6;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(startRestartGroup, r0);
                Function0<ComposeUiNode> constructor5 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor5);
                } else {
                    startRestartGroup.useNode();
                }
                Composer r103 = Updater.m3675constructorimpl(startRestartGroup);
                Updater.m3682setimpl(r103, maybeCachedBoxMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3682setimpl(r103, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r103.getInserting() || !Intrinsics.areEqual(r103.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash5))) {
                    r103.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                    r103.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                }
                Updater.m3682setimpl(r103, materializeModifier5, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -946744375, "C517@25711L8:TextField.kt#uh7d8r");
                function216.invoke(startRestartGroup, Integer.valueOf((i12 >> 21) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            } else {
                f2 = calculateEndPadding;
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1341581092);
            ComposerKt.sourceInformation(startRestartGroup, "522@25802L574");
            if (function22 != null) {
                f4 = f;
                Modifier r02 = PaddingKt.m779paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m833heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.LabelId), DpKt.m7154lerpMdfbLM(TextFieldImplKt.getMinTextLineHeight(), TextFieldImplKt.getMinFocusedLabelLineHeight(), f4), 0.0f, 2, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null), f5, 0.0f, f2, 0.0f, 10, (Object) null);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap6 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier6 = ComposedModifierKt.materializeModifier(startRestartGroup, r02);
                Function0<ComposeUiNode> constructor6 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor6);
                } else {
                    startRestartGroup.useNode();
                }
                Composer r11 = Updater.m3675constructorimpl(startRestartGroup);
                Updater.m3682setimpl(r11, maybeCachedBoxMeasurePolicy5, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3682setimpl(r11, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r11.getInserting() || !Intrinsics.areEqual(r11.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash6))) {
                    r11.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                    r11.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
                }
                Updater.m3682setimpl(r11, materializeModifier6, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope5 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -946109526, "C535@26351L7:TextField.kt#uh7d8r");
                function22.invoke(startRestartGroup, Integer.valueOf((i12 >> 6) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            } else {
                Function2<? super Composer, ? super Integer, Unit> function219 = function22;
                f4 = f;
            }
            startRestartGroup.endReplaceGroup();
            Modifier wrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.m833heightInVpY3zN4$default(Modifier.Companion, TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null);
            if (function215 != null) {
                f5 = Dp.m7111constructorimpl((float) 0);
            }
            float f7 = f5;
            if (function216 == null) {
                f3 = f2;
            } else {
                f3 = Dp.m7111constructorimpl((float) 0);
            }
            Modifier r03 = PaddingKt.m779paddingqDBjuR0$default(wrapContentHeight$default, f7, 0.0f, f3, 0.0f, 10, (Object) null);
            startRestartGroup.startReplaceGroup(1341611627);
            ComposerKt.sourceInformation(startRestartGroup, "548@26778L63");
            if (function3 != null) {
                function32 = function3;
                function32.invoke(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.PlaceholderId).then(r03), startRestartGroup, Integer.valueOf((i12 >> 6) & 112));
            } else {
                function32 = function3;
            }
            startRestartGroup.endReplaceGroup();
            Modifier then3 = LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.TextFieldId).then(r03);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap7 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier7 = ComposedModifierKt.materializeModifier(startRestartGroup, then3);
            Function0<ComposeUiNode> constructor7 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor7);
            } else {
                startRestartGroup.useNode();
            }
            Composer r22 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r22, maybeCachedBoxMeasurePolicy6, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r22, currentCompositionLocalMap7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r22.getInserting() || !Intrinsics.areEqual(r22.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash7))) {
                r22.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash7));
                r22.apply(Integer.valueOf(currentCompositeKeyHash7), setCompositeKeyHash7);
            }
            Updater.m3682setimpl(r22, materializeModifier7, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope6 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -945435834, "C554@27030L11:TextField.kt#uh7d8r");
            function210 = function2;
            function210.invoke(startRestartGroup, Integer.valueOf((i12 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.startReplaceGroup(1341622624);
            ComposerKt.sourceInformation(startRestartGroup, "559@27167L317");
            if (function28 != null) {
                Modifier padding = PaddingKt.padding(SizeKt.wrapContentHeight$default(SizeKt.m833heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.SupportingId), TextFieldImplKt.getMinSupportingTextLineHeight(), 0.0f, 2, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null), TextFieldDefaults.m2667supportingTextPaddinga9UjIt4$material3_release$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, (Object) null));
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash8 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap8 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier8 = ComposedModifierKt.materializeModifier(startRestartGroup, padding);
                Function0<ComposeUiNode> constructor8 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor8);
                } else {
                    startRestartGroup.useNode();
                }
                Composer r4 = Updater.m3675constructorimpl(startRestartGroup);
                Updater.m3682setimpl(r4, maybeCachedBoxMeasurePolicy7, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3682setimpl(r4, currentCompositionLocalMap8, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r4.getInserting() || !Intrinsics.areEqual(r4.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash8))) {
                    r4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash8));
                    r4.apply(Integer.valueOf(currentCompositeKeyHash8), setCompositeKeyHash8);
                }
                Updater.m3682setimpl(r4, materializeModifier8, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope7 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -945015195, "C565@27454L12:TextField.kt#uh7d8r");
                function29 = function28;
                function29.invoke(startRestartGroup, Integer.valueOf((i13 >> 3) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            } else {
                function29 = function28;
            }
            startRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextFieldKt$TextFieldLayout$2(modifier, function210, function22, function32, function23, function24, function215, function216, z, f4, function27, function29, paddingValues2, i, i2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateWidth-yeHjK3Y  reason: not valid java name */
    public static final int m2689calculateWidthyeHjK3Y(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j) {
        int i8 = i3 + i4;
        return Math.max(i + Math.max(i5 + i8, Math.max(i7 + i8, i6)) + i2, Constraints.m7054getMinWidthimpl(j));
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateHeight-mKXJcVc  reason: not valid java name */
    public static final int m2688calculateHeightmKXJcVc(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f, long j, float f2, PaddingValues paddingValues) {
        boolean z = i2 > 0;
        float r15 = Dp.m7111constructorimpl(paddingValues.m792calculateTopPaddingD9Ej5fM() + paddingValues.m789calculateBottomPaddingD9Ej5fM()) * f2;
        if (z) {
            r15 = MathHelpersKt.lerp(Dp.m7111constructorimpl(TextFieldImplKt.getTextFieldPadding() * ((float) 2)) * f2, r15, f);
        }
        return Math.max(Constraints.m7053getMinHeightimpl(j), Math.max(i3, Math.max(i4, MathKt.roundToInt(r15 + ((float) MathHelpersKt.lerp(0, i2, f)) + ((float) ComparisonsKt.maxOf(i, i7, i5, i6, MathHelpersKt.lerp(i2, 0, f)))))) + i8);
    }

    /* access modifiers changed from: private */
    public static final void placeWithLabel(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, Placeable placeable8, Placeable placeable9, boolean z, int i3, int i4, float f, float f2) {
        int i5;
        Placeable.PlacementScope.m5890place70tqf50$default(placementScope, placeable8, IntOffset.Companion.m7251getZeronOccac(), 0.0f, 2, (Object) null);
        int heightOrZero = i2 - TextFieldImplKt.heightOrZero(placeable9);
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, 0, Alignment.Companion.getCenterVertically().align(placeable4.getHeight(), heightOrZero), 0.0f, 4, (Object) null);
        }
        if (placeable2 != null) {
            if (z) {
                i5 = Alignment.Companion.getCenterVertically().align(placeable2.getHeight(), heightOrZero);
            } else {
                i5 = MathKt.roundToInt(TextFieldImplKt.getTextFieldPadding() * f2);
            }
            Placeable.PlacementScope placementScope2 = placementScope;
            Placeable placeable10 = placeable2;
            Placeable.PlacementScope.placeRelative$default(placementScope2, placeable10, TextFieldImplKt.widthOrZero(placeable4), i5 - MathKt.roundToInt(((float) (i5 - i3)) * f), 0.0f, 4, (Object) null);
        }
        if (placeable6 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable6, TextFieldImplKt.widthOrZero(placeable4), i4, 0.0f, 4, (Object) null);
        }
        int widthOrZero = TextFieldImplKt.widthOrZero(placeable4) + TextFieldImplKt.widthOrZero(placeable6);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, widthOrZero, i4, 0.0f, 4, (Object) null);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, widthOrZero, i4, 0.0f, 4, (Object) null);
        }
        if (placeable7 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable7, (i - TextFieldImplKt.widthOrZero(placeable5)) - placeable7.getWidth(), i4, 0.0f, 4, (Object) null);
        }
        if (placeable5 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, i - placeable5.getWidth(), Alignment.Companion.getCenterVertically().align(placeable5.getHeight(), heightOrZero), 0.0f, 4, (Object) null);
        }
        if (placeable9 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable9, 0, heightOrZero, 0.0f, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void placeWithoutLabel(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, Placeable placeable8, boolean z, float f, PaddingValues paddingValues) {
        Placeable placeable9 = placeable2;
        Placeable placeable10 = placeable5;
        Placeable placeable11 = placeable6;
        boolean z2 = z;
        Placeable.PlacementScope.m5890place70tqf50$default(placementScope, placeable7, IntOffset.Companion.m7251getZeronOccac(), 0.0f, 2, (Object) null);
        int heightOrZero = i2 - TextFieldImplKt.heightOrZero(placeable8);
        int roundToInt = MathKt.roundToInt(paddingValues.m792calculateTopPaddingD9Ej5fM() * f);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, 0, Alignment.Companion.getCenterVertically().align(placeable3.getHeight(), heightOrZero), 0.0f, 4, (Object) null);
        }
        if (placeable10 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable10, TextFieldImplKt.widthOrZero(placeable3), placeWithoutLabel$calculateVerticalPosition(z2, heightOrZero, roundToInt, placeable10), 0.0f, 4, (Object) null);
        }
        Placeable placeable12 = placeable;
        int widthOrZero = TextFieldImplKt.widthOrZero(placeable5) + TextFieldImplKt.widthOrZero(placeable3);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable12, widthOrZero, placeWithoutLabel$calculateVerticalPosition(z2, heightOrZero, roundToInt, placeable12), 0.0f, 4, (Object) null);
        int i3 = widthOrZero;
        if (placeable9 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable9, i3, placeWithoutLabel$calculateVerticalPosition(z2, heightOrZero, roundToInt, placeable9), 0.0f, 4, (Object) null);
        }
        if (placeable11 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable11, (i - TextFieldImplKt.widthOrZero(placeable4)) - placeable11.getWidth(), placeWithoutLabel$calculateVerticalPosition(z2, heightOrZero, roundToInt, placeable11), 0.0f, 4, (Object) null);
        }
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, i - placeable4.getWidth(), Alignment.Companion.getCenterVertically().align(placeable4.getHeight(), heightOrZero), 0.0f, 4, (Object) null);
        }
        if (placeable8 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable8, 0, heightOrZero, 0.0f, 4, (Object) null);
        }
    }

    private static final int placeWithoutLabel$calculateVerticalPosition(boolean z, int i, int i2, Placeable placeable) {
        return z ? Alignment.Companion.getCenterVertically().align(placeable.getHeight(), i) : i2;
    }

    public static final Modifier drawIndicatorLine(Modifier modifier, State<BorderStroke> state) {
        return DrawModifierKt.drawWithContent(modifier, new TextFieldKt$drawIndicatorLine$1(state));
    }

    public static final float getTextFieldWithLabelVerticalPadding() {
        return TextFieldWithLabelVerticalPadding;
    }
}
