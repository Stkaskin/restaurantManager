package com.stkaskin.restaurantmanager.Models.Model;

import com.stkaskin.restaurantmanager.Models.Extra;
import com.stkaskin.restaurantmanager.Models.ExtraDetail;

import java.util.ArrayList;

public class ExtraAndDetailModel {
  ExtraDetail detail;
  Extra extra;

  public ExtraDetail getDetail() {
    return detail;
  }

  public void setDetail(ExtraDetail detail) {
    this.detail = detail;
  }

  public Extra getExtra() {
    return extra;
  }

  public void setExtra(Extra extra) {
    this.extra = extra;
  }
}
