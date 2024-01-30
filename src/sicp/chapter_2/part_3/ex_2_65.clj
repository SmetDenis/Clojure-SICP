(ns sicp.chapter-2.part-3.ex-2-65
  (:require [sicp.chapter-2.part-3.book-2-3 :as b23]))

; Exercise 2.65
;
; Use the results of Exercise 2.63 and Exercise 2.64 to give Θ(n)
; implementations of union-set and intersection-set for sets implemented as (balanced) binary trees.

(defn union-set-tree [tree1 tree2]
  (cond
    (empty? tree1) tree2
    (empty? tree2) tree1
    :else (let [tree1-entry        (b23/entry tree1)
                tree1-left-branch  (b23/left-branch tree1)
                tree1-right-branch (b23/right-branch tree1)
                tree2-entry        (b23/entry tree2)
                tree2-left-branch  (b23/left-branch tree2)
                tree2-right-branch (b23/right-branch tree2)]
            (cond
              (= tree1-entry tree2-entry) (b23/make-tree tree1-entry
                                                         (union-set-tree tree1-left-branch tree2-left-branch)
                                                         (union-set-tree tree1-right-branch tree2-right-branch))
              (< tree1-entry tree2-entry) (b23/make-tree tree2-entry
                                                         (union-set-tree tree1 tree2-left-branch)
                                                         tree2-right-branch)
              :else (b23/make-tree tree1-entry
                                   (union-set-tree tree1-left-branch tree2)
                                   tree1-right-branch)))))

(defn intersection-set-tree [tree1 tree2]
  (cond
    (empty? tree1) '()
    (empty? tree2) '()
    :else (let [tree1-entry        (b23/entry tree1)
                tree1-left-branch  (b23/left-branch tree1)
                tree1-right-branch (b23/right-branch tree1)
                tree2-entry        (b23/entry tree2)
                tree2-left-branch  (b23/left-branch tree2)
                tree2-right-branch (b23/right-branch tree2)]
            (cond
              (= tree1-entry tree2-entry)
              (b23/make-tree tree1-entry
                             (intersection-set-tree tree1-left-branch tree2-left-branch)
                             (intersection-set-tree tree1-right-branch tree2-right-branch))
              (< tree1-entry tree2-entry)
              (union-set-tree
                (intersection-set-tree tree1-right-branch
                                       (b23/make-tree tree2-entry '() tree2-right-branch))
                (intersection-set-tree (b23/make-tree tree1-entry tree1-left-branch '())
                                       tree2-left-branch))
              :else (union-set-tree
                      (intersection-set-tree (b23/make-tree tree1-entry '() tree1-right-branch)
                                             tree2-right-branch)
                      (intersection-set-tree tree1-left-branch
                                             (b23/make-tree tree2-entry tree2-left-branch '())))))))
