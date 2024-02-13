(ns sicp.chapter-2.part-5.ex-2-77-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-5.ex-2-77 :refer [fix-complex-nimbers]]))

(deftest fix-complex-nimbers-test
  (is (= 5 (fix-complex-nimbers))))
