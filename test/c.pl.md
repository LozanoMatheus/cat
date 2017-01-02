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
