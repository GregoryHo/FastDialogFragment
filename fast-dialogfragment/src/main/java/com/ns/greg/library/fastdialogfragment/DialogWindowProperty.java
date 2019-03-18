package com.ns.greg.library.fastdialogfragment;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.ViewGroup;

/**
 * @author gregho
 * @since 2019/3/18
 */
public class DialogWindowProperty implements Parcelable {

  private final int width ;
  private final int height;
  private final int gravity;
  private final int deltaX;
  private final int deltaY;
  private final int backgroundResId;
  private final int backgroundColor;
  private final int animation;

  private DialogWindowProperty(int width, int height, int gravity, int deltaX, int deltaY,
      int backgroundResId, int backgroundColor,
      int animation) {
    this.width = width;
    this.height = height;
    this.gravity = gravity;
    this.deltaX = deltaX;
    this.deltaY = deltaY;
    this.backgroundResId = backgroundResId;
    this.backgroundColor = backgroundColor;
    this.animation = animation;

  }

  private DialogWindowProperty(Parcel in) {
    this.width = in.readInt();
    this.height = in.readInt();
    this.gravity = in.readInt();
    this.deltaX = in.readInt();
    this.deltaY = in.readInt();
    this.backgroundResId = in.readInt();
    this.backgroundColor = in.readInt();
    this.animation = in.readInt();
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(width);
    dest.writeInt(height);
    dest.writeInt(gravity);
    dest.writeInt(deltaX);
    dest.writeInt(deltaY);
    dest.writeInt(backgroundResId);
    dest.writeInt(backgroundColor);
    dest.writeInt(animation);
  }

  public int getAnimation() {
    return animation;
  }

  public int getGravity() {
    return gravity;
  }

  public int getDeltaX() {
    return deltaX;
  }

  public int getDeltaY() {
    return deltaY;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public int getBackgroundResId() {
    return backgroundResId;
  }

  public int getBackgroundColor() {
    return backgroundColor;
  }

  public static final Creator<DialogWindowProperty> CREATOR = new Creator<DialogWindowProperty>() {
    @Override
    public DialogWindowProperty createFromParcel(Parcel in) {
      return new DialogWindowProperty(in);
    }

    @Override
    public DialogWindowProperty[] newArray(int size) {
      return new DialogWindowProperty[size];
    }
  };

  public static final class Builder {

    private int width;
    private int height;
    private int gravity;
    private int deltaX;
    private int deltaY;
    private int backgroundResId;
    private int backgroundColor;
    private int animation;

    public Builder() {
      this.width = ViewGroup.LayoutParams.WRAP_CONTENT;
      this.height = ViewGroup.LayoutParams.WRAP_CONTENT;
      this.gravity = Gravity.CENTER;
      this.deltaX = 0;
      this.deltaY = 0;
      this.backgroundResId = -1;
      this.backgroundColor = -1;
      this.animation = -1;
    }

    public Builder setAnimation(int animation) {
      this.animation = animation;
      return this;
    }

    public Builder setGravity(int gravity) {
      this.gravity = gravity;
      return this;
    }

    public Builder setDeltaX(int deltaX) {
      this.deltaX = deltaX;
      return this;
    }

    public Builder setDeltaY(int deltaY) {
      this.deltaY = deltaY;
      return this;
    }

    public Builder setWidth(int width) {
      this.width = width;
      return this;
    }

    public Builder setHeight(int height) {
      this.height = height;
      return this;
    }

    public Builder setBackgroundResId(int backgroundResId) {
      this.backgroundResId = backgroundResId;
      return this;
    }

    public Builder setBackgroundColor(int backgroundColor) {
      this.backgroundColor = backgroundColor;
      return this;
    }

    public DialogWindowProperty build() {
      return new DialogWindowProperty(width, height, gravity, deltaX, deltaY, backgroundResId,
          backgroundColor, animation);
    }
  }
}
