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
