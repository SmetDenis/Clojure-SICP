(ns sicp.chapter-1.part-3.ex-1-40-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-1.part-3.book-1-3 :as b13]
            [sicp.chapter-1.part-3.ex-1-40 :refer [cubic]]))

(deftest cubic-test
  (is (= -1.2756822036498454 (b13/newtons-method (cubic 1 2 3) 1))))
