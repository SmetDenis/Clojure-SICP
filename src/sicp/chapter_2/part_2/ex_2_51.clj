(ns sicp.chapter-2.part-2.ex-2-51
  (:require
    [sicp.chapter-2.part-2.book-2-2 :as b22]
    [sicp.chapter-2.part-2.ex-2-46 :as ex-2-46]
    [sicp.chapter-2.part-2.ex-2-50 :as ex-2-50]))

; Exercise 2.51
;
; Define the below operation for painters. Below takes two painters as arguments.
; The resulting painter, given a frame, draws with the first painter in the bottom of
; the frame and with the second painter in the top. Define below in two different ways—first by
; writing a procedure that is analogous to the beside procedure given above, and again in terms
; of beside and suitable rotation operations (from Exercise 2.50).

(defn below
  [painter1 painter2]
  (let [split-point  (ex-2-46/make-vect 0.0 0.5)
        paint-bottom (b22/transform-painter painter1
                                            (ex-2-46/make-vect 0.0 0.0)
                                            split-point
                                            (ex-2-46/make-vect 1.0 0.0))
        paint-top    (b22/transform-painter painter2
                                            split-point
                                            (ex-2-46/make-vect 0.0 1.0)
                                            (ex-2-46/make-vect 1.0 1.0))]
    (fn [frame]
      (paint-bottom frame)
      (paint-top frame))))

(defn below-v2
  [painter1 painter2]
  (ex-2-50/rotate-270-cc
    (ex-2-50/rotate-180-cc
      (b22/beside (ex-2-50/rotate-270-cc painter1) (ex-2-50/rotate-270-cc painter2)))))
