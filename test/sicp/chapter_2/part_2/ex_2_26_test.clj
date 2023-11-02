(ns sicp.chapter-2.part-2.ex-2-26-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.misc :as m]))

(def x (list 1 2 3))
(def y (list 4 5 6))

(deftest list-test
  (is (= '(1 2 3 4 5 6) (m/append x y)))
  (is (= '((1 2 3) 4 5 6) (cons x y)))
  (is (= '((1 2 3) (4 5 6)) (list x y))))
