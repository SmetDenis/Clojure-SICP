(ns sicp.chapter-2.part-2.ex-2-45-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-2.ex-2-45 :refer [right-split up-split]]))

; I can't cover it with real unit tests. :(

(deftest up-split-test
  (is (= nil (up-split #() 1))))

(deftest right-split-test
  (is (= nil (right-split #() 1))))
