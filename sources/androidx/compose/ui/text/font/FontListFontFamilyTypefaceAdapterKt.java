package androidx.compose.ui.text.font;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aR\u0010\u0000\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\fH\u0002¨\u0006\r"}, d2 = {"firstImmediatelyAvailable", "Lkotlin/Pair;", "", "Landroidx/compose/ui/text/font/Font;", "", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "createDefaultTypeface", "Lkotlin/Function1;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: FontListFontFamilyTypefaceAdapter.kt */
public final class FontListFontFamilyTypefaceAdapterKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v39, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v25, resolved type: androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.Pair<java.util.List<androidx.compose.ui.text.font.Font>, java.lang.Object> firstImmediatelyAvailable(java.util.List<? extends androidx.compose.ui.text.font.Font> r13, androidx.compose.ui.text.font.TypefaceRequest r14, androidx.compose.ui.text.font.AsyncTypefaceCache r15, androidx.compose.ui.text.font.PlatformFontLoader r16, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.font.TypefaceRequest, ? extends java.lang.Object> r17) {
        /*
            r3 = r16
            int r8 = r13.size()
            r9 = 0
            r10 = 0
            r12 = r9
            r11 = r10
        L_0x000a:
            if (r11 >= r8) goto L_0x018d
            java.lang.Object r0 = r13.get(r11)
            r2 = r0
            androidx.compose.ui.text.font.Font r2 = (androidx.compose.ui.text.font.Font) r2
            int r0 = r2.m6649getLoadingStrategyPKNRLFQ()
            androidx.compose.ui.text.font.FontLoadingStrategy$Companion r1 = androidx.compose.ui.text.font.FontLoadingStrategy.Companion
            int r1 = r1.m6670getBlockingPKNRLFQ()
            boolean r1 = androidx.compose.ui.text.font.FontLoadingStrategy.m6665equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x00a7
            androidx.compose.ui.text.platform.SynchronizedObject r1 = r15.cacheLock
            monitor-enter(r1)
            androidx.compose.ui.text.font.AsyncTypefaceCache$Key r0 = new androidx.compose.ui.text.font.AsyncTypefaceCache$Key     // Catch:{ all -> 0x00a4 }
            java.lang.Object r4 = r3.getCacheKey()     // Catch:{ all -> 0x00a4 }
            r0.<init>(r2, r4)     // Catch:{ all -> 0x00a4 }
            androidx.compose.ui.text.caches.LruCache r4 = r15.resultCache     // Catch:{ all -> 0x00a4 }
            java.lang.Object r4 = r4.get(r0)     // Catch:{ all -> 0x00a4 }
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r4 = (androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult) r4     // Catch:{ all -> 0x00a4 }
            if (r4 != 0) goto L_0x0048
            androidx.compose.ui.text.caches.SimpleArrayMap r4 = r15.permanentCache     // Catch:{ all -> 0x00a4 }
            java.lang.Object r0 = r4.get(r0)     // Catch:{ all -> 0x00a4 }
            r4 = r0
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r4 = (androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult) r4     // Catch:{ all -> 0x00a4 }
        L_0x0048:
            if (r4 == 0) goto L_0x0050
            java.lang.Object r0 = r4.m6638unboximpl()     // Catch:{ all -> 0x00a4 }
            monitor-exit(r1)
            goto L_0x0060
        L_0x0050:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00a4 }
            monitor-exit(r1)
            java.lang.Object r4 = r3.loadBlocking(r2)     // Catch:{ Exception -> 0x008c }
            r6 = 8
            r7 = 0
            r5 = 0
            r1 = r15
            androidx.compose.ui.text.font.AsyncTypefaceCache.put$default(r1, r2, r3, r4, r5, r6, r7)
            r0 = r4
        L_0x0060:
            if (r0 == 0) goto L_0x0077
            int r1 = r14.m6732getFontSynthesisGVVA2EU()
            androidx.compose.ui.text.font.FontWeight r3 = r14.getFontWeight()
            int r4 = r14.m6731getFontStyle_LCdwA()
            java.lang.Object r0 = androidx.compose.ui.text.font.FontSynthesis_androidKt.m6699synthesizeTypefaceFxwP2eA(r1, r0, r2, r3, r4)
            kotlin.Pair r0 = kotlin.TuplesKt.to(r12, r0)
            return r0
        L_0x0077:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Unable to load font "
            r1.<init>(r3)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x008c:
            r0 = move-exception
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Unable to load font "
            r3.<init>(r4)
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.String r2 = r2.toString()
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r1.<init>(r2, r0)
            throw r1
        L_0x00a4:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        L_0x00a7:
            androidx.compose.ui.text.font.FontLoadingStrategy$Companion r1 = androidx.compose.ui.text.font.FontLoadingStrategy.Companion
            int r1 = r1.m6671getOptionalLocalPKNRLFQ()
            boolean r1 = androidx.compose.ui.text.font.FontLoadingStrategy.m6665equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x0127
            androidx.compose.ui.text.platform.SynchronizedObject r1 = r15.cacheLock
            monitor-enter(r1)
            androidx.compose.ui.text.font.AsyncTypefaceCache$Key r0 = new androidx.compose.ui.text.font.AsyncTypefaceCache$Key     // Catch:{ all -> 0x0124 }
            java.lang.Object r4 = r3.getCacheKey()     // Catch:{ all -> 0x0124 }
            r0.<init>(r2, r4)     // Catch:{ all -> 0x0124 }
            androidx.compose.ui.text.caches.LruCache r4 = r15.resultCache     // Catch:{ all -> 0x0124 }
            java.lang.Object r4 = r4.get(r0)     // Catch:{ all -> 0x0124 }
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r4 = (androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult) r4     // Catch:{ all -> 0x0124 }
            if (r4 != 0) goto L_0x00d8
            androidx.compose.ui.text.caches.SimpleArrayMap r4 = r15.permanentCache     // Catch:{ all -> 0x0124 }
            java.lang.Object r0 = r4.get(r0)     // Catch:{ all -> 0x0124 }
            r4 = r0
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r4 = (androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult) r4     // Catch:{ all -> 0x0124 }
        L_0x00d8:
            if (r4 == 0) goto L_0x00e0
            java.lang.Object r0 = r4.m6638unboximpl()     // Catch:{ all -> 0x0124 }
            monitor-exit(r1)
            goto L_0x010b
        L_0x00e0:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0124 }
            monitor-exit(r1)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x00ee }
            java.lang.Object r0 = r3.loadBlocking(r2)     // Catch:{ all -> 0x00ee }
            java.lang.Object r0 = kotlin.Result.m7823constructorimpl(r0)     // Catch:{ all -> 0x00ee }
            goto L_0x00f9
        L_0x00ee:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m7823constructorimpl(r0)
        L_0x00f9:
            boolean r1 = kotlin.Result.m7829isFailureimpl(r0)
            if (r1 == 0) goto L_0x0101
            r4 = r9
            goto L_0x0102
        L_0x0101:
            r4 = r0
        L_0x0102:
            r6 = 8
            r7 = 0
            r5 = 0
            r1 = r15
            androidx.compose.ui.text.font.AsyncTypefaceCache.put$default(r1, r2, r3, r4, r5, r6, r7)
            r0 = r4
        L_0x010b:
            if (r0 == 0) goto L_0x0122
            int r1 = r14.m6732getFontSynthesisGVVA2EU()
            androidx.compose.ui.text.font.FontWeight r3 = r14.getFontWeight()
            int r4 = r14.m6731getFontStyle_LCdwA()
            java.lang.Object r0 = androidx.compose.ui.text.font.FontSynthesis_androidKt.m6699synthesizeTypefaceFxwP2eA(r1, r0, r2, r3, r4)
            kotlin.Pair r0 = kotlin.TuplesKt.to(r12, r0)
            return r0
        L_0x0122:
            r1 = r15
            goto L_0x0174
        L_0x0124:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        L_0x0127:
            androidx.compose.ui.text.font.FontLoadingStrategy$Companion r1 = androidx.compose.ui.text.font.FontLoadingStrategy.Companion
            int r1 = r1.m6669getAsyncPKNRLFQ()
            boolean r0 = androidx.compose.ui.text.font.FontLoadingStrategy.m6665equalsimpl0(r0, r1)
            if (r0 == 0) goto L_0x0178
            r1 = r15
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r0 = r15.m6630get1ASDuI8(r2, r3)
            if (r0 != 0) goto L_0x014a
            if (r12 != 0) goto L_0x0146
            r0 = 1
            androidx.compose.ui.text.font.Font[] r0 = new androidx.compose.ui.text.font.Font[r0]
            r0[r10] = r2
            java.util.List r12 = kotlin.collections.CollectionsKt.mutableListOf(r0)
            goto L_0x0174
        L_0x0146:
            r12.add(r2)
            goto L_0x0174
        L_0x014a:
            java.lang.Object r4 = r0.m6638unboximpl()
            boolean r4 = androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult.m6636isPermanentFailureimpl(r4)
            if (r4 == 0) goto L_0x0155
            goto L_0x0174
        L_0x0155:
            java.lang.Object r4 = r0.m6638unboximpl()
            if (r4 == 0) goto L_0x0174
            int r1 = r14.m6732getFontSynthesisGVVA2EU()
            java.lang.Object r0 = r0.m6638unboximpl()
            androidx.compose.ui.text.font.FontWeight r3 = r14.getFontWeight()
            int r4 = r14.m6731getFontStyle_LCdwA()
            java.lang.Object r0 = androidx.compose.ui.text.font.FontSynthesis_androidKt.m6699synthesizeTypefaceFxwP2eA(r1, r0, r2, r3, r4)
            kotlin.Pair r0 = kotlin.TuplesKt.to(r12, r0)
            return r0
        L_0x0174:
            int r11 = r11 + 1
            goto L_0x000a
        L_0x0178:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Unknown font type "
            r1.<init>(r3)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x018d:
            r2 = r17
            java.lang.Object r0 = r2.invoke(r14)
            kotlin.Pair r0 = kotlin.TuplesKt.to(r12, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapterKt.firstImmediatelyAvailable(java.util.List, androidx.compose.ui.text.font.TypefaceRequest, androidx.compose.ui.text.font.AsyncTypefaceCache, androidx.compose.ui.text.font.PlatformFontLoader, kotlin.jvm.functions.Function1):kotlin.Pair");
    }
}
