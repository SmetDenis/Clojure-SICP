(ns sicp.chapter-1.part-2.ex-1-11)

; Exercise 1.11
; A function f is defined by the rule that f(n)=n
; if n<3 and f(n)=f(n−1)+2f(n−2)+3f(n−3)
; if n≥3.

; Write a procedure that computes f by means of a recursive process.
; Write a procedure that computes f by means of an iterative process.

(defn f
  "Recursive process"
  [n]
  (cond (< n 3) n
        :else (+ (f (- n 1))
                 (* 2 (f (- n 2)))
                 (* 3 (f (- n 3))))))

(defn f-v2-iter
  [a b c count]
  (if (= count 0)
    c
    (f-v2-iter b
               c
               (+ c (* 2 b) (* 3 a))
               (- count 1))))

(defn f-v2
  "Iterative process"
  [n]
  (cond (< n 3) n
        :else (f-v2-iter 0 1 2 (- n 2))))
