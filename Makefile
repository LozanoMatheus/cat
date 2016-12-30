.PHONY: clean test

all: target/cat.jar test
clean:
	rm -rf target/
	make -C test -f build.mk clean

target/cat.jar: $(wildcard src/main/java/com/tangzhixiong/cat/*.java)
	mvn package

test: target/cat.jar
	make -C test -f build.mk
