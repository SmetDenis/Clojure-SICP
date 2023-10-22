(ns sicp.chapter-1.part-3.ex-1-39-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-1.part-3.ex-1-39 :refer [tan-cf]]))

(def angle (/ Math/PI 3))

(deftest tan-cf-test
  (is (= 1.7320508075688767 (Math/tan angle)))
  (is (= 1.732050807568877 (tan-cf angle 100))))            ; Almost there after 100 iters
