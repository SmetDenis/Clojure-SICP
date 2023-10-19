(ns sicp.chapter-1.part_2.ex-1-18-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-1.part_2.ex-1-18 :refer [mult]]))

(deftest mult-test
  (is (= 0 (mult 0 19))))
