package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.tokens.TypeScaleTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
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
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000°\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aØ\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001e\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020'2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020.H\u0007¢\u0006\u0002\u0010/\u001aØ\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u0002002\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001e\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020'2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020.H\u0007¢\u0006\u0002\u00101\u001a\u0002\u00102\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0011\u00103\u001a\r\u0012\u0004\u0012\u00020\t0\u0016¢\u0006\u0002\b\u00172\u0019\u0010\u0018\u001a\u0015\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\r¢\u0006\u0002\b\u00172\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u00104\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u00105\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0006\u0010%\u001a\u00020\u00112\u0006\u00106\u001a\u0002072\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\t0\r2\u0011\u0010:\u001a\r\u0012\u0004\u0012\u00020\t0\u0016¢\u0006\u0002\b\u00172\u0013\u0010;\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0006\u0010<\u001a\u00020=H\u0001¢\u0006\u0002\u0010>\u001ar\u0010?\u001a\u00020'2\u0006\u0010@\u001a\u00020'2\u0006\u0010A\u001a\u00020'2\u0006\u0010B\u001a\u00020'2\u0006\u0010C\u001a\u00020'2\u0006\u0010D\u001a\u00020'2\u0006\u0010E\u001a\u00020'2\u0006\u0010F\u001a\u00020'2\u0006\u0010G\u001a\u00020'2\u0006\u00106\u001a\u0002072\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u0002072\u0006\u0010<\u001a\u00020=H\u0002ø\u0001\u0000¢\u0006\u0004\bK\u0010L\u001aj\u0010M\u001a\u00020'2\u0006\u0010N\u001a\u00020'2\u0006\u0010O\u001a\u00020'2\u0006\u0010P\u001a\u00020'2\u0006\u0010Q\u001a\u00020'2\u0006\u0010R\u001a\u00020'2\u0006\u0010S\u001a\u00020'2\u0006\u0010T\u001a\u00020'2\u0006\u00106\u001a\u0002072\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u0002072\u0006\u0010<\u001a\u00020=H\u0002ø\u0001\u0000¢\u0006\u0004\bU\u0010V\u001a\"\u0010W\u001a\u00020\u000f*\u00020\u000f2\f\u0010X\u001a\b\u0012\u0004\u0012\u0002090\u00162\u0006\u0010<\u001a\u00020=H\u0000\u001a\u0001\u0010Y\u001a\u00020\t*\u00020Z2\u0006\u0010[\u001a\u00020'2\u0006\u0010\\\u001a\u00020'2\b\u0010]\u001a\u0004\u0018\u00010^2\b\u0010_\u001a\u0004\u0018\u00010^2\b\u0010`\u001a\u0004\u0018\u00010^2\b\u0010a\u001a\u0004\u0018\u00010^2\u0006\u0010b\u001a\u00020^2\b\u0010c\u001a\u0004\u0018\u00010^2\b\u0010d\u001a\u0004\u0018\u00010^2\u0006\u0010e\u001a\u00020^2\b\u0010f\u001a\u0004\u0018\u00010^2\u0006\u00106\u001a\u0002072\u0006\u0010%\u001a\u00020\u00112\u0006\u0010J\u001a\u0002072\u0006\u0010g\u001a\u00020h2\u0006\u0010<\u001a\u00020=H\u0002\u001a\u0014\u0010i\u001a\u00020'*\u00020'2\u0006\u0010j\u001a\u00020'H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006k"}, d2 = {"OutlinedTextFieldInnerPadding", "Landroidx/compose/ui/unit/Dp;", "F", "OutlinedTextFieldTopPadding", "Landroidx/compose/ui/unit/TextUnit;", "getOutlinedTextFieldTopPadding", "()J", "J", "OutlinedTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "minLines", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "OutlinedTextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "onLabelMeasured", "Landroidx/compose/ui/geometry/Size;", "container", "supporting", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "leadingHeight", "trailingHeight", "prefixHeight", "suffixHeight", "textFieldHeight", "labelHeight", "placeholderHeight", "supportingHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-mKXJcVc", "(IIIIIIIIFJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingPlaceableWidth", "trailingPlaceableWidth", "prefixPlaceableWidth", "suffixPlaceableWidth", "textFieldPlaceableWidth", "labelPlaceableWidth", "placeholderPlaceableWidth", "calculateWidth-DHJA7U0", "(IIIIIIIFJFLandroidx/compose/foundation/layout/PaddingValues;)I", "outlineCutout", "labelSize", "place", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "totalHeight", "width", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "prefixPlaceable", "suffixPlaceable", "textFieldPlaceable", "labelPlaceable", "placeholderPlaceable", "containerPlaceable", "supportingPlaceable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "substractConstraintSafely", "from", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: OutlinedTextField.kt */
public final class OutlinedTextFieldKt {
    /* access modifiers changed from: private */
    public static final float OutlinedTextFieldInnerPadding = Dp.m7111constructorimpl((float) 4);
    private static final long OutlinedTextFieldTopPadding;

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
    /* JADX WARNING: Removed duplicated region for block: B:348:0x05be  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:350:? A[RETURN, SYNTHETIC] */
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
    public static final void OutlinedTextField(java.lang.String r68, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r69, androidx.compose.ui.Modifier r70, boolean r71, boolean r72, androidx.compose.ui.text.TextStyle r73, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r74, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r75, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r76, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r77, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r78, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r79, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r80, boolean r81, androidx.compose.ui.text.input.VisualTransformation r82, androidx.compose.foundation.text.KeyboardOptions r83, androidx.compose.foundation.text.KeyboardActions r84, boolean r85, int r86, int r87, androidx.compose.foundation.interaction.MutableInteractionSource r88, androidx.compose.ui.graphics.Shape r89, androidx.compose.material3.TextFieldColors r90, androidx.compose.runtime.Composer r91, int r92, int r93, int r94, int r95) {
        /*
            r0 = r92
            r1 = r93
            r2 = r94
            r3 = r95
            r4 = -1922450045(0xffffffff8d69bd83, float:-7.2026785E-31)
            r5 = r91
            androidx.compose.runtime.Composer r4 = r5.startRestartGroup(r4)
            java.lang.String r5 = "C(OutlinedTextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)175@9821L7,191@10625L5,192@10688L8,204@11208L7,206@11308L2853,206@11221L2940:OutlinedTextField.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r5)
            r5 = r3 & 1
            if (r5 == 0) goto L_0x001f
            r5 = r0 | 6
            r14 = r68
            goto L_0x0031
        L_0x001f:
            r5 = r0 & 6
            r14 = r68
            if (r5 != 0) goto L_0x0030
            boolean r5 = r4.changed((java.lang.Object) r14)
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
            r15 = r69
            goto L_0x004c
        L_0x003a:
            r8 = r0 & 48
            r15 = r69
            if (r8 != 0) goto L_0x004c
            boolean r8 = r4.changedInstance(r15)
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
            r13 = r0 & 384(0x180, float:5.38E-43)
            if (r13 != 0) goto L_0x0067
            r13 = r70
            boolean r16 = r4.changed((java.lang.Object) r13)
            if (r16 == 0) goto L_0x0062
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r5 = r5 | r16
            goto L_0x0069
        L_0x0067:
            r13 = r70
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
            r6 = r71
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
            r6 = r71
        L_0x008a:
            r19 = r3 & 16
            r20 = 8192(0x2000, float:1.14794E-41)
            if (r19 == 0) goto L_0x0093
            r5 = r5 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a7
        L_0x0093:
            r7 = r0 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x00a7
            r7 = r72
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
            r7 = r72
        L_0x00a9:
            r22 = 196608(0x30000, float:2.75506E-40)
            r23 = r0 & r22
            if (r23 != 0) goto L_0x00c3
            r23 = r3 & 32
            r9 = r73
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
            r9 = r73
        L_0x00c5:
            r24 = r3 & 64
            r25 = 1572864(0x180000, float:2.204052E-39)
            if (r24 == 0) goto L_0x00d0
            r5 = r5 | r25
            r10 = r74
            goto L_0x00e3
        L_0x00d0:
            r26 = r0 & r25
            r10 = r74
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
            r12 = r75
            goto L_0x0103
        L_0x00f0:
            r30 = r0 & r29
            r12 = r75
            if (r30 != 0) goto L_0x0103
            boolean r31 = r4.changedInstance(r12)
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
            r31 = r92 & r31
            if (r31 != 0) goto L_0x0122
            r31 = r0
            r0 = r76
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
            r0 = r76
        L_0x0126:
            r0 = r3 & 512(0x200, float:7.175E-43)
            r32 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x012f
            r5 = r5 | r32
            goto L_0x0145
        L_0x012f:
            r33 = r92 & r32
            if (r33 != 0) goto L_0x0145
            r33 = r0
            r0 = r77
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
            r0 = r77
        L_0x0149:
            r0 = r3 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0156
            r34 = r1 | 6
            r35 = r34
            r34 = r0
            r0 = r78
            goto L_0x0172
        L_0x0156:
            r34 = r1 & 6
            if (r34 != 0) goto L_0x016c
            r34 = r0
            r0 = r78
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
            r0 = r78
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
            r0 = r79
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
            r0 = r79
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
            r0 = r80
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
            r0 = r80
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
            r0 = r81
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
            r0 = r81
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
            r0 = r82
            boolean r38 = r4.changed((java.lang.Object) r0)
            if (r38 == 0) goto L_0x01f8
            r20 = 16384(0x4000, float:2.2959E-41)
        L_0x01f8:
            r18 = r18 | r20
            goto L_0x01fd
        L_0x01fb:
            r0 = r82
        L_0x01fd:
            r20 = 32768(0x8000, float:4.5918E-41)
            r20 = r3 & r20
            if (r20 == 0) goto L_0x0209
            r18 = r18 | r22
            r0 = r83
            goto L_0x021c
        L_0x0209:
            r22 = r1 & r22
            r0 = r83
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
            r0 = r84
            goto L_0x023a
        L_0x0227:
            r25 = r1 & r25
            r0 = r84
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
            r0 = r85
            goto L_0x0258
        L_0x0245:
            r29 = r1 & r29
            r0 = r85
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
            r0 = r86
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
            r0 = r86
        L_0x0276:
            r29 = 524288(0x80000, float:7.34684E-40)
            r29 = r3 & r29
            if (r29 == 0) goto L_0x0281
            r18 = r18 | r32
            r0 = r87
            goto L_0x0294
        L_0x0281:
            r32 = r1 & r32
            r0 = r87
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
            r0 = r88
            goto L_0x02b5
        L_0x029f:
            r38 = r2 & 6
            r0 = r88
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
            r0 = r89
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
            r0 = r89
        L_0x02d1:
            r0 = r2 & 384(0x180, float:5.38E-43)
            if (r0 != 0) goto L_0x02eb
            r0 = r3 & r28
            if (r0 != 0) goto L_0x02e4
            r0 = r90
            boolean r23 = r4.changed((java.lang.Object) r0)
            if (r23 == 0) goto L_0x02e6
            r27 = 256(0x100, float:3.59E-43)
            goto L_0x02e8
        L_0x02e4:
            r0 = r90
        L_0x02e6:
            r27 = 128(0x80, float:1.794E-43)
        L_0x02e8:
            r21 = r21 | r27
            goto L_0x02ed
        L_0x02eb:
            r0 = r90
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
            r27 = r76
            r11 = r78
            r14 = r81
            r15 = r82
            r16 = r83
            r17 = r84
            r18 = r85
            r19 = r86
            r20 = r87
            r21 = r88
            r22 = r89
            r23 = r90
            r0 = r4
            r4 = r6
            r5 = r7
            r6 = r9
            r7 = r10
            r8 = r12
            r9 = r13
            r10 = r77
            r12 = r79
            r13 = r80
            goto L_0x05b8
        L_0x033a:
            r4.startDefaults()
            r0 = r92 & 1
            if (r0 == 0) goto L_0x038a
            boolean r0 = r4.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0348
            goto L_0x038a
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
            r27 = r76
            r28 = r77
            r29 = r78
            r30 = r79
            r31 = r80
            r24 = r82
            r19 = r83
            r20 = r84
            r21 = r85
            r22 = r86
            r23 = r87
            r1 = r88
            r32 = r89
            r17 = r7
            r0 = r9
            r26 = r12
            r9 = r13
            r2 = r18
            r7 = 0
            r12 = r81
            r13 = r90
            goto L_0x0498
        L_0x038a:
            if (r8 == 0) goto L_0x0391
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r13 = r0
        L_0x0391:
            if (r16 == 0) goto L_0x0394
            r6 = 1
        L_0x0394:
            if (r19 == 0) goto L_0x0397
            r7 = 0
        L_0x0397:
            r0 = r3 & 32
            if (r0 == 0) goto L_0x03b9
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
            goto L_0x03bb
        L_0x03b9:
            r8 = r35
        L_0x03bb:
            r0 = 0
            if (r24 == 0) goto L_0x03bf
            r10 = r0
        L_0x03bf:
            if (r11 == 0) goto L_0x03c2
            r12 = r0
        L_0x03c2:
            if (r31 == 0) goto L_0x03c6
            r11 = r0
            goto L_0x03c8
        L_0x03c6:
            r11 = r76
        L_0x03c8:
            if (r33 == 0) goto L_0x03cd
            r16 = r0
            goto L_0x03cf
        L_0x03cd:
            r16 = r77
        L_0x03cf:
            if (r34 == 0) goto L_0x03d4
            r19 = r0
            goto L_0x03d6
        L_0x03d4:
            r19 = r78
        L_0x03d6:
            if (r36 == 0) goto L_0x03db
            r21 = r0
            goto L_0x03dd
        L_0x03db:
            r21 = r79
        L_0x03dd:
            if (r37 == 0) goto L_0x03e2
            r23 = r0
            goto L_0x03e4
        L_0x03e2:
            r23 = r80
        L_0x03e4:
            if (r17 == 0) goto L_0x03e9
            r17 = 0
            goto L_0x03eb
        L_0x03e9:
            r17 = r81
        L_0x03eb:
            if (r5 == 0) goto L_0x03f4
            androidx.compose.ui.text.input.VisualTransformation$Companion r5 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r5 = r5.getNone()
            goto L_0x03f6
        L_0x03f4:
            r5 = r82
        L_0x03f6:
            if (r20 == 0) goto L_0x03ff
            androidx.compose.foundation.text.KeyboardOptions$Companion r20 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r20 = r20.getDefault()
            goto L_0x0401
        L_0x03ff:
            r20 = r83
        L_0x0401:
            if (r22 == 0) goto L_0x040a
            androidx.compose.foundation.text.KeyboardActions$Companion r22 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r22 = r22.getDefault()
            goto L_0x040c
        L_0x040a:
            r22 = r84
        L_0x040c:
            if (r25 == 0) goto L_0x0411
            r24 = 0
            goto L_0x0413
        L_0x0411:
            r24 = r85
        L_0x0413:
            r25 = 262144(0x40000, float:3.67342E-40)
            r25 = r3 & r25
            if (r25 == 0) goto L_0x0427
            if (r24 == 0) goto L_0x041e
            r25 = 1
            goto L_0x0421
        L_0x041e:
            r25 = 2147483647(0x7fffffff, float:NaN)
        L_0x0421:
            r26 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r18 = r18 & r26
            goto L_0x0429
        L_0x0427:
            r25 = r86
        L_0x0429:
            if (r29 == 0) goto L_0x042e
            r26 = 1
            goto L_0x0430
        L_0x042e:
            r26 = r87
        L_0x0430:
            if (r32 == 0) goto L_0x0433
            goto L_0x0435
        L_0x0433:
            r0 = r88
        L_0x0435:
            r27 = 2097152(0x200000, float:2.938736E-39)
            r27 = r3 & r27
            r2 = 6
            if (r27 == 0) goto L_0x0443
            androidx.compose.material3.OutlinedTextFieldDefaults r1 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r1 = r1.getShape(r4, r2)
            goto L_0x0445
        L_0x0443:
            r1 = r89
        L_0x0445:
            r28 = r3 & r28
            r70 = r0
            if (r28 == 0) goto L_0x0470
            androidx.compose.material3.OutlinedTextFieldDefaults r0 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            androidx.compose.material3.TextFieldColors r0 = r0.colors(r4, r2)
            r2 = r13
            r13 = r0
            r0 = r9
            r9 = r2
            r32 = r1
            r27 = r11
            r28 = r16
            r2 = r18
            r29 = r19
            r19 = r20
            r30 = r21
            r20 = r22
            r31 = r23
            r21 = r24
            r22 = r25
            r23 = r26
            r1 = r70
            goto L_0x048e
        L_0x0470:
            r32 = r1
            r0 = r9
            r27 = r11
            r9 = r13
            r28 = r16
            r2 = r18
            r29 = r19
            r19 = r20
            r30 = r21
            r20 = r22
            r31 = r23
            r21 = r24
            r22 = r25
            r23 = r26
            r1 = r70
            r13 = r90
        L_0x048e:
            r24 = r5
            r5 = r8
            r26 = r12
            r12 = r17
            r17 = r7
            r7 = 0
        L_0x0498:
            r4.endDefaults()
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x04a9
            r8 = -1922450045(0xffffffff8d69bd83, float:-7.2026785E-31)
            java.lang.String r11 = "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:193)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r8, r5, r2, r11)
        L_0x04a9:
            r2 = 30062948(0x1cab964, float:7.4469103E-38)
            r4.startReplaceGroup(r2)
            java.lang.String r2 = "195@10782L39"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r2)
            if (r1 != 0) goto L_0x04d9
            r2 = 30063599(0x1cabbef, float:7.447275E-38)
            java.lang.String r5 = "CC(remember):OutlinedTextField.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r2, r5)
            java.lang.Object r2 = r4.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r2 != r5) goto L_0x04d1
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r4.updateRememberedValue(r2)
        L_0x04d1:
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = (androidx.compose.foundation.interaction.MutableInteractionSource) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r25 = r2
            goto L_0x04db
        L_0x04d9:
            r25 = r1
        L_0x04db:
            r4.endReplaceGroup()
            r2 = 30069058(0x1cad142, float:7.450335E-38)
            r4.startReplaceGroup(r2)
            java.lang.String r2 = "*199@11006L25"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r2)
            long r33 = r0.m6594getColor0d7_KjU()
            r35 = 16
            int r2 = (r33 > r35 ? 1 : (r33 == r35 ? 0 : -1))
            if (r2 == 0) goto L_0x04f4
            goto L_0x050a
        L_0x04f4:
            r2 = r25
            androidx.compose.foundation.interaction.InteractionSource r2 = (androidx.compose.foundation.interaction.InteractionSource) r2
            androidx.compose.runtime.State r2 = androidx.compose.foundation.interaction.FocusInteractionKt.collectIsFocusedAsState(r2, r4, r7)
            java.lang.Object r2 = r2.getValue()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            long r33 = r13.m2659textColorXeAY9LY$material3_release(r6, r12, r2)
        L_0x050a:
            r36 = r33
            r4.endReplaceGroup()
            androidx.compose.ui.text.TextStyle r35 = new androidx.compose.ui.text.TextStyle
            r65 = 16777214(0xfffffe, float:2.3509884E-38)
            r66 = 0
            r38 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = 0
            r52 = 0
            r53 = 0
            r54 = 0
            r55 = 0
            r56 = 0
            r57 = 0
            r59 = 0
            r60 = 0
            r61 = 0
            r62 = 0
            r63 = 0
            r64 = 0
            r35.<init>((long) r36, (long) r38, (androidx.compose.ui.text.font.FontWeight) r40, (androidx.compose.ui.text.font.FontStyle) r41, (androidx.compose.ui.text.font.FontSynthesis) r42, (androidx.compose.ui.text.font.FontFamily) r43, (java.lang.String) r44, (long) r45, (androidx.compose.ui.text.style.BaselineShift) r47, (androidx.compose.ui.text.style.TextGeometricTransform) r48, (androidx.compose.ui.text.intl.LocaleList) r49, (long) r50, (androidx.compose.ui.text.style.TextDecoration) r52, (androidx.compose.ui.graphics.Shadow) r53, (androidx.compose.ui.graphics.drawscope.DrawStyle) r54, (int) r55, (int) r56, (long) r57, (androidx.compose.ui.text.style.TextIndent) r59, (androidx.compose.ui.text.PlatformTextStyle) r60, (androidx.compose.ui.text.style.LineHeightStyle) r61, (int) r62, (int) r63, (androidx.compose.ui.text.style.TextMotion) r64, (int) r65, (kotlin.jvm.internal.DefaultConstructorMarker) r66)
            r2 = r35
            androidx.compose.ui.text.TextStyle r18 = r0.merge((androidx.compose.ui.text.TextStyle) r2)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r5, r7)
            java.lang.Object r2 = r4.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r11 = r2
            androidx.compose.ui.unit.Density r11 = (androidx.compose.ui.unit.Density) r11
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.foundation.text.selection.TextSelectionColors r5 = r13.getTextSelectionColors()
            androidx.compose.runtime.ProvidedValue r2 = r2.provides(r5)
            androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$1 r8 = new androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$1
            r16 = r6
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            r5 = 54
            r6 = -1886965181(0xffffffff8f873243, float:-1.3331388E-29)
            r7 = 1
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r6, r7, r8, r4, r5)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            int r6 = androidx.compose.runtime.ProvidedValue.$stable
            r6 = r6 | 48
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>) r2, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r5, (androidx.compose.runtime.Composer) r4, (int) r6)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0594
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0594:
            r6 = r0
            r0 = r4
            r7 = r10
            r14 = r12
            r4 = r16
            r5 = r17
            r16 = r19
            r17 = r20
            r18 = r21
            r19 = r22
            r20 = r23
            r15 = r24
            r8 = r26
            r10 = r28
            r11 = r29
            r12 = r30
            r22 = r32
            r21 = r1
            r23 = r13
            r13 = r31
        L_0x05b8:
            androidx.compose.runtime.ScopeUpdateScope r0 = r0.endRestartGroup()
            if (r0 == 0) goto L_0x05dd
            r1 = r0
            androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$2 r0 = new androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$2
            r2 = r27
            r27 = r3
            r3 = r9
            r9 = r2
            r2 = r69
            r24 = r92
            r25 = r93
            r26 = r94
            r67 = r1
            r1 = r68
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r67
            r1.updateScope(r0)
        L_0x05dd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
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
    /* JADX WARNING: Removed duplicated region for block: B:348:0x05be  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:350:? A[RETURN, SYNTHETIC] */
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
    public static final void OutlinedTextField(androidx.compose.ui.text.input.TextFieldValue r68, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r69, androidx.compose.ui.Modifier r70, boolean r71, boolean r72, androidx.compose.ui.text.TextStyle r73, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r74, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r75, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r76, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r77, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r78, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r79, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r80, boolean r81, androidx.compose.ui.text.input.VisualTransformation r82, androidx.compose.foundation.text.KeyboardOptions r83, androidx.compose.foundation.text.KeyboardActions r84, boolean r85, int r86, int r87, androidx.compose.foundation.interaction.MutableInteractionSource r88, androidx.compose.ui.graphics.Shape r89, androidx.compose.material3.TextFieldColors r90, androidx.compose.runtime.Composer r91, int r92, int r93, int r94, int r95) {
        /*
            r0 = r92
            r1 = r93
            r2 = r94
            r3 = r95
            r4 = -1570442800(0xffffffffa264f1d0, float:-3.1027776E-18)
            r5 = r91
            androidx.compose.runtime.Composer r4 = r5.startRestartGroup(r4)
            java.lang.String r5 = "C(OutlinedTextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)350@19364L7,366@20168L5,367@20231L8,379@20751L7,381@20851L2858,381@20764L2945:OutlinedTextField.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r5)
            r5 = r3 & 1
            if (r5 == 0) goto L_0x001f
            r5 = r0 | 6
            r14 = r68
            goto L_0x0031
        L_0x001f:
            r5 = r0 & 6
            r14 = r68
            if (r5 != 0) goto L_0x0030
            boolean r5 = r4.changed((java.lang.Object) r14)
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
            r15 = r69
            goto L_0x004c
        L_0x003a:
            r8 = r0 & 48
            r15 = r69
            if (r8 != 0) goto L_0x004c
            boolean r8 = r4.changedInstance(r15)
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
            r13 = r0 & 384(0x180, float:5.38E-43)
            if (r13 != 0) goto L_0x0067
            r13 = r70
            boolean r16 = r4.changed((java.lang.Object) r13)
            if (r16 == 0) goto L_0x0062
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r5 = r5 | r16
            goto L_0x0069
        L_0x0067:
            r13 = r70
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
            r6 = r71
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
            r6 = r71
        L_0x008a:
            r19 = r3 & 16
            r20 = 8192(0x2000, float:1.14794E-41)
            if (r19 == 0) goto L_0x0093
            r5 = r5 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a7
        L_0x0093:
            r7 = r0 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x00a7
            r7 = r72
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
            r7 = r72
        L_0x00a9:
            r22 = 196608(0x30000, float:2.75506E-40)
            r23 = r0 & r22
            if (r23 != 0) goto L_0x00c3
            r23 = r3 & 32
            r9 = r73
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
            r9 = r73
        L_0x00c5:
            r24 = r3 & 64
            r25 = 1572864(0x180000, float:2.204052E-39)
            if (r24 == 0) goto L_0x00d0
            r5 = r5 | r25
            r10 = r74
            goto L_0x00e3
        L_0x00d0:
            r26 = r0 & r25
            r10 = r74
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
            r12 = r75
            goto L_0x0103
        L_0x00f0:
            r30 = r0 & r29
            r12 = r75
            if (r30 != 0) goto L_0x0103
            boolean r31 = r4.changedInstance(r12)
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
            r31 = r92 & r31
            if (r31 != 0) goto L_0x0122
            r31 = r0
            r0 = r76
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
            r0 = r76
        L_0x0126:
            r0 = r3 & 512(0x200, float:7.175E-43)
            r32 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x012f
            r5 = r5 | r32
            goto L_0x0145
        L_0x012f:
            r33 = r92 & r32
            if (r33 != 0) goto L_0x0145
            r33 = r0
            r0 = r77
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
            r0 = r77
        L_0x0149:
            r0 = r3 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0156
            r34 = r1 | 6
            r35 = r34
            r34 = r0
            r0 = r78
            goto L_0x0172
        L_0x0156:
            r34 = r1 & 6
            if (r34 != 0) goto L_0x016c
            r34 = r0
            r0 = r78
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
            r0 = r78
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
            r0 = r79
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
            r0 = r79
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
            r0 = r80
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
            r0 = r80
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
            r0 = r81
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
            r0 = r81
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
            r0 = r82
            boolean r38 = r4.changed((java.lang.Object) r0)
            if (r38 == 0) goto L_0x01f8
            r20 = 16384(0x4000, float:2.2959E-41)
        L_0x01f8:
            r18 = r18 | r20
            goto L_0x01fd
        L_0x01fb:
            r0 = r82
        L_0x01fd:
            r20 = 32768(0x8000, float:4.5918E-41)
            r20 = r3 & r20
            if (r20 == 0) goto L_0x0209
            r18 = r18 | r22
            r0 = r83
            goto L_0x021c
        L_0x0209:
            r22 = r1 & r22
            r0 = r83
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
            r0 = r84
            goto L_0x023a
        L_0x0227:
            r25 = r1 & r25
            r0 = r84
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
            r0 = r85
            goto L_0x0258
        L_0x0245:
            r29 = r1 & r29
            r0 = r85
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
            r0 = r86
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
            r0 = r86
        L_0x0276:
            r29 = 524288(0x80000, float:7.34684E-40)
            r29 = r3 & r29
            if (r29 == 0) goto L_0x0281
            r18 = r18 | r32
            r0 = r87
            goto L_0x0294
        L_0x0281:
            r32 = r1 & r32
            r0 = r87
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
            r0 = r88
            goto L_0x02b5
        L_0x029f:
            r38 = r2 & 6
            r0 = r88
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
            r0 = r89
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
            r0 = r89
        L_0x02d1:
            r0 = r2 & 384(0x180, float:5.38E-43)
            if (r0 != 0) goto L_0x02eb
            r0 = r3 & r28
            if (r0 != 0) goto L_0x02e4
            r0 = r90
            boolean r23 = r4.changed((java.lang.Object) r0)
            if (r23 == 0) goto L_0x02e6
            r27 = 256(0x100, float:3.59E-43)
            goto L_0x02e8
        L_0x02e4:
            r0 = r90
        L_0x02e6:
            r27 = 128(0x80, float:1.794E-43)
        L_0x02e8:
            r21 = r21 | r27
            goto L_0x02ed
        L_0x02eb:
            r0 = r90
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
            r27 = r76
            r11 = r78
            r14 = r81
            r15 = r82
            r16 = r83
            r17 = r84
            r18 = r85
            r19 = r86
            r20 = r87
            r21 = r88
            r22 = r89
            r23 = r90
            r0 = r4
            r4 = r6
            r5 = r7
            r6 = r9
            r7 = r10
            r8 = r12
            r9 = r13
            r10 = r77
            r12 = r79
            r13 = r80
            goto L_0x05b8
        L_0x033a:
            r4.startDefaults()
            r0 = r92 & 1
            if (r0 == 0) goto L_0x038a
            boolean r0 = r4.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0348
            goto L_0x038a
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
            r27 = r76
            r28 = r77
            r29 = r78
            r30 = r79
            r31 = r80
            r24 = r82
            r19 = r83
            r20 = r84
            r21 = r85
            r22 = r86
            r23 = r87
            r1 = r88
            r32 = r89
            r17 = r7
            r0 = r9
            r26 = r12
            r9 = r13
            r2 = r18
            r7 = 0
            r12 = r81
            r13 = r90
            goto L_0x0498
        L_0x038a:
            if (r8 == 0) goto L_0x0391
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r13 = r0
        L_0x0391:
            if (r16 == 0) goto L_0x0394
            r6 = 1
        L_0x0394:
            if (r19 == 0) goto L_0x0397
            r7 = 0
        L_0x0397:
            r0 = r3 & 32
            if (r0 == 0) goto L_0x03b9
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
            goto L_0x03bb
        L_0x03b9:
            r8 = r35
        L_0x03bb:
            r0 = 0
            if (r24 == 0) goto L_0x03bf
            r10 = r0
        L_0x03bf:
            if (r11 == 0) goto L_0x03c2
            r12 = r0
        L_0x03c2:
            if (r31 == 0) goto L_0x03c6
            r11 = r0
            goto L_0x03c8
        L_0x03c6:
            r11 = r76
        L_0x03c8:
            if (r33 == 0) goto L_0x03cd
            r16 = r0
            goto L_0x03cf
        L_0x03cd:
            r16 = r77
        L_0x03cf:
            if (r34 == 0) goto L_0x03d4
            r19 = r0
            goto L_0x03d6
        L_0x03d4:
            r19 = r78
        L_0x03d6:
            if (r36 == 0) goto L_0x03db
            r21 = r0
            goto L_0x03dd
        L_0x03db:
            r21 = r79
        L_0x03dd:
            if (r37 == 0) goto L_0x03e2
            r23 = r0
            goto L_0x03e4
        L_0x03e2:
            r23 = r80
        L_0x03e4:
            if (r17 == 0) goto L_0x03e9
            r17 = 0
            goto L_0x03eb
        L_0x03e9:
            r17 = r81
        L_0x03eb:
            if (r5 == 0) goto L_0x03f4
            androidx.compose.ui.text.input.VisualTransformation$Companion r5 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r5 = r5.getNone()
            goto L_0x03f6
        L_0x03f4:
            r5 = r82
        L_0x03f6:
            if (r20 == 0) goto L_0x03ff
            androidx.compose.foundation.text.KeyboardOptions$Companion r20 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r20 = r20.getDefault()
            goto L_0x0401
        L_0x03ff:
            r20 = r83
        L_0x0401:
            if (r22 == 0) goto L_0x040a
            androidx.compose.foundation.text.KeyboardActions$Companion r22 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r22 = r22.getDefault()
            goto L_0x040c
        L_0x040a:
            r22 = r84
        L_0x040c:
            if (r25 == 0) goto L_0x0411
            r24 = 0
            goto L_0x0413
        L_0x0411:
            r24 = r85
        L_0x0413:
            r25 = 262144(0x40000, float:3.67342E-40)
            r25 = r3 & r25
            if (r25 == 0) goto L_0x0427
            if (r24 == 0) goto L_0x041e
            r25 = 1
            goto L_0x0421
        L_0x041e:
            r25 = 2147483647(0x7fffffff, float:NaN)
        L_0x0421:
            r26 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r18 = r18 & r26
            goto L_0x0429
        L_0x0427:
            r25 = r86
        L_0x0429:
            if (r29 == 0) goto L_0x042e
            r26 = 1
            goto L_0x0430
        L_0x042e:
            r26 = r87
        L_0x0430:
            if (r32 == 0) goto L_0x0433
            goto L_0x0435
        L_0x0433:
            r0 = r88
        L_0x0435:
            r27 = 2097152(0x200000, float:2.938736E-39)
            r27 = r3 & r27
            r2 = 6
            if (r27 == 0) goto L_0x0443
            androidx.compose.material3.OutlinedTextFieldDefaults r1 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r1 = r1.getShape(r4, r2)
            goto L_0x0445
        L_0x0443:
            r1 = r89
        L_0x0445:
            r28 = r3 & r28
            r70 = r0
            if (r28 == 0) goto L_0x0470
            androidx.compose.material3.OutlinedTextFieldDefaults r0 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            androidx.compose.material3.TextFieldColors r0 = r0.colors(r4, r2)
            r2 = r13
            r13 = r0
            r0 = r9
            r9 = r2
            r32 = r1
            r27 = r11
            r28 = r16
            r2 = r18
            r29 = r19
            r19 = r20
            r30 = r21
            r20 = r22
            r31 = r23
            r21 = r24
            r22 = r25
            r23 = r26
            r1 = r70
            goto L_0x048e
        L_0x0470:
            r32 = r1
            r0 = r9
            r27 = r11
            r9 = r13
            r28 = r16
            r2 = r18
            r29 = r19
            r19 = r20
            r30 = r21
            r20 = r22
            r31 = r23
            r21 = r24
            r22 = r25
            r23 = r26
            r1 = r70
            r13 = r90
        L_0x048e:
            r24 = r5
            r5 = r8
            r26 = r12
            r12 = r17
            r17 = r7
            r7 = 0
        L_0x0498:
            r4.endDefaults()
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x04a9
            r8 = -1570442800(0xffffffffa264f1d0, float:-3.1027776E-18)
            java.lang.String r11 = "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:368)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r8, r5, r2, r11)
        L_0x04a9:
            r2 = 30368324(0x1cf6244, float:7.6180795E-38)
            r4.startReplaceGroup(r2)
            java.lang.String r2 = "370@20325L39"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r2)
            if (r1 != 0) goto L_0x04d9
            r2 = 30368975(0x1cf64cf, float:7.6184444E-38)
            java.lang.String r5 = "CC(remember):OutlinedTextField.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r2, r5)
            java.lang.Object r2 = r4.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r2 != r5) goto L_0x04d1
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r4.updateRememberedValue(r2)
        L_0x04d1:
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = (androidx.compose.foundation.interaction.MutableInteractionSource) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r25 = r2
            goto L_0x04db
        L_0x04d9:
            r25 = r1
        L_0x04db:
            r4.endReplaceGroup()
            r2 = 30374434(0x1cf7a22, float:7.6215043E-38)
            r4.startReplaceGroup(r2)
            java.lang.String r2 = "*374@20549L25"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r2)
            long r33 = r0.m6594getColor0d7_KjU()
            r35 = 16
            int r2 = (r33 > r35 ? 1 : (r33 == r35 ? 0 : -1))
            if (r2 == 0) goto L_0x04f4
            goto L_0x050a
        L_0x04f4:
            r2 = r25
            androidx.compose.foundation.interaction.InteractionSource r2 = (androidx.compose.foundation.interaction.InteractionSource) r2
            androidx.compose.runtime.State r2 = androidx.compose.foundation.interaction.FocusInteractionKt.collectIsFocusedAsState(r2, r4, r7)
            java.lang.Object r2 = r2.getValue()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            long r33 = r13.m2659textColorXeAY9LY$material3_release(r6, r12, r2)
        L_0x050a:
            r36 = r33
            r4.endReplaceGroup()
            androidx.compose.ui.text.TextStyle r35 = new androidx.compose.ui.text.TextStyle
            r65 = 16777214(0xfffffe, float:2.3509884E-38)
            r66 = 0
            r38 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = 0
            r52 = 0
            r53 = 0
            r54 = 0
            r55 = 0
            r56 = 0
            r57 = 0
            r59 = 0
            r60 = 0
            r61 = 0
            r62 = 0
            r63 = 0
            r64 = 0
            r35.<init>((long) r36, (long) r38, (androidx.compose.ui.text.font.FontWeight) r40, (androidx.compose.ui.text.font.FontStyle) r41, (androidx.compose.ui.text.font.FontSynthesis) r42, (androidx.compose.ui.text.font.FontFamily) r43, (java.lang.String) r44, (long) r45, (androidx.compose.ui.text.style.BaselineShift) r47, (androidx.compose.ui.text.style.TextGeometricTransform) r48, (androidx.compose.ui.text.intl.LocaleList) r49, (long) r50, (androidx.compose.ui.text.style.TextDecoration) r52, (androidx.compose.ui.graphics.Shadow) r53, (androidx.compose.ui.graphics.drawscope.DrawStyle) r54, (int) r55, (int) r56, (long) r57, (androidx.compose.ui.text.style.TextIndent) r59, (androidx.compose.ui.text.PlatformTextStyle) r60, (androidx.compose.ui.text.style.LineHeightStyle) r61, (int) r62, (int) r63, (androidx.compose.ui.text.style.TextMotion) r64, (int) r65, (kotlin.jvm.internal.DefaultConstructorMarker) r66)
            r2 = r35
            androidx.compose.ui.text.TextStyle r18 = r0.merge((androidx.compose.ui.text.TextStyle) r2)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r5, r7)
            java.lang.Object r2 = r4.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r11 = r2
            androidx.compose.ui.unit.Density r11 = (androidx.compose.ui.unit.Density) r11
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.foundation.text.selection.TextSelectionColors r5 = r13.getTextSelectionColors()
            androidx.compose.runtime.ProvidedValue r2 = r2.provides(r5)
            androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$3 r8 = new androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$3
            r16 = r6
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            r5 = 54
            r6 = 1830921872(0x6d21a690, float:3.126778E27)
            r7 = 1
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r6, r7, r8, r4, r5)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            int r6 = androidx.compose.runtime.ProvidedValue.$stable
            r6 = r6 | 48
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>) r2, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r5, (androidx.compose.runtime.Composer) r4, (int) r6)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0594
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0594:
            r6 = r0
            r0 = r4
            r7 = r10
            r14 = r12
            r4 = r16
            r5 = r17
            r16 = r19
            r17 = r20
            r18 = r21
            r19 = r22
            r20 = r23
            r15 = r24
            r8 = r26
            r10 = r28
            r11 = r29
            r12 = r30
            r22 = r32
            r21 = r1
            r23 = r13
            r13 = r31
        L_0x05b8:
            androidx.compose.runtime.ScopeUpdateScope r0 = r0.endRestartGroup()
            if (r0 == 0) goto L_0x05dd
            r1 = r0
            androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$4 r0 = new androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$4
            r2 = r27
            r27 = r3
            r3 = r9
            r9 = r2
            r2 = r69
            r24 = r92
            r25 = r93
            r26 = r94
            r67 = r1
            r1 = r68
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r67
            r1.updateScope(r0)
        L_0x05dd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    public static final void OutlinedTextFieldLayout(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, boolean z, float f, Function1<? super Size, Unit> function1, Function2<? super Composer, ? super Integer, Unit> function27, Function2<? super Composer, ? super Integer, Unit> function28, PaddingValues paddingValues, Composer composer, int i, int i2) {
        int i3;
        int i4;
        PaddingValues paddingValues2;
        float f2;
        Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function32;
        Function2<? super Composer, ? super Integer, Unit> function29;
        int i5;
        float f3;
        float f4;
        Modifier modifier2 = modifier;
        Function2<? super Composer, ? super Integer, Unit> function210 = function2;
        Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function33 = function3;
        Function2<? super Composer, ? super Integer, Unit> function211 = function22;
        Function2<? super Composer, ? super Integer, Unit> function212 = function23;
        Function2<? super Composer, ? super Integer, Unit> function213 = function24;
        Function2<? super Composer, ? super Integer, Unit> function214 = function25;
        Function2<? super Composer, ? super Integer, Unit> function215 = function26;
        boolean z2 = z;
        float f5 = f;
        Function1<? super Size, Unit> function12 = function1;
        Function2<? super Composer, ? super Integer, Unit> function216 = function27;
        int i6 = i;
        int i7 = i2;
        Composer startRestartGroup = composer.startRestartGroup(1408290209);
        ComposerKt.sourceInformation(startRestartGroup, "C(OutlinedTextFieldLayout)P(4,12,7,2,3,13,8,10,9!1,5!1,11)470@24558L267,478@24873L7,479@24885L3739:OutlinedTextField.kt#uh7d8r");
        if ((i6 & 6) == 0) {
            i3 = i6 | (startRestartGroup.changed((Object) modifier2) ? 4 : 2);
        } else {
            i3 = i6;
        }
        if ((i6 & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function210) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function33) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function211) ? 2048 : 1024;
        }
        if ((i6 & 24576) == 0) {
            i3 |= startRestartGroup.changedInstance(function212) ? 16384 : 8192;
        }
        if ((196608 & i6) == 0) {
            i3 |= startRestartGroup.changedInstance(function213) ? 131072 : 65536;
        }
        if ((1572864 & i6) == 0) {
            i3 |= startRestartGroup.changedInstance(function214) ? 1048576 : 524288;
        }
        if ((12582912 & i6) == 0) {
            i3 |= startRestartGroup.changedInstance(function215) ? 8388608 : 4194304;
        }
        if ((100663296 & i6) == 0) {
            i3 |= startRestartGroup.changed(z2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((805306368 & i6) == 0) {
            i3 |= startRestartGroup.changed(f5) ? 536870912 : 268435456;
        }
        int i8 = i3;
        if ((i7 & 6) == 0) {
            i4 = i7 | (startRestartGroup.changedInstance(function12) ? 4 : 2);
        } else {
            i4 = i7;
        }
        if ((i7 & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function216) ? 32 : 16;
        }
        if ((i7 & 384) == 0) {
            i4 |= startRestartGroup.changedInstance(function28) ? 256 : 128;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function217 = function28;
        }
        if ((i7 & 3072) == 0) {
            paddingValues2 = paddingValues;
            i4 |= startRestartGroup.changed((Object) paddingValues2) ? 2048 : 1024;
        } else {
            paddingValues2 = paddingValues;
        }
        int i9 = i4;
        if ((i8 & 306783379) == 306783378 && (i9 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            function29 = function28;
            function32 = function33;
            f2 = f5;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1408290209, i8, i9, "androidx.compose.material3.OutlinedTextFieldLayout (OutlinedTextField.kt:468)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 602705309, "CC(remember):OutlinedTextField.kt#9igjgp");
            int i10 = i9;
            boolean z3 = ((i9 & 7168) == 2048) | ((i9 & 14) == 4) | ((234881024 & i8) == 67108864) | ((1879048192 & i8) == 536870912);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new OutlinedTextFieldMeasurePolicy(function12, z2, f5, paddingValues2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy = (OutlinedTextFieldMeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier2);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            int i11 = i8;
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
            Updater.m3682setimpl(r1, outlinedTextFieldMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r1, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r1.getInserting() || !Intrinsics.areEqual(r1.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r1.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r1.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r1, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -828374317, "C482@24954L11,550@27430L186:OutlinedTextField.kt#uh7d8r");
            function216.invoke(startRestartGroup, Integer.valueOf((i10 >> 3) & 14));
            startRestartGroup.startReplaceGroup(250370369);
            ComposerKt.sourceInformation(startRestartGroup, "485@25018L219");
            if (function212 != null) {
                Modifier then = LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.LeadingId).then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment center = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, then);
                int i12 = currentCompositeKeyHash2;
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
                Composer r3 = Updater.m3675constructorimpl(startRestartGroup);
                Updater.m3682setimpl(r3, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3682setimpl(r3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r3.getInserting() || !Intrinsics.areEqual(r3.rememberedValue(), (Object) Integer.valueOf(i12))) {
                    r3.updateRememberedValue(Integer.valueOf(i12));
                    r3.apply(Integer.valueOf(i12), setCompositeKeyHash2);
                }
                Updater.m3682setimpl(r3, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -367907446, "C489@25210L9:OutlinedTextField.kt#uh7d8r");
                function212.invoke(startRestartGroup, Integer.valueOf((i11 >> 12) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(250379492);
            ComposerKt.sourceInformation(startRestartGroup, "493@25304L221");
            if (function213 != null) {
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -367622711, "C497@25497L10:OutlinedTextField.kt#uh7d8r");
                function213.invoke(startRestartGroup, Integer.valueOf((i11 >> 15) & 14));
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
            float f6 = calculateStartPadding;
            if (function213 != null) {
                calculateEndPadding = Dp.m7111constructorimpl(RangesKt.coerceAtLeast(Dp.m7111constructorimpl(calculateEndPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m7111constructorimpl((float) i5)));
            }
            startRestartGroup.startReplaceGroup(250410106);
            ComposerKt.sourceInformation(startRestartGroup, "518@26256L309");
            if (function214 != null) {
                Modifier r10 = PaddingKt.m779paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m833heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.PrefixId), TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null), f6, 0.0f, TextFieldImplKt.getPrefixSuffixTextPadding(), 0.0f, 10, (Object) null);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, r10);
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -366589109, "C524@26539L8:OutlinedTextField.kt#uh7d8r");
                function214.invoke(startRestartGroup, Integer.valueOf((i11 >> 18) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(250422072);
            ComposerKt.sourceInformation(startRestartGroup, "528@26630L307");
            if (function215 != null) {
                f3 = calculateEndPadding;
                Modifier r0 = PaddingKt.m779paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m833heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.SuffixId), TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null), TextFieldImplKt.getPrefixSuffixTextPadding(), 0.0f, f3, 0.0f, 10, (Object) null);
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
                Composer r102 = Updater.m3675constructorimpl(startRestartGroup);
                Updater.m3682setimpl(r102, maybeCachedBoxMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3682setimpl(r102, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r102.getInserting() || !Intrinsics.areEqual(r102.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash5))) {
                    r102.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                    r102.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                }
                Updater.m3682setimpl(r102, materializeModifier5, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -366220085, "C534@26911L8:OutlinedTextField.kt#uh7d8r");
                function215.invoke(startRestartGroup, Integer.valueOf((i11 >> 21) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            } else {
                f3 = calculateEndPadding;
            }
            startRestartGroup.endReplaceGroup();
            Modifier wrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.m833heightInVpY3zN4$default(Modifier.Companion, TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null);
            if (function214 != null) {
                f6 = Dp.m7111constructorimpl((float) 0);
            }
            float f7 = f6;
            if (function215 == null) {
                f4 = f3;
            } else {
                f4 = Dp.m7111constructorimpl((float) 0);
            }
            Modifier r02 = PaddingKt.m779paddingqDBjuR0$default(wrapContentHeight$default, f7, 0.0f, f4, 0.0f, 10, (Object) null);
            startRestartGroup.startReplaceGroup(250444361);
            ComposerKt.sourceInformation(startRestartGroup, "547@27339L63");
            if (function3 != null) {
                function32 = function3;
                function32.invoke(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.PlaceholderId).then(r02), startRestartGroup, Integer.valueOf((i11 >> 3) & 112));
            } else {
                function32 = function3;
            }
            startRestartGroup.endReplaceGroup();
            Modifier then3 = LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.TextFieldId).then(r02);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap6 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier6 = ComposedModifierKt.materializeModifier(startRestartGroup, then3);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -365545432, "C554@27591L11:OutlinedTextField.kt#uh7d8r");
            function2.invoke(startRestartGroup, Integer.valueOf((i11 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.startReplaceGroup(250455481);
            ComposerKt.sourceInformation(startRestartGroup, "558@27667L501");
            if (function22 != null) {
                f2 = f;
                Modifier layoutId = LayoutIdKt.layoutId(SizeKt.wrapContentHeight$default(SizeKt.m833heightInVpY3zN4$default(Modifier.Companion, DpKt.m7154lerpMdfbLM(TextFieldImplKt.getMinTextLineHeight(), TextFieldImplKt.getMinFocusedLabelLineHeight(), f2), 0.0f, 2, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null), TextFieldImplKt.LabelId);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap7 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier7 = ComposedModifierKt.materializeModifier(startRestartGroup, layoutId);
                Function0<ComposeUiNode> constructor7 = ComposeUiNode.Companion.getConstructor();
                int i13 = currentCompositeKeyHash7;
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
                Composer r32 = Updater.m3675constructorimpl(startRestartGroup);
                Updater.m3682setimpl(r32, maybeCachedBoxMeasurePolicy6, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3682setimpl(r32, currentCompositionLocalMap7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r32.getInserting() || !Intrinsics.areEqual(r32.rememberedValue(), (Object) Integer.valueOf(i13))) {
                    r32.updateRememberedValue(Integer.valueOf(i13));
                    r32.apply(Integer.valueOf(i13), setCompositeKeyHash7);
                }
                Updater.m3682setimpl(r32, materializeModifier7, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope6 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -364997972, "C570@28143L7:OutlinedTextField.kt#uh7d8r");
                function22.invoke(startRestartGroup, Integer.valueOf((i11 >> 9) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            } else {
                Function2<? super Composer, ? super Integer, Unit> function218 = function22;
                f2 = f;
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(250473414);
            ComposerKt.sourceInformation(startRestartGroup, "575@28238L317");
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
                Composer r9 = Updater.m3675constructorimpl(startRestartGroup);
                Updater.m3682setimpl(r9, maybeCachedBoxMeasurePolicy7, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3682setimpl(r9, currentCompositionLocalMap8, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r9.getInserting() || !Intrinsics.areEqual(r9.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash8))) {
                    r9.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash8));
                    r9.apply(Integer.valueOf(currentCompositeKeyHash8), setCompositeKeyHash8);
                }
                Updater.m3682setimpl(r9, materializeModifier8, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope7 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -364618873, "C581@28525L12:OutlinedTextField.kt#uh7d8r");
                function29 = function28;
                function29.invoke(startRestartGroup, Integer.valueOf((i10 >> 6) & 14));
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
            endRestartGroup.updateScope(new OutlinedTextFieldKt$OutlinedTextFieldLayout$2(modifier, function2, function32, function22, function23, function213, function214, function215, z, f2, function1, function27, function29, paddingValues2, i, i2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateWidth-DHJA7U0  reason: not valid java name */
    public static final int m2332calculateWidthDHJA7U0(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f, long j, float f2, PaddingValues paddingValues) {
        int i8 = i3 + i4;
        return Math.max(i + Math.max(i5 + i8, Math.max(i7 + i8, MathHelpersKt.lerp(i6, 0, f))) + i2, Math.max(MathKt.roundToInt((((float) i6) + (Dp.m7111constructorimpl(paddingValues.m790calculateLeftPaddingu2uoSUM(LayoutDirection.Ltr) + paddingValues.m791calculateRightPaddingu2uoSUM(LayoutDirection.Ltr)) * f2)) * f), Constraints.m7054getMinWidthimpl(j)));
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateHeight-mKXJcVc  reason: not valid java name */
    public static final int m2331calculateHeightmKXJcVc(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f, long j, float f2, PaddingValues paddingValues) {
        int maxOf = ComparisonsKt.maxOf(i5, i7, i3, i4, MathHelpersKt.lerp(i6, 0, f));
        float r4 = paddingValues.m792calculateTopPaddingD9Ej5fM() * f2;
        return Math.max(Constraints.m7053getMinHeightimpl(j), Math.max(i, Math.max(i2, MathKt.roundToInt(MathHelpersKt.lerp(r4, Math.max(r4, ((float) i6) / 2.0f), f) + ((float) maxOf) + (paddingValues.m789calculateBottomPaddingD9Ej5fM() * f2)))) + i8);
    }

    /* access modifiers changed from: private */
    public static final void place(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, Placeable placeable8, Placeable placeable9, float f, boolean z, float f2, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        Placeable placeable10;
        int i3;
        int i4;
        boolean z2;
        float f3;
        Placeable placeable11 = placeable3;
        Placeable placeable12 = placeable4;
        Placeable placeable13 = placeable7;
        float f4 = f;
        boolean z3 = z;
        Placeable.PlacementScope.m5890place70tqf50$default(placementScope, placeable8, IntOffset.Companion.m7251getZeronOccac(), 0.0f, 2, (Object) null);
        int heightOrZero = i - TextFieldImplKt.heightOrZero(placeable9);
        int roundToInt = MathKt.roundToInt(paddingValues.m792calculateTopPaddingD9Ej5fM() * f2);
        int roundToInt2 = MathKt.roundToInt(PaddingKt.calculateStartPadding(paddingValues, layoutDirection) * f2);
        float horizontalIconPadding = TextFieldImplKt.getHorizontalIconPadding() * f2;
        if (placeable != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, Alignment.Companion.getCenterVertically().align(placeable.getHeight(), heightOrZero), 0.0f, 4, (Object) null);
        }
        if (placeable6 != null) {
            int lerp = MathHelpersKt.lerp(z3 ? Alignment.Companion.getCenterVertically().align(placeable6.getHeight(), heightOrZero) : roundToInt, -(placeable6.getHeight() / 2), f4);
            if (placeable == null) {
                f3 = 0.0f;
            } else {
                f3 = (((float) TextFieldImplKt.widthOrZero(placeable)) - horizontalIconPadding) * (((float) 1) - f4);
            }
            placeable10 = placeable6;
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable10, MathKt.roundToInt(f3) + roundToInt2, lerp, 0.0f, 4, (Object) null);
        } else {
            placeable10 = placeable6;
        }
        if (placeable11 != null) {
            int i5 = heightOrZero;
            i3 = roundToInt;
            i4 = i5;
            z2 = z3;
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable11, TextFieldImplKt.widthOrZero(placeable), place$calculateVerticalPosition(z3, i5, roundToInt, placeable10, placeable11), 0.0f, 4, (Object) null);
        } else {
            z2 = z3;
            i4 = heightOrZero;
            i3 = roundToInt;
        }
        int widthOrZero = TextFieldImplKt.widthOrZero(placeable) + TextFieldImplKt.widthOrZero(placeable3);
        Placeable placeable14 = placeable5;
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable14, widthOrZero, place$calculateVerticalPosition(z2, i4, i3, placeable10, placeable14), 0.0f, 4, (Object) null);
        if (placeable13 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable13, widthOrZero, place$calculateVerticalPosition(z2, i4, i3, placeable10, placeable13), 0.0f, 4, (Object) null);
        }
        if (placeable12 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable12, (i2 - TextFieldImplKt.widthOrZero(placeable2)) - placeable12.getWidth(), place$calculateVerticalPosition(z2, i4, i3, placeable10, placeable12), 0.0f, 4, (Object) null);
        }
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i2 - placeable2.getWidth(), Alignment.Companion.getCenterVertically().align(placeable2.getHeight(), i4), 0.0f, 4, (Object) null);
        }
        if (placeable9 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable9, 0, i4, 0.0f, 4, (Object) null);
        }
    }

    private static final int place$calculateVerticalPosition(boolean z, int i, int i2, Placeable placeable, Placeable placeable2) {
        if (z) {
            i2 = Alignment.Companion.getCenterVertically().align(placeable2.getHeight(), i);
        }
        return Math.max(i2, TextFieldImplKt.heightOrZero(placeable) / 2);
    }

    public static final Modifier outlineCutout(Modifier modifier, Function0<Size> function0, PaddingValues paddingValues) {
        return DrawModifierKt.drawWithContent(modifier, new OutlinedTextFieldKt$outlineCutout$1(function0, paddingValues));
    }

    public static final long getOutlinedTextFieldTopPadding() {
        return OutlinedTextFieldTopPadding;
    }

    static {
        long r0 = TypeScaleTokens.INSTANCE.m3599getBodySmallLineHeightXSAIIZE();
        TextUnitKt.m7319checkArithmeticR2X_6o(r0);
        OutlinedTextFieldTopPadding = TextUnitKt.pack(TextUnit.m7304getRawTypeimpl(r0), TextUnit.m7306getValueimpl(r0) / ((float) 2));
    }
}
