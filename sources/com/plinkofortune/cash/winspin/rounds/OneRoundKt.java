package com.plinkofortune.cash.winspin.rounds;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
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
import androidx.core.location.LocationRequestCompat;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.plinkofortune.cash.winspin.MortalKt;
import com.plinkofortune.cash.winspin.R;
import com.plinkofortune.cash.winspin.StringFog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"OneRound", "", "round", "Lcom/plinkofortune/cash/winspin/rounds/RoundModel;", "mortal", "Lkotlin/Function0;", "(Lcom/plinkofortune/cash/winspin/rounds/RoundModel;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: OneRound.kt */
public final class OneRoundKt {
    /* access modifiers changed from: private */
    public static final Unit OneRound$lambda$5(RoundModel roundModel, Function0 function0, int i, Composer composer, int i2) {
        OneRound(roundModel, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void OneRound(RoundModel roundModel, Function0<Unit> function0, Composer composer, int i) {
        int i2;
        float f;
        int i3;
        int i4;
        RoundModel roundModel2 = roundModel;
        Function0<Unit> function02 = function0;
        int i5 = i;
        Intrinsics.checkNotNullParameter(roundModel2, StringFog.decrypt(new byte[]{7, -101, -62, -66, -42}, new byte[]{117, -12, -73, -48, -78, 32, 67, -100}));
        Intrinsics.checkNotNullParameter(function02, StringFog.decrypt(new byte[]{69, -18, -84, -64, 83, -56}, new byte[]{40, -127, -34, -76, 50, -92, 47, -63}));
        Composer startRestartGroup = composer.startRestartGroup(1899108504);
        if ((i5 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) roundModel2) ? 4 : 2) | i5;
        } else {
            i2 = i5;
        }
        if ((i5 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1899108504, i2, -1, StringFog.decrypt(new byte[]{-93, 118, -89, -4, Ascii.ESC, 80, -5, -13, -85, 118, -84, -67, Ascii.EM, 72, -25, -13, -91, 55, -87, -77, Ascii.CAN, 84, -68, -22, -87, 119, -71, -94, 2, 82, -68, -17, -81, 108, -92, -74, Ascii.CAN, Ascii.DC2, -35, -13, -91, 75, -91, -89, 5, 88, -78, -75, -113, 119, -81, Byte.MIN_VALUE, 4, 73, -4, -7, -18, 114, -66, -24, 89, 5, -69}, new byte[]{-64, Ascii.EM, -54, -46, 107, 60, -110, -99}));
            }
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            float f2 = (float) 100;
            Modifier r10 = SizeKt.m831height3ABfNKs(SizeKt.m850width3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl((float) 150)), Dp.m7111constructorimpl(f2));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, StringFog.decrypt(new byte[]{-15, -45, -31, Ascii.SO, -5, -90, 50, 51, -102, -94, -27, 109, -72, -30, 50, 90, -117, -48, -4, 108, -91, -23, 87, 86, -118, -68, -8, 108, -92, -111, 46, 83, -118, -95, -123, 109, -89, -31, 33, 49, -35, -25, -25, 55, -32, -14, 41, Ascii.DC4, -127, -30, -81, 51}, new byte[]{-78, -112, -55, 92, -108, -47, Ascii.ESC, 99}));
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, StringFog.decrypt(new byte[]{78, Ascii.SUB, 3, 80, -104, -12, 54, -18, 121, 112, 123, 52, -40, -68, 117, -87, 36, 110, Ascii.DC2, 92, -54, -65, 105, -93, 65, 107, Ascii.CAN, 48, -63, -65, Ascii.EM, -88, 62, 108, Ascii.DC2, 80, -51, -68, 104, -95, 65, 56, 82, 115, -116, -7, 119, -16, 121, 122, 19, 44, -108, -1, Utf8.REPLACEMENT_BYTE, -13}, new byte[]{Ascii.CR, 89, 43, Ascii.FS, -7, -115, 89, -101}));
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, r10);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, StringFog.decrypt(new byte[]{-65, Ascii.SUB, 38, 36, 80, 38, -8, 93, -98, 53, 107, 53, 90, 62, -5, 83, -113, 60, SignedBytes.MAX_POWER_OF_TWO, Ascii.EM, 81, 54, -94, 108, -44, 104, 34, 68, Ascii.FS, 96, -68, 10, -68, 104, 58, 70, 3, 97, -57, 5, -58, Ascii.SUB, 97, Ascii.ESC, 69, 60, -8, 93, -98, 53, 107, 5, Ascii.ESC, 56, -1, Ascii.US, -59, 48, 105, Ascii.FS, 82, 35}, new byte[]{-4, 89, Ascii.SO, 118, 53, 83, -117, 60}));
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r3 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r3, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r3.getInserting() || !Intrinsics.areEqual(r3.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r3.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r3, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407840262, StringFog.decrypt(new byte[]{85, Ascii.SYN, 42, -85, -31, -22, 68, -64, 32, 107, 35, -96, -13, -80, 2, -36, 125, 83, 57, -88, -42, -20, 7, -108, 121}, new byte[]{Ascii.SYN, 39, Ascii.SUB, -102, -95, -33, 117, -14}));
            RowScope rowScope = RowScopeInstance.INSTANCE;
            Alignment center = Alignment.Companion.getCenter();
            Modifier r6 = SizeKt.m845size3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl((float) 90));
            startRestartGroup.startReplaceGroup(384843216);
            boolean z = (i2 & 112) == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new OneRoundKt$$ExternalSyntheticLambda0(function02);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier paint$default = PainterModifierKt.paint$default(MortalKt.mortal(r6, (Function0) rememberedValue), PainterResources_androidKt.painterResource(R.drawable.level_bg, startRestartGroup, 0), false, (Alignment) null, ContentScale.Companion.getFillBounds(), 0.0f, (ColorFilter) null, 54, (Object) null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, StringFog.decrypt(new byte[]{52, -15, -85, -105, 106, 94, Ascii.SI, 102, 95, Byte.MIN_VALUE, -81, -28, 41, Ascii.NAK, Ascii.SI, 1, 69, -14, -80, -26, Base64.padSymbol, Ascii.DC2, 106, 7, 68, -126, -71, -105, 106, 94, 8, 93, 3, -111, -79, -94, 54, 84, SignedBytes.MAX_POWER_OF_TWO, 89}, new byte[]{119, -78, -125, -43, 5, 38, 38, 54}));
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, StringFog.decrypt(new byte[]{-79, -89, Ascii.SYN, 104, -123, -95, -32, -68, -122, -51, 110, Ascii.FF, -59, -23, -93, -5, -37, -45, 7, 100, -41, -22, -65, -15, -66, -42, Ascii.CR, 8, -36, -22, -49, -6, -63, -47, 7, 104, -48, -23, -66, -13, -66, -123, 71, 75, -111, -84, -95, -94, -122, -57, 6, Ascii.DC4, -119, -86, -23, -95}, new byte[]{-14, -28, 62, 36, -28, -40, -113, -55}));
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, paint$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, StringFog.decrypt(new byte[]{43, -87, -32, -75, 32, -124, 10, 36, 10, -122, -83, -92, 42, -100, 9, 42, Ascii.ESC, -113, -122, -120, 33, -108, 80, Ascii.NAK, SignedBytes.MAX_POWER_OF_TWO, -37, -28, -43, 108, -62, 78, 115, 40, -37, -4, -41, 115, -61, 53, 124, 82, -87, -89, -118, 53, -98, 10, 36, 10, -122, -83, -108, 107, -102, Ascii.CR, 102, 81, -125, -81, -115, 34, -127}, new byte[]{104, -22, -56, -25, 69, -15, 121, 69}));
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer r12 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r12, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r12, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r12.getInserting() || !Intrinsics.areEqual(r12.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                r12.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                r12.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3682setimpl(r12, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, StringFog.decrypt(new byte[]{-27, 93, 37, 38, -40, 75, -27, -88, -22, 83, 44, 36, -124, 7, -7, -6, -46, 73, 36, 17, -40, Ascii.CR, -79, -2}, new byte[]{-90, 106, Ascii.SYN, 102, -21, Byte.MAX_VALUE, -41, -111}));
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            if (roundModel2.getUnlocked()) {
                startRestartGroup.startReplaceGroup(978492673);
                float f3 = (float) 5;
                Composer composer2 = startRestartGroup;
                f = f2;
                i3 = 0;
                i4 = 2;
                TextKt.m2692Text4IGK_g(String.valueOf(roundModel2.getNum()), OffsetKt.m733offsetVpY3zN4(Modifier.Companion, Dp.m7111constructorimpl(f3), Dp.m7111constructorimpl(f3)), Color.Companion.m4276getWhite0d7_KjU(), TextUnitKt.getSp(32), (FontStyle) null, (FontWeight) null, FontFamilyKt.FontFamily(FontKt.m6661FontYpTlLL0$default(R.font.playtone, (FontWeight) null, 0, 0, 14, (Object) null)), 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 3504, 0, 130992);
                startRestartGroup = composer2;
                startRestartGroup.endReplaceGroup();
            } else {
                i3 = 0;
                f = f2;
                i4 = 2;
                startRestartGroup.startReplaceGroup(978814484);
                float f4 = (float) 5;
                ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.lock, startRestartGroup, 0), (String) null, OffsetKt.m733offsetVpY3zN4(SizeKt.m845size3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl((float) 40)), Dp.m7111constructorimpl(f4), Dp.m7111constructorimpl(f4)), (Alignment) null, ContentScale.Companion.getFillBounds(), 0.0f, (ColorFilter) null, startRestartGroup, 25008, (int) LocationRequestCompat.QUALITY_LOW_POWER);
                startRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier r62 = SizeKt.m831height3ABfNKs(SizeKt.m850width3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl((float) 50)), Dp.m7111constructorimpl(f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, StringFog.decrypt(new byte[]{-21, Ascii.EM, 17, 46, 111, -113, Ascii.SUB, 4, -58, 115, 105, 69, 50, -49, 92, 69, -103, 115, 1, 91, SignedBytes.MAX_POWER_OF_TWO, -41, 92, 90, -104, Ascii.SYN, Ascii.SI, 92, 44, -37, 88, 41, -100, 105, 0, 91, 76, -46, 92, 90, -110, Ascii.EM, 86, 1, 117, -114, 1, 71, -61, 46, Ascii.SUB, 95, 119, -48, Ascii.GS, Ascii.SI, -57}, new byte[]{-88, 90, 57, 109, 0, -29, 111, 105}));
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, i3);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, StringFog.decrypt(new byte[]{103, -16, -125, Ascii.SYN, -121, 69, -19, Ascii.FS, 80, -102, -5, 114, -57, Ascii.CR, -82, 91, Ascii.CR, -124, -110, Ascii.SUB, -43, Ascii.SO, -78, 81, 104, -127, -104, 118, -34, Ascii.SO, -62, 90, Ascii.ETB, -122, -110, Ascii.SYN, -46, Ascii.CR, -77, 83, 104, -46, -46, 53, -109, 72, -84, 2, 80, -112, -109, 106, -117, 78, -28, 1}, new byte[]{36, -77, -85, 90, -26, 60, -126, 105}));
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, i3);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, r62);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, StringFog.decrypt(new byte[]{Ascii.CR, 5, 110, -73, -120, -15, 88, 33, 44, 42, 35, -90, -126, -23, 91, 47, Base64.padSymbol, 35, 8, -118, -119, -31, 2, Ascii.DLE, 102, 119, 106, -41, -60, -73, Ascii.FS, 118, Ascii.SO, 119, 114, -43, -37, -74, 103, 121, 116, 5, 41, -120, -99, -21, 88, 33, 44, 42, 35, -106, -61, -17, 95, 99, 119, 47, 33, -113, -118, -12}, new byte[]{78, 70, 70, -27, -19, -124, 43, SignedBytes.MAX_POWER_OF_TWO}));
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            Composer r102 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r102, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r102, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r102.getInserting() || !Intrinsics.areEqual(r102.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash3))) {
                r102.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                r102.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3682setimpl(r102, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -384784025, StringFog.decrypt(new byte[]{-41, 123, 68, 5, 78, -90, 66, -21, -40, 122, 70, 6, Ascii.NAK, -2, 3, -78, -6, 109, Ascii.ETB, 49, 89, -96, 1, -20, -26, 37, 19}, new byte[]{-108, 67, 124, 69, 122, -110, 118, -33}));
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            float f5 = (float) 30;
            float f6 = f5;
            ImageKt.Image(PainterResources_androidKt.painterResource(roundModel2.getStars() >= 3 ? R.drawable.star_filled : R.drawable.star_empty, startRestartGroup, i3), (String) null, RotateKt.rotate(SizeKt.m845size3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f5)), 90.0f), (Alignment) null, ContentScale.Companion.getFillBounds(), 0.0f, (ColorFilter) null, startRestartGroup, 25008, (int) LocationRequestCompat.QUALITY_LOW_POWER);
            ImageKt.Image(PainterResources_androidKt.painterResource(roundModel2.getStars() >= i4 ? R.drawable.star_filled : R.drawable.star_empty, startRestartGroup, i3), (String) null, RotateKt.rotate(SizeKt.m845size3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl((float) 45)), 90.0f), (Alignment) null, ContentScale.Companion.getFillBounds(), 0.0f, (ColorFilter) null, startRestartGroup, 25008, (int) LocationRequestCompat.QUALITY_LOW_POWER);
            ImageKt.Image(PainterResources_androidKt.painterResource(roundModel2.getStars() >= 1 ? R.drawable.star_filled : R.drawable.star_empty, startRestartGroup, i3), (String) null, RotateKt.rotate(SizeKt.m845size3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f6)), 90.0f), (Alignment) null, ContentScale.Companion.getFillBounds(), 0.0f, (ColorFilter) null, startRestartGroup, 25008, (int) LocationRequestCompat.QUALITY_LOW_POWER);
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
            endRestartGroup.updateScope(new OneRoundKt$$ExternalSyntheticLambda1(roundModel2, function02, i5));
        }
    }

    /* access modifiers changed from: private */
    public static final Unit OneRound$lambda$4$lambda$1$lambda$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }
}
