package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.foundation.text.input.internal.IndexTransformationType;
import androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0001¨\u0006\t"}, d2 = {"calculateAdjacentCursorPosition", "", "transformedText", "", "cursor", "forward", "", "state", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextPreparedSelection.kt */
public final class TextPreparedSelectionKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextPreparedSelection.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                androidx.compose.foundation.text.input.internal.IndexTransformationType[] r0 = androidx.compose.foundation.text.input.internal.IndexTransformationType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.foundation.text.input.internal.IndexTransformationType r1 = androidx.compose.foundation.text.input.internal.IndexTransformationType.Untransformed     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.foundation.text.input.internal.IndexTransformationType r1 = androidx.compose.foundation.text.input.internal.IndexTransformationType.Deletion     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.foundation.text.input.internal.IndexTransformationType r1 = androidx.compose.foundation.text.input.internal.IndexTransformationType.Replacement     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                androidx.compose.foundation.text.input.internal.IndexTransformationType r1 = androidx.compose.foundation.text.input.internal.IndexTransformationType.Insertion     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextPreparedSelectionKt.WhenMappings.<clinit>():void");
        }
    }

    public static final int calculateAdjacentCursorPosition(String str, int i, boolean z, TransformedTextFieldState transformedTextFieldState) {
        int i2;
        IndexTransformationType indexTransformationType;
        if (z) {
            i2 = StringHelpers_androidKt.findFollowingBreak(str, i);
        } else {
            i2 = StringHelpers_androidKt.findPrecedingBreak(str, i);
        }
        if (i2 == -1) {
            return i;
        }
        long r0 = transformedTextFieldState.m1444mapFromTransformedjx7JFs(i2);
        long r2 = transformedTextFieldState.m1447mapToTransformedGEjPoXI(r0);
        if (TextRange.m6558getCollapsedimpl(r0) && TextRange.m6558getCollapsedimpl(r2)) {
            indexTransformationType = IndexTransformationType.Untransformed;
        } else if (!TextRange.m6558getCollapsedimpl(r0) && !TextRange.m6558getCollapsedimpl(r2)) {
            indexTransformationType = IndexTransformationType.Replacement;
        } else if (!TextRange.m6558getCollapsedimpl(r0) || TextRange.m6558getCollapsedimpl(r2)) {
            indexTransformationType = IndexTransformationType.Deletion;
        } else {
            indexTransformationType = IndexTransformationType.Insertion;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[indexTransformationType.ordinal()];
        if (i3 == 1 || i3 == 2) {
            return i2;
        }
        if (i3 == 3) {
            return z ? TextRange.m6559getEndimpl(r2) : TextRange.m6564getStartimpl(r2);
        }
        if (i3 != 4) {
            throw new NoWhenBranchMatchedException();
        } else if (z) {
            if (i2 == TextRange.m6564getStartimpl(r2)) {
                transformedTextFieldState.setSelectionWedgeAffinity(new SelectionWedgeAffinity(WedgeAffinity.Start));
                return i2;
            }
            transformedTextFieldState.setSelectionWedgeAffinity(new SelectionWedgeAffinity(WedgeAffinity.End));
            return i;
        } else if (i2 == TextRange.m6559getEndimpl(r2)) {
            transformedTextFieldState.setSelectionWedgeAffinity(new SelectionWedgeAffinity(WedgeAffinity.End));
            return i2;
        } else {
            transformedTextFieldState.setSelectionWedgeAffinity(new SelectionWedgeAffinity(WedgeAffinity.Start));
            return i;
        }
    }
}
