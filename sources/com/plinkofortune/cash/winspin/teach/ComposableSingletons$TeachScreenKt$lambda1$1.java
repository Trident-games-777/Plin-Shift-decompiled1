package com.plinkofortune.cash.winspin.teach;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.ColorResources_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.plinkofortune.cash.winspin.R;
import com.plinkofortune.cash.winspin.StringFog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* renamed from: com.plinkofortune.cash.winspin.teach.ComposableSingletons$TeachScreenKt$lambda-1$1  reason: invalid class name */
/* compiled from: TeachScreen.kt */
final class ComposableSingletons$TeachScreenKt$lambda1$1 implements Function3<ColumnScope, Composer, Integer, Unit> {
    public static final ComposableSingletons$TeachScreenKt$lambda1$1 INSTANCE = new ComposableSingletons$TeachScreenKt$lambda1$1();

    ComposableSingletons$TeachScreenKt$lambda1$1() {
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((ColumnScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope columnScope, Composer composer, int i) {
        int i2;
        ColumnScope columnScope2 = columnScope;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(columnScope2, StringFog.decrypt(new byte[]{Ascii.CR, -49, -49, -48, Ascii.ETB, 82, Ascii.DLE, 89, 70, -41, -59, -40, Ascii.SYN, 53, 43, 90, 92, -42, -55}, new byte[]{41, -69, -89, -71, 100, 118, 68, 54}));
        if ((i & 6) == 0) {
            i2 = i | (composer2.changed((Object) columnScope2) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 19) != 18 || !composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-991128036, i2, -1, StringFog.decrypt(new byte[]{10, -42, Ascii.SUB, -34, -12, 119, -39, -46, 2, -42, 17, -97, -10, 111, -59, -46, Ascii.FF, -105, Ascii.DC4, -111, -9, 115, -98, -53, 0, -41, 4, Byte.MIN_VALUE, -19, 117, -98, -56, Ascii.FF, -40, Ascii.DC4, -104, -86, 88, -33, -47, Ascii.EM, -42, 4, -111, -26, 119, -43, -17, 0, -41, Ascii.DLE, -100, -31, 111, -33, -46, Ascii.SUB, -99, 35, -107, -27, 120, -40, -17, 10, -53, Ascii.DC2, -107, -22, 80, -60, -110, 5, -40, Ascii.SUB, -110, -32, 122, -99, -115, 71, -123, Ascii.SYN, -98, -21, 117, -55, -47, 6, -52, 4, -50, -92, 51, -28, -39, 8, -38, Ascii.US, -93, -25, 105, -43, -39, 7, -105, Ascii.FS, -124, -66, 44, -120, -107}, new byte[]{105, -71, 119, -16, -124, Ascii.ESC, -80, -68}));
            }
            Alignment center = Alignment.Companion.getCenter();
            Modifier paint$default = PainterModifierKt.paint$default(columnScope2.align(ColumnScope.weight$default(columnScope2, SizeKt.fillMaxWidth(Modifier.Companion, 0.9f), 1.0f, false, 2, (Object) null), Alignment.Companion.getCenterHorizontally()), PainterResources_androidKt.painterResource(R.drawable.form, composer2, 0), false, (Alignment) null, ContentScale.Companion.getFillBounds(), 0.0f, (ColorFilter) null, 54, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, StringFog.decrypt(new byte[]{Ascii.DLE, -26, -63, 122, -14, 87, Ascii.SUB, 8, 123, -105, -59, 9, -79, Ascii.FS, Ascii.SUB, 111, 97, -27, -38, Ascii.VT, -91, Ascii.ESC, Byte.MAX_VALUE, 105, 96, -107, -45, 122, -14, 87, Ascii.GS, 51, 39, -122, -37, 79, -82, 93, 85, 55}, new byte[]{83, -91, -23, 56, -99, 47, 51, 88}));
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, StringFog.decrypt(new byte[]{-58, -106, -63, 39, 51, -25, 94, -15, -15, -4, -71, 67, 115, -81, Ascii.GS, -74, -84, -30, -48, 43, 97, -84, 1, -68, -55, -25, -38, 71, 106, -84, 113, -73, -74, -32, -48, 39, 102, -81, 0, -66, -55, -76, -112, 4, 39, -22, Ascii.US, -17, -15, -10, -47, 91, Utf8.REPLACEMENT_BYTE, -20, 87, -20}, new byte[]{-123, -43, -23, 107, 82, -98, 49, -124}));
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, paint$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, StringFog.decrypt(new byte[]{Ascii.ETB, 84, 60, -59, -104, -37, 48, -22, 54, 123, 113, -44, -110, -61, 51, -28, 39, 114, 90, -8, -103, -53, 106, -37, 124, 38, 56, -91, -44, -99, 116, -67, Ascii.DC4, 38, 32, -89, -53, -100, Ascii.SI, -78, 110, 84, 123, -6, -115, -63, 48, -22, 54, 123, 113, -28, -45, -59, 55, -88, 109, 126, 115, -3, -102, -34}, new byte[]{84, Ascii.ETB, Ascii.DC4, -105, -3, -82, 67, -117}));
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer r5 = Updater.m3675constructorimpl(composer2);
            Updater.m3682setimpl(r5, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r5, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r5.getInserting() || !Intrinsics.areEqual(r5.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r5.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r5, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, StringFog.decrypt(new byte[]{Ascii.FF, -37, 5, -66, -109, 41, 89, -20, 3, -43, Ascii.FF, -68, -49, 101, 69, -66, 59, -49, 4, -119, -109, 111, Ascii.CR, -70}, new byte[]{79, -20, 54, -2, -96, Ascii.GS, 107, -43}));
            long sp = TextUnitKt.getSp(24);
            FontFamily FontFamily = FontFamilyKt.FontFamily(FontKt.m6661FontYpTlLL0$default(R.font.playtone, (FontWeight) null, 0, 0, 14, (Object) null));
            long r2 = Color.Companion.m4276getWhite0d7_KjU();
            Modifier verticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxHeight(SizeKt.fillMaxWidth(Modifier.Companion, 0.8f), 0.8f), ScrollKt.rememberScrollState(0, composer2, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            Composer composer3 = composer;
            TextKt.m2692Text4IGK_g(StringFog.decrypt(new byte[]{19, -101, -11, -74, Ascii.CAN, -108, -91, Ascii.ETB, Base64.padSymbol, -108, -72, -89, 92, -35, -69, 88, 44, -100, -69, -91, 80, -97, -73, 91, 54, -122, -11, -93, 0, -115, -77, 86, 40, -43, -76, -74, 80, -119, -66, 82, 122, -127, -70, -78, 80, -110, -80, Ascii.ETB, 46, -99, -80, -30, 3, -98, -92, 82, Utf8.REPLACEMENT_BYTE, -101, -11, -93, Ascii.FS, -110, -72, 80, 122, -126, -68, -74, Ascii.CAN, -35, -73, Ascii.ETB, 46, -108, -89, -91, Ascii.NAK, -119, -10, 68, Utf8.REPLACEMENT_BYTE, -124, -96, -89, Ascii.RS, -98, -77, Ascii.ETB, 35, -102, -96, -30, Ascii.RS, -104, -77, 83, 122, -127, -70, -30, Ascii.GS, -100, -94, 84, 50, -37, -11, -106, 17, -115, -10, 67, 50, -112, -11, -79, 19, -113, -77, 82, 52, -43, -95, -83, 80, -111, -73, 66, 52, -106, -67, -30, 9, -110, -93, 69, 122, -105, -76, -82, Ascii.FS, -35, 52, -73, -50, -43, -68, -74, 80, -118, -65, 91, 54, -43, -77, -82, 9, -35, -93, 71, 45, -108, -89, -90, 80, -119, -71, SignedBytes.MAX_POWER_OF_TWO, 59, -121, -79, -30, 4, -107, -77, Ascii.ETB, 55, Byte.MIN_VALUE, -71, -74, Ascii.EM, -115, -70, 94, Utf8.REPLACEMENT_BYTE, -121, -90, -20, 80, -92, -71, 66, 40, -43, -78, -83, 17, -111, -10, 94, 41, -43, -95, -83, 80, -113, -77, 84, 40, -112, -76, -74, Ascii.NAK, -35, -94, 95, Utf8.REPLACEMENT_BYTE, -43, -80, -70, 17, -98, -94, Ascii.ETB, 41, -112, -92, -73, Ascii.NAK, -109, -75, 82, 122, -122, -67, -83, 7, -109, -10, 86, 56, -102, -93, -89, 94, -35, -126, 94, 55, -100, -69, -91, 80, -124, -71, 66, 40, -43, -90, -86, Ascii.US, -119, -91, Ascii.ETB, 59, -101, -79, -30, 17, -108, -69, 94, 52, -110, -11, -95, 17, -113, -77, 81, 47, -103, -71, -69, 80, -118, -65, 91, 54, -43, -67, -89, Ascii.FS, -115, -10, 78, 53, Byte.MIN_VALUE, -11, -86, Ascii.EM, -119, -10, 67, 50, -112, -11, -80, Ascii.EM, -102, -66, 67, 122, -104, -96, -82, 4, -108, -90, 91, 51, -112, -89, -79, 80, -100, -72, 83, 122, -106, -70, -81, 0, -111, -77, 67, Utf8.REPLACEMENT_BYTE, -43, -95, -86, Ascii.NAK, -35, -75, 88, 55, -105, -68, -84, 17, -119, -65, 88, 52, -43, -90, -73, 19, -98, -77, 68, 41, -109, -96, -82, Ascii.FS, -124, -8}, new byte[]{90, -11, -43, -62, 112, -3, -42, 55}), verticalScroll$default, r2, sp, (FontStyle) null, (FontWeight) null, FontFamily, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 3462, 0, 130992);
            Composer composer4 = composer3;
            Alignment center2 = Alignment.Companion.getCenter();
            float f = (float) 16;
            Modifier align = boxScope.align(BorderKt.m259borderxT4_qwU(BackgroundKt.background$default(SizeKt.fillMaxHeight(SizeKt.fillMaxWidth(Modifier.Companion, 0.9f), 0.1f), Brush.Companion.m4186verticalGradient8A3gB4$default(Brush.Companion, CollectionsKt.listOf(Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_1, composer4, 0)), Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_2, composer4, 0)), Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_3, composer4, 0))), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl(f)), 0.0f, 4, (Object) null), Dp.m7111constructorimpl((float) 2), ColorResources_androidKt.colorResource(R.color.seq_border, composer4, 0), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl(f))), Alignment.Companion.getTopCenter());
            ComposerKt.sourceInformationMarkerStart(composer4, 733328855, StringFog.decrypt(new byte[]{-64, 44, 33, -12, -7, 45, -55, -35, -85, 93, 37, -121, -70, 102, -55, -70, -79, 47, 58, -123, -82, 97, -84, -68, -80, 95, 51, -12, -7, 45, -50, -26, -9, 76, 59, -63, -91, 39, -122, -30}, new byte[]{-125, 111, 9, -74, -106, 85, -32, -115}));
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
            ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, StringFog.decrypt(new byte[]{-84, 68, -114, 106, 39, -125, 39, 33, -101, 46, -10, Ascii.SO, 103, -53, 100, 102, -58, 48, -97, 102, 117, -56, 120, 108, -93, 53, -107, 10, 126, -56, 8, 103, -36, 50, -97, 106, 114, -53, 121, 110, -93, 102, -33, 73, 51, -114, 102, Utf8.REPLACEMENT_BYTE, -101, 36, -98, Ascii.SYN, 43, -120, 46, 60}, new byte[]{-17, 7, -90, 38, 70, -6, 72, 84}));
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer4, align);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer4, -692256719, StringFog.decrypt(new byte[]{-47, -104, 80, -57, -2, -15, -110, 47, -16, -73, Ascii.GS, -42, -12, -23, -111, 33, -31, -66, 54, -6, -1, -31, -56, Ascii.RS, -70, -22, 84, -89, -78, -73, -42, 120, -46, -22, 76, -91, -83, -74, -83, 119, -88, -104, Ascii.ETB, -8, -21, -21, -110, 47, -16, -73, Ascii.GS, -26, -75, -17, -107, 109, -85, -78, Ascii.US, -1, -4, -12}, new byte[]{-110, -37, 120, -107, -101, -124, -31, 78}));
            if (!(composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer4.startReusableNode();
            if (composer4.getInserting()) {
                composer4.createNode(constructor2);
            } else {
                composer4.useNode();
            }
            Composer r52 = Updater.m3675constructorimpl(composer4);
            Updater.m3682setimpl(r52, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r52, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r52.getInserting() || !Intrinsics.areEqual(r52.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                r52.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                r52.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3682setimpl(r52, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, StringFog.decrypt(new byte[]{-101, -32, 113, -107, 58, -27, -10, 70, -108, -18, 120, -105, 102, -87, -22, Ascii.DC4, -84, -12, 112, -94, 58, -93, -94, Ascii.DLE}, new byte[]{-40, -41, 66, -43, 9, -47, -60, Byte.MAX_VALUE}));
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            TextKt.m2692Text4IGK_g(StringFog.decrypt(new byte[]{41, -51, -53, -57, Byte.MIN_VALUE, -64, 89, 107, Ascii.CR, -61, -59}, new byte[]{97, -94, -68, -25, -12, -81, 121, Ascii.ESC}), (Modifier) null, Color.Companion.m4276getWhite0d7_KjU(), TextUnitKt.getSp(32), (FontStyle) null, (FontWeight) null, FontFamilyKt.FontFamily(FontKt.m6661FontYpTlLL0$default(R.font.playtone, (FontWeight) null, 0, 0, 14, (Object) null)), 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 3462, 0, 130994);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer2.skipToGroupEnd();
    }
}
