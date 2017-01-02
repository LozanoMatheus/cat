## 1. a & b

### a.txt

    a.txt
    
        a <- b
    
        @include <-=b.txt=
    
    a.end
    
    中文。

### b.txt:

    b.txt
    
        b <- a
    
        @include <-=a.txt=
    
    b.end

### perl cat.pl a.txt

         1	a.txt
         2	
         3	    a <- b
         4	
         5	    b.txt
         6	
         7	        b <- a
         8	
         9	        a.txt
        10	
        11	            a <- b
        12	
        13	            @include <-=b.txt=
        14	
        15	        a.end
        16	
        17	        中文。
        18	
        19	    b.end
        20	
        21	a.end
        22	
        23	中文。

### perl cat.pl b.txt

         1	b.txt
         2	
         3	    b <- a
         4	
         5	    a.txt
         6	
         7	        a <- b
         8	
         9	        b.txt
        10	
        11	            b <- a
        12	
        13	            @include <-=a.txt=
        14	
        15	        b.end
        16	
        17	    a.end
        18	
        19	    中文。
        20	
        21	b.end

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

### perl cat.pl c.txt

         1	c.txt
         2	
         3	    c <- da
         4	
         5	    da.txt
         6	
         7	        da <- e
         8	
         9	        e.txt
        10	
        11	        (nothing here in e.txt)
        12	
        13	        e.end
        14	
        15	        da <- a
        16	
        17	        a.txt
        18	
        19	            a <- b
        20	
        21	            b.txt
        22	
        23	                b <- a
        24	
        25	                a.txt
        26	
        27	                    a <- b
        28	
        29	                    @include <-=b.txt=
        30	
        31	                a.end
        32	
        33	                中文。
        34	
        35	            b.end
        36	
        37	        a.end
        38	
        39	        中文。
        40	
        41	    da.end
        42	
        43	c.end

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

### perl cat.pl f.txt

         1	f.txt
         2	
         3	    f <- a (expand)
         4	
         5	    a.txt
         6	
         7	        a <- b
         8	
         9	        b.txt
        10	
        11	            b <- a
        12	
        13	            a.txt
        14	
        15	                a <- b
        16	
        17	                @include <-=b.txt=
        18	
        19	            a.end
        20	
        21	            中文。
        22	
        23	        b.end
        24	
        25	    a.end
        26	
        27	    中文。
        28	
        29	    f <- a (not expand)
        30	
        31	    a.txt
        32	
        33	        a <- b
        34	
        35	        @include <-=b.txt=
        36	
        37	    a.end
        38	
        39	    中文。
        40	
        41	f.end

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

### perl cat.pl g.txt

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

### perl cat.pl h.txt

         1	h.txt
         2	
         3	    h <- y (no such file to %)
         4	
         5	    Error openning file: [./y.txt].
         6	
         7	    h <- z (no such file to @)
         8	
         9	    Error openning file: [./z.txt].
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

### perl cat.pl i.txt

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

### perl cat.pl j.txt

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

### perl cat.pl k1.txt

         1	k1.txt
         2	
         3	    without yaml block (recursive)
         4	
         5	    l1.txt
         6	
         7	        without yaml block (recursive)
         8	
         9	        k1.txt
        10	
        11	            without yaml block (recursive)
        12	
        13	            @include </=l1.txt=
        14	
        15	        k1.end
        16	
        17	        recursive include a.txt
        18	
        19	        a.txt
        20	
        21	            a <- b
        22	
        23	            b.txt
        24	
        25	                b <- a
        26	
        27	                a.txt
        28	
        29	                    a <- b
        30	
        31	                    @include <-=b.txt=
        32	
        33	                a.end
        34	
        35	                中文。
        36	
        37	            b.end
        38	
        39	        a.end
        40	
        41	        中文。
        42	
        43	    l1.end
        44	
        45	k1.end

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

### perl cat.pl k2.txt

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

