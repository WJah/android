/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.tools.idea.uibuilder.handlers;

import com.android.SdkConstants;
import com.android.annotations.NonNull;
import com.android.annotations.Nullable;
import com.android.tools.idea.uibuilder.model.NlComponent;

import static com.android.SdkConstants.COORDINATOR_LAYOUT;

public class FloatingActionButtonHandler extends ImageViewHandler {

  @Override
  public String getSampleImageSrc() {
    // Builtin graphics available since v1:
    return "@android:drawable/ic_input_add"; //$NON-NLS-1$
  }

  @Override
  public boolean acceptsParent(@NonNull NlComponent layout, @NonNull NlComponent newChild) {
    NlComponent appBar = getAppBar(layout);
    if (appBar == null) {
      return super.acceptsParent(layout, newChild);
    }
    return layout == appBar.getParent();
  }

  @Nullable
  private static NlComponent getAppBar(@NonNull NlComponent component) {
    NlComponent parent = component.getParent();
    while (parent != null) {
      component = parent;
      parent = component.getParent();
    }
    if (!component.getTagName().equals(COORDINATOR_LAYOUT)) {
      return null;
    }
    for (NlComponent child : component.getChildren()) {
      if (child.getTagName().equals(SdkConstants.APP_BAR_LAYOUT)) {
        return child;
      }
    }
    return null;
  }
}
