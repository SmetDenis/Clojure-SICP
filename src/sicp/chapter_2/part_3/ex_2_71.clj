(ns sicp.chapter-2.part-3.ex-2-71)

; Exercise 2.71
;
; Suppose we have a Huffman tree for an alphabet of n symbols, and that the relative frequencies
; of the symbols are 1,2,4,…,2n−1). Sketch the tree for n=5; for n=10.

; Answer:
; Sketch of Huffman Tree.
;
;                     {a b c d e f g h i j} 1023                     n=10 <--
;                       /                      \
;             {a b c d e f g h i} 511           j 512                n=9
;                    /               \
;          {a b c d e f g h} 255      i 256                          n=8
;                /             \
;       {a b c d e f g} 127     h 128                                n=7
;            /           \
;     {a b c d e f} 63    g 64                                       n=6
;          /         \
;   {a b c d e} 31    f 32                                           n=5  <--
;         /      \
; {a b c d} 15    e 16                                               n=4
;     /      \
; {a b c} 7   d 8                                                    n=3
;    /     \
; {a b} 3   c 4                                                      n=2
;  /   \
; a 1   b 2                                                          n=1
;
; Note. Only the left branch grows.


; In such a tree (for general n) how many bits are required to encode the most frequent symbol?
; Answer: The most frequent symbol (32 or 512) also requires just 1 bit.


; The least frequent symbol?
; Answer: The least frequent symbol is required n-1 bits. So it's 4 or 9.
