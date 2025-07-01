package androidx.compose.ui.viewinterop;

import android.graphics.Rect;
import android.view.FocusFinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTransactionManager;
import androidx.compose.ui.focus.FocusTransactionsKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0019J\u001c\u0010\u001c\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0007H\u0016J\u0010\u0010!\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0007H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"Landroidx/compose/ui/viewinterop/FocusGroupPropertiesNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "Landroid/view/View$OnAttachStateChangeListener;", "()V", "focusedChild", "Landroid/view/View;", "getFocusedChild", "()Landroid/view/View;", "setFocusedChild", "(Landroid/view/View;)V", "applyFocusProperties", "", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "getFocusTargetOfEmbeddedViewWrapper", "Landroidx/compose/ui/focus/FocusTargetNode;", "onAttach", "onDetach", "onEnter", "Landroidx/compose/ui/focus/FocusRequester;", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "onEnter-3ESFkO8", "(I)Landroidx/compose/ui/focus/FocusRequester;", "onExit", "onExit-3ESFkO8", "onGlobalFocusChanged", "oldFocus", "newFocus", "onViewAttachedToWindow", "v", "onViewDetachedFromWindow", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusGroupNode.android.kt */
final class FocusGroupPropertiesNode extends Modifier.Node implements FocusPropertiesModifierNode, ViewTreeObserver.OnGlobalFocusChangeListener, View.OnAttachStateChangeListener {
    private View focusedChild;

    public final View getFocusedChild() {
        return this.focusedChild;
    }

    public final void setFocusedChild(View view) {
        this.focusedChild = view;
    }

    public void applyFocusProperties(FocusProperties focusProperties) {
        focusProperties.setCanFocus(false);
        focusProperties.setEnter(new FocusGroupPropertiesNode$applyFocusProperties$1(this));
        focusProperties.setExit(new FocusGroupPropertiesNode$applyFocusProperties$2(this));
    }

    /* renamed from: onEnter-3ESFkO8  reason: not valid java name */
    public final FocusRequester m7364onEnter3ESFkO8(int i) {
        View access$getView = FocusGroupNode_androidKt.getView(this);
        if (access$getView.isFocused() || access$getView.hasFocus()) {
            return FocusRequester.Companion.getDefault();
        }
        DelegatableNode delegatableNode = this;
        FocusOwner focusOwner = DelegatableNodeKt.requireOwner(delegatableNode).getFocusOwner();
        Owner requireOwner = DelegatableNodeKt.requireOwner(delegatableNode);
        Intrinsics.checkNotNull(requireOwner, "null cannot be cast to non-null type android.view.View");
        return FocusInteropUtils_androidKt.requestInteropFocus(access$getView, FocusInteropUtils_androidKt.m3906toAndroidFocusDirection3ESFkO8(i), FocusGroupNode_androidKt.getCurrentlyFocusedRect(focusOwner, (View) requireOwner, access$getView)) ? FocusRequester.Companion.getDefault() : FocusRequester.Companion.getCancel();
    }

    /* renamed from: onExit-3ESFkO8  reason: not valid java name */
    public final FocusRequester m7365onExit3ESFkO8(int i) {
        View view;
        View access$getView = FocusGroupNode_androidKt.getView(this);
        if (!access$getView.hasFocus()) {
            return FocusRequester.Companion.getDefault();
        }
        DelegatableNode delegatableNode = this;
        FocusOwner focusOwner = DelegatableNodeKt.requireOwner(delegatableNode).getFocusOwner();
        Owner requireOwner = DelegatableNodeKt.requireOwner(delegatableNode);
        Intrinsics.checkNotNull(requireOwner, "null cannot be cast to non-null type android.view.View");
        View view2 = (View) requireOwner;
        if (access$getView instanceof ViewGroup) {
            Rect access$getCurrentlyFocusedRect = FocusGroupNode_androidKt.getCurrentlyFocusedRect(focusOwner, view2, access$getView);
            Integer r8 = FocusInteropUtils_androidKt.m3906toAndroidFocusDirection3ESFkO8(i);
            int intValue = r8 != null ? r8.intValue() : 130;
            FocusFinder instance = FocusFinder.getInstance();
            View view3 = this.focusedChild;
            if (view3 != null) {
                view = instance.findNextFocus((ViewGroup) view2, view3, intValue);
            } else {
                view = instance.findNextFocusFromRect((ViewGroup) view2, access$getCurrentlyFocusedRect, intValue);
            }
            if (view != null && FocusGroupNode_androidKt.containsDescendant(access$getView, view)) {
                view.requestFocus(intValue, access$getCurrentlyFocusedRect);
                return FocusRequester.Companion.getCancel();
            } else if (view2.requestFocus()) {
                return FocusRequester.Companion.getDefault();
            } else {
                throw new IllegalStateException("host view did not take focus".toString());
            }
        } else if (view2.requestFocus()) {
            return FocusRequester.Companion.getDefault();
        } else {
            throw new IllegalStateException("host view did not take focus".toString());
        }
    }

