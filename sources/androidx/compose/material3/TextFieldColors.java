package androidx.compose.material3;

import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.ui.graphics.Color;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\bQ\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001BÝ\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010&\u001a\u00020\u0003\u0012\u0006\u0010'\u001a\u00020\u0003\u0012\u0006\u0010(\u001a\u00020\u0003\u0012\u0006\u0010)\u001a\u00020\u0003\u0012\u0006\u0010*\u001a\u00020\u0003\u0012\u0006\u0010+\u001a\u00020\u0003\u0012\u0006\u0010,\u001a\u00020\u0003\u0012\u0006\u0010-\u001a\u00020\u0003\u0012\u0006\u0010.\u001a\u00020\u0003¢\u0006\u0002\u0010/J-\u0010^\u001a\u00020\u00032\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020`2\u0006\u0010b\u001a\u00020`H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bc\u0010dJÀ\u0003\u0010e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\bf\u0010gJ\u001d\u0010\u000b\u001a\u00020\u00032\u0006\u0010a\u001a\u00020`H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bh\u0010iJ\u0013\u0010j\u001a\u00020`2\b\u0010k\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010l\u001a\u00020mH\u0016J-\u0010n\u001a\u00020\u00032\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020`2\u0006\u0010b\u001a\u00020`H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bo\u0010dJ-\u0010p\u001a\u00020\u00032\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020`2\u0006\u0010b\u001a\u00020`H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bq\u0010dJ-\u0010r\u001a\u00020\u00032\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020`2\u0006\u0010b\u001a\u00020`H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bs\u0010dJ-\u0010t\u001a\u00020\u00032\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020`2\u0006\u0010b\u001a\u00020`H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bu\u0010dJ-\u0010v\u001a\u00020\u00032\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020`2\u0006\u0010b\u001a\u00020`H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bw\u0010dJ-\u0010x\u001a\u00020\u00032\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020`2\u0006\u0010b\u001a\u00020`H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\by\u0010dJ-\u0010z\u001a\u00020\u00032\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020`2\u0006\u0010b\u001a\u00020`H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b{\u0010dJ-\u0010|\u001a\u00020\u00032\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020`2\u0006\u0010b\u001a\u00020`H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b}\u0010dJ-\u0010~\u001a\u00020\u00032\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020`2\u0006\u0010b\u001a\u00020`H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010dJ%\u0010\u0001\u001a\u00020\u000e*\u0004\u0018\u00010\u000e2\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0\u0001H\u0000¢\u0006\u0003\b\u0001R\u0019\u0010\u000b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0019\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b3\u00101R\u0019\u0010\u0011\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b4\u00101R\u0019\u0010\u001d\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b5\u00101R\u0019\u0010\u0015\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b6\u00101R\u0019\u0010!\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b7\u00101R\u0019\u0010)\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b8\u00101R\u0019\u0010-\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b9\u00101R\u0019\u0010%\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b:\u00101R\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b;\u00101R\u0019\u0010\u0019\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b<\u00101R\u0019\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b=\u00101R\u0019\u0010\f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b>\u00101R\u0019\u0010\u0012\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b?\u00101R\u0019\u0010\u001e\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b@\u00101R\u0019\u0010\u0016\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bA\u00101R\u0019\u0010\"\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bB\u00101R\u0019\u0010*\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bC\u00101R\u0019\u0010.\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bD\u00101R\u0019\u0010&\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bE\u00101R\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bF\u00101R\u0019\u0010\u001a\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bG\u00101R\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bH\u00101R\u0019\u0010\u000f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bI\u00101R\u0019\u0010\u001b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bJ\u00101R\u0019\u0010\u0013\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bK\u00101R\u0019\u0010\u001f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bL\u00101R\u0019\u0010'\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bM\u00101R\u0019\u0010+\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bN\u00101R\u0019\u0010#\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bO\u00101R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bP\u00101R\u0019\u0010\u0017\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bQ\u00101R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0019\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bT\u00101R\u0019\u0010\u0010\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bU\u00101R\u0019\u0010\u001c\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bV\u00101R\u0019\u0010\u0014\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bW\u00101R\u0019\u0010 \u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bX\u00101R\u0019\u0010(\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bY\u00101R\u0019\u0010,\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\bZ\u00101R\u0019\u0010$\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b[\u00101R\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b\\\u00101R\u0019\u0010\u0018\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b]\u00101\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0001"}, d2 = {"Landroidx/compose/material3/TextFieldColors;", "", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "textSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCursorColor-0d7_KjU", "()J", "J", "getDisabledContainerColor-0d7_KjU", "getDisabledIndicatorColor-0d7_KjU", "getDisabledLabelColor-0d7_KjU", "getDisabledLeadingIconColor-0d7_KjU", "getDisabledPlaceholderColor-0d7_KjU", "getDisabledPrefixColor-0d7_KjU", "getDisabledSuffixColor-0d7_KjU", "getDisabledSupportingTextColor-0d7_KjU", "getDisabledTextColor-0d7_KjU", "getDisabledTrailingIconColor-0d7_KjU", "getErrorContainerColor-0d7_KjU", "getErrorCursorColor-0d7_KjU", "getErrorIndicatorColor-0d7_KjU", "getErrorLabelColor-0d7_KjU", "getErrorLeadingIconColor-0d7_KjU", "getErrorPlaceholderColor-0d7_KjU", "getErrorPrefixColor-0d7_KjU", "getErrorSuffixColor-0d7_KjU", "getErrorSupportingTextColor-0d7_KjU", "getErrorTextColor-0d7_KjU", "getErrorTrailingIconColor-0d7_KjU", "getFocusedContainerColor-0d7_KjU", "getFocusedIndicatorColor-0d7_KjU", "getFocusedLabelColor-0d7_KjU", "getFocusedLeadingIconColor-0d7_KjU", "getFocusedPlaceholderColor-0d7_KjU", "getFocusedPrefixColor-0d7_KjU", "getFocusedSuffixColor-0d7_KjU", "getFocusedSupportingTextColor-0d7_KjU", "getFocusedTextColor-0d7_KjU", "getFocusedTrailingIconColor-0d7_KjU", "getTextSelectionColors", "()Landroidx/compose/foundation/text/selection/TextSelectionColors;", "getUnfocusedContainerColor-0d7_KjU", "getUnfocusedIndicatorColor-0d7_KjU", "getUnfocusedLabelColor-0d7_KjU", "getUnfocusedLeadingIconColor-0d7_KjU", "getUnfocusedPlaceholderColor-0d7_KjU", "getUnfocusedPrefixColor-0d7_KjU", "getUnfocusedSuffixColor-0d7_KjU", "getUnfocusedSupportingTextColor-0d7_KjU", "getUnfocusedTextColor-0d7_KjU", "getUnfocusedTrailingIconColor-0d7_KjU", "containerColor", "enabled", "", "isError", "focused", "containerColor-XeAY9LY$material3_release", "(ZZZ)J", "copy", "copy-ejIjP34", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/TextFieldColors;", "cursorColor-vNxB06k$material3_release", "(Z)J", "equals", "other", "hashCode", "", "indicatorColor", "indicatorColor-XeAY9LY$material3_release", "labelColor", "labelColor-XeAY9LY$material3_release", "leadingIconColor", "leadingIconColor-XeAY9LY$material3_release", "placeholderColor", "placeholderColor-XeAY9LY$material3_release", "prefixColor", "prefixColor-XeAY9LY$material3_release", "suffixColor", "suffixColor-XeAY9LY$material3_release", "supportingTextColor", "supportingTextColor-XeAY9LY$material3_release", "textColor", "textColor-XeAY9LY$material3_release", "trailingIconColor", "trailingIconColor-XeAY9LY$material3_release", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDefaults.kt */
public final class TextFieldColors {
    public static final int $stable = 0;
    private final long cursorColor;
    private final long disabledContainerColor;
    private final long disabledIndicatorColor;
    private final long disabledLabelColor;
    private final long disabledLeadingIconColor;
    private final long disabledPlaceholderColor;
    private final long disabledPrefixColor;
    private final long disabledSuffixColor;
    private final long disabledSupportingTextColor;
    private final long disabledTextColor;
    private final long disabledTrailingIconColor;
    private final long errorContainerColor;
    private final long errorCursorColor;
    private final long errorIndicatorColor;
    private final long errorLabelColor;
    private final long errorLeadingIconColor;
    private final long errorPlaceholderColor;
    private final long errorPrefixColor;
    private final long errorSuffixColor;
    private final long errorSupportingTextColor;
    private final long errorTextColor;
    private final long errorTrailingIconColor;
    private final long focusedContainerColor;
    private final long focusedIndicatorColor;
    private final long focusedLabelColor;
    private final long focusedLeadingIconColor;
    private final long focusedPlaceholderColor;
    private final long focusedPrefixColor;
    private final long focusedSuffixColor;
    private final long focusedSupportingTextColor;
    private final long focusedTextColor;
    private final long focusedTrailingIconColor;
    private final TextSelectionColors textSelectionColors;
    private final long unfocusedContainerColor;
    private final long unfocusedIndicatorColor;
    private final long unfocusedLabelColor;
    private final long unfocusedLeadingIconColor;
    private final long unfocusedPlaceholderColor;
    private final long unfocusedPrefixColor;
    private final long unfocusedSuffixColor;
    private final long unfocusedSupportingTextColor;
    private final long unfocusedTextColor;
    private final long unfocusedTrailingIconColor;

