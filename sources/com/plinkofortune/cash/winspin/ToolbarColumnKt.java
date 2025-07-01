package com.plinkofortune.cash.winspin;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.core.location.LocationRequestCompat;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a9\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0007¢\u0006\u0002\b\bH\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"ToolbarColumn", "", "mortal", "Lkotlin/Function0;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "app_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: ToolbarColumn.kt */
public final class ToolbarColumnKt {
    /* access modifiers changed from: private */
    public static final Unit ToolbarColumn$lambda$4(Function0 function0, Function3 function3, int i, Composer composer, int i2) {
        ToolbarColumn(function0, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ToolbarColumn(Function0<Unit> function0, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i) {
        int i2;
        Function0<Unit> function02 = function0;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
        int i3 = i;
        Intrinsics.checkNotNullParameter(function02, StringFog.decrypt(new byte[]{-2, 52, -27, -79, 0, 8}, new byte[]{-109, 91, -105, -59, 97, 100, 94, 122}));
        Intrinsics.checkNotNullParameter(function32, StringFog.decrypt(new byte[]{50, -88, -24, Ascii.DC4, Utf8.REPLACEMENT_BYTE, -39, 66}, new byte[]{81, -57, -122, 96, 90, -73, 54, -102}));
        Composer startRestartGroup = composer.startRestartGroup(-2000867008);
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function32) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2000867008, i2, -1, StringFog.decrypt(new byte[]{-123, 37, 72, -124, 109, 1, -117, -46, -115, 37, 67, -59, 111, Ascii.EM, -105, -46, -125, 100, 70, -53, 110, 5, -52, -53, -113, 36, 86, -38, 116, 3, -52, -24, -119, 37, 73, -56, 124, Ascii.US, -95, -45, -118, Utf8.REPLACEMENT_BYTE, 72, -60, Base64.padSymbol, 69, -74, -45, -119, 38, 71, -53, 111, 46, -115, -48, -109, 39, 75, -124, 118, Ascii.EM, -40, -115, -34, 99}, new byte[]{-26, 74, 37, -86, Ascii.GS, 109, -30, -68}));
            }
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, StringFog.decrypt(new byte[]{Byte.MAX_VALUE, 0, -72, 98, 59, 76, 53, 84, 82, 106, -64, 9, 102, Ascii.FF, 115, Ascii.NAK, Ascii.CR, 106, -88, Ascii.ETB, Ascii.DC4, Ascii.DC4, 115, 10, Ascii.FF, Ascii.SI, -90, Ascii.DLE, 120, Ascii.CAN, 119, 121, 8, 112, -87, Ascii.ETB, Ascii.CAN, 17, 115, 10, 6, 0, -1, 77, 33, 77, 46, Ascii.ETB, 87, 55, -77, 19, 35, 19, 50, 95, 83}, new byte[]{60, 67, -112, 33, 84, 32, SignedBytes.MAX_POWER_OF_TWO, 57}));
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, StringFog.decrypt(new byte[]{-100, 8, -24, -11, Ascii.NAK, -3, -79, 41, -85, 98, -112, -111, 85, -75, -14, 110, -10, 124, -7, -7, 71, -74, -18, 100, -109, 121, -13, -107, 76, -74, -98, 111, -20, 126, -7, -11, SignedBytes.MAX_POWER_OF_TWO, -75, -17, 102, -109, 42, -71, -42, 1, -16, -16, 55, -85, 104, -8, -119, Ascii.EM, -10, -72, 52}, new byte[]{-33, 75, -64, -71, 116, -124, -34, 92}));
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, StringFog.decrypt(new byte[]{Ascii.DC2, 100, Ascii.SO, -24, 54, 32, -71, -27, 51, 75, 67, -7, 60, 56, -70, -21, 34, 66, 104, -43, 55, 48, -29, -44, 121, Ascii.SYN, 10, -120, 122, 102, -3, -78, 17, Ascii.SYN, Ascii.DC2, -118, 101, 103, -122, -67, 107, 100, 73, -41, 35, 58, -71, -27, 51, 75, 67, -55, 125, 62, -66, -89, 104, 78, 65, -48, 52, 37}, new byte[]{81, 39, 38, -70, 83, 85, -54, -124}));
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r11 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r11, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r11, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r11.getInserting() || !Intrinsics.areEqual(r11.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r11.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r11.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r11, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -384784025, StringFog.decrypt(new byte[]{-119, -52, -25, 5, 118, 58, 44, -56, -122, -51, -27, 6, 45, 98, 109, -111, -92, -38, -76, 49, 97, 60, 111, -49, -72, -110, -80}, new byte[]{-54, -12, -33, 69, 66, Ascii.SO, Ascii.CAN, -4}));
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            float f = (float) 20;
            SpacerKt.Spacer(SizeKt.m831height3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f)), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, StringFog.decrypt(new byte[]{-104, 62, -38, -23, 85, Ascii.SUB, -108, -68, -13, 79, -34, -118, Ascii.SYN, 94, -108, -43, -30, Base64.padSymbol, -57, -117, Ascii.VT, 85, -15, -39, -29, 81, -61, -117, 10, 45, -120, -36, -29, 76, -66, -118, 9, 93, -121, -66, -76, 10, -36, -48, 78, 78, -113, -101, -24, Ascii.SI, -108, -44}, new byte[]{-37, 125, -14, -69, 58, 109, -67, -20}));
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, StringFog.decrypt(new byte[]{-110, 92, -77, -7, -13, -124, 114, 123, -91, 54, -53, -99, -77, -52, 49, 60, -8, 40, -94, -11, -95, -49, 45, 54, -99, 45, -88, -103, -86, -49, 93, Base64.padSymbol, -30, 42, -94, -7, -90, -52, 44, 52, -99, 126, -30, -38, -25, -119, 51, 101, -91, 60, -93, -123, -1, -113, 123, 102}, new byte[]{-47, Ascii.US, -101, -75, -110, -3, Ascii.GS, Ascii.SO}));
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, StringFog.decrypt(new byte[]{-82, 99, 110, -116, -65, 57, -45, -102, -113, 76, 35, -99, -75, 33, -48, -108, -98, 69, 8, -79, -66, 41, -119, -85, -59, 17, 106, -20, -13, Byte.MAX_VALUE, -105, -51, -83, 17, 114, -18, -20, 126, -20, -62, -41, 99, 41, -77, -86, 35, -45, -102, -113, 76, 35, -83, -12, 39, -44, -40, -44, 73, 33, -76, -67, 60}, new byte[]{-19, 32, 70, -34, -38, 76, -96, -5}));
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer r9 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r9, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r9, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r9.getInserting() || !Intrinsics.areEqual(r9.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                r9.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                r9.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3682setimpl(r9, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407840262, StringFog.decrypt(new byte[]{95, 35, -119, 124, 85, 49, 46, -38, 42, 94, Byte.MIN_VALUE, 119, 71, 107, 104, -58, 119, 102, -102, Byte.MAX_VALUE, 98, 55, 109, -114, 115}, new byte[]{Ascii.FS, Ascii.DC2, -71, 77, Ascii.NAK, 4, Ascii.US, -24}));
            RowScope rowScope = RowScopeInstance.INSTANCE;
            SpacerKt.Spacer(SizeKt.m850width3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f)), startRestartGroup, 6);
            boolean z = false;
            Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.cvbzx, startRestartGroup, 0);
            ContentScale fillBounds = ContentScale.Companion.getFillBounds();
            Modifier r92 = SizeKt.m845size3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl((float) 60));
            startRestartGroup.startReplaceGroup(1084519567);
            if ((i2 & 14) == 4) {
                z = true;
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new ToolbarColumnKt$$ExternalSyntheticLambda0(function02);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            ImageKt.Image(painterResource, (String) null, MortalKt.mortal(r92, (Function0) rememberedValue), (Alignment) null, fillBounds, 0.0f, (ColorFilter) null, startRestartGroup, 24624, (int) LocationRequestCompat.QUALITY_LOW_POWER);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            SpacerKt.Spacer(SizeKt.m831height3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f)), startRestartGroup, 6);
            function32.invoke(columnScope, startRestartGroup, Integer.valueOf(6 | (i2 & 112)));
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
            endRestartGroup.updateScope(new ToolbarColumnKt$$ExternalSyntheticLambda1(function02, function32, i3));
        }
    }

    /* access modifiers changed from: private */
    public static final Unit ToolbarColumn$lambda$3$lambda$2$lambda$1$lambda$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }
}
