package androidx.navigation.serialization;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleKt;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0005¢\u0006\u0002\u0010\bB'\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0005¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J#\u0010 \u001a\u0002H!\"\u0004\b\u0000\u0010!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H!0#H\u0000¢\u0006\u0004\b$\u0010%J!\u0010&\u001a\u0002H!\"\u0004\b\u0000\u0010!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H!0#H\u0016¢\u0006\u0002\u0010%J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020(H\u0002R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Landroidx/navigation/serialization/RouteDecoder;", "Lkotlinx/serialization/encoding/AbstractDecoder;", "bundle", "Landroid/os/Bundle;", "typeMap", "", "", "Landroidx/navigation/NavType;", "(Landroid/os/Bundle;Ljava/util/Map;)V", "handle", "Landroidx/lifecycle/SavedStateHandle;", "(Landroidx/lifecycle/SavedStateHandle;Ljava/util/Map;)V", "elementIndex", "", "elementName", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule$annotations", "()V", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "store", "Landroidx/navigation/serialization/ArgStore;", "decodeElementIndex", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "decodeInline", "Lkotlinx/serialization/encoding/Decoder;", "decodeNotNullMark", "", "decodeNull", "", "decodeRouteWithArgs", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "decodeRouteWithArgs$navigation_common_release", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeSerializableValue", "decodeValue", "", "internalDecodeValue", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RouteDecoder.kt */
public final class RouteDecoder extends AbstractDecoder {
    private int elementIndex = -1;
    private String elementName = "";
    private final SerializersModule serializersModule = SerializersModuleKt.getEmptySerializersModule();
    private final ArgStore store;

    public static /* synthetic */ void getSerializersModule$annotations() {
    }

    public Void decodeNull() {
        return null;
    }

    public RouteDecoder(Bundle bundle, Map<String, ? extends NavType<?>> map) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(map, "typeMap");
        this.store = new BundleArgStore(bundle, map);
    }

    public RouteDecoder(SavedStateHandle savedStateHandle, Map<String, ? extends NavType<?>> map) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "handle");
        Intrinsics.checkNotNullParameter(map, "typeMap");
        this.store = new SavedStateArgStore(savedStateHandle, map);
    }

    public SerializersModule getSerializersModule() {
        return this.serializersModule;
    }

    public int decodeElementIndex(SerialDescriptor serialDescriptor) {
        String elementName2;
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        int i = this.elementIndex;
        do {
            i++;
            if (i >= serialDescriptor.getElementsCount()) {
                return -1;
            }
            elementName2 = serialDescriptor.getElementName(i);
        } while (!this.store.contains(elementName2));
        this.elementIndex = i;
        this.elementName = elementName2;
        return i;
    }

    public Object decodeValue() {
        return internalDecodeValue();
    }

    public boolean decodeNotNullMark() {
        return this.store.get(this.elementName) != null;
    }

    public Decoder decodeInline(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (RouteSerializerKt.isValueClass(serialDescriptor)) {
            this.elementName = serialDescriptor.getElementName(0);
            this.elementIndex = 0;
        }
        return super.decodeInline(serialDescriptor);
    }

    public final <T> T decodeRouteWithArgs$navigation_common_release(DeserializationStrategy<? extends T> deserializationStrategy) {
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        return super.decodeSerializableValue(deserializationStrategy);
    }

    public <T> T decodeSerializableValue(DeserializationStrategy<? extends T> deserializationStrategy) {
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        return internalDecodeValue();
    }

    private final Object internalDecodeValue() {
        Object obj = this.store.get(this.elementName);
        if (obj != null) {
            return obj;
        }
        throw new IllegalStateException(("Unexpected null value for non-nullable argument " + this.elementName).toString());
    }
}
