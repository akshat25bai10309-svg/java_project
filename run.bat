@echo off
cd /d "%~dp0"
start "" javaw -jar EventManager.jar 2>nul
if errorlevel 1 (
    echo Launching with console java...
    java -jar EventManager.jar
    if errorlevel 1 pause
)




