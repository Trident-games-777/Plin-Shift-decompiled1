package androidx.compose.ui.graphics.layer;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.graphics.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005J\u001d\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\u0010H\bJ+\u0010\u0011\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013H\bR\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/graphics/layer/ChildLayerDependenciesTracker;", "", "()V", "dependenciesSet", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "dependency", "oldDependenciesSet", "oldDependency", "trackingInProgress", "", "onDependencyAdded", "graphicsLayer", "removeDependencies", "", "block", "Lkotlin/Function1;", "withTracking", "onDependencyRemoved", "Lkotlin/Function0;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ChildLayerDependenciesTracker.kt */
public final class ChildLayerDependenciesTracker {
    /* access modifiers changed from: private */
    public MutableScatterSet<GraphicsLayer> dependenciesSet;
    /* access modifiers changed from: private */
    public GraphicsLayer dependency;
    /* access modifiers changed from: private */
    public MutableScatterSet<GraphicsLayer> oldDependenciesSet;
    /* access modifiers changed from: private */
    public GraphicsLayer oldDependency;
    /* access modifiers changed from: private */
    public boolean trackingInProgress;

    public final void withTracking(Function1<? super GraphicsLayer, Unit> function1, Function0<Unit> function0) {
        Function1<? super GraphicsLayer, Unit> function12 = function1;
        this.oldDependency = this.dependency;
        MutableScatterSet access$getDependenciesSet$p = this.dependenciesSet;
        if (access$getDependenciesSet$p != null && access$getDependenciesSet$p.isNotEmpty()) {
            MutableScatterSet access$getOldDependenciesSet$p = this.oldDependenciesSet;
            if (access$getOldDependenciesSet$p == null) {
                access$getOldDependenciesSet$p = ScatterSetKt.mutableScatterSetOf();
                this.oldDependenciesSet = access$getOldDependenciesSet$p;
            }
            access$getOldDependenciesSet$p.addAll(access$getDependenciesSet$p);
            access$getDependenciesSet$p.clear();
        }
        this.trackingInProgress = true;
        function0.invoke();
        this.trackingInProgress = false;
        GraphicsLayer access$getOldDependency$p = this.oldDependency;
        if (access$getOldDependency$p != null) {
            function12.invoke(access$getOldDependency$p);
        }
        MutableScatterSet access$getOldDependenciesSet$p2 = this.oldDependenciesSet;
        if (access$getOldDependenciesSet$p2 != null && access$getOldDependenciesSet$p2.isNotEmpty()) {
            ScatterSet scatterSet = access$getOldDependenciesSet$p2;
            Object[] objArr = scatterSet.elements;
            long[] jArr = scatterSet.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                function12.invoke(objArr[(i << 3) + i3]);
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        }
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
            access$getOldDependenciesSet$p2.clear();
        }
    }

    public final boolean onDependencyAdded(GraphicsLayer graphicsLayer) {
        if (!this.trackingInProgress) {
            InlineClassHelperKt.throwIllegalArgumentException("Only add dependencies during a tracking");
        }
        MutableScatterSet<GraphicsLayer> mutableScatterSet = this.dependenciesSet;
        if (mutableScatterSet != null) {
            Intrinsics.checkNotNull(mutableScatterSet);
            mutableScatterSet.add(graphicsLayer);
        } else if (this.dependency != null) {
            MutableScatterSet<GraphicsLayer> mutableScatterSetOf = ScatterSetKt.mutableScatterSetOf();
            GraphicsLayer graphicsLayer2 = this.dependency;
            Intrinsics.checkNotNull(graphicsLayer2);
            mutableScatterSetOf.add(graphicsLayer2);
            mutableScatterSetOf.add(graphicsLayer);
            this.dependenciesSet = mutableScatterSetOf;
            this.dependency = null;
        } else {
            this.dependency = graphicsLayer;
        }
        MutableScatterSet<GraphicsLayer> mutableScatterSet2 = this.oldDependenciesSet;
        if (mutableScatterSet2 != null) {
            Intrinsics.checkNotNull(mutableScatterSet2);
            return !mutableScatterSet2.remove(graphicsLayer);
        } else if (this.oldDependency != graphicsLayer) {
            return true;
        } else {
            this.oldDependency = null;
            return false;
        }
    }

    public final void removeDependencies(Function1<? super GraphicsLayer, Unit> function1) {
        ChildLayerDependenciesTracker childLayerDependenciesTracker;
        Function1<? super GraphicsLayer, Unit> function12 = function1;
        GraphicsLayer access$getDependency$p = this.dependency;
        if (access$getDependency$p != null) {
            function12.invoke(access$getDependency$p);
            childLayerDependenciesTracker = this;
            childLayerDependenciesTracker.dependency = null;
        } else {
            childLayerDependenciesTracker = this;
        }
        MutableScatterSet access$getDependenciesSet$p = childLayerDependenciesTracker.dependenciesSet;
        if (access$getDependenciesSet$p != null) {
            ScatterSet scatterSet = access$getDependenciesSet$p;
            Object[] objArr = scatterSet.elements;
            long[] jArr = scatterSet.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                function12.invoke(objArr[(i << 3) + i3]);
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        }
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
            access$getDependenciesSet$p.clear();
        }
    }
}
