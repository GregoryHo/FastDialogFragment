package com.ns.greg.library.fastdialogfragment;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.DimenRes;
import android.support.v7.app.AlertDialog;
import android.util.TypedValue;
import android.view.Gravity;
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
 * Created by Gregory on 2016/1/13.
 */
public class FastDialogFragment extends DialogFragment {

  public static final String FIELD_LAYOUT = "layout";
  public static final String FIELD_TITLE_RESOURCE = "title.res";
  public static final String FIELD_TITLE_STRING = "title.str";
  public static final String FIELD_MESSAGE_RESOURCE = "message.res";
  public static final String FIELD_MESSAGE_STRING = "message.str";
  public static final String FIELD_LIST_ITEMS = "list_items";
  public static final String FIELD_LIST_ITEMS_STRING = "list_items_string";
  public static final String FIELD_LABEL_POSITIVE_RESOURCE = "label_positive.res";
  public static final String FIELD_LABEL_POSITIVE_STRING = "label_positive.str";
  public static final String FIELD_LABEL_NEGATIVE_RESOURCE = "label_negative.res";
  public static final String FIELD_LABEL_NEGATIVE_STRING = "label_negative.str";
  public static final String FIELD_LABEL_NEUTRAL_RESOURCE = "label_neutral.res";
  public static final String FIELD_LABEL_NEUTRAL_STRING = "label_neutral.str";

  private AlertDialog mAlertDialog;

  // Dialog theme
  private int theme = R.style.fast_dialog_normal_style;

  // Dialog animation
  private int animation = -1;

  // Dialog position
  private int gravity = Gravity.CENTER;

  // Dialog y-axis distance
  private int deltaY = 0;

  // Dialog x-axis distance
  private int deltaX = 0;

  // Screen width
  private int width = ViewGroup.LayoutParams.WRAP_CONTENT;

  // Screen Height
  private int height = ViewGroup.LayoutParams.WRAP_CONTENT;

  private int textSizeResId = R.dimen.fast_dialog_small_text_size;

  private SimpleDialogListener dialogListener;

  public static FastDialogFragment newInstance() {
    return new FastDialogFragment();
  }

  @Override public void onCreate(Bundle savedInstance) {
    super.onCreate(savedInstance);
    setCancelable(true);
  }

