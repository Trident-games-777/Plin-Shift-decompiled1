package androidx.compose.runtime;

import androidx.collection.MutableScatterMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/MutableScatterMultiMap;", "", "Landroidx/compose/runtime/KeyInfo;", "invoke-SAeQiB4", "()Landroidx/collection/MutableScatterMap;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Composer.kt */
final class Pending$keyMap$2 extends Lambda implements Function0<MutableScatterMultiMap<Object, KeyInfo>> {
    final /* synthetic */ Pending this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Pending$keyMap$2(Pending pending) {
        super(0);
        this.this$0 = pending;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return MutableScatterMultiMap.m3655boximpl(m3665invokeSAeQiB4());
    }

    /* renamed from: invoke-SAeQiB4  reason: not valid java name */
    public final MutableScatterMap<K, Object> m3665invokeSAeQiB4() {
        MutableScatterMap<K, Object> access$multiMap = ComposerKt.multiMap(this.this$0.getKeyInfos().size());
        Pending pending = this.this$0;
        int size = pending.getKeyInfos().size();
        for (int i = 0; i < size; i++) {
            KeyInfo keyInfo = pending.getKeyInfos().get(i);
            MutableScatterMultiMap.m3661putimpl(access$multiMap, ComposerKt.getJoinedKey(keyInfo), keyInfo);
        }
        return access$multiMap;
    }
}
