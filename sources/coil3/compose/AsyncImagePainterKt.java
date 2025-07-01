package coil3.compose;

import android.os.Trace;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.InspectionModeKt;
import coil3.ImageLoader;
import coil3.compose.AsyncImagePainter;
import coil3.compose.internal.AsyncImageState;
import coil3.compose.internal.UtilsKt;
import coil3.request.ImageRequest;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.ws.WebSocketProtocol;

@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a¡\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001ac\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u000b2\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u001e2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u000b2\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0003¢\u0006\u0004\b\u001f\u0010 \u001a\u000f\u0010!\u001a\u0004\u0018\u00010\"H\u0003¢\u0006\u0002\u0010#\u001a\u0010\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0002\u001a\u001a\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020*H\u0002¨\u0006,"}, d2 = {"rememberAsyncImagePainter", "Lcoil3/compose/AsyncImagePainter;", "model", "", "imageLoader", "Lcoil3/ImageLoader;", "placeholder", "Landroidx/compose/ui/graphics/painter/Painter;", "error", "fallback", "onLoading", "Lkotlin/Function1;", "Lcoil3/compose/AsyncImagePainter$State$Loading;", "", "onSuccess", "Lcoil3/compose/AsyncImagePainter$State$Success;", "onError", "Lcoil3/compose/AsyncImagePainter$State$Error;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "rememberAsyncImagePainter-3HmZ8SU", "(Ljava/lang/Object;Lcoil3/ImageLoader;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;II)Lcoil3/compose/AsyncImagePainter;", "transform", "Lcoil3/compose/AsyncImagePainter$State;", "onState", "rememberAsyncImagePainter-5jETZwI", "(Ljava/lang/Object;Lcoil3/ImageLoader;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;II)Lcoil3/compose/AsyncImagePainter;", "state", "Lcoil3/compose/internal/AsyncImageState;", "rememberAsyncImagePainter-GSdzBsE", "(Lcoil3/compose/internal/AsyncImageState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;I)Lcoil3/compose/AsyncImagePainter;", "previewHandler", "Lcoil3/compose/AsyncImagePreviewHandler;", "(Landroidx/compose/runtime/Composer;I)Lcoil3/compose/AsyncImagePreviewHandler;", "validateRequest", "request", "Lcoil3/request/ImageRequest;", "unsupportedData", "", "name", "", "description", "coil-compose-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: AsyncImagePainter.kt */
public final class AsyncImagePainterKt {
    /* renamed from: rememberAsyncImagePainter-3HmZ8SU  reason: not valid java name */
    public static final AsyncImagePainter m7463rememberAsyncImagePainter3HmZ8SU(Object obj, ImageLoader imageLoader, Painter painter, Painter painter2, Painter painter3, Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function12, Function1<? super AsyncImagePainter.State.Error, Unit> function13, ContentScale contentScale, int i, Composer composer, int i2, int i3) {
        int i4 = i2;
        int i5 = i3;
        Function1<? super AsyncImagePainter.State.Error, Unit> function14 = null;
        if ((i5 & 4) != 0) {
            painter = null;
        }
        Painter painter4 = (i5 & 8) != 0 ? null : painter2;
        Painter painter5 = (i5 & 16) != 0 ? painter4 : painter3;
        Function1<? super AsyncImagePainter.State.Loading, Unit> function15 = (i5 & 32) != 0 ? null : function1;
        Function1<? super AsyncImagePainter.State.Success, Unit> function16 = (i5 & 64) != 0 ? null : function12;
        if ((i5 & 128) == 0) {
            function14 = function13;
        }
        ContentScale fit = (i5 & 256) != 0 ? ContentScale.Companion.getFit() : contentScale;
        int r1 = (i5 & 512) != 0 ? DrawScope.Companion.m4868getDefaultFilterQualityfv9h1I() : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1219624997, i4, -1, "coil3.compose.rememberAsyncImagePainter (AsyncImagePainter.kt:91)");
        }
        Composer composer2 = composer;
        AsyncImagePainter r11 = m7465rememberAsyncImagePainterGSdzBsE(UtilsKt.AsyncImageState(obj, imageLoader, composer2, i4 & WebSocketProtocol.PAYLOAD_SHORT), UtilsKt.transformOf(painter, painter4, painter5), UtilsKt.onStateOf(function15, function16, function14), fit, r1, composer2, (i4 >> 15) & 64512);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return r11;
    }

    /* renamed from: rememberAsyncImagePainter-5jETZwI  reason: not valid java name */
    public static final AsyncImagePainter m7464rememberAsyncImagePainter5jETZwI(Object obj, ImageLoader imageLoader, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, ContentScale contentScale, int i, Composer composer, int i2, int i3) {
        Function1<AsyncImagePainter.State, AsyncImagePainter.State> function13 = function1;
        if ((i3 & 4) != 0) {
            function13 = AsyncImagePainter.Companion.getDefaultTransform();
        }
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function14 = function13;
        if ((i3 & 8) != 0) {
            function12 = null;
        }
        Function1<? super AsyncImagePainter.State, Unit> function15 = function12;
        if ((i3 & 16) != 0) {
            contentScale = ContentScale.Companion.getFit();
        }
        ContentScale contentScale2 = contentScale;
        if ((i3 & 32) != 0) {
            i = DrawScope.Companion.m4868getDefaultFilterQualityfv9h1I();
        }
        int i4 = i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1066092719, i2, -1, "coil3.compose.rememberAsyncImagePainter (AsyncImagePainter.kt:124)");
        }
        AsyncImagePainter r7 = m7465rememberAsyncImagePainterGSdzBsE(UtilsKt.AsyncImageState(obj, imageLoader, composer, i2 & WebSocketProtocol.PAYLOAD_SHORT), function14, function15, contentScale2, i4, composer, (i2 >> 3) & 65520);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return r7;
    }

    /* renamed from: rememberAsyncImagePainter-GSdzBsE  reason: not valid java name */
    private static final AsyncImagePainter m7465rememberAsyncImagePainterGSdzBsE(AsyncImageState asyncImageState, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, ContentScale contentScale, int i, Composer composer, int i2) {
        composer.startReplaceGroup(-1242991349);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1242991349, i2, -1, "coil3.compose.rememberAsyncImagePainter (AsyncImagePainter.kt:139)");
        }
        Trace.beginSection("rememberAsyncImagePainter");
        try {
            ImageRequest requestOf = UtilsKt.requestOf(asyncImageState.getModel(), composer, 0);
            validateRequest(requestOf);
            AsyncImagePainter.Input input = new AsyncImagePainter.Input(asyncImageState.getImageLoader(), requestOf, asyncImageState.getModelEqualityDelegate());
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new AsyncImagePainter(input);
                composer.updateRememberedValue(rememberedValue);
            }
            AsyncImagePainter asyncImagePainter = (AsyncImagePainter) rememberedValue;
            ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)482@20332L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composer, -954367824, "CC(remember):Effects.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
                composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue2 = compositionScopedCoroutineScopeCanceller;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd(composer);
            asyncImagePainter.setScope$coil_compose_core_release(coroutineScope);
            asyncImagePainter.setTransform$coil_compose_core_release(function1);
            asyncImagePainter.setOnState$coil_compose_core_release(function12);
            asyncImagePainter.setContentScale$coil_compose_core_release(contentScale);
            asyncImagePainter.m7462setFilterQualityvDHp3xo$coil_compose_core_release(i);
            asyncImagePainter.setPreviewHandler$coil_compose_core_release(previewHandler(composer, 0));
            asyncImagePainter.get_input$coil_compose_core_release().setValue(input);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return asyncImagePainter;
        } finally {
            Trace.endSection();
        }
    }

    private static final AsyncImagePreviewHandler previewHandler(Composer composer, int i) {
        AsyncImagePreviewHandler asyncImagePreviewHandler;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-793376393, i, -1, "coil3.compose.previewHandler (AsyncImagePainter.kt:391)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(InspectionModeKt.getLocalInspectionMode());
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (((Boolean) consume).booleanValue()) {
            composer.startReplaceGroup(-924569787);
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = composer.consume(LocalAsyncImagePreviewHandlerKt.getLocalAsyncImagePreviewHandler());
            ComposerKt.sourceInformationMarkerEnd(composer);
            asyncImagePreviewHandler = (AsyncImagePreviewHandler) consume2;
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-924512282);
            composer.endReplaceGroup();
            asyncImagePreviewHandler = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return asyncImagePreviewHandler;
    }

    private static final void validateRequest(ImageRequest imageRequest) {
        Object data = imageRequest.getData();
        if (data instanceof ImageRequest.Builder) {
            unsupportedData("ImageRequest.Builder", "Did you forget to call ImageRequest.Builder.build()?");
            throw new KotlinNothingValueException();
        } else if (data instanceof ImageBitmap) {
            unsupportedData$default("ImageBitmap", (String) null, 2, (Object) null);
            throw new KotlinNothingValueException();
        } else if (data instanceof ImageVector) {
            unsupportedData$default("ImageVector", (String) null, 2, (Object) null);
            throw new KotlinNothingValueException();
        } else if (!(data instanceof Painter)) {
            AsyncImagePainter_androidKt.validateRequestProperties(imageRequest);
        } else {
            unsupportedData$default("Painter", (String) null, 2, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    static /* synthetic */ Void unsupportedData$default(String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "If you wish to display this " + str + ", use androidx.compose.foundation.Image.";
        }
        return unsupportedData(str, str2);
    }

    private static final Void unsupportedData(String str, String str2) {
        throw new IllegalArgumentException("Unsupported type: " + str + ". " + str2);
    }
}
