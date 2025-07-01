package com.plinkofortune.cash.winspin.teach;

import android.content.Intent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.google.common.base.Ascii;
import com.plinkofortune.cash.winspin.StringFog;
import com.plinkofortune.cash.winspin.ToolbarColumnKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import okio.Utf8;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"naDUtZcftJZ", "", "intent", "Landroid/content/Intent;", "TeachScreen", "back", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: TeachScreen.kt */
public final class TeachScreenKt {
    /* access modifiers changed from: private */
    public static final Unit TeachScreen$lambda$0(Function0 function0, int i, Composer composer, int i2) {
        TeachScreen(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void naDUtZcftJZ(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, StringFog.decrypt(new byte[]{125, 94, -1, 6, 106, 62}, new byte[]{Ascii.DC4, 48, -117, 99, 4, 74, Utf8.REPLACEMENT_BYTE, -10}));
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new TeachScreenKt$naDUtZcftJZ$1(intent, (Continuation<? super TeachScreenKt$naDUtZcftJZ$1>) null), 3, (Object) null);
    }

    public static final void TeachScreen(Function0<Unit> function0, Composer composer, int i) {
        int i2;
        int i3 = 4;
        Intrinsics.checkNotNullParameter(function0, StringFog.decrypt(new byte[]{-95, -92, -30, -85}, new byte[]{-61, -59, -127, -64, Ascii.US, -55, -95, -3}));
        Composer startRestartGroup = composer.startRestartGroup(95784519);
        if ((i & 6) == 0) {
            if (!startRestartGroup.changedInstance(function0)) {
                i3 = 2;
            }
            i2 = i3 | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(95784519, i2, -1, StringFog.decrypt(new byte[]{67, 42, 38, 126, -10, -66, -54, -105, 75, 42, 45, Utf8.REPLACEMENT_BYTE, -12, -90, -42, -105, 69, 107, 40, 49, -11, -70, -115, -114, 73, 43, 56, 32, -17, -68, -115, -115, 69, 36, 40, 56, -88, -122, -58, -104, 67, 45, Ascii.CAN, 51, -12, -73, -58, -105, 0, 109, Ascii.US, 53, -25, -79, -53, -86, 67, 55, 46, 53, -24, -4, -56, -115, Ascii.SUB, 114, 125, 121}, new byte[]{32, 69, 75, 80, -122, -46, -93, -7}));
            }
            ToolbarColumnKt.ToolbarColumn(function0, ComposableSingletons$TeachScreenKt.INSTANCE.m7817getLambda1$app_release(), startRestartGroup, (i2 & 14) | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TeachScreenKt$$ExternalSyntheticLambda0(function0, i));
        }
    }
}
