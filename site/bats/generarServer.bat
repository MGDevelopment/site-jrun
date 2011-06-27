@echo off
D:

echo Borrando clases viejas...
del \tmp\workspace\site\src\site-ear\kernel\com\tmk\kernel\server\*.java
del \tmp\workspace\site\src\site-ear\kernel\com\tmk\kernel\server\types\*.java

echo Generando clases para server.xml...

D:\tmp\jdk1.5.0_08\bin\javaw.exe -classpath D:\tmp\workspace\site\common\castor-0.9.5-xml.jar org.exolab.castor.builder.SourceGenerator -line-separator win -dest \tmp\workspace\site\src\site-ear\kernel -f -i \tmp\workspace\site\setup\server.xsd -package com.tmk.kernel.server