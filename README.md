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

---

todo features:

-   do not include yml meta block
