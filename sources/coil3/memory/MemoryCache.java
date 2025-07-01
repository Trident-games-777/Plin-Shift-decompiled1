package coil3.memory;

import android.content.Context;
import coil3.Image;
import coil3.util.Collections_jvmCommonKt;
import coil3.util.ContextsKt;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0003\u0017\u0018\u0019J\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\nH¦\u0002J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u000eH¦\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\nH&J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0011H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Lcoil3/memory/MemoryCache;", "", "size", "", "getSize", "()J", "maxSize", "getMaxSize", "keys", "", "Lcoil3/memory/MemoryCache$Key;", "getKeys", "()Ljava/util/Set;", "get", "Lcoil3/memory/MemoryCache$Value;", "key", "set", "", "value", "remove", "", "trimToSize", "clear", "Key", "Value", "Builder", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: MemoryCache.kt */
public interface MemoryCache {
    void clear();

    Value get(Key key);

    Set<Key> getKeys();

    long getMaxSize();

    long getSize();

    boolean remove(Key key);

    void set(Key key, Value value);

    void trimToSize(long j);

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcoil3/memory/MemoryCache$Key;", "", "key", "", "extras", "", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "getKey", "()Ljava/lang/String;", "getExtras", "()Ljava/util/Map;", "copy", "equals", "", "other", "hashCode", "", "toString", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: MemoryCache.kt */
    public static final class Key {
        private final Map<String, String> extras;
        private final String key;

        public Key(String str) {
            this(str, (Map) null, 2, (DefaultConstructorMarker) null);
        }

        public Key(String str, Map<String, String> map) {
            this.key = str;
            this.extras = Collections_jvmCommonKt.toImmutableMap(map);
        }

        public final String getKey() {
            return this.key;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Key(String str, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? MapsKt.emptyMap() : map);
        }

        public final Map<String, String> getExtras() {
            return this.extras;
        }

        public static /* synthetic */ Key copy$default(Key key2, String str, Map<String, String> map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = key2.key;
            }
            if ((i & 2) != 0) {
                map = key2.extras;
            }
            return key2.copy(str, map);
        }

        public final Key copy(String str, Map<String, String> map) {
            return new Key(str, map);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key2 = (Key) obj;
            if (!Intrinsics.areEqual((Object) this.key, (Object) key2.key) || !Intrinsics.areEqual((Object) this.extras, (Object) key2.extras)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.key.hashCode() * 31) + this.extras.hashCode();
        }

