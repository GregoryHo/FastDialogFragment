package com.ns.greg.library.fastdialogfragment.listener;

import android.app.Dialog;
import java.lang.ref.WeakReference;

/**
 * Created by Gregory on 2017/6/29.
 */

public class SimpleDialogListener<T>
    implements DialogListener.OnShowListener, DialogListener.OnDismissListener,
    DialogListener.OnButtonClickListener, DialogListener.OnItemClickListener {

  private final T instance;

  public SimpleDialogListener() {
    instance = null;
  }

  public SimpleDialogListener(T reference) {
    WeakReference<T> weakReference = new WeakReference<T>(reference);
    instance = weakReference.get();
  }

  public T getInstance() {
    return instance;
  }

  @Override public void onShow(String tag, Dialog dialog) {

  }

  @Override public void onDismiss(String tag) {

  }

  @Override public void onPositiveClick(String tag, Dialog dialog) {

  }

  @Override public void onNegativeClick(String tag, Dialog dialog) {
    dialog.dismiss();
  }

  @Override public void onNeutralClick(String tag, Dialog dialog) {

  }

  @Override public void onItemClick(String tag, Dialog dialog, String title, int which) {

  }
}
