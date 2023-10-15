(ns sicp.chapter-1.ex-1-21-test
  (:require [clojure.test :refer :all])
  (:require [sicp.chapter-1.ex-1-21 :refer [smallest-divisor]]))

(deftest smallest-divisor-test
  (is (= 199 (smallest-divisor 199)))
  (is (= 1999 (smallest-divisor 1999)))
  (is (= 7 (smallest-divisor 19999))))
