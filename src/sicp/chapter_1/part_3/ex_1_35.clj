(ns sicp.chapter-1.part-3.ex-1-35
  (:require [sicp.chapter-1.part-3.book-1-3 :as b]))

; Exercise 1.35
; Show that the golden ratio φ (1.2.2) is a fixed point of the transformation x↦1+1/x,
; and use this fact to compute φ by means of the fixed-point procedure.

(defn gorlden-ration
  [precision]
  (b/fixed-point #(+ 1.0 (/ 1 %)) precision))
