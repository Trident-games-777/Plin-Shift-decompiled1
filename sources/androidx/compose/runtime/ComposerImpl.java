package androidx.compose.runtime;

import androidx.collection.MutableIntIntMap;
import androidx.collection.ScatterMap;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.changelist.ChangeList;
import androidx.compose.runtime.changelist.ComposerChangeListWriter;
import androidx.compose.runtime.changelist.FixupList;
import androidx.compose.runtime.collection.IntMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalMapKt;
import androidx.compose.runtime.snapshots.ListUtilsKt;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000ñ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\u0010\f\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b**\u0001A\b\u0000\u0018\u00002\u00020\u0001:\u0004Ø\u0002Ù\u0002BG\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002JM\u0010\u0001\u001a\u00030\u0001\"\u0005\b\u0000\u0010\u0001\"\u0005\b\u0001\u0010\u00012\b\u0010\u0001\u001a\u0003H\u00012#\u0010\u0001\u001a\u001e\u0012\u0005\u0012\u0003H\u0001\u0012\u0005\u0012\u0003H\u0001\u0012\u0005\u0012\u00030\u00010\u0001¢\u0006\u0003\b\u0001H\u0016¢\u0006\u0003\u0010\u0001J\t\u0010\u0001\u001a\u00020\u0005H\u0016J2\u0010\u0001\u001a\u0003H\u0001\"\u0005\b\u0000\u0010\u00012\u0007\u0010\u0001\u001a\u00020\u00182\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00010\u0001H\b¢\u0006\u0003\u0010\u0001J\u0014\u0010\u0001\u001a\u00020\u00182\t\u0010\u0001\u001a\u0004\u0018\u00010~H\u0017J\u0012\u0010\u0001\u001a\u00020\u00182\u0007\u0010\u0001\u001a\u00020\u0018H\u0017J\u0013\u0010\u0001\u001a\u00020\u00182\b\u0010\u0001\u001a\u00030\u0001H\u0017J\u0013\u0010\u0001\u001a\u00020\u00182\b\u0010\u0001\u001a\u00030\u0001H\u0017J\u0013\u0010\u0001\u001a\u00020\u00182\b\u0010\u0001\u001a\u00030 \u0001H\u0017J\u0013\u0010\u0001\u001a\u00020\u00182\b\u0010\u0001\u001a\u00030¡\u0001H\u0017J\u0012\u0010\u0001\u001a\u00020\u00182\u0007\u0010\u0001\u001a\u00020\u001cH\u0017J\u0013\u0010\u0001\u001a\u00020\u00182\b\u0010\u0001\u001a\u00030¢\u0001H\u0017J\u0013\u0010\u0001\u001a\u00020\u00182\b\u0010\u0001\u001a\u00030£\u0001H\u0017J\u0014\u0010¤\u0001\u001a\u00020\u00182\t\u0010\u0001\u001a\u0004\u0018\u00010~H\u0017J\u0010\u0010¥\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\b¦\u0001J\n\u0010§\u0001\u001a\u00030\u0001H\u0002J\n\u0010¨\u0001\u001a\u00030\u0001H\u0002J\n\u0010©\u0001\u001a\u00030\u0001H\u0016J@\u0010ª\u0001\u001a\u00030\u00012\u0014\u0010«\u0001\u001a\u000f\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020~0¬\u00012\u0015\u0010­\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u00010\u0001¢\u0006\u0003\b®\u0001H\u0000¢\u0006\u0006\b¯\u0001\u0010°\u0001J,\u0010±\u0001\u001a\u00020\u001c2\u0007\u0010²\u0001\u001a\u00020\u001c2\u0006\u0010r\u001a\u00020\u001c2\u0007\u0010³\u0001\u001a\u00020\u001c2\u0007\u0010´\u0001\u001a\u00020\u001cH\u0002J(\u0010µ\u0001\u001a\u0003H\u0001\"\u0005\b\u0000\u0010\u00012\u000f\u0010¶\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00010·\u0001H\u0017¢\u0006\u0003\u0010¸\u0001J\n\u0010¹\u0001\u001a\u00030\u0001H\u0002J\"\u0010º\u0001\u001a\u00030\u0001\"\u0005\b\u0000\u0010\u00012\u000f\u0010»\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00010\u0001H\u0016J\t\u0010¼\u0001\u001a\u00020hH\u0002J\u0012\u0010¼\u0001\u001a\u00020h2\u0007\u0010²\u0001\u001a\u00020\u001cH\u0002J\u0010\u0010½\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\b¾\u0001J\u0013\u0010¿\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0018H\u0017J\n\u0010À\u0001\u001a\u00030\u0001H\u0016J\n\u0010Á\u0001\u001a\u00030\u0001H\u0016J\u0010\u0010Â\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\bÃ\u0001J?\u0010Ä\u0001\u001a\u00030\u00012\u0014\u0010«\u0001\u001a\u000f\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020~0¬\u00012\u0017\u0010­\u0001\u001a\u0012\u0012\u0005\u0012\u00030\u0001\u0018\u00010\u0001¢\u0006\u0003\b®\u0001H\u0002¢\u0006\u0003\u0010°\u0001J\u001c\u0010Å\u0001\u001a\u00030\u00012\u0007\u0010²\u0001\u001a\u00020\u001c2\u0007\u0010Æ\u0001\u001a\u00020\u001cH\u0002J\n\u0010Ç\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010È\u0001\u001a\u00030\u00012\u0007\u0010É\u0001\u001a\u00020\u0018H\u0002J\n\u0010Ê\u0001\u001a\u00030\u0001H\u0017J\n\u0010Ë\u0001\u001a\u00030\u0001H\u0002J\n\u0010Ì\u0001\u001a\u00030\u0001H\u0017J\n\u0010Í\u0001\u001a\u00030\u0001H\u0016J\n\u0010Î\u0001\u001a\u00030\u0001H\u0017J\n\u0010Ï\u0001\u001a\u00030\u0001H\u0017J\n\u0010Ð\u0001\u001a\u00030\u0001H\u0017J\n\u0010Ñ\u0001\u001a\u00030\u0001H\u0017J\f\u0010Ò\u0001\u001a\u0005\u0018\u00010Ó\u0001H\u0017J\n\u0010Ô\u0001\u001a\u00030\u0001H\u0016J\b\u0010Õ\u0001\u001a\u00030\u0001J\n\u0010Ö\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010×\u0001\u001a\u00030\u00012\u0007\u0010Ø\u0001\u001a\u00020\u001cH\u0016J\n\u0010Ù\u0001\u001a\u00030\u0001H\u0002J\u001e\u0010Ú\u0001\u001a\u00030\u00012\u0007\u0010É\u0001\u001a\u00020\u00182\t\u0010Û\u0001\u001a\u0004\u0018\u00010kH\u0002J\u001b\u0010Ü\u0001\u001a\u00030\u00012\u0007\u0010Ý\u0001\u001a\u00020\u001c2\u0006\u0010U\u001a\u00020\u0018H\u0002J\n\u0010Þ\u0001\u001a\u00030\u0001H\u0002J\n\u0010ß\u0001\u001a\u00030\u0001H\u0002J\u000e\u0010E\u001a\u00020\u0018H\u0000¢\u0006\u0003\bà\u0001J#\u0010á\u0001\u001a\u00030\u00012\f\u0010\u0001\u001a\u0007\u0012\u0002\b\u00030â\u00012\t\u0010ã\u0001\u001a\u0004\u0018\u00010~H\u0017J+\u0010ä\u0001\u001a\u00030\u00012\u001f\u0010å\u0001\u001a\u001a\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030è\u0001\u0012\u0007\u0012\u0005\u0018\u00010è\u00010ç\u00010æ\u0001H\u0002J+\u0010é\u0001\u001a\u00030\u00012\u001f\u0010å\u0001\u001a\u001a\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030è\u0001\u0012\u0007\u0012\u0005\u0018\u00010è\u00010ç\u00010æ\u0001H\u0017J\u0012\u0010ê\u0001\u001a\u00020\u001c2\u0007\u0010ë\u0001\u001a\u00020\u001cH\u0002J9\u0010ì\u0001\u001a\u00030\u00012\u0010\u0010­\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010~0â\u00012\u0007\u0010í\u0001\u001a\u00020h2\t\u0010ã\u0001\u001a\u0004\u0018\u00010~2\u0007\u0010î\u0001\u001a\u00020\u0018H\u0002J\u001f\u0010ï\u0001\u001a\u00020~2\t\u0010ð\u0001\u001a\u0004\u0018\u00010~2\t\u0010ñ\u0001\u001a\u0004\u0018\u00010~H\u0017J\u000b\u0010ò\u0001\u001a\u0004\u0018\u00010~H\u0001J\u000b\u0010ó\u0001\u001a\u0004\u0018\u00010~H\u0001J-\u0010ô\u0001\u001a\u00020\u001c2\u0007\u0010õ\u0001\u001a\u00020\u001c2\u0007\u0010²\u0001\u001a\u00020\u001c2\u0007\u0010³\u0001\u001a\u00020\u001c2\u0007\u0010ö\u0001\u001a\u00020\u001cH\u0002J\u000f\u0010÷\u0001\u001a\u00020\u001cH\u0001¢\u0006\u0003\bø\u0001J!\u0010ù\u0001\u001a\u00030\u00012\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001H\u0000¢\u0006\u0003\bú\u0001J\u0012\u0010û\u0001\u001a\u00020\u001c2\u0007\u0010²\u0001\u001a\u00020\u001cH\u0002J%\u0010ü\u0001\u001a\u00020\u00182\u0014\u0010«\u0001\u001a\u000f\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020~0¬\u0001H\u0000¢\u0006\u0003\bý\u0001Jo\u0010þ\u0001\u001a\u0003Hÿ\u0001\"\u0005\b\u0000\u0010ÿ\u00012\u000b\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u000f2\u000b\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u000f2\u000b\b\u0002\u0010ë\u0001\u001a\u0004\u0018\u00010\u001c2\u001e\b\u0002\u0010Z\u001a\u0018\u0012\u0013\u0012\u0011\u0012\u0004\u0012\u000205\u0012\u0006\u0012\u0004\u0018\u00010~0ç\u00010æ\u00012\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u0003Hÿ\u00010\u0001H\u0002¢\u0006\u0003\u0010\u0002J\n\u0010\u0002\u001a\u00030\u0001H\u0002J\n\u0010\u0002\u001a\u00030\u0001H\u0002J\u0013\u0010\u0002\u001a\u00030\u00012\u0007\u0010\u0002\u001a\u00020MH\u0002J\u0013\u0010\u0002\u001a\u00030\u00012\u0007\u0010\u0002\u001a\u00020hH\u0002J\u001b\u0010\u0002\u001a\u00030\u00012\u000f\u0010\u0002\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001H\u0016J%\u0010\u0002\u001a\u00030\u00012\u0007\u0010\u0002\u001a\u00020\u001c2\u0007\u0010\u0002\u001a\u00020\u001c2\u0007\u0010\u0002\u001a\u00020\u001cH\u0002J\u0013\u0010\u0002\u001a\u00030\u00012\u0007\u0010\u0002\u001a\u00020zH\u0016J\u000b\u0010\u0002\u001a\u0004\u0018\u00010MH\u0002J\u000b\u0010\u0002\u001a\u0004\u0018\u00010~H\u0016J\n\u0010\u0002\u001a\u00030\u0001H\u0002J\u0013\u0010\u0002\u001a\u00030\u00012\u0007\u0010\u0002\u001a\u00020\u001cH\u0002J\n\u0010\u0002\u001a\u00030\u0001H\u0017J\n\u0010\u0002\u001a\u00030\u0001H\u0002J\n\u0010\u0002\u001a\u00030\u0001H\u0002J\n\u0010\u0002\u001a\u00030\u0001H\u0017J\u0014\u0010\u0002\u001a\u00030\u00012\b\u0010\u0002\u001a\u00030\u0002H\u0017J\n\u0010\u0002\u001a\u00030\u0001H\u0017J\u001d\u0010\u0002\u001a\u00030\u00012\u0007\u0010¶\u0001\u001a\u00020\u001c2\b\u0010\u0002\u001a\u00030\u0002H\u0017J\u000f\u0010\u0002\u001a\u00020\u001cH\u0000¢\u0006\u0003\b\u0002J?\u0010 \u0002\u001a\u00030\u00012\u0007\u0010¶\u0001\u001a\u00020\u001c2\t\u0010¡\u0002\u001a\u0004\u0018\u00010~2\b\u0010¢\u0002\u001a\u00030£\u00022\t\u0010¤\u0002\u001a\u0004\u0018\u00010~H\u0002ø\u0001\u0000¢\u0006\u0006\b¥\u0002\u0010¦\u0002J\n\u0010§\u0002\u001a\u00030\u0001H\u0017J\u0013\u0010¨\u0002\u001a\u00030\u00012\u0007\u0010¶\u0001\u001a\u00020\u001cH\u0002J\u001e\u0010¨\u0002\u001a\u00030\u00012\u0007\u0010¶\u0001\u001a\u00020\u001c2\t\u0010©\u0002\u001a\u0004\u0018\u00010~H\u0002J\u001e\u0010ª\u0002\u001a\u00030\u00012\u0007\u0010¶\u0001\u001a\u00020\u001c2\t\u0010©\u0002\u001a\u0004\u0018\u00010~H\u0017J\n\u0010«\u0002\u001a\u00030\u0001H\u0016J\u0018\u0010¬\u0002\u001a\u00030\u00012\f\u0010\u0001\u001a\u0007\u0012\u0002\b\u00030­\u0002H\u0017J'\u0010®\u0002\u001a\u00030\u00012\u0015\u0010¯\u0002\u001a\u0010\u0012\u000b\b\u0001\u0012\u0007\u0012\u0002\b\u00030­\u00020°\u0002H\u0017¢\u0006\u0003\u0010±\u0002J\u001e\u0010²\u0002\u001a\u00030\u00012\u0007\u0010É\u0001\u001a\u00020\u00182\t\u0010¤\u0002\u001a\u0004\u0018\u00010~H\u0002J\u0013\u0010³\u0002\u001a\u00030\u00012\u0007\u0010¶\u0001\u001a\u00020\u001cH\u0017J\u0013\u0010´\u0002\u001a\u00030\u00012\u0007\u0010¶\u0001\u001a\u00020\u001cH\u0017J\u0012\u0010µ\u0002\u001a\u00020\u00012\u0007\u0010¶\u0001\u001a\u00020\u001cH\u0017J\u001e\u0010¶\u0002\u001a\u00030\u00012\u0007\u0010¶\u0001\u001a\u00020\u001c2\t\u0010©\u0002\u001a\u0004\u0018\u00010~H\u0016J\n\u0010·\u0002\u001a\u00030\u0001H\u0016J\b\u0010¸\u0002\u001a\u00030\u0001J\n\u0010¹\u0002\u001a\u00030\u0001H\u0002J#\u0010º\u0002\u001a\u00020\u00182\u0007\u0010\u0002\u001a\u0002052\t\u0010»\u0002\u001a\u0004\u0018\u00010~H\u0000¢\u0006\u0003\b¼\u0002J\u0015\u0010½\u0002\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010~H\u0001J2\u0010¾\u0002\u001a\u00030\u00012\u0007\u0010¿\u0002\u001a\u00020\u001c2\u0006\u0010r\u001a\u00020\u001c2\t\u0010©\u0002\u001a\u0004\u0018\u00010~2\t\u0010¤\u0002\u001a\u0004\u0018\u00010~H\bJ\u001c\u0010À\u0002\u001a\u00030\u00012\u0007\u0010Á\u0002\u001a\u00020\u001c2\u0006\u0010r\u001a\u00020\u001cH\bJ2\u0010Â\u0002\u001a\u00030\u00012\u0007\u0010¿\u0002\u001a\u00020\u001c2\u0006\u0010r\u001a\u00020\u001c2\t\u0010©\u0002\u001a\u0004\u0018\u00010~2\t\u0010¤\u0002\u001a\u0004\u0018\u00010~H\bJ\u001c\u0010Ã\u0002\u001a\u00030\u00012\u0007\u0010¿\u0002\u001a\u00020\u001c2\u0006\u0010r\u001a\u00020\u001cH\bJ\u001c\u0010Ä\u0002\u001a\u00030\u00012\u0007\u0010²\u0001\u001a\u00020\u001c2\u0007\u0010Å\u0002\u001a\u00020\u001cH\u0002J\u001c\u0010Æ\u0002\u001a\u00030\u00012\u0007\u0010²\u0001\u001a\u00020\u001c2\u0007\u0010Ç\u0002\u001a\u00020\u001cH\u0002J\u001b\u0010È\u0002\u001a\u00020h2\u0007\u0010É\u0002\u001a\u00020h2\u0007\u0010Ê\u0002\u001a\u00020hH\u0002J\u0015\u0010Ë\u0002\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010~H\u0016J\u0015\u0010Ì\u0002\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010~H\u0002J\u0015\u0010Í\u0002\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010~H\u0001J\u0012\u0010Î\u0002\u001a\u00020\u001c2\u0007\u0010²\u0001\u001a\u00020\u001cH\u0002J\n\u0010Ï\u0002\u001a\u00030\u0001H\u0016J\n\u0010Ð\u0002\u001a\u00030\u0001H\u0002J\n\u0010Ñ\u0002\u001a\u00030\u0001H\u0002J\u0010\u0010Ò\u0002\u001a\u00030\u0001H\u0000¢\u0006\u0003\bÓ\u0002J1\u0010Ô\u0002\u001a\u0003Hÿ\u0001\"\u0005\b\u0000\u0010ÿ\u00012\u0006\u0010s\u001a\u00020t2\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u0003Hÿ\u00010\u0001H\b¢\u0006\u0003\u0010Õ\u0002J\u0016\u0010Ö\u0002\u001a\u00020\u001c*\u00020t2\u0007\u0010²\u0001\u001a\u00020\u001cH\u0002J\u0018\u0010×\u0002\u001a\u0004\u0018\u00010~*\u00020t2\u0007\u0010ë\u0001\u001a\u00020\u001cH\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148WX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00188@X\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8@X\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R&\u0010*\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u001c8\u0016@RX\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010,\u001a\u0004\b-\u0010\u001eR\u0014\u0010.\u001a\u00020/8VX\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00102\u001a\u00020\u001c8VX\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u001eR\u0016\u00104\u001a\u0004\u0018\u0001058@X\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u001a\u00108\u001a\u00020\u00188VX\u0004¢\u0006\f\u0012\u0004\b9\u0010,\u001a\u0004\b:\u0010\u001aR\u001c\u0010;\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0010\u0010@\u001a\u00020AX\u0004¢\u0006\u0004\n\u0002\u0010BR\u000e\u0010C\u001a\u00020DX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010H\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\bI\u0010\u001aR\u0014\u0010J\u001a\u00020\u00188@X\u0004¢\u0006\u0006\u001a\u0004\bK\u0010\u001aR\u000e\u0010L\u001a\u00020MX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020OX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010P\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR&\u0010U\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u00188\u0016@RX\u000e¢\u0006\u000e\n\u0000\u0012\u0004\bV\u0010,\u001a\u0004\bW\u0010\u001aR\u0014\u0010X\u001a\b\u0012\u0004\u0012\u0002050YX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010Z\u001a\b\u0012\u0004\u0012\u00020\\0[X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010]\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0018@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b^\u0010\u001aR\u001e\u0010_\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0018@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b`\u0010\u001aR\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010a\u001a\u0004\u0018\u00010bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010c\u001a\u0004\u0018\u00010dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020hX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020DX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010j\u001a\u0004\u0018\u00010kX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010l\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010k0YX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010m\u001a\u0004\u0018\u00010hX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010n\u001a\n\u0012\u0004\u0012\u00020h\u0018\u00010oX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020DX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010s\u001a\u00020tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u0016\u0010y\u001a\u0004\u0018\u00010z8VX\u0004¢\u0006\u0006\u001a\u0004\b{\u0010|R\u0017\u0010}\u001a\u0004\u0018\u00010~8VX\u0004¢\u0006\u0007\u001a\u0005\b\u0010\u0001R\u000f\u0010\u0001\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0001\u001a\u00020\u00188VX\u0004¢\u0006\u000e\u0012\u0005\b\u0001\u0010,\u001a\u0005\b\u0001\u0010\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0001\u001a\u0004\u0018\u00010~*\u00020t8BX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006Ú\u0002"}, d2 = {"Landroidx/compose/runtime/ComposerImpl;", "Landroidx/compose/runtime/Composer;", "applier", "Landroidx/compose/runtime/Applier;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "slotTable", "Landroidx/compose/runtime/SlotTable;", "abandonSet", "", "Landroidx/compose/runtime/RememberObserver;", "changes", "Landroidx/compose/runtime/changelist/ChangeList;", "lateChanges", "composition", "Landroidx/compose/runtime/ControlledComposition;", "(Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/SlotTable;Ljava/util/Set;Landroidx/compose/runtime/changelist/ChangeList;Landroidx/compose/runtime/changelist/ChangeList;Landroidx/compose/runtime/ControlledComposition;)V", "getApplier", "()Landroidx/compose/runtime/Applier;", "applyCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getApplyCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "areChildrenComposing", "", "getAreChildrenComposing$runtime_release", "()Z", "changeCount", "", "getChangeCount$runtime_release", "()I", "changeListWriter", "Landroidx/compose/runtime/changelist/ComposerChangeListWriter;", "childrenComposing", "getComposition", "()Landroidx/compose/runtime/ControlledComposition;", "compositionData", "Landroidx/compose/runtime/tooling/CompositionData;", "getCompositionData", "()Landroidx/compose/runtime/tooling/CompositionData;", "compositionToken", "<set-?>", "compoundKeyHash", "getCompoundKeyHash$annotations", "()V", "getCompoundKeyHash", "currentCompositionLocalMap", "Landroidx/compose/runtime/CompositionLocalMap;", "getCurrentCompositionLocalMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "currentMarker", "getCurrentMarker", "currentRecomposeScope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "getCurrentRecomposeScope$runtime_release", "()Landroidx/compose/runtime/RecomposeScopeImpl;", "defaultsInvalid", "getDefaultsInvalid$annotations", "getDefaultsInvalid", "deferredChanges", "getDeferredChanges$runtime_release", "()Landroidx/compose/runtime/changelist/ChangeList;", "setDeferredChanges$runtime_release", "(Landroidx/compose/runtime/changelist/ChangeList;)V", "derivedStateObserver", "androidx/compose/runtime/ComposerImpl$derivedStateObserver$1", "Landroidx/compose/runtime/ComposerImpl$derivedStateObserver$1;", "entersStack", "Landroidx/compose/runtime/IntStack;", "forceRecomposeScopes", "forciblyRecompose", "groupNodeCount", "hasInvalidations", "getHasInvalidations", "hasPendingChanges", "getHasPendingChanges$runtime_release", "insertAnchor", "Landroidx/compose/runtime/Anchor;", "insertFixups", "Landroidx/compose/runtime/changelist/FixupList;", "insertTable", "getInsertTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "setInsertTable$runtime_release", "(Landroidx/compose/runtime/SlotTable;)V", "inserting", "getInserting$annotations", "getInserting", "invalidateStack", "Landroidx/compose/runtime/Stack;", "invalidations", "", "Landroidx/compose/runtime/Invalidation;", "isComposing", "isComposing$runtime_release", "isDisposed", "isDisposed$runtime_release", "nodeCountOverrides", "", "nodeCountVirtualOverrides", "Landroidx/collection/MutableIntIntMap;", "nodeExpected", "nodeIndex", "parentProvider", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "parentStateStack", "pending", "Landroidx/compose/runtime/Pending;", "pendingStack", "providerCache", "providerUpdates", "Landroidx/compose/runtime/collection/IntMap;", "providersInvalid", "providersInvalidStack", "rGroupIndex", "reader", "Landroidx/compose/runtime/SlotReader;", "getReader$runtime_release", "()Landroidx/compose/runtime/SlotReader;", "setReader$runtime_release", "(Landroidx/compose/runtime/SlotReader;)V", "recomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "recomposeScopeIdentity", "", "getRecomposeScopeIdentity", "()Ljava/lang/Object;", "reusing", "reusingGroup", "skipping", "getSkipping$annotations", "getSkipping", "sourceMarkersEnabled", "writer", "Landroidx/compose/runtime/SlotWriter;", "writerHasAProvider", "node", "getNode", "(Landroidx/compose/runtime/SlotReader;)Ljava/lang/Object;", "abortRoot", "", "addRecomposeScope", "apply", "V", "T", "value", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "buildContext", "cache", "invalid", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "changed", "", "", "", "", "", "", "changedInstance", "changesApplied", "changesApplied$runtime_release", "cleanUpCompose", "clearUpdatedNodeCounts", "collectParameterInformation", "composeContent", "invalidationsRequested", "Landroidx/compose/runtime/collection/ScopeMap;", "content", "Landroidx/compose/runtime/Composable;", "composeContent$runtime_release", "(Landroidx/compose/runtime/collection/ScopeMap;Lkotlin/jvm/functions/Function2;)V", "compoundKeyOf", "group", "recomposeGroup", "recomposeKey", "consume", "key", "Landroidx/compose/runtime/CompositionLocal;", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "createFreshInsertTable", "createNode", "factory", "currentCompositionLocalScope", "deactivate", "deactivate$runtime_release", "deactivateToEndGroup", "disableReusing", "disableSourceInformation", "dispose", "dispose$runtime_release", "doCompose", "doRecordDownsFor", "nearestCommonRoot", "enableReusing", "end", "isNode", "endDefaults", "endGroup", "endMovableGroup", "endNode", "endProvider", "endProviders", "endReplaceGroup", "endReplaceableGroup", "endRestartGroup", "Landroidx/compose/runtime/ScopeUpdateScope;", "endReusableGroup", "endReuseFromRoot", "endRoot", "endToMarker", "marker", "ensureWriter", "enterGroup", "newPending", "exitGroup", "expectedNodeCount", "finalizeCompose", "forceFreshInsertTable", "forceRecomposeScopes$runtime_release", "insertMovableContent", "Landroidx/compose/runtime/MovableContent;", "parameter", "insertMovableContentGuarded", "references", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "insertMovableContentReferences", "insertedGroupVirtualIndex", "index", "invokeMovableContentLambda", "locals", "force", "joinKey", "left", "right", "nextSlot", "nextSlotForCache", "nodeIndexOf", "groupLocation", "recomposeIndex", "parentKey", "parentKey$runtime_release", "prepareCompose", "prepareCompose$runtime_release", "rGroupIndexOf", "recompose", "recompose$runtime_release", "recomposeMovableContent", "R", "from", "to", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ControlledComposition;Ljava/lang/Integer;Ljava/util/List;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "recomposeToGroupEnd", "recordDelete", "recordInsert", "anchor", "recordProviderUpdate", "providers", "recordSideEffect", "effect", "recordUpsAndDowns", "oldGroup", "newGroup", "commonRoot", "recordUsed", "scope", "rememberObserverAnchor", "rememberedValue", "reportAllMovableContent", "reportFreeMovableContent", "groupBeingRemoved", "skipCurrentGroup", "skipGroup", "skipReaderToGroupEnd", "skipToGroupEnd", "sourceInformation", "", "sourceInformationMarkerEnd", "sourceInformationMarkerStart", "stacksSize", "stacksSize$runtime_release", "start", "objectKey", "kind", "Landroidx/compose/runtime/GroupKind;", "data", "start-BaiHCIY", "(ILjava/lang/Object;ILjava/lang/Object;)V", "startDefaults", "startGroup", "dataKey", "startMovableGroup", "startNode", "startProvider", "Landroidx/compose/runtime/ProvidedValue;", "startProviders", "values", "", "([Landroidx/compose/runtime/ProvidedValue;)V", "startReaderGroup", "startReplaceGroup", "startReplaceableGroup", "startRestartGroup", "startReusableGroup", "startReusableNode", "startReuseFromRoot", "startRoot", "tryImminentInvalidation", "instance", "tryImminentInvalidation$runtime_release", "updateCachedValue", "updateCompoundKeyWhenWeEnterGroup", "groupKey", "updateCompoundKeyWhenWeEnterGroupKeyHash", "keyHash", "updateCompoundKeyWhenWeExitGroup", "updateCompoundKeyWhenWeExitGroupKeyHash", "updateNodeCount", "count", "updateNodeCountOverrides", "newCount", "updateProviderMapGroup", "parentScope", "currentProviders", "updateRememberedValue", "updateSlot", "updateValue", "updatedNodeCount", "useNode", "validateNodeExpected", "validateNodeNotExpected", "verifyConsistent", "verifyConsistent$runtime_release", "withReader", "(Landroidx/compose/runtime/SlotReader;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "groupCompoundKeyPart", "nodeAt", "CompositionContextHolder", "CompositionContextImpl", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Composer.kt */
public final class ComposerImpl implements Composer {
    public static final int $stable = 8;
    private final Set<RememberObserver> abandonSet;
    private final Applier<?> applier;
    /* access modifiers changed from: private */
    public final ComposerChangeListWriter changeListWriter;
    private ChangeList changes;
    /* access modifiers changed from: private */
    public int childrenComposing;
    private final ControlledComposition composition;
    private int compositionToken;
    private int compoundKeyHash;
    private ChangeList deferredChanges;
    private final ComposerImpl$derivedStateObserver$1 derivedStateObserver;
    private final IntStack entersStack = new IntStack();
    private boolean forceRecomposeScopes;
    private boolean forciblyRecompose;
    private int groupNodeCount;
    private Anchor insertAnchor;
    private FixupList insertFixups;
    private SlotTable insertTable;
    private boolean inserting;
    private final Stack<RecomposeScopeImpl> invalidateStack;
    private final List<Invalidation> invalidations = new ArrayList();
    private boolean isComposing;
    private boolean isDisposed;
    private ChangeList lateChanges;
    /* access modifiers changed from: private */
    public int[] nodeCountOverrides;
    private MutableIntIntMap nodeCountVirtualOverrides;
    private boolean nodeExpected;
    private int nodeIndex;
    /* access modifiers changed from: private */
    public final CompositionContext parentContext;
    private PersistentCompositionLocalMap parentProvider = PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf();
    private final IntStack parentStateStack = new IntStack();
    private Pending pending;
    private final Stack<Pending> pendingStack = new Stack<>();
    private PersistentCompositionLocalMap providerCache;
    /* access modifiers changed from: private */
    public IntMap<PersistentCompositionLocalMap> providerUpdates;
    private boolean providersInvalid;
    private final IntStack providersInvalidStack = new IntStack();
    private int rGroupIndex;
    private SlotReader reader;
    private boolean reusing;
    private int reusingGroup = -1;
    /* access modifiers changed from: private */
    public final SlotTable slotTable;
    private boolean sourceMarkersEnabled;
    private SlotWriter writer;
    private boolean writerHasAProvider;

    public static /* synthetic */ void getCompoundKeyHash$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getDefaultsInvalid$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getInserting$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getSkipping$annotations() {
    }

    private final int insertedGroupVirtualIndex(int i) {
        return -2 - i;
    }

    /* JADX INFO: finally extract failed */
    public ComposerImpl(Applier<?> applier2, CompositionContext compositionContext, SlotTable slotTable2, Set<RememberObserver> set, ChangeList changeList, ChangeList changeList2, ControlledComposition controlledComposition) {
        this.applier = applier2;
        this.parentContext = compositionContext;
        this.slotTable = slotTable2;
        this.abandonSet = set;
        this.changes = changeList;
        this.lateChanges = changeList2;
        this.composition = controlledComposition;
        this.sourceMarkersEnabled = compositionContext.getCollectingSourceInformation$runtime_release() || compositionContext.getCollectingCallByInformation$runtime_release();
        this.derivedStateObserver = new ComposerImpl$derivedStateObserver$1(this);
        this.invalidateStack = new Stack<>();
        SlotReader openReader = slotTable2.openReader();
        openReader.close();
        this.reader = openReader;
        SlotTable slotTable3 = new SlotTable();
        if (compositionContext.getCollectingSourceInformation$runtime_release()) {
            slotTable3.collectSourceInformation();
        }
        if (compositionContext.getCollectingCallByInformation$runtime_release()) {
            slotTable3.collectCalledByInformation();
        }
        this.insertTable = slotTable3;
        SlotWriter openWriter = slotTable3.openWriter();
        openWriter.close(true);
        this.writer = openWriter;
        this.changeListWriter = new ComposerChangeListWriter(this, this.changes);
        SlotReader openReader2 = this.insertTable.openReader();
        try {
            Anchor anchor = openReader2.anchor(0);
            openReader2.close();
            this.insertAnchor = anchor;
            this.insertFixups = new FixupList();
        } catch (Throwable th) {
            openReader2.close();
            throw th;
        }
    }

    public Applier<?> getApplier() {
        return this.applier;
    }

    public ControlledComposition getComposition() {
        return this.composition;
    }

    public final boolean isComposing$runtime_release() {
        return this.isComposing;
    }

    public final boolean isDisposed$runtime_release() {
        return this.isDisposed;
    }

    public final boolean getAreChildrenComposing$runtime_release() {
        return this.childrenComposing > 0;
    }

    public final boolean getHasPendingChanges$runtime_release() {
        return this.changes.isNotEmpty();
    }

    public final SlotReader getReader$runtime_release() {
        return this.reader;
    }

    public final void setReader$runtime_release(SlotReader slotReader) {
        this.reader = slotReader;
    }

    public final SlotTable getInsertTable$runtime_release() {
        return this.insertTable;
    }

    public final void setInsertTable$runtime_release(SlotTable slotTable2) {
        this.insertTable = slotTable2;
    }

    public final ChangeList getDeferredChanges$runtime_release() {
        return this.deferredChanges;
    }

    public final void setDeferredChanges$runtime_release(ChangeList changeList) {
        this.deferredChanges = changeList;
    }

    public CoroutineContext getApplyCoroutineContext() {
        return this.parentContext.getEffectCoroutineContext();
    }

    @ComposeCompilerApi
    public void startReplaceableGroup(int i) {
        m3642startBaiHCIY(i, (Object) null, GroupKind.Companion.m3652getGroupULZAiWs(), (Object) null);
    }

    @ComposeCompilerApi
    public void endReplaceableGroup() {
        endGroup();
    }

    @ComposeCompilerApi
    public void startReplaceGroup(int i) {
        if (this.pending != null) {
            m3642startBaiHCIY(i, (Object) null, GroupKind.Companion.m3652getGroupULZAiWs(), (Object) null);
            return;
        }
        validateNodeNotExpected();
        this.compoundKeyHash = this.rGroupIndex ^ Integer.rotateLeft(Integer.rotateLeft(getCompoundKeyHash(), 3) ^ i, 3);
        this.rGroupIndex++;
        SlotReader slotReader = this.reader;
        if (getInserting()) {
            slotReader.beginEmpty();
            this.writer.startGroup(i, Composer.Companion.getEmpty());
            enterGroup(false, (Pending) null);
        } else if (slotReader.getGroupKey() != i || slotReader.getHasObjectKey()) {
            if (!slotReader.isGroupEnd()) {
                int i2 = this.nodeIndex;
                int currentGroup = slotReader.getCurrentGroup();
                recordDelete();
                this.changeListWriter.removeNode(i2, slotReader.skipGroup());
                ComposerKt.removeRange(this.invalidations, currentGroup, slotReader.getCurrentGroup());
            }
            slotReader.beginEmpty();
            this.inserting = true;
            this.providerCache = null;
            ensureWriter();
            SlotWriter slotWriter = this.writer;
            slotWriter.beginInsert();
            int currentGroup2 = slotWriter.getCurrentGroup();
            slotWriter.startGroup(i, Composer.Companion.getEmpty());
            this.insertAnchor = slotWriter.anchor(currentGroup2);
            enterGroup(false, (Pending) null);
        } else {
            slotReader.startGroup();
            enterGroup(false, (Pending) null);
        }
    }

    @ComposeCompilerApi
    public void endReplaceGroup() {
        endGroup();
    }

    @ComposeCompilerApi
    public void startDefaults() {
        m3642startBaiHCIY(-127, (Object) null, GroupKind.Companion.m3652getGroupULZAiWs(), (Object) null);
    }

    @ComposeCompilerApi
    public void endDefaults() {
        endGroup();
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        if (currentRecomposeScope$runtime_release != null && currentRecomposeScope$runtime_release.getUsed()) {
            currentRecomposeScope$runtime_release.setDefaultsInScope(true);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
        r0 = getCurrentRecomposeScope$runtime_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean getDefaultsInvalid() {
        /*
            r2 = this;
            boolean r0 = r2.getSkipping()
            r1 = 1
            if (r0 == 0) goto L_0x001a
            boolean r0 = r2.providersInvalid
            if (r0 != 0) goto L_0x001a
            androidx.compose.runtime.RecomposeScopeImpl r0 = r2.getCurrentRecomposeScope$runtime_release()
            if (r0 == 0) goto L_0x0018
            boolean r0 = r0.getDefaultsInvalid()
            if (r0 != r1) goto L_0x0018
            goto L_0x001a
        L_0x0018:
            r0 = 0
            return r0
        L_0x001a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.getDefaultsInvalid():boolean");
    }

    @ComposeCompilerApi
    public void startMovableGroup(int i, Object obj) {
        m3642startBaiHCIY(i, obj, GroupKind.Companion.m3652getGroupULZAiWs(), (Object) null);
    }

    @ComposeCompilerApi
    public void endMovableGroup() {
        endGroup();
    }

    private final void startRoot() {
        this.rGroupIndex = 0;
        this.reader = this.slotTable.openReader();
        startGroup(100);
        this.parentContext.startComposing$runtime_release();
        this.parentProvider = this.parentContext.getCompositionLocalScope$runtime_release();
        this.providersInvalidStack.push(ComposerKt.asInt(this.providersInvalid));
        this.providersInvalid = changed((Object) this.parentProvider);
        this.providerCache = null;
        if (!this.forceRecomposeScopes) {
            this.forceRecomposeScopes = this.parentContext.getCollectingParameterInformation$runtime_release();
        }
        if (!this.sourceMarkersEnabled) {
            this.sourceMarkersEnabled = this.parentContext.getCollectingSourceInformation$runtime_release();
        }
        Set set = (Set) CompositionLocalMapKt.read(this.parentProvider, InspectionTablesKt.getLocalInspectionTables());
        if (set != null) {
            set.add(this.slotTable);
            this.parentContext.recordInspectionTable$runtime_release(set);
        }
        startGroup(this.parentContext.getCompoundHashKey$runtime_release());
    }

    private final void endRoot() {
        endGroup();
        this.parentContext.doneComposing$runtime_release();
        endGroup();
        this.changeListWriter.endRoot();
        finalizeCompose();
        this.reader.close();
        this.forciblyRecompose = false;
        this.providersInvalid = ComposerKt.asBool(this.providersInvalidStack.pop());
    }

    private final void abortRoot() {
        cleanUpCompose();
        this.pendingStack.clear();
        this.parentStateStack.clear();
        this.entersStack.clear();
        this.providersInvalidStack.clear();
        this.providerUpdates = null;
        this.insertFixups.clear();
        this.compoundKeyHash = 0;
        this.childrenComposing = 0;
        this.nodeExpected = false;
        this.inserting = false;
        this.reusing = false;
        this.isComposing = false;
        this.forciblyRecompose = false;
        this.reusingGroup = -1;
        if (!this.reader.getClosed()) {
            this.reader.close();
        }
        if (!this.writer.getClosed()) {
            forceFreshInsertTable();
        }
    }

    public final void changesApplied$runtime_release() {
        this.providerUpdates = null;
    }

    public boolean getInserting() {
        return this.inserting;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        r0 = getCurrentRecomposeScope$runtime_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean getSkipping() {
        /*
            r1 = this;
            boolean r0 = r1.getInserting()
            if (r0 != 0) goto L_0x0020
            boolean r0 = r1.reusing
            if (r0 != 0) goto L_0x0020
            boolean r0 = r1.providersInvalid
            if (r0 != 0) goto L_0x0020
            androidx.compose.runtime.RecomposeScopeImpl r0 = r1.getCurrentRecomposeScope$runtime_release()
            if (r0 == 0) goto L_0x0020
            boolean r0 = r0.getRequiresRecompose()
            if (r0 != 0) goto L_0x0020
            boolean r0 = r1.forciblyRecompose
            if (r0 != 0) goto L_0x0020
            r0 = 1
            return r0
        L_0x0020:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.getSkipping():boolean");
    }

    public int getCompoundKeyHash() {
        return this.compoundKeyHash;
    }

    public void collectParameterInformation() {
        this.forceRecomposeScopes = true;
        this.sourceMarkersEnabled = true;
        this.slotTable.collectSourceInformation();
        this.insertTable.collectSourceInformation();
        this.writer.updateToTableMaps();
    }

    public final void dispose$runtime_release() {
        Object beginSection = Trace.INSTANCE.beginSection("Compose:Composer.dispose");
        try {
            this.parentContext.unregisterComposer$runtime_release(this);
            deactivate$runtime_release();
            getApplier().clear();
            this.isDisposed = true;
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.INSTANCE.endSection(beginSection);
        }
    }

    public final void deactivate$runtime_release() {
        this.invalidateStack.clear();
        this.invalidations.clear();
        this.changes.clear();
        this.providerUpdates = null;
    }

    public final boolean forceRecomposeScopes$runtime_release() {
        if (this.forceRecomposeScopes) {
            return false;
        }
        this.forceRecomposeScopes = true;
        this.forciblyRecompose = true;
        return true;
    }

    private final void startGroup(int i) {
        m3642startBaiHCIY(i, (Object) null, GroupKind.Companion.m3652getGroupULZAiWs(), (Object) null);
    }

    private final void startGroup(int i, Object obj) {
        m3642startBaiHCIY(i, obj, GroupKind.Companion.m3652getGroupULZAiWs(), (Object) null);
    }

    private final void endGroup() {
        end(false);
    }

    private final void skipGroup() {
        this.groupNodeCount += this.reader.skipGroup();
    }

    public void startNode() {
        m3642startBaiHCIY(125, (Object) null, GroupKind.Companion.m3653getNodeULZAiWs(), (Object) null);
        this.nodeExpected = true;
    }

    public void startReusableNode() {
        m3642startBaiHCIY(125, (Object) null, GroupKind.Companion.m3654getReusableNodeULZAiWs(), (Object) null);
        this.nodeExpected = true;
    }

    public <T> void createNode(Function0<? extends T> function0) {
        validateNodeExpected();
        if (!getInserting()) {
            ComposerKt.composeImmediateRuntimeError("createNode() can only be called when inserting");
        }
        int peek = this.parentStateStack.peek();
        SlotWriter slotWriter = this.writer;
        Anchor anchor = slotWriter.anchor(slotWriter.getParent());
        this.groupNodeCount++;
        this.insertFixups.createAndInsertNode(function0, peek, anchor);
    }

    public void useNode() {
        validateNodeExpected();
        if (getInserting()) {
            ComposerKt.composeImmediateRuntimeError("useNode() called while inserting");
        }
        Object node = getNode(this.reader);
        this.changeListWriter.moveDown(node);
        if (this.reusing && (node instanceof ComposeNodeLifecycleCallback)) {
            this.changeListWriter.useNode(node);
        }
    }

    public void endNode() {
        end(true);
    }

    public void startReusableGroup(int i, Object obj) {
        if (!getInserting() && this.reader.getGroupKey() == i && !Intrinsics.areEqual(this.reader.getGroupAux(), obj) && this.reusingGroup < 0) {
            this.reusingGroup = this.reader.getCurrentGroup();
            this.reusing = true;
        }
        m3642startBaiHCIY(i, (Object) null, GroupKind.Companion.m3652getGroupULZAiWs(), obj);
    }

    public void endReusableGroup() {
        if (this.reusing && this.reader.getParent() == this.reusingGroup) {
            this.reusingGroup = -1;
            this.reusing = false;
        }
        end(false);
    }

    public void disableReusing() {
        this.reusing = false;
    }

    public void enableReusing() {
        this.reusing = this.reusingGroup >= 0;
    }

    public final void startReuseFromRoot() {
        this.reusingGroup = 100;
        this.reusing = true;
    }

    public final void endReuseFromRoot() {
        if (!(!this.isComposing && this.reusingGroup == 100)) {
            PreconditionsKt.throwIllegalArgumentException("Cannot disable reuse from root if it was caused by other groups");
        }
        this.reusingGroup = -1;
        this.reusing = false;
    }

    public int getCurrentMarker() {
        return getInserting() ? -this.writer.getParent() : this.reader.getParent();
    }

    public void endToMarker(int i) {
        if (i < 0) {
            int i2 = -i;
            SlotWriter slotWriter = this.writer;
            while (true) {
                int parent = slotWriter.getParent();
                if (parent > i2) {
                    end(slotWriter.isNode(parent));
                } else {
                    return;
                }
            }
        } else {
            if (getInserting()) {
                SlotWriter slotWriter2 = this.writer;
                while (getInserting()) {
                    end(slotWriter2.isNode(slotWriter2.getParent()));
                }
            }
            SlotReader slotReader = this.reader;
            while (true) {
                int parent2 = slotReader.getParent();
                if (parent2 > i) {
                    end(slotReader.isNode(parent2));
                } else {
                    return;
                }
            }
        }
    }

    public <V, T> void apply(V v, Function2<? super T, ? super V, Unit> function2) {
        if (getInserting()) {
            this.insertFixups.updateNode(v, function2);
        } else {
            this.changeListWriter.updateNode(v, function2);
        }
    }

    @ComposeCompilerApi
    public Object joinKey(Object obj, Object obj2) {
        Object access$getKey = ComposerKt.getKey(this.reader.getGroupObjectKey(), obj, obj2);
        return access$getKey == null ? new JoinedKey(obj, obj2) : access$getKey;
    }

    public final Object nextSlot() {
        if (getInserting()) {
            validateNodeNotExpected();
            return Composer.Companion.getEmpty();
        }
        Object next = this.reader.next();
        return (!this.reusing || (next instanceof ReusableRememberObserver)) ? next : Composer.Companion.getEmpty();
    }

    public final Object nextSlotForCache() {
        if (getInserting()) {
            validateNodeNotExpected();
            return Composer.Companion.getEmpty();
        }
        Object next = this.reader.next();
        if (!this.reusing || (next instanceof ReusableRememberObserver)) {
            return next instanceof RememberObserverHolder ? ((RememberObserverHolder) next).getWrapped() : next;
        }
        return Composer.Companion.getEmpty();
    }

    @ComposeCompilerApi
    public boolean changed(Object obj) {
        if (Intrinsics.areEqual(nextSlot(), obj)) {
            return false;
        }
        updateValue(obj);
        return true;
    }

    @ComposeCompilerApi
    public boolean changedInstance(Object obj) {
        if (nextSlot() == obj) {
            return false;
        }
        updateValue(obj);
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(char c) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Character) && c == ((Character) nextSlot).charValue()) {
            return false;
        }
        updateValue(Character.valueOf(c));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(byte b) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Byte) && b == ((Number) nextSlot).byteValue()) {
            return false;
        }
        updateValue(Byte.valueOf(b));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(short s) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Short) && s == ((Number) nextSlot).shortValue()) {
            return false;
        }
        updateValue(Short.valueOf(s));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(boolean z) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Boolean) && z == ((Boolean) nextSlot).booleanValue()) {
            return false;
        }
        updateValue(Boolean.valueOf(z));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(float f) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Float) && f == ((Number) nextSlot).floatValue()) {
            return false;
        }
        updateValue(Float.valueOf(f));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(long j) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Long) && j == ((Number) nextSlot).longValue()) {
            return false;
        }
        updateValue(Long.valueOf(j));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(double d) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Double) && d == ((Number) nextSlot).doubleValue()) {
            return false;
        }
        updateValue(Double.valueOf(d));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(int i) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Integer) && i == ((Number) nextSlot).intValue()) {
            return false;
        }
        updateValue(Integer.valueOf(i));
        return true;
    }

    @ComposeCompilerApi
    public final <T> T cache(boolean z, Function0<? extends T> function0) {
        T nextSlotForCache = nextSlotForCache();
        if (nextSlotForCache != Composer.Companion.getEmpty() && !z) {
            return nextSlotForCache;
        }
        T invoke = function0.invoke();
        updateCachedValue(invoke);
        return invoke;
    }

    private final void updateSlot(Object obj) {
        nextSlot();
        updateValue(obj);
    }

    public final void updateValue(Object obj) {
        if (getInserting()) {
            this.writer.update(obj);
        } else if (this.reader.getHadNext()) {
            int groupSlotIndex = this.reader.getGroupSlotIndex() - 1;
            if (this.changeListWriter.getPastParent()) {
                ComposerChangeListWriter composerChangeListWriter = this.changeListWriter;
                SlotReader slotReader = this.reader;
                composerChangeListWriter.updateAnchoredValue(obj, slotReader.anchor(slotReader.getParent()), groupSlotIndex);
                return;
            }
            this.changeListWriter.updateValue(obj, groupSlotIndex);
        } else {
            ComposerChangeListWriter composerChangeListWriter2 = this.changeListWriter;
            SlotReader slotReader2 = this.reader;
            composerChangeListWriter2.appendValue(slotReader2.anchor(slotReader2.getParent()), obj);
        }
    }

    public final void updateCachedValue(Object obj) {
        if (obj instanceof RememberObserver) {
            if (getInserting()) {
                this.changeListWriter.remember((RememberObserver) obj);
            }
            this.abandonSet.add(obj);
            obj = new RememberObserverHolder((RememberObserver) obj, rememberObserverAnchor());
        }
        updateValue(obj);
    }

    private final Anchor rememberObserverAnchor() {
        int i;
        int i2;
        if (getInserting()) {
            if (!ComposerKt.isAfterFirstChild(this.writer)) {
                return null;
            }
            int currentGroup = this.writer.getCurrentGroup() - 1;
            int parent = this.writer.parent(currentGroup);
            while (true) {
                int i3 = parent;
                i2 = currentGroup;
                currentGroup = i3;
                if (currentGroup != this.writer.getParent() && currentGroup >= 0) {
                    parent = this.writer.parent(currentGroup);
                }
            }
            return this.writer.anchor(i2);
        } else if (!ComposerKt.isAfterFirstChild(this.reader)) {
            return null;
        } else {
            int currentGroup2 = this.reader.getCurrentGroup() - 1;
            int parent2 = this.reader.parent(currentGroup2);
            while (true) {
                int i4 = parent2;
                i = currentGroup2;
                currentGroup2 = i4;
                if (currentGroup2 != this.reader.getParent() && currentGroup2 >= 0) {
                    parent2 = this.reader.parent(currentGroup2);
                }
            }
            return this.reader.anchor(i);
        }
    }

    public CompositionData getCompositionData() {
        return this.slotTable;
    }

    public void recordSideEffect(Function0<Unit> function0) {
        this.changeListWriter.sideEffect(function0);
    }

    private final PersistentCompositionLocalMap currentCompositionLocalScope() {
        PersistentCompositionLocalMap persistentCompositionLocalMap = this.providerCache;
        if (persistentCompositionLocalMap != null) {
            return persistentCompositionLocalMap;
        }
        return currentCompositionLocalScope(this.reader.getParent());
    }

    public CompositionLocalMap getCurrentCompositionLocalMap() {
        return currentCompositionLocalScope();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: androidx.compose.runtime.PersistentCompositionLocalMap} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.runtime.PersistentCompositionLocalMap currentCompositionLocalScope(int r6) {
        /*
            r5 = this;
            boolean r0 = r5.getInserting()
            java.lang.String r1 = "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap"
            r2 = 202(0xca, float:2.83E-43)
            if (r0 == 0) goto L_0x0043
            boolean r0 = r5.writerHasAProvider
            if (r0 == 0) goto L_0x0043
            androidx.compose.runtime.SlotWriter r0 = r5.writer
            int r0 = r0.getParent()
        L_0x0014:
            if (r0 <= 0) goto L_0x0043
            androidx.compose.runtime.SlotWriter r3 = r5.writer
            int r3 = r3.groupKey(r0)
            if (r3 != r2) goto L_0x003c
            androidx.compose.runtime.SlotWriter r3 = r5.writer
            java.lang.Object r3 = r3.groupObjectKey(r0)
            java.lang.Object r4 = androidx.compose.runtime.ComposerKt.getCompositionLocalMap()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x003c
            androidx.compose.runtime.SlotWriter r6 = r5.writer
            java.lang.Object r6 = r6.groupAux(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r1)
            androidx.compose.runtime.PersistentCompositionLocalMap r6 = (androidx.compose.runtime.PersistentCompositionLocalMap) r6
            r5.providerCache = r6
            return r6
        L_0x003c:
            androidx.compose.runtime.SlotWriter r3 = r5.writer
            int r0 = r3.parent((int) r0)
            goto L_0x0014
        L_0x0043:
            androidx.compose.runtime.SlotReader r0 = r5.reader
            int r0 = r0.getSize()
            if (r0 <= 0) goto L_0x0087
        L_0x004b:
            if (r6 <= 0) goto L_0x0087
            androidx.compose.runtime.SlotReader r0 = r5.reader
            int r0 = r0.groupKey((int) r6)
            if (r0 != r2) goto L_0x0080
            androidx.compose.runtime.SlotReader r0 = r5.reader
            java.lang.Object r0 = r0.groupObjectKey(r6)
            java.lang.Object r3 = androidx.compose.runtime.ComposerKt.getCompositionLocalMap()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            if (r0 == 0) goto L_0x0080
            androidx.compose.runtime.collection.IntMap<androidx.compose.runtime.PersistentCompositionLocalMap> r0 = r5.providerUpdates
            if (r0 == 0) goto L_0x0071
            java.lang.Object r0 = r0.get(r6)
            androidx.compose.runtime.PersistentCompositionLocalMap r0 = (androidx.compose.runtime.PersistentCompositionLocalMap) r0
            if (r0 != 0) goto L_0x007d
        L_0x0071:
            androidx.compose.runtime.SlotReader r0 = r5.reader
            java.lang.Object r6 = r0.groupAux(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r1)
            r0 = r6
            androidx.compose.runtime.PersistentCompositionLocalMap r0 = (androidx.compose.runtime.PersistentCompositionLocalMap) r0
        L_0x007d:
            r5.providerCache = r0
            return r0
        L_0x0080:
            androidx.compose.runtime.SlotReader r0 = r5.reader
            int r6 = r0.parent(r6)
            goto L_0x004b
        L_0x0087:
            androidx.compose.runtime.PersistentCompositionLocalMap r6 = r5.parentProvider
            r5.providerCache = r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.currentCompositionLocalScope(int):androidx.compose.runtime.PersistentCompositionLocalMap");
    }

    public void startProvider(ProvidedValue<?> providedValue) {
        ValueHolder valueHolder;
        PersistentCompositionLocalMap persistentCompositionLocalMap;
        PersistentCompositionLocalMap currentCompositionLocalScope = currentCompositionLocalScope();
        startGroup(ComposerKt.providerKey, ComposerKt.getProvider());
        Object rememberedValue = rememberedValue();
        if (Intrinsics.areEqual(rememberedValue, Composer.Companion.getEmpty())) {
            valueHolder = null;
        } else {
            Intrinsics.checkNotNull(rememberedValue, "null cannot be cast to non-null type androidx.compose.runtime.ValueHolder<kotlin.Any?>");
            valueHolder = (ValueHolder) rememberedValue;
        }
        CompositionLocal<?> compositionLocal = providedValue.getCompositionLocal();
        Intrinsics.checkNotNull(compositionLocal, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
        Intrinsics.checkNotNull(providedValue, "null cannot be cast to non-null type androidx.compose.runtime.ProvidedValue<kotlin.Any?>");
        ValueHolder<?> updatedStateOf$runtime_release = compositionLocal.updatedStateOf$runtime_release(providedValue, valueHolder);
        boolean areEqual = Intrinsics.areEqual((Object) updatedStateOf$runtime_release, (Object) valueHolder);
        if (!areEqual) {
            updateRememberedValue(updatedStateOf$runtime_release);
        }
        boolean z = true;
        boolean z2 = false;
        if (getInserting()) {
            if (providedValue.getCanOverride() || !CompositionLocalMapKt.contains(currentCompositionLocalScope, compositionLocal)) {
                currentCompositionLocalScope = currentCompositionLocalScope.putValue(compositionLocal, updatedStateOf$runtime_release);
            }
            this.writerHasAProvider = true;
        } else {
            SlotReader slotReader = this.reader;
            Object groupAux = slotReader.groupAux(slotReader.getCurrentGroup());
            Intrinsics.checkNotNull(groupAux, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap persistentCompositionLocalMap2 = (PersistentCompositionLocalMap) groupAux;
            if ((!getSkipping() || !areEqual) && (providedValue.getCanOverride() || !CompositionLocalMapKt.contains(currentCompositionLocalScope, compositionLocal))) {
                persistentCompositionLocalMap = currentCompositionLocalScope.putValue(compositionLocal, updatedStateOf$runtime_release);
            } else {
                persistentCompositionLocalMap = persistentCompositionLocalMap2;
            }
            if (!this.reusing && persistentCompositionLocalMap2 == persistentCompositionLocalMap) {
                z = false;
            }
            z2 = z;
        }
        if (z2 && !getInserting()) {
            recordProviderUpdate(persistentCompositionLocalMap);
        }
        this.providersInvalidStack.push(ComposerKt.asInt(this.providersInvalid));
        this.providersInvalid = z2;
        this.providerCache = persistentCompositionLocalMap;
        m3642startBaiHCIY(ComposerKt.compositionLocalMapKey, ComposerKt.getCompositionLocalMap(), GroupKind.Companion.m3652getGroupULZAiWs(), persistentCompositionLocalMap);
    }

    private final void recordProviderUpdate(PersistentCompositionLocalMap persistentCompositionLocalMap) {
        IntMap<PersistentCompositionLocalMap> intMap = this.providerUpdates;
        if (intMap == null) {
            ComposerImpl composerImpl = this;
            intMap = new IntMap<>(0, 1, (DefaultConstructorMarker) null);
            this.providerUpdates = intMap;
        }
        intMap.set(this.reader.getCurrentGroup(), persistentCompositionLocalMap);
    }

    public void endProvider() {
        endGroup();
        endGroup();
        this.providersInvalid = ComposerKt.asBool(this.providersInvalidStack.pop());
        this.providerCache = null;
    }

    public void startProviders(ProvidedValue<?>[] providedValueArr) {
        PersistentCompositionLocalMap persistentCompositionLocalMap;
        PersistentCompositionLocalMap currentCompositionLocalScope = currentCompositionLocalScope();
        startGroup(ComposerKt.providerKey, ComposerKt.getProvider());
        boolean z = true;
        boolean z2 = false;
        if (getInserting()) {
            persistentCompositionLocalMap = updateProviderMapGroup(currentCompositionLocalScope, CompositionLocalMapKt.updateCompositionMap$default(providedValueArr, currentCompositionLocalScope, (PersistentCompositionLocalMap) null, 4, (Object) null));
            this.writerHasAProvider = true;
        } else {
            Object groupGet = this.reader.groupGet(0);
            Intrinsics.checkNotNull(groupGet, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap persistentCompositionLocalMap2 = (PersistentCompositionLocalMap) groupGet;
            Object groupGet2 = this.reader.groupGet(1);
            Intrinsics.checkNotNull(groupGet2, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap persistentCompositionLocalMap3 = (PersistentCompositionLocalMap) groupGet2;
            PersistentCompositionLocalMap updateCompositionMap = CompositionLocalMapKt.updateCompositionMap(providedValueArr, currentCompositionLocalScope, persistentCompositionLocalMap3);
            if (!getSkipping() || this.reusing || !Intrinsics.areEqual((Object) persistentCompositionLocalMap3, (Object) updateCompositionMap)) {
                persistentCompositionLocalMap = updateProviderMapGroup(currentCompositionLocalScope, updateCompositionMap);
                if (!this.reusing && Intrinsics.areEqual((Object) persistentCompositionLocalMap, (Object) persistentCompositionLocalMap2)) {
                    z = false;
                }
                z2 = z;
            } else {
                skipGroup();
                persistentCompositionLocalMap = persistentCompositionLocalMap2;
            }
        }
        if (z2 && !getInserting()) {
            recordProviderUpdate(persistentCompositionLocalMap);
        }
        this.providersInvalidStack.push(ComposerKt.asInt(this.providersInvalid));
        this.providersInvalid = z2;
        this.providerCache = persistentCompositionLocalMap;
        m3642startBaiHCIY(ComposerKt.compositionLocalMapKey, ComposerKt.getCompositionLocalMap(), GroupKind.Companion.m3652getGroupULZAiWs(), persistentCompositionLocalMap);
    }

    public void endProviders() {
        endGroup();
        endGroup();
        this.providersInvalid = ComposerKt.asBool(this.providersInvalidStack.pop());
        this.providerCache = null;
    }

    public <T> T consume(CompositionLocal<T> compositionLocal) {
        return CompositionLocalMapKt.read(currentCompositionLocalScope(), compositionLocal);
    }

    public CompositionContext buildContext() {
        startGroup(ComposerKt.referenceKey, ComposerKt.getReference());
        CompositionObserverHolder compositionObserverHolder = null;
        if (getInserting()) {
            SlotWriter.markGroup$default(this.writer, 0, 1, (Object) null);
        }
        Object nextSlot = nextSlot();
        CompositionContextHolder compositionContextHolder = nextSlot instanceof CompositionContextHolder ? (CompositionContextHolder) nextSlot : null;
        if (compositionContextHolder == null) {
            int compoundKeyHash2 = getCompoundKeyHash();
            boolean z = this.forceRecomposeScopes;
            boolean z2 = this.sourceMarkersEnabled;
            ControlledComposition composition2 = getComposition();
            CompositionImpl compositionImpl = composition2 instanceof CompositionImpl ? (CompositionImpl) composition2 : null;
            if (compositionImpl != null) {
                compositionObserverHolder = compositionImpl.getObserverHolder$runtime_release();
            }
            compositionContextHolder = new CompositionContextHolder(new CompositionContextImpl(compoundKeyHash2, z, z2, compositionObserverHolder));
            updateValue(compositionContextHolder);
        }
        compositionContextHolder.getRef().updateCompositionLocalScope(currentCompositionLocalScope());
        endGroup();
        return compositionContextHolder.getRef();
    }

    public final int getChangeCount$runtime_release() {
        return this.changes.getSize();
    }

    public final RecomposeScopeImpl getCurrentRecomposeScope$runtime_release() {
        Stack<RecomposeScopeImpl> stack = this.invalidateStack;
        if (this.childrenComposing != 0 || !stack.isNotEmpty()) {
            return null;
        }
        return stack.peek();
    }

    private final void ensureWriter() {
        if (this.writer.getClosed()) {
            SlotWriter openWriter = this.insertTable.openWriter();
            this.writer = openWriter;
            openWriter.skipToGroupEnd();
            this.writerHasAProvider = false;
            this.providerCache = null;
        }
    }

    private final void createFreshInsertTable() {
        ComposerKt.runtimeCheck(this.writer.getClosed());
        forceFreshInsertTable();
    }

    private final void forceFreshInsertTable() {
        SlotTable slotTable2 = new SlotTable();
        if (this.sourceMarkersEnabled) {
            slotTable2.collectSourceInformation();
        }
        if (this.parentContext.getCollectingCallByInformation$runtime_release()) {
            slotTable2.collectCalledByInformation();
        }
        this.insertTable = slotTable2;
        SlotWriter openWriter = slotTable2.openWriter();
        openWriter.close(true);
        this.writer = openWriter;
    }

    private final void startReaderGroup(boolean z, Object obj) {
        if (z) {
            this.reader.startNode();
            return;
        }
        if (!(obj == null || this.reader.getGroupAux() == obj)) {
            this.changeListWriter.updateAuxData(obj);
        }
        this.reader.startGroup();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00db  */
    /* renamed from: start-BaiHCIY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m3642startBaiHCIY(int r13, java.lang.Object r14, int r15, java.lang.Object r16) {
        /*
            r12 = this;
            r0 = r14
            r2 = r15
            r3 = r16
            r12.validateNodeNotExpected()
            int r4 = r12.rGroupIndex
            r5 = 3
            if (r0 != 0) goto L_0x0042
            if (r3 == 0) goto L_0x0033
            r6 = 207(0xcf, float:2.9E-43)
            if (r13 != r6) goto L_0x0033
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r6)
            if (r6 != 0) goto L_0x0033
            int r6 = r3.hashCode()
            int r7 = r12.getCompoundKeyHash()
            int r7 = java.lang.Integer.rotateLeft(r7, r5)
            r6 = r6 ^ r7
            int r5 = java.lang.Integer.rotateLeft(r6, r5)
            r4 = r4 ^ r5
            r12.compoundKeyHash = r4
            goto L_0x0061
        L_0x0033:
            int r6 = r12.getCompoundKeyHash()
            int r6 = java.lang.Integer.rotateLeft(r6, r5)
            r6 = r6 ^ r13
            int r5 = java.lang.Integer.rotateLeft(r6, r5)
            r4 = r4 ^ r5
            goto L_0x005f
        L_0x0042:
            boolean r4 = r0 instanceof java.lang.Enum
            if (r4 == 0) goto L_0x004e
            r4 = r0
            java.lang.Enum r4 = (java.lang.Enum) r4
            int r4 = r4.ordinal()
            goto L_0x0052
        L_0x004e:
            int r4 = r14.hashCode()
        L_0x0052:
            int r6 = r12.getCompoundKeyHash()
            int r6 = java.lang.Integer.rotateLeft(r6, r5)
            r4 = r4 ^ r6
            int r4 = java.lang.Integer.rotateLeft(r4, r5)
        L_0x005f:
            r12.compoundKeyHash = r4
        L_0x0061:
            r4 = 1
            if (r0 != 0) goto L_0x0069
            int r5 = r12.rGroupIndex
            int r5 = r5 + r4
            r12.rGroupIndex = r5
        L_0x0069:
            androidx.compose.runtime.GroupKind$Companion r5 = androidx.compose.runtime.GroupKind.Companion
            int r5 = r5.m3652getGroupULZAiWs()
            r6 = 0
            if (r2 == r5) goto L_0x0074
            r7 = r4
            goto L_0x0075
        L_0x0074:
            r7 = r6
        L_0x0075:
            boolean r5 = r12.getInserting()
            r8 = -1
            r9 = 0
            if (r5 == 0) goto L_0x00db
            androidx.compose.runtime.SlotReader r2 = r12.reader
            r2.beginEmpty()
            androidx.compose.runtime.SlotWriter r2 = r12.writer
            int r2 = r2.getCurrentGroup()
            if (r7 == 0) goto L_0x0096
            androidx.compose.runtime.SlotWriter r0 = r12.writer
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            r0.startNode(r13, r3)
            goto L_0x00b3
        L_0x0096:
            if (r3 == 0) goto L_0x00a6
            androidx.compose.runtime.SlotWriter r4 = r12.writer
            if (r0 != 0) goto L_0x00a2
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
        L_0x00a2:
            r4.startData(r13, r0, r3)
            goto L_0x00b3
        L_0x00a6:
            androidx.compose.runtime.SlotWriter r3 = r12.writer
            if (r0 != 0) goto L_0x00b0
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
        L_0x00b0:
            r3.startGroup(r13, r0)
        L_0x00b3:
            androidx.compose.runtime.Pending r6 = r12.pending
            if (r6 == 0) goto L_0x00d7
            androidx.compose.runtime.KeyInfo r0 = new androidx.compose.runtime.KeyInfo
            java.lang.Integer r3 = java.lang.Integer.valueOf(r8)
            int r2 = r12.insertedGroupVirtualIndex(r2)
            r4 = -1
            r5 = 0
            r1 = r3
            r3 = r2
            r2 = r1
            r1 = r13
            r0.<init>(r1, r2, r3, r4, r5)
            int r1 = r12.nodeIndex
            int r2 = r6.getStartIndex()
            int r1 = r1 - r2
            r6.registerInsert(r0, r1)
            r6.recordUsed(r0)
        L_0x00d7:
            r12.enterGroup(r7, r9)
            return
        L_0x00db:
            androidx.compose.runtime.GroupKind$Companion r5 = androidx.compose.runtime.GroupKind.Companion
            int r5 = r5.m3653getNodeULZAiWs()
            if (r2 == r5) goto L_0x00e4
            goto L_0x00ea
        L_0x00e4:
            boolean r2 = r12.reusing
            if (r2 == 0) goto L_0x00ea
            r2 = r4
            goto L_0x00eb
        L_0x00ea:
            r2 = r6
        L_0x00eb:
            androidx.compose.runtime.Pending r5 = r12.pending
            if (r5 != 0) goto L_0x0118
            androidx.compose.runtime.SlotReader r5 = r12.reader
            int r5 = r5.getGroupKey()
            if (r2 != 0) goto L_0x0109
            if (r5 != r13) goto L_0x0109
            androidx.compose.runtime.SlotReader r5 = r12.reader
            java.lang.Object r5 = r5.getGroupObjectKey()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0109
            r12.startReaderGroup(r7, r3)
            goto L_0x0118
        L_0x0109:
            androidx.compose.runtime.Pending r5 = new androidx.compose.runtime.Pending
            androidx.compose.runtime.SlotReader r10 = r12.reader
            java.util.List r10 = r10.extractKeys()
            int r11 = r12.nodeIndex
            r5.<init>(r10, r11)
            r12.pending = r5
        L_0x0118:
            androidx.compose.runtime.Pending r10 = r12.pending
            if (r10 == 0) goto L_0x01d8
            androidx.compose.runtime.KeyInfo r5 = r10.getNext(r13, r14)
            if (r2 != 0) goto L_0x015d
            if (r5 == 0) goto L_0x015d
            r10.recordUsed(r5)
            int r0 = r5.getLocation()
            int r1 = r10.nodePositionOf(r5)
            int r2 = r10.getStartIndex()
            int r1 = r1 + r2
            r12.nodeIndex = r1
            int r1 = r10.slotPositionOf(r5)
            int r2 = r10.getGroupIndex()
            int r2 = r1 - r2
            int r4 = r10.getGroupIndex()
            r10.registerMoveSlot(r1, r4)
            androidx.compose.runtime.changelist.ComposerChangeListWriter r1 = r12.changeListWriter
            r1.moveReaderRelativeTo(r0)
            androidx.compose.runtime.SlotReader r1 = r12.reader
            r1.reposition(r0)
            if (r2 <= 0) goto L_0x0158
            androidx.compose.runtime.changelist.ComposerChangeListWriter r0 = r12.changeListWriter
            r0.moveCurrentGroup(r2)
        L_0x0158:
            r12.startReaderGroup(r7, r3)
            goto L_0x01d8
        L_0x015d:
            androidx.compose.runtime.SlotReader r2 = r12.reader
            r2.beginEmpty()
            r12.inserting = r4
            r12.providerCache = r9
            r12.ensureWriter()
            androidx.compose.runtime.SlotWriter r2 = r12.writer
            r2.beginInsert()
            androidx.compose.runtime.SlotWriter r2 = r12.writer
            int r2 = r2.getCurrentGroup()
            if (r7 == 0) goto L_0x0182
            androidx.compose.runtime.SlotWriter r0 = r12.writer
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            r0.startNode(r13, r3)
            goto L_0x019f
        L_0x0182:
            if (r3 == 0) goto L_0x0192
            androidx.compose.runtime.SlotWriter r4 = r12.writer
            if (r0 != 0) goto L_0x018e
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
        L_0x018e:
            r4.startData(r13, r0, r3)
            goto L_0x019f
        L_0x0192:
            androidx.compose.runtime.SlotWriter r3 = r12.writer
            if (r0 != 0) goto L_0x019c
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
        L_0x019c:
            r3.startGroup(r13, r0)
        L_0x019f:
            androidx.compose.runtime.SlotWriter r0 = r12.writer
            androidx.compose.runtime.Anchor r0 = r0.anchor(r2)
            r12.insertAnchor = r0
            androidx.compose.runtime.KeyInfo r0 = new androidx.compose.runtime.KeyInfo
            java.lang.Integer r3 = java.lang.Integer.valueOf(r8)
            int r2 = r12.insertedGroupVirtualIndex(r2)
            r4 = -1
            r5 = 0
            r1 = r3
            r3 = r2
            r2 = r1
            r1 = r13
            r0.<init>(r1, r2, r3, r4, r5)
            int r1 = r12.nodeIndex
            int r2 = r10.getStartIndex()
            int r1 = r1 - r2
            r10.registerInsert(r0, r1)
            r10.recordUsed(r0)
            androidx.compose.runtime.Pending r9 = new androidx.compose.runtime.Pending
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            if (r7 == 0) goto L_0x01d3
            goto L_0x01d5
        L_0x01d3:
            int r6 = r12.nodeIndex
        L_0x01d5:
            r9.<init>(r0, r6)
        L_0x01d8:
            r12.enterGroup(r7, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.m3642startBaiHCIY(int, java.lang.Object, int, java.lang.Object):void");
    }

    private final void enterGroup(boolean z, Pending pending2) {
        this.pendingStack.push(this.pending);
        this.pending = pending2;
        this.parentStateStack.push(this.groupNodeCount);
        this.parentStateStack.push(this.rGroupIndex);
        this.parentStateStack.push(this.nodeIndex);
        if (z) {
            this.nodeIndex = 0;
        }
        this.groupNodeCount = 0;
        this.rGroupIndex = 0;
    }

    private final void exitGroup(int i, boolean z) {
        Pending pop = this.pendingStack.pop();
        if (pop != null && !z) {
            pop.setGroupIndex(pop.getGroupIndex() + 1);
        }
        this.pending = pop;
        this.nodeIndex = this.parentStateStack.pop() + i;
        this.rGroupIndex = this.parentStateStack.pop();
        this.groupNodeCount = this.parentStateStack.pop() + i;
    }

    private final void end(boolean z) {
        List<KeyInfo> list;
        List<KeyInfo> list2;
        int i;
        int i2;
        int i3;
        int i4;
        int peek2 = this.parentStateStack.peek2() - 1;
        if (getInserting()) {
            int parent = this.writer.getParent();
            int groupKey = this.writer.groupKey(parent);
            Object groupObjectKey = this.writer.groupObjectKey(parent);
            Object groupAux = this.writer.groupAux(parent);
            if (groupObjectKey != null) {
                if (groupObjectKey instanceof Enum) {
                    i4 = ((Enum) groupObjectKey).ordinal();
                } else {
                    i4 = groupObjectKey.hashCode();
                }
                i3 = Integer.hashCode(i4) ^ Integer.rotateRight(getCompoundKeyHash(), 3);
            } else if (groupAux == null || groupKey != 207 || Intrinsics.areEqual(groupAux, Composer.Companion.getEmpty())) {
                i3 = Integer.rotateRight(peek2 ^ getCompoundKeyHash(), 3) ^ Integer.hashCode(groupKey);
            } else {
                this.compoundKeyHash = Integer.rotateRight(Integer.rotateRight(peek2 ^ getCompoundKeyHash(), 3) ^ Integer.hashCode(groupAux.hashCode()), 3);
            }
            this.compoundKeyHash = Integer.rotateRight(i3, 3);
        } else {
            int parent2 = this.reader.getParent();
            int groupKey2 = this.reader.groupKey(parent2);
            Object groupObjectKey2 = this.reader.groupObjectKey(parent2);
            Object groupAux2 = this.reader.groupAux(parent2);
            if (groupObjectKey2 != null) {
                if (groupObjectKey2 instanceof Enum) {
                    i2 = ((Enum) groupObjectKey2).ordinal();
                } else {
                    i2 = groupObjectKey2.hashCode();
                }
                i = Integer.hashCode(i2) ^ Integer.rotateRight(getCompoundKeyHash(), 3);
            } else if (groupAux2 == null || groupKey2 != 207 || Intrinsics.areEqual(groupAux2, Composer.Companion.getEmpty())) {
                i = Integer.rotateRight(peek2 ^ getCompoundKeyHash(), 3) ^ Integer.hashCode(groupKey2);
            } else {
                this.compoundKeyHash = Integer.rotateRight(Integer.rotateRight(peek2 ^ getCompoundKeyHash(), 3) ^ Integer.hashCode(groupAux2.hashCode()), 3);
            }
            this.compoundKeyHash = Integer.rotateRight(i, 3);
        }
        int i5 = this.groupNodeCount;
        Pending pending2 = this.pending;
        if (pending2 != null && pending2.getKeyInfos().size() > 0) {
            List<KeyInfo> keyInfos = pending2.getKeyInfos();
            List<KeyInfo> used = pending2.getUsed();
            Set<T> fastToSet = ListUtilsKt.fastToSet(used);
            Set linkedHashSet = new LinkedHashSet();
            int size = used.size();
            int size2 = keyInfos.size();
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (i6 < size2) {
                KeyInfo keyInfo = keyInfos.get(i6);
                if (!fastToSet.contains(keyInfo)) {
                    this.changeListWriter.removeNode(pending2.nodePositionOf(keyInfo) + pending2.getStartIndex(), keyInfo.getNodes());
                    pending2.updateNodeCount(keyInfo.getLocation(), 0);
                    this.changeListWriter.moveReaderRelativeTo(keyInfo.getLocation());
                    this.reader.reposition(keyInfo.getLocation());
                    recordDelete();
                    this.reader.skipGroup();
                    list = keyInfos;
                    ComposerKt.removeRange(this.invalidations, keyInfo.getLocation(), keyInfo.getLocation() + this.reader.groupSize(keyInfo.getLocation()));
                } else {
                    list = keyInfos;
                    if (!linkedHashSet.contains(keyInfo)) {
                        if (i7 < size) {
                            KeyInfo keyInfo2 = used.get(i7);
                            if (keyInfo2 != keyInfo) {
                                int nodePositionOf = pending2.nodePositionOf(keyInfo2);
                                linkedHashSet.add(keyInfo2);
                                if (nodePositionOf != i8) {
                                    int updatedNodeCountOf = pending2.updatedNodeCountOf(keyInfo2);
                                    list2 = used;
                                    this.changeListWriter.moveNode(pending2.getStartIndex() + nodePositionOf, i8 + pending2.getStartIndex(), updatedNodeCountOf);
                                    pending2.registerMoveNode(nodePositionOf, i8, updatedNodeCountOf);
                                } else {
                                    list2 = used;
                                }
                            } else {
                                list2 = used;
                                i6++;
                            }
                            i7++;
                            i8 += pending2.updatedNodeCountOf(keyInfo2);
                            keyInfos = list;
                            used = list2;
                        }
                        keyInfos = list;
                    }
                }
                i6++;
                keyInfos = list;
            }
            this.changeListWriter.endNodeMovement();
            if (keyInfos.size() > 0) {
                this.changeListWriter.moveReaderRelativeTo(this.reader.getGroupEnd());
                this.reader.skipToGroupEnd();
            }
        }
        int i9 = this.nodeIndex;
        while (!this.reader.isGroupEnd()) {
            int currentGroup = this.reader.getCurrentGroup();
            recordDelete();
            this.changeListWriter.removeNode(i9, this.reader.skipGroup());
            ComposerKt.removeRange(this.invalidations, currentGroup, this.reader.getCurrentGroup());
        }
        boolean inserting2 = getInserting();
        if (inserting2) {
            if (z) {
                this.insertFixups.endNodeInsert();
                i5 = 1;
            }
            this.reader.endEmpty();
            int parent3 = this.writer.getParent();
            this.writer.endGroup();
            if (!this.reader.getInEmpty()) {
                int insertedGroupVirtualIndex = insertedGroupVirtualIndex(parent3);
                this.writer.endInsert();
                this.writer.close(true);
                recordInsert(this.insertAnchor);
                this.inserting = false;
                if (!this.slotTable.isEmpty()) {
                    updateNodeCount(insertedGroupVirtualIndex, 0);
                    updateNodeCountOverrides(insertedGroupVirtualIndex, i5);
                }
            }
        } else {
            if (z) {
                this.changeListWriter.moveUp();
            }
            int remainingSlots = this.reader.getRemainingSlots();
            if (remainingSlots > 0) {
                this.changeListWriter.trimValues(remainingSlots);
            }
            this.changeListWriter.endCurrentGroup();
            int parent4 = this.reader.getParent();
            if (i5 != updatedNodeCount(parent4)) {
                updateNodeCountOverrides(parent4, i5);
            }
            if (z) {
                i5 = 1;
            }
            this.reader.endGroup();
            this.changeListWriter.endNodeMovement();
        }
        exitGroup(i5, inserting2);
    }

    private final void recomposeToGroupEnd() {
        boolean z = this.isComposing;
        this.isComposing = true;
        int parent = this.reader.getParent();
        int groupSize = this.reader.groupSize(parent) + parent;
        int i = this.nodeIndex;
        int compoundKeyHash2 = getCompoundKeyHash();
        int i2 = this.groupNodeCount;
        int i3 = this.rGroupIndex;
        Invalidation access$firstInRange = ComposerKt.firstInRange(this.invalidations, this.reader.getCurrentGroup(), groupSize);
        boolean z2 = false;
        int i4 = parent;
        while (access$firstInRange != null) {
            int location = access$firstInRange.getLocation();
            Invalidation unused = ComposerKt.removeLocation(this.invalidations, location);
            if (access$firstInRange.isInvalid()) {
                this.reader.reposition(location);
                int currentGroup = this.reader.getCurrentGroup();
                recordUpsAndDowns(i4, currentGroup, parent);
                this.nodeIndex = nodeIndexOf(location, currentGroup, parent, i);
                this.rGroupIndex = rGroupIndexOf(currentGroup);
                int parent2 = this.reader.parent(currentGroup);
                this.compoundKeyHash = compoundKeyOf(parent2, rGroupIndexOf(parent2), parent, compoundKeyHash2);
                this.providerCache = null;
                access$firstInRange.getScope().compose(this);
                this.providerCache = null;
                this.reader.restoreParent(parent);
                i4 = currentGroup;
                z2 = true;
            } else {
                this.invalidateStack.push(access$firstInRange.getScope());
                access$firstInRange.getScope().rereadTrackedInstances();
                this.invalidateStack.pop();
            }
            access$firstInRange = ComposerKt.firstInRange(this.invalidations, this.reader.getCurrentGroup(), groupSize);
        }
        if (z2) {
            recordUpsAndDowns(i4, parent, parent);
            this.reader.skipToGroupEnd();
            int updatedNodeCount = updatedNodeCount(parent);
            this.nodeIndex = i + updatedNodeCount;
            this.groupNodeCount = i2 + updatedNodeCount;
            this.rGroupIndex = i3;
        } else {
            skipReaderToGroupEnd();
        }
        this.compoundKeyHash = compoundKeyHash2;
        this.isComposing = z;
    }

    private final void updateNodeCountOverrides(int i, int i2) {
        int updatedNodeCount = updatedNodeCount(i);
        if (updatedNodeCount != i2) {
            int i3 = i2 - updatedNodeCount;
            int size = this.pendingStack.getSize() - 1;
            while (i != -1) {
                int updatedNodeCount2 = updatedNodeCount(i) + i3;
                updateNodeCount(i, updatedNodeCount2);
                int i4 = size;
                while (true) {
                    if (-1 < i4) {
                        Pending peek = this.pendingStack.peek(i4);
                        if (peek != null && peek.updateNodeCount(i, updatedNodeCount2)) {
                            size = i4 - 1;
                            break;
                        }
                        i4--;
                    } else {
                        break;
                    }
                }
                if (i < 0) {
                    i = this.reader.getParent();
                } else if (!this.reader.isNode(i)) {
                    i = this.reader.parent(i);
                } else {
                    return;
                }
            }
        }
    }

    private final int nodeIndexOf(int i, int i2, int i3, int i4) {
        int i5;
        int parent = this.reader.parent(i2);
        while (i5 != i3 && !this.reader.isNode(i5)) {
            parent = this.reader.parent(i5);
        }
        if (this.reader.isNode(i5)) {
            i4 = 0;
        }
        if (i5 == i2) {
            return i4;
        }
        int updatedNodeCount = (updatedNodeCount(i5) - this.reader.nodeCount(i2)) + i4;
        loop1:
        while (i4 < updatedNodeCount && i5 != i) {
            i5++;
            while (true) {
                if (i5 >= i) {
                    break loop1;
                }
                int groupSize = this.reader.groupSize(i5) + i5;
                if (i >= groupSize) {
                    i4 += this.reader.isNode(i5) ? 1 : updatedNodeCount(i5);
                    i5 = groupSize;
                }
            }
        }
        return i4;
    }

    private final int rGroupIndexOf(int i) {
        int parent = this.reader.parent(i) + 1;
        int i2 = 0;
        while (parent < i) {
            if (!this.reader.hasObjectKey(parent)) {
                i2++;
            }
            parent += this.reader.groupSize(parent);
        }
        return i2;
    }

    private final int updatedNodeCount(int i) {
        int i2;
        if (i < 0) {
            MutableIntIntMap mutableIntIntMap = this.nodeCountVirtualOverrides;
            if (mutableIntIntMap == null || !mutableIntIntMap.contains(i)) {
                return 0;
            }
            return mutableIntIntMap.get(i);
        }
        int[] iArr = this.nodeCountOverrides;
        if (iArr == null || (i2 = iArr[i]) < 0) {
            return this.reader.nodeCount(i);
        }
        return i2;
    }

    private final void updateNodeCount(int i, int i2) {
        if (updatedNodeCount(i) == i2) {
            return;
        }
        if (i < 0) {
            MutableIntIntMap mutableIntIntMap = this.nodeCountVirtualOverrides;
            if (mutableIntIntMap == null) {
                ComposerImpl composerImpl = this;
                mutableIntIntMap = new MutableIntIntMap(0, 1, (DefaultConstructorMarker) null);
                this.nodeCountVirtualOverrides = mutableIntIntMap;
            }
            mutableIntIntMap.set(i, i2);
            return;
        }
        int[] iArr = this.nodeCountOverrides;
        if (iArr == null) {
            ComposerImpl composerImpl2 = this;
            int[] iArr2 = new int[this.reader.getSize()];
            ArraysKt.fill$default(iArr2, -1, 0, 0, 6, (Object) null);
            this.nodeCountOverrides = iArr2;
            iArr = iArr2;
        }
        iArr[i] = i2;
    }

    private final void clearUpdatedNodeCounts() {
        this.nodeCountOverrides = null;
        this.nodeCountVirtualOverrides = null;
    }

    private final void recordUpsAndDowns(int i, int i2, int i3) {
        SlotReader slotReader = this.reader;
        int access$nearestCommonRootOf = ComposerKt.nearestCommonRootOf(slotReader, i, i2, i3);
        while (i > 0 && i != access$nearestCommonRootOf) {
            if (slotReader.isNode(i)) {
                this.changeListWriter.moveUp();
            }
            i = slotReader.parent(i);
        }
        doRecordDownsFor(i2, access$nearestCommonRootOf);
    }

    private final void doRecordDownsFor(int i, int i2) {
        if (i > 0 && i != i2) {
            doRecordDownsFor(this.reader.parent(i), i2);
            if (this.reader.isNode(i)) {
                this.changeListWriter.moveDown(nodeAt(this.reader, i));
            }
        }
    }

    private final int compoundKeyOf(int i, int i2, int i3, int i4) {
        if (i == i3) {
            return i4;
        }
        ComposerImpl composerImpl = this;
        int groupCompoundKeyPart = groupCompoundKeyPart(this.reader, i);
        if (groupCompoundKeyPart == 126665345) {
            return groupCompoundKeyPart;
        }
        int parent = this.reader.parent(i);
        if (parent != i3) {
            i4 = compoundKeyOf(parent, rGroupIndexOf(parent), i3, i4);
        }
        if (this.reader.hasObjectKey(i)) {
            i2 = 0;
        }
        return Integer.rotateLeft(Integer.rotateLeft(i4, 3) ^ groupCompoundKeyPart, 3) ^ i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002e, code lost:
        r3 = r3.groupAux(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int groupCompoundKeyPart(androidx.compose.runtime.SlotReader r3, int r4) {
        /*
            r2 = this;
            boolean r0 = r3.hasObjectKey(r4)
            if (r0 == 0) goto L_0x0026
            java.lang.Object r3 = r3.groupObjectKey(r4)
            if (r3 == 0) goto L_0x0024
            boolean r4 = r3 instanceof java.lang.Enum
            if (r4 == 0) goto L_0x0017
            java.lang.Enum r3 = (java.lang.Enum) r3
            int r3 = r3.ordinal()
            return r3
        L_0x0017:
            boolean r4 = r3 instanceof androidx.compose.runtime.MovableContent
            if (r4 == 0) goto L_0x001f
            r3 = 126665345(0x78cc281, float:2.1179178E-34)
            return r3
        L_0x001f:
            int r3 = r3.hashCode()
            return r3
        L_0x0024:
            r3 = 0
            return r3
        L_0x0026:
            int r0 = r3.groupKey((int) r4)
            r1 = 207(0xcf, float:2.9E-43)
            if (r0 != r1) goto L_0x0046
            java.lang.Object r3 = r3.groupAux(r4)
            if (r3 == 0) goto L_0x0046
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x0041
            goto L_0x0046
        L_0x0041:
            int r3 = r3.hashCode()
            return r3
        L_0x0046:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.groupCompoundKeyPart(androidx.compose.runtime.SlotReader, int):int");
    }

    public final boolean tryImminentInvalidation$runtime_release(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        Anchor anchor = recomposeScopeImpl.getAnchor();
        if (anchor == null) {
            return false;
        }
        int indexFor = anchor.toIndexFor(this.reader.getTable$runtime_release());
        if (!this.isComposing || indexFor < this.reader.getCurrentGroup()) {
            return false;
        }
        ComposerKt.insertIfMissing(this.invalidations, indexFor, recomposeScopeImpl, obj);
        return true;
    }

    public final int parentKey$runtime_release() {
        if (getInserting()) {
            SlotWriter slotWriter = this.writer;
            return slotWriter.groupKey(slotWriter.getParent());
        }
        SlotReader slotReader = this.reader;
        return slotReader.groupKey(slotReader.getParent());
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c2  */
    @androidx.compose.runtime.ComposeCompilerApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void skipCurrentGroup() {
        /*
            r9 = this;
            java.util.List<androidx.compose.runtime.Invalidation> r0 = r9.invalidations
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x000c
            r9.skipGroup()
            return
        L_0x000c:
            androidx.compose.runtime.SlotReader r0 = r9.reader
            int r1 = r0.getGroupKey()
            java.lang.Object r2 = r0.getGroupObjectKey()
            java.lang.Object r3 = r0.getGroupAux()
            int r4 = r9.rGroupIndex
            r5 = 207(0xcf, float:2.9E-43)
            r6 = 3
            if (r2 != 0) goto L_0x0055
            if (r3 == 0) goto L_0x0046
            if (r1 != r5) goto L_0x0046
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r7)
            if (r7 != 0) goto L_0x0046
            int r7 = r3.hashCode()
            int r8 = r9.getCompoundKeyHash()
            int r8 = java.lang.Integer.rotateLeft(r8, r6)
            r7 = r7 ^ r8
            int r7 = java.lang.Integer.rotateLeft(r7, r6)
            r7 = r7 ^ r4
            r9.compoundKeyHash = r7
            goto L_0x0074
        L_0x0046:
            int r7 = r9.getCompoundKeyHash()
            int r7 = java.lang.Integer.rotateLeft(r7, r6)
            r7 = r7 ^ r1
            int r7 = java.lang.Integer.rotateLeft(r7, r6)
            r7 = r7 ^ r4
            goto L_0x0072
        L_0x0055:
            boolean r7 = r2 instanceof java.lang.Enum
            if (r7 == 0) goto L_0x0061
            r7 = r2
            java.lang.Enum r7 = (java.lang.Enum) r7
            int r7 = r7.ordinal()
            goto L_0x0065
        L_0x0061:
            int r7 = r2.hashCode()
        L_0x0065:
            int r8 = r9.getCompoundKeyHash()
            int r8 = java.lang.Integer.rotateLeft(r8, r6)
            r7 = r7 ^ r8
            int r7 = java.lang.Integer.rotateLeft(r7, r6)
        L_0x0072:
            r9.compoundKeyHash = r7
        L_0x0074:
            boolean r7 = r0.isNode()
            r8 = 0
            r9.startReaderGroup(r7, r8)
            r9.recomposeToGroupEnd()
            r0.endGroup()
            if (r2 != 0) goto L_0x00c2
            if (r3 == 0) goto L_0x00ad
            if (r1 != r5) goto L_0x00ad
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r0)
            if (r0 != 0) goto L_0x00ad
            int r0 = r3.hashCode()
            int r1 = r9.getCompoundKeyHash()
            r1 = r1 ^ r4
            int r1 = java.lang.Integer.rotateRight(r1, r6)
            int r0 = java.lang.Integer.hashCode(r0)
            r0 = r0 ^ r1
            int r0 = java.lang.Integer.rotateRight(r0, r6)
            r9.compoundKeyHash = r0
            return
        L_0x00ad:
            int r0 = r9.getCompoundKeyHash()
            r0 = r0 ^ r4
            int r0 = java.lang.Integer.rotateRight(r0, r6)
            int r1 = java.lang.Integer.hashCode(r1)
            r0 = r0 ^ r1
            int r0 = java.lang.Integer.rotateRight(r0, r6)
            r9.compoundKeyHash = r0
            return
        L_0x00c2:
            boolean r0 = r2 instanceof java.lang.Enum
            if (r0 == 0) goto L_0x00e0
            java.lang.Enum r2 = (java.lang.Enum) r2
            int r0 = r2.ordinal()
            int r1 = r9.getCompoundKeyHash()
            int r1 = java.lang.Integer.rotateRight(r1, r6)
            int r0 = java.lang.Integer.hashCode(r0)
            r0 = r0 ^ r1
            int r0 = java.lang.Integer.rotateRight(r0, r6)
            r9.compoundKeyHash = r0
            return
        L_0x00e0:
            int r0 = r2.hashCode()
            int r1 = r9.getCompoundKeyHash()
            int r1 = java.lang.Integer.rotateRight(r1, r6)
            int r0 = java.lang.Integer.hashCode(r0)
            r0 = r0 ^ r1
            int r0 = java.lang.Integer.rotateRight(r0, r6)
            r9.compoundKeyHash = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.skipCurrentGroup():void");
    }

    private final void skipReaderToGroupEnd() {
        this.groupNodeCount = this.reader.getParentNodes();
        this.reader.skipToGroupEnd();
    }

    @ComposeCompilerApi
    public void skipToGroupEnd() {
        if (!(this.groupNodeCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("No nodes can be emitted before calling skipAndEndGroup");
        }
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        if (currentRecomposeScope$runtime_release != null) {
            currentRecomposeScope$runtime_release.scopeSkipped();
        }
        if (this.invalidations.isEmpty()) {
            skipReaderToGroupEnd();
        } else {
            recomposeToGroupEnd();
        }
    }

    @ComposeCompilerApi
    public void deactivateToEndGroup(boolean z) {
        if (!(this.groupNodeCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("No nodes can be emitted before calling dactivateToEndGroup");
        }
        if (getInserting()) {
            return;
        }
        if (!z) {
            skipReaderToGroupEnd();
            return;
        }
        int currentGroup = this.reader.getCurrentGroup();
        int currentEnd = this.reader.getCurrentEnd();
        this.changeListWriter.deactivateCurrentGroup();
        ComposerKt.removeRange(this.invalidations, currentGroup, currentEnd);
        this.reader.skipToGroupEnd();
    }

    @ComposeCompilerApi
    public Composer startRestartGroup(int i) {
        startReplaceGroup(i);
        addRecomposeScope();
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x006b, code lost:
        if (r0 != false) goto L_0x006d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void addRecomposeScope() {
        /*
            r4 = this;
            boolean r0 = r4.getInserting()
            java.lang.String r1 = "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl"
            if (r0 == 0) goto L_0x0026
            androidx.compose.runtime.RecomposeScopeImpl r0 = new androidx.compose.runtime.RecomposeScopeImpl
            androidx.compose.runtime.ControlledComposition r2 = r4.getComposition()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r1)
            androidx.compose.runtime.CompositionImpl r2 = (androidx.compose.runtime.CompositionImpl) r2
            androidx.compose.runtime.RecomposeScopeOwner r2 = (androidx.compose.runtime.RecomposeScopeOwner) r2
            r0.<init>(r2)
            androidx.compose.runtime.Stack<androidx.compose.runtime.RecomposeScopeImpl> r1 = r4.invalidateStack
            r1.push(r0)
            r4.updateValue(r0)
            int r1 = r4.compositionToken
            r0.start(r1)
            return
        L_0x0026:
            java.util.List<androidx.compose.runtime.Invalidation> r0 = r4.invalidations
            androidx.compose.runtime.SlotReader r2 = r4.reader
            int r2 = r2.getParent()
            androidx.compose.runtime.Invalidation r0 = androidx.compose.runtime.ComposerKt.removeLocation(r0, r2)
            androidx.compose.runtime.SlotReader r2 = r4.reader
            java.lang.Object r2 = r2.next()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0058
            androidx.compose.runtime.RecomposeScopeImpl r2 = new androidx.compose.runtime.RecomposeScopeImpl
            androidx.compose.runtime.ControlledComposition r3 = r4.getComposition()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r1)
            androidx.compose.runtime.CompositionImpl r3 = (androidx.compose.runtime.CompositionImpl) r3
            androidx.compose.runtime.RecomposeScopeOwner r3 = (androidx.compose.runtime.RecomposeScopeOwner) r3
            r2.<init>(r3)
            r4.updateValue(r2)
            goto L_0x005f
        L_0x0058:
            java.lang.String r1 = "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r1)
            androidx.compose.runtime.RecomposeScopeImpl r2 = (androidx.compose.runtime.RecomposeScopeImpl) r2
        L_0x005f:
            if (r0 != 0) goto L_0x006d
            boolean r0 = r2.getForcedRecompose()
            r1 = 0
            if (r0 == 0) goto L_0x006b
            r2.setForcedRecompose(r1)
        L_0x006b:
            if (r0 == 0) goto L_0x006e
        L_0x006d:
            r1 = 1
        L_0x006e:
            r2.setRequiresRecompose(r1)
            androidx.compose.runtime.Stack<androidx.compose.runtime.RecomposeScopeImpl> r0 = r4.invalidateStack
            r0.push(r2)
            int r0 = r4.compositionToken
            r2.start(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.addRecomposeScope():void");
    }

    @ComposeCompilerApi
    public ScopeUpdateScope endRestartGroup() {
        Anchor anchor;
        Function1<Composition, Unit> end;
        RecomposeScopeImpl recomposeScopeImpl = null;
        RecomposeScopeImpl pop = this.invalidateStack.isNotEmpty() ? this.invalidateStack.pop() : null;
        if (pop != null) {
            pop.setRequiresRecompose(false);
        }
        if (!(pop == null || (end = pop.end(this.compositionToken)) == null)) {
            this.changeListWriter.endCompositionScope(end, getComposition());
        }
        if (pop != null && !pop.getSkipped$runtime_release() && (pop.getUsed() || this.forceRecomposeScopes)) {
            if (pop.getAnchor() == null) {
                if (getInserting()) {
                    SlotWriter slotWriter = this.writer;
                    anchor = slotWriter.anchor(slotWriter.getParent());
                } else {
                    SlotReader slotReader = this.reader;
                    anchor = slotReader.anchor(slotReader.getParent());
                }
                pop.setAnchor(anchor);
            }
            pop.setDefaultsInvalid(false);
            recomposeScopeImpl = pop;
        }
        end(false);
        return recomposeScopeImpl;
    }

    public void insertMovableContent(MovableContent<?> movableContent, Object obj) {
        Intrinsics.checkNotNull(movableContent, "null cannot be cast to non-null type androidx.compose.runtime.MovableContent<kotlin.Any?>");
        invokeMovableContentLambda(movableContent, currentCompositionLocalScope(), obj, false);
    }

    /* access modifiers changed from: private */
    public final void invokeMovableContentLambda(MovableContent<Object> movableContent, PersistentCompositionLocalMap persistentCompositionLocalMap, Object obj, boolean z) {
        startMovableGroup(MovableContentKt.movableContentKey, movableContent);
        updateSlot(obj);
        int compoundKeyHash2 = getCompoundKeyHash();
        try {
            this.compoundKeyHash = MovableContentKt.movableContentKey;
            boolean z2 = false;
            if (getInserting()) {
                SlotWriter.markGroup$default(this.writer, 0, 1, (Object) null);
            }
            if (!getInserting()) {
                if (!Intrinsics.areEqual(this.reader.getGroupAux(), (Object) persistentCompositionLocalMap)) {
                    z2 = true;
                }
            }
            if (z2) {
                recordProviderUpdate(persistentCompositionLocalMap);
            }
            m3642startBaiHCIY(ComposerKt.compositionLocalMapKey, ComposerKt.getCompositionLocalMap(), GroupKind.Companion.m3652getGroupULZAiWs(), persistentCompositionLocalMap);
            this.providerCache = null;
            if (!getInserting() || z) {
                boolean z3 = this.providersInvalid;
                this.providersInvalid = z2;
                ActualJvm_jvmKt.invokeComposable(this, ComposableLambdaKt.composableLambdaInstance(316014703, true, new ComposerImpl$invokeMovableContentLambda$1(movableContent, obj)));
                this.providersInvalid = z3;
            } else {
                this.writerHasAProvider = true;
                SlotWriter slotWriter = this.writer;
                this.parentContext.insertMovableContent$runtime_release(new MovableContentStateReference(movableContent, obj, getComposition(), this.insertTable, slotWriter.anchor(slotWriter.parent(slotWriter.getParent())), CollectionsKt.emptyList(), currentCompositionLocalScope()));
            }
            endGroup();
            this.providerCache = null;
            this.compoundKeyHash = compoundKeyHash2;
            endMovableGroup();
        } catch (Throwable th) {
            Throwable th2 = th;
            endGroup();
            this.providerCache = null;
            this.compoundKeyHash = compoundKeyHash2;
            endMovableGroup();
            throw th2;
        }
    }

    public void insertMovableContentReferences(List<Pair<MovableContentStateReference, MovableContentStateReference>> list) {
        try {
            insertMovableContentGuarded(list);
            cleanUpCompose();
        } catch (Throwable th) {
            abortRoot();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00aa, code lost:
        if (r6 == null) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00bd, code lost:
        if (r8 != null) goto L_0x00c3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void insertMovableContentGuarded(java.util.List<kotlin.Pair<androidx.compose.runtime.MovableContentStateReference, androidx.compose.runtime.MovableContentStateReference>> r23) {
        /*
            r22 = this;
            r1 = r22
            androidx.compose.runtime.changelist.ComposerChangeListWriter r9 = r1.changeListWriter
            androidx.compose.runtime.changelist.ChangeList r0 = r1.lateChanges
            androidx.compose.runtime.changelist.ChangeList r10 = r9.getChangeList()
            r9.setChangeList(r0)     // Catch:{ all -> 0x01fd }
            androidx.compose.runtime.changelist.ComposerChangeListWriter r0 = r1.changeListWriter     // Catch:{ all -> 0x01fd }
            r0.resetSlots()     // Catch:{ all -> 0x01fd }
            int r0 = r23.size()     // Catch:{ all -> 0x01fd }
            r11 = 0
            r12 = r11
        L_0x0018:
            if (r12 >= r0) goto L_0x01e0
            r13 = r23
            java.lang.Object r2 = r13.get(r12)     // Catch:{ all -> 0x01da }
            kotlin.Pair r2 = (kotlin.Pair) r2     // Catch:{ all -> 0x01da }
            java.lang.Object r3 = r2.component1()     // Catch:{ all -> 0x01da }
            androidx.compose.runtime.MovableContentStateReference r3 = (androidx.compose.runtime.MovableContentStateReference) r3     // Catch:{ all -> 0x01da }
            java.lang.Object r2 = r2.component2()     // Catch:{ all -> 0x01da }
            androidx.compose.runtime.MovableContentStateReference r2 = (androidx.compose.runtime.MovableContentStateReference) r2     // Catch:{ all -> 0x01da }
            androidx.compose.runtime.Anchor r4 = r3.getAnchor$runtime_release()     // Catch:{ all -> 0x01da }
            androidx.compose.runtime.SlotTable r5 = r3.getSlotTable$runtime_release()     // Catch:{ all -> 0x01da }
            int r5 = r5.anchorIndex(r4)     // Catch:{ all -> 0x01da }
            androidx.compose.runtime.internal.IntRef r14 = new androidx.compose.runtime.internal.IntRef     // Catch:{ all -> 0x01da }
            r6 = 1
            r7 = 0
            r14.<init>(r11, r6, r7)     // Catch:{ all -> 0x01da }
            androidx.compose.runtime.changelist.ComposerChangeListWriter r6 = r1.changeListWriter     // Catch:{ all -> 0x01da }
            r6.determineMovableContentNodeIndex(r14, r4)     // Catch:{ all -> 0x01da }
            if (r2 != 0) goto L_0x009e
            androidx.compose.runtime.SlotTable r2 = r3.getSlotTable$runtime_release()     // Catch:{ all -> 0x01fd }
            androidx.compose.runtime.SlotTable r4 = r1.insertTable     // Catch:{ all -> 0x01fd }
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)     // Catch:{ all -> 0x01fd }
            if (r2 == 0) goto L_0x0057
            r1.createFreshInsertTable()     // Catch:{ all -> 0x01fd }
        L_0x0057:
            androidx.compose.runtime.SlotTable r2 = r3.getSlotTable$runtime_release()     // Catch:{ all -> 0x01fd }
            androidx.compose.runtime.SlotReader r15 = r2.openReader()     // Catch:{ all -> 0x01fd }
            r15.reposition(r5)     // Catch:{ all -> 0x0099 }
            androidx.compose.runtime.changelist.ComposerChangeListWriter r2 = r1.changeListWriter     // Catch:{ all -> 0x0099 }
            r2.moveReaderToAbsolute(r5)     // Catch:{ all -> 0x0099 }
            androidx.compose.runtime.changelist.ChangeList r2 = new androidx.compose.runtime.changelist.ChangeList     // Catch:{ all -> 0x0099 }
            r2.<init>()     // Catch:{ all -> 0x0099 }
            androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$1$1 r4 = new androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$1$1     // Catch:{ all -> 0x0099 }
            r4.<init>(r1, r2, r15, r3)     // Catch:{ all -> 0x0099 }
            r6 = r4
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6     // Catch:{ all -> 0x0099 }
            r7 = 15
            r8 = 0
            r3 = r2
            r2 = 0
            r4 = r3
            r3 = 0
            r5 = r4
            r4 = 0
            r16 = r5
            r5 = 0
            r11 = r16
            recomposeMovableContent$default(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0099 }
            androidx.compose.runtime.changelist.ComposerChangeListWriter r2 = r1.changeListWriter     // Catch:{ all -> 0x0099 }
            r2.includeOperationsIn(r11, r14)     // Catch:{ all -> 0x0099 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0099 }
            r15.close()     // Catch:{ all -> 0x01fd }
            r18 = r0
            r19 = r9
            r20 = r10
            r17 = r12
            goto L_0x0188
        L_0x0099:
            r0 = move-exception
            r15.close()     // Catch:{ all -> 0x01fd }
            throw r0     // Catch:{ all -> 0x01fd }
        L_0x009e:
            androidx.compose.runtime.CompositionContext r5 = r1.parentContext     // Catch:{ all -> 0x01da }
            androidx.compose.runtime.MovableContentState r5 = r5.movableContentStateResolve$runtime_release(r2)     // Catch:{ all -> 0x01da }
            if (r5 == 0) goto L_0x00ac
            androidx.compose.runtime.SlotTable r6 = r5.getSlotTable$runtime_release()     // Catch:{ all -> 0x01fd }
            if (r6 != 0) goto L_0x00b0
        L_0x00ac:
            androidx.compose.runtime.SlotTable r6 = r2.getSlotTable$runtime_release()     // Catch:{ all -> 0x01da }
        L_0x00b0:
            if (r5 == 0) goto L_0x00bf
            androidx.compose.runtime.SlotTable r8 = r5.getSlotTable$runtime_release()     // Catch:{ all -> 0x01fd }
            if (r8 == 0) goto L_0x00bf
            r11 = 0
            androidx.compose.runtime.Anchor r8 = r8.anchor(r11)     // Catch:{ all -> 0x01fd }
            if (r8 != 0) goto L_0x00c3
        L_0x00bf:
            androidx.compose.runtime.Anchor r8 = r2.getAnchor$runtime_release()     // Catch:{ all -> 0x01da }
        L_0x00c3:
            java.util.List r11 = androidx.compose.runtime.ComposerKt.collectNodesFrom(r6, r8)     // Catch:{ all -> 0x01da }
            r15 = r11
            java.util.Collection r15 = (java.util.Collection) r15     // Catch:{ all -> 0x01da }
            boolean r15 = r15.isEmpty()     // Catch:{ all -> 0x01da }
            if (r15 != 0) goto L_0x00f3
            androidx.compose.runtime.changelist.ComposerChangeListWriter r15 = r1.changeListWriter     // Catch:{ all -> 0x01fd }
            r15.copyNodesToNewAnchorLocation(r11, r14)     // Catch:{ all -> 0x01fd }
            androidx.compose.runtime.SlotTable r15 = r3.getSlotTable$runtime_release()     // Catch:{ all -> 0x01fd }
            androidx.compose.runtime.SlotTable r7 = r1.slotTable     // Catch:{ all -> 0x01fd }
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r7)     // Catch:{ all -> 0x01fd }
            if (r7 == 0) goto L_0x00f3
            androidx.compose.runtime.SlotTable r7 = r1.slotTable     // Catch:{ all -> 0x01fd }
            int r4 = r7.anchorIndex(r4)     // Catch:{ all -> 0x01fd }
            int r7 = r1.updatedNodeCount(r4)     // Catch:{ all -> 0x01fd }
            int r11 = r11.size()     // Catch:{ all -> 0x01fd }
            int r7 = r7 + r11
            r1.updateNodeCount(r4, r7)     // Catch:{ all -> 0x01fd }
        L_0x00f3:
            androidx.compose.runtime.changelist.ComposerChangeListWriter r4 = r1.changeListWriter     // Catch:{ all -> 0x01da }
            androidx.compose.runtime.CompositionContext r7 = r1.parentContext     // Catch:{ all -> 0x01da }
            r4.copySlotTableToAnchorLocation(r5, r7, r2, r3)     // Catch:{ all -> 0x01da }
            androidx.compose.runtime.SlotReader r7 = r6.openReader()     // Catch:{ all -> 0x01da }
            androidx.compose.runtime.SlotReader r11 = r1.getReader$runtime_release()     // Catch:{ all -> 0x01cf }
            int[] r15 = r1.nodeCountOverrides     // Catch:{ all -> 0x01cf }
            androidx.compose.runtime.collection.IntMap r4 = r1.providerUpdates     // Catch:{ all -> 0x01cf }
            r5 = 0
            r1.nodeCountOverrides = r5     // Catch:{ all -> 0x01cf }
            r1.providerUpdates = r5     // Catch:{ all -> 0x01cf }
            r1.setReader$runtime_release(r7)     // Catch:{ all -> 0x01bb }
            int r5 = r6.anchorIndex(r8)     // Catch:{ all -> 0x01bb }
            r7.reposition(r5)     // Catch:{ all -> 0x01bb }
            androidx.compose.runtime.changelist.ComposerChangeListWriter r6 = r1.changeListWriter     // Catch:{ all -> 0x01bb }
            r6.moveReaderToAbsolute(r5)     // Catch:{ all -> 0x01bb }
            androidx.compose.runtime.changelist.ChangeList r8 = new androidx.compose.runtime.changelist.ChangeList     // Catch:{ all -> 0x01bb }
            r8.<init>()     // Catch:{ all -> 0x01bb }
            androidx.compose.runtime.changelist.ComposerChangeListWriter r5 = r1.changeListWriter     // Catch:{ all -> 0x01bb }
            androidx.compose.runtime.changelist.ChangeList r6 = r5.getChangeList()     // Catch:{ all -> 0x01bb }
            r5.setChangeList(r8)     // Catch:{ all -> 0x01ab }
            r16 = r7
            androidx.compose.runtime.changelist.ComposerChangeListWriter r7 = r1.changeListWriter     // Catch:{ all -> 0x01a8 }
            r17 = r12
            boolean r12 = r7.getImplicitRootStart()     // Catch:{ all -> 0x01a8 }
            r18 = r0
            r0 = 0
            r7.setImplicitRootStart(r0)     // Catch:{ all -> 0x019a }
            r0 = r2
            androidx.compose.runtime.ControlledComposition r2 = r0.getComposition$runtime_release()     // Catch:{ all -> 0x019a }
            androidx.compose.runtime.ControlledComposition r19 = r3.getComposition$runtime_release()     // Catch:{ all -> 0x019a }
            int r20 = r16.getCurrentGroup()     // Catch:{ all -> 0x019a }
            java.lang.Integer r20 = java.lang.Integer.valueOf(r20)     // Catch:{ all -> 0x019a }
            java.util.List r0 = r0.getInvalidations$runtime_release()     // Catch:{ all -> 0x019a }
            r21 = r0
            androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$2$1$1$1$1 r0 = new androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$2$1$1$1$1     // Catch:{ all -> 0x019a }
            r0.<init>(r1, r3)     // Catch:{ all -> 0x019a }
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0     // Catch:{ all -> 0x019a }
            r13 = r4
            r3 = r19
            r4 = r20
            r19 = r9
            r20 = r10
            r9 = r5
            r10 = r6
            r5 = r21
            r6 = r0
            r1.recomposeMovableContent(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0198 }
            r7.setImplicitRootStart(r12)     // Catch:{ all -> 0x01a6 }
            r9.setChangeList(r10)     // Catch:{ all -> 0x01b9 }
            androidx.compose.runtime.changelist.ComposerChangeListWriter r0 = r1.changeListWriter     // Catch:{ all -> 0x01b9 }
            r0.includeOperationsIn(r8, r14)     // Catch:{ all -> 0x01b9 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01b9 }
            r1.setReader$runtime_release(r11)     // Catch:{ all -> 0x01cd }
            r1.nodeCountOverrides = r15     // Catch:{ all -> 0x01cd }
            r1.providerUpdates = r13     // Catch:{ all -> 0x01cd }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01cd }
            r16.close()     // Catch:{ all -> 0x01f7 }
        L_0x0188:
            androidx.compose.runtime.changelist.ComposerChangeListWriter r0 = r1.changeListWriter     // Catch:{ all -> 0x01f7 }
            r0.skipToEndOfCurrentGroup()     // Catch:{ all -> 0x01f7 }
            int r12 = r17 + 1
            r0 = r18
            r9 = r19
            r10 = r20
            r11 = 0
            goto L_0x0018
        L_0x0198:
            r0 = move-exception
            goto L_0x01a2
        L_0x019a:
            r0 = move-exception
            r13 = r4
            r19 = r9
            r20 = r10
            r9 = r5
            r10 = r6
        L_0x01a2:
            r7.setImplicitRootStart(r12)     // Catch:{ all -> 0x01a6 }
            throw r0     // Catch:{ all -> 0x01a6 }
        L_0x01a6:
            r0 = move-exception
            goto L_0x01b5
        L_0x01a8:
            r0 = move-exception
            r13 = r4
            goto L_0x01af
        L_0x01ab:
            r0 = move-exception
            r13 = r4
            r16 = r7
        L_0x01af:
            r19 = r9
            r20 = r10
            r9 = r5
            r10 = r6
        L_0x01b5:
            r9.setChangeList(r10)     // Catch:{ all -> 0x01b9 }
            throw r0     // Catch:{ all -> 0x01b9 }
        L_0x01b9:
            r0 = move-exception
            goto L_0x01c3
        L_0x01bb:
            r0 = move-exception
            r13 = r4
            r16 = r7
            r19 = r9
            r20 = r10
        L_0x01c3:
            r1.setReader$runtime_release(r11)     // Catch:{ all -> 0x01cd }
            r1.nodeCountOverrides = r15     // Catch:{ all -> 0x01cd }
            r1.providerUpdates = r13     // Catch:{ all -> 0x01cd }
            throw r0     // Catch:{ all -> 0x01cd }
        L_0x01cd:
            r0 = move-exception
            goto L_0x01d6
        L_0x01cf:
            r0 = move-exception
            r16 = r7
            r19 = r9
            r20 = r10
        L_0x01d6:
            r16.close()     // Catch:{ all -> 0x01f7 }
            throw r0     // Catch:{ all -> 0x01f7 }
        L_0x01da:
            r0 = move-exception
            r19 = r9
            r20 = r10
            goto L_0x01f8
        L_0x01e0:
            r19 = r9
            r20 = r10
            androidx.compose.runtime.changelist.ComposerChangeListWriter r0 = r1.changeListWriter     // Catch:{ all -> 0x01f7 }
            r0.endMovableContentPlacement()     // Catch:{ all -> 0x01f7 }
            androidx.compose.runtime.changelist.ComposerChangeListWriter r0 = r1.changeListWriter     // Catch:{ all -> 0x01f7 }
            r11 = 0
            r0.moveReaderToAbsolute(r11)     // Catch:{ all -> 0x01f7 }
            r2 = r19
            r3 = r20
            r2.setChangeList(r3)
            return
        L_0x01f7:
            r0 = move-exception
        L_0x01f8:
            r2 = r19
            r3 = r20
            goto L_0x0200
        L_0x01fd:
            r0 = move-exception
            r2 = r9
            r3 = r10
        L_0x0200:
            r2.setChangeList(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.insertMovableContentGuarded(java.util.List):void");
    }

    private final <R> R withReader(SlotReader slotReader, Function0<? extends R> function0) {
        SlotReader reader$runtime_release = getReader$runtime_release();
        int[] access$getNodeCountOverrides$p = this.nodeCountOverrides;
        IntMap access$getProviderUpdates$p = this.providerUpdates;
        this.nodeCountOverrides = null;
        this.providerUpdates = null;
        try {
            setReader$runtime_release(slotReader);
            return function0.invoke();
        } finally {
            setReader$runtime_release(reader$runtime_release);
            this.nodeCountOverrides = access$getNodeCountOverrides$p;
            this.providerUpdates = access$getProviderUpdates$p;
        }
    }

    static /* synthetic */ Object recomposeMovableContent$default(ComposerImpl composerImpl, ControlledComposition controlledComposition, ControlledComposition controlledComposition2, Integer num, List list, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            controlledComposition = null;
        }
        if ((i & 2) != 0) {
            controlledComposition2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            list = CollectionsKt.emptyList();
        }
        return composerImpl.recomposeMovableContent(controlledComposition, controlledComposition2, num, list, function0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        if (r7 == null) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <R> R recomposeMovableContent(androidx.compose.runtime.ControlledComposition r7, androidx.compose.runtime.ControlledComposition r8, java.lang.Integer r9, java.util.List<? extends kotlin.Pair<androidx.compose.runtime.RecomposeScopeImpl, ? extends java.lang.Object>> r10, kotlin.jvm.functions.Function0<? extends R> r11) {
        /*
            r6 = this;
            boolean r0 = r6.isComposing
            int r1 = r6.nodeIndex
            r2 = 1
            r6.isComposing = r2     // Catch:{ all -> 0x0046 }
            r2 = 0
            r6.nodeIndex = r2     // Catch:{ all -> 0x0046 }
            int r3 = r10.size()     // Catch:{ all -> 0x0046 }
        L_0x000e:
            if (r2 >= r3) goto L_0x002d
            java.lang.Object r4 = r10.get(r2)     // Catch:{ all -> 0x0046 }
            kotlin.Pair r4 = (kotlin.Pair) r4     // Catch:{ all -> 0x0046 }
            java.lang.Object r5 = r4.component1()     // Catch:{ all -> 0x0046 }
            androidx.compose.runtime.RecomposeScopeImpl r5 = (androidx.compose.runtime.RecomposeScopeImpl) r5     // Catch:{ all -> 0x0046 }
            java.lang.Object r4 = r4.component2()     // Catch:{ all -> 0x0046 }
            if (r4 == 0) goto L_0x0026
            r6.tryImminentInvalidation$runtime_release(r5, r4)     // Catch:{ all -> 0x0046 }
            goto L_0x002a
        L_0x0026:
            r4 = 0
            r6.tryImminentInvalidation$runtime_release(r5, r4)     // Catch:{ all -> 0x0046 }
        L_0x002a:
            int r2 = r2 + 1
            goto L_0x000e
        L_0x002d:
            if (r7 == 0) goto L_0x003d
            if (r9 == 0) goto L_0x0036
            int r9 = r9.intValue()     // Catch:{ all -> 0x0046 }
            goto L_0x0037
        L_0x0036:
            r9 = -1
        L_0x0037:
            java.lang.Object r7 = r7.delegateInvalidations(r8, r9, r11)     // Catch:{ all -> 0x0046 }
            if (r7 != 0) goto L_0x0041
        L_0x003d:
            java.lang.Object r7 = r11.invoke()     // Catch:{ all -> 0x0046 }
        L_0x0041:
            r6.isComposing = r0
            r6.nodeIndex = r1
            return r7
        L_0x0046:
            r7 = move-exception
            r6.isComposing = r0
            r6.nodeIndex = r1
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.recomposeMovableContent(androidx.compose.runtime.ControlledComposition, androidx.compose.runtime.ControlledComposition, java.lang.Integer, java.util.List, kotlin.jvm.functions.Function0):java.lang.Object");
    }

    @ComposeCompilerApi
    public void sourceInformation(String str) {
        if (getInserting() && this.sourceMarkersEnabled) {
            this.writer.recordGroupSourceInformation(str);
        }
    }

    @ComposeCompilerApi
    public void sourceInformationMarkerStart(int i, String str) {
        if (getInserting() && this.sourceMarkersEnabled) {
            this.writer.recordGrouplessCallSourceInformationStart(i, str);
        }
    }

    @ComposeCompilerApi
    public void sourceInformationMarkerEnd() {
        if (getInserting() && this.sourceMarkersEnabled) {
            this.writer.recordGrouplessCallSourceInformationEnd();
        }
    }

    public void disableSourceInformation() {
        this.sourceMarkersEnabled = false;
    }

    public final void composeContent$runtime_release(ScopeMap<RecomposeScopeImpl, Object> scopeMap, Function2<? super Composer, ? super Integer, Unit> function2) {
        if (!this.changes.isEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Expected applyChanges() to have been called");
        }
        doCompose(scopeMap, function2);
    }

    public final void prepareCompose$runtime_release(Function0<Unit> function0) {
        if (this.isComposing) {
            ComposerKt.composeImmediateRuntimeError("Preparing a composition while composing is not supported");
        }
        this.isComposing = true;
        try {
            function0.invoke();
        } finally {
            this.isComposing = false;
        }
    }

    public final boolean recompose$runtime_release(ScopeMap<RecomposeScopeImpl, Object> scopeMap) {
        if (!this.changes.isEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Expected applyChanges() to have been called");
        }
        if (scopeMap.getSize() <= 0 && this.invalidations.isEmpty() && !this.forciblyRecompose) {
            return false;
        }
        doCompose(scopeMap, (Function2<? super Composer, ? super Integer, Unit>) null);
        return this.changes.isNotEmpty();
    }

    private final void doCompose(ScopeMap<RecomposeScopeImpl, Object> scopeMap, Function2<? super Composer, ? super Integer, Unit> function2) {
        MutableVector<DerivedStateObserver> derivedStateObservers;
        long[] jArr;
        long[] jArr2;
        int i;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        if (this.isComposing) {
            ComposerKt.composeImmediateRuntimeError("Reentrant composition is not supported");
        }
        Object beginSection = Trace.INSTANCE.beginSection("Compose:recompose");
        try {
            this.compositionToken = SnapshotKt.currentSnapshot().getId();
            this.providerUpdates = null;
            ScatterMap map = scopeMap.getMap();
            Object[] objArr = map.keys;
            Object[] objArr2 = map.values;
            long[] jArr3 = map.metadata;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i2 = 0;
                while (true) {
                    long j = jArr3[i2];
                    if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                        int i3 = 8;
                        int i4 = 8 - ((~(i2 - length)) >>> 31);
                        int i5 = 0;
                        while (i5 < i4) {
                            if ((j & 255) < 128) {
                                int i6 = (i2 << 3) + i5;
                                Object obj = objArr[i6];
                                Object obj2 = objArr2[i6];
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl");
                                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj;
                                Anchor anchor = ((RecomposeScopeImpl) obj).getAnchor();
                                if (anchor != null) {
                                    int location$runtime_release = anchor.getLocation$runtime_release();
                                    i = i3;
                                    List<Invalidation> list = this.invalidations;
                                    RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj;
                                    jArr2 = jArr3;
                                    if (obj2 == ScopeInvalidated.INSTANCE) {
                                        obj2 = null;
                                    }
                                    list.add(new Invalidation(recomposeScopeImpl2, location$runtime_release, obj2));
                                    j >>= i;
                                    i5++;
                                    i3 = i;
                                    jArr3 = jArr2;
                                }
                            }
                            jArr2 = jArr3;
                            i = i3;
                            j >>= i;
                            i5++;
                            i3 = i;
                            jArr3 = jArr2;
                        }
                        jArr = jArr3;
                        if (i4 != i3) {
                            break;
                        }
                    } else {
                        jArr = jArr3;
                    }
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                    jArr3 = jArr;
                }
            }
            CollectionsKt.sortWith(this.invalidations, ComposerKt.InvalidationLocationAscending);
            this.nodeIndex = 0;
            this.isComposing = true;
            try {
                startRoot();
                Object nextSlot = nextSlot();
                if (!(nextSlot == function22 || function22 == null)) {
                    updateValue(function22);
                }
                DerivedStateObserver derivedStateObserver2 = this.derivedStateObserver;
                derivedStateObservers = SnapshotStateKt.derivedStateObservers();
                derivedStateObservers.add(derivedStateObserver2);
                if (function22 != null) {
                    startGroup(200, ComposerKt.getInvocation());
                    ActualJvm_jvmKt.invokeComposable(this, function22);
                    endGroup();
                } else if ((this.forciblyRecompose || this.providersInvalid) && nextSlot != null && !Intrinsics.areEqual(nextSlot, Composer.Companion.getEmpty())) {
                    startGroup(200, ComposerKt.getInvocation());
                    ActualJvm_jvmKt.invokeComposable(this, (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(nextSlot, 2));
                    endGroup();
                } else {
                    skipCurrentGroup();
                }
                derivedStateObservers.removeAt(derivedStateObservers.getSize() - 1);
                endRoot();
                this.isComposing = false;
                this.invalidations.clear();
                createFreshInsertTable();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                this.isComposing = false;
                this.invalidations.clear();
                abortRoot();
                createFreshInsertTable();
                throw th;
            }
        } finally {
            Trace.INSTANCE.endSection(beginSection);
        }
    }

    public final boolean getHasInvalidations() {
        return !this.invalidations.isEmpty();
    }

    private final Object getNode(SlotReader slotReader) {
        return slotReader.node(slotReader.getParent());
    }

    private final Object nodeAt(SlotReader slotReader, int i) {
        return slotReader.node(i);
    }

    private final void validateNodeExpected() {
        if (!this.nodeExpected) {
            ComposerKt.composeImmediateRuntimeError("A call to createNode(), emitNode() or useNode() expected was not expected");
        }
        this.nodeExpected = false;
    }

    private final void validateNodeNotExpected() {
        if (this.nodeExpected) {
            ComposerKt.composeImmediateRuntimeError("A call to createNode(), emitNode() or useNode() expected");
        }
    }

    private final void recordInsert(Anchor anchor) {
        if (this.insertFixups.isEmpty()) {
            this.changeListWriter.insertSlots(anchor, this.insertTable);
            return;
        }
        this.changeListWriter.insertSlots(anchor, this.insertTable, this.insertFixups);
        this.insertFixups = new FixupList();
    }

    private final void recordDelete() {
        reportFreeMovableContent(this.reader.getCurrentGroup());
        this.changeListWriter.removeCurrentGroup();
    }

    private static final int reportFreeMovableContent$reportGroup(ComposerImpl composerImpl, int i, boolean z, int i2) {
        ComposerImpl composerImpl2 = composerImpl;
        int i3 = i;
        int i4 = i2;
        SlotReader slotReader = composerImpl2.reader;
        if (slotReader.hasMark(i3)) {
            int groupKey = slotReader.groupKey(i3);
            Object groupObjectKey = slotReader.groupObjectKey(i3);
            if (groupKey == 126665345 && (groupObjectKey instanceof MovableContent)) {
                MovableContent movableContent = (MovableContent) groupObjectKey;
                Object groupGet = slotReader.groupGet(i3, 0);
                Anchor anchor = slotReader.anchor(i3);
                List access$filterToRange = ComposerKt.filterToRange(composerImpl2.invalidations, i3, slotReader.groupSize(i3) + i3);
                ArrayList arrayList = new ArrayList(access$filterToRange.size());
                int size = access$filterToRange.size();
                for (int i5 = 0; i5 < size; i5++) {
                    Invalidation invalidation = (Invalidation) access$filterToRange.get(i5);
                    arrayList.add(TuplesKt.to(invalidation.getScope(), invalidation.getInstances()));
                }
                MovableContentStateReference movableContentStateReference = new MovableContentStateReference(movableContent, groupGet, composerImpl2.getComposition(), composerImpl2.slotTable, anchor, arrayList, composerImpl.currentCompositionLocalScope(i));
                composerImpl2.parentContext.deletedMovableContent$runtime_release(movableContentStateReference);
                composerImpl2.changeListWriter.recordSlotEditing();
                composerImpl2.changeListWriter.releaseMovableGroupAtCurrent(composerImpl2.getComposition(), composerImpl2.parentContext, movableContentStateReference);
                if (!z) {
                    return slotReader.nodeCount(i3);
                }
                composerImpl2.changeListWriter.endNodeMovementAndDeleteNode(i4, i3);
                return 0;
            } else if (groupKey == 206 && Intrinsics.areEqual(groupObjectKey, ComposerKt.getReference())) {
                Object groupGet2 = slotReader.groupGet(i3, 0);
                CompositionContextHolder compositionContextHolder = groupGet2 instanceof CompositionContextHolder ? (CompositionContextHolder) groupGet2 : null;
                if (compositionContextHolder != null) {
                    for (ComposerImpl composerImpl3 : compositionContextHolder.getRef().getComposers()) {
                        composerImpl3.reportAllMovableContent();
                        composerImpl2.parentContext.reportRemovedComposition$runtime_release(composerImpl3.getComposition());
                    }
                }
                return slotReader.nodeCount(i3);
            } else if (slotReader.isNode(i3)) {
                return 1;
            } else {
                return slotReader.nodeCount(i3);
            }
        } else if (slotReader.containsMark(i3)) {
            int groupSize = slotReader.groupSize(i3) + i3;
            int i6 = 0;
            for (int i7 = i3 + 1; i7 < groupSize; i7 += slotReader.groupSize(i7)) {
                boolean isNode = slotReader.isNode(i7);
                if (isNode) {
                    composerImpl2.changeListWriter.endNodeMovement();
                    composerImpl2.changeListWriter.moveDown(slotReader.node(i7));
                }
                i6 += reportFreeMovableContent$reportGroup(composerImpl2, i7, isNode || z, isNode ? 0 : i4 + i6);
                if (isNode) {
                    composerImpl2.changeListWriter.endNodeMovement();
                    composerImpl2.changeListWriter.moveUp();
                }
            }
            if (slotReader.isNode(i3)) {
                return 1;
            }
            return i6;
        } else if (slotReader.isNode(i3)) {
            return 1;
        } else {
            return slotReader.nodeCount(i3);
        }
    }

    private final void reportFreeMovableContent(int i) {
        reportFreeMovableContent$reportGroup(this, i, false, 0);
        this.changeListWriter.endNodeMovement();
    }

    private final void reportAllMovableContent() {
        ComposerChangeListWriter composerChangeListWriter;
        ChangeList changeList;
        if (this.slotTable.containsMark()) {
            ChangeList changeList2 = new ChangeList();
            this.deferredChanges = changeList2;
            SlotReader openReader = this.slotTable.openReader();
            try {
                this.reader = openReader;
                composerChangeListWriter = this.changeListWriter;
                changeList = composerChangeListWriter.getChangeList();
                composerChangeListWriter.setChangeList(changeList2);
                reportFreeMovableContent(0);
                this.changeListWriter.releaseMovableContent();
                composerChangeListWriter.setChangeList(changeList);
                Unit unit = Unit.INSTANCE;
                openReader.close();
            } catch (Throwable th) {
                openReader.close();
                throw th;
            }
        }
    }

    private final void finalizeCompose() {
        this.changeListWriter.finalizeComposition();
        if (!this.pendingStack.isEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Start/end imbalance");
        }
        cleanUpCompose();
    }

    private final void cleanUpCompose() {
        this.pending = null;
        this.nodeIndex = 0;
        this.groupNodeCount = 0;
        this.compoundKeyHash = 0;
        this.nodeExpected = false;
        this.changeListWriter.resetTransientState();
        this.invalidateStack.clear();
        clearUpdatedNodeCounts();
    }

    public final void verifyConsistent$runtime_release() {
        this.insertTable.verifyWellFormed();
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016R\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Landroidx/compose/runtime/ComposerImpl$CompositionContextHolder;", "Landroidx/compose/runtime/ReusableRememberObserver;", "ref", "Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "Landroidx/compose/runtime/ComposerImpl;", "(Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;)V", "getRef", "()Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "onAbandoned", "", "onForgotten", "onRemembered", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Composer.kt */
    private static final class CompositionContextHolder implements ReusableRememberObserver {
        private final CompositionContextImpl ref;

        public void onRemembered() {
        }

        public CompositionContextHolder(CompositionContextImpl compositionContextImpl) {
            this.ref = compositionContextImpl;
        }

        public final CompositionContextImpl getRef() {
            return this.ref;
        }

        public void onAbandoned() {
            this.ref.dispose();
        }

        public void onForgotten() {
            this.ref.dispose();
        }
    }

    @Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ*\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0011\u00102\u001a\r\u0012\u0004\u0012\u00020/03¢\u0006\u0002\b4H\u0010¢\u0006\u0004\b5\u00106J\u0015\u00107\u001a\u00020/2\u0006\u00108\u001a\u000209H\u0010¢\u0006\u0002\b:J\u0006\u0010;\u001a\u00020/J\r\u0010<\u001a\u00020/H\u0010¢\u0006\u0002\b=J\r\u0010\u0017\u001a\u00020\u0015H\u0010¢\u0006\u0002\b>J\u0015\u0010?\u001a\u00020/2\u0006\u00108\u001a\u000209H\u0010¢\u0006\u0002\b@J\u0015\u0010A\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0010¢\u0006\u0002\bBJ\u0015\u0010C\u001a\u00020/2\u0006\u0010D\u001a\u00020EH\u0010¢\u0006\u0002\bFJ\u001d\u0010G\u001a\u00020/2\u0006\u00108\u001a\u0002092\u0006\u0010H\u001a\u00020IH\u0010¢\u0006\u0002\bJJ\u0017\u0010K\u001a\u0004\u0018\u00010I2\u0006\u00108\u001a\u000209H\u0010¢\u0006\u0002\bLJ\u001b\u0010M\u001a\u00020/2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020$0\u0010H\u0010¢\u0006\u0002\bOJ\u0015\u0010P\u001a\u00020/2\u0006\u0010Q\u001a\u00020RH\u0010¢\u0006\u0002\bSJ\u0015\u0010T\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0010¢\u0006\u0002\bUJ\u0015\u0010V\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0010¢\u0006\u0002\bWJ\r\u0010X\u001a\u00020/H\u0010¢\u0006\u0002\bYJ\u0015\u0010Z\u001a\u00020/2\u0006\u0010Q\u001a\u00020RH\u0010¢\u0006\u0002\b[J\u0015\u0010\\\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0010¢\u0006\u0002\b]J\u000e\u0010^\u001a\u00020/2\u0006\u0010D\u001a\u00020\u0015R\u0014\u0010\n\u001a\u00020\u00058PX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158B@BX\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 8VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R(\u0010#\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u0010\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0013\"\u0004\b&\u0010'R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020 8PX\u0004¢\u0006\f\u0012\u0004\b+\u0010,\u001a\u0004\b-\u0010\"¨\u0006_"}, d2 = {"Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "Landroidx/compose/runtime/CompositionContext;", "compoundHashKey", "", "collectingParameterInformation", "", "collectingSourceInformation", "observerHolder", "Landroidx/compose/runtime/CompositionObserverHolder;", "(Landroidx/compose/runtime/ComposerImpl;IZZLandroidx/compose/runtime/CompositionObserverHolder;)V", "collectingCallByInformation", "getCollectingCallByInformation$runtime_release", "()Z", "getCollectingParameterInformation$runtime_release", "getCollectingSourceInformation$runtime_release", "composers", "", "Landroidx/compose/runtime/ComposerImpl;", "getComposers", "()Ljava/util/Set;", "<set-?>", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "compositionLocalScope", "getCompositionLocalScope", "()Landroidx/compose/runtime/PersistentCompositionLocalMap;", "setCompositionLocalScope", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;)V", "compositionLocalScope$delegate", "Landroidx/compose/runtime/MutableState;", "getCompoundHashKey$runtime_release", "()I", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getEffectCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "inspectionTables", "Landroidx/compose/runtime/tooling/CompositionData;", "getInspectionTables", "setInspectionTables", "(Ljava/util/Set;)V", "getObserverHolder$runtime_release", "()Landroidx/compose/runtime/CompositionObserverHolder;", "recomposeCoroutineContext", "getRecomposeCoroutineContext$runtime_release$annotations", "()V", "getRecomposeCoroutineContext$runtime_release", "composeInitial", "", "composition", "Landroidx/compose/runtime/ControlledComposition;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "deletedMovableContent", "reference", "Landroidx/compose/runtime/MovableContentStateReference;", "deletedMovableContent$runtime_release", "dispose", "doneComposing", "doneComposing$runtime_release", "getCompositionLocalScope$runtime_release", "insertMovableContent", "insertMovableContent$runtime_release", "invalidate", "invalidate$runtime_release", "invalidateScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "invalidateScope$runtime_release", "movableContentStateReleased", "data", "Landroidx/compose/runtime/MovableContentState;", "movableContentStateReleased$runtime_release", "movableContentStateResolve", "movableContentStateResolve$runtime_release", "recordInspectionTable", "table", "recordInspectionTable$runtime_release", "registerComposer", "composer", "Landroidx/compose/runtime/Composer;", "registerComposer$runtime_release", "registerComposition", "registerComposition$runtime_release", "reportRemovedComposition", "reportRemovedComposition$runtime_release", "startComposing", "startComposing$runtime_release", "unregisterComposer", "unregisterComposer$runtime_release", "unregisterComposition", "unregisterComposition$runtime_release", "updateCompositionLocalScope", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Composer.kt */
    private final class CompositionContextImpl extends CompositionContext {
        private final boolean collectingParameterInformation;
        private final boolean collectingSourceInformation;
        private final Set<ComposerImpl> composers = new LinkedHashSet();
        private final MutableState compositionLocalScope$delegate = SnapshotStateKt.mutableStateOf(PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf(), SnapshotStateKt.referentialEqualityPolicy());
        private final int compoundHashKey;
        private Set<Set<CompositionData>> inspectionTables;
        private final CompositionObserverHolder observerHolder;

        public static /* synthetic */ void getRecomposeCoroutineContext$runtime_release$annotations() {
        }

        public CompositionContextImpl(int i, boolean z, boolean z2, CompositionObserverHolder compositionObserverHolder) {
            this.compoundHashKey = i;
            this.collectingParameterInformation = z;
            this.collectingSourceInformation = z2;
            this.observerHolder = compositionObserverHolder;
        }

        public int getCompoundHashKey$runtime_release() {
            return this.compoundHashKey;
        }

        public boolean getCollectingParameterInformation$runtime_release() {
            return this.collectingParameterInformation;
        }

        public boolean getCollectingSourceInformation$runtime_release() {
            return this.collectingSourceInformation;
        }

        public CompositionObserverHolder getObserverHolder$runtime_release() {
            return this.observerHolder;
        }

        public final Set<Set<CompositionData>> getInspectionTables() {
            return this.inspectionTables;
        }

        public final void setInspectionTables(Set<Set<CompositionData>> set) {
            this.inspectionTables = set;
        }

        public final Set<ComposerImpl> getComposers() {
            return this.composers;
        }

        public boolean getCollectingCallByInformation$runtime_release() {
            return ComposerImpl.this.parentContext.getCollectingCallByInformation$runtime_release();
        }

        public final void dispose() {
            if (!this.composers.isEmpty()) {
                Set<Set<CompositionData>> set = this.inspectionTables;
                if (set != null) {
                    for (ComposerImpl next : this.composers) {
                        for (Set<CompositionData> remove : set) {
                            remove.remove(next.slotTable);
                        }
                    }
                }
                this.composers.clear();
            }
        }

        public void registerComposer$runtime_release(Composer composer) {
            Intrinsics.checkNotNull(composer, "null cannot be cast to non-null type androidx.compose.runtime.ComposerImpl");
            super.registerComposer$runtime_release((ComposerImpl) composer);
            this.composers.add(composer);
        }

        public void unregisterComposer$runtime_release(Composer composer) {
            Set<Set<CompositionData>> set = this.inspectionTables;
            if (set != null) {
                for (Set remove : set) {
                    Intrinsics.checkNotNull(composer, "null cannot be cast to non-null type androidx.compose.runtime.ComposerImpl");
                    remove.remove(((ComposerImpl) composer).slotTable);
                }
            }
            TypeIntrinsics.asMutableCollection(this.composers).remove(composer);
        }

        public void registerComposition$runtime_release(ControlledComposition controlledComposition) {
            ComposerImpl.this.parentContext.registerComposition$runtime_release(controlledComposition);
        }

        public void unregisterComposition$runtime_release(ControlledComposition controlledComposition) {
            ComposerImpl.this.parentContext.unregisterComposition$runtime_release(controlledComposition);
        }

        public CoroutineContext getEffectCoroutineContext() {
            return ComposerImpl.this.parentContext.getEffectCoroutineContext();
        }

        public CoroutineContext getRecomposeCoroutineContext$runtime_release() {
            return CompositionKt.getRecomposeCoroutineContext(ComposerImpl.this.getComposition());
        }

        public void composeInitial$runtime_release(ControlledComposition controlledComposition, Function2<? super Composer, ? super Integer, Unit> function2) {
            ComposerImpl.this.parentContext.composeInitial$runtime_release(controlledComposition, function2);
        }

        public void invalidate$runtime_release(ControlledComposition controlledComposition) {
            ComposerImpl.this.parentContext.invalidate$runtime_release(ComposerImpl.this.getComposition());
            ComposerImpl.this.parentContext.invalidate$runtime_release(controlledComposition);
        }

        public void invalidateScope$runtime_release(RecomposeScopeImpl recomposeScopeImpl) {
            ComposerImpl.this.parentContext.invalidateScope$runtime_release(recomposeScopeImpl);
        }

        private final PersistentCompositionLocalMap getCompositionLocalScope() {
            return (PersistentCompositionLocalMap) this.compositionLocalScope$delegate.getValue();
        }

        private final void setCompositionLocalScope(PersistentCompositionLocalMap persistentCompositionLocalMap) {
            this.compositionLocalScope$delegate.setValue(persistentCompositionLocalMap);
        }

        public PersistentCompositionLocalMap getCompositionLocalScope$runtime_release() {
            return getCompositionLocalScope();
        }

        public final void updateCompositionLocalScope(PersistentCompositionLocalMap persistentCompositionLocalMap) {
            setCompositionLocalScope(persistentCompositionLocalMap);
        }

        public void recordInspectionTable$runtime_release(Set<CompositionData> set) {
            Set<Set<CompositionData>> set2 = this.inspectionTables;
            if (set2 == null) {
                set2 = new HashSet<>();
                this.inspectionTables = set2;
            }
            set2.add(set);
        }

        public void startComposing$runtime_release() {
            ComposerImpl composerImpl = ComposerImpl.this;
            composerImpl.childrenComposing = composerImpl.childrenComposing + 1;
        }

        public void doneComposing$runtime_release() {
            ComposerImpl composerImpl = ComposerImpl.this;
            composerImpl.childrenComposing = composerImpl.childrenComposing - 1;
        }

        public void insertMovableContent$runtime_release(MovableContentStateReference movableContentStateReference) {
            ComposerImpl.this.parentContext.insertMovableContent$runtime_release(movableContentStateReference);
        }

        public void deletedMovableContent$runtime_release(MovableContentStateReference movableContentStateReference) {
            ComposerImpl.this.parentContext.deletedMovableContent$runtime_release(movableContentStateReference);
        }

        public MovableContentState movableContentStateResolve$runtime_release(MovableContentStateReference movableContentStateReference) {
            return ComposerImpl.this.parentContext.movableContentStateResolve$runtime_release(movableContentStateReference);
        }

        public void movableContentStateReleased$runtime_release(MovableContentStateReference movableContentStateReference, MovableContentState movableContentState) {
            ComposerImpl.this.parentContext.movableContentStateReleased$runtime_release(movableContentStateReference, movableContentState);
        }

        public void reportRemovedComposition$runtime_release(ControlledComposition controlledComposition) {
            ComposerImpl.this.parentContext.reportRemovedComposition$runtime_release(controlledComposition);
        }
    }

    private final void updateCompoundKeyWhenWeEnterGroup(int i, int i2, Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null || i != 207 || Intrinsics.areEqual(obj2, Composer.Companion.getEmpty())) {
                this.compoundKeyHash = Integer.rotateLeft(i ^ Integer.rotateLeft(getCompoundKeyHash(), 3), 3) ^ i2;
            } else {
                this.compoundKeyHash = Integer.rotateLeft(obj2.hashCode() ^ Integer.rotateLeft(getCompoundKeyHash(), 3), 3) ^ i2;
            }
        } else if (obj instanceof Enum) {
            this.compoundKeyHash = Integer.rotateLeft(((Enum) obj).ordinal() ^ Integer.rotateLeft(getCompoundKeyHash(), 3), 3);
        } else {
            this.compoundKeyHash = Integer.rotateLeft(obj.hashCode() ^ Integer.rotateLeft(getCompoundKeyHash(), 3), 3);
        }
    }

    private final void updateCompoundKeyWhenWeEnterGroupKeyHash(int i, int i2) {
        this.compoundKeyHash = Integer.rotateLeft(i ^ Integer.rotateLeft(getCompoundKeyHash(), 3), 3) ^ i2;
    }

    private final void updateCompoundKeyWhenWeExitGroup(int i, int i2, Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null || i != 207 || Intrinsics.areEqual(obj2, Composer.Companion.getEmpty())) {
                this.compoundKeyHash = Integer.rotateRight(Integer.hashCode(i) ^ Integer.rotateRight(i2 ^ getCompoundKeyHash(), 3), 3);
                return;
            }
            int hashCode = obj2.hashCode();
            this.compoundKeyHash = Integer.rotateRight(Integer.hashCode(hashCode) ^ Integer.rotateRight(i2 ^ getCompoundKeyHash(), 3), 3);
        } else if (obj instanceof Enum) {
            int ordinal = ((Enum) obj).ordinal();
            this.compoundKeyHash = Integer.rotateRight(Integer.hashCode(ordinal) ^ Integer.rotateRight(getCompoundKeyHash(), 3), 3);
        } else {
            int hashCode2 = obj.hashCode();
            this.compoundKeyHash = Integer.rotateRight(Integer.hashCode(hashCode2) ^ Integer.rotateRight(getCompoundKeyHash(), 3), 3);
        }
    }

    private final void updateCompoundKeyWhenWeExitGroupKeyHash(int i, int i2) {
        this.compoundKeyHash = Integer.rotateRight(Integer.hashCode(i) ^ Integer.rotateRight(i2 ^ getCompoundKeyHash(), 3), 3);
    }

    public final int stacksSize$runtime_release() {
        return this.entersStack.getSize() + this.invalidateStack.getSize() + this.providersInvalidStack.getSize() + this.pendingStack.getSize() + this.parentStateStack.getSize();
    }

    public RecomposeScope getRecomposeScope() {
        return getCurrentRecomposeScope$runtime_release();
    }

    public Object getRecomposeScopeIdentity() {
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        if (currentRecomposeScope$runtime_release != null) {
            return currentRecomposeScope$runtime_release.getAnchor();
        }
        return null;
    }

    public Object rememberedValue() {
        return nextSlotForCache();
    }

    public void updateRememberedValue(Object obj) {
        updateCachedValue(obj);
    }

    public void recordUsed(RecomposeScope recomposeScope) {
        RecomposeScopeImpl recomposeScopeImpl = recomposeScope instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) recomposeScope : null;
        if (recomposeScopeImpl != null) {
            recomposeScopeImpl.setUsed(true);
        }
    }

    private final PersistentCompositionLocalMap updateProviderMapGroup(PersistentCompositionLocalMap persistentCompositionLocalMap, PersistentCompositionLocalMap persistentCompositionLocalMap2) {
        PersistentCompositionLocalMap.Builder builder = persistentCompositionLocalMap.builder();
        builder.putAll(persistentCompositionLocalMap2);
        PersistentCompositionLocalMap build = builder.build();
        startGroup(ComposerKt.providerMapsKey, ComposerKt.getProviderMaps());
        updateSlot(build);
        updateSlot(persistentCompositionLocalMap2);
        endGroup();
        return build;
    }
}
