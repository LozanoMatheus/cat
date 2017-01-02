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
