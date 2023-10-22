(ns sicp.chapter-1.part-3.ex-1-42-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-1.part-3.ex-1-42 :refer [compose]]
            [sicp.misc :as m]))

(deftest compose-test
  (is (= 49 ((compose m/square inc) 6))))
