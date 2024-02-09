(ns sicp.chapter-2.part-2.ex-2-52
  (:require
    [sicp.chapter-2.part-2.book-2-2 :as b22]
    [sicp.chapter-2.part-2.ex-2-44 :as ex-2-44]
    [sicp.chapter-2.part-2.ex-2-45 :as ex-2-45]
    [sicp.chapter-2.part-2.ex-2-46 :as ex-2-46]
    [sicp.chapter-2.part-2.ex-2-48 :as ex-2-48]))

; Exercise 2.52
;
; Make changes to the square limit of wave shown in Figure 2.9 by working at each of the levels described above. In particular:
;
; 1. Add some segments to the primitive wave painter of Exercise 2.49 (to add a smile, for example).
;
; 2. Change the pattern constructed by corner-split (for example, by using only one copy of the
; up-split and right-split images instead of two).
;
; 3. Modify the version of square-limit that uses square-of-four so as to assemble the corners
; in a different pattern. (For example, you might make the big Mr. Rogers look
; outward from each corner of the square.)

(defn corner-split
  [painter n]
  (if (zero? n)
    painter
    (let [up           (ex-2-44/up-split painter (dec n))
          right        (ex-2-45/right-split painter (dec n))
          top-left     up
          bottom-right right
          corner       (corner-split painter (dec n))]
      (b22/beside (b22/below painter top-left)
                  (b22/below bottom-right corner)))))

(def krest-segments
  [(ex-2-48/make-segment (ex-2-46/make-vect 0.4 0.2) (ex-2-46/make-vect 0.6 0.2))
   (ex-2-48/make-segment (ex-2-46/make-vect 0.5 0.0) (ex-2-46/make-vect 0.5 1.0))
   (ex-2-48/make-segment (ex-2-46/make-vect 0.3 1.0) (ex-2-46/make-vect 0.7 0.7))
   (ex-2-48/make-segment (ex-2-46/make-vect 0.0 0.4) (ex-2-46/make-vect 1.0 0.4))
   (ex-2-48/make-segment (ex-2-46/make-vect 0.2 0.4) (ex-2-46/make-vect 0.2 0.6))
   (ex-2-48/make-segment (ex-2-46/make-vect 1.0 0.4) (ex-2-46/make-vect 1.0 0.6))
   (ex-2-48/make-segment (ex-2-46/make-vect 0.0 0.6) (ex-2-46/make-vect 0.2 0.6))])
