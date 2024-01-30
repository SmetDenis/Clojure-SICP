(ns sicp.chapter-2.part-3.ex-2-64-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-3.book-2-3 :as b23]
            [sicp.chapter-2.part-3.ex-2-64 :refer [list->tree]]))

(defn tree-empty [x] (b23/make-tree x '() '()))

(def expected-tree
  (b23/make-tree 5
                 (b23/make-tree 1
                                '()
                                (tree-empty 3))
                 (b23/make-tree 9
                                (tree-empty 7)
                                (tree-empty 11))))

(deftest list->tree-test
  (is (= '(5
            (1
              ()
              (3 () ()))
            (9
              (7 () ())
              (11 () ())))
         expected-tree))
  (is (= expected-tree
         (list->tree '(1 3 5 7 9 11)))))
