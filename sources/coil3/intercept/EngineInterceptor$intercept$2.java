package coil3.intercept;

import coil3.EventListener;
import coil3.Image;
import coil3.decode.DataSource;
import coil3.intercept.EngineInterceptor;
import coil3.intercept.Interceptor;
import coil3.memory.MemoryCache;
import coil3.request.ImageRequest;
import coil3.request.Options;
import coil3.request.SuccessResult;
import coil3.util.UtilsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcoil3/request/SuccessResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.intercept.EngineInterceptor$intercept$2", f = "EngineInterceptor.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: EngineInterceptor.kt */
final class EngineInterceptor$intercept$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SuccessResult>, Object> {
    final /* synthetic */ MemoryCache.Key $cacheKey;
    final /* synthetic */ Interceptor.Chain $chain;
    final /* synthetic */ EventListener $eventListener;
    final /* synthetic */ Object $mappedData;
    final /* synthetic */ Options $options;
    final /* synthetic */ ImageRequest $request;
    int label;
    final /* synthetic */ EngineInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EngineInterceptor$intercept$2(EngineInterceptor engineInterceptor, ImageRequest imageRequest, Object obj, Options options, EventListener eventListener, MemoryCache.Key key, Interceptor.Chain chain, Continuation<? super EngineInterceptor$intercept$2> continuation) {
        super(2, continuation);
        this.this$0 = engineInterceptor;
        this.$request = imageRequest;
        this.$mappedData = obj;
        this.$options = options;
        this.$eventListener = eventListener;
        this.$cacheKey = key;
        this.$chain = chain;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EngineInterceptor$intercept$2(this.this$0, this.$request, this.$mappedData, this.$options, this.$eventListener, this.$cacheKey, this.$chain, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SuccessResult> continuation) {
        return ((EngineInterceptor$intercept$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.execute(this.$request, this.$mappedData, this.$options, this.$eventListener, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        EngineInterceptor.ExecuteResult executeResult = (EngineInterceptor.ExecuteResult) obj;
        this.this$0.systemCallbacks.registerMemoryPressureCallbacks();
        boolean cacheValue = this.this$0.memoryCacheService.setCacheValue(this.$cacheKey, this.$request, executeResult);
        Image image = executeResult.getImage();
        ImageRequest imageRequest = this.$request;
        DataSource dataSource = executeResult.getDataSource();
        MemoryCache.Key key = this.$cacheKey;
        if (!cacheValue) {
            key = null;
        }
        return new SuccessResult(image, imageRequest, dataSource, key, executeResult.getDiskCacheKey(), executeResult.isSampled(), UtilsKt.isPlaceholderCached(this.$chain));
    }
}
