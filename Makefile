.PHONY: clean test

txt := $(wildcard *.txt)
md  := $(txt:%.txt=%.md)

all: target/cat.jar test $(md) html
clean:
	rm -rf target/ $(md) html
	make -C test -f build.mk clean
gh: all
	git add -A; git commit -m "`date`"; git push;

target/cat.jar: $(wildcard src/main/java/com/tangzhixiong/cat/*.java)
	mvn package

test: target/cat.jar
	make -C test -f build.mk
%.md: bin/cat.pl %.txt
	perl $^ > $@

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

html: md2html.jar
	java -jar $< -o html -r res -c config.yml
md2html.jar:
	cp ../md2html/target/md2html.jar $@ || wget http://whudoc.qiniudn.com/java/md2html/md2html.jar
