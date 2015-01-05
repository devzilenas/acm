SET /P proj=< current
ECHO Project name: %proj%
REM Delete classes dir
RMDIR /S /Q %proj%\classes
mkdir %proj%\classes
SET home=%cd%

REM Compiling
javac -sourcepath %cd%\%proj%\src;%cd%\..\trie\src -d %proj%\classes %proj%\src\%proj%.java
mkdir %proj%\jars
del %proj%\jars\%proj%.jar
REM Making jar
jar cfe %proj%\jars\%proj%.jar %proj% -C %proj%\classes .

