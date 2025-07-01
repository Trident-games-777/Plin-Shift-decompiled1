package com.plinkofortune.cash.winspin.nav;

import androidx.datastore.preferences.core.MutablePreferences;
import com.google.common.base.Ascii;
import com.plinkofortune.cash.winspin.StringFog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.plinkofortune.cash.winspin.nav.MrqgsKoujVcT$kPHgCRYpKti$2", f = "MrqgsKoujVcT.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: MrqgsKoujVcT.kt */
final class MrqgsKoujVcT$kPHgCRYpKti$2 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<String> $current;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MrqgsKoujVcT$kPHgCRYpKti$2(Ref.ObjectRef<String> objectRef, Continuation<? super MrqgsKoujVcT$kPHgCRYpKti$2> continuation) {
        super(2, continuation);
        this.$current = objectRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MrqgsKoujVcT$kPHgCRYpKti$2 mrqgsKoujVcT$kPHgCRYpKti$2 = new MrqgsKoujVcT$kPHgCRYpKti$2(this.$current, continuation);
        mrqgsKoujVcT$kPHgCRYpKti$2.L$0 = obj;
        return mrqgsKoujVcT$kPHgCRYpKti$2;
    }

    public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
        return ((MrqgsKoujVcT$kPHgCRYpKti$2) create(mutablePreferences, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ((MutablePreferences) this.L$0).set(MrqgsKoujVcT.gCTMhFHEGLk, this.$current.element);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException(StringFog.decrypt(new byte[]{-61, -71, -51, 72, Ascii.EM, -104, -94, 36, -121, -86, -60, 87, 76, -127, -88, 35, Byte.MIN_VALUE, -70, -60, 66, 86, -98, -88, 36, -121, -79, -49, 82, 86, -121, -88, 35, Byte.MIN_VALUE, -81, -56, 80, 81, -52, -82, 107, -46, -73, -44, 80, 80, -126, -88}, new byte[]{-96, -40, -95, 36, 57, -20, -51, 4}));
    }
}
