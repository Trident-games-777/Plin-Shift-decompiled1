package coil3.compose;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import coil3.ImageLoader;
import coil3.compose.AsyncImagePainter;
import coil3.compose.internal.AsyncImageState;
import coil3.compose.internal.ContentPainterElement;
import coil3.compose.internal.UtilsKt;
import coil3.request.ImageRequest;
import coil3.size.SizeResolver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aß\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0007¢\u0006\u0004\b!\u0010\"\u001a¡\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$0\u000f2\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0007¢\u0006\u0004\b&\u0010'\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010(\u001a\u00020)2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$0\u000f2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0003¢\u0006\u0004\b*\u0010+\u001aQ\u0010,\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010-\u001a\u00020.2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0003¢\u0006\u0002\u0010/¨\u00060"}, d2 = {"AsyncImage", "", "model", "", "contentDescription", "", "imageLoader", "Lcoil3/ImageLoader;", "modifier", "Landroidx/compose/ui/Modifier;", "placeholder", "Landroidx/compose/ui/graphics/painter/Painter;", "error", "fallback", "onLoading", "Lkotlin/Function1;", "Lcoil3/compose/AsyncImagePainter$State$Loading;", "onSuccess", "Lcoil3/compose/AsyncImagePainter$State$Success;", "onError", "Lcoil3/compose/AsyncImagePainter$State$Error;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "clipToBounds", "", "AsyncImage-nc27qi8", "(Ljava/lang/Object;Ljava/lang/String;Lcoil3/ImageLoader;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLandroidx/compose/runtime/Composer;III)V", "transform", "Lcoil3/compose/AsyncImagePainter$State;", "onState", "AsyncImage-sKDTAoQ", "(Ljava/lang/Object;Ljava/lang/String;Lcoil3/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLandroidx/compose/runtime/Composer;III)V", "state", "Lcoil3/compose/internal/AsyncImageState;", "AsyncImage-76YX9Dk", "(Lcoil3/compose/internal/AsyncImageState;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLandroidx/compose/runtime/Composer;II)V", "Content", "painter", "Lcoil3/compose/AsyncImagePainter;", "(Landroidx/compose/ui/Modifier;Lcoil3/compose/AsyncImagePainter;Ljava/lang/String;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ZLandroidx/compose/runtime/Composer;I)V", "coil-compose-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: AsyncImage.kt */
public final class AsyncImageKt {
    /* access modifiers changed from: private */
    public static final Unit AsyncImage_76YX9Dk$lambda$0(AsyncImageState asyncImageState, String str, Modifier modifier, Function1 function1, Function1 function12, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, int i2, int i3, Composer composer, int i4) {
        m7456AsyncImage76YX9Dk(asyncImageState, str, modifier, function1, function12, alignment, contentScale, f, colorFilter, i, z, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit Content$lambda$3(Modifier modifier, AsyncImagePainter asyncImagePainter, String str, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, int i, Composer composer, int i2) {
        Content(modifier, asyncImagePainter, str, alignment, contentScale, f, colorFilter, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* renamed from: AsyncImage-nc27qi8  reason: not valid java name */
    public static final void m7457AsyncImagenc27qi8(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Painter painter, Painter painter2, Painter painter3, Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function12, Function1<? super AsyncImagePainter.State.Error, Unit> function13, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, Composer composer, int i2, int i3, int i4) {
        boolean z2;
        int i5 = i2;
        int i6 = i3;
        int i7 = i4;
        Modifier modifier2 = (i7 & 8) != 0 ? Modifier.Companion : modifier;
        ColorFilter colorFilter2 = null;
        Painter painter4 = (i7 & 16) != 0 ? null : painter;
        Painter painter5 = (i7 & 32) != 0 ? null : painter2;
        Painter painter6 = (i7 & 64) != 0 ? painter5 : painter3;
        Function1<? super AsyncImagePainter.State.Loading, Unit> function14 = (i7 & 128) != 0 ? null : function1;
        Function1<? super AsyncImagePainter.State.Success, Unit> function15 = (i7 & 256) != 0 ? null : function12;
        Function1<? super AsyncImagePainter.State.Error, Unit> function16 = (i7 & 512) != 0 ? null : function13;
        Alignment center = (i7 & 1024) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i7 & 2048) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f2 = (i7 & 4096) != 0 ? 1.0f : f;
        if ((i7 & 8192) == 0) {
            colorFilter2 = colorFilter;
        }
        int r14 = (i7 & 16384) != 0 ? DrawScope.Companion.m4868getDefaultFilterQualityfv9h1I() : i;
        boolean z3 = (i7 & 32768) != 0 ? true : z;
        if (ComposerKt.isTraceInProgress()) {
            z2 = z3;
            ComposerKt.traceEventStart(-1128374444, i5, i6, "coil3.compose.AsyncImage (AsyncImage.kt:71)");
        } else {
            z2 = z3;
        }
        int i8 = i5 >> 3;
        Modifier modifier3 = modifier2;
        Composer composer2 = composer;
        AsyncImageState AsyncImageState = UtilsKt.AsyncImageState(obj, imageLoader, composer2, (i5 & 14) | (i8 & 112));
        Function1<AsyncImagePainter.State, AsyncImagePainter.State> transformOf = UtilsKt.transformOf(painter4, painter5, painter6);
        int i9 = i3 << 15;
        m7456AsyncImage76YX9Dk(AsyncImageState, str, modifier3, transformOf, UtilsKt.onStateOf(function14, function15, function16), center, fit, f2, colorFilter2, r14, z2, composer2, (i2 & 112) | (i8 & 896) | (458752 & i9) | (3670016 & i9) | (29360128 & i9) | (234881024 & i9) | (i9 & 1879048192), (i3 >> 15) & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* renamed from: AsyncImage-sKDTAoQ  reason: not valid java name */
    public static final void m7458AsyncImagesKDTAoQ(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, Composer composer, int i2, int i3, int i4) {
        int i5 = i2;
        int i6 = i3;
        int i7 = i4;
        Modifier modifier2 = (i7 & 8) != 0 ? Modifier.Companion : modifier;
        Function1<AsyncImagePainter.State, AsyncImagePainter.State> defaultTransform = (i7 & 16) != 0 ? AsyncImagePainter.Companion.getDefaultTransform() : function1;
        Function1<? super AsyncImagePainter.State, Unit> function13 = (i7 & 32) != 0 ? null : function12;
        Alignment center = (i7 & 64) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i7 & 128) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f2 = (i7 & 256) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i7 & 512) != 0 ? null : colorFilter;
        int r13 = (i7 & 1024) != 0 ? DrawScope.Companion.m4868getDefaultFilterQualityfv9h1I() : i;
        boolean z2 = (i7 & 2048) != 0 ? true : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(40041566, i5, i6, "coil3.compose.AsyncImage (AsyncImage.kt:124)");
        }
        int i8 = i5 >> 3;
        Composer composer2 = composer;
        m7456AsyncImage76YX9Dk(UtilsKt.AsyncImageState(obj, imageLoader, composer2, (i5 & 14) | (i8 & 112)), str, modifier2, defaultTransform, function13, center, fit, f2, colorFilter2, r13, z2, composer2, (i5 & 112) | (i8 & 896) | (i8 & 7168) | (57344 & i8) | (458752 & i8) | (3670016 & i8) | (29360128 & i8) | (234881024 & i8) | ((i6 << 27) & 1879048192), (i6 >> 3) & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* renamed from: AsyncImage-76YX9Dk  reason: not valid java name */
    private static final void m7456AsyncImage76YX9Dk(AsyncImageState asyncImageState, String str, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, Composer composer, int i2, int i3) {
        int i4;
        AsyncImageState asyncImageState2;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function13;
        Function1<? super AsyncImagePainter.State, Unit> function14;
        int i5;
        Modifier modifier2 = modifier;
        ContentScale contentScale2 = contentScale;
        int i6 = i2;
        Composer startRestartGroup = composer.startRestartGroup(1236588022);
        int i7 = 4;
        if ((i6 & 6) == 0) {
            asyncImageState2 = asyncImageState;
            i4 = (startRestartGroup.changed((Object) asyncImageState2) ? 4 : 2) | i6;
        } else {
            asyncImageState2 = asyncImageState;
            i4 = i6;
        }
        String str2 = str;
        if ((i6 & 48) == 0) {
            i4 |= startRestartGroup.changed((Object) str2) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i4 |= startRestartGroup.changed((Object) modifier2) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            function13 = function1;
            i4 |= startRestartGroup.changedInstance(function13) ? 2048 : 1024;
        } else {
            function13 = function1;
        }
        if ((i6 & 24576) == 0) {
            function14 = function12;
            i4 |= startRestartGroup.changedInstance(function14) ? 16384 : 8192;
        } else {
            function14 = function12;
        }
        Alignment alignment2 = alignment;
        if ((196608 & i6) == 0) {
            i4 |= startRestartGroup.changed((Object) alignment2) ? 131072 : 65536;
        }
        if ((1572864 & i6) == 0) {
            i4 |= startRestartGroup.changed((Object) contentScale2) ? 1048576 : 524288;
        }
        float f2 = f;
        if ((12582912 & i6) == 0) {
            i4 |= startRestartGroup.changed(f2) ? 8388608 : 4194304;
        }
        if ((100663296 & i6) == 0) {
            i4 |= startRestartGroup.changed((Object) colorFilter) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            ColorFilter colorFilter2 = colorFilter;
        }
        if ((805306368 & i6) == 0) {
            i4 |= startRestartGroup.changed(i) ? 536870912 : 268435456;
        } else {
            int i8 = i;
        }
        boolean z2 = z;
        if ((i3 & 6) == 0) {
            if (!startRestartGroup.changed(z2)) {
                i7 = 2;
            }
            i5 = i3 | i7;
        } else {
            i5 = i3;
        }
        if ((i4 & 306783379) == 306783378 && (i5 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1236588022, i4, i5, "coil3.compose.AsyncImage (AsyncImage.kt:151)");
            }
            int i9 = i4 >> 6;
            int i10 = i9 & 57344;
            int i11 = i5;
            ImageRequest requestOfWithSizeResolver = UtilsKt.requestOfWithSizeResolver(asyncImageState2.getModel(), contentScale2, startRestartGroup, (i4 >> 15) & 112);
            int i12 = i9;
            int i13 = i4;
            AsyncImagePainter r5 = AsyncImagePainterKt.m7464rememberAsyncImagePainter5jETZwI(requestOfWithSizeResolver, asyncImageState2.getImageLoader(), function13, function14, contentScale2, i, startRestartGroup, ((i4 >> 3) & 8064) | i10 | ((i4 >> 12) & 458752), 0);
            SizeResolver sizeResolver = requestOfWithSizeResolver.getSizeResolver();
            Composer composer2 = startRestartGroup;
            Content(sizeResolver instanceof ConstraintsSizeResolver ? modifier2.then((Modifier) sizeResolver) : modifier2, r5, str2, alignment2, contentScale, f2, colorFilter, z, composer2, ((i11 << 21) & 29360128) | (i12 & 3670016) | ((i13 << 3) & 896) | (i12 & 7168) | i10 | (i12 & 458752));
            startRestartGroup = composer2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AsyncImageKt$$ExternalSyntheticLambda1(asyncImageState2, str, modifier2, function1, function12, alignment, contentScale, f, colorFilter, i, z, i2, i3));
        }
    }

    private static final void Content(Modifier modifier, AsyncImagePainter asyncImagePainter, String str, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, Composer composer, int i) {
        int i2;
        float f2;
        ColorFilter colorFilter2;
        Modifier modifier2 = modifier;
        AsyncImagePainter asyncImagePainter2 = asyncImagePainter;
        String str2 = str;
        boolean z2 = z;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-237738007);
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changed((Object) asyncImagePainter2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changed((Object) str2) ? 256 : 128;
        }
        Alignment alignment2 = alignment;
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changed((Object) alignment2) ? 2048 : 1024;
        }
        ContentScale contentScale2 = contentScale;
        if ((i3 & 24576) == 0) {
            i2 |= startRestartGroup.changed((Object) contentScale2) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            f2 = f;
            i2 |= startRestartGroup.changed(f2) ? 131072 : 65536;
        } else {
            f2 = f;
        }
        if ((1572864 & i3) == 0) {
            colorFilter2 = colorFilter;
            i2 |= startRestartGroup.changed((Object) colorFilter2) ? 1048576 : 524288;
        } else {
            colorFilter2 = colorFilter;
        }
        if ((12582912 & i3) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 8388608 : 4194304;
        }
        if ((4793491 & i2) != 4793490 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-237738007, i2, -1, "coil3.compose.Content (AsyncImage.kt:196)");
            }
            Modifier contentDescription = UtilsKt.contentDescription(modifier2, str2);
            if (z2) {
                contentDescription = ClipKt.clipToBounds(contentDescription);
            }
            Modifier then = contentDescription.then(new ContentPainterElement(asyncImagePainter2, alignment2, contentScale2, f2, colorFilter2));
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = AsyncImageKt$Content$2$1.INSTANCE;
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 544976794, "CC(Layout)P(1)124@4836L23,127@4987L385:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, then);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1405779621, "CC(ReusableComposeNode):Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r10 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r10, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r10, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m3682setimpl(r10, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r10.getInserting() || !Intrinsics.areEqual(r10.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r10.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r10.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
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
            endRestartGroup.updateScope(new AsyncImageKt$$ExternalSyntheticLambda0(modifier2, asyncImagePainter2, str2, alignment, contentScale, f, colorFilter, z2, i3));
        }
    }
}
