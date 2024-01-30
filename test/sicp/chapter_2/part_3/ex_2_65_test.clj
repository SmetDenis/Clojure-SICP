(ns sicp.chapter-2.part-3.ex-2-65-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-3.ex-2-63 :refer [tree->list-2]]
            [sicp.chapter-2.part-3.ex-2-64 :refer [list->tree]]
            [sicp.chapter-2.part-3.ex-2-65 :refer [intersection-set-tree union-set-tree]]))

(def tree1 (list->tree '(1 2 3)))
(def tree2 (list->tree '(1 2 4)))
(def tree3 (list->tree '(1 4 5)))

(deftest union-set-tree-test
  (is (= '(2
            (1 () ())
            (4
              (3 () ())
              ()))                                          ; Not balanced! It's fine...
         (union-set-tree tree1 tree2)))
  (is (= '(1 2 3 4)
         (tree->list-2 (union-set-tree tree1 tree2))))
  (is (= '(1 2 3 4)
         (tree->list-2 (union-set-tree tree2 tree1))))
  (is (= '(1 2 3 4 5)
         (tree->list-2 (union-set-tree tree1 tree3))))
  (is (= '(1 2 4 4 5)                                       ; Duplicate 4! Hm...?
         (tree->list-2 (union-set-tree tree2 tree3)))))

(deftest intersection-set-tree-test
  (is (= '(2
            (1
              ()
              ())
            ())
         (intersection-set-tree tree1 tree2)))
  (is (= '(1 2) (tree->list-2 (intersection-set-tree tree1 tree2))))
  (is (= '(1) (tree->list-2 (intersection-set-tree tree1 tree3))))
  (is (= '(1 4) (tree->list-2 (intersection-set-tree tree2 tree3)))))
