(ns sicp.chapter-2.part-2.ex-2-43
  (:require
    [sicp.chapter-2.part-2.book-2-2 :as b22]
    [sicp.chapter-2.part-2.ex-2-42 :as ex-2-42]))

; Exercise 2.43
;
; Louis Reasoner is having a terrible time doing Exercise 2.42.
; His queens procedure seems to work, but it runs extremely slowly.
; (Louis never does manage to wait long enough for it to solve even the 6×6 case.)
; When Louis asks Eva Lu Ator for help, she points out that he has interchanged
; the order of the nested mappings in the flatmap, writing it as
;
; (flatmap
;  (lambda (new-row)
;    (map (lambda (rest-of-queens)
;           (adjoin-position
;            new-row k rest-of-queens))
;         (queen-cols (- k 1))))
;  (enumerate-interval 1 board-size))
;
; Explain why this interchange makes the program run slowly.
; Estimate how long it will take Louis’s program to solve the eight-queens puzzle,
; assuming that the program in Exercise 2.42 solves the puzzle in time T.

(defn queens-2-42
  [board-size]
  (letfn [(queen-cols
            [k]
            (if (= 0 k)
              (list nil)
              (filter (fn [positions] (ex-2-42/safe? k positions))
                      (mapcat (fn [rest-of-queens]
                                (map (fn [new-row]
                                       (ex-2-42/adjoin-position new-row k rest-of-queens))
                                     (b22/enumerate-interval 1 board-size)))
                              (queen-cols (- k 1))))))]
    (queen-cols board-size)))

(defn queens-2-43
  [board-size]
  (letfn [(queen-cols
            [k]
            (if (= 0 k)
              (list nil)
              (filter (fn [positions] (ex-2-42/safe? k positions))
                      (mapcat (fn [new-row]
                                ; diff 1
                                (map (fn [rest-of-queens]
                                       ; diff 1
                                       (ex-2-42/adjoin-position new-row k rest-of-queens))
                                     (queen-cols (- k 1)))) ; diff 2
                              (b22/enumerate-interval 1 board-size)))))] ; diff 2
    (queen-cols board-size)))
