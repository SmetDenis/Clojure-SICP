(ns sicp.chapter-2.part-3.ex-2-68-test
  (:require [clojure.test :refer :all]
            [sicp.chapter-2.part-3.book-2-3 :as b23]
            [sicp.chapter-2.part-3.ex-2-68 :refer [encode encode-symbol]]))

(def sample-tree
  (b23/make-code-tree
    (b23/make-leaf :A 4)
    (b23/make-code-tree
      (b23/make-leaf :B 2)
      (b23/make-code-tree
        (b23/make-leaf :D 1)
        (b23/make-leaf :C 1)))))

(deftest encode-symbol-test
  (is (= '(0) (encode-symbol :A sample-tree)))
  (is (= '(1 0) (encode-symbol :B sample-tree)))
  (is (= '(1 1 1) (encode-symbol :C sample-tree)))
  (is (= '(1 1 0) (encode-symbol :D sample-tree))))

(deftest encode-symbol-exception-test
  (is (thrown-with-msg?
        Exception
        #"Symbol not found in tree :Z"
        (encode-symbol :Z sample-tree))))

(deftest encode-exception-test
  (try
    (encode-symbol :Z sample-tree)
    (is false "Exception not thrown")
    (catch Exception e
      (is (= (.getMessage e) "Symbol not found in tree :Z")))))

(deftest encode-test
  (is (= '(0                                                ; A
            1 1 0                                           ; D
            0                                               ; A
            1 0                                             ; B
            1 0                                             ; B
            1 1 1                                           ; C
            0)                                              ; A
         (encode '(:A :D :A :B :B :C :A) sample-tree))))
