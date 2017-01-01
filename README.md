# cat

`bin` ����� [`cat.pl`](bin/cat.pl) ���� `cat` ���ָ��һ����
���������ӣ��ϲ�������ļ����� `cat` �Ǻ���غϲ���`cat.pl` ������غϲ���

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
    //      "/etc/issue"
    //
    //  Ҳ���������·��������ڵ�ǰ������ı��������磺
    //
    //      "test/a.txt"
    //      "test/d/../b.txt"
    //      "../blog/README"
    //      "~/git/cat/README.md"

---

����һ���Ƚ� clean �� cat.pl���Ѿ��൱ǿ��Դ�벻�࣬������������ϲ�����棩��

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

������[`cat.pl`](bin/cat.pl) ���ˡ�ȥ�� yaml ͷ���Ĺ��ܣ��ͱ��ӷ����һ�㡣

`cat.jar` ʵ�������ƵĹ��ܣ�ʹ�� `make` ������ jar ���������ߵı��ּ���һ�¡�
ʹ��ʵ����
[`tutorial_cat.jar_.md`](tutorial_cat.jar_.md) ��
[`tutorial_cat.pl_.md`](tutorial_cat.pl_.md)��
