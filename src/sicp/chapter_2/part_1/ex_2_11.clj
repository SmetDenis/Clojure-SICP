(ns sicp.chapter-2.part-1.ex-2-11
  (:require
    [sicp.misc :as m]))

; Exercise 2.11
; In passing, Ben also cryptically comments: “By testing the signs of the endpoints
; of the intervals, it is possible to break mul-interval into nine cases, only one
; of which requires more than two multiplications.”
; Rewrite this procedure using Ben’s suggestion.
;
; After debugging her program, Alyssa shows it to a potential user,
; who complains that her program solves the wrong problem.
; He wants a program that can deal with numbers represented as a center value
; and an additive tolerance; for example, he wants to work with intervals such as 3.5 ± 0.15
; rather than [3.35, 3.65].
; Alyssa returns to her desk and fixes this problem by supplying
; an alternate constructor and alternate selectors:
;
; (define (make-center-width c w)
;   (make-interval (- c w) (+ c w)))
;
; (define (center i)
;   (/ (+ (lower-bound i)
;         (upper-bound i))
;      2))
;
; (define (width i)
;   (/ (- (upper-bound i)
;         (lower-bound i))
;      2))
;
; Unfortunately, most of Alyssa’s users are engineers.
; Real engineering situations usually involve measurements with only a small uncertainty,
; measured as the ratio of the width of the interval to the midpoint of the interval.
; Engineers usually specify percentage tolerances on the parameters of devices,
; as in the resistor specifications given earlier.

(defn make-center-width
  [c w]
  (m/make-interval (- c w) (+ c w)))

(defn center
  [i]
  (/ (+ (m/lower-bound i) (m/upper-bound i)) 2.0))

(defn width
  [i]
  (/ (- (m/upper-bound i) (m/lower-bound i)) 2.0))

; Solution

(defn interval-case
  [low high]
  (cond (and (neg? low) (neg? high)) -1
        (and (neg? low) (pos? high)) 0
        :else 1))

(defn mul-interval
  [i1 i2]
  (let [i1-lo   (m/lower-bound i1)
        i1-hi   (m/upper-bound i1)
        i2-lo   (m/lower-bound i2)
        i2-hi   (m/upper-bound i2)
        i1-case (interval-case i1-lo i1-hi)
        i2-case (interval-case i2-lo i2-hi)]
    (cond
      (= i1-case -1) (cond
                       ; - - - -
                       (= i2-case -1) (m/make-interval (* i1-hi i2-hi) (* i1-lo i2-lo))
                       ; - - - +
                       (zero? i2-case) (m/make-interval (* i1-lo i2-hi) (* i1-lo i2-lo))
                       ; - - + +
                       :else (m/make-interval (* i1-lo i2-hi) (* i1-hi i2-lo)))
      (zero? i1-case) (cond
                        ; - + - -
                        (= i2-case -1) (m/make-interval (* i1-hi i2-lo) (* i1-lo i2-lo))
                        ; - + - +
                        (zero? i2-case) (m/make-interval (min (* i1-lo i2-hi) (* i1-hi i2-lo))
                                                         (max (* i1-lo i2-lo) (* i1-hi i2-hi)))
                        ; - + + +
                        :else (m/make-interval (* i1-lo i2-hi) (* i1-hi i2-hi)))
      :else (cond
              ; + + - -
              (= i2-case -1) (m/make-interval (* i1-hi i2-lo) (* i1-lo i2-hi))
              ; + + - +
              (zero? i2-case) (m/make-interval (* i1-hi i2-lo) (* i1-hi i2-hi))
              ; + + + +
              :else (m/make-interval (* i1-lo i2-lo) (* i1-hi i2-hi))))))
