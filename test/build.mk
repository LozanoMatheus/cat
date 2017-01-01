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
	@echo -e "\n\ncat    k.txt # YAML HEADER\n"                 >> result_cat.pl_.txt
	perl ../bin/cat.pl k.txt                                    >> result_cat.pl_.txt

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
	@echo -e "\n\ncat    k.txt # YAML HEADER\n"                 >> result_cat.jar_.txt
	java -jar ../target/cat.jar k.txt                           >> result_cat.jar_.txt

../target/cat.jar:
	cd .. && mvn package

result_diff_.txt: result_cat.pl_.txt result_cat.jar_.txt
	git diff --no-index --color-words --patience -- $^ > $@ || :
