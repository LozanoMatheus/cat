[1mdiff --git a/result_cat.pl_.md b/result_cat.jar_.md[m
[1mindex 874006c..ce00c46 100644[m
[1m--- a/result_cat.pl_.md[m
[1m+++ b/result_cat.jar_.md[m
[36m@@ -10,7 +10,7 @@[m
    [m
    a.end[m
    [m
    [31m中文。[m[32m���ġ�[m

### b.txt:[m

[36m@@ -22,55 +22,11 @@[m
    [m
    b.end[m

### [31mperl cat.pl[m[32mjava -jar cat.jar[m a.txt

[31m         1	a.txt[m
[31m         2	[m
[31m         3	    a <- b[m
[31m         4	[m
[31m         5	    b.txt[m
[31m         6	[m
[31m         7	        b <- a[m
[31m         8	[m
[31m         9	        a.txt[m
[31m        10	[m
[31m        11	            a <- b[m
[31m        12	[m
[31m        13	            @include <-=b.txt=[m
[31m        14	[m
[31m        15	        a.end[m
[31m        16	[m
[31m        17	        中文。[m
[31m        18	[m
[31m        19	    b.end[m
[31m        20	[m
[31m        21	a.end[m
[31m        22	[m
[31m        23	中文。[m

### [31mperl cat.pl[m[32mjava -jar cat.jar[m b.txt

[31m         1	b.txt[m
[31m         2	[m
[31m         3	    b <- a[m
[31m         4	[m
[31m         5	    a.txt[m
[31m         6	[m
[31m         7	        a <- b[m
[31m         8	[m
[31m         9	        b.txt[m
[31m        10	[m
[31m        11	            b <- a[m
[31m        12	[m
[31m        13	            @include <-=a.txt=[m
[31m        14	[m
[31m        15	        b.end[m
[31m        16	[m
[31m        17	    a.end[m
[31m        18	[m
[31m        19	    中文。[m
[31m        20	[m
[31m        21	b.end[m

---[m

[36m@@ -108,51 +64,8 @@[m
    [m
    e.end[m

### [31mperl cat.pl[m[32mjava -jar cat.jar[m c.txt

[31m         1	c.txt[m
[31m         2	[m
[31m         3	    c <- da[m
[31m         4	[m
[31m         5	    da.txt[m
[31m         6	[m
[31m         7	        da <- e[m
[31m         8	[m
[31m         9	        e.txt[m
[31m        10	[m
[31m        11	        (nothing here in e.txt)[m
[31m        12	[m
[31m        13	        e.end[m
[31m        14	[m
[31m        15	        da <- a[m
[31m        16	[m
[31m        17	        a.txt[m
[31m        18	[m
[31m        19	            a <- b[m
[31m        20	[m
[31m        21	            b.txt[m
[31m        22	[m
[31m        23	                b <- a[m
[31m        24	[m
[31m        25	                a.txt[m
[31m        26	[m
[31m        27	                    a <- b[m
[31m        28	[m
[31m        29	                    @include <-=b.txt=[m
[31m        30	[m
[31m        31	                a.end[m
[31m        32	[m
[31m        33	                中文。[m
[31m        34	[m
[31m        35	            b.end[m
[31m        36	[m
[31m        37	        a.end[m
[31m        38	[m
[31m        39	        中文。[m
[31m        40	[m
[31m        41	    da.end[m
[31m        42	[m
[31m        43	c.end[m

---[m

[36m@@ -174,49 +87,8 @@[m
    [m
    f.end[m

### [31mperl cat.pl[m[32mjava -jar cat.jar[m f.txt

[31m         1	f.txt[m
[31m         2	[m
[31m         3	    f <- a (expand)[m
[31m         4	[m
[31m         5	    a.txt[m
[31m         6	[m
[31m         7	        a <- b[m
[31m         8	[m
[31m         9	        b.txt[m
[31m        10	[m
[31m        11	            b <- a[m
[31m        12	[m
[31m        13	            a.txt[m
[31m        14	[m
[31m        15	                a <- b[m
[31m        16	[m
[31m        17	                @include <-=b.txt=[m
[31m        18	[m
[31m        19	            a.end[m
[31m        20	[m
[31m        21	            中文。[m
[31m        22	[m
[31m        23	        b.end[m
[31m        24	[m
[31m        25	    a.end[m
[31m        26	[m
[31m        27	    中文。[m
[31m        28	[m
[31m        29	    f <- a (not expand)[m
[31m        30	[m
[31m        31	    a.txt[m
[31m        32	[m
[31m        33	        a <- b[m
[31m        34	[m
[31m        35	        @include <-=b.txt=[m
[31m        36	[m
[31m        37	    a.end[m
[31m        38	[m
[31m        39	    中文。[m
[31m        40	[m
[31m        41	f.end[m

---[m

[36m@@ -238,7 +110,7 @@[m
    [m
    g.end[m

### [31mperl cat.pl[m[32mjava -jar cat.jar[m g.txt

         1	g.txt[m
         2	[m
[36m@@ -292,17 +164,17 @@[m
    [m
    h.end[m

### [31mperl cat.pl[m[32mjava -jar cat.jar[m h.txt

         1	h.txt[m
         2	[m
         3	    h <- y (no such file to %)[m
         4	[m
         5	    Error openning file: [31m[./y.txt].[m[32m[y.txt].[m
         6	[m
         7	    h <- z (no such file to @)[m
         8	[m
         9	    Error openning file: [31m[./z.txt].[m[32m[z.txt].[m
        10	[m
        11	h.end[m

[36m@@ -324,7 +196,7 @@[m
    [m
    i.end[m

### [31mperl cat.pl[m[32mjava -jar cat.jar[m i.txt

         1	i.txt[m
         2	[m
[36m@@ -362,7 +234,7 @@[m
    [m
    j.end[m

### [31mperl cat.pl[m[32mjava -jar cat.jar[m j.txt

         1	j.txt[m
         2	[m
[36m@@ -441,53 +313,8 @@[m
    [m
    l1.end[m

### [31mperl cat.pl[m[32mjava -jar cat.jar[m k1.txt

[31m         1	k1.txt[m
[31m         2	[m
[31m         3	    without yaml block (recursive)[m
[31m         4	[m
[31m         5	    l1.txt[m
[31m         6	[m
[31m         7	        without yaml block (recursive)[m
[31m         8	[m
[31m         9	        k1.txt[m
[31m        10	[m
[31m        11	            without yaml block (recursive)[m
[31m        12	[m
[31m        13	            @include </=l1.txt=[m
[31m        14	[m
[31m        15	        k1.end[m
[31m        16	[m
[31m        17	        recursive include a.txt[m
[31m        18	[m
[31m        19	        a.txt[m
[31m        20	[m
[31m        21	            a <- b[m
[31m        22	[m
[31m        23	            b.txt[m
[31m        24	[m
[31m        25	                b <- a[m
[31m        26	[m
[31m        27	                a.txt[m
[31m        28	[m
[31m        29	                    a <- b[m
[31m        30	[m
[31m        31	                    @include <-=b.txt=[m
[31m        32	[m
[31m        33	                a.end[m
[31m        34	[m
[31m        35	                中文。[m
[31m        36	[m
[31m        37	            b.end[m
[31m        38	[m
[31m        39	        a.end[m
[31m        40	[m
[31m        41	        中文。[m
[31m        42	[m
[31m        43	    l1.end[m
[31m        44	[m
[31m        45	k1.end[m

## 9. k2[m

[36m@@ -518,7 +345,7 @@[m
    [m
    l2.end[m

### [31mperl cat.pl[m[32mjava -jar cat.jar[m k2.txt

         1	k2.txt[m
         2	[m
[36m@@ -583,7 +410,7 @@[m
    [m
    m.end[m

### [31mperl cat.pl[m[32mjava -jar cat.jar[m m.txt

         1	---[m
         2	title: this is m.txt[m
[36m@@ -641,60 +468,7 @@[m
        54	        shave[m
        55	[m
        56	        %include </=m.txt=[m
        57[31m58	        not shave[m
[31m        59	[m
[31m        60	        %include <-=m.txt=[m
[31m        61	[m
[31m        62	        recursive a.txt[m
[31m        63	[m
[31m        64	        @include <-=a.txt=[m
[31m        65	[m
[31m        66	        preserve a.txt[m
[31m        67	[m
[31m        68	        %include <-=a.txt=[m
[31m        69	[m
[31m        70	    m.end[m
[31m        71	[m
[31m        72	    recursive a.txt[m
[31m        73	[m
[31m        74	    a.txt[m
[31m        75	[m
[31m        76	        a <- b[m
[31m        77	[m
[31m        78	        b.txt[m
[31m        79	[m
[31m        80	            b <- a[m
[31m        81	[m
[31m        82	            a.txt[m
[31m        83	[m
[31m        84	                a <- b[m
[31m        85	[m
[31m        86	                @include <-=b.txt=[m
[31m        87	[m
[31m        88	            a.end[m
[31m        89	[m
[31m        90	            中文。[m
[31m        91	[m
[31m        92	        b.end[m
[31m        93	[m
[31m        94	    a.end[m
[31m        95	[m
[31m        96	    中文。[m
[31m        97	[m
[31m        98	    preserve a.txt[m
[31m        99	[m
[31m       100	    a.txt[m
[31m       101	[m
[31m       102	        a <- b[m
[31m       103	[m
[31m       104	        @include <-=b.txt=[m
[31m       105	[m
[31m       106	    a.end[m
[31m       107	[m
[31m       108	    中文。[m
[31m       109	[m
[31m       110	m.end[m

---[m

[36m@@ -722,7 +496,7 @@[m
    [m
    k.end[m

### [31mperl cat.pl[m[32mjava -jar cat.jar[m k.txt

         1	k.txt[m
         2	[m
[36m@@ -831,141 +605,69 @@[m
       105	[m
       106	        without yaml block (recursive)[m
       107	[m
       108	        [31mk.txt[m[32m@include </=k.txt=[m
       109	[m
       110	        [31mwithout[m[32mwith[m yaml block (recursive)
       111	[m
       112	        @include [31m</=l.txt=[m[32m<-=k.txt=[m
       113	[m
       114	        [31mwith[m[32mwithout[m yaml block [31m(recursive)[m[32m(preserve)[m
       115	[m
       116	        [31m@include <-=l.txt=[m[32m%include </=k.txt=[m
       117	[m
       118	        [31mwithout[m[32mwith[m yaml block (preserve)
       119	[m
       120	        %include [31m</=l.txt=[m[32m<-=k.txt=[m
       121	[m
       122	    [31mwith yaml block (preserve)[m[32ml.end[m
       123	[m
       124	    [31m%include <-=l.txt=[m[32mwithout yaml block (preserve)[m
       125	[m
       126	    [31mk.end[m[32ml.txt[m
       127	[m
       128	        [31mwith[m[32mwithout[m yaml block (recursive)
       129	[m
       130	        [31mk.txt[m[32m@include </=k.txt=[m
       131	[m
       132	        [31mwithout[m[32mwith[m yaml block (recursive)
       133	[m
       134	        @include [31m</=l.txt=[m[32m<-=k.txt=[m
       135	[m
       136	        [31mwith[m[32mwithout[m yaml block [31m(recursive)[m[32m(preserve)[m
       137	[m
       138	        [31m@include <-=l.txt=[m[32m%include </=k.txt=[m
       139	[m
       140	        [31mwithout[m[32mwith[m yaml block (preserve)
       141	[m
       142	        %include [31m</=l.txt=[m[32m<-=k.txt=[m
       143	[m
       144	    [31mwith yaml block (preserve)[m[32ml.end[m
       145	[m
       146	    [31m%include <-=l.txt=[m[32mwith yaml block (preserve)[m
       147	[m
       148	    [31mk.end[m[32m---[m
       149	    [32mtitle: this is l.txt[m
       150	    [31mwithout yaml block (preserve)[m[32mauthor: tzx[m
       151	    [32m---[m
       152[31mk.txt[m	
       153	    [32ml.txt[m
       154	
       [32m155[m	        without yaml block (recursive)[31m155[m
       156[31m@include </=l.txt=[m	
       157	        [32m@include </=k.txt=[m
       158	
       [32m159[m	        with yaml block (recursive)[31m159[m
       160[31m@include <-=l.txt=[m	
       161	        [32m@include <-=k.txt=[m
       162	
       [32m163[m	        without yaml block (preserve)[31m163[m
       164[31m%include </=l.txt=[m	
       165	        [32m%include </=k.txt=[m
       166	
       [32m167[m	        with yaml block (preserve)[31m167[m
       168[31m%include <-=l.txt=[m	
       169	        [32m%include <-=k.txt=[m
       170[31mk.end[m	
       171	    [32ml.end[m
       172[31mwith yaml block (preserve)[m	
       173[31m174	        k.txt[m
[31m       175	[m
[31m       176	            without yaml block (recursive)[m
[31m       177	[m
[31m       178	            @include </=l.txt=[m
[31m       179	[m
[31m       180	            with yaml block (recursive)[m
[31m       181	[m
[31m       182	            @include <-=l.txt=[m
[31m       183	[m
[31m       184	            without yaml block (preserve)[m
[31m       185	[m
[31m       186	            %include </=l.txt=[m
[31m       187	[m
[31m       188	            with yaml block (preserve)[m
[31m       189	[m
[31m       190	            %include <-=l.txt=[m
[31m       191	[m
[31m       192	        k.end[m
[31m       193	[m
[31m       194	    l.end[m
[31m       195	[m
[31m       196	    without yaml block (preserve)[m
[31m       197	[m
[31m       198	    l.txt[m
[31m       199	[m
[31m       200	        without yaml block (recursive)[m
[31m       201	[m
[31m       202	        @include </=k.txt=[m
[31m       203	[m
[31m       204	        with yaml block (recursive)[m
[31m       205	[m
[31m       206	        @include <-=k.txt=[m
[31m       207	[m
[31m       208	        without yaml block (preserve)[m
[31m       209	[m
[31m       210	        %include </=k.txt=[m
[31m       211	[m
[31m       212	        with yaml block (preserve)[m
[31m       213	[m
[31m       214	        %include <-=k.txt=[m
[31m       215	[m
[31m       216	    l.end[m
[31m       217	[m
[31m       218	    with yaml block (preserve)[m
[31m       219	[m
[31m       220	    ---[m
[31m       221	    title: this is l.txt[m
[31m       222	    author: tzx[m
[31m       223	    ---[m
[31m       224	[m
[31m       225	    l.txt[m
[31m       226	[m
[31m       227	        without yaml block (recursive)[m
[31m       228	[m
[31m       229	        @include </=k.txt=[m
[31m       230	[m
[31m       231	        with yaml block (recursive)[m
[31m       232	[m
[31m       233	        @include <-=k.txt=[m
[31m       234	[m
[31m       235	        without yaml block (preserve)[m
[31m       236	[m
[31m       237	        %include </=k.txt=[m
[31m       238	[m
[31m       239	        with yaml block (preserve)[m
[31m       240	[m
[31m       241	        %include <-=k.txt=[m
[31m       242	[m
[31m       243	    l.end[m
[31m       244	[m
[31m       245[m	k.end
