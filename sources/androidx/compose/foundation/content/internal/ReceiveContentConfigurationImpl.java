package androidx.compose.foundation.content.internal;

import androidx.compose.foundation.content.ReceiveContentListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Landroidx/compose/foundation/content/internal/ReceiveContentConfigurationImpl;", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "receiveContentListener", "Landroidx/compose/foundation/content/ReceiveContentListener;", "(Landroidx/compose/foundation/content/ReceiveContentListener;)V", "getReceiveContentListener", "()Landroidx/compose/foundation/content/ReceiveContentListener;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ReceiveContentConfiguration.kt */
final class ReceiveContentConfigurationImpl extends ReceiveContentConfiguration {
    private final ReceiveContentListener receiveContentListener;

    public static /* synthetic */ ReceiveContentConfigurationImpl copy$default(ReceiveContentConfigurationImpl receiveContentConfigurationImpl, ReceiveContentListener receiveContentListener2, int i, Object obj) {
        if ((i & 1) != 0) {
            receiveContentListener2 = receiveContentConfigurationImpl.receiveContentListener;
        }
        return receiveContentConfigurationImpl.copy(receiveContentListener2);
    }

    public final ReceiveContentListener component1() {
        return this.receiveContentListener;
    }

    public final ReceiveContentConfigurationImpl copy(ReceiveContentListener receiveContentListener2) {
        return new ReceiveContentConfigurationImpl(receiveContentListener2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ReceiveContentConfigurationImpl) && Intrinsics.areEqual((Object) this.receiveContentListener, (Object) ((ReceiveContentConfigurationImpl) obj).receiveContentListener);
    }

    public int hashCode() {
        return this.receiveContentListener.hashCode();
    }

    public String toString() {
        return "ReceiveContentConfigurationImpl(receiveContentListener=" + this.receiveContentListener + ')';
    }

    public ReceiveContentListener getReceiveContentListener() {
        return this.receiveContentListener;
    }

    public ReceiveContentConfigurationImpl(ReceiveContentListener receiveContentListener2) {
        this.receiveContentListener = receiveContentListener2;
    }
}
