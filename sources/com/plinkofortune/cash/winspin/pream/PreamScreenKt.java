package com.plinkofortune.cash.winspin.pream;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
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
import com.plinkofortune.cash.winspin.Soleq;
import com.plinkofortune.cash.winspin.StringFog;
import com.plinkofortune.cash.winspin.lostnework.LostNetworkScreenKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\u001a\u001b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005²\u0006\n\u0010\u0006\u001a\u00020\u0007X\u0002"}, d2 = {"PreamScreen", "", "mortal", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_release", "promo", ""}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: PreamScreen.kt */
public final class PreamScreenKt {
    /* access modifiers changed from: private */
    public static final Unit PreamScreen$lambda$6(Function0 function0, int i, Composer composer, int i2) {
        PreamScreen(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void PreamScreen(Function0<Unit> function0, Composer composer, int i) {
        int i2;
        CreationExtras creationExtras;
        Function0<Unit> function02 = function0;
        int i3 = i;
        Intrinsics.checkNotNullParameter(function02, StringFog.decrypt(new byte[]{87, -33, Ascii.VT, -93, -36, 44}, new byte[]{58, -80, 121, -41, -67, SignedBytes.MAX_POWER_OF_TWO, 84, 87}));
        Composer startRestartGroup = composer.startRestartGroup(-812695135);
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-812695135, i2, -1, StringFog.decrypt(new byte[]{-125, Byte.MIN_VALUE, 117, 116, -40, 56, -15, 101, -117, Byte.MIN_VALUE, 126, 53, -38, 32, -19, 101, -123, -63, 123, 59, -37, 60, -74, 124, -119, -127, 107, 42, -63, 58, -74, 123, -110, -118, 121, 55, -122, 4, -22, 110, -127, -126, 75, 57, -38, 49, -3, 101, -64, -57, 72, 40, -51, 53, -11, 88, -125, -99, 125, Utf8.REPLACEMENT_BYTE, -58, 122, -13, Byte.MAX_VALUE, -38, -35, 43, 115}, new byte[]{-32, -17, Ascii.CAN, 90, -88, 84, -104, Ascii.VT}));
            }
            ViewModelProvider.Factory factory = PreamViewModel.Companion.getFactory();
            startRestartGroup.startReplaceableGroup(1729797275);
            ComposerKt.sourceInformation(startRestartGroup, StringFog.decrypt(new byte[]{-62, -64, Ascii.FF, 77, -89, Ascii.DLE, -83, Ascii.US, -18, -25, 65, 87, -25, 37, -14, 97, -83, -79, 8, 10, -25, 95, -17, 102, -63, -79, 17, Ascii.VT, -4, 57, -19, 126, -73, -73, 100, 9, -10, 66, -19, Ascii.RS, -73, -80, Ascii.RS, 109, -89, Ascii.DLE, -83, Ascii.US, -18, -25, 65, 87, -32, Ascii.RS, -82, 113, -78, -9, 78, 90, -8, 66}, new byte[]{-127, -125, 36, 59, -50, 117, -38, 82}));
            ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, 6);
            if (current != null) {
                if (current instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.Empty.INSTANCE;
                }
                ViewModel viewModel = ViewModelKt.viewModel(Reflection.getOrCreateKotlinClass(PreamViewModel.class), current, (String) null, factory, creationExtras, startRestartGroup, 0, 0);
                startRestartGroup.endReplaceableGroup();
                PreamViewModel preamViewModel = (PreamViewModel) viewModel;
                State collectAsState = SnapshotStateKt.collectAsState(preamViewModel.getPream(), (CoroutineContext) null, startRestartGroup, 0, 1);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, StringFog.decrypt(new byte[]{-82, 103, 68, 43, -72, -19, -77, 33, -98, 77, 10, 1, -72, -18, -113, 33, -114, 69, Ascii.DC2, 70, -68, -12, -32, 119, -124, 67, Ascii.DC4, Ascii.SI, -89}, new byte[]{-19, 36, 126, 104, -41, Byte.MIN_VALUE, -61, 78}));
                Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Intrinsics.checkNotNull(consume, StringFog.decrypt(new byte[]{-104, -45, -65, 66, Ascii.VT, -66, 124, -43, -104, -55, -89, Ascii.SO, 73, -72, Base64.padSymbol, -40, -105, -43, -89, Ascii.SO, 95, -78, Base64.padSymbol, -43, -103, -56, -2, SignedBytes.MAX_POWER_OF_TWO, 94, -79, 113, -101, -126, -33, -93, 75, Ascii.VT, -66, 114, -42, -40, -42, -65, 71, 69, -74, 114, -35, -103, -44, -89, 91, 69, -72, 51, -40, -105, -43, -69, 0, 92, -76, 115, -56, -122, -49, -67, 0, 120, -78, 113, -34, -121}, new byte[]{-10, -90, -45, 46, 43, -35, Ascii.GS, -69}));
                Soleq soleq = (Soleq) consume;
                Composer composer2 = startRestartGroup;
                State state = collectAsState;
                ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.bg, startRestartGroup, 0), (String) null, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), (Alignment) null, ContentScale.Companion.getFillBounds(), 0.0f, (ColorFilter) null, composer2, 25008, (int) LocationRequestCompat.QUALITY_LOW_POWER);
                startRestartGroup = composer2;
                Boolean valueOf = Boolean.valueOf(PreamScreen$lambda$0(state));
                startRestartGroup.startReplaceGroup(78345096);
                State state2 = state;
                boolean changed = startRestartGroup.changed((Object) state2) | startRestartGroup.changedInstance(soleq) | ((i2 & 14) == 4);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new PreamScreenKt$PreamScreen$1$1(state2, soleq, function02, (Continuation<? super PreamScreenKt$PreamScreen$1$1>) null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect((Object) valueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue, startRestartGroup, 0);
                startRestartGroup.startReplaceGroup(78355348);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new PreamScreenKt$$ExternalSyntheticLambda0();
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                BackHandlerKt.BackHandler(false, (Function0) rememberedValue2, startRestartGroup, 48, 1);
                if (PreamScreen$lambda$0(state2)) {
                    startRestartGroup.startReplaceGroup(-1865930953);
                    PreamAnimKt.PreamAnim(startRestartGroup, 0);
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(-1865897008);
                    startRestartGroup.startReplaceGroup(78357968);
                    boolean changedInstance = startRestartGroup.changedInstance(preamViewModel);
                    Object rememberedValue3 = startRestartGroup.rememberedValue();
                    if (changedInstance || rememberedValue3 == Composer.Companion.getEmpty()) {
                        rememberedValue3 = new PreamScreenKt$$ExternalSyntheticLambda1(preamViewModel);
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                    }
                    startRestartGroup.endReplaceGroup();
                    LostNetworkScreenKt.LostNetworkScreen((Function0) rememberedValue3, startRestartGroup, 0);
                    startRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                throw new IllegalStateException(StringFog.decrypt(new byte[]{113, -3, Byte.MIN_VALUE, -26, 56, -83, 109, Ascii.SUB, 80, -10, -59, -36, 2, -68, 117, 37, 90, -35, -41, -34, 52, -70, 58, 32, 94, -31, Byte.MIN_VALUE, -64, 35, -89, 108, 62, 91, -9, -60, -112, 39, -95, 123, 119, 115, -3, -61, -47, Base64.padSymbol, -98, 115, 50, 72, -33, -49, -44, 52, -92, 73, 35, 80, -32, -59, -1, 38, -90, Byte.MAX_VALUE, 37}, new byte[]{Utf8.REPLACEMENT_BYTE, -110, -96, -80, 81, -56, Ascii.SUB, 87}).toString());
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new PreamScreenKt$$ExternalSyntheticLambda2(function02, i3));
        }
    }

    /* access modifiers changed from: private */
    public static final Unit PreamScreen$lambda$3$lambda$2() {
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit PreamScreen$lambda$5$lambda$4(PreamViewModel preamViewModel) {
        preamViewModel.getPream().setValue(true);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final boolean PreamScreen$lambda$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
