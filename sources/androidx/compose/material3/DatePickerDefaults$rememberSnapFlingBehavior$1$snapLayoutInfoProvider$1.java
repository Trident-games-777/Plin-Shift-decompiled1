package androidx.compose.material3;

import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0011\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0001¨\u0006\u0007"}, d2 = {"androidx/compose/material3/DatePickerDefaults$rememberSnapFlingBehavior$1$snapLayoutInfoProvider$1", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "calculateApproachOffset", "", "velocity", "decayOffset", "calculateSnapOffset", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
public final class DatePickerDefaults$rememberSnapFlingBehavior$1$snapLayoutInfoProvider$1 implements SnapLayoutInfoProvider {
    private final /* synthetic */ SnapLayoutInfoProvider $$delegate_0;

    public float calculateApproachOffset(float f, float f2) {
        return 0.0f;
    }

    public float calculateSnapOffset(float f) {
        return this.$$delegate_0.calculateSnapOffset(f);
    }

    DatePickerDefaults$rememberSnapFlingBehavior$1$snapLayoutInfoProvider$1(SnapLayoutInfoProvider snapLayoutInfoProvider) {
        this.$$delegate_0 = snapLayoutInfoProvider;
    }
}
