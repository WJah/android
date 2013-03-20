/*
 * Copyright (C) 2013 The Android Open Source Project
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
package com.android.tools.idea.rendering;

import com.android.ide.common.rendering.api.RenderSession;
import com.android.ide.common.rendering.api.ViewInfo;
import com.intellij.openapi.module.Module;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

// TODO: Similar name to the unrelated RenderingResult class. This class needs a better name.
public class RenderResult {
  @NotNull public static final RenderResult NONE = new RenderResult();

  @NotNull private final PsiFile myFile;
  @NotNull private final RenderLogger myLogger;
  @Nullable private final List<ViewInfo> myRootViews;
  @Nullable private final ScalableImage myImage;
  @Nullable private RenderedViewHierarchy myHierarchy;
  @NotNull private final RenderService myRenderService;

  public RenderResult(@NotNull RenderService renderService,
                      @NotNull RenderSession session,
                      @NotNull PsiFile file,
                      @NotNull RenderLogger logger) {
    myRenderService = renderService;
    myFile = file;
    myLogger = logger;
    if (session.getResult().isSuccess()) {
      myRootViews = session.getRootViews();
      myImage = new ScalableImage(session);
    } else {
      myRootViews = null;
      myImage = null;
    }
  }

  private RenderResult() { // For the NONE instance
    myFile = null;
    myRootViews = null;
    myImage = null;
    myLogger = null;
    myRenderService = null;
  }

  @NotNull
  public RenderLogger getLogger() {
    return myLogger;
  }

  @Nullable
  public RenderedViewHierarchy getHierarchy() {
    if (myHierarchy == null && myRootViews != null) {
      myHierarchy = RenderedViewHierarchy.create(myFile, myRootViews);
    }

    return myHierarchy;
  }

  @Nullable
  public ScalableImage getImage() {
    return myImage;
  }

  @Nullable
  public List<ViewInfo> getRootViews() {
    return myRootViews;
  }

  @NotNull
  public PsiFile getFile() {
    return myFile;
  }

  @NotNull
  public RenderService getRenderService() {
    return myRenderService;
  }

  @NotNull
  public Module getModule() {
    return myLogger.getModule();
  }
}