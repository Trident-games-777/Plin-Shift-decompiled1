package androidx.compose.ui.platform;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.text.SpannableString;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.collection.ArraySet;
import androidx.collection.IntList;
import androidx.collection.IntListKt;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.IntSet;
import androidx.collection.IntSetKt;
import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.collection.SparseArrayCompat;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.R;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AccessibilityIterators;
import androidx.compose.ui.platform.accessibility.CollectionInfo_androidKt;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesAndroid;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.platform.AndroidAccessibilitySpannableString_androidKt;
import androidx.compose.ui.text.platform.URLSpanCache;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

@Metadata(d1 = {"\u0000è\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 ú\u00012\u00020\u0001:\u0010ø\u0001ù\u0001ú\u0001û\u0001ü\u0001ý\u0001þ\u0001ÿ\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010p\u001a\u00020!2\u0006\u0010q\u001a\u00020\u00122\u0006\u0010r\u001a\u00020*2\u0006\u0010s\u001a\u00020\u00062\b\u0010t\u001a\u0004\u0018\u00010uH\u0002J\u0010\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020%H\u0002J\u0010\u0010y\u001a\u00020!H@¢\u0006\u0004\bz\u0010{J;\u0010|\u001a\u00020\u00142\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010}\u001a\u00020\u00142\u0006\u0010~\u001a\u00020\u00122\u0007\u0010\u001a\u00030\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J-\u0010|\u001a\u00020\u00142\u0006\u0010}\u001a\u00020\u00142\u0006\u0010~\u001a\u00020\u00122\u0007\u0010\u001a\u00030\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\t\u0010\u0001\u001a\u00020!H\u0002J\u0011\u0010\u0001\u001a\u00020\u00142\u0006\u0010q\u001a\u00020\u0012H\u0002J\u001a\u0010\u0001\u001a\u00020N2\u0006\u0010q\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u0012H\u0003J\u0013\u0010\u0001\u001a\u0004\u0018\u00010*2\u0006\u0010q\u001a\u00020\u0012H\u0002J\u0014\u0010\u0001\u001a\u0004\u0018\u00010\u00062\u0007\u0010x\u001a\u00030\u0001H\u0002JC\u0010\u0001\u001a\u00020N2\u0006\u0010q\u001a\u00020\u00122\t\u0010\u0001\u001a\u0004\u0018\u00010\u00122\t\u0010\u0001\u001a\u0004\u0018\u00010\u00122\t\u0010\u0001\u001a\u0004\u0018\u00010\u00122\t\u0010\u0001\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0003\u0010\u0001J\u0019\u0010\u0001\u001a\u00020\u00142\b\u0010\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\b\u0001JF\u0010\u0001\u001a\u00020!2\b\u0010\u0001\u001a\u00030\u00012\u001b\u0010\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u00010\u0001j\n\u0012\u0005\u0012\u00030\u0001`\u00012\u0014\u0010\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u00010,0WH\u0002J\u0014\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0012\u0010 \u0001\u001a\u00020\u00122\u0007\u0010x\u001a\u00030\u0001H\u0002J\u0012\u0010¡\u0001\u001a\u00020\u00122\u0007\u0010x\u001a\u00030\u0001H\u0002J\u0012\u0010¢\u0001\u001a\u00020\u00142\u0007\u0010x\u001a\u00030\u0001H\u0002J\u0014\u0010£\u0001\u001a\u0004\u0018\u00010\u00062\u0007\u0010x\u001a\u00030\u0001H\u0002J\u0015\u0010¤\u0001\u001a\u0005\u0018\u00010¥\u00012\u0007\u0010x\u001a\u00030\u0001H\u0002J\u0016\u0010¦\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010x\u001a\u0005\u0018\u00010\u0001H\u0002J \u0010§\u0001\u001a\u0005\u0018\u00010¨\u00012\t\u0010x\u001a\u0005\u0018\u00010\u00012\u0007\u0010©\u0001\u001a\u00020\u0012H\u0002J#\u0010ª\u0001\u001a\u00020\u00122\b\u0010«\u0001\u001a\u00030¬\u00012\b\u0010­\u0001\u001a\u00030¬\u0001H\u0001¢\u0006\u0003\b®\u0001J\u0011\u0010¯\u0001\u001a\u00020\u00142\u0006\u0010q\u001a\u00020\u0012H\u0002J\u0012\u0010°\u0001\u001a\u00020\u00142\u0007\u0010x\u001a\u00030\u0001H\u0002J\u0012\u0010±\u0001\u001a\u00020\u00142\u0007\u0010x\u001a\u00030\u0001H\u0002J\u0012\u0010²\u0001\u001a\u00020!2\u0007\u0010³\u0001\u001a\u00020iH\u0002J\u0018\u0010´\u0001\u001a\u00020!2\u0007\u0010³\u0001\u001a\u00020iH\u0000¢\u0006\u0003\bµ\u0001J\u000f\u0010¶\u0001\u001a\u00020!H\u0000¢\u0006\u0003\b·\u0001J$\u0010¸\u0001\u001a\u00020\u00142\u0006\u0010q\u001a\u00020\u00122\u0007\u0010¹\u0001\u001a\u00020\u00122\b\u0010t\u001a\u0004\u0018\u00010uH\u0002J#\u0010º\u0001\u001a\u00020!2\u0006\u0010q\u001a\u00020\u00122\u0006\u0010r\u001a\u00020*2\b\u0010»\u0001\u001a\u00030\u0001H\u0002J!\u0010¼\u0001\u001a\u00020\u00142\u0007\u0010½\u0001\u001a\u00020\u00122\r\u0010¾\u0001\u001a\b\u0012\u0004\u0012\u00020b0/H\u0002J\u0011\u0010¿\u0001\u001a\u00020\u00142\u0006\u0010q\u001a\u00020\u0012H\u0002J\u0012\u0010À\u0001\u001a\u00020!2\u0007\u0010Á\u0001\u001a\u00020bH\u0002J'\u0010Â\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u00010Ã\u0001j\n\u0012\u0005\u0012\u00030\u0001`Ä\u00012\u0007\u0010Å\u0001\u001a\u00020\u0014H\bJ\u0012\u0010Æ\u0001\u001a\u00020\u00122\u0007\u0010½\u0001\u001a\u00020\u0012H\u0002J\u001c\u0010Ç\u0001\u001a\u00020!2\b\u0010È\u0001\u001a\u00030\u00012\u0007\u0010É\u0001\u001a\u00020]H\u0002J\u0012\u0010Ê\u0001\u001a\u00020\u00142\u0007\u0010\u0001\u001a\u00020NH\u0002J@\u0010Ë\u0001\u001a\u00020\u00142\u0006\u0010q\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u00122\u000b\b\u0002\u0010Ì\u0001\u001a\u0004\u0018\u00010\u00122\u0011\b\u0002\u0010Í\u0001\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010/H\u0002¢\u0006\u0003\u0010Î\u0001J&\u0010Ï\u0001\u001a\u00020!2\u0007\u0010Ð\u0001\u001a\u00020\u00122\u0007\u0010Ì\u0001\u001a\u00020\u00122\t\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010Ò\u0001\u001a\u00020!2\u0007\u0010Ð\u0001\u001a\u00020\u0012H\u0002J\u0018\u0010Ó\u0001\u001a\u00020!2\r\u0010Ô\u0001\u001a\b\u0012\u0004\u0012\u00020%0$H\u0002J\u001b\u0010Õ\u0001\u001a\u00020!2\u0007\u0010³\u0001\u001a\u00020i2\u0007\u0010Ö\u0001\u001a\u00020UH\u0002J\u0012\u0010×\u0001\u001a\u00020!2\u0007\u0010³\u0001\u001a\u00020iH\u0002J-\u0010Ø\u0001\u001a\u00020\u00142\u0007\u0010x\u001a\u00030\u00012\u0007\u0010Ù\u0001\u001a\u00020\u00122\u0007\u0010Ú\u0001\u001a\u00020\u00122\u0007\u0010Û\u0001\u001a\u00020\u0014H\u0002J\u001a\u0010Ü\u0001\u001a\u00020!2\u0007\u0010x\u001a\u00030\u00012\u0006\u0010r\u001a\u00020*H\u0002J\u001a\u0010Ý\u0001\u001a\u00020!2\u0007\u0010x\u001a\u00030\u00012\u0006\u0010r\u001a\u00020*H\u0002J\u001a\u0010Þ\u0001\u001a\u00020!2\u0007\u0010x\u001a\u00030\u00012\u0006\u0010r\u001a\u00020*H\u0002J\u001a\u0010ß\u0001\u001a\u00020!2\u0007\u0010x\u001a\u00030\u00012\u0006\u0010r\u001a\u00020*H\u0002J\t\u0010à\u0001\u001a\u00020!H\u0002JN\u0010á\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010,2\u0007\u0010Å\u0001\u001a\u00020\u00142\u001b\u0010â\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u00010\u0001j\n\u0012\u0005\u0012\u00030\u0001`\u00012\u0016\b\u0002\u0010ã\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u00010,0WH\u0002J)\u0010ä\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010,2\u0007\u0010Å\u0001\u001a\u00020\u00142\u000e\u0010å\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010,H\u0002J\"\u0010æ\u0001\u001a\u0005\u0018\u00010ç\u00012\n\u0010è\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010é\u0001\u001a\u00030ê\u0001H\u0002J-\u0010ë\u0001\u001a\u00020\u00142\u0007\u0010x\u001a\u00030\u00012\u0007\u0010©\u0001\u001a\u00020\u00122\u0007\u0010ì\u0001\u001a\u00020\u00142\u0007\u0010í\u0001\u001a\u00020\u0014H\u0002J4\u0010î\u0001\u001a\u0005\u0018\u0001Hï\u0001\"\t\b\u0000\u0010ï\u0001*\u00020\u001e2\n\u0010\u0001\u001a\u0005\u0018\u0001Hï\u00012\t\b\u0001\u0010ð\u0001\u001a\u00020\u0012H\u0002¢\u0006\u0003\u0010ñ\u0001J\u0011\u0010ò\u0001\u001a\u00020!2\u0006\u0010q\u001a\u00020\u0012H\u0002J\t\u0010ó\u0001\u001a\u00020!H\u0002J\u0011\u0010ô\u0001\u001a\u0005\u0018\u00010¥\u0001*\u00030õ\u0001H\u0002J\u0011\u0010ö\u0001\u001a\u0005\u0018\u00010÷\u0001*\u00030¥\u0001H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001dX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$8BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R2\u0010+\u001a&\u0012\f\u0012\n .*\u0004\u0018\u00010-0- .*\u0012\u0012\f\u0012\n .*\u0004\u0018\u00010-0-\u0018\u00010/0,X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0004¢\u0006\u0002\n\u0000R$\u00105\u001a\u00020\u00128\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020=X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010B\u001a\u00020=X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010?\"\u0004\bD\u0010AR\u0014\u0010E\u001a\u00020\u00148@X\u0004¢\u0006\u0006\u001a\u0004\bF\u0010\u0017R\u0014\u0010G\u001a\u00020\u00148BX\u0004¢\u0006\u0006\u001a\u0004\bG\u0010\u0017R\u001a\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0I0\u001dX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010J\u001a\u00060KR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R0\u0010L\u001a\u000e\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020\u00140M8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bO\u00107\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u000e\u0010T\u001a\u00020UX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010V\u001a\b\u0012\u0004\u0012\u00020X0WX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Y\u001a\u0004\u0018\u00010ZX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010[\u001a\b\u0012\u0004\u0012\u00020X0WX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\\\u001a\b\u0012\u0004\u0012\u00020]0WX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020]X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010_\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0004\n\u0002\u0010`R\u001a\u0010a\u001a\u000e\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020!0MX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010c\u001a\b\u0012\u0004\u0012\u00020b0,X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010g\u001a\b\u0012\u0004\u0012\u00020i0hX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020kX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020mX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bn\u0010o\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0002"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "Landroidx/core/view/AccessibilityDelegateCompat;", "view", "Landroidx/compose/ui/platform/AndroidComposeView;", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "ExtraDataTestTraversalAfterVal", "", "getExtraDataTestTraversalAfterVal$ui_release", "()Ljava/lang/String;", "ExtraDataTestTraversalBeforeVal", "getExtraDataTestTraversalBeforeVal$ui_release", "SendRecurringAccessibilityEventsIntervalMillis", "", "getSendRecurringAccessibilityEventsIntervalMillis$ui_release", "()J", "setSendRecurringAccessibilityEventsIntervalMillis$ui_release", "(J)V", "accessibilityCursorPosition", "", "value", "", "accessibilityForceEnabledForTesting", "getAccessibilityForceEnabledForTesting$ui_release", "()Z", "setAccessibilityForceEnabledForTesting$ui_release", "(Z)V", "accessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "actionIdToLabel", "Landroidx/collection/SparseArrayCompat;", "", "boundsUpdateChannel", "Lkotlinx/coroutines/channels/Channel;", "", "checkingForSemanticsChanges", "currentSemanticsNodes", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "getCurrentSemanticsNodes", "()Landroidx/collection/IntObjectMap;", "currentSemanticsNodesInvalidated", "currentlyFocusedANI", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "enabledServices", "", "Landroid/accessibilityservice/AccessibilityServiceInfo;", "kotlin.jvm.PlatformType", "", "enabledStateListener", "Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;", "focusedVirtualViewId", "handler", "Landroid/os/Handler;", "hoveredVirtualViewId", "getHoveredVirtualViewId$ui_release$annotations", "()V", "getHoveredVirtualViewId$ui_release", "()I", "setHoveredVirtualViewId$ui_release", "(I)V", "idToAfterMap", "Landroidx/collection/MutableIntIntMap;", "getIdToAfterMap$ui_release", "()Landroidx/collection/MutableIntIntMap;", "setIdToAfterMap$ui_release", "(Landroidx/collection/MutableIntIntMap;)V", "idToBeforeMap", "getIdToBeforeMap$ui_release", "setIdToBeforeMap$ui_release", "isEnabled", "isEnabled$ui_release", "isTouchExplorationEnabled", "labelToActionId", "Landroidx/collection/MutableObjectIntMap;", "nodeProvider", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$ComposeAccessibilityNodeProvider;", "onSendAccessibilityEvent", "Lkotlin/Function1;", "Landroid/view/accessibility/AccessibilityEvent;", "getOnSendAccessibilityEvent$ui_release$annotations", "getOnSendAccessibilityEvent$ui_release", "()Lkotlin/jvm/functions/Function1;", "setOnSendAccessibilityEvent$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "paneDisplayed", "Landroidx/collection/MutableIntSet;", "pendingHorizontalScrollEvents", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "pendingTextTraversedEvent", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "pendingVerticalScrollEvents", "previousSemanticsNodes", "Landroidx/compose/ui/platform/SemanticsNodeCopy;", "previousSemanticsRoot", "previousTraversedNode", "Ljava/lang/Integer;", "scheduleScrollEventIfNeededLambda", "Landroidx/compose/ui/platform/ScrollObservationScope;", "scrollObservationScopes", "semanticsChangeChecker", "Ljava/lang/Runnable;", "sendingFocusAffectingEvent", "subtreeChangedLayoutNodes", "Landroidx/collection/ArraySet;", "Landroidx/compose/ui/node/LayoutNode;", "touchExplorationStateListener", "Landroid/view/accessibility/AccessibilityManager$TouchExplorationStateChangeListener;", "urlSpanCache", "Landroidx/compose/ui/text/platform/URLSpanCache;", "getView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "addExtraDataToAccessibilityNodeInfoHelper", "virtualViewId", "info", "extraDataKey", "arguments", "Landroid/os/Bundle;", "boundsInScreen", "Landroid/graphics/Rect;", "node", "boundsUpdatesEventLoop", "boundsUpdatesEventLoop$ui_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "canScroll", "vertical", "direction", "position", "Landroidx/compose/ui/geometry/Offset;", "canScroll-moWRBKg", "(Landroidx/collection/IntObjectMap;ZIJ)Z", "canScroll-0AR0LA0$ui_release", "(ZIJ)Z", "checkForSemanticsChanges", "clearAccessibilityFocus", "createEvent", "eventType", "createNodeInfo", "createStateDescriptionForTextField", "Landroidx/compose/ui/semantics/SemanticsNode;", "createTextSelectionChangedEvent", "fromIndex", "toIndex", "itemCount", "text", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;)Landroid/view/accessibility/AccessibilityEvent;", "dispatchHoverEvent", "event", "Landroid/view/MotionEvent;", "dispatchHoverEvent$ui_release", "geometryDepthFirstSearch", "currNode", "geometryList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "containerMapToChildren", "getAccessibilityNodeProvider", "Landroidx/core/view/accessibility/AccessibilityNodeProviderCompat;", "host", "Landroid/view/View;", "getAccessibilitySelectionEnd", "getAccessibilitySelectionStart", "getInfoIsCheckable", "getInfoStateDescriptionOrNull", "getInfoText", "Landroidx/compose/ui/text/AnnotatedString;", "getIterableTextForAccessibility", "getIteratorForGranularity", "Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", "granularity", "hitTestSemanticsAt", "x", "", "y", "hitTestSemanticsAt$ui_release", "isAccessibilityFocused", "isAccessibilitySelectionExtendable", "isScreenReaderFocusable", "notifySubtreeAccessibilityStateChangedIfNeeded", "layoutNode", "onLayoutChange", "onLayoutChange$ui_release", "onSemanticsChange", "onSemanticsChange$ui_release", "performActionHelper", "action", "populateAccessibilityNodeInfoProperties", "semanticsNode", "registerScrollingId", "id", "oldScrollObservationScopes", "requestAccessibilityFocus", "scheduleScrollEventIfNeeded", "scrollObservationScope", "semanticComparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "layoutIsRtl", "semanticsNodeIdToAccessibilityVirtualNodeId", "sendAccessibilitySemanticsStructureChangeEvents", "newNode", "oldNode", "sendEvent", "sendEventForVirtualView", "contentChangeType", "contentDescription", "(IILjava/lang/Integer;Ljava/util/List;)Z", "sendPaneChangeEvents", "semanticsNodeId", "title", "sendPendingTextTraversedAtGranularityEvent", "sendSemanticsPropertyChangeEvents", "newSemanticsNodes", "sendSubtreeChangeAccessibilityEvents", "subtreeChangedSemanticsNodesIds", "sendTypeViewScrolledAccessibilityEvent", "setAccessibilitySelection", "start", "end", "traversalMode", "setContentInvalid", "setIsCheckable", "setStateDescription", "setText", "setTraversalValues", "sortByGeometryGroupings", "parentListToSort", "containerChildrenMapping", "subtreeSortedByGeometryGrouping", "listToSort", "toScreenCoords", "Landroid/graphics/RectF;", "textNode", "bounds", "Landroidx/compose/ui/geometry/Rect;", "traverseAtGranularity", "forward", "extendSelection", "trimToSize", "T", "size", "(Ljava/lang/CharSequence;I)Ljava/lang/CharSequence;", "updateHoveredVirtualView", "updateSemanticsNodesCopyAndPanes", "getTextForTextField", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "toSpannableString", "Landroid/text/SpannableString;", "Api24Impl", "Api29Impl", "Companion", "ComposeAccessibilityNodeProvider", "LtrBoundsComparator", "PendingTextTraversedEvent", "RtlBoundsComparator", "TopBottomBoundsComparator", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
public final class AndroidComposeViewAccessibilityDelegateCompat extends AccessibilityDelegateCompat {
    public static final int $stable = 8;
    private static final IntList AccessibilityActionsResourceIds = IntListKt.intListOf(R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31);
    public static final int AccessibilityCursorPositionUndefined = -1;
    public static final int AccessibilitySliderStepsCount = 20;
    public static final String ClassName = "android.view.View";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ExtraDataIdKey = "androidx.compose.ui.semantics.id";
    public static final String ExtraDataTestTagKey = "androidx.compose.ui.semantics.testTag";
    public static final int InvalidId = Integer.MIN_VALUE;
    public static final String LogTag = "AccessibilityDelegate";
    public static final int ParcelSafeTextLength = 100000;
    public static final String TextClassName = "android.widget.TextView";
    public static final String TextFieldClassName = "android.widget.EditText";
    public static final long TextTraversedEventTimeoutMillis = 1000;
    private final String ExtraDataTestTraversalAfterVal;
    private final String ExtraDataTestTraversalBeforeVal;
    private long SendRecurringAccessibilityEventsIntervalMillis;
    private int accessibilityCursorPosition;
    private boolean accessibilityForceEnabledForTesting;
    /* access modifiers changed from: private */
    public final AccessibilityManager accessibilityManager;
    private SparseArrayCompat<SparseArrayCompat<CharSequence>> actionIdToLabel;
    private final Channel<Unit> boundsUpdateChannel;
    private boolean checkingForSemanticsChanges;
    private IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes;
    private boolean currentSemanticsNodesInvalidated;
    /* access modifiers changed from: private */
    public AccessibilityNodeInfoCompat currentlyFocusedANI;
    private List<AccessibilityServiceInfo> enabledServices;
    /* access modifiers changed from: private */
    public final AccessibilityManager.AccessibilityStateChangeListener enabledStateListener;
    /* access modifiers changed from: private */
    public int focusedVirtualViewId;
    /* access modifiers changed from: private */
    public final Handler handler;
    private int hoveredVirtualViewId = Integer.MIN_VALUE;
    private MutableIntIntMap idToAfterMap;
    private MutableIntIntMap idToBeforeMap;
    private SparseArrayCompat<MutableObjectIntMap<CharSequence>> labelToActionId;
    private ComposeAccessibilityNodeProvider nodeProvider;
    private Function1<? super AccessibilityEvent, Boolean> onSendAccessibilityEvent = new AndroidComposeViewAccessibilityDelegateCompat$onSendAccessibilityEvent$1(this);
    private MutableIntSet paneDisplayed;
    /* access modifiers changed from: private */
    public final MutableIntObjectMap<ScrollAxisRange> pendingHorizontalScrollEvents;
    private PendingTextTraversedEvent pendingTextTraversedEvent;
    /* access modifiers changed from: private */
    public final MutableIntObjectMap<ScrollAxisRange> pendingVerticalScrollEvents;
    private MutableIntObjectMap<SemanticsNodeCopy> previousSemanticsNodes;
    private SemanticsNodeCopy previousSemanticsRoot;
    private Integer previousTraversedNode;
    private final Function1<ScrollObservationScope, Unit> scheduleScrollEventIfNeededLambda;
    private final List<ScrollObservationScope> scrollObservationScopes;
    /* access modifiers changed from: private */
    public final Runnable semanticsChangeChecker;
    /* access modifiers changed from: private */
    public boolean sendingFocusAffectingEvent;
    private final ArraySet<LayoutNode> subtreeChangedLayoutNodes;
    /* access modifiers changed from: private */
    public final AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateListener;
    private final URLSpanCache urlSpanCache;
    private final AndroidComposeView view;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                androidx.compose.ui.state.ToggleableState[] r0 = androidx.compose.ui.state.ToggleableState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.ui.state.ToggleableState r1 = androidx.compose.ui.state.ToggleableState.On     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.ui.state.ToggleableState r1 = androidx.compose.ui.state.ToggleableState.Off     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.ui.state.ToggleableState r1 = androidx.compose.ui.state.ToggleableState.Indeterminate     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.WhenMappings.<clinit>():void");
        }
    }

    public static /* synthetic */ void getHoveredVirtualViewId$ui_release$annotations() {
    }

    public static /* synthetic */ void getOnSendAccessibilityEvent$ui_release$annotations() {
    }

    public final AndroidComposeView getView() {
        return this.view;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Companion;", "", "()V", "AccessibilityActionsResourceIds", "Landroidx/collection/IntList;", "AccessibilityCursorPositionUndefined", "", "AccessibilitySliderStepsCount", "ClassName", "", "ExtraDataIdKey", "ExtraDataTestTagKey", "InvalidId", "LogTag", "ParcelSafeTextLength", "TextClassName", "TextFieldClassName", "TextTraversedEventTimeoutMillis", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public AndroidComposeViewAccessibilityDelegateCompat(AndroidComposeView androidComposeView) {
        this.view = androidComposeView;
        Object systemService = androidComposeView.getContext().getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        AccessibilityManager accessibilityManager2 = (AccessibilityManager) systemService;
        this.accessibilityManager = accessibilityManager2;
        this.SendRecurringAccessibilityEventsIntervalMillis = 100;
        this.enabledStateListener = new AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda1(this);
        this.touchExplorationStateListener = new AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda2(this);
        this.enabledServices = accessibilityManager2.getEnabledAccessibilityServiceList(-1);
        this.handler = new Handler(Looper.getMainLooper());
        this.nodeProvider = new ComposeAccessibilityNodeProvider();
        this.focusedVirtualViewId = Integer.MIN_VALUE;
        this.pendingHorizontalScrollEvents = new MutableIntObjectMap<>(0, 1, (DefaultConstructorMarker) null);
        this.pendingVerticalScrollEvents = new MutableIntObjectMap<>(0, 1, (DefaultConstructorMarker) null);
        this.actionIdToLabel = new SparseArrayCompat<>(0, 1, (DefaultConstructorMarker) null);
        this.labelToActionId = new SparseArrayCompat<>(0, 1, (DefaultConstructorMarker) null);
        this.accessibilityCursorPosition = -1;
        this.subtreeChangedLayoutNodes = new ArraySet<>(0, 1, (DefaultConstructorMarker) null);
        this.boundsUpdateChannel = ChannelKt.Channel$default(1, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        this.currentSemanticsNodesInvalidated = true;
        this.currentSemanticsNodes = IntObjectMapKt.intObjectMapOf();
        this.paneDisplayed = new MutableIntSet(0, 1, (DefaultConstructorMarker) null);
        this.idToBeforeMap = new MutableIntIntMap(0, 1, (DefaultConstructorMarker) null);
        this.idToAfterMap = new MutableIntIntMap(0, 1, (DefaultConstructorMarker) null);
        this.ExtraDataTestTraversalBeforeVal = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL";
        this.ExtraDataTestTraversalAfterVal = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL";
        this.urlSpanCache = new URLSpanCache();
        this.previousSemanticsNodes = IntObjectMapKt.mutableIntObjectMapOf();
        this.previousSemanticsRoot = new SemanticsNodeCopy(androidComposeView.getSemanticsOwner().getUnmergedRootSemanticsNode(), IntObjectMapKt.intObjectMapOf());
        androidComposeView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(this) {
            final /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat this$0;

            {
                this.this$0 = r1;
            }

            public void onViewAttachedToWindow(View view) {
                AccessibilityManager access$getAccessibilityManager$p = this.this$0.accessibilityManager;
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = this.this$0;
                access$getAccessibilityManager$p.addAccessibilityStateChangeListener(androidComposeViewAccessibilityDelegateCompat.enabledStateListener);
                access$getAccessibilityManager$p.addTouchExplorationStateChangeListener(androidComposeViewAccessibilityDelegateCompat.touchExplorationStateListener);
            }

            public void onViewDetachedFromWindow(View view) {
                this.this$0.handler.removeCallbacks(this.this$0.semanticsChangeChecker);
                AccessibilityManager access$getAccessibilityManager$p = this.this$0.accessibilityManager;
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = this.this$0;
                access$getAccessibilityManager$p.removeAccessibilityStateChangeListener(androidComposeViewAccessibilityDelegateCompat.enabledStateListener);
                access$getAccessibilityManager$p.removeTouchExplorationStateChangeListener(androidComposeViewAccessibilityDelegateCompat.touchExplorationStateListener);
            }
        });
        this.semanticsChangeChecker = new AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda3(this);
        this.scrollObservationScopes = new ArrayList();
        this.scheduleScrollEventIfNeededLambda = new AndroidComposeViewAccessibilityDelegateCompat$scheduleScrollEventIfNeededLambda$1(this);
    }

    public final int getHoveredVirtualViewId$ui_release() {
        return this.hoveredVirtualViewId;
    }

    public final void setHoveredVirtualViewId$ui_release(int i) {
        this.hoveredVirtualViewId = i;
    }

    public final Function1<AccessibilityEvent, Boolean> getOnSendAccessibilityEvent$ui_release() {
        return this.onSendAccessibilityEvent;
    }

    public final void setOnSendAccessibilityEvent$ui_release(Function1<? super AccessibilityEvent, Boolean> function1) {
        this.onSendAccessibilityEvent = function1;
    }

    public final boolean getAccessibilityForceEnabledForTesting$ui_release() {
        return this.accessibilityForceEnabledForTesting;
    }

    public final void setAccessibilityForceEnabledForTesting$ui_release(boolean z) {
        this.accessibilityForceEnabledForTesting = z;
        this.currentSemanticsNodesInvalidated = true;
    }

    public final long getSendRecurringAccessibilityEventsIntervalMillis$ui_release() {
        return this.SendRecurringAccessibilityEventsIntervalMillis;
    }

    public final void setSendRecurringAccessibilityEventsIntervalMillis$ui_release(long j) {
        this.SendRecurringAccessibilityEventsIntervalMillis = j;
    }

    /* access modifiers changed from: private */
    public static final void enabledStateListener$lambda$0(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, boolean z) {
        List<AccessibilityServiceInfo> list;
        if (z) {
            list = androidComposeViewAccessibilityDelegateCompat.accessibilityManager.getEnabledAccessibilityServiceList(-1);
        } else {
            list = CollectionsKt.emptyList();
        }
        androidComposeViewAccessibilityDelegateCompat.enabledServices = list;
    }

    /* access modifiers changed from: private */
    public static final void touchExplorationStateListener$lambda$1(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, boolean z) {
        androidComposeViewAccessibilityDelegateCompat.enabledServices = androidComposeViewAccessibilityDelegateCompat.accessibilityManager.getEnabledAccessibilityServiceList(-1);
    }

    public final boolean isEnabled$ui_release() {
        if (!this.accessibilityForceEnabledForTesting) {
            return this.accessibilityManager.isEnabled() && !this.enabledServices.isEmpty();
        }
        return true;
    }

    private final boolean isTouchExplorationEnabled() {
        if (!this.accessibilityForceEnabledForTesting) {
            return this.accessibilityManager.isEnabled() && this.accessibilityManager.isTouchExplorationEnabled();
        }
        return true;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "action", "", "granularity", "fromIndex", "toIndex", "traverseTime", "", "(Landroidx/compose/ui/semantics/SemanticsNode;IIIIJ)V", "getAction", "()I", "getFromIndex", "getGranularity", "getNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "getToIndex", "getTraverseTime", "()J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    private static final class PendingTextTraversedEvent {
        private final int action;
        private final int fromIndex;
        private final int granularity;
        private final SemanticsNode node;
        private final int toIndex;
        private final long traverseTime;

        public PendingTextTraversedEvent(SemanticsNode semanticsNode, int i, int i2, int i3, int i4, long j) {
            this.node = semanticsNode;
            this.action = i;
            this.granularity = i2;
            this.fromIndex = i3;
            this.toIndex = i4;
            this.traverseTime = j;
        }

        public final SemanticsNode getNode() {
            return this.node;
        }

        public final int getAction() {
            return this.action;
        }

        public final int getGranularity() {
            return this.granularity;
        }

        public final int getFromIndex() {
            return this.fromIndex;
        }

        public final int getToIndex() {
            return this.toIndex;
        }

        public final long getTraverseTime() {
            return this.traverseTime;
        }
    }

    /* access modifiers changed from: private */
    public final IntObjectMap<SemanticsNodeWithAdjustedBounds> getCurrentSemanticsNodes() {
        if (this.currentSemanticsNodesInvalidated) {
            this.currentSemanticsNodesInvalidated = false;
            this.currentSemanticsNodes = SemanticsUtils_androidKt.getAllUncoveredSemanticsNodesToIntObjectMap(this.view.getSemanticsOwner());
            if (isEnabled$ui_release()) {
                setTraversalValues();
            }
        }
        return this.currentSemanticsNodes;
    }

    public final MutableIntIntMap getIdToBeforeMap$ui_release() {
        return this.idToBeforeMap;
    }

    public final void setIdToBeforeMap$ui_release(MutableIntIntMap mutableIntIntMap) {
        this.idToBeforeMap = mutableIntIntMap;
    }

    public final MutableIntIntMap getIdToAfterMap$ui_release() {
        return this.idToAfterMap;
    }

    public final void setIdToAfterMap$ui_release(MutableIntIntMap mutableIntIntMap) {
        this.idToAfterMap = mutableIntIntMap;
    }

    public final String getExtraDataTestTraversalBeforeVal$ui_release() {
        return this.ExtraDataTestTraversalBeforeVal;
    }

    public final String getExtraDataTestTraversalAfterVal$ui_release() {
        return this.ExtraDataTestTraversalAfterVal;
    }

    /* renamed from: canScroll-0AR0LA0$ui_release  reason: not valid java name */
    public final boolean m6250canScroll0AR0LA0$ui_release(boolean z, int i, long j) {
        if (!Intrinsics.areEqual((Object) Looper.getMainLooper().getThread(), (Object) Thread.currentThread())) {
            return false;
        }
        return m6249canScrollmoWRBKg(getCurrentSemanticsNodes(), z, i, j);
    }

    /* renamed from: canScroll-moWRBKg  reason: not valid java name */
    private final boolean m6249canScrollmoWRBKg(IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap, boolean z, int i, long j) {
        SemanticsPropertyKey semanticsPropertyKey;
        ScrollAxisRange scrollAxisRange;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap2 = intObjectMap;
        boolean z2 = z;
        int i2 = i;
        long j2 = j;
        if (Offset.m3984equalsimpl0(j2, Offset.Companion.m4002getUnspecifiedF1C5BW0()) || !Offset.m3990isValidimpl(j2)) {
            return false;
        }
        if (z2) {
            semanticsPropertyKey = SemanticsProperties.INSTANCE.getVerticalScrollAxisRange();
        } else if (!z2) {
            semanticsPropertyKey = SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Object[] objArr = intObjectMap2.values;
        long[] jArr = intObjectMap2.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return false;
        }
        int i3 = 0;
        boolean z3 = false;
        while (true) {
            long j3 = jArr[i3];
            if ((((~j3) << 7) & j3 & -9187201950435737472L) != -9187201950435737472L) {
                int i4 = 8 - ((~(i3 - length)) >>> 31);
                for (int i5 = 0; i5 < i4; i5++) {
                    if ((j3 & 255) < 128) {
                        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) objArr[(i3 << 3) + i5];
                        if (RectHelper_androidKt.toComposeRect(semanticsNodeWithAdjustedBounds.getAdjustedBounds()).m4013containsk4lQ0M(j2) && (scrollAxisRange = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNodeWithAdjustedBounds.getSemanticsNode().getUnmergedConfig$ui_release(), semanticsPropertyKey)) != null) {
                            int i6 = scrollAxisRange.getReverseScrolling() ? -i2 : i2;
                            if (i2 == 0 && scrollAxisRange.getReverseScrolling()) {
                                i6 = -1;
                            }
                            if (i6 < 0) {
                                if (scrollAxisRange.getValue().invoke().floatValue() <= 0.0f) {
                                    j3 >>= 8;
                                }
                            } else if (scrollAxisRange.getValue().invoke().floatValue() >= scrollAxisRange.getMaxValue().invoke().floatValue()) {
                                j3 >>= 8;
                            }
                            z3 = true;
                            j3 >>= 8;
                        }
                    }
                    j3 >>= 8;
                }
                if (i4 != 8) {
                    return z3;
                }
            }
            if (i3 == length) {
                return z3;
            }
            i3++;
        }
    }

    /* JADX WARNING: type inference failed for: r1v11, types: [java.lang.Integer] */
    /* JADX WARNING: type inference failed for: r4v4, types: [android.view.ViewParent] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        r0 = (r0 = r0.getLifecycleOwner()).getLifecycle();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.core.view.accessibility.AccessibilityNodeInfoCompat createNodeInfo(int r7) {
        /*
            r6 = this;
            androidx.compose.ui.platform.AndroidComposeView r0 = r6.view
            androidx.compose.ui.platform.AndroidComposeView$ViewTreeOwners r0 = r0.getViewTreeOwners()
            r1 = 0
            if (r0 == 0) goto L_0x001a
            androidx.lifecycle.LifecycleOwner r0 = r0.getLifecycleOwner()
            if (r0 == 0) goto L_0x001a
            androidx.lifecycle.Lifecycle r0 = r0.getLifecycle()
            if (r0 == 0) goto L_0x001a
            androidx.lifecycle.Lifecycle$State r0 = r0.getCurrentState()
            goto L_0x001b
        L_0x001a:
            r0 = r1
        L_0x001b:
            androidx.lifecycle.Lifecycle$State r2 = androidx.lifecycle.Lifecycle.State.DESTROYED
            if (r0 != r2) goto L_0x0020
            return r1
        L_0x0020:
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat r0 = androidx.core.view.accessibility.AccessibilityNodeInfoCompat.obtain()
            androidx.collection.IntObjectMap r2 = r6.getCurrentSemanticsNodes()
            java.lang.Object r2 = r2.get(r7)
            androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds r2 = (androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds) r2
            if (r2 != 0) goto L_0x0031
            return r1
        L_0x0031:
            androidx.compose.ui.semantics.SemanticsNode r3 = r2.getSemanticsNode()
            r4 = -1
            if (r7 != r4) goto L_0x0049
            androidx.compose.ui.platform.AndroidComposeView r4 = r6.view
            android.view.ViewParent r4 = r4.getParentForAccessibility()
            boolean r5 = r4 instanceof android.view.View
            if (r5 == 0) goto L_0x0045
            r1 = r4
            android.view.View r1 = (android.view.View) r1
        L_0x0045:
            r0.setParent(r1)
            goto L_0x0078
        L_0x0049:
            androidx.compose.ui.semantics.SemanticsNode r5 = r3.getParent()
            if (r5 == 0) goto L_0x0057
            int r1 = r5.getId()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x0057:
            if (r1 == 0) goto L_0x008a
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            androidx.compose.ui.platform.AndroidComposeView r5 = r6.view
            androidx.compose.ui.semantics.SemanticsOwner r5 = r5.getSemanticsOwner()
            androidx.compose.ui.semantics.SemanticsNode r5 = r5.getUnmergedRootSemanticsNode()
            int r5 = r5.getId()
            if (r1 != r5) goto L_0x0070
            goto L_0x0071
        L_0x0070:
            r4 = r1
        L_0x0071:
            androidx.compose.ui.platform.AndroidComposeView r1 = r6.view
            android.view.View r1 = (android.view.View) r1
            r0.setParent(r1, r4)
        L_0x0078:
            androidx.compose.ui.platform.AndroidComposeView r1 = r6.view
            android.view.View r1 = (android.view.View) r1
            r0.setSource(r1, r7)
            android.graphics.Rect r1 = r6.boundsInScreen(r2)
            r0.setBoundsInScreen(r1)
            r6.populateAccessibilityNodeInfoProperties(r7, r0, r3)
            return r0
        L_0x008a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "semanticsNode "
            r0.<init>(r1)
            java.lang.StringBuilder r7 = r0.append(r7)
            java.lang.String r0 = " has null parent"
            java.lang.StringBuilder r7 = r7.append(r0)
            java.lang.String r7 = r7.toString()
            androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateExceptionForNullCheck(r7)
            kotlin.KotlinNothingValueException r7 = new kotlin.KotlinNothingValueException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.createNodeInfo(int):androidx.core.view.accessibility.AccessibilityNodeInfoCompat");
    }

    /* access modifiers changed from: private */
    public final Rect boundsInScreen(SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds) {
        Rect adjustedBounds = semanticsNodeWithAdjustedBounds.getAdjustedBounds();
        long r0 = this.view.m6237localToScreenMKHz9U(OffsetKt.Offset((float) adjustedBounds.left, (float) adjustedBounds.top));
        long r2 = this.view.m6237localToScreenMKHz9U(OffsetKt.Offset((float) adjustedBounds.right, (float) adjustedBounds.bottom));
        return new Rect((int) ((float) Math.floor((double) Offset.m3987getXimpl(r0))), (int) ((float) Math.floor((double) Offset.m3988getYimpl(r0))), (int) ((float) Math.ceil((double) Offset.m3987getXimpl(r2))), (int) ((float) Math.ceil((double) Offset.m3988getYimpl(r2))));
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u000026\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00020\u0001j\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002`\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0007J<\u0010\b\u001a\u00020\t2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00022\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002H\u0016¨\u0006\f"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$TopBottomBoundsComparator;", "Ljava/util/Comparator;", "Lkotlin/Pair;", "Landroidx/compose/ui/geometry/Rect;", "", "Landroidx/compose/ui/semantics/SemanticsNode;", "Lkotlin/Comparator;", "()V", "compare", "", "a", "b", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    private static final class TopBottomBoundsComparator implements Comparator<Pair<? extends androidx.compose.ui.geometry.Rect, ? extends List<SemanticsNode>>> {
        public static final TopBottomBoundsComparator INSTANCE = new TopBottomBoundsComparator();

        private TopBottomBoundsComparator() {
        }

        public int compare(Pair<androidx.compose.ui.geometry.Rect, ? extends List<SemanticsNode>> pair, Pair<androidx.compose.ui.geometry.Rect, ? extends List<SemanticsNode>> pair2) {
            int compare = Float.compare(pair.getFirst().getTop(), pair2.getFirst().getTop());
            if (compare != 0) {
                return compare;
            }
            return Float.compare(pair.getFirst().getBottom(), pair2.getFirst().getBottom());
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$LtrBoundsComparator;", "Ljava/util/Comparator;", "Landroidx/compose/ui/semantics/SemanticsNode;", "Lkotlin/Comparator;", "()V", "compare", "", "a", "b", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    private static final class LtrBoundsComparator implements Comparator<SemanticsNode> {
        public static final LtrBoundsComparator INSTANCE = new LtrBoundsComparator();

        private LtrBoundsComparator() {
        }

        public int compare(SemanticsNode semanticsNode, SemanticsNode semanticsNode2) {
            androidx.compose.ui.geometry.Rect boundsInWindow = semanticsNode.getBoundsInWindow();
            androidx.compose.ui.geometry.Rect boundsInWindow2 = semanticsNode2.getBoundsInWindow();
            int compare = Float.compare(boundsInWindow.getLeft(), boundsInWindow2.getLeft());
            if (compare != 0) {
                return compare;
            }
            int compare2 = Float.compare(boundsInWindow.getTop(), boundsInWindow2.getTop());
            if (compare2 != 0) {
                return compare2;
            }
            int compare3 = Float.compare(boundsInWindow.getBottom(), boundsInWindow2.getBottom());
            if (compare3 != 0) {
                return compare3;
            }
            return Float.compare(boundsInWindow.getRight(), boundsInWindow2.getRight());
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$RtlBoundsComparator;", "Ljava/util/Comparator;", "Landroidx/compose/ui/semantics/SemanticsNode;", "Lkotlin/Comparator;", "()V", "compare", "", "a", "b", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    private static final class RtlBoundsComparator implements Comparator<SemanticsNode> {
        public static final RtlBoundsComparator INSTANCE = new RtlBoundsComparator();

        private RtlBoundsComparator() {
        }

        public int compare(SemanticsNode semanticsNode, SemanticsNode semanticsNode2) {
            androidx.compose.ui.geometry.Rect boundsInWindow = semanticsNode.getBoundsInWindow();
            androidx.compose.ui.geometry.Rect boundsInWindow2 = semanticsNode2.getBoundsInWindow();
            int compare = Float.compare(boundsInWindow2.getRight(), boundsInWindow.getRight());
            if (compare != 0) {
                return compare;
            }
            int compare2 = Float.compare(boundsInWindow.getTop(), boundsInWindow2.getTop());
            if (compare2 != 0) {
                return compare2;
            }
            int compare3 = Float.compare(boundsInWindow.getBottom(), boundsInWindow2.getBottom());
            if (compare3 != 0) {
                return compare3;
            }
            return Float.compare(boundsInWindow2.getLeft(), boundsInWindow.getLeft());
        }
    }

    private final Comparator<SemanticsNode> semanticComparator(boolean z) {
        return new AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$$inlined$thenBy$2<>(new AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$$inlined$thenBy$1(z ? RtlBoundsComparator.INSTANCE : LtrBoundsComparator.INSTANCE, LayoutNode.Companion.getZComparator$ui_release()));
    }

    static /* synthetic */ List sortByGeometryGroupings$default(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, boolean z, ArrayList arrayList, MutableIntObjectMap mutableIntObjectMap, int i, Object obj) {
        if ((i & 4) != 0) {
            mutableIntObjectMap = IntObjectMapKt.mutableIntObjectMapOf();
        }
        return androidComposeViewAccessibilityDelegateCompat.sortByGeometryGroupings(z, arrayList, mutableIntObjectMap);
    }

    private final List<SemanticsNode> sortByGeometryGroupings(boolean z, ArrayList<SemanticsNode> arrayList, MutableIntObjectMap<List<SemanticsNode>> mutableIntObjectMap) {
        ArrayList arrayList2 = new ArrayList();
        int lastIndex = CollectionsKt.getLastIndex(arrayList);
        int i = 0;
        if (lastIndex >= 0) {
            int i2 = 0;
            while (true) {
                SemanticsNode semanticsNode = arrayList.get(i2);
                if (i2 == 0 || !sortByGeometryGroupings$placedEntryRowOverlaps(arrayList2, semanticsNode)) {
                    arrayList2.add(new Pair(semanticsNode.getBoundsInWindow(), CollectionsKt.mutableListOf(semanticsNode)));
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        List list = arrayList2;
        CollectionsKt.sortWith(list, TopBottomBoundsComparator.INSTANCE);
        ArrayList arrayList3 = new ArrayList();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            Pair pair = (Pair) list.get(i3);
            CollectionsKt.sortWith((List) pair.getSecond(), new AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$$inlined$thenBy$2(new AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$$inlined$thenBy$1(z ? RtlBoundsComparator.INSTANCE : LtrBoundsComparator.INSTANCE, LayoutNode.Companion.getZComparator$ui_release())));
            arrayList3.addAll((Collection) pair.getSecond());
        }
        List<SemanticsNode> list2 = arrayList3;
        CollectionsKt.sortWith(list2, new AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda0(AndroidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$2.INSTANCE));
        while (i <= CollectionsKt.getLastIndex(list2)) {
            List list3 = mutableIntObjectMap.get(((SemanticsNode) arrayList3.get(i)).getId());
            if (list3 != null) {
                if (!isScreenReaderFocusable((SemanticsNode) arrayList3.get(i))) {
                    arrayList3.remove(i);
                } else {
                    i++;
                }
                arrayList3.addAll(i, list3);
                i += list3.size();
            } else {
                i++;
            }
        }
        return list2;
    }

    private static final boolean sortByGeometryGroupings$placedEntryRowOverlaps(ArrayList<Pair<androidx.compose.ui.geometry.Rect, List<SemanticsNode>>> arrayList, SemanticsNode semanticsNode) {
        float top = semanticsNode.getBoundsInWindow().getTop();
        float bottom = semanticsNode.getBoundsInWindow().getBottom();
        boolean z = top >= bottom;
        int lastIndex = CollectionsKt.getLastIndex(arrayList);
        if (lastIndex >= 0) {
            int i = 0;
            while (true) {
                androidx.compose.ui.geometry.Rect rect = (androidx.compose.ui.geometry.Rect) arrayList.get(i).getFirst();
                boolean z2 = rect.getTop() >= rect.getBottom();
                if (z || z2 || Math.max(top, rect.getTop()) >= Math.min(bottom, rect.getBottom())) {
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                } else {
                    arrayList.set(i, new Pair(rect.intersect(0.0f, top, Float.POSITIVE_INFINITY, bottom), arrayList.get(i).getSecond()));
                    ((List) arrayList.get(i).getSecond()).add(semanticsNode);
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static final int sortByGeometryGroupings$lambda$7(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    private final void geometryDepthFirstSearch(SemanticsNode semanticsNode, ArrayList<SemanticsNode> arrayList, MutableIntObjectMap<List<SemanticsNode>> mutableIntObjectMap) {
        boolean access$isRtl = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode);
        boolean booleanValue = ((Boolean) semanticsNode.getUnmergedConfig$ui_release().getOrElse(SemanticsProperties.INSTANCE.getIsTraversalGroup(), AndroidComposeViewAccessibilityDelegateCompat$geometryDepthFirstSearch$isTraversalGroup$1.INSTANCE)).booleanValue();
        if ((booleanValue || isScreenReaderFocusable(semanticsNode)) && getCurrentSemanticsNodes().containsKey(semanticsNode.getId())) {
            arrayList.add(semanticsNode);
        }
        if (booleanValue) {
            mutableIntObjectMap.set(semanticsNode.getId(), subtreeSortedByGeometryGrouping(access$isRtl, CollectionsKt.toMutableList(semanticsNode.getChildren())));
            return;
        }
        List<SemanticsNode> children = semanticsNode.getChildren();
        int size = children.size();
        for (int i = 0; i < size; i++) {
            geometryDepthFirstSearch(children.get(i), arrayList, mutableIntObjectMap);
        }
    }

    private final List<SemanticsNode> subtreeSortedByGeometryGrouping(boolean z, List<SemanticsNode> list) {
        MutableIntObjectMap mutableIntObjectMapOf = IntObjectMapKt.mutableIntObjectMapOf();
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            geometryDepthFirstSearch(list.get(i), arrayList, mutableIntObjectMapOf);
        }
        return sortByGeometryGroupings(z, arrayList, mutableIntObjectMapOf);
    }

    private final void setTraversalValues() {
        this.idToBeforeMap.clear();
        this.idToAfterMap.clear();
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(-1);
        SemanticsNode semanticsNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
        Intrinsics.checkNotNull(semanticsNode);
        int i = 1;
        List<SemanticsNode> subtreeSortedByGeometryGrouping = subtreeSortedByGeometryGrouping(AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode), CollectionsKt.mutableListOf(semanticsNode));
        int lastIndex = CollectionsKt.getLastIndex(subtreeSortedByGeometryGrouping);
        if (1 <= lastIndex) {
            while (true) {
                int id = subtreeSortedByGeometryGrouping.get(i - 1).getId();
                int id2 = subtreeSortedByGeometryGrouping.get(i).getId();
                this.idToBeforeMap.set(id, id2);
                this.idToAfterMap.set(id2, id);
                if (i != lastIndex) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private final boolean isScreenReaderFocusable(SemanticsNode semanticsNode) {
        List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getContentDescription());
        return semanticsNode.getUnmergedConfig$ui_release().isMergingSemanticsOfDescendants() || (semanticsNode.isUnmergedLeafNode$ui_release() && ((list != null ? (String) CollectionsKt.firstOrNull(list) : null) != null || getInfoText(semanticsNode) != null || getInfoStateDescriptionOrNull(semanticsNode) != null || getInfoIsCheckable(semanticsNode)));
    }

    private final void populateAccessibilityNodeInfoProperties(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, SemanticsNode semanticsNode) {
        View semanticsIdToView;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat2;
        boolean z;
        boolean z2;
        int i2 = i;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = accessibilityNodeInfoCompat;
        SemanticsNode semanticsNode2 = semanticsNode;
        accessibilityNodeInfoCompat2.setClassName(ClassName);
        if (semanticsNode2.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getEditableText())) {
            accessibilityNodeInfoCompat2.setClassName(TextFieldClassName);
        }
        if (semanticsNode2.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getText())) {
            accessibilityNodeInfoCompat2.setClassName(TextClassName);
        }
        Role role = (Role) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getRole());
        if (role != null) {
            role.m6366unboximpl();
            if (semanticsNode2.isFake$ui_release() || semanticsNode2.getReplacedChildren$ui_release().isEmpty()) {
                if (Role.m6363equalsimpl0(role.m6366unboximpl(), Role.Companion.m6373getTabo7Vup1c())) {
                    accessibilityNodeInfoCompat2.setRoleDescription(this.view.getContext().getResources().getString(R.string.tab));
                } else {
                    if (Role.m6363equalsimpl0(role.m6366unboximpl(), Role.Companion.m6372getSwitcho7Vup1c())) {
                        accessibilityNodeInfoCompat2.setRoleDescription(this.view.getContext().getResources().getString(R.string.switch_role));
                    } else {
                        String r7 = SemanticsUtils_androidKt.m6332toLegacyClassNameV4PA4sw(role.m6366unboximpl());
                        if (!Role.m6363equalsimpl0(role.m6366unboximpl(), Role.Companion.m6370getImageo7Vup1c()) || semanticsNode2.isUnmergedLeafNode$ui_release() || semanticsNode2.getUnmergedConfig$ui_release().isMergingSemanticsOfDescendants()) {
                            accessibilityNodeInfoCompat2.setClassName(r7);
                        }
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
        }
        if (semanticsNode2.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getSetText())) {
            accessibilityNodeInfoCompat2.setClassName(TextFieldClassName);
        }
        if (semanticsNode2.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getText())) {
            accessibilityNodeInfoCompat2.setClassName(TextClassName);
        }
        accessibilityNodeInfoCompat2.setPackageName(this.view.getContext().getPackageName());
        accessibilityNodeInfoCompat2.setImportantForAccessibility(SemanticsUtils_androidKt.isImportantForAccessibility(semanticsNode2));
        List<SemanticsNode> replacedChildren$ui_release = semanticsNode2.getReplacedChildren$ui_release();
        int size = replacedChildren$ui_release.size();
        for (int i3 = 0; i3 < size; i3++) {
            SemanticsNode semanticsNode3 = replacedChildren$ui_release.get(i3);
            if (getCurrentSemanticsNodes().contains(semanticsNode3.getId())) {
                AndroidViewHolder androidViewHolder = this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(semanticsNode3.getLayoutNode$ui_release());
                if (semanticsNode3.getId() != -1) {
                    if (androidViewHolder != null) {
                        accessibilityNodeInfoCompat2.addChild(androidViewHolder);
                    } else {
                        accessibilityNodeInfoCompat2.addChild(this.view, semanticsNode3.getId());
                    }
                }
            }
        }
        if (i2 == this.focusedVirtualViewId) {
            accessibilityNodeInfoCompat2.setAccessibilityFocused(true);
            accessibilityNodeInfoCompat2.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        } else {
            accessibilityNodeInfoCompat2.setAccessibilityFocused(false);
            accessibilityNodeInfoCompat2.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_ACCESSIBILITY_FOCUS);
        }
        setText(semanticsNode2, accessibilityNodeInfoCompat2);
        setContentInvalid(semanticsNode2, accessibilityNodeInfoCompat2);
        setStateDescription(semanticsNode2, accessibilityNodeInfoCompat2);
        setIsCheckable(semanticsNode2, accessibilityNodeInfoCompat2);
        ToggleableState toggleableState = (ToggleableState) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getToggleableState());
        if (toggleableState != null) {
            if (toggleableState == ToggleableState.On) {
                accessibilityNodeInfoCompat2.setChecked(true);
            } else if (toggleableState == ToggleableState.Off) {
                accessibilityNodeInfoCompat2.setChecked(false);
            }
            Unit unit3 = Unit.INSTANCE;
            Unit unit4 = Unit.INSTANCE;
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getSelected());
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            if (role == null ? false : Role.m6363equalsimpl0(role.m6366unboximpl(), Role.Companion.m6373getTabo7Vup1c())) {
                accessibilityNodeInfoCompat2.setSelected(booleanValue);
            } else {
                accessibilityNodeInfoCompat2.setChecked(booleanValue);
            }
            Unit unit5 = Unit.INSTANCE;
            Unit unit6 = Unit.INSTANCE;
        }
        if (!semanticsNode2.getUnmergedConfig$ui_release().isMergingSemanticsOfDescendants() || semanticsNode2.getReplacedChildren$ui_release().isEmpty()) {
            List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getContentDescription());
            accessibilityNodeInfoCompat2.setContentDescription(list != null ? (String) CollectionsKt.firstOrNull(list) : null);
        }
        String str = (String) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getTestTag());
        if (str != null) {
            SemanticsNode semanticsNode4 = semanticsNode2;
            while (true) {
                if (semanticsNode4 == null) {
                    z2 = false;
                    break;
                } else if (semanticsNode4.getUnmergedConfig$ui_release().contains(SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId())) {
                    z2 = ((Boolean) semanticsNode4.getUnmergedConfig$ui_release().get(SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId())).booleanValue();
                    break;
                } else {
                    semanticsNode4 = semanticsNode4.getParent();
                }
            }
            if (z2) {
                accessibilityNodeInfoCompat2.setViewIdResourceName(str);
            }
        }
        if (((Unit) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getHeading())) != null) {
            accessibilityNodeInfoCompat2.setHeading(true);
            Unit unit7 = Unit.INSTANCE;
            Unit unit8 = Unit.INSTANCE;
        }
        accessibilityNodeInfoCompat2.setPassword(semanticsNode2.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getPassword()));
        accessibilityNodeInfoCompat2.setEditable(semanticsNode2.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getIsEditable()));
        Integer num = (Integer) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getMaxTextLength());
        accessibilityNodeInfoCompat2.setMaxTextLength(num != null ? num.intValue() : -1);
        accessibilityNodeInfoCompat2.setEnabled(AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode2));
        accessibilityNodeInfoCompat2.setFocusable(semanticsNode2.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getFocused()));
        int i4 = 2;
        if (accessibilityNodeInfoCompat2.isFocusable()) {
            accessibilityNodeInfoCompat2.setFocused(((Boolean) semanticsNode2.getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getFocused())).booleanValue());
            if (accessibilityNodeInfoCompat2.isFocused()) {
                accessibilityNodeInfoCompat2.addAction(2);
            } else {
                accessibilityNodeInfoCompat2.addAction(1);
            }
        }
        accessibilityNodeInfoCompat2.setVisibleToUser(AndroidComposeViewAccessibilityDelegateCompat_androidKt.isVisible(semanticsNode2));
        LiveRegionMode liveRegionMode = (LiveRegionMode) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getLiveRegion());
        if (liveRegionMode != null) {
            int r5 = liveRegionMode.m6357unboximpl();
            if (LiveRegionMode.m6354equalsimpl0(r5, LiveRegionMode.Companion.m6359getPolite0phEisY()) || !LiveRegionMode.m6354equalsimpl0(r5, LiveRegionMode.Companion.m6358getAssertive0phEisY())) {
                i4 = 1;
            }
            accessibilityNodeInfoCompat2.setLiveRegion(i4);
            Unit unit9 = Unit.INSTANCE;
            Unit unit10 = Unit.INSTANCE;
        }
        accessibilityNodeInfoCompat2.setClickable(false);
        AccessibilityAction accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getOnClick());
        if (accessibilityAction != null) {
            boolean areEqual = Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getSelected()), (Object) true);
            if (!(role == null ? false : Role.m6363equalsimpl0(role.m6366unboximpl(), Role.Companion.m6373getTabo7Vup1c()))) {
                if (!(role == null ? false : Role.m6363equalsimpl0(role.m6366unboximpl(), Role.Companion.m6371getRadioButtono7Vup1c()))) {
                    z = false;
                    accessibilityNodeInfoCompat2.setClickable(z || (z && !areEqual));
                    if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode2) && accessibilityNodeInfoCompat2.isClickable()) {
                        accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, accessibilityAction.getLabel()));
                    }
                    Unit unit11 = Unit.INSTANCE;
                    Unit unit12 = Unit.INSTANCE;
                }
            }
            z = true;
            accessibilityNodeInfoCompat2.setClickable(z || (z && !areEqual));
            accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, accessibilityAction.getLabel()));
            Unit unit112 = Unit.INSTANCE;
            Unit unit122 = Unit.INSTANCE;
        }
        accessibilityNodeInfoCompat2.setLongClickable(false);
        AccessibilityAction accessibilityAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getOnLongClick());
        if (accessibilityAction2 != null) {
            accessibilityNodeInfoCompat2.setLongClickable(true);
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode2)) {
                accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32, accessibilityAction2.getLabel()));
            }
            Unit unit13 = Unit.INSTANCE;
            Unit unit14 = Unit.INSTANCE;
        }
        AccessibilityAction accessibilityAction3 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getCopyText());
        if (accessibilityAction3 != null) {
            accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16384, accessibilityAction3.getLabel()));
            Unit unit15 = Unit.INSTANCE;
            Unit unit16 = Unit.INSTANCE;
        }
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode2)) {
            AccessibilityAction accessibilityAction4 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getSetText());
            if (accessibilityAction4 != null) {
                accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(2097152, accessibilityAction4.getLabel()));
                Unit unit17 = Unit.INSTANCE;
                Unit unit18 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction5 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getOnImeAction());
            if (accessibilityAction5 != null) {
                accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908372, accessibilityAction5.getLabel()));
                Unit unit19 = Unit.INSTANCE;
                Unit unit20 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction6 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getCutText());
            if (accessibilityAction6 != null) {
                accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(65536, accessibilityAction6.getLabel()));
                Unit unit21 = Unit.INSTANCE;
                Unit unit22 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction7 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPasteText());
            if (accessibilityAction7 != null) {
                if (accessibilityNodeInfoCompat2.isFocused() && this.view.getClipboardManager().hasText()) {
                    accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32768, accessibilityAction7.getLabel()));
                }
                Unit unit23 = Unit.INSTANCE;
                Unit unit24 = Unit.INSTANCE;
            }
        }
        CharSequence iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode2);
        if (!(iterableTextForAccessibility == null || iterableTextForAccessibility.length() == 0)) {
            accessibilityNodeInfoCompat2.setTextSelection(getAccessibilitySelectionStart(semanticsNode2), getAccessibilitySelectionEnd(semanticsNode2));
            AccessibilityAction accessibilityAction8 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getSetSelection());
            accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(131072, accessibilityAction8 != null ? accessibilityAction8.getLabel() : null));
            accessibilityNodeInfoCompat2.addAction(256);
            accessibilityNodeInfoCompat2.addAction(512);
            accessibilityNodeInfoCompat2.setMovementGranularities(11);
            Collection collection = (List) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getContentDescription());
            if ((collection == null || collection.isEmpty()) && semanticsNode2.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult()) && !AndroidComposeViewAccessibilityDelegateCompat_androidKt.excludeLineAndPageGranularities(semanticsNode2)) {
                accessibilityNodeInfoCompat2.setMovementGranularities(accessibilityNodeInfoCompat2.getMovementGranularities() | 20);
            }
        }
        List arrayList = new ArrayList();
        arrayList.add(ExtraDataIdKey);
        CharSequence text = accessibilityNodeInfoCompat2.getText();
        if (!(text == null || text.length() == 0) && semanticsNode2.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult())) {
            arrayList.add("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY");
        }
        if (semanticsNode2.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getTestTag())) {
            arrayList.add(ExtraDataTestTagKey);
        }
        accessibilityNodeInfoCompat2.setAvailableExtraData(arrayList);
        ProgressBarRangeInfo progressBarRangeInfo = (ProgressBarRangeInfo) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getProgressBarRangeInfo());
        if (progressBarRangeInfo != null) {
            if (semanticsNode2.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getSetProgress())) {
                accessibilityNodeInfoCompat2.setClassName("android.widget.SeekBar");
            } else {
                accessibilityNodeInfoCompat2.setClassName("android.widget.ProgressBar");
            }
            if (progressBarRangeInfo != ProgressBarRangeInfo.Companion.getIndeterminate()) {
                accessibilityNodeInfoCompat2.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, progressBarRangeInfo.getRange().getStart().floatValue(), progressBarRangeInfo.getRange().getEndInclusive().floatValue(), progressBarRangeInfo.getCurrent()));
            }
            if (semanticsNode2.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getSetProgress()) && AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode2)) {
                if (progressBarRangeInfo.getCurrent() < RangesKt.coerceAtLeast(progressBarRangeInfo.getRange().getEndInclusive().floatValue(), progressBarRangeInfo.getRange().getStart().floatValue())) {
                    accessibilityNodeInfoCompat2.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                }
                if (progressBarRangeInfo.getCurrent() > RangesKt.coerceAtMost(progressBarRangeInfo.getRange().getStart().floatValue(), progressBarRangeInfo.getRange().getEndInclusive().floatValue())) {
                    accessibilityNodeInfoCompat2.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                }
            }
        }
        Api24Impl.addSetProgressAction(accessibilityNodeInfoCompat, semanticsNode);
        CollectionInfo_androidKt.setCollectionInfo(semanticsNode2, accessibilityNodeInfoCompat2);
        CollectionInfo_androidKt.setCollectionItemInfo(semanticsNode2, accessibilityNodeInfoCompat2);
        ScrollAxisRange scrollAxisRange = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange());
        AccessibilityAction accessibilityAction9 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getScrollBy());
        if (!(scrollAxisRange == null || accessibilityAction9 == null)) {
            if (!CollectionInfo_androidKt.hasCollectionInfo(semanticsNode2)) {
                accessibilityNodeInfoCompat2.setClassName("android.widget.HorizontalScrollView");
            }
            if (scrollAxisRange.getMaxValue().invoke().floatValue() > 0.0f) {
                accessibilityNodeInfoCompat2.setScrollable(true);
            }
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode2)) {
                if (populateAccessibilityNodeInfoProperties$canScrollForward(scrollAxisRange)) {
                    accessibilityNodeInfoCompat2.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    if (!AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode2)) {
                        accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                    } else {
                        accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                    }
                    accessibilityNodeInfoCompat2.addAction(accessibilityActionCompat2);
                }
                if (populateAccessibilityNodeInfoProperties$canScrollBackward(scrollAxisRange)) {
                    accessibilityNodeInfoCompat2.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    if (!AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode2)) {
                        accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                    } else {
                        accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                    }
                    accessibilityNodeInfoCompat2.addAction(accessibilityActionCompat);
                }
            }
        }
        ScrollAxisRange scrollAxisRange2 = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
        if (!(scrollAxisRange2 == null || accessibilityAction9 == null)) {
            if (!CollectionInfo_androidKt.hasCollectionInfo(semanticsNode2)) {
                accessibilityNodeInfoCompat2.setClassName("android.widget.ScrollView");
            }
            if (scrollAxisRange2.getMaxValue().invoke().floatValue() > 0.0f) {
                accessibilityNodeInfoCompat2.setScrollable(true);
            }
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode2)) {
                if (populateAccessibilityNodeInfoProperties$canScrollForward(scrollAxisRange2)) {
                    accessibilityNodeInfoCompat2.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    accessibilityNodeInfoCompat2.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
                }
                if (populateAccessibilityNodeInfoProperties$canScrollBackward(scrollAxisRange2)) {
                    accessibilityNodeInfoCompat2.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    accessibilityNodeInfoCompat2.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.addPageActions(accessibilityNodeInfoCompat, semanticsNode);
        }
        accessibilityNodeInfoCompat2.setPaneTitle((CharSequence) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getPaneTitle()));
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode2)) {
            AccessibilityAction accessibilityAction10 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getExpand());
            if (accessibilityAction10 != null) {
                accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(262144, accessibilityAction10.getLabel()));
                Unit unit25 = Unit.INSTANCE;
                Unit unit26 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction11 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getCollapse());
            if (accessibilityAction11 != null) {
                accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(524288, accessibilityAction11.getLabel()));
                Unit unit27 = Unit.INSTANCE;
                Unit unit28 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction12 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getDismiss());
            if (accessibilityAction12 != null) {
                accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(1048576, accessibilityAction12.getLabel()));
                Unit unit29 = Unit.INSTANCE;
                Unit unit30 = Unit.INSTANCE;
            }
            if (semanticsNode2.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getCustomActions())) {
                List list2 = (List) semanticsNode2.getUnmergedConfig$ui_release().get(SemanticsActions.INSTANCE.getCustomActions());
                int size2 = list2.size();
                IntList intList = AccessibilityActionsResourceIds;
                if (size2 < intList.getSize()) {
                    SparseArrayCompat sparseArrayCompat = new SparseArrayCompat(0, 1, (DefaultConstructorMarker) null);
                    MutableObjectIntMap mutableObjectIntMapOf = ObjectIntMapKt.mutableObjectIntMapOf();
                    if (this.labelToActionId.containsKey(i2)) {
                        MutableObjectIntMap mutableObjectIntMap = this.labelToActionId.get(i2);
                        MutableIntList mutableIntList = new MutableIntList(0, 1, (DefaultConstructorMarker) null);
                        int[] iArr = intList.content;
                        int i5 = intList._size;
                        for (int i6 = 0; i6 < i5; i6++) {
                            mutableIntList.add(iArr[i6]);
                        }
                        List arrayList2 = new ArrayList();
                        int size3 = list2.size();
                        for (int i7 = 0; i7 < size3; i7++) {
                            CustomAccessibilityAction customAccessibilityAction = (CustomAccessibilityAction) list2.get(i7);
                            Intrinsics.checkNotNull(mutableObjectIntMap);
                            if (mutableObjectIntMap.contains(customAccessibilityAction.getLabel())) {
                                int i8 = mutableObjectIntMap.get(customAccessibilityAction.getLabel());
                                sparseArrayCompat.put(i8, customAccessibilityAction.getLabel());
                                mutableObjectIntMapOf.set(customAccessibilityAction.getLabel(), i8);
                                mutableIntList.remove(i8);
                                accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i8, customAccessibilityAction.getLabel()));
                            } else {
                                arrayList2.add(customAccessibilityAction);
                            }
                        }
                        int size4 = arrayList2.size();
                        for (int i9 = 0; i9 < size4; i9++) {
                            CustomAccessibilityAction customAccessibilityAction2 = (CustomAccessibilityAction) arrayList2.get(i9);
                            int i10 = mutableIntList.get(i9);
                            sparseArrayCompat.put(i10, customAccessibilityAction2.getLabel());
                            mutableObjectIntMapOf.set(customAccessibilityAction2.getLabel(), i10);
                            accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i10, customAccessibilityAction2.getLabel()));
                        }
                    } else {
                        int size5 = list2.size();
                        for (int i11 = 0; i11 < size5; i11++) {
                            CustomAccessibilityAction customAccessibilityAction3 = (CustomAccessibilityAction) list2.get(i11);
                            int i12 = AccessibilityActionsResourceIds.get(i11);
                            sparseArrayCompat.put(i12, customAccessibilityAction3.getLabel());
                            mutableObjectIntMapOf.set(customAccessibilityAction3.getLabel(), i12);
                            accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i12, customAccessibilityAction3.getLabel()));
                        }
                    }
                    this.actionIdToLabel.put(i2, sparseArrayCompat);
                    this.labelToActionId.put(i2, mutableObjectIntMapOf);
                } else {
                    throw new IllegalStateException("Can't have more than " + intList.getSize() + " custom actions for one widget");
                }
            }
        }
        accessibilityNodeInfoCompat2.setScreenReaderFocusable(isScreenReaderFocusable(semanticsNode2));
        int orDefault = this.idToBeforeMap.getOrDefault(i2, -1);
        if (orDefault != -1) {
            View semanticsIdToView2 = SemanticsUtils_androidKt.semanticsIdToView(this.view.getAndroidViewsHandler$ui_release(), orDefault);
            if (semanticsIdToView2 != null) {
                accessibilityNodeInfoCompat2.setTraversalBefore(semanticsIdToView2);
            } else {
                accessibilityNodeInfoCompat2.setTraversalBefore(this.view, orDefault);
            }
            addExtraDataToAccessibilityNodeInfoHelper(i2, accessibilityNodeInfoCompat2, this.ExtraDataTestTraversalBeforeVal, (Bundle) null);
        }
        int orDefault2 = this.idToAfterMap.getOrDefault(i2, -1);
        if (orDefault2 != -1 && (semanticsIdToView = SemanticsUtils_androidKt.semanticsIdToView(this.view.getAndroidViewsHandler$ui_release(), orDefault2)) != null) {
            accessibilityNodeInfoCompat2.setTraversalAfter(semanticsIdToView);
            addExtraDataToAccessibilityNodeInfoHelper(i2, accessibilityNodeInfoCompat2, this.ExtraDataTestTraversalAfterVal, (Bundle) null);
        }
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollForward(ScrollAxisRange scrollAxisRange) {
        if (scrollAxisRange.getValue().invoke().floatValue() >= scrollAxisRange.getMaxValue().invoke().floatValue() || scrollAxisRange.getReverseScrolling()) {
            return scrollAxisRange.getValue().invoke().floatValue() > 0.0f && scrollAxisRange.getReverseScrolling();
        }
        return true;
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollBackward(ScrollAxisRange scrollAxisRange) {
        if (scrollAxisRange.getValue().invoke().floatValue() <= 0.0f || scrollAxisRange.getReverseScrolling()) {
            return scrollAxisRange.getValue().invoke().floatValue() < scrollAxisRange.getMaxValue().invoke().floatValue() && scrollAxisRange.getReverseScrolling();
        }
        return true;
    }

    private final void setContentInvalid(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getError())) {
            accessibilityNodeInfoCompat.setContentInvalid(true);
            accessibilityNodeInfoCompat.setError((CharSequence) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getError()));
        }
    }

    private final String getInfoStateDescriptionOrNull(SemanticsNode semanticsNode) {
        float f;
        Object orNull = SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getStateDescription());
        ToggleableState toggleableState = (ToggleableState) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getToggleableState());
        Role role = (Role) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getRole());
        int i = 0;
        if (toggleableState != null) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[toggleableState.ordinal()];
            if (i2 == 1) {
                if ((role == null ? false : Role.m6363equalsimpl0(role.m6366unboximpl(), Role.Companion.m6372getSwitcho7Vup1c())) && orNull == null) {
                    orNull = this.view.getContext().getResources().getString(R.string.state_on);
                }
            } else if (i2 == 2) {
                if ((role == null ? false : Role.m6363equalsimpl0(role.m6366unboximpl(), Role.Companion.m6372getSwitcho7Vup1c())) && orNull == null) {
                    orNull = this.view.getContext().getResources().getString(R.string.state_off);
                }
            } else if (i2 == 3 && orNull == null) {
                orNull = this.view.getContext().getResources().getString(R.string.indeterminate);
            }
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getSelected());
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            if (!(role == null ? false : Role.m6363equalsimpl0(role.m6366unboximpl(), Role.Companion.m6373getTabo7Vup1c())) && orNull == null) {
                if (booleanValue) {
                    orNull = this.view.getContext().getResources().getString(R.string.selected);
                } else {
                    orNull = this.view.getContext().getResources().getString(R.string.not_selected);
                }
            }
        }
        ProgressBarRangeInfo progressBarRangeInfo = (ProgressBarRangeInfo) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getProgressBarRangeInfo());
        if (progressBarRangeInfo != null) {
            if (progressBarRangeInfo != ProgressBarRangeInfo.Companion.getIndeterminate()) {
                if (orNull == null) {
                    ClosedFloatingPointRange<Float> range = progressBarRangeInfo.getRange();
                    if (range.getEndInclusive().floatValue() - range.getStart().floatValue() == 0.0f) {
                        f = 0.0f;
                    } else {
                        f = (progressBarRangeInfo.getCurrent() - range.getStart().floatValue()) / (range.getEndInclusive().floatValue() - range.getStart().floatValue());
                    }
                    if (f < 0.0f) {
                        f = 0.0f;
                    }
                    if (f > 1.0f) {
                        f = 1.0f;
                    }
                    if (!(f == 0.0f)) {
                        if (f == 1.0f) {
                            i = 1;
                        }
                        if (i != 0) {
                            i = 100;
                        } else {
                            i = RangesKt.coerceIn(Math.round(f * ((float) 100)), 1, 99);
                        }
                    }
                    orNull = this.view.getContext().getResources().getString(R.string.template_percent, new Object[]{Integer.valueOf(i)});
                }
            } else if (orNull == null) {
                orNull = this.view.getContext().getResources().getString(R.string.in_progress);
            }
        }
        if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getEditableText())) {
            orNull = createStateDescriptionForTextField(semanticsNode);
        }
        return (String) orNull;
    }

    private final String createStateDescriptionForTextField(SemanticsNode semanticsNode) {
        SemanticsConfiguration config = semanticsNode.copyWithMergingEnabled$ui_release().getConfig();
        Collection collection = (Collection) SemanticsConfigurationKt.getOrNull(config, SemanticsProperties.INSTANCE.getContentDescription());
        if (collection != null && !collection.isEmpty()) {
            return null;
        }
        Collection collection2 = (Collection) SemanticsConfigurationKt.getOrNull(config, SemanticsProperties.INSTANCE.getText());
        if (collection2 != null && !collection2.isEmpty()) {
            return null;
        }
        CharSequence charSequence = (CharSequence) SemanticsConfigurationKt.getOrNull(config, SemanticsProperties.INSTANCE.getEditableText());
        if (charSequence == null || charSequence.length() == 0) {
            return this.view.getContext().getResources().getString(R.string.state_empty);
        }
        return null;
    }

    private final void setStateDescription(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        accessibilityNodeInfoCompat.setStateDescription(getInfoStateDescriptionOrNull(semanticsNode));
    }

    private final boolean getInfoIsCheckable(SemanticsNode semanticsNode) {
        ToggleableState toggleableState = (ToggleableState) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getToggleableState());
        Role role = (Role) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getRole());
        boolean z = false;
        boolean z2 = toggleableState != null;
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getSelected());
        if (bool != null) {
            bool.booleanValue();
            int r6 = Role.Companion.m6373getTabo7Vup1c();
            if (role != null) {
                z = Role.m6363equalsimpl0(role.m6366unboximpl(), r6);
            }
            if (!z) {
                return true;
            }
        }
        return z2;
    }

    private final void setIsCheckable(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        accessibilityNodeInfoCompat.setCheckable(getInfoIsCheckable(semanticsNode));
    }

    private final AnnotatedString getInfoText(SemanticsNode semanticsNode) {
        AnnotatedString textForTextField = getTextForTextField(semanticsNode.getUnmergedConfig$ui_release());
        List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getText());
        return textForTextField == null ? list != null ? (AnnotatedString) CollectionsKt.firstOrNull(list) : null : textForTextField;
    }

    private final SpannableString toSpannableString(AnnotatedString annotatedString) {
        return (SpannableString) trimToSize(AndroidAccessibilitySpannableString_androidKt.toAccessibilitySpannableString(annotatedString, this.view.getDensity(), this.view.getFontFamilyResolver(), this.urlSpanCache), ParcelSafeTextLength);
    }

    private final void setText(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        AnnotatedString infoText = getInfoText(semanticsNode);
        accessibilityNodeInfoCompat.setText(infoText != null ? toSpannableString(infoText) : null);
    }

    private final boolean isAccessibilityFocused(int i) {
        return this.focusedVirtualViewId == i;
    }

    private final boolean requestAccessibilityFocus(int i) {
        if (!isTouchExplorationEnabled() || isAccessibilityFocused(i)) {
            return false;
        }
        int i2 = this.focusedVirtualViewId;
        if (i2 != Integer.MIN_VALUE) {
            sendEventForVirtualView$default(this, i2, 65536, (Integer) null, (List) null, 12, (Object) null);
        }
        this.focusedVirtualViewId = i;
        this.view.invalidate();
        sendEventForVirtualView$default(this, i, 32768, (Integer) null, (List) null, 12, (Object) null);
        return true;
    }

    static /* synthetic */ boolean sendEventForVirtualView$default(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, int i, int i2, Integer num, List list, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        if ((i3 & 8) != 0) {
            list = null;
        }
        return androidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView(i, i2, num, list);
    }

    private final boolean sendEventForVirtualView(int i, int i2, Integer num, List<String> list) {
        if (i == Integer.MIN_VALUE || !isEnabled$ui_release()) {
            return false;
        }
        AccessibilityEvent createEvent = createEvent(i, i2);
        if (num != null) {
            createEvent.setContentChangeTypes(num.intValue());
        }
        if (list != null) {
            createEvent.setContentDescription(ListUtilsKt.fastJoinToString$default(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        }
        Trace.beginSection("sendEvent");
        try {
            boolean sendEvent = sendEvent(createEvent);
            Trace.endSection();
            return sendEvent;
        } catch (Throwable th) {
            Throwable th2 = th;
            Trace.endSection();
            throw th2;
        }
    }

    private final boolean sendEvent(AccessibilityEvent accessibilityEvent) {
        if (!isEnabled$ui_release()) {
            return false;
        }
        if (accessibilityEvent.getEventType() == 2048 || accessibilityEvent.getEventType() == 32768) {
            this.sendingFocusAffectingEvent = true;
        }
        try {
            return this.onSendAccessibilityEvent.invoke(accessibilityEvent).booleanValue();
        } finally {
            this.sendingFocusAffectingEvent = false;
        }
    }

    private final AccessibilityEvent createEvent(int i, int i2) {
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds;
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        obtain.setEnabled(true);
        obtain.setClassName(ClassName);
        obtain.setPackageName(this.view.getContext().getPackageName());
        obtain.setSource(this.view, i);
        if (isEnabled$ui_release() && (semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(i)) != null) {
            obtain.setPassword(semanticsNodeWithAdjustedBounds.getSemanticsNode().getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getPassword()));
        }
        return obtain;
    }

    private final AccessibilityEvent createTextSelectionChangedEvent(int i, Integer num, Integer num2, Integer num3, CharSequence charSequence) {
        AccessibilityEvent createEvent = createEvent(i, 8192);
        if (num != null) {
            createEvent.setFromIndex(num.intValue());
        }
        if (num2 != null) {
            createEvent.setToIndex(num2.intValue());
        }
        if (num3 != null) {
            createEvent.setItemCount(num3.intValue());
        }
        if (charSequence != null) {
            createEvent.getText().add(charSequence);
        }
        return createEvent;
    }

    private final boolean clearAccessibilityFocus(int i) {
        if (!isAccessibilityFocused(i)) {
            return false;
        }
        this.focusedVirtualViewId = Integer.MIN_VALUE;
        this.currentlyFocusedANI = null;
        this.view.invalidate();
        sendEventForVirtualView$default(this, i, 65536, (Integer) null, (List) null, 12, (Object) null);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v21, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v28, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v41, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v42, resolved type: java.lang.Object} */
    /* JADX WARNING: type inference failed for: r5v30, types: [java.lang.String] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x01cd A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean performActionHelper(int r17, int r18, android.os.Bundle r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            androidx.collection.IntObjectMap r4 = r0.getCurrentSemanticsNodes()
            java.lang.Object r4 = r4.get(r1)
            androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds r4 = (androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds) r4
            r7 = 0
            if (r4 == 0) goto L_0x0707
            androidx.compose.ui.semantics.SemanticsNode r4 = r4.getSemanticsNode()
            if (r4 != 0) goto L_0x001d
            goto L_0x0707
        L_0x001d:
            r5 = 64
            if (r2 == r5) goto L_0x0702
            r5 = 128(0x80, float:1.794E-43)
            if (r2 == r5) goto L_0x06fd
            r5 = 256(0x100, float:3.59E-43)
            r6 = 1
            if (r2 == r5) goto L_0x06e6
            r8 = 512(0x200, float:7.175E-43)
            if (r2 == r8) goto L_0x06e6
            r5 = 16384(0x4000, float:2.2959E-41)
            if (r2 == r5) goto L_0x06c0
            r5 = 131072(0x20000, float:1.83671E-40)
            if (r2 == r5) goto L_0x0695
            boolean r5 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(r4)
            if (r5 != 0) goto L_0x003d
            return r7
        L_0x003d:
            if (r2 == r6) goto L_0x066f
            r5 = 2
            if (r2 == r5) goto L_0x0646
            r5 = 0
            switch(r2) {
                case 16: goto L_0x0613;
                case 32: goto L_0x05ed;
                case 4096: goto L_0x0384;
                case 8192: goto L_0x0384;
                case 32768: goto L_0x035e;
                case 65536: goto L_0x0338;
                case 262144: goto L_0x0312;
                case 524288: goto L_0x02ec;
                case 1048576: goto L_0x02c6;
                case 2097152: goto L_0x028a;
                case 16908342: goto L_0x0193;
                case 16908349: goto L_0x015a;
                case 16908372: goto L_0x0134;
                default: goto L_0x0046;
            }
        L_0x0046:
            switch(r2) {
                case 16908344: goto L_0x0384;
                case 16908345: goto L_0x0384;
                case 16908346: goto L_0x0384;
                case 16908347: goto L_0x0384;
                default: goto L_0x0049;
            }
        L_0x0049:
            switch(r2) {
                case 16908358: goto L_0x010e;
                case 16908359: goto L_0x00e8;
                case 16908360: goto L_0x00c2;
                case 16908361: goto L_0x009c;
                default: goto L_0x004c;
            }
        L_0x004c:
            androidx.collection.SparseArrayCompat<androidx.collection.SparseArrayCompat<java.lang.CharSequence>> r3 = r0.actionIdToLabel
            java.lang.Object r1 = r3.get(r1)
            androidx.collection.SparseArrayCompat r1 = (androidx.collection.SparseArrayCompat) r1
            if (r1 == 0) goto L_0x009b
            java.lang.Object r1 = r1.get(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 != 0) goto L_0x005f
            goto L_0x009b
        L_0x005f:
            androidx.compose.ui.semantics.SemanticsConfiguration r2 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r3 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r3.getCustomActions()
            java.lang.Object r2 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r2, r3)
            java.util.List r2 = (java.util.List) r2
            if (r2 != 0) goto L_0x0072
            return r7
        L_0x0072:
            int r3 = r2.size()
            r4 = r7
        L_0x0077:
            if (r4 >= r3) goto L_0x009b
            java.lang.Object r5 = r2.get(r4)
            androidx.compose.ui.semantics.CustomAccessibilityAction r5 = (androidx.compose.ui.semantics.CustomAccessibilityAction) r5
            java.lang.String r6 = r5.getLabel()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r1)
            if (r6 == 0) goto L_0x0098
            kotlin.jvm.functions.Function0 r1 = r5.getAction()
            java.lang.Object r1 = r1.invoke()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            return r1
        L_0x0098:
            int r4 = r4 + 1
            goto L_0x0077
        L_0x009b:
            return r7
        L_0x009c:
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r2 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getPageRight()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            androidx.compose.ui.semantics.AccessibilityAction r1 = (androidx.compose.ui.semantics.AccessibilityAction) r1
            if (r1 == 0) goto L_0x00c1
            kotlin.Function r1 = r1.getAction()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            if (r1 == 0) goto L_0x00c1
            java.lang.Object r1 = r1.invoke()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            return r1
        L_0x00c1:
            return r7
        L_0x00c2:
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r2 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getPageLeft()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            androidx.compose.ui.semantics.AccessibilityAction r1 = (androidx.compose.ui.semantics.AccessibilityAction) r1
            if (r1 == 0) goto L_0x00e7
            kotlin.Function r1 = r1.getAction()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            if (r1 == 0) goto L_0x00e7
            java.lang.Object r1 = r1.invoke()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            return r1
        L_0x00e7:
            return r7
        L_0x00e8:
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r2 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getPageDown()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            androidx.compose.ui.semantics.AccessibilityAction r1 = (androidx.compose.ui.semantics.AccessibilityAction) r1
            if (r1 == 0) goto L_0x010d
            kotlin.Function r1 = r1.getAction()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            if (r1 == 0) goto L_0x010d
            java.lang.Object r1 = r1.invoke()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            return r1
        L_0x010d:
            return r7
        L_0x010e:
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r2 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getPageUp()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            androidx.compose.ui.semantics.AccessibilityAction r1 = (androidx.compose.ui.semantics.AccessibilityAction) r1
            if (r1 == 0) goto L_0x0133
            kotlin.Function r1 = r1.getAction()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            if (r1 == 0) goto L_0x0133
            java.lang.Object r1 = r1.invoke()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            return r1
        L_0x0133:
            return r7
        L_0x0134:
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r2 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getOnImeAction()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            androidx.compose.ui.semantics.AccessibilityAction r1 = (androidx.compose.ui.semantics.AccessibilityAction) r1
            if (r1 == 0) goto L_0x0159
            kotlin.Function r1 = r1.getAction()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            if (r1 == 0) goto L_0x0159
            java.lang.Object r1 = r1.invoke()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            return r1
        L_0x0159:
            return r7
        L_0x015a:
            if (r3 == 0) goto L_0x0192
            java.lang.String r1 = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"
            boolean r2 = r3.containsKey(r1)
            if (r2 != 0) goto L_0x0165
            goto L_0x0192
        L_0x0165:
            androidx.compose.ui.semantics.SemanticsConfiguration r2 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r4 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r4 = r4.getSetProgress()
            java.lang.Object r2 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r2, r4)
            androidx.compose.ui.semantics.AccessibilityAction r2 = (androidx.compose.ui.semantics.AccessibilityAction) r2
            if (r2 == 0) goto L_0x0192
            kotlin.Function r2 = r2.getAction()
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            if (r2 == 0) goto L_0x0192
            float r1 = r3.getFloat(r1)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            java.lang.Object r1 = r2.invoke(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            return r1
        L_0x0192:
            return r7
        L_0x0193:
            androidx.compose.ui.semantics.SemanticsNode r1 = r4.getParent()
            if (r1 == 0) goto L_0x01ac
            androidx.compose.ui.semantics.SemanticsConfiguration r2 = r1.getUnmergedConfig$ui_release()
            if (r2 == 0) goto L_0x01ac
            androidx.compose.ui.semantics.SemanticsActions r3 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r3.getScrollBy()
            java.lang.Object r2 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r2, r3)
            androidx.compose.ui.semantics.AccessibilityAction r2 = (androidx.compose.ui.semantics.AccessibilityAction) r2
            goto L_0x01ad
        L_0x01ac:
            r2 = r5
        L_0x01ad:
            if (r1 == 0) goto L_0x01cb
            if (r2 == 0) goto L_0x01b2
            goto L_0x01cb
        L_0x01b2:
            androidx.compose.ui.semantics.SemanticsNode r1 = r1.getParent()
            if (r1 == 0) goto L_0x01ac
            androidx.compose.ui.semantics.SemanticsConfiguration r2 = r1.getUnmergedConfig$ui_release()
            if (r2 == 0) goto L_0x01ac
            androidx.compose.ui.semantics.SemanticsActions r3 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r3.getScrollBy()
            java.lang.Object r2 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r2, r3)
            androidx.compose.ui.semantics.AccessibilityAction r2 = (androidx.compose.ui.semantics.AccessibilityAction) r2
            goto L_0x01ad
        L_0x01cb:
            if (r1 != 0) goto L_0x01ce
            return r7
        L_0x01ce:
            androidx.compose.ui.layout.LayoutInfo r3 = r1.getLayoutInfo()
            androidx.compose.ui.layout.LayoutCoordinates r3 = r3.getCoordinates()
            androidx.compose.ui.geometry.Rect r3 = androidx.compose.ui.layout.LayoutCoordinatesKt.boundsInParent(r3)
            androidx.compose.ui.layout.LayoutInfo r5 = r1.getLayoutInfo()
            androidx.compose.ui.layout.LayoutCoordinates r5 = r5.getCoordinates()
            androidx.compose.ui.layout.LayoutCoordinates r5 = r5.getParentLayoutCoordinates()
            if (r5 == 0) goto L_0x01ed
            long r8 = androidx.compose.ui.layout.LayoutCoordinatesKt.positionInRoot(r5)
            goto L_0x01f3
        L_0x01ed:
            androidx.compose.ui.geometry.Offset$Companion r5 = androidx.compose.ui.geometry.Offset.Companion
            long r8 = r5.m4003getZeroF1C5BW0()
        L_0x01f3:
            androidx.compose.ui.geometry.Rect r3 = r3.m4024translatek4lQ0M(r8)
            long r8 = r4.m6375getPositionInRootF1C5BW0()
            long r10 = r4.m6378getSizeYbymL2g()
            long r10 = androidx.compose.ui.unit.IntSizeKt.m7295toSizeozmzZPI(r10)
            androidx.compose.ui.geometry.Rect r5 = androidx.compose.ui.geometry.RectKt.m4027Recttz77jQw(r8, r10)
            androidx.compose.ui.semantics.SemanticsConfiguration r8 = r1.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r9 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r9 = r9.getHorizontalScrollAxisRange()
            java.lang.Object r8 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r8, r9)
            androidx.compose.ui.semantics.ScrollAxisRange r8 = (androidx.compose.ui.semantics.ScrollAxisRange) r8
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r1.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r9 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r9 = r9.getVerticalScrollAxisRange()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r9)
            androidx.compose.ui.semantics.ScrollAxisRange r1 = (androidx.compose.ui.semantics.ScrollAxisRange) r1
            float r9 = r5.getLeft()
            float r10 = r3.getLeft()
            float r9 = r9 - r10
            float r10 = r5.getRight()
            float r11 = r3.getRight()
            float r10 = r10 - r11
            float r9 = performActionHelper$scrollDelta(r9, r10)
            if (r8 == 0) goto L_0x0246
            boolean r8 = r8.getReverseScrolling()
            if (r8 != r6) goto L_0x0246
            float r9 = -r9
        L_0x0246:
            boolean r4 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(r4)
            if (r4 == 0) goto L_0x024d
            float r9 = -r9
        L_0x024d:
            float r4 = r5.getTop()
            float r8 = r3.getTop()
            float r4 = r4 - r8
            float r5 = r5.getBottom()
            float r3 = r3.getBottom()
            float r5 = r5 - r3
            float r3 = performActionHelper$scrollDelta(r4, r5)
            if (r1 == 0) goto L_0x026c
            boolean r1 = r1.getReverseScrolling()
            if (r1 != r6) goto L_0x026c
            float r3 = -r3
        L_0x026c:
            if (r2 == 0) goto L_0x0289
            kotlin.Function r1 = r2.getAction()
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            if (r1 == 0) goto L_0x0289
            java.lang.Float r2 = java.lang.Float.valueOf(r9)
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            java.lang.Object r1 = r1.invoke(r2, r3)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            return r1
        L_0x0289:
            return r7
        L_0x028a:
            if (r3 == 0) goto L_0x0292
            java.lang.String r1 = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE"
            java.lang.String r5 = r3.getString(r1)
        L_0x0292:
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r2 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getSetText()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            androidx.compose.ui.semantics.AccessibilityAction r1 = (androidx.compose.ui.semantics.AccessibilityAction) r1
            if (r1 == 0) goto L_0x02c5
            kotlin.Function r1 = r1.getAction()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            if (r1 == 0) goto L_0x02c5
            androidx.compose.ui.text.AnnotatedString r8 = new androidx.compose.ui.text.AnnotatedString
            if (r5 != 0) goto L_0x02b2
            java.lang.String r5 = ""
        L_0x02b2:
            r9 = r5
            r12 = 6
            r13 = 0
            r10 = 0
            r11 = 0
            r8.<init>(r9, r10, r11, r12, r13)
            java.lang.Object r1 = r1.invoke(r8)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            return r1
        L_0x02c5:
            return r7
        L_0x02c6:
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r2 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getDismiss()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            androidx.compose.ui.semantics.AccessibilityAction r1 = (androidx.compose.ui.semantics.AccessibilityAction) r1
            if (r1 == 0) goto L_0x02eb
            kotlin.Function r1 = r1.getAction()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            if (r1 == 0) goto L_0x02eb
            java.lang.Object r1 = r1.invoke()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            return r1
        L_0x02eb:
            return r7
        L_0x02ec:
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r2 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getCollapse()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            androidx.compose.ui.semantics.AccessibilityAction r1 = (androidx.compose.ui.semantics.AccessibilityAction) r1
            if (r1 == 0) goto L_0x0311
            kotlin.Function r1 = r1.getAction()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            if (r1 == 0) goto L_0x0311
            java.lang.Object r1 = r1.invoke()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            return r1
        L_0x0311:
            return r7
        L_0x0312:
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r2 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getExpand()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            androidx.compose.ui.semantics.AccessibilityAction r1 = (androidx.compose.ui.semantics.AccessibilityAction) r1
            if (r1 == 0) goto L_0x0337
            kotlin.Function r1 = r1.getAction()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            if (r1 == 0) goto L_0x0337
            java.lang.Object r1 = r1.invoke()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            return r1
        L_0x0337:
            return r7
        L_0x0338:
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r2 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getCutText()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            androidx.compose.ui.semantics.AccessibilityAction r1 = (androidx.compose.ui.semantics.AccessibilityAction) r1
            if (r1 == 0) goto L_0x035d
            kotlin.Function r1 = r1.getAction()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            if (r1 == 0) goto L_0x035d
            java.lang.Object r1 = r1.invoke()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            return r1
        L_0x035d:
            return r7
        L_0x035e:
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r2 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getPasteText()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            androidx.compose.ui.semantics.AccessibilityAction r1 = (androidx.compose.ui.semantics.AccessibilityAction) r1
            if (r1 == 0) goto L_0x0383
            kotlin.Function r1 = r1.getAction()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            if (r1 == 0) goto L_0x0383
            java.lang.Object r1 = r1.invoke()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            return r1
        L_0x0383:
            return r7
        L_0x0384:
            r1 = 4096(0x1000, float:5.74E-42)
            if (r2 != r1) goto L_0x038a
            r1 = r6
            goto L_0x038b
        L_0x038a:
            r1 = r7
        L_0x038b:
            r3 = 8192(0x2000, float:1.14794E-41)
            if (r2 != r3) goto L_0x0391
            r3 = r6
            goto L_0x0392
        L_0x0391:
            r3 = r7
        L_0x0392:
            r5 = 16908345(0x1020039, float:2.387739E-38)
            if (r2 != r5) goto L_0x0399
            r5 = r6
            goto L_0x039a
        L_0x0399:
            r5 = r7
        L_0x039a:
            r8 = 16908347(0x102003b, float:2.3877394E-38)
            if (r2 != r8) goto L_0x03a1
            r8 = r6
            goto L_0x03a2
        L_0x03a1:
            r8 = r7
        L_0x03a2:
            r9 = 16908344(0x1020038, float:2.3877386E-38)
            if (r2 != r9) goto L_0x03a9
            r9 = r6
            goto L_0x03aa
        L_0x03a9:
            r9 = r7
        L_0x03aa:
            r10 = 16908346(0x102003a, float:2.3877392E-38)
            if (r2 != r10) goto L_0x03b1
            r2 = r6
            goto L_0x03b2
        L_0x03b1:
            r2 = r7
        L_0x03b2:
            if (r5 != 0) goto L_0x03bd
            if (r8 != 0) goto L_0x03bd
            if (r1 != 0) goto L_0x03bd
            if (r3 == 0) goto L_0x03bb
            goto L_0x03bd
        L_0x03bb:
            r10 = r7
            goto L_0x03be
        L_0x03bd:
            r10 = r6
        L_0x03be:
            if (r9 != 0) goto L_0x03c9
            if (r2 != 0) goto L_0x03c9
            if (r1 != 0) goto L_0x03c9
            if (r3 == 0) goto L_0x03c7
            goto L_0x03c9
        L_0x03c7:
            r2 = r7
            goto L_0x03ca
        L_0x03c9:
            r2 = r6
        L_0x03ca:
            if (r1 != 0) goto L_0x03ce
            if (r3 == 0) goto L_0x0464
        L_0x03ce:
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r11 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r11 = r11.getProgressBarRangeInfo()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r11)
            androidx.compose.ui.semantics.ProgressBarRangeInfo r1 = (androidx.compose.ui.semantics.ProgressBarRangeInfo) r1
            androidx.compose.ui.semantics.SemanticsConfiguration r11 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r12 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r12 = r12.getSetProgress()
            java.lang.Object r11 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r11, r12)
            androidx.compose.ui.semantics.AccessibilityAction r11 = (androidx.compose.ui.semantics.AccessibilityAction) r11
            if (r1 == 0) goto L_0x0464
            if (r11 == 0) goto L_0x0464
            kotlin.ranges.ClosedFloatingPointRange r2 = r1.getRange()
            java.lang.Comparable r2 = r2.getEndInclusive()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            kotlin.ranges.ClosedFloatingPointRange r4 = r1.getRange()
            java.lang.Comparable r4 = r4.getStart()
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            float r2 = kotlin.ranges.RangesKt.coerceAtLeast((float) r2, (float) r4)
            kotlin.ranges.ClosedFloatingPointRange r4 = r1.getRange()
            java.lang.Comparable r4 = r4.getStart()
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            kotlin.ranges.ClosedFloatingPointRange r5 = r1.getRange()
            java.lang.Comparable r5 = r5.getEndInclusive()
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            float r4 = kotlin.ranges.RangesKt.coerceAtMost((float) r4, (float) r5)
            int r5 = r1.getSteps()
            if (r5 <= 0) goto L_0x043f
            float r2 = r2 - r4
            int r4 = r1.getSteps()
            int r4 = r4 + r6
            goto L_0x0442
        L_0x043f:
            float r2 = r2 - r4
            r4 = 20
        L_0x0442:
            float r4 = (float) r4
            float r2 = r2 / r4
            if (r3 == 0) goto L_0x0447
            float r2 = -r2
        L_0x0447:
            kotlin.Function r3 = r11.getAction()
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            if (r3 == 0) goto L_0x0463
            float r1 = r1.getCurrent()
            float r1 = r1 + r2
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            java.lang.Object r1 = r3.invoke(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            return r1
        L_0x0463:
            return r7
        L_0x0464:
            androidx.compose.ui.layout.LayoutInfo r1 = r4.getLayoutInfo()
            androidx.compose.ui.layout.LayoutCoordinates r1 = r1.getCoordinates()
            androidx.compose.ui.geometry.Rect r1 = androidx.compose.ui.layout.LayoutCoordinatesKt.boundsInParent(r1)
            long r11 = r1.m4020getSizeNHjbRc()
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r4.getUnmergedConfig$ui_release()
            java.lang.Float r1 = androidx.compose.ui.platform.SemanticsUtils_androidKt.getScrollViewportLength(r1)
            androidx.compose.ui.semantics.SemanticsConfiguration r6 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r13 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r13 = r13.getScrollBy()
            java.lang.Object r6 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r6, r13)
            androidx.compose.ui.semantics.AccessibilityAction r6 = (androidx.compose.ui.semantics.AccessibilityAction) r6
            if (r6 != 0) goto L_0x048f
            return r7
        L_0x048f:
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r14 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getHorizontalScrollAxisRange()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            androidx.compose.ui.semantics.ScrollAxisRange r13 = (androidx.compose.ui.semantics.ScrollAxisRange) r13
            r14 = 0
            if (r13 == 0) goto L_0x0544
            if (r10 == 0) goto L_0x0544
            if (r1 == 0) goto L_0x04ab
            float r10 = r1.floatValue()
            goto L_0x04af
        L_0x04ab:
            float r10 = androidx.compose.ui.geometry.Size.m4056getWidthimpl(r11)
        L_0x04af:
            if (r5 != 0) goto L_0x04b3
            if (r3 == 0) goto L_0x04b4
        L_0x04b3:
            float r10 = -r10
        L_0x04b4:
            boolean r15 = r13.getReverseScrolling()
            if (r15 == 0) goto L_0x04bb
            float r10 = -r10
        L_0x04bb:
            boolean r15 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(r4)
            if (r15 == 0) goto L_0x04c6
            if (r5 != 0) goto L_0x04c5
            if (r8 == 0) goto L_0x04c6
        L_0x04c5:
            float r10 = -r10
        L_0x04c6:
            boolean r5 = performActionHelper$canScroll(r13, r10)
            if (r5 == 0) goto L_0x0544
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r2 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getPageLeft()
            boolean r1 = r1.contains(r2)
            if (r1 != 0) goto L_0x0509
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r2 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getPageRight()
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L_0x04ed
            goto L_0x0509
        L_0x04ed:
            kotlin.Function r1 = r6.getAction()
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            if (r1 == 0) goto L_0x0508
            java.lang.Float r2 = java.lang.Float.valueOf(r10)
            java.lang.Float r3 = java.lang.Float.valueOf(r14)
            java.lang.Object r1 = r1.invoke(r2, r3)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            return r1
        L_0x0508:
            return r7
        L_0x0509:
            int r1 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r1 <= 0) goto L_0x051e
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r2 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getPageRight()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            androidx.compose.ui.semantics.AccessibilityAction r1 = (androidx.compose.ui.semantics.AccessibilityAction) r1
            goto L_0x052e
        L_0x051e:
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r2 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getPageLeft()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            androidx.compose.ui.semantics.AccessibilityAction r1 = (androidx.compose.ui.semantics.AccessibilityAction) r1
        L_0x052e:
            if (r1 == 0) goto L_0x0543
            kotlin.Function r1 = r1.getAction()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            if (r1 == 0) goto L_0x0543
            java.lang.Object r1 = r1.invoke()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            return r1
        L_0x0543:
            return r7
        L_0x0544:
            androidx.compose.ui.semantics.SemanticsConfiguration r5 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r8 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r8 = r8.getVerticalScrollAxisRange()
            java.lang.Object r5 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r5, r8)
            androidx.compose.ui.semantics.ScrollAxisRange r5 = (androidx.compose.ui.semantics.ScrollAxisRange) r5
            if (r5 == 0) goto L_0x05ec
            if (r2 == 0) goto L_0x05ec
            if (r1 == 0) goto L_0x055f
            float r1 = r1.floatValue()
            goto L_0x0563
        L_0x055f:
            float r1 = androidx.compose.ui.geometry.Size.m4053getHeightimpl(r11)
        L_0x0563:
            if (r9 != 0) goto L_0x0567
            if (r3 == 0) goto L_0x0568
        L_0x0567:
            float r1 = -r1
        L_0x0568:
            boolean r2 = r5.getReverseScrolling()
            if (r2 == 0) goto L_0x056f
            float r1 = -r1
        L_0x056f:
            boolean r2 = performActionHelper$canScroll(r5, r1)
            if (r2 == 0) goto L_0x05ec
            androidx.compose.ui.semantics.SemanticsConfiguration r2 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r3 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r3.getPageUp()
            boolean r2 = r2.contains(r3)
            if (r2 != 0) goto L_0x05b2
            androidx.compose.ui.semantics.SemanticsConfiguration r2 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r3 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r3.getPageDown()
            boolean r2 = r2.contains(r3)
            if (r2 == 0) goto L_0x0596
            goto L_0x05b2
        L_0x0596:
            kotlin.Function r2 = r6.getAction()
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            if (r2 == 0) goto L_0x05b1
            java.lang.Float r3 = java.lang.Float.valueOf(r14)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            java.lang.Object r1 = r2.invoke(r3, r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            return r1
        L_0x05b1:
            return r7
        L_0x05b2:
            int r1 = (r1 > r14 ? 1 : (r1 == r14 ? 0 : -1))
            if (r1 <= 0) goto L_0x05c7
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r2 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getPageDown()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            androidx.compose.ui.semantics.AccessibilityAction r1 = (androidx.compose.ui.semantics.AccessibilityAction) r1
            goto L_0x05d7
        L_0x05c7:
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r2 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getPageUp()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            androidx.compose.ui.semantics.AccessibilityAction r1 = (androidx.compose.ui.semantics.AccessibilityAction) r1
        L_0x05d7:
            if (r1 == 0) goto L_0x05ec
            kotlin.Function r1 = r1.getAction()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            if (r1 == 0) goto L_0x05ec
            java.lang.Object r1 = r1.invoke()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            return r1
        L_0x05ec:
            return r7
        L_0x05ed:
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r2 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getOnLongClick()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            androidx.compose.ui.semantics.AccessibilityAction r1 = (androidx.compose.ui.semantics.AccessibilityAction) r1
            if (r1 == 0) goto L_0x0612
            kotlin.Function r1 = r1.getAction()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            if (r1 == 0) goto L_0x0612
            java.lang.Object r1 = r1.invoke()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            return r1
        L_0x0612:
            return r7
        L_0x0613:
            androidx.compose.ui.semantics.SemanticsConfiguration r2 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r3 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r3.getOnClick()
            java.lang.Object r2 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r2, r3)
            androidx.compose.ui.semantics.AccessibilityAction r2 = (androidx.compose.ui.semantics.AccessibilityAction) r2
            if (r2 == 0) goto L_0x0634
            kotlin.Function r2 = r2.getAction()
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            if (r2 == 0) goto L_0x0634
            java.lang.Object r2 = r2.invoke()
            r5 = r2
            java.lang.Boolean r5 = (java.lang.Boolean) r5
        L_0x0634:
            r8 = r5
            r5 = 12
            r6 = 0
            r2 = 1
            r3 = 0
            r4 = 0
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
            if (r8 == 0) goto L_0x0645
            boolean r1 = r8.booleanValue()
            return r1
        L_0x0645:
            return r7
        L_0x0646:
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getFocused()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r6)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x066e
            androidx.compose.ui.platform.AndroidComposeView r1 = r0.view
            androidx.compose.ui.focus.FocusOwner r1 = r1.getFocusOwner()
            androidx.compose.ui.focus.FocusDirection$Companion r2 = androidx.compose.ui.focus.FocusDirection.Companion
            int r2 = r2.m3900getExitdhqQ8s()
            r1.m3909clearFocusI7lrPNg(r7, r6, r6, r2)
            return r6
        L_0x066e:
            return r7
        L_0x066f:
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r2 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getRequestFocus()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            androidx.compose.ui.semantics.AccessibilityAction r1 = (androidx.compose.ui.semantics.AccessibilityAction) r1
            if (r1 == 0) goto L_0x0694
            kotlin.Function r1 = r1.getAction()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            if (r1 == 0) goto L_0x0694
            java.lang.Object r1 = r1.invoke()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            return r1
        L_0x0694:
            return r7
        L_0x0695:
            r1 = -1
            if (r3 == 0) goto L_0x069f
            java.lang.String r2 = "ACTION_ARGUMENT_SELECTION_START_INT"
            int r2 = r3.getInt(r2, r1)
            goto L_0x06a0
        L_0x069f:
            r2 = r1
        L_0x06a0:
            if (r3 == 0) goto L_0x06a8
            java.lang.String r5 = "ACTION_ARGUMENT_SELECTION_END_INT"
            int r1 = r3.getInt(r5, r1)
        L_0x06a8:
            boolean r7 = r0.setAccessibilitySelection(r4, r2, r1, r7)
            if (r7 == 0) goto L_0x06bf
            int r1 = r4.getId()
            int r1 = r0.semanticsNodeIdToAccessibilityVirtualNodeId(r1)
            r5 = 12
            r6 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
        L_0x06bf:
            return r7
        L_0x06c0:
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r2 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getCopyText()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            androidx.compose.ui.semantics.AccessibilityAction r1 = (androidx.compose.ui.semantics.AccessibilityAction) r1
            if (r1 == 0) goto L_0x06e5
            kotlin.Function r1 = r1.getAction()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            if (r1 == 0) goto L_0x06e5
            java.lang.Object r1 = r1.invoke()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            return r1
        L_0x06e5:
            return r7
        L_0x06e6:
            if (r3 == 0) goto L_0x06fc
            java.lang.String r1 = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT"
            int r1 = r3.getInt(r1)
            java.lang.String r8 = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN"
            boolean r3 = r3.getBoolean(r8)
            if (r2 != r5) goto L_0x06f7
            r7 = r6
        L_0x06f7:
            boolean r1 = r0.traverseAtGranularity(r4, r1, r7, r3)
            return r1
        L_0x06fc:
            return r7
        L_0x06fd:
            boolean r1 = r16.clearAccessibilityFocus(r17)
            return r1
        L_0x0702:
            boolean r1 = r16.requestAccessibilityFocus(r17)
            return r1
        L_0x0707:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.performActionHelper(int, int, android.os.Bundle):boolean");
    }

    private static final boolean performActionHelper$canScroll(ScrollAxisRange scrollAxisRange, float f) {
        if (f >= 0.0f || scrollAxisRange.getValue().invoke().floatValue() <= 0.0f) {
            return f > 0.0f && scrollAxisRange.getValue().invoke().floatValue() < scrollAxisRange.getMaxValue().invoke().floatValue();
        }
        return true;
    }

    private static final float performActionHelper$scrollDelta(float f, float f2) {
        if (Math.signum(f) == Math.signum(f2)) {
            return Math.abs(f) < Math.abs(f2) ? f : f2;
        }
        return 0.0f;
    }

    /* access modifiers changed from: private */
    public final void addExtraDataToAccessibilityNodeInfoHelper(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, String str, Bundle bundle) {
        SemanticsNode semanticsNode;
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(i);
        if (semanticsNodeWithAdjustedBounds != null && (semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode()) != null) {
            String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
            if (Intrinsics.areEqual((Object) str, (Object) this.ExtraDataTestTraversalBeforeVal)) {
                int orDefault = this.idToBeforeMap.getOrDefault(i, -1);
                if (orDefault != -1) {
                    accessibilityNodeInfoCompat.getExtras().putInt(str, orDefault);
                }
            } else if (Intrinsics.areEqual((Object) str, (Object) this.ExtraDataTestTraversalAfterVal)) {
                int orDefault2 = this.idToAfterMap.getOrDefault(i, -1);
                if (orDefault2 != -1) {
                    accessibilityNodeInfoCompat.getExtras().putInt(str, orDefault2);
                }
            } else if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult()) && bundle != null && Intrinsics.areEqual((Object) str, (Object) "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY")) {
                int i2 = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX", -1);
                int i3 = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH", -1);
                if (i3 > 0 && i2 >= 0) {
                    if (i2 < (iterableTextForAccessibility != null ? iterableTextForAccessibility.length() : Integer.MAX_VALUE)) {
                        TextLayoutResult textLayoutResult = SemanticsUtils_androidKt.getTextLayoutResult(semanticsNode.getUnmergedConfig$ui_release());
                        if (textLayoutResult != null) {
                            List arrayList = new ArrayList();
                            for (int i4 = 0; i4 < i3; i4++) {
                                int i5 = i2 + i4;
                                if (i5 >= textLayoutResult.getLayoutInput().getText().length()) {
                                    arrayList.add((Object) null);
                                } else {
                                    arrayList.add(toScreenCoords(semanticsNode, textLayoutResult.getBoundingBox(i5)));
                                }
                            }
                            accessibilityNodeInfoCompat.getExtras().putParcelableArray(str, (Parcelable[]) arrayList.toArray(new RectF[0]));
                            return;
                        }
                        return;
                    }
                }
                Log.e(LogTag, "Invalid arguments for accessibility character locations");
            } else if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getTestTag()) && bundle != null && Intrinsics.areEqual((Object) str, (Object) ExtraDataTestTagKey)) {
                String str2 = (String) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getTestTag());
                if (str2 != null) {
                    accessibilityNodeInfoCompat.getExtras().putCharSequence(str, str2);
                }
            } else if (Intrinsics.areEqual((Object) str, (Object) ExtraDataIdKey)) {
                accessibilityNodeInfoCompat.getExtras().putInt(str, semanticsNode.getId());
            }
        }
    }

    private final RectF toScreenCoords(SemanticsNode semanticsNode, androidx.compose.ui.geometry.Rect rect) {
        if (semanticsNode == null) {
            return null;
        }
        androidx.compose.ui.geometry.Rect r6 = rect.m4024translatek4lQ0M(semanticsNode.m6375getPositionInRootF1C5BW0());
        androidx.compose.ui.geometry.Rect boundsInRoot = semanticsNode.getBoundsInRoot();
        androidx.compose.ui.geometry.Rect intersect = r6.overlaps(boundsInRoot) ? r6.intersect(boundsInRoot) : null;
        if (intersect == null) {
            return null;
        }
        long r0 = this.view.m6237localToScreenMKHz9U(OffsetKt.Offset(intersect.getLeft(), intersect.getTop()));
        long r5 = this.view.m6237localToScreenMKHz9U(OffsetKt.Offset(intersect.getRight(), intersect.getBottom()));
        return new RectF(Offset.m3987getXimpl(r0), Offset.m3988getYimpl(r0), Offset.m3987getXimpl(r5), Offset.m3988getYimpl(r5));
    }

    public final boolean dispatchHoverEvent$ui_release(MotionEvent motionEvent) {
        if (!isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int hitTestSemanticsAt$ui_release = hitTestSemanticsAt$ui_release(motionEvent.getX(), motionEvent.getY());
            boolean dispatchGenericMotionEvent = this.view.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(motionEvent);
            updateHoveredVirtualView(hitTestSemanticsAt$ui_release);
            if (hitTestSemanticsAt$ui_release == Integer.MIN_VALUE) {
                return dispatchGenericMotionEvent;
            }
            return true;
        } else if (action != 10) {
            return false;
        } else {
            if (this.hoveredVirtualViewId == Integer.MIN_VALUE) {
                return this.view.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(motionEvent);
            }
            updateHoveredVirtualView(Integer.MIN_VALUE);
            return true;
        }
    }

    public final int hitTestSemanticsAt$ui_release(float f, float f2) {
        NodeChain nodes$ui_release;
        LayoutNode layoutNode = null;
        Owner.measureAndLayout$default(this.view, false, 1, (Object) null);
        HitTestResult hitTestResult = new HitTestResult();
        LayoutNode.m5994hitTestSemanticsM_7yMNQ$ui_release$default(this.view.getRoot(), OffsetKt.Offset(f, f2), hitTestResult, false, false, 12, (Object) null);
        Modifier.Node node = (Modifier.Node) CollectionsKt.lastOrNull(hitTestResult);
        if (node != null) {
            layoutNode = DelegatableNodeKt.requireLayoutNode(node);
        }
        if (layoutNode == null || (nodes$ui_release = layoutNode.getNodes$ui_release()) == null || !nodes$ui_release.m6082hasH91voCI$ui_release(NodeKind.m6139constructorimpl(8)) || !AndroidComposeViewAccessibilityDelegateCompat_androidKt.isVisible(SemanticsNodeKt.SemanticsNode(layoutNode, false)) || this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(layoutNode) != null) {
            return Integer.MIN_VALUE;
        }
        return semanticsNodeIdToAccessibilityVirtualNodeId(layoutNode.getSemanticsId());
    }

    private final void updateHoveredVirtualView(int i) {
        int i2 = this.hoveredVirtualViewId;
        if (i2 != i) {
            this.hoveredVirtualViewId = i;
            sendEventForVirtualView$default(this, i, 128, (Integer) null, (List) null, 12, (Object) null);
            sendEventForVirtualView$default(this, i2, 256, (Integer) null, (List) null, 12, (Object) null);
        }
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view2) {
        return this.nodeProvider;
    }

    private final <T extends CharSequence> T trimToSize(T t, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("size should be greater than 0".toString());
        } else if (t == null || t.length() == 0 || t.length() <= i) {
            return t;
        } else {
            int i2 = i - 1;
            if (Character.isHighSurrogate(t.charAt(i2)) && Character.isLowSurrogate(t.charAt(i))) {
                i = i2;
            }
            T subSequence = t.subSequence(0, i);
            Intrinsics.checkNotNull(subSequence, "null cannot be cast to non-null type T of androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.trimToSize");
            return subSequence;
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public static final void semanticsChangeChecker$lambda$49(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat) {
        Trace.beginSection("measureAndLayout");
        try {
            Owner.measureAndLayout$default(androidComposeViewAccessibilityDelegateCompat.view, false, 1, (Object) null);
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
            Trace.beginSection("checkForSemanticsChanges");
            try {
                androidComposeViewAccessibilityDelegateCompat.checkForSemanticsChanges();
                Unit unit2 = Unit.INSTANCE;
                Trace.endSection();
                androidComposeViewAccessibilityDelegateCompat.checkingForSemanticsChanges = false;
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        } catch (Throwable th2) {
            Trace.endSection();
            throw th2;
        }
    }

    public final void onSemanticsChange$ui_release() {
        this.currentSemanticsNodesInvalidated = true;
        if (isEnabled$ui_release() && !this.checkingForSemanticsChanges) {
            this.checkingForSemanticsChanges = true;
            this.handler.post(this.semanticsChangeChecker);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d0, code lost:
        if (kotlinx.coroutines.DelayKt.delay(r8, r0) == r1) goto L_0x00d2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0075 A[Catch:{ all -> 0x0053 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0080 A[Catch:{ all -> 0x0053 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object boundsUpdatesEventLoop$ui_release(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1 r0 = (androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1 r0 = new androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1
            r0.<init>(r11, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0056
            if (r2 == r5) goto L_0x0043
            if (r2 != r4) goto L_0x003b
            java.lang.Object r2 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r6 = r0.L$1
            androidx.collection.MutableIntSet r6 = (androidx.collection.MutableIntSet) r6
            java.lang.Object r7 = r0.L$0
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r7 = (androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat) r7
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0053 }
            goto L_0x00d3
        L_0x003b:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0043:
            java.lang.Object r2 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r6 = r0.L$1
            androidx.collection.MutableIntSet r6 = (androidx.collection.MutableIntSet) r6
            java.lang.Object r7 = r0.L$0
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r7 = (androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat) r7
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0053 }
            goto L_0x0078
        L_0x0053:
            r12 = move-exception
            goto L_0x00df
        L_0x0056:
            kotlin.ResultKt.throwOnFailure(r12)
            androidx.collection.MutableIntSet r12 = new androidx.collection.MutableIntSet     // Catch:{ all -> 0x00dd }
            r2 = 0
            r12.<init>(r3, r5, r2)     // Catch:{ all -> 0x00dd }
            kotlinx.coroutines.channels.Channel<kotlin.Unit> r2 = r11.boundsUpdateChannel     // Catch:{ all -> 0x00dd }
            kotlinx.coroutines.channels.ChannelIterator r2 = r2.iterator()     // Catch:{ all -> 0x00dd }
            r7 = r11
        L_0x0066:
            r0.L$0 = r7     // Catch:{ all -> 0x0053 }
            r0.L$1 = r12     // Catch:{ all -> 0x0053 }
            r0.L$2 = r2     // Catch:{ all -> 0x0053 }
            r0.label = r5     // Catch:{ all -> 0x0053 }
            java.lang.Object r6 = r2.hasNext(r0)     // Catch:{ all -> 0x0053 }
            if (r6 != r1) goto L_0x0075
            goto L_0x00d2
        L_0x0075:
            r10 = r6
            r6 = r12
            r12 = r10
        L_0x0078:
            java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch:{ all -> 0x0053 }
            boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x0053 }
            if (r12 == 0) goto L_0x00d5
            r2.next()     // Catch:{ all -> 0x0053 }
            boolean r12 = r7.isEnabled$ui_release()     // Catch:{ all -> 0x0053 }
            if (r12 == 0) goto L_0x00d3
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r12 = r7.subtreeChangedLayoutNodes     // Catch:{ all -> 0x0053 }
            int r12 = r12.size()     // Catch:{ all -> 0x0053 }
            r8 = r3
        L_0x0090:
            if (r8 >= r12) goto L_0x00a3
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r9 = r7.subtreeChangedLayoutNodes     // Catch:{ all -> 0x0053 }
            java.lang.Object r9 = r9.valueAt(r8)     // Catch:{ all -> 0x0053 }
            androidx.compose.ui.node.LayoutNode r9 = (androidx.compose.ui.node.LayoutNode) r9     // Catch:{ all -> 0x0053 }
            r7.sendSubtreeChangeAccessibilityEvents(r9, r6)     // Catch:{ all -> 0x0053 }
            r7.sendTypeViewScrolledAccessibilityEvent(r9)     // Catch:{ all -> 0x0053 }
            int r8 = r8 + 1
            goto L_0x0090
        L_0x00a3:
            r6.clear()     // Catch:{ all -> 0x0053 }
            boolean r12 = r7.checkingForSemanticsChanges     // Catch:{ all -> 0x0053 }
            if (r12 != 0) goto L_0x00b3
            r7.checkingForSemanticsChanges = r5     // Catch:{ all -> 0x0053 }
            android.os.Handler r12 = r7.handler     // Catch:{ all -> 0x0053 }
            java.lang.Runnable r8 = r7.semanticsChangeChecker     // Catch:{ all -> 0x0053 }
            r12.post(r8)     // Catch:{ all -> 0x0053 }
        L_0x00b3:
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r12 = r7.subtreeChangedLayoutNodes     // Catch:{ all -> 0x0053 }
            r12.clear()     // Catch:{ all -> 0x0053 }
            androidx.collection.MutableIntObjectMap<androidx.compose.ui.semantics.ScrollAxisRange> r12 = r7.pendingHorizontalScrollEvents     // Catch:{ all -> 0x0053 }
            r12.clear()     // Catch:{ all -> 0x0053 }
            androidx.collection.MutableIntObjectMap<androidx.compose.ui.semantics.ScrollAxisRange> r12 = r7.pendingVerticalScrollEvents     // Catch:{ all -> 0x0053 }
            r12.clear()     // Catch:{ all -> 0x0053 }
            long r8 = r7.SendRecurringAccessibilityEventsIntervalMillis     // Catch:{ all -> 0x0053 }
            r0.L$0 = r7     // Catch:{ all -> 0x0053 }
            r0.L$1 = r6     // Catch:{ all -> 0x0053 }
            r0.L$2 = r2     // Catch:{ all -> 0x0053 }
            r0.label = r4     // Catch:{ all -> 0x0053 }
            java.lang.Object r12 = kotlinx.coroutines.DelayKt.delay(r8, r0)     // Catch:{ all -> 0x0053 }
            if (r12 != r1) goto L_0x00d3
        L_0x00d2:
            return r1
        L_0x00d3:
            r12 = r6
            goto L_0x0066
        L_0x00d5:
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r12 = r7.subtreeChangedLayoutNodes
            r12.clear()
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x00dd:
            r12 = move-exception
            r7 = r11
        L_0x00df:
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r0 = r7.subtreeChangedLayoutNodes
            r0.clear()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.boundsUpdatesEventLoop$ui_release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void onLayoutChange$ui_release(LayoutNode layoutNode) {
        this.currentSemanticsNodesInvalidated = true;
        if (isEnabled$ui_release()) {
            notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
        }
    }

    /* access modifiers changed from: private */
    public final void notifySubtreeAccessibilityStateChangedIfNeeded(LayoutNode layoutNode) {
        if (this.subtreeChangedLayoutNodes.add(layoutNode)) {
            this.boundsUpdateChannel.m9382trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    private final void sendTypeViewScrolledAccessibilityEvent(LayoutNode layoutNode) {
        if (layoutNode.isAttached() && !this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(layoutNode)) {
            int semanticsId = layoutNode.getSemanticsId();
            ScrollAxisRange scrollAxisRange = this.pendingHorizontalScrollEvents.get(semanticsId);
            ScrollAxisRange scrollAxisRange2 = this.pendingVerticalScrollEvents.get(semanticsId);
            if (scrollAxisRange != null || scrollAxisRange2 != null) {
                AccessibilityEvent createEvent = createEvent(semanticsId, 4096);
                if (scrollAxisRange != null) {
                    createEvent.setScrollX((int) scrollAxisRange.getValue().invoke().floatValue());
                    createEvent.setMaxScrollX((int) scrollAxisRange.getMaxValue().invoke().floatValue());
                }
                if (scrollAxisRange2 != null) {
                    createEvent.setScrollY((int) scrollAxisRange2.getValue().invoke().floatValue());
                    createEvent.setMaxScrollY((int) scrollAxisRange2.getMaxValue().invoke().floatValue());
                }
                sendEvent(createEvent);
            }
        }
    }

    private final void sendSubtreeChangeAccessibilityEvents(LayoutNode layoutNode, MutableIntSet mutableIntSet) {
        SemanticsConfiguration collapsedSemantics$ui_release;
        LayoutNode access$findClosestParentNode;
        if (layoutNode.isAttached() && !this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(layoutNode)) {
            if (!layoutNode.getNodes$ui_release().m6082hasH91voCI$ui_release(NodeKind.m6139constructorimpl(8))) {
                layoutNode = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(layoutNode, AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1.INSTANCE);
            }
            if (layoutNode != null && (collapsedSemantics$ui_release = layoutNode.getCollapsedSemantics$ui_release()) != null) {
                if (!collapsedSemantics$ui_release.isMergingSemanticsOfDescendants() && (access$findClosestParentNode = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(layoutNode, AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.INSTANCE)) != null) {
                    layoutNode = access$findClosestParentNode;
                }
                if (layoutNode != null) {
                    int semanticsId = layoutNode.getSemanticsId();
                    if (mutableIntSet.add(semanticsId)) {
                        sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(semanticsId), 2048, 1, (List) null, 8, (Object) null);
                    }
                }
            }
        }
    }

    /* JADX INFO: finally extract failed */
    private final void checkForSemanticsChanges() {
        Trace.beginSection("sendAccessibilitySemanticsStructureChangeEvents");
        try {
            if (isEnabled$ui_release()) {
                sendAccessibilitySemanticsStructureChangeEvents(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), this.previousSemanticsRoot);
            }
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
            Trace.beginSection("sendSemanticsPropertyChangeEvents");
            try {
                sendSemanticsPropertyChangeEvents(getCurrentSemanticsNodes());
                Unit unit2 = Unit.INSTANCE;
                Trace.endSection();
                Trace.beginSection("updateSemanticsNodesCopyAndPanes");
                try {
                    updateSemanticsNodesCopyAndPanes();
                    Unit unit3 = Unit.INSTANCE;
                } finally {
                    Trace.endSection();
                }
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        } catch (Throwable th2) {
            Trace.endSection();
            throw th2;
        }
    }

    private final void updateSemanticsNodesCopyAndPanes() {
        long j;
        long j2;
        long j3;
        long j4;
        SemanticsConfiguration unmergedConfig;
        MutableIntSet mutableIntSet = new MutableIntSet(0, 1, (DefaultConstructorMarker) null);
        IntSet intSet = this.paneDisplayed;
        int[] iArr = intSet.elements;
        long[] jArr = intSet.metadata;
        int length = jArr.length - 2;
        long j5 = 128;
        long j6 = 255;
        char c = 7;
        long j7 = -9187201950435737472L;
        if (length >= 0) {
            int i = 0;
            long[] jArr2 = jArr;
            while (true) {
                long j8 = jArr2[i];
                int[] iArr2 = iArr;
                if ((((~j8) << 7) & j8 & -9187201950435737472L) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    int i3 = 0;
                    while (i3 < i2) {
                        if ((j8 & j6) < j5) {
                            j4 = j5;
                            int i4 = iArr2[(i << 3) + i3];
                            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(i4);
                            SemanticsNode semanticsNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
                            if (semanticsNode != null) {
                                j3 = j6;
                                if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getPaneTitle())) {
                                }
                            } else {
                                j3 = j6;
                            }
                            mutableIntSet.add(i4);
                            SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(i4);
                            sendPaneChangeEvents(i4, 32, (semanticsNodeCopy == null || (unmergedConfig = semanticsNodeCopy.getUnmergedConfig()) == null) ? null : (String) SemanticsConfigurationKt.getOrNull(unmergedConfig, SemanticsProperties.INSTANCE.getPaneTitle()));
                        } else {
                            j4 = j5;
                            j3 = j6;
                        }
                        j8 >>= 8;
                        i3++;
                        j5 = j4;
                        j6 = j3;
                    }
                    j2 = j5;
                    j = j6;
                    if (i2 != 8) {
                        break;
                    }
                } else {
                    j2 = j5;
                    j = j6;
                }
                if (i == length) {
                    break;
                }
                i++;
                iArr = iArr2;
                j5 = j2;
                j6 = j;
            }
        } else {
            j2 = 128;
            j = 255;
        }
        this.paneDisplayed.removeAll((IntSet) mutableIntSet);
        this.previousSemanticsNodes.clear();
        IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes2 = getCurrentSemanticsNodes();
        int[] iArr3 = currentSemanticsNodes2.keys;
        Object[] objArr = currentSemanticsNodes2.values;
        long[] jArr3 = currentSemanticsNodes2.metadata;
        int length2 = jArr3.length - 2;
        if (length2 >= 0) {
            int i5 = 0;
            while (true) {
                long j9 = jArr3[i5];
                if ((((~j9) << c) & j9 & j7) != j7) {
                    int i6 = 8 - ((~(i5 - length2)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((j9 & j) < j2) {
                            int i8 = (i5 << 3) + i7;
                            int i9 = iArr3[i8];
                            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds2 = (SemanticsNodeWithAdjustedBounds) objArr[i8];
                            if (semanticsNodeWithAdjustedBounds2.getSemanticsNode().getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getPaneTitle()) && this.paneDisplayed.add(i9)) {
                                sendPaneChangeEvents(i9, 16, (String) semanticsNodeWithAdjustedBounds2.getSemanticsNode().getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getPaneTitle()));
                            }
                            this.previousSemanticsNodes.set(i9, new SemanticsNodeCopy(semanticsNodeWithAdjustedBounds2.getSemanticsNode(), getCurrentSemanticsNodes()));
                        }
                        j9 >>= 8;
                    }
                    if (i6 != 8) {
                        break;
                    }
                }
                if (i5 == length2) {
                    break;
                }
                i5++;
                c = 7;
                j7 = -9187201950435737472L;
            }
        }
        this.previousSemanticsRoot = new SemanticsNodeCopy(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), getCurrentSemanticsNodes());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:154:0x058e, code lost:
        if (r1.containsAll(r3) != false) goto L_0x0591;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x05df, code lost:
        if (androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$accessibilityEquals((androidx.compose.ui.semantics.AccessibilityAction) r1, androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r18.getUnmergedConfig(), (androidx.compose.ui.semantics.SemanticsPropertyKey) r5.getKey())) == false) goto L_0x0594;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00d0, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r5.getValue(), androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r18.getUnmergedConfig(), (androidx.compose.ui.semantics.SemanticsPropertyKey) r5.getKey())) != false) goto L_0x0105;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void sendSemanticsPropertyChangeEvents(androidx.collection.IntObjectMap<androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds> r37) {
        /*
            r36 = this;
            r0 = r36
            r7 = r37
            java.util.ArrayList r8 = new java.util.ArrayList
            java.util.List<androidx.compose.ui.platform.ScrollObservationScope> r1 = r0.scrollObservationScopes
            java.util.Collection r1 = (java.util.Collection) r1
            r8.<init>(r1)
            java.util.List<androidx.compose.ui.platform.ScrollObservationScope> r1 = r0.scrollObservationScopes
            r1.clear()
            int[] r9 = r7.keys
            long[] r10 = r7.metadata
            int r1 = r10.length
            r11 = 2
            int r12 = r1 + -2
            if (r12 < 0) goto L_0x0648
            r14 = 0
        L_0x001d:
            r1 = r10[r14]
            long r3 = ~r1
            r5 = 7
            long r3 = r3 << r5
            long r3 = r3 & r1
            r5 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r3 = r3 & r5
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x0638
            int r3 = r14 - r12
            int r3 = ~r3
            int r3 = r3 >>> 31
            r15 = 8
            int r3 = 8 - r3
            r16 = r1
            r1 = 0
        L_0x0039:
            if (r1 >= r3) goto L_0x062f
            r4 = 255(0xff, double:1.26E-321)
            long r4 = r16 & r4
            r18 = 128(0x80, double:6.32E-322)
            int r2 = (r4 > r18 ? 1 : (r4 == r18 ? 0 : -1))
            if (r2 >= 0) goto L_0x0619
            int r2 = r14 << 3
            int r2 = r2 + r1
            r2 = r9[r2]
            androidx.collection.MutableIntObjectMap<androidx.compose.ui.platform.SemanticsNodeCopy> r4 = r0.previousSemanticsNodes
            java.lang.Object r4 = r4.get(r2)
            r18 = r4
            androidx.compose.ui.platform.SemanticsNodeCopy r18 = (androidx.compose.ui.platform.SemanticsNodeCopy) r18
            if (r18 != 0) goto L_0x005f
            r25 = r1
            r23 = r11
            r24 = 0
            r11 = r3
            goto L_0x060b
        L_0x005f:
            java.lang.Object r4 = r7.get(r2)
            androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds r4 = (androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds) r4
            r19 = 0
            if (r4 == 0) goto L_0x006e
            androidx.compose.ui.semantics.SemanticsNode r4 = r4.getSemanticsNode()
            goto L_0x0070
        L_0x006e:
            r4 = r19
        L_0x0070:
            if (r4 == 0) goto L_0x060e
            androidx.compose.ui.semantics.SemanticsConfiguration r5 = r4.getUnmergedConfig$ui_release()
            java.util.Iterator r20 = r5.iterator()
            r21 = 0
        L_0x007c:
            boolean r5 = r20.hasNext()
            if (r5 == 0) goto L_0x05e2
            java.lang.Object r5 = r20.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r6 = r5.getKey()
            androidx.compose.ui.semantics.SemanticsProperties r22 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            r23 = r11
            androidx.compose.ui.semantics.SemanticsPropertyKey r11 = r22.getHorizontalScrollAxisRange()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r11)
            if (r6 != 0) goto L_0x00ad
            java.lang.Object r6 = r5.getKey()
            androidx.compose.ui.semantics.SemanticsProperties r11 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r11 = r11.getVerticalScrollAxisRange()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r11)
            if (r6 == 0) goto L_0x00ab
            goto L_0x00ad
        L_0x00ab:
            r6 = 0
            goto L_0x00b4
        L_0x00ad:
            r6 = r8
            java.util.List r6 = (java.util.List) r6
            boolean r6 = r0.registerScrollingId(r2, r6)
        L_0x00b4:
            if (r6 != 0) goto L_0x00d3
            java.lang.Object r6 = r5.getValue()
            androidx.compose.ui.semantics.SemanticsConfiguration r11 = r18.getUnmergedConfig()
            java.lang.Object r22 = r5.getKey()
            r24 = 0
            r13 = r22
            androidx.compose.ui.semantics.SemanticsPropertyKey r13 = (androidx.compose.ui.semantics.SemanticsPropertyKey) r13
            java.lang.Object r11 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r11, r13)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r11)
            if (r6 == 0) goto L_0x00d5
            goto L_0x0105
        L_0x00d3:
            r24 = 0
        L_0x00d5:
            java.lang.Object r6 = r5.getKey()
            androidx.compose.ui.semantics.SemanticsPropertyKey r6 = (androidx.compose.ui.semantics.SemanticsPropertyKey) r6
            androidx.compose.ui.semantics.SemanticsProperties r11 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r11 = r11.getPaneTitle()
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r11)
            if (r11 == 0) goto L_0x010d
            java.lang.Object r5 = r5.getValue()
            java.lang.String r6 = "null cannot be cast to non-null type kotlin.String"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5, r6)
            java.lang.String r5 = (java.lang.String) r5
            androidx.compose.ui.semantics.SemanticsConfiguration r6 = r18.getUnmergedConfig()
            androidx.compose.ui.semantics.SemanticsProperties r11 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r11 = r11.getPaneTitle()
            boolean r6 = r6.contains(r11)
            if (r6 == 0) goto L_0x0105
            r0.sendPaneChangeEvents(r2, r15, r5)
        L_0x0105:
            r25 = r1
            r7 = r2
            r11 = r3
            r26 = r4
            goto L_0x05ac
        L_0x010d:
            androidx.compose.ui.semantics.SemanticsProperties r11 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r11 = r11.getStateDescription()
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r11)
            r13 = 1
            if (r11 == 0) goto L_0x011c
            r11 = r13
            goto L_0x0126
        L_0x011c:
            androidx.compose.ui.semantics.SemanticsProperties r11 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r11 = r11.getToggleableState()
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r11)
        L_0x0126:
            r22 = 64
            if (r11 == 0) goto L_0x0158
            r11 = r1
            int r1 = r0.semanticsNodeIdToAccessibilityVirtualNodeId(r2)
            r5 = r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r22)
            r6 = r5
            r5 = 8
            r13 = r6
            r6 = 0
            r22 = r2
            r2 = 2048(0x800, float:2.87E-42)
            r25 = r4
            r4 = 0
            r26 = r25
            r25 = r11
            r11 = r13
            r13 = r22
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
            int r1 = r0.semanticsNodeIdToAccessibilityVirtualNodeId(r13)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r24)
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
        L_0x0155:
            r7 = r13
            goto L_0x05ac
        L_0x0158:
            r25 = r1
            r1 = r2
            r11 = r3
            r26 = r4
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getProgressBarRangeInfo()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x018c
            r2 = r1
            int r1 = r0.semanticsNodeIdToAccessibilityVirtualNodeId(r2)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r22)
            r5 = 8
            r6 = 0
            r22 = r2
            r2 = 2048(0x800, float:2.87E-42)
            r4 = 0
            r13 = r22
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
            int r1 = r0.semanticsNodeIdToAccessibilityVirtualNodeId(r13)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r24)
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x0155
        L_0x018c:
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getSelected()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r2)
            r3 = 4
            if (r2 == 0) goto L_0x028d
            androidx.compose.ui.semantics.SemanticsConfiguration r2 = r26.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r4 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r4 = r4.getRole()
            java.lang.Object r2 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r2, r4)
            androidx.compose.ui.semantics.Role r2 = (androidx.compose.ui.semantics.Role) r2
            androidx.compose.ui.semantics.Role$Companion r4 = androidx.compose.ui.semantics.Role.Companion
            int r4 = r4.m6373getTabo7Vup1c()
            if (r2 != 0) goto L_0x01b4
            r2 = r24
            goto L_0x01bc
        L_0x01b4:
            int r2 = r2.m6366unboximpl()
            boolean r2 = androidx.compose.ui.semantics.Role.m6363equalsimpl0(r2, r4)
        L_0x01bc:
            if (r2 == 0) goto L_0x026e
            androidx.compose.ui.semantics.SemanticsConfiguration r2 = r26.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r4 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r4 = r4.getSelected()
            java.lang.Object r2 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r2, r4)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r13)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)
            if (r2 == 0) goto L_0x025a
            int r2 = r0.semanticsNodeIdToAccessibilityVirtualNodeId(r1)
            android.view.accessibility.AccessibilityEvent r2 = r0.createEvent(r2, r3)
            androidx.compose.ui.semantics.SemanticsNode r3 = r26.copyWithMergingEnabled$ui_release()
            androidx.compose.ui.semantics.SemanticsConfiguration r4 = r3.getConfig()
            androidx.compose.ui.semantics.SemanticsProperties r5 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r5 = r5.getContentDescription()
            java.lang.Object r4 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r4, r5)
            r27 = r4
            java.util.List r27 = (java.util.List) r27
            java.lang.String r4 = ","
            if (r27 == 0) goto L_0x020f
            r28 = r4
            java.lang.CharSequence r28 = (java.lang.CharSequence) r28
            r34 = 62
            r35 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            java.lang.String r5 = androidx.compose.ui.util.ListUtilsKt.fastJoinToString$default(r27, r28, r29, r30, r31, r32, r33, r34, r35)
            goto L_0x0211
        L_0x020f:
            r5 = r19
        L_0x0211:
            androidx.compose.ui.semantics.SemanticsConfiguration r3 = r3.getConfig()
            androidx.compose.ui.semantics.SemanticsProperties r6 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r6 = r6.getText()
            java.lang.Object r3 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r3, r6)
            r27 = r3
            java.util.List r27 = (java.util.List) r27
            if (r27 == 0) goto L_0x023c
            r28 = r4
            java.lang.CharSequence r28 = (java.lang.CharSequence) r28
            r34 = 62
            r35 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            java.lang.String r3 = androidx.compose.ui.util.ListUtilsKt.fastJoinToString$default(r27, r28, r29, r30, r31, r32, r33, r34, r35)
            goto L_0x023e
        L_0x023c:
            r3 = r19
        L_0x023e:
            if (r5 == 0) goto L_0x0249
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r2.setContentDescription(r5)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
        L_0x0249:
            if (r3 == 0) goto L_0x0256
            java.util.List r4 = r2.getText()
            boolean r3 = r4.add(r3)
            java.lang.Boolean.valueOf(r3)
        L_0x0256:
            r0.sendEvent(r2)
            goto L_0x02b1
        L_0x025a:
            r13 = r1
            int r1 = r0.semanticsNodeIdToAccessibilityVirtualNodeId(r13)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r24)
            r5 = 8
            r6 = 0
            r2 = 2048(0x800, float:2.87E-42)
            r4 = 0
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x0155
        L_0x026e:
            r13 = r1
            int r1 = r0.semanticsNodeIdToAccessibilityVirtualNodeId(r13)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r22)
            r5 = 8
            r6 = 0
            r2 = 2048(0x800, float:2.87E-42)
            r4 = 0
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
            int r1 = r0.semanticsNodeIdToAccessibilityVirtualNodeId(r13)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r24)
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x0155
        L_0x028d:
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getContentDescription()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x02b4
            int r2 = r0.semanticsNodeIdToAccessibilityVirtualNodeId(r1)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object r4 = r5.getValue()
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r5)
            java.util.List r4 = (java.util.List) r4
            r5 = 2048(0x800, float:2.87E-42)
            r0.sendEventForVirtualView(r2, r5, r3, r4)
        L_0x02b1:
            r7 = r1
            goto L_0x05ac
        L_0x02b4:
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getEditableText()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r2)
            r3 = 100000(0x186a0, float:1.4013E-40)
            java.lang.String r4 = ""
            if (r2 == 0) goto L_0x040f
            androidx.compose.ui.semantics.SemanticsConfiguration r2 = r26.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r5 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r5 = r5.getSetText()
            boolean r2 = r2.contains(r5)
            if (r2 == 0) goto L_0x03fb
            androidx.compose.ui.semantics.SemanticsConfiguration r2 = r18.getUnmergedConfig()
            androidx.compose.ui.text.AnnotatedString r2 = r0.getTextForTextField(r2)
            if (r2 == 0) goto L_0x02e2
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            goto L_0x02e5
        L_0x02e2:
            r2 = r4
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
        L_0x02e5:
            androidx.compose.ui.semantics.SemanticsConfiguration r5 = r26.getUnmergedConfig$ui_release()
            androidx.compose.ui.text.AnnotatedString r5 = r0.getTextForTextField(r5)
            if (r5 == 0) goto L_0x02f2
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            goto L_0x02f5
        L_0x02f2:
            r5 = r4
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
        L_0x02f5:
            java.lang.CharSequence r3 = r0.trimToSize(r5, r3)
            int r4 = r2.length()
            int r6 = r5.length()
            int r13 = kotlin.ranges.RangesKt.coerceAtMost((int) r4, (int) r6)
            r15 = r24
        L_0x0307:
            r28 = r4
            if (r15 >= r13) goto L_0x031f
            char r4 = r2.charAt(r15)
            r29 = r6
            char r6 = r5.charAt(r15)
            if (r4 == r6) goto L_0x0318
            goto L_0x0321
        L_0x0318:
            int r15 = r15 + 1
            r4 = r28
            r6 = r29
            goto L_0x0307
        L_0x031f:
            r29 = r6
        L_0x0321:
            r4 = r24
        L_0x0323:
            int r6 = r13 - r15
            if (r4 >= r6) goto L_0x033e
            int r6 = r28 + -1
            int r6 = r6 - r4
            char r6 = r2.charAt(r6)
            int r30 = r29 + -1
            r31 = r4
            int r4 = r30 - r31
            char r4 = r5.charAt(r4)
            if (r6 == r4) goto L_0x033b
            goto L_0x0340
        L_0x033b:
            int r4 = r31 + 1
            goto L_0x0323
        L_0x033e:
            r31 = r4
        L_0x0340:
            int r4 = r28 - r31
            int r4 = r4 - r15
            int r6 = r29 - r31
            int r6 = r6 - r15
            androidx.compose.ui.semantics.SemanticsConfiguration r5 = r18.getUnmergedConfig()
            androidx.compose.ui.semantics.SemanticsProperties r13 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r13 = r13.getPassword()
            boolean r5 = r5.contains(r13)
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r26.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r28 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            r30 = r5
            androidx.compose.ui.semantics.SemanticsPropertyKey r5 = r28.getPassword()
            boolean r5 = r13.contains(r5)
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r18.getUnmergedConfig()
            androidx.compose.ui.semantics.SemanticsProperties r28 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            r31 = r5
            androidx.compose.ui.semantics.SemanticsPropertyKey r5 = r28.getEditableText()
            boolean r5 = r13.contains(r5)
            if (r5 == 0) goto L_0x037c
            if (r30 != 0) goto L_0x037c
            if (r31 == 0) goto L_0x037c
            r13 = 1
            goto L_0x037e
        L_0x037c:
            r13 = r24
        L_0x037e:
            if (r5 == 0) goto L_0x0387
            if (r30 == 0) goto L_0x0387
            if (r31 != 0) goto L_0x0387
            r22 = 1
            goto L_0x0389
        L_0x0387:
            r22 = r24
        L_0x0389:
            if (r13 != 0) goto L_0x03ad
            if (r22 == 0) goto L_0x038e
            goto L_0x03ad
        L_0x038e:
            int r5 = r0.semanticsNodeIdToAccessibilityVirtualNodeId(r1)
            r7 = 16
            android.view.accessibility.AccessibilityEvent r5 = r0.createEvent(r5, r7)
            r5.setFromIndex(r15)
            r5.setRemovedCount(r4)
            r5.setAddedCount(r6)
            r5.setBeforeText(r2)
            java.util.List r2 = r5.getText()
            r2.add(r3)
            r7 = r1
            goto L_0x03c6
        L_0x03ad:
            r2 = r1
            int r1 = r0.semanticsNodeIdToAccessibilityVirtualNodeId(r2)
            r4 = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r24)
            r5 = r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r24)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r29)
            r7 = r4
            r4 = r6
            android.view.accessibility.AccessibilityEvent r5 = r0.createTextSelectionChangedEvent(r1, r2, r3, r4, r5)
        L_0x03c6:
            java.lang.String r1 = "android.widget.EditText"
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r5.setClassName(r1)
            r0.sendEvent(r5)
            if (r13 != 0) goto L_0x03d4
            if (r22 == 0) goto L_0x05ac
        L_0x03d4:
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r26.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getTextSelectionRange()
            java.lang.Object r1 = r1.get(r2)
            androidx.compose.ui.text.TextRange r1 = (androidx.compose.ui.text.TextRange) r1
            long r1 = r1.m6568unboximpl()
            int r3 = androidx.compose.ui.text.TextRange.m6564getStartimpl(r1)
            r5.setFromIndex(r3)
            int r1 = androidx.compose.ui.text.TextRange.m6559getEndimpl(r1)
            r5.setToIndex(r1)
            r0.sendEvent(r5)
            goto L_0x05ac
        L_0x03fb:
            r7 = r1
            int r1 = r0.semanticsNodeIdToAccessibilityVirtualNodeId(r7)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r23)
            r5 = 8
            r6 = 0
            r2 = 2048(0x800, float:2.87E-42)
            r4 = 0
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x05ac
        L_0x040f:
            r7 = r1
            androidx.compose.ui.semantics.SemanticsProperties r1 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getTextSelectionRange()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x0479
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r26.getUnmergedConfig$ui_release()
            androidx.compose.ui.text.AnnotatedString r1 = r0.getTextForTextField(r1)
            if (r1 == 0) goto L_0x042e
            java.lang.String r1 = r1.getText()
            if (r1 != 0) goto L_0x042d
            goto L_0x042e
        L_0x042d:
            r4 = r1
        L_0x042e:
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r26.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getTextSelectionRange()
            java.lang.Object r1 = r1.get(r2)
            androidx.compose.ui.text.TextRange r1 = (androidx.compose.ui.text.TextRange) r1
            long r1 = r1.m6568unboximpl()
            r5 = r1
            int r1 = r0.semanticsNodeIdToAccessibilityVirtualNodeId(r7)
            int r2 = androidx.compose.ui.text.TextRange.m6564getStartimpl(r5)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r5 = androidx.compose.ui.text.TextRange.m6559getEndimpl(r5)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            int r6 = r4.length()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.CharSequence r3 = r0.trimToSize(r4, r3)
            r4 = r5
            r5 = r3
            r3 = r4
            r4 = r6
            android.view.accessibility.AccessibilityEvent r1 = r0.createTextSelectionChangedEvent(r1, r2, r3, r4, r5)
            r0.sendEvent(r1)
            int r1 = r26.getId()
            r0.sendPendingTextTraversedAtGranularityEvent(r1)
            goto L_0x05ac
        L_0x0479:
            androidx.compose.ui.semantics.SemanticsProperties r1 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getHorizontalScrollAxisRange()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x0487
            r1 = 1
            goto L_0x0491
        L_0x0487:
            androidx.compose.ui.semantics.SemanticsProperties r1 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getVerticalScrollAxisRange()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r1)
        L_0x0491:
            if (r1 == 0) goto L_0x04ce
            androidx.compose.ui.node.LayoutNode r1 = r26.getLayoutNode$ui_release()
            r0.notifySubtreeAccessibilityStateChangedIfNeeded(r1)
            java.util.List<androidx.compose.ui.platform.ScrollObservationScope> r1 = r0.scrollObservationScopes
            androidx.compose.ui.platform.ScrollObservationScope r1 = androidx.compose.ui.platform.SemanticsUtils_androidKt.findById(r1, r7)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            androidx.compose.ui.semantics.SemanticsConfiguration r2 = r26.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r3 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r3.getHorizontalScrollAxisRange()
            java.lang.Object r2 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r2, r3)
            androidx.compose.ui.semantics.ScrollAxisRange r2 = (androidx.compose.ui.semantics.ScrollAxisRange) r2
            r1.setHorizontalScrollAxisRange(r2)
            androidx.compose.ui.semantics.SemanticsConfiguration r2 = r26.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r3 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r3.getVerticalScrollAxisRange()
            java.lang.Object r2 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r2, r3)
            androidx.compose.ui.semantics.ScrollAxisRange r2 = (androidx.compose.ui.semantics.ScrollAxisRange) r2
            r1.setVerticalScrollAxisRange(r2)
            r0.scheduleScrollEventIfNeeded(r1)
            goto L_0x05ac
        L_0x04ce:
            androidx.compose.ui.semantics.SemanticsProperties r1 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getFocused()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x0513
            java.lang.Object r1 = r5.getValue()
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Boolean"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x04fc
            int r1 = r26.getId()
            int r1 = r0.semanticsNodeIdToAccessibilityVirtualNodeId(r1)
            r2 = 8
            android.view.accessibility.AccessibilityEvent r1 = r0.createEvent(r1, r2)
            r0.sendEvent(r1)
        L_0x04fc:
            int r1 = r26.getId()
            int r1 = r0.semanticsNodeIdToAccessibilityVirtualNodeId(r1)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r24)
            r5 = 8
            r6 = 0
            r2 = 2048(0x800, float:2.87E-42)
            r4 = 0
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x05ac
        L_0x0513:
            androidx.compose.ui.semantics.SemanticsActions r1 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getCustomActions()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x05ba
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r26.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r2 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getCustomActions()
            java.lang.Object r1 = r1.get(r2)
            java.util.List r1 = (java.util.List) r1
            androidx.compose.ui.semantics.SemanticsConfiguration r2 = r18.getUnmergedConfig()
            androidx.compose.ui.semantics.SemanticsActions r3 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r3.getCustomActions()
            java.lang.Object r2 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r2, r3)
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x0597
            java.util.LinkedHashSet r3 = new java.util.LinkedHashSet
            r3.<init>()
            java.util.Set r3 = (java.util.Set) r3
            int r4 = r1.size()
            r5 = r24
        L_0x054e:
            if (r5 >= r4) goto L_0x0560
            java.lang.Object r6 = r1.get(r5)
            androidx.compose.ui.semantics.CustomAccessibilityAction r6 = (androidx.compose.ui.semantics.CustomAccessibilityAction) r6
            java.lang.String r6 = r6.getLabel()
            r3.add(r6)
            int r5 = r5 + 1
            goto L_0x054e
        L_0x0560:
            java.util.LinkedHashSet r1 = new java.util.LinkedHashSet
            r1.<init>()
            java.util.Set r1 = (java.util.Set) r1
            int r4 = r2.size()
            r5 = r24
        L_0x056d:
            if (r5 >= r4) goto L_0x057f
            java.lang.Object r6 = r2.get(r5)
            androidx.compose.ui.semantics.CustomAccessibilityAction r6 = (androidx.compose.ui.semantics.CustomAccessibilityAction) r6
            java.lang.String r6 = r6.getLabel()
            r1.add(r6)
            int r5 = r5 + 1
            goto L_0x056d
        L_0x057f:
            r2 = r1
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r3.containsAll(r2)
            if (r2 == 0) goto L_0x0594
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r1 = r1.containsAll(r3)
            if (r1 != 0) goto L_0x0591
            goto L_0x0594
        L_0x0591:
            r21 = r24
            goto L_0x05ac
        L_0x0594:
            r21 = 1
            goto L_0x05ac
        L_0x0597:
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x05ac
            r2 = r7
            r3 = r11
            r11 = r23
            r1 = r25
            r4 = r26
            r15 = 8
            r21 = 1
            goto L_0x05b6
        L_0x05ac:
            r2 = r7
            r3 = r11
            r11 = r23
            r1 = r25
            r4 = r26
            r15 = 8
        L_0x05b6:
            r7 = r37
            goto L_0x007c
        L_0x05ba:
            java.lang.Object r1 = r5.getValue()
            boolean r1 = r1 instanceof androidx.compose.ui.semantics.AccessibilityAction
            if (r1 == 0) goto L_0x0594
            java.lang.Object r1 = r5.getValue()
            java.lang.String r2 = "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)
            androidx.compose.ui.semantics.AccessibilityAction r1 = (androidx.compose.ui.semantics.AccessibilityAction) r1
            androidx.compose.ui.semantics.SemanticsConfiguration r2 = r18.getUnmergedConfig()
            java.lang.Object r3 = r5.getKey()
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = (androidx.compose.ui.semantics.SemanticsPropertyKey) r3
            java.lang.Object r2 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r2, r3)
            boolean r1 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.accessibilityEquals(r1, r2)
            if (r1 != 0) goto L_0x0591
            goto L_0x0594
        L_0x05e2:
            r25 = r1
            r7 = r2
            r26 = r4
            r23 = r11
            r24 = 0
            r11 = r3
            if (r21 != 0) goto L_0x05f8
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r18.getUnmergedConfig()
            r4 = r26
            boolean r21 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.propertiesDeleted(r4, r1)
        L_0x05f8:
            if (r21 == 0) goto L_0x060b
            int r1 = r0.semanticsNodeIdToAccessibilityVirtualNodeId(r7)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r24)
            r5 = 8
            r6 = 0
            r2 = 2048(0x800, float:2.87E-42)
            r4 = 0
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
        L_0x060b:
            r2 = 8
            goto L_0x0621
        L_0x060e:
            java.lang.String r0 = "no value for specified key"
            androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateExceptionForNullCheck(r0)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x0619:
            r25 = r1
            r23 = r11
            r24 = 0
            r11 = r3
            r2 = r15
        L_0x0621:
            long r16 = r16 >> r2
            int r1 = r25 + 1
            r0 = r36
            r7 = r37
            r15 = r2
            r3 = r11
            r11 = r23
            goto L_0x0039
        L_0x062f:
            r23 = r11
            r2 = r15
            r24 = 0
            r11 = r3
            if (r11 != r2) goto L_0x0648
            goto L_0x063c
        L_0x0638:
            r23 = r11
            r24 = 0
        L_0x063c:
            if (r14 == r12) goto L_0x0648
            int r14 = r14 + 1
            r0 = r36
            r7 = r37
            r11 = r23
            goto L_0x001d
        L_0x0648:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.sendSemanticsPropertyChangeEvents(androidx.collection.IntObjectMap):void");
    }

    private final boolean registerScrollingId(int i, List<ScrollObservationScope> list) {
        boolean z;
        ScrollObservationScope findById = SemanticsUtils_androidKt.findById(list, i);
        if (findById != null) {
            z = false;
        } else {
            int i2 = i;
            z = true;
            findById = new ScrollObservationScope(i2, this.scrollObservationScopes, (Float) null, (Float) null, (ScrollAxisRange) null, (ScrollAxisRange) null);
        }
        this.scrollObservationScopes.add(findById);
        return z;
    }

    /* access modifiers changed from: private */
    public final void scheduleScrollEventIfNeeded(ScrollObservationScope scrollObservationScope) {
        if (scrollObservationScope.isValidOwnerScope()) {
            this.view.getSnapshotObserver().observeReads$ui_release(scrollObservationScope, this.scheduleScrollEventIfNeededLambda, new AndroidComposeViewAccessibilityDelegateCompat$scheduleScrollEventIfNeeded$1(scrollObservationScope, this));
        }
    }

    private final void sendPaneChangeEvents(int i, int i2, String str) {
        AccessibilityEvent createEvent = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(i), 32);
        createEvent.setContentChangeTypes(i2);
        if (str != null) {
            createEvent.getText().add(str);
        }
        sendEvent(createEvent);
    }

    private final void sendAccessibilitySemanticsStructureChangeEvents(SemanticsNode semanticsNode, SemanticsNodeCopy semanticsNodeCopy) {
        MutableIntSet mutableIntSetOf = IntSetKt.mutableIntSetOf();
        List<SemanticsNode> replacedChildren$ui_release = semanticsNode.getReplacedChildren$ui_release();
        int size = replacedChildren$ui_release.size();
        for (int i = 0; i < size; i++) {
            SemanticsNode semanticsNode2 = replacedChildren$ui_release.get(i);
            if (getCurrentSemanticsNodes().contains(semanticsNode2.getId())) {
                if (!semanticsNodeCopy.getChildren().contains(semanticsNode2.getId())) {
                    notifySubtreeAccessibilityStateChangedIfNeeded(semanticsNode.getLayoutNode$ui_release());
                    return;
                }
                mutableIntSetOf.add(semanticsNode2.getId());
            }
        }
        IntSet children = semanticsNodeCopy.getChildren();
        int[] iArr = children.elements;
        long[] jArr = children.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i2 - length)) >>> 31);
                    int i4 = 0;
                    while (i4 < i3) {
                        if ((255 & j) >= 128 || mutableIntSetOf.contains(iArr[(i2 << 3) + i4])) {
                            j >>= 8;
                            i4++;
                        } else {
                            notifySubtreeAccessibilityStateChangedIfNeeded(semanticsNode.getLayoutNode$ui_release());
                            return;
                        }
                    }
                    if (i3 != 8) {
                        break;
                    }
                }
                if (i2 == length) {
                    break;
                }
                i2++;
            }
        }
        List<SemanticsNode> replacedChildren$ui_release2 = semanticsNode.getReplacedChildren$ui_release();
        int size2 = replacedChildren$ui_release2.size();
        for (int i5 = 0; i5 < size2; i5++) {
            SemanticsNode semanticsNode3 = replacedChildren$ui_release2.get(i5);
            if (getCurrentSemanticsNodes().contains(semanticsNode3.getId())) {
                SemanticsNodeCopy semanticsNodeCopy2 = this.previousSemanticsNodes.get(semanticsNode3.getId());
                Intrinsics.checkNotNull(semanticsNodeCopy2);
                sendAccessibilitySemanticsStructureChangeEvents(semanticsNode3, semanticsNodeCopy2);
            }
        }
    }

    /* access modifiers changed from: private */
    public final int semanticsNodeIdToAccessibilityVirtualNodeId(int i) {
        if (i == this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
            return -1;
        }
        return i;
    }

    private final boolean traverseAtGranularity(SemanticsNode semanticsNode, int i, boolean z, boolean z2) {
        AccessibilityIterators.TextSegmentIterator iteratorForGranularity;
        int i2;
        int i3;
        int id = semanticsNode.getId();
        Integer num = this.previousTraversedNode;
        if (num == null || id != num.intValue()) {
            this.accessibilityCursorPosition = -1;
            this.previousTraversedNode = Integer.valueOf(semanticsNode.getId());
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
        CharSequence charSequence = iterableTextForAccessibility;
        if (charSequence == null || charSequence.length() == 0 || (iteratorForGranularity = getIteratorForGranularity(semanticsNode, i)) == null) {
            return false;
        }
        int accessibilitySelectionEnd = getAccessibilitySelectionEnd(semanticsNode);
        if (accessibilitySelectionEnd == -1) {
            accessibilitySelectionEnd = z ? 0 : iterableTextForAccessibility.length();
        }
        int[] following = z ? iteratorForGranularity.following(accessibilitySelectionEnd) : iteratorForGranularity.preceding(accessibilitySelectionEnd);
        if (following == null) {
            return false;
        }
        int i4 = following[0];
        int i5 = following[1];
        if (!z2 || !isAccessibilitySelectionExtendable(semanticsNode)) {
            i3 = z ? i5 : i4;
            i2 = i3;
        } else {
            i3 = getAccessibilitySelectionStart(semanticsNode);
            if (i3 == -1) {
                i3 = z ? i4 : i5;
            }
            i2 = z ? i5 : i4;
        }
        this.pendingTextTraversedEvent = new PendingTextTraversedEvent(semanticsNode, z ? 256 : 512, i, i4, i5, SystemClock.uptimeMillis());
        setAccessibilitySelection(semanticsNode, i3, i2, true);
        return true;
    }

    private final void sendPendingTextTraversedAtGranularityEvent(int i) {
        PendingTextTraversedEvent pendingTextTraversedEvent2 = this.pendingTextTraversedEvent;
        if (pendingTextTraversedEvent2 != null) {
            if (i == pendingTextTraversedEvent2.getNode().getId()) {
                if (SystemClock.uptimeMillis() - pendingTextTraversedEvent2.getTraverseTime() <= 1000) {
                    AccessibilityEvent createEvent = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(pendingTextTraversedEvent2.getNode().getId()), 131072);
                    createEvent.setFromIndex(pendingTextTraversedEvent2.getFromIndex());
                    createEvent.setToIndex(pendingTextTraversedEvent2.getToIndex());
                    createEvent.setAction(pendingTextTraversedEvent2.getAction());
                    createEvent.setMovementGranularity(pendingTextTraversedEvent2.getGranularity());
                    createEvent.getText().add(getIterableTextForAccessibility(pendingTextTraversedEvent2.getNode()));
                    sendEvent(createEvent);
                }
            } else {
                return;
            }
        }
        this.pendingTextTraversedEvent = null;
    }

    private final boolean setAccessibilitySelection(SemanticsNode semanticsNode, int i, int i2, boolean z) {
        String iterableTextForAccessibility;
        boolean z2 = false;
        if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getSetSelection()) && AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
            Function3 function3 = (Function3) ((AccessibilityAction) semanticsNode.getUnmergedConfig$ui_release().get(SemanticsActions.INSTANCE.getSetSelection())).getAction();
            if (function3 != null) {
                return ((Boolean) function3.invoke(Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
            }
            return false;
        } else if ((i == i2 && i2 == this.accessibilityCursorPosition) || (iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode)) == null) {
            return false;
        } else {
            if (i < 0 || i != i2 || i2 > iterableTextForAccessibility.length()) {
                i = -1;
            }
            this.accessibilityCursorPosition = i;
            CharSequence charSequence = iterableTextForAccessibility;
            if (charSequence.length() > 0) {
                z2 = true;
            }
            int semanticsNodeIdToAccessibilityVirtualNodeId = semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNode.getId());
            Integer num = null;
            Integer valueOf = z2 ? Integer.valueOf(this.accessibilityCursorPosition) : null;
            Integer valueOf2 = z2 ? Integer.valueOf(this.accessibilityCursorPosition) : null;
            if (z2) {
                num = Integer.valueOf(iterableTextForAccessibility.length());
            }
            sendEvent(createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId, valueOf, valueOf2, num, charSequence));
            sendPendingTextTraversedAtGranularityEvent(semanticsNode.getId());
            return true;
        }
    }

    private final int getAccessibilitySelectionStart(SemanticsNode semanticsNode) {
        if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getContentDescription()) || !semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getTextSelectionRange())) {
            return this.accessibilityCursorPosition;
        }
        return TextRange.m6564getStartimpl(((TextRange) semanticsNode.getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).m6568unboximpl());
    }

    private final int getAccessibilitySelectionEnd(SemanticsNode semanticsNode) {
        if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getContentDescription()) || !semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getTextSelectionRange())) {
            return this.accessibilityCursorPosition;
        }
        return TextRange.m6559getEndimpl(((TextRange) semanticsNode.getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).m6568unboximpl());
    }

    private final boolean isAccessibilitySelectionExtendable(SemanticsNode semanticsNode) {
        return !semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getContentDescription()) && semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getEditableText());
    }

    private final AccessibilityIterators.TextSegmentIterator getIteratorForGranularity(SemanticsNode semanticsNode, int i) {
        AccessibilityIterators.AbstractTextSegmentIterator abstractTextSegmentIterator;
        TextLayoutResult textLayoutResult;
        if (semanticsNode == null) {
            return null;
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
        CharSequence charSequence = iterableTextForAccessibility;
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        if (i == 1) {
            abstractTextSegmentIterator = AccessibilityIterators.CharacterTextSegmentIterator.Companion.getInstance(this.view.getContext().getResources().getConfiguration().locale);
            abstractTextSegmentIterator.initialize(iterableTextForAccessibility);
        } else if (i != 2) {
            if (i != 4) {
                if (i == 8) {
                    abstractTextSegmentIterator = AccessibilityIterators.ParagraphTextSegmentIterator.Companion.getInstance();
                    abstractTextSegmentIterator.initialize(iterableTextForAccessibility);
                } else if (i != 16) {
                    return null;
                }
            }
            if (!semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult()) || (textLayoutResult = SemanticsUtils_androidKt.getTextLayoutResult(semanticsNode.getUnmergedConfig$ui_release())) == null) {
                return null;
            }
            if (i == 4) {
                abstractTextSegmentIterator = AccessibilityIterators.LineTextSegmentIterator.Companion.getInstance();
                ((AccessibilityIterators.LineTextSegmentIterator) abstractTextSegmentIterator).initialize(iterableTextForAccessibility, textLayoutResult);
            } else {
                AccessibilityIterators.AbstractTextSegmentIterator instance = AccessibilityIterators.PageTextSegmentIterator.Companion.getInstance();
                ((AccessibilityIterators.PageTextSegmentIterator) instance).initialize(iterableTextForAccessibility, textLayoutResult, semanticsNode);
                abstractTextSegmentIterator = instance;
            }
        } else {
            abstractTextSegmentIterator = AccessibilityIterators.WordTextSegmentIterator.Companion.getInstance(this.view.getContext().getResources().getConfiguration().locale);
            abstractTextSegmentIterator.initialize(iterableTextForAccessibility);
        }
        return abstractTextSegmentIterator;
    }

    private final String getIterableTextForAccessibility(SemanticsNode semanticsNode) {
        AnnotatedString annotatedString;
        if (semanticsNode == null) {
            return null;
        }
        if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getContentDescription())) {
            return ListUtilsKt.fastJoinToString$default((List) semanticsNode.getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getContentDescription()), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
        if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getEditableText())) {
            AnnotatedString textForTextField = getTextForTextField(semanticsNode.getUnmergedConfig$ui_release());
            if (textForTextField != null) {
                return textForTextField.getText();
            }
            return null;
        }
        List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getText());
        if (list == null || (annotatedString = (AnnotatedString) CollectionsKt.firstOrNull(list)) == null) {
            return null;
        }
        return annotatedString.getText();
    }

    private final AnnotatedString getTextForTextField(SemanticsConfiguration semanticsConfiguration) {
        return (AnnotatedString) SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsProperties.INSTANCE.getEditableText());
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$ComposeAccessibilityNodeProvider;", "Landroidx/core/view/accessibility/AccessibilityNodeProviderCompat;", "(Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;)V", "addExtraDataToAccessibilityNodeInfo", "", "virtualViewId", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "extraDataKey", "", "arguments", "Landroid/os/Bundle;", "createAccessibilityNodeInfo", "findFocus", "focus", "performAction", "", "action", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    private final class ComposeAccessibilityNodeProvider extends AccessibilityNodeProviderCompat {
        public ComposeAccessibilityNodeProvider() {
        }

        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i) {
            AccessibilityNodeInfoCompat access$createNodeInfo = AndroidComposeViewAccessibilityDelegateCompat.this.createNodeInfo(i);
            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
            if (androidComposeViewAccessibilityDelegateCompat.sendingFocusAffectingEvent && i == androidComposeViewAccessibilityDelegateCompat.focusedVirtualViewId) {
                androidComposeViewAccessibilityDelegateCompat.currentlyFocusedANI = access$createNodeInfo;
            }
            return access$createNodeInfo;
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            return AndroidComposeViewAccessibilityDelegateCompat.this.performActionHelper(i, i2, bundle);
        }

        public void addExtraDataToAccessibilityNodeInfo(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, String str, Bundle bundle) {
            AndroidComposeViewAccessibilityDelegateCompat.this.addExtraDataToAccessibilityNodeInfoHelper(i, accessibilityNodeInfoCompat, str, bundle);
        }

        public AccessibilityNodeInfoCompat findFocus(int i) {
            return createAccessibilityNodeInfo(AndroidComposeViewAccessibilityDelegateCompat.this.focusedVirtualViewId);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api24Impl;", "", "()V", "addSetProgressAction", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    private static final class Api24Impl {
        public static final Api24Impl INSTANCE = new Api24Impl();

        private Api24Impl() {
        }

        @JvmStatic
        public static final void addSetProgressAction(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, SemanticsNode semanticsNode) {
            AccessibilityAction accessibilityAction;
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode) && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getSetProgress())) != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908349, accessibilityAction.getLabel()));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api29Impl;", "", "()V", "addPageActions", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    private static final class Api29Impl {
        public static final Api29Impl INSTANCE = new Api29Impl();

        private Api29Impl() {
        }

        @JvmStatic
        public static final void addPageActions(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, SemanticsNode semanticsNode) {
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                AccessibilityAction accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPageUp());
                if (accessibilityAction != null) {
                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908358, accessibilityAction.getLabel()));
                }
                AccessibilityAction accessibilityAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPageDown());
                if (accessibilityAction2 != null) {
                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908359, accessibilityAction2.getLabel()));
                }
                AccessibilityAction accessibilityAction3 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPageLeft());
                if (accessibilityAction3 != null) {
                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908360, accessibilityAction3.getLabel()));
                }
                AccessibilityAction accessibilityAction4 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPageRight());
                if (accessibilityAction4 != null) {
                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908361, accessibilityAction4.getLabel()));
                }
            }
        }
    }
}
