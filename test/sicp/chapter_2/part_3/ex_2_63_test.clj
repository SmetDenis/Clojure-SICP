(ns sicp.chapter-2.part-3.ex-2-63-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-3.book-2-3 :as b23]
    [sicp.chapter-2.part-3.ex-2-63 :refer [tree->list-1 tree->list-2]]))

(defn tree-empty
  [x]
  (b23/make-tree x '() '()))

; (7 (3 (1 () ()) (5 () ())) (9 () (11)))
(def tree1
  (b23/make-tree 7
                 (b23/make-tree 3 (tree-empty 1) (tree-empty 5))
                 (b23/make-tree 9 '() '(11))))

; (3 (1 () ()) (7 (5 () ()) (9 () (11 () ()))))
(def tree2
  (b23/make-tree 3
                 (tree-empty 1)
                 (b23/make-tree 7
                                (tree-empty 5)
                                (b23/make-tree 9 '() (tree-empty 11)))))

; (5 (3 (1 () ()) ()) (9 (7 () ()) (11 () ())))
(def tree3
  (b23/make-tree 5
                 (b23/make-tree 3 (tree-empty 1) '())
                 (b23/make-tree 9 (tree-empty 7) (tree-empty 11))))

(deftest tree->list-1-test
  (is (= '(1 3 5 7 9 11) (tree->list-1 tree1)))
  (is (= '(1 3 5 7 9 11) (tree->list-1 tree2)))
  (is (= '(1 3 5 7 9 11) (tree->list-1 tree3))))

(deftest tree->list-2-test
  (is (= '(1 3 5 7 9 11) (tree->list-2 tree1)))
  (is (= '(1 3 5 7 9 11) (tree->list-2 tree2)))
  (is (= '(1 3 5 7 9 11) (tree->list-2 tree3))))
