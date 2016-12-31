.PHONY: clean test

txt := tutorial_cat.jar_.md tutorial_cat.pl_.md

all: target/cat.jar test $(txt:%.txt=%.md)
clean:
	rm -rf target/ $(txt)
	make -C test -f build.mk clean
gh:
	git add -A; git commit -m "`date`"; git push;

target/cat.jar: $(wildcard src/main/java/com/tangzhixiong/cat/*.java)
	mvn package

test: target/cat.jar
	make -C test -f build.mk
tutorial_cat.jar_.md: tutorial_cat.jar_.txt
	perl bin/cat.pl $< > $@
tutorial_cat.pl_.md: tutorial_cat.pl_.txt
	java -jar target/cat.jar $< > $@

test1: target/cat.jar
	@echo test simple inclusion.
	java -jar $< test/a.txt
test2: target/cat.jar
	@echo test multiple inclusion.
	java -jar $< test/c.txt
test3: target/cat.jar
	@echo test expand or not.
	java -jar $< test/f.txt
	java -jar $< test/g.txt
test4: target/cat.jar
	@echo Test no file found.
	java -jar $< test/h.txt
test5: target/cat.jar
	@echo Test reveal.
	java -jar $< test/i.txt
