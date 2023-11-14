(ns sicp.chapter-2.part-3.book-2-3-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-3.book-2-3 :refer [memq]]))

(comment "2.3")
; Symbolic Data ------------------------------------------------------------------------------------

(deftest memq-test
  (is (= false (memq 'apple '(pear banana prune))))
  (is (= '(pear banana prune) (memq 'pear '(pear banana prune))))
  (is (= '(apple pear) (memq 'apple '(x (apple sauce) y apple pear)))))
