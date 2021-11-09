

file -inlinebatch END_OF_BATCH

DROP FUNCTION GREATEST IF EXISTS;
DROP FUNCTION LEAST IF EXISTS;
DROP FUNCTION SIGN2 IF EXISTS;
DROP FUNCTION arbitraryTruncateWithBaseTime IF EXISTS;
DROP FUNCTION arbitraryTruncate             IF EXISTS;

END_OF_BATCH


LOAD CLASSES ../jars/voltdb-functions.jar;


file -inlinebatch END_OF_BATCH


CREATE FUNCTION GREATEST FROM METHOD javafunctions.MathComparators.greatest;
CREATE FUNCTION LEAST    FROM METHOD javafunctions.MathComparators.least;
CREATE FUNCTION SIGN2    FROM METHOD javafunctions.MathComparators.sign;
CREATE FUNCTION  arbitraryTruncateWithBaseTime FROM METHOD javafunctions.ArbitraryTruncate.arbitraryTruncateWithBaseTime;
CREATE FUNCTION  arbitraryTruncate             FROM METHOD javafunctions.ArbitraryTruncate.arbitraryTruncate;



END_OF_BATCH




