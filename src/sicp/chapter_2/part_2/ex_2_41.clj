(ns sicp.chapter-2.part-2.ex-2-41
  (:require
    [sicp.chapter-2.part-2.book-2-2 :as b22]))

; Exercise 2.41
;
; Write a procedure to find all ordered triples of distinct positive integers i, j, and k
; less than or equal to a given integer n that sum to a given integer s.

(defn duplets
  [n]
  (b22/flatmap (fn [i]
                 (map (fn [j] (list i j))
                      (b22/enumerate-interval 1 n)))
               (b22/enumerate-interval 1 n)))

(defn triplets
  [n]
  (b22/flatmap (fn [i]
                 (map (fn [j] (cons i j))
                      (duplets n)))
               (b22/enumerate-interval 1 n)))

(defn check-triplet?
  [triplet]
  (and (< (b22/list-ref triplet 0)
          (b22/list-ref triplet 1))
       (< (b22/list-ref triplet 1)
          (b22/list-ref triplet 2))))

(defn check-triplet-sum?
  [triplet sum]
  (= sum (+ (b22/list-ref triplet 0)
            (b22/list-ref triplet 1)
            (b22/list-ref triplet 2))))

(defn find-triplets
  [n s]
  (filter (fn [i] (check-triplet-sum? i s))
          (filter check-triplet? (triplets n))))
