@echo off
set DIR=%CD%



REM CHANGE THIS DIRECTORY
cd C:\Users\...





color 3f

set /p ch0=<"Char0.txt"
set /p ch1=<"Char1.txt"


:menu
cls
echo.
echo.
echo     Implementacoes:                     Settings:
echo.
echo        1 -- Encriptar                      Char 0 = %ch0%
echo        2 -- Decriptar                      Char 1 = %ch1%
echo        3 -- Change settings
echo        4 -- Reset chars
echo        q -- Quit

set /p OPT=
REM OPCAO LIDA
if NOT "%OPT%" == "q" (
if NOT "%OPT%" == "4" (
if NOT "%OPT%" == "1" (
if NOT "%OPT%" == "2" (
if NOT "%OPT%" == "3" (
echo Ainda estas a escolher a opcao!
echo.
pause
goto :menu
)))))

if "%OPT%" == "q" (goto :close)

if "%OPT%" == "3" (

goto :settingsMenu
)

if "%OPT%" == "4" goto :resetChars

cls
echo.
echo Input:
set /a OPT=%OPT%-1
java Main %OPT% > tmp.txt
set /a OPT=%OPT%+1
cls

if "%OPT%" == "1" (

echo.
echo Copied to clipboard
goto :end

) else (

REM OPT == 1
echo.
echo Mensagem:
type tmp.txt

goto :end
)

REM UNREACHABLE

:charsUpdate
echo %ch0%%ch1% > "Chars.txt"
goto :settingsMenu

:end
echo.
pause
goto :menu


:resetChars
set ch0=0
set ch1=1
goto :menu





:settingsMenu
cls
echo     Settings:
echo.
echo        0 -- Alterar char0 %ch0%
echo        1 -- Alterar char1 %ch1%
echo        2 -- Voltar ao menu principal
set /p optCh=

if "%optCh%" == "0" (
cls
echo.
echo A mudar Char0 para:
set /p ch0=
goto :charsUpdate

) else if "%optCh%" == "1" (
cls
echo.
echo A mudar Char1 para:
set /p ch1=
goto :charsUpdate

) else if "%optCh%" == "2" (
goto :menu
) else goto :settingsMenu









:close
echo %ch0% > "Char0.txt"
echo %ch1% > "Char1.txt"
del tmp.txt
cd "%DIR%"
color
cls
