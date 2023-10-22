(ns sicp.chapter-2.part-1.ex-2-03-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-1.ex-2-02 :as ex-2-02]
            [sicp.chapter-2.part-1.ex-2-03 :as ex-2-03]))

(def seg-width (ex-2-02/make-segment (ex-2-02/make-point 0 0)
                                     (ex-2-02/make-point 5 12)))
(def seg-height (ex-2-02/make-segment (ex-2-02/make-point 1 1)
                                      (ex-2-02/make-point 4 5)))
(def rectangle (ex-2-03/make-rectangle seg-width seg-height))

(deftest length-segment-test
  (is (= 13.0 (ex-2-03/length-segment seg-width)))
  (is (= 5.0 (ex-2-03/length-segment seg-height))))

(deftest make-rectangle-test
  (is (= [seg-width seg-height] (ex-2-03/make-rectangle seg-width seg-height))))

(deftest side-width-rectangle-test
  (is (= seg-width (ex-2-03/side-width-rectangle rectangle))))

(deftest side-height-rectangle-test
  (is (= seg-height (ex-2-03/side-height-rectangle rectangle))))

(deftest area-rectangle-test
  (is (= 65.0 (ex-2-03/area-rectangle rectangle))))

(deftest perimeter-rectangle-test
  (is (= 36.0 (ex-2-03/perimeter-rectangle rectangle))))
