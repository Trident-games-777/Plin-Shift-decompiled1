package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteAllCommand;
import androidx.compose.ui.text.input.FinishComposingTextCommand;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.input.TransformedText;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoreTextField.kt */
final class CoreTextFieldKt$CoreTextField$semanticsModifier$1$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ ImeOptions $imeOptions;
    final /* synthetic */ boolean $isPassword;
    final /* synthetic */ TextFieldSelectionManager $manager;
    final /* synthetic */ OffsetMapping $offsetMapping;
    final /* synthetic */ boolean $readOnly;
    final /* synthetic */ LegacyTextFieldState $state;
    final /* synthetic */ TransformedText $transformedText;
    final /* synthetic */ TextFieldValue $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$semanticsModifier$1$1(TransformedText transformedText, TextFieldValue textFieldValue, boolean z, boolean z2, boolean z3, ImeOptions imeOptions, LegacyTextFieldState legacyTextFieldState, OffsetMapping offsetMapping, TextFieldSelectionManager textFieldSelectionManager, FocusRequester focusRequester) {
        super(1);
        this.$transformedText = transformedText;
        this.$value = textFieldValue;
        this.$enabled = z;
        this.$isPassword = z2;
        this.$readOnly = z3;
        this.$imeOptions = imeOptions;
        this.$state = legacyTextFieldState;
        this.$offsetMapping = offsetMapping;
        this.$manager = textFieldSelectionManager;
        this.$focusRequester = focusRequester;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(final SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertyReceiver semanticsPropertyReceiver2 = semanticsPropertyReceiver;
        SemanticsPropertiesKt.setEditableText(semanticsPropertyReceiver, this.$transformedText.getText());
        SemanticsPropertiesKt.m6387setTextSelectionRangeFDrldGo(semanticsPropertyReceiver, this.$value.m6823getSelectiond9O1mEE());
        if (!this.$enabled) {
            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
        }
        if (this.$isPassword) {
            SemanticsPropertiesKt.password(semanticsPropertyReceiver);
        }
        boolean z = this.$enabled && !this.$readOnly;
        SemanticsPropertiesKt.setEditable(semanticsPropertyReceiver, z);
        final LegacyTextFieldState legacyTextFieldState = this.$state;
        SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, (String) null, new Function1<List<TextLayoutResult>, Boolean>() {
            public final Boolean invoke(List<TextLayoutResult> list) {
                boolean z;
                if (legacyTextFieldState.getLayoutResult() != null) {
                    TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                    Intrinsics.checkNotNull(layoutResult);
                    list.add(layoutResult.getValue());
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        }, 1, (Object) null);
        if (z) {
            final LegacyTextFieldState legacyTextFieldState2 = this.$state;
            SemanticsPropertiesKt.setText$default(semanticsPropertyReceiver, (String) null, new Function1<AnnotatedString, Boolean>() {
                public final Boolean invoke(AnnotatedString annotatedString) {
                    Unit unit;
                    TextInputSession inputSession = legacyTextFieldState2.getInputSession();
                    if (inputSession != null) {
                        LegacyTextFieldState legacyTextFieldState = legacyTextFieldState2;
                        TextFieldDelegate.Companion.onEditCommand$foundation_release(CollectionsKt.listOf(new DeleteAllCommand(), new CommitTextCommand(annotatedString, 1)), legacyTextFieldState.getProcessor(), legacyTextFieldState.getOnValueChange(), inputSession);
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        legacyTextFieldState2.getOnValueChange().invoke(new TextFieldValue(annotatedString.getText(), TextRangeKt.TextRange(annotatedString.getText().length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                    }
                    return true;
                }
            }, 1, (Object) null);
            final boolean z2 = this.$readOnly;
            final boolean z3 = this.$enabled;
            final LegacyTextFieldState legacyTextFieldState3 = this.$state;
            final TextFieldValue textFieldValue = this.$value;
            final SemanticsPropertyReceiver semanticsPropertyReceiver3 = semanticsPropertyReceiver;
            semanticsPropertyReceiver2 = semanticsPropertyReceiver3;
            SemanticsPropertiesKt.insertTextAtCursor$default(semanticsPropertyReceiver, (String) null, new Function1<AnnotatedString, Boolean>() {
                public final Boolean invoke(AnnotatedString annotatedString) {
                    Unit unit;
                    if (z2 || !z3) {
                        return false;
                    }
                    TextInputSession inputSession = legacyTextFieldState3.getInputSession();
                    if (inputSession != null) {
                        LegacyTextFieldState legacyTextFieldState = legacyTextFieldState3;
                        TextFieldDelegate.Companion.onEditCommand$foundation_release(CollectionsKt.listOf(new FinishComposingTextCommand(), new CommitTextCommand(annotatedString, 1)), legacyTextFieldState.getProcessor(), legacyTextFieldState.getOnValueChange(), inputSession);
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        TextFieldValue textFieldValue = textFieldValue;
                        legacyTextFieldState3.getOnValueChange().invoke(new TextFieldValue(StringsKt.replaceRange((CharSequence) textFieldValue.getText(), TextRange.m6564getStartimpl(textFieldValue.m6823getSelectiond9O1mEE()), TextRange.m6559getEndimpl(textFieldValue.m6823getSelectiond9O1mEE()), (CharSequence) annotatedString).toString(), TextRangeKt.TextRange(TextRange.m6564getStartimpl(textFieldValue.m6823getSelectiond9O1mEE()) + annotatedString.length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                    }
                    return true;
                }
            }, 1, (Object) null);
        }
        final OffsetMapping offsetMapping = this.$offsetMapping;
        final boolean z4 = this.$enabled;
        final TextFieldValue textFieldValue2 = this.$value;
        final TextFieldSelectionManager textFieldSelectionManager = this.$manager;
        final LegacyTextFieldState legacyTextFieldState4 = this.$state;
        SemanticsPropertiesKt.setSelection$default(semanticsPropertyReceiver, (String) null, new Function3<Integer, Integer, Boolean, Boolean>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), ((Boolean) obj3).booleanValue());
            }

            public final Boolean invoke(int i, int i2, boolean z) {
                if (!z) {
                    i = offsetMapping.transformedToOriginal(i);
                }
                if (!z) {
                    i2 = offsetMapping.transformedToOriginal(i2);
                }
                boolean z2 = false;
                if (z4 && !(i == TextRange.m6564getStartimpl(textFieldValue2.m6823getSelectiond9O1mEE()) && i2 == TextRange.m6559getEndimpl(textFieldValue2.m6823getSelectiond9O1mEE()))) {
                    if (Math.min(i, i2) < 0 || Math.max(i, i2) > textFieldValue2.getAnnotatedString().length()) {
                        textFieldSelectionManager.exitSelectionMode$foundation_release();
                    } else {
                        if (z || i == i2) {
                            textFieldSelectionManager.exitSelectionMode$foundation_release();
                        } else {
                            TextFieldSelectionManager.enterSelectionMode$foundation_release$default(textFieldSelectionManager, false, 1, (Object) null);
                        }
                        legacyTextFieldState4.getOnValueChange().invoke(new TextFieldValue(textFieldValue2.getAnnotatedString(), TextRangeKt.TextRange(i, i2), (TextRange) null, 4, (DefaultConstructorMarker) null));
                        z2 = true;
                    }
                }
                return Boolean.valueOf(z2);
            }
        }, 1, (Object) null);
        int r1 = this.$imeOptions.m6770getImeActioneUduSuo();
        final LegacyTextFieldState legacyTextFieldState5 = this.$state;
        final ImeOptions imeOptions = this.$imeOptions;
        SemanticsPropertiesKt.m6382onImeAction9UiTYpY$default(semanticsPropertyReceiver2, r1, (String) null, new Function0<Boolean>() {
            public final Boolean invoke() {
                legacyTextFieldState5.getOnImeActionPerformed().invoke(ImeAction.m6738boximpl(imeOptions.m6770getImeActioneUduSuo()));
                return true;
            }
        }, 2, (Object) null);
        final LegacyTextFieldState legacyTextFieldState6 = this.$state;
        final FocusRequester focusRequester = this.$focusRequester;
        final boolean z5 = this.$readOnly;
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() {
            public final Boolean invoke() {
                CoreTextFieldKt.tapToFocus(legacyTextFieldState6, focusRequester, !z5);
                return true;
            }
        }, 1, (Object) null);
        final TextFieldSelectionManager textFieldSelectionManager2 = this.$manager;
        SemanticsPropertiesKt.onLongClick$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() {
            public final Boolean invoke() {
                TextFieldSelectionManager.enterSelectionMode$foundation_release$default(textFieldSelectionManager2, false, 1, (Object) null);
                return true;
            }
        }, 1, (Object) null);
        if (!TextRange.m6558getCollapsedimpl(this.$value.m6823getSelectiond9O1mEE()) && !this.$isPassword) {
            final TextFieldSelectionManager textFieldSelectionManager3 = this.$manager;
            SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() {
                public final Boolean invoke() {
                    TextFieldSelectionManager.copy$foundation_release$default(textFieldSelectionManager3, false, 1, (Object) null);
                    return true;
                }
            }, 1, (Object) null);
            if (this.$enabled && !this.$readOnly) {
                final TextFieldSelectionManager textFieldSelectionManager4 = this.$manager;
                SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() {
                    public final Boolean invoke() {
                        textFieldSelectionManager4.cut$foundation_release();
                        return true;
                    }
                }, 1, (Object) null);
            }
        }
        if (this.$enabled && !this.$readOnly) {
            final TextFieldSelectionManager textFieldSelectionManager5 = this.$manager;
            SemanticsPropertiesKt.pasteText$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() {
                public final Boolean invoke() {
                    textFieldSelectionManager5.paste$foundation_release();
                    return true;
                }
            }, 1, (Object) null);
        }
    }
}
