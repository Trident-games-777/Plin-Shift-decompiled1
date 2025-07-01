package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.content.MediaType;
import androidx.compose.ui.draganddrop.DragAndDropEvent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "dragAndDropEvent", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "invoke", "(Landroidx/compose/ui/draganddrop/DragAndDropEvent;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDragAndDropNode.android.kt */
final class TextFieldDragAndDropNode_androidKt$textFieldDragAndDropNode$1 extends Lambda implements Function1<DragAndDropEvent, Boolean> {
    final /* synthetic */ Function0<Set<MediaType>> $hintMediaTypes;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldDragAndDropNode_androidKt$textFieldDragAndDropNode$1(Function0<? extends Set<MediaType>> function0) {
        super(1);
        this.$hintMediaTypes = function0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0046 A[EDGE_INSN: B:15:0x0046->B:12:0x0046 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean invoke(androidx.compose.ui.draganddrop.DragAndDropEvent r5) {
        /*
            r4 = this;
            android.view.DragEvent r5 = androidx.compose.ui.draganddrop.DragAndDrop_androidKt.toAndroidDragEvent(r5)
            android.content.ClipDescription r5 = r5.getClipDescription()
            kotlin.jvm.functions.Function0<java.util.Set<androidx.compose.foundation.content.MediaType>> r0 = r4.$hintMediaTypes
            java.lang.Object r0 = r0.invoke()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            r2 = 0
            if (r1 == 0) goto L_0x001f
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x001f
            goto L_0x0046
        L_0x001f:
            java.util.Iterator r0 = r0.iterator()
        L_0x0023:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0046
            java.lang.Object r1 = r0.next()
            androidx.compose.foundation.content.MediaType r1 = (androidx.compose.foundation.content.MediaType) r1
            androidx.compose.foundation.content.MediaType$Companion r3 = androidx.compose.foundation.content.MediaType.Companion
            androidx.compose.foundation.content.MediaType r3 = r3.getAll()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r3 != 0) goto L_0x0045
            java.lang.String r1 = r1.getRepresentation()
            boolean r1 = r5.hasMimeType(r1)
            if (r1 == 0) goto L_0x0023
        L_0x0045:
            r2 = 1
        L_0x0046:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.TextFieldDragAndDropNode_androidKt$textFieldDragAndDropNode$1.invoke(androidx.compose.ui.draganddrop.DragAndDropEvent):java.lang.Boolean");
    }
}
