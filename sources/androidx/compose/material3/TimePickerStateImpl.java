package androidx.compose.material3;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000 %2\u00020\u0001:\u0001%B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R$\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038V@VX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R+\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00068V@VX\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R$\u0010\u001b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038V@VX\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u000b\"\u0004\b\u001d\u0010\rR\u0011\u0010\u001e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0011R1\u0010!\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020 8V@VX\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b$\u0010\u001a\u001a\u0004\b\"\u0010\u000b\"\u0004\b#\u0010\r\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006&"}, d2 = {"Landroidx/compose/material3/TimePickerStateImpl;", "Landroidx/compose/material3/TimePickerState;", "initialHour", "", "initialMinute", "is24Hour", "", "(IIZ)V", "value", "hour", "getHour", "()I", "setHour", "(I)V", "hourState", "Landroidx/compose/runtime/MutableIntState;", "getHourState", "()Landroidx/compose/runtime/MutableIntState;", "is24hour", "()Z", "set24hour", "(Z)V", "<set-?>", "isAfternoon", "setAfternoon", "isAfternoon$delegate", "Landroidx/compose/runtime/MutableState;", "minute", "getMinute", "setMinute", "minuteState", "getMinuteState", "Landroidx/compose/material3/TimePickerSelectionMode;", "selection", "getSelection-yecRtBI", "setSelection-6_8s6DQ", "selection$delegate", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerStateImpl implements TimePickerState {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final MutableIntState hourState;
    private boolean is24hour;
    private final MutableState isAfternoon$delegate;
    private final MutableIntState minuteState;
    private final MutableState selection$delegate;

    public TimePickerStateImpl(int i, int i2, boolean z) {
        if (i < 0 || i >= 24) {
            throw new IllegalArgumentException("initialHour should in [0..23] range".toString());
        } else if (i2 < 0 || i2 >= 60) {
            throw new IllegalArgumentException("initialMinute should be in [0..59] range".toString());
        } else {
            this.is24hour = z;
            this.selection$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TimePickerSelectionMode.m2747boximpl(TimePickerSelectionMode.Companion.m2754getHouryecRtBI()), (SnapshotMutationPolicy) null, 2, (Object) null);
            this.isAfternoon$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(i >= 12), (SnapshotMutationPolicy) null, 2, (Object) null);
            this.hourState = SnapshotIntStateKt.mutableIntStateOf(i % 12);
            this.minuteState = SnapshotIntStateKt.mutableIntStateOf(i2);
        }
    }

    public boolean is24hour() {
        return this.is24hour;
    }

    public void set24hour(boolean z) {
        this.is24hour = z;
    }

    /* renamed from: getSelection-yecRtBI  reason: not valid java name */
    public int m2758getSelectionyecRtBI() {
        return ((TimePickerSelectionMode) this.selection$delegate.getValue()).m2753unboximpl();
    }

    /* renamed from: setSelection-6_8s6DQ  reason: not valid java name */
    public void m2759setSelection6_8s6DQ(int i) {
        this.selection$delegate.setValue(TimePickerSelectionMode.m2747boximpl(i));
    }

    public boolean isAfternoon() {
        return ((Boolean) this.isAfternoon$delegate.getValue()).booleanValue();
    }

    public void setAfternoon(boolean z) {
        this.isAfternoon$delegate.setValue(Boolean.valueOf(z));
    }

    public final MutableIntState getHourState() {
        return this.hourState;
    }

    public final MutableIntState getMinuteState() {
        return this.minuteState;
    }

    public int getMinute() {
        return this.minuteState.getIntValue();
    }

    public void setMinute(int i) {
        this.minuteState.setIntValue(i);
    }

    public int getHour() {
        return this.hourState.getIntValue() + (isAfternoon() ? 12 : 0);
    }

    public void setHour(int i) {
        setAfternoon(i >= 12);
        this.hourState.setIntValue(i % 12);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0004¨\u0006\u0006"}, d2 = {"Landroidx/compose/material3/TimePickerStateImpl$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/TimePickerStateImpl;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TimePicker.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<TimePickerStateImpl, ?> Saver() {
            return SaverKt.Saver(TimePickerStateImpl$Companion$Saver$1.INSTANCE, TimePickerStateImpl$Companion$Saver$2.INSTANCE);
        }
    }
}
