package com.plinkofortune.cash.winspin;

import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0005²\u0006\n\u0010\u0006\u001a\u00020\u0007X\u0002²\u0006\n\u0010\b\u001a\u00020\tX\u0002"}, d2 = {"mortal", "Landroidx/compose/ui/Modifier;", "click", "Lkotlin/Function0;", "", "app_release", "pressed", "", "scale", ""}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: Mortal.kt */
public final class MortalKt {
    public static final Modifier mortal(Modifier modifier, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(modifier, StringFog.decrypt(new byte[]{Ascii.DLE, Ascii.NAK, Byte.MAX_VALUE, 50, -122, -95}, new byte[]{44, 97, Ascii.ETB, 91, -11, -97, 59, 101}));
        Intrinsics.checkNotNullParameter(function0, StringFog.decrypt(new byte[]{Ascii.DLE, -75, 94, 35, 0}, new byte[]{115, -39, 55, SignedBytes.MAX_POWER_OF_TWO, 107, 83, -33, -32}));
        return ComposedModifierKt.composed$default(modifier, (Function1) null, new MortalKt$mortal$1(function0), 1, (Object) null);
    }
}
