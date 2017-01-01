# cat

`bin` 下面的 [`cat.pl`](bin/cat.pl) 就像 `cat` 这个指令一样，
它可以连接（合并）多个文件，但 `cat` 是横向地合并，`cat.pl` 是纵向地合并。

使用方法为：

    // 递归地引入其它文件：(mnemonics/巧记法: `@` 象形为递归)

    @include <-=path=

    // 原样地引入其它文件：(mnemonics: `%` **p**ercent/百分号 ---> **p**reserve/保留)

    %include <-=path=

    // Verbatim

    "@@include <-=path=" 会变成 "@include <-=path="
    "%%include <-=path=" 会变成 "%include <-=path="

    //  path 可以是绝对路径，比如：
    //
    //      "D:\tzx\git\cat\README.md"
    //      "D:\\tzx\\git\\cat\\README.md"
    //      "D:/tzx/git/cat/README.md"
    //      "/etc/issue"
    //
    //  也可以是相对路径（相对于当前处理的文本），比如：
    //
    //      "test/a.txt"
    //      "test/d/../b.txt"
    //      "../blog/README"
    //      "~/git/cat/README.md"

---

这是一个比较 clean 的 cat.pl，已经相当强大，源码不多，贴在这里（如果你喜欢简洁版）：

```perl
#!/usr/bin/perl
#
# Usage:
#       $ perl cat.pl INPUT_FILE > OUTPUT_FILE
#
# Detailed Example:
#       https://github.com/district10/cat/blob/master/tutorial_cat.pl_.md

use 5.010;
use strict;
use warnings;
use File::Basename;
use Cwd 'abs_path';

sub inList {                                # is needle in haystack?
    my $needle = shift;
    my @haystack = @_;
    foreach my $hay (@haystack) {
        if ($needle eq $hay) { return 1; }
    }
    return 0;
}

sub preserveLines {
    my $pd = shift;                         # pd: padding
    my $fn = shift;                         # fn: filename
    if (open my $fh, '<', $fn) {            # fh: file handle
        while(<$fh>) {
            s/\r?\n?$//;
            print $pd.$_."\n";
        }
    } else {
        print STDERR "Error openning file: [".$fn."].\n";
        print    $pd."Error openning file: [".$fn."].\n";
    }
}

sub unfoldLines {
    my $pd = shift;
    my $fn = shift;
    if (! -f $fn) {                         # -f: Entry is a plain file
        print STDERR "Error openning file: [".$fn."].\n";
        print    $pd."Error openning file: [".$fn."].\n";
        return;
    }
    my $ap = abs_path($fn);                 # ap: abs path
    if (&inList($ap, @_) == 1) {
        &preserveLines($pd, $fn);
    } else {
        unshift(@_, $ap);
        open my $fh, '<', $fn or return;
        my $dn = dirname($fn);              # dn: dirname
        while(<$fh>) {
            s/\r?\n?$//;
            if (/^(\s*)\@include <-=([^=]*)=$/) {
                my $p = $1; my $f = $2;
                if ($f =~ /^.:/ or $f =~ /^\//) {
                    &unfoldLines($pd.$p, $f, @_);
                } else {
                    &unfoldLines($pd.$p, $dn."/".$f, @_);
                }
            } elsif (/^(\s*)\%include <-=([^=]*)=$/) {
                my $p = $1; my $f = $2;
                if ($f =~ /^.:/ or $f =~ /^\//) {
                    &preserveLines($pd.$p, $f);
                } else {
                    &preserveLines($pd.$p, $dn."/".$f);
                }
            } elsif (/^(?<p>\s*)\%\%include <-=(?<f>[^=]*)=$/) {
                print $pd.$+{p}.'%include <-='.$+{f}."=\n";
            } elsif (/^(?<p>\s*)\@\@include <-=(?<f>[^=]*)=$/) {
                print $pd.$+{p}.'@include <-='.$+{f}."=\n";
            } else {
                print $pd.$_."\n";
            }
        }
    }
}

if (-f $ARGV[0]) {
    &unfoldLines("", $ARGV[0]);
} else {
    print STDERR "Error openning file: [".$ARGV[0]."].\n";
}
```

---

后来，[`cat.pl`](bin/cat.pl) 有了【去除 yaml 头】的功能，就变得臃肿了一点。

`cat.jar` 实现了类似的功能（使用 `make` 来生成 jar 包），两者的表现几乎一致。
使用实例见
[`tutorial_cat.jar_.md`](tutorial_cat.jar_.md) 和
[`tutorial_cat.pl_.md`](tutorial_cat.pl_.md)。
