package androidx.compose.material3.internal;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutIdParentData;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000º\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0002\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00012\u0011\u00102\u001a\r\u0012\u0004\u0012\u00020.03¢\u0006\u0002\b42\u0006\u00105\u001a\u0002062\u0013\u00107\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u00108\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u00109\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u0010:\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u0010;\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u0010<\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u0010=\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\b\b\u0002\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u00020?2\b\b\u0002\u0010A\u001a\u00020?2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0011\u0010H\u001a\r\u0012\u0004\u0012\u00020.03¢\u0006\u0002\b4H\u0001¢\u0006\u0002\u0010I\u001a-\u0010J\u001a\u00020.2\u0006\u0010K\u001a\u00020L2\u0011\u0010M\u001a\r\u0012\u0004\u0012\u00020.03¢\u0006\u0002\b4H\u0003ø\u0001\u0000¢\u0006\u0004\bN\u0010O\u001a5\u0010J\u001a\u00020.2\u0006\u0010K\u001a\u00020L2\u0006\u0010P\u001a\u00020Q2\u0011\u0010M\u001a\r\u0012\u0004\u0012\u00020.03¢\u0006\u0002\b4H\u0003ø\u0001\u0000¢\u0006\u0004\bR\u0010S\u001a×\u0001\u0010T\u001a\u00020.2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020L2\u0006\u0010X\u001a\u00020L2\u0006\u0010Y\u001a\u00020L2\u0006\u0010Z\u001a\u00020?2\u0001\u0010M\u001a\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020]0\\¢\u0006\f\b^\u0012\b\b_\u0012\u0004\b\b(`\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020L0\\¢\u0006\f\b^\u0012\b\b_\u0012\u0004\b\b(a\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020L0\\¢\u0006\f\b^\u0012\b\b_\u0012\u0004\b\b(b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020]0\\¢\u0006\f\b^\u0012\b\b_\u0012\u0004\b\b(c\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020]0\\¢\u0006\f\b^\u0012\b\b_\u0012\u0004\b\b(d\u0012\u0004\u0012\u00020.0[¢\u0006\u0002\b4H\bø\u0001\u0000¢\u0006\u0004\be\u0010f\u001aH\u0010g\u001a\b\u0012\u0004\u0012\u00020h0\\2\u0006\u0010@\u001a\u00020?2\u0006\u0010A\u001a\u00020?2\u0006\u0010i\u001a\u00020?2\u0006\u0010F\u001a\u00020G2\u0006\u0010j\u001a\u00020\u00032\u0006\u0010k\u001a\u00020\u0003H\u0001ø\u0001\u0000¢\u0006\u0004\bl\u0010m\u001a\u0012\u0010n\u001a\u00020\u00142\b\u0010o\u001a\u0004\u0018\u00010pH\u0000\u001a\u0012\u0010q\u001a\u00020\u00142\b\u0010o\u001a\u0004\u0018\u00010pH\u0000\u001a\u001c\u0010r\u001a\u00020\b*\u00020\b2\u0006\u0010A\u001a\u00020?2\u0006\u0010s\u001a\u00020\u0001H\u0000\u001a\u001c\u0010t\u001a\u00020\b*\u00020\b2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020xH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0016\u0010\r\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u000e\u0010\u0005\"\u0016\u0010\u000f\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0010\u0010\u0005\"\u0016\u0010\u0011\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0012\u0010\u0005\"\u000e\u0010\u0013\u001a\u00020\u0014XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0014XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0016\u0010\u0018\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0019\u0010\u0005\"\u000e\u0010\u001a\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0016\u0010\u001c\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u001d\u0010\u0005\"\u000e\u0010\u001e\u001a\u00020\u0014XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0016\u0010 \u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b!\u0010\u0005\"\u000e\u0010\"\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0016\u0010#\u001a\u00020$X\u0004¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&\"\u001a\u0010(\u001a\u0004\u0018\u00010)*\u00020*8@X\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006y²\u0006\n\u0010z\u001a\u00020?X\u0002²\u0006\n\u0010{\u001a\u00020?X\u0002"}, d2 = {"ContainerId", "", "HorizontalIconPadding", "Landroidx/compose/ui/unit/Dp;", "getHorizontalIconPadding", "()F", "F", "IconDefaultSizeModifier", "Landroidx/compose/ui/Modifier;", "getIconDefaultSizeModifier", "()Landroidx/compose/ui/Modifier;", "LabelId", "LeadingId", "MinFocusedLabelLineHeight", "getMinFocusedLabelLineHeight", "MinSupportingTextLineHeight", "getMinSupportingTextLineHeight", "MinTextLineHeight", "getMinTextLineHeight", "PlaceholderAnimationDelayOrDuration", "", "PlaceholderAnimationDuration", "PlaceholderId", "PrefixId", "PrefixSuffixTextPadding", "getPrefixSuffixTextPadding", "SuffixId", "SupportingId", "SupportingTopPadding", "getSupportingTopPadding", "TextFieldAnimationDuration", "TextFieldId", "TextFieldPadding", "getTextFieldPadding", "TrailingId", "ZeroConstraints", "Landroidx/compose/ui/unit/Constraints;", "getZeroConstraints", "()J", "J", "layoutId", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getLayoutId", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Ljava/lang/Object;", "CommonDecorationBox", "", "type", "Landroidx/compose/material3/internal/TextFieldType;", "value", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "singleLine", "", "enabled", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "colors", "Landroidx/compose/material3/TextFieldColors;", "container", "(Landroidx/compose/material3/internal/TextFieldType;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/material3/TextFieldColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Decoration", "contentColor", "Landroidx/compose/ui/graphics/Color;", "content", "Decoration-Iv8Zu3U", "(JLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "Decoration-3J-VO9M", "(JLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TextFieldTransitionScope", "inputState", "Landroidx/compose/material3/internal/InputPhase;", "focusedLabelTextStyleColor", "unfocusedLabelTextStyleColor", "labelColor", "showLabel", "Lkotlin/Function5;", "Landroidx/compose/runtime/State;", "", "Lkotlin/ParameterName;", "name", "labelProgress", "labelTextStyleColor", "labelContentColor", "placeholderOpacity", "prefixSuffixOpacity", "TextFieldTransitionScope-Jy8F4Js", "(Landroidx/compose/material3/internal/InputPhase;JJJZLkotlin/jvm/functions/Function7;Landroidx/compose/runtime/Composer;I)V", "animateBorderStrokeAsState", "Landroidx/compose/foundation/BorderStroke;", "focused", "focusedBorderThickness", "unfocusedBorderThickness", "animateBorderStrokeAsState-NuRrP5Q", "(ZZZLandroidx/compose/material3/TextFieldColors;FFLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "heightOrZero", "placeable", "Landroidx/compose/ui/layout/Placeable;", "widthOrZero", "defaultErrorSemantics", "defaultErrorMessage", "textFieldBackground", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "shape", "Landroidx/compose/ui/graphics/Shape;", "material3_release", "showPlaceholder", "showPrefixSuffix"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldImpl.kt */
public final class TextFieldImplKt {
    public static final String ContainerId = "Container";
    private static final float HorizontalIconPadding = Dp.m7111constructorimpl((float) 12);
    private static final Modifier IconDefaultSizeModifier;
    public static final String LabelId = "Label";
    public static final String LeadingId = "Leading";
    private static final float MinFocusedLabelLineHeight;
    private static final float MinSupportingTextLineHeight;
    private static final float MinTextLineHeight = Dp.m7111constructorimpl((float) 24);
    private static final int PlaceholderAnimationDelayOrDuration = 67;
    private static final int PlaceholderAnimationDuration = 83;
    public static final String PlaceholderId = "Hint";
    public static final String PrefixId = "Prefix";
    private static final float PrefixSuffixTextPadding = Dp.m7111constructorimpl((float) 2);
    public static final String SuffixId = "Suffix";
    public static final String SupportingId = "Supporting";
    private static final float SupportingTopPadding = Dp.m7111constructorimpl((float) 4);
    public static final int TextFieldAnimationDuration = 150;
    public static final String TextFieldId = "TextField";
    private static final float TextFieldPadding;
    public static final String TrailingId = "Trailing";
    private static final long ZeroConstraints = ConstraintsKt.Constraints(0, 0, 0, 0);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextFieldImpl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|17) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0032 */
        static {
            /*
                androidx.compose.material3.internal.TextFieldType[] r0 = androidx.compose.material3.internal.TextFieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                androidx.compose.material3.internal.TextFieldType r2 = androidx.compose.material3.internal.TextFieldType.Filled     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                androidx.compose.material3.internal.TextFieldType r3 = androidx.compose.material3.internal.TextFieldType.Outlined     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                androidx.compose.material3.internal.InputPhase[] r0 = androidx.compose.material3.internal.InputPhase.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.material3.internal.InputPhase r3 = androidx.compose.material3.internal.InputPhase.Focused     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                androidx.compose.material3.internal.InputPhase r1 = androidx.compose.material3.internal.InputPhase.UnfocusedEmpty     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                androidx.compose.material3.internal.InputPhase r1 = androidx.compose.material3.internal.InputPhase.UnfocusedNotEmpty     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.TextFieldImplKt.WhenMappings.<clinit>():void");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:319:0x052d, code lost:
        if (r34 != false) goto L_0x0525;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:337:0x0583, code lost:
        if (r34 != false) goto L_0x057b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0215  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x022f  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x0443  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x0462  */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x0470  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x047f  */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x0496  */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x04fd  */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x050e  */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x051f  */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x0538  */
    /* JADX WARNING: Removed duplicated region for block: B:326:0x0557  */
    /* JADX WARNING: Removed duplicated region for block: B:327:0x0566  */
    /* JADX WARNING: Removed duplicated region for block: B:330:0x0575  */
    /* JADX WARNING: Removed duplicated region for block: B:341:0x058e  */
    /* JADX WARNING: Removed duplicated region for block: B:344:0x05ef  */
    /* JADX WARNING: Removed duplicated region for block: B:345:0x05fe  */
    /* JADX WARNING: Removed duplicated region for block: B:348:0x060d  */
    /* JADX WARNING: Removed duplicated region for block: B:359:0x0626  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:362:0x0645  */
    /* JADX WARNING: Removed duplicated region for block: B:363:0x0654  */
    /* JADX WARNING: Removed duplicated region for block: B:366:0x0663  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:377:0x067c  */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x06d1  */
    /* JADX WARNING: Removed duplicated region for block: B:381:0x06df  */
    /* JADX WARNING: Removed duplicated region for block: B:384:0x06f0  */
    /* JADX WARNING: Removed duplicated region for block: B:385:0x06f3  */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x06fb  */
    /* JADX WARNING: Removed duplicated region for block: B:396:0x074c  */
    /* JADX WARNING: Removed duplicated region for block: B:397:0x0758  */
    /* JADX WARNING: Removed duplicated region for block: B:400:0x0767  */
    /* JADX WARNING: Removed duplicated region for block: B:401:0x076a  */
    /* JADX WARNING: Removed duplicated region for block: B:404:0x0772  */
    /* JADX WARNING: Removed duplicated region for block: B:407:0x078e  */
    /* JADX WARNING: Removed duplicated region for block: B:408:0x079a  */
    /* JADX WARNING: Removed duplicated region for block: B:411:0x07a9  */
    /* JADX WARNING: Removed duplicated region for block: B:412:0x07ac  */
    /* JADX WARNING: Removed duplicated region for block: B:415:0x07b4  */
    /* JADX WARNING: Removed duplicated region for block: B:418:0x080b  */
    /* JADX WARNING: Removed duplicated region for block: B:419:0x0817  */
    /* JADX WARNING: Removed duplicated region for block: B:422:0x0821  */
    /* JADX WARNING: Removed duplicated region for block: B:430:0x0872  */
    /* JADX WARNING: Removed duplicated region for block: B:433:0x087f  */
    /* JADX WARNING: Removed duplicated region for block: B:436:0x089b  */
    /* JADX WARNING: Removed duplicated region for block: B:437:0x08a3  */
    /* JADX WARNING: Removed duplicated region for block: B:440:0x08aa  */
    /* JADX WARNING: Removed duplicated region for block: B:443:0x08ff  */
    /* JADX WARNING: Removed duplicated region for block: B:444:0x0906  */
    /* JADX WARNING: Removed duplicated region for block: B:447:0x094a  */
    /* JADX WARNING: Removed duplicated region for block: B:454:0x097e  */
    /* JADX WARNING: Removed duplicated region for block: B:455:0x09a4  */
    /* JADX WARNING: Removed duplicated region for block: B:458:0x09c0  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:463:0x09ea  */
    /* JADX WARNING: Removed duplicated region for block: B:464:0x0a11  */
    /* JADX WARNING: Removed duplicated region for block: B:469:0x0a36  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:470:0x0a56  */
    /* JADX WARNING: Removed duplicated region for block: B:473:0x0a70  */
    /* JADX WARNING: Removed duplicated region for block: B:474:0x0a72  */
    /* JADX WARNING: Removed duplicated region for block: B:477:0x0a97  */
    /* JADX WARNING: Removed duplicated region for block: B:478:0x0a9c  */
    /* JADX WARNING: Removed duplicated region for block: B:481:0x0ac5  */
    /* JADX WARNING: Removed duplicated region for block: B:482:0x0acb  */
    /* JADX WARNING: Removed duplicated region for block: B:485:0x0aed  */
    /* JADX WARNING: Removed duplicated region for block: B:497:0x0ba9  */
    /* JADX WARNING: Removed duplicated region for block: B:500:0x0c0a  */
    /* JADX WARNING: Removed duplicated region for block: B:504:0x0c1f  */
    /* JADX WARNING: Removed duplicated region for block: B:506:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0130  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void CommonDecorationBox(androidx.compose.material3.internal.TextFieldType r44, java.lang.String r45, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, androidx.compose.ui.text.input.VisualTransformation r47, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r48, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r52, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r53, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r54, boolean r55, boolean r56, boolean r57, androidx.compose.foundation.interaction.InteractionSource r58, androidx.compose.foundation.layout.PaddingValues r59, androidx.compose.material3.TextFieldColors r60, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r61, androidx.compose.runtime.Composer r62, int r63, int r64, int r65) {
        /*
            r4 = r47
            r5 = r48
            r15 = r58
            r0 = r59
            r1 = r60
            r2 = r61
            r3 = r63
            r6 = r64
            r7 = r65
            r8 = 1514469103(0x5a44f6ef, float:1.38601504E16)
            r9 = r62
            androidx.compose.runtime.Composer r8 = r9.startRestartGroup(r8)
            java.lang.String r9 = "C(CommonDecorationBox)P(15,16,4,17,7,9,8,14,10,12,13,11,3,6,5,2)98@4054L121,104@4251L25,114@4594L10,121@4911L7503:TextFieldImpl.kt#mqatfk"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r9)
            r9 = r7 & 1
            if (r9 == 0) goto L_0x002a
            r9 = r3 | 6
            r11 = r9
            r9 = r44
            goto L_0x003e
        L_0x002a:
            r9 = r3 & 6
            if (r9 != 0) goto L_0x003b
            r9 = r44
            boolean r11 = r8.changed((java.lang.Object) r9)
            if (r11 == 0) goto L_0x0038
            r11 = 4
            goto L_0x0039
        L_0x0038:
            r11 = 2
        L_0x0039:
            r11 = r11 | r3
            goto L_0x003e
        L_0x003b:
            r9 = r44
            r11 = r3
        L_0x003e:
            r12 = r7 & 2
            if (r12 == 0) goto L_0x0045
            r11 = r11 | 48
            goto L_0x0058
        L_0x0045:
            r12 = r3 & 48
            if (r12 != 0) goto L_0x0058
            r12 = r45
            boolean r14 = r8.changed((java.lang.Object) r12)
            if (r14 == 0) goto L_0x0054
            r14 = 32
            goto L_0x0056
        L_0x0054:
            r14 = 16
        L_0x0056:
            r11 = r11 | r14
            goto L_0x005a
        L_0x0058:
            r12 = r45
        L_0x005a:
            r14 = r7 & 4
            if (r14 == 0) goto L_0x0061
            r11 = r11 | 384(0x180, float:5.38E-43)
            goto L_0x0075
        L_0x0061:
            r14 = r3 & 384(0x180, float:5.38E-43)
            if (r14 != 0) goto L_0x0075
            r14 = r46
            boolean r16 = r8.changedInstance(r14)
            if (r16 == 0) goto L_0x0070
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0072
        L_0x0070:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0072:
            r11 = r11 | r16
            goto L_0x0077
        L_0x0075:
            r14 = r46
        L_0x0077:
            r16 = r7 & 8
            if (r16 == 0) goto L_0x007e
            r11 = r11 | 3072(0xc00, float:4.305E-42)
            goto L_0x008e
        L_0x007e:
            r10 = r3 & 3072(0xc00, float:4.305E-42)
            if (r10 != 0) goto L_0x008e
            boolean r10 = r8.changed((java.lang.Object) r4)
            if (r10 == 0) goto L_0x008b
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x008d
        L_0x008b:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x008d:
            r11 = r11 | r10
        L_0x008e:
            r10 = r7 & 16
            if (r10 == 0) goto L_0x0095
            r11 = r11 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a5
        L_0x0095:
            r10 = r3 & 24576(0x6000, float:3.4438E-41)
            if (r10 != 0) goto L_0x00a5
            boolean r10 = r8.changedInstance(r5)
            if (r10 == 0) goto L_0x00a2
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a4
        L_0x00a2:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x00a4:
            r11 = r11 | r10
        L_0x00a5:
            r10 = r7 & 32
            r17 = 196608(0x30000, float:2.75506E-40)
            if (r10 == 0) goto L_0x00b0
            r11 = r11 | r17
            r13 = r49
            goto L_0x00c3
        L_0x00b0:
            r17 = r3 & r17
            r13 = r49
            if (r17 != 0) goto L_0x00c3
            boolean r18 = r8.changedInstance(r13)
            if (r18 == 0) goto L_0x00bf
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c1
        L_0x00bf:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x00c1:
            r11 = r11 | r18
        L_0x00c3:
            r18 = r7 & 64
            r19 = 1572864(0x180000, float:2.204052E-39)
            if (r18 == 0) goto L_0x00ce
            r11 = r11 | r19
            r3 = r50
            goto L_0x00e1
        L_0x00ce:
            r19 = r3 & r19
            r3 = r50
            if (r19 != 0) goto L_0x00e1
            boolean r19 = r8.changedInstance(r3)
            if (r19 == 0) goto L_0x00dd
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00df
        L_0x00dd:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x00df:
            r11 = r11 | r19
        L_0x00e1:
            r3 = r7 & 128(0x80, float:1.794E-43)
            r19 = 12582912(0xc00000, float:1.7632415E-38)
            if (r3 == 0) goto L_0x00ea
            r11 = r11 | r19
            goto L_0x0100
        L_0x00ea:
            r19 = r63 & r19
            if (r19 != 0) goto L_0x0100
            r19 = r3
            r3 = r51
            boolean r20 = r8.changedInstance(r3)
            if (r20 == 0) goto L_0x00fb
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fd
        L_0x00fb:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fd:
            r11 = r11 | r20
            goto L_0x0104
        L_0x0100:
            r19 = r3
            r3 = r51
        L_0x0104:
            r3 = r7 & 256(0x100, float:3.59E-43)
            r20 = 100663296(0x6000000, float:2.4074124E-35)
            if (r3 == 0) goto L_0x010d
            r11 = r11 | r20
            goto L_0x0123
        L_0x010d:
            r20 = r63 & r20
            if (r20 != 0) goto L_0x0123
            r20 = r3
            r3 = r52
            boolean r21 = r8.changedInstance(r3)
            if (r21 == 0) goto L_0x011e
            r21 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0120
        L_0x011e:
            r21 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0120:
            r11 = r11 | r21
            goto L_0x0127
        L_0x0123:
            r20 = r3
            r3 = r52
        L_0x0127:
            r3 = r7 & 512(0x200, float:7.175E-43)
            r21 = 805306368(0x30000000, float:4.656613E-10)
            if (r3 == 0) goto L_0x0130
            r11 = r11 | r21
            goto L_0x0146
        L_0x0130:
            r21 = r63 & r21
            if (r21 != 0) goto L_0x0146
            r21 = r3
            r3 = r53
            boolean r22 = r8.changedInstance(r3)
            if (r22 == 0) goto L_0x0141
            r22 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0143
        L_0x0141:
            r22 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0143:
            r11 = r11 | r22
            goto L_0x014a
        L_0x0146:
            r21 = r3
            r3 = r53
        L_0x014a:
            r3 = r7 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0157
            r22 = r6 | 6
            r23 = r22
            r22 = r3
            r3 = r54
            goto L_0x0173
        L_0x0157:
            r22 = r6 & 6
            if (r22 != 0) goto L_0x016d
            r22 = r3
            r3 = r54
            boolean r23 = r8.changedInstance(r3)
            if (r23 == 0) goto L_0x0168
            r23 = 4
            goto L_0x016a
        L_0x0168:
            r23 = 2
        L_0x016a:
            r23 = r6 | r23
            goto L_0x0173
        L_0x016d:
            r22 = r3
            r3 = r54
            r23 = r6
        L_0x0173:
            r3 = r7 & 2048(0x800, float:2.87E-42)
            if (r3 == 0) goto L_0x017c
            r23 = r23 | 48
            r24 = r3
            goto L_0x0196
        L_0x017c:
            r24 = r6 & 48
            if (r24 != 0) goto L_0x0192
            r24 = r3
            r3 = r55
            boolean r25 = r8.changed((boolean) r3)
            if (r25 == 0) goto L_0x018d
            r25 = 32
            goto L_0x018f
        L_0x018d:
            r25 = 16
        L_0x018f:
            r23 = r23 | r25
            goto L_0x0196
        L_0x0192:
            r24 = r3
            r3 = r55
        L_0x0196:
            r3 = r23
            r5 = r7 & 4096(0x1000, float:5.74E-42)
            if (r5 == 0) goto L_0x019f
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x01b9
        L_0x019f:
            r23 = r3
            r3 = r6 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x01b5
            r3 = r56
            boolean r25 = r8.changed((boolean) r3)
            if (r25 == 0) goto L_0x01b0
            r25 = 256(0x100, float:3.59E-43)
            goto L_0x01b2
        L_0x01b0:
            r25 = 128(0x80, float:1.794E-43)
        L_0x01b2:
            r23 = r23 | r25
            goto L_0x01b7
        L_0x01b5:
            r3 = r56
        L_0x01b7:
            r3 = r23
        L_0x01b9:
            r23 = r5
            r5 = r7 & 8192(0x2000, float:1.14794E-41)
            if (r5 == 0) goto L_0x01c2
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x01dc
        L_0x01c2:
            r25 = r3
            r3 = r6 & 3072(0xc00, float:4.305E-42)
            if (r3 != 0) goto L_0x01d8
            r3 = r57
            boolean r26 = r8.changed((boolean) r3)
            if (r26 == 0) goto L_0x01d3
            r26 = 2048(0x800, float:2.87E-42)
            goto L_0x01d5
        L_0x01d3:
            r26 = 1024(0x400, float:1.435E-42)
        L_0x01d5:
            r25 = r25 | r26
            goto L_0x01da
        L_0x01d8:
            r3 = r57
        L_0x01da:
            r3 = r25
        L_0x01dc:
            r25 = r5
            r5 = r7 & 16384(0x4000, float:2.2959E-41)
            if (r5 == 0) goto L_0x01e5
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x01f5
        L_0x01e5:
            r5 = r6 & 24576(0x6000, float:3.4438E-41)
            if (r5 != 0) goto L_0x01f5
            boolean r5 = r8.changed((java.lang.Object) r15)
            if (r5 == 0) goto L_0x01f2
            r5 = 16384(0x4000, float:2.2959E-41)
            goto L_0x01f4
        L_0x01f2:
            r5 = 8192(0x2000, float:1.14794E-41)
        L_0x01f4:
            r3 = r3 | r5
        L_0x01f5:
            r5 = 32768(0x8000, float:4.5918E-41)
            r5 = r5 & r7
            if (r5 == 0) goto L_0x01ff
            r5 = 196608(0x30000, float:2.75506E-40)
        L_0x01fd:
            r3 = r3 | r5
            goto L_0x0210
        L_0x01ff:
            r5 = 196608(0x30000, float:2.75506E-40)
            r5 = r5 & r6
            if (r5 != 0) goto L_0x0210
            boolean r5 = r8.changed((java.lang.Object) r0)
            if (r5 == 0) goto L_0x020d
            r5 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01fd
        L_0x020d:
            r5 = 65536(0x10000, float:9.18355E-41)
            goto L_0x01fd
        L_0x0210:
            r5 = 65536(0x10000, float:9.18355E-41)
            r5 = r5 & r7
            if (r5 == 0) goto L_0x0219
            r5 = 1572864(0x180000, float:2.204052E-39)
        L_0x0217:
            r3 = r3 | r5
            goto L_0x022a
        L_0x0219:
            r5 = 1572864(0x180000, float:2.204052E-39)
            r5 = r5 & r6
            if (r5 != 0) goto L_0x022a
            boolean r5 = r8.changed((java.lang.Object) r1)
            if (r5 == 0) goto L_0x0227
            r5 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0217
        L_0x0227:
            r5 = 524288(0x80000, float:7.34684E-40)
            goto L_0x0217
        L_0x022a:
            r5 = 131072(0x20000, float:1.83671E-40)
            r5 = r5 & r7
            if (r5 == 0) goto L_0x0233
            r5 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x0231:
            r3 = r3 | r5
            goto L_0x0244
        L_0x0233:
            r5 = 12582912(0xc00000, float:1.7632415E-38)
            r5 = r5 & r6
            if (r5 != 0) goto L_0x0244
            boolean r5 = r8.changedInstance(r2)
            if (r5 == 0) goto L_0x0241
            r5 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0231
        L_0x0241:
            r5 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x0231
        L_0x0244:
            r5 = 306783379(0x12492493, float:6.34695E-28)
            r5 = r5 & r11
            r6 = 306783378(0x12492492, float:6.3469493E-28)
            if (r5 != r6) goto L_0x0275
            r5 = 4793491(0x492493, float:6.717112E-39)
            r5 = r5 & r3
            r6 = 4793490(0x492492, float:6.71711E-39)
            if (r5 != r6) goto L_0x0275
            boolean r5 = r8.getSkipping()
            if (r5 != 0) goto L_0x025d
            goto L_0x0275
        L_0x025d:
            r8.skipToGroupEnd()
            r7 = r50
            r9 = r52
            r10 = r53
            r11 = r54
            r12 = r55
            r14 = r57
            r5 = r2
            r4 = r8
            r6 = r13
            r8 = r51
            r13 = r56
            goto L_0x0c19
        L_0x0275:
            if (r10 == 0) goto L_0x0278
            r13 = 0
        L_0x0278:
            if (r18 == 0) goto L_0x027c
            r6 = 0
            goto L_0x027e
        L_0x027c:
            r6 = r50
        L_0x027e:
            if (r19 == 0) goto L_0x0282
            r10 = 0
            goto L_0x0284
        L_0x0282:
            r10 = r51
        L_0x0284:
            if (r20 == 0) goto L_0x0289
            r18 = 0
            goto L_0x028b
        L_0x0289:
            r18 = r52
        L_0x028b:
            if (r21 == 0) goto L_0x0290
            r19 = 0
            goto L_0x0292
        L_0x0290:
            r19 = r53
        L_0x0292:
            if (r22 == 0) goto L_0x0296
            r5 = 0
            goto L_0x0298
        L_0x0296:
            r5 = r54
        L_0x0298:
            if (r24 == 0) goto L_0x029d
            r24 = 0
            goto L_0x029f
        L_0x029d:
            r24 = r55
        L_0x029f:
            if (r23 == 0) goto L_0x02a3
            r7 = 1
            goto L_0x02a5
        L_0x02a3:
            r7 = r56
        L_0x02a5:
            if (r25 == 0) goto L_0x02a9
            r9 = 0
            goto L_0x02ab
        L_0x02a9:
            r9 = r57
        L_0x02ab:
            boolean r23 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r23 == 0) goto L_0x02bc
            r12 = 1514469103(0x5a44f6ef, float:1.38601504E16)
            r23 = r13
            java.lang.String r13 = "androidx.compose.material3.internal.CommonDecorationBox (TextFieldImpl.kt:96)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r11, r3, r13)
            goto L_0x02be
        L_0x02bc:
            r23 = r13
        L_0x02be:
            r12 = 318599163(0x12fd6ffb, float:1.599415E-27)
            java.lang.String r13 = "CC(remember):TextFieldImpl.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r12, r13)
            r12 = r11 & 112(0x70, float:1.57E-43)
            r25 = r3
            r3 = 32
            if (r12 != r3) goto L_0x02d0
            r3 = 1
            goto L_0x02d1
        L_0x02d0:
            r3 = 0
        L_0x02d1:
            r12 = r11 & 7168(0x1c00, float:1.0045E-41)
            r49 = r3
            r3 = 2048(0x800, float:2.87E-42)
            if (r12 != r3) goto L_0x02db
            r3 = 1
            goto L_0x02dc
        L_0x02db:
            r3 = 0
        L_0x02dc:
            r3 = r49 | r3
            java.lang.Object r12 = r8.rememberedValue()
            if (r3 != 0) goto L_0x02ec
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r12 != r3) goto L_0x030b
        L_0x02ec:
            androidx.compose.ui.text.AnnotatedString r3 = new androidx.compose.ui.text.AnnotatedString
            r12 = 6
            r16 = 0
            r17 = 0
            r26 = 0
            r50 = r45
            r49 = r3
            r53 = r12
            r54 = r16
            r51 = r17
            r52 = r26
            r49.<init>(r50, r51, r52, r53, r54)
            androidx.compose.ui.text.input.TransformedText r12 = r4.filter(r3)
            r8.updateRememberedValue(r12)
        L_0x030b:
            androidx.compose.ui.text.input.TransformedText r12 = (androidx.compose.ui.text.input.TransformedText) r12
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.ui.text.AnnotatedString r3 = r12.getText()
            java.lang.String r3 = r3.getText()
            int r12 = r25 >> 12
            r12 = r12 & 14
            androidx.compose.runtime.State r12 = androidx.compose.foundation.interaction.FocusInteractionKt.collectIsFocusedAsState(r15, r8, r12)
            java.lang.Object r12 = r12.getValue()
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x0333
            androidx.compose.material3.internal.InputPhase r16 = androidx.compose.material3.internal.InputPhase.Focused
        L_0x032e:
            r57 = r3
            r3 = r16
            goto L_0x0343
        L_0x0333:
            r16 = r3
            java.lang.CharSequence r16 = (java.lang.CharSequence) r16
            int r16 = r16.length()
            if (r16 != 0) goto L_0x0340
            androidx.compose.material3.internal.InputPhase r16 = androidx.compose.material3.internal.InputPhase.UnfocusedEmpty
            goto L_0x032e
        L_0x0340:
            androidx.compose.material3.internal.InputPhase r16 = androidx.compose.material3.internal.InputPhase.UnfocusedNotEmpty
            goto L_0x032e
        L_0x0343:
            long r16 = r1.m2653labelColorXeAY9LY$material3_release(r7, r9, r12)
            androidx.compose.material3.MaterialTheme r4 = androidx.compose.material3.MaterialTheme.INSTANCE
            r26 = r11
            r11 = 6
            androidx.compose.material3.Typography r4 = r4.getTypography(r8, r11)
            androidx.compose.ui.text.TextStyle r27 = r4.getBodyLarge()
            androidx.compose.ui.text.TextStyle r4 = r4.getBodySmall()
            r29 = r11
            r28 = r12
            long r11 = r27.m6594getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r30 = androidx.compose.ui.graphics.Color.Companion
            long r14 = r30.m4275getUnspecified0d7_KjU()
            boolean r11 = androidx.compose.ui.graphics.Color.m4240equalsimpl0(r11, r14)
            if (r11 == 0) goto L_0x037c
            long r11 = r4.m6594getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r14 = androidx.compose.ui.graphics.Color.Companion
            long r14 = r14.m4275getUnspecified0d7_KjU()
            boolean r11 = androidx.compose.ui.graphics.Color.m4240equalsimpl0(r11, r14)
            if (r11 == 0) goto L_0x039c
        L_0x037c:
            long r11 = r27.m6594getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r14 = androidx.compose.ui.graphics.Color.Companion
            long r14 = r14.m4275getUnspecified0d7_KjU()
            boolean r11 = androidx.compose.ui.graphics.Color.m4240equalsimpl0(r11, r14)
            if (r11 != 0) goto L_0x039e
            long r11 = r4.m6594getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r14 = androidx.compose.ui.graphics.Color.Companion
            long r14 = r14.m4275getUnspecified0d7_KjU()
            boolean r11 = androidx.compose.ui.graphics.Color.m4240equalsimpl0(r11, r14)
            if (r11 == 0) goto L_0x039e
        L_0x039c:
            r11 = 1
            goto L_0x039f
        L_0x039e:
            r11 = 0
        L_0x039f:
            long r14 = r4.m6594getColor0d7_KjU()
            if (r11 == 0) goto L_0x03ae
            r30 = 16
            int r12 = (r14 > r30 ? 1 : (r14 == r30 ? 0 : -1))
            if (r12 == 0) goto L_0x03ac
            goto L_0x03ae
        L_0x03ac:
            r14 = r16
        L_0x03ae:
            long r30 = r27.m6594getColor0d7_KjU()
            if (r11 == 0) goto L_0x03bd
            r32 = 16
            int r12 = (r30 > r32 ? 1 : (r30 == r32 ? 0 : -1))
            if (r12 == 0) goto L_0x03bb
            goto L_0x03bd
        L_0x03bb:
            r30 = r16
        L_0x03bd:
            if (r48 == 0) goto L_0x03c1
            r12 = 1
            goto L_0x03c2
        L_0x03c1:
            r12 = 0
        L_0x03c2:
            r32 = r4
            r4 = -1087703202(0xffffffffbf2af75e, float:-0.667837)
            r33 = r11
            java.lang.String r11 = "CC(TextFieldTransitionScope)P(2,1:c#ui.graphics.Color,5:c#ui.graphics.Color,3:c#ui.graphics.Color,4)349@14528L59,352@14632L334,364@15016L1126,394@16193L363,406@16607L318,418@17028L197,424@17231L150:TextFieldImpl.kt#mqatfk"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r4, r11)
            java.lang.String r4 = "TextFieldInputState"
            r11 = 48
            r34 = r12
            r12 = 0
            androidx.compose.animation.core.Transition r3 = androidx.compose.animation.core.TransitionKt.updateTransition(r3, (java.lang.String) r4, (androidx.compose.runtime.Composer) r8, (int) r11, (int) r12)
            androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelProgress$1 r4 = androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelProgress$1.INSTANCE
            kotlin.jvm.functions.Function3 r4 = (kotlin.jvm.functions.Function3) r4
            r12 = -1338768149(0xffffffffb03404eb, float:-6.549061E-10)
            r35 = r11
            java.lang.String r11 = "CC(animateFloat)P(2)1966@80444L78:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r12, r11)
            kotlin.jvm.internal.FloatCompanionObject r11 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r11 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r11)
            r12 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            r49 = r3
            java.lang.String r3 = "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r12, r3)
            java.lang.Object r36 = r49.getCurrentState()
            androidx.compose.material3.internal.InputPhase r36 = (androidx.compose.material3.internal.InputPhase) r36
            r12 = -2036730335(0xffffffff8699f621, float:-5.791386E-35)
            r8.startReplaceGroup(r12)
            java.lang.String r12 = "C:TextFieldImpl.kt#mqatfk"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r12)
            boolean r37 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r53 = r11
            r11 = -1
            if (r37 == 0) goto L_0x041d
            r37 = r14
            r14 = -2036730335(0xffffffff8699f621, float:-5.791386E-35)
            java.lang.String r15 = "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:356)"
            r0 = 0
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r0, r11, r15)
            goto L_0x041f
        L_0x041d:
            r37 = r14
        L_0x041f:
            int[] r0 = androidx.compose.material3.internal.TextFieldImplKt.WhenMappings.$EnumSwitchMapping$1
            int r14 = r36.ordinal()
            r0 = r0[r14]
            r15 = 3
            r36 = 1065353216(0x3f800000, float:1.0)
            r14 = 1
            if (r0 == r14) goto L_0x043b
            r14 = 2
            if (r0 == r14) goto L_0x0439
            if (r0 != r15) goto L_0x0433
            goto L_0x043b
        L_0x0433:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0439:
            r0 = 0
            goto L_0x043d
        L_0x043b:
            r0 = r36
        L_0x043d:
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto L_0x0446
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0446:
            r8.endReplaceGroup()
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            java.lang.Object r14 = r49.getTargetState()
            androidx.compose.material3.internal.InputPhase r14 = (androidx.compose.material3.internal.InputPhase) r14
            r15 = -2036730335(0xffffffff8699f621, float:-5.791386E-35)
            r8.startReplaceGroup(r15)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r12)
            boolean r15 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r15 == 0) goto L_0x0470
            r15 = -2036730335(0xffffffff8699f621, float:-5.791386E-35)
            r50 = r0
            java.lang.String r0 = "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:356)"
            r51 = r14
            r14 = 0
            androidx.compose.runtime.ComposerKt.traceEventStart(r15, r14, r11, r0)
            goto L_0x0474
        L_0x0470:
            r50 = r0
            r51 = r14
        L_0x0474:
            int[] r0 = androidx.compose.material3.internal.TextFieldImplKt.WhenMappings.$EnumSwitchMapping$1
            int r14 = r51.ordinal()
            r0 = r0[r14]
            r14 = 1
            if (r0 == r14) goto L_0x048e
            r14 = 2
            if (r0 == r14) goto L_0x048c
            r14 = 3
            if (r0 != r14) goto L_0x0486
            goto L_0x048e
        L_0x0486:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x048c:
            r0 = 0
            goto L_0x0490
        L_0x048e:
            r0 = r36
        L_0x0490:
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto L_0x0499
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0499:
            r8.endReplaceGroup()
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            androidx.compose.animation.core.Transition$Segment r14 = r49.getSegment()
            r21 = 0
            java.lang.Integer r15 = java.lang.Integer.valueOf(r21)
            java.lang.Object r4 = r4.invoke(r14, r8, r15)
            androidx.compose.animation.core.FiniteAnimationSpec r4 = (androidx.compose.animation.core.FiniteAnimationSpec) r4
            java.lang.String r14 = "LabelProgress"
            r15 = 196608(0x30000, float:2.75506E-40)
            r51 = r0
            r52 = r4
            r55 = r8
            r54 = r14
            r56 = r15
            androidx.compose.runtime.State r0 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r49, r50, r51, r52, r53, r54, r55, r56)
            r8 = r49
            r4 = r55
            r14 = r56
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1 r15 = androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1.INSTANCE
            kotlin.jvm.functions.Function3 r15 = (kotlin.jvm.functions.Function3) r15
            r14 = -1338768149(0xffffffffb03404eb, float:-6.549061E-10)
            java.lang.String r11 = "CC(animateFloat)P(2)1966@80444L78:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r14, r11)
            kotlin.jvm.internal.FloatCompanionObject r11 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r11 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r11)
            r14 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r14, r3)
            java.lang.Object r14 = r8.getCurrentState()
            androidx.compose.material3.internal.InputPhase r14 = (androidx.compose.material3.internal.InputPhase) r14
            r40 = r0
            r0 = 1435837472(0x55952420, float:2.04977985E13)
            r4.startReplaceGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r12)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x050e
            r0 = 1435837472(0x55952420, float:2.04977985E13)
            r49 = r8
            java.lang.String r8 = "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:386)"
            r53 = r11
            r50 = r14
            r11 = 0
            r14 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r11, r14, r8)
            goto L_0x0514
        L_0x050e:
            r49 = r8
            r53 = r11
            r50 = r14
        L_0x0514:
            int[] r0 = androidx.compose.material3.internal.TextFieldImplKt.WhenMappings.$EnumSwitchMapping$1
            int r8 = r50.ordinal()
            r0 = r0[r8]
            r14 = 1
            if (r0 == r14) goto L_0x0530
            r14 = 2
            if (r0 == r14) goto L_0x052d
            r14 = 3
            if (r0 != r14) goto L_0x0527
        L_0x0525:
            r0 = 0
            goto L_0x0532
        L_0x0527:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x052d:
            if (r34 == 0) goto L_0x0530
            goto L_0x0525
        L_0x0530:
            r0 = r36
        L_0x0532:
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x053b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x053b:
            r4.endReplaceGroup()
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            java.lang.Object r8 = r49.getTargetState()
            androidx.compose.material3.internal.InputPhase r8 = (androidx.compose.material3.internal.InputPhase) r8
            r11 = 1435837472(0x55952420, float:2.04977985E13)
            r4.startReplaceGroup(r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r12)
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x0566
            r11 = 1435837472(0x55952420, float:2.04977985E13)
            java.lang.String r14 = "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:386)"
            r50 = r0
            r51 = r8
            r0 = 0
            r8 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r11, r0, r8, r14)
            goto L_0x056a
        L_0x0566:
            r50 = r0
            r51 = r8
        L_0x056a:
            int[] r0 = androidx.compose.material3.internal.TextFieldImplKt.WhenMappings.$EnumSwitchMapping$1
            int r8 = r51.ordinal()
            r0 = r0[r8]
            r14 = 1
            if (r0 == r14) goto L_0x0586
            r14 = 2
            if (r0 == r14) goto L_0x0583
            r14 = 3
            if (r0 != r14) goto L_0x057d
        L_0x057b:
            r0 = 0
            goto L_0x0588
        L_0x057d:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0583:
            if (r34 == 0) goto L_0x0586
            goto L_0x057b
        L_0x0586:
            r0 = r36
        L_0x0588:
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x0591
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0591:
            r4.endReplaceGroup()
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            androidx.compose.animation.core.Transition$Segment r8 = r49.getSegment()
            r21 = 0
            java.lang.Integer r11 = java.lang.Integer.valueOf(r21)
            java.lang.Object r8 = r15.invoke(r8, r4, r11)
            androidx.compose.animation.core.FiniteAnimationSpec r8 = (androidx.compose.animation.core.FiniteAnimationSpec) r8
            java.lang.String r11 = "PlaceholderOpacity"
            r51 = r0
            r55 = r4
            r52 = r8
            r54 = r11
            r56 = 196608(0x30000, float:2.75506E-40)
            androidx.compose.runtime.State r0 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r49, r50, r51, r52, r53, r54, r55, r56)
            r8 = r49
            r14 = r56
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1 r11 = androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1.INSTANCE
            kotlin.jvm.functions.Function3 r11 = (kotlin.jvm.functions.Function3) r11
            r15 = -1338768149(0xffffffffb03404eb, float:-6.549061E-10)
            java.lang.String r14 = "CC(animateFloat)P(2)1966@80444L78:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r15, r14)
            kotlin.jvm.internal.FloatCompanionObject r14 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r14 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r14)
            r15 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r15, r3)
            java.lang.Object r15 = r8.getCurrentState()
            androidx.compose.material3.internal.InputPhase r15 = (androidx.compose.material3.internal.InputPhase) r15
            r8 = 1128033978(0x433c6eba, float:188.43253)
            r4.startReplaceGroup(r8)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r12)
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x05fe
            r8 = 1128033978(0x433c6eba, float:188.43253)
            r53 = r14
            java.lang.String r14 = "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:398)"
            r50 = r15
            r2 = -1
            r15 = 0
            androidx.compose.runtime.ComposerKt.traceEventStart(r8, r15, r2, r14)
            goto L_0x0602
        L_0x05fe:
            r53 = r14
            r50 = r15
        L_0x0602:
            int[] r2 = androidx.compose.material3.internal.TextFieldImplKt.WhenMappings.$EnumSwitchMapping$1
            int r8 = r50.ordinal()
            r2 = r2[r8]
            r14 = 1
            if (r2 == r14) goto L_0x061e
            r14 = 2
            if (r2 == r14) goto L_0x061a
            r14 = 3
            if (r2 != r14) goto L_0x0614
            goto L_0x061e
        L_0x0614:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x061a:
            if (r34 == 0) goto L_0x061e
            r2 = 0
            goto L_0x0620
        L_0x061e:
            r2 = r36
        L_0x0620:
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x0629
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0629:
            r4.endReplaceGroup()
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            java.lang.Object r8 = r49.getTargetState()
            androidx.compose.material3.internal.InputPhase r8 = (androidx.compose.material3.internal.InputPhase) r8
            r14 = 1128033978(0x433c6eba, float:188.43253)
            r4.startReplaceGroup(r14)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r12)
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto L_0x0654
            r14 = 1128033978(0x433c6eba, float:188.43253)
            java.lang.String r15 = "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:398)"
            r50 = r2
            r51 = r8
            r2 = 0
            r8 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r2, r8, r15)
            goto L_0x0658
        L_0x0654:
            r50 = r2
            r51 = r8
        L_0x0658:
            int[] r2 = androidx.compose.material3.internal.TextFieldImplKt.WhenMappings.$EnumSwitchMapping$1
            int r8 = r51.ordinal()
            r2 = r2[r8]
            r14 = 1
            if (r2 == r14) goto L_0x0674
            r14 = 2
            if (r2 == r14) goto L_0x0670
            r14 = 3
            if (r2 != r14) goto L_0x066a
            goto L_0x0674
        L_0x066a:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0670:
            if (r34 == 0) goto L_0x0674
            r14 = 0
            goto L_0x0676
        L_0x0674:
            r14 = r36
        L_0x0676:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x067f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x067f:
            r4.endReplaceGroup()
            java.lang.Float r2 = java.lang.Float.valueOf(r14)
            androidx.compose.animation.core.Transition$Segment r8 = r49.getSegment()
            r21 = 0
            java.lang.Integer r14 = java.lang.Integer.valueOf(r21)
            java.lang.Object r8 = r11.invoke(r8, r4, r14)
            androidx.compose.animation.core.FiniteAnimationSpec r8 = (androidx.compose.animation.core.FiniteAnimationSpec) r8
            java.lang.String r11 = "PrefixSuffixOpacity"
            r51 = r2
            r55 = r4
            r52 = r8
            r54 = r11
            r56 = 196608(0x30000, float:2.75506E-40)
            androidx.compose.runtime.State r2 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r49, r50, r51, r52, r53, r54, r55, r56)
            r8 = r49
            r14 = r56
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1 r11 = androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1.INSTANCE
            kotlin.jvm.functions.Function3 r11 = (kotlin.jvm.functions.Function3) r11
            r15 = -1939694975(0xffffffff8c629a81, float:-1.7456901E-31)
            java.lang.String r14 = "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r15, r14)
            java.lang.Object r14 = r8.getTargetState()
            androidx.compose.material3.internal.InputPhase r14 = (androidx.compose.material3.internal.InputPhase) r14
            r15 = -107432127(0xfffffffff998b741, float:-9.911824E34)
            r4.startReplaceGroup(r15)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r12)
            boolean r34 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r34 == 0) goto L_0x06df
            r49 = r8
            java.lang.String r8 = "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:410)"
            r34 = r5
            r50 = r14
            r5 = -1
            r14 = 0
            androidx.compose.runtime.ComposerKt.traceEventStart(r15, r14, r5, r8)
            goto L_0x06e5
        L_0x06df:
            r34 = r5
            r49 = r8
            r50 = r14
        L_0x06e5:
            int[] r5 = androidx.compose.material3.internal.TextFieldImplKt.WhenMappings.$EnumSwitchMapping$1
            int r8 = r50.ordinal()
            r5 = r5[r8]
            r14 = 1
            if (r5 != r14) goto L_0x06f3
            r41 = r37
            goto L_0x06f5
        L_0x06f3:
            r41 = r30
        L_0x06f5:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x06fe
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x06fe:
            r4.endReplaceGroup()
            androidx.compose.ui.graphics.colorspace.ColorSpace r5 = androidx.compose.ui.graphics.Color.m4243getColorSpaceimpl(r41)
            r8 = 1918408083(0x72589593, float:4.2898935E30)
            java.lang.String r14 = "CC(remember):Transition.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r8, r14)
            boolean r8 = r4.changed((java.lang.Object) r5)
            java.lang.Object r14 = r4.rememberedValue()
            if (r8 != 0) goto L_0x071f
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r14 != r8) goto L_0x072f
        L_0x071f:
            androidx.compose.ui.graphics.Color$Companion r8 = androidx.compose.ui.graphics.Color.Companion
            kotlin.jvm.functions.Function1 r8 = androidx.compose.animation.ColorVectorConverterKt.getVectorConverter(r8)
            java.lang.Object r5 = r8.invoke(r5)
            r14 = r5
            androidx.compose.animation.core.TwoWayConverter r14 = (androidx.compose.animation.core.TwoWayConverter) r14
            r4.updateRememberedValue(r14)
        L_0x072f:
            androidx.compose.animation.core.TwoWayConverter r14 = (androidx.compose.animation.core.TwoWayConverter) r14
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r5 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r5, r3)
            java.lang.Object r5 = r49.getCurrentState()
            androidx.compose.material3.internal.InputPhase r5 = (androidx.compose.material3.internal.InputPhase) r5
            r4.startReplaceGroup(r15)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r12)
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x0758
            java.lang.String r8 = "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:410)"
            r50 = r5
            r53 = r14
            r5 = 0
            r14 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r15, r5, r14, r8)
            goto L_0x075c
        L_0x0758:
            r50 = r5
            r53 = r14
        L_0x075c:
            int[] r5 = androidx.compose.material3.internal.TextFieldImplKt.WhenMappings.$EnumSwitchMapping$1
            int r8 = r50.ordinal()
            r5 = r5[r8]
            r14 = 1
            if (r5 != r14) goto L_0x076a
            r41 = r37
            goto L_0x076c
        L_0x076a:
            r41 = r30
        L_0x076c:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0775
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0775:
            r4.endReplaceGroup()
            androidx.compose.ui.graphics.Color r5 = androidx.compose.ui.graphics.Color.m4229boximpl(r41)
            java.lang.Object r8 = r49.getTargetState()
            androidx.compose.material3.internal.InputPhase r8 = (androidx.compose.material3.internal.InputPhase) r8
            r4.startReplaceGroup(r15)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r12)
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto L_0x079a
            java.lang.String r14 = "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:410)"
            r50 = r5
            r51 = r8
            r5 = 0
            r8 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r15, r5, r8, r14)
            goto L_0x079e
        L_0x079a:
            r50 = r5
            r51 = r8
        L_0x079e:
            int[] r5 = androidx.compose.material3.internal.TextFieldImplKt.WhenMappings.$EnumSwitchMapping$1
            int r8 = r51.ordinal()
            r5 = r5[r8]
            r14 = 1
            if (r5 != r14) goto L_0x07ac
            r14 = r37
            goto L_0x07ae
        L_0x07ac:
            r14 = r30
        L_0x07ae:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x07b7
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x07b7:
            r4.endReplaceGroup()
            androidx.compose.ui.graphics.Color r5 = androidx.compose.ui.graphics.Color.m4229boximpl(r14)
            androidx.compose.animation.core.Transition$Segment r8 = r49.getSegment()
            r21 = 0
            java.lang.Integer r14 = java.lang.Integer.valueOf(r21)
            java.lang.Object r8 = r11.invoke(r8, r4, r14)
            androidx.compose.animation.core.FiniteAnimationSpec r8 = (androidx.compose.animation.core.FiniteAnimationSpec) r8
            java.lang.String r11 = "LabelTextStyleColor"
            r55 = r4
            r51 = r5
            r52 = r8
            r54 = r11
            r56 = 196608(0x30000, float:2.75506E-40)
            androidx.compose.runtime.State r4 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r49, r50, r51, r52, r53, r54, r55, r56)
            r8 = r49
            r5 = r55
            r14 = r56
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1 r11 = androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1.INSTANCE
            kotlin.jvm.functions.Function3 r11 = (kotlin.jvm.functions.Function3) r11
            r15 = -1939694975(0xffffffff8c629a81, float:-1.7456901E-31)
            java.lang.String r14 = "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r15, r14)
            java.lang.Object r14 = r8.getTargetState()
            androidx.compose.material3.internal.InputPhase r14 = (androidx.compose.material3.internal.InputPhase) r14
            r14 = 1023351670(0x3cff1b76, float:0.031141024)
            r5.startReplaceGroup(r14)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r12)
            boolean r15 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r15 == 0) goto L_0x0817
            java.lang.String r15 = "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:421)"
            r30 = r4
            r49 = r8
            r4 = 0
            r8 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r4, r8, r15)
            goto L_0x081b
        L_0x0817:
            r30 = r4
            r49 = r8
        L_0x081b:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0824
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0824:
            r5.endReplaceGroup()
            androidx.compose.ui.graphics.colorspace.ColorSpace r4 = androidx.compose.ui.graphics.Color.m4243getColorSpaceimpl(r16)
            r8 = 1918408083(0x72589593, float:4.2898935E30)
            java.lang.String r15 = "CC(remember):Transition.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r8, r15)
            boolean r8 = r5.changed((java.lang.Object) r4)
            java.lang.Object r15 = r5.rememberedValue()
            if (r8 != 0) goto L_0x0845
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r15 != r8) goto L_0x0855
        L_0x0845:
            androidx.compose.ui.graphics.Color$Companion r8 = androidx.compose.ui.graphics.Color.Companion
            kotlin.jvm.functions.Function1 r8 = androidx.compose.animation.ColorVectorConverterKt.getVectorConverter(r8)
            java.lang.Object r4 = r8.invoke(r4)
            r15 = r4
            androidx.compose.animation.core.TwoWayConverter r15 = (androidx.compose.animation.core.TwoWayConverter) r15
            r5.updateRememberedValue(r15)
        L_0x0855:
            androidx.compose.animation.core.TwoWayConverter r15 = (androidx.compose.animation.core.TwoWayConverter) r15
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r4 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r4, r3)
            java.lang.Object r3 = r49.getCurrentState()
            androidx.compose.material3.internal.InputPhase r3 = (androidx.compose.material3.internal.InputPhase) r3
            r5.startReplaceGroup(r14)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r12)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0879
            java.lang.String r3 = "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:421)"
            r4 = 0
            r8 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r4, r8, r3)
        L_0x0879:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0882
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0882:
            r5.endReplaceGroup()
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m4229boximpl(r16)
            java.lang.Object r4 = r49.getTargetState()
            androidx.compose.material3.internal.InputPhase r4 = (androidx.compose.material3.internal.InputPhase) r4
            r5.startReplaceGroup(r14)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r12)
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x08a3
            java.lang.String r4 = "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:421)"
            r8 = -1
            r12 = 0
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r12, r8, r4)
            goto L_0x08a4
        L_0x08a3:
            r12 = 0
        L_0x08a4:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x08ad
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x08ad:
            r5.endReplaceGroup()
            androidx.compose.ui.graphics.Color r4 = androidx.compose.ui.graphics.Color.m4229boximpl(r16)
            androidx.compose.animation.core.Transition$Segment r8 = r49.getSegment()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.Object r8 = r11.invoke(r8, r5, r12)
            androidx.compose.animation.core.FiniteAnimationSpec r8 = (androidx.compose.animation.core.FiniteAnimationSpec) r8
            java.lang.String r11 = "LabelContentColor"
            r50 = r3
            r51 = r4
            r55 = r5
            r52 = r8
            r54 = r11
            r53 = r15
            r56 = 196608(0x30000, float:2.75506E-40)
            androidx.compose.runtime.State r3 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r49, r50, r51, r52, r53, r54, r55, r56)
            r4 = r55
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r5 = -571896332(0xffffffffdde98df4, float:-2.10367196E18)
            java.lang.String r8 = "CP(1,2)155@6472L107,172@7259L108:TextFieldImpl.kt#mqatfk"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r5, r8)
            java.lang.Object r5 = r40.getValue()
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            r8 = -156998101(0xfffffffff6a4662b, float:-1.6672049E33)
            r4.startReplaceGroup(r8)
            java.lang.String r8 = "*138@5668L506"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r8)
            r8 = 54
            if (r48 != 0) goto L_0x0906
            r11 = r5
            r3 = r27
            r5 = r32
            r12 = 0
            goto L_0x092d
        L_0x0906:
            androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1 r11 = new androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
            r54 = r48
            r53 = r3
            r52 = r5
            r49 = r11
            r50 = r27
            r56 = r30
            r51 = r32
            r55 = r33
            r49.<init>(r50, r51, r52, r53, r54, r55, r56)
            r12 = r49
            r3 = r50
            r5 = r51
            r11 = r52
            r14 = -1236585568(0xffffffffb64b33a0, float:-3.0279407E-6)
            r15 = 1
            androidx.compose.runtime.internal.ComposableLambda r12 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r14, r15, r12, r4, r8)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
        L_0x092d:
            r4.endReplaceGroup()
            r14 = r28
            long r15 = r1.m2655placeholderColorXeAY9LY$material3_release(r7, r9, r14)
            r8 = -156971732(0xfffffffff6a4cd2c, float:-1.6712853E33)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r8, r13)
            java.lang.Object r8 = r4.rememberedValue()
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            r50 = r3
            java.lang.Object r3 = r17.getEmpty()
            if (r8 != r3) goto L_0x095c
            androidx.compose.runtime.SnapshotMutationPolicy r3 = androidx.compose.runtime.SnapshotStateKt.structuralEqualityPolicy()
            androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$showPlaceholder$2$1 r8 = new androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$showPlaceholder$2$1
            r8.<init>(r0)
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            androidx.compose.runtime.State r8 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r3, r8)
            r4.updateRememberedValue(r8)
        L_0x095c:
            androidx.compose.runtime.State r8 = (androidx.compose.runtime.State) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r3 = -156965270(0xfffffffff6a4e66a, float:-1.6722852E33)
            r4.startReplaceGroup(r3)
            java.lang.String r3 = "160@6765L362"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r3)
            if (r23 == 0) goto L_0x09a4
            r3 = r57
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 != 0) goto L_0x09a4
            boolean r3 = CommonDecorationBox$lambda$15$lambda$7(r8)
            if (r3 == 0) goto L_0x09a4
            androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1 r3 = new androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
            r53 = r50
            r50 = r0
            r49 = r3
            r51 = r15
            r54 = r23
            r49.<init>(r50, r51, r53, r54)
            r8 = r49
            r3 = r53
            r0 = r54
            r15 = -660524084(0xffffffffd8a133cc, float:-1.4179507E15)
            r56 = r0
            r50 = r3
            r0 = 54
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r8 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r15, r3, r8, r4, r0)
            kotlin.jvm.functions.Function3 r8 = (kotlin.jvm.functions.Function3) r8
            goto L_0x09a7
        L_0x09a4:
            r56 = r23
            r8 = 0
        L_0x09a7:
            r4.endReplaceGroup()
            long r15 = r1.m2656prefixColorXeAY9LY$material3_release(r7, r9, r14)
            r0 = -156946547(0xfffffffff6a52f8d, float:-1.6751825E33)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r0, r13)
            java.lang.Object r0 = r4.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r0 != r3) goto L_0x09d2
            androidx.compose.runtime.SnapshotMutationPolicy r0 = androidx.compose.runtime.SnapshotStateKt.structuralEqualityPolicy()
            androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$showPrefixSuffix$2$1 r3 = new androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$showPrefixSuffix$2$1
            r3.<init>(r2)
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            androidx.compose.runtime.State r0 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r0, r3)
            r4.updateRememberedValue(r0)
        L_0x09d2:
            androidx.compose.runtime.State r0 = (androidx.compose.runtime.State) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r3 = -156940524(0xfffffffff6a54714, float:-1.6761145E33)
            r4.startReplaceGroup(r3)
            java.lang.String r3 = "177@7507L341"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r3)
            if (r18 == 0) goto L_0x0a11
            boolean r3 = CommonDecorationBox$lambda$15$lambda$9(r0)
            if (r3 == 0) goto L_0x0a11
            androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedPrefix$1 r3 = new androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedPrefix$1
            r53 = r50
            r50 = r2
            r49 = r3
            r51 = r15
            r54 = r18
            r49.<init>(r50, r51, r53, r54)
            r3 = r0
            r0 = r49
            r49 = r3
            r3 = r53
            r15 = r54
            r2 = 274398694(0x105afde6, float:4.3188516E-29)
            r18 = r8
            r3 = 54
            r8 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r2, r8, r0, r4, r3)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            goto L_0x0a1c
        L_0x0a11:
            r53 = r50
            r49 = r0
            r50 = r2
            r15 = r18
            r18 = r8
            r0 = 0
        L_0x0a1c:
            r4.endReplaceGroup()
            long r2 = r1.m2657suffixColorXeAY9LY$material3_release(r7, r9, r14)
            r8 = -156921964(0xfffffffff6a58f94, float:-1.6789865E33)
            r4.startReplaceGroup(r8)
            java.lang.String r8 = "191@8087L341"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r8)
            if (r19 == 0) goto L_0x0a56
            boolean r8 = CommonDecorationBox$lambda$15$lambda$9(r49)
            if (r8 == 0) goto L_0x0a56
            androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedSuffix$1 r8 = new androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedSuffix$1
            r51 = r2
            r49 = r8
            r54 = r19
            r49.<init>(r50, r51, r53, r54)
            r3 = r49
            r2 = r54
            r8 = -1526229403(0xffffffffa5079665, float:-1.1760339E-16)
            r49 = r0
            r0 = 54
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r8, r2, r3, r4, r0)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r23 = r3
            goto L_0x0a5c
        L_0x0a56:
            r49 = r0
            r54 = r19
            r23 = 0
        L_0x0a5c:
            r4.endReplaceGroup()
            long r2 = r1.m2654leadingIconColorXeAY9LY$material3_release(r7, r9, r14)
            r0 = -156902962(0xfffffffff6a5d9ce, float:-1.681927E33)
            r4.startReplaceGroup(r0)
            java.lang.String r0 = "*205@8655L61"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r0)
            if (r6 != 0) goto L_0x0a72
            r0 = 0
            goto L_0x0a83
        L_0x0a72:
            androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1 r0 = new androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
            r0.<init>(r2, r6)
            r2 = -130107406(0xfffffffff83eb7f2, float:-1.5472926E34)
            r3 = 54
            r8 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r2, r8, r0, r4, r3)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
        L_0x0a83:
            r4.endReplaceGroup()
            long r2 = r1.m2660trailingIconColorXeAY9LY$material3_release(r7, r9, r14)
            r8 = -156893937(0xfffffffff6a5fd0f, float:-1.6833235E33)
            r4.startReplaceGroup(r8)
            java.lang.String r8 = "*211@8937L62"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r8)
            if (r10 != 0) goto L_0x0a9c
            r50 = r0
            r21 = 0
            goto L_0x0ab1
        L_0x0a9c:
            androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1 r8 = new androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
            r8.<init>(r2, r10)
            r2 = 2079816678(0x7bf77be6, float:2.5700206E36)
            r50 = r0
            r0 = 1
            r3 = 54
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r2, r0, r8, r4, r3)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r21 = r2
        L_0x0ab1:
            r4.endReplaceGroup()
            long r2 = r1.m2658supportingTextColorXeAY9LY$material3_release(r7, r9, r14)
            r0 = -156884470(0xfffffffff6a6220a, float:-1.6847884E33)
            r4.startReplaceGroup(r0)
            java.lang.String r0 = "*217@9228L217"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r0)
            if (r34 != 0) goto L_0x0acb
            r8 = r34
            r14 = 1
            r27 = 0
            goto L_0x0ae0
        L_0x0acb:
            androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedSupporting$1$1 r0 = new androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedSupporting$1$1
            r8 = r34
            r0.<init>(r2, r5, r8)
            r2 = 1263707005(0x4b52a37d, float:1.3804413E7)
            r3 = 54
            r14 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r2, r14, r0, r4, r3)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r27 = r0
        L_0x0ae0:
            r4.endReplaceGroup()
            int[] r0 = androidx.compose.material3.internal.TextFieldImplKt.WhenMappings.$EnumSwitchMapping$0
            int r2 = r44.ordinal()
            r0 = r0[r2]
            if (r0 == r14) goto L_0x0ba9
            r14 = 2
            if (r0 == r14) goto L_0x0aff
            r0 = -565271199(0xffffffffde4ea561, float:-3.7226036E18)
            r4.startReplaceGroup(r0)
            r4.endReplaceGroup()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r5 = r61
            goto L_0x0bfe
        L_0x0aff:
            r0 = -567018607(0xffffffffde33fb91, float:-3.24227975E18)
            r4.startReplaceGroup(r0)
            java.lang.String r0 = "253@10659L38,254@10766L314,275@11639L463,264@11098L1286"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r0)
            r0 = -156837817(0xfffffffff6a6d847, float:-1.6920076E33)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r0, r13)
            java.lang.Object r0 = r4.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r0 != r2) goto L_0x0b2f
            androidx.compose.ui.geometry.Size$Companion r0 = androidx.compose.ui.geometry.Size.Companion
            long r2 = r0.m4065getZeroNHjbRc()
            androidx.compose.ui.geometry.Size r0 = androidx.compose.ui.geometry.Size.m4044boximpl(r2)
            r2 = 0
            r14 = 2
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r2, r14, r2)
            r4.updateRememberedValue(r0)
        L_0x0b2f:
            androidx.compose.runtime.MutableState r0 = (androidx.compose.runtime.MutableState) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$borderContainerWithId$1 r2 = new androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$borderContainerWithId$1
            r3 = r59
            r5 = r61
            r2.<init>(r0, r3, r5)
            r14 = 157291737(0x96014d9, float:2.6972822E-33)
            r1 = 54
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r14, r3, r2, r4, r1)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            r16 = r2
            androidx.compose.ui.Modifier r16 = (androidx.compose.ui.Modifier) r16
            r2 = -156806032(0xfffffffff6a75470, float:-1.6969261E33)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r2, r13)
            boolean r2 = r4.changed((float) r11)
            java.lang.Object r3 = r4.rememberedValue()
            if (r2 != 0) goto L_0x0b67
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x0b72
        L_0x0b67:
            androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$1$1 r2 = new androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$1$1
            r2.<init>(r11, r0)
            r3 = r2
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r4.updateRememberedValue(r3)
        L_0x0b72:
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r39 = 3
            int r0 = r26 >> 3
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | 6
            int r2 = r25 << 21
            r13 = 234881024(0xe000000, float:1.5777218E-30)
            r2 = r2 & r13
            r31 = r0 | r2
            int r0 = r25 >> 6
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r32 = r0 | 48
            r17 = r46
            r22 = r49
            r20 = r50
            r29 = r59
            r26 = r3
            r30 = r4
            r25 = r11
            r19 = r12
            r28 = r27
            r27 = r1
            androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextFieldLayout(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            r4.endReplaceGroup()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x0bfe
        L_0x0ba9:
            r0 = r49
            r20 = r50
            r5 = r61
            r19 = r18
            r18 = r12
            r1 = -568105095(0xffffffffde236779, float:-2.9436282E18)
            r4.startReplaceGroup(r1)
            java.lang.String r1 = "228@9583L167,234@9768L769"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r1)
            androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$containerWithId$1 r1 = new androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$containerWithId$1
            r1.<init>(r5)
            r2 = 1750327932(0x6853e27c, float:4.002389E24)
            r3 = 54
            r14 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r2, r14, r1, r4, r3)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            r16 = r2
            androidx.compose.ui.Modifier r16 = (androidx.compose.ui.Modifier) r16
            r39 = 3
            int r2 = r26 >> 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            r2 = r2 | 6
            int r3 = r25 << 21
            r12 = 234881024(0xe000000, float:1.5777218E-30)
            r3 = r3 & r12
            r30 = r2 | r3
            int r2 = r25 >> 9
            r2 = r2 & 896(0x380, float:1.256E-42)
            r31 = r2 | 6
            r17 = r46
            r28 = r59
            r22 = r0
            r26 = r1
            r29 = r4
            r25 = r11
            androidx.compose.material3.TextFieldKt.TextFieldLayout(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            r4.endReplaceGroup()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x0bfe:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0c0d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0c0d:
            r13 = r7
            r11 = r8
            r14 = r9
            r8 = r10
            r9 = r15
            r12 = r24
            r10 = r54
            r7 = r6
            r6 = r56
        L_0x0c19:
            androidx.compose.runtime.ScopeUpdateScope r0 = r4.endRestartGroup()
            if (r0 == 0) goto L_0x0c46
            r1 = r0
            androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$4 r0 = new androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$4
            r2 = r45
            r3 = r46
            r4 = r47
            r15 = r58
            r16 = r59
            r17 = r60
            r19 = r63
            r20 = r64
            r21 = r65
            r43 = r1
            r18 = r5
            r1 = r44
            r5 = r48
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r43
            r1.updateScope(r0)
        L_0x0c46:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.TextFieldImplKt.CommonDecorationBox(androidx.compose.material3.internal.TextFieldType, java.lang.String, kotlin.jvm.functions.Function2, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.foundation.layout.PaddingValues, androidx.compose.material3.TextFieldColors, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: Decoration-3J-VO9M  reason: not valid java name */
    public static final void m2994Decoration3JVO9M(long j, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function22;
        TextStyle textStyle2;
        long j2;
        Composer startRestartGroup = composer.startRestartGroup(1208685580);
        ComposerKt.sourceInformation(startRestartGroup, "C(Decoration)P(1:c#ui.graphics.Color,2)298@12599L62:TextFieldImpl.kt#mqatfk");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed((Object) textStyle) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1208685580, i2, -1, "androidx.compose.material3.internal.Decoration (TextFieldImpl.kt:298)");
            }
            long j3 = j;
            TextStyle textStyle3 = textStyle;
            Function2<? super Composer, ? super Integer, Unit> function23 = function2;
            ProvideContentColorTextStyleKt.m2920ProvideContentColorTextStyle3JVO9M(j3, textStyle3, function23, startRestartGroup, i2 & 1022);
            j2 = j3;
            textStyle2 = textStyle3;
            function22 = function23;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            function22 = function2;
            textStyle2 = textStyle;
            j2 = j;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextFieldImplKt$Decoration$1(j2, textStyle2, function22, i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Decoration-Iv8Zu3U  reason: not valid java name */
    public static final void m2995DecorationIv8Zu3U(long j, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(660142980);
        ComposerKt.sourceInformation(startRestartGroup, "C(Decoration)P(1:c#ui.graphics.Color)303@12806L84:TextFieldImpl.kt#mqatfk");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(660142980, i2, -1, "androidx.compose.material3.internal.Decoration (TextFieldImpl.kt:303)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) ContentColorKt.getLocalContentColor().provides(Color.m4229boximpl(j)), function2, startRestartGroup, (i2 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextFieldImplKt$Decoration$2(j, function2, i));
        }
    }

    public static final Modifier defaultErrorSemantics(Modifier modifier, boolean z, String str) {
        return z ? SemanticsModifierKt.semantics$default(modifier, false, new TextFieldImplKt$defaultErrorSemantics$1(str), 1, (Object) null) : modifier;
    }

    public static final Modifier textFieldBackground(Modifier modifier, ColorProducer colorProducer, Shape shape) {
        return DrawModifierKt.drawWithCache(modifier, new TextFieldImplKt$textFieldBackground$1(shape, colorProducer));
    }

    public static final int widthOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getWidth();
        }
        return 0;
    }

    public static final int heightOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getHeight();
        }
        return 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: androidx.compose.animation.core.TwoWayConverter} */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x012c, code lost:
        if (r31 != false) goto L_0x0122;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x016e, code lost:
        if (r31 != false) goto L_0x0165;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x022a, code lost:
        if (r31 != false) goto L_0x022f;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0296  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x02e8  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02f5  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x02f8  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0300  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x031c  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0329  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x032c  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0334  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x037d  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0386  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x03d7  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x03e0  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x03fc  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0405  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01db  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0235  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x027e  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x028b  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x028e  */
    /* renamed from: TextFieldTransitionScope-Jy8F4Js  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final void m2996TextFieldTransitionScopeJy8F4Js(androidx.compose.material3.internal.InputPhase r24, long r25, long r27, long r29, boolean r31, kotlin.jvm.functions.Function7<? super androidx.compose.runtime.State<java.lang.Float>, ? super androidx.compose.runtime.State<androidx.compose.ui.graphics.Color>, ? super androidx.compose.runtime.State<androidx.compose.ui.graphics.Color>, ? super androidx.compose.runtime.State<java.lang.Float>, ? super androidx.compose.runtime.State<java.lang.Float>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, int r34) {
        /*
            r6 = r33
            r0 = -1087703202(0xffffffffbf2af75e, float:-0.667837)
            java.lang.String r1 = "CC(TextFieldTransitionScope)P(2,1:c#ui.graphics.Color,5:c#ui.graphics.Color,3:c#ui.graphics.Color,4)349@14528L59,352@14632L334,364@15016L1126,394@16193L363,406@16607L318,418@17028L197,424@17231L150:TextFieldImpl.kt#mqatfk"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r0, r1)
            r0 = r34 & 14
            r0 = r0 | 48
            java.lang.String r1 = "TextFieldInputState"
            r8 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
            r2 = r24
            androidx.compose.animation.core.Transition r0 = androidx.compose.animation.core.TransitionKt.updateTransition(r2, (java.lang.String) r1, (androidx.compose.runtime.Composer) r6, (int) r0, (int) r8)
            androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelProgress$1 r1 = androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelProgress$1.INSTANCE
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r10 = -1338768149(0xffffffffb03404eb, float:-6.549061E-10)
            java.lang.String r11 = "CC(animateFloat)P(2)1966@80444L78:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r10, r11)
            kotlin.jvm.internal.FloatCompanionObject r2 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r4 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r2)
            r12 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            java.lang.String r13 = "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r12, r13)
            java.lang.Object r2 = r0.getCurrentState()
            androidx.compose.material3.internal.InputPhase r2 = (androidx.compose.material3.internal.InputPhase) r2
            r3 = -2036730335(0xffffffff8699f621, float:-5.791386E-35)
            r6.startReplaceGroup(r3)
            java.lang.String r14 = "C:TextFieldImpl.kt#mqatfk"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r14)
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            java.lang.String r7 = "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:356)"
            r15 = -1
            if (r5 == 0) goto L_0x0052
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r8, r15, r7)
        L_0x0052:
            int[] r5 = androidx.compose.material3.internal.TextFieldImplKt.WhenMappings.$EnumSwitchMapping$1
            int r2 = r2.ordinal()
            r2 = r5[r2]
            r5 = 3
            r12 = 2
            r16 = 0
            r10 = 1
            r18 = 1065353216(0x3f800000, float:1.0)
            if (r2 == r10) goto L_0x0071
            if (r2 == r12) goto L_0x006e
            if (r2 != r5) goto L_0x0068
            goto L_0x0071
        L_0x0068:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x006e:
            r2 = r16
            goto L_0x0073
        L_0x0071:
            r2 = r18
        L_0x0073:
            boolean r19 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r19 == 0) goto L_0x007c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x007c:
            r6.endReplaceGroup()
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            java.lang.Object r19 = r0.getTargetState()
            androidx.compose.material3.internal.InputPhase r19 = (androidx.compose.material3.internal.InputPhase) r19
            r6.startReplaceGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r14)
            boolean r20 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r20 == 0) goto L_0x0098
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r8, r15, r7)
        L_0x0098:
            int[] r3 = androidx.compose.material3.internal.TextFieldImplKt.WhenMappings.$EnumSwitchMapping$1
            int r7 = r19.ordinal()
            r3 = r3[r7]
            if (r3 == r10) goto L_0x00b0
            if (r3 == r12) goto L_0x00ad
            if (r3 != r5) goto L_0x00a7
            goto L_0x00b0
        L_0x00a7:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x00ad:
            r3 = r16
            goto L_0x00b2
        L_0x00b0:
            r3 = r18
        L_0x00b2:
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x00bb
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00bb:
            r6.endReplaceGroup()
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            androidx.compose.animation.core.Transition$Segment r7 = r0.getSegment()
            java.lang.Object r1 = r1.invoke(r7, r6, r9)
            androidx.compose.animation.core.FiniteAnimationSpec r1 = (androidx.compose.animation.core.FiniteAnimationSpec) r1
            r7 = r5
            java.lang.String r5 = "LabelProgress"
            r19 = r7
            r7 = 196608(0x30000, float:2.75506E-40)
            r23 = r3
            r3 = r1
            r1 = r2
            r2 = r23
            androidx.compose.runtime.State r19 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r0, r1, r2, r3, r4, r5, r6, r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1 r1 = androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1.INSTANCE
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r2 = -1338768149(0xffffffffb03404eb, float:-6.549061E-10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r2, r11)
            kotlin.jvm.internal.FloatCompanionObject r2 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r4 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r2)
            r2 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r2, r13)
            java.lang.Object r2 = r0.getCurrentState()
            androidx.compose.material3.internal.InputPhase r2 = (androidx.compose.material3.internal.InputPhase) r2
            r3 = 1435837472(0x55952420, float:2.04977985E13)
            r6.startReplaceGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r14)
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            java.lang.String r7 = "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:386)"
            if (r5 == 0) goto L_0x0113
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r8, r15, r7)
        L_0x0113:
            int[] r5 = androidx.compose.material3.internal.TextFieldImplKt.WhenMappings.$EnumSwitchMapping$1
            int r2 = r2.ordinal()
            r2 = r5[r2]
            if (r2 == r10) goto L_0x012f
            if (r2 == r12) goto L_0x012b
            r5 = 3
            if (r2 != r5) goto L_0x0125
        L_0x0122:
            r2 = r16
            goto L_0x0132
        L_0x0125:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x012b:
            r5 = 3
            if (r31 == 0) goto L_0x0130
            goto L_0x0122
        L_0x012f:
            r5 = 3
        L_0x0130:
            r2 = r18
        L_0x0132:
            boolean r21 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r21 == 0) goto L_0x013b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x013b:
            r6.endReplaceGroup()
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            java.lang.Object r21 = r0.getTargetState()
            androidx.compose.material3.internal.InputPhase r21 = (androidx.compose.material3.internal.InputPhase) r21
            r6.startReplaceGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r14)
            boolean r22 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r22 == 0) goto L_0x0157
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r8, r15, r7)
        L_0x0157:
            int[] r3 = androidx.compose.material3.internal.TextFieldImplKt.WhenMappings.$EnumSwitchMapping$1
            int r7 = r21.ordinal()
            r3 = r3[r7]
            if (r3 == r10) goto L_0x0171
            if (r3 == r12) goto L_0x016e
            if (r3 != r5) goto L_0x0168
        L_0x0165:
            r3 = r16
            goto L_0x0173
        L_0x0168:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x016e:
            if (r31 == 0) goto L_0x0171
            goto L_0x0165
        L_0x0171:
            r3 = r18
        L_0x0173:
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x017c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x017c:
            r6.endReplaceGroup()
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            androidx.compose.animation.core.Transition$Segment r7 = r0.getSegment()
            java.lang.Object r1 = r1.invoke(r7, r6, r9)
            androidx.compose.animation.core.FiniteAnimationSpec r1 = (androidx.compose.animation.core.FiniteAnimationSpec) r1
            r21 = r5
            java.lang.String r5 = "PlaceholderOpacity"
            r7 = r3
            r3 = r1
            r1 = r2
            r2 = r7
            r7 = 196608(0x30000, float:2.75506E-40)
            androidx.compose.runtime.State r20 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r0, r1, r2, r3, r4, r5, r6, r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1 r1 = androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1.INSTANCE
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r2 = -1338768149(0xffffffffb03404eb, float:-6.549061E-10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r2, r11)
            kotlin.jvm.internal.FloatCompanionObject r2 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r4 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r2)
            r2 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r2, r13)
            java.lang.Object r2 = r0.getCurrentState()
            androidx.compose.material3.internal.InputPhase r2 = (androidx.compose.material3.internal.InputPhase) r2
            r3 = 1128033978(0x433c6eba, float:188.43253)
            r6.startReplaceGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r14)
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            java.lang.String r11 = "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:398)"
            if (r5 == 0) goto L_0x01d1
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r8, r15, r11)
        L_0x01d1:
            int[] r5 = androidx.compose.material3.internal.TextFieldImplKt.WhenMappings.$EnumSwitchMapping$1
            int r2 = r2.ordinal()
            r2 = r5[r2]
            if (r2 == r10) goto L_0x01ed
            if (r2 == r12) goto L_0x01e7
            r5 = 3
            if (r2 != r5) goto L_0x01e1
            goto L_0x01ee
        L_0x01e1:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x01e7:
            r5 = 3
            if (r31 == 0) goto L_0x01ee
            r2 = r16
            goto L_0x01f0
        L_0x01ed:
            r5 = 3
        L_0x01ee:
            r2 = r18
        L_0x01f0:
            boolean r17 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r17 == 0) goto L_0x01f9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01f9:
            r6.endReplaceGroup()
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            java.lang.Object r17 = r0.getTargetState()
            androidx.compose.material3.internal.InputPhase r17 = (androidx.compose.material3.internal.InputPhase) r17
            r6.startReplaceGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r14)
            boolean r21 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r21 == 0) goto L_0x0215
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r8, r15, r11)
        L_0x0215:
            int[] r3 = androidx.compose.material3.internal.TextFieldImplKt.WhenMappings.$EnumSwitchMapping$1
            int r11 = r17.ordinal()
            r3 = r3[r11]
            if (r3 == r10) goto L_0x022d
            if (r3 == r12) goto L_0x022a
            if (r3 != r5) goto L_0x0224
            goto L_0x022d
        L_0x0224:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x022a:
            if (r31 == 0) goto L_0x022d
            goto L_0x022f
        L_0x022d:
            r16 = r18
        L_0x022f:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0238
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0238:
            r6.endReplaceGroup()
            java.lang.Float r3 = java.lang.Float.valueOf(r16)
            androidx.compose.animation.core.Transition$Segment r5 = r0.getSegment()
            java.lang.Object r1 = r1.invoke(r5, r6, r9)
            androidx.compose.animation.core.FiniteAnimationSpec r1 = (androidx.compose.animation.core.FiniteAnimationSpec) r1
            java.lang.String r5 = "PrefixSuffixOpacity"
            r23 = r3
            r3 = r1
            r1 = r2
            r2 = r23
            androidx.compose.runtime.State r11 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r0, r1, r2, r3, r4, r5, r6, r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1 r1 = androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1.INSTANCE
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r2 = -1939694975(0xffffffff8c629a81, float:-1.7456901E-31)
            java.lang.String r3 = "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r2, r3)
            java.lang.Object r2 = r0.getTargetState()
            androidx.compose.material3.internal.InputPhase r2 = (androidx.compose.material3.internal.InputPhase) r2
            r3 = -107432127(0xfffffffff998b741, float:-9.911824E34)
            r6.startReplaceGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r14)
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            java.lang.String r5 = "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:410)"
            if (r4 == 0) goto L_0x0281
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r8, r15, r5)
        L_0x0281:
            int[] r4 = androidx.compose.material3.internal.TextFieldImplKt.WhenMappings.$EnumSwitchMapping$1
            int r2 = r2.ordinal()
            r2 = r4[r2]
            if (r2 != r10) goto L_0x028e
            r16 = r25
            goto L_0x0290
        L_0x028e:
            r16 = r27
        L_0x0290:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0299
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0299:
            r6.endReplaceGroup()
            androidx.compose.ui.graphics.colorspace.ColorSpace r2 = androidx.compose.ui.graphics.Color.m4243getColorSpaceimpl(r16)
            r4 = 1918408083(0x72589593, float:4.2898935E30)
            java.lang.String r12 = "CC(remember):Transition.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r4, r12)
            boolean r4 = r6.changed((java.lang.Object) r2)
            java.lang.Object r12 = r6.rememberedValue()
            if (r4 != 0) goto L_0x02ba
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r12 != r4) goto L_0x02ca
        L_0x02ba:
            androidx.compose.ui.graphics.Color$Companion r4 = androidx.compose.ui.graphics.Color.Companion
            kotlin.jvm.functions.Function1 r4 = androidx.compose.animation.ColorVectorConverterKt.getVectorConverter(r4)
            java.lang.Object r2 = r4.invoke(r2)
            r12 = r2
            androidx.compose.animation.core.TwoWayConverter r12 = (androidx.compose.animation.core.TwoWayConverter) r12
            r6.updateRememberedValue(r12)
        L_0x02ca:
            r4 = r12
            androidx.compose.animation.core.TwoWayConverter r4 = (androidx.compose.animation.core.TwoWayConverter) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r2 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r2, r13)
            java.lang.Object r2 = r0.getCurrentState()
            androidx.compose.material3.internal.InputPhase r2 = (androidx.compose.material3.internal.InputPhase) r2
            r6.startReplaceGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r14)
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x02eb
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r8, r15, r5)
        L_0x02eb:
            int[] r12 = androidx.compose.material3.internal.TextFieldImplKt.WhenMappings.$EnumSwitchMapping$1
            int r2 = r2.ordinal()
            r2 = r12[r2]
            if (r2 != r10) goto L_0x02f8
            r16 = r25
            goto L_0x02fa
        L_0x02f8:
            r16 = r27
        L_0x02fa:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0303
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0303:
            r6.endReplaceGroup()
            androidx.compose.ui.graphics.Color r2 = androidx.compose.ui.graphics.Color.m4229boximpl(r16)
            java.lang.Object r12 = r0.getTargetState()
            androidx.compose.material3.internal.InputPhase r12 = (androidx.compose.material3.internal.InputPhase) r12
            r6.startReplaceGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r14)
            boolean r16 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r16 == 0) goto L_0x031f
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r8, r15, r5)
        L_0x031f:
            int[] r3 = androidx.compose.material3.internal.TextFieldImplKt.WhenMappings.$EnumSwitchMapping$1
            int r5 = r12.ordinal()
            r3 = r3[r5]
            if (r3 != r10) goto L_0x032c
            r16 = r25
            goto L_0x032e
        L_0x032c:
            r16 = r27
        L_0x032e:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0337
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0337:
            r6.endReplaceGroup()
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m4229boximpl(r16)
            androidx.compose.animation.core.Transition$Segment r5 = r0.getSegment()
            java.lang.Object r1 = r1.invoke(r5, r6, r9)
            androidx.compose.animation.core.FiniteAnimationSpec r1 = (androidx.compose.animation.core.FiniteAnimationSpec) r1
            java.lang.String r5 = "LabelTextStyleColor"
            r23 = r3
            r3 = r1
            r1 = r2
            r2 = r23
            androidx.compose.runtime.State r1 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r0, r1, r2, r3, r4, r5, r6, r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1 r2 = androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1.INSTANCE
            kotlin.jvm.functions.Function3 r2 = (kotlin.jvm.functions.Function3) r2
            r3 = -1939694975(0xffffffff8c629a81, float:-1.7456901E-31)
            java.lang.String r4 = "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r3, r4)
            java.lang.Object r3 = r0.getTargetState()
            androidx.compose.material3.internal.InputPhase r3 = (androidx.compose.material3.internal.InputPhase) r3
            r3 = 1023351670(0x3cff1b76, float:0.031141024)
            r6.startReplaceGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r14)
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            java.lang.String r5 = "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:421)"
            if (r4 == 0) goto L_0x0380
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r8, r15, r5)
        L_0x0380:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0389
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0389:
            r6.endReplaceGroup()
            androidx.compose.ui.graphics.colorspace.ColorSpace r4 = androidx.compose.ui.graphics.Color.m4243getColorSpaceimpl(r29)
            r10 = 1918408083(0x72589593, float:4.2898935E30)
            java.lang.String r12 = "CC(remember):Transition.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r10, r12)
            boolean r10 = r6.changed((java.lang.Object) r4)
            java.lang.Object r12 = r6.rememberedValue()
            if (r10 != 0) goto L_0x03aa
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r12 != r10) goto L_0x03ba
        L_0x03aa:
            androidx.compose.ui.graphics.Color$Companion r10 = androidx.compose.ui.graphics.Color.Companion
            kotlin.jvm.functions.Function1 r10 = androidx.compose.animation.ColorVectorConverterKt.getVectorConverter(r10)
            java.lang.Object r4 = r10.invoke(r4)
            r12 = r4
            androidx.compose.animation.core.TwoWayConverter r12 = (androidx.compose.animation.core.TwoWayConverter) r12
            r6.updateRememberedValue(r12)
        L_0x03ba:
            androidx.compose.animation.core.TwoWayConverter r12 = (androidx.compose.animation.core.TwoWayConverter) r12
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r4 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r4, r13)
            java.lang.Object r4 = r0.getCurrentState()
            androidx.compose.material3.internal.InputPhase r4 = (androidx.compose.material3.internal.InputPhase) r4
            r6.startReplaceGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r14)
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x03da
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r8, r15, r5)
        L_0x03da:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x03e3
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03e3:
            r6.endReplaceGroup()
            androidx.compose.ui.graphics.Color r4 = androidx.compose.ui.graphics.Color.m4229boximpl(r29)
            java.lang.Object r10 = r0.getTargetState()
            androidx.compose.material3.internal.InputPhase r10 = (androidx.compose.material3.internal.InputPhase) r10
            r6.startReplaceGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r14)
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x03ff
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r8, r15, r5)
        L_0x03ff:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0408
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0408:
            r6.endReplaceGroup()
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m4229boximpl(r29)
            androidx.compose.animation.core.Transition$Segment r5 = r0.getSegment()
            java.lang.Object r2 = r2.invoke(r5, r6, r9)
            androidx.compose.animation.core.FiniteAnimationSpec r2 = (androidx.compose.animation.core.FiniteAnimationSpec) r2
            java.lang.String r5 = "LabelContentColor"
            r24 = r0
            r27 = r2
            r26 = r3
            r25 = r4
            r29 = r5
            r30 = r6
            r31 = r7
            r28 = r12
            androidx.compose.runtime.State r0 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r24, r25, r26, r27, r28, r29, r30, r31)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r33)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r33)
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r34 & r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r24 = r32
            r30 = r33
            r27 = r0
            r26 = r1
            r31 = r2
            r29 = r11
            r25 = r19
            r28 = r20
            r24.invoke(r25, r26, r27, r28, r29, r30, r31)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r33)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.TextFieldImplKt.m2996TextFieldTransitionScopeJy8F4Js(androidx.compose.material3.internal.InputPhase, long, long, long, boolean, kotlin.jvm.functions.Function7, androidx.compose.runtime.Composer, int):void");
    }

    /* renamed from: animateBorderStrokeAsState-NuRrP5Q  reason: not valid java name */
    public static final State<BorderStroke> m2999animateBorderStrokeAsStateNuRrP5Q(boolean z, boolean z2, boolean z3, TextFieldColors textFieldColors, float f, float f2, Composer composer, int i) {
        State<Color> state;
        State<Dp> state2;
        boolean z4 = z3;
        Composer composer2 = composer;
        int i2 = i;
        ComposerKt.sourceInformationMarkerStart(composer2, 2047013045, "C(animateBorderStrokeAsState)P(1,4,2!1,3:c#ui.unit.Dp,5:c#ui.unit.Dp)458@18252L73:TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2047013045, i2, -1, "androidx.compose.material3.internal.animateBorderStrokeAsState (TextFieldImpl.kt:441)");
        }
        long r1 = textFieldColors.m2652indicatorColorXeAY9LY$material3_release(z, z2, z4);
        if (z) {
            composer2.startReplaceGroup(1023053998);
            ComposerKt.sourceInformation(composer2, "445@17754L84");
            Composer composer3 = composer;
            state = SingleValueAnimationKt.m123animateColorAsStateeuL9pac(r1, AnimationSpecKt.tween$default(150, 0, (Easing) null, 6, (Object) null), (String) null, (Function1<? super Color, Unit>) null, composer3, 48, 12);
            composer2 = composer3;
            composer2.endReplaceGroup();
        } else {
            composer2.startReplaceGroup(1023165505);
            ComposerKt.sourceInformation(composer2, "447@17868L33");
            state = SnapshotStateKt.rememberUpdatedState(Color.m4229boximpl(r1), composer2, 0);
            composer2.endReplaceGroup();
        }
        State<Color> state3 = state;
        if (z) {
            composer2.startReplaceGroup(1023269417);
            ComposerKt.sourceInformation(composer2, "453@18068L85");
            state2 = AnimateAsStateKt.m140animateDpAsStateAjpBEmI(z4 ? f : f2, AnimationSpecKt.tween$default(150, 0, (Easing) null, 6, (Object) null), (String) null, (Function1<? super Dp, Unit>) null, composer2, 48, 12);
            composer2.endReplaceGroup();
        } else {
            composer2.startReplaceGroup(1023478388);
            ComposerKt.sourceInformation(composer2, "455@18183L46");
            state2 = SnapshotStateKt.rememberUpdatedState(Dp.m7109boximpl(f2), composer2, (i2 >> 15) & 14);
            composer2.endReplaceGroup();
        }
        State<BorderStroke> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(BorderStrokeKt.m275BorderStrokecXLIe8U(state2.getValue().m7125unboximpl(), state3.getValue().m4249unboximpl()), composer2, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return rememberUpdatedState;
    }

    public static final Object getLayoutId(IntrinsicMeasurable intrinsicMeasurable) {
        Object parentData = intrinsicMeasurable.getParentData();
        LayoutIdParentData layoutIdParentData = parentData instanceof LayoutIdParentData ? (LayoutIdParentData) parentData : null;
        if (layoutIdParentData != null) {
            return layoutIdParentData.getLayoutId();
        }
        return null;
    }

    static {
        float f = (float) 16;
        TextFieldPadding = Dp.m7111constructorimpl(f);
        MinFocusedLabelLineHeight = Dp.m7111constructorimpl(f);
        MinSupportingTextLineHeight = Dp.m7111constructorimpl(f);
        float f2 = (float) 48;
        IconDefaultSizeModifier = SizeKt.m829defaultMinSizeVpY3zN4(Modifier.Companion, Dp.m7111constructorimpl(f2), Dp.m7111constructorimpl(f2));
    }

    public static final long getZeroConstraints() {
        return ZeroConstraints;
    }

    public static final float getTextFieldPadding() {
        return TextFieldPadding;
    }

    public static final float getHorizontalIconPadding() {
        return HorizontalIconPadding;
    }

    public static final float getSupportingTopPadding() {
        return SupportingTopPadding;
    }

    public static final float getPrefixSuffixTextPadding() {
        return PrefixSuffixTextPadding;
    }

    public static final float getMinTextLineHeight() {
        return MinTextLineHeight;
    }

    public static final float getMinFocusedLabelLineHeight() {
        return MinFocusedLabelLineHeight;
    }

    public static final float getMinSupportingTextLineHeight() {
        return MinSupportingTextLineHeight;
    }

    public static final Modifier getIconDefaultSizeModifier() {
        return IconDefaultSizeModifier;
    }

    private static final boolean CommonDecorationBox$lambda$15$lambda$7(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean CommonDecorationBox$lambda$15$lambda$9(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
