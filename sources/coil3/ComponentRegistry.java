package coil3;

import coil3.decode.Decoder;
import coil3.fetch.Fetcher;
import coil3.fetch.SourceFetchResult;
import coil3.intercept.Interceptor;
import coil3.key.Keyer;
import coil3.map.Mapper;
import coil3.request.Options;
import coil3.util.Collections_jvmCommonKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00010BÃ\u0001\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00120\u0010\u0005\u001a,\u0012(\u0012&\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u00010\u0007\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b0\u00060\u0003\u0012(\u0010\t\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\n\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b0\u00060\u0003\u00124\u0010\u000b\u001a0\u0012,\u0012*\u0012&\u0012$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\r\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b0\u00060\u00030\f0\u0003\u0012\u0018\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00030\f0\u0003¢\u0006\u0004\b\u0010\u0010\u0011B\t\b\u0016¢\u0006\u0004\b\u0010\u0010\u0012J\u0016\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020!J\u0018\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020!J8\u0010$\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0018\u00010\u00062\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020!2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020&H\u0007J8\u0010*\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020&\u0018\u00010\u00062\u0006\u0010,\u001a\u00020-2\u0006\u0010 \u001a\u00020!2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020&H\u0007J\u0006\u0010.\u001a\u00020/R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R;\u0010\u0005\u001a,\u0012(\u0012&\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u00010\u0007\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b0\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R3\u0010\t\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\n\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b0\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R<\u0010\u000b\u001a0\u0012,\u0012*\u0012&\u0012$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\r\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b0\u00060\u00030\f0\u0003X\u000e¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00030\f0\u0003X\u000e¢\u0006\u0002\n\u0000R=\u0010\u0017\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\r\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b0\u00060\u00038FX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0018\u0010\u0014R!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00038FX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001c\u0010\u0014¨\u00061"}, d2 = {"Lcoil3/ComponentRegistry;", "", "interceptors", "", "Lcoil3/intercept/Interceptor;", "mappers", "Lkotlin/Pair;", "Lcoil3/map/Mapper;", "Lkotlin/reflect/KClass;", "keyers", "Lcoil3/key/Keyer;", "lazyFetcherFactories", "Lkotlin/Function0;", "Lcoil3/fetch/Fetcher$Factory;", "lazyDecoderFactories", "Lcoil3/decode/Decoder$Factory;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "()V", "getInterceptors", "()Ljava/util/List;", "getMappers", "getKeyers", "fetcherFactories", "getFetcherFactories", "fetcherFactories$delegate", "Lkotlin/Lazy;", "decoderFactories", "getDecoderFactories", "decoderFactories$delegate", "map", "data", "options", "Lcoil3/request/Options;", "key", "", "newFetcher", "Lcoil3/fetch/Fetcher;", "", "imageLoader", "Lcoil3/ImageLoader;", "startIndex", "newDecoder", "Lcoil3/decode/Decoder;", "result", "Lcoil3/fetch/SourceFetchResult;", "newBuilder", "Lcoil3/ComponentRegistry$Builder;", "Builder", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ComponentRegistry.kt */
public final class ComponentRegistry {
    private final Lazy decoderFactories$delegate;
    private final Lazy fetcherFactories$delegate;
    private final List<Interceptor> interceptors;
    private final List<Pair<Keyer<? extends Object>, KClass<? extends Object>>> keyers;
    private List<? extends Function0<? extends List<? extends Decoder.Factory>>> lazyDecoderFactories;
    private List<? extends Function0<? extends List<? extends Pair<? extends Fetcher.Factory<? extends Object>, ? extends KClass<? extends Object>>>>> lazyFetcherFactories;
    private final List<Pair<Mapper<? extends Object, ? extends Object>, KClass<? extends Object>>> mappers;

    public /* synthetic */ ComponentRegistry(List list, List list2, List list3, List list4, List list5, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, list3, list4, list5);
    }

    public final Pair<Decoder, Integer> newDecoder(SourceFetchResult sourceFetchResult, Options options, ImageLoader imageLoader) {
        return newDecoder$default(this, sourceFetchResult, options, imageLoader, 0, 8, (Object) null);
    }

    public final Pair<Fetcher, Integer> newFetcher(Object obj, Options options, ImageLoader imageLoader) {
        return newFetcher$default(this, obj, options, imageLoader, 0, 8, (Object) null);
    }

    private ComponentRegistry(List<? extends Interceptor> list, List<? extends Pair<? extends Mapper<? extends Object, ? extends Object>, ? extends KClass<? extends Object>>> list2, List<? extends Pair<? extends Keyer<? extends Object>, ? extends KClass<? extends Object>>> list3, List<? extends Function0<? extends List<? extends Pair<? extends Fetcher.Factory<? extends Object>, ? extends KClass<? extends Object>>>>> list4, List<? extends Function0<? extends List<? extends Decoder.Factory>>> list5) {
        this.interceptors = list;
        this.mappers = list2;
        this.keyers = list3;
        this.lazyFetcherFactories = list4;
        this.lazyDecoderFactories = list5;
        this.fetcherFactories$delegate = LazyKt.lazy(new ComponentRegistry$$ExternalSyntheticLambda0(this));
        this.decoderFactories$delegate = LazyKt.lazy(new ComponentRegistry$$ExternalSyntheticLambda1(this));
    }

    public final List<Interceptor> getInterceptors() {
        return this.interceptors;
    }

    public final List<Pair<Mapper<? extends Object, ? extends Object>, KClass<? extends Object>>> getMappers() {
        return this.mappers;
    }

    public final List<Pair<Keyer<? extends Object>, KClass<? extends Object>>> getKeyers() {
        return this.keyers;
    }

    public ComponentRegistry() {
        this(CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }

    public final List<Pair<Fetcher.Factory<? extends Object>, KClass<? extends Object>>> getFetcherFactories() {
        return (List) this.fetcherFactories$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final List fetcherFactories_delegate$lambda$2(ComponentRegistry componentRegistry) {
        List<? extends Function0<? extends List<? extends Pair<? extends Fetcher.Factory<? extends Object>, ? extends KClass<? extends Object>>>>> list = componentRegistry.lazyFetcherFactories;
        List arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            CollectionsKt.addAll(arrayList, (List) ((Function0) list.get(i)).invoke());
        }
        componentRegistry.lazyFetcherFactories = CollectionsKt.emptyList();
        return arrayList;
    }

    public final List<Decoder.Factory> getDecoderFactories() {
        return (List) this.decoderFactories$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final List decoderFactories_delegate$lambda$5(ComponentRegistry componentRegistry) {
        List<? extends Function0<? extends List<? extends Decoder.Factory>>> list = componentRegistry.lazyDecoderFactories;
        List arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            CollectionsKt.addAll(arrayList, (List) ((Function0) list.get(i)).invoke());
        }
        componentRegistry.lazyDecoderFactories = CollectionsKt.emptyList();
        return arrayList;
    }

    public final Object map(Object obj, Options options) {
        List<Pair<Mapper<? extends Object, ? extends Object>, KClass<? extends Object>>> list = this.mappers;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Pair pair = list.get(i);
            Mapper mapper = (Mapper) pair.component1();
            if (((KClass) pair.component2()).isInstance(obj)) {
                Intrinsics.checkNotNull(mapper, "null cannot be cast to non-null type coil3.map.Mapper<kotlin.Any, *>");
                Object map = mapper.map(obj, options);
                if (map != null) {
                    obj = map;
                }
            }
        }
        return obj;
    }

    public final String key(Object obj, Options options) {
        List<Pair<Keyer<? extends Object>, KClass<? extends Object>>> list = this.keyers;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Pair pair = list.get(i);
            Keyer keyer = (Keyer) pair.component1();
            if (((KClass) pair.component2()).isInstance(obj)) {
                Intrinsics.checkNotNull(keyer, "null cannot be cast to non-null type coil3.key.Keyer<kotlin.Any>");
                String key = keyer.key(obj, options);
                if (key != null) {
                    return key;
                }
            }
        }
        return null;
    }

    public static /* synthetic */ Pair newFetcher$default(ComponentRegistry componentRegistry, Object obj, Options options, ImageLoader imageLoader, int i, int i2, Object obj2) {
        if ((i2 & 8) != 0) {
            i = 0;
        }
        return componentRegistry.newFetcher(obj, options, imageLoader, i);
    }

    public final Pair<Fetcher, Integer> newFetcher(Object obj, Options options, ImageLoader imageLoader, int i) {
        int size = getFetcherFactories().size();
        while (i < size) {
            Pair pair = getFetcherFactories().get(i);
            Fetcher.Factory factory = (Fetcher.Factory) pair.component1();
            if (((KClass) pair.component2()).isInstance(obj)) {
                Intrinsics.checkNotNull(factory, "null cannot be cast to non-null type coil3.fetch.Fetcher.Factory<kotlin.Any>");
                Fetcher create = factory.create(obj, options, imageLoader);
                if (create != null) {
                    return TuplesKt.to(create, Integer.valueOf(i));
                }
            }
            i++;
        }
        return null;
    }

    public static /* synthetic */ Pair newDecoder$default(ComponentRegistry componentRegistry, SourceFetchResult sourceFetchResult, Options options, ImageLoader imageLoader, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = 0;
        }
        return componentRegistry.newDecoder(sourceFetchResult, options, imageLoader, i);
    }

    public final Pair<Decoder, Integer> newDecoder(SourceFetchResult sourceFetchResult, Options options, ImageLoader imageLoader, int i) {
        int size = getDecoderFactories().size();
        while (i < size) {
            Decoder create = getDecoderFactories().get(i).create(sourceFetchResult, options, imageLoader);
            if (create != null) {
                return TuplesKt.to(create, Integer.valueOf(i));
            }
            i++;
        }
        return null;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\tJ'\u0010\u001c\u001a\u00020\u0000\"\n\b\u0000\u0010\u001e\u0018\u0001*\u00020\u00012\u0010\u0010\u001f\u001a\f\u0012\u0004\u0012\u0002H\u001e\u0012\u0002\b\u00030\u000eH\bJ0\u0010\u001c\u001a\u00020\u0000\"\b\b\u0000\u0010\u001e*\u00020\u00012\u0010\u0010\u001f\u001a\f\u0012\u0004\u0012\u0002H\u001e\u0012\u0002\b\u00030\u000e2\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001e0\u000fJ#\u0010\u001c\u001a\u00020\u0000\"\n\b\u0000\u0010\u001e\u0018\u0001*\u00020\u00012\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u0012H\bJ,\u0010\u001c\u001a\u00020\u0000\"\b\b\u0000\u0010\u001e*\u00020\u00012\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u00122\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001e0\u000fJ#\u0010\u001c\u001a\u00020\u0000\"\n\b\u0000\u0010\u001e\u0018\u0001*\u00020\u00012\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u0017H\bJ,\u0010\u001c\u001a\u00020\u0000\"\b\b\u0000\u0010\u001e*\u00020\u00012\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u00172\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001e0\u000fJ6\u0010#\u001a\u00020\u00002.\u0010\"\u001a*\u0012&\u0012$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0017\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000f0\r0\u00160\u0015J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u001aJ\u001a\u0010$\u001a\u00020\u00002\u0012\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00160\u0015J\u0006\u0010%\u001a\u00020\u0005R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR:\u0010\f\u001a(\u0012$\u0012\"\u0012\u0010\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0002\b\u00030\u000e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000f0\r0\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR6\u0010\u0011\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000f0\r0\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bRB\u0010\u0014\u001a0\u0012,\u0012*\u0012&\u0012$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0017\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000f0\r0\u00160\u00150\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000bR&\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00160\u00150\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000b¨\u0006&"}, d2 = {"Lcoil3/ComponentRegistry$Builder;", "", "<init>", "()V", "registry", "Lcoil3/ComponentRegistry;", "(Lcoil3/ComponentRegistry;)V", "interceptors", "", "Lcoil3/intercept/Interceptor;", "getInterceptors$coil_core_release", "()Ljava/util/List;", "mappers", "Lkotlin/Pair;", "Lcoil3/map/Mapper;", "Lkotlin/reflect/KClass;", "getMappers$coil_core_release", "keyers", "Lcoil3/key/Keyer;", "getKeyers$coil_core_release", "lazyFetcherFactories", "Lkotlin/Function0;", "", "Lcoil3/fetch/Fetcher$Factory;", "getLazyFetcherFactories$coil_core_release", "lazyDecoderFactories", "Lcoil3/decode/Decoder$Factory;", "getLazyDecoderFactories$coil_core_release", "add", "interceptor", "T", "mapper", "type", "keyer", "factory", "addFetcherFactories", "addDecoderFactories", "build", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: ComponentRegistry.kt */
    public static final class Builder {
        private final List<Interceptor> interceptors;
        private final List<Pair<Keyer<? extends Object>, KClass<? extends Object>>> keyers;
        private final List<Function0<List<Decoder.Factory>>> lazyDecoderFactories;
        private final List<Function0<List<Pair<Fetcher.Factory<? extends Object>, KClass<? extends Object>>>>> lazyFetcherFactories;
        private final List<Pair<Mapper<? extends Object, ?>, KClass<? extends Object>>> mappers;

        public final List<Interceptor> getInterceptors$coil_core_release() {
            return this.interceptors;
        }

        public final List<Pair<Mapper<? extends Object, ?>, KClass<? extends Object>>> getMappers$coil_core_release() {
            return this.mappers;
        }

        public final List<Pair<Keyer<? extends Object>, KClass<? extends Object>>> getKeyers$coil_core_release() {
            return this.keyers;
        }

        public final List<Function0<List<Pair<Fetcher.Factory<? extends Object>, KClass<? extends Object>>>>> getLazyFetcherFactories$coil_core_release() {
            return this.lazyFetcherFactories;
        }

        public final List<Function0<List<Decoder.Factory>>> getLazyDecoderFactories$coil_core_release() {
            return this.lazyDecoderFactories;
        }

        public Builder() {
            this.interceptors = new ArrayList();
            this.mappers = new ArrayList();
            this.keyers = new ArrayList();
            this.lazyFetcherFactories = new ArrayList();
            this.lazyDecoderFactories = new ArrayList();
        }

        public Builder(ComponentRegistry componentRegistry) {
            this.interceptors = CollectionsKt.toMutableList(componentRegistry.getInterceptors());
            this.mappers = CollectionsKt.toMutableList(componentRegistry.getMappers());
            this.keyers = CollectionsKt.toMutableList(componentRegistry.getKeyers());
            Collection arrayList = new ArrayList();
            for (Pair componentRegistry$Builder$$ExternalSyntheticLambda0 : componentRegistry.getFetcherFactories()) {
                arrayList.add(new ComponentRegistry$Builder$$ExternalSyntheticLambda0(componentRegistry$Builder$$ExternalSyntheticLambda0));
            }
            this.lazyFetcherFactories = (List) arrayList;
            Collection arrayList2 = new ArrayList();
            for (Decoder.Factory componentRegistry$Builder$$ExternalSyntheticLambda1 : componentRegistry.getDecoderFactories()) {
                arrayList2.add(new ComponentRegistry$Builder$$ExternalSyntheticLambda1(componentRegistry$Builder$$ExternalSyntheticLambda1));
            }
            this.lazyDecoderFactories = (List) arrayList2;
        }

        /* access modifiers changed from: private */
        public static final List _init_$lambda$1$lambda$0(Pair pair) {
            return CollectionsKt.listOf(pair);
        }

        /* access modifiers changed from: private */
        public static final List _init_$lambda$3$lambda$2(Decoder.Factory factory) {
            return CollectionsKt.listOf(factory);
        }

        public final Builder add(Interceptor interceptor) {
            Builder builder = this;
            this.interceptors.add(interceptor);
            return this;
        }

        public final /* synthetic */ <T> Builder add(Mapper<T, ?> mapper) {
            Intrinsics.reifiedOperationMarker(4, "T");
            return add(mapper, Reflection.getOrCreateKotlinClass(Object.class));
        }

        public final <T> Builder add(Mapper<T, ?> mapper, KClass<T> kClass) {
            Builder builder = this;
            this.mappers.add(TuplesKt.to(mapper, kClass));
            return this;
        }

        public final /* synthetic */ <T> Builder add(Keyer<T> keyer) {
            Intrinsics.reifiedOperationMarker(4, "T");
            return add(keyer, Reflection.getOrCreateKotlinClass(Object.class));
        }

        public final <T> Builder add(Keyer<T> keyer, KClass<T> kClass) {
            Builder builder = this;
            this.keyers.add(TuplesKt.to(keyer, kClass));
            return this;
        }

        public final /* synthetic */ <T> Builder add(Fetcher.Factory<T> factory) {
            Intrinsics.reifiedOperationMarker(4, "T");
            return add(factory, Reflection.getOrCreateKotlinClass(Object.class));
        }

        public final <T> Builder add(Fetcher.Factory<T> factory, KClass<T> kClass) {
            Builder builder = this;
            this.lazyFetcherFactories.add(new ComponentRegistry$Builder$$ExternalSyntheticLambda2(factory, kClass));
            return this;
        }

        /* access modifiers changed from: private */
        public static final List add$lambda$8$lambda$7(Fetcher.Factory factory, KClass kClass) {
            return CollectionsKt.listOf(TuplesKt.to(factory, kClass));
        }

        public final Builder addFetcherFactories(Function0<? extends List<? extends Pair<? extends Fetcher.Factory<? extends Object>, ? extends KClass<? extends Object>>>> function0) {
            Builder builder = this;
            this.lazyFetcherFactories.add(function0);
            return this;
        }

        public final Builder add(Decoder.Factory factory) {
            Builder builder = this;
            this.lazyDecoderFactories.add(new ComponentRegistry$Builder$$ExternalSyntheticLambda3(factory));
            return this;
        }

        /* access modifiers changed from: private */
        public static final List add$lambda$11$lambda$10(Decoder.Factory factory) {
            return CollectionsKt.listOf(factory);
        }

        public final Builder addDecoderFactories(Function0<? extends List<? extends Decoder.Factory>> function0) {
            Builder builder = this;
            this.lazyDecoderFactories.add(function0);
            return this;
        }

        public final ComponentRegistry build() {
            return new ComponentRegistry(Collections_jvmCommonKt.toImmutableList(this.interceptors), Collections_jvmCommonKt.toImmutableList(this.mappers), Collections_jvmCommonKt.toImmutableList(this.keyers), Collections_jvmCommonKt.toImmutableList(this.lazyFetcherFactories), Collections_jvmCommonKt.toImmutableList(this.lazyDecoderFactories), (DefaultConstructorMarker) null);
        }
    }
}
