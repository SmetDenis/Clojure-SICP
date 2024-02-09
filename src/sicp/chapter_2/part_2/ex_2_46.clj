(ns sicp.chapter-2.part-2.ex-2-46
  (:require
    [sicp.misc :as m]))

; Exercise 2.46
;
; A two-dimensional vector v running from the origin to a point can be represented as a pair
; consisting of an x coordinate and a y coordinate.
;
; Implement a data abstraction for vectors by giving a constructor make-vect and corresponding
; selectors xcor-vect and ycor-vect. In terms of your selectors and constructor,
; implement procedures add-vect, sub-vect, and scale-vect that perform the operations vector
; addition, vector subtraction, and multiplying a vector by a scalar:
;
; (x1, y1) + (x2, y2) = (x1 + x2, y1 + y2)
; (x1, y1) - (x2, y2) = (x1 - x2, y1 - y2)
; s*(x, y) = (s*x, s*y)

(defn make-vect
  [x y]
  (m/pair x y))

(defn xcor-vect
  [vect]
  (m/car vect))

(defn ycor-vect
  [vect]
  (m/cdr vect))

(defn add-vect
  [v1 v2]
  (make-vect (+ (xcor-vect v1)
                (xcor-vect v2))
             (+ (ycor-vect v1)
                (ycor-vect v2))))

(defn sub-vect
  [v1 v2]
  (make-vect (- (xcor-vect v1)
                (xcor-vect v2))
             (- (ycor-vect v1)
                (ycor-vect v2))))

(defn scale-vect
  [s v]
  (make-vect (* s (xcor-vect v))
             (* s (ycor-vect v))))
