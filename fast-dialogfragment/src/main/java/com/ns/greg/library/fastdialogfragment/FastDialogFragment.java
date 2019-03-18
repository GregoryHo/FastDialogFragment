package com.ns.greg.library.fastdialogfragment;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import com.ns.greg.library.fastdialogfragment.listener.DialogListener;
import com.ns.greg.library.fastdialogfragment.listener.SimpleDialogListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gregory
 * @since 2016/1/13
 */
public class FastDialogFragment extends DialogFragment {

  static final String FIELD_THEME = "theme";
  static final String FIELD_WINDOW_PROPERTY = "window.properties";
  static final String FIELD_LAYOUT = "layout";
  static final String FIELD_TITLE_RESOURCE = "title.res";
  static final String FIELD_TITLE_STRING = "title.str";
  static final String FIELD_MESSAGE_RESOURCE = "message.res";
  static final String FIELD_MESSAGE_STRING = "message.str";
  static final String FIELD_LIST_ITEMS = "list.items";
  static final String FIELD_LIST_ITEMS_STRING = "list.items.string";
  static final String FIELD_LABEL_POSITIVE_RESOURCE = "label.positive.res";
  static final String FIELD_LABEL_POSITIVE_STRING = "label.positive.str";
  static final String FIELD_LABEL_NEGATIVE_RESOURCE = "label.negative.res";
  static final String FIELD_LABEL_NEGATIVE_STRING = "label.negative.str";
  static final String FIELD_LABEL_NEUTRAL_RESOURCE = "label.neutral.res";
  static final String FIELD_LABEL_NEUTRAL_STRING = "label.neutral.str";
  static final String FIELD_TEXT_SIZE = "text.size";

  private AlertDialog alertDialog;
  private SimpleDialogListener dialogListener;

