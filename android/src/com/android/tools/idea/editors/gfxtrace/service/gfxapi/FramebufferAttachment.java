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
 *
 * THIS FILE WAS GENERATED BY codergen. EDIT WITH CARE.
 */
package com.android.tools.idea.editors.gfxtrace.service.gfxapi;

import org.jetbrains.annotations.NotNull;
import com.android.tools.rpclib.binary.Decoder;
import com.android.tools.rpclib.binary.Encoder;
import java.io.IOException;

public final class FramebufferAttachment {
  public static final int Color = 0;
  public static FramebufferAttachment color() { return new FramebufferAttachment(Color); }
  public static final int Depth = 1;
  public static FramebufferAttachment depth() { return new FramebufferAttachment(Depth); }
  public static final int Stencil = 2;
  public static FramebufferAttachment stencil() { return new FramebufferAttachment(Stencil); }

  public final int value;

  public FramebufferAttachment(int value) {
    this.value = value;
  }

  public void encode(@NotNull Encoder e) throws IOException {
    e.uint32(value);
  }

  public static FramebufferAttachment decode(@NotNull Decoder d) throws IOException {
    int value = d.uint32();
    return new FramebufferAttachment(value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || !(o instanceof FramebufferAttachment)) return false;
    return value == ((FramebufferAttachment)o).value;
  }

  @Override
  public int hashCode() {
    return value;
  }

  @Override
  public String toString() {
    switch(value) {
      case Color: return "Color";
      case Depth: return "Depth";
      case Stencil: return "Stencil";
      default: return "FramebufferAttachment(" + value + ")";
    }
  }
}
