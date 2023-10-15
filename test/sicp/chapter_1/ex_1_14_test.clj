(ns sicp.chapter-1.ex-1-14-test
  (:require [clojure.test :refer :all]
            [sicp.chapter-1.ex-1-14 :refer [money-change]]))

(deftest count-change-test
  (is (= 1 (money-change 1)))
  (is (= 4 (money-change 10)))
  (is (= 292 (money-change 100))))