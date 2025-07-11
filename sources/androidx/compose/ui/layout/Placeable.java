package androidx.compose.ui.layout;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.MotionReferencePlacementDelegate;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001:\u0001,B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J=\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"2\u0019\u0010#\u001a\u0015\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001e\u0018\u00010$¢\u0006\u0002\b&H$ø\u0001\u0000¢\u0006\u0004\b'\u0010(J*\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"2\u0006\u0010)\u001a\u00020*H\u0014ø\u0001\u0000¢\u0006\u0004\b'\u0010+R&\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR,\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@DX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\fR,\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0017@DX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\u0014R\u001e\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006-"}, d2 = {"Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/layout/Measured;", "()V", "<set-?>", "Landroidx/compose/ui/unit/IntOffset;", "apparentToRealOffset", "getApparentToRealOffset-nOcc-ac", "()J", "J", "", "height", "getHeight", "()I", "measuredHeight", "getMeasuredHeight", "value", "Landroidx/compose/ui/unit/IntSize;", "measuredSize", "getMeasuredSize-YbymL2g", "setMeasuredSize-ozmzZPI", "(J)V", "measuredWidth", "getMeasuredWidth", "Landroidx/compose/ui/unit/Constraints;", "measurementConstraints", "getMeasurementConstraints-msEJaDk", "setMeasurementConstraints-BRTryo0", "width", "getWidth", "onMeasuredSizeChanged", "", "placeAt", "position", "zIndex", "", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "PlacementScope", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Placeable.kt */
public abstract class Placeable implements Measured {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public long apparentToRealOffset = IntOffset.Companion.m7251getZeronOccac();
    private int height;
    private long measuredSize = IntSizeKt.IntSize(0, 0);
    private long measurementConstraints = PlaceableKt.DefaultConstraints;
    private int width;

