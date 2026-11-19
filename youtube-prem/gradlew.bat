@echo off
set GRADLE_USER_HOME=%USERPROFILE%\.gradle
exec gradle "%@args%"
