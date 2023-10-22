(ns sicp.chapter-2.part-1.ex-2-04-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-1.ex-2-04 :as ex-2-04]))

(deftest pair-test
  (is (= 1 (ex-2-04/car (ex-2-04/pair 1 2))))
  (is (= 2 (ex-2-04/cdr (ex-2-04/pair 1 2)))))
