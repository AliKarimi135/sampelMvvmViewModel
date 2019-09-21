package com.sepehran.siane.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.sepehran.siane.activity.order.childfragment.ListModelBinding;
import com.sepehran.siane.publics.PublicAdapterBinding;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemSelectProblemBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout layout;

  @NonNull
  public final SwitchCompat switchproblem;

  @Bindable
  protected PublicAdapterBinding.ClickListenersBrand mPresenter;

  @Bindable
  protected ListModelBinding mSelectProblemViewModel;

  protected ItemSelectProblemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      LinearLayout layout, SwitchCompat switchproblem) {
    super(_bindingComponent, _root, _localFieldCount);
    this.layout = layout;
    this.switchproblem = switchproblem;
  }

  public abstract void setPresenter(@Nullable PublicAdapterBinding.ClickListenersBrand presenter);

  @Nullable
  public PublicAdapterBinding.ClickListenersBrand getPresenter() {
    return mPresenter;
  }

  public abstract void setSelectProblemViewModel(@Nullable ListModelBinding SelectProblemViewModel);

  @Nullable
  public ListModelBinding getSelectProblemViewModel() {
    return mSelectProblemViewModel;
  }

  @NonNull
  public static ItemSelectProblemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_selectproblem, root, attachToRoot, component)
   */
  @NonNull