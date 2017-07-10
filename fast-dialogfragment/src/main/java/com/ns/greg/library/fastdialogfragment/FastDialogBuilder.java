package com.ns.greg.library.fastdialogfragment;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.DimenRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import com.ns.greg.library.fastdialogfragment.listener.SimpleDialogListener;

/**
 * Created by Gregory on 2016/2/24.
 */
public class FastDialogBuilder {

  private FastDialogBuilder() {
    throw new UnsupportedOperationException();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {

    private final Bundle args;

    private final FastDialogFragment fragment;

    public Builder() {
      args = new Bundle();
      fragment = FastDialogFragment.newInstance();
    }

    /**
     * Sets text size resource
     */
    public Builder setTextSizeResId(@DimenRes int sizeResId) {
      fragment.setTextSizeResId(sizeResId);
      return this;
    }

    /**
     * Sets layout resource
     */
    public Builder setLayout(@LayoutRes int layoutId) {
      args.putInt(FastDialogFragment.FIELD_LAYOUT, layoutId);
      return this;
    }

    /**
     * Sets dialog title by resource
     */
    public Builder setTitle(@StringRes int titleId) {
      args.putInt(FastDialogFragment.FIELD_TITLE_RESOURCE, titleId);
      return this;
    }

    /**
     * Sets dialog title by string
     */
    public Builder setTitle(String title) {
      args.putString(FastDialogFragment.FIELD_TITLE_STRING, title);
      return this;
    }

    /**
     * Sets dialog message by resource
     */
    public Builder setMessage(@StringRes int stringId) {
      args.putInt(FastDialogFragment.FIELD_MESSAGE_RESOURCE, stringId);
      return this;
    }

    /**
     * Sets dialog message by string
     */
    public Builder setMessage(String string) {
      args.putString(FastDialogFragment.FIELD_MESSAGE_STRING, string);
      return this;
    }

    /**
     * Sets positive button label by resource
     */
    public Builder setPositiveButtonLabel(@StringRes int labelId) {
      args.putInt(FastDialogFragment.FIELD_LABEL_POSITIVE_RESOURCE, labelId);
      return this;
    }

    /**
     * Sets positive button label by string
     */
    public Builder setPositiveButtonLabel(String label) {
      args.putString(FastDialogFragment.FIELD_LABEL_POSITIVE_STRING, label);
      return this;
    }

    /**
     * Sets negative button label by resource id
     */
    public Builder setNegativeButtonLabel(@StringRes int labelId) {
      args.putInt(FastDialogFragment.FIELD_LABEL_NEGATIVE_RESOURCE, labelId);
      return this;
    }

    /**
     * Sets negative button label by string
     */
    public Builder setNegativeButtonLabel(String  label) {
      args.putString(FastDialogFragment.FIELD_LABEL_NEGATIVE_STRING, label);
      return this;
    }

    /**
     * Sets neutral button label by resource id
     */
    public Builder setNeutralButtonLabel(@StringRes int labelId) {
      args.putInt(FastDialogFragment.FIELD_LABEL_NEUTRAL_RESOURCE, labelId);
      return this;
    }

    /**
     * Sets neutral button label by string
     */
    public Builder setNeutralButtonLabel(String  label) {
      args.putString(FastDialogFragment.FIELD_LABEL_NEUTRAL_STRING, label);
      return this;
    }

    /**
     * Sets the dialog theme
     */
    public Builder setDialogTheme(int themeId) {
      fragment.setTheme(themeId);
      return this;
    }

    /**
     * Sets the dialog animation
     */
    public Builder setDialogAnimation(int animationId) {
      fragment.setAnimation(animationId);
      return this;
    }

    /**
     * Sets dialog window configuration
     */
    public Builder setDialogWindowConfiguration(int gravity, int width, int height) {
      fragment.setGravity(gravity);
      fragment.setWidth(width);
      fragment.setHeight(height);
      return this;
    }

    /**
     * Sets dialog position according by x and y axis
     */
    public Builder setDialogPosition(int x, int y) {
      fragment.setDeltaX(x);
      fragment.setDeltaY(y);
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
    public void build(FragmentManager fragmentManager, String tag) {
      fragment.setArguments(args);
      fragment.show(fragmentManager, tag);
    }
  }
}
