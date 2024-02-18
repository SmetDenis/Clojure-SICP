(ns sicp.chapter-2.part-5.book-2-5
  (:require
    [sicp.chapter-2.packages.op-table :as ot]))

(comment "2.5 Systems with Generic Operations ----------------------------------------------------")

(comment "2.5.1 Generic Arithmetic Operations ----------------------------------------------------")

(defn add
  [x y]
  (ot/apply-generic :add x y))

(defn sub
  [x y]
  (ot/apply-generic :sub x y))

(defn mul
  [x y]
  (ot/apply-generic :mul x y))

(defn div
  [x y]
  (ot/apply-generic :div x y))

(comment
  "See also:"
  "sicp.chapter-2.packages.install-scheme-number"
  "sicp.chapter-2.packages.install-rational"
  "sicp.chapter-2.packages.install-rectangular"
  "sicp.chapter-2.packages.install-complex")
