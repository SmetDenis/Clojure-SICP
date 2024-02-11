(ns sicp.chapter-2.part-2.ex-2-47)

; Exercise 2.47
;
; Here are two possible constructors for frames:
;
; (define (make-frame origin edge1 edge2)
;   (list origin edge1 edge2))
;
; (define (make-frame origin edge1 edge2)
;   (cons origin (cons edge1 edge2)))
;
; For each constructor supply the appropriate selectors to produce an implementation for frames.

(defn make-frame
  [origin edge1 edge2]
  (list origin edge1 edge2))

(defn make-frame-2
  [origin edge1 edge2]
  (cons origin (cons edge1 edge2)))

(defn origin-frame
  [frame]
  (first frame))

(defn edge1-frame
  [frame]
  (second frame))

(defn edge2-frame
  [frame]
  (nth frame 2))

(defn edge2-frame-2
  [frame]
  (list (nth frame 2) (nth frame 3)))
