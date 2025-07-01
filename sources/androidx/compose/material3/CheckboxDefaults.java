package androidx.compose.material3;

import androidx.compose.material3.tokens.CheckboxTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\b\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\tJN\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058@X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"Landroidx/compose/material3/CheckboxDefaults;", "", "()V", "defaultCheckboxColors", "Landroidx/compose/material3/CheckboxColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultCheckboxColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/CheckboxColors;", "colors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/CheckboxColors;", "checkedColor", "Landroidx/compose/ui/graphics/Color;", "uncheckedColor", "checkmarkColor", "disabledCheckedColor", "disabledUncheckedColor", "disabledIndeterminateColor", "colors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/CheckboxColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Checkbox.kt */
public final class CheckboxDefaults {
    public static final int $stable = 0;
    public static final CheckboxDefaults INSTANCE = new CheckboxDefaults();

    private CheckboxDefaults() {
    }

    public final CheckboxColors colors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -9530498, "C(colors)193@8111L11:Checkbox.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-9530498, i, -1, "androidx.compose.material3.CheckboxDefaults.colors (Checkbox.kt:193)");
        }
        CheckboxColors defaultCheckboxColors$material3_release = getDefaultCheckboxColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultCheckboxColors$material3_release;
    }

    /* renamed from: colors-5tl4gsc  reason: not valid java name */
    public final CheckboxColors m1802colors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        ComposerKt.sourceInformationMarkerStart(composer2, -89536160, "C(colors)P(0:c#ui.graphics.Color,5:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.graphics.Color,3:c#ui.graphics.Color)219@9500L11:Checkbox.kt#uh7d8r");
        long r10 = (i2 & 1) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j;
        long r22 = (i2 & 2) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j2;
        long r6 = (i2 & 4) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j3;
        long r14 = (i2 & 8) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j4;
        long r26 = (i2 & 16) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j5;
        long r18 = (i2 & 32) != 0 ? Color.Companion.m4275getUnspecified0d7_KjU() : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-89536160, i, -1, "androidx.compose.material3.CheckboxDefaults.colors (Checkbox.kt:219)");
        }
        CheckboxColors r1 = getDefaultCheckboxColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m1789copy2qZNXz8(r6, Color.Companion.m4274getTransparent0d7_KjU(), r10, Color.Companion.m4274getTransparent0d7_KjU(), r14, Color.Companion.m4274getTransparent0d7_KjU(), r18, r10, r22, r14, r26, r18);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return r1;
    }

    public final CheckboxColors getDefaultCheckboxColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        CheckboxColors defaultCheckboxColorsCached$material3_release = colorScheme2.getDefaultCheckboxColorsCached$material3_release();
        if (defaultCheckboxColorsCached$material3_release != null) {
            return defaultCheckboxColorsCached$material3_release;
        }
        CheckboxColors checkboxColors = new CheckboxColors(ColorSchemeKt.fromToken(colorScheme2, CheckboxTokens.INSTANCE.getSelectedIconColor()), Color.Companion.m4274getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme2, CheckboxTokens.INSTANCE.getSelectedContainerColor()), Color.Companion.m4274getTransparent0d7_KjU(), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, CheckboxTokens.INSTANCE.getSelectedDisabledContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.Companion.m4274getTransparent0d7_KjU(), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, CheckboxTokens.INSTANCE.getSelectedDisabledContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, CheckboxTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.fromToken(colorScheme2, CheckboxTokens.INSTANCE.getUnselectedOutlineColor()), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, CheckboxTokens.INSTANCE.getSelectedDisabledContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, CheckboxTokens.INSTANCE.getUnselectedDisabledOutlineColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m4238copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, CheckboxTokens.INSTANCE.getSelectedDisabledContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        colorScheme2.setDefaultCheckboxColorsCached$material3_release(checkboxColors);
        return checkboxColors;
    }
}
