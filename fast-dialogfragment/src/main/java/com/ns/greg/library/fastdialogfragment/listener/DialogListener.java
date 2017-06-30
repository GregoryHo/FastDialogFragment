package com.ns.greg.library.fastdialogfragment.listener;

import android.app.Dialog;

/**
 * Created by Gregory on 2016/8/31.
 */
public interface DialogListener {

  interface OnShowListener {

    /**
     * When dialog showing
     */
    void onShow(String tag, Dialog dialog);
  }

  interface OnDismissListener {

    /**
     * When dialog dismiss
     */
    void onDismiss(String tag);
  }

  interface OnButtonClickListener {

    /**
     * On dialog button click
     */
    void onPositiveClick(String tag, Dialog dialog);

    /**
     * On dialog button click
     */
    void onNegativeClick(String tag, Dialog dialog);

    /**
     * On dialog button click
     */
    void onNeutralClick(String tag, Dialog dialog);
  }

  interface OnItemClickListener {

    /**
     * On dialog default items (using list_items) click
     */
    void onItemClick(String tag, Dialog dialog, String title, int which); // For dialog default items
  }
}
