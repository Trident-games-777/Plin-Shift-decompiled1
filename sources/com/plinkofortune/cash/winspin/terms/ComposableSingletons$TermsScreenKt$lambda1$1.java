package com.plinkofortune.cash.winspin.terms;

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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* renamed from: com.plinkofortune.cash.winspin.terms.ComposableSingletons$TermsScreenKt$lambda-1$1  reason: invalid class name */
/* compiled from: TermsScreen.kt */
final class ComposableSingletons$TermsScreenKt$lambda1$1 implements Function3<ColumnScope, Composer, Integer, Unit> {
    public static final ComposableSingletons$TermsScreenKt$lambda1$1 INSTANCE = new ComposableSingletons$TermsScreenKt$lambda1$1();

    ComposableSingletons$TermsScreenKt$lambda1$1() {
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((ColumnScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope columnScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(columnScope, StringFog.decrypt(new byte[]{-2, 76, 7, -9, 97, -7, -100, -81, -75, 84, Ascii.CR, -1, 96, -98, -89, -84, -81, 85, 1}, new byte[]{-38, 56, 111, -98, Ascii.DC2, -35, -56, -64}));
        if ((i & 6) == 0) {
            i |= composer.changed((Object) columnScope) ? 4 : 2;
        }
        if ((i & 19) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1981432338, i, -1, StringFog.decrypt(new byte[]{109, -83, 9, 92, Ascii.CAN, 113, 70, -13, 101, -83, 2, Ascii.GS, Ascii.SUB, 105, 90, -13, 107, -20, 7, 19, Ascii.ESC, 117, 1, -22, 103, -84, Ascii.ETB, 2, 1, 115, 1, -23, 107, -80, 9, 1, 70, 94, SignedBytes.MAX_POWER_OF_TWO, -16, 126, -83, Ascii.ETB, 19, 10, 113, 74, -50, 103, -84, 3, Ascii.RS, Ascii.CR, 105, SignedBytes.MAX_POWER_OF_TWO, -13, 125, -26, 48, Ascii.ETB, Ascii.SUB, 112, 92, -50, 109, -80, 1, Ascii.ETB, 6, 86, 91, -77, 98, -93, 9, Ascii.DLE, Ascii.FF, 124, 2, -84, 32, -2, 5, Ascii.FS, 7, 115, 86, -16, 97, -73, Ascii.ETB, 76, 72, 53, 123, -8, 124, -81, Ascii.ETB, 33, Ascii.VT, 111, 74, -8, 96, -20, Ascii.SI, 6, 82, 46, Ascii.EM, -76}, new byte[]{Ascii.SO, -62, 100, 114, 104, Ascii.GS, 47, -99}));
            }
            Alignment center = Alignment.Companion.getCenter();
            ColumnScope columnScope2 = columnScope;
            Modifier paint$default = PainterModifierKt.paint$default(columnScope2.align(ColumnScope.weight$default(columnScope2, SizeKt.fillMaxWidth(Modifier.Companion, 0.9f), 1.0f, false, 2, (Object) null), Alignment.Companion.getCenterHorizontally()), PainterResources_androidKt.painterResource(R.drawable.form, composer, 0), false, (Alignment) null, ContentScale.Companion.getFillBounds(), 0.0f, (ColorFilter) null, 54, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, StringFog.decrypt(new byte[]{-99, -72, -114, -82, -52, -29, Ascii.FS, 9, -10, -55, -118, -35, -113, -88, Ascii.FS, 110, -20, -69, -107, -33, -101, -81, 121, 104, -19, -53, -100, -82, -52, -29, Ascii.ESC, 50, -86, -40, -108, -101, -112, -23, 83, 54}, new byte[]{-34, -5, -90, -20, -93, -101, 53, 89}));
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, StringFog.decrypt(new byte[]{117, -48, -25, -79, 116, -71, 17, -86, 66, -70, -97, -43, 52, -15, 82, -19, Ascii.US, -92, -10, -67, 38, -14, 78, -25, 122, -95, -4, -47, 45, -14, 62, -20, 5, -90, -10, -79, 33, -15, 79, -27, 122, -14, -74, -110, 96, -76, 80, -76, 66, -80, -9, -51, 120, -78, Ascii.CAN, -73}, new byte[]{54, -109, -49, -3, Ascii.NAK, -64, 126, -33}));
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, paint$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, StringFog.decrypt(new byte[]{-52, -102, -112, 80, 92, -67, -127, 80, -19, -75, -35, 65, 86, -91, -126, 94, -4, -68, -10, 109, 93, -83, -37, 97, -89, -24, -108, 48, Ascii.DLE, -5, -59, 7, -49, -24, -116, 50, Ascii.SI, -6, -66, 8, -75, -102, -41, 111, 73, -89, -127, 80, -19, -75, -35, 113, Ascii.ETB, -93, -122, Ascii.DC2, -74, -80, -33, 104, 94, -72}, new byte[]{-113, -39, -72, 2, 57, -56, -14, 49}));
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
            ComposerKt.sourceInformationMarkerStart(composer, -2146769399, StringFog.decrypt(new byte[]{-119, 46, 38, -14, -13, -31, -52, 82, -122, 32, 47, -16, -81, -83, -48, 0, -66, 58, 39, -59, -13, -89, -104, 4}, new byte[]{-54, Ascii.EM, Ascii.NAK, -78, -64, -43, -2, 107}));
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            composer.startReplaceGroup(-2088241207);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new ComposableSingletons$TermsScreenKt$lambda1$1$$ExternalSyntheticLambda0();
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
        Intrinsics.checkNotNullParameter(context, StringFog.decrypt(new byte[]{Utf8.REPLACEMENT_BYTE, -110, Ascii.US, 44, Ascii.DC4, -16, 6}, new byte[]{92, -3, 113, 88, 113, -120, 114, 38}));
        WebView webView = new WebView(context);
        webView.setWebViewClient(new ComposableSingletons$TermsScreenKt$lambda1$1$1$1$1$1$1());
        webView.setWebChromeClient(new ComposableSingletons$TermsScreenKt$lambda1$1$1$1$1$1$2());
        webView.setInitialScale(100);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        webView.loadUrl(StringFog.decrypt(new byte[]{-57, -63, 98, 94, 43, 123, -51, 88, -33, -57, Byte.MAX_VALUE, 88, 57, 34, -101, 7, -64, -39, Byte.MAX_VALUE, 77, 33, 49, -114, Ascii.RS, -63, -58, 126, 71, 62, 53, -52, 17, -35, -48, 115, 0, 43, 40, -106, Ascii.DC2, -127, -59, 100, 65, 119, Ascii.NAK, -121, 5, -62, -58, 59, 109, 55, 47, -122, Ascii.RS, -37, -36, 121, SignedBytes.MAX_POWER_OF_TWO, 43}, new byte[]{-81, -75, Ascii.SYN, 46, 88, 65, -30, 119}));
        return webView;
    }
}
