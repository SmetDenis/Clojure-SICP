(ns sicp.chapter-2.part-2.ex-2-49
  (:require
    [sicp.chapter-2.part-2.book-2-2 :as b22]
    [sicp.chapter-2.part-2.ex-2-46 :as ex-2-46]
    [sicp.chapter-2.part-2.ex-2-48 :as ex-2-48]))

; Exercise 2.49
;
; Use segments->painter to define the following primitive painters:
;
; 1. The painter that draws the outline of the designated frame.
; 2. The painter that draws an “X” by connecting opposite corners of the frame.
; 3. The painter that draws a diamond shape by connecting the midpoints of the sides of the frame.
; 4. The wave painter.

(defn outline-painter
  []
  (b22/segments->painter [(ex-2-48/make-segment (ex-2-46/make-vect 0 0) (ex-2-46/make-vect 1 0))
                          (ex-2-48/make-segment (ex-2-46/make-vect 1 0) (ex-2-46/make-vect 1 1))
                          (ex-2-48/make-segment (ex-2-46/make-vect 1 1) (ex-2-46/make-vect 0 1))
                          (ex-2-48/make-segment (ex-2-46/make-vect 0 1) (ex-2-46/make-vect 0 0))]))

(defn x-painter
  []
  (b22/segments->painter [(ex-2-48/make-segment (ex-2-46/make-vect 0 0) (ex-2-46/make-vect 1 1))
                          (ex-2-48/make-segment (ex-2-46/make-vect 0 1) (ex-2-46/make-vect 1 0))]))

(defn diamond-painter
  []
  (b22/segments->painter [(ex-2-48/make-segment (ex-2-46/make-vect 0.5 0) (ex-2-46/make-vect 1 0.5))
                          (ex-2-48/make-segment (ex-2-46/make-vect 1 0.5) (ex-2-46/make-vect 0.5 1))
                          (ex-2-48/make-segment (ex-2-46/make-vect 0.5 1) (ex-2-46/make-vect 0 0.5))
                          (ex-2-48/make-segment (ex-2-46/make-vect 0 0.5) (ex-2-46/make-vect 0.5 0))]))
