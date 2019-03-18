package com.ns.greg.fastdialogfragment;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import com.ns.greg.library.fastdialogfragment.DialogWindowProperty;
import com.ns.greg.library.fastdialogfragment.FastDialog;
import com.ns.greg.library.fastdialogfragment.listener.SimpleDialogListener;

/**
 * Created by Gregory on 2017/6/29.
 */
public class DemoActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override protected void onResume() {
    super.onResume();
    new FastDialog.Builder().setTitle("TEST")
        .setMessage("FAST and EASY.")
        .setPositiveButtonLabel("OK")
        .setNegativeButtonLabel("CANCEL")
        .setSimpleDialogListener(new SimpleDialogListener() {
          @Override public void onShow(String tag, Dialog dialog) {
            super.onShow(tag, dialog);
            System.out.println("onShow - " + "tag = [" + tag + "], dialog = [" + dialog + "]");
          }

          @Override public void onPositiveClick(String tag, Dialog dialog) {
            super.onPositiveClick(tag, dialog);
            System.out.println(
                "onPositiveClick - " + "tag = [" + tag + "], dialog = [" + dialog + "]");
          }
        })
        .setDialogWindowProperty(new DialogWindowProperty.Builder().setGravity(Gravity.BOTTOM)
            .setBackgroundColor(Color.TRANSPARENT)
            .build())
        .build(getFragmentManager(), "TEST");
  }
}
