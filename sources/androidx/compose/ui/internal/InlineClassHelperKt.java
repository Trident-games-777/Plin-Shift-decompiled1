package androidx.compose.ui.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\b\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\b\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a/\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\b\u0010\u0002\u001a\u0004\u0018\u0001H\bH\b\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\n\u001a=\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\b\u0010\u0002\u001a\u0004\u0018\u0001H\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\b\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\u000b\u001a*\u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\b\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0006H\u0000¨\u0006\u0012"}, d2 = {"checkPrecondition", "", "value", "", "lazyMessage", "Lkotlin/Function0;", "", "checkPreconditionNotNull", "T", "", "(Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "requirePrecondition", "throwIllegalArgumentException", "message", "throwIllegalStateException", "throwIllegalStateExceptionForNullCheck", "", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: InlineClassHelper.kt */
public final class InlineClassHelperKt {
    public static final void throwIllegalStateException(String str) {
        throw new IllegalStateException(str);
    }

    public static final Void throwIllegalStateExceptionForNullCheck(String str) {
        throw new IllegalStateException(str);
    }

    public static final void throwIllegalArgumentException(String str) {
        throw new IllegalArgumentException(str);
    }

    public static final void checkPrecondition(boolean z, Function0<String> function0) {
        if (!z) {
            throwIllegalStateException(function0.invoke());
        }
    }

    public static final void checkPrecondition(boolean z) {
        if (!z) {
            throwIllegalStateException("Check failed.");
        }
    }

    public static final <T> T checkPreconditionNotNull(T t, Function0<String> function0) {
        if (t != null) {
            return t;
        }
        throwIllegalStateExceptionForNullCheck(function0.invoke());
        throw new KotlinNothingValueException();
    }

    public static final <T> T checkPreconditionNotNull(T t) {
        if (t != null) {
            return t;
        }
        throwIllegalStateExceptionForNullCheck("Required value was null.");
        throw new KotlinNothingValueException();
    }

    public static final void requirePrecondition(boolean z, Function0<String> function0) {
        if (!z) {
            throwIllegalArgumentException(function0.invoke());
        }
    }
}
