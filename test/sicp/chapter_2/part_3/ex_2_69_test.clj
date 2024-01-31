(ns sicp.chapter-2.part-3.ex-2-69-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-3.book-2-3 :as b23]
            [sicp.chapter-2.part-3.ex-2-68 :refer [encode-symbol]]
            [sicp.chapter-2.part-3.ex-2-69 :refer [generate-huffman-tree]]))

(deftest generate-huffman-tree-test
  (is (= b23/huffman-tree (generate-huffman-tree b23/huffman-pairs))))

(deftest encode-symbol-test
  (is (= b23/huffman-A (encode-symbol :A (generate-huffman-tree b23/huffman-pairs))))
  (is (= b23/huffman-B (encode-symbol :B (generate-huffman-tree b23/huffman-pairs))))
  (is (= b23/huffman-C (encode-symbol :C (generate-huffman-tree b23/huffman-pairs))))
  (is (= b23/huffman-D (encode-symbol :D (generate-huffman-tree b23/huffman-pairs)))))
