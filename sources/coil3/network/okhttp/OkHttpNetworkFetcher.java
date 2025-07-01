package coil3.network.okhttp;

import coil3.PlatformContext;
import coil3.network.CacheStrategy;
import coil3.network.ConnectivityChecker;
import coil3.network.NetworkClient;
import coil3.network.NetworkFetcher;
import coil3.network.okhttp.internal.CallFactoryNetworkClient;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.Call;
import okhttp3.OkHttpClient;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\b\u0002\u001a\u001b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0005H\u0007¢\u0006\u0002\b\u0002\u001aC\u0010\u0000\u001a\u00020\u00012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00052\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0007¢\u0006\u0002\b\u0002\u001a\n\u0010\f\u001a\u00020\r*\u00020\u0004¨\u0006\u000e"}, d2 = {"OkHttpNetworkFetcherFactory", "Lcoil3/network/NetworkFetcher$Factory;", "factory", "callFactory", "Lokhttp3/Call$Factory;", "Lkotlin/Function0;", "cacheStrategy", "Lcoil3/network/CacheStrategy;", "connectivityChecker", "Lkotlin/Function1;", "Lcoil3/PlatformContext;", "Lcoil3/network/ConnectivityChecker;", "asNetworkClient", "Lcoil3/network/NetworkClient;", "coil-network-okhttp"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: OkHttpNetworkFetcher.kt */
public final class OkHttpNetworkFetcher {
    public static final NetworkFetcher.Factory factory() {
        return new NetworkFetcher.Factory(new OkHttpNetworkFetcher$$ExternalSyntheticLambda2(), (Function0) null, (Function1) null, 6, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    public static final NetworkClient OkHttpNetworkFetcherFactory$lambda$0() {
        return asNetworkClient(new OkHttpClient());
    }

    public static final NetworkFetcher.Factory factory(Call.Factory factory) {
        return new NetworkFetcher.Factory(new OkHttpNetworkFetcher$$ExternalSyntheticLambda3(factory), (Function0) null, (Function1) null, 6, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    public static final NetworkClient OkHttpNetworkFetcherFactory$lambda$1(Call.Factory factory) {
        return asNetworkClient(factory);
    }

    public static final NetworkFetcher.Factory factory(Function0<? extends Call.Factory> function0) {
        return new NetworkFetcher.Factory(new OkHttpNetworkFetcher$$ExternalSyntheticLambda1(function0), (Function0) null, (Function1) null, 6, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    public static final NetworkClient OkHttpNetworkFetcherFactory$lambda$2(Function0 function0) {
        return asNetworkClient((Call.Factory) function0.invoke());
    }

    public static /* synthetic */ NetworkFetcher.Factory factory$default(Function0 function0, Function0 function02, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = OkHttpNetworkFetcher$OkHttpNetworkFetcherFactory$4.INSTANCE;
        }
        if ((i & 2) != 0) {
            new OkHttpNetworkFetcher$$ExternalSyntheticLambda4
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000e: CONSTRUCTOR  (r1v2 ? I:coil3.network.okhttp.OkHttpNetworkFetcher$$ExternalSyntheticLambda4) =  call: coil3.network.okhttp.OkHttpNetworkFetcher$$ExternalSyntheticLambda4.<init>():void type: CONSTRUCTOR in method: coil3.network.okhttp.OkHttpNetworkFetcher.factory$default(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, int, java.lang.Object):coil3.network.NetworkFetcher$Factory, dex: classes2.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r1v2 ?
                	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:620)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	... 34 more
                */
            /*
                r4 = r3 & 1
                if (r4 == 0) goto L_0x0008
                coil3.network.okhttp.OkHttpNetworkFetcher$OkHttpNetworkFetcherFactory$4 r0 = coil3.network.okhttp.OkHttpNetworkFetcher$OkHttpNetworkFetcherFactory$4.INSTANCE
                kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            L_0x0008:
                r4 = r3 & 2
                if (r4 == 0) goto L_0x0011
                coil3.network.okhttp.OkHttpNetworkFetcher$$ExternalSyntheticLambda4 r1 = new coil3.network.okhttp.OkHttpNetworkFetcher$$ExternalSyntheticLambda4
                r1.<init>()
            L_0x0011:
                r3 = r3 & 4
                if (r3 == 0) goto L_0x0019
                coil3.network.okhttp.OkHttpNetworkFetcher$OkHttpNetworkFetcherFactory$6 r2 = coil3.network.okhttp.OkHttpNetworkFetcher$OkHttpNetworkFetcherFactory$6.INSTANCE
                kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            L_0x0019:
                coil3.network.NetworkFetcher$Factory r0 = factory(r0, r1, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: coil3.network.okhttp.OkHttpNetworkFetcher.factory$default(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, int, java.lang.Object):coil3.network.NetworkFetcher$Factory");
        }

        /* access modifiers changed from: private */
        public static final CacheStrategy OkHttpNetworkFetcherFactory$lambda$3() {
            return CacheStrategy.DEFAULT;
        }

        public static final NetworkFetcher.Factory factory(Function0<? extends Call.Factory> function0, Function0<? extends CacheStrategy> function02, Function1<? super PlatformContext, ? extends ConnectivityChecker> function1) {
            return new NetworkFetcher.Factory(new OkHttpNetworkFetcher$$ExternalSyntheticLambda0(function0), function02, function1);
        }

        /* access modifiers changed from: private */
        public static final NetworkClient OkHttpNetworkFetcherFactory$lambda$4(Function0 function0) {
            return asNetworkClient((Call.Factory) function0.invoke());
        }

        public static final NetworkClient asNetworkClient(Call.Factory factory) {
            return CallFactoryNetworkClient.m7524boximpl(CallFactoryNetworkClient.m7525constructorimpl(factory));
        }
    }
