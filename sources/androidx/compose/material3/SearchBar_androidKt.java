package androidx.compose.material3;

import androidx.activity.BackEventCompat;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000¾\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u0001\u0010,\u001a\u00020-2\u0011\u0010.\u001a\r\u0012\u0004\u0012\u00020-0/¢\u0006\u0002\b02\u0006\u00101\u001a\u0002022\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020-042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020\u00152\b\b\u0002\u0010<\u001a\u00020\u00152\u001c\u0010=\u001a\u0018\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020-04¢\u0006\u0002\b0¢\u0006\u0002\b?H\u0007ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a\u0002\u0010,\u001a\u00020-2\u0006\u0010B\u001a\u00020\u001a2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020-042\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020-042\u0006\u0010E\u001a\u0002022\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020-042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u0010G\u001a\u0002022\u0015\b\u0002\u0010H\u001a\u000f\u0012\u0004\u0012\u00020-\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u0010I\u001a\u000f\u0012\u0004\u0012\u00020-\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u0010J\u001a\u000f\u0012\u0004\u0012\u00020-\u0018\u00010/¢\u0006\u0002\b02\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020\u00152\b\b\u0002\u0010<\u001a\u00020\u00152\n\b\u0002\u0010K\u001a\u0004\u0018\u00010L2\u001c\u0010=\u001a\u0018\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020-04¢\u0006\u0002\b0¢\u0006\u0002\b?H\u0007ø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001a\u0001\u0010O\u001a\u00020-2\u0011\u0010.\u001a\r\u0012\u0004\u0012\u00020-0/¢\u0006\u0002\b02\u0006\u00101\u001a\u0002022\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020-042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020\u00152\b\b\u0002\u0010<\u001a\u00020\u00152\b\b\u0002\u0010P\u001a\u00020Q2\u001c\u0010=\u001a\u0018\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020-04¢\u0006\u0002\b0¢\u0006\u0002\b?H\u0007ø\u0001\u0000¢\u0006\u0004\bR\u0010S\u001a\u0002\u0010O\u001a\u00020-2\u0006\u0010B\u001a\u00020\u001a2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020-042\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020-042\u0006\u0010E\u001a\u0002022\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020-042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u0010G\u001a\u0002022\u0015\b\u0002\u0010H\u001a\u000f\u0012\u0004\u0012\u00020-\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u0010I\u001a\u000f\u0012\u0004\u0012\u00020-\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u0010J\u001a\u000f\u0012\u0004\u0012\u00020-\u0018\u00010/¢\u0006\u0002\b02\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020\u00152\b\b\u0002\u0010<\u001a\u00020\u00152\b\b\u0002\u0010P\u001a\u00020Q2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010L2\u001c\u0010=\u001a\u0018\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020-04¢\u0006\u0002\b0¢\u0006\u0002\b?H\u0007ø\u0001\u0000¢\u0006\u0004\bT\u0010U\u001a»\u0001\u0010V\u001a\u00020-2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020Y0X2\u0006\u0010Z\u001a\u00020[2\u000e\u0010\\\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010^0]2\u000e\u0010_\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010^0]2\b\b\u0002\u00105\u001a\u0002062\u0011\u0010.\u001a\r\u0012\u0004\u0012\u00020-0/¢\u0006\u0002\b02\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020\u00152\b\b\u0002\u0010<\u001a\u00020\u00152\b\b\u0002\u0010P\u001a\u00020Q2\u001c\u0010=\u001a\u0018\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020-04¢\u0006\u0002\b0¢\u0006\u0002\b?H\u0001ø\u0001\u0000¢\u0006\u0004\b`\u0010a\u001a\u0001\u0010b\u001a\u00020-2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020Y0X2\u0006\u0010Z\u001a\u00020[2\u000e\u0010\\\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010^0]2\u000e\u0010_\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010^0]2\u0006\u00105\u001a\u0002062\u0006\u0010P\u001a\u00020Q2\u0011\u0010.\u001a\r\u0012\u0004\u0012\u00020-0/¢\u0006\u0002\b02\u0011\u0010c\u001a\r\u0012\u0004\u0012\u00020-0/¢\u0006\u0002\b02\u0013\u0010=\u001a\u000f\u0012\u0004\u0012\u00020-\u0018\u00010/¢\u0006\u0002\b0H\u0003¢\u0006\u0002\u0010d\u001a\"\u0010e\u001a\u00020\u00072\b\u0010_\u001a\u0004\u0018\u00010^2\u0006\u0010f\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020\u0007H\u0002\u001aD\u0010g\u001a\u00020\u00012\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020\u00012\b\u0010_\u001a\u0004\u0018\u00010^2\u0006\u0010k\u001a\u00020l2\u0006\u0010f\u001a\u00020\u00072\u0006\u0010m\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\bn\u0010o\u001aN\u0010p\u001a\u00020\u00012\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020\u00012\b\u0010_\u001a\u0004\u0018\u00010^2\b\u0010\\\u001a\u0004\u0018\u00010^2\u0006\u0010q\u001a\u00020\u00012\u0006\u0010r\u001a\u00020\u00012\u0006\u0010m\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\bs\u0010t\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u0016\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017\"\u000e\u0010\u0019\u001a\u00020\u001aXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u001aXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u001aXT¢\u0006\u0002\n\u0000\"\u0016\u0010\u001d\u001a\u00020\u0015X\u0004¢\u0006\n\n\u0002\u0010\u0018\u0012\u0004\b\u001e\u0010\u001f\"\u0010\u0010 \u001a\u00020\u0015X\u0004¢\u0006\u0004\n\u0002\u0010\u0018\"\u0010\u0010!\u001a\u00020\u0015X\u0004¢\u0006\u0004\n\u0002\u0010\u0018\"\u0016\u0010\"\u001a\u00020\u0015X\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b#\u0010\u0017\"\u000e\u0010$\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u0010\u0010%\u001a\u00020\u0015X\u0004¢\u0006\u0004\n\u0002\u0010\u0018\"\u0010\u0010&\u001a\u00020\u0015X\u0004¢\u0006\u0004\n\u0002\u0010\u0018\"\u000e\u0010'\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u0016\u0010(\u001a\u00020\u0015X\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b)\u0010\u0017\"\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006u²\u0006\n\u0010v\u001a\u000202X\u0002²\u0006\n\u0010w\u001a\u000202X\u0002"}, d2 = {"AnimationDelayMillis", "", "AnimationEnterDurationMillis", "AnimationEnterEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "AnimationEnterFloatSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "AnimationEnterSizeSpec", "Landroidx/compose/ui/unit/IntSize;", "AnimationExitDurationMillis", "AnimationExitEasing", "AnimationExitFloatSpec", "AnimationExitSizeSpec", "AnimationPredictiveBackExitFloatSpec", "DockedEnterTransition", "Landroidx/compose/animation/EnterTransition;", "DockedExitTransition", "Landroidx/compose/animation/ExitTransition;", "DockedExpandedTableMaxHeightScreenRatio", "DockedExpandedTableMinHeight", "Landroidx/compose/ui/unit/Dp;", "getDockedExpandedTableMinHeight", "()F", "F", "LayoutIdInputField", "", "LayoutIdSearchContent", "LayoutIdSurface", "SearchBarCornerRadius", "getSearchBarCornerRadius$annotations", "()V", "SearchBarIconOffsetX", "SearchBarMaxWidth", "SearchBarMinWidth", "getSearchBarMinWidth", "SearchBarPredictiveBackMaxOffsetXRatio", "SearchBarPredictiveBackMaxOffsetY", "SearchBarPredictiveBackMinMargin", "SearchBarPredictiveBackMinScale", "SearchBarVerticalPadding", "getSearchBarVerticalPadding", "UnspecifiedTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "DockedSearchBar", "", "inputField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "expanded", "", "onExpandedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/SearchBarColors;", "tonalElevation", "shadowElevation", "content", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "DockedSearchBar-EQC0FA8", "(Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "query", "onQueryChange", "onSearch", "active", "onActiveChange", "enabled", "placeholder", "leadingIcon", "trailingIcon", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "DockedSearchBar-eWTbjVg", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SearchBar", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "SearchBar-Y92LkZI", "(Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SearchBar-WuY5d9Q", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SearchBarImpl", "animationProgress", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "finalBackProgress", "Landroidx/compose/runtime/MutableFloatState;", "firstBackEvent", "Landroidx/compose/runtime/MutableState;", "Landroidx/activity/BackEventCompat;", "currentBackEvent", "SearchBarImpl-j1jLAyQ", "(Landroidx/compose/animation/core/Animatable;Landroidx/compose/runtime/MutableFloatState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SearchBarLayout", "surface", "(Landroidx/compose/animation/core/Animatable;Landroidx/compose/runtime/MutableFloatState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "calculatePredictiveBackMultiplier", "progress", "calculatePredictiveBackOffsetX", "constraints", "Landroidx/compose/ui/unit/Constraints;", "minMargin", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "predictiveBackMultiplier", "calculatePredictiveBackOffsetX-rOvwMX4", "(JILandroidx/activity/BackEventCompat;Landroidx/compose/ui/unit/LayoutDirection;FF)I", "calculatePredictiveBackOffsetY", "height", "maxOffsetY", "calculatePredictiveBackOffsetY-dzo92Q0", "(JILandroidx/activity/BackEventCompat;Landroidx/activity/BackEventCompat;IIF)I", "material3_release", "useFullScreenShape", "showContent"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SearchBar.android.kt */
public final class SearchBar_androidKt {
    private static final int AnimationDelayMillis = 100;
    private static final int AnimationEnterDurationMillis = 600;
    private static final CubicBezierEasing AnimationEnterEasing;
    /* access modifiers changed from: private */
    public static final FiniteAnimationSpec<Float> AnimationEnterFloatSpec;
    private static final FiniteAnimationSpec<IntSize> AnimationEnterSizeSpec;
    private static final int AnimationExitDurationMillis = 350;
    private static final CubicBezierEasing AnimationExitEasing;
    /* access modifiers changed from: private */
    public static final FiniteAnimationSpec<Float> AnimationExitFloatSpec;
    private static final FiniteAnimationSpec<IntSize> AnimationExitSizeSpec;
    /* access modifiers changed from: private */
    public static final FiniteAnimationSpec<Float> AnimationPredictiveBackExitFloatSpec;
    /* access modifiers changed from: private */
    public static final EnterTransition DockedEnterTransition;
    /* access modifiers changed from: private */
    public static final ExitTransition DockedExitTransition;
    private static final float DockedExpandedTableMaxHeightScreenRatio = 0.6666667f;
    private static final float DockedExpandedTableMinHeight = Dp.m7111constructorimpl((float) 240);
    private static final String LayoutIdInputField = "InputField";
    private static final String LayoutIdSearchContent = "Content";
    private static final String LayoutIdSurface = "Surface";
    /* access modifiers changed from: private */
    public static final float SearchBarCornerRadius = Dp.m7111constructorimpl(SearchBarDefaults.INSTANCE.m2401getInputFieldHeightD9Ej5fM() / ((float) 2));
    /* access modifiers changed from: private */
    public static final float SearchBarIconOffsetX = Dp.m7111constructorimpl((float) 4);
    /* access modifiers changed from: private */
    public static final float SearchBarMaxWidth = Dp.m7111constructorimpl((float) 720);
    private static final float SearchBarMinWidth = Dp.m7111constructorimpl((float) 360);
    private static final float SearchBarPredictiveBackMaxOffsetXRatio = 0.05f;
    /* access modifiers changed from: private */
    public static final float SearchBarPredictiveBackMaxOffsetY = Dp.m7111constructorimpl((float) 24);
    /* access modifiers changed from: private */
    public static final float SearchBarPredictiveBackMinMargin;
    private static final float SearchBarPredictiveBackMinScale = 0.9f;
    private static final float SearchBarVerticalPadding;
    /* access modifiers changed from: private */
    public static final TextFieldColors UnspecifiedTextFieldColors = new TextFieldColors(Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), new TextSelectionColors(Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), (DefaultConstructorMarker) null), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), Color.Companion.m4275getUnspecified0d7_KjU(), (DefaultConstructorMarker) null);

    private static /* synthetic */ void getSearchBarCornerRadius$annotations() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x03bd  */
    /* JADX WARNING: Removed duplicated region for block: B:198:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0114  */
    /* renamed from: SearchBar-Y92LkZI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2409SearchBarY92LkZI(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, boolean r30, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r31, androidx.compose.ui.Modifier r32, androidx.compose.ui.graphics.Shape r33, androidx.compose.material3.SearchBarColors r34, float r35, float r36, androidx.compose.foundation.layout.WindowInsets r37, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, int r40, int r41) {
        /*
            r2 = r30
            r11 = r40
            r12 = r41
            r0 = 1444649673(0x561b9ac9, float:4.2772275E13)
            r1 = r39
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(SearchBar)P(3,2,5,4,7!1,8:c#ui.unit.Dp,6:c#ui.unit.Dp,9)171@8255L15,172@8320L8,175@8501L12,178@8596L64,179@8689L43,180@8758L51,181@8837L51,183@8919L638,183@8894L663,199@9582L27,200@9656L1062,200@9614L1104,226@10724L458:SearchBar.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x001d
            r1 = r11 | 6
            r14 = r29
            goto L_0x002f
        L_0x001d:
            r1 = r11 & 6
            r14 = r29
            if (r1 != 0) goto L_0x002e
            boolean r1 = r8.changedInstance(r14)
            if (r1 == 0) goto L_0x002b
            r1 = 4
            goto L_0x002c
        L_0x002b:
            r1 = 2
        L_0x002c:
            r1 = r1 | r11
            goto L_0x002f
        L_0x002e:
            r1 = r11
        L_0x002f:
            r3 = r12 & 2
            if (r3 == 0) goto L_0x0036
            r1 = r1 | 48
            goto L_0x0046
        L_0x0036:
            r3 = r11 & 48
            if (r3 != 0) goto L_0x0046
            boolean r3 = r8.changed((boolean) r2)
            if (r3 == 0) goto L_0x0043
            r3 = 32
            goto L_0x0045
        L_0x0043:
            r3 = 16
        L_0x0045:
            r1 = r1 | r3
        L_0x0046:
            r3 = r12 & 4
            if (r3 == 0) goto L_0x004d
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0060
        L_0x004d:
            r3 = r11 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x0060
            r3 = r31
            boolean r5 = r8.changedInstance(r3)
            if (r5 == 0) goto L_0x005c
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005c:
            r5 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r1 = r1 | r5
            goto L_0x0062
        L_0x0060:
            r3 = r31
        L_0x0062:
            r5 = r12 & 8
            if (r5 == 0) goto L_0x0069
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007c
        L_0x0069:
            r6 = r11 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x007c
            r6 = r32
            boolean r7 = r8.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0078
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r1 = r1 | r7
            goto L_0x007e
        L_0x007c:
            r6 = r32
        L_0x007e:
            r7 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x0097
            r7 = r12 & 16
            if (r7 != 0) goto L_0x0091
            r7 = r33
            boolean r9 = r8.changed((java.lang.Object) r7)
            if (r9 == 0) goto L_0x0093
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0095
        L_0x0091:
            r7 = r33
        L_0x0093:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x0095:
            r1 = r1 | r9
            goto L_0x0099
        L_0x0097:
            r7 = r33
        L_0x0099:
            r9 = 196608(0x30000, float:2.75506E-40)
            r9 = r9 & r11
            if (r9 != 0) goto L_0x00b3
            r9 = r12 & 32
            if (r9 != 0) goto L_0x00ad
            r9 = r34
            boolean r10 = r8.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x00af
            r10 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b1
        L_0x00ad:
            r9 = r34
        L_0x00af:
            r10 = 65536(0x10000, float:9.18355E-41)
        L_0x00b1:
            r1 = r1 | r10
            goto L_0x00b5
        L_0x00b3:
            r9 = r34
        L_0x00b5:
            r16 = r12 & 64
            r10 = 1572864(0x180000, float:2.204052E-39)
            if (r16 == 0) goto L_0x00bd
            r1 = r1 | r10
            goto L_0x00d0
        L_0x00bd:
            r10 = r10 & r11
            if (r10 != 0) goto L_0x00d0
            r10 = r35
            boolean r17 = r8.changed((float) r10)
            if (r17 == 0) goto L_0x00cb
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cd
        L_0x00cb:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00cd:
            r1 = r1 | r17
            goto L_0x00d2
        L_0x00d0:
            r10 = r35
        L_0x00d2:
            r15 = r12 & 128(0x80, float:1.794E-43)
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            if (r15 == 0) goto L_0x00dd
            r1 = r1 | r17
            r13 = r36
            goto L_0x00f0
        L_0x00dd:
            r17 = r11 & r17
            r13 = r36
            if (r17 != 0) goto L_0x00f0
            boolean r18 = r8.changed((float) r13)
            if (r18 == 0) goto L_0x00ec
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ee
        L_0x00ec:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ee:
            r1 = r1 | r18
        L_0x00f0:
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            r18 = r11 & r18
            if (r18 != 0) goto L_0x010c
            r4 = r12 & 256(0x100, float:3.59E-43)
            if (r4 != 0) goto L_0x0105
            r4 = r37
            boolean r19 = r8.changed((java.lang.Object) r4)
            if (r19 == 0) goto L_0x0107
            r19 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0109
        L_0x0105:
            r4 = r37
        L_0x0107:
            r19 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0109:
            r1 = r1 | r19
            goto L_0x010e
        L_0x010c:
            r4 = r37
        L_0x010e:
            r0 = r12 & 512(0x200, float:7.175E-43)
            r20 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x0117
            r1 = r1 | r20
            goto L_0x012b
        L_0x0117:
            r0 = r11 & r20
            if (r0 != 0) goto L_0x012b
            r0 = r38
            boolean r20 = r8.changedInstance(r0)
            if (r20 == 0) goto L_0x0126
            r20 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0128
        L_0x0126:
            r20 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0128:
            r1 = r1 | r20
            goto L_0x012d
        L_0x012b:
            r0 = r38
        L_0x012d:
            r20 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r1 & r20
            r20 = r1
            r1 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r1) goto L_0x014e
            boolean r0 = r8.getSkipping()
            if (r0 != 0) goto L_0x0140
            goto L_0x014e
        L_0x0140:
            r8.skipToGroupEnd()
            r5 = r9
            r9 = r4
            r4 = r6
            r6 = r5
            r5 = r7
            r25 = r8
            r7 = r10
            r8 = r13
            goto L_0x03b7
        L_0x014e:
            r8.startDefaults()
            r0 = r11 & 1
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r21 = -458753(0xfffffffffff8ffff, float:NaN)
            r22 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x0189
            boolean r0 = r8.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0165
            goto L_0x0189
        L_0x0165:
            r8.skipToGroupEnd()
            r0 = r12 & 16
            if (r0 == 0) goto L_0x0170
            r0 = r20 & r22
            r20 = r0
        L_0x0170:
            r0 = r12 & 32
            if (r0 == 0) goto L_0x0176
            r20 = r20 & r21
        L_0x0176:
            r0 = r12 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x017c
            r20 = r20 & r1
        L_0x017c:
            r24 = r4
            r15 = r13
            r0 = r20
            r11 = 256(0x100, float:3.59E-43)
            r13 = r10
            r10 = r9
            r9 = r7
            r7 = r6
            goto L_0x01f9
        L_0x0189:
            if (r5 == 0) goto L_0x0190
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0191
        L_0x0190:
            r0 = r6
        L_0x0191:
            r5 = r12 & 16
            r6 = 6
            if (r5 == 0) goto L_0x01a3
            androidx.compose.material3.SearchBarDefaults r5 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r5 = r5.getInputFieldShape(r8, r6)
            r7 = r20 & r22
            r20 = r5
            r22 = r7
            goto L_0x01a7
        L_0x01a3:
            r22 = r20
            r20 = r7
        L_0x01a7:
            r5 = r12 & 32
            if (r5 == 0) goto L_0x01c3
            androidx.compose.material3.SearchBarDefaults r3 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            r9 = 384(0x180, float:5.38E-43)
            r10 = 3
            r4 = 0
            r23 = r6
            r6 = 0
            r18 = r1
            r1 = r23
            r11 = 256(0x100, float:3.59E-43)
            androidx.compose.material3.SearchBarColors r3 = r3.m2399colorsdgg9oW8(r4, r6, r8, r9, r10)
            r4 = r22 & r21
            goto L_0x01cb
        L_0x01c3:
            r18 = r1
            r1 = r6
            r11 = 256(0x100, float:3.59E-43)
            r3 = r9
            r4 = r22
        L_0x01cb:
            if (r16 == 0) goto L_0x01d4
            androidx.compose.material3.SearchBarDefaults r5 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            float r5 = r5.m2403getTonalElevationD9Ej5fM()
            goto L_0x01d6
        L_0x01d4:
            r5 = r35
        L_0x01d6:
            if (r15 == 0) goto L_0x01df
            androidx.compose.material3.SearchBarDefaults r6 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            float r6 = r6.m2402getShadowElevationD9Ej5fM()
            goto L_0x01e0
        L_0x01df:
            r6 = r13
        L_0x01e0:
            r7 = r12 & 256(0x100, float:3.59E-43)
            if (r7 == 0) goto L_0x01f0
            androidx.compose.material3.SearchBarDefaults r7 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r1 = r7.getWindowInsets(r8, r1)
            r4 = r4 & r18
            r7 = r0
            r24 = r1
            goto L_0x01f3
        L_0x01f0:
            r24 = r37
            r7 = r0
        L_0x01f3:
            r10 = r3
            r0 = r4
            r13 = r5
            r15 = r6
            r9 = r20
        L_0x01f9:
            r8.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x020b
            r1 = -1
            java.lang.String r3 = "androidx.compose.material3.SearchBar (SearchBar.android.kt:177)"
            r4 = 1444649673(0x561b9ac9, float:4.2772275E13)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r0, r1, r3)
        L_0x020b:
            r1 = 626005896(0x25501788, float:1.8049097E-16)
            java.lang.String r3 = "CC(remember):SearchBar.android.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r1, r3)
            java.lang.Object r1 = r8.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            r5 = 0
            if (r1 != r4) goto L_0x022f
            r1 = 0
            if (r2 == 0) goto L_0x0226
            r4 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0227
        L_0x0226:
            r4 = r1
        L_0x0227:
            r6 = 2
            androidx.compose.animation.core.Animatable r1 = androidx.compose.animation.core.AnimatableKt.Animatable$default(r4, r1, r6, r5)
            r8.updateRememberedValue(r1)
        L_0x022f:
            androidx.compose.animation.core.Animatable r1 = (androidx.compose.animation.core.Animatable) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r4 = 626008851(0x25502313, float:1.8053008E-16)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r4, r3)
            java.lang.Object r4 = r8.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r4 != r6) goto L_0x024f
            r4 = 2143289344(0x7fc00000, float:NaN)
            androidx.compose.runtime.MutableFloatState r4 = androidx.compose.runtime.PrimitiveSnapshotStateKt.mutableFloatStateOf(r4)
            r8.updateRememberedValue(r4)
        L_0x024f:
            r18 = r4
            androidx.compose.runtime.MutableFloatState r18 = (androidx.compose.runtime.MutableFloatState) r18
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r4 = 626011067(0x25502bbb, float:1.805594E-16)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r4, r3)
            java.lang.Object r4 = r8.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r4 != r6) goto L_0x0270
            r6 = 2
            androidx.compose.runtime.MutableState r4 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r5, r5, r6, r5)
            r8.updateRememberedValue(r4)
        L_0x0270:
            androidx.compose.runtime.MutableState r4 = (androidx.compose.runtime.MutableState) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r6 = 626013595(0x2550359b, float:1.8059286E-16)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r6, r3)
            java.lang.Object r6 = r8.rememberedValue()
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r16.getEmpty()
            if (r6 != r11) goto L_0x028f
            r11 = 2
            androidx.compose.runtime.MutableState r6 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r5, r5, r11, r5)
            r8.updateRememberedValue(r6)
        L_0x028f:
            r5 = r6
            androidx.compose.runtime.MutableState r5 = (androidx.compose.runtime.MutableState) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r2)
            r6 = 626016806(0x25504226, float:1.8063536E-16)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r6, r3)
            boolean r6 = r8.changedInstance(r1)
            r16 = r0
            r0 = r16 & 112(0x70, float:1.57E-43)
            r32 = r6
            r17 = 1
            r6 = 32
            if (r0 != r6) goto L_0x02b2
            r0 = r17
            goto L_0x02b3
        L_0x02b2:
            r0 = 0
        L_0x02b3:
            r0 = r32 | r0
            java.lang.Object r6 = r8.rememberedValue()
            if (r0 != 0) goto L_0x02ce
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r6 != r0) goto L_0x02c4
            goto L_0x02ce
        L_0x02c4:
            r32 = r7
            r34 = r9
            r7 = r16
            r9 = r3
            r3 = r18
            goto L_0x02e3
        L_0x02ce:
            androidx.compose.material3.SearchBar_androidKt$SearchBar$1$1 r0 = new androidx.compose.material3.SearchBar_androidKt$SearchBar$1$1
            r6 = 0
            r32 = r7
            r34 = r9
            r7 = r16
            r9 = r3
            r3 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r6 = r0
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r8.updateRememberedValue(r6)
        L_0x02e3:
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            int r0 = r7 >> 3
            r0 = r0 & 14
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r11, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r6, (androidx.compose.runtime.Composer) r8, (int) r0)
            r6 = 626037411(0x255092a3, float:1.8090807E-16)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r6, r9)
            java.lang.Object r6 = r8.rememberedValue()
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r6 != r11) goto L_0x0309
            androidx.compose.foundation.MutatorMutex r6 = new androidx.compose.foundation.MutatorMutex
            r6.<init>()
            r8.updateRememberedValue(r6)
        L_0x0309:
            androidx.compose.foundation.MutatorMutex r6 = (androidx.compose.foundation.MutatorMutex) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r11 = 626040814(0x25509fee, float:1.809531E-16)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r11, r9)
            boolean r9 = r8.changedInstance(r1)
            r11 = r7 & 896(0x380, float:1.256E-42)
            r16 = r1
            r1 = 256(0x100, float:3.59E-43)
            if (r11 != r1) goto L_0x0321
            goto L_0x0323
        L_0x0321:
            r17 = 0
        L_0x0323:
            r1 = r9 | r17
            java.lang.Object r9 = r8.rememberedValue()
            if (r1 != 0) goto L_0x0337
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r9 != r1) goto L_0x0334
            goto L_0x0337
        L_0x0334:
            r1 = r16
            goto L_0x0353
        L_0x0337:
            r1 = r16
            androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1 r16 = new androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1
            r23 = 0
            r20 = r31
            r19 = r1
            r18 = r3
            r21 = r4
            r22 = r5
            r17 = r6
            r16.<init>(r17, r18, r19, r20, r21, r22, r23)
            r9 = r16
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r8.updateRememberedValue(r9)
        L_0x0353:
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r6 = 0
            androidx.activity.compose.PredictiveBackHandlerKt.PredictiveBackHandler(r2, r9, r8, r0, r6)
            int r0 = androidx.compose.animation.core.Animatable.$stable
            r0 = r0 | 3504(0xdb0, float:4.91E-42)
            int r6 = r7 << 3
            r9 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r9
            r0 = r0 | r6
            int r6 = r7 << 15
            r9 = 458752(0x70000, float:6.42848E-40)
            r6 = r6 & r9
            r0 = r0 | r6
            int r6 = r7 << 6
            r9 = 3670016(0x380000, float:5.142788E-39)
            r9 = r9 & r6
            r0 = r0 | r9
            r9 = 29360128(0x1c00000, float:7.052966E-38)
            r9 = r9 & r6
            r0 = r0 | r9
            r9 = 234881024(0xe000000, float:1.5777218E-30)
            r9 = r9 & r6
            r0 = r0 | r9
            r9 = 1879048192(0x70000000, float:1.58456325E29)
            r6 = r6 & r9
            r26 = r0 | r6
            int r0 = r7 >> 24
            r27 = r0 & 126(0x7e, float:1.77E-43)
            r28 = 0
            r17 = r32
            r19 = r34
            r16 = r5
            r25 = r8
            r20 = r10
            r21 = r13
            r18 = r14
            r22 = r15
            r23 = r24
            r24 = r38
            r13 = r1
            r14 = r3
            r15 = r4
            m2410SearchBarImplj1jLAyQ(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x03a9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03a9:
            r25 = r8
            r4 = r17
            r5 = r19
            r6 = r20
            r7 = r21
            r8 = r22
            r9 = r23
        L_0x03b7:
            androidx.compose.runtime.ScopeUpdateScope r13 = r25.endRestartGroup()
            if (r13 == 0) goto L_0x03cf
            androidx.compose.material3.SearchBar_androidKt$SearchBar$3 r0 = new androidx.compose.material3.SearchBar_androidKt$SearchBar$3
            r1 = r29
            r3 = r31
            r10 = r38
            r11 = r40
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x03cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBar_androidKt.m2409SearchBarY92LkZI(kotlin.jvm.functions.Function2, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SearchBarColors, float, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0117  */
    /* renamed from: DockedSearchBar-EQC0FA8  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2406DockedSearchBarEQC0FA8(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, boolean r27, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r28, androidx.compose.ui.Modifier r29, androidx.compose.ui.graphics.Shape r30, androidx.compose.material3.SearchBarColors r31, float r32, float r33, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, androidx.compose.runtime.Composer r35, int r36, int r37) {
        /*
            r1 = r26
            r2 = r27
            r3 = r28
            r9 = r34
            r10 = r36
            r11 = r37
            r0 = 1209217899(0x4813336b, float:150733.67)
            r4 = r35
            androidx.compose.runtime.Composer r4 = r4.startRestartGroup(r0)
            java.lang.String r5 = "C(DockedSearchBar)P(3,2,5,4,7!1,8:c#ui.unit.Dp,6:c#ui.unit.Dp)287@13410L11,288@13471L8,296@13752L38,300@13946L831,293@13658L1119,325@14815L27,325@14783L59:SearchBar.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r5)
            r5 = r11 & 1
            if (r5 == 0) goto L_0x0021
            r5 = r10 | 6
            goto L_0x0031
        L_0x0021:
            r5 = r10 & 6
            if (r5 != 0) goto L_0x0030
            boolean r5 = r4.changedInstance(r1)
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
            boolean r6 = r4.changed((boolean) r2)
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
            boolean r6 = r4.changedInstance(r3)
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
            r8 = r10 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x0079
            r8 = r29
            boolean r12 = r4.changed((java.lang.Object) r8)
            if (r12 == 0) goto L_0x0075
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x0077
        L_0x0075:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x0077:
            r5 = r5 | r12
            goto L_0x007b
        L_0x0079:
            r8 = r29
        L_0x007b:
            r12 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x0094
            r12 = r11 & 16
            if (r12 != 0) goto L_0x008e
            r12 = r30
            boolean r13 = r4.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x0090
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0092
        L_0x008e:
            r12 = r30
        L_0x0090:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0092:
            r5 = r5 | r13
            goto L_0x0096
        L_0x0094:
            r12 = r30
        L_0x0096:
            r13 = 196608(0x30000, float:2.75506E-40)
            r13 = r13 & r10
            if (r13 != 0) goto L_0x00b0
            r13 = r11 & 32
            if (r13 != 0) goto L_0x00aa
            r13 = r31
            boolean r14 = r4.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x00ac
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ae
        L_0x00aa:
            r13 = r31
        L_0x00ac:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00ae:
            r5 = r5 | r14
            goto L_0x00b2
        L_0x00b0:
            r13 = r31
        L_0x00b2:
            r20 = r11 & 64
            r14 = 1572864(0x180000, float:2.204052E-39)
            if (r20 == 0) goto L_0x00ba
            r5 = r5 | r14
            goto L_0x00cc
        L_0x00ba:
            r14 = r14 & r10
            if (r14 != 0) goto L_0x00cc
            r14 = r32
            boolean r15 = r4.changed((float) r14)
            if (r15 == 0) goto L_0x00c8
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ca
        L_0x00c8:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00ca:
            r5 = r5 | r15
            goto L_0x00ce
        L_0x00cc:
            r14 = r32
        L_0x00ce:
            r15 = r11 & 128(0x80, float:1.794E-43)
            r21 = 12582912(0xc00000, float:1.7632415E-38)
            if (r15 == 0) goto L_0x00d9
            r5 = r5 | r21
            r7 = r33
            goto L_0x00ec
        L_0x00d9:
            r16 = r10 & r21
            r7 = r33
            if (r16 != 0) goto L_0x00ec
            boolean r16 = r4.changed((float) r7)
            if (r16 == 0) goto L_0x00e8
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ea
        L_0x00e8:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ea:
            r5 = r5 | r16
        L_0x00ec:
            r0 = r11 & 256(0x100, float:3.59E-43)
            r16 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x00f5
            r5 = r5 | r16
            goto L_0x0105
        L_0x00f5:
            r0 = r10 & r16
            if (r0 != 0) goto L_0x0105
            boolean r0 = r4.changedInstance(r9)
            if (r0 == 0) goto L_0x0102
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0104
        L_0x0102:
            r0 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0104:
            r5 = r5 | r0
        L_0x0105:
            r0 = 38347923(0x2492493, float:1.4777644E-37)
            r0 = r0 & r5
            r16 = r5
            r5 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r5) goto L_0x0123
            boolean r0 = r4.getSkipping()
            if (r0 != 0) goto L_0x0117
            goto L_0x0123
        L_0x0117:
            r4.skipToGroupEnd()
            r5 = r14
            r14 = r4
            r4 = r8
            r8 = r7
            r7 = r5
            r5 = r12
            r6 = r13
            goto L_0x0257
        L_0x0123:
            r4.startDefaults()
            r0 = r10 & 1
            r5 = -458753(0xfffffffffff8ffff, float:NaN)
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x0153
            boolean r0 = r4.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0137
            goto L_0x0153
        L_0x0137:
            r4.skipToGroupEnd()
            r0 = r11 & 16
            if (r0 == 0) goto L_0x0142
            r0 = r16 & r17
            r16 = r0
        L_0x0142:
            r0 = r11 & 32
            if (r0 == 0) goto L_0x0148
            r16 = r16 & r5
        L_0x0148:
            r19 = r7
            r0 = r13
            r18 = r14
            r14 = r4
            r13 = r12
        L_0x014f:
            r4 = r16
            goto L_0x01b0
        L_0x0153:
            if (r6 == 0) goto L_0x015a
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r8 = r0
        L_0x015a:
            r0 = r11 & 16
            if (r0 == 0) goto L_0x0168
            androidx.compose.material3.SearchBarDefaults r0 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            r6 = 6
            androidx.compose.ui.graphics.Shape r0 = r0.getDockedShape(r4, r6)
            r6 = r16 & r17
            goto L_0x016b
        L_0x0168:
            r0 = r12
            r6 = r16
        L_0x016b:
            r12 = r11 & 32
            if (r12 == 0) goto L_0x018b
            androidx.compose.material3.SearchBarDefaults r12 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            r18 = 384(0x180, float:5.38E-43)
            r19 = 3
            r13 = 0
            r17 = r15
            r15 = 0
            r25 = r17
            r17 = r4
            r4 = r25
            androidx.compose.material3.SearchBarColors r12 = r12.m2399colorsdgg9oW8(r13, r15, r17, r18, r19)
            r14 = r17
            r5 = r5 & r6
            r16 = r5
            goto L_0x0190
        L_0x018b:
            r14 = r4
            r4 = r15
            r16 = r6
            r12 = r13
        L_0x0190:
            if (r20 == 0) goto L_0x0199
            androidx.compose.material3.SearchBarDefaults r5 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            float r5 = r5.m2403getTonalElevationD9Ej5fM()
            goto L_0x019b
        L_0x0199:
            r5 = r32
        L_0x019b:
            if (r4 == 0) goto L_0x01a9
            androidx.compose.material3.SearchBarDefaults r4 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            float r4 = r4.m2402getShadowElevationD9Ej5fM()
            r13 = r0
            r19 = r4
            r18 = r5
            goto L_0x01ae
        L_0x01a9:
            r13 = r0
            r18 = r5
            r19 = r7
        L_0x01ae:
            r0 = r12
            goto L_0x014f
        L_0x01b0:
            r14.endDefaults()
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x01c2
            r5 = -1
            java.lang.String r6 = "androidx.compose.material3.DockedSearchBar (SearchBar.android.kt:292)"
            r7 = 1209217899(0x4813336b, float:150733.67)
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r4, r5, r6)
        L_0x01c2:
            long r5 = r0.m2395getContainerColor0d7_KjU()
            r29 = r5
            long r5 = r0.m2395getContainerColor0d7_KjU()
            r7 = 0
            long r16 = androidx.compose.material3.ColorSchemeKt.m1886contentColorForek8zF_U(r5, r14, r7)
            r5 = 1065353216(0x3f800000, float:1.0)
            androidx.compose.ui.Modifier r5 = androidx.compose.ui.ZIndexModifierKt.zIndex(r8, r5)
            float r6 = SearchBarMinWidth
            androidx.compose.ui.Modifier r12 = androidx.compose.foundation.layout.SizeKt.m850width3ABfNKs(r5, r6)
            androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$1 r5 = new androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$1
            r5.<init>(r1, r2, r0, r9)
            r6 = 54
            r15 = 878471280(0x345c6870, float:2.0527091E-7)
            r7 = 1
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r15, r7, r5, r14, r6)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            int r6 = r4 >> 9
            r6 = r6 & 112(0x70, float:1.57E-43)
            r6 = r6 | r21
            int r15 = r4 >> 6
            r20 = 57344(0xe000, float:8.0356E-41)
            r20 = r15 & r20
            r6 = r6 | r20
            r20 = 458752(0x70000, float:6.42848E-40)
            r15 = r15 & r20
            r23 = r6 | r15
            r24 = 64
            r20 = 0
            r21 = r5
            r22 = r14
            r14 = r29
            androidx.compose.material3.SurfaceKt.m2536SurfaceT9BRK9s(r12, r13, r14, r16, r18, r19, r20, r21, r22, r23, r24)
            r14 = r22
            r5 = -994322031(0xffffffffc4bbd991, float:-1502.799)
            java.lang.String r6 = "CC(remember):SearchBar.android.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r5, r6)
            r5 = r4 & 896(0x380, float:1.256E-42)
            r6 = 256(0x100, float:3.59E-43)
            if (r5 != r6) goto L_0x0221
            goto L_0x0222
        L_0x0221:
            r7 = 0
        L_0x0222:
            java.lang.Object r5 = r14.rememberedValue()
            if (r7 != 0) goto L_0x0230
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r5 != r6) goto L_0x023a
        L_0x0230:
            androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$2$1 r5 = new androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$2$1
            r5.<init>(r3)
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r14.updateRememberedValue(r5)
        L_0x023a:
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            int r4 = r4 >> 3
            r4 = r4 & 14
            r6 = 0
            androidx.activity.compose.BackHandlerKt.BackHandler(r2, r5, r14, r4, r6)
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0250
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0250:
            r6 = r0
            r4 = r8
            r5 = r13
            r7 = r18
            r8 = r19
        L_0x0257:
            androidx.compose.runtime.ScopeUpdateScope r12 = r14.endRestartGroup()
            if (r12 == 0) goto L_0x0267
            androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$3 r0 = new androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$3
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x0267:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBar_androidKt.m2406DockedSearchBarEQC0FA8(kotlin.jvm.functions.Function2, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SearchBarColors, float, float, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0250  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x03b8  */
    /* JADX WARNING: Removed duplicated region for block: B:247:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x012c  */
    @kotlin.Deprecated(message = "Use overload which takes inputField as a parameter", replaceWith = @kotlin.ReplaceWith(expression = "SearchBar(\n    inputField = {\n        SearchBarDefaults.InputField(\n            query = query,\n            onQueryChange = onQueryChange,\n            onSearch = onSearch,\n            expanded = active,\n            onExpandedChange = onActiveChange,\n            enabled = enabled,\n            placeholder = placeholder,\n            leadingIcon = leadingIcon,\n            trailingIcon = trailingIcon,\n            colors = colors.inputFieldColors,\n            interactionSource = interactionSource,\n        )\n    },\n    expanded = active,\n    onExpandedChange = onActiveChange,\n    modifier = modifier,\n    shape = shape,\n    colors = colors,\n    tonalElevation = tonalElevation,\n    shadowElevation = shadowElevation,\n    windowInsets = windowInsets,\n    content = content,\n)", imports = {}))
    /* renamed from: SearchBar-WuY5d9Q  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2408SearchBarWuY5d9Q(java.lang.String r35, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r36, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r37, boolean r38, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r39, androidx.compose.ui.Modifier r40, boolean r41, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, androidx.compose.ui.graphics.Shape r45, androidx.compose.material3.SearchBarColors r46, float r47, float r48, androidx.compose.foundation.layout.WindowInsets r49, androidx.compose.foundation.interaction.MutableInteractionSource r50, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, androidx.compose.runtime.Composer r52, int r53, int r54, int r55) {
        /*
            r0 = r53
            r1 = r54
            r2 = r55
            r3 = 1001512593(0x3bb1de91, float:0.0054281433)
            r4 = r52
            androidx.compose.runtime.Composer r14 = r4.startRestartGroup(r3)
            java.lang.String r4 = "C(SearchBar)P(11,8,9!1,7,6,3,10,5,15,13!1,14:c#ui.unit.Dp,12:c#ui.unit.Dp,16,4)737@34012L15,738@34077L8,741@34258L12,746@34418L591,745@34386L925:SearchBar.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r4)
            r4 = r2 & 1
            if (r4 == 0) goto L_0x001d
            r4 = r0 | 6
            r12 = r35
            goto L_0x002f
        L_0x001d:
            r4 = r0 & 6
            r12 = r35
            if (r4 != 0) goto L_0x002e
            boolean r4 = r14.changed((java.lang.Object) r12)
            if (r4 == 0) goto L_0x002b
            r4 = 4
            goto L_0x002c
        L_0x002b:
            r4 = 2
        L_0x002c:
            r4 = r4 | r0
            goto L_0x002f
        L_0x002e:
            r4 = r0
        L_0x002f:
            r7 = r2 & 2
            if (r7 == 0) goto L_0x0038
            r4 = r4 | 48
            r13 = r36
            goto L_0x004a
        L_0x0038:
            r7 = r0 & 48
            r13 = r36
            if (r7 != 0) goto L_0x004a
            boolean r7 = r14.changedInstance(r13)
            if (r7 == 0) goto L_0x0047
            r7 = 32
            goto L_0x0049
        L_0x0047:
            r7 = 16
        L_0x0049:
            r4 = r4 | r7
        L_0x004a:
            r7 = r2 & 4
            if (r7 == 0) goto L_0x0053
            r4 = r4 | 384(0x180, float:5.38E-43)
            r15 = r37
            goto L_0x0065
        L_0x0053:
            r7 = r0 & 384(0x180, float:5.38E-43)
            r15 = r37
            if (r7 != 0) goto L_0x0065
            boolean r7 = r14.changedInstance(r15)
            if (r7 == 0) goto L_0x0062
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r4 = r4 | r7
        L_0x0065:
            r7 = r2 & 8
            r16 = 2048(0x800, float:2.87E-42)
            r17 = 1024(0x400, float:1.435E-42)
            if (r7 == 0) goto L_0x0070
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0084
        L_0x0070:
            r7 = r0 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x0084
            r7 = r38
            boolean r18 = r14.changed((boolean) r7)
            if (r18 == 0) goto L_0x007f
            r18 = r16
            goto L_0x0081
        L_0x007f:
            r18 = r17
        L_0x0081:
            r4 = r4 | r18
            goto L_0x0086
        L_0x0084:
            r7 = r38
        L_0x0086:
            r18 = r2 & 16
            r19 = 8192(0x2000, float:1.14794E-41)
            r20 = 16384(0x4000, float:2.2959E-41)
            if (r18 == 0) goto L_0x0091
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a5
        L_0x0091:
            r5 = r0 & 24576(0x6000, float:3.4438E-41)
            if (r5 != 0) goto L_0x00a5
            r5 = r39
            boolean r18 = r14.changedInstance(r5)
            if (r18 == 0) goto L_0x00a0
            r18 = r20
            goto L_0x00a2
        L_0x00a0:
            r18 = r19
        L_0x00a2:
            r4 = r4 | r18
            goto L_0x00a7
        L_0x00a5:
            r5 = r39
        L_0x00a7:
            r18 = r2 & 32
            r21 = 131072(0x20000, float:1.83671E-40)
            r22 = 65536(0x10000, float:9.18355E-41)
            r23 = 196608(0x30000, float:2.75506E-40)
            if (r18 == 0) goto L_0x00b6
            r4 = r4 | r23
            r6 = r40
            goto L_0x00c9
        L_0x00b6:
            r24 = r0 & r23
            r6 = r40
            if (r24 != 0) goto L_0x00c9
            boolean r25 = r14.changed((java.lang.Object) r6)
            if (r25 == 0) goto L_0x00c5
            r25 = r21
            goto L_0x00c7
        L_0x00c5:
            r25 = r22
        L_0x00c7:
            r4 = r4 | r25
        L_0x00c9:
            r25 = r2 & 64
            r26 = 1572864(0x180000, float:2.204052E-39)
            if (r25 == 0) goto L_0x00d4
            r4 = r4 | r26
            r8 = r41
            goto L_0x00e7
        L_0x00d4:
            r27 = r0 & r26
            r8 = r41
            if (r27 != 0) goto L_0x00e7
            boolean r28 = r14.changed((boolean) r8)
            if (r28 == 0) goto L_0x00e3
            r28 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e5
        L_0x00e3:
            r28 = 524288(0x80000, float:7.34684E-40)
        L_0x00e5:
            r4 = r4 | r28
        L_0x00e7:
            r9 = r2 & 128(0x80, float:1.794E-43)
            r29 = 12582912(0xc00000, float:1.7632415E-38)
            if (r9 == 0) goto L_0x00f2
            r4 = r4 | r29
            r10 = r42
            goto L_0x0105
        L_0x00f2:
            r29 = r0 & r29
            r10 = r42
            if (r29 != 0) goto L_0x0105
            boolean r30 = r14.changedInstance(r10)
            if (r30 == 0) goto L_0x0101
            r30 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0103
        L_0x0101:
            r30 = 4194304(0x400000, float:5.877472E-39)
        L_0x0103:
            r4 = r4 | r30
        L_0x0105:
            r11 = r2 & 256(0x100, float:3.59E-43)
            r31 = 100663296(0x6000000, float:2.4074124E-35)
            if (r11 == 0) goto L_0x0110
            r4 = r4 | r31
            r3 = r43
            goto L_0x0123
        L_0x0110:
            r31 = r0 & r31
            r3 = r43
            if (r31 != 0) goto L_0x0123
            boolean r32 = r14.changedInstance(r3)
            if (r32 == 0) goto L_0x011f
            r32 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0121
        L_0x011f:
            r32 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0121:
            r4 = r4 | r32
        L_0x0123:
            r0 = r2 & 512(0x200, float:7.175E-43)
            r32 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x012c
            r4 = r4 | r32
            goto L_0x0142
        L_0x012c:
            r32 = r53 & r32
            if (r32 != 0) goto L_0x0142
            r32 = r0
            r0 = r44
            boolean r33 = r14.changedInstance(r0)
            if (r33 == 0) goto L_0x013d
            r33 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x013f
        L_0x013d:
            r33 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x013f:
            r4 = r4 | r33
            goto L_0x0146
        L_0x0142:
            r32 = r0
            r0 = r44
        L_0x0146:
            r33 = r1 & 6
            if (r33 != 0) goto L_0x0160
            r0 = r2 & 1024(0x400, float:1.435E-42)
            if (r0 != 0) goto L_0x0159
            r0 = r45
            boolean r33 = r14.changed((java.lang.Object) r0)
            if (r33 == 0) goto L_0x015b
            r24 = 4
            goto L_0x015d
        L_0x0159:
            r0 = r45
        L_0x015b:
            r24 = 2
        L_0x015d:
            r24 = r1 | r24
            goto L_0x0164
        L_0x0160:
            r0 = r45
            r24 = r1
        L_0x0164:
            r33 = r1 & 48
            if (r33 != 0) goto L_0x017e
            r0 = r2 & 2048(0x800, float:2.87E-42)
            if (r0 != 0) goto L_0x0177
            r0 = r46
            boolean r33 = r14.changed((java.lang.Object) r0)
            if (r33 == 0) goto L_0x0179
            r27 = 32
            goto L_0x017b
        L_0x0177:
            r0 = r46
        L_0x0179:
            r27 = 16
        L_0x017b:
            r24 = r24 | r27
            goto L_0x0180
        L_0x017e:
            r0 = r46
        L_0x0180:
            r0 = r24
            r5 = r2 & 4096(0x1000, float:5.74E-42)
            if (r5 == 0) goto L_0x0189
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x01a3
        L_0x0189:
            r24 = r0
            r0 = r1 & 384(0x180, float:5.38E-43)
            if (r0 != 0) goto L_0x019f
            r0 = r47
            boolean r27 = r14.changed((float) r0)
            if (r27 == 0) goto L_0x019a
            r29 = 256(0x100, float:3.59E-43)
            goto L_0x019c
        L_0x019a:
            r29 = 128(0x80, float:1.794E-43)
        L_0x019c:
            r24 = r24 | r29
            goto L_0x01a1
        L_0x019f:
            r0 = r47
        L_0x01a1:
            r0 = r24
        L_0x01a3:
            r24 = r5
            r5 = r2 & 8192(0x2000, float:1.14794E-41)
            if (r5 == 0) goto L_0x01ae
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            r27 = r0
            goto L_0x01c4
        L_0x01ae:
            r27 = r0
            r0 = r1 & 3072(0xc00, float:4.305E-42)
            if (r0 != 0) goto L_0x01c4
            r0 = r48
            boolean r28 = r14.changed((float) r0)
            if (r28 == 0) goto L_0x01bd
            goto L_0x01bf
        L_0x01bd:
            r16 = r17
        L_0x01bf:
            r16 = r27 | r16
            r27 = r16
            goto L_0x01c6
        L_0x01c4:
            r0 = r48
        L_0x01c6:
            r0 = r1 & 24576(0x6000, float:3.4438E-41)
            if (r0 != 0) goto L_0x01de
            r0 = r2 & 16384(0x4000, float:2.2959E-41)
            if (r0 != 0) goto L_0x01d9
            r0 = r49
            boolean r16 = r14.changed((java.lang.Object) r0)
            if (r16 == 0) goto L_0x01db
            r19 = r20
            goto L_0x01db
        L_0x01d9:
            r0 = r49
        L_0x01db:
            r27 = r27 | r19
            goto L_0x01e0
        L_0x01de:
            r0 = r49
        L_0x01e0:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r2 & r16
            if (r16 == 0) goto L_0x01ea
            r27 = r27 | r23
            goto L_0x01fe
        L_0x01ea:
            r17 = r1 & r23
            if (r17 != 0) goto L_0x01fe
            r17 = r5
            r5 = r50
            boolean r19 = r14.changed((java.lang.Object) r5)
            if (r19 == 0) goto L_0x01f9
            goto L_0x01fb
        L_0x01f9:
            r21 = r22
        L_0x01fb:
            r27 = r27 | r21
            goto L_0x0202
        L_0x01fe:
            r17 = r5
            r5 = r50
        L_0x0202:
            r19 = r2 & r22
            if (r19 == 0) goto L_0x020b
            r27 = r27 | r26
            r5 = r51
            goto L_0x021e
        L_0x020b:
            r19 = r1 & r26
            r5 = r51
            if (r19 != 0) goto L_0x021e
            boolean r19 = r14.changedInstance(r5)
            if (r19 == 0) goto L_0x021a
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x021c
        L_0x021a:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x021c:
            r27 = r27 | r19
        L_0x021e:
            r19 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r4 & r19
            r1 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r1) goto L_0x0250
            r0 = 599187(0x92493, float:8.3964E-40)
            r0 = r27 & r0
            r1 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r1) goto L_0x0250
            boolean r0 = r14.getSkipping()
            if (r0 != 0) goto L_0x0239
            goto L_0x0250
        L_0x0239:
            r14.skipToGroupEnd()
            r11 = r45
            r12 = r46
            r13 = r47
            r15 = r49
            r16 = r50
            r9 = r3
            r7 = r8
            r8 = r10
            r0 = r14
            r10 = r44
            r14 = r48
            goto L_0x03b2
        L_0x0250:
            r14.startDefaults()
            r0 = r53 & 1
            r1 = 6
            r5 = 1
            if (r0 == 0) goto L_0x0293
            boolean r0 = r14.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0260
            goto L_0x0293
        L_0x0260:
            r14.skipToGroupEnd()
            r0 = r2 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0269
            r27 = r27 & -15
        L_0x0269:
            r0 = r2 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x026f
            r27 = r27 & -113(0xffffffffffffff8f, float:NaN)
        L_0x026f:
            r0 = r2 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x0278
            r0 = -57345(0xffffffffffff1fff, float:NaN)
            r27 = r27 & r0
        L_0x0278:
            r25 = r44
            r16 = r46
            r11 = r48
            r12 = r49
            r26 = r50
            r24 = r3
            r7 = r6
            r22 = r8
            r23 = r10
            r9 = r14
            r0 = r27
            r8 = r45
            r10 = r47
            r14 = r4
            goto L_0x0331
        L_0x0293:
            if (r18 == 0) goto L_0x029a
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x029b
        L_0x029a:
            r0 = r6
        L_0x029b:
            if (r25 == 0) goto L_0x02a0
            r18 = r5
            goto L_0x02a2
        L_0x02a0:
            r18 = r8
        L_0x02a2:
            r19 = 0
            if (r9 == 0) goto L_0x02a9
            r20 = r19
            goto L_0x02ab
        L_0x02a9:
            r20 = r10
        L_0x02ab:
            if (r11 == 0) goto L_0x02af
            r3 = r19
        L_0x02af:
            if (r32 == 0) goto L_0x02b4
            r21 = r19
            goto L_0x02b6
        L_0x02b4:
            r21 = r44
        L_0x02b6:
            r6 = r2 & 1024(0x400, float:1.435E-42)
            if (r6 == 0) goto L_0x02c5
            androidx.compose.material3.SearchBarDefaults r6 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r6 = r6.getInputFieldShape(r14, r1)
            r27 = r27 & -15
            r22 = r6
            goto L_0x02c7
        L_0x02c5:
            r22 = r45
        L_0x02c7:
            r6 = r2 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x02e3
            r6 = r4
            androidx.compose.material3.SearchBarDefaults r4 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            r10 = 384(0x180, float:5.38E-43)
            r11 = 3
            r9 = r5
            r8 = r6
            r5 = 0
            r23 = r8
            r7 = 0
            r9 = r14
            r14 = r23
            androidx.compose.material3.SearchBarColors r4 = r4.m2399colorsdgg9oW8(r5, r7, r9, r10, r11)
            r27 = r27 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x02e7
        L_0x02e3:
            r9 = r14
            r14 = r4
            r4 = r46
        L_0x02e7:
            if (r24 == 0) goto L_0x02f0
            androidx.compose.material3.SearchBarDefaults r5 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            float r5 = r5.m2403getTonalElevationD9Ej5fM()
            goto L_0x02f2
        L_0x02f0:
            r5 = r47
        L_0x02f2:
            if (r17 == 0) goto L_0x02fb
            androidx.compose.material3.SearchBarDefaults r6 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            float r6 = r6.m2402getShadowElevationD9Ej5fM()
            goto L_0x02fd
        L_0x02fb:
            r6 = r48
        L_0x02fd:
            r7 = r2 & 16384(0x4000, float:2.2959E-41)
            if (r7 == 0) goto L_0x030f
            androidx.compose.material3.SearchBarDefaults r7 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r7 = r7.getWindowInsets(r9, r1)
            r8 = -57345(0xffffffffffff1fff, float:NaN)
            r8 = r27 & r8
            r27 = r8
            goto L_0x0311
        L_0x030f:
            r7 = r49
        L_0x0311:
            if (r16 == 0) goto L_0x031d
            r24 = r3
            r16 = r4
            r10 = r5
            r11 = r6
            r12 = r7
            r26 = r19
            goto L_0x0326
        L_0x031d:
            r26 = r50
            r24 = r3
            r16 = r4
            r10 = r5
            r11 = r6
            r12 = r7
        L_0x0326:
            r23 = r20
            r25 = r21
            r8 = r22
            r7 = r0
            r22 = r18
            r0 = r27
        L_0x0331:
            r9.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0342
            java.lang.String r3 = "androidx.compose.material3.SearchBar (SearchBar.android.kt:745)"
            r4 = 1001512593(0x3bb1de91, float:0.0054281433)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r14, r0, r3)
        L_0x0342:
            androidx.compose.material3.SearchBar_androidKt$SearchBar$4 r15 = new androidx.compose.material3.SearchBar_androidKt$SearchBar$4
            r17 = r35
            r19 = r37
            r20 = r38
            r21 = r39
            r18 = r13
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            r3 = 54
            r4 = -1158111311(0xffffffffbaf89fb1, float:-0.001896849)
            r5 = 1
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r4, r5, r15, r9, r3)
            r4 = r3
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            int r3 = r14 >> 6
            r5 = r3 & 112(0x70, float:1.57E-43)
            r1 = r1 | r5
            r5 = r3 & 896(0x380, float:1.256E-42)
            r1 = r1 | r5
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r3
            int r3 = r0 << 12
            r5 = 57344(0xe000, float:8.0356E-41)
            r5 = r5 & r3
            r1 = r1 | r5
            r5 = 458752(0x70000, float:6.42848E-40)
            r5 = r5 & r3
            r1 = r1 | r5
            r5 = 3670016(0x380000, float:5.142788E-39)
            r5 = r5 & r3
            r1 = r1 | r5
            r5 = 29360128(0x1c00000, float:7.052966E-38)
            r5 = r5 & r3
            r1 = r1 | r5
            r5 = 234881024(0xe000000, float:1.5777218E-30)
            r3 = r3 & r5
            r1 = r1 | r3
            int r0 = r0 << 9
            r3 = 1879048192(0x70000000, float:1.58456325E29)
            r0 = r0 & r3
            r15 = r1 | r0
            r14 = r9
            r9 = r16
            r16 = 0
            r5 = r38
            r6 = r39
            r13 = r51
            m2409SearchBarY92LkZI(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r16 = r9
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x03a0
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03a0:
            r6 = r7
            r13 = r10
            r15 = r12
            r0 = r14
            r12 = r16
            r7 = r22
            r9 = r24
            r10 = r25
            r16 = r26
            r14 = r11
            r11 = r8
            r8 = r23
        L_0x03b2:
            androidx.compose.runtime.ScopeUpdateScope r0 = r0.endRestartGroup()
            if (r0 == 0) goto L_0x03d9
            r1 = r0
            androidx.compose.material3.SearchBar_androidKt$SearchBar$5 r0 = new androidx.compose.material3.SearchBar_androidKt$SearchBar$5
            r3 = r37
            r4 = r38
            r5 = r39
            r17 = r51
            r18 = r53
            r19 = r54
            r34 = r1
            r20 = r2
            r1 = r35
            r2 = r36
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r34
            r1.updateScope(r0)
        L_0x03d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBar_androidKt.m2408SearchBarWuY5d9Q(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SearchBarColors, float, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x0384  */
    /* JADX WARNING: Removed duplicated region for block: B:230:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x012c  */
    @kotlin.Deprecated(message = "Use overload which takes inputField as a parameter", replaceWith = @kotlin.ReplaceWith(expression = "DockedSearchBar(\n    inputField = {\n        SearchBarDefaults.InputField(\n            query = query,\n            onQueryChange = onQueryChange,\n            onSearch = onSearch,\n            expanded = active,\n            onExpandedChange = onActiveChange,\n            enabled = enabled,\n            placeholder = placeholder,\n            leadingIcon = leadingIcon,\n            trailingIcon = trailingIcon,\n            colors = colors.inputFieldColors,\n            interactionSource = interactionSource,\n        )\n    },\n    expanded = active,\n    onExpandedChange = onActiveChange,\n    modifier = modifier,\n    shape = shape,\n    colors = colors,\n    tonalElevation = tonalElevation,\n    shadowElevation = shadowElevation,\n    content = content,\n)", imports = {}))
    /* renamed from: DockedSearchBar-eWTbjVg  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2407DockedSearchBareWTbjVg(java.lang.String r34, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r35, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r36, boolean r37, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r38, androidx.compose.ui.Modifier r39, boolean r40, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, androidx.compose.ui.graphics.Shape r44, androidx.compose.material3.SearchBarColors r45, float r46, float r47, androidx.compose.foundation.interaction.MutableInteractionSource r48, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, androidx.compose.runtime.Composer r50, int r51, int r52, int r53) {
        /*
            r0 = r51
            r1 = r52
            r2 = r53
            r3 = 1299054533(0x4d6dffc5, float:2.49560144E8)
            r4 = r50
            androidx.compose.runtime.Composer r13 = r4.startRestartGroup(r3)
            java.lang.String r4 = "C(DockedSearchBar)P(11,8,9!1,7,6,3,10,5,15,13!1,14:c#ui.unit.Dp,12:c#ui.unit.Dp,4)818@37222L11,819@37283L8,826@37565L591,825@37527L894:SearchBar.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r4)
            r4 = r2 & 1
            if (r4 == 0) goto L_0x001d
            r4 = r0 | 6
            r12 = r34
            goto L_0x002f
        L_0x001d:
            r4 = r0 & 6
            r12 = r34
            if (r4 != 0) goto L_0x002e
            boolean r4 = r13.changed((java.lang.Object) r12)
            if (r4 == 0) goto L_0x002b
            r4 = 4
            goto L_0x002c
        L_0x002b:
            r4 = 2
        L_0x002c:
            r4 = r4 | r0
            goto L_0x002f
        L_0x002e:
            r4 = r0
        L_0x002f:
            r7 = r2 & 2
            if (r7 == 0) goto L_0x0038
            r4 = r4 | 48
            r14 = r35
            goto L_0x004a
        L_0x0038:
            r7 = r0 & 48
            r14 = r35
            if (r7 != 0) goto L_0x004a
            boolean r7 = r13.changedInstance(r14)
            if (r7 == 0) goto L_0x0047
            r7 = 32
            goto L_0x0049
        L_0x0047:
            r7 = 16
        L_0x0049:
            r4 = r4 | r7
        L_0x004a:
            r7 = r2 & 4
            if (r7 == 0) goto L_0x0053
            r4 = r4 | 384(0x180, float:5.38E-43)
            r15 = r36
            goto L_0x0065
        L_0x0053:
            r7 = r0 & 384(0x180, float:5.38E-43)
            r15 = r36
            if (r7 != 0) goto L_0x0065
            boolean r7 = r13.changedInstance(r15)
            if (r7 == 0) goto L_0x0062
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r4 = r4 | r7
        L_0x0065:
            r7 = r2 & 8
            r16 = 2048(0x800, float:2.87E-42)
            r17 = 1024(0x400, float:1.435E-42)
            if (r7 == 0) goto L_0x0070
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0084
        L_0x0070:
            r7 = r0 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x0084
            r7 = r37
            boolean r18 = r13.changed((boolean) r7)
            if (r18 == 0) goto L_0x007f
            r18 = r16
            goto L_0x0081
        L_0x007f:
            r18 = r17
        L_0x0081:
            r4 = r4 | r18
            goto L_0x0086
        L_0x0084:
            r7 = r37
        L_0x0086:
            r18 = r2 & 16
            r19 = 16384(0x4000, float:2.2959E-41)
            r20 = 8192(0x2000, float:1.14794E-41)
            if (r18 == 0) goto L_0x0091
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a5
        L_0x0091:
            r5 = r0 & 24576(0x6000, float:3.4438E-41)
            if (r5 != 0) goto L_0x00a5
            r5 = r38
            boolean r18 = r13.changedInstance(r5)
            if (r18 == 0) goto L_0x00a0
            r18 = r19
            goto L_0x00a2
        L_0x00a0:
            r18 = r20
        L_0x00a2:
            r4 = r4 | r18
            goto L_0x00a7
        L_0x00a5:
            r5 = r38
        L_0x00a7:
            r18 = r2 & 32
            r21 = 131072(0x20000, float:1.83671E-40)
            r22 = 65536(0x10000, float:9.18355E-41)
            r23 = 196608(0x30000, float:2.75506E-40)
            if (r18 == 0) goto L_0x00b6
            r4 = r4 | r23
            r6 = r39
            goto L_0x00c9
        L_0x00b6:
            r24 = r0 & r23
            r6 = r39
            if (r24 != 0) goto L_0x00c9
            boolean r25 = r13.changed((java.lang.Object) r6)
            if (r25 == 0) goto L_0x00c5
            r25 = r21
            goto L_0x00c7
        L_0x00c5:
            r25 = r22
        L_0x00c7:
            r4 = r4 | r25
        L_0x00c9:
            r25 = r2 & 64
            r26 = 1572864(0x180000, float:2.204052E-39)
            if (r25 == 0) goto L_0x00d4
            r4 = r4 | r26
            r8 = r40
            goto L_0x00e7
        L_0x00d4:
            r26 = r0 & r26
            r8 = r40
            if (r26 != 0) goto L_0x00e7
            boolean r27 = r13.changed((boolean) r8)
            if (r27 == 0) goto L_0x00e3
            r27 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e5
        L_0x00e3:
            r27 = 524288(0x80000, float:7.34684E-40)
        L_0x00e5:
            r4 = r4 | r27
        L_0x00e7:
            r9 = r2 & 128(0x80, float:1.794E-43)
            r28 = 12582912(0xc00000, float:1.7632415E-38)
            if (r9 == 0) goto L_0x00f2
            r4 = r4 | r28
            r10 = r41
            goto L_0x0105
        L_0x00f2:
            r28 = r0 & r28
            r10 = r41
            if (r28 != 0) goto L_0x0105
            boolean r29 = r13.changedInstance(r10)
            if (r29 == 0) goto L_0x0101
            r29 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0103
        L_0x0101:
            r29 = 4194304(0x400000, float:5.877472E-39)
        L_0x0103:
            r4 = r4 | r29
        L_0x0105:
            r11 = r2 & 256(0x100, float:3.59E-43)
            r30 = 100663296(0x6000000, float:2.4074124E-35)
            if (r11 == 0) goto L_0x0110
            r4 = r4 | r30
            r3 = r42
            goto L_0x0123
        L_0x0110:
            r30 = r0 & r30
            r3 = r42
            if (r30 != 0) goto L_0x0123
            boolean r31 = r13.changedInstance(r3)
            if (r31 == 0) goto L_0x011f
            r31 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0121
        L_0x011f:
            r31 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0121:
            r4 = r4 | r31
        L_0x0123:
            r0 = r2 & 512(0x200, float:7.175E-43)
            r31 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x012c
            r4 = r4 | r31
            goto L_0x0142
        L_0x012c:
            r31 = r51 & r31
            if (r31 != 0) goto L_0x0142
            r31 = r0
            r0 = r43
            boolean r32 = r13.changedInstance(r0)
            if (r32 == 0) goto L_0x013d
            r32 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x013f
        L_0x013d:
            r32 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x013f:
            r4 = r4 | r32
            goto L_0x0146
        L_0x0142:
            r31 = r0
            r0 = r43
        L_0x0146:
            r32 = r1 & 6
            if (r32 != 0) goto L_0x0160
            r0 = r2 & 1024(0x400, float:1.435E-42)
            if (r0 != 0) goto L_0x0159
            r0 = r44
            boolean r32 = r13.changed((java.lang.Object) r0)
            if (r32 == 0) goto L_0x015b
            r24 = 4
            goto L_0x015d
        L_0x0159:
            r0 = r44
        L_0x015b:
            r24 = 2
        L_0x015d:
            r24 = r1 | r24
            goto L_0x0164
        L_0x0160:
            r0 = r44
            r24 = r1
        L_0x0164:
            r32 = r1 & 48
            if (r32 != 0) goto L_0x017e
            r0 = r2 & 2048(0x800, float:2.87E-42)
            if (r0 != 0) goto L_0x0177
            r0 = r45
            boolean r32 = r13.changed((java.lang.Object) r0)
            if (r32 == 0) goto L_0x0179
            r26 = 32
            goto L_0x017b
        L_0x0177:
            r0 = r45
        L_0x0179:
            r26 = 16
        L_0x017b:
            r24 = r24 | r26
            goto L_0x0180
        L_0x017e:
            r0 = r45
        L_0x0180:
            r0 = r24
            r5 = r2 & 4096(0x1000, float:5.74E-42)
            if (r5 == 0) goto L_0x0189
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x01a3
        L_0x0189:
            r24 = r0
            r0 = r1 & 384(0x180, float:5.38E-43)
            if (r0 != 0) goto L_0x019f
            r0 = r46
            boolean r26 = r13.changed((float) r0)
            if (r26 == 0) goto L_0x019a
            r28 = 256(0x100, float:3.59E-43)
            goto L_0x019c
        L_0x019a:
            r28 = 128(0x80, float:1.794E-43)
        L_0x019c:
            r24 = r24 | r28
            goto L_0x01a1
        L_0x019f:
            r0 = r46
        L_0x01a1:
            r0 = r24
        L_0x01a3:
            r24 = r5
            r5 = r2 & 8192(0x2000, float:1.14794E-41)
            if (r5 == 0) goto L_0x01ac
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x01c6
        L_0x01ac:
            r26 = r0
            r0 = r1 & 3072(0xc00, float:4.305E-42)
            if (r0 != 0) goto L_0x01c2
            r0 = r47
            boolean r27 = r13.changed((float) r0)
            if (r27 == 0) goto L_0x01bb
            goto L_0x01bd
        L_0x01bb:
            r16 = r17
        L_0x01bd:
            r16 = r26 | r16
            r0 = r16
            goto L_0x01c6
        L_0x01c2:
            r0 = r47
            r0 = r26
        L_0x01c6:
            r16 = r5
            r5 = r2 & 16384(0x4000, float:2.2959E-41)
            if (r5 == 0) goto L_0x01d1
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r17 = r0
            goto L_0x01e5
        L_0x01d1:
            r17 = r0
            r0 = r1 & 24576(0x6000, float:3.4438E-41)
            if (r0 != 0) goto L_0x01e5
            r0 = r48
            boolean r26 = r13.changed((java.lang.Object) r0)
            if (r26 == 0) goto L_0x01e0
            goto L_0x01e2
        L_0x01e0:
            r19 = r20
        L_0x01e2:
            r17 = r17 | r19
            goto L_0x01e7
        L_0x01e5:
            r0 = r48
        L_0x01e7:
            r19 = 32768(0x8000, float:4.5918E-41)
            r19 = r2 & r19
            if (r19 == 0) goto L_0x01f1
            r17 = r17 | r23
            goto L_0x0205
        L_0x01f1:
            r19 = r1 & r23
            if (r19 != 0) goto L_0x0205
            r19 = r5
            r5 = r49
            boolean r20 = r13.changedInstance(r5)
            if (r20 == 0) goto L_0x0200
            goto L_0x0202
        L_0x0200:
            r21 = r22
        L_0x0202:
            r17 = r17 | r21
            goto L_0x0209
        L_0x0205:
            r19 = r5
            r5 = r49
        L_0x0209:
            r20 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r4 & r20
            r1 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r1) goto L_0x0239
            r0 = 74899(0x12493, float:1.04956E-40)
            r0 = r17 & r0
            r1 = 74898(0x12492, float:1.04954E-40)
            if (r0 != r1) goto L_0x0239
            boolean r0 = r13.getSkipping()
            if (r0 != 0) goto L_0x0224
            goto L_0x0239
        L_0x0224:
            r13.skipToGroupEnd()
            r11 = r44
            r12 = r45
            r14 = r47
            r15 = r48
            r9 = r3
            r7 = r8
            r8 = r10
            r0 = r13
            r10 = r43
            r13 = r46
            goto L_0x037e
        L_0x0239:
            r13.startDefaults()
            r0 = r51 & 1
            r1 = 6
            r5 = 1
            if (r0 == 0) goto L_0x0274
            boolean r0 = r13.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0249
            goto L_0x0274
        L_0x0249:
            r13.skipToGroupEnd()
            r0 = r2 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0252
            r17 = r17 & -15
        L_0x0252:
            r0 = r2 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0258
            r17 = r17 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0258:
            r24 = r43
            r15 = r45
            r11 = r47
            r25 = r48
            r50 = r1
            r23 = r3
            r1 = r5
            r7 = r6
            r21 = r8
            r22 = r10
            r9 = r13
            r5 = r17
            r8 = r44
            r10 = r46
            r13 = r4
            goto L_0x0306
        L_0x0274:
            if (r18 == 0) goto L_0x027b
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x027c
        L_0x027b:
            r0 = r6
        L_0x027c:
            if (r25 == 0) goto L_0x0281
            r18 = r5
            goto L_0x0283
        L_0x0281:
            r18 = r8
        L_0x0283:
            r20 = 0
            if (r9 == 0) goto L_0x028a
            r21 = r20
            goto L_0x028c
        L_0x028a:
            r21 = r10
        L_0x028c:
            if (r11 == 0) goto L_0x0290
            r3 = r20
        L_0x0290:
            if (r31 == 0) goto L_0x0295
            r22 = r20
            goto L_0x0297
        L_0x0295:
            r22 = r43
        L_0x0297:
            r6 = r2 & 1024(0x400, float:1.435E-42)
            if (r6 == 0) goto L_0x02a8
            androidx.compose.material3.SearchBarDefaults r6 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r6 = r6.getDockedShape(r13, r1)
            r17 = r17 & -15
            r23 = r17
            r17 = r6
            goto L_0x02ac
        L_0x02a8:
            r23 = r17
            r17 = r44
        L_0x02ac:
            r6 = r2 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x02cb
            r6 = r4
            androidx.compose.material3.SearchBarDefaults r4 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            r10 = 384(0x180, float:5.38E-43)
            r11 = 3
            r9 = r5
            r8 = r6
            r5 = 0
            r25 = r8
            r7 = 0
            r50 = r1
            r1 = r9
            r9 = r13
            r13 = r25
            androidx.compose.material3.SearchBarColors r4 = r4.m2399colorsdgg9oW8(r5, r7, r9, r10, r11)
            r5 = r23 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x02d4
        L_0x02cb:
            r50 = r1
            r1 = r5
            r9 = r13
            r13 = r4
            r4 = r45
            r5 = r23
        L_0x02d4:
            if (r24 == 0) goto L_0x02dd
            androidx.compose.material3.SearchBarDefaults r6 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            float r6 = r6.m2403getTonalElevationD9Ej5fM()
            goto L_0x02df
        L_0x02dd:
            r6 = r46
        L_0x02df:
            if (r16 == 0) goto L_0x02e8
            androidx.compose.material3.SearchBarDefaults r7 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            float r7 = r7.m2402getShadowElevationD9Ej5fM()
            goto L_0x02ea
        L_0x02e8:
            r7 = r47
        L_0x02ea:
            if (r19 == 0) goto L_0x02f6
            r23 = r3
            r15 = r4
            r10 = r6
            r11 = r7
            r8 = r17
            r25 = r20
            goto L_0x02ff
        L_0x02f6:
            r25 = r48
            r23 = r3
            r15 = r4
            r10 = r6
            r11 = r7
            r8 = r17
        L_0x02ff:
            r24 = r22
            r7 = r0
            r22 = r21
            r21 = r18
        L_0x0306:
            r9.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0317
            java.lang.String r0 = "androidx.compose.material3.DockedSearchBar (SearchBar.android.kt:825)"
            r3 = 1299054533(0x4d6dffc5, float:2.49560144E8)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r13, r5, r0)
        L_0x0317:
            androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$4 r14 = new androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$4
            r17 = r35
            r18 = r36
            r19 = r37
            r20 = r38
            r16 = r12
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            r0 = 54
            r3 = -303118761(0xffffffffedeec657, float:-9.2371513E27)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r3, r1, r14, r9, r0)
            r4 = r0
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            int r0 = r13 >> 6
            r1 = r0 & 112(0x70, float:1.57E-43)
            r1 = r1 | 6
            r3 = r0 & 896(0x380, float:1.256E-42)
            r1 = r1 | r3
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r5 << 12
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r1
            r0 = r0 | r3
            r3 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r1
            r0 = r0 | r3
            r3 = 3670016(0x380000, float:5.142788E-39)
            r3 = r3 & r1
            r0 = r0 | r3
            r3 = 29360128(0x1c00000, float:7.052966E-38)
            r1 = r1 & r3
            r0 = r0 | r1
            int r1 = r5 << 9
            r3 = 234881024(0xe000000, float:1.5777218E-30)
            r1 = r1 & r3
            r14 = r0 | r1
            r13 = r9
            r9 = r15
            r15 = 0
            r5 = r37
            r6 = r38
            r12 = r49
            m2406DockedSearchBarEQC0FA8(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r15 = r9
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x036e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x036e:
            r6 = r7
            r14 = r11
            r0 = r13
            r12 = r15
            r7 = r21
            r9 = r23
            r15 = r25
            r11 = r8
            r13 = r10
            r8 = r22
            r10 = r24
        L_0x037e:
            androidx.compose.runtime.ScopeUpdateScope r0 = r0.endRestartGroup()
            if (r0 == 0) goto L_0x03a5
            r1 = r0
            androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$5 r0 = new androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$5
            r3 = r36
            r4 = r37
            r5 = r38
            r16 = r49
            r17 = r51
            r18 = r52
            r33 = r1
            r19 = r2
            r1 = r34
            r2 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r33
            r1.updateScope(r0)
        L_0x03a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBar_androidKt.m2407DockedSearchBareWTbjVg(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SearchBarColors, float, float, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x03ca  */
    /* JADX WARNING: Removed duplicated region for block: B:214:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0125  */
    /* renamed from: SearchBarImpl-j1jLAyQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2410SearchBarImplj1jLAyQ(androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r27, androidx.compose.runtime.MutableFloatState r28, androidx.compose.runtime.MutableState<androidx.activity.BackEventCompat> r29, androidx.compose.runtime.MutableState<androidx.activity.BackEventCompat> r30, androidx.compose.ui.Modifier r31, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.ui.graphics.Shape r33, androidx.compose.material3.SearchBarColors r34, float r35, float r36, androidx.compose.foundation.layout.WindowInsets r37, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, int r40, int r41, int r42) {
        /*
            r0 = r27
            r12 = r38
            r13 = r40
            r15 = r42
            r1 = -440333505(0xffffffffe5c10b3f, float:-1.1395302E23)
            r2 = r39
            androidx.compose.runtime.Composer r7 = r2.startRestartGroup(r1)
            java.lang.String r2 = "C(SearchBarImpl)P(!1,4,5,3,7,6,9!1,10:c#ui.unit.Dp,8:c#ui.unit.Dp,11)861@38824L15,862@38889L8,865@39070L12,868@39168L7,870@39228L15,871@39295L15,872@39341L101,876@39475L666,892@40180L333,903@40538L99,916@40970L362:SearchBar.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r2)
            r2 = r15 & 1
            if (r2 == 0) goto L_0x001d
            r2 = r13 | 6
            goto L_0x0036
        L_0x001d:
            r2 = r13 & 6
            if (r2 != 0) goto L_0x0035
            r2 = r13 & 8
            if (r2 != 0) goto L_0x002a
            boolean r2 = r7.changed((java.lang.Object) r0)
            goto L_0x002e
        L_0x002a:
            boolean r2 = r7.changedInstance(r0)
        L_0x002e:
            if (r2 == 0) goto L_0x0032
            r2 = 4
            goto L_0x0033
        L_0x0032:
            r2 = 2
        L_0x0033:
            r2 = r2 | r13
            goto L_0x0036
        L_0x0035:
            r2 = r13
        L_0x0036:
            r5 = r15 & 2
            if (r5 == 0) goto L_0x003f
            r2 = r2 | 48
            r10 = r28
            goto L_0x0051
        L_0x003f:
            r5 = r13 & 48
            r10 = r28
            if (r5 != 0) goto L_0x0051
            boolean r5 = r7.changed((java.lang.Object) r10)
            if (r5 == 0) goto L_0x004e
            r5 = 32
            goto L_0x0050
        L_0x004e:
            r5 = 16
        L_0x0050:
            r2 = r2 | r5
        L_0x0051:
            r5 = r15 & 4
            if (r5 == 0) goto L_0x005a
            r2 = r2 | 384(0x180, float:5.38E-43)
            r11 = r29
            goto L_0x006c
        L_0x005a:
            r5 = r13 & 384(0x180, float:5.38E-43)
            r11 = r29
            if (r5 != 0) goto L_0x006c
            boolean r5 = r7.changed((java.lang.Object) r11)
            if (r5 == 0) goto L_0x0069
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x006b
        L_0x0069:
            r5 = 128(0x80, float:1.794E-43)
        L_0x006b:
            r2 = r2 | r5
        L_0x006c:
            r5 = r15 & 8
            if (r5 == 0) goto L_0x0075
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r14 = r30
            goto L_0x0087
        L_0x0075:
            r5 = r13 & 3072(0xc00, float:4.305E-42)
            r14 = r30
            if (r5 != 0) goto L_0x0087
            boolean r5 = r7.changed((java.lang.Object) r14)
            if (r5 == 0) goto L_0x0084
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x0086
        L_0x0084:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x0086:
            r2 = r2 | r5
        L_0x0087:
            r5 = r15 & 16
            if (r5 == 0) goto L_0x008e
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a2
        L_0x008e:
            r9 = r13 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x00a2
            r9 = r31
            boolean r16 = r7.changed((java.lang.Object) r9)
            if (r16 == 0) goto L_0x009d
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009f
        L_0x009d:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x009f:
            r2 = r2 | r16
            goto L_0x00a4
        L_0x00a2:
            r9 = r31
        L_0x00a4:
            r16 = r15 & 32
            r17 = 196608(0x30000, float:2.75506E-40)
            if (r16 == 0) goto L_0x00af
            r2 = r2 | r17
            r1 = r32
            goto L_0x00c2
        L_0x00af:
            r16 = r13 & r17
            r1 = r32
            if (r16 != 0) goto L_0x00c2
            boolean r17 = r7.changedInstance(r1)
            if (r17 == 0) goto L_0x00be
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c0
        L_0x00be:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00c0:
            r2 = r2 | r17
        L_0x00c2:
            r17 = 1572864(0x180000, float:2.204052E-39)
            r18 = r13 & r17
            if (r18 != 0) goto L_0x00dc
            r18 = r15 & 64
            r3 = r33
            if (r18 != 0) goto L_0x00d7
            boolean r19 = r7.changed((java.lang.Object) r3)
            if (r19 == 0) goto L_0x00d7
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d9
        L_0x00d7:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x00d9:
            r2 = r2 | r19
            goto L_0x00de
        L_0x00dc:
            r3 = r33
        L_0x00de:
            r19 = 12582912(0xc00000, float:1.7632415E-38)
            r20 = r13 & r19
            if (r20 != 0) goto L_0x00fa
            r4 = r15 & 128(0x80, float:1.794E-43)
            if (r4 != 0) goto L_0x00f3
            r4 = r34
            boolean r21 = r7.changed((java.lang.Object) r4)
            if (r21 == 0) goto L_0x00f5
            r21 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f7
        L_0x00f3:
            r4 = r34
        L_0x00f5:
            r21 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f7:
            r2 = r2 | r21
            goto L_0x00fc
        L_0x00fa:
            r4 = r34
        L_0x00fc:
            r3 = r15 & 256(0x100, float:3.59E-43)
            r21 = 100663296(0x6000000, float:2.4074124E-35)
            if (r3 == 0) goto L_0x0105
            r2 = r2 | r21
            goto L_0x011b
        L_0x0105:
            r21 = r13 & r21
            if (r21 != 0) goto L_0x011b
            r21 = r3
            r3 = r35
            boolean r22 = r7.changed((float) r3)
            if (r22 == 0) goto L_0x0116
            r22 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0118
        L_0x0116:
            r22 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0118:
            r2 = r2 | r22
            goto L_0x011f
        L_0x011b:
            r21 = r3
            r3 = r35
        L_0x011f:
            r3 = r15 & 512(0x200, float:7.175E-43)
            r22 = 805306368(0x30000000, float:4.656613E-10)
            if (r3 == 0) goto L_0x0128
            r2 = r2 | r22
            goto L_0x013e
        L_0x0128:
            r22 = r13 & r22
            if (r22 != 0) goto L_0x013e
            r22 = r3
            r3 = r36
            boolean r23 = r7.changed((float) r3)
            if (r23 == 0) goto L_0x0139
            r23 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x013b
        L_0x0139:
            r23 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x013b:
            r2 = r2 | r23
            goto L_0x0142
        L_0x013e:
            r22 = r3
            r3 = r36
        L_0x0142:
            r23 = r41 & 6
            if (r23 != 0) goto L_0x015c
            r6 = r15 & 1024(0x400, float:1.435E-42)
            if (r6 != 0) goto L_0x0155
            r6 = r37
            boolean r24 = r7.changed((java.lang.Object) r6)
            if (r24 == 0) goto L_0x0157
            r20 = 4
            goto L_0x0159
        L_0x0155:
            r6 = r37
        L_0x0157:
            r20 = 2
        L_0x0159:
            r20 = r41 | r20
            goto L_0x0160
        L_0x015c:
            r6 = r37
            r20 = r41
        L_0x0160:
            r8 = r15 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x0167
            r20 = r20 | 48
            goto L_0x0178
        L_0x0167:
            r8 = r41 & 48
            if (r8 != 0) goto L_0x0178
            boolean r8 = r7.changedInstance(r12)
            if (r8 == 0) goto L_0x0174
            r23 = 32
            goto L_0x0176
        L_0x0174:
            r23 = 16
        L_0x0176:
            r20 = r20 | r23
        L_0x0178:
            r8 = 306783379(0x12492493, float:6.34695E-28)
            r8 = r8 & r2
            r1 = 306783378(0x12492492, float:6.3469493E-28)
            if (r8 != r1) goto L_0x019c
            r1 = r20 & 19
            r8 = 18
            if (r1 != r8) goto L_0x019c
            boolean r1 = r7.getSkipping()
            if (r1 != 0) goto L_0x018e
            goto L_0x019c
        L_0x018e:
            r7.skipToGroupEnd()
            r10 = r3
            r8 = r4
            r11 = r6
            r0 = r7
            r5 = r9
            r7 = r33
            r9 = r35
            goto L_0x03c4
        L_0x019c:
            r7.startDefaults()
            r1 = r13 & 1
            r8 = 6
            if (r1 == 0) goto L_0x01d1
            boolean r1 = r7.getDefaultsInvalid()
            if (r1 == 0) goto L_0x01ab
            goto L_0x01d1
        L_0x01ab:
            r7.skipToGroupEnd()
            r1 = r15 & 64
            if (r1 == 0) goto L_0x01b6
            r1 = -3670017(0xffffffffffc7ffff, float:NaN)
            r2 = r2 & r1
        L_0x01b6:
            r1 = r15 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x01be
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r2 = r2 & r1
        L_0x01be:
            r1 = r15 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x01c4
            r20 = r20 & -15
        L_0x01c4:
            r5 = r35
            r8 = r6
            r1 = r20
            r6 = r3
            r3 = r4
            r4 = r9
            r9 = r2
            r2 = r33
            goto L_0x024b
        L_0x01d1:
            if (r5 == 0) goto L_0x01d8
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x01d9
        L_0x01d8:
            r1 = r9
        L_0x01d9:
            r5 = r15 & 64
            if (r5 == 0) goto L_0x01ea
            androidx.compose.material3.SearchBarDefaults r5 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r5 = r5.getInputFieldShape(r7, r8)
            r9 = -3670017(0xffffffffffc7ffff, float:NaN)
            r2 = r2 & r9
            r23 = r5
            goto L_0x01ec
        L_0x01ea:
            r23 = r33
        L_0x01ec:
            r24 = r2
            r2 = r15 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x020d
            androidx.compose.material3.SearchBarDefaults r2 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            r4 = r8
            r8 = 384(0x180, float:5.38E-43)
            r9 = 3
            r5 = r4
            r3 = 0
            r25 = r5
            r5 = 0
            r31 = r1
            r1 = r25
            androidx.compose.material3.SearchBarColors r2 = r2.m2399colorsdgg9oW8(r3, r5, r7, r8, r9)
            r3 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = r24 & r3
            goto L_0x0213
        L_0x020d:
            r31 = r1
            r1 = r8
            r2 = r4
            r3 = r24
        L_0x0213:
            if (r21 == 0) goto L_0x021c
            androidx.compose.material3.SearchBarDefaults r4 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            float r4 = r4.m2403getTonalElevationD9Ej5fM()
            goto L_0x021e
        L_0x021c:
            r4 = r35
        L_0x021e:
            if (r22 == 0) goto L_0x0227
            androidx.compose.material3.SearchBarDefaults r5 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            float r5 = r5.m2402getShadowElevationD9Ej5fM()
            goto L_0x0229
        L_0x0227:
            r5 = r36
        L_0x0229:
            r6 = r15 & 1024(0x400, float:1.435E-42)
            if (r6 == 0) goto L_0x023f
            androidx.compose.material3.SearchBarDefaults r6 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r6 = r6.getWindowInsets(r7, r1)
            r20 = r20 & -15
            r9 = r3
            r8 = r6
            r1 = r20
            r3 = r2
            r6 = r5
            r2 = r23
            r5 = r4
            goto L_0x0249
        L_0x023f:
            r8 = r37
            r9 = r3
            r6 = r5
            r1 = r20
            r3 = r2
            r5 = r4
            r2 = r23
        L_0x0249:
            r4 = r31
        L_0x024b:
            r7.endDefaults()
            boolean r20 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r31 = r4
            if (r20 == 0) goto L_0x0261
            java.lang.String r4 = "androidx.compose.material3.SearchBarImpl (SearchBar.android.kt:867)"
            r33 = r8
            r8 = -440333505(0xffffffffe5c10b3f, float:-1.1395302E23)
            androidx.compose.runtime.ComposerKt.traceEventStart(r8, r9, r1, r4)
            goto L_0x0263
        L_0x0261:
            r33 = r8
        L_0x0263:
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            r16 = r1
            java.lang.String r1 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r8, r1)
            java.lang.Object r1 = r7.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            androidx.compose.material3.SearchBarDefaults r4 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            r8 = 6
            androidx.compose.ui.graphics.Shape r4 = r4.getInputFieldShape(r7, r8)
            androidx.compose.material3.SearchBarDefaults r10 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r8 = r10.getFullScreenShape(r7, r8)
            r10 = -1567245043(0xffffffffa295bd0d, float:-4.0586696E-18)
            r34 = r8
            java.lang.String r8 = "CC(remember):SearchBar.android.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r10, r8)
            java.lang.Object r10 = r7.rememberedValue()
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r20.getEmpty()
            if (r10 != r11) goto L_0x02b1
            androidx.compose.runtime.SnapshotMutationPolicy r10 = androidx.compose.runtime.SnapshotStateKt.structuralEqualityPolicy()
            androidx.compose.material3.SearchBar_androidKt$SearchBarImpl$useFullScreenShape$2$1 r11 = new androidx.compose.material3.SearchBar_androidKt$SearchBarImpl$useFullScreenShape$2$1
            r11.<init>(r0)
            kotlin.jvm.functions.Function0 r11 = (kotlin.jvm.functions.Function0) r11
            androidx.compose.runtime.State r10 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r10, r11)
            r7.updateRememberedValue(r10)
        L_0x02b1:
            androidx.compose.runtime.State r10 = (androidx.compose.runtime.State) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            boolean r11 = SearchBarImpl_j1jLAyQ$lambda$9(r10)
            r35 = r10
            r10 = -1567240190(0xffffffffa295d002, float:-4.0606768E-18)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r10, r8)
            boolean r10 = r7.changed((boolean) r11)
            r11 = 3670016(0x380000, float:5.142788E-39)
            r11 = r11 & r9
            r11 = r11 ^ r17
            r36 = r10
            r10 = 1048576(0x100000, float:1.469368E-39)
            if (r11 <= r10) goto L_0x02d7
            boolean r11 = r7.changed((java.lang.Object) r2)
            if (r11 != 0) goto L_0x02db
        L_0x02d7:
            r11 = r9 & r17
            if (r11 != r10) goto L_0x02dd
        L_0x02db:
            r10 = 1
            goto L_0x02de
        L_0x02dd:
            r10 = 0
        L_0x02de:
            r10 = r36 | r10
            java.lang.Object r11 = r7.rememberedValue()
            if (r10 != 0) goto L_0x02ee
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r11 != r10) goto L_0x0312
        L_0x02ee:
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x0304
            androidx.compose.foundation.shape.GenericShape r4 = new androidx.compose.foundation.shape.GenericShape
            androidx.compose.material3.SearchBar_androidKt$SearchBarImpl$animatedShape$1$1 r10 = new androidx.compose.material3.SearchBar_androidKt$SearchBarImpl$animatedShape$1$1
            r10.<init>(r1, r0)
            kotlin.jvm.functions.Function3 r10 = (kotlin.jvm.functions.Function3) r10
            r4.<init>(r10)
            r1 = r4
            androidx.compose.ui.graphics.Shape r1 = (androidx.compose.ui.graphics.Shape) r1
            goto L_0x030e
        L_0x0304:
            boolean r1 = SearchBarImpl_j1jLAyQ$lambda$9(r35)
            if (r1 == 0) goto L_0x030d
            r1 = r34
            goto L_0x030e
        L_0x030d:
            r1 = r2
        L_0x030e:
            r7.updateRememberedValue(r1)
            r11 = r1
        L_0x0312:
            androidx.compose.ui.graphics.Shape r11 = (androidx.compose.ui.graphics.Shape) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            androidx.compose.material3.SearchBar_androidKt$SearchBarImpl$surface$1 r1 = new androidx.compose.material3.SearchBar_androidKt$SearchBarImpl$surface$1
            r1.<init>(r11, r3, r5, r6)
            r4 = 54
            r10 = -170534294(0xfffffffff5d5da6a, float:-5.4218222E32)
            r11 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r10, r11, r1, r7, r4)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r4 = -1567206741(0xffffffffa29652ab, float:-4.074511E-18)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r4, r8)
            java.lang.Object r4 = r7.rememberedValue()
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r4 != r8) goto L_0x034c
            androidx.compose.runtime.SnapshotMutationPolicy r4 = androidx.compose.runtime.SnapshotStateKt.structuralEqualityPolicy()
            androidx.compose.material3.SearchBar_androidKt$SearchBarImpl$showContent$2$1 r8 = new androidx.compose.material3.SearchBar_androidKt$SearchBarImpl$showContent$2$1
            r8.<init>(r0)
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            androidx.compose.runtime.State r4 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r4, r8)
            r7.updateRememberedValue(r4)
        L_0x034c:
            androidx.compose.runtime.State r4 = (androidx.compose.runtime.State) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r8 = -1567201454(0xffffffffa2966752, float:-4.0766976E-18)
            r7.startReplaceGroup(r8)
            java.lang.String r8 = "908@40729L215"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r8)
            boolean r4 = SearchBarImpl_j1jLAyQ$lambda$12(r4)
            if (r4 == 0) goto L_0x0374
            androidx.compose.material3.SearchBar_androidKt$SearchBarImpl$wrappedContent$1 r4 = new androidx.compose.material3.SearchBar_androidKt$SearchBarImpl$wrappedContent$1
            r4.<init>(r0, r3, r12)
            r8 = 54
            r10 = 147843820(0x8cfeaec, float:1.2513589E-33)
            r11 = 1
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r10, r11, r4, r7, r8)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            goto L_0x0375
        L_0x0374:
            r4 = 0
        L_0x0375:
            r8 = r4
            r7.endReplaceGroup()
            int r4 = androidx.compose.animation.core.Animatable.$stable
            r4 = r4 | r19
            r10 = r9 & 14
            r4 = r4 | r10
            r10 = r9 & 112(0x70, float:1.57E-43)
            r4 = r4 | r10
            r10 = r9 & 896(0x380, float:1.256E-42)
            r4 = r4 | r10
            r10 = r9 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | r10
            r10 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r9
            r4 = r4 | r10
            int r10 = r16 << 15
            r11 = 458752(0x70000, float:6.42848E-40)
            r10 = r10 & r11
            r4 = r4 | r10
            int r9 = r9 << 3
            r10 = 3670016(0x380000, float:5.142788E-39)
            r9 = r9 & r10
            r10 = r4 | r9
            r4 = r31
            r23 = r2
            r11 = r3
            r16 = r6
            r9 = r7
            r3 = r14
            r2 = r29
            r6 = r32
            r7 = r1
            r14 = r5
            r1 = r28
            r5 = r33
            SearchBarLayout(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r7 = r9
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x03bb
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03bb:
            r0 = r7
            r8 = r11
            r9 = r14
            r10 = r16
            r7 = r23
            r11 = r5
            r5 = r4
        L_0x03c4:
            androidx.compose.runtime.ScopeUpdateScope r0 = r0.endRestartGroup()
            if (r0 == 0) goto L_0x03e5
            r1 = r0
            androidx.compose.material3.SearchBar_androidKt$SearchBarImpl$1 r0 = new androidx.compose.material3.SearchBar_androidKt$SearchBarImpl$1
            r2 = r28
            r3 = r29
            r4 = r30
            r6 = r32
            r14 = r41
            r26 = r1
            r1 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r26
            r1.updateScope(r0)
        L_0x03e5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBar_androidKt.m2410SearchBarImplj1jLAyQ(androidx.compose.animation.core.Animatable, androidx.compose.runtime.MutableFloatState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SearchBarColors, float, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void SearchBarLayout(Animatable<Float, AnimationVector1D> animatable, MutableFloatState mutableFloatState, MutableState<BackEventCompat> mutableState, MutableState<BackEventCompat> mutableState2, Modifier modifier, WindowInsets windowInsets, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Composer composer, int i) {
        int i2;
        MutableFloatState mutableFloatState2;
        MutableState<BackEventCompat> mutableState3;
        MutableState<BackEventCompat> mutableState4;
        int i3;
        Animatable<Float, AnimationVector1D> animatable2 = animatable;
        Modifier modifier2 = modifier;
        WindowInsets windowInsets2 = windowInsets;
        Function2<? super Composer, ? super Integer, Unit> function24 = function2;
        Function2<? super Composer, ? super Integer, Unit> function25 = function22;
        Function2<? super Composer, ? super Integer, Unit> function26 = function23;
        int i4 = i;
        Composer startRestartGroup = composer.startRestartGroup(70029564);
        ComposerKt.sourceInformation(startRestartGroup, "C(SearchBarLayout)P(!1,3,4,2,6,8,5,7)945@42029L34,950@42191L120,965@42827L5009,946@42068L5768:SearchBar.android.kt#uh7d8r");
        if ((i4 & 6) == 0) {
            i2 = ((i4 & 8) == 0 ? startRestartGroup.changed((Object) animatable2) : startRestartGroup.changedInstance(animatable2) ? 4 : 2) | i4;
        } else {
            i2 = i4;
        }
        if ((i4 & 48) == 0) {
            mutableFloatState2 = mutableFloatState;
            i2 |= startRestartGroup.changed((Object) mutableFloatState2) ? 32 : 16;
        } else {
            mutableFloatState2 = mutableFloatState;
        }
        if ((i4 & 384) == 0) {
            mutableState3 = mutableState;
            i2 |= startRestartGroup.changed((Object) mutableState3) ? 256 : 128;
        } else {
            mutableState3 = mutableState;
        }
        if ((i4 & 3072) == 0) {
            mutableState4 = mutableState2;
            i2 |= startRestartGroup.changed((Object) mutableState4) ? 2048 : 1024;
        } else {
            mutableState4 = mutableState2;
        }
        if ((i4 & 24576) == 0) {
            i2 |= startRestartGroup.changed((Object) modifier2) ? 16384 : 8192;
        }
        if ((196608 & i4) == 0) {
            i2 |= startRestartGroup.changed((Object) windowInsets2) ? 131072 : 65536;
        }
        if ((1572864 & i4) == 0) {
            i2 |= startRestartGroup.changedInstance(function24) ? 1048576 : 524288;
        }
        if ((12582912 & i4) == 0) {
            i2 |= startRestartGroup.changedInstance(function25) ? 8388608 : 4194304;
        }
        if ((100663296 & i4) == 0) {
            i2 |= startRestartGroup.changedInstance(function26) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((38347923 & i2) != 38347922 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(70029564, i2, -1, "androidx.compose.material3.SearchBarLayout (SearchBar.android.kt:941)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -660147884, "CC(remember):SearchBar.android.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new MutableWindowInsets((WindowInsets) null, 1, (DefaultConstructorMarker) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableWindowInsets mutableWindowInsets = (MutableWindowInsets) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier zIndex = ZIndexModifierKt.zIndex(modifier2, 1.0f);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -660142614, "CC(remember):SearchBar.android.kt#9igjgp");
            boolean z = (458752 & i2) == 131072;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new SearchBar_androidKt$SearchBarLayout$1$1(mutableWindowInsets, windowInsets2);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier consumeWindowInsets = WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(zIndex, (Function1) rememberedValue2), windowInsets2);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -660117373, "CC(remember):SearchBar.android.kt#9igjgp");
            boolean z2 = ((i2 & 14) == 4 || ((i2 & 8) != 0 && startRestartGroup.changedInstance(animatable2))) | ((i2 & 7168) == 2048) | ((i2 & 112) == 32) | ((i2 & 896) == 256);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                MutableState<BackEventCompat> mutableState5 = mutableState3;
                i3 = i2;
                rememberedValue3 = new SearchBar_androidKt$SearchBarLayout$2$1(animatable2, mutableWindowInsets, mutableState4, mutableFloatState2, mutableState5);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            } else {
                i3 = i2;
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, consumeWindowInsets);
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
            Composer r6 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r6, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r6, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r6.getInserting() || !Intrinsics.areEqual(r6.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r6.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r6, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 36789781, "C955@42396L85,956@42494L119:SearchBar.android.kt#uh7d8r");
            Modifier layoutId = LayoutIdKt.layoutId(Modifier.Companion, LayoutIdSurface);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, layoutId);
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
            Composer r0 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r0, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r0, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r0.getInserting() || !Intrinsics.areEqual(r0.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                r0.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                r0.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3682setimpl(r0, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1442016074, "C955@42470L9:SearchBar.android.kt#uh7d8r");
            function25.invoke(startRestartGroup, Integer.valueOf((i3 >> 21) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier layoutId2 = LayoutIdKt.layoutId(Modifier.Companion, LayoutIdInputField);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, layoutId2);
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
            Composer r02 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r02, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r02, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r02.getInserting() || !Intrinsics.areEqual(r02.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash3))) {
                r02.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                r02.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3682setimpl(r02, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1442132231, "C957@42587L12:SearchBar.android.kt#uh7d8r");
            function24.invoke(startRestartGroup, Integer.valueOf((i3 >> 18) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.startReplaceGroup(-1107184481);
            ComposerKt.sourceInformation(startRestartGroup, "*960@42668L127");
            if (function26 != null) {
                Modifier layoutId3 = LayoutIdKt.layoutId(Modifier.Companion, LayoutIdSearchContent);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, layoutId3);
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
                Composer r5 = Updater.m3675constructorimpl(startRestartGroup);
                Updater.m3682setimpl(r5, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3682setimpl(r5, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (r5.getInserting() || !Intrinsics.areEqual(r5.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash4))) {
                    r5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    r5.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m3682setimpl(r5, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1302856683, "C961@42768L9:SearchBar.android.kt#uh7d8r");
                function26.invoke(startRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            }
            startRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
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
            endRestartGroup.updateScope(new SearchBar_androidKt$SearchBarLayout$4(animatable, mutableFloatState, mutableState, mutableState2, modifier, windowInsets, function24, function25, function26, i4));
        }
    }

    /* access modifiers changed from: private */
    public static final float calculatePredictiveBackMultiplier(BackEventCompat backEventCompat, float f, float f2) {
        if (backEventCompat == null) {
            return 0.0f;
        }
        if (Float.isNaN(f2)) {
            return 1.0f;
        }
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        return f / f2;
    }

    /* access modifiers changed from: private */
    /* renamed from: calculatePredictiveBackOffsetX-rOvwMX4  reason: not valid java name */
    public static final int m2413calculatePredictiveBackOffsetXrOvwMX4(long j, int i, BackEventCompat backEventCompat, LayoutDirection layoutDirection, float f, float f2) {
        if (backEventCompat == null || f2 == 0.0f) {
            return 0;
        }
        int i2 = -1;
        int i3 = backEventCompat.getSwipeEdge() == 0 ? 1 : -1;
        if (layoutDirection == LayoutDirection.Ltr) {
            i2 = 1;
        }
        return MathKt.roundToInt(((((float) Constraints.m7052getMaxWidthimpl(j)) * SearchBarPredictiveBackMaxOffsetXRatio) - ((float) i)) * (((float) 1) - f) * f2 * ((float) i3) * ((float) i2));
    }

    /* access modifiers changed from: private */
    /* renamed from: calculatePredictiveBackOffsetY-dzo92Q0  reason: not valid java name */
    public static final int m2414calculatePredictiveBackOffsetYdzo92Q0(long j, int i, BackEventCompat backEventCompat, BackEventCompat backEventCompat2, int i2, int i3, float f) {
        if (backEventCompat2 == null || backEventCompat == null || f == 0.0f) {
            return 0;
        }
        int min = Math.min(Math.max(0, ((Constraints.m7051getMaxHeightimpl(j) - i2) / 2) - i), i3);
        float touchY = backEventCompat.getTouchY() - backEventCompat2.getTouchY();
        float abs = Math.abs(touchY) / ((float) Constraints.m7051getMaxHeightimpl(j));
        return MathKt.roundToInt(((float) MathHelpersKt.lerp(0, min, abs)) * f * Math.signum(touchY));
    }

    static {
        float f = (float) 8;
        SearchBarVerticalPadding = Dp.m7111constructorimpl(f);
        SearchBarPredictiveBackMinMargin = Dp.m7111constructorimpl(f);
        CubicBezierEasing easingEmphasizedDecelerateCubicBezier = MotionTokens.INSTANCE.getEasingEmphasizedDecelerateCubicBezier();
        AnimationEnterEasing = easingEmphasizedDecelerateCubicBezier;
        CubicBezierEasing cubicBezierEasing = new CubicBezierEasing(0.0f, 1.0f, 0.0f, 1.0f);
        AnimationExitEasing = cubicBezierEasing;
        FiniteAnimationSpec<Float> tween = AnimationSpecKt.tween(AnimationEnterDurationMillis, 100, easingEmphasizedDecelerateCubicBezier);
        AnimationEnterFloatSpec = tween;
        FiniteAnimationSpec<Float> tween2 = AnimationSpecKt.tween(AnimationExitDurationMillis, 100, cubicBezierEasing);
        AnimationExitFloatSpec = tween2;
        AnimationPredictiveBackExitFloatSpec = AnimationSpecKt.tween$default(AnimationExitDurationMillis, 0, cubicBezierEasing, 2, (Object) null);
        FiniteAnimationSpec<IntSize> tween3 = AnimationSpecKt.tween(AnimationEnterDurationMillis, 100, easingEmphasizedDecelerateCubicBezier);
        AnimationEnterSizeSpec = tween3;
        FiniteAnimationSpec<IntSize> tween4 = AnimationSpecKt.tween(AnimationExitDurationMillis, 100, cubicBezierEasing);
        AnimationExitSizeSpec = tween4;
        DockedEnterTransition = EnterExitTransitionKt.fadeIn$default(tween, 0.0f, 2, (Object) null).plus(EnterExitTransitionKt.expandVertically$default(tween3, (Alignment.Vertical) null, false, (Function1) null, 14, (Object) null));
        DockedExitTransition = EnterExitTransitionKt.fadeOut$default(tween2, 0.0f, 2, (Object) null).plus(EnterExitTransitionKt.shrinkVertically$default(tween4, (Alignment.Vertical) null, false, (Function1) null, 14, (Object) null));
    }

    public static final float getDockedExpandedTableMinHeight() {
        return DockedExpandedTableMinHeight;
    }

    public static final float getSearchBarMinWidth() {
        return SearchBarMinWidth;
    }

    public static final float getSearchBarVerticalPadding() {
        return SearchBarVerticalPadding;
    }

    private static final boolean SearchBarImpl_j1jLAyQ$lambda$9(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean SearchBarImpl_j1jLAyQ$lambda$12(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
