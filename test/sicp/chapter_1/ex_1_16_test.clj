(ns sicp.chapter-1.ex-1-16-test
  (:require [clojure.test :refer :all]
            [sicp.chapter-1.ex-1-16 :refer [expt]]))

(deftest expt-test
  (is (= 1 (expt 1 2)))
  (is (= 3486784401 (expt 3 20))))