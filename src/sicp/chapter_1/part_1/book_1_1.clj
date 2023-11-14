(ns sicp.chapter-1.part-1.book-1-1)

(comment "1.1.1")
; Expressions --------------------------------------------------------------------------------------

(+ 137 349)                                                 ; 486
(- 1000 334)                                                ; 666
(* 5 99)                                                    ; 495
(/ 10 5)                                                    ; 2
(+ 2.7 10)                                                  ; 12.7

(+ 21 35 12 7)                                              ; 75
(* 25 4 12)                                                 ; 1200
(+ (* 3 5) (- 10 6))                                        ; 19
(+ (* 3 (+ (* 2 4) (+ 3 5))) (+ (- 10 7) 6))                ; 57
(+ (* 3
      (+ (* 2 4)
         (+ 3 5)))
   (+ (- 10 7)
      6))                                                   ; 57

(comment "1.1.2")
; Naming and the Environment -----------------------------------------------------------------------

(def size 2)
(* 5 size)                                                  ; 10

(def pi 3.14159)
(def radius 10)
(* pi (* radius radius))                                    ; 314.159
(def circumference (* 2 pi radius))                         ; 62.8318

(comment "1.1.3")
; Evaluating Combinations --------------------------------------------------------------------------

(* (+ 2 (* 4 6)) (+ 3 5 7))                                 ; 390

(comment "1.1.4")
; Compound Procedures ------------------------------------------------------------------------------

(defn square [x]
  (* x x))

(square 21)                                                 ; 441
(square (+ 2 5))                                            ; 49
(square (square 3))                                         ; 81

(defn sum-of-squares [x y]
  (+ (square x) (square y)))

(sum-of-squares 3 4)                                        ; 25

(defn f [a]
  (sum-of-squares (+ a 1) (* a 2)))

(f 5)                                                       ; 136

(comment "1.1.5")
; The Substitution Model for Procedure Application -------------------------------------------------

(f 5)                                                       ; 136
(sum-of-squares (+ 5 1) (* 5 2))                            ; 136
(+ (square 6) (square 10))                                  ; 136
(+ (* 6 6) (* 10 10))                                       ; 136
(+ 36 100)                                                  ; 136

(sum-of-squares (+ 5 1) (* 5 2))                            ; 136
(+ (square (+ 5 1))
   (square (* 5 2)))                                        ; 136
(+ (* (+ 5 1) (+ 5 1))
   (* (* 5 2) (* 5 2)))                                     ; 136

(comment "1.1.6")
; Conditional Expressions and Predicates -----------------------------------------------------------
; Exercises:
; * 1.1
; * 1.2
; * 1.3
; * 1.4
; * 1.5

; Renamed `abs` => `abs-x` due to Clojure conflit names
(defn abs-1
  [x]
  (cond (> x 0) x
        (= x 0) 0
        (< x 0) (- x)))

(defn abs-2 [x]
  (cond (< x 0) (- x)
        :else x))

(defn abs-3 [x]
  (if (< x 0)
    (- x)
    x))

; Renamed due to Clojure conflit names
(defn >=-1 [x y]
  (or (> x y) (= x y)))

(defn >=-2 [x y]
  (not (< x y)))

(comment "1.1.7")
; Example: Square Roots by Newton’s Method ---------------------------------------------------------
; Exercises:
; * 1.6
; * 1.7
; * 1.8

(defn average [x y]
  (/ (+ x y) 2))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn good-enough? [guess x]
  (< (abs (- (square guess) x)) 0.001))

(defn sqrt-iter
  [guess x]
  (if (good-enough? guess x)
    guess
    (sqrt-iter (improve guess x) x)))

(defn sqrt [x]
  (sqrt-iter 1.0 x))

(comment "1.1.8")
; Procedures as Black-Box Abstractions -------------------------------------------------------------

(defn square-alt [x]
  (Math/exp (double (Math/log x))))

(defn sqrt-alt [x]
  (letfn [(good-enough? [guess x] (< (abs (- (* guess guess) x)) 0.001))
          (improve [guess x] (/ (+ guess (/ x guess)) 2))
          (sqrt-iter [guess x]
            (if (good-enough? guess x)
              guess
              (sqrt-iter (improve guess x) x)))]
    (sqrt-iter 1.0 x)))
