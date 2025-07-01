package androidx.compose.material3;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.AccessibilityUtilKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.SliderTokens;
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
import androidx.compose.ui.R;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0001\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00102\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020 2\u0019\b\u0002\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170#¢\u0006\u0002\b$2\u0019\b\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170#¢\u0006\u0002\b$2\u0019\b\u0002\u0010&\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170#¢\u0006\u0002\b$H\u0007¢\u0006\u0002\u0010'\u001aä\u0001\u0010\u0016\u001a\u00020\u00172\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0018\u0010+\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)\u0012\u0004\u0012\u00020\u00170#2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00102\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020*0)2\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010.2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020 2\u0019\b\u0002\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170#¢\u0006\u0002\b$2\u0019\b\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170#¢\u0006\u0002\b$2\u0019\b\u0002\u0010&\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170#¢\u0006\u0002\b$2\b\b\u0003\u0010/\u001a\u000200H\u0007¢\u0006\u0002\u00101\u001a\u0010\u0016\u001a\u00020\u00172\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0018\u0010+\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)\u0012\u0004\u0012\u00020\u00170#2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00102\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020*0)2\b\b\u0003\u0010/\u001a\u0002002\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010.2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0007¢\u0006\u0002\u00102\u001a\u0001\u00103\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170#¢\u0006\u0002\b$2\u0017\u0010%\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170#¢\u0006\u0002\b$2\u0017\u0010&\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170#¢\u0006\u0002\b$H\u0003¢\u0006\u0002\u00104\u001as\u00105\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u0002062\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00102\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u00107\u001a\u00020 2\u0019\b\u0002\u00108\u001a\u0013\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00170#¢\u0006\u0002\b$2\u0019\b\u0002\u0010&\u001a\u0013\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00170#¢\u0006\u0002\b$H\u0007¢\u0006\u0002\u00109\u001a³\u0001\u00105\u001a\u00020\u00172\u0006\u0010(\u001a\u00020*2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00170#2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00102\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010.2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u00107\u001a\u00020 2\b\b\u0003\u0010/\u001a\u0002002\u0019\b\u0002\u00108\u001a\u0013\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00170#¢\u0006\u0002\b$2\u0019\b\u0002\u0010&\u001a\u0013\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00170#¢\u0006\u0002\b$2\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020*0)H\u0007¢\u0006\u0002\u0010:\u001a}\u00105\u001a\u00020\u00172\u0006\u0010(\u001a\u00020*2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00170#2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00102\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020*0)2\b\b\u0003\u0010/\u001a\u0002002\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010.2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u00107\u001a\u00020 H\u0007¢\u0006\u0002\u0010;\u001a_\u0010<\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u0002062\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u00107\u001a\u00020 2\u0017\u00108\u001a\u0013\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00170#¢\u0006\u0002\b$2\u0017\u0010&\u001a\u0013\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00170#¢\u0006\u0002\b$H\u0003¢\u0006\u0002\u0010=\u001a\u001d\u0010>\u001a\u00020\u00112\u0006\u0010?\u001a\u00020*2\u0006\u0010@\u001a\u00020*H\u0001¢\u0006\u0002\u0010A\u001a\u001b\u0010>\u001a\u00020\u00112\f\u0010B\u001a\b\u0012\u0004\u0012\u00020*0)H\u0001¢\u0006\u0002\u0010C\u001a \u0010D\u001a\u00020*2\u0006\u0010E\u001a\u00020*2\u0006\u0010F\u001a\u00020*2\u0006\u0010G\u001a\u00020*H\u0002\u001a:\u0010H\u001a\u00020\u00112\u0006\u0010I\u001a\u00020*2\u0006\u0010J\u001a\u00020*2\u0006\u0010K\u001a\u00020\u00112\u0006\u0010L\u001a\u00020*2\u0006\u0010M\u001a\u00020*H\u0002ø\u0001\u0000¢\u0006\u0004\bN\u0010O\u001a0\u0010H\u001a\u00020*2\u0006\u0010I\u001a\u00020*2\u0006\u0010J\u001a\u00020*2\u0006\u0010P\u001a\u00020*2\u0006\u0010L\u001a\u00020*2\u0006\u0010M\u001a\u00020*H\u0002\u001a(\u0010Q\u001a\u00020*2\u0006\u0010R\u001a\u00020*2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020*2\u0006\u0010V\u001a\u00020*H\u0002\u001a\u0010\u0010W\u001a\u00020T2\u0006\u0010/\u001a\u000200H\u0002\u001a5\u0010X\u001a\u0010\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u00020*\u0018\u00010Y*\u00020[2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020_H@ø\u0001\u0000¢\u0006\u0004\b`\u0010a\u001a\u001c\u0010b\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0010H\u0002\u001a,\u0010c\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u0010H\u0003\u001a\u001c\u0010d\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0010H\u0002\u001a\u001c\u0010e\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u0018\u001a\u0002062\u0006\u0010\u001c\u001a\u00020\u0010H\u0002\u001a$\u0010f\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u0018\u001a\u0002062\u0006\u00107\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u0010H\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007\"\u0010\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\n\u0010\u000b\"\u0016\u0010\f\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\r\u0010\u000b\"\u0010\u0010\u000e\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u001e\u0010\u000f\u001a\u00020\u0010*\u00020\u00118@X\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006g"}, d2 = {"SliderRangeTolerance", "", "ThumbHeight", "Landroidx/compose/ui/unit/Dp;", "F", "ThumbSize", "Landroidx/compose/ui/unit/DpSize;", "J", "ThumbTrackGapSize", "ThumbWidth", "getThumbWidth", "()F", "TrackHeight", "getTrackHeight", "TrackInsideCornerSize", "isSpecified", "", "Landroidx/compose/material3/SliderRange;", "isSpecified-If1S1O4$annotations", "(J)V", "isSpecified-If1S1O4", "(J)Z", "RangeSlider", "", "state", "Landroidx/compose/material3/RangeSliderState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/SliderColors;", "startInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "endInteractionSource", "startThumb", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "endThumb", "track", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "value", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "onValueChange", "valueRange", "onValueChangeFinished", "Lkotlin/Function0;", "steps", "", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;ILandroidx/compose/runtime/Composer;III)V", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/runtime/Composer;II)V", "RangeSliderImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/RangeSliderState;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "Slider", "Landroidx/compose/material3/SliderState;", "interactionSource", "thumb", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;ILkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/Composer;III)V", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SliderImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderState;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "SliderRange", "start", "endInclusive", "(FF)J", "range", "(Lkotlin/ranges/ClosedFloatingPointRange;)J", "calcFraction", "a", "b", "pos", "scale", "a1", "b1", "x", "a2", "b2", "scale-ziovWd0", "(FFJFF)J", "x1", "snapValueToTick", "current", "tickFractions", "", "minPx", "maxPx", "stepsToTickFractions", "awaitSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "awaitSlop-8vUncbI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rangeSliderEndThumbSemantics", "rangeSliderPressDragModifier", "rangeSliderStartThumbSemantics", "sliderSemantics", "sliderTapModifier", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
public final class SliderKt {
    private static final double SliderRangeTolerance = 1.0E-4d;
    private static final float ThumbHeight;
    /* access modifiers changed from: private */
    public static final long ThumbSize;
    /* access modifiers changed from: private */
    public static final float ThumbTrackGapSize = SliderTokens.INSTANCE.m3509getActiveHandleLeadingSpaceD9Ej5fM();
    private static final float ThumbWidth;
    private static final float TrackHeight = SliderTokens.INSTANCE.m3519getInactiveTrackHeightD9Ej5fM();
    /* access modifiers changed from: private */
    public static final float TrackInsideCornerSize = Dp.m7111constructorimpl((float) 2);

