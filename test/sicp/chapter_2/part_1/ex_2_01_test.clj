(ns sicp.chapter-2.part-1.ex-2-01-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-1.book-2-1 :as b21]
            [sicp.chapter-2.part-1.ex-2-01 :refer [make-rat-2]]))

(deftest make-rat-2-test
  (is (= [1 1] (make-rat-2 1 1)))
  (is (= [-1 1] (make-rat-2 1 -1)))
  (is (= [-1 1] (make-rat-2 -1 1)))
  (is (= [1 1] (make-rat-2 -1 -1)))

  (is (= [1 2] (make-rat-2 2 4)))
  (is (= [-1 2] (make-rat-2 2 -4)))
  (is (= [-1 2] (make-rat-2 -2 4)))
  (is (= [1 2] (make-rat-2 -2 -4)))

  (is (= "1/2" (b21/print-rat (make-rat-2 2 4))))
  (is (= "-1/2" (b21/print-rat (make-rat-2 2 -4))))
  (is (= "-1/2" (b21/print-rat (make-rat-2 -2 4))))
  (is (= "1/2" (b21/print-rat (make-rat-2 -2 -4)))))

(def neg (make-rat-2 -2 4))
(def pos (make-rat-2 2 4))
(def neg-x2 (make-rat-2 -4 8))
(def pos-x2 (make-rat-2 4 8))

(deftest mul-rat-test
  (is (= [1 4] (b21/mul-rat pos pos)))
  (is (= [-1 4] (b21/mul-rat neg pos)))
  (is (= [-1 4] (b21/mul-rat pos neg)))
  (is (= [1 4] (b21/mul-rat neg neg)))

  (is (= [1 4] (b21/mul-rat pos-x2 pos-x2)))
  (is (= [-1 4] (b21/mul-rat neg-x2 pos-x2)))
  (is (= [-1 4] (b21/mul-rat pos-x2 neg-x2)))
  (is (= [1 4] (b21/mul-rat neg-x2 neg-x2))))
