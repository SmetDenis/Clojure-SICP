(ns sicp.chapter-1.part-2.ex-1-11-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-1.part-2.ex-1-11 :refer [f f-v2]]))

(deftest f-test
  ; ~ O(3^n)
  (is (= (f 1) 1))                                          ; "Elapsed time: 3.541558 msecs"
  (is (= (f 2) 2))                                          ; "Elapsed time: 2.143086 msecs"
  (is (= (f 3) 4))                                          ; "Elapsed time: 1.413709 msecs"
  (is (= (f 4) 11))                                         ; "Elapsed time: 1.343298 msecs"
  (is (= (f 5) 25))                                         ; "Elapsed time: 1.148649 msecs"
  (is (= (f 6) 59))                                         ; "Elapsed time: 1.667051 msecs"
  (is (= (f 7) 142))                                        ; "Elapsed time: 1.326258 msecs"
  (is (= (f 8) 335))                                        ; "Elapsed time: 1.483437 msecs"
  (is (= (f 9) 796))                                        ; "Elapsed time: 3.40105 msecs"
  (is (= (f 10) 1892))                                      ; "Elapsed time: 2.025039 msecs"
  (is (= (f 20) 10771211))                                  ; "Elapsed time: 32.969995 msecs
  (is (= (f 25) 812934961))                                 ; "Elapsed time: 77.825729 msecs
  (is (= (f 30) 61354575194))                               ; "Elapsed time: 470.359975 msecs"
)

(deftest f-v2-test
  ; ~ O(n)
  (is (= (f-v2 1) 1))                                       ; "Elapsed time: 3.209596 msecs"
  (is (= (f-v2 2) 2))                                       ; "Elapsed time: 1.38101 msecs"
  (is (= (f-v2 3) 4))                                       ; "Elapsed time: 2.122814 msecs"
  (is (= (f-v2 4) 11))                                      ; "Elapsed time: 1.531897 msecs"
  (is (= (f-v2 5) 25))                                      ; "Elapsed time: 1.403303 msecs"
  (is (= (f-v2 6) 59))                                      ; "Elapsed time: 1.383425 msecs"
  (is (= (f-v2 7) 142))                                     ; "Elapsed time: 1.335105 msecs"
  (is (= (f-v2 8) 335))                                     ; "Elapsed time: 1.88524 msecs"
  (is (= (f-v2 9) 796))                                     ; "Elapsed time: 2.091203 msecs"
  (is (= (f-v2 10) 1892))                                   ; "Elapsed time: 3.245716 msecs"
  (is (= (f-v2 20) 10771211))                               ; "Elapsed time: 3.275056 msecs"
  (is (= (f-v2 25) 812934961))                              ; "Elapsed time: 1.989168 msecs"
  (is (= (f-v2 30) 61354575194))                            ; "Elapsed time: 2.462203 msecs"
)