  @Override public Dialog onCreateDialog(Bundle savedInstance) {
    Bundle bundle = getArguments();
    //ContextThemeWrapper _context = new ContextThemeWrapper(getActivity(), getTheme());
    /* theme field */
    int theme;
    if (bundle.containsKey(FIELD_THEME)) {
      theme = bundle.getInt(FIELD_THEME);
    } else {
      theme = R.style.fast_dialog_normal_style;
    }
    /* dialog builder */
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), theme);
    /* layout field */
    if (bundle.containsKey(FIELD_LAYOUT)) {
      LayoutInflater inflater =
          (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      if (inflater != null) {
        View content = inflater.inflate(bundle.getInt(FIELD_LAYOUT), null);
        builder.setView(content);
      }
    }
    /* title field */
    if (bundle.containsKey(FIELD_TITLE_RESOURCE)) {
      builder.setTitle(bundle.getInt(FIELD_TITLE_RESOURCE));
    } else if (bundle.containsKey(FIELD_TITLE_STRING)) {
      builder.setTitle(bundle.getString(FIELD_TITLE_STRING));
    }
    /* message field */
    if (bundle.containsKey(FIELD_MESSAGE_RESOURCE)) {
      builder.setMessage(bundle.getInt(FIELD_MESSAGE_RESOURCE));
    } else if (bundle.containsKey(FIELD_MESSAGE_STRING)) {
      builder.setMessage(bundle.getString(FIELD_MESSAGE_STRING));
    }
    /* items field */
    final List<String> items = new ArrayList<String>();
    if (bundle.containsKey(FIELD_LIST_ITEMS)) {
      final int[] listItems = bundle.getIntArray(FIELD_LIST_ITEMS);
      if (listItems != null) {
        for (int listItem : listItems) {
          items.add(getString(listItem));
        }
      }
    }
    /* string items field */
    if (bundle.containsKey(FIELD_LIST_ITEMS_STRING)) {
      final ArrayList<String> listItems = bundle.getStringArrayList(FIELD_LIST_ITEMS_STRING);
      if (listItems != null) {
        items.addAll(listItems);
      }
    }

    if (items.size() > 0) {
      // if u want set onClickListener
      /*builder.setItems(items.toArray(new String[items.size()]), new DialogInterface.OnClickListener() {
        @Override
				public void onClick(DialogInterface dialog, int which) {
					if (fastDialogListener != null) {
						fastDialogListener.onDialogItemClick(getTag(), alertDialog, items.get(which), which);
					}
				}
			});*/
      builder.setItems(items.toArray(new String[0]), null);
    }
    /* positive button filed */
    if (bundle.containsKey(FIELD_LABEL_POSITIVE_RESOURCE)) {
      builder.setPositiveButton(bundle.getInt(FIELD_LABEL_POSITIVE_RESOURCE),
          new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialog, int which) {
              // this will never be called, if we set View.onClickListener
            }
          });
    } else if (bundle.containsKey(FIELD_LABEL_POSITIVE_STRING)) {
      builder.setPositiveButton(bundle.getString(FIELD_LABEL_POSITIVE_STRING),
          new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialog, int which) {
              // this will never be called, if we set View.onClickListener
            }
          });
    }
    /* negative button field */
    if (bundle.containsKey(FIELD_LABEL_NEGATIVE_RESOURCE)) {
      builder.setNegativeButton(bundle.getInt(FIELD_LABEL_NEGATIVE_RESOURCE),
          new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialog, int which) {
              // this will never be called, if we set View.onClickListener
            }
          });
    } else if (bundle.containsKey(FIELD_LABEL_NEGATIVE_STRING)) {
      builder.setNegativeButton(bundle.getString(FIELD_LABEL_NEGATIVE_STRING),
          new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialog, int which) {
              // this will never be called, if we set View.onClickListener
            }
          });
    }
    /* neutral button field */
    if (bundle.containsKey(FIELD_LABEL_NEUTRAL_RESOURCE)) {
      builder.setNeutralButton(bundle.getInt(FIELD_LABEL_NEUTRAL_RESOURCE),
          new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialog, int which) {
              // this will never be called, if we set View.onClickListener
            }
          });
    } else if (bundle.containsKey(FIELD_LABEL_NEUTRAL_STRING)) {
      builder.setNeutralButton(bundle.getString(FIELD_LABEL_NEUTRAL_STRING),
          new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialog, int which) {
              // this will never be called, if we set View.onClickListener
            }
          });
    }

    alertDialog = builder.create();
    return alertDialog;
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      Bundle savedInstanceState) {
    buildDialogWindow();
    return super.onCreateView(inflater, container, savedInstanceState);
  }

  @Override public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    // Registers View.onClickListener is to interrupt event from original listener
    if (dialogListener != null) {
      alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
        @Override public void onShow(DialogInterface dialog) {
          Bundle bundle = getArguments();
          int dimenId = bundle.getInt(FIELD_TEXT_SIZE, R.dimen.fast_dialog_small_text_size);
          configureTitle(dimenId);
          configurePositiveButton(dimenId);
          configureNegativeButton(dimenId);
          configureNeutralButton(dimenId);
          dialogListener.onShow(getTag(), alertDialog);
        }
      });
    }
  }

  private void configureTitle(int dimenId) {
    int titleDividerId = getResources().getIdentifier("titleDivider", "id", "android");
    View titleDivider = alertDialog.findViewById(titleDividerId);
    if (titleDivider != null) {
      titleDivider.setBackgroundColor(getResources().getColor(android.R.color.white));
    }
  }

  private void configurePositiveButton(int dimenId) {
    Button positiveBtn = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
    positiveBtn.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    positiveBtn.setTextSize(TypedValue.COMPLEX_UNIT_PX,
        getResources().getDimensionPixelSize(dimenId));
    positiveBtn.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        if (dialogListener != null) {
          dialogListener.onPositiveClick(getTag(), alertDialog);
        }
      }
    });
  }

  private void configureNegativeButton(int dimenId) {
    Button negativeBtn = alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
    negativeBtn.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    negativeBtn.setTextSize(TypedValue.COMPLEX_UNIT_PX,
        getResources().getDimensionPixelSize(dimenId));
    negativeBtn.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        if (dialogListener != null) {
          dialogListener.onNegativeClick(getTag(), alertDialog);
        }
      }
    });
  }

  private void configureNeutralButton(int dimenId) {
    Button neutralBtn = alertDialog.getButton(DialogInterface.BUTTON_NEUTRAL);
    neutralBtn.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    neutralBtn.setTextSize(TypedValue.COMPLEX_UNIT_PX,
        getResources().getDimensionPixelSize(dimenId));
    neutralBtn.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        if (dialogListener != null) {
          dialogListener.onNeutralClick(getTag(), alertDialog);
        }
      }
    });
  }

  private void buildDialogWindow() {
    Window window = getDialog().getWindow();
    if (window == null) {
      return;
    }
    /* input mode */
    window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    /* window property */
    Bundle bundle = getArguments();
    DialogWindowProperty property = bundle.getParcelable(FIELD_WINDOW_PROPERTY);
    if (property == null) {
      return;
    }

    int animation = property.getAnimation();
    if (animation != -1) {
      window.setWindowAnimations(animation);
    }

    window.setGravity(property.getGravity());
    WindowManager.LayoutParams wl = window.getAttributes();
    wl.width = property.getWidth();
    wl.height = property.getHeight();
    wl.x += property.getDeltaX();
    wl.y += property.getDeltaY();
    window.setAttributes(wl);
    int backgroundResId = property.getBackgroundResId();
    int backgroundColor = property.getBackgroundColor();
    if (backgroundResId != -1) {
      window.setBackgroundDrawable(getResources().getDrawable(backgroundResId));
    } else if (backgroundColor != -1) {
      window.setBackgroundDrawable(new ColorDrawable(backgroundColor));
    }
  }

  @Override public void onDismiss(DialogInterface dialog) {
    super.onDismiss(dialog);
    if (dialogListener != null) {
      dialogListener.onDismiss(getTag());
    }
  }

  /**
   * Sets custom dialog listener to received call back from {@link DialogListener}
   */
  public void setListener(SimpleDialogListener listener) {
    this.dialogListener = listener;
  }
}
