#!/usr/bin/perl

while(<>) {
    s/\s*\r?\n?$//;
    print $_."\n";
}
