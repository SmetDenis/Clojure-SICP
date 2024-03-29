(ns sicp.chapter-1.part-3.ex-1-29-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-1.part-3.book-1-3 :refer [integral]]
    [sicp.chapter-1.part-3.ex-1-29 :refer [integral-simpson]]
    [sicp.misc :as m]))

(deftest integral-test
  (is (= 1/8 (integral m/cube 0 1 1)))
  (is (= 0.24874999999999994 (integral m/cube 0 1 0.1)))
  (is (= 0.24998750000000042 (integral m/cube 0 1 0.01)))
  (is (= 0.249999875000001 (integral m/cube 0 1 0.001))))   ; Is not 1/4 even after 1000 iterations

(deftest integral-simpson-test
  (is (= 1/3 (integral-simpson m/cube 0 1 1)))
  (is (= 1/4 (integral-simpson m/cube 0 1 10)))             ; We can see the method converges dramaticaly faster
  (is (= 1/4 (integral-simpson m/cube 0 1 100)))
  (is (= 1/4 (integral-simpson m/cube 0 1 1000))))
