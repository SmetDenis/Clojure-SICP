(ns sicp.misc-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.misc :refer [square cube]]))

(deftest square-test
  (is (= 4 (square 2)))
  (is (= 9 (square 3))))

(deftest cube-test
  (is (= 8 (cube 2)))
  (is (= 27 (cube 3)))
  (is (= 64 (cube 4)))
  (is (= 125 (cube 5))))
