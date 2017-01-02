.PHONY: clean

entries := a.txt b.txt c.txt f.txt g.txt h.txt i.txt j.txt k1.txt k2.txt m.txt k.txt
entries_j := $(entries:%.txt=%.jar.md)
entries_p := $(entries:%.txt=%.pl.md)
outputs := result_cat.pl_.md result_cat.jar_.md result_diff_.md $(entries_j) $(entries_p)

all: $(outputs)
clean:
	rm -f $(outputs)

../target/cat.jar:
	cd .. && mvn package
result_cat.pl_.md: ../bin/cat.pl result_cat.pl_.txt $(entries_p)
	perl $^ > $@
result_cat.jar_.md: ../target/cat.jar result_cat.jar_.txt $(entries_j)
	java -jar $^ > $@
result_diff_.md: result_cat.pl_.md result_cat.jar_.md
	git diff --no-index --color-words --patience -- $^ > $@ 2> /dev/null || :
%.jar.md: ../target/cat.jar %.txt
	java -jar $^ | perl ../bin/trim.pl | cat -n > $@
%.pl.md: ../bin/cat.pl %.txt
	perl $^      | perl ../bin/trim.pl | cat -n > $@
