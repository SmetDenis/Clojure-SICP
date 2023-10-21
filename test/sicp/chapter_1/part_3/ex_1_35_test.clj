(ns sicp.chapter-1.part-3.ex-1-35-test
  (:require [clojure.test :refer [deftest is]])
  (:require [sicp.chapter-1.part-3.ex-1-35 :refer [gorlden-ration]]))

(deftest gorlden-ration-test
  (is (= 1.6180327868852458 (gorlden-ration 1)))
  (is (= 1.6180365296803654 (gorlden-ration 0.1)))
  (is (= 1.6180328133318276 (gorlden-ration 0.01)))
  (is (= 1.6180327895683542 (gorlden-ration 0.001)))
  (is (= 1.6180327871539473 (gorlden-ration 0.0001)))
  (is (= 1.6180327869121198 (gorlden-ration 0.00001)))
  (is (= 1.6180327868879334 (gorlden-ration 0.000001)))
  (is (= 1.6180327868855147 (gorlden-ration 0.0000001)))
  (is (= 1.6180327868852729 (gorlden-ration 0.00000001))))
