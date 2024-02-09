(ns sicp.chapter-2.part-2.ex-2-23-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-2.ex-2-23 :refer [for-each]]))

(deftest for-each-test
  (is (= true (for-each #(comment (println %))
                        (list 57 321 88)))))
