(ns sicp.chapter-2.part-2.ex-2-29
  (:require
    [sicp.misc :as m]))

; Exercise 2.29
;
; A binary mobile consists of two branches, a left branch and a right branch.
; Each branch is a rod of a certain length, from which hangs either a weight or another binary mobile.
; We can represent a binary mobile using compound data by constructing it
; from two branches (for example, using list):
;
; (define (make-mobile left right)
;   (list left right))
;
; A branch is constructed from a length (which must be a number) together with a structure,
; which may be either a number (representing a simple weight) or another mobile:
;
; (define (make-branch length structure)
;   (list length structure))
;
; 1. Write the corresponding selectors left-branch and right-branch, which return the branches of
; a mobile, and branch-length and branch-structure, which return the components of a branch.
;
; 2. Using your selectors, define a procedure total-weight that returns the total weight of a mobile.
;
; 3. A mobile is said to be balanced if the torque applied by its top-left branch is equal to
; that applied by its top-right branch (that is, if the length of the left rod multiplied by
; the weight hanging from that rod is equal to the corresponding product for the right side)
; and if each of the submobiles hanging off its branches is balanced.
; Design a predicate that tests whether a binary mobile is balanced.
;
; 4. Suppose we change the representation of mobiles so that the constructors are
; (define (make-mobile left right)
;   (cons left right))
;
; (define (make-branch length structure)
;   (cons length structure))
;
; How much do you need to change your programs to convert to the new representation?

; Solution
(defn make-mobile
  [left right]
  (m/pair left right))

(defn make-branch
  [length structure]
  (m/pair length structure))

(defn left-branch
  [mobile]
  (m/car mobile))

(defn right-branch
  [mobile]
  (m/cdr mobile))

(defn branch-length
  [branch]
  (m/car branch))

(defn branch-structure
  [branch]
  (m/cdr branch))

(defn branch-has-structure?
  [branch]
  (m/pair? (branch-structure branch)))

(defn total-weight
  [mobile]
  (cond
    (m/leaf? mobile) 0
    (m/leaf? (branch-structure mobile)) (branch-structure mobile)
    :else (+ (total-weight (left-branch mobile))
             (total-weight (right-branch mobile)))))

(defn branch-moment
  [branch]
  (if (branch-has-structure? branch)
    (* (branch-length branch) (total-weight (branch-structure branch)))
    (* (branch-length branch) (branch-structure branch))))

(defn mobile-balanced?
  [mobile]
  (let [left  (left-branch mobile)
        right (right-branch mobile)]
    (and (= (branch-moment left) (branch-moment right))
         (or (not (branch-has-structure? left))
             (mobile-balanced? (branch-structure left)))
         (or (not (branch-has-structure? right))
             (mobile-balanced? (branch-structure right))))))
