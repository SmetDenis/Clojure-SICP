(ns sicp.chapter-1.ex-1-18-test
  (:require [clojure.test :refer :all])
  (:require [sicp.chapter-1.ex-1-18 :refer [mult]]))

(deftest mult-test
  (is (= 0 (mult 0 19))))
