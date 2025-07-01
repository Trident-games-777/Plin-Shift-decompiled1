package androidx.compose.ui.platform;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.res.ImageVectorCache;
import androidx.compose.ui.res.ResourceIdCache;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a(\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u001a0\u001e¢\u0006\u0002\b\u001fH\u0001¢\u0006\u0002\u0010 \u001a\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002\u001a\u001f\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010\u0002H\u0003¢\u0006\u0002\u0010(\u001a\u0015\u0010)\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u0006H\u0003¢\u0006\u0002\u0010*\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0004\"\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0004\" \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00018FX\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0004\"\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0004\"\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0004\"\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0004¨\u0006+²\u0006\n\u0010'\u001a\u00020\u0002X\u0002"}, d2 = {"LocalConfiguration", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroid/content/res/Configuration;", "getLocalConfiguration", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalContext", "Landroid/content/Context;", "getLocalContext", "LocalImageVectorCache", "Landroidx/compose/ui/res/ImageVectorCache;", "getLocalImageVectorCache", "LocalLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "getLocalLifecycleOwner$annotations", "()V", "getLocalLifecycleOwner", "LocalResourceIdCache", "Landroidx/compose/ui/res/ResourceIdCache;", "getLocalResourceIdCache", "LocalSavedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "getLocalSavedStateRegistryOwner", "LocalView", "Landroid/view/View;", "getLocalView", "ProvideAndroidCompositionLocals", "", "owner", "Landroidx/compose/ui/platform/AndroidComposeView;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "noLocalProvidedFor", "", "name", "", "obtainImageVectorCache", "context", "configuration", "(Landroid/content/Context;Landroid/content/res/Configuration;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/res/ImageVectorCache;", "obtainResourceIdCache", "(Landroid/content/Context;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/res/ResourceIdCache;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidCompositionLocals.android.kt */
public final class AndroidCompositionLocals_androidKt {
    private static final ProvidableCompositionLocal<Configuration> LocalConfiguration = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, AndroidCompositionLocals_androidKt$LocalConfiguration$1.INSTANCE, 1, (Object) null);
    private static final ProvidableCompositionLocal<Context> LocalContext = CompositionLocalKt.staticCompositionLocalOf(AndroidCompositionLocals_androidKt$LocalContext$1.INSTANCE);
    private static final ProvidableCompositionLocal<ImageVectorCache> LocalImageVectorCache = CompositionLocalKt.staticCompositionLocalOf(AndroidCompositionLocals_androidKt$LocalImageVectorCache$1.INSTANCE);
    private static final ProvidableCompositionLocal<ResourceIdCache> LocalResourceIdCache = CompositionLocalKt.staticCompositionLocalOf(AndroidCompositionLocals_androidKt$LocalResourceIdCache$1.INSTANCE);
    private static final ProvidableCompositionLocal<SavedStateRegistryOwner> LocalSavedStateRegistryOwner = CompositionLocalKt.staticCompositionLocalOf(AndroidCompositionLocals_androidKt$LocalSavedStateRegistryOwner$1.INSTANCE);
    private static final ProvidableCompositionLocal<View> LocalView = CompositionLocalKt.staticCompositionLocalOf(AndroidCompositionLocals_androidKt$LocalView$1.INSTANCE);

    @Deprecated(message = "Moved to lifecycle-runtime-compose library in androidx.lifecycle.compose package.", replaceWith = @ReplaceWith(expression = "androidx.lifecycle.compose.LocalLifecycleOwner", imports = {}))
    public static /* synthetic */ void getLocalLifecycleOwner$annotations() {
    }

    public static final ProvidableCompositionLocal<Configuration> getLocalConfiguration() {
        return LocalConfiguration;
    }

    public static final ProvidableCompositionLocal<Context> getLocalContext() {
        return LocalContext;
    }

    public static final ProvidableCompositionLocal<ImageVectorCache> getLocalImageVectorCache() {
        return LocalImageVectorCache;
    }

    public static final ProvidableCompositionLocal<ResourceIdCache> getLocalResourceIdCache() {
        return LocalResourceIdCache;
    }

    public static final ProvidableCompositionLocal<LifecycleOwner> getLocalLifecycleOwner() {
        return LocalLifecycleOwnerKt.getLocalLifecycleOwner();
    }

    public static final ProvidableCompositionLocal<SavedStateRegistryOwner> getLocalSavedStateRegistryOwner() {
        return LocalSavedStateRegistryOwner;
    }

    public static final ProvidableCompositionLocal<View> getLocalView() {
        return LocalView;
    }

    public static final void ProvideAndroidCompositionLocals(AndroidComposeView androidComposeView, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        AndroidComposeView androidComposeView2 = androidComposeView;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(1396852028);
        ComposerKt.sourceInformation(startRestartGroup, "C(ProvideAndroidCompositionLocals)P(1)96@3347L87,100@3476L37,102@3536L39,107@3776L102,110@3906L81,110@3883L104,116@4016L46,117@4089L30,119@4191L7,130@4811L151,120@4236L726:AndroidCompositionLocals.android.kt#itgzvw");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(androidComposeView2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1396852028, i2, -1, "androidx.compose.ui.platform.ProvideAndroidCompositionLocals (AndroidCompositionLocals.android.kt:91)");
            }
            Context context = androidComposeView2.getContext();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1970600807, "CC(remember):AndroidCompositionLocals.android.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new Configuration(context.getResources().getConfiguration()), (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1970596729, "CC(remember):AndroidCompositionLocals.android.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$1$1(mutableState);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            androidComposeView2.setConfigurationChangeObserver((Function1) rememberedValue2);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1970594807, "CC(remember):AndroidCompositionLocals.android.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new AndroidUriHandler(context);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            AndroidUriHandler androidUriHandler = (AndroidUriHandler) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            AndroidComposeView.ViewTreeOwners viewTreeOwners = androidComposeView2.getViewTreeOwners();
            if (viewTreeOwners != null) {
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1970587064, "CC(remember):AndroidCompositionLocals.android.kt#9igjgp");
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                    rememberedValue4 = DisposableSaveableStateRegistry_androidKt.DisposableSaveableStateRegistry((View) androidComposeView2, viewTreeOwners.getSavedStateRegistryOwner());
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                DisposableSaveableStateRegistry disposableSaveableStateRegistry = (DisposableSaveableStateRegistry) rememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1970582925, "CC(remember):AndroidCompositionLocals.android.kt#9igjgp");
                boolean changedInstance = startRestartGroup.changedInstance(disposableSaveableStateRegistry);
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue5 == Composer.Companion.getEmpty()) {
                    rememberedValue5 = new AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$2$1(disposableSaveableStateRegistry);
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                EffectsKt.DisposableEffect((Object) unit, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) (Function1) rememberedValue5, startRestartGroup, 6);
                ImageVectorCache obtainImageVectorCache = obtainImageVectorCache(context, ProvideAndroidCompositionLocals$lambda$1(mutableState), startRestartGroup, 0);
                ResourceIdCache obtainResourceIdCache = obtainResourceIdCache(context, startRestartGroup, 0);
                CompositionLocal localScrollCaptureInProgress = CompositionLocalsKt.getLocalScrollCaptureInProgress();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = startRestartGroup.consume(localScrollCaptureInProgress);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{LocalConfiguration.provides(ProvideAndroidCompositionLocals$lambda$1(mutableState)), LocalContext.provides(context), LocalLifecycleOwnerKt.getLocalLifecycleOwner().provides(viewTreeOwners.getLifecycleOwner()), LocalSavedStateRegistryOwner.provides(viewTreeOwners.getSavedStateRegistryOwner()), SaveableStateRegistryKt.getLocalSaveableStateRegistry().provides(disposableSaveableStateRegistry), LocalView.provides(androidComposeView2.getView()), LocalImageVectorCache.provides(obtainImageVectorCache), LocalResourceIdCache.provides(obtainResourceIdCache), CompositionLocalsKt.getLocalProvidableScrollCaptureInProgress().provides(Boolean.valueOf(((Boolean) consume).booleanValue() | androidComposeView2.getScrollCaptureInProgress$ui_release()))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(1471621628, true, new AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$3(androidComposeView2, androidUriHandler, function22), startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                throw new IllegalStateException("Called when the ViewTreeOwnersAvailability is not yet in Available state");
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$4(androidComposeView2, function22, i3));
        }
    }

    private static final Configuration ProvideAndroidCompositionLocals$lambda$1(MutableState<Configuration> mutableState) {
        return (Configuration) mutableState.getValue();
    }

    private static final ResourceIdCache obtainResourceIdCache(Context context, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1348507246, "C(obtainResourceIdCache)142@5083L30,143@5134L398,158@5571L189,158@5537L223:AndroidCompositionLocals.android.kt#itgzvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1348507246, i, -1, "androidx.compose.ui.platform.obtainResourceIdCache (AndroidCompositionLocals.android.kt:141)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1144662288, "CC(remember):AndroidCompositionLocals.android.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new ResourceIdCache();
            composer.updateRememberedValue(rememberedValue);
        }
        ResourceIdCache resourceIdCache = (ResourceIdCache) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1144664288, "CC(remember):AndroidCompositionLocals.android.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new AndroidCompositionLocals_androidKt$obtainResourceIdCache$callbacks$1$1(resourceIdCache);
            composer.updateRememberedValue(rememberedValue2);
        }
        AndroidCompositionLocals_androidKt$obtainResourceIdCache$callbacks$1$1 androidCompositionLocals_androidKt$obtainResourceIdCache$callbacks$1$1 = (AndroidCompositionLocals_androidKt$obtainResourceIdCache$callbacks$1$1) rememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1144678063, "CC(remember):AndroidCompositionLocals.android.kt#9igjgp");
        boolean changedInstance = composer.changedInstance(context);
        Object rememberedValue3 = composer.rememberedValue();
        if (changedInstance || rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = new AndroidCompositionLocals_androidKt$obtainResourceIdCache$1$1(context, androidCompositionLocals_androidKt$obtainResourceIdCache$callbacks$1$1);
            composer.updateRememberedValue(rememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect((Object) resourceIdCache, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) (Function1) rememberedValue3, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return resourceIdCache;
    }

    private static final ImageVectorCache obtainImageVectorCache(Context context, Configuration configuration, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -485908294, "C(obtainImageVectorCache)P(1)173@5952L31,174@6030L88,177@6139L557,194@6736L189,194@6701L224:AndroidCompositionLocals.android.kt#itgzvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-485908294, i, -1, "androidx.compose.ui.platform.obtainImageVectorCache (AndroidCompositionLocals.android.kt:172)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 674256202, "CC(remember):AndroidCompositionLocals.android.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new ImageVectorCache();
            composer.updateRememberedValue(rememberedValue);
        }
        ImageVectorCache imageVectorCache = (ImageVectorCache) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 674258755, "CC(remember):AndroidCompositionLocals.android.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        Configuration configuration2 = rememberedValue2;
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            Configuration configuration3 = new Configuration();
            if (configuration != null) {
                configuration3.setTo(configuration);
            }
            composer.updateRememberedValue(configuration3);
            configuration2 = configuration3;
        }
        Configuration configuration4 = (Configuration) configuration2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 674262712, "CC(remember):AndroidCompositionLocals.android.kt#9igjgp");
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = new AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1(configuration4, imageVectorCache);
            composer.updateRememberedValue(rememberedValue3);
        }
        AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1 androidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1 = (AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1) rememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 674281448, "CC(remember):AndroidCompositionLocals.android.kt#9igjgp");
        boolean changedInstance = composer.changedInstance(context);
        Object rememberedValue4 = composer.rememberedValue();
        if (changedInstance || rememberedValue4 == Composer.Companion.getEmpty()) {
            rememberedValue4 = new AndroidCompositionLocals_androidKt$obtainImageVectorCache$1$1(context, androidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1);
            composer.updateRememberedValue(rememberedValue4);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect((Object) imageVectorCache, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) (Function1) rememberedValue4, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return imageVectorCache;
    }

    /* access modifiers changed from: private */
    public static final Void noLocalProvidedFor(String str) {
        throw new IllegalStateException(("CompositionLocal " + str + " not present").toString());
    }

    /* access modifiers changed from: private */
    public static final void ProvideAndroidCompositionLocals$lambda$2(MutableState<Configuration> mutableState, Configuration configuration) {
        mutableState.setValue(configuration);
    }
}
