package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.WindowUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.SnackbarManager;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    public static final int ANIMATION_MODE_FADE = 1;
    public static final int ANIMATION_MODE_SLIDE = 0;
    private static final float ANIMATION_SCALE_FROM_VALUE = 0.8f;
    static final int DEFAULT_ANIMATION_FADE_DURATION = 180;
    private static final TimeInterpolator DEFAULT_ANIMATION_FADE_INTERPOLATOR = AnimationUtils.LINEAR_INTERPOLATOR;
    private static final int DEFAULT_ANIMATION_FADE_IN_DURATION = 150;
    private static final int DEFAULT_ANIMATION_FADE_OUT_DURATION = 75;
    private static final TimeInterpolator DEFAULT_ANIMATION_SCALE_INTERPOLATOR = AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
    private static final TimeInterpolator DEFAULT_ANIMATION_SLIDE_INTERPOLATOR = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
    static final int DEFAULT_SLIDE_ANIMATION_DURATION = 250;
    public static final int LENGTH_INDEFINITE = -2;
    public static final int LENGTH_LONG = 0;
    public static final int LENGTH_SHORT = -1;
    static final int MSG_DISMISS = 1;
    static final int MSG_SHOW = 0;
    private static final int[] SNACKBAR_STYLE_ATTR = {R.attr.snackbarStyle};
    /* access modifiers changed from: private */
    public static final String TAG = "BaseTransientBottomBar";
    /* access modifiers changed from: private */
    public static final boolean USE_OFFSET_API = false;
    static final Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                ((BaseTransientBottomBar) message.obj).showView();
                return true;
            } else if (i != 1) {
                return false;
            } else {
                ((BaseTransientBottomBar) message.obj).hideView(message.arg1);
                return true;
            }
        }
    });
    private final AccessibilityManager accessibilityManager;
    private Anchor anchor;
    /* access modifiers changed from: private */
    public boolean anchorViewLayoutListenerEnabled;
    /* access modifiers changed from: private */
    public final int animationFadeInDuration;
    private final TimeInterpolator animationFadeInterpolator;
    /* access modifiers changed from: private */
    public final int animationFadeOutDuration;
    private final TimeInterpolator animationScaleInterpolator;
    /* access modifiers changed from: private */
    public final int animationSlideDuration;
    private final TimeInterpolator animationSlideInterpolator;
    /* access modifiers changed from: private */
    public int appliedBottomMarginGestureInset;
    private Behavior behavior;
    private final Runnable bottomMarginGestureInsetRunnable;
    private List<BaseCallback<B>> callbacks;
    /* access modifiers changed from: private */
    public final ContentViewCallback contentViewCallback;
    /* access modifiers changed from: private */
    public final Context context;
    private int duration;
    private int extraBottomMarginAnchorView;
    /* access modifiers changed from: private */
    public int extraBottomMarginGestureInset;
    /* access modifiers changed from: private */
    public int extraBottomMarginWindowInset;
    /* access modifiers changed from: private */
    public int extraLeftMarginWindowInset;
    /* access modifiers changed from: private */
    public int extraRightMarginWindowInset;
    private boolean gestureInsetBottomIgnored;
    SnackbarManager.Callback managerCallback;
    private boolean pendingShowingView;
    private final ViewGroup targetParent;
    protected final SnackbarBaseLayout view;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AnimationMode {
    }

    public static abstract class BaseCallback<B> {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        @Retention(RetentionPolicy.SOURCE)
        public @interface DismissEvent {
        }

        public void onDismissed(B b, int i) {
        }

        public void onShown(B b) {
        }
    }

    @Deprecated
    public interface ContentViewCallback extends ContentViewCallback {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Duration {
    }

    protected BaseTransientBottomBar(ViewGroup viewGroup, View view2, ContentViewCallback contentViewCallback2) {
        this(viewGroup.getContext(), viewGroup, view2, contentViewCallback2);
    }

    protected BaseTransientBottomBar(Context context2, ViewGroup viewGroup, View view2, ContentViewCallback contentViewCallback2) {
        this.anchorViewLayoutListenerEnabled = false;
        this.bottomMarginGestureInsetRunnable = new Runnable() {
            public void run() {
                if (BaseTransientBottomBar.this.view != null && BaseTransientBottomBar.this.context != null) {
                    int height = (WindowUtils.getCurrentWindowBounds(BaseTransientBottomBar.this.context).height() - BaseTransientBottomBar.this.getViewAbsoluteBottom()) + ((int) BaseTransientBottomBar.this.view.getTranslationY());
                    if (height >= BaseTransientBottomBar.this.extraBottomMarginGestureInset) {
                        BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
                        int unused = baseTransientBottomBar.appliedBottomMarginGestureInset = baseTransientBottomBar.extraBottomMarginGestureInset;
                        return;
                    }
                    ViewGroup.LayoutParams layoutParams = BaseTransientBottomBar.this.view.getLayoutParams();
                    if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                        Log.w(BaseTransientBottomBar.TAG, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                        return;
                    }
                    BaseTransientBottomBar baseTransientBottomBar2 = BaseTransientBottomBar.this;
                    int unused2 = baseTransientBottomBar2.appliedBottomMarginGestureInset = baseTransientBottomBar2.extraBottomMarginGestureInset;
                    ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += BaseTransientBottomBar.this.extraBottomMarginGestureInset - height;
                    BaseTransientBottomBar.this.view.requestLayout();
                }
            }
        };
        this.managerCallback = new SnackbarManager.Callback() {
            public void show() {
                BaseTransientBottomBar.handler.sendMessage(BaseTransientBottomBar.handler.obtainMessage(0, BaseTransientBottomBar.this));
            }

            public void dismiss(int i) {
                BaseTransientBottomBar.handler.sendMessage(BaseTransientBottomBar.handler.obtainMessage(1, i, 0, BaseTransientBottomBar.this));
            }
        };
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        } else if (view2 == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        } else if (contentViewCallback2 != null) {
            this.targetParent = viewGroup;
            this.contentViewCallback = contentViewCallback2;
            this.context = context2;
            ThemeEnforcement.checkAppCompatTheme(context2);
            SnackbarBaseLayout snackbarBaseLayout = (SnackbarBaseLayout) LayoutInflater.from(context2).inflate(getSnackbarBaseLayoutResId(), viewGroup, false);
            this.view = snackbarBaseLayout;
            snackbarBaseLayout.setBaseTransientBottomBar(this);
            if (view2 instanceof SnackbarContentLayout) {
                SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) view2;
                snackbarContentLayout.updateActionTextColorAlphaIfNeeded(snackbarBaseLayout.getActionTextColorAlpha());
                snackbarContentLayout.setMaxInlineActionWidth(snackbarBaseLayout.getMaxInlineActionWidth());
            }
            snackbarBaseLayout.addView(view2);
            ViewCompat.setAccessibilityLiveRegion(snackbarBaseLayout, 1);
            ViewCompat.setImportantForAccessibility(snackbarBaseLayout, 1);
            ViewCompat.setFitsSystemWindows(snackbarBaseLayout, true);
            ViewCompat.setOnApplyWindowInsetsListener(snackbarBaseLayout, new OnApplyWindowInsetsListener() {
                public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    int unused = BaseTransientBottomBar.this.extraBottomMarginWindowInset = windowInsetsCompat.getSystemWindowInsetBottom();
                    int unused2 = BaseTransientBottomBar.this.extraLeftMarginWindowInset = windowInsetsCompat.getSystemWindowInsetLeft();
                    int unused3 = BaseTransientBottomBar.this.extraRightMarginWindowInset = windowInsetsCompat.getSystemWindowInsetRight();
                    BaseTransientBottomBar.this.updateMargins();
                    return windowInsetsCompat;
                }
            });
            ViewCompat.setAccessibilityDelegate(snackbarBaseLayout, new AccessibilityDelegateCompat() {
                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                    accessibilityNodeInfoCompat.addAction(1048576);
                    accessibilityNodeInfoCompat.setDismissable(true);
                }

                public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                    if (i != 1048576) {
                        return super.performAccessibilityAction(view, i, bundle);
                    }
                    BaseTransientBottomBar.this.dismiss();
                    return true;
                }
            });
            this.accessibilityManager = (AccessibilityManager) context2.getSystemService("accessibility");
            this.animationSlideDuration = MotionUtils.resolveThemeDuration(context2, R.attr.motionDurationLong2, 250);
            this.animationFadeInDuration = MotionUtils.resolveThemeDuration(context2, R.attr.motionDurationLong2, 150);
            this.animationFadeOutDuration = MotionUtils.resolveThemeDuration(context2, R.attr.motionDurationMedium1, 75);
            this.animationFadeInterpolator = MotionUtils.resolveThemeInterpolator(context2, R.attr.motionEasingEmphasizedInterpolator, DEFAULT_ANIMATION_FADE_INTERPOLATOR);
            this.animationScaleInterpolator = MotionUtils.resolveThemeInterpolator(context2, R.attr.motionEasingEmphasizedInterpolator, DEFAULT_ANIMATION_SCALE_INTERPOLATOR);
            this.animationSlideInterpolator = MotionUtils.resolveThemeInterpolator(context2, R.attr.motionEasingEmphasizedInterpolator, DEFAULT_ANIMATION_SLIDE_INTERPOLATOR);
        } else {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
    }

    /* access modifiers changed from: private */
    public void updateMargins() {
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            Log.w(TAG, "Unable to update margins because layout params are not MarginLayoutParams");
        } else if (this.view.originalMargins == null) {
            Log.w(TAG, "Unable to update margins because original view margins are not set");
        } else if (this.view.getParent() != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i = this.view.originalMargins.bottom + (getAnchorView() != null ? this.extraBottomMarginAnchorView : this.extraBottomMarginWindowInset);
            int i2 = this.view.originalMargins.left + this.extraLeftMarginWindowInset;
            int i3 = this.view.originalMargins.right + this.extraRightMarginWindowInset;
            int i4 = this.view.originalMargins.top;
            boolean z = (marginLayoutParams.bottomMargin == i && marginLayoutParams.leftMargin == i2 && marginLayoutParams.rightMargin == i3 && marginLayoutParams.topMargin == i4) ? false : true;
            if (z) {
                marginLayoutParams.bottomMargin = i;
                marginLayoutParams.leftMargin = i2;
                marginLayoutParams.rightMargin = i3;
                marginLayoutParams.topMargin = i4;
                this.view.requestLayout();
            }
            if ((z || this.appliedBottomMarginGestureInset != this.extraBottomMarginGestureInset) && Build.VERSION.SDK_INT >= 29 && shouldUpdateGestureInset()) {
                this.view.removeCallbacks(this.bottomMarginGestureInsetRunnable);
                this.view.post(this.bottomMarginGestureInsetRunnable);
            }
        }
    }

    private boolean shouldUpdateGestureInset() {
        return this.extraBottomMarginGestureInset > 0 && !this.gestureInsetBottomIgnored && isSwipeDismissable();
    }

    private boolean isSwipeDismissable() {
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        return (layoutParams instanceof CoordinatorLayout.LayoutParams) && (((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof SwipeDismissBehavior);
    }

    /* access modifiers changed from: protected */
    public int getSnackbarBaseLayoutResId() {
        return hasSnackbarStyleAttr() ? R.layout.mtrl_layout_snackbar : R.layout.design_layout_snackbar;
    }

    /* access modifiers changed from: protected */
    public boolean hasSnackbarStyleAttr() {
        TypedArray obtainStyledAttributes = this.context.obtainStyledAttributes(SNACKBAR_STYLE_ATTR);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        if (resourceId != -1) {
            return true;
        }
        return false;
    }

    public B setDuration(int i) {
        this.duration = i;
        return this;
    }

    public int getDuration() {
        return this.duration;
    }

    public B setGestureInsetBottomIgnored(boolean z) {
        this.gestureInsetBottomIgnored = z;
        return this;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    public int getAnimationMode() {
        return this.view.getAnimationMode();
    }

    public B setAnimationMode(int i) {
        this.view.setAnimationMode(i);
        return this;
    }

    public View getAnchorView() {
        Anchor anchor2 = this.anchor;
        if (anchor2 == null) {
            return null;
        }
        return anchor2.getAnchorView();
    }

    public B setAnchorView(View view2) {
        Anchor anchor2;
        Anchor anchor3 = this.anchor;
        if (anchor3 != null) {
            anchor3.unanchor();
        }
        if (view2 == null) {
            anchor2 = null;
        } else {
            anchor2 = Anchor.anchor(this, view2);
        }
        this.anchor = anchor2;
        return this;
    }

    public B setAnchorView(int i) {
        View findViewById = this.targetParent.findViewById(i);
        if (findViewById != null) {
            return setAnchorView(findViewById);
        }
        throw new IllegalArgumentException("Unable to find anchor view with id: " + i);
    }

    public boolean isAnchorViewLayoutListenerEnabled() {
        return this.anchorViewLayoutListenerEnabled;
    }

    public void setAnchorViewLayoutListenerEnabled(boolean z) {
        this.anchorViewLayoutListenerEnabled = z;
    }

    public B setBehavior(Behavior behavior2) {
        this.behavior = behavior2;
        return this;
    }

    public Behavior getBehavior() {
        return this.behavior;
    }

    public Context getContext() {
        return this.context;
    }

    public View getView() {
        return this.view;
    }

    public void show() {
        SnackbarManager.getInstance().show(getDuration(), this.managerCallback);
    }

    public void dismiss() {
        dispatchDismiss(3);
    }

    /* access modifiers changed from: protected */
    public void dispatchDismiss(int i) {
        SnackbarManager.getInstance().dismiss(this.managerCallback, i);
    }

    public B addCallback(BaseCallback<B> baseCallback) {
        if (baseCallback == null) {
            return this;
        }
        if (this.callbacks == null) {
            this.callbacks = new ArrayList();
        }
        this.callbacks.add(baseCallback);
        return this;
    }

    public B removeCallback(BaseCallback<B> baseCallback) {
        List<BaseCallback<B>> list;
        if (baseCallback == null || (list = this.callbacks) == null) {
            return this;
        }
        list.remove(baseCallback);
        return this;
    }

    public boolean isShown() {
        return SnackbarManager.getInstance().isCurrent(this.managerCallback);
    }

    public boolean isShownOrQueued() {
        return SnackbarManager.getInstance().isCurrentOrNext(this.managerCallback);
    }

    /* access modifiers changed from: protected */
    public SwipeDismissBehavior<? extends View> getNewBehavior() {
        return new Behavior();
    }

    /* access modifiers changed from: package-private */
    public final void showView() {
        if (this.view.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                setUpBehavior((CoordinatorLayout.LayoutParams) layoutParams);
            }
            this.view.addToTargetParent(this.targetParent);
            recalculateAndUpdateMargins();
            this.view.setVisibility(4);
        }
        if (ViewCompat.isLaidOut(this.view)) {
            showViewImpl();
        } else {
            this.pendingShowingView = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void onAttachedToWindow() {
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT >= 29 && (rootWindowInsets = this.view.getRootWindowInsets()) != null) {
            this.extraBottomMarginGestureInset = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
            updateMargins();
        }
    }

    /* access modifiers changed from: package-private */
    public void onDetachedFromWindow() {
        if (isShownOrQueued()) {
            handler.post(new Runnable() {
                public void run() {
                    BaseTransientBottomBar.this.onViewHidden(3);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void onLayoutChange() {
        if (this.pendingShowingView) {
            showViewImpl();
            this.pendingShowingView = false;
        }
    }

    private void showViewImpl() {
        if (shouldAnimate()) {
            animateViewIn();
            return;
        }
        if (this.view.getParent() != null) {
            this.view.setVisibility(0);
        }
        onViewShown();
    }

    /* access modifiers changed from: private */
    public int getViewAbsoluteBottom() {
        int[] iArr = new int[2];
        this.view.getLocationInWindow(iArr);
        return iArr[1] + this.view.getHeight();
    }

    private void setUpBehavior(CoordinatorLayout.LayoutParams layoutParams) {
        SwipeDismissBehavior swipeDismissBehavior = this.behavior;
        if (swipeDismissBehavior == null) {
            swipeDismissBehavior = getNewBehavior();
        }
        if (swipeDismissBehavior instanceof Behavior) {
            ((Behavior) swipeDismissBehavior).setBaseTransientBottomBar(this);
        }
        swipeDismissBehavior.setListener(new SwipeDismissBehavior.OnDismissListener() {
            public void onDismiss(View view) {
                if (view.getParent() != null) {
                    view.setVisibility(8);
                }
                BaseTransientBottomBar.this.dispatchDismiss(0);
            }

            public void onDragStateChanged(int i) {
                if (i == 0) {
                    SnackbarManager.getInstance().restoreTimeoutIfPaused(BaseTransientBottomBar.this.managerCallback);
                } else if (i == 1 || i == 2) {
                    SnackbarManager.getInstance().pauseTimeout(BaseTransientBottomBar.this.managerCallback);
                }
            }
        });
        layoutParams.setBehavior(swipeDismissBehavior);
        if (getAnchorView() == null) {
            layoutParams.insetEdge = 80;
        }
    }

    /* access modifiers changed from: private */
    public void recalculateAndUpdateMargins() {
        this.extraBottomMarginAnchorView = calculateBottomMarginForAnchorView();
        updateMargins();
    }

    private int calculateBottomMarginForAnchorView() {
        if (getAnchorView() == null) {
            return 0;
        }
        int[] iArr = new int[2];
        getAnchorView().getLocationOnScreen(iArr);
        int i = iArr[1];
        int[] iArr2 = new int[2];
        this.targetParent.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.targetParent.getHeight()) - i;
    }

    /* access modifiers changed from: package-private */
    public void animateViewIn() {
        this.view.post(new Runnable() {
            public void run() {
                if (BaseTransientBottomBar.this.view != null) {
                    if (BaseTransientBottomBar.this.view.getParent() != null) {
                        BaseTransientBottomBar.this.view.setVisibility(0);
                    }
                    if (BaseTransientBottomBar.this.view.getAnimationMode() == 1) {
                        BaseTransientBottomBar.this.startFadeInAnimation();
                    } else {
                        BaseTransientBottomBar.this.startSlideInAnimation();
                    }
                }
            }
        });
    }

    private void animateViewOut(int i) {
        if (this.view.getAnimationMode() == 1) {
            startFadeOutAnimation(i);
        } else {
            startSlideOutAnimation(i);
        }
    }

    /* access modifiers changed from: private */
    public void startFadeInAnimation() {
        ValueAnimator alphaAnimator = getAlphaAnimator(0.0f, 1.0f);
        ValueAnimator scaleAnimator = getScaleAnimator(0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{alphaAnimator, scaleAnimator});
        animatorSet.setDuration((long) this.animationFadeInDuration);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.onViewShown();
            }
        });
        animatorSet.start();
    }

    private void startFadeOutAnimation(final int i) {
        ValueAnimator alphaAnimator = getAlphaAnimator(1.0f, 0.0f);
        alphaAnimator.setDuration((long) this.animationFadeOutDuration);
        alphaAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.onViewHidden(i);
            }
        });
        alphaAnimator.start();
    }

    private ValueAnimator getAlphaAnimator(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(this.animationFadeInterpolator);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseTransientBottomBar.this.view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        return ofFloat;
    }

    private ValueAnimator getScaleAnimator(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(this.animationScaleInterpolator);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                BaseTransientBottomBar.this.view.setScaleX(floatValue);
                BaseTransientBottomBar.this.view.setScaleY(floatValue);
            }
        });
        return ofFloat;
    }

    /* access modifiers changed from: private */
    public void startSlideInAnimation() {
        int translationYBottom = getTranslationYBottom();
        if (USE_OFFSET_API) {
            ViewCompat.offsetTopAndBottom(this.view, translationYBottom);
        } else {
            this.view.setTranslationY((float) translationYBottom);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(new int[]{translationYBottom, 0});
        valueAnimator.setInterpolator(this.animationSlideInterpolator);
        valueAnimator.setDuration((long) this.animationSlideDuration);
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                BaseTransientBottomBar.this.contentViewCallback.animateContentIn(BaseTransientBottomBar.this.animationSlideDuration - BaseTransientBottomBar.this.animationFadeInDuration, BaseTransientBottomBar.this.animationFadeInDuration);
            }

            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.onViewShown();
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(translationYBottom) {
            private int previousAnimatedIntValue;
            final /* synthetic */ int val$translationYBottom;

            {
                this.val$translationYBottom = r2;
                this.previousAnimatedIntValue = r2;
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (BaseTransientBottomBar.USE_OFFSET_API) {
                    ViewCompat.offsetTopAndBottom(BaseTransientBottomBar.this.view, intValue - this.previousAnimatedIntValue);
                } else {
                    BaseTransientBottomBar.this.view.setTranslationY((float) intValue);
                }
                this.previousAnimatedIntValue = intValue;
            }
        });
        valueAnimator.start();
    }

    private void startSlideOutAnimation(final int i) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(new int[]{0, getTranslationYBottom()});
        valueAnimator.setInterpolator(this.animationSlideInterpolator);
        valueAnimator.setDuration((long) this.animationSlideDuration);
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                BaseTransientBottomBar.this.contentViewCallback.animateContentOut(0, BaseTransientBottomBar.this.animationFadeOutDuration);
            }

            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.onViewHidden(i);
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            private int previousAnimatedIntValue = 0;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (BaseTransientBottomBar.USE_OFFSET_API) {
                    ViewCompat.offsetTopAndBottom(BaseTransientBottomBar.this.view, intValue - this.previousAnimatedIntValue);
                } else {
                    BaseTransientBottomBar.this.view.setTranslationY((float) intValue);
                }
                this.previousAnimatedIntValue = intValue;
            }
        });
        valueAnimator.start();
    }

    private int getTranslationYBottom() {
        int height = this.view.getHeight();
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    /* access modifiers changed from: package-private */
    public final void hideView(int i) {
        if (!shouldAnimate() || this.view.getVisibility() != 0) {
            onViewHidden(i);
        } else {
            animateViewOut(i);
        }
    }

    /* access modifiers changed from: package-private */
    public void onViewShown() {
        SnackbarManager.getInstance().onShown(this.managerCallback);
        List<BaseCallback<B>> list = this.callbacks;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.callbacks.get(size).onShown(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void onViewHidden(int i) {
        SnackbarManager.getInstance().onDismissed(this.managerCallback);
        List<BaseCallback<B>> list = this.callbacks;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.callbacks.get(size).onDismissed(this, i);
            }
        }
        ViewParent parent = this.view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.view);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean shouldAnimate() {
        AccessibilityManager accessibilityManager2 = this.accessibilityManager;
        if (accessibilityManager2 == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager2.getEnabledAccessibilityServiceList(1);
        if (enabledAccessibilityServiceList == null || !enabledAccessibilityServiceList.isEmpty()) {
            return false;
        }
        return true;
    }

    protected static class SnackbarBaseLayout extends FrameLayout {
        private static final View.OnTouchListener consumeAllTouchListener = new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        };
        private final float actionTextColorAlpha;
        private boolean addingToTargetParent;
        private int animationMode;
        private final float backgroundOverlayColorAlpha;
        private ColorStateList backgroundTint;
        private PorterDuff.Mode backgroundTintMode;
        private BaseTransientBottomBar<?> baseTransientBottomBar;
        private final int maxInlineActionWidth;
        private final int maxWidth;
        /* access modifiers changed from: private */
        public Rect originalMargins;
        ShapeAppearanceModel shapeAppearanceModel;

        protected SnackbarBaseLayout(Context context) {
            this(context, (AttributeSet) null);
        }

        protected SnackbarBaseLayout(Context context, AttributeSet attributeSet) {
            super(MaterialThemeOverlay.wrap(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
            if (obtainStyledAttributes.hasValue(R.styleable.SnackbarLayout_elevation)) {
                ViewCompat.setElevation(this, (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_elevation, 0));
            }
            this.animationMode = obtainStyledAttributes.getInt(R.styleable.SnackbarLayout_animationMode, 0);
            if (obtainStyledAttributes.hasValue(R.styleable.SnackbarLayout_shapeAppearance) || obtainStyledAttributes.hasValue(R.styleable.SnackbarLayout_shapeAppearanceOverlay)) {
                this.shapeAppearanceModel = ShapeAppearanceModel.builder(context2, attributeSet, 0, 0).build();
            }
            this.backgroundOverlayColorAlpha = obtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(MaterialResources.getColorStateList(context2, obtainStyledAttributes, R.styleable.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(ViewUtils.parseTintMode(obtainStyledAttributes.getInt(R.styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.actionTextColorAlpha = obtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
            this.maxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
            this.maxInlineActionWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
            obtainStyledAttributes.recycle();
            setOnTouchListener(consumeAllTouchListener);
            setFocusable(true);
            if (getBackground() == null) {
                ViewCompat.setBackground(this, createThemedBackground());
            }
        }

        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        public void setBackgroundDrawable(Drawable drawable) {
            if (!(drawable == null || this.backgroundTint == null)) {
                drawable = DrawableCompat.wrap(drawable.mutate());
                DrawableCompat.setTintList(drawable, this.backgroundTint);
                DrawableCompat.setTintMode(drawable, this.backgroundTintMode);
            }
            super.setBackgroundDrawable(drawable);
        }

        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.backgroundTint = colorStateList;
            if (getBackground() != null) {
                Drawable wrap = DrawableCompat.wrap(getBackground().mutate());
                DrawableCompat.setTintList(wrap, colorStateList);
                DrawableCompat.setTintMode(wrap, this.backgroundTintMode);
                if (wrap != getBackground()) {
                    super.setBackgroundDrawable(wrap);
                }
            }
        }

        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.backgroundTintMode = mode;
            if (getBackground() != null) {
                Drawable wrap = DrawableCompat.wrap(getBackground().mutate());
                DrawableCompat.setTintMode(wrap, mode);
                if (wrap != getBackground()) {
                    super.setBackgroundDrawable(wrap);
                }
            }
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : consumeAllTouchListener);
            super.setOnClickListener(onClickListener);
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i, int i2) {
            int i3;
            super.onMeasure(i, i2);
            if (this.maxWidth > 0 && getMeasuredWidth() > (i3 = this.maxWidth)) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
            }
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            BaseTransientBottomBar<?> baseTransientBottomBar2 = this.baseTransientBottomBar;
            if (baseTransientBottomBar2 != null) {
                baseTransientBottomBar2.onLayoutChange();
            }
        }

        /* access modifiers changed from: protected */
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar2 = this.baseTransientBottomBar;
            if (baseTransientBottomBar2 != null) {
                baseTransientBottomBar2.onAttachedToWindow();
            }
            ViewCompat.requestApplyInsets(this);
        }

        /* access modifiers changed from: protected */
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar2 = this.baseTransientBottomBar;
            if (baseTransientBottomBar2 != null) {
                baseTransientBottomBar2.onDetachedFromWindow();
            }
        }

        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
            if (!this.addingToTargetParent && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                updateOriginalMargins((ViewGroup.MarginLayoutParams) layoutParams);
                BaseTransientBottomBar<?> baseTransientBottomBar2 = this.baseTransientBottomBar;
                if (baseTransientBottomBar2 != null) {
                    baseTransientBottomBar2.updateMargins();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public int getAnimationMode() {
            return this.animationMode;
        }

        /* access modifiers changed from: package-private */
        public void setAnimationMode(int i) {
            this.animationMode = i;
        }

        /* access modifiers changed from: package-private */
        public float getBackgroundOverlayColorAlpha() {
            return this.backgroundOverlayColorAlpha;
        }

        /* access modifiers changed from: package-private */
        public float getActionTextColorAlpha() {
            return this.actionTextColorAlpha;
        }

        /* access modifiers changed from: package-private */
        public int getMaxWidth() {
            return this.maxWidth;
        }

        /* access modifiers changed from: package-private */
        public int getMaxInlineActionWidth() {
            return this.maxInlineActionWidth;
        }

        /* access modifiers changed from: package-private */
        public void addToTargetParent(ViewGroup viewGroup) {
            this.addingToTargetParent = true;
            viewGroup.addView(this);
            this.addingToTargetParent = false;
        }

        /* access modifiers changed from: private */
        public void setBaseTransientBottomBar(BaseTransientBottomBar<?> baseTransientBottomBar2) {
            this.baseTransientBottomBar = baseTransientBottomBar2;
        }

        private void updateOriginalMargins(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.originalMargins = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }

        private Drawable createThemedBackground() {
            Drawable drawable;
            int layer = MaterialColors.layer(this, R.attr.colorSurface, R.attr.colorOnSurface, getBackgroundOverlayColorAlpha());
            ShapeAppearanceModel shapeAppearanceModel2 = this.shapeAppearanceModel;
            if (shapeAppearanceModel2 != null) {
                drawable = BaseTransientBottomBar.createMaterialShapeDrawableBackground(layer, shapeAppearanceModel2);
            } else {
                drawable = BaseTransientBottomBar.createGradientDrawableBackground(layer, getResources());
            }
            if (this.backgroundTint == null) {
                return DrawableCompat.wrap(drawable);
            }
            Drawable wrap = DrawableCompat.wrap(drawable);
            DrawableCompat.setTintList(wrap, this.backgroundTint);
            return wrap;
        }
    }

    /* access modifiers changed from: private */
    public static MaterialShapeDrawable createMaterialShapeDrawableBackground(int i, ShapeAppearanceModel shapeAppearanceModel) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(shapeAppearanceModel);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(i));
        return materialShapeDrawable;
    }

    /* access modifiers changed from: private */
    public static GradientDrawable createGradientDrawableBackground(int i, Resources resources) {
        float dimension = resources.getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(dimension);
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    public static class Behavior extends SwipeDismissBehavior<View> {
        private final BehaviorDelegate delegate = new BehaviorDelegate(this);

        /* access modifiers changed from: private */
        public void setBaseTransientBottomBar(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.delegate.setBaseTransientBottomBar(baseTransientBottomBar);
        }

        public boolean canSwipeDismissView(View view) {
            return this.delegate.canSwipeDismissView(view);
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.delegate.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }
    }

    public static class BehaviorDelegate {
        private SnackbarManager.Callback managerCallback;

        public BehaviorDelegate(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.setStartAlphaSwipeDistance(0.1f);
            swipeDismissBehavior.setEndAlphaSwipeDistance(0.6f);
            swipeDismissBehavior.setSwipeDirection(0);
        }

        public void setBaseTransientBottomBar(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.managerCallback = baseTransientBottomBar.managerCallback;
        }

        public boolean canSwipeDismissView(View view) {
            return view instanceof SnackbarBaseLayout;
        }

        public void onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    SnackbarManager.getInstance().restoreTimeoutIfPaused(this.managerCallback);
                }
            } else if (coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                SnackbarManager.getInstance().pauseTimeout(this.managerCallback);
            }
        }
    }

    static class Anchor implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {
        private final WeakReference<View> anchorView;
        private final WeakReference<BaseTransientBottomBar> transientBottomBar;

        static Anchor anchor(BaseTransientBottomBar baseTransientBottomBar, View view) {
            Anchor anchor = new Anchor(baseTransientBottomBar, view);
            if (ViewCompat.isAttachedToWindow(view)) {
                ViewUtils.addOnGlobalLayoutListener(view, anchor);
            }
            view.addOnAttachStateChangeListener(anchor);
            return anchor;
        }

        private Anchor(BaseTransientBottomBar baseTransientBottomBar, View view) {
            this.transientBottomBar = new WeakReference<>(baseTransientBottomBar);
            this.anchorView = new WeakReference<>(view);
        }

        public void onViewAttachedToWindow(View view) {
            if (!unanchorIfNoTransientBottomBar()) {
                ViewUtils.addOnGlobalLayoutListener(view, this);
            }
        }

        public void onViewDetachedFromWindow(View view) {
            if (!unanchorIfNoTransientBottomBar()) {
                ViewUtils.removeOnGlobalLayoutListener(view, (ViewTreeObserver.OnGlobalLayoutListener) this);
            }
        }

        public void onGlobalLayout() {
            if (!unanchorIfNoTransientBottomBar() && ((BaseTransientBottomBar) this.transientBottomBar.get()).anchorViewLayoutListenerEnabled) {
                ((BaseTransientBottomBar) this.transientBottomBar.get()).recalculateAndUpdateMargins();
            }
        }

        /* access modifiers changed from: package-private */
        public View getAnchorView() {
            return (View) this.anchorView.get();
        }

        private boolean unanchorIfNoTransientBottomBar() {
            if (this.transientBottomBar.get() != null) {
                return false;
            }
            unanchor();
            return true;
        }

        /* access modifiers changed from: package-private */
        public void unanchor() {
            if (this.anchorView.get() != null) {
                ((View) this.anchorView.get()).removeOnAttachStateChangeListener(this);
                ViewUtils.removeOnGlobalLayoutListener((View) this.anchorView.get(), (ViewTreeObserver.OnGlobalLayoutListener) this);
            }
            this.anchorView.clear();
            this.transientBottomBar.clear();
        }
    }
}