  @Override public Dialog onCreateDialog(Bundle savedInstance) {
    Bundle args = getArguments();

    //ContextThemeWrapper _context = new ContextThemeWrapper(getActivity(), getTheme());

    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), theme);

    // [CUSTOM LAYOUT]
    if (args.containsKey(FIELD_LAYOUT)) {
      LayoutInflater inflater =
          (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      View content = inflater.inflate(args.getInt(FIELD_LAYOUT), null);
      builder.setView(content);
    }

    // [DIALOG TITLE]
    if (args.containsKey(FIELD_TITLE_RESOURCE)) {
      builder.setTitle(args.getInt(FIELD_TITLE_RESOURCE));
    } else if (args.containsKey(FIELD_TITLE_STRING)) {
      builder.setTitle(args.getString(FIELD_TITLE_RESOURCE));
    }

    // [DIALOG MESSAGE]
    if (args.containsKey(FIELD_MESSAGE_RESOURCE)) {
      builder.setMessage(args.getInt(FIELD_MESSAGE_RESOURCE));
    } else if (args.containsKey(FIELD_MESSAGE_STRING)) {
      builder.setMessage(args.getString(FIELD_MESSAGE_STRING));
    }

    // [DIALOG ITEMS]
    final List<String> items = new ArrayList<String>();
    if (args.containsKey(FIELD_LIST_ITEMS)) {
      final int[] listItems = args.getIntArray(FIELD_LIST_ITEMS);
      if (listItems != null) {
        for (int listItem : listItems) {
          items.add(getString(listItem));
        }
      }
    }

    if (args.containsKey(FIELD_LIST_ITEMS_STRING)) {
      final ArrayList<String> listItems = args.getStringArrayList(FIELD_LIST_ITEMS_STRING);
      if (listItems != null) {
        for (String lisItem : listItems) {
          items.add(lisItem);
        }
      }
    }

    if (items.size() > 0) {
      // if u want set onClickListener
      /*builder.setItems(items.toArray(new String[items.size()]), new DialogInterface.OnClickListener() {
        @Override
				public void onClick(DialogInterface dialog, int which) {
					if (fastDialogListener != null) {
						fastDialogListener.onDialogItemClick(getTag(), mAlertDialog, items.get(which), which);
					}
				}
			});*/

      builder.setItems(items.toArray(new String[items.size()]), null);
    }

    // [POSITIVE BUTTON]
    if (args.containsKey(FIELD_LABEL_POSITIVE_RESOURCE)) {
      builder.setPositiveButton(args.getInt(FIELD_LABEL_POSITIVE_RESOURCE),
          new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialog, int which) {
              // this will never be called, if we set View.onClickListener
            }
          });
    } else if (args.containsKey(FIELD_LABEL_POSITIVE_STRING)) {
      builder.setPositiveButton(args.getString(FIELD_LABEL_POSITIVE_STRING),
          new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialog, int which) {
              // this will never be called, if we set View.onClickListener
            }
          });
    }

    // [NEGATIVE BUTTON]
    if (args.containsKey(FIELD_LABEL_NEGATIVE_RESOURCE)) {
      builder.setNegativeButton(args.getInt(FIELD_LABEL_NEGATIVE_RESOURCE),
          new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialog, int which) {
              // this will never be called, if we set View.onClickListener
            }
          });
    } else if (args.containsKey(FIELD_LABEL_NEGATIVE_STRING)) {
      builder.setNegativeButton(args.getString(FIELD_LABEL_NEGATIVE_STRING),
          new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialog, int which) {
              // this will never be called, if we set View.onClickListener
            }
          });
    }

    // [NEUTRAL BUTTON]
    if (args.containsKey(FIELD_LABEL_NEUTRAL_RESOURCE)) {
      builder.setNeutralButton(args.getInt(FIELD_LABEL_NEUTRAL_RESOURCE),
          new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialog, int which) {
              // this will never be called, if we set View.onClickListener
            }
          });
    } else if (args.containsKey(FIELD_LABEL_NEUTRAL_STRING)) {
      builder.setNeutralButton(args.getString(FIELD_LABEL_NEUTRAL_STRING),
          new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialog, int which) {
              // this will never be called, if we set View.onClickListener
            }
          });
    }

    mAlertDialog = builder.create();

    return mAlertDialog;
  }

  @Override public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    // Registers View.onClickListener is to interrupt event from original listener
    if (dialogListener != null) {
      mAlertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
        @Override public void onShow(DialogInterface dialog) {
          dialogListener.onShow(getTag(), mAlertDialog);
          configureTitle();
          configurePositiveButton();
          configureNegativeButton();
          configureNeutralButton();
        }
      });
    }
  }

  private void configureTitle() {
    int titleDividerId = getResources().getIdentifier("titleDivider", "id", "android");
    View titleDivider = mAlertDialog.findViewById(titleDividerId);
    if (titleDivider != null) {
      titleDivider.setBackgroundColor(getResources().getColor(android.R.color.white));
    }
  }

  private void configurePositiveButton() {
    Button btnPositive = mAlertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
    btnPositive.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    btnPositive.setTextSize(TypedValue.COMPLEX_UNIT_PX,
        getResources().getDimensionPixelSize(textSizeResId));
    btnPositive.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        if (dialogListener != null) {
          dialogListener.onPositiveClick(getTag(), mAlertDialog);
        }
      }
    });
  }

  private void configureNegativeButton() {
    Button btnNegative = mAlertDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
    btnNegative.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    btnNegative.setTextSize(TypedValue.COMPLEX_UNIT_PX,
        getResources().getDimensionPixelSize(textSizeResId));
    btnNegative.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        if (dialogListener != null) {
          dialogListener.onNegativeClick(getTag(), mAlertDialog);
        }
      }
    });
  }

  private void configureNeutralButton() {
    Button btnNeutral = mAlertDialog.getButton(DialogInterface.BUTTON_NEUTRAL);
    btnNeutral.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    btnNeutral.setTextSize(TypedValue.COMPLEX_UNIT_PX,
        getResources().getDimensionPixelSize(textSizeResId));
    btnNeutral.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        if (dialogListener != null) {
          dialogListener.onNeutralClick(getTag(), mAlertDialog);
        }
      }
    });
  }

  @Override public void onStart() {
    super.onStart();

    // check
    if (getDialog() == null) {
      return;
    }

    Window window = getDialog().getWindow();
    if (window != null) {
      window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
      buildDialogWindow(window, gravity);
    }
  }

  private void buildDialogWindow(Window window, int gravity) {
    if (animation != -1) {
      window.setWindowAnimations(animation);
    }

    window.setGravity(gravity);
    WindowManager.LayoutParams wl = window.getAttributes();
    wl.width = width;
    wl.height = height;
    wl.y += deltaY;
    wl.x += deltaX;
    window.setAttributes(wl);
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
    dialogListener = listener;
  }

  /**
   * Sets the text size resource id of dialog layout
   */
  public void setTextSizeResId(@DimenRes int sizeResId) {
    this.textSizeResId = sizeResId;
  }

  /**
   * Sets the dialog's theme
   */
  public void setTheme(int theme) {
    this.theme = theme;
  }

  /**
   * Sets the dialog's animation
   */
  public void setAnimation(int animationId) {
    this.animation = animationId;
  }

  /**
   * Sets the gravity of dialog
   */
  public void setGravity(int gravity) {
    this.gravity = gravity;
  }

  /**
   * Sets the delta y for y-axis
   */
  public void setDeltaY(int deltaY) {
    this.deltaY = deltaY;
  }

  /**
   * Sets the delta x for x-axis
   */
  public void setDeltaX(int deltaX) {
    this.deltaX = deltaX;
  }

  /**
   * Sets the width of dialog layout
   */
  public void setWidth(int width) {
    this.width = width;
  }

  /**
   * Sets the height of dialog layout
   */
  public void setHeight(int height) {
    this.height = height;
  }
}
