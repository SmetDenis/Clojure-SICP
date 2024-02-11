(ns sicp.chapter-1.part-3.ex-1-34)

; Exercise 1.34: Suppose we define the procedure
;
; (define (f g) (g 2))

; Then we have
; (f square)                                                  ; 4
; (f (lambda (z) (* z (+ z 1))))                              ; 6

; What happens if we (perversely) ask the interpreter to evaluate the combination (f f)?
; Explain.

(defn f
  [g]
  (g 2))

; (f f)
; Error: java.lang.ClassCastException: class java.lang.Long cannot be cast to class clojure.lang.IFn
; (java.lang.Long is in module java.base of loader 'bootstrap';
; clojure.lang.IFn is in unnamed module of loader 'app')
;
; Explanation
; Calling (f f) will cause an error because the function f expects the argument g is a function that takes one argument.
; In your case, when you call (f f f), f tries to call itself with argument 2 (that is, does (f 2)),
; and then this new instance of f tries again to call the argument (which in this context is also f) with 2,
; and so on. This will result in an infinite recursive call and eventually a call stack overflow
; (StackOverflowError).
