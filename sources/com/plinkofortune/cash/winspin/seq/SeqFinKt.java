package com.plinkofortune.cash.winspin.seq;

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
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
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
import androidx.core.location.LocationRequestCompat;
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

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"SeqFin", "", "round", "", "stars", "time", "score", "mortal", "Lkotlin/Function0;", "(IIIILkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: SeqFin.kt */
public final class SeqFinKt {
    /* access modifiers changed from: private */
    public static final Unit SeqFin$lambda$9(int i, int i2, int i3, int i4, Function0 function0, int i5, Composer composer, int i6) {
        SeqFin(i, i2, i3, i4, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void SeqFin(int i, int i2, int i3, int i4, Function0<Unit> function0, Composer composer, int i5) {
        int i6;
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        Function0<Unit> function02 = function0;
        int i11 = i5;
        Intrinsics.checkNotNullParameter(function02, StringFog.decrypt(new byte[]{88, 85, -97, 90, Ascii.DC2, -61}, new byte[]{53, 58, -19, 46, 115, -81, 8, -89}));
        Composer startRestartGroup = composer.startRestartGroup(-899219747);
        if ((i11 & 6) == 0) {
            i6 = (startRestartGroup.changed(i7) ? 4 : 2) | i11;
        } else {
            i6 = i11;
        }
        if ((i11 & 48) == 0) {
            i6 |= startRestartGroup.changed(i8) ? 32 : 16;
        }
        if ((i11 & 384) == 0) {
            i6 |= startRestartGroup.changed(i9) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i6 |= startRestartGroup.changed(i10) ? 2048 : 1024;
        }
        if ((i11 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function02) ? 16384 : 8192;
        }
        if ((i6 & 9363) != 9362 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-899219747, i6, -1, StringFog.decrypt(new byte[]{-123, -89, -111, -93, 87, -41, -7, 77, -115, -89, -102, -30, 85, -49, -27, 77, -125, -26, -97, -20, 84, -45, -66, 84, -113, -90, -113, -3, 78, -43, -66, 80, -125, -71, -46, -34, 66, -54, -42, 74, -120, -24, -44, -34, 66, -54, -42, 74, -120, -26, -105, -7, Ascii.GS, -113, -96, 10}, new byte[]{-26, -56, -4, -115, 39, -69, -112, 35}));
            }
            BoxKt.Box(BackgroundKt.m248backgroundbw27NRU$default(AlphaKt.alpha(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.4f), Color.Companion.m4265getBlack0d7_KjU(), (Shape) null, 2, (Object) null), startRestartGroup, 6);
            Alignment center = Alignment.Companion.getCenter();
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, StringFog.decrypt(new byte[]{Ascii.SYN, -108, -34, -79, SignedBytes.MAX_POWER_OF_TWO, -28, 57, -88, 125, -27, -38, -62, 3, -81, 57, -49, 103, -105, -59, -64, Ascii.ETB, -88, 92, -55, 102, -25, -52, -79, SignedBytes.MAX_POWER_OF_TWO, -28, 62, -109, 33, -12, -60, -124, Ascii.FS, -18, 118, -105}, new byte[]{85, -41, -10, -13, 47, -100, Ascii.DLE, -8}));
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, StringFog.decrypt(new byte[]{-76, -98, 76, 0, -17, -73, -112, -96, -125, -12, 52, 100, -81, -1, -45, -25, -34, -22, 93, Ascii.FF, -67, -4, -49, -19, -69, -17, 87, 96, -74, -4, -65, -26, -60, -24, 93, 0, -70, -1, -50, -17, -69, -68, Ascii.GS, 35, -5, -70, -47, -66, -125, -2, 92, 124, -29, -68, -103, -67}, new byte[]{-9, -35, 100, 76, -114, -50, -1, -43}));
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, StringFog.decrypt(new byte[]{-122, -33, -6, -37, -20, 105, 84, -51, -89, -16, -73, -54, -26, 113, 87, -61, -74, -7, -100, -26, -19, 121, Ascii.SO, -4, -19, -83, -2, -69, -96, 47, Ascii.DLE, -102, -123, -83, -26, -71, -65, 46, 107, -107, -1, -33, -67, -28, -7, 115, 84, -51, -89, -16, -73, -6, -89, 119, 83, -113, -4, -11, -75, -29, -18, 108}, new byte[]{-59, -100, -46, -119, -119, Ascii.FS, 39, -84}));
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
            Updater.m3682setimpl(r10, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r10, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r10.getInserting() || !Intrinsics.areEqual(r10.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r10.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r10.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r10, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, StringFog.decrypt(new byte[]{93, 66, 76, -45, -9, -77, -88, 82, 82, 76, 69, -47, -85, -1, -76, 0, 106, 86, 77, -28, -9, -11, -4, 4}, new byte[]{Ascii.RS, 117, Byte.MAX_VALUE, -109, -60, -121, -102, 107}));
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            float f = (float) 300;
            Modifier r9 = SizeKt.m831height3ABfNKs(SizeKt.m850width3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f)), Dp.m7111constructorimpl((float) 420));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, StringFog.decrypt(new byte[]{-44, -4, 119, -37, -88, 111, -86, 56, -65, -115, 115, -88, -21, 36, -86, 95, -91, -1, 108, -86, -1, 35, -49, 89, -92, -113, 101, -37, -88, 111, -83, 3, -29, -100, 109, -18, -12, 101, -27, 7}, new byte[]{-105, -65, 95, -103, -57, Ascii.ETB, -125, 104}));
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, StringFog.decrypt(new byte[]{-4, -79, -54, 75, 95, -110, 105, 108, -53, -37, -78, 47, Ascii.US, -38, 42, 43, -106, -59, -37, 71, Ascii.CR, -39, 54, 33, -13, -64, -47, 43, 6, -39, 70, 42, -116, -57, -37, 75, 10, -38, 55, 35, -13, -109, -101, 104, 75, -97, 40, 114, -53, -47, -38, 55, 83, -103, 96, 113}, new byte[]{-65, -14, -30, 7, 62, -21, 6, Ascii.EM}));
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, r9);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            int i12 = i6;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, StringFog.decrypt(new byte[]{118, Ascii.GS, -6, 87, -33, 2, 66, 37, 87, 50, -73, 70, -43, Ascii.SUB, 65, 43, 70, 59, -100, 106, -34, Ascii.DC2, Ascii.CAN, Ascii.DC4, Ascii.GS, 111, -2, 55, -109, 68, 6, 114, 117, 111, -26, 53, -116, 69, 125, 125, Ascii.SI, Ascii.GS, -67, 104, -54, Ascii.CAN, 66, 37, 87, 50, -73, 118, -108, Ascii.FS, 69, 103, Ascii.FF, 55, -75, 111, -35, 7}, new byte[]{53, 94, -46, 5, -70, 119, 49, 68}));
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer r0 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r0, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r0, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r0.getInserting() || !Intrinsics.areEqual(r0.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                r0.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                r0.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3682setimpl(r0, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, StringFog.decrypt(new byte[]{-1, -28, 104, 10, 105, 7, -107, 79, -16, -22, 97, 8, 53, 75, -119, Ascii.GS, -56, -16, 105, Base64.padSymbol, 105, 65, -63, Ascii.EM}, new byte[]{-68, -45, 91, 74, 90, 51, -89, 118}));
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            float f2 = (float) 10;
            Arrangement.Vertical r11 = Arrangement.INSTANCE.m625spacedByD5KLDUw(Dp.m7111constructorimpl(f2), Alignment.Companion.getCenterVertically());
            Modifier paint$default = PainterModifierKt.paint$default(boxScope2.align(SizeKt.m845size3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f)), Alignment.Companion.getCenter()), PainterResources_androidKt.painterResource(R.drawable.form, startRestartGroup, 0), false, (Alignment) null, ContentScale.Companion.getFillBounds(), 0.0f, (ColorFilter) null, 54, (Object) null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, StringFog.decrypt(new byte[]{-54, Ascii.ESC, -15, -52, 2, -74, 94, -77, -25, 113, -119, -89, 95, -10, Ascii.CAN, -14, -72, 113, -31, -71, 45, -18, Ascii.CAN, -19, -71, Ascii.DC4, -17, -66, 65, -30, Ascii.FS, -98, -67, 107, -32, -71, 33, -21, Ascii.CAN, -19, -77, Ascii.ESC, -74, -29, Ascii.CAN, -73, 69, -16, -30, 44, -6, -67, Ascii.SUB, -23, 89, -72, -26}, new byte[]{-119, 88, -39, -113, 109, -38, 43, -34}));
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(r11, centerHorizontally, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, StringFog.decrypt(new byte[]{57, -119, -122, 1, -80, -53, 116, -97, Ascii.SO, -29, -2, 101, -16, -125, 55, -40, 83, -3, -105, Ascii.CR, -30, Byte.MIN_VALUE, 43, -46, 54, -8, -99, 97, -23, Byte.MIN_VALUE, 91, -39, 73, -1, -105, 1, -27, -125, 42, -48, 54, -85, -41, 34, -92, -58, 53, -127, Ascii.SO, -23, -106, 125, -68, -64, 125, -126}, new byte[]{122, -54, -82, 77, -47, -78, Ascii.ESC, -22}));
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, paint$default);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, StringFog.decrypt(new byte[]{75, 5, -98, 41, -36, -23, -48, Ascii.FS, 106, 42, -45, 56, -42, -15, -45, Ascii.DC2, 123, 35, -8, Ascii.DC4, -35, -7, -118, 45, 32, 119, -102, 73, -112, -81, -108, 75, 72, 119, -126, 75, -113, -82, -17, 68, 50, 5, -39, Ascii.SYN, -55, -13, -48, Ascii.FS, 106, 42, -45, 8, -105, -9, -41, 94, 49, 47, -47, 17, -34, -20}, new byte[]{8, 70, -74, 123, -71, -100, -93, 125}));
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            Composer r02 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r02, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r02, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r02.getInserting() || !Intrinsics.areEqual(r02.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash3))) {
                r02.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                r02.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3682setimpl(r02, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -384784025, StringFog.decrypt(new byte[]{-125, -84, -105, 46, -123, Ascii.DLE, Ascii.SUB, -89, -116, -83, -107, 45, -34, 72, 91, -2, -82, -70, -60, Ascii.SUB, -110, Ascii.SYN, 89, -96, -78, -14, -64}, new byte[]{-64, -108, -81, 110, -79, 36, 46, -109}));
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            Arrangement.HorizontalOrVertical center2 = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            float f3 = (float) 260;
            Modifier r92 = SizeKt.m850width3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f3));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, StringFog.decrypt(new byte[]{54, Ascii.DC4, -103, 71, -25, -93, -90, -103, 93, 101, -99, 36, -92, -25, -90, -16, 76, Ascii.ETB, -124, 37, -71, -20, -61, -4, 77, 123, Byte.MIN_VALUE, 37, -72, -108, -70, -7, 77, 102, -3, 36, -69, -28, -75, -101, Ascii.SUB, 32, -97, 126, -4, -9, -67, -66, 70, 37, -41, 122}, new byte[]{117, 87, -79, Ascii.NAK, -120, -44, -113, -55}));
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center2, centerVertically, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, StringFog.decrypt(new byte[]{-40, -63, 8, Ascii.FF, -8, -20, 120, 103, -17, -85, 112, 104, -72, -92, 59, 32, -78, -75, Ascii.EM, 0, -86, -89, 39, 42, -41, -80, 19, 108, -95, -89, 87, 33, -88, -73, Ascii.EM, Ascii.FF, -83, -92, 38, 40, -41, -29, 89, 47, -20, -31, 57, 121, -17, -95, Ascii.CAN, 112, -12, -25, 113, 122}, new byte[]{-101, -126, 32, SignedBytes.MAX_POWER_OF_TWO, -103, -107, Ascii.ETB, Ascii.DC2}));
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, r92);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
            int i13 = currentCompositeKeyHash4;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, StringFog.decrypt(new byte[]{80, -19, 7, -43, -115, -5, -40, 119, 113, -62, 74, -60, -121, -29, -37, 121, 96, -53, 97, -24, -116, -21, -126, 70, 59, -97, 3, -75, -63, -67, -100, 32, 83, -97, Ascii.ESC, -73, -34, -68, -25, 47, 41, -19, SignedBytes.MAX_POWER_OF_TWO, -22, -104, -31, -40, 119, 113, -62, 74, -12, -58, -27, -33, 53, 42, -57, 72, -19, -113, -2}, new byte[]{19, -82, 47, -121, -24, -114, -85, Ascii.SYN}));
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor4);
            } else {
                startRestartGroup.useNode();
            }
            Composer r6 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r6, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r6, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r6.getInserting() || !Intrinsics.areEqual(r6.rememberedValue(), (Object) Integer.valueOf(i13))) {
                r6.updateRememberedValue(Integer.valueOf(i13));
                r6.apply(Integer.valueOf(i13), setCompositeKeyHash4);
            }
            Updater.m3682setimpl(r6, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407840262, StringFog.decrypt(new byte[]{Ascii.US, Ascii.RS, 47, -105, -83, 44, -73, -106, 106, 99, 38, -100, -65, 118, -15, -118, 55, 91, 60, -108, -102, 42, -12, -62, 51}, new byte[]{92, 47, Ascii.US, -90, -19, Ascii.EM, -122, -92}));
            RowScope rowScope = RowScopeInstance.INSTANCE;
            Painter painterResource = PainterResources_androidKt.painterResource(i8 >= 3 ? R.drawable.star_filled : R.drawable.star_empty, startRestartGroup, 0);
            ContentScale fillBounds = ContentScale.Companion.getFillBounds();
            float f4 = (float) 40;
            float f5 = f4;
            float f6 = f3;
            Modifier r102 = OffsetKt.m734offsetVpY3zN4$default(SizeKt.m845size3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f4)), 0.0f, Dp.m7111constructorimpl(f2), 1, (Object) null);
            float f7 = f2;
            ContentScale contentScale = fillBounds;
            BoxScope boxScope3 = boxScope2;
            ImageKt.Image(painterResource, (String) null, r102, (Alignment) null, contentScale, 0.0f, (ColorFilter) null, startRestartGroup, 25008, (int) LocationRequestCompat.QUALITY_LOW_POWER);
            ImageKt.Image(PainterResources_androidKt.painterResource(i8 >= 2 ? R.drawable.star_filled : R.drawable.star_empty, startRestartGroup, 0), (String) null, OffsetKt.m734offsetVpY3zN4$default(SizeKt.m845size3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl((float) 60)), 0.0f, Dp.m7111constructorimpl(-Dp.m7111constructorimpl(f7)), 1, (Object) null), (Alignment) null, ContentScale.Companion.getFillBounds(), 0.0f, (ColorFilter) null, startRestartGroup, 25008, (int) LocationRequestCompat.QUALITY_LOW_POWER);
            ImageKt.Image(PainterResources_androidKt.painterResource(i8 >= 1 ? R.drawable.star_filled : R.drawable.star_empty, startRestartGroup, 0), (String) null, OffsetKt.m734offsetVpY3zN4$default(SizeKt.m845size3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f5)), 0.0f, Dp.m7111constructorimpl(f7), 1, (Object) null), (Alignment) null, ContentScale.Companion.getFillBounds(), 0.0f, (ColorFilter) null, startRestartGroup, 25008, (int) LocationRequestCompat.QUALITY_LOW_POWER);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Composer composer2 = startRestartGroup;
            TextKt.m2692Text4IGK_g(StringFog.decrypt(new byte[]{-50, 40, -58, -23, Byte.MIN_VALUE, 4, Ascii.FS, -71, -37}, new byte[]{-119, 105, -117, -84, -96, 75, 74, -4}), (Modifier) null, ColorResources_androidKt.colorResource(R.color.game_over, startRestartGroup, 0), TextUnitKt.getSp(30), (FontStyle) null, (FontWeight) null, FontFamilyKt.FontFamily(FontKt.m6661FontYpTlLL0$default(R.font.playtone, (FontWeight) null, 0, 0, 14, (Object) null)), 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 3078, 0, 130994);
            Composer composer3 = composer2;
            Alignment center3 = Alignment.Companion.getCenter();
            float f8 = (float) 220;
            float f9 = (float) 50;
            float f10 = (float) 16;
            float f11 = (float) 2;
            float f12 = f10;
            float f13 = f8;
            Modifier r7 = BorderKt.m259borderxT4_qwU(BackgroundKt.background$default(SizeKt.m831height3ABfNKs(SizeKt.m850width3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f8)), Dp.m7111constructorimpl(f9)), Brush.Companion.m4186verticalGradient8A3gB4$default(Brush.Companion, CollectionsKt.listOf(Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_1, composer3, 0)), Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_2, composer3, 0)), Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_3, composer3, 0))), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl(f10)), 0.0f, 4, (Object) null), Dp.m7111constructorimpl(f11), ColorResources_androidKt.colorResource(R.color.seq_border, composer3, 0), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl(f12)));
            ComposerKt.sourceInformationMarkerStart(composer3, 733328855, StringFog.decrypt(new byte[]{-69, -112, 90, 112, -105, 126, -113, Ascii.DC4, -48, -31, 94, 3, -44, 53, -113, 115, -54, -109, 65, 1, -64, 50, -22, 117, -53, -29, 72, 112, -105, 126, -120, 47, -116, -16, SignedBytes.MAX_POWER_OF_TWO, 69, -53, 116, -64, 43}, new byte[]{-8, -45, 114, 50, -8, 6, -90, 68}));
            MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center3, false);
            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, StringFog.decrypt(new byte[]{-103, 43, 118, -11, 42, Ascii.GS, -44, 78, -82, 65, Ascii.SO, -111, 106, 85, -105, 9, -13, 95, 103, -7, 120, 86, -117, 3, -106, 90, 109, -107, 115, 86, -5, 8, -23, 93, 103, -11, Byte.MAX_VALUE, 85, -118, 1, -106, 9, 39, -42, 62, Ascii.DLE, -107, 80, -82, 75, 102, -119, 38, Ascii.SYN, -35, 83}, new byte[]{-38, 104, 94, -71, 75, 100, -69, 59}));
            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
            CompositionLocalMap currentCompositionLocalMap5 = composer3.getCurrentCompositionLocalMap();
            Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(composer3, r7);
            Function0<ComposeUiNode> constructor5 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer3, -692256719, StringFog.decrypt(new byte[]{-24, 96, -93, 36, 79, -99, -122, 40, -55, 79, -18, 53, 69, -123, -123, 38, -40, 70, -59, Ascii.EM, 78, -115, -36, Ascii.EM, -125, Ascii.DC2, -89, 68, 3, -37, -62, Byte.MAX_VALUE, -21, Ascii.DC2, -65, 70, Ascii.FS, -38, -71, 112, -111, 96, -28, Ascii.ESC, 90, -121, -122, 40, -55, 79, -18, 5, 4, -125, -127, 106, -110, 74, -20, Ascii.FS, 77, -104}, new byte[]{-85, 35, -117, 118, 42, -24, -11, 73}));
            if (!(composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor5);
            } else {
                composer3.useNode();
            }
            Composer r2 = Updater.m3675constructorimpl(composer3);
            Updater.m3682setimpl(r2, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r2, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r2.getInserting() || !Intrinsics.areEqual(r2.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash5))) {
                r2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                r2.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
            }
            Updater.m3682setimpl(r2, materializeModifier5, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, StringFog.decrypt(new byte[]{-12, -115, 59, 124, 53, -62, 81, Ascii.CAN, -5, -125, 50, 126, 105, -114, 77, 74, -61, -103, 58, 75, 53, -124, 5, 78}, new byte[]{-73, -70, 8, 60, 6, -10, 99, 33}));
            BoxScope boxScope4 = BoxScopeInstance.INSTANCE;
            float f14 = f9;
            Composer composer4 = composer3;
            float f15 = f11;
            TextKt.m2692Text4IGK_g("Score: " + i10, (Modifier) null, Color.Companion.m4276getWhite0d7_KjU(), TextUnitKt.getSp(24), (FontStyle) null, (FontWeight) null, FontFamilyKt.FontFamily(FontKt.m6661FontYpTlLL0$default(R.font.playtone, (FontWeight) null, 0, 0, 14, (Object) null)), 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 3456, 0, 130994);
            Composer composer5 = composer4;
            ComposerKt.sourceInformationMarkerEnd(composer5);
            composer5.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer5);
            ComposerKt.sourceInformationMarkerEnd(composer5);
            ComposerKt.sourceInformationMarkerEnd(composer5);
            Alignment center4 = Alignment.Companion.getCenter();
            Modifier r22 = BorderKt.m259borderxT4_qwU(BackgroundKt.background$default(SizeKt.m831height3ABfNKs(SizeKt.m850width3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f13)), Dp.m7111constructorimpl(f14)), Brush.Companion.m4186verticalGradient8A3gB4$default(Brush.Companion, CollectionsKt.listOf(Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_1, composer5, 0)), Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_2, composer5, 0)), Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_3, composer5, 0))), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl(f12)), 0.0f, 4, (Object) null), Dp.m7111constructorimpl(f15), ColorResources_androidKt.colorResource(R.color.seq_border, composer5, 0), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl(f12)));
            ComposerKt.sourceInformationMarkerStart(composer5, 733328855, StringFog.decrypt(new byte[]{1, -47, -27, 41, -67, -103, -26, 114, 106, -96, -31, 90, -2, -46, -26, Ascii.NAK, 112, -46, -2, 88, -22, -43, -125, 19, 113, -94, -9, 41, -67, -103, -31, 73, 54, -79, -1, Ascii.FS, -31, -109, -87, 77}, new byte[]{66, -110, -51, 107, -46, -31, -49, 34}));
            MeasurePolicy maybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(center4, false);
            ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, StringFog.decrypt(new byte[]{-68, -126, 80, -85, 113, 32, -37, 1, -117, -24, 40, -49, 49, 104, -104, 70, -42, -10, 65, -89, 35, 107, -124, 76, -77, -13, 75, -53, 40, 107, -12, 71, -52, -12, 65, -85, 36, 104, -123, 78, -77, -96, 1, -120, 101, 45, -102, Ascii.US, -117, -30, SignedBytes.MAX_POWER_OF_TWO, -41, 125, 43, -46, Ascii.FS}, new byte[]{-1, -63, 120, -25, Ascii.DLE, 89, -76, 116}));
            int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
            CompositionLocalMap currentCompositionLocalMap6 = composer5.getCurrentCompositionLocalMap();
            Modifier materializeModifier6 = ComposedModifierKt.materializeModifier(composer5, r22);
            Function0<ComposeUiNode> constructor6 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer5, -692256719, StringFog.decrypt(new byte[]{-44, -29, 126, -26, 100, 84, -74, -21, -11, -52, 51, -9, 110, 76, -75, -27, -28, -59, Ascii.CAN, -37, 101, 68, -20, -38, -65, -111, 122, -122, 40, Ascii.DC2, -14, -68, -41, -111, 98, -124, 55, 19, -119, -77, -83, -29, 57, -39, 113, 78, -74, -21, -11, -52, 51, -57, 47, 74, -79, -87, -82, -55, 49, -34, 102, 81}, new byte[]{-105, -96, 86, -76, 1, 33, -59, -118}));
            if (!(composer5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer5.startReusableNode();
            if (composer5.getInserting()) {
                composer5.createNode(constructor6);
            } else {
                composer5.useNode();
            }
            Composer r112 = Updater.m3675constructorimpl(composer5);
            Updater.m3682setimpl(r112, maybeCachedBoxMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r112, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r112.getInserting() || !Intrinsics.areEqual(r112.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash6))) {
                r112.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                r112.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
            }
            Updater.m3682setimpl(r112, materializeModifier6, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, StringFog.decrypt(new byte[]{-50, 112, 120, Ascii.DC4, -19, 35, -108, 57, -63, 126, 113, Ascii.SYN, -79, 111, -120, 107, -7, 100, 121, 35, -19, 101, -64, 111}, new byte[]{-115, 71, 75, 84, -34, Ascii.ETB, -90, 0}));
            BoxScope boxScope5 = BoxScopeInstance.INSTANCE;
            Composer composer6 = composer5;
            TextKt.m2692Text4IGK_g("Time: " + i9, (Modifier) null, Color.Companion.m4276getWhite0d7_KjU(), TextUnitKt.getSp(24), (FontStyle) null, (FontWeight) null, FontFamilyKt.FontFamily(FontKt.m6661FontYpTlLL0$default(R.font.playtone, (FontWeight) null, 0, 0, 14, (Object) null)), 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer6, 3456, 0, 130994);
            Composer composer7 = composer6;
            ComposerKt.sourceInformationMarkerEnd(composer7);
            composer7.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer7);
            ComposerKt.sourceInformationMarkerEnd(composer7);
            ComposerKt.sourceInformationMarkerEnd(composer7);
            ComposerKt.sourceInformationMarkerEnd(composer7);
            composer7.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer7);
            ComposerKt.sourceInformationMarkerEnd(composer7);
            ComposerKt.sourceInformationMarkerEnd(composer7);
            Alignment center5 = Alignment.Companion.getCenter();
            Modifier r72 = BorderKt.m259borderxT4_qwU(BackgroundKt.background$default(boxScope3.align(OffsetKt.m734offsetVpY3zN4$default(SizeKt.m831height3ABfNKs(SizeKt.m850width3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f6)), Dp.m7111constructorimpl(f14)), 0.0f, Dp.m7111constructorimpl((float) 30), 1, (Object) null), Alignment.Companion.getTopCenter()), Brush.Companion.m4186verticalGradient8A3gB4$default(Brush.Companion, CollectionsKt.listOf(Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_1, composer7, 0)), Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_2, composer7, 0)), Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_3, composer7, 0))), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl(f12)), 0.0f, 4, (Object) null), Dp.m7111constructorimpl(f15), ColorResources_androidKt.colorResource(R.color.seq_border, composer7, 0), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl(f12)));
            ComposerKt.sourceInformationMarkerStart(composer7, 733328855, StringFog.decrypt(new byte[]{92, Ascii.DLE, -122, -22, 97, 51, 65, -29, 55, 97, -126, -103, 34, 120, 65, -124, 45, 19, -99, -101, 54, Byte.MAX_VALUE, 36, -126, 44, 99, -108, -22, 97, 51, 70, -40, 107, 112, -100, -33, Base64.padSymbol, 57, Ascii.SO, -36}, new byte[]{Ascii.US, 83, -82, -88, Ascii.SO, 75, 104, -77}));
            MeasurePolicy maybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(center5, false);
            ComposerKt.sourceInformationMarkerStart(composer7, -1323940314, StringFog.decrypt(new byte[]{7, -80, Ascii.SUB, -12, 0, -84, Ascii.RS, -98, 48, -38, 98, -112, SignedBytes.MAX_POWER_OF_TWO, -28, 93, -39, 109, -60, Ascii.VT, -8, 82, -25, 65, -45, 8, -63, 1, -108, 89, -25, 49, -40, 119, -58, Ascii.VT, -12, 85, -28, SignedBytes.MAX_POWER_OF_TWO, -47, 8, -110, 75, -41, Ascii.DC4, -95, 95, Byte.MIN_VALUE, 48, -48, 10, -120, Ascii.FF, -89, Ascii.ETB, -125}, new byte[]{68, -13, 50, -72, 97, -43, 113, -21}));
            int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(composer7, 0);
            CompositionLocalMap currentCompositionLocalMap7 = composer7.getCurrentCompositionLocalMap();
            Modifier materializeModifier7 = ComposedModifierKt.materializeModifier(composer7, r72);
            Function0<ComposeUiNode> constructor7 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer7, -692256719, StringFog.decrypt(new byte[]{-71, -16, Ascii.NAK, -104, -32, 52, -125, 41, -104, -33, 88, -119, -22, 44, Byte.MIN_VALUE, 39, -119, -42, 115, -91, -31, 36, -39, Ascii.CAN, -46, -126, 17, -8, -84, 114, -57, 126, -70, -126, 9, -6, -77, 115, -68, 113, -64, -16, 82, -89, -11, 46, -125, 41, -104, -33, 88, -71, -85, 42, -124, 107, -61, -38, 90, -96, -30, 49}, new byte[]{-6, -77, Base64.padSymbol, -54, -123, 65, -16, 72}));
            if (!(composer7.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer7.startReusableNode();
            if (composer7.getInserting()) {
                composer7.createNode(constructor7);
            } else {
                composer7.useNode();
            }
            Composer r93 = Updater.m3675constructorimpl(composer7);
            Updater.m3682setimpl(r93, maybeCachedBoxMeasurePolicy5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r93, currentCompositionLocalMap7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r93.getInserting() || !Intrinsics.areEqual(r93.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash7))) {
                r93.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash7));
                r93.apply(Integer.valueOf(currentCompositeKeyHash7), setCompositeKeyHash7);
            }
            Updater.m3682setimpl(r93, materializeModifier7, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer7, -2146769399, StringFog.decrypt(new byte[]{-125, Byte.MIN_VALUE, -3, -52, -40, 68, -97, 10, -116, -114, -12, -50, -124, 8, -125, 88, -76, -108, -4, -5, -40, 2, -53, 92}, new byte[]{-64, -73, -50, -116, -21, 112, -83, 51}));
            BoxScope boxScope6 = BoxScopeInstance.INSTANCE;
            Composer composer8 = composer7;
            TextKt.m2692Text4IGK_g("Round " + i7, (Modifier) null, Color.Companion.m4276getWhite0d7_KjU(), TextUnitKt.getSp(24), (FontStyle) null, (FontWeight) null, FontFamilyKt.FontFamily(FontKt.m6661FontYpTlLL0$default(R.font.playtone, (FontWeight) null, 0, 0, 14, (Object) null)), 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer8, 3456, 0, 130994);
            startRestartGroup = composer8;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier align = boxScope3.align(SizeKt.m831height3ABfNKs(SizeKt.m850width3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl((float) 200)), Dp.m7111constructorimpl((float) 80)), Alignment.Companion.getBottomCenter());
            startRestartGroup.startReplaceGroup(-2131528815);
            boolean z = (i12 & 57344) == 16384;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SeqFinKt$$ExternalSyntheticLambda0(function02);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            BoxKt.Box(PainterModifierKt.paint$default(MortalKt.mortal(align, (Function0) rememberedValue), PainterResources_androidKt.painterResource(R.drawable.ok_btn, startRestartGroup, 0), false, (Alignment) null, ContentScale.Companion.getFillBounds(), 0.0f, (ColorFilter) null, 54, (Object) null), startRestartGroup, 0);
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
            endRestartGroup.updateScope(new SeqFinKt$$ExternalSyntheticLambda1(i7, i2, i9, i10, function02, i5));
        }
    }

    /* access modifiers changed from: private */
    public static final Unit SeqFin$lambda$8$lambda$7$lambda$6$lambda$5(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }
}
