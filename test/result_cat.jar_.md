## 1. a & b

### a.txt

    a.txt
    
        a <- b
    
        @include <-=b.txt=
    
    a.end
    
    ÖÐÎÄ¡£

### b.txt:

    b.txt
    
        b <- a
    
        @include <-=a.txt=
    
    b.end

### java -jar cat.jar a.txt


### java -jar cat.jar b.txt


---

## 2. c & d/da & a & e

### c.txt:

    c.txt
    
        c <- da
    
        @include <-=d/da.txt=
    
    c.end

### d/da.txt:

    da.txt
    
        da <- e
    
        @include <-=../e.txt=
    
        da <- a
    
        @include <-=../a.txt=
    
    da.end

### e.txt:

    e.txt
    
    (nothing here in e.txt)
    
    e.end

### java -jar cat.jar c.txt


---

## 3. f

(expand or not.)

### f.txt:

    f.txt
    
        f <- a (expand)
    
        @include <-=a.txt=
    
        f <- a (not expand)
    
        %include <-=a.txt=
    
    f.end

### java -jar cat.jar f.txt


---

## 4. g

(self expand not working.)

### g.txt:

    g.txt
    
        g <- g (expand, won't work)
    
        @include <-=g.txt=
    
        g <- g (not expand)
    
        %include <-=g.txt=
    
    g.end

### java -jar cat.jar g.txt

         1	g.txt
         2	
         3	    g <- g (expand, won't work)
         4	
         5	    g.txt
         6	
         7	        g <- g (expand, won't work)
         8	
         9	        @include <-=g.txt=
        10	
        11	        g <- g (not expand)
        12	
        13	        %include <-=g.txt=
        14	
        15	    g.end
        16	
        17	    g <- g (not expand)
        18	
        19	    g.txt
        20	
        21	        g <- g (expand, won't work)
        22	
        23	        @include <-=g.txt=
        24	
        25	        g <- g (not expand)
        26	
        27	        %include <-=g.txt=
        28	
        29	    g.end
        30	
        31	g.end

---

## 5. h

(no such file.)

### h.txt:

    h.txt
    
        h <- y (no such file to %)
    
        @include <-=y.txt=
    
        h <- z (no such file to @)
    
        %include <-=z.txt=
    
    h.end

### java -jar cat.jar h.txt

         1	h.txt
         2	
         3	    h <- y (no such file to %)
         4	
         5	    Error openning file: [y.txt].
         6	
         7	    h <- z (no such file to @)
         8	
         9	    Error openning file: [z.txt].
        10	
        11	h.end

---

## 6. i

(comment out inclusion.)

### i.txt:

    i.txt
    
        reveal with @@include/%%include (verbatim)
    
        %%include <-=a.txt=
    
        @@include <-=a.txt=
    
    i.end

### java -jar cat.jar i.txt

         1	i.txt
         2	
         3	    reveal with @@include/%%include (verbatim)
         4	
         5	    %include <-=a.txt=
         6	
         7	    @include <-=a.txt=
         8	
         9	i.end

---

## 7. j

(path: relative or absolute.)

### j.txt:

    j.txt
    
        C:\Windows\System32\winrm.cmd (works on windows)
    
        %include <-=C:\Windows\System32\winrm.cmd=
    
        C:/Windows/System32/winrm.cmd (works on windows)
    
        %include <-=C:/Windows/System32/winrm.cmd=
    
        C:\\Windows\\System32\\winrm.cmd (works on windows)
    
        %include <-=C:\\Windows\\System32\\winrm.cmd=
    
        %include <-=/etc/issue=
    
    j.end

### java -jar cat.jar j.txt

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

---

## 8. k1

(shave out yaml block.)

### k1.txt:

    k1.txt
    
        without yaml block (recursive)
    
        @include </=l1.txt=
    
    k1.end

### l1.txt:

    ---
    title: this is l1.txt
    author: tzx
    ---
    
    l1.txt
    
        without yaml block (recursive)
    
        @include </=k1.txt=
    
        recursive include a.txt
    
        @include <-=a.txt=
    
    l1.end

### java -jar cat.jar k1.txt


## 9. k2

(shave out yaml block.)

### k2.txt:

    k2.txt
    
        with yaml block (recursive)
    
        @include <-=l2.txt=
    
    k2.end

### l2.txt:

    ---
    title: this is l2.txt
    author: tzx
    ---
    
    l2.txt
    
        with yaml block (recursive)
    
        @include <-=k2.txt=
    
    l2.end

### java -jar cat.jar k2.txt

         1	k2.txt
         2	
         3	    with yaml block (recursive)
         4	
         5	    ---
         6	    title: this is l2.txt
         7	    author: tzx
         8	    ---
         9	
        10	    l2.txt
        11	
        12	        with yaml block (recursive)
        13	
        14	        k2.txt
        15	
        16	            with yaml block (recursive)
        17	
        18	            @include <-=l2.txt=
        19	
        20	        k2.end
        21	
        22	    l2.end
        23	
        24	k2.end

---

## 10. m

(shave out yaml block.)

### m.txt:

    ---
    title: this is m.txt
    author: tzx
    ---
    
    m.txt
    
        comment out:
    
        %%include </=m.txt=
        @@include </=m.txt=
    
        shave
    
        %include </=m.txt=
    
        not shave
    
        %include <-=m.txt=
    
        recursive a.txt
    
        @include <-=a.txt=
    
        preserve a.txt
    
        %include <-=a.txt=
    
    m.end

### java -jar cat.jar m.txt

         1	---
         2	title: this is m.txt
         3	author: tzx
         4	---
         5	
         6	m.txt
         7	
         8	    comment out:
         9	
        10	    %include </=m.txt=
        11	    @include </=m.txt=
        12	
        13	    shave
        14	
        15	    m.txt
        16	
        17	        comment out:
        18	
        19	        %%include </=m.txt=
        20	        @@include </=m.txt=
        21	
        22	        shave
        23	
        24	        %include </=m.txt=
        25	
        26	        not shave
        27	
        28	        %include <-=m.txt=
        29	
        30	        recursive a.txt
        31	
        32	        @include <-=a.txt=
        33	
        34	        preserve a.txt
        35	
        36	        %include <-=a.txt=
        37	
        38	    m.end
        39	
        40	    not shave
        41	
        42	    ---
        43	    title: this is m.txt
        44	    author: tzx
        45	    ---
        46	
        47	    m.txt
        48	
        49	        comment out:
        50	
        51	        %%include </=m.txt=
        52	        @@include </=m.txt=
        53	
        54	        shave
        55	
        56	        %include </=m.txt=
        57

---

## 11. k

### k.txt:

    k.txt
    
        without yaml block (recursive)
    
        @include </=l.txt=
    
        with yaml block (recursive)
    
        @include <-=l.txt=
    
        without yaml block (preserve)
    
        %include </=l.txt=
    
        with yaml block (preserve)
    
        %include <-=l.txt=
    
    k.end

### java -jar cat.jar k.txt

         1	k.txt
         2	
         3	    without yaml block (recursive)
         4	
         5	    l.txt
         6	
         7	        without yaml block (recursive)
         8	
         9	        k.txt
        10	
        11	            without yaml block (recursive)
        12	
        13	            @include </=l.txt=
        14	
        15	            with yaml block (recursive)
        16	
        17	            @include <-=l.txt=
        18	
        19	            without yaml block (preserve)
        20	
        21	            %include </=l.txt=
        22	
        23	            with yaml block (preserve)
        24	
        25	            %include <-=l.txt=
        26	
        27	        k.end
        28	
        29	        with yaml block (recursive)
        30	
        31	        k.txt
        32	
        33	            without yaml block (recursive)
        34	
        35	            @include </=l.txt=
        36	
        37	            with yaml block (recursive)
        38	
        39	            @include <-=l.txt=
        40	
        41	            without yaml block (preserve)
        42	
        43	            %include </=l.txt=
        44	
        45	            with yaml block (preserve)
        46	
        47	            %include <-=l.txt=
        48	
        49	        k.end
        50	
        51	        without yaml block (preserve)
        52	
        53	        k.txt
        54	
        55	            without yaml block (recursive)
        56	
        57	            @include </=l.txt=
        58	
        59	            with yaml block (recursive)
        60	
        61	            @include <-=l.txt=
        62	
        63	            without yaml block (preserve)
        64	
        65	            %include </=l.txt=
        66	
        67	            with yaml block (preserve)
        68	
        69	            %include <-=l.txt=
        70	
        71	        k.end
        72	
        73	        with yaml block (preserve)
        74	
        75	        k.txt
        76	
        77	            without yaml block (recursive)
        78	
        79	            @include </=l.txt=
        80	
        81	            with yaml block (recursive)
        82	
        83	            @include <-=l.txt=
        84	
        85	            without yaml block (preserve)
        86	
        87	            %include </=l.txt=
        88	
        89	            with yaml block (preserve)
        90	
        91	            %include <-=l.txt=
        92	
        93	        k.end
        94	
        95	    l.end
        96	
        97	    with yaml block (recursive)
        98	
        99	    ---
       100	    title: this is l.txt
       101	    author: tzx
       102	    ---
       103	
       104	    l.txt
       105	
       106	        without yaml block (recursive)
       107	
       108	        @include </=k.txt=
       109	
       110	        with yaml block (recursive)
       111	
       112	        @include <-=k.txt=
       113	
       114	        without yaml block (preserve)
       115	
       116	        %include </=k.txt=
       117	
       118	        with yaml block (preserve)
       119	
       120	        %include <-=k.txt=
       121	
       122	    l.end
       123	
       124	    without yaml block (preserve)
       125	
       126	    l.txt
       127	
       128	        without yaml block (recursive)
       129	
       130	        @include </=k.txt=
       131	
       132	        with yaml block (recursive)
       133	
       134	        @include <-=k.txt=
       135	
       136	        without yaml block (preserve)
       137	
       138	        %include </=k.txt=
       139	
       140	        with yaml block (preserve)
       141	
       142	        %include <-=k.txt=
       143	
       144	    l.end
       145	
       146	    with yaml block (preserve)
       147	
       148	    ---
       149	    title: this is l.txt
       150	    author: tzx
       151	    ---
       152	
       153	    l.txt
       154	
       155	        without yaml block (recursive)
       156	
       157	        @include </=k.txt=
       158	
       159	        with yaml block (recursive)
       160	
       161	        @include <-=k.txt=
       162	
       163	        without yaml block (preserve)
       164	
       165	        %include </=k.txt=
       166	
       167	        with yaml block (preserve)
       168	
       169	        %include <-=k.txt=
       170	
       171	    l.end
       172	
       173	k.end
