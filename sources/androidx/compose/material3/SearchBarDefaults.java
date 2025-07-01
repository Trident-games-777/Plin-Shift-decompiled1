package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.FilledTextFieldTokens;
import androidx.compose.material3.tokens.SearchBarTokens;
import androidx.compose.material3.tokens.SearchViewTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JÈ\u0001\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001c0 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001c0 2\u0006\u0010\"\u001a\u00020#2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001c0 2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020#2\u0015\b\u0002\u0010(\u001a\u000f\u0012\u0004\u0012\u00020\u001c\u0018\u00010)¢\u0006\u0002\b*2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020\u001c\u0018\u00010)¢\u0006\u0002\b*2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020\u001c\u0018\u00010)¢\u0006\u0002\b*2\b\b\u0002\u0010-\u001a\u00020.2\n\b\u0002\u0010/\u001a\u0004\u0018\u000100H\u0007¢\u0006\u0002\u00101J&\u0010-\u001a\u0002022\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u000204H\u0007ø\u0001\u0000¢\u0006\u0004\b6\u00107J0\u0010-\u001a\u0002022\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002042\b\b\u0002\u00108\u001a\u00020.H\u0007ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u0001\u00108\u001a\u00020.2\b\b\u0002\u0010;\u001a\u0002042\b\b\u0002\u0010<\u001a\u0002042\b\b\u0002\u0010=\u001a\u0002042\b\b\u0002\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u0002042\b\b\u0002\u0010A\u001a\u0002042\b\b\u0002\u0010B\u001a\u0002042\b\b\u0002\u0010C\u001a\u0002042\b\b\u0002\u0010D\u001a\u0002042\b\b\u0002\u0010E\u001a\u0002042\b\b\u0002\u0010F\u001a\u0002042\b\b\u0002\u0010G\u001a\u000204H\u0007ø\u0001\u0000¢\u0006\u0004\bH\u0010IJ\u0001\u00108\u001a\u00020.2\b\b\u0002\u0010J\u001a\u0002042\b\b\u0002\u0010K\u001a\u0002042\b\b\u0002\u0010<\u001a\u0002042\b\b\u0002\u0010=\u001a\u0002042\b\b\u0002\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u0002042\b\b\u0002\u0010A\u001a\u0002042\b\b\u0002\u0010B\u001a\u0002042\b\b\u0002\u0010C\u001a\u0002042\b\b\u0002\u0010D\u001a\u0002042\b\b\u0002\u0010E\u001a\u0002042\b\b\u0002\u0010L\u001a\u0002042\b\b\u0002\u0010M\u001a\u0002042\b\b\u0002\u0010G\u001a\u000204H\u0007ø\u0001\u0000¢\u0006\u0004\bN\u0010OR$\u0010\u0003\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\t\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0019\u0010\r\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0011\u0010\u000f\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0017\u001a\u00020\u00188G¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006P"}, d2 = {"Landroidx/compose/material3/SearchBarDefaults;", "", "()V", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM$annotations", "getElevation-D9Ej5fM", "()F", "F", "InputFieldHeight", "getInputFieldHeight-D9Ej5fM", "ShadowElevation", "getShadowElevation-D9Ej5fM", "TonalElevation", "getTonalElevation-D9Ej5fM", "dockedShape", "Landroidx/compose/ui/graphics/Shape;", "getDockedShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "fullScreenShape", "getFullScreenShape", "inputFieldShape", "getInputFieldShape", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "InputField", "", "query", "", "onQueryChange", "Lkotlin/Function1;", "onSearch", "expanded", "", "onExpandedChange", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "placeholder", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "leadingIcon", "trailingIcon", "colors", "Landroidx/compose/material3/TextFieldColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/material3/SearchBarColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "dividerColor", "colors-dgg9oW8", "(JJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SearchBarColors;", "inputFieldColors", "colors-Klgx-Pg", "(JJLandroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SearchBarColors;", "textColor", "disabledTextColor", "cursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "placeholderColor", "disabledPlaceholderColor", "inputFieldColors--u-KgnY", "(JJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "unfocusedTextColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "inputFieldColors-ITpI4ow", "(JJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/TextFieldColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SearchBar.android.kt */
public final class SearchBarDefaults {
    public static final int $stable = 0;
    private static final float Elevation;
    public static final SearchBarDefaults INSTANCE = new SearchBarDefaults();
    private static final float InputFieldHeight = SearchBarTokens.INSTANCE.m3496getContainerHeightD9Ej5fM();
    private static final float ShadowElevation = ElevationTokens.INSTANCE.m3195getLevel0D9Ej5fM();
    private static final float TonalElevation;

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to TonalElevation. Not to be confused with ShadowElevation.", replaceWith = @ReplaceWith(expression = "TonalElevation", imports = {}))
    /* renamed from: getElevation-D9Ej5fM$annotations  reason: not valid java name */
    public static /* synthetic */ void m2397getElevationD9Ej5fM$annotations() {
    }

    private SearchBarDefaults() {
    }

    static {
        float r0 = ElevationTokens.INSTANCE.m3195getLevel0D9Ej5fM();
        TonalElevation = r0;
        Elevation = r0;
    }

    /* renamed from: getTonalElevation-D9Ej5fM  reason: not valid java name */
    public final float m2403getTonalElevationD9Ej5fM() {
        return TonalElevation;
    }

    /* renamed from: getShadowElevation-D9Ej5fM  reason: not valid java name */
    public final float m2402getShadowElevationD9Ej5fM() {
        return ShadowElevation;
    }

    /* renamed from: getElevation-D9Ej5fM  reason: not valid java name */
    public final float m2400getElevationD9Ej5fM() {
        return Elevation;
    }

    /* renamed from: getInputFieldHeight-D9Ej5fM  reason: not valid java name */
    public final float m2401getInputFieldHeightD9Ej5fM() {
        return InputFieldHeight;
    }

    public final Shape getInputFieldShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -971556142, "C349@15770L5:SearchBar.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-971556142, i, -1, "androidx.compose.material3.SearchBarDefaults.<get-inputFieldShape> (SearchBar.android.kt:349)");
        }
        Shape value = ShapesKt.getValue(SearchBarTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getFullScreenShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1665502056, "C353@15944L5:SearchBar.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1665502056, i, -1, "androidx.compose.material3.SearchBarDefaults.<get-fullScreenShape> (SearchBar.android.kt:353)");
        }
        Shape value = ShapesKt.getValue(SearchViewTokens.INSTANCE.getFullScreenContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getDockedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1006952150, "C357@16094L5:SearchBar.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1006952150, i, -1, "androidx.compose.material3.SearchBarDefaults.<get-dockedShape> (SearchBar.android.kt:357)");
        }
        Shape value = ShapesKt.getValue(SearchViewTokens.INSTANCE.getDockedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final WindowInsets getWindowInsets(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 2112270157, "C361@16229L10:SearchBar.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2112270157, i, -1, "androidx.compose.material3.SearchBarDefaults.<get-windowInsets> (SearchBar.android.kt:361)");
        }
        WindowInsets statusBars = WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return statusBars;
    }

    /* renamed from: colors-dgg9oW8  reason: not valid java name */
    public final SearchBarColors m2399colorsdgg9oW8(long j, long j2, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i;
        ComposerKt.sourceInformationMarkerStart(composer2, -1507037523, "C(colors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color)375@16778L5,376@16845L5,381@17019L18:SearchBar.android.kt#uh7d8r");
        long value = (i2 & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), composer2, 6) : j;
        long value2 = (i2 & 2) != 0 ? ColorSchemeKt.getValue(SearchViewTokens.INSTANCE.getDividerColor(), composer2, 6) : j2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1507037523, i3, -1, "androidx.compose.material3.SearchBarDefaults.colors (SearchBar.android.kt:378)");
        }
        SearchBarColors searchBarColors = new SearchBarColors(value, value2, m2405inputFieldColorsITpI4ow(0, 0, 0, 0, (TextSelectionColors) null, 0, 0, 0, 0, 0, 0, 0, 0, 0, composer2, 0, (i3 << 6) & 57344, 16383), (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return searchBarColors;
    }

    /* renamed from: inputFieldColors-ITpI4ow  reason: not valid java name */
    public final TextFieldColors m2405inputFieldColorsITpI4ow(long j, long j2, long j3, long j4, TextSelectionColors textSelectionColors, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, Composer composer, int i, int i2, int i3) {
        TextSelectionColors textSelectionColors2;
        Composer composer2 = composer;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ComposerKt.sourceInformationMarkerStart(composer2, -602148837, "C(inputFieldColors)P(7:c#ui.graphics.Color,12:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,9,5:c#ui.graphics.Color,10:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,13:c#ui.graphics.Color,4:c#ui.graphics.Color,6:c#ui.graphics.Color,11:c#ui.graphics.Color,2:c#ui.graphics.Color)410@18829L5,411@18903L5,413@18998L5,416@19154L5,417@19233L7,418@19316L5,419@19399L5,421@19507L5,424@19683L5,425@19768L5,427@19878L5,430@20056L5,431@20142L5,433@20244L5,437@20389L847:SearchBar.android.kt#uh7d8r");
        long value = (i6 & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), composer2, 6) : j;
        long value2 = (i6 & 2) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), composer2, 6) : j2;
        long r11 = (i6 & 4) != 0 ? Color.m4238copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer2, 6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j3;
        long value3 = (i6 & 8) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getCaretColor(), composer2, 6) : j4;
        if ((i6 & 16) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer2);
            textSelectionColors2 = (TextSelectionColors) consume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        long value4 = (i6 & 32) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), composer2, 6) : j5;
        long value5 = (i6 & 64) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), composer2, 6) : j6;
        long r35 = (i6 & 128) != 0 ? Color.m4238copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), composer2, 6), FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j7;
        long value6 = (i6 & 256) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), composer2, 6) : j8;
        long value7 = (i6 & 512) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), composer2, 6) : j9;
        long r43 = (i6 & 1024) != 0 ? Color.m4238copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), composer2, 6), FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j10;
        long value8 = (i6 & 2048) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), composer2, 6) : j11;
        long value9 = (i6 & 4096) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), composer2, 6) : j12;
        long r59 = (i6 & 8192) != 0 ? Color.m4238copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer2, 6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j13;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-602148837, i4, i5, "androidx.compose.material3.SearchBarDefaults.inputFieldColors (SearchBar.android.kt:437)");
        }
        int i7 = i5 << 18;
        TextFieldColors r0 = TextFieldDefaults.INSTANCE.m2671colors0hiis_0(value, value2, r11, 0, 0, 0, 0, 0, value3, 0, textSelectionColors2, 0, 0, 0, 0, value4, value5, r35, 0, value6, value7, r43, 0, 0, 0, 0, 0, value8, value9, r59, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, composer2, (i4 & 1022) | ((i4 << 15) & 234881024), ((i4 >> 12) & 14) | (458752 & i4) | (3670016 & i4) | (i4 & 29360128) | ((i4 << 3) & 1879048192), ((i4 >> 27) & 14) | ((i5 << 3) & 112) | (i7 & 29360128) | (i7 & 234881024) | (i7 & 1879048192), 0, 3072, 1204058872, 4095);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return r0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v1, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x0584  */
    /* JADX WARNING: Removed duplicated region for block: B:239:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0117  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void InputField(java.lang.String r83, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r84, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r85, boolean r86, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r87, androidx.compose.ui.Modifier r88, boolean r89, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r90, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r91, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r92, androidx.compose.material3.TextFieldColors r93, androidx.compose.foundation.interaction.MutableInteractionSource r94, androidx.compose.runtime.Composer r95, int r96, int r97, int r98) {
        /*
            r82 = this;
            r0 = r83
            r1 = r85
            r2 = r86
            r3 = r87
            r4 = r96
            r5 = r97
            r6 = r98
            r7 = 1451366815(0x5682199f, float:7.1523277E13)
            r8 = r95
            androidx.compose.runtime.Composer r8 = r8.startRestartGroup(r7)
            java.lang.String r9 = "C(InputField)P(10,7,8,2,6,5,1,9,4,11)492@23517L18,498@23776L25,499@23837L29,500@23912L7,502@23951L34,503@24030L39,*506@24122L7,521@24685L44,522@24761L378,534@25242L7,537@25496L19,540@25625L1172,510@24250L2557,566@26894L320,566@26869L345:SearchBar.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r9)
            r9 = r6 & 1
            if (r9 == 0) goto L_0x0023
            r9 = r4 | 6
            goto L_0x0033
        L_0x0023:
            r9 = r4 & 6
            if (r9 != 0) goto L_0x0032
            boolean r9 = r8.changed((java.lang.Object) r0)
            if (r9 == 0) goto L_0x002f
            r9 = 4
            goto L_0x0030
        L_0x002f:
            r9 = 2
        L_0x0030:
            r9 = r9 | r4
            goto L_0x0033
        L_0x0032:
            r9 = r4
        L_0x0033:
            r12 = r6 & 2
            if (r12 == 0) goto L_0x003a
            r9 = r9 | 48
            goto L_0x004d
        L_0x003a:
            r12 = r4 & 48
            if (r12 != 0) goto L_0x004d
            r12 = r84
            boolean r15 = r8.changedInstance(r12)
            if (r15 == 0) goto L_0x0049
            r15 = 32
            goto L_0x004b
        L_0x0049:
            r15 = 16
        L_0x004b:
            r9 = r9 | r15
            goto L_0x004f
        L_0x004d:
            r12 = r84
        L_0x004f:
            r15 = r6 & 4
            r16 = 128(0x80, float:1.794E-43)
            if (r15 == 0) goto L_0x0058
            r9 = r9 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0058:
            r15 = r4 & 384(0x180, float:5.38E-43)
            if (r15 != 0) goto L_0x0068
            boolean r15 = r8.changedInstance(r1)
            if (r15 == 0) goto L_0x0065
            r15 = 256(0x100, float:3.59E-43)
            goto L_0x0067
        L_0x0065:
            r15 = r16
        L_0x0067:
            r9 = r9 | r15
        L_0x0068:
            r15 = r6 & 8
            if (r15 == 0) goto L_0x006f
            r9 = r9 | 3072(0xc00, float:4.305E-42)
            goto L_0x007f
        L_0x006f:
            r15 = r4 & 3072(0xc00, float:4.305E-42)
            if (r15 != 0) goto L_0x007f
            boolean r15 = r8.changed((boolean) r2)
            if (r15 == 0) goto L_0x007c
            r15 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r15 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r9 = r9 | r15
        L_0x007f:
            r15 = r6 & 16
            if (r15 == 0) goto L_0x0086
            r9 = r9 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0096
        L_0x0086:
            r15 = r4 & 24576(0x6000, float:3.4438E-41)
            if (r15 != 0) goto L_0x0096
            boolean r15 = r8.changedInstance(r3)
            if (r15 == 0) goto L_0x0093
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0095
        L_0x0093:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x0095:
            r9 = r9 | r15
        L_0x0096:
            r15 = r6 & 32
            r17 = 196608(0x30000, float:2.75506E-40)
            if (r15 == 0) goto L_0x00a1
            r9 = r9 | r17
            r10 = r88
            goto L_0x00b4
        L_0x00a1:
            r17 = r4 & r17
            r10 = r88
            if (r17 != 0) goto L_0x00b4
            boolean r18 = r8.changed((java.lang.Object) r10)
            if (r18 == 0) goto L_0x00b0
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b2
        L_0x00b0:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x00b2:
            r9 = r9 | r18
        L_0x00b4:
            r18 = r6 & 64
            r19 = 1572864(0x180000, float:2.204052E-39)
            if (r18 == 0) goto L_0x00bf
            r9 = r9 | r19
            r11 = r89
            goto L_0x00d2
        L_0x00bf:
            r19 = r4 & r19
            r11 = r89
            if (r19 != 0) goto L_0x00d2
            boolean r20 = r8.changed((boolean) r11)
            if (r20 == 0) goto L_0x00ce
            r20 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d0
        L_0x00ce:
            r20 = 524288(0x80000, float:7.34684E-40)
        L_0x00d0:
            r9 = r9 | r20
        L_0x00d2:
            r13 = r6 & 128(0x80, float:1.794E-43)
            r21 = 12582912(0xc00000, float:1.7632415E-38)
            if (r13 == 0) goto L_0x00dd
            r9 = r9 | r21
            r14 = r90
            goto L_0x00f0
        L_0x00dd:
            r21 = r4 & r21
            r14 = r90
            if (r21 != 0) goto L_0x00f0
            boolean r22 = r8.changedInstance(r14)
            if (r22 == 0) goto L_0x00ec
            r22 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ee
        L_0x00ec:
            r22 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ee:
            r9 = r9 | r22
        L_0x00f0:
            r7 = r6 & 256(0x100, float:3.59E-43)
            r22 = 100663296(0x6000000, float:2.4074124E-35)
            if (r7 == 0) goto L_0x00fb
            r9 = r9 | r22
            r4 = r91
            goto L_0x010e
        L_0x00fb:
            r22 = r4 & r22
            r4 = r91
            if (r22 != 0) goto L_0x010e
            boolean r22 = r8.changedInstance(r4)
            if (r22 == 0) goto L_0x010a
            r22 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010c
        L_0x010a:
            r22 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010c:
            r9 = r9 | r22
        L_0x010e:
            r4 = r6 & 512(0x200, float:7.175E-43)
            r22 = 805306368(0x30000000, float:4.656613E-10)
            if (r4 == 0) goto L_0x0117
            r9 = r9 | r22
            goto L_0x012d
        L_0x0117:
            r22 = r96 & r22
            if (r22 != 0) goto L_0x012d
            r22 = r4
            r4 = r92
            boolean r23 = r8.changedInstance(r4)
            if (r23 == 0) goto L_0x0128
            r23 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012a
        L_0x0128:
            r23 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x012a:
            r9 = r9 | r23
            goto L_0x0131
        L_0x012d:
            r22 = r4
            r4 = r92
        L_0x0131:
            r23 = r5 & 6
            if (r23 != 0) goto L_0x014b
            r4 = r6 & 1024(0x400, float:1.435E-42)
            if (r4 != 0) goto L_0x0144
            r4 = r93
            boolean r23 = r8.changed((java.lang.Object) r4)
            if (r23 == 0) goto L_0x0146
            r17 = 4
            goto L_0x0148
        L_0x0144:
            r4 = r93
        L_0x0146:
            r17 = 2
        L_0x0148:
            r17 = r5 | r17
            goto L_0x014f
        L_0x014b:
            r4 = r93
            r17 = r5
        L_0x014f:
            r23 = r9
            r9 = r6 & 2048(0x800, float:2.87E-42)
            if (r9 == 0) goto L_0x015e
            r17 = r17 | 48
            r24 = r9
            r4 = r17
            r9 = r94
            goto L_0x017a
        L_0x015e:
            r24 = r5 & 48
            if (r24 != 0) goto L_0x0174
            r24 = r9
            r9 = r94
            boolean r25 = r8.changed((java.lang.Object) r9)
            if (r25 == 0) goto L_0x016f
            r20 = 32
            goto L_0x0171
        L_0x016f:
            r20 = 16
        L_0x0171:
            r17 = r17 | r20
            goto L_0x0178
        L_0x0174:
            r24 = r9
            r9 = r94
        L_0x0178:
            r4 = r17
        L_0x017a:
            r17 = r7
            r7 = r6 & 4096(0x1000, float:5.74E-42)
            if (r7 == 0) goto L_0x0183
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0194
        L_0x0183:
            r7 = r5 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0194
            r7 = r82
            boolean r20 = r8.changed((java.lang.Object) r7)
            if (r20 == 0) goto L_0x0191
            r16 = 256(0x100, float:3.59E-43)
        L_0x0191:
            r4 = r4 | r16
            goto L_0x0196
        L_0x0194:
            r7 = r82
        L_0x0196:
            r16 = 306783379(0x12492493, float:6.34695E-28)
            r5 = r23 & r16
            r7 = 306783378(0x12492492, float:6.3469493E-28)
            if (r5 != r7) goto L_0x01be
            r5 = r4 & 147(0x93, float:2.06E-43)
            r7 = 146(0x92, float:2.05E-43)
            if (r5 != r7) goto L_0x01be
            boolean r5 = r8.getSkipping()
            if (r5 != 0) goto L_0x01ad
            goto L_0x01be
        L_0x01ad:
            r8.skipToGroupEnd()
            r12 = r93
            r36 = r8
            r13 = r9
            r7 = r10
            r8 = r11
            r9 = r14
            r10 = r91
            r11 = r92
            goto L_0x057e
        L_0x01be:
            r8.startDefaults()
            r5 = r96 & 1
            r40 = r4
            if (r5 == 0) goto L_0x01f6
            boolean r5 = r8.getDefaultsInvalid()
            if (r5 == 0) goto L_0x01ce
            goto L_0x01f6
        L_0x01ce:
            r8.skipToGroupEnd()
            r5 = r6 & 1024(0x400, float:1.435E-42)
            if (r5 == 0) goto L_0x01e5
            r5 = r40 & -15
            r4 = r10
            r10 = r5
            r5 = r4
            r43 = r91
            r44 = r92
            r20 = r9
            r42 = r14
            r4 = r23
            goto L_0x01f2
        L_0x01e5:
            r43 = r91
            r44 = r92
            r20 = r9
            r5 = r10
            r42 = r14
            r4 = r23
            r10 = r40
        L_0x01f2:
            r9 = r93
            goto L_0x0289
        L_0x01f6:
            if (r15 == 0) goto L_0x01fd
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            goto L_0x01fe
        L_0x01fd:
            r5 = r10
        L_0x01fe:
            if (r18 == 0) goto L_0x0203
            r41 = 1
            goto L_0x0205
        L_0x0203:
            r41 = r11
        L_0x0205:
            if (r13 == 0) goto L_0x020a
            r42 = 0
            goto L_0x020c
        L_0x020a:
            r42 = r14
        L_0x020c:
            if (r17 == 0) goto L_0x0211
            r43 = 0
            goto L_0x0213
        L_0x0211:
            r43 = r91
        L_0x0213:
            if (r22 == 0) goto L_0x0218
            r44 = 0
            goto L_0x021a
        L_0x0218:
            r44 = r92
        L_0x021a:
            r10 = r6 & 1024(0x400, float:1.435E-42)
            if (r10 == 0) goto L_0x0276
            r10 = 57344(0xe000, float:8.0356E-41)
            int r11 = r40 << 6
            r38 = r11 & r10
            r39 = 16383(0x3fff, float:2.2957E-41)
            r9 = 0
            r11 = 0
            r13 = 0
            r15 = 0
            r17 = 0
            r20 = 4
            r18 = 0
            r22 = r20
            r20 = 0
            r26 = r22
            r25 = r23
            r22 = 0
            r27 = r24
            r28 = r25
            r24 = 0
            r30 = r26
            r29 = r27
            r26 = 0
            r32 = r28
            r31 = r29
            r28 = 0
            r34 = r30
            r33 = r31
            r30 = 0
            r36 = r32
            r35 = r33
            r32 = 0
            r45 = r34
            r37 = r35
            r34 = 0
            r46 = r37
            r37 = 0
            r4 = r36
            r36 = r8
            r8 = r82
            androidx.compose.material3.TextFieldColors r9 = r8.m2405inputFieldColorsITpI4ow(r9, r11, r13, r15, r17, r18, r20, r22, r24, r26, r28, r30, r32, r34, r36, r37, r38, r39)
            r8 = r36
            r10 = r40 & -15
            goto L_0x027e
        L_0x0276:
            r4 = r23
            r46 = r24
            r9 = r93
            r10 = r40
        L_0x027e:
            if (r46 == 0) goto L_0x0285
            r11 = r41
            r20 = 0
            goto L_0x0289
        L_0x0285:
            r20 = r94
            r11 = r41
        L_0x0289:
            r8.endDefaults()
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x029a
            java.lang.String r12 = "androidx.compose.material3.SearchBarDefaults.InputField (SearchBar.android.kt:494)"
            r13 = 1451366815(0x5682199f, float:7.1523277E13)
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r4, r10, r12)
        L_0x029a:
            r10 = -320443616(0xffffffffece66b20, float:-2.2284706E27)
            r8.startReplaceGroup(r10)
            java.lang.String r10 = "496@23695L39"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r10)
            java.lang.String r10 = "CC(remember):SearchBar.android.kt#9igjgp"
            if (r20 != 0) goto L_0x02c9
            r12 = -320442965(0xffffffffece66dab, float:-2.2285666E27)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r12, r10)
            java.lang.Object r12 = r8.rememberedValue()
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r12 != r13) goto L_0x02c2
            androidx.compose.foundation.interaction.MutableInteractionSource r12 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r8.updateRememberedValue(r12)
        L_0x02c2:
            androidx.compose.foundation.interaction.MutableInteractionSource r12 = (androidx.compose.foundation.interaction.MutableInteractionSource) r12
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r13 = r12
            goto L_0x02cb
        L_0x02c9:
            r13 = r20
        L_0x02cb:
            r8.endReplaceGroup()
            r12 = r13
            androidx.compose.foundation.interaction.InteractionSource r12 = (androidx.compose.foundation.interaction.InteractionSource) r12
            r14 = 0
            androidx.compose.runtime.State r12 = androidx.compose.foundation.interaction.FocusInteractionKt.collectIsFocusedAsState(r12, r8, r14)
            java.lang.Object r12 = r12.getValue()
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            r15 = -320438431(0xffffffffece67f61, float:-2.2292357E27)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r15, r10)
            java.lang.Object r15 = r8.rememberedValue()
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r16.getEmpty()
            if (r15 != r7) goto L_0x02fa
            androidx.compose.ui.focus.FocusRequester r15 = new androidx.compose.ui.focus.FocusRequester
            r15.<init>()
            r8.updateRememberedValue(r15)
        L_0x02fa:
            androidx.compose.ui.focus.FocusRequester r15 = (androidx.compose.ui.focus.FocusRequester) r15
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFocusManager()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            r88 = r5
            java.lang.String r5 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r14, r5)
            java.lang.Object r7 = r8.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.ui.focus.FocusManager r7 = (androidx.compose.ui.focus.FocusManager) r7
            androidx.compose.material3.internal.Strings$Companion r18 = androidx.compose.material3.internal.Strings.Companion
            int r18 = androidx.compose.material3.R.string.m3c_search_bar_search
            int r14 = androidx.compose.material3.internal.Strings.m2922constructorimpl(r18)
            r6 = 0
            java.lang.String r14 = androidx.compose.material3.internal.Strings_androidKt.m2992getString2EP1pXo(r14, r8, r6)
            androidx.compose.material3.internal.Strings$Companion r16 = androidx.compose.material3.internal.Strings.Companion
            int r16 = androidx.compose.material3.R.string.m3c_suggestions_available
            r18 = r7
            int r7 = androidx.compose.material3.internal.Strings.m2922constructorimpl(r16)
            java.lang.String r7 = androidx.compose.material3.internal.Strings_androidKt.m2992getString2EP1pXo(r7, r8, r6)
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.material3.TextKt.getLocalTextStyle()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r21 = r13
            r13 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r13, r5)
            java.lang.Object r6 = r8.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.ui.text.TextStyle r6 = (androidx.compose.ui.text.TextStyle) r6
            long r22 = r6.m6594getColor0d7_KjU()
            r24 = 16
            int r6 = (r22 > r24 ? 1 : (r22 == r24 ? 0 : -1))
            if (r6 == 0) goto L_0x0355
            goto L_0x035a
        L_0x0355:
            r6 = 0
            long r22 = r9.m2659textColorXeAY9LY$material3_release(r11, r6, r12)
        L_0x035a:
            r48 = r22
            float r6 = androidx.compose.material3.SearchBar_androidKt.getSearchBarMinWidth()
            float r13 = androidx.compose.material3.SearchBar_androidKt.SearchBarMaxWidth
            float r22 = InputFieldHeight
            r23 = 8
            r24 = 0
            r25 = 0
            r89 = r6
            r91 = r13
            r90 = r22
            r93 = r23
            r94 = r24
            r92 = r25
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.SizeKt.m849sizeInqDBjuR0$default(r88, r89, r90, r91, r92, r93, r94)
            r22 = r88
            androidx.compose.ui.Modifier r6 = androidx.compose.ui.focus.FocusRequesterModifierKt.focusRequester(r6, r15)
            r13 = -320411280(0xffffffffece6e970, float:-2.2332425E27)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r13, r10)
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r4
            r90 = r11
            r11 = 16384(0x4000, float:2.2959E-41)
            if (r13 != r11) goto L_0x0394
            r11 = 1
            goto L_0x0395
        L_0x0394:
            r11 = 0
        L_0x0395:
            java.lang.Object r13 = r8.rememberedValue()
            if (r11 != 0) goto L_0x03a3
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r13 != r11) goto L_0x03ae
        L_0x03a3:
            androidx.compose.material3.SearchBarDefaults$InputField$1$1 r11 = new androidx.compose.material3.SearchBarDefaults$InputField$1$1
            r11.<init>(r3)
            r13 = r11
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            r8.updateRememberedValue(r13)
        L_0x03ae:
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.ui.Modifier r6 = androidx.compose.ui.focus.FocusChangedModifierKt.onFocusChanged(r6, r13)
            r11 = -320408514(0xffffffffece6f43e, float:-2.2336507E27)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r11, r10)
            boolean r11 = r8.changed((java.lang.Object) r14)
            r13 = r4 & 7168(0x1c00, float:1.0045E-41)
            r3 = 2048(0x800, float:2.87E-42)
            if (r13 != r3) goto L_0x03c9
            r3 = 1
            goto L_0x03ca
        L_0x03c9:
            r3 = 0
        L_0x03ca:
            r3 = r3 | r11
            boolean r11 = r8.changed((java.lang.Object) r7)
            r3 = r3 | r11
            java.lang.Object r11 = r8.rememberedValue()
            if (r3 != 0) goto L_0x03de
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r11 != r3) goto L_0x03e9
        L_0x03de:
            androidx.compose.material3.SearchBarDefaults$InputField$2$1 r3 = new androidx.compose.material3.SearchBarDefaults$InputField$2$1
            r3.<init>(r14, r2, r7, r15)
            r11 = r3
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            r8.updateRememberedValue(r11)
        L_0x03e9:
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r3 = 0
            r7 = 0
            r13 = 1
            androidx.compose.ui.Modifier r6 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r6, r7, r11, r13, r3)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.material3.TextKt.getLocalTextStyle()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r13 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r13, r5)
            java.lang.Object r3 = r8.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.ui.text.TextStyle r3 = (androidx.compose.ui.text.TextStyle) r3
            androidx.compose.ui.text.TextStyle r47 = new androidx.compose.ui.text.TextStyle
            r77 = 16777214(0xfffffe, float:2.3509884E-38)
            r78 = 0
            r50 = 0
            r52 = 0
            r53 = 0
            r54 = 0
            r55 = 0
            r56 = 0
            r57 = 0
            r59 = 0
            r60 = 0
            r61 = 0
            r62 = 0
            r64 = 0
            r65 = 0
            r66 = 0
            r67 = 0
            r68 = 0
            r69 = 0
            r71 = 0
            r72 = 0
            r73 = 0
            r74 = 0
            r75 = 0
            r76 = 0
            r47.<init>((long) r48, (long) r50, (androidx.compose.ui.text.font.FontWeight) r52, (androidx.compose.ui.text.font.FontStyle) r53, (androidx.compose.ui.text.font.FontSynthesis) r54, (androidx.compose.ui.text.font.FontFamily) r55, (java.lang.String) r56, (long) r57, (androidx.compose.ui.text.style.BaselineShift) r59, (androidx.compose.ui.text.style.TextGeometricTransform) r60, (androidx.compose.ui.text.intl.LocaleList) r61, (long) r62, (androidx.compose.ui.text.style.TextDecoration) r64, (androidx.compose.ui.graphics.Shadow) r65, (androidx.compose.ui.graphics.drawscope.DrawStyle) r66, (int) r67, (int) r68, (long) r69, (androidx.compose.ui.text.style.TextIndent) r71, (androidx.compose.ui.text.PlatformTextStyle) r72, (androidx.compose.ui.text.style.LineHeightStyle) r73, (int) r74, (int) r75, (androidx.compose.ui.text.style.TextMotion) r76, (int) r77, (kotlin.jvm.internal.DefaultConstructorMarker) r78)
            r5 = r47
            androidx.compose.ui.text.TextStyle r5 = r3.merge((androidx.compose.ui.text.TextStyle) r5)
            androidx.compose.ui.graphics.SolidColor r3 = new androidx.compose.ui.graphics.SolidColor
            r7 = 0
            long r13 = r9.m2609cursorColorvNxB06k$material3_release(r7)
            r11 = 0
            r3.<init>(r13, r11)
            androidx.compose.foundation.text.KeyboardOptions r23 = new androidx.compose.foundation.text.KeyboardOptions
            androidx.compose.ui.text.input.ImeAction$Companion r13 = androidx.compose.ui.text.input.ImeAction.Companion
            int r27 = r13.m6760getSearcheUduSuo()
            r31 = 119(0x77, float:1.67E-43)
            r32 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r23.<init>((int) r24, (java.lang.Boolean) r25, (int) r26, (int) r27, (androidx.compose.ui.text.input.PlatformImeOptions) r28, (java.lang.Boolean) r29, (androidx.compose.ui.text.intl.LocaleList) r30, (int) r31, (kotlin.jvm.internal.DefaultConstructorMarker) r32)
            r13 = -320385353(0xffffffffece74eb7, float:-2.2370687E27)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r13, r10)
            r13 = r4 & 896(0x380, float:1.256E-42)
            r14 = 256(0x100, float:3.59E-43)
            if (r13 != r14) goto L_0x047c
            r13 = 1
            goto L_0x047d
        L_0x047c:
            r13 = r7
        L_0x047d:
            r14 = r4 & 14
            r15 = 4
            if (r14 != r15) goto L_0x0484
            r15 = 1
            goto L_0x0485
        L_0x0484:
            r15 = r7
        L_0x0485:
            r13 = r13 | r15
            java.lang.Object r15 = r8.rememberedValue()
            if (r13 != 0) goto L_0x0494
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r15 != r13) goto L_0x049f
        L_0x0494:
            androidx.compose.material3.SearchBarDefaults$InputField$3$1 r13 = new androidx.compose.material3.SearchBarDefaults$InputField$3$1
            r13.<init>(r1, r0)
            r15 = r13
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15
            r8.updateRememberedValue(r15)
        L_0x049f:
            r29 = r15
            kotlin.jvm.functions.Function1 r29 = (kotlin.jvm.functions.Function1) r29
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.foundation.text.KeyboardActions r24 = new androidx.compose.foundation.text.KeyboardActions
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r30 = 0
            r31 = 47
            r32 = 0
            r24.<init>(r25, r26, r27, r28, r29, r30, r31, r32)
            androidx.compose.ui.graphics.Brush r3 = (androidx.compose.ui.graphics.Brush) r3
            androidx.compose.material3.SearchBarDefaults$InputField$4 r13 = new androidx.compose.material3.SearchBarDefaults$InputField$4
            r89 = r0
            r95 = r9
            r88 = r13
            r91 = r21
            r92 = r42
            r93 = r43
            r94 = r44
            r88.<init>(r89, r90, r91, r92, r93, r94, r95)
            r9 = r88
            r25 = r95
            r0 = r14
            r14 = r3
            r3 = r90
            r13 = 54
            r15 = -2029278807(0xffffffff870ba9a9, float:-1.0507056E-34)
            r7 = 1
            androidx.compose.runtime.internal.ComposableLambda r9 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r15, r7, r9, r8, r13)
            r15 = r9
            kotlin.jvm.functions.Function3 r15 = (kotlin.jvm.functions.Function3) r15
            r9 = 102236160(0x6180000, float:2.8588023E-35)
            r0 = r0 | r9
            r9 = r4 & 112(0x70, float:1.57E-43)
            r0 = r0 | r9
            int r4 = r4 >> 9
            r9 = r4 & 7168(0x1c00, float:1.0045E-41)
            r17 = r0 | r9
            r0 = r18
            r18 = 196608(0x30000, float:2.75506E-40)
            r19 = 7696(0x1e10, float:1.0784E-41)
            r9 = r4
            r4 = 0
            r36 = r8
            r8 = 1
            r13 = r9
            r9 = 0
            r26 = r10
            r10 = 0
            r27 = r11
            r11 = 0
            r28 = r12
            r12 = 0
            r1 = r21
            r21 = r13
            r13 = r1
            r1 = r84
            r79 = r0
            r2 = r6
            r45 = r7
            r6 = r23
            r7 = r24
            r80 = r26
            r16 = r36
            r23 = 0
            r0 = r83
            androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField((java.lang.String) r0, (kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit>) r1, (androidx.compose.ui.Modifier) r2, (boolean) r3, (boolean) r4, (androidx.compose.ui.text.TextStyle) r5, (androidx.compose.foundation.text.KeyboardOptions) r6, (androidx.compose.foundation.text.KeyboardActions) r7, (boolean) r8, (int) r9, (int) r10, (androidx.compose.ui.text.input.VisualTransformation) r11, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r12, (androidx.compose.foundation.interaction.MutableInteractionSource) r13, (androidx.compose.ui.graphics.Brush) r14, (kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r15, (androidx.compose.runtime.Composer) r16, (int) r17, (int) r18, (int) r19)
            r8 = r16
            if (r86 != 0) goto L_0x0529
            if (r28 == 0) goto L_0x0529
            r4 = r45
            goto L_0x052b
        L_0x0529:
            r4 = r23
        L_0x052b:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r86)
            r1 = -320340316(0xffffffffece7fea4, float:-2.243715E27)
            r2 = r80
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r1, r2)
            boolean r1 = r8.changed((boolean) r4)
            r7 = r79
            boolean r2 = r8.changedInstance(r7)
            r1 = r1 | r2
            java.lang.Object r2 = r8.rememberedValue()
            if (r1 != 0) goto L_0x0550
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r2 != r1) goto L_0x055c
        L_0x0550:
            androidx.compose.material3.SearchBarDefaults$InputField$5$1 r1 = new androidx.compose.material3.SearchBarDefaults$InputField$5$1
            r11 = 0
            r1.<init>(r4, r7, r11)
            r2 = r1
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r8.updateRememberedValue(r2)
        L_0x055c:
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r1 = r21 & 14
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r0, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r2, (androidx.compose.runtime.Composer) r8, (int) r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x056f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x056f:
            r36 = r8
            r13 = r20
            r7 = r22
            r12 = r25
            r9 = r42
            r10 = r43
            r11 = r44
            r8 = r3
        L_0x057e:
            androidx.compose.runtime.ScopeUpdateScope r0 = r36.endRestartGroup()
            if (r0 == 0) goto L_0x05a5
            r1 = r0
            androidx.compose.material3.SearchBarDefaults$InputField$6 r0 = new androidx.compose.material3.SearchBarDefaults$InputField$6
            r2 = r83
            r3 = r84
            r4 = r85
            r5 = r86
            r6 = r87
            r14 = r96
            r15 = r97
            r16 = r98
            r81 = r1
            r1 = r82
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r81
            r1.updateScope(r0)
        L_0x05a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBarDefaults.InputField(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    @Deprecated(message = "Search bars now take the input field as a parameter. `inputFieldColors` should be passed explicitly to the input field. This parameter will be removed in a future version of the library.", replaceWith = @ReplaceWith(expression = "colors(containerColor, dividerColor)", imports = {}))
    /* renamed from: colors-Klgx-Pg  reason: not valid java name */
    public final SearchBarColors m2398colorsKlgxPg(long j, long j2, TextFieldColors textFieldColors, Composer composer, int i, int i2) {
        TextFieldColors textFieldColors2;
        int i3;
        Composer composer2 = composer;
        ComposerKt.sourceInformationMarkerStart(composer2, -1216168196, "C(colors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color)586@27706L5,587@27773L5,588@27824L18:SearchBar.android.kt#uh7d8r");
        long value = (i2 & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), composer2, 6) : j;
        long value2 = (i2 & 2) != 0 ? ColorSchemeKt.getValue(SearchViewTokens.INSTANCE.getDividerColor(), composer2, 6) : j2;
        if ((i2 & 4) != 0) {
            Composer composer3 = composer2;
            i3 = i;
            textFieldColors2 = m2405inputFieldColorsITpI4ow(0, 0, 0, 0, (TextSelectionColors) null, 0, 0, 0, 0, 0, 0, 0, 0, 0, composer3, 0, (i << 3) & 57344, 16383);
        } else {
            i3 = i;
            textFieldColors2 = textFieldColors;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1216168196, i3, -1, "androidx.compose.material3.SearchBarDefaults.colors (SearchBar.android.kt:590)");
        }
        SearchBarColors searchBarColors = new SearchBarColors(value, value2, textFieldColors2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return searchBarColors;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: inputFieldColors--u-KgnY  reason: not valid java name */
    public final /* synthetic */ TextFieldColors m2404inputFieldColorsuKgnY(long j, long j2, long j3, TextSelectionColors textSelectionColors, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, Composer composer, int i, int i2, int i3) {
        TextSelectionColors textSelectionColors2;
        Composer composer2 = composer;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ComposerKt.sourceInformationMarkerStart(composer2, 355927049, "C(inputFieldColors)P(9:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,8,5:c#ui.graphics.Color,10:c#ui.graphics.Color,1:c#ui.graphics.Color,6:c#ui.graphics.Color,11:c#ui.graphics.Color,4:c#ui.graphics.Color,7:c#ui.graphics.Color,2:c#ui.graphics.Color)599@28228L5,601@28323L5,604@28479L5,605@28558L7,606@28641L5,607@28724L5,609@28832L5,612@29008L5,613@29093L5,615@29203L5,618@29374L5,620@29476L5,624@29586L825:SearchBar.android.kt#uh7d8r");
        long value = (i6 & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), composer2, 6) : j;
        long r9 = (i6 & 2) != 0 ? Color.m4238copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer2, 6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j2;
        long value2 = (i6 & 4) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getCaretColor(), composer2, 6) : j3;
        if ((i6 & 8) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer2);
            textSelectionColors2 = (TextSelectionColors) consume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        long value3 = (i6 & 16) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), composer2, 6) : j4;
        long value4 = (i6 & 32) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), composer2, 6) : j5;
        long r19 = (i6 & 64) != 0 ? Color.m4238copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), composer2, 6), FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j6;
        long value5 = (i6 & 128) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), composer2, 6) : j7;
        long value6 = (i6 & 256) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), composer2, 6) : j8;
        long r25 = (i6 & 512) != 0 ? Color.m4238copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), composer2, 6), FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j9;
        long value7 = (i6 & 1024) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), composer2, 6) : j10;
        long r29 = (i6 & 2048) != 0 ? Color.m4238copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer2, 6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j11;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(355927049, i4, i5, "androidx.compose.material3.SearchBarDefaults.inputFieldColors (SearchBar.android.kt:624)");
        }
        int i7 = i4 << 3;
        int i8 = i5 << 6;
        int i9 = ((i4 >> 27) & 14) | ((i5 << 3) & 112) | (i8 & 896) | (i8 & 7168) | (i8 & 57344);
        long j12 = value;
        long j13 = value2;
        long j14 = value3;
        long j15 = value4;
        long j16 = r19;
        long j17 = value6;
        long j18 = value7;
        TextFieldColors r0 = m2405inputFieldColorsITpI4ow(j12, j12, r9, j13, textSelectionColors2, j14, j15, j16, value5, j17, r25, j18, j18, r29, composer2, (i4 & 14) | (i7 & 112) | (i7 & 896) | (i7 & 7168) | (i7 & 57344) | (i7 & 458752) | (i7 & 3670016) | (i7 & 29360128) | (i7 & 234881024) | (i7 & 1879048192), i9, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return r0;
    }
}
