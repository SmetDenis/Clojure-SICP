(ns sicp.chapter-2.part-4.book-2-4)

(comment "2.4 Multiple Representations for Abstract Data -----------------------------------------")

(comment "2.4.1 Representations for Complex Numbers ----------------------------------------------")

; Ben's way ----------------------------------------------------------------------------------------
(defn Ben-real-part
  [z]
  (float (first z)))

(defn Ben-imag-part
  [z]
  (float (second z)))

(defn Ben-magnitude
  [z]
  (Math/sqrt (+ (Math/pow (Ben-real-part z) 2)
                (Math/pow (Ben-imag-part z) 2))))

(defn Ben-angle
  [z]
  (Math/atan2 (Ben-imag-part z) (Ben-real-part z)))

(defn Ben-make-from-real-imag
  ([x y] [(float x) (float y)])
  ([z] [(Ben-real-part z) (Ben-imag-part z)]))

(defn Ben-make-from-mag-ang
  ([r a] [(* r (Math/cos a)) (* r (Math/sin a))])
  ([z] [(Ben-magnitude z) (Ben-angle z)]))

(defn Ben-add-complex
  [z1 z2]
  (Ben-make-from-real-imag
    (+ (Ben-real-part z1) (Ben-real-part z2))
    (+ (Ben-imag-part z1) (Ben-imag-part z2))))

(defn Ben-sub-complex
  [z1 z2]
  (Ben-make-from-real-imag
    (- (Ben-real-part z1) (Ben-real-part z2))
    (- (Ben-imag-part z1) (Ben-imag-part z2))))

(defn Ben-mul-complex
  [z1 z2]
  (Ben-make-from-mag-ang
    (* (Ben-magnitude z1) (Ben-magnitude z2))
    (+ (Ben-angle z1) (Ben-angle z2))))

(defn Ben-div-complex
  [z1 z2]
  (Ben-make-from-mag-ang
    (/ (Ben-magnitude z1) (Ben-magnitude z2))
    (- (Ben-angle z1) (Ben-angle z2))))

; Alyssa's way -------------------------------------------------------------------------------------
(defn Alyssa-magnitude
  [z]
  (first z))

(defn Alyssa-angle
  [z]
  (second z))

(defn Alyssa-real-part
  [z]
  (* (Alyssa-magnitude z) (Math/cos (Alyssa-angle z))))

(defn Alyssa-imag-part
  [z]
  (* (Alyssa-magnitude z) (Math/sin (Alyssa-angle z))))

(defn Alyssa-make-from-real-imag
  [x y]
  [(Math/sqrt (+ (Math/pow x 2) (Math/pow y 2)))
   (Math/atan2 y x)])

(defn Alyssa-make-from-mag-ang
  [r a]
  [(float r) (float a)])

(comment "2.4.2")

; Tagged data --------------------------------------------------------------------------------------

; Types/tags of data
(defn attach-tag
  [type-tag contents]
  (cons type-tag contents))

(defn type-tag
  [datum]
  (if (sequential? datum)
    (first datum)
    (throw (Exception. (str "Bad tagged datum: TYPE-TAG " datum)))))

(defn contents
  [datum]
  (if (sequential? datum)
    (rest datum)
    (throw (Exception. (str "Bad tagged datum: CONTENTS " datum)))))

(defn rectangular?
  [z]
  (= (type-tag z) :rectangular))

(defn polar?
  [z]
  (= (type-tag z) :polar))

; Rectangular
(defn real-part-rectangular
  [z]
  (first z))

(defn imag-part-rectangular
  [z]
  (second z))

(defn magnitude-rectangular
  [z]
  (Math/sqrt (+ (Math/pow (real-part-rectangular z) 2)
                (Math/pow (imag-part-rectangular z) 2))))

(defn angle-rectangular
  [z]
  (Math/atan2 (imag-part-rectangular z)
              (real-part-rectangular z)))

(defn make-from-real-imag-rectangular
  [x y]
  (attach-tag :rectangular [x y]))

(defn make-from-mag-ang-rectangular
  [r a]
  (attach-tag :rectangular [(* r (Math/cos a)) (* r (Math/sin a))]))

; Polar
(defn magnitude-polar
  [z]
  (first z))

(defn angle-polar
  [z]
  (second z))

(defn real-part-polar
  [z]
  (* (magnitude-polar z) (Math/cos (angle-polar z))))

(defn imag-part-polar
  [z]
  (* (magnitude-polar z) (Math/sin (angle-polar z))))

(defn make-from-real-imag-polar
  [x y]
  (attach-tag :polar
              [(Math/sqrt (+ (Math/pow x 2) (Math/pow y 2)))
               (Math/atan2 y x)]))

(defn make-from-mag-ang-polar
  [r a]
  (attach-tag :polar [r a]))

; Compounding of Polar and Rectangular ways
(defn real-part
  [z]
  (cond
    (rectangular? z) (real-part-rectangular (contents z))
    (polar? z) (real-part-polar (contents z))
    :else (throw (Exception. (str "Unknown type: REAL-PART " z)))))

(defn imag-part
  [z]
  (cond
    (rectangular? z) (imag-part-rectangular (contents z))
    (polar? z) (imag-part-polar (contents z))
    :else (throw (Exception. (str "Unknown type: IMAG-PART " z)))))

(defn magnitude
  [z]
  (cond
    (rectangular? z) (magnitude-rectangular (contents z))
    (polar? z) (magnitude-polar (contents z))
    :else (throw (Exception. (str "Unknown type: MAGNITUDE " z)))))

(defn angle
  [z]
  (cond
    (rectangular? z) (angle-rectangular (contents z))
    (polar? z) (angle-polar (contents z))
    :else (throw (Exception. (str "Unknown type: ANGLE " z)))))

(defn make-from-real-imag-v2
  [x y]
  (make-from-real-imag-rectangular x y))

(defn add-complex
  [z1 z2]
  (make-from-real-imag-v2
    (+ (real-part z1) (real-part z2))
    (+ (imag-part z1) (imag-part z2))))

(defn make-from-mag-ang-v2
  [r a]
  (make-from-mag-ang-polar r a))

(comment "2.4.3 Data-Directed Programming and Additivity -----------------------------------------")

; Exercises:
; * 2.73
; * 2.74
; * 2.75
; * 2.76

(defn apply-generic
  [op & args]
  (let [type-tags (map type-tag args)
        proc      (get op type-tags)]
    (if proc
      (apply proc (map contents args))
      (throw (Exception. (str "No method for these types: APPLY-GENERIC "
                              (list op type-tags)))))))

(defn make-from-real-imag
  [x y]
  (fn [op]
    (cond
      (= op :real-part) x
      (= op :imag-part) y
      (= op :magnitude) (Math/sqrt (+ (* x x) (* y y)))
      (= op :angle) (Math/atan2 y x)
      :else (throw (Exception. (str "Unknown op: MAKE-FROM-REAL-IMAG " op))))))

(defn apply-generic-v2
  [op arg]
  (arg op))
