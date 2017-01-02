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
