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
