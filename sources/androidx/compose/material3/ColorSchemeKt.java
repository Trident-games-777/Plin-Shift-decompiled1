package androidx.compose.material3;

import androidx.compose.material3.tokens.ColorDarkTokens;
import androidx.compose.material3.tokens.ColorLightTokens;
import androidx.compose.material3.tokens.ColorSchemeKeyTokens;
import androidx.compose.material3.tokens.PaletteTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u001a\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a´\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001d\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010#\u001a\u00020\u000b2\b\b\u0002\u0010$\u001a\u00020\u000b2\b\b\u0002\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010&\u001a\u00020\u000b2\b\b\u0002\u0010'\u001a\u00020\u000b2\b\b\u0002\u0010(\u001a\u00020\u000b2\b\b\u0002\u0010)\u001a\u00020\u000b2\b\b\u0002\u0010*\u001a\u00020\u000b2\b\b\u0002\u0010+\u001a\u00020\u000b2\b\b\u0002\u0010,\u001a\u00020\u000b2\b\b\u0002\u0010-\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u00020\u000b2\b\b\u0002\u00100\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001aø\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001d\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010#\u001a\u00020\u000b2\b\b\u0002\u0010$\u001a\u00020\u000b2\b\b\u0002\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010&\u001a\u00020\u000b2\b\b\u0002\u0010'\u001a\u00020\u000b2\b\b\u0002\u0010(\u001a\u00020\u000b2\b\b\u0002\u0010)\u001a\u00020\u000b2\b\b\u0002\u0010*\u001a\u00020\u000b2\b\b\u0002\u0010+\u001a\u00020\u000b2\b\b\u0002\u0010,\u001a\u00020\u000b2\b\b\u0002\u0010-\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u00020\u000b2\b\b\u0002\u00100\u001a\u00020\u000b2\b\b\u0002\u00103\u001a\u00020\u000b2\b\b\u0002\u00104\u001a\u00020\u000b2\b\b\u0002\u00105\u001a\u00020\u000b2\b\b\u0002\u00106\u001a\u00020\u000b2\b\b\u0002\u00107\u001a\u00020\u000b2\b\b\u0002\u00108\u001a\u00020\u000b2\b\b\u0002\u00109\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\b:\u0010;\u001a\b\u0010<\u001a\u00020\u0004H\u0000\u001a´\u0002\u0010=\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001d\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010#\u001a\u00020\u000b2\b\b\u0002\u0010$\u001a\u00020\u000b2\b\b\u0002\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010&\u001a\u00020\u000b2\b\b\u0002\u0010'\u001a\u00020\u000b2\b\b\u0002\u0010(\u001a\u00020\u000b2\b\b\u0002\u0010)\u001a\u00020\u000b2\b\b\u0002\u0010*\u001a\u00020\u000b2\b\b\u0002\u0010+\u001a\u00020\u000b2\b\b\u0002\u0010,\u001a\u00020\u000b2\b\b\u0002\u0010-\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u00020\u000b2\b\b\u0002\u00100\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b>\u00102\u001aø\u0002\u0010=\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001d\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010#\u001a\u00020\u000b2\b\b\u0002\u0010$\u001a\u00020\u000b2\b\b\u0002\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010&\u001a\u00020\u000b2\b\b\u0002\u0010'\u001a\u00020\u000b2\b\b\u0002\u0010(\u001a\u00020\u000b2\b\b\u0002\u0010)\u001a\u00020\u000b2\b\b\u0002\u0010*\u001a\u00020\u000b2\b\b\u0002\u0010+\u001a\u00020\u000b2\b\b\u0002\u0010,\u001a\u00020\u000b2\b\b\u0002\u0010-\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u00020\u000b2\b\b\u0002\u00100\u001a\u00020\u000b2\b\b\u0002\u00103\u001a\u00020\u000b2\b\b\u0002\u00104\u001a\u00020\u000b2\b\b\u0002\u00105\u001a\u00020\u000b2\b\b\u0002\u00106\u001a\u00020\u000b2\b\b\u0002\u00107\u001a\u00020\u000b2\b\b\u0002\u00108\u001a\u00020\u000b2\b\b\u0002\u00109\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\b?\u0010;\u001a&\u0010@\u001a\u00020\u000b*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020BH\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001a\u001e\u0010\u000f\u001a\u00020\u000b*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001a\u0019\u0010G\u001a\u00020\u000b*\u00020\u00042\u0006\u0010\n\u001a\u00020\fH\u0001¢\u0006\u0002\u0010H\u001a\u001e\u0010I\u001a\u00020\u000b*\u00020\u00042\u0006\u0010A\u001a\u00020BH\u0007ø\u0001\u0000¢\u0006\u0004\bJ\u0010K\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0018\u0010\n\u001a\u00020\u000b*\u00020\f8AX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006L"}, d2 = {"DisabledAlpha", "", "LocalColorScheme", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/ColorScheme;", "getLocalColorScheme", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalTonalElevationEnabled", "", "getLocalTonalElevationEnabled", "value", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getValue", "(Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;Landroidx/compose/runtime/Composer;I)J", "contentColorFor", "backgroundColor", "contentColorFor-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)J", "darkColorScheme", "primary", "onPrimary", "primaryContainer", "onPrimaryContainer", "inversePrimary", "secondary", "onSecondary", "secondaryContainer", "onSecondaryContainer", "tertiary", "onTertiary", "tertiaryContainer", "onTertiaryContainer", "background", "onBackground", "surface", "onSurface", "surfaceVariant", "onSurfaceVariant", "surfaceTint", "inverseSurface", "inverseOnSurface", "error", "onError", "errorContainer", "onErrorContainer", "outline", "outlineVariant", "scrim", "darkColorScheme-G1PFc-w", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "surfaceBright", "surfaceContainer", "surfaceContainerHigh", "surfaceContainerHighest", "surfaceContainerLow", "surfaceContainerLowest", "surfaceDim", "darkColorScheme-C-Xl9yA", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "expressiveLightColorScheme", "lightColorScheme", "lightColorScheme-G1PFc-w", "lightColorScheme-C-Xl9yA", "applyTonalElevation", "elevation", "Landroidx/compose/ui/unit/Dp;", "applyTonalElevation-RFCenO8", "(Landroidx/compose/material3/ColorScheme;JFLandroidx/compose/runtime/Composer;I)J", "contentColorFor-4WTKRHQ", "(Landroidx/compose/material3/ColorScheme;J)J", "fromToken", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;)J", "surfaceColorAtElevation", "surfaceColorAtElevation-3ABfNKs", "(Landroidx/compose/material3/ColorScheme;F)J", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ColorScheme.kt */
public final class ColorSchemeKt {
    public static final float DisabledAlpha = 0.38f;
    private static final ProvidableCompositionLocal<ColorScheme> LocalColorScheme = CompositionLocalKt.staticCompositionLocalOf(ColorSchemeKt$LocalColorScheme$1.INSTANCE);
    private static final ProvidableCompositionLocal<Boolean> LocalTonalElevationEnabled = CompositionLocalKt.staticCompositionLocalOf(ColorSchemeKt$LocalTonalElevationEnabled$1.INSTANCE);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ColorScheme.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(74:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|(2:71|72)|73|75) */
        /* JADX WARNING: Can't wrap try/catch for region: R(75:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|75) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0082 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x008c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0096 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00be */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00c8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00d2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00dc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00e6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00fa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0104 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x010e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x0118 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x0122 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x012c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0136 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0140 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x014a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x0154 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x015e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                androidx.compose.material3.tokens.ColorSchemeKeyTokens[] r0 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.Background     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.Error     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.ErrorContainer     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.InverseOnSurface     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.InversePrimary     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.InverseSurface     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.OnBackground     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.OnError     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.OnErrorContainer     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.OnPrimary     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.OnPrimaryContainer     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.OnSecondary     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.OnSecondaryContainer     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.OnSurface     // Catch:{ NoSuchFieldError -> 0x008c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008c }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008c }
            L_0x008c:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.OnSurfaceVariant     // Catch:{ NoSuchFieldError -> 0x0096 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0096 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0096 }
            L_0x0096:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.SurfaceTint     // Catch:{ NoSuchFieldError -> 0x00a0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a0 }
            L_0x00a0:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.OnTertiary     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.OnTertiaryContainer     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.Outline     // Catch:{ NoSuchFieldError -> 0x00be }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00be }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00be }
            L_0x00be:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.OutlineVariant     // Catch:{ NoSuchFieldError -> 0x00c8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c8 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c8 }
            L_0x00c8:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.Primary     // Catch:{ NoSuchFieldError -> 0x00d2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d2 }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d2 }
            L_0x00d2:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.PrimaryContainer     // Catch:{ NoSuchFieldError -> 0x00dc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00dc }
                r2 = 22
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00dc }
            L_0x00dc:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.Scrim     // Catch:{ NoSuchFieldError -> 0x00e6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e6 }
                r2 = 23
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e6 }
            L_0x00e6:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.Secondary     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 24
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.SecondaryContainer     // Catch:{ NoSuchFieldError -> 0x00fa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fa }
                r2 = 25
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fa }
            L_0x00fa:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.Surface     // Catch:{ NoSuchFieldError -> 0x0104 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0104 }
                r2 = 26
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0104 }
            L_0x0104:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.SurfaceVariant     // Catch:{ NoSuchFieldError -> 0x010e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x010e }
                r2 = 27
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x010e }
            L_0x010e:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.SurfaceBright     // Catch:{ NoSuchFieldError -> 0x0118 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0118 }
                r2 = 28
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0118 }
            L_0x0118:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.SurfaceContainer     // Catch:{ NoSuchFieldError -> 0x0122 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0122 }
                r2 = 29
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0122 }
            L_0x0122:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.SurfaceContainerHigh     // Catch:{ NoSuchFieldError -> 0x012c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x012c }
                r2 = 30
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x012c }
            L_0x012c:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.SurfaceContainerHighest     // Catch:{ NoSuchFieldError -> 0x0136 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0136 }
                r2 = 31
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0136 }
            L_0x0136:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.SurfaceContainerLow     // Catch:{ NoSuchFieldError -> 0x0140 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0140 }
                r2 = 32
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0140 }
            L_0x0140:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.SurfaceContainerLowest     // Catch:{ NoSuchFieldError -> 0x014a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x014a }
                r2 = 33
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x014a }
            L_0x014a:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.SurfaceDim     // Catch:{ NoSuchFieldError -> 0x0154 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0154 }
                r2 = 34
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0154 }
            L_0x0154:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.Tertiary     // Catch:{ NoSuchFieldError -> 0x015e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x015e }
                r2 = 35
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x015e }
            L_0x015e:
                androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = androidx.compose.material3.tokens.ColorSchemeKeyTokens.TertiaryContainer     // Catch:{ NoSuchFieldError -> 0x0168 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0168 }
                r2 = 36
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0168 }
            L_0x0168:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ColorSchemeKt.WhenMappings.<clinit>():void");
        }
    }

    /* renamed from: lightColorScheme-C-Xl9yA$default  reason: not valid java name */
    public static /* synthetic */ ColorScheme m1892lightColorSchemeCXl9yA$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, int i, int i2, Object obj) {
        int i3 = i;
        long r1 = (i3 & 1) != 0 ? ColorLightTokens.INSTANCE.m3133getPrimary0d7_KjU() : j;
        long r3 = (i3 & 2) != 0 ? ColorLightTokens.INSTANCE.m3117getOnPrimary0d7_KjU() : j2;
        long r5 = (i3 & 4) != 0 ? ColorLightTokens.INSTANCE.m3134getPrimaryContainer0d7_KjU() : j3;
        long r7 = (i3 & 8) != 0 ? ColorLightTokens.INSTANCE.m3118getOnPrimaryContainer0d7_KjU() : j4;
        long r9 = (i3 & 16) != 0 ? ColorLightTokens.INSTANCE.m3112getInversePrimary0d7_KjU() : j5;
        long r11 = (i3 & 32) != 0 ? ColorLightTokens.INSTANCE.m3138getSecondary0d7_KjU() : j6;
        long r13 = (i3 & 64) != 0 ? ColorLightTokens.INSTANCE.m3121getOnSecondary0d7_KjU() : j7;
        long r15 = (i3 & 128) != 0 ? ColorLightTokens.INSTANCE.m3139getSecondaryContainer0d7_KjU() : j8;
        long j37 = r1;
        long r75 = (i3 & 256) != 0 ? ColorLightTokens.INSTANCE.m3122getOnSecondaryContainer0d7_KjU() : j9;
        long r77 = (i3 & 512) != 0 ? ColorLightTokens.INSTANCE.m3152getTertiary0d7_KjU() : j10;
        long r79 = (i3 & 1024) != 0 ? ColorLightTokens.INSTANCE.m3127getOnTertiary0d7_KjU() : j11;
        long r81 = (i3 & 2048) != 0 ? ColorLightTokens.INSTANCE.m3153getTertiaryContainer0d7_KjU() : j12;
        long r83 = (i3 & 4096) != 0 ? ColorLightTokens.INSTANCE.m3128getOnTertiaryContainer0d7_KjU() : j13;
        long r85 = (i3 & 8192) != 0 ? ColorLightTokens.INSTANCE.m3108getBackground0d7_KjU() : j14;
        long r12 = (i3 & 16384) != 0 ? ColorLightTokens.INSTANCE.m3114getOnBackground0d7_KjU() : j15;
        long r17 = (i3 & 32768) != 0 ? ColorLightTokens.INSTANCE.m3142getSurface0d7_KjU() : j16;
        long r19 = (i3 & 65536) != 0 ? ColorLightTokens.INSTANCE.m3125getOnSurface0d7_KjU() : j17;
        long r21 = (i3 & 131072) != 0 ? ColorLightTokens.INSTANCE.m3151getSurfaceVariant0d7_KjU() : j18;
        long r23 = (i3 & 262144) != 0 ? ColorLightTokens.INSTANCE.m3126getOnSurfaceVariant0d7_KjU() : j19;
        long j38 = (i3 & 524288) != 0 ? j37 : j20;
        long r27 = (i3 & 1048576) != 0 ? ColorLightTokens.INSTANCE.m3113getInverseSurface0d7_KjU() : j21;
        long r29 = (i3 & 2097152) != 0 ? ColorLightTokens.INSTANCE.m3111getInverseOnSurface0d7_KjU() : j22;
        long r31 = (i3 & 4194304) != 0 ? ColorLightTokens.INSTANCE.m3109getError0d7_KjU() : j23;
        long r33 = (i3 & 8388608) != 0 ? ColorLightTokens.INSTANCE.m3115getOnError0d7_KjU() : j24;
        long r35 = (i3 & 16777216) != 0 ? ColorLightTokens.INSTANCE.m3110getErrorContainer0d7_KjU() : j25;
        long r37 = (i3 & 33554432) != 0 ? ColorLightTokens.INSTANCE.m3116getOnErrorContainer0d7_KjU() : j26;
        long r39 = (i3 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? ColorLightTokens.INSTANCE.m3131getOutline0d7_KjU() : j27;
        long r41 = (i3 & 134217728) != 0 ? ColorLightTokens.INSTANCE.m3132getOutlineVariant0d7_KjU() : j28;
        long r43 = (i3 & 268435456) != 0 ? ColorLightTokens.INSTANCE.m3137getScrim0d7_KjU() : j29;
        long r45 = (i3 & 536870912) != 0 ? ColorLightTokens.INSTANCE.m3143getSurfaceBright0d7_KjU() : j30;
        long r47 = (i3 & 1073741824) != 0 ? ColorLightTokens.INSTANCE.m3144getSurfaceContainer0d7_KjU() : j31;
        long r49 = (i3 & Integer.MIN_VALUE) != 0 ? ColorLightTokens.INSTANCE.m3145getSurfaceContainerHigh0d7_KjU() : j32;
        long r51 = (i2 & 1) != 0 ? ColorLightTokens.INSTANCE.m3146getSurfaceContainerHighest0d7_KjU() : j33;
        long r53 = (i2 & 2) != 0 ? ColorLightTokens.INSTANCE.m3147getSurfaceContainerLow0d7_KjU() : j34;
        long r55 = (i2 & 4) != 0 ? ColorLightTokens.INSTANCE.m3148getSurfaceContainerLowest0d7_KjU() : j35;
        if ((i2 & 8) != 0) {
            j36 = ColorLightTokens.INSTANCE.m3149getSurfaceDim0d7_KjU();
        }
        return m1891lightColorSchemeCXl9yA(j37, r3, r5, r7, r9, r11, r13, r15, r75, r77, r79, r81, r83, r85, r12, r17, r19, r21, r23, j38, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, j36);
    }

    /* renamed from: lightColorScheme-C-Xl9yA  reason: not valid java name */
    public static final ColorScheme m1891lightColorSchemeCXl9yA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36) {
        return new ColorScheme(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j36, j31, j32, j33, j34, j35, (DefaultConstructorMarker) null);
    }

    /* renamed from: lightColorScheme-G1PFc-w$default  reason: not valid java name */
    public static /* synthetic */ ColorScheme m1894lightColorSchemeG1PFcw$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, int i, Object obj) {
        int i2 = i;
        long r1 = (i2 & 1) != 0 ? ColorLightTokens.INSTANCE.m3133getPrimary0d7_KjU() : j;
        long r3 = (i2 & 2) != 0 ? ColorLightTokens.INSTANCE.m3117getOnPrimary0d7_KjU() : j2;
        long r5 = (i2 & 4) != 0 ? ColorLightTokens.INSTANCE.m3134getPrimaryContainer0d7_KjU() : j3;
        long r7 = (i2 & 8) != 0 ? ColorLightTokens.INSTANCE.m3118getOnPrimaryContainer0d7_KjU() : j4;
        long r9 = (i2 & 16) != 0 ? ColorLightTokens.INSTANCE.m3112getInversePrimary0d7_KjU() : j5;
        long r11 = (i2 & 32) != 0 ? ColorLightTokens.INSTANCE.m3138getSecondary0d7_KjU() : j6;
        long r13 = (i2 & 64) != 0 ? ColorLightTokens.INSTANCE.m3121getOnSecondary0d7_KjU() : j7;
        long r15 = (i2 & 128) != 0 ? ColorLightTokens.INSTANCE.m3139getSecondaryContainer0d7_KjU() : j8;
        long j30 = r1;
        long r61 = (i2 & 256) != 0 ? ColorLightTokens.INSTANCE.m3122getOnSecondaryContainer0d7_KjU() : j9;
        long r63 = (i2 & 512) != 0 ? ColorLightTokens.INSTANCE.m3152getTertiary0d7_KjU() : j10;
        long r65 = (i2 & 1024) != 0 ? ColorLightTokens.INSTANCE.m3127getOnTertiary0d7_KjU() : j11;
        long r67 = (i2 & 2048) != 0 ? ColorLightTokens.INSTANCE.m3153getTertiaryContainer0d7_KjU() : j12;
        long r69 = (i2 & 4096) != 0 ? ColorLightTokens.INSTANCE.m3128getOnTertiaryContainer0d7_KjU() : j13;
        long r71 = (i2 & 8192) != 0 ? ColorLightTokens.INSTANCE.m3108getBackground0d7_KjU() : j14;
        long r12 = (i2 & 16384) != 0 ? ColorLightTokens.INSTANCE.m3114getOnBackground0d7_KjU() : j15;
        long r17 = (i2 & 32768) != 0 ? ColorLightTokens.INSTANCE.m3142getSurface0d7_KjU() : j16;
        long r19 = (i2 & 65536) != 0 ? ColorLightTokens.INSTANCE.m3125getOnSurface0d7_KjU() : j17;
        long r21 = (i2 & 131072) != 0 ? ColorLightTokens.INSTANCE.m3151getSurfaceVariant0d7_KjU() : j18;
        long r23 = (i2 & 262144) != 0 ? ColorLightTokens.INSTANCE.m3126getOnSurfaceVariant0d7_KjU() : j19;
        long j31 = (i2 & 524288) != 0 ? j30 : j20;
        long r27 = (i2 & 1048576) != 0 ? ColorLightTokens.INSTANCE.m3113getInverseSurface0d7_KjU() : j21;
        long r29 = (i2 & 2097152) != 0 ? ColorLightTokens.INSTANCE.m3111getInverseOnSurface0d7_KjU() : j22;
        long r31 = (i2 & 4194304) != 0 ? ColorLightTokens.INSTANCE.m3109getError0d7_KjU() : j23;
        long r33 = (i2 & 8388608) != 0 ? ColorLightTokens.INSTANCE.m3115getOnError0d7_KjU() : j24;
        long r35 = (i2 & 16777216) != 0 ? ColorLightTokens.INSTANCE.m3110getErrorContainer0d7_KjU() : j25;
        long r37 = (i2 & 33554432) != 0 ? ColorLightTokens.INSTANCE.m3116getOnErrorContainer0d7_KjU() : j26;
        long r39 = (i2 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? ColorLightTokens.INSTANCE.m3131getOutline0d7_KjU() : j27;
        long r41 = (i2 & 134217728) != 0 ? ColorLightTokens.INSTANCE.m3132getOutlineVariant0d7_KjU() : j28;
        if ((i2 & 268435456) != 0) {
            j29 = ColorLightTokens.INSTANCE.m3137getScrim0d7_KjU();
        }
        return m1892lightColorSchemeCXl9yA$default(j30, r3, r5, r7, r9, r11, r13, r15, r61, r63, r65, r67, r69, r71, r12, r17, r19, r21, r23, j31, r27, r29, r31, r33, r35, r37, r39, r41, j29, 0, 0, 0, 0, 0, 0, 0, -536870912, 15, (Object) null);
    }

    /* renamed from: darkColorScheme-C-Xl9yA$default  reason: not valid java name */
    public static /* synthetic */ ColorScheme m1888darkColorSchemeCXl9yA$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, int i, int i2, Object obj) {
        int i3 = i;
        long r1 = (i3 & 1) != 0 ? ColorDarkTokens.INSTANCE.m3085getPrimary0d7_KjU() : j;
        long r3 = (i3 & 2) != 0 ? ColorDarkTokens.INSTANCE.m3069getOnPrimary0d7_KjU() : j2;
        long r5 = (i3 & 4) != 0 ? ColorDarkTokens.INSTANCE.m3086getPrimaryContainer0d7_KjU() : j3;
        long r7 = (i3 & 8) != 0 ? ColorDarkTokens.INSTANCE.m3070getOnPrimaryContainer0d7_KjU() : j4;
        long r9 = (i3 & 16) != 0 ? ColorDarkTokens.INSTANCE.m3064getInversePrimary0d7_KjU() : j5;
        long r11 = (i3 & 32) != 0 ? ColorDarkTokens.INSTANCE.m3090getSecondary0d7_KjU() : j6;
        long r13 = (i3 & 64) != 0 ? ColorDarkTokens.INSTANCE.m3073getOnSecondary0d7_KjU() : j7;
        long r15 = (i3 & 128) != 0 ? ColorDarkTokens.INSTANCE.m3091getSecondaryContainer0d7_KjU() : j8;
        long j37 = r1;
        long r75 = (i3 & 256) != 0 ? ColorDarkTokens.INSTANCE.m3074getOnSecondaryContainer0d7_KjU() : j9;
        long r77 = (i3 & 512) != 0 ? ColorDarkTokens.INSTANCE.m3104getTertiary0d7_KjU() : j10;
        long r79 = (i3 & 1024) != 0 ? ColorDarkTokens.INSTANCE.m3079getOnTertiary0d7_KjU() : j11;
        long r81 = (i3 & 2048) != 0 ? ColorDarkTokens.INSTANCE.m3105getTertiaryContainer0d7_KjU() : j12;
        long r83 = (i3 & 4096) != 0 ? ColorDarkTokens.INSTANCE.m3080getOnTertiaryContainer0d7_KjU() : j13;
        long r85 = (i3 & 8192) != 0 ? ColorDarkTokens.INSTANCE.m3060getBackground0d7_KjU() : j14;
        long r12 = (i3 & 16384) != 0 ? ColorDarkTokens.INSTANCE.m3066getOnBackground0d7_KjU() : j15;
        long r17 = (i3 & 32768) != 0 ? ColorDarkTokens.INSTANCE.m3094getSurface0d7_KjU() : j16;
        long r19 = (i3 & 65536) != 0 ? ColorDarkTokens.INSTANCE.m3077getOnSurface0d7_KjU() : j17;
        long r21 = (i3 & 131072) != 0 ? ColorDarkTokens.INSTANCE.m3103getSurfaceVariant0d7_KjU() : j18;
        long r23 = (i3 & 262144) != 0 ? ColorDarkTokens.INSTANCE.m3078getOnSurfaceVariant0d7_KjU() : j19;
        long j38 = (i3 & 524288) != 0 ? j37 : j20;
        long r27 = (i3 & 1048576) != 0 ? ColorDarkTokens.INSTANCE.m3065getInverseSurface0d7_KjU() : j21;
        long r29 = (i3 & 2097152) != 0 ? ColorDarkTokens.INSTANCE.m3063getInverseOnSurface0d7_KjU() : j22;
        long r31 = (i3 & 4194304) != 0 ? ColorDarkTokens.INSTANCE.m3061getError0d7_KjU() : j23;
        long r33 = (i3 & 8388608) != 0 ? ColorDarkTokens.INSTANCE.m3067getOnError0d7_KjU() : j24;
        long r35 = (i3 & 16777216) != 0 ? ColorDarkTokens.INSTANCE.m3062getErrorContainer0d7_KjU() : j25;
        long r37 = (i3 & 33554432) != 0 ? ColorDarkTokens.INSTANCE.m3068getOnErrorContainer0d7_KjU() : j26;
        long r39 = (i3 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? ColorDarkTokens.INSTANCE.m3083getOutline0d7_KjU() : j27;
        long r41 = (i3 & 134217728) != 0 ? ColorDarkTokens.INSTANCE.m3084getOutlineVariant0d7_KjU() : j28;
        long r43 = (i3 & 268435456) != 0 ? ColorDarkTokens.INSTANCE.m3089getScrim0d7_KjU() : j29;
        long r45 = (i3 & 536870912) != 0 ? ColorDarkTokens.INSTANCE.m3095getSurfaceBright0d7_KjU() : j30;
        long r47 = (i3 & 1073741824) != 0 ? ColorDarkTokens.INSTANCE.m3096getSurfaceContainer0d7_KjU() : j31;
        long r49 = (i3 & Integer.MIN_VALUE) != 0 ? ColorDarkTokens.INSTANCE.m3097getSurfaceContainerHigh0d7_KjU() : j32;
        long r51 = (i2 & 1) != 0 ? ColorDarkTokens.INSTANCE.m3098getSurfaceContainerHighest0d7_KjU() : j33;
        long r53 = (i2 & 2) != 0 ? ColorDarkTokens.INSTANCE.m3099getSurfaceContainerLow0d7_KjU() : j34;
        long r55 = (i2 & 4) != 0 ? ColorDarkTokens.INSTANCE.m3100getSurfaceContainerLowest0d7_KjU() : j35;
        if ((i2 & 8) != 0) {
            j36 = ColorDarkTokens.INSTANCE.m3101getSurfaceDim0d7_KjU();
        }
        return m1887darkColorSchemeCXl9yA(j37, r3, r5, r7, r9, r11, r13, r15, r75, r77, r79, r81, r83, r85, r12, r17, r19, r21, r23, j38, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, j36);
    }

    /* renamed from: darkColorScheme-C-Xl9yA  reason: not valid java name */
    public static final ColorScheme m1887darkColorSchemeCXl9yA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36) {
        return new ColorScheme(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j36, j31, j32, j33, j34, j35, (DefaultConstructorMarker) null);
    }

    /* renamed from: darkColorScheme-G1PFc-w$default  reason: not valid java name */
    public static /* synthetic */ ColorScheme m1890darkColorSchemeG1PFcw$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, int i, Object obj) {
        int i2 = i;
        long r1 = (i2 & 1) != 0 ? ColorDarkTokens.INSTANCE.m3085getPrimary0d7_KjU() : j;
        long r3 = (i2 & 2) != 0 ? ColorDarkTokens.INSTANCE.m3069getOnPrimary0d7_KjU() : j2;
        long r5 = (i2 & 4) != 0 ? ColorDarkTokens.INSTANCE.m3086getPrimaryContainer0d7_KjU() : j3;
        long r7 = (i2 & 8) != 0 ? ColorDarkTokens.INSTANCE.m3070getOnPrimaryContainer0d7_KjU() : j4;
        long r9 = (i2 & 16) != 0 ? ColorDarkTokens.INSTANCE.m3064getInversePrimary0d7_KjU() : j5;
        long r11 = (i2 & 32) != 0 ? ColorDarkTokens.INSTANCE.m3090getSecondary0d7_KjU() : j6;
        long r13 = (i2 & 64) != 0 ? ColorDarkTokens.INSTANCE.m3073getOnSecondary0d7_KjU() : j7;
        long r15 = (i2 & 128) != 0 ? ColorDarkTokens.INSTANCE.m3091getSecondaryContainer0d7_KjU() : j8;
        long j30 = r1;
        long r61 = (i2 & 256) != 0 ? ColorDarkTokens.INSTANCE.m3074getOnSecondaryContainer0d7_KjU() : j9;
        long r63 = (i2 & 512) != 0 ? ColorDarkTokens.INSTANCE.m3104getTertiary0d7_KjU() : j10;
        long r65 = (i2 & 1024) != 0 ? ColorDarkTokens.INSTANCE.m3079getOnTertiary0d7_KjU() : j11;
        long r67 = (i2 & 2048) != 0 ? ColorDarkTokens.INSTANCE.m3105getTertiaryContainer0d7_KjU() : j12;
        long r69 = (i2 & 4096) != 0 ? ColorDarkTokens.INSTANCE.m3080getOnTertiaryContainer0d7_KjU() : j13;
        long r71 = (i2 & 8192) != 0 ? ColorDarkTokens.INSTANCE.m3060getBackground0d7_KjU() : j14;
        long r12 = (i2 & 16384) != 0 ? ColorDarkTokens.INSTANCE.m3066getOnBackground0d7_KjU() : j15;
        long r17 = (i2 & 32768) != 0 ? ColorDarkTokens.INSTANCE.m3094getSurface0d7_KjU() : j16;
        long r19 = (i2 & 65536) != 0 ? ColorDarkTokens.INSTANCE.m3077getOnSurface0d7_KjU() : j17;
        long r21 = (i2 & 131072) != 0 ? ColorDarkTokens.INSTANCE.m3103getSurfaceVariant0d7_KjU() : j18;
        long r23 = (i2 & 262144) != 0 ? ColorDarkTokens.INSTANCE.m3078getOnSurfaceVariant0d7_KjU() : j19;
        long j31 = (i2 & 524288) != 0 ? j30 : j20;
        long r27 = (i2 & 1048576) != 0 ? ColorDarkTokens.INSTANCE.m3065getInverseSurface0d7_KjU() : j21;
        long r29 = (i2 & 2097152) != 0 ? ColorDarkTokens.INSTANCE.m3063getInverseOnSurface0d7_KjU() : j22;
        long r31 = (i2 & 4194304) != 0 ? ColorDarkTokens.INSTANCE.m3061getError0d7_KjU() : j23;
        long r33 = (i2 & 8388608) != 0 ? ColorDarkTokens.INSTANCE.m3067getOnError0d7_KjU() : j24;
        long r35 = (i2 & 16777216) != 0 ? ColorDarkTokens.INSTANCE.m3062getErrorContainer0d7_KjU() : j25;
        long r37 = (i2 & 33554432) != 0 ? ColorDarkTokens.INSTANCE.m3068getOnErrorContainer0d7_KjU() : j26;
        long r39 = (i2 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? ColorDarkTokens.INSTANCE.m3083getOutline0d7_KjU() : j27;
        long r41 = (i2 & 134217728) != 0 ? ColorDarkTokens.INSTANCE.m3084getOutlineVariant0d7_KjU() : j28;
        if ((i2 & 268435456) != 0) {
            j29 = ColorDarkTokens.INSTANCE.m3089getScrim0d7_KjU();
        }
        return m1888darkColorSchemeCXl9yA$default(j30, r3, r5, r7, r9, r11, r13, r15, r61, r63, r65, r67, r69, r71, r12, r17, r19, r21, r23, j31, r27, r29, r31, r33, r35, r37, r39, r41, j29, 0, 0, 0, 0, 0, 0, 0, -536870912, 15, (Object) null);
    }

    /* renamed from: contentColorFor-4WTKRHQ  reason: not valid java name */
    public static final long m1885contentColorFor4WTKRHQ(ColorScheme colorScheme, long j) {
        if (Color.m4240equalsimpl0(j, colorScheme.m1867getPrimary0d7_KjU())) {
            return colorScheme.m1857getOnPrimary0d7_KjU();
        }
        if (Color.m4240equalsimpl0(j, colorScheme.m1870getSecondary0d7_KjU())) {
            return colorScheme.m1859getOnSecondary0d7_KjU();
        }
        if (Color.m4240equalsimpl0(j, colorScheme.m1882getTertiary0d7_KjU())) {
            return colorScheme.m1863getOnTertiary0d7_KjU();
        }
        if (Color.m4240equalsimpl0(j, colorScheme.m1848getBackground0d7_KjU())) {
            return colorScheme.m1854getOnBackground0d7_KjU();
        }
        if (Color.m4240equalsimpl0(j, colorScheme.m1849getError0d7_KjU())) {
            return colorScheme.m1855getOnError0d7_KjU();
        }
        if (Color.m4240equalsimpl0(j, colorScheme.m1868getPrimaryContainer0d7_KjU())) {
            return colorScheme.m1858getOnPrimaryContainer0d7_KjU();
        }
        if (Color.m4240equalsimpl0(j, colorScheme.m1871getSecondaryContainer0d7_KjU())) {
            return colorScheme.m1860getOnSecondaryContainer0d7_KjU();
        }
        if (Color.m4240equalsimpl0(j, colorScheme.m1883getTertiaryContainer0d7_KjU())) {
            return colorScheme.m1864getOnTertiaryContainer0d7_KjU();
        }
        if (Color.m4240equalsimpl0(j, colorScheme.m1850getErrorContainer0d7_KjU())) {
            return colorScheme.m1856getOnErrorContainer0d7_KjU();
        }
        if (Color.m4240equalsimpl0(j, colorScheme.m1853getInverseSurface0d7_KjU())) {
            return colorScheme.m1851getInverseOnSurface0d7_KjU();
        }
        if (Color.m4240equalsimpl0(j, colorScheme.m1872getSurface0d7_KjU())) {
            return colorScheme.m1861getOnSurface0d7_KjU();
        }
        if (Color.m4240equalsimpl0(j, colorScheme.m1881getSurfaceVariant0d7_KjU())) {
            return colorScheme.m1862getOnSurfaceVariant0d7_KjU();
        }
        if (Color.m4240equalsimpl0(j, colorScheme.m1873getSurfaceBright0d7_KjU())) {
            return colorScheme.m1861getOnSurface0d7_KjU();
        }
        if (Color.m4240equalsimpl0(j, colorScheme.m1874getSurfaceContainer0d7_KjU())) {
            return colorScheme.m1861getOnSurface0d7_KjU();
        }
        if (Color.m4240equalsimpl0(j, colorScheme.m1875getSurfaceContainerHigh0d7_KjU())) {
            return colorScheme.m1861getOnSurface0d7_KjU();
        }
        if (Color.m4240equalsimpl0(j, colorScheme.m1876getSurfaceContainerHighest0d7_KjU())) {
            return colorScheme.m1861getOnSurface0d7_KjU();
        }
        if (Color.m4240equalsimpl0(j, colorScheme.m1877getSurfaceContainerLow0d7_KjU())) {
            return colorScheme.m1861getOnSurface0d7_KjU();
        }
        if (Color.m4240equalsimpl0(j, colorScheme.m1878getSurfaceContainerLowest0d7_KjU())) {
            return colorScheme.m1861getOnSurface0d7_KjU();
        }
        return Color.Companion.m4275getUnspecified0d7_KjU();
    }

    /* renamed from: contentColorFor-ek8zF_U  reason: not valid java name */
    public static final long m1886contentColorForek8zF_U(long j, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 509589638, "C(contentColorFor)P(0:c#ui.graphics.Color):ColorScheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(509589638, i, -1, "androidx.compose.material3.contentColorFor (ColorScheme.kt:878)");
        }
        composer.startReplaceGroup(-1680936624);
        ComposerKt.sourceInformation(composer, "*878@39525L11,879@39609L7");
        long r3 = m1885contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(composer, 6), j);
        if (r3 == 16) {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd(composer);
            r3 = ((Color) consume).m4249unboximpl();
        }
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return r3;
    }

    /* renamed from: applyTonalElevation-RFCenO8  reason: not valid java name */
    public static final long m1884applyTonalElevationRFCenO8(ColorScheme colorScheme, long j, float f, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1610977682, "C(applyTonalElevation)P(0:c#ui.graphics.Color,1:c#ui.unit.Dp)896@40465L7:ColorScheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1610977682, i, -1, "androidx.compose.material3.applyTonalElevation (ColorScheme.kt:895)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(LocalTonalElevationEnabled);
        ComposerKt.sourceInformationMarkerEnd(composer);
        boolean booleanValue = ((Boolean) consume).booleanValue();
        if (Color.m4240equalsimpl0(j, colorScheme.m1872getSurface0d7_KjU()) && booleanValue) {
            j = m1895surfaceColorAtElevation3ABfNKs(colorScheme, f);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return j;
    }

    public static final ColorScheme expressiveLightColorScheme() {
        return m1892lightColorSchemeCXl9yA$default(0, 0, 0, PaletteTokens.INSTANCE.m3444getPrimary300d7_KjU(), 0, 0, 0, 0, PaletteTokens.INSTANCE.m3457getSecondary300d7_KjU(), 0, 0, 0, PaletteTokens.INSTANCE.m3457getSecondary300d7_KjU(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4361, 15, (Object) null);
    }

    public static final long fromToken(ColorScheme colorScheme, ColorSchemeKeyTokens colorSchemeKeyTokens) {
        switch (WhenMappings.$EnumSwitchMapping$0[colorSchemeKeyTokens.ordinal()]) {
            case 1:
                return colorScheme.m1848getBackground0d7_KjU();
            case 2:
                return colorScheme.m1849getError0d7_KjU();
            case 3:
                return colorScheme.m1850getErrorContainer0d7_KjU();
            case 4:
                return colorScheme.m1851getInverseOnSurface0d7_KjU();
            case 5:
                return colorScheme.m1852getInversePrimary0d7_KjU();
            case 6:
                return colorScheme.m1853getInverseSurface0d7_KjU();
            case 7:
                return colorScheme.m1854getOnBackground0d7_KjU();
            case 8:
                return colorScheme.m1855getOnError0d7_KjU();
            case 9:
                return colorScheme.m1856getOnErrorContainer0d7_KjU();
            case 10:
                return colorScheme.m1857getOnPrimary0d7_KjU();
            case 11:
                return colorScheme.m1858getOnPrimaryContainer0d7_KjU();
            case 12:
                return colorScheme.m1859getOnSecondary0d7_KjU();
            case 13:
                return colorScheme.m1860getOnSecondaryContainer0d7_KjU();
            case 14:
                return colorScheme.m1861getOnSurface0d7_KjU();
            case 15:
                return colorScheme.m1862getOnSurfaceVariant0d7_KjU();
            case 16:
                return colorScheme.m1880getSurfaceTint0d7_KjU();
            case 17:
                return colorScheme.m1863getOnTertiary0d7_KjU();
            case 18:
                return colorScheme.m1864getOnTertiaryContainer0d7_KjU();
            case 19:
                return colorScheme.m1865getOutline0d7_KjU();
            case 20:
                return colorScheme.m1866getOutlineVariant0d7_KjU();
            case 21:
                return colorScheme.m1867getPrimary0d7_KjU();
            case 22:
                return colorScheme.m1868getPrimaryContainer0d7_KjU();
            case 23:
                return colorScheme.m1869getScrim0d7_KjU();
            case 24:
                return colorScheme.m1870getSecondary0d7_KjU();
            case 25:
                return colorScheme.m1871getSecondaryContainer0d7_KjU();
            case 26:
                return colorScheme.m1872getSurface0d7_KjU();
            case 27:
                return colorScheme.m1881getSurfaceVariant0d7_KjU();
            case 28:
                return colorScheme.m1873getSurfaceBright0d7_KjU();
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /*29*/:
                return colorScheme.m1874getSurfaceContainer0d7_KjU();
            case 30:
                return colorScheme.m1875getSurfaceContainerHigh0d7_KjU();
            case 31:
                return colorScheme.m1876getSurfaceContainerHighest0d7_KjU();
            case 32:
                return colorScheme.m1877getSurfaceContainerLow0d7_KjU();
            case 33:
                return colorScheme.m1878getSurfaceContainerLowest0d7_KjU();
            case 34:
                return colorScheme.m1879getSurfaceDim0d7_KjU();
            case 35:
                return colorScheme.m1882getTertiary0d7_KjU();
            case 36:
                return colorScheme.m1883getTertiaryContainer0d7_KjU();
            default:
                return Color.Companion.m4275getUnspecified0d7_KjU();
        }
    }

    public static final ProvidableCompositionLocal<ColorScheme> getLocalColorScheme() {
        return LocalColorScheme;
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalTonalElevationEnabled() {
        return LocalTonalElevationEnabled;
    }

    public static final long getValue(ColorSchemeKeyTokens colorSchemeKeyTokens, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -810780884, "C1009@45379L11:ColorScheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-810780884, i, -1, "androidx.compose.material3.<get-value> (ColorScheme.kt:1009)");
        }
        long fromToken = fromToken(MaterialTheme.INSTANCE.getColorScheme(composer, 6), colorSchemeKeyTokens);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return fromToken;
    }

    /* renamed from: surfaceColorAtElevation-3ABfNKs  reason: not valid java name */
    public static final long m1895surfaceColorAtElevation3ABfNKs(ColorScheme colorScheme, float f) {
        if (Dp.m7116equalsimpl0(f, Dp.m7111constructorimpl((float) 0))) {
            return colorScheme.m1872getSurface0d7_KjU();
        }
        return ColorKt.m4284compositeOverOWjLjI(Color.m4238copywmQWz5c$default(colorScheme.m1880getSurfaceTint0d7_KjU(), ((((float) Math.log((double) (f + ((float) 1)))) * 4.5f) + 2.0f) / 100.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null), colorScheme.m1872getSurface0d7_KjU());
    }
}
