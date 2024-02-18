(ns sicp.chapter-2.packages.install-rational
  (:require
    [sicp.chapter-2.packages.op-table :as ot]
    [sicp.misc :as m]))

(defn install-rational-package
  []
  ; Internal procedures
  (letfn [(numer [x] (first x))
          (denom [x] (second x))
          (make-rat
            [n d]
            (let [g (m/gcd n d)]
              (m/pair (/ n g) (/ d g))))
          (add-rat
            [x y]
            (make-rat (+ (* (numer x) (denom y))
                         (* (numer y) (denom x)))
                      (* (denom x) (denom y))))
          (sub-rat
            [x y]
            (make-rat (- (* (numer x) (denom y))
                         (* (numer y) (denom x)))
                      (* (denom x) (denom y))))
          (mul-rat
            [x y]
            (make-rat (* (numer x) (numer y))
                      (* (denom x) (denom y))))
          (div-rat
            [x y]
            (make-rat (* (numer x) (denom y))
                      (* (denom x) (numer y))))
          ; Interface to rest of the system
          (tag [x] (ot/attach-tag :rational x))]
    (ot/put :add [:rational :rational] (fn [x y] (tag (add-rat x y))))
    (ot/put :sub [:rational :rational] (fn [x y] (tag (sub-rat x y))))
    (ot/put :mul [:rational :rational] (fn [x y] (tag (mul-rat x y))))
    (ot/put :div [:rational :rational] (fn [x y] (tag (div-rat x y))))
    (ot/put :make :rational (fn [n d] (tag (make-rat n d))))
    :done))

(defn make-rational
  [n d]
  ((ot/get :make :rational) n d))
