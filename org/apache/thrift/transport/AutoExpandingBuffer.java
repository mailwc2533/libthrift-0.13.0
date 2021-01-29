/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.thrift.transport;

import java.util.Arrays;

/**
 * Helper class that wraps a byte[] so that it can expand and be reused. Users
 * should call resizeIfNecessary to make sure the buffer has suitable capacity,
 * and then use the array as needed. Note that the internal array will grow at a
 * rate slightly faster than the requested capacity with the (untested)
 * objective of avoiding expensive buffer allocations and copies.
 */
class AutoExpandingBuffer {
  private byte[] array;

  public AutoExpandingBuffer(int initialCapacity) {
    this.array = new byte[initialCapacity];
  }

  public void resizeIfNecessary(int size) {
    final int currentCapacity = this.array.length;
    if (currentCapacity < size) {
      // Increase by a factor of 1.5x
      // 增加1.5倍
      int growCapacity = currentCapacity + (currentCapacity >> 1);
      int newCapacity = Math.max(growCapacity, size);
      this.array = Arrays.copyOf(array, newCapacity);
    }
  }

  public byte[] array() {
    return this.array;
  }
}
