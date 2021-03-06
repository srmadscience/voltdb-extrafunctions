package javafunctions;

/* This file is part of VoltDB.
 * Copyright (C) 2008-2021 VoltDB Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

import org.voltdb.VoltProcedure.VoltAbortException;

/**
 * Class containing obscure math comparison functions not currently part of
 * VoltDB
 */
public class MathComparators {

    /**
     * 
     * Return the lesser of the two values. Note that null will always win.
     * 
     * @param value1
     * @param value2
     * @return lesser of value1 or value2
     * @throws VoltAbortException
     */
    public double least(double value1, double value2) throws VoltAbortException {

        if (value1 < value2) {
            return value1;
        }

        return value2;

    }

    /**
     * 
     * Return the greater of the two values. Note that null will always lose.
     * 
     * @param value1
     * @param value2
     * @return greater of value1 or value2
     * @throws VoltAbortException
     */
    public double greatest(double value1, double value2) throws VoltAbortException {

        if (value1 > value2) {
            return value1;
        }

        return value2;

    }

    /**
     * 
     * Map the input to 1, 0 or -1, depending on whether it's positive, zero or
     * negative.
     * 
     * @param value
     * @return -1, 0 or +1
     * @throws VoltAbortException if null is provided.
     */
    public byte sign(double value) throws VoltAbortException {

        if (value == Double.MIN_VALUE) {
            throw new VoltAbortException("value can not be null");
        }

        if (value > 0) {
            return 1;
        }

        if (value < 0) {
            return -1;
        }

        return 0;

    }

}
