(ns sicp.chapter-2.part-2.ex-2-50
  (:require [sicp.chapter-2.part-2.book-2-2 :as b22]
            [sicp.chapter-2.part-2.ex-2-46 :as ex-2-46]))

; Exercise 2.50
;
; Define the transformation flip-horiz, which flips painters horizontally,
; and transformations that rotate painters counterclockwise by 180 degrees and 270 degrees.

(defn flip-horiz [painter]
  (b22/transform-painter painter
                         (ex-2-46/make-vect 1.0 0.0)
                         (ex-2-46/make-vect 0.0 0.0)
                         (ex-2-46/make-vect 1.0 1.0)))

(defn rotate-180-cc [painter]
  (b22/transform-painter painter
                         (ex-2-46/make-vect 1.0 1.0)
                         (ex-2-46/make-vect 1.0 0.0)
                         (ex-2-46/make-vect 0.0 1.0)))

(defn rotate-270-cc [painter]
  (b22/transform-painter painter
                         (ex-2-46/make-vect 0.0 1.0)
                         (ex-2-46/make-vect 1.0 1.0)
                         (ex-2-46/make-vect 0.0 0.0)))
