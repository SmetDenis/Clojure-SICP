(ns sicp.chapter-2.part-3.ex-2-56)

; Exercise 2.56
;
; Show how to extend the basic differentiator to handle more kinds of expressions.
; For instance, implement the differentiation rule
; d(u^n)/dx = n*u^(n-1)*du/dx
;
; by adding a new clause to the deriv program and defining appropriate procedures exponentiation?
; base, exponent, and make-exponentiation.(You may use the symbol ** to denote exponentiation.)
; Build in the rules that anything raised to the power 0 is 1 and anything raised to
; the power 1 is the thing itself.


