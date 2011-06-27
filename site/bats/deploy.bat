@echo off

set BASE=D:\tmp\workspace\site\

echo Compactando...

pushd %BASE%\deploy
jar -cf %BASE%\bats\site.ear.zip site-ear
popd

pushd %BASE%\src\site-ear
jar -cf %BASE%\bats\site.war.zip site-war
popd

popd
pause