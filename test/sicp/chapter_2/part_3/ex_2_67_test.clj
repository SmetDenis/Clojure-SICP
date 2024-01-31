(ns sicp.chapter-2.part-3.ex-2-67-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-3.book-2-3 :as b23]
            [sicp.chapter-2.part-3.ex-2-67 :refer [decode-message]]))

(deftest decode-message-test
  (is (= b23/huffman-message-encoded
         (decode-message b23/huffman-message-decoded b23/huffman-tree))))
