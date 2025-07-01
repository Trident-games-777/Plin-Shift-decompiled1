package com.plinkofortune.cash.winspin.lostnework;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
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
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
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

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\u001a\u001b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005²\u0006\n\u0010\u0006\u001a\u00020\u0007X\u0002"}, d2 = {"LostNetworkScreen", "", "onReconnect", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_release", "alpha", ""}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: LostNetworkScreen.kt */
public final class LostNetworkScreenKt {
    /* access modifiers changed from: private */
    public static final Unit LostNetworkScreen$lambda$5(Function0 function0, int i, Composer composer, int i2) {
        LostNetworkScreen(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void LostNetworkScreen(Function0<Unit> function0, Composer composer, int i) {
        int i2;
        Function0<Unit> function02 = function0;
        int i3 = i;
        Intrinsics.checkNotNullParameter(function02, StringFog.decrypt(new byte[]{-34, 10, 4, Ascii.ETB, -120, -47, -2, 51, -44, 7, 34}, new byte[]{-79, 100, 86, 114, -21, -66, -112, 93}));
        Composer startRestartGroup = composer.startRestartGroup(-1711376864);
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1711376864, i2, -1, StringFog.decrypt(new byte[]{58, Ascii.SYN, -112, 62, 74, -103, -46, 101, 50, Ascii.SYN, -101, Byte.MAX_VALUE, 72, -127, -50, 101, 60, 87, -98, 113, 73, -99, -107, 124, 48, Ascii.ETB, -114, 96, 83, -101, -107, 103, 54, 10, -119, 126, 95, -126, -44, 121, 50, 87, -79, Byte.MAX_VALUE, 73, -127, -11, 110, 45, Ascii.SO, -110, 98, 81, -90, -40, 121, 60, Ascii.FS, -109, 48, Ascii.DC2, -71, -44, 120, 45, 55, -104, 100, 77, -102, -55, 96, 10, Ascii.SUB, -113, 117, 95, -101, -107, 96, 45, 67, -55, 35, 19}, new byte[]{89, 121, -3, Ascii.DLE, 58, -11, -69, Ascii.VT}));
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, StringFog.decrypt(new byte[]{110, 43, Ascii.NAK, -24, -73, -17, -103, 91, 94, 1, 91, -62, -73, -20, -91, 91, 78, 9, 67, -123, -77, -10, -54, Ascii.CR, 68, Ascii.SI, 69, -52, -88}, new byte[]{45, 104, 47, -85, -40, -126, -23, 52}));
            Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Context context = (Context) consume;
            State<Float> animateFloat = InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition((String) null, startRestartGroup, 0, 1), 1.0f, 0.0f, AnimationSpecKt.m151infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(1200, 0, (Easing) null, 6, (Object) null), RepeatMode.Reverse, 0, 4, (Object) null), (String) null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, StringFog.decrypt(new byte[]{58, -52, -126, -1, -55, 125, -70, 32, Ascii.ETB, -90, -6, -108, -108, Base64.padSymbol, -4, 97, 72, -90, -110, -118, -26, 37, -4, 126, 73, -61, -100, -115, -118, 41, -8, Ascii.CR, 77, -68, -109, -118, -22, 32, -4, 126, 67, -52, -59, -48, -45, 124, -95, 99, Ascii.DC2, -5, -119, -114, -47, 34, -67, 43, Ascii.SYN}, new byte[]{121, -113, -86, -68, -90, 17, -49, 77}));
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, StringFog.decrypt(new byte[]{87, Utf8.REPLACEMENT_BYTE, -76, 60, 46, 49, -109, 43, 96, 85, -52, 88, 110, 121, -48, 108, Base64.padSymbol, 75, -91, 48, 124, 122, -52, 102, 88, 78, -81, 92, 119, 122, -68, 109, 39, 73, -91, 60, 123, 121, -51, 100, 88, Ascii.GS, -27, Ascii.US, 58, 60, -46, 53, 96, 95, -92, SignedBytes.MAX_POWER_OF_TWO, 34, 58, -102, 54}, new byte[]{Ascii.DC4, 124, -100, 112, 79, 72, -4, 94}));
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, StringFog.decrypt(new byte[]{-3, -124, Ascii.NAK, -110, -67, 62, 110, 115, -36, -85, 88, -125, -73, 38, 109, 125, -51, -94, 115, -81, -68, 46, 52, 66, -106, -10, 17, -14, -15, 120, 42, 36, -2, -10, 9, -16, -18, 121, 81, 43, -124, -124, 82, -83, -88, 36, 110, 115, -36, -85, 88, -77, -10, 32, 105, 49, -121, -82, 90, -86, -65, 59}, new byte[]{-66, -57, Base64.padSymbol, -64, -40, 75, Ascii.GS, Ascii.DC2}));
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
            Updater.m3682setimpl(r10, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r10, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r10.getInserting() || !Intrinsics.areEqual(r10.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r10.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r10.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r10, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -384784025, StringFog.decrypt(new byte[]{-46, 35, 46, -109, -110, Ascii.RS, -97, -50, -35, 34, 44, -112, -55, 70, -34, -105, -1, 53, 125, -89, -123, Ascii.CAN, -36, -55, -29, 125, 121}, new byte[]{-111, Ascii.ESC, Ascii.SYN, -45, -90, 42, -85, -6}));
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            Composer composer2 = startRestartGroup;
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.deco, startRestartGroup, 0), (String) null, AlphaKt.alpha(SizeKt.m845size3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl((float) MenuKt.InTransitionDuration)), LostNetworkScreen$lambda$0(animateFloat)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer2, 48, (int) MenuKt.InTransitionDuration);
            Composer composer3 = composer2;
            float f = (float) 12;
            SpacerKt.Spacer(SizeKt.m831height3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f)), composer3, 6);
            Composer composer4 = composer3;
            Context context2 = context;
            int i4 = i2;
            TextKt.m2692Text4IGK_g(StringFog.decrypt(new byte[]{108, Ascii.SO, Ascii.FF, -78, -42, 62, -16, 47, 119, Ascii.SO, Ascii.CR, -83}, new byte[]{32, 65, 95, -26, -10, 112, -75, 123}), (Modifier) null, Color.Companion.m4276getWhite0d7_KjU(), TextUnitKt.getSp(32), (FontStyle) null, (FontWeight) null, FontFamilyKt.FontFamily(FontKt.m6661FontYpTlLL0$default(R.font.playtone, (FontWeight) null, 0, 0, 14, (Object) null)), 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 3462, 0, 130994);
            Composer composer5 = composer4;
            SpacerKt.Spacer(SizeKt.m831height3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f)), composer5, 6);
            Alignment center2 = Alignment.Companion.getCenter();
            Modifier r4 = SizeKt.m831height3ABfNKs(SizeKt.m850width3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl((float) 200)), Dp.m7111constructorimpl((float) 80));
            composer5.startReplaceGroup(1063303412);
            boolean changedInstance = composer5.changedInstance(context2) | ((i4 & 14) == 4);
            Object rememberedValue = composer5.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new LostNetworkScreenKt$$ExternalSyntheticLambda0(context2, function02);
                composer5.updateRememberedValue(rememberedValue);
            }
            composer5.endReplaceGroup();
            float f2 = (float) 16;
            Modifier r3 = BorderKt.m259borderxT4_qwU(BackgroundKt.background$default(MortalKt.mortal(r4, (Function0) rememberedValue), Brush.Companion.m4186verticalGradient8A3gB4$default(Brush.Companion, CollectionsKt.listOf(Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_1, composer5, 0)), Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_2, composer5, 0)), Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_3, composer5, 0))), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl(f2)), 0.0f, 4, (Object) null), Dp.m7111constructorimpl((float) 2), ColorResources_androidKt.colorResource(R.color.seq_border, composer5, 0), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl(f2)));
            ComposerKt.sourceInformationMarkerStart(composer5, 733328855, StringFog.decrypt(new byte[]{-95, 5, -67, 38, -29, -35, 35, -113, -54, 116, -71, 85, -96, -106, 35, -24, -48, 6, -90, 87, -76, -111, 70, -18, -47, 118, -81, 38, -29, -35, 36, -76, -106, 101, -89, 19, -65, -41, 108, -80}, new byte[]{-30, 70, -107, 100, -116, -91, 10, -33}));
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
            ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, StringFog.decrypt(new byte[]{-68, -101, 43, -77, -78, 111, 9, 35, -117, -15, 83, -41, -14, 39, 74, 100, -42, -17, 58, -65, -32, 36, 86, 110, -77, -22, 48, -45, -21, 36, 38, 101, -52, -19, 58, -77, -25, 39, 87, 108, -77, -71, 122, -112, -90, 98, 72, Base64.padSymbol, -117, -5, 59, -49, -66, 100, 0, 62}, new byte[]{-1, -40, 3, -1, -45, Ascii.SYN, 102, 86}));
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer5.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer5, r3);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer5, -692256719, StringFog.decrypt(new byte[]{6, -115, -17, 35, -10, -115, 48, 39, 39, -94, -94, 50, -4, -107, 51, 41, 54, -85, -119, Ascii.RS, -9, -99, 106, Ascii.SYN, 109, -1, -21, 67, -70, -53, 116, 112, 5, -1, -13, 65, -91, -54, Ascii.SI, Byte.MAX_VALUE, Byte.MAX_VALUE, -115, -88, Ascii.FS, -29, -105, 48, 39, 39, -94, -94, 2, -67, -109, 55, 101, 124, -89, -96, Ascii.ESC, -12, -120}, new byte[]{69, -50, -57, 113, -109, -8, 67, 70}));
            if (!(composer5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer5.startReusableNode();
            if (composer5.getInserting()) {
                composer5.createNode(constructor2);
            } else {
                composer5.useNode();
            }
            Composer r6 = Updater.m3675constructorimpl(composer5);
            Updater.m3682setimpl(r6, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r6, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r6.getInserting() || !Intrinsics.areEqual(r6.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                r6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                r6.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3682setimpl(r6, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, StringFog.decrypt(new byte[]{94, 50, 103, -19, -57, -95, Byte.MAX_VALUE, Ascii.FF, 81, 60, 110, -17, -101, -19, 99, 94, 105, 38, 102, -38, -57, -25, 43, 90}, new byte[]{Ascii.GS, 5, 84, -83, -12, -107, 77, 53}));
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            Composer composer6 = composer5;
            TextKt.m2692Text4IGK_g(StringFog.decrypt(new byte[]{-86, 5, 82, -39, -105, 74, 60, 42, -116}, new byte[]{-8, 96, 49, -74, -7, 36, 89, 73}), (Modifier) null, Color.Companion.m4276getWhite0d7_KjU(), TextUnitKt.getSp(26), (FontStyle) null, (FontWeight) null, FontFamilyKt.FontFamily(FontKt.m6661FontYpTlLL0$default(R.font.playtone, (FontWeight) null, 0, 0, 14, (Object) null)), 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer6, 3462, 0, 130994);
            startRestartGroup = composer6;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
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
            endRestartGroup.updateScope(new LostNetworkScreenKt$$ExternalSyntheticLambda1(function02, i3));
        }
    }

    /* access modifiers changed from: private */
    public static final Unit LostNetworkScreen$lambda$4$lambda$2$lambda$1(Context context, Function0 function0) {
        NetworkCapabilities networkCapabilities;
        Object systemService = context.getSystemService(StringFog.decrypt(new byte[]{38, -9, -38, -4, 124, 17, Ascii.RS, -19, 51, -15, -64, -21}, new byte[]{69, -104, -76, -110, Ascii.EM, 114, 106, -124}));
        Intrinsics.checkNotNull(systemService, StringFog.decrypt(new byte[]{98, -40, -101, 97, 111, 43, -24, -92, 98, -62, -125, 45, 45, 45, -87, -87, 109, -34, -125, 45, 59, 39, -87, -92, 99, -61, -38, 99, 58, 36, -27, -22, 120, -44, -121, 104, 111, 41, -25, -82, 126, -62, -98, 105, 97, 38, -20, -66, 34, -18, -104, 99, 33, 45, -22, -66, 101, -37, -98, 121, 54, 5, -24, -92, 109, -54, -110, Byte.MAX_VALUE}, new byte[]{Ascii.FF, -83, -9, Ascii.CR, 79, 72, -119, -54}));
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (!(activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null || (!networkCapabilities.hasTransport(4) && !networkCapabilities.hasTransport(1) && !networkCapabilities.hasTransport(3) && !networkCapabilities.hasTransport(0)))) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    private static final float LostNetworkScreen$lambda$0(State<Float> state) {
        return state.getValue().floatValue();
    }
}
