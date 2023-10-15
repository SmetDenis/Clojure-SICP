(ns sicp.chapter-1.ex-1-12-test
  (:require [clojure.test :refer :all]
            [sicp.chapter-1.ex-1-12 :refer [pascal]]))

(deftest pascal-test
  (is (= 1 (pascal 1 1)))
  (is (= 1 (pascal 2 1)))
  (is (= 2 (pascal 3 2)))
  (is (= 3 (pascal 4 2)))
  (is (= 6 (pascal 5 3)))
  (is (= 126 (pascal 10 5))))
