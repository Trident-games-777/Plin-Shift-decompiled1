package com.plinkofortune.cash.winspin.menu;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.ColorResources_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.core.location.LocationRequestCompat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.plinkofortune.cash.winspin.MortalKt;
import com.plinkofortune.cash.winspin.R;
import com.plinkofortune.cash.winspin.StringFog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aa\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"MenuScreen", "", "howToPlay", "Lkotlin/Function0;", "policy", "terms", "start", "profile", "leaders", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: MenuScreen.kt */
public final class MenuScreenKt {
    /* access modifiers changed from: private */
    public static final Unit MenuScreen$lambda$20(Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, Function0 function06, int i, Composer composer, int i2) {
        MenuScreen(function0, function02, function03, function04, function05, function06, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void MenuScreen(Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Function0<Unit> function04, Function0<Unit> function05, Function0<Unit> function06, Composer composer, int i) {
        int i2;
        Composer composer2;
        Function0<Unit> function07 = function0;
        Function0<Unit> function08 = function02;
        Function0<Unit> function09 = function03;
        Function0<Unit> function010 = function04;
        Function0<Unit> function011 = function05;
        Function0<Unit> function012 = function06;
        int i3 = i;
        Intrinsics.checkNotNullParameter(function07, StringFog.decrypt(new byte[]{-102, -67, -89, -49, 113, 76, 19, Ascii.VT, -117}, new byte[]{-14, -46, -48, -101, Ascii.RS, Ascii.FS, Byte.MAX_VALUE, 106}));
        Intrinsics.checkNotNullParameter(function08, StringFog.decrypt(new byte[]{92, -52, -45, -115, 118, -26}, new byte[]{44, -93, -65, -28, Ascii.NAK, -97, 121, -67}));
        Intrinsics.checkNotNullParameter(function09, StringFog.decrypt(new byte[]{-91, -92, 3, -91, -46}, new byte[]{-47, -63, 113, -56, -95, 72, Ascii.DC4, Ascii.NAK}));
        Intrinsics.checkNotNullParameter(function010, StringFog.decrypt(new byte[]{-49, -52, -88, 92, 109}, new byte[]{-68, -72, -55, 46, Ascii.EM, 104, -70, -88}));
        Intrinsics.checkNotNullParameter(function011, StringFog.decrypt(new byte[]{-50, Ascii.RS, -28, -16, Ascii.ETB, -94, -73}, new byte[]{-66, 108, -117, -106, 126, -50, -46, 2}));
        Intrinsics.checkNotNullParameter(function012, StringFog.decrypt(new byte[]{36, 90, 97, 70, 1, -21, 57}, new byte[]{72, Utf8.REPLACEMENT_BYTE, 0, 34, 100, -103, 74, 1}));
        Composer startRestartGroup = composer.startRestartGroup(1650765351);
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function07) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function08) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function09) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function010) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function011) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changedInstance(function012) ? 131072 : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1650765351, i2, -1, StringFog.decrypt(new byte[]{-122, Utf8.REPLACEMENT_BYTE, 96, 46, 68, -31, 47, -86, -114, Utf8.REPLACEMENT_BYTE, 107, 111, 70, -7, 51, -86, Byte.MIN_VALUE, 126, 110, 97, 71, -27, 104, -77, -116, 62, 126, 112, 93, -29, 104, -87, Byte.MIN_VALUE, 62, 120, 46, 121, -24, 40, -79, -74, 51, Byte.MAX_VALUE, 101, 81, -29, 102, -20, -88, 53, 99, 117, 103, -18, 52, -95, Byte.MIN_VALUE, 62, 35, 107, SignedBytes.MAX_POWER_OF_TWO, -73, 114, -15, -52}, new byte[]{-27, 80, Ascii.CR, 0, 52, -115, 70, -60}));
            }
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            float f = (float) 20;
            Arrangement.Vertical r11 = Arrangement.INSTANCE.m625spacedByD5KLDUw(Dp.m7111constructorimpl(f), Alignment.Companion.getCenterVertically());
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, StringFog.decrypt(new byte[]{-21, -71, 99, -125, 86, -122, -48, 89, -58, -45, Ascii.ESC, -24, Ascii.VT, -58, -106, Ascii.CAN, -103, -45, 115, -10, 121, -34, -106, 7, -104, -74, 125, -15, Ascii.NAK, -46, -110, 116, -100, -55, 114, -10, 117, -37, -106, 7, -110, -71, 36, -84, 76, -121, -53, Ascii.SUB, -61, -114, 104, -14, 78, -39, -41, 82, -57}, new byte[]{-88, -6, 75, -64, 57, -22, -91, 52}));
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(r11, centerHorizontally, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, StringFog.decrypt(new byte[]{Ascii.SI, -64, -110, 105, 106, 83, 45, -118, 56, -86, -22, Ascii.CR, 42, Ascii.ESC, 110, -51, 101, -76, -125, 101, 56, Ascii.CAN, 114, -57, 0, -79, -119, 9, 51, Ascii.CAN, 2, -52, Byte.MAX_VALUE, -74, -125, 105, Utf8.REPLACEMENT_BYTE, Ascii.ESC, 115, -59, 0, -30, -61, 74, 126, 94, 108, -108, 56, -96, -126, Ascii.NAK, 102, 88, 36, -105}, new byte[]{76, -125, -70, 37, Ascii.VT, 42, 66, -1}));
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            float f2 = f;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, StringFog.decrypt(new byte[]{93, 87, 115, -98, -47, -7, 72, -58, 124, 120, 62, -113, -37, -31, 75, -56, 109, 113, Ascii.NAK, -93, -48, -23, Ascii.DC2, -9, 54, 37, 119, -2, -99, -65, Ascii.FF, -111, 94, 37, 111, -4, -126, -66, 119, -98, 36, 87, 52, -95, -60, -29, 72, -58, 124, 120, 62, -65, -102, -25, 79, -124, 39, 125, 60, -90, -45, -4}, new byte[]{Ascii.RS, Ascii.DC4, 91, -52, -76, -116, 59, -89}));
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r7 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r7, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r7, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r7.getInserting() || !Intrinsics.areEqual(r7.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r7.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r7, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -384784025, StringFog.decrypt(new byte[]{101, 52, -78, -61, -126, -62, 60, Ascii.FF, 106, 53, -80, -64, -39, -102, 125, 85, 72, 34, -31, -9, -107, -60, Byte.MAX_VALUE, Ascii.VT, 84, 106, -27}, new byte[]{38, Ascii.FF, -118, -125, -74, -10, 8, 56}));
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            Alignment center = Alignment.Companion.getCenter();
            float f3 = (float) 240;
            float f4 = (float) 60;
            Modifier r8 = SizeKt.m831height3ABfNKs(SizeKt.m850width3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f3)), Dp.m7111constructorimpl(f4));
            startRestartGroup.startReplaceGroup(-620368068);
            boolean z = (i2 & 14) == 4;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new MenuScreenKt$$ExternalSyntheticLambda0(function07);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            float f5 = (float) 16;
            float f6 = (float) 2;
            float f7 = f5;
            float f8 = f3;
            Modifier r1 = BorderKt.m259borderxT4_qwU(BackgroundKt.background$default(MortalKt.mortal(r8, (Function0) rememberedValue), Brush.Companion.m4186verticalGradient8A3gB4$default(Brush.Companion, CollectionsKt.listOf(Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_1, startRestartGroup, 0)), Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_2, startRestartGroup, 0)), Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_3, startRestartGroup, 0))), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl(f5)), 0.0f, 4, (Object) null), Dp.m7111constructorimpl(f6), ColorResources_androidKt.colorResource(R.color.seq_border, startRestartGroup, 0), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl(f7)));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, StringFog.decrypt(new byte[]{-84, -106, -23, 109, Ascii.VT, 92, -106, -43, -57, -25, -19, Ascii.RS, 72, Ascii.ETB, -106, -78, -35, -107, -14, Ascii.FS, 92, Ascii.DLE, -13, -76, -36, -27, -5, 109, Ascii.VT, 92, -111, -18, -101, -10, -13, 88, 87, 86, -39, -22}, new byte[]{-17, -43, -63, 47, 100, 36, -65, -123}));
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, StringFog.decrypt(new byte[]{-123, -2, -69, 93, 107, Utf8.REPLACEMENT_BYTE, -41, -58, -78, -108, -61, 57, 43, 119, -108, -127, -17, -118, -86, 81, 57, 116, -120, -117, -118, -113, -96, Base64.padSymbol, 50, 116, -8, Byte.MIN_VALUE, -11, -120, -86, 93, 62, 119, -119, -119, -118, -36, -22, 126, Byte.MAX_VALUE, 50, -106, -40, -78, -98, -85, 33, 103, 52, -34, -37}, new byte[]{-58, -67, -109, 17, 10, 70, -72, -77}));
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, r1);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            int i4 = currentCompositeKeyHash2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, StringFog.decrypt(new byte[]{-69, Ascii.DC4, -29, 59, -31, -47, -49, 47, -102, 59, -82, 42, -21, -55, -52, 33, -117, 50, -123, 6, -32, -63, -107, Ascii.RS, -48, 102, -25, 91, -83, -105, -117, 120, -72, 102, -1, 89, -78, -106, -16, 119, -62, Ascii.DC4, -92, 4, -12, -53, -49, 47, -102, 59, -82, Ascii.SUB, -86, -49, -56, 109, -63, 62, -84, 3, -29, -44}, new byte[]{-8, 87, -53, 105, -124, -92, -68, 78}));
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer r82 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r82, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r82, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r82.getInserting() || !Intrinsics.areEqual(r82.rememberedValue(), (Object) Integer.valueOf(i4))) {
                r82.updateRememberedValue(Integer.valueOf(i4));
                r82.apply(Integer.valueOf(i4), setCompositeKeyHash2);
            }
            Updater.m3682setimpl(r82, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, StringFog.decrypt(new byte[]{-106, 111, 17, -88, -6, Ascii.SYN, -80, 109, -103, 97, Ascii.CAN, -86, -90, 90, -84, Utf8.REPLACEMENT_BYTE, -95, 123, Ascii.DLE, -97, -6, 80, -28, 59}, new byte[]{-43, 88, 34, -24, -55, 34, -126, 84}));
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            float f9 = f8;
            float f10 = f6;
            float f11 = f4;
            float f12 = f2;
            Composer composer3 = startRestartGroup;
            TextKt.m2692Text4IGK_g(StringFog.decrypt(new byte[]{Ascii.DC2, -24, 87, 39, -110, -79, 4, -22, 54, -26, 89}, new byte[]{90, -121, 32, 7, -26, -34, 36, -102}), (Modifier) null, Color.Companion.m4276getWhite0d7_KjU(), TextUnitKt.getSp(28), (FontStyle) null, (FontWeight) null, FontFamilyKt.FontFamily(FontKt.m6661FontYpTlLL0$default(R.font.playtone, (FontWeight) null, 0, 0, 14, (Object) null)), 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 3462, 0, 130994);
            Composer composer4 = composer3;
            ComposerKt.sourceInformationMarkerEnd(composer4);
            composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            Alignment center2 = Alignment.Companion.getCenter();
            Modifier r10 = SizeKt.m831height3ABfNKs(SizeKt.m850width3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f9)), Dp.m7111constructorimpl(f11));
            composer4.startReplaceGroup(-620337287);
            boolean z2 = (i2 & 112) == 32;
            Object rememberedValue2 = composer4.rememberedValue();
            if (z2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new MenuScreenKt$$ExternalSyntheticLambda1(function08);
                composer4.updateRememberedValue(rememberedValue2);
            }
            composer4.endReplaceGroup();
            Modifier r102 = BorderKt.m259borderxT4_qwU(BackgroundKt.background$default(MortalKt.mortal(r10, (Function0) rememberedValue2), Brush.Companion.m4186verticalGradient8A3gB4$default(Brush.Companion, CollectionsKt.listOf(Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_1, composer4, 0)), Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_2, composer4, 0)), Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_3, composer4, 0))), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl(f7)), 0.0f, 4, (Object) null), Dp.m7111constructorimpl(f10), ColorResources_androidKt.colorResource(R.color.seq_border, composer4, 0), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl(f7)));
            ComposerKt.sourceInformationMarkerStart(composer4, 733328855, StringFog.decrypt(new byte[]{69, -17, 69, -5, 90, 90, 84, 106, 46, -98, 65, -120, Ascii.EM, 17, 84, Ascii.CR, 52, -20, 94, -118, Ascii.CR, Ascii.SYN, 49, Ascii.VT, 53, -100, 87, -5, 90, 90, 83, 81, 114, -113, 95, -50, 6, 80, Ascii.ESC, 85}, new byte[]{6, -84, 109, -71, 53, 34, 125, 58}));
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
            ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, StringFog.decrypt(new byte[]{-120, 107, 116, -94, Ascii.EM, 80, 44, -56, -65, 1, Ascii.FF, -58, 89, Ascii.CAN, 111, -113, -30, Ascii.US, 101, -82, 75, Ascii.ESC, 115, -123, -121, Ascii.SUB, 111, -62, SignedBytes.MAX_POWER_OF_TWO, Ascii.ESC, 3, -114, -8, Ascii.GS, 101, -94, 76, Ascii.CAN, 114, -121, -121, 73, 37, -127, Ascii.CR, 93, 109, -42, -65, Ascii.VT, 100, -34, Ascii.NAK, 91, 37, -43}, new byte[]{-53, 40, 92, -18, 120, 41, 67, -67}));
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer4.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer4, r102);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer4, -692256719, StringFog.decrypt(new byte[]{58, Byte.MAX_VALUE, 80, -63, 122, -124, -51, 52, Ascii.ESC, 80, Ascii.GS, -48, 112, -100, -50, 58, 10, 89, 54, -4, 123, -108, -105, 5, 81, Ascii.CR, 84, -95, 54, -62, -119, 99, 57, Ascii.CR, 76, -93, 41, -61, -14, 108, 67, Byte.MAX_VALUE, Ascii.ETB, -2, 111, -98, -51, 52, Ascii.ESC, 80, Ascii.GS, -32, 49, -102, -54, 118, SignedBytes.MAX_POWER_OF_TWO, 85, Ascii.US, -7, 120, -127}, new byte[]{121, 60, 120, -109, Ascii.US, -15, -66, 85}));
            if (!(composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer4.startReusableNode();
            if (composer4.getInserting()) {
                composer4.createNode(constructor3);
            } else {
                composer4.useNode();
            }
            Composer r12 = Updater.m3675constructorimpl(composer4);
            Updater.m3682setimpl(r12, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r12, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r12.getInserting() || !Intrinsics.areEqual(r12.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash3))) {
                r12.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                r12.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3682setimpl(r12, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, StringFog.decrypt(new byte[]{-91, 6, -50, 118, 36, 60, -100, -116, -86, 8, -57, 116, 120, 112, Byte.MIN_VALUE, -34, -110, Ascii.DC2, -49, 65, 36, 122, -56, -38}, new byte[]{-26, 49, -3, 54, Ascii.ETB, 8, -82, -75}));
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            Composer composer5 = composer4;
            TextKt.m2692Text4IGK_g(StringFog.decrypt(new byte[]{-112, 32, 47, 124, -41, -35, 109, 53, -112, Base64.padSymbol, 42, 99, -43, -57}, new byte[]{-64, 82, 70, 10, -74, -66, Ascii.DC4, Ascii.NAK}), (Modifier) null, Color.Companion.m4276getWhite0d7_KjU(), TextUnitKt.getSp(28), (FontStyle) null, (FontWeight) null, FontFamilyKt.FontFamily(FontKt.m6661FontYpTlLL0$default(R.font.playtone, (FontWeight) null, 0, 0, 14, (Object) null)), 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer5, 3462, 0, 130994);
            Composer composer6 = composer5;
            ComposerKt.sourceInformationMarkerEnd(composer6);
            composer6.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer6);
            ComposerKt.sourceInformationMarkerEnd(composer6);
            ComposerKt.sourceInformationMarkerEnd(composer6);
            Alignment center3 = Alignment.Companion.getCenter();
            Modifier r72 = SizeKt.m831height3ABfNKs(SizeKt.m850width3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f9)), Dp.m7111constructorimpl(f11));
            composer6.startReplaceGroup(-620306504);
            boolean z3 = (i2 & 896) == 256;
            Object rememberedValue3 = composer6.rememberedValue();
            if (z3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new MenuScreenKt$$ExternalSyntheticLambda2(function09);
                composer6.updateRememberedValue(rememberedValue3);
            }
            composer6.endReplaceGroup();
            Modifier r73 = BorderKt.m259borderxT4_qwU(BackgroundKt.background$default(MortalKt.mortal(r72, (Function0) rememberedValue3), Brush.Companion.m4186verticalGradient8A3gB4$default(Brush.Companion, CollectionsKt.listOf(Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_1, composer6, 0)), Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_2, composer6, 0)), Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_3, composer6, 0))), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl(f7)), 0.0f, 4, (Object) null), Dp.m7111constructorimpl(f10), ColorResources_androidKt.colorResource(R.color.seq_border, composer6, 0), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl(f7)));
            ComposerKt.sourceInformationMarkerStart(composer6, 733328855, StringFog.decrypt(new byte[]{112, 89, -45, -51, Ascii.DC2, -44, 46, 104, Ascii.ESC, 40, -41, -66, 81, -97, 46, Ascii.SI, 1, 90, -56, -68, 69, -104, 75, 9, 0, 42, -63, -51, Ascii.DC2, -44, 41, 83, 71, 57, -55, -8, 78, -34, 97, 87}, new byte[]{51, Ascii.SUB, -5, -113, 125, -84, 7, 56}));
            MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center3, false);
            ComposerKt.sourceInformationMarkerStart(composer6, -1323940314, StringFog.decrypt(new byte[]{-13, -73, 34, -12, 83, -57, -112, Ascii.SI, -60, -35, 90, -112, 19, -113, -45, 72, -103, -61, 51, -8, 1, -116, -49, 66, -4, -58, 57, -108, 10, -116, -65, 73, -125, -63, 51, -12, 6, -113, -50, SignedBytes.MAX_POWER_OF_TWO, -4, -107, 115, -41, 71, -54, -47, 17, -60, -41, 50, -120, 95, -52, -103, Ascii.DC2}, new byte[]{-80, -12, 10, -72, 50, -66, -1, 122}));
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composer6.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer6, r73);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer6, -692256719, StringFog.decrypt(new byte[]{Ascii.RS, -19, Ascii.VT, -87, -90, 44, 51, 96, Utf8.REPLACEMENT_BYTE, -62, 70, -72, -84, 52, 48, 110, 46, -53, 109, -108, -89, 60, 105, 81, 117, -97, Ascii.SI, -55, -22, 106, 119, 55, Ascii.GS, -97, Ascii.ETB, -53, -11, 107, Ascii.FF, 56, 103, -19, 76, -106, -77, 54, 51, 96, Utf8.REPLACEMENT_BYTE, -62, 70, -120, -19, 50, 52, 34, 100, -57, 68, -111, -92, 41}, new byte[]{93, -82, 35, -5, -61, 89, SignedBytes.MAX_POWER_OF_TWO, 1}));
            if (!(composer6.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer6.startReusableNode();
            if (composer6.getInserting()) {
                composer6.createNode(constructor4);
            } else {
                composer6.useNode();
            }
            Composer r112 = Updater.m3675constructorimpl(composer6);
            Updater.m3682setimpl(r112, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r112, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r112.getInserting() || !Intrinsics.areEqual(r112.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash4))) {
                r112.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                r112.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m3682setimpl(r112, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer6, -2146769399, StringFog.decrypt(new byte[]{95, -101, -104, 115, -2, -22, 44, -82, 80, -107, -111, 113, -94, -90, 48, -4, 104, -113, -103, 68, -2, -84, 120, -8}, new byte[]{Ascii.FS, -84, -85, 51, -51, -34, Ascii.RS, -105}));
            BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
            Composer composer7 = composer6;
            TextKt.m2692Text4IGK_g(StringFog.decrypt(new byte[]{Ascii.SUB, -115, 49, -116, 116, 122, -52, 4, 110, -67, 48, -124}, new byte[]{78, -24, 67, -31, 7, 90, -125, 98}), (Modifier) null, Color.Companion.m4276getWhite0d7_KjU(), TextUnitKt.getSp(28), (FontStyle) null, (FontWeight) null, FontFamilyKt.FontFamily(FontKt.m6661FontYpTlLL0$default(R.font.playtone, (FontWeight) null, 0, 0, 14, (Object) null)), 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer7, 3462, 0, 130994);
            Composer composer8 = composer7;
            ComposerKt.sourceInformationMarkerEnd(composer8);
            composer8.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer8);
            ComposerKt.sourceInformationMarkerEnd(composer8);
            ComposerKt.sourceInformationMarkerEnd(composer8);
            Alignment center4 = Alignment.Companion.getCenter();
            Modifier r74 = SizeKt.m831height3ABfNKs(SizeKt.m850width3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f9)), Dp.m7111constructorimpl(f11));
            composer8.startReplaceGroup(-620275814);
            boolean z4 = (458752 & i2) == 131072;
            Object rememberedValue4 = composer8.rememberedValue();
            if (z4 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new MenuScreenKt$$ExternalSyntheticLambda3(function012);
                composer8.updateRememberedValue(rememberedValue4);
            }
            composer8.endReplaceGroup();
            Modifier r75 = BorderKt.m259borderxT4_qwU(BackgroundKt.background$default(MortalKt.mortal(r74, (Function0) rememberedValue4), Brush.Companion.m4186verticalGradient8A3gB4$default(Brush.Companion, CollectionsKt.listOf(Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_1, composer8, 0)), Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_2, composer8, 0)), Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_3, composer8, 0))), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl(f7)), 0.0f, 4, (Object) null), Dp.m7111constructorimpl(f10), ColorResources_androidKt.colorResource(R.color.seq_border, composer8, 0), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl(f7)));
            ComposerKt.sourceInformationMarkerStart(composer8, 733328855, StringFog.decrypt(new byte[]{121, 49, 93, Ascii.DC4, 95, 56, 102, Ascii.NAK, Ascii.DC2, SignedBytes.MAX_POWER_OF_TWO, 89, 103, Ascii.FS, 115, 102, 114, 8, 50, 70, 101, 8, 116, 3, 116, 9, 66, 79, Ascii.DC4, 95, 56, 97, 46, 78, 81, 71, 33, 3, 50, 41, 42}, new byte[]{58, 114, 117, 86, 48, SignedBytes.MAX_POWER_OF_TWO, 79, 69}));
            MeasurePolicy maybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(center4, false);
            ComposerKt.sourceInformationMarkerStart(composer8, -1323940314, StringFog.decrypt(new byte[]{-67, -53, -8, -119, 125, -65, -2, 57, -118, -95, Byte.MIN_VALUE, -19, Base64.padSymbol, -9, -67, 126, -41, -65, -23, -123, 47, -12, -95, 116, -78, -70, -29, -23, 36, -12, -47, Byte.MAX_VALUE, -51, -67, -23, -119, 40, -9, -96, 118, -78, -23, -87, -86, 105, -78, -65, 39, -118, -85, -24, -11, 113, -76, -9, 36}, new byte[]{-2, -120, -48, -59, Ascii.FS, -58, -111, 76}));
            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer8, 0);
            CompositionLocalMap currentCompositionLocalMap5 = composer8.getCurrentCompositionLocalMap();
            Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(composer8, r75);
            Function0<ComposeUiNode> constructor5 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer8, -692256719, StringFog.decrypt(new byte[]{92, 6, 50, -121, -48, 3, -53, -8, 125, 41, Byte.MAX_VALUE, -106, -38, Ascii.ESC, -56, -10, 108, 32, 84, -70, -47, 19, -111, -55, 55, 116, 54, -25, -100, 69, -113, -81, 95, 116, 46, -27, -125, 68, -12, -96, 37, 6, 117, -72, -59, Ascii.EM, -53, -8, 125, 41, Byte.MAX_VALUE, -90, -101, Ascii.GS, -52, -70, 38, 44, 125, -65, -46, 6}, new byte[]{Ascii.US, 69, Ascii.SUB, -43, -75, 118, -72, -103}));
            if (!(composer8.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer8.startReusableNode();
            if (composer8.getInserting()) {
                composer8.createNode(constructor5);
            } else {
                composer8.useNode();
            }
            Composer r113 = Updater.m3675constructorimpl(composer8);
            Updater.m3682setimpl(r113, maybeCachedBoxMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r113, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r113.getInserting() || !Intrinsics.areEqual(r113.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash5))) {
                r113.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                r113.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
            }
            Updater.m3682setimpl(r113, materializeModifier5, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer8, -2146769399, StringFog.decrypt(new byte[]{Ascii.CR, -94, -118, -39, 108, 78, 70, -33, 2, -84, -125, -37, 48, 2, 90, -115, 58, -74, -117, -18, 108, 8, Ascii.DC2, -119}, new byte[]{78, -107, -71, -103, 95, 122, 116, -26}));
            BoxScope boxScope4 = BoxScopeInstance.INSTANCE;
            Composer composer9 = composer8;
            TextKt.m2692Text4IGK_g(StringFog.decrypt(new byte[]{43, 33, 52, 97, -38, -7, -113}, new byte[]{103, 68, 85, 5, -65, -117, -4, 87}), (Modifier) null, Color.Companion.m4276getWhite0d7_KjU(), TextUnitKt.getSp(28), (FontStyle) null, (FontWeight) null, FontFamilyKt.FontFamily(FontKt.m6661FontYpTlLL0$default(R.font.playtone, (FontWeight) null, 0, 0, 14, (Object) null)), 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer9, 3462, 0, 130994);
            Composer composer10 = composer9;
            ComposerKt.sourceInformationMarkerEnd(composer10);
            composer10.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer10);
            ComposerKt.sourceInformationMarkerEnd(composer10);
            ComposerKt.sourceInformationMarkerEnd(composer10);
            Modifier r13 = SizeKt.m831height3ABfNKs(SizeKt.m850width3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl((float) 200)), Dp.m7111constructorimpl((float) 80));
            composer10.startReplaceGroup(-620246792);
            boolean z5 = (i2 & 7168) == 2048;
            Object rememberedValue5 = composer10.rememberedValue();
            if (z5 || rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = new MenuScreenKt$$ExternalSyntheticLambda4(function010);
                composer10.updateRememberedValue(rememberedValue5);
            }
            composer10.endReplaceGroup();
            BoxKt.Box(PainterModifierKt.paint$default(MortalKt.mortal(r13, (Function0) rememberedValue5), PainterResources_androidKt.painterResource(R.drawable.start_btn, composer10, 0), false, (Alignment) null, ContentScale.Companion.getFillBounds(), 0.0f, (ColorFilter) null, 54, (Object) null), composer10, 0);
            ComposerKt.sourceInformationMarkerEnd(composer10);
            composer10.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer10);
            ComposerKt.sourceInformationMarkerEnd(composer10);
            ComposerKt.sourceInformationMarkerEnd(composer10);
            Modifier fillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer10, 733328855, StringFog.decrypt(new byte[]{98, 69, -3, -100, 41, -77, -44, 2, 9, 52, -7, -17, 106, -8, -44, 101, 19, 70, -26, -19, 126, -1, -79, 99, Ascii.DC2, 54, -17, -100, 41, -77, -45, 57, 85, 37, -25, -87, 117, -71, -101, Base64.padSymbol}, new byte[]{33, 6, -43, -34, 70, -53, -3, 82}));
            MeasurePolicy maybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer10, -1323940314, StringFog.decrypt(new byte[]{-91, -28, Ascii.RS, -13, -79, Ascii.DC2, 59, Ascii.NAK, -110, -114, 102, -105, -15, 90, 120, 82, -49, -112, Ascii.SI, -1, -29, 89, 100, 88, -86, -107, 5, -109, -24, 89, Ascii.DC4, 83, -43, -110, Ascii.SI, -13, -28, 90, 101, 90, -86, -58, 79, -48, -91, Ascii.US, 122, Ascii.VT, -110, -124, Ascii.SO, -113, -67, Ascii.EM, 50, 8}, new byte[]{-26, -89, 54, -65, -48, 107, 84, 96}));
            int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(composer10, 0);
            CompositionLocalMap currentCompositionLocalMap6 = composer10.getCurrentCompositionLocalMap();
            Modifier materializeModifier6 = ComposedModifierKt.materializeModifier(composer10, fillMaxSize$default2);
            Function0<ComposeUiNode> constructor6 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer10, -692256719, StringFog.decrypt(new byte[]{38, -23, 34, 78, 81, -77, -64, -114, 7, -58, 111, 95, 91, -85, -61, Byte.MIN_VALUE, Ascii.SYN, -49, 68, 115, 80, -93, -102, -65, 77, -101, 38, 46, Ascii.GS, -11, -124, -39, 37, -101, 62, 44, 2, -12, -1, -42, 95, -23, 101, 113, 68, -87, -64, -114, 7, -58, 111, 111, Ascii.SUB, -83, -57, -52, 92, -61, 109, 118, 83, -74}, new byte[]{101, -86, 10, Ascii.FS, 52, -58, -77, -17}));
            if (!(composer10.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer10.startReusableNode();
            if (composer10.getInserting()) {
                composer10.createNode(constructor6);
            } else {
                composer10.useNode();
            }
            Composer r114 = Updater.m3675constructorimpl(composer10);
            Updater.m3682setimpl(r114, maybeCachedBoxMeasurePolicy5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r114, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r114.getInserting() || !Intrinsics.areEqual(r114.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash6))) {
                r114.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                r114.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
            }
            Updater.m3682setimpl(r114, materializeModifier6, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer10, -2146769399, StringFog.decrypt(new byte[]{-26, 50, -59, Ascii.ETB, -31, -16, 55, 10, -23, 60, -52, Ascii.NAK, -67, -68, 43, 88, -47, 38, -60, 32, -31, -74, 99, 92}, new byte[]{-91, 5, -10, 87, -46, -60, 5, 51}));
            BoxScope boxScope5 = BoxScopeInstance.INSTANCE;
            Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.settings_tools, composer10, 0);
            ContentScale fillBounds = ContentScale.Companion.getFillBounds();
            Modifier r83 = OffsetKt.m733offsetVpY3zN4(boxScope5.align(SizeKt.m845size3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f11)), Alignment.Companion.getTopEnd()), Dp.m7111constructorimpl(-Dp.m7111constructorimpl(f12)), Dp.m7111constructorimpl(f12));
            composer10.startReplaceGroup(-620226182);
            boolean z6 = (i2 & 57344) == 16384;
            Object rememberedValue6 = composer10.rememberedValue();
            if (z6 || rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = new MenuScreenKt$$ExternalSyntheticLambda5(function011);
                composer10.updateRememberedValue(rememberedValue6);
            }
            composer10.endReplaceGroup();
            Composer composer11 = composer10;
            ImageKt.Image(painterResource, (String) null, MortalKt.mortal(r83, (Function0) rememberedValue6), (Alignment) null, fillBounds, 0.0f, (ColorFilter) null, composer11, 24624, (int) LocationRequestCompat.QUALITY_LOW_POWER);
            Composer composer12 = composer11;
            Modifier navigationBarsPadding = WindowInsetsPadding_androidKt.navigationBarsPadding(boxScope5.align(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getBottomCenter()));
            composer12.startReplaceGroup(-620218857);
            Object rememberedValue7 = composer12.rememberedValue();
            if (rememberedValue7 == Composer.Companion.getEmpty()) {
                rememberedValue7 = new MenuScreenKt$$ExternalSyntheticLambda6();
                composer12.updateRememberedValue(rememberedValue7);
            }
            composer12.endReplaceGroup();
            AndroidView_androidKt.AndroidView((Function1) rememberedValue7, navigationBarsPadding, (Function1) null, composer12, 6, 4);
            composer2 = composer12;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new MenuScreenKt$$ExternalSyntheticLambda7(function0, function08, function09, function010, function011, function012, i));
        }
    }

    /* access modifiers changed from: private */
    public static final Unit MenuScreen$lambda$14$lambda$1$lambda$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit MenuScreen$lambda$14$lambda$4$lambda$3(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit MenuScreen$lambda$14$lambda$7$lambda$6(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit MenuScreen$lambda$14$lambda$10$lambda$9(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit MenuScreen$lambda$14$lambda$13$lambda$12(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit MenuScreen$lambda$19$lambda$16$lambda$15(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final AdView MenuScreen$lambda$19$lambda$18$lambda$17(Context context) {
        Intrinsics.checkNotNullParameter(context, StringFog.decrypt(new byte[]{109, -7, 109, -37, Base64.padSymbol, 7, Ascii.SYN}, new byte[]{Ascii.SO, -106, 3, -81, 88, Byte.MAX_VALUE, 98, 55}));
        AdView adView = new AdView(context);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(StringFog.decrypt(new byte[]{-80, 105, 55, Ascii.CR, -94, -57, -71, Ascii.FF, -90, 106, 55, 95, -21, -125, -92, 78, -26, 62, 42, 85, -21, -114, -96, 78, -26, 60, 46, 67, -21, -123, -91, 72, -26, 48, 35, 91, -26, -122}, new byte[]{-45, 8, Ascii.SUB, 108, -46, -73, -108, 124}));
        adView.loadAd(new AdRequest.Builder().build());
        return adView;
    }
}
