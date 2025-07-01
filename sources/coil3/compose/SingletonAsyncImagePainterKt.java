package coil3.compose;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import coil3.ImageLoader;
import coil3.SingletonImageLoader;
import coil3.compose.AsyncImagePainter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a[\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\t2\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"rememberAsyncImagePainter", "Lcoil3/compose/AsyncImagePainter;", "model", "", "placeholder", "Landroidx/compose/ui/graphics/painter/Painter;", "error", "fallback", "onLoading", "Lkotlin/Function1;", "Lcoil3/compose/AsyncImagePainter$State$Loading;", "", "onSuccess", "Lcoil3/compose/AsyncImagePainter$State$Success;", "onError", "Lcoil3/compose/AsyncImagePainter$State$Error;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "rememberAsyncImagePainter-MqR-F_0", "(Ljava/lang/Object;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;II)Lcoil3/compose/AsyncImagePainter;", "transform", "Lcoil3/compose/AsyncImagePainter$State;", "onState", "rememberAsyncImagePainter-19ie5dc", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;II)Lcoil3/compose/AsyncImagePainter;", "coil-compose_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: SingletonAsyncImagePainter.kt */
public final class SingletonAsyncImagePainterKt {
    /* renamed from: rememberAsyncImagePainter-MqR-F_0  reason: not valid java name */
    public static final AsyncImagePainter m7478rememberAsyncImagePainterMqRF_0(Object obj, Painter painter, Painter painter2, Painter painter3, Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function12, Function1<? super AsyncImagePainter.State.Error, Unit> function13, ContentScale contentScale, int i, Composer composer, int i2, int i3) {
        Composer composer2 = composer;
        int i4 = i2;
        int i5 = i3;
        Painter painter4 = (i5 & 2) != 0 ? null : painter;
        if ((i5 & 4) != 0) {
            painter2 = null;
        }
        Painter painter5 = (i5 & 8) != 0 ? painter2 : painter3;
        Function1<? super AsyncImagePainter.State.Loading, Unit> function14 = (i5 & 16) != 0 ? null : function1;
        Function1<? super AsyncImagePainter.State.Success, Unit> function15 = (i5 & 32) != 0 ? null : function12;
        Function1<? super AsyncImagePainter.State.Error, Unit> function16 = (i5 & 64) != 0 ? null : function13;
        ContentScale fit = (i5 & 128) != 0 ? ContentScale.Companion.getFit() : contentScale;
        int r9 = (i5 & 256) != 0 ? DrawScope.Companion.m4868getDefaultFilterQualityfv9h1I() : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1650263642, i4, -1, "coil3.compose.rememberAsyncImagePainter (SingletonAsyncImagePainter.kt:44)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ImageLoader imageLoader = SingletonImageLoader.get((Context) consume);
        int i6 = i4 & 14;
        int i7 = i4 << 3;
        AsyncImagePainter r13 = AsyncImagePainterKt.m7463rememberAsyncImagePainter3HmZ8SU(obj, imageLoader, painter4, painter2, painter5, function14, function15, function16, fit, r9, composer2, i6 | (i7 & 896) | (i7 & 7168) | (57344 & i7) | (458752 & i7) | (3670016 & i7) | (29360128 & i7) | (234881024 & i7) | (i7 & 1879048192), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return r13;
    }

    /* renamed from: rememberAsyncImagePainter-19ie5dc  reason: not valid java name */
    public static final AsyncImagePainter m7477rememberAsyncImagePainter19ie5dc(Object obj, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, ContentScale contentScale, int i, Composer composer, int i2, int i3) {
        Function1<AsyncImagePainter.State, AsyncImagePainter.State> function13 = function1;
        if ((i3 & 2) != 0) {
            function13 = AsyncImagePainter.Companion.getDefaultTransform();
        }
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function14 = function13;
        if ((i3 & 4) != 0) {
            function12 = null;
        }
        Function1<? super AsyncImagePainter.State, Unit> function15 = function12;
        if ((i3 & 8) != 0) {
            contentScale = ContentScale.Companion.getFit();
        }
        ContentScale contentScale2 = contentScale;
        if ((i3 & 16) != 0) {
            i = DrawScope.Companion.m4868getDefaultFilterQualityfv9h1I();
        }
        int i4 = i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1093003120, i2, -1, "coil3.compose.rememberAsyncImagePainter (SingletonAsyncImagePainter.kt:80)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i5 = i2 << 3;
        AsyncImagePainter r9 = AsyncImagePainterKt.m7464rememberAsyncImagePainter5jETZwI(obj, SingletonImageLoader.get((Context) consume), function14, function15, contentScale2, i4, composer, (i2 & 14) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (i5 & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return r9;
    }
}
