package com.plinkofortune.cash.winspin.rounds;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.GridItemSpan;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
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
import java.util.List;
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
/* compiled from: RoundsScreen.kt */
final class RoundsScreenKt$RoundsScreen$1 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ Function1<Integer, Unit> $mortal;
    final /* synthetic */ State<List<RoundModel>> $rounds$delegate;

    RoundsScreenKt$RoundsScreen$1(State<? extends List<RoundModel>> state, Function1<? super Integer, Unit> function1) {
        this.$rounds$delegate = state;
        this.$mortal = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((ColumnScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope columnScope, Composer composer, int i) {
        int i2;
        ColumnScope columnScope2 = columnScope;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(columnScope2, StringFog.decrypt(new byte[]{-116, -95, 58, -98, 8, -116, 119, 3, -57, -71, 48, -106, 9, -21, 76, 0, -35, -72, 60}, new byte[]{-88, -43, 82, -9, 123, -88, 35, 108}));
        if ((i & 6) == 0) {
            i2 = i | (composer2.changed((Object) columnScope2) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 19) != 18 || !composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-435800003, i2, -1, StringFog.decrypt(new byte[]{68, 32, Ascii.FS, 60, 76, 122, 84, 36, 76, 32, Ascii.ETB, 125, 78, 98, 72, 36, 66, 97, Ascii.DC2, 115, 79, 126, 19, Base64.padSymbol, 78, 33, 2, 98, 85, 120, 19, 56, 72, 58, Ascii.US, 118, 79, 56, 111, 37, 82, 33, Ascii.NAK, 97, 111, 117, 79, 47, 66, 33, 95, 46, 93, 120, 82, 36, 94, 34, Ascii.RS, 103, 79, 40, Ascii.GS, 98, 117, 32, 4, 124, 88, 101, 110, 41, 85, 42, Ascii.DC4, 124, Ascii.DC2, 125, 73, 112, Ascii.DC4, 118, 88}, new byte[]{39, 79, 113, Ascii.DC2, 60, Ascii.SYN, Base64.padSymbol, 74}));
            }
            Alignment center = Alignment.Companion.getCenter();
            Modifier paint$default = PainterModifierKt.paint$default(columnScope2.align(ColumnScope.weight$default(columnScope2, SizeKt.fillMaxWidth(Modifier.Companion, 0.9f), 1.0f, false, 2, (Object) null), Alignment.Companion.getCenterHorizontally()), PainterResources_androidKt.painterResource(R.drawable.form, composer2, 0), false, (Alignment) null, ContentScale.Companion.getFillBounds(), 0.0f, (ColorFilter) null, 54, (Object) null);
            State<List<RoundModel>> state = this.$rounds$delegate;
            Function1<Integer, Unit> function1 = this.$mortal;
            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, StringFog.decrypt(new byte[]{-53, -26, -116, -107, -103, 83, 37, Ascii.EM, -96, -105, -120, -26, -38, Ascii.CAN, 37, 126, -70, -27, -105, -28, -50, Ascii.US, SignedBytes.MAX_POWER_OF_TWO, 120, -69, -107, -98, -107, -103, 83, 34, 34, -4, -122, -106, -96, -59, 89, 106, 38}, new byte[]{-120, -91, -92, -41, -10, 43, Ascii.FF, 73}));
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, StringFog.decrypt(new byte[]{-8, 117, 82, -56, -15, -25, -64, -29, -49, Ascii.US, 42, -84, -79, -81, -125, -92, -110, 1, 67, -60, -93, -84, -97, -82, -9, 4, 73, -88, -88, -84, -17, -91, -120, 3, 67, -56, -92, -81, -98, -84, -9, 87, 3, -21, -27, -22, -127, -3, -49, Ascii.NAK, 66, -76, -3, -20, -55, -2}, new byte[]{-69, 54, 122, -124, -112, -98, -81, -106}));
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, paint$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, StringFog.decrypt(new byte[]{98, -13, 126, 41, 59, Utf8.REPLACEMENT_BYTE, -104, 3, 67, -36, 51, 56, 49, 39, -101, Ascii.CR, 82, -43, Ascii.CAN, Ascii.DC4, 58, 47, -62, 50, 9, -127, 122, 73, 119, 121, -36, 84, 97, -127, 98, 75, 104, 120, -89, 91, Ascii.ESC, -13, 57, Ascii.SYN, 46, 37, -104, 3, 67, -36, 51, 8, 112, 33, -97, 65, Ascii.CAN, -39, 49, 17, 57, 58}, new byte[]{33, -80, 86, 123, 94, 74, -21, 98}));
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer r10 = Updater.m3675constructorimpl(composer2);
            Updater.m3682setimpl(r10, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r10, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r10.getInserting() || !Intrinsics.areEqual(r10.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r10.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r10.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r10, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, StringFog.decrypt(new byte[]{Utf8.REPLACEMENT_BYTE, 1, -6, 47, -96, -16, -63, -125, 48, Ascii.SI, -13, 45, -4, -68, -35, -47, 8, Ascii.NAK, -5, Ascii.CAN, -96, -74, -107, -43}, new byte[]{124, 54, -55, 111, -109, -60, -13, -70}));
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            Arrangement.HorizontalOrVertical r7 = Arrangement.INSTANCE.m623spacedBy0680j_4(Dp.m7111constructorimpl((float) 18));
            GridCells.Fixed fixed = new GridCells.Fixed(2);
            Modifier fillMaxHeight = SizeKt.fillMaxHeight(SizeKt.fillMaxWidth(Modifier.Companion, 0.8f), 0.8f);
            GridCells gridCells = fixed;
            Arrangement.Vertical vertical = r7;
            Arrangement.Horizontal horizontal = spaceBetween;
            composer2.startReplaceGroup(35414191);
            boolean changed = composer2.changed((Object) state) | composer2.changed((Object) function1);
            Object rememberedValue = composer2.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new RoundsScreenKt$RoundsScreen$1$$ExternalSyntheticLambda0(state, function1);
                composer2.updateRememberedValue(rememberedValue);
            }
            composer2.endReplaceGroup();
            LazyGridDslKt.LazyVerticalGrid(gridCells, fillMaxHeight, (LazyGridState) null, (PaddingValues) null, false, vertical, horizontal, (FlingBehavior) null, false, (Function1) rememberedValue, composer2, 1769520, 412);
            Alignment center2 = Alignment.Companion.getCenter();
            float f = (float) 16;
            Modifier align = boxScope.align(BorderKt.m259borderxT4_qwU(BackgroundKt.background$default(SizeKt.fillMaxHeight(SizeKt.fillMaxWidth(Modifier.Companion, 0.9f), 0.1f), Brush.Companion.m4186verticalGradient8A3gB4$default(Brush.Companion, CollectionsKt.listOf(Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_1, composer2, 0)), Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_2, composer2, 0)), Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_3, composer2, 0))), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl(f)), 0.0f, 4, (Object) null), Dp.m7111constructorimpl((float) 2), ColorResources_androidKt.colorResource(R.color.seq_border, composer2, 0), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl(f))), Alignment.Companion.getTopCenter());
            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, StringFog.decrypt(new byte[]{107, 41, 88, 83, 81, -117, -84, 60, 0, 88, 92, 32, Ascii.DC2, -64, -84, 91, Ascii.SUB, 42, 67, 34, 6, -57, -55, 93, Ascii.ESC, 90, 74, 83, 81, -117, -85, 7, 92, 73, 66, 102, Ascii.CR, -127, -29, 3}, new byte[]{40, 106, 112, 17, 62, -13, -123, 108}));
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, StringFog.decrypt(new byte[]{34, -84, -55, 126, 32, 93, -9, Ascii.SI, Ascii.NAK, -58, -79, Ascii.SUB, 96, Ascii.NAK, -76, 72, 72, -40, -40, 114, 114, Ascii.SYN, -88, 66, 45, -35, -46, Ascii.RS, 121, Ascii.SYN, -40, 73, 82, -38, -40, 126, 117, Ascii.NAK, -87, SignedBytes.MAX_POWER_OF_TWO, 45, -114, -104, 93, 52, 80, -74, 17, Ascii.NAK, -52, -39, 2, 44, 86, -2, Ascii.DC2}, new byte[]{97, -17, -31, 50, 65, 36, -104, 122}));
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, align);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, StringFog.decrypt(new byte[]{-101, -83, Ascii.VT, 124, -50, 60, 42, -116, -70, -126, 70, 109, -60, 36, 41, -126, -85, -117, 109, 65, -49, 44, 112, -67, -16, -33, Ascii.SI, Ascii.FS, -126, 122, 110, -37, -104, -33, Ascii.ETB, Ascii.RS, -99, 123, Ascii.NAK, -44, -30, -83, 76, 67, -37, 38, 42, -116, -70, -126, 70, 93, -123, 34, 45, -50, -31, -121, 68, 68, -52, 57}, new byte[]{-40, -18, 35, 46, -85, 73, 89, -19}));
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor2);
            } else {
                composer2.useNode();
            }
            Composer r5 = Updater.m3675constructorimpl(composer2);
            Updater.m3682setimpl(r5, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r5, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r5.getInserting() || !Intrinsics.areEqual(r5.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                r5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                r5.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3682setimpl(r5, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, StringFog.decrypt(new byte[]{-73, 102, -48, 58, -55, -116, 124, 50, -72, 104, -39, 56, -107, -64, 96, 96, Byte.MIN_VALUE, 114, -47, Ascii.CR, -55, -54, 40, 100}, new byte[]{-12, 81, -29, 122, -6, -72, 78, Ascii.VT}));
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            TextKt.m2692Text4IGK_g(StringFog.decrypt(new byte[]{-17, -95, 56, -118, -83}, new byte[]{-67, -50, 77, -28, -55, -96, -10, Byte.MAX_VALUE}), (Modifier) null, Color.Companion.m4276getWhite0d7_KjU(), TextUnitKt.getSp(32), (FontStyle) null, (FontWeight) null, FontFamilyKt.FontFamily(FontKt.m6661FontYpTlLL0$default(R.font.playtone, (FontWeight) null, 0, 0, 14, (Object) null)), 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 3462, 0, 130994);
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

    /* access modifiers changed from: private */
    public static final Unit invoke$lambda$5$lambda$3$lambda$2(State state, Function1 function1, LazyGridScope lazyGridScope) {
        Intrinsics.checkNotNullParameter(lazyGridScope, StringFog.decrypt(new byte[]{90, -115, 101, -69, -26, -48, -60, Byte.MIN_VALUE, 4, Byte.MIN_VALUE, 91, -73, -25, Byte.MIN_VALUE, -31, -126, Ascii.US, -107, 74, -96, -4, -112}, new byte[]{126, -7, Ascii.CR, -46, -107, -12, -120, -31}));
        List access$RoundsScreen$lambda$0 = RoundsScreenKt.RoundsScreen$lambda$0(state);
        lazyGridScope.items(access$RoundsScreen$lambda$0.size(), (Function1<? super Integer, ? extends Object>) null, (Function2<? super LazyGridItemSpanScope, ? super Integer, GridItemSpan>) null, new RoundsScreenKt$RoundsScreen$1$invoke$lambda$5$lambda$3$lambda$2$$inlined$items$default$4(RoundsScreenKt$RoundsScreen$1$invoke$lambda$5$lambda$3$lambda$2$$inlined$items$default$1.INSTANCE, access$RoundsScreen$lambda$0), ComposableLambdaKt.composableLambdaInstance(699646206, true, new RoundsScreenKt$RoundsScreen$1$invoke$lambda$5$lambda$3$lambda$2$$inlined$items$default$5(access$RoundsScreen$lambda$0, function1)));
        return Unit.INSTANCE;
    }
}
