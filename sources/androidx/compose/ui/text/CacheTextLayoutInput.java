package androidx.compose.ui.text;

import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Landroidx/compose/ui/text/CacheTextLayoutInput;", "", "textLayoutInput", "Landroidx/compose/ui/text/TextLayoutInput;", "(Landroidx/compose/ui/text/TextLayoutInput;)V", "getTextLayoutInput", "()Landroidx/compose/ui/text/TextLayoutInput;", "equals", "", "other", "hashCode", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextMeasurer.kt */
public final class CacheTextLayoutInput {
    public static final int $stable = 0;
    private final TextLayoutInput textLayoutInput;

    public CacheTextLayoutInput(TextLayoutInput textLayoutInput2) {
        this.textLayoutInput = textLayoutInput2;
    }

    public final TextLayoutInput getTextLayoutInput() {
        return this.textLayoutInput;
    }

    public int hashCode() {
        TextLayoutInput textLayoutInput2 = this.textLayoutInput;
        return (((((((((((((((((((textLayoutInput2.getText().hashCode() * 31) + textLayoutInput2.getStyle().hashCodeLayoutAffectingAttributes$ui_text_release()) * 31) + textLayoutInput2.getPlaceholders().hashCode()) * 31) + textLayoutInput2.getMaxLines()) * 31) + Boolean.hashCode(textLayoutInput2.getSoftWrap())) * 31) + TextOverflow.m7031hashCodeimpl(textLayoutInput2.m6533getOverflowgIe3tQ8())) * 31) + textLayoutInput2.getDensity().hashCode()) * 31) + textLayoutInput2.getLayoutDirection().hashCode()) * 31) + textLayoutInput2.getFontFamilyResolver().hashCode()) * 31) + Integer.hashCode(Constraints.m7052getMaxWidthimpl(textLayoutInput2.m6532getConstraintsmsEJaDk()))) * 31) + Integer.hashCode(Constraints.m7051getMaxHeightimpl(textLayoutInput2.m6532getConstraintsmsEJaDk()));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CacheTextLayoutInput)) {
            return false;
        }
        TextLayoutInput textLayoutInput2 = this.textLayoutInput;
        CacheTextLayoutInput cacheTextLayoutInput = (CacheTextLayoutInput) obj;
        return Intrinsics.areEqual((Object) textLayoutInput2.getText(), (Object) cacheTextLayoutInput.textLayoutInput.getText()) && textLayoutInput2.getStyle().hasSameLayoutAffectingAttributes(cacheTextLayoutInput.textLayoutInput.getStyle()) && Intrinsics.areEqual((Object) textLayoutInput2.getPlaceholders(), (Object) cacheTextLayoutInput.textLayoutInput.getPlaceholders()) && textLayoutInput2.getMaxLines() == cacheTextLayoutInput.textLayoutInput.getMaxLines() && textLayoutInput2.getSoftWrap() == cacheTextLayoutInput.textLayoutInput.getSoftWrap() && TextOverflow.m7030equalsimpl0(textLayoutInput2.m6533getOverflowgIe3tQ8(), cacheTextLayoutInput.textLayoutInput.m6533getOverflowgIe3tQ8()) && Intrinsics.areEqual((Object) textLayoutInput2.getDensity(), (Object) cacheTextLayoutInput.textLayoutInput.getDensity()) && textLayoutInput2.getLayoutDirection() == cacheTextLayoutInput.textLayoutInput.getLayoutDirection() && textLayoutInput2.getFontFamilyResolver() == cacheTextLayoutInput.textLayoutInput.getFontFamilyResolver() && Constraints.m7052getMaxWidthimpl(textLayoutInput2.m6532getConstraintsmsEJaDk()) == Constraints.m7052getMaxWidthimpl(cacheTextLayoutInput.textLayoutInput.m6532getConstraintsmsEJaDk()) && Constraints.m7051getMaxHeightimpl(textLayoutInput2.m6532getConstraintsmsEJaDk()) == Constraints.m7051getMaxHeightimpl(cacheTextLayoutInput.textLayoutInput.m6532getConstraintsmsEJaDk());
    }
}
