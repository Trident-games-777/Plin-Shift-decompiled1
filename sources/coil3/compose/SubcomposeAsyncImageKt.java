package coil3.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import coil3.ImageLoader;
import coil3.compose.AsyncImagePainter;
import coil3.compose.internal.AsyncImageState;
import coil3.compose.internal.UtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import okhttp3.internal.ws.WebSocketProtocol;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aÉ\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2&\b\u0002\u0010\r\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122&\b\u0002\u0010\u0013\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122&\b\u0002\u0010\u0015\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%H\u0007¢\u0006\u0004\b&\u0010'\u001a¿\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\u001c\u0010)\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0004\b*\u0010+\u001a¥\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u001c\u0010)\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0003¢\u0006\u0004\b.\u0010/\u001ae\u00100\u001a\u00020\u0001*\u00020\u000f2\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u00101\u001a\u0002022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010$\u001a\u00020%H\u0007¢\u0006\u0002\u00103\u001a\u0001\u00104\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122$\u0010\r\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122$\u0010\u0013\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122$\u0010\u0015\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0003¢\u0006\u0002\u00105¨\u00066"}, d2 = {"SubcomposeAsyncImage", "", "model", "", "contentDescription", "", "imageLoader", "Lcoil3/ImageLoader;", "modifier", "Landroidx/compose/ui/Modifier;", "transform", "Lkotlin/Function1;", "Lcoil3/compose/AsyncImagePainter$State;", "loading", "Lkotlin/Function2;", "Lcoil3/compose/SubcomposeAsyncImageScope;", "Lcoil3/compose/AsyncImagePainter$State$Loading;", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/runtime/Composable;", "success", "Lcoil3/compose/AsyncImagePainter$State$Success;", "error", "Lcoil3/compose/AsyncImagePainter$State$Error;", "onLoading", "onSuccess", "onError", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "clipToBounds", "", "SubcomposeAsyncImage-MokUVwQ", "(Ljava/lang/Object;Ljava/lang/String;Lcoil3/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLandroidx/compose/runtime/Composer;III)V", "onState", "content", "SubcomposeAsyncImage-QgsmV_s", "(Ljava/lang/Object;Ljava/lang/String;Lcoil3/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "state", "Lcoil3/compose/internal/AsyncImageState;", "SubcomposeAsyncImage-gl8XCv8", "(Lcoil3/compose/internal/AsyncImageState;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SubcomposeAsyncImageContent", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Lcoil3/compose/SubcomposeAsyncImageScope;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ZLandroidx/compose/runtime/Composer;II)V", "contentOf", "(Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;)Lkotlin/jvm/functions/Function3;", "coil-compose-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: SubcomposeAsyncImage.kt */
public final class SubcomposeAsyncImageKt {
    /* access modifiers changed from: private */
    public static final Unit SubcomposeAsyncImageContent$lambda$4(SubcomposeAsyncImageScope subcomposeAsyncImageScope, Modifier modifier, Painter painter, String str, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, int i, int i2, Composer composer, int i3) {
        SubcomposeAsyncImageContent(subcomposeAsyncImageScope, modifier, painter, str, alignment, contentScale, f, colorFilter, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit SubcomposeAsyncImage_gl8XCv8$lambda$1(AsyncImageState asyncImageState, String str, Modifier modifier, Function1 function1, Function1 function12, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, Function3 function3, int i2, int i3, int i4, Composer composer, int i5) {
        m7484SubcomposeAsyncImagegl8XCv8(asyncImageState, str, modifier, function1, function12, alignment, contentScale, f, colorFilter, i, z, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* renamed from: SubcomposeAsyncImage-MokUVwQ  reason: not valid java name */
    public static final void m7482SubcomposeAsyncImageMokUVwQ(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function4, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function42, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function43, Function1<? super AsyncImagePainter.State.Loading, Unit> function12, Function1<? super AsyncImagePainter.State.Success, Unit> function13, Function1<? super AsyncImagePainter.State.Error, Unit> function14, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, Composer composer, int i2, int i3, int i4) {
        ColorFilter colorFilter2;
        int i5 = i2;
        int i6 = i3;
        int i7 = i4;
        Modifier modifier2 = (i7 & 8) != 0 ? Modifier.Companion : modifier;
        Function1<AsyncImagePainter.State, AsyncImagePainter.State> defaultTransform = (i7 & 16) != 0 ? AsyncImagePainter.Companion.getDefaultTransform() : function1;
        ColorFilter colorFilter3 = null;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function44 = (i7 & 32) != 0 ? null : function4;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function45 = (i7 & 64) != 0 ? null : function42;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function46 = (i7 & 128) != 0 ? null : function43;
        Function1<? super AsyncImagePainter.State.Loading, Unit> function15 = (i7 & 256) != 0 ? null : function12;
        Function1<? super AsyncImagePainter.State.Success, Unit> function16 = (i7 & 512) != 0 ? null : function13;
        Function1<? super AsyncImagePainter.State.Error, Unit> function17 = (i7 & 1024) != 0 ? null : function14;
        Alignment center = (i7 & 2048) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i7 & 4096) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f2 = (i7 & 8192) != 0 ? 1.0f : f;
        if ((i7 & 16384) == 0) {
            colorFilter3 = colorFilter;
        }
        int r15 = (32768 & i7) != 0 ? DrawScope.Companion.m4868getDefaultFilterQualityfv9h1I() : i;
        boolean z2 = (i7 & 65536) != 0 ? true : z;
        if (ComposerKt.isTraceInProgress()) {
            colorFilter2 = colorFilter3;
            ComposerKt.traceEventStart(831032125, i5, i6, "coil3.compose.SubcomposeAsyncImage (SubcomposeAsyncImage.kt:82)");
        } else {
            colorFilter2 = colorFilter3;
        }
        int i8 = i5 >> 3;
        Modifier modifier3 = modifier2;
        Composer composer2 = composer;
        AsyncImageState AsyncImageState = UtilsKt.AsyncImageState(obj, imageLoader, composer2, (i5 & 14) | (i8 & 112));
        Function1<AsyncImagePainter.State, Unit> onStateOf = UtilsKt.onStateOf(function15, function16, function17);
        Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit> contentOf = contentOf(function44, function45, function46);
        int i9 = (i2 & 112) | (i8 & 896) | (i8 & 7168);
        int i10 = i3 << 12;
        m7484SubcomposeAsyncImagegl8XCv8(AsyncImageState, str, modifier3, defaultTransform, onStateOf, center, fit, f2, colorFilter2, r15, z2, contentOf, composer2, i9 | (458752 & i10) | (3670016 & i10) | (29360128 & i10) | (234881024 & i10) | (i10 & 1879048192), (i3 >> 18) & 14, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* renamed from: SubcomposeAsyncImage-QgsmV_s  reason: not valid java name */
    public static final void m7483SubcomposeAsyncImageQgsmV_s(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, Function3<? super SubcomposeAsyncImageScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i2, int i3, int i4) {
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
            ComposerKt.traceEventStart(-734720902, i5, i6, "coil3.compose.SubcomposeAsyncImage (SubcomposeAsyncImage.kt:141)");
        }
        int i8 = i5 >> 3;
        Composer composer2 = composer;
        m7484SubcomposeAsyncImagegl8XCv8(UtilsKt.AsyncImageState(obj, imageLoader, composer2, (i5 & 14) | (i8 & 112)), str, modifier2, defaultTransform, function13, center, fit, f2, colorFilter2, r13, z2, function3, composer2, (i5 & 112) | (i8 & 896) | (i8 & 7168) | (57344 & i8) | (458752 & i8) | (3670016 & i8) | (29360128 & i8) | (234881024 & i8) | ((i6 << 27) & 1879048192), (i6 >> 3) & WebSocketProtocol.PAYLOAD_SHORT, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x02fe  */
    /* JADX WARNING: Removed duplicated region for block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x011b  */
    /* renamed from: SubcomposeAsyncImage-gl8XCv8  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final void m7484SubcomposeAsyncImagegl8XCv8(coil3.compose.internal.AsyncImageState r22, java.lang.String r23, androidx.compose.ui.Modifier r24, kotlin.jvm.functions.Function1<? super coil3.compose.AsyncImagePainter.State, ? extends coil3.compose.AsyncImagePainter.State> r25, kotlin.jvm.functions.Function1<? super coil3.compose.AsyncImagePainter.State, kotlin.Unit> r26, androidx.compose.ui.Alignment r27, androidx.compose.ui.layout.ContentScale r28, float r29, androidx.compose.ui.graphics.ColorFilter r30, int r31, boolean r32, kotlin.jvm.functions.Function3<? super coil3.compose.SubcomposeAsyncImageScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, int r35, int r36, int r37) {
        /*
            r1 = r27
            r6 = r28
            r12 = r33
            r13 = r35
            r15 = r37
            r0 = -205779950(0xfffffffff3bc0c12, float:-2.979726E31)
            r2 = r34
            androidx.compose.runtime.Composer r4 = r2.startRestartGroup(r0)
            r2 = r15 & 1
            if (r2 == 0) goto L_0x001c
            r2 = r13 | 6
            r11 = r22
            goto L_0x002e
        L_0x001c:
            r2 = r13 & 6
            r11 = r22
            if (r2 != 0) goto L_0x002d
            boolean r2 = r4.changed((java.lang.Object) r11)
            if (r2 == 0) goto L_0x002a
            r2 = 4
            goto L_0x002b
        L_0x002a:
            r2 = 2
        L_0x002b:
            r2 = r2 | r13
            goto L_0x002e
        L_0x002d:
            r2 = r13
        L_0x002e:
            r7 = r15 & 2
            if (r7 == 0) goto L_0x0037
            r2 = r2 | 48
            r14 = r23
            goto L_0x0049
        L_0x0037:
            r7 = r13 & 48
            r14 = r23
            if (r7 != 0) goto L_0x0049
            boolean r7 = r4.changed((java.lang.Object) r14)
            if (r7 == 0) goto L_0x0046
            r7 = 32
            goto L_0x0048
        L_0x0046:
            r7 = 16
        L_0x0048:
            r2 = r2 | r7
        L_0x0049:
            r7 = r15 & 4
            if (r7 == 0) goto L_0x0050
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0050:
            r10 = r13 & 384(0x180, float:5.38E-43)
            if (r10 != 0) goto L_0x0064
            r10 = r24
            boolean r16 = r4.changed((java.lang.Object) r10)
            if (r16 == 0) goto L_0x005f
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r2 = r2 | r16
            goto L_0x0066
        L_0x0064:
            r10 = r24
        L_0x0066:
            r16 = r15 & 8
            if (r16 == 0) goto L_0x006d
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x006d:
            r3 = r13 & 3072(0xc00, float:4.305E-42)
            if (r3 != 0) goto L_0x0081
            r3 = r25
            boolean r16 = r4.changedInstance(r3)
            if (r16 == 0) goto L_0x007c
            r16 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r16 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r2 = r2 | r16
            goto L_0x0083
        L_0x0081:
            r3 = r25
        L_0x0083:
            r16 = r15 & 16
            if (r16 == 0) goto L_0x008a
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009e
        L_0x008a:
            r5 = r13 & 24576(0x6000, float:3.4438E-41)
            if (r5 != 0) goto L_0x009e
            r5 = r26
            boolean r17 = r4.changedInstance(r5)
            if (r17 == 0) goto L_0x0099
            r17 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009b
        L_0x0099:
            r17 = 8192(0x2000, float:1.14794E-41)
        L_0x009b:
            r2 = r2 | r17
            goto L_0x00a0
        L_0x009e:
            r5 = r26
        L_0x00a0:
            r17 = r15 & 32
            r18 = 196608(0x30000, float:2.75506E-40)
            if (r17 == 0) goto L_0x00a9
            r2 = r2 | r18
            goto L_0x00ba
        L_0x00a9:
            r17 = r13 & r18
            if (r17 != 0) goto L_0x00ba
            boolean r17 = r4.changed((java.lang.Object) r1)
            if (r17 == 0) goto L_0x00b6
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00b6:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00b8:
            r2 = r2 | r17
        L_0x00ba:
            r17 = r15 & 64
            r18 = 1572864(0x180000, float:2.204052E-39)
            if (r17 == 0) goto L_0x00c3
            r2 = r2 | r18
            goto L_0x00d4
        L_0x00c3:
            r17 = r13 & r18
            if (r17 != 0) goto L_0x00d4
            boolean r17 = r4.changed((java.lang.Object) r6)
            if (r17 == 0) goto L_0x00d0
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d2
        L_0x00d0:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d2:
            r2 = r2 | r17
        L_0x00d4:
            r8 = r15 & 128(0x80, float:1.794E-43)
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            if (r8 == 0) goto L_0x00dd
            r2 = r2 | r18
            goto L_0x00f1
        L_0x00dd:
            r8 = r13 & r18
            if (r8 != 0) goto L_0x00f1
            r8 = r29
            boolean r18 = r4.changed((float) r8)
            if (r18 == 0) goto L_0x00ec
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ee
        L_0x00ec:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ee:
            r2 = r2 | r18
            goto L_0x00f3
        L_0x00f1:
            r8 = r29
        L_0x00f3:
            r9 = r15 & 256(0x100, float:3.59E-43)
            r19 = 100663296(0x6000000, float:2.4074124E-35)
            if (r9 == 0) goto L_0x00fc
            r2 = r2 | r19
            goto L_0x0110
        L_0x00fc:
            r9 = r13 & r19
            if (r9 != 0) goto L_0x0110
            r9 = r30
            boolean r19 = r4.changed((java.lang.Object) r9)
            if (r19 == 0) goto L_0x010b
            r19 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010d
        L_0x010b:
            r19 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010d:
            r2 = r2 | r19
            goto L_0x0112
        L_0x0110:
            r9 = r30
        L_0x0112:
            r0 = r15 & 512(0x200, float:7.175E-43)
            r20 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x011b
            r2 = r2 | r20
            goto L_0x012f
        L_0x011b:
            r0 = r13 & r20
            if (r0 != 0) goto L_0x012f
            r0 = r31
            boolean r20 = r4.changed((int) r0)
            if (r20 == 0) goto L_0x012a
            r20 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012c
        L_0x012a:
            r20 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x012c:
            r2 = r2 | r20
            goto L_0x0131
        L_0x012f:
            r0 = r31
        L_0x0131:
            r0 = r15 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x013c
            r0 = r36 | 6
            r16 = r0
            r0 = r32
            goto L_0x0154
        L_0x013c:
            r0 = r36 & 6
            if (r0 != 0) goto L_0x0150
            r0 = r32
            boolean r20 = r4.changed((boolean) r0)
            if (r20 == 0) goto L_0x014b
            r16 = 4
            goto L_0x014d
        L_0x014b:
            r16 = 2
        L_0x014d:
            r16 = r36 | r16
            goto L_0x0154
        L_0x0150:
            r0 = r32
            r16 = r36
        L_0x0154:
            r0 = r15 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x015b
            r16 = r16 | 48
            goto L_0x016c
        L_0x015b:
            r0 = r36 & 48
            if (r0 != 0) goto L_0x016c
            boolean r0 = r4.changedInstance(r12)
            if (r0 == 0) goto L_0x0168
            r17 = 32
            goto L_0x016a
        L_0x0168:
            r17 = 16
        L_0x016a:
            r16 = r16 | r17
        L_0x016c:
            r0 = r16
            r16 = 306783379(0x12492493, float:6.34695E-28)
            r3 = r2 & r16
            r5 = 306783378(0x12492492, float:6.3469493E-28)
            if (r3 != r5) goto L_0x018b
            r3 = r0 & 19
            r5 = 18
            if (r3 != r5) goto L_0x018b
            boolean r3 = r4.getSkipping()
            if (r3 != 0) goto L_0x0185
            goto L_0x018b
        L_0x0185:
            r4.skipToGroupEnd()
            r3 = r10
            goto L_0x02f8
        L_0x018b:
            if (r7 == 0) goto L_0x0192
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x0193
        L_0x0192:
            r3 = r10
        L_0x0193:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x01a1
            java.lang.String r5 = "coil3.compose.SubcomposeAsyncImage (SubcomposeAsyncImage.kt:170)"
            r7 = -205779950(0xfffffffff3bc0c12, float:-2.979726E31)
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r2, r0, r5)
        L_0x01a1:
            java.lang.Object r5 = r11.getModel()
            int r7 = r2 >> 15
            r7 = r7 & 112(0x70, float:1.57E-43)
            coil3.request.ImageRequest r5 = coil3.compose.internal.UtilsKt.requestOfWithSizeResolver(r5, r6, r4, r7)
            r10 = r3
            coil3.ImageLoader r3 = r11.getImageLoader()
            int r7 = r2 >> 3
            r7 = r7 & 8064(0x1f80, float:1.13E-41)
            int r16 = r2 >> 6
            r17 = 57344(0xe000, float:8.0356E-41)
            r17 = r16 & r17
            r7 = r7 | r17
            int r17 = r2 >> 12
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r17 & r2
            r2 = r2 | r7
            r7 = r10
            r10 = 0
            r9 = r2
            r8 = r4
            r2 = r5
            r11 = r7
            r4 = r25
            r5 = r26
            r7 = r31
            coil3.compose.AsyncImagePainter r3 = coil3.compose.AsyncImagePainterKt.m7464rememberAsyncImagePainter5jETZwI(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r10 = r8
            coil3.size.SizeResolver r2 = r2.getSizeResolver()
            boolean r4 = r2 instanceof coil3.compose.ConstraintsSizeResolver
            r5 = 1
            if (r4 != 0) goto L_0x02b4
            r2 = -637501818(0xffffffffda007e86, float:-9.0419778E15)
            r10.startReplaceGroup(r2)
            r2 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            java.lang.String r4 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r2, r4)
            androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.BoxKt.maybeCachedBoxMeasurePolicy(r1, r5)
            r4 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r5 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r4, r5)
            r4 = 0
            int r4 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r10, r4)
            androidx.compose.runtime.CompositionLocalMap r5 = r10.getCurrentCompositionLocalMap()
            androidx.compose.ui.Modifier r6 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r10, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r7 = r7.getConstructor()
            r8 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            java.lang.String r9 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r8, r9)
            androidx.compose.runtime.Applier r8 = r10.getApplier()
            boolean r8 = r8 instanceof androidx.compose.runtime.Applier
            if (r8 != 0) goto L_0x0220
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0220:
            r10.startReusableNode()
            boolean r8 = r10.getInserting()
            if (r8 == 0) goto L_0x022d
            r10.createNode(r7)
            goto L_0x0230
        L_0x022d:
            r10.useNode()
        L_0x0230:
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.Updater.m3675constructorimpl(r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r7, r2, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r7, r5, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetCompositeKeyHash()
            boolean r5 = r7.getInserting()
            if (r5 != 0) goto L_0x0260
            java.lang.Object r5 = r7.rememberedValue()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r8)
            if (r5 != 0) goto L_0x026e
        L_0x0260:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            r7.updateRememberedValue(r5)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r7.apply(r4, r2)
        L_0x026e:
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r7, r6, r2)
            r2 = -2146769399(0xffffffff800ae609, float:-1.000876E-39)
            java.lang.String r4 = "C73@3429L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r2, r4)
            androidx.compose.foundation.layout.BoxScopeInstance r2 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r2 = (androidx.compose.foundation.layout.BoxScope) r2
            r16 = r0
            coil3.compose.RealSubcomposeAsyncImageScope r0 = new coil3.compose.RealSubcomposeAsyncImageScope
            r5 = r28
            r6 = r29
            r7 = r30
            r8 = r32
            r4 = r1
            r1 = r2
            r2 = r3
            r3 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r1 = r16 & 112(0x70, float:1.57E-43)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r12.invoke(r0, r10, r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r10.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r10.endReplaceGroup()
            r4 = r10
            r0 = r11
            goto L_0x02ee
        L_0x02b4:
            r0 = -636813091(0xffffffffda0b00dd, float:-9.7814927E15)
            r10.startReplaceGroup(r0)
            coil3.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImage$2 r0 = new coil3.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImage$2
            r4 = r23
            r6 = r28
            r7 = r29
            r8 = r30
            r9 = r32
            r1 = r2
            r2 = r12
            r12 = r5
            r5 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r1 = 54
            r2 = -374957172(0xffffffffe9a69b8c, float:-2.517703E25)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r2, r12, r0, r10, r1)
            r3 = r0
            kotlin.jvm.functions.Function3 r3 = (kotlin.jvm.functions.Function3) r3
            r0 = r16 & 14
            r0 = r0 | 3456(0xd80, float:4.843E-42)
            r1 = r17 & 112(0x70, float:1.57E-43)
            r5 = r0 | r1
            r6 = 0
            r2 = 1
            r1 = r27
            r4 = r10
            r0 = r11
            androidx.compose.foundation.layout.BoxWithConstraintsKt.BoxWithConstraints(r0, r1, r2, r3, r4, r5, r6)
            r4.endReplaceGroup()
        L_0x02ee:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x02f7
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02f7:
            r3 = r0
        L_0x02f8:
            androidx.compose.runtime.ScopeUpdateScope r0 = r4.endRestartGroup()
            if (r0 == 0) goto L_0x0323
            r1 = r0
            coil3.compose.SubcomposeAsyncImageKt$$ExternalSyntheticLambda0 r0 = new coil3.compose.SubcomposeAsyncImageKt$$ExternalSyntheticLambda0
            r2 = r23
            r4 = r25
            r5 = r26
            r6 = r27
            r7 = r28
            r8 = r29
            r9 = r30
            r10 = r31
            r11 = r32
            r12 = r33
            r14 = r36
            r21 = r1
            r1 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r1 = r21
            r1.updateScope(r0)
        L_0x0323:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.compose.SubcomposeAsyncImageKt.m7484SubcomposeAsyncImagegl8XCv8(coil3.compose.internal.AsyncImageState, java.lang.String, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.ui.Alignment, androidx.compose.ui.layout.ContentScale, float, androidx.compose.ui.graphics.ColorFilter, int, boolean, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x02b2  */
    /* JADX WARNING: Removed duplicated region for block: B:182:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0107  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SubcomposeAsyncImageContent(coil3.compose.SubcomposeAsyncImageScope r21, androidx.compose.ui.Modifier r22, androidx.compose.ui.graphics.painter.Painter r23, java.lang.String r24, androidx.compose.ui.Alignment r25, androidx.compose.ui.layout.ContentScale r26, float r27, androidx.compose.ui.graphics.ColorFilter r28, boolean r29, androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r10 = r31
            r11 = r32
            r0 = -1375825518(0xffffffffadfe9192, float:-2.8941103E-11)
            r1 = r30
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r11
            if (r2 == 0) goto L_0x0018
            r2 = r10 | 6
            r3 = r2
            r2 = r21
            goto L_0x002c
        L_0x0018:
            r2 = r10 & 6
            if (r2 != 0) goto L_0x0029
            r2 = r21
            boolean r3 = r1.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0026
            r3 = 4
            goto L_0x0027
        L_0x0026:
            r3 = 2
        L_0x0027:
            r3 = r3 | r10
            goto L_0x002c
        L_0x0029:
            r2 = r21
            r3 = r10
        L_0x002c:
            r4 = r11 & 1
            if (r4 == 0) goto L_0x0033
            r3 = r3 | 48
            goto L_0x0046
        L_0x0033:
            r5 = r10 & 48
            if (r5 != 0) goto L_0x0046
            r5 = r22
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0042
            r6 = 32
            goto L_0x0044
        L_0x0042:
            r6 = 16
        L_0x0044:
            r3 = r3 | r6
            goto L_0x0048
        L_0x0046:
            r5 = r22
        L_0x0048:
            r6 = r10 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L_0x0061
            r6 = r11 & 2
            if (r6 != 0) goto L_0x005b
            r6 = r23
            boolean r7 = r1.changedInstance(r6)
            if (r7 == 0) goto L_0x005d
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005b:
            r6 = r23
        L_0x005d:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r3 = r3 | r7
            goto L_0x0063
        L_0x0061:
            r6 = r23
        L_0x0063:
            r7 = r10 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x007c
            r7 = r11 & 4
            if (r7 != 0) goto L_0x0076
            r7 = r24
            boolean r8 = r1.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0078
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0076:
            r7 = r24
        L_0x0078:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r3 = r3 | r8
            goto L_0x007e
        L_0x007c:
            r7 = r24
        L_0x007e:
            r8 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r8 != 0) goto L_0x0097
            r8 = r11 & 8
            if (r8 != 0) goto L_0x0091
            r8 = r25
            boolean r9 = r1.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0093
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0095
        L_0x0091:
            r8 = r25
        L_0x0093:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x0095:
            r3 = r3 | r9
            goto L_0x0099
        L_0x0097:
            r8 = r25
        L_0x0099:
            r9 = 196608(0x30000, float:2.75506E-40)
            r9 = r9 & r10
            if (r9 != 0) goto L_0x00b3
            r9 = r11 & 16
            if (r9 != 0) goto L_0x00ad
            r9 = r26
            boolean r12 = r1.changed((java.lang.Object) r9)
            if (r12 == 0) goto L_0x00af
            r12 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b1
        L_0x00ad:
            r9 = r26
        L_0x00af:
            r12 = 65536(0x10000, float:9.18355E-41)
        L_0x00b1:
            r3 = r3 | r12
            goto L_0x00b5
        L_0x00b3:
            r9 = r26
        L_0x00b5:
            r12 = 1572864(0x180000, float:2.204052E-39)
            r12 = r12 & r10
            if (r12 != 0) goto L_0x00cf
            r12 = r11 & 32
            if (r12 != 0) goto L_0x00c9
            r12 = r27
            boolean r13 = r1.changed((float) r12)
            if (r13 == 0) goto L_0x00cb
            r13 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cd
        L_0x00c9:
            r12 = r27
        L_0x00cb:
            r13 = 524288(0x80000, float:7.34684E-40)
        L_0x00cd:
            r3 = r3 | r13
            goto L_0x00d1
        L_0x00cf:
            r12 = r27
        L_0x00d1:
            r13 = 12582912(0xc00000, float:1.7632415E-38)
            r13 = r13 & r10
            if (r13 != 0) goto L_0x00eb
            r13 = r11 & 64
            if (r13 != 0) goto L_0x00e5
            r13 = r28
            boolean r14 = r1.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x00e7
            r14 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00e9
        L_0x00e5:
            r13 = r28
        L_0x00e7:
            r14 = 4194304(0x400000, float:5.877472E-39)
        L_0x00e9:
            r3 = r3 | r14
            goto L_0x00ed
        L_0x00eb:
            r13 = r28
        L_0x00ed:
            r14 = 100663296(0x6000000, float:2.4074124E-35)
            r14 = r14 & r10
            if (r14 != 0) goto L_0x0107
            r14 = r11 & 128(0x80, float:1.794E-43)
            if (r14 != 0) goto L_0x0101
            r14 = r29
            boolean r15 = r1.changed((boolean) r14)
            if (r15 == 0) goto L_0x0103
            r15 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0105
        L_0x0101:
            r14 = r29
        L_0x0103:
            r15 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0105:
            r3 = r3 | r15
            goto L_0x0109
        L_0x0107:
            r14 = r29
        L_0x0109:
            r15 = 38347923(0x2492493, float:1.4777644E-37)
            r15 = r15 & r3
            r0 = 38347922(0x2492492, float:1.4777643E-37)
            if (r15 != r0) goto L_0x0126
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x0119
            goto L_0x0126
        L_0x0119:
            r1.skipToGroupEnd()
            r2 = r5
        L_0x011d:
            r3 = r6
            r4 = r7
            r5 = r8
            r6 = r9
            r7 = r12
            r8 = r13
            r9 = r14
            goto L_0x02ac
        L_0x0126:
            r1.startDefaults()
            r0 = r10 & 1
            r15 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r17 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r18 = -3670017(0xffffffffffc7ffff, float:NaN)
            r19 = -458753(0xfffffffffff8ffff, float:NaN)
            r20 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x0170
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0143
            goto L_0x0170
        L_0x0143:
            r1.skipToGroupEnd()
            r0 = r11 & 2
            if (r0 == 0) goto L_0x014c
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x014c:
            r0 = r11 & 4
            if (r0 == 0) goto L_0x0152
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0152:
            r0 = r11 & 8
            if (r0 == 0) goto L_0x0158
            r3 = r3 & r20
        L_0x0158:
            r0 = r11 & 16
            if (r0 == 0) goto L_0x015e
            r3 = r3 & r19
        L_0x015e:
            r0 = r11 & 32
            if (r0 == 0) goto L_0x0164
            r3 = r3 & r18
        L_0x0164:
            r0 = r11 & 64
            if (r0 == 0) goto L_0x016a
            r3 = r3 & r17
        L_0x016a:
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x01c5
            r3 = r3 & r15
            goto L_0x01c5
        L_0x0170:
            if (r4 == 0) goto L_0x0177
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r5 = r0
        L_0x0177:
            r0 = r11 & 2
            if (r0 == 0) goto L_0x0184
            coil3.compose.AsyncImagePainter r0 = r2.getPainter()
            androidx.compose.ui.graphics.painter.Painter r0 = (androidx.compose.ui.graphics.painter.Painter) r0
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            r6 = r0
        L_0x0184:
            r0 = r11 & 4
            if (r0 == 0) goto L_0x018f
            java.lang.String r0 = r2.getContentDescription()
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            r7 = r0
        L_0x018f:
            r0 = r11 & 8
            if (r0 == 0) goto L_0x019a
            androidx.compose.ui.Alignment r0 = r2.getAlignment()
            r3 = r3 & r20
            r8 = r0
        L_0x019a:
            r0 = r11 & 16
            if (r0 == 0) goto L_0x01a5
            androidx.compose.ui.layout.ContentScale r0 = r2.getContentScale()
            r3 = r3 & r19
            r9 = r0
        L_0x01a5:
            r0 = r11 & 32
            if (r0 == 0) goto L_0x01b0
            float r0 = r2.getAlpha()
            r3 = r3 & r18
            r12 = r0
        L_0x01b0:
            r0 = r11 & 64
            if (r0 == 0) goto L_0x01bb
            androidx.compose.ui.graphics.ColorFilter r0 = r2.getColorFilter()
            r3 = r3 & r17
            r13 = r0
        L_0x01bb:
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x01c5
            boolean r0 = r2.getClipToBounds()
            r3 = r3 & r15
            r14 = r0
        L_0x01c5:
            r1.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01d7
            r0 = -1
            java.lang.String r4 = "coil3.compose.SubcomposeAsyncImageContent (SubcomposeAsyncImage.kt:277)"
            r15 = -1375825518(0xffffffffadfe9192, float:-2.8941103E-11)
            androidx.compose.runtime.ComposerKt.traceEventStart(r15, r3, r0, r4)
        L_0x01d7:
            androidx.compose.ui.Modifier r0 = coil3.compose.internal.UtilsKt.contentDescription(r5, r7)
            if (r14 == 0) goto L_0x01e1
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.draw.ClipKt.clipToBounds(r0)
        L_0x01e1:
            coil3.compose.internal.ContentPainterElement r3 = new coil3.compose.internal.ContentPainterElement
            r22 = r3
            r23 = r6
            r24 = r8
            r25 = r9
            r26 = r12
            r27 = r13
            r22.<init>(r23, r24, r25, r26, r27)
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            androidx.compose.ui.Modifier r0 = r0.then(r3)
            java.lang.Object r3 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r3 != r4) goto L_0x020b
            coil3.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImageContent$2$1 r3 = coil3.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImageContent$2$1.INSTANCE
            androidx.compose.ui.layout.MeasurePolicy r3 = (androidx.compose.ui.layout.MeasurePolicy) r3
            r1.updateRememberedValue(r3)
        L_0x020b:
            androidx.compose.ui.layout.MeasurePolicy r3 = (androidx.compose.ui.layout.MeasurePolicy) r3
            r4 = 544976794(0x207baf9a, float:2.1318629E-19)
            java.lang.String r15 = "CC(Layout)P(1)124@4836L23,127@4987L385:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r4, r15)
            r4 = 0
            int r4 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r1, r4)
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r1, r0)
            androidx.compose.runtime.CompositionLocalMap r15 = r1.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r2 = r16.getConstructor()
            r22 = r4
            r4 = 1405779621(0x53ca7ea5, float:1.73941627E12)
            r16 = r5
            java.lang.String r5 = "CC(ReusableComposeNode):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r4, r5)
            androidx.compose.runtime.Applier r4 = r1.getApplier()
            boolean r4 = r4 instanceof androidx.compose.runtime.Applier
            if (r4 != 0) goto L_0x023f
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x023f:
            r1.startReusableNode()
            boolean r4 = r1.getInserting()
            if (r4 == 0) goto L_0x024c
            r1.createNode(r2)
            goto L_0x024f
        L_0x024c:
            r1.useNode()
        L_0x024f:
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.Updater.m3675constructorimpl(r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r2, r3, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r2, r15, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetModifier()
            androidx.compose.runtime.Updater.m3682setimpl((androidx.compose.runtime.Composer) r2, r0, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetCompositeKeyHash()
            boolean r3 = r2.getInserting()
            if (r3 != 0) goto L_0x0288
            java.lang.Object r3 = r2.rememberedValue()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r22)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 != 0) goto L_0x0296
        L_0x0288:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r22)
            r2.updateRememberedValue(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r22)
            r2.apply(r3, r0)
        L_0x0296:
            r1.endNode()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02a8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02a8:
            r2 = r16
            goto L_0x011d
        L_0x02ac:
            androidx.compose.runtime.ScopeUpdateScope r12 = r1.endRestartGroup()
            if (r12 == 0) goto L_0x02bc
            coil3.compose.SubcomposeAsyncImageKt$$ExternalSyntheticLambda1 r0 = new coil3.compose.SubcomposeAsyncImageKt$$ExternalSyntheticLambda1
            r1 = r21
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r12.updateScope(r0)
        L_0x02bc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.compose.SubcomposeAsyncImageKt.SubcomposeAsyncImageContent(coil3.compose.SubcomposeAsyncImageScope, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.painter.Painter, java.lang.String, androidx.compose.ui.Alignment, androidx.compose.ui.layout.ContentScale, float, androidx.compose.ui.graphics.ColorFilter, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit> contentOf(Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function4, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function42, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function43) {
        return (function4 == null && function42 == null && function43 == null) ? ComposableSingletons$SubcomposeAsyncImageKt.INSTANCE.m7466getLambda1$coil_compose_core_release() : ComposableLambdaKt.composableLambdaInstance(-1106738291, true, new SubcomposeAsyncImageKt$contentOf$1(function4, function42, function43));
    }
}
