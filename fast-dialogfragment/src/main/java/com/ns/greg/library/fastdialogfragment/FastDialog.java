package com.ns.greg.library.fastdialogfragment;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.DimenRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import com.ns.greg.library.fastdialogfragment.listener.SimpleDialogListener;
import java.util.ArrayList;

/**
 * @author Gregory
 * @since 2016/2/24
 */
public class FastDialog {

  private FastDialog() {
    throw new UnsupportedOperationException();
  }

  public static final class Builder {

    private static final String TAG = "";

    private FastDialogFragment fragment;
    private Bundle bundle;
    private DialogWindowProperty dialogWindowProperty;

    public Builder() {
      this.fragment = new FastDialogFragment();
      this.bundle = new Bundle();
    }

    /**
     * Sets layout resource
     */
    public Builder setLayout(@LayoutRes int layoutId) {
      bundle.putInt(FastDialogFragment.FIELD_LAYOUT, layoutId);
      return this;
    }

    /**
     * Sets dialog title by resource
     */
    public Builder setTitle(@StringRes int titleId) {
      bundle.putInt(FastDialogFragment.FIELD_TITLE_RESOURCE, titleId);
      return this;
    }

    /**
     * Sets dialog title by string
     */
    public Builder setTitle(String title) {
      bundle.putString(FastDialogFragment.FIELD_TITLE_STRING, title);
      return this;
    }

    /**
     * Sets dialog message by resource
     */
    public Builder setMessage(@StringRes int stringId) {
      bundle.putInt(FastDialogFragment.FIELD_MESSAGE_RESOURCE, stringId);
      return this;
    }

    /**
     * Sets dialog message by string
     */
    public Builder setMessage(String string) {
      bundle.putString(FastDialogFragment.FIELD_MESSAGE_STRING, string);
      return this;
    }

    /**
     * Sets dialog message by String list
     */
    public Builder setMessage(ArrayList<String> strings) {
      bundle.putStringArrayList(FastDialogFragment.FIELD_LIST_ITEMS_STRING, strings);

      return this;
    }

    /**
     * Sets positive button label by resource
     */
    public Builder setPositiveButtonLabel(@StringRes int labelId) {
      bundle.putInt(FastDialogFragment.FIELD_LABEL_POSITIVE_RESOURCE, labelId);
      return this;
    }

    /**
     * Sets positive button label by string
     */
    public Builder setPositiveButtonLabel(String label) {
      bundle.putString(FastDialogFragment.FIELD_LABEL_POSITIVE_STRING, label);
      return this;
    }

    /**
     * Sets negative button label by resource id
     */
    public Builder setNegativeButtonLabel(@StringRes int labelId) {
      bundle.putInt(FastDialogFragment.FIELD_LABEL_NEGATIVE_RESOURCE, labelId);
      return this;
    }

    /**
     * Sets negative button label by string
     */
    public Builder setNegativeButtonLabel(String label) {
      bundle.putString(FastDialogFragment.FIELD_LABEL_NEGATIVE_STRING, label);
      return this;
    }

    /**
     * Sets neutral button label by resource id
     */
    public Builder setNeutralButtonLabel(@StringRes int labelId) {
      bundle.putInt(FastDialogFragment.FIELD_LABEL_NEUTRAL_RESOURCE, labelId);
      return this;
    }

    /**
     * Sets neutral button label by string
     */
    public Builder setNeutralButtonLabel(String label) {
      bundle.putString(FastDialogFragment.FIELD_LABEL_NEUTRAL_STRING, label);
      return this;
    }

    /**
     * Sets text size resource
     */
    public Builder setTextSizeResId(@DimenRes int sizeResId) {
      bundle.putInt(FastDialogFragment.FIELD_TEXT_SIZE, sizeResId);
      return this;
    }

    public Builder setDialogWindowProperty(DialogWindowProperty dialogWindowProperty) {
      this.dialogWindowProperty = dialogWindowProperty;
      return this;
    }

    /**
     * Sets dialog is cancelable or not
     *
     * @param cancelable true cancelable, false not
     */
    public Builder setCancelable(boolean cancelable) {
      this.fragment.setCancelable(cancelable);
      return this;
    }

    /**
     * Sets simple dialog listener
     *
     * @param listener simple dialog listener
     */
    public Builder setSimpleDialogListener(SimpleDialogListener listener) {
      fragment.setListener(listener);
      return this;
    }

    /**
     * Build dialog fragment
     */
    public void build(FragmentManager fragmentManager) {
      build(fragmentManager, TAG);
    }

    /**
     * Build dialog fragment
     */
    public void build(FragmentManager fragmentManager, String tag) {
      if (dialogWindowProperty == null) {
        dialogWindowProperty = new DialogWindowProperty.Builder().build();
      }
      /* put property */
      bundle.putParcelable(FastDialogFragment.FIELD_WINDOW_PROPERTY, dialogWindowProperty);
      fragment.setArguments(bundle);
      fragment.show(fragmentManager, tag);
    }
  }
}
