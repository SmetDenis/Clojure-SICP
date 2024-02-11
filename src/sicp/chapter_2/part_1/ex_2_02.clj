(ns sicp.chapter-2.part-1.ex-2-02
  (:require
    [sicp.misc :as m]))

; Exercise 2.2
; Consider the problem of representing line segments in a plane.
; Each segment is represented as a pair of points: a starting point and an ending point.

; Define a constructor make-segment and selectors start-segment and end-segment that
; define the representation of segments in terms of points.
;
; Furthermore, a point can be represented as a pair of numbers: the x coordinate and the y coordinate.
; Accordingly, specify a constructor make-point and selectors x-point and y-point
; that define this representation.
;
; Finally, using your selectors and constructors, define a procedure midpoint-segment that
; takes a line segment as argument and returns its midpoint (the point whose coordinates are
; the average of the coordinates of the endpoints).
;
; To try your procedures, you’ll need a way to print points:
; (define (print-point p)
;   (newline)
;   (display "(")
;   (display (x-point p))
;   (display ",")
;   (display (y-point p))
;   (display ")"))

(defn make-point
  [x y]
  (m/pair x y))

(defn x-point
  [point]
  (m/car point))

(defn y-point
  [point]
  (m/cdr point))

(defn print-point
  [point]
  (str "(" (x-point point) "," (y-point point) ")"))

(defn make-segment
  [start end]
  (m/pair start end))

(defn start-segment
  [segment]
  (m/car segment))

(defn end-segment
  [segment]
  (m/cdr segment))

(defn midpoint-segment
  [segment]
  (make-point (m/average (x-point (start-segment segment))
                         (x-point (end-segment segment)))
              (m/average (y-point (start-segment segment))
                         (y-point (end-segment segment)))))
