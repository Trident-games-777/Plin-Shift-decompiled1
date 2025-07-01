package androidx.compose.runtime;

import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectList;
import androidx.collection.ObjectList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\bK\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 Ë\u00012\u00020\u0001:\u0002Ë\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\rJ\u0010\u0010F\u001a\u00020\u00072\b\b\u0002\u0010G\u001a\u00020\rJ\u000e\u0010H\u001a\u00020\r2\u0006\u0010F\u001a\u00020\u0007J\u0018\u0010I\u001a\u00020D2\u0006\u0010F\u001a\u00020\u00072\b\u0010J\u001a\u0004\u0018\u00010\u0001J\u0006\u0010K\u001a\u00020DJ\u0006\u0010L\u001a\u00020DJ\u0010\u0010M\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\rH\u0002J\b\u0010O\u001a\u00020DH\u0002J\u000e\u0010P\u001a\u00020D2\u0006\u0010Q\u001a\u00020\u0011J\u0010\u0010R\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\rH\u0002J\u0010\u0010S\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\rH\u0002J \u0010T\u001a\u00020\r2\u0006\u0010F\u001a\u00020\r2\u0006\u0010U\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010V\u001a\u00020\r2\u0006\u0010G\u001a\u00020\rH\u0002J\u0010\u0010W\u001a\u00020\r2\u0006\u0010V\u001a\u00020\rH\u0002J(\u0010X\u001a\u00020\r2\u0006\u0010G\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\u0006\u0010U\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0006\u0010Z\u001a\u00020\rJ\u0006\u0010[\u001a\u00020DJ\u000e\u0010\\\u001a\u00020D2\u0006\u0010F\u001a\u00020\u0007J\u000e\u0010\\\u001a\u00020D2\u0006\u0010G\u001a\u00020\rJ \u0010]\u001a\u00020D2\u0006\u0010.\u001a\u00020\r2\u0006\u0010Z\u001a\u00020\r2\u0006\u0010^\u001a\u00020\rH\u0002JK\u0010_\u001a\u00020D2\u0006\u0010N\u001a\u00020\r28\u0010`\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\bb\u0012\b\bc\u0012\u0004\b\b(G\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\bb\u0012\b\bc\u0012\u0004\b\b(d\u0012\u0004\u0012\u00020D0aH\bJK\u0010e\u001a\u00020D2\u0006\u0010N\u001a\u00020\r28\u0010`\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\bb\u0012\b\bc\u0012\u0004\b\b(G\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\bb\u0012\b\bc\u0012\u0004\b\b(d\u0012\u0004\u0012\u00020D0aH\bJ5\u0010f\u001a\u00020D2\u0006\u0010g\u001a\u00020\r2\u0006\u0010h\u001a\u00020\r2\u001a\u0010`\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020D0aH\bJ\u0010\u0010i\u001a\u0004\u0018\u00010\u00012\u0006\u0010G\u001a\u00020\rJ\u0010\u0010j\u001a\u00020\r2\u0006\u0010G\u001a\u00020\rH\u0002J\u000e\u0010k\u001a\u00020\r2\u0006\u0010G\u001a\u00020\rJ\u0010\u0010l\u001a\u0004\u0018\u00010\u00012\u0006\u0010G\u001a\u00020\rJ\u000e\u0010m\u001a\u00020\r2\u0006\u0010G\u001a\u00020\rJ\u000e\u0010n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010oJ\u001c\u0010p\u001a\u0004\u0018\u00010>2\u0006\u0010.\u001a\u00020\r2\b\u0010q\u001a\u0004\u0018\u00010rH\u0002J\u000e\u0010s\u001a\u00020\u00112\u0006\u0010G\u001a\u00020\rJ\u0016\u0010t\u001a\u00020\u00112\u0006\u0010G\u001a\u00020\r2\u0006\u0010N\u001a\u00020\rJ\u000e\u0010u\u001a\u00020\u00112\u0006\u0010G\u001a\u00020\rJ\u0010\u0010v\u001a\u00020D2\b\u0010J\u001a\u0004\u0018\u00010\u0001J\u0010\u0010w\u001a\u00020D2\u0006\u00102\u001a\u00020\rH\u0002J\u0018\u0010x\u001a\u00020D2\u0006\u00102\u001a\u00020\r2\u0006\u0010N\u001a\u00020\rH\u0002J\u000e\u0010+\u001a\u00020\u00112\u0006\u0010G\u001a\u00020\rJ\u000e\u0010y\u001a\b\u0012\u0004\u0012\u00020\r0zH\u0002J\u0010\u0010{\u001a\u00020D2\b\b\u0002\u0010N\u001a\u00020\rJ \u0010|\u001a\u00020D2\u0006\u0010}\u001a\u00020\r2\u0006\u0010~\u001a\u00020\r2\u0006\u00102\u001a\u00020\rH\u0002J'\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070z2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010G\u001a\u00020\r2\t\b\u0002\u0010\u0001\u001a\u00020\u0011J\u0010\u0010\u0001\u001a\u00020D2\u0007\u0010\u0001\u001a\u00020\rJ\u0011\u0010\u0001\u001a\u00020D2\u0006\u0010G\u001a\u00020\rH\u0002J&\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070z2\u0007\u0010\u0001\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010G\u001a\u00020\rJ\u0019\u0010\u0001\u001a\u00020D2\u0006\u0010G\u001a\u00020\r2\u0006\u0010N\u001a\u00020\rH\u0002J'\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070z2\u0006\u0010F\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\r2\u0007\u0010\u0001\u001a\u00020\u0000J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010F\u001a\u00020\u0007J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010G\u001a\u00020\rJ\u000e\u0010,\u001a\u00020\r2\u0006\u0010G\u001a\u00020\rJ\u000e\u0010.\u001a\u00020\r2\u0006\u0010F\u001a\u00020\u0007J\u000e\u0010.\u001a\u00020\r2\u0006\u0010G\u001a\u00020\rJ\u0011\u0010\u0001\u001a\u00020\r2\u0006\u0010G\u001a\u00020\rH\u0002J\u0019\u0010\u0001\u001a\u00020\r2\u0006\u0010G\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\rH\u0002J\u0015\u0010\u0001\u001a\u0004\u0018\u00010\u00012\b\u0010J\u001a\u0004\u0018\u00010\u0001H\u0002J\t\u0010\u0001\u001a\u00020DH\u0002J\u000f\u0010\u0001\u001a\u00020D2\u0006\u0010q\u001a\u00020rJ\u0007\u0010\u0001\u001a\u00020DJ\u0018\u0010\u0001\u001a\u00020D2\u0007\u0010\u0001\u001a\u00020\r2\u0006\u0010J\u001a\u00020rJA\u0010\u0001\u001a\u00020\u00112\u0006\u0010Y\u001a\u00020\r2\u0006\u00102\u001a\u00020\r2&\u0010<\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020>\u0018\u00010=j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020>\u0018\u0001`?H\u0002J\u0007\u0010\u0001\u001a\u00020\u0011J\u001b\u0010\u0001\u001a\u00020\u00112\u0007\u0010\u0001\u001a\u00020\r2\u0007\u0010\u0001\u001a\u00020\rH\u0002J#\u0010\u0001\u001a\u00020D2\u0007\u0010\u0001\u001a\u00020\r2\u0007\u0010\u0001\u001a\u00020\r2\u0006\u0010N\u001a\u00020\rH\u0002J\u0007\u0010\u0001\u001a\u00020DJ\t\u0010\u0001\u001a\u00020\rH\u0002J\t\u0010\u0001\u001a\u00020DH\u0002J\u000f\u0010\u0001\u001a\u00020D2\u0006\u0010F\u001a\u00020\u0007J\u0011\u0010\u0001\u001a\u00020D2\b\u0010J\u001a\u0004\u0018\u00010\u0001J\u001b\u0010\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010G\u001a\u00020\r2\b\u0010J\u001a\u0004\u0018\u00010\u0001J#\u0010\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010N\u001a\u00020\r2\u0006\u0010G\u001a\u00020\r2\b\u0010J\u001a\u0004\u0018\u00010\u0001J\t\u0010\u0001\u001a\u0004\u0018\u00010\u0001J\u0007\u0010\u0001\u001a\u00020\rJ\u0007\u0010\u0001\u001a\u00020DJ\u0019\u0010\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\rJ\u0019\u0010\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010g\u001a\u00020\r2\u0006\u0010G\u001a\u00020\rJ\u0017\u0010 \u0001\u001a\u00020\r2\u0006\u0010N\u001a\u00020\r2\u0006\u0010G\u001a\u00020\rJ\u0017\u0010¡\u0001\u001a\u00020\r2\u0006\u0010g\u001a\u00020\rH\u0000¢\u0006\u0003\b¢\u0001J\u0017\u0010£\u0001\u001a\u00020\r2\u0006\u0010g\u001a\u00020\rH\u0000¢\u0006\u0003\b¤\u0001J\u0017\u0010¥\u0001\u001a\u00020\r2\u0006\u0010g\u001a\u00020\rH\u0000¢\u0006\u0003\b¦\u0001J\u0013\u0010§\u0001\u001a\u0004\u0018\u00010>2\u0006\u0010N\u001a\u00020\rH\u0002J\u001b\u0010¨\u0001\u001a\u00020D2\u0007\u0010\u0001\u001a\u00020\r2\t\u0010©\u0001\u001a\u0004\u0018\u00010\u0001J&\u0010¨\u0001\u001a\u00020D2\u0007\u0010\u0001\u001a\u00020\r2\t\u0010ª\u0001\u001a\u0004\u0018\u00010\u00012\t\u0010©\u0001\u001a\u0004\u0018\u00010\u0001J\u0007\u0010«\u0001\u001a\u00020DJ\u0010\u0010«\u0001\u001a\u00020D2\u0007\u0010\u0001\u001a\u00020\rJ\u001b\u0010«\u0001\u001a\u00020D2\u0007\u0010\u0001\u001a\u00020\r2\t\u0010¬\u0001\u001a\u0004\u0018\u00010\u0001J0\u0010«\u0001\u001a\u00020D2\u0007\u0010\u0001\u001a\u00020\r2\t\u0010ª\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010+\u001a\u00020\u00112\t\u0010©\u0001\u001a\u0004\u0018\u00010\u0001H\u0002J\u001b\u0010­\u0001\u001a\u00020D2\u0007\u0010\u0001\u001a\u00020\r2\t\u0010ª\u0001\u001a\u0004\u0018\u00010\u0001J&\u0010­\u0001\u001a\u00020D2\u0007\u0010\u0001\u001a\u00020\r2\t\u0010ª\u0001\u001a\u0004\u0018\u00010\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010\u0001J\u0007\u0010®\u0001\u001a\u00020rJ\t\u0010¯\u0001\u001a\u00020rH\u0016J\u000f\u0010°\u0001\u001a\u00020D2\u0006\u0010h\u001a\u00020\rJ\u0019\u0010±\u0001\u001a\u0004\u0018\u00010\u00072\u0006\u0010N\u001a\u00020\rH\u0000¢\u0006\u0003\b²\u0001J\u0013\u0010³\u0001\u001a\u0004\u0018\u00010\u00012\b\u0010J\u001a\u0004\u0018\u00010\u0001J\u001b\u0010´\u0001\u001a\u00020D2\u0007\u0010µ\u0001\u001a\u00020\r2\u0007\u0010¶\u0001\u001a\u00020\rH\u0002J\u0011\u0010·\u0001\u001a\u00020D2\b\u0010J\u001a\u0004\u0018\u00010\u0001J\u0011\u0010¸\u0001\u001a\u00020D2\u0006\u0010N\u001a\u00020\rH\u0002J\u001a\u0010¹\u0001\u001a\u00020D2\u0006\u0010N\u001a\u00020\r2\u0007\u0010\u0001\u001a\u000201H\u0002J\u0019\u0010º\u0001\u001a\u00020D2\u0006\u0010F\u001a\u00020\u00072\b\u0010J\u001a\u0004\u0018\u00010\u0001J\u0011\u0010º\u0001\u001a\u00020D2\b\u0010J\u001a\u0004\u0018\u00010\u0001J\u001b\u0010»\u0001\u001a\u00020D2\u0006\u0010G\u001a\u00020\r2\b\u0010J\u001a\u0004\u0018\u00010\u0001H\u0002J\u0011\u0010¼\u0001\u001a\u00020D2\b\u0010J\u001a\u0004\u0018\u00010\u0001J\u0007\u0010½\u0001\u001a\u00020DJ\u000f\u0010¾\u0001\u001a\u00020DH\u0000¢\u0006\u0003\b¿\u0001J\u000f\u0010À\u0001\u001a\u00020DH\u0000¢\u0006\u0003\bÁ\u0001J\u0016\u0010Â\u0001\u001a\u00020\r*\u00020(2\u0007\u0010Ã\u0001\u001a\u00020\rH\u0002J\u0015\u0010V\u001a\u00020\r*\u00020(2\u0007\u0010Ã\u0001\u001a\u00020\rH\u0002J\u0013\u0010Ä\u0001\u001a\b\u0012\u0004\u0012\u00020\r0z*\u00020(H\u0002J\u001b\u0010Å\u0001\u001a\u00020D*\b0Æ\u0001j\u0003`Ç\u00012\u0006\u0010G\u001a\u00020\rH\u0002J\u0016\u0010È\u0001\u001a\u00020\r*\u00020(2\u0007\u0010Ã\u0001\u001a\u00020\rH\u0002J\u0014\u0010.\u001a\u00020\r*\u00020(2\u0006\u0010G\u001a\u00020\rH\u0002J\u0016\u0010É\u0001\u001a\u00020\r*\u00020(2\u0007\u0010Ã\u0001\u001a\u00020\rH\u0002J\u001e\u0010Ê\u0001\u001a\u00020D*\u00020(2\u0007\u0010Ã\u0001\u001a\u00020\r2\u0006\u0010V\u001a\u00020\rH\u0002R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014R\u001e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000fR\u001e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000fR\u0014\u0010\u001d\u001a\u00020\r8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u000fR\u000e\u0010\u001f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\"\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010*\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b*\u0010\u0014R\u0011\u0010+\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b+\u0010\u0014R\u000e\u0010,\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010.\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u000fR\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\u00020\r8@X\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u000fR\u0018\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000105X\u000e¢\u0006\u0004\n\u0002\u00106R\u000e\u00107\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010:\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b;\u0010\u000fR.\u0010<\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020>\u0018\u00010=j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020>\u0018\u0001`?X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010B¨\u0006Ì\u0001"}, d2 = {"Landroidx/compose/runtime/SlotWriter;", "", "table", "Landroidx/compose/runtime/SlotTable;", "(Landroidx/compose/runtime/SlotTable;)V", "anchors", "Ljava/util/ArrayList;", "Landroidx/compose/runtime/Anchor;", "Lkotlin/collections/ArrayList;", "calledByMap", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/collection/MutableIntSet;", "capacity", "", "getCapacity", "()I", "<set-?>", "", "closed", "getClosed", "()Z", "collectingCalledInformation", "getCollectingCalledInformation", "collectingSourceInformation", "getCollectingSourceInformation", "currentGroup", "getCurrentGroup", "currentGroupEnd", "getCurrentGroupEnd", "currentGroupSlotIndex", "getCurrentGroupSlotIndex", "currentSlot", "currentSlotEnd", "deferredSlotWrites", "Landroidx/collection/MutableObjectList;", "endStack", "Landroidx/compose/runtime/IntStack;", "groupGapLen", "groupGapStart", "groups", "", "insertCount", "isGroupEnd", "isNode", "nodeCount", "nodeCountStack", "parent", "getParent", "pendingRecalculateMarks", "Landroidx/compose/runtime/PrioritySet;", "size", "getSize$runtime_release", "slots", "", "[Ljava/lang/Object;", "slotsGapLen", "slotsGapOwner", "slotsGapStart", "slotsSize", "getSlotsSize", "sourceInformationMap", "Ljava/util/HashMap;", "Landroidx/compose/runtime/GroupSourceInformation;", "Lkotlin/collections/HashMap;", "startStack", "getTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "advanceBy", "", "amount", "anchor", "index", "anchorIndex", "appendSlot", "value", "bashCurrentGroup", "beginInsert", "childContainsAnyMarks", "group", "clearSlotGap", "close", "normalClose", "containsAnyGroupMarks", "containsGroupMark", "dataAnchorToDataIndex", "gapLen", "dataIndex", "dataIndexToDataAddress", "dataIndexToDataAnchor", "gapStart", "endGroup", "endInsert", "ensureStarted", "fixParentAnchorsFor", "firstChild", "forAllData", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "data", "forEachData", "forEachTailSlot", "groupIndex", "count", "groupAux", "groupIndexToAddress", "groupKey", "groupObjectKey", "groupSize", "groupSlots", "", "groupSourceInformationFor", "sourceInformation", "", "indexInCurrentGroup", "indexInGroup", "indexInParent", "insertAux", "insertGroups", "insertSlots", "keys", "", "markGroup", "moveAnchors", "originalLocation", "newLocation", "moveFrom", "removeSourceGroup", "moveGroup", "offset", "moveGroupGapTo", "moveIntoGroupFrom", "moveSlotGapTo", "moveTo", "writer", "node", "parentAnchorToIndex", "parentIndexToAnchor", "rawUpdate", "recalculateMarks", "recordGroupSourceInformation", "recordGrouplessCallSourceInformationEnd", "recordGrouplessCallSourceInformationStart", "key", "removeAnchors", "removeGroup", "removeGroups", "start", "len", "removeSlots", "reset", "restoreCurrentGroupEnd", "saveCurrentGroupEnd", "seek", "set", "skip", "skipGroup", "skipToGroupEnd", "slot", "slotIndexOfGroupSlotIndex", "slotsEndAllIndex", "slotsEndAllIndex$runtime_release", "slotsEndIndex", "slotsEndIndex$runtime_release", "slotsStartIndex", "slotsStartIndex$runtime_release", "sourceInformationOf", "startData", "aux", "objectKey", "startGroup", "dataKey", "startNode", "toDebugString", "toString", "trimTailSlots", "tryAnchor", "tryAnchor$runtime_release", "update", "updateAnchors", "previousGapStart", "newGapStart", "updateAux", "updateContainsMark", "updateContainsMarkNow", "updateNode", "updateNodeOfGroup", "updateParentNode", "updateToTableMaps", "verifyDataAnchors", "verifyDataAnchors$runtime_release", "verifyParentAnchors", "verifyParentAnchors$runtime_release", "auxIndex", "address", "dataIndexes", "groupAsString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "nodeIndex", "slotIndex", "updateDataIndex", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SlotTable.kt */
public final class SlotWriter {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public ArrayList<Anchor> anchors;
    private MutableIntObjectMap<MutableIntSet> calledByMap;
    private boolean closed;
    /* access modifiers changed from: private */
    public int currentGroup;
    private int currentGroupEnd;
    /* access modifiers changed from: private */
    public int currentSlot;
    private int currentSlotEnd;
    private MutableIntObjectMap<MutableObjectList<Object>> deferredSlotWrites;
    private final IntStack endStack = new IntStack();
    private int groupGapLen;
    /* access modifiers changed from: private */
    public int groupGapStart;
    /* access modifiers changed from: private */
    public int[] groups;
    private int insertCount;
    /* access modifiers changed from: private */
    public int nodeCount;
    private final IntStack nodeCountStack = new IntStack();
    private int parent;
    private PrioritySet pendingRecalculateMarks;
    /* access modifiers changed from: private */
    public Object[] slots;
    /* access modifiers changed from: private */
    public int slotsGapLen;
    /* access modifiers changed from: private */
    public int slotsGapOwner;
    /* access modifiers changed from: private */
    public int slotsGapStart;
    /* access modifiers changed from: private */
    public HashMap<Anchor, GroupSourceInformation> sourceInformationMap;
    private final IntStack startStack = new IntStack();
    private final SlotTable table;

    private final int dataAnchorToDataIndex(int i, int i2, int i3) {
        return i < 0 ? (i3 - i2) + i + 1 : i;
    }

    /* access modifiers changed from: private */
    public final int dataIndexToDataAnchor(int i, int i2, int i3, int i4) {
        return i > i2 ? -(((i4 - i3) - i) + 1) : i;
    }

    public SlotWriter(SlotTable slotTable) {
        this.table = slotTable;
        this.groups = slotTable.getGroups();
        this.slots = slotTable.getSlots();
        this.anchors = slotTable.getAnchors$runtime_release();
        this.sourceInformationMap = slotTable.getSourceInformationMap$runtime_release();
        this.calledByMap = slotTable.getCalledByMap$runtime_release();
        this.groupGapStart = slotTable.getGroupsSize();
        this.groupGapLen = (this.groups.length / 5) - slotTable.getGroupsSize();
        this.slotsGapStart = slotTable.getSlotsSize();
        this.slotsGapLen = this.slots.length - slotTable.getSlotsSize();
        this.slotsGapOwner = slotTable.getGroupsSize();
        this.currentGroupEnd = slotTable.getGroupsSize();
        this.parent = -1;
    }

    public final SlotTable getTable$runtime_release() {
        return this.table;
    }

    public final int getCurrentGroup() {
        return this.currentGroup;
    }

    public final int getCurrentGroupEnd() {
        return this.currentGroupEnd;
    }

    public final boolean isGroupEnd() {
        return this.currentGroup == this.currentGroupEnd;
    }

    public final int getSlotsSize() {
        return this.slots.length - this.slotsGapLen;
    }

    public final boolean isNode() {
        int i = this.currentGroup;
        return i < this.currentGroupEnd && SlotTableKt.isNode(this.groups, groupIndexToAddress(i));
    }

    public final boolean getCollectingSourceInformation() {
        return this.sourceInformationMap != null;
    }

    public final boolean getCollectingCalledInformation() {
        return this.calledByMap != null;
    }

    public final boolean isNode(int i) {
        return SlotTableKt.isNode(this.groups, groupIndexToAddress(i));
    }

    public final int nodeCount(int i) {
        return SlotTableKt.nodeCount(this.groups, groupIndexToAddress(i));
    }

    public final int groupKey(int i) {
        return SlotTableKt.key(this.groups, groupIndexToAddress(i));
    }

    public final Object groupObjectKey(int i) {
        int groupIndexToAddress = groupIndexToAddress(i);
        if (SlotTableKt.hasObjectKey(this.groups, groupIndexToAddress)) {
            return this.slots[SlotTableKt.objectKeyIndex(this.groups, groupIndexToAddress)];
        }
        return null;
    }

    public final int groupSize(int i) {
        return SlotTableKt.groupSize(this.groups, groupIndexToAddress(i));
    }

    public final Object groupAux(int i) {
        int groupIndexToAddress = groupIndexToAddress(i);
        return SlotTableKt.hasAux(this.groups, groupIndexToAddress) ? this.slots[auxIndex(this.groups, groupIndexToAddress)] : Composer.Companion.getEmpty();
    }

    public final boolean indexInParent(int i) {
        int i2 = this.parent;
        if (i <= i2 || i >= this.currentGroupEnd) {
            return i2 == 0 && i == 0;
        }
        return true;
    }

    public final boolean indexInCurrentGroup(int i) {
        return indexInGroup(i, this.currentGroup);
    }

    public final boolean indexInGroup(int i, int i2) {
        int i3;
        int groupSize;
        if (i2 == this.parent) {
            i3 = this.currentGroupEnd;
        } else {
            if (i2 > this.startStack.peekOr(0)) {
                groupSize = groupSize(i2);
            } else {
                int indexOf = this.startStack.indexOf(i2);
                if (indexOf < 0) {
                    groupSize = groupSize(i2);
                } else {
                    i3 = (getCapacity() - this.groupGapLen) - this.endStack.peek(indexOf);
                }
            }
            i3 = groupSize + i2;
        }
        if (i <= i2 || i >= i3) {
            return false;
        }
        return true;
    }

    public final Object node(int i) {
        int groupIndexToAddress = groupIndexToAddress(i);
        if (SlotTableKt.isNode(this.groups, groupIndexToAddress)) {
            return this.slots[dataIndexToDataAddress(nodeIndex(this.groups, groupIndexToAddress))];
        }
        return null;
    }

    public final Object node(Anchor anchor) {
        return node(anchor.toIndexFor(this));
    }

    public final int getParent() {
        return this.parent;
    }

    public final int parent(int i) {
        return parent(this.groups, i);
    }

    public final int parent(Anchor anchor) {
        if (anchor.getValid()) {
            return parent(this.groups, anchorIndex(anchor));
        }
        return -1;
    }

    public final boolean getClosed() {
        return this.closed;
    }

    public final void close(boolean z) {
        this.closed = true;
        if (z && this.startStack.isEmpty()) {
            moveGroupGapTo(getSize$runtime_release());
            moveSlotGapTo(this.slots.length - this.slotsGapLen, this.groupGapStart);
            clearSlotGap();
            recalculateMarks();
        }
        this.table.close$runtime_release(this, this.groups, this.groupGapStart, this.slots, this.slotsGapStart, this.anchors, this.sourceInformationMap, this.calledByMap);
    }

    public final void reset() {
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot reset when inserting");
        }
        recalculateMarks();
        this.currentGroup = 0;
        this.currentGroupEnd = getCapacity() - this.groupGapLen;
        this.currentSlot = 0;
        this.currentSlotEnd = 0;
        this.nodeCount = 0;
    }

    public final Object update(Object obj) {
        if (this.insertCount <= 0 || this.currentSlot == this.slotsGapStart) {
            return rawUpdate(obj);
        }
        MutableIntObjectMap<MutableObjectList<Object>> mutableIntObjectMap = this.deferredSlotWrites;
        if (mutableIntObjectMap == null) {
            mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, (DefaultConstructorMarker) null);
        }
        this.deferredSlotWrites = mutableIntObjectMap;
        int i = this.parent;
        MutableObjectList<Object> mutableObjectList = mutableIntObjectMap.get(i);
        if (mutableObjectList == null) {
            mutableObjectList = new MutableObjectList<>(0, 1, (DefaultConstructorMarker) null);
            mutableIntObjectMap.set(i, mutableObjectList);
        }
        mutableObjectList.add(obj);
        return Composer.Companion.getEmpty();
    }

    private final Object rawUpdate(Object obj) {
        Object skip = skip();
        set(obj);
        return skip;
    }

    public final void appendSlot(Anchor anchor, Object obj) {
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Can only append a slot if not current inserting");
        }
        int i = this.currentSlot;
        int i2 = this.currentSlotEnd;
        int anchorIndex = anchorIndex(anchor);
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(anchorIndex + 1));
        this.currentSlot = dataIndex;
        this.currentSlotEnd = dataIndex;
        insertSlots(1, anchorIndex);
        if (i >= dataIndex) {
            i++;
            i2++;
        }
        this.slots[dataIndex] = obj;
        this.currentSlot = i;
        this.currentSlotEnd = i2;
    }

    public final void trimTailSlots(int i) {
        boolean z = false;
        ComposerKt.runtimeCheck(i > 0);
        int i2 = this.parent;
        int slotIndex = slotIndex(this.groups, groupIndexToAddress(i2));
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(i2 + 1)) - i;
        if (dataIndex >= slotIndex) {
            z = true;
        }
        ComposerKt.runtimeCheck(z);
        removeSlots(dataIndex, i, i2);
        int i3 = this.currentSlot;
        if (i3 >= slotIndex) {
            this.currentSlot = i3 - i;
        }
    }

    public final void updateAux(Object obj) {
        int groupIndexToAddress = groupIndexToAddress(this.currentGroup);
        if (!SlotTableKt.hasAux(this.groups, groupIndexToAddress)) {
            ComposerKt.composeImmediateRuntimeError("Updating the data of a group that was not created with a data slot");
        }
        this.slots[dataIndexToDataAddress(auxIndex(this.groups, groupIndexToAddress))] = obj;
    }

    public final void insertAux(Object obj) {
        boolean z = false;
        if (!(this.insertCount >= 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot insert auxiliary data when not inserting");
        }
        int i = this.parent;
        int groupIndexToAddress = groupIndexToAddress(i);
        if (SlotTableKt.hasAux(this.groups, groupIndexToAddress)) {
            ComposerKt.composeImmediateRuntimeError("Group already has auxiliary data");
        }
        insertSlots(1, i);
        int auxIndex = auxIndex(this.groups, groupIndexToAddress);
        int dataIndexToDataAddress = dataIndexToDataAddress(auxIndex);
        int i2 = this.currentSlot;
        if (i2 > auxIndex) {
            int i3 = i2 - auxIndex;
            if (i3 < 3) {
                z = true;
            }
            if (!z) {
                PreconditionsKt.throwIllegalStateException("Moving more than two slot not supported");
            }
            if (i3 > 1) {
                Object[] objArr = this.slots;
                objArr[dataIndexToDataAddress + 2] = objArr[dataIndexToDataAddress + 1];
            }
            Object[] objArr2 = this.slots;
            objArr2[dataIndexToDataAddress + 1] = objArr2[dataIndexToDataAddress];
        }
        SlotTableKt.addAux(this.groups, groupIndexToAddress);
        this.slots[dataIndexToDataAddress] = obj;
        this.currentSlot++;
    }

    public final void updateToTableMaps() {
        this.sourceInformationMap = this.table.getSourceInformationMap$runtime_release();
        this.calledByMap = this.table.getCalledByMap$runtime_release();
    }

    public final void recordGroupSourceInformation(String str) {
        if (this.insertCount > 0) {
            groupSourceInformationFor(this.parent, str);
        }
    }

    public final void recordGrouplessCallSourceInformationStart(int i, String str) {
        if (this.insertCount > 0) {
            MutableIntObjectMap<MutableIntSet> mutableIntObjectMap = this.calledByMap;
            if (mutableIntObjectMap != null) {
                SlotTableKt.add(mutableIntObjectMap, i, groupKey(this.parent));
            }
            GroupSourceInformation groupSourceInformationFor = groupSourceInformationFor(this.parent, (String) null);
            if (groupSourceInformationFor != null) {
                groupSourceInformationFor.startGrouplessCall(i, str, getCurrentGroupSlotIndex());
            }
        }
    }

    public final void recordGrouplessCallSourceInformationEnd() {
        GroupSourceInformation groupSourceInformationFor;
        if (this.insertCount > 0 && (groupSourceInformationFor = groupSourceInformationFor(this.parent, (String) null)) != null) {
            groupSourceInformationFor.endGrouplessCall(getCurrentGroupSlotIndex());
        }
    }

    private final GroupSourceInformation groupSourceInformationFor(int i, String str) {
        HashMap<Anchor, GroupSourceInformation> hashMap = this.sourceInformationMap;
        if (hashMap == null) {
            return null;
        }
        Map map = hashMap;
        Anchor anchor = anchor(i);
        Object obj = map.get(anchor);
        GroupSourceInformation groupSourceInformation = obj;
        if (obj == null) {
            GroupSourceInformation groupSourceInformation2 = new GroupSourceInformation(0, str, 0);
            if (str == null) {
                int i2 = i + 1;
                int i3 = this.currentGroup;
                while (i2 < i3) {
                    groupSourceInformation2.reportGroup(this, i2);
                    i2 += SlotTableKt.groupSize(this.groups, i2);
                }
            }
            map.put(anchor, groupSourceInformation2);
            groupSourceInformation = groupSourceInformation2;
        }
        return (GroupSourceInformation) groupSourceInformation;
    }

    public final void updateNode(Object obj) {
        updateNodeOfGroup(this.currentGroup, obj);
    }

    public final void updateNode(Anchor anchor, Object obj) {
        updateNodeOfGroup(anchor.toIndexFor(this), obj);
    }

    public final void updateParentNode(Object obj) {
        updateNodeOfGroup(this.parent, obj);
    }

    public final void set(Object obj) {
        if (!(this.currentSlot <= this.currentSlotEnd)) {
            ComposerKt.composeImmediateRuntimeError("Writing to an invalid slot");
        }
        this.slots[dataIndexToDataAddress(this.currentSlot - 1)] = obj;
    }

    public final Object set(int i, Object obj) {
        return set(this.currentGroup, i, obj);
    }

    public final int slotIndexOfGroupSlotIndex(int i, int i2) {
        int slotIndex = slotIndex(this.groups, groupIndexToAddress(i));
        int i3 = slotIndex + i2;
        if (!(i3 >= slotIndex && i3 < dataIndex(this.groups, groupIndexToAddress(i + 1)))) {
            ComposerKt.composeImmediateRuntimeError("Write to an invalid slot index " + i2 + " for group " + i);
        }
        return i3;
    }

    public final Object set(int i, int i2, Object obj) {
        int dataIndexToDataAddress = dataIndexToDataAddress(slotIndexOfGroupSlotIndex(i, i2));
        Object[] objArr = this.slots;
        Object obj2 = objArr[dataIndexToDataAddress];
        objArr[dataIndexToDataAddress] = obj;
        return obj2;
    }

    public final Object skip() {
        if (this.insertCount > 0) {
            insertSlots(1, this.parent);
        }
        Object[] objArr = this.slots;
        int i = this.currentSlot;
        this.currentSlot = i + 1;
        return objArr[dataIndexToDataAddress(i)];
    }

    public final Object slot(Anchor anchor, int i) {
        return slot(anchorIndex(anchor), i);
    }

    public final Object slot(int i, int i2) {
        int slotIndex = slotIndex(this.groups, groupIndexToAddress(i));
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(i + 1));
        int i3 = i2 + slotIndex;
        if (slotIndex > i3 || i3 >= dataIndex) {
            return Composer.Companion.getEmpty();
        }
        return this.slots[dataIndexToDataAddress(i3)];
    }

    public final void forEachTailSlot(int i, int i2, Function2<? super Integer, Object, Unit> function2) {
        int slotsStartIndex$runtime_release = slotsStartIndex$runtime_release(i);
        int slotsEndIndex$runtime_release = slotsEndIndex$runtime_release(i);
        for (int max = Math.max(slotsStartIndex$runtime_release, slotsEndIndex$runtime_release - i2); max < slotsEndIndex$runtime_release; max++) {
            function2.invoke(Integer.valueOf(max), this.slots[dataIndexToDataAddress(max)]);
        }
    }

    public final int slotsStartIndex$runtime_release(int i) {
        return slotIndex(this.groups, groupIndexToAddress(i));
    }

    public final int slotsEndIndex$runtime_release(int i) {
        return dataIndex(this.groups, groupIndexToAddress(i + 1));
    }

    public final int slotsEndAllIndex$runtime_release(int i) {
        return dataIndex(this.groups, groupIndexToAddress(i + groupSize(i)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r1 = r1.get(r3.parent);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int getCurrentGroupSlotIndex() {
        /*
            r3 = this;
            int r0 = r3.currentSlot
            int r1 = r3.parent
            int r1 = r3.slotsStartIndex$runtime_release(r1)
            int r0 = r0 - r1
            androidx.collection.MutableIntObjectMap<androidx.collection.MutableObjectList<java.lang.Object>> r1 = r3.deferredSlotWrites
            if (r1 == 0) goto L_0x001c
            int r2 = r3.parent
            java.lang.Object r1 = r1.get(r2)
            androidx.collection.MutableObjectList r1 = (androidx.collection.MutableObjectList) r1
            if (r1 == 0) goto L_0x001c
            int r1 = r1.getSize()
            goto L_0x001d
        L_0x001c:
            r1 = 0
        L_0x001d:
            int r0 = r0 + r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SlotWriter.getCurrentGroupSlotIndex():int");
    }

    public final void advanceBy(int i) {
        boolean z = true;
        if (!(i >= 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot seek backwards");
        }
        if (!(this.insertCount <= 0)) {
            PreconditionsKt.throwIllegalStateException("Cannot call seek() while inserting");
        }
        if (i != 0) {
            int i2 = this.currentGroup + i;
            if (i2 < this.parent || i2 > this.currentGroupEnd) {
                z = false;
            }
            if (!z) {
                ComposerKt.composeImmediateRuntimeError("Cannot seek outside the current group (" + this.parent + '-' + this.currentGroupEnd + ')');
            }
            this.currentGroup = i2;
            int dataIndex = dataIndex(this.groups, groupIndexToAddress(i2));
            this.currentSlot = dataIndex;
            this.currentSlotEnd = dataIndex;
        }
    }

    public final void seek(Anchor anchor) {
        advanceBy(anchor.toIndexFor(this) - this.currentGroup);
    }

    public final void skipToGroupEnd() {
        int i = this.currentGroupEnd;
        this.currentGroup = i;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(i));
    }

    public final void beginInsert() {
        int i = this.insertCount;
        this.insertCount = i + 1;
        if (i == 0) {
            saveCurrentGroupEnd();
        }
    }

    public final void endInsert() {
        boolean z = true;
        if (!(this.insertCount > 0)) {
            PreconditionsKt.throwIllegalStateException("Unbalanced begin/end insert");
        }
        int i = this.insertCount - 1;
        this.insertCount = i;
        if (i == 0) {
            if (this.nodeCountStack.getSize() != this.startStack.getSize()) {
                z = false;
            }
            if (!z) {
                ComposerKt.composeImmediateRuntimeError("startGroup/endGroup mismatch while inserting");
            }
            restoreCurrentGroupEnd();
        }
    }

    public final void startGroup() {
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Key must be supplied when inserting");
        }
        startGroup(0, Composer.Companion.getEmpty(), false, Composer.Companion.getEmpty());
    }

    public final void startGroup(int i) {
        startGroup(i, Composer.Companion.getEmpty(), false, Composer.Companion.getEmpty());
    }

    public final void startGroup(int i, Object obj) {
        startGroup(i, obj, false, Composer.Companion.getEmpty());
    }

    public final void startNode(int i, Object obj) {
        startGroup(i, obj, true, Composer.Companion.getEmpty());
    }

    public final void startNode(int i, Object obj, Object obj2) {
        startGroup(i, obj, true, obj2);
    }

    public final void startData(int i, Object obj, Object obj2) {
        startGroup(i, obj, false, obj2);
    }

    public final void startData(int i, Object obj) {
        startGroup(i, Composer.Companion.getEmpty(), false, obj);
    }

    private final void startGroup(int i, Object obj, boolean z, Object obj2) {
        int i2;
        GroupSourceInformation sourceInformationOf;
        Object obj3 = obj;
        Object obj4 = obj2;
        int i3 = this.parent;
        boolean z2 = this.insertCount > 0;
        this.nodeCountStack.push(this.nodeCount);
        if (z2) {
            int i4 = this.currentGroup;
            int dataIndex = dataIndex(this.groups, groupIndexToAddress(i4));
            insertGroups(1);
            this.currentSlot = dataIndex;
            this.currentSlotEnd = dataIndex;
            int groupIndexToAddress = groupIndexToAddress(i4);
            boolean z3 = obj3 != Composer.Companion.getEmpty();
            boolean z4 = !z && obj4 != Composer.Companion.getEmpty();
            int dataIndexToDataAnchor = dataIndexToDataAnchor(dataIndex, this.slotsGapStart, this.slotsGapLen, this.slots.length);
            if (dataIndexToDataAnchor >= 0 && this.slotsGapOwner < i4) {
                dataIndexToDataAnchor = -(((this.slots.length - this.slotsGapLen) - dataIndexToDataAnchor) + 1);
            }
            SlotTableKt.initGroup(this.groups, groupIndexToAddress, i, z, z3, z4, this.parent, dataIndexToDataAnchor);
            int i5 = (z ? 1 : 0) + (z3 ? 1 : 0) + (z4 ? 1 : 0);
            if (i5 > 0) {
                insertSlots(i5, i4);
                Object[] objArr = this.slots;
                int i6 = this.currentSlot;
                if (z) {
                    objArr[i6] = obj4;
                    i6++;
                }
                if (z3) {
                    objArr[i6] = obj3;
                    i6++;
                }
                if (z4) {
                    objArr[i6] = obj4;
                    i6++;
                }
                this.currentSlot = i6;
            }
            this.nodeCount = 0;
            i2 = i4 + 1;
            this.parent = i4;
            this.currentGroup = i2;
            if (i3 >= 0 && (sourceInformationOf = sourceInformationOf(i3)) != null) {
                sourceInformationOf.reportGroup(this, i4);
            }
        } else {
            this.startStack.push(i3);
            saveCurrentGroupEnd();
            int i7 = this.currentGroup;
            int groupIndexToAddress2 = groupIndexToAddress(i7);
            if (!Intrinsics.areEqual(obj4, Composer.Companion.getEmpty())) {
                if (z) {
                    updateNode(obj4);
                } else {
                    updateAux(obj4);
                }
            }
            this.currentSlot = slotIndex(this.groups, groupIndexToAddress2);
            this.currentSlotEnd = dataIndex(this.groups, groupIndexToAddress(this.currentGroup + 1));
            this.nodeCount = SlotTableKt.nodeCount(this.groups, groupIndexToAddress2);
            this.parent = i7;
            this.currentGroup = i7 + 1;
            i2 = i7 + SlotTableKt.groupSize(this.groups, groupIndexToAddress2);
        }
        this.currentGroupEnd = i2;
    }

    public final int endGroup() {
        MutableObjectList mutableObjectList;
        boolean z = true;
        int i = 0;
        boolean z2 = this.insertCount > 0;
        int i2 = this.currentGroup;
        int i3 = this.currentGroupEnd;
        int i4 = this.parent;
        int groupIndexToAddress = groupIndexToAddress(i4);
        int i5 = this.nodeCount;
        int i6 = i2 - i4;
        boolean access$isNode = SlotTableKt.isNode(this.groups, groupIndexToAddress);
        if (z2) {
            MutableIntObjectMap<MutableObjectList<Object>> mutableIntObjectMap = this.deferredSlotWrites;
            if (!(mutableIntObjectMap == null || (mutableObjectList = mutableIntObjectMap.get(i4)) == null)) {
                ObjectList objectList = mutableObjectList;
                Object[] objArr = objectList.content;
                int i7 = objectList._size;
                for (int i8 = 0; i8 < i7; i8++) {
                    rawUpdate(objArr[i8]);
                }
                MutableObjectList remove = mutableIntObjectMap.remove(i4);
            }
            SlotTableKt.updateGroupSize(this.groups, groupIndexToAddress, i6);
            SlotTableKt.updateNodeCount(this.groups, groupIndexToAddress, i5);
            this.nodeCount = this.nodeCountStack.pop() + (access$isNode ? 1 : i5);
            int parent2 = parent(this.groups, i4);
            this.parent = parent2;
            int size$runtime_release = parent2 < 0 ? getSize$runtime_release() : groupIndexToAddress(parent2 + 1);
            if (size$runtime_release >= 0) {
                i = dataIndex(this.groups, size$runtime_release);
            }
            this.currentSlot = i;
            this.currentSlotEnd = i;
            return i5;
        }
        if (i2 != i3) {
            z = false;
        }
        if (!z) {
            ComposerKt.composeImmediateRuntimeError("Expected to be at the end of a group");
        }
        int access$groupSize = SlotTableKt.groupSize(this.groups, groupIndexToAddress);
        int access$nodeCount = SlotTableKt.nodeCount(this.groups, groupIndexToAddress);
        SlotTableKt.updateGroupSize(this.groups, groupIndexToAddress, i6);
        SlotTableKt.updateNodeCount(this.groups, groupIndexToAddress, i5);
        int pop = this.startStack.pop();
        restoreCurrentGroupEnd();
        this.parent = pop;
        int parent3 = parent(this.groups, i4);
        int pop2 = this.nodeCountStack.pop();
        this.nodeCount = pop2;
        if (parent3 == pop) {
            if (!access$isNode) {
                i = i5 - access$nodeCount;
            }
            this.nodeCount = pop2 + i;
            return i5;
        }
        int i9 = i6 - access$groupSize;
        int i10 = access$isNode ? 0 : i5 - access$nodeCount;
        if (!(i9 == 0 && i10 == 0)) {
            while (parent3 != 0 && parent3 != pop && (i10 != 0 || i9 != 0)) {
                int groupIndexToAddress2 = groupIndexToAddress(parent3);
                if (i9 != 0) {
                    SlotTableKt.updateGroupSize(this.groups, groupIndexToAddress2, SlotTableKt.groupSize(this.groups, groupIndexToAddress2) + i9);
                }
                if (i10 != 0) {
                    int[] iArr = this.groups;
                    SlotTableKt.updateNodeCount(iArr, groupIndexToAddress2, SlotTableKt.nodeCount(iArr, groupIndexToAddress2) + i10);
                }
                if (SlotTableKt.isNode(this.groups, groupIndexToAddress2)) {
                    i10 = 0;
                }
                parent3 = parent(this.groups, parent3);
            }
        }
        this.nodeCount += i10;
        return i5;
    }

    public final void ensureStarted(int i) {
        boolean z = true;
        if (!(this.insertCount <= 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot call ensureStarted() while inserting");
        }
        int i2 = this.parent;
        if (i2 != i) {
            if (i < i2 || i >= this.currentGroupEnd) {
                z = false;
            }
            if (!z) {
                ComposerKt.composeImmediateRuntimeError("Started group at " + i + " must be a subgroup of the group at " + i2);
            }
            int i3 = this.currentGroup;
            int i4 = this.currentSlot;
            int i5 = this.currentSlotEnd;
            this.currentGroup = i;
            startGroup();
            this.currentGroup = i3;
            this.currentSlot = i4;
            this.currentSlotEnd = i5;
        }
    }

    public final void ensureStarted(Anchor anchor) {
        ensureStarted(anchor.toIndexFor(this));
    }

    public final int skipGroup() {
        int groupIndexToAddress = groupIndexToAddress(this.currentGroup);
        int access$groupSize = this.currentGroup + SlotTableKt.groupSize(this.groups, groupIndexToAddress);
        this.currentGroup = access$groupSize;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(access$groupSize));
        if (SlotTableKt.isNode(this.groups, groupIndexToAddress)) {
            return 1;
        }
        return SlotTableKt.nodeCount(this.groups, groupIndexToAddress);
    }

    public final boolean removeGroup() {
        Anchor tryAnchor$runtime_release;
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot remove group while inserting");
        }
        int i = this.currentGroup;
        int i2 = this.currentSlot;
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(i));
        int skipGroup = skipGroup();
        GroupSourceInformation sourceInformationOf = sourceInformationOf(this.parent);
        if (!(sourceInformationOf == null || (tryAnchor$runtime_release = tryAnchor$runtime_release(i)) == null)) {
            sourceInformationOf.removeAnchor(tryAnchor$runtime_release);
        }
        PrioritySet prioritySet = this.pendingRecalculateMarks;
        if (prioritySet != null) {
            while (prioritySet.isNotEmpty() && prioritySet.peek() >= i) {
                prioritySet.takeMax();
            }
        }
        boolean removeGroups = removeGroups(i, this.currentGroup - i);
        removeSlots(dataIndex, this.currentSlot - dataIndex, i - 1);
        this.currentGroup = i;
        this.currentSlot = i2;
        this.nodeCount -= skipGroup;
        return removeGroups;
    }

    public final Iterator<Object> groupSlots() {
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(this.currentGroup));
        int[] iArr = this.groups;
        int i = this.currentGroup;
        return new SlotWriter$groupSlots$1(dataIndex, dataIndex(iArr, groupIndexToAddress(i + groupSize(i))), this);
    }

    public final void forEachData(int i, Function2<? super Integer, Object, Unit> function2) {
        int access$slotIndex = slotIndex(this.groups, groupIndexToAddress(i));
        int access$dataIndex = dataIndex(this.groups, groupIndexToAddress(i + 1));
        for (int i2 = access$slotIndex; i2 < access$dataIndex; i2++) {
            function2.invoke(Integer.valueOf(i2 - access$slotIndex), this.slots[dataIndexToDataAddress(i2)]);
        }
    }

    public final void forAllData(int i, Function2<? super Integer, Object, Unit> function2) {
        int access$dataIndex = dataIndex(this.groups, groupIndexToAddress(getCurrentGroup() + groupSize(getCurrentGroup())));
        for (int access$dataIndex2 = dataIndex(this.groups, groupIndexToAddress(i)); access$dataIndex2 < access$dataIndex; access$dataIndex2++) {
            function2.invoke(Integer.valueOf(access$dataIndex2), this.slots[dataIndexToDataAddress(access$dataIndex2)]);
        }
    }

    public final void moveGroup(int i) {
        boolean z = true;
        if (!(this.insertCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot move a group while inserting");
        }
        if (!(i >= 0)) {
            ComposerKt.composeImmediateRuntimeError("Parameter offset is out of bounds");
        }
        if (i != 0) {
            int i2 = this.currentGroup;
            int i3 = this.parent;
            int i4 = this.currentGroupEnd;
            int i5 = i2;
            for (int i6 = i; i6 > 0; i6--) {
                i5 += SlotTableKt.groupSize(this.groups, groupIndexToAddress(i5));
                if (!(i5 <= i4)) {
                    ComposerKt.composeImmediateRuntimeError("Parameter offset is out of bounds");
                }
            }
            int access$groupSize = SlotTableKt.groupSize(this.groups, groupIndexToAddress(i5));
            int dataIndex = dataIndex(this.groups, groupIndexToAddress(this.currentGroup));
            int dataIndex2 = dataIndex(this.groups, groupIndexToAddress(i5));
            int i7 = i5 + access$groupSize;
            int dataIndex3 = dataIndex(this.groups, groupIndexToAddress(i7));
            int i8 = dataIndex3 - dataIndex2;
            insertSlots(i8, Math.max(this.currentGroup - 1, 0));
            insertGroups(access$groupSize);
            int[] iArr = this.groups;
            int groupIndexToAddress = groupIndexToAddress(i7) * 5;
            ArraysKt.copyInto(iArr, iArr, groupIndexToAddress(i2) * 5, groupIndexToAddress, (access$groupSize * 5) + groupIndexToAddress);
            if (i8 > 0) {
                Object[] objArr = this.slots;
                ArraysKt.copyInto((T[]) objArr, (T[]) objArr, dataIndex, dataIndexToDataAddress(dataIndex2 + i8), dataIndexToDataAddress(dataIndex3 + i8));
            }
            int i9 = dataIndex2 + i8;
            int i10 = i9 - dataIndex;
            int i11 = this.slotsGapStart;
            int i12 = this.slotsGapLen;
            int length = this.slots.length;
            int i13 = this.slotsGapOwner;
            int i14 = i2 + access$groupSize;
            int i15 = i2;
            while (i15 < i14) {
                boolean z2 = z;
                int groupIndexToAddress2 = groupIndexToAddress(i15);
                int i16 = i15;
                int i17 = i10;
                updateDataIndex(iArr, groupIndexToAddress2, dataIndexToDataAnchor(dataIndex(iArr, groupIndexToAddress2) - i10, i13 < groupIndexToAddress2 ? 0 : i11, i12, length));
                i15 = i16 + 1;
                z = z2;
                i10 = i17;
            }
            boolean z3 = z;
            moveAnchors(i7, i2, access$groupSize);
            if (removeGroups(i7, access$groupSize)) {
                ComposerKt.composeImmediateRuntimeError("Unexpectedly removed anchors");
            }
            fixParentAnchorsFor(i3, this.currentGroupEnd, i2);
            if (i8 > 0) {
                removeSlots(i9, i8, i7 - 1);
            }
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0002¨\u0006\u000f"}, d2 = {"Landroidx/compose/runtime/SlotWriter$Companion;", "", "()V", "moveGroup", "", "Landroidx/compose/runtime/Anchor;", "fromWriter", "Landroidx/compose/runtime/SlotWriter;", "fromIndex", "", "toWriter", "updateFromCursor", "", "updateToCursor", "removeSourceGroup", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SlotTable.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        static /* synthetic */ List moveGroup$default(Companion companion, SlotWriter slotWriter, int i, SlotWriter slotWriter2, boolean z, boolean z2, boolean z3, int i2, Object obj) {
            if ((i2 & 32) != 0) {
                z3 = true;
            }
            return companion.moveGroup(slotWriter, i, slotWriter2, z, z2, z3);
        }

        /* access modifiers changed from: private */
        public final List<Anchor> moveGroup(SlotWriter slotWriter, int i, SlotWriter slotWriter2, boolean z, boolean z2, boolean z3) {
            int i2;
            List<Anchor> list;
            HashMap hashMap;
            int i3;
            SlotWriter slotWriter3 = slotWriter;
            int i4 = i;
            SlotWriter slotWriter4 = slotWriter2;
            int groupSize = slotWriter.groupSize(i);
            int i5 = i4 + groupSize;
            int access$dataIndex = slotWriter.dataIndex(i);
            int access$dataIndex2 = slotWriter3.dataIndex(i5);
            int i6 = access$dataIndex2 - access$dataIndex;
            boolean access$containsAnyGroupMarks = slotWriter.containsAnyGroupMarks(i);
            slotWriter4.insertGroups(groupSize);
            slotWriter4.insertSlots(i6, slotWriter4.getCurrentGroup());
            if (slotWriter3.groupGapStart < i5) {
                slotWriter3.moveGroupGapTo(i5);
            }
            if (slotWriter3.slotsGapStart < access$dataIndex2) {
                slotWriter3.moveSlotGapTo(access$dataIndex2, i5);
            }
            int[] access$getGroups$p = slotWriter4.groups;
            int currentGroup = slotWriter4.getCurrentGroup();
            ArraysKt.copyInto(slotWriter3.groups, access$getGroups$p, currentGroup * 5, i4 * 5, i5 * 5);
            Object[] access$getSlots$p = slotWriter4.slots;
            int access$getCurrentSlot$p = slotWriter4.currentSlot;
            ArraysKt.copyInto((T[]) slotWriter3.slots, (T[]) access$getSlots$p, access$getCurrentSlot$p, access$dataIndex, access$dataIndex2);
            int parent = slotWriter4.getParent();
            SlotTableKt.updateParentAnchor(access$getGroups$p, currentGroup, parent);
            int i7 = currentGroup + groupSize;
            int access$dataIndex3 = access$getCurrentSlot$p - slotWriter4.dataIndex(access$getGroups$p, currentGroup);
            int access$getSlotsGapOwner$p = slotWriter4.slotsGapOwner;
            boolean z4 = access$containsAnyGroupMarks;
            int access$getSlotsGapLen$p = slotWriter4.slotsGapLen;
            int length = access$getSlots$p.length;
            int i8 = access$getCurrentSlot$p;
            int i9 = access$getSlotsGapOwner$p;
            int i10 = currentGroup - i4;
            int i11 = currentGroup;
            while (true) {
                i2 = 0;
                if (i11 >= i7) {
                    break;
                }
                if (i11 != currentGroup) {
                    i3 = access$dataIndex3;
                    SlotTableKt.updateParentAnchor(access$getGroups$p, i11, SlotTableKt.parentAnchor(access$getGroups$p, i11) + i10);
                } else {
                    i3 = access$dataIndex3;
                }
                int access$dataIndex4 = slotWriter4.dataIndex(access$getGroups$p, i11) + i3;
                if (i9 >= i11) {
                    i2 = slotWriter4.slotsGapStart;
                }
                int i12 = i7;
                SlotTableKt.updateDataAnchor(access$getGroups$p, i11, slotWriter4.dataIndexToDataAnchor(access$dataIndex4, i2, access$getSlotsGapLen$p, length));
                if (i11 == i9) {
                    i9++;
                }
                i11++;
                i7 = i12;
                access$dataIndex3 = i3;
            }
            int i13 = i7;
            slotWriter4.slotsGapOwner = i9;
            int access$locationOf = SlotTableKt.locationOf(slotWriter3.anchors, i4, slotWriter3.getSize$runtime_release());
            int access$locationOf2 = SlotTableKt.locationOf(slotWriter3.anchors, i5, slotWriter3.getSize$runtime_release());
            if (access$locationOf < access$locationOf2) {
                ArrayList access$getAnchors$p = slotWriter3.anchors;
                ArrayList arrayList = new ArrayList(access$locationOf2 - access$locationOf);
                for (int i14 = access$locationOf; i14 < access$locationOf2; i14++) {
                    Anchor anchor = (Anchor) access$getAnchors$p.get(i14);
                    anchor.setLocation$runtime_release(anchor.getLocation$runtime_release() + i10);
                    arrayList.add(anchor);
                }
                slotWriter4.anchors.addAll(SlotTableKt.locationOf(slotWriter4.anchors, slotWriter4.getCurrentGroup(), slotWriter4.getSize$runtime_release()), arrayList);
                access$getAnchors$p.subList(access$locationOf, access$locationOf2).clear();
                list = arrayList;
            } else {
                list = CollectionsKt.emptyList();
            }
            if (!list.isEmpty()) {
                HashMap access$getSourceInformationMap$p = slotWriter3.sourceInformationMap;
                HashMap access$getSourceInformationMap$p2 = slotWriter4.sourceInformationMap;
                if (!(access$getSourceInformationMap$p == null || access$getSourceInformationMap$p2 == null)) {
                    int size = list.size();
                    int i15 = 0;
                    while (i15 < size) {
                        Anchor anchor2 = list.get(i15);
                        GroupSourceInformation groupSourceInformation = (GroupSourceInformation) access$getSourceInformationMap$p.get(anchor2);
                        if (groupSourceInformation != null) {
                            access$getSourceInformationMap$p.remove(anchor2);
                            hashMap = access$getSourceInformationMap$p;
                            access$getSourceInformationMap$p2.put(anchor2, groupSourceInformation);
                        } else {
                            hashMap = access$getSourceInformationMap$p;
                        }
                        i15++;
                        access$getSourceInformationMap$p = hashMap;
                    }
                }
            }
            int parent2 = slotWriter4.getParent();
            GroupSourceInformation access$sourceInformationOf = slotWriter4.sourceInformationOf(parent);
            int i16 = 1;
            if (access$sourceInformationOf != null) {
                int currentGroup2 = slotWriter4.getCurrentGroup();
                int i17 = -1;
                for (int i18 = parent2 + 1; i18 < currentGroup2; i18 = SlotTableKt.groupSize(slotWriter4.groups, i18) + i18) {
                    i17 = i18;
                }
                access$sourceInformationOf.addGroupAfter(slotWriter4, i17, currentGroup2);
            }
            int parent3 = slotWriter.parent(i);
            if (z3) {
                if (z) {
                    if (parent3 >= 0) {
                        i2 = 1;
                    }
                    if (i2 != 0) {
                        slotWriter3.startGroup();
                        slotWriter3.advanceBy(parent3 - slotWriter3.getCurrentGroup());
                        slotWriter3.startGroup();
                    }
                    slotWriter3.advanceBy(i4 - slotWriter3.getCurrentGroup());
                    boolean removeGroup = slotWriter3.removeGroup();
                    if (i2 != 0) {
                        slotWriter3.skipToGroupEnd();
                        slotWriter3.endGroup();
                        slotWriter3.skipToGroupEnd();
                        slotWriter3.endGroup();
                    }
                    i2 = removeGroup;
                } else {
                    i2 = slotWriter3.removeGroups(i4, groupSize);
                    slotWriter3.removeSlots(access$dataIndex, i6, i4 - 1);
                }
            }
            if (i2 != 0) {
                ComposerKt.composeImmediateRuntimeError("Unexpectedly removed anchors");
            }
            int access$getNodeCount$p = slotWriter4.nodeCount;
            if (!SlotTableKt.isNode(access$getGroups$p, currentGroup)) {
                i16 = SlotTableKt.nodeCount(access$getGroups$p, currentGroup);
            }
            slotWriter4.nodeCount = access$getNodeCount$p + i16;
            if (z2) {
                slotWriter4.currentGroup = i13;
                slotWriter4.currentSlot = i8 + i6;
            }
            if (z4) {
                slotWriter4.updateContainsMark(parent);
            }
            return list;
        }
    }

    public final List<Anchor> moveTo(Anchor anchor, int i, SlotWriter slotWriter) {
        SlotWriter slotWriter2 = slotWriter;
        boolean z = true;
        ComposerKt.runtimeCheck(slotWriter2.insertCount > 0);
        ComposerKt.runtimeCheck(this.insertCount == 0);
        ComposerKt.runtimeCheck(anchor.getValid());
        int anchorIndex = anchorIndex(anchor) + i;
        int i2 = this.currentGroup;
        ComposerKt.runtimeCheck(i2 <= anchorIndex && anchorIndex < this.currentGroupEnd);
        int parent2 = parent(anchorIndex);
        int groupSize = groupSize(anchorIndex);
        int nodeCount2 = isNode(anchorIndex) ? 1 : nodeCount(anchorIndex);
        List<Anchor> moveGroup$default = Companion.moveGroup$default(Companion, this, anchorIndex, slotWriter2, false, false, false, 32, (Object) null);
        updateContainsMark(parent2);
        boolean z2 = nodeCount2 > 0;
        while (parent2 >= i2) {
            int groupIndexToAddress = groupIndexToAddress(parent2);
            int[] iArr = this.groups;
            SlotTableKt.updateGroupSize(iArr, groupIndexToAddress, SlotTableKt.groupSize(iArr, groupIndexToAddress) - groupSize);
            if (z2) {
                if (SlotTableKt.isNode(this.groups, groupIndexToAddress)) {
                    z2 = false;
                } else {
                    int[] iArr2 = this.groups;
                    SlotTableKt.updateNodeCount(iArr2, groupIndexToAddress, SlotTableKt.nodeCount(iArr2, groupIndexToAddress) - nodeCount2);
                }
            }
            parent2 = parent(parent2);
        }
        if (z2) {
            if (this.nodeCount < nodeCount2) {
                z = false;
            }
            ComposerKt.runtimeCheck(z);
            this.nodeCount -= nodeCount2;
        }
        return moveGroup$default;
    }

    public static /* synthetic */ List moveFrom$default(SlotWriter slotWriter, SlotTable slotTable, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = true;
        }
        return slotWriter.moveFrom(slotTable, i, z);
    }

    public final List<Anchor> moveFrom(SlotTable slotTable, int i, boolean z) {
        ComposerKt.runtimeCheck(this.insertCount > 0);
        if (i == 0 && this.currentGroup == 0 && this.table.getGroupsSize() == 0 && SlotTableKt.groupSize(slotTable.getGroups(), i) == slotTable.getGroupsSize()) {
            int[] iArr = this.groups;
            Object[] objArr = this.slots;
            ArrayList<Anchor> arrayList = this.anchors;
            HashMap<Anchor, GroupSourceInformation> hashMap = this.sourceInformationMap;
            MutableIntObjectMap<MutableIntSet> mutableIntObjectMap = this.calledByMap;
            int[] groups2 = slotTable.getGroups();
            int groupsSize = slotTable.getGroupsSize();
            Object[] slots2 = slotTable.getSlots();
            int slotsSize = slotTable.getSlotsSize();
            HashMap<Anchor, GroupSourceInformation> sourceInformationMap$runtime_release = slotTable.getSourceInformationMap$runtime_release();
            MutableIntObjectMap<MutableIntSet> calledByMap$runtime_release = slotTable.getCalledByMap$runtime_release();
            this.groups = groups2;
            this.slots = slots2;
            this.anchors = slotTable.getAnchors$runtime_release();
            this.groupGapStart = groupsSize;
            this.groupGapLen = (groups2.length / 5) - groupsSize;
            this.slotsGapStart = slotsSize;
            this.slotsGapLen = slots2.length - slotsSize;
            this.slotsGapOwner = groupsSize;
            this.sourceInformationMap = sourceInformationMap$runtime_release;
            this.calledByMap = calledByMap$runtime_release;
            slotTable.setTo$runtime_release(iArr, 0, objArr, 0, arrayList, hashMap, mutableIntObjectMap);
            return this.anchors;
        }
        SlotWriter openWriter = slotTable.openWriter();
        try {
            List<Anchor> access$moveGroup = Companion.moveGroup(openWriter, i, this, true, true, z);
            openWriter.close(true);
            return access$moveGroup;
        } catch (Throwable th) {
            Throwable th2 = th;
            openWriter.close(false);
            throw th2;
        }
    }

    public final void bashCurrentGroup() {
        SlotTableKt.updateGroupKey(this.groups, this.currentGroup, -3);
    }

    public final List<Anchor> moveIntoGroupFrom(int i, SlotTable slotTable, int i2) {
        ComposerKt.runtimeCheck(this.insertCount <= 0 && groupSize(this.currentGroup + i) == 1);
        int i3 = this.currentGroup;
        int i4 = this.currentSlot;
        int i5 = this.currentSlotEnd;
        advanceBy(i);
        startGroup();
        beginInsert();
        SlotWriter openWriter = slotTable.openWriter();
        try {
            List<Anchor> moveGroup$default = Companion.moveGroup$default(Companion, openWriter, i2, this, false, true, false, 32, (Object) null);
            openWriter.close(true);
            endInsert();
            endGroup();
            this.currentGroup = i3;
            this.currentSlot = i4;
            this.currentSlotEnd = i5;
            return moveGroup$default;
        } catch (Throwable th) {
            Throwable th2 = th;
            openWriter.close(false);
            throw th2;
        }
    }

    public static /* synthetic */ Anchor anchor$default(SlotWriter slotWriter, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = slotWriter.currentGroup;
        }
        return slotWriter.anchor(i);
    }

    public final Anchor anchor(int i) {
        ArrayList<Anchor> arrayList = this.anchors;
        int access$search = SlotTableKt.search(arrayList, i, getSize$runtime_release());
        if (access$search >= 0) {
            return arrayList.get(access$search);
        }
        if (i > this.groupGapStart) {
            i = -(getSize$runtime_release() - i);
        }
        Anchor anchor = new Anchor(i);
        arrayList.add(-(access$search + 1), anchor);
        return anchor;
    }

    public static /* synthetic */ void markGroup$default(SlotWriter slotWriter, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = slotWriter.parent;
        }
        slotWriter.markGroup(i);
    }

    public final void markGroup(int i) {
        int groupIndexToAddress = groupIndexToAddress(i);
        if (!SlotTableKt.hasMark(this.groups, groupIndexToAddress)) {
            SlotTableKt.updateMark(this.groups, groupIndexToAddress, true);
            if (!SlotTableKt.containsMark(this.groups, groupIndexToAddress)) {
                updateContainsMark(parent(i));
            }
        }
    }

    private final boolean containsGroupMark(int i) {
        return i >= 0 && SlotTableKt.containsMark(this.groups, groupIndexToAddress(i));
    }

    /* access modifiers changed from: private */
    public final boolean containsAnyGroupMarks(int i) {
        return i >= 0 && SlotTableKt.containsAnyMark(this.groups, groupIndexToAddress(i));
    }

    private final void recalculateMarks() {
        PrioritySet prioritySet = this.pendingRecalculateMarks;
        if (prioritySet != null) {
            while (prioritySet.isNotEmpty()) {
                updateContainsMarkNow(prioritySet.takeMax(), prioritySet);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateContainsMark(int i) {
        if (i >= 0) {
            PrioritySet prioritySet = this.pendingRecalculateMarks;
            if (prioritySet == null) {
                prioritySet = new PrioritySet((List) null, 1, (DefaultConstructorMarker) null);
                this.pendingRecalculateMarks = prioritySet;
            }
            prioritySet.add(i);
        }
    }

    private final void updateContainsMarkNow(int i, PrioritySet prioritySet) {
        int groupIndexToAddress = groupIndexToAddress(i);
        boolean childContainsAnyMarks = childContainsAnyMarks(i);
        if (SlotTableKt.containsMark(this.groups, groupIndexToAddress) != childContainsAnyMarks) {
            SlotTableKt.updateContainsMark(this.groups, groupIndexToAddress, childContainsAnyMarks);
            int parent2 = parent(i);
            if (parent2 >= 0) {
                prioritySet.add(parent2);
            }
        }
    }

    private final boolean childContainsAnyMarks(int i) {
        int i2 = i + 1;
        int groupSize = i + groupSize(i);
        while (i2 < groupSize) {
            if (SlotTableKt.containsAnyMark(this.groups, groupIndexToAddress(i2))) {
                return true;
            }
            i2 += groupSize(i2);
        }
        return false;
    }

    public final int anchorIndex(Anchor anchor) {
        int location$runtime_release = anchor.getLocation$runtime_release();
        return location$runtime_release < 0 ? getSize$runtime_release() + location$runtime_release : location$runtime_release;
    }

    public String toString() {
        return "SlotWriter(current = " + this.currentGroup + " end=" + this.currentGroupEnd + " size = " + getSize$runtime_release() + " gap=" + this.groupGapStart + '-' + (this.groupGapStart + this.groupGapLen) + ')';
    }

    private final void saveCurrentGroupEnd() {
        this.endStack.push((getCapacity() - this.groupGapLen) - this.currentGroupEnd);
    }

    private final int restoreCurrentGroupEnd() {
        int capacity = (getCapacity() - this.groupGapLen) - this.endStack.pop();
        this.currentGroupEnd = capacity;
        return capacity;
    }

    private final void fixParentAnchorsFor(int i, int i2, int i3) {
        int parentIndexToAnchor = parentIndexToAnchor(i, this.groupGapStart);
        while (i3 < i2) {
            SlotTableKt.updateParentAnchor(this.groups, groupIndexToAddress(i3), parentIndexToAnchor);
            int access$groupSize = SlotTableKt.groupSize(this.groups, groupIndexToAddress(i3)) + i3;
            fixParentAnchorsFor(i3, access$groupSize, i3 + 1);
            i3 = access$groupSize;
        }
    }

    /* access modifiers changed from: private */
    public final void moveGroupGapTo(int i) {
        int i2;
        int i3 = this.groupGapLen;
        int i4 = this.groupGapStart;
        if (i4 != i) {
            if (!this.anchors.isEmpty()) {
                updateAnchors(i4, i);
            }
            if (i3 > 0) {
                int[] iArr = this.groups;
                int i5 = i * 5;
                int i6 = i3 * 5;
                int i7 = i4 * 5;
                if (i < i4) {
                    ArraysKt.copyInto(iArr, iArr, i6 + i5, i5, i7);
                } else {
                    ArraysKt.copyInto(iArr, iArr, i7, i7 + i6, i5 + i6);
                }
            }
            if (i < i4) {
                i4 = i + i3;
            }
            int capacity = getCapacity();
            ComposerKt.runtimeCheck(i2 < capacity);
            while (i2 < capacity) {
                int access$parentAnchor = SlotTableKt.parentAnchor(this.groups, i2);
                int parentIndexToAnchor = parentIndexToAnchor(parentAnchorToIndex(access$parentAnchor), i);
                if (parentIndexToAnchor != access$parentAnchor) {
                    SlotTableKt.updateParentAnchor(this.groups, i2, parentIndexToAnchor);
                }
                i2++;
                if (i2 == i) {
                    i2 += i3;
                }
            }
        }
        this.groupGapStart = i;
    }

    /* access modifiers changed from: private */
    public final void moveSlotGapTo(int i, int i2) {
        int i3 = this.slotsGapLen;
        int i4 = this.slotsGapStart;
        int i5 = this.slotsGapOwner;
        if (i4 != i) {
            Object[] objArr = this.slots;
            if (i < i4) {
                ArraysKt.copyInto((T[]) objArr, (T[]) objArr, i + i3, i, i4);
            } else {
                ArraysKt.copyInto((T[]) objArr, (T[]) objArr, i4, i4 + i3, i + i3);
            }
        }
        int min = Math.min(i2 + 1, getSize$runtime_release());
        if (i5 != min) {
            int length = this.slots.length - i3;
            if (min < i5) {
                int groupIndexToAddress = groupIndexToAddress(min);
                int groupIndexToAddress2 = groupIndexToAddress(i5);
                int i6 = this.groupGapStart;
                while (groupIndexToAddress < groupIndexToAddress2) {
                    int access$dataAnchor = SlotTableKt.dataAnchor(this.groups, groupIndexToAddress);
                    if (!(access$dataAnchor >= 0)) {
                        ComposerKt.composeImmediateRuntimeError("Unexpected anchor value, expected a positive anchor");
                    }
                    SlotTableKt.updateDataAnchor(this.groups, groupIndexToAddress, -((length - access$dataAnchor) + 1));
                    groupIndexToAddress++;
                    if (groupIndexToAddress == i6) {
                        groupIndexToAddress += this.groupGapLen;
                    }
                }
            } else {
                int groupIndexToAddress3 = groupIndexToAddress(i5);
                int groupIndexToAddress4 = groupIndexToAddress(min);
                while (groupIndexToAddress3 < groupIndexToAddress4) {
                    int access$dataAnchor2 = SlotTableKt.dataAnchor(this.groups, groupIndexToAddress3);
                    if (!(access$dataAnchor2 < 0)) {
                        ComposerKt.composeImmediateRuntimeError("Unexpected anchor value, expected a negative anchor");
                    }
                    SlotTableKt.updateDataAnchor(this.groups, groupIndexToAddress3, access$dataAnchor2 + length + 1);
                    groupIndexToAddress3++;
                    if (groupIndexToAddress3 == this.groupGapStart) {
                        groupIndexToAddress3 += this.groupGapLen;
                    }
                }
            }
            this.slotsGapOwner = min;
        }
        this.slotsGapStart = i;
    }

    private final void clearSlotGap() {
        int i = this.slotsGapStart;
        ArraysKt.fill((T[]) this.slots, null, i, this.slotsGapLen + i);
    }

    /* access modifiers changed from: private */
    public final void insertGroups(int i) {
        if (i > 0) {
            int i2 = this.currentGroup;
            moveGroupGapTo(i2);
            int i3 = this.groupGapStart;
            int i4 = this.groupGapLen;
            int[] iArr = this.groups;
            int length = iArr.length / 5;
            int i5 = length - i4;
            int i6 = 0;
            if (i4 < i) {
                int max = Math.max(Math.max(length * 2, i5 + i), 32);
                int[] iArr2 = new int[(max * 5)];
                int i7 = max - i5;
                ArraysKt.copyInto(iArr, iArr2, 0, 0, i3 * 5);
                ArraysKt.copyInto(iArr, iArr2, (i3 + i7) * 5, (i4 + i3) * 5, length * 5);
                this.groups = iArr2;
                i4 = i7;
            }
            int i8 = this.currentGroupEnd;
            if (i8 >= i3) {
                this.currentGroupEnd = i8 + i;
            }
            int i9 = i3 + i;
            this.groupGapStart = i9;
            this.groupGapLen = i4 - i;
            int dataIndex = i5 > 0 ? dataIndex(i2 + i) : 0;
            if (this.slotsGapOwner >= i3) {
                i6 = this.slotsGapStart;
            }
            int dataIndexToDataAnchor = dataIndexToDataAnchor(dataIndex, i6, this.slotsGapLen, this.slots.length);
            for (int i10 = i3; i10 < i9; i10++) {
                SlotTableKt.updateDataAnchor(this.groups, i10, dataIndexToDataAnchor);
            }
            int i11 = this.slotsGapOwner;
            if (i11 >= i3) {
                this.slotsGapOwner = i11 + i;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void insertSlots(int i, int i2) {
        if (i > 0) {
            moveSlotGapTo(this.currentSlot, i2);
            int i3 = this.slotsGapStart;
            int i4 = this.slotsGapLen;
            if (i4 < i) {
                Object[] objArr = this.slots;
                int length = objArr.length;
                int i5 = length - i4;
                int max = Math.max(Math.max(length * 2, i5 + i), 32);
                Object[] objArr2 = new Object[max];
                for (int i6 = 0; i6 < max; i6++) {
                    objArr2[i6] = null;
                }
                int i7 = max - i5;
                ArraysKt.copyInto((T[]) objArr, (T[]) objArr2, 0, 0, i3);
                ArraysKt.copyInto((T[]) objArr, (T[]) objArr2, i3 + i7, i4 + i3, length);
                this.slots = objArr2;
                i4 = i7;
            }
            int i8 = this.currentSlotEnd;
            if (i8 >= i3) {
                this.currentSlotEnd = i8 + i;
            }
            this.slotsGapStart = i3 + i;
            this.slotsGapLen = i4 - i;
        }
    }

    /* access modifiers changed from: private */
    public final boolean removeGroups(int i, int i2) {
        boolean z = false;
        if (i2 > 0) {
            ArrayList<Anchor> arrayList = this.anchors;
            moveGroupGapTo(i);
            if (!arrayList.isEmpty()) {
                z = removeAnchors(i, i2, this.sourceInformationMap);
            }
            this.groupGapStart = i;
            this.groupGapLen += i2;
            int i3 = this.slotsGapOwner;
            if (i3 > i) {
                this.slotsGapOwner = Math.max(i, i3 - i2);
            }
            int i4 = this.currentGroupEnd;
            if (i4 >= this.groupGapStart) {
                this.currentGroupEnd = i4 - i2;
            }
            int i5 = this.parent;
            if (containsGroupMark(i5)) {
                updateContainsMark(i5);
            }
        }
        return z;
    }

    /* access modifiers changed from: private */
    public final GroupSourceInformation sourceInformationOf(int i) {
        Anchor tryAnchor$runtime_release;
        HashMap<Anchor, GroupSourceInformation> hashMap = this.sourceInformationMap;
        if (hashMap == null || (tryAnchor$runtime_release = tryAnchor$runtime_release(i)) == null) {
            return null;
        }
        return hashMap.get(tryAnchor$runtime_release);
    }

    public final Anchor tryAnchor$runtime_release(int i) {
        if (i < 0 || i >= getSize$runtime_release()) {
            return null;
        }
        return SlotTableKt.find(this.anchors, i, getSize$runtime_release());
    }

    /* access modifiers changed from: private */
    public final void removeSlots(int i, int i2, int i3) {
        if (i2 > 0) {
            int i4 = this.slotsGapLen;
            int i5 = i + i2;
            moveSlotGapTo(i5, i3);
            this.slotsGapStart = i;
            this.slotsGapLen = i4 + i2;
            ArraysKt.fill((T[]) this.slots, null, i, i5);
            int i6 = this.currentSlotEnd;
            if (i6 >= i) {
                this.currentSlotEnd = i6 - i2;
            }
        }
    }

    private final void updateNodeOfGroup(int i, Object obj) {
        int groupIndexToAddress = groupIndexToAddress(i);
        int[] iArr = this.groups;
        if (!(groupIndexToAddress < iArr.length && SlotTableKt.isNode(iArr, groupIndexToAddress))) {
            ComposerKt.composeImmediateRuntimeError("Updating the node of a group at " + i + " that was not created with as a node group");
        }
        this.slots[dataIndexToDataAddress(nodeIndex(this.groups, groupIndexToAddress))] = obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003c, code lost:
        r5 = r3.anchors.get(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0017, code lost:
        r0 = r3.anchors.get(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateAnchors(int r4, int r5) {
        /*
            r3 = this;
            int r0 = r3.groupGapLen
            int r1 = r3.getCapacity()
            int r1 = r1 - r0
            if (r4 >= r5) goto L_0x002e
            java.util.ArrayList<androidx.compose.runtime.Anchor> r0 = r3.anchors
            int r4 = androidx.compose.runtime.SlotTableKt.locationOf(r0, r4, r1)
        L_0x000f:
            java.util.ArrayList<androidx.compose.runtime.Anchor> r0 = r3.anchors
            int r0 = r0.size()
            if (r4 >= r0) goto L_0x0053
            java.util.ArrayList<androidx.compose.runtime.Anchor> r0 = r3.anchors
            java.lang.Object r0 = r0.get(r4)
            androidx.compose.runtime.Anchor r0 = (androidx.compose.runtime.Anchor) r0
            int r2 = r0.getLocation$runtime_release()
            if (r2 >= 0) goto L_0x0053
            int r2 = r2 + r1
            if (r2 >= r5) goto L_0x0053
            r0.setLocation$runtime_release(r2)
            int r4 = r4 + 1
            goto L_0x000f
        L_0x002e:
            java.util.ArrayList<androidx.compose.runtime.Anchor> r4 = r3.anchors
            int r4 = androidx.compose.runtime.SlotTableKt.locationOf(r4, r5, r1)
        L_0x0034:
            java.util.ArrayList<androidx.compose.runtime.Anchor> r5 = r3.anchors
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0053
            java.util.ArrayList<androidx.compose.runtime.Anchor> r5 = r3.anchors
            java.lang.Object r5 = r5.get(r4)
            androidx.compose.runtime.Anchor r5 = (androidx.compose.runtime.Anchor) r5
            int r0 = r5.getLocation$runtime_release()
            if (r0 < 0) goto L_0x0053
            int r0 = r1 - r0
            int r0 = -r0
            r5.setLocation$runtime_release(r0)
            int r4 = r4 + 1
            goto L_0x0034
        L_0x0053:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SlotWriter.updateAnchors(int, int):void");
    }

    private final boolean removeAnchors(int i, int i2, HashMap<Anchor, GroupSourceInformation> hashMap) {
        int i3 = i2 + i;
        int access$locationOf = SlotTableKt.locationOf(this.anchors, i3, getCapacity() - this.groupGapLen);
        if (access$locationOf >= this.anchors.size()) {
            access$locationOf--;
        }
        int i4 = access$locationOf + 1;
        boolean z = false;
        int i5 = 0;
        while (access$locationOf >= 0) {
            Anchor anchor = this.anchors.get(access$locationOf);
            int anchorIndex = anchorIndex(anchor);
            if (anchorIndex < i) {
                break;
            }
            if (anchorIndex < i3) {
                anchor.setLocation$runtime_release(Integer.MIN_VALUE);
                if (hashMap != null) {
                    GroupSourceInformation remove = hashMap.remove(anchor);
                }
                if (i5 == 0) {
                    i5 = access$locationOf + 1;
                }
                i4 = access$locationOf;
            }
            access$locationOf--;
        }
        if (i4 < i5) {
            z = true;
        }
        if (z) {
            this.anchors.subList(i4, i5).clear();
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001c, code lost:
        r3 = r5.anchors.get(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void moveAnchors(int r6, int r7, int r8) {
        /*
            r5 = this;
            int r8 = r8 + r6
            int r0 = r5.getSize$runtime_release()
            java.util.ArrayList<androidx.compose.runtime.Anchor> r1 = r5.anchors
            int r1 = androidx.compose.runtime.SlotTableKt.locationOf(r1, r6, r0)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List r2 = (java.util.List) r2
            if (r1 < 0) goto L_0x0035
        L_0x0014:
            java.util.ArrayList<androidx.compose.runtime.Anchor> r3 = r5.anchors
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x0035
            java.util.ArrayList<androidx.compose.runtime.Anchor> r3 = r5.anchors
            java.lang.Object r3 = r3.get(r1)
            androidx.compose.runtime.Anchor r3 = (androidx.compose.runtime.Anchor) r3
            int r4 = r5.anchorIndex(r3)
            if (r4 < r6) goto L_0x0035
            if (r4 >= r8) goto L_0x0035
            r2.add(r3)
            java.util.ArrayList<androidx.compose.runtime.Anchor> r3 = r5.anchors
            r3.remove(r1)
            goto L_0x0014
        L_0x0035:
            int r7 = r7 - r6
            int r6 = r2.size()
            r8 = 0
        L_0x003b:
            if (r8 >= r6) goto L_0x0064
            java.lang.Object r1 = r2.get(r8)
            androidx.compose.runtime.Anchor r1 = (androidx.compose.runtime.Anchor) r1
            int r3 = r5.anchorIndex(r1)
            int r3 = r3 + r7
            int r4 = r5.groupGapStart
            if (r3 < r4) goto L_0x0053
            int r4 = r0 - r3
            int r4 = -r4
            r1.setLocation$runtime_release(r4)
            goto L_0x0056
        L_0x0053:
            r1.setLocation$runtime_release(r3)
        L_0x0056:
            java.util.ArrayList<androidx.compose.runtime.Anchor> r4 = r5.anchors
            int r3 = androidx.compose.runtime.SlotTableKt.locationOf(r4, r3, r0)
            java.util.ArrayList<androidx.compose.runtime.Anchor> r4 = r5.anchors
            r4.add(r3, r1)
            int r8 = r8 + 1
            goto L_0x003b
        L_0x0064:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SlotWriter.moveAnchors(int, int, int):void");
    }

    public final String toDebugString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder append = sb.append(toString());
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        Intrinsics.checkNotNullExpressionValue(append.append(10), "append('\\n')");
        StringBuilder append2 = sb.append("  parent:    " + this.parent);
        Intrinsics.checkNotNullExpressionValue(append2, "append(value)");
        Intrinsics.checkNotNullExpressionValue(append2.append(10), "append('\\n')");
        StringBuilder append3 = sb.append("  current:   " + this.currentGroup);
        Intrinsics.checkNotNullExpressionValue(append3, "append(value)");
        Intrinsics.checkNotNullExpressionValue(append3.append(10), "append('\\n')");
        StringBuilder append4 = sb.append("  group gap: " + this.groupGapStart + '-' + (this.groupGapStart + this.groupGapLen) + '(' + this.groupGapLen + ')');
        Intrinsics.checkNotNullExpressionValue(append4, "append(value)");
        Intrinsics.checkNotNullExpressionValue(append4.append(10), "append('\\n')");
        StringBuilder append5 = sb.append("  slots gap: " + this.slotsGapStart + '-' + (this.slotsGapStart + this.slotsGapLen) + '(' + this.slotsGapLen + ')');
        Intrinsics.checkNotNullExpressionValue(append5, "append(value)");
        Intrinsics.checkNotNullExpressionValue(append5.append(10), "append('\\n')");
        StringBuilder append6 = sb.append("  gap owner: " + this.slotsGapOwner);
        Intrinsics.checkNotNullExpressionValue(append6, "append(value)");
        Intrinsics.checkNotNullExpressionValue(append6.append(10), "append('\\n')");
        int size$runtime_release = getSize$runtime_release();
        for (int i = 0; i < size$runtime_release; i++) {
            groupAsString(sb, i);
            sb.append(10);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    private final void groupAsString(StringBuilder sb, int i) {
        int groupIndexToAddress = groupIndexToAddress(i);
        sb.append("Group(");
        if (i < 10) {
            sb.append(' ');
        }
        if (i < 100) {
            sb.append(' ');
        }
        if (i < 1000) {
            sb.append(' ');
        }
        sb.append(i);
        if (groupIndexToAddress != i) {
            sb.append("(");
            sb.append(groupIndexToAddress);
            sb.append(")");
        }
        sb.append('#');
        sb.append(SlotTableKt.groupSize(this.groups, groupIndexToAddress));
        sb.append('^');
        sb.append(parentAnchorToIndex(SlotTableKt.parentAnchor(this.groups, groupIndexToAddress)));
        sb.append(": key=");
        sb.append(SlotTableKt.key(this.groups, groupIndexToAddress));
        sb.append(", nodes=");
        sb.append(SlotTableKt.nodeCount(this.groups, groupIndexToAddress));
        sb.append(", dataAnchor=");
        sb.append(SlotTableKt.dataAnchor(this.groups, groupIndexToAddress));
        sb.append(", parentAnchor=");
        sb.append(SlotTableKt.parentAnchor(this.groups, groupIndexToAddress));
        if (SlotTableKt.isNode(this.groups, groupIndexToAddress)) {
            sb.append(", node=" + SlotTableKt.summarize(String.valueOf(this.slots[dataIndexToDataAddress(nodeIndex(this.groups, groupIndexToAddress))]), 10));
        }
        int slotIndex = slotIndex(this.groups, groupIndexToAddress);
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(i + 1));
        if (dataIndex > slotIndex) {
            sb.append(", [");
            for (int i2 = slotIndex; i2 < dataIndex; i2++) {
                if (i2 != slotIndex) {
                    sb.append(", ");
                }
                sb.append(String.valueOf(SlotTableKt.summarize(String.valueOf(this.slots[dataIndexToDataAddress(i2)]), 10)));
            }
            sb.append(']');
        }
        sb.append(")");
    }

    public final void verifyDataAnchors$runtime_release() {
        int i = this.slotsGapOwner;
        int length = this.slots.length - this.slotsGapLen;
        int size$runtime_release = getSize$runtime_release();
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        while (i2 < size$runtime_release) {
            int groupIndexToAddress = groupIndexToAddress(i2);
            int access$dataAnchor = SlotTableKt.dataAnchor(this.groups, groupIndexToAddress);
            int dataIndex = dataIndex(this.groups, groupIndexToAddress);
            if (!(dataIndex >= i3)) {
                PreconditionsKt.throwIllegalStateException("Data index out of order at " + i2 + ", previous = " + i3 + ", current = " + dataIndex);
            }
            if (!(dataIndex <= length)) {
                PreconditionsKt.throwIllegalStateException("Data index, " + dataIndex + ", out of bound at " + i2);
            }
            if (access$dataAnchor < 0 && !z) {
                if (!(i == i2)) {
                    PreconditionsKt.throwIllegalStateException("Expected the slot gap owner to be " + i + " found gap at " + i2);
                }
                z = true;
            }
            i2++;
            i3 = dataIndex;
        }
    }

    public final void verifyParentAnchors$runtime_release() {
        int i = this.groupGapStart;
        int i2 = this.groupGapLen;
        int capacity = getCapacity();
        int i3 = 0;
        while (true) {
            boolean z = true;
            if (i3 >= i) {
                break;
            }
            if (SlotTableKt.parentAnchor(this.groups, i3) <= -2) {
                z = false;
            }
            if (!z) {
                PreconditionsKt.throwIllegalStateException("Expected a start relative anchor at " + i3);
            }
            i3++;
        }
        for (int i4 = i2 + i; i4 < capacity; i4++) {
            int access$parentAnchor = SlotTableKt.parentAnchor(this.groups, i4);
            if (parentAnchorToIndex(access$parentAnchor) < i) {
                if (!(access$parentAnchor > -2)) {
                    PreconditionsKt.throwIllegalStateException("Expected a start relative anchor at " + i4);
                }
            } else {
                if (!(access$parentAnchor <= -2)) {
                    PreconditionsKt.throwIllegalStateException("Expected an end relative anchor at " + i4);
                }
            }
        }
    }

    public final int getSize$runtime_release() {
        return getCapacity() - this.groupGapLen;
    }

    private final int getCapacity() {
        return this.groups.length / 5;
    }

    /* access modifiers changed from: private */
    public final int groupIndexToAddress(int i) {
        return i < this.groupGapStart ? i : i + this.groupGapLen;
    }

    /* access modifiers changed from: private */
    public final int dataIndexToDataAddress(int i) {
        return i < this.slotsGapStart ? i : i + this.slotsGapLen;
    }

    private final int parent(int[] iArr, int i) {
        return parentAnchorToIndex(SlotTableKt.parentAnchor(iArr, groupIndexToAddress(i)));
    }

    /* access modifiers changed from: private */
    public final int dataIndex(int i) {
        return dataIndex(this.groups, groupIndexToAddress(i));
    }

    /* access modifiers changed from: private */
    public final int dataIndex(int[] iArr, int i) {
        if (i >= getCapacity()) {
            return this.slots.length - this.slotsGapLen;
        }
        return dataAnchorToDataIndex(SlotTableKt.dataAnchor(iArr, i), this.slotsGapLen, this.slots.length);
    }

    /* access modifiers changed from: private */
    public final int slotIndex(int[] iArr, int i) {
        if (i >= getCapacity()) {
            return this.slots.length - this.slotsGapLen;
        }
        return dataAnchorToDataIndex(SlotTableKt.slotAnchor(iArr, i), this.slotsGapLen, this.slots.length);
    }

    private final void updateDataIndex(int[] iArr, int i, int i2) {
        SlotTableKt.updateDataAnchor(iArr, i, dataIndexToDataAnchor(i2, this.slotsGapStart, this.slotsGapLen, this.slots.length));
    }

    private final int nodeIndex(int[] iArr, int i) {
        return dataIndex(iArr, i);
    }

    private final int auxIndex(int[] iArr, int i) {
        return dataIndex(iArr, i) + SlotTableKt.countOneBits(SlotTableKt.groupInfo(iArr, i) >> 29);
    }

    private final List<Integer> dataIndexes(int[] iArr) {
        List dataAnchors$default = SlotTableKt.dataAnchors$default(this.groups, 0, 1, (Object) null);
        List plus = CollectionsKt.plus(CollectionsKt.slice(dataAnchors$default, RangesKt.until(0, this.groupGapStart)), CollectionsKt.slice(dataAnchors$default, RangesKt.until(this.groupGapStart + this.groupGapLen, iArr.length / 5)));
        ArrayList arrayList = new ArrayList(plus.size());
        int size = plus.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(Integer.valueOf(dataAnchorToDataIndex(((Number) plus.get(i)).intValue(), this.slotsGapLen, this.slots.length)));
        }
        return arrayList;
    }

    private final List<Integer> keys() {
        List keys$default = SlotTableKt.keys$default(this.groups, 0, 1, (Object) null);
        ArrayList arrayList = new ArrayList(keys$default.size());
        int size = keys$default.size();
        for (int i = 0; i < size; i++) {
            Object obj = keys$default.get(i);
            ((Number) obj).intValue();
            int i2 = this.groupGapStart;
            if (i < i2 || i >= i2 + this.groupGapLen) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final int parentIndexToAnchor(int i, int i2) {
        return i < i2 ? i : -((getSize$runtime_release() - i) + 2);
    }

    private final int parentAnchorToIndex(int i) {
        return i > -2 ? i : (getSize$runtime_release() + i) - -2;
    }
}
