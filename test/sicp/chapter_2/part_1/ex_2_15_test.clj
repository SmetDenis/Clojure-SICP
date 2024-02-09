(ns sicp.chapter-2.part-1.ex-2-15-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-1.ex-2-13 :as ex-2-13]
    [sicp.misc :as m]))

; Huge tolerance - ±0.5)
(def a-wide (m/make-interval 1 2))
(def b-wide (m/make-interval 3 4))

; Small tolerance - ±0.0005
(def a-narrow (m/make-interval 1 1.001))
(def b-narrow (m/make-interval 100 100.001))

(deftest a-a-wide-test
  (is (= "[2.0, 0.25] / 1.125±0.875" (m/print-interval (ex-2-13/par1 a-wide a-wide))))
  (is (= "[1.0, 0.5] / 0.75±0.25" (m/print-interval (ex-2-13/par2 a-wide a-wide)))))

(deftest a-b-wide-test
  (is (= "[2.0, 0.5] / 1.25±0.75" (m/print-interval (ex-2-13/par1 b-wide a-wide))))
  (is (= "[1.333, 0.75] / 1.042±0.292" (m/print-interval (ex-2-13/par2 b-wide a-wide)))))

(deftest a-a-narrow-test
  (is (= "[0.501, 0.5] / 0.5±0.001" (m/print-interval (ex-2-13/par1 a-narrow a-narrow))))
  (is (= "[0.5, 0.5] / 0.5±0.0" (m/print-interval (ex-2-13/par2 a-narrow a-narrow)))))

(deftest a-b-narrow-test
  (is (= "[0.991, 0.99] / 0.991±0.001" (m/print-interval (ex-2-13/par1 b-narrow a-narrow))))
  (is (= "[0.991, 0.99] / 0.991±0.0" (m/print-interval (ex-2-13/par2 b-narrow a-narrow)))))
