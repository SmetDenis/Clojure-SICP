(ns sicp.chapter-2.part-4.book-2-4)

(comment "2.4")
; Multiple Representations for Abstract Data -------------------------------------------------------

(comment "2.4.1")
; Representations for Complex Numbers --------------------------------------------------------------

; Ben's way
(defn real-part-Ben [z] (first z))
(defn imag-part-Ben [z] (second z))
(defn magnitude-Ben [z] (Math/sqrt (+ (Math/pow (real-part-Ben z) 2)
                                      (Math/pow (imag-part-Ben z) 2))))
(defn angle-v1 [z] (Math/atan2 (imag-part-Ben z) (real-part-Ben z)))

(defn make-from-real-imag-Ben
  ([x y] [x y])
  ([z] [(real-part-Ben z) (imag-part-Ben z)]))

(defn make-from-mag-ang-Ben
  ([r a] [(* r (Math/cos a)) (* r (Math/sin a))])
  ([z] [(magnitude-Ben z) (angle-v1 z)]))

(defn add-complex-Ben [z1 z2]
  (make-from-real-imag-Ben
    (+ (real-part-Ben z1) (real-part-Ben z2))
    (+ (imag-part-Ben z1) (imag-part-Ben z2))))

(defn sub-complex-Ben [z1 z2]
  (make-from-real-imag-Ben
    (- (real-part-Ben z1) (real-part-Ben z2))
    (- (imag-part-Ben z1) (imag-part-Ben z2))))

(defn mul-complex-Ben [z1 z2]
  (make-from-mag-ang-Ben
    (* (magnitude-Ben z1) (magnitude-Ben z2))
    (+ (angle-v1 z1) (angle-v1 z2))))

(defn div-complex-Ben [z1 z2]
  (make-from-mag-ang-Ben
    (/ (magnitude-Ben z1) (magnitude-Ben z2))
    (- (angle-v1 z1) (angle-v1 z2))))

; Alyssa's way
(defn magnitude-Alyssa [z] (first z))
(defn angle-Alyssa [z] (second z))
(defn real-part-Alyssa [z] (* (magnitude-Alyssa z) (Math/cos (angle-Alyssa z))))
(defn imag-part-Alyssa [z] (* (magnitude-Alyssa z) (Math/sin (angle-Alyssa z))))
(defn make-from-real-imag-Alyssa [x y] [(Math/sqrt (+ (Math/pow x 2) (Math/pow y 2)))
                                        (Math/atan2 y x)])
(defn make-from-mag-ang-Alyssa [r a] [r a])

(comment "2.4.2")
; Tagged data --------------------------------------------------------------------------------------

; Types/tags of data
(defn attach-tag [type-tag contents]
  (cons type-tag contents))

(defn type-tag [datum]
  (if (sequential? datum)
    (first datum)
    (throw (Exception. (str "Bad tagged datum: TYPE-TAG " datum)))))

(defn contents [datum]
  (if (sequential? datum)
    (rest datum)
    (throw (Exception. (str "Bad tagged datum: CONTENTS " datum)))))

(defn rectangular? [z]
  (= (type-tag z) :rectangular))

(defn polar? [z]
  (= (type-tag z) :polar))

; Rectangular
(defn real-part-rectangular [z] (first z))
(defn imag-part-rectangular [z] (second z))

(defn magnitude-rectangular [z]
  (Math/sqrt (+ (Math/pow (real-part-rectangular z) 2)
                (Math/pow (imag-part-rectangular z) 2))))

(defn angle-rectangular [z]
  (Math/atan2 (imag-part-rectangular z)
              (real-part-rectangular z)))

(defn make-from-real-imag-rectangular [x y]
  (attach-tag :rectangular [x y]))

(defn make-from-mag-ang-rectangular [r a]
  (attach-tag :rectangular [(* r (Math/cos a)) (* r (Math/sin a))]))

; Polar
(defn magnitude-polar [z] (first z))
(defn angle-polar [z] (second z))

(defn real-part-polar [z]
  (* (magnitude-polar z) (Math/cos (angle-polar z))))

(defn imag-part-polar [z]
  (* (magnitude-polar z) (Math/sin (angle-polar z))))

(defn make-from-real-imag-polar [x y]
  (attach-tag :polar
              [(Math/sqrt (+ (Math/pow x 2) (Math/pow y 2)))
               (Math/atan2 y x)]))

(defn make-from-mag-ang-polar [r a]
  (attach-tag :polar [r a]))

; Compounding of Polar and Rectangular ways
(defn real-part [z]
  (cond
    (rectangular? z) (real-part-rectangular (contents z))
    (polar? z) (real-part-polar (contents z))
    :else (throw (Exception. (str "Unknown type: REAL-PART " z)))))

(defn imag-part [z]
  (cond
    (rectangular? z) (imag-part-rectangular (contents z))
    (polar? z) (imag-part-polar (contents z))
    :else (throw (Exception. (str "Unknown type: IMAG-PART " z)))))

(defn magnitude [z]
  (cond
    (rectangular? z) (magnitude-rectangular (contents z))
    (polar? z) (magnitude-polar (contents z))
    :else (throw (Exception. (str "Unknown type: MAGNITUDE " z)))))

(defn angle [z]
  (cond
    (rectangular? z) (angle-rectangular (contents z))
    (polar? z) (angle-polar (contents z))
    :else (throw (Exception. (str "Unknown type: ANGLE " z)))))

(defn make-from-real-imag-v2 [x y]
  (make-from-real-imag-rectangular x y))

(defn add-complex [z1 z2]
  (make-from-real-imag-v2
    (+ (real-part z1) (real-part z2))
    (+ (imag-part z1) (imag-part z2))))

(defn make-from-mag-ang-v2 [r a]
  (make-from-mag-ang-polar r a))

(comment "2.4.3")
; Data-Directed Programming and Additivity ---------------------------------------------------------
; Exercises:
; * 2.73
; * 2.74
; * 2.75
; * 2.76

(defn apply-generic [op & args]
  (let [type-tags (map type-tag args)
        proc      (get op type-tags)]
    (if proc
      (apply proc (map contents args))
      (throw (Exception. (str "No method for these types: APPLY-GENERIC "
                              (list op type-tags)))))))

(defn make-from-real-imag [x y]
  (fn [op]
    (cond
      (= op :real-part) x
      (= op :imag-part) y
      (= op :magnitude) (Math/sqrt (+ (* x x) (* y y)))
      (= op :angle) (Math/atan2 y x)
      :else (throw (Exception. (str "Unknown op: MAKE-FROM-REAL-IMAG " op))))))

(defn apply-generic-v2 [op arg] (arg op))

