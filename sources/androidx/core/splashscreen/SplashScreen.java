package androidx.core.splashscreen;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.ImageView;
import android.window.SplashScreenView;
import androidx.core.splashscreen.ThemeUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0005\u000f\u0010\u0011\u0012\u0013B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/core/splashscreen/SplashScreen;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "impl", "Landroidx/core/splashscreen/SplashScreen$Impl;", "install", "", "setKeepOnScreenCondition", "condition", "Landroidx/core/splashscreen/SplashScreen$KeepOnScreenCondition;", "setOnExitAnimationListener", "listener", "Landroidx/core/splashscreen/SplashScreen$OnExitAnimationListener;", "Companion", "Impl", "Impl31", "KeepOnScreenCondition", "OnExitAnimationListener", "core-splashscreen_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SplashScreen.kt */
public final class SplashScreen {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float MASK_FACTOR = 0.6666667f;
    private final Impl impl;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'¨\u0006\u0004"}, d2 = {"Landroidx/core/splashscreen/SplashScreen$KeepOnScreenCondition;", "", "shouldKeepOnScreen", "", "core-splashscreen_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SplashScreen.kt */
    public interface KeepOnScreenCondition {
        boolean shouldKeepOnScreen();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Landroidx/core/splashscreen/SplashScreen$OnExitAnimationListener;", "", "onSplashScreenExit", "", "splashScreenViewProvider", "Landroidx/core/splashscreen/SplashScreenViewProvider;", "core-splashscreen_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SplashScreen.kt */
    public interface OnExitAnimationListener {
        void onSplashScreenExit(SplashScreenViewProvider splashScreenViewProvider);
    }

    public /* synthetic */ SplashScreen(Activity activity, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity);
    }

    @JvmStatic
    public static final SplashScreen installSplashScreen(Activity activity) {
        return Companion.installSplashScreen(activity);
    }

