package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.Transition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class Visibility extends Transition {
    public static final int MODE_IN = 1;
    public static final int MODE_OUT = 2;
    private static final String PROPNAME_PARENT = "android:visibility:parent";
    private static final String PROPNAME_SCREEN_LOCATION = "android:visibility:screenLocation";
    static final String PROPNAME_VISIBILITY = "android:visibility:visibility";
    private static final String[] sTransitionProperties = {PROPNAME_VISIBILITY, PROPNAME_PARENT};
    private int mMode = 3;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    private static class VisibilityInfo {
        ViewGroup mEndParent;
        int mEndVisibility;
        boolean mFadeIn;
        ViewGroup mStartParent;
        int mStartVisibility;
        boolean mVisibilityChange;

        VisibilityInfo() {
        }
    }

    public Visibility() {
    }

    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.VISIBILITY_TRANSITION);
        int namedInt = TypedArrayUtils.getNamedInt(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        obtainStyledAttributes.recycle();
        if (namedInt != 0) {
            setMode(namedInt);
        }
    }

    public void setMode(int i) {
        if ((i & -4) == 0) {
            this.mMode = i;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    public int getMode() {
        return this.mMode;
    }

    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    private void captureValues(TransitionValues transitionValues) {
        transitionValues.values.put(PROPNAME_VISIBILITY, Integer.valueOf(transitionValues.view.getVisibility()));
        transitionValues.values.put(PROPNAME_PARENT, transitionValues.view.getParent());
        int[] iArr = new int[2];
        transitionValues.view.getLocationOnScreen(iArr);
        transitionValues.values.put(PROPNAME_SCREEN_LOCATION, iArr);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public boolean isVisible(TransitionValues transitionValues) {
        if (transitionValues == null) {
            return false;
        }
        int intValue = ((Integer) transitionValues.values.get(PROPNAME_VISIBILITY)).intValue();
        View view = (View) transitionValues.values.get(PROPNAME_PARENT);
        if (intValue != 0 || view == null) {
            return false;
        }
        return true;
    }

    private VisibilityInfo getVisibilityChangeInfo(TransitionValues transitionValues, TransitionValues transitionValues2) {
        VisibilityInfo visibilityInfo = new VisibilityInfo();
        visibilityInfo.mVisibilityChange = false;
        visibilityInfo.mFadeIn = false;
        if (transitionValues == null || !transitionValues.values.containsKey(PROPNAME_VISIBILITY)) {
            visibilityInfo.mStartVisibility = -1;
            visibilityInfo.mStartParent = null;
        } else {
            visibilityInfo.mStartVisibility = ((Integer) transitionValues.values.get(PROPNAME_VISIBILITY)).intValue();
            visibilityInfo.mStartParent = (ViewGroup) transitionValues.values.get(PROPNAME_PARENT);
        }
        if (transitionValues2 == null || !transitionValues2.values.containsKey(PROPNAME_VISIBILITY)) {
            visibilityInfo.mEndVisibility = -1;
            visibilityInfo.mEndParent = null;
        } else {
            visibilityInfo.mEndVisibility = ((Integer) transitionValues2.values.get(PROPNAME_VISIBILITY)).intValue();
            visibilityInfo.mEndParent = (ViewGroup) transitionValues2.values.get(PROPNAME_PARENT);
        }
        if (transitionValues == null || transitionValues2 == null) {
            if (transitionValues == null && visibilityInfo.mEndVisibility == 0) {
                visibilityInfo.mFadeIn = true;
                visibilityInfo.mVisibilityChange = true;
                return visibilityInfo;
            } else if (transitionValues2 == null && visibilityInfo.mStartVisibility == 0) {
                visibilityInfo.mFadeIn = false;
                visibilityInfo.mVisibilityChange = true;
            }
        } else if (!(visibilityInfo.mStartVisibility == visibilityInfo.mEndVisibility && visibilityInfo.mStartParent == visibilityInfo.mEndParent)) {
            if (visibilityInfo.mStartVisibility != visibilityInfo.mEndVisibility) {
                if (visibilityInfo.mStartVisibility == 0) {
                    visibilityInfo.mFadeIn = false;
                    visibilityInfo.mVisibilityChange = true;
                    return visibilityInfo;
                } else if (visibilityInfo.mEndVisibility == 0) {
                    visibilityInfo.mFadeIn = true;
                    visibilityInfo.mVisibilityChange = true;
                    return visibilityInfo;
                }
            } else if (visibilityInfo.mEndParent == null) {
                visibilityInfo.mFadeIn = false;
                visibilityInfo.mVisibilityChange = true;
                return visibilityInfo;
            } else if (visibilityInfo.mStartParent == null) {
                visibilityInfo.mFadeIn = true;
                visibilityInfo.mVisibilityChange = true;
                return visibilityInfo;
            }
        }
        return visibilityInfo;
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        VisibilityInfo visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
        if (!visibilityChangeInfo.mVisibilityChange) {
            return null;
        }
        if (visibilityChangeInfo.mStartParent == null && visibilityChangeInfo.mEndParent == null) {
            return null;
        }
        if (visibilityChangeInfo.mFadeIn) {
            return onAppear(viewGroup, transitionValues, visibilityChangeInfo.mStartVisibility, transitionValues2, visibilityChangeInfo.mEndVisibility);
        }
        int i = visibilityChangeInfo.mStartVisibility;
        int i2 = visibilityChangeInfo.mEndVisibility;
        return onDisappear(viewGroup, transitionValues, i, transitionValues2, i2);
    }

    public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
        if ((this.mMode & 1) != 1 || transitionValues2 == null) {
            return null;
        }
        if (transitionValues == null) {
            View view = (View) transitionValues2.view.getParent();
            if (getVisibilityChangeInfo(getMatchedTransitionValues(view, false), getTransitionValues(view, false)).mVisibilityChange) {
                return null;
            }
        }
        return onAppear(viewGroup, transitionValues2.view, transitionValues, transitionValues2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x007f, code lost:
        if (r9.mCanRemoveViews != false) goto L_0x0081;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator onDisappear(android.view.ViewGroup r10, androidx.transition.TransitionValues r11, int r12, androidx.transition.TransitionValues r13, int r14) {
        /*
            r9 = this;
            int r12 = r9.mMode
            r0 = 2
            r12 = r12 & r0
            r1 = 0
            if (r12 == r0) goto L_0x0008
            return r1
        L_0x0008:
            if (r11 != 0) goto L_0x000b
            return r1
        L_0x000b:
            android.view.View r12 = r11.view
            if (r13 == 0) goto L_0x0012
            android.view.View r2 = r13.view
            goto L_0x0013
        L_0x0012:
            r2 = r1
        L_0x0013:
            int r3 = androidx.transition.R.id.save_overlay_view
            java.lang.Object r3 = r12.getTag(r3)
            android.view.View r3 = (android.view.View) r3
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x0023
            r2 = r1
            r6 = r5
            goto L_0x0089
        L_0x0023:
            if (r2 == 0) goto L_0x0036
            android.view.ViewParent r3 = r2.getParent()
            if (r3 != 0) goto L_0x002c
            goto L_0x0036
        L_0x002c:
            r3 = 4
            if (r14 != r3) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            if (r12 != r2) goto L_0x003b
        L_0x0032:
            r3 = r2
            r6 = r4
            r2 = r1
            goto L_0x003e
        L_0x0036:
            if (r2 == 0) goto L_0x003b
            r3 = r1
            r6 = r4
            goto L_0x003e
        L_0x003b:
            r2 = r1
            r3 = r2
            r6 = r5
        L_0x003e:
            if (r6 == 0) goto L_0x0085
            android.view.ViewParent r6 = r12.getParent()
            if (r6 != 0) goto L_0x0047
            goto L_0x0081
        L_0x0047:
            android.view.ViewParent r6 = r12.getParent()
            boolean r6 = r6 instanceof android.view.View
            if (r6 == 0) goto L_0x0085
            android.view.ViewParent r6 = r12.getParent()
            android.view.View r6 = (android.view.View) r6
            androidx.transition.TransitionValues r7 = r9.getTransitionValues(r6, r5)
            androidx.transition.TransitionValues r8 = r9.getMatchedTransitionValues(r6, r5)
            androidx.transition.Visibility$VisibilityInfo r7 = r9.getVisibilityChangeInfo(r7, r8)
            boolean r7 = r7.mVisibilityChange
            if (r7 != 0) goto L_0x006a
            android.view.View r2 = androidx.transition.TransitionUtils.copyViewImage(r10, r12, r6)
            goto L_0x0085
        L_0x006a:
            int r7 = r6.getId()
            android.view.ViewParent r6 = r6.getParent()
            if (r6 != 0) goto L_0x0085
            r6 = -1
            if (r7 == r6) goto L_0x0085
            android.view.View r6 = r10.findViewById(r7)
            if (r6 == 0) goto L_0x0085
            boolean r6 = r9.mCanRemoveViews
            if (r6 == 0) goto L_0x0085
        L_0x0081:
            r2 = r3
            r6 = r4
            r3 = r12
            goto L_0x0089
        L_0x0085:
            r6 = r3
            r3 = r2
            r2 = r6
            r6 = r4
        L_0x0089:
            if (r3 == 0) goto L_0x00e5
            if (r6 != 0) goto L_0x00bd
            java.util.Map<java.lang.String, java.lang.Object> r14 = r11.values
            java.lang.String r1 = "android:visibility:screenLocation"
            java.lang.Object r14 = r14.get(r1)
            int[] r14 = (int[]) r14
            r1 = r14[r4]
            r14 = r14[r5]
            int[] r0 = new int[r0]
            r10.getLocationOnScreen(r0)
            r2 = r0[r4]
            int r1 = r1 - r2
            int r2 = r3.getLeft()
            int r1 = r1 - r2
            r3.offsetLeftAndRight(r1)
            r0 = r0[r5]
            int r14 = r14 - r0
            int r0 = r3.getTop()
            int r14 = r14 - r0
            r3.offsetTopAndBottom(r14)
            android.view.ViewGroupOverlay r14 = r10.getOverlay()
            r14.add(r3)
        L_0x00bd:
            android.animation.Animator r11 = r9.onDisappear(r10, r3, r11, r13)
            if (r6 != 0) goto L_0x00e4
            if (r11 != 0) goto L_0x00cd
            android.view.ViewGroupOverlay r10 = r10.getOverlay()
            r10.remove(r3)
            return r11
        L_0x00cd:
            int r13 = androidx.transition.R.id.save_overlay_view
            r12.setTag(r13, r3)
            androidx.transition.Visibility$OverlayListener r13 = new androidx.transition.Visibility$OverlayListener
            r13.<init>(r10, r3, r12)
            r11.addListener(r13)
            r11.addPauseListener(r13)
            androidx.transition.Transition r10 = r9.getRootTransition()
            r10.addListener(r13)
        L_0x00e4:
            return r11
        L_0x00e5:
            if (r2 == 0) goto L_0x0108
            int r12 = r2.getVisibility()
            androidx.transition.ViewUtils.setTransitionVisibility(r2, r4)
            android.animation.Animator r10 = r9.onDisappear(r10, r2, r11, r13)
            if (r10 == 0) goto L_0x0104
            androidx.transition.Visibility$DisappearListener r11 = new androidx.transition.Visibility$DisappearListener
            r11.<init>(r2, r14, r5)
            r10.addListener(r11)
            androidx.transition.Transition r12 = r9.getRootTransition()
            r12.addListener(r11)
            return r10
        L_0x0104:
            androidx.transition.ViewUtils.setTransitionVisibility(r2, r12)
            return r10
        L_0x0108:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.onDisappear(android.view.ViewGroup, androidx.transition.TransitionValues, int, androidx.transition.TransitionValues, int):android.animation.Animator");
    }

    public boolean isTransitionRequired(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null && transitionValues2 == null) {
            return false;
        }
        if (transitionValues != null && transitionValues2 != null && transitionValues2.values.containsKey(PROPNAME_VISIBILITY) != transitionValues.values.containsKey(PROPNAME_VISIBILITY)) {
            return false;
        }
        VisibilityInfo visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
        if (!visibilityChangeInfo.mVisibilityChange || (visibilityChangeInfo.mStartVisibility != 0 && visibilityChangeInfo.mEndVisibility != 0)) {
            return false;
        }
        return true;
    }

    private static class DisappearListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        boolean mCanceled = false;
        private final int mFinalVisibility;
        private boolean mLayoutSuppressed;
        private final ViewGroup mParent;
        private final boolean mSuppressLayout;
        private final View mView;

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionStart(Transition transition) {
        }

        DisappearListener(View view, int i, boolean z) {
            this.mView = view;
            this.mFinalVisibility = i;
            this.mParent = (ViewGroup) view.getParent();
            this.mSuppressLayout = z;
            suppressLayout(true);
        }

        public void onAnimationCancel(Animator animator) {
            this.mCanceled = true;
        }

        public void onAnimationEnd(Animator animator) {
            hideViewWhenNotCanceled();
        }

        public void onAnimationStart(Animator animator, boolean z) {
            if (z) {
                ViewUtils.setTransitionVisibility(this.mView, 0);
                ViewGroup viewGroup = this.mParent;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
        }

        public void onAnimationEnd(Animator animator, boolean z) {
            if (!z) {
                hideViewWhenNotCanceled();
            }
        }

        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
        }

        public void onTransitionPause(Transition transition) {
            suppressLayout(false);
            if (!this.mCanceled) {
                ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
            }
        }

        public void onTransitionResume(Transition transition) {
            suppressLayout(true);
            if (!this.mCanceled) {
                ViewUtils.setTransitionVisibility(this.mView, 0);
            }
        }

        private void hideViewWhenNotCanceled() {
            if (!this.mCanceled) {
                ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
                ViewGroup viewGroup = this.mParent;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            suppressLayout(false);
        }

        private void suppressLayout(boolean z) {
            ViewGroup viewGroup;
            if (this.mSuppressLayout && this.mLayoutSuppressed != z && (viewGroup = this.mParent) != null) {
                this.mLayoutSuppressed = z;
                ViewGroupUtils.suppressLayout(viewGroup, z);
            }
        }
    }

    private class OverlayListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private boolean mHasOverlay = true;
        private final ViewGroup mOverlayHost;
        private final View mOverlayView;
        private final View mStartView;

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }

        public void onTransitionStart(Transition transition) {
        }

        OverlayListener(ViewGroup viewGroup, View view, View view2) {
            this.mOverlayHost = viewGroup;
            this.mOverlayView = view;
            this.mStartView = view2;
        }

        public void onAnimationPause(Animator animator) {
            this.mOverlayHost.getOverlay().remove(this.mOverlayView);
        }

        public void onAnimationResume(Animator animator) {
            if (this.mOverlayView.getParent() == null) {
                this.mOverlayHost.getOverlay().add(this.mOverlayView);
            } else {
                Visibility.this.cancel();
            }
        }

        public void onAnimationStart(Animator animator, boolean z) {
            if (z) {
                this.mStartView.setTag(R.id.save_overlay_view, this.mOverlayView);
                this.mOverlayHost.getOverlay().add(this.mOverlayView);
                this.mHasOverlay = true;
            }
        }

        public void onAnimationEnd(Animator animator) {
            removeFromOverlay();
        }

        public void onAnimationEnd(Animator animator, boolean z) {
            if (!z) {
                removeFromOverlay();
            }
        }

        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
        }

        public void onTransitionCancel(Transition transition) {
            if (this.mHasOverlay) {
                removeFromOverlay();
            }
        }

        private void removeFromOverlay() {
            this.mStartView.setTag(R.id.save_overlay_view, (Object) null);
            this.mOverlayHost.getOverlay().remove(this.mOverlayView);
            this.mHasOverlay = false;
        }
    }
}
