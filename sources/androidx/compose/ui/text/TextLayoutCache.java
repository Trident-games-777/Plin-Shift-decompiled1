package androidx.compose.ui.text;

import androidx.compose.ui.text.caches.LruCache;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bR\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/TextLayoutCache;", "", "capacity", "", "(I)V", "lruCache", "Landroidx/compose/ui/text/caches/LruCache;", "Landroidx/compose/ui/text/CacheTextLayoutInput;", "Landroidx/compose/ui/text/TextLayoutResult;", "get", "key", "Landroidx/compose/ui/text/TextLayoutInput;", "put", "value", "remove", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextMeasurer.kt */
public final class TextLayoutCache {
    public static final int $stable = 8;
    private final LruCache<CacheTextLayoutInput, TextLayoutResult> lruCache;

    public TextLayoutCache() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public TextLayoutCache(int i) {
        this.lruCache = new LruCache<>(i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextLayoutCache(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? TextMeasurerKt.DefaultCacheSize : i);
    }

    public final TextLayoutResult get(TextLayoutInput textLayoutInput) {
        TextLayoutResult textLayoutResult = this.lruCache.get(new CacheTextLayoutInput(textLayoutInput));
        if (textLayoutResult != null && !textLayoutResult.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts()) {
            return textLayoutResult;
        }
        return null;
    }

    public final TextLayoutResult put(TextLayoutInput textLayoutInput, TextLayoutResult textLayoutResult) {
        return this.lruCache.put(new CacheTextLayoutInput(textLayoutInput), textLayoutResult);
    }

    public final TextLayoutResult remove(TextLayoutInput textLayoutInput) {
        return this.lruCache.remove(new CacheTextLayoutInput(textLayoutInput));
    }
}
