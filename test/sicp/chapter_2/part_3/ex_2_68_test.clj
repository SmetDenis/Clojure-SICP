(ns sicp.chapter-2.part-3.ex-2-68-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-3.book-2-3 :as b23]
    [sicp.chapter-2.part-3.ex-2-68 :refer [encode encode-symbol]]
    [sicp.misc :as m]))

(deftest encode-symbol-test
  (is (= b23/huffman-A (encode-symbol :A b23/huffman-tree)))
  (is (= b23/huffman-B (encode-symbol :B b23/huffman-tree)))
  (is (= b23/huffman-C (encode-symbol :C b23/huffman-tree)))
  (is (= b23/huffman-D (encode-symbol :D b23/huffman-tree)))
  (is (= true (m/is-exception? (encode-symbol :Z b23/huffman-tree) "Symbol not found in tree :Z"))))

(deftest encode-test
  (is (= '(0                                                ; A
           1 1 0                                           ; D
           0                                               ; A
           1 0                                             ; B
           1 0                                             ; B
           1 1 1                                           ; C
           0)                                              ; A
         (encode b23/huffman-message-encoded b23/huffman-tree))))
