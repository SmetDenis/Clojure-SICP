(ns sicp.chapter-2.part-2.book-2-2
  (:require
    [sicp.chapter-1.part-2.book-1-2 :refer [fib]]
    [sicp.chapter-2.part-2.ex-2-46 :as ex-2-46]
    [sicp.chapter-2.part-2.ex-2-47 :as ex-2-47]
    [sicp.chapter-2.part-2.ex-2-48 :as ex-2-48]
    [sicp.misc :as m]))

(comment "2.2 Hierarchical Data and the Closure Property -----------------------------------------")

(comment
  (m/pair (m/pair 1 2) (m/pair 3 4))                        ; [[1 2] [3 4]]
  (m/pair (m/pair 1 (m/pair 2 3)) 4))                       ; [[1 [2 3]] 4]

(comment "2.2.1 Representing Sequences -----------------------------------------------------------")

; Exercises:
; * 2.17
; * 2.18
; * 2.19
; * 2.20
; * 2.21
; * 2.22
; * 2.23

(comment
  (m/pair 1 (m/pair 2 (m/pair 3 (m/pair 4 nil))))           ; [1 [2 [3 [4 nil]]]]
  (list 1 2 3 4)                                            ; (1 2 3 4)
  '(1 2 3 4)                                                ; (1 2 3 4)
  (m/cdr '(1 2 3 4))                                        ; 2
  (m/cdr '(1 (2 (3 4)))))                                   ; (2 (3 4))

(defn list-ref
  [lst index]
  (cond
    (< index 0) nil
    (= index 0) (first lst)
    :else (list-ref (rest lst) (dec index))))

(comment
  (def squares '(1 4 9 16 25))
  (list-ref squares 3))                                     ; 16

(defn length-recursice
  [items]
  (if (m/list-empty? items)
    0
    (+ 1 (length-recursice (m/cdr items)))))

(comment
  (length-recursice (list 1 3 5 7)))                        ; 4

(defn length
  [list]
  (if (seq list)
    (+ 1 (length (rest list)))
    0))

(comment
  (length (list 1 3 5 7)))                                  ; 4

(defn append
  [list1 list2]
  (if (empty? list1)
    (if (empty? list2) '() list2)
    (cons (first list1) (append (rest list1) list2))))

(comment
  (append '(1 4 9 16 25) '(1 3 5 7))                        ; (1 4 9 16 25 1 3 5 7)
  (append '(1 3 5 7) '(1 4 9 16 25)))                       ; (1 3 5 7 1 4 9 16 25)

(defn scale-list
  [items factor]
  (if (m/list-empty? items)
    nil
    (cons (* (m/car items) factor)
          (scale-list (m/cdr items)
                      factor))))

(comment
  (scale-list (list 1 2 3 4 5) 10))                         ; (10 20 30 40 50)

(defn my-map
  [proc items]
  (if (m/list-empty? items)
    nil
    (cons (proc (m/car items))
          (my-map proc (m/cdr items)))))

(comment
  (my-map abs (list -10 2.5 -11.6 17))                      ; (10 2.5 11.6 17)
  (my-map #(* % %) (list 1 2 3 4)))                         ; (1 4 9 16)

(defn scale-list-2
  [items factor]
  (my-map #(* % factor) items))

(comment
  (scale-list-2 (list 1 2 3 4 5) 10))                       ; (10 20 30 40 50)

(comment "2.2.2 Hierarchical Structures ----------------------------------------------------------")

; Exercises:
; * 2.24
; * 2.25
; * 2.26
; * 2.27
; * 2.28
; * 2.29
; * 2.30
; * 2.31
; * 2.32

(defn length-tree
  [tree]
  (reduce (fn [acc _] (inc acc)) 0 tree))

(defn count-leaves
  [tree]
  (cond
    (number? tree) 1
    (or (empty? tree) (nil? tree)) 0
    :else (+ (count-leaves (m/car tree))
             (count-leaves (m/cdr tree)))))

(defn scale-tree-v0
  [tree factor]
  (cond (m/list-empty? tree) nil
        (m/leaf? tree) (* tree factor)
        :else (cons (scale-tree-v0 (first tree) factor)
                    (scale-tree-v0 (rest tree) factor))))

(defn scale-tree
  [tree factor]
  (map (fn [sub-tree]
         (if (list? sub-tree)
           (scale-tree sub-tree factor)
           (* sub-tree factor)))
       tree))

(comment "2.2.3 Sequences as Conventional Interfaces ---------------------------------------------")

; Exercises:
; * 2.33
; * 2.34
; * 2.35
; * 2.36
; * 2.37
; * 2.38
; * 2.39
; * 2.40
; * 2.41
; * 2.42
; * 2.43

(defn sum-odd-squares
  [tree]
  (cond (m/list-empty? tree) 0
        (m/leaf? tree) (if (odd? tree) (m/square tree) 0)
        :else (+ (sum-odd-squares (first tree))
                 (sum-odd-squares (rest tree)))))

(defn even-fibs
  [n]
  (letfn [(next
            [k]
            (if (> k n)
              nil
              (let [f (fib k)]
                (if (even? f)
                  (cons f (next (inc k)))
                  (next (inc k))))))]
    (next 0)))

(defn my-filter
  [predicate sequence]
  (cond (m/list-empty? sequence) nil
        (predicate (m/car sequence))
        (cons (m/car sequence)
              (my-filter predicate (m/cdr sequence)))
        :else (my-filter predicate (m/cdr sequence))))

(defn accumulate
  [op initial sequence]
  (if (m/list-empty? sequence)
    initial
    (op (m/car sequence)
        (accumulate op initial (m/cdr sequence)))))

(defn enumerate-interval
  [low high]
  (if (> low high)
    nil
    (cons low (enumerate-interval (+ low 1) high))))

(defn enumerate-tree
  [tree]
  (cond (m/list-empty? tree) nil
        (m/leaf? tree) (list tree)
        :else (m/append (enumerate-tree (m/car tree))
                        (enumerate-tree (m/cdr tree)))))

(defn sum-odd-squares-v2
  [tree]
  (accumulate
    +
    0
    (map m/square
         (filter odd?
                 (enumerate-tree tree)))))

(defn even-fibs-v2
  [n]
  (accumulate
    cons
    nil
    (filter even?
            (map fib
                 (enumerate-interval 0 n)))))

(defn list-fib-squares
  [n]
  (accumulate
    cons
    nil
    (map m/square
         (map fib
              (enumerate-interval 0 n)))))

(defn product-of-squares-of-odd-elements
  [sequence]
  (accumulate
    *
    1
    (map m/square (filter odd? sequence))))

; (defn salary-of-highest-paid-programmer [records]
;   (accumulate
;     max
;     0
;     (map salary
;          (filter programmer? records))))

(comment
  (accumulate append nil
              (map (fn [i]
                     (map (fn [j] (list i j))
                          (enumerate-interval 1 (- i 1))))
                   (enumerate-interval 1 6))))              ; (1 2 3 4 5 6)
; ((2 1) (3 1) (3 2) (4 1) (4 2) (4 3) (5 1) (5 2) (5 3) (5 4) (6 1) (6 2) (6 3) (6 4) (6 5))

(defn flatmap
  [proc seq]
  (accumulate append nil (map proc seq)))

(defn prime-sum?
  [pair]
  (m/prime? (+ (m/car pair) (m/cdr pair))))

(defn make-pair-sum
  [pair]
  (list (m/car pair)
        (m/cdr pair)
        (+ (m/car pair) (m/cdr pair))))

(defn prime-sum-pairs
  [n]
  (map make-pair-sum
       (filter prime-sum? (flatmap
                            (fn [i]
                              (map (fn [j] (list i j))
                                   (enumerate-interval 1 (- i 1))))
                            (enumerate-interval 1 n)))))

(defn my-remove
  [item sequence]
  (filter (fn [x] (not (= x item))) sequence))

(defn permutations
  [s]
  (if (m/list-empty? s)                                     ; empty set?
    (list nil)                                              ; sequence containing empty set
    (flatmap (fn [x]
               (map (fn [p] (cons x p))
                    (permutations (my-remove x s))))
             s)))

(comment "2.2.4 Example: A Picture Language ------------------------------------------------------")

; Exercises:
; * 2.44
; * 2.45
; * 2.46
; * 2.47
; * 2.48
; * 2.49
; * 2.50
; * 2.51
; * 2.52

; The part of book has fake functions
(defn below
  [wave-1 wave-2]
  (comment wave-1 wave-2))

(defn flip-horiz
  [painter]
  (comment painter))

(defn rotate180
  [wave]
  (comment wave))

(defn draw-line
  [param1 param2]
  (comment param1 param2))

(defn frame-coord-map
  [frame]
  (fn [v]
    (ex-2-46/add-vect
      (ex-2-47/origin-frame frame)
      (ex-2-46/add-vect
        (ex-2-46/scale-vect (ex-2-46/xcor-vect v)
                            (ex-2-47/edge1-frame frame))
        (ex-2-46/scale-vect (ex-2-46/ycor-vect v)
                            (ex-2-47/edge2-frame frame))))))

; ((frame-coord-map a-frame) (ex-2-46/make-vect 0 0)) ; (origin-frame a-frame)

(defn segments->painter
  [segment-list]
  (fn [frame]
    (doseq [segment segment-list]
      (let [start               (ex-2-48/start-segment segment)
            end                 (ex-2-48/end-segment segment)
            frame-coord-map-int (frame-coord-map frame)]
        (draw-line (frame-coord-map-int start) (frame-coord-map-int end))))))

(defn transform-painter
  [painter origin corner1 corner2]
  (fn [frame]
    (let [m          (frame-coord-map frame)
          new-origin (m origin)]
      (painter (ex-2-47/make-frame
                 new-origin
                 (ex-2-46/sub-vect (m corner1) new-origin)
                 (ex-2-46/sub-vect (m corner2) new-origin))))))

(defn flip-vert
  [painter]
  (transform-painter
    painter
    (ex-2-46/make-vect 0.0 1.0)                             ; new origin
    (ex-2-46/make-vect 1.0 1.0)                             ; new end of edge1
    (ex-2-46/make-vect 0.0 0.0)))                           ; new end of edge2

(defn rotate90
  [painter]
  (transform-painter painter
                     (ex-2-46/make-vect 1.0 0.0)
                     (ex-2-46/make-vect 1.0 1.0)
                     (ex-2-46/make-vect 0.0 0.0)))

(defn squash-inwards
  [painter]
  (transform-painter painter
                     (ex-2-46/make-vect 0.0 0.0)
                     (ex-2-46/make-vect 0.65 0.35)
                     (ex-2-46/make-vect 0.35 0.65)))

(defn beside
  [painter1 painter2]
  (let [split-point (ex-2-46/make-vect 0.5 0.0)
        paint-left  (transform-painter
                      painter1
                      (ex-2-46/make-vect 0.0 0.0)
                      split-point
                      (ex-2-46/make-vect 0.0 1.0))
        paint-right (transform-painter
                      painter2
                      split-point
                      (ex-2-46/make-vect 1.0 0.0)
                      (ex-2-46/make-vect 0.5 1.0))]
    (fn [frame]
      (paint-left frame)
      (paint-right frame))))

(defn corner-split
  [painter n]
  (if (= n 0)
    painter
    (let [up           (corner-split painter (dec n))
          right        (corner-split painter (dec n))
          top-left     (beside up up)
          bottom-right (below right right)
          corner       (corner-split painter (dec n))]
      (beside (below painter top-left)
              (below bottom-right corner)))))

(defn square-of-four
  [tl tr bl br]
  (fn [painter]
    (let [top    (beside (tl painter) (tr painter))
          bottom (beside (bl painter) (br painter))]
      (below top bottom))))

(defn flipped-pairs
  [painter]
  (let [combine4 (fn [p] ((square-of-four identity flip-vert identity flip-vert) p))]
    (combine4 painter)))

(defn square-limit
  [painter n]
  (let [combine4 (fn [p] ((square-of-four flip-horiz identity rotate180 flip-vert) p))]
    (combine4 (corner-split painter n))))
