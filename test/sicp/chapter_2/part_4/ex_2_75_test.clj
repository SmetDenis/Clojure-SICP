(ns sicp.chapter-2.part-4.ex-2-75-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-4.ex-2-75 :refer [make-from-mag-ang]]
    [sicp.misc :as m]))

(def angle-60 (/ Math/PI 3))
(def radius 2.0)
(def x 1.0000000000000002)
(def y 1.7320508075688772)

(deftest make-from-mag-ang-test
  (is (= x ((make-from-mag-ang radius angle-60) :real-part)))
  (is (= y ((make-from-mag-ang radius angle-60) :imag-part)))
  (is (= radius ((make-from-mag-ang radius angle-60) :magnitude)))
  (is (= angle-60 ((make-from-mag-ang radius angle-60) :angle)))
  (is (= true (m/is-exception? ((make-from-mag-ang radius angle-60) :undefined)
                               "Unknown op: MAKE-FROM-REAL-IMAG :undefined"))))
