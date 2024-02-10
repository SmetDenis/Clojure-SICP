(ns sicp.chapter-2.part-1.ex-2-03
  (:require
    [sicp.chapter-2.part-1.ex-2-02 :as ex-2-02]
    [sicp.misc :as m]))

; Exercise 2.3
; Implement a representation for rectangles in a plane.
; (Hint: You may want to make use of Exercise 2.2.)
; In terms of your constructors and selectors, create procedures
; that compute the perimeter and the area of a given rectangle.
;
; Now implement a different representation for rectangles.
; Can you design your system with suitable abstraction barriers,
; so that the same perimeter and area procedures will work using either representation?

(defn length-segment
  [segment]
  (Math/hypot (- (ex-2-02/x-point (ex-2-02/start-segment segment))
                 (ex-2-02/x-point (ex-2-02/end-segment segment)))
              (- (ex-2-02/y-point (ex-2-02/start-segment segment))
                 (ex-2-02/y-point (ex-2-02/end-segment segment)))))

(defn make-rectangle
  [segment-width segment-height]
  (m/pair segment-width segment-height))

(defn side-width-rectangle
  [rectangle]
  (m/car rectangle))

(defn side-height-rectangle
  [rectangle]
  (m/cdr rectangle))

(defn area-rectangle
  [rectangle]
  (* (length-segment (side-width-rectangle rectangle))
     (length-segment (side-height-rectangle rectangle))))

(defn perimeter-rectangle
  [rectangle]
  (* 2 (+ (length-segment (side-width-rectangle rectangle))
          (length-segment (side-height-rectangle rectangle)))))
