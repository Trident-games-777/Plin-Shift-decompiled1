package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.inspector.InspectionCompanion;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.view.ViewCompat;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.customview.view.AbsSavedState;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends LinearLayoutCompat implements CollapsibleActionView {
    static final boolean DBG = false;
    private static final String IME_OPTION_NO_MICROPHONE = "nm";
    static final String LOG_TAG = "SearchView";
    static final PreQAutoCompleteTextViewReflector PRE_API_29_HIDDEN_METHOD_INVOKER = (Build.VERSION.SDK_INT < 29 ? new PreQAutoCompleteTextViewReflector() : null);
    private Bundle mAppSearchData;
    private boolean mClearingFocus;
    final ImageView mCloseButton;
    private final ImageView mCollapsedIcon;
    private int mCollapsedImeOptions;
    private final CharSequence mDefaultQueryHint;
    private final View mDropDownAnchor;
    private boolean mExpandedInActionView;
    final ImageView mGoButton;
    private boolean mIconified;
    private boolean mIconifiedByDefault;
    private int mMaxWidth;
    private CharSequence mOldQueryText;
    private final View.OnClickListener mOnClickListener;
    private OnCloseListener mOnCloseListener;
    private final TextView.OnEditorActionListener mOnEditorActionListener;
    private final AdapterView.OnItemClickListener mOnItemClickListener;
    private final AdapterView.OnItemSelectedListener mOnItemSelectedListener;
    private OnQueryTextListener mOnQueryChangeListener;
    View.OnFocusChangeListener mOnQueryTextFocusChangeListener;
    private View.OnClickListener mOnSearchClickListener;
    private OnSuggestionListener mOnSuggestionListener;
    private final WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache;
    private CharSequence mQueryHint;
    private boolean mQueryRefinement;
    private Runnable mReleaseCursorRunnable;
    final ImageView mSearchButton;
    private final View mSearchEditFrame;
    private final Drawable mSearchHintIcon;
    private final View mSearchPlate;
    final SearchAutoComplete mSearchSrcTextView;
    private Rect mSearchSrcTextViewBounds;
    private Rect mSearchSrtTextViewBoundsExpanded;
    SearchableInfo mSearchable;
    private final View mSubmitArea;
    private boolean mSubmitButtonEnabled;
    private final int mSuggestionCommitIconResId;
    private final int mSuggestionRowLayout;
    CursorAdapter mSuggestionsAdapter;
    private int[] mTemp;
    private int[] mTemp2;
    View.OnKeyListener mTextKeyListener;
    private TextWatcher mTextWatcher;
    private UpdatableTouchDelegate mTouchDelegate;
    private final Runnable mUpdateDrawableStateRunnable;
    private CharSequence mUserQuery;
    private final Intent mVoiceAppSearchIntent;
    final ImageView mVoiceButton;
    private boolean mVoiceButtonEnabled;
    private final Intent mVoiceWebSearchIntent;

    public interface OnCloseListener {
        boolean onClose();
    }

    public interface OnQueryTextListener {
        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    public interface OnSuggestionListener {
        boolean onSuggestionClick(int i);

        boolean onSuggestionSelect(int i);
    }

    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion<SearchView> {
        private int mIconifiedByDefaultId;
        private int mImeOptionsId;
        private int mMaxWidthId;
        private boolean mPropertiesMapped = false;
        private int mQueryHintId;

        public void mapProperties(PropertyMapper propertyMapper) {
            this.mImeOptionsId = propertyMapper.mapInt("imeOptions", 16843364);
            this.mMaxWidthId = propertyMapper.mapInt("maxWidth", 16843039);
            this.mIconifiedByDefaultId = propertyMapper.mapBoolean("iconifiedByDefault", R.attr.iconifiedByDefault);
            this.mQueryHintId = propertyMapper.mapObject("queryHint", R.attr.queryHint);
            this.mPropertiesMapped = true;
        }

        public void readProperties(SearchView searchView, PropertyReader propertyReader) {
            if (this.mPropertiesMapped) {
                propertyReader.readInt(this.mImeOptionsId, searchView.getImeOptions());
                propertyReader.readInt(this.mMaxWidthId, searchView.getMaxWidth());
                propertyReader.readBoolean(this.mIconifiedByDefaultId, searchView.isIconfiedByDefault());
                propertyReader.readObject(this.mQueryHintId, searchView.getQueryHint());
                return;
            }
            throw new InspectionCompanion.UninitializedPropertyMapException();
        }
    }

    public SearchView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchViewStyle);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSearchSrcTextViewBounds = new Rect();
        this.mSearchSrtTextViewBoundsExpanded = new Rect();
        this.mTemp = new int[2];
        this.mTemp2 = new int[2];
        this.mUpdateDrawableStateRunnable = new Runnable() {
            public void run() {
                SearchView.this.updateFocusedState();
            }
        };
        this.mReleaseCursorRunnable = new Runnable() {
            public void run() {
                if (SearchView.this.mSuggestionsAdapter instanceof SuggestionsAdapter) {
                    SearchView.this.mSuggestionsAdapter.changeCursor((Cursor) null);
                }
            }
        };
        this.mOutsideDrawablesCache = new WeakHashMap<>();
        AnonymousClass5 r7 = new View.OnClickListener() {
            public void onClick(View view) {
                if (view == SearchView.this.mSearchButton) {
                    SearchView.this.onSearchClicked();
                } else if (view == SearchView.this.mCloseButton) {
                    SearchView.this.onCloseClicked();
                } else if (view == SearchView.this.mGoButton) {
                    SearchView.this.onSubmitQuery();
                } else if (view == SearchView.this.mVoiceButton) {
                    SearchView.this.onVoiceClicked();
                } else if (view == SearchView.this.mSearchSrcTextView) {
                    SearchView.this.forceSuggestionQuery();
                }
            }
        };
        this.mOnClickListener = r7;
        this.mTextKeyListener = new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (SearchView.this.mSearchable == null) {
                    return false;
                }
                if (SearchView.this.mSearchSrcTextView.isPopupShowing() && SearchView.this.mSearchSrcTextView.getListSelection() != -1) {
                    return SearchView.this.onSuggestionsKey(view, i, keyEvent);
                }
                if (SearchView.this.mSearchSrcTextView.isEmpty() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i != 66) {
                    return false;
                }
                view.cancelLongPress();
                SearchView searchView = SearchView.this;
                searchView.launchQuerySearch(0, (String) null, searchView.mSearchSrcTextView.getText().toString());
                return true;
            }
        };
        AnonymousClass7 r8 = new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                SearchView.this.onSubmitQuery();
                return true;
            }
        };
        this.mOnEditorActionListener = r8;
        AnonymousClass8 r9 = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                SearchView.this.onItemClicked(i, 0, (String) null);
            }
        };
        this.mOnItemClickListener = r9;
        AnonymousClass9 r10 = new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                SearchView.this.onItemSelected(i);
            }
        };
        this.mOnItemSelectedListener = r10;
        this.mTextWatcher = new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                SearchView.this.onTextChanged(charSequence);
            }
        };
        AttributeSet attributeSet2 = attributeSet;
        int i2 = i;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet2, R.styleable.SearchView, i2, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, R.styleable.SearchView, attributeSet2, obtainStyledAttributes.getWrappedTypeArray(), i2, 0);
        LayoutInflater.from(context).inflate(obtainStyledAttributes.getResourceId(R.styleable.SearchView_layout, R.layout.abc_search_view), this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.mSearchSrcTextView = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.mSearchEditFrame = findViewById(R.id.search_edit_frame);
        View findViewById = findViewById(R.id.search_plate);
        this.mSearchPlate = findViewById;
        View findViewById2 = findViewById(R.id.submit_area);
        this.mSubmitArea = findViewById2;
        ImageView imageView = (ImageView) findViewById(R.id.search_button);
        this.mSearchButton = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.id.search_go_btn);
        this.mGoButton = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R.id.search_close_btn);
        this.mCloseButton = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R.id.search_voice_btn);
        this.mVoiceButton = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R.id.search_mag_icon);
        this.mCollapsedIcon = imageView5;
        ViewCompat.setBackground(findViewById, obtainStyledAttributes.getDrawable(R.styleable.SearchView_queryBackground));
        ViewCompat.setBackground(findViewById2, obtainStyledAttributes.getDrawable(R.styleable.SearchView_submitBackground));
        imageView.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_searchIcon));
        imageView2.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_goIcon));
        imageView3.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_closeIcon));
        imageView4.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_voiceIcon));
        imageView5.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_searchIcon));
        this.mSearchHintIcon = obtainStyledAttributes.getDrawable(R.styleable.SearchView_searchHintIcon);
        TooltipCompat.setTooltipText(imageView, getResources().getString(R.string.abc_searchview_description_search));
        this.mSuggestionRowLayout = obtainStyledAttributes.getResourceId(R.styleable.SearchView_suggestionRowLayout, R.layout.abc_search_dropdown_item_icons_2line);
        this.mSuggestionCommitIconResId = obtainStyledAttributes.getResourceId(R.styleable.SearchView_commitIcon, 0);
        imageView.setOnClickListener(r7);
        imageView3.setOnClickListener(r7);
        imageView2.setOnClickListener(r7);
        imageView4.setOnClickListener(r7);
        searchAutoComplete.setOnClickListener(r7);
        searchAutoComplete.addTextChangedListener(this.mTextWatcher);
        searchAutoComplete.setOnEditorActionListener(r8);
        searchAutoComplete.setOnItemClickListener(r9);
        searchAutoComplete.setOnItemSelectedListener(r10);
        searchAutoComplete.setOnKeyListener(this.mTextKeyListener);
        searchAutoComplete.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (SearchView.this.mOnQueryTextFocusChangeListener != null) {
                    SearchView.this.mOnQueryTextFocusChangeListener.onFocusChange(SearchView.this, z);
                }
            }
        });
        setIconifiedByDefault(obtainStyledAttributes.getBoolean(R.styleable.SearchView_iconifiedByDefault, true));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SearchView_android_maxWidth, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.mDefaultQueryHint = obtainStyledAttributes.getText(R.styleable.SearchView_defaultQueryHint);
        this.mQueryHint = obtainStyledAttributes.getText(R.styleable.SearchView_queryHint);
        int i3 = obtainStyledAttributes.getInt(R.styleable.SearchView_android_imeOptions, -1);
        if (i3 != -1) {
            setImeOptions(i3);
        }
        int i4 = obtainStyledAttributes.getInt(R.styleable.SearchView_android_inputType, -1);
        if (i4 != -1) {
            setInputType(i4);
        }
        setFocusable(obtainStyledAttributes.getBoolean(R.styleable.SearchView_android_focusable, true));
        obtainStyledAttributes.recycle();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.mVoiceWebSearchIntent = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.mVoiceAppSearchIntent = intent2;
        intent2.addFlags(268435456);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.mDropDownAnchor = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    SearchView.this.adjustDropDownSizeAndPosition();
                }
            });
        }
        updateViewsVisibility(this.mIconifiedByDefault);
        updateQueryHint();
    }

    /* access modifiers changed from: package-private */
    public int getSuggestionRowLayout() {
        return this.mSuggestionRowLayout;
    }

    /* access modifiers changed from: package-private */
    public int getSuggestionCommitIconResId() {
        return this.mSuggestionCommitIconResId;
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.mSearchable = searchableInfo;
        if (searchableInfo != null) {
            updateSearchAutoComplete();
            updateQueryHint();
        }
        boolean hasVoiceSearch = hasVoiceSearch();
        this.mVoiceButtonEnabled = hasVoiceSearch;
        if (hasVoiceSearch) {
            this.mSearchSrcTextView.setPrivateImeOptions(IME_OPTION_NO_MICROPHONE);
        }
        updateViewsVisibility(isIconified());
    }

    public void setAppSearchData(Bundle bundle) {
        this.mAppSearchData = bundle;
    }

    public void setImeOptions(int i) {
        this.mSearchSrcTextView.setImeOptions(i);
    }

    public int getImeOptions() {
        return this.mSearchSrcTextView.getImeOptions();
    }

    public void setInputType(int i) {
        this.mSearchSrcTextView.setInputType(i);
    }

    public int getInputType() {
        return this.mSearchSrcTextView.getInputType();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.mClearingFocus || !isFocusable()) {
            return false;
        }
        if (isIconified()) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.mSearchSrcTextView.requestFocus(i, rect);
        if (requestFocus) {
            updateViewsVisibility(false);
        }
        return requestFocus;
    }

    public void clearFocus() {
        this.mClearingFocus = true;
        super.clearFocus();
        this.mSearchSrcTextView.clearFocus();
        this.mSearchSrcTextView.setImeVisibility(false);
        this.mClearingFocus = false;
    }

    public void setOnQueryTextListener(OnQueryTextListener onQueryTextListener) {
        this.mOnQueryChangeListener = onQueryTextListener;
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.mOnCloseListener = onCloseListener;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.mOnQueryTextFocusChangeListener = onFocusChangeListener;
    }

    public void setOnSuggestionListener(OnSuggestionListener onSuggestionListener) {
        this.mOnSuggestionListener = onSuggestionListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.mOnSearchClickListener = onClickListener;
    }

    public CharSequence getQuery() {
        return this.mSearchSrcTextView.getText();
    }

    public void setQuery(CharSequence charSequence, boolean z) {
        this.mSearchSrcTextView.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.mSearchSrcTextView;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.mUserQuery = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            onSubmitQuery();
        }
    }

    public void setQueryHint(CharSequence charSequence) {
        this.mQueryHint = charSequence;
        updateQueryHint();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.mQueryHint;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.mSearchable;
        if (searchableInfo == null || searchableInfo.getHintId() == 0) {
            return this.mDefaultQueryHint;
        }
        return getContext().getText(this.mSearchable.getHintId());
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.mIconifiedByDefault != z) {
            this.mIconifiedByDefault = z;
            updateViewsVisibility(z);
            updateQueryHint();
        }
    }

    public boolean isIconfiedByDefault() {
        return this.mIconifiedByDefault;
    }

    public void setIconified(boolean z) {
        if (z) {
            onCloseClicked();
        } else {
            onSearchClicked();
        }
    }

    public boolean isIconified() {
        return this.mIconified;
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.mSubmitButtonEnabled = z;
        updateViewsVisibility(isIconified());
    }

    public boolean isSubmitButtonEnabled() {
        return this.mSubmitButtonEnabled;
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.mQueryRefinement = z;
        CursorAdapter cursorAdapter = this.mSuggestionsAdapter;
        if (cursorAdapter instanceof SuggestionsAdapter) {
            ((SuggestionsAdapter) cursorAdapter).setQueryRefinement(z ? 2 : 1);
        }
    }

    public boolean isQueryRefinementEnabled() {
        return this.mQueryRefinement;
    }

    public void setSuggestionsAdapter(CursorAdapter cursorAdapter) {
        this.mSuggestionsAdapter = cursorAdapter;
        this.mSearchSrcTextView.setAdapter(cursorAdapter);
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.mSuggestionsAdapter;
    }

    public void setMaxWidth(int i) {
        this.mMaxWidth = i;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        if (isIconified()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            int i4 = this.mMaxWidth;
            size = i4 > 0 ? Math.min(i4, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.mMaxWidth;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i3 = this.mMaxWidth) > 0) {
            size = Math.min(i3, size);
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        boolean z2 = z;
        if (z2) {
            getChildBoundsWithinSearchView(this.mSearchSrcTextView, this.mSearchSrcTextViewBounds);
            this.mSearchSrtTextViewBoundsExpanded.set(this.mSearchSrcTextViewBounds.left, 0, this.mSearchSrcTextViewBounds.right, i4 - i2);
            UpdatableTouchDelegate updatableTouchDelegate = this.mTouchDelegate;
            if (updatableTouchDelegate == null) {
                UpdatableTouchDelegate updatableTouchDelegate2 = new UpdatableTouchDelegate(this.mSearchSrtTextViewBoundsExpanded, this.mSearchSrcTextViewBounds, this.mSearchSrcTextView);
                this.mTouchDelegate = updatableTouchDelegate2;
                setTouchDelegate(updatableTouchDelegate2);
                return;
            }
            updatableTouchDelegate.setBounds(this.mSearchSrtTextViewBoundsExpanded, this.mSearchSrcTextViewBounds);
        }
    }

    private void getChildBoundsWithinSearchView(View view, Rect rect) {
        view.getLocationInWindow(this.mTemp);
        getLocationInWindow(this.mTemp2);
        int[] iArr = this.mTemp;
        int i = iArr[1];
        int[] iArr2 = this.mTemp2;
        int i2 = i - iArr2[1];
        int i3 = iArr[0] - iArr2[0];
        rect.set(i3, i2, view.getWidth() + i3, view.getHeight() + i2);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    private void updateViewsVisibility(boolean z) {
        this.mIconified = z;
        int i = 0;
        int i2 = z ? 0 : 8;
        boolean isEmpty = TextUtils.isEmpty(this.mSearchSrcTextView.getText());
        this.mSearchButton.setVisibility(i2);
        updateSubmitButton(!isEmpty);
        this.mSearchEditFrame.setVisibility(z ? 8 : 0);
        if (this.mCollapsedIcon.getDrawable() == null || this.mIconifiedByDefault) {
            i = 8;
        }
        this.mCollapsedIcon.setVisibility(i);
        updateCloseButton();
        updateVoiceButton(isEmpty);
        updateSubmitArea();
    }

    private boolean hasVoiceSearch() {
        Intent intent;
        SearchableInfo searchableInfo = this.mSearchable;
        if (searchableInfo != null && searchableInfo.getVoiceSearchEnabled()) {
            if (this.mSearchable.getVoiceSearchLaunchWebSearch()) {
                intent = this.mVoiceWebSearchIntent;
            } else {
                intent = this.mSearchable.getVoiceSearchLaunchRecognizer() ? this.mVoiceAppSearchIntent : null;
            }
            if (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) {
                return false;
            }
            return true;
        }
        return false;
    }

    private boolean isSubmitAreaEnabled() {
        return (this.mSubmitButtonEnabled || this.mVoiceButtonEnabled) && !isIconified();
    }

    private void updateSubmitButton(boolean z) {
        this.mGoButton.setVisibility((!this.mSubmitButtonEnabled || !isSubmitAreaEnabled() || !hasFocus() || (!z && this.mVoiceButtonEnabled)) ? 8 : 0);
    }

    private void updateSubmitArea() {
        this.mSubmitArea.setVisibility((!isSubmitAreaEnabled() || !(this.mGoButton.getVisibility() == 0 || this.mVoiceButton.getVisibility() == 0)) ? 8 : 0);
    }

    private void updateCloseButton() {
        boolean isEmpty = TextUtils.isEmpty(this.mSearchSrcTextView.getText());
        int i = 0;
        boolean z = !isEmpty || (this.mIconifiedByDefault && !this.mExpandedInActionView);
        ImageView imageView = this.mCloseButton;
        if (!z) {
            i = 8;
        }
        imageView.setVisibility(i);
        Drawable drawable = this.mCloseButton.getDrawable();
        if (drawable != null) {
            drawable.setState(!isEmpty ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void postUpdateFocusedState() {
        post(this.mUpdateDrawableStateRunnable);
    }

    /* access modifiers changed from: package-private */
    public void updateFocusedState() {
        int[] iArr = this.mSearchSrcTextView.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable background = this.mSearchPlate.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.mSubmitArea.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.mUpdateDrawableStateRunnable);
        post(this.mReleaseCursorRunnable);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onQueryRefine(CharSequence charSequence) {
        setQuery(charSequence);
    }

    /* access modifiers changed from: package-private */
    public boolean onSuggestionsKey(View view, int i, KeyEvent keyEvent) {
        if (this.mSearchable != null && this.mSuggestionsAdapter != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i == 66 || i == 84 || i == 61) {
                return onItemClicked(this.mSearchSrcTextView.getListSelection(), 0, (String) null);
            }
            if (i == 21 || i == 22) {
                this.mSearchSrcTextView.setSelection(i == 21 ? 0 : this.mSearchSrcTextView.length());
                this.mSearchSrcTextView.setListSelection(0);
                this.mSearchSrcTextView.clearListSelection();
                this.mSearchSrcTextView.ensureImeVisible();
                return true;
            } else if (i == 19) {
                this.mSearchSrcTextView.getListSelection();
                return false;
            }
        }
        return false;
    }

    private CharSequence getDecoratedHint(CharSequence charSequence) {
        if (!this.mIconifiedByDefault || this.mSearchHintIcon == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.mSearchSrcTextView.getTextSize()) * 1.25d);
        this.mSearchHintIcon.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.mSearchHintIcon), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private void updateQueryHint() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.mSearchSrcTextView;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(getDecoratedHint(queryHint));
    }

    private void updateSearchAutoComplete() {
        this.mSearchSrcTextView.setThreshold(this.mSearchable.getSuggestThreshold());
        this.mSearchSrcTextView.setImeOptions(this.mSearchable.getImeOptions());
        int inputType = this.mSearchable.getInputType();
        int i = 1;
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.mSearchable.getSuggestAuthority() != null) {
                inputType |= 589824;
            }
        }
        this.mSearchSrcTextView.setInputType(inputType);
        CursorAdapter cursorAdapter = this.mSuggestionsAdapter;
        if (cursorAdapter != null) {
            cursorAdapter.changeCursor((Cursor) null);
        }
        if (this.mSearchable.getSuggestAuthority() != null) {
            SuggestionsAdapter suggestionsAdapter = new SuggestionsAdapter(getContext(), this, this.mSearchable, this.mOutsideDrawablesCache);
            this.mSuggestionsAdapter = suggestionsAdapter;
            this.mSearchSrcTextView.setAdapter(suggestionsAdapter);
            SuggestionsAdapter suggestionsAdapter2 = (SuggestionsAdapter) this.mSuggestionsAdapter;
            if (this.mQueryRefinement) {
                i = 2;
            }
            suggestionsAdapter2.setQueryRefinement(i);
        }
    }

    private void updateVoiceButton(boolean z) {
        int i = 8;
        if (this.mVoiceButtonEnabled && !isIconified() && z) {
            this.mGoButton.setVisibility(8);
            i = 0;
        }
        this.mVoiceButton.setVisibility(i);
    }

    /* access modifiers changed from: package-private */
    public void onTextChanged(CharSequence charSequence) {
        Editable text = this.mSearchSrcTextView.getText();
        this.mUserQuery = text;
        boolean isEmpty = TextUtils.isEmpty(text);
        updateSubmitButton(!isEmpty);
        updateVoiceButton(isEmpty);
        updateCloseButton();
        updateSubmitArea();
        if (this.mOnQueryChangeListener != null && !TextUtils.equals(charSequence, this.mOldQueryText)) {
            this.mOnQueryChangeListener.onQueryTextChange(charSequence.toString());
        }
        this.mOldQueryText = charSequence.toString();
    }

    /* access modifiers changed from: package-private */
    public void onSubmitQuery() {
        Editable text = this.mSearchSrcTextView.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            OnQueryTextListener onQueryTextListener = this.mOnQueryChangeListener;
            if (onQueryTextListener == null || !onQueryTextListener.onQueryTextSubmit(text.toString())) {
                if (this.mSearchable != null) {
                    launchQuerySearch(0, (String) null, text.toString());
                }
                this.mSearchSrcTextView.setImeVisibility(false);
                dismissSuggestions();
            }
        }
    }

    private void dismissSuggestions() {
        this.mSearchSrcTextView.dismissDropDown();
    }

    /* access modifiers changed from: package-private */
    public void onCloseClicked() {
        if (!TextUtils.isEmpty(this.mSearchSrcTextView.getText())) {
            this.mSearchSrcTextView.setText("");
            this.mSearchSrcTextView.requestFocus();
            this.mSearchSrcTextView.setImeVisibility(true);
        } else if (this.mIconifiedByDefault) {
            OnCloseListener onCloseListener = this.mOnCloseListener;
            if (onCloseListener == null || !onCloseListener.onClose()) {
                clearFocus();
                updateViewsVisibility(true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void onSearchClicked() {
        updateViewsVisibility(false);
        this.mSearchSrcTextView.requestFocus();
        this.mSearchSrcTextView.setImeVisibility(true);
        View.OnClickListener onClickListener = this.mOnSearchClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void onVoiceClicked() {
        SearchableInfo searchableInfo = this.mSearchable;
        if (searchableInfo != null) {
            try {
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    getContext().startActivity(createVoiceWebSearchIntent(this.mVoiceWebSearchIntent, searchableInfo));
                } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    getContext().startActivity(createVoiceAppSearchIntent(this.mVoiceAppSearchIntent, searchableInfo));
                }
            } catch (ActivityNotFoundException unused) {
                Log.w(LOG_TAG, "Could not find voice search activity");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void onTextFocusChanged() {
        updateViewsVisibility(isIconified());
        postUpdateFocusedState();
        if (this.mSearchSrcTextView.hasFocus()) {
            forceSuggestionQuery();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        postUpdateFocusedState();
    }

    public void onActionViewCollapsed() {
        setQuery("", false);
        clearFocus();
        updateViewsVisibility(true);
        this.mSearchSrcTextView.setImeOptions(this.mCollapsedImeOptions);
        this.mExpandedInActionView = false;
    }

    public void onActionViewExpanded() {
        if (!this.mExpandedInActionView) {
            this.mExpandedInActionView = true;
            int imeOptions = this.mSearchSrcTextView.getImeOptions();
            this.mCollapsedImeOptions = imeOptions;
            this.mSearchSrcTextView.setImeOptions(imeOptions | 33554432);
            this.mSearchSrcTextView.setText("");
            setIconified(false);
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean isIconified;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.isIconified = ((Boolean) parcel.readValue((ClassLoader) null)).booleanValue();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.isIconified));
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.isIconified + "}";
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.isIconified = isIconified();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        updateViewsVisibility(savedState.isIconified);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void adjustDropDownSizeAndPosition() {
        int i;
        if (this.mDropDownAnchor.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.mSearchPlate.getPaddingLeft();
            Rect rect = new Rect();
            boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
            int dimensionPixelSize = this.mIconifiedByDefault ? resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) : 0;
            this.mSearchSrcTextView.getDropDownBackground().getPadding(rect);
            if (isLayoutRtl) {
                i = -rect.left;
            } else {
                i = paddingLeft - (rect.left + dimensionPixelSize);
            }
            this.mSearchSrcTextView.setDropDownHorizontalOffset(i);
            this.mSearchSrcTextView.setDropDownWidth((((this.mDropDownAnchor.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean onItemClicked(int i, int i2, String str) {
        OnSuggestionListener onSuggestionListener = this.mOnSuggestionListener;
        if (onSuggestionListener != null && onSuggestionListener.onSuggestionClick(i)) {
            return false;
        }
        launchSuggestion(i, 0, (String) null);
        this.mSearchSrcTextView.setImeVisibility(false);
        dismissSuggestions();
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean onItemSelected(int i) {
        OnSuggestionListener onSuggestionListener = this.mOnSuggestionListener;
        if (onSuggestionListener != null && onSuggestionListener.onSuggestionSelect(i)) {
            return false;
        }
        rewriteQueryFromSuggestion(i);
        return true;
    }

    private void rewriteQueryFromSuggestion(int i) {
        Editable text = this.mSearchSrcTextView.getText();
        Cursor cursor = this.mSuggestionsAdapter.getCursor();
        if (cursor != null) {
            if (cursor.moveToPosition(i)) {
                CharSequence convertToString = this.mSuggestionsAdapter.convertToString(cursor);
                if (convertToString != null) {
                    setQuery(convertToString);
                } else {
                    setQuery(text);
                }
            } else {
                setQuery(text);
            }
        }
    }

    private boolean launchSuggestion(int i, int i2, String str) {
        Cursor cursor = this.mSuggestionsAdapter.getCursor();
        if (cursor == null || !cursor.moveToPosition(i)) {
            return false;
        }
        launchIntent(createIntentFromSuggestion(cursor, i2, str));
        return true;
    }

    private void launchIntent(Intent intent) {
        if (intent != null) {
            try {
                getContext().startActivity(intent);
            } catch (RuntimeException e) {
                Log.e(LOG_TAG, "Failed launch activity: " + intent, e);
            }
        }
    }

    private void setQuery(CharSequence charSequence) {
        this.mSearchSrcTextView.setText(charSequence);
        this.mSearchSrcTextView.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    /* access modifiers changed from: package-private */
    public void launchQuerySearch(int i, String str, String str2) {
        getContext().startActivity(createIntent("android.intent.action.SEARCH", (Uri) null, (String) null, str2, i, str));
    }

    private Intent createIntent(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.mUserQuery);
        if (str3 != null) {
            intent.putExtra(SearchIntents.EXTRA_QUERY, str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.mAppSearchData;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.mSearchable.getSearchActivity());
        return intent;
    }

    private Intent createVoiceWebSearchIntent(Intent intent, SearchableInfo searchableInfo) {
        String str;
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        if (searchActivity == null) {
            str = null;
        } else {
            str = searchActivity.flattenToShortString();
        }
        intent2.putExtra("calling_package", str);
        return intent2;
    }

    private Intent createVoiceAppSearchIntent(Intent intent, SearchableInfo searchableInfo) {
        String str;
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.mAppSearchData;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        if (searchableInfo.getVoiceLanguageModeId() != 0) {
            str = resources.getString(searchableInfo.getVoiceLanguageModeId());
        } else {
            str = "free_form";
        }
        String str2 = null;
        String string = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string2 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", str);
        intent3.putExtra("android.speech.extra.PROMPT", string);
        intent3.putExtra("android.speech.extra.LANGUAGE", string2);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        if (searchActivity != null) {
            str2 = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", str2);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent createIntentFromSuggestion(Cursor cursor, int i, String str) {
        int i2;
        Uri uri;
        String columnString;
        try {
            String columnString2 = SuggestionsAdapter.getColumnString(cursor, "suggest_intent_action");
            if (columnString2 == null) {
                columnString2 = this.mSearchable.getSuggestIntentAction();
            }
            if (columnString2 == null) {
                columnString2 = "android.intent.action.SEARCH";
            }
            String str2 = columnString2;
            String columnString3 = SuggestionsAdapter.getColumnString(cursor, "suggest_intent_data");
            if (columnString3 == null) {
                columnString3 = this.mSearchable.getSuggestIntentData();
            }
            if (!(columnString3 == null || (columnString = SuggestionsAdapter.getColumnString(cursor, "suggest_intent_data_id")) == null)) {
                columnString3 = columnString3 + RemoteSettings.FORWARD_SLASH_STRING + Uri.encode(columnString);
            }
            if (columnString3 == null) {
                uri = null;
            } else {
                uri = Uri.parse(columnString3);
            }
            return createIntent(str2, uri, SuggestionsAdapter.getColumnString(cursor, "suggest_intent_extra_data"), SuggestionsAdapter.getColumnString(cursor, "suggest_intent_query"), i, str);
        } catch (RuntimeException e) {
            RuntimeException runtimeException = e;
            try {
                i2 = cursor.getPosition();
            } catch (RuntimeException unused) {
                i2 = -1;
            }
            Log.w(LOG_TAG, "Search suggestions cursor at row " + i2 + " returned exception.", runtimeException);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void forceSuggestionQuery() {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.refreshAutoCompleteResults(this.mSearchSrcTextView);
            return;
        }
        PreQAutoCompleteTextViewReflector preQAutoCompleteTextViewReflector = PRE_API_29_HIDDEN_METHOD_INVOKER;
        preQAutoCompleteTextViewReflector.doBeforeTextChanged(this.mSearchSrcTextView);
        preQAutoCompleteTextViewReflector.doAfterTextChanged(this.mSearchSrcTextView);
    }

    static boolean isLandscapeMode(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private static class UpdatableTouchDelegate extends TouchDelegate {
        private final Rect mActualBounds = new Rect();
        private boolean mDelegateTargeted;
        private final View mDelegateView;
        private final int mSlop;
        private final Rect mSlopBounds = new Rect();
        private final Rect mTargetBounds = new Rect();

        public UpdatableTouchDelegate(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.mSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            setBounds(rect, rect2);
            this.mDelegateView = view;
        }

        public void setBounds(Rect rect, Rect rect2) {
            this.mTargetBounds.set(rect);
            this.mSlopBounds.set(rect);
            Rect rect3 = this.mSlopBounds;
            int i = this.mSlop;
            rect3.inset(-i, -i);
            this.mActualBounds.set(rect2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0043  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0077 A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouchEvent(android.view.MotionEvent r9) {
            /*
                r8 = this;
                float r0 = r9.getX()
                int r0 = (int) r0
                float r1 = r9.getY()
                int r1 = (int) r1
                int r2 = r9.getAction()
                r3 = 2
                r4 = 0
                r5 = 1
                if (r2 == 0) goto L_0x0033
                if (r2 == r5) goto L_0x0020
                if (r2 == r3) goto L_0x0020
                r6 = 3
                if (r2 == r6) goto L_0x001b
                goto L_0x003f
            L_0x001b:
                boolean r2 = r8.mDelegateTargeted
                r8.mDelegateTargeted = r4
                goto L_0x002f
            L_0x0020:
                boolean r2 = r8.mDelegateTargeted
                if (r2 == 0) goto L_0x002f
                android.graphics.Rect r6 = r8.mSlopBounds
                boolean r6 = r6.contains(r0, r1)
                if (r6 != 0) goto L_0x002f
                r5 = r2
                r2 = r4
                goto L_0x0041
            L_0x002f:
                r7 = r5
                r5 = r2
                r2 = r7
                goto L_0x0041
            L_0x0033:
                android.graphics.Rect r2 = r8.mTargetBounds
                boolean r2 = r2.contains(r0, r1)
                if (r2 == 0) goto L_0x003f
                r8.mDelegateTargeted = r5
                r2 = r5
                goto L_0x0041
            L_0x003f:
                r2 = r5
                r5 = r4
            L_0x0041:
                if (r5 == 0) goto L_0x0077
                if (r2 == 0) goto L_0x0061
                android.graphics.Rect r2 = r8.mActualBounds
                boolean r2 = r2.contains(r0, r1)
                if (r2 != 0) goto L_0x0061
                android.view.View r0 = r8.mDelegateView
                int r0 = r0.getWidth()
                int r0 = r0 / r3
                float r0 = (float) r0
                android.view.View r1 = r8.mDelegateView
                int r1 = r1.getHeight()
                int r1 = r1 / r3
                float r1 = (float) r1
                r9.setLocation(r0, r1)
                goto L_0x0070
            L_0x0061:
                android.graphics.Rect r2 = r8.mActualBounds
                int r2 = r2.left
                int r0 = r0 - r2
                float r0 = (float) r0
                android.graphics.Rect r2 = r8.mActualBounds
                int r2 = r2.top
                int r1 = r1 - r2
                float r1 = (float) r1
                r9.setLocation(r0, r1)
            L_0x0070:
                android.view.View r0 = r8.mDelegateView
                boolean r9 = r0.dispatchTouchEvent(r9)
                return r9
            L_0x0077:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.UpdatableTouchDelegate.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {
        private boolean mHasPendingShowSoftInputRequest;
        final Runnable mRunShowSoftInputIfNecessary;
        private SearchView mSearchView;
        private int mThreshold;

        public void performCompletion() {
        }

        /* access modifiers changed from: protected */
        public void replaceText(CharSequence charSequence) {
        }

        public SearchAutoComplete(Context context) {
            this(context, (AttributeSet) null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.mRunShowSoftInputIfNecessary = new Runnable() {
                public void run() {
                    SearchAutoComplete.this.showSoftInputIfNecessary();
                }
            };
            this.mThreshold = getThreshold();
        }

        /* access modifiers changed from: protected */
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        /* access modifiers changed from: package-private */
        public void setSearchView(SearchView searchView) {
            this.mSearchView = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.mThreshold = i;
        }

        /* access modifiers changed from: package-private */
        public boolean isEmpty() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.mSearchView.hasFocus() && getVisibility() == 0) {
                this.mHasPendingShowSoftInputRequest = true;
                if (SearchView.isLandscapeMode(getContext())) {
                    ensureImeVisible();
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.mSearchView.onTextFocusChanged();
        }

        public boolean enoughToFilter() {
            return this.mThreshold <= 0 || super.enoughToFilter();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.mSearchView.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i >= 960 && i2 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i < 600) {
                return (i < 640 || i2 < 480) ? 160 : 192;
            }
            return 192;
        }

        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.mHasPendingShowSoftInputRequest) {
                removeCallbacks(this.mRunShowSoftInputIfNecessary);
                post(this.mRunShowSoftInputIfNecessary);
            }
            return onCreateInputConnection;
        }

        /* access modifiers changed from: package-private */
        public void showSoftInputIfNecessary() {
            if (this.mHasPendingShowSoftInputRequest) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.mHasPendingShowSoftInputRequest = false;
            }
        }

        /* access modifiers changed from: package-private */
        public void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.mHasPendingShowSoftInputRequest = false;
                removeCallbacks(this.mRunShowSoftInputIfNecessary);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.mHasPendingShowSoftInputRequest = false;
                removeCallbacks(this.mRunShowSoftInputIfNecessary);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.mHasPendingShowSoftInputRequest = true;
            }
        }

        /* access modifiers changed from: package-private */
        public void ensureImeVisible() {
            if (Build.VERSION.SDK_INT >= 29) {
                Api29Impl.setInputMethodMode(this, 1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            SearchView.PRE_API_29_HIDDEN_METHOD_INVOKER.ensureImeVisible(this);
        }
    }

    private static class PreQAutoCompleteTextViewReflector {
        private Method mDoAfterTextChanged = null;
        private Method mDoBeforeTextChanged = null;
        private Method mEnsureImeVisible = null;

        PreQAutoCompleteTextViewReflector() {
            preApi29Check();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.mDoBeforeTextChanged = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.mDoAfterTextChanged = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            Class<AutoCompleteTextView> cls = AutoCompleteTextView.class;
            try {
                Method method = cls.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.mEnsureImeVisible = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        /* access modifiers changed from: package-private */
        public void doBeforeTextChanged(AutoCompleteTextView autoCompleteTextView) {
            preApi29Check();
            Method method = this.mDoBeforeTextChanged;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void doAfterTextChanged(AutoCompleteTextView autoCompleteTextView) {
            preApi29Check();
            Method method = this.mDoAfterTextChanged;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void ensureImeVisible(AutoCompleteTextView autoCompleteTextView) {
            preApi29Check();
            Method method = this.mEnsureImeVisible;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[]{true});
                } catch (Exception unused) {
                }
            }
        }

        private static void preApi29Check() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static void setInputMethodMode(SearchAutoComplete searchAutoComplete, int i) {
            searchAutoComplete.setInputMethodMode(i);
        }

        static void refreshAutoCompleteResults(AutoCompleteTextView autoCompleteTextView) {
            autoCompleteTextView.refreshAutoCompleteResults();
        }
    }
}
