package androidx.compose.material3;

import androidx.collection.IntList;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "screen", "Landroidx/collection/IntList;", "invoke", "(Landroidx/collection/IntList;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$ClockFace$1 extends Lambda implements Function3<IntList, Composer, Integer, Unit> {
    final /* synthetic */ boolean $autoSwitchToMinute;
    final /* synthetic */ TimePickerColors $colors;
    final /* synthetic */ AnalogTimePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$ClockFace$1(TimePickerColors timePickerColors, AnalogTimePickerState analogTimePickerState, boolean z) {
        super(3);
        this.$colors = timePickerColors;
        this.$state = analogTimePickerState;
        this.$autoSwitchToMinute = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((IntList) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(final IntList intList, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C1525@60456L1828,1522@60292L1992:TimePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1022006568, i, -1, "androidx.compose.material3.ClockFace.<anonymous> (TimePicker.kt:1522)");
        }
        Modifier semantics$default = SemanticsModifierKt.semantics$default(SizeKt.m845size3ABfNKs(Modifier.Companion, TimePickerTokens.INSTANCE.m3561getClockDialContainerSizeD9Ej5fM()), false, AnonymousClass1.INSTANCE, 1, (Object) null);
        float access$getOuterCircleSizeRadius$p = TimePickerKt.OuterCircleSizeRadius;
        final TimePickerColors timePickerColors = this.$colors;
        final AnalogTimePickerState analogTimePickerState = this.$state;
        final boolean z = this.$autoSwitchToMinute;
        TimePickerKt.m2719CircularLayoutuFdPcIQ(semantics$default, access$getOuterCircleSizeRadius$p, ComposableLambdaKt.rememberComposableLambda(-320307952, true, new Function2<Composer, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                ComposerKt.sourceInformation(composer, "C1528@60589L1685,1526@60470L1804:TimePicker.kt#uh7d8r");
                if ((i & 3) != 2 || !composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-320307952, i, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous> (TimePicker.kt:1526)");
                    }
                    ProvidedValue<Color> provides = ContentColorKt.getLocalContentColor().provides(Color.m4229boximpl(timePickerColors.m2697clockDialContentColorvNxB06k$material3_release(false)));
                    final IntList intList = intList;
                    final AnalogTimePickerState analogTimePickerState = analogTimePickerState;
                    final boolean z = z;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) provides, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(1992872400, true, new Function2<Composer, Integer, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer, int i) {
                            int i2;
                            ComposerKt.sourceInformation(composer, "C1551@61690L552,1545@61343L899:TimePicker.kt#uh7d8r");
                            if ((i & 3) != 2 || !composer.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1992872400, i, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1529)");
                                }
                                composer.startReplaceGroup(1547046870);
                                ComposerKt.sourceInformation(composer, "*1537@61008L36,1536@60943L271");
                                int size = intList.getSize();
                                AnalogTimePickerState analogTimePickerState = analogTimePickerState;
                                IntList intList = intList;
                                boolean z = z;
                                for (int i3 = 0; i3 < size; i3++) {
                                    if (!analogTimePickerState.is24hour() || TimePickerSelectionMode.m2750equalsimpl0(analogTimePickerState.m1708getSelectionyecRtBI(), TimePickerSelectionMode.Companion.m2755getMinuteyecRtBI())) {
                                        i2 = intList.get(i3);
                                    } else {
                                        i2 = intList.get(i3) % 12;
                                    }
                                    Modifier modifier = Modifier.Companion;
                                    ComposerKt.sourceInformationMarkerStart(composer, 707420712, "CC(remember):TimePicker.kt#9igjgp");
                                    boolean changed = composer.changed(i3);
                                    Object rememberedValue = composer.rememberedValue();
                                    if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                                        rememberedValue = new TimePickerKt$ClockFace$1$2$1$1$1$1(i3);
                                        composer.updateRememberedValue(rememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer);
                                    boolean z2 = z;
                                    TimePickerKt.ClockText(SemanticsModifierKt.semantics$default(modifier, false, (Function1) rememberedValue, 1, (Object) null), analogTimePickerState, i2, z2, composer, 0);
                                    z = z2;
                                }
                                composer.endReplaceGroup();
                                if (TimePickerSelectionMode.m2750equalsimpl0(analogTimePickerState.m1708getSelectionyecRtBI(), TimePickerSelectionMode.Companion.m2754getHouryecRtBI()) && analogTimePickerState.is24hour()) {
                                    Modifier r0 = BackgroundKt.m247backgroundbw27NRU(SizeKt.m845size3ABfNKs(LayoutIdKt.layoutId(Modifier.Companion, LayoutId.InnerCircle), TimePickerTokens.INSTANCE.m3561getClockDialContainerSizeD9Ej5fM()), Color.Companion.m4274getTransparent0d7_KjU(), RoundedCornerShapeKt.getCircleShape());
                                    float access$getInnerCircleRadius$p = TimePickerKt.InnerCircleRadius;
                                    final AnalogTimePickerState analogTimePickerState2 = analogTimePickerState;
                                    final boolean z3 = z;
                                    TimePickerKt.m2719CircularLayoutuFdPcIQ(r0, access$getInnerCircleRadius$p, ComposableLambdaKt.rememberComposableLambda(-205464413, true, new Function2<Composer, Integer, Unit>() {
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer, int i) {
                                            ComposerKt.sourceInformation(composer, "C*1556@61951L41,1554@61842L352:TimePicker.kt#uh7d8r");
                                            if ((i & 3) != 2 || !composer.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-205464413, i, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1552)");
                                                }
                                                int size = TimePickerKt.ExtraHours.getSize();
                                                AnalogTimePickerState analogTimePickerState = analogTimePickerState2;
                                                boolean z = z3;
                                                for (int i2 = 0; i2 < size; i2++) {
                                                    int i3 = TimePickerKt.ExtraHours.get(i2);
                                                    Modifier modifier = Modifier.Companion;
                                                    ComposerKt.sourceInformationMarkerStart(composer, 1677472780, "CC(remember):TimePicker.kt#9igjgp");
                                                    boolean changed = composer.changed(i2);
                                                    Object rememberedValue = composer.rememberedValue();
                                                    if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                                                        rememberedValue = new TimePickerKt$ClockFace$1$2$1$2$1$1$1(i2);
                                                        composer.updateRememberedValue(rememberedValue);
                                                    }
                                                    ComposerKt.sourceInformationMarkerEnd(composer);
                                                    TimePickerKt.ClockText(SemanticsModifierKt.semantics$default(modifier, false, (Function1) rememberedValue, 1, (Object) null), analogTimePickerState, i3, z, composer, 0);
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer.skipToGroupEnd();
                                        }
                                    }, composer, 54), composer, 432, 0);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer.skipToGroupEnd();
                        }
                    }, composer, 54), composer, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        }, composer, 54), composer, 432, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
