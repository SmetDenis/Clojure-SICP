(ns sicp.chapter-1.part-3.book-text
  (:require [sicp.misc :refer [cube]]))

(comment "1.3.1")                                           ; Procedures as Arguments ----------------------------------

(defn sum-integers
  [a b]
  (if (> a b)
    0
    (+ a
       (sum-integers (+ a 1) b))))

(defn sum-cubes
  [a b]
  (if (> a b)
    0
    (+ (cube a)
       (sum-cubes (+ a 1) b))))

(defn pi-sum
  [a b]
  (if (> a b)
    0
    (+ (/ 1.0 (* a (+ a 2)))
       (pi-sum (+ a 4) b))))

;(defn ⟨name⟩
;  [a b]
;  (if (> a b)
;    0
;    (+ (⟨term⟩ a)
;       (⟨name⟩ (⟨next⟩ a) b))))

(defn sum-terms
  [term a next b]
  (if (> a b)
    0
    (+ (term a)
       (sum-terms term (next a) next b))))

(defn sum-integers-2
  [a b]
  (sum-terms identity a inc b))

(defn sum-cubes-2
  [a b]
  (sum-terms cube a inc b))

(defn pi-sum-2
  [a b]
  (sum-terms #(/ 1.0 (* % (+ % 2))) a #(+ % 4) b))

(defn integral
  [f a b dx]
  (letfn [(add-dx [x] (+ x dx))]
    (* (sum-terms f (+ a (/ dx 2)) add-dx b) dx)))
