package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"androidx/compose/ui/platform/AndroidComposeView$addAndroidView$1", "Landroidx/core/view/AccessibilityDelegateCompat;", "onInitializeAccessibilityNodeInfo", "", "host", "Landroid/view/View;", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeView.android.kt */
public final class AndroidComposeView$addAndroidView$1 extends AccessibilityDelegateCompat {
    final /* synthetic */ LayoutNode $layoutNode;
    final /* synthetic */ AndroidComposeView $thisView;
    final /* synthetic */ AndroidComposeView this$0;

    AndroidComposeView$addAndroidView$1(AndroidComposeView androidComposeView, LayoutNode layoutNode, AndroidComposeView androidComposeView2) {
        this.this$0 = androidComposeView;
        this.$layoutNode = layoutNode;
        this.$thisView = androidComposeView2;
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        if (this.this$0.composeAccessibilityDelegate.isEnabled$ui_release()) {
            accessibilityNodeInfoCompat.setVisibleToUser(false);
        }
        LayoutNode findClosestParentNode = SemanticsNodeKt.findClosestParentNode(this.$layoutNode, AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1.INSTANCE);
        Integer valueOf = findClosestParentNode != null ? Integer.valueOf(findClosestParentNode.getSemanticsId()) : null;
        if (valueOf == null || valueOf.intValue() == this.this$0.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
            valueOf = -1;
        }
        accessibilityNodeInfoCompat.setParent(this.$thisView, valueOf.intValue());
        int semanticsId = this.$layoutNode.getSemanticsId();
        int orDefault = this.this$0.composeAccessibilityDelegate.getIdToBeforeMap$ui_release().getOrDefault(semanticsId, -1);
        if (orDefault != -1) {
            View semanticsIdToView = SemanticsUtils_androidKt.semanticsIdToView(this.this$0.getAndroidViewsHandler$ui_release(), orDefault);
            if (semanticsIdToView != null) {
                accessibilityNodeInfoCompat.setTraversalBefore(semanticsIdToView);
            } else {
                accessibilityNodeInfoCompat.setTraversalBefore(this.$thisView, orDefault);
            }
            this.this$0.addExtraDataToAccessibilityNodeInfoHelper(semanticsId, accessibilityNodeInfoCompat.unwrap(), this.this$0.composeAccessibilityDelegate.getExtraDataTestTraversalBeforeVal$ui_release());
        }
        int orDefault2 = this.this$0.composeAccessibilityDelegate.getIdToAfterMap$ui_release().getOrDefault(semanticsId, -1);
        if (orDefault2 != -1) {
            View semanticsIdToView2 = SemanticsUtils_androidKt.semanticsIdToView(this.this$0.getAndroidViewsHandler$ui_release(), orDefault2);
            if (semanticsIdToView2 != null) {
                accessibilityNodeInfoCompat.setTraversalAfter(semanticsIdToView2);
            } else {
                accessibilityNodeInfoCompat.setTraversalAfter(this.$thisView, orDefault2);
            }
            this.this$0.addExtraDataToAccessibilityNodeInfoHelper(semanticsId, accessibilityNodeInfoCompat.unwrap(), this.this$0.composeAccessibilityDelegate.getExtraDataTestTraversalAfterVal$ui_release());
        }
    }
}
