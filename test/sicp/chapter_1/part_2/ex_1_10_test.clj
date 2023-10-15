(ns sicp.chapter-1.part_2.ex-1-10-test
  (:require [clojure.test :refer :all]
            [sicp.chapter-1.part_2.ex-1-10 :refer [A f g h k]]))

(deftest A-test
  (is (= 1024 (A 1 10)))
  (is (= 65536 (A 2 4)))
  (is (= 65536 (A 3 3)))

  (is (= 6 (f 3)))
  (is (= 8 (g 3)))
  (is (= 16 (h 3)))
  (is (= 45 (k 3))))
