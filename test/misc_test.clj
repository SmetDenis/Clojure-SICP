(ns misc-test
  (:require [clojure.test :refer [deftest is]]
            [misc :refer [square]]))

(deftest square-test
  (is (= 4 (square 2)))
  (is (= 9 (square 3))))
