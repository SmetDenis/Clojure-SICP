(ns sicp.chapter-2.part-1.ex-2-14-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.misc :as m]))

; Huge tolerance - ±0.5)
(def a-wide (m/make-interval 1 2))
(def b-wide (m/make-interval 3 4))

; Small tolerance - ±0.0005
(def a-narrow (m/make-interval 1 1.001))
(def b-narrow (m/make-interval 100 100.001))

(deftest a-a-wide-test
  (is (= "[2.0, 0.5] / 1.25±0.75" (m/print-interval (m/div-interval a-wide a-wide)))))

(deftest a-b-wide-test
  (is (= "[4.0, 1.5] / 2.75±1.25" (m/print-interval (m/div-interval b-wide a-wide)))))

(deftest a-a-narrow-test
  (is (= "[1.001, 0.999] / 1.0±0.001" (m/print-interval (m/div-interval a-narrow a-narrow)))))

(deftest a-b-narrow-test
  (is (= "[100.001, 99.9] / 99.951±0.05" (m/print-interval (m/div-interval b-narrow a-narrow)))))
