.PHONY: clean test

txt := $(wildcard *.txt)
md  := $(txt:%.txt=%.md)

all: target/cat.jar test $(md)
clean:
	rm -rf target/ $(md)
	make -C test -f build.mk clean
gh:
	git add -A; git commit -m "`date`"; git push;

target/cat.jar: $(wildcard src/main/java/com/tangzhixiong/cat/*.java)
	mvn package

test: target/cat.jar
	make -C test -f build.mk
%.md: target/cat.jar %.txt
	java -jar $^ > $@

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
