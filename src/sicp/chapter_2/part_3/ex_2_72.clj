(ns sicp.chapter-2.part-3.ex-2-72)

; Exercise 2.72
;
; Consider the encoding procedure that you designed in Exercise 2.68.
; What is the order of growth in the number of steps needed to encode a symbol?
; Be sure to include the number of steps needed to search the symbol list at each node encountered.
; To answer this question in general is difficult.
;
; Consider the special case where the relative frequencies of the n symbols are as described in
; Exercise 2.71, and give the order of growth (as a function of n) of the number of steps needed
; to encode the most frequent and least frequent symbols in the alphabet.

; Answer
; For this specific distribution of symbol frequencies, encoding the most frequent symbol is
; a constant-time operation, while encoding the least frequent symbol has a linear growth in the number of steps with respect to the number of symbols n.
