package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a^\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042<\u0010\u0005\u001a8\u0012\u0004\u0012\u00020\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00010\u0006H\b¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"getIndexTransformationType", "R", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "transformedQueryIndex", "", "onResult", "Lkotlin/Function3;", "Landroidx/compose/foundation/text/input/internal/IndexTransformationType;", "Landroidx/compose/ui/text/TextRange;", "Lkotlin/ParameterName;", "name", "untransformed", "retransformed", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;ILkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TransformedTextFieldState.kt */
public final class TransformedTextFieldStateKt {
    public static final <R> R getIndexTransformationType(TransformedTextFieldState transformedTextFieldState, int i, Function3<? super IndexTransformationType, ? super TextRange, ? super TextRange, ? extends R> function3) {
        IndexTransformationType indexTransformationType;
        long r0 = transformedTextFieldState.m1444mapFromTransformedjx7JFs(i);
        long r3 = transformedTextFieldState.m1447mapToTransformedGEjPoXI(r0);
        if (TextRange.m6558getCollapsedimpl(r0) && TextRange.m6558getCollapsedimpl(r3)) {
            indexTransformationType = IndexTransformationType.Untransformed;
        } else if (!TextRange.m6558getCollapsedimpl(r0) && !TextRange.m6558getCollapsedimpl(r3)) {
            indexTransformationType = IndexTransformationType.Replacement;
        } else if (!TextRange.m6558getCollapsedimpl(r0) || TextRange.m6558getCollapsedimpl(r3)) {
            indexTransformationType = IndexTransformationType.Deletion;
        } else {
            indexTransformationType = IndexTransformationType.Insertion;
        }
        return function3.invoke(indexTransformationType, TextRange.m6552boximpl(r0), TextRange.m6552boximpl(r3));
    }
}
