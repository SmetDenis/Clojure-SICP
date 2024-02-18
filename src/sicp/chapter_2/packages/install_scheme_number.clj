(ns sicp.chapter-2.packages.install-scheme-number
  (:require
    [sicp.chapter-2.packages.op-table :as ot]))

(defn install-scheme-number-package
  []
  (letfn [(tag [x] (ot/attach-tag :scheme-number x))]
    (ot/put :add [:scheme-number :scheme-number] (fn [x y] (tag (+ x y))))
    (ot/put :sub [:scheme-number :scheme-number] (fn [x y] (tag (- x y))))
    (ot/put :mul [:scheme-number :scheme-number] (fn [x y] (tag (* x y))))
    (ot/put :div [:scheme-number :scheme-number] (fn [x y] (tag (/ x y))))
    (ot/put :make :scheme-number (fn [x] (tag x)))
    :done))

(defn make-scheme-number
  [n]
  ((ot/get :make :scheme-number) n))
