package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "value", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Recomposer.kt */
final class Recomposer$writeObserverOf$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ ControlledComposition $composition;
    final /* synthetic */ MutableScatterSet<Object> $modifiedValues;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Recomposer$writeObserverOf$1(ControlledComposition controlledComposition, MutableScatterSet<Object> mutableScatterSet) {
        super(1);
        this.$composition = controlledComposition;
        this.$modifiedValues = mutableScatterSet;
    }

    public final void invoke(Object obj) {
        this.$composition.recordWriteOf(obj);
        MutableScatterSet<Object> mutableScatterSet = this.$modifiedValues;
        if (mutableScatterSet != null) {
            mutableScatterSet.add(obj);
        }
    }
}
