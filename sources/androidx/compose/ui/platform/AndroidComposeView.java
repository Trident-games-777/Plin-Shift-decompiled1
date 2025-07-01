package androidx.compose.ui.platform;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Build;
import android.os.Trace;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ScrollCaptureTarget;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.translation.ViewTranslationRequest;
import android.view.translation.ViewTranslationResponse;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.SessionMutex;
import androidx.compose.ui.autofill.AndroidAutofill;
import androidx.compose.ui.autofill.AndroidAutofill_androidKt;
import androidx.compose.ui.autofill.Autofill;
import androidx.compose.ui.autofill.AutofillCallback;
import androidx.compose.ui.autofill.AutofillTree;
import androidx.compose.ui.contentcapture.AndroidContentCaptureManager;
import androidx.compose.ui.draganddrop.ComposeDragShadowBuilder;
import androidx.compose.ui.draganddrop.DragAndDropManager;
import androidx.compose.ui.draganddrop.DragAndDropTransferData;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidGraphicsContext_androidKt;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.InputModeManagerImpl;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.MotionEventAdapter;
import androidx.compose.ui.input.pointer.PointerIconService;
import androidx.compose.ui.input.pointer.PointerInputEvent;
import androidx.compose.ui.input.pointer.PointerInputEventData;
import androidx.compose.ui.input.pointer.PointerInputEventProcessor;
import androidx.compose.ui.input.pointer.PointerInputEventProcessorKt;
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers;
import androidx.compose.ui.input.pointer.PositionCalculator;
import androidx.compose.ui.input.pointer.ProcessResult;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryInputModifierKt;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.compose.ui.layout.RootMeasurePolicy;
import androidx.compose.ui.modifier.ModifierLocalManager;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.MeasureAndLayoutDelegate;
import androidx.compose.ui.node.NestedVectorStack;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.RootForTest;
import androidx.compose.ui.scrollcapture.ScrollCapture;
import androidx.compose.ui.semantics.EmptySemanticsElement;
import androidx.compose.ui.semantics.EmptySemanticsModifier;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyResolver_androidKt;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputServiceAndroid;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b*\u0002¾\u0001\b\u0000\u0018\u0000 \u00042\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0004\u0004\u0004B\u0015\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001b\u0010\u0002\u001a\u0002062\b\u0010þ\u0001\u001a\u00030\u00022\b\u0010\u0002\u001a\u00030Á\u0001J&\u0010\u0002\u001a\u0002062\u0007\u0010\u0002\u001a\u00020G2\b\u0010\u0002\u001a\u00030\u00022\b\u0010\u0002\u001a\u00030\u0002H\u0002J\u0015\u0010 \u0002\u001a\u0002062\n\u0010¡\u0002\u001a\u0005\u0018\u00010ÿ\u0001H\u0016J!\u0010 \u0002\u001a\u0002062\n\u0010¡\u0002\u001a\u0005\u0018\u00010ÿ\u00012\n\u0010¢\u0002\u001a\u0005\u0018\u00010£\u0002H\u0016J\u001e\u0010 \u0002\u001a\u0002062\n\u0010¡\u0002\u001a\u0005\u0018\u00010ÿ\u00012\u0007\u0010¤\u0002\u001a\u00020GH\u0016J*\u0010 \u0002\u001a\u0002062\n\u0010¡\u0002\u001a\u0005\u0018\u00010ÿ\u00012\u0007\u0010¤\u0002\u001a\u00020G2\n\u0010¢\u0002\u001a\u0005\u0018\u00010£\u0002H\u0016J'\u0010 \u0002\u001a\u0002062\n\u0010¡\u0002\u001a\u0005\u0018\u00010ÿ\u00012\u0007\u0010¥\u0002\u001a\u00020G2\u0007\u0010¦\u0002\u001a\u00020GH\u0016J\u0019\u0010#\u001a\u0002062\u000f\u0010§\u0002\u001a\n\u0012\u0005\u0012\u00030©\u00020¨\u0002H\u0016J\t\u0010ª\u0002\u001a\u00020mH\u0002J\u0010\u0010«\u0002\u001a\u000206H@¢\u0006\u0003\u0010¬\u0002J\u0010\u0010­\u0002\u001a\u000206H@¢\u0006\u0003\u0010¬\u0002J \u0010®\u0002\u001a\u00030\u00012\b\u0010¯\u0002\u001a\u00030\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b°\u0002\u0010±\u0002J \u0010²\u0002\u001a\u00030\u00012\b\u0010³\u0002\u001a\u00030\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b´\u0002\u0010±\u0002J\u0012\u0010µ\u0002\u001a\u00020m2\u0007\u0010¶\u0002\u001a\u00020GH\u0016J\u0012\u0010·\u0002\u001a\u00020m2\u0007\u0010¶\u0002\u001a\u00020GH\u0016J\u0012\u0010¸\u0002\u001a\u0002062\u0007\u0010¹\u0002\u001a\u00020\u0001H\u0002J\"\u0010º\u0002\u001a\u00030»\u00022\u0007\u0010¼\u0002\u001a\u00020GH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b½\u0002\u0010¾\u0002Jh\u0010¿\u0002\u001a\u00020Q2B\u0010À\u0002\u001a=\u0012\u0017\u0012\u00150Â\u0002¢\u0006\u000f\bÃ\u0002\u0012\n\bÄ\u0002\u0012\u0005\b\b(Å\u0002\u0012\u0019\u0012\u0017\u0018\u00010Æ\u0002¢\u0006\u000f\bÃ\u0002\u0012\n\bÄ\u0002\u0012\u0005\b\b(Ç\u0002\u0012\u0004\u0012\u0002060Á\u00022\r\u0010È\u0002\u001a\b\u0012\u0004\u0012\u0002060Z2\n\u0010É\u0002\u001a\u0005\u0018\u00010Æ\u0002H\u0016J\u0013\u0010Ê\u0002\u001a\u0002062\b\u0010Å\u0002\u001a\u00030Ë\u0002H\u0014J\u0013\u0010Ì\u0002\u001a\u00020m2\b\u0010Í\u0002\u001a\u00030º\u0001H\u0016J\u0013\u0010Î\u0002\u001a\u00020m2\b\u0010Ï\u0002\u001a\u00030º\u0001H\u0016J\u0013\u0010Ð\u0002\u001a\u00020m2\b\u0010Ï\u0002\u001a\u00030Ñ\u0002H\u0016J\u0013\u0010Ò\u0002\u001a\u00020m2\b\u0010Ï\u0002\u001a\u00030Ñ\u0002H\u0016J\t\u0010Ó\u0002\u001a\u000206H\u0002J\u0013\u0010Ô\u0002\u001a\u0002062\b\u0010Õ\u0002\u001a\u00030Ö\u0002H\u0016J\u0013\u0010×\u0002\u001a\u00020m2\b\u0010Í\u0002\u001a\u00030º\u0001H\u0016J\u001b\u0010Ø\u0002\u001a\u0002062\b\u0010þ\u0001\u001a\u00030\u00022\b\u0010Å\u0002\u001a\u00030Ë\u0002J\u0015\u0010Ù\u0002\u001a\u0005\u0018\u00010ÿ\u00012\u0007\u0010¶\u0002\u001a\u00020GH\u0002J\u001f\u0010Ú\u0002\u001a\u0005\u0018\u00010ÿ\u00012\u0007\u0010Û\u0002\u001a\u00020G2\b\u0010Ü\u0002\u001a\u00030ÿ\u0001H\u0002J\u0013\u0010Ý\u0002\u001a\u0005\u0018\u00010ÿ\u00012\u0007\u0010Û\u0002\u001a\u00020GJ!\u0010Þ\u0002\u001a\u0005\u0018\u00010ÿ\u00012\n\u0010ß\u0002\u001a\u0005\u0018\u00010ÿ\u00012\u0007\u0010¶\u0002\u001a\u00020GH\u0016J\u0012\u0010à\u0002\u001a\u0002062\u0007\u0010á\u0002\u001a\u00020mH\u0016J\u001c\u0010â\u0002\u001a\u0002062\b\u0010\u0002\u001a\u00030Á\u00012\u0007\u0010ã\u0002\u001a\u00020mH\u0016J\"\u0010ä\u0002\u001a\u0005\u0018\u00010å\u00022\b\u0010æ\u0002\u001a\u00030ç\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\bè\u0002\u0010é\u0002J\u0013\u0010ê\u0002\u001a\u0002062\b\u0010ë\u0002\u001a\u00030ì\u0002H\u0016J#\u0010í\u0002\u001a\u00030î\u00022\b\u0010Í\u0002\u001a\u00030º\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bï\u0002\u0010ð\u0002J\u0013\u0010ñ\u0002\u001a\u00020m2\b\u0010Ï\u0002\u001a\u00030º\u0001H\u0002J\u001d\u0010ò\u0002\u001a\u00020m2\b\u0010Ï\u0002\u001a\u00030º\u00012\b\u0010ó\u0002\u001a\u00030º\u0001H\u0002J\t\u0010ô\u0002\u001a\u000206H\u0016J\u0013\u0010õ\u0002\u001a\u0002062\b\u0010ö\u0002\u001a\u00030Á\u0001H\u0002J\u0013\u0010÷\u0002\u001a\u0002062\b\u0010ö\u0002\u001a\u00030Á\u0001H\u0002J\u0013\u0010ø\u0002\u001a\u00020m2\b\u0010Ï\u0002\u001a\u00030º\u0001H\u0002J\u0013\u0010ù\u0002\u001a\u00020m2\b\u0010Ï\u0002\u001a\u00030º\u0001H\u0002J\u0013\u0010ú\u0002\u001a\u00020m2\b\u0010Í\u0002\u001a\u00030º\u0001H\u0002J\u0013\u0010û\u0002\u001a\u00020m2\b\u0010Ï\u0002\u001a\u00030º\u0001H\u0002J \u0010ü\u0002\u001a\u00030\u00012\b\u0010³\u0002\u001a\u00030\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bý\u0002\u0010±\u0002J\u001f\u0010ü\u0002\u001a\u0002062\b\u0010þ\u0002\u001a\u00030ø\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bÿ\u0002\u0010\u0003J)\u0010\u0003\u001a\u0002062\b\u0010\u0002\u001a\u00030Á\u00012\b\u0010\u0003\u001a\u00030¬\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0003\u0010\u0003J\u0012\u0010\u0003\u001a\u0002062\u0007\u0010\u0003\u001a\u00020mH\u0016J\t\u0010\u0003\u001a\u000206H\u0016J!\u0010\u0003\u001a\u0002062\u0007\u0010\u0003\u001a\u00020Q2\u0007\u0010\u0003\u001a\u00020mH\u0000¢\u0006\u0003\b\u0003J\u0013\u0010\u0003\u001a\u0002062\b\u0010ö\u0002\u001a\u00030Á\u0001H\u0016J\t\u0010\u0003\u001a\u000206H\u0014J\t\u0010\u0003\u001a\u00020mH\u0016J\t\u0010\u0003\u001a\u000206H\u0002J\u0012\u0010\u0003\u001a\u0002062\u0007\u0010\u0003\u001a\u000205H\u0014J\u0016\u0010\u0003\u001a\u0005\u0018\u00010\u00032\b\u0010\u0003\u001a\u00030\u0003H\u0016J0\u0010\u0003\u001a\u0002062\b\u0010\u0003\u001a\u00030\u00032\b\u0010\u0003\u001a\u00030û\u00012\u0011\u0010\u0003\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u00030\u0003H\u0017J\u0013\u0010\u0003\u001a\u0002062\b\u0010ö\u0002\u001a\u00030Á\u0001H\u0016J\t\u0010\u0003\u001a\u000206H\u0014J\u0013\u0010\u0003\u001a\u0002062\b\u0010Å\u0002\u001a\u00030Ë\u0002H\u0014J\t\u0010\u0003\u001a\u000206H\u0016J\f\u0010 \u0003\u001a\u0005\u0018\u00010¡\u0003H\u0002J'\u0010¢\u0003\u001a\u0002062\u0007\u0010£\u0003\u001a\u00020m2\u0007\u0010¶\u0002\u001a\u00020G2\n\u0010¤\u0003\u001a\u0005\u0018\u00010ì\u0002H\u0014J\u0018\u0010¥\u0003\u001a\u0002062\r\u0010þ\u0001\u001a\b0ÿ\u0001j\u0003`¦\u0003H\u0016J6\u0010§\u0003\u001a\u0002062\u0007\u0010¨\u0003\u001a\u00020m2\u0007\u0010©\u0003\u001a\u00020G2\u0007\u0010ª\u0003\u001a\u00020G2\u0007\u0010«\u0003\u001a\u00020G2\u0007\u0010¬\u0003\u001a\u00020GH\u0014J\u0013\u0010­\u0003\u001a\u0002062\b\u0010\u0002\u001a\u00030Á\u0001H\u0016J\u001b\u0010®\u0003\u001a\u0002062\u0007\u0010¯\u0003\u001a\u00020G2\u0007\u0010°\u0003\u001a\u00020GH\u0014J\u001f\u0010±\u0003\u001a\u00020m2\b\u0010²\u0003\u001a\u00030å\u0002H\u0002ø\u0001\u0000¢\u0006\u0006\b³\u0003\u0010´\u0003J\u001e\u0010µ\u0003\u001a\u0002062\n\u0010Õ\u0002\u001a\u0005\u0018\u00010Ö\u00022\u0007\u0010¶\u0003\u001a\u00020GH\u0016J*\u0010·\u0003\u001a\u00020m2\n\u0010²\u0003\u001a\u0005\u0018\u00010å\u00022\n\u0010¤\u0003\u001a\u0005\u0018\u00010¡\u0003H\u0002ø\u0001\u0000¢\u0006\u0003\b¸\u0003J.\u0010¹\u0003\u001a\u0002062\b\u0010\u0002\u001a\u00030Á\u00012\u0007\u0010ã\u0002\u001a\u00020m2\u0007\u0010º\u0003\u001a\u00020m2\u0007\u0010»\u0003\u001a\u00020mH\u0016J%\u0010¼\u0003\u001a\u0002062\b\u0010\u0002\u001a\u00030Á\u00012\u0007\u0010ã\u0002\u001a\u00020m2\u0007\u0010º\u0003\u001a\u00020mH\u0016J\u0013\u0010½\u0003\u001a\u0002062\b\u0010¾\u0003\u001a\u00030¿\u0003H\u0016J\u0012\u0010À\u0003\u001a\u0002062\u0007\u0010\u0001\u001a\u00020GH\u0016J.\u0010Á\u0003\u001a\u0002062\b\u0010Â\u0003\u001a\u00030ì\u00022\b\u0010Ã\u0003\u001a\u00030Ä\u00032\u000f\u0010Å\u0003\u001a\n\u0012\u0005\u0012\u00030Æ\u00030\u0003H\u0016J\t\u0010Ç\u0003\u001a\u000206H\u0016J\u001c\u0010È\u0003\u001a\u0002062\u0011\u0010É\u0003\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010Ë\u00030Ê\u0003H\u0017J\u0012\u0010Ì\u0003\u001a\u0002062\u0007\u0010Í\u0003\u001a\u00020mH\u0016J+\u0010Î\u0003\u001a\u00030»\u00022\u0007\u0010Ï\u0003\u001a\u00020G2\u0007\u0010¬\u0003\u001a\u00020GH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÐ\u0003\u0010Ñ\u0003J\t\u0010Ò\u0003\u001a\u000206H\u0002J\u0013\u0010Ò\u0003\u001a\u0002062\b\u0010Í\u0002\u001a\u00030º\u0001H\u0002J\t\u0010Ó\u0003\u001a\u000206H\u0002J\u0018\u0010Ô\u0003\u001a\u00020m2\u0007\u0010\u0003\u001a\u00020QH\u0000¢\u0006\u0003\bÕ\u0003J\u0018\u0010Ö\u0003\u001a\u0002062\r\u0010×\u0003\u001a\b\u0012\u0004\u0012\u0002060ZH\u0016J\u0013\u0010Ø\u0003\u001a\u0002062\b\u0010×\u0003\u001a\u00030Ù\u0003H\u0016J\u0011\u0010Ú\u0003\u001a\u0002062\b\u0010þ\u0001\u001a\u00030\u0002J\u0007\u0010Û\u0003\u001a\u000206J\u001e\u0010Ü\u0003\u001a\u00020m2\u0007\u0010¶\u0002\u001a\u00020G2\n\u0010¤\u0003\u001a\u0005\u0018\u00010ì\u0002H\u0016J\u0013\u0010Ý\u0003\u001a\u0002062\b\u0010\u0002\u001a\u00030Á\u0001H\u0016J\u0017\u0010»\u0003\u001a\u0002062\f\b\u0002\u0010Þ\u0003\u001a\u0005\u0018\u00010Á\u0001H\u0002J \u0010ß\u0003\u001a\u00030\u00012\b\u0010à\u0003\u001a\u00030\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bá\u0003\u0010±\u0002J\u001f\u0010â\u0003\u001a\u00020m2\b\u0010æ\u0002\u001a\u00030ç\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\bã\u0003\u0010ä\u0003J#\u0010å\u0003\u001a\u00030î\u00022\b\u0010Í\u0002\u001a\u00030º\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bæ\u0003\u0010ð\u0002J1\u0010ç\u0003\u001a\u0002062\b\u0010Í\u0002\u001a\u00030º\u00012\u0007\u0010è\u0003\u001a\u00020G2\b\u0010é\u0003\u001a\u00030\u00012\t\b\u0002\u0010ê\u0003\u001a\u00020mH\u0002J\u0013\u0010ë\u0003\u001a\u0002062\b\u0010ì\u0003\u001a\u00030\u0001H\u0016J\u001c\u0010í\u0003\u001a\u0002062\u0013\u0010î\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020604J\t\u0010ï\u0003\u001a\u00020mH\u0016JE\u0010ð\u0003\u001a\u00020m2\b\u0010ñ\u0003\u001a\u00030ò\u00032\b\u0010ó\u0003\u001a\u00030ô\u00032\u001a\u0010õ\u0003\u001a\u0015\u0012\u0005\u0012\u00030ö\u0003\u0012\u0004\u0012\u00020604¢\u0006\u0003\b÷\u0003H\u0002ø\u0001\u0000¢\u0006\u0006\bø\u0003\u0010ù\u0003JA\u0010ú\u0003\u001a\u00030û\u00032.\u0010ü\u0003\u001a)\b\u0001\u0012\u0005\u0012\u00030ý\u0003\u0012\f\u0012\n\u0012\u0005\u0012\u00030û\u00030þ\u0003\u0012\u0007\u0012\u0005\u0018\u00010ÿ\u00030Á\u0002¢\u0006\u0003\b÷\u0003H@¢\u0006\u0003\u0010\u0004J\t\u0010\u0004\u001a\u000206H\u0002J\u000e\u0010\u0004\u001a\u00020m*\u00030Á\u0001H\u0002J\u001b\u0010\u0004\u001a\u00020G*\u00030»\u0002H\nø\u0001\u0000¢\u0006\u0006\b\u0004\u0010\u0004J\u001b\u0010\u0004\u001a\u00020G*\u00030»\u0002H\nø\u0001\u0000¢\u0006\u0006\b\u0004\u0010\u0004R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R/\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00128B@BX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\f8@X\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u0010#\u001a\u0004\u0018\u00010$8VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\u00020.X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u000e\u00101\u001a\u000202X\u0004¢\u0006\u0002\n\u0000R&\u00103\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020604X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010\b\u001a\u00020\t2\u0006\u0010A\u001a\u00020\t@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u000e\u0010F\u001a\u00020GX\u000e¢\u0006\u0002\n\u0000R+\u0010I\u001a\u00020H2\u0006\u0010\u0011\u001a\u00020H8V@RX\u0002¢\u0006\u0012\n\u0004\bN\u0010\u0019\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0014\u0010O\u001a\b\u0012\u0004\u0012\u00020Q0PX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010R\u001a\u00020SX\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u000e\u0010V\u001a\u00020WX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010X\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000206\u0018\u00010Z0YX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010[\u001a\u00020\\X\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R+\u0010`\u001a\u00020_2\u0006\u0010\u0011\u001a\u00020_8V@RX\u0002¢\u0006\u0012\n\u0004\be\u0010\u0019\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001c\u0010f\u001a\u00020g8\u0016X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bh\u0010i\u001a\u0004\bj\u0010kR\u000e\u0010l\u001a\u00020mX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020oX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010p\u001a\u00020qX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010rR\u0014\u0010s\u001a\u00020tX\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010vR\u0014\u0010w\u001a\u00020xX\u0004¢\u0006\b\n\u0000\u001a\u0004\by\u0010zR\u0014\u0010{\u001a\u00020m8VX\u0004¢\u0006\u0006\u001a\u0004\b|\u0010}R\u000e\u0010~\u001a\u00020mX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u00030\u00018VX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u000f\u0010\u0001\u001a\u00020mX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0001\u001a\u00020m8VX\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010}R\u000f\u0010\u0001\u001a\u00020mX\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020mX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020mX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0001\u001a\u00030\u0001X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010rR+\u0010\u0001\u001a\u00030\u00018\u0000@\u0000X\u000e¢\u0006\u0019\n\u0000\u0012\u0005\b\u0001\u0010i\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u0016\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020Q0\u0001X\u0004¢\u0006\u0002\n\u0000R3\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0011\u001a\u00030\u00018V@RX\u0002¢\u0006\u0017\n\u0005\b\u0001\u0010\u0019\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u0001\u001a\u00030¡\u0001X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010¢\u0001\u001a\u00030\u00018VX\u0004¢\u0006\b\u001a\u0006\b£\u0001\u0010\u0001R\u0018\u0010¤\u0001\u001a\u00030¥\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b¦\u0001\u0010§\u0001R\u0010\u0010¨\u0001\u001a\u00030©\u0001X\u0004¢\u0006\u0002\n\u0000R\u000f\u0010ª\u0001\u001a\u00020mX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010«\u0001\u001a\u0005\u0018\u00010¬\u0001X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u001d\u0010­\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u000206\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010®\u0001\u001a\u00030¯\u00018VX\u0004¢\u0006\b\u001a\u0006\b°\u0001\u0010±\u0001R\u0018\u0010²\u0001\u001a\u00030³\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b´\u0001\u0010µ\u0001R\u0010\u0010¶\u0001\u001a\u00030·\u0001X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010¸\u0001\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010PX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¹\u0001\u001a\u0005\u0018\u00010º\u0001X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010»\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0002\n\u0000R\u0015\u0010¼\u0001\u001a\b\u0012\u0004\u0012\u0002060ZX\u0004¢\u0006\u0002\n\u0000R\u0013\u0010½\u0001\u001a\u00030¾\u0001X\u0004¢\u0006\u0005\n\u0003\u0010¿\u0001R\u0018\u0010À\u0001\u001a\u00030Á\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\bÂ\u0001\u0010Ã\u0001R\u0018\u0010Ä\u0001\u001a\u00030Å\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\bÆ\u0001\u0010Ç\u0001R\u0010\u0010È\u0001\u001a\u00030É\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Ê\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010Ë\u0001\u001a\u0005\u0018\u00010Ì\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010Í\u0001\u001a\u00020m8@X\u0004¢\u0006\u0007\u001a\u0005\bÎ\u0001\u0010}R\u0010\u0010Ï\u0001\u001a\u00030Ð\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Ñ\u0001\u001a\u00030Ò\u0001X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010Ó\u0001\u001a\u00030Ô\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\bÕ\u0001\u0010Ö\u0001R\u0010\u0010×\u0001\u001a\u00030Ø\u0001X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010Ù\u0001\u001a\u00030Ú\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\bÛ\u0001\u0010Ü\u0001R%\u0010Ý\u0001\u001a\u00020mX\u000e¢\u0006\u0018\n\u0000\u0012\u0005\bÞ\u0001\u0010i\u001a\u0005\bß\u0001\u0010}\"\u0006\bà\u0001\u0010á\u0001R\u0018\u0010â\u0001\u001a\u00030ã\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\bä\u0001\u0010å\u0001R\u0018\u0010æ\u0001\u001a\u00030ç\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\bè\u0001\u0010é\u0001R\u000f\u0010ê\u0001\u001a\u00020mX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010ë\u0001\u001a\u00030ì\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\bí\u0001\u0010î\u0001R \u0010ï\u0001\u001a\n\u0012\u0005\u0012\u00030ñ\u00010ð\u0001X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\n\u0003\u0010ò\u0001R\u0018\u0010ó\u0001\u001a\u00030ô\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\bõ\u0001\u0010ö\u0001R\u0019\u0010÷\u0001\u001a\u00030ø\u0001X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\n\u0003\u0010ù\u0001R\u0010\u0010ú\u0001\u001a\u00030û\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010ü\u0001\u001a\u00030ý\u0001X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010þ\u0001\u001a\u00030ÿ\u00018VX\u0004¢\u0006\b\u001a\u0006\b\u0002\u0010\u0002R\u0018\u0010\u0002\u001a\u00030\u0002X\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0002\u0010\u0002R\u0012\u0010\u0002\u001a\u0005\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0002\u001a\u00030ø\u0001X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\n\u0003\u0010ù\u0001R!\u0010\u0002\u001a\u0004\u0018\u00010\u00128FX\u0002¢\u0006\u000f\n\u0006\b\u0002\u0010\u0002\u001a\u0005\b\u0002\u0010\u0015R\u000f\u0010\u0002\u001a\u00020mX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0002\u001a\u00030\u00028VX\u0004¢\u0006\b\u001a\u0006\b\u0002\u0010\u0002R\u0018\u0010\u0002\u001a\u00030\u0001X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010rR\u0019\u0010\u0002\u001a\u00030ø\u0001X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\n\u0003\u0010ù\u0001R\u001b\u0010\u0002\u001a\u00020G*\u0002058BX\u0004¢\u0006\b\u001a\u0006\b\u0002\u0010\u0002\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView;", "Landroid/view/ViewGroup;", "Landroidx/compose/ui/node/Owner;", "Landroidx/compose/ui/platform/ViewRootForTest;", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "context", "Landroid/content/Context;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroid/content/Context;Lkotlin/coroutines/CoroutineContext;)V", "_androidViewsHandler", "Landroidx/compose/ui/platform/AndroidViewsHandler;", "_autofill", "Landroidx/compose/ui/autofill/AndroidAutofill;", "_inputModeManager", "Landroidx/compose/ui/input/InputModeManagerImpl;", "<set-?>", "Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "_viewTreeOwners", "get_viewTreeOwners", "()Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "set_viewTreeOwners", "(Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;)V", "_viewTreeOwners$delegate", "Landroidx/compose/runtime/MutableState;", "_windowInfo", "Landroidx/compose/ui/platform/WindowInfoImpl;", "accessibilityManager", "Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "getAccessibilityManager", "()Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "androidViewsHandler", "getAndroidViewsHandler$ui_release", "()Landroidx/compose/ui/platform/AndroidViewsHandler;", "autofill", "Landroidx/compose/ui/autofill/Autofill;", "getAutofill", "()Landroidx/compose/ui/autofill/Autofill;", "autofillTree", "Landroidx/compose/ui/autofill/AutofillTree;", "getAutofillTree", "()Landroidx/compose/ui/autofill/AutofillTree;", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipboardManager", "Landroidx/compose/ui/platform/AndroidClipboardManager;", "getClipboardManager", "()Landroidx/compose/ui/platform/AndroidClipboardManager;", "composeAccessibilityDelegate", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "configurationChangeObserver", "Lkotlin/Function1;", "Landroid/content/res/Configuration;", "", "getConfigurationChangeObserver", "()Lkotlin/jvm/functions/Function1;", "setConfigurationChangeObserver", "(Lkotlin/jvm/functions/Function1;)V", "contentCaptureManager", "Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "getContentCaptureManager$ui_release", "()Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "setContentCaptureManager$ui_release", "(Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;)V", "value", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "setCoroutineContext", "(Lkotlin/coroutines/CoroutineContext;)V", "currentFontWeightAdjustment", "", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "density$delegate", "dirtyLayers", "", "Landroidx/compose/ui/node/OwnedLayer;", "dragAndDropManager", "Landroidx/compose/ui/draganddrop/DragAndDropManager;", "getDragAndDropManager", "()Landroidx/compose/ui/draganddrop/DragAndDropManager;", "dragAndDropModifierOnDragListener", "Landroidx/compose/ui/platform/DragAndDropModifierOnDragListener;", "endApplyChangesListeners", "Landroidx/compose/runtime/collection/MutableVector;", "Lkotlin/Function0;", "focusOwner", "Landroidx/compose/ui/focus/FocusOwner;", "getFocusOwner", "()Landroidx/compose/ui/focus/FocusOwner;", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontFamilyResolver", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "setFontFamilyResolver", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "fontFamilyResolver$delegate", "fontLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getFontLoader$annotations", "()V", "getFontLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "forceUseMatrixCache", "", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "globalPosition", "Landroidx/compose/ui/unit/IntOffset;", "J", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "getGraphicsContext", "()Landroidx/compose/ui/graphics/GraphicsContext;", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "hasPendingMeasureOrLayout", "getHasPendingMeasureOrLayout", "()Z", "hoverExitReceived", "inputModeManager", "Landroidx/compose/ui/input/InputModeManager;", "getInputModeManager", "()Landroidx/compose/ui/input/InputModeManager;", "isDrawingContent", "isLifecycleInResumedState", "isPendingInteropViewLayoutChangeDispatch", "isRenderNodeCompatible", "keyInputModifier", "Landroidx/compose/ui/Modifier;", "keyboardModifiersRequireUpdate", "lastDownPointerPosition", "Landroidx/compose/ui/geometry/Offset;", "lastMatrixRecalculationAnimationTime", "", "getLastMatrixRecalculationAnimationTime$ui_release$annotations", "getLastMatrixRecalculationAnimationTime$ui_release", "()J", "setLastMatrixRecalculationAnimationTime$ui_release", "(J)V", "layerCache", "Landroidx/compose/ui/platform/WeakCache;", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutDirection$delegate", "legacyTextInputServiceAndroid", "Landroidx/compose/ui/text/input/TextInputServiceAndroid;", "matrixToWindow", "Landroidx/compose/ui/platform/CalculateMatrixToWindow;", "measureAndLayoutDelegate", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate;", "measureIteration", "getMeasureIteration", "modifierLocalManager", "Landroidx/compose/ui/modifier/ModifierLocalManager;", "getModifierLocalManager", "()Landroidx/compose/ui/modifier/ModifierLocalManager;", "motionEventAdapter", "Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "observationClearRequested", "onMeasureConstraints", "Landroidx/compose/ui/unit/Constraints;", "onViewTreeOwnersAvailable", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getPlacementScope", "()Landroidx/compose/ui/layout/Placeable$PlacementScope;", "pointerIconService", "Landroidx/compose/ui/input/pointer/PointerIconService;", "getPointerIconService", "()Landroidx/compose/ui/input/pointer/PointerIconService;", "pointerInputEventProcessor", "Landroidx/compose/ui/input/pointer/PointerInputEventProcessor;", "postponedDirtyLayers", "previousMotionEvent", "Landroid/view/MotionEvent;", "relayoutTime", "resendMotionEventOnLayout", "resendMotionEventRunnable", "androidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1", "Landroidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1;", "root", "Landroidx/compose/ui/node/LayoutNode;", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "rootForTest", "Landroidx/compose/ui/node/RootForTest;", "getRootForTest", "()Landroidx/compose/ui/node/RootForTest;", "rootSemanticsNode", "Landroidx/compose/ui/semantics/EmptySemanticsModifier;", "rotaryInputModifier", "scrollCapture", "Landroidx/compose/ui/scrollcapture/ScrollCapture;", "scrollCaptureInProgress", "getScrollCaptureInProgress$ui_release", "scrollChangedListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "semanticsModifier", "Landroidx/compose/ui/semantics/EmptySemanticsElement;", "semanticsOwner", "Landroidx/compose/ui/semantics/SemanticsOwner;", "getSemanticsOwner", "()Landroidx/compose/ui/semantics/SemanticsOwner;", "sendHoverExitEvent", "Ljava/lang/Runnable;", "sharedDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getSharedDrawScope", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "showLayoutBounds", "getShowLayoutBounds$annotations", "getShowLayoutBounds", "setShowLayoutBounds", "(Z)V", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "softwareKeyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "getSoftwareKeyboardController", "()Landroidx/compose/ui/platform/SoftwareKeyboardController;", "superclassInitComplete", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "getTextInputService", "()Landroidx/compose/ui/text/input/TextInputService;", "textInputSessionMutex", "Landroidx/compose/ui/SessionMutex;", "Landroidx/compose/ui/platform/AndroidPlatformTextInputSession;", "Ljava/util/concurrent/atomic/AtomicReference;", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "tmpPositionArray", "", "touchModeChangeListener", "Landroid/view/ViewTreeObserver$OnTouchModeChangeListener;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "viewLayersContainer", "Landroidx/compose/ui/platform/DrawChildContainer;", "viewToWindowMatrix", "viewTreeOwners", "getViewTreeOwners", "viewTreeOwners$delegate", "Landroidx/compose/runtime/State;", "wasMeasuredWithMultipleConstraints", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "getWindowInfo", "()Landroidx/compose/ui/platform/WindowInfo;", "windowPosition", "windowToViewMatrix", "fontWeightAdjustmentCompat", "getFontWeightAdjustmentCompat", "(Landroid/content/res/Configuration;)I", "addAndroidView", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "layoutNode", "addExtraDataToAccessibilityNodeInfoHelper", "virtualViewId", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "extraDataKey", "", "addView", "child", "params", "Landroid/view/ViewGroup$LayoutParams;", "index", "width", "height", "values", "Landroid/util/SparseArray;", "Landroid/view/autofill/AutofillValue;", "autofillSupported", "boundsUpdatesAccessibilityEventLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "boundsUpdatesContentCaptureEventLoop", "calculateLocalPosition", "positionInWindow", "calculateLocalPosition-MK-Hz9U", "(J)J", "calculatePositionInWindow", "localPosition", "calculatePositionInWindow-MK-Hz9U", "canScrollHorizontally", "direction", "canScrollVertically", "clearChildInvalidObservations", "viewGroup", "convertMeasureSpec", "Lkotlin/ULong;", "measureSpec", "convertMeasureSpec-I7RO_PI", "(I)J", "createLayer", "drawBlock", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/Canvas;", "Lkotlin/ParameterName;", "name", "canvas", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "parentLayer", "invalidateParentLayer", "explicitLayer", "dispatchDraw", "Landroid/graphics/Canvas;", "dispatchGenericMotionEvent", "motionEvent", "dispatchHoverEvent", "event", "dispatchKeyEvent", "Landroid/view/KeyEvent;", "dispatchKeyEventPreIme", "dispatchPendingInteropLayoutCallbacks", "dispatchProvideStructure", "structure", "Landroid/view/ViewStructure;", "dispatchTouchEvent", "drawAndroidView", "findNextNonChildView", "findViewByAccessibilityIdRootedAtCurrentView", "accessibilityId", "currentView", "findViewByAccessibilityIdTraversal", "focusSearch", "focused", "forceAccessibilityForTesting", "enable", "forceMeasureTheSubtree", "affectsLookahead", "getFocusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "getFocusDirection-P8AzH3I", "(Landroid/view/KeyEvent;)Landroidx/compose/ui/focus/FocusDirection;", "getFocusedRect", "rect", "Landroid/graphics/Rect;", "handleMotionEvent", "Landroidx/compose/ui/input/pointer/ProcessResult;", "handleMotionEvent-8iAsVTc", "(Landroid/view/MotionEvent;)I", "handleRotaryEvent", "hasChangedDevices", "lastEvent", "invalidateDescendants", "invalidateLayers", "node", "invalidateLayoutNodeMeasurement", "isBadMotionEvent", "isDevicePressEvent", "isInBounds", "isPositionChanged", "localToScreen", "localToScreen-MK-Hz9U", "localTransform", "localToScreen-58bKbWc", "([F)V", "measureAndLayout", "constraints", "measureAndLayout-0kLqBqw", "(Landroidx/compose/ui/node/LayoutNode;J)V", "sendPointerUpdate", "measureAndLayoutForTest", "notifyLayerIsDirty", "layer", "isDirty", "notifyLayerIsDirty$ui_release", "onAttach", "onAttachedToWindow", "onCheckIsTextEditor", "onClearFocusForOwner", "onConfigurationChanged", "newConfig", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onCreateVirtualViewTranslationRequests", "virtualIds", "", "supportedFormats", "requestsCollector", "Ljava/util/function/Consumer;", "Landroid/view/translation/ViewTranslationRequest;", "onDetach", "onDetachedFromWindow", "onDraw", "onEndApplyChanges", "onFetchFocusRect", "Landroidx/compose/ui/geometry/Rect;", "onFocusChanged", "gainFocus", "previouslyFocusedRect", "onInteropViewLayoutChange", "Landroidx/compose/ui/viewinterop/InteropView;", "onLayout", "changed", "l", "t", "r", "b", "onLayoutChange", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onMoveFocusInChildren", "focusDirection", "onMoveFocusInChildren-3ESFkO8", "(I)Z", "onProvideAutofillVirtualStructure", "flags", "onRequestFocusForOwner", "onRequestFocusForOwner-7o62pno", "onRequestMeasure", "forceRequest", "scheduleMeasureAndLayout", "onRequestRelayout", "onResume", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onRtlPropertiesChanged", "onScrollCaptureSearch", "localVisibleRect", "windowOffset", "Landroid/graphics/Point;", "targets", "Landroid/view/ScrollCaptureTarget;", "onSemanticsChange", "onVirtualViewTranslationResponses", "response", "Landroid/util/LongSparseArray;", "Landroid/view/translation/ViewTranslationResponse;", "onWindowFocusChanged", "hasWindowFocus", "pack", "a", "pack-ZIaKswc", "(II)J", "recalculateWindowPosition", "recalculateWindowViewTransforms", "recycle", "recycle$ui_release", "registerOnEndApplyChangesListener", "listener", "registerOnLayoutCompletedListener", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "removeAndroidView", "requestClearInvalidObservations", "requestFocus", "requestOnPositionedCallback", "nodeToRemeasure", "screenToLocal", "positionOnScreen", "screenToLocal-MK-Hz9U", "sendKeyEvent", "sendKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "sendMotionEvent", "sendMotionEvent-8iAsVTc", "sendSimulatedEvent", "action", "eventTime", "forceHover", "setAccessibilityEventBatchIntervalMillis", "intervalMillis", "setOnViewTreeOwnersAvailable", "callback", "shouldDelayChildPressedState", "startDrag", "transferData", "Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "decorationSize", "Landroidx/compose/ui/geometry/Size;", "drawDragDecoration", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "startDrag-12SF9DM", "(Landroidx/compose/ui/draganddrop/DragAndDropTransferData;JLkotlin/jvm/functions/Function1;)Z", "textInputSession", "", "session", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePositionCacheAndDispatch", "childSizeCanAffectParentSize", "component1", "component1-VKZWuLQ", "(J)I", "component2", "component2-VKZWuLQ", "Companion", "ViewTreeOwners", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeView.android.kt */
public final class AndroidComposeView extends ViewGroup implements Owner, ViewRootForTest, PositionCalculator, DefaultLifecycleObserver {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static Method getBooleanMethod;
    /* access modifiers changed from: private */
    public static Class<?> systemPropertiesClass;
    private AndroidViewsHandler _androidViewsHandler;
    private final AndroidAutofill _autofill;
    private final InputModeManagerImpl _inputModeManager;
    private final MutableState _viewTreeOwners$delegate;
    private final WindowInfoImpl _windowInfo;
    private final AndroidAccessibilityManager accessibilityManager;
    private final AutofillTree autofillTree;
    private final CanvasHolder canvasHolder;
    private final AndroidClipboardManager clipboardManager;
    /* access modifiers changed from: private */
    public final AndroidComposeViewAccessibilityDelegateCompat composeAccessibilityDelegate;
    private Function1<? super Configuration, Unit> configurationChangeObserver;
    private AndroidContentCaptureManager contentCaptureManager;
    private CoroutineContext coroutineContext;
    private int currentFontWeightAdjustment;
    private final MutableState density$delegate;
    private final List<OwnedLayer> dirtyLayers;
    private final DragAndDropManager dragAndDropManager;
    private final DragAndDropModifierOnDragListener dragAndDropModifierOnDragListener;
    private final MutableVector<Function0<Unit>> endApplyChangesListeners;
    private final FocusOwner focusOwner;
    private final MutableState fontFamilyResolver$delegate;
    private final Font.ResourceLoader fontLoader;
    private boolean forceUseMatrixCache;
    private final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    private long globalPosition;
    private final GraphicsContext graphicsContext;
    private final HapticFeedback hapticFeedBack;
    private boolean hoverExitReceived;
    private boolean isDrawingContent;
    private boolean isPendingInteropViewLayoutChangeDispatch;
    private boolean isRenderNodeCompatible;
    private final Modifier keyInputModifier;
    private boolean keyboardModifiersRequireUpdate;
    private long lastDownPointerPosition = Offset.Companion.m4002getUnspecifiedF1C5BW0();
    private long lastMatrixRecalculationAnimationTime;
    private final WeakCache<OwnedLayer> layerCache;
    private final MutableState layoutDirection$delegate;
    private final TextInputServiceAndroid legacyTextInputServiceAndroid;
    private final CalculateMatrixToWindow matrixToWindow;
    private final MeasureAndLayoutDelegate measureAndLayoutDelegate;
    private final ModifierLocalManager modifierLocalManager;
    private final MotionEventAdapter motionEventAdapter;
    private boolean observationClearRequested;
    private Constraints onMeasureConstraints;
    private Function1<? super ViewTreeOwners, Unit> onViewTreeOwnersAvailable;
    private final PointerIconService pointerIconService;
    private final PointerInputEventProcessor pointerInputEventProcessor;
    private List<OwnedLayer> postponedDirtyLayers;
    /* access modifiers changed from: private */
    public MotionEvent previousMotionEvent;
    /* access modifiers changed from: private */
    public long relayoutTime;
    private final Function0<Unit> resendMotionEventOnLayout;
    /* access modifiers changed from: private */
    public final AndroidComposeView$resendMotionEventRunnable$1 resendMotionEventRunnable;
    private final LayoutNode root;
    private final RootForTest rootForTest;
    private final EmptySemanticsModifier rootSemanticsNode;
    private final Modifier rotaryInputModifier;
    private final ScrollCapture scrollCapture;
    private final ViewTreeObserver.OnScrollChangedListener scrollChangedListener;
    private final EmptySemanticsElement semanticsModifier;
    private final SemanticsOwner semanticsOwner;
    private final Runnable sendHoverExitEvent;
    private final LayoutNodeDrawScope sharedDrawScope;
    private boolean showLayoutBounds;
    private final OwnerSnapshotObserver snapshotObserver;
    private final SoftwareKeyboardController softwareKeyboardController;
    private boolean superclassInitComplete = true;
    private final TextInputService textInputService;
    private final AtomicReference<SessionMutex.Session<T>> textInputSessionMutex;
    private final TextToolbar textToolbar;
    private final float[] tmpMatrix;
    private final int[] tmpPositionArray;
    private final ViewTreeObserver.OnTouchModeChangeListener touchModeChangeListener;
    private final ViewConfiguration viewConfiguration;
    private DrawChildContainer viewLayersContainer;
    private final float[] viewToWindowMatrix;
    private final State viewTreeOwners$delegate;
    private boolean wasMeasuredWithMultipleConstraints;
    private long windowPosition;
    private final float[] windowToViewMatrix;

    private final boolean autofillSupported() {
        return true;
    }

    @Deprecated(message = "fontLoader is deprecated, use fontFamilyResolver", replaceWith = @ReplaceWith(expression = "fontFamilyResolver", imports = {}))
    public static /* synthetic */ void getFontLoader$annotations() {
    }

    public static /* synthetic */ void getLastMatrixRecalculationAnimationTime$ui_release$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    public void onAttach(LayoutNode layoutNode) {
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public AndroidComposeView(Context context, CoroutineContext coroutineContext2) {
        super(context);
        ScrollCapture scrollCapture2 = null;
        this.sharedDrawScope = new LayoutNodeDrawScope((CanvasDrawScope) null, 1, (DefaultConstructorMarker) null);
        this.density$delegate = SnapshotStateKt.mutableStateOf(AndroidDensity_androidKt.Density(context), SnapshotStateKt.referentialEqualityPolicy());
        EmptySemanticsModifier emptySemanticsModifier = new EmptySemanticsModifier();
        this.rootSemanticsNode = emptySemanticsModifier;
        EmptySemanticsElement emptySemanticsElement = new EmptySemanticsElement(emptySemanticsModifier);
        this.semanticsModifier = emptySemanticsElement;
        this.focusOwner = new FocusOwnerImpl(new AndroidComposeView$focusOwner$1(this), new AndroidComposeView$focusOwner$2(this), new AndroidComposeView$focusOwner$3(this), new AndroidComposeView$focusOwner$4(this), new AndroidComposeView$focusOwner$5(this), new AndroidComposeView$focusOwner$6(this));
        DragAndDropModifierOnDragListener dragAndDropModifierOnDragListener2 = new DragAndDropModifierOnDragListener(new AndroidComposeView$dragAndDropModifierOnDragListener$1(this));
        this.dragAndDropModifierOnDragListener = dragAndDropModifierOnDragListener2;
        this.coroutineContext = coroutineContext2;
        this.dragAndDropManager = dragAndDropModifierOnDragListener2;
        this._windowInfo = new WindowInfoImpl();
        Modifier onKeyEvent = KeyInputModifierKt.onKeyEvent(Modifier.Companion, new AndroidComposeView$keyInputModifier$1(this));
        this.keyInputModifier = onKeyEvent;
        Modifier onRotaryScrollEvent = RotaryInputModifierKt.onRotaryScrollEvent(Modifier.Companion, AndroidComposeView$rotaryInputModifier$1.INSTANCE);
        this.rotaryInputModifier = onRotaryScrollEvent;
        this.canvasHolder = new CanvasHolder();
        LayoutNode layoutNode = new LayoutNode(false, 0, 3, (DefaultConstructorMarker) null);
        layoutNode.setMeasurePolicy(RootMeasurePolicy.INSTANCE);
        layoutNode.setDensity(getDensity());
        layoutNode.setModifier(Modifier.Companion.then(emptySemanticsElement).then(onRotaryScrollEvent).then(onKeyEvent).then(getFocusOwner().getModifier()).then(dragAndDropModifierOnDragListener2.getModifier()));
        this.root = layoutNode;
        this.rootForTest = this;
        this.semanticsOwner = new SemanticsOwner(getRoot(), emptySemanticsModifier);
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = new AndroidComposeViewAccessibilityDelegateCompat(this);
        this.composeAccessibilityDelegate = androidComposeViewAccessibilityDelegateCompat;
        this.contentCaptureManager = new AndroidContentCaptureManager(this, new AndroidComposeView$contentCaptureManager$1(this));
        this.accessibilityManager = new AndroidAccessibilityManager(context);
        this.graphicsContext = AndroidGraphicsContext_androidKt.GraphicsContext(this);
        this.autofillTree = new AutofillTree();
        this.dirtyLayers = new ArrayList();
        this.motionEventAdapter = new MotionEventAdapter();
        this.pointerInputEventProcessor = new PointerInputEventProcessor(getRoot());
        this.configurationChangeObserver = AndroidComposeView$configurationChangeObserver$1.INSTANCE;
        this._autofill = autofillSupported() ? new AndroidAutofill(this, getAutofillTree()) : null;
        this.clipboardManager = new AndroidClipboardManager(context);
        this.snapshotObserver = new OwnerSnapshotObserver(new AndroidComposeView$snapshotObserver$1(this));
        this.measureAndLayoutDelegate = new MeasureAndLayoutDelegate(getRoot());
        this.viewConfiguration = new AndroidViewConfiguration(ViewConfiguration.get(context));
        this.globalPosition = IntOffsetKt.IntOffset(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.tmpPositionArray = new int[]{0, 0};
        float[] r1 = Matrix.m4474constructorimpl$default((float[]) null, 1, (DefaultConstructorMarker) null);
        this.tmpMatrix = r1;
        this.viewToWindowMatrix = Matrix.m4474constructorimpl$default((float[]) null, 1, (DefaultConstructorMarker) null);
        this.windowToViewMatrix = Matrix.m4474constructorimpl$default((float[]) null, 1, (DefaultConstructorMarker) null);
        this.lastMatrixRecalculationAnimationTime = -1;
        this.windowPosition = Offset.Companion.m4001getInfiniteF1C5BW0();
        this.isRenderNodeCompatible = true;
        this._viewTreeOwners$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.viewTreeOwners$delegate = SnapshotStateKt.derivedStateOf(new AndroidComposeView$viewTreeOwners$2(this));
        this.globalLayoutListener = new AndroidComposeView$$ExternalSyntheticLambda0(this);
        this.scrollChangedListener = new AndroidComposeView$$ExternalSyntheticLambda1(this);
        this.touchModeChangeListener = new AndroidComposeView$$ExternalSyntheticLambda2(this);
        TextInputServiceAndroid textInputServiceAndroid = new TextInputServiceAndroid(getView(), this);
        this.legacyTextInputServiceAndroid = textInputServiceAndroid;
        this.textInputService = new TextInputService(AndroidComposeView_androidKt.getPlatformTextInputServiceInterceptor().invoke(textInputServiceAndroid));
        this.textInputSessionMutex = SessionMutex.m3824constructorimpl();
        this.softwareKeyboardController = new DelegatingSoftwareKeyboardController(getTextInputService());
        this.fontLoader = new AndroidFontResourceLoader(context);
        this.fontFamilyResolver$delegate = SnapshotStateKt.mutableStateOf(FontFamilyResolver_androidKt.createFontFamilyResolver(context), SnapshotStateKt.referentialEqualityPolicy());
        this.currentFontWeightAdjustment = getFontWeightAdjustmentCompat(context.getResources().getConfiguration());
        LayoutDirection layoutDirection = FocusInteropUtils_androidKt.toLayoutDirection(context.getResources().getConfiguration().getLayoutDirection());
        this.layoutDirection$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(layoutDirection == null ? LayoutDirection.Ltr : layoutDirection, (SnapshotMutationPolicy) null, 2, (Object) null);
        View view = this;
        this.hapticFeedBack = new PlatformHapticFeedback(view);
        this._inputModeManager = new InputModeManagerImpl(isInTouchMode() ? InputMode.Companion.m5111getTouchaOaMEAU() : InputMode.Companion.m5110getKeyboardaOaMEAU(), new AndroidComposeView$_inputModeManager$1(this), (DefaultConstructorMarker) null);
        Owner owner = this;
        this.modifierLocalManager = new ModifierLocalManager(owner);
        this.textToolbar = new AndroidTextToolbar(view);
        this.layerCache = new WeakCache<>();
        this.endApplyChangesListeners = new MutableVector<>(new Function0[16], 0);
        this.resendMotionEventRunnable = new AndroidComposeView$resendMotionEventRunnable$1(this);
        this.sendHoverExitEvent = new AndroidComposeView$$ExternalSyntheticLambda3(this);
        this.resendMotionEventOnLayout = new AndroidComposeView$resendMotionEventOnLayout$1(this);
        this.matrixToWindow = Build.VERSION.SDK_INT < 29 ? new CalculateMatrixToWindowApi21(r1, (DefaultConstructorMarker) null) : new CalculateMatrixToWindowApi29();
        addOnAttachStateChangeListener(this.contentCaptureManager);
        setWillNotDraw(false);
        setFocusable(true);
        AndroidComposeViewVerificationHelperMethodsO.INSTANCE.focusable(view, 1, false);
        setFocusableInTouchMode(true);
        setClipChildren(false);
        ViewCompat.setAccessibilityDelegate(view, androidComposeViewAccessibilityDelegateCompat);
        Function1<ViewRootForTest, Unit> onViewCreatedCallback = ViewRootForTest.Companion.getOnViewCreatedCallback();
        if (onViewCreatedCallback != null) {
            onViewCreatedCallback.invoke(this);
        }
        setOnDragListener(dragAndDropModifierOnDragListener2);
        getRoot().attach$ui_release(owner);
        if (Build.VERSION.SDK_INT >= 29) {
            AndroidComposeViewForceDarkModeQ.INSTANCE.disallowForceDark(view);
        }
        this.scrollCapture = Build.VERSION.SDK_INT >= 31 ? new ScrollCapture() : scrollCapture2;
        this.pointerIconService = new AndroidComposeView$pointerIconService$1(this);
    }

    public LayoutNodeDrawScope getSharedDrawScope() {
        return this.sharedDrawScope;
    }

    public View getView() {
        return this;
    }

    private void setDensity(Density density) {
        this.density$delegate.setValue(density);
    }

    public Density getDensity() {
        return (Density) this.density$delegate.getValue();
    }

    public FocusOwner getFocusOwner() {
        return this.focusOwner;
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public void setCoroutineContext(CoroutineContext coroutineContext2) {
        this.coroutineContext = coroutineContext2;
        Modifier.Node head$ui_release = getRoot().getNodes$ui_release().getHead$ui_release();
        if (head$ui_release instanceof SuspendingPointerInputModifierNode) {
            ((SuspendingPointerInputModifierNode) head$ui_release).resetPointerInputHandler();
        }
        DelegatableNode delegatableNode = head$ui_release;
        int r1 = NodeKind.m6139constructorimpl(16);
        if (!delegatableNode.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtree called on an unattached node");
        }
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        NestedVectorStack nestedVectorStack = new NestedVectorStack();
        while (requireLayoutNode != null) {
            if (child$ui_release == null) {
                child$ui_release = requireLayoutNode.getNodes$ui_release().getHead$ui_release();
            }
            if ((child$ui_release.getAggregateChildKindSet$ui_release() & r1) != 0) {
                while (child$ui_release != null) {
                    if ((child$ui_release.getKindSet$ui_release() & r1) != 0) {
                        Modifier.Node node = child$ui_release;
                        MutableVector mutableVector = null;
                        while (node != null) {
                            if (node instanceof PointerInputModifierNode) {
                                PointerInputModifierNode pointerInputModifierNode = (PointerInputModifierNode) node;
                                if (pointerInputModifierNode instanceof SuspendingPointerInputModifierNode) {
                                    ((SuspendingPointerInputModifierNode) pointerInputModifierNode).resetPointerInputHandler();
                                }
                            } else if ((node.getKindSet$ui_release() & r1) != 0 && (node instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                    if ((delegate$ui_release.getKindSet$ui_release() & r1) != 0) {
                                        i++;
                                        if (i == 1) {
                                            node = delegate$ui_release;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(node);
                                                }
                                                node = null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate$ui_release);
                                            }
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    child$ui_release = child$ui_release.getChild$ui_release();
                }
            }
            nestedVectorStack.push(requireLayoutNode.get_children$ui_release());
            requireLayoutNode = nestedVectorStack.isNotEmpty() ? (LayoutNode) nestedVectorStack.pop() : null;
            child$ui_release = null;
        }
    }

    public DragAndDropManager getDragAndDropManager() {
        return this.dragAndDropManager;
    }

    public WindowInfo getWindowInfo() {
        return this._windowInfo;
    }

    /* access modifiers changed from: private */
    /* renamed from: onMoveFocusInChildren-3ESFkO8  reason: not valid java name */
    public final boolean m6228onMoveFocusInChildren3ESFkO8(int i) {
        View view;
        if (FocusDirection.m3892equalsimpl0(i, FocusDirection.Companion.m3899getEnterdhqQ8s()) || FocusDirection.m3892equalsimpl0(i, FocusDirection.Companion.m3900getExitdhqQ8s())) {
            return false;
        }
        Integer r6 = FocusInteropUtils_androidKt.m3906toAndroidFocusDirection3ESFkO8(i);
        if (r6 != null) {
            int intValue = r6.intValue();
            Rect onFetchFocusRect = onFetchFocusRect();
            android.graphics.Rect androidRect = onFetchFocusRect != null ? RectHelper_androidKt.toAndroidRect(onFetchFocusRect) : null;
            FocusFinder instance = FocusFinder.getInstance();
            if (androidRect == null) {
                view = instance.findNextFocus(this, findFocus(), intValue);
            } else {
                view = instance.findNextFocusFromRect(this, androidRect, intValue);
            }
            if (view != null) {
                return FocusInteropUtils_androidKt.requestInteropFocus(view, Integer.valueOf(intValue), androidRect);
            }
            return false;
        }
        throw new IllegalStateException("Invalid focus direction".toString());
    }

    /* access modifiers changed from: private */
    public final Rect onFetchFocusRect() {
        if (isFocused()) {
            return getFocusOwner().getFocusRect();
        }
        View findFocus = findFocus();
        if (findFocus != null) {
            return FocusInteropUtils_androidKt.calculateBoundingRect(findFocus);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final View findNextNonChildView(int i) {
        View view = this;
        View view2 = view;
        while (view2 != null) {
            FocusFinder instance = FocusFinder.getInstance();
            View rootView = getRootView();
            Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            view2 = instance.findNextFocus((ViewGroup) rootView, view2, i);
            if (view2 != null && !AndroidComposeView_androidKt.containsDescendant(view, view2)) {
                return view2;
            }
        }
        return null;
    }

    public LayoutNode getRoot() {
        return this.root;
    }

    public RootForTest getRootForTest() {
        return this.rootForTest;
    }

    public SemanticsOwner getSemanticsOwner() {
        return this.semanticsOwner;
    }

    public final AndroidContentCaptureManager getContentCaptureManager$ui_release() {
        return this.contentCaptureManager;
    }

    public final void setContentCaptureManager$ui_release(AndroidContentCaptureManager androidContentCaptureManager) {
        this.contentCaptureManager = androidContentCaptureManager;
    }

    public AndroidAccessibilityManager getAccessibilityManager() {
        return this.accessibilityManager;
    }

    public GraphicsContext getGraphicsContext() {
        return this.graphicsContext;
    }

    public AutofillTree getAutofillTree() {
        return this.autofillTree;
    }

    public final Function1<Configuration, Unit> getConfigurationChangeObserver() {
        return this.configurationChangeObserver;
    }

    public final void setConfigurationChangeObserver(Function1<? super Configuration, Unit> function1) {
        this.configurationChangeObserver = function1;
    }

    public Autofill getAutofill() {
        return this._autofill;
    }

    public AndroidClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    public OwnerSnapshotObserver getSnapshotObserver() {
        return this.snapshotObserver;
    }

    public boolean getShowLayoutBounds() {
        return this.showLayoutBounds;
    }

    public void setShowLayoutBounds(boolean z) {
        this.showLayoutBounds = z;
    }

    public final AndroidViewsHandler getAndroidViewsHandler$ui_release() {
        if (this._androidViewsHandler == null) {
            AndroidViewsHandler androidViewsHandler = new AndroidViewsHandler(getContext());
            this._androidViewsHandler = androidViewsHandler;
            addView(androidViewsHandler);
            requestLayout();
        }
        AndroidViewsHandler androidViewsHandler2 = this._androidViewsHandler;
        Intrinsics.checkNotNull(androidViewsHandler2);
        return androidViewsHandler2;
    }

    public long getMeasureIteration() {
        return this.measureAndLayoutDelegate.getMeasureIteration();
    }

    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    public boolean getHasPendingMeasureOrLayout() {
        return this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout();
    }

    public final long getLastMatrixRecalculationAnimationTime$ui_release() {
        return this.lastMatrixRecalculationAnimationTime;
    }

    public final void setLastMatrixRecalculationAnimationTime$ui_release(long j) {
        this.lastMatrixRecalculationAnimationTime = j;
    }

    /* access modifiers changed from: private */
    public final ViewTreeOwners get_viewTreeOwners() {
        return (ViewTreeOwners) this._viewTreeOwners$delegate.getValue();
    }

    private final void set_viewTreeOwners(ViewTreeOwners viewTreeOwners) {
        this._viewTreeOwners$delegate.setValue(viewTreeOwners);
    }

    public final ViewTreeOwners getViewTreeOwners() {
        return (ViewTreeOwners) this.viewTreeOwners$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final void globalLayoutListener$lambda$4(AndroidComposeView androidComposeView) {
        androidComposeView.updatePositionCacheAndDispatch();
    }

    /* access modifiers changed from: private */
    public static final void scrollChangedListener$lambda$5(AndroidComposeView androidComposeView) {
        androidComposeView.updatePositionCacheAndDispatch();
    }

    /* access modifiers changed from: private */
    public static final void touchModeChangeListener$lambda$6(AndroidComposeView androidComposeView, boolean z) {
        androidComposeView._inputModeManager.m5116setInputModeiuPiT84(z ? InputMode.Companion.m5111getTouchaOaMEAU() : InputMode.Companion.m5110getKeyboardaOaMEAU());
    }

    public TextInputService getTextInputService() {
        return this.textInputService;
    }

    public SoftwareKeyboardController getSoftwareKeyboardController() {
        return this.softwareKeyboardController;
    }

    public Placeable.PlacementScope getPlacementScope() {
        return PlaceableKt.PlacementScope((Owner) this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object textInputSession(kotlin.jvm.functions.Function2<? super androidx.compose.ui.platform.PlatformTextInputSessionScope, ? super kotlin.coroutines.Continuation<?>, ? extends java.lang.Object> r5, kotlin.coroutines.Continuation<?> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.compose.ui.platform.AndroidComposeView$textInputSession$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            androidx.compose.ui.platform.AndroidComposeView$textInputSession$1 r0 = (androidx.compose.ui.platform.AndroidComposeView$textInputSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            androidx.compose.ui.platform.AndroidComposeView$textInputSession$1 r0 = new androidx.compose.ui.platform.AndroidComposeView$textInputSession$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 == r3) goto L_0x002e
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x002e:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0047
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            java.util.concurrent.atomic.AtomicReference<androidx.compose.ui.SessionMutex$Session<T>> r6 = r4.textInputSessionMutex
            androidx.compose.ui.platform.AndroidComposeView$textInputSession$2 r2 = new androidx.compose.ui.platform.AndroidComposeView$textInputSession$2
            r2.<init>(r4)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r0.label = r3
            java.lang.Object r5 = androidx.compose.ui.SessionMutex.m3831withSessionCancellingPreviousimpl(r6, r2, r5, r0)
            if (r5 != r1) goto L_0x0047
            return r1
        L_0x0047:
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView.textInputSession(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Font.ResourceLoader getFontLoader() {
        return this.fontLoader;
    }

    private void setFontFamilyResolver(FontFamily.Resolver resolver) {
        this.fontFamilyResolver$delegate.setValue(resolver);
    }

    public FontFamily.Resolver getFontFamilyResolver() {
        return (FontFamily.Resolver) this.fontFamilyResolver$delegate.getValue();
    }

    private final int getFontWeightAdjustmentCompat(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            return configuration.fontWeightAdjustment;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public void setLayoutDirection(LayoutDirection layoutDirection) {
        this.layoutDirection$delegate.setValue(layoutDirection);
    }

    public LayoutDirection getLayoutDirection() {
        return (LayoutDirection) this.layoutDirection$delegate.getValue();
    }

    public HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public InputModeManager getInputModeManager() {
        return this._inputModeManager;
    }

    public ModifierLocalManager getModifierLocalManager() {
        return this.modifierLocalManager;
    }

    public TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    /* access modifiers changed from: private */
    public static final void sendHoverExitEvent$lambda$8(AndroidComposeView androidComposeView) {
        androidComposeView.hoverExitReceived = false;
        MotionEvent motionEvent = androidComposeView.previousMotionEvent;
        Intrinsics.checkNotNull(motionEvent);
        if (motionEvent.getActionMasked() == 10) {
            androidComposeView.m6231sendMotionEvent8iAsVTc(motionEvent);
            return;
        }
        throw new IllegalStateException("The ACTION_HOVER_EXIT event was not cleared.".toString());
    }

    public void getFocusedRect(android.graphics.Rect rect) {
        Unit unit;
        Rect onFetchFocusRect = onFetchFocusRect();
        if (onFetchFocusRect != null) {
            rect.left = Math.round(onFetchFocusRect.getLeft());
            rect.top = Math.round(onFetchFocusRect.getTop());
            rect.right = Math.round(onFetchFocusRect.getRight());
            rect.bottom = Math.round(onFetchFocusRect.getBottom());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            super.getFocusedRect(rect);
        }
    }

    public void dispatchProvideStructure(ViewStructure viewStructure) {
        super.dispatchProvideStructure(viewStructure);
    }

    public final boolean getScrollCaptureInProgress$ui_release() {
        ScrollCapture scrollCapture2;
        if (Build.VERSION.SDK_INT < 31 || (scrollCapture2 = this.scrollCapture) == null) {
            return false;
        }
        return scrollCapture2.getScrollCaptureInProgress();
    }

    public void onScrollCaptureSearch(android.graphics.Rect rect, Point point, Consumer<ScrollCaptureTarget> consumer) {
        ScrollCapture scrollCapture2;
        if (Build.VERSION.SDK_INT >= 31 && (scrollCapture2 = this.scrollCapture) != null) {
            scrollCapture2.onScrollCaptureSearch(this, getSemanticsOwner(), getCoroutineContext(), consumer);
        }
    }

    public void onResume(LifecycleOwner lifecycleOwner) {
        setShowLayoutBounds(Companion.getIsShowingLayoutBounds());
    }

    public View focusSearch(View view, int i) {
        if (view != null) {
            Rect calculateBoundingRect = FocusInteropUtils_androidKt.calculateBoundingRect(view);
            FocusDirection focusDirection = FocusInteropUtils_androidKt.toFocusDirection(i);
            if (Intrinsics.areEqual((Object) getFocusOwner().m3912focusSearchULY8qGw(focusDirection != null ? focusDirection.m3895unboximpl() : FocusDirection.Companion.m3898getDowndhqQ8s(), calculateBoundingRect, AndroidComposeView$focusSearch$1.INSTANCE), (Object) true)) {
                return this;
            }
        }
        return super.focusSearch(view, i);
    }

    public boolean requestFocus(int i, android.graphics.Rect rect) {
        if (isFocused()) {
            return true;
        }
        if (getFocusOwner().getRootState().getHasFocus()) {
            return super.requestFocus(i, rect);
        }
        if (isInTouchMode()) {
            return false;
        }
        FocusDirection focusDirection = FocusInteropUtils_androidKt.toFocusDirection(i);
        int r4 = focusDirection != null ? focusDirection.m3895unboximpl() : FocusDirection.Companion.m3899getEnterdhqQ8s();
        Boolean r42 = getFocusOwner().m3912focusSearchULY8qGw(r4, rect != null ? RectHelper_androidKt.toComposeRect(rect) : null, new AndroidComposeView$requestFocus$1(r4));
        if (r42 != null) {
            return r42.booleanValue();
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000f, code lost:
        r2 = androidx.compose.ui.focus.FocusInteropUtils_androidKt.m3906toAndroidFocusDirection3ESFkO8(r2.m3895unboximpl());
     */
    /* renamed from: onRequestFocusForOwner-7o62pno  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m6229onRequestFocusForOwner7o62pno(androidx.compose.ui.focus.FocusDirection r2, androidx.compose.ui.geometry.Rect r3) {
        /*
            r1 = this;
            boolean r0 = r1.isFocused()
            if (r0 != 0) goto L_0x002d
            boolean r0 = r1.hasFocus()
            if (r0 == 0) goto L_0x000d
            goto L_0x002d
        L_0x000d:
            if (r2 == 0) goto L_0x001e
            int r2 = r2.m3895unboximpl()
            java.lang.Integer r2 = androidx.compose.ui.focus.FocusInteropUtils_androidKt.m3906toAndroidFocusDirection3ESFkO8(r2)
            if (r2 == 0) goto L_0x001e
            int r2 = r2.intValue()
            goto L_0x0020
        L_0x001e:
            r2 = 130(0x82, float:1.82E-43)
        L_0x0020:
            if (r3 == 0) goto L_0x0027
            android.graphics.Rect r3 = androidx.compose.ui.graphics.RectHelper_androidKt.toAndroidRect((androidx.compose.ui.geometry.Rect) r3)
            goto L_0x0028
        L_0x0027:
            r3 = 0
        L_0x0028:
            boolean r2 = super.requestFocus(r2, r3)
            return r2
        L_0x002d:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView.m6229onRequestFocusForOwner7o62pno(androidx.compose.ui.focus.FocusDirection, androidx.compose.ui.geometry.Rect):boolean");
    }

    /* access modifiers changed from: private */
    public final void onClearFocusForOwner() {
        if (isFocused() || hasFocus()) {
            super.clearFocus();
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, android.graphics.Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (!z && !hasFocus()) {
            getFocusOwner().releaseFocus();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        boolean access$getIsShowingLayoutBounds;
        this._windowInfo.setWindowFocused(z);
        this.keyboardModifiersRequireUpdate = true;
        super.onWindowFocusChanged(z);
        if (z && getShowLayoutBounds() != (access$getIsShowingLayoutBounds = Companion.getIsShowingLayoutBounds())) {
            setShowLayoutBounds(access$getIsShowingLayoutBounds);
            invalidateDescendants();
        }
    }

    /* renamed from: sendKeyEvent-ZmokQxo  reason: not valid java name */
    public boolean m6240sendKeyEventZmokQxo(KeyEvent keyEvent) {
        return getFocusOwner().m3910dispatchInterceptedSoftKeyboardEventZmokQxo(keyEvent) || FocusOwner.m3908dispatchKeyEventYhN2O0w$default(getFocusOwner(), keyEvent, (Function0) null, 2, (Object) null);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!isFocused()) {
            return getFocusOwner().m3911dispatchKeyEventYhN2O0w(androidx.compose.ui.input.key.KeyEvent.m5414constructorimpl(keyEvent), new AndroidComposeView$dispatchKeyEvent$1(this, keyEvent));
        }
        this._windowInfo.m6349setKeyboardModifiers5xRPYO0(PointerKeyboardModifiers.m5653constructorimpl(keyEvent.getMetaState()));
        return FocusOwner.m3908dispatchKeyEventYhN2O0w$default(getFocusOwner(), androidx.compose.ui.input.key.KeyEvent.m5414constructorimpl(keyEvent), (Function0) null, 2, (Object) null) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        return (isFocused() && getFocusOwner().m3910dispatchInterceptedSoftKeyboardEventZmokQxo(androidx.compose.ui.input.key.KeyEvent.m5414constructorimpl(keyEvent))) || super.dispatchKeyEventPreIme(keyEvent);
    }

    public void forceAccessibilityForTesting(boolean z) {
        this.composeAccessibilityDelegate.setAccessibilityForceEnabledForTesting$ui_release(z);
    }

    public void setAccessibilityEventBatchIntervalMillis(long j) {
        this.composeAccessibilityDelegate.setSendRecurringAccessibilityEventsIntervalMillis$ui_release(j);
    }

    public void onDetach(LayoutNode layoutNode) {
        this.measureAndLayoutDelegate.onNodeDetached(layoutNode);
        requestClearInvalidObservations();
    }

    public final void requestClearInvalidObservations() {
        this.observationClearRequested = true;
    }

    public void onEndApplyChanges() {
        if (this.observationClearRequested) {
            getSnapshotObserver().clearInvalidObservations$ui_release();
            this.observationClearRequested = false;
        }
        AndroidViewsHandler androidViewsHandler = this._androidViewsHandler;
        if (androidViewsHandler != null) {
            clearChildInvalidObservations(androidViewsHandler);
        }
        while (this.endApplyChangesListeners.isNotEmpty()) {
            int size = this.endApplyChangesListeners.getSize();
            for (int i = 0; i < size; i++) {
                Function0 function0 = (Function0) this.endApplyChangesListeners.getContent()[i];
                this.endApplyChangesListeners.set(i, null);
                if (function0 != null) {
                    function0.invoke();
                }
            }
            this.endApplyChangesListeners.removeRange(0, size);
        }
    }

    public void registerOnEndApplyChangesListener(Function0<Unit> function0) {
        if (!this.endApplyChangesListeners.contains(function0)) {
            this.endApplyChangesListeners.add(function0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startDrag-12SF9DM  reason: not valid java name */
    public final boolean m6232startDrag12SF9DM(DragAndDropTransferData dragAndDropTransferData, long j, Function1<? super DrawScope, Unit> function1) {
        Resources resources = getContext().getResources();
        return AndroidComposeViewStartDragAndDropN.INSTANCE.startDragAndDrop(this, dragAndDropTransferData, new ComposeDragShadowBuilder(DensityKt.Density(resources.getDisplayMetrics().density, resources.getConfiguration().fontScale), j, function1, (DefaultConstructorMarker) null));
    }

    private final void clearChildInvalidObservations(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof AndroidComposeView) {
                ((AndroidComposeView) childAt).onEndApplyChanges();
            } else if (childAt instanceof ViewGroup) {
                clearChildInvalidObservations((ViewGroup) childAt);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void addExtraDataToAccessibilityNodeInfoHelper(int i, AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        int orDefault;
        if (Intrinsics.areEqual((Object) str, (Object) this.composeAccessibilityDelegate.getExtraDataTestTraversalBeforeVal$ui_release())) {
            int orDefault2 = this.composeAccessibilityDelegate.getIdToBeforeMap$ui_release().getOrDefault(i, -1);
            if (orDefault2 != -1) {
                accessibilityNodeInfo.getExtras().putInt(str, orDefault2);
            }
        } else if (Intrinsics.areEqual((Object) str, (Object) this.composeAccessibilityDelegate.getExtraDataTestTraversalAfterVal$ui_release()) && (orDefault = this.composeAccessibilityDelegate.getIdToAfterMap$ui_release().getOrDefault(i, -1)) != -1) {
            accessibilityNodeInfo.getExtras().putInt(str, orDefault);
        }
    }

    public void addView(View view) {
        addView(view, -1);
    }

    public void addView(View view, int i) {
        Intrinsics.checkNotNull(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        addView(view, i, layoutParams);
    }

    public void addView(View view, int i, int i2) {
        ViewGroup.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.width = i;
        generateDefaultLayoutParams.height = i2;
        Unit unit = Unit.INSTANCE;
        addView(view, -1, generateDefaultLayoutParams);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        addView(view, -1, layoutParams);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        addViewInLayout(view, i, layoutParams, true);
    }

    public final void addAndroidView(AndroidViewHolder androidViewHolder, LayoutNode layoutNode) {
        getAndroidViewsHandler$ui_release().getHolderToLayoutNode().put(androidViewHolder, layoutNode);
        View view = androidViewHolder;
        getAndroidViewsHandler$ui_release().addView(view);
        getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().put(layoutNode, androidViewHolder);
        androidViewHolder.setImportantForAccessibility(1);
        ViewCompat.setAccessibilityDelegate(view, new AndroidComposeView$addAndroidView$1(this, layoutNode, this));
    }

    public final void removeAndroidView(AndroidViewHolder androidViewHolder) {
        registerOnEndApplyChangesListener(new AndroidComposeView$removeAndroidView$1(this, androidViewHolder));
    }

    public final void drawAndroidView(AndroidViewHolder androidViewHolder, Canvas canvas) {
        getAndroidViewsHandler$ui_release().drawView(androidViewHolder, canvas);
    }

    static /* synthetic */ void scheduleMeasureAndLayout$default(AndroidComposeView androidComposeView, LayoutNode layoutNode, int i, Object obj) {
        if ((i & 1) != 0) {
            layoutNode = null;
        }
        androidComposeView.scheduleMeasureAndLayout(layoutNode);
    }

    private final void scheduleMeasureAndLayout(LayoutNode layoutNode) {
        if (!isLayoutRequested() && isAttachedToWindow()) {
            if (layoutNode != null) {
                while (layoutNode != null && layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock && childSizeCanAffectParentSize(layoutNode)) {
                    layoutNode = layoutNode.getParent$ui_release();
                }
                if (layoutNode == getRoot()) {
                    requestLayout();
                    return;
                }
            }
            if (getWidth() == 0 || getHeight() == 0) {
                requestLayout();
            } else {
                invalidate();
            }
        }
    }

    private final boolean childSizeCanAffectParentSize(LayoutNode layoutNode) {
        if (this.wasMeasuredWithMultipleConstraints) {
            return true;
        }
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        return parent$ui_release != null && !parent$ui_release.getHasFixedInnerContentConstraints$ui_release();
    }

    public void measureAndLayout(boolean z) {
        Function0<Unit> function0;
        if (this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout() || this.measureAndLayoutDelegate.getHasPendingOnPositionedCallbacks()) {
            Trace.beginSection("AndroidOwner:measureAndLayout");
            if (z) {
                try {
                    function0 = this.resendMotionEventOnLayout;
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            } else {
                function0 = null;
            }
            if (this.measureAndLayoutDelegate.measureAndLayout(function0)) {
                requestLayout();
            }
            MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, (Object) null);
            dispatchPendingInteropLayoutCallbacks();
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
        }
    }

    /* renamed from: measureAndLayout-0kLqBqw  reason: not valid java name */
    public void m6238measureAndLayout0kLqBqw(LayoutNode layoutNode, long j) {
        Trace.beginSection("AndroidOwner:measureAndLayout");
        try {
            this.measureAndLayoutDelegate.m6075measureAndLayout0kLqBqw(layoutNode, j);
            if (!this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout()) {
                MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, (Object) null);
                dispatchPendingInteropLayoutCallbacks();
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    private final void dispatchPendingInteropLayoutCallbacks() {
        if (this.isPendingInteropViewLayoutChangeDispatch) {
            getViewTreeObserver().dispatchOnGlobalLayout();
            this.isPendingInteropViewLayoutChangeDispatch = false;
        }
    }

    public void forceMeasureTheSubtree(LayoutNode layoutNode, boolean z) {
        this.measureAndLayoutDelegate.forceMeasureTheSubtree(layoutNode, z);
    }

    public void onRequestMeasure(LayoutNode layoutNode, boolean z, boolean z2, boolean z3) {
        if (z) {
            if (this.measureAndLayoutDelegate.requestLookaheadRemeasure(layoutNode, z2) && z3) {
                scheduleMeasureAndLayout(layoutNode);
            }
        } else if (this.measureAndLayoutDelegate.requestRemeasure(layoutNode, z2) && z3) {
            scheduleMeasureAndLayout(layoutNode);
        }
    }

    public void onRequestRelayout(LayoutNode layoutNode, boolean z, boolean z2) {
        if (z) {
            if (this.measureAndLayoutDelegate.requestLookaheadRelayout(layoutNode, z2)) {
                scheduleMeasureAndLayout$default(this, (LayoutNode) null, 1, (Object) null);
            }
        } else if (this.measureAndLayoutDelegate.requestRelayout(layoutNode, z2)) {
            scheduleMeasureAndLayout$default(this, (LayoutNode) null, 1, (Object) null);
        }
    }

    public void requestOnPositionedCallback(LayoutNode layoutNode) {
        this.measureAndLayoutDelegate.requestOnPositionedCallback(layoutNode);
        scheduleMeasureAndLayout$default(this, (LayoutNode) null, 1, (Object) null);
    }

    public void measureAndLayoutForTest() {
        Owner.measureAndLayout$default(this, false, 1, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        Trace.beginSection("AndroidOwner:onMeasure");
        try {
            if (!isAttachedToWindow()) {
                invalidateLayoutNodeMeasurement(getRoot());
            }
            long r0 = m6226convertMeasureSpecI7RO_PI(i);
            long r5 = m6226convertMeasureSpecI7RO_PI(i2);
            long r8 = Constraints.Companion.m7060fitPrioritizingHeightZbe2FdA((int) ULong.m7997constructorimpl(r0 >>> 32), (int) ULong.m7997constructorimpl(r0 & 4294967295L), (int) ULong.m7997constructorimpl(r5 >>> 32), (int) ULong.m7997constructorimpl(4294967295L & r5));
            Constraints constraints = this.onMeasureConstraints;
            boolean z = false;
            if (constraints == null) {
                this.onMeasureConstraints = Constraints.m7040boximpl(r8);
                this.wasMeasuredWithMultipleConstraints = false;
            } else {
                if (constraints != null) {
                    z = Constraints.m7045equalsimpl0(constraints.m7058unboximpl(), r8);
                }
                if (!z) {
                    this.wasMeasuredWithMultipleConstraints = true;
                }
            }
            this.measureAndLayoutDelegate.m6076updateRootConstraintsBRTryo0(r8);
            this.measureAndLayoutDelegate.measureOnly();
            setMeasuredDimension(getRoot().getWidth(), getRoot().getHeight());
            if (this._androidViewsHandler != null) {
                getAndroidViewsHandler$ui_release().measure(View.MeasureSpec.makeMeasureSpec(getRoot().getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getRoot().getHeight(), 1073741824));
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    /* renamed from: component1-VKZWuLQ  reason: not valid java name */
    private final int m6224component1VKZWuLQ(long j) {
        return (int) ULong.m7997constructorimpl(j >>> 32);
    }

    /* renamed from: component2-VKZWuLQ  reason: not valid java name */
    private final int m6225component2VKZWuLQ(long j) {
        return (int) ULong.m7997constructorimpl(j & 4294967295L);
    }

    /* renamed from: pack-ZIaKswc  reason: not valid java name */
    private final long m6230packZIaKswc(int i, int i2) {
        return ULong.m7997constructorimpl(ULong.m7997constructorimpl((long) i2) | ULong.m7997constructorimpl(ULong.m7997constructorimpl((long) i) << 32));
    }

    /* renamed from: convertMeasureSpec-I7RO_PI  reason: not valid java name */
    private final long m6226convertMeasureSpecI7RO_PI(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            return m6230packZIaKswc(0, size);
        }
        if (mode == 0) {
            return m6230packZIaKswc(0, Integer.MAX_VALUE);
        }
        if (mode == 1073741824) {
            return m6230packZIaKswc(size, size);
        }
        throw new IllegalStateException();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.measureAndLayoutDelegate.measureAndLayout(this.resendMotionEventOnLayout);
        this.onMeasureConstraints = null;
        updatePositionCacheAndDispatch();
        if (this._androidViewsHandler != null) {
            getAndroidViewsHandler$ui_release().layout(0, 0, i3 - i, i4 - i2);
        }
    }

    private final void updatePositionCacheAndDispatch() {
        getLocationOnScreen(this.tmpPositionArray);
        long j = this.globalPosition;
        int r2 = IntOffset.m7241getXimpl(j);
        int r0 = IntOffset.m7242getYimpl(j);
        int[] iArr = this.tmpPositionArray;
        boolean z = false;
        int i = iArr[0];
        if (!(r2 == i && r0 == iArr[1])) {
            this.globalPosition = IntOffsetKt.IntOffset(i, iArr[1]);
            if (!(r2 == Integer.MAX_VALUE || r0 == Integer.MAX_VALUE)) {
                getRoot().getLayoutDelegate$ui_release().getMeasurePassDelegate$ui_release().notifyChildrenUsingCoordinatesWhilePlacing();
                z = true;
            }
        }
        this.measureAndLayoutDelegate.dispatchOnPositionedCallbacks(z);
    }

    public OwnedLayer createLayer(Function2<? super androidx.compose.ui.graphics.Canvas, ? super GraphicsLayer, Unit> function2, Function0<Unit> function0, GraphicsLayer graphicsLayer) {
        DrawChildContainer drawChildContainer;
        if (graphicsLayer != null) {
            return new GraphicsLayerOwnerLayer(graphicsLayer, (GraphicsContext) null, this, function2, function0);
        }
        Function2<? super androidx.compose.ui.graphics.Canvas, ? super GraphicsLayer, Unit> function22 = function2;
        Function0<Unit> function02 = function0;
        OwnedLayer pop = this.layerCache.pop();
        if (pop != null) {
            pop.reuseLayer(function22, function02);
            return pop;
        } else if (!isHardwareAccelerated() || Build.VERSION.SDK_INT == 28) {
            if (isHardwareAccelerated() && this.isRenderNodeCompatible) {
                try {
                    return new RenderNodeLayer(this, function22, function02);
                } catch (Throwable unused) {
                    this.isRenderNodeCompatible = false;
                }
            }
            if (this.viewLayersContainer == null) {
                if (!ViewLayer.Companion.getHasRetrievedMethod()) {
                    ViewLayer.Companion.updateDisplayList(new View(getContext()));
                }
                if (ViewLayer.Companion.getShouldUseDispatchDraw()) {
                    drawChildContainer = new DrawChildContainer(getContext());
                } else {
                    drawChildContainer = new ViewLayerContainer(getContext());
                }
                this.viewLayersContainer = drawChildContainer;
                addView(drawChildContainer);
            }
            DrawChildContainer drawChildContainer2 = this.viewLayersContainer;
            Intrinsics.checkNotNull(drawChildContainer2);
            return new ViewLayer(this, drawChildContainer2, function22, function02);
        } else {
            Function2<? super androidx.compose.ui.graphics.Canvas, ? super GraphicsLayer, Unit> function23 = function22;
            GraphicsLayer createGraphicsLayer = getGraphicsContext().createGraphicsLayer();
            return new GraphicsLayerOwnerLayer(createGraphicsLayer, getGraphicsContext(), this, function23, function02);
        }
    }

    public final boolean recycle$ui_release(OwnedLayer ownedLayer) {
        if (this.viewLayersContainer != null) {
            ViewLayer.Companion.getShouldUseDispatchDraw();
        }
        this.layerCache.push(ownedLayer);
        return true;
    }

    public void onSemanticsChange() {
        this.composeAccessibilityDelegate.onSemanticsChange$ui_release();
        this.contentCaptureManager.onSemanticsChange$ui_release();
    }

    public void onLayoutChange(LayoutNode layoutNode) {
        this.composeAccessibilityDelegate.onLayoutChange$ui_release(layoutNode);
        this.contentCaptureManager.onLayoutChange$ui_release(layoutNode);
    }

    public void onInteropViewLayoutChange(View view) {
        this.isPendingInteropViewLayoutChangeDispatch = true;
    }

    public void registerOnLayoutCompletedListener(Owner.OnLayoutCompletedListener onLayoutCompletedListener) {
        this.measureAndLayoutDelegate.registerOnLayoutCompletedListener(onLayoutCompletedListener);
        scheduleMeasureAndLayout$default(this, (LayoutNode) null, 1, (Object) null);
    }

    /* renamed from: getFocusDirection-P8AzH3I  reason: not valid java name */
    public FocusDirection m6235getFocusDirectionP8AzH3I(KeyEvent keyEvent) {
        long r0 = KeyEvent_androidKt.m5430getKeyZmokQxo(keyEvent);
        if (Key.m5122equalsimpl0(r0, Key.Companion.m5358getTabEK5gGoQ())) {
            return FocusDirection.m3889boximpl(KeyEvent_androidKt.m5436isShiftPressedZmokQxo(keyEvent) ? FocusDirection.Companion.m3903getPreviousdhqQ8s() : FocusDirection.Companion.m3902getNextdhqQ8s());
        } else if (Key.m5122equalsimpl0(r0, Key.Companion.m5199getDirectionRightEK5gGoQ())) {
            return FocusDirection.m3889boximpl(FocusDirection.Companion.m3904getRightdhqQ8s());
        } else {
            if (Key.m5122equalsimpl0(r0, Key.Companion.m5198getDirectionLeftEK5gGoQ())) {
                return FocusDirection.m3889boximpl(FocusDirection.Companion.m3901getLeftdhqQ8s());
            }
            boolean z = true;
            if (Key.m5122equalsimpl0(r0, Key.Companion.m5200getDirectionUpEK5gGoQ()) ? true : Key.m5122equalsimpl0(r0, Key.Companion.m5311getPageUpEK5gGoQ())) {
                return FocusDirection.m3889boximpl(FocusDirection.Companion.m3905getUpdhqQ8s());
            }
            if (Key.m5122equalsimpl0(r0, Key.Companion.m5195getDirectionDownEK5gGoQ()) ? true : Key.m5122equalsimpl0(r0, Key.Companion.m5310getPageDownEK5gGoQ())) {
                return FocusDirection.m3889boximpl(FocusDirection.Companion.m3898getDowndhqQ8s());
            }
            if (Key.m5122equalsimpl0(r0, Key.Companion.m5194getDirectionCenterEK5gGoQ()) ? true : Key.m5122equalsimpl0(r0, Key.Companion.m5208getEnterEK5gGoQ()) ? true : Key.m5122equalsimpl0(r0, Key.Companion.m5300getNumPadEnterEK5gGoQ())) {
                return FocusDirection.m3889boximpl(FocusDirection.Companion.m3899getEnterdhqQ8s());
            }
            if (!Key.m5122equalsimpl0(r0, Key.Companion.m5137getBackEK5gGoQ())) {
                z = Key.m5122equalsimpl0(r0, Key.Companion.m5211getEscapeEK5gGoQ());
            }
            if (z) {
                return FocusDirection.m3889boximpl(FocusDirection.Companion.m3900getExitdhqQ8s());
            }
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (!isAttachedToWindow()) {
            invalidateLayers(getRoot());
        }
        Owner.measureAndLayout$default(this, false, 1, (Object) null);
        Snapshot.Companion.sendApplyNotifications();
        this.isDrawingContent = true;
        CanvasHolder canvasHolder2 = this.canvasHolder;
        Canvas internalCanvas = canvasHolder2.getAndroidCanvas().getInternalCanvas();
        canvasHolder2.getAndroidCanvas().setInternalCanvas(canvas);
        getRoot().draw$ui_release(canvasHolder2.getAndroidCanvas(), (GraphicsLayer) null);
        canvasHolder2.getAndroidCanvas().setInternalCanvas(internalCanvas);
        if (!this.dirtyLayers.isEmpty()) {
            int size = this.dirtyLayers.size();
            for (int i = 0; i < size; i++) {
                this.dirtyLayers.get(i).updateDisplayList();
            }
        }
        if (ViewLayer.Companion.getShouldUseDispatchDraw()) {
            int save = canvas.save();
            canvas.clipRect(0.0f, 0.0f, 0.0f, 0.0f);
            super.dispatchDraw(canvas);
            canvas.restoreToCount(save);
        }
        this.dirtyLayers.clear();
        this.isDrawingContent = false;
        List<OwnedLayer> list = this.postponedDirtyLayers;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            this.dirtyLayers.addAll(list);
            list.clear();
        }
    }

    public final void notifyLayerIsDirty$ui_release(OwnedLayer ownedLayer, boolean z) {
        if (!z) {
            if (!this.isDrawingContent) {
                this.dirtyLayers.remove(ownedLayer);
                List<OwnedLayer> list = this.postponedDirtyLayers;
                if (list != null) {
                    list.remove(ownedLayer);
                }
            }
        } else if (!this.isDrawingContent) {
            this.dirtyLayers.add(ownedLayer);
        } else {
            List<OwnedLayer> list2 = this.postponedDirtyLayers;
            if (list2 == null) {
                list2 = new ArrayList<>();
                this.postponedDirtyLayers = list2;
            }
            list2.add(ownedLayer);
        }
    }

    public final void setOnViewTreeOwnersAvailable(Function1<? super ViewTreeOwners, Unit> function1) {
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null) {
            function1.invoke(viewTreeOwners);
        }
        if (!isAttachedToWindow()) {
            this.onViewTreeOwnersAvailable = function1;
        }
    }

    public final Object boundsUpdatesContentCaptureEventLoop(Continuation<? super Unit> continuation) {
        Object boundsUpdatesEventLoop$ui_release = this.contentCaptureManager.boundsUpdatesEventLoop$ui_release(continuation);
        return boundsUpdatesEventLoop$ui_release == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? boundsUpdatesEventLoop$ui_release : Unit.INSTANCE;
    }

    public final Object boundsUpdatesAccessibilityEventLoop(Continuation<? super Unit> continuation) {
        Object boundsUpdatesEventLoop$ui_release = this.composeAccessibilityDelegate.boundsUpdatesEventLoop$ui_release(continuation);
        return boundsUpdatesEventLoop$ui_release == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? boundsUpdatesEventLoop$ui_release : Unit.INSTANCE;
    }

    private final void invalidateLayoutNodeMeasurement(LayoutNode layoutNode) {
        int i = 0;
        MeasureAndLayoutDelegate.requestRemeasure$default(this.measureAndLayoutDelegate, layoutNode, false, 2, (Object) null);
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            do {
                invalidateLayoutNodeMeasurement((LayoutNode) content[i]);
                i++;
            } while (i < size);
        }
    }

    private final void invalidateLayers(LayoutNode layoutNode) {
        layoutNode.invalidateLayers$ui_release();
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i = 0;
            do {
                invalidateLayers((LayoutNode) content[i]);
                i++;
            } while (i < size);
        }
    }

    public void invalidateDescendants() {
        invalidateLayers(getRoot());
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        LifecycleOwner lifecycleOwner;
        LifecycleOwner lifecycleOwner2;
        Lifecycle lifecycle;
        AndroidAutofill androidAutofill;
        super.onAttachedToWindow();
        this._windowInfo.setWindowFocused(hasWindowFocus());
        invalidateLayoutNodeMeasurement(getRoot());
        invalidateLayers(getRoot());
        getSnapshotObserver().startObserving$ui_release();
        if (autofillSupported() && (androidAutofill = this._autofill) != null) {
            AutofillCallback.INSTANCE.register(androidAutofill);
        }
        View view = this;
        LifecycleOwner lifecycleOwner3 = ViewTreeLifecycleOwner.get(view);
        SavedStateRegistryOwner savedStateRegistryOwner = ViewTreeSavedStateRegistryOwner.get(view);
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        Lifecycle lifecycle2 = null;
        if (viewTreeOwners == null || !(lifecycleOwner3 == null || savedStateRegistryOwner == null || (lifecycleOwner3 == viewTreeOwners.getLifecycleOwner() && savedStateRegistryOwner == viewTreeOwners.getLifecycleOwner()))) {
            if (lifecycleOwner3 == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagate ViewTreeLifecycleOwner!");
            } else if (savedStateRegistryOwner != null) {
                if (!(viewTreeOwners == null || (lifecycleOwner2 = viewTreeOwners.getLifecycleOwner()) == null || (lifecycle = lifecycleOwner2.getLifecycle()) == null)) {
                    lifecycle.removeObserver(this);
                }
                lifecycleOwner3.getLifecycle().addObserver(this);
                ViewTreeOwners viewTreeOwners2 = new ViewTreeOwners(lifecycleOwner3, savedStateRegistryOwner);
                set_viewTreeOwners(viewTreeOwners2);
                Function1<? super ViewTreeOwners, Unit> function1 = this.onViewTreeOwnersAvailable;
                if (function1 != null) {
                    function1.invoke(viewTreeOwners2);
                }
                this.onViewTreeOwnersAvailable = null;
            } else {
                throw new IllegalStateException("Composed into the View which doesn't propagateViewTreeSavedStateRegistryOwner!");
            }
        }
        this._inputModeManager.m5116setInputModeiuPiT84(isInTouchMode() ? InputMode.Companion.m5111getTouchaOaMEAU() : InputMode.Companion.m5110getKeyboardaOaMEAU());
        ViewTreeOwners viewTreeOwners3 = getViewTreeOwners();
        if (!(viewTreeOwners3 == null || (lifecycleOwner = viewTreeOwners3.getLifecycleOwner()) == null)) {
            lifecycle2 = lifecycleOwner.getLifecycle();
        }
        if (lifecycle2 != null) {
            lifecycle2.addObserver(this);
            lifecycle2.addObserver(this.contentCaptureManager);
            getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
            getViewTreeObserver().addOnScrollChangedListener(this.scrollChangedListener);
            getViewTreeObserver().addOnTouchModeChangeListener(this.touchModeChangeListener);
            if (Build.VERSION.SDK_INT >= 31) {
                AndroidComposeViewTranslationCallbackS.INSTANCE.setViewTranslationCallback(view);
                return;
            }
            return;
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("No lifecycle owner exists");
        throw new KotlinNothingValueException();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0010, code lost:
        r0 = r0.getLifecycleOwner();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDetachedFromWindow() {
        /*
            r2 = this;
            super.onDetachedFromWindow()
            androidx.compose.ui.node.OwnerSnapshotObserver r0 = r2.getSnapshotObserver()
            r0.stopObserving$ui_release()
            androidx.compose.ui.platform.AndroidComposeView$ViewTreeOwners r0 = r2.getViewTreeOwners()
            if (r0 == 0) goto L_0x001b
            androidx.lifecycle.LifecycleOwner r0 = r0.getLifecycleOwner()
            if (r0 == 0) goto L_0x001b
            androidx.lifecycle.Lifecycle r0 = r0.getLifecycle()
            goto L_0x001c
        L_0x001b:
            r0 = 0
        L_0x001c:
            if (r0 == 0) goto L_0x0064
            androidx.compose.ui.contentcapture.AndroidContentCaptureManager r1 = r2.contentCaptureManager
            androidx.lifecycle.LifecycleObserver r1 = (androidx.lifecycle.LifecycleObserver) r1
            r0.removeObserver(r1)
            r1 = r2
            androidx.lifecycle.LifecycleObserver r1 = (androidx.lifecycle.LifecycleObserver) r1
            r0.removeObserver(r1)
            boolean r0 = r2.autofillSupported()
            if (r0 == 0) goto L_0x003a
            androidx.compose.ui.autofill.AndroidAutofill r0 = r2._autofill
            if (r0 == 0) goto L_0x003a
            androidx.compose.ui.autofill.AutofillCallback r1 = androidx.compose.ui.autofill.AutofillCallback.INSTANCE
            r1.unregister(r0)
        L_0x003a:
            android.view.ViewTreeObserver r0 = r2.getViewTreeObserver()
            android.view.ViewTreeObserver$OnGlobalLayoutListener r1 = r2.globalLayoutListener
            r0.removeOnGlobalLayoutListener(r1)
            android.view.ViewTreeObserver r0 = r2.getViewTreeObserver()
            android.view.ViewTreeObserver$OnScrollChangedListener r1 = r2.scrollChangedListener
            r0.removeOnScrollChangedListener(r1)
            android.view.ViewTreeObserver r0 = r2.getViewTreeObserver()
            android.view.ViewTreeObserver$OnTouchModeChangeListener r1 = r2.touchModeChangeListener
            r0.removeOnTouchModeChangeListener(r1)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 31
            if (r0 < r1) goto L_0x0063
            androidx.compose.ui.platform.AndroidComposeViewTranslationCallbackS r0 = androidx.compose.ui.platform.AndroidComposeViewTranslationCallbackS.INSTANCE
            r1 = r2
            android.view.View r1 = (android.view.View) r1
            r0.clearViewTranslationCallback(r1)
        L_0x0063:
            return
        L_0x0064:
            java.lang.String r0 = "No lifecycle owner exists"
            androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateExceptionForNullCheck(r0)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView.onDetachedFromWindow():void");
    }

    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i) {
        AndroidAutofill androidAutofill;
        if (autofillSupported() && viewStructure != null && (androidAutofill = this._autofill) != null) {
            AndroidAutofill_androidKt.populateViewStructure(androidAutofill, viewStructure);
        }
    }

    public void autofill(SparseArray<AutofillValue> sparseArray) {
        AndroidAutofill androidAutofill;
        if (autofillSupported() && (androidAutofill = this._autofill) != null) {
            AndroidAutofill_androidKt.performAutofill(androidAutofill, sparseArray);
        }
    }

    public void onCreateVirtualViewTranslationRequests(long[] jArr, int[] iArr, Consumer<ViewTranslationRequest> consumer) {
        this.contentCaptureManager.onCreateVirtualViewTranslationRequests$ui_release(jArr, iArr, consumer);
    }

    public void onVirtualViewTranslationResponses(LongSparseArray<ViewTranslationResponse> longSparseArray) {
        AndroidContentCaptureManager androidContentCaptureManager = this.contentCaptureManager;
        androidContentCaptureManager.onVirtualViewTranslationResponses$ui_release(androidContentCaptureManager, longSparseArray);
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            if (motionEvent.getActionMasked() == 8) {
                this.hoverExitReceived = false;
            } else {
                this.sendHoverExitEvent.run();
            }
        }
        if (motionEvent.getActionMasked() != 8) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        if (isBadMotionEvent(motionEvent) || !isAttachedToWindow()) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        if (motionEvent.isFromSource(4194304)) {
            return handleRotaryEvent(motionEvent);
        }
        return ProcessResult.m5679getDispatchedToAPointerInputModifierimpl(m6227handleMotionEvent8iAsVTc(motionEvent));
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            MotionEvent motionEvent2 = this.previousMotionEvent;
            Intrinsics.checkNotNull(motionEvent2);
            if (motionEvent.getActionMasked() != 0 || hasChangedDevices(motionEvent, motionEvent2)) {
                this.sendHoverExitEvent.run();
            } else {
                this.hoverExitReceived = false;
            }
        }
        if (isBadMotionEvent(motionEvent) || !isAttachedToWindow()) {
            return false;
        }
        if (motionEvent.getActionMasked() == 2 && !isPositionChanged(motionEvent)) {
            return false;
        }
        int r4 = m6227handleMotionEvent8iAsVTc(motionEvent);
        if (ProcessResult.m5678getAnyMovementConsumedimpl(r4)) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return ProcessResult.m5679getDispatchedToAPointerInputModifierimpl(r4);
    }

    private final boolean handleRotaryEvent(MotionEvent motionEvent) {
        ViewConfiguration viewConfiguration2 = ViewConfiguration.get(getContext());
        float f = -motionEvent.getAxisValue(26);
        return getFocusOwner().dispatchRotaryEvent(new RotaryScrollEvent(ViewConfigurationCompat.getScaledVerticalScrollFactor(viewConfiguration2, getContext()) * f, f * ViewConfigurationCompat.getScaledHorizontalScrollFactor(viewConfiguration2, getContext()), motionEvent.getEventTime(), motionEvent.getDeviceId()));
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0060 A[Catch:{ all -> 0x011e }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0062 A[Catch:{ all -> 0x011e }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008b A[Catch:{ all -> 0x0122 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x009c A[Catch:{ all -> 0x0122 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a1 A[Catch:{ all -> 0x0122 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ae A[Catch:{ all -> 0x0122 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b6 A[Catch:{ all -> 0x0122 }] */
    /* renamed from: handleMotionEvent-8iAsVTc  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int m6227handleMotionEvent8iAsVTc(android.view.MotionEvent r17) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            androidx.compose.ui.platform.AndroidComposeView$resendMotionEventRunnable$1 r2 = r1.resendMotionEventRunnable
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r1.removeCallbacks(r2)
            r9 = 0
            r16.recalculateWindowPosition(r17)     // Catch:{ all -> 0x0127 }
            r10 = 1
            r1.forceUseMatrixCache = r10     // Catch:{ all -> 0x0127 }
            r1.measureAndLayout(r9)     // Catch:{ all -> 0x0127 }
            java.lang.String r2 = "AndroidOwner:onTouch"
            android.os.Trace.beginSection(r2)     // Catch:{ all -> 0x0127 }
            int r11 = r0.getActionMasked()     // Catch:{ all -> 0x0122 }
            android.view.MotionEvent r2 = r1.previousMotionEvent     // Catch:{ all -> 0x0122 }
            r12 = 3
            if (r2 == 0) goto L_0x002b
            int r3 = r2.getToolType(r9)     // Catch:{ all -> 0x0122 }
            if (r3 != r12) goto L_0x002b
            r13 = r10
            goto L_0x002c
        L_0x002b:
            r13 = r9
        L_0x002c:
            r14 = 10
            if (r2 == 0) goto L_0x0059
            boolean r3 = r1.hasChangedDevices(r0, r2)     // Catch:{ all -> 0x011e }
            if (r3 == 0) goto L_0x0059
            boolean r3 = r1.isDevicePressEvent(r2)     // Catch:{ all -> 0x011e }
            if (r3 == 0) goto L_0x0042
            androidx.compose.ui.input.pointer.PointerInputEventProcessor r3 = r1.pointerInputEventProcessor     // Catch:{ all -> 0x0122 }
            r3.processCancel()     // Catch:{ all -> 0x0122 }
            goto L_0x0059
        L_0x0042:
            int r3 = r2.getActionMasked()     // Catch:{ all -> 0x011e }
            if (r3 == r14) goto L_0x0059
            if (r13 == 0) goto L_0x0059
            long r4 = r2.getEventTime()     // Catch:{ all -> 0x011e }
            r7 = 8
            r8 = 0
            r3 = 10
            r6 = 0
            sendSimulatedEvent$default(r1, r2, r3, r4, r6, r7, r8)     // Catch:{ all -> 0x011e }
            r15 = r2
            goto L_0x005a
        L_0x0059:
            r15 = r2
        L_0x005a:
            int r1 = r0.getToolType(r9)     // Catch:{ all -> 0x011e }
            if (r1 != r12) goto L_0x0062
            r1 = r10
            goto L_0x0063
        L_0x0062:
            r1 = r9
        L_0x0063:
            r2 = 9
            if (r13 != 0) goto L_0x0086
            if (r1 == 0) goto L_0x0086
            if (r11 == r12) goto L_0x0086
            if (r11 == r2) goto L_0x0086
            boolean r1 = r16.isInBounds(r17)     // Catch:{ all -> 0x011e }
            if (r1 == 0) goto L_0x0086
            long r4 = r0.getEventTime()     // Catch:{ all -> 0x011e }
            r7 = 8
            r8 = 0
            r3 = 9
            r6 = 0
            r1 = r2
            r2 = r0
            r0 = r1
            r1 = r16
            sendSimulatedEvent$default(r1, r2, r3, r4, r6, r7, r8)     // Catch:{ all -> 0x0122 }
            goto L_0x0089
        L_0x0086:
            r1 = r16
            r0 = r2
        L_0x0089:
            if (r15 == 0) goto L_0x008e
            r15.recycle()     // Catch:{ all -> 0x0122 }
        L_0x008e:
            android.view.MotionEvent r2 = r1.previousMotionEvent     // Catch:{ all -> 0x0122 }
            if (r2 == 0) goto L_0x010e
            int r2 = r2.getAction()     // Catch:{ all -> 0x0122 }
            if (r2 != r14) goto L_0x010e
            android.view.MotionEvent r2 = r1.previousMotionEvent     // Catch:{ all -> 0x0122 }
            if (r2 == 0) goto L_0x00a1
            int r2 = r2.getPointerId(r9)     // Catch:{ all -> 0x0122 }
            goto L_0x00a2
        L_0x00a1:
            r2 = -1
        L_0x00a2:
            int r3 = r17.getAction()     // Catch:{ all -> 0x0122 }
            if (r3 != r0) goto L_0x00b6
            int r0 = r17.getHistorySize()     // Catch:{ all -> 0x0122 }
            if (r0 != 0) goto L_0x00b6
            if (r2 < 0) goto L_0x010e
            androidx.compose.ui.input.pointer.MotionEventAdapter r0 = r1.motionEventAdapter     // Catch:{ all -> 0x0122 }
            r0.endStream(r2)     // Catch:{ all -> 0x0122 }
            goto L_0x010e
        L_0x00b6:
            int r0 = r17.getAction()     // Catch:{ all -> 0x0122 }
            if (r0 != 0) goto L_0x010e
            int r0 = r17.getHistorySize()     // Catch:{ all -> 0x0122 }
            if (r0 != 0) goto L_0x010e
            android.view.MotionEvent r0 = r1.previousMotionEvent     // Catch:{ all -> 0x0122 }
            r3 = 2143289344(0x7fc00000, float:NaN)
            if (r0 == 0) goto L_0x00cd
            float r0 = r0.getX()     // Catch:{ all -> 0x0122 }
            goto L_0x00ce
        L_0x00cd:
            r0 = r3
        L_0x00ce:
            android.view.MotionEvent r4 = r1.previousMotionEvent     // Catch:{ all -> 0x0122 }
            if (r4 == 0) goto L_0x00d6
            float r3 = r4.getY()     // Catch:{ all -> 0x0122 }
        L_0x00d6:
            float r4 = r17.getX()     // Catch:{ all -> 0x0122 }
            float r5 = r17.getY()     // Catch:{ all -> 0x0122 }
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x00e8
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 != 0) goto L_0x00e8
            r0 = r9
            goto L_0x00e9
        L_0x00e8:
            r0 = r10
        L_0x00e9:
            android.view.MotionEvent r3 = r1.previousMotionEvent     // Catch:{ all -> 0x0122 }
            if (r3 == 0) goto L_0x00f2
            long r3 = r3.getEventTime()     // Catch:{ all -> 0x0122 }
            goto L_0x00f4
        L_0x00f2:
            r3 = -1
        L_0x00f4:
            long r5 = r17.getEventTime()     // Catch:{ all -> 0x0122 }
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x00fd
            goto L_0x00fe
        L_0x00fd:
            r10 = r9
        L_0x00fe:
            if (r0 != 0) goto L_0x0102
            if (r10 == 0) goto L_0x010e
        L_0x0102:
            if (r2 < 0) goto L_0x0109
            androidx.compose.ui.input.pointer.MotionEventAdapter r0 = r1.motionEventAdapter     // Catch:{ all -> 0x0122 }
            r0.endStream(r2)     // Catch:{ all -> 0x0122 }
        L_0x0109:
            androidx.compose.ui.input.pointer.PointerInputEventProcessor r0 = r1.pointerInputEventProcessor     // Catch:{ all -> 0x0122 }
            r0.clearPreviouslyHitModifierNodes()     // Catch:{ all -> 0x0122 }
        L_0x010e:
            android.view.MotionEvent r0 = android.view.MotionEvent.obtainNoHistory(r17)     // Catch:{ all -> 0x0122 }
            r1.previousMotionEvent = r0     // Catch:{ all -> 0x0122 }
            int r0 = r16.m6231sendMotionEvent8iAsVTc(r17)     // Catch:{ all -> 0x0122 }
            android.os.Trace.endSection()     // Catch:{ all -> 0x0127 }
            r1.forceUseMatrixCache = r9
            return r0
        L_0x011e:
            r0 = move-exception
            r1 = r16
            goto L_0x0123
        L_0x0122:
            r0 = move-exception
        L_0x0123:
            android.os.Trace.endSection()     // Catch:{ all -> 0x0127 }
            throw r0     // Catch:{ all -> 0x0127 }
        L_0x0127:
            r0 = move-exception
            r1.forceUseMatrixCache = r9
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView.m6227handleMotionEvent8iAsVTc(android.view.MotionEvent):int");
    }

    private final boolean hasChangedDevices(MotionEvent motionEvent, MotionEvent motionEvent2) {
        if (motionEvent2.getSource() == motionEvent.getSource() && motionEvent2.getToolType(0) == motionEvent.getToolType(0)) {
            return false;
        }
        return true;
    }

    private final boolean isDevicePressEvent(MotionEvent motionEvent) {
        int actionMasked;
        if (motionEvent.getButtonState() != 0 || (actionMasked = motionEvent.getActionMasked()) == 0 || actionMasked == 2 || actionMasked == 6) {
            return true;
        }
        return false;
    }

    /* renamed from: sendMotionEvent-8iAsVTc  reason: not valid java name */
    private final int m6231sendMotionEvent8iAsVTc(MotionEvent motionEvent) {
        PointerInputEventData pointerInputEventData;
        if (this.keyboardModifiersRequireUpdate) {
            this.keyboardModifiersRequireUpdate = false;
            this._windowInfo.m6349setKeyboardModifiers5xRPYO0(PointerKeyboardModifiers.m5653constructorimpl(motionEvent.getMetaState()));
        }
        PositionCalculator positionCalculator = this;
        PointerInputEvent convertToPointerInputEvent$ui_release = this.motionEventAdapter.convertToPointerInputEvent$ui_release(motionEvent, positionCalculator);
        if (convertToPointerInputEvent$ui_release != null) {
            List<PointerInputEventData> pointers = convertToPointerInputEvent$ui_release.getPointers();
            int size = pointers.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i = size - 1;
                    pointerInputEventData = pointers.get(size);
                    if (pointerInputEventData.getDown()) {
                        break;
                    } else if (i < 0) {
                        break;
                    } else {
                        size = i;
                    }
                }
            }
            pointerInputEventData = null;
            PointerInputEventData pointerInputEventData2 = pointerInputEventData;
            if (pointerInputEventData2 != null) {
                this.lastDownPointerPosition = pointerInputEventData2.m5604getPositionF1C5BW0();
            }
            int r0 = this.pointerInputEventProcessor.m5609processBIzXfog(convertToPointerInputEvent$ui_release, positionCalculator, isInBounds(motionEvent));
            int actionMasked = motionEvent.getActionMasked();
            if ((actionMasked == 0 || actionMasked == 5) && !ProcessResult.m5679getDispatchedToAPointerInputModifierimpl(r0)) {
                this.motionEventAdapter.endStream(motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
            return r0;
        }
        this.pointerInputEventProcessor.processCancel();
        return PointerInputEventProcessorKt.ProcessResult(false, false);
    }

    static /* synthetic */ void sendSimulatedEvent$default(AndroidComposeView androidComposeView, MotionEvent motionEvent, int i, long j, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = true;
        }
        androidComposeView.sendSimulatedEvent(motionEvent, i, j, z);
    }

    /* access modifiers changed from: private */
    public final void sendSimulatedEvent(MotionEvent motionEvent, int i, long j, boolean z) {
        long j2;
        MotionEvent motionEvent2 = motionEvent;
        int i2 = i;
        int actionMasked = motionEvent2.getActionMasked();
        int i3 = -1;
        int i4 = 0;
        if (actionMasked != 1) {
            if (actionMasked == 6) {
                i3 = motionEvent2.getActionIndex();
            }
        } else if (!(i2 == 9 || i2 == 10)) {
            i3 = 0;
        }
        int pointerCount = motionEvent2.getPointerCount() - (i3 >= 0 ? 1 : 0);
        if (pointerCount != 0) {
            MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
            for (int i5 = 0; i5 < pointerCount; i5++) {
                pointerPropertiesArr[i5] = new MotionEvent.PointerProperties();
            }
            MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
            for (int i6 = 0; i6 < pointerCount; i6++) {
                pointerCoordsArr[i6] = new MotionEvent.PointerCoords();
            }
            int i7 = 0;
            while (i7 < pointerCount) {
                int i8 = ((i3 < 0 || i7 < i3) ? 0 : 1) + i7;
                motionEvent2.getPointerProperties(i8, pointerPropertiesArr[i7]);
                MotionEvent.PointerCoords pointerCoords = pointerCoordsArr[i7];
                motionEvent2.getPointerCoords(i8, pointerCoords);
                long r12 = m6237localToScreenMKHz9U(OffsetKt.Offset(pointerCoords.x, pointerCoords.y));
                pointerCoords.x = Offset.m3987getXimpl(r12);
                pointerCoords.y = Offset.m3988getYimpl(r12);
                i7++;
            }
            if (!z) {
                i4 = motionEvent2.getButtonState();
            }
            int i9 = i4;
            if (motionEvent2.getDownTime() == motionEvent2.getEventTime()) {
                j2 = j;
            } else {
                j2 = motionEvent2.getDownTime();
            }
            MotionEvent obtain = MotionEvent.obtain(j2, j, i2, pointerCount, pointerPropertiesArr, pointerCoordsArr, motionEvent2.getMetaState(), i9, motionEvent2.getXPrecision(), motionEvent2.getYPrecision(), motionEvent2.getDeviceId(), motionEvent2.getEdgeFlags(), motionEvent2.getSource(), motionEvent2.getFlags());
            PositionCalculator positionCalculator = this;
            PointerInputEvent convertToPointerInputEvent$ui_release = this.motionEventAdapter.convertToPointerInputEvent$ui_release(obtain, positionCalculator);
            Intrinsics.checkNotNull(convertToPointerInputEvent$ui_release);
            this.pointerInputEventProcessor.m5609processBIzXfog(convertToPointerInputEvent$ui_release, positionCalculator, true);
            obtain.recycle();
        }
    }

    public boolean canScrollHorizontally(int i) {
        return this.composeAccessibilityDelegate.m6250canScroll0AR0LA0$ui_release(false, i, this.lastDownPointerPosition);
    }

    public boolean canScrollVertically(int i) {
        return this.composeAccessibilityDelegate.m6250canScroll0AR0LA0$ui_release(true, i, this.lastDownPointerPosition);
    }

    private final boolean isInBounds(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        return 0.0f <= x && x <= ((float) getWidth()) && 0.0f <= y && y <= ((float) getHeight());
    }

    /* renamed from: localToScreen-MK-Hz9U  reason: not valid java name */
    public long m6237localToScreenMKHz9U(long j) {
        recalculateWindowPosition();
        long r4 = Matrix.m4480mapMKHz9U(this.viewToWindowMatrix, j);
        return OffsetKt.Offset(Offset.m3987getXimpl(r4) + Offset.m3987getXimpl(this.windowPosition), Offset.m3988getYimpl(r4) + Offset.m3988getYimpl(this.windowPosition));
    }

    /* renamed from: localToScreen-58bKbWc  reason: not valid java name */
    public void m6236localToScreen58bKbWc(float[] fArr) {
        recalculateWindowPosition();
        Matrix.m4491timesAssign58bKbWc(fArr, this.viewToWindowMatrix);
        AndroidComposeView_androidKt.m6255preTranslatecG2Xzmc(fArr, Offset.m3987getXimpl(this.windowPosition), Offset.m3988getYimpl(this.windowPosition), this.tmpMatrix);
    }

    /* renamed from: screenToLocal-MK-Hz9U  reason: not valid java name */
    public long m6239screenToLocalMKHz9U(long j) {
        recalculateWindowPosition();
        return Matrix.m4480mapMKHz9U(this.windowToViewMatrix, OffsetKt.Offset(Offset.m3987getXimpl(j) - Offset.m3987getXimpl(this.windowPosition), Offset.m3988getYimpl(j) - Offset.m3988getYimpl(this.windowPosition)));
    }

    private final void recalculateWindowPosition() {
        if (!this.forceUseMatrixCache) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (currentAnimationTimeMillis != this.lastMatrixRecalculationAnimationTime) {
                this.lastMatrixRecalculationAnimationTime = currentAnimationTimeMillis;
                recalculateWindowViewTransforms();
                ViewParent parent = getParent();
                View view = this;
                while (parent instanceof ViewGroup) {
                    view = (View) parent;
                    parent = ((ViewGroup) view).getParent();
                }
                view.getLocationOnScreen(this.tmpPositionArray);
                int[] iArr = this.tmpPositionArray;
                view.getLocationInWindow(iArr);
                int[] iArr2 = this.tmpPositionArray;
                this.windowPosition = OffsetKt.Offset(((float) iArr[0]) - ((float) iArr2[0]), ((float) iArr[1]) - ((float) iArr2[1]));
            }
        }
    }

    private final void recalculateWindowPosition(MotionEvent motionEvent) {
        this.lastMatrixRecalculationAnimationTime = AnimationUtils.currentAnimationTimeMillis();
        recalculateWindowViewTransforms();
        long r0 = Matrix.m4480mapMKHz9U(this.viewToWindowMatrix, OffsetKt.Offset(motionEvent.getX(), motionEvent.getY()));
        this.windowPosition = OffsetKt.Offset(motionEvent.getRawX() - Offset.m3987getXimpl(r0), motionEvent.getRawY() - Offset.m3988getYimpl(r0));
    }

    private final void recalculateWindowViewTransforms() {
        this.matrixToWindow.m6256calculateMatrixToWindowEL8BTi8(this, this.viewToWindowMatrix);
        InvertMatrixKt.m6291invertToJiSxe2E(this.viewToWindowMatrix, this.windowToViewMatrix);
    }

    public boolean onCheckIsTextEditor() {
        AndroidPlatformTextInputSession androidPlatformTextInputSession = (AndroidPlatformTextInputSession) SessionMutex.m3828getCurrentSessionimpl(this.textInputSessionMutex);
        if (androidPlatformTextInputSession == null) {
            return this.legacyTextInputServiceAndroid.isEditorFocused();
        }
        return androidPlatformTextInputSession.isReadyForConnection();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        AndroidPlatformTextInputSession androidPlatformTextInputSession = (AndroidPlatformTextInputSession) SessionMutex.m3828getCurrentSessionimpl(this.textInputSessionMutex);
        if (androidPlatformTextInputSession == null) {
            return this.legacyTextInputServiceAndroid.createInputConnection(editorInfo);
        }
        return androidPlatformTextInputSession.createInputConnection(editorInfo);
    }

    /* renamed from: calculateLocalPosition-MK-Hz9U  reason: not valid java name */
    public long m6233calculateLocalPositionMKHz9U(long j) {
        recalculateWindowPosition();
        return Matrix.m4480mapMKHz9U(this.windowToViewMatrix, j);
    }

    /* renamed from: calculatePositionInWindow-MK-Hz9U  reason: not valid java name */
    public long m6234calculatePositionInWindowMKHz9U(long j) {
        recalculateWindowPosition();
        return Matrix.m4480mapMKHz9U(this.viewToWindowMatrix, j);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setDensity(AndroidDensity_androidKt.Density(getContext()));
        if (getFontWeightAdjustmentCompat(configuration) != this.currentFontWeightAdjustment) {
            this.currentFontWeightAdjustment = getFontWeightAdjustmentCompat(configuration);
            setFontFamilyResolver(FontFamilyResolver_androidKt.createFontFamilyResolver(getContext()));
        }
        this.configurationChangeObserver.invoke(configuration);
    }

    public void onRtlPropertiesChanged(int i) {
        if (this.superclassInitComplete) {
            LayoutDirection layoutDirection = FocusInteropUtils_androidKt.toLayoutDirection(i);
            if (layoutDirection == null) {
                layoutDirection = LayoutDirection.Ltr;
            }
            setLayoutDirection(layoutDirection);
        }
    }

    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            this.sendHoverExitEvent.run();
        }
        if (isBadMotionEvent(motionEvent) || !isAttachedToWindow()) {
            return false;
        }
        this.composeAccessibilityDelegate.dispatchHoverEvent$ui_release(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10 && isInBounds(motionEvent)) {
                if (motionEvent.getToolType(0) == 3 && motionEvent.getButtonState() != 0) {
                    return false;
                }
                MotionEvent motionEvent2 = this.previousMotionEvent;
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                this.previousMotionEvent = MotionEvent.obtainNoHistory(motionEvent);
                this.hoverExitReceived = true;
                postDelayed(this.sendHoverExitEvent, 8);
                return false;
            }
        } else if (!isPositionChanged(motionEvent)) {
            return false;
        }
        return ProcessResult.m5679getDispatchedToAPointerInputModifierimpl(m6227handleMotionEvent8iAsVTc(motionEvent));
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0082 A[LOOP:0: B:20:0x004c->B:36:0x0082, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0085 A[EDGE_INSN: B:38:0x0085->B:37:0x0085 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean isBadMotionEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            float r0 = r7.getX()
            boolean r1 = java.lang.Float.isInfinite(r0)
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x0044
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x0044
            float r0 = r7.getY()
            boolean r1 = java.lang.Float.isInfinite(r0)
            if (r1 != 0) goto L_0x0044
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x0044
            float r0 = r7.getRawX()
            boolean r1 = java.lang.Float.isInfinite(r0)
            if (r1 != 0) goto L_0x0044
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x0044
            float r0 = r7.getRawY()
            boolean r1 = java.lang.Float.isInfinite(r0)
            if (r1 != 0) goto L_0x0044
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x0044
            r0 = r2
            goto L_0x0045
        L_0x0044:
            r0 = r3
        L_0x0045:
            if (r0 != 0) goto L_0x0085
            int r1 = r7.getPointerCount()
            r4 = r3
        L_0x004c:
            if (r4 >= r1) goto L_0x0085
            float r0 = r7.getX(r4)
            boolean r5 = java.lang.Float.isInfinite(r0)
            if (r5 != 0) goto L_0x007f
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x007f
            float r0 = r7.getY(r4)
            boolean r5 = java.lang.Float.isInfinite(r0)
            if (r5 != 0) goto L_0x007f
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x007f
            int r0 = android.os.Build.VERSION.SDK_INT
            r5 = 29
            if (r0 < r5) goto L_0x007d
            androidx.compose.ui.platform.MotionEventVerifierApi29 r0 = androidx.compose.ui.platform.MotionEventVerifierApi29.INSTANCE
            boolean r0 = r0.isValidMotionEvent(r7, r4)
            if (r0 != 0) goto L_0x007d
            goto L_0x007f
        L_0x007d:
            r0 = r2
            goto L_0x0080
        L_0x007f:
            r0 = r3
        L_0x0080:
            if (r0 != 0) goto L_0x0085
            int r4 = r4 + 1
            goto L_0x004c
        L_0x0085:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView.isBadMotionEvent(android.view.MotionEvent):boolean");
    }

    private final boolean isPositionChanged(MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        if (motionEvent.getPointerCount() == 1 && (motionEvent2 = this.previousMotionEvent) != null && motionEvent2.getPointerCount() == motionEvent.getPointerCount() && motionEvent.getRawX() == motionEvent2.getRawX() && motionEvent.getRawY() == motionEvent2.getRawY()) {
            return false;
        }
        return true;
    }

    private final View findViewByAccessibilityIdRootedAtCurrentView(int i, View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return null;
        }
        Method declaredMethod = Class.forName(AndroidComposeViewAccessibilityDelegateCompat.ClassName).getDeclaredMethod("getAccessibilityViewId", new Class[0]);
        declaredMethod.setAccessible(true);
        if (Intrinsics.areEqual(declaredMethod.invoke(view, new Object[0]), (Object) Integer.valueOf(i))) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View findViewByAccessibilityIdRootedAtCurrentView = findViewByAccessibilityIdRootedAtCurrentView(i, viewGroup.getChildAt(i2));
            if (findViewByAccessibilityIdRootedAtCurrentView != null) {
                return findViewByAccessibilityIdRootedAtCurrentView;
            }
        }
        return null;
    }

    public PointerIconService getPointerIconService() {
        return this.pointerIconService;
    }

    public final View findViewByAccessibilityIdTraversal(int i) {
        try {
            if (Build.VERSION.SDK_INT < 29) {
                return findViewByAccessibilityIdRootedAtCurrentView(i, this);
            }
            Method declaredMethod = Class.forName(AndroidComposeViewAccessibilityDelegateCompat.ClassName).getDeclaredMethod("findViewByAccessibilityIdTraversal", new Class[]{Integer.TYPE});
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(this, new Object[]{Integer.valueOf(i)});
            if (invoke instanceof View) {
                return (View) invoke;
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r0 = (r0 = r0.getLifecycleOwner()).getLifecycle();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isLifecycleInResumedState() {
        /*
            r2 = this;
            androidx.compose.ui.platform.AndroidComposeView$ViewTreeOwners r0 = r2.getViewTreeOwners()
            if (r0 == 0) goto L_0x0017
            androidx.lifecycle.LifecycleOwner r0 = r0.getLifecycleOwner()
            if (r0 == 0) goto L_0x0017
            androidx.lifecycle.Lifecycle r0 = r0.getLifecycle()
            if (r0 == 0) goto L_0x0017
            androidx.lifecycle.Lifecycle$State r0 = r0.getCurrentState()
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.RESUMED
            if (r0 != r1) goto L_0x001e
            r0 = 1
            return r0
        L_0x001e:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView.isLifecycleInResumedState():boolean");
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$Companion;", "", "()V", "getBooleanMethod", "Ljava/lang/reflect/Method;", "systemPropertiesClass", "Ljava/lang/Class;", "getIsShowingLayoutBounds", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeView.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final boolean getIsShowingLayoutBounds() {
            try {
                Boolean bool = null;
                if (AndroidComposeView.systemPropertiesClass == null) {
                    AndroidComposeView.systemPropertiesClass = Class.forName("android.os.SystemProperties");
                    Class access$getSystemPropertiesClass$cp = AndroidComposeView.systemPropertiesClass;
                    AndroidComposeView.getBooleanMethod = access$getSystemPropertiesClass$cp != null ? access$getSystemPropertiesClass$cp.getDeclaredMethod("getBoolean", new Class[]{String.class, Boolean.TYPE}) : null;
                }
                Method access$getGetBooleanMethod$cp = AndroidComposeView.getBooleanMethod;
                Object invoke = access$getGetBooleanMethod$cp != null ? access$getGetBooleanMethod$cp.invoke((Object) null, new Object[]{"debug.layout", false}) : null;
                if (invoke instanceof Boolean) {
                    bool = (Boolean) invoke;
                }
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/savedstate/SavedStateRegistryOwner;)V", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "getSavedStateRegistryOwner", "()Landroidx/savedstate/SavedStateRegistryOwner;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeView.android.kt */
    public static final class ViewTreeOwners {
        public static final int $stable = 8;
        private final LifecycleOwner lifecycleOwner;
        private final SavedStateRegistryOwner savedStateRegistryOwner;

        public ViewTreeOwners(LifecycleOwner lifecycleOwner2, SavedStateRegistryOwner savedStateRegistryOwner2) {
            this.lifecycleOwner = lifecycleOwner2;
            this.savedStateRegistryOwner = savedStateRegistryOwner2;
        }

        public final LifecycleOwner getLifecycleOwner() {
            return this.lifecycleOwner;
        }

        public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
            return this.savedStateRegistryOwner;
        }
    }
}
