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
