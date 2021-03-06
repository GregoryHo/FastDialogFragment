package com.ns.greg.library.fastdialogfragment.listener;

import android.app.Dialog;

/**
 * @author Gregory
 * @since 2017/6/29
 */

public class SimpleDialogListener
    implements DialogListener.OnShowListener, DialogListener.OnDismissListener,
    DialogListener.OnButtonClickListener, DialogListener.OnItemClickListener {

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
