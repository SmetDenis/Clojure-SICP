(ns sicp.chapter-2.part-2.ex-2-28-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-2.ex-2-28 :refer [fringe]]))

(def x '((1 2) (3 4)))

(deftest fringe-test
  (is (= '(1 2 3 4) (fringe x)))
  (is (= '(1 2 3 4 1 2 3 4) (fringe (list x x))))
  (is (= '(1 2 3 4 1 2 3 4) (fringe (list x (list x)))))
  (is (= '(1 2 3 4 1 2 3 4) (fringe (list (list x) (list x)))))
  (is (= '(1 2 3 4 1 2 3 4 1 2 3 4) (fringe (list (list x) (list x (list x)))))))
