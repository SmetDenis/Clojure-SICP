(ns sicp.chapter-2.part-1.ex-2-05-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-1.ex-2-05 :as ex-2-05]))

(deftest pair-test
  (is (= 1 (ex-2-05/car (ex-2-05/pair 1 2))))
  (is (= 2 (ex-2-05/cdr (ex-2-05/pair 1 2))))

  (is (= 2 (ex-2-05/car (ex-2-05/pair 2 3))))
  (is (= 3 (ex-2-05/cdr (ex-2-05/pair 2 3))))

  (is (= 3 (ex-2-05/car (ex-2-05/pair 3 4))))
  (is (= 4 (ex-2-05/cdr (ex-2-05/pair 3 4))))

  (is (= 5 (ex-2-05/car (ex-2-05/pair 5 8))))
  (is (= 8 (ex-2-05/cdr (ex-2-05/pair 5 8)))))
