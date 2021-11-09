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

public class MathTruncate {
    
    
    //TODO
    
    public double arbitraryTruncateNumberToPlaces (double theValue, int decimalPlaces) throws VoltAbortException {
        
        if (theValue == Double.MIN_VALUE) {
            throw new VoltAbortException("Value can not be null");
        }
        
        if (decimalPlaces == Integer.MIN_VALUE) {
            throw new VoltAbortException("decimalPlaces can not be null");
        }
        
        double divisor = 1;
        
        if (decimalPlaces != 0) {
            divisor = divisor / Math.pow(10, decimalPlaces);
        }
        
        long goesInto = (long) (theValue / divisor);
      
        // Calculate offset
        final double newValue = goesInto * divisor;
         
        return newValue;
         
     }

    public double arbitraryTruncateNumber (double theValue) throws VoltAbortException {
        
        return arbitraryTruncateNumberToPlaces(theValue,0);
         
     }

   

    
}