### perl cat.pl m.txt

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
        58	        not shave
        59	
        60	        %include <-=m.txt=
        61	
        62	        recursive a.txt
        63	
        64	        @include <-=a.txt=
        65	
        66	        preserve a.txt
        67	
        68	        %include <-=a.txt=
        69	
        70	    m.end
        71	
        72	    recursive a.txt
        73	
        74	    a.txt
        75	
        76	        a <- b
        77	
        78	        b.txt
        79	
        80	            b <- a
        81	
        82	            a.txt
        83	
        84	                a <- b
        85	
        86	                @include <-=b.txt=
        87	
        88	            a.end
        89	
        90	            中文。
        91	
        92	        b.end
        93	
        94	    a.end
        95	
        96	    中文。
        97	
        98	    preserve a.txt
        99	
       100	    a.txt
       101	
       102	        a <- b
       103	
       104	        @include <-=b.txt=
       105	
       106	    a.end
       107	
       108	    中文。
       109	
       110	m.end

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

### perl cat.pl k.txt

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
       108	        k.txt
       109	
       110	            without yaml block (recursive)
       111	
       112	            @include </=l.txt=
       113	
       114	            with yaml block (recursive)
       115	
       116	            @include <-=l.txt=
       117	
       118	            without yaml block (preserve)
       119	
       120	            %include </=l.txt=
       121	
       122	            with yaml block (preserve)
       123	
       124	            %include <-=l.txt=
       125	
       126	        k.end
       127	
       128	        with yaml block (recursive)
       129	
       130	        k.txt
       131	
       132	            without yaml block (recursive)
       133	
       134	            @include </=l.txt=
       135	
       136	            with yaml block (recursive)
       137	
       138	            @include <-=l.txt=
       139	
       140	            without yaml block (preserve)
       141	
       142	            %include </=l.txt=
       143	
       144	            with yaml block (preserve)
       145	
       146	            %include <-=l.txt=
       147	
       148	        k.end
       149	
       150	        without yaml block (preserve)
       151	
       152	        k.txt
       153	
       154	            without yaml block (recursive)
       155	
       156	            @include </=l.txt=
       157	
       158	            with yaml block (recursive)
       159	
       160	            @include <-=l.txt=
       161	
       162	            without yaml block (preserve)
       163	
       164	            %include </=l.txt=
       165	
       166	            with yaml block (preserve)
       167	
       168	            %include <-=l.txt=
       169	
       170	        k.end
       171	
       172	        with yaml block (preserve)
       173	
       174	        k.txt
       175	
       176	            without yaml block (recursive)
       177	
       178	            @include </=l.txt=
       179	
       180	            with yaml block (recursive)
       181	
       182	            @include <-=l.txt=
       183	
       184	            without yaml block (preserve)
       185	
       186	            %include </=l.txt=
       187	
       188	            with yaml block (preserve)
       189	
       190	            %include <-=l.txt=
       191	
       192	        k.end
       193	
       194	    l.end
       195	
       196	    without yaml block (preserve)
       197	
       198	    l.txt
       199	
       200	        without yaml block (recursive)
       201	
       202	        @include </=k.txt=
       203	
       204	        with yaml block (recursive)
       205	
       206	        @include <-=k.txt=
       207	
       208	        without yaml block (preserve)
       209	
       210	        %include </=k.txt=
       211	
       212	        with yaml block (preserve)
       213	
       214	        %include <-=k.txt=
       215	
       216	    l.end
       217	
       218	    with yaml block (preserve)
       219	
       220	    ---
       221	    title: this is l.txt
       222	    author: tzx
       223	    ---
       224	
       225	    l.txt
       226	
       227	        without yaml block (recursive)
       228	
       229	        @include </=k.txt=
       230	
       231	        with yaml block (recursive)
       232	
       233	        @include <-=k.txt=
       234	
       235	        without yaml block (preserve)
       236	
       237	        %include </=k.txt=
       238	
       239	        with yaml block (preserve)
       240	
       241	        %include <-=k.txt=
       242	
       243	    l.end
       244	
       245	k.end
