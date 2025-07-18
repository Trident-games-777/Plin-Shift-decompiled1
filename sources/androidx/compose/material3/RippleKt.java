package androidx.compose.material3;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a.\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a0\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0010\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a0\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0010\u001a\u00020\u0017H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"$\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048GX\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048GX\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\t\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"DefaultBoundedRipple", "Landroidx/compose/material3/RippleNodeFactory;", "DefaultUnboundedRipple", "LocalRippleConfiguration", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/RippleConfiguration;", "getLocalRippleConfiguration$annotations", "()V", "getLocalRippleConfiguration", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalUseFallbackRippleImplementation", "", "getLocalUseFallbackRippleImplementation$annotations", "getLocalUseFallbackRippleImplementation", "ripple", "Landroidx/compose/foundation/IndicationNodeFactory;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "bounded", "radius", "Landroidx/compose/ui/unit/Dp;", "ripple-wH6b6FI", "(Landroidx/compose/ui/graphics/ColorProducer;ZF)Landroidx/compose/foundation/IndicationNodeFactory;", "Landroidx/compose/ui/graphics/Color;", "ripple-H2RKhps", "(ZFJ)Landroidx/compose/foundation/IndicationNodeFactory;", "rippleOrFallbackImplementation", "Landroidx/compose/foundation/Indication;", "rippleOrFallbackImplementation-9IZ8Weo", "(ZFJLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/Indication;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Ripple.kt */
public final class RippleKt {
    private static final RippleNodeFactory DefaultBoundedRipple = new RippleNodeFactory(true, Dp.Companion.m7131getUnspecifiedD9Ej5fM(), Color.Companion.m4275getUnspecified0d7_KjU(), (DefaultConstructorMarker) null);
    private static final RippleNodeFactory DefaultUnboundedRipple = new RippleNodeFactory(false, Dp.Companion.m7131getUnspecifiedD9Ej5fM(), Color.Companion.m4275getUnspecified0d7_KjU(), (DefaultConstructorMarker) null);
    private static final ProvidableCompositionLocal<RippleConfiguration> LocalRippleConfiguration = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, RippleKt$LocalRippleConfiguration$1.INSTANCE, 1, (Object) null);
    private static final ProvidableCompositionLocal<Boolean> LocalUseFallbackRippleImplementation = CompositionLocalKt.staticCompositionLocalOf(RippleKt$LocalUseFallbackRippleImplementation$1.INSTANCE);

    public static /* synthetic */ void getLocalRippleConfiguration$annotations() {
    }

    public static /* synthetic */ void getLocalUseFallbackRippleImplementation$annotations() {
    }

    /* renamed from: ripple-H2RKhps$default  reason: not valid java name */
    public static /* synthetic */ IndicationNodeFactory m2386rippleH2RKhps$default(boolean z, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            f = Dp.Companion.m7131getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            j = Color.Companion.m4275getUnspecified0d7_KjU();
        }
        return m2385rippleH2RKhps(z, f, j);
    }

    /* renamed from: ripple-H2RKhps  reason: not valid java name */
    public static final IndicationNodeFactory m2385rippleH2RKhps(boolean z, float f, long j) {
        if (!Dp.m7116equalsimpl0(f, Dp.Companion.m7131getUnspecifiedD9Ej5fM()) || !Color.m4240equalsimpl0(j, Color.Companion.m4275getUnspecified0d7_KjU())) {
            return new RippleNodeFactory(z, f, j, (DefaultConstructorMarker) null);
        }
        return z ? DefaultBoundedRipple : DefaultUnboundedRipple;
    }

    /* renamed from: ripple-wH6b6FI$default  reason: not valid java name */
    public static /* synthetic */ IndicationNodeFactory m2388ripplewH6b6FI$default(ColorProducer colorProducer, boolean z, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            f = Dp.Companion.m7131getUnspecifiedD9Ej5fM();
        }
        return m2387ripplewH6b6FI(colorProducer, z, f);
    }

    /* renamed from: ripple-wH6b6FI  reason: not valid java name */
    public static final IndicationNodeFactory m2387ripplewH6b6FI(ColorProducer colorProducer, boolean z, float f) {
        return new RippleNodeFactory(z, f, colorProducer, (DefaultConstructorMarker) null);
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalUseFallbackRippleImplementation() {
        return LocalUseFallbackRippleImplementation;
    }

    public static final ProvidableCompositionLocal<RippleConfiguration> getLocalRippleConfiguration() {
        return LocalRippleConfiguration;
    }

    /* renamed from: rippleOrFallbackImplementation-9IZ8Weo  reason: not valid java name */
    public static final Indication m2389rippleOrFallbackImplementation9IZ8Weo(boolean z, float f, long j, Composer composer, int i, int i2) {
        Indication indication;
        Composer composer2;
        ComposerKt.sourceInformationMarkerStart(composer, -1315814667, "C(rippleOrFallbackImplementation)P(!1,2:c#ui.unit.Dp,1:c#ui.graphics.Color):Ripple.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i2 & 2) != 0) {
            f = Dp.Companion.m7131getUnspecifiedD9Ej5fM();
        }
        float f2 = f;
        if ((i2 & 4) != 0) {
            j = Color.Companion.m4275getUnspecified0d7_KjU();
        }
        long j2 = j;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1315814667, i, -1, "androidx.compose.material3.rippleOrFallbackImplementation (Ripple.kt:230)");
        }
        composer.startReplaceGroup(-1280632857);
        ComposerKt.sourceInformation(composer, "231@10696L7,232@10748L38");
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(LocalUseFallbackRippleImplementation);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (((Boolean) consume).booleanValue()) {
            composer2 = composer;
            indication = androidx.compose.material.ripple.RippleKt.m1691rememberRipple9IZ8Weo(z2, f2, j2, composer2, i & 1022, 0);
        } else {
            composer2 = composer;
            indication = m2385rippleH2RKhps(z2, f2, j2);
        }
        composer2.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return indication;
    }
}
