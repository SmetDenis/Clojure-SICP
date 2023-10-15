(ns sicp.chapter-1.ex-1-20)

; Exercise 1.20
; The process that a procedure generates is of course dependent on the rules used by the interpreter.
; As an example, consider the iterative gcd procedure given above.
; Suppose we were to interpret this procedure using normal-order evaluation, as discussed in 1.1.5.
; (The normal-order-evaluation rule for if is described in Exercise 1.5.)
; Using the substitution method (for normal order), illustrate the process generated in evaluating
; (gcd 206 40) and indicate the remainder operations that are actually performed.
;
; How many remainder operations are actually performed in the normal-order evaluation of (gcd 206 40)?
; In the applicative-order evaluation?

(defn gcd [a b]
  (if (= b 0)
    a
    (gcd b (mod a b))))
