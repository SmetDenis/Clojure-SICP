(ns sicp.chapter-2.part-2.ex-2-37
  (:require
    [sicp.chapter-2.part-2.book-2-2 :as b22]
    [sicp.chapter-2.part-2.ex-2-36 :as ex-2-36]))

; Exercise 2.37
;
; Suppose we represent vectors v = (vi) as sequences of numbers, and matrices m = (mij)
; as sequences of vectors (the rows of the matrix). For example, the matrix
;
; | 1 2 3 4 |
; | 4 5 6 6 |
; | 6 7 8 9 |
;
; is represented as the sequence ((1 2 3 4) (4 5 6 6) (6 7 8 9)).
; With this representation, we can use sequence operations to concisely express the basic
; matrix and vector operations. These operations (which are described in any book on
; matrix algebra) are the following:
;
; (dot-product v w)                  ; returns the sum "Summa i (vi * wi)"
; (matrix-*-vector m v)              ; returns vector t where ti  = Summa j (mij * vj)
; (matrix-*-matrix m n)              ; returns matrix p where pij = Summa k (mik * nkj)
; (transpose m)                      ; returns matrix n where nij = mji
;
; We can define the dot product as
;
; (define (dot-product v w)
;   (accumulate + 0 (map * v w)))
;
; Fill in the missing expressions in the following procedures for computing the other matrix
; operations. (The procedure accumulate-n is defined in Exercise 2.36.)
;
; (define (matrix-*-vector m v)
;   (map ⟨??⟩ m))
;
; (define (transpose mat)
;   (accumulate-n ⟨??⟩ ⟨??⟩ mat))
;
; (define (matrix-*-matrix m n)
;   (let ((cols (transpose n)))
;     (map ⟨??⟩ m)))
;

(defn dot-product
  [v w]
  (b22/accumulate + 0 (map * v w)))

(defn matrix-*-vector
  [m v]
  (map (fn [i] (dot-product i v)) m))

(defn transpose
  [mat]
  (ex-2-36/accumulate-n cons nil mat))

(defn matrix-*-matrix
  [m n]
  (let [cols (transpose n)]
    (map (fn [rows] (matrix-*-vector cols rows)) m)))
