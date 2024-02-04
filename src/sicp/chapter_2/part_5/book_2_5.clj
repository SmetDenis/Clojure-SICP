(ns sicp.chapter-2.part-5.book-2-5
  (:require [sicp.chapter-2.part-4.book-2-4 :as b24]
            [sicp.misc :as m]))

(comment "2.5")
; Systems with Generic Operations ------------------------------------------------------------------

(comment "2.5.1")
; Generic Arithmetic Operations --------------------------------------------------------------------

; Custom helper functions. Made myself, just for testing -------------------------------------------

(def operation-table (atom {}))

(defn attach-tag [tag value]
  {:tag tag, :contents value})

(defn put-op [operation types procedure]
  (swap! operation-table assoc-in [operation types] procedure))

(defn get-op [operation types]
  (get-in @operation-table [operation types]))

(defn apply-generic [op & args]
  (let [type-tags (map #(-> % :tag) args)
        operation (get-op op type-tags)]
    (if operation
      (apply operation (map #(:contents %) args))
      (throw (IllegalArgumentException. (str "No method for: " op " " type-tags))))))

; --------------------------------------------------------------------------------------------------

(defn add [x y] (apply-generic :add x y))
(defn sub [x y] (apply-generic :sub x y))
(defn mul [x y] (apply-generic :mul x y))
(defn div [x y] (apply-generic :div x y))

(defn install-scheme-number-package []
  (letfn [(tag [x] (attach-tag :scheme-number x))]
    (put-op :add [:scheme-number :scheme-number] (fn [x y] (tag (+ x y))))
    (put-op :sub [:scheme-number :scheme-number] (fn [x y] (tag (- x y))))
    (put-op :mul [:scheme-number :scheme-number] (fn [x y] (tag (* x y))))
    (put-op :div [:scheme-number :scheme-number] (fn [x y] (tag (/ x y))))
    (put-op :make :scheme-number (fn [x] (tag x)))
    :done))

(defn install-rational-package []
  ; Internal procedures
  (letfn [(numer [x] (first x))
          (denom [x] (second x))
          (make-rat [n d] (let [g (m/gcd n d)]
                            (m/pair (/ n g) (/ d g))))
          (add-rat [x y] (make-rat (+ (* (numer x) (denom y))
                                      (* (numer y) (denom x)))
                                   (* (denom x) (denom y))))
          (sub-rat [x y] (make-rat (- (* (numer x) (denom y))
                                      (* (numer y) (denom x)))
                                   (* (denom x) (denom y))))
          (mul-rat [x y] (make-rat (* (numer x) (numer y))
                                   (* (denom x) (denom y))))
          (div-rat [x y] (make-rat (* (numer x) (denom y))
                                   (* (denom x) (numer y))))
          ; Interface to rest of the system
          (tag [x] (attach-tag :rational x))]
    (put-op :add [:rational :rational] (fn [x y] (tag (add-rat x y))))
    (put-op :sub [:rational :rational] (fn [x y] (tag (sub-rat x y))))
    (put-op :mul [:rational :rational] (fn [x y] (tag (mul-rat x y))))
    (put-op :div [:rational :rational] (fn [x y] (tag (div-rat x y))))
    (put-op :make :rational (fn [n d] (tag (make-rat n d))))
    :done))

(defn install-complex-package []
  ; Imported procedures from rectangular and polar packages
  (letfn [(make-from-real-imag [x y] ((get-op :make-from-real-imag :rectangular) x y))
          (make-from-mag-ang [r a] ((get-op :make-from-mag-ang :polar) r a))
          ; Internal procedures
          (add-complex [z1 z2] (make-from-real-imag
                                 (+ (b24/real-part z1) (b24/real-part z2))
                                 (+ (b24/imag-part z1) (b24/imag-part z2))))
          (sub-complex [z1 z2] (make-from-real-imag
                                 (- (b24/real-part z1) (b24/real-part z2))
                                 (- (b24/imag-part z1) (b24/imag-part z2))))
          (mul-complex [z1 z2] (make-from-mag-ang
                                 (* (b24/magnitude z1) (b24/magnitude z2))
                                 (+ (b24/angle z1) (b24/angle z2))))
          (div-complex [z1 z2] (make-from-mag-ang
                                 (/ (b24/magnitude z1) (b24/magnitude z2))
                                 (- (b24/angle z1) (b24/angle z2))))
          ; Interface to rest of the system
          (tag [z] (attach-tag :complex z))]
    ; Putting functions in a map or registry
    (put-op :add [:complex :complex] (fn [z1 z2] (tag (add-complex z1 z2))))
    (put-op :sub [:complex :complex] (fn [z1 z2] (tag (sub-complex z1 z2))))
    (put-op :mul [:complex :complex] (fn [z1 z2] (tag (mul-complex z1 z2))))
    (put-op :div [:complex :complex] (fn [z1 z2] (tag (div-complex z1 z2))))
    (put-op :make-from-real-imag :complex (fn [x y] (tag (make-from-real-imag x y))))
    (put-op :make-from-mag-ang :complex (fn [r a] (tag (make-from-mag-ang r a))))
    :done))

(defn make-scheme-number [n]
  ((get-op :make :scheme-number) n))

(defn make-rational [n d]
  ((get-op :make :rational) n d))

(defn make-complex-from-real-imag [x y]
  ((get-op :make-from-real-imag :complex) x y))

(defn make-complex-from-mag-ang [r a]
  ((get-op :make-from-mag-ang :complex) r a))
