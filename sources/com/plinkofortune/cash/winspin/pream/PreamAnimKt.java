package com.plinkofortune.cash.winspin.pream;

import android.content.res.Configuration;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
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
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
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
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.core.location.LocationRequestCompat;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.firebase.messaging.ServiceStarter;
import com.plinkofortune.cash.winspin.R;
import com.plinkofortune.cash.winspin.StringFog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006²\u0006\n\u0010\u0007\u001a\u00020\bX\u0002²\u0006\n\u0010\t\u001a\u00020\bX\u0002²\u0006\n\u0010\n\u001a\u00020\bX\u0002²\u0006\n\u0010\u000b\u001a\u00020\bX\u0002²\u0006\n\u0010\f\u001a\u00020\bX\u0002²\u0006\n\u0010\r\u001a\u00020\bX\u0002²\u0006\n\u0010\u000e\u001a\u00020\bX\u0002"}, d2 = {"progressUpdatable", "Landroidx/compose/runtime/MutableFloatState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/MutableFloatState;", "PreamAnim", "", "(Landroidx/compose/runtime/Composer;I)V", "app_release", "progress", "", "offset1Y", "offset2Y", "offset3Y", "offset4Y", "offset5Y", "offset6Y"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: PreamAnim.kt */
public final class PreamAnimKt {
    /* access modifiers changed from: private */
    public static final Unit PreamAnim$lambda$32(int i, Composer composer, int i2) {
        PreamAnim(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final MutableFloatState progressUpdatable(Composer composer, int i) {
        composer.startReplaceGroup(-1004180691);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1004180691, i, -1, StringFog.decrypt(new byte[]{-35, 52, 4, 5, 111, Ascii.SO, 93, Ascii.CAN, -43, 52, Ascii.SI, 68, 109, Ascii.SYN, 65, Ascii.CAN, -37, 117, 10, 74, 108, 10, Ascii.SUB, 1, -41, 53, Ascii.SUB, 91, 118, Ascii.FF, Ascii.SUB, 6, -52, 62, 8, 70, 49, Ascii.DC2, 70, Ascii.EM, -39, 41, Ascii.FF, 88, 108, 55, 68, Ascii.DC2, -33, 47, 8, 73, 115, 7, Ascii.DC4, 94, -18, 41, Ascii.FF, 74, 114, 35, 90, Ascii.US, -45, 117, 2, 95, 37, 86, 2, 95}, new byte[]{-66, 91, 105, 43, Ascii.US, 98, 52, 118}));
        }
        composer.startReplaceGroup(1584785390);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
            composer.updateRememberedValue(rememberedValue);
        }
        MutableFloatState mutableFloatState = (MutableFloatState) rememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(1584787498);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = AnimatableKt.Animatable$default(mutableFloatState.getFloatValue(), 0.0f, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue2);
        }
        Animatable animatable = (Animatable) rememberedValue2;
        composer.endReplaceGroup();
        composer.startReplaceGroup(1584790361);
        boolean changedInstance = composer.changedInstance(animatable);
        Object rememberedValue3 = composer.rememberedValue();
        if (changedInstance || rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = new PreamAnimKt$progressUpdatable$1$1(mutableFloatState, animatable, (Continuation<? super PreamAnimKt$progressUpdatable$1$1>) null);
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceGroup();
        EffectsKt.LaunchedEffect((Object) 0, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue3, composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return mutableFloatState;
    }

    public static final void PreamAnim(Composer composer, int i) {
        int i2 = i;
        Composer startRestartGroup = composer.startRestartGroup(-337810379);
        if (i2 != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-337810379, i2, -1, StringFog.decrypt(new byte[]{-69, Ascii.ESC, -73, 124, 4, 104, 52, 8, -77, Ascii.ESC, -68, Base64.padSymbol, 6, 112, 40, 8, -67, 90, -71, 51, 7, 108, 115, 17, -79, Ascii.SUB, -87, 34, Ascii.GS, 106, 115, Ascii.SYN, -86, 17, -69, Utf8.REPLACEMENT_BYTE, 90, 84, 47, 3, -71, Ascii.EM, -101, 60, Ascii.GS, 105, 125, 78, -120, 6, -65, 51, Ascii.EM, 69, 51, Ascii.SI, -75, 90, -79, 38, 78, 60, 109, 79}, new byte[]{-40, 116, -38, 82, 116, 4, 93, 102}));
            }
            MutableFloatState progressUpdatable = progressUpdatable(startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, StringFog.decrypt(new byte[]{-77, 109, 122, -126, -126, 2, -25, -63, -125, 71, 52, -88, -126, 1, -37, -63, -109, 79, 44, -17, -122, Ascii.ESC, -76, -105, -103, 73, 42, -90, -99}, new byte[]{-16, 46, SignedBytes.MAX_POWER_OF_TWO, -63, -19, 111, -105, -82}));
            Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            float r13 = Dp.m7111constructorimpl((float) ((Configuration) consume).screenWidthDp);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, StringFog.decrypt(new byte[]{-120, -29, -25, 123, 47, -25, -105, -84, -72, -55, -87, 81, 47, -28, -85, -84, -88, -63, -79, Ascii.SYN, 43, -2, -60, -6, -94, -57, -73, 95, 48}, new byte[]{-53, -96, -35, 56, SignedBytes.MAX_POWER_OF_TWO, -118, -25, -61}));
            Object consume2 = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            float r2 = Dp.m7111constructorimpl((float) ((Configuration) consume2).screenHeightDp);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, StringFog.decrypt(new byte[]{-19, -100, -41, -53, -105, 52, 59, -96, -35, -74, -103, -31, -105, 55, 7, -96, -51, -66, -127, -90, -109, 45, 104, -10, -57, -72, -121, -17, -120}, new byte[]{-82, -33, -19, -120, -8, 89, 75, -49}));
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume3;
            float r3 = density.m7091toPx0680j_4(r2);
            InfiniteTransition rememberInfiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition((String) null, startRestartGroup, 0, 1);
            float f = 0.3f * r3;
            State<Float> animateFloat = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, f, AnimationSpecKt.m151infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(1200, RangesKt.random(new IntRange(100, ServiceStarter.ERROR_UNKNOWN), (Random) Random.Default), (Easing) null, 4, (Object) null), RepeatMode.Reverse, 0, 4, (Object) null), (String) null, startRestartGroup, InfiniteTransition.$stable | 48 | (InfiniteRepeatableSpec.$stable << 9), 8);
            State<Float> animateFloat2 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, f, AnimationSpecKt.m151infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(1200, RangesKt.random(new IntRange(100, ServiceStarter.ERROR_UNKNOWN), (Random) Random.Default), (Easing) null, 4, (Object) null), RepeatMode.Reverse, 0, 4, (Object) null), (String) null, startRestartGroup, (InfiniteRepeatableSpec.$stable << 9) | InfiniteTransition.$stable | 48, 8);
            State<Float> animateFloat3 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, f, AnimationSpecKt.m151infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(1200, RangesKt.random(new IntRange(100, ServiceStarter.ERROR_UNKNOWN), (Random) Random.Default), (Easing) null, 4, (Object) null), RepeatMode.Reverse, 0, 4, (Object) null), (String) null, startRestartGroup, (InfiniteRepeatableSpec.$stable << 9) | InfiniteTransition.$stable | 48, 8);
            State<Float> animateFloat4 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, f, AnimationSpecKt.m151infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(1200, RangesKt.random(new IntRange(100, ServiceStarter.ERROR_UNKNOWN), (Random) Random.Default), (Easing) null, 4, (Object) null), RepeatMode.Reverse, 0, 4, (Object) null), (String) null, startRestartGroup, (InfiniteRepeatableSpec.$stable << 9) | InfiniteTransition.$stable | 48, 8);
            State<Float> animateFloat5 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, f, AnimationSpecKt.m151infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(1200, RangesKt.random(new IntRange(100, ServiceStarter.ERROR_UNKNOWN), (Random) Random.Default), (Easing) null, 4, (Object) null), RepeatMode.Reverse, 0, 4, (Object) null), (String) null, startRestartGroup, (InfiniteRepeatableSpec.$stable << 9) | InfiniteTransition.$stable | 48, 8);
            State<Float> animateFloat6 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, f, AnimationSpecKt.m151infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(1200, RangesKt.random(new IntRange(100, ServiceStarter.ERROR_UNKNOWN), (Random) Random.Default), (Easing) null, 4, (Object) null), RepeatMode.Reverse, 0, 4, (Object) null), (String) null, startRestartGroup, InfiniteTransition.$stable | 48 | (InfiniteRepeatableSpec.$stable << 9), 8);
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, StringFog.decrypt(new byte[]{-28, 32, 71, -77, -94, -104, -26, 77, -113, 81, 67, -64, -31, -45, -26, 42, -107, 35, 92, -62, -11, -44, -125, 44, -108, 83, 85, -77, -94, -104, -31, 118, -45, SignedBytes.MAX_POWER_OF_TWO, 93, -122, -2, -110, -87, 114}, new byte[]{-89, 99, 111, -15, -51, -32, -49, Ascii.GS}));
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, StringFog.decrypt(new byte[]{119, -22, -74, 123, -95, 5, -14, 36, SignedBytes.MAX_POWER_OF_TWO, Byte.MIN_VALUE, -50, Ascii.US, -31, 77, -79, 99, Ascii.GS, -98, -89, 119, -13, 78, -83, 105, 120, -101, -83, Ascii.ESC, -8, 78, -35, 98, 7, -100, -89, 123, -12, 77, -84, 107, 120, -56, -25, 88, -75, 8, -77, 58, SignedBytes.MAX_POWER_OF_TWO, -118, -90, 7, -83, Ascii.SO, -5, 57}, new byte[]{52, -87, -98, 55, -64, 124, -99, 81}));
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, StringFog.decrypt(new byte[]{-101, 108, 107, 4, 46, 120, -54, 42, -70, 67, 38, Ascii.NAK, 36, 96, -55, 36, -85, 74, Ascii.CR, 57, 47, 104, -112, Ascii.ESC, -16, Ascii.RS, 111, 100, 98, 62, -114, 125, -104, Ascii.RS, 119, 102, 125, Utf8.REPLACEMENT_BYTE, -11, 114, -30, 108, 44, 59, 59, 98, -54, 42, -70, 67, 38, 37, 101, 102, -51, 104, -31, 70, 36, 60, 44, 125}, new byte[]{-40, 47, 67, 86, 75, Ascii.CR, -71, 75}));
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r8 = Updater.m3675constructorimpl(startRestartGroup);
            Updater.m3682setimpl(r8, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r8, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r8.getInserting() || !Intrinsics.areEqual(r8.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r8.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3682setimpl(r8, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, StringFog.decrypt(new byte[]{82, -66, -90, -63, 41, -112, -56, -63, 93, -80, -81, -61, 117, -36, -44, -109, 101, -86, -89, -10, 41, -42, -100, -105}, new byte[]{17, -119, -107, -127, Ascii.SUB, -92, -6, -8}));
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.b1, startRestartGroup, 0);
            ContentScale fillBounds = ContentScale.Companion.getFillBounds();
            float f2 = r13 * 0.15f;
            Modifier r5 = SizeKt.m845size3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f2));
            startRestartGroup.startReplaceGroup(-1125959612);
            State<Float> state = animateFloat;
            boolean changed = startRestartGroup.changed((Object) density) | startRestartGroup.changed(r13) | startRestartGroup.changed((Object) state);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new PreamAnimKt$$ExternalSyntheticLambda0(density, r13, state);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            BoxScope boxScope2 = boxScope;
            State<Float> state2 = animateFloat6;
            Composer composer2 = startRestartGroup;
            ImageKt.Image(painterResource, (String) null, OffsetKt.offset(r5, (Function1) rememberedValue), (Alignment) null, fillBounds, 0.0f, (ColorFilter) null, composer2, 24624, (int) LocationRequestCompat.QUALITY_LOW_POWER);
            Composer composer3 = composer2;
            Painter painterResource2 = PainterResources_androidKt.painterResource(R.drawable.b2, composer3, 0);
            ContentScale fillBounds2 = ContentScale.Companion.getFillBounds();
            Modifier align = boxScope2.align(SizeKt.m845size3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f2)), Alignment.Companion.getBottomStart());
            composer3.startReplaceGroup(-1125943293);
            State<Float> state3 = animateFloat2;
            boolean changed2 = composer3.changed((Object) density) | composer3.changed(r13) | composer3.changed((Object) state3);
            Object rememberedValue2 = composer3.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new PreamAnimKt$$ExternalSyntheticLambda1(density, r13, state3);
                composer3.updateRememberedValue(rememberedValue2);
            }
            composer3.endReplaceGroup();
            Composer composer4 = composer3;
            ImageKt.Image(painterResource2, (String) null, OffsetKt.offset(align, (Function1) rememberedValue2), (Alignment) null, fillBounds2, 0.0f, (ColorFilter) null, composer4, 24624, (int) LocationRequestCompat.QUALITY_LOW_POWER);
            Composer composer5 = composer4;
            Painter painterResource3 = PainterResources_androidKt.painterResource(R.drawable.b1, composer5, 0);
            ContentScale fillBounds3 = ContentScale.Companion.getFillBounds();
            Modifier align2 = boxScope2.align(SizeKt.m845size3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f2)), Alignment.Companion.getTopCenter());
            composer5.startReplaceGroup(-1125927068);
            State<Float> state4 = animateFloat3;
            boolean changed3 = composer5.changed((Object) density) | composer5.changed(r13) | composer5.changed((Object) state4);
            Object rememberedValue3 = composer5.rememberedValue();
            if (changed3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new PreamAnimKt$$ExternalSyntheticLambda2(density, r13, state4);
                composer5.updateRememberedValue(rememberedValue3);
            }
            composer5.endReplaceGroup();
            Composer composer6 = composer5;
            ImageKt.Image(painterResource3, (String) null, OffsetKt.offset(align2, (Function1) rememberedValue3), (Alignment) null, fillBounds3, 0.0f, (ColorFilter) null, composer6, 24624, (int) LocationRequestCompat.QUALITY_LOW_POWER);
            Composer composer7 = composer6;
            Painter painterResource4 = PainterResources_androidKt.painterResource(R.drawable.b2, composer7, 0);
            ContentScale fillBounds4 = ContentScale.Companion.getFillBounds();
            Modifier align3 = boxScope2.align(SizeKt.m845size3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f2)), Alignment.Companion.getBottomCenter());
            composer7.startReplaceGroup(-1125910717);
            State<Float> state5 = animateFloat4;
            boolean changed4 = composer7.changed((Object) density) | composer7.changed(r13) | composer7.changed((Object) state5);
            Object rememberedValue4 = composer7.rememberedValue();
            if (changed4 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new PreamAnimKt$$ExternalSyntheticLambda3(density, r13, state5);
                composer7.updateRememberedValue(rememberedValue4);
            }
            composer7.endReplaceGroup();
            Composer composer8 = composer7;
            ImageKt.Image(painterResource4, (String) null, OffsetKt.offset(align3, (Function1) rememberedValue4), (Alignment) null, fillBounds4, 0.0f, (ColorFilter) null, composer8, 24624, (int) LocationRequestCompat.QUALITY_LOW_POWER);
            Composer composer9 = composer8;
            Painter painterResource5 = PainterResources_androidKt.painterResource(R.drawable.b1, composer9, 0);
            ContentScale fillBounds5 = ContentScale.Companion.getFillBounds();
            Modifier align4 = boxScope2.align(SizeKt.m845size3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f2)), Alignment.Companion.getTopEnd());
            composer9.startReplaceGroup(-1125894588);
            boolean changed5 = composer9.changed((Object) density) | composer9.changed(r13) | composer9.changed((Object) animateFloat5);
            Object rememberedValue5 = composer9.rememberedValue();
            if (changed5 || rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = new PreamAnimKt$$ExternalSyntheticLambda4(density, r13, animateFloat5);
                composer9.updateRememberedValue(rememberedValue5);
            }
            composer9.endReplaceGroup();
            Composer composer10 = composer9;
            ImageKt.Image(painterResource5, (String) null, OffsetKt.offset(align4, (Function1) rememberedValue5), (Alignment) null, fillBounds5, 0.0f, (ColorFilter) null, composer10, 24624, (int) LocationRequestCompat.QUALITY_LOW_POWER);
            Composer composer11 = composer10;
            Painter painterResource6 = PainterResources_androidKt.painterResource(R.drawable.b2, composer11, 0);
            ContentScale fillBounds6 = ContentScale.Companion.getFillBounds();
            Modifier align5 = boxScope2.align(SizeKt.m845size3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f2)), Alignment.Companion.getBottomEnd());
            composer11.startReplaceGroup(-1125878333);
            boolean changed6 = composer11.changed((Object) density) | composer11.changed(r13) | composer11.changed((Object) state2);
            Object rememberedValue6 = composer11.rememberedValue();
            if (changed6 || rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = new PreamAnimKt$$ExternalSyntheticLambda5(density, r13, state2);
                composer11.updateRememberedValue(rememberedValue6);
            }
            composer11.endReplaceGroup();
            Composer composer12 = composer11;
            ImageKt.Image(painterResource6, (String) null, OffsetKt.offset(align5, (Function1) rememberedValue6), (Alignment) null, fillBounds6, 0.0f, (ColorFilter) null, composer12, 24624, (int) LocationRequestCompat.QUALITY_LOW_POWER);
            Composer composer13 = composer12;
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(boxScope2.align(Modifier.Companion, Alignment.Companion.getCenter()), 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer13, -483455358, StringFog.decrypt(new byte[]{-55, -100, -39, -42, -108, -100, -115, 116, -28, -10, -95, -67, -55, -36, -53, 53, -69, -10, -55, -93, -69, -60, -53, 42, -70, -109, -57, -92, -41, -56, -49, 89, -66, -20, -56, -93, -73, -63, -53, 42, -80, -100, -98, -7, -114, -99, -106, 55, -31, -85, -46, -89, -116, -61, -118, Byte.MAX_VALUE, -27}, new byte[]{-118, -33, -15, -107, -5, -16, -8, Ascii.EM}));
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer13, 48);
            ComposerKt.sourceInformationMarkerStart(composer13, -1323940314, StringFog.decrypt(new byte[]{-6, -84, 103, 56, -105, 32, 71, -49, -51, -58, Ascii.US, 92, -41, 104, 4, -120, -112, -40, 118, 52, -59, 107, Ascii.CAN, -126, -11, -35, 124, 88, -50, 107, 104, -119, -118, -38, 118, 56, -62, 104, Ascii.EM, Byte.MIN_VALUE, -11, -114, 54, Ascii.ESC, -125, 45, 6, -47, -51, -52, 119, 68, -101, 43, 78, -46}, new byte[]{-71, -17, 79, 116, -10, 89, 40, -70}));
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer13, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer13.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer13, fillMaxWidth$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer13, -692256719, StringFog.decrypt(new byte[]{-87, 52, 118, 113, -33, -98, -83, 9, -120, Ascii.ESC, 59, 96, -43, -122, -82, 7, -103, Ascii.DC2, Ascii.DLE, 76, -34, -114, -9, 56, -62, 70, 114, 17, -109, -40, -23, 94, -86, 70, 106, 19, -116, -39, -110, 81, -48, 52, 49, 78, -54, -124, -83, 9, -120, Ascii.ESC, 59, 80, -108, Byte.MIN_VALUE, -86, 75, -45, Ascii.RS, 57, 73, -35, -101}, new byte[]{-22, 119, 94, 35, -70, -21, -34, 104}));
            if (!(composer13.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer13.startReusableNode();
            if (composer13.getInserting()) {
                composer13.createNode(constructor2);
            } else {
                composer13.useNode();
            }
            Composer r52 = Updater.m3675constructorimpl(composer13);
            Updater.m3682setimpl(r52, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r52, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r52.getInserting() || !Intrinsics.areEqual(r52.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash2))) {
                r52.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                r52.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3682setimpl(r52, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer13, -384784025, StringFog.decrypt(new byte[]{83, 73, -57, -2, -30, 9, Ascii.ETB, -112, 92, 72, -59, -3, -71, 81, 86, -55, 126, 95, -108, -54, -11, Ascii.SI, 84, -105, 98, Ascii.ETB, -112}, new byte[]{Ascii.DLE, 113, -1, -66, -42, Base64.padSymbol, 35, -92}));
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            long sp = TextUnitKt.getSp(28);
            Composer composer14 = composer13;
            TextKt.m2692Text4IGK_g(StringFog.decrypt(new byte[]{-43, -86, -120, 93, -42, -103, 89, 66, -73, -21}, new byte[]{-103, -59, -23, 57, -65, -9, 62, 108}), (Modifier) null, Color.Companion.m4276getWhite0d7_KjU(), sp, (FontStyle) null, (FontWeight) null, FontFamilyKt.FontFamily(FontKt.m6661FontYpTlLL0$default(R.font.playtone, (FontWeight) null, 0, 0, 14, (Object) null)), 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer14, 3462, 0, 130994);
            Composer composer15 = composer14;
            float f3 = (float) 60;
            float f4 = (float) 16;
            float f5 = (float) 2;
            Modifier clip = ClipKt.clip(BorderKt.m259borderxT4_qwU(BackgroundKt.background$default(SizeKt.m831height3ABfNKs(SizeKt.fillMaxWidth(Modifier.Companion, 0.8f), Dp.m7111constructorimpl(f3)), Brush.Companion.m4186verticalGradient8A3gB4$default(Brush.Companion, CollectionsKt.listOf(Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_1, composer15, 0)), Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_2, composer15, 0)), Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.seq_bg_3, composer15, 0))), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl(f4)), 0.0f, 4, (Object) null), Dp.m7111constructorimpl(f5), ColorResources_androidKt.colorResource(R.color.seq_border, composer15, 0), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl(f4))), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl(f4)));
            ComposerKt.sourceInformationMarkerStart(composer15, 733328855, StringFog.decrypt(new byte[]{86, -76, -111, SignedBytes.MAX_POWER_OF_TWO, -10, 47, 82, 37, Base64.padSymbol, -59, -107, 51, -75, 100, 82, 66, 39, -73, -118, 49, -95, 99, 55, 68, 38, -57, -125, SignedBytes.MAX_POWER_OF_TWO, -10, 47, 85, Ascii.RS, 97, -44, -117, 117, -86, 37, Ascii.GS, Ascii.SUB}, new byte[]{Ascii.NAK, -9, -71, 2, -103, 87, 123, 117}));
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer15, -1323940314, StringFog.decrypt(new byte[]{46, -100, -9, -24, -31, 84, 114, -47, Ascii.EM, -10, -113, -116, -95, Ascii.FS, 49, -106, 68, -24, -26, -28, -77, Ascii.US, 45, -100, 33, -19, -20, -120, -72, Ascii.US, 93, -105, 94, -22, -26, -24, -76, Ascii.FS, 44, -98, 33, -66, -90, -53, -11, 89, 51, -49, Ascii.EM, -4, -25, -108, -19, 95, 123, -52}, new byte[]{109, -33, -33, -92, Byte.MIN_VALUE, 45, Ascii.GS, -92}));
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer15, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer15.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer15, clip);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer15, -692256719, StringFog.decrypt(new byte[]{-100, -43, -54, 35, 35, -83, -19, -20, -67, -6, -121, 50, 41, -75, -18, -30, -84, -13, -84, Ascii.RS, 34, -67, -73, -35, -9, -89, -50, 67, 111, -21, -87, -69, -97, -89, -42, 65, 112, -22, -46, -76, -27, -43, -115, Ascii.FS, 54, -73, -19, -20, -67, -6, -121, 2, 104, -77, -22, -82, -26, -1, -123, Ascii.ESC, 33, -88}, new byte[]{-33, -106, -30, 113, 70, -40, -98, -115}));
            if (!(composer15.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer15.startReusableNode();
            if (composer15.getInserting()) {
                composer15.createNode(constructor3);
            } else {
                composer15.useNode();
            }
            Composer r10 = Updater.m3675constructorimpl(composer15);
            Updater.m3682setimpl(r10, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3682setimpl(r10, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r10.getInserting() || !Intrinsics.areEqual(r10.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash3))) {
                r10.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                r10.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3682setimpl(r10, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer15, -2146769399, StringFog.decrypt(new byte[]{-88, -36, 42, 8, -90, 105, 95, -63, -89, -46, 35, 10, -6, 37, 67, -109, -97, -56, 43, Utf8.REPLACEMENT_BYTE, -90, 47, Ascii.VT, -105}, new byte[]{-21, -21, Ascii.EM, 72, -107, 93, 109, -8}));
            BoxKt.Box(ClipKt.clip(BorderKt.m259borderxT4_qwU(BackgroundKt.background$default(SizeKt.fillMaxWidth(SizeKt.m831height3ABfNKs(Modifier.Companion, Dp.m7111constructorimpl(f3)), PreamAnim$lambda$3(progressUpdatable) / 100.0f), Brush.Companion.m4186verticalGradient8A3gB4$default(Brush.Companion, CollectionsKt.listOf(Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.progress_1, composer15, 0)), Color.m4229boximpl(ColorResources_androidKt.colorResource(R.color.progress_2, composer15, 0))), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl(f4)), 0.0f, 4, (Object) null), Dp.m7111constructorimpl(f5), ColorResources_androidKt.colorResource(R.color.seq_border, composer15, 0), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl(f4))), RoundedCornerShapeKt.m1150RoundedCornerShape0680j_4(Dp.m7111constructorimpl(f4))), composer15, 0);
            FontFamily FontFamily = FontFamilyKt.FontFamily(FontKt.m6661FontYpTlLL0$default(R.font.playtone, (FontWeight) null, 0, 0, 14, (Object) null));
            Composer composer16 = composer15;
            TextKt.m2692Text4IGK_g(((int) PreamAnim$lambda$3(progressUpdatable)) + "%", BoxScopeInstance.INSTANCE.align(Modifier.Companion, Alignment.Companion.getCenter()), Color.Companion.m4276getWhite0d7_KjU(), TextUnitKt.getSp(28), (FontStyle) null, (FontWeight) null, FontFamily, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer16, 3456, 0, 130992);
            startRestartGroup = composer16;
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
            endRestartGroup.updateScope(new PreamAnimKt$$ExternalSyntheticLambda6(i));
        }
    }

    private static final float PreamAnim$lambda$3(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    /* access modifiers changed from: private */
    public static final IntOffset PreamAnim$lambda$31$lambda$13$lambda$12(Density density, float f, State state, Density density2) {
        Intrinsics.checkNotNullParameter(density2, StringFog.decrypt(new byte[]{-125, -72, -5, 94, -33, -22, -21, -94, -63, -65, -10, 67}, new byte[]{-89, -52, -109, 55, -84, -50, -124, -60}));
        return IntOffset.m7232boximpl(IntOffsetKt.IntOffset(0, (-((int) (density.m7091toPx0680j_4(f) * 0.15f))) + ((int) PreamAnim$lambda$5(state))));
    }

    /* access modifiers changed from: private */
    public static final IntOffset PreamAnim$lambda$31$lambda$16$lambda$15(Density density, float f, State state, Density density2) {
        Intrinsics.checkNotNullParameter(density2, StringFog.decrypt(new byte[]{-19, 96, -2, -106, 100, 106, 94, 106, -81, 103, -13, -117}, new byte[]{-55, Ascii.DC4, -106, -1, Ascii.ETB, 78, 49, Ascii.FF}));
        return IntOffset.m7232boximpl(IntOffsetKt.IntOffset(0, ((int) (density.m7091toPx0680j_4(f) * 0.15f)) - ((int) PreamAnim$lambda$6(state))));
    }

    /* access modifiers changed from: private */
    public static final IntOffset PreamAnim$lambda$31$lambda$19$lambda$18(Density density, float f, State state, Density density2) {
        Intrinsics.checkNotNullParameter(density2, StringFog.decrypt(new byte[]{87, 2, -101, -58, 110, -55, 9, -109, Ascii.NAK, 5, -106, -37}, new byte[]{115, 118, -13, -81, Ascii.GS, -19, 102, -11}));
        return IntOffset.m7232boximpl(IntOffsetKt.IntOffset(0, (-((int) (density.m7091toPx0680j_4(f) * 0.15f))) + ((int) PreamAnim$lambda$7(state))));
    }

    /* access modifiers changed from: private */
    public static final IntOffset PreamAnim$lambda$31$lambda$22$lambda$21(Density density, float f, State state, Density density2) {
        Intrinsics.checkNotNullParameter(density2, StringFog.decrypt(new byte[]{-88, 69, 51, 1, -63, -69, -9, 9, -22, 66, 62, Ascii.FS}, new byte[]{-116, 49, 91, 104, -78, -97, -104, 111}));
        return IntOffset.m7232boximpl(IntOffsetKt.IntOffset(0, ((int) (density.m7091toPx0680j_4(f) * 0.15f)) - ((int) PreamAnim$lambda$8(state))));
    }

    /* access modifiers changed from: private */
    public static final IntOffset PreamAnim$lambda$31$lambda$25$lambda$24(Density density, float f, State state, Density density2) {
        Intrinsics.checkNotNullParameter(density2, StringFog.decrypt(new byte[]{-60, 107, -65, -127, 103, Ascii.DC2, 118, -95, -122, 108, -78, -100}, new byte[]{-32, Ascii.US, -41, -24, Ascii.DC4, 54, Ascii.EM, -57}));
        return IntOffset.m7232boximpl(IntOffsetKt.IntOffset(0, (-((int) (density.m7091toPx0680j_4(f) * 0.15f))) + ((int) PreamAnim$lambda$9(state))));
    }

    /* access modifiers changed from: private */
    public static final IntOffset PreamAnim$lambda$31$lambda$28$lambda$27(Density density, float f, State state, Density density2) {
        Intrinsics.checkNotNullParameter(density2, StringFog.decrypt(new byte[]{-102, 79, 66, -15, 72, -88, 89, -73, -40, 72, 79, -20}, new byte[]{-66, 59, 42, -104, 59, -116, 54, -47}));
        return IntOffset.m7232boximpl(IntOffsetKt.IntOffset(0, ((int) (density.m7091toPx0680j_4(f) * 0.15f)) - ((int) PreamAnim$lambda$10(state))));
    }

    private static final float PreamAnim$lambda$5(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float PreamAnim$lambda$6(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float PreamAnim$lambda$7(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float PreamAnim$lambda$8(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float PreamAnim$lambda$9(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float PreamAnim$lambda$10(State<Float> state) {
        return state.getValue().floatValue();
    }
}
