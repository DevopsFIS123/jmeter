/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.jmeter.testelement.schema

import org.apache.jmeter.testelement.TestElement
import org.apache.jmeter.testelement.TestElementSchema
import org.apache.jmeter.testelement.property.DoubleProperty
import org.apiguardian.api.API
import kotlin.reflect.KProperty

/**
 * Describes a [DoubleProperty] that contains class reference: name, default value, and provides accessors for properties.
 * Use [EmptyTestElementSchema.double] for building the property descriptors.
 * @since 5.6
 */
@API(status = API.Status.EXPERIMENTAL, since = "5.6")
public class DoublePropertyDescriptor<in Schema : TestElementSchema>(
    public override val name: String,
    /** Default value, null means there's no default */
    public override val defaultValue: Double?
) : PropertyDescriptor<Schema, Double> {
    private companion object {
        private const val serialVersionUID: Long = 1
    }

    override fun toString(): String = "DoublePropertyDescriptor(name='$name', defaultValue='$defaultValue')"

    public operator fun get(target: TestElement): Double =
        target[this]

    public operator fun set(target: TestElement, value: Double) {
        target[this] = value
    }

    @JvmSynthetic
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun getValue(testElement: TestElement, property: KProperty<*>): Double {
        return testElement[this]
    }

    @JvmSynthetic
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun setValue(testElement: TestElement, property: KProperty<*>, value: Double) {
        testElement[this] = value
    }
}