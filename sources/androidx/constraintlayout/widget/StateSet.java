package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public class StateSet {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    private SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();
    private ConstraintsChangedListener mConstraintsChangedListener = null;
    int mCurrentConstraintNumber = -1;
    int mCurrentStateId = -1;
    ConstraintSet mDefaultConstraintSet;
    int mDefaultState = -1;
    private SparseArray<State> mStateList = new SparseArray<>();

    public StateSet(Context context, XmlPullParser xmlPullParser) {
        load(context, xmlPullParser);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void load(android.content.Context r9, org.xmlpull.v1.XmlPullParser r10) {
        /*
            r8 = this;
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r10)
            int[] r1 = androidx.constraintlayout.widget.R.styleable.StateSet
            android.content.res.TypedArray r0 = r9.obtainStyledAttributes(r0, r1)
            int r1 = r0.getIndexCount()
            r2 = 0
            r3 = r2
        L_0x0010:
            if (r3 >= r1) goto L_0x0025
            int r4 = r0.getIndex(r3)
            int r5 = androidx.constraintlayout.widget.R.styleable.StateSet_defaultState
            if (r4 != r5) goto L_0x0022
            int r5 = r8.mDefaultState
            int r4 = r0.getResourceId(r4, r5)
            r8.mDefaultState = r4
        L_0x0022:
            int r3 = r3 + 1
            goto L_0x0010
        L_0x0025:
            int r0 = r10.getEventType()     // Catch:{ XmlPullParserException -> 0x00bf, IOException -> 0x00ba }
            r1 = 0
        L_0x002a:
            r3 = 1
            if (r0 == r3) goto L_0x00c3
            if (r0 == 0) goto L_0x00b1
            java.lang.String r4 = "StateSet"
            r5 = 3
            r6 = 2
            if (r0 == r6) goto L_0x0045
            if (r0 == r5) goto L_0x0039
            goto L_0x00b4
        L_0x0039:
            java.lang.String r0 = r10.getName()     // Catch:{ XmlPullParserException -> 0x00bf, IOException -> 0x00ba }
            boolean r0 = r4.equals(r0)     // Catch:{ XmlPullParserException -> 0x00bf, IOException -> 0x00ba }
            if (r0 == 0) goto L_0x00b4
            goto L_0x00c3
        L_0x0045:
            java.lang.String r0 = r10.getName()     // Catch:{ XmlPullParserException -> 0x00bf, IOException -> 0x00ba }
            int r7 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x00bf, IOException -> 0x00ba }
            switch(r7) {
                case 80204913: goto L_0x006d;
                case 1301459538: goto L_0x0063;
                case 1382829617: goto L_0x005b;
                case 1901439077: goto L_0x0051;
                default: goto L_0x0050;
            }     // Catch:{ XmlPullParserException -> 0x00bf, IOException -> 0x00ba }
        L_0x0050:
            goto L_0x0077
        L_0x0051:
            java.lang.String r4 = "Variant"
            boolean r4 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x00bf, IOException -> 0x00ba }
            if (r4 == 0) goto L_0x0077
            r4 = r5
            goto L_0x0078
        L_0x005b:
            boolean r4 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x00bf, IOException -> 0x00ba }
            if (r4 == 0) goto L_0x0077
            r4 = r3
            goto L_0x0078
        L_0x0063:
            java.lang.String r4 = "LayoutDescription"
            boolean r4 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x00bf, IOException -> 0x00ba }
            if (r4 == 0) goto L_0x0077
            r4 = r2
            goto L_0x0078
        L_0x006d:
            java.lang.String r4 = "State"
            boolean r4 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x00bf, IOException -> 0x00ba }
            if (r4 == 0) goto L_0x0077
            r4 = r6
            goto L_0x0078
        L_0x0077:
            r4 = -1
        L_0x0078:
            if (r4 == 0) goto L_0x00b4
            if (r4 == r3) goto L_0x00b4
            if (r4 == r6) goto L_0x00a4
            if (r4 == r5) goto L_0x0099
            java.lang.String r3 = "ConstraintLayoutStates"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x00bf, IOException -> 0x00ba }
            r4.<init>()     // Catch:{ XmlPullParserException -> 0x00bf, IOException -> 0x00ba }
            java.lang.String r5 = "unknown tag "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ XmlPullParserException -> 0x00bf, IOException -> 0x00ba }
            java.lang.StringBuilder r0 = r4.append(r0)     // Catch:{ XmlPullParserException -> 0x00bf, IOException -> 0x00ba }
            java.lang.String r0 = r0.toString()     // Catch:{ XmlPullParserException -> 0x00bf, IOException -> 0x00ba }
            android.util.Log.v(r3, r0)     // Catch:{ XmlPullParserException -> 0x00bf, IOException -> 0x00ba }
            goto L_0x00b4
        L_0x0099:
            androidx.constraintlayout.widget.StateSet$Variant r0 = new androidx.constraintlayout.widget.StateSet$Variant     // Catch:{ XmlPullParserException -> 0x00bf, IOException -> 0x00ba }
            r0.<init>(r9, r10)     // Catch:{ XmlPullParserException -> 0x00bf, IOException -> 0x00ba }
            if (r1 == 0) goto L_0x00b4
            r1.add(r0)     // Catch:{ XmlPullParserException -> 0x00bf, IOException -> 0x00ba }
            goto L_0x00b4
        L_0x00a4:
            androidx.constraintlayout.widget.StateSet$State r1 = new androidx.constraintlayout.widget.StateSet$State     // Catch:{ XmlPullParserException -> 0x00bf, IOException -> 0x00ba }
            r1.<init>(r9, r10)     // Catch:{ XmlPullParserException -> 0x00bf, IOException -> 0x00ba }
            android.util.SparseArray<androidx.constraintlayout.widget.StateSet$State> r0 = r8.mStateList     // Catch:{ XmlPullParserException -> 0x00bf, IOException -> 0x00ba }
            int r3 = r1.mId     // Catch:{ XmlPullParserException -> 0x00bf, IOException -> 0x00ba }
            r0.put(r3, r1)     // Catch:{ XmlPullParserException -> 0x00bf, IOException -> 0x00ba }
            goto L_0x00b4
        L_0x00b1:
            r10.getName()     // Catch:{ XmlPullParserException -> 0x00bf, IOException -> 0x00ba }
        L_0x00b4:
            int r0 = r10.next()     // Catch:{ XmlPullParserException -> 0x00bf, IOException -> 0x00ba }
            goto L_0x002a
        L_0x00ba:
            r9 = move-exception
            r9.printStackTrace()
            goto L_0x00c3
        L_0x00bf:
            r9 = move-exception
            r9.printStackTrace()
        L_0x00c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.StateSet.load(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public boolean needsToChange(int i, float f, float f2) {
        int i2 = this.mCurrentStateId;
        if (i2 != i) {
            return true;
        }
        State state = (State) (i == -1 ? this.mStateList.valueAt(0) : this.mStateList.get(i2));
        return (this.mCurrentConstraintNumber == -1 || !state.mVariants.get(this.mCurrentConstraintNumber).match(f, f2)) && this.mCurrentConstraintNumber != state.findMatch(f, f2);
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
    }

    public int stateGetConstraintID(int i, int i2, int i3) {
        return updateConstraints(-1, i, (float) i2, (float) i3);
    }

    public int convertToConstraintSet(int i, int i2, float f, float f2) {
        State state = this.mStateList.get(i2);
        if (state == null) {
            return i2;
        }
        if (f != -1.0f && f2 != -1.0f) {
            Iterator<Variant> it = state.mVariants.iterator();
            Variant variant = null;
            while (it.hasNext()) {
                Variant next = it.next();
                if (next.match(f, f2)) {
                    if (i != next.mConstraintID) {
                        variant = next;
                    }
                }
            }
            if (variant != null) {
                return variant.mConstraintID;
            }
            return state.mConstraintID;
        } else if (state.mConstraintID != i) {
            Iterator<Variant> it2 = state.mVariants.iterator();
            while (it2.hasNext()) {
                if (i == it2.next().mConstraintID) {
                }
            }
            return state.mConstraintID;
        }
        return i;
    }

    public int updateConstraints(int i, int i2, float f, float f2) {
        State state;
        int findMatch;
        if (i == i2) {
            if (i2 == -1) {
                state = this.mStateList.valueAt(0);
            } else {
                state = this.mStateList.get(this.mCurrentStateId);
            }
            if (state == null) {
                return -1;
            }
            if ((this.mCurrentConstraintNumber == -1 || !state.mVariants.get(i).match(f, f2)) && i != (findMatch = state.findMatch(f, f2))) {
                return findMatch == -1 ? state.mConstraintID : state.mVariants.get(findMatch).mConstraintID;
            }
            return i;
        }
        State state2 = this.mStateList.get(i2);
        if (state2 == null) {
            return -1;
        }
        int findMatch2 = state2.findMatch(f, f2);
        return findMatch2 == -1 ? state2.mConstraintID : state2.mVariants.get(findMatch2).mConstraintID;
    }

    static class State {
        int mConstraintID = -1;
        int mId;
        boolean mIsLayout;
        ArrayList<Variant> mVariants = new ArrayList<>();

        public State(Context context, XmlPullParser xmlPullParser) {
            this.mIsLayout = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.State_android_id) {
                    this.mId = obtainStyledAttributes.getResourceId(index, this.mId);
                } else if (index == R.styleable.State_constraints) {
                    this.mConstraintID = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if ("layout".equals(resourceTypeName)) {
                        this.mIsLayout = true;
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public void add(Variant variant) {
            this.mVariants.add(variant);
        }

        public int findMatch(float f, float f2) {
            for (int i = 0; i < this.mVariants.size(); i++) {
                if (this.mVariants.get(i).match(f, f2)) {
                    return i;
                }
            }
            return -1;
        }
    }

    static class Variant {
        int mConstraintID = -1;
        int mId;
        boolean mIsLayout;
        float mMaxHeight = Float.NaN;
        float mMaxWidth = Float.NaN;
        float mMinHeight = Float.NaN;
        float mMinWidth = Float.NaN;

        public Variant(Context context, XmlPullParser xmlPullParser) {
            this.mIsLayout = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.Variant_constraints) {
                    this.mConstraintID = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if ("layout".equals(resourceTypeName)) {
                        this.mIsLayout = true;
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.mMaxHeight = obtainStyledAttributes.getDimension(index, this.mMaxHeight);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.mMinHeight = obtainStyledAttributes.getDimension(index, this.mMinHeight);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.mMaxWidth = obtainStyledAttributes.getDimension(index, this.mMaxWidth);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.mMinWidth = obtainStyledAttributes.getDimension(index, this.mMinWidth);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public boolean match(float f, float f2) {
            if (!Float.isNaN(this.mMinWidth) && f < this.mMinWidth) {
                return false;
            }
            if (!Float.isNaN(this.mMinHeight) && f2 < this.mMinHeight) {
                return false;
            }
            if (!Float.isNaN(this.mMaxWidth) && f > this.mMaxWidth) {
                return false;
            }
            if (Float.isNaN(this.mMaxHeight) || f2 <= this.mMaxHeight) {
                return true;
            }
            return false;
        }
    }
}
