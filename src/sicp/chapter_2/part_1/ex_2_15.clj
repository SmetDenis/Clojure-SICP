(ns sicp.chapter-2.part-1.ex-2-15)

; Exercise 2.15
; Eva Lu Ator, another user, has also noticed the different intervals computed by different
; but algebraically equivalent expressions.
; She says that a formula to compute with intervals using Alyssa’s system will produce
; tighter error bounds if it can be written in such a form that no variable that represents
; an uncertain number is repeated. Thus, she says, par2 is a “better” program for parallel
; resistances than par1. Is she right? Why?

; See test/sicp/chapter_2/part_1/ex_2_15_test.clj