    private SplashScreen(Activity activity) {
        Impl impl2;
        if (Build.VERSION.SDK_INT >= 31) {
            impl2 = new Impl31(activity);
        } else {
            impl2 = new Impl(activity);
        }
        this.impl = impl2;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/core/splashscreen/SplashScreen$Companion;", "", "()V", "MASK_FACTOR", "", "installSplashScreen", "Landroidx/core/splashscreen/SplashScreen;", "Landroid/app/Activity;", "core-splashscreen_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SplashScreen.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SplashScreen installSplashScreen(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "<this>");
            SplashScreen splashScreen = new SplashScreen(activity, (DefaultConstructorMarker) null);
            splashScreen.install();
            return splashScreen;
        }
    }

    public final void setKeepOnScreenCondition(KeepOnScreenCondition keepOnScreenCondition) {
        Intrinsics.checkNotNullParameter(keepOnScreenCondition, "condition");
        this.impl.setKeepOnScreenCondition(keepOnScreenCondition);
    }

    public final void setOnExitAnimationListener(OnExitAnimationListener onExitAnimationListener) {
        Intrinsics.checkNotNullParameter(onExitAnimationListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.impl.setOnExitAnimationListener(onExitAnimationListener);
    }

    /* access modifiers changed from: private */
    public final void install() {
        this.impl.install();
    }

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0012\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020%J\u0018\u0010/\u001a\u00020-2\u0006\u00100\u001a\u0002012\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u00102\u001a\u00020-H\u0016J\u0010\u00103\u001a\u00020-2\u0006\u00104\u001a\u00020'H\u0016J\u0010\u00105\u001a\u00020-2\u0006\u00106\u001a\u00020\bH\u0016J\u001c\u00107\u001a\u00020-2\n\u00108\u001a\u000609R\u00020:2\u0006\u0010;\u001a\u00020<H\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006="}, d2 = {"Landroidx/core/splashscreen/SplashScreen$Impl;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "animationListener", "Landroidx/core/splashscreen/SplashScreen$OnExitAnimationListener;", "backgroundColor", "", "getBackgroundColor", "()Ljava/lang/Integer;", "setBackgroundColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "backgroundResId", "getBackgroundResId", "setBackgroundResId", "finalThemeId", "getFinalThemeId", "()I", "setFinalThemeId", "(I)V", "hasBackground", "", "getHasBackground", "()Z", "setHasBackground", "(Z)V", "icon", "Landroid/graphics/drawable/Drawable;", "getIcon", "()Landroid/graphics/drawable/Drawable;", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "mSplashScreenViewProvider", "Landroidx/core/splashscreen/SplashScreenViewProvider;", "splashScreenWaitPredicate", "Landroidx/core/splashscreen/SplashScreen$KeepOnScreenCondition;", "getSplashScreenWaitPredicate", "()Landroidx/core/splashscreen/SplashScreen$KeepOnScreenCondition;", "setSplashScreenWaitPredicate", "(Landroidx/core/splashscreen/SplashScreen$KeepOnScreenCondition;)V", "dispatchOnExitAnimation", "", "splashScreenViewProvider", "displaySplashScreenIcon", "splashScreenView", "Landroid/view/View;", "install", "setKeepOnScreenCondition", "keepOnScreenCondition", "setOnExitAnimationListener", "exitAnimationListener", "setPostSplashScreenTheme", "currentTheme", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "typedValue", "Landroid/util/TypedValue;", "core-splashscreen_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SplashScreen.kt */
    private static class Impl {
        private final Activity activity;
        private OnExitAnimationListener animationListener;
        private Integer backgroundColor;
        private Integer backgroundResId;
        private int finalThemeId;
        private boolean hasBackground;
        private Drawable icon;
        /* access modifiers changed from: private */
        public SplashScreenViewProvider mSplashScreenViewProvider;
        private KeepOnScreenCondition splashScreenWaitPredicate = new SplashScreen$Impl$$ExternalSyntheticLambda0();

        /* access modifiers changed from: private */
        /* renamed from: splashScreenWaitPredicate$lambda-0  reason: not valid java name */
        public static final boolean m7402splashScreenWaitPredicate$lambda0() {
            return false;
        }

        public Impl(Activity activity2) {
            Intrinsics.checkNotNullParameter(activity2, "activity");
            this.activity = activity2;
        }

        public final Activity getActivity() {
            return this.activity;
        }

        public final int getFinalThemeId() {
            return this.finalThemeId;
        }

        public final void setFinalThemeId(int i) {
            this.finalThemeId = i;
        }

        public final Integer getBackgroundResId() {
            return this.backgroundResId;
        }

        public final void setBackgroundResId(Integer num) {
            this.backgroundResId = num;
        }

        public final Integer getBackgroundColor() {
            return this.backgroundColor;
        }

        public final void setBackgroundColor(Integer num) {
            this.backgroundColor = num;
        }

        public final Drawable getIcon() {
            return this.icon;
        }

        public final void setIcon(Drawable drawable) {
            this.icon = drawable;
        }

        public final boolean getHasBackground() {
            return this.hasBackground;
        }

        public final void setHasBackground(boolean z) {
            this.hasBackground = z;
        }

        public final KeepOnScreenCondition getSplashScreenWaitPredicate() {
            return this.splashScreenWaitPredicate;
        }

        public final void setSplashScreenWaitPredicate(KeepOnScreenCondition keepOnScreenCondition) {
            Intrinsics.checkNotNullParameter(keepOnScreenCondition, "<set-?>");
            this.splashScreenWaitPredicate = keepOnScreenCondition;
        }

        public void install() {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = this.activity.getTheme();
            boolean z = true;
            if (theme.resolveAttribute(R.attr.windowSplashScreenBackground, typedValue, true)) {
                this.backgroundResId = Integer.valueOf(typedValue.resourceId);
                this.backgroundColor = Integer.valueOf(typedValue.data);
            }
            if (theme.resolveAttribute(R.attr.windowSplashScreenAnimatedIcon, typedValue, true)) {
                this.icon = theme.getDrawable(typedValue.resourceId);
            }
            if (theme.resolveAttribute(R.attr.splashScreenIconSize, typedValue, true)) {
                if (typedValue.resourceId != R.dimen.splashscreen_icon_size_with_background) {
                    z = false;
                }
                this.hasBackground = z;
            }
            Intrinsics.checkNotNullExpressionValue(theme, "currentTheme");
            setPostSplashScreenTheme(theme, typedValue);
        }

        /* access modifiers changed from: protected */
        public final void setPostSplashScreenTheme(Resources.Theme theme, TypedValue typedValue) {
            Intrinsics.checkNotNullParameter(theme, "currentTheme");
            Intrinsics.checkNotNullParameter(typedValue, "typedValue");
            if (theme.resolveAttribute(R.attr.postSplashScreenTheme, typedValue, true)) {
                int i = typedValue.resourceId;
                this.finalThemeId = i;
                if (i != 0) {
                    this.activity.setTheme(i);
                }
            }
        }

        public void setKeepOnScreenCondition(KeepOnScreenCondition keepOnScreenCondition) {
            Intrinsics.checkNotNullParameter(keepOnScreenCondition, "keepOnScreenCondition");
            this.splashScreenWaitPredicate = keepOnScreenCondition;
            View findViewById = this.activity.findViewById(16908290);
            findViewById.getViewTreeObserver().addOnPreDrawListener(new SplashScreen$Impl$setKeepOnScreenCondition$1(this, findViewById));
        }

        public void setOnExitAnimationListener(OnExitAnimationListener onExitAnimationListener) {
            Intrinsics.checkNotNullParameter(onExitAnimationListener, "exitAnimationListener");
            this.animationListener = onExitAnimationListener;
            SplashScreenViewProvider splashScreenViewProvider = new SplashScreenViewProvider(this.activity);
            Integer num = this.backgroundResId;
            Integer num2 = this.backgroundColor;
            View view = splashScreenViewProvider.getView();
            if (num != null && num.intValue() != 0) {
                view.setBackgroundResource(num.intValue());
            } else if (num2 != null) {
                view.setBackgroundColor(num2.intValue());
            } else {
                view.setBackground(this.activity.getWindow().getDecorView().getBackground());
            }
            Drawable drawable = this.icon;
            if (drawable != null) {
                displaySplashScreenIcon(view, drawable);
            }
            view.addOnLayoutChangeListener(new SplashScreen$Impl$setOnExitAnimationListener$2(this, splashScreenViewProvider));
        }

        private final void displaySplashScreenIcon(View view, Drawable drawable) {
            float f;
            ImageView imageView = (ImageView) view.findViewById(R.id.splashscreen_icon_view);
            if (this.hasBackground) {
                Drawable drawable2 = imageView.getContext().getDrawable(R.drawable.icon_background);
                f = imageView.getResources().getDimension(R.dimen.splashscreen_icon_size_with_background) * SplashScreen.MASK_FACTOR;
                if (drawable2 != null) {
                    imageView.setBackground(new MaskedDrawable(drawable2, f));
                }
            } else {
                f = imageView.getResources().getDimension(R.dimen.splashscreen_icon_size_no_background) * SplashScreen.MASK_FACTOR;
            }
            imageView.setImageDrawable(new MaskedDrawable(drawable, f));
        }

        public final void dispatchOnExitAnimation(SplashScreenViewProvider splashScreenViewProvider) {
            Intrinsics.checkNotNullParameter(splashScreenViewProvider, "splashScreenViewProvider");
            OnExitAnimationListener onExitAnimationListener = this.animationListener;
            if (onExitAnimationListener != null) {
                this.animationListener = null;
                splashScreenViewProvider.getView().postOnAnimation(new SplashScreen$Impl$$ExternalSyntheticLambda1(splashScreenViewProvider, onExitAnimationListener));
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: dispatchOnExitAnimation$lambda-3  reason: not valid java name */
        public static final void m7401dispatchOnExitAnimation$lambda3(SplashScreenViewProvider splashScreenViewProvider, OnExitAnimationListener onExitAnimationListener) {
            Intrinsics.checkNotNullParameter(splashScreenViewProvider, "$splashScreenViewProvider");
            Intrinsics.checkNotNullParameter(onExitAnimationListener, "$finalListener");
            splashScreenViewProvider.getView().bringToFront();
            onExitAnimationListener.onSplashScreenExit(splashScreenViewProvider);
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u000e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Landroidx/core/splashscreen/SplashScreen$Impl31;", "Landroidx/core/splashscreen/SplashScreen$Impl;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "hierarchyListener", "Landroid/view/ViewGroup$OnHierarchyChangeListener;", "getHierarchyListener", "()Landroid/view/ViewGroup$OnHierarchyChangeListener;", "mDecorFitWindowInsets", "", "getMDecorFitWindowInsets", "()Z", "setMDecorFitWindowInsets", "(Z)V", "preDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "getPreDrawListener", "()Landroid/view/ViewTreeObserver$OnPreDrawListener;", "setPreDrawListener", "(Landroid/view/ViewTreeObserver$OnPreDrawListener;)V", "applyAppSystemUiTheme", "", "computeDecorFitsWindow", "child", "Landroid/window/SplashScreenView;", "install", "setKeepOnScreenCondition", "keepOnScreenCondition", "Landroidx/core/splashscreen/SplashScreen$KeepOnScreenCondition;", "setOnExitAnimationListener", "exitAnimationListener", "Landroidx/core/splashscreen/SplashScreen$OnExitAnimationListener;", "core-splashscreen_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SplashScreen.kt */
    private static final class Impl31 extends Impl {
        private final ViewGroup.OnHierarchyChangeListener hierarchyListener;
        private boolean mDecorFitWindowInsets = true;
        private ViewTreeObserver.OnPreDrawListener preDrawListener;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Impl31(Activity activity) {
            super(activity);
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.hierarchyListener = new SplashScreen$Impl31$hierarchyListener$1(this, activity);
        }

        public final ViewTreeObserver.OnPreDrawListener getPreDrawListener() {
            return this.preDrawListener;
        }

        public final void setPreDrawListener(ViewTreeObserver.OnPreDrawListener onPreDrawListener) {
            this.preDrawListener = onPreDrawListener;
        }

        public final boolean getMDecorFitWindowInsets() {
            return this.mDecorFitWindowInsets;
        }

        public final void setMDecorFitWindowInsets(boolean z) {
            this.mDecorFitWindowInsets = z;
        }

        public final ViewGroup.OnHierarchyChangeListener getHierarchyListener() {
            return this.hierarchyListener;
        }

        public final boolean computeDecorFitsWindow(SplashScreenView splashScreenView) {
            Intrinsics.checkNotNullParameter(splashScreenView, "child");
            WindowInsets build = new WindowInsets.Builder().build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder().build()");
            Rect rect = new Rect(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
            return build != splashScreenView.getRootView().computeSystemWindowInsets(build, rect) || !rect.isEmpty();
        }

        public void install() {
            Resources.Theme theme = getActivity().getTheme();
            Intrinsics.checkNotNullExpressionValue(theme, "activity.theme");
            setPostSplashScreenTheme(theme, new TypedValue());
            ((ViewGroup) getActivity().getWindow().getDecorView()).setOnHierarchyChangeListener(this.hierarchyListener);
        }

        public void setKeepOnScreenCondition(KeepOnScreenCondition keepOnScreenCondition) {
            Intrinsics.checkNotNullParameter(keepOnScreenCondition, "keepOnScreenCondition");
            setSplashScreenWaitPredicate(keepOnScreenCondition);
            View findViewById = getActivity().findViewById(16908290);
            ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
            if (this.preDrawListener != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.preDrawListener);
            }
            ViewTreeObserver.OnPreDrawListener splashScreen$Impl31$setKeepOnScreenCondition$1 = new SplashScreen$Impl31$setKeepOnScreenCondition$1(this, findViewById);
            this.preDrawListener = splashScreen$Impl31$setKeepOnScreenCondition$1;
            viewTreeObserver.addOnPreDrawListener(splashScreen$Impl31$setKeepOnScreenCondition$1);
        }

        public void setOnExitAnimationListener(OnExitAnimationListener onExitAnimationListener) {
            Intrinsics.checkNotNullParameter(onExitAnimationListener, "exitAnimationListener");
            getActivity().getSplashScreen().setOnExitAnimationListener(new SplashScreen$Impl31$$ExternalSyntheticLambda0(this, onExitAnimationListener));
        }

        /* access modifiers changed from: private */
        /* renamed from: setOnExitAnimationListener$lambda-0  reason: not valid java name */
        public static final void m7403setOnExitAnimationListener$lambda0(Impl31 impl31, OnExitAnimationListener onExitAnimationListener, SplashScreenView splashScreenView) {
            Intrinsics.checkNotNullParameter(impl31, "this$0");
            Intrinsics.checkNotNullParameter(onExitAnimationListener, "$exitAnimationListener");
            Intrinsics.checkNotNullParameter(splashScreenView, "splashScreenView");
            impl31.applyAppSystemUiTheme();
            onExitAnimationListener.onSplashScreenExit(new SplashScreenViewProvider(splashScreenView, impl31.getActivity()));
        }

        private final void applyAppSystemUiTheme() {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = getActivity().getTheme();
            Window window = getActivity().getWindow();
            boolean z = true;
            if (theme.resolveAttribute(16843857, typedValue, true)) {
                window.setStatusBarColor(typedValue.data);
            }
            if (theme.resolveAttribute(16843858, typedValue, true)) {
                window.setNavigationBarColor(typedValue.data);
            }
            if (theme.resolveAttribute(16843856, typedValue, true)) {
                if (typedValue.data != 0) {
                    window.addFlags(Integer.MIN_VALUE);
                } else {
                    window.clearFlags(Integer.MIN_VALUE);
                }
            }
            if (theme.resolveAttribute(16844293, typedValue, true)) {
                window.setNavigationBarContrastEnforced(typedValue.data != 0);
            }
            if (theme.resolveAttribute(16844292, typedValue, true)) {
                if (typedValue.data == 0) {
                    z = false;
                }
                window.setStatusBarContrastEnforced(z);
            }
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(theme, "theme");
            ThemeUtils.Api31.applyThemesSystemBarAppearance(theme, viewGroup, typedValue);
            viewGroup.setOnHierarchyChangeListener((ViewGroup.OnHierarchyChangeListener) null);
            window.setDecorFitsSystemWindows(this.mDecorFitWindowInsets);
        }
    }
}
