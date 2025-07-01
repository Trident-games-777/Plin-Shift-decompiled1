package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.MutableRectKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LookaheadLayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000 \u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b&\b \u0018\u0000 ®\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004®\u0002¯\u0002B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J$\u0010\u0001\u001a\u00020\u001e2\u0007\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020%H\u0002J2\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020%H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001d\u0010\u0001\u001a\u00020`2\u0006\u0010_\u001a\u00020`H\u0004ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010 \u0001J'\u0010¡\u0001\u001a\u00020\u00172\b\u0010¢\u0001\u001a\u00030\u00012\u0006\u0010_\u001a\u00020`H\u0004ø\u0001\u0000¢\u0006\u0006\b£\u0001\u0010¤\u0001J\u001b\u0010¥\u0001\u001a\u00020\u001e2\u0007\u0010¦\u0001\u001a\u00020\u001c2\t\u0010§\u0001\u001a\u0004\u0018\u00010\u001dJ\u001c\u0010¨\u0001\u001a\u00020\u001e2\u0007\u0010¦\u0001\u001a\u00020\u001c2\b\u0010©\u0001\u001a\u00030ª\u0001H\u0004J\u001d\u0010«\u0001\u001a\u00020\u001e2\u0007\u0010¦\u0001\u001a\u00020\u001c2\t\u0010§\u0001\u001a\u0004\u0018\u00010\u001dH\u0002J\t\u0010¬\u0001\u001a\u00020\u001eH&J\u0018\u0010­\u0001\u001a\u00020\u00002\u0007\u0010®\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0003\b¯\u0001J*\u0010°\u0001\u001a\u00030\u00012\u0007\u0010q\u001a\u00030\u00012\t\b\u0002\u0010\u0001\u001a\u00020%H\u0016ø\u0001\u0000¢\u0006\u0006\b±\u0001\u0010²\u0001J\u001b\u0010³\u0001\u001a\u00020\u001e2\u0007\u0010´\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020%H\u0002J#\u0010µ\u0001\u001a\u00020%2\f\u0010¶\u0001\u001a\u0007\u0012\u0002\b\u00030·\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\b¸\u0001\u0010¹\u0001J$\u0010º\u0001\u001a\u0005\u0018\u00010\u00012\f\u0010¶\u0001\u001a\u0007\u0012\u0002\b\u00030·\u0001ø\u0001\u0000¢\u0006\u0006\b»\u0001\u0010¼\u0001J\u0015\u0010½\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010¾\u0001\u001a\u00020%H\u0002JC\u0010¿\u0001\u001a\u00020\u001e2\b\u0010À\u0001\u001a\u00030Á\u00012\b\u0010¢\u0001\u001a\u00030\u00012\b\u0010Â\u0001\u001a\u00030Ã\u00012\u0007\u0010Ä\u0001\u001a\u00020%2\u0007\u0010Å\u0001\u001a\u00020%ø\u0001\u0000¢\u0006\u0006\bÆ\u0001\u0010Ç\u0001JE\u0010È\u0001\u001a\u00020\u001e2\b\u0010À\u0001\u001a\u00030Á\u00012\b\u0010¢\u0001\u001a\u00030\u00012\b\u0010Â\u0001\u001a\u00030Ã\u00012\u0007\u0010Ä\u0001\u001a\u00020%2\u0007\u0010Å\u0001\u001a\u00020%H\u0016ø\u0001\u0000¢\u0006\u0006\bÉ\u0001\u0010Ç\u0001J\t\u0010Ê\u0001\u001a\u00020\u001eH\u0016J\u001f\u0010Ë\u0001\u001a\u00020%2\b\u0010¢\u0001\u001a\u00030\u0001H\u0004ø\u0001\u0000¢\u0006\u0006\bÌ\u0001\u0010Í\u0001J\u0007\u0010Î\u0001\u001a\u00020%J\u001c\u0010Ï\u0001\u001a\u00030Ð\u00012\u0007\u0010Ñ\u0001\u001a\u00020\u00032\u0007\u0010\u0001\u001a\u00020%H\u0016J)\u0010Ò\u0001\u001a\u00030\u00012\u0007\u0010Ñ\u0001\u001a\u00020\u00032\b\u0010Ó\u0001\u001a\u00030\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bÔ\u0001\u0010Õ\u0001J2\u0010Ò\u0001\u001a\u00030\u00012\u0007\u0010Ñ\u0001\u001a\u00020\u00032\b\u0010Ó\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020%H\u0016ø\u0001\u0000¢\u0006\u0006\bÖ\u0001\u0010×\u0001J \u0010Ø\u0001\u001a\u00030\u00012\b\u0010Ù\u0001\u001a\u00030\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bÚ\u0001\u0010 \u0001J \u0010Û\u0001\u001a\u00030\u00012\b\u0010Ù\u0001\u001a\u00030\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bÜ\u0001\u0010 \u0001J \u0010Ý\u0001\u001a\u00030\u00012\b\u0010Ù\u0001\u001a\u00030\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bÞ\u0001\u0010 \u0001J \u0010ß\u0001\u001a\u00030\u00012\b\u0010¢\u0001\u001a\u00030\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\bà\u0001\u0010 \u0001J\u000f\u0010á\u0001\u001a\u00020\u001eH\u0000¢\u0006\u0003\bâ\u0001J\t\u0010ã\u0001\u001a\u00020\u001eH\u0016J\u0007\u0010ä\u0001\u001a\u00020\u001eJ\u001b\u0010å\u0001\u001a\u00020\u001e2\u0007\u0010æ\u0001\u001a\u00020e2\u0007\u0010ç\u0001\u001a\u00020eH\u0014J\u0007\u0010è\u0001\u001a\u00020\u001eJ\u0007\u0010é\u0001\u001a\u00020\u001eJ\u0007\u0010ê\u0001\u001a\u00020\u001eJ\u001d\u0010ë\u0001\u001a\u00020\u001e2\u0007\u0010¦\u0001\u001a\u00020\u001c2\t\u0010§\u0001\u001a\u0004\u0018\u00010\u001dH\u0016J2\u0010ì\u0001\u001a\u00030í\u00012\u0007\u0010î\u0001\u001a\u00020;2\u0010\b\u0004\u0010ï\u0001\u001a\t\u0012\u0005\u0012\u00030í\u000102H\bø\u0001\u0000¢\u0006\u0006\bð\u0001\u0010ñ\u0001JA\u0010ò\u0001\u001a\u00020\u001e2\u0006\u0010q\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020\u00172\u0019\u0010E\u001a\u0015\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u001e\u0018\u00010B¢\u0006\u0002\bDH\u0014ø\u0001\u0000¢\u0006\u0006\bó\u0001\u0010ô\u0001J.\u0010ò\u0001\u001a\u00020\u001e2\u0006\u0010q\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\u001dH\u0014ø\u0001\u0000¢\u0006\u0006\bó\u0001\u0010õ\u0001JK\u0010ö\u0001\u001a\u00020\u001e2\u0006\u0010q\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020\u00172\u0019\u0010E\u001a\u0015\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u001e\u0018\u00010B¢\u0006\u0002\bD2\b\u0010!\u001a\u0004\u0018\u00010\u001dH\u0002ø\u0001\u0000¢\u0006\u0006\b÷\u0001\u0010ø\u0001JI\u0010ù\u0001\u001a\u00020\u001e2\u0006\u0010q\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020\u00172\u0019\u0010E\u001a\u0015\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u001e\u0018\u00010B¢\u0006\u0002\bD2\b\u0010?\u001a\u0004\u0018\u00010\u001dø\u0001\u0000¢\u0006\u0006\bú\u0001\u0010ø\u0001J,\u0010û\u0001\u001a\u00020\u001e2\u0007\u0010´\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020%2\t\b\u0002\u0010ü\u0001\u001a\u00020%H\u0000¢\u0006\u0003\bý\u0001J\u0007\u0010þ\u0001\u001a\u00020\u001eJ\u000f\u0010ÿ\u0001\u001a\u00020\u001eH\u0010¢\u0006\u0003\b\u0002J \u0010\u0002\u001a\u00030\u00012\b\u0010\u0002\u001a\u00030\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010 \u0001J\u0007\u0010\u0002\u001a\u00020%J*\u0010\u0002\u001a\u00030\u00012\u0007\u0010q\u001a\u00030\u00012\t\b\u0002\u0010\u0001\u001a\u00020%H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010²\u0001J\b\u0010\u0002\u001a\u00030Ð\u0001J(\u0010\u0002\u001a\u00020\u001e2\u0007\u0010Ñ\u0001\u001a\u00020\u00032\b\u0010\u0002\u001a\u00030\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002J(\u0010\u0002\u001a\u00020\u001e2\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010\u0002\u001a\u00030\u0002H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002J(\u0010\u0002\u001a\u00020\u001e2\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010\u0002\u001a\u00030\u0002H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002J\u001f\u0010\u0002\u001a\u00020\u001e2\b\u0010\u0002\u001a\u00030\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002J-\u0010\u0002\u001a\u00020\u001e2\u0019\u0010E\u001a\u0015\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u001e\u0018\u00010B¢\u0006\u0002\bD2\t\b\u0002\u0010\u0002\u001a\u00020%J\u0014\u0010\u0002\u001a\u00020\u001e2\t\b\u0002\u0010\u0002\u001a\u00020%H\u0002JF\u0010\u0002\u001a\u00020\u001e\"\u0007\b\u0000\u0010\u0002\u0018\u00012\u000f\u0010¶\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00020·\u00012\u0014\u0010ï\u0001\u001a\u000f\u0012\u0005\u0012\u0003H\u0002\u0012\u0004\u0012\u00020\u001e0BH\bø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002J2\u0010\u0002\u001a\u00020\u001e2\u0007\u0010\u0002\u001a\u00020e2\u0007\u0010¾\u0001\u001a\u00020%2\u0014\u0010ï\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u0001\u0012\u0004\u0012\u00020\u001e0BH\bJ \u0010\u0002\u001a\u00030\u00012\b\u0010\u0002\u001a\u00030\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b \u0002\u0010 \u0001J(\u0010¡\u0002\u001a\u00020\u001e2\u0007\u0010¦\u0001\u001a\u00020\u001c2\u0013\u0010ï\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001e0BH\bJ\u001f\u0010¢\u0002\u001a\u00020%2\b\u0010¢\u0001\u001a\u00030\u0001H\u0004ø\u0001\u0000¢\u0006\u0006\b£\u0002\u0010Í\u0001JL\u0010¤\u0002\u001a\u00020\u001e*\u0005\u0018\u00010\u00012\b\u0010À\u0001\u001a\u00030Á\u00012\b\u0010¢\u0001\u001a\u00030\u00012\b\u0010Â\u0001\u001a\u00030Ã\u00012\u0007\u0010Ä\u0001\u001a\u00020%2\u0007\u0010Å\u0001\u001a\u00020%H\u0002ø\u0001\u0000¢\u0006\u0006\b¥\u0002\u0010¦\u0002JU\u0010§\u0002\u001a\u00020\u001e*\u0005\u0018\u00010\u00012\b\u0010À\u0001\u001a\u00030Á\u00012\b\u0010¢\u0001\u001a\u00030\u00012\b\u0010Â\u0001\u001a\u00030Ã\u00012\u0007\u0010Ä\u0001\u001a\u00020%2\u0007\u0010Å\u0001\u001a\u00020%2\u0007\u0010¨\u0002\u001a\u00020\u0017H\u0002ø\u0001\u0000¢\u0006\u0006\b©\u0002\u0010ª\u0002JU\u0010«\u0002\u001a\u00020\u001e*\u0005\u0018\u00010\u00012\b\u0010À\u0001\u001a\u00030Á\u00012\b\u0010¢\u0001\u001a\u00030\u00012\b\u0010Â\u0001\u001a\u00030Ã\u00012\u0007\u0010Ä\u0001\u001a\u00020%2\u0007\u0010Å\u0001\u001a\u00020%2\u0007\u0010¨\u0002\u001a\u00020\u0017H\u0002ø\u0001\u0000¢\u0006\u0006\b¬\u0002\u0010ª\u0002J\r\u0010­\u0002\u001a\u00020\u0000*\u00020\u0003H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R(\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0012\u0004\u0012\u00020\u001e0\u001bX\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020\u00178VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0019R\u001a\u0010$\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\u0014\u0010-\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010'R\u0014\u0010/\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b0\u0010'R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\u001e02X\u0004¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b3\u0010'R\u000e\u00104\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b5\u0010'R\u000e\u00106\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u001e\u00108\u001a\u00020%2\u0006\u00107\u001a\u00020%@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b9\u0010'R\u001a\u0010:\u001a\u00020;8@X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b<\u0010=R\"\u0010?\u001a\u0004\u0018\u00010>2\b\u00107\u001a\u0004\u0018\u00010>@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b@\u0010ARD\u0010E\u001a\u0015\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u001e\u0018\u00010B¢\u0006\u0002\bD2\u0019\u00107\u001a\u0015\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u001e\u0018\u00010B¢\u0006\u0002\bD@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u000e\u0010H\u001a\u00020IX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010MX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010N\u001a\u00020K8VX\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR&\u0010T\u001a\u0004\u0018\u00010S2\b\u00107\u001a\u0004\u0018\u00010S@dX¦\u000e¢\u0006\f\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR$\u0010Z\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\t8P@PX\u000e¢\u0006\f\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u0017\u0010_\u001a\u00020`8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\ba\u0010=R\u001c\u0010b\u001a\u0010\u0012\u0004\u0012\u00020d\u0012\u0004\u0012\u00020e\u0018\u00010cX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010f\u001a\u0004\u0018\u00010\u00018VX\u0004¢\u0006\u0006\u001a\u0004\bg\u0010\u0012R\u0013\u0010h\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bi\u0010\u0015R\u0016\u0010j\u001a\u0004\u0018\u00010k8VX\u0004¢\u0006\u0006\u001a\u0004\bl\u0010mR\u0013\u0010n\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bo\u0010\u0015R,\u0010q\u001a\u00020p2\u0006\u00107\u001a\u00020p@TX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010u\u001a\u0004\br\u0010=\"\u0004\bs\u0010tR\u001a\u0010v\u001a\b\u0012\u0004\u0012\u00020d0w8VX\u0004¢\u0006\u0006\u001a\u0004\bx\u0010yR\u0014\u0010z\u001a\u00020\u000b8DX\u0004¢\u0006\u0006\u001a\u0004\b{\u0010|R\u000e\u0010}\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010~\u001a\u000208Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0007\u001a\u0005\b\u0001\u0010=R\u0018\u0010\u0001\u001a\u00030\u00018BX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u0016\u0010\u0001\u001a\u00030\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R!\u0010\u0001\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R!\u0010\u0001\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R(\u0010\u0001\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u0017@DX\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0001\u0010\u0019\"\u0006\b\u0001\u0010\u0001\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006°\u0002"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/node/OwnerScope;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "_measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "_rectCache", "Landroidx/compose/ui/geometry/MutableRect;", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "child", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "coordinates", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "density", "", "getDensity", "()F", "drawBlock", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/Canvas;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "", "getDrawBlock$annotations", "()V", "explicitLayer", "fontScale", "getFontScale", "forceMeasureWithLookaheadConstraints", "", "getForceMeasureWithLookaheadConstraints$ui_release", "()Z", "setForceMeasureWithLookaheadConstraints$ui_release", "(Z)V", "forcePlaceWithLookaheadOffset", "getForcePlaceWithLookaheadOffset$ui_release", "setForcePlaceWithLookaheadOffset$ui_release", "hasMeasureResult", "getHasMeasureResult", "introducesMotionFrameOfReference", "getIntroducesMotionFrameOfReference", "invalidateParentLayer", "Lkotlin/Function0;", "isAttached", "isClipping", "isValidOwnerScope", "lastLayerAlpha", "<set-?>", "lastLayerDrawingWasSkipped", "getLastLayerDrawingWasSkipped$ui_release", "lastMeasurementConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastMeasurementConstraints-msEJaDk$ui_release", "()J", "Landroidx/compose/ui/node/OwnedLayer;", "layer", "getLayer", "()Landroidx/compose/ui/node/OwnedLayer;", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "layerBlock", "getLayerBlock", "()Lkotlin/jvm/functions/Function1;", "layerDensity", "Landroidx/compose/ui/unit/Density;", "layerLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "layerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadDelegate", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "setLookaheadDelegate", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "value", "measureResult", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "setMeasureResult$ui_release", "(Landroidx/compose/ui/layout/MeasureResult;)V", "minimumTouchTargetSize", "Landroidx/compose/ui/geometry/Size;", "getMinimumTouchTargetSize-NH-jbRc", "oldAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "parent", "getParent", "parentCoordinates", "getParentCoordinates", "parentData", "", "getParentData", "()Ljava/lang/Object;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "Landroidx/compose/ui/unit/IntOffset;", "position", "getPosition-nOcc-ac", "setPosition--gyyYBs", "(J)V", "J", "providedAlignmentLines", "", "getProvidedAlignmentLines", "()Ljava/util/Set;", "rectCache", "getRectCache", "()Landroidx/compose/ui/geometry/MutableRect;", "released", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "tail", "Landroidx/compose/ui/Modifier$Node;", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "wrapped", "getWrapped$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "setWrapped$ui_release", "(Landroidx/compose/ui/node/NodeCoordinator;)V", "wrappedBy", "getWrappedBy$ui_release", "setWrappedBy$ui_release", "zIndex", "getZIndex", "setZIndex", "(F)V", "ancestorToLocal", "ancestor", "rect", "clipBounds", "Landroidx/compose/ui/geometry/Offset;", "offset", "includeMotionFrameOfReference", "ancestorToLocal-S_NoaFU", "(Landroidx/compose/ui/node/NodeCoordinator;JZ)J", "calculateMinimumTouchTargetPadding", "calculateMinimumTouchTargetPadding-E7KxVPU", "(J)J", "distanceInMinimumTouchTarget", "pointerPosition", "distanceInMinimumTouchTarget-tz77jQw", "(JJ)F", "draw", "canvas", "graphicsLayer", "drawBorder", "paint", "Landroidx/compose/ui/graphics/Paint;", "drawContainedDrawModifiers", "ensureLookaheadDelegateCreated", "findCommonAncestor", "other", "findCommonAncestor$ui_release", "fromParentPosition", "fromParentPosition-8S9VItk", "(JZ)J", "fromParentRect", "bounds", "hasNode", "type", "Landroidx/compose/ui/node/NodeKind;", "hasNode-H91voCI", "(I)Z", "head", "head-H91voCI", "(I)Landroidx/compose/ui/Modifier$Node;", "headNode", "includeTail", "hitTest", "hitTestSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "isInLayer", "hitTest-YqVAtuI", "(Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitTestChild", "hitTestChild-YqVAtuI", "invalidateLayer", "isPointerInBounds", "isPointerInBounds-k-4lQ0M", "(J)Z", "isTransparent", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "localPositionOf", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localPositionOf-S_NoaFU", "(Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "localToScreen", "localToScreen-MK-Hz9U", "localToWindow", "localToWindow-MK-Hz9U", "offsetFromEdge", "offsetFromEdge-MK-Hz9U", "onCoordinatesUsed", "onCoordinatesUsed$ui_release", "onLayoutModifierNodeChanged", "onLayoutNodeAttach", "onMeasureResultChanged", "width", "height", "onMeasured", "onPlaced", "onRelease", "performDraw", "performingMeasure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "block", "performingMeasure-K40F9xA", "(JLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/layout/Placeable;", "placeAt", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeSelf", "placeSelf-MLgxB_4", "(JFLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeSelfApparentToRealOffset", "placeSelfApparentToRealOffset-MLgxB_4", "rectInParent", "clipToMinimumTouchTargetSize", "rectInParent$ui_release", "releaseLayer", "replace", "replace$ui_release", "screenToLocal", "relativeToScreen", "screenToLocal-MK-Hz9U", "shouldSharePointerInputWithSiblings", "toParentPosition", "toParentPosition-8S9VItk", "touchBoundsInRoot", "transformFrom", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformFromAncestor", "transformFromAncestor-EL8BTi8", "(Landroidx/compose/ui/node/NodeCoordinator;[F)V", "transformToAncestor", "transformToAncestor-EL8BTi8", "transformToScreen", "transformToScreen-58bKbWc", "([F)V", "updateLayerBlock", "forceUpdateLayerParameters", "updateLayerParameters", "invokeOnLayoutChange", "visitNodes", "T", "visitNodes-aLcG6gQ", "(ILkotlin/jvm/functions/Function1;)V", "mask", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "withPositionTranslation", "withinLayerBounds", "withinLayerBounds-k-4lQ0M", "hit", "hit-1hIXUjU", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitNear", "distanceFromEdge", "hitNear-JHbHoSQ", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZF)V", "speculativeHit", "speculativeHit-JHbHoSQ", "toCoordinator", "Companion", "HitTestSource", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NodeCoordinator.kt */
public abstract class NodeCoordinator extends LookaheadCapablePlaceable implements Measurable, LayoutCoordinates, OwnerScope {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ExpectAttachedLayoutCoordinates = "LayoutCoordinate operations are only valid when isAttached is true";
    /* access modifiers changed from: private */
    public static final HitTestSource PointerInputSource = new NodeCoordinator$Companion$PointerInputSource$1();
    /* access modifiers changed from: private */
    public static final HitTestSource SemanticsSource = new NodeCoordinator$Companion$SemanticsSource$1();
    public static final String UnmeasuredError = "Asking for measurement result of unmeasured layout modifier";
    /* access modifiers changed from: private */
    public static final ReusableGraphicsLayerScope graphicsLayerScope = new ReusableGraphicsLayerScope();
    /* access modifiers changed from: private */
    public static final Function1<NodeCoordinator, Unit> onCommitAffectingLayer = NodeCoordinator$Companion$onCommitAffectingLayer$1.INSTANCE;
    private static final Function1<NodeCoordinator, Unit> onCommitAffectingLayerParams = NodeCoordinator$Companion$onCommitAffectingLayerParams$1.INSTANCE;
    /* access modifiers changed from: private */
    public static final LayerPositionalProperties tmpLayerPositionalProperties = new LayerPositionalProperties();
    private static final float[] tmpMatrix = Matrix.m4474constructorimpl$default((float[]) null, 1, (DefaultConstructorMarker) null);
    private MeasureResult _measureResult;
    private MutableRect _rectCache;
    private final Function2<Canvas, GraphicsLayer, Unit> drawBlock = new NodeCoordinator$drawBlock$1(this);
    private GraphicsLayer explicitLayer;
    private boolean forceMeasureWithLookaheadConstraints;
    private boolean forcePlaceWithLookaheadOffset;
    private final Function0<Unit> invalidateParentLayer = new NodeCoordinator$invalidateParentLayer$1(this);
    private boolean isClipping;
    private float lastLayerAlpha = 0.8f;
    /* access modifiers changed from: private */
    public boolean lastLayerDrawingWasSkipped;
    private OwnedLayer layer;
    private Function1<? super GraphicsLayerScope, Unit> layerBlock;
    private Density layerDensity = getLayoutNode().getDensity();
    private LayoutDirection layerLayoutDirection = getLayoutNode().getLayoutDirection();
    /* access modifiers changed from: private */
    public LayerPositionalProperties layerPositionalProperties;
    private final LayoutNode layoutNode;
    private Map<AlignmentLine, Integer> oldAlignmentLines;
    private long position = IntOffset.Companion.m7251getZeronOccac();
    private boolean released;
    private NodeCoordinator wrapped;
    private NodeCoordinator wrappedBy;
    private float zIndex;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0005H&ø\u0001\u0002\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "", "childHitTest", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "", "isInLayer", "childHitTest-YqVAtuI", "(Landroidx/compose/ui/node/LayoutNode;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "entityType", "Landroidx/compose/ui/node/NodeKind;", "entityType-OLwlOKw", "()I", "interceptOutOfBoundsChildEvents", "node", "Landroidx/compose/ui/Modifier$Node;", "shouldHitTestChildren", "parentLayoutNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NodeCoordinator.kt */
    public interface HitTestSource {
        /* renamed from: childHitTest-YqVAtuI  reason: not valid java name */
        void m6134childHitTestYqVAtuI(LayoutNode layoutNode, long j, HitTestResult hitTestResult, boolean z, boolean z2);

        /* renamed from: entityType-OLwlOKw  reason: not valid java name */
        int m6135entityTypeOLwlOKw();

        boolean interceptOutOfBoundsChildEvents(Modifier.Node node);

        boolean shouldHitTestChildren(LayoutNode layoutNode);
    }

    private static /* synthetic */ void getDrawBlock$annotations() {
    }

    public abstract void ensureLookaheadDelegateCreated();

    public abstract LookaheadDelegate getLookaheadDelegate();

    public abstract Modifier.Node getTail();

    /* access modifiers changed from: protected */
    public abstract void setLookaheadDelegate(LookaheadDelegate lookaheadDelegate);

    public LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public NodeCoordinator(LayoutNode layoutNode2) {
        this.layoutNode = layoutNode2;
    }

    public final boolean getForcePlaceWithLookaheadOffset$ui_release() {
        return this.forcePlaceWithLookaheadOffset;
    }

    public final void setForcePlaceWithLookaheadOffset$ui_release(boolean z) {
        this.forcePlaceWithLookaheadOffset = z;
    }

    public final boolean getForceMeasureWithLookaheadConstraints$ui_release() {
        return this.forceMeasureWithLookaheadConstraints;
    }

    public final void setForceMeasureWithLookaheadConstraints$ui_release(boolean z) {
        this.forceMeasureWithLookaheadConstraints = z;
    }

    public final NodeCoordinator getWrapped$ui_release() {
        return this.wrapped;
    }

    public final void setWrapped$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrapped = nodeCoordinator;
    }

    public final NodeCoordinator getWrappedBy$ui_release() {
        return this.wrappedBy;
    }

    public final void setWrappedBy$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrappedBy = nodeCoordinator;
    }

    public LayoutDirection getLayoutDirection() {
        return getLayoutNode().getLayoutDirection();
    }

    public float getDensity() {
        return getLayoutNode().getDensity().getDensity();
    }

    public float getFontScale() {
        return getLayoutNode().getDensity().getFontScale();
    }

    public LookaheadCapablePlaceable getParent() {
        return this.wrappedBy;
    }

    public LayoutCoordinates getCoordinates() {
        return this;
    }

    public boolean getIntroducesMotionFrameOfReference() {
        return isPlacedUnderMotionFrameOfReference();
    }

    /* access modifiers changed from: private */
    public final Modifier.Node headNode(boolean z) {
        Modifier.Node tail;
        if (getLayoutNode().getOuterCoordinator$ui_release() == this) {
            return getLayoutNode().getNodes$ui_release().getHead$ui_release();
        }
        if (z) {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator == null || (tail = nodeCoordinator.getTail()) == null) {
                return null;
            }
            return tail.getChild$ui_release();
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        if (nodeCoordinator2 != null) {
            return nodeCoordinator2.getTail();
        }
        return null;
    }

    public final void visitNodes(int i, boolean z, Function1<? super Modifier.Node, Unit> function1) {
        Modifier.Node tail = getTail();
        if (z || (tail = tail.getParent$ui_release()) != null) {
            Modifier.Node access$headNode = headNode(z);
            while (access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & i) != 0) {
                if ((access$headNode.getKindSet$ui_release() & i) != 0) {
                    function1.invoke(access$headNode);
                }
                if (access$headNode != tail) {
                    access$headNode = access$headNode.getChild$ui_release();
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: visitNodes-aLcG6gQ  reason: not valid java name */
    public final /* synthetic */ <T> void m6127visitNodesaLcG6gQ(int i, Function1<? super T, Unit> function1) {
        boolean r0 = NodeKindKt.m6148getIncludeSelfInTraversalH91voCI(i);
        Modifier.Node tail = getTail();
        if (r0 || (tail = tail.getParent$ui_release()) != null) {
            Modifier.Node access$headNode = headNode(r0);
            while (access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & i) != 0) {
                if ((access$headNode.getKindSet$ui_release() & i) != 0) {
                    Modifier.Node node = access$headNode;
                    Modifier.Node node2 = access$headNode;
                    MutableVector mutableVector = null;
                    while (node2 != null) {
                        Intrinsics.reifiedOperationMarker(3, "T");
                        if (node2 instanceof Object) {
                            function1.invoke(node2);
                        } else {
                            Modifier.Node node3 = node2;
                            if ((node2.getKindSet$ui_release() & i) != 0 && (node2 instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                    Modifier.Node node4 = delegate$ui_release;
                                    if ((delegate$ui_release.getKindSet$ui_release() & i) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            node2 = delegate$ui_release;
                                        } else {
                                            MutableVector mutableVector2 = mutableVector;
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                MutableVector mutableVector3 = mutableVector;
                                            }
                                            Modifier.Node node5 = node2;
                                            if (node2 != null) {
                                                MutableVector mutableVector4 = mutableVector;
                                                if (mutableVector != null) {
                                                    mutableVector.add(node2);
                                                }
                                                node2 = null;
                                            }
                                            MutableVector mutableVector5 = mutableVector;
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate$ui_release);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                        }
                        MutableVector mutableVector6 = mutableVector;
                        node2 = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if (access$headNode != tail) {
                    access$headNode = access$headNode.getChild$ui_release();
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: hasNode-H91voCI  reason: not valid java name */
    private final boolean m6093hasNodeH91voCI(int i) {
        Modifier.Node headNode = headNode(NodeKindKt.m6148getIncludeSelfInTraversalH91voCI(i));
        return headNode != null && DelegatableNodeKt.m5952has64DMado(headNode, i);
    }

    /* renamed from: head-H91voCI  reason: not valid java name */
    public final Modifier.Node m6109headH91voCI(int i) {
        boolean r0 = NodeKindKt.m6148getIncludeSelfInTraversalH91voCI(i);
        Modifier.Node tail = getTail();
        if (!r0 && (tail = tail.getParent$ui_release()) == null) {
            return null;
        }
        Modifier.Node access$headNode = headNode(r0);
        while (access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & i) != 0) {
            if ((access$headNode.getKindSet$ui_release() & i) != 0) {
                return access$headNode;
            }
            if (access$headNode == tail) {
                return null;
            }
            access$headNode = access$headNode.getChild$ui_release();
        }
        return null;
    }

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    public final long m6108getSizeYbymL2g() {
        return m5884getMeasuredSizeYbymL2g();
    }

    /* access modifiers changed from: protected */
    public final Function1<GraphicsLayerScope, Unit> getLayerBlock() {
        return this.layerBlock;
    }

    public final boolean isTransparent() {
        if (this.layer != null && this.lastLayerAlpha <= 0.0f) {
            return true;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            return nodeCoordinator.isTransparent();
        }
        return false;
    }

    public AlignmentLinesOwner getAlignmentLinesOwner() {
        return getLayoutNode().getLayoutDelegate$ui_release().getAlignmentLinesOwner$ui_release();
    }

    public LookaheadCapablePlaceable getChild() {
        return this.wrapped;
    }

    public void replace$ui_release() {
        GraphicsLayer graphicsLayer = this.explicitLayer;
        if (graphicsLayer != null) {
            m6119placeAtf8xVGno(m6107getPositionnOccac(), this.zIndex, graphicsLayer);
        } else {
            m6120placeAtf8xVGno(m6107getPositionnOccac(), this.zIndex, this.layerBlock);
        }
    }

    public boolean getHasMeasureResult() {
        return this._measureResult != null;
    }

    public boolean isAttached() {
        return getTail().isAttached();
    }

    public MeasureResult getMeasureResult$ui_release() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException(UnmeasuredError.toString());
    }

    public void setMeasureResult$ui_release(MeasureResult measureResult) {
        MeasureResult measureResult2 = this._measureResult;
        if (measureResult != measureResult2) {
            this._measureResult = measureResult;
            if (!(measureResult2 != null && measureResult.getWidth() == measureResult2.getWidth() && measureResult.getHeight() == measureResult2.getHeight())) {
                onMeasureResultChanged(measureResult.getWidth(), measureResult.getHeight());
            }
            Map<AlignmentLine, Integer> map = this.oldAlignmentLines;
            if (((map != null && !map.isEmpty()) || !measureResult.getAlignmentLines().isEmpty()) && !Intrinsics.areEqual((Object) measureResult.getAlignmentLines(), (Object) this.oldAlignmentLines)) {
                getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
                Map<AlignmentLine, Integer> map2 = this.oldAlignmentLines;
                if (map2 == null) {
                    map2 = new LinkedHashMap<>();
                    this.oldAlignmentLines = map2;
                }
                map2.clear();
                map2.putAll(measureResult.getAlignmentLines());
            }
        }
    }

    public Set<AlignmentLine> getProvidedAlignmentLines() {
        Set<AlignmentLine> set = null;
        for (NodeCoordinator nodeCoordinator = this; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.wrapped) {
            MeasureResult measureResult = nodeCoordinator._measureResult;
            Map<AlignmentLine, Integer> alignmentLines = measureResult != null ? measureResult.getAlignmentLines() : null;
            if (alignmentLines != null && (!alignmentLines.isEmpty())) {
                if (set == null) {
                    set = new LinkedHashSet<>();
                }
                set.addAll(alignmentLines.keySet());
            }
        }
        return set == null ? SetsKt.emptySet() : set;
    }

    /* access modifiers changed from: protected */
    public void onMeasureResultChanged(int i, int i2) {
        NodeCoordinator nodeCoordinator;
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.m6194resizeozmzZPI(IntSizeKt.IntSize(i, i2));
        } else if (getLayoutNode().isPlaced() && (nodeCoordinator = this.wrappedBy) != null) {
            nodeCoordinator.invalidateLayer();
        }
        m5888setMeasuredSizeozmzZPI(IntSizeKt.IntSize(i, i2));
        if (this.layerBlock != null) {
            updateLayerParameters(false);
        }
        int r10 = NodeKind.m6139constructorimpl(4);
        boolean r0 = NodeKindKt.m6148getIncludeSelfInTraversalH91voCI(r10);
        Modifier.Node tail = getTail();
        if (r0 || (tail = tail.getParent$ui_release()) != null) {
            Modifier.Node access$headNode = headNode(r0);
            while (access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & r10) != 0) {
                if ((access$headNode.getKindSet$ui_release() & r10) != 0) {
                    Modifier.Node node = access$headNode;
                    MutableVector mutableVector = null;
                    while (node != null) {
                        if (node instanceof DrawModifierNode) {
                            ((DrawModifierNode) node).onMeasureResultChanged();
                        } else if ((node.getKindSet$ui_release() & r10) != 0 && (node instanceof DelegatingNode)) {
                            int i3 = 0;
                            for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                if ((delegate$ui_release.getKindSet$ui_release() & r10) != 0) {
                                    i3++;
                                    if (i3 == 1) {
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
                            if (i3 == 1) {
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if (access$headNode == tail) {
                    break;
                }
                access$headNode = access$headNode.getChild$ui_release();
            }
        }
        Owner owner$ui_release = getLayoutNode().getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.onLayoutChange(getLayoutNode());
        }
    }

    /* renamed from: getPosition-nOcc-ac  reason: not valid java name */
    public long m6107getPositionnOccac() {
        return this.position;
    }

    /* access modifiers changed from: protected */
    /* renamed from: setPosition--gyyYBs  reason: not valid java name */
    public void m6123setPositiongyyYBs(long j) {
        this.position = j;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    /* access modifiers changed from: protected */
    public final void setZIndex(float f) {
        this.zIndex = f;
    }

    public Object getParentData() {
        if (!getLayoutNode().getNodes$ui_release().m6082hasH91voCI$ui_release(NodeKind.m6139constructorimpl(64))) {
            return null;
        }
        getTail();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        for (Modifier.Node tail$ui_release = getLayoutNode().getNodes$ui_release().getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
            if ((NodeKind.m6139constructorimpl(64) & tail$ui_release.getKindSet$ui_release()) != 0) {
                int r4 = NodeKind.m6139constructorimpl(64);
                MutableVector mutableVector = null;
                Modifier.Node node = tail$ui_release;
                while (node != null) {
                    if (node instanceof ParentDataModifierNode) {
                        objectRef.element = ((ParentDataModifierNode) node).modifyParentData(getLayoutNode().getDensity(), objectRef.element);
                    } else if ((node.getKindSet$ui_release() & r4) != 0 && (node instanceof DelegatingNode)) {
                        int i = 0;
                        for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                            if ((delegate$ui_release.getKindSet$ui_release() & r4) != 0) {
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
        }
        return objectRef.element;
    }

    public final void onCoordinatesUsed$ui_release() {
        getLayoutNode().getLayoutDelegate$ui_release().onCoordinatesUsed();
    }

    public final LayoutCoordinates getParentLayoutCoordinates() {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        onCoordinatesUsed$ui_release();
        return getLayoutNode().getOuterCoordinator$ui_release().wrappedBy;
    }

    public final LayoutCoordinates getParentCoordinates() {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        onCoordinatesUsed$ui_release();
        return this.wrappedBy;
    }

    /* access modifiers changed from: protected */
    public final MutableRect getRectCache() {
        MutableRect mutableRect = this._rectCache;
        if (mutableRect != null) {
            return mutableRect;
        }
        MutableRect mutableRect2 = new MutableRect(0.0f, 0.0f, 0.0f, 0.0f);
        this._rectCache = mutableRect2;
        return mutableRect2;
    }

    /* access modifiers changed from: private */
    public final OwnerSnapshotObserver getSnapshotObserver() {
        return LayoutNodeKt.requireOwner(getLayoutNode()).getSnapshotObserver();
    }

    /* renamed from: getLastMeasurementConstraints-msEJaDk$ui_release  reason: not valid java name */
    public final long m6105getLastMeasurementConstraintsmsEJaDk$ui_release() {
        return m5885getMeasurementConstraintsmsEJaDk();
    }

    /* access modifiers changed from: protected */
    /* renamed from: performingMeasure-K40F9xA  reason: not valid java name */
    public final Placeable m6118performingMeasureK40F9xA(long j, Function0<? extends Placeable> function0) {
        m5889setMeasurementConstraintsBRTryo0(j);
        return (Placeable) function0.invoke();
    }

    /* access modifiers changed from: protected */
    /* renamed from: placeAt-f8xVGno  reason: not valid java name */
    public void m6120placeAtf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
        if (this.forcePlaceWithLookaheadOffset) {
            LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            m6097placeSelfMLgxB_4(lookaheadDelegate.m6066getPositionnOccac(), f, function1, (GraphicsLayer) null);
            return;
        }
        m6097placeSelfMLgxB_4(j, f, function1, (GraphicsLayer) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: placeAt-f8xVGno  reason: not valid java name */
    public void m6119placeAtf8xVGno(long j, float f, GraphicsLayer graphicsLayer) {
        if (this.forcePlaceWithLookaheadOffset) {
            LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            m6097placeSelfMLgxB_4(lookaheadDelegate.m6066getPositionnOccac(), f, (Function1<? super GraphicsLayerScope, Unit>) null, graphicsLayer);
            return;
        }
        m6097placeSelfMLgxB_4(j, f, (Function1<? super GraphicsLayerScope, Unit>) null, graphicsLayer);
    }

    /* renamed from: placeSelf-MLgxB_4  reason: not valid java name */
    private final void m6097placeSelfMLgxB_4(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1, GraphicsLayer graphicsLayer) {
        if (graphicsLayer != null) {
            if (!(function1 == null)) {
                InlineClassHelperKt.throwIllegalArgumentException("both ways to create layers shouldn't be used together");
            }
            if (this.explicitLayer != graphicsLayer) {
                this.explicitLayer = null;
                updateLayerBlock$default(this, (Function1) null, false, 2, (Object) null);
                this.explicitLayer = graphicsLayer;
            }
            if (this.layer == null) {
                OwnedLayer createLayer = LayoutNodeKt.requireOwner(getLayoutNode()).createLayer(this.drawBlock, this.invalidateParentLayer, graphicsLayer);
                createLayer.m6194resizeozmzZPI(m5884getMeasuredSizeYbymL2g());
                createLayer.m6193movegyyYBs(j);
                this.layer = createLayer;
                getLayoutNode().setInnerLayerCoordinatorIsDirty$ui_release(true);
                this.invalidateParentLayer.invoke();
            }
        } else {
            if (this.explicitLayer != null) {
                this.explicitLayer = null;
                updateLayerBlock$default(this, (Function1) null, false, 2, (Object) null);
            }
            updateLayerBlock$default(this, function1, false, 2, (Object) null);
        }
        if (!IntOffset.m7240equalsimpl0(m6107getPositionnOccac(), j)) {
            m6123setPositiongyyYBs(j);
            getLayoutNode().getLayoutDelegate$ui_release().getMeasurePassDelegate$ui_release().notifyChildrenUsingCoordinatesWhilePlacing();
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.m6193movegyyYBs(j);
            } else {
                NodeCoordinator nodeCoordinator = this.wrappedBy;
                if (nodeCoordinator != null) {
                    nodeCoordinator.invalidateLayer();
                }
            }
            invalidateAlignmentLinesFromPositionChange(this);
            Owner owner$ui_release = getLayoutNode().getOwner$ui_release();
            if (owner$ui_release != null) {
                owner$ui_release.onLayoutChange(getLayoutNode());
            }
        }
        this.zIndex = f;
        if (!isPlacingForAlignment$ui_release()) {
            captureRulers$ui_release(getMeasureResult$ui_release());
        }
    }

    public final void releaseLayer() {
        if (this.layer != null) {
            if (this.explicitLayer != null) {
                this.explicitLayer = null;
            }
            updateLayerBlock$default(this, (Function1) null, false, 2, (Object) null);
            LayoutNode.requestRelayout$ui_release$default(getLayoutNode(), false, 1, (Object) null);
        }
    }

    /* renamed from: placeSelfApparentToRealOffset-MLgxB_4  reason: not valid java name */
    public final void m6121placeSelfApparentToRealOffsetMLgxB_4(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1, GraphicsLayer graphicsLayer) {
        m6097placeSelfMLgxB_4(IntOffset.m7245plusqkQi6aY(j, m5883getApparentToRealOffsetnOccac()), f, function1, graphicsLayer);
    }

    public final void draw(Canvas canvas, GraphicsLayer graphicsLayer) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.drawLayer(canvas, graphicsLayer);
            return;
        }
        float r0 = (float) IntOffset.m7241getXimpl(m6107getPositionnOccac());
        float r1 = (float) IntOffset.m7242getYimpl(m6107getPositionnOccac());
        canvas.translate(r0, r1);
        drawContainedDrawModifiers(canvas, graphicsLayer);
        canvas.translate(-r0, -r1);
    }

    public void performDraw(Canvas canvas, GraphicsLayer graphicsLayer) {
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.draw(canvas, graphicsLayer);
        }
    }

    public static /* synthetic */ void updateLayerBlock$default(NodeCoordinator nodeCoordinator, Function1 function1, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            nodeCoordinator.updateLayerBlock(function1, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerBlock");
    }

    public final void updateLayerBlock(Function1<? super GraphicsLayerScope, Unit> function1, boolean z) {
        Owner owner$ui_release;
        if (!(function1 == null || this.explicitLayer == null)) {
            InlineClassHelperKt.throwIllegalArgumentException("layerBlock can't be provided when explicitLayer is provided");
        }
        LayoutNode layoutNode2 = getLayoutNode();
        boolean z2 = z || this.layerBlock != function1 || !Intrinsics.areEqual((Object) this.layerDensity, (Object) layoutNode2.getDensity()) || this.layerLayoutDirection != layoutNode2.getLayoutDirection();
        this.layerDensity = layoutNode2.getDensity();
        this.layerLayoutDirection = layoutNode2.getLayoutDirection();
        if (!layoutNode2.isAttached() || function1 == null) {
            this.layerBlock = null;
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.destroy();
                layoutNode2.setInnerLayerCoordinatorIsDirty$ui_release(true);
                this.invalidateParentLayer.invoke();
                if (isAttached() && (owner$ui_release = layoutNode2.getOwner$ui_release()) != null) {
                    owner$ui_release.onLayoutChange(layoutNode2);
                }
            }
            this.layer = null;
            this.lastLayerDrawingWasSkipped = false;
            return;
        }
        this.layerBlock = function1;
        if (this.layer == null) {
            OwnedLayer createLayer$default = Owner.createLayer$default(LayoutNodeKt.requireOwner(layoutNode2), this.drawBlock, this.invalidateParentLayer, (GraphicsLayer) null, 4, (Object) null);
            createLayer$default.m6194resizeozmzZPI(m5884getMeasuredSizeYbymL2g());
            createLayer$default.m6193movegyyYBs(m6107getPositionnOccac());
            this.layer = createLayer$default;
            updateLayerParameters$default(this, false, 1, (Object) null);
            layoutNode2.setInnerLayerCoordinatorIsDirty$ui_release(true);
            this.invalidateParentLayer.invoke();
        } else if (z2) {
            updateLayerParameters$default(this, false, 1, (Object) null);
        }
    }

    static /* synthetic */ void updateLayerParameters$default(NodeCoordinator nodeCoordinator, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            nodeCoordinator.updateLayerParameters(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerParameters");
    }

    private final void updateLayerParameters(boolean z) {
        Owner owner$ui_release;
        if (this.explicitLayer == null) {
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                Function1<? super GraphicsLayerScope, Unit> function1 = this.layerBlock;
                if (function1 != null) {
                    ReusableGraphicsLayerScope reusableGraphicsLayerScope = graphicsLayerScope;
                    reusableGraphicsLayerScope.reset();
                    reusableGraphicsLayerScope.setGraphicsDensity$ui_release(getLayoutNode().getDensity());
                    reusableGraphicsLayerScope.setLayoutDirection$ui_release(getLayoutNode().getLayoutDirection());
                    reusableGraphicsLayerScope.m4586setSizeuvyYCjk(IntSizeKt.m7295toSizeozmzZPI(m6108getSizeYbymL2g()));
                    getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayerParams, new NodeCoordinator$updateLayerParameters$1(function1));
                    LayerPositionalProperties layerPositionalProperties2 = this.layerPositionalProperties;
                    if (layerPositionalProperties2 == null) {
                        layerPositionalProperties2 = new LayerPositionalProperties();
                        this.layerPositionalProperties = layerPositionalProperties2;
                    }
                    layerPositionalProperties2.copyFrom((GraphicsLayerScope) reusableGraphicsLayerScope);
                    ownedLayer.updateLayerProperties(reusableGraphicsLayerScope);
                    this.isClipping = reusableGraphicsLayerScope.getClip();
                    this.lastLayerAlpha = reusableGraphicsLayerScope.getAlpha();
                    if (z && (owner$ui_release = getLayoutNode().getOwner$ui_release()) != null) {
                        owner$ui_release.onLayoutChange(getLayoutNode());
                        return;
                    }
                    return;
                }
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("updateLayerParameters requires a non-null layerBlock");
                throw new KotlinNothingValueException();
            }
            if (!(this.layerBlock == null)) {
                InlineClassHelperKt.throwIllegalStateException("null layer with a non-null layerBlock");
            }
        }
    }

    public final boolean getLastLayerDrawingWasSkipped$ui_release() {
        return this.lastLayerDrawingWasSkipped;
    }

    public final OwnedLayer getLayer() {
        return this.layer;
    }

    public boolean isValidOwnerScope() {
        return this.layer != null && !this.released && getLayoutNode().isAttached();
    }

    /* renamed from: getMinimumTouchTargetSize-NH-jbRc  reason: not valid java name */
    public final long m6106getMinimumTouchTargetSizeNHjbRc() {
        return this.layerDensity.m7092toSizeXkaWNTQ(getLayoutNode().getViewConfiguration().m6337getMinimumTouchTargetSizeMYxV2XQ());
    }

    /* renamed from: hitTest-YqVAtuI  reason: not valid java name */
    public final void m6110hitTestYqVAtuI(HitTestSource hitTestSource, long j, HitTestResult hitTestResult, boolean z, boolean z2) {
        float f;
        Modifier.Node r1 = m6109headH91voCI(hitTestSource.m6135entityTypeOLwlOKw());
        if (!m6129withinLayerBoundsk4lQ0M(j)) {
            if (z) {
                float r8 = m6103distanceInMinimumTouchTargettz77jQw(j, m6106getMinimumTouchTargetSizeNHjbRc());
                if (!Float.isInfinite(r8) && !Float.isNaN(r8) && hitTestResult.isHitInMinimumTouchTargetBetter(r8, false)) {
                    m6095hitNearJHbHoSQ(r1, hitTestSource, j, hitTestResult, z, false, r8);
                }
            }
        } else if (r1 == null) {
            m6111hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
        } else if (m6112isPointerInBoundsk4lQ0M(j)) {
            m6094hit1hIXUjU(r1, hitTestSource, j, hitTestResult, z, z2);
        } else {
            if (!z) {
                f = Float.POSITIVE_INFINITY;
            } else {
                f = m6103distanceInMinimumTouchTargettz77jQw(j, m6106getMinimumTouchTargetSizeNHjbRc());
            }
            float f2 = f;
            if (Float.isInfinite(f2) || Float.isNaN(f2) || !hitTestResult.isHitInMinimumTouchTargetBetter(f2, z2)) {
                m6098speculativeHitJHbHoSQ(r1, hitTestSource, j, hitTestResult, z, z2, f2);
            } else {
                m6095hitNearJHbHoSQ(r1, hitTestSource, j, hitTestResult, z, z2, f2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: hit-1hIXUjU  reason: not valid java name */
    public final void m6094hit1hIXUjU(Modifier.Node node, HitTestSource hitTestSource, long j, HitTestResult hitTestResult, boolean z, boolean z2) {
        if (node == null) {
            m6111hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
            return;
        }
        boolean z3 = z2;
        hitTestResult.hit(node, z3, new NodeCoordinator$hit$1(this, node, hitTestSource, j, hitTestResult, z, z3));
    }

    /* access modifiers changed from: private */
    /* renamed from: hitNear-JHbHoSQ  reason: not valid java name */
    public final void m6095hitNearJHbHoSQ(Modifier.Node node, HitTestSource hitTestSource, long j, HitTestResult hitTestResult, boolean z, boolean z2, float f) {
        if (node == null) {
            m6111hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
            return;
        }
        boolean z3 = z2;
        float f2 = f;
        hitTestResult.hitInMinimumTouchTarget(node, f2, z3, new NodeCoordinator$hitNear$1(this, node, hitTestSource, j, hitTestResult, z, z3, f2));
    }

    /* access modifiers changed from: private */
    /* renamed from: speculativeHit-JHbHoSQ  reason: not valid java name */
    public final void m6098speculativeHitJHbHoSQ(Modifier.Node node, HitTestSource hitTestSource, long j, HitTestResult hitTestResult, boolean z, boolean z2, float f) {
        if (node == null) {
            m6111hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
        } else if (hitTestSource.interceptOutOfBoundsChildEvents(node)) {
            float f2 = f;
            hitTestResult.speculativeHit(node, f2, z2, new NodeCoordinator$speculativeHit$1(this, node, hitTestSource, j, hitTestResult, z, z2, f));
        } else {
            m6098speculativeHitJHbHoSQ(NodeCoordinatorKt.m6137nextUntilhw7D004(node, hitTestSource.m6135entityTypeOLwlOKw(), NodeKind.m6139constructorimpl(2)), hitTestSource, j, hitTestResult, z, z2, f);
        }
    }

    /* renamed from: hitTestChild-YqVAtuI  reason: not valid java name */
    public void m6111hitTestChildYqVAtuI(HitTestSource hitTestSource, long j, HitTestResult hitTestResult, boolean z, boolean z2) {
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.m6110hitTestYqVAtuI(hitTestSource, m6092fromParentPosition8S9VItk$default(nodeCoordinator, j, false, 2, (Object) null), hitTestResult, z, z2);
        }
    }

    public final Rect touchBoundsInRoot() {
        if (!isAttached()) {
            return Rect.Companion.getZero();
        }
        LayoutCoordinates findRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
        MutableRect rectCache = getRectCache();
        long r2 = m6102calculateMinimumTouchTargetPaddingE7KxVPU(m6106getMinimumTouchTargetSizeNHjbRc());
        rectCache.setLeft(-Size.m4056getWidthimpl(r2));
        rectCache.setTop(-Size.m4053getHeightimpl(r2));
        rectCache.setRight(((float) getMeasuredWidth()) + Size.m4056getWidthimpl(r2));
        rectCache.setBottom(((float) getMeasuredHeight()) + Size.m4053getHeightimpl(r2));
        NodeCoordinator nodeCoordinator = this;
        while (nodeCoordinator != findRootCoordinates) {
            nodeCoordinator.rectInParent$ui_release(rectCache, false, true);
            if (rectCache.isEmpty()) {
                return Rect.Companion.getZero();
            }
            nodeCoordinator = nodeCoordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
        }
        return MutableRectKt.toRect(rectCache);
    }

    /* renamed from: screenToLocal-MK-Hz9U  reason: not valid java name */
    public long m6122screenToLocalMKHz9U(long j) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        return m6113localPositionOfR5De75A(LayoutCoordinatesKt.findRootCoordinates(this), LayoutNodeKt.requireOwner(getLayoutNode()).m5673screenToLocalMKHz9U(j));
    }

    /* renamed from: localToScreen-MK-Hz9U  reason: not valid java name */
    public long m6116localToScreenMKHz9U(long j) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        return LayoutNodeKt.requireOwner(getLayoutNode()).m5672localToScreenMKHz9U(m6115localToRootMKHz9U(j));
    }

    /* renamed from: windowToLocal-MK-Hz9U  reason: not valid java name */
    public long m6128windowToLocalMKHz9U(long j) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        LayoutCoordinates findRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
        return m6113localPositionOfR5De75A(findRootCoordinates, Offset.m3991minusMKHz9U(LayoutNodeKt.requireOwner(getLayoutNode()).m6196calculateLocalPositionMKHz9U(j), LayoutCoordinatesKt.positionInRoot(findRootCoordinates)));
    }

    /* renamed from: localToWindow-MK-Hz9U  reason: not valid java name */
    public long m6117localToWindowMKHz9U(long j) {
        return LayoutNodeKt.requireOwner(getLayoutNode()).m6197calculatePositionInWindowMKHz9U(m6115localToRootMKHz9U(j));
    }

    private final NodeCoordinator toCoordinator(LayoutCoordinates layoutCoordinates) {
        NodeCoordinator coordinator;
        LookaheadLayoutCoordinates lookaheadLayoutCoordinates = layoutCoordinates instanceof LookaheadLayoutCoordinates ? (LookaheadLayoutCoordinates) layoutCoordinates : null;
        if (lookaheadLayoutCoordinates != null && (coordinator = lookaheadLayoutCoordinates.getCoordinator()) != null) {
            return coordinator;
        }
        Intrinsics.checkNotNull(layoutCoordinates, "null cannot be cast to non-null type androidx.compose.ui.node.NodeCoordinator");
        return (NodeCoordinator) layoutCoordinates;
    }

    /* renamed from: localPositionOf-R5De75A  reason: not valid java name */
    public long m6113localPositionOfR5De75A(LayoutCoordinates layoutCoordinates, long j) {
        return m6114localPositionOfS_NoaFU(layoutCoordinates, j, true);
    }

    /* renamed from: localPositionOf-S_NoaFU  reason: not valid java name */
    public long m6114localPositionOfS_NoaFU(LayoutCoordinates layoutCoordinates, long j, boolean z) {
        if (layoutCoordinates instanceof LookaheadLayoutCoordinates) {
            ((LookaheadLayoutCoordinates) layoutCoordinates).getCoordinator().onCoordinatesUsed$ui_release();
            return Offset.m3996unaryMinusF1C5BW0(layoutCoordinates.m5802localPositionOfS_NoaFU(this, Offset.m3996unaryMinusF1C5BW0(j), z));
        }
        NodeCoordinator coordinator = toCoordinator(layoutCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator findCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        while (coordinator != findCommonAncestor$ui_release) {
            j = coordinator.m6124toParentPosition8S9VItk(j, z);
            coordinator = coordinator.wrappedBy;
            Intrinsics.checkNotNull(coordinator);
        }
        return m6091ancestorToLocalS_NoaFU(findCommonAncestor$ui_release, j, z);
    }

    /* renamed from: transformFrom-EL8BTi8  reason: not valid java name */
    public void m6125transformFromEL8BTi8(LayoutCoordinates layoutCoordinates, float[] fArr) {
        NodeCoordinator coordinator = toCoordinator(layoutCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator findCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        Matrix.m4483resetimpl(fArr);
        coordinator.m6101transformToAncestorEL8BTi8(findCommonAncestor$ui_release, fArr);
        m6100transformFromAncestorEL8BTi8(findCommonAncestor$ui_release, fArr);
    }

    /* renamed from: transformToScreen-58bKbWc  reason: not valid java name */
    public void m6126transformToScreen58bKbWc(float[] fArr) {
        Owner requireOwner = LayoutNodeKt.requireOwner(getLayoutNode());
        m6101transformToAncestorEL8BTi8(toCoordinator(LayoutCoordinatesKt.findRootCoordinates(this)), fArr);
        requireOwner.m5671localToScreen58bKbWc(fArr);
    }

    /* renamed from: transformToAncestor-EL8BTi8  reason: not valid java name */
    private final void m6101transformToAncestorEL8BTi8(NodeCoordinator nodeCoordinator, float[] fArr) {
        NodeCoordinator nodeCoordinator2 = this;
        while (!Intrinsics.areEqual((Object) nodeCoordinator2, (Object) nodeCoordinator)) {
            OwnedLayer ownedLayer = nodeCoordinator2.layer;
            if (ownedLayer != null) {
                ownedLayer.m6195transform58bKbWc(fArr);
            }
            long r1 = nodeCoordinator2.m6107getPositionnOccac();
            if (!IntOffset.m7240equalsimpl0(r1, IntOffset.Companion.m7251getZeronOccac())) {
                float[] fArr2 = tmpMatrix;
                Matrix.m4483resetimpl(fArr2);
                Matrix.m4494translateimpl$default(fArr2, (float) IntOffset.m7241getXimpl(r1), (float) IntOffset.m7242getYimpl(r1), 0.0f, 4, (Object) null);
                Matrix.m4491timesAssign58bKbWc(fArr, fArr2);
            }
            nodeCoordinator2 = nodeCoordinator2.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator2);
        }
    }

    /* renamed from: transformFromAncestor-EL8BTi8  reason: not valid java name */
    private final void m6100transformFromAncestorEL8BTi8(NodeCoordinator nodeCoordinator, float[] fArr) {
        if (!Intrinsics.areEqual((Object) nodeCoordinator, (Object) this)) {
            NodeCoordinator nodeCoordinator2 = this.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator2);
            nodeCoordinator2.m6100transformFromAncestorEL8BTi8(nodeCoordinator, fArr);
            if (!IntOffset.m7240equalsimpl0(m6107getPositionnOccac(), IntOffset.Companion.m7251getZeronOccac())) {
                float[] fArr2 = tmpMatrix;
                Matrix.m4483resetimpl(fArr2);
                Matrix.m4494translateimpl$default(fArr2, -((float) IntOffset.m7241getXimpl(m6107getPositionnOccac())), -((float) IntOffset.m7242getYimpl(m6107getPositionnOccac())), 0.0f, 4, (Object) null);
                Matrix.m4491timesAssign58bKbWc(fArr, fArr2);
            }
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.m6190inverseTransform58bKbWc(fArr);
            }
        }
    }

    public Rect localBoundingBoxOf(LayoutCoordinates layoutCoordinates, boolean z) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        if (!layoutCoordinates.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinates " + layoutCoordinates + " is not attached!");
        }
        NodeCoordinator coordinator = toCoordinator(layoutCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator findCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        MutableRect rectCache = getRectCache();
        rectCache.setLeft(0.0f);
        rectCache.setTop(0.0f);
        rectCache.setRight((float) IntSize.m7283getWidthimpl(layoutCoordinates.m5800getSizeYbymL2g()));
        rectCache.setBottom((float) IntSize.m7282getHeightimpl(layoutCoordinates.m5800getSizeYbymL2g()));
        NodeCoordinator nodeCoordinator = coordinator;
        while (nodeCoordinator != findCommonAncestor$ui_release) {
            boolean z2 = z;
            rectInParent$ui_release$default(nodeCoordinator, rectCache, z2, false, 4, (Object) null);
            if (rectCache.isEmpty()) {
                return Rect.Companion.getZero();
            }
            nodeCoordinator = nodeCoordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
            z = z2;
        }
        ancestorToLocal(findCommonAncestor$ui_release, rectCache, z);
        return MutableRectKt.toRect(rectCache);
    }

    /* renamed from: ancestorToLocal-S_NoaFU  reason: not valid java name */
    private final long m6091ancestorToLocalS_NoaFU(NodeCoordinator nodeCoordinator, long j, boolean z) {
        if (nodeCoordinator == this) {
            return j;
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        if (nodeCoordinator2 == null || Intrinsics.areEqual((Object) nodeCoordinator, (Object) nodeCoordinator2)) {
            return m6104fromParentPosition8S9VItk(j, z);
        }
        return m6104fromParentPosition8S9VItk(nodeCoordinator2.m6091ancestorToLocalS_NoaFU(nodeCoordinator, j, z), z);
    }

    private final void ancestorToLocal(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z) {
        if (nodeCoordinator != this) {
            NodeCoordinator nodeCoordinator2 = this.wrappedBy;
            if (nodeCoordinator2 != null) {
                nodeCoordinator2.ancestorToLocal(nodeCoordinator, mutableRect, z);
            }
            fromParentRect(mutableRect, z);
        }
    }

    /* renamed from: localToRoot-MK-Hz9U  reason: not valid java name */
    public long m6115localToRootMKHz9U(long j) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        onCoordinatesUsed$ui_release();
        long j2 = j;
        for (NodeCoordinator nodeCoordinator = this; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.wrappedBy) {
            j2 = m6099toParentPosition8S9VItk$default(nodeCoordinator, j2, false, 2, (Object) null);
        }
        return j2;
    }

    /* access modifiers changed from: protected */
    public final void withPositionTranslation(Canvas canvas, Function1<? super Canvas, Unit> function1) {
        float r0 = (float) IntOffset.m7241getXimpl(m6107getPositionnOccac());
        float r1 = (float) IntOffset.m7242getYimpl(m6107getPositionnOccac());
        canvas.translate(r0, r1);
        function1.invoke(canvas);
        canvas.translate(-r0, -r1);
    }

    /* renamed from: toParentPosition-8S9VItk$default  reason: not valid java name */
    public static /* synthetic */ long m6099toParentPosition8S9VItk$default(NodeCoordinator nodeCoordinator, long j, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = true;
            }
            return nodeCoordinator.m6124toParentPosition8S9VItk(j, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toParentPosition-8S9VItk");
    }

    /* renamed from: toParentPosition-8S9VItk  reason: not valid java name */
    public long m6124toParentPosition8S9VItk(long j, boolean z) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            j = ownedLayer.m6192mapOffset8S9VItk(j, false);
        }
        if (z || !isPlacedUnderMotionFrameOfReference()) {
            return IntOffsetKt.m7255plusNvtHpc(j, m6107getPositionnOccac());
        }
        return j;
    }

    /* renamed from: fromParentPosition-8S9VItk$default  reason: not valid java name */
    public static /* synthetic */ long m6092fromParentPosition8S9VItk$default(NodeCoordinator nodeCoordinator, long j, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = true;
            }
            return nodeCoordinator.m6104fromParentPosition8S9VItk(j, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fromParentPosition-8S9VItk");
    }

    /* renamed from: fromParentPosition-8S9VItk  reason: not valid java name */
    public long m6104fromParentPosition8S9VItk(long j, boolean z) {
        if (z || !isPlacedUnderMotionFrameOfReference()) {
            j = IntOffsetKt.m7253minusNvtHpc(j, m6107getPositionnOccac());
        }
        OwnedLayer ownedLayer = this.layer;
        return ownedLayer != null ? ownedLayer.m6192mapOffset8S9VItk(j, true) : j;
    }

    /* access modifiers changed from: protected */
    public final void drawBorder(Canvas canvas, Paint paint) {
        canvas.drawRect(new Rect(0.5f, 0.5f, ((float) IntSize.m7283getWidthimpl(m5884getMeasuredSizeYbymL2g())) - 0.5f, ((float) IntSize.m7282getHeightimpl(m5884getMeasuredSizeYbymL2g())) - 0.5f), paint);
    }

    public final void onLayoutNodeAttach() {
        updateLayerBlock(this.layerBlock, true);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final void onRelease() {
        this.released = true;
        this.invalidateParentLayer.invoke();
        releaseLayer();
    }

    public static /* synthetic */ void rectInParent$ui_release$default(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z, boolean z2, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                z2 = false;
            }
            nodeCoordinator.rectInParent$ui_release(mutableRect, z, z2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rectInParent");
    }

    public final void rectInParent$ui_release(MutableRect mutableRect, boolean z, boolean z2) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            if (this.isClipping) {
                if (z2) {
                    long r8 = m6106getMinimumTouchTargetSizeNHjbRc();
                    float r1 = Size.m4056getWidthimpl(r8) / 2.0f;
                    float r82 = Size.m4053getHeightimpl(r8) / 2.0f;
                    mutableRect.intersect(-r1, -r82, ((float) IntSize.m7283getWidthimpl(m6108getSizeYbymL2g())) + r1, ((float) IntSize.m7282getHeightimpl(m6108getSizeYbymL2g())) + r82);
                } else if (z) {
                    mutableRect.intersect(0.0f, 0.0f, (float) IntSize.m7283getWidthimpl(m6108getSizeYbymL2g()), (float) IntSize.m7282getHeightimpl(m6108getSizeYbymL2g()));
                }
                if (mutableRect.isEmpty()) {
                    return;
                }
            }
            ownedLayer.mapBounds(mutableRect, false);
        }
        float r83 = (float) IntOffset.m7241getXimpl(m6107getPositionnOccac());
        mutableRect.setLeft(mutableRect.getLeft() + r83);
        mutableRect.setRight(mutableRect.getRight() + r83);
        float r84 = (float) IntOffset.m7242getYimpl(m6107getPositionnOccac());
        mutableRect.setTop(mutableRect.getTop() + r84);
        mutableRect.setBottom(mutableRect.getBottom() + r84);
    }

    private final void fromParentRect(MutableRect mutableRect, boolean z) {
        float r0 = (float) IntOffset.m7241getXimpl(m6107getPositionnOccac());
        mutableRect.setLeft(mutableRect.getLeft() - r0);
        mutableRect.setRight(mutableRect.getRight() - r0);
        float r02 = (float) IntOffset.m7242getYimpl(m6107getPositionnOccac());
        mutableRect.setTop(mutableRect.getTop() - r02);
        mutableRect.setBottom(mutableRect.getBottom() - r02);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mapBounds(mutableRect, true);
            if (this.isClipping && z) {
                mutableRect.intersect(0.0f, 0.0f, (float) IntSize.m7283getWidthimpl(m6108getSizeYbymL2g()), (float) IntSize.m7282getHeightimpl(m6108getSizeYbymL2g()));
                mutableRect.isEmpty();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: withinLayerBounds-k-4lQ0M  reason: not valid java name */
    public final boolean m6129withinLayerBoundsk4lQ0M(long j) {
        if (!OffsetKt.m4004isFinitek4lQ0M(j)) {
            return false;
        }
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer == null || !this.isClipping || ownedLayer.m6191isInLayerk4lQ0M(j)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: isPointerInBounds-k-4lQ0M  reason: not valid java name */
    public final boolean m6112isPointerInBoundsk4lQ0M(long j) {
        float r0 = Offset.m3987getXimpl(j);
        float r3 = Offset.m3988getYimpl(j);
        return r0 >= 0.0f && r3 >= 0.0f && r0 < ((float) getMeasuredWidth()) && r3 < ((float) getMeasuredHeight());
    }

    public void invalidateLayer() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            nodeCoordinator.invalidateLayer();
        }
    }

    public void onLayoutModifierNodeChanged() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final NodeCoordinator findCommonAncestor$ui_release(NodeCoordinator nodeCoordinator) {
        LayoutNode layoutNode2 = nodeCoordinator.getLayoutNode();
        LayoutNode layoutNode3 = getLayoutNode();
        if (layoutNode2 == layoutNode3) {
            Modifier.Node tail = nodeCoordinator.getTail();
            DelegatableNode tail2 = getTail();
            int r2 = NodeKind.m6139constructorimpl(2);
            if (!tail2.getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitLocalAncestors called on an unattached node");
            }
            for (Modifier.Node parent$ui_release = tail2.getNode().getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
                if ((parent$ui_release.getKindSet$ui_release() & r2) != 0 && parent$ui_release == tail) {
                    return nodeCoordinator;
                }
            }
        } else {
            while (layoutNode2.getDepth$ui_release() > layoutNode3.getDepth$ui_release()) {
                layoutNode2 = layoutNode2.getParent$ui_release();
                Intrinsics.checkNotNull(layoutNode2);
            }
            while (layoutNode3.getDepth$ui_release() > layoutNode2.getDepth$ui_release()) {
                layoutNode3 = layoutNode3.getParent$ui_release();
                Intrinsics.checkNotNull(layoutNode3);
            }
            while (layoutNode2 != layoutNode3) {
                layoutNode2 = layoutNode2.getParent$ui_release();
                layoutNode3 = layoutNode3.getParent$ui_release();
                if (layoutNode2 != null) {
                    if (layoutNode3 == null) {
                    }
                }
                throw new IllegalArgumentException("layouts are not part of the same hierarchy");
            }
            if (layoutNode3 != getLayoutNode()) {
                if (layoutNode2 != nodeCoordinator.getLayoutNode()) {
                    return layoutNode2.getInnerCoordinator$ui_release();
                }
                return nodeCoordinator;
            }
        }
        return this;
    }

    /* renamed from: offsetFromEdge-MK-Hz9U  reason: not valid java name */
    private final long m6096offsetFromEdgeMKHz9U(long j) {
        float f;
        float f2;
        float r0 = Offset.m3987getXimpl(j);
        if (r0 < 0.0f) {
            f = -r0;
        } else {
            f = r0 - ((float) getMeasuredWidth());
        }
        float max = Math.max(0.0f, f);
        float r4 = Offset.m3988getYimpl(j);
        if (r4 < 0.0f) {
            f2 = -r4;
        } else {
            f2 = r4 - ((float) getMeasuredHeight());
        }
        return OffsetKt.Offset(max, Math.max(0.0f, f2));
    }

    /* access modifiers changed from: protected */
    /* renamed from: calculateMinimumTouchTargetPadding-E7KxVPU  reason: not valid java name */
    public final long m6102calculateMinimumTouchTargetPaddingE7KxVPU(long j) {
        return SizeKt.Size(Math.max(0.0f, (Size.m4056getWidthimpl(j) - ((float) getMeasuredWidth())) / 2.0f), Math.max(0.0f, (Size.m4053getHeightimpl(j) - ((float) getMeasuredHeight())) / 2.0f));
    }

    /* access modifiers changed from: protected */
    /* renamed from: distanceInMinimumTouchTarget-tz77jQw  reason: not valid java name */
    public final float m6103distanceInMinimumTouchTargettz77jQw(long j, long j2) {
        if (((float) getMeasuredWidth()) >= Size.m4056getWidthimpl(j2) && ((float) getMeasuredHeight()) >= Size.m4053getHeightimpl(j2)) {
            return Float.POSITIVE_INFINITY;
        }
        long r6 = m6102calculateMinimumTouchTargetPaddingE7KxVPU(j2);
        float r0 = Size.m4056getWidthimpl(r6);
        float r62 = Size.m4053getHeightimpl(r6);
        long r4 = m6096offsetFromEdgeMKHz9U(j);
        if ((r0 > 0.0f || r62 > 0.0f) && Offset.m3987getXimpl(r4) <= r0 && Offset.m3988getYimpl(r4) <= r62) {
            return Offset.m3986getDistanceSquaredimpl(r4);
        }
        return Float.POSITIVE_INFINITY;
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u00020\u0016X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0017\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator$Companion;", "", "()V", "ExpectAttachedLayoutCoordinates", "", "PointerInputSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "getPointerInputSource", "()Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "SemanticsSource", "getSemanticsSource", "UnmeasuredError", "graphicsLayerScope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "onCommitAffectingLayer", "Lkotlin/Function1;", "Landroidx/compose/ui/node/NodeCoordinator;", "", "onCommitAffectingLayerParams", "tmpLayerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NodeCoordinator.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HitTestSource getPointerInputSource() {
            return NodeCoordinator.PointerInputSource;
        }

        public final HitTestSource getSemanticsSource() {
            return NodeCoordinator.SemanticsSource;
        }
    }

    public final void onMeasured() {
        Modifier.Node node;
        if (m6093hasNodeH91voCI(NodeKind.m6139constructorimpl(128))) {
            Snapshot.Companion companion = Snapshot.Companion;
            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                int r0 = NodeKind.m6139constructorimpl(128);
                boolean r6 = NodeKindKt.m6148getIncludeSelfInTraversalH91voCI(r0);
                if (r6) {
                    node = getTail();
                } else {
                    node = getTail().getParent$ui_release();
                    if (node == null) {
                        Unit unit = Unit.INSTANCE;
                    }
                }
                Modifier.Node access$headNode = headNode(r6);
                while (access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & r0) != 0) {
                    if ((access$headNode.getKindSet$ui_release() & r0) != 0) {
                        MutableVector mutableVector = null;
                        Modifier.Node node2 = access$headNode;
                        while (node2 != null) {
                            if (node2 instanceof LayoutAwareModifierNode) {
                                ((LayoutAwareModifierNode) node2).m5981onRemeasuredozmzZPI(m5884getMeasuredSizeYbymL2g());
                            } else if ((node2.getKindSet$ui_release() & r0) != 0 && (node2 instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                    if ((delegate$ui_release.getKindSet$ui_release() & r0) != 0) {
                                        i++;
                                        if (i == 1) {
                                            node2 = delegate$ui_release;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node2 != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(node2);
                                                }
                                                node2 = null;
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
                            node2 = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    if (access$headNode == node) {
                        break;
                    }
                    access$headNode = access$headNode.getChild$ui_release();
                }
                Unit unit2 = Unit.INSTANCE;
            } finally {
                companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void drawContainedDrawModifiers(Canvas canvas, GraphicsLayer graphicsLayer) {
        Modifier.Node r6 = m6109headH91voCI(NodeKind.m6139constructorimpl(4));
        if (r6 == null) {
            performDraw(canvas, graphicsLayer);
            return;
        }
        getLayoutNode().getMDrawScope$ui_release().m6005draweZhPAX0$ui_release(canvas, IntSizeKt.m7295toSizeozmzZPI(m6108getSizeYbymL2g()), this, r6, graphicsLayer);
    }

    public final void onPlaced() {
        int r0 = NodeKind.m6139constructorimpl(128);
        boolean r1 = NodeKindKt.m6148getIncludeSelfInTraversalH91voCI(r0);
        Modifier.Node tail = getTail();
        if (r1 || (tail = tail.getParent$ui_release()) != null) {
            Modifier.Node access$headNode = headNode(r1);
            while (access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & r0) != 0) {
                if ((access$headNode.getKindSet$ui_release() & r0) != 0) {
                    Modifier.Node node = access$headNode;
                    MutableVector mutableVector = null;
                    while (node != null) {
                        if (node instanceof LayoutAwareModifierNode) {
                            ((LayoutAwareModifierNode) node).onPlaced(this);
                        } else if ((node.getKindSet$ui_release() & r0) != 0 && (node instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                if ((delegate$ui_release.getKindSet$ui_release() & r0) != 0) {
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
                if (access$headNode != tail) {
                    access$headNode = access$headNode.getChild$ui_release();
                } else {
                    return;
                }
            }
        }
    }

    public final boolean shouldSharePointerInputWithSiblings() {
        Modifier.Node headNode = headNode(NodeKindKt.m6148getIncludeSelfInTraversalH91voCI(NodeKind.m6139constructorimpl(16)));
        if (headNode != null && headNode.isAttached()) {
            DelegatableNode delegatableNode = headNode;
            int r3 = NodeKind.m6139constructorimpl(16);
            if (!delegatableNode.getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
            }
            Modifier.Node node = delegatableNode.getNode();
            if ((node.getAggregateChildKindSet$ui_release() & r3) != 0) {
                while (node != null) {
                    if ((node.getKindSet$ui_release() & r3) != 0) {
                        Modifier.Node node2 = node;
                        MutableVector mutableVector = null;
                        while (node2 != null) {
                            if (node2 instanceof PointerInputModifierNode) {
                                if (((PointerInputModifierNode) node2).sharePointerInputWithSiblings()) {
                                    return true;
                                }
                            } else if ((node2.getKindSet$ui_release() & r3) != 0 && (node2 instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                    if ((delegate$ui_release.getKindSet$ui_release() & r3) != 0) {
                                        i++;
                                        if (i == 1) {
                                            node2 = delegate$ui_release;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node2 != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(node2);
                                                }
                                                node2 = null;
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
                            node2 = DelegatableNodeKt.pop(mutableVector);
                        }
                        continue;
                    }
                    node = node.getChild$ui_release();
                }
            }
        }
        return false;
    }
}
