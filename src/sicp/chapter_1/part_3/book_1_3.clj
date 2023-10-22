(ns sicp.chapter-1.part-3.book-1-3
  (:require [sicp.misc :as m]))

(comment "1.3.1")
; Procedures as Arguments --------------------------------------------------------------------------
; Exercises:
; * 1.29
; * 1.30
; * 1.31
; * 1.32
; * 1.33

(defn sum-integers
  [a b]
  (if (> a b)
    0
    (+ a (sum-integers (+ a 1) b))))

(defn sum-cubes
  [a b]
  (if (> a b)
    0
    (+ (m/cube a)
       (sum-cubes (+ a 1) b))))

(defn pi-sum
  [a b]
  (if (> a b)
    0
    (+ (/ 1.0 (* a (+ a 2)))
       (pi-sum (+ a 4) b))))

(defn sum-terms
  [term a next b]
  (if (> a b)
    0
    (+ (term a)
       (sum-terms term (next a) next b))))

(defn sum-integers-2 [a b]
  (sum-terms identity a inc b))

(defn sum-cubes-2 [a b]
  (sum-terms m/cube a inc b))

(defn pi-sum-2 [a b]
  (sum-terms #(/ 1.0 (* % (+ % 2))) a #(+ % 4) b))

(defn integral
  [f a b dx]
  (letfn [(add-dx [x] (+ x dx))]
    (* (sum-terms f (+ a (/ dx 2)) add-dx b) dx)))

(comment "1.3.2")
; Constructing Procedures Using Lambda -------------------------------------------------------------
; Exercises:
; * 1.34

(defn pi-sum-lamda [a b]
  (sum-terms #(/ 1.0 (* % (+ % 2))) a #(+ % 4) b))

(defn integral-lamda [f a b dx]
  (* (sum-terms f (+ a (/ dx 2.0)) #(+ % dx) b) dx))

(defn f-1
  [x y]
  (letfn [(f-helper [a b]
            (+ (* x (m/square a))
               (* y b)
               (* a b)))]
    (f-helper (+ 1 (* x y))
              (- 1 y))))

(defn f-2 [x y]
  (let [a (+ 1 (* x y))
        b (- 1 y)]
    (+ (* x (m/square a))
       (* y b)
       (* a b))))

(comment "1.3.3")
; Procedures as General Methods --------------------------------------------------------------------
; Exercises:
; * 1.35
; * 1.36
; * 1.37
; * 1.38
; * 1.39

(defn search
  [f neg-point pos-point]
  (let [midpoint (m/average neg-point pos-point)]
    (if (m/close-enough? neg-point pos-point)
      midpoint
      (let [test-value (f midpoint)]
        (cond
          (m/positive? test-value) (search f neg-point midpoint)
          (m/negative? test-value) (search f midpoint pos-point)
          :else midpoint)))))

(defn half-interval-method
  [f a b]
  (let [a-value (f a)
        b-value (f b)]
    (cond
      (and (m/negative? a-value) (m/positive? b-value)) (search f a b)
      (and (m/negative? b-value) (m/positive? a-value)) (search f b a)
      :else (throw (Exception. (str "Values are not of opposite sign " a " " b))))))

(defn fixed-point
  [f first-guess]
  (letfn [(try-fn [guess]
            (let [next (f guess)]
              (if (m/close-enough? guess next 0.00001) next (recur next))))]
    (try-fn first-guess)))

(defn sqrt [x]
  (fixed-point #(/ (+ % (/ x %)) 2) 1.0))

(comment "1.3.4")
; Procedures as Returned Values --------------------------------------------------------------------
; Exercises:
; * 1.40
; * 1.41
; * 1.42
; * 1.43
; * 1.44
; * 1.45
; * 1.46

(defn average-damp [f]
  (fn [x] (m/average x (f x))))

(defn sqrt-lamda [x]
  (fixed-point (average-damp #(/ x %)) 1.0))

(defn cube-root [x]
  (fixed-point (average-damp #(/ x (m/square %))) 1.0))

(defn deriv
  ([g] (deriv g 0.00001))
  ([g dx] (fn [x] (/ (- (g (+ x dx)) (g x)) dx))))

(defn newton-transform [g]
  (fn [x] (- x (/ (g x) ((deriv g) x)))))

(defn newtons-method [g guess]
  (fixed-point (newton-transform g) guess))

(defn sqrt-newton [x]
  (newtons-method (fn [y] (- (m/square y) x)) 1.0))