    /* renamed from: isSpecified-If1S1O4$annotations  reason: not valid java name */
    public static /* synthetic */ void m2495isSpecifiedIf1S1O4$annotations(long j) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:150:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00fb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Slider(float r27, kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r28, androidx.compose.ui.Modifier r29, boolean r30, kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r31, int r32, kotlin.jvm.functions.Function0<kotlin.Unit> r33, androidx.compose.material3.SliderColors r34, androidx.compose.foundation.interaction.MutableInteractionSource r35, androidx.compose.runtime.Composer r36, int r37, int r38) {
        /*
            r10 = r37
            r11 = r38
            r0 = -202044027(0xfffffffff3f50d85, float:-3.8830168E31)
            r1 = r36
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(Slider)P(7,4,3,1,8,6,5)167@8058L8,168@8118L39,179@8458L181,186@8657L122,170@8166L652:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r11 & 1
            if (r2 == 0) goto L_0x001b
            r2 = r10 | 6
            r12 = r27
            goto L_0x002d
        L_0x001b:
            r2 = r10 & 6
            r12 = r27
            if (r2 != 0) goto L_0x002c
            boolean r2 = r1.changed((float) r12)
            if (r2 == 0) goto L_0x0029
            r2 = 4
            goto L_0x002a
        L_0x0029:
            r2 = 2
        L_0x002a:
            r2 = r2 | r10
            goto L_0x002d
        L_0x002c:
            r2 = r10
        L_0x002d:
            r3 = r11 & 2
            if (r3 == 0) goto L_0x0036
            r2 = r2 | 48
            r13 = r28
            goto L_0x0048
        L_0x0036:
            r3 = r10 & 48
            r13 = r28
            if (r3 != 0) goto L_0x0048
            boolean r3 = r1.changedInstance(r13)
            if (r3 == 0) goto L_0x0045
            r3 = 32
            goto L_0x0047
        L_0x0045:
            r3 = 16
        L_0x0047:
            r2 = r2 | r3
        L_0x0048:
            r3 = r11 & 4
            if (r3 == 0) goto L_0x004f
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r4 = r10 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x0062
            r4 = r29
            boolean r5 = r1.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x005e
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r2 = r2 | r5
            goto L_0x0064
        L_0x0062:
            r4 = r29
        L_0x0064:
            r5 = r11 & 8
            if (r5 == 0) goto L_0x006b
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r6 = r10 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x007e
            r6 = r30
            boolean r7 = r1.changed((boolean) r6)
            if (r7 == 0) goto L_0x007a
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r2 = r2 | r7
            goto L_0x0080
        L_0x007e:
            r6 = r30
        L_0x0080:
            r7 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x0099
            r7 = r11 & 16
            if (r7 != 0) goto L_0x0093
            r7 = r31
            boolean r8 = r1.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0095
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0093:
            r7 = r31
        L_0x0095:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r2 = r2 | r8
            goto L_0x009b
        L_0x0099:
            r7 = r31
        L_0x009b:
            r8 = r11 & 32
            r9 = 196608(0x30000, float:2.75506E-40)
            if (r8 == 0) goto L_0x00a3
            r2 = r2 | r9
            goto L_0x00b5
        L_0x00a3:
            r9 = r9 & r10
            if (r9 != 0) goto L_0x00b5
            r9 = r32
            boolean r14 = r1.changed((int) r9)
            if (r14 == 0) goto L_0x00b1
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b3
        L_0x00b1:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b3:
            r2 = r2 | r14
            goto L_0x00b7
        L_0x00b5:
            r9 = r32
        L_0x00b7:
            r14 = r11 & 64
            r15 = 1572864(0x180000, float:2.204052E-39)
            if (r14 == 0) goto L_0x00bf
            r2 = r2 | r15
            goto L_0x00d2
        L_0x00bf:
            r15 = r15 & r10
            if (r15 != 0) goto L_0x00d2
            r15 = r33
            boolean r16 = r1.changedInstance(r15)
            if (r16 == 0) goto L_0x00cd
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cf
        L_0x00cd:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00cf:
            r2 = r2 | r16
            goto L_0x00d4
        L_0x00d2:
            r15 = r33
        L_0x00d4:
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r16 = r10 & r16
            if (r16 != 0) goto L_0x00f0
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x00e9
            r0 = r34
            boolean r17 = r1.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00eb
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ed
        L_0x00e9:
            r0 = r34
        L_0x00eb:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ed:
            r2 = r2 | r17
            goto L_0x00f2
        L_0x00f0:
            r0 = r34
        L_0x00f2:
            r0 = r11 & 256(0x100, float:3.59E-43)
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x00fb
            r2 = r2 | r17
            goto L_0x0111
        L_0x00fb:
            r17 = r10 & r17
            if (r17 != 0) goto L_0x0111
            r17 = r0
            r0 = r35
            boolean r18 = r1.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x010c
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010e
        L_0x010c:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010e:
            r2 = r2 | r18
            goto L_0x0115
        L_0x0111:
            r17 = r0
            r0 = r35
        L_0x0115:
            r18 = 38347923(0x2492493, float:1.4777644E-37)
            r0 = r2 & r18
            r36 = r2
            r2 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r2) goto L_0x0138
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x0128
            goto L_0x0138
        L_0x0128:
            r1.skipToGroupEnd()
            r8 = r34
            r23 = r1
            r3 = r4
            r4 = r6
            r5 = r7
            r6 = r9
            r7 = r15
            r9 = r35
            goto L_0x024d
        L_0x0138:
            r1.startDefaults()
            r0 = r10 & 1
            r18 = -57345(0xffffffffffff1fff, float:NaN)
            r19 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r2 = 1
            if (r0 == 0) goto L_0x0171
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x014d
            goto L_0x0171
        L_0x014d:
            r1.skipToGroupEnd()
            r0 = r11 & 16
            if (r0 == 0) goto L_0x0157
            r0 = r36 & r18
            goto L_0x0159
        L_0x0157:
            r0 = r36
        L_0x0159:
            r3 = r11 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x015f
            r0 = r0 & r19
        L_0x015f:
            r5 = r35
            r3 = r0
            r14 = r4
            r22 = r7
            r19 = r9
            r16 = r15
            r4 = -202044027(0xfffffffff3f50d85, float:-3.8830168E31)
            r0 = r34
        L_0x016e:
            r15 = r6
            goto L_0x01d4
        L_0x0171:
            if (r3 == 0) goto L_0x0178
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r4 = r0
        L_0x0178:
            if (r5 == 0) goto L_0x017b
            r6 = r2
        L_0x017b:
            r0 = r11 & 16
            if (r0 == 0) goto L_0x018a
            r0 = 0
            r3 = 1065353216(0x3f800000, float:1.0)
            kotlin.ranges.ClosedFloatingPointRange r0 = kotlin.ranges.RangesKt.rangeTo((float) r0, (float) r3)
            r3 = r36 & r18
            r7 = r0
            goto L_0x018c
        L_0x018a:
            r3 = r36
        L_0x018c:
            if (r8 == 0) goto L_0x0190
            r0 = 0
            r9 = r0
        L_0x0190:
            if (r14 == 0) goto L_0x0194
            r0 = 0
            r15 = r0
        L_0x0194:
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x01a2
            androidx.compose.material3.SliderDefaults r0 = androidx.compose.material3.SliderDefaults.INSTANCE
            r5 = 6
            androidx.compose.material3.SliderColors r0 = r0.colors(r1, r5)
            r3 = r3 & r19
            goto L_0x01a4
        L_0x01a2:
            r0 = r34
        L_0x01a4:
            if (r17 == 0) goto L_0x01c7
            r5 = -403669397(0xffffffffe7f07e6b, float:-2.2713999E24)
            java.lang.String r8 = "CC(remember):Slider.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r5, r8)
            java.lang.Object r5 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r5 != r8) goto L_0x01c1
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r1.updateRememberedValue(r5)
        L_0x01c1:
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = (androidx.compose.foundation.interaction.MutableInteractionSource) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            goto L_0x01c9
        L_0x01c7:
            r5 = r35
        L_0x01c9:
            r14 = r4
            r22 = r7
            r19 = r9
            r16 = r15
            r4 = -202044027(0xfffffffff3f50d85, float:-3.8830168E31)
            goto L_0x016e
        L_0x01d4:
            r1.endDefaults()
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x01e3
            r6 = -1
            java.lang.String r7 = "androidx.compose.material3.Slider (Slider.kt:169)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r3, r6, r7)
        L_0x01e3:
            androidx.compose.material3.SliderKt$Slider$2 r4 = new androidx.compose.material3.SliderKt$Slider$2
            r4.<init>(r5, r0, r15)
            r6 = 308249025(0x125f81c1, float:7.0526327E-28)
            r7 = 54
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r6, r2, r4, r1, r7)
            r20 = r4
            kotlin.jvm.functions.Function3 r20 = (kotlin.jvm.functions.Function3) r20
            androidx.compose.material3.SliderKt$Slider$3 r4 = new androidx.compose.material3.SliderKt$Slider$3
            r4.<init>(r15, r0)
            r6 = -1843234110(0xffffffff92227ac2, float:-5.1269497E-28)
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r6, r2, r4, r1, r7)
            r21 = r2
            kotlin.jvm.functions.Function3 r21 = (kotlin.jvm.functions.Function3) r21
            r2 = r3 & 14
            r4 = 905969664(0x36000000, float:1.9073486E-6)
            r2 = r2 | r4
            r4 = r3 & 112(0x70, float:1.57E-43)
            r2 = r2 | r4
            r4 = r3 & 896(0x380, float:1.256E-42)
            r2 = r2 | r4
            r4 = r3 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r4
            int r4 = r3 >> 6
            r6 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r4
            r2 = r2 | r6
            r6 = 458752(0x70000, float:6.42848E-40)
            r6 = r6 & r4
            r2 = r2 | r6
            r6 = 3670016(0x380000, float:5.142788E-39)
            r4 = r4 & r6
            r2 = r2 | r4
            int r4 = r3 << 6
            r6 = 29360128(0x1c00000, float:7.052966E-38)
            r4 = r4 & r6
            r24 = r2 | r4
            int r2 = r3 >> 12
            r25 = r2 & 14
            r26 = 0
            r17 = r0
            r23 = r1
            r18 = r5
            Slider(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0241
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0241:
            r3 = r14
            r4 = r15
            r7 = r16
            r8 = r17
            r9 = r18
            r6 = r19
            r5 = r22
        L_0x024d:
            androidx.compose.runtime.ScopeUpdateScope r12 = r23.endRestartGroup()
            if (r12 == 0) goto L_0x0261
            androidx.compose.material3.SliderKt$Slider$4 r0 = new androidx.compose.material3.SliderKt$Slider$4
            r1 = r27
            r2 = r28
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x0261:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.Slider(float, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.ranges.ClosedFloatingPointRange, int, kotlin.jvm.functions.Function0, androidx.compose.material3.SliderColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x02f1  */
    /* JADX WARNING: Removed duplicated region for block: B:193:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x011f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Slider(float r27, kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r28, androidx.compose.ui.Modifier r29, boolean r30, kotlin.jvm.functions.Function0<kotlin.Unit> r31, androidx.compose.material3.SliderColors r32, androidx.compose.foundation.interaction.MutableInteractionSource r33, int r34, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r37, androidx.compose.runtime.Composer r38, int r39, int r40, int r41) {
        /*
            r1 = r27
            r2 = r28
            r12 = r39
            r14 = r41
            r0 = 1191170377(0x46ffd149, float:32744.643)
            r3 = r38
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r0)
            java.lang.String r4 = "C(Slider)P(9,4,3,1,5)256@12184L8,257@12244L39,259@12372L157,266@12578L114,272@12779L92,278@12998L184:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            r4 = r14 & 1
            if (r4 == 0) goto L_0x001d
            r4 = r12 | 6
            goto L_0x002d
        L_0x001d:
            r4 = r12 & 6
            if (r4 != 0) goto L_0x002c
            boolean r4 = r3.changed((float) r1)
            if (r4 == 0) goto L_0x0029
            r4 = 4
            goto L_0x002a
        L_0x0029:
            r4 = 2
        L_0x002a:
            r4 = r4 | r12
            goto L_0x002d
        L_0x002c:
            r4 = r12
        L_0x002d:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x0034
            r4 = r4 | 48
            goto L_0x0044
        L_0x0034:
            r7 = r12 & 48
            if (r7 != 0) goto L_0x0044
            boolean r7 = r3.changedInstance(r2)
            if (r7 == 0) goto L_0x0041
            r7 = 32
            goto L_0x0043
        L_0x0041:
            r7 = 16
        L_0x0043:
            r4 = r4 | r7
        L_0x0044:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x004b
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x005e
        L_0x004b:
            r8 = r12 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x005e
            r8 = r29
            boolean r9 = r3.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x005a
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x005c
        L_0x005a:
            r9 = 128(0x80, float:1.794E-43)
        L_0x005c:
            r4 = r4 | r9
            goto L_0x0060
        L_0x005e:
            r8 = r29
        L_0x0060:
            r9 = r14 & 8
            if (r9 == 0) goto L_0x0067
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x007a
        L_0x0067:
            r10 = r12 & 3072(0xc00, float:4.305E-42)
            if (r10 != 0) goto L_0x007a
            r10 = r30
            boolean r11 = r3.changed((boolean) r10)
            if (r11 == 0) goto L_0x0076
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0078
        L_0x0076:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0078:
            r4 = r4 | r11
            goto L_0x007c
        L_0x007a:
            r10 = r30
        L_0x007c:
            r11 = r14 & 16
            if (r11 == 0) goto L_0x0083
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0096
        L_0x0083:
            r13 = r12 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x0096
            r13 = r31
            boolean r15 = r3.changedInstance(r13)
            if (r15 == 0) goto L_0x0092
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0094
        L_0x0092:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x0094:
            r4 = r4 | r15
            goto L_0x0098
        L_0x0096:
            r13 = r31
        L_0x0098:
            r15 = 196608(0x30000, float:2.75506E-40)
            r15 = r15 & r12
            if (r15 != 0) goto L_0x00b3
            r15 = r14 & 32
            if (r15 != 0) goto L_0x00ac
            r15 = r32
            boolean r16 = r3.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00ae
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b0
        L_0x00ac:
            r15 = r32
        L_0x00ae:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b0:
            r4 = r4 | r16
            goto L_0x00b5
        L_0x00b3:
            r15 = r32
        L_0x00b5:
            r16 = r14 & 64
            r17 = 1572864(0x180000, float:2.204052E-39)
            if (r16 == 0) goto L_0x00c0
            r4 = r4 | r17
            r6 = r33
            goto L_0x00d3
        L_0x00c0:
            r17 = r12 & r17
            r6 = r33
            if (r17 != 0) goto L_0x00d3
            boolean r17 = r3.changed((java.lang.Object) r6)
            if (r17 == 0) goto L_0x00cf
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00cf:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d1:
            r4 = r4 | r17
        L_0x00d3:
            r0 = r14 & 128(0x80, float:1.794E-43)
            r19 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00de
            r4 = r4 | r19
            r5 = r34
            goto L_0x00f1
        L_0x00de:
            r19 = r12 & r19
            r5 = r34
            if (r19 != 0) goto L_0x00f1
            boolean r20 = r3.changed((int) r5)
            if (r20 == 0) goto L_0x00ed
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ef
        L_0x00ed:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ef:
            r4 = r4 | r20
        L_0x00f1:
            r20 = r0
            r0 = r14 & 256(0x100, float:3.59E-43)
            r21 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x00fc
            r4 = r4 | r21
            goto L_0x0112
        L_0x00fc:
            r21 = r12 & r21
            if (r21 != 0) goto L_0x0112
            r21 = r0
            r0 = r35
            boolean r22 = r3.changedInstance(r0)
            if (r22 == 0) goto L_0x010d
            r22 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010f
        L_0x010d:
            r22 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010f:
            r4 = r4 | r22
            goto L_0x0116
        L_0x0112:
            r21 = r0
            r0 = r35
        L_0x0116:
            r0 = r14 & 512(0x200, float:7.175E-43)
            r22 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x011f
            r4 = r4 | r22
            goto L_0x0135
        L_0x011f:
            r22 = r12 & r22
            if (r22 != 0) goto L_0x0135
            r22 = r0
            r0 = r36
            boolean r23 = r3.changedInstance(r0)
            if (r23 == 0) goto L_0x0130
            r23 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0132
        L_0x0130:
            r23 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0132:
            r4 = r4 | r23
            goto L_0x0139
        L_0x0135:
            r22 = r0
            r0 = r36
        L_0x0139:
            r23 = r40 & 6
            if (r23 != 0) goto L_0x0153
            r0 = r14 & 1024(0x400, float:1.435E-42)
            if (r0 != 0) goto L_0x014c
            r0 = r37
            boolean r23 = r3.changed((java.lang.Object) r0)
            if (r23 == 0) goto L_0x014e
            r23 = 4
            goto L_0x0150
        L_0x014c:
            r0 = r37
        L_0x014e:
            r23 = 2
        L_0x0150:
            r23 = r40 | r23
            goto L_0x0157
        L_0x0153:
            r0 = r37
            r23 = r40
        L_0x0157:
            r24 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r4 & r24
            r24 = r4
            r4 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r4) goto L_0x0181
            r0 = r23 & 3
            r4 = 2
            if (r0 != r4) goto L_0x0181
            boolean r0 = r3.getSkipping()
            if (r0 != 0) goto L_0x016f
            goto L_0x0181
        L_0x016f:
            r3.skipToGroupEnd()
            r9 = r35
            r11 = r37
            r0 = r3
            r4 = r10
            r10 = r36
            r7 = r6
            r3 = r8
            r6 = r15
        L_0x017d:
            r8 = r5
            r5 = r13
            goto L_0x02eb
        L_0x0181:
            r3.startDefaults()
            r0 = r12 & 1
            r18 = 0
            r25 = -458753(0xfffffffffff8ffff, float:NaN)
            r4 = 1
            if (r0 == 0) goto L_0x01b2
            boolean r0 = r3.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0195
            goto L_0x01b2
        L_0x0195:
            r3.skipToGroupEnd()
            r0 = r14 & 32
            if (r0 == 0) goto L_0x01a0
            r0 = r24 & r25
            r24 = r0
        L_0x01a0:
            r0 = r14 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x01a6
            r23 = r23 & -15
        L_0x01a6:
            r0 = r35
            r7 = r36
            r9 = r37
            r11 = r23
            r4 = r24
            goto L_0x023c
        L_0x01b2:
            if (r7 == 0) goto L_0x01b9
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r8 = r0
        L_0x01b9:
            if (r9 == 0) goto L_0x01bc
            r10 = r4
        L_0x01bc:
            if (r11 == 0) goto L_0x01c0
            r0 = 0
            r13 = r0
        L_0x01c0:
            r0 = r14 & 32
            if (r0 == 0) goto L_0x01cf
            androidx.compose.material3.SliderDefaults r0 = androidx.compose.material3.SliderDefaults.INSTANCE
            r7 = 6
            androidx.compose.material3.SliderColors r0 = r0.colors(r3, r7)
            r7 = r24 & r25
            r15 = r0
            goto L_0x01d1
        L_0x01cf:
            r7 = r24
        L_0x01d1:
            if (r16 == 0) goto L_0x01f4
            r0 = -403537365(0xffffffffe7f2822b, float:-2.2904277E24)
            java.lang.String r6 = "CC(remember):Slider.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r6)
            java.lang.Object r0 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r0 != r6) goto L_0x01ee
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r3.updateRememberedValue(r0)
        L_0x01ee:
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r6 = r0
        L_0x01f4:
            if (r20 == 0) goto L_0x01f8
            r5 = r18
        L_0x01f8:
            if (r21 == 0) goto L_0x020b
            androidx.compose.material3.SliderKt$Slider$6 r0 = new androidx.compose.material3.SliderKt$Slider$6
            r0.<init>(r6, r15, r10)
            r9 = 54
            r11 = -1756326375(0xffffffff97509619, float:-6.7397875E-25)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r11, r4, r0, r3, r9)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            goto L_0x020d
        L_0x020b:
            r0 = r35
        L_0x020d:
            if (r22 == 0) goto L_0x0222
            androidx.compose.material3.SliderKt$Slider$7 r9 = new androidx.compose.material3.SliderKt$Slider$7
            r9.<init>(r10, r15)
            r11 = 54
            r29 = r0
            r0 = 2083675534(0x7c325d8e, float:3.7045054E36)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r0, r4, r9, r3, r11)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            goto L_0x0226
        L_0x0222:
            r29 = r0
            r0 = r36
        L_0x0226:
            r9 = r14 & 1024(0x400, float:1.435E-42)
            if (r9 == 0) goto L_0x0234
            r9 = 0
            r11 = 1065353216(0x3f800000, float:1.0)
            kotlin.ranges.ClosedFloatingPointRange r9 = kotlin.ranges.RangesKt.rangeTo((float) r9, (float) r11)
            r23 = r23 & -15
            goto L_0x0236
        L_0x0234:
            r9 = r37
        L_0x0236:
            r4 = r7
            r11 = r23
            r7 = r0
            r0 = r29
        L_0x023c:
            r3.endDefaults()
            boolean r20 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r34 = r0
            if (r20 == 0) goto L_0x0252
            java.lang.String r0 = "androidx.compose.material3.Slider (Slider.kt:270)"
            r33 = r6
            r6 = 1191170377(0x46ffd149, float:32744.643)
            androidx.compose.runtime.ComposerKt.traceEventStart(r6, r4, r11, r0)
            goto L_0x0254
        L_0x0252:
            r33 = r6
        L_0x0254:
            r0 = -403520192(0xffffffffe7f2c540, float:-2.2929026E24)
            java.lang.String r6 = "CC(remember):Slider.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r6)
            r0 = 29360128(0x1c00000, float:7.052966E-38)
            r0 = r0 & r4
            r6 = 8388608(0x800000, float:1.17549435E-38)
            if (r0 != r6) goto L_0x0265
            r0 = 1
            goto L_0x0267
        L_0x0265:
            r0 = r18
        L_0x0267:
            r6 = r11 & 14
            r26 = 6
            r6 = r6 ^ 6
            r29 = r0
            r0 = 4
            if (r6 <= r0) goto L_0x0278
            boolean r6 = r3.changed((java.lang.Object) r9)
            if (r6 != 0) goto L_0x027c
        L_0x0278:
            r6 = r11 & 6
            if (r6 != r0) goto L_0x027e
        L_0x027c:
            r18 = 1
        L_0x027e:
            r0 = r29 | r18
            java.lang.Object r6 = r3.rememberedValue()
            if (r0 != 0) goto L_0x028e
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r6 != r0) goto L_0x0296
        L_0x028e:
            androidx.compose.material3.SliderState r6 = new androidx.compose.material3.SliderState
            r6.<init>(r1, r5, r13, r9)
            r3.updateRememberedValue(r6)
        L_0x0296:
            androidx.compose.material3.SliderState r6 = (androidx.compose.material3.SliderState) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r6.setOnValueChangeFinished(r13)
            r6.setOnValueChange$material3_release(r2)
            r6.setValue(r1)
            int r0 = r4 >> 3
            r0 = r0 & 1008(0x3f0, float:1.413E-42)
            int r11 = r4 >> 6
            r16 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r16
            r0 = r0 | r11
            int r4 = r4 >> 9
            r11 = 458752(0x70000, float:6.42848E-40)
            r11 = r11 & r4
            r0 = r0 | r11
            r11 = 3670016(0x380000, float:5.142788E-39)
            r4 = r4 & r11
            r0 = r0 | r4
            r4 = 8
            r11 = 0
            r37 = r0
            r36 = r3
            r38 = r4
            r29 = r6
            r35 = r7
            r30 = r8
            r31 = r10
            r32 = r11
            Slider(r29, r30, r31, r32, r33, r34, r35, r36, r37, r38)
            r6 = r33
            r3 = r34
            r4 = r35
            r0 = r36
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x02e1
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02e1:
            r7 = r10
            r10 = r4
            r4 = r7
            r11 = r9
            r9 = r3
            r7 = r6
            r6 = r15
            r3 = r8
            goto L_0x017d
        L_0x02eb:
            androidx.compose.runtime.ScopeUpdateScope r15 = r0.endRestartGroup()
            if (r15 == 0) goto L_0x02fd
            androidx.compose.material3.SliderKt$Slider$8 r0 = new androidx.compose.material3.SliderKt$Slider$8
            r13 = r40
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x02fd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.Slider(float, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function0, androidx.compose.material3.SliderColors, androidx.compose.foundation.interaction.MutableInteractionSource, int, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.ranges.ClosedFloatingPointRange, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:122:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00f1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Slider(androidx.compose.material3.SliderState r17, androidx.compose.ui.Modifier r18, boolean r19, androidx.compose.material3.SliderColors r20, androidx.compose.foundation.interaction.MutableInteractionSource r21, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r22, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, androidx.compose.runtime.Composer r24, int r25, int r26) {
        /*
            r8 = r25
            r0 = -1303883986(0xffffffffb2484f2e, float:-1.1659536E-8)
            r1 = r24
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Slider)P(4,3,1)339@15682L8,340@15742L39,341@15830L157,348@16036L114,354@16217L188:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            r1 = r26 & 1
            if (r1 == 0) goto L_0x0019
            r1 = r8 | 6
            r10 = r17
            goto L_0x002b
        L_0x0019:
            r1 = r8 & 6
            r10 = r17
            if (r1 != 0) goto L_0x002a
            boolean r1 = r15.changedInstance(r10)
            if (r1 == 0) goto L_0x0027
            r1 = 4
            goto L_0x0028
        L_0x0027:
            r1 = 2
        L_0x0028:
            r1 = r1 | r8
            goto L_0x002b
        L_0x002a:
            r1 = r8
        L_0x002b:
            r2 = r26 & 2
            if (r2 == 0) goto L_0x0032
            r1 = r1 | 48
            goto L_0x0045
        L_0x0032:
            r3 = r8 & 48
            if (r3 != 0) goto L_0x0045
            r3 = r18
            boolean r4 = r15.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0041
            r4 = 32
            goto L_0x0043
        L_0x0041:
            r4 = 16
        L_0x0043:
            r1 = r1 | r4
            goto L_0x0047
        L_0x0045:
            r3 = r18
        L_0x0047:
            r4 = r26 & 4
            if (r4 == 0) goto L_0x004e
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r5 = r8 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x0061
            r5 = r19
            boolean r6 = r15.changed((boolean) r5)
            if (r6 == 0) goto L_0x005d
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r1 = r1 | r6
            goto L_0x0063
        L_0x0061:
            r5 = r19
        L_0x0063:
            r6 = r8 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x007c
            r6 = r26 & 8
            if (r6 != 0) goto L_0x0076
            r6 = r20
            boolean r7 = r15.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0078
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0076:
            r6 = r20
        L_0x0078:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r1 = r1 | r7
            goto L_0x007e
        L_0x007c:
            r6 = r20
        L_0x007e:
            r7 = r26 & 16
            if (r7 == 0) goto L_0x0085
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0098
        L_0x0085:
            r9 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x0098
            r9 = r21
            boolean r11 = r15.changed((java.lang.Object) r9)
            if (r11 == 0) goto L_0x0094
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0094:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r1 = r1 | r11
            goto L_0x009a
        L_0x0098:
            r9 = r21
        L_0x009a:
            r11 = r26 & 32
            r12 = 196608(0x30000, float:2.75506E-40)
            if (r11 == 0) goto L_0x00a2
            r1 = r1 | r12
            goto L_0x00b4
        L_0x00a2:
            r12 = r12 & r8
            if (r12 != 0) goto L_0x00b4
            r12 = r22
            boolean r13 = r15.changedInstance(r12)
            if (r13 == 0) goto L_0x00b0
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b2
        L_0x00b0:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00b2:
            r1 = r1 | r13
            goto L_0x00b6
        L_0x00b4:
            r12 = r22
        L_0x00b6:
            r13 = r26 & 64
            r14 = 1572864(0x180000, float:2.204052E-39)
            if (r13 == 0) goto L_0x00be
            r1 = r1 | r14
            goto L_0x00d1
        L_0x00be:
            r14 = r14 & r8
            if (r14 != 0) goto L_0x00d1
            r14 = r23
            boolean r16 = r15.changedInstance(r14)
            if (r16 == 0) goto L_0x00cc
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ce
        L_0x00cc:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00ce:
            r1 = r1 | r16
            goto L_0x00d3
        L_0x00d1:
            r14 = r23
        L_0x00d3:
            r16 = 599187(0x92493, float:8.3964E-40)
            r0 = r1 & r16
            r24 = r2
            r2 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r2) goto L_0x00f1
            boolean r0 = r15.getSkipping()
            if (r0 != 0) goto L_0x00e6
            goto L_0x00f1
        L_0x00e6:
            r15.skipToGroupEnd()
            r2 = r3
            r3 = r5
            r4 = r6
            r5 = r9
            r6 = r12
        L_0x00ee:
            r7 = r14
            goto L_0x01b7
        L_0x00f1:
            r15.startDefaults()
            r0 = r8 & 1
            if (r0 == 0) goto L_0x010e
            boolean r0 = r15.getDefaultsInvalid()
            if (r0 == 0) goto L_0x00ff
            goto L_0x010e
        L_0x00ff:
            r15.skipToGroupEnd()
            r0 = r26 & 8
            if (r0 == 0) goto L_0x0108
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0108:
            r11 = r5
            r13 = r12
            r12 = r9
            r9 = r3
            goto L_0x0173
        L_0x010e:
            if (r24 == 0) goto L_0x0115
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0116
        L_0x0115:
            r0 = r3
        L_0x0116:
            r2 = 1
            if (r4 == 0) goto L_0x011a
            r5 = r2
        L_0x011a:
            r3 = r26 & 8
            if (r3 == 0) goto L_0x0128
            androidx.compose.material3.SliderDefaults r3 = androidx.compose.material3.SliderDefaults.INSTANCE
            r4 = 6
            androidx.compose.material3.SliderColors r3 = r3.colors(r15, r4)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r6 = r3
        L_0x0128:
            if (r7 == 0) goto L_0x014b
            r3 = -403425429(0xffffffffe7f4376b, float:-2.3065594E24)
            java.lang.String r4 = "CC(remember):Slider.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r3, r4)
            java.lang.Object r3 = r15.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r3 != r4) goto L_0x0145
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r15.updateRememberedValue(r3)
        L_0x0145:
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = (androidx.compose.foundation.interaction.MutableInteractionSource) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            r9 = r3
        L_0x014b:
            r3 = 54
            if (r11 == 0) goto L_0x015e
            androidx.compose.material3.SliderKt$Slider$10 r4 = new androidx.compose.material3.SliderKt$Slider$10
            r4.<init>(r9, r6, r5)
            r7 = 1426271326(0x55032c5e, float:9.0141612E12)
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r7, r2, r4, r15, r3)
            kotlin.jvm.functions.Function3 r4 = (kotlin.jvm.functions.Function3) r4
            r12 = r4
        L_0x015e:
            if (r13 == 0) goto L_0x016f
            androidx.compose.material3.SliderKt$Slider$11 r4 = new androidx.compose.material3.SliderKt$Slider$11
            r4.<init>(r5, r6)
            r7 = 577038345(0x2264e809, float:3.10226E-18)
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r7, r2, r4, r15, r3)
            kotlin.jvm.functions.Function3 r2 = (kotlin.jvm.functions.Function3) r2
            r14 = r2
        L_0x016f:
            r11 = r5
            r13 = r12
            r12 = r9
            r9 = r0
        L_0x0173:
            r15.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0185
            r0 = -1
            java.lang.String r2 = "androidx.compose.material3.Slider (Slider.kt:351)"
            r3 = -1303883986(0xffffffffb2484f2e, float:-1.1659536E-8)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r1, r0, r2)
        L_0x0185:
            int r0 = r10.getSteps()
            if (r0 < 0) goto L_0x01cc
            int r0 = r1 >> 3
            r2 = r0 & 14
            int r3 = r1 << 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            r1 = r1 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r2 = r0 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r0
            r1 = r1 | r2
            r2 = 458752(0x70000, float:6.42848E-40)
            r0 = r0 & r2
            r16 = r1 | r0
            SliderImpl(r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01b0
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01b0:
            r4 = r6
            r2 = r9
            r3 = r11
            r5 = r12
            r6 = r13
            goto L_0x00ee
        L_0x01b7:
            androidx.compose.runtime.ScopeUpdateScope r10 = r15.endRestartGroup()
            if (r10 == 0) goto L_0x01cb
            androidx.compose.material3.SliderKt$Slider$13 r0 = new androidx.compose.material3.SliderKt$Slider$13
            r1 = r17
            r9 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x01cb:
            return
        L_0x01cc:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "steps should be >= 0"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.Slider(androidx.compose.material3.SliderState, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.SliderColors, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:138:0x0246  */
    /* JADX WARNING: Removed duplicated region for block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0113  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void RangeSlider(kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r28, kotlin.jvm.functions.Function1<? super kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit> r29, androidx.compose.ui.Modifier r30, boolean r31, kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r32, int r33, kotlin.jvm.functions.Function0<kotlin.Unit> r34, androidx.compose.material3.SliderColors r35, androidx.compose.runtime.Composer r36, int r37, int r38) {
        /*
            r9 = r37
            r10 = r38
            r0 = -743091416(0xffffffffd3b55328, float:-1.55756842E12)
            r1 = r36
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(RangeSlider)P(6,3,2,1,7,5,4)408@18812L8,410@18884L39,411@18981L39,423@19399L186,430@19606L184,437@19808L199,413@19026L987:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r10 & 1
            if (r2 == 0) goto L_0x001b
            r2 = r9 | 6
            r11 = r28
            goto L_0x002d
        L_0x001b:
            r2 = r9 & 6
            r11 = r28
            if (r2 != 0) goto L_0x002c
            boolean r2 = r1.changed((java.lang.Object) r11)
            if (r2 == 0) goto L_0x0029
            r2 = 4
            goto L_0x002a
        L_0x0029:
            r2 = 2
        L_0x002a:
            r2 = r2 | r9
            goto L_0x002d
        L_0x002c:
            r2 = r9
        L_0x002d:
            r3 = r10 & 2
            if (r3 == 0) goto L_0x0036
            r2 = r2 | 48
            r12 = r29
            goto L_0x0048
        L_0x0036:
            r3 = r9 & 48
            r12 = r29
            if (r3 != 0) goto L_0x0048
            boolean r3 = r1.changedInstance(r12)
            if (r3 == 0) goto L_0x0045
            r3 = 32
            goto L_0x0047
        L_0x0045:
            r3 = 16
        L_0x0047:
            r2 = r2 | r3
        L_0x0048:
            r3 = r10 & 4
            if (r3 == 0) goto L_0x004f
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r4 = r9 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x0062
            r4 = r30
            boolean r5 = r1.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x005e
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r2 = r2 | r5
            goto L_0x0064
        L_0x0062:
            r4 = r30
        L_0x0064:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x006b
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r6 = r9 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x007e
            r6 = r31
            boolean r7 = r1.changed((boolean) r6)
            if (r7 == 0) goto L_0x007a
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r2 = r2 | r7
            goto L_0x0080
        L_0x007e:
            r6 = r31
        L_0x0080:
            r7 = r9 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x0099
            r7 = r10 & 16
            if (r7 != 0) goto L_0x0093
            r7 = r32
            boolean r8 = r1.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0095
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0093:
            r7 = r32
        L_0x0095:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r2 = r2 | r8
            goto L_0x009b
        L_0x0099:
            r7 = r32
        L_0x009b:
            r8 = r10 & 32
            r13 = 196608(0x30000, float:2.75506E-40)
            if (r8 == 0) goto L_0x00a3
            r2 = r2 | r13
            goto L_0x00b5
        L_0x00a3:
            r13 = r13 & r9
            if (r13 != 0) goto L_0x00b5
            r13 = r33
            boolean r14 = r1.changed((int) r13)
            if (r14 == 0) goto L_0x00b1
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b3
        L_0x00b1:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b3:
            r2 = r2 | r14
            goto L_0x00b7
        L_0x00b5:
            r13 = r33
        L_0x00b7:
            r14 = r10 & 64
            r15 = 1572864(0x180000, float:2.204052E-39)
            if (r14 == 0) goto L_0x00bf
            r2 = r2 | r15
            goto L_0x00d2
        L_0x00bf:
            r15 = r15 & r9
            if (r15 != 0) goto L_0x00d2
            r15 = r34
            boolean r16 = r1.changedInstance(r15)
            if (r16 == 0) goto L_0x00cd
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cf
        L_0x00cd:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00cf:
            r2 = r2 | r16
            goto L_0x00d4
        L_0x00d2:
            r15 = r34
        L_0x00d4:
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r16 = r9 & r16
            if (r16 != 0) goto L_0x00f0
            r0 = r10 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x00e9
            r0 = r35
            boolean r17 = r1.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00eb
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ed
        L_0x00e9:
            r0 = r35
        L_0x00eb:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ed:
            r2 = r2 | r17
            goto L_0x00f2
        L_0x00f0:
            r0 = r35
        L_0x00f2:
            r17 = 4793491(0x492493, float:6.717112E-39)
            r0 = r2 & r17
            r36 = r2
            r2 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r2) goto L_0x0113
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x0105
            goto L_0x0113
        L_0x0105:
            r1.skipToGroupEnd()
            r8 = r35
            r24 = r1
            r3 = r4
            r4 = r6
            r5 = r7
            r6 = r13
            r7 = r15
            goto L_0x0240
        L_0x0113:
            r1.startDefaults()
            r0 = r9 & 1
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            r18 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r2 = 1
            if (r0 == 0) goto L_0x0147
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0128
            goto L_0x0147
        L_0x0128:
            r1.skipToGroupEnd()
            r0 = r10 & 16
            if (r0 == 0) goto L_0x0132
            r0 = r36 & r17
            goto L_0x0134
        L_0x0132:
            r0 = r36
        L_0x0134:
            r3 = r10 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x013a
            r0 = r0 & r18
        L_0x013a:
            r3 = r35
            r14 = r6
            r23 = r13
            r16 = r15
            r13 = r4
        L_0x0142:
            r15 = r7
            r4 = -743091416(0xffffffffd3b55328, float:-1.55756842E12)
            goto L_0x0183
        L_0x0147:
            if (r3 == 0) goto L_0x014e
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x014f
        L_0x014e:
            r0 = r4
        L_0x014f:
            if (r5 == 0) goto L_0x0152
            r6 = r2
        L_0x0152:
            r3 = r10 & 16
            if (r3 == 0) goto L_0x0161
            r3 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            kotlin.ranges.ClosedFloatingPointRange r3 = kotlin.ranges.RangesKt.rangeTo((float) r3, (float) r4)
            r4 = r36 & r17
            r7 = r3
            goto L_0x0163
        L_0x0161:
            r4 = r36
        L_0x0163:
            if (r8 == 0) goto L_0x0167
            r3 = 0
            r13 = r3
        L_0x0167:
            if (r14 == 0) goto L_0x016b
            r3 = 0
            r15 = r3
        L_0x016b:
            r3 = r10 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x0179
            androidx.compose.material3.SliderDefaults r3 = androidx.compose.material3.SliderDefaults.INSTANCE
            r5 = 6
            androidx.compose.material3.SliderColors r3 = r3.colors(r1, r5)
            r4 = r4 & r18
            goto L_0x017b
        L_0x0179:
            r3 = r35
        L_0x017b:
            r14 = r6
            r23 = r13
            r16 = r15
            r13 = r0
            r0 = r4
            goto L_0x0142
        L_0x0183:
            r1.endDefaults()
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0192
            r5 = -1
            java.lang.String r6 = "androidx.compose.material3.RangeSlider (Slider.kt:409)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r0, r5, r6)
        L_0x0192:
            r4 = 1661051042(0x6301a0a2, float:2.3912048E21)
            java.lang.String r5 = "CC(remember):Slider.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r4, r5)
            java.lang.Object r4 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r4 != r6) goto L_0x01ad
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r1.updateRememberedValue(r4)
        L_0x01ad:
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = (androidx.compose.foundation.interaction.MutableInteractionSource) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r6 = 1661054146(0x6301acc2, float:2.3920785E21)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r6, r5)
            java.lang.Object r5 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r5 != r6) goto L_0x01cb
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r1.updateRememberedValue(r5)
        L_0x01cb:
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = (androidx.compose.foundation.interaction.MutableInteractionSource) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.material3.SliderKt$RangeSlider$1 r6 = new androidx.compose.material3.SliderKt$RangeSlider$1
            r6.<init>(r4, r3, r14)
            r7 = -811582901(0xffffffffcfa03a4b, float:-5.3763497E9)
            r8 = 54
            androidx.compose.runtime.internal.ComposableLambda r6 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r7, r2, r6, r1, r8)
            r20 = r6
            kotlin.jvm.functions.Function3 r20 = (kotlin.jvm.functions.Function3) r20
            androidx.compose.material3.SliderKt$RangeSlider$2 r6 = new androidx.compose.material3.SliderKt$RangeSlider$2
            r6.<init>(r5, r3, r14)
            r7 = -1832060001(0xffffffff92ccfb9f, float:-1.2936239E-27)
            androidx.compose.runtime.internal.ComposableLambda r6 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r7, r2, r6, r1, r8)
            r21 = r6
            kotlin.jvm.functions.Function3 r21 = (kotlin.jvm.functions.Function3) r21
            androidx.compose.material3.SliderKt$RangeSlider$3 r6 = new androidx.compose.material3.SliderKt$RangeSlider$3
            r6.<init>(r14, r3)
            r7 = 377064480(0x16798c20, float:2.0158275E-25)
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r7, r2, r6, r1, r8)
            r22 = r2
            kotlin.jvm.functions.Function3 r22 = (kotlin.jvm.functions.Function3) r22
            r2 = r0 & 14
            r6 = 918552576(0x36c00000, float:5.722046E-6)
            r2 = r2 | r6
            r6 = r0 & 112(0x70, float:1.57E-43)
            r2 = r2 | r6
            r6 = r0 & 896(0x380, float:1.256E-42)
            r2 = r2 | r6
            r6 = r0 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r6
            r6 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r0
            r2 = r2 | r6
            int r6 = r0 >> 3
            r7 = 458752(0x70000, float:6.42848E-40)
            r6 = r6 & r7
            r25 = r2 | r6
            int r0 = r0 >> 9
            r0 = r0 & 896(0x380, float:1.256E-42)
            r26 = r0 | 54
            r27 = 64
            r17 = 0
            r24 = r1
            r18 = r4
            r19 = r5
            RangeSlider(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0238
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0238:
            r8 = r3
            r3 = r13
            r4 = r14
            r5 = r15
            r7 = r16
            r6 = r23
        L_0x0240:
            androidx.compose.runtime.ScopeUpdateScope r11 = r24.endRestartGroup()
            if (r11 == 0) goto L_0x0254
            androidx.compose.material3.SliderKt$RangeSlider$4 r0 = new androidx.compose.material3.SliderKt$RangeSlider$4
            r1 = r28
            r2 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r11.updateScope(r0)
        L_0x0254:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.RangeSlider(kotlin.ranges.ClosedFloatingPointRange, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.ranges.ClosedFloatingPointRange, int, kotlin.jvm.functions.Function0, androidx.compose.material3.SliderColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x040c  */
    /* JADX WARNING: Removed duplicated region for block: B:236:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0125  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void RangeSlider(kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r31, kotlin.jvm.functions.Function1<? super kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit> r32, androidx.compose.ui.Modifier r33, boolean r34, kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r35, kotlin.jvm.functions.Function0<kotlin.Unit> r36, androidx.compose.material3.SliderColors r37, androidx.compose.foundation.interaction.MutableInteractionSource r38, androidx.compose.foundation.interaction.MutableInteractionSource r39, kotlin.jvm.functions.Function3<? super androidx.compose.material3.RangeSliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, kotlin.jvm.functions.Function3<? super androidx.compose.material3.RangeSliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, kotlin.jvm.functions.Function3<? super androidx.compose.material3.RangeSliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, int r43, androidx.compose.runtime.Composer r44, int r45, int r46, int r47) {
        /*
            r2 = r32
            r14 = r45
            r15 = r46
            r0 = r47
            r1 = -1048796133(0xffffffffc17ca41b, float:-15.790065)
            r3 = r44
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r1)
            java.lang.String r4 = "C(RangeSlider)P(11,5,4,1,12,6!1,7!1,8!1,10)511@23750L8,512@23815L39,513@23909L39,514@24007L162,521@24226L160,528@24440L175,538@24684L237,549@25005L44,553@25142L291:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            r4 = r0 & 1
            if (r4 == 0) goto L_0x0020
            r4 = r14 | 6
            r7 = r4
            r4 = r31
            goto L_0x0034
        L_0x0020:
            r4 = r14 & 6
            if (r4 != 0) goto L_0x0031
            r4 = r31
            boolean r7 = r3.changed((java.lang.Object) r4)
            if (r7 == 0) goto L_0x002e
            r7 = 4
            goto L_0x002f
        L_0x002e:
            r7 = 2
        L_0x002f:
            r7 = r7 | r14
            goto L_0x0034
        L_0x0031:
            r4 = r31
            r7 = r14
        L_0x0034:
            r8 = r0 & 2
            if (r8 == 0) goto L_0x003b
            r7 = r7 | 48
            goto L_0x004b
        L_0x003b:
            r8 = r14 & 48
            if (r8 != 0) goto L_0x004b
            boolean r8 = r3.changedInstance(r2)
            if (r8 == 0) goto L_0x0048
            r8 = 32
            goto L_0x004a
        L_0x0048:
            r8 = 16
        L_0x004a:
            r7 = r7 | r8
        L_0x004b:
            r8 = r0 & 4
            if (r8 == 0) goto L_0x0052
            r7 = r7 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0052:
            r13 = r14 & 384(0x180, float:5.38E-43)
            if (r13 != 0) goto L_0x0066
            r13 = r33
            boolean r16 = r3.changed((java.lang.Object) r13)
            if (r16 == 0) goto L_0x0061
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r7 = r7 | r16
            goto L_0x0068
        L_0x0066:
            r13 = r33
        L_0x0068:
            r16 = r0 & 8
            if (r16 == 0) goto L_0x006f
            r7 = r7 | 3072(0xc00, float:4.305E-42)
            goto L_0x0083
        L_0x006f:
            r5 = r14 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x0083
            r5 = r34
            boolean r17 = r3.changed((boolean) r5)
            if (r17 == 0) goto L_0x007e
            r17 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r17 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r7 = r7 | r17
            goto L_0x0085
        L_0x0083:
            r5 = r34
        L_0x0085:
            r6 = r14 & 24576(0x6000, float:3.4438E-41)
            if (r6 != 0) goto L_0x009f
            r6 = r0 & 16
            if (r6 != 0) goto L_0x0098
            r6 = r35
            boolean r19 = r3.changed((java.lang.Object) r6)
            if (r19 == 0) goto L_0x009a
            r19 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009c
        L_0x0098:
            r6 = r35
        L_0x009a:
            r19 = 8192(0x2000, float:1.14794E-41)
        L_0x009c:
            r7 = r7 | r19
            goto L_0x00a1
        L_0x009f:
            r6 = r35
        L_0x00a1:
            r19 = r0 & 32
            r20 = 196608(0x30000, float:2.75506E-40)
            if (r19 == 0) goto L_0x00ac
            r7 = r7 | r20
            r11 = r36
            goto L_0x00bf
        L_0x00ac:
            r20 = r14 & r20
            r11 = r36
            if (r20 != 0) goto L_0x00bf
            boolean r21 = r3.changedInstance(r11)
            if (r21 == 0) goto L_0x00bb
            r21 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bd
        L_0x00bb:
            r21 = 65536(0x10000, float:9.18355E-41)
        L_0x00bd:
            r7 = r7 | r21
        L_0x00bf:
            r21 = 1572864(0x180000, float:2.204052E-39)
            r21 = r14 & r21
            if (r21 != 0) goto L_0x00d9
            r21 = r0 & 64
            r9 = r37
            if (r21 != 0) goto L_0x00d4
            boolean r22 = r3.changed((java.lang.Object) r9)
            if (r22 == 0) goto L_0x00d4
            r22 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d6
        L_0x00d4:
            r22 = 524288(0x80000, float:7.34684E-40)
        L_0x00d6:
            r7 = r7 | r22
            goto L_0x00db
        L_0x00d9:
            r9 = r37
        L_0x00db:
            r10 = r0 & 128(0x80, float:1.794E-43)
            r23 = 12582912(0xc00000, float:1.7632415E-38)
            if (r10 == 0) goto L_0x00e6
            r7 = r7 | r23
            r12 = r38
            goto L_0x00f9
        L_0x00e6:
            r23 = r14 & r23
            r12 = r38
            if (r23 != 0) goto L_0x00f9
            boolean r24 = r3.changed((java.lang.Object) r12)
            if (r24 == 0) goto L_0x00f5
            r24 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f7
        L_0x00f5:
            r24 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f7:
            r7 = r7 | r24
        L_0x00f9:
            r1 = r0 & 256(0x100, float:3.59E-43)
            r25 = 100663296(0x6000000, float:2.4074124E-35)
            if (r1 == 0) goto L_0x0102
            r7 = r7 | r25
            goto L_0x0118
        L_0x0102:
            r25 = r14 & r25
            if (r25 != 0) goto L_0x0118
            r25 = r1
            r1 = r39
            boolean r26 = r3.changed((java.lang.Object) r1)
            if (r26 == 0) goto L_0x0113
            r26 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0115
        L_0x0113:
            r26 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0115:
            r7 = r7 | r26
            goto L_0x011c
        L_0x0118:
            r25 = r1
            r1 = r39
        L_0x011c:
            r1 = r0 & 512(0x200, float:7.175E-43)
            r26 = 805306368(0x30000000, float:4.656613E-10)
            if (r1 == 0) goto L_0x0125
            r7 = r7 | r26
            goto L_0x013b
        L_0x0125:
            r26 = r14 & r26
            if (r26 != 0) goto L_0x013b
            r26 = r1
            r1 = r40
            boolean r27 = r3.changedInstance(r1)
            if (r27 == 0) goto L_0x0136
            r27 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0138
        L_0x0136:
            r27 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0138:
            r7 = r7 | r27
            goto L_0x013f
        L_0x013b:
            r26 = r1
            r1 = r40
        L_0x013f:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x014a
            r17 = r15 | 6
            r27 = r1
            r1 = r41
            goto L_0x0166
        L_0x014a:
            r27 = r15 & 6
            if (r27 != 0) goto L_0x0160
            r27 = r1
            r1 = r41
            boolean r28 = r3.changedInstance(r1)
            if (r28 == 0) goto L_0x015b
            r17 = 4
            goto L_0x015d
        L_0x015b:
            r17 = 2
        L_0x015d:
            r17 = r15 | r17
            goto L_0x0166
        L_0x0160:
            r27 = r1
            r1 = r41
            r17 = r15
        L_0x0166:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x016f
            r17 = r17 | 48
            r28 = r1
            goto L_0x0189
        L_0x016f:
            r28 = r15 & 48
            if (r28 != 0) goto L_0x0185
            r28 = r1
            r1 = r42
            boolean r29 = r3.changedInstance(r1)
            if (r29 == 0) goto L_0x0180
            r18 = 32
            goto L_0x0182
        L_0x0180:
            r18 = 16
        L_0x0182:
            r17 = r17 | r18
            goto L_0x0189
        L_0x0185:
            r28 = r1
            r1 = r42
        L_0x0189:
            r1 = r17
            r4 = r0 & 4096(0x1000, float:5.74E-42)
            if (r4 == 0) goto L_0x0192
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x01a6
        L_0x0192:
            r0 = r15 & 384(0x180, float:5.38E-43)
            if (r0 != 0) goto L_0x01a6
            r0 = r43
            boolean r17 = r3.changed((int) r0)
            if (r17 == 0) goto L_0x01a1
            r20 = 256(0x100, float:3.59E-43)
            goto L_0x01a3
        L_0x01a1:
            r20 = 128(0x80, float:1.794E-43)
        L_0x01a3:
            r1 = r1 | r20
            goto L_0x01a8
        L_0x01a6:
            r0 = r43
        L_0x01a8:
            r17 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r7 & r17
            r17 = r4
            r4 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r4) goto L_0x01d7
            r0 = r1 & 147(0x93, float:2.06E-43)
            r4 = 146(0x92, float:2.05E-43)
            if (r0 != r4) goto L_0x01d7
            boolean r0 = r3.getSkipping()
            if (r0 != 0) goto L_0x01c1
            goto L_0x01d7
        L_0x01c1:
            r3.skipToGroupEnd()
            r10 = r40
            r0 = r3
            r4 = r5
            r5 = r6
            r7 = r9
            r6 = r11
            r8 = r12
            r3 = r13
            r9 = r39
            r11 = r41
            r12 = r42
            r13 = r43
            goto L_0x0406
        L_0x01d7:
            r3.startDefaults()
            r0 = r14 & 1
            java.lang.String r4 = "CC(remember):Slider.kt#9igjgp"
            r18 = r0
            if (r18 == 0) goto L_0x020a
            boolean r18 = r3.getDefaultsInvalid()
            if (r18 == 0) goto L_0x01e9
            goto L_0x020a
        L_0x01e9:
            r3.skipToGroupEnd()
            r8 = r47 & 16
            if (r8 == 0) goto L_0x01f4
            r8 = -57345(0xffffffffffff1fff, float:NaN)
            r7 = r7 & r8
        L_0x01f4:
            r8 = r47 & 64
            if (r8 == 0) goto L_0x01fc
            r8 = -3670017(0xffffffffffc7ffff, float:NaN)
            r7 = r7 & r8
        L_0x01fc:
            r0 = r40
            r16 = r42
            r17 = r43
            r10 = r12
            r8 = r13
            r12 = r39
            r13 = r41
            goto L_0x02db
        L_0x020a:
            if (r8 == 0) goto L_0x0211
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            goto L_0x0212
        L_0x0211:
            r8 = r13
        L_0x0212:
            if (r16 == 0) goto L_0x0215
            r5 = 1
        L_0x0215:
            r13 = r47 & 16
            if (r13 == 0) goto L_0x0224
            r6 = 0
            r13 = 1065353216(0x3f800000, float:1.0)
            kotlin.ranges.ClosedFloatingPointRange r6 = kotlin.ranges.RangesKt.rangeTo((float) r6, (float) r13)
            r13 = -57345(0xffffffffffff1fff, float:NaN)
            r7 = r7 & r13
        L_0x0224:
            if (r19 == 0) goto L_0x0227
            r11 = 0
        L_0x0227:
            r13 = r47 & 64
            if (r13 == 0) goto L_0x0236
            androidx.compose.material3.SliderDefaults r9 = androidx.compose.material3.SliderDefaults.INSTANCE
            r13 = 6
            androidx.compose.material3.SliderColors r9 = r9.colors(r3, r13)
            r13 = -3670017(0xffffffffffc7ffff, float:NaN)
            r7 = r7 & r13
        L_0x0236:
            if (r10 == 0) goto L_0x0257
            r10 = 1661208834(0x63040902, float:2.4356193E21)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r10, r4)
            java.lang.Object r10 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r10 != r12) goto L_0x0251
            androidx.compose.foundation.interaction.MutableInteractionSource r10 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r3.updateRememberedValue(r10)
        L_0x0251:
            androidx.compose.foundation.interaction.MutableInteractionSource r10 = (androidx.compose.foundation.interaction.MutableInteractionSource) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            goto L_0x0258
        L_0x0257:
            r10 = r12
        L_0x0258:
            if (r25 == 0) goto L_0x0279
            r12 = 1661211842(0x630414c2, float:2.436466E21)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r12, r4)
            java.lang.Object r12 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r12 != r13) goto L_0x0273
            androidx.compose.foundation.interaction.MutableInteractionSource r12 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r3.updateRememberedValue(r12)
        L_0x0273:
            androidx.compose.foundation.interaction.MutableInteractionSource r12 = (androidx.compose.foundation.interaction.MutableInteractionSource) r12
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            goto L_0x027b
        L_0x0279:
            r12 = r39
        L_0x027b:
            r13 = 54
            if (r26 == 0) goto L_0x0293
            androidx.compose.material3.SliderKt$RangeSlider$7 r0 = new androidx.compose.material3.SliderKt$RangeSlider$7
            r0.<init>(r10, r9, r5)
            r33 = r6
            r6 = -1963073082(0xffffffff8afde1c6, float:-2.444794E-32)
            r34 = r7
            r7 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r6, r7, r0, r3, r13)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            goto L_0x029a
        L_0x0293:
            r33 = r6
            r34 = r7
            r7 = 1
            r0 = r40
        L_0x029a:
            if (r27 == 0) goto L_0x02ad
            androidx.compose.material3.SliderKt$RangeSlider$8 r6 = new androidx.compose.material3.SliderKt$RangeSlider$8
            r6.<init>(r12, r9, r5)
            r35 = r0
            r0 = 1908709951(0x71c49a3f, float:1.9470571E30)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r0, r7, r6, r3, r13)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            goto L_0x02b1
        L_0x02ad:
            r35 = r0
            r0 = r41
        L_0x02b1:
            if (r28 == 0) goto L_0x02c4
            androidx.compose.material3.SliderKt$RangeSlider$9 r6 = new androidx.compose.material3.SliderKt$RangeSlider$9
            r6.<init>(r5, r9)
            r36 = r0
            r0 = -429193201(0xffffffffe66b080f, float:-2.774762E23)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r0, r7, r6, r3, r13)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            goto L_0x02c8
        L_0x02c4:
            r36 = r0
            r0 = r42
        L_0x02c8:
            r6 = r33
            r7 = r34
            r13 = r36
            if (r17 == 0) goto L_0x02d5
            r16 = r0
            r17 = 0
            goto L_0x02d9
        L_0x02d5:
            r17 = r43
            r16 = r0
        L_0x02d9:
            r0 = r35
        L_0x02db:
            r3.endDefaults()
            boolean r19 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r39 = r0
            if (r19 == 0) goto L_0x02f1
            java.lang.String r0 = "androidx.compose.material3.RangeSlider (Slider.kt:536)"
            r40 = r5
            r5 = -1048796133(0xffffffffc17ca41b, float:-15.790065)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r7, r1, r0)
            goto L_0x02f3
        L_0x02f1:
            r40 = r5
        L_0x02f3:
            r0 = 1661236840(0x63047668, float:2.4435023E21)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r4)
            r0 = r1 & 896(0x380, float:1.256E-42)
            r5 = 256(0x100, float:3.59E-43)
            if (r0 != r5) goto L_0x0301
            r0 = 1
            goto L_0x0302
        L_0x0301:
            r0 = 0
        L_0x0302:
            r5 = 57344(0xe000, float:8.0356E-41)
            r5 = r5 & r7
            r5 = r5 ^ 24576(0x6000, float:3.4438E-41)
            r33 = r0
            r0 = 16384(0x4000, float:2.2959E-41)
            if (r5 <= r0) goto L_0x0314
            boolean r5 = r3.changed((java.lang.Object) r6)
            if (r5 != 0) goto L_0x0318
        L_0x0314:
            r5 = r7 & 24576(0x6000, float:3.4438E-41)
            if (r5 != r0) goto L_0x031a
        L_0x0318:
            r0 = 1
            goto L_0x031b
        L_0x031a:
            r0 = 0
        L_0x031b:
            r0 = r33 | r0
            java.lang.Object r5 = r3.rememberedValue()
            if (r0 != 0) goto L_0x032f
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r5 != r0) goto L_0x032c
            goto L_0x032f
        L_0x032c:
            r0 = r17
            goto L_0x035b
        L_0x032f:
            androidx.compose.material3.RangeSliderState r0 = new androidx.compose.material3.RangeSliderState
            java.lang.Comparable r5 = r31.getStart()
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            java.lang.Comparable r19 = r31.getEndInclusive()
            java.lang.Number r19 = (java.lang.Number) r19
            float r19 = r19.floatValue()
            r33 = r0
            r34 = r5
            r38 = r6
            r37 = r11
            r36 = r17
            r35 = r19
            r33.<init>(r34, r35, r36, r37, r38)
            r5 = r33
            r0 = r36
            r3.updateRememberedValue(r5)
        L_0x035b:
            androidx.compose.material3.RangeSliderState r5 = (androidx.compose.material3.RangeSliderState) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r5.setOnValueChangeFinished(r11)
            r17 = r0
            r0 = 1661246919(0x63049dc7, float:2.4463393E21)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r4)
            r0 = r7 & 112(0x70, float:1.57E-43)
            r4 = 32
            if (r0 != r4) goto L_0x0373
            r4 = 1
            goto L_0x0374
        L_0x0373:
            r4 = 0
        L_0x0374:
            java.lang.Object r0 = r3.rememberedValue()
            if (r4 != 0) goto L_0x0382
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r0 != r4) goto L_0x038c
        L_0x0382:
            androidx.compose.material3.SliderKt$RangeSlider$10$1 r0 = new androidx.compose.material3.SliderKt$RangeSlider$10$1
            r0.<init>(r2)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r3.updateRememberedValue(r0)
        L_0x038c:
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r5.setOnValueChange$material3_release(r0)
            java.lang.Comparable r0 = r31.getStart()
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            r5.setActiveRangeStart(r0)
            java.lang.Comparable r0 = r31.getEndInclusive()
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            r5.setActiveRangeEnd(r0)
            int r0 = r7 >> 3
            r0 = r0 & 1008(0x3f0, float:1.413E-42)
            int r4 = r7 >> 9
            r7 = 57344(0xe000, float:8.0356E-41)
            r7 = r7 & r4
            r0 = r0 | r7
            r7 = 458752(0x70000, float:6.42848E-40)
            r7 = r7 & r4
            r0 = r0 | r7
            r7 = 3670016(0x380000, float:5.142788E-39)
            r4 = r4 & r7
            r0 = r0 | r4
            int r1 = r1 << 21
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r4 = r4 & r1
            r0 = r0 | r4
            r4 = 234881024(0xe000000, float:1.5777218E-30)
            r1 = r1 & r4
            r0 = r0 | r1
            r1 = 8
            r4 = 0
            r35 = r40
            r43 = r0
            r44 = r1
            r42 = r3
            r36 = r4
            r33 = r5
            r34 = r8
            r37 = r10
            r38 = r12
            r40 = r13
            r41 = r16
            RangeSlider(r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44)
            r5 = r35
            r1 = r39
            r3 = r40
            r4 = r41
            r0 = r42
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x03fa
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03fa:
            r7 = r9
            r9 = r12
            r13 = r17
            r12 = r4
            r4 = r5
            r5 = r6
            r6 = r11
            r11 = r3
            r3 = r8
            r8 = r10
            r10 = r1
        L_0x0406:
            androidx.compose.runtime.ScopeUpdateScope r0 = r0.endRestartGroup()
            if (r0 == 0) goto L_0x041f
            r1 = r0
            androidx.compose.material3.SliderKt$RangeSlider$11 r0 = new androidx.compose.material3.SliderKt$RangeSlider$11
            r16 = r47
            r30 = r1
            r1 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r30
            r1.updateScope(r0)
        L_0x041f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.RangeSlider(kotlin.ranges.ClosedFloatingPointRange, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.ranges.ClosedFloatingPointRange, kotlin.jvm.functions.Function0, androidx.compose.material3.SliderColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, int, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:158:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0102  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void RangeSlider(androidx.compose.material3.RangeSliderState r22, androidx.compose.ui.Modifier r23, boolean r24, androidx.compose.material3.SliderColors r25, androidx.compose.foundation.interaction.MutableInteractionSource r26, androidx.compose.foundation.interaction.MutableInteractionSource r27, kotlin.jvm.functions.Function3<? super androidx.compose.material3.RangeSliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, kotlin.jvm.functions.Function3<? super androidx.compose.material3.RangeSliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, kotlin.jvm.functions.Function3<? super androidx.compose.material3.RangeSliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r10 = r32
            r11 = r33
            r0 = 511405654(0x1e7b6e56, float:1.3310646E-20)
            r1 = r31
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(RangeSlider)P(7,4,1!1,5!1,6)616@28157L8,617@28222L39,618@28316L39,619@28414L162,626@28633L160,633@28847L175,643@29089L295:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r11 & 1
            if (r2 == 0) goto L_0x001b
            r2 = r10 | 6
            r13 = r22
            goto L_0x002d
        L_0x001b:
            r2 = r10 & 6
            r13 = r22
            if (r2 != 0) goto L_0x002c
            boolean r2 = r1.changedInstance(r13)
            if (r2 == 0) goto L_0x0029
            r2 = 4
            goto L_0x002a
        L_0x0029:
            r2 = 2
        L_0x002a:
            r2 = r2 | r10
            goto L_0x002d
        L_0x002c:
            r2 = r10
        L_0x002d:
            r3 = r11 & 2
            if (r3 == 0) goto L_0x0034
            r2 = r2 | 48
            goto L_0x0047
        L_0x0034:
            r4 = r10 & 48
            if (r4 != 0) goto L_0x0047
            r4 = r23
            boolean r5 = r1.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0043
            r5 = 32
            goto L_0x0045
        L_0x0043:
            r5 = 16
        L_0x0045:
            r2 = r2 | r5
            goto L_0x0049
        L_0x0047:
            r4 = r23
        L_0x0049:
            r5 = r11 & 4
            if (r5 == 0) goto L_0x0050
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r6 = r10 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0063
            r6 = r24
            boolean r7 = r1.changed((boolean) r6)
            if (r7 == 0) goto L_0x005f
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r2 = r2 | r7
            goto L_0x0065
        L_0x0063:
            r6 = r24
        L_0x0065:
            r7 = r10 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x007e
            r7 = r11 & 8
            if (r7 != 0) goto L_0x0078
            r7 = r25
            boolean r8 = r1.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x007a
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x0078:
            r7 = r25
        L_0x007a:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r2 = r2 | r8
            goto L_0x0080
        L_0x007e:
            r7 = r25
        L_0x0080:
            r8 = r11 & 16
            if (r8 == 0) goto L_0x0087
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0087:
            r9 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x009a
            r9 = r26
            boolean r12 = r1.changed((java.lang.Object) r9)
            if (r12 == 0) goto L_0x0096
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r2 = r2 | r12
            goto L_0x009c
        L_0x009a:
            r9 = r26
        L_0x009c:
            r12 = r11 & 32
            r14 = 196608(0x30000, float:2.75506E-40)
            if (r12 == 0) goto L_0x00a4
            r2 = r2 | r14
            goto L_0x00b6
        L_0x00a4:
            r14 = r14 & r10
            if (r14 != 0) goto L_0x00b6
            r14 = r27
            boolean r15 = r1.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00b2
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b4
        L_0x00b2:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b4:
            r2 = r2 | r15
            goto L_0x00b8
        L_0x00b6:
            r14 = r27
        L_0x00b8:
            r15 = r11 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00c3
            r2 = r2 | r16
            r0 = r28
            goto L_0x00d6
        L_0x00c3:
            r16 = r10 & r16
            r0 = r28
            if (r16 != 0) goto L_0x00d6
            boolean r17 = r1.changedInstance(r0)
            if (r17 == 0) goto L_0x00d2
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d4
        L_0x00d2:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d4:
            r2 = r2 | r17
        L_0x00d6:
            r0 = r11 & 128(0x80, float:1.794E-43)
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00df
            r2 = r2 | r17
            goto L_0x00f5
        L_0x00df:
            r17 = r10 & r17
            if (r17 != 0) goto L_0x00f5
            r17 = r0
            r0 = r29
            boolean r18 = r1.changedInstance(r0)
            if (r18 == 0) goto L_0x00f0
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f2
        L_0x00f0:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f2:
            r2 = r2 | r18
            goto L_0x00f9
        L_0x00f5:
            r17 = r0
            r0 = r29
        L_0x00f9:
            r0 = r11 & 256(0x100, float:3.59E-43)
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x0102
            r2 = r2 | r18
            goto L_0x0118
        L_0x0102:
            r18 = r10 & r18
            if (r18 != 0) goto L_0x0118
            r18 = r0
            r0 = r30
            boolean r19 = r1.changedInstance(r0)
            if (r19 == 0) goto L_0x0113
            r19 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0115
        L_0x0113:
            r19 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0115:
            r2 = r2 | r19
            goto L_0x011c
        L_0x0118:
            r18 = r0
            r0 = r30
        L_0x011c:
            r19 = 38347923(0x2492493, float:1.4777644E-37)
            r0 = r2 & r19
            r31 = r3
            r3 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r3) goto L_0x0141
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x012f
            goto L_0x0141
        L_0x012f:
            r1.skipToGroupEnd()
            r8 = r29
            r20 = r1
            r2 = r4
            r3 = r6
            r4 = r7
            r5 = r9
            r6 = r14
            r7 = r28
            r9 = r30
            goto L_0x025b
        L_0x0141:
            r1.startDefaults()
            r0 = r10 & 1
            if (r0 == 0) goto L_0x0168
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x014f
            goto L_0x0168
        L_0x014f:
            r1.skipToGroupEnd()
            r0 = r11 & 8
            if (r0 == 0) goto L_0x0158
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0158:
            r17 = r28
            r18 = r29
            r19 = r30
            r12 = r4
            r15 = r9
        L_0x0160:
            r16 = r14
            r0 = 511405654(0x1e7b6e56, float:1.3310646E-20)
            r14 = r6
            goto L_0x020b
        L_0x0168:
            if (r31 == 0) goto L_0x016f
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r4 = r0
        L_0x016f:
            r0 = 1
            if (r5 == 0) goto L_0x0173
            r6 = r0
        L_0x0173:
            r3 = r11 & 8
            if (r3 == 0) goto L_0x0181
            androidx.compose.material3.SliderDefaults r3 = androidx.compose.material3.SliderDefaults.INSTANCE
            r5 = 6
            androidx.compose.material3.SliderColors r3 = r3.colors(r1, r5)
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
            r7 = r3
        L_0x0181:
            java.lang.String r3 = "CC(remember):Slider.kt#9igjgp"
            if (r8 == 0) goto L_0x01a4
            r5 = 1661349858(0x63062fe2, float:2.475314E21)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r5, r3)
            java.lang.Object r5 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r5 != r8) goto L_0x019e
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r1.updateRememberedValue(r5)
        L_0x019e:
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = (androidx.compose.foundation.interaction.MutableInteractionSource) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            goto L_0x01a5
        L_0x01a4:
            r5 = r9
        L_0x01a5:
            if (r12 == 0) goto L_0x01c6
            r8 = 1661352866(0x63063ba2, float:2.4761607E21)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r8, r3)
            java.lang.Object r3 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r3 != r8) goto L_0x01c0
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r1.updateRememberedValue(r3)
        L_0x01c0:
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = (androidx.compose.foundation.interaction.MutableInteractionSource) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r14 = r3
        L_0x01c6:
            r3 = 54
            if (r15 == 0) goto L_0x01d9
            androidx.compose.material3.SliderKt$RangeSlider$14 r8 = new androidx.compose.material3.SliderKt$RangeSlider$14
            r8.<init>(r5, r7, r6)
            r9 = 1884205643(0x704eb24b, float:2.5587782E29)
            androidx.compose.runtime.internal.ComposableLambda r8 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r9, r0, r8, r1, r3)
            kotlin.jvm.functions.Function3 r8 = (kotlin.jvm.functions.Function3) r8
            goto L_0x01db
        L_0x01d9:
            r8 = r28
        L_0x01db:
            if (r17 == 0) goto L_0x01ec
            androidx.compose.material3.SliderKt$RangeSlider$15 r9 = new androidx.compose.material3.SliderKt$RangeSlider$15
            r9.<init>(r14, r7, r6)
            r12 = 1016457138(0x3c95e7b2, float:0.018298957)
            androidx.compose.runtime.internal.ComposableLambda r9 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r12, r0, r9, r1, r3)
            kotlin.jvm.functions.Function3 r9 = (kotlin.jvm.functions.Function3) r9
            goto L_0x01ee
        L_0x01ec:
            r9 = r29
        L_0x01ee:
            if (r18 == 0) goto L_0x0201
            androidx.compose.material3.SliderKt$RangeSlider$16 r12 = new androidx.compose.material3.SliderKt$RangeSlider$16
            r12.<init>(r6, r7)
            r15 = -1617375262(0xffffffff9f98cfe2, float:-6.471842E-20)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r15, r0, r12, r1, r3)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r19 = r0
            goto L_0x0203
        L_0x0201:
            r19 = r30
        L_0x0203:
            r12 = r4
            r15 = r5
            r17 = r8
            r18 = r9
            goto L_0x0160
        L_0x020b:
            r1.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x021a
            r3 = -1
            java.lang.String r4 = "androidx.compose.material3.RangeSlider (Slider.kt:640)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r3, r4)
        L_0x021a:
            int r0 = r13.getSteps()
            if (r0 < 0) goto L_0x026e
            int r0 = r2 >> 3
            r3 = r0 & 14
            int r4 = r2 << 3
            r4 = r4 & 112(0x70, float:1.57E-43)
            r3 = r3 | r4
            r2 = r2 & 896(0x380, float:1.256E-42)
            r2 = r2 | r3
            r3 = r0 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r3
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r0
            r2 = r2 | r3
            r3 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r0
            r2 = r2 | r3
            r3 = 3670016(0x380000, float:5.142788E-39)
            r3 = r3 & r0
            r2 = r2 | r3
            r3 = 29360128(0x1c00000, float:7.052966E-38)
            r0 = r0 & r3
            r21 = r2 | r0
            r20 = r1
            RangeSliderImpl(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x024f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x024f:
            r4 = r7
            r2 = r12
            r3 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            r9 = r19
        L_0x025b:
            androidx.compose.runtime.ScopeUpdateScope r12 = r20.endRestartGroup()
            if (r12 == 0) goto L_0x026d
            androidx.compose.material3.SliderKt$RangeSlider$18 r0 = new androidx.compose.material3.SliderKt$RangeSlider$18
            r1 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x026d:
            return
        L_0x026e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "steps should be >= 0"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.RangeSlider(androidx.compose.material3.RangeSliderState, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.SliderColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void SliderImpl(Modifier modifier, SliderState sliderState, boolean z, MutableInteractionSource mutableInteractionSource, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function32, Composer composer, int i) {
        int i2;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function33;
        boolean z2;
        SliderState sliderState2 = sliderState;
        boolean z3 = z;
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function34 = function3;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function35 = function32;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(1390990089);
        ComposerKt.sourceInformation(startRestartGroup, "C(SliderImpl)P(2,3)665@29717L7,673@30073L28,698@30935L1093,678@30197L1831:Slider.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i3;
        } else {
            Modifier modifier2 = modifier;
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(sliderState2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changed(z3) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changed((Object) mutableInteractionSource2) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function34) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(function35) ? 131072 : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1390990089, i2, -1, "androidx.compose.material3.SliderImpl (Slider.kt:664)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            sliderState2.setRtl$material3_release(consume == LayoutDirection.Rtl);
            Modifier sliderTapModifier = sliderTapModifier(Modifier.Companion, sliderState2, mutableInteractionSource2, z3);
            Modifier.Companion companion = Modifier.Companion;
            Modifier modifier3 = sliderTapModifier;
            Orientation orientation = Orientation.Horizontal;
            boolean isRtl$material3_release = sliderState2.isRtl$material3_release();
            Modifier.Companion companion2 = companion;
            boolean isDragging$material3_release = sliderState2.isDragging$material3_release();
            Modifier modifier4 = companion2;
            DraggableState draggableState = sliderState2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 174725888, "CC(remember):Slider.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(sliderState2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            String str = "CC(remember):Slider.kt#9igjgp";
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SliderKt$SliderImpl$drag$1$1(sliderState2, (Continuation<? super SliderKt$SliderImpl$drag$1$1>) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            z2 = z;
            String str2 = str;
            int i4 = i2;
            MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource;
            Modifier draggable$default = DraggableKt.draggable$default(modifier4, draggableState, orientation, z2, mutableInteractionSource3, isDragging$material3_release, (Function3) null, (Function3) rememberedValue, isRtl$material3_release, 32, (Object) null);
            mutableInteractionSource2 = mutableInteractionSource3;
            Modifier then = FocusableKt.focusable(sliderSemantics(SizeKt.m841requiredSizeInqDBjuR0$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier), ThumbWidth, TrackHeight, 0.0f, 0.0f, 12, (Object) null), sliderState2, z2), z2, mutableInteractionSource2).then(modifier3).then(draggable$default);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 174754537, str2);
            boolean changedInstance2 = startRestartGroup.changedInstance(sliderState2);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new SliderKt$SliderImpl$2$1(sliderState2);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, then);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
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
            Composer r11 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r11, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r11, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r11.getInserting() || !Intrinsics.areEqual(r11.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r11.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r11.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r11, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -610171494, "C682@30354L85,680@30227L271,688@30511L74:Slider.kt#uh7d8r");
            Modifier wrapContentWidth$default = SizeKt.wrapContentWidth$default(LayoutIdKt.layoutId(Modifier.Companion, SliderComponents.THUMB), (Alignment.Horizontal) null, false, 3, (Object) null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 534510168, str2);
            boolean changedInstance3 = startRestartGroup.changedInstance(sliderState2);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new SliderKt$SliderImpl$1$1$1(sliderState2);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier onSizeChanged = OnRemeasuredModifierKt.onSizeChanged(wrapContentWidth$default, (Function1) rememberedValue3);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, onSizeChanged);
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
            Composer r12 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r12, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r12, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r12.getInserting() || !Intrinsics.areEqual(r12.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                r12.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                r12.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3682setimpl(r12, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -469300363, "C686@30472L12:Slider.kt#uh7d8r");
            int i5 = (i4 >> 3) & 14;
            function33 = function3;
            function33.invoke(sliderState2, startRestartGroup, Integer.valueOf(((i4 >> 9) & 112) | i5));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier layoutId = LayoutIdKt.layoutId(Modifier.Companion, SliderComponents.TRACK);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, layoutId);
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
            Composer r8 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r8, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r8, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r8.getInserting() || !Intrinsics.areEqual(r8.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash3))) {
                r8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                r8.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3682setimpl(r8, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -469202155, "C688@30571L12:Slider.kt#uh7d8r");
            function35 = function32;
            function35.invoke(sliderState2, startRestartGroup, Integer.valueOf(((i4 >> 12) & 112) | i5));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            function33 = function34;
            z2 = z3;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SliderKt$SliderImpl$3(modifier, sliderState2, z2, mutableInteractionSource2, function33, function35, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void RangeSliderImpl(Modifier modifier, RangeSliderState rangeSliderState, boolean z, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function32, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function33, Composer composer, int i) {
        int i2;
        Modifier modifier2;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function34;
        RangeSliderState rangeSliderState2 = rangeSliderState;
        boolean z2 = z;
        MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource;
        MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function35 = function3;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function36 = function32;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function37 = function33;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1411725677);
        ComposerKt.sourceInformation(startRestartGroup, "C(RangeSliderImpl)P(3,6!1,4!1,5)736@32503L7,746@32756L35,747@32824L33,784@34404L2230,749@32863L3771:Slider.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i2 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(rangeSliderState2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changed((Object) mutableInteractionSource3) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i2 |= startRestartGroup.changed((Object) mutableInteractionSource4) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(function35) ? 131072 : 65536;
        }
        if ((1572864 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(function36) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(function37) ? 8388608 : 4194304;
        }
        if ((4793491 & i2) != 4793490 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1411725677, i2, -1, "androidx.compose.material3.RangeSliderImpl (Slider.kt:735)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            rangeSliderState2.setRtl$material3_release(consume == LayoutDirection.Rtl);
            Modifier rangeSliderPressDragModifier = rangeSliderPressDragModifier(Modifier.Companion, rangeSliderState2, mutableInteractionSource3, mutableInteractionSource4, z2);
            Strings.Companion companion = Strings.Companion;
            String r12 = Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.range_start), startRestartGroup, 0);
            Strings.Companion companion2 = Strings.Companion;
            String r15 = Strings_androidKt.m2992getString2EP1pXo(Strings.m2922constructorimpl(R.string.range_end), startRestartGroup, 0);
            Modifier then = SizeKt.m841requiredSizeInqDBjuR0$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2), ThumbWidth, TrackHeight, 0.0f, 0.0f, 12, (Object) null).then(rangeSliderPressDragModifier);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1662324209, "CC(remember):Slider.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(rangeSliderState2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SliderKt$RangeSliderImpl$2$1(rangeSliderState2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, then);
            int i4 = i2;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
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
            Composer r8 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r8, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r8, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r8.getInserting() || !Intrinsics.areEqual(r8.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r8.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r8, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2110426496, "C755@33080L46,757@33259L100,751@32893L598,768@33689L44,770@33864L98,764@33504L586,777@34103L79:Slider.kt#uh7d8r");
            Modifier wrapContentWidth$default = SizeKt.wrapContentWidth$default(LayoutIdKt.layoutId(Modifier.Companion, RangeSliderComponents.STARTTHUMB), (Alignment.Horizontal) null, false, 3, (Object) null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1176461672, "CC(remember):Slider.kt#9igjgp");
            boolean changedInstance2 = startRestartGroup.changedInstance(rangeSliderState2);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new SliderKt$RangeSliderImpl$1$1$1(rangeSliderState2);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier rangeSliderStartThumbSemantics = rangeSliderStartThumbSemantics(OnRemeasuredModifierKt.onSizeChanged(wrapContentWidth$default, (Function1) rememberedValue2), rangeSliderState2, z2);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1176467454, "CC(remember):Slider.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) r12);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new SliderKt$RangeSliderImpl$1$2$1(r12);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier focusable = FocusableKt.focusable(SemanticsModifierKt.semantics(rangeSliderStartThumbSemantics, true, (Function1) rememberedValue3), z2, mutableInteractionSource3);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, focusable);
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
            Composer r4 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r4, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r4, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r4.getInserting() || !Intrinsics.areEqual(r4.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                r4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                r4.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3682setimpl(r4, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 259534201, "C762@33460L17:Slider.kt#uh7d8r");
            int i5 = (i4 >> 3) & 14;
            function35.invoke(rangeSliderState2, startRestartGroup, Integer.valueOf(((i4 >> 12) & 112) | i5));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier wrapContentWidth$default2 = SizeKt.wrapContentWidth$default(LayoutIdKt.layoutId(Modifier.Companion, RangeSliderComponents.ENDTHUMB), (Alignment.Horizontal) null, false, 3, (Object) null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1176481158, "CC(remember):Slider.kt#9igjgp");
            boolean changedInstance3 = startRestartGroup.changedInstance(rangeSliderState2);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new SliderKt$RangeSliderImpl$1$4$1(rangeSliderState2);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier rangeSliderEndThumbSemantics = rangeSliderEndThumbSemantics(OnRemeasuredModifierKt.onSizeChanged(wrapContentWidth$default2, (Function1) rememberedValue4), rangeSliderState2, z2);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1176486812, "CC(remember):Slider.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed((Object) r15);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = new SliderKt$RangeSliderImpl$1$5$1(r15);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier focusable2 = FocusableKt.focusable(SemanticsModifierKt.semantics(rangeSliderEndThumbSemantics, true, (Function1) rememberedValue5), z2, mutableInteractionSource4);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, focusable2);
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
            Composer r14 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r14, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r14, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r14.getInserting() || !Intrinsics.areEqual(r14.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash3))) {
                r14.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                r14.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3682setimpl(r14, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 260130331, "C775@34061L15:Slider.kt#uh7d8r");
            function34 = function32;
            function34.invoke(rangeSliderState2, startRestartGroup, Integer.valueOf(((i4 >> 15) & 112) | i5));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier layoutId = LayoutIdKt.layoutId(Modifier.Companion, RangeSliderComponents.TRACK);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, layoutId);
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
            Composer r7 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r7, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r7, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r7.getInserting() || !Intrinsics.areEqual(r7.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash4))) {
                r7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                r7.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m3682setimpl(r7, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 260236382, "C777@34168L12:Slider.kt#uh7d8r");
            function37 = function33;
            function37.invoke(rangeSliderState2, startRestartGroup, Integer.valueOf(((i4 >> 18) & 112) | i5));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            function34 = function36;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SliderKt$RangeSliderImpl$3(modifier, rangeSliderState2, z2, mutableInteractionSource, mutableInteractionSource4, function35, function34, function37, i));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0067 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: awaitSlop-8vUncbI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m2493awaitSlop8vUncbI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r8, long r9, int r11, kotlin.coroutines.Continuation<? super kotlin.Pair<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float>> r12) {
        /*
            boolean r0 = r12 instanceof androidx.compose.material3.SliderKt$awaitSlop$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            androidx.compose.material3.SliderKt$awaitSlop$1 r0 = (androidx.compose.material3.SliderKt$awaitSlop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            androidx.compose.material3.SliderKt$awaitSlop$1 r0 = new androidx.compose.material3.SliderKt$awaitSlop$1
            r0.<init>(r12)
        L_0x0019:
            r6 = r0
            java.lang.Object r12 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L_0x0037
            if (r1 != r2) goto L_0x002f
            java.lang.Object r8 = r6.L$0
            kotlin.jvm.internal.Ref$FloatRef r8 = (kotlin.jvm.internal.Ref.FloatRef) r8
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0058
        L_0x002f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r12)
            kotlin.jvm.internal.Ref$FloatRef r12 = new kotlin.jvm.internal.Ref$FloatRef
            r12.<init>()
            androidx.compose.material3.SliderKt$awaitSlop$postPointerSlop$1 r1 = new androidx.compose.material3.SliderKt$awaitSlop$postPointerSlop$1
            r1.<init>(r12)
            r5 = r1
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r6.L$0 = r12
            r6.label = r2
            r1 = r8
            r2 = r9
            r4 = r11
            java.lang.Object r8 = androidx.compose.material3.internal.DragGestureDetectorCopyKt.m2906awaitHorizontalPointerSlopOrCancellationgDDlDlE(r1, r2, r4, r5, r6)
            if (r8 != r0) goto L_0x0055
            return r0
        L_0x0055:
            r7 = r12
            r12 = r8
            r8 = r7
        L_0x0058:
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            if (r12 == 0) goto L_0x0067
            float r8 = r8.element
            java.lang.Float r8 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r8)
            kotlin.Pair r8 = kotlin.TuplesKt.to(r12, r8)
            return r8
        L_0x0067:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.m2493awaitSlop8vUncbI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final float[] stepsToTickFractions(int i) {
        if (i == 0) {
            return new float[0];
        }
        int i2 = i + 2;
        float[] fArr = new float[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            fArr[i3] = ((float) i3) / ((float) (i + 1));
        }
        return fArr;
    }

    /* access modifiers changed from: private */
    public static final float scale(float f, float f2, float f3, float f4, float f5) {
        return MathHelpersKt.lerp(f4, f5, calcFraction(f, f2, f3));
    }

    /* access modifiers changed from: private */
    /* renamed from: scale-ziovWd0  reason: not valid java name */
    public static final long m2496scaleziovWd0(float f, float f2, long j, float f3, float f4) {
        return SliderRange(scale(f, f2, SliderRange.m2510getStartimpl(j), f3, f4), scale(f, f2, SliderRange.m2509getEndInclusiveimpl(j), f3, f4));
    }

    /* access modifiers changed from: private */
    public static final float calcFraction(float f, float f2, float f3) {
        float f4 = f2 - f;
        return RangesKt.coerceIn(f4 == 0.0f ? 0.0f : (f3 - f) / f4, 0.0f, 1.0f);
    }

    private static final Modifier sliderSemantics(Modifier modifier, SliderState sliderState, boolean z) {
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(modifier, false, new SliderKt$sliderSemantics$1(z, sliderState), 1, (Object) null).then(AccessibilityUtilKt.getIncreaseHorizontalSemanticsBounds()), sliderState.getValue(), RangesKt.rangeTo(sliderState.getValueRange().getStart().floatValue(), sliderState.getValueRange().getEndInclusive().floatValue()), sliderState.getSteps());
    }

