package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.FlowLayoutOverflow;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B«\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0017\u0010\u0013\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0002\b\u00170\u0014\u0012;\u0010\u0018\u001a7\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00160\u0019¢\u0006\u0002\b\u0017¢\u0006\u0002\u0010\u001fJ\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0012HÂ\u0003J\u001a\u0010+\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0002\b\u00170\u0014HÂ\u0003JC\u0010,\u001a7\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00160\u0019¢\u0006\u0002\b\u0017HÂ\u0003¢\u0006\u0002\u0010-J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0007HÆ\u0003J\u0016\u00100\u001a\u00020\tHÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102J\t\u00103\u001a\u00020\u000bHÆ\u0003J\u0016\u00104\u001a\u00020\tHÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00102J\t\u00106\u001a\u00020\u000eHÂ\u0003J\t\u00107\u001a\u00020\u000eHÂ\u0003J\t\u00108\u001a\u00020\u000eHÂ\u0003JÑ\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0019\b\u0002\u0010\u0013\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0002\b\u00170\u00142=\b\u0002\u0010\u0018\u001a7\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00160\u0019¢\u0006\u0002\b\u0017HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b:\u0010;J\u0013\u0010<\u001a\u00020\u00032\b\u0010=\u001a\u0004\u0018\u00010>HÖ\u0003J\u0018\u0010?\u001a\u0014\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020B0\u0019J\t\u0010C\u001a\u00020\u000eHÖ\u0001J\t\u0010D\u001a\u00020EHÖ\u0001J\u001e\u0010F\u001a\u00020B*\u00020@2\u0006\u0010G\u001a\u00020AH\u0002ø\u0001\u0000¢\u0006\u0004\bH\u0010IR\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\f\u001a\u00020\tX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\"RE\u0010\u0018\u001a7\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00160\u0019¢\u0006\u0002\b\u0017X\u0004¢\u0006\u0004\n\u0002\u0010#R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010&R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u00020\tX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\"R\u000e\u0010\u0010\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0013\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0002\b\u00170\u0014X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006J"}, d2 = {"Landroidx/compose/foundation/layout/FlowMeasureLazyPolicy;", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "isHorizontal", "", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "crossAxisArrangementSpacing", "itemCount", "", "maxLines", "maxItemsInMainAxis", "overflow", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "overflowComposables", "", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "getComposable", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "index", "Landroidx/compose/foundation/layout/FlowLineInfo;", "info", "(ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/CrossAxisAlignment;FIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Ljava/util/List;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCrossAxisAlignment", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "F", "Lkotlin/jvm/functions/Function4;", "getHorizontalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "()Z", "getVerticalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "component1", "component10", "component11", "component12", "()Lkotlin/jvm/functions/Function4;", "component2", "component3", "component4", "component4-D9Ej5fM", "()F", "component5", "component6", "component6-D9Ej5fM", "component7", "component8", "component9", "copy", "copy-E4Q9ldg", "(ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/CrossAxisAlignment;FIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Ljava/util/List;Lkotlin/jvm/functions/Function4;)Landroidx/compose/foundation/layout/FlowMeasureLazyPolicy;", "equals", "other", "", "getMeasurePolicy", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "hashCode", "toString", "", "measure", "constraints", "measure-0kLqBqw", "(Landroidx/compose/ui/layout/SubcomposeMeasureScope;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContextualFlowLayout.kt */
final class FlowMeasureLazyPolicy implements FlowLineMeasurePolicy {
    private final CrossAxisAlignment crossAxisAlignment;
    private final float crossAxisArrangementSpacing;
    /* access modifiers changed from: private */
    public final Function4<Integer, FlowLineInfo, Composer, Integer, Unit> getComposable;
    private final Arrangement.Horizontal horizontalArrangement;
    private final boolean isHorizontal;
    /* access modifiers changed from: private */
    public final int itemCount;
    private final float mainAxisSpacing;
    private final int maxItemsInMainAxis;
    private final int maxLines;
    private final FlowLayoutOverflowState overflow;
    /* access modifiers changed from: private */
    public final List<Function2<Composer, Integer, Unit>> overflowComposables;
    private final Arrangement.Vertical verticalArrangement;

    public /* synthetic */ FlowMeasureLazyPolicy(boolean z, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, CrossAxisAlignment crossAxisAlignment2, float f2, int i, int i2, int i3, FlowLayoutOverflowState flowLayoutOverflowState, List list, Function4 function4, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, horizontal, vertical, f, crossAxisAlignment2, f2, i, i2, i3, flowLayoutOverflowState, list, function4);
    }

    private final FlowLayoutOverflowState component10() {
        return this.overflow;
    }

    private final List<Function2<Composer, Integer, Unit>> component11() {
        return this.overflowComposables;
    }

    private final Function4<Integer, FlowLineInfo, Composer, Integer, Unit> component12() {
        return this.getComposable;
    }

    /* renamed from: component4-D9Ej5fM  reason: not valid java name */
    private final float m707component4D9Ej5fM() {
        return this.mainAxisSpacing;
    }

    /* renamed from: component6-D9Ej5fM  reason: not valid java name */
    private final float m708component6D9Ej5fM() {
        return this.crossAxisArrangementSpacing;
    }

    private final int component7() {
        return this.itemCount;
    }

    private final int component8() {
        return this.maxLines;
    }

    private final int component9() {
        return this.maxItemsInMainAxis;
    }

    /* renamed from: copy-E4Q9ldg$default  reason: not valid java name */
    public static /* synthetic */ FlowMeasureLazyPolicy m709copyE4Q9ldg$default(FlowMeasureLazyPolicy flowMeasureLazyPolicy, boolean z, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, CrossAxisAlignment crossAxisAlignment2, float f2, int i, int i2, int i3, FlowLayoutOverflowState flowLayoutOverflowState, List<Function2<Composer, Integer, Unit>> list, Function4<Integer, FlowLineInfo, Composer, Integer, Unit> function4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z = flowMeasureLazyPolicy.isHorizontal;
        }
        if ((i4 & 2) != 0) {
            horizontal = flowMeasureLazyPolicy.horizontalArrangement;
        }
        if ((i4 & 4) != 0) {
            vertical = flowMeasureLazyPolicy.verticalArrangement;
        }
        if ((i4 & 8) != 0) {
            f = flowMeasureLazyPolicy.mainAxisSpacing;
        }
        if ((i4 & 16) != 0) {
            crossAxisAlignment2 = flowMeasureLazyPolicy.crossAxisAlignment;
        }
        if ((i4 & 32) != 0) {
            f2 = flowMeasureLazyPolicy.crossAxisArrangementSpacing;
        }
        if ((i4 & 64) != 0) {
            i = flowMeasureLazyPolicy.itemCount;
        }
        if ((i4 & 128) != 0) {
            i2 = flowMeasureLazyPolicy.maxLines;
        }
        if ((i4 & 256) != 0) {
            i3 = flowMeasureLazyPolicy.maxItemsInMainAxis;
        }
        if ((i4 & 512) != 0) {
            flowLayoutOverflowState = flowMeasureLazyPolicy.overflow;
        }
        if ((i4 & 1024) != 0) {
            list = flowMeasureLazyPolicy.overflowComposables;
        }
        if ((i4 & 2048) != 0) {
            function4 = flowMeasureLazyPolicy.getComposable;
        }
        List<Function2<Composer, Integer, Unit>> list2 = list;
        Function4<Integer, FlowLineInfo, Composer, Integer, Unit> function42 = function4;
        int i5 = i3;
        FlowLayoutOverflowState flowLayoutOverflowState2 = flowLayoutOverflowState;
        int i6 = i;
        int i7 = i2;
        CrossAxisAlignment crossAxisAlignment3 = crossAxisAlignment2;
        float f3 = f2;
        float f4 = f;
        Arrangement.Horizontal horizontal2 = horizontal;
        return flowMeasureLazyPolicy.m711copyE4Q9ldg(z, horizontal2, vertical, f4, crossAxisAlignment3, f3, i6, i7, i5, flowLayoutOverflowState2, list2, function42);
    }

    public final boolean component1() {
        return this.isHorizontal;
    }

    public final Arrangement.Horizontal component2() {
        return this.horizontalArrangement;
    }

    public final Arrangement.Vertical component3() {
        return this.verticalArrangement;
    }

    public final CrossAxisAlignment component5() {
        return this.crossAxisAlignment;
    }

    /* renamed from: copy-E4Q9ldg  reason: not valid java name */
    public final FlowMeasureLazyPolicy m711copyE4Q9ldg(boolean z, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, CrossAxisAlignment crossAxisAlignment2, float f2, int i, int i2, int i3, FlowLayoutOverflowState flowLayoutOverflowState, List<? extends Function2<? super Composer, ? super Integer, Unit>> list, Function4<? super Integer, ? super FlowLineInfo, ? super Composer, ? super Integer, Unit> function4) {
        return new FlowMeasureLazyPolicy(z, horizontal, vertical, f, crossAxisAlignment2, f2, i, i2, i3, flowLayoutOverflowState, list, function4, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlowMeasureLazyPolicy)) {
            return false;
        }
        FlowMeasureLazyPolicy flowMeasureLazyPolicy = (FlowMeasureLazyPolicy) obj;
        return this.isHorizontal == flowMeasureLazyPolicy.isHorizontal && Intrinsics.areEqual((Object) this.horizontalArrangement, (Object) flowMeasureLazyPolicy.horizontalArrangement) && Intrinsics.areEqual((Object) this.verticalArrangement, (Object) flowMeasureLazyPolicy.verticalArrangement) && Dp.m7116equalsimpl0(this.mainAxisSpacing, flowMeasureLazyPolicy.mainAxisSpacing) && Intrinsics.areEqual((Object) this.crossAxisAlignment, (Object) flowMeasureLazyPolicy.crossAxisAlignment) && Dp.m7116equalsimpl0(this.crossAxisArrangementSpacing, flowMeasureLazyPolicy.crossAxisArrangementSpacing) && this.itemCount == flowMeasureLazyPolicy.itemCount && this.maxLines == flowMeasureLazyPolicy.maxLines && this.maxItemsInMainAxis == flowMeasureLazyPolicy.maxItemsInMainAxis && Intrinsics.areEqual((Object) this.overflow, (Object) flowMeasureLazyPolicy.overflow) && Intrinsics.areEqual((Object) this.overflowComposables, (Object) flowMeasureLazyPolicy.overflowComposables) && Intrinsics.areEqual((Object) this.getComposable, (Object) flowMeasureLazyPolicy.getComposable);
    }

    public int hashCode() {
        return (((((((((((((((((((((Boolean.hashCode(this.isHorizontal) * 31) + this.horizontalArrangement.hashCode()) * 31) + this.verticalArrangement.hashCode()) * 31) + Dp.m7117hashCodeimpl(this.mainAxisSpacing)) * 31) + this.crossAxisAlignment.hashCode()) * 31) + Dp.m7117hashCodeimpl(this.crossAxisArrangementSpacing)) * 31) + Integer.hashCode(this.itemCount)) * 31) + Integer.hashCode(this.maxLines)) * 31) + Integer.hashCode(this.maxItemsInMainAxis)) * 31) + this.overflow.hashCode()) * 31) + this.overflowComposables.hashCode()) * 31) + this.getComposable.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FlowMeasureLazyPolicy(isHorizontal=");
        sb.append(this.isHorizontal).append(", horizontalArrangement=").append(this.horizontalArrangement).append(", verticalArrangement=").append(this.verticalArrangement).append(", mainAxisSpacing=").append(Dp.m7122toStringimpl(this.mainAxisSpacing)).append(", crossAxisAlignment=").append(this.crossAxisAlignment).append(", crossAxisArrangementSpacing=").append(Dp.m7122toStringimpl(this.crossAxisArrangementSpacing)).append(", itemCount=").append(this.itemCount).append(", maxLines=").append(this.maxLines).append(", maxItemsInMainAxis=").append(this.maxItemsInMainAxis).append(", overflow=").append(this.overflow).append(", overflowComposables=").append(this.overflowComposables).append(", getComposable=");
        sb.append(this.getComposable).append(')');
        return sb.toString();
    }

    private FlowMeasureLazyPolicy(boolean z, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, CrossAxisAlignment crossAxisAlignment2, float f2, int i, int i2, int i3, FlowLayoutOverflowState flowLayoutOverflowState, List<? extends Function2<? super Composer, ? super Integer, Unit>> list, Function4<? super Integer, ? super FlowLineInfo, ? super Composer, ? super Integer, Unit> function4) {
        this.isHorizontal = z;
        this.horizontalArrangement = horizontal;
        this.verticalArrangement = vertical;
        this.mainAxisSpacing = f;
        this.crossAxisAlignment = crossAxisAlignment2;
        this.crossAxisArrangementSpacing = f2;
        this.itemCount = i;
        this.maxLines = i2;
        this.maxItemsInMainAxis = i3;
        this.overflow = flowLayoutOverflowState;
        this.overflowComposables = list;
        this.getComposable = function4;
    }

    public boolean isHorizontal() {
        return this.isHorizontal;
    }

    public Arrangement.Horizontal getHorizontalArrangement() {
        return this.horizontalArrangement;
    }

    public Arrangement.Vertical getVerticalArrangement() {
        return this.verticalArrangement;
    }

    public CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    public final Function2<SubcomposeMeasureScope, Constraints, MeasureResult> getMeasurePolicy() {
        return new FlowMeasureLazyPolicy$getMeasurePolicy$1(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: measure-0kLqBqw  reason: not valid java name */
    public final MeasureResult m710measure0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
        LayoutOrientation layoutOrientation;
        if (this.itemCount <= 0 || this.maxLines == 0 || this.maxItemsInMainAxis == 0 || (Constraints.m7051getMaxHeightimpl(j) == 0 && this.overflow.getType$foundation_layout_release() != FlowLayoutOverflow.OverflowType.Visible)) {
            return MeasureScope.layout$default(subcomposeMeasureScope, 0, 0, (Map) null, FlowMeasureLazyPolicy$measure$1.INSTANCE, 4, (Object) null);
        }
        ContextualFlowItemIterator contextualFlowItemIterator = new ContextualFlowItemIterator(this.itemCount, new FlowMeasureLazyPolicy$measure$measurablesIterator$1(subcomposeMeasureScope, this));
        this.overflow.setItemCount$foundation_layout_release(this.itemCount);
        FlowLineMeasurePolicy flowLineMeasurePolicy = this;
        this.overflow.m699setOverflowMeasurablesVKLhPVY$foundation_layout_release(flowLineMeasurePolicy, j, new FlowMeasureLazyPolicy$measure$2(this, subcomposeMeasureScope));
        MeasureScope measureScope = subcomposeMeasureScope;
        Iterator it = contextualFlowItemIterator;
        float f = this.mainAxisSpacing;
        float f2 = this.crossAxisArrangementSpacing;
        if (isHorizontal()) {
            layoutOrientation = LayoutOrientation.Horizontal;
        } else {
            layoutOrientation = LayoutOrientation.Vertical;
        }
        return FlowLayoutKt.m691breakDownItemsdi9J0FM(measureScope, flowLineMeasurePolicy, it, f, f2, OrientationIndependentConstraints.m744constructorimpl(j, layoutOrientation), this.maxItemsInMainAxis, this.maxLines, this.overflow);
    }
}
