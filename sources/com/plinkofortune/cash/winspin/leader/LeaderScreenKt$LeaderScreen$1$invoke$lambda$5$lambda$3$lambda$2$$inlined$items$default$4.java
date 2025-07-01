package com.plinkofortune.cash.winspin.leader;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
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
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.ColorResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
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
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okio.Utf8;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/LazyItemScope;", "it", "", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V", "androidx/compose/foundation/lazy/LazyDslKt$items$4"}, k = 3, mv = {2, 0, 0}, xi = 48)
/* compiled from: LazyDsl.kt */
public final class LeaderScreenKt$LeaderScreen$1$invoke$lambda$5$lambda$3$lambda$2$$inlined$items$default$4 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
    final /* synthetic */ List $items;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LeaderScreenKt$LeaderScreen$1$invoke$lambda$5$lambda$3$lambda$2$$inlined$items$default$4(List list) {
        super(4);
        this.$items = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
        int i3;
        int i4 = i;
        Composer composer2 = composer;
        ComposerKt.sourceInformation(composer2, StringFog.decrypt(new byte[]{125, Ascii.ETB, 10, -15, -84, 122, Ascii.CR, 57, 10, 106, Ascii.CR, -15, -42, 1, 92, 116, 71, 98, 76, -81, -62, 38, 73, 45, 10, Ascii.DC4, 7, -83, -127, 44}, new byte[]{62, 38, Utf8.REPLACEMENT_BYTE, -61, -20, 77, Base64.padSymbol, Ascii.SO}));
        if ((i2 & 6) == 0) {
            i3 = i2 | (composer2.changed((Object) lazyItemScope) ? 4 : 2);
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composer2.changed(i4) ? 32 : 16;
        }
        if ((i3 & 147) != 146 || !composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-632812321, i3, -1, StringFog.decrypt(new byte[]{Ascii.VT, 84, 2, 32, -63, -87, 79, -112, 68, 89, 9, Utf8.REPLACEMENT_BYTE, -34, -81, 88, -115, 68, 92, 9, 39, -64, -92, 74, -100, 3, 85, 8, 124, -62, -95, 81, -111, 68, 83, Ascii.DC2, 55, -61, -77, 5, -44, Ascii.VT, 84, 9, 60, -41, -83, 68, -99, Ascii.EM, 4, 70, 122, -30, -95, 81, -111, 46, 73, 10, 124, -59, -76, 17, -39, 95, 8, 79}, new byte[]{106, 58, 102, 82, -82, -64, 43, -24}));
            }
            LeaderModel leaderModel = (LeaderModel) this.$items.get(i4);
            composer2.startReplaceGroup(-2058221034);
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            float f = (float) 16;
            Modifier r4 = BorderKt.m259borderxT4_qwU(BackgroundKt.background$default(SizeKt.m831height3ABfNKs(SizeKt.fillMaxWidth(Modifier.Companion, 0.95f), Dp.m7111constructorimpl((float) 70)), Brush.Companion.m4186verticalGradient8A3gB4$default(Brush.Companion, CollectionsKt.listOf(Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_1, composer2, 0)), Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_2, composer2, 0)), Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_3, composer2, 0))), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl(f)), 0.0f, 4, (Object) null), Dp.m7111constructorimpl((float) 2), ColorResources_androidKt.colorResource(R.color.seq_border, composer2, 0), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl(f)));
            ComposerKt.sourceInformationMarkerStart(composer2, 693286680, StringFog.decrypt(new byte[]{39, 120, 36, Ascii.SO, -52, 115, -113, 56, 76, 9, 32, 109, -113, 55, -113, 81, 93, 123, 57, 108, -110, 60, -22, 93, 92, Ascii.ETB, Base64.padSymbol, 108, -109, 68, -109, 88, 92, 10, SignedBytes.MAX_POWER_OF_TWO, 109, -112, 52, -100, 58, Ascii.VT, 76, 34, 55, -41, 39, -108, Ascii.US, 87, 73, 106, 51}, new byte[]{100, 59, Ascii.FF, 92, -93, 4, -90, 104}));
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer2, 54);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, StringFog.decrypt(new byte[]{Ascii.VT, Ascii.FF, -64, -99, -111, -47, SignedBytes.MAX_POWER_OF_TWO, -36, 60, 102, -72, -7, -47, -103, 3, -101, 97, 120, -47, -111, -61, -102, Ascii.US, -111, 4, 125, -37, -3, -56, -102, 111, -102, 123, 122, -47, -99, -60, -103, Ascii.RS, -109, 4, 46, -111, -66, -123, -36, 1, -62, 60, 108, -48, -31, -99, -38, 73, -63}, new byte[]{72, 79, -24, -47, -16, -88, 47, -87}));
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, r4);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, StringFog.decrypt(new byte[]{-38, Ascii.EM, -64, -104, -70, -3, 102, Base64.padSymbol, -5, 54, -115, -119, -80, -27, 101, 51, -22, Utf8.REPLACEMENT_BYTE, -90, -91, -69, -19, 60, Ascii.FF, -79, 107, -60, -8, -10, -69, 34, 106, -39, 107, -36, -6, -23, -70, 89, 101, -93, Ascii.EM, -121, -89, -81, -25, 102, Base64.padSymbol, -5, 54, -115, -71, -15, -29, 97, Byte.MAX_VALUE, -96, 51, -113, -96, -72, -8}, new byte[]{-103, 90, -24, -54, -33, -120, Ascii.NAK, 92}));
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer r9 = Updater.m3675constructorimpl(composer2);
            Updater.m3682setimpl(r9, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r9, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r9.getInserting() || !Intrinsics.areEqual(r9.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r9.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r9.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r9, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -407840262, StringFog.decrypt(new byte[]{19, 106, -32, -31, Ascii.EM, 87, -2, Ascii.SYN, 102, Ascii.ETB, -23, -22, Ascii.VT, Ascii.CR, -72, 10, 59, 47, -13, -30, 46, 81, -67, 66, Utf8.REPLACEMENT_BYTE}, new byte[]{80, 91, -48, -48, 89, 98, -49, 36}));
            float f2 = (float) 10;
            SpacerKt.Spacer(SizeKt.m850width3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f2)), composer2, 6);
            float f3 = (float) 40;
            float f4 = f2;
            Composer composer3 = composer;
            TextKt.m2692Text4IGK_g(leaderModel.getNum() + ".", SizeKt.m850width3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f3)), Color.Companion.m4276getWhite0d7_KjU(), TextUnitKt.getSp(20), (FontStyle) null, (FontWeight) null, FontFamilyKt.FontFamily(FontKt.m6661FontYpTlLL0$default(R.font.playtone, (FontWeight) null, 0, 0, 14, (Object) null)), 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 3504, 3072, 122800);
            SpacerKt.Spacer(SizeKt.m850width3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl((float) 8)), composer3, 6);
            TextKt.m2692Text4IGK_g(leaderModel.getName(), RowScope.weight$default(RowScopeInstance.INSTANCE, Modifier.Companion, 1.0f, false, 2, (Object) null), Color.Companion.m4276getWhite0d7_KjU(), TextUnitKt.getSp(20), (FontStyle) null, (FontWeight) null, FontFamilyKt.FontFamily(FontKt.m6661FontYpTlLL0$default(R.font.playtone, (FontWeight) null, 0, 0, 14, (Object) null)), 0, (TextDecoration) null, (TextAlign) null, 0, TextOverflow.Companion.m7038getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 3456, 3120, 120752);
            SpacerKt.Spacer(SizeKt.m850width3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl((float) 12)), composer3, 6);
            TextKt.m2692Text4IGK_g(String.valueOf(leaderModel.getScore()), SizeKt.m850width3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f3)), Color.Companion.m4276getWhite0d7_KjU(), TextUnitKt.getSp(20), (FontStyle) null, (FontWeight) null, FontFamilyKt.FontFamily(FontKt.m6661FontYpTlLL0$default(R.font.playtone, (FontWeight) null, 0, 0, 14, (Object) null)), 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 3504, 3072, 122800);
            Composer composer4 = composer3;
            SpacerKt.Spacer(SizeKt.m850width3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f4)), composer4, 6);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            composer4.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer2.skipToGroupEnd();
    }
}
