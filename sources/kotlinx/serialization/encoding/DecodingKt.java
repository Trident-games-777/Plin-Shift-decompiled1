package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1 = {"\u00000\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aA\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0007H\bø\u0001\u0000¢\u0006\u0002\u0010\b\u001a>\u0010\t\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\u00010\f¢\u0006\u0002\b\u000eH\bø\u0001\u0000¢\u0006\u0002\u0010\u000f\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0010"}, d2 = {"decodeIfNullable", "T", "", "Lkotlinx/serialization/encoding/Decoder;", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "block", "Lkotlin/Function0;", "(Lkotlinx/serialization/encoding/Decoder;Lkotlinx/serialization/DeserializationStrategy;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "decodeStructure", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlin/Function1;", "Lkotlinx/serialization/encoding/CompositeDecoder;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/serialization/encoding/Decoder;Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: Decoding.kt */
public final class DecodingKt {
    public static final <T> T decodeIfNullable(Decoder decoder, DeserializationStrategy<? extends T> deserializationStrategy, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(decoder, "<this>");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        Intrinsics.checkNotNullParameter(function0, "block");
        return (deserializationStrategy.getDescriptor().isNullable() || decoder.decodeNotNullMark()) ? function0.invoke() : decoder.decodeNull();
    }

    public static final <T> T decodeStructure(Decoder decoder, SerialDescriptor serialDescriptor, Function1<? super CompositeDecoder, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(decoder, "<this>");
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(function1, "block");
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        T invoke = function1.invoke(beginStructure);
        beginStructure.endStructure(serialDescriptor);
        return invoke;
    }
}
