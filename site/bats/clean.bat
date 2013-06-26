@echo off

rem DEPRECATED

echo Borra temporales?
pause

d:
pushd D:\tmp\workspace\site\

rmdir /s /q deploy\site-ear
mkdir deploy\site-ear
rmdir /s /q deploy\SERVER-INF\temp
rmdir /s /q deploy\SERVER-INF\jms
rmdir /s /q src\site-ear\site-war\WEB-INF\jsp
rmdir /s /q src\site-ear\site-war\WEB-INF\classes
rmdir /s /q src\site-ear\site-war\WEB-INF\sessions

del /s /q .#*.*

popd
pause