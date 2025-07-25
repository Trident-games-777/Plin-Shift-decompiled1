package androidx.compose.ui.modifier;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002¢\u0006\u0002\b\u0007J$\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\t0\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ,\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\t0\u00062\u0006\u0010\u000e\u001a\u0002H\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/modifier/EmptyMap;", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "()V", "contains", "", "key", "Landroidx/compose/ui/modifier/ModifierLocal;", "contains$ui_release", "get", "T", "get$ui_release", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "set", "", "value", "set$ui_release", "(Landroidx/compose/ui/modifier/ModifierLocal;Ljava/lang/Object;)Ljava/lang/Void;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModifierLocalModifierNode.kt */
public final class EmptyMap extends ModifierLocalMap {
    public static final int $stable = 0;
    public static final EmptyMap INSTANCE = new EmptyMap();

    public boolean contains$ui_release(ModifierLocal<?> modifierLocal) {
        return false;
    }

    private EmptyMap() {
        super((DefaultConstructorMarker) null);
    }

    public <T> Void set$ui_release(ModifierLocal<T> modifierLocal, T t) {
        throw new IllegalStateException("".toString());
    }

    public <T> T get$ui_release(ModifierLocal<T> modifierLocal) {
        throw new IllegalStateException("".toString());
    }
}
