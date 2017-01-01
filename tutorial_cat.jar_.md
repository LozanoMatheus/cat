比如有以下文件：

[`test/a.txt`](test/a.txt)

    a.txt
    
        a <- b
    
        @include <-=b.txt=
    
    a.end
    
    中文。

[`test/b.txt`](test/b.txt)

    b.txt
    
        b <- a
    
        @include <-=a.txt=
    
    b.end

[`test/c.txt`](test/c.txt)

    c.txt
    
        c <- da
    
        @include <-=d/da.txt=
    
    c.end

[`test/d/da.txt`](test/d/da.txt)

    da.txt
    
        da <- e
    
        @include <-=../e.txt=
    
        da <- a
    
        @include <-=../a.txt=
    
    da.end

[`test/e.txt`](test/e.txt)

    e.txt
    
    (nothing here in e.txt)
    
    e.end

[`test/f.txt`](test/f.txt)

    f.txt
    
        f <- a (expand)
    
        @include <-=a.txt=
    
        f <- a (not expand)
    
        %include <-=a.txt=
    
    f.end

[`test/g.txt`](test/g.txt)

    g.txt
    
        g <- g (expand, won't work)
    
        @include <-=g.txt=
    
        g <- g (not expand)
    
        %include <-=g.txt=
    
    g.end

通过 Makefile（[`test/build.mk`](test/build.mk)）：

```makefile
.PHONY: clean

outputs := result_cat.pl_.txt result_cat.jar_.txt result_diff_.txt

all: $(outputs)
clean:
	rm -f $(outputs)

result_cat.pl_.txt: ../bin/cat.pl
	rm -f result_cat.pl_.txt
	@echo -e "cat    a.txt # TEST LOOP (a<-b, b<-a)\n"          >> result_cat.pl_.txt
	perl ../bin/cat.pl a.txt                                    >> result_cat.pl_.txt
	@echo -e "\n\ncat    c.txt # TEST MULTIPLE INCLUSIONS\n"    >> result_cat.pl_.txt
	perl ../bin/cat.pl c.txt                                    >> result_cat.pl_.txt
	@echo -e "\n\ncat    f.txt # TEST EXPAND/NOT\n"             >> result_cat.pl_.txt
	perl ../bin/cat.pl f.txt                                    >> result_cat.pl_.txt
	@echo -e "\n\ncat    g.txt # SELF INCLUSION\n"              >> result_cat.pl_.txt
	perl ../bin/cat.pl g.txt                                    >> result_cat.pl_.txt
	@echo -e "\n\ncat    h.txt # NO SUCH FILE\n"                >> result_cat.pl_.txt
	perl ../bin/cat.pl h.txt                                    >> result_cat.pl_.txt
	@echo -e "\n\ncat    i.txt # VERBATIM\n"                    >> result_cat.pl_.txt
	perl ../bin/cat.pl i.txt                                    >> result_cat.pl_.txt
	@echo -e "\n\ncat    j.txt # ABSOLUTE PATH\n"               >> result_cat.pl_.txt
	perl ../bin/cat.pl j.txt                                    >> result_cat.pl_.txt
	@echo -e "\n\ncat    m.txt # YAML HEADER\n"                 >> result_cat.pl_.txt
	perl ../bin/cat.pl m.txt                                    >> result_cat.pl_.txt
	@echo -e "\n\ncat    k1.txt # YAML HEADER\n"                >> result_cat.pl_.txt
	perl ../bin/cat.pl k1.txt                                   >> result_cat.pl_.txt
	@echo -e "\n\ncat    k2.txt # YAML HEADER\n"                >> result_cat.pl_.txt
	perl ../bin/cat.pl k2.txt                                   >> result_cat.pl_.txt
	@echo -e "\n\ncat    k.txt # YAML HEADER\n"                 >> result_cat.pl_.txt
	perl ../bin/cat.pl k.txt                                    >> result_cat.pl_.txt
	perl ../bin/trim.pl result_cat.pl_.txt > result_cat.pl_ && rm result_cat.pl_.txt
	mv result_cat.pl_ result_cat.pl_.txt

result_cat.jar_.txt: ../target/cat.jar
	rm -f result_cat.jar_.txt
	@echo -e "cat    a.txt # TEST LOOP (a<-b, b<-a)\n"          >> result_cat.jar_.txt
	java -jar ../target/cat.jar a.txt                           >> result_cat.jar_.txt
	@echo -e "\n\ncat    c.txt # TEST MULTIPLE INCLUSIONS\n"    >> result_cat.jar_.txt
	java -jar ../target/cat.jar c.txt                           >> result_cat.jar_.txt
	@echo -e "\n\ncat    f.txt # TEST EXPAND/NOT\n"             >> result_cat.jar_.txt
	java -jar ../target/cat.jar f.txt                           >> result_cat.jar_.txt
	@echo -e "\n\ncat    g.txt # SELF INCLUSION\n"              >> result_cat.jar_.txt
	java -jar ../target/cat.jar g.txt                           >> result_cat.jar_.txt
	@echo -e "\n\ncat    h.txt # NO SUCH FILE\n"                >> result_cat.jar_.txt
	java -jar ../target/cat.jar h.txt                           >> result_cat.jar_.txt
	@echo -e "\n\ncat    i.txt # VERBATIM\n"                    >> result_cat.jar_.txt
	java -jar ../target/cat.jar i.txt                           >> result_cat.jar_.txt
	@echo -e "\n\ncat    j.txt # ABSOLUTE PATH\n"               >> result_cat.jar_.txt
	java -jar ../target/cat.jar j.txt                           >> result_cat.jar_.txt
	@echo -e "\n\ncat    m.txt # YAML HEADER\n"                 >> result_cat.jar_.txt
	java -jar ../target/cat.jar m.txt                           >> result_cat.jar_.txt
	@echo -e "\n\ncat    k1.txt # YAML HEADER\n"                >> result_cat.jar_.txt
	java -jar ../target/cat.jar k1.txt                          >> result_cat.jar_.txt
	@echo -e "\n\ncat    k2.txt # YAML HEADER\n"                 >> result_cat.jar_.txt
	java -jar ../target/cat.jar k2.txt                          >> result_cat.jar_.txt
	@echo -e "\n\ncat    k.txt # YAML HEADER\n"                 >> result_cat.jar_.txt
	java -jar ../target/cat.jar k.txt                           >> result_cat.jar_.txt
	perl ../bin/trim.pl result_cat.jar_.txt > result_cat.jar_ && rm result_cat.jar_.txt
	mv result_cat.jar_ result_cat.jar_.txt

../target/cat.jar:
	cd .. && mvn package

result_diff_.txt: result_cat.pl_.txt result_cat.jar_.txt
	git diff --no-index --color-words --patience -- $^ > $@ || :
```

生成的 [`test/result_cat.jar_.txt`](test/result_cat.jar_.txt) 为：

    cat    a.txt # TEST LOOP (a<-b, b<-a)
    
    a.txt
    
        a <- b
    
        @include <-=b.txt=
    
    a.end
    
    ���ġ�
    
    
    cat    c.txt # TEST MULTIPLE INCLUSIONS
    
    c.txt
    
        c <- da
    
        @include <-=d/da.txt=
    
    c.end
    
    
    cat    f.txt # TEST EXPAND/NOT
    
    f.txt
    
        f <- a (expand)
    
        @include <-=a.txt=
    
        f <- a (not expand)
    
        %include <-=a.txt=
    
    f.end
    
    
    cat    g.txt # SELF INCLUSION
    
    g.txt
    
        g <- g (expand, won't work)
    
        @include <-=g.txt=
    
        g <- g (not expand)
    
        %include <-=g.txt=
    
    g.end
    
    
    cat    h.txt # NO SUCH FILE
    
    h.txt
    
        h <- y (no such file to %)
    
        @include <-=y.txt=
    
        h <- z (no such file to @)
    
        %include <-=z.txt=
    
    h.end
    
    
    cat    i.txt # VERBATIM
    
    i.txt
    
        reveal with @@include/%%include (verbatim)
    
        a.txt
    
            a <- b
    
            @include <-=b.txt=
    
        a.end
    
        ���ġ�
    
        a.txt
    
            a <- b
    
            @include <-=b.txt=
    
        a.end
    
        ���ġ�
    
    i.end
    
    
    cat    j.txt # ABSOLUTE PATH
    
    j.txt
    
        C:\Windows\System32\winrm.cmd (works on windows)
    
        %include <-=C:\Windows\System32\winrm.cmd=
    
        C:/Windows/System32/winrm.cmd (works on windows)
    
        %include <-=C:/Windows/System32/winrm.cmd=
    
        C:\\Windows\\System32\\winrm.cmd (works on windows)
    
        %include <-=C:\\Windows\\System32\\winrm.cmd=
    
        %include <-=/etc/issue=
    
    j.end
    
    
    cat    m.txt # YAML HEADER
    
    ---
    title: this is m.txt
    author: tzx
    ---
    
    m.txt
    
        comment out:
    
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
    
        shave
    
        %include </=m.txt=
    
        not shave
    
        %include <-=m.txt=
    
        recursive a.txt
    
        @include <-=a.txt=
    
        preserve a.txt
    
        %include <-=a.txt=
    
    m.end
    
    
    cat    k1.txt # YAML HEADER
    
    k1.txt
    
        without yaml block (recursive)
    
        @include </=l1.txt=
    
    k1.end
    
    
    cat    k2.txt # YAML HEADER
    
    k2.txt
    
        with yaml block (recursive)
    
        @include <-=l2.txt=
    
    k2.end
    
    
    cat    k.txt # YAML HEADER
    
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
