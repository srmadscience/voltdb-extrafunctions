package javafunctions;

import java.text.SimpleDateFormat;
import java.util.Date;

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
import org.voltdb.types.TimestampType;

public class DateFormatting {

    public String toSimpleDateFormat(String formatMask, TimestampType dateValue) throws VoltAbortException {

        SimpleDateFormat simpleDateFormat = null;

        if (formatMask == null) {
            throw new VoltAbortException("formatMask can not be null");
        }

        if (dateValue == null) {
            throw new VoltAbortException("dateValue can not be null");
        }

        try {
            simpleDateFormat = new SimpleDateFormat(formatMask);
        } catch (IllegalArgumentException e) {
            throw new VoltAbortException("Unusable formatMask: '" + formatMask + "' " + e.getMessage());
        }

        return (simpleDateFormat.format(dateValue.asExactJavaDate()));

    }

}
