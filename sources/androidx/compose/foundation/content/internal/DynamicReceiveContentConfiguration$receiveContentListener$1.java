package androidx.compose.foundation.content.internal;

import androidx.compose.foundation.content.ReceiveContentListener;
import androidx.compose.foundation.content.TransferableContent;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"androidx/compose/foundation/content/internal/DynamicReceiveContentConfiguration$receiveContentListener$1", "Landroidx/compose/foundation/content/ReceiveContentListener;", "nodeEnterCount", "", "onDragEnd", "", "onDragEnter", "onDragExit", "onDragStart", "onReceive", "Landroidx/compose/foundation/content/TransferableContent;", "transferableContent", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ReceiveContentConfiguration.kt */
public final class DynamicReceiveContentConfiguration$receiveContentListener$1 implements ReceiveContentListener {
    private int nodeEnterCount;
    final /* synthetic */ DynamicReceiveContentConfiguration this$0;

    DynamicReceiveContentConfiguration$receiveContentListener$1(DynamicReceiveContentConfiguration dynamicReceiveContentConfiguration) {
        this.this$0 = dynamicReceiveContentConfiguration;
    }

    public void onDragStart() {
        this.nodeEnterCount = 0;
        this.this$0.getReceiveContentNode().getReceiveContentListener().onDragStart();
    }

    public void onDragEnd() {
        this.this$0.getReceiveContentNode().getReceiveContentListener().onDragEnd();
        this.nodeEnterCount = 0;
    }

    public void onDragEnter() {
        int i = this.nodeEnterCount + 1;
        this.nodeEnterCount = i;
        if (i == 1) {
            this.this$0.getReceiveContentNode().getReceiveContentListener().onDragEnter();
        }
        ReceiveContentListener access$getParentReceiveContentListener = this.this$0.getParentReceiveContentListener();
        if (access$getParentReceiveContentListener != null) {
            access$getParentReceiveContentListener.onDragEnter();
        }
    }

    public void onDragExit() {
        int i = this.nodeEnterCount;
        int coerceAtLeast = RangesKt.coerceAtLeast(i - 1, 0);
        this.nodeEnterCount = coerceAtLeast;
        if (coerceAtLeast == 0 && i > 0) {
            this.this$0.getReceiveContentNode().getReceiveContentListener().onDragExit();
        }
        ReceiveContentListener access$getParentReceiveContentListener = this.this$0.getParentReceiveContentListener();
        if (access$getParentReceiveContentListener != null) {
            access$getParentReceiveContentListener.onDragExit();
        }
    }

    public TransferableContent onReceive(TransferableContent transferableContent) {
        TransferableContent onReceive = this.this$0.getReceiveContentNode().getReceiveContentListener().onReceive(transferableContent);
        if (onReceive == null) {
            return null;
        }
        ReceiveContentListener access$getParentReceiveContentListener = this.this$0.getParentReceiveContentListener();
        if (access$getParentReceiveContentListener == null) {
            return onReceive;
        }
        return access$getParentReceiveContentListener.onReceive(onReceive);
    }
}
