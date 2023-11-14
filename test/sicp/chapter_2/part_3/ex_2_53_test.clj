(ns sicp.chapter-2.part-3.ex-2-53-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-3.ex-2-53 :refer [print-vars]]))

(deftest print-vars-test
  (is (= ['(a b c)
          '((george))
          '(y1 y2)
          '(y1 y2)
          false
          false
          '(red shoes blue socks)] (print-vars))))
