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
package com.android.tools.idea.editors.gfxtrace.service;

import org.jetbrains.annotations.NotNull;
import com.android.tools.rpclib.binary.Decoder;
import com.android.tools.rpclib.binary.Encoder;
import java.io.IOException;

public final class TimingFlags {
  public static final int TimingCPU = 0;
  public static TimingFlags timingCPU() { return new TimingFlags(TimingCPU); }
  public static final int TimingGPU = 1;
  public static TimingFlags timingGPU() { return new TimingFlags(TimingGPU); }
  public static final int TimingPerCommand = 2;
  public static TimingFlags timingPerCommand() { return new TimingFlags(TimingPerCommand); }
  public static final int TimingPerDrawCall = 4;
  public static TimingFlags timingPerDrawCall() { return new TimingFlags(TimingPerDrawCall); }
  public static final int TimingPerFrame = 8;
  public static TimingFlags timingPerFrame() { return new TimingFlags(TimingPerFrame); }

  public final int value;

  public TimingFlags(int value) {
    this.value = value;
  }

  public void encode(@NotNull Encoder e) throws IOException {
    e.int32(value);
  }

  public static TimingFlags decode(@NotNull Decoder d) throws IOException {
    int value = d.int32();
    return new TimingFlags(value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || !(o instanceof TimingFlags)) return false;
    return value == ((TimingFlags)o).value;
  }

  @Override
  public int hashCode() {
    return value;
  }

  @Override
  public String toString() {
    switch(value) {
      case TimingCPU: return "TimingCPU";
      case TimingGPU: return "TimingGPU";
      case TimingPerCommand: return "TimingPerCommand";
      case TimingPerDrawCall: return "TimingPerDrawCall";
      case TimingPerFrame: return "TimingPerFrame";
      default: return "TimingFlags(" + value + ")";
    }
  }
}
