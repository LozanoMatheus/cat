# cat

`bin` ÏÂÃæµÄ [`cat.pl`](bin/cat.pl) ¾ÍÏñ `cat` Õâ¸öÖ¸ÁîÒ»Ñù£¬
Ëü¿ÉÒÔÁ¬½Ó£¨ºÏ²¢£©¶à¸öÎÄ¼ş£¬µ« `cat` ÊÇºáÏòµØºÏ²¢£¬`cat.pl` ÊÇ
×İÏòµØºÏ²¢¡£

Ê¹ÓÃ·½·¨Îª£º

    // µİ¹éµØÒıÈëÆäËüÎÄ¼ş£º(mnemonics/ÇÉ¼Ç·¨: `@` ÏóĞÎÎªµİ¹é)

    @include <-=path=

    // Ô­ÑùµØÒıÈëÆäËüÎÄ¼ş£º(mnemonics: `%` **p**ercent/°Ù·ÖºÅ ---> **p**reserve/±£Áô)

    %include <-=path=

    // Verbatim

    "@@include <-=path=" »á±ä³É "@include <-=path="
    "%%include <-=path=" »á±ä³É "%include <-=path="
    %%include <-=path=" »á±ä³É "%include <-=path=

    //  path ¿ÉÒÔÊÇ¾ø¶ÔÂ·¾¶£¬±ÈÈç£º
    //
    //      "D:\tzx\git\cat\README.md"
    //      "D:\\tzx\\git\\cat\\README.md"
    //      "D:/tzx/git/cat/README.md"
    //      "~/git/cat/README.md"
    //
    //  Ò²¿ÉÒÔÊÇÏà¶ÔÂ·¾¶£¨Ïà¶ÔÓÚµ±Ç°´¦ÀíµÄÎÄ±¾£©£¬±ÈÈç£º
    //
    //      "test/a.txt"
    //      "test/d/../b.txt"
    //      "../blog/README"

`cat.jar` ÊµÏÖÁËÀàËÆµÄ¹¦ÄÜ£¨Ê¹ÓÃ `make` À´Éú³É jar °ü£©£¬Á½ÕßµÄ±íÏÖ¼¸ºõÒ»ÖÂ¡£
Ê¹ÓÃÊµÀı¼û
[`tutorial_cat.jar_.md`](tutorial_cat.jar_.md) ºÍ
[`tutorial_cat.pl_.md`](tutorial_cat.pl_.md)¡£

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
