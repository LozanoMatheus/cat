     1	j.txt
     2	
     3	    C:\Windows\System32\winrm.cmd (works on windows)
     4	
     5	    @echo off
     6	    IF EXIST %SystemRoot%\system32\cscript.exe (
     7	        @cscript //nologo "%~dpn0.vbs" %*
     8	    ) ELSE (
     9	        echo.
    10	        echo WinRM command line is not available on this system.
    11	        exit /B 1
    12	    )
    13	
    14	
    15	    C:/Windows/System32/winrm.cmd (works on windows)
    16	
    17	    @echo off
    18	    IF EXIST %SystemRoot%\system32\cscript.exe (
    19	        @cscript //nologo "%~dpn0.vbs" %*
    20	    ) ELSE (
    21	        echo.
    22	        echo WinRM command line is not available on this system.
    23	        exit /B 1
    24	    )
    25	
    26	
    27	    C:\\Windows\\System32\\winrm.cmd (works on windows)
    28	
    29	    @echo off
    30	    IF EXIST %SystemRoot%\system32\cscript.exe (
    31	        @cscript //nologo "%~dpn0.vbs" %*
    32	    ) ELSE (
    33	        echo.
    34	        echo WinRM command line is not available on this system.
    35	        exit /B 1
    36	    )
    37	
    38	
    39	    Error openning file: [/etc/issue].
    40	
    41	j.end
