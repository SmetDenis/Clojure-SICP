(ns sicp.chapter-2.part-1.ex-2-13-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-1.ex-2-13 :refer [par1 par2]]
            [sicp.misc :as m]))

; Huge tolerance - ±0.5)
(def i-01 (m/make-interval 1 2))
(def i-02 (m/make-interval 3 4))

; Small tolerance - ±0.00005
(def i-11 (m/make-interval 1 1.0001))
(def i-12 (m/make-interval 3 3.0001))

; Let's show huge difference between `par1` and `par2`
(deftest par1-test
  ; To huge difference
  (is (= [0.5 2.0] (par1 i-01 i-02)))
  (is (= [0.75 1.3333333333333333] (par2 i-01 i-02))))

(deftest par2-test
  ; It close to each other only if tolerance is small
  (is (= [0.7499625018749061 0.7501000025000001] (par1 i-11 i-12)))
  (is (= [0.75 0.7500624993750312] (par2 i-11 i-12))))
