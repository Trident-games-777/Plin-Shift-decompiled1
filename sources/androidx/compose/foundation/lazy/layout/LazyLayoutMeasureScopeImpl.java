package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007Je\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00192\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00190\"2\u001b\b\u0002\u0010$\u001a\u0015\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0018\u00010%¢\u0006\u0002\b(2\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020'0%¢\u0006\u0002\b(H\u0001JH\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00192\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00190\"2\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020'0%¢\u0006\u0002\b(H\u0001J(\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020.H\u0016ø\u0001\u0000¢\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020\u0019*\u000202H\u0001ø\u0001\u0000¢\u0006\u0004\b3\u00104J\u0017\u00101\u001a\u00020\u0019*\u000205H\u0001ø\u0001\u0000¢\u0006\u0004\b6\u00107J\u0016\u00108\u001a\u000202*\u000205H\u0016ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u0019\u00108\u001a\u000202*\u00020\tH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u0019\u00108\u001a\u000202*\u00020\u0019H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b;\u0010=J\u0016\u0010>\u001a\u00020?*\u00020@H\u0016ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ\u0017\u0010C\u001a\u00020\t*\u000202H\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010<J\u0017\u0010C\u001a\u00020\t*\u000205H\u0001ø\u0001\u0000¢\u0006\u0004\bE\u0010:J\r\u0010F\u001a\u00020G*\u00020HH\u0001J\u0016\u0010I\u001a\u00020@*\u00020?H\u0016ø\u0001\u0000¢\u0006\u0004\bJ\u0010BJ\u0016\u0010K\u001a\u000205*\u000202H\u0016ø\u0001\u0000¢\u0006\u0004\bL\u0010MJ\u0019\u0010K\u001a\u000205*\u00020\tH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010MJ\u0019\u0010K\u001a\u000205*\u00020\u0019H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010OR\u0014\u0010\b\u001a\u00020\t8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u0014X\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R6\u0010\u0017\u001a*\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0018j\u0014\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a`\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006P"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScopeImpl;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", "itemContentFactory", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "subcomposeMeasureScope", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;Landroidx/compose/ui/layout/SubcomposeMeasureScope;)V", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "isLookingAhead", "", "()Z", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "placeablesCache", "Ljava/util/HashMap;", "", "", "Landroidx/compose/ui/layout/Placeable;", "Lkotlin/collections/HashMap;", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "placementBlock", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "measure", "index", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-0kLqBqw", "(IJ)Ljava/util/List;", "roundToPx", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutMeasureScope.kt */
public final class LazyLayoutMeasureScopeImpl implements LazyLayoutMeasureScope, MeasureScope {
    public static final int $stable = 0;
    private final LazyLayoutItemContentFactory itemContentFactory;
    private final LazyLayoutItemProvider itemProvider;
    private final HashMap<Integer, List<Placeable>> placeablesCache = new HashMap<>();
    private final SubcomposeMeasureScope subcomposeMeasureScope;

    public float getDensity() {
        return this.subcomposeMeasureScope.getDensity();
    }

    public float getFontScale() {
        return this.subcomposeMeasureScope.getFontScale();
    }

    public LayoutDirection getLayoutDirection() {
        return this.subcomposeMeasureScope.getLayoutDirection();
    }

    public boolean isLookingAhead() {
        return this.subcomposeMeasureScope.isLookingAhead();
    }

    public MeasureResult layout(int i, int i2, Map<AlignmentLine, Integer> map, Function1<? super Placeable.PlacementScope, Unit> function1) {
        return this.subcomposeMeasureScope.layout(i, i2, map, function1);
    }

    public MeasureResult layout(int i, int i2, Map<AlignmentLine, Integer> map, Function1<? super RulerScope, Unit> function1, Function1<? super Placeable.PlacementScope, Unit> function12) {
        return this.subcomposeMeasureScope.layout(i, i2, map, function1, function12);
    }

    /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
    public int m1000roundToPxR2X_6o(long j) {
        return this.subcomposeMeasureScope.m7085roundToPxR2X_6o(j);
    }

    /* renamed from: roundToPx-0680j_4  reason: not valid java name */
    public int m1001roundToPx0680j_4(float f) {
        return this.subcomposeMeasureScope.m7086roundToPx0680j_4(f);
    }

    /* renamed from: toPx--R2X_6o  reason: not valid java name */
    public float m1006toPxR2X_6o(long j) {
        return this.subcomposeMeasureScope.m7090toPxR2X_6o(j);
    }

    /* renamed from: toPx-0680j_4  reason: not valid java name */
    public float m1007toPx0680j_4(float f) {
        return this.subcomposeMeasureScope.m7091toPx0680j_4(f);
    }

    public Rect toRect(DpRect dpRect) {
        return this.subcomposeMeasureScope.toRect(dpRect);
    }

    public LazyLayoutMeasureScopeImpl(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, SubcomposeMeasureScope subcomposeMeasureScope2) {
        this.itemContentFactory = lazyLayoutItemContentFactory;
        this.subcomposeMeasureScope = subcomposeMeasureScope2;
        this.itemProvider = lazyLayoutItemContentFactory.getItemProvider().invoke();
    }

    /* renamed from: measure-0kLqBqw  reason: not valid java name */
    public List<Placeable> m999measure0kLqBqw(int i, long j) {
        List<Placeable> list = this.placeablesCache.get(Integer.valueOf(i));
        if (list != null) {
            return list;
        }
        Object key = this.itemProvider.getKey(i);
        List<Measurable> subcompose = this.subcomposeMeasureScope.subcompose(key, this.itemContentFactory.getContent(i, key, this.itemProvider.getContentType(i)));
        int size = subcompose.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(subcompose.get(i2).m5848measureBRTryo0(j));
        }
        List<Placeable> list2 = arrayList;
        this.placeablesCache.put(Integer.valueOf(i), list2);
        return list2;
    }

    /* renamed from: toDp-GaN1DYA  reason: not valid java name */
    public float m1002toDpGaN1DYA(long j) {
        return this.subcomposeMeasureScope.m7222toDpGaN1DYA(j);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public float m1004toDpu2uoSUM(int i) {
        return this.subcomposeMeasureScope.m7088toDpu2uoSUM(i);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public float m1003toDpu2uoSUM(float f) {
        return this.subcomposeMeasureScope.m7087toDpu2uoSUM(f);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public long m1010toSpkPz2Gy4(float f) {
        return this.subcomposeMeasureScope.m7093toSpkPz2Gy4(f);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public long m1011toSpkPz2Gy4(int i) {
        return this.subcomposeMeasureScope.m7094toSpkPz2Gy4(i);
    }

    /* renamed from: toSp-0xMU5do  reason: not valid java name */
    public long m1009toSp0xMU5do(float f) {
        return this.subcomposeMeasureScope.m7223toSp0xMU5do(f);
    }

    /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
    public long m1008toSizeXkaWNTQ(long j) {
        return this.subcomposeMeasureScope.m7092toSizeXkaWNTQ(j);
    }

    /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
    public long m1005toDpSizekrfVVM(long j) {
        return this.subcomposeMeasureScope.m7089toDpSizekrfVVM(j);
    }
}
