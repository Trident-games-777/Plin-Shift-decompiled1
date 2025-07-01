package coil3.compose.internal;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.ScaleFactorKt;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.TimeSource;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u00002\u00020\u0001B;\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\f\u0010,\u001a\u00020-*\u00020.H\u0014J\u0010\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\u0018H\u0014J\u0012\u00101\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010 H\u0014J\u000f\u00102\u001a\u00020)H\u0002¢\u0006\u0004\b3\u0010+J\u001e\u00104\u001a\u00020-*\u00020.2\b\u00105\u001a\u0004\u0018\u00010\u00012\u0006\u00100\u001a\u00020\u0018H\u0002J\u001f\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020)2\u0006\u00108\u001a\u00020)H\u0002¢\u0006\u0004\b9\u0010:R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R+\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00078B@BX\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R+\u0010\u0019\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u00188B@BX\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR/\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\r\u001a\u0004\u0018\u00010 8B@BX\u0002¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020)8VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006;"}, d2 = {"Lcoil3/compose/internal/CrossfadePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "start", "end", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "durationMillis", "", "fadeStart", "", "preferExactIntrinsicSize", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/layout/ContentScale;IZZ)V", "<set-?>", "invalidateTick", "getInvalidateTick", "()I", "setInvalidateTick", "(I)V", "invalidateTick$delegate", "Landroidx/compose/runtime/MutableIntState;", "startTime", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "isDone", "", "maxAlpha", "getMaxAlpha", "()F", "setMaxAlpha", "(F)V", "maxAlpha$delegate", "Landroidx/compose/runtime/MutableFloatState;", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "colorFilter$delegate", "Landroidx/compose/runtime/MutableState;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "applyAlpha", "alpha", "applyColorFilter", "computeIntrinsicSize", "computeIntrinsicSize-NH-jbRc", "drawPainter", "painter", "computeDrawSize", "srcSize", "dstSize", "computeDrawSize-x8L_9b0", "(JJ)J", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: CrossfadePainter.kt */
public final class CrossfadePainter extends Painter {
    public static final int $stable = 0;
    private final MutableState colorFilter$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final ContentScale contentScale;
    private final int durationMillis;
    private final Painter end;
    private final boolean fadeStart;
    private final MutableIntState invalidateTick$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
    private boolean isDone;
    private final MutableFloatState maxAlpha$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);
    private final boolean preferExactIntrinsicSize;
    private Painter start;
    private TimeSource.Monotonic.ValueTimeMark startTime;

    public CrossfadePainter(Painter painter, Painter painter2, ContentScale contentScale2, int i, boolean z, boolean z2) {
        this.start = painter;
        this.end = painter2;
        this.contentScale = contentScale2;
        this.durationMillis = i;
        this.fadeStart = z;
        this.preferExactIntrinsicSize = z2;
    }

    private final int getInvalidateTick() {
        return this.invalidateTick$delegate.getIntValue();
    }

    private final void setInvalidateTick(int i) {
        this.invalidateTick$delegate.setIntValue(i);
    }

    private final float getMaxAlpha() {
        return this.maxAlpha$delegate.getFloatValue();
    }

    private final void setMaxAlpha(float f) {
        this.maxAlpha$delegate.setFloatValue(f);
    }

    private final ColorFilter getColorFilter() {
        return (ColorFilter) this.colorFilter$delegate.getValue();
    }

    private final void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter$delegate.setValue(colorFilter);
    }

    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public long m7492getIntrinsicSizeNHjbRc() {
        return m7491computeIntrinsicSizeNHjbRc();
    }

    /* access modifiers changed from: protected */
    public void onDraw(DrawScope drawScope) {
        long j;
        if (this.isDone) {
            drawPainter(drawScope, this.end, getMaxAlpha());
            return;
        }
        TimeSource.Monotonic.ValueTimeMark valueTimeMark = this.startTime;
        if (valueTimeMark != null) {
            j = valueTimeMark.m9321unboximpl();
        } else {
            j = TimeSource.Monotonic.INSTANCE.m9297markNowz9LOYto();
            this.startTime = TimeSource.Monotonic.ValueTimeMark.m9298boximpl(j);
        }
        float r0 = ((float) Duration.m9173getInWholeMillisecondsimpl(TimeSource.Monotonic.ValueTimeMark.m9302elapsedNowUwyO8pc(j))) / ((float) this.durationMillis);
        float coerceIn = RangesKt.coerceIn(r0, 0.0f, 1.0f) * getMaxAlpha();
        float maxAlpha = this.fadeStart ? getMaxAlpha() - coerceIn : getMaxAlpha();
        this.isDone = r0 >= 1.0f;
        drawPainter(drawScope, this.start, maxAlpha);
        drawPainter(drawScope, this.end, coerceIn);
        if (this.isDone) {
            this.start = null;
        } else {
            setInvalidateTick(getInvalidateTick() + 1);
        }
    }

    /* access modifiers changed from: protected */
    public boolean applyAlpha(float f) {
        setMaxAlpha(f);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean applyColorFilter(ColorFilter colorFilter) {
        setColorFilter(colorFilter);
        return true;
    }

    /* renamed from: computeIntrinsicSize-NH-jbRc  reason: not valid java name */
    private final long m7491computeIntrinsicSizeNHjbRc() {
        Painter painter = this.start;
        long r0 = painter != null ? painter.m5044getIntrinsicSizeNHjbRc() : Size.Companion.m4065getZeroNHjbRc();
        Painter painter2 = this.end;
        long r2 = painter2 != null ? painter2.m5044getIntrinsicSizeNHjbRc() : Size.Companion.m4065getZeroNHjbRc();
        boolean z = true;
        boolean z2 = r0 != InlineClassHelperKt.UnspecifiedPackedFloats;
        if (r2 == InlineClassHelperKt.UnspecifiedPackedFloats) {
            z = false;
        }
        if (z2 && z) {
            return SizeKt.Size(Math.max(Size.m4056getWidthimpl(r0), Size.m4056getWidthimpl(r2)), Math.max(Size.m4053getHeightimpl(r0), Size.m4053getHeightimpl(r2)));
        }
        if (this.preferExactIntrinsicSize) {
            if (z2) {
                return r0;
            }
            if (z) {
                return r2;
            }
        }
        return Size.Companion.m4064getUnspecifiedNHjbRc();
    }

    private final void drawPainter(DrawScope drawScope, Painter painter, float f) {
        if (painter != null && f > 0.0f) {
            long r0 = drawScope.m4865getSizeNHjbRc();
            long r6 = m7490computeDrawSizex8L_9b0(painter.m5044getIntrinsicSizeNHjbRc(), r0);
            if (r0 != InlineClassHelperKt.UnspecifiedPackedFloats && !Size.m4058isEmptyimpl(r0)) {
                DrawScope drawScope2 = drawScope;
                Painter painter2 = painter;
                float f2 = f;
                float f3 = (float) 2;
                float r11 = (Size.m4056getWidthimpl(r0) - Size.m4056getWidthimpl(r6)) / f3;
                float r13 = (Size.m4053getHeightimpl(r0) - Size.m4053getHeightimpl(r6)) / f3;
                drawScope2.getDrawContext().getTransform().inset(r11, r13, r11, r13);
                try {
                    painter2.m5043drawx_KDEd0(drawScope2, r6, f2, getColorFilter());
                    float f4 = -r11;
                    float f5 = -r13;
                    drawScope2.getDrawContext().getTransform().inset(f4, f5, f4, f5);
                } catch (Throwable th) {
                    Throwable th2 = th;
                    float f6 = -r11;
                    float f7 = -r13;
                    drawScope2.getDrawContext().getTransform().inset(f6, f7, f6, f7);
                    throw th2;
                }
            } else {
                Painter painter3 = painter;
                painter3.m5043drawx_KDEd0(drawScope, r6, f, getColorFilter());
            }
        }
    }

    /* renamed from: computeDrawSize-x8L_9b0  reason: not valid java name */
    private final long m7490computeDrawSizex8L_9b0(long j, long j2) {
        if (j != InlineClassHelperKt.UnspecifiedPackedFloats && !Size.m4058isEmptyimpl(j) && j2 != InlineClassHelperKt.UnspecifiedPackedFloats && !Size.m4058isEmptyimpl(j2)) {
            return ScaleFactorKt.m5931timesUQTWf7w(j, this.contentScale.m5764computeScaleFactorH7hwNQA(j, j2));
        }
        return j2;
    }
}
