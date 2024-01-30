(ns sicp.chapter-2.part-3.ex-2-67-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-3.book-2-3 :as b23]
            [sicp.chapter-2.part-3.ex-2-67 :refer [decode-message]]))

; [[:leaf :A 4] [[:leaf :B 2] [[:leaf :D 1] [:leaf :C 1] (:D :C) 2] (:B :D :C) 4] (:A :B :D :C) 8]
(def sample-tree
  (b23/make-code-tree
    (b23/make-leaf :A 4)
    (b23/make-code-tree
      (b23/make-leaf :B 2)
      (b23/make-code-tree
        (b23/make-leaf :D 1)
        (b23/make-leaf :C 1)))))

(def sample-message '(0 1 1 0 0 1 0 1 0 1 1 1 0))

(deftest decode-message-test
  (is (= '(:A :D :A :B :B :C :A)
         (decode-message sample-message sample-tree))))
