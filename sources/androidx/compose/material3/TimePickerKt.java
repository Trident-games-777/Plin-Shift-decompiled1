package androidx.compose.material3;

import androidx.collection.IntList;
import androidx.collection.IntListKt;
import androidx.collection.MutableIntList;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.TimeInputTokens;
import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.ws.WebSocketProtocol;

@Metadata(d1 = {"\u0000Â\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\u001a7\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00012\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020#0(¢\u0006\u0002\b)H\u0003ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a\u001d\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/H\u0003¢\u0006\u0002\u00100\u001a%\u00101\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020/2\u0006\u00102\u001a\u000203H\u0001¢\u0006\u0002\u00104\u001a-\u00105\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010-\u001a\u00020\u001f2\u0006\u00106\u001a\u00020\u00192\u0006\u00102\u001a\u000203H\u0003¢\u0006\u0002\u00107\u001a\u0015\u00108\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0003¢\u0006\u0002\u00109\u001a\u001d\u0010:\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/H\u0003¢\u0006\u0002\u00100\u001a%\u0010;\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/H\u0003¢\u0006\u0002\u0010<\u001a1\u0010=\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001f2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010.\u001a\u00020/2\u0006\u00102\u001a\u000203H\u0001¢\u0006\u0002\u0010>\u001a=\u0010?\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020CH\u0003¢\u0006\u0002\u0010E\u001a)\u0010F\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001a2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010.\u001a\u00020/H\u0007¢\u0006\u0002\u0010G\u001a%\u0010H\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010.\u001a\u00020/2\u0006\u0010-\u001a\u00020\u001aH\u0003¢\u0006\u0002\u0010I\u001a8\u0010J\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001a2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u0010K\u001a\u00020LH\u0007ø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001a \u0010O\u001a\u00020\u001a2\u0006\u0010P\u001a\u00020\u00192\u0006\u0010Q\u001a\u00020\u00192\u0006\u0010R\u001a\u000203H\u0007\u001ab\u0010S\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u00106\u001a\u00020T2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020#0V2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010W\u001a\u00020X2\b\b\u0002\u0010Y\u001a\u00020Z2\b\b\u0002\u0010[\u001a\u00020\\2\u0006\u0010.\u001a\u00020/H\u0003ø\u0001\u0000¢\u0006\u0004\b]\u0010^\u001a:\u0010_\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u00106\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010W\u001a\u00020X2\u0006\u0010.\u001a\u00020/H\u0003ø\u0001\u0000¢\u0006\u0004\b`\u0010a\u001aQ\u0010b\u001a\u00020#2\u0006\u0010c\u001a\u0002032\u0006\u0010d\u001a\u00020C2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020#0(2\u0006\u0010.\u001a\u00020/2\u001c\u0010'\u001a\u0018\u0012\u0004\u0012\u00020f\u0012\u0004\u0012\u00020#0V¢\u0006\u0002\b)¢\u0006\u0002\bgH\u0003¢\u0006\u0002\u0010h\u001a\u001d\u0010i\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/H\u0003¢\u0006\u0002\u00100\u001a%\u0010j\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/H\u0003¢\u0006\u0002\u0010<\u001a1\u0010k\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001f2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010.\u001a\u00020/2\u0006\u00102\u001a\u000203H\u0001¢\u0006\u0002\u0010>\u001a\u0018\u0010l\u001a\u00020\b2\u0006\u0010m\u001a\u00020\b2\u0006\u0010n\u001a\u00020\bH\u0002\u001a(\u0010o\u001a\u00020\b2\u0006\u0010p\u001a\u00020\b2\u0006\u0010q\u001a\u00020\b2\u0006\u0010r\u001a\u00020\u00192\u0006\u0010s\u001a\u00020\u0019H\u0002\u001a*\u0010t\u001a\u00020u2\u0006\u0010W\u001a\u00020X2\u0006\u0010R\u001a\u0002032\u0006\u0010v\u001a\u00020\u0019H\u0001ø\u0001\u0000¢\u0006\u0004\bw\u0010x\u001a+\u0010y\u001a\u00020\u001a2\b\b\u0002\u0010P\u001a\u00020\u00192\b\b\u0002\u0010Q\u001a\u00020\u00192\b\b\u0002\u0010R\u001a\u000203H\u0007¢\u0006\u0002\u0010z\u001a`\u0010{\u001a\u00020#2\u0006\u0010W\u001a\u00020X2\u0006\u0010-\u001a\u00020\u001a2\u0006\u00106\u001a\u00020T2\u0006\u0010|\u001a\u00020T2\u0006\u0010}\u001a\u00020\u00192\"\u0010~\u001a\u001e\u0012\u0014\u0012\u00120T¢\u0006\r\b\u0012\t\b\u0001\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020#0VH\u0002ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001\u001a\u001d\u0010\u0001\u001a\u00020%*\u00020%2\u0006\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020/H\u0002\u001a<\u0010\u0001\u001a\u00020#*\u00020\u001a2\u0006\u0010n\u001a\u00020\b2\u0006\u0010m\u001a\u00020\b2\u0007\u0010\u0001\u001a\u00020\b2\b\u0010\u0001\u001a\u00030\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001\u001aE\u0010\u0001\u001a\u00020#*\u00020\u001f2\u0006\u0010n\u001a\u00020\b2\u0006\u0010m\u001a\u00020\b2\u0007\u0010\u0001\u001a\u00020\b2\u0006\u00102\u001a\u0002032\b\u0010\u0001\u001a\u00030\u0001H@ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001\u001a\u0016\u0010\u0001\u001a\u00020%*\u00020%2\u0007\u0010\u0001\u001a\u000203H\u0003\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u000b\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\f\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\r\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u000e\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u000f\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0010\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0011\u001a\u00020\u0012XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0016\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0017\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0018\u0010\u0018\u001a\u00020\u0019*\u00020\u001a8@X\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u0018\u0010\u001d\u001a\u00020\u001e*\u00020\u001f8@X\u0004¢\u0006\u0006\u001a\u0004\b \u0010!\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0001²\u0006\u000b\u0010\u0001\u001a\u000203X\u0002²\u0006\u000b\u0010\u0001\u001a\u00020TX\u0002²\u0006\u000b\u0010\u0001\u001a\u00020TX\u0002²\u0006\f\u0010\u0001\u001a\u00030\u0001X\u0002²\u0006\f\u0010\u0001\u001a\u00030\u0001X\u0002"}, d2 = {"ClockDisplayBottomMargin", "Landroidx/compose/ui/unit/Dp;", "F", "ClockFaceBottomMargin", "DisplaySeparatorWidth", "ExtraHours", "Landroidx/collection/IntList;", "FullCircle", "", "HalfCircle", "Hours", "InnerCircleRadius", "MaxDistance", "MinimumInteractiveSize", "Minutes", "OuterCircleSizeRadius", "PeriodToggleMargin", "QuarterCircle", "", "RadiansPerHour", "RadiansPerMinute", "SeparatorZIndex", "SupportLabelTop", "TimeInputBottomPadding", "hourForDisplay", "", "Landroidx/compose/material3/TimePickerState;", "getHourForDisplay", "(Landroidx/compose/material3/TimePickerState;)I", "selectorPos", "Landroidx/compose/ui/unit/DpOffset;", "Landroidx/compose/material3/AnalogTimePickerState;", "getSelectorPos", "(Landroidx/compose/material3/AnalogTimePickerState;)J", "CircularLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "radius", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "CircularLayout-uFdPcIQ", "(Landroidx/compose/ui/Modifier;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ClockDisplayNumbers", "state", "colors", "Landroidx/compose/material3/TimePickerColors;", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "ClockFace", "autoSwitchToMinute", "", "(Landroidx/compose/material3/AnalogTimePickerState;Landroidx/compose/material3/TimePickerColors;ZLandroidx/compose/runtime/Composer;I)V", "ClockText", "value", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/AnalogTimePickerState;IZLandroidx/compose/runtime/Composer;I)V", "DisplaySeparator", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "HorizontalClockDisplay", "HorizontalPeriodToggle", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "HorizontalTimePicker", "(Landroidx/compose/material3/AnalogTimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;ZLandroidx/compose/runtime/Composer;II)V", "PeriodToggleImpl", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "startShape", "Landroidx/compose/ui/graphics/Shape;", "endShape", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)V", "TimeInput", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;II)V", "TimeInputImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/material3/TimePickerState;Landroidx/compose/runtime/Composer;I)V", "TimePicker", "layoutType", "Landroidx/compose/material3/TimePickerLayoutType;", "TimePicker-mT9BvqQ", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;ILandroidx/compose/runtime/Composer;II)V", "TimePickerState", "initialHour", "initialMinute", "is24Hour", "TimePickerTextField", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "selection", "Landroidx/compose/material3/TimePickerSelectionMode;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "TimePickerTextField-1vLObsk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/TimePickerState;ILandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;II)V", "TimeSelector", "TimeSelector-SAnMeKU", "(Landroidx/compose/ui/Modifier;ILandroidx/compose/material3/TimePickerState;ILandroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "ToggleItem", "checked", "shape", "onClick", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "(ZLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/TimePickerColors;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "VerticalClockDisplay", "VerticalPeriodToggle", "VerticalTimePicker", "atan", "y", "x", "dist", "x1", "y1", "x2", "y2", "numberContentDescription", "", "number", "numberContentDescription-dSwYdS4", "(IZILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "rememberTimePickerState", "(IIZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TimePickerState;", "timeInputOnChange", "prevValue", "max", "onNewValue", "Lkotlin/ParameterName;", "name", "timeInputOnChange-z7XvuPQ", "(ILandroidx/compose/material3/TimePickerState;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/TextFieldValue;ILkotlin/jvm/functions/Function1;)V", "drawSelector", "moveSelector", "maxDist", "center", "Landroidx/compose/ui/unit/IntOffset;", "moveSelector-d3b8Pxo", "(Landroidx/compose/material3/TimePickerState;FFFJ)V", "onTap", "onTap-rOwcSBo", "(Landroidx/compose/material3/AnalogTimePickerState;FFFZJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "visible", "material3_release", "a11yServicesEnabled", "hourValue", "minuteValue", "Landroidx/compose/ui/geometry/Offset;", "parentCenter"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
public final class TimePickerKt {
    private static final float ClockDisplayBottomMargin = Dp.m7111constructorimpl((float) 36);
    private static final float ClockFaceBottomMargin;
    /* access modifiers changed from: private */
    public static final float DisplaySeparatorWidth;
    /* access modifiers changed from: private */
    public static final IntList ExtraHours;
    private static final float FullCircle = 6.2831855f;
    private static final float HalfCircle = 3.1415927f;
    /* access modifiers changed from: private */
    public static final IntList Hours;
    /* access modifiers changed from: private */
    public static final float InnerCircleRadius = Dp.m7111constructorimpl((float) 69);
    /* access modifiers changed from: private */
    public static final float MaxDistance = Dp.m7111constructorimpl((float) 74);
    private static final float MinimumInteractiveSize = Dp.m7111constructorimpl((float) 48);
    /* access modifiers changed from: private */
    public static final IntList Minutes = IntListKt.intListOf(0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55);
    /* access modifiers changed from: private */
    public static final float OuterCircleSizeRadius = Dp.m7111constructorimpl((float) 101);
    private static final float PeriodToggleMargin = Dp.m7111constructorimpl((float) 12);
    private static final double QuarterCircle = 1.5707963267948966d;
    private static final float RadiansPerHour = 0.5235988f;
    private static final float RadiansPerMinute = 0.10471976f;
    private static final float SeparatorZIndex = 2.0f;
    private static final float SupportLabelTop = Dp.m7111constructorimpl((float) 7);
    private static final float TimeInputBottomPadding;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: androidx.compose.material3.AnalogTimePickerState} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x015e  */
    /* renamed from: TimePicker-mT9BvqQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2720TimePickermT9BvqQ(androidx.compose.material3.TimePickerState r13, androidx.compose.ui.Modifier r14, androidx.compose.material3.TimePickerColors r15, int r16, androidx.compose.runtime.Composer r17, int r18, int r19) {
        /*
            r5 = r18
            r0 = -619286452(0xffffffffdb16704c, float:-4.2344718E16)
            r1 = r17
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(TimePicker)P(3,2!,1:c#material3.TimePickerLayoutType)218@11441L8,219@11509L12,221@11558L35,222@11616L48:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r19 & 1
            r2 = 4
            if (r1 == 0) goto L_0x0018
            r1 = r5 | 6
            goto L_0x0031
        L_0x0018:
            r1 = r5 & 6
            if (r1 != 0) goto L_0x0030
            r1 = r5 & 8
            if (r1 != 0) goto L_0x0025
            boolean r1 = r10.changed((java.lang.Object) r13)
            goto L_0x0029
        L_0x0025:
            boolean r1 = r10.changedInstance(r13)
        L_0x0029:
            if (r1 == 0) goto L_0x002d
            r1 = r2
            goto L_0x002e
        L_0x002d:
            r1 = 2
        L_0x002e:
            r1 = r1 | r5
            goto L_0x0031
        L_0x0030:
            r1 = r5
        L_0x0031:
            r3 = r19 & 2
            if (r3 == 0) goto L_0x0038
            r1 = r1 | 48
            goto L_0x0048
        L_0x0038:
            r4 = r5 & 48
            if (r4 != 0) goto L_0x0048
            boolean r4 = r10.changed((java.lang.Object) r14)
            if (r4 == 0) goto L_0x0045
            r4 = 32
            goto L_0x0047
        L_0x0045:
            r4 = 16
        L_0x0047:
            r1 = r1 | r4
        L_0x0048:
            r4 = r5 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x005c
            r4 = r19 & 4
            if (r4 != 0) goto L_0x0059
            boolean r4 = r10.changed((java.lang.Object) r15)
            if (r4 == 0) goto L_0x0059
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x005b
        L_0x0059:
            r4 = 128(0x80, float:1.794E-43)
        L_0x005b:
            r1 = r1 | r4
        L_0x005c:
            r4 = r5 & 3072(0xc00, float:4.305E-42)
            if (r4 != 0) goto L_0x0075
            r4 = r19 & 8
            if (r4 != 0) goto L_0x006f
            r4 = r16
            boolean r6 = r10.changed((int) r4)
            if (r6 == 0) goto L_0x0071
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x0073
        L_0x006f:
            r4 = r16
        L_0x0071:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x0073:
            r1 = r1 | r6
            goto L_0x0077
        L_0x0075:
            r4 = r16
        L_0x0077:
            r6 = r1 & 1171(0x493, float:1.641E-42)
            r7 = 1170(0x492, float:1.64E-42)
            if (r6 != r7) goto L_0x008b
            boolean r6 = r10.getSkipping()
            if (r6 != 0) goto L_0x0084
            goto L_0x008b
        L_0x0084:
            r10.skipToGroupEnd()
            r2 = r14
            r3 = r15
            goto L_0x0163
        L_0x008b:
            r10.startDefaults()
            r6 = r5 & 1
            if (r6 == 0) goto L_0x00a9
            boolean r6 = r10.getDefaultsInvalid()
            if (r6 == 0) goto L_0x0099
            goto L_0x00a9
        L_0x0099:
            r10.skipToGroupEnd()
            r3 = r19 & 4
            if (r3 == 0) goto L_0x00a2
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00a2:
            r3 = r19 & 8
            if (r3 == 0) goto L_0x00cc
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x00cc
        L_0x00a9:
            if (r3 == 0) goto L_0x00af
            androidx.compose.ui.Modifier$Companion r14 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r14 = (androidx.compose.ui.Modifier) r14
        L_0x00af:
            r3 = r19 & 4
            r6 = 6
            if (r3 == 0) goto L_0x00bc
            androidx.compose.material3.TimePickerDefaults r15 = androidx.compose.material3.TimePickerDefaults.INSTANCE
            androidx.compose.material3.TimePickerColors r15 = r15.colors(r10, r6)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00bc:
            r3 = r19 & 8
            if (r3 == 0) goto L_0x00cc
            androidx.compose.material3.TimePickerDefaults r3 = androidx.compose.material3.TimePickerDefaults.INSTANCE
            int r3 = r3.m2718layoutTypesDNSZnc(r10, r6)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r7 = r14
            r8 = r15
            r4 = r3
            goto L_0x00ce
        L_0x00cc:
            r7 = r14
            r8 = r15
        L_0x00ce:
            r10.endDefaults()
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto L_0x00dd
            r14 = -1
            java.lang.String r15 = "androidx.compose.material3.TimePicker (TimePicker.kt:220)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r14, r15)
        L_0x00dd:
            r14 = 3
            r15 = 0
            androidx.compose.runtime.State r14 = androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt.rememberAccessibilityServiceState(r15, r15, r10, r15, r14)
            r0 = -2089091954(0xffffffff837afc8e, float:-7.3758315E-37)
            java.lang.String r3 = "CC(remember):TimePicker.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r0, r3)
            r0 = r1 & 14
            r3 = 1
            if (r0 == r2) goto L_0x00fa
            r0 = r1 & 8
            if (r0 == 0) goto L_0x00fb
            boolean r0 = r10.changed((java.lang.Object) r13)
            if (r0 == 0) goto L_0x00fb
        L_0x00fa:
            r15 = r3
        L_0x00fb:
            java.lang.Object r0 = r10.rememberedValue()
            if (r15 != 0) goto L_0x0109
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            if (r0 != r15) goto L_0x0111
        L_0x0109:
            androidx.compose.material3.AnalogTimePickerState r0 = new androidx.compose.material3.AnalogTimePickerState
            r0.<init>(r13)
            r10.updateRememberedValue(r0)
        L_0x0111:
            r6 = r0
            androidx.compose.material3.AnalogTimePickerState r6 = (androidx.compose.material3.AnalogTimePickerState) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.material3.TimePickerLayoutType$Companion r15 = androidx.compose.material3.TimePickerLayoutType.Companion
            int r15 = r15.m2746getVerticalQJTpgSE()
            boolean r15 = androidx.compose.material3.TimePickerLayoutType.m2741equalsimpl0(r4, r15)
            if (r15 == 0) goto L_0x013e
            r15 = -337235422(0xffffffffebe63222, float:-5.5657937E26)
            r10.startReplaceGroup(r15)
            java.lang.String r15 = "224@11728L178"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r15)
            boolean r14 = TimePicker_mT9BvqQ$lambda$0(r14)
            r9 = r14 ^ 1
            r11 = r1 & 1008(0x3f0, float:1.413E-42)
            r12 = 0
            VerticalTimePicker(r6, r7, r8, r9, r10, r11, r12)
            r10.endReplaceGroup()
            goto L_0x0158
        L_0x013e:
            r15 = -337036960(0xffffffffebe93960, float:-5.6390132E26)
            r10.startReplaceGroup(r15)
            java.lang.String r15 = "231@11928L180"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r15)
            boolean r14 = TimePicker_mT9BvqQ$lambda$0(r14)
            r9 = r14 ^ 1
            r11 = r1 & 1008(0x3f0, float:1.413E-42)
            r12 = 0
            HorizontalTimePicker(r6, r7, r8, r9, r10, r11, r12)
            r10.endReplaceGroup()
        L_0x0158:
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto L_0x0161
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0161:
            r2 = r7
            r3 = r8
        L_0x0163:
            androidx.compose.runtime.ScopeUpdateScope r14 = r10.endRestartGroup()
            if (r14 == 0) goto L_0x0176
            androidx.compose.material3.TimePickerKt$TimePicker$1 r0 = new androidx.compose.material3.TimePickerKt$TimePicker$1
            r1 = r13
            r6 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r14.updateScope(r0)
        L_0x0176:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.m2720TimePickermT9BvqQ(androidx.compose.material3.TimePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerColors, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x007e, code lost:
        if ((r12 & 4) != 0) goto L_0x0091;
     */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TimeInput(androidx.compose.material3.TimePickerState r7, androidx.compose.ui.Modifier r8, androidx.compose.material3.TimePickerColors r9, androidx.compose.runtime.Composer r10, int r11, int r12) {
        /*
            r0 = -760850373(0xffffffffd2a6583b, float:-3.57222416E11)
            androidx.compose.runtime.Composer r10 = r10.startRestartGroup(r0)
            java.lang.String r1 = "C(TimeInput)P(2,1)259@12999L8,261@13017L38:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x0013
            r1 = r11 | 6
            goto L_0x002c
        L_0x0013:
            r1 = r11 & 6
            if (r1 != 0) goto L_0x002b
            r1 = r11 & 8
            if (r1 != 0) goto L_0x0020
            boolean r1 = r10.changed((java.lang.Object) r7)
            goto L_0x0024
        L_0x0020:
            boolean r1 = r10.changedInstance(r7)
        L_0x0024:
            if (r1 == 0) goto L_0x0028
            r1 = 4
            goto L_0x0029
        L_0x0028:
            r1 = 2
        L_0x0029:
            r1 = r1 | r11
            goto L_0x002c
        L_0x002b:
            r1 = r11
        L_0x002c:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0033
            r1 = r1 | 48
            goto L_0x0043
        L_0x0033:
            r3 = r11 & 48
            if (r3 != 0) goto L_0x0043
            boolean r3 = r10.changed((java.lang.Object) r8)
            if (r3 == 0) goto L_0x0040
            r3 = 32
            goto L_0x0042
        L_0x0040:
            r3 = 16
        L_0x0042:
            r1 = r1 | r3
        L_0x0043:
            r3 = r11 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x0057
            r3 = r12 & 4
            if (r3 != 0) goto L_0x0054
            boolean r3 = r10.changed((java.lang.Object) r9)
            if (r3 == 0) goto L_0x0054
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0056
        L_0x0054:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0056:
            r1 = r1 | r3
        L_0x0057:
            r3 = r1 & 147(0x93, float:2.06E-43)
            r4 = 146(0x92, float:2.05E-43)
            if (r3 != r4) goto L_0x006a
            boolean r3 = r10.getSkipping()
            if (r3 != 0) goto L_0x0064
            goto L_0x006a
        L_0x0064:
            r10.skipToGroupEnd()
        L_0x0067:
            r3 = r8
            r4 = r9
            goto L_0x00b7
        L_0x006a:
            r10.startDefaults()
            r3 = r11 & 1
            r4 = 6
            if (r3 == 0) goto L_0x0081
            boolean r3 = r10.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0079
            goto L_0x0081
        L_0x0079:
            r10.skipToGroupEnd()
            r2 = r12 & 4
            if (r2 == 0) goto L_0x0093
            goto L_0x0091
        L_0x0081:
            if (r2 == 0) goto L_0x0087
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
        L_0x0087:
            r2 = r12 & 4
            if (r2 == 0) goto L_0x0093
            androidx.compose.material3.TimePickerDefaults r9 = androidx.compose.material3.TimePickerDefaults.INSTANCE
            androidx.compose.material3.TimePickerColors r9 = r9.colors(r10, r4)
        L_0x0091:
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0093:
            r10.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x00a2
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.TimeInput (TimePicker.kt:260)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r2, r3)
        L_0x00a2:
            int r0 = r1 >> 3
            r0 = r0 & 126(0x7e, float:1.77E-43)
            int r1 = r1 << r4
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            TimeInputImpl(r8, r9, r7, r10, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0067
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x0067
        L_0x00b7:
            androidx.compose.runtime.ScopeUpdateScope r8 = r10.endRestartGroup()
            if (r8 == 0) goto L_0x00ca
            androidx.compose.material3.TimePickerKt$TimeInput$1 r1 = new androidx.compose.material3.TimePickerKt$TimeInput$1
            r2 = r7
            r5 = r11
            r6 = r12
            r1.<init>(r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r8.updateScope(r1)
        L_0x00ca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.TimeInput(androidx.compose.material3.TimePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerColors, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final TimePickerState rememberTimePickerState(int i, int i2, boolean z, Composer composer, int i3, int i4) {
        int i5 = i3;
        ComposerKt.sourceInformationMarkerStart(composer, 1237715277, "C(rememberTimePickerState)572@28878L14,575@29014L185,575@28960L239:TimePicker.kt#uh7d8r");
        boolean z2 = false;
        int i6 = (i4 & 1) != 0 ? 0 : i;
        int i7 = (i4 & 2) != 0 ? 0 : i2;
        boolean is24HourFormat = (i4 & 4) != 0 ? TimeFormat_androidKt.is24HourFormat(composer, 0) : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1237715277, i5, -1, "androidx.compose.material3.rememberTimePickerState (TimePicker.kt:573)");
        }
        Object[] objArr = new Object[0];
        Saver<TimePickerStateImpl, ?> Saver = TimePickerStateImpl.Companion.Saver();
        ComposerKt.sourceInformationMarkerStart(composer, -1964549601, "CC(remember):TimePicker.kt#9igjgp");
        boolean z3 = ((((i5 & 14) ^ 6) > 4 && composer.changed(i6)) || (i5 & 6) == 4) | ((((i5 & 112) ^ 48) > 32 && composer.changed(i7)) || (i5 & 48) == 32);
        if ((((i5 & 896) ^ 384) > 256 && composer.changed(is24HourFormat)) || (i5 & 384) == 256) {
            z2 = true;
        }
        boolean z4 = z3 | z2;
        Object rememberedValue = composer.rememberedValue();
        if (z4 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new TimePickerKt$rememberTimePickerState$state$1$1(i6, i7, is24HourFormat);
            composer.updateRememberedValue(rememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        TimePickerStateImpl timePickerStateImpl = (TimePickerStateImpl) RememberSaveableKt.rememberSaveable(objArr, Saver, (String) null, (Function0) rememberedValue, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return timePickerStateImpl;
    }

    public static final TimePickerState TimePickerState(int i, int i2, boolean z) {
        return new TimePickerStateImpl(i, i2, z);
    }

    public static final int getHourForDisplay(TimePickerState timePickerState) {
        if (timePickerState.is24hour()) {
            return timePickerState.getHour() % 24;
        }
        if (timePickerState.getHour() % 12 == 0) {
            return 12;
        }
        if (timePickerState.isAfternoon()) {
            return timePickerState.getHour() - 12;
        }
        return timePickerState.getHour();
    }

    /* access modifiers changed from: private */
    /* renamed from: moveSelector-d3b8Pxo  reason: not valid java name */
    public static final void m2729moveSelectord3b8Pxo(TimePickerState timePickerState, float f, float f2, float f3, long j) {
        if (TimePickerSelectionMode.m2750equalsimpl0(timePickerState.m2756getSelectionyecRtBI(), TimePickerSelectionMode.Companion.m2754getHouryecRtBI()) && timePickerState.is24hour()) {
            timePickerState.setAfternoon(dist(f, f2, IntOffset.m7241getXimpl(j), IntOffset.m7242getYimpl(j)) < f3);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00a2, code lost:
        if (r13.rotateTo(r0 * r3, true, r1) == r2) goto L_0x00c5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* renamed from: onTap-rOwcSBo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m2731onTaprOwcSBo(androidx.compose.material3.AnalogTimePickerState r13, float r14, float r15, float r16, boolean r17, long r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            r0 = r20
            boolean r1 = r0 instanceof androidx.compose.material3.TimePickerKt$onTap$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.material3.TimePickerKt$onTap$1 r1 = (androidx.compose.material3.TimePickerKt$onTap$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.material3.TimePickerKt$onTap$1 r1 = new androidx.compose.material3.TimePickerKt$onTap$1
            r1.<init>(r0)
        L_0x001b:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L_0x004b
            if (r3 == r5) goto L_0x003e
            if (r3 != r4) goto L_0x0036
            boolean r13 = r1.Z$0
            java.lang.Object r14 = r1.L$0
            androidx.compose.material3.AnalogTimePickerState r14 = (androidx.compose.material3.AnalogTimePickerState) r14
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x00c9
        L_0x0036:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x003e:
            boolean r13 = r1.Z$0
            java.lang.Object r14 = r1.L$0
            androidx.compose.material3.AnalogTimePickerState r14 = (androidx.compose.material3.AnalogTimePickerState) r14
            kotlin.ResultKt.throwOnFailure(r0)
            r12 = r14
            r14 = r13
            r13 = r12
            goto L_0x00a5
        L_0x004b:
            kotlin.ResultKt.throwOnFailure(r0)
            int r0 = androidx.compose.ui.unit.IntOffset.m7242getYimpl(r18)
            float r0 = (float) r0
            float r0 = r15 - r0
            int r3 = androidx.compose.ui.unit.IntOffset.m7241getXimpl(r18)
            float r3 = (float) r3
            float r3 = r14 - r3
            float r0 = atan(r0, r3)
            int r3 = r13.m1708getSelectionyecRtBI()
            androidx.compose.material3.TimePickerSelectionMode$Companion r6 = androidx.compose.material3.TimePickerSelectionMode.Companion
            int r6 = r6.m2755getMinuteyecRtBI()
            boolean r3 = androidx.compose.material3.TimePickerSelectionMode.m2750equalsimpl0(r3, r6)
            if (r3 == 0) goto L_0x007f
            r3 = 1037465424(0x3dd67750, float:0.10471976)
            float r0 = r0 / r3
            r6 = 1084227584(0x40a00000, float:5.0)
            float r0 = r0 / r6
            double r7 = (double) r0
            double r7 = java.lang.Math.rint(r7)
            float r0 = (float) r7
            float r0 = r0 * r6
            goto L_0x0089
        L_0x007f:
            r3 = 1057360530(0x3f060a92, float:0.5235988)
            float r0 = r0 / r3
            double r6 = (double) r0
            double r6 = java.lang.Math.rint(r6)
            float r0 = (float) r6
        L_0x0089:
            float r0 = r0 * r3
            r6 = r13
            androidx.compose.material3.TimePickerState r6 = (androidx.compose.material3.TimePickerState) r6
            r7 = r14
            r8 = r15
            r9 = r16
            r10 = r18
            m2729moveSelectord3b8Pxo(r6, r7, r8, r9, r10)
            r1.L$0 = r13
            r14 = r17
            r1.Z$0 = r14
            r1.label = r5
            java.lang.Object r0 = r13.rotateTo(r0, r5, r1)
            if (r0 != r2) goto L_0x00a5
            goto L_0x00c5
        L_0x00a5:
            int r0 = r13.m1708getSelectionyecRtBI()
            androidx.compose.material3.TimePickerSelectionMode$Companion r3 = androidx.compose.material3.TimePickerSelectionMode.Companion
            int r3 = r3.m2754getHouryecRtBI()
            boolean r0 = androidx.compose.material3.TimePickerSelectionMode.m2750equalsimpl0(r0, r3)
            if (r0 == 0) goto L_0x00cc
            if (r14 == 0) goto L_0x00cc
            r1.L$0 = r13
            r1.Z$0 = r14
            r1.label = r4
            r3 = 100
            java.lang.Object r0 = kotlinx.coroutines.DelayKt.delay(r3, r1)
            if (r0 != r2) goto L_0x00c6
        L_0x00c5:
            return r2
        L_0x00c6:
            r12 = r14
            r14 = r13
            r13 = r12
        L_0x00c9:
            r12 = r14
            r14 = r13
            r13 = r12
        L_0x00cc:
            if (r14 == 0) goto L_0x00d7
            androidx.compose.material3.TimePickerSelectionMode$Companion r14 = androidx.compose.material3.TimePickerSelectionMode.Companion
            int r14 = r14.m2755getMinuteyecRtBI()
            r13.m1709setSelection6_8s6DQ(r14)
        L_0x00d7:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.m2731onTaprOwcSBo(androidx.compose.material3.AnalogTimePickerState, float, float, float, boolean, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final long getSelectorPos(AnalogTimePickerState analogTimePickerState) {
        float f;
        float f2 = (float) 2;
        float r0 = Dp.m7111constructorimpl(TimePickerTokens.INSTANCE.m3563getClockDialSelectorHandleContainerSizeD9Ej5fM() / f2);
        if (!analogTimePickerState.is24hour() || !analogTimePickerState.isAfternoon() || !TimePickerSelectionMode.m2750equalsimpl0(analogTimePickerState.m1708getSelectionyecRtBI(), TimePickerSelectionMode.Companion.m2754getHouryecRtBI())) {
            f = OuterCircleSizeRadius;
        } else {
            f = InnerCircleRadius;
        }
        float r02 = Dp.m7111constructorimpl(Dp.m7111constructorimpl(f - r0) + r0);
        return DpKt.m7132DpOffsetYgX7TsA(Dp.m7111constructorimpl(Dp.m7111constructorimpl(((float) Math.cos((double) analogTimePickerState.getCurrentAngle())) * r02) + Dp.m7111constructorimpl(TimePickerTokens.INSTANCE.m3561getClockDialContainerSizeD9Ej5fM() / f2)), Dp.m7111constructorimpl(Dp.m7111constructorimpl(r02 * ((float) Math.sin((double) analogTimePickerState.getCurrentAngle()))) + Dp.m7111constructorimpl(TimePickerTokens.INSTANCE.m3561getClockDialContainerSizeD9Ej5fM() / f2)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x008d, code lost:
        if ((r15 & 4) != 0) goto L_0x00a0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void VerticalTimePicker(androidx.compose.material3.AnalogTimePickerState r9, androidx.compose.ui.Modifier r10, androidx.compose.material3.TimePickerColors r11, boolean r12, androidx.compose.runtime.Composer r13, int r14, int r15) {
        /*
            r0 = 1249591487(0x4a7b40bf, float:4116527.8)
            androidx.compose.runtime.Composer r13 = r13.startRestartGroup(r0)
            java.lang.String r1 = "C(VerticalTimePicker)P(3,2,1)927@40188L8,930@40238L379:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            r1 = r15 & 1
            if (r1 == 0) goto L_0x0013
            r1 = r14 | 6
            goto L_0x0023
        L_0x0013:
            r1 = r14 & 6
            if (r1 != 0) goto L_0x0022
            boolean r1 = r13.changedInstance(r9)
            if (r1 == 0) goto L_0x001f
            r1 = 4
            goto L_0x0020
        L_0x001f:
            r1 = 2
        L_0x0020:
            r1 = r1 | r14
            goto L_0x0023
        L_0x0022:
            r1 = r14
        L_0x0023:
            r2 = r15 & 2
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 48
            goto L_0x003a
        L_0x002a:
            r3 = r14 & 48
            if (r3 != 0) goto L_0x003a
            boolean r3 = r13.changed((java.lang.Object) r10)
            if (r3 == 0) goto L_0x0037
            r3 = 32
            goto L_0x0039
        L_0x0037:
            r3 = 16
        L_0x0039:
            r1 = r1 | r3
        L_0x003a:
            r3 = r14 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x004e
            r3 = r15 & 4
            if (r3 != 0) goto L_0x004b
            boolean r3 = r13.changed((java.lang.Object) r11)
            if (r3 == 0) goto L_0x004b
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x004d
        L_0x004b:
            r3 = 128(0x80, float:1.794E-43)
        L_0x004d:
            r1 = r1 | r3
        L_0x004e:
            r3 = r15 & 8
            if (r3 == 0) goto L_0x0055
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0065
        L_0x0055:
            r3 = r14 & 3072(0xc00, float:4.305E-42)
            if (r3 != 0) goto L_0x0065
            boolean r3 = r13.changed((boolean) r12)
            if (r3 == 0) goto L_0x0062
            r3 = 2048(0x800, float:2.87E-42)
            goto L_0x0064
        L_0x0062:
            r3 = 1024(0x400, float:1.435E-42)
        L_0x0064:
            r1 = r1 | r3
        L_0x0065:
            r3 = r1 & 1171(0x493, float:1.641E-42)
            r4 = 1170(0x492, float:1.64E-42)
            if (r3 != r4) goto L_0x0079
            boolean r3 = r13.getSkipping()
            if (r3 != 0) goto L_0x0072
            goto L_0x0079
        L_0x0072:
            r13.skipToGroupEnd()
        L_0x0075:
            r3 = r10
            r4 = r11
            goto L_0x01b8
        L_0x0079:
            r13.startDefaults()
            r3 = r14 & 1
            r4 = 6
            if (r3 == 0) goto L_0x0090
            boolean r3 = r13.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0088
            goto L_0x0090
        L_0x0088:
            r13.skipToGroupEnd()
            r2 = r15 & 4
            if (r2 == 0) goto L_0x00a2
            goto L_0x00a0
        L_0x0090:
            if (r2 == 0) goto L_0x0096
            androidx.compose.ui.Modifier$Companion r10 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r10 = (androidx.compose.ui.Modifier) r10
        L_0x0096:
            r2 = r15 & 4
            if (r2 == 0) goto L_0x00a2
            androidx.compose.material3.TimePickerDefaults r11 = androidx.compose.material3.TimePickerDefaults.INSTANCE
            androidx.compose.material3.TimePickerColors r11 = r11.colors(r13, r4)
        L_0x00a0:
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00a2:
            r13.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x00b1
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.VerticalTimePicker (TimePicker.kt:929)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r2, r3)
        L_0x00b1:
            androidx.compose.material3.TimePickerKt$VerticalTimePicker$1 r0 = androidx.compose.material3.TimePickerKt$VerticalTimePicker$1.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r2 = 0
            r3 = 0
            r5 = 1
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r10, r3, r0, r5, r2)
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r2 = r2.getCenterHorizontally()
            r5 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            java.lang.String r6 = "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r5, r6)
            androidx.compose.foundation.layout.Arrangement r5 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r5 = r5.getTop()
            r6 = 48
            androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r5, r2, r13, r6)
            r5 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r6 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r5, r6)
            int r3 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r13, r3)
            androidx.compose.runtime.CompositionLocalMap r5 = r13.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r13, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r6 = r6.getConstructor()
            r7 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            java.lang.String r8 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r7, r8)
            androidx.compose.runtime.Applier r7 = r13.getApplier()
            boolean r7 = r7 instanceof androidx.compose.runtime.Applier
            if (r7 != 0) goto L_0x0103
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0103:
            r13.startReusableNode()
            boolean r7 = r13.getInserting()
            if (r7 == 0) goto L_0x0110
            r13.createNode(r6)
            goto L_0x0113
        L_0x0110:
            r13.useNode()
        L_0x0113:
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m3675constructorimpl(r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r6, r2, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r6, r5, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetCompositeKeyHash()
            boolean r5 = r6.getInserting()
            if (r5 != 0) goto L_0x0143
            java.lang.Object r5 = r6.rememberedValue()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r7)
            if (r5 != 0) goto L_0x0151
        L_0x0143:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
            r6.updateRememberedValue(r5)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r6.apply(r3, r2)
        L_0x0151:
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r6, r0, r2)
            r0 = -384862393(0xffffffffe90f7747, float:-1.0839979E25)
            java.lang.String r2 = "C87@4365L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r0, r2)
            androidx.compose.foundation.layout.ColumnScopeInstance r0 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r0 = (androidx.compose.foundation.layout.ColumnScope) r0
            r0 = 1628603633(0x611284f1, float:1.6892525E20)
            java.lang.String r2 = "C934@40388L35,935@40432L60,936@40501L44,937@40554L57:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r0, r2)
            r0 = r9
            androidx.compose.material3.TimePickerState r0 = (androidx.compose.material3.TimePickerState) r0
            r2 = r1 & 14
            int r1 = r1 >> 3
            r3 = r1 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            VerticalClockDisplay(r0, r11, r13, r2)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            float r3 = ClockDisplayBottomMargin
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m831height3ABfNKs(r0, r3)
            androidx.compose.foundation.layout.SpacerKt.Spacer(r0, r13, r4)
            r0 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            ClockFace(r9, r11, r12, r13, r0)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            float r1 = ClockFaceBottomMargin
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m831height3ABfNKs(r0, r1)
            androidx.compose.foundation.layout.SpacerKt.Spacer(r0, r13, r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r13.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0075
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x0075
        L_0x01b8:
            androidx.compose.runtime.ScopeUpdateScope r10 = r13.endRestartGroup()
            if (r10 == 0) goto L_0x01cc
            androidx.compose.material3.TimePickerKt$VerticalTimePicker$3 r1 = new androidx.compose.material3.TimePickerKt$VerticalTimePicker$3
            r2 = r9
            r5 = r12
            r6 = r14
            r7 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r10.updateScope(r1)
        L_0x01cc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.VerticalTimePicker(androidx.compose.material3.AnalogTimePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerColors, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void HorizontalTimePicker(androidx.compose.material3.AnalogTimePickerState r18, androidx.compose.ui.Modifier r19, androidx.compose.material3.TimePickerColors r20, boolean r21, androidx.compose.runtime.Composer r22, int r23, int r24) {
        /*
            r1 = r18
            r4 = r21
            r5 = r23
            r0 = 1432307537(0x555f4751, float:1.53435872E13)
            r2 = r22
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(HorizontalTimePicker)P(3,2,1)945@40787L8,948@40837L309:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r24 & 1
            if (r3 == 0) goto L_0x001b
            r3 = r5 | 6
            goto L_0x002b
        L_0x001b:
            r3 = r5 & 6
            if (r3 != 0) goto L_0x002a
            boolean r3 = r2.changedInstance(r1)
            if (r3 == 0) goto L_0x0027
            r3 = 4
            goto L_0x0028
        L_0x0027:
            r3 = 2
        L_0x0028:
            r3 = r3 | r5
            goto L_0x002b
        L_0x002a:
            r3 = r5
        L_0x002b:
            r6 = r24 & 2
            if (r6 == 0) goto L_0x0032
            r3 = r3 | 48
            goto L_0x0045
        L_0x0032:
            r7 = r5 & 48
            if (r7 != 0) goto L_0x0045
            r7 = r19
            boolean r8 = r2.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0041
            r8 = 32
            goto L_0x0043
        L_0x0041:
            r8 = 16
        L_0x0043:
            r3 = r3 | r8
            goto L_0x0047
        L_0x0045:
            r7 = r19
        L_0x0047:
            r8 = r5 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x0060
            r8 = r24 & 4
            if (r8 != 0) goto L_0x005a
            r8 = r20
            boolean r9 = r2.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x005c
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005a:
            r8 = r20
        L_0x005c:
            r9 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r3 = r3 | r9
            goto L_0x0062
        L_0x0060:
            r8 = r20
        L_0x0062:
            r9 = r24 & 8
            if (r9 == 0) goto L_0x0069
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0079
        L_0x0069:
            r9 = r5 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x0079
            boolean r9 = r2.changed((boolean) r4)
            if (r9 == 0) goto L_0x0076
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0078
        L_0x0076:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0078:
            r3 = r3 | r9
        L_0x0079:
            r9 = r3 & 1171(0x493, float:1.641E-42)
            r10 = 1170(0x492, float:1.64E-42)
            if (r9 != r10) goto L_0x008d
            boolean r9 = r2.getSkipping()
            if (r9 != 0) goto L_0x0086
            goto L_0x008d
        L_0x0086:
            r2.skipToGroupEnd()
            r11 = r7
        L_0x008a:
            r3 = r8
            goto L_0x01cb
        L_0x008d:
            r2.startDefaults()
            r9 = r5 & 1
            r10 = 6
            if (r9 == 0) goto L_0x00a7
            boolean r9 = r2.getDefaultsInvalid()
            if (r9 == 0) goto L_0x009c
            goto L_0x00a7
        L_0x009c:
            r2.skipToGroupEnd()
            r6 = r24 & 4
            if (r6 == 0) goto L_0x00a5
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00a5:
            r11 = r7
            goto L_0x00bf
        L_0x00a7:
            if (r6 == 0) goto L_0x00ae
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            goto L_0x00af
        L_0x00ae:
            r6 = r7
        L_0x00af:
            r7 = r24 & 4
            if (r7 == 0) goto L_0x00be
            androidx.compose.material3.TimePickerDefaults r7 = androidx.compose.material3.TimePickerDefaults.INSTANCE
            androidx.compose.material3.TimePickerColors r7 = r7.colors(r2, r10)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            r11 = r6
            r8 = r7
            goto L_0x00bf
        L_0x00be:
            r11 = r6
        L_0x00bf:
            r2.endDefaults()
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x00ce
            r6 = -1
            java.lang.String r7 = "androidx.compose.material3.HorizontalTimePicker (TimePicker.kt:947)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r6, r7)
        L_0x00ce:
            float r15 = ClockFaceBottomMargin
            r16 = 7
            r17 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.PaddingKt.m779paddingqDBjuR0$default(r11, r12, r13, r14, r15, r16, r17)
            androidx.compose.ui.Alignment$Companion r6 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r6 = r6.getCenterVertically()
            r7 = 693286680(0x2952b718, float:4.6788176E-14)
            java.lang.String r9 = "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r7, r9)
            androidx.compose.foundation.layout.Arrangement r7 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r7 = r7.getStart()
            r9 = 48
            androidx.compose.ui.layout.MeasurePolicy r6 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r7, r6, r2, r9)
            r7 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r9 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r7, r9)
            r7 = 0
            int r7 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r7)
            androidx.compose.runtime.CompositionLocalMap r9 = r2.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r2, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r12 = r12.getConstructor()
            r13 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            java.lang.String r14 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r13, r14)
            androidx.compose.runtime.Applier r13 = r2.getApplier()
            boolean r13 = r13 instanceof androidx.compose.runtime.Applier
            if (r13 != 0) goto L_0x0123
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0123:
            r2.startReusableNode()
            boolean r13 = r2.getInserting()
            if (r13 == 0) goto L_0x0130
            r2.createNode(r12)
            goto L_0x0133
        L_0x0130:
            r2.useNode()
        L_0x0133:
            androidx.compose.runtime.Composer r12 = androidx.compose.runtime.Updater.m3675constructorimpl(r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r12, r6, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r12, r9, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetCompositeKeyHash()
            boolean r9 = r12.getInserting()
            if (r9 != 0) goto L_0x0163
            java.lang.Object r9 = r12.rememberedValue()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r7)
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r13)
            if (r9 != 0) goto L_0x0171
        L_0x0163:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r7)
            r12.updateRememberedValue(r9)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r12.apply(r7, r6)
        L_0x0171:
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r12, r0, r6)
            r0 = -407918630(0xffffffffe7afa7da, float:-1.6590209E24)
            java.lang.String r6 = "C100@5047L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r6)
            androidx.compose.foundation.layout.RowScopeInstance r0 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            androidx.compose.foundation.layout.RowScope r0 = (androidx.compose.foundation.layout.RowScope) r0
            r0 = 157723300(0x966aaa4, float:2.7765478E-33)
            java.lang.String r6 = "C952@40982L37,953@41028L59,954@41096L44:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r6)
            r0 = r1
            androidx.compose.material3.TimePickerState r0 = (androidx.compose.material3.TimePickerState) r0
            r6 = r3 & 14
            int r3 = r3 >> 3
            r7 = r3 & 112(0x70, float:1.57E-43)
            r6 = r6 | r7
            HorizontalClockDisplay(r0, r8, r2, r6)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            float r7 = ClockDisplayBottomMargin
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m850width3ABfNKs(r0, r7)
            androidx.compose.foundation.layout.SpacerKt.Spacer(r0, r2, r10)
            r0 = r3 & 896(0x380, float:1.256E-42)
            r0 = r0 | r6
            ClockFace(r1, r8, r4, r2, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r2.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x008a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x008a
        L_0x01cb:
            androidx.compose.runtime.ScopeUpdateScope r7 = r2.endRestartGroup()
            if (r7 == 0) goto L_0x01de
            androidx.compose.material3.TimePickerKt$HorizontalTimePicker$2 r0 = new androidx.compose.material3.TimePickerKt$HorizontalTimePicker$2
            r6 = r24
            r2 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r7.updateScope(r0)
        L_0x01de:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.HorizontalTimePicker(androidx.compose.material3.AnalogTimePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerColors, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v4, resolved type: kotlin.jvm.functions.Function0} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TimeInputImpl(androidx.compose.ui.Modifier r50, androidx.compose.material3.TimePickerColors r51, androidx.compose.material3.TimePickerState r52, androidx.compose.runtime.Composer r53, int r54) {
        /*
            r0 = r50
            r7 = r51
            r8 = r52
            r9 = r54
            r1 = -475657989(0xffffffffe3a608fb, float:-6.125613E21)
            r2 = r53
            androidx.compose.runtime.Composer r14 = r2.startRestartGroup(r1)
            java.lang.String r2 = "C(TimeInputImpl)P(1)965@41356L112,965@41304L164,969@41552L104,969@41500L156,972@41661L4502:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r2)
            r2 = r9 & 6
            r3 = 2
            if (r2 != 0) goto L_0x0026
            boolean r2 = r14.changed((java.lang.Object) r0)
            if (r2 == 0) goto L_0x0023
            r2 = 4
            goto L_0x0024
        L_0x0023:
            r2 = r3
        L_0x0024:
            r2 = r2 | r9
            goto L_0x0027
        L_0x0026:
            r2 = r9
        L_0x0027:
            r4 = r9 & 48
            if (r4 != 0) goto L_0x0037
            boolean r4 = r14.changed((java.lang.Object) r7)
            if (r4 == 0) goto L_0x0034
            r4 = 32
            goto L_0x0036
        L_0x0034:
            r4 = 16
        L_0x0036:
            r2 = r2 | r4
        L_0x0037:
            r4 = r9 & 384(0x180, float:5.38E-43)
            r5 = 256(0x100, float:3.59E-43)
            if (r4 != 0) goto L_0x0051
            r4 = r9 & 512(0x200, float:7.175E-43)
            if (r4 != 0) goto L_0x0046
            boolean r4 = r14.changed((java.lang.Object) r8)
            goto L_0x004a
        L_0x0046:
            boolean r4 = r14.changedInstance(r8)
        L_0x004a:
            if (r4 == 0) goto L_0x004e
            r4 = r5
            goto L_0x0050
        L_0x004e:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0050:
            r2 = r2 | r4
        L_0x0051:
            r4 = r2 & 147(0x93, float:2.06E-43)
            r6 = 146(0x92, float:2.05E-43)
            if (r4 != r6) goto L_0x0063
            boolean r4 = r14.getSkipping()
            if (r4 != 0) goto L_0x005e
            goto L_0x0063
        L_0x005e:
            r14.skipToGroupEnd()
            goto L_0x0364
        L_0x0063:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x006f
            r4 = -1
            java.lang.String r6 = "androidx.compose.material3.TimeInputImpl (TimePicker.kt:963)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r2, r4, r6)
        L_0x006f:
            r1 = 0
            java.lang.Object[] r10 = new java.lang.Object[r1]
            androidx.compose.ui.text.input.TextFieldValue$Companion r4 = androidx.compose.ui.text.input.TextFieldValue.Companion
            androidx.compose.runtime.saveable.Saver r11 = r4.getSaver()
            r4 = 339122986(0x14369b2a, float:9.2192525E-27)
            java.lang.String r6 = "CC(remember):TimePicker.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r4, r6)
            r4 = r2 & 896(0x380, float:1.256E-42)
            r12 = 1
            if (r4 == r5) goto L_0x0092
            r13 = r2 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x0090
            boolean r13 = r14.changedInstance(r8)
            if (r13 == 0) goto L_0x0090
            goto L_0x0092
        L_0x0090:
            r13 = r1
            goto L_0x0093
        L_0x0092:
            r13 = r12
        L_0x0093:
            java.lang.Object r15 = r14.rememberedValue()
            if (r13 != 0) goto L_0x00a1
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r15 != r13) goto L_0x00ac
        L_0x00a1:
            androidx.compose.material3.TimePickerKt$TimeInputImpl$hourValue$2$1 r13 = new androidx.compose.material3.TimePickerKt$TimeInputImpl$hourValue$2$1
            r13.<init>(r8)
            r15 = r13
            kotlin.jvm.functions.Function0 r15 = (kotlin.jvm.functions.Function0) r15
            r14.updateRememberedValue(r15)
        L_0x00ac:
            r13 = r15
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r15 = 0
            r16 = 4
            r17 = r12
            r12 = 0
            androidx.compose.runtime.MutableState r10 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r10, r11, (java.lang.String) r12, r13, (androidx.compose.runtime.Composer) r14, (int) r15, (int) r16)
            r11 = r10
            java.lang.Object[] r10 = new java.lang.Object[r1]
            androidx.compose.ui.text.input.TextFieldValue$Companion r12 = androidx.compose.ui.text.input.TextFieldValue.Companion
            androidx.compose.runtime.saveable.Saver r12 = r12.getSaver()
            r13 = 339129250(0x1436b3a2, float:9.224078E-27)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r13, r6)
            if (r4 == r5) goto L_0x00da
            r4 = r2 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x00d8
            boolean r4 = r14.changedInstance(r8)
            if (r4 == 0) goto L_0x00d8
            goto L_0x00da
        L_0x00d8:
            r4 = r1
            goto L_0x00db
        L_0x00da:
            r4 = 1
        L_0x00db:
            java.lang.Object r5 = r14.rememberedValue()
            if (r4 != 0) goto L_0x00e9
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r5 != r4) goto L_0x00f4
        L_0x00e9:
            androidx.compose.material3.TimePickerKt$TimeInputImpl$minuteValue$2$1 r4 = new androidx.compose.material3.TimePickerKt$TimeInputImpl$minuteValue$2$1
            r4.<init>(r8)
            r5 = r4
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r14.updateRememberedValue(r5)
        L_0x00f4:
            r13 = r5
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r15 = 0
            r16 = 4
            r4 = r11
            r11 = r12
            r12 = 0
            androidx.compose.runtime.MutableState r10 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r10, r11, (java.lang.String) r12, r13, (androidx.compose.runtime.Composer) r14, (int) r15, (int) r16)
            r11 = r4
            float r4 = TimeInputBottomPadding
            r5 = 7
            r6 = 0
            r12 = r1
            r1 = 0
            r13 = r2
            r2 = 0
            r15 = r3
            r3 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.m779paddingqDBjuR0$default(r0, r1, r2, r3, r4, r5, r6)
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r2 = r2.getTop()
            r3 = 693286680(0x2952b718, float:4.6788176E-14)
            java.lang.String r4 = "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r3, r4)
            androidx.compose.foundation.layout.Arrangement r3 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r3 = r3.getStart()
            r4 = 48
            androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r3, r2, r14, r4)
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r5 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r3, r5)
            int r6 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r14, r12)
            r53 = r4
            androidx.compose.runtime.CompositionLocalMap r4 = r14.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r14, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r3 = r16.getConstructor()
            r16 = r12
            r12 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            java.lang.String r15 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r12, r15)
            androidx.compose.runtime.Applier r12 = r14.getApplier()
            boolean r12 = r12 instanceof androidx.compose.runtime.Applier
            if (r12 != 0) goto L_0x015e
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x015e:
            r14.startReusableNode()
            boolean r12 = r14.getInserting()
            if (r12 == 0) goto L_0x016b
            r14.createNode(r3)
            goto L_0x016e
        L_0x016b:
            r14.useNode()
        L_0x016e:
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.Updater.m3675constructorimpl(r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r3, r2, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r3, r4, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetCompositeKeyHash()
            boolean r4 = r3.getInserting()
            if (r4 != 0) goto L_0x019e
            java.lang.Object r4 = r3.rememberedValue()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r6)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r12)
            if (r4 != 0) goto L_0x01ac
        L_0x019e:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)
            r3.updateRememberedValue(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)
            r3.apply(r4, r2)
        L_0x01ac:
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r3, r1, r2)
            r1 = -407918630(0xffffffffe7afa7da, float:-1.6590209E24)
            java.lang.String r2 = "C100@5047L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r1, r2)
            androidx.compose.foundation.layout.RowScopeInstance r1 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            androidx.compose.foundation.layout.RowScope r1 = (androidx.compose.foundation.layout.RowScope) r1
            r1 = -1328966913(0xffffffffb0c992ff, float:-1.4666454E-9)
            java.lang.String r2 = "C977@41861L5,986@42225L3553,982@42004L3774:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r1, r2)
            androidx.compose.material3.tokens.TimeInputTokens r1 = androidx.compose.material3.tokens.TimeInputTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r1 = r1.getTimeFieldLabelTextFont()
            r2 = 6
            androidx.compose.ui.text.TextStyle r18 = androidx.compose.material3.TypographyKt.getValue(r1, r14, r2)
            androidx.compose.ui.text.style.TextAlign$Companion r1 = androidx.compose.ui.text.style.TextAlign.Companion
            int r38 = r1.m6986getCentere0LSkKk()
            r1 = 1
            long r19 = r7.m2716timeSelectorContentColorvNxB06k$material3_release(r1)
            r48 = 16744446(0xff7ffe, float:2.3463966E-38)
            r49 = 0
            r21 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r39 = 0
            r40 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            androidx.compose.ui.text.TextStyle r3 = androidx.compose.ui.text.TextStyle.m6577copyp1EtxEg$default(r18, r19, r21, r23, r24, r25, r26, r27, r28, r30, r31, r32, r33, r35, r36, r37, r38, r39, r40, r42, r43, r44, r45, r46, r47, r48, r49)
            r4 = 2
            androidx.compose.runtime.ProvidedValue[] r4 = new androidx.compose.runtime.ProvidedValue[r4]
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.material3.TextKt.getLocalTextStyle()
            androidx.compose.runtime.ProvidedValue r3 = r6.provides(r3)
            r4[r16] = r3
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.ui.unit.LayoutDirection r6 = androidx.compose.ui.unit.LayoutDirection.Ltr
            androidx.compose.runtime.ProvidedValue r3 = r3.provides(r6)
            r4[r1] = r3
            androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1 r3 = new androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1
            r3.<init>(r11, r8, r7, r10)
            r6 = 54
            r10 = 1306700887(0x4de2ac57, float:4.7536816E8)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r10, r1, r3, r14, r6)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            int r3 = androidx.compose.runtime.ProvidedValue.$stable
            r3 = r3 | 48
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r4, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r1, (androidx.compose.runtime.Composer) r14, (int) r3)
            r1 = 511443242(0x1e7c012a, float:1.334101E-20)
            r14.startReplaceGroup(r1)
            java.lang.String r1 = "1073@45823L324"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            boolean r1 = r8.is24hour()
            if (r1 != 0) goto L_0x0346
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            r18 = r1
            androidx.compose.ui.Modifier r18 = (androidx.compose.ui.Modifier) r18
            float r19 = PeriodToggleMargin
            r23 = 14
            r24 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.m779paddingqDBjuR0$default(r18, r19, r20, r21, r22, r23, r24)
            r3 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            java.lang.String r4 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r3, r4)
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r3 = r3.getTopStart()
            r12 = r16
            androidx.compose.ui.layout.MeasurePolicy r3 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r3, r12)
            r4 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r4, r5)
            int r4 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r14, r12)
            androidx.compose.runtime.CompositionLocalMap r5 = r14.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r14, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r6 = r6.getConstructor()
            r10 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r10, r15)
            androidx.compose.runtime.Applier r10 = r14.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x02a8
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02a8:
            r14.startReusableNode()
            boolean r10 = r14.getInserting()
            if (r10 == 0) goto L_0x02b5
            r14.createNode(r6)
            goto L_0x02b8
        L_0x02b5:
            r14.useNode()
        L_0x02b8:
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m3675constructorimpl(r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r6, r3, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r6, r5, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetCompositeKeyHash()
            boolean r5 = r6.getInserting()
            if (r5 != 0) goto L_0x02e8
            java.lang.Object r5 = r6.rememberedValue()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r4)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r10)
            if (r5 != 0) goto L_0x02f6
        L_0x02e8:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            r6.updateRememberedValue(r5)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r6.apply(r4, r3)
        L_0x02f6:
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r6, r1, r3)
            r1 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            java.lang.String r3 = "C73@3429L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r1, r3)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            r1 = -415465671(0xffffffffe73c7f39, float:-8.9015174E23)
            java.lang.String r3 = "C1074@45891L242:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r1, r3)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.material3.tokens.TimeInputTokens r3 = androidx.compose.material3.tokens.TimeInputTokens.INSTANCE
            float r3 = r3.m3556getPeriodSelectorContainerWidthD9Ej5fM()
            androidx.compose.material3.tokens.TimeInputTokens r4 = androidx.compose.material3.tokens.TimeInputTokens.INSTANCE
            float r4 = r4.m3555getPeriodSelectorContainerHeightD9Ej5fM()
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m847sizeVpY3zN4(r1, r3, r4)
            int r3 = r13 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            int r3 = r13 << 3
            r3 = r3 & 896(0x380, float:1.256E-42)
            r2 = r2 | r3
            VerticalPeriodToggle(r1, r8, r7, r14, r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r14.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
        L_0x0346:
            r14.endReplaceGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r14.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0364
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0364:
            androidx.compose.runtime.ScopeUpdateScope r1 = r14.endRestartGroup()
            if (r1 == 0) goto L_0x0374
            androidx.compose.material3.TimePickerKt$TimeInputImpl$2 r2 = new androidx.compose.material3.TimePickerKt$TimeInputImpl$2
            r2.<init>(r0, r7, r8, r9)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r1.updateScope(r2)
        L_0x0374:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.TimeInputImpl(androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerColors, androidx.compose.material3.TimePickerState, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final TextFieldValue TimeInputImpl$lambda$6(MutableState<TextFieldValue> mutableState) {
        return (TextFieldValue) mutableState.getValue();
    }

    /* access modifiers changed from: private */
    public static final TextFieldValue TimeInputImpl$lambda$9(MutableState<TextFieldValue> mutableState) {
        return (TextFieldValue) mutableState.getValue();
    }

    /* access modifiers changed from: private */
    public static final void HorizontalClockDisplay(TimePickerState timePickerState, TimePickerColors timePickerColors, Composer composer, int i) {
        int i2;
        TimePickerState timePickerState2 = timePickerState;
        TimePickerColors timePickerColors2 = timePickerColors;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(755539561);
        ComposerKt.sourceInformation(startRestartGroup, "C(HorizontalClockDisplay)P(1)1087@46270L590:TimePicker.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = ((i3 & 8) == 0 ? startRestartGroup.changed((Object) timePickerState2) : startRestartGroup.changedInstance(timePickerState2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changed((Object) timePickerColors2) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(755539561, i2, -1, "androidx.compose.material3.HorizontalClockDisplay (TimePicker.kt:1086)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getCenter(), Alignment.Companion.getStart(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
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
            Updater.m3682setimpl(r8, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r8, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r8.getInserting() || !Intrinsics.areEqual(r8.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r8.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r8, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1556019140, "C1088@46329L34:TimePicker.kt#uh7d8r");
            ClockDisplayNumbers(timePickerState2, timePickerColors2, startRestartGroup, i2 & WebSocketProtocol.PAYLOAD_SHORT);
            startRestartGroup.startReplaceGroup(919638492);
            ComposerKt.sourceInformation(startRestartGroup, "1090@46407L437");
            if (!timePickerState2.is24hour()) {
                Modifier r3 = PaddingKt.m779paddingqDBjuR0$default(Modifier.Companion, 0.0f, PeriodToggleMargin, 0.0f, 0.0f, 13, (Object) null);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, r3);
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
                Composer r9 = Updater.m3675constructorimpl(startRestartGroup);
                Updater.m3682setimpl(r9, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3682setimpl(r9, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r9.getInserting() || !Intrinsics.areEqual(r9.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                    r9.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    r9.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m3682setimpl(r9, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -743649264, "C1091@46484L346:TimePicker.kt#uh7d8r");
                int i4 = i2 << 3;
                HorizontalPeriodToggle(SizeKt.m847sizeVpY3zN4(Modifier.Companion, TimePickerTokens.INSTANCE.m3567getPeriodSelectorHorizontalContainerWidthD9Ej5fM(), TimePickerTokens.INSTANCE.m3566getPeriodSelectorHorizontalContainerHeightD9Ej5fM()), timePickerState2, timePickerColors2, startRestartGroup, (i4 & 896) | (i4 & 112) | 6);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            }
            startRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TimePickerKt$HorizontalClockDisplay$2(timePickerState2, timePickerColors2, i3));
        }
    }

    /* access modifiers changed from: private */
    public static final void VerticalClockDisplay(TimePickerState timePickerState, TimePickerColors timePickerColors, Composer composer, int i) {
        int i2;
        TimePickerState timePickerState2 = timePickerState;
        TimePickerColors timePickerColors2 = timePickerColors;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(2054675515);
        ComposerKt.sourceInformation(startRestartGroup, "C(VerticalClockDisplay)P(1)1107@46965L585:TimePicker.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = ((i3 & 8) == 0 ? startRestartGroup.changed((Object) timePickerState2) : startRestartGroup.changedInstance(timePickerState2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changed((Object) timePickerColors2) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2054675515, i2, -1, "androidx.compose.material3.VerticalClockDisplay (TimePicker.kt:1106)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), Alignment.Companion.getTop(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
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
            Updater.m3682setimpl(r8, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r8, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r8.getInserting() || !Intrinsics.areEqual(r8.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r8.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r8, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -519240274, "C1108@47023L34:TimePicker.kt#uh7d8r");
            ClockDisplayNumbers(timePickerState2, timePickerColors2, startRestartGroup, i2 & WebSocketProtocol.PAYLOAD_SHORT);
            startRestartGroup.startReplaceGroup(-709485014);
            ComposerKt.sourceInformation(startRestartGroup, "1110@47101L433");
            if (!timePickerState2.is24hour()) {
                Modifier r3 = PaddingKt.m779paddingqDBjuR0$default(Modifier.Companion, PeriodToggleMargin, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, r3);
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
                Composer r9 = Updater.m3675constructorimpl(startRestartGroup);
                Updater.m3682setimpl(r9, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3682setimpl(r9, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r9.getInserting() || !Intrinsics.areEqual(r9.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                    r9.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    r9.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m3682setimpl(r9, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 204292100, "C1111@47180L340:TimePicker.kt#uh7d8r");
                int i4 = i2 << 3;
                VerticalPeriodToggle(SizeKt.m847sizeVpY3zN4(Modifier.Companion, TimePickerTokens.INSTANCE.m3570getPeriodSelectorVerticalContainerWidthD9Ej5fM(), TimePickerTokens.INSTANCE.m3569getPeriodSelectorVerticalContainerHeightD9Ej5fM()), timePickerState2, timePickerColors2, startRestartGroup, (i4 & 896) | (i4 & 112) | 6);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            }
            startRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TimePickerKt$VerticalClockDisplay$2(timePickerState2, timePickerColors2, i3));
        }
    }

    /* access modifiers changed from: private */
    public static final void ClockDisplayNumbers(TimePickerState timePickerState, TimePickerColors timePickerColors, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-934561141);
        ComposerKt.sourceInformation(startRestartGroup, "C(ClockDisplayNumbers)P(1)1128@47738L5,1131@47873L775,1127@47654L994:TimePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed((Object) timePickerState) : startRestartGroup.changedInstance(timePickerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed((Object) timePickerColors) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-934561141, i2, -1, "androidx.compose.material3.ClockDisplayNumbers (TimePicker.kt:1126)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{TextKt.getLocalTextStyle().provides(TypographyKt.getValue(TimePickerTokens.INSTANCE.getTimeSelectorLabelTextFont(), startRestartGroup, 6)), CompositionLocalsKt.getLocalLayoutDirection().provides(LayoutDirection.Ltr)}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-477913269, true, new TimePickerKt$ClockDisplayNumbers$1(timePickerState, timePickerColors), startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TimePickerKt$ClockDisplayNumbers$2(timePickerState, timePickerColors, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void HorizontalPeriodToggle(Modifier modifier, TimePickerState timePickerState, TimePickerColors timePickerColors, Composer composer, int i) {
        int i2;
        TimePickerColors timePickerColors2;
        TimePickerState timePickerState2;
        Modifier modifier2;
        Composer startRestartGroup = composer.startRestartGroup(1261215927);
        ComposerKt.sourceInformation(startRestartGroup, "C(HorizontalPeriodToggle)P(1,2)1160@48810L1014,1188@49871L5,1190@49902L206:TimePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? startRestartGroup.changed((Object) timePickerState) : startRestartGroup.changedInstance(timePickerState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed((Object) timePickerColors) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1261215927, i2, -1, "androidx.compose.material3.HorizontalPeriodToggle (TimePicker.kt:1159)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2071625362, "CC(remember):TimePicker.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1.INSTANCE;
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Shape value = ShapesKt.getValue(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), startRestartGroup, 6);
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            CornerBasedShape cornerBasedShape = (CornerBasedShape) value;
            modifier2 = modifier;
            timePickerState2 = timePickerState;
            timePickerColors2 = timePickerColors;
            PeriodToggleImpl(modifier2, timePickerState2, timePickerColors2, (MeasurePolicy) rememberedValue, ShapesKt.start(cornerBasedShape), ShapesKt.end(cornerBasedShape), startRestartGroup, (i2 & 14) | 3072 | (i2 & 112) | (i2 & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            timePickerState2 = timePickerState;
            timePickerColors2 = timePickerColors;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TimePickerKt$HorizontalPeriodToggle$1(modifier2, timePickerState2, timePickerColors2, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void VerticalPeriodToggle(Modifier modifier, TimePickerState timePickerState, TimePickerColors timePickerColors, Composer composer, int i) {
        int i2;
        TimePickerColors timePickerColors2;
        TimePickerState timePickerState2;
        Modifier modifier2;
        Composer startRestartGroup = composer.startRestartGroup(-1898918107);
        ComposerKt.sourceInformation(startRestartGroup, "C(VerticalPeriodToggle)P(1,2)1206@50268L1021,1234@51336L5,1236@51367L207:TimePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? startRestartGroup.changed((Object) timePickerState) : startRestartGroup.changedInstance(timePickerState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed((Object) timePickerColors) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1898918107, i2, -1, "androidx.compose.material3.VerticalPeriodToggle (TimePicker.kt:1205)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1491514731, "CC(remember):TimePicker.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1.INSTANCE;
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Shape value = ShapesKt.getValue(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), startRestartGroup, 6);
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            CornerBasedShape cornerBasedShape = (CornerBasedShape) value;
            modifier2 = modifier;
            timePickerState2 = timePickerState;
            timePickerColors2 = timePickerColors;
            PeriodToggleImpl(modifier2, timePickerState2, timePickerColors2, (MeasurePolicy) rememberedValue, ShapesKt.top(cornerBasedShape), ShapesKt.bottom(cornerBasedShape), startRestartGroup, (i2 & 14) | 3072 | (i2 & 112) | (i2 & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            timePickerState2 = timePickerState;
            timePickerColors2 = timePickerColors;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TimePickerKt$VerticalPeriodToggle$1(modifier2, timePickerState2, timePickerColors2, i));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v13, resolved type: kotlin.jvm.functions.Function0} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void PeriodToggleImpl(androidx.compose.ui.Modifier r26, androidx.compose.material3.TimePickerState r27, androidx.compose.material3.TimePickerColors r28, androidx.compose.ui.layout.MeasurePolicy r29, androidx.compose.ui.graphics.Shape r30, androidx.compose.ui.graphics.Shape r31, androidx.compose.runtime.Composer r32, int r33) {
        /*
            r1 = r26
            r2 = r27
            r4 = r29
            r7 = r33
            r0 = 1374241901(0x51e9446d, float:1.25234422E11)
            r3 = r32
            androidx.compose.runtime.Composer r13 = r3.startRestartGroup(r0)
            java.lang.String r3 = "C(PeriodToggleImpl)P(3,5!1,2,4)1258@51953L5,1259@52008L41,1263@52129L128,1260@52054L1189:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r3)
            r3 = r7 & 6
            if (r3 != 0) goto L_0x0025
            boolean r3 = r13.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0022
            r3 = 4
            goto L_0x0023
        L_0x0022:
            r3 = 2
        L_0x0023:
            r3 = r3 | r7
            goto L_0x0026
        L_0x0025:
            r3 = r7
        L_0x0026:
            r5 = r7 & 48
            if (r5 != 0) goto L_0x003f
            r5 = r7 & 64
            if (r5 != 0) goto L_0x0033
            boolean r5 = r13.changed((java.lang.Object) r2)
            goto L_0x0037
        L_0x0033:
            boolean r5 = r13.changedInstance(r2)
        L_0x0037:
            if (r5 == 0) goto L_0x003c
            r5 = 32
            goto L_0x003e
        L_0x003c:
            r5 = 16
        L_0x003e:
            r3 = r3 | r5
        L_0x003f:
            r5 = r7 & 384(0x180, float:5.38E-43)
            r11 = r28
            if (r5 != 0) goto L_0x0051
            boolean r5 = r13.changed((java.lang.Object) r11)
            if (r5 == 0) goto L_0x004e
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0050
        L_0x004e:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0050:
            r3 = r3 | r5
        L_0x0051:
            r5 = r7 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x0061
            boolean r5 = r13.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x005e
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x0060
        L_0x005e:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x0060:
            r3 = r3 | r5
        L_0x0061:
            r5 = r7 & 24576(0x6000, float:3.4438E-41)
            r9 = r30
            if (r5 != 0) goto L_0x0073
            boolean r5 = r13.changed((java.lang.Object) r9)
            if (r5 == 0) goto L_0x0070
            r5 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0072
        L_0x0070:
            r5 = 8192(0x2000, float:1.14794E-41)
        L_0x0072:
            r3 = r3 | r5
        L_0x0073:
            r5 = 196608(0x30000, float:2.75506E-40)
            r5 = r5 & r7
            if (r5 != 0) goto L_0x0087
            r5 = r31
            boolean r8 = r13.changed((java.lang.Object) r5)
            if (r8 == 0) goto L_0x0083
            r8 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0085
        L_0x0083:
            r8 = 65536(0x10000, float:9.18355E-41)
        L_0x0085:
            r3 = r3 | r8
            goto L_0x0089
        L_0x0087:
            r5 = r31
        L_0x0089:
            r8 = 74899(0x12493, float:1.04956E-40)
            r8 = r8 & r3
            r10 = 74898(0x12492, float:1.04954E-40)
            if (r8 != r10) goto L_0x009e
            boolean r8 = r13.getSkipping()
            if (r8 != 0) goto L_0x0099
            goto L_0x009e
        L_0x0099:
            r13.skipToGroupEnd()
            goto L_0x0284
        L_0x009e:
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x00aa
            r8 = -1
            java.lang.String r10 = "androidx.compose.material3.PeriodToggleImpl (TimePicker.kt:1254)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r8, r10)
        L_0x00aa:
            androidx.compose.material3.tokens.TimePickerTokens r0 = androidx.compose.material3.tokens.TimePickerTokens.INSTANCE
            float r0 = r0.m3568getPeriodSelectorOutlineWidthD9Ej5fM()
            long r14 = r11.m2703getPeriodSelectorBorderColor0d7_KjU()
            androidx.compose.foundation.BorderStroke r0 = androidx.compose.foundation.BorderStrokeKt.m275BorderStrokecXLIe8U(r0, r14)
            androidx.compose.material3.tokens.TimePickerTokens r8 = androidx.compose.material3.tokens.TimePickerTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r8 = r8.getPeriodSelectorContainerShape()
            r10 = 6
            androidx.compose.ui.graphics.Shape r8 = androidx.compose.material3.ShapesKt.getValue(r8, r13, r10)
            java.lang.String r10 = "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8, r10)
            androidx.compose.foundation.shape.CornerBasedShape r8 = (androidx.compose.foundation.shape.CornerBasedShape) r8
            androidx.compose.material3.internal.Strings$Companion r10 = androidx.compose.material3.internal.Strings.Companion
            int r10 = androidx.compose.material3.R.string.m3c_time_picker_period_toggle_description
            int r10 = androidx.compose.material3.internal.Strings.m2922constructorimpl(r10)
            r15 = 0
            java.lang.String r10 = androidx.compose.material3.internal.Strings_androidKt.m2992getString2EP1pXo(r10, r13, r15)
            r12 = -2132305224(0xffffffff80e79ab8, float:-2.1269502E-38)
            java.lang.String r14 = "CC(remember):TimePicker.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r12, r14)
            boolean r12 = r13.changed((java.lang.Object) r10)
            java.lang.Object r6 = r13.rememberedValue()
            if (r12 != 0) goto L_0x00f1
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r6 != r12) goto L_0x00fb
        L_0x00f1:
            androidx.compose.material3.TimePickerKt$PeriodToggleImpl$1$1 r6 = new androidx.compose.material3.TimePickerKt$PeriodToggleImpl$1$1
            r6.<init>(r10)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r13.updateRememberedValue(r6)
        L_0x00fb:
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r10 = 1
            r12 = 0
            androidx.compose.ui.Modifier r6 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r1, r15, r6, r10, r12)
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.selection.SelectableGroupKt.selectableGroup(r6)
            androidx.compose.ui.graphics.Shape r8 = (androidx.compose.ui.graphics.Shape) r8
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.BorderKt.border(r6, r0, r8)
            r6 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r8 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r6, r8)
            int r6 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r13, r15)
            androidx.compose.runtime.CompositionLocalMap r8 = r13.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r13, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            r17 = r10
            kotlin.jvm.functions.Function0 r10 = r16.getConstructor()
            r12 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            java.lang.String r15 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r12, r15)
            androidx.compose.runtime.Applier r12 = r13.getApplier()
            boolean r12 = r12 instanceof androidx.compose.runtime.Applier
            if (r12 != 0) goto L_0x013f
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x013f:
            r13.startReusableNode()
            boolean r12 = r13.getInserting()
            if (r12 == 0) goto L_0x014c
            r13.createNode(r10)
            goto L_0x014f
        L_0x014c:
            r13.useNode()
        L_0x014f:
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m3675constructorimpl(r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r10, r4, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r10, r8, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetCompositeKeyHash()
            boolean r12 = r10.getInserting()
            if (r12 != 0) goto L_0x017f
            java.lang.Object r12 = r10.rememberedValue()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r6)
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r15)
            if (r12 != 0) goto L_0x018d
        L_0x017f:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r6)
            r10.updateRememberedValue(r12)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r10.apply(r6, r8)
        L_0x018d:
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r10, r0, r6)
            r0 = 822309452(0x3103724c, float:1.912798E-9)
            java.lang.String r6 = "C1274@52547L29,1271@52427L283,1279@52723L219,1288@53072L28,1285@52955L272:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r0, r6)
            boolean r0 = r2.isAfternoon()
            r8 = r0 ^ 1
            r0 = -250565484(0xfffffffff110ac94, float:-7.163916E29)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r0, r14)
            r0 = r3 & 112(0x70, float:1.57E-43)
            r6 = 32
            if (r0 == r6) goto L_0x01bd
            r6 = r3 & 64
            if (r6 == 0) goto L_0x01bb
            boolean r6 = r13.changedInstance(r2)
            if (r6 == 0) goto L_0x01bb
            goto L_0x01bd
        L_0x01bb:
            r6 = 0
            goto L_0x01bf
        L_0x01bd:
            r6 = r17
        L_0x01bf:
            java.lang.Object r10 = r13.rememberedValue()
            if (r6 != 0) goto L_0x01cd
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r10 != r6) goto L_0x01d8
        L_0x01cd:
            androidx.compose.material3.TimePickerKt$PeriodToggleImpl$2$1$1 r6 = new androidx.compose.material3.TimePickerKt$PeriodToggleImpl$2$1$1
            r6.<init>(r2)
            r10 = r6
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            r13.updateRememberedValue(r10)
        L_0x01d8:
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.material3.ComposableSingletons$TimePickerKt r6 = androidx.compose.material3.ComposableSingletons$TimePickerKt.INSTANCE
            kotlin.jvm.functions.Function3 r12 = r6.m1947getLambda1$material3_release()
            int r6 = r3 >> 9
            r6 = r6 & 112(0x70, float:1.57E-43)
            r6 = r6 | 24576(0x6000, float:3.4438E-41)
            int r15 = r3 << 3
            r15 = r15 & 7168(0x1c00, float:1.0045E-41)
            r6 = r6 | r15
            r19 = r14
            r1 = r17
            r14 = r6
            r6 = 0
            ToggleItem(r8, r9, r10, r11, r12, r13, r14)
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            java.lang.String r9 = "Spacer"
            androidx.compose.ui.Modifier r8 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r8, r9)
            r9 = 1073741824(0x40000000, float:2.0)
            androidx.compose.ui.Modifier r8 = androidx.compose.ui.ZIndexModifierKt.zIndex(r8, r9)
            r9 = 0
            androidx.compose.ui.Modifier r20 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r8, r9, r1, r6)
            long r21 = r28.m2703getPeriodSelectorBorderColor0d7_KjU()
            r24 = 2
            r25 = 0
            r23 = 0
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.BackgroundKt.m248backgroundbw27NRU$default(r20, r21, r23, r24, r25)
            r8 = 0
            androidx.compose.foundation.layout.SpacerKt.Spacer(r6, r13, r8)
            r18 = r8
            boolean r8 = r2.isAfternoon()
            r6 = -250548685(0xfffffffff110ee33, float:-7.176609E29)
            r9 = r19
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r6, r9)
            r6 = 32
            if (r0 == r6) goto L_0x023d
            r0 = r3 & 64
            if (r0 == 0) goto L_0x023b
            boolean r0 = r13.changedInstance(r2)
            if (r0 == 0) goto L_0x023b
            goto L_0x023d
        L_0x023b:
            r1 = r18
        L_0x023d:
            java.lang.Object r0 = r13.rememberedValue()
            if (r1 != 0) goto L_0x024b
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r0 != r1) goto L_0x0255
        L_0x024b:
            androidx.compose.material3.TimePickerKt$PeriodToggleImpl$2$2$1 r0 = new androidx.compose.material3.TimePickerKt$PeriodToggleImpl$2$2$1
            r0.<init>(r2)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r13.updateRememberedValue(r0)
        L_0x0255:
            r10 = r0
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.material3.ComposableSingletons$TimePickerKt r0 = androidx.compose.material3.ComposableSingletons$TimePickerKt.INSTANCE
            kotlin.jvm.functions.Function3 r12 = r0.m1948getLambda2$material3_release()
            int r0 = r3 >> 12
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r14 = r0 | r15
            r11 = r28
            r9 = r5
            ToggleItem(r8, r9, r10, r11, r12, r13, r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r13.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0284
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0284:
            androidx.compose.runtime.ScopeUpdateScope r8 = r13.endRestartGroup()
            if (r8 == 0) goto L_0x029c
            androidx.compose.material3.TimePickerKt$PeriodToggleImpl$3 r0 = new androidx.compose.material3.TimePickerKt$PeriodToggleImpl$3
            r1 = r26
            r3 = r28
            r5 = r30
            r6 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r8.updateScope(r0)
        L_0x029c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.PeriodToggleImpl(androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerState, androidx.compose.material3.TimePickerColors, androidx.compose.ui.layout.MeasurePolicy, androidx.compose.ui.graphics.Shape, androidx.compose.ui.graphics.Shape, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final void ToggleItem(boolean z, Shape shape, Function0<Unit> function0, TimePickerColors timePickerColors, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i) {
        int i2;
        Composer composer2;
        boolean z2 = z;
        TimePickerColors timePickerColors2 = timePickerColors;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1937408098);
        ComposerKt.sourceInformation(startRestartGroup, "C(ToggleItem)P(!1,4,3)1310@53677L22,1316@53868L124,1308@53569L429:TimePicker.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed(z2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changed((Object) shape) ? 32 : 16;
        } else {
            Shape shape2 = shape;
        }
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        } else {
            Function0<Unit> function02 = function0;
        }
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changed((Object) timePickerColors2) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function3) ? 16384 : 8192;
        } else {
            Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
        }
        if ((i2 & 9363) != 9362 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1937408098, i2, -1, "androidx.compose.material3.ToggleItem (TimePicker.kt:1304)");
            }
            long r10 = timePickerColors2.m2714periodSelectorContentColorvNxB06k$material3_release(z2);
            long r8 = timePickerColors2.m2713periodSelectorContainerColorvNxB06k$material3_release(z2);
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(ZIndexModifierKt.zIndex(Modifier.Companion, z2 ? 0.0f : 1.0f), 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -857429536, "CC(remember):TimePicker.kt#9igjgp");
            boolean z3 = (i2 & 14) == 4;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new TimePickerKt$ToggleItem$1$1(z2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Composer composer3 = startRestartGroup;
            Composer composer4 = composer3;
            ButtonKt.TextButton(function0, SemanticsModifierKt.semantics$default(fillMaxSize$default, false, (Function1) rememberedValue, 1, (Object) null), false, shape, ButtonDefaults.INSTANCE.m1772textButtonColorsro_MJ88(r8, r10, 0, 0, composer3, 24576, 12), (ButtonElevation) null, (BorderStroke) null, PaddingKt.m768PaddingValues0680j_4(Dp.m7111constructorimpl((float) 0)), (MutableInteractionSource) null, function3, composer4, ((i2 >> 6) & 14) | 12582912 | ((i2 << 6) & 7168) | ((i2 << 15) & 1879048192), 356);
            composer2 = composer4;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TimePickerKt$ToggleItem$2(z2, shape, function0, timePickerColors2, function3, i3));
        }
    }

    /* access modifiers changed from: private */
    public static final void DisplaySeparator(Modifier modifier, Composer composer, int i) {
        int i2;
        Composer composer2;
        Modifier modifier2 = modifier;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(2100674302);
        ComposerKt.sourceInformation(startRestartGroup, "C(DisplaySeparator)1326@54104L7,1335@54375L172:TimePicker.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2100674302, i2, -1, "androidx.compose.material3.DisplaySeparator (TimePicker.kt:1324)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(TextKt.getLocalTextStyle());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            TextStyle r23 = TextStyle.m6577copyp1EtxEg$default((TextStyle) consume, 0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, TextAlign.Companion.m6986getCentere0LSkKk(), 0, 0, (TextIndent) null, (PlatformTextStyle) null, new LineHeightStyle(LineHeightStyle.Alignment.Companion.m6963getCenterPIaL0Z0(), LineHeightStyle.Trim.Companion.m6975getBothEVpEnUU(), (DefaultConstructorMarker) null), 0, 0, (TextMotion) null, 15695871, (Object) null);
            Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(modifier2, TimePickerKt$DisplaySeparator$1.INSTANCE);
            Alignment center = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, clearAndSetSemantics);
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
            Composer r7 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r7, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r7, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r7.getInserting() || !Intrinsics.areEqual(r7.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r7.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r7, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -789568360, "C1336@54520L5,1336@54471L70:TimePicker.kt#uh7d8r");
            composer2 = startRestartGroup;
            TextKt.m2692Text4IGK_g(":", (Modifier) null, ColorSchemeKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldSeparatorColor(), startRestartGroup, 6), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, r23, composer2, 6, 0, 65530);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TimePickerKt$DisplaySeparator$3(modifier2, i3));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: kotlin.jvm.functions.Function0} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: TimeSelector-SAnMeKU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2722TimeSelectorSAnMeKU(androidx.compose.ui.Modifier r27, int r28, androidx.compose.material3.TimePickerState r29, int r30, androidx.compose.material3.TimePickerColors r31, androidx.compose.runtime.Composer r32, int r33) {
        /*
            r1 = r27
            r3 = r29
            r4 = r30
            r0 = r31
            r8 = r33
            r2 = -1148055889(0xffffffffbb920eaf, float:-0.004457317)
            r5 = r32
            androidx.compose.runtime.Composer r9 = r5.startRestartGroup(r2)
            java.lang.String r5 = "C(TimeSelector)P(1,4,3,2:c#material3.TimePickerSelectionMode)1351@54864L214,1363@55302L124,1373@55637L5,1367@55446L117,1375@55682L497,1361@55218L961:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r5)
            r5 = r8 & 6
            if (r5 != 0) goto L_0x0027
            boolean r5 = r9.changed((java.lang.Object) r1)
            if (r5 == 0) goto L_0x0024
            r5 = 4
            goto L_0x0025
        L_0x0024:
            r5 = 2
        L_0x0025:
            r5 = r5 | r8
            goto L_0x0028
        L_0x0027:
            r5 = r8
        L_0x0028:
            r6 = r8 & 48
            if (r6 != 0) goto L_0x003b
            r6 = r28
            boolean r7 = r9.changed((int) r6)
            if (r7 == 0) goto L_0x0037
            r7 = 32
            goto L_0x0039
        L_0x0037:
            r7 = 16
        L_0x0039:
            r5 = r5 | r7
            goto L_0x003d
        L_0x003b:
            r6 = r28
        L_0x003d:
            r7 = r8 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0056
            r7 = r8 & 512(0x200, float:7.175E-43)
            if (r7 != 0) goto L_0x004a
            boolean r7 = r9.changed((java.lang.Object) r3)
            goto L_0x004e
        L_0x004a:
            boolean r7 = r9.changedInstance(r3)
        L_0x004e:
            if (r7 == 0) goto L_0x0053
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0055
        L_0x0053:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0055:
            r5 = r5 | r7
        L_0x0056:
            r7 = r8 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x0066
            boolean r7 = r9.changed((int) r4)
            if (r7 == 0) goto L_0x0063
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0065
        L_0x0063:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0065:
            r5 = r5 | r7
        L_0x0066:
            r7 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x0076
            boolean r7 = r9.changed((java.lang.Object) r0)
            if (r7 == 0) goto L_0x0073
            r7 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0075
        L_0x0073:
            r7 = 8192(0x2000, float:1.14794E-41)
        L_0x0075:
            r5 = r5 | r7
        L_0x0076:
            r7 = r5 & 9363(0x2493, float:1.312E-41)
            r12 = 9362(0x2492, float:1.3119E-41)
            if (r7 != r12) goto L_0x008a
            boolean r7 = r9.getSkipping()
            if (r7 != 0) goto L_0x0083
            goto L_0x008a
        L_0x0083:
            r9.skipToGroupEnd()
            r23 = r9
            goto L_0x017d
        L_0x008a:
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x0096
            r7 = -1
            java.lang.String r12 = "androidx.compose.material3.TimeSelector (TimePicker.kt:1348)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r5, r7, r12)
        L_0x0096:
            int r2 = r3.m2756getSelectionyecRtBI()
            boolean r12 = androidx.compose.material3.TimePickerSelectionMode.m2750equalsimpl0(r2, r4)
            androidx.compose.material3.TimePickerSelectionMode$Companion r2 = androidx.compose.material3.TimePickerSelectionMode.Companion
            int r2 = r2.m2754getHouryecRtBI()
            boolean r2 = androidx.compose.material3.TimePickerSelectionMode.m2750equalsimpl0(r4, r2)
            if (r2 == 0) goto L_0x00b3
            androidx.compose.material3.internal.Strings$Companion r2 = androidx.compose.material3.internal.Strings.Companion
            int r2 = androidx.compose.material3.R.string.m3c_time_picker_hour_selection
            int r2 = androidx.compose.material3.internal.Strings.m2922constructorimpl(r2)
            goto L_0x00bb
        L_0x00b3:
            androidx.compose.material3.internal.Strings$Companion r2 = androidx.compose.material3.internal.Strings.Companion
            int r2 = androidx.compose.material3.R.string.m3c_time_picker_minute_selection
            int r2 = androidx.compose.material3.internal.Strings.m2922constructorimpl(r2)
        L_0x00bb:
            r7 = 0
            java.lang.String r2 = androidx.compose.material3.internal.Strings_androidKt.m2992getString2EP1pXo(r2, r9, r7)
            long r14 = r0.m2715timeSelectorContainerColorvNxB06k$material3_release(r12)
            r13 = r7
            long r6 = r0.m2716timeSelectorContentColorvNxB06k$material3_release(r12)
            r13 = 1840519339(0x6db418ab, float:6.9671404E27)
            java.lang.String r10 = "CC(remember):TimePicker.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r13, r10)
            boolean r13 = r9.changed((java.lang.Object) r2)
            java.lang.Object r11 = r9.rememberedValue()
            if (r13 != 0) goto L_0x00e3
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r11 != r13) goto L_0x00ed
        L_0x00e3:
            androidx.compose.material3.TimePickerKt$TimeSelector$1$1 r11 = new androidx.compose.material3.TimePickerKt$TimeSelector$1$1
            r11.<init>(r2)
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            r9.updateRememberedValue(r11)
        L_0x00ed:
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r13 = 1
            androidx.compose.ui.Modifier r11 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r1, r13, r11)
            androidx.compose.material3.tokens.TimePickerTokens r2 = androidx.compose.material3.tokens.TimePickerTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r2 = r2.getTimeSelectorContainerShape()
            r13 = 6
            androidx.compose.ui.graphics.Shape r13 = androidx.compose.material3.ShapesKt.getValue(r2, r9, r13)
            r2 = 1840523940(0x6db42aa4, float:6.9698564E27)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r2, r10)
            r2 = r5 & 7168(0x1c00, float:1.0045E-41)
            r10 = 2048(0x800, float:2.87E-42)
            if (r2 != r10) goto L_0x0110
            r2 = 1
            goto L_0x0111
        L_0x0110:
            r2 = 0
        L_0x0111:
            r10 = r5 & 896(0x380, float:1.256E-42)
            r0 = 256(0x100, float:3.59E-43)
            if (r10 == r0) goto L_0x0124
            r0 = r5 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0122
            boolean r0 = r9.changedInstance(r3)
            if (r0 == 0) goto L_0x0122
            goto L_0x0124
        L_0x0122:
            r0 = 0
            goto L_0x0125
        L_0x0124:
            r0 = 1
        L_0x0125:
            r0 = r0 | r2
            java.lang.Object r2 = r9.rememberedValue()
            if (r0 != 0) goto L_0x0134
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r2 != r0) goto L_0x013f
        L_0x0134:
            androidx.compose.material3.TimePickerKt$TimeSelector$2$1 r0 = new androidx.compose.material3.TimePickerKt$TimeSelector$2$1
            r0.<init>(r4, r3)
            r2 = r0
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r9.updateRememberedValue(r2)
        L_0x013f:
            r10 = r2
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            androidx.compose.material3.TimePickerKt$TimeSelector$3 r2 = new androidx.compose.material3.TimePickerKt$TimeSelector$3
            r5 = r4
            r4 = r3
            r3 = r5
            r5 = r28
            r2.<init>(r3, r4, r5, r6)
            r0 = 54
            r3 = -1477282471(0xffffffffa7f27559, float:-6.729572E-15)
            r4 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r3, r4, r2, r9, r0)
            r22 = r0
            kotlin.jvm.functions.Function2 r22 = (kotlin.jvm.functions.Function2) r22
            r25 = 48
            r26 = 1992(0x7c8, float:2.791E-42)
            r23 = r9
            r9 = r12
            r12 = 0
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r24 = 0
            androidx.compose.material3.SurfaceKt.m2537Surfaced85dljk((boolean) r9, (kotlin.jvm.functions.Function0<kotlin.Unit>) r10, (androidx.compose.ui.Modifier) r11, (boolean) r12, (androidx.compose.ui.graphics.Shape) r13, (long) r14, (long) r16, (float) r18, (float) r19, (androidx.compose.foundation.BorderStroke) r20, (androidx.compose.foundation.interaction.MutableInteractionSource) r21, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r22, (androidx.compose.runtime.Composer) r23, (int) r24, (int) r25, (int) r26)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x017d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x017d:
            androidx.compose.runtime.ScopeUpdateScope r7 = r23.endRestartGroup()
            if (r7 == 0) goto L_0x0196
            androidx.compose.material3.TimePickerKt$TimeSelector$4 r0 = new androidx.compose.material3.TimePickerKt$TimeSelector$4
            r2 = r28
            r3 = r29
            r4 = r30
            r5 = r31
            r6 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r7.updateScope(r0)
        L_0x0196:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.m2722TimeSelectorSAnMeKU(androidx.compose.ui.Modifier, int, androidx.compose.material3.TimePickerState, int, androidx.compose.material3.TimePickerColors, androidx.compose.runtime.Composer, int):void");
    }

    public static final void ClockFace(AnalogTimePickerState analogTimePickerState, TimePickerColors timePickerColors, boolean z, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1170157036);
        ComposerKt.sourceInformation(startRestartGroup, "C(ClockFace)P(2,1)1521@60272L2018,1513@59878L2412:TimePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(analogTimePickerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed((Object) timePickerColors) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1170157036, i2, -1, "androidx.compose.material3.ClockFace (TimePicker.kt:1512)");
            }
            CrossfadeKt.Crossfade(analogTimePickerState.getClockFaceValues(), drawSelector(SizeKt.m845size3ABfNKs(BackgroundKt.m247backgroundbw27NRU(Modifier.Companion, timePickerColors.m2699getClockDialColor0d7_KjU(), RoundedCornerShapeKt.getCircleShape()).then(new ClockDialModifier(analogTimePickerState, z, analogTimePickerState.m1708getSelectionyecRtBI(), (DefaultConstructorMarker) null)), TimePickerTokens.INSTANCE.m3561getClockDialContainerSizeD9Ej5fM()), analogTimePickerState, timePickerColors), (FiniteAnimationSpec<Float>) AnimationSpecKt.tween$default(200, 0, (Easing) null, 6, (Object) null), (String) null, ComposableLambdaKt.rememberComposableLambda(-1022006568, true, new TimePickerKt$ClockFace$1(timePickerColors, analogTimePickerState, z), startRestartGroup, 54), startRestartGroup, 24960, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TimePickerKt$ClockFace$2(analogTimePickerState, timePickerColors, z, i));
        }
    }

    private static final Modifier drawSelector(Modifier modifier, AnalogTimePickerState analogTimePickerState, TimePickerColors timePickerColors) {
        return DrawModifierKt.drawWithContent(modifier, new TimePickerKt$drawSelector$1(analogTimePickerState, timePickerColors));
    }

    /* access modifiers changed from: private */
    public static final void ClockText(Modifier modifier, AnalogTimePickerState analogTimePickerState, int i, boolean z, Composer composer, int i2) {
        int i3;
        Composer composer2;
        boolean z2;
        boolean z3;
        boolean z4;
        Modifier modifier2;
        Alignment alignment;
        AnalogTimePickerState analogTimePickerState2 = analogTimePickerState;
        int i4 = i;
        int i5 = i2;
        Composer startRestartGroup = composer.startRestartGroup(-206784607);
        ComposerKt.sourceInformation(startRestartGroup, "C(ClockText)P(1,2,3)1639@64421L5,*1640@64463L7,1641@64513L40,1642@64578L43,1643@64638L24,1645@64700L142,1665@65318L163,1670@65563L503,1659@65093L1182:TimePicker.kt#uh7d8r");
        Modifier modifier3 = modifier;
        if ((i5 & 6) == 0) {
            i3 = (startRestartGroup.changed((Object) modifier3) ? 4 : 2) | i5;
        } else {
            i3 = i5;
        }
        if ((i5 & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(analogTimePickerState2) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i3 |= startRestartGroup.changed(i4) ? 256 : 128;
        }
        boolean z5 = z;
        if ((i5 & 3072) == 0) {
            i3 |= startRestartGroup.changed(z5) ? 2048 : 1024;
        }
        if ((i3 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-206784607, i3, -1, "androidx.compose.material3.ClockText (TimePicker.kt:1638)");
            }
            TextStyle value = TypographyKt.getValue(TimePickerTokens.INSTANCE.getClockDialLabelTextFont(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            float r0 = ((Density) consume).m7091toPx0680j_4(MaxDistance);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 297230880, "CC(remember):TimePicker.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m3976boximpl(Offset.Companion.m4003getZeroF1C5BW0()), (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 297232963, "CC(remember):TimePicker.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntOffset.m7232boximpl(IntOffset.Companion.m7251getZeronOccac()), (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MutableState mutableState2 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -954363344, "CC(remember):Effects.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue3 = compositionScopedCoroutineScopeCanceller;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue3).getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            String r12 = m2730numberContentDescriptiondSwYdS4(analogTimePickerState2.m1708getSelectionyecRtBI(), analogTimePickerState2.is24hour(), i4, startRestartGroup, i3 & 896);
            CoroutineScope coroutineScope2 = coroutineScope;
            MutableState mutableState3 = mutableState2;
            MutableState mutableState4 = mutableState;
            String localString$default = CalendarLocale_jvmKt.toLocalString$default(i4, 0, 0, false, 7, (Object) null);
            if (TimePickerSelectionMode.m2750equalsimpl0(analogTimePickerState2.m1708getSelectionyecRtBI(), TimePickerSelectionMode.Companion.m2755getMinuteyecRtBI())) {
                z2 = Intrinsics.areEqual((Object) CalendarLocale_jvmKt.toLocalString$default(analogTimePickerState2.getMinute(), 0, 0, false, 7, (Object) null), (Object) localString$default);
            } else {
                z2 = Intrinsics.areEqual((Object) CalendarLocale_jvmKt.toLocalString$default(analogTimePickerState2.getHour(), 0, 0, false, 7, (Object) null), (Object) localString$default);
            }
            Alignment center = Alignment.Companion.getCenter();
            Modifier r5 = SizeKt.m845size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier), MinimumInteractiveSize);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 297256763, "CC(remember):TimePicker.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new TimePickerKt$ClockText$1$1(mutableState3, mutableState4);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Alignment alignment2 = center;
            Modifier focusable$default = FocusableKt.focusable$default(OnGloballyPositionedModifierKt.onGloballyPositioned(r5, (Function1) rememberedValue4), false, (MutableInteractionSource) null, 3, (Object) null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 297264943, "CC(remember):TimePicker.kt#9igjgp");
            boolean changedInstance = ((i3 & 7168) == 2048) | startRestartGroup.changedInstance(coroutineScope2) | startRestartGroup.changedInstance(analogTimePickerState2) | startRestartGroup.changed(r0) | startRestartGroup.changed(z2);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue5 == Composer.Companion.getEmpty()) {
                CoroutineScope coroutineScope3 = coroutineScope2;
                modifier2 = focusable$default;
                boolean z6 = z2;
                AnalogTimePickerState analogTimePickerState3 = analogTimePickerState2;
                CoroutineScope coroutineScope4 = coroutineScope3;
                boolean z7 = z5;
                MutableState mutableState5 = mutableState4;
                z4 = true;
                z3 = false;
                MutableState mutableState6 = mutableState3;
                alignment = alignment2;
                rememberedValue5 = new TimePickerKt$ClockText$2$1(z6, coroutineScope4, analogTimePickerState3, r0, z7, mutableState5, mutableState6);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            } else {
                modifier2 = focusable$default;
                z3 = false;
                alignment = alignment2;
                z4 = true;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier semantics = SemanticsModifierKt.semantics(modifier2, z4, (Function1) rememberedValue5);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(alignment, z3);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, z3 ? 1 : 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, semantics);
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
            Composer r4 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r4, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r4, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r4.getInserting() || !Intrinsics.areEqual(r4.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r4.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r4, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1481062706, "C1688@66158L48,1686@66083L186:TimePicker.kt#uh7d8r");
            Modifier modifier4 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 879062471, "CC(remember):TimePicker.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) r12);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = new TimePickerKt$ClockText$3$1$1(r12);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            composer2 = startRestartGroup;
            TextKt.m2692Text4IGK_g(localString$default, SemanticsModifierKt.clearAndSetSemantics(modifier4, (Function1) rememberedValue6), 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, value, composer2, 0, 0, 65532);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TimePickerKt$ClockText$4(modifier, analogTimePickerState, i, z, i2));
        }
    }

    /* access modifiers changed from: private */
    public static final long ClockText$lambda$29(MutableState<Offset> mutableState) {
        return ((Offset) mutableState.getValue()).m3997unboximpl();
    }

    /* access modifiers changed from: private */
    public static final void ClockText$lambda$30(MutableState<Offset> mutableState, long j) {
        mutableState.setValue(Offset.m3976boximpl(j));
    }

    /* access modifiers changed from: private */
    public static final long ClockText$lambda$32(MutableState<IntOffset> mutableState) {
        return ((IntOffset) mutableState.getValue()).m7250unboximpl();
    }

    /* access modifiers changed from: private */
    public static final void ClockText$lambda$33(MutableState<IntOffset> mutableState, long j) {
        mutableState.setValue(IntOffset.m7232boximpl(j));
    }

    /* access modifiers changed from: private */
    /* renamed from: timeInputOnChange-z7XvuPQ  reason: not valid java name */
    public static final void m2732timeInputOnChangez7XvuPQ(int i, TimePickerState timePickerState, TextFieldValue textFieldValue, TextFieldValue textFieldValue2, int i2, Function1<? super TextFieldValue, Unit> function1) {
        int i3;
        TextFieldValue textFieldValue3;
        if (Intrinsics.areEqual((Object) textFieldValue.getText(), (Object) textFieldValue2.getText())) {
            function1.invoke(textFieldValue);
        } else if (textFieldValue.getText().length() == 0) {
            if (TimePickerSelectionMode.m2750equalsimpl0(i, TimePickerSelectionMode.Companion.m2754getHouryecRtBI())) {
                timePickerState.setHour(0);
            } else {
                timePickerState.setMinute(0);
            }
            function1.invoke(TextFieldValue.m6819copy3r_uNRQ$default(textFieldValue, "", 0, (TextRange) null, 6, (Object) null));
        } else {
            TextFieldValue textFieldValue4 = textFieldValue;
            try {
                if (textFieldValue4.getText().length() == 3 && TextRange.m6564getStartimpl(textFieldValue4.m6823getSelectiond9O1mEE()) == 1) {
                    i3 = CharsKt.digitToInt(textFieldValue4.getText().charAt(0));
                } else {
                    i3 = Integer.parseInt(textFieldValue4.getText());
                }
                if (i3 <= i2) {
                    if (TimePickerSelectionMode.m2750equalsimpl0(i, TimePickerSelectionMode.Companion.m2754getHouryecRtBI())) {
                        timePickerState.setHour(i3);
                        if (i3 > 1 && !timePickerState.is24hour()) {
                            timePickerState.m2757setSelection6_8s6DQ(TimePickerSelectionMode.Companion.m2755getMinuteyecRtBI());
                        }
                    } else {
                        timePickerState.setMinute(i3);
                    }
                    if (textFieldValue4.getText().length() <= 2) {
                        textFieldValue3 = textFieldValue4;
                    } else {
                        textFieldValue3 = TextFieldValue.m6819copy3r_uNRQ$default(textFieldValue4, String.valueOf(textFieldValue4.getText().charAt(0)), 0, (TextRange) null, 6, (Object) null);
                    }
                    function1.invoke(textFieldValue3);
                }
            } catch (IllegalArgumentException | NumberFormatException unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x06a8, code lost:
        if (r8.changedInstance(r6) != false) goto L_0x06b1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x06ba  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x06bd  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x06eb  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x06f6  */
    /* JADX WARNING: Removed duplicated region for block: B:178:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x010e  */
    /* renamed from: TimePickerTextField-1vLObsk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2721TimePickerTextField1vLObsk(androidx.compose.ui.Modifier r114, androidx.compose.ui.text.input.TextFieldValue r115, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r116, androidx.compose.material3.TimePickerState r117, int r118, androidx.compose.foundation.text.KeyboardOptions r119, androidx.compose.foundation.text.KeyboardActions r120, androidx.compose.material3.TimePickerColors r121, androidx.compose.runtime.Composer r122, int r123, int r124) {
        /*
            r1 = r114
            r2 = r115
            r5 = r117
            r6 = r118
            r7 = r121
            r0 = r123
            r10 = r124
            r3 = 1299172990(0x4d6fce7e, float:2.51455456E8)
            r4 = r122
            androidx.compose.runtime.Composer r8 = r4.startRestartGroup(r3)
            java.lang.String r4 = "C(TimePickerTextField)P(3,7,4,6,5:c#material3.TimePickerSelectionMode,2,1)1762@68219L39,1763@68284L29,1765@68374L243,1771@68670L3410,1857@72118L103,1857@72086L135:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r4)
            r4 = r10 & 1
            r105 = 4
            r106 = 2
            if (r4 == 0) goto L_0x0027
            r4 = r0 | 6
            goto L_0x0039
        L_0x0027:
            r4 = r0 & 6
            if (r4 != 0) goto L_0x0038
            boolean r4 = r8.changed((java.lang.Object) r1)
            if (r4 == 0) goto L_0x0034
            r4 = r105
            goto L_0x0036
        L_0x0034:
            r4 = r106
        L_0x0036:
            r4 = r4 | r0
            goto L_0x0039
        L_0x0038:
            r4 = r0
        L_0x0039:
            r9 = r10 & 2
            if (r9 == 0) goto L_0x0040
            r4 = r4 | 48
            goto L_0x0050
        L_0x0040:
            r9 = r0 & 48
            if (r9 != 0) goto L_0x0050
            boolean r9 = r8.changed((java.lang.Object) r2)
            if (r9 == 0) goto L_0x004d
            r9 = 32
            goto L_0x004f
        L_0x004d:
            r9 = 16
        L_0x004f:
            r4 = r4 | r9
        L_0x0050:
            r9 = r10 & 4
            if (r9 == 0) goto L_0x0057
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x006a
        L_0x0057:
            r9 = r0 & 384(0x180, float:5.38E-43)
            if (r9 != 0) goto L_0x006a
            r9 = r116
            boolean r11 = r8.changedInstance(r9)
            if (r11 == 0) goto L_0x0066
            r11 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0066:
            r11 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r4 = r4 | r11
            goto L_0x006c
        L_0x006a:
            r9 = r116
        L_0x006c:
            r11 = r10 & 8
            if (r11 == 0) goto L_0x0073
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x008c
        L_0x0073:
            r11 = r0 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x008c
            r11 = r0 & 4096(0x1000, float:5.74E-42)
            if (r11 != 0) goto L_0x0080
            boolean r11 = r8.changed((java.lang.Object) r5)
            goto L_0x0084
        L_0x0080:
            boolean r11 = r8.changedInstance(r5)
        L_0x0084:
            if (r11 == 0) goto L_0x0089
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x008b
        L_0x0089:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x008b:
            r4 = r4 | r11
        L_0x008c:
            r11 = r10 & 16
            if (r11 == 0) goto L_0x0093
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a3
        L_0x0093:
            r11 = r0 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x00a3
            boolean r11 = r8.changed((int) r6)
            if (r11 == 0) goto L_0x00a0
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a2
        L_0x00a0:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x00a2:
            r4 = r4 | r11
        L_0x00a3:
            r11 = r10 & 32
            r14 = 196608(0x30000, float:2.75506E-40)
            if (r11 == 0) goto L_0x00ab
            r4 = r4 | r14
            goto L_0x00bd
        L_0x00ab:
            r14 = r14 & r0
            if (r14 != 0) goto L_0x00bd
            r14 = r119
            boolean r15 = r8.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00b9
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bb
        L_0x00b9:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00bb:
            r4 = r4 | r15
            goto L_0x00bf
        L_0x00bd:
            r14 = r119
        L_0x00bf:
            r15 = r10 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00ca
            r4 = r4 | r16
            r12 = r120
            goto L_0x00dd
        L_0x00ca:
            r16 = r0 & r16
            r12 = r120
            if (r16 != 0) goto L_0x00dd
            boolean r16 = r8.changed((java.lang.Object) r12)
            if (r16 == 0) goto L_0x00d9
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00db
        L_0x00d9:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00db:
            r4 = r4 | r16
        L_0x00dd:
            r13 = r10 & 128(0x80, float:1.794E-43)
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            if (r13 == 0) goto L_0x00e6
            r4 = r4 | r17
            goto L_0x00f6
        L_0x00e6:
            r13 = r0 & r17
            if (r13 != 0) goto L_0x00f6
            boolean r13 = r8.changed((java.lang.Object) r7)
            if (r13 == 0) goto L_0x00f3
            r13 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f5
        L_0x00f3:
            r13 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f5:
            r4 = r4 | r13
        L_0x00f6:
            r13 = 4793491(0x492493, float:6.717112E-39)
            r13 = r13 & r4
            r3 = 4793490(0x492492, float:6.71711E-39)
            if (r13 != r3) goto L_0x010e
            boolean r3 = r8.getSkipping()
            if (r3 != 0) goto L_0x0106
            goto L_0x010e
        L_0x0106:
            r8.skipToGroupEnd()
            r0 = r6
            r7 = r12
            r6 = r5
            goto L_0x06f0
        L_0x010e:
            if (r11 == 0) goto L_0x0119
            androidx.compose.foundation.text.KeyboardOptions$Companion r3 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r3 = r3.getDefault()
            r107 = r3
            goto L_0x011b
        L_0x0119:
            r107 = r14
        L_0x011b:
            if (r15 == 0) goto L_0x0126
            androidx.compose.foundation.text.KeyboardActions$Companion r3 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r3 = r3.getDefault()
            r108 = r3
            goto L_0x0128
        L_0x0126:
            r108 = r12
        L_0x0128:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0137
            r3 = -1
            java.lang.String r11 = "androidx.compose.material3.TimePickerTextField (TimePicker.kt:1761)"
            r12 = 1299172990(0x4d6fce7e, float:2.51455456E8)
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r4, r3, r11)
        L_0x0137:
            r3 = 882970966(0x34a11156, float:3.00012E-7)
            java.lang.String r11 = "CC(remember):TimePicker.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r3, r11)
            java.lang.Object r3 = r8.rememberedValue()
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r3 != r12) goto L_0x0152
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r8.updateRememberedValue(r3)
        L_0x0152:
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = (androidx.compose.foundation.interaction.MutableInteractionSource) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r12 = 882973036(0x34a1196c, float:3.0007084E-7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r12, r11)
            java.lang.Object r12 = r8.rememberedValue()
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r12 != r13) goto L_0x0171
            androidx.compose.ui.focus.FocusRequester r12 = new androidx.compose.ui.focus.FocusRequester
            r12.<init>()
            r8.updateRememberedValue(r12)
        L_0x0171:
            androidx.compose.ui.focus.FocusRequester r12 = (androidx.compose.ui.focus.FocusRequester) r12
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r13 = r11
            androidx.compose.material3.OutlinedTextFieldDefaults r11 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            r14 = 1
            long r20 = r7.m2715timeSelectorContainerColorvNxB06k$material3_release(r14)
            long r22 = r7.m2715timeSelectorContainerColorvNxB06k$material3_release(r14)
            r15 = r12
            r17 = r13
            long r12 = r7.m2716timeSelectorContentColorvNxB06k$material3_release(r14)
            r103 = 2147483598(0x7fffffce, float:NaN)
            r104 = 4095(0xfff, float:5.738E-42)
            r19 = r14
            r18 = r15
            r14 = 0
            r25 = r17
            r24 = 16384(0x4000, float:2.2959E-41)
            r16 = 0
            r26 = r18
            r27 = r19
            r18 = 0
            r28 = r24
            r29 = r25
            r24 = 0
            r30 = r26
            r31 = r27
            r26 = 0
            r32 = r28
            r33 = r29
            r28 = 0
            r34 = r30
            r35 = r31
            r30 = 0
            r36 = r32
            r32 = 0
            r38 = r33
            r37 = r34
            r33 = 0
            r40 = r35
            r39 = r36
            r35 = 0
            r41 = r37
            r42 = r38
            r37 = 0
            r43 = r39
            r44 = r40
            r39 = 0
            r45 = r41
            r46 = r42
            r41 = 0
            r47 = r43
            r48 = r44
            r43 = 0
            r49 = r45
            r50 = r46
            r45 = 0
            r51 = r47
            r52 = r48
            r47 = 0
            r53 = r49
            r54 = r50
            r49 = 0
            r55 = r51
            r56 = r52
            r51 = 0
            r57 = r53
            r58 = r54
            r53 = 0
            r59 = r55
            r60 = r56
            r55 = 0
            r61 = r57
            r62 = r58
            r57 = 0
            r63 = r59
            r64 = r60
            r59 = 0
            r65 = r61
            r66 = r62
            r61 = 0
            r67 = r63
            r68 = r64
            r63 = 0
            r69 = r65
            r70 = r66
            r65 = 0
            r71 = r67
            r72 = r68
            r67 = 0
            r73 = r69
            r74 = r70
            r69 = 0
            r75 = r71
            r76 = r72
            r71 = 0
            r77 = r73
            r78 = r74
            r73 = 0
            r79 = r75
            r80 = r76
            r75 = 0
            r81 = r77
            r82 = r78
            r77 = 0
            r83 = r79
            r84 = r80
            r79 = 0
            r85 = r81
            r86 = r82
            r81 = 0
            r87 = r83
            r88 = r84
            r83 = 0
            r89 = r85
            r90 = r86
            r85 = 0
            r91 = r87
            r92 = r88
            r87 = 0
            r93 = r89
            r94 = r90
            r89 = 0
            r95 = r91
            r96 = r92
            r91 = 0
            r97 = r93
            r98 = r94
            r93 = 0
            r99 = r95
            r100 = r96
            r95 = 0
            r101 = r98
            r98 = 0
            r102 = r99
            r99 = 0
            r109 = r100
            r100 = 0
            r110 = r101
            r101 = 0
            r111 = r102
            r102 = 3072(0xc00, float:4.305E-42)
            r10 = r97
            r97 = r8
            r8 = r10
            r10 = r110
            androidx.compose.material3.TextFieldColors r11 = r11.m2323colors0hiis_0(r12, r14, r16, r18, r20, r22, r24, r26, r28, r30, r32, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r61, r63, r65, r67, r69, r71, r73, r75, r77, r79, r81, r83, r85, r87, r89, r91, r93, r95, r97, r98, r99, r100, r101, r102, r103, r104)
            r12 = r97
            int r13 = r5.m2756getSelectionyecRtBI()
            boolean r13 = androidx.compose.material3.TimePickerSelectionMode.m2750equalsimpl0(r6, r13)
            r14 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            java.lang.String r15 = "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r14, r15)
            androidx.compose.foundation.layout.Arrangement r14 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r14 = r14.getTop()
            androidx.compose.ui.Alignment$Companion r15 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r15 = r15.getStart()
            r0 = 0
            androidx.compose.ui.layout.MeasurePolicy r14 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r14, r15, r12, r0)
            r15 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r119 = r3
            java.lang.String r3 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r15, r3)
            int r3 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r12, r0)
            androidx.compose.runtime.CompositionLocalMap r15 = r12.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r12, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r1 = r16.getConstructor()
            r122 = r3
            r3 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            r16 = r4
            java.lang.String r4 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r3, r4)
            androidx.compose.runtime.Applier r3 = r12.getApplier()
            boolean r3 = r3 instanceof androidx.compose.runtime.Applier
            if (r3 != 0) goto L_0x02f1
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02f1:
            r12.startReusableNode()
            boolean r3 = r12.getInserting()
            if (r3 == 0) goto L_0x02fe
            r12.createNode(r1)
            goto L_0x0301
        L_0x02fe:
            r12.useNode()
        L_0x0301:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m3675constructorimpl(r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r1, r14, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r1, r15, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetCompositeKeyHash()
            boolean r4 = r1.getInserting()
            if (r4 != 0) goto L_0x0331
            java.lang.Object r4 = r1.rememberedValue()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r122)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r14)
            if (r4 != 0) goto L_0x033f
        L_0x0331:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r122)
            r1.updateRememberedValue(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r122)
            r1.apply(r4, r3)
        L_0x033f:
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r1, r0, r3)
            r0 = -384862393(0xffffffffe90f7747, float:-1.0839979E25)
            java.lang.String r1 = "C87@4365L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r0, r1)
            androidx.compose.foundation.layout.ColumnScopeInstance r0 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r0 = (androidx.compose.foundation.layout.ColumnScope) r0
            r0 = -2071429233(0xffffffff84887f8f, float:-3.209059E-36)
            java.lang.String r1 = "C1788@69244L240,1796@69494L2047,1845@71677L244,1852@71988L5,1853@72059L5,1842@71551L523:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r0, r1)
            r0 = 2011386807(0x77e353b7, float:9.221479E33)
            r12.startReplaceGroup(r0)
            java.lang.String r0 = "1773@68737L450"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            r0 = 6
            if (r13 != 0) goto L_0x03b1
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.material3.tokens.TimeInputTokens r3 = androidx.compose.material3.tokens.TimeInputTokens.INSTANCE
            float r3 = r3.m3559getTimeFieldContainerWidthD9Ej5fM()
            androidx.compose.material3.tokens.TimeInputTokens r4 = androidx.compose.material3.tokens.TimeInputTokens.INSTANCE
            float r4 = r4.m3558getTimeFieldContainerHeightD9Ej5fM()
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m847sizeVpY3zN4(r1, r3, r4)
            androidx.compose.material3.TimePickerSelectionMode$Companion r1 = androidx.compose.material3.TimePickerSelectionMode.Companion
            int r1 = r1.m2754getHouryecRtBI()
            boolean r1 = androidx.compose.material3.TimePickerSelectionMode.m2750equalsimpl0(r6, r1)
            if (r1 == 0) goto L_0x038f
            int r1 = getHourForDisplay(r5)
            goto L_0x0393
        L_0x038f:
            int r1 = r5.getMinute()
        L_0x0393:
            r4 = r1
            int r1 = r16 >> 3
            r14 = r1 & 896(0x380, float:1.256E-42)
            r14 = r14 | r0
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r14
            int r14 = r16 >> 9
            r15 = 57344(0xe000, float:8.0356E-41)
            r14 = r14 & r15
            r1 = r1 | r14
            r9 = r12
            r12 = r8
            r8 = r9
            r15 = r119
            r9 = r1
            r1 = r16
            r14 = r109
            m2722TimeSelectorSAnMeKU(r3, r4, r5, r6, r7, r8, r9)
            goto L_0x03ba
        L_0x03b1:
            r1 = r12
            r12 = r8
            r8 = r1
            r15 = r119
            r1 = r16
            r14 = r109
        L_0x03ba:
            r3 = r6
            r8.endReplaceGroup()
            androidx.compose.material3.TimePickerSelectionMode$Companion r4 = androidx.compose.material3.TimePickerSelectionMode.Companion
            int r4 = r4.m2755getMinuteyecRtBI()
            boolean r4 = androidx.compose.material3.TimePickerSelectionMode.m2750equalsimpl0(r3, r4)
            if (r4 == 0) goto L_0x03d3
            androidx.compose.material3.internal.Strings$Companion r4 = androidx.compose.material3.internal.Strings.Companion
            int r4 = androidx.compose.material3.R.string.m3c_time_picker_minute_text_field
            int r4 = androidx.compose.material3.internal.Strings.m2922constructorimpl(r4)
            goto L_0x03db
        L_0x03d3:
            androidx.compose.material3.internal.Strings$Companion r4 = androidx.compose.material3.internal.Strings.Companion
            int r4 = androidx.compose.material3.R.string.m3c_time_picker_hour_text_field
            int r4 = androidx.compose.material3.internal.Strings.m2922constructorimpl(r4)
        L_0x03db:
            r5 = 0
            java.lang.String r4 = androidx.compose.material3.internal.Strings_androidKt.m2992getString2EP1pXo(r4, r8, r5)
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            androidx.compose.ui.Modifier r6 = visible(r6, r13)
            r7 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            java.lang.String r9 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r7, r9)
            androidx.compose.ui.Alignment$Companion r7 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r7 = r7.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r7 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r7, r5)
            r9 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r13 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r9, r13)
            int r9 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r8, r5)
            androidx.compose.runtime.CompositionLocalMap r5 = r8.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r6 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r8, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r13 = r13.getConstructor()
            r0 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            java.lang.String r14 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r0, r14)
            androidx.compose.runtime.Applier r0 = r8.getApplier()
            boolean r0 = r0 instanceof androidx.compose.runtime.Applier
            if (r0 != 0) goto L_0x0427
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0427:
            r8.startReusableNode()
            boolean r0 = r8.getInserting()
            if (r0 == 0) goto L_0x0434
            r8.createNode(r13)
            goto L_0x0437
        L_0x0434:
            r8.useNode()
        L_0x0437:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.Updater.m3675constructorimpl(r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r0, r7, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r0, r5, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetCompositeKeyHash()
            boolean r7 = r0.getInserting()
            if (r7 != 0) goto L_0x0467
            java.lang.Object r7 = r0.rememberedValue()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r9)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r13)
            if (r7 != 0) goto L_0x0475
        L_0x0467:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r9)
            r0.updateRememberedValue(r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r9)
            r0.apply(r7, r5)
        L_0x0475:
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r0, r6, r5)
            r0 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            java.lang.String r5 = "C73@3429L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r0, r5)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r0 = -1024044049(0xffffffffc2f653ef, float:-123.16393)
            java.lang.String r5 = "C1803@69837L48,1807@70087L7,1814@70388L11,1815@70456L11,1819@70616L915,1797@69540L1991:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r0, r5)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.focus.FocusRequesterModifierKt.focusRequester(r0, r12)
            androidx.compose.material3.tokens.TimeInputTokens r5 = androidx.compose.material3.tokens.TimeInputTokens.INSTANCE
            float r5 = r5.m3559getTimeFieldContainerWidthD9Ej5fM()
            androidx.compose.material3.tokens.TimeInputTokens r6 = androidx.compose.material3.tokens.TimeInputTokens.INSTANCE
            float r6 = r6.m3558getTimeFieldContainerHeightD9Ej5fM()
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m847sizeVpY3zN4(r0, r5, r6)
            r5 = -1002857443(0xffffffffc4399c1d, float:-742.4393)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r5, r10)
            boolean r5 = r8.changed((java.lang.Object) r4)
            java.lang.Object r6 = r8.rememberedValue()
            if (r5 != 0) goto L_0x04c2
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r6 != r5) goto L_0x04cd
        L_0x04c2:
            androidx.compose.material3.TimePickerKt$TimePickerTextField$1$1$1$1 r5 = new androidx.compose.material3.TimePickerKt$TimePickerTextField$1$1$1$1
            r5.<init>(r4)
            r6 = r5
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r8.updateRememberedValue(r6)
        L_0x04cd:
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r4 = 0
            r5 = 0
            r14 = 1
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r0, r5, r6, r14, r4)
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.material3.TextKt.getLocalTextStyle()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r6, r7)
            java.lang.Object r5 = r8.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r7 = r5
            androidx.compose.ui.text.TextStyle r7 = (androidx.compose.ui.text.TextStyle) r7
            androidx.compose.ui.graphics.Brush$Companion r20 = androidx.compose.ui.graphics.Brush.Companion
            r5 = 6
            kotlin.Pair[] r6 = new kotlin.Pair[r5]
            r5 = 0
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            androidx.compose.ui.graphics.Color$Companion r9 = androidx.compose.ui.graphics.Color.Companion
            long r13 = r9.m4274getTransparent0d7_KjU()
            androidx.compose.ui.graphics.Color r9 = androidx.compose.ui.graphics.Color.m4229boximpl(r13)
            kotlin.Pair r5 = kotlin.TuplesKt.to(r5, r9)
            r9 = 0
            r6[r9] = r5
            r5 = 1036831949(0x3dcccccd, float:0.1)
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            androidx.compose.ui.graphics.Color$Companion r9 = androidx.compose.ui.graphics.Color.Companion
            long r13 = r9.m4274getTransparent0d7_KjU()
            androidx.compose.ui.graphics.Color r9 = androidx.compose.ui.graphics.Color.m4229boximpl(r13)
            kotlin.Pair r5 = kotlin.TuplesKt.to(r5, r9)
            r19 = 1
            r6[r19] = r5
            r5 = 1036831949(0x3dcccccd, float:0.1)
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            androidx.compose.material3.MaterialTheme r9 = androidx.compose.material3.MaterialTheme.INSTANCE
            r13 = 6
            androidx.compose.material3.ColorScheme r9 = r9.getColorScheme(r8, r13)
            long r16 = r9.m1867getPrimary0d7_KjU()
            androidx.compose.ui.graphics.Color r9 = androidx.compose.ui.graphics.Color.m4229boximpl(r16)
            kotlin.Pair r5 = kotlin.TuplesKt.to(r5, r9)
            r6[r106] = r5
            r5 = 1063675494(0x3f666666, float:0.9)
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            androidx.compose.material3.MaterialTheme r9 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.ColorScheme r9 = r9.getColorScheme(r8, r13)
            long r13 = r9.m1867getPrimary0d7_KjU()
            androidx.compose.ui.graphics.Color r9 = androidx.compose.ui.graphics.Color.m4229boximpl(r13)
            kotlin.Pair r5 = kotlin.TuplesKt.to(r5, r9)
            r9 = 3
            r6[r9] = r5
            r5 = 1063675494(0x3f666666, float:0.9)
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            androidx.compose.ui.graphics.Color$Companion r9 = androidx.compose.ui.graphics.Color.Companion
            long r13 = r9.m4274getTransparent0d7_KjU()
            androidx.compose.ui.graphics.Color r9 = androidx.compose.ui.graphics.Color.m4229boximpl(r13)
            kotlin.Pair r5 = kotlin.TuplesKt.to(r5, r9)
            r6[r105] = r5
            r5 = 1065353216(0x3f800000, float:1.0)
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            androidx.compose.ui.graphics.Color$Companion r9 = androidx.compose.ui.graphics.Color.Companion
            long r13 = r9.m4274getTransparent0d7_KjU()
            androidx.compose.ui.graphics.Color r9 = androidx.compose.ui.graphics.Color.m4229boximpl(r13)
            kotlin.Pair r5 = kotlin.TuplesKt.to(r5, r9)
            r9 = 5
            r6[r9] = r5
            r25 = 14
            r26 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r21 = r6
            androidx.compose.ui.graphics.Brush r16 = androidx.compose.ui.graphics.Brush.Companion.m4187verticalGradient8A3gB4$default((androidx.compose.ui.graphics.Brush.Companion) r20, (kotlin.Pair[]) r21, (float) r22, (float) r23, (int) r24, (int) r25, (java.lang.Object) r26)
            androidx.compose.material3.TimePickerKt$TimePickerTextField$1$1$2 r5 = new androidx.compose.material3.TimePickerKt$TimePickerTextField$1$1$2
            r5.<init>(r2, r15, r11)
            r6 = 54
            r9 = 825138052(0x312e9b84, float:2.5408733E-9)
            r14 = 1
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r9, r14, r5, r8, r6)
            r17 = r5
            kotlin.jvm.functions.Function3 r17 = (kotlin.jvm.functions.Function3) r17
            int r5 = r1 >> 3
            r6 = r5 & 14
            r9 = 100666368(0x6000c00, float:2.408294E-35)
            r6 = r6 | r9
            r5 = r5 & 112(0x70, float:1.57E-43)
            r5 = r5 | r6
            int r6 = r1 << 3
            r9 = 3670016(0x380000, float:5.142788E-39)
            r9 = r9 & r6
            r5 = r5 | r9
            r9 = 29360128(0x1c00000, float:7.052966E-38)
            r6 = r6 & r9
            r19 = r5 | r6
            r20 = 199680(0x30c00, float:2.79811E-40)
            r21 = 7696(0x1e10, float:1.0784E-41)
            r5 = 1
            r6 = 0
            r54 = r10
            r10 = 1
            r11 = 0
            r53 = r12
            r12 = 0
            r13 = 0
            r109 = r14
            r14 = 0
            r3 = r116
            r122 = r1
            r1 = r4
            r18 = r8
            r112 = r53
            r113 = r54
            r8 = r107
            r9 = r108
            r4 = r0
            r0 = r109
            androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField((androidx.compose.ui.text.input.TextFieldValue) r2, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit>) r3, (androidx.compose.ui.Modifier) r4, (boolean) r5, (boolean) r6, (androidx.compose.ui.text.TextStyle) r7, (androidx.compose.foundation.text.KeyboardOptions) r8, (androidx.compose.foundation.text.KeyboardActions) r9, (boolean) r10, (int) r11, (int) r12, (androidx.compose.ui.text.input.VisualTransformation) r13, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r14, (androidx.compose.foundation.interaction.MutableInteractionSource) r15, (androidx.compose.ui.graphics.Brush) r16, (kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r17, (androidx.compose.runtime.Composer) r18, (int) r19, (int) r20, (int) r21)
            r3 = r8
            r2 = r9
            r8 = r18
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r8.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            r5 = 0
            float r6 = SupportLabelTop
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.OffsetKt.m734offsetVpY3zN4$default(r4, r5, r6, r0, r1)
            androidx.compose.material3.TimePickerKt$TimePickerTextField$1$2 r5 = androidx.compose.material3.TimePickerKt$TimePickerTextField$1$2.INSTANCE
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            androidx.compose.ui.Modifier r5 = androidx.compose.ui.semantics.SemanticsModifierKt.clearAndSetSemantics(r4, r5)
            androidx.compose.material3.TimePickerSelectionMode$Companion r4 = androidx.compose.material3.TimePickerSelectionMode.Companion
            int r4 = r4.m2754getHouryecRtBI()
            r6 = r118
            boolean r4 = androidx.compose.material3.TimePickerSelectionMode.m2750equalsimpl0(r6, r4)
            if (r4 == 0) goto L_0x062b
            androidx.compose.material3.internal.Strings$Companion r4 = androidx.compose.material3.internal.Strings.Companion
            int r4 = androidx.compose.material3.R.string.m3c_time_picker_hour
            int r4 = androidx.compose.material3.internal.Strings.m2922constructorimpl(r4)
            goto L_0x0633
        L_0x062b:
            androidx.compose.material3.internal.Strings$Companion r4 = androidx.compose.material3.internal.Strings.Companion
            int r4 = androidx.compose.material3.R.string.m3c_time_picker_minute
            int r4 = androidx.compose.material3.internal.Strings.m2922constructorimpl(r4)
        L_0x0633:
            r9 = 0
            java.lang.String r4 = androidx.compose.material3.internal.Strings_androidKt.m2992getString2EP1pXo(r4, r8, r9)
            androidx.compose.material3.tokens.TimeInputTokens r7 = androidx.compose.material3.tokens.TimeInputTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r7 = r7.getTimeFieldSupportingTextColor()
            r13 = 6
            long r9 = androidx.compose.material3.ColorSchemeKt.getValue(r7, r8, r13)
            androidx.compose.material3.tokens.TimeInputTokens r7 = androidx.compose.material3.tokens.TimeInputTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r7 = r7.getTimeFieldSupportingTextFont()
            androidx.compose.ui.text.TextStyle r24 = androidx.compose.material3.TypographyKt.getValue(r7, r8, r13)
            r27 = 0
            r28 = 65528(0xfff8, float:9.1824E-41)
            r25 = r8
            r6 = r9
            r8 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r26 = 0
            r0 = r118
            androidx.compose.material3.TextKt.m2692Text4IGK_g((java.lang.String) r4, (androidx.compose.ui.Modifier) r5, (long) r6, (long) r8, (androidx.compose.ui.text.font.FontStyle) r10, (androidx.compose.ui.text.font.FontWeight) r11, (androidx.compose.ui.text.font.FontFamily) r12, (long) r13, (androidx.compose.ui.text.style.TextDecoration) r15, (androidx.compose.ui.text.style.TextAlign) r16, (long) r17, (int) r19, (boolean) r20, (int) r21, (int) r22, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r23, (androidx.compose.ui.text.TextStyle) r24, (androidx.compose.runtime.Composer) r25, (int) r26, (int) r27, (int) r28)
            r8 = r25
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r8.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            int r4 = r117.m2756getSelectionyecRtBI()
            androidx.compose.material3.TimePickerSelectionMode r4 = androidx.compose.material3.TimePickerSelectionMode.m2747boximpl(r4)
            r5 = 883095798(0x34a2f8f6, float:3.0355994E-7)
            r10 = r113
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r5, r10)
            r5 = r122
            r6 = r5 & 7168(0x1c00, float:1.0045E-41)
            r7 = 2048(0x800, float:2.87E-42)
            if (r6 == r7) goto L_0x06af
            r6 = r5 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x06ab
            r6 = r117
            boolean r7 = r8.changedInstance(r6)
            if (r7 == 0) goto L_0x06ad
            goto L_0x06b1
        L_0x06ab:
            r6 = r117
        L_0x06ad:
            r14 = 0
            goto L_0x06b2
        L_0x06af:
            r6 = r117
        L_0x06b1:
            r14 = 1
        L_0x06b2:
            r7 = 57344(0xe000, float:8.0356E-41)
            r5 = r5 & r7
            r7 = 16384(0x4000, float:2.2959E-41)
            if (r5 != r7) goto L_0x06bd
            r31 = 1
            goto L_0x06bf
        L_0x06bd:
            r31 = 0
        L_0x06bf:
            r5 = r14 | r31
            java.lang.Object r7 = r8.rememberedValue()
            if (r5 != 0) goto L_0x06cf
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r7 != r5) goto L_0x06dc
        L_0x06cf:
            androidx.compose.material3.TimePickerKt$TimePickerTextField$2$1 r5 = new androidx.compose.material3.TimePickerKt$TimePickerTextField$2$1
            r12 = r112
            r5.<init>(r6, r0, r12, r1)
            r7 = r5
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r8.updateRememberedValue(r7)
        L_0x06dc:
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r5 = 0
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r4, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r7, (androidx.compose.runtime.Composer) r8, (int) r5)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x06ee
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x06ee:
            r7 = r2
            r14 = r3
        L_0x06f0:
            androidx.compose.runtime.ScopeUpdateScope r11 = r8.endRestartGroup()
            if (r11 == 0) goto L_0x0710
            androidx.compose.material3.TimePickerKt$TimePickerTextField$3 r0 = new androidx.compose.material3.TimePickerKt$TimePickerTextField$3
            r1 = r114
            r2 = r115
            r3 = r116
            r5 = r118
            r8 = r121
            r9 = r123
            r10 = r124
            r4 = r6
            r6 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r11.updateScope(r0)
        L_0x0710:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.m2721TimePickerTextField1vLObsk(androidx.compose.ui.Modifier, androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.material3.TimePickerState, int, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, androidx.compose.material3.TimePickerColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: CircularLayout-uFdPcIQ  reason: not valid java name */
    public static final void m2719CircularLayoutuFdPcIQ(Modifier modifier, float f, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1548175696);
        ComposerKt.sourceInformation(startRestartGroup, "C(CircularLayout)P(1,2:c#ui.unit.Dp)1871@72466L1666,1871@72419L1713:TimePicker.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i3 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1548175696, i3, -1, "androidx.compose.material3.CircularLayout (TimePicker.kt:1870)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -328610546, "CC(remember):TimePicker.kt#9igjgp");
            boolean z = (i3 & 112) == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new TimePickerKt$CircularLayout$1$1(f);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            int i5 = ((i3 >> 6) & 14) | ((i3 << 3) & 112);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            int i6 = ((i5 << 6) & 896) | 6;
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
            Composer r5 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r5, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r5, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r5.getInserting() || !Intrinsics.areEqual(r5.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r5.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r5, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            function2.invoke(startRestartGroup, Integer.valueOf((i6 >> 6) & 14));
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        Modifier modifier2 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TimePickerKt$CircularLayout$2(modifier2, f, function2, i, i2));
        }
    }

    /* renamed from: numberContentDescription-dSwYdS4  reason: not valid java name */
    public static final String m2730numberContentDescriptiondSwYdS4(int i, boolean z, int i2, Composer composer, int i3) {
        int i4;
        ComposerKt.sourceInformationMarkerStart(composer, 194237364, "C(numberContentDescription)P(2:c#material3.TimePickerSelectionMode)1924@74567L21:TimePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(194237364, i3, -1, "androidx.compose.material3.numberContentDescription (TimePicker.kt:1914)");
        }
        if (TimePickerSelectionMode.m2750equalsimpl0(i, TimePickerSelectionMode.Companion.m2755getMinuteyecRtBI())) {
            Strings.Companion companion = Strings.Companion;
            i4 = Strings.m2922constructorimpl(R.string.m3c_time_picker_minute_suffix);
        } else if (z) {
            Strings.Companion companion2 = Strings.Companion;
            i4 = Strings.m2922constructorimpl(R.string.m3c_time_picker_hour_24h_suffix);
        } else {
            Strings.Companion companion3 = Strings.Companion;
            i4 = Strings.m2922constructorimpl(R.string.m3c_time_picker_hour_suffix);
        }
        String r3 = Strings_androidKt.m2993getStringqBjtwXw(i4, new Object[]{Integer.valueOf(i2)}, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return r3;
    }

    private static final float dist(float f, float f2, int i, int i2) {
        return (float) Math.hypot((double) (((float) i) - f), (double) (((float) i2) - f2));
    }

    /* access modifiers changed from: private */
    public static final float atan(float f, float f2) {
        float atan2 = ((float) Math.atan2((double) f, (double) f2)) - 1.5707964f;
        return atan2 < 0.0f ? atan2 + FullCircle : atan2;
    }

    private static final Modifier visible(Modifier modifier, boolean z) {
        return modifier.then(new VisibleModifier(z, InspectableValueKt.isDebugInspectorInfoEnabled() ? new TimePickerKt$visible$$inlined$debugInspectorInfo$1(z) : InspectableValueKt.getNoInspectorInfo()));
    }

    private static final boolean TimePicker_mT9BvqQ$lambda$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* access modifiers changed from: private */
    public static final void TimeInputImpl$lambda$7(MutableState<TextFieldValue> mutableState, TextFieldValue textFieldValue) {
        mutableState.setValue(textFieldValue);
    }

    /* access modifiers changed from: private */
    public static final void TimeInputImpl$lambda$10(MutableState<TextFieldValue> mutableState, TextFieldValue textFieldValue) {
        mutableState.setValue(textFieldValue);
    }

    static {
        float f = (float) 24;
        ClockFaceBottomMargin = Dp.m7111constructorimpl(f);
        DisplaySeparatorWidth = Dp.m7111constructorimpl(f);
        TimeInputBottomPadding = Dp.m7111constructorimpl(f);
        IntList intListOf = IntListKt.intListOf(12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        Hours = intListOf;
        MutableIntList mutableIntList = new MutableIntList(intListOf.getSize());
        int[] iArr = intListOf.content;
        int i = intListOf._size;
        for (int i2 = 0; i2 < i; i2++) {
            mutableIntList.add((iArr[i2] % 12) + 12);
        }
        ExtraHours = mutableIntList;
    }
}
