/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.data.properties;

import org.spongepowered.api.data.Property;
import org.spongepowered.api.util.Coerce;

/**
 * Represents an block property that has an integer value. Examples may include
 */
public class IntProperty extends AbstractProperty<String, Integer> {

    /**
     * Create a new integer property with the specified value.
     *
     * @param value value to match
     */
    public IntProperty(int value) {
        super(Coerce.toInteger(value));
    }

    /**
     * Create a new integer property with the specified value and logical
     * operator.
     *
     * @param value value to match
     * @param operator logical operator to use when comparing to other
     *      properties
     */
    public IntProperty(int value, Operator operator) {
        super(value, operator);
    }

    /**
     * Create a new integer property with the specified value and logical
     * operator.
     *
     * @param value value to match
     * @param operator logical operator to use when comparing to other
     *      properties
     */
    public IntProperty(Object value, Operator operator) {
        super(Coerce.toInteger(value), operator);
    }

    @Override
    public int compareTo(Property<?, ?> other) {
        return this.getValue().compareTo(other == null ? 1 : Coerce.toInteger(other.getValue()));
    }

    /**
     * Create an IntProperty property which matches IntProperty properties with
     * equal value.
     *
     * @param value value to match
     * @return new property
     */
    public static IntProperty of(Object value) {
        return new IntProperty(value, Operator.EQUAL);
    }

    /**
     * Create an IntProperty property which matches IntProperty properties with
     * unequal value.
     *
     * @param value value to match
     * @return new property
     */
    public static IntProperty not(Object value) {
        return new IntProperty(value, Operator.NOTEQUAL);
    }

    /**
     * Create an IntProperty property which matches IntProperty properties with
     * value greater than this value.
     *
     * @param value value to match
     * @return new property
     */
    public static IntProperty greaterThan(Object value) {
        return new IntProperty(value, Operator.GREATER);
    }

    /**
     * Create an IntProperty property which matches IntProperty properties with
     * value greater than or equal to this value.
     *
     * @param value value to match
     * @return new property
     */
    public static IntProperty greaterThanOrEqual(Object value) {
        return new IntProperty(value, Operator.GEQUAL);
    }

    /**
     * Create an IntProperty property which matches IntProperty properties with
     * value less than this value.
     *
     * @param value value to match
     * @return new property
     */
    public static IntProperty lessThan(Object value) {
        return new IntProperty(value, Operator.LESS);
    }

    /**
     * Create an IntProperty property which matches IntProperty properties with
     * value less than or equal to this value.
     *
     * @param value value to match
     * @return new property
     */
    public static IntProperty lessThanOrEqual(Object value) {
        return new IntProperty(value, Operator.LEQUAL);
    }

}
