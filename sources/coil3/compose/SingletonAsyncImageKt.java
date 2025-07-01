package coil3.compose;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import coil3.SingletonImageLoader;
import coil3.compose.AsyncImagePainter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import okhttp3.internal.ws.WebSocketProtocol;

@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a×\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0007¢\u0006\u0004\b\u001f\u0010 \u001a\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0\r2\u0016\b\u0002\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0007¢\u0006\u0004\b$\u0010%¨\u0006&"}, d2 = {"AsyncImage", "", "model", "", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "placeholder", "Landroidx/compose/ui/graphics/painter/Painter;", "error", "fallback", "onLoading", "Lkotlin/Function1;", "Lcoil3/compose/AsyncImagePainter$State$Loading;", "onSuccess", "Lcoil3/compose/AsyncImagePainter$State$Success;", "onError", "Lcoil3/compose/AsyncImagePainter$State$Error;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "clipToBounds", "", "AsyncImage-x1rPTaM", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLandroidx/compose/runtime/Composer;III)V", "transform", "Lcoil3/compose/AsyncImagePainter$State;", "onState", "AsyncImage-10Xjiaw", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLandroidx/compose/runtime/Composer;III)V", "coil-compose_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: SingletonAsyncImage.kt */
public final class SingletonAsyncImageKt {
    /* renamed from: AsyncImage-x1rPTaM  reason: not valid java name */
    public static final void m7476AsyncImagex1rPTaM(Object obj, String str, Modifier modifier, Painter painter, Painter painter2, Painter painter3, Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function12, Function1<? super AsyncImagePainter.State.Error, Unit> function13, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, Composer composer, int i2, int i3, int i4) {
        Modifier modifier2;
        Composer composer2 = composer;
        int i5 = i2;
        int i6 = i3;
        int i7 = i4;
        Modifier modifier3 = (i7 & 4) != 0 ? Modifier.Companion : modifier;
        ColorFilter colorFilter2 = null;
        Painter painter4 = (i7 & 8) != 0 ? null : painter;
        Painter painter5 = (i7 & 16) != 0 ? null : painter2;
        Painter painter6 = (i7 & 32) != 0 ? painter5 : painter3;
        Function1<? super AsyncImagePainter.State.Loading, Unit> function14 = (i7 & 64) != 0 ? null : function1;
        Function1<? super AsyncImagePainter.State.Success, Unit> function15 = (i7 & 128) != 0 ? null : function12;
        Function1<? super AsyncImagePainter.State.Error, Unit> function16 = (i7 & 256) != 0 ? null : function13;
        Alignment center = (i7 & 512) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i7 & 1024) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f2 = (i7 & 2048) != 0 ? 1.0f : f;
        if ((i7 & 4096) == 0) {
            colorFilter2 = colorFilter;
        }
        int r15 = (i7 & 8192) != 0 ? DrawScope.Companion.m4868getDefaultFilterQualityfv9h1I() : i;
        boolean z2 = (i7 & 16384) != 0 ? true : z;
        if (ComposerKt.isTraceInProgress()) {
            modifier2 = modifier3;
            ComposerKt.traceEventStart(-846727149, i5, i6, "coil3.compose.AsyncImage (SingletonAsyncImage.kt:61)");
        } else {
            modifier2 = modifier3;
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(composer2);
        int i8 = i2 << 3;
        int i9 = i6 << 3;
        AsyncImageKt.m7457AsyncImagenc27qi8(obj, str, SingletonImageLoader.get((Context) consume), modifier2, painter4, painter5, painter6, function14, function15, function16, center, fit, f2, colorFilter2, r15, z2, composer, (i8 & 7168) | (i2 & WebSocketProtocol.PAYLOAD_SHORT) | (i8 & 57344) | (i8 & 458752) | (i8 & 3670016) | (i8 & 29360128) | (i8 & 234881024) | (i8 & 1879048192), (i9 & 896) | ((i2 >> 27) & 14) | (i9 & 112) | (i9 & 7168) | (i9 & 57344) | (i9 & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* renamed from: AsyncImage-10Xjiaw  reason: not valid java name */
    public static final void m7475AsyncImage10Xjiaw(Object obj, String str, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, Composer composer, int i2, int i3, int i4) {
        Composer composer2 = composer;
        int i5 = i2;
        int i6 = i3;
        int i7 = i4;
        Modifier modifier2 = (i7 & 4) != 0 ? Modifier.Companion : modifier;
        Function1 defaultTransform = (i7 & 8) != 0 ? AsyncImagePainter.Companion.getDefaultTransform() : function1;
        ColorFilter colorFilter2 = null;
        Function1<? super AsyncImagePainter.State, Unit> function13 = (i7 & 16) != 0 ? null : function12;
        Alignment center = (i7 & 32) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i7 & 64) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f2 = (i7 & 128) != 0 ? 1.0f : f;
        if ((i7 & 256) == 0) {
            colorFilter2 = colorFilter;
        }
        int r10 = (i7 & 512) != 0 ? DrawScope.Companion.m4868getDefaultFilterQualityfv9h1I() : i;
        boolean z2 = (i7 & 1024) != 0 ? true : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1976030921, i5, i6, "coil3.compose.AsyncImage (SingletonAsyncImage.kt:117)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(composer2);
        int i8 = i5 << 3;
        AsyncImageKt.m7458AsyncImagesKDTAoQ(obj, str, SingletonImageLoader.get((Context) consume), modifier2, defaultTransform, function13, center, fit, f2, colorFilter2, r10, z2, composer2, (i5 & WebSocketProtocol.PAYLOAD_SHORT) | (i8 & 7168) | (57344 & i8) | (458752 & i8) | (3670016 & i8) | (29360128 & i8) | (234881024 & i8) | (i8 & 1879048192), ((i5 >> 27) & 14) | ((i6 << 3) & 112), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
