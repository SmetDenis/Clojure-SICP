(ns sicp.chapter-2.part-3.ex-2-69-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-3.ex-2-68 :refer [encode-symbol]]
            [sicp.chapter-2.part-3.ex-2-69 :refer [generate-huffman-tree]]))

(def pairs '((:A 4) (:B 2) (:C 1) (:D 1)))

(def expected-tree '[[:leaf :A 4]
                     [[:leaf :B 2]
                      [[:leaf :D 1]
                       [:leaf :C 1]
                       (:D :C) 2]
                      (:B :D :C) 4]
                     (:A :B :D :C) 8])

(deftest generate-huffman-tree-test
  (is (= expected-tree (generate-huffman-tree pairs))))

(deftest encode-symbol-test
  (is (= '(0) (encode-symbol :A (generate-huffman-tree pairs))))
  (is (= '(1 0) (encode-symbol :B (generate-huffman-tree pairs))))
  (is (= '(1 1 1) (encode-symbol :C (generate-huffman-tree pairs))))
  (is (= '(1 1 0) (encode-symbol :D (generate-huffman-tree pairs)))))
