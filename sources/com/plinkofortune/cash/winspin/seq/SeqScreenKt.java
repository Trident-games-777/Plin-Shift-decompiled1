package com.plinkofortune.cash.winspin.seq;

import android.content.res.Configuration;
import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.core.location.LocationRequestCompat;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.plinkofortune.cash.winspin.R;
import com.plinkofortune.cash.winspin.StringFog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\r\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007²\u0006\f\u0010\b\u001a\u0004\u0018\u00010\tX\u0002²\u0006\n\u0010\n\u001a\u00020\u0003X\u0002²\u0006\f\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0002²\u0006\f\u0010\r\u001a\u0004\u0018\u00010\fX\u0002²\u0006\f\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0002²\u0006\f\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0002²\u0006\f\u0010\u0010\u001a\u0004\u0018\u00010\fX\u0002²\u0006\f\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0002²\u0006\f\u0010\u0012\u001a\u0004\u0018\u00010\fX\u0002²\u0006\n\u0010\u0013\u001a\u00020\u0014X\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0014X\u0002²\u0006\n\u0010\u0016\u001a\u00020\u0014X\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0014X\u0002²\u0006\n\u0010\u0018\u001a\u00020\u0014X\u0002²\u0006\n\u0010\u0019\u001a\u00020\u0014X\u0002²\u0006\n\u0010\u001a\u001a\u00020\u0014X\u0002²\u0006\n\u0010\u001b\u001a\u00020\u0014X\u0002²\u0006\n\u0010\u001c\u001a\u00020\u0014X\u0002²\u0006\n\u0010\u001d\u001a\u00020\u0014X\u0002²\u0006\n\u0010\u001e\u001a\u00020\u0014X\u0002²\u0006\n\u0010\u001f\u001a\u00020\u0014X\u0002²\u0006\n\u0010 \u001a\u00020\u0014X\u0002²\u0006\n\u0010!\u001a\u00020\u0014X\u0002²\u0006\n\u0010\"\u001a\u00020#X\u0002²\u0006\n\u0010$\u001a\u00020#X\u0002²\u0006\n\u0010%\u001a\u00020#X\u0002²\u0006\n\u0010&\u001a\u00020#X\u0002²\u0006\n\u0010'\u001a\u00020#X\u0002²\u0006\n\u0010(\u001a\u00020#X\u0002²\u0006\n\u0010)\u001a\u00020#X\u0002²\u0006\n\u0010*\u001a\u00020\u0014X\u0002²\u0006\n\u0010+\u001a\u00020\u0014X\u0002²\u0006\n\u0010,\u001a\u00020\u0014X\u0002²\u0006\n\u0010-\u001a\u00020\u0014X\u0002²\u0006\n\u0010.\u001a\u00020\u0014X\u0002²\u0006\n\u0010/\u001a\u00020\u0014X\u0002²\u0006\n\u00100\u001a\u00020\u0014X\u0002"}, d2 = {"SeqScreen", "", "round", "", "mortal", "Lkotlin/Function0;", "(ILkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_release", "state", "Lcom/plinkofortune/cash/winspin/seq/SeqState;", "animatedScore", "ballInScreen1", "Lcom/plinkofortune/cash/winspin/seq/models/BallInScreen;", "ballInScreen2", "ballInScreen3", "ballInScreen4", "ballInScreen5", "ballInScreen6", "ballInScreen7", "ballInScreen1OffsetX", "", "ballInScreen2OffsetX", "ballInScreen3OffsetX", "ballInScreen4OffsetX", "ballInScreen5OffsetX", "ballInScreen6OffsetX", "ballInScreen7OffsetX", "ballInScreen1OffsetY", "ballInScreen2OffsetY", "ballInScreen3OffsetY", "ballInScreen4OffsetY", "ballInScreen5OffsetY", "ballInScreen6OffsetY", "ballInScreen7OffsetY", "multi1", "Lcom/plinkofortune/cash/winspin/seq/models/Multi;", "multi2", "multi3", "multi4", "multi5", "multi6", "multi7", "multi1Offset", "multi2Offset", "multi3Offset", "multi4Offset", "multi5Offset", "multi6Offset", "multi7Offset"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: SeqScreen.kt */
public final class SeqScreenKt {
    /* access modifiers changed from: private */
    public static final Unit SeqScreen$lambda$5(int i, Function0 function0, int i2, Composer composer, int i3) {
        SeqScreen(i, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final void SeqScreen(int i, Function0<Unit> function0, Composer composer, int i2) {
        int i3;
        Composer composer2;
        CreationExtras creationExtras;
        int i4 = i;
        Function0<Unit> function02 = function0;
        int i5 = i2;
        Intrinsics.checkNotNullParameter(function02, StringFog.decrypt(new byte[]{65, -11, Ascii.ETB, -87, -86, -120}, new byte[]{44, -102, 101, -35, -53, -28, 58, 59}));
        Composer startRestartGroup = composer.startRestartGroup(1819314516);
        if ((i5 & 6) == 0) {
            i3 = (startRestartGroup.changed(i4) ? 4 : 2) | i5;
        } else {
            i3 = i5;
        }
        if ((i5 & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function02) ? 32 : 16;
        }
        if ((i3 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1819314516, i3, -1, StringFog.decrypt(new byte[]{-13, 108, Ascii.VT, 101, 49, -9, -54, 88, -5, 108, 0, 36, 51, -17, -42, 88, -11, 45, 5, 42, 50, -13, -115, 65, -7, 109, Ascii.NAK, 59, 40, -11, -115, 69, -11, 114, 72, Ascii.CAN, 36, -22, -16, 85, -30, 102, 3, 37, 97, -77, -16, 83, -31, 80, 5, 57, 36, -2, -51, Ascii.CAN, -5, 119, 92, 126, 112, -78}, new byte[]{-112, 3, 102, 75, 65, -101, -93, 54}));
            }
            ViewModelProvider.Factory Factory = SeqViewModel.Companion.Factory(i4);
            startRestartGroup.startReplaceableGroup(1729797275);
            ComposerKt.sourceInformation(startRestartGroup, StringFog.decrypt(new byte[]{-105, 56, -5, -39, 2, -35, 115, -114, -69, Ascii.US, -74, -61, 66, -24, 44, -16, -8, 73, -1, -98, 66, -110, 49, -9, -108, 73, -26, -97, 89, -12, 51, -17, -30, 79, -109, -99, 83, -113, 51, -113, -30, 72, -23, -7, 2, -35, 115, -114, -69, Ascii.US, -74, -61, 69, -45, 112, -32, -25, Ascii.SI, -71, -50, 93, -113}, new byte[]{-44, 123, -45, -81, 107, -72, 4, -61}));
            ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, 6);
            if (current != null) {
                if (current instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.Empty.INSTANCE;
                }
                ViewModel viewModel = ViewModelKt.viewModel(Reflection.getOrCreateKotlinClass(SeqViewModel.class), current, (String) null, Factory, creationExtras, startRestartGroup, 0, 0);
                startRestartGroup.endReplaceableGroup();
                SeqViewModel seqViewModel = (SeqViewModel) viewModel;
                boolean z = false;
                State<SeqState> collectAsState = SnapshotStateKt.collectAsState(seqViewModel.getState(), (CoroutineContext) null, startRestartGroup, 0, 1);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, StringFog.decrypt(new byte[]{94, -28, -57, 102, 7, -52, -90, -83, 110, -50, -119, 76, 7, -49, -102, -83, 126, -58, -111, Ascii.VT, 3, -43, -11, -5, 116, -64, -105, 66, Ascii.CAN}, new byte[]{Ascii.GS, -89, -3, 37, 104, -95, -42, -62}));
                Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                float r2 = Dp.m7111constructorimpl((float) ((Configuration) consume).screenWidthDp);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, StringFog.decrypt(new byte[]{-5, 32, 104, -101, 75, 58, -26, 76, -53, 10, 38, -79, 75, 57, -38, 76, -37, 2, 62, -10, 79, 35, -75, Ascii.SUB, -47, 4, 56, -65, 84}, new byte[]{-72, 99, 82, -40, 36, 87, -106, 35}));
                Object consume2 = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                float r19 = Dp.m7111constructorimpl((float) ((Configuration) consume2).screenHeightDp);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, StringFog.decrypt(new byte[]{-120, 66, -54, 36, -24, 67, 101, -60, -72, 104, -124, Ascii.SO, -24, SignedBytes.MAX_POWER_OF_TWO, 89, -60, -88, 96, -100, 73, -20, 90, 54, -110, -94, 102, -102, 0, -9}, new byte[]{-53, 1, -16, 103, -121, 46, Ascii.NAK, -85}));
                Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Density density = (Density) consume3;
                Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.bg, startRestartGroup, 0);
                ContentScale fillBounds = ContentScale.Companion.getFillBounds();
                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                startRestartGroup.startReplaceGroup(-1572207337);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) rememberedValue;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(-1572205216);
                boolean changedInstance = startRestartGroup.changedInstance(seqViewModel);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new SeqScreenKt$SeqScreen$2$1(seqViewModel);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                Composer composer3 = startRestartGroup;
                ImageKt.Image(painterResource, (String) null, ClickableKt.m279clickableO2vRcR0$default(fillMaxSize$default, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) ((KFunction) rememberedValue2), 28, (Object) null), (Alignment) null, fillBounds, 0.0f, (ColorFilter) null, composer3, 24624, (int) LocationRequestCompat.QUALITY_LOW_POWER);
                Composer composer4 = composer3;
                SeqState SeqScreen$lambda$0 = SeqScreen$lambda$0(collectAsState);
                if (SeqScreen$lambda$0 != null) {
                    if (SeqScreen$lambda$0.getWin() != null) {
                        z = true;
                    }
                    Boolean valueOf = Boolean.valueOf(z);
                    composer4.startReplaceGroup(-1572197772);
                    Object rememberedValue3 = composer4.rememberedValue();
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        rememberedValue3 = new SeqScreenKt$$ExternalSyntheticLambda0();
                        composer4.updateRememberedValue(rememberedValue3);
                    }
                    composer4.endReplaceGroup();
                    composer2 = composer4;
                    AnimatedContentKt.AnimatedContent(valueOf, (Modifier) null, (Function1) rememberedValue3, (Alignment) null, (String) null, (Function1) null, ComposableLambdaKt.rememberComposableLambda(1336964056, true, new SeqScreenKt$SeqScreen$4(SeqScreen$lambda$0, function02, density, seqViewModel, r2, r19), composer4, 54), composer2, 1573248, 58);
                } else {
                    composer2 = composer4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                throw new IllegalStateException(StringFog.decrypt(new byte[]{Ascii.FS, -70, -126, -127, -51, 77, 111, -62, Base64.padSymbol, -79, -57, -69, -9, 92, 119, -3, 55, -102, -43, -71, -63, 90, 56, -8, 51, -90, -126, -89, -42, 71, 110, -26, 54, -80, -58, -9, -46, 65, 121, -81, Ascii.RS, -70, -63, -74, -56, 126, 113, -22, 37, -104, -51, -77, -63, 68, 75, -5, Base64.padSymbol, -89, -57, -104, -45, 70, 125, -3}, new byte[]{82, -43, -94, -41, -92, 40, Ascii.CAN, -113}).toString());
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SeqScreenKt$$ExternalSyntheticLambda1(i4, function02, i5));
        }
    }

    /* access modifiers changed from: private */
    public static final ContentTransform SeqScreen$lambda$4$lambda$3(AnimatedContentTransitionScope animatedContentTransitionScope) {
        Intrinsics.checkNotNullParameter(animatedContentTransitionScope, StringFog.decrypt(new byte[]{-19, -79, -47, -124, 52, -34, -96, -87, -96, -88, -40, -103, 34, -98, -94, -88, -89, -79, -36, -125, 51}, new byte[]{-55, -59, -71, -19, 71, -6, -31, -57}));
        return AnimatedContentKt.togetherWith(EnterExitTransitionKt.fadeIn$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null), EnterExitTransitionKt.fadeOut$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null));
    }

    private static final SeqState SeqScreen$lambda$0(State<SeqState> state) {
        return state.getValue();
    }
}
