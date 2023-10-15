(ns sicp.chapter-1.part_2.ex-1-11-test
  (:require [clojure.test :refer :all]
            [sicp.chapter-1.part_2.ex-1-11 :refer [f f-v2]]))

(deftest f-test
  ; ~ O(3^n)
  (time (is (= (f 1) 1)))                                   ; "Elapsed time: 3.541558 msecs"
  (time (is (= (f 2) 2)))                                   ; "Elapsed time: 2.143086 msecs"
  (time (is (= (f 3) 4)))                                   ; "Elapsed time: 1.413709 msecs"
  (time (is (= (f 4) 11)))                                  ; "Elapsed time: 1.343298 msecs"
  (time (is (= (f 5) 25)))                                  ; "Elapsed time: 1.148649 msecs"
  (time (is (= (f 6) 59)))                                  ; "Elapsed time: 1.667051 msecs"
  (time (is (= (f 7) 142)))                                 ; "Elapsed time: 1.326258 msecs"
  (time (is (= (f 8) 335)))                                 ; "Elapsed time: 1.483437 msecs"
  (time (is (= (f 9) 796)))                                 ; "Elapsed time: 3.40105 msecs"
  (time (is (= (f 10) 1892)))                               ; "Elapsed time: 2.025039 msecs"
  (time (is (= (f 20) 10771211)))                           ; "Elapsed time: 32.969995 msecs
  (time (is (= (f 25) 812934961)))                          ; "Elapsed time: 77.825729 msecs
  (time (is (= (f 30) 61354575194)))                        ; "Elapsed time: 470.359975 msecs"
)

(deftest f-v2-test
  ; ~ O(n)
  (time (is (= (f-v2 1) 1)))                                ; "Elapsed time: 3.209596 msecs"
  (time (is (= (f-v2 2) 2)))                                ; "Elapsed time: 1.38101 msecs"
  (time (is (= (f-v2 3) 4)))                                ; "Elapsed time: 2.122814 msecs"
  (time (is (= (f-v2 4) 11)))                               ; "Elapsed time: 1.531897 msecs"
  (time (is (= (f-v2 5) 25)))                               ; "Elapsed time: 1.403303 msecs"
  (time (is (= (f-v2 6) 59)))                               ; "Elapsed time: 1.383425 msecs"
  (time (is (= (f-v2 7) 142)))                              ; "Elapsed time: 1.335105 msecs"
  (time (is (= (f-v2 8) 335)))                              ; "Elapsed time: 1.88524 msecs"
  (time (is (= (f-v2 9) 796)))                              ; "Elapsed time: 2.091203 msecs"
  (time (is (= (f-v2 10) 1892)))                            ; "Elapsed time: 3.245716 msecs"
  (time (is (= (f-v2 20) 10771211)))                        ; "Elapsed time: 3.275056 msecs"
  (time (is (= (f-v2 25) 812934961)))                       ; "Elapsed time: 1.989168 msecs"
  (time (is (= (f-v2 30) 61354575194)))                     ; "Elapsed time: 2.462203 msecs"
)