    private final FocusTargetNode getFocusTargetOfEmbeddedViewWrapper() {
        DelegatableNode delegatableNode = this;
        int r1 = NodeKind.m6139constructorimpl(1024);
        if (!delegatableNode.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        if ((node.getAggregateChildKindSet$ui_release() & r1) != 0) {
            boolean z = false;
            for (Modifier.Node child$ui_release = node.getChild$ui_release(); child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                if ((child$ui_release.getKindSet$ui_release() & r1) != 0) {
                    Modifier.Node node2 = child$ui_release;
                    MutableVector mutableVector = null;
                    while (node2 != null) {
                        if (node2 instanceof FocusTargetNode) {
                            FocusTargetNode focusTargetNode = (FocusTargetNode) node2;
                            if (z) {
                                return focusTargetNode;
                            }
                            z = true;
                        } else if ((node2.getKindSet$ui_release() & r1) != 0 && (node2 instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node delegate$ui_release = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                if ((delegate$ui_release.getKindSet$ui_release() & r1) != 0) {
                                    i++;
                                    if (i == 1) {
                                        node2 = delegate$ui_release;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (node2 != null) {
                                            if (mutableVector != null) {
                                                mutableVector.add(node2);
                                            }
                                            node2 = null;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate$ui_release);
                                        }
                                    }
                                }
                            }
                            if (i == 1) {
                            }
                        }
                        node2 = DelegatableNodeKt.pop(mutableVector);
                    }
                    continue;
                }
            }
        }
        throw new IllegalStateException("Could not find focus target of embedded view wrapper".toString());
    }

    public void onGlobalFocusChanged(View view, View view2) {
        DelegatableNode delegatableNode = this;
        if (DelegatableNodeKt.requireLayoutNode(delegatableNode).getOwner$ui_release() != null) {
            View access$getView = FocusGroupNode_androidKt.getView(this);
            FocusOwner focusOwner = DelegatableNodeKt.requireOwner(delegatableNode).getFocusOwner();
            Owner requireOwner = DelegatableNodeKt.requireOwner(delegatableNode);
            boolean z = view != null && !Intrinsics.areEqual((Object) view, (Object) requireOwner) && FocusGroupNode_androidKt.containsDescendant(access$getView, view);
            boolean z2 = view2 != null && !Intrinsics.areEqual((Object) view2, (Object) requireOwner) && FocusGroupNode_androidKt.containsDescendant(access$getView, view2);
            if (z && z2) {
                this.focusedChild = view2;
            } else if (z2) {
                this.focusedChild = view2;
                FocusTargetNode focusTargetOfEmbeddedViewWrapper = getFocusTargetOfEmbeddedViewWrapper();
                if (!focusTargetOfEmbeddedViewWrapper.getFocusState().getHasFocus()) {
                    FocusTransactionManager focusTransactionManager = focusOwner.getFocusTransactionManager();
                    try {
                        if (focusTransactionManager.ongoingTransaction) {
                            focusTransactionManager.cancelTransaction();
                        }
                        focusTransactionManager.beginTransaction();
                        FocusTransactionsKt.performRequestFocus(focusTargetOfEmbeddedViewWrapper);
                    } finally {
                        focusTransactionManager.commitTransaction();
                    }
                }
            } else if (z) {
                this.focusedChild = null;
                if (getFocusTargetOfEmbeddedViewWrapper().getFocusState().isFocused()) {
                    focusOwner.m3909clearFocusI7lrPNg(false, true, false, FocusDirection.Companion.m3900getExitdhqQ8s());
                }
            } else {
                this.focusedChild = null;
            }
        }
    }

    public void onAttach() {
        super.onAttach();
        FocusGroupNode_androidKt.getView(this).addOnAttachStateChangeListener(this);
    }

    public void onDetach() {
        FocusGroupNode_androidKt.getView(this).removeOnAttachStateChangeListener(this);
        this.focusedChild = null;
        super.onDetach();
    }

    public void onViewAttachedToWindow(View view) {
        view.getViewTreeObserver().addOnGlobalFocusChangeListener(this);
    }

    public void onViewDetachedFromWindow(View view) {
        view.getViewTreeObserver().removeOnGlobalFocusChangeListener(this);
    }
}
