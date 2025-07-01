package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDefaults.kt */
final class TextFieldDefaults$sam$androidx_compose_ui_graphics_ColorProducer$0 implements ColorProducer, FunctionAdapter {
    private final /* synthetic */ Function0 function;

    TextFieldDefaults$sam$androidx_compose_ui_graphics_ColorProducer$0(Function0 function0) {
        this.function = function0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ColorProducer) || !(obj instanceof FunctionAdapter)) {
            return false;
        }
        return Intrinsics.areEqual((Object) getFunctionDelegate(), (Object) ((FunctionAdapter) obj).getFunctionDelegate());
    }

    public final Function<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    /* renamed from: invoke-0d7_KjU  reason: not valid java name */
    public final /* synthetic */ long m2685invoke0d7_KjU() {
        return ((Color) this.function.invoke()).m4249unboximpl();
    }
}
