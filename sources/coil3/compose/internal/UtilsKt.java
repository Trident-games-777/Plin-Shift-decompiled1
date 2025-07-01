package coil3.compose.internal;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSizeKt;
import coil3.ImageLoader;
import coil3.compose.AsyncImageModelEqualityDelegate;
import coil3.compose.AsyncImagePainter;
import coil3.compose.ConstraintsSizeResolver;
import coil3.compose.ConstraintsSizeResolverKt;
import coil3.compose.LocalAsyncImageModelEqualityDelegateKt;
import coil3.request.ErrorResult;
import coil3.request.ImageRequest;
import coil3.request.NullRequestDataException;
import coil3.size.Dimension;
import coil3.size.DimensionKt;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.size.SizeResolver;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata(d1 = {"\u0000¢\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a2\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0001\u001aX\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0011\u0018\u00010\n2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0011\u0018\u00010\n2\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0011\u0018\u00010\n2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0011\u0018\u00010\nH\u0001\u001a\u001f\u0010\u0018\u001a\u00020\u00192\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0001¢\u0006\u0002\u0010\u001c\u001a\u0016\u0010\u001d\u001a\u00020\u001e*\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001fH\u0001\u001a\f\u0010 \u001a\u00020!*\u00020\u0007H\u0001\u001a\u0013\u0010\"\u001a\u00020#*\u00020$H\u0001¢\u0006\u0004\b%\u0010&\u001a\u0015\u0010'\u001a\u0004\u0018\u00010#*\u00020(H\u0001¢\u0006\u0004\b)\u0010&\u001a\f\u0010*\u001a\u00020+*\u00020,H\u0002\u001a\f\u0010*\u001a\u00020+*\u00020-H\u0002\u001a\u001b\u0010.\u001a\u00020-*\u00020$2\u0006\u0010/\u001a\u00020-H\u0000¢\u0006\u0004\b0\u00101\u001a\u001b\u00102\u001a\u00020-*\u00020$2\u0006\u00103\u001a\u00020-H\u0000¢\u0006\u0004\b4\u00101\u001a\u001b\u00105\u001a\u00020-*\u00020-2\f\u00106\u001a\b\u0012\u0004\u0012\u00020-07H\b\u001a\u0013\u00108\u001a\u000209*\u00020(H\u0000¢\u0006\u0004\b:\u0010;\"\u0018\u0010<\u001a\u00020=*\u00020(8@X\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?\"\u0014\u0010@\u001a\u00020AX\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010C¨\u0006D"}, d2 = {"requestOf", "Lcoil3/request/ImageRequest;", "model", "", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Lcoil3/request/ImageRequest;", "requestOfWithSizeResolver", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "(Ljava/lang/Object;Landroidx/compose/ui/layout/ContentScale;Landroidx/compose/runtime/Composer;I)Lcoil3/request/ImageRequest;", "transformOf", "Lkotlin/Function1;", "Lcoil3/compose/AsyncImagePainter$State;", "placeholder", "Landroidx/compose/ui/graphics/painter/Painter;", "error", "fallback", "onStateOf", "", "onLoading", "Lcoil3/compose/AsyncImagePainter$State$Loading;", "onSuccess", "Lcoil3/compose/AsyncImagePainter$State$Success;", "onError", "Lcoil3/compose/AsyncImagePainter$State$Error;", "AsyncImageState", "Lcoil3/compose/internal/AsyncImageState;", "imageLoader", "Lcoil3/ImageLoader;", "(Ljava/lang/Object;Lcoil3/ImageLoader;Landroidx/compose/runtime/Composer;I)Lcoil3/compose/internal/AsyncImageState;", "contentDescription", "Landroidx/compose/ui/Modifier;", "", "toScale", "Lcoil3/size/Scale;", "toSize", "Lcoil3/size/Size;", "Landroidx/compose/ui/unit/Constraints;", "toSize-BRTryo0", "(J)Lcoil3/size/Size;", "toSizeOrNull", "Landroidx/compose/ui/geometry/Size;", "toSizeOrNull-uvyYCjk", "toDimension", "Lcoil3/size/Dimension;", "", "", "constrainWidth", "width", "constrainWidth-K40F9xA", "(JF)F", "constrainHeight", "height", "constrainHeight-K40F9xA", "takeOrElse", "block", "Lkotlin/Function0;", "toIntSize", "Landroidx/compose/ui/unit/IntSize;", "toIntSize-uvyYCjk", "(J)J", "isPositive", "", "isPositive-uvyYCjk", "(J)Z", "safeImmediateMainDispatcher", "Lkotlin/coroutines/CoroutineContext;", "getSafeImmediateMainDispatcher", "()Lkotlin/coroutines/CoroutineContext;", "coil-compose-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: utils.kt */
public final class UtilsKt {
    private static final CoroutineContext safeImmediateMainDispatcher;

    public static final ImageRequest requestOf(Object obj, Composer composer, int i) {
        composer.startReplaceGroup(1319639034);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1319639034, i, -1, "coil3.compose.internal.requestOf (utils.kt:40)");
        }
        if (obj instanceof ImageRequest) {
            composer.startReplaceGroup(-72568693);
            ImageRequest imageRequest = (ImageRequest) obj;
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return imageRequest;
        }
        composer.startReplaceGroup(-72529447);
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) consume;
        boolean changed = composer.changed((Object) context) | composer.changed(obj);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new ImageRequest.Builder(context).data(obj).build();
            composer.updateRememberedValue(rememberedValue);
        }
        ImageRequest imageRequest2 = (ImageRequest) rememberedValue;
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return imageRequest2;
    }

    public static final ImageRequest requestOfWithSizeResolver(Object obj, ContentScale contentScale, Composer composer, int i) {
        SizeResolver sizeResolver;
        composer.startReplaceGroup(-329318062);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-329318062, i, -1, "coil3.compose.internal.requestOfWithSizeResolver (utils.kt:59)");
        }
        boolean z = obj instanceof ImageRequest;
        if (z) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (imageRequest.getDefined().getSizeResolver() != null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return imageRequest;
            }
        }
        if (Intrinsics.areEqual((Object) contentScale, (Object) ContentScale.Companion.getNone())) {
            composer.startReplaceGroup(-858559883);
            composer.endReplaceGroup();
            sizeResolver = SizeResolver.ORIGINAL;
        } else {
            composer.startReplaceGroup(-858516855);
            ConstraintsSizeResolver rememberConstraintsSizeResolver = ConstraintsSizeResolverKt.rememberConstraintsSizeResolver(composer, 0);
            composer.endReplaceGroup();
            sizeResolver = rememberConstraintsSizeResolver;
        }
        if (z) {
            composer.startReplaceGroup(-858432194);
            ImageRequest imageRequest2 = (ImageRequest) obj;
            boolean changed = composer.changed((Object) imageRequest2) | composer.changed((Object) sizeResolver);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = ImageRequest.newBuilder$default(imageRequest2, (Context) null, 1, (Object) null).size(sizeResolver).build();
                composer.updateRememberedValue(rememberedValue);
            }
            ImageRequest imageRequest3 = (ImageRequest) rememberedValue;
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return imageRequest3;
        }
        composer.startReplaceGroup(-858268390);
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) consume;
        boolean changed2 = composer.changed((Object) context) | composer.changed(obj) | composer.changed((Object) sizeResolver);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new ImageRequest.Builder(context).data(obj).size(sizeResolver).build();
            composer.updateRememberedValue(rememberedValue2);
        }
        ImageRequest imageRequest4 = (ImageRequest) rememberedValue2;
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return imageRequest4;
    }

    /* access modifiers changed from: private */
    public static final AsyncImagePainter.State transformOf$lambda$3(Painter painter, Painter painter2, Painter painter3, AsyncImagePainter.State state) {
        if (state instanceof AsyncImagePainter.State.Loading) {
            return painter != null ? ((AsyncImagePainter.State.Loading) state).copy(painter) : (AsyncImagePainter.State.Loading) state;
        } else if (!(state instanceof AsyncImagePainter.State.Error)) {
            return state;
        } else {
            AsyncImagePainter.State.Error error = (AsyncImagePainter.State.Error) state;
            if (error.getResult().getThrowable() instanceof NullRequestDataException) {
                if (painter2 != null) {
                    error = AsyncImagePainter.State.Error.copy$default(error, painter2, (ErrorResult) null, 2, (Object) null);
                }
            } else if (painter3 != null) {
                error = AsyncImagePainter.State.Error.copy$default(error, painter3, (ErrorResult) null, 2, (Object) null);
            }
            return error;
        }
    }

    public static final Function1<AsyncImagePainter.State, AsyncImagePainter.State> transformOf(Painter painter, Painter painter2, Painter painter3) {
        return (painter == null && painter2 == null && painter3 == null) ? AsyncImagePainter.Companion.getDefaultTransform() : new UtilsKt$$ExternalSyntheticLambda1(painter, painter3, painter2);
    }

    public static final Function1<AsyncImagePainter.State, Unit> onStateOf(Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function12, Function1<? super AsyncImagePainter.State.Error, Unit> function13) {
        if (function1 == null && function12 == null && function13 == null) {
            return null;
        }
        return new UtilsKt$$ExternalSyntheticLambda2(function1, function12, function13);
    }

    /* access modifiers changed from: private */
    public static final Unit onStateOf$lambda$4(Function1 function1, Function1 function12, Function1 function13, AsyncImagePainter.State state) {
        if (state instanceof AsyncImagePainter.State.Loading) {
            if (function1 != null) {
                function1.invoke(state);
            }
        } else if (state instanceof AsyncImagePainter.State.Success) {
            if (function12 != null) {
                function12.invoke(state);
            }
        } else if (state instanceof AsyncImagePainter.State.Error) {
            if (function13 != null) {
                function13.invoke(state);
            }
        } else if (!(state instanceof AsyncImagePainter.State.Empty)) {
            throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }

    public static final AsyncImageState AsyncImageState(Object obj, ImageLoader imageLoader, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1014878424, i, -1, "coil3.compose.internal.AsyncImageState (utils.kt:138)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(LocalAsyncImageModelEqualityDelegateKt.getLocalAsyncImageModelEqualityDelegate());
        ComposerKt.sourceInformationMarkerEnd(composer);
        AsyncImageState asyncImageState = new AsyncImageState(obj, (AsyncImageModelEqualityDelegate) consume, imageLoader);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return asyncImageState;
    }

    public static final Modifier contentDescription(Modifier modifier, String str) {
        return str != null ? SemanticsModifierKt.semantics$default(modifier, false, new UtilsKt$$ExternalSyntheticLambda0(str), 1, (Object) null) : modifier;
    }

    /* access modifiers changed from: private */
    public static final Unit contentDescription$lambda$5(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.m6386setRolekuIjeqM(semanticsPropertyReceiver, Role.Companion.m6370getImageo7Vup1c());
        return Unit.INSTANCE;
    }

    public static final Scale toScale(ContentScale contentScale) {
        if (Intrinsics.areEqual((Object) contentScale, (Object) ContentScale.Companion.getFit()) || Intrinsics.areEqual((Object) contentScale, (Object) ContentScale.Companion.getInside())) {
            return Scale.FIT;
        }
        return Scale.FILL;
    }

    /* renamed from: toSize-BRTryo0  reason: not valid java name */
    public static final Size m7497toSizeBRTryo0(long j) {
        return new Size(toDimension(Constraints.m7052getMaxWidthimpl(j)), toDimension(Constraints.m7051getMaxHeightimpl(j)));
    }

    /* renamed from: toSizeOrNull-uvyYCjk  reason: not valid java name */
    public static final Size m7498toSizeOrNulluvyYCjk(long j) {
        if (j == InlineClassHelperKt.UnspecifiedPackedFloats) {
            return Size.ORIGINAL;
        }
        if (m7495isPositiveuvyYCjk(j)) {
            return new Size(toDimension(androidx.compose.ui.geometry.Size.m4056getWidthimpl(j)), toDimension(androidx.compose.ui.geometry.Size.m4053getHeightimpl(j)));
        }
        return null;
    }

    private static final Dimension toDimension(int i) {
        return i != Integer.MAX_VALUE ? Dimension.Pixels.m7542boximpl(DimensionKt.Dimension(i)) : Dimension.Undefined.INSTANCE;
    }

    private static final Dimension toDimension(float f) {
        return (Float.isInfinite(f) || Float.isNaN(f)) ? Dimension.Undefined.INSTANCE : Dimension.Pixels.m7542boximpl(DimensionKt.Dimension(MathKt.roundToInt(f)));
    }

    /* renamed from: constrainWidth-K40F9xA  reason: not valid java name */
    public static final float m7494constrainWidthK40F9xA(long j, float f) {
        return RangesKt.coerceIn(f, (float) Constraints.m7054getMinWidthimpl(j), (float) Constraints.m7052getMaxWidthimpl(j));
    }

    /* renamed from: constrainHeight-K40F9xA  reason: not valid java name */
    public static final float m7493constrainHeightK40F9xA(long j, float f) {
        return RangesKt.coerceIn(f, (float) Constraints.m7053getMinHeightimpl(j), (float) Constraints.m7051getMaxHeightimpl(j));
    }

    public static final float takeOrElse(float f, Function0<Float> function0) {
        return (Float.isInfinite(f) || Float.isNaN(f)) ? function0.invoke().floatValue() : f;
    }

    /* renamed from: toIntSize-uvyYCjk  reason: not valid java name */
    public static final long m7496toIntSizeuvyYCjk(long j) {
        return IntSizeKt.IntSize(MathKt.roundToInt(androidx.compose.ui.geometry.Size.m4056getWidthimpl(j)), MathKt.roundToInt(androidx.compose.ui.geometry.Size.m4053getHeightimpl(j)));
    }

    /* renamed from: isPositive-uvyYCjk  reason: not valid java name */
    public static final boolean m7495isPositiveuvyYCjk(long j) {
        return ((double) androidx.compose.ui.geometry.Size.m4056getWidthimpl(j)) >= 0.5d && ((double) androidx.compose.ui.geometry.Size.m4053getHeightimpl(j)) >= 0.5d;
    }

    public static final CoroutineContext getSafeImmediateMainDispatcher() {
        return safeImmediateMainDispatcher;
    }

    static {
        CoroutineContext coroutineContext;
        try {
            MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
            immediate.isDispatchNeeded(EmptyCoroutineContext.INSTANCE);
            coroutineContext = immediate;
        } catch (Throwable unused) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        safeImmediateMainDispatcher = coroutineContext;
    }
}
