(ns sicp.chapter-2.part-3.ex-2-54-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-3.ex-2-54 :refer [equal?]]))

(deftest equal?-test
  (is (= true (equal? '(this is a list)
                      '(this is a list))))
  (is (= false (equal? '(this is a list)
                       '(this (is a) list)))))
