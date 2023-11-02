(ns sicp.chapter-2.part-2.ex-2-24-test
  (:require [clojure.test :refer [deftest is]]))

(deftest list-test
  (is (= '(1 (2 (3 4)))
         (list 1 (list 2 (list 3 4))))))
