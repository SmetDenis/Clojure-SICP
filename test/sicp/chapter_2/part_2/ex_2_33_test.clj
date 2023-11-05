(ns sicp.chapter-2.part-2.ex-2-33-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-2.ex-2-33 :refer [my-map my-length my-append]]))

(deftest my-map-test
  (is (= '(1 2 3) (my-map inc '(0 1 2)))))

(deftest my-length-test
  (is (= 3 (my-length '(1 2 3)))))

(deftest my-append-test
  (is (= '(1 2 3 1 2 3) (my-append '(1 2 3) '(1 2 3)))))
