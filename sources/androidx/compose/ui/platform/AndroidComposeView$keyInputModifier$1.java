package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.ui.focus.FocusOwnerImplKt;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTransactionsKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "invoke-ZmokQxo", "(Landroid/view/KeyEvent;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeView.android.kt */
final class AndroidComposeView$keyInputModifier$1 extends Lambda implements Function1<KeyEvent, Boolean> {
    final /* synthetic */ AndroidComposeView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidComposeView$keyInputModifier$1(AndroidComposeView androidComposeView) {
        super(1);
        this.this$0 = androidComposeView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m6245invokeZmokQxo(((KeyEvent) obj).m5419unboximpl());
    }

    /* renamed from: invoke-ZmokQxo  reason: not valid java name */
    public final Boolean m6245invokeZmokQxo(android.view.KeyEvent keyEvent) {
        final FocusDirection r0 = this.this$0.m6235getFocusDirectionP8AzH3I(keyEvent);
        if (r0 == null || !KeyEventType.m5423equalsimpl0(KeyEvent_androidKt.m5431getTypeZmokQxo(keyEvent), KeyEventType.Companion.m5427getKeyDownCS__XNY())) {
            return false;
        }
        Rect access$onFetchFocusRect = this.this$0.onFetchFocusRect();
        Boolean r3 = this.this$0.getFocusOwner().m3912focusSearchULY8qGw(r0.m3895unboximpl(), access$onFetchFocusRect, new AndroidComposeView$keyInputModifier$1$focusWasMovedOrCancelled$1(r0));
        boolean z = true;
        if (r3 != null ? r3.booleanValue() : true) {
            return true;
        }
        if (!FocusOwnerImplKt.m3925is1dFocusSearch3ESFkO8(r0.m3895unboximpl())) {
            return false;
        }
        Integer r2 = FocusInteropUtils_androidKt.m3906toAndroidFocusDirection3ESFkO8(r0.m3895unboximpl());
        if (r2 != null) {
            int intValue = r2.intValue();
            android.graphics.Rect androidRect = access$onFetchFocusRect != null ? RectHelper_androidKt.toAndroidRect(access$onFetchFocusRect) : null;
            if (androidRect != null) {
                View access$findNextNonChildView = this.this$0.findNextNonChildView(intValue);
                if (Intrinsics.areEqual((Object) access$findNextNonChildView, (Object) this.this$0)) {
                    access$findNextNonChildView = null;
                }
                if (access$findNextNonChildView != null && FocusInteropUtils_androidKt.requestInteropFocus(access$findNextNonChildView, Integer.valueOf(intValue), androidRect)) {
                    return true;
                }
                if (!this.this$0.getFocusOwner().m3909clearFocusI7lrPNg(false, true, false, r0.m3895unboximpl())) {
                    return true;
                }
                Boolean r8 = this.this$0.getFocusOwner().m3912focusSearchULY8qGw(r0.m3895unboximpl(), (Rect) null, new Function1<FocusTargetNode, Boolean>() {
                    public final Boolean invoke(FocusTargetNode focusTargetNode) {
                        Boolean r2 = FocusTransactionsKt.m3938requestFocusMxy_nc0(focusTargetNode, r0.m3895unboximpl());
                        return Boolean.valueOf(r2 != null ? r2.booleanValue() : true);
                    }
                });
                if (r8 != null) {
                    z = r8.booleanValue();
                }
                return Boolean.valueOf(z);
            }
            throw new IllegalStateException("Invalid rect".toString());
        }
        throw new IllegalStateException("Invalid focus direction".toString());
    }
}
