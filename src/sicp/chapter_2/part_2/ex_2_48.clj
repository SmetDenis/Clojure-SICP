(ns sicp.chapter-2.part-2.ex-2-48
  (:require [sicp.misc :as m]))

; Exercise 2.48
;
; A directed line segment in the plane can be represented as a pair of vectors—the vector
; running from the origin to the start-point of the segment, and the vector running from
; the origin to the end-point of the segment.
;
; Use your vector representation from Exercise 2.46 to define a representation for segments
; with a constructor make-segment and selectors start-segment and end-segment.

(defn make-segment [x y]
  (m/pair x y))

(defn start-segment [vect]
  (m/car vect))

(defn end-segment [vect]
  (m/cdr vect))
