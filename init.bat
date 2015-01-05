@ECHO OFF
ECHO "Type the name of the new project:"
set /P proj=
ECHO %proj%> current

MKDIR %proj%
MKDIR %proj%\src

::TYPE nul > %proj%\src\%proj%.java
