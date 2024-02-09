(ns sicp.chapter-1.part-3.ex-1-43
  (:require
    [sicp.chapter-1.part-3.ex-1-42 :as ex-1-42]))

; Exercise 1.43
;
; If f is a numerical function and n is a positive integer, then we can form the nth
; repeated application of f, which is defined to be the function whose value at x is f(f(…(f(x))…)).

; For example, if f is the function x->x+1, then the nth repeated application of f is the function
; x->x+n. If f is the operation of squaring a number, then the nth repeated application of f
; is the function that raises its argument to the 2n-th power.
;
; Write a procedure that takes as inputs a procedure that computes f and a positive integer n and
; returns the procedure that computes the nth repeated application of f.
;
; Your procedure should be able to be used as follows:
; ((repeated square 2) 5)
; 625

; Hint: You may find it convenient to use "compose" from "Exercise 1.42".

(defn repeated
  [func times]
  (fn [x]
    (letfn [(iter
              [i result]
              (if (= times i)
                result
                (iter (inc i) (func result))))]
      (iter 1 (func x)))))

(defn repeated-compose
  [func times]
  (if (= 1 times)
    func
    (ex-1-42/compose func (repeated func (dec times)))))
