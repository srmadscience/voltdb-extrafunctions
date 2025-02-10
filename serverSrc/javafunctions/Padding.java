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

public class Padding {

    public String rpad(String inputValue, long length, String padString) throws VoltAbortException {

        if (inputValue == null) {
            throw new VoltAbortException("inputValue can not be null");
        }

        if (padString == null) {
            throw new VoltAbortException("padString can not be null");
        }

        if (length >= Integer.MAX_VALUE) {
            throw new VoltAbortException("length can not be > " + Integer.MAX_VALUE );
        }

        if (length < 0) {
            throw new VoltAbortException("length can not be negative");
        }

        if (inputValue.length() >= length) {
            return inputValue;
        }

        StringBuffer sb = new StringBuffer(inputValue);
        final char[] charArray = padString.toCharArray();
        long charsLeft = length - inputValue.length();

        while (charsLeft > 0) {

            for (int i = 0; i < charArray.length; i++) {
                sb.append(charArray[i]);
                if (--charsLeft <= 0) {
                    break;
                }
            }
        }

        return (sb.toString());

    }

    public String lpad(String inputValue, long length, String padString) throws VoltAbortException {

        if (inputValue == null) {
            throw new VoltAbortException("inputValue can not be null");
        }

        if (padString == null) {
            throw new VoltAbortException("padString can not be null");
        }

        if (length < 0) {
            throw new VoltAbortException("length can not be negative");
        }

        if (length >= Integer.MAX_VALUE) {
            throw new VoltAbortException("length can not be > " + Integer.MAX_VALUE );
        }

        if (inputValue.length() >= length) {
            return inputValue;
        }
        
        

        StringBuffer sb = new StringBuffer();
        final char[] charArray = padString.toCharArray();
        long charsLeft = length - inputValue.length();

        while (charsLeft > 0) {

            for (int i = 0; i < charArray.length; i++) {
                sb.append(charArray[i]);
                if (--charsLeft <= 0) {
                    break;
                }
            }
        }

        sb.append(inputValue);

        return (sb.toString());

    }
}
