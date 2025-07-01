package com.plinkofortune.cash.winspin.policy;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.plinkofortune.cash.winspin.R;
import com.plinkofortune.cash.winspin.StringFog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* renamed from: com.plinkofortune.cash.winspin.policy.ComposableSingletons$PolicyScreenKt$lambda-1$1  reason: invalid class name */
/* compiled from: PolicyScreen.kt */
final class ComposableSingletons$PolicyScreenKt$lambda1$1 implements Function3<ColumnScope, Composer, Integer, Unit> {
    public static final ComposableSingletons$PolicyScreenKt$lambda1$1 INSTANCE = new ComposableSingletons$PolicyScreenKt$lambda1$1();

    ComposableSingletons$PolicyScreenKt$lambda1$1() {
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((ColumnScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope columnScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(columnScope, StringFog.decrypt(new byte[]{Ascii.RS, 75, 93, 106, -50, 33, -90, -103, 85, 83, 87, 98, -49, 70, -99, -102, 79, 82, 91}, new byte[]{58, Utf8.REPLACEMENT_BYTE, 53, 3, -67, 5, -14, -10}));
        if ((i & 6) == 0) {
            i |= composer.changed((Object) columnScope) ? 4 : 2;
        }
        if ((i & 19) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1895582307, i, -1, StringFog.decrypt(new byte[]{-10, -116, SignedBytes.MAX_POWER_OF_TWO, -74, -65, 115, -56, 83, -2, -116, 75, -9, -67, 107, -44, 83, -16, -51, 78, -7, -68, 119, -113, 74, -4, -115, 94, -24, -90, 113, -113, 77, -6, -113, 68, -5, -74, 49, -30, 82, -8, -109, 66, -21, -82, 125, -51, 88, -58, -118, 67, -1, -93, 122, -43, 82, -5, -112, 9, -56, -96, 115, -56, 94, -20, -80, 78, -22, -86, 122, -49, 118, -31, -51, 65, -7, -94, 125, -59, 92, -72, -46, 3, -92, -82, 113, -50, 83, -20, -114, 66, -19, -68, 33, -127, Ascii.NAK, -59, -116, 65, -15, -84, 102, -14, 94, -25, -122, 72, -10, -31, 116, -43, 7, -90, -43, 4}, new byte[]{-107, -29, 45, -104, -49, Ascii.US, -95, Base64.padSymbol}));
            }
            Alignment center = Alignment.Companion.getCenter();
            ColumnScope columnScope2 = columnScope;
            Modifier paint$default = PainterModifierKt.paint$default(columnScope2.align(ColumnScope.weight$default(columnScope2, SizeKt.fillMaxWidth(Modifier.Companion, 0.9f), 1.0f, false, 2, (Object) null), Alignment.Companion.getCenterHorizontally()), PainterResources_androidKt.painterResource(R.drawable.form, composer, 0), false, (Alignment) null, ContentScale.Companion.getFillBounds(), 0.0f, (ColorFilter) null, 54, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, StringFog.decrypt(new byte[]{Ascii.CR, -13, -56, -43, 76, -61, -104, 45, 102, -126, -52, -90, Ascii.SI, -120, -104, 74, 124, -16, -45, -92, Ascii.ESC, -113, -3, 76, 125, Byte.MIN_VALUE, -38, -43, 76, -61, -97, Ascii.SYN, 58, -109, -46, -32, Ascii.DLE, -55, -41, Ascii.DC2}, new byte[]{78, -80, -32, -105, 35, -69, -79, 125}));
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, StringFog.decrypt(new byte[]{71, 74, Ascii.SI, 103, -104, Ascii.GS, -82, -65, 112, 32, 119, 3, -40, 85, -19, -8, 45, 62, Ascii.RS, 107, -54, 86, -15, -14, 72, 59, Ascii.DC4, 7, -63, 86, -127, -7, 55, 60, Ascii.RS, 103, -51, 85, -16, -16, 72, 104, 94, 68, -116, Ascii.DLE, -17, -95, 112, 42, Ascii.US, Ascii.ESC, -108, Ascii.SYN, -89, -94}, new byte[]{4, 9, 39, 43, -7, 100, -63, -54}));
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, paint$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, StringFog.decrypt(new byte[]{-25, -56, 54, -94, -126, 4, -83, 37, -58, -25, 123, -77, -120, Ascii.FS, -82, 43, -41, -18, 80, -97, -125, Ascii.DC4, -9, Ascii.DC4, -116, -70, 50, -62, -50, 66, -23, 114, -28, -70, 42, -64, -47, 67, -110, 125, -98, -56, 113, -99, -105, Ascii.RS, -83, 37, -58, -25, 123, -125, -55, Ascii.SUB, -86, 103, -99, -30, 121, -102, Byte.MIN_VALUE, 1}, new byte[]{-92, -117, Ascii.RS, -16, -25, 113, -34, 68}));
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer r3 = Updater.m3675constructorimpl(composer);
            Updater.m3682setimpl(r3, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r3.getInserting() || !Intrinsics.areEqual(r3.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r3.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r3, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146769399, StringFog.decrypt(new byte[]{35, 58, Ascii.FF, 71, 60, -72, -116, -39, 44, 52, 5, 69, 96, -12, -112, -117, Ascii.DC4, 46, Ascii.CR, 112, 60, -2, -40, -113}, new byte[]{96, Ascii.CR, Utf8.REPLACEMENT_BYTE, 7, Ascii.SI, -116, -66, -32}));
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            composer.startReplaceGroup(-1886193774);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new ComposableSingletons$PolicyScreenKt$lambda1$1$$ExternalSyntheticLambda0();
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            Composer composer2 = composer;
            AndroidView_androidKt.AndroidView((Function1) rememberedValue, ClipKt.clip(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl((float) 20))), (Function1) null, composer2, 6, 4);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }

    /* access modifiers changed from: private */
    public static final WebView invoke$lambda$4$lambda$3$lambda$2(Context context) {
        Intrinsics.checkNotNullParameter(context, StringFog.decrypt(new byte[]{-53, -77, 70, 66, Ascii.NAK, 83, -95}, new byte[]{-88, -36, 40, 54, 112, 43, -43, 123}));
        WebView webView = new WebView(context);
        webView.setWebViewClient(new ComposableSingletons$PolicyScreenKt$lambda1$1$1$1$1$1$1());
        webView.setWebChromeClient(new ComposableSingletons$PolicyScreenKt$lambda1$1$1$1$1$1$2());
        webView.setInitialScale(100);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        webView.loadUrl(StringFog.decrypt(new byte[]{-29, -91, 5, -4, Ascii.VT, -110, 5, -84, -5, -93, Ascii.CAN, -6, Ascii.EM, -53, 83, -13, -28, -67, Ascii.CAN, -17, 1, -40, 70, -22, -27, -94, Ascii.EM, -27, Ascii.RS, -36, 4, -27, -7, -76, Ascii.DC4, -94, Ascii.VT, -63, 94, -26, -91, -95, 3, -29}, new byte[]{-117, -47, 113, -116, 120, -88, 42, -125}));
        return webView;
    }
}