    private static final Modifier rangeSliderStartThumbSemantics(Modifier modifier, RangeSliderState rangeSliderState, boolean z) {
        ClosedFloatingPointRange<Float> rangeTo = RangesKt.rangeTo(rangeSliderState.getValueRange().getStart().floatValue(), rangeSliderState.getActiveRangeEnd());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(modifier, false, new SliderKt$rangeSliderStartThumbSemantics$1(z, rangeTo, rangeSliderState), 1, (Object) null).then(AccessibilityUtilKt.getIncreaseHorizontalSemanticsBounds()), rangeSliderState.getActiveRangeStart(), rangeTo, rangeSliderState.getStartSteps$material3_release());
    }

    private static final Modifier rangeSliderEndThumbSemantics(Modifier modifier, RangeSliderState rangeSliderState, boolean z) {
        ClosedFloatingPointRange<Float> rangeTo = RangesKt.rangeTo(rangeSliderState.getActiveRangeStart(), rangeSliderState.getValueRange().getEndInclusive().floatValue());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(modifier, false, new SliderKt$rangeSliderEndThumbSemantics$1(z, rangeTo, rangeSliderState), 1, (Object) null).then(AccessibilityUtilKt.getIncreaseHorizontalSemanticsBounds()), rangeSliderState.getActiveRangeEnd(), rangeTo, rangeSliderState.getEndSteps$material3_release());
    }

    private static final Modifier sliderTapModifier(Modifier modifier, SliderState sliderState, MutableInteractionSource mutableInteractionSource, boolean z) {
        return z ? SuspendingPointerInputFilterKt.pointerInput(modifier, sliderState, mutableInteractionSource, new SliderKt$sliderTapModifier$1(sliderState, (Continuation<? super SliderKt$sliderTapModifier$1>) null)) : modifier;
    }

    private static final Modifier rangeSliderPressDragModifier(Modifier modifier, RangeSliderState rangeSliderState, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, boolean z) {
        return z ? SuspendingPointerInputFilterKt.pointerInput(modifier, new Object[]{mutableInteractionSource, mutableInteractionSource2, rangeSliderState}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new SliderKt$rangeSliderPressDragModifier$1(rangeSliderState, mutableInteractionSource, mutableInteractionSource2, (Continuation<? super SliderKt$rangeSliderPressDragModifier$1>) null)) : modifier;
    }

    static {
        float r0 = SliderTokens.INSTANCE.m3517getHandleWidthD9Ej5fM();
        ThumbWidth = r0;
        float r1 = SliderTokens.INSTANCE.m3516getHandleHeightD9Ej5fM();
        ThumbHeight = r1;
        ThumbSize = DpKt.m7133DpSizeYgX7TsA(r0, r1);
    }

    public static final float getTrackHeight() {
        return TrackHeight;
    }

    public static final float getThumbWidth() {
        return ThumbWidth;
    }

    public static final long SliderRange(float f, float f2) {
        if ((!Float.isNaN(f) || !Float.isNaN(f2)) && ((double) f) > ((double) f2) + SliderRangeTolerance) {
            throw new IllegalArgumentException(("start(" + f + ") must be <= endInclusive(" + f2 + ')').toString());
        }
        long floatToRawIntBits = (long) Float.floatToRawIntBits(f);
        return SliderRange.m2506constructorimpl((((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (floatToRawIntBits << 32));
    }

    public static final long SliderRange(ClosedFloatingPointRange<Float> closedFloatingPointRange) {
        float floatValue = closedFloatingPointRange.getStart().floatValue();
        float floatValue2 = closedFloatingPointRange.getEndInclusive().floatValue();
        if ((Float.isNaN(floatValue) && Float.isNaN(floatValue2)) || ((double) floatValue) <= ((double) floatValue2) + SliderRangeTolerance) {
            return SliderRange.m2506constructorimpl((((long) Float.floatToRawIntBits(floatValue)) << 32) | (((long) Float.floatToRawIntBits(floatValue2)) & 4294967295L));
        }
        throw new IllegalArgumentException(("ClosedFloatingPointRange<Float>.start(" + floatValue + ") must be <= ClosedFloatingPoint.endInclusive(" + floatValue2 + ')').toString());
    }

    /* renamed from: isSpecified-If1S1O4  reason: not valid java name */
    public static final boolean m2494isSpecifiedIf1S1O4(long j) {
        return j != SliderRange.Companion.m2515getUnspecifiedFYbKRX4();
    }

    /* access modifiers changed from: private */
    public static final float snapValueToTick(float f, float[] fArr, float f2, float f3) {
        Float f4;
        if (fArr.length == 0) {
            f4 = null;
        } else {
            float f5 = fArr[0];
            int lastIndex = ArraysKt.getLastIndex(fArr);
            if (lastIndex == 0) {
                f4 = Float.valueOf(f5);
            } else {
                float abs = Math.abs(MathHelpersKt.lerp(f2, f3, f5) - f);
                IntIterator it = new IntRange(1, lastIndex).iterator();
                while (it.hasNext()) {
                    float f6 = fArr[it.nextInt()];
                    float abs2 = Math.abs(MathHelpersKt.lerp(f2, f3, f6) - f);
                    if (Float.compare(abs, abs2) > 0) {
                        f5 = f6;
                        abs = abs2;
                    }
                }
                f4 = Float.valueOf(f5);
            }
        }
        return f4 != null ? MathHelpersKt.lerp(f2, f3, f4.floatValue()) : f;
    }
}
