(ns sicp.chapter-2.part-2.ex-2-27-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-2.ex-2-27 :refer [deep-reverse]]))

(deftest deep-reverse-test
  (is (= '((4 3) (2 1)) (deep-reverse '((1 2) (3 4)))))
  (is (= '((10 9) (8 7 6 5) (4 3 2 1)) (deep-reverse '((1 2 3 4) (5 6 7 8) (9 10)))))
  (is (= '((10 9) (8 (2 1) 6 5) (4 3 2 1)) (deep-reverse '((1 2 3 4) (5 6 (1 2) 8) (9 10))))))
