package kotlinx.serialization.internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlinx.serialization.InternalSerializationApi;

@Target({ElementType.TYPE})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lkotlinx/serialization/internal/NamedCompanion;", "", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Retention(AnnotationRetention.RUNTIME)
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
@InternalSerializationApi
/* compiled from: NamedCompanion.kt */
public @interface NamedCompanion {
}
