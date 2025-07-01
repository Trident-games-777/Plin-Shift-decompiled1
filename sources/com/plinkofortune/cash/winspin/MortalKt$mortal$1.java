package com.plinkofortune.cash.winspin;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.semantics.Role;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* compiled from: Mortal.kt */
final class MortalKt$mortal$1 implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ Function0<Unit> $click;

    MortalKt$mortal$1(Function0<Unit> function0) {
        this.$click = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    private static final boolean invoke$lambda$1(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(modifier, StringFog.decrypt(new byte[]{83, 114, 0, SignedBytes.MAX_POWER_OF_TWO, 108, -118, -10, 100, Ascii.SUB, 118, 7, 90, 122, -54}, new byte[]{119, 6, 104, 41, Ascii.US, -82, -107, Ascii.VT}));
        composer.startReplaceGroup(-841916268);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-841916268, i, -1, StringFog.decrypt(new byte[]{87, -24, 59, -125, -63, -45, -118, -54, 95, -24, 48, -62, -61, -53, -106, -54, 81, -87, 53, -52, -62, -41, -51, -45, 93, -23, 37, -35, -40, -47, -51, -55, 91, -11, 34, -52, -35, -111, -33, -59, 90, -24, 56, -44, -36, -48, -106, -41, 10, -89, 126, -32, -34, -51, -105, -59, 88, -87, Base64.padSymbol, -39, -117, -114, -43, -115}, new byte[]{52, -121, 86, -83, -79, -65, -29, -92}));
        }
        composer.startReplaceGroup(1031001468);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        MutableState mutableState = (MutableState) rememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(1031003201);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = InteractionSourceKt.MutableInteractionSource();
            composer.updateRememberedValue(rememberedValue2);
        }
        MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) rememberedValue2;
        composer.endReplaceGroup();
        composer.startReplaceGroup(1031005510);
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = new MortalKt$mortal$1$1$1(mutableInteractionSource, mutableState, (Continuation<? super MortalKt$mortal$1$1$1>) null);
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceGroup();
        EffectsKt.LaunchedEffect((Object) mutableInteractionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue3, composer, 6);
        float f = invoke$lambda$1(mutableState) ? 0.8f : 1.0f;
        Composer composer2 = composer;
        Composer composer3 = composer2;
        Modifier r13 = ClickableKt.m279clickableO2vRcR0$default(ScaleKt.scale(modifier, invoke$lambda$5(AnimateAsStateKt.animateFloatAsState(f, (AnimationSpec<Float>) null, 0.0f, (String) null, (Function1<? super Float, Unit>) null, composer2, 0, 30))), mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, this.$click, 28, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer3.endReplaceGroup();
        return r13;
    }

    private static final float invoke$lambda$5(State<Float> state) {
        return state.getValue().floatValue();
    }
}
