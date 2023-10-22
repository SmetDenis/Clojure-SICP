(ns sicp.chapter-1.part-3.ex-1-46-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-1.part-3.ex-1-46 :refer [sqrt-improved fixed-point-improved]]))

(deftest sqrt-improved-test
  (is (= 1.7321428571428572 (sqrt-improved 3 1.0)))
  (is (= 4.000000636692939 (sqrt-improved 16 1.0)))
  (is (= 8.000001655289593 (sqrt-improved 64 1.0)))
  (is (= 16.00000352670594 (sqrt-improved 256 1.0))))

(deftest fixed-point-improved-test
  (is (= 0.1814333572199292 (fixed-point-improved (fn [x] (Math/sin x)) 1)))
  (is (= 0.7395672022122561 (fixed-point-improved (fn [x] (Math/cos x)) 1)))
  (is (= -0.10103212125727049 (fixed-point-improved (fn [x] (Math/tan x)) 1))))
