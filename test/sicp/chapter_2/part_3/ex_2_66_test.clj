(ns sicp.chapter-2.part-3.ex-2-66-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-3.ex-2-64 :refer [list->tree]]
            [sicp.chapter-2.part-3.ex-2-66 :refer [lookup-tree]]))

(def tree (list->tree (range 10)))

(deftest lookup-tree-test
  (is (= false (lookup-tree 1 '())))
  (is (= 1 (lookup-tree 1 tree)))
  (is (= 5 (lookup-tree 5 tree)))
  (is (= false (lookup-tree 10 tree))))
