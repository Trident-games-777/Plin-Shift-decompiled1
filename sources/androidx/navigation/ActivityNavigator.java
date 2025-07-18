package androidx.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.navigation.Navigator;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0017\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0016\u0017\u0018B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u0002H\u0016J0\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0013\u0010\u0003\u001a\u00020\u00048\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/navigation/ActivityNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/ActivityNavigator$Destination;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "hostActivity", "Landroid/app/Activity;", "createDestination", "navigate", "Landroidx/navigation/NavDestination;", "destination", "args", "Landroid/os/Bundle;", "navOptions", "Landroidx/navigation/NavOptions;", "navigatorExtras", "Landroidx/navigation/Navigator$Extras;", "popBackStack", "", "Companion", "Destination", "Extras", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Navigator.Name("activity")
/* compiled from: ActivityNavigator.kt */
public class ActivityNavigator extends Navigator<Destination> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_NAV_CURRENT = "android-support-navigation:ActivityNavigator:current";
    private static final String EXTRA_NAV_SOURCE = "android-support-navigation:ActivityNavigator:source";
    private static final String EXTRA_POP_ENTER_ANIM = "android-support-navigation:ActivityNavigator:popEnterAnim";
    private static final String EXTRA_POP_EXIT_ANIM = "android-support-navigation:ActivityNavigator:popExitAnim";
    private static final String LOG_TAG = "ActivityNavigator";
    private final Context context;
    private final Activity hostActivity;

    @JvmStatic
    public static final void applyPopAnimationsToPendingTransition(Activity activity) {
        Companion.applyPopAnimationsToPendingTransition(activity);
    }

    public final Context getContext() {
        return this.context;
    }

    public ActivityNavigator(Context context2) {
        Object obj;
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        Iterator it = SequencesKt.generateSequence(context2, ActivityNavigator$hostActivity$1.INSTANCE).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Context) obj) instanceof Activity) {
                break;
            }
        }
        this.hostActivity = (Activity) obj;
    }

    public Destination createDestination() {
        return new Destination((Navigator<? extends Destination>) this);
    }

    public boolean popBackStack() {
        Activity activity = this.hostActivity;
        if (activity == null) {
            return false;
        }
        activity.finish();
        return true;
    }

    public NavDestination navigate(Destination destination, Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        Intent intent;
        int intExtra;
        String str;
        Intrinsics.checkNotNullParameter(destination, FirebaseAnalytics.Param.DESTINATION);
        if (destination.getIntent() != null) {
            Intent intent2 = new Intent(destination.getIntent());
            if (bundle != null) {
                intent2.putExtras(bundle);
                String dataPattern = destination.getDataPattern();
                CharSequence charSequence = dataPattern;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(charSequence);
                    while (matcher.find()) {
                        String group = matcher.group(1);
                        if (bundle.containsKey(group)) {
                            matcher.appendReplacement(stringBuffer, "");
                            Map<String, NavArgument> arguments = destination.getArguments();
                            Intrinsics.checkNotNull(group);
                            NavArgument navArgument = arguments.get(group);
                            NavType<Object> type = navArgument != null ? navArgument.getType() : null;
                            if (type == null || (str = type.serializeAsValue(type.get(bundle, group))) == null) {
                                str = Uri.encode(String.valueOf(bundle.get(group)));
                            }
                            stringBuffer.append(str);
                        } else {
                            throw new IllegalArgumentException(("Could not find " + group + " in " + bundle + " to fill data pattern " + dataPattern).toString());
                        }
                    }
                    matcher.appendTail(stringBuffer);
                    intent2.setData(Uri.parse(stringBuffer.toString()));
                }
            }
            boolean z = extras instanceof Extras;
            if (z) {
                intent2.addFlags(((Extras) extras).getFlags());
            }
            if (this.hostActivity == null) {
                intent2.addFlags(268435456);
            }
            if (navOptions != null && navOptions.shouldLaunchSingleTop()) {
                intent2.addFlags(536870912);
            }
            Activity activity = this.hostActivity;
            if (!(activity == null || (intent = activity.getIntent()) == null || (intExtra = intent.getIntExtra(EXTRA_NAV_CURRENT, 0)) == 0)) {
                intent2.putExtra(EXTRA_NAV_SOURCE, intExtra);
            }
            intent2.putExtra(EXTRA_NAV_CURRENT, destination.getId());
            Resources resources = this.context.getResources();
            if (navOptions != null) {
                int popEnterAnim = navOptions.getPopEnterAnim();
                int popExitAnim = navOptions.getPopExitAnim();
                if ((popEnterAnim <= 0 || !Intrinsics.areEqual((Object) resources.getResourceTypeName(popEnterAnim), (Object) "animator")) && (popExitAnim <= 0 || !Intrinsics.areEqual((Object) resources.getResourceTypeName(popExitAnim), (Object) "animator"))) {
                    intent2.putExtra(EXTRA_POP_ENTER_ANIM, popEnterAnim);
                    intent2.putExtra(EXTRA_POP_EXIT_ANIM, popExitAnim);
                } else {
                    Log.w(LOG_TAG, "Activity destinations do not support Animator resource. Ignoring popEnter resource " + resources.getResourceName(popEnterAnim) + " and popExit resource " + resources.getResourceName(popExitAnim) + " when launching " + destination);
                }
            }
            if (z) {
                ActivityOptionsCompat activityOptions = ((Extras) extras).getActivityOptions();
                if (activityOptions != null) {
                    ActivityCompat.startActivity(this.context, intent2, activityOptions.toBundle());
                } else {
                    this.context.startActivity(intent2);
                }
            } else {
                this.context.startActivity(intent2);
            }
            if (!(navOptions == null || this.hostActivity == null)) {
                int enterAnim = navOptions.getEnterAnim();
                int exitAnim = navOptions.getExitAnim();
                if ((enterAnim > 0 && Intrinsics.areEqual((Object) resources.getResourceTypeName(enterAnim), (Object) "animator")) || (exitAnim > 0 && Intrinsics.areEqual((Object) resources.getResourceTypeName(exitAnim), (Object) "animator"))) {
                    Log.w(LOG_TAG, "Activity destinations do not support Animator resource. Ignoring enter resource " + resources.getResourceName(enterAnim) + " and exit resource " + resources.getResourceName(exitAnim) + "when launching " + destination);
                } else if (enterAnim >= 0 || exitAnim >= 0) {
                    this.hostActivity.overridePendingTransition(RangesKt.coerceAtLeast(enterAnim, 0), RangesKt.coerceAtLeast(exitAnim, 0));
                }
            }
            return null;
        }
        throw new IllegalStateException(("Destination " + destination.getId() + " does not have an Intent set.").toString());
    }

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0017\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\b\u0010!\u001a\u00020\"H\u0016J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0017J\u001c\u0010)\u001a\u0004\u0018\u00010\t2\u0006\u0010%\u001a\u00020&2\b\u0010*\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010+\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010,\u001a\u00020\u00002\b\u0010-\u001a\u0004\u0018\u00010\rJ\u0010\u0010.\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0010\u0010/\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\tJ\u0010\u00100\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u0010\u00101\u001a\u00020\u00002\b\u00102\u001a\u0004\u0018\u00010\tJ\b\u00103\u001a\u00020\u001eH\u0017J\b\u00104\u001a\u00020\tH\u0016R$\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\r8F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u00118F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\fR\"\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\b\u001a\u0004\u0018\u00010\u0017@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\f¨\u00065"}, d2 = {"Landroidx/navigation/ActivityNavigator$Destination;", "Landroidx/navigation/NavDestination;", "navigatorProvider", "Landroidx/navigation/NavigatorProvider;", "(Landroidx/navigation/NavigatorProvider;)V", "activityNavigator", "Landroidx/navigation/Navigator;", "(Landroidx/navigation/Navigator;)V", "<set-?>", "", "action", "getAction", "()Ljava/lang/String;", "Landroid/content/ComponentName;", "component", "getComponent", "()Landroid/content/ComponentName;", "Landroid/net/Uri;", "data", "getData", "()Landroid/net/Uri;", "dataPattern", "getDataPattern", "Landroid/content/Intent;", "intent", "getIntent", "()Landroid/content/Intent;", "targetPackage", "getTargetPackage", "equals", "", "other", "", "hashCode", "", "onInflate", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "parseApplicationId", "pattern", "setAction", "setComponentName", "name", "setData", "setDataPattern", "setIntent", "setTargetPackage", "packageName", "supportsActions", "toString", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ActivityNavigator.kt */
    public static class Destination extends NavDestination {
        private String action;
        private ComponentName component;
        private Uri data;
        private String dataPattern;
        private Intent intent;
        private String targetPackage;

        public boolean supportsActions() {
            return false;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Destination(Navigator<? extends Destination> navigator) {
            super((Navigator<? extends NavDestination>) navigator);
            Intrinsics.checkNotNullParameter(navigator, "activityNavigator");
        }

        public final Intent getIntent() {
            return this.intent;
        }

        public final String getDataPattern() {
            return this.dataPattern;
        }

        public final Destination setIntent(Intent intent2) {
            this.intent = intent2;
            return this;
        }

        public final Destination setDataPattern(String str) {
            this.dataPattern = str;
            return this;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Destination(NavigatorProvider navigatorProvider) {
            this((Navigator<? extends Destination>) navigatorProvider.getNavigator(ActivityNavigator.class));
            Intrinsics.checkNotNullParameter(navigatorProvider, "navigatorProvider");
        }

        public void onInflate(Context context, AttributeSet attributeSet) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attributeSet, "attrs");
            super.onInflate(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.ActivityNavigator);
            Intrinsics.checkNotNullExpressionValue(obtainAttributes, "context.resources.obtain…leable.ActivityNavigator)");
            setTargetPackage(parseApplicationId(context, obtainAttributes.getString(R.styleable.ActivityNavigator_targetPackage)));
            String string = obtainAttributes.getString(R.styleable.ActivityNavigator_android_name);
            if (string != null) {
                if (string.charAt(0) == '.') {
                    string = context.getPackageName() + string;
                }
                setComponentName(new ComponentName(context, string));
            }
            setAction(obtainAttributes.getString(R.styleable.ActivityNavigator_action));
            String parseApplicationId = parseApplicationId(context, obtainAttributes.getString(R.styleable.ActivityNavigator_data));
            if (parseApplicationId != null) {
                setData(Uri.parse(parseApplicationId));
            }
            setDataPattern(parseApplicationId(context, obtainAttributes.getString(R.styleable.ActivityNavigator_dataPattern)));
            obtainAttributes.recycle();
        }

        private final String parseApplicationId(Context context, String str) {
            if (str == null) {
                return null;
            }
            String packageName = context.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
            return StringsKt.replace$default(str, NavInflater.APPLICATION_ID_PLACEHOLDER, packageName, false, 4, (Object) null);
        }

        public final String getTargetPackage() {
            Intent intent2 = this.intent;
            if (intent2 != null) {
                return intent2.getPackage();
            }
            return null;
        }

        public final Destination setTargetPackage(String str) {
            if (this.intent == null) {
                this.intent = new Intent();
            }
            Intent intent2 = this.intent;
            Intrinsics.checkNotNull(intent2);
            intent2.setPackage(str);
            return this;
        }

        public final ComponentName getComponent() {
            Intent intent2 = this.intent;
            if (intent2 != null) {
                return intent2.getComponent();
            }
            return null;
        }

        public final Destination setComponentName(ComponentName componentName) {
            if (this.intent == null) {
                this.intent = new Intent();
            }
            Intent intent2 = this.intent;
            Intrinsics.checkNotNull(intent2);
            intent2.setComponent(componentName);
            return this;
        }

        public final String getAction() {
            Intent intent2 = this.intent;
            if (intent2 != null) {
                return intent2.getAction();
            }
            return null;
        }

        public final Destination setAction(String str) {
            if (this.intent == null) {
                this.intent = new Intent();
            }
            Intent intent2 = this.intent;
            Intrinsics.checkNotNull(intent2);
            intent2.setAction(str);
            return this;
        }

        public final Uri getData() {
            Intent intent2 = this.intent;
            if (intent2 != null) {
                return intent2.getData();
            }
            return null;
        }

        public final Destination setData(Uri uri) {
            if (this.intent == null) {
                this.intent = new Intent();
            }
            Intent intent2 = this.intent;
            Intrinsics.checkNotNull(intent2);
            intent2.setData(uri);
            return this;
        }

        public String toString() {
            ComponentName component2 = getComponent();
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            if (component2 != null) {
                sb.append(" class=");
                sb.append(component2.getClassName());
            } else {
                String action2 = getAction();
                if (action2 != null) {
                    sb.append(" action=");
                    sb.append(action2);
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
            return sb2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && (obj instanceof Destination) && super.equals(obj)) {
                Intent intent2 = this.intent;
                return (intent2 != null ? intent2.filterEquals(((Destination) obj).intent) : ((Destination) obj).intent == null) && Intrinsics.areEqual((Object) this.dataPattern, (Object) ((Destination) obj).dataPattern);
            }
        }

        public int hashCode() {
            int hashCode = super.hashCode() * 31;
            Intent intent2 = this.intent;
            int i = 0;
            int filterHashCode = (hashCode + (intent2 != null ? intent2.filterHashCode() : 0)) * 31;
            String str = this.dataPattern;
            if (str != null) {
                i = str.hashCode();
            }
            return filterHashCode + i;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000bB\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Landroidx/navigation/ActivityNavigator$Extras;", "Landroidx/navigation/Navigator$Extras;", "flags", "", "activityOptions", "Landroidx/core/app/ActivityOptionsCompat;", "(ILandroidx/core/app/ActivityOptionsCompat;)V", "getActivityOptions", "()Landroidx/core/app/ActivityOptionsCompat;", "getFlags", "()I", "Builder", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ActivityNavigator.kt */
    public static final class Extras implements Navigator.Extras {
        private final ActivityOptionsCompat activityOptions;
        private final int flags;

        public Extras(int i, ActivityOptionsCompat activityOptionsCompat) {
            this.flags = i;
            this.activityOptions = activityOptionsCompat;
        }

        public final int getFlags() {
            return this.flags;
        }

        public final ActivityOptionsCompat getActivityOptions() {
            return this.activityOptions;
        }

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/navigation/ActivityNavigator$Extras$Builder;", "", "()V", "activityOptions", "Landroidx/core/app/ActivityOptionsCompat;", "flags", "", "addFlags", "build", "Landroidx/navigation/ActivityNavigator$Extras;", "setActivityOptions", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: ActivityNavigator.kt */
        public static final class Builder {
            private ActivityOptionsCompat activityOptions;
            private int flags;

            public final Builder addFlags(int i) {
                this.flags = i | this.flags;
                return this;
            }

            public final Builder setActivityOptions(ActivityOptionsCompat activityOptionsCompat) {
                Intrinsics.checkNotNullParameter(activityOptionsCompat, "activityOptions");
                this.activityOptions = activityOptionsCompat;
                return this;
            }

            public final Extras build() {
                return new Extras(this.flags, this.activityOptions);
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/navigation/ActivityNavigator$Companion;", "", "()V", "EXTRA_NAV_CURRENT", "", "EXTRA_NAV_SOURCE", "EXTRA_POP_ENTER_ANIM", "EXTRA_POP_EXIT_ANIM", "LOG_TAG", "applyPopAnimationsToPendingTransition", "", "activity", "Landroid/app/Activity;", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ActivityNavigator.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void applyPopAnimationsToPendingTransition(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intent intent = activity.getIntent();
            if (intent != null) {
                int intExtra = intent.getIntExtra(ActivityNavigator.EXTRA_POP_ENTER_ANIM, -1);
                int intExtra2 = intent.getIntExtra(ActivityNavigator.EXTRA_POP_EXIT_ANIM, -1);
                if (intExtra != -1 || intExtra2 != -1) {
                    if (intExtra == -1) {
                        intExtra = 0;
                    }
                    if (intExtra2 == -1) {
                        intExtra2 = 0;
                    }
                    activity.overridePendingTransition(intExtra, intExtra2);
                }
            }
        }
    }
}
