@echo off
setlocal enabledelayedexpansion

echo =============================
echo INFO/ build CyanChat
echo =============================

call gradlew build
set BUILD_RESULT=%ERRORLEVEL%

if NOT "%BUILD_RESULT%"=="0" (
echo.
echo =============================
echo ERROR/ failed
echo =============================
echo.
pause
exit /b %BUILD_RESULT%
)

echo.
echo INFO/ build complete
echo.

set TARGET_DIR=%USERPROFILE%\Documents\Modrinth\profiles\1-21-10-fabric-server\mods

echo INFO/ remove old version
del "%TARGET_DIR%\cyanchat-*.jar" 2>nul

echo INFO/ copy new version

for %%f in (build\libs\cyanchat-*.jar) do (
set FILE=%%f
)

if not defined FILE (
echo ERROR/ cyanchat-x.x.x.jar not found
pause
exit /b 1
)

copy "!FILE!" "%TARGET_DIR%" /Y

echo.
echo =============================
echo INFO/ update complete
echo =============================
echo.

pause
