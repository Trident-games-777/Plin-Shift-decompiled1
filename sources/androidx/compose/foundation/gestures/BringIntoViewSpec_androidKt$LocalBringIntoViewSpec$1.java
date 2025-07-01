package androidx.compose.foundation.gestures;

import android.content.Context;
import androidx.compose.runtime.CompositionLocalAccessorScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "Landroidx/compose/runtime/CompositionLocalAccessorScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BringIntoViewSpec.android.kt */
final class BringIntoViewSpec_androidKt$LocalBringIntoViewSpec$1 extends Lambda implements Function1<CompositionLocalAccessorScope, BringIntoViewSpec> {
    public static final BringIntoViewSpec_androidKt$LocalBringIntoViewSpec$1 INSTANCE = new BringIntoViewSpec_androidKt$LocalBringIntoViewSpec$1();

    BringIntoViewSpec_androidKt$LocalBringIntoViewSpec$1() {
        super(1);
    }

    public final BringIntoViewSpec invoke(CompositionLocalAccessorScope compositionLocalAccessorScope) {
        if (!((Context) compositionLocalAccessorScope.getCurrentValue(AndroidCompositionLocals_androidKt.getLocalContext())).getPackageManager().hasSystemFeature("android.software.leanback")) {
            return BringIntoViewSpec.Companion.getDefaultBringIntoViewSpec$foundation_release();
        }
        return BringIntoViewSpec_androidKt.getPivotBringIntoViewSpec();
    }
}
