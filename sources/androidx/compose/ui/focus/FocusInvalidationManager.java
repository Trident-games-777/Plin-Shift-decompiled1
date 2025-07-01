package androidx.compose.ui.focus;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\fJ\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000eJ%\u0010\u0013\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0015*\b\u0012\u0004\u0012\u0002H\u00150\t2\u0006\u0010\u0014\u001a\u0002H\u0015H\u0002¢\u0006\u0002\u0010\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R \u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/focus/FocusInvalidationManager;", "", "onRequestApplyChangesListener", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "invalidateOwnerFocusState", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "focusEventNodes", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "focusPropertiesNodes", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "focusTargetNodes", "Landroidx/compose/ui/focus/FocusTargetNode;", "focusTargetsWithInvalidatedFocusEvents", "hasPendingInvalidation", "", "invalidateNodes", "scheduleInvalidation", "node", "T", "(Landroidx/collection/MutableScatterSet;Ljava/lang/Object;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusInvalidationManager.kt */
public final class FocusInvalidationManager {
    public static final int $stable = 8;
    private final MutableScatterSet<FocusEventModifierNode> focusEventNodes = ScatterSetKt.mutableScatterSetOf();
    private final MutableScatterSet<FocusPropertiesModifierNode> focusPropertiesNodes = ScatterSetKt.mutableScatterSetOf();
    private final MutableScatterSet<FocusTargetNode> focusTargetNodes = ScatterSetKt.mutableScatterSetOf();
    private final MutableScatterSet<FocusTargetNode> focusTargetsWithInvalidatedFocusEvents = ScatterSetKt.mutableScatterSetOf();
    private final Function0<Unit> invalidateOwnerFocusState;
    private final Function1<Function0<Unit>, Unit> onRequestApplyChangesListener;

    public FocusInvalidationManager(Function1<? super Function0<Unit>, Unit> function1, Function0<Unit> function0) {
        this.onRequestApplyChangesListener = function1;
        this.invalidateOwnerFocusState = function0;
    }

    public final void scheduleInvalidation(FocusTargetNode focusTargetNode) {
        scheduleInvalidation(this.focusTargetNodes, focusTargetNode);
    }

    public final void scheduleInvalidation(FocusEventModifierNode focusEventModifierNode) {
        scheduleInvalidation(this.focusEventNodes, focusEventModifierNode);
    }

    public final void scheduleInvalidation(FocusPropertiesModifierNode focusPropertiesModifierNode) {
        scheduleInvalidation(this.focusPropertiesNodes, focusPropertiesModifierNode);
    }

    public final boolean hasPendingInvalidation() {
        return this.focusTargetNodes.isNotEmpty() || this.focusPropertiesNodes.isNotEmpty() || this.focusEventNodes.isNotEmpty();
    }

    private final <T> void scheduleInvalidation(MutableScatterSet<T> mutableScatterSet, T t) {
        if (mutableScatterSet.add(t) && this.focusTargetNodes.getSize() + this.focusEventNodes.getSize() + this.focusPropertiesNodes.getSize() == 1) {
            this.onRequestApplyChangesListener.invoke(new FocusInvalidationManager$scheduleInvalidation$1(this));
        }
    }

    /* access modifiers changed from: private */
    public final void invalidateNodes() {
        char c;
        long j;
        long j2;
        int i;
        String str;
        Object[] objArr;
        long[] jArr;
        long j3;
        String str2;
        Object[] objArr2;
        long[] jArr2;
        FocusState focusState;
        FocusStateImpl focusStateImpl;
        long j4;
        String str3;
        Object[] objArr3;
        long j5;
        String str4;
        int i2;
        MutableVector mutableVector;
        long[] jArr3;
        int i3;
        int i4;
        long[] jArr4;
        long[] jArr5;
        int i5;
        char c2;
        long[] jArr6;
        int i6;
        long[] jArr7;
        MutableVector mutableVector2;
        ScatterSet scatterSet = this.focusPropertiesNodes;
        Object[] objArr4 = scatterSet.elements;
        long[] jArr8 = scatterSet.metadata;
        int length = jArr8.length - 2;
        String str5 = "visitChildren called on an unattached node";
        char c3 = 7;
        int i7 = 16;
        int i8 = 8;
        int i9 = 1;
        int i10 = 0;
        if (length >= 0) {
            int i11 = 0;
            j2 = 255;
            while (true) {
                long j6 = jArr8[i11];
                j = -9187201950435737472L;
                if ((((~j6) << c3) & j6 & -9187201950435737472L) != -9187201950435737472L) {
                    int i12 = 8 - ((~(i11 - length)) >>> 31);
                    int i13 = i10;
                    while (i13 < i12) {
                        if ((j6 & 255) < 128) {
                            FocusPropertiesModifierNode focusPropertiesModifierNode = (FocusPropertiesModifierNode) objArr4[(i11 << 3) + i13];
                            if (focusPropertiesModifierNode.getNode().isAttached()) {
                                DelegatableNode delegatableNode = focusPropertiesModifierNode;
                                int r24 = NodeKind.m6139constructorimpl(1024);
                                c2 = c3;
                                Modifier.Node node = delegatableNode.getNode();
                                MutableVector mutableVector3 = null;
                                while (node != null) {
                                    if (node instanceof FocusTargetNode) {
                                        this.focusTargetNodes.add((FocusTargetNode) node);
                                    } else if ((node.getKindSet$ui_release() & r24) != 0 && (node instanceof DelegatingNode)) {
                                        Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release();
                                        i6 = i3;
                                        int i14 = i10;
                                        while (delegate$ui_release != null) {
                                            if ((delegate$ui_release.getKindSet$ui_release() & r24) != 0) {
                                                i14++;
                                                if (i14 == i4) {
                                                    jArr7 = jArr4;
                                                    node = delegate$ui_release;
                                                } else {
                                                    if (mutableVector3 == null) {
                                                        jArr7 = jArr4;
                                                        mutableVector2 = new MutableVector(new Modifier.Node[i7], i10);
                                                    } else {
                                                        jArr7 = jArr4;
                                                        mutableVector2 = mutableVector3;
                                                    }
                                                    if (node != null) {
                                                        if (mutableVector2 != null) {
                                                            Boolean.valueOf(mutableVector2.add(node));
                                                        }
                                                        node = null;
                                                    }
                                                    if (mutableVector2 != null) {
                                                        Boolean.valueOf(mutableVector2.add(delegate$ui_release));
                                                    }
                                                    mutableVector3 = mutableVector2;
                                                }
                                            } else {
                                                jArr7 = jArr4;
                                            }
                                            delegate$ui_release = delegate$ui_release.getChild$ui_release();
                                            jArr4 = jArr7;
                                            i4 = 1;
                                        }
                                        jArr6 = jArr4;
                                        int i15 = i4;
                                        if (i14 == i15) {
                                            i4 = i15;
                                            i3 = i6;
                                            jArr4 = jArr6;
                                        }
                                        node = DelegatableNodeKt.pop(mutableVector3);
                                        i3 = i6;
                                        jArr4 = jArr6;
                                        i4 = 1;
                                    }
                                    jArr6 = jArr4;
                                    i6 = i3;
                                    node = DelegatableNodeKt.pop(mutableVector3);
                                    i3 = i6;
                                    jArr4 = jArr6;
                                    i4 = 1;
                                }
                                jArr5 = jArr4;
                                i5 = i3;
                                if (delegatableNode.getNode().isAttached()) {
                                    MutableVector mutableVector4 = new MutableVector(new Modifier.Node[i7], i10);
                                    Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
                                    if (child$ui_release == null) {
                                        DelegatableNodeKt.addLayoutNodeChildren(mutableVector4, delegatableNode.getNode());
                                    } else {
                                        mutableVector4.add(child$ui_release);
                                    }
                                    while (mutableVector4.isNotEmpty()) {
                                        Modifier.Node node2 = (Modifier.Node) mutableVector4.removeAt(mutableVector4.getSize() - 1);
                                        if ((node2.getAggregateChildKindSet$ui_release() & r24) == 0) {
                                            DelegatableNodeKt.addLayoutNodeChildren(mutableVector4, node2);
                                        } else {
                                            while (true) {
                                                if (node2 == null) {
                                                    break;
                                                } else if ((node2.getKindSet$ui_release() & r24) != 0) {
                                                    MutableVector mutableVector5 = null;
                                                    while (node2 != null) {
                                                        if (node2 instanceof FocusTargetNode) {
                                                            this.focusTargetNodes.add((FocusTargetNode) node2);
                                                        } else if ((node2.getKindSet$ui_release() & r24) != 0 && (node2 instanceof DelegatingNode)) {
                                                            Modifier.Node delegate$ui_release2 = ((DelegatingNode) node2).getDelegate$ui_release();
                                                            int i16 = i10;
                                                            while (delegate$ui_release2 != null) {
                                                                if ((delegate$ui_release2.getKindSet$ui_release() & r24) != 0) {
                                                                    i16++;
                                                                    if (i16 == 1) {
                                                                        node2 = delegate$ui_release2;
                                                                    } else {
                                                                        if (mutableVector5 == null) {
                                                                            mutableVector5 = new MutableVector(new Modifier.Node[i7], 0);
                                                                        }
                                                                        if (node2 != null) {
                                                                            if (mutableVector5 != null) {
                                                                                Boolean.valueOf(mutableVector5.add(node2));
                                                                            }
                                                                            node2 = null;
                                                                        }
                                                                        if (mutableVector5 != null) {
                                                                            Boolean.valueOf(mutableVector5.add(delegate$ui_release2));
                                                                        }
                                                                    }
                                                                }
                                                                delegate$ui_release2 = delegate$ui_release2.getChild$ui_release();
                                                                i7 = 16;
                                                            }
                                                            if (i16 == 1) {
                                                                i10 = 0;
                                                                i7 = 16;
                                                            }
                                                        }
                                                        node2 = DelegatableNodeKt.pop(mutableVector5);
                                                        i10 = 0;
                                                        i7 = 16;
                                                    }
                                                } else {
                                                    node2 = node2.getChild$ui_release();
                                                    i10 = 0;
                                                    i7 = 16;
                                                }
                                            }
                                        }
                                    }
                                    j6 >>= i5;
                                    i13++;
                                    c3 = c2;
                                    i8 = i5;
                                    jArr8 = jArr5;
                                    i9 = 1;
                                    i10 = 0;
                                    i7 = 16;
                                } else {
                                    throw new IllegalStateException(str5.toString());
                                }
                            }
                        }
                        jArr5 = jArr4;
                        c2 = c3;
                        i5 = i3;
                        j6 >>= i5;
                        i13++;
                        c3 = c2;
                        i8 = i5;
                        jArr8 = jArr5;
                        i9 = 1;
                        i10 = 0;
                        i7 = 16;
                    }
                    jArr3 = jArr4;
                    c = c3;
                    if (i12 != i3) {
                        break;
                    }
                } else {
                    jArr3 = jArr8;
                    c = c3;
                }
                if (i11 == length) {
                    break;
                }
                i11++;
                c3 = c;
                jArr8 = jArr3;
                i9 = 1;
                i10 = 0;
                i7 = 16;
                i8 = 8;
            }
        } else {
            c = 7;
            j2 = 255;
            j = -9187201950435737472L;
        }
        this.focusPropertiesNodes.clear();
        ScatterSet scatterSet2 = this.focusEventNodes;
        Object[] objArr5 = scatterSet2.elements;
        long[] jArr9 = scatterSet2.metadata;
        int length2 = jArr9.length - 2;
        if (length2 >= 0) {
            int i17 = 0;
            while (true) {
                long j7 = jArr9[i17];
                if ((((~j7) << c) & j7 & j) != j) {
                    int i18 = 8 - ((~(i17 - length2)) >>> 31);
                    int i19 = 0;
                    while (i19 < i18) {
                        if ((j7 & j2) < 128) {
                            FocusEventModifierNode focusEventModifierNode = (FocusEventModifierNode) objArr5[(i17 << 3) + i19];
                            if (!focusEventModifierNode.getNode().isAttached()) {
                                focusEventModifierNode.onFocusEvent(FocusStateImpl.Inactive);
                            } else {
                                DelegatableNode delegatableNode2 = focusEventModifierNode;
                                int r10 = NodeKind.m6139constructorimpl(1024);
                                Modifier.Node node3 = delegatableNode2.getNode();
                                boolean z = false;
                                boolean z2 = true;
                                FocusTargetNode focusTargetNode = null;
                                MutableVector mutableVector6 = null;
                                while (node3 != null) {
                                    long[] jArr10 = jArr9;
                                    if (node3 instanceof FocusTargetNode) {
                                        FocusTargetNode focusTargetNode2 = (FocusTargetNode) node3;
                                        if (focusTargetNode != null) {
                                            z = true;
                                        }
                                        if (this.focusTargetNodes.contains(focusTargetNode2)) {
                                            this.focusTargetsWithInvalidatedFocusEvents.add(focusTargetNode2);
                                            z2 = false;
                                        }
                                        objArr3 = objArr5;
                                        str3 = str5;
                                        j4 = j7;
                                        focusTargetNode = focusTargetNode2;
                                    } else if ((node3.getKindSet$ui_release() & r10) == 0 || !(node3 instanceof DelegatingNode)) {
                                        objArr3 = objArr5;
                                        str3 = str5;
                                        j4 = j7;
                                    } else {
                                        Modifier.Node delegate$ui_release3 = ((DelegatingNode) node3).getDelegate$ui_release();
                                        objArr3 = objArr5;
                                        int i20 = 0;
                                        while (delegate$ui_release3 != null) {
                                            if ((delegate$ui_release3.getKindSet$ui_release() & r10) != 0) {
                                                i20++;
                                                str4 = str5;
                                                if (i20 == 1) {
                                                    node3 = delegate$ui_release3;
                                                } else {
                                                    if (mutableVector6 == null) {
                                                        i2 = i20;
                                                        j5 = j7;
                                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                    } else {
                                                        i2 = i20;
                                                        j5 = j7;
                                                        mutableVector = mutableVector6;
                                                    }
                                                    if (node3 != null) {
                                                        if (mutableVector != null) {
                                                            Boolean.valueOf(mutableVector.add(node3));
                                                        }
                                                        node3 = null;
                                                    }
                                                    if (mutableVector != null) {
                                                        Boolean.valueOf(mutableVector.add(delegate$ui_release3));
                                                    }
                                                    mutableVector6 = mutableVector;
                                                    i20 = i2;
                                                    delegate$ui_release3 = delegate$ui_release3.getChild$ui_release();
                                                    str5 = str4;
                                                    j7 = j5;
                                                }
                                            } else {
                                                str4 = str5;
                                            }
                                            j5 = j7;
                                            delegate$ui_release3 = delegate$ui_release3.getChild$ui_release();
                                            str5 = str4;
                                            j7 = j5;
                                        }
                                        str3 = str5;
                                        j4 = j7;
                                        if (i20 == 1) {
                                            jArr9 = jArr10;
                                            objArr5 = objArr3;
                                            str5 = str3;
                                            j7 = j4;
                                        }
                                    }
                                    node3 = DelegatableNodeKt.pop(mutableVector6);
                                    jArr9 = jArr10;
                                    objArr5 = objArr3;
                                    str5 = str3;
                                    j7 = j4;
                                }
                                jArr2 = jArr9;
                                objArr2 = objArr5;
                                str2 = str5;
                                j3 = j7;
                                if (delegatableNode2.getNode().isAttached()) {
                                    MutableVector mutableVector7 = new MutableVector(new Modifier.Node[16], 0);
                                    Modifier.Node child$ui_release2 = delegatableNode2.getNode().getChild$ui_release();
                                    if (child$ui_release2 == null) {
                                        DelegatableNodeKt.addLayoutNodeChildren(mutableVector7, delegatableNode2.getNode());
                                    } else {
                                        mutableVector7.add(child$ui_release2);
                                    }
                                    while (mutableVector7.isNotEmpty()) {
                                        Modifier.Node node4 = (Modifier.Node) mutableVector7.removeAt(mutableVector7.getSize() - 1);
                                        if ((node4.getAggregateChildKindSet$ui_release() & r10) != 0) {
                                            while (true) {
                                                if (node4 == null) {
                                                    break;
                                                } else if ((node4.getKindSet$ui_release() & r10) != 0) {
                                                    MutableVector mutableVector8 = null;
                                                    while (node4 != null) {
                                                        if (node4 instanceof FocusTargetNode) {
                                                            FocusTargetNode focusTargetNode3 = (FocusTargetNode) node4;
                                                            if (focusTargetNode != null) {
                                                                z = true;
                                                            }
                                                            if (this.focusTargetNodes.contains(focusTargetNode3)) {
                                                                this.focusTargetsWithInvalidatedFocusEvents.add(focusTargetNode3);
                                                                z2 = false;
                                                            }
                                                            focusTargetNode = focusTargetNode3;
                                                        } else if ((node4.getKindSet$ui_release() & r10) != 0 && (node4 instanceof DelegatingNode)) {
                                                            int i21 = 0;
                                                            for (Modifier.Node delegate$ui_release4 = ((DelegatingNode) node4).getDelegate$ui_release(); delegate$ui_release4 != null; delegate$ui_release4 = delegate$ui_release4.getChild$ui_release()) {
                                                                if ((delegate$ui_release4.getKindSet$ui_release() & r10) != 0) {
                                                                    i21++;
                                                                    if (i21 == 1) {
                                                                        node4 = delegate$ui_release4;
                                                                    } else {
                                                                        if (mutableVector8 == null) {
                                                                            mutableVector8 = new MutableVector(new Modifier.Node[16], 0);
                                                                        }
                                                                        if (node4 != null) {
                                                                            if (mutableVector8 != null) {
                                                                                Boolean.valueOf(mutableVector8.add(node4));
                                                                            }
                                                                            node4 = null;
                                                                        }
                                                                        if (mutableVector8 != null) {
                                                                            Boolean.valueOf(mutableVector8.add(delegate$ui_release4));
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            if (i21 == 1) {
                                                            }
                                                            node4 = DelegatableNodeKt.pop(mutableVector8);
                                                        }
                                                        node4 = DelegatableNodeKt.pop(mutableVector8);
                                                    }
                                                } else {
                                                    node4 = node4.getChild$ui_release();
                                                }
                                            }
                                        } else {
                                            DelegatableNodeKt.addLayoutNodeChildren(mutableVector7, node4);
                                        }
                                    }
                                    if (z2) {
                                        if (z) {
                                            focusState = FocusEventModifierNodeKt.getFocusState(focusEventModifierNode);
                                        } else {
                                            if (focusTargetNode == null || (focusStateImpl = focusTargetNode.getFocusState()) == null) {
                                                focusStateImpl = FocusStateImpl.Inactive;
                                            }
                                            focusState = focusStateImpl;
                                        }
                                        focusEventModifierNode.onFocusEvent(focusState);
                                    }
                                    i19++;
                                    j7 = j3 >> 8;
                                    jArr9 = jArr2;
                                    objArr5 = objArr2;
                                    str5 = str2;
                                } else {
                                    throw new IllegalStateException(str2.toString());
                                }
                            }
                        }
                        jArr2 = jArr9;
                        objArr2 = objArr5;
                        str2 = str5;
                        j3 = j7;
                        i19++;
                        j7 = j3 >> 8;
                        jArr9 = jArr2;
                        objArr5 = objArr2;
                        str5 = str2;
                    }
                    jArr = jArr9;
                    objArr = objArr5;
                    str = str5;
                    i = 0;
                    if (i18 != 8) {
                        break;
                    }
                } else {
                    jArr = jArr9;
                    objArr = objArr5;
                    str = str5;
                    i = 0;
                }
                if (i17 == length2) {
                    break;
                }
                i17++;
                jArr9 = jArr;
                objArr5 = objArr;
                str5 = str;
            }
        } else {
            i = 0;
        }
        this.focusEventNodes.clear();
        ScatterSet scatterSet3 = this.focusTargetNodes;
        Object[] objArr6 = scatterSet3.elements;
        long[] jArr11 = scatterSet3.metadata;
        int length3 = jArr11.length - 2;
        if (length3 >= 0) {
            int i22 = i;
            while (true) {
                long j8 = jArr11[i22];
                if ((((~j8) << c) & j8 & j) != j) {
                    int i23 = 8 - ((~(i22 - length3)) >>> 31);
                    for (int i24 = i; i24 < i23; i24++) {
                        if ((j8 & j2) < 128) {
                            FocusTargetNode focusTargetNode4 = (FocusTargetNode) objArr6[(i22 << 3) + i24];
                            if (focusTargetNode4.isAttached()) {
                                FocusStateImpl focusState2 = focusTargetNode4.getFocusState();
                                focusTargetNode4.invalidateFocus$ui_release();
                                if (focusState2 != focusTargetNode4.getFocusState() || this.focusTargetsWithInvalidatedFocusEvents.contains(focusTargetNode4)) {
                                    FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode4);
                                }
                            }
                        }
                        j8 >>= 8;
                    }
                    if (i23 != 8) {
                        break;
                    }
                }
                if (i22 == length3) {
                    break;
                }
                i22++;
            }
        }
        this.focusTargetNodes.clear();
        this.focusTargetsWithInvalidatedFocusEvents.clear();
        this.invalidateOwnerFocusState.invoke();
        if (!this.focusPropertiesNodes.isEmpty()) {
            InlineClassHelperKt.throwIllegalStateException("Unprocessed FocusProperties nodes");
        }
        if (!this.focusEventNodes.isEmpty()) {
            InlineClassHelperKt.throwIllegalStateException("Unprocessed FocusEvent nodes");
        }
        if (!this.focusTargetNodes.isEmpty()) {
            InlineClassHelperKt.throwIllegalStateException("Unprocessed FocusTarget nodes");
        }
    }
}
