package androidx.compose.foundation.text.input.internal;

import android.view.DragEvent;
import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.draganddrop.DragAndDropTarget;
import androidx.compose.ui.draganddrop.DragAndDrop_androidKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.platform.AndroidClipboardManager_androidKt;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.ClipMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\r"}, d2 = {"androidx/compose/foundation/text/input/internal/TextFieldDragAndDropNode_androidKt$textFieldDragAndDropNode$2", "Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "onChanged", "", "event", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "onDrop", "", "onEnded", "onEntered", "onExited", "onMoved", "onStarted", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDragAndDropNode.android.kt */
public final class TextFieldDragAndDropNode_androidKt$textFieldDragAndDropNode$2 implements DragAndDropTarget {
    final /* synthetic */ Function1<DragAndDropEvent, Unit> $dragAndDropRequestPermission;
    final /* synthetic */ Function1<DragAndDropEvent, Unit> $onChanged;
    final /* synthetic */ Function2<ClipEntry, ClipMetadata, Boolean> $onDrop;
    final /* synthetic */ Function1<DragAndDropEvent, Unit> $onEnded;
    final /* synthetic */ Function1<DragAndDropEvent, Unit> $onEntered;
    final /* synthetic */ Function1<DragAndDropEvent, Unit> $onExited;
    final /* synthetic */ Function1<Offset, Unit> $onMoved;
    final /* synthetic */ Function1<DragAndDropEvent, Unit> $onStarted;

    TextFieldDragAndDropNode_androidKt$textFieldDragAndDropNode$2(Function1<? super DragAndDropEvent, Unit> function1, Function2<? super ClipEntry, ? super ClipMetadata, Boolean> function2, Function1<? super DragAndDropEvent, Unit> function12, Function1<? super DragAndDropEvent, Unit> function13, Function1<? super Offset, Unit> function14, Function1<? super DragAndDropEvent, Unit> function15, Function1<? super DragAndDropEvent, Unit> function16, Function1<? super DragAndDropEvent, Unit> function17) {
        this.$dragAndDropRequestPermission = function1;
        this.$onDrop = function2;
        this.$onStarted = function12;
        this.$onEntered = function13;
        this.$onMoved = function14;
        this.$onExited = function15;
        this.$onChanged = function16;
        this.$onEnded = function17;
    }

    public boolean onDrop(DragAndDropEvent dragAndDropEvent) {
        this.$dragAndDropRequestPermission.invoke(dragAndDropEvent);
        return this.$onDrop.invoke(AndroidClipboardManager_androidKt.toClipEntry(DragAndDrop_androidKt.toAndroidDragEvent(dragAndDropEvent).getClipData()), AndroidClipboardManager_androidKt.toClipMetadata(DragAndDrop_androidKt.toAndroidDragEvent(dragAndDropEvent).getClipDescription())).booleanValue();
    }

    public void onStarted(DragAndDropEvent dragAndDropEvent) {
        Function1<DragAndDropEvent, Unit> function1 = this.$onStarted;
        if (function1 != null) {
            function1.invoke(dragAndDropEvent);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void onEntered(DragAndDropEvent dragAndDropEvent) {
        Function1<DragAndDropEvent, Unit> function1 = this.$onEntered;
        if (function1 != null) {
            function1.invoke(dragAndDropEvent);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void onMoved(DragAndDropEvent dragAndDropEvent) {
        DragEvent androidDragEvent = DragAndDrop_androidKt.toAndroidDragEvent(dragAndDropEvent);
        Function1<Offset, Unit> function1 = this.$onMoved;
        if (function1 != null) {
            function1.invoke(Offset.m3976boximpl(OffsetKt.Offset(androidDragEvent.getX(), androidDragEvent.getY())));
            Unit unit = Unit.INSTANCE;
        }
    }

    public void onExited(DragAndDropEvent dragAndDropEvent) {
        Function1<DragAndDropEvent, Unit> function1 = this.$onExited;
        if (function1 != null) {
            function1.invoke(dragAndDropEvent);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void onChanged(DragAndDropEvent dragAndDropEvent) {
        Function1<DragAndDropEvent, Unit> function1 = this.$onChanged;
        if (function1 != null) {
            function1.invoke(dragAndDropEvent);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void onEnded(DragAndDropEvent dragAndDropEvent) {
        Function1<DragAndDropEvent, Unit> function1 = this.$onEnded;
        if (function1 != null) {
            function1.invoke(dragAndDropEvent);
            Unit unit = Unit.INSTANCE;
        }
    }
}