    /* access modifiers changed from: protected */
    /* renamed from: placeAt-f8xVGno  reason: not valid java name */
    public abstract void m5887placeAtf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1);

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public int getMeasuredWidth() {
        return IntSize.m7283getWidthimpl(this.measuredSize);
    }

    public int getMeasuredHeight() {
        return IntSize.m7282getHeightimpl(this.measuredSize);
    }

    /* access modifiers changed from: protected */
    /* renamed from: getMeasuredSize-YbymL2g  reason: not valid java name */
    public final long m5884getMeasuredSizeYbymL2g() {
        return this.measuredSize;
    }

    /* access modifiers changed from: protected */
    /* renamed from: setMeasuredSize-ozmzZPI  reason: not valid java name */
    public final void m5888setMeasuredSizeozmzZPI(long j) {
        if (!IntSize.m7281equalsimpl0(this.measuredSize, j)) {
            this.measuredSize = j;
            onMeasuredSizeChanged();
        }
    }

    private final void onMeasuredSizeChanged() {
        this.width = RangesKt.coerceIn(IntSize.m7283getWidthimpl(this.measuredSize), Constraints.m7054getMinWidthimpl(this.measurementConstraints), Constraints.m7052getMaxWidthimpl(this.measurementConstraints));
        this.height = RangesKt.coerceIn(IntSize.m7282getHeightimpl(this.measuredSize), Constraints.m7053getMinHeightimpl(this.measurementConstraints), Constraints.m7051getMaxHeightimpl(this.measurementConstraints));
        this.apparentToRealOffset = IntOffsetKt.IntOffset((this.width - IntSize.m7283getWidthimpl(this.measuredSize)) / 2, (this.height - IntSize.m7282getHeightimpl(this.measuredSize)) / 2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: placeAt-f8xVGno  reason: not valid java name */
    public void m5886placeAtf8xVGno(long j, float f, GraphicsLayer graphicsLayer) {
        m5887placeAtf8xVGno(j, f, (Function1<? super GraphicsLayerScope, Unit>) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: getMeasurementConstraints-msEJaDk  reason: not valid java name */
    public final long m5885getMeasurementConstraintsmsEJaDk() {
        return this.measurementConstraints;
    }

    /* access modifiers changed from: protected */
    /* renamed from: setMeasurementConstraints-BRTryo0  reason: not valid java name */
    public final void m5889setMeasurementConstraintsBRTryo0(long j) {
        if (!Constraints.m7045equalsimpl0(this.measurementConstraints, j)) {
            this.measurementConstraints = j;
            onMeasuredSizeChanged();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: getApparentToRealOffset-nOcc-ac  reason: not valid java name */
    public final long m5883getApparentToRealOffsetnOccac() {
        return this.apparentToRealOffset;
    }

    @PlacementScopeMarker
    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0011\u001a\u00020\u00122\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\u0002\b\u0015J\u0014\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\f\u0010\u001a\u001a\u00020\u0012*\u00020\u001bH\u0002J&\u0010\u001c\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0004\b \u0010!J$\u0010\u001c\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u0017JD\u0010$\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00172\u001b\b\b\u0010%\u001a\u0015\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0014¢\u0006\u0002\b\u0015H\bø\u0001\u0000¢\u0006\u0004\b'\u0010(J/\u0010$\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*H\bø\u0001\u0000¢\u0006\u0004\b'\u0010+JD\u0010,\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00172\u001b\b\b\u0010%\u001a\u0015\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0014¢\u0006\u0002\b\u0015H\bø\u0001\u0000¢\u0006\u0004\b-\u0010(J/\u0010,\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*H\bø\u0001\u0000¢\u0006\u0004\b-\u0010+J&\u0010.\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0004\b/\u0010!J$\u0010.\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u0017J.\u00100\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010\u001f\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0004\b1\u00102JA\u00100\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00172\u0019\b\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\u0002\b\u0015ø\u0001\u0000¢\u0006\u0004\b1\u0010(J,\u00100\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010\u001f\u001a\u00020\u0017J?\u00100\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u00172\u0019\b\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\u0002\b\u0015J.\u00103\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010\u001f\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0004\b4\u00102JA\u00103\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00172\u0019\b\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\u0002\b\u0015ø\u0001\u0000¢\u0006\u0004\b4\u0010(J,\u00103\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010\u001f\u001a\u00020\u0017J?\u00103\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u00172\u0019\b\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\u0002\b\u0015R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\nX¤\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\u000eX¤\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00065"}, d2 = {"Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "()V", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "motionFrameOfReferencePlacement", "", "parentLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getParentLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "parentWidth", "", "getParentWidth", "()I", "withMotionFrameOfReferencePlacement", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "current", "", "Landroidx/compose/ui/layout/Ruler;", "defaultValue", "handleMotionFrameOfReferencePlacement", "Landroidx/compose/ui/layout/Placeable;", "place", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "place-70tqf50", "(Landroidx/compose/ui/layout/Placeable;JF)V", "x", "y", "placeApparentToRealOffset", "layerBlock", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "placeApparentToRealOffset-aW-9-wM$ui_release", "(Landroidx/compose/ui/layout/Placeable;JFLkotlin/jvm/functions/Function1;)V", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(Landroidx/compose/ui/layout/Placeable;JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeAutoMirrored", "placeAutoMirrored-aW-9-wM$ui_release", "placeRelative", "placeRelative-70tqf50", "placeRelativeWithLayer", "placeRelativeWithLayer-aW-9-wM", "(Landroidx/compose/ui/layout/Placeable;JLandroidx/compose/ui/graphics/layer/GraphicsLayer;F)V", "placeWithLayer", "placeWithLayer-aW-9-wM", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Placeable.kt */
    public static abstract class PlacementScope {
        public static final int $stable = 8;
        private boolean motionFrameOfReferencePlacement;

        public float current(Ruler ruler, float f) {
            return f;
        }

        public LayoutCoordinates getCoordinates() {
            return null;
        }

        /* access modifiers changed from: protected */
        public abstract LayoutDirection getParentLayoutDirection();

        /* access modifiers changed from: protected */
        public abstract int getParentWidth();

        /* renamed from: placeRelative-70tqf50$default  reason: not valid java name */
        public static /* synthetic */ void m5891placeRelative70tqf50$default(PlacementScope placementScope, Placeable placeable, long j, float f, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    f = 0.0f;
                }
                placementScope.m5901placeRelative70tqf50(placeable, j, f);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative-70tqf50");
        }

        public static /* synthetic */ void placeRelative$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    f = 0.0f;
                }
                placementScope.placeRelative(placeable, i, i2, f);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative");
        }

        public final void placeRelative(Placeable placeable, int i, int i2, float f) {
            long IntOffset = IntOffsetKt.IntOffset(i, i2);
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.m5887placeAtf8xVGno(IntOffset.m7245plusqkQi6aY(IntOffset, placeable.apparentToRealOffset), f, (Function1<? super GraphicsLayerScope, Unit>) null);
                return;
            }
            long IntOffset2 = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m7241getXimpl(IntOffset), IntOffset.m7242getYimpl(IntOffset));
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.m5887placeAtf8xVGno(IntOffset.m7245plusqkQi6aY(IntOffset2, placeable.apparentToRealOffset), f, (Function1<? super GraphicsLayerScope, Unit>) null);
        }

        public static /* synthetic */ void place$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    f = 0.0f;
                }
                placementScope.place(placeable, i, i2, f);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place");
        }

        public final void place(Placeable placeable, int i, int i2, float f) {
            long IntOffset = IntOffsetKt.IntOffset(i, i2);
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.m5887placeAtf8xVGno(IntOffset.m7245plusqkQi6aY(IntOffset, placeable.apparentToRealOffset), f, (Function1<? super GraphicsLayerScope, Unit>) null);
        }

        /* renamed from: place-70tqf50$default  reason: not valid java name */
        public static /* synthetic */ void m5890place70tqf50$default(PlacementScope placementScope, Placeable placeable, long j, float f, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    f = 0.0f;
                }
                placementScope.m5896place70tqf50(placeable, j, f);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place-70tqf50");
        }

        /* renamed from: placeRelativeWithLayer-aW-9-wM$default  reason: not valid java name */
        public static /* synthetic */ void m5892placeRelativeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j, float f, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    f = 0.0f;
                }
                float f2 = f;
                if ((i & 4) != 0) {
                    function1 = PlaceableKt.DefaultLayerBlock;
                }
                placementScope.m5902placeRelativeWithLayeraW9wM(placeable, j, f2, (Function1<? super GraphicsLayerScope, Unit>) function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
        }

        public static /* synthetic */ void placeRelativeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, Function1 function1, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    f = 0.0f;
                }
                float f2 = f;
                if ((i3 & 8) != 0) {
                    function1 = PlaceableKt.DefaultLayerBlock;
                }
                placementScope.placeRelativeWithLayer(placeable, i, i2, f2, (Function1<? super GraphicsLayerScope, Unit>) function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer");
        }

        public final void placeRelativeWithLayer(Placeable placeable, int i, int i2, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
            long IntOffset = IntOffsetKt.IntOffset(i, i2);
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.m5887placeAtf8xVGno(IntOffset.m7245plusqkQi6aY(IntOffset, placeable.apparentToRealOffset), f, function1);
                return;
            }
            long IntOffset2 = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m7241getXimpl(IntOffset), IntOffset.m7242getYimpl(IntOffset));
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.m5887placeAtf8xVGno(IntOffset.m7245plusqkQi6aY(IntOffset2, placeable.apparentToRealOffset), f, function1);
        }

        public static /* synthetic */ void placeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, Function1 function1, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    f = 0.0f;
                }
                float f2 = f;
                if ((i3 & 8) != 0) {
                    function1 = PlaceableKt.DefaultLayerBlock;
                }
                placementScope.placeWithLayer(placeable, i, i2, f2, (Function1<? super GraphicsLayerScope, Unit>) function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer");
        }

        public final void placeWithLayer(Placeable placeable, int i, int i2, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
            long IntOffset = IntOffsetKt.IntOffset(i, i2);
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.m5887placeAtf8xVGno(IntOffset.m7245plusqkQi6aY(IntOffset, placeable.apparentToRealOffset), f, function1);
        }

        /* renamed from: placeWithLayer-aW-9-wM$default  reason: not valid java name */
        public static /* synthetic */ void m5894placeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j, float f, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    f = 0.0f;
                }
                float f2 = f;
                if ((i & 4) != 0) {
                    function1 = PlaceableKt.DefaultLayerBlock;
                }
                placementScope.m5904placeWithLayeraW9wM(placeable, j, f2, (Function1<? super GraphicsLayerScope, Unit>) function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
        }

        public static /* synthetic */ void placeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i2, GraphicsLayer graphicsLayer, float f, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    f = 0.0f;
                }
                placementScope.placeWithLayer(placeable, i, i2, graphicsLayer, f);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer");
        }

        public final void placeWithLayer(Placeable placeable, int i, int i2, GraphicsLayer graphicsLayer, float f) {
            long IntOffset = IntOffsetKt.IntOffset(i, i2);
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.m5886placeAtf8xVGno(IntOffset.m7245plusqkQi6aY(IntOffset, placeable.apparentToRealOffset), f, graphicsLayer);
        }

        /* renamed from: placeWithLayer-aW-9-wM$default  reason: not valid java name */
        public static /* synthetic */ void m5895placeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j, GraphicsLayer graphicsLayer, float f, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    f = 0.0f;
                }
                placementScope.m5905placeWithLayeraW9wM(placeable, j, graphicsLayer, f);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
        }

        public static /* synthetic */ void placeRelativeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i2, GraphicsLayer graphicsLayer, float f, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    f = 0.0f;
                }
                placementScope.placeRelativeWithLayer(placeable, i, i2, graphicsLayer, f);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer");
        }

        public final void placeRelativeWithLayer(Placeable placeable, int i, int i2, GraphicsLayer graphicsLayer, float f) {
            long IntOffset = IntOffsetKt.IntOffset(i, i2);
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.m5886placeAtf8xVGno(IntOffset.m7245plusqkQi6aY(IntOffset, placeable.apparentToRealOffset), f, graphicsLayer);
                return;
            }
            long IntOffset2 = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m7241getXimpl(IntOffset), IntOffset.m7242getYimpl(IntOffset));
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.m5886placeAtf8xVGno(IntOffset.m7245plusqkQi6aY(IntOffset2, placeable.apparentToRealOffset), f, graphicsLayer);
        }

        /* renamed from: placeRelativeWithLayer-aW-9-wM$default  reason: not valid java name */
        public static /* synthetic */ void m5893placeRelativeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j, GraphicsLayer graphicsLayer, float f, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    f = 0.0f;
                }
                placementScope.m5903placeRelativeWithLayeraW9wM(placeable, j, graphicsLayer, f);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
        }

        /* renamed from: placeAutoMirrored-aW-9-wM$ui_release  reason: not valid java name */
        public final void m5900placeAutoMirroredaW9wM$ui_release(Placeable placeable, long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.m5887placeAtf8xVGno(IntOffset.m7245plusqkQi6aY(j, placeable.apparentToRealOffset), f, function1);
                return;
            }
            long IntOffset = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m7241getXimpl(j), IntOffset.m7242getYimpl(j));
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.m5887placeAtf8xVGno(IntOffset.m7245plusqkQi6aY(IntOffset, placeable.apparentToRealOffset), f, function1);
        }

        /* renamed from: placeAutoMirrored-aW-9-wM$ui_release  reason: not valid java name */
        public final void m5899placeAutoMirroredaW9wM$ui_release(Placeable placeable, long j, float f, GraphicsLayer graphicsLayer) {
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.m5886placeAtf8xVGno(IntOffset.m7245plusqkQi6aY(j, placeable.apparentToRealOffset), f, graphicsLayer);
                return;
            }
            long IntOffset = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m7241getXimpl(j), IntOffset.m7242getYimpl(j));
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.m5886placeAtf8xVGno(IntOffset.m7245plusqkQi6aY(IntOffset, placeable.apparentToRealOffset), f, graphicsLayer);
        }

        /* renamed from: placeApparentToRealOffset-aW-9-wM$ui_release  reason: not valid java name */
        public final void m5898placeApparentToRealOffsetaW9wM$ui_release(Placeable placeable, long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.m5887placeAtf8xVGno(IntOffset.m7245plusqkQi6aY(j, placeable.apparentToRealOffset), f, function1);
        }

        /* renamed from: placeApparentToRealOffset-aW-9-wM$ui_release  reason: not valid java name */
        public final void m5897placeApparentToRealOffsetaW9wM$ui_release(Placeable placeable, long j, float f, GraphicsLayer graphicsLayer) {
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.m5886placeAtf8xVGno(IntOffset.m7245plusqkQi6aY(j, placeable.apparentToRealOffset), f, graphicsLayer);
        }

        public final void withMotionFrameOfReferencePlacement(Function1<? super PlacementScope, Unit> function1) {
            this.motionFrameOfReferencePlacement = true;
            function1.invoke(this);
            this.motionFrameOfReferencePlacement = false;
        }

        /* access modifiers changed from: private */
        public final void handleMotionFrameOfReferencePlacement(Placeable placeable) {
            if (placeable instanceof MotionReferencePlacementDelegate) {
                ((MotionReferencePlacementDelegate) placeable).setPlacedUnderMotionFrameOfReference(this.motionFrameOfReferencePlacement);
            }
        }

        /* renamed from: placeRelative-70tqf50  reason: not valid java name */
        public final void m5901placeRelative70tqf50(Placeable placeable, long j, float f) {
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.m5887placeAtf8xVGno(IntOffset.m7245plusqkQi6aY(j, placeable.apparentToRealOffset), f, (Function1<? super GraphicsLayerScope, Unit>) null);
                return;
            }
            long IntOffset = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m7241getXimpl(j), IntOffset.m7242getYimpl(j));
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.m5887placeAtf8xVGno(IntOffset.m7245plusqkQi6aY(IntOffset, placeable.apparentToRealOffset), f, (Function1<? super GraphicsLayerScope, Unit>) null);
        }

        /* renamed from: place-70tqf50  reason: not valid java name */
        public final void m5896place70tqf50(Placeable placeable, long j, float f) {
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.m5887placeAtf8xVGno(IntOffset.m7245plusqkQi6aY(j, placeable.apparentToRealOffset), f, (Function1<? super GraphicsLayerScope, Unit>) null);
        }

        /* renamed from: placeRelativeWithLayer-aW-9-wM  reason: not valid java name */
        public final void m5902placeRelativeWithLayeraW9wM(Placeable placeable, long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.m5887placeAtf8xVGno(IntOffset.m7245plusqkQi6aY(j, placeable.apparentToRealOffset), f, function1);
                return;
            }
            long IntOffset = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m7241getXimpl(j), IntOffset.m7242getYimpl(j));
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.m5887placeAtf8xVGno(IntOffset.m7245plusqkQi6aY(IntOffset, placeable.apparentToRealOffset), f, function1);
        }

        /* renamed from: placeWithLayer-aW-9-wM  reason: not valid java name */
        public final void m5904placeWithLayeraW9wM(Placeable placeable, long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.m5887placeAtf8xVGno(IntOffset.m7245plusqkQi6aY(j, placeable.apparentToRealOffset), f, function1);
        }

        /* renamed from: placeWithLayer-aW-9-wM  reason: not valid java name */
        public final void m5905placeWithLayeraW9wM(Placeable placeable, long j, GraphicsLayer graphicsLayer, float f) {
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.m5886placeAtf8xVGno(IntOffset.m7245plusqkQi6aY(j, placeable.apparentToRealOffset), f, graphicsLayer);
        }

        /* renamed from: placeRelativeWithLayer-aW-9-wM  reason: not valid java name */
        public final void m5903placeRelativeWithLayeraW9wM(Placeable placeable, long j, GraphicsLayer graphicsLayer, float f) {
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.m5886placeAtf8xVGno(IntOffset.m7245plusqkQi6aY(j, placeable.apparentToRealOffset), f, graphicsLayer);
                return;
            }
            long IntOffset = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m7241getXimpl(j), IntOffset.m7242getYimpl(j));
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.m5886placeAtf8xVGno(IntOffset.m7245plusqkQi6aY(IntOffset, placeable.apparentToRealOffset), f, graphicsLayer);
        }
    }
}
