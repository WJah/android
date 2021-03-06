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
package com.android.tools.idea.editors.gfxtrace.service.path;

import com.android.tools.rpclib.schema.*;
import org.jetbrains.annotations.NotNull;

import com.android.tools.rpclib.binary.BinaryClass;
import com.android.tools.rpclib.binary.BinaryID;
import com.android.tools.rpclib.binary.BinaryObject;
import com.android.tools.rpclib.binary.Decoder;
import com.android.tools.rpclib.binary.Encoder;
import com.android.tools.rpclib.binary.Namespace;
import com.android.tools.rpclib.any.Box;

import java.io.IOException;

public final class AsPath extends Path {
  @Override
  public StringBuilder stringPath(StringBuilder builder) {
    return myObject.stringPath(builder).append(".As<").append(myType).append(">");
  }

  @Override
  public Path getParent() {
    return myObject;
  }

  //<<<Start:Java.ClassBody:1>>>
  private Path myObject;
  private Object myType;

  // Constructs a default-initialized {@link AsPath}.
  public AsPath() {}


  public Path getObject() {
    return myObject;
  }

  public AsPath setObject(Path v) {
    myObject = v;
    return this;
  }

  public Object getType() {
    return myType;
  }

  public AsPath setType(Object v) {
    myType = v;
    return this;
  }

  @Override @NotNull
  public BinaryClass klass() { return Klass.INSTANCE; }


  private static final Entity ENTITY = new Entity("path","As","","");

  static {
    ENTITY.setFields(new Field[]{
      new Field("Object", new Interface("Path")),
      new Field("Type", new AnyType()),
    });
    Namespace.register(Klass.INSTANCE);
  }
  public static void register() {}
  //<<<End:Java.ClassBody:1>>>
  public enum Klass implements BinaryClass {
    //<<<Start:Java.KlassBody:2>>>
    INSTANCE;

    @Override @NotNull
    public Entity entity() { return ENTITY; }

    @Override @NotNull
    public BinaryObject create() { return new AsPath(); }

    @Override
    public void encode(@NotNull Encoder e, BinaryObject obj) throws IOException {
      AsPath o = (AsPath)obj;
      e.object(o.myObject.unwrap());
      e.variant(Box.wrap(o.myType));
    }

    @Override
    public void decode(@NotNull Decoder d, BinaryObject obj) throws IOException {
      AsPath o = (AsPath)obj;
      o.myObject = Path.wrap(d.object());
      o.myType = ((Box)d.variant()).unwrap();
    }
    //<<<End:Java.KlassBody:2>>>
  }
}