        public String toString() {
            return "Key(key=" + this.key + ", extras=" + this.extras + ')';
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ&\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcoil3/memory/MemoryCache$Value;", "", "image", "Lcoil3/Image;", "extras", "", "", "<init>", "(Lcoil3/Image;Ljava/util/Map;)V", "getImage", "()Lcoil3/Image;", "getExtras", "()Ljava/util/Map;", "copy", "equals", "", "other", "hashCode", "", "toString", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: MemoryCache.kt */
    public static final class Value {
        private final Map<String, Object> extras;
        private final Image image;

        public Value(Image image2) {
            this(image2, (Map) null, 2, (DefaultConstructorMarker) null);
        }

        public Value(Image image2, Map<String, ? extends Object> map) {
            this.image = image2;
            this.extras = Collections_jvmCommonKt.toImmutableMap(map);
        }

        public final Image getImage() {
            return this.image;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Value(Image image2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(image2, (i & 2) != 0 ? MapsKt.emptyMap() : map);
        }

        public final Map<String, Object> getExtras() {
            return this.extras;
        }

        public static /* synthetic */ Value copy$default(Value value, Image image2, Map<String, Object> map, int i, Object obj) {
            if ((i & 1) != 0) {
                image2 = value.image;
            }
            if ((i & 2) != 0) {
                map = value.extras;
            }
            return value.copy(image2, map);
        }

        public final Value copy(Image image2, Map<String, ? extends Object> map) {
            return new Value(image2, map);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Value)) {
                return false;
            }
            Value value = (Value) obj;
            if (!Intrinsics.areEqual((Object) this.image, (Object) value.image) || !Intrinsics.areEqual((Object) this.extras, (Object) value.extras)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.image.hashCode() * 31) + this.extras.hashCode();
        }

        public String toString() {
            return "Value(image=" + this.image + ", extras=" + this.extras + ')';
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0006J\u0014\u0010\n\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J!\u0010\f\u001a\u00020\u00002\n\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\u0015R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcoil3/memory/MemoryCache$Builder;", "", "<init>", "()V", "maxSizeBytesFactory", "Lkotlin/Function0;", "", "strongReferencesEnabled", "", "weakReferencesEnabled", "maxSizeBytes", "size", "maxSizePercent", "context", "Landroid/content/Context;", "Lcoil3/PlatformContext;", "percent", "", "(Landroid/content/Context;D)Lcoil3/memory/MemoryCache$Builder;", "enable", "build", "Lcoil3/memory/MemoryCache;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: MemoryCache.kt */
    public static final class Builder {
        private Function0<Long> maxSizeBytesFactory;
        private boolean strongReferencesEnabled = true;
        private boolean weakReferencesEnabled = true;

        /* access modifiers changed from: private */
        public static final long maxSizeBytes$lambda$1$lambda$0(long j) {
            return j;
        }

        public final Builder maxSizeBytes(long j) {
            Builder builder = this;
            this.maxSizeBytesFactory = new MemoryCache$Builder$$ExternalSyntheticLambda1(j);
            return this;
        }

        public final Builder maxSizeBytes(Function0<Long> function0) {
            Builder builder = this;
            this.maxSizeBytesFactory = function0;
            return this;
        }

        public static /* synthetic */ Builder maxSizePercent$default(Builder builder, Context context, double d, int i, Object obj) {
            if ((i & 2) != 0) {
                d = ContextsKt.defaultMemoryCacheSizePercent(context);
            }
            return builder.maxSizePercent(context, d);
        }

        public final Builder maxSizePercent(Context context, double d) {
            Builder builder = this;
            if (0.0d > d || d > 1.0d) {
                throw new IllegalArgumentException("percent must be in the range [0.0, 1.0].".toString());
            }
            this.maxSizeBytesFactory = new MemoryCache$Builder$$ExternalSyntheticLambda0(d, context);
            return this;
        }

        /* access modifiers changed from: private */
        public static final long maxSizePercent$lambda$5$lambda$4(double d, Context context) {
            return (long) (d * ((double) ContextsKt.totalAvailableMemoryBytes(context)));
        }

        public final Builder strongReferencesEnabled(boolean z) {
            Builder builder = this;
            this.strongReferencesEnabled = z;
            return this;
        }

        public final Builder weakReferencesEnabled(boolean z) {
            Builder builder = this;
            this.weakReferencesEnabled = z;
            return this;
        }

        public final MemoryCache build() {
            WeakMemoryCache weakMemoryCache;
            StrongMemoryCache strongMemoryCache;
            if (this.weakReferencesEnabled) {
                weakMemoryCache = new RealWeakMemoryCache();
            } else {
                weakMemoryCache = new EmptyWeakMemoryCache();
            }
            if (this.strongReferencesEnabled) {
                Function0<Long> function0 = this.maxSizeBytesFactory;
                if (function0 != null) {
                    long longValue = function0.invoke().longValue();
                    if (longValue > 0) {
                        strongMemoryCache = new RealStrongMemoryCache(longValue, weakMemoryCache);
                    } else {
                        strongMemoryCache = new EmptyStrongMemoryCache(weakMemoryCache);
                    }
                } else {
                    throw new IllegalStateException("maxSizeBytesFactory == null".toString());
                }
            } else {
                strongMemoryCache = new EmptyStrongMemoryCache(weakMemoryCache);
            }
            return new RealMemoryCache(strongMemoryCache, weakMemoryCache);
        }
    }
}
