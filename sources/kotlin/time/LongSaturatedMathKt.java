package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\t\u001a'\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a'\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u000e\u001a%\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\u0010\u0014\u001a%\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0002\u0010\u0014\u001a%\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\u0010\u0014\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0001H\b¨\u0006\u001d"}, d2 = {"checkInfiniteSumDefined", "", "value", "duration", "Lkotlin/time/Duration;", "durationInUnit", "checkInfiniteSumDefined-PjuGub4", "(JJJ)J", "infinityOfSign", "(J)J", "saturatingAdd", "unit", "Lkotlin/time/DurationUnit;", "saturatingAdd-NuflL3o", "(JLkotlin/time/DurationUnit;J)J", "saturatingAddInHalves", "saturatingAddInHalves-NuflL3o", "saturatingDiff", "valueNs", "origin", "(JJLkotlin/time/DurationUnit;)J", "saturatingFiniteDiff", "value1", "value2", "saturatingOriginsDiff", "origin1", "origin2", "isSaturated", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: longSaturatedMath.kt */
public final class LongSaturatedMathKt {
    public static final boolean isSaturated(long j) {
        return ((j - 1) | 1) == Long.MAX_VALUE;
    }

    /* renamed from: saturatingAdd-NuflL3o  reason: not valid java name */
    public static final long m9284saturatingAddNuflL3o(long j, DurationUnit durationUnit, long j2) {
        Intrinsics.checkNotNullParameter(durationUnit, "unit");
        long r5 = Duration.m9201toLongimpl(j2, durationUnit);
        if (((j - 1) | 1) == Long.MAX_VALUE) {
            return m9283checkInfiniteSumDefinedPjuGub4(j, j2, r5);
        }
        long j3 = j;
        long j4 = j2;
        if (((r5 - 1) | 1) == Long.MAX_VALUE) {
            return m9285saturatingAddInHalvesNuflL3o(j3, durationUnit, j4);
        }
        long j5 = j3 + r5;
        if (((j3 ^ j5) & (r5 ^ j5)) >= 0) {
            return j5;
        }
        if (j3 < 0) {
            return Long.MIN_VALUE;
        }
        return Long.MAX_VALUE;
    }

    /* renamed from: checkInfiniteSumDefined-PjuGub4  reason: not valid java name */
    private static final long m9283checkInfiniteSumDefinedPjuGub4(long j, long j2, long j3) {
        if (!Duration.m9187isInfiniteimpl(j2) || (j ^ j3) >= 0) {
            return j;
        }
        throw new IllegalArgumentException("Summing infinities of different signs");
    }

    /* renamed from: saturatingAddInHalves-NuflL3o  reason: not valid java name */
    private static final long m9285saturatingAddInHalvesNuflL3o(long j, DurationUnit durationUnit, long j2) {
        long r0 = Duration.m9158divUwyO8pc(j2, 2);
        long r2 = Duration.m9201toLongimpl(r0, durationUnit);
        if ((1 | (r2 - 1)) == Long.MAX_VALUE) {
            return r2;
        }
        return m9284saturatingAddNuflL3o(m9284saturatingAddNuflL3o(j, durationUnit, r0), durationUnit, Duration.m9190minusLRDsOJo(j2, r0));
    }

    private static final long infinityOfSign(long j) {
        return j < 0 ? Duration.Companion.m9257getNEG_INFINITEUwyO8pc$kotlin_stdlib() : Duration.Companion.m9256getINFINITEUwyO8pc();
    }

    public static final long saturatingDiff(long j, long j2, DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, "unit");
        if ((1 | (j2 - 1)) == Long.MAX_VALUE) {
            return Duration.m9208unaryMinusUwyO8pc(infinityOfSign(j2));
        }
        return saturatingFiniteDiff(j, j2, durationUnit);
    }

    public static final long saturatingOriginsDiff(long j, long j2, DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, "unit");
        if (((j2 - 1) | 1) == Long.MAX_VALUE) {
            if (j == j2) {
                return Duration.Companion.m9258getZEROUwyO8pc();
            }
            return Duration.m9208unaryMinusUwyO8pc(infinityOfSign(j2));
        } else if ((1 | (j - 1)) == Long.MAX_VALUE) {
            return infinityOfSign(j);
        } else {
            return saturatingFiniteDiff(j, j2, durationUnit);
        }
    }

    private static final long saturatingFiniteDiff(long j, long j2, DurationUnit durationUnit) {
        long j3 = j - j2;
        if (((j3 ^ j) & (~(j3 ^ j2))) >= 0) {
            return DurationKt.toDuration(j3, durationUnit);
        }
        if (durationUnit.compareTo(DurationUnit.MILLISECONDS) >= 0) {
            return Duration.m9208unaryMinusUwyO8pc(infinityOfSign(j3));
        }
        long convertDurationUnit = DurationUnitKt.convertDurationUnit(1, DurationUnit.MILLISECONDS, durationUnit);
        long j4 = (j % convertDurationUnit) - (j2 % convertDurationUnit);
        Duration.Companion companion = Duration.Companion;
        return Duration.m9191plusLRDsOJo(DurationKt.toDuration((j / convertDurationUnit) - (j2 / convertDurationUnit), DurationUnit.MILLISECONDS), DurationKt.toDuration(j4, durationUnit));
    }
}
