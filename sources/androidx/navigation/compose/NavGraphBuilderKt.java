package androidx.navigation.compose;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.SizeTransform;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDeepLink;
import androidx.navigation.NavGraph;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavType;
import androidx.navigation.compose.ComposeNavGraphNavigator;
import androidx.navigation.compose.ComposeNavigator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001aR\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u000e\u001a\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062(\b\u0002\u0010\u000f\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u000b¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u00132(\b\u0002\u0010\u0014\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u000b¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u00132(\b\u0002\u0010\u0016\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u000b¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u00132(\b\u0002\u0010\u0017\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u000b¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u00132\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\r¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u001a\u001a­\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062(\b\u0002\u0010\u000f\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u000b¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u00132(\b\u0002\u0010\u0014\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u000b¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u00132(\b\u0002\u0010\u0016\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u000b¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u00132(\b\u0002\u0010\u0017\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u000b¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u00132(\b\u0002\u0010\u001b\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u000b¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u00132\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\r¢\u0006\u0002\b\u0013¢\u0006\u0002\u0010\u001d\u001aÅ\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u001e\u0018\u0001*\u00020\u001f*\u00020\u00022\u001d\b\u0002\u0010 \u001a\u0017\u0012\u0004\u0012\u00020\"\u0012\r\u0012\u000b\u0012\u0002\b\u00030#¢\u0006\u0002\b\u00120!2\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062(\b\n\u0010\u000f\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u000b\u0012\t\u0018\u00010\u0011¢\u0006\u0002\b\u0012\u0018\u00010\u000b¢\u0006\u0002\b\u00132(\b\n\u0010\u0014\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u000b\u0012\t\u0018\u00010\u0015¢\u0006\u0002\b\u0012\u0018\u00010\u000b¢\u0006\u0002\b\u00132(\b\n\u0010\u0016\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u000b\u0012\t\u0018\u00010\u0011¢\u0006\u0002\b\u0012\u0018\u00010\u000b¢\u0006\u0002\b\u00132(\b\n\u0010\u0017\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u000b\u0012\t\u0018\u00010\u0015¢\u0006\u0002\b\u0012\u0018\u00010\u000b¢\u0006\u0002\b\u00132(\b\n\u0010\u001b\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u000b\u0012\t\u0018\u00010\u001c¢\u0006\u0002\b\u0012\u0018\u00010\u000b¢\u0006\u0002\b\u00132$\b\b\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\r¢\u0006\u0002\b\u0013H\b¢\u0006\u0002\u0010$\u001aZ\u0010%\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\b\b\u0002\u0010&\u001a\u00020'2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\r¢\u0006\u0002\u0010(\u001ar\u0010%\u001a\u00020\u0001\"\n\b\u0000\u0010\u001e\u0018\u0001*\u00020\u001f*\u00020\u00022\u001d\b\u0002\u0010 \u001a\u0017\u0012\u0004\u0012\u00020\"\u0012\r\u0012\u000b\u0012\u0002\b\u00030#¢\u0006\u0002\b\u00120!2\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\b\b\u0002\u0010&\u001a\u00020'2\u0019\b\b\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\rH\b¢\u0006\u0002\u0010)\u001a½\u0002\u0010*\u001a\u00020\u0001\"\n\b\u0000\u0010\u001e\u0018\u0001*\u00020\u001f*\u00020\u00022\u0006\u0010+\u001a\u00020\u001f2\u001d\b\u0002\u0010 \u001a\u0017\u0012\u0004\u0012\u00020\"\u0012\r\u0012\u000b\u0012\u0002\b\u00030#¢\u0006\u0002\b\u00120!2\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062(\b\n\u0010\u000f\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u000b\u0012\t\u0018\u00010\u0011¢\u0006\u0002\b\u0012\u0018\u00010\u000b¢\u0006\u0002\b\u00132(\b\n\u0010\u0014\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u000b\u0012\t\u0018\u00010\u0015¢\u0006\u0002\b\u0012\u0018\u00010\u000b¢\u0006\u0002\b\u00132(\b\n\u0010\u0016\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u000b\u0012\t\u0018\u00010\u0011¢\u0006\u0002\b\u0012\u0018\u00010\u000b¢\u0006\u0002\b\u00132(\b\n\u0010\u0017\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u000b\u0012\t\u0018\u00010\u0015¢\u0006\u0002\b\u0012\u0018\u00010\u000b¢\u0006\u0002\b\u00132(\b\n\u0010\u001b\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u000b\u0012\t\u0018\u00010\u001c¢\u0006\u0002\b\u0012\u0018\u00010\u000b¢\u0006\u0002\b\u00132\u0019\b\b\u0010,\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0013H\b\u001aº\u0002\u0010*\u001a\u00020\u0001*\u00020\u00022\u0006\u0010+\u001a\u00020\u001f2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030-2\u001d\b\u0002\u0010 \u001a\u0017\u0012\u0004\u0012\u00020\"\u0012\r\u0012\u000b\u0012\u0002\b\u00030#¢\u0006\u0002\b\u00120!2\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062(\b\u0002\u0010\u000f\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u000b\u0012\t\u0018\u00010\u0011¢\u0006\u0002\b\u0012\u0018\u00010\u000b¢\u0006\u0002\b\u00132(\b\u0002\u0010\u0014\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u000b\u0012\t\u0018\u00010\u0015¢\u0006\u0002\b\u0012\u0018\u00010\u000b¢\u0006\u0002\b\u00132(\b\u0002\u0010\u0016\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u000b\u0012\t\u0018\u00010\u0011¢\u0006\u0002\b\u0012\u0018\u00010\u000b¢\u0006\u0002\b\u00132(\b\u0002\u0010\u0017\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u000b\u0012\t\u0018\u00010\u0015¢\u0006\u0002\b\u0012\u0018\u00010\u000b¢\u0006\u0002\b\u00132(\b\u0002\u0010\u001b\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u000b\u0012\t\u0018\u00010\u001c¢\u0006\u0002\b\u0012\u0018\u00010\u000b¢\u0006\u0002\b\u00132\u0017\u0010,\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0013H\u0007\u001aé\u0001\u0010*\u001a\u00020\u0001*\u00020\u00022\u0006\u0010+\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062#\b\u0002\u0010\u000f\u001a\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u000b¢\u0006\u0002\b\u00132#\b\u0002\u0010\u0014\u001a\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u000b¢\u0006\u0002\b\u00132#\b\u0002\u0010\u0016\u001a\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u000b¢\u0006\u0002\b\u00132#\b\u0002\u0010\u0017\u001a\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u000b¢\u0006\u0002\b\u00132\u0017\u0010,\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0013H\u0007\u001a¥\u0002\u0010*\u001a\u00020\u0001*\u00020\u00022\u0006\u0010+\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062(\b\u0002\u0010\u000f\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u000b¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u00132(\b\u0002\u0010\u0014\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u000b¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u00132(\b\u0002\u0010\u0016\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u000b¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u00132(\b\u0002\u0010\u0017\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u000b¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u00132(\b\u0002\u0010\u001b\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u000b¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u00132\u0017\u0010,\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0013\u001aU\u0010*\u001a\u00020\u0001*\u00020\u00022\u0006\u0010+\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u0017\u0010,\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0013H\u0007\u001aÁ\u0002\u0010*\u001a\u00020\u0001\"\n\b\u0000\u0010\u001e\u0018\u0001*\u00020\u001f*\u00020\u00022\n\u0010+\u001a\u0006\u0012\u0002\b\u00030-2\u001d\b\u0002\u0010 \u001a\u0017\u0012\u0004\u0012\u00020\"\u0012\r\u0012\u000b\u0012\u0002\b\u00030#¢\u0006\u0002\b\u00120!2\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062(\b\n\u0010\u000f\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u000b\u0012\t\u0018\u00010\u0011¢\u0006\u0002\b\u0012\u0018\u00010\u000b¢\u0006\u0002\b\u00132(\b\n\u0010\u0014\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u000b\u0012\t\u0018\u00010\u0015¢\u0006\u0002\b\u0012\u0018\u00010\u000b¢\u0006\u0002\b\u00132(\b\n\u0010\u0016\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u000b\u0012\t\u0018\u00010\u0011¢\u0006\u0002\b\u0012\u0018\u00010\u000b¢\u0006\u0002\b\u00132(\b\n\u0010\u0017\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u000b\u0012\t\u0018\u00010\u0015¢\u0006\u0002\b\u0012\u0018\u00010\u000b¢\u0006\u0002\b\u00132(\b\n\u0010\u001b\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u000b\u0012\t\u0018\u00010\u001c¢\u0006\u0002\b\u0012\u0018\u00010\u000b¢\u0006\u0002\b\u00132\u0019\b\b\u0010,\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0013H\b\u001a¾\u0002\u0010*\u001a\u00020\u0001*\u00020\u00022\n\u0010+\u001a\u0006\u0012\u0002\b\u00030-2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030-2\u001d\b\u0002\u0010 \u001a\u0017\u0012\u0004\u0012\u00020\"\u0012\r\u0012\u000b\u0012\u0002\b\u00030#¢\u0006\u0002\b\u00120!2\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062(\b\u0002\u0010\u000f\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u000b\u0012\t\u0018\u00010\u0011¢\u0006\u0002\b\u0012\u0018\u00010\u000b¢\u0006\u0002\b\u00132(\b\u0002\u0010\u0014\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u000b\u0012\t\u0018\u00010\u0015¢\u0006\u0002\b\u0012\u0018\u00010\u000b¢\u0006\u0002\b\u00132(\b\u0002\u0010\u0016\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u000b\u0012\t\u0018\u00010\u0011¢\u0006\u0002\b\u0012\u0018\u00010\u000b¢\u0006\u0002\b\u00132(\b\u0002\u0010\u0017\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u000b\u0012\t\u0018\u00010\u0015¢\u0006\u0002\b\u0012\u0018\u00010\u000b¢\u0006\u0002\b\u00132(\b\u0002\u0010\u001b\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0010\u0012\u000b\u0012\t\u0018\u00010\u001c¢\u0006\u0002\b\u0012\u0018\u00010\u000b¢\u0006\u0002\b\u00132\u0017\u0010,\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0013H\u0007¨\u0006."}, d2 = {"composable", "", "Landroidx/navigation/NavGraphBuilder;", "route", "", "arguments", "", "Landroidx/navigation/NamedNavArgument;", "deepLinks", "Landroidx/navigation/NavDeepLink;", "content", "Lkotlin/Function1;", "Landroidx/navigation/NavBackStackEntry;", "Landroidx/compose/runtime/Composable;", "(Landroidx/navigation/NavGraphBuilder;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/functions/Function3;)V", "enterTransition", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/compose/animation/EnterTransition;", "Lkotlin/jvm/JvmSuppressWildcards;", "Lkotlin/ExtensionFunctionType;", "exitTransition", "Landroidx/compose/animation/ExitTransition;", "popEnterTransition", "popExitTransition", "Lkotlin/Function2;", "Landroidx/compose/animation/AnimatedContentScope;", "(Landroidx/navigation/NavGraphBuilder;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "sizeTransform", "Landroidx/compose/animation/SizeTransform;", "(Landroidx/navigation/NavGraphBuilder;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "T", "", "typeMap", "", "Lkotlin/reflect/KType;", "Landroidx/navigation/NavType;", "(Landroidx/navigation/NavGraphBuilder;Ljava/util/Map;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "dialog", "dialogProperties", "Landroidx/compose/ui/window/DialogProperties;", "(Landroidx/navigation/NavGraphBuilder;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function3;)V", "(Landroidx/navigation/NavGraphBuilder;Ljava/util/Map;Ljava/util/List;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function3;)V", "navigation", "startDestination", "builder", "Lkotlin/reflect/KClass;", "navigation-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavGraphBuilder.kt */
public final class NavGraphBuilderKt {
    public static /* synthetic */ void composable$default(NavGraphBuilder navGraphBuilder, String str, List list, List list2, Function3 function3, int i, Object obj) {
        if ((i & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i & 4) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        composable(navGraphBuilder, str, list, list2, function3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of composable builder that supports AnimatedContent")
    public static final /* synthetic */ void composable(NavGraphBuilder navGraphBuilder, String str, List list, List list2, Function3 function3) {
        ComposeNavigator.Destination destination = new ComposeNavigator.Destination((ComposeNavigator) navGraphBuilder.getProvider().getNavigator(ComposeNavigator.class), (Function4<? super AnimatedContentScope, NavBackStackEntry, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambdaInstance(484185514, true, new NavGraphBuilderKt$composable$1(function3)));
        destination.setRoute(str);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            NamedNavArgument namedNavArgument = (NamedNavArgument) it.next();
            destination.addArgument(namedNavArgument.component1(), namedNavArgument.component2());
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            destination.addDeepLink((NavDeepLink) it2.next());
        }
        navGraphBuilder.addDestination(destination);
    }

    public static /* synthetic */ void composable$default(NavGraphBuilder navGraphBuilder, String str, List list, List list2, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        List list3 = list;
        if ((i & 4) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        List list4 = list2;
        Function1 function15 = (i & 8) != 0 ? null : function1;
        Function1 function16 = (i & 16) != 0 ? null : function12;
        composable(navGraphBuilder, str, list3, list4, function15, function16, (i & 32) != 0 ? function15 : function13, (i & 64) != 0 ? function16 : function14, function4);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of composable builder that supports sizeTransform")
    public static final /* synthetic */ void composable(NavGraphBuilder navGraphBuilder, String str, List list, List list2, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function4 function4) {
        ComposeNavigatorDestinationBuilder composeNavigatorDestinationBuilder = new ComposeNavigatorDestinationBuilder((ComposeNavigator) navGraphBuilder.getProvider().getNavigator(ComposeNavigator.class), str, function4);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            NamedNavArgument namedNavArgument = (NamedNavArgument) it.next();
            composeNavigatorDestinationBuilder.argument(namedNavArgument.component1(), namedNavArgument.component2());
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            composeNavigatorDestinationBuilder.deepLink((NavDeepLink) it2.next());
        }
        composeNavigatorDestinationBuilder.setEnterTransition(function1);
        composeNavigatorDestinationBuilder.setExitTransition(function12);
        composeNavigatorDestinationBuilder.setPopEnterTransition(function13);
        composeNavigatorDestinationBuilder.setPopExitTransition(function14);
        navGraphBuilder.destination(composeNavigatorDestinationBuilder);
    }

    public static /* synthetic */ void composable$default(NavGraphBuilder navGraphBuilder, String str, List list, List list2, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function4 function4, int i, Object obj) {
        int i2 = i;
        if ((i2 & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        List list3 = list;
        if ((i2 & 4) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        List list4 = list2;
        Function1 function16 = (i2 & 8) != 0 ? null : function1;
        Function1 function17 = (i2 & 16) != 0 ? null : function12;
        composable(navGraphBuilder, str, list3, list4, function16, function17, (i2 & 32) != 0 ? function16 : function13, (i2 & 64) != 0 ? function17 : function14, (i2 & 128) != 0 ? null : function15, function4);
    }

    public static final void composable(NavGraphBuilder navGraphBuilder, String str, List<NamedNavArgument> list, List<NavDeepLink> list2, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function12, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function13, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function14, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function15, Function4<? super AnimatedContentScope, ? super NavBackStackEntry, ? super Composer, ? super Integer, Unit> function4) {
        ComposeNavigatorDestinationBuilder composeNavigatorDestinationBuilder = new ComposeNavigatorDestinationBuilder((ComposeNavigator) navGraphBuilder.getProvider().getNavigator(ComposeNavigator.class), str, function4);
        for (NamedNavArgument namedNavArgument : list) {
            composeNavigatorDestinationBuilder.argument(namedNavArgument.component1(), namedNavArgument.component2());
        }
        for (NavDeepLink deepLink : list2) {
            composeNavigatorDestinationBuilder.deepLink(deepLink);
        }
        composeNavigatorDestinationBuilder.setEnterTransition(function1);
        composeNavigatorDestinationBuilder.setExitTransition(function12);
        composeNavigatorDestinationBuilder.setPopEnterTransition(function13);
        composeNavigatorDestinationBuilder.setPopExitTransition(function14);
        composeNavigatorDestinationBuilder.setSizeTransform(function15);
        navGraphBuilder.destination(composeNavigatorDestinationBuilder);
    }

    public static /* synthetic */ void composable$default(NavGraphBuilder navGraphBuilder, Map map, List<NavDeepLink> list, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function4 function4, int i, Object obj) {
        if ((i & 1) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((i & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        if ((i & 8) != 0) {
            function12 = null;
        }
        if ((i & 16) != 0) {
            function13 = function1;
        }
        if ((i & 32) != 0) {
            function14 = function12;
        }
        if ((i & 64) != 0) {
            function15 = null;
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        ComposeNavigatorDestinationBuilder composeNavigatorDestinationBuilder = new ComposeNavigatorDestinationBuilder((ComposeNavigator) navGraphBuilder.getProvider().getNavigator(ComposeNavigator.class), Reflection.getOrCreateKotlinClass(Object.class), map, function4);
        ComposeNavigatorDestinationBuilder composeNavigatorDestinationBuilder2 = composeNavigatorDestinationBuilder;
        for (NavDeepLink deepLink : list) {
            composeNavigatorDestinationBuilder.deepLink(deepLink);
        }
        composeNavigatorDestinationBuilder.setEnterTransition(function1);
        composeNavigatorDestinationBuilder.setExitTransition(function12);
        composeNavigatorDestinationBuilder.setPopEnterTransition(function13);
        composeNavigatorDestinationBuilder.setPopExitTransition(function14);
        composeNavigatorDestinationBuilder.setSizeTransform(function15);
        navGraphBuilder.destination(composeNavigatorDestinationBuilder);
    }

    public static final /* synthetic */ <T> void composable(NavGraphBuilder navGraphBuilder, Map<KType, NavType<?>> map, List<NavDeepLink> list, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function12, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function13, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function14, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function15, Function4<? super AnimatedContentScope, ? super NavBackStackEntry, ? super Composer, ? super Integer, Unit> function4) {
        Intrinsics.reifiedOperationMarker(4, "T");
        ComposeNavigatorDestinationBuilder composeNavigatorDestinationBuilder = new ComposeNavigatorDestinationBuilder((ComposeNavigator) navGraphBuilder.getProvider().getNavigator(ComposeNavigator.class), Reflection.getOrCreateKotlinClass(Object.class), map, function4);
        ComposeNavigatorDestinationBuilder composeNavigatorDestinationBuilder2 = composeNavigatorDestinationBuilder;
        for (NavDeepLink deepLink : list) {
            composeNavigatorDestinationBuilder.deepLink(deepLink);
        }
        composeNavigatorDestinationBuilder.setEnterTransition(function1);
        composeNavigatorDestinationBuilder.setExitTransition(function12);
        composeNavigatorDestinationBuilder.setPopEnterTransition(function13);
        composeNavigatorDestinationBuilder.setPopExitTransition(function14);
        composeNavigatorDestinationBuilder.setSizeTransform(function15);
        navGraphBuilder.destination(composeNavigatorDestinationBuilder);
    }

    public static /* synthetic */ void navigation$default(NavGraphBuilder navGraphBuilder, String str, String str2, List list, List list2, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        List list3 = list;
        if ((i & 8) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        navigation(navGraphBuilder, str, str2, (List<NamedNavArgument>) list3, (List<NavDeepLink>) list2, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) null, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) null, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) null, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) null, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform>) null, (Function1<? super NavGraphBuilder, Unit>) function1);
    }

    public static /* synthetic */ void navigation$default(NavGraphBuilder navGraphBuilder, String str, String str2, List list, List list2, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, int i, Object obj) {
        int i2 = i;
        if ((i2 & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        List list3 = list;
        List emptyList = (i2 & 8) != 0 ? CollectionsKt.emptyList() : list2;
        Function1 function16 = (i2 & 16) != 0 ? null : function1;
        Function1 function17 = (i2 & 32) != 0 ? null : function12;
        navigation(navGraphBuilder, str, str2, (List<NamedNavArgument>) list3, (List<NavDeepLink>) emptyList, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function16, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function17, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) (i2 & 64) != 0 ? function16 : function13, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) (i2 & 128) != 0 ? function17 : function14, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform>) null, (Function1<? super NavGraphBuilder, Unit>) function15);
    }

    public static /* synthetic */ void navigation$default(NavGraphBuilder navGraphBuilder, String str, String str2, List list, List list2, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, int i, Object obj) {
        Function1 function17;
        Function1 function18;
        String str3;
        String str4;
        NavGraphBuilder navGraphBuilder2;
        int i2 = i;
        List emptyList = (i2 & 4) != 0 ? CollectionsKt.emptyList() : list;
        List emptyList2 = (i2 & 8) != 0 ? CollectionsKt.emptyList() : list2;
        Function1 function19 = (i2 & 16) != 0 ? null : function1;
        Function1 function110 = (i2 & 32) != 0 ? null : function12;
        Function1 function111 = (i2 & 64) != 0 ? function19 : function13;
        Function1 function112 = (i2 & 128) != 0 ? function110 : function14;
        if ((i2 & 256) != 0) {
            function18 = null;
            str4 = str;
            str3 = str2;
            function17 = function16;
            navGraphBuilder2 = navGraphBuilder;
        } else {
            function18 = function15;
            navGraphBuilder2 = navGraphBuilder;
            str4 = str;
            str3 = str2;
            function17 = function16;
        }
        navigation(navGraphBuilder2, str4, str3, (List<NamedNavArgument>) emptyList, (List<NavDeepLink>) emptyList2, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function19, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function110, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function111, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function112, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform>) function18, (Function1<? super NavGraphBuilder, Unit>) function17);
    }

    public static final void navigation(NavGraphBuilder navGraphBuilder, String str, String str2, List<NamedNavArgument> list, List<NavDeepLink> list2, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function12, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function13, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function14, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function15, Function1<? super NavGraphBuilder, Unit> function16) {
        NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(navGraphBuilder.getProvider(), str, str2);
        function16.invoke(navGraphBuilder2);
        NavGraph build = navGraphBuilder2.build();
        for (NamedNavArgument namedNavArgument : list) {
            build.addArgument(namedNavArgument.component1(), namedNavArgument.component2());
        }
        for (NavDeepLink addDeepLink : list2) {
            build.addDeepLink(addDeepLink);
        }
        if (build instanceof ComposeNavGraphNavigator.ComposeNavGraph) {
            ComposeNavGraphNavigator.ComposeNavGraph composeNavGraph = (ComposeNavGraphNavigator.ComposeNavGraph) build;
            composeNavGraph.setEnterTransition$navigation_compose_release(function1);
            composeNavGraph.setExitTransition$navigation_compose_release(function12);
            composeNavGraph.setPopEnterTransition$navigation_compose_release(function13);
            composeNavGraph.setPopExitTransition$navigation_compose_release(function14);
            composeNavGraph.setSizeTransform$navigation_compose_release(function15);
        }
        navGraphBuilder.addDestination(build);
    }

    public static /* synthetic */ void navigation$default(NavGraphBuilder navGraphBuilder, KClass kClass, Map map, List list, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, int i, Object obj) {
        List list2;
        int i2 = i;
        if ((i2 & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        Map map2 = map;
        if ((i2 & 4) != 0) {
            list2 = CollectionsKt.emptyList();
        } else {
            list2 = list;
        }
        Function1 function17 = (i2 & 8) != 0 ? null : function1;
        Function1 function18 = (i2 & 16) != 0 ? null : function12;
        Function1 function19 = (i2 & 32) != 0 ? function17 : function13;
        Function1 function110 = (i2 & 64) != 0 ? function18 : function14;
        Function1 function111 = (i2 & 128) != 0 ? null : function15;
        Intrinsics.reifiedOperationMarker(4, "T");
        navigation(navGraphBuilder, (KClass<?>) kClass, (KClass<?>) Reflection.getOrCreateKotlinClass(Object.class), (Map<KType, NavType<?>>) map2, (List<NavDeepLink>) list2, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function17, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function18, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function19, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function110, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform>) function111, (Function1<? super NavGraphBuilder, Unit>) function16);
    }

    public static final /* synthetic */ <T> void navigation(NavGraphBuilder navGraphBuilder, KClass<?> kClass, Map<KType, NavType<?>> map, List<NavDeepLink> list, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function12, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function13, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function14, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function15, Function1<? super NavGraphBuilder, Unit> function16) {
        Intrinsics.reifiedOperationMarker(4, "T");
        navigation(navGraphBuilder, kClass, (KClass<?>) Reflection.getOrCreateKotlinClass(Object.class), map, list, function1, function12, function13, function14, function15, function16);
    }

    public static /* synthetic */ void navigation$default(NavGraphBuilder navGraphBuilder, KClass kClass, KClass kClass2, Map map, List list, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, int i, Object obj) {
        Function1 function17;
        Function1 function18;
        KClass kClass3;
        KClass kClass4;
        NavGraphBuilder navGraphBuilder2;
        int i2 = i;
        Map emptyMap = (i2 & 4) != 0 ? MapsKt.emptyMap() : map;
        List emptyList = (i2 & 8) != 0 ? CollectionsKt.emptyList() : list;
        Function1 function19 = (i2 & 16) != 0 ? null : function1;
        Function1 function110 = (i2 & 32) != 0 ? null : function12;
        Function1 function111 = (i2 & 64) != 0 ? function19 : function13;
        Function1 function112 = (i2 & 128) != 0 ? function110 : function14;
        if ((i2 & 256) != 0) {
            function18 = null;
            kClass4 = kClass;
            kClass3 = kClass2;
            function17 = function16;
            navGraphBuilder2 = navGraphBuilder;
        } else {
            function18 = function15;
            navGraphBuilder2 = navGraphBuilder;
            kClass4 = kClass;
            kClass3 = kClass2;
            function17 = function16;
        }
        navigation(navGraphBuilder2, (KClass<?>) kClass4, (KClass<?>) kClass3, (Map<KType, NavType<?>>) emptyMap, (List<NavDeepLink>) emptyList, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function19, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function110, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function111, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function112, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform>) function18, (Function1<? super NavGraphBuilder, Unit>) function17);
    }

    public static final void navigation(NavGraphBuilder navGraphBuilder, KClass<?> kClass, KClass<?> kClass2, Map<KType, NavType<?>> map, List<NavDeepLink> list, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function12, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function13, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function14, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function15, Function1<? super NavGraphBuilder, Unit> function16) {
        NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(navGraphBuilder.getProvider(), kClass, kClass2, map);
        function16.invoke(navGraphBuilder2);
        NavGraph build = navGraphBuilder2.build();
        for (NavDeepLink addDeepLink : list) {
            build.addDeepLink(addDeepLink);
        }
        if (build instanceof ComposeNavGraphNavigator.ComposeNavGraph) {
            ComposeNavGraphNavigator.ComposeNavGraph composeNavGraph = (ComposeNavGraphNavigator.ComposeNavGraph) build;
            composeNavGraph.setEnterTransition$navigation_compose_release(function1);
            composeNavGraph.setExitTransition$navigation_compose_release(function12);
            composeNavGraph.setPopEnterTransition$navigation_compose_release(function13);
            composeNavGraph.setPopExitTransition$navigation_compose_release(function14);
            composeNavGraph.setSizeTransform$navigation_compose_release(function15);
        }
        navGraphBuilder.addDestination(build);
    }

    public static /* synthetic */ void navigation$default(NavGraphBuilder navGraphBuilder, Object obj, Map map, List list, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, int i, Object obj2) {
        List list2;
        int i2 = i;
        if ((i2 & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        Map map2 = map;
        if ((i2 & 4) != 0) {
            list2 = CollectionsKt.emptyList();
        } else {
            list2 = list;
        }
        Function1 function17 = (i2 & 8) != 0 ? null : function1;
        Function1 function18 = (i2 & 16) != 0 ? null : function12;
        Function1 function19 = (i2 & 32) != 0 ? function17 : function13;
        Function1 function110 = (i2 & 64) != 0 ? function18 : function14;
        Function1 function111 = (i2 & 128) != 0 ? null : function15;
        Intrinsics.reifiedOperationMarker(4, "T");
        navigation(navGraphBuilder, obj, (KClass<?>) Reflection.getOrCreateKotlinClass(Object.class), (Map<KType, NavType<?>>) map2, (List<NavDeepLink>) list2, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function17, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function18, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function19, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function110, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform>) function111, (Function1<? super NavGraphBuilder, Unit>) function16);
    }

    public static final /* synthetic */ <T> void navigation(NavGraphBuilder navGraphBuilder, Object obj, Map<KType, NavType<?>> map, List<NavDeepLink> list, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function12, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function13, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function14, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function15, Function1<? super NavGraphBuilder, Unit> function16) {
        Intrinsics.reifiedOperationMarker(4, "T");
        navigation(navGraphBuilder, obj, (KClass<?>) Reflection.getOrCreateKotlinClass(Object.class), map, list, function1, function12, function13, function14, function15, function16);
    }

    public static /* synthetic */ void navigation$default(NavGraphBuilder navGraphBuilder, Object obj, KClass kClass, Map map, List list, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, int i, Object obj2) {
        Function1 function17;
        Function1 function18;
        KClass kClass2;
        Object obj3;
        NavGraphBuilder navGraphBuilder2;
        int i2 = i;
        Map emptyMap = (i2 & 4) != 0 ? MapsKt.emptyMap() : map;
        List emptyList = (i2 & 8) != 0 ? CollectionsKt.emptyList() : list;
        Function1 function19 = (i2 & 16) != 0 ? null : function1;
        Function1 function110 = (i2 & 32) != 0 ? null : function12;
        Function1 function111 = (i2 & 64) != 0 ? function19 : function13;
        Function1 function112 = (i2 & 128) != 0 ? function110 : function14;
        if ((i2 & 256) != 0) {
            function18 = null;
            obj3 = obj;
            kClass2 = kClass;
            function17 = function16;
            navGraphBuilder2 = navGraphBuilder;
        } else {
            function18 = function15;
            navGraphBuilder2 = navGraphBuilder;
            obj3 = obj;
            kClass2 = kClass;
            function17 = function16;
        }
        navigation(navGraphBuilder2, obj3, (KClass<?>) kClass2, (Map<KType, NavType<?>>) emptyMap, (List<NavDeepLink>) emptyList, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function19, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function110, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function111, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function112, (Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform>) function18, (Function1<? super NavGraphBuilder, Unit>) function17);
    }

    public static final void navigation(NavGraphBuilder navGraphBuilder, Object obj, KClass<?> kClass, Map<KType, NavType<?>> map, List<NavDeepLink> list, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function12, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function13, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function14, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function15, Function1<? super NavGraphBuilder, Unit> function16) {
        NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(navGraphBuilder.getProvider(), obj, kClass, map);
        function16.invoke(navGraphBuilder2);
        NavGraph build = navGraphBuilder2.build();
        for (NavDeepLink addDeepLink : list) {
            build.addDeepLink(addDeepLink);
        }
        if (build instanceof ComposeNavGraphNavigator.ComposeNavGraph) {
            ComposeNavGraphNavigator.ComposeNavGraph composeNavGraph = (ComposeNavGraphNavigator.ComposeNavGraph) build;
            composeNavGraph.setEnterTransition$navigation_compose_release(function1);
            composeNavGraph.setExitTransition$navigation_compose_release(function12);
            composeNavGraph.setPopEnterTransition$navigation_compose_release(function13);
            composeNavGraph.setPopExitTransition$navigation_compose_release(function14);
            composeNavGraph.setSizeTransform$navigation_compose_release(function15);
        }
        navGraphBuilder.addDestination(build);
    }

    public static /* synthetic */ void dialog$default(NavGraphBuilder navGraphBuilder, String str, List list, List list2, DialogProperties dialogProperties, Function3 function3, int i, Object obj) {
        if ((i & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        List list3 = list;
        if ((i & 4) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        dialog(navGraphBuilder, str, list3, list2, (i & 8) != 0 ? new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null) : dialogProperties, function3);
    }

    public static final void dialog(NavGraphBuilder navGraphBuilder, String str, List<NamedNavArgument> list, List<NavDeepLink> list2, DialogProperties dialogProperties, Function3<? super NavBackStackEntry, ? super Composer, ? super Integer, Unit> function3) {
        DialogNavigatorDestinationBuilder dialogNavigatorDestinationBuilder = new DialogNavigatorDestinationBuilder((DialogNavigator) navGraphBuilder.getProvider().getNavigator(DialogNavigator.class), str, dialogProperties, function3);
        for (NamedNavArgument namedNavArgument : list) {
            dialogNavigatorDestinationBuilder.argument(namedNavArgument.component1(), namedNavArgument.component2());
        }
        for (NavDeepLink deepLink : list2) {
            dialogNavigatorDestinationBuilder.deepLink(deepLink);
        }
        navGraphBuilder.destination(dialogNavigatorDestinationBuilder);
    }

    public static /* synthetic */ void dialog$default(NavGraphBuilder navGraphBuilder, Map map, List<NavDeepLink> list, DialogProperties dialogProperties, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            map = MapsKt.emptyMap();
        }
        Map map2 = map;
        if ((i & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        DialogProperties dialogProperties2 = (i & 4) != 0 ? new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null) : dialogProperties;
        Intrinsics.reifiedOperationMarker(4, "T");
        DialogNavigatorDestinationBuilder dialogNavigatorDestinationBuilder = new DialogNavigatorDestinationBuilder((DialogNavigator) navGraphBuilder.getProvider().getNavigator(DialogNavigator.class), Reflection.getOrCreateKotlinClass(Object.class), map2, dialogProperties2, function3);
        DialogNavigatorDestinationBuilder dialogNavigatorDestinationBuilder2 = dialogNavigatorDestinationBuilder;
        for (NavDeepLink deepLink : list) {
            dialogNavigatorDestinationBuilder.deepLink(deepLink);
        }
        navGraphBuilder.destination(dialogNavigatorDestinationBuilder);
    }

    public static final /* synthetic */ <T> void dialog(NavGraphBuilder navGraphBuilder, Map<KType, NavType<?>> map, List<NavDeepLink> list, DialogProperties dialogProperties, Function3<? super NavBackStackEntry, ? super Composer, ? super Integer, Unit> function3) {
        Intrinsics.reifiedOperationMarker(4, "T");
        DialogNavigatorDestinationBuilder dialogNavigatorDestinationBuilder = new DialogNavigatorDestinationBuilder((DialogNavigator) navGraphBuilder.getProvider().getNavigator(DialogNavigator.class), Reflection.getOrCreateKotlinClass(Object.class), map, dialogProperties, function3);
        DialogNavigatorDestinationBuilder dialogNavigatorDestinationBuilder2 = dialogNavigatorDestinationBuilder;
        for (NavDeepLink deepLink : list) {
            dialogNavigatorDestinationBuilder.deepLink(deepLink);
        }
        navGraphBuilder.destination(dialogNavigatorDestinationBuilder);
    }
}
