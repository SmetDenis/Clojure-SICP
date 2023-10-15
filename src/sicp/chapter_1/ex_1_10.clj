(ns sicp.chapter-1.ex-1-10)

; Exercise 1.10
; The following procedure computes a mathematical function called Ackermann’s function.
(defn A [x y]
  (cond (= y 0) 0
        (= x 0) (* 2 y)
        (= y 1) 2
        :else (A (- x 1)
                 (A x (- y 1)))))

; What are the values of the following expressions?
(A 1 10)
(A 2 4)
(A 3 3)

; Consider the following procedures, where A is the procedure defined above:
(defn f [n] (A 0 n))
(defn g [n] (A 1 n))
(defn h [n] (A 2 n))
(defn k [n] (* 5 n n))

; Give concise mathematical definitions for the functions computed
; by the procedures f, g, and h for positive integer values of n.
; For example, (k n) computes 5*n^2.
