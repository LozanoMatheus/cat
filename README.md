# cat

`bin` ����� [`cat.pl`](bin/cat.pl) ���� `cat` ���ָ��һ����
���������ӣ��ϲ�������ļ����� `cat` �Ǻ���غϲ���`cat.pl` ��
����غϲ���

ʹ�÷���Ϊ��

    // �ݹ�����������ļ���(mnemonics/�ɼǷ�: `@` ����Ϊ�ݹ�)

    @include <-=path=

    // ԭ�������������ļ���(mnemonics: `%` **p**ercent/�ٷֺ� ---> **p**reserve/����)

    %include <-=path=

    // Verbatim

    "@@include <-=path=" ���� "@include <-=path="
    "%%include <-=path=" ���� "%include <-=path="
    %%include <-=path=" ���� "%include <-=path=

    //  path �����Ǿ���·�������磺
    //
    //      "D:\tzx\git\cat\README.md"
    //      "D:\\tzx\\git\\cat\\README.md"
    //      "D:/tzx/git/cat/README.md"
    //      "~/git/cat/README.md"
    //
    //  Ҳ���������·��������ڵ�ǰ������ı��������磺
    //
    //      "test/a.txt"
    //      "test/d/../b.txt"
    //      "../blog/README"

`cat.jar` ʵ�������ƵĹ��ܣ�ʹ�� `make` ������ jar ���������ߵı��ּ���һ�¡�
ʹ��ʵ����
[`tutorial_cat.jar_.md`](tutorial_cat.jar_.md) ��
[`tutorial_cat.pl_.md`](tutorial_cat.pl_.md)��

```git-diff
[1mdiff --git a/result_cat.pl_.txt b/result_cat.jar_.txt[m
[1mindex cd55ec1..ae92653 100644[m
[1m--- a/result_cat.pl_.txt[m
[1m+++ b/result_cat.jar_.txt[m
[36m@@ -144,11 +144,11 @@[m [mh.txt[m

    h <- y (no such file to %)[m

    Error openning file: [31m[./y.txt].[m[32m[y.txt].[m

    h <- z (no such file to @)[m

    Error openning file: [31m[./z.txt].[m[32m[z.txt].[m

h.end[m

```

---

todo features:

-   do not include yml meta block
