package com.plinkofortune.cash.winspin.profile;

import android.net.Uri;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.PickVisualMediaRequestKt;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
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
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.material3.TextFieldKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.ColorResources_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import coil3.compose.AsyncImagePainter;
import coil3.compose.SingletonAsyncImageKt;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Utf8;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* compiled from: ProfileScreen.kt */
final class ProfileScreenKt$ProfileScreen$2 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ MutableState<String> $actualNickname$delegate;
    final /* synthetic */ MutableState<String> $actualPath$delegate;
    final /* synthetic */ MutableState<Uri> $actualUri$delegate;
    final /* synthetic */ MutableState<Boolean> $exec$delegate;
    final /* synthetic */ ManagedActivityResultLauncher<PickVisualMediaRequest, Uri> $photoPicker;
    final /* synthetic */ ProfileVIewModel $viewmodel;

    ProfileScreenKt$ProfileScreen$2(MutableState<String> mutableState, ProfileVIewModel profileVIewModel, ManagedActivityResultLauncher<PickVisualMediaRequest, Uri> managedActivityResultLauncher, MutableState<Uri> mutableState2, MutableState<String> mutableState3, MutableState<Boolean> mutableState4) {
        this.$actualNickname$delegate = mutableState;
        this.$viewmodel = profileVIewModel;
        this.$photoPicker = managedActivityResultLauncher;
        this.$actualUri$delegate = mutableState2;
        this.$actualPath$delegate = mutableState3;
        this.$exec$delegate = mutableState4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((ColumnScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope columnScope, Composer composer, int i) {
        int i2;
        String str;
        ColumnScope columnScope2 = columnScope;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(columnScope2, StringFog.decrypt(new byte[]{Ascii.SYN, 1, -108, -31, -56, 125, 95, 98, 93, Ascii.EM, -98, -23, -55, Ascii.SUB, 100, 97, 71, Ascii.CAN, -110}, new byte[]{50, 117, -4, -120, -69, 89, Ascii.VT, Ascii.CR}));
        if ((i & 6) == 0) {
            i2 = i | (composer2.changed((Object) columnScope2) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 19) != 18 || !composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(985285840, i2, -1, StringFog.decrypt(new byte[]{-69, 56, -68, -100, -59, -72, -80, 115, -77, 56, -73, -35, -57, -96, -84, 115, -67, 121, -78, -45, -58, -68, -9, 106, -79, 57, -94, -62, -36, -70, -9, 109, -86, 56, -73, -37, -39, -79, -9, 77, -86, 56, -73, -37, -39, -79, -118, 126, -86, 50, -76, -36, -101, -24, -72, 115, -73, 57, -88, -33, -38, -95, -86, 35, -8, Byte.MAX_VALUE, -127, -64, -38, -78, -80, 113, -67, 4, -78, -64, -48, -79, -73, 51, -77, 35, -21, -118, -125, -3}, new byte[]{-40, 87, -47, -78, -75, -44, -39, Ascii.GS}));
            }
            Alignment center = Alignment.Companion.getCenter();
            Modifier paint$default = PainterModifierKt.paint$default(columnScope2.align(ColumnScope.weight$default(columnScope2, SizeKt.fillMaxWidth(Modifier.Companion, 0.9f), 1.0f, false, 2, (Object) null), Alignment.Companion.getCenterHorizontally()), PainterResources_androidKt.painterResource(R.drawable.form, composer2, 0), false, (Alignment) null, ContentScale.Companion.getFillBounds(), 0.0f, (ColorFilter) null, 54, (Object) null);
            MutableState<String> mutableState = this.$actualNickname$delegate;
            ProfileVIewModel profileVIewModel = this.$viewmodel;
            ManagedActivityResultLauncher<PickVisualMediaRequest, Uri> managedActivityResultLauncher = this.$photoPicker;
            MutableState<Uri> mutableState2 = this.$actualUri$delegate;
            MutableState<String> mutableState3 = this.$actualPath$delegate;
            MutableState<Boolean> mutableState4 = this.$exec$delegate;
            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, StringFog.decrypt(new byte[]{Ascii.EM, -63, 67, Base64.padSymbol, 2, 75, -37, 33, 114, -80, 71, 78, 65, 0, -37, 70, 104, -62, 88, 76, 85, 7, -66, SignedBytes.MAX_POWER_OF_TWO, 105, -78, 81, Base64.padSymbol, 2, 75, -36, Ascii.SUB, 46, -95, 89, 8, 94, 65, -108, Ascii.RS}, new byte[]{90, -126, 107, Byte.MAX_VALUE, 109, 51, -14, 113}));
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, StringFog.decrypt(new byte[]{-79, -101, -67, -18, 115, -35, 120, -9, -122, -15, -59, -118, 51, -107, 59, -80, -37, -17, -84, -30, 33, -106, 39, -70, -66, -22, -90, -114, 42, -106, 87, -79, -63, -19, -84, -18, 38, -107, 38, -72, -66, -71, -20, -51, 103, -48, 57, -23, -122, -5, -83, -110, Byte.MAX_VALUE, -42, 113, -22}, new byte[]{-14, -40, -107, -94, Ascii.DC2, -92, Ascii.ETB, -126}));
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, paint$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, StringFog.decrypt(new byte[]{-95, -76, -44, 54, -49, Ascii.ESC, -44, -74, Byte.MIN_VALUE, -101, -103, 39, -59, 3, -41, -72, -111, -110, -78, Ascii.VT, -50, Ascii.VT, -114, -121, -54, -58, -48, 86, -125, 93, -112, -31, -94, -58, -56, 84, -100, 92, -21, -18, -40, -76, -109, 9, -38, 1, -44, -74, Byte.MIN_VALUE, -101, -103, Ascii.ETB, -124, 5, -45, -12, -37, -98, -101, Ascii.SO, -51, Ascii.RS}, new byte[]{-30, -9, -4, 100, -86, 110, -89, -41}));
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer r2 = Updater.m3675constructorimpl(composer2);
            Updater.m3682setimpl(r2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r2.getInserting() || !Intrinsics.areEqual(r2.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, StringFog.decrypt(new byte[]{67, -111, -54, -111, Ascii.FF, 97, -92, 87, 76, -97, -61, -109, 80, 45, -72, 5, 116, -123, -53, -90, Ascii.FF, 39, -16, 1}, new byte[]{0, -90, -7, -47, Utf8.REPLACEMENT_BYTE, 85, -106, 110}));
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            Arrangement.HorizontalOrVertical center2 = Arrangement.INSTANCE.getCenter();
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            Modifier fillMaxHeight = SizeKt.fillMaxHeight(SizeKt.fillMaxWidth(Modifier.Companion, 0.8f), 0.8f);
            ComposerKt.sourceInformationMarkerStart(composer2, -483455358, StringFog.decrypt(new byte[]{-14, 38, -114, -126, -74, -89, -29, 49, -33, 76, -10, -23, -21, -25, -91, 112, Byte.MIN_VALUE, 76, -98, -9, -103, -1, -91, 111, -127, 41, -112, -16, -11, -13, -95, Ascii.FS, -123, 86, -97, -9, -107, -6, -91, 111, -117, 38, -55, -83, -84, -90, -8, 114, -38, 17, -123, -13, -82, -8, -28, 58, -34}, new byte[]{-79, 101, -90, -63, -39, -53, -106, 92}));
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(center2, centerHorizontally, composer2, 54);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, StringFog.decrypt(new byte[]{7, -96, -72, 39, 87, -84, 114, Ascii.SYN, 48, -54, -64, 67, Ascii.ETB, -28, 49, 81, 109, -44, -87, 43, 5, -25, 45, 91, 8, -47, -93, 71, Ascii.SO, -25, 93, 80, 119, -42, -87, 39, 2, -28, 44, 89, 8, -126, -23, 4, 67, -95, 51, 8, 48, -64, -88, 91, 91, -89, 123, Ascii.VT}, new byte[]{68, -29, -112, 107, 54, -43, Ascii.GS, 99}));
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, fillMaxHeight);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, StringFog.decrypt(new byte[]{-46, 117, 34, -90, -106, -37, -6, 83, -13, 90, 111, -73, -100, -61, -7, 93, -30, 83, 68, -101, -105, -53, -96, 98, -71, 7, 38, -58, -38, -99, -66, 4, -47, 7, 62, -60, -59, -100, -59, Ascii.VT, -85, 117, 101, -103, -125, -63, -6, 83, -13, 90, 111, -121, -35, -59, -3, 17, -88, 95, 109, -98, -108, -34}, new byte[]{-111, 54, 10, -12, -13, -82, -119, 50}));
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor2);
            } else {
                composer2.useNode();
            }
            Composer r0 = Updater.m3675constructorimpl(composer2);
            Updater.m3682setimpl(r0, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r0, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r0.getInserting() || !Intrinsics.areEqual(r0.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                r0.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                r0.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3682setimpl(r0, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -384784025, StringFog.decrypt(new byte[]{48, -105, 89, 49, -105, Ascii.RS, -123, -66, Utf8.REPLACEMENT_BYTE, -106, 91, 50, -52, 70, -60, -25, Ascii.GS, -127, 10, 5, Byte.MIN_VALUE, Ascii.CAN, -58, -71, 1, -55, Ascii.SO}, new byte[]{115, -81, 97, 113, -93, 42, -79, -118}));
            ColumnScope columnScope3 = ColumnScopeInstance.INSTANCE;
            Uri access$ProfileScreen$lambda$11 = ProfileScreenKt.ProfileScreen$lambda$11(mutableState2);
            if (access$ProfileScreen$lambda$11 == null || (str = access$ProfileScreen$lambda$11.toString()) == null) {
                str = ProfileScreenKt.ProfileScreen$lambda$2(mutableState3);
            }
            String str2 = str;
            Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.empty_icon, composer2, 0);
            Painter painterResource2 = PainterResources_androidKt.painterResource(R.drawable.empty_icon, composer2, 0);
            ContentScale fillBounds = ContentScale.Companion.getFillBounds();
            float f = (float) 80;
            Modifier r10 = SizeKt.m845size3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f));
            composer2.startReplaceGroup(-1480765327);
            boolean changedInstance = composer2.changedInstance(managedActivityResultLauncher);
            Object rememberedValue = composer2.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new ProfileScreenKt$ProfileScreen$2$$ExternalSyntheticLambda0(managedActivityResultLauncher);
                composer2.updateRememberedValue(rememberedValue);
            }
            composer2.endReplaceGroup();
            Composer composer3 = composer;
            MutableState<String> mutableState5 = mutableState;
            ProfileVIewModel profileVIewModel2 = profileVIewModel;
            BoxScope boxScope2 = boxScope;
            MutableState<Boolean> mutableState6 = mutableState4;
            float f2 = f;
            MutableState<Uri> mutableState7 = mutableState2;
            SingletonAsyncImageKt.m7476AsyncImagex1rPTaM(str2, (String) null, MortalKt.mortal(r10, (Function0) rememberedValue), painterResource2, painterResource, (Painter) null, (Function1<? super AsyncImagePainter.State.Loading, Unit>) null, (Function1<? super AsyncImagePainter.State.Success, Unit>) null, (Function1<? super AsyncImagePainter.State.Error, Unit>) null, (Alignment) null, fillBounds, 0.0f, (ColorFilter) null, 0, false, composer3, 48, 6, 31712);
            SpacerKt.Spacer(SizeKt.m831height3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl((float) 24)), composer3, 6);
            Composer composer4 = composer;
            TextKt.m2692Text4IGK_g(StringFog.decrypt(new byte[]{-99, 47, -95, 105, 79, -5, -24, -4}, new byte[]{-45, 70, -62, 2, 33, -102, -123, -103}), (Modifier) null, Color.Companion.m4276getWhite0d7_KjU(), TextUnitKt.getSp(28), (FontStyle) null, (FontWeight) null, FontFamilyKt.FontFamily(FontKt.m6661FontYpTlLL0$default(R.font.playtone, (FontWeight) null, 0, 0, 14, (Object) null)), 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 3462, 0, 130994);
            SpacerKt.Spacer(SizeKt.m831height3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl((float) 4)), composer4, 6);
            String access$ProfileScreen$lambda$5 = ProfileScreenKt.ProfileScreen$lambda$5(mutableState5);
            if (access$ProfileScreen$lambda$5 == null) {
                access$ProfileScreen$lambda$5 = "";
            }
            String str3 = access$ProfileScreen$lambda$5;
            TextStyle r102 = TextStyle.m6577copyp1EtxEg$default(TextStyle.Companion.getDefault(), Color.Companion.m4276getWhite0d7_KjU(), TextUnitKt.getSp(20), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, FontFamilyKt.FontFamily(FontKt.m6661FontYpTlLL0$default(R.font.playtone, (FontWeight) null, 0, 0, 14, (Object) null)), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777180, (Object) null);
            Composer composer5 = composer;
            TextFieldColors r23 = TextFieldDefaults.INSTANCE.m2671colors0hiis_0(0, 0, 0, 0, Color.Companion.m4274getTransparent0d7_KjU(), Color.Companion.m4274getTransparent0d7_KjU(), 0, 0, Color.Companion.m4274getTransparent0d7_KjU(), 0, (TextSelectionColors) null, Color.Companion.m4274getTransparent0d7_KjU(), Color.Companion.m4274getTransparent0d7_KjU(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, composer5, 100884480, 432, 0, 0, 3072, 2147477199, 4095);
            Composer composer6 = composer5;
            float f3 = (float) 200;
            float f4 = (float) 16;
            float f5 = (float) 2;
            Modifier r3 = BorderKt.m259borderxT4_qwU(BackgroundKt.background$default(SizeKt.m850width3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f3)), Brush.Companion.m4186verticalGradient8A3gB4$default(Brush.Companion, CollectionsKt.listOf(Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_1, composer6, 0)), Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_2, composer6, 0)), Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_3, composer6, 0))), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl(f4)), 0.0f, 4, (Object) null), Dp.m7111constructorimpl(f5), ColorResources_androidKt.colorResource(R.color.seq_border, composer6, 0), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl(f4)));
            composer6.startReplaceGroup(-1480749388);
            MutableState<String> mutableState8 = mutableState5;
            boolean changed = composer6.changed((Object) mutableState8);
            Object rememberedValue2 = composer6.rememberedValue();
            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new ProfileScreenKt$ProfileScreen$2$$ExternalSyntheticLambda1(mutableState8);
                composer6.updateRememberedValue(rememberedValue2);
            }
            composer6.endReplaceGroup();
            float f6 = f3;
            float f7 = f4;
            MutableState<String> mutableState9 = mutableState8;
            Composer composer7 = composer;
            TextFieldKt.TextField(str3, (Function1<? super String, Unit>) (Function1) rememberedValue2, r3, false, false, r102, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 1, 0, (MutableInteractionSource) null, (Shape) null, r23, composer7, 0, 100663296, 0, 3932120);
            Composer composer8 = composer7;
            ComposerKt.sourceInformationMarkerEnd(composer8);
            composer8.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer8);
            ComposerKt.sourceInformationMarkerEnd(composer8);
            ComposerKt.sourceInformationMarkerEnd(composer8);
            Alignment center3 = Alignment.Companion.getCenter();
            BoxScope boxScope3 = boxScope2;
            Modifier align = boxScope3.align(BorderKt.m259borderxT4_qwU(BackgroundKt.background$default(SizeKt.fillMaxHeight(SizeKt.fillMaxWidth(Modifier.Companion, 0.9f), 0.1f), Brush.Companion.m4186verticalGradient8A3gB4$default(Brush.Companion, CollectionsKt.listOf(Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_1, composer8, 0)), Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_2, composer8, 0)), Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_3, composer8, 0))), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl(f7)), 0.0f, 4, (Object) null), Dp.m7111constructorimpl(f5), ColorResources_androidKt.colorResource(R.color.seq_border, composer8, 0), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl(f7))), Alignment.Companion.getTopCenter());
            ComposerKt.sourceInformationMarkerStart(composer8, 733328855, StringFog.decrypt(new byte[]{-61, 87, 6, 90, 45, Ascii.DC4, 54, 78, -88, 38, 2, 41, 110, 95, 54, 41, -78, 84, Ascii.GS, 43, 122, 88, 83, 47, -77, 36, Ascii.DC4, 90, 45, Ascii.DC4, 49, 117, -12, 55, Ascii.FS, 111, 113, Ascii.RS, 121, 113}, new byte[]{Byte.MIN_VALUE, Ascii.DC4, 46, Ascii.CAN, 66, 108, Ascii.US, Ascii.RS}));
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center3, false);
            ComposerKt.sourceInformationMarkerStart(composer8, -1323940314, StringFog.decrypt(new byte[]{1, -42, Ascii.EM, -5, -48, 52, 36, Ascii.VT, 54, -68, 97, -97, -112, 124, 103, 76, 107, -94, 8, -9, -126, Byte.MAX_VALUE, 123, 70, Ascii.SO, -89, 2, -101, -119, Byte.MAX_VALUE, Ascii.VT, 77, 113, -96, 8, -5, -123, 124, 122, 68, Ascii.SO, -12, 72, -40, -60, 57, 101, Ascii.NAK, 54, -74, 9, -121, -36, Utf8.REPLACEMENT_BYTE, 45, Ascii.SYN}, new byte[]{66, -107, 49, -73, -79, 77, 75, 126}));
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer8, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer8.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer8, align);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer8, -692256719, StringFog.decrypt(new byte[]{-22, -67, 10, 58, Ascii.SYN, 50, -120, 104, -53, -110, 71, 43, Ascii.FS, 42, -117, 102, -38, -101, 108, 7, Ascii.ETB, 34, -46, 89, -127, -49, Ascii.SO, 90, 90, 116, -52, Utf8.REPLACEMENT_BYTE, -23, -49, Ascii.SYN, 88, 69, 117, -73, 48, -109, -67, 77, 5, 3, 40, -120, 104, -53, -110, 71, Ascii.ESC, 93, 44, -113, 42, -112, -105, 69, 2, Ascii.DC4, 55}, new byte[]{-87, -2, 34, 104, 115, 71, -5, 9}));
            if (!(composer8.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer8.startReusableNode();
            if (composer8.getInserting()) {
                composer8.createNode(constructor3);
            } else {
                composer8.useNode();
            }
            Composer r6 = Updater.m3675constructorimpl(composer8);
            Updater.m3682setimpl(r6, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r6, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r6.getInserting() || !Intrinsics.areEqual(r6.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash3))) {
                r6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                r6.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3682setimpl(r6, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer8, -2146769399, StringFog.decrypt(new byte[]{55, -10, -106, 119, -103, Base64.padSymbol, -91, -17, 56, -8, -97, 117, -59, 113, -71, -67, 0, -30, -105, SignedBytes.MAX_POWER_OF_TWO, -103, 123, -15, -71}, new byte[]{116, -63, -91, 55, -86, 9, -105, -42}));
            BoxScope boxScope4 = BoxScopeInstance.INSTANCE;
            FontFamily FontFamily = FontFamilyKt.FontFamily(FontKt.m6661FontYpTlLL0$default(R.font.playtone, (FontWeight) null, 0, 0, 14, (Object) null));
            Composer composer9 = composer;
            TextKt.m2692Text4IGK_g(StringFog.decrypt(new byte[]{-46, 59, -116, 46, 126, -103, -49}, new byte[]{-126, 73, -29, 72, Ascii.ETB, -11, -86, -68}), (Modifier) null, Color.Companion.m4276getWhite0d7_KjU(), TextUnitKt.getSp(32), (FontStyle) null, (FontWeight) null, FontFamily, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer9, 3462, 0, 130994);
            Composer composer10 = composer9;
            ComposerKt.sourceInformationMarkerEnd(composer10);
            composer10.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer10);
            ComposerKt.sourceInformationMarkerEnd(composer10);
            ComposerKt.sourceInformationMarkerEnd(composer10);
            Modifier align2 = boxScope3.align(SizeKt.m831height3ABfNKs(SizeKt.m850width3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f6)), Dp.m7111constructorimpl(f2)), Alignment.Companion.getBottomCenter());
            composer10.startReplaceGroup(-1654126803);
            MutableState<String> mutableState10 = mutableState9;
            ProfileVIewModel profileVIewModel3 = profileVIewModel2;
            boolean changed2 = composer10.changed((Object) mutableState10) | composer10.changedInstance(profileVIewModel3);
            Object rememberedValue3 = composer10.rememberedValue();
            if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new ProfileScreenKt$ProfileScreen$2$$ExternalSyntheticLambda2(mutableState10, profileVIewModel3, mutableState7, mutableState6);
                composer10.updateRememberedValue(rememberedValue3);
            }
            composer10.endReplaceGroup();
            BoxKt.Box(PainterModifierKt.paint$default(MortalKt.mortal(align2, (Function0) rememberedValue3), PainterResources_androidKt.painterResource(R.drawable.ok_btn, composer10, 0), false, (Alignment) null, ContentScale.Companion.getFillBounds(), 0.0f, (ColorFilter) null, 54, (Object) null), composer10, 0);
            ComposerKt.sourceInformationMarkerEnd(composer10);
            composer10.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer10);
            ComposerKt.sourceInformationMarkerEnd(composer10);
            ComposerKt.sourceInformationMarkerEnd(composer10);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer2.skipToGroupEnd();
    }

    /* access modifiers changed from: private */
    public static final Unit invoke$lambda$9$lambda$4$lambda$1$lambda$0(ManagedActivityResultLauncher managedActivityResultLauncher) {
        managedActivityResultLauncher.launch(PickVisualMediaRequestKt.PickVisualMediaRequest$default((ActivityResultContracts.PickVisualMedia.VisualMediaType) null, 1, (Object) null));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit invoke$lambda$9$lambda$4$lambda$3$lambda$2(MutableState mutableState, String str) {
        Intrinsics.checkNotNullParameter(str, StringFog.decrypt(new byte[]{-19, Ascii.ETB}, new byte[]{-124, 99, 88, -10, -65, -87, -85, -76}));
        if (!StringsKt.contains$default((CharSequence) str, (CharSequence) "\n", false, 2, (Object) null)) {
            ProfileScreenKt.ProfileScreen$lambda$6(mutableState, str);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit invoke$lambda$9$lambda$8$lambda$7(MutableState mutableState, ProfileVIewModel profileVIewModel, MutableState mutableState2, MutableState mutableState3) {
        String access$ProfileScreen$lambda$5 = ProfileScreenKt.ProfileScreen$lambda$5(mutableState);
        if (access$ProfileScreen$lambda$5 != null) {
            if (access$ProfileScreen$lambda$5.length() > 0) {
                profileVIewModel.save(access$ProfileScreen$lambda$5, ProfileScreenKt.ProfileScreen$lambda$11(mutableState2));
            }
            ProfileScreenKt.ProfileScreen$lambda$9(mutableState3, true);
        }
        return Unit.INSTANCE;
    }
}
