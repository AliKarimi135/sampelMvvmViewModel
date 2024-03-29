package com.sepehran.siane.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.github.siyamed.shapeimageview.mask.PorterShapeImageView;
import com.sepehran.siane.activity.list.ListModelBinding;
import com.sepehran.siane.publics.PublicAdapterBinding;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemListBinding extends ViewDataBinding {
  @NonNull
  public final PorterShapeImageView imgFood;

  @NonNull
  public final LinearLayout layout;

  @Bindable
  protected PublicAdapterBinding.ClickListeners mPresenter;

  @Bindable
  protected ListModelBinding mListViewModel;

  protected ItemListBinding(Object _bindingComponent, View _root, int _localFieldCount,
      PorterShapeImageView imgFood, LinearLayout layout) {
    super(_bindingComponent, _root, _localFieldCount);
    this.imgFood = imgFood;
    this.layout = layout;
  }

  public abstract void setPresenter(@Nullable PublicAdapterBinding.ClickListeners presenter);

  @Nullable
  public PublicAdapterBinding.ClickListeners getPresenter() {
    return mPresenter;
  }

  public abstract void setListViewModel(@Nullable ListModelBinding ListViewModel);

  @Nullable
  public ListModelBinding getListViewModel() {
    return mListViewModel;
  }

  @NonNull
  public static ItemListBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_list, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemListBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemListBinding>inflateInternal(inflater, com.sepehran.siane.R.layout.item_list, root, attachToRoot, component);
  }

  @NonNull
  public static ItemListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_list, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemListBinding>inflateInternal(inflater, com.sepehran.siane.R.layout.item_list, null, false, component);
  }

  public static ItemListBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ItemListBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemListBinding)bind(component, view, com.sepehran.siane.R.layout.item_list);
  }
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               