    public /* synthetic */ TextFieldColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, TextSelectionColors textSelectionColors2, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, textSelectionColors2, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j31, j32, j33, j34, j35, j36, j37, j38, j39, j40, j41, j42);
    }

    private TextFieldColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, TextSelectionColors textSelectionColors2, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42) {
        this.focusedTextColor = j;
        this.unfocusedTextColor = j2;
        this.disabledTextColor = j3;
        this.errorTextColor = j4;
        this.focusedContainerColor = j5;
        this.unfocusedContainerColor = j6;
        this.disabledContainerColor = j7;
        this.errorContainerColor = j8;
        this.cursorColor = j9;
        this.errorCursorColor = j10;
        this.textSelectionColors = textSelectionColors2;
        this.focusedIndicatorColor = j11;
        this.unfocusedIndicatorColor = j12;
        this.disabledIndicatorColor = j13;
        this.errorIndicatorColor = j14;
        this.focusedLeadingIconColor = j15;
        this.unfocusedLeadingIconColor = j16;
        this.disabledLeadingIconColor = j17;
        this.errorLeadingIconColor = j18;
        this.focusedTrailingIconColor = j19;
        this.unfocusedTrailingIconColor = j20;
        this.disabledTrailingIconColor = j21;
        this.errorTrailingIconColor = j22;
        this.focusedLabelColor = j23;
        this.unfocusedLabelColor = j24;
        this.disabledLabelColor = j25;
        this.errorLabelColor = j26;
        this.focusedPlaceholderColor = j27;
        this.unfocusedPlaceholderColor = j28;
        this.disabledPlaceholderColor = j29;
        this.errorPlaceholderColor = j30;
        this.focusedSupportingTextColor = j31;
        this.unfocusedSupportingTextColor = j32;
        this.disabledSupportingTextColor = j33;
        this.errorSupportingTextColor = j34;
        this.focusedPrefixColor = j35;
        this.unfocusedPrefixColor = j36;
        this.disabledPrefixColor = j37;
        this.errorPrefixColor = j38;
        this.focusedSuffixColor = j39;
        this.unfocusedSuffixColor = j40;
        this.disabledSuffixColor = j41;
        this.errorSuffixColor = j42;
    }

    /* renamed from: getFocusedTextColor-0d7_KjU  reason: not valid java name */
    public final long m2640getFocusedTextColor0d7_KjU() {
        return this.focusedTextColor;
    }

    /* renamed from: getUnfocusedTextColor-0d7_KjU  reason: not valid java name */
    public final long m2650getUnfocusedTextColor0d7_KjU() {
        return this.unfocusedTextColor;
    }

    /* renamed from: getDisabledTextColor-0d7_KjU  reason: not valid java name */
    public final long m2619getDisabledTextColor0d7_KjU() {
        return this.disabledTextColor;
    }

    /* renamed from: getErrorTextColor-0d7_KjU  reason: not valid java name */
    public final long m2630getErrorTextColor0d7_KjU() {
        return this.errorTextColor;
    }

    /* renamed from: getFocusedContainerColor-0d7_KjU  reason: not valid java name */
    public final long m2632getFocusedContainerColor0d7_KjU() {
        return this.focusedContainerColor;
    }

    /* renamed from: getUnfocusedContainerColor-0d7_KjU  reason: not valid java name */
    public final long m2642getUnfocusedContainerColor0d7_KjU() {
        return this.unfocusedContainerColor;
    }

    /* renamed from: getDisabledContainerColor-0d7_KjU  reason: not valid java name */
    public final long m2611getDisabledContainerColor0d7_KjU() {
        return this.disabledContainerColor;
    }

    /* renamed from: getErrorContainerColor-0d7_KjU  reason: not valid java name */
    public final long m2621getErrorContainerColor0d7_KjU() {
        return this.errorContainerColor;
    }

    /* renamed from: getCursorColor-0d7_KjU  reason: not valid java name */
    public final long m2610getCursorColor0d7_KjU() {
        return this.cursorColor;
    }

    /* renamed from: getErrorCursorColor-0d7_KjU  reason: not valid java name */
    public final long m2622getErrorCursorColor0d7_KjU() {
        return this.errorCursorColor;
    }

    public final TextSelectionColors getTextSelectionColors() {
        return this.textSelectionColors;
    }

    /* renamed from: getFocusedIndicatorColor-0d7_KjU  reason: not valid java name */
    public final long m2633getFocusedIndicatorColor0d7_KjU() {
        return this.focusedIndicatorColor;
    }

    /* renamed from: getUnfocusedIndicatorColor-0d7_KjU  reason: not valid java name */
    public final long m2643getUnfocusedIndicatorColor0d7_KjU() {
        return this.unfocusedIndicatorColor;
    }

    /* renamed from: getDisabledIndicatorColor-0d7_KjU  reason: not valid java name */
    public final long m2612getDisabledIndicatorColor0d7_KjU() {
        return this.disabledIndicatorColor;
    }

    /* renamed from: getErrorIndicatorColor-0d7_KjU  reason: not valid java name */
    public final long m2623getErrorIndicatorColor0d7_KjU() {
        return this.errorIndicatorColor;
    }

    /* renamed from: getFocusedLeadingIconColor-0d7_KjU  reason: not valid java name */
    public final long m2635getFocusedLeadingIconColor0d7_KjU() {
        return this.focusedLeadingIconColor;
    }

    /* renamed from: getUnfocusedLeadingIconColor-0d7_KjU  reason: not valid java name */
    public final long m2645getUnfocusedLeadingIconColor0d7_KjU() {
        return this.unfocusedLeadingIconColor;
    }

    /* renamed from: getDisabledLeadingIconColor-0d7_KjU  reason: not valid java name */
    public final long m2614getDisabledLeadingIconColor0d7_KjU() {
        return this.disabledLeadingIconColor;
    }

    /* renamed from: getErrorLeadingIconColor-0d7_KjU  reason: not valid java name */
    public final long m2625getErrorLeadingIconColor0d7_KjU() {
        return this.errorLeadingIconColor;
    }

    /* renamed from: getFocusedTrailingIconColor-0d7_KjU  reason: not valid java name */
    public final long m2641getFocusedTrailingIconColor0d7_KjU() {
        return this.focusedTrailingIconColor;
    }

    /* renamed from: getUnfocusedTrailingIconColor-0d7_KjU  reason: not valid java name */
    public final long m2651getUnfocusedTrailingIconColor0d7_KjU() {
        return this.unfocusedTrailingIconColor;
    }

    /* renamed from: getDisabledTrailingIconColor-0d7_KjU  reason: not valid java name */
    public final long m2620getDisabledTrailingIconColor0d7_KjU() {
        return this.disabledTrailingIconColor;
    }

    /* renamed from: getErrorTrailingIconColor-0d7_KjU  reason: not valid java name */
    public final long m2631getErrorTrailingIconColor0d7_KjU() {
        return this.errorTrailingIconColor;
    }

    /* renamed from: getFocusedLabelColor-0d7_KjU  reason: not valid java name */
    public final long m2634getFocusedLabelColor0d7_KjU() {
        return this.focusedLabelColor;
    }

    /* renamed from: getUnfocusedLabelColor-0d7_KjU  reason: not valid java name */
    public final long m2644getUnfocusedLabelColor0d7_KjU() {
        return this.unfocusedLabelColor;
    }

    /* renamed from: getDisabledLabelColor-0d7_KjU  reason: not valid java name */
    public final long m2613getDisabledLabelColor0d7_KjU() {
        return this.disabledLabelColor;
    }

    /* renamed from: getErrorLabelColor-0d7_KjU  reason: not valid java name */
    public final long m2624getErrorLabelColor0d7_KjU() {
        return this.errorLabelColor;
    }

    /* renamed from: getFocusedPlaceholderColor-0d7_KjU  reason: not valid java name */
    public final long m2636getFocusedPlaceholderColor0d7_KjU() {
        return this.focusedPlaceholderColor;
    }

    /* renamed from: getUnfocusedPlaceholderColor-0d7_KjU  reason: not valid java name */
    public final long m2646getUnfocusedPlaceholderColor0d7_KjU() {
        return this.unfocusedPlaceholderColor;
    }

    /* renamed from: getDisabledPlaceholderColor-0d7_KjU  reason: not valid java name */
    public final long m2615getDisabledPlaceholderColor0d7_KjU() {
        return this.disabledPlaceholderColor;
    }

    /* renamed from: getErrorPlaceholderColor-0d7_KjU  reason: not valid java name */
    public final long m2626getErrorPlaceholderColor0d7_KjU() {
        return this.errorPlaceholderColor;
    }

    /* renamed from: getFocusedSupportingTextColor-0d7_KjU  reason: not valid java name */
    public final long m2639getFocusedSupportingTextColor0d7_KjU() {
        return this.focusedSupportingTextColor;
    }

    /* renamed from: getUnfocusedSupportingTextColor-0d7_KjU  reason: not valid java name */
    public final long m2649getUnfocusedSupportingTextColor0d7_KjU() {
        return this.unfocusedSupportingTextColor;
    }

    /* renamed from: getDisabledSupportingTextColor-0d7_KjU  reason: not valid java name */
    public final long m2618getDisabledSupportingTextColor0d7_KjU() {
        return this.disabledSupportingTextColor;
    }

    /* renamed from: getErrorSupportingTextColor-0d7_KjU  reason: not valid java name */
    public final long m2629getErrorSupportingTextColor0d7_KjU() {
        return this.errorSupportingTextColor;
    }

    /* renamed from: getFocusedPrefixColor-0d7_KjU  reason: not valid java name */
    public final long m2637getFocusedPrefixColor0d7_KjU() {
        return this.focusedPrefixColor;
    }

    /* renamed from: getUnfocusedPrefixColor-0d7_KjU  reason: not valid java name */
    public final long m2647getUnfocusedPrefixColor0d7_KjU() {
        return this.unfocusedPrefixColor;
    }

    /* renamed from: getDisabledPrefixColor-0d7_KjU  reason: not valid java name */
    public final long m2616getDisabledPrefixColor0d7_KjU() {
        return this.disabledPrefixColor;
    }

    /* renamed from: getErrorPrefixColor-0d7_KjU  reason: not valid java name */
    public final long m2627getErrorPrefixColor0d7_KjU() {
        return this.errorPrefixColor;
    }

    /* renamed from: getFocusedSuffixColor-0d7_KjU  reason: not valid java name */
    public final long m2638getFocusedSuffixColor0d7_KjU() {
        return this.focusedSuffixColor;
    }

    /* renamed from: getUnfocusedSuffixColor-0d7_KjU  reason: not valid java name */
    public final long m2648getUnfocusedSuffixColor0d7_KjU() {
        return this.unfocusedSuffixColor;
    }

    /* renamed from: getDisabledSuffixColor-0d7_KjU  reason: not valid java name */
    public final long m2617getDisabledSuffixColor0d7_KjU() {
        return this.disabledSuffixColor;
    }

    /* renamed from: getErrorSuffixColor-0d7_KjU  reason: not valid java name */
    public final long m2628getErrorSuffixColor0d7_KjU() {
        return this.errorSuffixColor;
    }

    /* renamed from: copy-ejIjP34$default  reason: not valid java name */
    public static /* synthetic */ TextFieldColors m2606copyejIjP34$default(TextFieldColors textFieldColors, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, TextSelectionColors textSelectionColors2, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, int i, int i2, Object obj) {
        long j43;
        long j44;
        long j45;
        TextFieldColors textFieldColors2 = textFieldColors;
        int i3 = i;
        int i4 = i2;
        long j46 = (i3 & 1) != 0 ? textFieldColors2.focusedTextColor : j;
        long j47 = (i3 & 2) != 0 ? textFieldColors2.unfocusedTextColor : j2;
        long j48 = (i3 & 4) != 0 ? textFieldColors2.disabledTextColor : j3;
        long j49 = (i3 & 8) != 0 ? textFieldColors2.errorTextColor : j4;
        long j50 = (i3 & 16) != 0 ? textFieldColors2.focusedContainerColor : j5;
        long j51 = (i3 & 32) != 0 ? textFieldColors2.unfocusedContainerColor : j6;
        if ((i3 & 64) != 0) {
            j43 = j46;
            j44 = textFieldColors2.disabledContainerColor;
        } else {
            j43 = j46;
            j44 = j7;
        }
        long j52 = j44;
        long j53 = (i3 & 128) != 0 ? textFieldColors2.errorContainerColor : j8;
        long j54 = (i3 & 256) != 0 ? textFieldColors2.cursorColor : j9;
        long j55 = (i3 & 512) != 0 ? textFieldColors2.errorCursorColor : j10;
        TextSelectionColors textSelectionColors3 = (i3 & 1024) != 0 ? textFieldColors2.textSelectionColors : textSelectionColors2;
        long j56 = (i3 & 2048) != 0 ? textFieldColors2.focusedIndicatorColor : j11;
        long j57 = (i3 & 4096) != 0 ? textFieldColors2.unfocusedIndicatorColor : j12;
        long j58 = (i3 & 8192) != 0 ? textFieldColors2.disabledIndicatorColor : j13;
        long j59 = (i3 & 16384) != 0 ? textFieldColors2.errorIndicatorColor : j14;
        long j60 = (i3 & 32768) != 0 ? textFieldColors2.focusedLeadingIconColor : j15;
        long j61 = (i3 & 65536) != 0 ? textFieldColors2.unfocusedLeadingIconColor : j16;
        long j62 = (i3 & 131072) != 0 ? textFieldColors2.disabledLeadingIconColor : j17;
        long j63 = (i3 & 262144) != 0 ? textFieldColors2.errorLeadingIconColor : j18;
        long j64 = (i3 & 524288) != 0 ? textFieldColors2.focusedTrailingIconColor : j19;
        long j65 = (i3 & 1048576) != 0 ? textFieldColors2.unfocusedTrailingIconColor : j20;
        long j66 = (i3 & 2097152) != 0 ? textFieldColors2.disabledTrailingIconColor : j21;
        long j67 = (i3 & 4194304) != 0 ? textFieldColors2.errorTrailingIconColor : j22;
        long j68 = (i3 & 8388608) != 0 ? textFieldColors2.focusedLabelColor : j23;
        long j69 = (i3 & 16777216) != 0 ? textFieldColors2.unfocusedLabelColor : j24;
        long j70 = (i3 & 33554432) != 0 ? textFieldColors2.disabledLabelColor : j25;
        long j71 = (i3 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? textFieldColors2.errorLabelColor : j26;
        long j72 = (i3 & 134217728) != 0 ? textFieldColors2.focusedPlaceholderColor : j27;
        long j73 = (i3 & 268435456) != 0 ? textFieldColors2.unfocusedPlaceholderColor : j28;
        long j74 = (i3 & 536870912) != 0 ? textFieldColors2.disabledPlaceholderColor : j29;
        long j75 = (i3 & 1073741824) != 0 ? textFieldColors2.errorPlaceholderColor : j30;
        long j76 = (i3 & Integer.MIN_VALUE) != 0 ? textFieldColors2.focusedSupportingTextColor : j31;
        long j77 = (i4 & 1) != 0 ? textFieldColors2.unfocusedSupportingTextColor : j32;
        long j78 = (i4 & 2) != 0 ? textFieldColors2.disabledSupportingTextColor : j33;
        long j79 = (i4 & 4) != 0 ? textFieldColors2.errorSupportingTextColor : j34;
        long j80 = (i4 & 8) != 0 ? textFieldColors2.focusedPrefixColor : j35;
        long j81 = (i4 & 16) != 0 ? textFieldColors2.unfocusedPrefixColor : j36;
        long j82 = (i4 & 32) != 0 ? textFieldColors2.disabledPrefixColor : j37;
        long j83 = (i4 & 64) != 0 ? textFieldColors2.errorPrefixColor : j38;
        long j84 = (i4 & 128) != 0 ? textFieldColors2.focusedSuffixColor : j39;
        long j85 = (i4 & 256) != 0 ? textFieldColors2.unfocusedSuffixColor : j40;
        long j86 = (i4 & 512) != 0 ? textFieldColors2.disabledSuffixColor : j41;
        if ((i4 & 1024) != 0) {
            j45 = textFieldColors2.errorSuffixColor;
        } else {
            j45 = j42;
        }
        return textFieldColors2.m2608copyejIjP34(j43, j47, j48, j49, j50, j51, j52, j53, j54, j55, textSelectionColors3, j56, j57, j58, j59, j60, j61, j62, j63, j64, j65, j66, j67, j68, j69, j70, j71, j72, j73, j74, j75, j76, j77, j78, j79, j80, j81, j82, j83, j84, j85, j86, j45);
    }

    /* renamed from: copy-ejIjP34  reason: not valid java name */
    public final TextFieldColors m2608copyejIjP34(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, TextSelectionColors textSelectionColors2, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42) {
        long j43;
        long j44;
        long j45;
        long j46;
        long j47;
        long j48;
        long j49;
        long j50;
        long j51;
        long j52;
        long j53;
        long j54;
        long j55;
        long j56;
        long j57;
        long j58;
        long j59;
        long j60;
        long j61;
        long j62;
        long j63;
        long j64;
        long j65;
        long j66;
        long j67;
        long j68;
        long j69;
        long j70;
        long j71;
        long j72;
        long j73;
        long j74;
        long j75;
        long j76;
        long j77;
        long j78;
        long j79;
        long j80;
        long j81;
        long j82;
        long j83;
        long j84 = j != 16 ? j : this.focusedTextColor;
        if (j2 != 16) {
            j43 = j2;
        } else {
            j43 = this.unfocusedTextColor;
        }
        if (j3 != 16) {
            j44 = j3;
        } else {
            j44 = this.disabledTextColor;
        }
        if (j4 != 16) {
            j45 = j4;
        } else {
            j45 = this.errorTextColor;
        }
        if (j5 != 16) {
            j46 = j5;
        } else {
            j46 = this.focusedContainerColor;
        }
        if (j6 != 16) {
            j47 = j6;
        } else {
            j47 = this.unfocusedContainerColor;
        }
        if (j7 != 16) {
            j48 = j7;
        } else {
            j48 = this.disabledContainerColor;
        }
        if (j8 != 16) {
            j49 = j8;
        } else {
            j49 = this.errorContainerColor;
        }
        if (j9 != 16) {
            j50 = j9;
        } else {
            j50 = this.cursorColor;
        }
        if (j10 != 16) {
            j51 = j10;
        } else {
            j51 = this.errorCursorColor;
        }
        TextSelectionColors takeOrElse$material3_release = takeOrElse$material3_release(textSelectionColors2, new TextFieldColors$copy$11(this));
        if (j11 != 16) {
            j52 = j11;
        } else {
            j52 = this.focusedIndicatorColor;
        }
        if (j12 != 16) {
            j53 = j12;
        } else {
            j53 = this.unfocusedIndicatorColor;
        }
        if (j13 != 16) {
            j54 = j13;
        } else {
            j54 = this.disabledIndicatorColor;
        }
        if (j14 != 16) {
            j55 = j14;
        } else {
            j55 = this.errorIndicatorColor;
        }
        if (j15 != 16) {
            j56 = j15;
        } else {
            j56 = this.focusedLeadingIconColor;
        }
        if (j16 != 16) {
            j57 = j16;
        } else {
            j57 = this.unfocusedLeadingIconColor;
        }
        if (j17 != 16) {
            j58 = j17;
        } else {
            j58 = this.disabledLeadingIconColor;
        }
        if (j18 != 16) {
            j59 = j18;
        } else {
            j59 = this.errorLeadingIconColor;
        }
        if (j19 != 16) {
            j60 = j19;
        } else {
            j60 = this.focusedTrailingIconColor;
        }
        if (j20 != 16) {
            j61 = j20;
        } else {
            j61 = this.unfocusedTrailingIconColor;
        }
        if (j21 != 16) {
            j62 = j21;
        } else {
            j62 = this.disabledTrailingIconColor;
        }
        if (j22 != 16) {
            j63 = j22;
        } else {
            j63 = this.errorTrailingIconColor;
        }
        if (j23 != 16) {
            j64 = j23;
        } else {
            j64 = this.focusedLabelColor;
        }
        if (j24 != 16) {
            j65 = j24;
        } else {
            j65 = this.unfocusedLabelColor;
        }
        if (j25 != 16) {
            j66 = j25;
        } else {
            j66 = this.disabledLabelColor;
        }
        if (j26 != 16) {
            j67 = j26;
        } else {
            j67 = this.errorLabelColor;
        }
        if (j27 != 16) {
            j68 = j27;
        } else {
            j68 = this.focusedPlaceholderColor;
        }
        if (j28 != 16) {
            j69 = j28;
        } else {
            j69 = this.unfocusedPlaceholderColor;
        }
        if (j29 != 16) {
            j70 = j29;
        } else {
            j70 = this.disabledPlaceholderColor;
        }
        if (j30 != 16) {
            j71 = j30;
        } else {
            j71 = this.errorPlaceholderColor;
        }
        if (j31 != 16) {
            j72 = j31;
        } else {
            j72 = this.focusedSupportingTextColor;
        }
        if (j32 != 16) {
            j73 = j32;
        } else {
            j73 = this.unfocusedSupportingTextColor;
        }
        if (j33 != 16) {
            j74 = j33;
        } else {
            j74 = this.disabledSupportingTextColor;
        }
        if (j34 != 16) {
            j75 = j34;
        } else {
            j75 = this.errorSupportingTextColor;
        }
        if (j35 != 16) {
            j76 = j35;
        } else {
            j76 = this.focusedPrefixColor;
        }
        if (j36 != 16) {
            j77 = j36;
        } else {
            j77 = this.unfocusedPrefixColor;
        }
        if (j37 != 16) {
            j78 = j37;
        } else {
            j78 = this.disabledPrefixColor;
        }
        if (j38 != 16) {
            j79 = j38;
        } else {
            j79 = this.errorPrefixColor;
        }
        if (j39 != 16) {
            j80 = j39;
        } else {
            j80 = this.focusedSuffixColor;
        }
        if (j40 != 16) {
            j81 = j40;
        } else {
            j81 = this.unfocusedSuffixColor;
        }
        if (j41 != 16) {
            j82 = j41;
        } else {
            j82 = this.disabledSuffixColor;
        }
        if (j42 != 16) {
            j83 = j42;
        } else {
            j83 = this.errorSuffixColor;
        }
        return new TextFieldColors(j84, j43, j44, j45, j46, j47, j48, j49, j50, j51, takeOrElse$material3_release, j52, j53, j54, j55, j56, j57, j58, j59, j60, j61, j62, j63, j64, j65, j66, j67, j68, j69, j70, j71, j72, j73, j74, j75, j76, j77, j78, j79, j80, j81, j82, j83, (DefaultConstructorMarker) null);
    }

    public final TextSelectionColors takeOrElse$material3_release(TextSelectionColors textSelectionColors2, Function0<TextSelectionColors> function0) {
        return textSelectionColors2 == null ? function0.invoke() : textSelectionColors2;
    }

    /* renamed from: leadingIconColor-XeAY9LY$material3_release  reason: not valid java name */
    public final long m2654leadingIconColorXeAY9LY$material3_release(boolean z, boolean z2, boolean z3) {
        if (!z) {
            return this.disabledLeadingIconColor;
        }
        if (z2) {
            return this.errorLeadingIconColor;
        }
        if (z3) {
            return this.focusedLeadingIconColor;
        }
        return this.unfocusedLeadingIconColor;
    }

    /* renamed from: trailingIconColor-XeAY9LY$material3_release  reason: not valid java name */
    public final long m2660trailingIconColorXeAY9LY$material3_release(boolean z, boolean z2, boolean z3) {
        if (!z) {
            return this.disabledTrailingIconColor;
        }
        if (z2) {
            return this.errorTrailingIconColor;
        }
        if (z3) {
            return this.focusedTrailingIconColor;
        }
        return this.unfocusedTrailingIconColor;
    }

    /* renamed from: indicatorColor-XeAY9LY$material3_release  reason: not valid java name */
    public final long m2652indicatorColorXeAY9LY$material3_release(boolean z, boolean z2, boolean z3) {
        if (!z) {
            return this.disabledIndicatorColor;
        }
        if (z2) {
            return this.errorIndicatorColor;
        }
        if (z3) {
            return this.focusedIndicatorColor;
        }
        return this.unfocusedIndicatorColor;
    }

    /* renamed from: containerColor-XeAY9LY$material3_release  reason: not valid java name */
    public final long m2607containerColorXeAY9LY$material3_release(boolean z, boolean z2, boolean z3) {
        if (!z) {
            return this.disabledContainerColor;
        }
        if (z2) {
            return this.errorContainerColor;
        }
        if (z3) {
            return this.focusedContainerColor;
        }
        return this.unfocusedContainerColor;
    }

    /* renamed from: placeholderColor-XeAY9LY$material3_release  reason: not valid java name */
    public final long m2655placeholderColorXeAY9LY$material3_release(boolean z, boolean z2, boolean z3) {
        if (!z) {
            return this.disabledPlaceholderColor;
        }
        if (z2) {
            return this.errorPlaceholderColor;
        }
        if (z3) {
            return this.focusedPlaceholderColor;
        }
        return this.unfocusedPlaceholderColor;
    }

    /* renamed from: labelColor-XeAY9LY$material3_release  reason: not valid java name */
    public final long m2653labelColorXeAY9LY$material3_release(boolean z, boolean z2, boolean z3) {
        if (!z) {
            return this.disabledLabelColor;
        }
        if (z2) {
            return this.errorLabelColor;
        }
        if (z3) {
            return this.focusedLabelColor;
        }
        return this.unfocusedLabelColor;
    }

    /* renamed from: textColor-XeAY9LY$material3_release  reason: not valid java name */
    public final long m2659textColorXeAY9LY$material3_release(boolean z, boolean z2, boolean z3) {
        if (!z) {
            return this.disabledTextColor;
        }
        if (z2) {
            return this.errorTextColor;
        }
        if (z3) {
            return this.focusedTextColor;
        }
        return this.unfocusedTextColor;
    }

    /* renamed from: supportingTextColor-XeAY9LY$material3_release  reason: not valid java name */
    public final long m2658supportingTextColorXeAY9LY$material3_release(boolean z, boolean z2, boolean z3) {
        if (!z) {
            return this.disabledSupportingTextColor;
        }
        if (z2) {
            return this.errorSupportingTextColor;
        }
        if (z3) {
            return this.focusedSupportingTextColor;
        }
        return this.unfocusedSupportingTextColor;
    }

    /* renamed from: prefixColor-XeAY9LY$material3_release  reason: not valid java name */
    public final long m2656prefixColorXeAY9LY$material3_release(boolean z, boolean z2, boolean z3) {
        if (!z) {
            return this.disabledPrefixColor;
        }
        if (z2) {
            return this.errorPrefixColor;
        }
        if (z3) {
            return this.focusedPrefixColor;
        }
        return this.unfocusedPrefixColor;
    }

    /* renamed from: suffixColor-XeAY9LY$material3_release  reason: not valid java name */
    public final long m2657suffixColorXeAY9LY$material3_release(boolean z, boolean z2, boolean z3) {
        if (!z) {
            return this.disabledSuffixColor;
        }
        if (z2) {
            return this.errorSuffixColor;
        }
        if (z3) {
            return this.focusedSuffixColor;
        }
        return this.unfocusedSuffixColor;
    }

    /* renamed from: cursorColor-vNxB06k$material3_release  reason: not valid java name */
    public final long m2609cursorColorvNxB06k$material3_release(boolean z) {
        return z ? this.errorCursorColor : this.cursorColor;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof TextFieldColors)) {
            return false;
        }
        TextFieldColors textFieldColors = (TextFieldColors) obj;
        return Color.m4240equalsimpl0(this.focusedTextColor, textFieldColors.focusedTextColor) && Color.m4240equalsimpl0(this.unfocusedTextColor, textFieldColors.unfocusedTextColor) && Color.m4240equalsimpl0(this.disabledTextColor, textFieldColors.disabledTextColor) && Color.m4240equalsimpl0(this.errorTextColor, textFieldColors.errorTextColor) && Color.m4240equalsimpl0(this.focusedContainerColor, textFieldColors.focusedContainerColor) && Color.m4240equalsimpl0(this.unfocusedContainerColor, textFieldColors.unfocusedContainerColor) && Color.m4240equalsimpl0(this.disabledContainerColor, textFieldColors.disabledContainerColor) && Color.m4240equalsimpl0(this.errorContainerColor, textFieldColors.errorContainerColor) && Color.m4240equalsimpl0(this.cursorColor, textFieldColors.cursorColor) && Color.m4240equalsimpl0(this.errorCursorColor, textFieldColors.errorCursorColor) && Intrinsics.areEqual((Object) this.textSelectionColors, (Object) textFieldColors.textSelectionColors) && Color.m4240equalsimpl0(this.focusedIndicatorColor, textFieldColors.focusedIndicatorColor) && Color.m4240equalsimpl0(this.unfocusedIndicatorColor, textFieldColors.unfocusedIndicatorColor) && Color.m4240equalsimpl0(this.disabledIndicatorColor, textFieldColors.disabledIndicatorColor) && Color.m4240equalsimpl0(this.errorIndicatorColor, textFieldColors.errorIndicatorColor) && Color.m4240equalsimpl0(this.focusedLeadingIconColor, textFieldColors.focusedLeadingIconColor) && Color.m4240equalsimpl0(this.unfocusedLeadingIconColor, textFieldColors.unfocusedLeadingIconColor) && Color.m4240equalsimpl0(this.disabledLeadingIconColor, textFieldColors.disabledLeadingIconColor) && Color.m4240equalsimpl0(this.errorLeadingIconColor, textFieldColors.errorLeadingIconColor) && Color.m4240equalsimpl0(this.focusedTrailingIconColor, textFieldColors.focusedTrailingIconColor) && Color.m4240equalsimpl0(this.unfocusedTrailingIconColor, textFieldColors.unfocusedTrailingIconColor) && Color.m4240equalsimpl0(this.disabledTrailingIconColor, textFieldColors.disabledTrailingIconColor) && Color.m4240equalsimpl0(this.errorTrailingIconColor, textFieldColors.errorTrailingIconColor) && Color.m4240equalsimpl0(this.focusedLabelColor, textFieldColors.focusedLabelColor) && Color.m4240equalsimpl0(this.unfocusedLabelColor, textFieldColors.unfocusedLabelColor) && Color.m4240equalsimpl0(this.disabledLabelColor, textFieldColors.disabledLabelColor) && Color.m4240equalsimpl0(this.errorLabelColor, textFieldColors.errorLabelColor) && Color.m4240equalsimpl0(this.focusedPlaceholderColor, textFieldColors.focusedPlaceholderColor) && Color.m4240equalsimpl0(this.unfocusedPlaceholderColor, textFieldColors.unfocusedPlaceholderColor) && Color.m4240equalsimpl0(this.disabledPlaceholderColor, textFieldColors.disabledPlaceholderColor) && Color.m4240equalsimpl0(this.errorPlaceholderColor, textFieldColors.errorPlaceholderColor) && Color.m4240equalsimpl0(this.focusedSupportingTextColor, textFieldColors.focusedSupportingTextColor) && Color.m4240equalsimpl0(this.unfocusedSupportingTextColor, textFieldColors.unfocusedSupportingTextColor) && Color.m4240equalsimpl0(this.disabledSupportingTextColor, textFieldColors.disabledSupportingTextColor) && Color.m4240equalsimpl0(this.errorSupportingTextColor, textFieldColors.errorSupportingTextColor) && Color.m4240equalsimpl0(this.focusedPrefixColor, textFieldColors.focusedPrefixColor) && Color.m4240equalsimpl0(this.unfocusedPrefixColor, textFieldColors.unfocusedPrefixColor) && Color.m4240equalsimpl0(this.disabledPrefixColor, textFieldColors.disabledPrefixColor) && Color.m4240equalsimpl0(this.errorPrefixColor, textFieldColors.errorPrefixColor) && Color.m4240equalsimpl0(this.focusedSuffixColor, textFieldColors.focusedSuffixColor) && Color.m4240equalsimpl0(this.unfocusedSuffixColor, textFieldColors.unfocusedSuffixColor) && Color.m4240equalsimpl0(this.disabledSuffixColor, textFieldColors.disabledSuffixColor) && Color.m4240equalsimpl0(this.errorSuffixColor, textFieldColors.errorSuffixColor);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((Color.m4246hashCodeimpl(this.focusedTextColor) * 31) + Color.m4246hashCodeimpl(this.unfocusedTextColor)) * 31) + Color.m4246hashCodeimpl(this.disabledTextColor)) * 31) + Color.m4246hashCodeimpl(this.errorTextColor)) * 31) + Color.m4246hashCodeimpl(this.focusedContainerColor)) * 31) + Color.m4246hashCodeimpl(this.unfocusedContainerColor)) * 31) + Color.m4246hashCodeimpl(this.disabledContainerColor)) * 31) + Color.m4246hashCodeimpl(this.errorContainerColor)) * 31) + Color.m4246hashCodeimpl(this.cursorColor)) * 31) + Color.m4246hashCodeimpl(this.errorCursorColor)) * 31) + this.textSelectionColors.hashCode()) * 31) + Color.m4246hashCodeimpl(this.focusedIndicatorColor)) * 31) + Color.m4246hashCodeimpl(this.unfocusedIndicatorColor)) * 31) + Color.m4246hashCodeimpl(this.disabledIndicatorColor)) * 31) + Color.m4246hashCodeimpl(this.errorIndicatorColor)) * 31) + Color.m4246hashCodeimpl(this.focusedLeadingIconColor)) * 31) + Color.m4246hashCodeimpl(this.unfocusedLeadingIconColor)) * 31) + Color.m4246hashCodeimpl(this.disabledLeadingIconColor)) * 31) + Color.m4246hashCodeimpl(this.errorLeadingIconColor)) * 31) + Color.m4246hashCodeimpl(this.focusedTrailingIconColor)) * 31) + Color.m4246hashCodeimpl(this.unfocusedTrailingIconColor)) * 31) + Color.m4246hashCodeimpl(this.disabledTrailingIconColor)) * 31) + Color.m4246hashCodeimpl(this.errorTrailingIconColor)) * 31) + Color.m4246hashCodeimpl(this.focusedLabelColor)) * 31) + Color.m4246hashCodeimpl(this.unfocusedLabelColor)) * 31) + Color.m4246hashCodeimpl(this.disabledLabelColor)) * 31) + Color.m4246hashCodeimpl(this.errorLabelColor)) * 31) + Color.m4246hashCodeimpl(this.focusedPlaceholderColor)) * 31) + Color.m4246hashCodeimpl(this.unfocusedPlaceholderColor)) * 31) + Color.m4246hashCodeimpl(this.disabledPlaceholderColor)) * 31) + Color.m4246hashCodeimpl(this.errorPlaceholderColor)) * 31) + Color.m4246hashCodeimpl(this.focusedSupportingTextColor)) * 31) + Color.m4246hashCodeimpl(this.unfocusedSupportingTextColor)) * 31) + Color.m4246hashCodeimpl(this.disabledSupportingTextColor)) * 31) + Color.m4246hashCodeimpl(this.errorSupportingTextColor)) * 31) + Color.m4246hashCodeimpl(this.focusedPrefixColor)) * 31) + Color.m4246hashCodeimpl(this.unfocusedPrefixColor)) * 31) + Color.m4246hashCodeimpl(this.disabledPrefixColor)) * 31) + Color.m4246hashCodeimpl(this.errorPrefixColor)) * 31) + Color.m4246hashCodeimpl(this.focusedSuffixColor)) * 31) + Color.m4246hashCodeimpl(this.unfocusedSuffixColor)) * 31) + Color.m4246hashCodeimpl(this.disabledSuffixColor)) * 31) + Color.m4246hashCodeimpl(this.errorSuffixColor);
    }
}
