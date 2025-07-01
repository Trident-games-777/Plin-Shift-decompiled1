package androidx.compose.foundation.text;

import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\b"}, d2 = {"androidx/compose/foundation/text/KeyMappingKt$commonKeyMapping$1", "Landroidx/compose/foundation/text/KeyMapping;", "map", "Landroidx/compose/foundation/text/KeyCommand;", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "map-ZmokQxo", "(Landroid/view/KeyEvent;)Landroidx/compose/foundation/text/KeyCommand;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: KeyMapping.kt */
public final class KeyMappingKt$commonKeyMapping$1 implements KeyMapping {
    final /* synthetic */ Function1<KeyEvent, Boolean> $shortcutModifier;

    KeyMappingKt$commonKeyMapping$1(Function1<? super KeyEvent, Boolean> function1) {
        this.$shortcutModifier = function1;
    }

    /* renamed from: map-ZmokQxo  reason: not valid java name */
    public KeyCommand m1191mapZmokQxo(android.view.KeyEvent keyEvent) {
        if (!this.$shortcutModifier.invoke(KeyEvent.m5413boximpl(keyEvent)).booleanValue() || !KeyEvent_androidKt.m5436isShiftPressedZmokQxo(keyEvent)) {
            if (this.$shortcutModifier.invoke(KeyEvent.m5413boximpl(keyEvent)).booleanValue()) {
                long r2 = KeyEvent_androidKt.m5430getKeyZmokQxo(keyEvent);
                if (Key.m5122equalsimpl0(r2, MappedKeys.INSTANCE.m1229getCEK5gGoQ()) ? true : Key.m5122equalsimpl0(r2, MappedKeys.INSTANCE.m1239getInsertEK5gGoQ())) {
                    return KeyCommand.COPY;
                }
                if (Key.m5122equalsimpl0(r2, MappedKeys.INSTANCE.m1246getVEK5gGoQ())) {
                    return KeyCommand.PASTE;
                }
                if (Key.m5122equalsimpl0(r2, MappedKeys.INSTANCE.m1247getXEK5gGoQ())) {
                    return KeyCommand.CUT;
                }
                if (Key.m5122equalsimpl0(r2, MappedKeys.INSTANCE.m1226getAEK5gGoQ())) {
                    return KeyCommand.SELECT_ALL;
                }
                if (Key.m5122equalsimpl0(r2, MappedKeys.INSTANCE.m1248getYEK5gGoQ())) {
                    return KeyCommand.REDO;
                }
                if (Key.m5122equalsimpl0(r2, MappedKeys.INSTANCE.m1249getZEK5gGoQ())) {
                    return KeyCommand.UNDO;
                }
                return null;
            } else if (KeyEvent_androidKt.m5434isCtrlPressedZmokQxo(keyEvent)) {
                return null;
            } else {
                if (KeyEvent_androidKt.m5436isShiftPressedZmokQxo(keyEvent)) {
                    long r22 = KeyEvent_androidKt.m5430getKeyZmokQxo(keyEvent);
                    if (Key.m5122equalsimpl0(r22, MappedKeys.INSTANCE.m1234getDirectionLeftEK5gGoQ())) {
                        return KeyCommand.SELECT_LEFT_CHAR;
                    }
                    if (Key.m5122equalsimpl0(r22, MappedKeys.INSTANCE.m1235getDirectionRightEK5gGoQ())) {
                        return KeyCommand.SELECT_RIGHT_CHAR;
                    }
                    if (Key.m5122equalsimpl0(r22, MappedKeys.INSTANCE.m1236getDirectionUpEK5gGoQ())) {
                        return KeyCommand.SELECT_UP;
                    }
                    if (Key.m5122equalsimpl0(r22, MappedKeys.INSTANCE.m1233getDirectionDownEK5gGoQ())) {
                        return KeyCommand.SELECT_DOWN;
                    }
                    if (Key.m5122equalsimpl0(r22, MappedKeys.INSTANCE.m1243getPageUpEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_UP;
                    }
                    if (Key.m5122equalsimpl0(r22, MappedKeys.INSTANCE.m1242getPageDownEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_DOWN;
                    }
                    if (Key.m5122equalsimpl0(r22, MappedKeys.INSTANCE.m1241getMoveHomeEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_START;
                    }
                    if (Key.m5122equalsimpl0(r22, MappedKeys.INSTANCE.m1240getMoveEndEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_END;
                    }
                    if (Key.m5122equalsimpl0(r22, MappedKeys.INSTANCE.m1239getInsertEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    return null;
                }
                long r23 = KeyEvent_androidKt.m5430getKeyZmokQxo(keyEvent);
                if (Key.m5122equalsimpl0(r23, MappedKeys.INSTANCE.m1234getDirectionLeftEK5gGoQ())) {
                    return KeyCommand.LEFT_CHAR;
                }
                if (Key.m5122equalsimpl0(r23, MappedKeys.INSTANCE.m1235getDirectionRightEK5gGoQ())) {
                    return KeyCommand.RIGHT_CHAR;
                }
                if (Key.m5122equalsimpl0(r23, MappedKeys.INSTANCE.m1236getDirectionUpEK5gGoQ())) {
                    return KeyCommand.UP;
                }
                if (Key.m5122equalsimpl0(r23, MappedKeys.INSTANCE.m1233getDirectionDownEK5gGoQ())) {
                    return KeyCommand.DOWN;
                }
                if (Key.m5122equalsimpl0(r23, MappedKeys.INSTANCE.m1243getPageUpEK5gGoQ())) {
                    return KeyCommand.PAGE_UP;
                }
                if (Key.m5122equalsimpl0(r23, MappedKeys.INSTANCE.m1242getPageDownEK5gGoQ())) {
                    return KeyCommand.PAGE_DOWN;
                }
                if (Key.m5122equalsimpl0(r23, MappedKeys.INSTANCE.m1241getMoveHomeEK5gGoQ())) {
                    return KeyCommand.LINE_START;
                }
                if (Key.m5122equalsimpl0(r23, MappedKeys.INSTANCE.m1240getMoveEndEK5gGoQ())) {
                    return KeyCommand.LINE_END;
                }
                if (Key.m5122equalsimpl0(r23, MappedKeys.INSTANCE.m1237getEnterEK5gGoQ())) {
                    return KeyCommand.NEW_LINE;
                }
                if (Key.m5122equalsimpl0(r23, MappedKeys.INSTANCE.m1228getBackspaceEK5gGoQ())) {
                    return KeyCommand.DELETE_PREV_CHAR;
                }
                if (Key.m5122equalsimpl0(r23, MappedKeys.INSTANCE.m1232getDeleteEK5gGoQ())) {
                    return KeyCommand.DELETE_NEXT_CHAR;
                }
                if (Key.m5122equalsimpl0(r23, MappedKeys.INSTANCE.m1244getPasteEK5gGoQ())) {
                    return KeyCommand.PASTE;
                }
                if (Key.m5122equalsimpl0(r23, MappedKeys.INSTANCE.m1231getCutEK5gGoQ())) {
                    return KeyCommand.CUT;
                }
                if (Key.m5122equalsimpl0(r23, MappedKeys.INSTANCE.m1230getCopyEK5gGoQ())) {
                    return KeyCommand.COPY;
                }
                if (Key.m5122equalsimpl0(r23, MappedKeys.INSTANCE.m1245getTabEK5gGoQ())) {
                    return KeyCommand.TAB;
                }
                return null;
            }
        } else if (Key.m5122equalsimpl0(KeyEvent_androidKt.m5430getKeyZmokQxo(keyEvent), MappedKeys.INSTANCE.m1249getZEK5gGoQ())) {
            return KeyCommand.REDO;
        } else {
            return null;
        }
    }
}
